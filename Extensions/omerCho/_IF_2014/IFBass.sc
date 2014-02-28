
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
		Server.default.doWhenBooted({ this.globals; this.preSet; this.default; });
		}
	}

	*globals{

		~bassCh=4;
		~bassTimes=1;
		~octBass=3;
		~transBass=0;
		~legBass=0;
		~stretchBass=0;

		~bassMac1=1; ~bassMac2=2;
		~bassMac3=3; ~bassMac4=4;
		~bassMac5=5; ~bassMac6=6;
		~bassMac7=7; ~bassMac8=8;
	}

	*preSet{}


	*default {

		~nt1Bass = PatternProxy( Pseq([0], inf));
		~nt1BassP = Pseq([~nt1Bass], inf).asStream;
		~dur1Bass = PatternProxy( Pseq([1], inf));
		~dur1BassP = Pseq([~dur1Bass], inf).asStream;
		~amp1Bass = PatternProxy( Pseq([0.9], inf));
		~amp1BassP = Pseq([~amp1Bass], inf).asStream;
		~sus1Bass = PatternProxy( Pseq([1], inf));
		~sus1BassP = Pseq([~dur1Bass], inf).asStream;


	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~nt1BassP.next;
				~dur1BassP.next;
				~amp1BassP.next;
				~sus1BassP.next;
				~nt1BassSon=~nt1BassP;
				~dur1BassSon=~dur1BassP;
				~amp1BassSon=~amp1BassP;
				~sus1BassSon=~sus1BassP;
				//~nt1BassSon.value;
				//~dur1BassSon.value;
				//~sus1BassSon.value;
				//~amp1BassSon.value;

				this.p1(val);

				~durMul*((~dur1BassSon.value)/i).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		Pbind(
			\chan, ~bassCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([~dur1BassSon.value/i],1)], 1),
			\degree, Pseq([~nt1BassSon.value], 1),
			\amp, Pseq([~amp1BassSon.value], 1),
			\sustain, Pseq([~sus1BassSon.value],1),
			\mtranspose, Pseq([~transBass.value], 1),
			\octave, ~octBass,
			\legato, ~legBass,
			\stretch, ~stretchBass
		).play;

		//this.count2;
		//this.timesCount;
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