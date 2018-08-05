/*
IFSeqSnr2.st16(0);
IFSeqSnr2.stepPack(1);
*/

IFSeqSnr2 {
	*loadAll {

		this.loadProxy;
		this.countReset;

		IFSeqNtSnr2.loadAll;
		IFSeqVelSnr2.loadAll;
		IFSeqSusSnr2.loadAll;
		this.on;
	}

	*loadProxy {

		~seqSnr2_01 = PatternProxy( Pseq([0], 1));
		~seqSnr2_02 = PatternProxy( Pseq([0], 1));
		~seqSnr2_03 = PatternProxy( Pseq([0], 1));
		~seqSnr2_04 = PatternProxy( Pseq([0], 1));
		~seqSnr2_05 = PatternProxy( Pseq([0], 1));
		~seqSnr2_06 = PatternProxy( Pseq([0], 1));
		~seqSnr2_07 = PatternProxy( Pseq([0], 1));
		~seqSnr2_08 = PatternProxy( Pseq([0], 1));

		~seqSnr2_09 = PatternProxy( Pseq([0], 1));
		~seqSnr2_10 = PatternProxy( Pseq([0], 1));
		~seqSnr2_11 = PatternProxy( Pseq([0], 1));
		~seqSnr2_12 = PatternProxy( Pseq([0], 1));
		~seqSnr2_13 = PatternProxy( Pseq([0], 1));
		~seqSnr2_14 = PatternProxy( Pseq([0], 1));
		~seqSnr2_15 = PatternProxy( Pseq([0], 1));
		~seqSnr2_16 = PatternProxy( Pseq([0], 1));
	}


	*free {
		~cntSeqUpSnr2_01=0;
		~cntSeqRandSnr2_01=0;

		IFSeqSnr2.st01(0);
		IFSeqSnr2.st02(0);
		IFSeqSnr2.st03(0);
		IFSeqSnr2.st04(0);
		IFSeqSnr2.st05(0);
		IFSeqSnr2.st06(0);
		IFSeqSnr2.st07(0);
		IFSeqSnr2.st08(0);

		IFSeqSnr2.st09(0);
		IFSeqSnr2.st10(0);
		IFSeqSnr2.st11(0);
		IFSeqSnr2.st12(0);
		IFSeqSnr2.st13(0);
		IFSeqSnr2.st14(0);
		IFSeqSnr2.st15(0);
		IFSeqSnr2.st16(0);
	}

	*countReset {
		~cntSeqUpSnr2_01=0;
		~cntSeqRandSnr2_01=0;

		~cntSeqSnr2_01=0;
		~cntSeqSnr2_02=0;
		~cntSeqSnr2_03=0;
		~cntSeqSnr2_04=0;
		~cntSeqSnr2_05=0;
		~cntSeqSnr2_06=0;
		~cntSeqSnr2_07=0;
		~cntSeqSnr2_08=0;

		~cntSeqSnr2_09=0;
		~cntSeqSnr2_10=0;
		~cntSeqSnr2_11=0;
		~cntSeqSnr2_12=0;
		~cntSeqSnr2_13=0;
		~cntSeqSnr2_14=0;
		~cntSeqSnr2_15=0;
		~cntSeqSnr2_16=0;
	}

	*freeOn {

		~seqFreeSnr2But.free;
		~seqFreeSnr2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSnr2.free;
				});
			},
			'/seqFreeSnr'
		);
	}
	*upOn {
		~ifSeqUpSnr2But.free;
		~ifSeqUpSnr2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqUpSnr2_01 = ~cntSeqUpSnr2_01 + 1;
				~cntSeqUpSnr2_01.switch(
					0,{},
					1,{
						IFSeqSnr2.stGrpSet(1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0);
					},
					2,{
						IFSeqSnr2.stGrpSet(1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0);
					},
					3,{
						IFSeqSnr2.stGrpSet(0,1,1,0,1,1,0,0,0,1,1,0,1,0,1,0);
					},
					4,{
						IFSeqSnr2.stGrpSet(1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0);
						~cntSeqUpSnr2_01=0;
					}
				)}
			);
			},
			'/seqUpSnr2'
		);
	}

	*randOn {
		~ifSeqRandSnr2But.free;
		~ifSeqRandSnr2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqRandSnr2_01 = ~cntSeqRandSnr2_01 + 1;
				~cntSeqRandSnr2_01.switch(
					0,{},
					1,{
						IFSeqSnr2.st01([0,1].choose);
						IFSeqSnr2.st02([0,1].choose);
						IFSeqSnr2.st03([0,1].choose);
						IFSeqSnr2.st04([0,1].choose);
						IFSeqSnr2.st05([0,1].choose);
						IFSeqSnr2.st06([0,1].choose);
						IFSeqSnr2.st07([0,1].choose);
						IFSeqSnr2.st08([0,1].choose);
						IFSeqSnr2.st09([0,1].choose);
						IFSeqSnr2.st10([0,1].choose);
						IFSeqSnr2.st11([0,1].choose);
						IFSeqSnr2.st12([0,1].choose);
						IFSeqSnr2.st13([0,1].choose);
						IFSeqSnr2.st14([0,1].choose);
						IFSeqSnr2.st15([0,1].choose);
						IFSeqSnr2.st16([0,1].choose);
						~cntSeqRandSnr2_01=0;
					}
				)}
			);
			},
			'/seqRandSnr2'
		);
	}

	*on {
		IFSeqSnr2.upOn;
		IFSeqSnr2.randOn;
		IFSeqSnr2.freeOn;

		~ifSeqSnr2But01.free;
		~ifSeqSnr2But01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_01 = ~cntSeqSnr2_01 + 1;
				~cntSeqSnr2_01.switch(
					0,{}, 1,{IFSeqSnr2.st01(1);}, 2,{IFSeqSnr2.st01(0);}
				)}
			);
			},
			'/if2Seq/2/1'
		);
		~ifSeqSnr2But02.free;
		~ifSeqSnr2But02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_02 = ~cntSeqSnr2_02 + 1;
				~cntSeqSnr2_02.switch(
					0,{}, 1,{IFSeqSnr2.st02(1);}, 2,{IFSeqSnr2.st02(0);}
				)}
			);
			},
			'/if2Seq/2/2'
		);
		~ifSeqSnr2But03.free;
		~ifSeqSnr2But03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_03 = ~cntSeqSnr2_03 + 1;
				~cntSeqSnr2_03.switch(
					0,{}, 1,{IFSeqSnr2.st03(1);}, 2,{IFSeqSnr2.st03(0);}
				)}
			);
			},
			'/if2Seq/2/3'
		);
		~ifSeqSnr2But04.free;
		~ifSeqSnr2But04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_04 = ~cntSeqSnr2_04 + 1;
				~cntSeqSnr2_04.switch(
					0,{}, 1,{IFSeqSnr2.st04(1);}, 2,{IFSeqSnr2.st04(0);}
				)}
			);
			},
			'/if2Seq/2/4'
		);
		~ifSeqSnr2But05.free;
		~ifSeqSnr2But05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_05 = ~cntSeqSnr2_05 + 1;
				~cntSeqSnr2_05.switch(
					0,{}, 1,{IFSeqSnr2.st05(1);}, 2,{IFSeqSnr2.st05(0);}
				)}
			);
			},
			'/if2Seq/2/5'
		);
		~ifSeqSnr2But06.free;
		~ifSeqSnr2But06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_06 = ~cntSeqSnr2_06 + 1;
				~cntSeqSnr2_06.switch(
					0,{}, 1,{IFSeqSnr2.st06(1);}, 2,{IFSeqSnr2.st06(0);}
				)}
			);
			},
			'/if2Seq/2/6'
		);
		~ifSeqSnr2But07.free;
		~ifSeqSnr2But07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_07 = ~cntSeqSnr2_07 + 1;
				~cntSeqSnr2_07.switch(
					0,{}, 1,{IFSeqSnr2.st07(1);}, 2,{IFSeqSnr2.st07(0);}
				)}
			);
			},
			'/if2Seq/2/7'
		);
		~ifSeqSnr2But08.free;
		~ifSeqSnr2But08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_08 = ~cntSeqSnr2_08 + 1;
				~cntSeqSnr2_08.switch(
					0,{}, 1,{IFSeqSnr2.st08(1);}, 2,{IFSeqSnr2.st08(0);}
				)}
			);
			},
			'/if2Seq/2/8'
		);

		~ifSeqSnr2But09.free;
		~ifSeqSnr2But09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_09 = ~cntSeqSnr2_09 + 1;
				~cntSeqSnr2_09.switch(
					0,{}, 1,{IFSeqSnr2.st09(1);}, 2,{IFSeqSnr2.st09(0);}
				)}
			);
			},
			'/if2Seq/2/9'
		);
		~ifSeqSnr2But10.free;
		~ifSeqSnr2But10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_10 = ~cntSeqSnr2_10 + 1;
				~cntSeqSnr2_10.switch(
					0,{}, 1,{IFSeqSnr2.st10(1);}, 2,{IFSeqSnr2.st10(0);}
				)}
			);
			},
			'/if2Seq/2/10'
		);
		~ifSeqSnr2But11.free;
		~ifSeqSnr2But11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_11 = ~cntSeqSnr2_11 + 1;
				~cntSeqSnr2_11.switch(
					0,{}, 1,{IFSeqSnr2.st11(1);}, 2,{IFSeqSnr2.st11(0);}
				)}
			);
			},
			'/if2Seq/2/11'
		);
		~ifSeqSnr2But12.free;
		~ifSeqSnr2But12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_12 = ~cntSeqSnr2_12 + 1;
				~cntSeqSnr2_12.switch(
					0,{}, 1,{IFSeqSnr2.st12(1);}, 2,{IFSeqSnr2.st12(0);}
				)}
			);
			},
			'/if2Seq/2/12'
		);
		~ifSeqSnr2But13.free;
		~ifSeqSnr2But13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_13 = ~cntSeqSnr2_13 + 1;
				~cntSeqSnr2_13.switch(
					0,{}, 1,{IFSeqSnr2.st13(1);}, 2,{IFSeqSnr2.st13(0);}
				)}
			);
			},
			'/if2Seq/2/13'
		);
		~ifSeqSnr2But14.free;
		~ifSeqSnr2But14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_14 = ~cntSeqSnr2_14 + 1;
				~cntSeqSnr2_14.switch(
					0,{}, 1,{IFSeqSnr2.st14(1);}, 2,{IFSeqSnr2.st14(0);}
				)}
			);
			},
			'/if2Seq/2/14'
		);
		~ifSeqSnr2But15.free;
		~ifSeqSnr2But15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_15 = ~cntSeqSnr2_15 + 1;
				~cntSeqSnr2_15.switch(
					0,{}, 1,{IFSeqSnr2.st15(1);}, 2,{IFSeqSnr2.st15(0);}
				)}
			);
			},
			'/if2Seq/2/15'
		);
		~ifSeqSnr2But16.free;
		~ifSeqSnr2But16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr2_16 = ~cntSeqSnr2_16 + 1;
				~cntSeqSnr2_16.switch(
					0,{}, 1,{IFSeqSnr2.st16(1);}, 2,{IFSeqSnr2.st16(0);}
				)}
			);
			},
			'/if2Seq/2/16'
		);


	}

	*st01 {|i|
		~cntSeqSnr2_01=i;
		~seqSnr2_01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_01', i);
	}
	*st02 {|i|
		~cntSeqSnr2_02=i;
		~seqSnr2_02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_02', i);
	}
	*st03 {|i|
		~cntSeqSnr2_03=i;
		~seqSnr2_03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_03', i);
	}
	*st04 {|i|
		~cntSeqSnr2_04=i;
		~seqSnr2_04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_04', i);
	}
	*st05 {|i|
		~cntSeqSnr2_05=i;
		~seqSnr2_05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_05', i);
	}
	*st06 {|i|
		~cntSeqSnr2_06=i;
		~seqSnr2_06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_06', i);
	}
	*st07 {|i|
		~cntSeqSnr2_07=i;
		~seqSnr2_07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_07', i);
	}
	*st08 {|i|
		~cntSeqSnr2_08=i;
		~seqSnr2_08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_08', i);
	}

	*st09 {|i|
		~cntSeqSnr2_09=i;
		~seqSnr2_09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_09', i);
	}
	*st10 {|i|
		~cntSeqSnr2_10=i;
		~seqSnr2_10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_10', i);
	}
	*st11 {|i|
		~cntSeqSnr2_11=i;
		~seqSnr2_11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_11', i);
	}
	*st12 {|i|
		~cntSeqSnr2_12=i;
		~seqSnr2_12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_12', i);
	}
	*st13 {|i|
		~cntSeqSnr2_13=i;
		~seqSnr2_13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_13', i);
	}
	*st14 {|i|
		~cntSeqSnr2_14=i;
		~seqSnr2_14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_14', i);
	}
	*st15 {|i|
		~cntSeqSnr2_15=i;
		~seqSnr2_15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_15', i);
	}
	*st16 {|i|
		~cntSeqSnr2_16=i;
		~seqSnr2_16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr2_16', i);
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
		~amp2Snr.source  =  Pseq([~seqSnr2_01.next*~seqVelSnr2_01.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_01.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_01.next], inf);
	}
	*step02{
		~amp2Snr.source  =  Pseq([~seqSnr2_02.next*~seqVelSnr2_02.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_02.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_02.next], inf);
	}
	*step03{
		~amp2Snr.source  =  Pseq([~seqSnr2_03.next*~seqVelSnr2_03.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_03.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_03.next], inf);
	}
	*step04{
		~amp2Snr.source  =  Pseq([~seqSnr2_04.next*~seqVelSnr2_04.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_04.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_04.next], inf);
	}
	*step05{
		~amp2Snr.source  =  Pseq([~seqSnr2_05.next*~seqVelSnr2_05.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_05.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_05.next], inf);
	}
	*step06{
		~amp2Snr.source  =  Pseq([~seqSnr2_06.next*~seqVelSnr2_06.next], inf);
		~octSnr.source = Pseq([~seqOctSnr06.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_06.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_06.next], inf);
	}
	*step07{
		~amp2Snr.source  =  Pseq([~seqSnr2_07.next*~seqVelSnr2_07.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_07.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_07.next], inf);
	}
	*step08{
		~amp2Snr.source  =  Pseq([~seqSnr2_08.next*~seqVelSnr2_08.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_08.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_08.next], inf);
	}
	*step09{
		~amp2Snr.source  =  Pseq([~seqSnr2_09.next*~seqVelSnr2_09.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_09.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_09.next], inf);
	}
	*step10{
		~amp2Snr.source  =  Pseq([~seqSnr2_10.next*~seqVelSnr2_10.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_10.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_10.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr10.next], inf);
	}
	*step11{
		~amp2Snr.source  =  Pseq([~seqSnr2_11.next*~seqVelSnr2_11.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_11.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_11.next], inf);
	}
	*step12{
		~amp2Snr.source  =  Pseq([~seqSnr2_12.next*~seqVelSnr2_12.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_12.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_12.next], inf);
	}
	*step13{
		~amp2Snr.source  =  Pseq([~seqSnr2_13.next*~seqVelSnr2_13.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_13.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_13.next], inf);
	}
	*step14{
		~amp2Snr.source  =  Pseq([~seqSnr2_14.next*~seqVelSnr2_14.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_14.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_14.next], inf);
	}
	*step15{
		~amp2Snr.source  =  Pseq([~seqSnr2_15.next*~seqVelSnr2_15.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_15.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_15.next], inf);
	}
	*step16{
		~amp2Snr.source  =  Pseq([~seqSnr2_16.next*~seqVelSnr2_16.next], inf);
		~nt2Snr.source   =  Pseq([~seqNtSnr2_16.next], inf);
		~sus2Snr.source  =  Pseq([~seqSusSnr2_16.next], inf);
	}

	*stGrp {|i|

		IFSeqSnr2.st01(i); IFSeqSnr2.st02(i); IFSeqSnr2.st03(i); IFSeqSnr2.st04(i);
		IFSeqSnr2.st05(i); IFSeqSnr2.st06(i); IFSeqSnr2.st07(i); IFSeqSnr2.st08(i);
		IFSeqSnr2.st09(i); IFSeqSnr2.st10(i); IFSeqSnr2.st11(i); IFSeqSnr2.st12(i);
		IFSeqSnr2.st13(i); IFSeqSnr2.st14(i); IFSeqSnr2.st15(i); IFSeqSnr2.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqSnr2.st01(s01); IFSeqSnr2.st02(s02); IFSeqSnr2.st03(s03); IFSeqSnr2.st04(s04);
		IFSeqSnr2.st05(s05); IFSeqSnr2.st06(s06); IFSeqSnr2.st07(s07); IFSeqSnr2.st08(s08);
		IFSeqSnr2.st09(s09); IFSeqSnr2.st10(s10); IFSeqSnr2.st11(s11); IFSeqSnr2.st12(s12);
		IFSeqSnr2.st13(s13); IFSeqSnr2.st14(s14); IFSeqSnr2.st15(s15); IFSeqSnr2.st16(s16);
	}
}

