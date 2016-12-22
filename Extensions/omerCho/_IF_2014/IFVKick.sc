
/*
IFVKick(1);
IFVKick.pat_1;

~octVKick=4;

*/


IFVKick {


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc;});*/
		}
	}

	*globals{

		~chVKick=9;
		~vBeatsLate=0;
		~vBeatsLate=Tempo.bpm*(1/267.92);
		~timesVKick=1;



	}

	*preSet{}


	*default {

		~nt1VKick = PatternProxy( Pseq([0], inf));
		~nt1VKickP = Pseq([~nt1VKick], inf).asStream;
		~dur1VKick = PatternProxy( Pseq([1], inf));
		~dur1VKickP = Pseq([~dur1VKick], inf).asStream;
		~amp1VKick = PatternProxy( Pseq([0.9], inf));
		~amp1VKickP = Pseq([~amp1VKick], inf).asStream;


		~tmMulVKick = PatternProxy( Pseq([1], inf));
		~tmMulVKickP= Pseq([~tmMulVKick], inf).asStream;
		~tmVKick = PatternProxy( Pseq([1], inf));
		~tmVKickP= Pseq([~tmVKick], inf).asStream;

		~levVKick = PatternProxy( Pseq([0.9], inf));
		~levVKickP= Pseq([~levVKick], inf).asStream;
		~levVKickMul =1;



	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{var led=1 , ledNum;

				~vBeatsLate.wait;
				this.p1(val);
				led= led* ~amp1VKick.asStream.value;
				if ( led>0.0, {
					1.do{
						~tOSCAdrr.sendMsg('vKickLed', led);
						0.09.wait;
						~tOSCAdrr.sendMsg('vKickLed', 0.0);
					};
					},{

				});
				~durMulP*((~dur1VKickP.next)/val).wait;
			}}.fork;
		}
	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\type, \midi, \midiout,~vBeats,\chan, ~chVKick,
			\scale, Pfunc({Scale.chromatic}, inf), \octave, 0,
			\dur, Pseq([~dur1VKickP.next/val], val),
			\note, Pseq([~nt1VKickP.next], inf),
			\amp, Pseq([~amp1VKickP.next], inf)

		).play;
		Pbind(//vKickLevel
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~kickLev,
			\delta, Pseq([~dur1VKickP/val], val),
			\control, Pseq([~levVKickP.next], val)*~levVKickMul*127,

		).play;

	}


	*osc{

	~levVKickMulFad.free;
	~levVKickMulFad= OSCFunc({
		arg msg;

			~levVKickMul=msg[1];
		~tOSCAdrr.sendMsg('/vBeatsLevels/1', msg[1]);
		},
		'/vBeatsLevels/1'
	);

///vBeatsLevels/1

	}



}