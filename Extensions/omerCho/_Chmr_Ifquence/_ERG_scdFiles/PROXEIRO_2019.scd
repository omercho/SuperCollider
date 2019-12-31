

~runTxtTest={|trck,prt,inst|
	var cnt=0, min=0,max=1,seq,lineBreak,tmLine;
	var tmp,scl1,scl2,rootNote,pitchPat,pitchDur,seqDur,seqMulDir;
	var rootStp,step,seqMul;
	/*tmLine=Pseq([
		Pseq([16],32),
		Pseq([2],2),
		Pseq([5],4),
	],inf).asStream;*/
	pitchPat=  [
		Pseq([0,Pshuf([0,1,2,3,4,5,6,7],3)],inf).asStream,
		Pseq([0,Pshuf([0,1,2,3,4,-1,-2,-3,-4],3)],inf).asStream
	].choose;
	pitchDur=  [
		Pseq([2],inf).asStream,
		Pseq([4,4,2,2],inf).asStream,
		Pseq([4,4,2,2, 4,4,4,4],inf).asStream,
		Pseq([2,2,2,2, 4,4,4,4],inf).asStream,
		Pseq([2,2,2,2, 4,4,4,4, 2,2,4,4, 2,2,4,4],inf).asStream,
		Pseq([4,4,4,2, 4,4,4,2, 4,4,4,2, 4,4,4,4],inf).asStream,
		Pseq([2,2,4,4, 2,2,4,4, 2,2,2,2, 4,4,4,4],inf).asStream,
	].choose;
	seqDur=  [

		Pseq([2],inf).asStream,
		Pseq([1,1,2,2],inf).asStream,
		Pseq([1,1,2,2, 1,1,1,1],inf).asStream,
		Pseq([2,2,2,2, 1,1,1,1],inf).asStream,
		Pseq([2,2,2,2, 1,1,1,1, 2,2,1,1, 2,2,1,1],inf).asStream,
		Pseq([1,1,1,2, 1,1,1,2, 1,1,1,2, 1,1,1,1],inf).asStream,
		Pseq([2,2,1,1, 2,2,1,1, 2,2,2,2, 1,1,1,1],inf).asStream,
	].choose;
	seqMulDir=Pseq([Pxrand([0,1],1),Pwhite(0, 16, 1)],inf).asStream;
	rootStp= Pwhite(0,   16,   inf).asStream;
	step=    Pwhite(0,   16,   inf).asStream;
	seqMul=  Pwhite(0,   2,   inf).asStream;
	fork{
		(1..106).do{|n|
			//("--SART").postln;
			//(cnt+"cntBeforePlus").postln;

			cnt=cnt+1;

			case
			{cnt>=1 &&cnt<=16}{ tmLine=16; seq=pitchPat.next}
			{cnt>=17&&cnt<=32}{ tmLine=16; seq=pitchDur.next}
			{cnt>=33&&cnt<=48}  {tmLine=16; seq=seqDur.next}//nt
			{cnt>=49&&cnt<=64}  {tmLine=16; seq=seqDur.next}//vel
			{cnt>=65&&cnt<=80}  {tmLine=16; seq=seqDur.next}//susT
			{cnt>=81&&cnt<=96}  {tmLine=16; seq=seqDur.next}
			{cnt>=97&&cnt<=106}{tmLine=16; seq=seqMulDir.next};
			//{ cnt >= 103 && cnt <=108 }{ tmLine=6;  seq=seqMul.next; };
			postln(
				seq.asString ++ if (/*((n)+cnt.asString).postln;*/ n%tmLine!=0, ",", Char.nl;);
			);

			//("-").postln;
			//(cnt+"cntAfterPlus").postln;

		};
		0.4.wait;

	}
}.fork;
/*
~dur1.source=Pshuf([1,0.5,2,0.5]*2,inf);
~dur2.source=Pshuf([1,0.5,2,0.5]*2,inf);
~dur3.source=Pshuf([1,0.5,2,0.5]*2,inf);
~dur4.source=Pshuf([1,0.5,2,0.5]*2,inf);
~durMaster.source=Pshuf([1,0.5,2,0.5]*2,inf);

~dur1.source=Pshuf([1]*2,inf);
~dur2.source=Pshuf([1]*2,inf);
~dur3.source=Pshuf([1]*2,inf);
~dur4.source=Pshuf([1]*2,inf);

IFRoot.set(\durPatSeq1,127);
IFRoot.set(\durMulSeq1,127);

~test=Pseq([Pxrand([\a,\b,\c],1),Pwhite(0, 127, 1)],inf).asStream;
~test.next;


Mopho.bank(~chMopho,2/*0-2*/,59/*0-2*/);

~vMopho.program(0,127);


~vMopho.control(0,32,0);

*loadLists{

	~bankLst = [\a,\b,\c];

}
*prog{|ch,bnk,prg|
	bnk.switch(
		\a, {~vMopho.control(ch, 0, /*0-2*/0);~vMopho.program(ch, prg);},
		\b, {~vMopho.control(ch, 0, 1);~vMopho.program(ch, prg);},
		\c, {~vMopho.control(ch, 0, 2);~vMopho.program(ch, prg);},
	);
}
*bank{|chan,bank,prog|
	Mopho.prog(ch:chan,bnk:~bankLst[bank],prg:prog);
}
*/

