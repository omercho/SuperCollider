
/*
IFVHat_SC(1);
IFVHat_SC.p1(2);

~octVHatL=4;

*/


IFVHat_SC {


	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc;});
		}
	}

	*globals{

		~chVHat=9;
		~vBeatsLate=0.00;
		~timesVHat=1;
		~trVHat=0;
		~lfoMulVHat=0;



	}

	*preSet{}


	*default {

		~nt1VHat = PatternProxy( Pseq([0], inf));
		~nt1VHatP = Pseq([~nt1VHat], inf).asStream;
		~dur1VHat = PatternProxy( Pseq([1], inf));
		~dur1VHatP = Pseq([~dur1VHat], inf).asStream;
		~amp1VHat = PatternProxy( Pseq([0.9], inf));
		~amp1VHatP = Pseq([~amp1VHat], inf).asStream;
		~tmVHat = PatternProxy( Pseq([1], inf));
		~tmVHatP= Pseq([~tmVHat], inf).asStream;

		~levVHatC = PatternProxy( Pseq([0.9], inf));
		~levVHatCP= Pseq([~levVHatC], inf).asStream;
		~levVHatCMul =1;

		~levVHatO = PatternProxy( Pseq([0.9], inf));
		~levVHatOP= Pseq([~levVHatO], inf).asStream;
		~levVHatOMul =1;

		~decVHatC = PatternProxy( Pseq([0.5], inf));
		~decVHatCP= Pseq([~decVHatC], inf).asStream;
		~decVHatCMul =1;

		~decVHatO = PatternProxy( Pseq([0.5], inf));
		~decVHatOP= Pseq([~decVHatO], inf).asStream;
		~decVHatOMul =1;


	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{var led;

				~vBeatsLate.wait;
				this.p1(val);
				/*led= 1*~amp1VHatLP.next;
				case {~amp1VHatLP.value==1} {
					this.led(val, ~levVHatLP.next);
					};*/
				~durMulP*((~dur1VHatP.next)/val).wait;
			}}.fork;
		}
	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\type, \midi, \midiout,~vBeats,\chan, ~chVHat,
			\scale, Pfunc({Scale.chromatic}, inf), \octave, 0,
			\dur, Pseq([~dur1VHatP.next/val], val),
			\note, Pseq([~nt1VHatP.next], inf),
			\amp, Pseq([~amp1VHatP.next], inf)

		).play;
		Pbind(//VHatCLevel
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~hatCLev,
			\delta, Pseq([~dur1VHatP/val], val),
			\control, Pseq([~levVHatCP.next], val)*~levVHatCMul*127,

		).play;
		Pbind(//VHatOLevel
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~hatOLev,
			\delta, Pseq([~dur1VHatP/val], val),
			\control, Pseq([~levVHatOP.next], val)*~levVHatOMul*127,

		).play;

		Pbind(//VHatCDecay
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~hatCDec,
			\delta, Pseq([~dur1VHatP/val], val),
			\control, Pseq([~decVHatCP.next], val)*~decVHatCMul*127,

		).play;

		Pbind(//VHatODecay
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~hatODec,
			\delta, Pseq([~dur1VHatP/val], val),
			\control, Pseq([~decVHatOP.next], val)*~decVHatOMul*127,

		).play;

	}

	*led{|i=1,amp=1|
		var val;
		val=i;
		val.do{
			1.do{
				~tOSCAdrr.sendMsg('VHatCLed', amp);0.1.wait;~tOSCAdrr.sendMsg('VHatCLed', 0.0);
			};
			~durMulP*((~dur1VHatP.value)/val).wait;



		};

	}

	*osc{

	~levVHatCMulFad.free;
	~levVHatCMulFad= OSCFunc({
		arg msg;

		~levVHatCMul=msg[1];
		~tOSCAdrr.sendMsg('/vBeatsLevels/5', msg[1]);
		},
		'/vBeatsLevels/5'
	);

	~levVHatOMulFad.free;
	~levVHatOMulFad= OSCFunc({
		arg msg;

		~levVHatOMul=msg[1];
		~tOSCAdrr.sendMsg('/vBeatsLevels/6', msg[1]);
		},
		'/vBeatsLevels/6'
	);

	~decVHatMulFad.free;
	~decVHatMulFad= OSCFunc({
		arg msg;

		~decVHatMul=msg[1];
		~tOSCAdrr.sendMsg('/decVHatC', msg[1]);
		},
		'/decVHatC'
	);


	}



}