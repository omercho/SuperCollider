PolySynth_1 {

//class methods

	*load {


//Initialize the WaveTable
~waveTableCur_Buffer = Buffer.alloc(Server.default, 512*8, 1);
~waveTableCur_Buffer.sine3((1.0..10), 1.0/(1..10), 0, true, true, true);
~h1 = 1; ~h2 = 1/2; ~h3 = 1/3; ~h4 = 1/4; ~h5 = 1/5; ~h6 = 1/6; ~h7 = 1/7; ~h8 = 1/8; ~h9 = 1/9; ~h10 = 1/10;

SynthDef(\FMSynth, { | bufnum,

	atk = 0.005, dec = 0.3, sus = 0.4, rel = 0.15, amp = 1, fb = 0 , gate = 0.0,

	atkM = 0.005, decM = 0.3, susM = 0.4, relM = 0.15, ampM = 1, fbM = 0, freqM = 1, gateM = 0.0

	lfoFreq = 1, lfoAmp = 1, lfo_mix = 0,

	extMod = 0, curSwitch = 1, modSwitch = 1,

	timeScale = 1
	|

	var sourceCur, sourceMod, envelopeCur, envelopeMod, lfo1, mixlfo;

	lfo1 = SinOsc.kr(lfoFreq, 0, lfoAmp)/*.range(-10, 10)*/;

	envelopeCur = EnvGen.ar(Env.adsr( atk, dec, sus, rel, curve: \amp_c.kr([1, 1])),
							gate: gate,
							levelScale: Latch.kr(gate, gate),
							timeScale: Latch.kr(timeScale, gate),
		                    doneAction: 2
							);

	envelopeMod = EnvGen.ar(Env.adsr( atkM, decM, susM, relM, peakLevel: 1, curve: \amp_c.kr([1, 1])),
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

//:Array

~noteArray = Array.newClear(128);
~bendcount = -1;

~on.remove;
~on = NoteOnResponder({ |src, chan, note, vel|

                 var x;
         	"WaveTable __  1  freq = ".post; (note.midicps*~midiTranspose1/2).postln;
			~waveTableCur_Buffer.sine3((1.0..10),
				[~h1, ~h2, ~h3, ~h4, ~h5, ~h6, ~h7, ~h8, ~h9, ~h10], 0, true, true, true);

                 ~noteArray.put(note,

					x = Synth(\FMSynth, [\gate, vel/127, \gateM, vel/100,

						\bufnum, ~waveTableCur_Buffer,
						\freq_l, [note.midicps*~bendRatioMul, note.midicps, note.midicps]*~midiTranspose1/2,
						\freq_d, [~freqDur1, ~freqDur2],
			            \freq_c, [-5, -1],    //default [0, -1]
						\atk, ~atk,
						\dec, ~dec,
						\sus, ~sus,
						\rel, ~rel,
						\fb, ~fb,
						\amp, ~amp,
						\curSwitch, ~curSwitch,
			            \timeScale, 1, //24.midicps/note.midicps

			           /////////Modulator Conntrols

						\freqM, note.midicps*~freqMMul,
						\atkM, ~atkM,
						\decM, ~decM,
						\susM, ~susM,
						\relM, ~relM,
						\fbM, ~fbM,
						\ampM, ~ampM,
						\modSwitch, ~modSwitch,

						/////////Lfo Conntrols

						\lfoFreq, 1,
						\lfoAmp, 1,
						\lfo_mix, -1

					]));

                 x.map(\extMod, ~mod2To1);

                 ~bendcount = note;
 			});

~off.remove;
~off = NoteOffResponder({ |src,chan,note,vel|
                 ~noteArray[note].set(\gate, 0.0, \gateM, 0.0);

			});


~bend = MIDIIn.bend = { |src,chan,val|

				(val/100).postln;
 				~noteArray.[~bendcount].set(\fb, val/100 );
 			};






	}

}









