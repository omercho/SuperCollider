/*
IFSeqSamp.st16(0);
IFSeqSamp.stepPack(1);
*/

IFSeqSamp {
	*loadAll {

		this.loadProxy;
		this.countReset;

		IFSeqOctSamp.loadAll;
		IFSeqNtSamp.loadAll;
		IFSeqVelSamp.loadAll;
		IFSeqSusSamp.loadAll;
		IFSeqTmSamp.loadAll;
		IFSeqDurSamp.loadAll;
		this.on;
	}

	*loadProxy {

		~seqSamp01 = PatternProxy( Pseq([0], 1));
		~seqSamp02 = PatternProxy( Pseq([0], 1));
		~seqSamp03 = PatternProxy( Pseq([0], 1));
		~seqSamp04 = PatternProxy( Pseq([0], 1));
		~seqSamp05 = PatternProxy( Pseq([0], 1));
		~seqSamp06 = PatternProxy( Pseq([0], 1));
		~seqSamp07 = PatternProxy( Pseq([0], 1));
		~seqSamp08 = PatternProxy( Pseq([0], 1));

		~seqSamp09 = PatternProxy( Pseq([0], 1));
		~seqSamp10 = PatternProxy( Pseq([0], 1));
		~seqSamp11 = PatternProxy( Pseq([0], 1));
		~seqSamp12 = PatternProxy( Pseq([0], 1));
		~seqSamp13 = PatternProxy( Pseq([0], 1));
		~seqSamp14 = PatternProxy( Pseq([0], 1));
		~seqSamp15 = PatternProxy( Pseq([0], 1));
		~seqSamp16 = PatternProxy( Pseq([0], 1));
	}


	*free {
		~cntSeqUpSamp01=0;
		~cntSeqRandSamp01=0;

		IFSeqSamp.st01(0);
		IFSeqSamp.st02(0);
		IFSeqSamp.st03(0);
		IFSeqSamp.st04(0);
		IFSeqSamp.st05(0);
		IFSeqSamp.st06(0);
		IFSeqSamp.st07(0);
		IFSeqSamp.st08(0);

		IFSeqSamp.st09(0);
		IFSeqSamp.st10(0);
		IFSeqSamp.st11(0);
		IFSeqSamp.st12(0);
		IFSeqSamp.st13(0);
		IFSeqSamp.st14(0);
		IFSeqSamp.st15(0);
		IFSeqSamp.st16(0);
	}

	*countReset {
		~cntSeqUpSamp01=0;
		~cntSeqRandSamp01=0;

		~cntSeqSamp01=0;
		~cntSeqSamp02=0;
		~cntSeqSamp03=0;
		~cntSeqSamp04=0;
		~cntSeqSamp05=0;
		~cntSeqSamp06=0;
		~cntSeqSamp07=0;
		~cntSeqSamp08=0;

		~cntSeqSamp09=0;
		~cntSeqSamp10=0;
		~cntSeqSamp11=0;
		~cntSeqSamp12=0;
		~cntSeqSamp13=0;
		~cntSeqSamp14=0;
		~cntSeqSamp15=0;
		~cntSeqSamp16=0;
	}

	*freeOn {

		~seqFreeSampBut.free;
		~seqFreeSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSamp.free;
				});
			},
			'/seqFreeSamp'
		);
	}
	*upOn {
		~ifSeqUpSampBut.free;
		~ifSeqUpSampBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqUpSamp01 = ~cntSeqUpSamp01 + 1;
				~cntSeqUpSamp01.switch(
					0,{},
					1,{
						IFSeqSamp.stGrp(1);
						IFSeqOctSamp.stGrpSet(3,3,3,3,3,3,3,4,4,4,4,4,4,4,5,5);
						IFSeqNtSamp.stGrpSet(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
						IFSeqVelSamp.stGrpSet(3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3);
						IFSeqSusSamp.stGrp(1);
						IFSeqTmSamp.stGrp(1);
					},
					2,{
						IFSeqSamp.stGrpSet(1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,0);
					},
					3,{
						IFSeqSamp.stGrpSet(0,1,1,0,1,1,0,0,0,1,1,0,1,0,1,0);
					},
					4,{
						IFSeqSamp.stGrpSet(1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0);
						~cntSeqUpSamp01=0;
					}
				)}
			);
			},
			'/seqUpSamp'
		);
	}

	*randOn {
		~ifSeqRandSampBut.free;
		~ifSeqRandSampBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqRandSamp01 = ~cntSeqRandSamp01 + 1;
				~cntSeqRandSamp01.switch(
					0,{},
					1,{
						IFSeqSamp.st01([0,1].choose);
						IFSeqSamp.st02([0,1].choose);
						IFSeqSamp.st03([0,1].choose);
						IFSeqSamp.st04([0,1].choose);
						IFSeqSamp.st05([0,1].choose);
						IFSeqSamp.st06([0,1].choose);
						IFSeqSamp.st07([0,1].choose);
						IFSeqSamp.st08([0,1].choose);
						IFSeqSamp.st09([0,1].choose);
						IFSeqSamp.st10([0,1].choose);
						IFSeqSamp.st11([0,1].choose);
						IFSeqSamp.st12([0,1].choose);
						IFSeqSamp.st13([0,1].choose);
						IFSeqSamp.st14([0,1].choose);
						IFSeqSamp.st15([0,1].choose);
						IFSeqSamp.st16([0,1].choose);
						~cntSeqRandSamp01=0;
					}
				)}
			);
			},
			'/seqRandSamp'
		);
	}

	*on {
		IFSeqSamp.upOn;
		IFSeqSamp.randOn;
		IFSeqSamp.freeOn;

		~ifSeqSampBut01.free;
		~ifSeqSampBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp01 = ~cntSeqSamp01 + 1;
				~cntSeqSamp01.switch(
					0,{}, 1,{IFSeqSamp.st01(1);}, 2,{IFSeqSamp.st01(0);}
				)}
			);
			},
			'/ifSeq/6/1'
		);
		~ifSeqSampBut02.free;
		~ifSeqSampBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp02 = ~cntSeqSamp02 + 1;
				~cntSeqSamp02.switch(
					0,{}, 1,{IFSeqSamp.st02(1);}, 2,{IFSeqSamp.st02(0);}
				)}
			);
			},
			'/ifSeq/6/2'
		);
		~ifSeqSampBut03.free;
		~ifSeqSampBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp03 = ~cntSeqSamp03 + 1;
				~cntSeqSamp03.switch(
					0,{}, 1,{IFSeqSamp.st03(1);}, 2,{IFSeqSamp.st03(0);}
				)}
			);
			},
			'/ifSeq/6/3'
		);
		~ifSeqSampBut04.free;
		~ifSeqSampBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp04 = ~cntSeqSamp04 + 1;
				~cntSeqSamp04.switch(
					0,{}, 1,{IFSeqSamp.st04(1);}, 2,{IFSeqSamp.st04(0);}
				)}
			);
			},
			'/ifSeq/6/4'
		);
		~ifSeqSampBut05.free;
		~ifSeqSampBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp05 = ~cntSeqSamp05 + 1;
				~cntSeqSamp05.switch(
					0,{}, 1,{IFSeqSamp.st05(1);}, 2,{IFSeqSamp.st05(0);}
				)}
			);
			},
			'/ifSeq/6/5'
		);
		~ifSeqSampBut06.free;
		~ifSeqSampBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp06 = ~cntSeqSamp06 + 1;
				~cntSeqSamp06.switch(
					0,{}, 1,{IFSeqSamp.st06(1);}, 2,{IFSeqSamp.st06(0);}
				)}
			);
			},
			'/ifSeq/6/6'
		);
		~ifSeqSampBut07.free;
		~ifSeqSampBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp07 = ~cntSeqSamp07 + 1;
				~cntSeqSamp07.switch(
					0,{}, 1,{IFSeqSamp.st07(1);}, 2,{IFSeqSamp.st07(0);}
				)}
			);
			},
			'/ifSeq/6/7'
		);
		~ifSeqSampBut08.free;
		~ifSeqSampBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp08 = ~cntSeqSamp08 + 1;
				~cntSeqSamp08.switch(
					0,{}, 1,{IFSeqSamp.st08(1);}, 2,{IFSeqSamp.st08(0);}
				)}
			);
			},
			'/ifSeq/6/8'
		);

		~ifSeqSampBut09.free;
		~ifSeqSampBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp09 = ~cntSeqSamp09 + 1;
				~cntSeqSamp09.switch(
					0,{}, 1,{IFSeqSamp.st09(1);}, 2,{IFSeqSamp.st09(0);}
				)}
			);
			},
			'/ifSeq/6/9'
		);
		~ifSeqSampBut10.free;
		~ifSeqSampBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp10 = ~cntSeqSamp10 + 1;
				~cntSeqSamp10.switch(
					0,{}, 1,{IFSeqSamp.st10(1);}, 2,{IFSeqSamp.st10(0);}
				)}
			);
			},
			'/ifSeq/6/10'
		);
		~ifSeqSampBut11.free;
		~ifSeqSampBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp11 = ~cntSeqSamp11 + 1;
				~cntSeqSamp11.switch(
					0,{}, 1,{IFSeqSamp.st11(1);}, 2,{IFSeqSamp.st11(0);}
				)}
			);
			},
			'/ifSeq/6/11'
		);
		~ifSeqSampBut12.free;
		~ifSeqSampBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp12 = ~cntSeqSamp12 + 1;
				~cntSeqSamp12.switch(
					0,{}, 1,{IFSeqSamp.st12(1);}, 2,{IFSeqSamp.st12(0);}
				)}
			);
			},
			'/ifSeq/6/12'
		);
		~ifSeqSampBut13.free;
		~ifSeqSampBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp13 = ~cntSeqSamp13 + 1;
				~cntSeqSamp13.switch(
					0,{}, 1,{IFSeqSamp.st13(1);}, 2,{IFSeqSamp.st13(0);}
				)}
			);
			},
			'/ifSeq/6/13'
		);
		~ifSeqSampBut14.free;
		~ifSeqSampBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp14 = ~cntSeqSamp14 + 1;
				~cntSeqSamp14.switch(
					0,{}, 1,{IFSeqSamp.st14(1);}, 2,{IFSeqSamp.st14(0);}
				)}
			);
			},
			'/ifSeq/6/14'
		);
		~ifSeqSampBut15.free;
		~ifSeqSampBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp15 = ~cntSeqSamp15 + 1;
				~cntSeqSamp15.switch(
					0,{}, 1,{IFSeqSamp.st15(1);}, 2,{IFSeqSamp.st15(0);}
				)}
			);
			},
			'/ifSeq/6/15'
		);
		~ifSeqSampBut16.free;
		~ifSeqSampBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSamp16 = ~cntSeqSamp16 + 1;
				~cntSeqSamp16.switch(
					0,{}, 1,{IFSeqSamp.st16(1);}, 2,{IFSeqSamp.st16(0);}
				)}
			);
			},
			'/ifSeq/6/16'
		);


	}

	*st01 {|i|
		~cntSeqSamp01=i;
		~seqSamp01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp01', i);
	}
	*st02 {|i|
		~cntSeqSamp02=i;
		~seqSamp02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp02', i);
	}
	*st03 {|i|
		~cntSeqSamp03=i;
		~seqSamp03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp03', i);
	}
	*st04 {|i|
		~cntSeqSamp04=i;
		~seqSamp04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp04', i);
	}
	*st05 {|i|
		~cntSeqSamp05=i;
		~seqSamp05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp05', i);
	}
	*st06 {|i|
		~cntSeqSamp06=i;
		~seqSamp06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp06', i);
	}
	*st07 {|i|
		~cntSeqSamp07=i;
		~seqSamp07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp07', i);
	}
	*st08 {|i|
		~cntSeqSamp08=i;
		~seqSamp08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp08', i);
	}

	*st09 {|i|
		~cntSeqSamp01=i;
		~seqSamp09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp09', i);
	}
	*st10 {|i|
		~cntSeqSamp10=i;
		~seqSamp10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp10', i);
	}
	*st11 {|i|
		~cntSeqSamp11=i;
		~seqSamp11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp11', i);
	}
	*st12 {|i|
		~cntSeqSamp12=i;
		~seqSamp12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp12', i);
	}
	*st13 {|i|
		~cntSeqSamp13=i;
		~seqSamp13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp13', i);
	}
	*st14 {|i|
		~cntSeqSamp14=i;
		~seqSamp14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp14', i);
	}
	*st15 {|i|
		~cntSeqSamp15=i;
		~seqSamp15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp15', i);
	}
	*st16 {|i|
		~cntSeqSamp16=i;
		~seqSamp16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSamp16', i);
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
		~amp1Samp.source  =  Pseq([~seqSamp01.next*~seqVelSamp01.next], inf);
		~octSamp.source = Pseq([~seqOctSamp01.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp01.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp01.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp01.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp01.next], inf);
	}
	*step02{
		~amp1Samp.source  =  Pseq([~seqSamp02.next*~seqVelSamp02.next], inf);
		~octSamp.source = Pseq([~seqOctSamp02.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp02.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp02.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp02.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp02.next], inf);
	}
	*step03{
		~amp1Samp.source  =  Pseq([~seqSamp03.next*~seqVelSamp03.next], inf);
		~octSamp.source = Pseq([~seqOctSamp03.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp03.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp03.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp03.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp03.next], inf);
	}
	*step04{
		~amp1Samp.source  =  Pseq([~seqSamp04.next*~seqVelSamp04.next], inf);
		~octSamp.source = Pseq([~seqOctSamp04.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp04.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp04.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp04.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp04.next], inf);
	}
	*step05{
		~amp1Samp.source  =  Pseq([~seqSamp05.next*~seqVelSamp05.next], inf);
		~octSamp.source = Pseq([~seqOctSamp05.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp05.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp05.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp05.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp05.next], inf);
	}
	*step06{
		~amp1Samp.source  =  Pseq([~seqSamp06.next*~seqVelSamp06.next], inf);
		~octSamp.source = Pseq([~seqOctSamp06.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp06.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp06.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp06.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp06.next], inf);
	}
	*step07{
		~amp1Samp.source  =  Pseq([~seqSamp07.next*~seqVelSamp07.next], inf);
		~octSamp.source = Pseq([~seqOctSamp07.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp07.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp07.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp07.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp07.next], inf);
	}
	*step08{
		~amp1Samp.source  =  Pseq([~seqSamp08.next*~seqVelSamp08.next], inf);
		~octSamp.source = Pseq([~seqOctSamp08.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp08.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp08.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp08.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp08.next], inf);
	}
	*step09{
		~amp1Samp.source  =  Pseq([~seqSamp09.next*~seqVelSamp09.next], inf);
		~octSamp.source = Pseq([~seqOctSamp09.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp09.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp09.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp09.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp09.next], inf);
	}
	*step10{
		~amp1Samp.source  =  Pseq([~seqSamp10.next*~seqVelSamp10.next], inf);
		~octSamp.source = Pseq([~seqOctSamp10.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp10.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp10.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp10.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp10.next], inf);
	}
	*step11{
		~amp1Samp.source  =  Pseq([~seqSamp11.next*~seqVelSamp11.next], inf);
		~octSamp.source = Pseq([~seqOctSamp11.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp11.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp11.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp11.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp11.next], inf);
	}
	*step12{
		~amp1Samp.source  =  Pseq([~seqSamp12.next*~seqVelSamp12.next], inf);
		~octSamp.source = Pseq([~seqOctSamp12.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp12.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp12.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp12.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp12.next], inf);
	}
	*step13{
		~amp1Samp.source  =  Pseq([~seqSamp13.next*~seqVelSamp13.next], inf);
		~octSamp.source = Pseq([~seqOctSamp13.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp13.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp13.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp13.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp13.next], inf);
	}
	*step14{
		~amp1Samp.source  =  Pseq([~seqSamp14.next*~seqVelSamp14.next], inf);
		~octSamp.source = Pseq([~seqOctSamp14.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp14.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp14.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp14.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp14.next], inf);
	}
	*step15{
		~amp1Samp.source  =  Pseq([~seqSamp15.next*~seqVelSamp15.next], inf);
		~octSamp.source = Pseq([~seqOctSamp15.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp15.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp15.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp15.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp15.next], inf);
	}
	*step16{
		~amp1Samp.source  =  Pseq([~seqSamp16.next*~seqVelSamp16.next], inf);
		~octSamp.source = Pseq([~seqOctSamp16.next], inf);
		~nt1Samp.source   =  Pseq([~seqNtSamp16.next], inf);
		~sus1Samp.source  =  Pseq([~seqSusSamp16.next], inf);
		~tmSamp.source    =  Pseq([~seqTmSamp16.next], inf);
		~dur1Samp.source    =  Pseq([~seqDurSamp16.next], inf);
	}
	*stGrp {|i|

		IFSeqSamp.st01(i); IFSeqSamp.st02(i); IFSeqSamp.st03(i); IFSeqSamp.st04(i);
		IFSeqSamp.st05(i); IFSeqSamp.st06(i); IFSeqSamp.st07(i); IFSeqSamp.st08(i);
		IFSeqSamp.st09(i); IFSeqSamp.st10(i); IFSeqSamp.st11(i); IFSeqSamp.st12(i);
		IFSeqSamp.st13(i); IFSeqSamp.st14(i); IFSeqSamp.st15(i); IFSeqSamp.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqSamp.st01(s01); IFSeqSamp.st02(s02); IFSeqSamp.st03(s03); IFSeqSamp.st04(s04);
		IFSeqSamp.st05(s05); IFSeqSamp.st06(s06); IFSeqSamp.st07(s07); IFSeqSamp.st08(s08);
		IFSeqSamp.st09(s09); IFSeqSamp.st10(s10); IFSeqSamp.st11(s11); IFSeqSamp.st12(s12);
		IFSeqSamp.st13(s13); IFSeqSamp.st14(s14); IFSeqSamp.st15(s15); IFSeqSamp.st16(s16);
	}

}

