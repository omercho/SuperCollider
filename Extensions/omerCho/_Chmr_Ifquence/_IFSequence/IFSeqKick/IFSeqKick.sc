/*
IFSeqKick.st16(0);
IFSeqKick.stepPack(1);
*/

IFSeqKick {
	*loadAll {

		this.loadProxy;
		this.countReset;

		IFSeqOctKick.loadAll;
		IFSeqNtKick.loadAll;
		IFSeqVelKick.loadAll;
		IFSeqSusKick.loadAll;
		IFSeqTmKick.loadAll;
		IFSeqDurKick.loadAll;
		IFSeqStKick.loadAll;
		this.on;
	}

	*loadProxy {

		~seqKick01 = PatternProxy( Pseq([0], 1));
		~seqKick02 = PatternProxy( Pseq([0], 1));
		~seqKick03 = PatternProxy( Pseq([0], 1));
		~seqKick04 = PatternProxy( Pseq([0], 1));
		~seqKick05 = PatternProxy( Pseq([0], 1));
		~seqKick06 = PatternProxy( Pseq([0], 1));
		~seqKick07 = PatternProxy( Pseq([0], 1));
		~seqKick08 = PatternProxy( Pseq([0], 1));

		~seqKick09 = PatternProxy( Pseq([0], 1));
		~seqKick10 = PatternProxy( Pseq([0], 1));
		~seqKick11 = PatternProxy( Pseq([0], 1));
		~seqKick12 = PatternProxy( Pseq([0], 1));
		~seqKick13 = PatternProxy( Pseq([0], 1));
		~seqKick14 = PatternProxy( Pseq([0], 1));
		~seqKick15 = PatternProxy( Pseq([0], 1));
		~seqKick16 = PatternProxy( Pseq([0], 1));

	}


	*free {
		~cntSeqUpKick01=0;
		~cntSeqRandKick01=0;

		IFSeqKick.st01(0);
		IFSeqKick.st02(0);
		IFSeqKick.st03(0);
		IFSeqKick.st04(0);
		IFSeqKick.st05(0);
		IFSeqKick.st06(0);
		IFSeqKick.st07(0);
		IFSeqKick.st08(0);

		IFSeqKick.st09(0);
		IFSeqKick.st10(0);
		IFSeqKick.st11(0);
		IFSeqKick.st12(0);
		IFSeqKick.st13(0);
		IFSeqKick.st14(0);
		IFSeqKick.st15(0);
		IFSeqKick.st16(0);
	}

	*countReset {
		~cntSeqUpKick01=0;
		~cntSeqRandKick01=0;

		~cntSeqKick01=0;
		~cntSeqKick02=0;
		~cntSeqKick03=0;
		~cntSeqKick04=0;
		~cntSeqKick05=0;
		~cntSeqKick06=0;
		~cntSeqKick07=0;
		~cntSeqKick08=0;

		~cntSeqKick09=0;
		~cntSeqKick10=0;
		~cntSeqKick11=0;
		~cntSeqKick12=0;
		~cntSeqKick13=0;
		~cntSeqKick14=0;
		~cntSeqKick15=0;
		~cntSeqKick16=0;
	}

	*freeOn {

		~seqFreeKickBut.free;
		~seqFreeKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqKick.free;
				});
			},
			'/seqFreeKick'
		);
	}
	*upOn {
		~ifSeqUpKickBut.free;
		~ifSeqUpKickBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqUpKick01 = ~cntSeqUpKick01 + 1;
				~cntSeqUpKick01.switch(
					0,{},
					1,{
						IFSeqKick.stGrpSet(1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0);
					},
					2,{
						IFSeqKick.stGrpSet(1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0);
					},
					3,{
						IFSeqKick.stGrpSet(0,1,1,0,1,1,0,0,0,1,1,0,1,0,1,0);
					},
					4,{
						IFSeqKick.stGrpSet(1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0);
						~cntSeqUpKick01=0;
					}
				)}
			);
			},
			'/seqUpKick'
		);
	}

	*randOn {
		~ifSeqRandKickBut.free;
		~ifSeqRandKickBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqRandKick01 = ~cntSeqRandKick01 + 1;
				~cntSeqRandKick01.switch(
					0,{},
					1,{
						IFSeqKick.st01([0,1].choose);
						IFSeqKick.st02([0,1].choose);
						IFSeqKick.st03([0,1].choose);
						IFSeqKick.st04([0,1].choose);
						IFSeqKick.st05([0,1].choose);
						IFSeqKick.st06([0,1].choose);
						IFSeqKick.st07([0,1].choose);
						IFSeqKick.st08([0,1].choose);
						IFSeqKick.st09([0,1].choose);
						IFSeqKick.st10([0,1].choose);
						IFSeqKick.st11([0,1].choose);
						IFSeqKick.st12([0,1].choose);
						IFSeqKick.st13([0,1].choose);
						IFSeqKick.st14([0,1].choose);
						IFSeqKick.st15([0,1].choose);
						IFSeqKick.st16([0,1].choose);
						~cntSeqRandKick01=0;
					}
				)}
			);
			},
			'/seqRandKick'
		);
	}

	*on {
		IFSeqKick.upOn;
		IFSeqKick.randOn;
		IFSeqKick.freeOn;

		~ifSeqKickBut01.free;
		~ifSeqKickBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick01 = ~cntSeqKick01 + 1;
				~cntSeqKick01.switch(
					0,{}, 1,{IFSeqKick.st01(1);}, 2,{IFSeqKick.st01(0);}
				)}
			);
			},
			'/ifSeq/1/1'
		);
		~ifSeqKickBut02.free;
		~ifSeqKickBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick02 = ~cntSeqKick02 + 1;
				~cntSeqKick02.switch(
					0,{}, 1,{IFSeqKick.st02(1);}, 2,{IFSeqKick.st02(0);}
				)}
			);
			},
			'/ifSeq/1/2'
		);
		~ifSeqKickBut03.free;
		~ifSeqKickBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick03 = ~cntSeqKick03 + 1;
				~cntSeqKick03.switch(
					0,{}, 1,{IFSeqKick.st03(1);}, 2,{IFSeqKick.st03(0);}
				)}
			);
			},
			'/ifSeq/1/3'
		);
		~ifSeqKickBut04.free;
		~ifSeqKickBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick04 = ~cntSeqKick04 + 1;
				~cntSeqKick04.switch(
					0,{}, 1,{IFSeqKick.st04(1);}, 2,{IFSeqKick.st04(0);}
				)}
			);
			},
			'/ifSeq/1/4'
		);
		~ifSeqKickBut05.free;
		~ifSeqKickBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick05 = ~cntSeqKick05 + 1;
				~cntSeqKick05.switch(
					0,{}, 1,{IFSeqKick.st05(1);}, 2,{IFSeqKick.st05(0);}
				)}
			);
			},
			'/ifSeq/1/5'
		);
		~ifSeqKickBut06.free;
		~ifSeqKickBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick06 = ~cntSeqKick06 + 1;
				~cntSeqKick06.switch(
					0,{}, 1,{IFSeqKick.st06(1);}, 2,{IFSeqKick.st06(0);}
				)}
			);
			},
			'/ifSeq/1/6'
		);
		~ifSeqKickBut07.free;
		~ifSeqKickBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick07 = ~cntSeqKick07 + 1;
				~cntSeqKick07.switch(
					0,{}, 1,{IFSeqKick.st07(1);}, 2,{IFSeqKick.st07(0);}
				)}
			);
			},
			'/ifSeq/1/7'
		);
		~ifSeqKickBut08.free;
		~ifSeqKickBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick08 = ~cntSeqKick08 + 1;
				~cntSeqKick08.switch(
					0,{}, 1,{IFSeqKick.st08(1);}, 2,{IFSeqKick.st08(0);}
				)}
			);
			},
			'/ifSeq/1/8'
		);

		~ifSeqKickBut09.free;
		~ifSeqKickBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick09 = ~cntSeqKick09 + 1;
				~cntSeqKick09.switch(
					0,{}, 1,{IFSeqKick.st09(1);}, 2,{IFSeqKick.st09(0);}
				)}
			);
			},
			'/ifSeq/1/9'
		);
		~ifSeqKickBut10.free;
		~ifSeqKickBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick10 = ~cntSeqKick10 + 1;
				~cntSeqKick10.switch(
					0,{}, 1,{IFSeqKick.st10(1);}, 2,{IFSeqKick.st10(0);}
				)}
			);
			},
			'/ifSeq/1/10'
		);
		~ifSeqKickBut11.free;
		~ifSeqKickBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick11 = ~cntSeqKick11 + 1;
				~cntSeqKick11.switch(
					0,{}, 1,{IFSeqKick.st11(1);}, 2,{IFSeqKick.st11(0);}
				)}
			);
			},
			'/ifSeq/1/11'
		);
		~ifSeqKickBut12.free;
		~ifSeqKickBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick12 = ~cntSeqKick12 + 1;
				~cntSeqKick12.switch(
					0,{}, 1,{IFSeqKick.st12(1);}, 2,{IFSeqKick.st12(0);}
				)}
			);
			},
			'/ifSeq/1/12'
		);
		~ifSeqKickBut13.free;
		~ifSeqKickBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick13 = ~cntSeqKick13 + 1;
				~cntSeqKick13.switch(
					0,{}, 1,{IFSeqKick.st13(1);}, 2,{IFSeqKick.st13(0);}
				)}
			);
			},
			'/ifSeq/1/13'
		);
		~ifSeqKickBut14.free;
		~ifSeqKickBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick14 = ~cntSeqKick14 + 1;
				~cntSeqKick14.switch(
					0,{}, 1,{IFSeqKick.st14(1);}, 2,{IFSeqKick.st14(0);}
				)}
			);
			},
			'/ifSeq/1/14'
		);
		~ifSeqKickBut15.free;
		~ifSeqKickBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick15 = ~cntSeqKick15 + 1;
				~cntSeqKick15.switch(
					0,{}, 1,{IFSeqKick.st15(1);}, 2,{IFSeqKick.st15(0);}
				)}
			);
			},
			'/ifSeq/1/15'
		);
		~ifSeqKickBut16.free;
		~ifSeqKickBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqKick16 = ~cntSeqKick16 + 1;
				~cntSeqKick16.switch(
					0,{}, 1,{IFSeqKick.st16(1);}, 2,{IFSeqKick.st16(0);}
				)}
			);
			},
			'/ifSeq/1/16'
		);


	}

	*st01 {|i|
		~cntSeqKick01=i;
		~seqKick01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick01', i);
	}
	*st02 {|i|
		~cntSeqKick02=i;
		~seqKick02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick02', i);
	}
	*st03 {|i|
		~cntSeqKick03=i;
		~seqKick03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick03', i);
	}
	*st04 {|i|
		~cntSeqKick04=i;
		~seqKick04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick04', i);
	}
	*st05 {|i|
		~cntSeqKick05=i;
		~seqKick05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick05', i);
	}
	*st06 {|i|
		~cntSeqKick06=i;
		~seqKick06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick06', i);
	}
	*st07 {|i|
		~cntSeqKick07=i;
		~seqKick07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick07', i);
	}
	*st08 {|i|
		~cntSeqKick08=i;
		~seqKick08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick08', i);
	}

	*st09 {|i|
		~cntSeqKick09=i;
		~seqKick09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick09', i);
	}
	*st10 {|i|
		~cntSeqKick10=i;
		~seqKick10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick10', i);
	}
	*st11 {|i|
		~cntSeqKick11=i;
		~seqKick11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick11', i);
	}
	*st12 {|i|
		~cntSeqKick12=i;
		~seqKick12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick12', i);
	}
	*st13 {|i|
		~cntSeqKick13=i;
		~seqKick13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick13', i);
	}
	*st14 {|i|
		~cntSeqKick14=i;
		~seqKick14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick14', i);
	}
	*st15 {|i|
		~cntSeqKick15=i;
		~seqKick15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick15', i);
	}
	*st16 {|i|
		~cntSeqKick16=i;
		~seqKick16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledKick16', i);
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
		{ i == 16 } { this.step16; }
	}

	*step01{
		~amp1Kick.source  =  Pseq([~seqKick01.next*~seqVelKick01.next], inf);
		~octKick.source = Pseq([~seqOctKick01.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick01.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick01.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick01.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick01.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick01.next], inf);
	}
	*step02{
		~amp1Kick.source  =  Pseq([~seqKick02.next*~seqVelKick02.next], inf);
		~octKick.source = Pseq([~seqOctKick02.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick02.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick02.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick02.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick02.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick02.next], inf);
	}
	*step03{
		~amp1Kick.source  =  Pseq([~seqKick03.next*~seqVelKick03.next], inf);
		~octKick.source = Pseq([~seqOctKick03.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick03.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick03.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick03.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick03.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick03.next], inf);
	}
	*step04{
		~amp1Kick.source  =  Pseq([~seqKick04.next*~seqVelKick04.next], inf);
		~octKick.source = Pseq([~seqOctKick04.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick04.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick04.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick04.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick04.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick04.next], inf);
	}
	*step05{
		~amp1Kick.source  =  Pseq([~seqKick05.next*~seqVelKick05.next], inf);
		~octKick.source = Pseq([~seqOctKick05.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick05.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick05.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick05.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick05.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick05.next], inf);
	}
	*step06{
		~amp1Kick.source  =  Pseq([~seqKick06.next*~seqVelKick06.next], inf);
		~octKick.source = Pseq([~seqOctKick06.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick06.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick06.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick06.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick06.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick06.next], inf);
	}
	*step07{
		~amp1Kick.source  =  Pseq([~seqKick07.next*~seqVelKick07.next], inf);
		~octKick.source = Pseq([~seqOctKick07.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick07.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick07.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick07.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick07.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick07.next], inf);
	}
	*step08{
		~amp1Kick.source  =  Pseq([~seqKick08.next*~seqVelKick08.next], inf);
		~octKick.source = Pseq([~seqOctKick08.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick08.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick08.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick08.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick08.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick08.next], inf);
	}
	*step09{
		~amp1Kick.source  =  Pseq([~seqKick09.next*~seqVelKick09.next], inf);
		~octKick.source = Pseq([~seqOctKick09.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick09.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick09.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick09.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick09.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick09.next], inf);
	}
	*step10{
		~amp1Kick.source  =  Pseq([~seqKick10.next*~seqVelKick10.next], inf);
		~octKick.source = Pseq([~seqOctKick10.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick10.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick10.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick10.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick10.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick10.next], inf);
	}
	*step11{
		~amp1Kick.source  =  Pseq([~seqKick11.next*~seqVelKick11.next], inf);
		~octKick.source = Pseq([~seqOctKick11.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick11.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick11.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick11.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick11.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick11.next], inf);
	}
	*step12{
		~amp1Kick.source  =  Pseq([~seqKick12.next*~seqVelKick12.next], inf);
		~octKick.source = Pseq([~seqOctKick12.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick12.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick12.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick12.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick12.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick12.next], inf);
	}
	*step13{
		~amp1Kick.source  =  Pseq([~seqKick13.next*~seqVelKick13.next], inf);
		~octKick.source = Pseq([~seqOctKick13.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick13.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick13.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick13.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick13.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick13.next], inf);
	}
	*step14{
		~amp1Kick.source  =  Pseq([~seqKick14.next*~seqVelKick14.next], inf);
		~octKick.source = Pseq([~seqOctKick14.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick14.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick14.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick14.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick14.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick14.next], inf);
	}
	*step15{
		~amp1Kick.source  =  Pseq([~seqKick15.next*~seqVelKick15.next], inf);
		~octKick.source = Pseq([~seqOctKick15.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick15.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick15.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick15.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick15.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick15.next], inf);
	}
	*step16{
		~amp1Kick.source  =  Pseq([~seqKick16.next*~seqVelKick16.next], inf);
		~octKick.source = Pseq([~seqOctKick16.next], inf);
		~nt1Kick.source   =  Pseq([~seqNtKick16.next], inf);
		~sus1Kick.source  =  Pseq([~seqSusKick16.next], inf);
		~tmKick.source    =  Pseq([~seqTmKick16.next], inf);
		~dur1Kick.source    =  Pseq([~seqDurKick16.next], inf);
		~ampStKick.source  =  Pseq([~seqStKick16.next], inf);
	}
	*stGrp {|i|

		IFSeqKick.st01(i); IFSeqKick.st02(i); IFSeqKick.st03(i); IFSeqKick.st04(i);
		IFSeqKick.st05(i); IFSeqKick.st06(i); IFSeqKick.st07(i); IFSeqKick.st08(i);
		IFSeqKick.st09(i); IFSeqKick.st10(i); IFSeqKick.st11(i); IFSeqKick.st12(i);
		IFSeqKick.st13(i); IFSeqKick.st14(i); IFSeqKick.st15(i); IFSeqKick.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqKick.st01(s01); IFSeqKick.st02(s02); IFSeqKick.st03(s03); IFSeqKick.st04(s04);
		IFSeqKick.st05(s05); IFSeqKick.st06(s06); IFSeqKick.st07(s07); IFSeqKick.st08(s08);
		IFSeqKick.st09(s09); IFSeqKick.st10(s10); IFSeqKick.st11(s11); IFSeqKick.st12(s12);
		IFSeqKick.st13(s13); IFSeqKick.st14(s14); IFSeqKick.st15(s15); IFSeqKick.st16(s16);
	}

}

