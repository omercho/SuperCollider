/*
IFSeqKick2.st16(0);
IFSeqKick2.stepPack(1);
*/

IFSeqKick2 {
	*loadAll {

		this.loadProxy;
		this.countReset;

		IFSeqNtKick2.loadAll;
		IFSeqVelKick2.loadAll;
		IFSeqSusKick2.loadAll;
		this.on;
	}

	*loadProxy {

		~seqKick2_01 = PatternProxy( Pseq([0], 1));
		~seqKick2_02 = PatternProxy( Pseq([0], 1));
		~seqKick2_03 = PatternProxy( Pseq([0], 1));
		~seqKick2_04 = PatternProxy( Pseq([0], 1));
		~seqKick2_05 = PatternProxy( Pseq([0], 1));
		~seqKick2_06 = PatternProxy( Pseq([0], 1));
		~seqKick2_07 = PatternProxy( Pseq([0], 1));
		~seqKick2_08 = PatternProxy( Pseq([0], 1));

		~seqKick2_09 = PatternProxy( Pseq([0], 1));
		~seqKick2_10 = PatternProxy( Pseq([0], 1));
		~seqKick2_11 = PatternProxy( Pseq([0], 1));
		~seqKick2_12 = PatternProxy( Pseq([0], 1));
		~seqKick2_13 = PatternProxy( Pseq([0], 1));
		~seqKick2_14 = PatternProxy( Pseq([0], 1));
		~seqKick2_15 = PatternProxy( Pseq([0], 1));
		~seqKick2_16 = PatternProxy( Pseq([0], 1));
	}


	*free {
		~cntSeqUpKick2_01=0;
		~cntSeqRandKick2_01=0;

		IFSeqKick2.st01(0);
		IFSeqKick2.st02(0);
		IFSeqKick2.st03(0);
		IFSeqKick2.st04(0);
		IFSeqKick2.st05(0);
		IFSeqKick2.st06(0);
		IFSeqKick2.st07(0);
		IFSeqKick2.st08(0);

		IFSeqKick2.st09(0);
		IFSeqKick2.st10(0);
		IFSeqKick2.st11(0);
		IFSeqKick2.st12(0);
		IFSeqKick2.st13(0);
		IFSeqKick2.st14(0);
		IFSeqKick2.st15(0);
		IFSeqKick2.st16(0);
	}

	*countReset {
		~cntSeqUpKick2_01=0;
		~cntSeqRandKick2_01=0;

		~cntSeqKick2_01=0;
		~cntSeqKick2_02=0;
		~cntSeqKick2_03=0;
		~cntSeqKick2_04=0;
		~cntSeqKick2_05=0;
		~cntSeqKick2_06=0;
		~cntSeqKick2_07=0;
		~cntSeqKick2_08=0;

		~cntSeqKick2_09=0;
		~cntSeqKick2_10=0;
		~cntSeqKick2_11=0;
		~cntSeqKick2_12=0;
		~cntSeqKick2_13=0;
		~cntSeqKick2_14=0;
		~cntSeqKick2_15=0;
		~cntSeqKick2_16=0;
	}

	*freeOn {

		~seqFreeKick2But.free;
		~seqFreeKick2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqKick2.free;
				});
			},
			'/seqFreeKick'
		);
	}
	*upOn {
		~ifSeqUpKick2But.free;
		~ifSeqUpKick2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqUpKick2_01 = ~cntSeqUpKick2_01 + 1;
				~cntSeqUpKick2_01.switch(
					0,{},
					1,{
						IFSeqKick2.stGrpSet(1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0);
					},
					2,{
						IFSeqKick2.stGrpSet(1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0);
					},
					3,{
						IFSeqKick2.stGrpSet(0,1,1,0,1,1,0,0,0,1,1,0,1,0,1,0);
					},
					4,{
						IFSeqKick2.stGrpSet(1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0);
						~cntSeqUpKick2_01=0;
					}
				)}
			);
			},
			'/seqUpKick2'
		);
	}

	*randOn {
		~ifSeqRandKick2But.free;
		~ifSeqRandKick2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqRandKick2_01 = ~cntSeqRandKick2_01 + 1;
				~cntSeqRandKick2_01.switch(
					0,{},
					1,{
						IFSeqKick2.st01([0,1].choose);
						IFSeqKick2.st02([0,1].choose);
						IFSeqKick2.st03([0,1].choose);
						IFSeqKick2.st04([0,1].choose);
						IFSeqKick2.st05([0,1].choose);
						IFSeqKick2.st06([0,1].choose);
						IFSeqKick2.st07([0,1].choose);
						IFSeqKick2.st08([0,1].choose);
						IFSeqKick2.st09([0,1].choose);
						IFSeqKick2.st10([0,1].choose);
						IFSeqKick2.st11([0,1].choose);
						IFSeqKick2.st12([0,1].choose);
						IFSeqKick2.st13([0,1].choose);
						IFSeqKick2.st14([0,1].choose);
						IFSeqKick2.st15([0,1].choose);
						IFSeqKick2.st16([0,1].choose);
						~cntSeqRandKick2_01=0;
					}
				)}
			);
			},
			'/seqRandKick2'
		);
	}

	*on {
		IFSeqKick2.upOn;
		IFSeqKick2.randOn;
		IFSeqKick2.freeOn;

		~ifSeqKick2But01.free;
		~ifSeqKick2But01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_01 = ~cntSeqKick2_01 + 1;
				~cntSeqKick2_01.switch(
					0,{}, 1,{IFSeqKick2.st01(1);}, 2,{IFSeqKick2.st01(0);}
				)}
			);
			},
			'/if2Seq/2/1'
		);
		~ifSeqKick2But02.free;
		~ifSeqKick2But02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_02 = ~cntSeqKick2_02 + 1;
				~cntSeqKick2_02.switch(
					0,{}, 1,{IFSeqKick2.st02(1);}, 2,{IFSeqKick2.st02(0);}
				)}
			);
			},
			'/if2Seq/2/2'
		);
		~ifSeqKick2But03.free;
		~ifSeqKick2But03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_03 = ~cntSeqKick2_03 + 1;
				~cntSeqKick2_03.switch(
					0,{}, 1,{IFSeqKick2.st03(1);}, 2,{IFSeqKick2.st03(0);}
				)}
			);
			},
			'/if2Seq/2/3'
		);
		~ifSeqKick2But04.free;
		~ifSeqKick2But04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_04 = ~cntSeqKick2_04 + 1;
				~cntSeqKick2_04.switch(
					0,{}, 1,{IFSeqKick2.st04(1);}, 2,{IFSeqKick2.st04(0);}
				)}
			);
			},
			'/if2Seq/2/4'
		);
		~ifSeqKick2But05.free;
		~ifSeqKick2But05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_05 = ~cntSeqKick2_05 + 1;
				~cntSeqKick2_05.switch(
					0,{}, 1,{IFSeqKick2.st05(1);}, 2,{IFSeqKick2.st05(0);}
				)}
			);
			},
			'/if2Seq/2/5'
		);
		~ifSeqKick2But06.free;
		~ifSeqKick2But06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_06 = ~cntSeqKick2_06 + 1;
				~cntSeqKick2_06.switch(
					0,{}, 1,{IFSeqKick2.st06(1);}, 2,{IFSeqKick2.st06(0);}
				)}
			);
			},
			'/if2Seq/2/6'
		);
		~ifSeqKick2But07.free;
		~ifSeqKick2But07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_07 = ~cntSeqKick2_07 + 1;
				~cntSeqKick2_07.switch(
					0,{}, 1,{IFSeqKick2.st07(1);}, 2,{IFSeqKick2.st07(0);}
				)}
			);
			},
			'/if2Seq/2/7'
		);
		~ifSeqKick2But08.free;
		~ifSeqKick2But08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_08 = ~cntSeqKick2_08 + 1;
				~cntSeqKick2_08.switch(
					0,{}, 1,{IFSeqKick2.st08(1);}, 2,{IFSeqKick2.st08(0);}
				)}
			);
			},
			'/if2Seq/2/8'
		);

		~ifSeqKick2But09.free;
		~ifSeqKick2But09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_09 = ~cntSeqKick2_09 + 1;
				~cntSeqKick2_09.switch(
					0,{}, 1,{IFSeqKick2.st09(1);}, 2,{IFSeqKick2.st09(0);}
				)}
			);
			},
			'/if2Seq/2/9'
		);
		~ifSeqKick2But10.free;
		~ifSeqKick2But10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_10 = ~cntSeqKick2_10 + 1;
				~cntSeqKick2_10.switch(
					0,{}, 1,{IFSeqKick2.st10(1);}, 2,{IFSeqKick2.st10(0);}
				)}
			);
			},
			'/if2Seq/2/10'
		);
		~ifSeqKick2But11.free;
		~ifSeqKick2But11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_11 = ~cntSeqKick2_11 + 1;
				~cntSeqKick2_11.switch(
					0,{}, 1,{IFSeqKick2.st11(1);}, 2,{IFSeqKick2.st11(0);}
				)}
			);
			},
			'/if2Seq/2/11'
		);
		~ifSeqKick2But12.free;
		~ifSeqKick2But12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_12 = ~cntSeqKick2_12 + 1;
				~cntSeqKick2_12.switch(
					0,{}, 1,{IFSeqKick2.st12(1);}, 2,{IFSeqKick2.st12(0);}
				)}
			);
			},
			'/if2Seq/2/12'
		);
		~ifSeqKick2But13.free;
		~ifSeqKick2But13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_13 = ~cntSeqKick2_13 + 1;
				~cntSeqKick2_13.switch(
					0,{}, 1,{IFSeqKick2.st13(1);}, 2,{IFSeqKick2.st13(0);}
				)}
			);
			},
			'/if2Seq/2/13'
		);
		~ifSeqKick2But14.free;
		~ifSeqKick2But14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_14 = ~cntSeqKick2_14 + 1;
				~cntSeqKick2_14.switch(
					0,{}, 1,{IFSeqKick2.st14(1);}, 2,{IFSeqKick2.st14(0);}
				)}
			);
			},
			'/if2Seq/2/14'
		);
		~ifSeqKick2But15.free;
		~ifSeqKick2But15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_15 = ~cntSeqKick2_15 + 1;
				~cntSeqKick2_15.switch(
					0,{}, 1,{IFSeqKick2.st15(1);}, 2,{IFSeqKick2.st15(0);}
				)}
			);
			},
			'/if2Seq/2/15'
		);
		~ifSeqKick2But16.free;
		~ifSeqKick2But16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick2_16 = ~cntSeqKick2_16 + 1;
				~cntSeqKick2_16.switch(
					0,{}, 1,{IFSeqKick2.st16(1);}, 2,{IFSeqKick2.st16(0);}
				)}
			);
			},
			'/if2Seq/2/16'
		);


	}

	*st01 {|i|
		~cntSeqKick2_01=i;
		~seqKick2_01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_01', i);
	}
	*st02 {|i|
		~cntSeqKick2_02=i;
		~seqKick2_02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_02', i);
	}
	*st03 {|i|
		~cntSeqKick2_03=i;
		~seqKick2_03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_03', i);
	}
	*st04 {|i|
		~cntSeqKick2_04=i;
		~seqKick2_04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_04', i);
	}
	*st05 {|i|
		~cntSeqKick2_05=i;
		~seqKick2_05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_05', i);
	}
	*st06 {|i|
		~cntSeqKick2_06=i;
		~seqKick2_06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_06', i);
	}
	*st07 {|i|
		~cntSeqKick2_07=i;
		~seqKick2_07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_07', i);
	}
	*st08 {|i|
		~cntSeqKick2_08=i;
		~seqKick2_08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_08', i);
	}

	*st09 {|i|
		~cntSeqKick2_09=i;
		~seqKick2_09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_09', i);
	}
	*st10 {|i|
		~cntSeqKick2_10=i;
		~seqKick2_10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_10', i);
	}
	*st11 {|i|
		~cntSeqKick2_11=i;
		~seqKick2_11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_11', i);
	}
	*st12 {|i|
		~cntSeqKick2_12=i;
		~seqKick2_12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_12', i);
	}
	*st13 {|i|
		~cntSeqKick2_13=i;
		~seqKick2_13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_13', i);
	}
	*st14 {|i|
		~cntSeqKick2_14=i;
		~seqKick2_14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_14', i);
	}
	*st15 {|i|
		~cntSeqKick2_15=i;
		~seqKick2_15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_15', i);
	}
	*st16 {|i|
		~cntSeqKick2_16=i;
		~seqKick2_16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick2_16', i);
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
		~ampKick2.source  =  Pseq([~seqKick2_01.next*~seqVelKick2_01.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_01.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_01.next], inf);
	}
	*step02{
		~ampKick2.source  =  Pseq([~seqKick2_02.next*~seqVelKick2_02.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_02.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_02.next], inf);
	}
	*step03{
		~ampKick2.source  =  Pseq([~seqKick2_03.next*~seqVelKick2_03.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_03.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_03.next], inf);
	}
	*step04{
		~ampKick2.source  =  Pseq([~seqKick2_04.next*~seqVelKick2_04.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_04.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_04.next], inf);
	}
	*step05{
		~ampKick2.source  =  Pseq([~seqKick2_05.next*~seqVelKick2_05.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_05.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_05.next], inf);
	}
	*step06{
		~ampKick2.source  =  Pseq([~seqKick2_06.next*~seqVelKick2_06.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_06.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_06.next], inf);
	}
	*step07{
		~ampKick2.source  =  Pseq([~seqKick2_07.next*~seqVelKick2_07.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_07.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_07.next], inf);
	}
	*step08{
		~ampKick2.source  =  Pseq([~seqKick2_08.next*~seqVelKick2_08.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_08.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_08.next], inf);
	}
	*step09{
		~ampKick2.source  =  Pseq([~seqKick2_09.next*~seqVelKick2_09.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_09.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_09.next], inf);
	}
	*step10{
		~ampKick2.source  =  Pseq([~seqKick2_10.next*~seqVelKick2_10.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_10.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_10.next], inf);
	}
	*step11{
		~ampKick2.source  =  Pseq([~seqKick2_11.next*~seqVelKick2_11.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_11.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_11.next], inf);
	}
	*step12{
		~ampKick2.source  =  Pseq([~seqKick2_12.next*~seqVelKick2_12.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_12.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_12.next], inf);
	}
	*step13{
		~ampKick2.source  =  Pseq([~seqKick2_13.next*~seqVelKick2_13.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_13.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_13.next], inf);
	}
	*step14{
		~ampKick2.source  =  Pseq([~seqKick2_14.next*~seqVelKick2_14.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_14.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_14.next], inf);
	}
	*step15{
		~ampKick2.source  =  Pseq([~seqKick2_15.next*~seqVelKick2_15.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_15.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_15.next], inf);
	}
	*step16{
		~ampKick2.source  =  Pseq([~seqKick2_16.next*~seqVelKick2_16.next], inf);
		~ntKick2.source   =  Pseq([~seqNtKick2_16.next], inf);
		~susKick2.source  =  Pseq([~seqSusKick2_16.next], inf);
	}

	*stGrp {|i|

		IFSeqKick2.st01(i); IFSeqKick2.st02(i); IFSeqKick2.st03(i); IFSeqKick2.st04(i);
		IFSeqKick2.st05(i); IFSeqKick2.st06(i); IFSeqKick2.st07(i); IFSeqKick2.st08(i);
		IFSeqKick2.st09(i); IFSeqKick2.st10(i); IFSeqKick2.st11(i); IFSeqKick2.st12(i);
		IFSeqKick2.st13(i); IFSeqKick2.st14(i); IFSeqKick2.st15(i); IFSeqKick2.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqKick2.st01(s01); IFSeqKick2.st02(s02); IFSeqKick2.st03(s03); IFSeqKick2.st04(s04);
		IFSeqKick2.st05(s05); IFSeqKick2.st06(s06); IFSeqKick2.st07(s07); IFSeqKick2.st08(s08);
		IFSeqKick2.st09(s09); IFSeqKick2.st10(s10); IFSeqKick2.st11(s11); IFSeqKick2.st12(s12);
		IFSeqKick2.st13(s13); IFSeqKick2.st14(s14); IFSeqKick2.st15(s15); IFSeqKick2.st16(s16);
	}
}

