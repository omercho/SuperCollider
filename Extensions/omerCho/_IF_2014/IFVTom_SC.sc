
/*
IFVTom_SC(1);
IFVTom_SC.p1(2);

~octVTomL=4;

*/


IFVTom_SC {


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc;});*/
		}
	}

	*globals{

		~chVTom=9;
		~vBeatsLate=0.00;
		~timesVTom=1;
		~trVTom=0;
		~lfoMulVTomL=0;



	}

	*preSet{}


	*default {

		~nt1VTom = PatternProxy( Pseq([0], inf));
		~nt1VTomP = Pseq([~nt1VTom], inf).asStream;
		~dur1VTom = PatternProxy( Pseq([1], inf));
		~dur1VTomP = Pseq([~dur1VTom], inf).asStream;
		~amp1VTom = PatternProxy( Pseq([0.9], inf));
		~amp1VTomP = Pseq([~amp1VTom], inf).asStream;
		~tmVTom = PatternProxy( Pseq([1], inf));
		~tmVTomP= Pseq([~tmVTom], inf).asStream;

		~levVTomL = PatternProxy( Pseq([0.9], inf));
		~levVTomLP= Pseq([~levVTomL], inf).asStream;
		~levVTomLMul =1;

		~levVTomH = PatternProxy( Pseq([0.9], inf));
		~levVTomHP= Pseq([~levVTomH], inf).asStream;
		~levVTomHMul =1;

		~decVTom = PatternProxy( Pseq([0.5], inf));
		~decVTomP= Pseq([~decVTom], inf).asStream;
		~decVTomMul =1;


	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{var led;

				~vBeatsLate.wait;
				this.p1(val);
				/*led= 1*~amp1VTomLP.next;
				case {~amp1VTomLP.value==1} {
					this.led(val, ~levVTomLP.next);
					};*/
				~durMulP*((~dur1VTomP.next)/val).wait;
			}}.fork;
		}
	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\type, \midi, \midiout,~vBeats,\chan, ~chVTom,
			\scale, Pfunc({Scale.chromatic}, inf), \octave, 0,
			\dur, Pseq([~dur1VTomP.next/val], val),
			\note, Pseq([~nt1VTomP.next], inf),
			\amp, Pseq([~amp1VTomP.next], inf)

		).play;
		Pbind(//vTomLLevel
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~tomLLev,
			\delta, Pseq([~dur1VTomP/val], val),
			\control, Pseq([~levVTomLP.next], val)*~levVTomLMul*127,

		).play;
		Pbind(//vTomHLevel
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~tomHLev,
			\delta, Pseq([~dur1VTomP/val], val),
			\control, Pseq([~levVTomHP.next], val)*~levVTomHMul*127,

		).play;

		Pbind(//vTomHLevel
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~tomDec,
			\delta, Pseq([~dur1VTomP/val], val),
			\control, Pseq([~decVTomP.next], val)*~decVTomMul*127,

		).play;

	}

	*led{|i=1,amp=1|
		var val;
		val=i;
		val.do{
			1.do{
				~tOSCAdrr.sendMsg('vTomLLed', amp);0.1.wait;~tOSCAdrr.sendMsg('vTomLLed', 0.0);
			};
			~durMulP*((~dur1VTomP.value)/val).wait;



		};

	}

	*osc{

	~levVTomLMulFad.free;
	~levVTomLMulFad= OSCFunc({
		arg msg;

		~levVTomLMul=msg[1];
		~tOSCAdrr.sendMsg('/vBeatsLevels/3', msg[1]);
		},
		'/vBeatsLevels/3'
	);

	~levVTomHMulFad.free;
	~levVTomHMulFad= OSCFunc({
		arg msg;

		~levVTomHMul=msg[1];
		~tOSCAdrr.sendMsg('/vBeatsLevels/4', msg[1]);
		},
		'/vBeatsLevels/4'
	);

	~decVTomMulFad.free;
	~decVTomMulFad= OSCFunc({
		arg msg;

		~decVTomMul=msg[1];
		~tOSCAdrr.sendMsg('/decVTom', msg[1]);
		},
		'/decVTom'
	);


	}



}