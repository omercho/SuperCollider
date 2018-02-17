
(
SynthDef(\FMSynth, { | bufnum,

	att = 0.005, dec = 0.3, susLev = 0.4, rel = 0.15, amp = 1, fb = 0 , gate = 0.0,

	attM = 0.005, decM = 0.3, susLevM = 0.4, relM = 0.15, ampM = 1, fbM = 0, freqM = 1, gateM = 0.0

	lfoFreq = 1, lfoAmp = 1, lfo_mix = 0,

	extMod = 0, curSwitch = 1, modSwitch = 1,

	timeScale = 1
	|

	var sourceCur, sourceMod, envelopeCur, envelopeMod, lfo1, mixlfo;

	lfo1 = SinOsc.kr(lfoFreq, 0, lfoAmp)/*.range(-10, 10)*/;

	envelopeCur = EnvGen.ar(Env.adsr( att, dec, susLev, rel, curve: \amp_c.kr([1, 1])),
							gate: gate,
							levelScale: Latch.kr(gate, gate),
							timeScale: Latch.kr(timeScale, gate),
		                    doneAction: 2
							);

	envelopeMod = EnvGen.ar(Env.adsr( attM, decM, susLevM, relM, peakLevel: 1, curve: \amp_c.kr([1, 1])),
							gate: gateM,
		                    levelScale: Latch.kr(gateM,gateM),
//							timeScale: 1,
                    		doneAction: 0
							);

	sourceMod = SinOscFB.ar(freqM, fbM, ampM * envelopeMod) * modSwitch  /*.abs*/;

	sourceCur = Osc.ar(bufnum,

		EnvGen.ar( Env(

			\freq_l.kr([2960, 70, 90]),
			\freq_d.kr([0.07, 0.2]),
			\freq_c.kr([-13, -1]),

		) ) + sourceMod + extMod, fb,

		amp * envelopeCur * curSwitch

		);

	mixlfo = XFade2.ar(sourceCur, sourceCur*lfo1, lfo_mix, 1);

	Out.ar([0, 1], mixlfo)

}).add;
)

(
x = Synth(\FMSynth, [\gate, vel/127, \gateM, vel/100,

						\bufnum, ~waveTableCur_Buffer,
						\freq_l, [note.midicps*~bendRatioMul, note.midicps, note.midicps]*~midiTranspose1/2,
						\freq_d, [~freqDur1, ~freqDur2],
			            \freq_c, [-5, -1],    //default [0, -1]
						\att, ~att,
						\dec, ~dec,
						\susLev, ~susLev,
						\rel, ~rel,
						\fb, ~fb,
						\amp, ~amp,
						\curSwitch, ~curSwitch,
			            \timeScale, 1, //24.midicps/note.midicps

			           /////////Modulator Conntrols

						\freqM, note.midicps*~freqMMul,
						\attM, ~attM,
						\decM, ~decM,
						\susLevM, ~susLevM,
						\relM, ~relM,
						\fbM, ~fbM,
						\ampM, ~ampM,
						\modSwitch, ~modSwitch,

						/////////Lfo Conntrols

						\lfoFreq, 1,
						\lfoAmp, 1,
						\lfo_mix, -1

					])
)