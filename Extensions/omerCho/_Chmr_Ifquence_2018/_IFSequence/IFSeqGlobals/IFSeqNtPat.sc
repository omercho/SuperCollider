IFSeqNtPat {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqNtPat01 = PatternProxy( Pseq([0], 1));
		~seqNtPat02 = PatternProxy( Pseq([0], 1));
		~seqNtPat03 = PatternProxy( Pseq([0], 1));
		~seqNtPat04 = PatternProxy( Pseq([0], 1));
		~seqNtPat05 = PatternProxy( Pseq([0], 1));
		~seqNtPat06 = PatternProxy( Pseq([0], 1));
		~seqNtPat07 = PatternProxy( Pseq([0], 1));
		~seqNtPat08 = PatternProxy( Pseq([0], 1));

		~seqNtPat09 = PatternProxy( Pseq([0], 1));
		~seqNtPat10 = PatternProxy( Pseq([0], 1));
		~seqNtPat11 = PatternProxy( Pseq([0], 1));
		~seqNtPat12 = PatternProxy( Pseq([0], 1));
		~seqNtPat13 = PatternProxy( Pseq([0], 1));
		~seqNtPat14 = PatternProxy( Pseq([0], 1));
		~seqNtPat15 = PatternProxy( Pseq([0], 1));
		~seqNtPat16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqNtUpPat01=0;
		~cntSeqNtRandPat01=0;

		~cntSeqNtPat01=0;
		~cntSeqNtPat02=0;
		~cntSeqNtPat03=0;
		~cntSeqNtPat04=0;
		~cntSeqNtPat05=0;
		~cntSeqNtPat06=0;
		~cntSeqNtPat07=0;
		~cntSeqNtPat08=0;

		~cntSeqNtPat09=0;
		~cntSeqNtPat10=0;
		~cntSeqNtPat11=0;
		~cntSeqNtPat12=0;
		~cntSeqNtPat13=0;
		~cntSeqNtPat14=0;
		~cntSeqNtPat15=0;
		~cntSeqNtPat16=0;
	}
	*freeOn {
		~seqFreePatBut.free;
		~seqFreePatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqNtPat.stGrp(0);
				});
			},
			'/seqFreePat'
		);

	}

	*upOn {
		~ifSeqUpPatBut.free;
		~ifSeqUpPatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtUpPat01 = ~cntSeqNtUpPat01 + 1;
				~cntSeqNtUpPat01.switch(
					0,{},
					1,{IFSeqNtPat.stGrp(0);},
					2,{IFSeqNtPat.stGrp(1);},
					3,{IFSeqNtPat.stGrp(2);},
					4,{IFSeqNtPat.stGrp(3);},
					5,{IFSeqNtPat.stGrp(4);},
					6,{IFSeqNtPat.stGrp(5);},
					7,{IFSeqNtPat.stGrp(6);},
					8,{IFSeqNtPat.stGrp(7);},
					9,{IFSeqNtPat.stGrp(8);},
					10,{IFSeqNtPat.stGrp(9);},
					11,{IFSeqNtPat.stGrp(10);},
					12,{IFSeqNtPat.stGrp(11);
						~cntSeqNtUpPat01=0;
					}
				)}
			);
			},
			'/seqUpPat'
		);
	}

	*randOn {
		~ifSeqRandPatBut.free;
		~ifSeqRandPatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtRandPat01 = ~cntSeqNtRandPat01 + 1;
				~cntSeqNtRandPat01.switch(
					0,{},
					1,{
						IFSeqNtPat.st01((0..11).choose);
						IFSeqNtPat.st02((0..11).choose);
						IFSeqNtPat.st03((0..11).choose);
						IFSeqNtPat.st04((0..11).choose);
						IFSeqNtPat.st05((0..11).choose);
						IFSeqNtPat.st06((0..11).choose);
						IFSeqNtPat.st07((0..11).choose);
						IFSeqNtPat.st08((0..11).choose);

						IFSeqNtPat.st09((0..11).choose);
						IFSeqNtPat.st10((0..11).choose);
						IFSeqNtPat.st11((0..11).choose);
						IFSeqNtPat.st12((0..11).choose);
						IFSeqNtPat.st13((0..11).choose);
						IFSeqNtPat.st14((0..11).choose);
						IFSeqNtPat.st15((0..11).choose);
						IFSeqNtPat.st16((0..11).choose);
						~cntSeqNtRandPat01=0;
					}
				)}
			);
			},
			'/seqRandPat'
		);
	}

	*on { // Shift NtAVE
		IFSeqNtPat.randOn;
		IFSeqNtPat.upOn;
		IFSeqNtPat.freeOn;

		~ifSeqPatBut01.free;
		~ifSeqPatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat01 = ~cntSeqNtPat01 + 1;
				~cntSeqNtPat01.switch(
					0,{},
					1, {IFSeqNtPat.st01(0);},
					2, {IFSeqNtPat.st01(1);},
					3, {IFSeqNtPat.st01(2);},
					4, {IFSeqNtPat.st01(3);},
					5, {IFSeqNtPat.st01(4);},
					6, {IFSeqNtPat.st01(5);},
					7, {IFSeqNtPat.st01(6);},
					8, {IFSeqNtPat.st01(7);},
					9, {IFSeqNtPat.st01(8);},
					10,{IFSeqNtPat.st01(9);},
					11,{IFSeqNtPat.st01(10);},
					12,{IFSeqNtPat.st01(11);
						~cntSeqNtPat01=0;
					}
				)}
			);
			},
			'/ifSeq/8/1'
		);
		~ifSeqPatBut02.free;
		~ifSeqPatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat02 = ~cntSeqNtPat02 + 1;
				~cntSeqNtPat02.switch(
					0,{},
					1, {IFSeqNtPat.st02(0);},
					2, {IFSeqNtPat.st02(1);},
					3, {IFSeqNtPat.st02(2);},
					4, {IFSeqNtPat.st02(3);},
					5, {IFSeqNtPat.st02(4);},
					6, {IFSeqNtPat.st02(5);},
					7, {IFSeqNtPat.st02(6);},
					8, {IFSeqNtPat.st02(7);},
					9, {IFSeqNtPat.st02(8);},
					10,{IFSeqNtPat.st02(9);},
					11,{IFSeqNtPat.st02(10);},
					12,{IFSeqNtPat.st02(11);
						~cntSeqNtPat02=0;
					}
				)}
			);
			},
			'/ifSeq/8/2'
		);
		~ifSeqPatBut03.free;
		~ifSeqPatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat03 = ~cntSeqNtPat03 + 1;
				~cntSeqNtPat03.switch(
					0,{},
					1, {IFSeqNtPat.st03(0);},
					2, {IFSeqNtPat.st03(1);},
					3, {IFSeqNtPat.st03(2);},
					4, {IFSeqNtPat.st03(3);},
					5, {IFSeqNtPat.st03(4);},
					6, {IFSeqNtPat.st03(5);},
					7, {IFSeqNtPat.st03(6);},
					8, {IFSeqNtPat.st03(7);},
					9, {IFSeqNtPat.st03(8);},
					10,{IFSeqNtPat.st03(9);},
					11,{IFSeqNtPat.st03(10);},
					12,{IFSeqNtPat.st03(11);
						~cntSeqNtPat03=0;
					}
				)}
			);
			},
			'/ifSeq/8/3'
		);
		~ifSeqPatBut04.free;
		~ifSeqPatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat04 = ~cntSeqNtPat04 + 1;
				~cntSeqNtPat04.switch(
					0,{},
					1, {IFSeqNtPat.st04(0);},
					2, {IFSeqNtPat.st04(1);},
					3, {IFSeqNtPat.st04(2);},
					4, {IFSeqNtPat.st04(3);},
					5, {IFSeqNtPat.st04(4);},
					6, {IFSeqNtPat.st04(5);},
					7, {IFSeqNtPat.st04(6);},
					8, {IFSeqNtPat.st04(7);},
					9, {IFSeqNtPat.st04(8);},
					10, {IFSeqNtPat.st04(9);},
					11,{IFSeqNtPat.st04(10);},
					12,{IFSeqNtPat.st04(11);
						~cntSeqNtPat04=0;
					}
				)}
			);
			},
			'/ifSeq/8/4'
		);
		~ifSeqPatBut05.free;
		~ifSeqPatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat05 = ~cntSeqNtPat05 + 1;
				~cntSeqNtPat05.switch(
					0,{},
					1, {IFSeqNtPat.st05(0);},
					2, {IFSeqNtPat.st05(1);},
					3, {IFSeqNtPat.st05(2);},
					4, {IFSeqNtPat.st05(3);},
					5, {IFSeqNtPat.st05(4);},
					6, {IFSeqNtPat.st05(5);},
					7, {IFSeqNtPat.st05(6);},
					8, {IFSeqNtPat.st05(7);},
					9, {IFSeqNtPat.st05(8);},
					10, {IFSeqNtPat.st05(9);},
					11,{IFSeqNtPat.st05(10);},
					12,{IFSeqNtPat.st05(11);
						~cntSeqNtPat05=0;
					}
				)}
			);
			},
			'/ifSeq/8/5'
		);
		~ifSeqPatBut06.free;
		~ifSeqPatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat06 = ~cntSeqNtPat06 + 1;
				~cntSeqNtPat06.switch(
					0,{},
					1, {IFSeqNtPat.st06(0);},
					2, {IFSeqNtPat.st06(1);},
					3, {IFSeqNtPat.st06(2);},
					4, {IFSeqNtPat.st06(3);},
					5, {IFSeqNtPat.st06(4);},
					6, {IFSeqNtPat.st06(5);},
					7, {IFSeqNtPat.st06(6);},
					8, {IFSeqNtPat.st06(7);},
					9, {IFSeqNtPat.st06(8);},
					10, {IFSeqNtPat.st06(9);},
					11,{IFSeqNtPat.st06(10);},
					12,{IFSeqNtPat.st06(11);
						~cntSeqNtPat06=0;
					}
				)}
			);
			},
			'/ifSeq/8/6'
		);
		~ifSeqPatBut07.free;
		~ifSeqPatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat07 = ~cntSeqNtPat07 + 1;
				~cntSeqNtPat07.switch(
					0,{},
					1, {IFSeqNtPat.st07(0);},
					2, {IFSeqNtPat.st07(1);},
					3, {IFSeqNtPat.st07(2);},
					4, {IFSeqNtPat.st07(3);},
					5, {IFSeqNtPat.st07(4);},
					6, {IFSeqNtPat.st07(5);},
					7, {IFSeqNtPat.st07(6);},
					8, {IFSeqNtPat.st07(7);},
					9, {IFSeqNtPat.st07(8);},
					10, {IFSeqNtPat.st07(9);},
					11,{IFSeqNtPat.st07(10);},
					12,{IFSeqNtPat.st07(11);
						~cntSeqNtPat07=0;
					}
				)}
			);
			},
			'/ifSeq/8/7'
		);
		~ifSeqPatBut08.free;
		~ifSeqPatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat08 = ~cntSeqNtPat08 + 1;
				~cntSeqNtPat08.switch(
					0,{},
					1, {IFSeqNtPat.st08(0);},
					2, {IFSeqNtPat.st08(1);},
					3, {IFSeqNtPat.st08(2);},
					4, {IFSeqNtPat.st08(3);},
					5, {IFSeqNtPat.st08(4);},
					6, {IFSeqNtPat.st08(5);},
					7, {IFSeqNtPat.st08(6);},
					8, {IFSeqNtPat.st08(7);},
					9, {IFSeqNtPat.st08(8);},
					10, {IFSeqNtPat.st08(9);},
					11,{IFSeqNtPat.st08(10);},
					12,{IFSeqNtPat.st08(11);
						~cntSeqNtPat08=0;
					}
				)}
			);
			},
			'/ifSeq/8/8'
		);

		~ifSeqPatBut09.free;
		~ifSeqPatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat09 = ~cntSeqNtPat09 + 1;
				~cntSeqNtPat09.switch(
					0,{},
					1, {IFSeqNtPat.st09(0);},
					2, {IFSeqNtPat.st09(1);},
					3, {IFSeqNtPat.st09(2);},
					4, {IFSeqNtPat.st09(3);},
					5, {IFSeqNtPat.st09(4);},
					6, {IFSeqNtPat.st09(5);},
					7, {IFSeqNtPat.st09(6);},
					8, {IFSeqNtPat.st09(7);},
					9, {IFSeqNtPat.st09(8);},
					10, {IFSeqNtPat.st09(9);},
					11,{IFSeqNtPat.st09(10);},
					12,{IFSeqNtPat.st09(11);
						~cntSeqNtPat09=0;
					}
				)}
			);
			},
			'/ifSeq/8/9'
		);
		~ifSeqPatBut10.free;
		~ifSeqPatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat10 = ~cntSeqNtPat10 + 1;
				~cntSeqNtPat10.switch(
					0,{},
					1, {IFSeqNtPat.st10(0);},
					2, {IFSeqNtPat.st10(1);},
					3, {IFSeqNtPat.st10(2);},
					4, {IFSeqNtPat.st10(3);},
					5, {IFSeqNtPat.st10(4);},
					6, {IFSeqNtPat.st10(5);},
					7, {IFSeqNtPat.st10(6);},
					8, {IFSeqNtPat.st10(7);},
					9, {IFSeqNtPat.st10(8);},
					10, {IFSeqNtPat.st10(9);},
					11,{IFSeqNtPat.st10(10);},
					12,{IFSeqNtPat.st10(11);
						~cntSeqNtPat10=0;
					}
				)}
			);
			},
			'/ifSeq/8/10'
		);
		~ifSeqPatBut11.free;
		~ifSeqPatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat11 = ~cntSeqNtPat11 + 1;
				~cntSeqNtPat11.switch(
					0,{},
					1, {IFSeqNtPat.st11(0);},
					2, {IFSeqNtPat.st11(1);},
					3, {IFSeqNtPat.st11(2);},
					4, {IFSeqNtPat.st11(3);},
					5, {IFSeqNtPat.st11(4);},
					6, {IFSeqNtPat.st11(5);},
					7, {IFSeqNtPat.st11(6);},
					8, {IFSeqNtPat.st11(7);},
					9, {IFSeqNtPat.st11(8);},
					10, {IFSeqNtPat.st11(9);},
					11,{IFSeqNtPat.st11(10);},
					12,{IFSeqNtPat.st11(11);
						~cntSeqNtPat11=0;
					}
				)}
			);
			},
			'/ifSeq/8/11'
		);
		~ifSeqPatBut12.free;
		~ifSeqPatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat12 = ~cntSeqNtPat12 + 1;
				~cntSeqNtPat12.switch(
					0,{},
					1, {IFSeqNtPat.st12(0);},
					2, {IFSeqNtPat.st12(1);},
					3, {IFSeqNtPat.st12(2);},
					4, {IFSeqNtPat.st12(3);},
					5, {IFSeqNtPat.st12(4);},
					6, {IFSeqNtPat.st12(5);},
					7, {IFSeqNtPat.st12(6);},
					8, {IFSeqNtPat.st12(7);},
					9, {IFSeqNtPat.st12(8);},
					10, {IFSeqNtPat.st12(9);},
					11,{IFSeqNtPat.st12(10);},
					12,{IFSeqNtPat.st12(11);
						~cntSeqNtPat12=0;
					}
				)}
			);
			},
			'/ifSeq/8/12'
		);
		~ifSeqPatBut13.free;
		~ifSeqPatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat13 = ~cntSeqNtPat13 + 1;
				~cntSeqNtPat13.switch(
					0,{},
					1, {IFSeqNtPat.st13(0);},
					2, {IFSeqNtPat.st13(1);},
					3, {IFSeqNtPat.st13(2);},
					4, {IFSeqNtPat.st13(3);},
					5, {IFSeqNtPat.st13(4);},
					6, {IFSeqNtPat.st13(5);},
					7, {IFSeqNtPat.st13(6);},
					8, {IFSeqNtPat.st13(7);},
					9, {IFSeqNtPat.st13(8);},
					10, {IFSeqNtPat.st13(9);},
					11,{IFSeqNtPat.st13(10);},
					12,{IFSeqNtPat.st13(11);
						~cntSeqNtPat13=0;
					}
				)}
			);
			},
			'/ifSeq/8/13'
		);
		~ifSeqPatBut14.free;
		~ifSeqPatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat14 = ~cntSeqNtPat14 + 1;
				~cntSeqNtPat14.switch(
					0,{},
					1, {IFSeqNtPat.st14(0);},
					2, {IFSeqNtPat.st14(1);},
					3, {IFSeqNtPat.st14(2);},
					4, {IFSeqNtPat.st14(3);},
					5, {IFSeqNtPat.st14(4);},
					6, {IFSeqNtPat.st14(5);},
					7, {IFSeqNtPat.st14(6);},
					8, {IFSeqNtPat.st14(7);},
					9, {IFSeqNtPat.st14(8);},
					10, {IFSeqNtPat.st14(9);},
					11,{IFSeqNtPat.st14(10);},
					12,{IFSeqNtPat.st14(11);
						~cntSeqNtPat14=0;
					}
				)}
			);
			},
			'/ifSeq/8/14'
		);
		~ifSeqPatBut15.free;
		~ifSeqPatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat15 = ~cntSeqNtPat15 + 1;
				~cntSeqNtPat15.switch(
					0,{},
					1, {IFSeqNtPat.st15(0);},
					2, {IFSeqNtPat.st15(1);},
					3, {IFSeqNtPat.st15(2);},
					4, {IFSeqNtPat.st15(3);},
					5, {IFSeqNtPat.st15(4);},
					6, {IFSeqNtPat.st15(5);},
					7, {IFSeqNtPat.st15(6);},
					8, {IFSeqNtPat.st15(7);},
					9, {IFSeqNtPat.st15(8);},
					10, {IFSeqNtPat.st15(9);},
					11,{IFSeqNtPat.st15(10);},
					12,{IFSeqNtPat.st15(11);
						~cntSeqNtPat15=0;
					}
				)}
			);
			},
			'/ifSeq/8/15'
		);
		~ifSeqPatBut16.free;
		~ifSeqPatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtPat16 = ~cntSeqNtPat16 + 1;
				~cntSeqNtPat16.switch(
					0,{},
					1, {IFSeqNtPat.st16(0);},
					2, {IFSeqNtPat.st16(1);},
					3, {IFSeqNtPat.st16(2);},
					4, {IFSeqNtPat.st16(3);},
					5, {IFSeqNtPat.st16(4);},
					6, {IFSeqNtPat.st16(5);},
					7, {IFSeqNtPat.st16(6);},
					8, {IFSeqNtPat.st16(7);},
					9, {IFSeqNtPat.st16(8);},
					10, {IFSeqNtPat.st16(9);},
					11,{IFSeqNtPat.st16(10);},
					12,{IFSeqNtPat.st16(11);
						~cntSeqNtPat16=0;
					}
				)}
			);
			},
			'/ifSeq/8/16'
		);

	}//

	*st01 {|i=0|
		~seqNtPat01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat01', i);
	}
	*st02 {|i=0|
		~seqNtPat02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat02', i);
	}
	*st03 {|i=0|
		~seqNtPat03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat03', i);
	}
	*st04 {|i=0|
		~seqNtPat04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat04', i);
	}
	*st05 {|i=0|
		~seqNtPat05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat05', i);
	}
	*st06 {|i=0|
		~seqNtPat06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat06', i);
	}
	*st07 {|i=0|
		~seqNtPat07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat07', i);
	}
	*st08 {|i=0|
		~seqNtPat08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat08', i);
	}

	*st09 {|i=0|
		~seqNtPat09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat09', i);
	}
	*st10 {|i=0|
		~seqNtPat10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat10', i);
	}
	*st11 {|i=0|
		~seqNtPat11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat11', i);
	}
	*st12 {|i=0|
		~seqNtPat12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat12', i);
	}
	*st13 {|i=0|
		~seqNtPat13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat13', i);
	}
	*st14 {|i=0|
		~seqNtPat14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat14', i);
	}
	*st15 {|i=0|
		~seqNtPat15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat15', i);
	}
	*st16 {|i=0|
		~seqNtPat16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtPat16', i);
	}
	*stGrp {|i|

		IFSeqNtPat.st01(i); IFSeqNtPat.st02(i); IFSeqNtPat.st03(i); IFSeqNtPat.st04(i);
		IFSeqNtPat.st05(i); IFSeqNtPat.st06(i); IFSeqNtPat.st07(i); IFSeqNtPat.st08(i);
		IFSeqNtPat.st09(i); IFSeqNtPat.st10(i); IFSeqNtPat.st11(i); IFSeqNtPat.st12(i);
		IFSeqNtPat.st13(i); IFSeqNtPat.st14(i); IFSeqNtPat.st15(i); IFSeqNtPat.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqNtPat.st01(s01); IFSeqNtPat.st02(s02); IFSeqNtPat.st03(s03); IFSeqNtPat.st04(s04);
		IFSeqNtPat.st05(s05); IFSeqNtPat.st06(s06); IFSeqNtPat.st07(s07); IFSeqNtPat.st08(s08);
		IFSeqNtPat.st09(s09); IFSeqNtPat.st10(s10); IFSeqNtPat.st11(s11); IFSeqNtPat.st12(s12);
		IFSeqNtPat.st13(s13); IFSeqNtPat.st14(s14); IFSeqNtPat.st15(s15); IFSeqNtPat.st16(s16);
	}
}