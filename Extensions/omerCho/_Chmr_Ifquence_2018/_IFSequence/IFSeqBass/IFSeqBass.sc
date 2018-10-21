/*
IFSeqBass.st16(0);
IFSeqBass.stepPack(1);
*/

IFSeqBass {
	*loadAll {

		this.loadProxy;
		this.countReset;

		IFSeqOctBass.loadAll;
		IFSeqNtBass.loadAll;
		IFSeqVelBass.loadAll;
		IFSeqSusBass.loadAll;
		IFSeqTmBass.loadAll;
		IFSeqDurBass.loadAll;
		IFSeqStBass.loadAll;
		this.on;
	}

	*loadProxy {

		~seqBass01 = PatternProxy( Pseq([0], 1));
		~seqBass02 = PatternProxy( Pseq([0], 1));
		~seqBass03 = PatternProxy( Pseq([0], 1));
		~seqBass04 = PatternProxy( Pseq([0], 1));
		~seqBass05 = PatternProxy( Pseq([0], 1));
		~seqBass06 = PatternProxy( Pseq([0], 1));
		~seqBass07 = PatternProxy( Pseq([0], 1));
		~seqBass08 = PatternProxy( Pseq([0], 1));

		~seqBass09 = PatternProxy( Pseq([0], 1));
		~seqBass10 = PatternProxy( Pseq([0], 1));
		~seqBass11 = PatternProxy( Pseq([0], 1));
		~seqBass12 = PatternProxy( Pseq([0], 1));
		~seqBass13 = PatternProxy( Pseq([0], 1));
		~seqBass14 = PatternProxy( Pseq([0], 1));
		~seqBass15 = PatternProxy( Pseq([0], 1));
		~seqBass16 = PatternProxy( Pseq([0], 1));
	}


	*free {
		~cntSeqUpBass01=0;
		~cntSeqRandBass01=0;

		IFSeqBass.st01(0);
		IFSeqBass.st02(0);
		IFSeqBass.st03(0);
		IFSeqBass.st04(0);
		IFSeqBass.st05(0);
		IFSeqBass.st06(0);
		IFSeqBass.st07(0);
		IFSeqBass.st08(0);

		IFSeqBass.st09(0);
		IFSeqBass.st10(0);
		IFSeqBass.st11(0);
		IFSeqBass.st12(0);
		IFSeqBass.st13(0);
		IFSeqBass.st14(0);
		IFSeqBass.st15(0);
		IFSeqBass.st16(0);
	}

	*countReset {
		~cntSeqUpBass01=0;
		~cntSeqRandBass01=0;

		~cntSeqBass01=0;
		~cntSeqBass02=0;
		~cntSeqBass03=0;
		~cntSeqBass04=0;
		~cntSeqBass05=0;
		~cntSeqBass06=0;
		~cntSeqBass07=0;
		~cntSeqBass08=0;

		~cntSeqBass09=0;
		~cntSeqBass10=0;
		~cntSeqBass11=0;
		~cntSeqBass12=0;
		~cntSeqBass13=0;
		~cntSeqBass14=0;
		~cntSeqBass15=0;
		~cntSeqBass16=0;
	}

	*freeOn {

		~seqFreeBassBut.free;
		~seqFreeBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqBass.free;
				});
			},
			'/seqFreeBass'
		);
	}
	*upOn {
		~ifSeqUpBassBut.free;
		~ifSeqUpBassBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqUpBass01 = ~cntSeqUpBass01 + 1;
				~cntSeqUpBass01.switch(
					0,{},
					1,{
						IFSeqBass.stGrp(1);
						IFSeqOctBass.stGrpSet(3,3,3,3,3,3,3,4,4,4,4,4,4,4,5,5);
						IFSeqNtBass.stGrpSet(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
						IFSeqVelBass.stGrpSet(3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3);
						IFSeqSusBass.stGrp(1);
						IFSeqTmBass.stGrp(1);
					},
					2,{
						IFSeqBass.stGrpSet(1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,0);
					},
					3,{
						IFSeqBass.stGrpSet(0,1,1,0,1,1,0,0,0,1,1,0,1,0,1,0);
					},
					4,{
						IFSeqBass.stGrpSet(1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0);
						~cntSeqUpBass01=0;
					}
				)}
			);
			},
			'/seqUpBass'
		);
	}

	*randOn {
		~ifSeqRandBassBut.free;
		~ifSeqRandBassBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqRandBass01 = ~cntSeqRandBass01 + 1;
				~cntSeqRandBass01.switch(
					0,{},
					1,{
						IFSeqBass.st01([0,1].choose);
						IFSeqBass.st02([0,1].choose);
						IFSeqBass.st03([0,1].choose);
						IFSeqBass.st04([0,1].choose);
						IFSeqBass.st05([0,1].choose);
						IFSeqBass.st06([0,1].choose);
						IFSeqBass.st07([0,1].choose);
						IFSeqBass.st08([0,1].choose);
						IFSeqBass.st09([0,1].choose);
						IFSeqBass.st10([0,1].choose);
						IFSeqBass.st11([0,1].choose);
						IFSeqBass.st12([0,1].choose);
						IFSeqBass.st13([0,1].choose);
						IFSeqBass.st14([0,1].choose);
						IFSeqBass.st15([0,1].choose);
						IFSeqBass.st16([0,1].choose);
						~cntSeqRandBass01=0;
					}
				)}
			);
			},
			'/seqRandBass'
		);
	}

	*on {
		IFSeqBass.upOn;
		IFSeqBass.randOn;
		IFSeqBass.freeOn;

		~ifSeqBassBut01.free;
		~ifSeqBassBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass01 = ~cntSeqBass01 + 1;
				~cntSeqBass01.switch(
					0,{}, 1,{IFSeqBass.st01(1);}, 2,{IFSeqBass.st01(0);}
				)}
			);
			},
			'/ifSeq/4/1'
		);
		~ifSeqBassBut02.free;
		~ifSeqBassBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass02 = ~cntSeqBass02 + 1;
				~cntSeqBass02.switch(
					0,{}, 1,{IFSeqBass.st02(1);}, 2,{IFSeqBass.st02(0);}
				)}
			);
			},
			'/ifSeq/4/2'
		);
		~ifSeqBassBut03.free;
		~ifSeqBassBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass03 = ~cntSeqBass03 + 1;
				~cntSeqBass03.switch(
					0,{}, 1,{IFSeqBass.st03(1);}, 2,{IFSeqBass.st03(0);}
				)}
			);
			},
			'/ifSeq/4/3'
		);
		~ifSeqBassBut04.free;
		~ifSeqBassBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass04 = ~cntSeqBass04 + 1;
				~cntSeqBass04.switch(
					0,{}, 1,{IFSeqBass.st04(1);}, 2,{IFSeqBass.st04(0);}
				)}
			);
			},
			'/ifSeq/4/4'
		);
		~ifSeqBassBut05.free;
		~ifSeqBassBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass05 = ~cntSeqBass05 + 1;
				~cntSeqBass05.switch(
					0,{}, 1,{IFSeqBass.st05(1);}, 2,{IFSeqBass.st05(0);}
				)}
			);
			},
			'/ifSeq/4/5'
		);
		~ifSeqBassBut06.free;
		~ifSeqBassBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass06 = ~cntSeqBass06 + 1;
				~cntSeqBass06.switch(
					0,{}, 1,{IFSeqBass.st06(1);}, 2,{IFSeqBass.st06(0);}
				)}
			);
			},
			'/ifSeq/4/6'
		);
		~ifSeqBassBut07.free;
		~ifSeqBassBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass07 = ~cntSeqBass07 + 1;
				~cntSeqBass07.switch(
					0,{}, 1,{IFSeqBass.st07(1);}, 2,{IFSeqBass.st07(0);}
				)}
			);
			},
			'/ifSeq/4/7'
		);
		~ifSeqBassBut08.free;
		~ifSeqBassBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass08 = ~cntSeqBass08 + 1;
				~cntSeqBass08.switch(
					0,{}, 1,{IFSeqBass.st08(1);}, 2,{IFSeqBass.st08(0);}
				)}
			);
			},
			'/ifSeq/4/8'
		);

		~ifSeqBassBut09.free;
		~ifSeqBassBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass09 = ~cntSeqBass09 + 1;
				~cntSeqBass09.switch(
					0,{}, 1,{IFSeqBass.st09(1);}, 2,{IFSeqBass.st09(0);}
				)}
			);
			},
			'/ifSeq/4/9'
		);
		~ifSeqBassBut10.free;
		~ifSeqBassBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass10 = ~cntSeqBass10 + 1;
				~cntSeqBass10.switch(
					0,{}, 1,{IFSeqBass.st10(1);}, 2,{IFSeqBass.st10(0);}
				)}
			);
			},
			'/ifSeq/4/10'
		);
		~ifSeqBassBut11.free;
		~ifSeqBassBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass11 = ~cntSeqBass11 + 1;
				~cntSeqBass11.switch(
					0,{}, 1,{IFSeqBass.st11(1);}, 2,{IFSeqBass.st11(0);}
				)}
			);
			},
			'/ifSeq/4/11'
		);
		~ifSeqBassBut12.free;
		~ifSeqBassBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass12 = ~cntSeqBass12 + 1;
				~cntSeqBass12.switch(
					0,{}, 1,{IFSeqBass.st12(1);}, 2,{IFSeqBass.st12(0);}
				)}
			);
			},
			'/ifSeq/4/12'
		);
		~ifSeqBassBut13.free;
		~ifSeqBassBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass13 = ~cntSeqBass13 + 1;
				~cntSeqBass13.switch(
					0,{}, 1,{IFSeqBass.st13(1);}, 2,{IFSeqBass.st13(0);}
				)}
			);
			},
			'/ifSeq/4/13'
		);
		~ifSeqBassBut14.free;
		~ifSeqBassBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass14 = ~cntSeqBass14 + 1;
				~cntSeqBass14.switch(
					0,{}, 1,{IFSeqBass.st14(1);}, 2,{IFSeqBass.st14(0);}
				)}
			);
			},
			'/ifSeq/4/14'
		);
		~ifSeqBassBut15.free;
		~ifSeqBassBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass15 = ~cntSeqBass15 + 1;
				~cntSeqBass15.switch(
					0,{}, 1,{IFSeqBass.st15(1);}, 2,{IFSeqBass.st15(0);}
				)}
			);
			},
			'/ifSeq/4/15'
		);
		~ifSeqBassBut16.free;
		~ifSeqBassBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqBass16 = ~cntSeqBass16 + 1;
				~cntSeqBass16.switch(
					0,{}, 1,{IFSeqBass.st16(1);}, 2,{IFSeqBass.st16(0);}
				)}
			);
			},
			'/ifSeq/4/16'
		);


	}

	*st01 {|i|
		~cntSeqBass01=i;
		~seqBass01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass01', i);
	}
	*st02 {|i|
		~cntSeqBass02=i;
		~seqBass02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass02', i);
	}
	*st03 {|i|
		~cntSeqBass03=i;
		~seqBass03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass03', i);
	}
	*st04 {|i|
		~cntSeqBass04=i;
		~seqBass04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass04', i);
	}
	*st05 {|i|
		~cntSeqBass05=i;
		~seqBass05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass05', i);
	}
	*st06 {|i|
		~cntSeqBass06=i;
		~seqBass06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass06', i);
	}
	*st07 {|i|
		~cntSeqBass07=i;
		~seqBass07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass07', i);
	}
	*st08 {|i|
		~cntSeqBass08=i;
		~seqBass08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass08', i);
	}

	*st09 {|i|
		~cntSeqBass09=i;
		~seqBass09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass09', i);
	}
	*st10 {|i|
		~cntSeqBass10=i;
		~seqBass10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass10', i);
	}
	*st11 {|i|
		~cntSeqBass11=i;
		~seqBass11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass11', i);
	}
	*st12 {|i|
		~cntSeqBass12=i;
		~seqBass12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass12', i);
	}
	*st13 {|i|
		~cntSeqBass13=i;
		~seqBass13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass13', i);
	}
	*st14 {|i|
		~cntSeqBass14=i;
		~seqBass14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass14', i);
	}
	*st15 {|i|
		~cntSeqBass15=i;
		~seqBass15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass15', i);
	}
	*st16 {|i|
		~cntSeqBass16=i;
		~seqBass16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledBass16', i);
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
		~amp1Bass.source  =  Pseq([~seqBass01.next*~seqVelBass01.next], inf);
		~octBass.source = Pseq([~seqOctBass01.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass01.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass01.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass01.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass01.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass01.next], inf);
	}
	*step02{
		~amp1Bass.source  =  Pseq([~seqBass02.next*~seqVelBass02.next], inf);
		~octBass.source = Pseq([~seqOctBass02.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass02.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass02.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass02.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass02.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass02.next], inf);
	}
	*step03{
		~amp1Bass.source  =  Pseq([~seqBass03.next*~seqVelBass03.next], inf);
		~octBass.source = Pseq([~seqOctBass03.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass03.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass03.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass03.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass03.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass03.next], inf);
	}
	*step04{
		~amp1Bass.source  =  Pseq([~seqBass04.next*~seqVelBass04.next], inf);
		~octBass.source = Pseq([~seqOctBass04.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass04.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass04.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass04.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass04.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass04.next], inf);
	}
	*step05{
		~amp1Bass.source  =  Pseq([~seqBass05.next*~seqVelBass05.next], inf);
		~octBass.source = Pseq([~seqOctBass05.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass05.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass05.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass05.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass05.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass05.next], inf);
	}
	*step06{
		~amp1Bass.source  =  Pseq([~seqBass06.next*~seqVelBass06.next], inf);
		~octBass.source = Pseq([~seqOctBass06.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass06.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass06.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass06.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass06.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass06.next], inf);
	}
	*step07{
		~amp1Bass.source  =  Pseq([~seqBass07.next*~seqVelBass07.next], inf);
		~octBass.source = Pseq([~seqOctBass07.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass07.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass07.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass07.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass07.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass07.next], inf);
	}
	*step08{
		~amp1Bass.source  =  Pseq([~seqBass08.next*~seqVelBass08.next], inf);
		~octBass.source = Pseq([~seqOctBass08.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass08.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass08.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass08.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass08.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass08.next], inf);
	}
	*step09{
		~amp1Bass.source  =  Pseq([~seqBass09.next*~seqVelBass09.next], inf);
		~octBass.source = Pseq([~seqOctBass09.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass09.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass09.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass09.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass09.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass09.next], inf);
	}
	*step10{
		~amp1Bass.source  =  Pseq([~seqBass10.next*~seqVelBass10.next], inf);
		~octBass.source = Pseq([~seqOctBass10.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass10.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass10.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass10.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass10.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass10.next], inf);
	}
	*step11{
		~amp1Bass.source  =  Pseq([~seqBass11.next*~seqVelBass11.next], inf);
		~octBass.source = Pseq([~seqOctBass11.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass11.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass11.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass11.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass11.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass11.next], inf);
	}
	*step12{
		~amp1Bass.source  =  Pseq([~seqBass12.next*~seqVelBass12.next], inf);
		~octBass.source = Pseq([~seqOctBass12.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass12.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass12.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass12.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass12.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass12.next], inf);
	}
	*step13{
		~amp1Bass.source  =  Pseq([~seqBass13.next*~seqVelBass13.next], inf);
		~octBass.source = Pseq([~seqOctBass13.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass13.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass13.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass13.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass13.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass13.next], inf);
	}
	*step14{
		~amp1Bass.source  =  Pseq([~seqBass14.next*~seqVelBass14.next], inf);
		~octBass.source = Pseq([~seqOctBass14.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass14.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass14.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass14.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass14.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass14.next], inf);
	}
	*step15{
		~amp1Bass.source  =  Pseq([~seqBass15.next*~seqVelBass15.next], inf);
		~octBass.source = Pseq([~seqOctBass15.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass15.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass15.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass15.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass15.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass15.next], inf);
	}
	*step16{
		~amp1Bass.source  =  Pseq([~seqBass16.next*~seqVelBass16.next], inf);
		~octBass.source = Pseq([~seqOctBass16.next], inf);
		~nt1Bass.source   =  Pseq([~seqNtBass16.next], inf);
		~sus1Bass.source  =  Pseq([~seqSusBass16.next], inf);
		~tmBass.source    =  Pseq([~seqTmBass16.next], inf);
		~dur1Bass.source    =  Pseq([~seqDurBass16.next], inf);
		~ampStBass.source  =  Pseq([~seqStBass16.next], inf);
	}

	*stGrp {|i|

		IFSeqBass.st01(i); IFSeqBass.st02(i); IFSeqBass.st03(i); IFSeqBass.st04(i);
		IFSeqBass.st05(i); IFSeqBass.st06(i); IFSeqBass.st07(i); IFSeqBass.st08(i);
		IFSeqBass.st09(i); IFSeqBass.st10(i); IFSeqBass.st11(i); IFSeqBass.st12(i);
		IFSeqBass.st13(i); IFSeqBass.st14(i); IFSeqBass.st15(i); IFSeqBass.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqBass.st01(s01); IFSeqBass.st02(s02); IFSeqBass.st03(s03); IFSeqBass.st04(s04);
		IFSeqBass.st05(s05); IFSeqBass.st06(s06); IFSeqBass.st07(s07); IFSeqBass.st08(s08);
		IFSeqBass.st09(s09); IFSeqBass.st10(s10); IFSeqBass.st11(s11); IFSeqBass.st12(s12);
		IFSeqBass.st13(s13); IFSeqBass.st14(s14); IFSeqBass.st15(s15); IFSeqBass.st16(s16);
	}
}

