SynthDef( \IFSamp_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.05, cut2=1, gate=1,
			lfo1Rate=1, lfo2Rate=2,
			att = 0.1, susLev = 0.1, dec=0.02, rel = 0.02,
			rate = 0.2, rate2 = 0.2,startPos = 0, loop = 1|

			var osc, ses;
			var env, env1, env2, env3;
			var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
			var lfo1, lfo2, lfo3, decay,imp;

			var in, chain, freqRate;
			startPos = startPos * BufFrames.kr(bufnum);
			freq = freq.ratiomidi;
	        freq = freq.midicps/rootFreq;
			//freqRate = freqRate.keyToDegree();
			//freqRate = freqRate.midiratio;

			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
			lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

			env =  EnvGen.ar(Env.adsr(att, dec+0.1, susLev, rel), gate, -2, doneAction:2);
			env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
			env2 =  EnvGen.ar(Env.new([0,1,susLev,0.3,0],[0.1,0.3,0.8,0.1],[-6,-9,-5,-2]), gate);
			env3 =  EnvGen.ar(Env.new([0,susLev*0.6,0.2,0],[att*0.5,0.1*dec,rel+0.01],[-7,-4,-2]), gate);


			in = PlayBuf.ar(1, bufnum, rate:freq, startPos: startPos, loop:1);
			in = in*mul;
			chain = FFT({LocalBuf(2048, 2)}.dup(2), in);
			chain = PV_BrickWall(chain, SinOsc.kr(rate2 *XLine.kr(1,15 * [1, 1.6],rel),Rand(0, pi)););


		Out.ar(out, Pan2.ar(IFFT(chain), pan, env));
}).add;

(
//var samplerEvent = Event.default.put(\freq, { ~midinote.midicps / ~sampleBaseFreq });
Pbind(

	\instrument, \IFSamp_SC,
	\scale, Pfunc({~scl2}, inf),
	\bufnum, Pseq([[~piano01, ~gnB01]], inf),
	\dur, Pseq([Pseq([~dur1SampP.next],1)], 1),
	\degree, Pseq([~nt1SampP.next], 1),
	\sustain, Pseq([~sus1SampP.next],1)*~susMulSamp,
	\mtranspose, Pseq([~transSampP.next], 1)+~trSamp,
	\octave, Pseq([~octSampP.next], 1)+~octMulSamp,
	\rootFreq, ~rootFreqSamp,

	//\group, ~piges,
	//\out, Pseq([0], inf )


).play;
)
