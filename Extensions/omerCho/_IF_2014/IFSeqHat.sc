/*
IFSeqHat.st16(0);
IFSeqHat.stepPack(1);
*/

IFSeqHat {
	*loadAll {

		this.loadProxy;
		this.countReset;

		IFSeqOctHat.loadAll;
		IFSeqNtHat.loadAll;
		IFSeqVelHat.loadAll;
		IFSeqSusHat.loadAll;
		IFSeqTmHat.loadAll;
		this.on;
	}

	*loadProxy {

		~seqHat01 = PatternProxy( Pseq([0], 1));
		~seqHat02 = PatternProxy( Pseq([0], 1));
		~seqHat03 = PatternProxy( Pseq([0], 1));
		~seqHat04 = PatternProxy( Pseq([0], 1));
		~seqHat05 = PatternProxy( Pseq([0], 1));
		~seqHat06 = PatternProxy( Pseq([0], 1));
		~seqHat07 = PatternProxy( Pseq([0], 1));
		~seqHat08 = PatternProxy( Pseq([0], 1));

		~seqHat09 = PatternProxy( Pseq([0], 1));
		~seqHat10 = PatternProxy( Pseq([0], 1));
		~seqHat11 = PatternProxy( Pseq([0], 1));
		~seqHat12 = PatternProxy( Pseq([0], 1));
		~seqHat13 = PatternProxy( Pseq([0], 1));
		~seqHat14 = PatternProxy( Pseq([0], 1));
		~seqHat15 = PatternProxy( Pseq([0], 1));
		~seqHat16 = PatternProxy( Pseq([0], 1));
	}


	*free {
		~cntSeqUpHat01=0;
		~cntSeqRandHat01=0;

		IFSeqHat.st01(0);
		IFSeqHat.st02(0);
		IFSeqHat.st03(0);
		IFSeqHat.st04(0);
		IFSeqHat.st05(0);
		IFSeqHat.st06(0);
		IFSeqHat.st07(0);
		IFSeqHat.st08(0);

		IFSeqHat.st09(0);
		IFSeqHat.st10(0);
		IFSeqHat.st11(0);
		IFSeqHat.st12(0);
		IFSeqHat.st13(0);
		IFSeqHat.st14(0);
		IFSeqHat.st15(0);
		IFSeqHat.st16(0);
	}

	*countReset {
		~cntSeqUpHat01=0;
		~cntSeqRandHat01=0;

		~cntSeqHat01=0;
		~cntSeqHat02=0;
		~cntSeqHat03=0;
		~cntSeqHat04=0;
		~cntSeqHat05=0;
		~cntSeqHat06=0;
		~cntSeqHat07=0;
		~cntSeqHat08=0;

		~cntSeqHat09=0;
		~cntSeqHat10=0;
		~cntSeqHat11=0;
		~cntSeqHat12=0;
		~cntSeqHat13=0;
		~cntSeqHat14=0;
		~cntSeqHat15=0;
		~cntSeqHat16=0;
	}

	*freeOn {

		~seqFreeHatBut.free;
		~seqFreeHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqHat.free;
				});
			},
			'/seqFreeHat'
		);
	}
	*upOn {
		~ifSeqUpHatBut.free;
		~ifSeqUpHatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqUpHat01 = ~cntSeqUpHat01 + 1;
				~cntSeqUpHat01.switch(
					0,{},
					1,{
						IFSeqHat.st01(1);
						IFSeqHat.st02(0);
						IFSeqHat.st03(0);
						IFSeqHat.st04(0);
						IFSeqHat.st05(1);
						IFSeqHat.st06(0);
						IFSeqHat.st07(0);
						IFSeqHat.st08(0);

						IFSeqHat.st09(1);
						IFSeqHat.st10(0);
						IFSeqHat.st11(0);
						IFSeqHat.st12(0);
						IFSeqHat.st13(1);
						IFSeqHat.st14(0);
						IFSeqHat.st15(0);
						IFSeqHat.st16(0);
					},
					2,{
						IFSeqHat.st01(1);
						IFSeqHat.st02(0);
						IFSeqHat.st03(1);
						IFSeqHat.st04(0);
						IFSeqHat.st05(1);
						IFSeqHat.st06(0);
						IFSeqHat.st07(1);
						IFSeqHat.st08(0);

						IFSeqHat.st09(1);
						IFSeqHat.st10(0);
						IFSeqHat.st11(1);
						IFSeqHat.st12(0);
						IFSeqHat.st13(1);
						IFSeqHat.st14(0);
						IFSeqHat.st15(1);
						IFSeqHat.st16(0);
					},
					3,{
						IFSeqHat.st01(1);
						IFSeqHat.st02(0);
						IFSeqHat.st03(1);
						IFSeqHat.st04(0);
						IFSeqHat.st05(1);
						IFSeqHat.st06(0);
						IFSeqHat.st07(1);
						IFSeqHat.st08(0);

						IFSeqHat.st09(1);
						IFSeqHat.st10(0);
						IFSeqHat.st11(1);
						IFSeqHat.st12(0);
						IFSeqHat.st13(1);
						IFSeqHat.st14(1);
						IFSeqHat.st15(0);
						IFSeqHat.st16(0);
					},
					4,{
						IFSeqHat.st01(1);
						IFSeqHat.st02(1);
						IFSeqHat.st03(0);
						IFSeqHat.st04(0);
						IFSeqHat.st05(1);
						IFSeqHat.st06(0);
						IFSeqHat.st07(1);
						IFSeqHat.st08(0);

						IFSeqHat.st09(1);
						IFSeqHat.st10(1);
						IFSeqHat.st11(0);
						IFSeqHat.st12(1);
						IFSeqHat.st13(1);
						IFSeqHat.st14(0);
						IFSeqHat.st15(1);
						IFSeqHat.st16(0);
						~cntSeqUpHat01=0;
					}
				)}
			);
			},
			'/seqUpHat'
		);
	}

	*randOn {
		~ifSeqRandHatBut.free;
		~ifSeqRandHatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqRandHat01 = ~cntSeqRandHat01 + 1;
				~cntSeqRandHat01.switch(
					0,{},
					1,{
						IFSeqHat.st01([0,1].choose);
						IFSeqHat.st02([0,1].choose);
						IFSeqHat.st03([0,1].choose);
						IFSeqHat.st04([0,1].choose);
						IFSeqHat.st05([0,1].choose);
						IFSeqHat.st06([0,1].choose);
						IFSeqHat.st07([0,1].choose);
						IFSeqHat.st08([0,1].choose);
						IFSeqHat.st09([0,1].choose);
						IFSeqHat.st10([0,1].choose);
						IFSeqHat.st11([0,1].choose);
						IFSeqHat.st12([0,1].choose);
						IFSeqHat.st13([0,1].choose);
						IFSeqHat.st14([0,1].choose);
						IFSeqHat.st15([0,1].choose);
						IFSeqHat.st16([0,1].choose);
						~cntSeqRandHat01=0;
					}
				)}
			);
			},
			'/seqRandHat'
		);
	}

	*on {
		IFSeqHat.upOn;
		IFSeqHat.randOn;
		IFSeqHat.freeOn;

		~ifSeqHatBut01.free;
		~ifSeqHatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat01 = ~cntSeqHat01 + 1;
				~cntSeqHat01.switch(
					0,{}, 1,{IFSeqHat.st01(1);}, 2,{IFSeqHat.st01(0);}
				)}
			);
			},
			'/ifSeq/3/1'
		);
		~ifSeqHatBut02.free;
		~ifSeqHatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat02 = ~cntSeqHat02 + 1;
				~cntSeqHat02.switch(
					0,{}, 1,{IFSeqHat.st02(1);}, 2,{IFSeqHat.st02(0);}
				)}
			);
			},
			'/ifSeq/3/2'
		);
		~ifSeqHatBut03.free;
		~ifSeqHatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat03 = ~cntSeqHat03 + 1;
				~cntSeqHat03.switch(
					0,{}, 1,{IFSeqHat.st03(1);}, 2,{IFSeqHat.st03(0);}
				)}
			);
			},
			'/ifSeq/3/3'
		);
		~ifSeqHatBut04.free;
		~ifSeqHatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat04 = ~cntSeqHat04 + 1;
				~cntSeqHat04.switch(
					0,{}, 1,{IFSeqHat.st04(1);}, 2,{IFSeqHat.st04(0);}
				)}
			);
			},
			'/ifSeq/3/4'
		);
		~ifSeqHatBut05.free;
		~ifSeqHatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat05 = ~cntSeqHat05 + 1;
				~cntSeqHat05.switch(
					0,{}, 1,{IFSeqHat.st05(1);}, 2,{IFSeqHat.st05(0);}
				)}
			);
			},
			'/ifSeq/3/5'
		);
		~ifSeqHatBut06.free;
		~ifSeqHatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat06 = ~cntSeqHat06 + 1;
				~cntSeqHat06.switch(
					0,{}, 1,{IFSeqHat.st06(1);}, 2,{IFSeqHat.st06(0);}
				)}
			);
			},
			'/ifSeq/3/6'
		);
		~ifSeqHatBut07.free;
		~ifSeqHatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat07 = ~cntSeqHat07 + 1;
				~cntSeqHat07.switch(
					0,{}, 1,{IFSeqHat.st07(1);}, 2,{IFSeqHat.st07(0);}
				)}
			);
			},
			'/ifSeq/3/7'
		);
		~ifSeqHatBut08.free;
		~ifSeqHatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat08 = ~cntSeqHat08 + 1;
				~cntSeqHat08.switch(
					0,{}, 1,{IFSeqHat.st08(1);}, 2,{IFSeqHat.st08(0);}
				)}
			);
			},
			'/ifSeq/3/8'
		);

		~ifSeqHatBut09.free;
		~ifSeqHatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat09 = ~cntSeqHat09 + 1;
				~cntSeqHat09.switch(
					0,{}, 1,{IFSeqHat.st09(1);}, 2,{IFSeqHat.st09(0);}
				)}
			);
			},
			'/ifSeq/3/9'
		);
		~ifSeqHatBut10.free;
		~ifSeqHatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat10 = ~cntSeqHat10 + 1;
				~cntSeqHat10.switch(
					0,{}, 1,{IFSeqHat.st10(1);}, 2,{IFSeqHat.st10(0);}
				)}
			);
			},
			'/ifSeq/3/10'
		);
		~ifSeqHatBut11.free;
		~ifSeqHatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat11 = ~cntSeqHat11 + 1;
				~cntSeqHat11.switch(
					0,{}, 1,{IFSeqHat.st11(1);}, 2,{IFSeqHat.st11(0);}
				)}
			);
			},
			'/ifSeq/3/11'
		);
		~ifSeqHatBut12.free;
		~ifSeqHatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat12 = ~cntSeqHat12 + 1;
				~cntSeqHat12.switch(
					0,{}, 1,{IFSeqHat.st12(1);}, 2,{IFSeqHat.st12(0);}
				)}
			);
			},
			'/ifSeq/3/12'
		);
		~ifSeqHatBut13.free;
		~ifSeqHatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat13 = ~cntSeqHat13 + 1;
				~cntSeqHat13.switch(
					0,{}, 1,{IFSeqHat.st13(1);}, 2,{IFSeqHat.st13(0);}
				)}
			);
			},
			'/ifSeq/3/13'
		);
		~ifSeqHatBut14.free;
		~ifSeqHatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat14 = ~cntSeqHat14 + 1;
				~cntSeqHat14.switch(
					0,{}, 1,{IFSeqHat.st14(1);}, 2,{IFSeqHat.st14(0);}
				)}
			);
			},
			'/ifSeq/3/14'
		);
		~ifSeqHatBut15.free;
		~ifSeqHatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat15 = ~cntSeqHat15 + 1;
				~cntSeqHat15.switch(
					0,{}, 1,{IFSeqHat.st15(1);}, 2,{IFSeqHat.st15(0);}
				)}
			);
			},
			'/ifSeq/3/15'
		);
		~ifSeqHatBut16.free;
		~ifSeqHatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqHat16 = ~cntSeqHat16 + 1;
				~cntSeqHat16.switch(
					0,{}, 1,{IFSeqHat.st16(1);}, 2,{IFSeqHat.st16(0);}
				)}
			);
			},
			'/ifSeq/3/16'
		);


	}

	*st01 {|i|
		~cntSeqHat01=i;
		~seqHat01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat01', i);
	}
	*st02 {|i|
		~cntSeqHat02=i;
		~seqHat02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat02', i);
	}
	*st03 {|i|
		~cntSeqHat03=i;
		~seqHat03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat03', i);
	}
	*st04 {|i|
		~cntSeqHat04=i;
		~seqHat04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat04', i);
	}
	*st05 {|i|
		~cntSeqHat05=i;
		~seqHat05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat05', i);
	}
	*st06 {|i|
		~cntSeqHat06=i;
		~seqHat06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat06', i);
	}
	*st07 {|i|
		~cntSeqHat07=i;
		~seqHat07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat07', i);
	}
	*st08 {|i|
		~cntSeqHat08=i;
		~seqHat08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat08', i);
	}

	*st09 {|i|
		~cntSeqHat01=i;
		~seqHat09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat09', i);
	}
	*st10 {|i|
		~cntSeqHat10=i;
		~seqHat10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat10', i);
	}
	*st11 {|i|
		~cntSeqHat11=i;
		~seqHat11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat11', i);
	}
	*st12 {|i|
		~cntSeqHat12=i;
		~seqHat12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat12', i);
	}
	*st13 {|i|
		~cntSeqHat13=i;
		~seqHat13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat13', i);
	}
	*st14 {|i|
		~cntSeqHat14=i;
		~seqHat14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat14', i);
	}
	*st15 {|i|
		~cntSeqHat15=i;
		~seqHat15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat15', i);
	}
	*st16 {|i|
		~cntSeqHat16=i;
		~seqHat16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledHat16', i);
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
		~amp1Hat.source  =  Pseq([~seqHat01.next*~seqVelHat01.next], inf);
		~octHat.source = Pseq([~seqOctHat01.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat01.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat01.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat01.next], inf);
	}
	*step02{
		~amp1Hat.source  =  Pseq([~seqHat02.next*~seqVelHat02.next], inf);
		~octHat.source = Pseq([~seqOctHat02.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat02.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat02.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat02.next], inf);
	}
	*step03{
		~amp1Hat.source  =  Pseq([~seqHat03.next*~seqVelHat03.next], inf);
		~octHat.source = Pseq([~seqOctHat03.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat03.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat03.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat03.next], inf);
	}
	*step04{
		~amp1Hat.source  =  Pseq([~seqHat04.next*~seqVelHat04.next], inf);
		~octHat.source = Pseq([~seqOctHat04.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat04.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat04.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat04.next], inf);
	}
	*step05{
		~amp1Hat.source  =  Pseq([~seqHat05.next*~seqVelHat05.next], inf);
		~octHat.source = Pseq([~seqOctHat05.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat05.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat05.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat05.next], inf);
	}
	*step06{
		~amp1Hat.source  =  Pseq([~seqHat06.next*~seqVelHat06.next], inf);
		~octHat.source = Pseq([~seqOctHat06.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat06.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat06.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat06.next], inf);
	}
	*step07{
		~amp1Hat.source  =  Pseq([~seqHat07.next*~seqVelHat07.next], inf);
		~octHat.source = Pseq([~seqOctHat07.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat07.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat07.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat07.next], inf);
	}
	*step08{
		~amp1Hat.source  =  Pseq([~seqHat08.next*~seqVelHat08.next], inf);
		~octHat.source = Pseq([~seqOctHat08.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat08.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat08.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat08.next], inf);
	}
	*step09{
		~amp1Hat.source  =  Pseq([~seqHat09.next*~seqVelHat09.next], inf);
		~octHat.source = Pseq([~seqOctHat09.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat09.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat09.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat09.next], inf);
	}
	*step10{
		~amp1Hat.source  =  Pseq([~seqHat10.next*~seqVelHat10.next], inf);
		~octHat.source = Pseq([~seqOctHat10.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat10.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat10.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat10.next], inf);
	}
	*step11{
		~amp1Hat.source  =  Pseq([~seqHat11.next*~seqVelHat11.next], inf);
		~octHat.source = Pseq([~seqOctHat11.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat11.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat11.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat11.next], inf);
	}
	*step12{
		~amp1Hat.source  =  Pseq([~seqHat12.next*~seqVelHat12.next], inf);
		~octHat.source = Pseq([~seqOctHat12.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat12.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat12.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat12.next], inf);
	}
	*step13{
		~amp1Hat.source  =  Pseq([~seqHat13.next*~seqVelHat13.next], inf);
		~octHat.source = Pseq([~seqOctHat13.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat13.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat13.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat13.next], inf);
	}
	*step14{
		~amp1Hat.source  =  Pseq([~seqHat14.next*~seqVelHat14.next], inf);
		~octHat.source = Pseq([~seqOctHat14.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat14.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat14.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat14.next], inf);
	}
	*step15{
		~amp1Hat.source  =  Pseq([~seqHat15.next*~seqVelHat15.next], inf);
		~octHat.source = Pseq([~seqOctHat15.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat15.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat15.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat15.next], inf);
	}
	*step16{
		~amp1Hat.source  =  Pseq([~seqHat16.next*~seqVelHat16.next], inf);
		~octHat.source = Pseq([~seqOctHat16.next], inf);
		~nt1Hat.source   =  Pseq([~seqNtHat16.next], inf);
		~sus1Hat.source  =  Pseq([~seqSusHat16.next], inf);
		~tmHat.source    =  Pseq([~seqTmHat16.next], inf);
	}

}

