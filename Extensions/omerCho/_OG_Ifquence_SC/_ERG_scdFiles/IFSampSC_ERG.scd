SynthDef( \IFSamp_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
			sin1 = 0.2, sin2 = 0.4, brown = 0.1, saw = 4, pan=0, cut1=0.5, cut2=1, gate=1,
			lfo1Rate=0.1, lfo2Rate=0.22,
			att = 0.1, susLev = 0.1, dec=0.02, rel = 0.02,
			rate = 0.2, rate2 = 1.2, startPos = 0, loop = 1, stretch = 0.05|

			var osc, osc2, osc3, ses;
			var env, env1, env2, env3;
			var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
			var lfo1, lfo2, lfo3, decay,imp;

			var mix, chain, buf, filt, freqRate, freqBuf, freqOsc;
			startPos = startPos * BufFrames.kr(bufnum);
			freqBuf = freq;
			freqBuf = freqBuf.ratiomidi;
			freqBuf = freqBuf.midicps/rootFreq;
			freqOsc = freq;
			//freqRate = freqRate.keyToDegree();
			//freqRate = freqRate.midiratio;

			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
			lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

			env =  EnvGen.ar(Env.adsr(att, dec+0.1, susLev, rel), gate, -2, doneAction:2);
			env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
			env2 =  EnvGen.ar(Env.new([0,1,susLev,0.3,0],[0.1,0.3,0.8,0.1],[-6,-9,-5,-2]), gate);
			env3 =  EnvGen.ar(Env.new([0,susLev*0.6,0.2,0],[att*0.5,0.1*dec,rel+0.01],[-7,-4,-2]), gate);

			osc = SinOsc.ar(LFSaw.kr(lfo1Rate*0.05, 0, freqOsc, freqOsc*2), 0)*0.4;
	        osc2 = SinOsc.ar(LFSaw.kr(lfo1Rate*0.6, 0, freqOsc, freqOsc*4), 0)*0.1;
	        osc3 = SinOsc.ar(SinOsc.kr(lfo1Rate*0.9, 0, freqOsc/8, freqOsc/2), 0)*0.2;
			buf = PlayBuf.ar(1, bufnum, rate:freqBuf, startPos: startPos, loop:0)*1.9;
			filt= MoogFF.ar(
				(1*osc2)+(osc*0.1*osc2),
				//12220,
				cut1*(lfo1)*2,
				1
			);
			mix = Mix.ar(osc3)+Mix.ar(osc2)+Mix.ar(filt);
			Out.ar(out, Pan2.ar(Mix.ar(mix)*mul*0.5, pan, env)*amp);
		}).add;