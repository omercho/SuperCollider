SynthDef( \IFSamp_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
	sin1 = 0.2, sin2 = 0.4, brown = 0.1, saw = 4, pan=0, cut1=0.5, cut2=1, gate=1,
	lfo1Rate=0.4, lfo2Rate=0.22,

	att = 0.1, susLev = 0.1, dec=0.02, rel = 0.02,
	rate = 0.2, rate2 = 1.2, startPos = 0, loop = 1, stretch = 0.05,
	freq1 = 60, freq2= 153, freq3= 203, freq4= 418,
	ffreq = 1.2, depth = 0.02,
	lagup=0.2, lagdown=0.2|

	var osc, osc2, osc3;
	var env, env1, env2, env3;
	var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
	var lfo1, lfo2, lfo3, decay,imp;

	var ipenv, mulenv, ses, lfo;
	var freqa, freqb, freqc, freqd;

	var mix, chain, buf, filt, freqRate, freqBuf, freqOsc;

	freq1=freq1+freq/2;
	freq2=freq2+freq/2;
	freq3=freq3+freq/2;
	freq4=freq4+freq/2;

	freqa = freq1.rrand(freq, freq+0.01)+freq;
	freqb = freq2.rrand(freq, freq+0.2)+freq/2;
	freqc = freq3.rrand(freq, freq+0.02)+freq/2;
	freqd = freq4.rrand(freq, freq+0.01)+freq/4;

	startPos = startPos * BufFrames.kr(bufnum);
	freqBuf = freq;
	freqBuf = freqBuf.ratiomidi;
	freqBuf = freqBuf.midicps/rootFreq;
	freqOsc = freq;
	//freqRate = freqRate.keyToDegree();
	//freqRate = freqRate.midiratio;
	lfo = LFNoise1.kr(rate, depth * ffreq, ffreq);
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
	lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

	env =  EnvGen.ar(Env.adsr(att, dec+0.1, susLev, rel), gate, -2, doneAction:2);
	env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*lfo2,0.1],[-6,-2,-5]), gate);
	env2 =  EnvGen.ar(Env.new([0,1,susLev,0.3,0],[0.1,0.3,0.8,0.1],[-6,-9,-5,-2]), gate);
	env3 =  EnvGen.ar(Env.new([0,susLev*0.6,0.2,0],[att*0.5,0.1*dec,rel+0.01],[-7,-4,-2]), gate);
	ipenv = EnvGen.kr( Env.adsr(att, dec+lfo2, susLev, rel),  gate );
	mulenv = EnvGen.kr(Env.adsr(0.02, 0.3, 0.7.rrand(0.1, 2.1), 1.5),gate );

	osc = Blip.ar(freq, ipenv*lfo2,env)*0.4;
	osc2 = Blip.ar(
		Lag2UD.kr( // lag the frequency
					[freqa, freqb].sin,
					lagup,
					lagdown
				), mulenv*lfo2,mulenv)*0.4;
	buf = PlayBuf.ar(1, bufnum, rate:freqBuf, startPos: startPos, loop:0)*0.6;


	ses = Blip.ar(
				Lag2UD.kr( // lag the frequency
			([freqa, freqb, freqc, freqd]),
					lagup,
					lagdown
				),
				ipenv*1.4,
				0.2,
				mul: mulenv*0.9
			)*0.9;
	filt= MoogFF.ar(
		(osc2+osc+ses),
		//12220,
		freq*lfo,
		0.8*ipenv
	)*1.0;
	mix=ses+filt;
	//mix = filt+AllpassN.ar(mix, 0.02, filt*0.0002, env);

	mix=Pan2.ar(mix, pan,amp );
	Out.ar(out, mix*env);
}).add;