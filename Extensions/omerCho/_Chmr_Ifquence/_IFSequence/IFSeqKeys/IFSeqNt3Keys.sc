IFSeqNt3Keys {
	*loadAll {
		this.loadProxy;
		this.countReset;
	}
	*loadProxy {
		~seqNt3Keys01 = PatternProxy( Pseq([0], 1));
		~seqNt3Keys02 = PatternProxy( Pseq([0], 1));
		~seqNt3Keys03 = PatternProxy( Pseq([0], 1));
		~seqNt3Keys04 = PatternProxy( Pseq([0], 1));
		~seqNt3Keys05 = PatternProxy( Pseq([0], 1));
		~seqNt3Keys06 = PatternProxy( Pseq([0], 1));
		~seqNt3Keys07 = PatternProxy( Pseq([0], 1));
		~seqNt3Keys08 = PatternProxy( Pseq([0], 1));

		~seqNt3Keys09 = PatternProxy( Pseq([0], 1));
		~seqNt3Keys10 = PatternProxy( Pseq([0], 1));
		~seqNt3Keys11 = PatternProxy( Pseq([0], 1));
		~seqNt3Keys12 = PatternProxy( Pseq([0], 1));
		~seqNt3Keys13 = PatternProxy( Pseq([0], 1));
		~seqNt3Keys14 = PatternProxy( Pseq([0], 1));
		~seqNt3Keys15 = PatternProxy( Pseq([0], 1));
		~seqNt3Keys16 = PatternProxy( Pseq([0], 1));
	}

	*countReset {
		~cntSeqNtUpKeys01=0;
		~cntSeqNtRandKeys01=0;

		~cntSeqNt3Keys01=0;
		~cntSeqNt3Keys02=0;
		~cntSeqNt3Keys03=0;
		~cntSeqNt3Keys04=0;
		~cntSeqNt3Keys05=0;
		~cntSeqNt3Keys06=0;
		~cntSeqNt3Keys07=0;
		~cntSeqNt3Keys08=0;

		~cntSeqNt3Keys09=0;
		~cntSeqNt3Keys10=0;
		~cntSeqNt3Keys11=0;
		~cntSeqNt3Keys12=0;
		~cntSeqNt3Keys13=0;
		~cntSeqNt3Keys14=0;
		~cntSeqNt3Keys15=0;
		~cntSeqNt3Keys16=0;
	}
	*freeOn {
		~seqFreeKeysBut.free;
		~seqFreeKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqNt3Keys.stGrp(0);
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
				~cntSeqNtUpKeys01 = ~cntSeqNtUpKeys01 + 1;
				~cntSeqNtUpKeys01.switch(
					0,{},
					1,{IFSeqNt3Keys.stGrp(0);},
					2,{IFSeqNt3Keys.stGrp(1);},
					3,{IFSeqNt3Keys.stGrp(2);},
					4,{IFSeqNt3Keys.stGrp(3);},
					5,{IFSeqNt3Keys.stGrp(4);},
					6,{IFSeqNt3Keys.stGrp(5);},
					7,{IFSeqNt3Keys.stGrp(6);},
					8,{IFSeqNt3Keys.stGrp(7);},
					9,{IFSeqNt3Keys.stGrp(8);},
					10,{IFSeqNt3Keys.stGrp(9);},
					11,{IFSeqNt3Keys.stGrp(10);},
					12,{IFSeqNt3Keys.stGrp(11);
						~cntSeqNtUpKeys01=0;
					}
				)}
			);
			},'/seqUpKeys');
	}

	*randOn {
		~ifSeqRandKeysBut.free;
		~ifSeqRandKeysBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtRandKeys01 = ~cntSeqNtRandKeys01 + 1;
				~cntSeqNtRandKeys01.switch(
					0,{},
					1,{
						IFSeqNt3Keys.st01((0..11).choose);
						IFSeqNt3Keys.st02((0..11).choose);
						IFSeqNt3Keys.st03((0..11).choose);
						IFSeqNt3Keys.st04((0..11).choose);
						IFSeqNt3Keys.st05((0..11).choose);
						IFSeqNt3Keys.st06((0..11).choose);
						IFSeqNt3Keys.st07((0..11).choose);
						IFSeqNt3Keys.st08((0..11).choose);

						IFSeqNt3Keys.st09((0..11).choose);
						IFSeqNt3Keys.st10((0..11).choose);
						IFSeqNt3Keys.st11((0..11).choose);
						IFSeqNt3Keys.st12((0..11).choose);
						IFSeqNt3Keys.st13((0..11).choose);
						IFSeqNt3Keys.st14((0..11).choose);
						IFSeqNt3Keys.st15((0..11).choose);
						IFSeqNt3Keys.st16((0..11).choose);
						~cntSeqNtRandKeys01=0;
					}
				)}
			);
			},
			'/seqRandKeys'
		);
	}

	*on { // Shift NtAVE
		IFSeqNt3Keys.randOn;
		IFSeqNt3Keys.upOn;
		IFSeqNt3Keys.freeOn;

		~ifSeqKeysBut01.free;
		~ifSeqKeysBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNt3Keys01 = ~cntSeqNt3Keys01 + 1;
				~cntSeqNt3Keys01.switch(
					0,{},
					1, {IFSeqNt3Keys.st01(0);},
					2, {IFSeqNt3Keys.st01(1);},
					3, {IFSeqNt3Keys.st01(2);},
					4, {IFSeqNt3Keys.st01(3);},
					5, {IFSeqNt3Keys.st01(4);},
					6, {IFSeqNt3Keys.st01(5);},
					7, {IFSeqNt3Keys.st01(6);},
					8, {IFSeqNt3Keys.st01(7);},
					9, {IFSeqNt3Keys.st01(8);},
					10,{IFSeqNt3Keys.st01(9);},
					11,{IFSeqNt3Keys.st01(10);},
					12,{IFSeqNt3Keys.st01(11);
						~cntSeqNt3Keys01=0;
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
				~cntSeqNt3Keys02 = ~cntSeqNt3Keys02 + 1;
				~cntSeqNt3Keys02.switch(
					0,{},
					1, {IFSeqNt3Keys.st02(0);},
					2, {IFSeqNt3Keys.st02(1);},
					3, {IFSeqNt3Keys.st02(2);},
					4, {IFSeqNt3Keys.st02(3);},
					5, {IFSeqNt3Keys.st02(4);},
					6, {IFSeqNt3Keys.st02(5);},
					7, {IFSeqNt3Keys.st02(6);},
					8, {IFSeqNt3Keys.st02(7);},
					9, {IFSeqNt3Keys.st02(8);},
					10, {IFSeqNt3Keys.st02(9);},
					11,{IFSeqNt3Keys.st02(10);},
					12,{IFSeqNt3Keys.st02(11);
						~cntSeqNt3Keys02=0;
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
				~cntSeqNt3Keys03 = ~cntSeqNt3Keys03 + 1;
				~cntSeqNt3Keys03.switch(
					0,{},
					1, {IFSeqNt3Keys.st03(0);},
					2, {IFSeqNt3Keys.st03(1);},
					3, {IFSeqNt3Keys.st03(2);},
					4, {IFSeqNt3Keys.st03(3);},
					5, {IFSeqNt3Keys.st03(4);},
					6, {IFSeqNt3Keys.st03(5);},
					7, {IFSeqNt3Keys.st03(6);},
					8, {IFSeqNt3Keys.st03(7);},
					9, {IFSeqNt3Keys.st03(8);},
					10, {IFSeqNt3Keys.st03(9);},
					11,{IFSeqNt3Keys.st03(10);},
					12,{IFSeqNt3Keys.st03(11);
						~cntSeqNt3Keys03=0;
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
				~cntSeqNt3Keys04 = ~cntSeqNt3Keys04 + 1;
				~cntSeqNt3Keys04.switch(
					0,{},
					1, {IFSeqNt3Keys.st04(0);},
					2, {IFSeqNt3Keys.st04(1);},
					3, {IFSeqNt3Keys.st04(2);},
					4, {IFSeqNt3Keys.st04(3);},
					5, {IFSeqNt3Keys.st04(4);},
					6, {IFSeqNt3Keys.st04(5);},
					7, {IFSeqNt3Keys.st04(6);},
					8, {IFSeqNt3Keys.st04(7);},
					9, {IFSeqNt3Keys.st04(8);},
					10, {IFSeqNt3Keys.st04(9);},
					11,{IFSeqNt3Keys.st04(10);},
					12,{IFSeqNt3Keys.st04(11);
						~cntSeqNt3Keys04=0;
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
				~cntSeqNt3Keys05 = ~cntSeqNt3Keys05 + 1;
				~cntSeqNt3Keys05.switch(
					0,{},
					1, {IFSeqNt3Keys.st05(0);},
					2, {IFSeqNt3Keys.st05(1);},
					3, {IFSeqNt3Keys.st05(2);},
					4, {IFSeqNt3Keys.st05(3);},
					5, {IFSeqNt3Keys.st05(4);},
					6, {IFSeqNt3Keys.st05(5);},
					7, {IFSeqNt3Keys.st05(6);},
					8, {IFSeqNt3Keys.st05(7);},
					9, {IFSeqNt3Keys.st05(8);},
					10, {IFSeqNt3Keys.st05(9);},
					11,{IFSeqNt3Keys.st05(10);},
					12,{IFSeqNt3Keys.st05(11);
						~cntSeqNt3Keys05=0;
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
				~cntSeqNt3Keys06 = ~cntSeqNt3Keys06 + 1;
				~cntSeqNt3Keys06.switch(
					0,{},
					1, {IFSeqNt3Keys.st06(0);},
					2, {IFSeqNt3Keys.st06(1);},
					3, {IFSeqNt3Keys.st06(2);},
					4, {IFSeqNt3Keys.st06(3);},
					5, {IFSeqNt3Keys.st06(4);},
					6, {IFSeqNt3Keys.st06(5);},
					7, {IFSeqNt3Keys.st06(6);},
					8, {IFSeqNt3Keys.st06(7);},
					9, {IFSeqNt3Keys.st06(8);},
					10, {IFSeqNt3Keys.st06(9);},
					11,{IFSeqNt3Keys.st06(10);},
					12,{IFSeqNt3Keys.st06(11);
						~cntSeqNt3Keys06=0;
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
				~cntSeqNt3Keys07 = ~cntSeqNt3Keys07 + 1;
				~cntSeqNt3Keys07.switch(
					0,{},
					1, {IFSeqNt3Keys.st07(0);},
					2, {IFSeqNt3Keys.st07(1);},
					3, {IFSeqNt3Keys.st07(2);},
					4, {IFSeqNt3Keys.st07(3);},
					5, {IFSeqNt3Keys.st07(4);},
					6, {IFSeqNt3Keys.st07(5);},
					7, {IFSeqNt3Keys.st07(6);},
					8, {IFSeqNt3Keys.st07(7);},
					9, {IFSeqNt3Keys.st07(8);},
					10, {IFSeqNt3Keys.st07(9);},
					11,{IFSeqNt3Keys.st07(10);},
					12,{IFSeqNt3Keys.st07(11);
						~cntSeqNt3Keys07=0;
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
				~cntSeqNt3Keys08 = ~cntSeqNt3Keys08 + 1;
				~cntSeqNt3Keys08.switch(
					0,{},
					1, {IFSeqNt3Keys.st08(0);},
					2, {IFSeqNt3Keys.st08(1);},
					3, {IFSeqNt3Keys.st08(2);},
					4, {IFSeqNt3Keys.st08(3);},
					5, {IFSeqNt3Keys.st08(4);},
					6, {IFSeqNt3Keys.st08(5);},
					7, {IFSeqNt3Keys.st08(6);},
					8, {IFSeqNt3Keys.st08(7);},
					9, {IFSeqNt3Keys.st08(8);},
					10, {IFSeqNt3Keys.st08(9);},
					11,{IFSeqNt3Keys.st08(10);},
					12,{IFSeqNt3Keys.st08(11);
						~cntSeqNt3Keys08=0;
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
				~cntSeqNt3Keys09 = ~cntSeqNt3Keys09 + 1;
				~cntSeqNt3Keys09.switch(
					0,{},
					1, {IFSeqNt3Keys.st09(0);},
					2, {IFSeqNt3Keys.st09(1);},
					3, {IFSeqNt3Keys.st09(2);},
					4, {IFSeqNt3Keys.st09(3);},
					5, {IFSeqNt3Keys.st09(4);},
					6, {IFSeqNt3Keys.st09(5);},
					7, {IFSeqNt3Keys.st09(6);},
					8, {IFSeqNt3Keys.st09(7);},
					9, {IFSeqNt3Keys.st09(8);},
					10, {IFSeqNt3Keys.st09(9);},
					11,{IFSeqNt3Keys.st09(10);},
					12,{IFSeqNt3Keys.st09(11);
						~cntSeqNt3Keys09=0;
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
				~cntSeqNt3Keys10 = ~cntSeqNt3Keys10 + 1;
				~cntSeqNt3Keys10.switch(
					0,{},
					1, {IFSeqNt3Keys.st10(0);},
					2, {IFSeqNt3Keys.st10(1);},
					3, {IFSeqNt3Keys.st10(2);},
					4, {IFSeqNt3Keys.st10(3);},
					5, {IFSeqNt3Keys.st10(4);},
					6, {IFSeqNt3Keys.st10(5);},
					7, {IFSeqNt3Keys.st10(6);},
					8, {IFSeqNt3Keys.st10(7);},
					9, {IFSeqNt3Keys.st10(8);},
					10, {IFSeqNt3Keys.st10(9);},
					11,{IFSeqNt3Keys.st10(10);},
					12,{IFSeqNt3Keys.st10(11);
						~cntSeqNt3Keys10=0;
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
				~cntSeqNt3Keys11 = ~cntSeqNt3Keys11 + 1;
				~cntSeqNt3Keys11.switch(
					0,{},
					1, {IFSeqNt3Keys.st11(0);},
					2, {IFSeqNt3Keys.st11(1);},
					3, {IFSeqNt3Keys.st11(2);},
					4, {IFSeqNt3Keys.st11(3);},
					5, {IFSeqNt3Keys.st11(4);},
					6, {IFSeqNt3Keys.st11(5);},
					7, {IFSeqNt3Keys.st11(6);},
					8, {IFSeqNt3Keys.st11(7);},
					9, {IFSeqNt3Keys.st11(8);},
					10, {IFSeqNt3Keys.st11(9);},
					11,{IFSeqNt3Keys.st11(10);},
					12,{IFSeqNt3Keys.st11(11);
						~cntSeqNt3Keys11=0;
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
				~cntSeqNt3Keys12 = ~cntSeqNt3Keys12 + 1;
				~cntSeqNt3Keys12.switch(
					0,{},
					1, {IFSeqNt3Keys.st12(0);},
					2, {IFSeqNt3Keys.st12(1);},
					3, {IFSeqNt3Keys.st12(2);},
					4, {IFSeqNt3Keys.st12(3);},
					5, {IFSeqNt3Keys.st12(4);},
					6, {IFSeqNt3Keys.st12(5);},
					7, {IFSeqNt3Keys.st12(6);},
					8, {IFSeqNt3Keys.st12(7);},
					9, {IFSeqNt3Keys.st12(8);},
					10, {IFSeqNt3Keys.st12(9);},
					11,{IFSeqNt3Keys.st12(10);},
					12,{IFSeqNt3Keys.st12(11);
						~cntSeqNt3Keys12=0;
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
				~cntSeqNt3Keys13 = ~cntSeqNt3Keys13 + 1;
				~cntSeqNt3Keys13.switch(
					0,{},
					1, {IFSeqNt3Keys.st13(0);},
					2, {IFSeqNt3Keys.st13(1);},
					3, {IFSeqNt3Keys.st13(2);},
					4, {IFSeqNt3Keys.st13(3);},
					5, {IFSeqNt3Keys.st13(4);},
					6, {IFSeqNt3Keys.st13(5);},
					7, {IFSeqNt3Keys.st13(6);},
					8, {IFSeqNt3Keys.st13(7);},
					9, {IFSeqNt3Keys.st13(8);},
					10, {IFSeqNt3Keys.st13(9);},
					11,{IFSeqNt3Keys.st13(10);},
					12,{IFSeqNt3Keys.st13(11);
						~cntSeqNt3Keys13=0;
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
				~cntSeqNt3Keys14 = ~cntSeqNt3Keys14 + 1;
				~cntSeqNt3Keys14.switch(
					0,{},
					1, {IFSeqNt3Keys.st14(0);},
					2, {IFSeqNt3Keys.st14(1);},
					3, {IFSeqNt3Keys.st14(2);},
					4, {IFSeqNt3Keys.st14(3);},
					5, {IFSeqNt3Keys.st14(4);},
					6, {IFSeqNt3Keys.st14(5);},
					7, {IFSeqNt3Keys.st14(6);},
					8, {IFSeqNt3Keys.st14(7);},
					9, {IFSeqNt3Keys.st14(8);},
					10, {IFSeqNt3Keys.st14(9);},
					11,{IFSeqNt3Keys.st14(10);},
					12,{IFSeqNt3Keys.st14(11);
						~cntSeqNt3Keys14=0;
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
				~cntSeqNt3Keys15 = ~cntSeqNt3Keys15 + 1;
				~cntSeqNt3Keys15.switch(
					0,{},
					1, {IFSeqNt3Keys.st15(0);},
					2, {IFSeqNt3Keys.st15(1);},
					3, {IFSeqNt3Keys.st15(2);},
					4, {IFSeqNt3Keys.st15(3);},
					5, {IFSeqNt3Keys.st15(4);},
					6, {IFSeqNt3Keys.st15(5);},
					7, {IFSeqNt3Keys.st15(6);},
					8, {IFSeqNt3Keys.st15(7);},
					9, {IFSeqNt3Keys.st15(8);},
					10, {IFSeqNt3Keys.st15(9);},
					11,{IFSeqNt3Keys.st15(10);},
					12,{IFSeqNt3Keys.st15(11);
						~cntSeqNt3Keys15=0;
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
				~cntSeqNt3Keys16 = ~cntSeqNt3Keys16 + 1;
				~cntSeqNt3Keys16.switch(
					0,{},
					1, {IFSeqNt3Keys.st16(0);},
					2, {IFSeqNt3Keys.st16(1);},
					3, {IFSeqNt3Keys.st16(2);},
					4, {IFSeqNt3Keys.st16(3);},
					5, {IFSeqNt3Keys.st16(4);},
					6, {IFSeqNt3Keys.st16(5);},
					7, {IFSeqNt3Keys.st16(6);},
					8, {IFSeqNt3Keys.st16(7);},
					9, {IFSeqNt3Keys.st16(8);},
					10, {IFSeqNt3Keys.st16(9);},
					11,{IFSeqNt3Keys.st16(10);},
					12,{IFSeqNt3Keys.st16(11);
						~cntSeqNt3Keys16=0;
					}
				)}
			);
			},
			'/ifSeq/5/16'
		);

	}//

	*st01 {|i=0|
		~seqNt3Keys01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys01', i);
	}
	*st02 {|i=0|
		~seqNt3Keys02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys02', i);
	}
	*st03 {|i=0|
		~seqNt3Keys03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys03', i);
	}
	*st04 {|i=0|
		~seqNt3Keys04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys04', i);
	}
	*st05 {|i=0|
		~seqNt3Keys05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys05', i);
	}
	*st06 {|i=0|
		~seqNt3Keys06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys06', i);
	}
	*st07 {|i=0|
		~seqNt3Keys07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys07', i);
	}
	*st08 {|i=0|
		~seqNt3Keys08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys08', i);
	}

	*st09 {|i=0|
		~seqNt3Keys09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys09', i);
	}
	*st10 {|i=0|
		~seqNt3Keys10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys10', i);
	}
	*st11 {|i=0|
		~seqNt3Keys11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys11', i);
	}
	*st12 {|i=0|
		~seqNt3Keys12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys12', i);
	}
	*st13 {|i=0|
		~seqNt3Keys13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys13', i);
	}
	*st14 {|i=0|
		~seqNt3Keys14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys14', i);
	}
	*st15 {|i=0|
		~seqNt3Keys15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys15', i);
	}
	*st16 {|i=0|
		~seqNt3Keys16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt3Keys16', i);
	}
	*stGrp {|i|

		IFSeqNt3Keys.st01(i); IFSeqNt3Keys.st02(i); IFSeqNt3Keys.st03(i); IFSeqNt3Keys.st04(i);
		IFSeqNt3Keys.st05(i); IFSeqNt3Keys.st06(i); IFSeqNt3Keys.st07(i); IFSeqNt3Keys.st08(i);
		IFSeqNt3Keys.st09(i); IFSeqNt3Keys.st10(i); IFSeqNt3Keys.st11(i); IFSeqNt3Keys.st12(i);
		IFSeqNt3Keys.st13(i); IFSeqNt3Keys.st14(i); IFSeqNt3Keys.st15(i); IFSeqNt3Keys.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqNt3Keys.st01(s01); IFSeqNt3Keys.st02(s02); IFSeqNt3Keys.st03(s03); IFSeqNt3Keys.st04(s04);
		IFSeqNt3Keys.st05(s05); IFSeqNt3Keys.st06(s06); IFSeqNt3Keys.st07(s07); IFSeqNt3Keys.st08(s08);
		IFSeqNt3Keys.st09(s09); IFSeqNt3Keys.st10(s10); IFSeqNt3Keys.st11(s11); IFSeqNt3Keys.st12(s12);
		IFSeqNt3Keys.st13(s13); IFSeqNt3Keys.st14(s14); IFSeqNt3Keys.st15(s15); IFSeqNt3Keys.st16(s16);
	}
}