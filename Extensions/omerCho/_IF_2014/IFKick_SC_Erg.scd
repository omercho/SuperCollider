
SynthDef( \lypat01, { | amp = 1, sustain = 1.1, freq = 60, freqlp,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 400,
	attime = 0.01, rlstime = 0.5 |
	var in, osc, env, ses;
	env =  EnvGen.ar(Env.perc(attime, rlstime), doneAction: 2, levelScale: 0.8, timeScale: sustain);
	in = SinOsc.ar(FSinOsc.ar(freq, 0, brown), 0.4);
	ses = SinOsc.ar(0, in, 0.01) ;
	ses = RLPF.ar(ses, freqlp, 1.4, 1.6, 0.4 );
	ses = ses.sin/4 + SinOsc.ar(freqlp, Decay.ar(SinOsc.ar(sin1, sin2), 4.2.abs, Saw.ar(saw)));
	//ses = Limiter.ar(ses, 0.9, 0.01);
	ses = DelayN.ar( ses, 4.5, 0.01, 1.5, 0.0, 2.1, ses);

	Out.ar(0, ses   *amp *env !2);
}).add;

Synth(\lypat01);

SynthDef(\IFKick_SC, {| att =0.01, dec=0.3, sus=0.8, rel=0.9, mul = 0.8,
	gate=1, wnoise=2.8,
	amp=0.5,out=0, freq=110, freq2=59, freq3=29, pan = 0 |

	var env, env1, env1m, ses;
	env =  EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);
	env1 = EnvGen.ar(Env.new([freq, freq2, freq3], [0.005, 0.29], [-4, -5]));
	env1m = env1.midicps;

	ses = LFPulse.ar(env1m, 0, 0.5, 1, -0.5);
	ses = ses + WhiteNoise.ar(wnoise);
	ses = LPF.ar(ses, env1m, env);
	ses = ses + SinOsc.ar(env1m, 0.5, env);
	ses = ses.clip2(1);
	ses = ses * mul;
	Out.ar(out, Pan2.ar(ses, pan)*amp);
}).send(Server.default);

~kick=Synth(\IFKick_SC);

~kick.set(\gate,0);



Pdef(\kar, Pbind(\instrument, \IFKick_SC,
	\octave,3,
	\dur, 1,
	\degree,  Pseq([0, 10, 100], inf).trace,
	\amp, 0.9,
	\pan, 0,
	\sus, 0.0,
	\dec, 0.4,
	\rel, 0.2,
	\wnoise,3
	)
);

Pdef(\kar).play;
Pdef(\kar).stop;


Pbind(\instrument, \IFKick_SC,
	\octave,30,
	\dur, 1,
	\degree,  Pseq([0], 4),
	\amp, 0.9,
	\pan, 0,
	\sus, 0.0,
	\dec, 0.4,
	\rel, 0.2,
	\wnoise,3
).play;