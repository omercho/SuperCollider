MIDIdef.noteOn(\noteOnPost).free;
MIDIdef.noteOn(\noteOnPost, {
	arg vel, nn, chan, src;
	[chan,nn,vel].postln;
});

(
MIDIdef.noteOn(\noteOnUMA).free;
MIDIdef.noteOn(\noteOnUMA, {
	arg vel, nn, chan, src;
	[nn,vel].postln;
	~notes[nn] = Synth.new(
		\IFSamp_SC,
		[
			\freq, nn.midicps,
			\amp, vel.linexp(1, 127, 0.01,0.3),
			\gate, 1,
			\bend, ~bend.linlin(0, 16383, -2, 2),

		]
	);
});

MIDIdef.noteOff(\noteOffUMA).free;
MIDIdef.noteOff(\noteOffUMA, {
	arg vel, nn, chan, src;
	[nn,vel].postln;
	~notes[nn].set(\gate, 0);
	~notes[nn] = nil;
});

MIDIdef.bend(\bendUMA, {
	arg val, chan, src;
	[chan,val].postln;
	~bend = val;
	~notes.do{arg synth; synth.set(\bend, val.linlin(0, 16383, -2, 2))};
});



~notes = Array.newClear(128);

SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 1.0, freq = 60, freqlp=1250, mul=0.7,
	sin1 = 0.3, sin2 = 1.1, brown = 0.1, saw = 40, pan=0, cut1=0.5, gate=0, bend=0,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.05, dec=0.02, rel = 0.02 |

	var in, osc, env,ses;
	var lfo1, lfo2, decay, den;
	lfo1 = Saw.kr(lfo1Rate).range(1.0, 1.2);
	lfo2 = LFNoise2.kr(lfo2Rate).range(1.0, 2.0);
	den =  LFSaw.ar(freq*lfo2*bend.midiratio, Decay.ar(SinOsc.ar(sin1, sin2), 4.2.abs, Saw.ar(saw)));
	//env =  EnvGen.ar(Env.perc(att, rel), doneAction: 2, levelScale: 0.8, timeScale: sus);
	env = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
	decay = Decay2.ar(
		SinOsc.ar(sin1, sin2),
		LFSaw.ar(sin2, sin1),
		den
	)*lfo1;

	in = LFSaw.ar(LFSaw.ar(freq*bend.midiratio, cut1, brown), 0.3)*0.3**lfo2;
	ses = LFSaw.ar(freq*bend.midiratio, den, brown);
	ses = RLPF.ar(Mix.ar(ses,in), freqlp*bend.midiratio*lfo2, cut1, 0.9, 0.6);
	ses = 0.8*(ses**Saw.ar(freq*bend.midiratio,amp*decay/2));

	ses = DelayC.ar( ses, 0.01, 0.01*lfo2, 4.5.abs, 0.3, ses);
	ses = (Mix.ar(ses*0.3,den*0.4,in*0.2)*amp*env);
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(out, Pan2.ar(ses, pan, mul));
}).add;
)


SynthDef.new(\IFSamp_SC, {
	arg freq=440, amp=0.3, gate=0, bend=0;
	var sig, env;
	sig= LFTri.ar(freq*bend.midiratio)!2;
	env = EnvGen.kr(Env.adsr,gate, doneAction:2);
	sig= sig*env*amp;
	Out.ar(0,sig);
}).add;



SynthDef.new(\IFSamp_SC, {
	arg freq=40, nharm=12, detune=0.2, amp=0.3, gate=0, bend=0, pan=0, out=0;
	var sig, env;
	env = EnvGen.kr(Env.adsr(0.05,0.1,0.5,2), gate, doneAction:2);
	sig= Blip.ar(
		freq*LFNoise1.kr(0.2!16).bipolar(detune.neg, detune).midiratio*(bend.midiratio),
		nharm
	);
	sig= sig*LFNoise1.kr(0.5!16).exprange(0.1,0.2);
	sig= Splay.ar(sig);
	sig= Balance2.ar(sig[0], sig[1], pan);
	sig= sig*env*amp;
	Out.ar(out,sig);
}).add;



