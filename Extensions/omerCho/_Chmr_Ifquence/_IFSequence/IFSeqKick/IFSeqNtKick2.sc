IFSeqNtKick2 {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqNtKick2_01 = PatternProxy( Pseq([0], 1));
		~seqNtKick2_02 = PatternProxy( Pseq([0], 1));
		~seqNtKick2_03 = PatternProxy( Pseq([0], 1));
		~seqNtKick2_04 = PatternProxy( Pseq([0], 1));
		~seqNtKick2_05 = PatternProxy( Pseq([0], 1));
		~seqNtKick2_06 = PatternProxy( Pseq([0], 1));
		~seqNtKick2_07 = PatternProxy( Pseq([0], 1));
		~seqNtKick2_08 = PatternProxy( Pseq([0], 1));

		~seqNtKick2_09 = PatternProxy( Pseq([0], 1));
		~seqNtKick2_10 = PatternProxy( Pseq([0], 1));
		~seqNtKick2_11 = PatternProxy( Pseq([0], 1));
		~seqNtKick2_12 = PatternProxy( Pseq([0], 1));
		~seqNtKick2_13 = PatternProxy( Pseq([0], 1));
		~seqNtKick2_14 = PatternProxy( Pseq([0], 1));
		~seqNtKick2_15 = PatternProxy( Pseq([0], 1));
		~seqNtKick2_16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqNtUpKick2_2_01=0;
		~cntSeqNtRandKick2_2_01=0;

		~cntSeqNtKick2_01=0;
		~cntSeqNtKick2_02=0;
		~cntSeqNtKick2_03=0;
		~cntSeqNtKick2_04=0;
		~cntSeqNtKick2_05=0;
		~cntSeqNtKick2_06=0;
		~cntSeqNtKick2_07=0;
		~cntSeqNtKick2_08=0;

		~cntSeqNtKick2_09=0;
		~cntSeqNtKick2_10=0;
		~cntSeqNtKick2_11=0;
		~cntSeqNtKick2_12=0;
		~cntSeqNtKick2_13=0;
		~cntSeqNtKick2_14=0;
		~cntSeqNtKick2_15=0;
		~cntSeqNtKick2_16=0;
	}
	*freeOn {
		~seqFreeKick2But.free;
		~seqFreeKick2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqNtKick2.stGrp(0);
				});
			},
			'/seqFreeKick2'
		);

	}

	*upOn {
		~ifSeqUpKick2But.free;
		~ifSeqUpKick2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtUpKick2_01 = ~cntSeqNtUpKick2_01 + 1;
				~cntSeqNtUpKick2_01.switch(
					0,{},
					1,{IFSeqNtKick2.stGrp(0);},
					2,{IFSeqNtKick2.stGrp(1);},
					3,{IFSeqNtKick2.stGrp(2);},
					4,{IFSeqNtKick2.stGrp(3);},
					5,{IFSeqNtKick2.stGrp(4);},
					6,{IFSeqNtKick2.stGrp(5);},
					7,{IFSeqNtKick2.stGrp(6);},
					8,{IFSeqNtKick2.stGrp(7);},
					9,{IFSeqNtKick2.stGrp(8);},
					10,{IFSeqNtKick2.stGrp(9);},
					11,{IFSeqNtKick2.stGrp(10);},
					12,{IFSeqNtKick2.stGrp(11);
						~cntSeqNtUpKick2_01=0;
					}
				)}
			);
			},
			'/seqUpKick2'
		);
	}

	*randOn {
		~ifSeqRandKick2But.free;
		~ifSeqRandKick2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtRandKick2_01 = ~cntSeqNtRandKick2_01 + 1;
				~cntSeqNtRandKick2_01.switch(
					0,{},
					1,{
						IFSeqNtKick2.st01((0..11).choose);
						IFSeqNtKick2.st02((0..11).choose);
						IFSeqNtKick2.st03((0..11).choose);
						IFSeqNtKick2.st04((0..11).choose);
						IFSeqNtKick2.st05((0..11).choose);
						IFSeqNtKick2.st06((0..11).choose);
						IFSeqNtKick2.st07((0..11).choose);
						IFSeqNtKick2.st08((0..11).choose);

						IFSeqNtKick2.st09((0..11).choose);
						IFSeqNtKick2.st10((0..11).choose);
						IFSeqNtKick2.st11((0..11).choose);
						IFSeqNtKick2.st12((0..11).choose);
						IFSeqNtKick2.st13((0..11).choose);
						IFSeqNtKick2.st14((0..11).choose);
						IFSeqNtKick2.st15((0..11).choose);
						IFSeqNtKick2.st16((0..11).choose);
						~cntSeqNtRandKick2_01=0;
					}
				)}
			);
			},
			'/seqRandKick2'
		);
	}

	*on { // Shift NtAVE
		IFSeqNtKick2.randOn;
		IFSeqNtKick2.upOn;
		IFSeqNtKick2.freeOn;

		~ifSeqKick2But01.free;
		~ifSeqKick2But01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_01 = ~cntSeqNtKick2_01 + 1;
				~cntSeqNtKick2_01.switch(
					0,{},
					1, {IFSeqNtKick2.st01(0);},
					2, {IFSeqNtKick2.st01(1);},
					3, {IFSeqNtKick2.st01(2);},
					4, {IFSeqNtKick2.st01(3);},
					5, {IFSeqNtKick2.st01(4);},
					6, {IFSeqNtKick2.st01(5);},
					7, {IFSeqNtKick2.st01(6);},
					8, {IFSeqNtKick2.st01(7);},
					9, {IFSeqNtKick2.st01(8);},
					10,{IFSeqNtKick2.st01(9);},
					11,{IFSeqNtKick2.st01(10);},
					12,{IFSeqNtKick2.st01(11);
						~cntSeqNtKick2_01=0;
					}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqKick2But02.free;
		~ifSeqKick2But02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_02 = ~cntSeqNtKick2_02 + 1;
				~cntSeqNtKick2_02.switch(
					0,{},
					1, {IFSeqNtKick2.st02(0);},
					2, {IFSeqNtKick2.st02(1);},
					3, {IFSeqNtKick2.st02(2);},
					4, {IFSeqNtKick2.st02(3);},
					5, {IFSeqNtKick2.st02(4);},
					6, {IFSeqNtKick2.st02(5);},
					7, {IFSeqNtKick2.st02(6);},
					8, {IFSeqNtKick2.st02(7);},
					9, {IFSeqNtKick2.st02(8);},
					10, {IFSeqNtKick2.st02(9);},
					11,{IFSeqNtKick2.st02(10);},
					12,{IFSeqNtKick2.st02(11);
						~cntSeqNtKick2_02=0;
					}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqKick2But03.free;
		~ifSeqKick2But03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_03 = ~cntSeqNtKick2_03 + 1;
				~cntSeqNtKick2_03.switch(
					0,{},
					1, {IFSeqNtKick2.st03(0);},
					2, {IFSeqNtKick2.st03(1);},
					3, {IFSeqNtKick2.st03(2);},
					4, {IFSeqNtKick2.st03(3);},
					5, {IFSeqNtKick2.st03(4);},
					6, {IFSeqNtKick2.st03(5);},
					7, {IFSeqNtKick2.st03(6);},
					8, {IFSeqNtKick2.st03(7);},
					9, {IFSeqNtKick2.st03(8);},
					10, {IFSeqNtKick2.st03(9);},
					11,{IFSeqNtKick2.st03(10);},
					12,{IFSeqNtKick2.st03(11);
						~cntSeqNtKick2_03=0;
					}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqKick2But04.free;
		~ifSeqKick2But04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_04 = ~cntSeqNtKick2_04 + 1;
				~cntSeqNtKick2_04.switch(
					0,{},
					1, {IFSeqNtKick2.st04(0);},
					2, {IFSeqNtKick2.st04(1);},
					3, {IFSeqNtKick2.st04(2);},
					4, {IFSeqNtKick2.st04(3);},
					5, {IFSeqNtKick2.st04(4);},
					6, {IFSeqNtKick2.st04(5);},
					7, {IFSeqNtKick2.st04(6);},
					8, {IFSeqNtKick2.st04(7);},
					9, {IFSeqNtKick2.st04(8);},
					10, {IFSeqNtKick2.st04(9);},
					11,{IFSeqNtKick2.st04(10);},
					12,{IFSeqNtKick2.st04(11);
						~cntSeqNtKick2_04=0;
					}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqKick2But05.free;
		~ifSeqKick2But05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_05 = ~cntSeqNtKick2_05 + 1;
				~cntSeqNtKick2_05.switch(
					0,{},
					1, {IFSeqNtKick2.st05(0);},
					2, {IFSeqNtKick2.st05(1);},
					3, {IFSeqNtKick2.st05(2);},
					4, {IFSeqNtKick2.st05(3);},
					5, {IFSeqNtKick2.st05(4);},
					6, {IFSeqNtKick2.st05(5);},
					7, {IFSeqNtKick2.st05(6);},
					8, {IFSeqNtKick2.st05(7);},
					9, {IFSeqNtKick2.st05(8);},
					10, {IFSeqNtKick2.st05(9);},
					11,{IFSeqNtKick2.st05(10);},
					12,{IFSeqNtKick2.st05(11);
						~cntSeqNtKick2_05=0;
					}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqKick2But06.free;
		~ifSeqKick2But06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_06 = ~cntSeqNtKick2_06 + 1;
				~cntSeqNtKick2_06.switch(
					0,{},
					1, {IFSeqNtKick2.st06(0);},
					2, {IFSeqNtKick2.st06(1);},
					3, {IFSeqNtKick2.st06(2);},
					4, {IFSeqNtKick2.st06(3);},
					5, {IFSeqNtKick2.st06(4);},
					6, {IFSeqNtKick2.st06(5);},
					7, {IFSeqNtKick2.st06(6);},
					8, {IFSeqNtKick2.st06(7);},
					9, {IFSeqNtKick2.st06(8);},
					10, {IFSeqNtKick2.st06(9);},
					11,{IFSeqNtKick2.st06(10);},
					12,{IFSeqNtKick2.st06(11);
						~cntSeqNtKick2_06=0;
					}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqKick2But07.free;
		~ifSeqKick2But07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_07 = ~cntSeqNtKick2_07 + 1;
				~cntSeqNtKick2_07.switch(
					0,{},
					1, {IFSeqNtKick2.st07(0);},
					2, {IFSeqNtKick2.st07(1);},
					3, {IFSeqNtKick2.st07(2);},
					4, {IFSeqNtKick2.st07(3);},
					5, {IFSeqNtKick2.st07(4);},
					6, {IFSeqNtKick2.st07(5);},
					7, {IFSeqNtKick2.st07(6);},
					8, {IFSeqNtKick2.st07(7);},
					9, {IFSeqNtKick2.st07(8);},
					10, {IFSeqNtKick2.st07(9);},
					11,{IFSeqNtKick2.st07(10);},
					12,{IFSeqNtKick2.st07(11);
						~cntSeqNtKick2_07=0;
					}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqKick2But08.free;
		~ifSeqKick2But08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_08 = ~cntSeqNtKick2_08 + 1;
				~cntSeqNtKick2_08.switch(
					0,{},
					1, {IFSeqNtKick2.st08(0);},
					2, {IFSeqNtKick2.st08(1);},
					3, {IFSeqNtKick2.st08(2);},
					4, {IFSeqNtKick2.st08(3);},
					5, {IFSeqNtKick2.st08(4);},
					6, {IFSeqNtKick2.st08(5);},
					7, {IFSeqNtKick2.st08(6);},
					8, {IFSeqNtKick2.st08(7);},
					9, {IFSeqNtKick2.st08(8);},
					10, {IFSeqNtKick2.st08(9);},
					11,{IFSeqNtKick2.st08(10);},
					12,{IFSeqNtKick2.st08(11);
						~cntSeqNtKick2_08=0;
					}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqKick2But09.free;
		~ifSeqKick2But09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_09 = ~cntSeqNtKick2_09 + 1;
				~cntSeqNtKick2_09.switch(
					0,{},
					1, {IFSeqNtKick2.st09(0);},
					2, {IFSeqNtKick2.st09(1);},
					3, {IFSeqNtKick2.st09(2);},
					4, {IFSeqNtKick2.st09(3);},
					5, {IFSeqNtKick2.st09(4);},
					6, {IFSeqNtKick2.st09(5);},
					7, {IFSeqNtKick2.st09(6);},
					8, {IFSeqNtKick2.st09(7);},
					9, {IFSeqNtKick2.st09(8);},
					10, {IFSeqNtKick2.st09(9);},
					11,{IFSeqNtKick2.st09(10);},
					12,{IFSeqNtKick2.st09(11);
						~cntSeqNtKick2_09=0;
					}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqKick2But10.free;
		~ifSeqKick2But10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_10 = ~cntSeqNtKick2_10 + 1;
				~cntSeqNtKick2_10.switch(
					0,{},
					1, {IFSeqNtKick2.st10(0);},
					2, {IFSeqNtKick2.st10(1);},
					3, {IFSeqNtKick2.st10(2);},
					4, {IFSeqNtKick2.st10(3);},
					5, {IFSeqNtKick2.st10(4);},
					6, {IFSeqNtKick2.st10(5);},
					7, {IFSeqNtKick2.st10(6);},
					8, {IFSeqNtKick2.st10(7);},
					9, {IFSeqNtKick2.st10(8);},
					10, {IFSeqNtKick2.st10(9);},
					11,{IFSeqNtKick2.st10(10);},
					12,{IFSeqNtKick2.st10(11);
						~cntSeqNtKick2_10=0;
					}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqKick2But11.free;
		~ifSeqKick2But11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_11 = ~cntSeqNtKick2_11 + 1;
				~cntSeqNtKick2_11.switch(
					0,{},
					1, {IFSeqNtKick2.st11(0);},
					2, {IFSeqNtKick2.st11(1);},
					3, {IFSeqNtKick2.st11(2);},
					4, {IFSeqNtKick2.st11(3);},
					5, {IFSeqNtKick2.st11(4);},
					6, {IFSeqNtKick2.st11(5);},
					7, {IFSeqNtKick2.st11(6);},
					8, {IFSeqNtKick2.st11(7);},
					9, {IFSeqNtKick2.st11(8);},
					10, {IFSeqNtKick2.st11(9);},
					11,{IFSeqNtKick2.st11(10);},
					12,{IFSeqNtKick2.st11(11);
						~cntSeqNtKick2_11=0;
					}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqKick2But12.free;
		~ifSeqKick2But12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_12 = ~cntSeqNtKick2_12 + 1;
				~cntSeqNtKick2_12.switch(
					0,{},
					1, {IFSeqNtKick2.st12(0);},
					2, {IFSeqNtKick2.st12(1);},
					3, {IFSeqNtKick2.st12(2);},
					4, {IFSeqNtKick2.st12(3);},
					5, {IFSeqNtKick2.st12(4);},
					6, {IFSeqNtKick2.st12(5);},
					7, {IFSeqNtKick2.st12(6);},
					8, {IFSeqNtKick2.st12(7);},
					9, {IFSeqNtKick2.st12(8);},
					10, {IFSeqNtKick2.st12(9);},
					11,{IFSeqNtKick2.st12(10);},
					12,{IFSeqNtKick2.st12(11);
						~cntSeqNtKick2_12=0;
					}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqKick2But13.free;
		~ifSeqKick2But13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_13 = ~cntSeqNtKick2_13 + 1;
				~cntSeqNtKick2_13.switch(
					0,{},
					1, {IFSeqNtKick2.st13(0);},
					2, {IFSeqNtKick2.st13(1);},
					3, {IFSeqNtKick2.st13(2);},
					4, {IFSeqNtKick2.st13(3);},
					5, {IFSeqNtKick2.st13(4);},
					6, {IFSeqNtKick2.st13(5);},
					7, {IFSeqNtKick2.st13(6);},
					8, {IFSeqNtKick2.st13(7);},
					9, {IFSeqNtKick2.st13(8);},
					10, {IFSeqNtKick2.st13(9);},
					11,{IFSeqNtKick2.st13(10);},
					12,{IFSeqNtKick2.st13(11);
						~cntSeqNtKick2_13=0;
					}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqKick2But14.free;
		~ifSeqKick2But14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_14 = ~cntSeqNtKick2_14 + 1;
				~cntSeqNtKick2_14.switch(
					0,{},
					1, {IFSeqNtKick2.st14(0);},
					2, {IFSeqNtKick2.st14(1);},
					3, {IFSeqNtKick2.st14(2);},
					4, {IFSeqNtKick2.st14(3);},
					5, {IFSeqNtKick2.st14(4);},
					6, {IFSeqNtKick2.st14(5);},
					7, {IFSeqNtKick2.st14(6);},
					8, {IFSeqNtKick2.st14(7);},
					9, {IFSeqNtKick2.st14(8);},
					10, {IFSeqNtKick2.st14(9);},
					11,{IFSeqNtKick2.st14(10);},
					12,{IFSeqNtKick2.st14(11);
						~cntSeqNtKick2_14=0;
					}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqKick2But15.free;
		~ifSeqKick2But15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_15 = ~cntSeqNtKick2_15 + 1;
				~cntSeqNtKick2_15.switch(
					0,{},
					1, {IFSeqNtKick2.st15(0);},
					2, {IFSeqNtKick2.st15(1);},
					3, {IFSeqNtKick2.st15(2);},
					4, {IFSeqNtKick2.st15(3);},
					5, {IFSeqNtKick2.st15(4);},
					6, {IFSeqNtKick2.st15(5);},
					7, {IFSeqNtKick2.st15(6);},
					8, {IFSeqNtKick2.st15(7);},
					9, {IFSeqNtKick2.st15(8);},
					10, {IFSeqNtKick2.st15(9);},
					11,{IFSeqNtKick2.st15(10);},
					12,{IFSeqNtKick2.st15(11);
						~cntSeqNtKick2_15=0;
					}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqKick2But16.free;
		~ifSeqKick2But16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick2_16 = ~cntSeqNtKick2_16 + 1;
				~cntSeqNtKick2_16.switch(
					0,{},
					1, {IFSeqNtKick2.st16(0);},
					2, {IFSeqNtKick2.st16(1);},
					3, {IFSeqNtKick2.st16(2);},
					4, {IFSeqNtKick2.st16(3);},
					5, {IFSeqNtKick2.st16(4);},
					6, {IFSeqNtKick2.st16(5);},
					7, {IFSeqNtKick2.st16(6);},
					8, {IFSeqNtKick2.st16(7);},
					9, {IFSeqNtKick2.st16(8);},
					10, {IFSeqNtKick2.st16(9);},
					11,{IFSeqNtKick2.st16(10);},
					12,{IFSeqNtKick2.st16(11);
						~cntSeqNtKick2_16=0;
					}
				)}
			);
			},
			'/ifSeq/2/16'
		);

	}//

	*st01 {|i=0|
		~seqNtKick2_01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_01', i);
	}
	*st02 {|i=0|
		~seqNtKick2_02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_02', i);
	}
	*st03 {|i=0|
		~seqNtKick2_03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_03', i);
	}
	*st04 {|i=0|
		~seqNtKick2_04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_04', i);
	}
	*st05 {|i=0|
		~seqNtKick2_05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_05', i);
	}
	*st06 {|i=0|
		~seqNtKick2_06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_06', i);
	}
	*st07 {|i=0|
		~seqNtKick2_07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_07', i);
	}
	*st08 {|i=0|
		~seqNtKick2_08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_08', i);
	}

	*st09 {|i=0|
		~seqNtKick2_09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_09', i);
	}
	*st10 {|i=0|
		~seqNtKick2_10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_10', i);
	}
	*st11 {|i=0|
		~seqNtKick2_11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_11', i);
	}
	*st12 {|i=0|
		~seqNtKick2_12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_12', i);
	}
	*st13 {|i=0|
		~seqNtKick2_13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_13', i);
	}
	*st14 {|i=0|
		~seqNtKick2_14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_14', i);
	}
	*st15 {|i=0|
		~seqNtKick2_15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_15', i);
	}
	*st16 {|i=0|
		~seqNtKick2_16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick2_16', i);
	}
	*stGrp {|i|

		IFSeqNtKick2.st01(i); IFSeqNtKick2.st02(i); IFSeqNtKick2.st03(i); IFSeqNtKick2.st04(i);
		IFSeqNtKick2.st05(i); IFSeqNtKick2.st06(i); IFSeqNtKick2.st07(i); IFSeqNtKick2.st08(i);
		IFSeqNtKick2.st09(i); IFSeqNtKick2.st10(i); IFSeqNtKick2.st11(i); IFSeqNtKick2.st12(i);
		IFSeqNtKick2.st13(i); IFSeqNtKick2.st14(i); IFSeqNtKick2.st15(i); IFSeqNtKick2.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqNtKick2.st01(s01); IFSeqNtKick2.st02(s02); IFSeqNtKick2.st03(s03); IFSeqNtKick2.st04(s04);
		IFSeqNtKick2.st05(s05); IFSeqNtKick2.st06(s06); IFSeqNtKick2.st07(s07); IFSeqNtKick2.st08(s08);
		IFSeqNtKick2.st09(s09); IFSeqNtKick2.st10(s10); IFSeqNtKick2.st11(s11); IFSeqNtKick2.st12(s12);
		IFSeqNtKick2.st13(s13); IFSeqNtKick2.st14(s14); IFSeqNtKick2.st15(s15); IFSeqNtKick2.st16(s16);
	}
}