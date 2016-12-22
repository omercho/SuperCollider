IFSeqNtKeys {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqNtKeys01 = PatternProxy( Pseq([0], 1));
		~seqNtKeys02 = PatternProxy( Pseq([0], 1));
		~seqNtKeys03 = PatternProxy( Pseq([0], 1));
		~seqNtKeys04 = PatternProxy( Pseq([0], 1));
		~seqNtKeys05 = PatternProxy( Pseq([0], 1));
		~seqNtKeys06 = PatternProxy( Pseq([0], 1));
		~seqNtKeys07 = PatternProxy( Pseq([0], 1));
		~seqNtKeys08 = PatternProxy( Pseq([0], 1));

		~seqNtKeys09 = PatternProxy( Pseq([0], 1));
		~seqNtKeys10 = PatternProxy( Pseq([0], 1));
		~seqNtKeys11 = PatternProxy( Pseq([0], 1));
		~seqNtKeys12 = PatternProxy( Pseq([0], 1));
		~seqNtKeys13 = PatternProxy( Pseq([0], 1));
		~seqNtKeys14 = PatternProxy( Pseq([0], 1));
		~seqNtKeys15 = PatternProxy( Pseq([0], 1));
		~seqNtKeys16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqNtUpKeys01=0;
		~cntSeqNtRandKeys01=0;

		~cntSeqNtKeys01=0;
		~cntSeqNtKeys02=0;
		~cntSeqNtKeys03=0;
		~cntSeqNtKeys04=0;
		~cntSeqNtKeys05=0;
		~cntSeqNtKeys06=0;
		~cntSeqNtKeys07=0;
		~cntSeqNtKeys08=0;

		~cntSeqNtKeys09=0;
		~cntSeqNtKeys10=0;
		~cntSeqNtKeys11=0;
		~cntSeqNtKeys12=0;
		~cntSeqNtKeys13=0;
		~cntSeqNtKeys14=0;
		~cntSeqNtKeys15=0;
		~cntSeqNtKeys16=0;
	}
	*freeOn {
		~seqFreeKeysBut.free;
		~seqFreeKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqNtKeys.stGrp(0);
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
					1,{IFSeqNtKeys.stGrp(0);},
					2,{IFSeqNtKeys.stGrp(1);},
					3,{IFSeqNtKeys.stGrp(2);},
					4,{IFSeqNtKeys.stGrp(3);},
					5,{IFSeqNtKeys.stGrp(4);},
					6,{IFSeqNtKeys.stGrp(5);},
					7,{IFSeqNtKeys.stGrp(6);},
					8,{IFSeqNtKeys.stGrp(7);},
					9,{IFSeqNtKeys.stGrp(8);},
					10,{IFSeqNtKeys.stGrp(9);},
					11,{IFSeqNtKeys.stGrp(10);},
					12,{IFSeqNtKeys.stGrp(11);
						~cntSeqNtUpKeys01=0;
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
				~cntSeqNtRandKeys01 = ~cntSeqNtRandKeys01 + 1;
				~cntSeqNtRandKeys01.switch(
					0,{},
					1,{
						IFSeqNtKeys.st01((0..11).choose);
						IFSeqNtKeys.st02((0..11).choose);
						IFSeqNtKeys.st03((0..11).choose);
						IFSeqNtKeys.st04((0..11).choose);
						IFSeqNtKeys.st05((0..11).choose);
						IFSeqNtKeys.st06((0..11).choose);
						IFSeqNtKeys.st07((0..11).choose);
						IFSeqNtKeys.st08((0..11).choose);

						IFSeqNtKeys.st09((0..11).choose);
						IFSeqNtKeys.st10((0..11).choose);
						IFSeqNtKeys.st11((0..11).choose);
						IFSeqNtKeys.st12((0..11).choose);
						IFSeqNtKeys.st13((0..11).choose);
						IFSeqNtKeys.st14((0..11).choose);
						IFSeqNtKeys.st15((0..11).choose);
						IFSeqNtKeys.st16((0..11).choose);
						~cntSeqNtRandKeys01=0;
					}
				)}
			);
			},
			'/seqRandKeys'
		);
	}

	*on { // Shift NtAVE
		IFSeqNtKeys.randOn;
		IFSeqNtKeys.upOn;
		IFSeqNtKeys.freeOn;

		~ifSeqKeysBut01.free;
		~ifSeqKeysBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKeys01 = ~cntSeqNtKeys01 + 1;
				~cntSeqNtKeys01.switch(
					0,{},
					1, {IFSeqNtKeys.st01(0);},
					2, {IFSeqNtKeys.st01(1);},
					3, {IFSeqNtKeys.st01(2);},
					4, {IFSeqNtKeys.st01(3);},
					5, {IFSeqNtKeys.st01(4);},
					6, {IFSeqNtKeys.st01(5);},
					7, {IFSeqNtKeys.st01(6);},
					8, {IFSeqNtKeys.st01(7);},
					9, {IFSeqNtKeys.st01(8);},
					10,{IFSeqNtKeys.st01(9);},
					11,{IFSeqNtKeys.st01(10);},
					12,{IFSeqNtKeys.st01(11);
						~cntSeqNtKeys01=0;
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
				~cntSeqNtKeys02 = ~cntSeqNtKeys02 + 1;
				~cntSeqNtKeys02.switch(
					0,{},
					1, {IFSeqNtKeys.st02(0);},
					2, {IFSeqNtKeys.st02(1);},
					3, {IFSeqNtKeys.st02(2);},
					4, {IFSeqNtKeys.st02(3);},
					5, {IFSeqNtKeys.st02(4);},
					6, {IFSeqNtKeys.st02(5);},
					7, {IFSeqNtKeys.st02(6);},
					8, {IFSeqNtKeys.st02(7);},
					9, {IFSeqNtKeys.st02(8);},
					10, {IFSeqNtKeys.st02(9);},
					11,{IFSeqNtKeys.st02(10);},
					12,{IFSeqNtKeys.st02(11);
						~cntSeqNtKeys02=0;
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
				~cntSeqNtKeys03 = ~cntSeqNtKeys03 + 1;
				~cntSeqNtKeys03.switch(
					0,{},
					1, {IFSeqNtKeys.st03(0);},
					2, {IFSeqNtKeys.st03(1);},
					3, {IFSeqNtKeys.st03(2);},
					4, {IFSeqNtKeys.st03(3);},
					5, {IFSeqNtKeys.st03(4);},
					6, {IFSeqNtKeys.st03(5);},
					7, {IFSeqNtKeys.st03(6);},
					8, {IFSeqNtKeys.st03(7);},
					9, {IFSeqNtKeys.st03(8);},
					10, {IFSeqNtKeys.st03(9);},
					11,{IFSeqNtKeys.st03(10);},
					12,{IFSeqNtKeys.st03(11);
						~cntSeqNtKeys03=0;
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
				~cntSeqNtKeys04 = ~cntSeqNtKeys04 + 1;
				~cntSeqNtKeys04.switch(
					0,{},
					1, {IFSeqNtKeys.st04(0);},
					2, {IFSeqNtKeys.st04(1);},
					3, {IFSeqNtKeys.st04(2);},
					4, {IFSeqNtKeys.st04(3);},
					5, {IFSeqNtKeys.st04(4);},
					6, {IFSeqNtKeys.st04(5);},
					7, {IFSeqNtKeys.st04(6);},
					8, {IFSeqNtKeys.st04(7);},
					9, {IFSeqNtKeys.st04(8);},
					10, {IFSeqNtKeys.st04(9);},
					11,{IFSeqNtKeys.st04(10);},
					12,{IFSeqNtKeys.st04(11);
						~cntSeqNtKeys04=0;
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
				~cntSeqNtKeys05 = ~cntSeqNtKeys05 + 1;
				~cntSeqNtKeys05.switch(
					0,{},
					1, {IFSeqNtKeys.st05(0);},
					2, {IFSeqNtKeys.st05(1);},
					3, {IFSeqNtKeys.st05(2);},
					4, {IFSeqNtKeys.st05(3);},
					5, {IFSeqNtKeys.st05(4);},
					6, {IFSeqNtKeys.st05(5);},
					7, {IFSeqNtKeys.st05(6);},
					8, {IFSeqNtKeys.st05(7);},
					9, {IFSeqNtKeys.st05(8);},
					10, {IFSeqNtKeys.st05(9);},
					11,{IFSeqNtKeys.st05(10);},
					12,{IFSeqNtKeys.st05(11);
						~cntSeqNtKeys05=0;
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
				~cntSeqNtKeys06 = ~cntSeqNtKeys06 + 1;
				~cntSeqNtKeys06.switch(
					0,{},
					1, {IFSeqNtKeys.st06(0);},
					2, {IFSeqNtKeys.st06(1);},
					3, {IFSeqNtKeys.st06(2);},
					4, {IFSeqNtKeys.st06(3);},
					5, {IFSeqNtKeys.st06(4);},
					6, {IFSeqNtKeys.st06(5);},
					7, {IFSeqNtKeys.st06(6);},
					8, {IFSeqNtKeys.st06(7);},
					9, {IFSeqNtKeys.st06(8);},
					10, {IFSeqNtKeys.st06(9);},
					11,{IFSeqNtKeys.st06(10);},
					12,{IFSeqNtKeys.st06(11);
						~cntSeqNtKeys06=0;
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
				~cntSeqNtKeys07 = ~cntSeqNtKeys07 + 1;
				~cntSeqNtKeys07.switch(
					0,{},
					1, {IFSeqNtKeys.st07(0);},
					2, {IFSeqNtKeys.st07(1);},
					3, {IFSeqNtKeys.st07(2);},
					4, {IFSeqNtKeys.st07(3);},
					5, {IFSeqNtKeys.st07(4);},
					6, {IFSeqNtKeys.st07(5);},
					7, {IFSeqNtKeys.st07(6);},
					8, {IFSeqNtKeys.st07(7);},
					9, {IFSeqNtKeys.st07(8);},
					10, {IFSeqNtKeys.st07(9);},
					11,{IFSeqNtKeys.st07(10);},
					12,{IFSeqNtKeys.st07(11);
						~cntSeqNtKeys07=0;
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
				~cntSeqNtKeys08 = ~cntSeqNtKeys08 + 1;
				~cntSeqNtKeys08.switch(
					0,{},
					1, {IFSeqNtKeys.st08(0);},
					2, {IFSeqNtKeys.st08(1);},
					3, {IFSeqNtKeys.st08(2);},
					4, {IFSeqNtKeys.st08(3);},
					5, {IFSeqNtKeys.st08(4);},
					6, {IFSeqNtKeys.st08(5);},
					7, {IFSeqNtKeys.st08(6);},
					8, {IFSeqNtKeys.st08(7);},
					9, {IFSeqNtKeys.st08(8);},
					10, {IFSeqNtKeys.st08(9);},
					11,{IFSeqNtKeys.st08(10);},
					12,{IFSeqNtKeys.st08(11);
						~cntSeqNtKeys08=0;
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
				~cntSeqNtKeys09 = ~cntSeqNtKeys09 + 1;
				~cntSeqNtKeys09.switch(
					0,{},
					1, {IFSeqNtKeys.st09(0);},
					2, {IFSeqNtKeys.st09(1);},
					3, {IFSeqNtKeys.st09(2);},
					4, {IFSeqNtKeys.st09(3);},
					5, {IFSeqNtKeys.st09(4);},
					6, {IFSeqNtKeys.st09(5);},
					7, {IFSeqNtKeys.st09(6);},
					8, {IFSeqNtKeys.st09(7);},
					9, {IFSeqNtKeys.st09(8);},
					10, {IFSeqNtKeys.st09(9);},
					11,{IFSeqNtKeys.st09(10);},
					12,{IFSeqNtKeys.st09(11);
						~cntSeqNtKeys09=0;
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
				~cntSeqNtKeys10 = ~cntSeqNtKeys10 + 1;
				~cntSeqNtKeys10.switch(
					0,{},
					1, {IFSeqNtKeys.st10(0);},
					2, {IFSeqNtKeys.st10(1);},
					3, {IFSeqNtKeys.st10(2);},
					4, {IFSeqNtKeys.st10(3);},
					5, {IFSeqNtKeys.st10(4);},
					6, {IFSeqNtKeys.st10(5);},
					7, {IFSeqNtKeys.st10(6);},
					8, {IFSeqNtKeys.st10(7);},
					9, {IFSeqNtKeys.st10(8);},
					10, {IFSeqNtKeys.st10(9);},
					11,{IFSeqNtKeys.st10(10);},
					12,{IFSeqNtKeys.st10(11);
						~cntSeqNtKeys10=0;
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
				~cntSeqNtKeys11 = ~cntSeqNtKeys11 + 1;
				~cntSeqNtKeys11.switch(
					0,{},
					1, {IFSeqNtKeys.st11(0);},
					2, {IFSeqNtKeys.st11(1);},
					3, {IFSeqNtKeys.st11(2);},
					4, {IFSeqNtKeys.st11(3);},
					5, {IFSeqNtKeys.st11(4);},
					6, {IFSeqNtKeys.st11(5);},
					7, {IFSeqNtKeys.st11(6);},
					8, {IFSeqNtKeys.st11(7);},
					9, {IFSeqNtKeys.st11(8);},
					10, {IFSeqNtKeys.st11(9);},
					11,{IFSeqNtKeys.st11(10);},
					12,{IFSeqNtKeys.st11(11);
						~cntSeqNtKeys11=0;
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
				~cntSeqNtKeys12 = ~cntSeqNtKeys12 + 1;
				~cntSeqNtKeys12.switch(
					0,{},
					1, {IFSeqNtKeys.st12(0);},
					2, {IFSeqNtKeys.st12(1);},
					3, {IFSeqNtKeys.st12(2);},
					4, {IFSeqNtKeys.st12(3);},
					5, {IFSeqNtKeys.st12(4);},
					6, {IFSeqNtKeys.st12(5);},
					7, {IFSeqNtKeys.st12(6);},
					8, {IFSeqNtKeys.st12(7);},
					9, {IFSeqNtKeys.st12(8);},
					10, {IFSeqNtKeys.st12(9);},
					11,{IFSeqNtKeys.st12(10);},
					12,{IFSeqNtKeys.st12(11);
						~cntSeqNtKeys12=0;
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
				~cntSeqNtKeys13 = ~cntSeqNtKeys13 + 1;
				~cntSeqNtKeys13.switch(
					0,{},
					1, {IFSeqNtKeys.st13(0);},
					2, {IFSeqNtKeys.st13(1);},
					3, {IFSeqNtKeys.st13(2);},
					4, {IFSeqNtKeys.st13(3);},
					5, {IFSeqNtKeys.st13(4);},
					6, {IFSeqNtKeys.st13(5);},
					7, {IFSeqNtKeys.st13(6);},
					8, {IFSeqNtKeys.st13(7);},
					9, {IFSeqNtKeys.st13(8);},
					10, {IFSeqNtKeys.st13(9);},
					11,{IFSeqNtKeys.st13(10);},
					12,{IFSeqNtKeys.st13(11);
						~cntSeqNtKeys13=0;
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
				~cntSeqNtKeys14 = ~cntSeqNtKeys14 + 1;
				~cntSeqNtKeys14.switch(
					0,{},
					1, {IFSeqNtKeys.st14(0);},
					2, {IFSeqNtKeys.st14(1);},
					3, {IFSeqNtKeys.st14(2);},
					4, {IFSeqNtKeys.st14(3);},
					5, {IFSeqNtKeys.st14(4);},
					6, {IFSeqNtKeys.st14(5);},
					7, {IFSeqNtKeys.st14(6);},
					8, {IFSeqNtKeys.st14(7);},
					9, {IFSeqNtKeys.st14(8);},
					10, {IFSeqNtKeys.st14(9);},
					11,{IFSeqNtKeys.st14(10);},
					12,{IFSeqNtKeys.st14(11);
						~cntSeqNtKeys14=0;
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
				~cntSeqNtKeys15 = ~cntSeqNtKeys15 + 1;
				~cntSeqNtKeys15.switch(
					0,{},
					1, {IFSeqNtKeys.st15(0);},
					2, {IFSeqNtKeys.st15(1);},
					3, {IFSeqNtKeys.st15(2);},
					4, {IFSeqNtKeys.st15(3);},
					5, {IFSeqNtKeys.st15(4);},
					6, {IFSeqNtKeys.st15(5);},
					7, {IFSeqNtKeys.st15(6);},
					8, {IFSeqNtKeys.st15(7);},
					9, {IFSeqNtKeys.st15(8);},
					10, {IFSeqNtKeys.st15(9);},
					11,{IFSeqNtKeys.st15(10);},
					12,{IFSeqNtKeys.st15(11);
						~cntSeqNtKeys15=0;
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
				~cntSeqNtKeys16 = ~cntSeqNtKeys16 + 1;
				~cntSeqNtKeys16.switch(
					0,{},
					1, {IFSeqNtKeys.st16(0);},
					2, {IFSeqNtKeys.st16(1);},
					3, {IFSeqNtKeys.st16(2);},
					4, {IFSeqNtKeys.st16(3);},
					5, {IFSeqNtKeys.st16(4);},
					6, {IFSeqNtKeys.st16(5);},
					7, {IFSeqNtKeys.st16(6);},
					8, {IFSeqNtKeys.st16(7);},
					9, {IFSeqNtKeys.st16(8);},
					10, {IFSeqNtKeys.st16(9);},
					11,{IFSeqNtKeys.st16(10);},
					12,{IFSeqNtKeys.st16(11);
						~cntSeqNtKeys16=0;
					}
				)}
			);
			},
			'/ifSeq/5/16'
		);

	}//

	*st01 {|i=0|
		~seqNtKeys01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys01', i);
	}
	*st02 {|i=0|
		~seqNtKeys02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys02', i);
	}
	*st03 {|i=0|
		~seqNtKeys03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys03', i);
	}
	*st04 {|i=0|
		~seqNtKeys04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys04', i);
	}
	*st05 {|i=0|
		~seqNtKeys05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys05', i);
	}
	*st06 {|i=0|
		~seqNtKeys06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys06', i);
	}
	*st07 {|i=0|
		~seqNtKeys07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys07', i);
	}
	*st08 {|i=0|
		~seqNtKeys08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys08', i);
	}

	*st09 {|i=0|
		~seqNtKeys09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys09', i);
	}
	*st10 {|i=0|
		~seqNtKeys10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys10', i);
	}
	*st11 {|i=0|
		~seqNtKeys11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys11', i);
	}
	*st12 {|i=0|
		~seqNtKeys12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys12', i);
	}
	*st13 {|i=0|
		~seqNtKeys13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys13', i);
	}
	*st14 {|i=0|
		~seqNtKeys14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys14', i);
	}
	*st15 {|i=0|
		~seqNtKeys15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys15', i);
	}
	*st16 {|i=0|
		~seqNtKeys16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKeys16', i);
	}
	*stGrp {|i|

		IFSeqNtKeys.st01(i); IFSeqNtKeys.st02(i); IFSeqNtKeys.st03(i); IFSeqNtKeys.st04(i);
		IFSeqNtKeys.st05(i); IFSeqNtKeys.st06(i); IFSeqNtKeys.st07(i); IFSeqNtKeys.st08(i);
		IFSeqNtKeys.st09(i); IFSeqNtKeys.st10(i); IFSeqNtKeys.st11(i); IFSeqNtKeys.st12(i);
		IFSeqNtKeys.st13(i); IFSeqNtKeys.st14(i); IFSeqNtKeys.st15(i); IFSeqNtKeys.st16(i);
	}
}