
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
		~transSnr=0;
		~octSnr=3;
		~stretchSnr=0;
		~legSnr=0;
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


	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~nt1SnrP.next;
				~nt1SnrSon=~nt1SnrP;
				~nt1SnrSon.value;

				~dur1SnrP.next;
				~dur1SnrSon=~dur1SnrP;




				~sus1SnrP.next;
				~sus1SnrSon=~sus1SnrP;
				~sus1SnrSon.value;

				~amp1SnrP.next;
				~amp1SnrSon=~amp1SnrP;
				~amp1SnrSon.value;

				this.p1(val);

				~dur1SnrSon.value;
				~durMul*((~dur1SnrSon.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		Pbind(
			\chan, ~snrCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([~dur1SnrSon.value/i],1)], 1),
			\degree, Pseq([~nt1SnrSon.value], 1),
			\amp, Pseq([~amp1SnrSon.value], 1),
			\sustain, Pseq([~sus1SnrSon.value],1),
			\mtranspose, Pseq([~transSnr.value], 1),
			\octave, ~octSnr,
			\legato, ~legSnr,
			\stretch, ~stretchSnr
		).play;

		//this.count2;
		//this.timesCount;
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

