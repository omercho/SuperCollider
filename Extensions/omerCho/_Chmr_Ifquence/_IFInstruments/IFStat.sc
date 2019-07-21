
/*

IFStat.ln01;
*/

IFStat {
	classvar <>counter2=0, timeCnt=0;
	var <>kTime=1;


	/**initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });*/
		}
	}*/
	*load {
		this.globals;
		this.proxy;
		this.preSet;
	}

	*globals{
		~chJmx=0;
		~chStatKick=8;
		~chStatDrum=8;
		~chStatHats=9;
		~chStat=9;
		~chVKick=9;
		~chVBeats=9;

		~octVKick=4;
		~octVSnr=0;
		~octVHat=0;
		~octVClap=0;
		~octVTomL=0;
		~octVTomH=0;
		~octVCrsh=0;
		~octVPcm=0;

		~susMulVKick=1;
		~susMulVSnr=1;
		~susMulVHat=0.9;
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
/*
		//4 StaticClap
		~actVClap = PatternProxy( Pseq([0], inf));
		~actVClapP= Pseq([~actVClap], inf).asStream;
		~durVClap = PatternProxy( Pseq([1], inf));
		~durVClapP = Pseq([~durVClap], inf).asStream;
		~ampVClap = PatternProxy( Pseq([0,0,0,1], inf));
		~ampVClapP = Pseq([~ampVClap], inf).asStream;
		~ntVClap = PatternProxy( Pseq([~vClap], inf));
		~ntVClapP = Pseq([~ntVClap], inf).asStream;
		~susVClap = PatternProxy( Pseq([0.3], inf));
		~susVClapP = Pseq([~susVClap], inf).asStream;
		~volVClap = PatternProxy( Pseq([0.9], inf));
		~volVClapP = Pseq([~volVClap], inf).asStream;
		~tmMulVClap = PatternProxy( Pseq([1], inf));
		~tmMulVClapP= Pseq([~tmMulVClap], inf).asStream;
		~tmVClap = PatternProxy( Pseq([1], inf));
		~tmVClapP= Pseq([~tmVClap], inf).asStream;
		//5 StaticTomL
		~actVTomL = PatternProxy( Pseq([0], inf));
		~actVTomLP= Pseq([~actVTomL], inf).asStream;
		~durVTomL = PatternProxy( Pseq([1], inf));
		~durVTomLP = Pseq([~durVTomL], inf).asStream;
		~ampVTomL = PatternProxy( Pseq([0,0,0,0,1], inf));
		~ampVTomLP = Pseq([~ampVTomL], inf).asStream;
		~ntVTomL = PatternProxy( Pseq([[~vTomL]], inf));
		~ntVTomLP = Pseq([~ntVTomL], inf).asStream;
		~susVTomL = PatternProxy( Pseq([0.3], inf));
		~susVTomLP = Pseq([~susVTomL], inf).asStream;
		~volVTomL = PatternProxy( Pseq([0.9], inf));
		~volVTomLP = Pseq([~volVTomL], inf).asStream;
		~tmMulVTomL = PatternProxy( Pseq([1], inf));
		~tmMulVTomLP= Pseq([~tmMulVTomL], inf).asStream;
		~tmVTomL = PatternProxy( Pseq([1], inf));
		~tmVTomLP= Pseq([~tmVTomL], inf).asStream;
		//6 StaticTomH
		~actVTomH = PatternProxy( Pseq([0], inf));
		~actVTomHP= Pseq([~actVTomH], inf).asStream;
		~durVTomH = PatternProxy( Pseq([1], inf));
		~durVTomHP = Pseq([~durVTomH], inf).asStream;
		~ampVTomH = PatternProxy( Pseq([0,1,1,0,1], inf));
		~ampVTomHP = Pseq([~ampVTomH], inf).asStream;
		~ntVTomH = PatternProxy( Pseq([[~vTomH]], inf));
		~ntVTomHP = Pseq([~ntVTomH], inf).asStream;
		~susVTomH = PatternProxy( Pseq([0.3], inf));
		~susVTomHP = Pseq([~susVTomH], inf).asStream;
		~volVTomH = PatternProxy( Pseq([0.9], inf));
		~volVTomHP = Pseq([~volVTomH], inf).asStream;
		~tmMulVTomH = PatternProxy( Pseq([1], inf));
		~tmMulVTomHP= Pseq([~tmMulVTomH], inf).asStream;
		~tmVTomH = PatternProxy( Pseq([1], inf));
		~tmVTomHP= Pseq([~tmVTomH], inf).asStream;
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
		~ntVPcmP = Pseq([~ntVPcm], inf).asStream;*/

	}//*proxy


	*ln01 {|i=1|
		var val;
		val=i;
		~stVKickPat=Pbind(
			\chan, ~chJmx,
			\type, \midi, \midiout,~vJmxMBs, \scale, Pfunc({~scl2}, inf),
			\octave,~octVKick,
			\dur, Pseq([~durVKickP.next],~actVKickP.next),
			\degree, Pseq([~ntVKickP.next], inf),
			\amp, Pseq([~volVKickP.next*~ampVKickP.next], inf),
			\sustain, Pseq([~susVKickP.next],inf)*~susMulVKick
		).play(~clkDrum, quant: 0);
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
			\amp, Pseq([~volVSnrP.next*~ampVSnrP.next], inf),
			\sustain, Pseq([~susVSnrP.next],inf)*~susMulVSnr
		).play(~clkDrum, quant: 0);
	}
	*ln03 {|i=1|
		var val;
		val=i;
		~stVHatPat=Pbind(
			\chan, ~chStatHats,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octVHat,
			\dur, Pseq([~durVHatP.next],~actVHatP.next),
			\degree, Pseq([~ntVHatP.next], inf),
			\amp, Pseq([~volVHatP.next*~ampVHatP.next], inf),
			\sustain, Pseq([~susVHatP.next],inf)*~susMulVHat
		).play(~clkDrum, quant: 0);
	}
	/**ln04 {|i=1|
		var val;
		val=i;
		~stVClapPat=Pbind(
			\chan, ~chStatDrum,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octVClap,
			\dur, Pseq([~durVClapP.next],~actVClapP.next),
			\degree, Pseq([~ntVClapP.next], inf),
			\amp, Pseq([~volVClapP.next*~ampVClapP.next], inf),
			\sustain, Pseq([~susVClapP.next],inf)*~susMulVSnr
		).play(~clkDrum, quant: 0);
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
			\amp, Pseq([~volVTomLP.next*~ampVTomLP.next], inf),
			\sustain, Pseq([~susVTomLP.next],inf)*~susMulVKick
		).play(~clkDrum, quant: 0);
	}//stat01
	*ln06 {|i=1|
		var val;
		val=i;
		~stVTomHPat=Pbind(
			\chan, ~chStatHats,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octVTomH,
			\dur, Pseq([~durVTomHP.next],~actVTomHP.next),
			\degree, Pseq([~ntVTomHP.next], inf),
			\amp, Pseq([~volVTomHP.next*~ampVTomHP.next], inf),
			\sustain, Pseq([~susVTomHP.next],inf)*~susMulVHat
		).play(~clkDrum, quant: 0);
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
		).play(~clkDrum, quant: 0);
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
		).play(~clkDrum, quant: 0);
	}//stat01

*/
	*preSet{

		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		//~ntVKick.source = Pseq([36], inf);
		IFSeqVSnr.stGrpSet  (0,1,1,0, 1,0,1,0,  0,0,1,0, 0,1,1,0);
		//~ntVSnr.source = Pseq([38], inf);
		IFSeqVHat.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,0,1);
		~ntVHat.source = Pseq([42,42,42,42,42,42,42,46], inf);
		/*IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVClap.stGrpSet  (0,0,1,0, 0,0,1,1,  0,0,0,0, 1,0,0,0);
		//~ntVClap.source = Pseq([39], inf);
		//~durVClap.source  =  Pseq([1/2], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);*/

	}
}

IFTxtStat{
	classvar <>file;
	*crtRndLines{|trck,prt,inst|
		var cnt=1, min=0,max=1, seq;
		var ntVl1,ntVl2,ntVl3,ntVl4,ntVl5,ntVl6;
		var amp1,nt1,amp2,nt2,amp3,nt3;

		amp1=[Pseq([1,0],inf).asStream,Pseq([1,0,1,0,1,0,1,1],inf).asStream].choose;
		nt1=Pseq([0],inf).asStream;
		amp2=[
			Pseq([0,0,1,0],inf).asStream,
			Pseq([0,0,1,0,0,0,1,1],inf).asStream,
			Pseq([0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1],inf).asStream,
		].choose;
		ntVl2=(20..67).choose;
		nt2=Pseq([ntVl2],inf).asStream;
		amp3= [
			Pseq([0,1],inf).asStream,
			Pshuf([0,1,0,1,0,1,0,1],inf).asStream,
			Pshuf([0,1,1,0],inf).asStream,
			Pseq([0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1],inf).asStream
		].choose;
		ntVl3=(0..127).choose;
		nt3=Pseq([ntVl3],inf).asStream;

		fork{
			IFTxt.ifPath(trck,prt,inst);
			file=File.new(IFTxt.ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..96).do{|n|
				case
				{cnt>0&&cnt<=16}{seq=amp1.next}//ampVkick
				{cnt>16&&cnt<=32}{seq=nt1.next}//ntVkick

				{cnt>32&&cnt<=48}{seq=amp2.next}//ampVSnr
				{cnt>48&&cnt<=64}{seq=nt2.next}//ntVSnr

				{cnt>64&&cnt<=80}{seq=amp3.next}//ampVHat
				{cnt>80&&cnt<=96}{seq=nt3.next};//ntVHat

				file.write(seq.asString ++ if (n % 16 != 0, ",", Char.nl));
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}
	*make{|trck,prt,inst,lines|
		lines.switch(
			'rndStatTag',{
				fork{
					this.crtRndLines(trck,prt,inst);
					0.1.wait;
					IFTxt.readIfTrack(trck,prt,inst);
					0.1.wait;
				};
			};
		)
	}
	*makeDflt{
		IFTxtStat.make(\01,\00,\ifStat,'rndStatTag');
	}
	*read{|trck,prtDir|

		IFTxt.readIfTrack(trck,prtDir,\ifStat);
		~tStKc=IFTxt.line(1);
		~tStKcN=IFTxt.line(2);
		~tStSn=IFTxt.line(3);
		~tStSnN=IFTxt.line(4);
		~tStHt=IFTxt.line(5);
		~tStHtN=IFTxt.line(6);

		this.storeVals;
	}
	*storeVals{//////
		"Store Stat Values from Txt to Patterns ".postln;
		//[ Stat ]//Static Drum
		IFSeqVKick.stGrpSet  (
			~tStKc[0],~tStKc[1],~tStKc[2],~tStKc[3],
			~tStKc[4],~tStKc[5],~tStKc[6],~tStKc[7],
			~tStKc[8],~tStKc[9],~tStKc[10],~tStKc[11],
			~tStKc[12],~tStKc[13],~tStKc[14],~tStKc[15],
		);
		~ntVKick.source = Pseq([
			~tStKcN[0],~tStKcN[1],~tStKcN[2],~tStKcN[3],
			~tStKcN[4],~tStKcN[5],~tStKcN[6],~tStKcN[7],
			~tStKcN[8],~tStKcN[9],~tStKcN[10],~tStKcN[11],
			~tStKcN[12],~tStKcN[13],~tStKcN[14],~tStKcN[15],
		], inf);
		IFSeqVSnr.stGrpSet  (
			~tStSn[0],~tStSn[1],~tStSn[2],~tStSn[3],
			~tStSn[4],~tStSn[5],~tStSn[6],~tStSn[7],
			~tStSn[8],~tStSn[9],~tStSn[10],~tStSn[11],
			~tStSn[12],~tStSn[13],~tStSn[14],~tStSn[15],
		);
		~ntVSnr.source = Pseq([
			~tStSnN[0],~tStSnN[1],~tStSnN[2],~tStSnN[3],
			~tStSnN[4],~tStSnN[5],~tStSnN[6],~tStSnN[7],
			~tStSnN[8],~tStSnN[9],~tStSnN[10],~tStSnN[11],
			~tStSnN[12],~tStSnN[13],~tStSnN[14],~tStSnN[15],
		], inf);
		IFSeqVHat.stGrpSet  (
			~tStHt[0],~tStHt[1],~tStHt[2],~tStHt[3],
			~tStHt[4],~tStHt[5],~tStHt[6],~tStHt[7],
			~tStHt[8],~tStHt[9],~tStHt[10],~tStHt[11],
			~tStHt[12],~tStHt[13],~tStHt[14],~tStHt[15],
		);
		~ntVHat.source = Pseq([
			~tStHtN[0],~tStHtN[1],~tStHtN[2],~tStHtN[3],
			~tStHtN[4],~tStHtN[5],~tStHtN[6],~tStHtN[7],
			~tStHtN[8],~tStHtN[9],~tStHtN[10],~tStHtN[11],
			~tStHtN[12],~tStHtN[13],~tStHtN[14],~tStHtN[15],
		], inf);


	}//////
}