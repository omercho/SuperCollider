SynthDef( \IFBass_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
	sin1 = 0.2, sin2 = 0.4, brown = 0.1, saw = 4, pan=0, cut1=1.5, cut2=1, gate=1,
	lfo1Rate=0.1, lfo2Rate=0.22,
	att = 0.1, susLev = 0.1, dec=0.02, rel = 0.02,
	rate = 0.2, rate2 = 1.2, startPos = 0, loop = 1, stretch = 0.05,
	cutoff = 850, gain = 0.1, lagamount = 0.01, chorus = 0.7|

	var osc1, osc2, osc3, ses;
	var env, env1, env2, env3;
	var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2,cut;
	var lfo1, lfo2, lfo3, decay,imp;

	var mix, chain, buf, filt, freqRate, freqBuf, freqOsc;

	var osc, filter, filterenv, snd, chorusfx;

	startPos = startPos * BufFrames.kr(bufnum);
	freqBuf = freq;
	freqBuf = freqBuf.ratiomidi;
	freqBuf = freqBuf.midicps/rootFreq;
	freqOsc = freq/2;
	//freqRate = freqRate.keyToDegree();
	//freqRate = freqRate.midiratio;
	cut= cut1.range(50,2000);

	lfo1 = Saw.kr(lfo1Rate).range(1.0, 1.2);
	lfo2 = Saw.kr(lfo2Rate).range(1.0, 2.0);
	lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

	env =  EnvGen.ar(Env.adsr(att+0.01, dec+0.2, susLev*lfo2, rel*0.3), gate, -2, doneAction:2);
	env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
	env2 =  EnvGen.ar(Env.new([0.9,1,susLev,0.0,0],[0.01,0.03,0.1,0.1],[-6,-9,-5,-2]), gate);
	env3 =  EnvGen.ar(Env.new([0,0.9,susLev*0.2,0],[att*0.2,0.1+dec,rel+0.05],[-3,-4,-2]), gate);
	filterenv = EnvGen.ar(
		envelope: Env.adsr(att+0.01, dec+0.2, susLev, rel*0.3),
		gate: gate);

	osc1 = Blip.ar(
		freq: freqOsc.lag(lagamount) ,
		numharm: Rand(2.5,2.75),
		mul: env1);
	osc2 = SyncSaw.ar(freq,freq,0.3);
	osc2 = RLPF.ar(osc2,freqOsc,1.9,1.9);
	osc3 = VarSaw.ar(
		freq: freqOsc.lag(lagamount) * [0.3, 0.901, 2.0],
		iphase: Rand(0.5,0.1) ! 3,
		width: Rand(0.7,0.75) ! 3,
		mul: 0.9);
	buf = PlayBuf.ar(1, bufnum, rate:freqBuf, startPos: startPos, loop:0)*env;

	//moog
	//osc = Mix([osc3*1.5,0.8*osc1+osc3,osc2]);
	osc = Mix([osc3+osc1]);
	filter =  MoogFF.ar(
		in: osc,
		freq: cut * (3.0 + (1.6 * filterenv)),
		gain: gain);
	snd = (0.6 * filter + (0.3 * filter.distort(0.2)));

	mix = Mix(snd)*env;
	Out.ar(out, Pan2.ar(mix*mul, pan)*amp);
}).add;