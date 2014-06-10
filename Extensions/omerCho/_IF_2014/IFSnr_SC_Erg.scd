(//1
SynthDef(\IFSnr_SC, {|
	att =0.01, dec=0.3, sus=0.8, rel=0.9, mul = 0.8, pan = 0.9,
	wnoise=0.2, gate=1,
	out = 0, amp = 1, freq = 100, decaytime = 0.7, bpfilter = 18900|

	var env0, env1, env2, env1m, oscs, noise, ses;

	env0 = EnvGen.ar(Env.new([0.5, 1, 0.5, 0], [0.005, 0.03, 0.10], [-4, -2, -4]));
	env1 = EnvGen.ar(Env.new([110, 60, 49], [0.005, 0.1], [-4, -5]));
	env1m = env1.midicps;
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	oscs = LFPulse.ar(env1m, 0, 0.5, 1, -0.5) + LFPulse.ar(env1m * 1.6, 0, 0.5, 0.5, -0.25);
	oscs = LPF.ar(oscs, env1m*1.2, env0);
	oscs = oscs  SinOsc.ar(env1m, 0.8, env0);

	noise = WhiteNoise.ar(wnoise);
	noise = BPF.ar(noise, freq, 2);
	noise = BPF.ar(noise, bpfilter, 0.6, 4) + noise;
	noise = noise * env2;

	ses = oscs + noise;
	ses = ses.clip2(2) * amp;
	ses = Ringz.ar(ses, (freq*env1)/4, decaytime);

	Out.ar(out, Pan2.ar(ses, pan)*amp);
}).add;
)

(
//2
SynthDef(\IFSnr_SC, {|
	att =0.01, dec=0.3, sus=0.8, rel=0.9, mul = 0.8, pan = 0.9,
	wnoise=0.2, gate=1,
	out = 0, amp = 1, freq = 100, decaytime = 0.7, bpfilter = 18900|

	var env0, env1, env2, env1m, oscs, noise, ses;

	env0 = EnvGen.ar(Env.new([0.5, 1, 0.5, 0], [0.005, 0.03, 0.10], [-4, -2, -4]));
	env1 = EnvGen.ar(Env.new([110, 60, 49], [0.005, 0.1], [-4, -5]));
	env1m = env1.midicps;
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	oscs = LFPulse.ar(env1m, 0, 0.5, 1, -0.5) - LFPulse.ar(env1m * 1.6, 0, 0.5, 0.5, -0.25);
	oscs = HPF.ar(oscs, env1m*1.2, env2);
	oscs = oscs + SinOsc.ar(env1m, 0.2, env2);

	noise = WhiteNoise.ar(wnoise);
	noise = HPF.ar(noise, freq, 1);
	noise = BPF.ar(noise, bpfilter, 0.6) ** noise;
	noise = noise * env2;

	ses = oscs * noise;
	ses = ses.clip2(2) * amp;
	ses = Ringz.ar(ses, (freq/env1m)/1, dec);

	Out.ar(out, Pan2.ar(ses, pan)*amp);
}).add;
)

(
SynthDef(\IFSnr_SC, {|
	att =0.01, dec=0.3, sus=0.8, rel=0.9, mul = 0.8, pan = 0.9,
	wnoise=0.2, gate=1,
	out = 0, amp = 1, freq = 100, decaytime = 0.7, bpfilter = 8900|

	var env0, env1, env2, env1m, oscs, noise, ses;

	env0 = EnvGen.ar(Env.new([0.5, 1, 0.5, 0], [0.005, 0.03, 0.10], [-4, -2, -4]));
	env1 = EnvGen.ar(Env.new([110, 60, 49], [0.005, 0.1], [-4, -5]));
	env1m = env1.midicps;
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	oscs = LFPulse.ar(env1m, 0, 0.5, 1, -0.5) + LFPulse.ar(env1m * 1.6, 0, 0.5, 0.5, -0.25);
	oscs = LPF.ar(oscs, env1m*1.2, env0);
	oscs = oscs + SinOsc.ar(env1m, 0.8, env0);

	noise = WhiteNoise.ar(wnoise);
	noise = HPF.ar(noise, 100, 2);
	noise = BPF.ar(noise, bpfilter, 0.6, 4) + noise;
	noise = noise * env2;

	ses = oscs + noise;
	ses = ses.clip2(1) * amp;
	ses = Ringz.ar(ses, freq, decaytime);

	Out.ar(out, Pan2.ar(ses, pan)*amp);
}).add;
)

(
SynthDef(\IFSnr_SC, {|
	att =0.01, dec=0.3, sus=0.8, rel=0.9, mul = 0.8, pan = 0.9,
	wnoise=0.2, gate=1,
	out = 0, amp = 1, freq = 100, decaytime = 0.7, bpfilter = 5900|

	var env0, env1, env2, env1m, oscs, noise, ses;

	env0 = EnvGen.ar(Env.new([0.0, 1, 0.4, 0], [att, 0.03, 0.10], [-4, -2, -4]));
	env1 = EnvGen.ar(Env.new([110, 60, 49], [att, rel], [-4, -5]));
	env1m = env1.midicps;
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	oscs = LFPulse.ar(env1m, 0, 0.5, 1, -0.5) + LFPulse.ar(env1m * 1.6, 0, 0.5, 0.5, -0.25);
	oscs = LPF.ar(oscs, env1m*1.1, env0);
	oscs = oscs + SinOsc.ar(env1m, 0.8, env0);

	noise = WhiteNoise.ar(wnoise);
	noise = HPF.ar(noise, 100, 2);
	noise = BPF.ar(noise, bpfilter, 0.6, 4) + noise;
	noise = noise * env2;

	ses = oscs + noise;
	ses = ses.clip2(1) * amp;
	ses = Ringz.ar(ses, freq, decaytime)*env2;

	Out.ar(out, Pan2.ar(ses, pan, amp)*mul);
}).add;
)

(
SynthDef(\IFSnr_SC, {|
	att =0.01, dec=0.3, sus=0.8, rel=0.9, mul = 0.8, pan = 0.9,
	wnoise=0.2, gate=1,
	out = 0, amp = 1, freq = 100, decaytime = 0.7, bpfilter = 5900|

	var env0, env1, env2, env1m, oscs, noise, ses;

	env0 = EnvGen.ar(Env.new([0.0, 1, 0.4, 0], [att, 0.03, 0.10], [-4, -2, -4]));
	env1 = EnvGen.ar(Env.new([110, 60, 49], [att, rel], [-4, -5]));
	env1m = env1.midicps;
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	oscs = LFPulse.ar(env1m, 0, 0.5, 1, -0.5) + LFPulse.ar(env1m * 1.6, 0, 0.5, 0.5, -0.25);
	oscs = LPF.ar(oscs, env1m*1.2, env0);
	oscs = oscs + SinOsc.ar(env1m, 0.8, env0);

	noise = WhiteNoise.ar(wnoise);
	noise = HPF.ar(noise, 100, 2);
	noise = BPF.ar(noise, bpfilter, 0.6, 4) + noise;
	noise = noise * env2;

	ses = oscs + noise;
	ses = ses.clip2(1) * amp;
	ses = Ringz.ar(ses, freq, decaytime)*env2;

	Out.ar(out, Pan2.ar(ses, pan, amp)*mul);
}).add;
)

(
SynthDef(\IFSnr_SC, {|
	att =0.01, dec=0.3, sus=0.8, rel=0.9, mul = 0.8, pan = 0.9,
	wnoise=0.2, gate=1,
	out = 0, amp = 1, freq = 100, decaytime = 0.7, bpfilter = 5900|

	var env0, env1, env2, env1m, oscs, noise, ses;

	env0 = EnvGen.ar(Env.new([0.0, 1, 0.4, 0], [att, 0.03, 0.10], [-4, -2, -4]));
	env1 = EnvGen.ar(Env.new([110, 60, 49], [att, rel], [-4, -5]));
	env1m = env1.midicps;
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	oscs = LFPulse.ar(env1m, 0, 0.5, 1, -0.5) * LFPulse.ar(env1m * 1.6, 0, 0.5, 0.5, -0.25);
	oscs = LPF.ar(oscs, freq+env1m*1.2, env0);
	oscs = oscs + SinOsc.ar(env1m, 0.8, env0);
	oscs = oscs *env2;

	noise = WhiteNoise.ar(wnoise);
	noise = HPF.ar(noise, 100, 2);
	noise = BPF.ar(noise, bpfilter, 0.6, 4) + noise;
	noise = noise * env2;

	ses = oscs + noise;
	ses = ses.clip2(1) * amp;
	ses = Ringz.ar(ses, freq, decaytime)*env2;

	Out.ar(out, Pan2.ar(ses, pan, amp)*mul);
}).add;
)

(
SynthDef(\IFSnr_SC, {|
	att =0.01, dec=0.3, sus=0.8, rel=0.9, mul = 0.8, pan = 0.9,
	wnoise=0.2, gate=1,
	out = 0, amp = 1, freq = 100, decaytime = 0.7, bpfilter = 5900|

	var env0, env1, env2, env1m, oscs, noise, ses;

	env0 = EnvGen.ar(Env.new([0.0, 1, 0.4, 0], [att, 0.03, 0.10], [-4, -2, -4]));
	env1 = EnvGen.ar(Env.new([110, 60, 49], [att, rel], [-4, -5]));
	env1m = env1.midicps;
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	oscs = LFPulse.ar(env1m, 0, 0.5, 1, -0.5) + LFPulse.ar(env1m * 1.2, 0, 0.5, 0.5, -0.25)*env2;
	oscs = LPF.ar(oscs, env1m*1.6, env0);
	oscs = oscs + SinOsc.ar(env1m*freq, 0.8, env0);
	oscs = oscs *env2;

	noise = WhiteNoise.ar(wnoise)*env2;
	noise = HPF.ar(noise, 150, 2);
	noise = BPF.ar(noise, bpfilter, 0.6, 4) + noise;
	noise = noise * env2;

	ses = (oscs + noise).clip2;
	ses = ses.clip2(10);
	ses = Ringz.ar(ses, freq, dec)*env2;

	Out.ar(out, Pan2.ar(ses, pan, amp)*mul);
}).add;
)


(
SynthDef(\IFSnr_SC, {|
	att =0.01, dec=0.3, sus=0.8, rel=0.9, mul = 0.8, pan = 0.9,
	wnoise=0.2, gate=1,
	out = 0, amp = 1, freq = 100, decaytime = 0.7, bpfilter = 5900|

	var env0, env1, env2, env1m, oscs, noise, ses;

	env0 = EnvGen.ar(Env.new([0.0, 1, 0.4, 0], [att, sus, 0.10], [-4, -2, -4]));
	env1 = EnvGen.ar(Env.new([110, 60, 49], [att, sus], [-4, -5]));
	env1m = env1.midicps;
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	oscs = LFPulse.ar(freq*env1m, 0, 0.5, 1, -0.5) + LFPulse.ar(env1m * 1.2, 0, 0.5, 0.5, -0.25)*env2;
	oscs = LPF.ar(oscs, env1m*1.6, env0);
	oscs = oscs + SinOsc.ar(env1m*freq, 0.8, env0);
	oscs = oscs *env2;

	noise = WhiteNoise.ar(wnoise)*env2;
	noise = HPF.ar(noise, 150, 2);
	noise = BPF.ar(noise, bpfilter, 0.6, 4) + noise;
	noise = noise * env2;

	ses = (oscs * noise);
	ses = ses.clip2(1);
	ses = Ringz.ar(ses, freq, dec)*env2;

	Out.ar(out, Pan2.ar(ses, pan, amp)*mul);
}).add;
)




(
Pdef(\kar, Pbind(\instrument, \IFSnr_SC,
	\octave,Pseq([Pseq([3], 6), Pseq([5], 12)], inf),
	\dur, Pseq([Pseq([1], 6), Pseq([1/2], 12)], inf),
	\degree,  Pseq([0], inf),
	\amp, 0.9,
	\pan, 0,
	\sus, Pseq([1, 0.1, 0.9, 0.3, 0.2, 0.1, 0.01], inf)*0.2,
	\att, 0.001,
	\dec, 1.304,
	\rel, 0.002,
	\wnoise,Pseq([0.02, 0.01, 0.30], inf),
	)
);
)
Pdef(\kar).play;
Pdef(\kar).stop;