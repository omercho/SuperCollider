
/*

IFStat.ln01;
*/

IFStat {
	classvar <>counter2=0, timeCnt=0;
	var <>kTime=1;


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });*/
		}
	}
	*load {
		this.globals;
		this.proxy;
		this.mdMix;
		this.preSet;


	}

	*globals{
		~chStatDrum=8;
		~chStat=9;
		~chVKick=9;
		~chVBeats=9;
		~octVKick=1;
		~octVSnr=0;
		~octVHat=0;
		~octVClap=0;
		~octVTomL=0;
		~octVTomH=0;
		~octVCrsh=0;
		~octVPcm=0;


	}

	*proxy {

		//Static_01_Kick
		~actVKick = PatternProxy( Pseq([0], inf));
		~actVKickP= Pseq([~actVKick], inf).asStream;
		~durVKick = PatternProxy( Pseq([1], inf));
		~durVKickP = Pseq([~durVKick], inf).asStream;
		~ampVKick = PatternProxy( Pseq([1,0], inf));
		~ampVKickP = Pseq([~ampVKick], inf).asStream;
		~ntVKick = PatternProxy( Pseq([[~vKick]], inf));
		~ntVKickP = Pseq([~ntVKick], inf).asStream;
		~susVKick = PatternProxy( Pseq([0.3], inf));
		~susVKickP = Pseq([~susVKick], inf).asStream;
		~volVKick = PatternProxy( Pseq([0.9], inf));
		~volVKickP = Pseq([~volVKick], inf).asStream;
		~tmMulVKick = PatternProxy( Pseq([1], inf));
		~tmMulVKickP= Pseq([~tmMulVKick], inf).asStream;
		~tmVKick = PatternProxy( Pseq([1], inf));
		~tmVKickP= Pseq([~tmVKick], inf).asStream;
		//2StaticSnr
		~actVSnr = PatternProxy( Pseq([0], inf));
		~actVSnrP= Pseq([~actVSnr], inf).asStream;
		~durVSnr = PatternProxy( Pseq([1], inf));
		~durVSnrP = Pseq([~durVSnr], inf).asStream;
		~ampVSnr = PatternProxy( Pseq([0,0,0,1], inf));
		~ampVSnrP = Pseq([~ampVSnr], inf).asStream;
		~ntVSnr = PatternProxy( Pseq([[~vSnr]], inf));
		~ntVSnrP = Pseq([~ntVSnr], inf).asStream;
		~susVSnr = PatternProxy( Pseq([0.3], inf));
		~susVSnrP = Pseq([~susVSnr], inf).asStream;
		~volVSnr = PatternProxy( Pseq([0.9], inf));
		~volVSnrP = Pseq([~volVSnr], inf).asStream;
		~tmMulVSnr = PatternProxy( Pseq([1], inf));
		~tmMulVSnrP= Pseq([~tmMulVSnr], inf).asStream;
		~tmVSnr = PatternProxy( Pseq([1], inf));
		~tmVSnrP= Pseq([~tmVSnr], inf).asStream;
		//3 StaticHat
		~actVHat = PatternProxy( Pseq([0], inf));
		~actVHatP= Pseq([~actVHat], inf).asStream;
		~durVHat = PatternProxy( Pseq([1], inf));
		~durVHatP = Pseq([~durVHat], inf).asStream;
		~ampVHat = PatternProxy( Pseq([1], inf));
		~ampVHatP = Pseq([~ampVHat], inf).asStream;
		~ntVHat = PatternProxy( Pseq([0], inf));
		~ntVHatP = Pseq([~ntVHat], inf).asStream;
		~susVHat = PatternProxy( Pseq([0.3], inf));
		~susVHatP = Pseq([~susVHat], inf).asStream;
		~volVHat = PatternProxy( Pseq([0.9], inf));
		~volVHatP = Pseq([~volVHat], inf).asStream;
		~tmMulVHat = PatternProxy( Pseq([1], inf));
		~tmMulVHatP= Pseq([~tmMulVHat], inf).asStream;
		~tmVHat = PatternProxy( Pseq([1], inf));
		~tmVHatP= Pseq([~tmVHat], inf).asStream;
		//4 StaticClap
		~actVClap = PatternProxy( Pseq([0], inf));
		~actVClapP= Pseq([~actVClap], inf).asStream;
		~durVClap = PatternProxy( Pseq([1], inf));
		~durVClapP = Pseq([~durVClap], inf).asStream;
		~ampVClap = PatternProxy( Pseq([0,0,0,1], inf));
		~ampVClapP = Pseq([~ampVClap], inf).asStream;
		~ntVClap = PatternProxy( Pseq([~vClap], inf));
		~ntVClapP = Pseq([~ntVClap], inf).asStream;
		//5 StaticTomL
		~actVTomL = PatternProxy( Pseq([0], inf));
		~actVTomLP= Pseq([~actVTomL], inf).asStream;
		~durVTomL = PatternProxy( Pseq([1], inf));
		~durVTomLP = Pseq([~durVTomL], inf).asStream;
		~ampVTomL = PatternProxy( Pseq([0,1,1,0,1], inf));
		~ampVTomLP = Pseq([~ampVTomL], inf).asStream;
		~ntVTomL = PatternProxy( Pseq([[~vTomL]], inf));
		~ntVTomLP = Pseq([~ntVTomL], inf).asStream;
		//6 StaticTomH
		~actVTomH = PatternProxy( Pseq([0], inf));
		~actVTomHP= Pseq([~actVTomH], inf).asStream;
		~durVTomH = PatternProxy( Pseq([1], inf));
		~durVTomHP = Pseq([~durVTomH], inf).asStream;
		~ampVTomH = PatternProxy( Pseq([0,1,1,0,1], inf));
		~ampVTomHP = Pseq([~ampVTomH], inf).asStream;
		~ntVTomH = PatternProxy( Pseq([[~vTomH]], inf));
		~ntVTomHP = Pseq([~ntVTomH], inf).asStream;
		//7 StaticCrsh
		~actVCrsh = PatternProxy( Pseq([0], inf));
		~actVCrshP= Pseq([~actVCrsh], inf).asStream;
		~durVCrsh = PatternProxy( Pseq([1], inf));
		~durVCrshP = Pseq([~durVCrsh], inf).asStream;
		~ampVCrsh = PatternProxy( Pseq([0,1,0,1], inf));
		~ampVCrshP = Pseq([~ampVCrsh], inf).asStream;
		~ntVCrsh = PatternProxy( Pseq([~vCrsh], inf));
		~ntVCrshP = Pseq([~ntVCrsh], inf).asStream;
		//8 StaticAgog
		~actVPcm = PatternProxy( Pseq([0], inf));
		~actVPcmP= Pseq([~actVPcm], inf).asStream;
		~durVPcm = PatternProxy( Pseq([1], inf));
		~durVPcmP = Pseq([~durVPcm], inf).asStream;
		~ampVPcm = PatternProxy( Pseq([0,1,0,1], inf));
		~ampVPcmP = Pseq([~ampVPcm], inf).asStream;
		~ntVPcm = PatternProxy( Pseq([~vAgog,~vCalv], inf));
		~ntVPcmP = Pseq([~ntVPcm], inf).asStream;

	}//*proxy


	*ln01 {|i=1|
		var val;
		val=i;
		~stVKickPat=Pbind(
			\chan, ~chStat,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octVKick,
			\dur, Pseq([~durVKickP.next],~actVKickP.next),
			\degree, Pseq([~ntVKickP.next], inf),
			\amp, Pseq([~volKickP.next*~ampVKickP.next], inf),
			\sustain, Pseq([~susVKickP.next],inf)*~susMulKick
		).play(quant:0);
	}//stat01
	*ln02 {|i=1|
		var val;
		val=i;
		~stVSnrPat=Pbind(
			\chan, ~chStatDrum,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octVSnr,
			\dur, Pseq([~durVSnrP.next],~actVSnrP.next),
			\degree, Pseq([~ntVSnrP.next], inf),
			\amp, Pseq([~volSnrP.next*~ampVSnrP.next], inf),
			\sustain, Pseq([~susVSnrP.next],inf)*~susMulSnr
		).play;
	}
	*ln03 {|i=1|
		var val;
		val=i;
		~stVHatPat=Pbind(
			\chan, ~chStatDrum,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octVHat,
			\dur, Pseq([~durVHatP.next],~actVHatP),
			\degree, Pseq([~ntVHatP.next], inf),
			\amp, Pseq([~volHatP.next*~ampVHatP.next], inf),
			\sustain, Pseq([~susVHatP.next],inf)*~susMulHat
		).play;
	}
	*ln04 {|i=1|
		var val;
		val=i;
		~stVClapPat=Pbind(
			\chan, ~chStatDrum,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octVClap,
			\dur, Pseq([~durVClapP.next],~actVClapP),
			\degree, Pseq([~ntVClapP.next], inf),
			\amp, Pseq([~ampVClapP.next*~ampVClapP.next], inf)
		).play;

	}
	*ln05 {|i=1|
		var val;
		val=i;
		~stVTomLPat=Pbind(
			\chan, ~chStatDrum,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octVTomL,
			\dur, Pseq([~durVTomLP.next],~actVTomLP.next),
			\degree, Pseq([~ntVTomLP.next], inf),
			\amp, Pseq([~ampVTomLP.next], inf)
		).play;
	}//stat01
	*ln06 {|i=1|
		var val;
		val=i;
		~stVTomHPat=Pbind(
			\chan, ~chStatDrum,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octVTomH,
			\dur, Pseq([~durVTomHP.next],~actVTomHP.next),
			\degree, Pseq([~ntVTomHP.next], inf),
			\amp, Pseq([~ampVTomHP.next], inf)
		).play;
	}//stat01
	*ln07 {|i=1|
		var val;
		val=i;
		~stVCrshPat=Pbind(
			\chan, ~chStatDrum,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octVCrsh,
			\dur, Pseq([~durVCrshP.next],~actVCrshP.next),
			\degree, Pseq([~ntVCrshP.next], inf),
			\amp, Pseq([~ampVCrshP.next], inf)
		).play;
	}//stat01
	*ln08 {|i=1|
		var val;
		val=i;
		~stVPcmPat=Pbind(
			\chan, ~chStatDrum,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octVPcm,
			\dur, Pseq([~durVPcmP.next],~actVPcmP.next),
			\degree, Pseq([~ntVPcmP.next], inf),
			\amp, Pseq([~ampVPcmP.next], inf)
		).play;
	}//stat01

	*mdMix{



		/*~decVHatC_Mix.free;
		~decVHatC_Mix=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('decVTom', vel/127);
			~vBeats.control(9, ~tomDec, vel);

		},srcID:~mdMixInID, chan:~mdMixLn2, ccNum:33);

		~volVHat_Mix.free;
		~volVHat_Mix=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volVHat', vel/127);
			~vBeats.control(9, ~hatCLev, vel);
			~vBeats.control(9, ~hatOLev, vel);

		},srcID:~mdMixInID, chan:~mdMixLn3, ccNum:30);

		~volVPCM_Mix.free;
		~volVPCM_Mix=MIDIFunc.cc( {
			arg vel;
			//~tOSCAdrr.sendMsg('volVKick', vel/127);
			~vBeats.control(9, ~calvLev, vel);
			~vBeats.control(9, ~agogLev, vel);
			~vBeats.control(9, ~clapLev, vel);
			~vBeats.control(9, ~crshLev, vel);

		},srcID:~mdMixInID, chan:~mdMixLn4, ccNum:30);*/





	}//*mdMix



	*preSet{

		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		//~ntVKick.source = Pseq([36], inf);
		IFSeqVSnr.stGrpSet  (0,1,1,0, 1,0,1,0,  0,0,1,0, 0,1,1,0);
		//~ntVSnr.source = Pseq([38], inf);
		IFSeqVHat.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,0,1);
		~ntVHat.source = Pseq([42,42,42,42,42,42,42,46], inf);
		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVClap.stGrpSet  (0,0,1,0, 0,0,1,1,  0,0,0,0, 1,0,0,0);
		//~ntVClap.source = Pseq([39], inf);
		//~durVClap.source  =  Pseq([1/2], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

	}
}

