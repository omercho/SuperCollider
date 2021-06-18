IFTxtSeqs{
	classvar <>file;
	*crtRndLines{|trck,prt,inst|
		var cnt=0, min=0,max=1,seq,lineBreak,tmLine;
		var seqMNt,seqMDur,seqMDir,seq1Dur,seq1Dir,seq2Dur,seq2Dir,seq3Dur,seq3Dir,seq4Dur,seq4Dir,seqMul;
		tmLine=Pseq([
			Pseq([16],32),
			Pseq([2],2),
			Pseq([5],4),
		],inf).asStream;
		seqMNt=  [
			Pseq([0,Pwhite(-4,   7,   inf)],inf).asStream,
			Pseq([0,Pshuf([2,6,4,5,3],3)],inf).asStream,
			Pseq([0,Pshuf([1,3,4,5,7],3)],inf).asStream,
			Pseq([0,Pshuf([0,2,4,6,7],3)],inf).asStream,
			Pseq([0,Pshuf([0,1,2,3,4,5,6,7],3)],inf).asStream,
			Pseq([0,Pshuf([0,-2,2,-1,-2,-3,-4],3)],inf).asStream,
			Pseq([0,Pshuf([0,1,2,3,4,-1,-2,-3,-4],3)],inf).asStream
		].choose;
		seqMDur=  [
			Pseq([1],inf).asStream,
			Pseq([2],inf).asStream,
			Pseq([1,1,2,2],inf).asStream,
			Pseq([1,2,2,2],inf).asStream,
			Pseq([1,2,1,2, 1,2,1,2],inf).asStream,
			Pseq([2,2,2,2, 1,1,1,1],inf).asStream,
			Pseq([1,2,1,2, 1,1,1,1, 2,2,1,1, 2,2,1,1],inf).asStream,
			Pseq([1,1,1,2, 1,1,1,2, 1,1,1,2, 1,1,1,1],inf).asStream,
			Pseq([2,2,1,1, 2,2,1,1, 2,2,2,2, 1,1,1,1],inf).asStream,
		].choose;
		seqMDir=  [
			Pwhite(1,   16,   inf).asStream,
			Pseq([1,2],inf).asStream,
			Pseq([1,2,3,4],inf).asStream,
			Pseq([5,6,7,8],inf).asStream,
			Pseq([1,2,3,4, 5,6,7,8],inf).asStream,
			Pseq([1,2,3,4, 5,6,7,8, 9,10,11,12, 13,14,15,16],inf).asStream,
		].choose;
		seq1Dur=  [
			Pseq([2],inf).asStream,
			Pseq([4],inf).asStream,
			Pseq([4,4,2,2],inf).asStream,
			Pseq([2,2,2,2, 4,4,4,4],inf).asStream,
			Pseq([2,4,2,4, 2,4,2,4],inf).asStream,
			Pseq([2,2,2,2, 2,4,2,4, 2,2,2,2, 2,4,2,4],inf).asStream,
			Pseq([4,2,2,2, 4,4,2,2, 4,2,2,2, 4,2,2,2],inf).asStream,
			Pseq([2,2,4,2, 2,2,4,2, 2,2,4,2, 4,2,2,2],inf).asStream,
		].choose;
		seq1Dir=  [
			Pwhite(1,   16,   inf).asStream,
			Pseq([1,2],inf).asStream,
			Pseq([1,2,3,4],inf).asStream,
			Pseq([5,6,7,8],inf).asStream,
			Pseq([1,2,3,4, 5,6,7,8],inf).asStream,
			Pseq([1,2,3,4, 5,6,7,8, 9,10,11,12, 13,14,15,16],inf).asStream,
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
		seq2Dir=  [
			Pwhite(1,   16,   inf).asStream,
			Pseq([1,2],inf).asStream,
			Pseq([1,2,3,4],inf).asStream,
			Pseq([5,6,7,8],inf).asStream,
			Pseq([1,2,3,4, 5,6,7,8],inf).asStream,
			Pseq([1,2,3,4, 5,6,7,8, 9,10,11,12, 13,14,15,16],inf).asStream,
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
		seq3Dir=  [
			Pwhite(1,   16,   inf).asStream,
			Pseq([1,2],inf).asStream,
			Pseq([1,2,3,4],inf).asStream,
			Pseq([5,6,7,8],inf).asStream,
			Pseq([1,2,3,4, 5,6,7,8],inf).asStream,
			Pseq([1,2,3,4, 5,6,7,8, 9,10,11,12, 13,14,15,16],inf).asStream,
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
		seq4Dir=  [
			Pwhite(1,   16,   inf).asStream,
			Pseq([1,2],inf).asStream,
			Pseq([1,2,3],inf).asStream,
			Pseq([1,2,3,4],inf).asStream,
			Pseq([5,6,7,8],inf).asStream,
			Pseq([9,10,11,12],inf).asStream,
			Pseq([13,14,15,16],inf).asStream,
			Pseq([1,2,3,4, 5,6,7,8],inf).asStream,
			Pseq([9,10,11,12, 13,14,15,16],inf).asStream,
			Pseq([1,2,3,4, 5,6,7,8, 9,10,11,12, 13,14,15,16],inf).asStream,
		].choose;
		seqMul=  Pwhite(0,   1,   inf).asStream;
		fork{
			IFTxt.ifPath(trck,prt,inst);
			file=File.new(IFTxt.ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..181).do{|n|
				//("--SART").postln;
				//(cnt+"cntBeforePlus").postln;
				cnt=cnt+1;
				case
				{cnt>=1 &&cnt<=16}   {tmLine=16; seq=seqMNt.next}
				{cnt>=17&&cnt<=32}   {tmLine=16; seq=seqMDur.next}//sM
				{cnt>=33&&cnt<=48}   {tmLine=16; seq=seqMDir.next}//
				{cnt>=49&&cnt<=64}   {tmLine=16; seq=seq1Dur.next}//s1
				{cnt>=65&&cnt<=80}   {tmLine=16; seq=seq1Dir.next}//
				{cnt>=81&&cnt<=96}   {tmLine=16; seq=seq2Dur.next}//s2
				{cnt>=97&&cnt<=112}  {tmLine=16; seq=seq2Dir.next}//
				{cnt>=113&&cnt<=128} {tmLine=16; seq=seq3Dur.next}//s3
				{cnt>=129&&cnt<=144} {tmLine=16; seq=seq3Dir.next}//
				{cnt>=145&&cnt<=160} {tmLine=16; seq=seq4Dur.next}//s4
				{cnt>=161&&cnt<=176} {tmLine=16; seq=seq4Dir.next}//

				{cnt>=177&&cnt<=181} {tmLine=16; seq=seqMul.next};
				file.write(
					seq.asString ++ if (n % tmLine.next != 0, ",", Char.nl)
				);
				//cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		};
	}
	*make{|trck,prt,inst,lines|
		lines.switch(
			'rndSeqsTag',{
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
		IFTxtSeqs.make(\00,\01,\ifSeqs,'rndSeqsTag');
	}
	*read{|trck,prtDir,prt|

		IFTxt.readIfTrack(trck,prtDir,\ifSeqs);
		prt.switch(
			\01, {
				~tSqMNt=IFTxt.line(1);
				~tSqMDur=IFTxt.line(2);
				~tSqMDir=IFTxt.line(3);

				~tSq1Dur=IFTxt.line(4);
				~tSq1Dir=IFTxt.line(5);

				~tSq2Dur=IFTxt.line(6);
				~tSq2Dir=IFTxt.line(7);

				~tSq3Dur=IFTxt.line(8);
				~tSq3Dir=IFTxt.line(9);

				~tSq4Dur=IFTxt.line(10);
				~tSq4Dir=IFTxt.line(11);

				~tSqMul=IFTxt.line(12);
			},
			\02, {

			},
			\03, {

			},
			\04, {

			},
		);

		this.storeVals;
	}
	*storeVals{//////
		"Store Seqs Values from Txt to Patterns ".postln;
		//[ Seqs ]
		IFSeqNtPat.stGrpSet  (
			~tSqMNt[0],~tSqMNt[1],~tSqMNt[2],~tSqMNt[3],
			~tSqMNt[4],~tSqMNt[5],~tSqMNt[6],~tSqMNt[7],
			~tSqMNt[8],~tSqMNt[9],~tSqMNt[10],~tSqMNt[11],
			~tSqMNt[12],~tSqMNt[13],~tSqMNt[14],~tSqMNt[15],
		);
		IFSeqDurPat.stGrpSet  (
			~tSqMDur[0],~tSqMDur[1],~tSqMDur[2],~tSqMDur[3],
			~tSqMDur[4],~tSqMDur[5],~tSqMDur[6],~tSqMDur[7],
			~tSqMDur[8],~tSqMDur[9],~tSqMDur[10],~tSqMDur[11],
			~tSqMDur[12],~tSqMDur[13],~tSqMDur[14],~tSqMDur[15],
		);
		~stepMaster.source=Pseq([
			~tSqMDir[0],~tSqMDir[1],~tSqMDir[2],~tSqMDir[3],
			~tSqMDir[4],~tSqMDir[5],~tSqMDir[6],~tSqMDir[7],
			~tSqMDir[8],~tSqMDir[9],~tSqMDir[10],~tSqMDir[11],
			~tSqMDir[12],~tSqMDir[13],~tSqMDir[14],~tSqMDir[15],
		], inf);

		IFSeq1Dur.stGrpSet  (
			~tSq1Dur[0],~tSq1Dur[1],~tSq1Dur[2],~tSq1Dur[3],
			~tSq1Dur[4],~tSq1Dur[5],~tSq1Dur[6],~tSq1Dur[7],
			~tSq1Dur[8],~tSq1Dur[9],~tSq1Dur[10],~tSq1Dur[11],
			~tSq1Dur[12],~tSq1Dur[13],~tSq1Dur[14],~tSq1Dur[15],
		);
		~stepNum1.source=Pseq([
			~tSq1Dir[0],~tSq1Dir[1],~tSq1Dir[2],~tSq1Dir[3],
			~tSq1Dir[4],~tSq1Dir[5],~tSq1Dir[6],~tSq1Dir[7],
			~tSq1Dir[8],~tSq1Dir[9],~tSq1Dir[10],~tSq1Dir[11],
			~tSq1Dir[12],~tSq1Dir[13],~tSq1Dir[14],~tSq1Dir[15],

		], inf);
		IFSeq2Dur.stGrpSet  (
			~tSq2Dur[0],~tSq2Dur[1],~tSq2Dur[2],~tSq2Dur[3],
			~tSq2Dur[4],~tSq2Dur[5],~tSq2Dur[6],~tSq2Dur[7],
			~tSq2Dur[8],~tSq2Dur[9],~tSq2Dur[10],~tSq2Dur[11],
			~tSq2Dur[12],~tSq2Dur[13],~tSq2Dur[14],~tSq2Dur[15],
		);
		~stepNum2.source=Pseq([
			~tSq2Dir[0],~tSq2Dir[1],~tSq2Dir[2],~tSq2Dir[3],
			~tSq2Dir[4],~tSq2Dir[5],~tSq2Dir[6],~tSq2Dir[7],
			~tSq2Dir[8],~tSq2Dir[9],~tSq2Dir[10],~tSq2Dir[11],
			~tSq2Dir[12],~tSq2Dir[13],~tSq2Dir[14],~tSq2Dir[15],

		], inf);
		IFSeq3Dur.stGrpSet  (
			~tSq3Dur[0],~tSq3Dur[1],~tSq3Dur[2],~tSq3Dur[3],
			~tSq3Dur[4],~tSq3Dur[5],~tSq3Dur[6],~tSq3Dur[7],
			~tSq3Dur[8],~tSq3Dur[9],~tSq3Dur[10],~tSq3Dur[11],
			~tSq3Dur[12],~tSq3Dur[13],~tSq3Dur[14],~tSq3Dur[15],
		);
		~stepNum3.source=Pseq([
			~tSq3Dir[0],~tSq3Dir[1],~tSq3Dir[2],~tSq3Dir[3],
			~tSq3Dir[4],~tSq3Dir[5],~tSq3Dir[6],~tSq3Dir[7],
			~tSq3Dir[8],~tSq3Dir[9],~tSq3Dir[10],~tSq3Dir[11],
			~tSq3Dir[12],~tSq3Dir[13],~tSq3Dir[14],~tSq3Dir[15],

		], inf);
		IFSeq4Dur.stGrpSet  (
			~tSq4Dur[0],~tSq4Dur[1],~tSq4Dur[2],~tSq4Dur[3],
			~tSq4Dur[4],~tSq4Dur[5],~tSq4Dur[6],~tSq4Dur[7],
			~tSq4Dur[8],~tSq4Dur[9],~tSq4Dur[10],~tSq4Dur[11],
			~tSq4Dur[12],~tSq4Dur[13],~tSq4Dur[14],~tSq4Dur[15],
		);
		~stepNum4.source=Pseq([
			~tSq4Dir[0],~tSq4Dir[1],~tSq4Dir[2],~tSq4Dir[3],
			~tSq4Dir[4],~tSq4Dir[5],~tSq4Dir[6],~tSq4Dir[7],
			~tSq4Dir[8],~tSq4Dir[9],~tSq4Dir[10],~tSq4Dir[11],
			~tSq4Dir[12],~tSq4Dir[13],~tSq4Dir[14],~tSq4Dir[15],

		], inf);
		IFGlobal.setSeqMuls(
			mulSeqM:~tSqMul[0],
			mulSeq1:~tSqMul[1],
			mulSeq2:~tSqMul[2],
			mulSeq3:~tSqMul[3],
			mulSeq4:~tSqMul[4],
		);
	}//////
}