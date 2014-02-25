
/*

IFKick.times(4);
*/

	IFKick {
	classvar <>counter2=0, timeCnt=0;
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
		~dur1Kick = PatternProxy( Pseq([1,1/2], inf));
		~dur1KickP = Pseq([~dur1Kick], inf).asStream;
		~amp1Kick = PatternProxy( Pseq([1], inf));
		~amp1KickP = Pseq([~amp1Kick], inf).asStream;
		~sus1Kick = PatternProxy( Pseq([1], inf));
		~sus1KickP = Pseq([~dur1Kick], inf).asStream;


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

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~nt1KickP.next;
				~dur1KickP.next;
				~amp1KickP.next;
				~sus1KickP.next;
				~nt1KickSon=~nt1KickP;
				~dur1KickSon=~dur1KickP;
				~amp1KickSon=~amp1KickP;
				~sus1KickSon=~sus1KickP;
				this.p1(val);
				~durMul*((~dur1KickSon.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		//~nt1KickSon=~nt1KickP;
		//~dur1KickSon=~dur1KickP;
		Pbind(
			\chan, ~kickCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([Pseq([~sus1KickSon],1)], 1),
			\degree, Pseq([~nt1KickSon], 1),
			\amp, Pseq([~amp1KickSon], 1),
			\sustain, Pseq([~sus1KickSon],1),
			\mtranspose, Pseq([~mTrans], 1),
			\octave, ~kickOct
		).play;


		this.count2;
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

	*count2 {
		1.do{
			counter2 = counter2 + 1;
			counter2.switch(
				2, {
					("            KickCnt"+counter2).postln;
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

