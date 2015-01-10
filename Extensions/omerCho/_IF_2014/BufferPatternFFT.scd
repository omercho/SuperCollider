(
SynthDef(\fftgrain, { |out, bufnum, sustain = 1, rate = 0.2, rate2 = 0.2,startPos = 0, amp = 1.0,
				gate = 1, att = 0.1, dec = 1.1, sus = 1, rls = 0.2,
				pan = 0, wid = 2, loop = 0|
	var env, in, chain;
	startPos = startPos * BufFrames.kr(bufnum);

	env = EnvGen.ar(Env.adsr(att, dec, sus, rls, 1, -1), gate, doneAction: 2);

	in = PlayBuf.ar(1, bufnum, BufRateScale.kr(bufnum)*rate, startPos: startPos, loop:1);
	chain = FFT({LocalBuf(2048, 2)}.dup(2), in);
	chain = PV_BrickWall(
		chain,
		SinOsc.kr(
			rate2 *
			XLine.kr(
				1,
				15 * [1, 1.6],
				sustain
			),
			Rand(0, pi)
		);
	);
	Out.ar(out, IFFT(chain) * XLine.kr(2, 0.001, sustain, doneAction: 2)) // inverse FFT
}).add;
)

(
SynthDef(\fftgrain, { |out, bufnum, freq=440, rate = 0.2, rate2 = 0.2,startPos = 0, amp = 1.0, mul=1.9,
				gate = 1, att = 0.1, dec = 1.1, sus = 1, rls = 0.2,
				pan = 0, loop = 1|
	var env, in, chain, freqRate;
	startPos = startPos * BufFrames.kr(bufnum);
	freqRate = freq.cpsmidi;
	freqRate = freqRate.midiratio;

	env = EnvGen.ar(Env.adsr(att, dec, sus, rls, 1, -2), gate, doneAction: 2);

	in = PlayBuf.ar(1, bufnum, BufRateScale.kr(bufnum)*freqRate, startPos: startPos, loop:1);
	in = in*mul;
	chain = FFT({LocalBuf(2048, 2)}.dup(2), in);
	chain = PV_BrickWall(chain, SinOsc.kr(rate2 *XLine.kr(1,15 * [1, 1.6],sus),Rand(0, pi)););
	Out.ar(out, IFFT(chain) * env) // inverse FFT
}).add;
)
(
		SynthDef( \fftgrain, { |out, bufnum amp = 0.9, susLev = 0.1, freq = 1, freqlp=1250, mul=2.4,
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=1.0, cut1=0.05, cut2=1, gate=1,
			lfo1Rate=1, lfo2Rate=2,
			att = 0.1, dec=0.02, rel = 0.02,
			rate = 0.2, rate2 = 0.2,startPos = 0, loop = 1|

			var osc, ses;
			var env, env1, env2, env3;
			var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
			var lfo1, lfo2, lfo3, decay,imp;

			var in, chain, freqRate;
			startPos = startPos * BufFrames.kr(bufnum);
			freqRate = freq.cpsmidi;
			freqRate = freqRate.midiratio;


			env =  EnvGen.ar(Env.adsr(att, dec+0.1, susLev, rel), gate, -2, doneAction:2);
			env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
			env2 =  EnvGen.ar(Env.new([0,1,susLev,0.3,0],[0.1,0.3,0.8,0.1],[-6,-9,-5,-2]), gate);
			env3 =  EnvGen.ar(Env.new([0,susLev*0.6,0.2,0],[att*0.5,0.1*dec,rel+0.01],[-7,-4,-2]), gate);



			in = PlayBuf.ar(1, bufnum, BufRateScale.kr(bufnum)*freqRate, startPos: startPos, loop:1);
			in = in*mul;
			chain = FFT({LocalBuf(2048, 2)}.dup(3), in);
			chain = PV_BrickWall(chain, SinOsc.kr(rate2 *XLine.kr(1/16,8 * [1, 1.6],dec),Rand(0, pi)););


		Out.ar(out, Pan2.ar(IFFT(chain), pan, env));
}).add;
)


Pdef(\fft01).play;
Pdef(\fft01).stop;


(
Pdef(\fft01, Pbind(
	\instrument, \fftgrain,
	\bufnum, Pseq([~gnB01], inf),
	\octave, -1,
	\degree, Pseq((-7..7).mirror2, inf),
	\amp, Pseq([0.9].mirror2,inf),
	\sustain, Pseq([1, 0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2].mirror2, inf)*2,
	\rate2, Pseq([4, 5, 3, 6, 2, 1], inf),
	\legato, Pseq([3.5], inf),
	\dur, Pseq([1, 0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2].mirror2, inf)
));
)

(
Pdef(\fft01, Pbind(
	\instrument, \fftgrain,
	\bufnum, Pseq([~gnB01], inf),
	\octave, 5,
	\degree, Pseq([10], inf).midiratio,
	\rate2, Pseq([4, 5, 3, 6, 2, 1], inf),
	\legato, Pseq([3.5], inf),
	\dur, Pseries(0.1, 1, inf)*Pseq([1, 0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2].mirror2, 1)
));
)


//
(
Pdef(\fft01, Pbind(
	\instrument, \fftgrain,
	\bufnum, Pseq([~gnB01], inf),
	\rate, Pseq([0.5], inf),
	\rate2, Pseq([4, 5, 3, 6, 2, 1], inf),
	\legato, Pseq([3.5], inf),
	\dur, Pseries(0.1, 1, inf)*Pseq([1, 0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2].mirror2, 1)
));
)


(
Pdef(\fft01, Pbind(
	\instrument, \fftgrain,
	\bufnum, Pseq([~gnB01], inf),
	\rate, Pseq([1], inf),
	\rate2, Pseq([4, 5, 3, 6, 2, 1], inf),
	\legato, Pseq([5.5], inf),
	\dur, Pseq([1, 0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2, 3]*0.2, 1)
));
)

(
Pdef(\fft01, Pbind(
	\instrument, \fftgrain,
	\bufnum, Pseq([~gnB01], inf),
	\rate, Pseq([0.5], inf),
	\rate2, Pseq([4, 5, 3, 6, 2, 1], inf),
	\sustain, 0.04,
	\legato, Pseq([3.5], inf),
	\dur, Pseries(0.1, 1, inf)*Pseq([1, 0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2].mirror2, 1)
));
)


(
// WAIT for "done recording" message before doing this
var    ~samplerEvent = Event.default.put(\freq, { ~midinote.midicps / ~sampleBaseFreq });

TempoClock.default.tempo = 1;
p = Pbind(
    \degree, Pwhite(0, 12, inf),
    \dur, Pwrand([0.25, Pn(0.125, 2)], #[0.8, 0.2], inf),
    \amp, Pexprand(0.1, 0.5, inf),
    \sampleBaseFreq, 440,
    \instrument, \sampler,
    \bufnum, b
).play(protoEvent: ~samplerEvent);
)