(
//1
SynthDef(\IFSnr_SC, {|att =0.01, dec=0.3, sus=0.8, rel=0.9, mul = 0.8, pan = 0.9,
	wnoise=0.2, gate=1,
	out = 0, amp = 1, freq = 100, decaytime = 0.7, bpfilter = 18900|

	var env0, env1, env2, env1m, oscs, noise, ses;

	env0 = EnvGen.ar(Env.new([0.5, 1, 0.5, 0], [0.005, 0.03, 0.10], [-4, -2, -4]));
	env1 = EnvGen.ar(Env.new([110, 60, 49], [0.005, 0.1], [-4, -5]));
	env1m = env1.midicps;
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	oscs = LFPulse.ar(env1m, 0, 0.5, 1, -0.5) + LFPulse.ar(env1m * 1.6, 0, 0.5, 0.5, -0.25);
	oscs = LPF.ar(oscs, env1m*1.2, env0);
	oscs = oscs * SinOsc.ar(env1m, 0.8, env0);

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
SynthDef(\IFSnr_SC, {|
	att =0.01, dec=0.3, sus=0.8, rel=0.9, mul = 0.8, pan = 0.9,
	wnoise=0.2, gate=1,
	out = 0, amp = 1, freq = 100, decaytime = 0.7, bpfilter = 5900|

	var env0, env1, env2, env1m, oscs, noise, ses;

	env0 = EnvGen.ar(Env.new([0.0, 1, 0.4, 0], [att, sus, 0.10], [-4, -2, -4]));
	env1 = EnvGen.ar(Env.new([freq, 60, 49], [att, sus], [-4, -5]));
	env1m = env1.midicps;
	env2 = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	oscs = Mix.ar(LFPulse.ar(freq*env1m, 0, 0.5, 1, -0.5) + LFPulse.ar(env1m * 1.2, 0, 0.5, 0.5, -0.25))*env2;
	oscs = LPF.ar(oscs, env1m, env0);
	oscs = Mix.ar(oscs , SinOsc.ar(freq, 0.8, env0)*env2);
	oscs = oscs;

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
SynthDef(\IFKick_SC, {| att =0.01, dec=0.0, susLev=1.2, rel=0.09, mul = 0.9,
	gate=1, wnoise=2.8,
	amp=0.5,out=0, freq=110, freq2=59, freq3=29, pan = 0 |

	var env, env1, env1m, ses;
	env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
	env1 = EnvGen.ar(Env.new([freq, freq2, freq3], [0.005, 0.29], [-4, -5]));
	env1m = env1.midicps;

	ses = LFPulse.ar(env1m, 0, 0.5, env, -0.5);
	ses = (ses + WhiteNoise.ar(wnoise))*env;
	ses = LPF.ar(ses, env1m, env);
	ses = ses + SinOsc.ar(env1m, 0.5, env);
	ses = ses.clip2(2);
	ses = ses * mul;
	Out.ar(out, Pan2.ar(ses, pan, mul*1.1));
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

(
SynthDef(\IFSnr_SC, {|
	att =0.01, dec=0.3, sustain=0.1,susLev=0.8, rel=0.9, mul = 0.8, pan = 0.0,
	wnoise=0.2, gate=1,
	lfo1Rate=1, lfo2Rate=1,
	out = 0, amp = 1, freq = 100, decayTime = 0.7, bpfilter = 1900|

	var env0, env1, env2, env1m, oscs, noise, ses,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 1.9);

	env0 = EnvGen.ar(Env.new([0.0, dec, susLev, 0], [att, sustain, rel], [-4, -2, -4], 1), gate, doneAction:2);
	env1 = EnvGen.ar(Env.new([freq*lfo2, 160, 140], [att, susLev], [-4, -5]));
	env1m = env1.midicps;
	env2 = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);

	oscs = Mix.ar(
		LFSaw.ar(env1m*lfo2, 0.6, 0.5, 0.3, -0.5),
		SyncSaw.ar(env1m * lfo1, 0.9, 0.5, 0.3, -0.25)
	);
	oscs = BPF.ar(oscs, 3*env1*lfo1, env2);
	oscs = Mix.ar(oscs , FSinOsc.ar(env1m, 0.8, env2));
	oscs = oscs * env2;

	noise = WhiteNoise.ar(wnoise);
	noise = BPF.ar(noise, freq*lfo2, 1);
	noise = BPF.ar(noise, 2*freq, 0.6, 3) * noise;
	//noise = noise * env2;

	ses = Mix.ar(oscs,noise);
	ses = ses.clip2(0.4);
	ses = Ringz.ar(ses, freq, dec, ses*lfo2);

	Out.ar(out, Pan2.ar(ses, pan, amp*0.2)*mul)*env2;
}).add;
)

(
SynthDef(\IFSnr_SC, {|
	att =0.01, dec=0.03, sustain=0.01,susLev=0.0, rel=0.09, mul = 0.9, pan = 0.0,
	wnoise=0.2, gate=1,
	lfo1Rate=1, lfo2Rate=1,
	out = 0, amp = 1, freq = 100, decayTime = 0.7, bpfilter = 1900|

	var env0, env1, env2, env1m, oscs, noise, ses,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 1.9);

	env0 = EnvGen.ar(Env.new([0.0, dec, susLev, 0], [att, sustain, rel], [-4, -2, -4], 1), gate, doneAction:2);
	env1 = EnvGen.ar(Env.new([freq, freq*0.2, freq*0.4], [att, susLev], [-4, -5]));
	env1m = env1.midicps;
	env2 = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);

	oscs = Mix.ar(
		LFTri.ar(env1m*lfo2, 0.6, 0.5, 0.3, 0.0)*0.5,
		LFTri.ar(env1 *lfo1, 0.9, 0.5, 0.3, -0.0)*1.2
	);
	oscs = BPF.ar(oscs, 2*env1*lfo1, env2);
	oscs = Mix.ar(oscs , FSinOsc.ar(env1, 0.8, env2));
	oscs = oscs * env2;

	noise = WhiteNoise.ar(wnoise);
	noise = BPF.ar(noise, freq, lfo2-0.9);
	noise = BPF.ar(noise, 2*freq, 0.6) * noise;
	//noise = noise * env2;

	ses = Mix.ar(oscs*1.2,noise*0.5);
	ses = ses.clip2(0.4);
	ses = Ringz.ar(ses, freq, dec, ses*lfo2);

	Out.ar(out, Pan2.ar(ses, pan, amp*0.2)*mul)*env2;
}).add;
)

(
SynthDef(\IFSnr_SC, {|
	att =0.01, dec=0.03, sustain=0.01,susLev=0.0, rel=0.09, mul = 0.9, pan = 0.0,
	wnoise=0.2, gate=1,
	lfo1Rate=1, lfo2Rate=1,
	out = 0, amp = 1, freq = 100, decayTime = 0.7, bpfilter = 1900|

	var env0, env1, env2, env1m, oscs, noise, ses,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 1.9);

	env0 = EnvGen.ar(Env.new([0.0, dec, susLev, 0], [att, sustain, rel], [-4, -2, -4], 1), gate, doneAction:2);
	env1 = EnvGen.ar(Env.new([freq, freq*0.2, freq*0.4], [att, susLev], [-4, -5]));
	env1m = env1.midicps;
	env2 = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);

	oscs = Mix.ar(
		LFTri.ar(env1m*lfo2, lfo2-0.9, 0.5, 0.3, 0.0)*0.5,
		LFTri.ar(env1, 0.9, 0.5, 0.3, -0.0)*1.2
	);
	oscs = BPF.ar(oscs, 2*env1*lfo1, env2);
	oscs = Mix.ar(oscs , FSinOsc.ar(env1, 0.8, env2));

	noise = WhiteNoise.ar(wnoise);
	noise = BPF.ar(noise, freq, lfo2-0.9);
	noise = BPF.ar(noise, 2*freq, 0.6) * noise;
	//noise = noise * env2;

	ses = Mix.ar(oscs*1.2,noise*0.5);
	ses = ses.clip2(0.4);
	ses = Ringz.ar(ses, freq, dec, ses*lfo2);

	Out.ar(out, Pan2.ar(ses, pan, amp*0.2)*mul)*env2;
}).add;



)

(
SynthDef(\IFSnr_SC, {| att =0.01, sustain=0.1, dec=0.0, susLev=1.2, rel=0.09, mul = 0.9,
	gate=1, wnoise=2.8,
	lfo1Rate=1, lfo2Rate=1,
	amp=0.9,out=0, freq=110, freq2=69, freq3=49, pan = 0 |

	var env, env1, env1m, ses,lfo1, lfo2;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 1.9);
	env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
	env1 = EnvGen.ar(Env.new([freq, freq2, freq3], [0.005, sustain], [-4, -5]));
	env1m = env1.midicps;

	ses = SinOsc.ar(env1m*(-1),lfo2-0.9);
	ses = Mix.ar(ses*0.02,WhiteNoise.ar(wnoise));
	ses = HPF.ar(ses, env1m, env);
	ses = ses + SinOsc.ar(env1m, 0.5, env);
	ses = ses.clip2(0.2+wnoise);
	ses = ses * mul;
	Out.ar(out, Pan2.ar(ses, pan, amp*1.1)*env);
}).add;

)