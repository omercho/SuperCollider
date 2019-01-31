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
		IFSeqSamp.stepPack(index);
		IFSeqMopho.stepPack(index);
		IFSeqPat.stepPack(index);
	}
	*st4{|index|
		this.led4(index);
		IFLpMnSteps.led4(index);
		IFSeqSamp.stepPack(index);
		IFSeqMopho.stepPack(index);
		IFSeqPat.stepPack(index);
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
	/*
	*st01{
		this.led01;
		IFSeqKick.stepPack(1);
		IFSeqSnr.stepPack(1);
		IFSeqHat.stepPack(1);
		IFSeqBass.stepPack(1);
		IFSeqKeys.stepPack(1);
		IFSeqSamp.stepPack(1);
		IFSeqMopho.stepPack(1);
		IFSeqPat.stepPack(1);
		IFSeqVKick.stepPack(1);
		IFSeqVTomL.stepPack(1);
	}
	*st02{
		this.led02;
		IFSeqKick.stepPack(2);
		IFSeqSnr.stepPack(2);
		IFSeqHat.stepPack(2);
		IFSeqBass.stepPack(2);
		IFSeqKeys.stepPack(2);
		IFSeqSamp.stepPack(2);
		IFSeqMopho.stepPack(2);
		IFSeqPat.stepPack(2);
		IFSeqVKick.stepPack(2);
		IFSeqVTomL.stepPack(2);
	}
	*st03{
		this.led03;
		IFSeqKick.stepPack(3);
		IFSeqSnr.stepPack(3);
		IFSeqHat.stepPack(3);
		IFSeqBass.stepPack(3);
		IFSeqKeys.stepPack(3);
		IFSeqSamp.stepPack(3);
		IFSeqMopho.stepPack(3);
		IFSeqPat.stepPack(3);
		IFSeqVKick.stepPack(3);
		IFSeqVTomL.stepPack(3);
	}
	*st04{
		this.led04;
		IFSeqKick.stepPack(4);
		IFSeqSnr.stepPack(4);
		IFSeqHat.stepPack(4);
		IFSeqBass.stepPack(4);
		IFSeqKeys.stepPack(4);
		IFSeqSamp.stepPack(4);
		IFSeqMopho.stepPack(4);
		IFSeqPat.stepPack(4);
		IFSeqVKick.stepPack(4);
		IFSeqVTomL.stepPack(4);
	}
	*st05{
		this.led05;
		IFSeqKick.stepPack(5);
		IFSeqSnr.stepPack(5);
		IFSeqHat.stepPack(5);
		IFSeqBass.stepPack(5);
		IFSeqKeys.stepPack(5);
		IFSeqSamp.stepPack(5);
		IFSeqMopho.stepPack(5);
		IFSeqPat.stepPack(5);
		IFSeqVKick.stepPack(5);
		IFSeqVTomL.stepPack(5);
	}
	*st06{
		this.led06;
		IFSeqKick.stepPack(6);
		IFSeqSnr.stepPack(6);
		IFSeqHat.stepPack(6);
		IFSeqBass.stepPack(6);
		IFSeqKeys.stepPack(6);
		IFSeqSamp.stepPack(6);
		IFSeqMopho.stepPack(6);
		IFSeqPat.stepPack(6);
		IFSeqVKick.stepPack(6);
		IFSeqVTomL.stepPack(6);
	}
	*st07{
		this.led07;
		IFSeqKick.stepPack(7);
		IFSeqSnr.stepPack(7);
		IFSeqHat.stepPack(7);
		IFSeqBass.stepPack(7);
		IFSeqKeys.stepPack(7);
		IFSeqSamp.stepPack(7);
		IFSeqMopho.stepPack(7);
		IFSeqPat.stepPack(7);
		IFSeqVKick.stepPack(7);
		IFSeqVTomL.stepPack(7);
	}
	*st08{
		this.led08;
		IFSeqKick.stepPack(8);
		IFSeqSnr.stepPack(8);
		IFSeqHat.stepPack(8);
		IFSeqBass.stepPack(8);
		IFSeqKeys.stepPack(8);
		IFSeqSamp.stepPack(8);
		IFSeqMopho.stepPack(8);
		IFSeqPat.stepPack(8);
		IFSeqVKick.stepPack(8);
		IFSeqVTomL.stepPack(8);
	}
	*st09{
		this.led09;
		IFSeqKick.stepPack(9);
		IFSeqSnr.stepPack(9);
		IFSeqHat.stepPack(9);
		IFSeqBass.stepPack(9);
		IFSeqKeys.stepPack(9);
		IFSeqSamp.stepPack(9);
		IFSeqMopho.stepPack(9);
		IFSeqPat.stepPack(9);
		IFSeqVKick.stepPack(9);
		IFSeqVTomL.stepPack(9);
	}
	*st10{
		this.led10;
		IFSeqKick.stepPack(10);
		IFSeqSnr.stepPack(10);
		IFSeqHat.stepPack(10);
		IFSeqBass.stepPack(10);
		IFSeqKeys.stepPack(10);
		IFSeqSamp.stepPack(10);
		IFSeqMopho.stepPack(10);
		IFSeqPat.stepPack(10);
		IFSeqVKick.stepPack(10);
		IFSeqVTomL.stepPack(10);
	}
	*st11{
		this.led11;
		IFSeqKick.stepPack(11);
		IFSeqSnr.stepPack(11);
		IFSeqHat.stepPack(11);
		IFSeqBass.stepPack(11);
		IFSeqKeys.stepPack(11);
		IFSeqSamp.stepPack(11);
		IFSeqMopho.stepPack(11);
		IFSeqPat.stepPack(11);
		IFSeqVKick.stepPack(11);
		IFSeqVTomL.stepPack(11);
	}
	*st12{
		this.led12;
		IFSeqKick.stepPack(12);
		IFSeqSnr.stepPack(12);
		IFSeqHat.stepPack(12);
		IFSeqBass.stepPack(12);
		IFSeqKeys.stepPack(12);
		IFSeqSamp.stepPack(12);
		IFSeqMopho.stepPack(12);
		IFSeqPat.stepPack(12);
		IFSeqVKick.stepPack(12);
		IFSeqVTomL.stepPack(12);
	}
	*st13{
		this.led13;
		IFSeqKick.stepPack(13);
		IFSeqSnr.stepPack(13);
		IFSeqHat.stepPack(13);
		IFSeqBass.stepPack(13);
		IFSeqKeys.stepPack(13);
		IFSeqSamp.stepPack(13);
		IFSeqMopho.stepPack(13);
		IFSeqPat.stepPack(13);
		IFSeqVKick.stepPack(13);
		IFSeqVTomL.stepPack(13);
	}
	*st14{
		this.led14;
		IFSeqKick.stepPack(14);
		IFSeqSnr.stepPack(14);
		IFSeqHat.stepPack(14);
		IFSeqBass.stepPack(14);
		IFSeqKeys.stepPack(14);
		IFSeqSamp.stepPack(14);
		IFSeqMopho.stepPack(14);
		IFSeqPat.stepPack(14);
		IFSeqVKick.stepPack(14);
		IFSeqVTomL.stepPack(14);
	}
	*st15{
		this.led15;
		IFSeqKick.stepPack(15);
		IFSeqSnr.stepPack(15);
		IFSeqHat.stepPack(15);
		IFSeqBass.stepPack(15);
		IFSeqKeys.stepPack(15);
		IFSeqSamp.stepPack(15);
		IFSeqMopho.stepPack(15);
		IFSeqPat.stepPack(15);
		IFSeqVKick.stepPack(15);
		IFSeqVTomL.stepPack(15);
	}
	*st16{
		this.led16;
		IFSeqKick.stepPack(16);
		IFSeqSnr.stepPack(16);
		IFSeqHat.stepPack(16);
		IFSeqBass.stepPack(16);
		IFSeqKeys.stepPack(16);
		IFSeqSamp.stepPack(16);
		IFSeqMopho.stepPack(16);
		IFSeqPat.stepPack(16);
		IFSeqVKick.stepPack(16);
		IFSeqVTomL.stepPack(16);
	}
	*/

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
//SEQUENCER RECIEVER
		~seqReciever.free;
		~countSeqRec=1;
		~seqReciever= OSCFunc({
			arg msg;
			if ( msg[1]==1, {//"Transpose Shuffle".postln;
				~countSeqRec.switch(
					0,{
						"0".postln;
						~tOSCAdrr.sendMsg('seqLed08', 0);
						~countSeqRec = ~countSeqRec + 1;
					},
					1, {
						"1".postln;
						~tOSCAdrr.sendMsg('seqLed08', 0);
						~tOSCAdrr.sendMsg('seqLed01', 1);
						~countSeqRec = ~countSeqRec + 1;
					},
					2, {
						"2".postln;
						~tOSCAdrr.sendMsg('seqLed01', 0);
						~tOSCAdrr.sendMsg('seqLed02', 1);
						~countSeqRec = ~countSeqRec + 1;
					},
					3, {
						"3".postln;
						~tOSCAdrr.sendMsg('seqLed02', 0);
						~tOSCAdrr.sendMsg('seqLed03', 1);
						~countSeqRec = ~countSeqRec + 1;
					},
					4, {
						"4".postln;
						~tOSCAdrr.sendMsg('seqLed03', 0);
						~tOSCAdrr.sendMsg('seqLed04', 1);
						~countSeqRec = ~countSeqRec + 1;
					},
					5, {
						"5".postln;
						~tOSCAdrr.sendMsg('seqLed04', 0);
						~tOSCAdrr.sendMsg('seqLed05', 1);
						~countSeqRec = ~countSeqRec + 1;
					},
					6, {
						"6".postln;
						~tOSCAdrr.sendMsg('seqLed05', 0);
						~tOSCAdrr.sendMsg('seqLed06', 1);
						~countSeqRec = ~countSeqRec + 1;
					},
					7, {
						"7".postln;
						~tOSCAdrr.sendMsg('seqLed06', 0);
						~tOSCAdrr.sendMsg('seqLed07', 1);
						~countSeqRec = ~countSeqRec + 1;
					},
					8,{
						"8".postln;
						~tOSCAdrr.sendMsg('seqLed07', 0);
						~tOSCAdrr.sendMsg('seqLed08', 1);
						~countSeqRec=1;
					}

				)}
			);
			},
			'/seqRec'
		);

*/