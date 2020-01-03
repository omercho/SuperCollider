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
		var tmp,scl1,scl2,rootNote,bankAbk,bankMph;
		tmLine=Pseq([
			Pseq([4],4),
			//Pseq([2],12),
		],inf).asStream;
		tmp=  Pwhite(60, 140, inf).asStream;
		scl1= Pwhite(0, 0, inf).asStream;
		scl2= Pwhite(0, 46, inf).asStream;
		rootNote= Pwhite(-4,   7,   inf).asStream;
		bankAbk=Pseq([Pxrand([0,1,2],1),Pwhite(0, 127, 1)],inf).asStream;
		bankMph=Pseq([Pxrand([0,1,2],1),Pwhite(0, 127, 1)],inf).asStream;
		fork{
			this.ifPath(trck,prt,inst);
			file=File.new(ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..18).do{|n|
				case
				{cnt==1}            { seq=tmp.next;}//tempo
				{cnt==2}            { seq=scl1.next;}//scl1
				{cnt==3}            { seq=scl2.next;}//scl2
				{cnt==4}            { seq=rootNote.next;}//rootNote
				{cnt>=5&&cnt<=16}   { seq=bankAbk.next;}//Ambk Program Banks
				{cnt>=17&&cnt<=18}  { seq=bankMph.next;};//Mopho Program Banks
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
		var cnt=0, min=0,max=1,seq,lineBreak,tmLine;
		var tmp,scl1,scl2,rootNote,pitchPat,pitchDur,seq1Dur,seq2Dur,seq3Dur,seq4Dur,seqMulDir;
		var rootStp,step,seqMul;
		tmLine=Pseq([
			Pseq([16],32),
			Pseq([2],2),
			Pseq([5],4),
		],inf).asStream;
		pitchPat=  [
			Pseq([0,Pshuf([2,6,4,5,3],3)],inf).asStream,
			Pseq([0,Pshuf([1,3,4,5,7],3)],inf).asStream,
			Pseq([0,Pshuf([0,2,4,6,7],3)],inf).asStream,
			Pseq([0,Pshuf([0,1,2,3,4,5,6,7],3)],inf).asStream,
			Pseq([0,Pshuf([0,-2,2,-1,-2,-3,-4],3)],inf).asStream,
			Pseq([0,Pshuf([0,1,2,3,4,-1,-2,-3,-4],3)],inf).asStream
		].choose;
		pitchDur=  [
			Pseq([2],inf).asStream,
			Pseq([1,1,2,2],inf).asStream,
			Pseq([1,1,2,2, 1,1,1,1],inf).asStream,
			Pseq([2,2,2,2, 1,1,1,1],inf).asStream,
			Pseq([2,2,2,2, 1,1,1,1, 2,2,1,1, 2,2,1,1],inf).asStream,
			Pseq([1,1,1,2, 1,1,1,2, 1,1,1,2, 1,1,1,1],inf).asStream,
			Pseq([2,2,1,1, 2,2,1,1, 2,2,2,2, 1,1,1,1],inf).asStream,
		].choose;
		seq1Dur=  [
			Pseq([2],inf).asStream,
			Pseq([4],inf).asStream,
			Pseq([4,4,2,2],inf).asStream,
			Pseq([2,2,2,2, 4,4,4,4],inf).asStream,
			Pseq([2,2,2,2, 4,4,4,4],inf).asStream,
			Pseq([2,2,2,2, 2,4,4,4, 2,2,2,2, 2,2,2,2],inf).asStream,
			Pseq([4,2,2,2, 4,4,2,2, 4,2,2,2, 4,2,2,2],inf).asStream,
			Pseq([2,2,4,2, 2,2,4,2, 2,2,4,2, 4,2,2,2],inf).asStream,
		].choose;
		seq2Dur=  [
			Pseq([2],inf).asStream,
			Pseq([4],inf).asStream,
			Pseq([4,4,2,2],inf).asStream,
			Pseq([2,2,2,2, 4,4,4,4],inf).asStream,
			Pseq([2,2,2,2, 4,4,4,4],inf).asStream,
			Pseq([2,2,2,2, 2,4,4,4, 2,2,2,2, 2,2,2,2],inf).asStream,
			Pseq([4,2,2,2, 4,4,2,2, 4,2,2,2, 4,2,2,2],inf).asStream,
			Pseq([2,2,4,2, 2,2,4,2, 2,2,4,2, 4,2,2,2],inf).asStream,
		].choose;
		seq3Dur=  [
			Pseq([2],inf).asStream,
			Pseq([4],inf).asStream,
			Pseq([4,4,2,2],inf).asStream,
			Pseq([2,2,2,2, 4,4,4,4],inf).asStream,
			Pseq([2,2,2,2, 4,4,4,4],inf).asStream,
			Pseq([2,2,2,2, 2,4,4,4, 2,2,2,2, 2,2,2,2],inf).asStream,
			Pseq([4,2,2,2, 4,4,2,2, 4,2,2,2, 4,2,2,2],inf).asStream,
			Pseq([2,2,4,2, 2,2,4,2, 2,2,4,2, 4,2,2,2],inf).asStream,
		].choose;
		seq4Dur=  [
			Pseq([2],inf).asStream,Pseq([4],inf).asStream,
			/*Pseq([2,4,2,4],inf).asStream,
			Pseq([4,2,2,2],inf).asStream,
			Pseq([4,4,2,2],inf).asStream,
			Pseq([4,2,2,2, 2,4,4,4, 2,2,2,2, 2,2,2,2],inf).asStream,
			Pseq([4,2,2,2, 4,4,2,2, 4,2,2,2, 4,2,2,2],inf).asStream,
			Pseq([2,2,4,2, 2,2,4,2, 2,2,4,2, 4,2,2,2],inf).asStream,*/
		].choose;
		seqMulDir=Pseq([Pxrand([0,1],1),Pwhite(0, 16, 1)],inf).asStream;
		rootStp= Pwhite(0,   16,   inf).asStream;
		step=    Pwhite(0,   16,   inf).asStream;
		seqMul=  Pwhite(0,   1,   inf).asStream;
		fork{
			this.ifPath(trck,prt,inst);
			file=File.new(ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..106).do{|n|
				//("--SART").postln;
				//(cnt+"cntBeforePlus").postln;
				cnt=cnt+1;
				case
				{cnt>=1 &&cnt<=16}  {tmLine=16; seq=pitchPat.next}
				{cnt>=17&&cnt<=32}  {tmLine=16; seq=pitchDur.next}//sM
				{cnt>=33&&cnt<=48}  {tmLine=16; seq=seq1Dur.next}//s1
				{cnt>=49&&cnt<=64}  {tmLine=16; seq=seq2Dur.next}//s2
				{cnt>=65&&cnt<=80}  {tmLine=16; seq=seq3Dur.next}//s3
				{cnt>=81&&cnt<=96}  {tmLine=16; seq=seq4Dur.next}//s4
				{cnt>=97&&cnt<=106} {tmLine=16; seq=seqMulDir.next};
				file.write(
					seq.asString ++ if (n % tmLine.next != 0, ",", Char.nl)
				);
				//cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		};
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
		seqFxVol=  Pwhite(0.0,   0.7,   inf).asStream;
		seqFx   =  Pwhite(0.0,   0.7,   inf).asStream;
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
			IFTxt.make(\00,\01,\ifGlbStrt,'rndGlbStrtTag');
			0.1.wait;
			IFTxt.make(\00,\01,\ifGlobal,'rndGlobalTag');
			0.1.wait;
			IFTxt.make(\00,\01,\ifFx,'rndFxTag');
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
		/*
		IFTxt.readIfTrack(\01,\01,\ifGlbStrt);
		*/
		IFTxt.readIfTrack(trck,prtDir,\ifGlbStrt);
		~tGlbStrt=IFTxt.line(1);
		~tGlbAmb1_2=IFTxt.line(2);
		~tGlbAmb3_4=IFTxt.line(3);
		~tGlbAmb5_6=IFTxt.line(4);
		~tGlbMph=IFTxt.line(5);
		IFTxt.storeGlblAtStart;
	}
	*readGlbl{|trck,prtDir,prt|
		IFTxt.readIfTrack(trck,prtDir,\ifGlobal);
		prt.switch(
			\01, {
				~tGlbNt=IFTxt.line(1);
				~tGlbDur=IFTxt.line(2);
				~tSq1Dur=IFTxt.line(3);
				~tSq2Dur=IFTxt.line(4);
				~tSq3Dur=IFTxt.line(5);
				~tSq4Dur=IFTxt.line(6);
				~tGlbRt=IFTxt.line(7);
			},
			\02, {
				~tGlbNt=IFTxt.line(8);
				~tGlbDur=IFTxt.line(9);
				~tSq1Dur=IFTxt.line(10);
				~tSq2Dur=IFTxt.line(11);
				~tSq3Dur=IFTxt.line(12);
				~tSq4Dur=IFTxt.line(13);
				~tGlbRt=IFTxt.line(14);
			},
			\03, {
				~tGlbNt=IFTxt.line(15);
				~tGlbDur=IFTxt.line(16);
				~tSq1Dur=IFTxt.line(17);
				~tSq2Dur=IFTxt.line(18);
				~tSq3Dur=IFTxt.line(19);
				~tSq4Dur=IFTxt.line(20);
				~tGlbRt=IFTxt.line(21);
			},
			\04, {
				~tGlbNt=IFTxt.line(22);
				~tGlbDur=IFTxt.line(23);
				~tSq1Dur=IFTxt.line(24);
				~tSq2Dur=IFTxt.line(25);
				~tSq3Dur=IFTxt.line(26);
				~tSq4Dur=IFTxt.line(27);
				~tGlbRt=IFTxt.line(28);
			},
		);
		IFTxt.storeGlblPatValues;
	}
	*readFx{|trck,prtDir|
		IFTxt.readIfTrack(trck,prtDir,\ifFx);

		~tFxVol=IFTxt.line(1);
		~tFxFad=IFTxt.line(2);
		~tFxXY=IFTxt.line(3);

		IFTxt.storeGlblFxValues;
	}
	*readInst{|trck,prtDir|
		this.storeInstPatValues;
	}

	*storeGlblAtStart{
		"IFTxt.storeGlblAtStart ".postln;
		IFGlobal.setAtStart(
			tmp:~tGlbStrt[0],scl1:~tGlbStrt[1],scl2:~tGlbStrt[2],root:~tGlbStrt[3],
		);
		Ambk.prtBnks(
			~tGlbAmb1_2[0],~tGlbAmb1_2[1],~tGlbAmb1_2[2],~tGlbAmb1_2[3],
			~tGlbAmb3_4[0],~tGlbAmb3_4[1],~tGlbAmb3_4[2],~tGlbAmb3_4[3],
			~tGlbAmb5_6[0],~tGlbAmb5_6[1],~tGlbAmb5_6[2],~tGlbAmb5_6[3],
		);
		Mopho.bank(~chMopho,~tGlbMph[0],~tGlbMph[1]);
	}
	*storeGlblPatValues{
		"IFTxt.storeGlblPatValues ".postln;
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
		IFSeq1Dur.stGrpSet  (
			~tSq1Dur[0],~tSq1Dur[1],~tSq1Dur[2],~tSq1Dur[3],
			~tSq1Dur[4],~tSq1Dur[5],~tSq1Dur[6],~tSq1Dur[7],
			~tSq1Dur[8],~tSq1Dur[9],~tSq1Dur[10],~tSq1Dur[11],
			~tSq1Dur[12],~tSq1Dur[13],~tSq1Dur[14],~tSq1Dur[15],
		);
		IFSeq2Dur.stGrpSet  (
			~tSq2Dur[0],~tSq2Dur[1],~tSq2Dur[2],~tSq2Dur[3],
			~tSq2Dur[4],~tSq2Dur[5],~tSq2Dur[6],~tSq2Dur[7],
			~tSq2Dur[8],~tSq2Dur[9],~tSq2Dur[10],~tSq2Dur[11],
			~tSq2Dur[12],~tSq2Dur[13],~tSq2Dur[14],~tSq2Dur[15],
		);
		IFSeq3Dur.stGrpSet  (
			~tSq3Dur[0],~tSq3Dur[1],~tSq3Dur[2],~tSq3Dur[3],
			~tSq3Dur[4],~tSq3Dur[5],~tSq3Dur[6],~tSq3Dur[7],
			~tSq3Dur[8],~tSq3Dur[9],~tSq3Dur[10],~tSq3Dur[11],
			~tSq3Dur[12],~tSq3Dur[13],~tSq3Dur[14],~tSq3Dur[15],
		);
		IFSeq4Dur.stGrpSet  (
			~tSq4Dur[0],~tSq4Dur[1],~tSq4Dur[2],~tSq4Dur[3],
			~tSq4Dur[4],~tSq4Dur[5],~tSq4Dur[6],~tSq4Dur[7],
			~tSq4Dur[8],~tSq4Dur[9],~tSq4Dur[10],~tSq4Dur[11],
			~tSq4Dur[12],~tSq4Dur[13],~tSq4Dur[14],~tSq4Dur[15],
		);
		IFGlobal.setRoot(
			mulSeqM:~tGlbRt[0],stepM:~tGlbRt[1],
			mulSeq1:~tGlbRt[2],step1:~tGlbRt[3],
			mulSeq2:~tGlbRt[4],step2:~tGlbRt[5],
			mulSeq3:~tGlbRt[6],step3:~tGlbRt[7],
			mulSeq4:~tGlbRt[8],step4:~tGlbRt[9],
		);
	}
	*storeGlblFxValues{
		"IFTxt.storeGlblFxValues ".postln;

		IFGlobal.setFx(
			vol1:~tFxVol[0],vol2:~tFxVol[1],
			fad1:~tFxFad[0],fad2:~tFxFad[1],comp:~tFxFad[2],dec:~tFxFad[3],
			fx1X:~tFxXY[0],fx1Y:~tFxXY[1],fx2X:~tFxXY[2],fx2Y:~tFxXY[3],
		);
	}
	*storeInstPatValues{//////
		//"Store Instruments Values from Txt to Patterns ".postln;
		//~tOSCAdrr.sendMsg('partLabel', 'Txt');


	}//////                                      - 7 -
}

/*

IFTxt.trckDflt;

*/