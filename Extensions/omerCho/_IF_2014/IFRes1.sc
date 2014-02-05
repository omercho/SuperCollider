
/*
IFRes1.times(2);
IFRes1.pat_1;
*/


IFRes1 {
var <>rs1Time = 1;
classvar <>counter3 = 0;


	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet; });
		}
	}

	*globals{

		~res1Ch=11;
		~res1Times=3;
		~octRes1=4;

		~res1Mac1=1; ~res1Mac2=2;
		~res1Mac3=3; ~res1Mac4=4;
		~res1Mac5=5; ~res1Mac6=6;
		~res1Mac7=7; ~res1Mac8=8;
	}

	*times { arg rs1Time;

		{~res1Times = rs1Time;}.fork;
	}

	*preSet{
		~md1.control(~res1Ch, ~res1Mac1, 94); //resonator Note
		~md1.control(~res1Ch, ~res1Mac2, 94); //resonator Decay
		~md1.control(~res1Ch, 3, 68); //resonator Filter freq
		~md1.control(~res1Ch, 4, 100); //resonator Color
		~md1.control(~res1Ch, 5, 120); //resonator Note gain
		~md1.control(~res1Ch, 6, 100); //resonator Width
		~md1.control(~res1Ch, 7, 74); //resonator Gain

	}

	*pat_1 { arg rs1Time;

		Pbind(//resonator note
			\chan, ~res1Ch, \ctlNum, ~res1Mac1,
			\type, \midi, \midicmd, \control, \midiout,~md1,
			\delta, Pseq([~durMul/3], ~res1Times),
			\control, Pseq([~nt1Res1.next, ~nt2Res1.next, ~nt3Res1.next].degreeToKey(~scl2), inf),
			\octave, ~octRes1
		).play;
		this.count3;
	}

	//Res1 Beat Counter
	*count3 {

		counter3 = counter3 + 1;
		counter3.switch(
			3, {
				("            Res1Cnt"+counter3).postln;
				this.ctl_3;
				counter3 = 0;

			}

		)
	}


	*ctl_1 {}

	*ctl_2 {}

	*ctl_3 {
		~res1Mcr2.stop;
		~res1Mcr2={
			var val;
			val = Pslide((30..100).mirror, inf,3,1,0).asStream;
			240.do{
				~md1.control(~res1Ch, ~res1Mac2, val.next);
			(~dur.next*(1/8)).wait;
			}
		}.fork;

	}

	*ctl_9 {}

	*ctl_18 {}
}