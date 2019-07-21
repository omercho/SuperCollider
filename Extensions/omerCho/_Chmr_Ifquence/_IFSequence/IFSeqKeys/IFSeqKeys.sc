/*
IFSeqKeys.st16(0);
IFSeqKeys.stepPack(1);
*/

IFSeqKeys {
	*loadAll {

		this.loadProxy;
		this.countReset;

		IFSeqOctKeys.loadAll;
		IFSeqNtKeys.loadAll;
		IFSeqNt2Keys.loadAll;
		IFSeqNt3Keys.loadAll;
		IFSeqVelKeys.loadAll;
		IFSeqSusKeys.loadAll;
		IFSeqTmKeys.loadAll;
		IFSeqDurKeys.loadAll;
		IFSeqStKeys.loadAll;
		this.on;
	}

	*loadProxy {

		~seqKeys01 = PatternProxy( Pseq([0], 1));
		~seqKeys02 = PatternProxy( Pseq([0], 1));
		~seqKeys03 = PatternProxy( Pseq([0], 1));
		~seqKeys04 = PatternProxy( Pseq([0], 1));
		~seqKeys05 = PatternProxy( Pseq([0], 1));
		~seqKeys06 = PatternProxy( Pseq([0], 1));
		~seqKeys07 = PatternProxy( Pseq([0], 1));
		~seqKeys08 = PatternProxy( Pseq([0], 1));

		~seqKeys09 = PatternProxy( Pseq([0], 1));
		~seqKeys10 = PatternProxy( Pseq([0], 1));
		~seqKeys11 = PatternProxy( Pseq([0], 1));
		~seqKeys12 = PatternProxy( Pseq([0], 1));
		~seqKeys13 = PatternProxy( Pseq([0], 1));
		~seqKeys14 = PatternProxy( Pseq([0], 1));
		~seqKeys15 = PatternProxy( Pseq([0], 1));
		~seqKeys16 = PatternProxy( Pseq([0], 1));
	}


	*free {
		~cntSeqUpKeys01=0;
		~cntSeqRandKeys01=0;

		IFSeqKeys.st01(0);
		IFSeqKeys.st02(0);
		IFSeqKeys.st03(0);
		IFSeqKeys.st04(0);
		IFSeqKeys.st05(0);
		IFSeqKeys.st06(0);
		IFSeqKeys.st07(0);
		IFSeqKeys.st08(0);

		IFSeqKeys.st09(0);
		IFSeqKeys.st10(0);
		IFSeqKeys.st11(0);
		IFSeqKeys.st12(0);
		IFSeqKeys.st13(0);
		IFSeqKeys.st14(0);
		IFSeqKeys.st15(0);
		IFSeqKeys.st16(0);
	}

	*countReset {
		~cntSeqUpKeys01=0;
		~cntSeqRandKeys01=0;

		~cntSeqKeys01=0;
		~cntSeqKeys02=0;
		~cntSeqKeys03=0;
		~cntSeqKeys04=0;
		~cntSeqKeys05=0;
		~cntSeqKeys06=0;
		~cntSeqKeys07=0;
		~cntSeqKeys08=0;

		~cntSeqKeys09=0;
		~cntSeqKeys10=0;
		~cntSeqKeys11=0;
		~cntSeqKeys12=0;
		~cntSeqKeys13=0;
		~cntSeqKeys14=0;
		~cntSeqKeys15=0;
		~cntSeqKeys16=0;
	}

	*freeOn {

		~seqFreeKeysBut.free;
		~seqFreeKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqKeys.free;
				});
			},
			'/seqFreeKeys'
		);
	}
	*upOn {
		~ifSeqUpKeysBut.free;
		~ifSeqUpKeysBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqUpKeys01 = ~cntSeqUpKeys01 + 1;
				~cntSeqUpKeys01.switch(
					0,{},
					1,{
						IFSeqKeys.stGrp(1);
						IFSeqOctKeys.stGrpSet(3,3,3,3,3,3,3,4,4,4,4,4,4,4,5,5);
						IFSeqNtKeys.stGrpSet(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
						IFSeqNt2Keys.stGrpSet(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
						IFSeqNt3Keys.stGrpSet(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
						IFSeqVelKeys.stGrpSet(3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3);
						IFSeqSusKeys.stGrp(1);
						IFSeqTmKeys.stGrp(1);
					},
					2,{
						IFSeqKeys.stGrpSet(1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,0);
					},
					3,{
						IFSeqKeys.stGrpSet(0,1,1,0,1,1,0,0,0,1,1,0,1,0,1,0);
					},
					4,{
						IFSeqKeys.stGrpSet(1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0);
						~cntSeqUpKeys01=0;
					}
				)}
			);
			},
			'/seqUpKeys'
		);
	}

	*randOn {
		~ifSeqRandKeysBut.free;
		~ifSeqRandKeysBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqRandKeys01 = ~cntSeqRandKeys01 + 1;
				~cntSeqRandKeys01.switch(
					0,{},
					1,{
						IFSeqKeys.st01([0,1].choose);
						IFSeqKeys.st02([0,1].choose);
						IFSeqKeys.st03([0,1].choose);
						IFSeqKeys.st04([0,1].choose);
						IFSeqKeys.st05([0,1].choose);
						IFSeqKeys.st06([0,1].choose);
						IFSeqKeys.st07([0,1].choose);
						IFSeqKeys.st08([0,1].choose);
						IFSeqKeys.st09([0,1].choose);
						IFSeqKeys.st10([0,1].choose);
						IFSeqKeys.st11([0,1].choose);
						IFSeqKeys.st12([0,1].choose);
						IFSeqKeys.st13([0,1].choose);
						IFSeqKeys.st14([0,1].choose);
						IFSeqKeys.st15([0,1].choose);
						IFSeqKeys.st16([0,1].choose);
						~cntSeqRandKeys01=0;
					}
				)}
			);
			},
			'/seqRandKeys'
		);
	}

	*on {
		IFSeqKeys.upOn;
		IFSeqKeys.randOn;
		IFSeqKeys.freeOn;

		~ifSeqKeysBut01.free;
		~ifSeqKeysBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys01 = ~cntSeqKeys01 + 1;
				~cntSeqKeys01.switch(
					0,{}, 1,{IFSeqKeys.st01(1);}, 2,{IFSeqKeys.st01(0);}
				)}
			);
			},
			'/ifSeq/5/1'
		);
		~ifSeqKeysBut02.free;
		~ifSeqKeysBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys02 = ~cntSeqKeys02 + 1;
				~cntSeqKeys02.switch(
					0,{}, 1,{IFSeqKeys.st02(1);}, 2,{IFSeqKeys.st02(0);}
				)}
			);
			},
			'/ifSeq/5/2'
		);
		~ifSeqKeysBut03.free;
		~ifSeqKeysBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys03 = ~cntSeqKeys03 + 1;
				~cntSeqKeys03.switch(
					0,{}, 1,{IFSeqKeys.st03(1);}, 2,{IFSeqKeys.st03(0);}
				)}
			);
			},
			'/ifSeq/5/3'
		);
		~ifSeqKeysBut04.free;
		~ifSeqKeysBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys04 = ~cntSeqKeys04 + 1;
				~cntSeqKeys04.switch(
					0,{}, 1,{IFSeqKeys.st04(1);}, 2,{IFSeqKeys.st04(0);}
				)}
			);
			},
			'/ifSeq/5/4'
		);
		~ifSeqKeysBut05.free;
		~ifSeqKeysBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys05 = ~cntSeqKeys05 + 1;
				~cntSeqKeys05.switch(
					0,{}, 1,{IFSeqKeys.st05(1);}, 2,{IFSeqKeys.st05(0);}
				)}
			);
			},
			'/ifSeq/5/5'
		);
		~ifSeqKeysBut06.free;
		~ifSeqKeysBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys06 = ~cntSeqKeys06 + 1;
				~cntSeqKeys06.switch(
					0,{}, 1,{IFSeqKeys.st06(1);}, 2,{IFSeqKeys.st06(0);}
				)}
			);
			},
			'/ifSeq/5/6'
		);
		~ifSeqKeysBut07.free;
		~ifSeqKeysBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys07 = ~cntSeqKeys07 + 1;
				~cntSeqKeys07.switch(
					0,{}, 1,{IFSeqKeys.st07(1);}, 2,{IFSeqKeys.st07(0);}
				)}
			);
			},
			'/ifSeq/5/7'
		);
		~ifSeqKeysBut08.free;
		~ifSeqKeysBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys08 = ~cntSeqKeys08 + 1;
				~cntSeqKeys08.switch(
					0,{}, 1,{IFSeqKeys.st08(1);}, 2,{IFSeqKeys.st08(0);}
				)}
			);
			},
			'/ifSeq/5/8'
		);

		~ifSeqKeysBut09.free;
		~ifSeqKeysBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys09 = ~cntSeqKeys09 + 1;
				~cntSeqKeys09.switch(
					0,{}, 1,{IFSeqKeys.st09(1);}, 2,{IFSeqKeys.st09(0);}
				)}
			);
			},
			'/ifSeq/5/9'
		);
		~ifSeqKeysBut10.free;
		~ifSeqKeysBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys10 = ~cntSeqKeys10 + 1;
				~cntSeqKeys10.switch(
					0,{}, 1,{IFSeqKeys.st10(1);}, 2,{IFSeqKeys.st10(0);}
				)}
			);
			},
			'/ifSeq/5/10'
		);
		~ifSeqKeysBut11.free;
		~ifSeqKeysBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys11 = ~cntSeqKeys11 + 1;
				~cntSeqKeys11.switch(
					0,{}, 1,{IFSeqKeys.st11(1);}, 2,{IFSeqKeys.st11(0);}
				)}
			);
			},
			'/ifSeq/5/11'
		);
		~ifSeqKeysBut12.free;
		~ifSeqKeysBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys12 = ~cntSeqKeys12 + 1;
				~cntSeqKeys12.switch(
					0,{}, 1,{IFSeqKeys.st12(1);}, 2,{IFSeqKeys.st12(0);}
				)}
			);
			},
			'/ifSeq/5/12'
		);
		~ifSeqKeysBut13.free;
		~ifSeqKeysBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys13 = ~cntSeqKeys13 + 1;
				~cntSeqKeys13.switch(
					0,{}, 1,{IFSeqKeys.st13(1);}, 2,{IFSeqKeys.st13(0);}
				)}
			);
			},
			'/ifSeq/5/13'
		);
		~ifSeqKeysBut14.free;
		~ifSeqKeysBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys14 = ~cntSeqKeys14 + 1;
				~cntSeqKeys14.switch(
					0,{}, 1,{IFSeqKeys.st14(1);}, 2,{IFSeqKeys.st14(0);}
				)}
			);
			},
			'/ifSeq/5/14'
		);
		~ifSeqKeysBut15.free;
		~ifSeqKeysBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys15 = ~cntSeqKeys15 + 1;
				~cntSeqKeys15.switch(
					0,{}, 1,{IFSeqKeys.st15(1);}, 2,{IFSeqKeys.st15(0);}
				)}
			);
			},
			'/ifSeq/5/15'
		);
		~ifSeqKeysBut16.free;
		~ifSeqKeysBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKeys16 = ~cntSeqKeys16 + 1;
				~cntSeqKeys16.switch(
					0,{}, 1,{IFSeqKeys.st16(1);}, 2,{IFSeqKeys.st16(0);}
				)}
			);
			},
			'/ifSeq/5/16'
		);


	}

	*st01 {|i|
		~cntSeqKeys01=i;
		~seqKeys01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys01', i);
	}
	*st02 {|i|
		~cntSeqKeys02=i;
		~seqKeys02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys02', i);
	}
	*st03 {|i|
		~cntSeqKeys03=i;
		~seqKeys03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys03', i);
	}
	*st04 {|i|
		~cntSeqKeys04=i;
		~seqKeys04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys04', i);
	}
	*st05 {|i|
		~cntSeqKeys05=i;
		~seqKeys05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys05', i);
	}
	*st06 {|i|
		~cntSeqKeys06=i;
		~seqKeys06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys06', i);
	}
	*st07 {|i|
		~cntSeqKeys07=i;
		~seqKeys07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys07', i);
	}
	*st08 {|i|
		~cntSeqKeys08=i;
		~seqKeys08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys08', i);
	}

	*st09 {|i|
		~cntSeqKeys09=i;
		~seqKeys09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys09', i);
	}
	*st10 {|i|
		~cntSeqKeys10=i;
		~seqKeys10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys10', i);
	}
	*st11 {|i|
		~cntSeqKeys11=i;
		~seqKeys11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys11', i);
	}
	*st12 {|i|
		~cntSeqKeys12=i;
		~seqKeys12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys12', i);
	}
	*st13 {|i|
		~cntSeqKeys13=i;
		~seqKeys13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys13', i);
	}
	*st14 {|i|
		~cntSeqKeys14=i;
		~seqKeys14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys14', i);
	}
	*st15 {|i|
		~cntSeqKeys15=i;
		~seqKeys15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys15', i);
	}
	*st16 {|i|
		~cntSeqKeys16=i;
		~seqKeys16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKeys16', i);
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
		~amp1Keys.source  =  Pseq([~seqKeys01.next*~seqVelKeys01.next], inf);
		~octKeys.source = Pseq([~seqOctKeys01.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys01.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys01.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys01.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys01.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys01.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys01.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys01.next], inf);
	}
	*step02{
		~amp1Keys.source  =  Pseq([~seqKeys02.next*~seqVelKeys02.next], inf);
		~octKeys.source = Pseq([~seqOctKeys02.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys02.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys02.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys02.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys02.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys02.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys02.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys02.next], inf);
	}
	*step03{
		~amp1Keys.source  =  Pseq([~seqKeys03.next*~seqVelKeys03.next], inf);
		~octKeys.source = Pseq([~seqOctKeys03.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys03.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys03.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys03.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys03.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys03.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys03.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys03.next], inf);
	}
	*step04{
		~amp1Keys.source  =  Pseq([~seqKeys04.next*~seqVelKeys04.next], inf);
		~octKeys.source = Pseq([~seqOctKeys04.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys04.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys04.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys04.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys04.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys04.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys04.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys04.next], inf);
	}
	*step05{
		~amp1Keys.source  =  Pseq([~seqKeys05.next*~seqVelKeys05.next], inf);
		~octKeys.source = Pseq([~seqOctKeys05.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys05.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys05.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys05.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys05.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys05.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys05.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys05.next], inf);
	}
	*step06{
		~amp1Keys.source  =  Pseq([~seqKeys06.next*~seqVelKeys06.next], inf);
		~octKeys.source = Pseq([~seqOctKeys06.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys06.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys06.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys06.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys06.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys06.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys06.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys06.next], inf);
	}
	*step07{
		~amp1Keys.source  =  Pseq([~seqKeys07.next*~seqVelKeys07.next], inf);
		~octKeys.source = Pseq([~seqOctKeys07.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys07.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys07.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys07.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys07.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys07.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys07.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys07.next], inf);
	}
	*step08{
		~amp1Keys.source  =  Pseq([~seqKeys08.next*~seqVelKeys08.next], inf);
		~octKeys.source = Pseq([~seqOctKeys08.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys08.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys08.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys08.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys08.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys08.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys08.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys08.next], inf);
	}
	*step09{
		~amp1Keys.source  =  Pseq([~seqKeys09.next*~seqVelKeys09.next], inf);
		~octKeys.source = Pseq([~seqOctKeys09.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys09.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys09.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys09.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys09.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys09.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys09.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys09.next], inf);
	}
	*step10{
		~amp1Keys.source  =  Pseq([~seqKeys10.next*~seqVelKeys10.next], inf);
		~octKeys.source = Pseq([~seqOctKeys10.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys10.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys10.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys10.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys10.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys10.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys10.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys10.next], inf);
	}
	*step11{
		~amp1Keys.source  =  Pseq([~seqKeys11.next*~seqVelKeys11.next], inf);
		~octKeys.source = Pseq([~seqOctKeys11.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys11.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys11.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys11.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys11.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys11.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys11.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys11.next], inf);
	}
	*step12{
		~amp1Keys.source  =  Pseq([~seqKeys12.next*~seqVelKeys12.next], inf);
		~octKeys.source = Pseq([~seqOctKeys12.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys12.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys12.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys12.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys12.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys12.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys12.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys12.next], inf);
	}
	*step13{
		~amp1Keys.source  =  Pseq([~seqKeys13.next*~seqVelKeys13.next], inf);
		~octKeys.source = Pseq([~seqOctKeys13.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys13.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys13.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys13.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys13.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys13.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys13.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys13.next], inf);
	}
	*step14{
		~amp1Keys.source  =  Pseq([~seqKeys14.next*~seqVelKeys14.next], inf);
		~octKeys.source = Pseq([~seqOctKeys14.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys14.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys14.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys14.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys14.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys14.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys14.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys14.next], inf);
	}
	*step15{
		~amp1Keys.source  =  Pseq([~seqKeys15.next*~seqVelKeys15.next], inf);
		~octKeys.source = Pseq([~seqOctKeys15.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys15.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys15.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys15.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys15.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys15.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys15.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys15.next], inf);
	}
	*step16{
		~amp1Keys.source  =  Pseq([~seqKeys16.next*~seqVelKeys16.next], inf);
		~octKeys.source = Pseq([~seqOctKeys16.next], inf);
		~nt1Keys.source   =  Pseq([~seqNtKeys16.next], inf);
		~nt2Keys.source   =  Pseq([~seqNt2Keys16.next], inf);
		~nt3Keys.source   =  Pseq([~seqNt3Keys16.next], inf);
		~sus1Keys.source  =  Pseq([~seqSusKeys16.next], inf);
		~tmKeys.source    =  Pseq([~seqTmKeys16.next], inf);
		~dur1Keys.source    =  Pseq([~seqDurKeys16.next], inf);
		~ampStKeys.source  =  Pseq([~seqStKeys16.next], inf);
	}
	*stGrp {|i|
		IFSeqKeys.st01(i); IFSeqKeys.st02(i); IFSeqKeys.st03(i); IFSeqKeys.st04(i);
		IFSeqKeys.st05(i); IFSeqKeys.st06(i); IFSeqKeys.st07(i); IFSeqKeys.st08(i);
		IFSeqKeys.st09(i); IFSeqKeys.st10(i); IFSeqKeys.st11(i); IFSeqKeys.st12(i);
		IFSeqKeys.st13(i); IFSeqKeys.st14(i); IFSeqKeys.st15(i); IFSeqKeys.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|
		IFSeqKeys.st01(s01); IFSeqKeys.st02(s02); IFSeqKeys.st03(s03); IFSeqKeys.st04(s04);
		IFSeqKeys.st05(s05); IFSeqKeys.st06(s06); IFSeqKeys.st07(s07); IFSeqKeys.st08(s08);
		IFSeqKeys.st09(s09); IFSeqKeys.st10(s10); IFSeqKeys.st11(s11); IFSeqKeys.st12(s12);
		IFSeqKeys.st13(s13); IFSeqKeys.st14(s14); IFSeqKeys.st15(s15); IFSeqKeys.st16(s16);
	}
}

