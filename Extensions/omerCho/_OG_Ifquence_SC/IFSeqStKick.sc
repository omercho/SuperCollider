IFSeqStKick {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqStKick01 = PatternProxy( Pseq([0], 1));
		~seqStKick02 = PatternProxy( Pseq([0], 1));
		~seqStKick03 = PatternProxy( Pseq([0], 1));
		~seqStKick04 = PatternProxy( Pseq([0], 1));
		~seqStKick05 = PatternProxy( Pseq([0], 1));
		~seqStKick06 = PatternProxy( Pseq([0], 1));
		~seqStKick07 = PatternProxy( Pseq([0], 1));
		~seqStKick08 = PatternProxy( Pseq([0], 1));

		~seqStKick09 = PatternProxy( Pseq([0], 1));
		~seqStKick10 = PatternProxy( Pseq([0], 1));
		~seqStKick11 = PatternProxy( Pseq([0], 1));
		~seqStKick12 = PatternProxy( Pseq([0], 1));
		~seqStKick13 = PatternProxy( Pseq([0], 1));
		~seqStKick14 = PatternProxy( Pseq([0], 1));
		~seqStKick15 = PatternProxy( Pseq([0], 1));
		~seqStKick16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqStUpKick01=0;
		~cntSeqStRandKick01=0;

		~cntSeqStKick01=0;
		~cntSeqStKick02=0;
		~cntSeqStKick03=0;
		~cntSeqStKick04=0;
		~cntSeqStKick05=0;
		~cntSeqStKick06=0;
		~cntSeqStKick07=0;
		~cntSeqStKick08=0;

		~cntSeqStKick09=0;
		~cntSeqStKick10=0;
		~cntSeqStKick11=0;
		~cntSeqStKick12=0;
		~cntSeqStKick13=0;
		~cntSeqStKick14=0;
		~cntSeqStKick15=0;
		~cntSeqStKick16=0;
	}
	*freeOn {
		~seqFreeKickBut.free;
		~seqFreeKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqStKick.stGrp(0);
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
					1,{IFSeqStKick.stGrp(0);},
					2,{IFSeqStKick.stGrp(1);},
					3,{IFSeqStKick.stGrp(2);},
					4,{IFSeqStKick.stGrp(3);},
					5,{IFSeqStKick.stGrp(4);},
					6,{IFSeqStKick.stGrp(5);},
					7,{IFSeqStKick.stGrp(6);},
					8,{IFSeqStKick.stGrp(7);
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
						IFSeqStKick.st01([0,1].choose);
						IFSeqStKick.st02([0,1].choose);
						IFSeqStKick.st03([0,1].choose);
						IFSeqStKick.st04([0,1].choose);
						IFSeqStKick.st05([0,1].choose);
						IFSeqStKick.st06([0,1].choose);
						IFSeqStKick.st07([0,1].choose);
						IFSeqStKick.st08([0,1].choose);

						IFSeqStKick.st09([0,1].choose);
						IFSeqStKick.st10([0,1].choose);
						IFSeqStKick.st11([0,1].choose);
						IFSeqStKick.st12([0,1].choose);
						IFSeqStKick.st13([0,1].choose);
						IFSeqStKick.st14([0,1].choose);
						IFSeqStKick.st15([0,1].choose);
						IFSeqStKick.st16([0,1].choose);
						~cntSeqStRandKick01=0;
					}
				)}
			);
			},
			'/seqRandKick'
		);
	}

	*on { // Shift StAVE
		IFSeqStKick.randOn;
		IFSeqStKick.upOn;
		IFSeqStKick.freeOn;

		~ifSeqKickBut01.free;
		~ifSeqKickBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKick01 = ~cntSeqStKick01 + 1;
				~cntSeqStKick01.switch(
					0,{},
					1, {IFSeqStKick.st01(0);},
					2, {IFSeqStKick.st01(1);
						~cntSeqStKick01=0;
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
				~cntSeqStKick02 = ~cntSeqStKick02 + 1;
				~cntSeqStKick02.switch(
					0,{},
					1, {IFSeqStKick.st02(0);},
					2, {IFSeqStKick.st02(1);
						~cntSeqStKick02=0;
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
				~cntSeqStKick03 = ~cntSeqStKick03 + 1;
				~cntSeqStKick03.switch(
					0,{},
					1, {IFSeqStKick.st03(0);},
					2, {IFSeqStKick.st03(1);
						~cntSeqStKick03=0;
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
				~cntSeqStKick04 = ~cntSeqStKick04 + 1;
				~cntSeqStKick04.switch(
					0,{},
					1, {IFSeqStKick.st04(0);},
					2, {IFSeqStKick.st04(1);
						~cntSeqStKick04=0;
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
				~cntSeqStKick05 = ~cntSeqStKick05 + 1;
				~cntSeqStKick05.switch(
					0,{},
					1, {IFSeqStKick.st05(0);},
					2, {IFSeqStKick.st05(1);
						~cntSeqStKick05=0;
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
				~cntSeqStKick06 = ~cntSeqStKick06 + 1;
				~cntSeqStKick06.switch(
					0,{},
					1, {IFSeqStKick.st06(0);},
					2, {IFSeqStKick.st06(1);
						~cntSeqStKick06=0;
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
				~cntSeqStKick07 = ~cntSeqStKick07 + 1;
				~cntSeqStKick07.switch(
					0,{},
					1, {IFSeqStKick.st07(0);},
					2, {IFSeqStKick.st07(1);
						~cntSeqStKick07=0;
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
				~cntSeqStKick08 = ~cntSeqStKick08 + 1;
				~cntSeqStKick08.switch(
					0,{},
					1, {IFSeqStKick.st08(0);},
					2, {IFSeqStKick.st08(1);
						~cntSeqStKick08=0;
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
				~cntSeqStKick09 = ~cntSeqStKick09 + 1;
				~cntSeqStKick09.switch(
					0,{},
					1, {IFSeqStKick.st09(0);},
					2, {IFSeqStKick.st09(1);
						~cntSeqStKick09=0;
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
				~cntSeqStKick10 = ~cntSeqStKick10 + 1;
				~cntSeqStKick10.switch(
					0,{},
					1, {IFSeqStKick.st10(0);},
					2, {IFSeqStKick.st10(1);
						~cntSeqStKick10=0;
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
				~cntSeqStKick11 = ~cntSeqStKick11 + 1;
				~cntSeqStKick11.switch(
					0,{},
					1, {IFSeqStKick.st11(0);},
					2, {IFSeqStKick.st11(1);
						~cntSeqStKick11=0;
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
				~cntSeqStKick12 = ~cntSeqStKick12 + 1;
				~cntSeqStKick12.switch(
					0,{},
					1, {IFSeqStKick.st12(0);},
					2, {IFSeqStKick.st12(1);
						~cntSeqStKick12=0;
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
				~cntSeqStKick13 = ~cntSeqStKick13 + 1;
				~cntSeqStKick13.switch(
					0,{},
					1, {IFSeqStKick.st13(0);},
					2, {IFSeqStKick.st13(1);
						~cntSeqStKick13=0;
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
				~cntSeqStKick14 = ~cntSeqStKick14 + 1;
				~cntSeqStKick14.switch(
					0,{},
					1, {IFSeqStKick.st14(0);},
					2, {IFSeqStKick.st14(1);
						~cntSeqStKick14=0;
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
				~cntSeqStKick15 = ~cntSeqStKick15 + 1;
				~cntSeqStKick15.switch(
					0,{},
					1, {IFSeqStKick.st15(0);},
					2, {IFSeqStKick.st15(1);
						~cntSeqStKick15=0;
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
				~cntSeqStKick16 = ~cntSeqStKick16 + 1;
				~cntSeqStKick16.switch(
					0,{},
					1, {IFSeqStKick.st16(0);},
					2, {IFSeqStKick.st16(1);
						~cntSeqStKick16=0;
					}
				)}
			);
			},
			'/ifSeq/1/16'
		);

	}//

	*st01 {|i=0|
		~seqStKick01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick01', i);
	}
	*st02 {|i=0|
		~seqStKick02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick02', i);
	}
	*st03 {|i=0|
		~seqStKick03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick03', i);
	}
	*st04 {|i=0|
		~seqStKick04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick04', i);
	}
	*st05 {|i=0|
		~seqStKick05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick05', i);
	}
	*st06 {|i=0|
		~seqStKick06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick06', i);
	}
	*st07 {|i=0|
		~seqStKick07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick07', i);
	}
	*st08 {|i=0|
		~seqStKick08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick08', i);
	}
	*st09 {|i=0|
		~seqStKick09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick09', i);
	}
	*st10 {|i=0|
		~seqStKick10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick10', i);
	}
	*st11 {|i=0|
		~seqStKick11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick11', i);
	}
	*st12 {|i=0|
		~seqStKick12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick12', i);
	}
	*st13 {|i=0|
		~seqStKick13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick13', i);
	}
	*st14 {|i=0|
		~seqStKick14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick14', i);
	}
	*st15 {|i=0|
		~seqStKick15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick15', i);
	}
	*st16 {|i=0|
		~seqStKick16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKick16', i);
	}
	*stGrp {|i|

		IFSeqStKick.st01(i); IFSeqStKick.st02(i); IFSeqStKick.st03(i); IFSeqStKick.st04(i);
		IFSeqStKick.st05(i); IFSeqStKick.st06(i); IFSeqStKick.st07(i); IFSeqStKick.st08(i);
		IFSeqStKick.st09(i); IFSeqStKick.st10(i); IFSeqStKick.st11(i); IFSeqStKick.st12(i);
		IFSeqStKick.st13(i); IFSeqStKick.st14(i); IFSeqStKick.st15(i); IFSeqStKick.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqStKick.st01(s01); IFSeqStKick.st02(s02); IFSeqStKick.st03(s03); IFSeqStKick.st04(s04);
		IFSeqStKick.st05(s05); IFSeqStKick.st06(s06); IFSeqStKick.st07(s07); IFSeqStKick.st08(s08);
		IFSeqStKick.st09(s09); IFSeqStKick.st10(s10); IFSeqStKick.st11(s11); IFSeqStKick.st12(s12);
		IFSeqStKick.st13(s13); IFSeqStKick.st14(s14); IFSeqStKick.st15(s15); IFSeqStKick.st16(s16);
	}
}