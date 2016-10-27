IFRoutine{
	classvar <>counter2=0, timeCnt=0;
	var <>kTime=1;


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
			this.routines; this.oscMIDI;
			});*/
		}

	}

	*load{
		this.loadRoutPacks;
		this.count;
		this.oscMIDI;


	}

	*loadRoutPacks{

		~blackFade={
			~fadeUp = Pseq((0..127), 124).asStream;
			128.do{
				var cnt;
				~mdOut.control(2, 8, ~fadeUp.next); // Kick Chain

				0.08.wait;
			};
		}.fork;

		~mdOut.noteOn(6,90,127);
		~mdOut.noteOff(6,90,127);
		~extRout = Pbind(
			\chan, 6,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([1/4],4), Pseq([1],2), Pseq([1/2],2)], 1),
			\degree, Pslide([~nt+0,~nt+0,~nt+7,~nt+0,~nt+1,~nt+4],  inf, 4,2,0),
			\amp, Pslide([0.9, 0.5, 0.8, 0.7, 0.9, 0.9], inf, 4,1,0),
			\sustain, Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*1.9,inf, 4,1,0)*~susMulBass,
			\mtranspose, Pseq([~transBassP.next], inf)+~trBass,
			\octave, Pseq([~octBassP.next], inf)+~octMulBass,
			\root, Pseq([~legBassP.next], inf),
			\harmonic, Pseq([~strBassP.next], inf)+~harmBass
		).play;
		~extRout.stop;



	}

	*count {
		1.do{var cnt;
			cnt = cnt + 1;
			counter2.switch(
				2, {
					("            KickCnt"+counter2).postln;
					this.ctl_2;
					counter2 = 0;

				}

			)
		}

	}

	*oscMIDI{


		~phrsExt01osc.free;
		~phrsExt01osc= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			if ( msg[1]==1, {

			~extRout = Pbind(
			\chan, 6,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([1/4],4), Pseq([1],2), Pseq([1/2],2), Pseq([1/8],8)], 1),
			\degree, Pslide([~nt+0,~nt+0,~nt+7,~nt+0,~nt+1,~nt+4],  inf, 4,2,0),
			\amp, Pslide([0.9, 0.5, 0.8, 0.7, 0.9, 0.9], inf, 4,1,0),
			\sustain, Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*0.9,inf, 4,1,0)*~susMulBass,
			\mtranspose, Pseq([~transBassP.next], inf)+~trBass,
			\octave, Pseq([~octBassP.next], inf)+~octMulBass,
			\root, Pseq([~legBassP.next], inf),
			\harmonic, Pseq([~strBassP.next], inf)+~harmBass
		).play;
		~extRout.stop;

			},{~extRout.stop;});



			},
			'/phraseExt01'
		);

	}

}