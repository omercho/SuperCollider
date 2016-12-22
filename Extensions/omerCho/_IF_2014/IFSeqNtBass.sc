IFSeqNtBass {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqNtBass01 = PatternProxy( Pseq([0], 1));
		~seqNtBass02 = PatternProxy( Pseq([0], 1));
		~seqNtBass03 = PatternProxy( Pseq([0], 1));
		~seqNtBass04 = PatternProxy( Pseq([0], 1));
		~seqNtBass05 = PatternProxy( Pseq([0], 1));
		~seqNtBass06 = PatternProxy( Pseq([0], 1));
		~seqNtBass07 = PatternProxy( Pseq([0], 1));
		~seqNtBass08 = PatternProxy( Pseq([0], 1));

		~seqNtBass09 = PatternProxy( Pseq([0], 1));
		~seqNtBass10 = PatternProxy( Pseq([0], 1));
		~seqNtBass11 = PatternProxy( Pseq([0], 1));
		~seqNtBass12 = PatternProxy( Pseq([0], 1));
		~seqNtBass13 = PatternProxy( Pseq([0], 1));
		~seqNtBass14 = PatternProxy( Pseq([0], 1));
		~seqNtBass15 = PatternProxy( Pseq([0], 1));
		~seqNtBass16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqNtUpBass01=0;
		~cntSeqNtRandBass01=0;

		~cntSeqNtBass01=0;
		~cntSeqNtBass02=0;
		~cntSeqNtBass03=0;
		~cntSeqNtBass04=0;
		~cntSeqNtBass05=0;
		~cntSeqNtBass06=0;
		~cntSeqNtBass07=0;
		~cntSeqNtBass08=0;

		~cntSeqNtBass09=0;
		~cntSeqNtBass10=0;
		~cntSeqNtBass11=0;
		~cntSeqNtBass12=0;
		~cntSeqNtBass13=0;
		~cntSeqNtBass14=0;
		~cntSeqNtBass15=0;
		~cntSeqNtBass16=0;
	}
	*freeOn {
		~seqFreeBassBut.free;
		~seqFreeBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqNtBass.stGrp(0);
				});
			},
			'/seqFreeBass'
		);

	}

	*upOn {
		~ifSeqUpBassBut.free;
		~ifSeqUpBassBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtUpBass01 = ~cntSeqNtUpBass01 + 1;
				~cntSeqNtUpBass01.switch(
					0,{},
					1,{IFSeqNtBass.stGrp(0);},
					2,{IFSeqNtBass.stGrp(1);},
					3,{IFSeqNtBass.stGrp(2);},
					4,{IFSeqNtBass.stGrp(3);},
					5,{IFSeqNtBass.stGrp(4);},
					6,{IFSeqNtBass.stGrp(5);},
					7,{IFSeqNtBass.stGrp(6);},
					8,{IFSeqNtBass.stGrp(7);},
					9,{IFSeqNtBass.stGrp(8);},
					10,{IFSeqNtBass.stGrp(9);},
					11,{IFSeqNtBass.stGrp(10);},
					12,{IFSeqNtBass.stGrp(11);
						~cntSeqNtUpBass01=0;
					}
				)}
			);
			},
			'/seqUpBass'
		);
	}

	*randOn {
		~ifSeqRandBassBut.free;
		~ifSeqRandBassBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtRandBass01 = ~cntSeqNtRandBass01 + 1;
				~cntSeqNtRandBass01.switch(
					0,{},
					1,{
						IFSeqNtBass.st01((0..11).choose);
						IFSeqNtBass.st02((0..11).choose);
						IFSeqNtBass.st03((0..11).choose);
						IFSeqNtBass.st04((0..11).choose);
						IFSeqNtBass.st05((0..11).choose);
						IFSeqNtBass.st06((0..11).choose);
						IFSeqNtBass.st07((0..11).choose);
						IFSeqNtBass.st08((0..11).choose);

						IFSeqNtBass.st09((0..11).choose);
						IFSeqNtBass.st10((0..11).choose);
						IFSeqNtBass.st11((0..11).choose);
						IFSeqNtBass.st12((0..11).choose);
						IFSeqNtBass.st13((0..11).choose);
						IFSeqNtBass.st14((0..11).choose);
						IFSeqNtBass.st15((0..11).choose);
						IFSeqNtBass.st16((0..11).choose);
						~cntSeqNtRandBass01=0;
					}
				)}
			);
			},
			'/seqRandBass'
		);
	}

	*on { // Shift NtAVE
		IFSeqNtBass.randOn;
		IFSeqNtBass.upOn;
		IFSeqNtBass.freeOn;

		~ifSeqBassBut01.free;
		~ifSeqBassBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass01 = ~cntSeqNtBass01 + 1;
				~cntSeqNtBass01.switch(
					0,{},
					1, {IFSeqNtBass.st01(0);},
					2, {IFSeqNtBass.st01(1);},
					3, {IFSeqNtBass.st01(2);},
					4, {IFSeqNtBass.st01(3);},
					5, {IFSeqNtBass.st01(4);},
					6, {IFSeqNtBass.st01(5);},
					7, {IFSeqNtBass.st01(6);},
					8, {IFSeqNtBass.st01(7);},
					9, {IFSeqNtBass.st01(8);},
					10,{IFSeqNtBass.st01(9);},
					11,{IFSeqNtBass.st01(10);},
					12,{IFSeqNtBass.st01(11);
						~cntSeqNtBass01=0;
					}
				)}
			);
			},
			'/ifSeq/4/1'
		);
		~ifSeqBassBut02.free;
		~ifSeqBassBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass02 = ~cntSeqNtBass02 + 1;
				~cntSeqNtBass02.switch(
					0,{},
					1, {IFSeqNtBass.st02(0);},
					2, {IFSeqNtBass.st02(1);},
					3, {IFSeqNtBass.st02(2);},
					4, {IFSeqNtBass.st02(3);},
					5, {IFSeqNtBass.st02(4);},
					6, {IFSeqNtBass.st02(5);},
					7, {IFSeqNtBass.st02(6);},
					8, {IFSeqNtBass.st02(7);},
					9, {IFSeqNtBass.st02(8);},
					10, {IFSeqNtBass.st02(9);},
					11,{IFSeqNtBass.st02(10);},
					12,{IFSeqNtBass.st02(11);
						~cntSeqNtBass02=0;
					}
				)}
			);
			},
			'/ifSeq/4/2'
		);
		~ifSeqBassBut03.free;
		~ifSeqBassBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass03 = ~cntSeqNtBass03 + 1;
				~cntSeqNtBass03.switch(
					0,{},
					1, {IFSeqNtBass.st03(0);},
					2, {IFSeqNtBass.st03(1);},
					3, {IFSeqNtBass.st03(2);},
					4, {IFSeqNtBass.st03(3);},
					5, {IFSeqNtBass.st03(4);},
					6, {IFSeqNtBass.st03(5);},
					7, {IFSeqNtBass.st03(6);},
					8, {IFSeqNtBass.st03(7);},
					9, {IFSeqNtBass.st03(8);},
					10, {IFSeqNtBass.st03(9);},
					11,{IFSeqNtBass.st03(10);},
					12,{IFSeqNtBass.st03(11);
						~cntSeqNtBass03=0;
					}
				)}
			);
			},
			'/ifSeq/4/3'
		);
		~ifSeqBassBut04.free;
		~ifSeqBassBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass04 = ~cntSeqNtBass04 + 1;
				~cntSeqNtBass04.switch(
					0,{},
					1, {IFSeqNtBass.st04(0);},
					2, {IFSeqNtBass.st04(1);},
					3, {IFSeqNtBass.st04(2);},
					4, {IFSeqNtBass.st04(3);},
					5, {IFSeqNtBass.st04(4);},
					6, {IFSeqNtBass.st04(5);},
					7, {IFSeqNtBass.st04(6);},
					8, {IFSeqNtBass.st04(7);},
					9, {IFSeqNtBass.st04(8);},
					10, {IFSeqNtBass.st04(9);},
					11,{IFSeqNtBass.st04(10);},
					12,{IFSeqNtBass.st04(11);
						~cntSeqNtBass04=0;
					}
				)}
			);
			},
			'/ifSeq/4/4'
		);
		~ifSeqBassBut05.free;
		~ifSeqBassBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass05 = ~cntSeqNtBass05 + 1;
				~cntSeqNtBass05.switch(
					0,{},
					1, {IFSeqNtBass.st05(0);},
					2, {IFSeqNtBass.st05(1);},
					3, {IFSeqNtBass.st05(2);},
					4, {IFSeqNtBass.st05(3);},
					5, {IFSeqNtBass.st05(4);},
					6, {IFSeqNtBass.st05(5);},
					7, {IFSeqNtBass.st05(6);},
					8, {IFSeqNtBass.st05(7);},
					9, {IFSeqNtBass.st05(8);},
					10, {IFSeqNtBass.st05(9);},
					11,{IFSeqNtBass.st05(10);},
					12,{IFSeqNtBass.st05(11);
						~cntSeqNtBass05=0;
					}
				)}
			);
			},
			'/ifSeq/4/5'
		);
		~ifSeqBassBut06.free;
		~ifSeqBassBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass06 = ~cntSeqNtBass06 + 1;
				~cntSeqNtBass06.switch(
					0,{},
					1, {IFSeqNtBass.st06(0);},
					2, {IFSeqNtBass.st06(1);},
					3, {IFSeqNtBass.st06(2);},
					4, {IFSeqNtBass.st06(3);},
					5, {IFSeqNtBass.st06(4);},
					6, {IFSeqNtBass.st06(5);},
					7, {IFSeqNtBass.st06(6);},
					8, {IFSeqNtBass.st06(7);},
					9, {IFSeqNtBass.st06(8);},
					10, {IFSeqNtBass.st06(9);},
					11,{IFSeqNtBass.st06(10);},
					12,{IFSeqNtBass.st06(11);
						~cntSeqNtBass06=0;
					}
				)}
			);
			},
			'/ifSeq/4/6'
		);
		~ifSeqBassBut07.free;
		~ifSeqBassBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass07 = ~cntSeqNtBass07 + 1;
				~cntSeqNtBass07.switch(
					0,{},
					1, {IFSeqNtBass.st07(0);},
					2, {IFSeqNtBass.st07(1);},
					3, {IFSeqNtBass.st07(2);},
					4, {IFSeqNtBass.st07(3);},
					5, {IFSeqNtBass.st07(4);},
					6, {IFSeqNtBass.st07(5);},
					7, {IFSeqNtBass.st07(6);},
					8, {IFSeqNtBass.st07(7);},
					9, {IFSeqNtBass.st07(8);},
					10, {IFSeqNtBass.st07(9);},
					11,{IFSeqNtBass.st07(10);},
					12,{IFSeqNtBass.st07(11);
						~cntSeqNtBass07=0;
					}
				)}
			);
			},
			'/ifSeq/4/7'
		);
		~ifSeqBassBut08.free;
		~ifSeqBassBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass08 = ~cntSeqNtBass08 + 1;
				~cntSeqNtBass08.switch(
					0,{},
					1, {IFSeqNtBass.st08(0);},
					2, {IFSeqNtBass.st08(1);},
					3, {IFSeqNtBass.st08(2);},
					4, {IFSeqNtBass.st08(3);},
					5, {IFSeqNtBass.st08(4);},
					6, {IFSeqNtBass.st08(5);},
					7, {IFSeqNtBass.st08(6);},
					8, {IFSeqNtBass.st08(7);},
					9, {IFSeqNtBass.st08(8);},
					10, {IFSeqNtBass.st08(9);},
					11,{IFSeqNtBass.st08(10);},
					12,{IFSeqNtBass.st08(11);
						~cntSeqNtBass08=0;
					}
				)}
			);
			},
			'/ifSeq/4/8'
		);

		~ifSeqBassBut09.free;
		~ifSeqBassBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass09 = ~cntSeqNtBass09 + 1;
				~cntSeqNtBass09.switch(
					0,{},
					1, {IFSeqNtBass.st09(0);},
					2, {IFSeqNtBass.st09(1);},
					3, {IFSeqNtBass.st09(2);},
					4, {IFSeqNtBass.st09(3);},
					5, {IFSeqNtBass.st09(4);},
					6, {IFSeqNtBass.st09(5);},
					7, {IFSeqNtBass.st09(6);},
					8, {IFSeqNtBass.st09(7);},
					9, {IFSeqNtBass.st09(8);},
					10, {IFSeqNtBass.st09(9);},
					11,{IFSeqNtBass.st09(10);},
					12,{IFSeqNtBass.st09(11);
						~cntSeqNtBass09=0;
					}
				)}
			);
			},
			'/ifSeq/4/9'
		);
		~ifSeqBassBut10.free;
		~ifSeqBassBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass10 = ~cntSeqNtBass10 + 1;
				~cntSeqNtBass10.switch(
					0,{},
					1, {IFSeqNtBass.st10(0);},
					2, {IFSeqNtBass.st10(1);},
					3, {IFSeqNtBass.st10(2);},
					4, {IFSeqNtBass.st10(3);},
					5, {IFSeqNtBass.st10(4);},
					6, {IFSeqNtBass.st10(5);},
					7, {IFSeqNtBass.st10(6);},
					8, {IFSeqNtBass.st10(7);},
					9, {IFSeqNtBass.st10(8);},
					10, {IFSeqNtBass.st10(9);},
					11,{IFSeqNtBass.st10(10);},
					12,{IFSeqNtBass.st10(11);
						~cntSeqNtBass10=0;
					}
				)}
			);
			},
			'/ifSeq/4/10'
		);
		~ifSeqBassBut11.free;
		~ifSeqBassBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass11 = ~cntSeqNtBass11 + 1;
				~cntSeqNtBass11.switch(
					0,{},
					1, {IFSeqNtBass.st11(0);},
					2, {IFSeqNtBass.st11(1);},
					3, {IFSeqNtBass.st11(2);},
					4, {IFSeqNtBass.st11(3);},
					5, {IFSeqNtBass.st11(4);},
					6, {IFSeqNtBass.st11(5);},
					7, {IFSeqNtBass.st11(6);},
					8, {IFSeqNtBass.st11(7);},
					9, {IFSeqNtBass.st11(8);},
					10, {IFSeqNtBass.st11(9);},
					11,{IFSeqNtBass.st11(10);},
					12,{IFSeqNtBass.st11(11);
						~cntSeqNtBass11=0;
					}
				)}
			);
			},
			'/ifSeq/4/11'
		);
		~ifSeqBassBut12.free;
		~ifSeqBassBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass12 = ~cntSeqNtBass12 + 1;
				~cntSeqNtBass12.switch(
					0,{},
					1, {IFSeqNtBass.st12(0);},
					2, {IFSeqNtBass.st12(1);},
					3, {IFSeqNtBass.st12(2);},
					4, {IFSeqNtBass.st12(3);},
					5, {IFSeqNtBass.st12(4);},
					6, {IFSeqNtBass.st12(5);},
					7, {IFSeqNtBass.st12(6);},
					8, {IFSeqNtBass.st12(7);},
					9, {IFSeqNtBass.st12(8);},
					10, {IFSeqNtBass.st12(9);},
					11,{IFSeqNtBass.st12(10);},
					12,{IFSeqNtBass.st12(11);
						~cntSeqNtBass12=0;
					}
				)}
			);
			},
			'/ifSeq/4/12'
		);
		~ifSeqBassBut13.free;
		~ifSeqBassBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass13 = ~cntSeqNtBass13 + 1;
				~cntSeqNtBass13.switch(
					0,{},
					1, {IFSeqNtBass.st13(0);},
					2, {IFSeqNtBass.st13(1);},
					3, {IFSeqNtBass.st13(2);},
					4, {IFSeqNtBass.st13(3);},
					5, {IFSeqNtBass.st13(4);},
					6, {IFSeqNtBass.st13(5);},
					7, {IFSeqNtBass.st13(6);},
					8, {IFSeqNtBass.st13(7);},
					9, {IFSeqNtBass.st13(8);},
					10, {IFSeqNtBass.st13(9);},
					11,{IFSeqNtBass.st13(10);},
					12,{IFSeqNtBass.st13(11);
						~cntSeqNtBass13=0;
					}
				)}
			);
			},
			'/ifSeq/4/13'
		);
		~ifSeqBassBut14.free;
		~ifSeqBassBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass14 = ~cntSeqNtBass14 + 1;
				~cntSeqNtBass14.switch(
					0,{},
					1, {IFSeqNtBass.st14(0);},
					2, {IFSeqNtBass.st14(1);},
					3, {IFSeqNtBass.st14(2);},
					4, {IFSeqNtBass.st14(3);},
					5, {IFSeqNtBass.st14(4);},
					6, {IFSeqNtBass.st14(5);},
					7, {IFSeqNtBass.st14(6);},
					8, {IFSeqNtBass.st14(7);},
					9, {IFSeqNtBass.st14(8);},
					10, {IFSeqNtBass.st14(9);},
					11,{IFSeqNtBass.st14(10);},
					12,{IFSeqNtBass.st14(11);
						~cntSeqNtBass14=0;
					}
				)}
			);
			},
			'/ifSeq/4/14'
		);
		~ifSeqBassBut15.free;
		~ifSeqBassBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass15 = ~cntSeqNtBass15 + 1;
				~cntSeqNtBass15.switch(
					0,{},
					1, {IFSeqNtBass.st15(0);},
					2, {IFSeqNtBass.st15(1);},
					3, {IFSeqNtBass.st15(2);},
					4, {IFSeqNtBass.st15(3);},
					5, {IFSeqNtBass.st15(4);},
					6, {IFSeqNtBass.st15(5);},
					7, {IFSeqNtBass.st15(6);},
					8, {IFSeqNtBass.st15(7);},
					9, {IFSeqNtBass.st15(8);},
					10, {IFSeqNtBass.st15(9);},
					11,{IFSeqNtBass.st15(10);},
					12,{IFSeqNtBass.st15(11);
						~cntSeqNtBass15=0;
					}
				)}
			);
			},
			'/ifSeq/4/15'
		);
		~ifSeqBassBut16.free;
		~ifSeqBassBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtBass16 = ~cntSeqNtBass16 + 1;
				~cntSeqNtBass16.switch(
					0,{},
					1, {IFSeqNtBass.st16(0);},
					2, {IFSeqNtBass.st16(1);},
					3, {IFSeqNtBass.st16(2);},
					4, {IFSeqNtBass.st16(3);},
					5, {IFSeqNtBass.st16(4);},
					6, {IFSeqNtBass.st16(5);},
					7, {IFSeqNtBass.st16(6);},
					8, {IFSeqNtBass.st16(7);},
					9, {IFSeqNtBass.st16(8);},
					10, {IFSeqNtBass.st16(9);},
					11,{IFSeqNtBass.st16(10);},
					12,{IFSeqNtBass.st16(11);
						~cntSeqNtBass16=0;
					}
				)}
			);
			},
			'/ifSeq/4/16'
		);

	}//

	*st01 {|i=0|
		~seqNtBass01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass01', i);
	}
	*st02 {|i=0|
		~seqNtBass02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass02', i);
	}
	*st03 {|i=0|
		~seqNtBass03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass03', i);
	}
	*st04 {|i=0|
		~seqNtBass04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass04', i);
	}
	*st05 {|i=0|
		~seqNtBass05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass05', i);
	}
	*st06 {|i=0|
		~seqNtBass06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass06', i);
	}
	*st07 {|i=0|
		~seqNtBass07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass07', i);
	}
	*st08 {|i=0|
		~seqNtBass08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass08', i);
	}

	*st09 {|i=0|
		~seqNtBass09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass09', i);
	}
	*st10 {|i=0|
		~seqNtBass10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass10', i);
	}
	*st11 {|i=0|
		~seqNtBass11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass11', i);
	}
	*st12 {|i=0|
		~seqNtBass12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass12', i);
	}
	*st13 {|i=0|
		~seqNtBass13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass13', i);
	}
	*st14 {|i=0|
		~seqNtBass14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass14', i);
	}
	*st15 {|i=0|
		~seqNtBass15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass15', i);
	}
	*st16 {|i=0|
		~seqNtBass16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtBass16', i);
	}
	*stGrp {|i|

		IFSeqNtBass.st01(i); IFSeqNtBass.st02(i); IFSeqNtBass.st03(i); IFSeqNtBass.st04(i);
		IFSeqNtBass.st05(i); IFSeqNtBass.st06(i); IFSeqNtBass.st07(i); IFSeqNtBass.st08(i);
		IFSeqNtBass.st09(i); IFSeqNtBass.st10(i); IFSeqNtBass.st11(i); IFSeqNtBass.st12(i);
		IFSeqNtBass.st13(i); IFSeqNtBass.st14(i); IFSeqNtBass.st15(i); IFSeqNtBass.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqNtBass.st01(s01); IFSeqNtBass.st02(s02); IFSeqNtBass.st03(s03); IFSeqNtBass.st04(s04);
		IFSeqNtBass.st05(s05); IFSeqNtBass.st06(s06); IFSeqNtBass.st07(s07); IFSeqNtBass.st08(s08);
		IFSeqNtBass.st09(s09); IFSeqNtBass.st10(s10); IFSeqNtBass.st11(s11); IFSeqNtBass.st12(s12);
		IFSeqNtBass.st13(s13); IFSeqNtBass.st14(s14); IFSeqNtBass.st15(s15); IFSeqNtBass.st16(s16);
	}
}