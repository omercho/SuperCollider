
/*

IFSnr.times(4);
*/

	IFSnr {
	classvar <>counter2=0, <>counter3=0, timeCnt=0;
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
		~dur1Snr = PatternProxy( Pseq([1], inf));
		~dur1SnrP = Pseq([~dur1Snr], inf).asStream;
		~amp1Snr = PatternProxy( Pseq([1], inf));
		~amp1SnrP = Pseq([~amp1Snr], inf).asStream;
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

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  { this.p1(val) }

	}

	*p1 {|i=1|

		Pbind(
			\chan, ~snrCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([Pseq([~dur1SnrP.next/i],i)]*~durMul, 1),
			\degree, Pseq([~nt1SnrP.next], inf),
			\amp, Pseq([~amp1SnrP.next], inf),
			\sustain, Pseq([~sus1SnrP.next],inf),
			\mtranspose, Pseq([~mTrans], inf),
			\octave, ~snrOct
		).play;


		this.count2;
		this.timesCount;
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

	*count2 {
		1.do{
			counter2 = counter2 + 1;
			counter2.switch(
				3, {
					("            SnareCnt"+counter2).postln;
					this.ctl_2;
					counter2 = 0;

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

