
/*
IFVSnr.times(2);
IFVSnr.pat_1;

IFVSnr_SC(1);
IFVSnr_SC.p1(1);

~octVSnr=4;

*/


IFVSnr_SC {


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc;});*/
		}
	}

	*globals{

		~chVSnr=9;
		~vBeatsLate=0.00;
		~timesVSnr=1;
		~octMulVSnr=0;
		~trVSnr=0;
		~lfoMulVSnr=0;



	}

	*preSet{}


	*default {

		~nt1VSnr = PatternProxy( Pseq([~vSnr], inf));
		~nt1VSnrP = Pseq([~nt1VSnr], inf).asStream;
		~dur1VSnr = PatternProxy( Pseq([1], inf));
		~dur1VSnrP = Pseq([~dur1VSnr], inf).asStream;
		~amp1VSnr = PatternProxy( Pseq([0.9], inf));
		~amp1VSnrP = Pseq([~amp1VSnr], inf).asStream;
		~tmVSnr = PatternProxy( Pseq([1], inf));
		~tmVSnrP= Pseq([~tmVSnr], inf).asStream;

		~levVSnr = PatternProxy( Pseq([0.9], inf));
		~levVSnrP= Pseq([~levVSnr], inf).asStream;
		~levVSnrMul =1;



	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{var led;

				~vBeatsLate.wait;
				this.p1(val);
				/*led= ~amp1VSnrP;
				case {led==1} {
					this.led(val, ~levVSnrP);
					};*/
				~durMulP*((~dur1VSnrP.next)/val).wait;
			}}.fork;
		}
	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\type, \midi, \midiout,~vBeats,\chan, ~chVSnr,
			\scale, Pfunc({Scale.chromatic}, inf), \octave, 0,
			\dur, Pseq([~dur1VSnrP.next/val], val),
			\note, Pseq([~nt1VSnrP.next], inf),
			\amp, Pseq([~amp1VSnrP.next], inf)

		).play;
		Pbind(//vSnrLevel
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~snrLev,
			\delta, Pseq([~dur1VSnrP/val], val),
			\control, Pseq([~levVSnrP.next], val)*~levVSnrMul*127,

		).play;

	}
	*led{|i=1,amp=1|
		var val;
		val=i;
		val.do{
			1.do{
				~tOSCAdrr.sendMsg('vSnrLed', amp);0.05.wait;~tOSCAdrr.sendMsg('vSnrLed', 0.0);
			};
			~durMulP*((~dur1VSnrP.value)/val).wait;



		};

	}


	*osc{

	~levVSnrMulFad.free;
	~levVSnrMulFad= OSCFunc({
		arg msg;

			~levVSnrMul=msg[1];
		~tOSCAdrr.sendMsg('/vBeatsLevels/2', msg[1]);
		},
		'/vBeatsLevels/2'
	);

///vBeatsLevels/1

	}



}