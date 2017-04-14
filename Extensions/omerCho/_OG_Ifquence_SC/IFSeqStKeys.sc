IFSeqStKeys {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqStKeys01 = PatternProxy( Pseq([0], 1));
		~seqStKeys02 = PatternProxy( Pseq([0], 1));
		~seqStKeys03 = PatternProxy( Pseq([0], 1));
		~seqStKeys04 = PatternProxy( Pseq([0], 1));
		~seqStKeys05 = PatternProxy( Pseq([0], 1));
		~seqStKeys06 = PatternProxy( Pseq([0], 1));
		~seqStKeys07 = PatternProxy( Pseq([0], 1));
		~seqStKeys08 = PatternProxy( Pseq([0], 1));

		~seqStKeys09 = PatternProxy( Pseq([0], 1));
		~seqStKeys10 = PatternProxy( Pseq([0], 1));
		~seqStKeys11 = PatternProxy( Pseq([0], 1));
		~seqStKeys12 = PatternProxy( Pseq([0], 1));
		~seqStKeys13 = PatternProxy( Pseq([0], 1));
		~seqStKeys14 = PatternProxy( Pseq([0], 1));
		~seqStKeys15 = PatternProxy( Pseq([0], 1));
		~seqStKeys16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqStUpKeys01=0;
		~cntSeqStRandKeys01=0;

		~cntSeqStKeys01=0;
		~cntSeqStKeys02=0;
		~cntSeqStKeys03=0;
		~cntSeqStKeys04=0;
		~cntSeqStKeys05=0;
		~cntSeqStKeys06=0;
		~cntSeqStKeys07=0;
		~cntSeqStKeys08=0;

		~cntSeqStKeys09=0;
		~cntSeqStKeys10=0;
		~cntSeqStKeys11=0;
		~cntSeqStKeys12=0;
		~cntSeqStKeys13=0;
		~cntSeqStKeys14=0;
		~cntSeqStKeys15=0;
		~cntSeqStKeys16=0;
	}
	*freeOn {
		~seqFreeKeysBut.free;
		~seqFreeKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqStKeys.stGrp(0);
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
				~cntSeqStUpKeys01 = ~cntSeqStUpKeys01 + 1;
				~cntSeqStUpKeys01.switch(
					0,{},
					1,{IFSeqStKeys.stGrp(0);},
					2,{IFSeqStKeys.stGrp(1);},
					3,{IFSeqStKeys.stGrp(2);},
					4,{IFSeqStKeys.stGrp(3);},
					5,{IFSeqStKeys.stGrp(4);},
					6,{IFSeqStKeys.stGrp(5);},
					7,{IFSeqStKeys.stGrp(6);},
					8,{IFSeqStKeys.stGrp(7);
						~cntSeqStUpKeys01=0;
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
				~cntSeqStRandKeys01 = ~cntSeqStRandKeys01 + 1;
				~cntSeqStRandKeys01.switch(
					0,{},
					1,{
						IFSeqStKeys.st01([0,1].choose);
						IFSeqStKeys.st02([0,1].choose);
						IFSeqStKeys.st03([0,1].choose);
						IFSeqStKeys.st04([0,1].choose);
						IFSeqStKeys.st05([0,1].choose);
						IFSeqStKeys.st06([0,1].choose);
						IFSeqStKeys.st07([0,1].choose);
						IFSeqStKeys.st08([0,1].choose);

						IFSeqStKeys.st09([0,1].choose);
						IFSeqStKeys.st10([0,1].choose);
						IFSeqStKeys.st11([0,1].choose);
						IFSeqStKeys.st12([0,1].choose);
						IFSeqStKeys.st13([0,1].choose);
						IFSeqStKeys.st14([0,1].choose);
						IFSeqStKeys.st15([0,1].choose);
						IFSeqStKeys.st16([0,1].choose);
						~cntSeqStRandKeys01=0;
					}
				)}
			);
			},
			'/seqRandKeys'
		);
	}

	*on { // Shift StAVE
		IFSeqStKeys.randOn;
		IFSeqStKeys.upOn;
		IFSeqStKeys.freeOn;

		~ifSeqKeysBut01.free;
		~ifSeqKeysBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys01 = ~cntSeqStKeys01 + 1;
				~cntSeqStKeys01.switch(
					0,{},
					1, {IFSeqStKeys.st01(0);},
					2, {IFSeqStKeys.st01(1);
						~cntSeqStKeys01=0;
					}
				)}
			);
			},
			'/ifSeq/5/1'
		);
		~ifSeqKeysBut02.free;
		~ifSeqKeysBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys02 = ~cntSeqStKeys02 + 1;
				~cntSeqStKeys02.switch(
					0,{},
					1, {IFSeqStKeys.st02(0);},
					2, {IFSeqStKeys.st02(1);
						~cntSeqStKeys02=0;
					}
				)}
			);
			},
			'/ifSeq/5/2'
		);
		~ifSeqKeysBut03.free;
		~ifSeqKeysBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys03 = ~cntSeqStKeys03 + 1;
				~cntSeqStKeys03.switch(
					0,{},
					1, {IFSeqStKeys.st03(0);},
					2, {IFSeqStKeys.st03(1);
						~cntSeqStKeys03=0;
					}
				)}
			);
			},
			'/ifSeq/5/3'
		);
		~ifSeqKeysBut04.free;
		~ifSeqKeysBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys04 = ~cntSeqStKeys04 + 1;
				~cntSeqStKeys04.switch(
					0,{},
					1, {IFSeqStKeys.st04(0);},
					2, {IFSeqStKeys.st04(1);
						~cntSeqStKeys04=0;
					}
				)}
			);
			},
			'/ifSeq/5/4'
		);
		~ifSeqKeysBut05.free;
		~ifSeqKeysBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys05 = ~cntSeqStKeys05 + 1;
				~cntSeqStKeys05.switch(
					0,{},
					1, {IFSeqStKeys.st05(0);},
					2, {IFSeqStKeys.st05(1);
						~cntSeqStKeys05=0;
					}
				)}
			);
			},
			'/ifSeq/5/5'
		);
		~ifSeqKeysBut06.free;
		~ifSeqKeysBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys06 = ~cntSeqStKeys06 + 1;
				~cntSeqStKeys06.switch(
					0,{},
					1, {IFSeqStKeys.st06(0);},
					2, {IFSeqStKeys.st06(1);
						~cntSeqStKeys06=0;
					}
				)}
			);
			},
			'/ifSeq/5/6'
		);
		~ifSeqKeysBut07.free;
		~ifSeqKeysBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys07 = ~cntSeqStKeys07 + 1;
				~cntSeqStKeys07.switch(
					0,{},
					1, {IFSeqStKeys.st07(0);},
					2, {IFSeqStKeys.st07(1);
						~cntSeqStKeys07=0;
					}
				)}
			);
			},
			'/ifSeq/5/7'
		);
		~ifSeqKeysBut08.free;
		~ifSeqKeysBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys08 = ~cntSeqStKeys08 + 1;
				~cntSeqStKeys08.switch(
					0,{},
					1, {IFSeqStKeys.st08(0);},
					2, {IFSeqStKeys.st08(1);
						~cntSeqStKeys08=0;
					}
				)}
			);
			},
			'/ifSeq/5/8'
		);
		~ifSeqKeysBut09.free;
		~ifSeqKeysBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys09 = ~cntSeqStKeys09 + 1;
				~cntSeqStKeys09.switch(
					0,{},
					1, {IFSeqStKeys.st09(0);},
					2, {IFSeqStKeys.st09(1);
						~cntSeqStKeys09=0;
					}
				)}
			);
			},
			'/ifSeq/5/9'
		);
		~ifSeqKeysBut10.free;
		~ifSeqKeysBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys10 = ~cntSeqStKeys10 + 1;
				~cntSeqStKeys10.switch(
					0,{},
					1, {IFSeqStKeys.st10(0);},
					2, {IFSeqStKeys.st10(1);
						~cntSeqStKeys10=0;
					}
				)}
			);
			},
			'/ifSeq/5/10'
		);
		~ifSeqKeysBut11.free;
		~ifSeqKeysBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys11 = ~cntSeqStKeys11 + 1;
				~cntSeqStKeys11.switch(
					0,{},
					1, {IFSeqStKeys.st11(0);},
					2, {IFSeqStKeys.st11(1);
						~cntSeqStKeys11=0;
					}
				)}
			);
			},
			'/ifSeq/5/11'
		);
		~ifSeqKeysBut12.free;
		~ifSeqKeysBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys12 = ~cntSeqStKeys12 + 1;
				~cntSeqStKeys12.switch(
					0,{},
					1, {IFSeqStKeys.st12(0);},
					2, {IFSeqStKeys.st12(1);
						~cntSeqStKeys12=0;
					}
				)}
			);
			},
			'/ifSeq/5/12'
		);
		~ifSeqKeysBut13.free;
		~ifSeqKeysBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys13 = ~cntSeqStKeys13 + 1;
				~cntSeqStKeys13.switch(
					0,{},
					1, {IFSeqStKeys.st13(0);},
					2, {IFSeqStKeys.st13(1);
						~cntSeqStKeys13=0;
					}
				)}
			);
			},
			'/ifSeq/5/13'
		);
		~ifSeqKeysBut14.free;
		~ifSeqKeysBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys14 = ~cntSeqStKeys14 + 1;
				~cntSeqStKeys14.switch(
					0,{},
					1, {IFSeqStKeys.st14(0);},
					2, {IFSeqStKeys.st14(1);
						~cntSeqStKeys14=0;
					}
				)}
			);
			},
			'/ifSeq/5/14'
		);
		~ifSeqKeysBut15.free;
		~ifSeqKeysBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys15 = ~cntSeqStKeys15 + 1;
				~cntSeqStKeys15.switch(
					0,{},
					1, {IFSeqStKeys.st15(0);},
					2, {IFSeqStKeys.st15(1);
						~cntSeqStKeys15=0;
					}
				)}
			);
			},
			'/ifSeq/5/15'
		);
		~ifSeqKeysBut16.free;
		~ifSeqKeysBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStKeys16 = ~cntSeqStKeys16 + 1;
				~cntSeqStKeys16.switch(
					0,{},
					1, {IFSeqStKeys.st16(0);},
					2, {IFSeqStKeys.st16(1);
						~cntSeqStKeys16=0;
					}
				)}
			);
			},
			'/ifSeq/5/16'
		);

	}//

	*st01 {|i=0|
		~seqStKeys01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys01', i);
	}
	*st02 {|i=0|
		~seqStKeys02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys02', i);
	}
	*st03 {|i=0|
		~seqStKeys03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys03', i);
	}
	*st04 {|i=0|
		~seqStKeys04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys04', i);
	}
	*st05 {|i=0|
		~seqStKeys05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys05', i);
	}
	*st06 {|i=0|
		~seqStKeys06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys06', i);
	}
	*st07 {|i=0|
		~seqStKeys07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys07', i);
	}
	*st08 {|i=0|
		~seqStKeys08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys08', i);
	}
	*st09 {|i=0|
		~seqStKeys09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys09', i);
	}
	*st10 {|i=0|
		~seqStKeys10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys10', i);
	}
	*st11 {|i=0|
		~seqStKeys11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys11', i);
	}
	*st12 {|i=0|
		~seqStKeys12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys12', i);
	}
	*st13 {|i=0|
		~seqStKeys13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys13', i);
	}
	*st14 {|i=0|
		~seqStKeys14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys14', i);
	}
	*st15 {|i=0|
		~seqStKeys15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys15', i);
	}
	*st16 {|i=0|
		~seqStKeys16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStKeys16', i);
	}
	*stGrp {|i|

		IFSeqStKeys.st01(i); IFSeqStKeys.st02(i); IFSeqStKeys.st03(i); IFSeqStKeys.st04(i);
		IFSeqStKeys.st05(i); IFSeqStKeys.st06(i); IFSeqStKeys.st07(i); IFSeqStKeys.st08(i);
		IFSeqStKeys.st09(i); IFSeqStKeys.st10(i); IFSeqStKeys.st11(i); IFSeqStKeys.st12(i);
		IFSeqStKeys.st13(i); IFSeqStKeys.st14(i); IFSeqStKeys.st15(i); IFSeqStKeys.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqStKeys.st01(s01); IFSeqStKeys.st02(s02); IFSeqStKeys.st03(s03); IFSeqStKeys.st04(s04);
		IFSeqStKeys.st05(s05); IFSeqStKeys.st06(s06); IFSeqStKeys.st07(s07); IFSeqStKeys.st08(s08);
		IFSeqStKeys.st09(s09); IFSeqStKeys.st10(s10); IFSeqStKeys.st11(s11); IFSeqStKeys.st12(s12);
		IFSeqStKeys.st13(s13); IFSeqStKeys.st14(s14); IFSeqStKeys.st15(s15); IFSeqStKeys.st16(s16);
	}
}