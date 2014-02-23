
/*

IFSnr.times(4);
*/

	IFSnr {
	classvar <>counter3=0, timeCnt=0;
	var <>sTime=1;


	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet; this.default; });
		}
	}

	*globals{

		~snrCh=1;
		~snrTimes=1;
		~snrOct=4;
		~snrVolC=1;
	}

	*preSet {

		~md1.control(~snrCh, ~snrVolC, 100); //SnareVol

	}



	*default {

		~nt1Snr = PatternProxy( Pseq([0], inf));
		~nt1SnrP = Pseq([~nt1Snr], inf).asStream;
		~nt2Snr = PatternProxy( Pseq([0], inf));
		~nt2SnrP = Pseq([~nt1Snr], inf).asStream;
		~nt3Snr = PatternProxy( Pseq([0], inf));
		~nt3SnrP = Pseq([~nt1Snr], inf).asStream;
		~amp1Snr = PatternProxy( Pseq([1], inf));
		~amp1SnrP = Pseq([~amp1Snr], inf).asStream;
		~amp2Snr = PatternProxy( Pseq([1], inf));
		~amp2SnrP = Pseq([~amp2Snr], inf).asStream;
		~amp3Snr = PatternProxy( Pseq([1], inf));
		~amp3SnrP = Pseq([~amp3Snr], inf).asStream;
		~sus1Snr = PatternProxy( Pseq([1], inf));
		~sus1SnrP = Pseq([~sus1Snr], inf).asStream;

	}

	*times { arg sTime;

		{
			~snrTimes = sTime;

		}.fork;
	}

	*oct { arg sOct;

		{
			~snrOct = sOct;

		}.fork;
	}

	*p1 {|pat1T=1|

		Pbind(
			\chan, ~snrCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([1]*~durMul, pat1T),
			\degree, Pseq([~nt1SnrP.next], inf),
			\amp, Pseq([~amp1SnrP.next], inf),
			\sustain, Pseq([~sus1SnrP.next],inf),
			\mtranspose, Pseq([~mTrans], inf),
			\octave, ~snrOct
		).play;



		this.count3;
		this.timesCount;
	}

	*p4 {|pat4T=1|

		Pbind(
			\chan, ~snrCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([Pseq([1/4],4)]*~durMul, pat4T),
			\degree, Pseq([~nt1SnrP.next], inf),
			\amp, Pseq([~amp1SnrP.next], inf),
			\sustain, Pseq([~sus1SnrP.next],inf),
			\mtranspose, Pseq([~mTrans], inf),
			\octave, ~snrOct
		).play;

	}

	*p8 {|pat8T=1|

		Pbind(
			\chan, ~snrCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([Pseq([1/8],8)]*~durMul, pat8T),
			\degree, Pseq([~nt1SnrP.next], inf),
			\amp, Pseq([~amp1SnrP.next], inf),
			\sustain, Pseq([~sus1SnrP.next],inf),
			\mtranspose, Pseq([~mTrans], inf),
			\octave, ~snrOct
		).play;

	}

	//Snr Beat Counter
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
				("        -----------SnareTimesCnt"+timeCnt).postln;

				timeCnt=0;
			},

		);

	}

	*count3 {
		1.do{
			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            SnareCnt"+counter3).postln;
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

