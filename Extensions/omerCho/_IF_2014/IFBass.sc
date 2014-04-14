
/*
IFBass.times(2);
IFBass.pat_1;

~octBass=4;

*/


IFBass {
var <>keyTime = 1;
classvar <>counter3 = 0;


	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet; this.default; });
		}
	}

	*globals{

		~chBass=4;
		~bassLate=0.00;
		~timesBass=1;
		~octBass=3;
		~transBass=0;
		~legBass=0;
		~stretchBass=0;

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

				~bassLate.wait;

				this.p1(val);

				~durMul*((~dur1BassP.value)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chBass,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([~dur1BassP.next/val],1)], 1),
			\degree, Pseq([~nt1BassP.next], 1),
			\amp, Pseq([~amp1BassP.next], 1),
			\sustain, Pseq([~sus1BassP.next],1),
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
					this.ctl_2;
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


}