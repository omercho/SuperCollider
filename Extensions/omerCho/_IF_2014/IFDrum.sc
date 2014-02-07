
/*

IFDrum.times(4,5,4);
*/

	IFDrum {
	classvar <>counter3=0, timeCnt=0;
	var <>kTime=1, <>sTime=1, <>hTime=1;


	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet; });
		}
	}

	*globals{

		~kickCh=0; ~snrCh=1; ~hatCh=2;
		~kickTimes=1; ~snrTimes=1; ~hatTimes=1;
		~kickOct=4; ~snrOct=4; ~hatOct=4;

		~drumVolC=0; ~kickVolC=1; ~snrVolC=1; ~hatVolC=1;
	}

	*preSet {
		~md1.control(~kickCh, ~drumVolC, 100); //Drum Channel Master Volume
		~md1.control(~kickCh, ~kickVolC, 100); //KickVol
		~md1.control(~snrCh, ~snrVolC, 100); //SnareVol
		~md1.control(~hatCh, ~hatVolC, 100); //HatVol
	}

	*times { arg kTime, sTime, hTime;

		{
			~kickTimes = kTime;
			~snrTimes =  sTime;
			~hatTimes =  hTime;
		}.fork;
	}

	*oct { arg kOct, sOct, hOct;

		{
			~kickOct = kOct;
			~snrOct =  sOct;
			~hatOct =  hOct;
		}.fork;
	}

	*pat_1 {

		Pbind(
			\chan, ~kickCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~durMul/2], ~kickTimes),
			\degree, Pseq([~nt1Kick.next], inf),
			\amp, Pseq([~amp1Kick.next, ~amp2Kick.next, ~amp3Kick.next], inf),
			\sustain, Pseq([~sus1Kick.next],inf),
			\mtranspose, Pseq([~mTrans], inf),
			\octave, ~kickOct
		).play;

		Pbind(
			\chan, ~snrCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~durMul/2], ~snrTimes),
			\degree, Pseq([~nt1Snr.next, ~nt2Snr.next, ~nt3Snr.next], inf),
			\amp, Pseq([~amp1Snr.next, ~amp2Snr.next, ~amp3Snr.next], inf),
			\sustain, Pseq([~sus1Snr.next],inf),
			\mtranspose, Pseq([~mTrans], inf),
			\octave, ~snrOct
		).play;


		Pbind(
			\chan, ~hatCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~durMul/2], ~hatTimes),
			\degree, Pseq([~nt1Hat.next, ~nt2Hat.next, ~nt3Hat.next], inf),
			\amp, Pseq([~amp1Hat.next, ~amp2Hat.next, ~amp3Hat.next], inf),
			\sustain, Pseq([~sus1Hat.next],inf),
			\mtranspose, Pseq([~mTrans], inf),
			\octave, ~hatOct
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
				("        -----------DrumTimesCnt"+timeCnt).postln;

				timeCnt=0;
			},

		);

	}

	*count3 {
		1.do{
			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            DrumCnt"+counter3).postln;
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

