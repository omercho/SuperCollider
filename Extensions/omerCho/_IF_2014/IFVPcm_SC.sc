
/*
IFVPcm_SC(1);
IFVPcm_SC.p1(2);

~octVPcmL=4;

*/


IFVPcm_SC {


	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc;});
		}
	}

	*globals{

		~chVPcm=9;
		~vBeatsLate=0.00;
		~timesVPcm=1;
		~trVPcm=0;
		~lfoMulVPcm=0;

	}

	*preSet{}


	*default {

		~nt1VPcm = PatternProxy( Pseq([0], inf));
		~nt1VPcmP = Pseq([~nt1VPcm], inf).asStream;
		~dur1VPcm = PatternProxy( Pseq([1], inf));
		~dur1VPcmP = Pseq([~dur1VPcm], inf).asStream;
		~amp1VPcm = PatternProxy( Pseq([0.9], inf));
		~amp1VPcmP = Pseq([~amp1VPcm], inf).asStream;
		~tmVPcm = PatternProxy( Pseq([1], inf));
		~tmVPcmP= Pseq([~tmVPcm], inf).asStream;

		~levVClap = PatternProxy( Pseq([0.9], inf));
		~levVClapP= Pseq([~levVClap], inf).asStream;
		~levVClapMul =1;
		~spdVClap = PatternProxy( Pseq([0.5], inf));
		~spdVClapP= Pseq([~spdVClap], inf).asStream;
		~spdVClapMul =1;

		~levVCalv = PatternProxy( Pseq([0.9], inf));
		~levVCalvP= Pseq([~levVCalv], inf).asStream;
		~levVCalvMul =1;
		~spdVCalv = PatternProxy( Pseq([0.5], inf));
		~spdVCalvP= Pseq([~spdVCalv], inf).asStream;
		~spdVCalvMul =1;

		~levVAgog = PatternProxy( Pseq([0.9], inf));
		~levVAgogP= Pseq([~levVAgog], inf).asStream;
		~levVAgogMul =1;
		~spdVAgog = PatternProxy( Pseq([0.5], inf));
		~spdVAgogP= Pseq([~spdVAgog], inf).asStream;
		~spdVAgogMul =1;

		~levVCrsh = PatternProxy( Pseq([0.9], inf));
		~levVCrshP= Pseq([~levVCrsh], inf).asStream;
		~levVCrshMul =1;
		~spdVCrsh = PatternProxy( Pseq([0.5], inf));
		~spdVCrshP= Pseq([~spdVCrsh], inf).asStream;
		~spdVCrshMul =1;
	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{var led;

				~vBeatsLate.wait;
				this.p1(val);
				/*led= 1*~amp1VCalvLP.next;
				case {~amp1VClapP.value==1} {
					this.led(val, ~levVPcmLP.next);
					};*/
				~durMulP*((~dur1VPcmP.next)/val).wait;
			}}.fork;
		}
	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\type, \midi, \midiout,~vBeats,\chan, ~chVPcm,
			\scale, Pfunc({Scale.chromatic}, inf), \octave, 0,
			\dur, Pseq([~dur1VPcmP.next/val], val),
			\note, Pseq([~nt1VPcmP.next], inf),
			\amp, Pseq([~amp1VPcmP.next], inf)
		).play;

		Pbind(//VClapLevel
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~clapLev,
			\delta, Pseq([~dur1VPcmP/val], val),
			\control, Pseq([~levVClapP.next], val)*~levVClapMul*127,
		).play;
		Pbind(//VClapSpeed
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~clapSpeed,
			\delta, Pseq([~dur1VPcmP/val], val),
			\control, Pseq([~spdVClapP.next], val)*~spdVClapMul*127,
		).play;

		Pbind(//VCalvLevel
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~calvLev,
			\delta, Pseq([~dur1VPcmP/val], val),
			\control, Pseq([~levVCalvP.next], val)*~levVCalvMul*127,
		).play;
		Pbind(//VCalvSpeed
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~calvSpeed,
			\delta, Pseq([~dur1VPcmP/val], val),
			\control, Pseq([~spdVCalvP.next], val)*~spdVCalvMul*127,
		).play;

		Pbind(//VAgogLevel
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~agogLev,
			\delta, Pseq([~dur1VPcmP/val], val),
			\control, Pseq([~levVAgogP.next], val)*~levVAgogMul*127,
		).play;
		Pbind(//VAgogSpeed
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~agogSpeed,
			\delta, Pseq([~dur1VPcmP/val], val),
			\control, Pseq([~spdVAgogP.next], val)*~spdVAgogMul*127,
		).play;

		Pbind(//VCrshLevel
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~crshLev,
			\delta, Pseq([~dur1VPcmP/val], val),
			\control, Pseq([~levVCrshP.next], val)*~levVCrshMul*127,
		).play;
		Pbind(//VCrshSpeed
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~crshSpeed,
			\delta, Pseq([~dur1VPcmP/val], val),
			\control, Pseq([~spdVCrshP.next], val)*~spdVCrshMul*127,
		).play;

	}

	*led{|i=1,amp=1|
		var val;
		val=i;
		val.do{
			1.do{
				~tOSCAdrr.sendMsg('VClapLed', amp);0.1.wait;~tOSCAdrr.sendMsg('VClapLed', 0.0);
			};
			~durMulP*((~dur1VPcmP.value)/val).wait;



		};

	}

	*osc{

	~levVClapMulFad.free;
	~levVClapMulFad= OSCFunc({
		arg msg;

		~levVClapMul=msg[1];
		~tOSCAdrr.sendMsg('/vBeatsLevels/7', msg[1]);
		},
		'/vBeatsLevels/7'
	);

	~levVCalvMulFad.free;
	~levVCalvMulFad= OSCFunc({
		arg msg;

		~levVCalvMul=msg[1];
		~tOSCAdrr.sendMsg('/vBeatsLevels/8', msg[1]);
		},
		'/vBeatsLevels/8'
	);

	~levVAgogMulFad.free;
	~levVAgogMulFad= OSCFunc({
		arg msg;

		~levVAgogMul=msg[1];
		~tOSCAdrr.sendMsg('/vBeatsLevels9', msg[1]);
		},
		'/vBeatsLevels/9'
	);

	~levVCrshMulFad.free;
	~levVCrshMulFad= OSCFunc({
		arg msg;

		~levVCrshMul=msg[1];
		~tOSCAdrr.sendMsg('/vBeatsLevels/10', msg[1]);
		},
		'/vBeatsLevels/10'
	);

	~decVHatMulFad.free;
	~decVHatMulFad= OSCFunc({
		arg msg;

		~decVHatMul=msg[1];
		~tOSCAdrr.sendMsg('/spdVClap', msg[1]);
		},
		'/spdVClap'
	);


	}



}