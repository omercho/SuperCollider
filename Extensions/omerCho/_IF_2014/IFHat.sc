
/*

IFHat.times(4);
*/

	IFHat {
	classvar <>counter3=0, timeCnt=0;
	var<>hTime=1;


	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet; this.default; });
		}
	}

	*globals{

		~hatCh=2;
		~hatTimes=1;
		~hatOct=4;
		~hatVolC=1;
	}

	*preSet {

		~md1.control(~hatCh, ~hatVolC, 100); //HatVol
	}

	*default {

		~nt1Hat = PatternProxy( Pseq([0], inf));
		~nt1HatP = Pseq([~nt1Hat], inf).asStream;
		~dur1Hat = PatternProxy( Pseq([1], inf));
		~dur1HatP = Pseq([~dur1Snr], inf).asStream;
		~amp1Hat = PatternProxy( Pseq([1], inf));
		~amp1HatP = Pseq([~amp1Hat], inf).asStream;
		~sus1Hat = PatternProxy( Pseq([1], inf));
		~sus1HatP = Pseq([~sus1Hat], inf).asStream;

	}

	*times { arg hTime;

		{
			~hatTimes =  hTime;
		}.fork;
	}

	*oct { arg hOct;

		{
			~hatOct =  hOct;
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
			\chan, ~hatCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([Pseq([~dur1HatP.next/i],i)]*~durMul, 1),
			\degree, Pseq([~nt1HatP.next], inf),
			\amp, Pseq([~amp1HatP.next], inf),
			\sustain, Pseq([~sus1HatP.next],inf),
			\mtranspose, Pseq([~mTrans], inf),
			\octave, ~hatOct
		).play;

		this.count3;
		this.timesCount;
	}


	//Hat Counter
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
				("        -----------HatTimesCnt"+timeCnt).postln;

				timeCnt=0;
			},

		);

	}

	*count3 {
		1.do{
			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            hatCnt"+counter3).postln;
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

