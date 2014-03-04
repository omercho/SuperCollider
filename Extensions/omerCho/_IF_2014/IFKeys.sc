
/*
IFKeys.times(2);
IFKeys.pat_1;

~octKeys=4;

*/


IFKeys {
var <>keyTime = 1;
classvar <>counter3 = 0;


	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet; this.default; });
		}
	}

	*globals{

		~chKeys=3;
		~timesKeys=1;
		~octKeys=3;
		~transKeys=0;
		~legKeys=0;
		~stretchKeys=0;

	}

	*preSet{}


	*default {

		~nt1Keys = PatternProxy( Pseq([0], inf));
		~nt1KeysP = Pseq([~nt1Keys], inf).asStream;
		~dur1Keys = PatternProxy( Pseq([1], inf));
		~dur1KeysP = Pseq([~dur1Keys], inf).asStream;
		~amp1Keys = PatternProxy( Pseq([0.9], inf));
		~amp1KeysP = Pseq([~amp1Keys], inf).asStream;
		~sus1Keys = PatternProxy( Pseq([1], inf));
		~sus1KeysP = Pseq([~dur1Keys], inf).asStream;


	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{


				this.p1(val);

				~durMul*((~dur1KeysP.value)/i).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		Pbind(
			\chan, ~chKeys,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([~dur1KeysP.next/i],1)], 1),
			\degree, Pseq([~nt1KeysP.next], 1),
			\amp, Pseq([~amp1KeysP.next], 1),
			\sustain, Pseq([~sus1KeysP.next],1),
			\mtranspose, Pseq([~transKeys.value], 1),
			\octave, ~octKeys,
			\legato, ~legKeys,
			\stretch, ~stretchKeys
		).play;

		//this.count2;
		//this.timesCount;
	}

	//Keys Beat Counter
	*count3 {
		1.do{
			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            KeysCnt"+counter3).postln;
					this.ctl_2;
					counter3 = 0;

				}

			)
		}

	}


	*ctl_1 {


	}

	*ctl_2 {
		("Keys CTL 2").postln;

	}


}