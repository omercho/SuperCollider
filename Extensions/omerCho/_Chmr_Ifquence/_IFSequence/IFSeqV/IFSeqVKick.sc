IFSeqVKick {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVKick01 = PatternProxy( Pseq([0], 1));
		~seqVKick02 = PatternProxy( Pseq([0], 1));
		~seqVKick03 = PatternProxy( Pseq([0], 1));
		~seqVKick04 = PatternProxy( Pseq([0], 1));
		~seqVKick05 = PatternProxy( Pseq([0], 1));
		~seqVKick06 = PatternProxy( Pseq([0], 1));
		~seqVKick07 = PatternProxy( Pseq([0], 1));
		~seqVKick08 = PatternProxy( Pseq([0], 1));

		~seqVKick09 = PatternProxy( Pseq([0], 1));
		~seqVKick10 = PatternProxy( Pseq([0], 1));
		~seqVKick11 = PatternProxy( Pseq([0], 1));
		~seqVKick12 = PatternProxy( Pseq([0], 1));
		~seqVKick13 = PatternProxy( Pseq([0], 1));
		~seqVKick14 = PatternProxy( Pseq([0], 1));
		~seqVKick15 = PatternProxy( Pseq([0], 1));
		~seqVKick16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqStUpKick01=0;
		~cntSeqStRandKick01=0;

		~cntSeqVKick01=0;
		~cntSeqVKick02=0;
		~cntSeqVKick03=0;
		~cntSeqVKick04=0;
		~cntSeqVKick05=0;
		~cntSeqVKick06=0;
		~cntSeqVKick07=0;
		~cntSeqVKick08=0;

		~cntSeqVKick09=0;
		~cntSeqVKick10=0;
		~cntSeqVKick11=0;
		~cntSeqVKick12=0;
		~cntSeqVKick13=0;
		~cntSeqVKick14=0;
		~cntSeqVKick15=0;
		~cntSeqVKick16=0;
	}
	*freeOn {
		~seqFreeKickBut.free;
		~seqFreeKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVKick.stGrp(0);
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
				~cntSeqStUpKick01 = ~cntSeqStUpKick01 + 1;
				~cntSeqStUpKick01.switch(
					0,{},
					1,{IFSeqVKick.stGrp(0);},
					2,{IFSeqVKick.stGrp(1);},
					3,{IFSeqVKick.stGrp(2);},
					4,{IFSeqVKick.stGrp(3);},
					5,{IFSeqVKick.stGrp(4);},
					6,{IFSeqVKick.stGrp(5);},
					7,{IFSeqVKick.stGrp(6);},
					8,{IFSeqVKick.stGrp(7);
						~cntSeqStUpKick01=0;
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
				~cntSeqStRandKick01 = ~cntSeqStRandKick01 + 1;
				~cntSeqStRandKick01.switch(
					0,{},
					1,{
						IFSeqVKick.st01([0,1].choose);
						IFSeqVKick.st02([0,1].choose);
						IFSeqVKick.st03([0,1].choose);
						IFSeqVKick.st04([0,1].choose);
						IFSeqVKick.st05([0,1].choose);
						IFSeqVKick.st06([0,1].choose);
						IFSeqVKick.st07([0,1].choose);
						IFSeqVKick.st08([0,1].choose);

						IFSeqVKick.st09([0,1].choose);
						IFSeqVKick.st10([0,1].choose);
						IFSeqVKick.st11([0,1].choose);
						IFSeqVKick.st12([0,1].choose);
						IFSeqVKick.st13([0,1].choose);
						IFSeqVKick.st14([0,1].choose);
						IFSeqVKick.st15([0,1].choose);
						IFSeqVKick.st16([0,1].choose);
						~cntSeqStRandKick01=0;
					}
				)}
			);
			},
			'/seqRandKick'
		);
	}

	*on { // Shift StAVE
		IFSeqVKick.randOn;
		IFSeqVKick.upOn;
		IFSeqVKick.freeOn;

		~ifSeqKickBut01.free;
		~ifSeqKickBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick01 = ~cntSeqVKick01 + 1;
				~cntSeqVKick01.switch(
					0,{},
					1, {IFSeqVKick.st01(0);},
					2, {IFSeqVKick.st01(1);
						~cntSeqVKick01=0;
					}
				)}
			);
			},
			'/ifSeq/1/1'
		);
		~ifSeqKickBut02.free;
		~ifSeqKickBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick02 = ~cntSeqVKick02 + 1;
				~cntSeqVKick02.switch(
					0,{},
					1, {IFSeqVKick.st02(0);},
					2, {IFSeqVKick.st02(1);
						~cntSeqVKick02=0;
					}
				)}
			);
			},
			'/ifSeq/1/2'
		);
		~ifSeqKickBut03.free;
		~ifSeqKickBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick03 = ~cntSeqVKick03 + 1;
				~cntSeqVKick03.switch(
					0,{},
					1, {IFSeqVKick.st03(0);},
					2, {IFSeqVKick.st03(1);
						~cntSeqVKick03=0;
					}
				)}
			);
			},
			'/ifSeq/1/3'
		);
		~ifSeqKickBut04.free;
		~ifSeqKickBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick04 = ~cntSeqVKick04 + 1;
				~cntSeqVKick04.switch(
					0,{},
					1, {IFSeqVKick.st04(0);},
					2, {IFSeqVKick.st04(1);
						~cntSeqVKick04=0;
					}
				)}
			);
			},
			'/ifSeq/1/4'
		);
		~ifSeqKickBut05.free;
		~ifSeqKickBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick05 = ~cntSeqVKick05 + 1;
				~cntSeqVKick05.switch(
					0,{},
					1, {IFSeqVKick.st05(0);},
					2, {IFSeqVKick.st05(1);
						~cntSeqVKick05=0;
					}
				)}
			);
			},
			'/ifSeq/1/5'
		);
		~ifSeqKickBut06.free;
		~ifSeqKickBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick06 = ~cntSeqVKick06 + 1;
				~cntSeqVKick06.switch(
					0,{},
					1, {IFSeqVKick.st06(0);},
					2, {IFSeqVKick.st06(1);
						~cntSeqVKick06=0;
					}
				)}
			);
			},
			'/ifSeq/1/6'
		);
		~ifSeqKickBut07.free;
		~ifSeqKickBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick07 = ~cntSeqVKick07 + 1;
				~cntSeqVKick07.switch(
					0,{},
					1, {IFSeqVKick.st07(0);},
					2, {IFSeqVKick.st07(1);
						~cntSeqVKick07=0;
					}
				)}
			);
			},
			'/ifSeq/1/7'
		);
		~ifSeqKickBut08.free;
		~ifSeqKickBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick08 = ~cntSeqVKick08 + 1;
				~cntSeqVKick08.switch(
					0,{},
					1, {IFSeqVKick.st08(0);},
					2, {IFSeqVKick.st08(1);
						~cntSeqVKick08=0;
					}
				)}
			);
			},
			'/ifSeq/1/8'
		);
		~ifSeqKickBut09.free;
		~ifSeqKickBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick09 = ~cntSeqVKick09 + 1;
				~cntSeqVKick09.switch(
					0,{},
					1, {IFSeqVKick.st09(0);},
					2, {IFSeqVKick.st09(1);
						~cntSeqVKick09=0;
					}
				)}
			);
			},
			'/ifSeq/1/9'
		);
		~ifSeqKickBut10.free;
		~ifSeqKickBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick10 = ~cntSeqVKick10 + 1;
				~cntSeqVKick10.switch(
					0,{},
					1, {IFSeqVKick.st10(0);},
					2, {IFSeqVKick.st10(1);
						~cntSeqVKick10=0;
					}
				)}
			);
			},
			'/ifSeq/1/10'
		);
		~ifSeqKickBut11.free;
		~ifSeqKickBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick11 = ~cntSeqVKick11 + 1;
				~cntSeqVKick11.switch(
					0,{},
					1, {IFSeqVKick.st11(0);},
					2, {IFSeqVKick.st11(1);
						~cntSeqVKick11=0;
					}
				)}
			);
			},
			'/ifSeq/1/11'
		);
		~ifSeqKickBut12.free;
		~ifSeqKickBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick12 = ~cntSeqVKick12 + 1;
				~cntSeqVKick12.switch(
					0,{},
					1, {IFSeqVKick.st12(0);},
					2, {IFSeqVKick.st12(1);
						~cntSeqVKick12=0;
					}
				)}
			);
			},
			'/ifSeq/1/12'
		);
		~ifSeqKickBut13.free;
		~ifSeqKickBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick13 = ~cntSeqVKick13 + 1;
				~cntSeqVKick13.switch(
					0,{},
					1, {IFSeqVKick.st13(0);},
					2, {IFSeqVKick.st13(1);
						~cntSeqVKick13=0;
					}
				)}
			);
			},
			'/ifSeq/1/13'
		);
		~ifSeqKickBut14.free;
		~ifSeqKickBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick14 = ~cntSeqVKick14 + 1;
				~cntSeqVKick14.switch(
					0,{},
					1, {IFSeqVKick.st14(0);},
					2, {IFSeqVKick.st14(1);
						~cntSeqVKick14=0;
					}
				)}
			);
			},
			'/ifSeq/1/14'
		);
		~ifSeqKickBut15.free;
		~ifSeqKickBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick15 = ~cntSeqVKick15 + 1;
				~cntSeqVKick15.switch(
					0,{},
					1, {IFSeqVKick.st15(0);},
					2, {IFSeqVKick.st15(1);
						~cntSeqVKick15=0;
					}
				)}
			);
			},
			'/ifSeq/1/15'
		);
		~ifSeqKickBut16.free;
		~ifSeqKickBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVKick16 = ~cntSeqVKick16 + 1;
				~cntSeqVKick16.switch(
					0,{},
					1, {IFSeqVKick.st16(0);},
					2, {IFSeqVKick.st16(1);
						~cntSeqVKick16=0;
					}
				)}
			);
			},
			'/ifSeq/1/16'
		);

	}//

	*st01 {|i=0|
		~seqVKick01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick01', i);
	}
	*st02 {|i=0|
		~seqVKick02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick02', i);
	}
	*st03 {|i=0|
		~seqVKick03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick03', i);
	}
	*st04 {|i=0|
		~seqVKick04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick04', i);
	}
	*st05 {|i=0|
		~seqVKick05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick05', i);
	}
	*st06 {|i=0|
		~seqVKick06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick06', i);
	}
	*st07 {|i=0|
		~seqVKick07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick07', i);
	}
	*st08 {|i=0|
		~seqVKick08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick08', i);
	}
	*st09 {|i=0|
		~seqVKick09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick09', i);
	}
	*st10 {|i=0|
		~seqVKick10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick10', i);
	}
	*st11 {|i=0|
		~seqVKick11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick11', i);
	}
	*st12 {|i=0|
		~seqVKick12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick12', i);
	}
	*st13 {|i=0|
		~seqVKick13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick13', i);
	}
	*st14 {|i=0|
		~seqVKick14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick14', i);
	}
	*st15 {|i=0|
		~seqVKick15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick15', i);
	}
	*st16 {|i=0|
		~seqVKick16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVKick16', i);
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

		~ampVKick.source  =  Pseq([~seqVKick01.next], inf);
	}
	*step02{

		~ampVKick.source  =  Pseq([~seqVKick02.next], inf);
	}
	*step03{

		~ampVKick.source  =  Pseq([~seqVKick03.next], inf);
	}
	*step04{

		~ampVKick.source  =  Pseq([~seqVKick04.next], inf);
	}
	*step05{

		~ampVKick.source  =  Pseq([~seqVKick05.next], inf);
	}
	*step06{

		~ampVKick.source  =  Pseq([~seqVKick06.next], inf);
	}
	*step07{

		~ampVKick.source  =  Pseq([~seqVKick07.next], inf);
	}
	*step08{

		~ampVKick.source  =  Pseq([~seqVKick08.next], inf);
	}
	*step09{

		~ampVKick.source  =  Pseq([~seqVKick09.next], inf);
	}
	*step10{

		~ampVKick.source  =  Pseq([~seqVKick10.next], inf);
	}
	*step11{

		~ampVKick.source  =  Pseq([~seqVKick11.next], inf);
	}
	*step12{

		~ampVKick.source  =  Pseq([~seqVKick12.next], inf);
	}
	*step13{

		~ampVKick.source  =  Pseq([~seqVKick13.next], inf);
	}
	*step14{

		~ampVKick.source  =  Pseq([~seqVKick14.next], inf);
	}
	*step15{

		~ampVKick.source  =  Pseq([~seqVKick15.next], inf);
	}
	*step16{

		~ampVKick.source  =  Pseq([~seqVKick16.next], inf);
	}

	*stGrp {|i|

		IFSeqVKick.st01(i); IFSeqVKick.st02(i); IFSeqVKick.st03(i); IFSeqVKick.st04(i);
		IFSeqVKick.st05(i); IFSeqVKick.st06(i); IFSeqVKick.st07(i); IFSeqVKick.st08(i);
		IFSeqVKick.st09(i); IFSeqVKick.st10(i); IFSeqVKick.st11(i); IFSeqVKick.st12(i);
		IFSeqVKick.st13(i); IFSeqVKick.st14(i); IFSeqVKick.st15(i); IFSeqVKick.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqVKick.st01(s01); IFSeqVKick.st02(s02); IFSeqVKick.st03(s03); IFSeqVKick.st04(s04);
		IFSeqVKick.st05(s05); IFSeqVKick.st06(s06); IFSeqVKick.st07(s07); IFSeqVKick.st08(s08);
		IFSeqVKick.st09(s09); IFSeqVKick.st10(s10); IFSeqVKick.st11(s11); IFSeqVKick.st12(s12);
		IFSeqVKick.st13(s13); IFSeqVKick.st14(s14); IFSeqVKick.st15(s15); IFSeqVKick.st16(s16);
	}
}