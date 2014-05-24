
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

		~chBass=0;
		~bassLate=0.00;
		~timesBass=1;
		~octMulBass=0;
		~harmBass=0;
		~rootBass=0;
		~susMulBass=1;
		~trBass=0;
		~lfoMulBass=0;



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
		~sus1BassP = Pseq([~sus1Bass], inf).asStream;


		~tmBass = PatternProxy( Pseq([1], inf));
		~tmBassP= Pseq([~tmBass], inf).asStream;


		~transBass = PatternProxy( Pseq([0], inf));
		~transBassP = Pseq([~transBass], inf).asStream;
		~octBass = PatternProxy( Pseq([3], inf));
		~octBassP = Pseq([~octBass], inf).asStream;
		~legBass = PatternProxy( Pseq([0.0], inf));
		~legBassP = Pseq([~legBass], inf).asStream;
		~strBass = PatternProxy( Pseq([1.0], inf));
		~strBassP = Pseq([~strBass], inf).asStream;

		~delta1Bass = PatternProxy( Pseq([0.5], inf));
		~delta1BassP = Pseq([~delta1Bass], inf).asStream;
		~delta2Bass = PatternProxy( Pseq([0.5], inf));
		~delta2BassP = Pseq([~delta2Bass], inf).asStream;

		~lfo1Bass = PatternProxy( Pseq([40], inf));
		~lfo1BassP = Pseq([~lfo1Bass], inf).asStream;
		~lfo2Bass = PatternProxy( Pseq([40], inf));
		~lfo2BassP = Pseq([~lfo2Bass], inf).asStream;


	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				//~bassLate=~abLate;
				~bassLate.wait;

				this.p1(val);

				~durMulP*((~dur1BassP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chBass,
			\type, \midi, \midiout,~vBass, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([~dur1BassP.next/val],1)], 1),
			\degree, Pseq([~nt1BassP.next], 1),
			\amp, Pseq([~amp1BassP.next], 1),
			\sustain, Pseq([~sus1BassP.next],1)*~susMulBass,
			\mtranspose, Pseq([~transBassP.next], 1)+~trBass,
			\octave, Pseq([~octBassP.next], 1)+~octMulBass,
			//\root, Pseq([~legBassP.next], 1),
			\harmonic, Pseq([~strBassP.next], 1)+~harmBass
		).play;

		Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~vBass, \chan, 4, \ctlNum, 0,
			\delta, Pseq([~delta1BassP.next], 2),
			\control, Pseq([~lfo1BassP.next], 2)*~lfoMulBass,

		).play;

		Pbind(//LFO 2
			\type, \midi, \midicmd, \control,
			\midiout,~vBass,\chan, 4,  \ctlNum, 1,
			\delta, Pseq([~delta2BassP.next], 2),
			\control, Pseq([~lfo2BassP.next], 2)*~lfoMulBass,

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