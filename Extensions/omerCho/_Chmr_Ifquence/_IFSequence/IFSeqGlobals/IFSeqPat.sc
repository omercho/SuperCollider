/*
IFSeqPat.st16(0);
IFSeqPat.stepPack(1);
*/

IFSeqPat {
	*loadAll {

		this.loadProxy;
		this.countReset;

		IFSeqNtPat.loadAll;
		IFSeqDurPat.loadAll;
		this.on;
	}

	*loadProxy {

		~seqPat01 = PatternProxy( Pseq([1], 1));
		~seqPat02 = PatternProxy( Pseq([1], 1));
		~seqPat03 = PatternProxy( Pseq([1], 1));
		~seqPat04 = PatternProxy( Pseq([1], 1));
		~seqPat05 = PatternProxy( Pseq([1], 1));
		~seqPat06 = PatternProxy( Pseq([1], 1));
		~seqPat07 = PatternProxy( Pseq([1], 1));
		~seqPat08 = PatternProxy( Pseq([1], 1));

		~seqPat09 = PatternProxy( Pseq([1], 1));
		~seqPat10 = PatternProxy( Pseq([1], 1));
		~seqPat11 = PatternProxy( Pseq([1], 1));
		~seqPat12 = PatternProxy( Pseq([1], 1));
		~seqPat13 = PatternProxy( Pseq([1], 1));
		~seqPat14 = PatternProxy( Pseq([1], 1));
		~seqPat15 = PatternProxy( Pseq([1], 1));
		~seqPat16 = PatternProxy( Pseq([1], 1));
	}


	*free {
		~cntSeqUpPat01=0;
		~cntSeqRandPat01=0;

		IFSeqPat.st01(0);
		IFSeqPat.st02(0);
		IFSeqPat.st03(0);
		IFSeqPat.st04(0);
		IFSeqPat.st05(0);
		IFSeqPat.st06(0);
		IFSeqPat.st07(0);
		IFSeqPat.st08(0);

		IFSeqPat.st09(0);
		IFSeqPat.st10(0);
		IFSeqPat.st11(0);
		IFSeqPat.st12(0);
		IFSeqPat.st13(0);
		IFSeqPat.st14(0);
		IFSeqPat.st15(0);
		IFSeqPat.st16(0);
	}

	*countReset {
		~cntSeqUpPat01=0;
		~cntSeqRandPat01=0;

		~cntSeqPat01=0;
		~cntSeqPat02=0;
		~cntSeqPat03=0;
		~cntSeqPat04=0;
		~cntSeqPat05=0;
		~cntSeqPat06=0;
		~cntSeqPat07=0;
		~cntSeqPat08=0;

		~cntSeqPat09=0;
		~cntSeqPat10=0;
		~cntSeqPat11=0;
		~cntSeqPat12=0;
		~cntSeqPat13=0;
		~cntSeqPat14=0;
		~cntSeqPat15=0;
		~cntSeqPat16=0;
	}

	*freeOn {

		~seqFreePatBut.free;
		~seqFreePatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqPat.free;
				});
			},
			'/seqFreePat'
		);
	}
	*upOn {
		~ifSeqUpPatBut.free;
		~ifSeqUpPatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqUpPat01 = ~cntSeqUpPat01 + 1;
				~cntSeqUpPat01.switch(
					0,{},
					1,{
						IFSeqPat.stGrp(1);
					},
					2,{
						IFSeqPat.stGrpSet(1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,0);
					},
					3,{
						IFSeqPat.stGrpSet(0,1,1,0,1,1,0,0,0,1,1,0,1,0,1,0);
					},
					4,{
						IFSeqPat.stGrpSet(1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0);
						~cntSeqUpPat01=0;
					}
				)}
			);
			},
			'/seqUpPat'
		);
	}

	*randOn {
		~ifSeqRandPatBut.free;
		~ifSeqRandPatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqRandPat01 = ~cntSeqRandPat01 + 1;
				~cntSeqRandPat01.switch(
					0,{},
					1,{
						IFSeqPat.st01([0,1].choose);
						IFSeqPat.st02([0,1].choose);
						IFSeqPat.st03([0,1].choose);
						IFSeqPat.st04([0,1].choose);
						IFSeqPat.st05([0,1].choose);
						IFSeqPat.st06([0,1].choose);
						IFSeqPat.st07([0,1].choose);
						IFSeqPat.st08([0,1].choose);
						IFSeqPat.st09([0,1].choose);
						IFSeqPat.st10([0,1].choose);
						IFSeqPat.st11([0,1].choose);
						IFSeqPat.st12([0,1].choose);
						IFSeqPat.st13([0,1].choose);
						IFSeqPat.st14([0,1].choose);
						IFSeqPat.st15([0,1].choose);
						IFSeqPat.st16([0,1].choose);
						~cntSeqRandPat01=0;
					}
				)}
			);
			},
			'/seqRandPat'
		);
	}

	*on {
		IFSeqPat.upOn;
		IFSeqPat.randOn;
		IFSeqPat.freeOn;

		~ifSeqPatBut01.free;
		~ifSeqPatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat01 = ~cntSeqPat01 + 1;
				~cntSeqPat01.switch(
					0,{}, 1,{IFSeqPat.st01(1);}, 2,{IFSeqPat.st01(0);}
				)}
			);
			},
			'/ifSeq/9/1'
		);
		~ifSeqPatBut02.free;
		~ifSeqPatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat02 = ~cntSeqPat02 + 1;
				~cntSeqPat02.switch(
					0,{}, 1,{IFSeqPat.st02(1);}, 2,{IFSeqPat.st02(0);}
				)}
			);
			},
			'/ifSeq/9/2'
		);
		~ifSeqPatBut03.free;
		~ifSeqPatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat03 = ~cntSeqPat03 + 1;
				~cntSeqPat03.switch(
					0,{}, 1,{IFSeqPat.st03(1);}, 2,{IFSeqPat.st03(0);}
				)}
			);
			},
			'/ifSeq/9/3'
		);
		~ifSeqPatBut04.free;
		~ifSeqPatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat04 = ~cntSeqPat04 + 1;
				~cntSeqPat04.switch(
					0,{}, 1,{IFSeqPat.st04(1);}, 2,{IFSeqPat.st04(0);}
				)}
			);
			},
			'/ifSeq/9/4'
		);
		~ifSeqPatBut05.free;
		~ifSeqPatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat05 = ~cntSeqPat05 + 1;
				~cntSeqPat05.switch(
					0,{}, 1,{IFSeqPat.st05(1);}, 2,{IFSeqPat.st05(0);}
				)}
			);
			},
			'/ifSeq/9/5'
		);
		~ifSeqPatBut06.free;
		~ifSeqPatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat06 = ~cntSeqPat06 + 1;
				~cntSeqPat06.switch(
					0,{}, 1,{IFSeqPat.st06(1);}, 2,{IFSeqPat.st06(0);}
				)}
			);
			},
			'/ifSeq/9/6'
		);
		~ifSeqPatBut07.free;
		~ifSeqPatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat07 = ~cntSeqPat07 + 1;
				~cntSeqPat07.switch(
					0,{}, 1,{IFSeqPat.st07(1);}, 2,{IFSeqPat.st07(0);}
				)}
			);
			},
			'/ifSeq/9/7'
		);
		~ifSeqPatBut08.free;
		~ifSeqPatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat08 = ~cntSeqPat08 + 1;
				~cntSeqPat08.switch(
					0,{}, 1,{IFSeqPat.st08(1);}, 2,{IFSeqPat.st08(0);}
				)}
			);
			},
			'/ifSeq/9/8'
		);

		~ifSeqPatBut09.free;
		~ifSeqPatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat09 = ~cntSeqPat09 + 1;
				~cntSeqPat09.switch(
					0,{}, 1,{IFSeqPat.st09(1);}, 2,{IFSeqPat.st09(0);}
				)}
			);
			},
			'/ifSeq/9/9'
		);
		~ifSeqPatBut10.free;
		~ifSeqPatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat10 = ~cntSeqPat10 + 1;
				~cntSeqPat10.switch(
					0,{}, 1,{IFSeqPat.st10(1);}, 2,{IFSeqPat.st10(0);}
				)}
			);
			},
			'/ifSeq/9/10'
		);
		~ifSeqPatBut11.free;
		~ifSeqPatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat11 = ~cntSeqPat11 + 1;
				~cntSeqPat11.switch(
					0,{}, 1,{IFSeqPat.st11(1);}, 2,{IFSeqPat.st11(0);}
				)}
			);
			},
			'/ifSeq/9/11'
		);
		~ifSeqPatBut12.free;
		~ifSeqPatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat12 = ~cntSeqPat12 + 1;
				~cntSeqPat12.switch(
					0,{}, 1,{IFSeqPat.st12(1);}, 2,{IFSeqPat.st12(0);}
				)}
			);
			},
			'/ifSeq/9/12'
		);
		~ifSeqPatBut13.free;
		~ifSeqPatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat13 = ~cntSeqPat13 + 1;
				~cntSeqPat13.switch(
					0,{}, 1,{IFSeqPat.st13(1);}, 2,{IFSeqPat.st13(0);}
				)}
			);
			},
			'/ifSeq/9/13'
		);
		~ifSeqPatBut14.free;
		~ifSeqPatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat14 = ~cntSeqPat14 + 1;
				~cntSeqPat14.switch(
					0,{}, 1,{IFSeqPat.st14(1);}, 2,{IFSeqPat.st14(0);}
				)}
			);
			},
			'/ifSeq/9/14'
		);
		~ifSeqPatBut15.free;
		~ifSeqPatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat15 = ~cntSeqPat15 + 1;
				~cntSeqPat15.switch(
					0,{}, 1,{IFSeqPat.st15(1);}, 2,{IFSeqPat.st15(0);}
				)}
			);
			},
			'/ifSeq/9/15'
		);
		~ifSeqPatBut16.free;
		~ifSeqPatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqPat16 = ~cntSeqPat16 + 1;
				~cntSeqPat16.switch(
					0,{}, 1,{IFSeqPat.st16(1);}, 2,{IFSeqPat.st16(0);}
			)});
			},'/ifSeq/9/16');
	}

	*st01 {|i|
		~cntSeqPat01=i;
		~seqPat01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat01', i);
	}
	*st02 {|i|
		~cntSeqPat02=i;
		~seqPat02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat02', i);
	}
	*st03 {|i|
		~cntSeqPat03=i;
		~seqPat03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat03', i);
	}
	*st04 {|i|
		~cntSeqPat04=i;
		~seqPat04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat04', i);
	}
	*st05 {|i|
		~cntSeqPat05=i;
		~seqPat05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat05', i);
	}
	*st06 {|i|
		~cntSeqPat06=i;
		~seqPat06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat06', i);
	}
	*st07 {|i|
		~cntSeqPat07=i;
		~seqPat07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat07', i);
	}
	*st08 {|i|
		~cntSeqPat08=i;
		~seqPat08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat08', i);
	}

	*st09 {|i|
		~cntSeqPat09=i;
		~seqPat09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat09', i);
	}
	*st10 {|i|
		~cntSeqPat10=i;
		~seqPat10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat10', i);
	}
	*st11 {|i|
		~cntSeqPat11=i;
		~seqPat11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat11', i);
	}
	*st12 {|i|
		~cntSeqPat12=i;
		~seqPat12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat12', i);
	}
	*st13 {|i|
		~cntSeqPat13=i;
		~seqPat13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat13', i);
	}
	*st14 {|i|
		~cntSeqPat14=i;
		~seqPat14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat14', i);
	}
	*st15 {|i|
		~cntSeqPat15=i;
		~seqPat15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat15', i);
	}
	*st16 {|i|
		~cntSeqPat16=i;
		~seqPat16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledPat16', i);
	}

	*stepPack{|i|
		case
		{ i == 1 } { this.step01; }
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
		~amp1Pat.source  =  Pseq([~seqPat01.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat01.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat01.next], inf);
	}
	*step02{
		~amp1Pat.source  =  Pseq([~seqPat02.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat02.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat02.next], inf);
	}
	*step03{
		~amp1Pat.source  =  Pseq([~seqPat03.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat03.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat03.next], inf);
	}
	*step04{
		~amp1Pat.source  =  Pseq([~seqPat04.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat04.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat04.next], inf);
	}
	*step05{
		~amp1Pat.source  =  Pseq([~seqPat05.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat05.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat05.next], inf);
	}
	*step06{
		~amp1Pat.source  =  Pseq([~seqPat06.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat06.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat06.next], inf);
	}
	*step07{
		~amp1Pat.source  =  Pseq([~seqPat07.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat07.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat07.next], inf);
	}
	*step08{
		~amp1Pat.source  =  Pseq([~seqPat08.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat08.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat08.next], inf);
	}
	*step09{
		~amp1Pat.source  =  Pseq([~seqPat09.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat09.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat09.next], inf);
	}
	*step10{
		~amp1Pat.source  =  Pseq([~seqPat10.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat10.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat10.next], inf);
	}
	*step11{
		~amp1Pat.source  =  Pseq([~seqPat11.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat11.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat11.next], inf);
	}
	*step12{
		~amp1Pat.source  =  Pseq([~seqPat12.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat12.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat12.next], inf);
	}
	*step13{
		~amp1Pat.source  =  Pseq([~seqPat13.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat13.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat13.next], inf);
	}
	*step14{
		~amp1Pat.source  =  Pseq([~seqPat14.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat14.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat14.next], inf);
	}
	*step15{
		~amp1Pat.source  =  Pseq([~seqPat15.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat15.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat15.next], inf);
	}
	*step16{
		~amp1Pat.source  =  Pseq([~seqPat16.next], inf);
		~ifPitchMst.source   =  Pseq([~seqNtPat16.next], inf);
		~durMaster.source    =  Pseq([~seqDurPat16.next], inf);
	}

	*stGrp {|i|

		IFSeqPat.st01(i); IFSeqPat.st02(i); IFSeqPat.st03(i); IFSeqPat.st04(i);
		IFSeqPat.st05(i); IFSeqPat.st06(i); IFSeqPat.st07(i); IFSeqPat.st08(i);
		IFSeqPat.st09(i); IFSeqPat.st10(i); IFSeqPat.st11(i); IFSeqPat.st12(i);
		IFSeqPat.st13(i); IFSeqPat.st14(i); IFSeqPat.st15(i); IFSeqPat.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqPat.st01(s01); IFSeqPat.st02(s02); IFSeqPat.st03(s03); IFSeqPat.st04(s04);
		IFSeqPat.st05(s05); IFSeqPat.st06(s06); IFSeqPat.st07(s07); IFSeqPat.st08(s08);
		IFSeqPat.st09(s09); IFSeqPat.st10(s10); IFSeqPat.st11(s11); IFSeqPat.st12(s12);
		IFSeqPat.st13(s13); IFSeqPat.st14(s14); IFSeqPat.st15(s15); IFSeqPat.st16(s16);
	}
}

