/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;


IFSequence.step(16);
IFSequence.led02;
*/

IFSequence {
	classvar <>stp=0;
	*loadAll {
		this.loadProxy;
		this.cntrl;
		IFSeqKick.loadAll;
		IFSeqKick2.loadAll;
		IFSeqSnr.loadAll;
		IFSeqSnr2.loadAll;
		IFSeqHat.loadAll;
		IFSeqHat2.loadAll;
		IFSeqBass.loadAll;
		IFSeqKeys.loadAll;
		IFSeqSamp.loadAll;
		IFSeqMopho.loadAll;
		IFSeqPat.loadAll;

		IFSeqVKick.loadAll;
		IFSeqVSnr.loadAll;
		IFSeqVHat.loadAll;
		IFSeqVClap.loadAll;
		IFSeqVTomL.loadAll;
		IFSeqVTomH.loadAll;
		IFSeqVCrsh.loadAll;
		IFSeqVPcm.loadAll;

	}
	*loadProxy {
		~stepNum = PatternProxy( Pseq([0], inf));
		~stepNumP= Pseq([~stepNum], inf).asStream;
		~stepNum2 = PatternProxy( Pseq([0], inf));
		~stepNum2P= Pseq([~stepNum2], inf).asStream;
		~stepNum3 = PatternProxy( Pseq([0], inf));
		~stepNum3P= Pseq([~stepNum3], inf).asStream;
		~stepNum4 = PatternProxy( Pseq([0], inf));
		~stepNum4P= Pseq([~stepNum4], inf).asStream;

		~dur = PatternProxy( Pseq([2],inf) );
		~durP= Pseq([~dur], inf).asStream;
		~durMul = PatternProxy( Pseq([2], inf));
		~durMulP= Pseq([~durMul], inf).asStream;

		~dur2 = PatternProxy( Pseq([2],inf) );
		~dur2P= Pseq([~dur2], inf).asStream;
		~durMul2 = PatternProxy( Pseq([1/4], inf));
		~durMul2P= Pseq([~durMul2], inf).asStream;

		~dur3 = PatternProxy( Pseq([2],inf) );
		~dur3P= Pseq([~dur3], inf).asStream;
		~durMul3 = PatternProxy( Pseq([1/2], inf));
		~durMul3P= Pseq([~durMul3], inf).asStream;

		~dur4 = PatternProxy( Pseq([2],inf) );
		~dur4P= Pseq([~dur4], inf).asStream;
		~durMul4 = PatternProxy( Pseq([1/4], inf));
		~durMul4P= Pseq([~durMul4], inf).asStream;

	}

	*step{|i|
		this.st(i);
	}
	*step2{|i|
		this.st2(i);
	}
	*step3{|i|
		this.st3(i);
	}
	*step4{|i|
		this.st4(i);
	}
	/**step{|i|
		case
		{ i == 1 } { this.st(i);  }
		{ i == 2 } { this.st02; }
		{ i == 3 } { this.st03; }
		{ i == 4 } { this.st04; }
		{ i == 5 } { this.st05; }
		{ i == 6 } { this.st06; }
		{ i == 7 } { this.st07; }
		{ i == 8 } { this.st08; }

		{ i == 9 } { this.st09; }
		{ i == 10 } { this.st10; }
		{ i == 11 } { this.st11; }
		{ i == 12 } { this.st12; }
		{ i == 13 } { this.st13; }
		{ i == 14 } { this.st14; }
		{ i == 15 } { this.st15; }
		{ i == 16 } { this.st16; };
	}*/
	*cntrl{

		~seqFreeAllBut.free;
		~seqFreeAllBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSequence.freeAll;
				});
			},
			'/seqFreeAll'
		);

		~shiftOctBut.free;
		~shiftOctBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqOctKick.on;
				IFSeqOctSnr.on;
				IFSeqOctHat.on;
				IFSeqOctBass.on;
				IFSeqOctKeys.on;
				IFSeqOctSamp.on;
				},{
					IFSeqKick.on;
					IFSeqSnr.on;
					IFSeqHat.on;
					IFSeqBass.on;
					IFSeqKeys.on;
					IFSeqSamp.on;
			});
			},
			'/seqShiftOct'
		);

		~shiftVelBut.free;
		~shiftVelBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVelKick.on;
				IFSeqVelSnr.on;
				IFSeqVelHat.on;
				IFSeqVelBass.on;
				IFSeqVelKeys.on;
				IFSeqVelSamp.on;
				},{
					IFSeqKick.on;
					IFSeqSnr.on;
					IFSeqHat.on;
					IFSeqBass.on;
					IFSeqKeys.on;
					IFSeqSamp.on;
			});
			},
			'/seqShiftVel'
		);

		~shiftSusBut.free;
		~shiftSusBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSusKick.on;
				IFSeqSusSnr.on;
				IFSeqSusHat.on;
				IFSeqSusBass.on;
				IFSeqSusKeys.on;
				IFSeqSusSamp.on;
				},{
					IFSeqKick.on;
					IFSeqSnr.on;
					IFSeqHat.on;
					IFSeqBass.on;
					IFSeqKeys.on;
					IFSeqSamp.on;
			});
			},
			'/seqShiftSus'
		);

		~shiftNtBut.free;
		~shiftNtBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqNtKick.on;
				IFSeqNtSnr.on;
				IFSeqNtHat.on;
				IFSeqNtBass.on;
				IFSeqNtKeys.on;
				IFSeqNtSamp.on;
				IFSeqNtPat.on;
				},{
					IFSeqKick.on;
					IFSeqSnr.on;
					IFSeqHat.on;
					IFSeqBass.on;
					IFSeqKeys.on;
					IFSeqSamp.on;
					IFSeqPat.on;
			});
			},
			'/seqShiftNote'
		);
		~shiftTimesBut.free;
		~shiftTimesBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqTmKick.on;
				IFSeqTmSnr.on;
				IFSeqTmHat.on;
				IFSeqTmBass.on;
				IFSeqTmKeys.on;
				IFSeqTmSamp.on;
				},{
					IFSeqKick.on;
					IFSeqSnr.on;
					IFSeqHat.on;
					IFSeqBass.on;
					IFSeqKeys.on;
					IFSeqSamp.on;
			});
			},
			'/seqShiftTimes'
		);
		~shiftDurBut.free;
		~shiftDurBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqDurKick.on;
				IFSeqDurSnr.on;
				IFSeqDurHat.on;
				IFSeqDurBass.on;
				IFSeqDurKeys.on;
				IFSeqDurSamp.on;
				IFSeqDurPat.on;
				},{
					IFSeqKick.on;
					IFSeqSnr.on;
					IFSeqHat.on;
					IFSeqBass.on;
					IFSeqKeys.on;
					IFSeqSamp.on;
					IFSeqPat.on;
			});
			},
			'/seqShiftDur'
		);


	}
	*st{|index|
		//IFLaunchSteps.led(index);
		this.led(index);
		IFLpMnSteps.led(index);

		//IFSeqPat.stepPack(index);

		IFSeqVKick.stepPack(index);
		IFSeqVSnr.stepPack(index);
		IFSeqVHat.stepPack(index);
		IFSeqVClap.stepPack(index);
		IFSeqVTomL.stepPack(index);
		IFSeqVTomH.stepPack(index);
		IFSeqVCrsh.stepPack(index);
		IFSeqVPcm.stepPack(index);
	}
	*st2{|index|
		this.led2(index);
		IFLpMnSteps.led2(index);
		IFSeqKick.stepPack(index);
		IFSeqKick2.stepPack(index);
		IFSeqSnr.stepPack(index);
		IFSeqSnr2.stepPack(index);
		IFSeqHat.stepPack(index);
		IFSeqHat2.stepPack(index);
	}
	*st3{|index|
		this.led3(index);
		IFLpMnSteps.led3(index);
		IFSeqBass.stepPack(index);
		IFSeqKeys.stepPack(index);
	}
	*st4{|index|
		this.led4(index);
		IFLpMnSteps.led4(index);
		IFSeqSamp.stepPack(index);
		IFSeqMopho.stepPack(index);
	}
	*led{|index|
		index.switch(
			1,{this.led01;},
			2,{this.led02;},
			3,{this.led03;},
			4,{this.led04;},
			5,{this.led05;},
			6,{this.led06;},
			7,{this.led07;},
			8,{this.led08;},
			9,{this.led09;},
			10,{this.led10;},
			11,{this.led11;},
			12,{this.led12;},
			13,{this.led13;},
			14,{this.led14;},
			15,{this.led15;},
			16,{this.led16;}
		);

	}
	*led2{|index|
		index.switch(
			1,{this.led17;},
			2,{this.led18;},
			3,{this.led19;},
			4,{this.led20;},
			5,{this.led21;},
			6,{this.led22;},
			7,{this.led23;},
			8,{this.led24;},
			9,{this.led25;},
			10,{this.led26;},
			11,{this.led27;},
			12,{this.led28;},
			13,{this.led29;},
			14,{this.led30;},
			15,{this.led31;},
			16,{this.led32;}
		);

	}
	*led3{|index|
		index.switch(
			1,{this.led33;},
			2,{this.led34;},
			3,{this.led35;},
			4,{this.led36;},
			5,{this.led37;},
			6,{this.led38;},
			7,{this.led39;},
			8,{this.led40;},
			9,{this.led41;},
			10,{this.led42;},
			11,{this.led43;},
			12,{this.led44;},
			13,{this.led45;},
			14,{this.led46;},
			15,{this.led47;},
			16,{this.led48;}
		);

	}
	*led4{|index|
		index.switch(
			1,{this.led49;},
			2,{this.led50;},
			3,{this.led51;},
			4,{this.led52;},
			5,{this.led53;},
			6,{this.led54;},
			7,{this.led55;},
			8,{this.led56;},
			9,{this.led57;},
			10,{this.led58;},
			11,{this.led59;},
			12,{this.led60;},
			13,{this.led61;},
			14,{this.led62;},
			15,{this.led63;},
			16,{this.led64;}
		);

	}
	*led01 {|delay=0.3|
		"Seq 1 step 01-".postln;
		fork{~tOSCAdrr.sendMsg('seqLed01', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed01', 0);};
	}
	*led02 {
		"Seq 1 step 02--".postln;
		fork{~tOSCAdrr.sendMsg('seqLed02', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed02', 0);};
	}
	*led03 {
		"Seq 1 step 03---".postln;
		fork{~tOSCAdrr.sendMsg('seqLed03', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed03', 0);};
	}
	*led04 {
		"Seq 1 step 04----".postln;
		fork{~tOSCAdrr.sendMsg('seqLed04', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed04', 0);};
	}
	*led05 {
		"Seq 1 step 05-".postln;
		fork{~tOSCAdrr.sendMsg('seqLed05', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed05', 0);};
	}
	*led06 {
		"Seq 1 step 06--".postln;
		fork{~tOSCAdrr.sendMsg('seqLed06', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed06', 0);};
	}
	*led07 {
		"Seq 1 step 07---".postln;
		fork{~tOSCAdrr.sendMsg('seqLed07', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed07', 0);};
	}
	*led08 {
		"Seq 1 step 08----".postln;
		fork{~tOSCAdrr.sendMsg('seqLed08', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed08', 0);};
	}
	*led09 {
		"Seq 1 step 09-".postln;
		fork{~tOSCAdrr.sendMsg('seqLed09', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed09', 0);};
	}
	*led10 {
		"Seq 1 step 10--".postln;
		fork{~tOSCAdrr.sendMsg('seqLed10', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed10', 0);};
	}
	*led11 {
		"Seq 1 step 11---".postln;
		fork{~tOSCAdrr.sendMsg('seqLed11', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed11', 0);};
	}
	*led12 {
		"Seq 1 step 12----".postln;
		fork{~tOSCAdrr.sendMsg('seqLed12', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed12', 0);};
	}
	*led13 {
		"Seq 1 step 13-".postln;
		fork{~tOSCAdrr.sendMsg('seqLed13', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed13', 0);};
	}
	*led14 {
		"Seq 1 step 14--".postln;
		fork{~tOSCAdrr.sendMsg('seqLed14', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed14', 0);};
	}
	*led15 {
		"Seq 1 step 15---".postln;
		fork{~tOSCAdrr.sendMsg('seqLed15', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed15', 0);};
	}
	*led16 {
		"Seq 1 step 16----".postln;
		fork{~tOSCAdrr.sendMsg('seqLed16', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed16', 0);};
	}
	//-----------2
	*led17 {|delay=0.3|
		"Seq 2 step 01-".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led01', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led01', 0);};
	}
	*led18 {
		"Seq 2 step 02--".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led02', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led02', 0);};
	}
	*led19 {
		"Seq 2 step 03---".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led03', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led03', 0);};
	}
	*led20 {
		"Seq 2 step 04----".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led04', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led04', 0);};
	}
	*led21 {
		"Seq 2 step 05-".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led05', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led05', 0);};
	}
	*led22 {
		"Seq 2 step 06--".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led06', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led06', 0);};
	}
	*led23 {
		"Seq 2 step 07---".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led07', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led07', 0);};
	}
	*led24 {
		"Seq 2 step 08----".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led08', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led08', 0);};
	}
	*led25 {
		"Seq 2 step 09-".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led09', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led09', 0);};
	}
	*led26 {
		"Seq 2 step 10--".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led10', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led10', 0);};
	}
	*led27 {
		"Seq 2 step 11---".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led11', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led11', 0);};
	}
	*led28 {
		"Seq 2 step 12----".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led12', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led12', 0);};
	}
	*led29 {
		"Seq 2 step 13-".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led13', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led13', 0);};
	}
	*led30 {
		"Seq 2 step 14--".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led14', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led14', 0);};
	}
	*led31 {
		"Seq 2 step 15---".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led15', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led15', 0);};
	}
	*led32 {
		"Seq 2 step 16----".postln;
		fork{~tOSCAdrr.sendMsg('seq2Led16', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq2Led16', 0);};
	}
	//-----------3
	*led33 {|delay=0.3|
		"Seq 3 step 01-".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led01', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led01', 0);};
	}
	*led34 {
		"Seq 3 step 02--".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led02', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led02', 0);};
	}
	*led35 {
		"Seq 3 step 03---".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led03', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led03', 0);};
	}
	*led36 {
		"Seq 3 step 04----".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led04', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led04', 0);};
	}
	*led37 {
		"Seq 3 step 05-".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led05', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led05', 0);};
	}
	*led38 {
		"Seq 3 step 06--".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led06', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led06', 0);};
	}
	*led39 {
		"Seq 3 step 07---".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led07', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led07', 0);};
	}
	*led40 {
		"Seq 3 step 08----".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led08', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led08', 0);};
	}
	*led41 {
		"Seq 3 step 09-".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led09', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led09', 0);};
	}
	*led42 {
		"Seq 3 step 10--".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led10', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led10', 0);};
	}
	*led43 {
		"Seq 3 step 11---".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led11', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led11', 0);};
	}
	*led44 {
		"Seq 3 step 12----".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led12', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led12', 0);};
	}
	*led45 {
		"Seq 3 step 13-".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led13', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led13', 0);};
	}
	*led46 {
		"Seq 3 step 14--".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led14', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led14', 0);};
	}
	*led47 {
		"Seq 3 step 15---".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led15', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led15', 0);};
	}
	*led48 {
		"Seq 3 step 16----".postln;
		fork{~tOSCAdrr.sendMsg('seq3Led16', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq3Led16', 0);};
	}
	//-----------4
	*led49 {|delay=0.3|
		"Seq 4 step 01-".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led01', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led01', 0);};
	}
	*led50 {
		"Seq 4 step 02--".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led02', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led02', 0);};
	}
	*led51 {
		"Seq 4 step 03---".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led03', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led03', 0);};
	}
	*led52 {
		"Seq 4 step 04----".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led04', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led04', 0);};
	}
	*led53 {
		"Seq 4 step 05-".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led05', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led05', 0);};
	}
	*led54 {
		"Seq 4 step 06--".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led06', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led06', 0);};
	}
	*led55 {
		"Seq 4 step 07---".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led07', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led07', 0);};
	}
	*led56 {
		"Seq 4 step 08----".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led08', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led08', 0);};
	}
	*led57 {
		"Seq 4 step 09-".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led09', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led09', 0);};
	}
	*led58 {
		"Seq 4 step 10--".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led10', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led10', 0);};
	}
	*led59 {
		"Seq 4 step 11---".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led11', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led11', 0);};
	}
	*led60 {
		"Seq 4 step 12----".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led12', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led12', 0);};
	}
	*led61 {
		"Seq 4 step 13-".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led13', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led13', 0);};
	}
	*led62 {
		"Seq 4 step 14--".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led14', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led14', 0);};
	}
	*led63 {
		"Seq 4 step 15---".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led15', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led15', 0);};
	}
	*led64 {
		"Seq 4 step 16----".postln;
		fork{~tOSCAdrr.sendMsg('seq4Led16', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seq4Led16', 0);};
	}
	*freeAll {
		IFSeqKick.free;
		IFSeqSnr.free;
		IFSeqHat.free;
		IFSeqBass.free;
		IFSeqKeys.free;
		IFSeqSamp.free;
		IFSeqMopho.free;
		IFSeqPat.free;
	}

}

/*

*/