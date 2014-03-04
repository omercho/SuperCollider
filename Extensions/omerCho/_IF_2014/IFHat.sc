
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
		~transHat=0;
		~stretchHat=0;
		~legHat=0;
		~octHat=4;
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
			~octHat =  hOct;
		}.fork;
	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				/*
				~nt1HatP.next;
				~dur1HatP.next;
				~amp1HatP.next;
				~sus1HatP.next;
				~nt1HatSon=~nt1HatP;
				~dur1HatSon=~dur1HatP;
				~amp1HatSon=~amp1HatP;
				~sus1HatSon=~sus1HatP;
				~nt1HatSon.value;
				~dur1HatSon.value;
				~amp1HatSon.value;
				~sus1HatSon.value;*/

				this.p1(val);

				~durMul*((~dur1HatP.value)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~hatCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([Pseq([~dur1HatP.next/val],1)], 1),
			\degree, Pseq([~nt1HatP.next], 1),
			\amp, Pseq([~amp1HatP.next], 1),
			\sustain, Pseq([~sus1HatP.next],1),
			\mtranspose, Pseq([~transHat], 1),
			\octave, ~octHat,
			\legato, ~legHat,
			\stretch, ~stretchHat
		).play;

		//this.count2;
		//this.timesCount;
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

