IFSeqNtSnr2 {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqNtSnr2_01 = PatternProxy( Pseq([0], 1));
		~seqNtSnr2_02 = PatternProxy( Pseq([0], 1));
		~seqNtSnr2_03 = PatternProxy( Pseq([0], 1));
		~seqNtSnr2_04 = PatternProxy( Pseq([0], 1));
		~seqNtSnr2_05 = PatternProxy( Pseq([0], 1));
		~seqNtSnr2_06 = PatternProxy( Pseq([0], 1));
		~seqNtSnr2_07 = PatternProxy( Pseq([0], 1));
		~seqNtSnr2_08 = PatternProxy( Pseq([0], 1));

		~seqNtSnr2_09 = PatternProxy( Pseq([0], 1));
		~seqNtSnr2_10 = PatternProxy( Pseq([0], 1));
		~seqNtSnr2_11 = PatternProxy( Pseq([0], 1));
		~seqNtSnr2_12 = PatternProxy( Pseq([0], 1));
		~seqNtSnr2_13 = PatternProxy( Pseq([0], 1));
		~seqNtSnr2_14 = PatternProxy( Pseq([0], 1));
		~seqNtSnr2_15 = PatternProxy( Pseq([0], 1));
		~seqNtSnr2_16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqNtUpSnr2_01=0;
		~cntSeqNtRandSnr2_01=0;

		~cntSeqNtSnr2_01=0;
		~cntSeqNtSnr2_02=0;
		~cntSeqNtSnr2_03=0;
		~cntSeqNtSnr2_04=0;
		~cntSeqNtSnr2_05=0;
		~cntSeqNtSnr2_06=0;
		~cntSeqNtSnr2_07=0;
		~cntSeqNtSnr2_08=0;

		~cntSeqNtSnr2_09=0;
		~cntSeqNtSnr2_10=0;
		~cntSeqNtSnr2_11=0;
		~cntSeqNtSnr2_12=0;
		~cntSeqNtSnr2_13=0;
		~cntSeqNtSnr2_14=0;
		~cntSeqNtSnr2_15=0;
		~cntSeqNtSnr2_16=0;
	}
	*freeOn {
		~seqFreeSnr2But.free;
		~seqFreeSnr2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqNtSnr2.stGrp(0);
				});
			},
			'/seqFreeSnr2'
		);

	}

	*upOn {
		~ifSeqUpSnr2But.free;
		~ifSeqUpSnr2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtUpSnr01 = ~cntSeqNtUpSnr01 + 1;
				~cntSeqNtUpSnr01.switch(
					0,{},
					1,{IFSeqNtSnr2.stGrp(0);},
					2,{IFSeqNtSnr2.stGrp(1);},
					3,{IFSeqNtSnr2.stGrp(2);},
					4,{IFSeqNtSnr2.stGrp(3);},
					5,{IFSeqNtSnr2.stGrp(4);},
					6,{IFSeqNtSnr2.stGrp(5);},
					7,{IFSeqNtSnr2.stGrp(6);},
					8,{IFSeqNtSnr2.stGrp(7);},
					9,{IFSeqNtSnr2.stGrp(8);},
					10,{IFSeqNtSnr2.stGrp(9);},
					11,{IFSeqNtSnr2.stGrp(10);},
					12,{IFSeqNtSnr2.stGrp(11);
						~cntSeqNtUpSnr01=0;
					}
				)}
			);
			},
			'/seqUpSnr2'
		);
	}

	*randOn {
		~ifSeqRandSnrBut.free;
		~ifSeqRandSnrBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtRandSnr01 = ~cntSeqNtRandSnr01 + 1;
				~cntSeqNtRandSnr01.switch(
					0,{},
					1,{
						IFSeqNtSnr2.st01((0..11).choose);
						IFSeqNtSnr2.st02((0..11).choose);
						IFSeqNtSnr2.st03((0..11).choose);
						IFSeqNtSnr2.st04((0..11).choose);
						IFSeqNtSnr2.st05((0..11).choose);
						IFSeqNtSnr2.st06((0..11).choose);
						IFSeqNtSnr2.st07((0..11).choose);
						IFSeqNtSnr2.st08((0..11).choose);

						IFSeqNtSnr2.st09((0..11).choose);
						IFSeqNtSnr2.st10((0..11).choose);
						IFSeqNtSnr2.st11((0..11).choose);
						IFSeqNtSnr2.st12((0..11).choose);
						IFSeqNtSnr2.st13((0..11).choose);
						IFSeqNtSnr2.st14((0..11).choose);
						IFSeqNtSnr2.st15((0..11).choose);
						IFSeqNtSnr2.st16((0..11).choose);
						~cntSeqNtRandSnr01=0;
					}
				)}
			);
			},
			'/seqRandSnr2'
		);
	}

	*on { // Shift NtAVE
		IFSeqNtSnr2.randOn;
		IFSeqNtSnr2.upOn;
		IFSeqNtSnr2.freeOn;

		~ifSeqSnr2But01.free;
		~ifSeqSnr2But01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_01 = ~cntSeqNtSnr2_01 + 1;
				~cntSeqNtSnr2_01.switch(
					0,{},
					1, {IFSeqNtSnr2.st01(0);},
					2, {IFSeqNtSnr2.st01(1);},
					3, {IFSeqNtSnr2.st01(2);},
					4, {IFSeqNtSnr2.st01(3);},
					5, {IFSeqNtSnr2.st01(4);},
					6, {IFSeqNtSnr2.st01(5);},
					7, {IFSeqNtSnr2.st01(6);},
					8, {IFSeqNtSnr2.st01(7);},
					9, {IFSeqNtSnr2.st01(8);},
					10,{IFSeqNtSnr2.st01(9);},
					11,{IFSeqNtSnr2.st01(10);},
					12,{IFSeqNtSnr2.st01(11);
						~cntSeqNtSnr2_01=0;
					}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqSnr2But02.free;
		~ifSeqSnr2But02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_02 = ~cntSeqNtSnr2_02 + 1;
				~cntSeqNtSnr2_02.switch(
					0,{},
					1, {IFSeqNtSnr2.st02(0);},
					2, {IFSeqNtSnr2.st02(1);},
					3, {IFSeqNtSnr2.st02(2);},
					4, {IFSeqNtSnr2.st02(3);},
					5, {IFSeqNtSnr2.st02(4);},
					6, {IFSeqNtSnr2.st02(5);},
					7, {IFSeqNtSnr2.st02(6);},
					8, {IFSeqNtSnr2.st02(7);},
					9, {IFSeqNtSnr2.st02(8);},
					10, {IFSeqNtSnr2.st02(9);},
					11,{IFSeqNtSnr2.st02(10);},
					12,{IFSeqNtSnr2.st02(11);
						~cntSeqNtSnr2_02=0;
					}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqSnr2But03.free;
		~ifSeqSnr2But03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_03 = ~cntSeqNtSnr2_03 + 1;
				~cntSeqNtSnr2_03.switch(
					0,{},
					1, {IFSeqNtSnr2.st03(0);},
					2, {IFSeqNtSnr2.st03(1);},
					3, {IFSeqNtSnr2.st03(2);},
					4, {IFSeqNtSnr2.st03(3);},
					5, {IFSeqNtSnr2.st03(4);},
					6, {IFSeqNtSnr2.st03(5);},
					7, {IFSeqNtSnr2.st03(6);},
					8, {IFSeqNtSnr2.st03(7);},
					9, {IFSeqNtSnr2.st03(8);},
					10, {IFSeqNtSnr2.st03(9);},
					11,{IFSeqNtSnr2.st03(10);},
					12,{IFSeqNtSnr2.st03(11);
						~cntSeqNtSnr2_03=0;
					}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqSnr2But04.free;
		~ifSeqSnr2But04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_04 = ~cntSeqNtSnr2_04 + 1;
				~cntSeqNtSnr2_04.switch(
					0,{},
					1, {IFSeqNtSnr2.st04(0);},
					2, {IFSeqNtSnr2.st04(1);},
					3, {IFSeqNtSnr2.st04(2);},
					4, {IFSeqNtSnr2.st04(3);},
					5, {IFSeqNtSnr2.st04(4);},
					6, {IFSeqNtSnr2.st04(5);},
					7, {IFSeqNtSnr2.st04(6);},
					8, {IFSeqNtSnr2.st04(7);},
					9, {IFSeqNtSnr2.st04(8);},
					10, {IFSeqNtSnr2.st04(9);},
					11,{IFSeqNtSnr2.st04(10);},
					12,{IFSeqNtSnr2.st04(11);
						~cntSeqNtSnr2_04=0;
					}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqSnr2But05.free;
		~ifSeqSnr2But05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_05 = ~cntSeqNtSnr2_05 + 1;
				~cntSeqNtSnr2_05.switch(
					0,{},
					1, {IFSeqNtSnr2.st05(0);},
					2, {IFSeqNtSnr2.st05(1);},
					3, {IFSeqNtSnr2.st05(2);},
					4, {IFSeqNtSnr2.st05(3);},
					5, {IFSeqNtSnr2.st05(4);},
					6, {IFSeqNtSnr2.st05(5);},
					7, {IFSeqNtSnr2.st05(6);},
					8, {IFSeqNtSnr2.st05(7);},
					9, {IFSeqNtSnr2.st05(8);},
					10, {IFSeqNtSnr2.st05(9);},
					11,{IFSeqNtSnr2.st05(10);},
					12,{IFSeqNtSnr2.st05(11);
						~cntSeqNtSnr2_05=0;
					}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqSnr2But06.free;
		~ifSeqSnr2But06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_06 = ~cntSeqNtSnr2_06 + 1;
				~cntSeqNtSnr2_06.switch(
					0,{},
					1, {IFSeqNtSnr2.st06(0);},
					2, {IFSeqNtSnr2.st06(1);},
					3, {IFSeqNtSnr2.st06(2);},
					4, {IFSeqNtSnr2.st06(3);},
					5, {IFSeqNtSnr2.st06(4);},
					6, {IFSeqNtSnr2.st06(5);},
					7, {IFSeqNtSnr2.st06(6);},
					8, {IFSeqNtSnr2.st06(7);},
					9, {IFSeqNtSnr2.st06(8);},
					10, {IFSeqNtSnr2.st06(9);},
					11,{IFSeqNtSnr2.st06(10);},
					12,{IFSeqNtSnr2.st06(11);
						~cntSeqNtSnr2_06=0;
					}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqSnr2But07.free;
		~ifSeqSnr2But07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_07 = ~cntSeqNtSnr2_07 + 1;
				~cntSeqNtSnr2_07.switch(
					0,{},
					1, {IFSeqNtSnr2.st07(0);},
					2, {IFSeqNtSnr2.st07(1);},
					3, {IFSeqNtSnr2.st07(2);},
					4, {IFSeqNtSnr2.st07(3);},
					5, {IFSeqNtSnr2.st07(4);},
					6, {IFSeqNtSnr2.st07(5);},
					7, {IFSeqNtSnr2.st07(6);},
					8, {IFSeqNtSnr2.st07(7);},
					9, {IFSeqNtSnr2.st07(8);},
					10, {IFSeqNtSnr2.st07(9);},
					11,{IFSeqNtSnr2.st07(10);},
					12,{IFSeqNtSnr2.st07(11);
						~cntSeqNtSnr2_07=0;
					}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqSnr2But08.free;
		~ifSeqSnr2But08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_08 = ~cntSeqNtSnr2_08 + 1;
				~cntSeqNtSnr2_08.switch(
					0,{},
					1, {IFSeqNtSnr2.st08(0);},
					2, {IFSeqNtSnr2.st08(1);},
					3, {IFSeqNtSnr2.st08(2);},
					4, {IFSeqNtSnr2.st08(3);},
					5, {IFSeqNtSnr2.st08(4);},
					6, {IFSeqNtSnr2.st08(5);},
					7, {IFSeqNtSnr2.st08(6);},
					8, {IFSeqNtSnr2.st08(7);},
					9, {IFSeqNtSnr2.st08(8);},
					10, {IFSeqNtSnr2.st08(9);},
					11,{IFSeqNtSnr2.st08(10);},
					12,{IFSeqNtSnr2.st08(11);
						~cntSeqNtSnr2_08=0;
					}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqSnr2But09.free;
		~ifSeqSnr2But09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_09 = ~cntSeqNtSnr2_09 + 1;
				~cntSeqNtSnr2_09.switch(
					0,{},
					1, {IFSeqNtSnr2.st09(0);},
					2, {IFSeqNtSnr2.st09(1);},
					3, {IFSeqNtSnr2.st09(2);},
					4, {IFSeqNtSnr2.st09(3);},
					5, {IFSeqNtSnr2.st09(4);},
					6, {IFSeqNtSnr2.st09(5);},
					7, {IFSeqNtSnr2.st09(6);},
					8, {IFSeqNtSnr2.st09(7);},
					9, {IFSeqNtSnr2.st09(8);},
					10, {IFSeqNtSnr2.st09(9);},
					11,{IFSeqNtSnr2.st09(10);},
					12,{IFSeqNtSnr2.st09(11);
						~cntSeqNtSnr2_09=0;
					}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqSnr2But10.free;
		~ifSeqSnr2But10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_10 = ~cntSeqNtSnr2_10 + 1;
				~cntSeqNtSnr2_10.switch(
					0,{},
					1, {IFSeqNtSnr2.st10(0);},
					2, {IFSeqNtSnr2.st10(1);},
					3, {IFSeqNtSnr2.st10(2);},
					4, {IFSeqNtSnr2.st10(3);},
					5, {IFSeqNtSnr2.st10(4);},
					6, {IFSeqNtSnr2.st10(5);},
					7, {IFSeqNtSnr2.st10(6);},
					8, {IFSeqNtSnr2.st10(7);},
					9, {IFSeqNtSnr2.st10(8);},
					10, {IFSeqNtSnr2.st10(9);},
					11,{IFSeqNtSnr2.st10(10);},
					12,{IFSeqNtSnr2.st10(11);
						~cntSeqNtSnr2_10=0;
					}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqSnr2But11.free;
		~ifSeqSnr2But11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_11 = ~cntSeqNtSnr2_11 + 1;
				~cntSeqNtSnr2_11.switch(
					0,{},
					1, {IFSeqNtSnr2.st11(0);},
					2, {IFSeqNtSnr2.st11(1);},
					3, {IFSeqNtSnr2.st11(2);},
					4, {IFSeqNtSnr2.st11(3);},
					5, {IFSeqNtSnr2.st11(4);},
					6, {IFSeqNtSnr2.st11(5);},
					7, {IFSeqNtSnr2.st11(6);},
					8, {IFSeqNtSnr2.st11(7);},
					9, {IFSeqNtSnr2.st11(8);},
					10, {IFSeqNtSnr2.st11(9);},
					11,{IFSeqNtSnr2.st11(10);},
					12,{IFSeqNtSnr2.st11(11);
						~cntSeqNtSnr2_11=0;
					}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqSnr2But12.free;
		~ifSeqSnr2But12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_12 = ~cntSeqNtSnr2_12 + 1;
				~cntSeqNtSnr2_12.switch(
					0,{},
					1, {IFSeqNtSnr2.st12(0);},
					2, {IFSeqNtSnr2.st12(1);},
					3, {IFSeqNtSnr2.st12(2);},
					4, {IFSeqNtSnr2.st12(3);},
					5, {IFSeqNtSnr2.st12(4);},
					6, {IFSeqNtSnr2.st12(5);},
					7, {IFSeqNtSnr2.st12(6);},
					8, {IFSeqNtSnr2.st12(7);},
					9, {IFSeqNtSnr2.st12(8);},
					10, {IFSeqNtSnr2.st12(9);},
					11,{IFSeqNtSnr2.st12(10);},
					12,{IFSeqNtSnr2.st12(11);
						~cntSeqNtSnr2_12=0;
					}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqSnr2But13.free;
		~ifSeqSnr2But13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_13 = ~cntSeqNtSnr2_13 + 1;
				~cntSeqNtSnr2_13.switch(
					0,{},
					1, {IFSeqNtSnr2.st13(0);},
					2, {IFSeqNtSnr2.st13(1);},
					3, {IFSeqNtSnr2.st13(2);},
					4, {IFSeqNtSnr2.st13(3);},
					5, {IFSeqNtSnr2.st13(4);},
					6, {IFSeqNtSnr2.st13(5);},
					7, {IFSeqNtSnr2.st13(6);},
					8, {IFSeqNtSnr2.st13(7);},
					9, {IFSeqNtSnr2.st13(8);},
					10, {IFSeqNtSnr2.st13(9);},
					11,{IFSeqNtSnr2.st13(10);},
					12,{IFSeqNtSnr2.st13(11);
						~cntSeqNtSnr2_13=0;
					}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqSnr2But14.free;
		~ifSeqSnr2But14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_14 = ~cntSeqNtSnr2_14 + 1;
				~cntSeqNtSnr2_14.switch(
					0,{},
					1, {IFSeqNtSnr2.st14(0);},
					2, {IFSeqNtSnr2.st14(1);},
					3, {IFSeqNtSnr2.st14(2);},
					4, {IFSeqNtSnr2.st14(3);},
					5, {IFSeqNtSnr2.st14(4);},
					6, {IFSeqNtSnr2.st14(5);},
					7, {IFSeqNtSnr2.st14(6);},
					8, {IFSeqNtSnr2.st14(7);},
					9, {IFSeqNtSnr2.st14(8);},
					10, {IFSeqNtSnr2.st14(9);},
					11,{IFSeqNtSnr2.st14(10);},
					12,{IFSeqNtSnr2.st14(11);
						~cntSeqNtSnr2_14=0;
					}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqSnr2But15.free;
		~ifSeqSnr2But15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_15 = ~cntSeqNtSnr2_15 + 1;
				~cntSeqNtSnr2_15.switch(
					0,{},
					1, {IFSeqNtSnr2.st15(0);},
					2, {IFSeqNtSnr2.st15(1);},
					3, {IFSeqNtSnr2.st15(2);},
					4, {IFSeqNtSnr2.st15(3);},
					5, {IFSeqNtSnr2.st15(4);},
					6, {IFSeqNtSnr2.st15(5);},
					7, {IFSeqNtSnr2.st15(6);},
					8, {IFSeqNtSnr2.st15(7);},
					9, {IFSeqNtSnr2.st15(8);},
					10, {IFSeqNtSnr2.st15(9);},
					11,{IFSeqNtSnr2.st15(10);},
					12,{IFSeqNtSnr2.st15(11);
						~cntSeqNtSnr2_15=0;
					}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqSnr2But16.free;
		~ifSeqSnr2But16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr2_16 = ~cntSeqNtSnr2_16 + 1;
				~cntSeqNtSnr2_16.switch(
					0,{},
					1, {IFSeqNtSnr2.st16(0);},
					2, {IFSeqNtSnr2.st16(1);},
					3, {IFSeqNtSnr2.st16(2);},
					4, {IFSeqNtSnr2.st16(3);},
					5, {IFSeqNtSnr2.st16(4);},
					6, {IFSeqNtSnr2.st16(5);},
					7, {IFSeqNtSnr2.st16(6);},
					8, {IFSeqNtSnr2.st16(7);},
					9, {IFSeqNtSnr2.st16(8);},
					10, {IFSeqNtSnr2.st16(9);},
					11,{IFSeqNtSnr2.st16(10);},
					12,{IFSeqNtSnr2.st16(11);
						~cntSeqNtSnr2_16=0;
					}
				)}
			);
			},
			'/ifSeq/2/16'
		);

	}//

	*st01 {|i=0|
		~seqNtSnr2_01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_01', i);
	}
	*st02 {|i=0|
		~seqNtSnr2_02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_02', i);
	}
	*st03 {|i=0|
		~seqNtSnr2_03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_03', i);
	}
	*st04 {|i=0|
		~seqNtSnr2_04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_04', i);
	}
	*st05 {|i=0|
		~seqNtSnr2_05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_05', i);
	}
	*st06 {|i=0|
		~seqNtSnr2_06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_06', i);
	}
	*st07 {|i=0|
		~seqNtSnr2_07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_07', i);
	}
	*st08 {|i=0|
		~seqNtSnr2_08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_08', i);
	}

	*st09 {|i=0|
		~seqNtSnr2_09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_09', i);
	}
	*st10 {|i=0|
		~seqNtSnr2_10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_10', i);
	}
	*st11 {|i=0|
		~seqNtSnr2_11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_11', i);
	}
	*st12 {|i=0|
		~seqNtSnr2_12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_12', i);
	}
	*st13 {|i=0|
		~seqNtSnr2_13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_13', i);
	}
	*st14 {|i=0|
		~seqNtSnr2_14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_14', i);
	}
	*st15 {|i=0|
		~seqNtSnr2_15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_15', i);
	}
	*st16 {|i=0|
		~seqNtSnr2_16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr2_16', i);
	}
	*stGrp {|i|

		IFSeqNtSnr2.st01(i); IFSeqNtSnr2.st02(i); IFSeqNtSnr2.st03(i); IFSeqNtSnr2.st04(i);
		IFSeqNtSnr2.st05(i); IFSeqNtSnr2.st06(i); IFSeqNtSnr2.st07(i); IFSeqNtSnr2.st08(i);
		IFSeqNtSnr2.st09(i); IFSeqNtSnr2.st10(i); IFSeqNtSnr2.st11(i); IFSeqNtSnr2.st12(i);
		IFSeqNtSnr2.st13(i); IFSeqNtSnr2.st14(i); IFSeqNtSnr2.st15(i); IFSeqNtSnr2.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqNtSnr2.st01(s01); IFSeqNtSnr2.st02(s02); IFSeqNtSnr2.st03(s03); IFSeqNtSnr2.st04(s04);
		IFSeqNtSnr2.st05(s05); IFSeqNtSnr2.st06(s06); IFSeqNtSnr2.st07(s07); IFSeqNtSnr2.st08(s08);
		IFSeqNtSnr2.st09(s09); IFSeqNtSnr2.st10(s10); IFSeqNtSnr2.st11(s11); IFSeqNtSnr2.st12(s12);
		IFSeqNtSnr2.st13(s13); IFSeqNtSnr2.st14(s14); IFSeqNtSnr2.st15(s15); IFSeqNtSnr2.st16(s16);
	}
}