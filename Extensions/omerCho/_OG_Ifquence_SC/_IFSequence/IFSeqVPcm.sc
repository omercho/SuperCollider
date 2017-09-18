IFSeqVPcm {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVPcm01 = PatternProxy( Pseq([0], 1));
		~seqVPcm02 = PatternProxy( Pseq([0], 1));
		~seqVPcm03 = PatternProxy( Pseq([0], 1));
		~seqVPcm04 = PatternProxy( Pseq([0], 1));
		~seqVPcm05 = PatternProxy( Pseq([0], 1));
		~seqVPcm06 = PatternProxy( Pseq([0], 1));
		~seqVPcm07 = PatternProxy( Pseq([0], 1));
		~seqVPcm08 = PatternProxy( Pseq([0], 1));

		~seqVPcm09 = PatternProxy( Pseq([0], 1));
		~seqVPcm10 = PatternProxy( Pseq([0], 1));
		~seqVPcm11 = PatternProxy( Pseq([0], 1));
		~seqVPcm12 = PatternProxy( Pseq([0], 1));
		~seqVPcm13 = PatternProxy( Pseq([0], 1));
		~seqVPcm14 = PatternProxy( Pseq([0], 1));
		~seqVPcm15 = PatternProxy( Pseq([0], 1));
		~seqVPcm16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqStUpVPcm01=0;
		~cntSeqStRandVPcm01=0;

		~cntSeqVPcm01=0;
		~cntSeqVPcm02=0;
		~cntSeqVPcm03=0;
		~cntSeqVPcm04=0;
		~cntSeqVPcm05=0;
		~cntSeqVPcm06=0;
		~cntSeqVPcm07=0;
		~cntSeqVPcm08=0;

		~cntSeqVPcm09=0;
		~cntSeqVPcm10=0;
		~cntSeqVPcm11=0;
		~cntSeqVPcm12=0;
		~cntSeqVPcm13=0;
		~cntSeqVPcm14=0;
		~cntSeqVPcm15=0;
		~cntSeqVPcm16=0;
	}
	*freeOn {
		~seqFreeVPcmBut.free;
		~seqFreeVPcmBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVPcm.stGrp(0);
				});
			},
			'/seqFreeVPcm'
		);

	}

	*upOn {
		~ifSeqUpVPcmBut.free;
		~ifSeqUpVPcmBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStUpVPcm01 = ~cntSeqStUpVPcm01 + 1;
				~cntSeqStUpVPcm01.switch(
					0,{},
					1,{IFSeqVPcm.stGrp(0);},
					2,{IFSeqVPcm.stGrp(1);},
					3,{IFSeqVPcm.stGrp(2);},
					4,{IFSeqVPcm.stGrp(3);},
					5,{IFSeqVPcm.stGrp(4);},
					6,{IFSeqVPcm.stGrp(5);},
					7,{IFSeqVPcm.stGrp(6);},
					8,{IFSeqVPcm.stGrp(7);
						~cntSeqStUpVPcm01=0;
					}
				)}
			);
			},
			'/seqUpVPcm'
		);
	}

	*randOn {
		~ifSeqRandVPcmBut.free;
		~ifSeqRandVPcmBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStRandVPcm01 = ~cntSeqStRandVPcm01 + 1;
				~cntSeqStRandVPcm01.switch(
					0,{},
					1,{
						IFSeqVPcm.st01([0,1].choose);
						IFSeqVPcm.st02([0,1].choose);
						IFSeqVPcm.st03([0,1].choose);
						IFSeqVPcm.st04([0,1].choose);
						IFSeqVPcm.st05([0,1].choose);
						IFSeqVPcm.st06([0,1].choose);
						IFSeqVPcm.st07([0,1].choose);
						IFSeqVPcm.st08([0,1].choose);

						IFSeqVPcm.st09([0,1].choose);
						IFSeqVPcm.st10([0,1].choose);
						IFSeqVPcm.st11([0,1].choose);
						IFSeqVPcm.st12([0,1].choose);
						IFSeqVPcm.st13([0,1].choose);
						IFSeqVPcm.st14([0,1].choose);
						IFSeqVPcm.st15([0,1].choose);
						IFSeqVPcm.st16([0,1].choose);
						~cntSeqStRandVPcm01=0;
					}
				)}
			);
			},
			'/seqRandVPcm'
		);
	}

	*on { // Shift StAVE
		IFSeqVPcm.randOn;
		IFSeqVPcm.upOn;
		IFSeqVPcm.freeOn;

		~ifSeqVPcmBut01.free;
		~ifSeqVPcmBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm01 = ~cntSeqVPcm01 + 1;
				~cntSeqVPcm01.switch(
					0,{},
					1, {IFSeqVPcm.st01(0);},
					2, {IFSeqVPcm.st01(1);
						~cntSeqVPcm01=0;
					}
				)}
			);
			},
			'/ifSeq/4/1'
		);
		~ifSeqVPcmBut02.free;
		~ifSeqVPcmBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm02 = ~cntSeqVPcm02 + 1;
				~cntSeqVPcm02.switch(
					0,{},
					1, {IFSeqVPcm.st02(0);},
					2, {IFSeqVPcm.st02(1);
						~cntSeqVPcm02=0;
					}
				)}
			);
			},
			'/ifSeq/4/2'
		);
		~ifSeqVPcmBut03.free;
		~ifSeqVPcmBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm03 = ~cntSeqVPcm03 + 1;
				~cntSeqVPcm03.switch(
					0,{},
					1, {IFSeqVPcm.st03(0);},
					2, {IFSeqVPcm.st03(1);
						~cntSeqVPcm03=0;
					}
				)}
			);
			},
			'/ifSeq/4/3'
		);
		~ifSeqVPcmBut04.free;
		~ifSeqVPcmBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm04 = ~cntSeqVPcm04 + 1;
				~cntSeqVPcm04.switch(
					0,{},
					1, {IFSeqVPcm.st04(0);},
					2, {IFSeqVPcm.st04(1);
						~cntSeqVPcm04=0;
					}
				)}
			);
			},
			'/ifSeq/4/4'
		);
		~ifSeqVPcmBut05.free;
		~ifSeqVPcmBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm05 = ~cntSeqVPcm05 + 1;
				~cntSeqVPcm05.switch(
					0,{},
					1, {IFSeqVPcm.st05(0);},
					2, {IFSeqVPcm.st05(1);
						~cntSeqVPcm05=0;
					}
				)}
			);
			},
			'/ifSeq/4/5'
		);
		~ifSeqVPcmBut06.free;
		~ifSeqVPcmBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm06 = ~cntSeqVPcm06 + 1;
				~cntSeqVPcm06.switch(
					0,{},
					1, {IFSeqVPcm.st06(0);},
					2, {IFSeqVPcm.st06(1);
						~cntSeqVPcm06=0;
					}
				)}
			);
			},
			'/ifSeq/4/6'
		);
		~ifSeqVPcmBut07.free;
		~ifSeqVPcmBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm07 = ~cntSeqVPcm07 + 1;
				~cntSeqVPcm07.switch(
					0,{},
					1, {IFSeqVPcm.st07(0);},
					2, {IFSeqVPcm.st07(1);
						~cntSeqVPcm07=0;
					}
				)}
			);
			},
			'/ifSeq/4/7'
		);
		~ifSeqVPcmBut08.free;
		~ifSeqVPcmBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm08 = ~cntSeqVPcm08 + 1;
				~cntSeqVPcm08.switch(
					0,{},
					1, {IFSeqVPcm.st08(0);},
					2, {IFSeqVPcm.st08(1);
						~cntSeqVPcm08=0;
					}
				)}
			);
			},
			'/ifSeq/4/8'
		);
		~ifSeqVPcmBut09.free;
		~ifSeqVPcmBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm09 = ~cntSeqVPcm09 + 1;
				~cntSeqVPcm09.switch(
					0,{},
					1, {IFSeqVPcm.st09(0);},
					2, {IFSeqVPcm.st09(1);
						~cntSeqVPcm09=0;
					}
				)}
			);
			},
			'/ifSeq/4/9'
		);
		~ifSeqVPcmBut10.free;
		~ifSeqVPcmBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm10 = ~cntSeqVPcm10 + 1;
				~cntSeqVPcm10.switch(
					0,{},
					1, {IFSeqVPcm.st10(0);},
					2, {IFSeqVPcm.st10(1);
						~cntSeqVPcm10=0;
					}
				)}
			);
			},
			'/ifSeq/4/10'
		);
		~ifSeqVPcmBut11.free;
		~ifSeqVPcmBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm11 = ~cntSeqVPcm11 + 1;
				~cntSeqVPcm11.switch(
					0,{},
					1, {IFSeqVPcm.st11(0);},
					2, {IFSeqVPcm.st11(1);
						~cntSeqVPcm11=0;
					}
				)}
			);
			},
			'/ifSeq/4/11'
		);
		~ifSeqVPcmBut12.free;
		~ifSeqVPcmBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm12 = ~cntSeqVPcm12 + 1;
				~cntSeqVPcm12.switch(
					0,{},
					1, {IFSeqVPcm.st12(0);},
					2, {IFSeqVPcm.st12(1);
						~cntSeqVPcm12=0;
					}
				)}
			);
			},
			'/ifSeq/4/12'
		);
		~ifSeqVPcmBut13.free;
		~ifSeqVPcmBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm13 = ~cntSeqVPcm13 + 1;
				~cntSeqVPcm13.switch(
					0,{},
					1, {IFSeqVPcm.st13(0);},
					2, {IFSeqVPcm.st13(1);
						~cntSeqVPcm13=0;
					}
				)}
			);
			},
			'/ifSeq/4/13'
		);
		~ifSeqVPcmBut14.free;
		~ifSeqVPcmBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm14 = ~cntSeqVPcm14 + 1;
				~cntSeqVPcm14.switch(
					0,{},
					1, {IFSeqVPcm.st14(0);},
					2, {IFSeqVPcm.st14(1);
						~cntSeqVPcm14=0;
					}
				)}
			);
			},
			'/ifSeq/4/14'
		);
		~ifSeqVPcmBut15.free;
		~ifSeqVPcmBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm15 = ~cntSeqVPcm15 + 1;
				~cntSeqVPcm15.switch(
					0,{},
					1, {IFSeqVPcm.st15(0);},
					2, {IFSeqVPcm.st15(1);
						~cntSeqVPcm15=0;
					}
				)}
			);
			},
			'/ifSeq/4/15'
		);
		~ifSeqVPcmBut16.free;
		~ifSeqVPcmBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVPcm16 = ~cntSeqVPcm16 + 1;
				~cntSeqVPcm16.switch(
					0,{},
					1, {IFSeqVPcm.st16(0);},
					2, {IFSeqVPcm.st16(1);
						~cntSeqVPcm16=0;
					}
				)}
			);
			},
			'/ifSeq/4/16'
		);

	}//

	*st01 {|i=0|
		~seqVPcm01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm01', i);
	}
	*st02 {|i=0|
		~seqVPcm02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm02', i);
	}
	*st03 {|i=0|
		~seqVPcm03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm03', i);
	}
	*st04 {|i=0|
		~seqVPcm04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm04', i);
	}
	*st05 {|i=0|
		~seqVPcm05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm05', i);
	}
	*st06 {|i=0|
		~seqVPcm06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm06', i);
	}
	*st07 {|i=0|
		~seqVPcm07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm07', i);
	}
	*st08 {|i=0|
		~seqVPcm08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm08', i);
	}
	*st09 {|i=0|
		~seqVPcm09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm09', i);
	}
	*st10 {|i=0|
		~seqVPcm10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm10', i);
	}
	*st11 {|i=0|
		~seqVPcm11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm11', i);
	}
	*st12 {|i=0|
		~seqVPcm12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm12', i);
	}
	*st13 {|i=0|
		~seqVPcm13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm13', i);
	}
	*st14 {|i=0|
		~seqVPcm14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm14', i);
	}
	*st15 {|i=0|
		~seqVPcm15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm15', i);
	}
	*st16 {|i=0|
		~seqVPcm16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVPcm16', i);
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

		~ampVPcm.source  =  Pseq([~seqVPcm01.next], inf);
	}
	*step02{

		~ampVPcm.source  =  Pseq([~seqVPcm02.next], inf);
	}
	*step03{

		~ampVPcm.source  =  Pseq([~seqVPcm03.next], inf);
	}
	*step04{

		~ampVPcm.source  =  Pseq([~seqVPcm04.next], inf);
	}
	*step05{

		~ampVPcm.source  =  Pseq([~seqVPcm05.next], inf);
	}
	*step06{

		~ampVPcm.source  =  Pseq([~seqVPcm06.next], inf);
	}
	*step07{

		~ampVPcm.source  =  Pseq([~seqVPcm07.next], inf);
	}
	*step08{

		~ampVPcm.source  =  Pseq([~seqVPcm08.next], inf);
	}
	*step09{

		~ampVPcm.source  =  Pseq([~seqVPcm09.next], inf);
	}
	*step10{

		~ampVPcm.source  =  Pseq([~seqVPcm10.next], inf);
	}
	*step11{

		~ampVPcm.source  =  Pseq([~seqVPcm11.next], inf);
	}
	*step12{

		~ampVPcm.source  =  Pseq([~seqVPcm12.next], inf);
	}
	*step13{

		~ampVPcm.source  =  Pseq([~seqVPcm13.next], inf);
	}
	*step14{

		~ampVPcm.source  =  Pseq([~seqVPcm14.next], inf);
	}
	*step15{

		~ampVPcm.source  =  Pseq([~seqVPcm15.next], inf);
	}
	*step16{

		~ampVPcm.source  =  Pseq([~seqVPcm16.next], inf);
	}



	*stGrp {|i|

		IFSeqVPcm.st01(i); IFSeqVPcm.st02(i); IFSeqVPcm.st03(i); IFSeqVPcm.st04(i);
		IFSeqVPcm.st05(i); IFSeqVPcm.st06(i); IFSeqVPcm.st07(i); IFSeqVPcm.st08(i);
		IFSeqVPcm.st09(i); IFSeqVPcm.st10(i); IFSeqVPcm.st11(i); IFSeqVPcm.st12(i);
		IFSeqVPcm.st13(i); IFSeqVPcm.st14(i); IFSeqVPcm.st15(i); IFSeqVPcm.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqVPcm.st01(s01); IFSeqVPcm.st02(s02); IFSeqVPcm.st03(s03); IFSeqVPcm.st04(s04);
		IFSeqVPcm.st05(s05); IFSeqVPcm.st06(s06); IFSeqVPcm.st07(s07); IFSeqVPcm.st08(s08);
		IFSeqVPcm.st09(s09); IFSeqVPcm.st10(s10); IFSeqVPcm.st11(s11); IFSeqVPcm.st12(s12);
		IFSeqVPcm.st13(s13); IFSeqVPcm.st14(s14); IFSeqVPcm.st15(s15); IFSeqVPcm.st16(s16);
	}
}