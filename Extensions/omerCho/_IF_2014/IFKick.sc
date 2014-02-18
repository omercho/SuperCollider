
/*

IFKick.times(4);
*/

	IFKick {
	classvar <>counter3=0, timeCnt=0;
	var <>kTime=1;


	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet; this.default; });
		}
	}

	*globals{

		~kickCh=0;
		~kickTimes=1;
		~kickOct=4;
		~drumVolC=0; ~kickVolC=1;
	}

	*preSet {
		~md1.control(~kickCh, ~drumVolC, 100); //Drum Channel Master Volume
		~md1.control(~kickCh, ~kickVolC, 100); //KickVol

	}

	*default {

		~nt1Kick = PatternProxy( Pseq([0], inf));
		~nt1KickP = Pseq([~nt1Kick], inf).asStream;
		~amp1Kick = PatternProxy( Pseq([1], inf));
		~amp1KickP = Pseq([~amp1Kick], inf).asStream;
		~amp2Kick = PatternProxy( Pseq([1], inf));
		~amp2KickP = Pseq([~amp2Kick], inf).asStream;
		~amp3Kick = PatternProxy( Pseq([1], inf));
		~amp3KickP = Pseq([~amp3Kick], inf).asStream;
		~sus1Kick = PatternProxy( Pseq([1], inf));
		~sus1KickP = Pseq([~sus1Kick], inf).asStream;

	}

	*times { arg kTime;

		{
			~kickTimes = kTime;

		}.fork;
	}

	*oct { arg kOct;

		{
			~kickOct = kOct;

		}.fork;
	}

	*pat_1 {

		Pbind(
			\chan, ~kickCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~durMul/2], ~kickTimes),
			\degree, Pseq([~nt1KickP.next], inf),
			\amp, Pseq([~amp1KickP.next, ~amp2KickP.next, ~amp3KickP.next], inf),
			\sustain, Pseq([~sus1KickP.next],inf),
			\mtranspose, Pseq([~mTrans], inf),
			\octave, ~kickOct
		).play;


		this.count3;
		this.timesCount;
	}

	//Drum Beat Counter
	*timesCount {
		timeCnt = timeCnt + 1;
		timeCnt.switch(

			1, {  },
			4, {  },
			6, {  },
			8, {  },
			9, {  },
			10, {  },
			15, {  },
			17, {  },
			18, {
				("        -----------KickTimesCnt"+timeCnt).postln;

				timeCnt=0;
			},

		);

	}

	*count3 {
		1.do{
			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            KickCnt"+counter3).postln;
					this.ctl_3;
					counter3 = 0;

				}

			)
		}

	}


	*ctl_1 {


	}

	*ctl_2 {


	}

	*ctl_3 {


	}
	*ctl_9 {



	}

	*ctl_18 {



	}

}

