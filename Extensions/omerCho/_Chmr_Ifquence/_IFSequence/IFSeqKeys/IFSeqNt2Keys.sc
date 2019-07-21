IFSeqNt2Keys {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqNt2Keys01 = PatternProxy( Pseq([0], 1));
		~seqNt2Keys02 = PatternProxy( Pseq([0], 1));
		~seqNt2Keys03 = PatternProxy( Pseq([0], 1));
		~seqNt2Keys04 = PatternProxy( Pseq([0], 1));
		~seqNt2Keys05 = PatternProxy( Pseq([0], 1));
		~seqNt2Keys06 = PatternProxy( Pseq([0], 1));
		~seqNt2Keys07 = PatternProxy( Pseq([0], 1));
		~seqNt2Keys08 = PatternProxy( Pseq([0], 1));

		~seqNt2Keys09 = PatternProxy( Pseq([0], 1));
		~seqNt2Keys10 = PatternProxy( Pseq([0], 1));
		~seqNt2Keys11 = PatternProxy( Pseq([0], 1));
		~seqNt2Keys12 = PatternProxy( Pseq([0], 1));
		~seqNt2Keys13 = PatternProxy( Pseq([0], 1));
		~seqNt2Keys14 = PatternProxy( Pseq([0], 1));
		~seqNt2Keys15 = PatternProxy( Pseq([0], 1));
		~seqNt2Keys16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqNtUpKeys01=0;
		~cntSeqNtRandKeys01=0;

		~cntSeqNt2Keys01=0;
		~cntSeqNt2Keys02=0;
		~cntSeqNt2Keys03=0;
		~cntSeqNt2Keys04=0;
		~cntSeqNt2Keys05=0;
		~cntSeqNt2Keys06=0;
		~cntSeqNt2Keys07=0;
		~cntSeqNt2Keys08=0;

		~cntSeqNt2Keys09=0;
		~cntSeqNt2Keys10=0;
		~cntSeqNt2Keys11=0;
		~cntSeqNt2Keys12=0;
		~cntSeqNt2Keys13=0;
		~cntSeqNt2Keys14=0;
		~cntSeqNt2Keys15=0;
		~cntSeqNt2Keys16=0;
	}
	*freeOn {
		~seqFreeKeysBut.free;
		~seqFreeKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqNt2Keys.stGrp(0);
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
					1,{IFSeqNt2Keys.stGrp(0);},
					2,{IFSeqNt2Keys.stGrp(1);},
					3,{IFSeqNt2Keys.stGrp(2);},
					4,{IFSeqNt2Keys.stGrp(3);},
					5,{IFSeqNt2Keys.stGrp(4);},
					6,{IFSeqNt2Keys.stGrp(5);},
					7,{IFSeqNt2Keys.stGrp(6);},
					8,{IFSeqNt2Keys.stGrp(7);},
					9,{IFSeqNt2Keys.stGrp(8);},
					10,{IFSeqNt2Keys.stGrp(9);},
					11,{IFSeqNt2Keys.stGrp(10);},
					12,{IFSeqNt2Keys.stGrp(11);
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
						IFSeqNt2Keys.st01((0..11).choose);
						IFSeqNt2Keys.st02((0..11).choose);
						IFSeqNt2Keys.st03((0..11).choose);
						IFSeqNt2Keys.st04((0..11).choose);
						IFSeqNt2Keys.st05((0..11).choose);
						IFSeqNt2Keys.st06((0..11).choose);
						IFSeqNt2Keys.st07((0..11).choose);
						IFSeqNt2Keys.st08((0..11).choose);

						IFSeqNt2Keys.st09((0..11).choose);
						IFSeqNt2Keys.st10((0..11).choose);
						IFSeqNt2Keys.st11((0..11).choose);
						IFSeqNt2Keys.st12((0..11).choose);
						IFSeqNt2Keys.st13((0..11).choose);
						IFSeqNt2Keys.st14((0..11).choose);
						IFSeqNt2Keys.st15((0..11).choose);
						IFSeqNt2Keys.st16((0..11).choose);
						~cntSeqNtRandKeys01=0;
					}
				)}
			);
			},
			'/seqRandKeys'
		);
	}

	*on { // Shift NtAVE
		IFSeqNt2Keys.randOn;
		IFSeqNt2Keys.upOn;
		IFSeqNt2Keys.freeOn;

		~ifSeqKeysBut01.free;
		~ifSeqKeysBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNt2Keys01 = ~cntSeqNt2Keys01 + 1;
				~cntSeqNt2Keys01.switch(
					0,{},
					1, {IFSeqNt2Keys.st01(0);},
					2, {IFSeqNt2Keys.st01(1);},
					3, {IFSeqNt2Keys.st01(2);},
					4, {IFSeqNt2Keys.st01(3);},
					5, {IFSeqNt2Keys.st01(4);},
					6, {IFSeqNt2Keys.st01(5);},
					7, {IFSeqNt2Keys.st01(6);},
					8, {IFSeqNt2Keys.st01(7);},
					9, {IFSeqNt2Keys.st01(8);},
					10,{IFSeqNt2Keys.st01(9);},
					11,{IFSeqNt2Keys.st01(10);},
					12,{IFSeqNt2Keys.st01(11);
						~cntSeqNt2Keys01=0;
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
				~cntSeqNt2Keys02 = ~cntSeqNt2Keys02 + 1;
				~cntSeqNt2Keys02.switch(
					0,{},
					1, {IFSeqNt2Keys.st02(0);},
					2, {IFSeqNt2Keys.st02(1);},
					3, {IFSeqNt2Keys.st02(2);},
					4, {IFSeqNt2Keys.st02(3);},
					5, {IFSeqNt2Keys.st02(4);},
					6, {IFSeqNt2Keys.st02(5);},
					7, {IFSeqNt2Keys.st02(6);},
					8, {IFSeqNt2Keys.st02(7);},
					9, {IFSeqNt2Keys.st02(8);},
					10, {IFSeqNt2Keys.st02(9);},
					11,{IFSeqNt2Keys.st02(10);},
					12,{IFSeqNt2Keys.st02(11);
						~cntSeqNt2Keys02=0;
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
				~cntSeqNt2Keys03 = ~cntSeqNt2Keys03 + 1;
				~cntSeqNt2Keys03.switch(
					0,{},
					1, {IFSeqNt2Keys.st03(0);},
					2, {IFSeqNt2Keys.st03(1);},
					3, {IFSeqNt2Keys.st03(2);},
					4, {IFSeqNt2Keys.st03(3);},
					5, {IFSeqNt2Keys.st03(4);},
					6, {IFSeqNt2Keys.st03(5);},
					7, {IFSeqNt2Keys.st03(6);},
					8, {IFSeqNt2Keys.st03(7);},
					9, {IFSeqNt2Keys.st03(8);},
					10, {IFSeqNt2Keys.st03(9);},
					11,{IFSeqNt2Keys.st03(10);},
					12,{IFSeqNt2Keys.st03(11);
						~cntSeqNt2Keys03=0;
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
				~cntSeqNt2Keys04 = ~cntSeqNt2Keys04 + 1;
				~cntSeqNt2Keys04.switch(
					0,{},
					1, {IFSeqNt2Keys.st04(0);},
					2, {IFSeqNt2Keys.st04(1);},
					3, {IFSeqNt2Keys.st04(2);},
					4, {IFSeqNt2Keys.st04(3);},
					5, {IFSeqNt2Keys.st04(4);},
					6, {IFSeqNt2Keys.st04(5);},
					7, {IFSeqNt2Keys.st04(6);},
					8, {IFSeqNt2Keys.st04(7);},
					9, {IFSeqNt2Keys.st04(8);},
					10, {IFSeqNt2Keys.st04(9);},
					11,{IFSeqNt2Keys.st04(10);},
					12,{IFSeqNt2Keys.st04(11);
						~cntSeqNt2Keys04=0;
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
				~cntSeqNt2Keys05 = ~cntSeqNt2Keys05 + 1;
				~cntSeqNt2Keys05.switch(
					0,{},
					1, {IFSeqNt2Keys.st05(0);},
					2, {IFSeqNt2Keys.st05(1);},
					3, {IFSeqNt2Keys.st05(2);},
					4, {IFSeqNt2Keys.st05(3);},
					5, {IFSeqNt2Keys.st05(4);},
					6, {IFSeqNt2Keys.st05(5);},
					7, {IFSeqNt2Keys.st05(6);},
					8, {IFSeqNt2Keys.st05(7);},
					9, {IFSeqNt2Keys.st05(8);},
					10, {IFSeqNt2Keys.st05(9);},
					11,{IFSeqNt2Keys.st05(10);},
					12,{IFSeqNt2Keys.st05(11);
						~cntSeqNt2Keys05=0;
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
				~cntSeqNt2Keys06 = ~cntSeqNt2Keys06 + 1;
				~cntSeqNt2Keys06.switch(
					0,{},
					1, {IFSeqNt2Keys.st06(0);},
					2, {IFSeqNt2Keys.st06(1);},
					3, {IFSeqNt2Keys.st06(2);},
					4, {IFSeqNt2Keys.st06(3);},
					5, {IFSeqNt2Keys.st06(4);},
					6, {IFSeqNt2Keys.st06(5);},
					7, {IFSeqNt2Keys.st06(6);},
					8, {IFSeqNt2Keys.st06(7);},
					9, {IFSeqNt2Keys.st06(8);},
					10, {IFSeqNt2Keys.st06(9);},
					11,{IFSeqNt2Keys.st06(10);},
					12,{IFSeqNt2Keys.st06(11);
						~cntSeqNt2Keys06=0;
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
				~cntSeqNt2Keys07 = ~cntSeqNt2Keys07 + 1;
				~cntSeqNt2Keys07.switch(
					0,{},
					1, {IFSeqNt2Keys.st07(0);},
					2, {IFSeqNt2Keys.st07(1);},
					3, {IFSeqNt2Keys.st07(2);},
					4, {IFSeqNt2Keys.st07(3);},
					5, {IFSeqNt2Keys.st07(4);},
					6, {IFSeqNt2Keys.st07(5);},
					7, {IFSeqNt2Keys.st07(6);},
					8, {IFSeqNt2Keys.st07(7);},
					9, {IFSeqNt2Keys.st07(8);},
					10, {IFSeqNt2Keys.st07(9);},
					11,{IFSeqNt2Keys.st07(10);},
					12,{IFSeqNt2Keys.st07(11);
						~cntSeqNt2Keys07=0;
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
				~cntSeqNt2Keys08 = ~cntSeqNt2Keys08 + 1;
				~cntSeqNt2Keys08.switch(
					0,{},
					1, {IFSeqNt2Keys.st08(0);},
					2, {IFSeqNt2Keys.st08(1);},
					3, {IFSeqNt2Keys.st08(2);},
					4, {IFSeqNt2Keys.st08(3);},
					5, {IFSeqNt2Keys.st08(4);},
					6, {IFSeqNt2Keys.st08(5);},
					7, {IFSeqNt2Keys.st08(6);},
					8, {IFSeqNt2Keys.st08(7);},
					9, {IFSeqNt2Keys.st08(8);},
					10, {IFSeqNt2Keys.st08(9);},
					11,{IFSeqNt2Keys.st08(10);},
					12,{IFSeqNt2Keys.st08(11);
						~cntSeqNt2Keys08=0;
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
				~cntSeqNt2Keys09 = ~cntSeqNt2Keys09 + 1;
				~cntSeqNt2Keys09.switch(
					0,{},
					1, {IFSeqNt2Keys.st09(0);},
					2, {IFSeqNt2Keys.st09(1);},
					3, {IFSeqNt2Keys.st09(2);},
					4, {IFSeqNt2Keys.st09(3);},
					5, {IFSeqNt2Keys.st09(4);},
					6, {IFSeqNt2Keys.st09(5);},
					7, {IFSeqNt2Keys.st09(6);},
					8, {IFSeqNt2Keys.st09(7);},
					9, {IFSeqNt2Keys.st09(8);},
					10, {IFSeqNt2Keys.st09(9);},
					11,{IFSeqNt2Keys.st09(10);},
					12,{IFSeqNt2Keys.st09(11);
						~cntSeqNt2Keys09=0;
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
				~cntSeqNt2Keys10 = ~cntSeqNt2Keys10 + 1;
				~cntSeqNt2Keys10.switch(
					0,{},
					1, {IFSeqNt2Keys.st10(0);},
					2, {IFSeqNt2Keys.st10(1);},
					3, {IFSeqNt2Keys.st10(2);},
					4, {IFSeqNt2Keys.st10(3);},
					5, {IFSeqNt2Keys.st10(4);},
					6, {IFSeqNt2Keys.st10(5);},
					7, {IFSeqNt2Keys.st10(6);},
					8, {IFSeqNt2Keys.st10(7);},
					9, {IFSeqNt2Keys.st10(8);},
					10, {IFSeqNt2Keys.st10(9);},
					11,{IFSeqNt2Keys.st10(10);},
					12,{IFSeqNt2Keys.st10(11);
						~cntSeqNt2Keys10=0;
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
				~cntSeqNt2Keys11 = ~cntSeqNt2Keys11 + 1;
				~cntSeqNt2Keys11.switch(
					0,{},
					1, {IFSeqNt2Keys.st11(0);},
					2, {IFSeqNt2Keys.st11(1);},
					3, {IFSeqNt2Keys.st11(2);},
					4, {IFSeqNt2Keys.st11(3);},
					5, {IFSeqNt2Keys.st11(4);},
					6, {IFSeqNt2Keys.st11(5);},
					7, {IFSeqNt2Keys.st11(6);},
					8, {IFSeqNt2Keys.st11(7);},
					9, {IFSeqNt2Keys.st11(8);},
					10, {IFSeqNt2Keys.st11(9);},
					11,{IFSeqNt2Keys.st11(10);},
					12,{IFSeqNt2Keys.st11(11);
						~cntSeqNt2Keys11=0;
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
				~cntSeqNt2Keys12 = ~cntSeqNt2Keys12 + 1;
				~cntSeqNt2Keys12.switch(
					0,{},
					1, {IFSeqNt2Keys.st12(0);},
					2, {IFSeqNt2Keys.st12(1);},
					3, {IFSeqNt2Keys.st12(2);},
					4, {IFSeqNt2Keys.st12(3);},
					5, {IFSeqNt2Keys.st12(4);},
					6, {IFSeqNt2Keys.st12(5);},
					7, {IFSeqNt2Keys.st12(6);},
					8, {IFSeqNt2Keys.st12(7);},
					9, {IFSeqNt2Keys.st12(8);},
					10, {IFSeqNt2Keys.st12(9);},
					11,{IFSeqNt2Keys.st12(10);},
					12,{IFSeqNt2Keys.st12(11);
						~cntSeqNt2Keys12=0;
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
				~cntSeqNt2Keys13 = ~cntSeqNt2Keys13 + 1;
				~cntSeqNt2Keys13.switch(
					0,{},
					1, {IFSeqNt2Keys.st13(0);},
					2, {IFSeqNt2Keys.st13(1);},
					3, {IFSeqNt2Keys.st13(2);},
					4, {IFSeqNt2Keys.st13(3);},
					5, {IFSeqNt2Keys.st13(4);},
					6, {IFSeqNt2Keys.st13(5);},
					7, {IFSeqNt2Keys.st13(6);},
					8, {IFSeqNt2Keys.st13(7);},
					9, {IFSeqNt2Keys.st13(8);},
					10, {IFSeqNt2Keys.st13(9);},
					11,{IFSeqNt2Keys.st13(10);},
					12,{IFSeqNt2Keys.st13(11);
						~cntSeqNt2Keys13=0;
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
				~cntSeqNt2Keys14 = ~cntSeqNt2Keys14 + 1;
				~cntSeqNt2Keys14.switch(
					0,{},
					1, {IFSeqNt2Keys.st14(0);},
					2, {IFSeqNt2Keys.st14(1);},
					3, {IFSeqNt2Keys.st14(2);},
					4, {IFSeqNt2Keys.st14(3);},
					5, {IFSeqNt2Keys.st14(4);},
					6, {IFSeqNt2Keys.st14(5);},
					7, {IFSeqNt2Keys.st14(6);},
					8, {IFSeqNt2Keys.st14(7);},
					9, {IFSeqNt2Keys.st14(8);},
					10, {IFSeqNt2Keys.st14(9);},
					11,{IFSeqNt2Keys.st14(10);},
					12,{IFSeqNt2Keys.st14(11);
						~cntSeqNt2Keys14=0;
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
				~cntSeqNt2Keys15 = ~cntSeqNt2Keys15 + 1;
				~cntSeqNt2Keys15.switch(
					0,{},
					1, {IFSeqNt2Keys.st15(0);},
					2, {IFSeqNt2Keys.st15(1);},
					3, {IFSeqNt2Keys.st15(2);},
					4, {IFSeqNt2Keys.st15(3);},
					5, {IFSeqNt2Keys.st15(4);},
					6, {IFSeqNt2Keys.st15(5);},
					7, {IFSeqNt2Keys.st15(6);},
					8, {IFSeqNt2Keys.st15(7);},
					9, {IFSeqNt2Keys.st15(8);},
					10, {IFSeqNt2Keys.st15(9);},
					11,{IFSeqNt2Keys.st15(10);},
					12,{IFSeqNt2Keys.st15(11);
						~cntSeqNt2Keys15=0;
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
				~cntSeqNt2Keys16 = ~cntSeqNt2Keys16 + 1;
				~cntSeqNt2Keys16.switch(
					0,{},
					1, {IFSeqNt2Keys.st16(0);},
					2, {IFSeqNt2Keys.st16(1);},
					3, {IFSeqNt2Keys.st16(2);},
					4, {IFSeqNt2Keys.st16(3);},
					5, {IFSeqNt2Keys.st16(4);},
					6, {IFSeqNt2Keys.st16(5);},
					7, {IFSeqNt2Keys.st16(6);},
					8, {IFSeqNt2Keys.st16(7);},
					9, {IFSeqNt2Keys.st16(8);},
					10, {IFSeqNt2Keys.st16(9);},
					11,{IFSeqNt2Keys.st16(10);},
					12,{IFSeqNt2Keys.st16(11);
						~cntSeqNt2Keys16=0;
					}
				)}
			);
			},
			'/ifSeq/5/16'
		);

	}//

	*st01 {|i=0|
		~seqNt2Keys01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys01', i);
	}
	*st02 {|i=0|
		~seqNt2Keys02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys02', i);
	}
	*st03 {|i=0|
		~seqNt2Keys03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys03', i);
	}
	*st04 {|i=0|
		~seqNt2Keys04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys04', i);
	}
	*st05 {|i=0|
		~seqNt2Keys05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys05', i);
	}
	*st06 {|i=0|
		~seqNt2Keys06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys06', i);
	}
	*st07 {|i=0|
		~seqNt2Keys07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys07', i);
	}
	*st08 {|i=0|
		~seqNt2Keys08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys08', i);
	}

	*st09 {|i=0|
		~seqNt2Keys09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys09', i);
	}
	*st10 {|i=0|
		~seqNt2Keys10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys10', i);
	}
	*st11 {|i=0|
		~seqNt2Keys11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys11', i);
	}
	*st12 {|i=0|
		~seqNt2Keys12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys12', i);
	}
	*st13 {|i=0|
		~seqNt2Keys13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys13', i);
	}
	*st14 {|i=0|
		~seqNt2Keys14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys14', i);
	}
	*st15 {|i=0|
		~seqNt2Keys15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys15', i);
	}
	*st16 {|i=0|
		~seqNt2Keys16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNt2Keys16', i);
	}
	*stGrp {|i|

		IFSeqNt2Keys.st01(i); IFSeqNt2Keys.st02(i); IFSeqNt2Keys.st03(i); IFSeqNt2Keys.st04(i);
		IFSeqNt2Keys.st05(i); IFSeqNt2Keys.st06(i); IFSeqNt2Keys.st07(i); IFSeqNt2Keys.st08(i);
		IFSeqNt2Keys.st09(i); IFSeqNt2Keys.st10(i); IFSeqNt2Keys.st11(i); IFSeqNt2Keys.st12(i);
		IFSeqNt2Keys.st13(i); IFSeqNt2Keys.st14(i); IFSeqNt2Keys.st15(i); IFSeqNt2Keys.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqNt2Keys.st01(s01); IFSeqNt2Keys.st02(s02); IFSeqNt2Keys.st03(s03); IFSeqNt2Keys.st04(s04);
		IFSeqNt2Keys.st05(s05); IFSeqNt2Keys.st06(s06); IFSeqNt2Keys.st07(s07); IFSeqNt2Keys.st08(s08);
		IFSeqNt2Keys.st09(s09); IFSeqNt2Keys.st10(s10); IFSeqNt2Keys.st11(s11); IFSeqNt2Keys.st12(s12);
		IFSeqNt2Keys.st13(s13); IFSeqNt2Keys.st14(s14); IFSeqNt2Keys.st15(s15); IFSeqNt2Keys.st16(s16);
	}
}