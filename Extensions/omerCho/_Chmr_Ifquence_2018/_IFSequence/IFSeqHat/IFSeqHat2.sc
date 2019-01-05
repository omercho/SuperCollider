/*
IFSeqHat2.st16(0);
IFSeqHat2.stepPack(1);
*/

IFSeqHat2 {
	*loadAll {

		this.loadProxy;
		this.countReset;

		IFSeqNtHat2.loadAll;
		IFSeqVelHat2.loadAll;
		IFSeqSusHat2.loadAll;
		IFSeqDur2Hat.loadAll;
		IFSeqTm2Hat.loadAll;
		this.on;
	}

	*loadProxy {

		~seqHat2_01 = PatternProxy( Pseq([0], 1));
		~seqHat2_02 = PatternProxy( Pseq([0], 1));
		~seqHat2_03 = PatternProxy( Pseq([0], 1));
		~seqHat2_04 = PatternProxy( Pseq([0], 1));
		~seqHat2_05 = PatternProxy( Pseq([0], 1));
		~seqHat2_06 = PatternProxy( Pseq([0], 1));
		~seqHat2_07 = PatternProxy( Pseq([0], 1));
		~seqHat2_08 = PatternProxy( Pseq([0], 1));

		~seqHat2_09 = PatternProxy( Pseq([0], 1));
		~seqHat2_10 = PatternProxy( Pseq([0], 1));
		~seqHat2_11 = PatternProxy( Pseq([0], 1));
		~seqHat2_12 = PatternProxy( Pseq([0], 1));
		~seqHat2_13 = PatternProxy( Pseq([0], 1));
		~seqHat2_14 = PatternProxy( Pseq([0], 1));
		~seqHat2_15 = PatternProxy( Pseq([0], 1));
		~seqHat2_16 = PatternProxy( Pseq([0], 1));
	}


	*free {
		~cntSeqUpHat2_01=0;
		~cntSeqRandHat2_01=0;

		IFSeqHat2.st01(0);
		IFSeqHat2.st02(0);
		IFSeqHat2.st03(0);
		IFSeqHat2.st04(0);
		IFSeqHat2.st05(0);
		IFSeqHat2.st06(0);
		IFSeqHat2.st07(0);
		IFSeqHat2.st08(0);

		IFSeqHat2.st09(0);
		IFSeqHat2.st10(0);
		IFSeqHat2.st11(0);
		IFSeqHat2.st12(0);
		IFSeqHat2.st13(0);
		IFSeqHat2.st14(0);
		IFSeqHat2.st15(0);
		IFSeqHat2.st16(0);
	}

	*countReset {
		~cntSeqUpHat2_01=0;
		~cntSeqRandHat2_01=0;

		~cntSeqHat2_01=0;
		~cntSeqHat2_02=0;
		~cntSeqHat2_03=0;
		~cntSeqHat2_04=0;
		~cntSeqHat2_05=0;
		~cntSeqHat2_06=0;
		~cntSeqHat2_07=0;
		~cntSeqHat2_08=0;

		~cntSeqHat2_09=0;
		~cntSeqHat2_10=0;
		~cntSeqHat2_11=0;
		~cntSeqHat2_12=0;
		~cntSeqHat2_13=0;
		~cntSeqHat2_14=0;
		~cntSeqHat2_15=0;
		~cntSeqHat2_16=0;
	}

	*freeOn {

		~seqFreeHat2But.free;
		~seqFreeHat2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqHat2.free;
				});
			},
			'/seqFreeHat'
		);
	}
	*upOn {
		~ifSeqUpHat2But.free;
		~ifSeqUpHat2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqUpHat2_01 = ~cntSeqUpHat2_01 + 1;
				~cntSeqUpHat2_01.switch(
					0,{},
					1,{
						IFSeqHat2.stGrpSet(1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0);
					},
					2,{
						IFSeqHat2.stGrpSet(1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0);
					},
					3,{
						IFSeqHat2.stGrpSet(0,1,1,0,1,1,0,0,0,1,1,0,1,0,1,0);
					},
					4,{
						IFSeqHat2.stGrpSet(1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0);
						~cntSeqUpHat2_01=0;
					}
				)}
			);
			},
			'/seqUpHat2'
		);
	}

	*randOn {
		~ifSeqRandHat2But.free;
		~ifSeqRandHat2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqRandHat2_01 = ~cntSeqRandHat2_01 + 1;
				~cntSeqRandHat2_01.switch(
					0,{},
					1,{
						IFSeqHat2.st01([0,1].choose);
						IFSeqHat2.st02([0,1].choose);
						IFSeqHat2.st03([0,1].choose);
						IFSeqHat2.st04([0,1].choose);
						IFSeqHat2.st05([0,1].choose);
						IFSeqHat2.st06([0,1].choose);
						IFSeqHat2.st07([0,1].choose);
						IFSeqHat2.st08([0,1].choose);
						IFSeqHat2.st09([0,1].choose);
						IFSeqHat2.st10([0,1].choose);
						IFSeqHat2.st11([0,1].choose);
						IFSeqHat2.st12([0,1].choose);
						IFSeqHat2.st13([0,1].choose);
						IFSeqHat2.st14([0,1].choose);
						IFSeqHat2.st15([0,1].choose);
						IFSeqHat2.st16([0,1].choose);
						~cntSeqRandHat2_01=0;
					}
				)}
			);
			},
			'/seqRandHat2'
		);
	}

	*on {
		IFSeqHat2.upOn;
		IFSeqHat2.randOn;
		IFSeqHat2.freeOn;

		~ifSeqHat2But01.free;
		~ifSeqHat2But01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_01 = ~cntSeqHat2_01 + 1;
				~cntSeqHat2_01.switch(
					0,{}, 1,{IFSeqHat2.st01(1);}, 2,{IFSeqHat2.st01(0);}
				)}
			);
			},
			'/if2Seq/2/1'
		);
		~ifSeqHat2But02.free;
		~ifSeqHat2But02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_02 = ~cntSeqHat2_02 + 1;
				~cntSeqHat2_02.switch(
					0,{}, 1,{IFSeqHat2.st02(1);}, 2,{IFSeqHat2.st02(0);}
				)}
			);
			},
			'/if2Seq/2/2'
		);
		~ifSeqHat2But03.free;
		~ifSeqHat2But03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_03 = ~cntSeqHat2_03 + 1;
				~cntSeqHat2_03.switch(
					0,{}, 1,{IFSeqHat2.st03(1);}, 2,{IFSeqHat2.st03(0);}
				)}
			);
			},
			'/if2Seq/2/3'
		);
		~ifSeqHat2But04.free;
		~ifSeqHat2But04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_04 = ~cntSeqHat2_04 + 1;
				~cntSeqHat2_04.switch(
					0,{}, 1,{IFSeqHat2.st04(1);}, 2,{IFSeqHat2.st04(0);}
				)}
			);
			},
			'/if2Seq/2/4'
		);
		~ifSeqHat2But05.free;
		~ifSeqHat2But05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_05 = ~cntSeqHat2_05 + 1;
				~cntSeqHat2_05.switch(
					0,{}, 1,{IFSeqHat2.st05(1);}, 2,{IFSeqHat2.st05(0);}
				)}
			);
			},
			'/if2Seq/2/5'
		);
		~ifSeqHat2But06.free;
		~ifSeqHat2But06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_06 = ~cntSeqHat2_06 + 1;
				~cntSeqHat2_06.switch(
					0,{}, 1,{IFSeqHat2.st06(1);}, 2,{IFSeqHat2.st06(0);}
				)}
			);
			},
			'/if2Seq/2/6'
		);
		~ifSeqHat2But07.free;
		~ifSeqHat2But07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_07 = ~cntSeqHat2_07 + 1;
				~cntSeqHat2_07.switch(
					0,{}, 1,{IFSeqHat2.st07(1);}, 2,{IFSeqHat2.st07(0);}
				)}
			);
			},
			'/if2Seq/2/7'
		);
		~ifSeqHat2But08.free;
		~ifSeqHat2But08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_08 = ~cntSeqHat2_08 + 1;
				~cntSeqHat2_08.switch(
					0,{}, 1,{IFSeqHat2.st08(1);}, 2,{IFSeqHat2.st08(0);}
				)}
			);
			},
			'/if2Seq/2/8'
		);

		~ifSeqHat2But09.free;
		~ifSeqHat2But09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_09 = ~cntSeqHat2_09 + 1;
				~cntSeqHat2_09.switch(
					0,{}, 1,{IFSeqHat2.st09(1);}, 2,{IFSeqHat2.st09(0);}
				)}
			);
			},
			'/if2Seq/2/9'
		);
		~ifSeqHat2But10.free;
		~ifSeqHat2But10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_10 = ~cntSeqHat2_10 + 1;
				~cntSeqHat2_10.switch(
					0,{}, 1,{IFSeqHat2.st10(1);}, 2,{IFSeqHat2.st10(0);}
				)}
			);
			},
			'/if2Seq/2/10'
		);
		~ifSeqHat2But11.free;
		~ifSeqHat2But11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_11 = ~cntSeqHat2_11 + 1;
				~cntSeqHat2_11.switch(
					0,{}, 1,{IFSeqHat2.st11(1);}, 2,{IFSeqHat2.st11(0);}
				)}
			);
			},
			'/if2Seq/2/11'
		);
		~ifSeqHat2But12.free;
		~ifSeqHat2But12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_12 = ~cntSeqHat2_12 + 1;
				~cntSeqHat2_12.switch(
					0,{}, 1,{IFSeqHat2.st12(1);}, 2,{IFSeqHat2.st12(0);}
				)}
			);
			},
			'/if2Seq/2/12'
		);
		~ifSeqHat2But13.free;
		~ifSeqHat2But13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_13 = ~cntSeqHat2_13 + 1;
				~cntSeqHat2_13.switch(
					0,{}, 1,{IFSeqHat2.st13(1);}, 2,{IFSeqHat2.st13(0);}
				)}
			);
			},
			'/if2Seq/2/13'
		);
		~ifSeqHat2But14.free;
		~ifSeqHat2But14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_14 = ~cntSeqHat2_14 + 1;
				~cntSeqHat2_14.switch(
					0,{}, 1,{IFSeqHat2.st14(1);}, 2,{IFSeqHat2.st14(0);}
				)}
			);
			},
			'/if2Seq/2/14'
		);
		~ifSeqHat2But15.free;
		~ifSeqHat2But15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_15 = ~cntSeqHat2_15 + 1;
				~cntSeqHat2_15.switch(
					0,{}, 1,{IFSeqHat2.st15(1);}, 2,{IFSeqHat2.st15(0);}
				)}
			);
			},
			'/if2Seq/2/15'
		);
		~ifSeqHat2But16.free;
		~ifSeqHat2But16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat2_16 = ~cntSeqHat2_16 + 1;
				~cntSeqHat2_16.switch(
					0,{}, 1,{IFSeqHat2.st16(1);}, 2,{IFSeqHat2.st16(0);}
				)}
			);
			},
			'/if2Seq/2/16'
		);


	}

	*st01 {|i|
		~cntSeqHat2_01=i;
		~seqHat2_01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_01', i);
	}
	*st02 {|i|
		~cntSeqHat2_02=i;
		~seqHat2_02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_02', i);
	}
	*st03 {|i|
		~cntSeqHat2_03=i;
		~seqHat2_03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_03', i);
	}
	*st04 {|i|
		~cntSeqHat2_04=i;
		~seqHat2_04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_04', i);
	}
	*st05 {|i|
		~cntSeqHat2_05=i;
		~seqHat2_05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_05', i);
	}
	*st06 {|i|
		~cntSeqHat2_06=i;
		~seqHat2_06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_06', i);
	}
	*st07 {|i|
		~cntSeqHat2_07=i;
		~seqHat2_07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_07', i);
	}
	*st08 {|i|
		~cntSeqHat2_08=i;
		~seqHat2_08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_08', i);
	}

	*st09 {|i|
		~cntSeqHat2_09=i;
		~seqHat2_09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_09', i);
	}
	*st10 {|i|
		~cntSeqHat2_10=i;
		~seqHat2_10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_10', i);
	}
	*st11 {|i|
		~cntSeqHat2_11=i;
		~seqHat2_11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_11', i);
	}
	*st12 {|i|
		~cntSeqHat2_12=i;
		~seqHat2_12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_12', i);
	}
	*st13 {|i|
		~cntSeqHat2_13=i;
		~seqHat2_13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_13', i);
	}
	*st14 {|i|
		~cntSeqHat2_14=i;
		~seqHat2_14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_14', i);
	}
	*st15 {|i|
		~cntSeqHat2_15=i;
		~seqHat2_15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_15', i);
	}
	*st16 {|i|
		~cntSeqHat2_16=i;
		~seqHat2_16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat2_16', i);
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
		~amp2Hat.source  =  Pseq([~seqHat2_01.next*~seqVelHat2_01.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_01.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_01.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat01.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat01.next], inf);
	}
	*step02{
		~amp2Hat.source  =  Pseq([~seqHat2_02.next*~seqVelHat2_02.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_02.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_02.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat02.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat02.next], inf);
	}
	*step03{
		~amp2Hat.source  =  Pseq([~seqHat2_03.next*~seqVelHat2_03.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_03.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_03.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat03.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat03.next], inf);
	}
	*step04{
		~amp2Hat.source  =  Pseq([~seqHat2_04.next*~seqVelHat2_04.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_04.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_04.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat04.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat04.next], inf);
	}
	*step05{
		~amp2Hat.source  =  Pseq([~seqHat2_05.next*~seqVelHat2_05.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_05.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_05.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat05.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat05.next], inf);
	}
	*step06{
		~amp2Hat.source  =  Pseq([~seqHat2_06.next*~seqVelHat2_06.next], inf);
		~octHat.source = Pseq([~seqOctHat06.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_06.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_06.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat06.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat06.next], inf);
	}
	*step07{
		~amp2Hat.source  =  Pseq([~seqHat2_07.next*~seqVelHat2_07.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_07.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_07.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat07.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat07.next], inf);
	}
	*step08{
		~amp2Hat.source  =  Pseq([~seqHat2_08.next*~seqVelHat2_08.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_08.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_08.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat08.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat08.next], inf);
	}
	*step09{
		~amp2Hat.source  =  Pseq([~seqHat2_09.next*~seqVelHat2_09.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_09.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_09.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat09.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat09.next], inf);
	}
	*step10{
		~amp2Hat.source  =  Pseq([~seqHat2_10.next*~seqVelHat2_10.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_10.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_10.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat10.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat10.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat10.next], inf);
	}
	*step11{
		~amp2Hat.source  =  Pseq([~seqHat2_11.next*~seqVelHat2_11.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_11.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_11.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat11.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat11.next], inf);
	}
	*step12{
		~amp2Hat.source  =  Pseq([~seqHat2_12.next*~seqVelHat2_12.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_12.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_12.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat12.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat12.next], inf);
	}
	*step13{
		~amp2Hat.source  =  Pseq([~seqHat2_13.next*~seqVelHat2_13.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_13.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_13.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat13.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat13.next], inf);
	}
	*step14{
		~amp2Hat.source  =  Pseq([~seqHat2_14.next*~seqVelHat2_14.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_14.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_14.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat14.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat14.next], inf);
	}
	*step15{
		~amp2Hat.source  =  Pseq([~seqHat2_15.next*~seqVelHat2_15.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_15.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_15.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat15.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat15.next], inf);
	}
	*step16{
		~amp2Hat.source  =  Pseq([~seqHat2_16.next*~seqVelHat2_16.next], inf);
		~nt2Hat.source   =  Pseq([~seqNtHat2_16.next], inf);
		~sus2Hat.source  =  Pseq([~seqSusHat2_16.next], inf);
		~tm2Hat.source    =  Pseq([~seqTm2Hat16.next], inf);
		~dur2Hat.source    =  Pseq([~seqDur2Hat16.next], inf);
	}

	*stGrp {|i|

		IFSeqHat2.st01(i); IFSeqHat2.st02(i); IFSeqHat2.st03(i); IFSeqHat2.st04(i);
		IFSeqHat2.st05(i); IFSeqHat2.st06(i); IFSeqHat2.st07(i); IFSeqHat2.st08(i);
		IFSeqHat2.st09(i); IFSeqHat2.st10(i); IFSeqHat2.st11(i); IFSeqHat2.st12(i);
		IFSeqHat2.st13(i); IFSeqHat2.st14(i); IFSeqHat2.st15(i); IFSeqHat2.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqHat2.st01(s01); IFSeqHat2.st02(s02); IFSeqHat2.st03(s03); IFSeqHat2.st04(s04);
		IFSeqHat2.st05(s05); IFSeqHat2.st06(s06); IFSeqHat2.st07(s07); IFSeqHat2.st08(s08);
		IFSeqHat2.st09(s09); IFSeqHat2.st10(s10); IFSeqHat2.st11(s11); IFSeqHat2.st12(s12);
		IFSeqHat2.st13(s13); IFSeqHat2.st14(s14); IFSeqHat2.st15(s15); IFSeqHat2.st16(s16);
	}
}

