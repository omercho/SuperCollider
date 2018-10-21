/*
IFSeqMopho.st16(0);
IFSeqMopho.stepPack(1);
*/

IFSeqMopho {
	*loadAll {

		this.loadProxy;
		this.countReset;

		IFSeqOctMopho.loadAll;
		IFSeqNtMopho.loadAll;
		IFSeqVelMopho.loadAll;
		IFSeqSusMopho.loadAll;
		IFSeqTmMopho.loadAll;
		IFSeqDurMopho.loadAll;
		this.on;
	}

	*loadProxy {

		~seqMopho01 = PatternProxy( Pseq([0], 1));
		~seqMopho02 = PatternProxy( Pseq([0], 1));
		~seqMopho03 = PatternProxy( Pseq([0], 1));
		~seqMopho04 = PatternProxy( Pseq([0], 1));
		~seqMopho05 = PatternProxy( Pseq([0], 1));
		~seqMopho06 = PatternProxy( Pseq([0], 1));
		~seqMopho07 = PatternProxy( Pseq([0], 1));
		~seqMopho08 = PatternProxy( Pseq([0], 1));

		~seqMopho09 = PatternProxy( Pseq([0], 1));
		~seqMopho10 = PatternProxy( Pseq([0], 1));
		~seqMopho11 = PatternProxy( Pseq([0], 1));
		~seqMopho12 = PatternProxy( Pseq([0], 1));
		~seqMopho13 = PatternProxy( Pseq([0], 1));
		~seqMopho14 = PatternProxy( Pseq([0], 1));
		~seqMopho15 = PatternProxy( Pseq([0], 1));
		~seqMopho16 = PatternProxy( Pseq([0], 1));
	}


	*free {
		~cntSeqUpMopho01=0;
		~cntSeqRandMopho01=0;

		IFSeqMopho.st01(0);
		IFSeqMopho.st02(0);
		IFSeqMopho.st03(0);
		IFSeqMopho.st04(0);
		IFSeqMopho.st05(0);
		IFSeqMopho.st06(0);
		IFSeqMopho.st07(0);
		IFSeqMopho.st08(0);

		IFSeqMopho.st09(0);
		IFSeqMopho.st10(0);
		IFSeqMopho.st11(0);
		IFSeqMopho.st12(0);
		IFSeqMopho.st13(0);
		IFSeqMopho.st14(0);
		IFSeqMopho.st15(0);
		IFSeqMopho.st16(0);
	}

	*countReset {
		~cntSeqUpMopho01=0;
		~cntSeqRandMopho01=0;

		~cntSeqMopho01=0;
		~cntSeqMopho02=0;
		~cntSeqMopho03=0;
		~cntSeqMopho04=0;
		~cntSeqMopho05=0;
		~cntSeqMopho06=0;
		~cntSeqMopho07=0;
		~cntSeqMopho08=0;

		~cntSeqMopho09=0;
		~cntSeqMopho10=0;
		~cntSeqMopho11=0;
		~cntSeqMopho12=0;
		~cntSeqMopho13=0;
		~cntSeqMopho14=0;
		~cntSeqMopho15=0;
		~cntSeqMopho16=0;
	}

	*freeOn {

		~seqFreeMophoBut.free;
		~seqFreeMophoBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqMopho.free;
				});
			},
			'/seqFreeMopho'
		);
	}
	*upOn {
		~ifSeqUpMophoBut.free;
		~ifSeqUpMophoBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqUpMopho01 = ~cntSeqUpMopho01 + 1;
				~cntSeqUpMopho01.switch(
					0,{},
					1,{
						IFSeqMopho.stGrp(1);
						IFSeqOctMopho.stGrpSet(3,3,3,3,3,3,3,4,4,4,4,4,4,4,5,5);
						IFSeqNtMopho.stGrpSet(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
						IFSeqVelMopho.stGrpSet(3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3);
						IFSeqSusMopho.stGrp(1);
						IFSeqTmMopho.stGrp(1);
					},
					2,{
						IFSeqMopho.stGrpSet(1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,0);
					},
					3,{
						IFSeqMopho.stGrpSet(0,1,1,0,1,1,0,0,0,1,1,0,1,0,1,0);
					},
					4,{
						IFSeqMopho.stGrpSet(1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0);
						~cntSeqUpMopho01=0;
					}
				)}
			);
			},
			'/seqUpMopho'
		);
	}

	*randOn {
		~ifSeqRandMophoBut.free;
		~ifSeqRandMophoBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqRandMopho01 = ~cntSeqRandMopho01 + 1;
				~cntSeqRandMopho01.switch(
					0,{},
					1,{
						IFSeqMopho.st01([0,1].choose);
						IFSeqMopho.st02([0,1].choose);
						IFSeqMopho.st03([0,1].choose);
						IFSeqMopho.st04([0,1].choose);
						IFSeqMopho.st05([0,1].choose);
						IFSeqMopho.st06([0,1].choose);
						IFSeqMopho.st07([0,1].choose);
						IFSeqMopho.st08([0,1].choose);
						IFSeqMopho.st09([0,1].choose);
						IFSeqMopho.st10([0,1].choose);
						IFSeqMopho.st11([0,1].choose);
						IFSeqMopho.st12([0,1].choose);
						IFSeqMopho.st13([0,1].choose);
						IFSeqMopho.st14([0,1].choose);
						IFSeqMopho.st15([0,1].choose);
						IFSeqMopho.st16([0,1].choose);
						~cntSeqRandMopho01=0;
					}
				)}
			);
			},
			'/seqRandMopho'
		);
	}

	*on {
		IFSeqMopho.upOn;
		IFSeqMopho.randOn;
		IFSeqMopho.freeOn;

		~ifSeqMophoBut01.free;
		~ifSeqMophoBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho01 = ~cntSeqMopho01 + 1;
				~cntSeqMopho01.switch(
					0,{}, 1,{IFSeqMopho.st01(1);}, 2,{IFSeqMopho.st01(0);}
				)}
			);
			},
			'/ifSeq/7/1'
		);
		~ifSeqMophoBut02.free;
		~ifSeqMophoBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho02 = ~cntSeqMopho02 + 1;
				~cntSeqMopho02.switch(
					0,{}, 1,{IFSeqMopho.st02(1);}, 2,{IFSeqMopho.st02(0);}
				)}
			);
			},
			'/ifSeq/7/2'
		);
		~ifSeqMophoBut03.free;
		~ifSeqMophoBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho03 = ~cntSeqMopho03 + 1;
				~cntSeqMopho03.switch(
					0,{}, 1,{IFSeqMopho.st03(1);}, 2,{IFSeqMopho.st03(0);}
				)}
			);
			},
			'/ifSeq/7/3'
		);
		~ifSeqMophoBut04.free;
		~ifSeqMophoBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho04 = ~cntSeqMopho04 + 1;
				~cntSeqMopho04.switch(
					0,{}, 1,{IFSeqMopho.st04(1);}, 2,{IFSeqMopho.st04(0);}
				)}
			);
			},
			'/ifSeq/7/4'
		);
		~ifSeqMophoBut05.free;
		~ifSeqMophoBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho05 = ~cntSeqMopho05 + 1;
				~cntSeqMopho05.switch(
					0,{}, 1,{IFSeqMopho.st05(1);}, 2,{IFSeqMopho.st05(0);}
				)}
			);
			},
			'/ifSeq/7/5'
		);
		~ifSeqMophoBut06.free;
		~ifSeqMophoBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho06 = ~cntSeqMopho06 + 1;
				~cntSeqMopho06.switch(
					0,{}, 1,{IFSeqMopho.st06(1);}, 2,{IFSeqMopho.st06(0);}
				)}
			);
			},
			'/ifSeq/7/6'
		);
		~ifSeqMophoBut07.free;
		~ifSeqMophoBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho07 = ~cntSeqMopho07 + 1;
				~cntSeqMopho07.switch(
					0,{}, 1,{IFSeqMopho.st07(1);}, 2,{IFSeqMopho.st07(0);}
				)}
			);
			},
			'/ifSeq/7/7'
		);
		~ifSeqMophoBut08.free;
		~ifSeqMophoBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho08 = ~cntSeqMopho08 + 1;
				~cntSeqMopho08.switch(
					0,{}, 1,{IFSeqMopho.st08(1);}, 2,{IFSeqMopho.st08(0);}
				)}
			);
			},
			'/ifSeq/7/8'
		);

		~ifSeqMophoBut09.free;
		~ifSeqMophoBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho09 = ~cntSeqMopho09 + 1;
				~cntSeqMopho09.switch(
					0,{}, 1,{IFSeqMopho.st09(1);}, 2,{IFSeqMopho.st09(0);}
				)}
			);
			},
			'/ifSeq/7/9'
		);
		~ifSeqMophoBut10.free;
		~ifSeqMophoBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho10 = ~cntSeqMopho10 + 1;
				~cntSeqMopho10.switch(
					0,{}, 1,{IFSeqMopho.st10(1);}, 2,{IFSeqMopho.st10(0);}
				)}
			);
			},
			'/ifSeq/7/10'
		);
		~ifSeqMophoBut11.free;
		~ifSeqMophoBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho11 = ~cntSeqMopho11 + 1;
				~cntSeqMopho11.switch(
					0,{}, 1,{IFSeqMopho.st11(1);}, 2,{IFSeqMopho.st11(0);}
				)}
			);
			},
			'/ifSeq/7/11'
		);
		~ifSeqMophoBut12.free;
		~ifSeqMophoBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho12 = ~cntSeqMopho12 + 1;
				~cntSeqMopho12.switch(
					0,{}, 1,{IFSeqMopho.st12(1);}, 2,{IFSeqMopho.st12(0);}
				)}
			);
			},
			'/ifSeq/7/12'
		);
		~ifSeqMophoBut13.free;
		~ifSeqMophoBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho13 = ~cntSeqMopho13 + 1;
				~cntSeqMopho13.switch(
					0,{}, 1,{IFSeqMopho.st13(1);}, 2,{IFSeqMopho.st13(0);}
				)}
			);
			},
			'/ifSeq/7/13'
		);
		~ifSeqMophoBut14.free;
		~ifSeqMophoBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho14 = ~cntSeqMopho14 + 1;
				~cntSeqMopho14.switch(
					0,{}, 1,{IFSeqMopho.st14(1);}, 2,{IFSeqMopho.st14(0);}
				)}
			);
			},
			'/ifSeq/7/14'
		);
		~ifSeqMophoBut15.free;
		~ifSeqMophoBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho15 = ~cntSeqMopho15 + 1;
				~cntSeqMopho15.switch(
					0,{}, 1,{IFSeqMopho.st15(1);}, 2,{IFSeqMopho.st15(0);}
				)}
			);
			},
			'/ifSeq/7/15'
		);
		~ifSeqMophoBut16.free;
		~ifSeqMophoBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqMopho16 = ~cntSeqMopho16 + 1;
				~cntSeqMopho16.switch(
					0,{}, 1,{IFSeqMopho.st16(1);}, 2,{IFSeqMopho.st16(0);}
				)}
			);
			},
			'/ifSeq/7/16'
		);


	}

	*st01 {|i|
		~cntSeqMopho01=i;
		~seqMopho01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho01', i);
	}
	*st02 {|i|
		~cntSeqMopho02=i;
		~seqMopho02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho02', i);
	}
	*st03 {|i|
		~cntSeqMopho03=i;
		~seqMopho03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho03', i);
	}
	*st04 {|i|
		~cntSeqMopho04=i;
		~seqMopho04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho04', i);
	}
	*st05 {|i|
		~cntSeqMopho05=i;
		~seqMopho05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho05', i);
	}
	*st06 {|i|
		~cntSeqMopho06=i;
		~seqMopho06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho06', i);
	}
	*st07 {|i|
		~cntSeqMopho07=i;
		~seqMopho07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho07', i);
	}
	*st08 {|i|
		~cntSeqMopho08=i;
		~seqMopho08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho08', i);
	}

	*st09 {|i|
		~cntSeqMopho09=i;
		~seqMopho09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho09', i);
	}
	*st10 {|i|
		~cntSeqMopho10=i;
		~seqMopho10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho10', i);
	}
	*st11 {|i|
		~cntSeqMopho11=i;
		~seqMopho11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho11', i);
	}
	*st12 {|i|
		~cntSeqMopho12=i;
		~seqMopho12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho12', i);
	}
	*st13 {|i|
		~cntSeqMopho13=i;
		~seqMopho13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho13', i);
	}
	*st14 {|i|
		~cntSeqMopho14=i;
		~seqMopho14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho14', i);
	}
	*st15 {|i|
		~cntSeqMopho15=i;
		~seqMopho15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho15', i);
	}
	*st16 {|i|
		~cntSeqMopho16=i;
		~seqMopho16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledMopho16', i);
	}

	*stepPack{|i|
		case
		{ i == 1 } { this.step01;  }
		{ i == 2 } { this.step02; }
		{ i == 3 } { this.step03; }
		{ i == 4 } { this.step04; }
		{ i == 5 } { this.step05; }
		{ i == 6 } { this.step06; }
		{ i == 7 } { this.step07; }
		{ i == 8 } { this.step08; }

		{ i == 9 } { this.step09; }
		{ i == 10 } { this.step10; }
		{ i == 11 } { this.step11; }
		{ i == 12 } { this.step12; }
		{ i == 13 } { this.step13; }
		{ i == 14 } { this.step14; }
		{ i == 15 } { this.step15; }
		{ i == 16 } { this.step16; };
	}

	*step01{
		~amp1Mopho.source  =  Pseq([~seqMopho01.next*~seqVelMopho01.next], inf);
		~octMopho.source = Pseq([~seqOctMopho01.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho01.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho01.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho01.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho01.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho01.next], inf);
	}
	*step02{
		~amp1Mopho.source  =  Pseq([~seqMopho02.next*~seqVelMopho02.next], inf);
		~octMopho.source = Pseq([~seqOctMopho02.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho02.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho02.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho02.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho02.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho02.next], inf);
	}
	*step03{
		~amp1Mopho.source  =  Pseq([~seqMopho03.next*~seqVelMopho03.next], inf);
		~octMopho.source = Pseq([~seqOctMopho03.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho03.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho03.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho03.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho03.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho03.next], inf);
	}
	*step04{
		~amp1Mopho.source  =  Pseq([~seqMopho04.next*~seqVelMopho04.next], inf);
		~octMopho.source = Pseq([~seqOctMopho04.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho04.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho04.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho04.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho04.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho04.next], inf);
	}
	*step05{
		~amp1Mopho.source  =  Pseq([~seqMopho05.next*~seqVelMopho05.next], inf);
		~octMopho.source = Pseq([~seqOctMopho05.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho05.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho05.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho05.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho05.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho05.next], inf);
	}
	*step06{
		~amp1Mopho.source  =  Pseq([~seqMopho06.next*~seqVelMopho06.next], inf);
		~octMopho.source = Pseq([~seqOctMopho06.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho06.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho06.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho06.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho06.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho06.next], inf);
	}
	*step07{
		~amp1Mopho.source  =  Pseq([~seqMopho07.next*~seqVelMopho07.next], inf);
		~octMopho.source = Pseq([~seqOctMopho07.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho07.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho07.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho07.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho07.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho07.next], inf);
	}
	*step08{
		~amp1Mopho.source  =  Pseq([~seqMopho08.next*~seqVelMopho08.next], inf);
		~octMopho.source = Pseq([~seqOctMopho08.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho08.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho08.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho08.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho08.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho08.next], inf);
	}
	*step09{
		~amp1Mopho.source  =  Pseq([~seqMopho09.next*~seqVelMopho09.next], inf);
		~octMopho.source = Pseq([~seqOctMopho09.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho09.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho09.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho09.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho09.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho09.next], inf);
	}
	*step10{
		~amp1Mopho.source  =  Pseq([~seqMopho10.next*~seqVelMopho10.next], inf);
		~octMopho.source = Pseq([~seqOctMopho10.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho10.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho10.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho10.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho10.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho10.next], inf);
	}
	*step11{
		~amp1Mopho.source  =  Pseq([~seqMopho11.next*~seqVelMopho11.next], inf);
		~octMopho.source = Pseq([~seqOctMopho11.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho11.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho11.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho11.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho11.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho11.next], inf);
	}
	*step12{
		~amp1Mopho.source  =  Pseq([~seqMopho12.next*~seqVelMopho12.next], inf);
		~octMopho.source = Pseq([~seqOctMopho12.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho12.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho12.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho12.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho12.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho12.next], inf);
	}
	*step13{
		~amp1Mopho.source  =  Pseq([~seqMopho13.next*~seqVelMopho13.next], inf);
		~octMopho.source = Pseq([~seqOctMopho13.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho13.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho13.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho13.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho13.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho13.next], inf);
	}
	*step14{
		~amp1Mopho.source  =  Pseq([~seqMopho14.next*~seqVelMopho14.next], inf);
		~octMopho.source = Pseq([~seqOctMopho14.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho14.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho14.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho14.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho14.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho14.next], inf);
	}
	*step15{
		~amp1Mopho.source  =  Pseq([~seqMopho15.next*~seqVelMopho15.next], inf);
		~octMopho.source = Pseq([~seqOctMopho15.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho15.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho15.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho15.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho15.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho15.next], inf);
	}
	*step16{
		~amp1Mopho.source  =  Pseq([~seqMopho16.next*~seqVelMopho16.next], inf);
		~octMopho.source = Pseq([~seqOctMopho16.next], inf);
		~nt1Mopho.source   =  Pseq([~seqNtMopho16.next], inf);
		~sus1Mopho.source  =  Pseq([~seqSusMopho16.next], inf);
		~tmMopho.source    =  Pseq([~seqTmMopho16.next], inf);
		~dur1Mopho.source    =  Pseq([~seqDurMopho16.next], inf);
		~ampStMopho.source  =  Pseq([~seqStMopho16.next], inf);
	}
	*stGrp {|i|

		IFSeqMopho.st01(i); IFSeqMopho.st02(i); IFSeqMopho.st03(i); IFSeqMopho.st04(i);
		IFSeqMopho.st05(i); IFSeqMopho.st06(i); IFSeqMopho.st07(i); IFSeqMopho.st08(i);
		IFSeqMopho.st09(i); IFSeqMopho.st10(i); IFSeqMopho.st11(i); IFSeqMopho.st12(i);
		IFSeqMopho.st13(i); IFSeqMopho.st14(i); IFSeqMopho.st15(i); IFSeqMopho.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqMopho.st01(s01); IFSeqMopho.st02(s02); IFSeqMopho.st03(s03); IFSeqMopho.st04(s04);
		IFSeqMopho.st05(s05); IFSeqMopho.st06(s06); IFSeqMopho.st07(s07); IFSeqMopho.st08(s08);
		IFSeqMopho.st09(s09); IFSeqMopho.st10(s10); IFSeqMopho.st11(s11); IFSeqMopho.st12(s12);
		IFSeqMopho.st13(s13); IFSeqMopho.st14(s14); IFSeqMopho.st15(s15); IFSeqMopho.st16(s16);
	}

}

