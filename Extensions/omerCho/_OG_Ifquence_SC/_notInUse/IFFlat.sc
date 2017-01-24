
/*

IFFlat.times(6);
IFFlat.pat_1;

*/

IFFlat{

	var <>fltTime = 1;

	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet; });
		}
	}

	*globals{

		~flatCh=7;
		~flatTimes=1;
		~octFlat=5;
		~flatMac1=1; ~flatMac2=2; ~flatMac3=3; ~flatMac4=4; ~flatMac5=5; ~flatMac6=6; ~flatMac7=7; ~flatMac8=8;
	}

	*preSet{}

	*times { arg fltTime;

		{
			~flatTimes = fltTime;
		}.fork;
	}
	*pat_1 {

		Pbind(
			\type, \midi, \chan, ~flatCh, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~durMul/3], ~flatTimes),
			\degree, Pseq([~nt1Flat.next, ~nt2Flat.next, ~nt3Flat.next], inf),
			\amp, Pseq([~amp1Flat.next, ~amp2Flat.next, ~amp3Flat.next], inf),
			\sustain, Pseq([~sus1Flat.next, ~sus2Flat.next, ~sus3Flat.next], inf),
			\mtranspose, Pseq([~mTrans], inf),
			\octave, ~octFlat
		).play;

	}

	*ctl_1 {


	}

	*ctl_3 {


	}
	*ctl_9 {

		Pbind(
			\chan, ~flatCh, \ctlNum, ~flatMac1,
			\type, \midi, \midicmd, \control, \midiout,~md1,
			\delta, Pseq([~durMul/2], ~flatTimes/2),
			\control, Pbrown(17,30, 1, inf)
		).play;

	}

	*ctl_18 {
		~flatMcr2.stop;
		~flatMcr2={
			var val;
			val = Pbrown(37,90, 1, inf).asStream;
			8.do{
				~md1.control(~flatCh, ~flatMac2, val.next);
			(~dur.next*(1/6)).wait;
			}
		}.fork;

	}

}

