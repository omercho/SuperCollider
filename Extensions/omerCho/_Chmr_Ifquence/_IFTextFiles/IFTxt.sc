/*
Omer Chatziserif, SKG 2019
*/

/*
IFTxt.make(\00,\00, \ifKick,1);
IFTxt.make(\00,\ifSnr,11);
IFTxt.make(\00,\ifHat,11);
IFTxt.make(\00,\ifBass,6);
IFTxt.make(\00,\ifKeys,6);
IFTxt.make(\00,\ifSamp,6);
IFTxt.make(\00,\ifMopho,6);

IFTxt.trckDflt;

IFTxt.readIfTrack(\00,\ifKick);
~tKcAmp=IFTxt.line(1);
~tKcNt=IFTxt.line(2);
~tKcVel=IFTxt.line(3);
~tKcSus=IFTxt.line(4);
~tKcTm=IFTxt.line(5);
~tKcDur=IFTxt.line(6);
~tKc2Amp=IFTxt.line(7);
~tKc2Nt=IFTxt.line(8);
~tKc2Vel=IFTxt.line(9);
~tKc2Sus=IFTxt.line(10);
~tKcOct=IFTxt.line(11);

IFTxt.readIfTrack(\00,\ifSnr);
~tSrAmp=IFTxt.line(1);
~tSrNt=IFTxt.line(2);
~tSrVel=IFTxt.line(3);
~tSrSus=IFTxt.line(4);
~tSrTm=IFTxt.line(5);
~tSrDur=IFTxt.line(6);
~tSr2Amp=IFTxt.line(7);
~tSr2Nt=IFTxt.line(8);
~tSr2Vel=IFTxt.line(9);
~tSr2Sus=IFTxt.line(10);
~tSrOct=IFTxt.line(11);

IFTxt.readIfTrack(\00,\ifHat);
~tHtAmp=IFTxt.line(1);
~tHtNt=IFTxt.line(2);
~tHtVel=IFTxt.line(3);
~tHtSus=IFTxt.line(4);
~tHtTm=IFTxt.line(5);
~tHtDur=IFTxt.line(6);
~tHt2Amp=IFTxt.line(7);
~tHt2Nt=IFTxt.line(8);
~tHt2Vel=IFTxt.line(9);
~tHt2Sus=IFTxt.line(10);
~tHtOct=IFTxt.line(11);

IFTxt.readIfTrack(\00,\ifBass);
~tBsAmp=IFTxt.line(1);
~tBsNt=IFTxt.line(2);
~tBsVel=IFTxt.line(3);
~tBsSus=IFTxt.line(4);
~tBsTm=IFTxt.line(5);
~tBsDur=IFTxt.line(6);

IFTxt.readIfTrack(\00,\ifKeys);
~tKyAmp=IFTxt.line(1);
~tKyNt=IFTxt.line(2);
~tKyVel=IFTxt.line(3);
~tKySus=IFTxt.line(4);
~tKyTm=IFTxt.line(5);
~tKyDur=IFTxt.line(6);

IFTxt.readIfTrack(\00,\ifSamp);
~tSmAmp=IFTxt.line(1);
~tSmNt=IFTxt.line(2);
~tSmVel=IFTxt.line(3);
~tSmSus=IFTxt.line(4);
~tSmTm=IFTxt.line(5);
~tSmDur=IFTxt.line(6);

IFTxt.readIfTrack(\00,\ifMopho);
~tMpAmp=IFTxt.line(1);
~tMpNt=IFTxt.line(2);
~tMpVel=IFTxt.line(3);
~tMpSus=IFTxt.line(4);
~tMpTm=IFTxt.line(5);
~tMpDur=IFTxt.line(6);

IFTxt.ifPath(\00,\00,\ifKick);

IFTxt.ifPath(\01,\01,\ifGlobal);
IFTxt.readIfTrack(\01,\01,\ifGlobal);
IFTxt.storeGlblAtStart;

*/

IFTxt{
	classvar <>file, <>path, <>trckPath,<>ifTrckPath, <>lineOut,<>rdFile;
	*initClass {
		StartUp add: {
			//Server.default.doWhenBooted({this.store; });
		}
	}

	*ifPath{|trck,prt,inst|
		^ifTrckPath="~/Library/Application Support/SuperCollider/Extensions/omerCho/_Chmr_Ifquence/_IFTrackPatterns/"++trck++"/"++prt++"/"++inst++".txt"
	}
	*readIfTrack{|trck,prt,inst|
		this.ifPath(trck,prt,inst);
		rdFile = CSVFileReader.readInterpret(ifTrckPath.standardizePath, true, true);
	}
	*line{|i|
		i.switch(i,{lineOut=rdFile[i-1];});
		^lineOut;
	}
	*writeRndGlbStrtLines{|trck,prt,inst|
		var cnt=1, min=0,max=1,seq,lineBreak,tmLine;
		var tmp,scl1,scl2,rootNote;
		tmLine=Pseq([Pseq([4],4)],inf).asStream;
		tmp=  Pwhite(60, 140, inf).asStream;
		scl1= Pwhite(0, 0, inf).asStream;
		scl2= Pwhite(0, 29, inf).asStream;
		rootNote= Pwhite(0,   7,   inf).asStream;
		fork{
			this.ifPath(trck,prt,inst);
			file=File.new(ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..4).do{|n|
				case
				{cnt==1}            { seq=tmp.next;}//tempo
				{cnt==2}            { seq=scl1.next;}//scl1
				{cnt==3}            { seq=scl2.next;}//scl2
				{cnt==4}            { seq=rootNote.next;};//rootNote
				file.write(
					seq.asString ++ if (n % tmLine.next != 0, ",", Char.nl)
				);
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}

	*writeRndGlobalLines{|trck,prt,inst|
		var cnt=1, min=0,max=1,seq,lineBreak,tmLine;
		var tmp,scl1,scl2,rootNote,pitchPat,pitchDur;
		var rootStp,step,seqMul;
		tmLine=Pseq([
			Pseq([16],32),
			Pseq([8],7),

		],inf).asStream;
		pitchPat=  [
			Pseq([0,Pshuf([0,1,2,3,4,5,6,7],3)],inf).asStream,
			Pseq([0,Pshuf([0,1,2,3,4,-1,-2,-3,-4],3)],inf).asStream
		].choose;
		pitchDur=  [
			Pseq([2],inf).asStream,
			Pseq([1,1,2,2],inf).asStream,
			Pseq([1,1,2,2, 1,1,1,1],inf).asStream,
			Pseq([2,2,2,2, 1,1,1,1],inf).asStream,
			Pseq([2,2,2,2, 1,1,1,1, 2,2,1,1, 2,2,1,1],inf).asStream,
			Pseq([2,2,1,1, 2,2,1,1, 2,2,2,2, 1,1,1,1],inf).asStream,
		].choose;
		rootStp= Pwhite(0,   16,   inf).asStream;
		step=    Pwhite(0,   16,   inf).asStream;
		seqMul=  Pwhite(0,   1,   inf).asStream;
		fork{
			this.ifPath(trck,prt,inst);
			file=File.new(ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..39).do{|n|
				case
				{cnt>=1&&cnt<=16}   { seq=pitchPat.next;}//MasterPitchPat
				{cnt>=17&&cnt<=32}  { seq=pitchDur.next;}//MasterPitchDur
				{cnt==33}           { seq=rootStp.next;}//
				{cnt==34}           { seq=step.next;}//
				{cnt>=35&&cnt<=39}  { seq=seqMul.next;};//
				file.write(
					seq.asString ++ if (n % tmLine.next != 0, ",", Char.nl)
				);
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}
	*writeRndFxLines{|trck,prt,inst|
		var cnt=1, min=0,max=1,seq,lineBreak,tmLine;
		var tmp,scl1,scl2,rootNote,pitchPat,pitchDur;
		var rootStp,step,seqMul;
		var seqFxVol,seqFx;
		tmLine=Pseq([
			Pseq([2],2),
			Pseq([6],8),
		],inf).asStream;
		seqFxVol=  Pwhite(0.0,   1.0,   inf).asStream;
		seqFx   =  Pwhite(0.0,   1.0,   inf).asStream;
		fork{
			this.ifPath(trck,prt,inst);
			file=File.new(ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..10).do{|n|
				case
				{cnt>=1&&cnt<=2}  { seq=seqFxVol.next;}
				{cnt>=3&&cnt<=16}  { seq=seqFx.next;};//
				file.write(
					seq.asString ++ if (n % tmLine.next != 0, ",", Char.nl)
				);
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}
	*make{|trck,prt,inst,lines|
		lines.switch(
			'rndGlbStrtTag',{
				fork{
					this.writeRndGlbStrtLines(trck,prt,inst);
					0.1.wait;
					this.readIfTrack(trck,prt,inst);
					0.1.wait;
				};
			},
			'rndGlobalTag',{
				fork{
					this.writeRndGlobalLines(trck,prt,inst);
					0.1.wait;
					this.readIfTrack(trck,prt,inst);
					0.1.wait;
				};
			},
			'rndFxTag',{
				fork{
					this.writeRndFxLines(trck,prt,inst);
					0.1.wait;
					this.readIfTrack(trck,prt,inst);
					0.1.wait;
				};
			};
		)
	}
	*trckDflt{
		fork{
			IFTxt.make(\01,\01,\ifGlbStrt,'rndGlbStrtTag');
			0.1.wait;
			IFTxt.make(\01,\01,\ifGlobal,'rndGlobalTag');
			0.1.wait;
			IFTxt.make(\01,\01,\ifFx,'rndFxTag');
			0.1.wait;
		};
	}
	*load{
		/*IFTxt.readGlbStrt(\01,\00);
		IFTxt.readGlbl(trck:\01,prtDir:\00,prt:1);
		IFTxt.readInst(\01,\00);
		IFTxt.readFx(trck:\01,prtDir:\00,prt:1);*/

	}
	*readGlbStrt{|trck,prtDir|
		IFTxt.readIfTrack(trck,prtDir,\ifGlbStrt);
		~tGlbStrt=IFTxt.line(1);
		IFTxt.storeGlblAtStart;
	}
	*readGlbl{|trck,prtDir,prt|
		IFTxt.readIfTrack(trck,prtDir,\ifGlobal);
		case
		{ prt == 1 }  {
			//IFTxt.readIfTrack(trck,prtDir,\ifGlobal);
			~tGlbNt=IFTxt.line(1);
			~tGlbDur=IFTxt.line(2);
			~tGlbRt=IFTxt.line(3);
		}
		{ prt == 2 }  {
			//IFTxt.readIfTrack(trck,prtDir,\ifGlobal);
			~tGlbNt=IFTxt.line(4);
			~tGlbDur=IFTxt.line(5);
			~tGlbRt=IFTxt.line(6);
		}
		{ prt == 3 }  {
			//IFTxt.readIfTrack(trck,prtDir,\ifGlobal);
			~tGlbNt=IFTxt.line(7);
			~tGlbDur=IFTxt.line(8);
			~tGlbRt=IFTxt.line(9);
		}
		{ prt == 4 }  {
			//IFTxt.readIfTrack(trck,prtDir,\ifGlobal);
			~tGlbNt=IFTxt.line(10);
			~tGlbDur=IFTxt.line(11);
			~tGlbRt=IFTxt.line(12);
		};
		IFTxt.storeGlblPatValues;
	}
	*readFx{|trck,prtDir,prt|
		IFTxt.readIfTrack(trck,prtDir,\ifFx);
		case
		{ prt == 1 }  {
			~tFxVol=IFTxt.line(1);
			~tFxFad=IFTxt.line(2);
			~tFxXY=IFTxt.line(3);
		}
		{ prt == 2 }  {
			~tFxVol=IFTxt.line(4);
			~tFxFad=IFTxt.line(5);
			~tFxXY=IFTxt.line(6);
		}
		{ prt == 3 }  {
			~tFxVol=IFTxt.line(7);
			~tFxFad=IFTxt.line(8);
			~tFxXY=IFTxt.line(9);
		}
		{ prt == 4 }  {
			~tFxVol=IFTxt.line(10);
			~tFxFad=IFTxt.line(11);
			~tFxXY=IFTxt.line(12);
		};
		IFTxt.storeGlblFxValues;
	}
	*readInst{|trck,prtDir|


		this.storeInstPatValues;
	}

	*storeGlblAtStart{
		IFGlobal.setAtStart(
			tmp:~tGlbStrt[0],scl1:~tGlbStrt[1],scl2:~tGlbStrt[2],root:~tGlbStrt[3],
		);
	}
	*storeGlblPatValues{
		"storeGlblPatValues from Txt to Patterns ".postln;
		/*IFGlobal.setAtStart(
			tmp:~tGlbStrt[0],scl1:~tGlbStrt[1],scl2:~tGlbStrt[2],root:~tGlbStrt[3],
		);*/
		IFSeqNtPat.stGrpSet  (
			~tGlbNt[0],~tGlbNt[1],~tGlbNt[2],~tGlbNt[3],
			~tGlbNt[4],~tGlbNt[5],~tGlbNt[6],~tGlbNt[7],
			~tGlbNt[8],~tGlbNt[9],~tGlbNt[10],~tGlbNt[11],
			~tGlbNt[12],~tGlbNt[13],~tGlbNt[14],~tGlbNt[15],
		);
		IFSeqDurPat.stGrpSet  (
			~tGlbDur[0],~tGlbDur[1],~tGlbDur[2],~tGlbDur[3],
			~tGlbDur[4],~tGlbDur[5],~tGlbDur[6],~tGlbDur[7],
			~tGlbDur[8],~tGlbDur[9],~tGlbDur[10],~tGlbDur[11],
			~tGlbDur[12],~tGlbDur[13],~tGlbDur[14],~tGlbDur[15],
		);
		IFGlobal.setRoot(
			rootStp:~tGlbRt[0],step:~tGlbRt[1],mulSeqM:~tGlbRt[2],
			mulSeq1:~tGlbRt[3],mulSeq2:~tGlbRt[4],mulSeq3:~tGlbRt[5],mulSeq4:~tGlbRt[6],
		);
	}
	*storeGlblFxValues{
		"storeGlblFxValues from Txt to Patterns ".postln;

		IFGlobal.setFx(
			vol1:~tFxVol[0],vol2:~tFxVol[1],
			fad1:~tFxFad[0],fad2:~tFxFad[1],comp:~tFxFad[2],dec:~tFxFad[3],
			fx1X:~tFxXY[0],fx1Y:~tFxXY[1],fx2X:~tFxXY[2],fx2Y:~tFxXY[3],
		);
	}
	*storeInstPatValues{//////
		"Store Instruments Values from Txt to Patterns ".postln;
		~tOSCAdrr.sendMsg('partLabel', 'Txt');


	}//////                                      - 7 -
}

/*

IFTxt.trckDflt;

*/