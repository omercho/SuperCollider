(
SynthDef(\IFHat_SC, { |outBus=0, amp=0.3, gate=1,
	att =0.01, dec=0.03, sus=0.08, rel=0.09,
	lfo1Rate=1, lfo2Rate=1,
	noose =10, freq = 90, pan = 0, freqpan=0.2 |
	var env1, env2, out, oscs1, noise, in, n2,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 0.99);

	env1 = EnvGen.ar(Env.perc(att, dec));
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	noise = Blip.ar(freq*lfo2)*Blip.ar(freq*env2);
	in = Blip.ar(freq*lfo2, freq*lfo1).softclip(2)+noise;
	noise = HPF.ar(in*noise**lfo2, 1, 0.9, 0.5, noise+in);
	noise = BHiShelf.ar(noise+in, 1, lfo2, -6);
	noise = BHiPass.ar(noise/in, freq*lfo1, 0.5, env2);
	in= MoogFF.ar(noise, in, 1);
	//in = HPF.ar(in, Vibrato.kr(1400.0,1,0.02));

	out = env1*noise**in;
	out = out*env2;
	//out = out.softclip(1);
	out = out * amp;

	Out.ar(outBus, Pan2.ar(out, SinOsc.kr(freqpan).range(-1.0, 1.0), 0.3)*env2);
}).add;

)

(
SynthDef(\IFHat_SC, { |outBus=0, amp=0.3, gate=1,
	att =0.01, dec=0.03, sus=0.08, rel=1.09,
	lfo1Rate=1, lfo2Rate=1,
	noose =10, freq = 90, pan = 0, freqpan=0.2 |
	var env1, env2, out, oscs1, noise, in, n2,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 0.99);

	env1 = EnvGen.ar(Env.perc(att, dec));
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	noise = Blip.ar(freq/lfo1,Blip.ar(freq))+Blip.ar(freq);
	in = Blip.ar(freq*lfo2, freq+noise*2);
	noise = HPF.ar(in*lfo2, 1, 0.9, 0.5, noise+in);
	noise = BHiShelf.ar(noise+in, 1, lfo2, -6);
	noise = BHiPass.ar(noise+in, freq, 0.5, env2);
	in= MoogFF.ar(noise, in*lfo1, 1);
	//in = HPF.ar(in, Vibrato.kr(1400.0,1,0.02));

	out = env1*noise**in;
	//out = out*env2;
	//out = out.softclip(1);
	//out = out * amp;

	Out.ar(outBus, Pan2.ar(out, SinOsc.kr(freqpan).range(-1.0, 1.0), amp)*env2);
}).add;

)


(
SynthDef(\IFHat_SC, { |outBus=0, amp=0.3, gate=1,
	att =0.01, dec=0.03, sus=0.08, rel=1.09,
	lfo1Rate=1, lfo2Rate=1,
	noose =10, freq = 90, pan = 0, freqpan=0.2 |
	var env1, env2, out, oscs1, noise, in, n2,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 0.99);

	env1 = EnvGen.ar(Env.perc(att, dec));
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	noise = Blip.ar(freq/lfo1,Blip.ar(freq))+Blip.ar(freq);
	in = Blip.ar(freq*lfo2, freq+noise*2);
	noise = HPF.ar(in*lfo2, 1, 0.9, 0.5, noise+in);
	noise = BHiShelf.ar(noise+in, 1, lfo2, -6);
	noise = BHiPass.ar(noise+in, freq, 0.5, env2);
	//noise= MoogFF.ar(noise, lfo1*100, 1);
	in = HPF.ar(noise, Vibrato.kr(1400.0,1,0.02));

	//out = env1*noise**in;
	//out = out*env2;
	//out = out.softclip(1);
	//out = out * amp;

	Out.ar(outBus, Pan2.ar(noise*in, SinOsc.kr(freqpan).range(-1.0, 1.0), amp)*env2);
}).add;

)


(
SynthDef(\IFHat_SC, { |outBus=0, amp=0.3, gate=1,
	att =0.01, dec=0.03, sus=0.08, rel=1.09,
	lfo1Rate=1, lfo2Rate=1,
	noose =10, freq = 90, pan = 0, freqpan=0.2 |
	var env1, env2, out, oscs1, noise, in, n2,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 0.99);

	env1 = EnvGen.ar(Env.perc(att, dec));
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	noise = Blip.ar(freq/lfo1,Blip.ar(freq))+Blip.ar(freq);
	in = Blip.ar(freq*lfo2, freq+noise*2);
	noise = HPF.ar(in*lfo2, 1, 0.9, 0.5, noise+in);
	noise = BHiShelf.ar(noise, 1, lfo2, -6);
	noise = BHiPass.ar(noise, freq, 0.5, env2);
	noise= MoogFF.ar(noise+in, freq**lfo1, 2, 0);
	//in = HPF.ar(noise, Vibrato.kr(400.0,1,0.02));

	//out = env1*noise**in;
	//out = out*env2;
	//out = out.softclip(1);
	//out = out * amp;

	Out.ar(outBus, Pan2.ar(noise, SinOsc.kr(freqpan).range(-1.0, 1.0), amp)*env2);
}).add;

)

(
SynthDef(\IFHat_SC, { |outBus=0, amp=0.3, gate=1,
	att =0.01, dec=0.03, sus=0.08, rel=1.09,
	lfo1Rate=1, lfo2Rate=1,
	noose =10, freq = 90, pan = 0, freqpan=0.2 |
	var env1, env2, out, oscs1, noise, in, n2,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 0.99);

	env1 = EnvGen.ar(Env.perc(att, dec));
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	noise = Blip.ar(freq/lfo1,Blip.ar(freq))+Blip.ar(freq);
	in = Blip.ar(freq*lfo2, freq+noise*2);
	noise = HPF.ar(in*lfo2, 1, 0.9, 0.5, noise+in);
	noise = BHiShelf.ar(noise, 1, lfo2, -6);
	noise = BHiPass.ar(noise, freq, 0.5, env2);
	noise= MoogFF.ar(noise+in, freq**lfo1, 2, 0);
	in = HPF.ar(noise, Vibrato.kr(400.0,1,0.02));

	out = env1*noise**in;
	//out = out*env2;
	//out = out.softclip(1);
	//out = out * amp;

	Out.ar(outBus, Pan2.ar(noise, SinOsc.kr(freqpan).range(-1.0, 1.0), amp)*env2);
}).add;

)




(
Pbind(\instrument, \IFHat_SC,
	\octave,Pseq([Pseq([6], 6), Pseq([8], 12)], inf),
	\dur, Pseq([Pseq([1/2], 6), Pseq([1/8], 12)], inf),
	\degree,  Pseq([0, 1, 5, 7, 14], inf),
	\amp, 0.9,

).play;
)






(
SynthDef(\IFHat_SC, { |out=0, amp=0.3, gate=1,
	att =0.001, dec=0.03, susLev=0.08, rel=0.9,
	lfo1Rate=1, lfo2Rate=1,
	noose =10, freq = 90, pan = 0, freqpan=0.2 |
	var env1, env2, ses, oscs1, noise, in, n2,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 0.99);

	env1 = EnvGen.ar(Env.perc(att, dec));
	env2 = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);

	noise = Clip.ar(freq*lfo2)*Blip.ar(freq);
	in = ClipNoise.ar(freq*lfo2, freq*lfo1).softclip(2)+noise;
	noise = HPF.ar(in*noise**lfo2, 1, 0.9, 0.5, noise+in);
	noise = BHiShelf.ar(noise*in, 1, lfo2, -6);
	noise = BHiPass.ar(noise, freq*lfo1, 0.5, env2);
	in= MoogFF.ar(noise, in, 0.2);

	ses = noise**in;
	ses = ses*env2;
	ses = ses.clip2(4);
	ses = ses * amp;

	Out.ar(out, Pan2.ar(ses, SinOsc.kr(freqpan).range(-1.0, 1.0), 0.3)*env2);
}).add;

)

(
SynthDef(\IFHat_SC, { |out=0, amp=0.3, gate=1,
	att =0.001, dec=0.03, susLev=0.0, rel=0.04,
	lfo1Rate=1, lfo2Rate=1,
	noose =10, freq = 90, pan = 0, freqpan=1.2 |
	var env1, env2, ses, oscs1, noise, in, n2,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 0.99);

	env1 = EnvGen.ar(Env.perc(att, dec));
	env2 = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);

	noise = Clip.ar(freq*lfo2)*Blip.ar(freq);
	in = ClipNoise.ar(freq*lfo2, freq*lfo1).softclip(2)+noise;
	noise = HPF.ar(in*noise**lfo2, 1, 0.9, 0.5, noise+in);
	noise = BHiShelf.ar(noise*in, 1, lfo2, -6);
	noise = BHiPass.ar(noise, freq*lfo1, 0.5, env2);
	in= MoogFF.ar(noise, in, 0.2);

	ses = noise/in;
	ses = ses*env2;
	ses = ses.clip2(6);
	ses = ses * amp;

	Out.ar(out, Pan2.ar(ses, SinOsc.kr(freqpan).range(-1.0, 1.0), 0.3)*env2);
}).add;

)

(
SynthDef(\IFHat_SC, { |out=0, amp=0.3, gate=1,
	att =0.001, dec=0.03, susLev=0.0, rel=0.04,
	lfo1Rate=1, lfo2Rate=1,
	noose =10, freq = 90, pan = 0, freqpan=1.2 |
	var env1, env2, ses, oscs1, noise, in, n2,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 0.99);

	env1 = EnvGen.ar(Env.perc(att, dec));
	env2 = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);

	noise = Clip.ar(freq*lfo2)*Blip.ar(freq);
	in = ClipNoise.ar(freq*lfo2, freq*lfo1).softclip(2)+noise;
	noise = HPF.ar(in*noise*lfo2, 1, 0.9, 0.5, noise+in);
	noise = BHiShelf.ar(noise*in, 1, lfo2, -6);
	noise = BHiPass.ar(noise, freq*lfo1, 0.5, env2);
	in= MoogFF.ar(noise, in, 0.2);

	ses = Mix.ar(noise,in);
	ses = ses*env2;
	ses = ses.clip2(1);
	ses = ses * amp;

	Out.ar(out, Pan2.ar(ses, SinOsc.kr(freqpan).range(-1.0, 1.0), 0.3)*env2);
}).add;

)
(
SynthDef(\IFHat_SC, { |out=0, amp=0.3, gate=1,
	att =0.01, dec=0.03, susLev=0.08, rel=0.04,
	lfo1Rate=1, lfo2Rate=1,
	noose =10, freq = 90, pan = 0, freqpan=0.2 |
	var env1, env2, ses, oscs1, noise, in, n2,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 1.9);

	env1 = EnvGen.ar(Env.perc(att, dec));
	env2 = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);

	noise = Blip.ar(freq*lfo2)*Blip.ar(freq);
	in = Blip.ar(freq*lfo2, freq*lfo1).softclip(2)+noise;
	noise = HPF.ar(in*noise**lfo2, 1, 0.9, 0.5, noise+in);
	noise = BHiShelf.ar(Mix.ar(noise,in), 1, lfo2, -6);
	noise = BHiPass.ar(noise/in, freq*lfo1, 0.5, env2);
	in= MoogFF.ar(noise, in, 0.2);

	ses = noise**in;
	ses = ses*env2;
	ses = ses.clip2(2);
	ses = ses * amp;

	Out.ar(out, Pan2.ar(ses, SinOsc.kr(freqpan).range(-1.0, 1.0), 0.3)*env2);
}).add;

)

(
SynthDef(\IFHat_SC, { |out=0, amp=0.3, gate=1,
	att =0.01, dec=0.03, susLev=0.08, rel=0.04,
	lfo1Rate=1, lfo2Rate=1,
	noose =10, freq = 90, pan = 0, freqpan=0.2 |
	var env1, env2, ses, oscs1, noise, in, n2,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 1.9);

	env1 = EnvGen.ar(Env.perc(att, dec));
	env2 = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);

	noise = Blip.ar(freq*lfo2)*Blip.ar(freq);
	in = Blip.ar(freq*lfo2, freq*lfo1).softclip(2)+noise;
	noise = HPF.ar(in*noise*lfo2, 0, 0.9, 0.5, Mix.ar(noise,in));
	noise = BHiShelf.ar(Mix.ar(noise,in), 1, lfo2, -6);
	noise = BHiPass.ar(noise/in, freq*lfo1, 0.5, env2);
	in= MoogFF.ar(noise, in, 0.2);

	ses = noise**in;
	ses = ses*env2;
	ses = ses.clip2(2);
	ses = ses * amp;

	Out.ar(out, Pan2.ar(ses, SinOsc.kr(freqpan).range(-1.0, 1.0), 0.3)*env2);
}).add;

)

(
SynthDef(\IFHat_SC, { |out=0, amp=0.3, gate=1,
	att =0.01, dec=0.03, susLev=0.08, rel=0.04,
	lfo1Rate=1, lfo2Rate=1,
	noose =10, freq = 90, pan = 0, freqpan=0.2 |
	var env1, env2, ses, oscs1, noise, in, n2,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 1.9);

	env1 = EnvGen.ar(Env.perc(att, dec));
	env2 = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);

	noise = SinOsc.ar(freq*lfo2);
	in = Mix.ar(Blip.ar(freq*lfo2, freq*lfo1).softclip(2),noise);
	noise = HPF.ar(in*noise*lfo2, 0, 0.9, 0.5, Mix.ar(noise*in));
	//noise = BHiShelf.ar(Mix.ar(noise,in), 1, lfo2, -6);
	noise = BHiPass.ar(noise/in, freq*lfo1, 0.5, env2);
	in= MoogFF.ar(noise, in, 0.2);

	ses = noise**in;
	ses = ses*env2;
	ses = ses.clip2(0.2);
	ses = ses * amp;

	Out.ar(out, Pan2.ar(ses, SinOsc.kr(freqpan).range(-1.0, 1.0), 0.3)*env2);
}).add;

)