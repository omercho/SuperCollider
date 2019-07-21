/*
IFCounter.count;
IFCounter.get;
IFCounter.step(5);
IFCounter.reset;


~ifTime= Clock.seconds-Clock.seconds;

*/
IFCounter{
	classvar <>cnt=0, <>counter=0,<>secCount=0, <>mainCount=0, <>clockSecs=0,<>clockMins=0,<>clockStart, <>clockNow, <>oneSec=0,<>seconds=0;

	*loadProxy {
		~cntNt=0;
		//~stepNumCnt = PatternProxy( Pseq([0], inf));
		//~stepNumCntP= Pseq([~stepNumCnt], inf).asStream;
	}
	*cnt8{
		~cntNt=~cntNt+1;
		~cntNt.postln;
		~cntNt.switch(
			0,{},
			1,{
				//IFPitch.trnsCnt(~ifPitchPatP.next;);
				//("IFCounter Coun 8 Beats").postln;
				//("IF Transpose Root"+~ifPitchLblP.value).postln;
			},
			8,{
				~cntNt=0;
			}
		);
	}
	*get{
		^mainCount.postln;
	}
	*getClockNow{
		clockNow=Clock.seconds;
		^clockNow;
	}
	*getClockStart{
		clockStart=Clock.seconds;
		^clockStart;
	}
	*reset{
		~cntNt=0;
		mainCount=0;
		secCount=0;
		clockMins=0;
		~tOSCAdrr.sendMsg('mainCountLabel', mainCount);
	}
	*count {
		mainCount = mainCount + 1;
		clockMins = (clockStart-Clock.seconds)*(-1);
		clockMins = (clockMins/60).asInt;

		if ( clockSecs<=59,
			{clockSecs = ((clockNow-Clock.seconds)*(-1)).asInt;},
			{clockSecs=0;this.getClockNow;}
		);
		("min:"+clockMins+"sec:"+clockSecs+"Step:"+mainCount).postln;

		~tOSCAdrr.sendMsg('mainCountLabel', mainCount);
		~tOSCAdrr.sendMsg('ifTimeBar1H', clockSecs);
	}
	*countSecs{

	}
	*step{|i|this.st(i);}
	*st01 {
		"START".postln;
		fork{~tOSCAdrr.sendMsg('seqLed01', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed01', 0);};
	}
	*st02 {
		fork{~tOSCAdrr.sendMsg('seqLed02', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed02', 0);};
	}
	*st03 {
		fork{~tOSCAdrr.sendMsg('seqLed03', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed03', 0);};
	}
	*st04 {
		fork{~tOSCAdrr.sendMsg('seqLed04', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed04', 0);};
	}
	*st05 {
		fork{~tOSCAdrr.sendMsg('seqLed05', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed05', 0);};
	}
	*st06 {
		fork{~tOSCAdrr.sendMsg('seqLed06', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed06', 0);};
	}
	*st07 {
		fork{~tOSCAdrr.sendMsg('seqLed07', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed07', 0);};
	}
	*st08 {
		fork{~tOSCAdrr.sendMsg('seqLed08', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed08', 0);};
	}
	*st09 {
		fork{~tOSCAdrr.sendMsg('seqLed09', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed09', 0);};
	}
	*st10 {
		fork{~tOSCAdrr.sendMsg('seqLed10', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed10', 0);};
	}
	*st11 {
		fork{~tOSCAdrr.sendMsg('seqLed11', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed11', 0);};
	}
	*st12 {
		fork{~tOSCAdrr.sendMsg('seqLed12', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed12', 0);};
	}
	*st13 {
		fork{~tOSCAdrr.sendMsg('seqLed13', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed13', 0);};
	}
	*st14 {
		fork{~tOSCAdrr.sendMsg('seqLed14', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed14', 0);};
	}
	*st15 {
		fork{~tOSCAdrr.sendMsg('seqLed15', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed15', 0);};
	}
	*st16 {
		fork{~tOSCAdrr.sendMsg('seqLed16', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed16', 0);};
	}

	*countOld {
		counter = counter + 1;
		//~tOSCAdrr.sendMsg('mainCountLabel', counter);
		counter.switch(
			1, {
				fork{~tOSCAdrr.sendMsg('seqLed01', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed01', 0);};
			},
			2, {
				fork{~tOSCAdrr.sendMsg('seqLed02', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed02', 0);};
			},
			3, {
				fork{~tOSCAdrr.sendMsg('seqLed03', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed03', 0);};
			},
			4, {
				fork{~tOSCAdrr.sendMsg('seqLed04', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed04', 0);};
			},
			5, {
				fork{~tOSCAdrr.sendMsg('seqLed05', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed05', 0);};
			},
			6, {
				fork{~tOSCAdrr.sendMsg('seqLed06', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed06', 0);};
			},
			7, {
				fork{~tOSCAdrr.sendMsg('seqLed07', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed07', 0);};
			},
			8, {
				fork{~tOSCAdrr.sendMsg('seqLed08', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed08', 0);};
			},
			9, {
				fork{~tOSCAdrr.sendMsg('seqLed09', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed09', 0);};
			},
			10, {
				fork{~tOSCAdrr.sendMsg('seqLed10', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed10', 0);};
			},
			11, {
				fork{~tOSCAdrr.sendMsg('seqLed11', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed11', 0);};
			},
			12, {
				fork{~tOSCAdrr.sendMsg('seqLed12', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed12', 0);};
			},
			13, {
				fork{~tOSCAdrr.sendMsg('seqLed13', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed13', 0);};
			},
			14, {
				fork{~tOSCAdrr.sendMsg('seqLed14', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed14', 0);};
			},
			15, {
				fork{~tOSCAdrr.sendMsg('seqLed15', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed15', 0);};
			},
			16,{
				fork{~tOSCAdrr.sendMsg('seqLed16', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed16', 0);};
				this.ctrl_8;
				this.reset;
				//~countSeqRec=1;
			}

		)
	}
	*zero{
		counter = 0;
		//~tOSCAdrr.sendMsg('mainCountLabel', counter);
	}
	*ctrl_8 {
		/*~res1Mcr2.stop;
		~res1Mcr2={
		var val;
		val = Pslide((30..100).mirror, inf,3,1,0).asStream;
		240.do{
		~mdOut.control(~res1Ch, ~res1Mac2, val.next);
		(~dur.next*(1/8)).wait;
		}
		}.fork;*/
	}
	/*

	*/
}