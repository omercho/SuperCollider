IFSeqNtMopho {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqNtMopho01 = PatternProxy( Pseq([0], 1));
		~seqNtMopho02 = PatternProxy( Pseq([0], 1));
		~seqNtMopho03 = PatternProxy( Pseq([0], 1));
		~seqNtMopho04 = PatternProxy( Pseq([0], 1));
		~seqNtMopho05 = PatternProxy( Pseq([0], 1));
		~seqNtMopho06 = PatternProxy( Pseq([0], 1));
		~seqNtMopho07 = PatternProxy( Pseq([0], 1));
		~seqNtMopho08 = PatternProxy( Pseq([0], 1));

		~seqNtMopho09 = PatternProxy( Pseq([0], 1));
		~seqNtMopho10 = PatternProxy( Pseq([0], 1));
		~seqNtMopho11 = PatternProxy( Pseq([0], 1));
		~seqNtMopho12 = PatternProxy( Pseq([0], 1));
		~seqNtMopho13 = PatternProxy( Pseq([0], 1));
		~seqNtMopho14 = PatternProxy( Pseq([0], 1));
		~seqNtMopho15 = PatternProxy( Pseq([0], 1));
		~seqNtMopho16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqNtUpMopho01=0;
		~cntSeqNtRandMopho01=0;

		~cntSeqNtMopho01=0;
		~cntSeqNtMopho02=0;
		~cntSeqNtMopho03=0;
		~cntSeqNtMopho04=0;
		~cntSeqNtMopho05=0;
		~cntSeqNtMopho06=0;
		~cntSeqNtMopho07=0;
		~cntSeqNtMopho08=0;

		~cntSeqNtMopho09=0;
		~cntSeqNtMopho10=0;
		~cntSeqNtMopho11=0;
		~cntSeqNtMopho12=0;
		~cntSeqNtMopho13=0;
		~cntSeqNtMopho14=0;
		~cntSeqNtMopho15=0;
		~cntSeqNtMopho16=0;
	}
	*freeOn {
		~seqFreeMophoBut.free;
		~seqFreeMophoBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqNtMopho.stGrp(0);
				});
			},
			'/seqFreeMopho'
		);

	}

	*upOn {
		~ifSeqUpMophoBut.free;
		~ifSeqUpMophoBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtUpMopho01 = ~cntSeqNtUpMopho01 + 1;
				~cntSeqNtUpMopho01.switch(
					0,{},
					1,{IFSeqNtMopho.stGrp(0);},
					2,{IFSeqNtMopho.stGrp(1);},
					3,{IFSeqNtMopho.stGrp(2);},
					4,{IFSeqNtMopho.stGrp(3);},
					5,{IFSeqNtMopho.stGrp(4);},
					6,{IFSeqNtMopho.stGrp(5);},
					7,{IFSeqNtMopho.stGrp(6);},
					8,{IFSeqNtMopho.stGrp(7);},
					9,{IFSeqNtMopho.stGrp(8);},
					10,{IFSeqNtMopho.stGrp(9);},
					11,{IFSeqNtMopho.stGrp(10);},
					12,{IFSeqNtMopho.stGrp(11);
						~cntSeqNtUpMopho01=0;
					}
				)}
			);
			},
			'/seqUpMopho'
		);
	}

	*randOn {
		~ifSeqRandMophoBut.free;
		~ifSeqRandMophoBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtRandMopho01 = ~cntSeqNtRandMopho01 + 1;
				~cntSeqNtRandMopho01.switch(
					0,{},
					1,{
						IFSeqNtMopho.st01((0..11).choose);
						IFSeqNtMopho.st02((0..11).choose);
						IFSeqNtMopho.st03((0..11).choose);
						IFSeqNtMopho.st04((0..11).choose);
						IFSeqNtMopho.st05((0..11).choose);
						IFSeqNtMopho.st06((0..11).choose);
						IFSeqNtMopho.st07((0..11).choose);
						IFSeqNtMopho.st08((0..11).choose);

						IFSeqNtMopho.st09((0..11).choose);
						IFSeqNtMopho.st10((0..11).choose);
						IFSeqNtMopho.st11((0..11).choose);
						IFSeqNtMopho.st12((0..11).choose);
						IFSeqNtMopho.st13((0..11).choose);
						IFSeqNtMopho.st14((0..11).choose);
						IFSeqNtMopho.st15((0..11).choose);
						IFSeqNtMopho.st16((0..11).choose);
						~cntSeqNtRandMopho01=0;
					}
				)}
			);
			},
			'/seqRandMopho'
		);
	}

	*on { // Shift NtAVE
		IFSeqNtMopho.randOn;
		IFSeqNtMopho.upOn;
		IFSeqNtMopho.freeOn;

		~ifSeqMophoBut01.free;
		~ifSeqMophoBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho01 = ~cntSeqNtMopho01 + 1;
				~cntSeqNtMopho01.switch(
					0,{},
					1, {IFSeqNtMopho.st01(0);},
					2, {IFSeqNtMopho.st01(1);},
					3, {IFSeqNtMopho.st01(2);},
					4, {IFSeqNtMopho.st01(3);},
					5, {IFSeqNtMopho.st01(4);},
					6, {IFSeqNtMopho.st01(5);},
					7, {IFSeqNtMopho.st01(6);},
					8, {IFSeqNtMopho.st01(7);},
					9, {IFSeqNtMopho.st01(8);},
					10,{IFSeqNtMopho.st01(9);},
					11,{IFSeqNtMopho.st01(10);},
					12,{IFSeqNtMopho.st01(11);
						~cntSeqNtMopho01=0;
					}
				)}
			);
			},
			'/ifSeq/7/1'
		);
		~ifSeqMophoBut02.free;
		~ifSeqMophoBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho02 = ~cntSeqNtMopho02 + 1;
				~cntSeqNtMopho02.switch(
					0,{},
					1, {IFSeqNtMopho.st02(0);},
					2, {IFSeqNtMopho.st02(1);},
					3, {IFSeqNtMopho.st02(2);},
					4, {IFSeqNtMopho.st02(3);},
					5, {IFSeqNtMopho.st02(4);},
					6, {IFSeqNtMopho.st02(5);},
					7, {IFSeqNtMopho.st02(6);},
					8, {IFSeqNtMopho.st02(7);},
					9, {IFSeqNtMopho.st02(8);},
					10, {IFSeqNtMopho.st02(9);},
					11,{IFSeqNtMopho.st02(10);},
					12,{IFSeqNtMopho.st02(11);
						~cntSeqNtMopho02=0;
					}
				)}
			);
			},
			'/ifSeq/7/2'
		);
		~ifSeqMophoBut03.free;
		~ifSeqMophoBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho03 = ~cntSeqNtMopho03 + 1;
				~cntSeqNtMopho03.switch(
					0,{},
					1, {IFSeqNtMopho.st03(0);},
					2, {IFSeqNtMopho.st03(1);},
					3, {IFSeqNtMopho.st03(2);},
					4, {IFSeqNtMopho.st03(3);},
					5, {IFSeqNtMopho.st03(4);},
					6, {IFSeqNtMopho.st03(5);},
					7, {IFSeqNtMopho.st03(6);},
					8, {IFSeqNtMopho.st03(7);},
					9, {IFSeqNtMopho.st03(8);},
					10, {IFSeqNtMopho.st03(9);},
					11,{IFSeqNtMopho.st03(10);},
					12,{IFSeqNtMopho.st03(11);
						~cntSeqNtMopho03=0;
					}
				)}
			);
			},
			'/ifSeq/7/3'
		);
		~ifSeqMophoBut04.free;
		~ifSeqMophoBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho04 = ~cntSeqNtMopho04 + 1;
				~cntSeqNtMopho04.switch(
					0,{},
					1, {IFSeqNtMopho.st04(0);},
					2, {IFSeqNtMopho.st04(1);},
					3, {IFSeqNtMopho.st04(2);},
					4, {IFSeqNtMopho.st04(3);},
					5, {IFSeqNtMopho.st04(4);},
					6, {IFSeqNtMopho.st04(5);},
					7, {IFSeqNtMopho.st04(6);},
					8, {IFSeqNtMopho.st04(7);},
					9, {IFSeqNtMopho.st04(8);},
					10, {IFSeqNtMopho.st04(9);},
					11,{IFSeqNtMopho.st04(10);},
					12,{IFSeqNtMopho.st04(11);
						~cntSeqNtMopho04=0;
					}
				)}
			);
			},
			'/ifSeq/7/4'
		);
		~ifSeqMophoBut05.free;
		~ifSeqMophoBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho05 = ~cntSeqNtMopho05 + 1;
				~cntSeqNtMopho05.switch(
					0,{},
					1, {IFSeqNtMopho.st05(0);},
					2, {IFSeqNtMopho.st05(1);},
					3, {IFSeqNtMopho.st05(2);},
					4, {IFSeqNtMopho.st05(3);},
					5, {IFSeqNtMopho.st05(4);},
					6, {IFSeqNtMopho.st05(5);},
					7, {IFSeqNtMopho.st05(6);},
					8, {IFSeqNtMopho.st05(7);},
					9, {IFSeqNtMopho.st05(8);},
					10, {IFSeqNtMopho.st05(9);},
					11,{IFSeqNtMopho.st05(10);},
					12,{IFSeqNtMopho.st05(11);
						~cntSeqNtMopho05=0;
					}
				)}
			);
			},
			'/ifSeq/7/5'
		);
		~ifSeqMophoBut06.free;
		~ifSeqMophoBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho06 = ~cntSeqNtMopho06 + 1;
				~cntSeqNtMopho06.switch(
					0,{},
					1, {IFSeqNtMopho.st06(0);},
					2, {IFSeqNtMopho.st06(1);},
					3, {IFSeqNtMopho.st06(2);},
					4, {IFSeqNtMopho.st06(3);},
					5, {IFSeqNtMopho.st06(4);},
					6, {IFSeqNtMopho.st06(5);},
					7, {IFSeqNtMopho.st06(6);},
					8, {IFSeqNtMopho.st06(7);},
					9, {IFSeqNtMopho.st06(8);},
					10, {IFSeqNtMopho.st06(9);},
					11,{IFSeqNtMopho.st06(10);},
					12,{IFSeqNtMopho.st06(11);
						~cntSeqNtMopho06=0;
					}
				)}
			);
			},
			'/ifSeq/7/6'
		);
		~ifSeqMophoBut07.free;
		~ifSeqMophoBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho07 = ~cntSeqNtMopho07 + 1;
				~cntSeqNtMopho07.switch(
					0,{},
					1, {IFSeqNtMopho.st07(0);},
					2, {IFSeqNtMopho.st07(1);},
					3, {IFSeqNtMopho.st07(2);},
					4, {IFSeqNtMopho.st07(3);},
					5, {IFSeqNtMopho.st07(4);},
					6, {IFSeqNtMopho.st07(5);},
					7, {IFSeqNtMopho.st07(6);},
					8, {IFSeqNtMopho.st07(7);},
					9, {IFSeqNtMopho.st07(8);},
					10, {IFSeqNtMopho.st07(9);},
					11,{IFSeqNtMopho.st07(10);},
					12,{IFSeqNtMopho.st07(11);
						~cntSeqNtMopho07=0;
					}
				)}
			);
			},
			'/ifSeq/7/7'
		);
		~ifSeqMophoBut08.free;
		~ifSeqMophoBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho08 = ~cntSeqNtMopho08 + 1;
				~cntSeqNtMopho08.switch(
					0,{},
					1, {IFSeqNtMopho.st08(0);},
					2, {IFSeqNtMopho.st08(1);},
					3, {IFSeqNtMopho.st08(2);},
					4, {IFSeqNtMopho.st08(3);},
					5, {IFSeqNtMopho.st08(4);},
					6, {IFSeqNtMopho.st08(5);},
					7, {IFSeqNtMopho.st08(6);},
					8, {IFSeqNtMopho.st08(7);},
					9, {IFSeqNtMopho.st08(8);},
					10, {IFSeqNtMopho.st08(9);},
					11,{IFSeqNtMopho.st08(10);},
					12,{IFSeqNtMopho.st08(11);
						~cntSeqNtMopho08=0;
					}
				)}
			);
			},
			'/ifSeq/7/8'
		);

		~ifSeqMophoBut09.free;
		~ifSeqMophoBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho09 = ~cntSeqNtMopho09 + 1;
				~cntSeqNtMopho09.switch(
					0,{},
					1, {IFSeqNtMopho.st09(0);},
					2, {IFSeqNtMopho.st09(1);},
					3, {IFSeqNtMopho.st09(2);},
					4, {IFSeqNtMopho.st09(3);},
					5, {IFSeqNtMopho.st09(4);},
					6, {IFSeqNtMopho.st09(5);},
					7, {IFSeqNtMopho.st09(6);},
					8, {IFSeqNtMopho.st09(7);},
					9, {IFSeqNtMopho.st09(8);},
					10, {IFSeqNtMopho.st09(9);},
					11,{IFSeqNtMopho.st09(10);},
					12,{IFSeqNtMopho.st09(11);
						~cntSeqNtMopho09=0;
					}
				)}
			);
			},
			'/ifSeq/7/9'
		);
		~ifSeqMophoBut10.free;
		~ifSeqMophoBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho10 = ~cntSeqNtMopho10 + 1;
				~cntSeqNtMopho10.switch(
					0,{},
					1, {IFSeqNtMopho.st10(0);},
					2, {IFSeqNtMopho.st10(1);},
					3, {IFSeqNtMopho.st10(2);},
					4, {IFSeqNtMopho.st10(3);},
					5, {IFSeqNtMopho.st10(4);},
					6, {IFSeqNtMopho.st10(5);},
					7, {IFSeqNtMopho.st10(6);},
					8, {IFSeqNtMopho.st10(7);},
					9, {IFSeqNtMopho.st10(8);},
					10, {IFSeqNtMopho.st10(9);},
					11,{IFSeqNtMopho.st10(10);},
					12,{IFSeqNtMopho.st10(11);
						~cntSeqNtMopho10=0;
					}
				)}
			);
			},
			'/ifSeq/7/10'
		);
		~ifSeqMophoBut11.free;
		~ifSeqMophoBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho11 = ~cntSeqNtMopho11 + 1;
				~cntSeqNtMopho11.switch(
					0,{},
					1, {IFSeqNtMopho.st11(0);},
					2, {IFSeqNtMopho.st11(1);},
					3, {IFSeqNtMopho.st11(2);},
					4, {IFSeqNtMopho.st11(3);},
					5, {IFSeqNtMopho.st11(4);},
					6, {IFSeqNtMopho.st11(5);},
					7, {IFSeqNtMopho.st11(6);},
					8, {IFSeqNtMopho.st11(7);},
					9, {IFSeqNtMopho.st11(8);},
					10, {IFSeqNtMopho.st11(9);},
					11,{IFSeqNtMopho.st11(10);},
					12,{IFSeqNtMopho.st11(11);
						~cntSeqNtMopho11=0;
					}
				)}
			);
			},
			'/ifSeq/7/11'
		);
		~ifSeqMophoBut12.free;
		~ifSeqMophoBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho12 = ~cntSeqNtMopho12 + 1;
				~cntSeqNtMopho12.switch(
					0,{},
					1, {IFSeqNtMopho.st12(0);},
					2, {IFSeqNtMopho.st12(1);},
					3, {IFSeqNtMopho.st12(2);},
					4, {IFSeqNtMopho.st12(3);},
					5, {IFSeqNtMopho.st12(4);},
					6, {IFSeqNtMopho.st12(5);},
					7, {IFSeqNtMopho.st12(6);},
					8, {IFSeqNtMopho.st12(7);},
					9, {IFSeqNtMopho.st12(8);},
					10, {IFSeqNtMopho.st12(9);},
					11,{IFSeqNtMopho.st12(10);},
					12,{IFSeqNtMopho.st12(11);
						~cntSeqNtMopho12=0;
					}
				)}
			);
			},
			'/ifSeq/7/12'
		);
		~ifSeqMophoBut13.free;
		~ifSeqMophoBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho13 = ~cntSeqNtMopho13 + 1;
				~cntSeqNtMopho13.switch(
					0,{},
					1, {IFSeqNtMopho.st13(0);},
					2, {IFSeqNtMopho.st13(1);},
					3, {IFSeqNtMopho.st13(2);},
					4, {IFSeqNtMopho.st13(3);},
					5, {IFSeqNtMopho.st13(4);},
					6, {IFSeqNtMopho.st13(5);},
					7, {IFSeqNtMopho.st13(6);},
					8, {IFSeqNtMopho.st13(7);},
					9, {IFSeqNtMopho.st13(8);},
					10, {IFSeqNtMopho.st13(9);},
					11,{IFSeqNtMopho.st13(10);},
					12,{IFSeqNtMopho.st13(11);
						~cntSeqNtMopho13=0;
					}
				)}
			);
			},
			'/ifSeq/7/13'
		);
		~ifSeqMophoBut14.free;
		~ifSeqMophoBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho14 = ~cntSeqNtMopho14 + 1;
				~cntSeqNtMopho14.switch(
					0,{},
					1, {IFSeqNtMopho.st14(0);},
					2, {IFSeqNtMopho.st14(1);},
					3, {IFSeqNtMopho.st14(2);},
					4, {IFSeqNtMopho.st14(3);},
					5, {IFSeqNtMopho.st14(4);},
					6, {IFSeqNtMopho.st14(5);},
					7, {IFSeqNtMopho.st14(6);},
					8, {IFSeqNtMopho.st14(7);},
					9, {IFSeqNtMopho.st14(8);},
					10, {IFSeqNtMopho.st14(9);},
					11,{IFSeqNtMopho.st14(10);},
					12,{IFSeqNtMopho.st14(11);
						~cntSeqNtMopho14=0;
					}
				)}
			);
			},
			'/ifSeq/7/14'
		);
		~ifSeqMophoBut15.free;
		~ifSeqMophoBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho15 = ~cntSeqNtMopho15 + 1;
				~cntSeqNtMopho15.switch(
					0,{},
					1, {IFSeqNtMopho.st15(0);},
					2, {IFSeqNtMopho.st15(1);},
					3, {IFSeqNtMopho.st15(2);},
					4, {IFSeqNtMopho.st15(3);},
					5, {IFSeqNtMopho.st15(4);},
					6, {IFSeqNtMopho.st15(5);},
					7, {IFSeqNtMopho.st15(6);},
					8, {IFSeqNtMopho.st15(7);},
					9, {IFSeqNtMopho.st15(8);},
					10, {IFSeqNtMopho.st15(9);},
					11,{IFSeqNtMopho.st15(10);},
					12,{IFSeqNtMopho.st15(11);
						~cntSeqNtMopho15=0;
					}
				)}
			);
			},
			'/ifSeq/7/15'
		);
		~ifSeqMophoBut16.free;
		~ifSeqMophoBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtMopho16 = ~cntSeqNtMopho16 + 1;
				~cntSeqNtMopho16.switch(
					0,{},
					1, {IFSeqNtMopho.st16(0);},
					2, {IFSeqNtMopho.st16(1);},
					3, {IFSeqNtMopho.st16(2);},
					4, {IFSeqNtMopho.st16(3);},
					5, {IFSeqNtMopho.st16(4);},
					6, {IFSeqNtMopho.st16(5);},
					7, {IFSeqNtMopho.st16(6);},
					8, {IFSeqNtMopho.st16(7);},
					9, {IFSeqNtMopho.st16(8);},
					10, {IFSeqNtMopho.st16(9);},
					11,{IFSeqNtMopho.st16(10);},
					12,{IFSeqNtMopho.st16(11);
						~cntSeqNtMopho16=0;
					}
				)}
			);
			},
			'/ifSeq/7/16'
		);

	}//

	*st01 {|i=0|
		~seqNtMopho01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho01', i);
	}
	*st02 {|i=0|
		~seqNtMopho02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho02', i);
	}
	*st03 {|i=0|
		~seqNtMopho03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho03', i);
	}
	*st04 {|i=0|
		~seqNtMopho04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho04', i);
	}
	*st05 {|i=0|
		~seqNtMopho05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho05', i);
	}
	*st06 {|i=0|
		~seqNtMopho06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho06', i);
	}
	*st07 {|i=0|
		~seqNtMopho07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho07', i);
	}
	*st08 {|i=0|
		~seqNtMopho08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho08', i);
	}

	*st09 {|i=0|
		~seqNtMopho09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho09', i);
	}
	*st10 {|i=0|
		~seqNtMopho10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho10', i);
	}
	*st11 {|i=0|
		~seqNtMopho11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho11', i);
	}
	*st12 {|i=0|
		~seqNtMopho12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho12', i);
	}
	*st13 {|i=0|
		~seqNtMopho13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho13', i);
	}
	*st14 {|i=0|
		~seqNtMopho14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho14', i);
	}
	*st15 {|i=0|
		~seqNtMopho15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho15', i);
	}
	*st16 {|i=0|
		~seqNtMopho16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtMopho16', i);
	}
	*stGrp {|i|

		IFSeqNtMopho.st01(i); IFSeqNtMopho.st02(i); IFSeqNtMopho.st03(i); IFSeqNtMopho.st04(i);
		IFSeqNtMopho.st05(i); IFSeqNtMopho.st06(i); IFSeqNtMopho.st07(i); IFSeqNtMopho.st08(i);
		IFSeqNtMopho.st09(i); IFSeqNtMopho.st10(i); IFSeqNtMopho.st11(i); IFSeqNtMopho.st12(i);
		IFSeqNtMopho.st13(i); IFSeqNtMopho.st14(i); IFSeqNtMopho.st15(i); IFSeqNtMopho.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqNtMopho.st01(s01); IFSeqNtMopho.st02(s02); IFSeqNtMopho.st03(s03); IFSeqNtMopho.st04(s04);
		IFSeqNtMopho.st05(s05); IFSeqNtMopho.st06(s06); IFSeqNtMopho.st07(s07); IFSeqNtMopho.st08(s08);
		IFSeqNtMopho.st09(s09); IFSeqNtMopho.st10(s10); IFSeqNtMopho.st11(s11); IFSeqNtMopho.st12(s12);
		IFSeqNtMopho.st13(s13); IFSeqNtMopho.st14(s14); IFSeqNtMopho.st15(s15); IFSeqNtMopho.st16(s16);
	}
}