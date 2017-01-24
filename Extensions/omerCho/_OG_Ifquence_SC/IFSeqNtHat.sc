IFSeqNtHat {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqNtHat01 = PatternProxy( Pseq([0], 1));
		~seqNtHat02 = PatternProxy( Pseq([0], 1));
		~seqNtHat03 = PatternProxy( Pseq([0], 1));
		~seqNtHat04 = PatternProxy( Pseq([0], 1));
		~seqNtHat05 = PatternProxy( Pseq([0], 1));
		~seqNtHat06 = PatternProxy( Pseq([0], 1));
		~seqNtHat07 = PatternProxy( Pseq([0], 1));
		~seqNtHat08 = PatternProxy( Pseq([0], 1));

		~seqNtHat09 = PatternProxy( Pseq([0], 1));
		~seqNtHat10 = PatternProxy( Pseq([0], 1));
		~seqNtHat11 = PatternProxy( Pseq([0], 1));
		~seqNtHat12 = PatternProxy( Pseq([0], 1));
		~seqNtHat13 = PatternProxy( Pseq([0], 1));
		~seqNtHat14 = PatternProxy( Pseq([0], 1));
		~seqNtHat15 = PatternProxy( Pseq([0], 1));
		~seqNtHat16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqNtUpHat01=0;
		~cntSeqNtRandHat01=0;

		~cntSeqNtHat01=0;
		~cntSeqNtHat02=0;
		~cntSeqNtHat03=0;
		~cntSeqNtHat04=0;
		~cntSeqNtHat05=0;
		~cntSeqNtHat06=0;
		~cntSeqNtHat07=0;
		~cntSeqNtHat08=0;

		~cntSeqNtHat09=0;
		~cntSeqNtHat10=0;
		~cntSeqNtHat11=0;
		~cntSeqNtHat12=0;
		~cntSeqNtHat13=0;
		~cntSeqNtHat14=0;
		~cntSeqNtHat15=0;
		~cntSeqNtHat16=0;
	}
	*freeOn {
		~seqFreeHatBut.free;
		~seqFreeHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqNtHat.stGrp(0);
				});
			},
			'/seqFreeHat'
		);

	}

	*upOn {
		~ifSeqUpHatBut.free;
		~ifSeqUpHatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtUpHat01 = ~cntSeqNtUpHat01 + 1;
				~cntSeqNtUpHat01.switch(
					0,{},
					1,{IFSeqNtHat.stGrp(0);},
					2,{IFSeqNtHat.stGrp(1);},
					3,{IFSeqNtHat.stGrp(2);},
					4,{IFSeqNtHat.stGrp(3);},
					5,{IFSeqNtHat.stGrp(4);},
					6,{IFSeqNtHat.stGrp(5);},
					7,{IFSeqNtHat.stGrp(6);},
					8,{IFSeqNtHat.stGrp(7);},
					9,{IFSeqNtHat.stGrp(8);},
					10,{IFSeqNtHat.stGrp(9);},
					11,{IFSeqNtHat.stGrp(10);},
					12,{IFSeqNtHat.stGrp(11);
						~cntSeqNtUpHat01=0;
					}
				)}
			);
			},
			'/seqUpHat'
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
						IFSeqNtHat.st01((0..11).choose);
						IFSeqNtHat.st02((0..11).choose);
						IFSeqNtHat.st03((0..11).choose);
						IFSeqNtHat.st04((0..11).choose);
						IFSeqNtHat.st05((0..11).choose);
						IFSeqNtHat.st06((0..11).choose);
						IFSeqNtHat.st07((0..11).choose);
						IFSeqNtHat.st08((0..11).choose);

						IFSeqNtHat.st09((0..11).choose);
						IFSeqNtHat.st10((0..11).choose);
						IFSeqNtHat.st11((0..11).choose);
						IFSeqNtHat.st12((0..11).choose);
						IFSeqNtHat.st13((0..11).choose);
						IFSeqNtHat.st14((0..11).choose);
						IFSeqNtHat.st15((0..11).choose);
						IFSeqNtHat.st16((0..11).choose);
						~cntSeqNtRandHat01=0;
					}
				)}
			);
			},
			'/seqRandHat'
		);
	}

	*on { // Shift NtAVE
		IFSeqNtHat.randOn;
		IFSeqNtHat.upOn;
		IFSeqNtHat.freeOn;

		~ifSeqHatBut01.free;
		~ifSeqHatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat01 = ~cntSeqNtHat01 + 1;
				~cntSeqNtHat01.switch(
					0,{},
					1, {IFSeqNtHat.st01(0);},
					2, {IFSeqNtHat.st01(1);},
					3, {IFSeqNtHat.st01(2);},
					4, {IFSeqNtHat.st01(3);},
					5, {IFSeqNtHat.st01(4);},
					6, {IFSeqNtHat.st01(5);},
					7, {IFSeqNtHat.st01(6);},
					8, {IFSeqNtHat.st01(7);},
					9, {IFSeqNtHat.st01(8);},
					10,{IFSeqNtHat.st01(9);},
					11,{IFSeqNtHat.st01(10);},
					12,{IFSeqNtHat.st01(11);
						~cntSeqNtHat01=0;
					}
				)}
			);
			},
			'/ifSeq/3/1'
		);
		~ifSeqHatBut02.free;
		~ifSeqHatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat02 = ~cntSeqNtHat02 + 1;
				~cntSeqNtHat02.switch(
					0,{},
					1, {IFSeqNtHat.st02(0);},
					2, {IFSeqNtHat.st02(1);},
					3, {IFSeqNtHat.st02(2);},
					4, {IFSeqNtHat.st02(3);},
					5, {IFSeqNtHat.st02(4);},
					6, {IFSeqNtHat.st02(5);},
					7, {IFSeqNtHat.st02(6);},
					8, {IFSeqNtHat.st02(7);},
					9, {IFSeqNtHat.st02(8);},
					10, {IFSeqNtHat.st02(9);},
					11,{IFSeqNtHat.st02(10);},
					12,{IFSeqNtHat.st02(11);
						~cntSeqNtHat02=0;
					}
				)}
			);
			},
			'/ifSeq/3/2'
		);
		~ifSeqHatBut03.free;
		~ifSeqHatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat03 = ~cntSeqNtHat03 + 1;
				~cntSeqNtHat03.switch(
					0,{},
					1, {IFSeqNtHat.st03(0);},
					2, {IFSeqNtHat.st03(1);},
					3, {IFSeqNtHat.st03(2);},
					4, {IFSeqNtHat.st03(3);},
					5, {IFSeqNtHat.st03(4);},
					6, {IFSeqNtHat.st03(5);},
					7, {IFSeqNtHat.st03(6);},
					8, {IFSeqNtHat.st03(7);},
					9, {IFSeqNtHat.st03(8);},
					10, {IFSeqNtHat.st03(9);},
					11,{IFSeqNtHat.st03(10);},
					12,{IFSeqNtHat.st03(11);
						~cntSeqNtHat03=0;
					}
				)}
			);
			},
			'/ifSeq/3/3'
		);
		~ifSeqHatBut04.free;
		~ifSeqHatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat04 = ~cntSeqNtHat04 + 1;
				~cntSeqNtHat04.switch(
					0,{},
					1, {IFSeqNtHat.st04(0);},
					2, {IFSeqNtHat.st04(1);},
					3, {IFSeqNtHat.st04(2);},
					4, {IFSeqNtHat.st04(3);},
					5, {IFSeqNtHat.st04(4);},
					6, {IFSeqNtHat.st04(5);},
					7, {IFSeqNtHat.st04(6);},
					8, {IFSeqNtHat.st04(7);},
					9, {IFSeqNtHat.st04(8);},
					10, {IFSeqNtHat.st04(9);},
					11,{IFSeqNtHat.st04(10);},
					12,{IFSeqNtHat.st04(11);
						~cntSeqNtHat04=0;
					}
				)}
			);
			},
			'/ifSeq/3/4'
		);
		~ifSeqHatBut05.free;
		~ifSeqHatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat05 = ~cntSeqNtHat05 + 1;
				~cntSeqNtHat05.switch(
					0,{},
					1, {IFSeqNtHat.st05(0);},
					2, {IFSeqNtHat.st05(1);},
					3, {IFSeqNtHat.st05(2);},
					4, {IFSeqNtHat.st05(3);},
					5, {IFSeqNtHat.st05(4);},
					6, {IFSeqNtHat.st05(5);},
					7, {IFSeqNtHat.st05(6);},
					8, {IFSeqNtHat.st05(7);},
					9, {IFSeqNtHat.st05(8);},
					10, {IFSeqNtHat.st05(9);},
					11,{IFSeqNtHat.st05(10);},
					12,{IFSeqNtHat.st05(11);
						~cntSeqNtHat05=0;
					}
				)}
			);
			},
			'/ifSeq/3/5'
		);
		~ifSeqHatBut06.free;
		~ifSeqHatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat06 = ~cntSeqNtHat06 + 1;
				~cntSeqNtHat06.switch(
					0,{},
					1, {IFSeqNtHat.st06(0);},
					2, {IFSeqNtHat.st06(1);},
					3, {IFSeqNtHat.st06(2);},
					4, {IFSeqNtHat.st06(3);},
					5, {IFSeqNtHat.st06(4);},
					6, {IFSeqNtHat.st06(5);},
					7, {IFSeqNtHat.st06(6);},
					8, {IFSeqNtHat.st06(7);},
					9, {IFSeqNtHat.st06(8);},
					10, {IFSeqNtHat.st06(9);},
					11,{IFSeqNtHat.st06(10);},
					12,{IFSeqNtHat.st06(11);
						~cntSeqNtHat06=0;
					}
				)}
			);
			},
			'/ifSeq/3/6'
		);
		~ifSeqHatBut07.free;
		~ifSeqHatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat07 = ~cntSeqNtHat07 + 1;
				~cntSeqNtHat07.switch(
					0,{},
					1, {IFSeqNtHat.st07(0);},
					2, {IFSeqNtHat.st07(1);},
					3, {IFSeqNtHat.st07(2);},
					4, {IFSeqNtHat.st07(3);},
					5, {IFSeqNtHat.st07(4);},
					6, {IFSeqNtHat.st07(5);},
					7, {IFSeqNtHat.st07(6);},
					8, {IFSeqNtHat.st07(7);},
					9, {IFSeqNtHat.st07(8);},
					10, {IFSeqNtHat.st07(9);},
					11,{IFSeqNtHat.st07(10);},
					12,{IFSeqNtHat.st07(11);
						~cntSeqNtHat07=0;
					}
				)}
			);
			},
			'/ifSeq/3/7'
		);
		~ifSeqHatBut08.free;
		~ifSeqHatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat08 = ~cntSeqNtHat08 + 1;
				~cntSeqNtHat08.switch(
					0,{},
					1, {IFSeqNtHat.st08(0);},
					2, {IFSeqNtHat.st08(1);},
					3, {IFSeqNtHat.st08(2);},
					4, {IFSeqNtHat.st08(3);},
					5, {IFSeqNtHat.st08(4);},
					6, {IFSeqNtHat.st08(5);},
					7, {IFSeqNtHat.st08(6);},
					8, {IFSeqNtHat.st08(7);},
					9, {IFSeqNtHat.st08(8);},
					10, {IFSeqNtHat.st08(9);},
					11,{IFSeqNtHat.st08(10);},
					12,{IFSeqNtHat.st08(11);
						~cntSeqNtHat08=0;
					}
				)}
			);
			},
			'/ifSeq/3/8'
		);

		~ifSeqHatBut09.free;
		~ifSeqHatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat09 = ~cntSeqNtHat09 + 1;
				~cntSeqNtHat09.switch(
					0,{},
					1, {IFSeqNtHat.st09(0);},
					2, {IFSeqNtHat.st09(1);},
					3, {IFSeqNtHat.st09(2);},
					4, {IFSeqNtHat.st09(3);},
					5, {IFSeqNtHat.st09(4);},
					6, {IFSeqNtHat.st09(5);},
					7, {IFSeqNtHat.st09(6);},
					8, {IFSeqNtHat.st09(7);},
					9, {IFSeqNtHat.st09(8);},
					10, {IFSeqNtHat.st09(9);},
					11,{IFSeqNtHat.st09(10);},
					12,{IFSeqNtHat.st09(11);
						~cntSeqNtHat09=0;
					}
				)}
			);
			},
			'/ifSeq/3/9'
		);
		~ifSeqHatBut10.free;
		~ifSeqHatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat10 = ~cntSeqNtHat10 + 1;
				~cntSeqNtHat10.switch(
					0,{},
					1, {IFSeqNtHat.st10(0);},
					2, {IFSeqNtHat.st10(1);},
					3, {IFSeqNtHat.st10(2);},
					4, {IFSeqNtHat.st10(3);},
					5, {IFSeqNtHat.st10(4);},
					6, {IFSeqNtHat.st10(5);},
					7, {IFSeqNtHat.st10(6);},
					8, {IFSeqNtHat.st10(7);},
					9, {IFSeqNtHat.st10(8);},
					10, {IFSeqNtHat.st10(9);},
					11,{IFSeqNtHat.st10(10);},
					12,{IFSeqNtHat.st10(11);
						~cntSeqNtHat10=0;
					}
				)}
			);
			},
			'/ifSeq/3/10'
		);
		~ifSeqHatBut11.free;
		~ifSeqHatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat11 = ~cntSeqNtHat11 + 1;
				~cntSeqNtHat11.switch(
					0,{},
					1, {IFSeqNtHat.st11(0);},
					2, {IFSeqNtHat.st11(1);},
					3, {IFSeqNtHat.st11(2);},
					4, {IFSeqNtHat.st11(3);},
					5, {IFSeqNtHat.st11(4);},
					6, {IFSeqNtHat.st11(5);},
					7, {IFSeqNtHat.st11(6);},
					8, {IFSeqNtHat.st11(7);},
					9, {IFSeqNtHat.st11(8);},
					10, {IFSeqNtHat.st11(9);},
					11,{IFSeqNtHat.st11(10);},
					12,{IFSeqNtHat.st11(11);
						~cntSeqNtHat11=0;
					}
				)}
			);
			},
			'/ifSeq/3/11'
		);
		~ifSeqHatBut12.free;
		~ifSeqHatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat12 = ~cntSeqNtHat12 + 1;
				~cntSeqNtHat12.switch(
					0,{},
					1, {IFSeqNtHat.st12(0);},
					2, {IFSeqNtHat.st12(1);},
					3, {IFSeqNtHat.st12(2);},
					4, {IFSeqNtHat.st12(3);},
					5, {IFSeqNtHat.st12(4);},
					6, {IFSeqNtHat.st12(5);},
					7, {IFSeqNtHat.st12(6);},
					8, {IFSeqNtHat.st12(7);},
					9, {IFSeqNtHat.st12(8);},
					10, {IFSeqNtHat.st12(9);},
					11,{IFSeqNtHat.st12(10);},
					12,{IFSeqNtHat.st12(11);
						~cntSeqNtHat12=0;
					}
				)}
			);
			},
			'/ifSeq/3/12'
		);
		~ifSeqHatBut13.free;
		~ifSeqHatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat13 = ~cntSeqNtHat13 + 1;
				~cntSeqNtHat13.switch(
					0,{},
					1, {IFSeqNtHat.st13(0);},
					2, {IFSeqNtHat.st13(1);},
					3, {IFSeqNtHat.st13(2);},
					4, {IFSeqNtHat.st13(3);},
					5, {IFSeqNtHat.st13(4);},
					6, {IFSeqNtHat.st13(5);},
					7, {IFSeqNtHat.st13(6);},
					8, {IFSeqNtHat.st13(7);},
					9, {IFSeqNtHat.st13(8);},
					10, {IFSeqNtHat.st13(9);},
					11,{IFSeqNtHat.st13(10);},
					12,{IFSeqNtHat.st13(11);
						~cntSeqNtHat13=0;
					}
				)}
			);
			},
			'/ifSeq/3/13'
		);
		~ifSeqHatBut14.free;
		~ifSeqHatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat14 = ~cntSeqNtHat14 + 1;
				~cntSeqNtHat14.switch(
					0,{},
					1, {IFSeqNtHat.st14(0);},
					2, {IFSeqNtHat.st14(1);},
					3, {IFSeqNtHat.st14(2);},
					4, {IFSeqNtHat.st14(3);},
					5, {IFSeqNtHat.st14(4);},
					6, {IFSeqNtHat.st14(5);},
					7, {IFSeqNtHat.st14(6);},
					8, {IFSeqNtHat.st14(7);},
					9, {IFSeqNtHat.st14(8);},
					10, {IFSeqNtHat.st14(9);},
					11,{IFSeqNtHat.st14(10);},
					12,{IFSeqNtHat.st14(11);
						~cntSeqNtHat14=0;
					}
				)}
			);
			},
			'/ifSeq/3/14'
		);
		~ifSeqHatBut15.free;
		~ifSeqHatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat15 = ~cntSeqNtHat15 + 1;
				~cntSeqNtHat15.switch(
					0,{},
					1, {IFSeqNtHat.st15(0);},
					2, {IFSeqNtHat.st15(1);},
					3, {IFSeqNtHat.st15(2);},
					4, {IFSeqNtHat.st15(3);},
					5, {IFSeqNtHat.st15(4);},
					6, {IFSeqNtHat.st15(5);},
					7, {IFSeqNtHat.st15(6);},
					8, {IFSeqNtHat.st15(7);},
					9, {IFSeqNtHat.st15(8);},
					10, {IFSeqNtHat.st15(9);},
					11,{IFSeqNtHat.st15(10);},
					12,{IFSeqNtHat.st15(11);
						~cntSeqNtHat15=0;
					}
				)}
			);
			},
			'/ifSeq/3/15'
		);
		~ifSeqHatBut16.free;
		~ifSeqHatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtHat16 = ~cntSeqNtHat16 + 1;
				~cntSeqNtHat16.switch(
					0,{},
					1, {IFSeqNtHat.st16(0);},
					2, {IFSeqNtHat.st16(1);},
					3, {IFSeqNtHat.st16(2);},
					4, {IFSeqNtHat.st16(3);},
					5, {IFSeqNtHat.st16(4);},
					6, {IFSeqNtHat.st16(5);},
					7, {IFSeqNtHat.st16(6);},
					8, {IFSeqNtHat.st16(7);},
					9, {IFSeqNtHat.st16(8);},
					10, {IFSeqNtHat.st16(9);},
					11,{IFSeqNtHat.st16(10);},
					12,{IFSeqNtHat.st16(11);
						~cntSeqNtHat16=0;
					}
				)}
			);
			},
			'/ifSeq/3/16'
		);

	}//

	*st01 {|i=0|
		~seqNtHat01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat01', i);
	}
	*st02 {|i=0|
		~seqNtHat02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat02', i);
	}
	*st03 {|i=0|
		~seqNtHat03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat03', i);
	}
	*st04 {|i=0|
		~seqNtHat04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat04', i);
	}
	*st05 {|i=0|
		~seqNtHat05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat05', i);
	}
	*st06 {|i=0|
		~seqNtHat06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat06', i);
	}
	*st07 {|i=0|
		~seqNtHat07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat07', i);
	}
	*st08 {|i=0|
		~seqNtHat08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat08', i);
	}

	*st09 {|i=0|
		~seqNtHat09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat09', i);
	}
	*st10 {|i=0|
		~seqNtHat10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat10', i);
	}
	*st11 {|i=0|
		~seqNtHat11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat11', i);
	}
	*st12 {|i=0|
		~seqNtHat12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat12', i);
	}
	*st13 {|i=0|
		~seqNtHat13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat13', i);
	}
	*st14 {|i=0|
		~seqNtHat14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat14', i);
	}
	*st15 {|i=0|
		~seqNtHat15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat15', i);
	}
	*st16 {|i=0|
		~seqNtHat16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtHat16', i);
	}
	*stGrp {|i|

		IFSeqNtHat.st01(i); IFSeqNtHat.st02(i); IFSeqNtHat.st03(i); IFSeqNtHat.st04(i);
		IFSeqNtHat.st05(i); IFSeqNtHat.st06(i); IFSeqNtHat.st07(i); IFSeqNtHat.st08(i);
		IFSeqNtHat.st09(i); IFSeqNtHat.st10(i); IFSeqNtHat.st11(i); IFSeqNtHat.st12(i);
		IFSeqNtHat.st13(i); IFSeqNtHat.st14(i); IFSeqNtHat.st15(i); IFSeqNtHat.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqNtHat.st01(s01); IFSeqNtHat.st02(s02); IFSeqNtHat.st03(s03); IFSeqNtHat.st04(s04);
		IFSeqNtHat.st05(s05); IFSeqNtHat.st06(s06); IFSeqNtHat.st07(s07); IFSeqNtHat.st08(s08);
		IFSeqNtHat.st09(s09); IFSeqNtHat.st10(s10); IFSeqNtHat.st11(s11); IFSeqNtHat.st12(s12);
		IFSeqNtHat.st13(s13); IFSeqNtHat.st14(s14); IFSeqNtHat.st15(s15); IFSeqNtHat.st16(s16);
	}
}