IFSeqNtHat2 {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqNtHat2_01 = PatternProxy( Pseq([0], 1));
		~seqNtHat2_02 = PatternProxy( Pseq([0], 1));
		~seqNtHat2_03 = PatternProxy( Pseq([0], 1));
		~seqNtHat2_04 = PatternProxy( Pseq([0], 1));
		~seqNtHat2_05 = PatternProxy( Pseq([0], 1));
		~seqNtHat2_06 = PatternProxy( Pseq([0], 1));
		~seqNtHat2_07 = PatternProxy( Pseq([0], 1));
		~seqNtHat2_08 = PatternProxy( Pseq([0], 1));

		~seqNtHat2_09 = PatternProxy( Pseq([0], 1));
		~seqNtHat2_10 = PatternProxy( Pseq([0], 1));
		~seqNtHat2_11 = PatternProxy( Pseq([0], 1));
		~seqNtHat2_12 = PatternProxy( Pseq([0], 1));
		~seqNtHat2_13 = PatternProxy( Pseq([0], 1));
		~seqNtHat2_14 = PatternProxy( Pseq([0], 1));
		~seqNtHat2_15 = PatternProxy( Pseq([0], 1));
		~seqNtHat2_16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqNtUpHat2_01=0;
		~cntSeqNtRandHat2_01=0;

		~cntSeqNtHat2_01=0;
		~cntSeqNtHat2_02=0;
		~cntSeqNtHat2_03=0;
		~cntSeqNtHat2_04=0;
		~cntSeqNtHat2_05=0;
		~cntSeqNtHat2_06=0;
		~cntSeqNtHat2_07=0;
		~cntSeqNtHat2_08=0;

		~cntSeqNtHat2_09=0;
		~cntSeqNtHat2_10=0;
		~cntSeqNtHat2_11=0;
		~cntSeqNtHat2_12=0;
		~cntSeqNtHat2_13=0;
		~cntSeqNtHat2_14=0;
		~cntSeqNtHat2_15=0;
		~cntSeqNtHat2_16=0;
	}
	*freeOn {
		~seqFreeHat2But.free;
		~seqFreeHat2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqNtHat2.stGrp(0);
				});
			},
			'/seqFreeHat2'
		);

	}

	*upOn {
		~ifSeqUpHat2But.free;
		~ifSeqUpHat2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtUpHat01 = ~cntSeqNtUpHat01 + 1;
				~cntSeqNtUpHat01.switch(
					0,{},
					1,{IFSeqNtHat2.stGrp(0);},
					2,{IFSeqNtHat2.stGrp(1);},
					3,{IFSeqNtHat2.stGrp(2);},
					4,{IFSeqNtHat2.stGrp(3);},
					5,{IFSeqNtHat2.stGrp(4);},
					6,{IFSeqNtHat2.stGrp(5);},
					7,{IFSeqNtHat2.stGrp(6);},
					8,{IFSeqNtHat2.stGrp(7);},
					9,{IFSeqNtHat2.stGrp(8);},
					10,{IFSeqNtHat2.stGrp(9);},
					11,{IFSeqNtHat2.stGrp(10);},
					12,{IFSeqNtHat2.stGrp(11);
						~cntSeqNtUpHat01=0;
					}
				)}
			);
			},
			'/seqUpHat2'
		);
	}

	*randOn {
		~ifSeqRandHatBut.free;
		~ifSeqRandHatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtRandHat01 = ~cntSeqNtRandHat01 + 1;
				~cntSeqNtRandHat01.switch(
					0,{},
					1,{
						IFSeqNtHat2.st01((0..11).choose);
						IFSeqNtHat2.st02((0..11).choose);
						IFSeqNtHat2.st03((0..11).choose);
						IFSeqNtHat2.st04((0..11).choose);
						IFSeqNtHat2.st05((0..11).choose);
						IFSeqNtHat2.st06((0..11).choose);
						IFSeqNtHat2.st07((0..11).choose);
						IFSeqNtHat2.st08((0..11).choose);

						IFSeqNtHat2.st09((0..11).choose);
						IFSeqNtHat2.st10((0..11).choose);
						IFSeqNtHat2.st11((0..11).choose);
						IFSeqNtHat2.st12((0..11).choose);
						IFSeqNtHat2.st13((0..11).choose);
						IFSeqNtHat2.st14((0..11).choose);
						IFSeqNtHat2.st15((0..11).choose);
						IFSeqNtHat2.st16((0..11).choose);
						~cntSeqNtRandHat01=0;
					}
				)}
			);
			},
			'/seqRandHat2'
		);
	}

	*on { // Shift NtAVE
		IFSeqNtHat2.randOn;
		IFSeqNtHat2.upOn;
		IFSeqNtHat2.freeOn;

		~ifSeqHat2But01.free;
		~ifSeqHat2But01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_01 = ~cntSeqNtHat2_01 + 1;
				~cntSeqNtHat2_01.switch(
					0,{},
					1, {IFSeqNtHat2.st01(0);},
					2, {IFSeqNtHat2.st01(1);},
					3, {IFSeqNtHat2.st01(2);},
					4, {IFSeqNtHat2.st01(3);},
					5, {IFSeqNtHat2.st01(4);},
					6, {IFSeqNtHat2.st01(5);},
					7, {IFSeqNtHat2.st01(6);},
					8, {IFSeqNtHat2.st01(7);},
					9, {IFSeqNtHat2.st01(8);},
					10,{IFSeqNtHat2.st01(9);},
					11,{IFSeqNtHat2.st01(10);},
					12,{IFSeqNtHat2.st01(11);
						~cntSeqNtHat2_01=0;
					}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqHat2But02.free;
		~ifSeqHat2But02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_02 = ~cntSeqNtHat2_02 + 1;
				~cntSeqNtHat2_02.switch(
					0,{},
					1, {IFSeqNtHat2.st02(0);},
					2, {IFSeqNtHat2.st02(1);},
					3, {IFSeqNtHat2.st02(2);},
					4, {IFSeqNtHat2.st02(3);},
					5, {IFSeqNtHat2.st02(4);},
					6, {IFSeqNtHat2.st02(5);},
					7, {IFSeqNtHat2.st02(6);},
					8, {IFSeqNtHat2.st02(7);},
					9, {IFSeqNtHat2.st02(8);},
					10, {IFSeqNtHat2.st02(9);},
					11,{IFSeqNtHat2.st02(10);},
					12,{IFSeqNtHat2.st02(11);
						~cntSeqNtHat2_02=0;
					}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqHat2But03.free;
		~ifSeqHat2But03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_03 = ~cntSeqNtHat2_03 + 1;
				~cntSeqNtHat2_03.switch(
					0,{},
					1, {IFSeqNtHat2.st03(0);},
					2, {IFSeqNtHat2.st03(1);},
					3, {IFSeqNtHat2.st03(2);},
					4, {IFSeqNtHat2.st03(3);},
					5, {IFSeqNtHat2.st03(4);},
					6, {IFSeqNtHat2.st03(5);},
					7, {IFSeqNtHat2.st03(6);},
					8, {IFSeqNtHat2.st03(7);},
					9, {IFSeqNtHat2.st03(8);},
					10, {IFSeqNtHat2.st03(9);},
					11,{IFSeqNtHat2.st03(10);},
					12,{IFSeqNtHat2.st03(11);
						~cntSeqNtHat2_03=0;
					}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqHat2But04.free;
		~ifSeqHat2But04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_04 = ~cntSeqNtHat2_04 + 1;
				~cntSeqNtHat2_04.switch(
					0,{},
					1, {IFSeqNtHat2.st04(0);},
					2, {IFSeqNtHat2.st04(1);},
					3, {IFSeqNtHat2.st04(2);},
					4, {IFSeqNtHat2.st04(3);},
					5, {IFSeqNtHat2.st04(4);},
					6, {IFSeqNtHat2.st04(5);},
					7, {IFSeqNtHat2.st04(6);},
					8, {IFSeqNtHat2.st04(7);},
					9, {IFSeqNtHat2.st04(8);},
					10, {IFSeqNtHat2.st04(9);},
					11,{IFSeqNtHat2.st04(10);},
					12,{IFSeqNtHat2.st04(11);
						~cntSeqNtHat2_04=0;
					}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqHat2But05.free;
		~ifSeqHat2But05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_05 = ~cntSeqNtHat2_05 + 1;
				~cntSeqNtHat2_05.switch(
					0,{},
					1, {IFSeqNtHat2.st05(0);},
					2, {IFSeqNtHat2.st05(1);},
					3, {IFSeqNtHat2.st05(2);},
					4, {IFSeqNtHat2.st05(3);},
					5, {IFSeqNtHat2.st05(4);},
					6, {IFSeqNtHat2.st05(5);},
					7, {IFSeqNtHat2.st05(6);},
					8, {IFSeqNtHat2.st05(7);},
					9, {IFSeqNtHat2.st05(8);},
					10, {IFSeqNtHat2.st05(9);},
					11,{IFSeqNtHat2.st05(10);},
					12,{IFSeqNtHat2.st05(11);
						~cntSeqNtHat2_05=0;
					}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqHat2But06.free;
		~ifSeqHat2But06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_06 = ~cntSeqNtHat2_06 + 1;
				~cntSeqNtHat2_06.switch(
					0,{},
					1, {IFSeqNtHat2.st06(0);},
					2, {IFSeqNtHat2.st06(1);},
					3, {IFSeqNtHat2.st06(2);},
					4, {IFSeqNtHat2.st06(3);},
					5, {IFSeqNtHat2.st06(4);},
					6, {IFSeqNtHat2.st06(5);},
					7, {IFSeqNtHat2.st06(6);},
					8, {IFSeqNtHat2.st06(7);},
					9, {IFSeqNtHat2.st06(8);},
					10, {IFSeqNtHat2.st06(9);},
					11,{IFSeqNtHat2.st06(10);},
					12,{IFSeqNtHat2.st06(11);
						~cntSeqNtHat2_06=0;
					}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqHat2But07.free;
		~ifSeqHat2But07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_07 = ~cntSeqNtHat2_07 + 1;
				~cntSeqNtHat2_07.switch(
					0,{},
					1, {IFSeqNtHat2.st07(0);},
					2, {IFSeqNtHat2.st07(1);},
					3, {IFSeqNtHat2.st07(2);},
					4, {IFSeqNtHat2.st07(3);},
					5, {IFSeqNtHat2.st07(4);},
					6, {IFSeqNtHat2.st07(5);},
					7, {IFSeqNtHat2.st07(6);},
					8, {IFSeqNtHat2.st07(7);},
					9, {IFSeqNtHat2.st07(8);},
					10, {IFSeqNtHat2.st07(9);},
					11,{IFSeqNtHat2.st07(10);},
					12,{IFSeqNtHat2.st07(11);
						~cntSeqNtHat2_07=0;
					}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqHat2But08.free;
		~ifSeqHat2But08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_08 = ~cntSeqNtHat2_08 + 1;
				~cntSeqNtHat2_08.switch(
					0,{},
					1, {IFSeqNtHat2.st08(0);},
					2, {IFSeqNtHat2.st08(1);},
					3, {IFSeqNtHat2.st08(2);},
					4, {IFSeqNtHat2.st08(3);},
					5, {IFSeqNtHat2.st08(4);},
					6, {IFSeqNtHat2.st08(5);},
					7, {IFSeqNtHat2.st08(6);},
					8, {IFSeqNtHat2.st08(7);},
					9, {IFSeqNtHat2.st08(8);},
					10, {IFSeqNtHat2.st08(9);},
					11,{IFSeqNtHat2.st08(10);},
					12,{IFSeqNtHat2.st08(11);
						~cntSeqNtHat2_08=0;
					}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqHat2But09.free;
		~ifSeqHat2But09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_09 = ~cntSeqNtHat2_09 + 1;
				~cntSeqNtHat2_09.switch(
					0,{},
					1, {IFSeqNtHat2.st09(0);},
					2, {IFSeqNtHat2.st09(1);},
					3, {IFSeqNtHat2.st09(2);},
					4, {IFSeqNtHat2.st09(3);},
					5, {IFSeqNtHat2.st09(4);},
					6, {IFSeqNtHat2.st09(5);},
					7, {IFSeqNtHat2.st09(6);},
					8, {IFSeqNtHat2.st09(7);},
					9, {IFSeqNtHat2.st09(8);},
					10, {IFSeqNtHat2.st09(9);},
					11,{IFSeqNtHat2.st09(10);},
					12,{IFSeqNtHat2.st09(11);
						~cntSeqNtHat2_09=0;
					}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqHat2But10.free;
		~ifSeqHat2But10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_10 = ~cntSeqNtHat2_10 + 1;
				~cntSeqNtHat2_10.switch(
					0,{},
					1, {IFSeqNtHat2.st10(0);},
					2, {IFSeqNtHat2.st10(1);},
					3, {IFSeqNtHat2.st10(2);},
					4, {IFSeqNtHat2.st10(3);},
					5, {IFSeqNtHat2.st10(4);},
					6, {IFSeqNtHat2.st10(5);},
					7, {IFSeqNtHat2.st10(6);},
					8, {IFSeqNtHat2.st10(7);},
					9, {IFSeqNtHat2.st10(8);},
					10, {IFSeqNtHat2.st10(9);},
					11,{IFSeqNtHat2.st10(10);},
					12,{IFSeqNtHat2.st10(11);
						~cntSeqNtHat2_10=0;
					}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqHat2But11.free;
		~ifSeqHat2But11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_11 = ~cntSeqNtHat2_11 + 1;
				~cntSeqNtHat2_11.switch(
					0,{},
					1, {IFSeqNtHat2.st11(0);},
					2, {IFSeqNtHat2.st11(1);},
					3, {IFSeqNtHat2.st11(2);},
					4, {IFSeqNtHat2.st11(3);},
					5, {IFSeqNtHat2.st11(4);},
					6, {IFSeqNtHat2.st11(5);},
					7, {IFSeqNtHat2.st11(6);},
					8, {IFSeqNtHat2.st11(7);},
					9, {IFSeqNtHat2.st11(8);},
					10, {IFSeqNtHat2.st11(9);},
					11,{IFSeqNtHat2.st11(10);},
					12,{IFSeqNtHat2.st11(11);
						~cntSeqNtHat2_11=0;
					}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqHat2But12.free;
		~ifSeqHat2But12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_12 = ~cntSeqNtHat2_12 + 1;
				~cntSeqNtHat2_12.switch(
					0,{},
					1, {IFSeqNtHat2.st12(0);},
					2, {IFSeqNtHat2.st12(1);},
					3, {IFSeqNtHat2.st12(2);},
					4, {IFSeqNtHat2.st12(3);},
					5, {IFSeqNtHat2.st12(4);},
					6, {IFSeqNtHat2.st12(5);},
					7, {IFSeqNtHat2.st12(6);},
					8, {IFSeqNtHat2.st12(7);},
					9, {IFSeqNtHat2.st12(8);},
					10, {IFSeqNtHat2.st12(9);},
					11,{IFSeqNtHat2.st12(10);},
					12,{IFSeqNtHat2.st12(11);
						~cntSeqNtHat2_12=0;
					}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqHat2But13.free;
		~ifSeqHat2But13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_13 = ~cntSeqNtHat2_13 + 1;
				~cntSeqNtHat2_13.switch(
					0,{},
					1, {IFSeqNtHat2.st13(0);},
					2, {IFSeqNtHat2.st13(1);},
					3, {IFSeqNtHat2.st13(2);},
					4, {IFSeqNtHat2.st13(3);},
					5, {IFSeqNtHat2.st13(4);},
					6, {IFSeqNtHat2.st13(5);},
					7, {IFSeqNtHat2.st13(6);},
					8, {IFSeqNtHat2.st13(7);},
					9, {IFSeqNtHat2.st13(8);},
					10, {IFSeqNtHat2.st13(9);},
					11,{IFSeqNtHat2.st13(10);},
					12,{IFSeqNtHat2.st13(11);
						~cntSeqNtHat2_13=0;
					}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqHat2But14.free;
		~ifSeqHat2But14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_14 = ~cntSeqNtHat2_14 + 1;
				~cntSeqNtHat2_14.switch(
					0,{},
					1, {IFSeqNtHat2.st14(0);},
					2, {IFSeqNtHat2.st14(1);},
					3, {IFSeqNtHat2.st14(2);},
					4, {IFSeqNtHat2.st14(3);},
					5, {IFSeqNtHat2.st14(4);},
					6, {IFSeqNtHat2.st14(5);},
					7, {IFSeqNtHat2.st14(6);},
					8, {IFSeqNtHat2.st14(7);},
					9, {IFSeqNtHat2.st14(8);},
					10, {IFSeqNtHat2.st14(9);},
					11,{IFSeqNtHat2.st14(10);},
					12,{IFSeqNtHat2.st14(11);
						~cntSeqNtHat2_14=0;
					}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqHat2But15.free;
		~ifSeqHat2But15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_15 = ~cntSeqNtHat2_15 + 1;
				~cntSeqNtHat2_15.switch(
					0,{},
					1, {IFSeqNtHat2.st15(0);},
					2, {IFSeqNtHat2.st15(1);},
					3, {IFSeqNtHat2.st15(2);},
					4, {IFSeqNtHat2.st15(3);},
					5, {IFSeqNtHat2.st15(4);},
					6, {IFSeqNtHat2.st15(5);},
					7, {IFSeqNtHat2.st15(6);},
					8, {IFSeqNtHat2.st15(7);},
					9, {IFSeqNtHat2.st15(8);},
					10, {IFSeqNtHat2.st15(9);},
					11,{IFSeqNtHat2.st15(10);},
					12,{IFSeqNtHat2.st15(11);
						~cntSeqNtHat2_15=0;
					}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqHat2But16.free;
		~ifSeqHat2But16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat2_16 = ~cntSeqNtHat2_16 + 1;
				~cntSeqNtHat2_16.switch(
					0,{},
					1, {IFSeqNtHat2.st16(0);},
					2, {IFSeqNtHat2.st16(1);},
					3, {IFSeqNtHat2.st16(2);},
					4, {IFSeqNtHat2.st16(3);},
					5, {IFSeqNtHat2.st16(4);},
					6, {IFSeqNtHat2.st16(5);},
					7, {IFSeqNtHat2.st16(6);},
					8, {IFSeqNtHat2.st16(7);},
					9, {IFSeqNtHat2.st16(8);},
					10, {IFSeqNtHat2.st16(9);},
					11,{IFSeqNtHat2.st16(10);},
					12,{IFSeqNtHat2.st16(11);
						~cntSeqNtHat2_16=0;
					}
				)}
			);
			},
			'/ifSeq/2/16'
		);

	}//

	*st01 {|i=0|
		~seqNtHat2_01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_01', i);
	}
	*st02 {|i=0|
		~seqNtHat2_02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_02', i);
	}
	*st03 {|i=0|
		~seqNtHat2_03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_03', i);
	}
	*st04 {|i=0|
		~seqNtHat2_04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_04', i);
	}
	*st05 {|i=0|
		~seqNtHat2_05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_05', i);
	}
	*st06 {|i=0|
		~seqNtHat2_06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_06', i);
	}
	*st07 {|i=0|
		~seqNtHat2_07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_07', i);
	}
	*st08 {|i=0|
		~seqNtHat2_08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_08', i);
	}

	*st09 {|i=0|
		~seqNtHat2_09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_09', i);
	}
	*st10 {|i=0|
		~seqNtHat2_10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_10', i);
	}
	*st11 {|i=0|
		~seqNtHat2_11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_11', i);
	}
	*st12 {|i=0|
		~seqNtHat2_12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_12', i);
	}
	*st13 {|i=0|
		~seqNtHat2_13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_13', i);
	}
	*st14 {|i=0|
		~seqNtHat2_14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_14', i);
	}
	*st15 {|i=0|
		~seqNtHat2_15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_15', i);
	}
	*st16 {|i=0|
		~seqNtHat2_16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat2_16', i);
	}
	*stGrp {|i|

		IFSeqNtHat2.st01(i); IFSeqNtHat2.st02(i); IFSeqNtHat2.st03(i); IFSeqNtHat2.st04(i);
		IFSeqNtHat2.st05(i); IFSeqNtHat2.st06(i); IFSeqNtHat2.st07(i); IFSeqNtHat2.st08(i);
		IFSeqNtHat2.st09(i); IFSeqNtHat2.st10(i); IFSeqNtHat2.st11(i); IFSeqNtHat2.st12(i);
		IFSeqNtHat2.st13(i); IFSeqNtHat2.st14(i); IFSeqNtHat2.st15(i); IFSeqNtHat2.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqNtHat2.st01(s01); IFSeqNtHat2.st02(s02); IFSeqNtHat2.st03(s03); IFSeqNtHat2.st04(s04);
		IFSeqNtHat2.st05(s05); IFSeqNtHat2.st06(s06); IFSeqNtHat2.st07(s07); IFSeqNtHat2.st08(s08);
		IFSeqNtHat2.st09(s09); IFSeqNtHat2.st10(s10); IFSeqNtHat2.st11(s11); IFSeqNtHat2.st12(s12);
		IFSeqNtHat2.st13(s13); IFSeqNtHat2.st14(s14); IFSeqNtHat2.st15(s15); IFSeqNtHat2.st16(s16);
	}
}