
/*
IFBass.times(2);
IFBass.pat_1;

~octBass=4;

*/


IFBass {
var <>basTime = 1;
classvar <>counter3 = 0;


	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet; });
		}
	}

	*globals{

		~bassCh=4;
		~bassTimes=1;
		~octBass=3;
		~bassMac1=1; ~bassMac2=2;
		~bassMac3=3; ~bassMac4=4;
		~bassMac5=5; ~bassMac6=6;
		~bassMac7=7; ~bassMac8=8;
	}

	*preSet{}

	*times { arg basTime;

		{~bassTimes = basTime;}.fork;
	}

	*pat_1 { arg basTime;

		Pbind(
			\type, \midi, \chan, ~bassCh, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~durMul/3], ~bassTimes),
			\degree, Pseq([~nt1Bass.next, ~nt2Bass.next, ~nt3Bass.next], inf),
			\amp, Pseq([~amp1Bass.next, ~amp2Bass.next, ~amp3Bass.next], inf),
			\sustain, Pseq([~sus1Bass.next, ~sus2Bass.next, ~sus3Bass.next], inf),
			\mtranspose, Pseq([~mTrans], inf),
			\octave, ~octBass
		).play;
		this.count3;
	}

	//Bass Beat Counter
	*count3 {
		1.do{
			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            BassCnt"+counter3).postln;
					this.ctl_3;
					counter3 = 0;

				}

			)
		}

	}


	*ctl_1 {


	}

	*ctl_2 {
		("Bass CTL 2").postln;

	}

	*ctl_3 {
		~bassMcr1.stop;
		~bassMcr1={
			var val;
			val = Pslide((30..120).mirror, inf,3,1,0).asStream;
			240.do{
				~md1.control(~bassCh, 0, val.next);
			(~dur.next*(1/8)).wait;
			}
		}.fork;

	}
	*ctl_9 {


	}

	*ctl_18 {


		~bassMcr2.stop;
		~bassMcr2={
			var val;
			val = Pbrown(37,90, 1, inf).asStream;
			8.do{
				~md1.control(~bassCh, ~bassMac2, val.next);
			(~dur.next*(1/6)).wait;
			}
		}.fork;


	}
}