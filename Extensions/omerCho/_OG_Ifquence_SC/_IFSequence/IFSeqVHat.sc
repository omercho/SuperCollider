IFSeqVHat {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVHat01 = PatternProxy( Pseq([0], 1));
		~seqVHat02 = PatternProxy( Pseq([0], 1));
		~seqVHat03 = PatternProxy( Pseq([0], 1));
		~seqVHat04 = PatternProxy( Pseq([0], 1));
		~seqVHat05 = PatternProxy( Pseq([0], 1));
		~seqVHat06 = PatternProxy( Pseq([0], 1));
		~seqVHat07 = PatternProxy( Pseq([0], 1));
		~seqVHat08 = PatternProxy( Pseq([0], 1));

		~seqVHat09 = PatternProxy( Pseq([0], 1));
		~seqVHat10 = PatternProxy( Pseq([0], 1));
		~seqVHat11 = PatternProxy( Pseq([0], 1));
		~seqVHat12 = PatternProxy( Pseq([0], 1));
		~seqVHat13 = PatternProxy( Pseq([0], 1));
		~seqVHat14 = PatternProxy( Pseq([0], 1));
		~seqVHat15 = PatternProxy( Pseq([0], 1));
		~seqVHat16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqStUpVHat01=0;
		~cntSeqStRandVHat01=0;

		~cntSeqVHat01=0;
		~cntSeqVHat02=0;
		~cntSeqVHat03=0;
		~cntSeqVHat04=0;
		~cntSeqVHat05=0;
		~cntSeqVHat06=0;
		~cntSeqVHat07=0;
		~cntSeqVHat08=0;

		~cntSeqVHat09=0;
		~cntSeqVHat10=0;
		~cntSeqVHat11=0;
		~cntSeqVHat12=0;
		~cntSeqVHat13=0;
		~cntSeqVHat14=0;
		~cntSeqVHat15=0;
		~cntSeqVHat16=0;
	}
	*freeOn {
		~seqFreeVHatBut.free;
		~seqFreeVHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVHat.stGrp(0);
				});
			},
			'/seqFreeVHat'
		);

	}

	*upOn {
		~ifSeqUpVHatBut.free;
		~ifSeqUpVHatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStUpVHat01 = ~cntSeqStUpVHat01 + 1;
				~cntSeqStUpVHat01.switch(
					0,{},
					1,{IFSeqVHat.stGrp(0);},
					2,{IFSeqVHat.stGrp(1);},
					3,{IFSeqVHat.stGrp(2);},
					4,{IFSeqVHat.stGrp(3);},
					5,{IFSeqVHat.stGrp(4);},
					6,{IFSeqVHat.stGrp(5);},
					7,{IFSeqVHat.stGrp(6);},
					8,{IFSeqVHat.stGrp(7);
						~cntSeqStUpVHat01=0;
					}
				)}
			);
			},
			'/seqUpVHat'
		);
	}

	*randOn {
		~ifSeqRandVHatBut.free;
		~ifSeqRandVHatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStRandVHat01 = ~cntSeqStRandVHat01 + 1;
				~cntSeqStRandVHat01.switch(
					0,{},
					1,{
						IFSeqVHat.st01([0,1].choose);
						IFSeqVHat.st02([0,1].choose);
						IFSeqVHat.st03([0,1].choose);
						IFSeqVHat.st04([0,1].choose);
						IFSeqVHat.st05([0,1].choose);
						IFSeqVHat.st06([0,1].choose);
						IFSeqVHat.st07([0,1].choose);
						IFSeqVHat.st08([0,1].choose);

						IFSeqVHat.st09([0,1].choose);
						IFSeqVHat.st10([0,1].choose);
						IFSeqVHat.st11([0,1].choose);
						IFSeqVHat.st12([0,1].choose);
						IFSeqVHat.st13([0,1].choose);
						IFSeqVHat.st14([0,1].choose);
						IFSeqVHat.st15([0,1].choose);
						IFSeqVHat.st16([0,1].choose);
						~cntSeqStRandVHat01=0;
					}
				)}
			);
			},
			'/seqRandVHat'
		);
	}

	*on { // Shift StAVE
		IFSeqVHat.randOn;
		IFSeqVHat.upOn;
		IFSeqVHat.freeOn;

		~ifSeqVHatBut01.free;
		~ifSeqVHatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat01 = ~cntSeqVHat01 + 1;
				~cntSeqVHat01.switch(
					0,{},
					1, {IFSeqVHat.st01(0);},
					2, {IFSeqVHat.st01(1);
						~cntSeqVHat01=0;
					}
				)}
			);
			},
			'/ifSeq/4/1'
		);
		~ifSeqVHatBut02.free;
		~ifSeqVHatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat02 = ~cntSeqVHat02 + 1;
				~cntSeqVHat02.switch(
					0,{},
					1, {IFSeqVHat.st02(0);},
					2, {IFSeqVHat.st02(1);
						~cntSeqVHat02=0;
					}
				)}
			);
			},
			'/ifSeq/4/2'
		);
		~ifSeqVHatBut03.free;
		~ifSeqVHatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat03 = ~cntSeqVHat03 + 1;
				~cntSeqVHat03.switch(
					0,{},
					1, {IFSeqVHat.st03(0);},
					2, {IFSeqVHat.st03(1);
						~cntSeqVHat03=0;
					}
				)}
			);
			},
			'/ifSeq/4/3'
		);
		~ifSeqVHatBut04.free;
		~ifSeqVHatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat04 = ~cntSeqVHat04 + 1;
				~cntSeqVHat04.switch(
					0,{},
					1, {IFSeqVHat.st04(0);},
					2, {IFSeqVHat.st04(1);
						~cntSeqVHat04=0;
					}
				)}
			);
			},
			'/ifSeq/4/4'
		);
		~ifSeqVHatBut05.free;
		~ifSeqVHatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat05 = ~cntSeqVHat05 + 1;
				~cntSeqVHat05.switch(
					0,{},
					1, {IFSeqVHat.st05(0);},
					2, {IFSeqVHat.st05(1);
						~cntSeqVHat05=0;
					}
				)}
			);
			},
			'/ifSeq/4/5'
		);
		~ifSeqVHatBut06.free;
		~ifSeqVHatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat06 = ~cntSeqVHat06 + 1;
				~cntSeqVHat06.switch(
					0,{},
					1, {IFSeqVHat.st06(0);},
					2, {IFSeqVHat.st06(1);
						~cntSeqVHat06=0;
					}
				)}
			);
			},
			'/ifSeq/4/6'
		);
		~ifSeqVHatBut07.free;
		~ifSeqVHatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat07 = ~cntSeqVHat07 + 1;
				~cntSeqVHat07.switch(
					0,{},
					1, {IFSeqVHat.st07(0);},
					2, {IFSeqVHat.st07(1);
						~cntSeqVHat07=0;
					}
				)}
			);
			},
			'/ifSeq/4/7'
		);
		~ifSeqVHatBut08.free;
		~ifSeqVHatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat08 = ~cntSeqVHat08 + 1;
				~cntSeqVHat08.switch(
					0,{},
					1, {IFSeqVHat.st08(0);},
					2, {IFSeqVHat.st08(1);
						~cntSeqVHat08=0;
					}
				)}
			);
			},
			'/ifSeq/4/8'
		);
		~ifSeqVHatBut09.free;
		~ifSeqVHatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat09 = ~cntSeqVHat09 + 1;
				~cntSeqVHat09.switch(
					0,{},
					1, {IFSeqVHat.st09(0);},
					2, {IFSeqVHat.st09(1);
						~cntSeqVHat09=0;
					}
				)}
			);
			},
			'/ifSeq/4/9'
		);
		~ifSeqVHatBut10.free;
		~ifSeqVHatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat10 = ~cntSeqVHat10 + 1;
				~cntSeqVHat10.switch(
					0,{},
					1, {IFSeqVHat.st10(0);},
					2, {IFSeqVHat.st10(1);
						~cntSeqVHat10=0;
					}
				)}
			);
			},
			'/ifSeq/4/10'
		);
		~ifSeqVHatBut11.free;
		~ifSeqVHatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat11 = ~cntSeqVHat11 + 1;
				~cntSeqVHat11.switch(
					0,{},
					1, {IFSeqVHat.st11(0);},
					2, {IFSeqVHat.st11(1);
						~cntSeqVHat11=0;
					}
				)}
			);
			},
			'/ifSeq/4/11'
		);
		~ifSeqVHatBut12.free;
		~ifSeqVHatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat12 = ~cntSeqVHat12 + 1;
				~cntSeqVHat12.switch(
					0,{},
					1, {IFSeqVHat.st12(0);},
					2, {IFSeqVHat.st12(1);
						~cntSeqVHat12=0;
					}
				)}
			);
			},
			'/ifSeq/4/12'
		);
		~ifSeqVHatBut13.free;
		~ifSeqVHatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat13 = ~cntSeqVHat13 + 1;
				~cntSeqVHat13.switch(
					0,{},
					1, {IFSeqVHat.st13(0);},
					2, {IFSeqVHat.st13(1);
						~cntSeqVHat13=0;
					}
				)}
			);
			},
			'/ifSeq/4/13'
		);
		~ifSeqVHatBut14.free;
		~ifSeqVHatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat14 = ~cntSeqVHat14 + 1;
				~cntSeqVHat14.switch(
					0,{},
					1, {IFSeqVHat.st14(0);},
					2, {IFSeqVHat.st14(1);
						~cntSeqVHat14=0;
					}
				)}
			);
			},
			'/ifSeq/4/14'
		);
		~ifSeqVHatBut15.free;
		~ifSeqVHatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat15 = ~cntSeqVHat15 + 1;
				~cntSeqVHat15.switch(
					0,{},
					1, {IFSeqVHat.st15(0);},
					2, {IFSeqVHat.st15(1);
						~cntSeqVHat15=0;
					}
				)}
			);
			},
			'/ifSeq/4/15'
		);
		~ifSeqVHatBut16.free;
		~ifSeqVHatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVHat16 = ~cntSeqVHat16 + 1;
				~cntSeqVHat16.switch(
					0,{},
					1, {IFSeqVHat.st16(0);},
					2, {IFSeqVHat.st16(1);
						~cntSeqVHat16=0;
					}
				)}
			);
			},
			'/ifSeq/4/16'
		);

	}//

	*st01 {|i=0|
		~seqVHat01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat01', i);
	}
	*st02 {|i=0|
		~seqVHat02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat02', i);
	}
	*st03 {|i=0|
		~seqVHat03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat03', i);
	}
	*st04 {|i=0|
		~seqVHat04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat04', i);
	}
	*st05 {|i=0|
		~seqVHat05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat05', i);
	}
	*st06 {|i=0|
		~seqVHat06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat06', i);
	}
	*st07 {|i=0|
		~seqVHat07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat07', i);
	}
	*st08 {|i=0|
		~seqVHat08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat08', i);
	}
	*st09 {|i=0|
		~seqVHat09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat09', i);
	}
	*st10 {|i=0|
		~seqVHat10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat10', i);
	}
	*st11 {|i=0|
		~seqVHat11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat11', i);
	}
	*st12 {|i=0|
		~seqVHat12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat12', i);
	}
	*st13 {|i=0|
		~seqVHat13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat13', i);
	}
	*st14 {|i=0|
		~seqVHat14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat14', i);
	}
	*st15 {|i=0|
		~seqVHat15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat15', i);
	}
	*st16 {|i=0|
		~seqVHat16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVHat16', i);
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

		~ampVHat.source  =  Pseq([~seqVHat01.next], inf);
	}
	*step02{

		~ampVHat.source  =  Pseq([~seqVHat02.next], inf);
	}
	*step03{

		~ampVHat.source  =  Pseq([~seqVHat03.next], inf);
	}
	*step04{

		~ampVHat.source  =  Pseq([~seqVHat04.next], inf);
	}
	*step05{

		~ampVHat.source  =  Pseq([~seqVHat05.next], inf);
	}
	*step06{

		~ampVHat.source  =  Pseq([~seqVHat06.next], inf);
	}
	*step07{

		~ampVHat.source  =  Pseq([~seqVHat07.next], inf);
	}
	*step08{

		~ampVHat.source  =  Pseq([~seqVHat08.next], inf);
	}
	*step09{

		~ampVHat.source  =  Pseq([~seqVHat09.next], inf);
	}
	*step10{

		~ampVHat.source  =  Pseq([~seqVHat10.next], inf);
	}
	*step11{

		~ampVHat.source  =  Pseq([~seqVHat11.next], inf);
	}
	*step12{

		~ampVHat.source  =  Pseq([~seqVHat12.next], inf);
	}
	*step13{

		~ampVHat.source  =  Pseq([~seqVHat13.next], inf);
	}
	*step14{

		~ampVHat.source  =  Pseq([~seqVHat14.next], inf);
	}
	*step15{

		~ampVHat.source  =  Pseq([~seqVHat15.next], inf);
	}
	*step16{

		~ampVHat.source  =  Pseq([~seqVHat16.next], inf);
	}



	*stGrp {|i|

		IFSeqVHat.st01(i); IFSeqVHat.st02(i); IFSeqVHat.st03(i); IFSeqVHat.st04(i);
		IFSeqVHat.st05(i); IFSeqVHat.st06(i); IFSeqVHat.st07(i); IFSeqVHat.st08(i);
		IFSeqVHat.st09(i); IFSeqVHat.st10(i); IFSeqVHat.st11(i); IFSeqVHat.st12(i);
		IFSeqVHat.st13(i); IFSeqVHat.st14(i); IFSeqVHat.st15(i); IFSeqVHat.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqVHat.st01(s01); IFSeqVHat.st02(s02); IFSeqVHat.st03(s03); IFSeqVHat.st04(s04);
		IFSeqVHat.st05(s05); IFSeqVHat.st06(s06); IFSeqVHat.st07(s07); IFSeqVHat.st08(s08);
		IFSeqVHat.st09(s09); IFSeqVHat.st10(s10); IFSeqVHat.st11(s11); IFSeqVHat.st12(s12);
		IFSeqVHat.st13(s13); IFSeqVHat.st14(s14); IFSeqVHat.st15(s15); IFSeqVHat.st16(s16);
	}
}