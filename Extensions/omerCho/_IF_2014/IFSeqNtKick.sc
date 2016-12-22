IFSeqNtKick {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqNtKick01 = PatternProxy( Pseq([0], 1));
		~seqNtKick02 = PatternProxy( Pseq([0], 1));
		~seqNtKick03 = PatternProxy( Pseq([0], 1));
		~seqNtKick04 = PatternProxy( Pseq([0], 1));
		~seqNtKick05 = PatternProxy( Pseq([0], 1));
		~seqNtKick06 = PatternProxy( Pseq([0], 1));
		~seqNtKick07 = PatternProxy( Pseq([0], 1));
		~seqNtKick08 = PatternProxy( Pseq([0], 1));

		~seqNtKick09 = PatternProxy( Pseq([0], 1));
		~seqNtKick10 = PatternProxy( Pseq([0], 1));
		~seqNtKick11 = PatternProxy( Pseq([0], 1));
		~seqNtKick12 = PatternProxy( Pseq([0], 1));
		~seqNtKick13 = PatternProxy( Pseq([0], 1));
		~seqNtKick14 = PatternProxy( Pseq([0], 1));
		~seqNtKick15 = PatternProxy( Pseq([0], 1));
		~seqNtKick16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqNtUpKick01=0;
		~cntSeqNtRandKick01=0;

		~cntSeqNtKick01=0;
		~cntSeqNtKick02=0;
		~cntSeqNtKick03=0;
		~cntSeqNtKick04=0;
		~cntSeqNtKick05=0;
		~cntSeqNtKick06=0;
		~cntSeqNtKick07=0;
		~cntSeqNtKick08=0;

		~cntSeqNtKick09=0;
		~cntSeqNtKick10=0;
		~cntSeqNtKick11=0;
		~cntSeqNtKick12=0;
		~cntSeqNtKick13=0;
		~cntSeqNtKick14=0;
		~cntSeqNtKick15=0;
		~cntSeqNtKick16=0;
	}
	*freeOn {
		~seqFreeKickBut.free;
		~seqFreeKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqNtKick.stGrp(0);
				});
			},
			'/seqFreeKick'
		);

	}

	*upOn {
		~ifSeqUpKickBut.free;
		~ifSeqUpKickBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtUpKick01 = ~cntSeqNtUpKick01 + 1;
				~cntSeqNtUpKick01.switch(
					0,{},
					1,{IFSeqNtKick.stGrp(0);},
					2,{IFSeqNtKick.stGrp(1);},
					3,{IFSeqNtKick.stGrp(2);},
					4,{IFSeqNtKick.stGrp(3);},
					5,{IFSeqNtKick.stGrp(4);},
					6,{IFSeqNtKick.stGrp(5);},
					7,{IFSeqNtKick.stGrp(6);},
					8,{IFSeqNtKick.stGrp(7);},
					9,{IFSeqNtKick.stGrp(8);},
					10,{IFSeqNtKick.stGrp(9);},
					11,{IFSeqNtKick.stGrp(10);},
					12,{IFSeqNtKick.stGrp(11);
						~cntSeqNtUpKick01=0;
					}
				)}
			);
			},
			'/seqUpKick'
		);
	}

	*randOn {
		~ifSeqRandKickBut.free;
		~ifSeqRandKickBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtRandKick01 = ~cntSeqNtRandKick01 + 1;
				~cntSeqNtRandKick01.switch(
					0,{},
					1,{
						IFSeqNtKick.st01((0..11).choose);
						IFSeqNtKick.st02((0..11).choose);
						IFSeqNtKick.st03((0..11).choose);
						IFSeqNtKick.st04((0..11).choose);
						IFSeqNtKick.st05((0..11).choose);
						IFSeqNtKick.st06((0..11).choose);
						IFSeqNtKick.st07((0..11).choose);
						IFSeqNtKick.st08((0..11).choose);

						IFSeqNtKick.st09((0..11).choose);
						IFSeqNtKick.st10((0..11).choose);
						IFSeqNtKick.st11((0..11).choose);
						IFSeqNtKick.st12((0..11).choose);
						IFSeqNtKick.st13((0..11).choose);
						IFSeqNtKick.st14((0..11).choose);
						IFSeqNtKick.st15((0..11).choose);
						IFSeqNtKick.st16((0..11).choose);
						~cntSeqNtRandKick01=0;
					}
				)}
			);
			},
			'/seqRandKick'
		);
	}

	*on { // Shift NtAVE
		IFSeqNtKick.randOn;
		IFSeqNtKick.upOn;
		IFSeqNtKick.freeOn;

		~ifSeqKickBut01.free;
		~ifSeqKickBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick01 = ~cntSeqNtKick01 + 1;
				~cntSeqNtKick01.switch(
					0,{},
					1, {IFSeqNtKick.st01(0);},
					2, {IFSeqNtKick.st01(1);},
					3, {IFSeqNtKick.st01(2);},
					4, {IFSeqNtKick.st01(3);},
					5, {IFSeqNtKick.st01(4);},
					6, {IFSeqNtKick.st01(5);},
					7, {IFSeqNtKick.st01(6);},
					8, {IFSeqNtKick.st01(7);},
					9, {IFSeqNtKick.st01(8);},
					10,{IFSeqNtKick.st01(9);},
					11,{IFSeqNtKick.st01(10);},
					12,{IFSeqNtKick.st01(11);
						~cntSeqNtKick01=0;
					}
				)}
			);
			},
			'/ifSeq/1/1'
		);
		~ifSeqKickBut02.free;
		~ifSeqKickBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick02 = ~cntSeqNtKick02 + 1;
				~cntSeqNtKick02.switch(
					0,{},
					1, {IFSeqNtKick.st02(0);},
					2, {IFSeqNtKick.st02(1);},
					3, {IFSeqNtKick.st02(2);},
					4, {IFSeqNtKick.st02(3);},
					5, {IFSeqNtKick.st02(4);},
					6, {IFSeqNtKick.st02(5);},
					7, {IFSeqNtKick.st02(6);},
					8, {IFSeqNtKick.st02(7);},
					9, {IFSeqNtKick.st02(8);},
					10, {IFSeqNtKick.st02(9);},
					11,{IFSeqNtKick.st02(10);},
					12,{IFSeqNtKick.st02(11);
						~cntSeqNtKick02=0;
					}
				)}
			);
			},
			'/ifSeq/1/2'
		);
		~ifSeqKickBut03.free;
		~ifSeqKickBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick03 = ~cntSeqNtKick03 + 1;
				~cntSeqNtKick03.switch(
					0,{},
					1, {IFSeqNtKick.st03(0);},
					2, {IFSeqNtKick.st03(1);},
					3, {IFSeqNtKick.st03(2);},
					4, {IFSeqNtKick.st03(3);},
					5, {IFSeqNtKick.st03(4);},
					6, {IFSeqNtKick.st03(5);},
					7, {IFSeqNtKick.st03(6);},
					8, {IFSeqNtKick.st03(7);},
					9, {IFSeqNtKick.st03(8);},
					10, {IFSeqNtKick.st03(9);},
					11,{IFSeqNtKick.st03(10);},
					12,{IFSeqNtKick.st03(11);
						~cntSeqNtKick03=0;
					}
				)}
			);
			},
			'/ifSeq/1/3'
		);
		~ifSeqKickBut04.free;
		~ifSeqKickBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick04 = ~cntSeqNtKick04 + 1;
				~cntSeqNtKick04.switch(
					0,{},
					1, {IFSeqNtKick.st04(0);},
					2, {IFSeqNtKick.st04(1);},
					3, {IFSeqNtKick.st04(2);},
					4, {IFSeqNtKick.st04(3);},
					5, {IFSeqNtKick.st04(4);},
					6, {IFSeqNtKick.st04(5);},
					7, {IFSeqNtKick.st04(6);},
					8, {IFSeqNtKick.st04(7);},
					9, {IFSeqNtKick.st04(8);},
					10, {IFSeqNtKick.st04(9);},
					11,{IFSeqNtKick.st04(10);},
					12,{IFSeqNtKick.st04(11);
						~cntSeqNtKick04=0;
					}
				)}
			);
			},
			'/ifSeq/1/4'
		);
		~ifSeqKickBut05.free;
		~ifSeqKickBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick05 = ~cntSeqNtKick05 + 1;
				~cntSeqNtKick05.switch(
					0,{},
					1, {IFSeqNtKick.st05(0);},
					2, {IFSeqNtKick.st05(1);},
					3, {IFSeqNtKick.st05(2);},
					4, {IFSeqNtKick.st05(3);},
					5, {IFSeqNtKick.st05(4);},
					6, {IFSeqNtKick.st05(5);},
					7, {IFSeqNtKick.st05(6);},
					8, {IFSeqNtKick.st05(7);},
					9, {IFSeqNtKick.st05(8);},
					10, {IFSeqNtKick.st05(9);},
					11,{IFSeqNtKick.st05(10);},
					12,{IFSeqNtKick.st05(11);
						~cntSeqNtKick05=0;
					}
				)}
			);
			},
			'/ifSeq/1/5'
		);
		~ifSeqKickBut06.free;
		~ifSeqKickBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick06 = ~cntSeqNtKick06 + 1;
				~cntSeqNtKick06.switch(
					0,{},
					1, {IFSeqNtKick.st06(0);},
					2, {IFSeqNtKick.st06(1);},
					3, {IFSeqNtKick.st06(2);},
					4, {IFSeqNtKick.st06(3);},
					5, {IFSeqNtKick.st06(4);},
					6, {IFSeqNtKick.st06(5);},
					7, {IFSeqNtKick.st06(6);},
					8, {IFSeqNtKick.st06(7);},
					9, {IFSeqNtKick.st06(8);},
					10, {IFSeqNtKick.st06(9);},
					11,{IFSeqNtKick.st06(10);},
					12,{IFSeqNtKick.st06(11);
						~cntSeqNtKick06=0;
					}
				)}
			);
			},
			'/ifSeq/1/6'
		);
		~ifSeqKickBut07.free;
		~ifSeqKickBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick07 = ~cntSeqNtKick07 + 1;
				~cntSeqNtKick07.switch(
					0,{},
					1, {IFSeqNtKick.st07(0);},
					2, {IFSeqNtKick.st07(1);},
					3, {IFSeqNtKick.st07(2);},
					4, {IFSeqNtKick.st07(3);},
					5, {IFSeqNtKick.st07(4);},
					6, {IFSeqNtKick.st07(5);},
					7, {IFSeqNtKick.st07(6);},
					8, {IFSeqNtKick.st07(7);},
					9, {IFSeqNtKick.st07(8);},
					10, {IFSeqNtKick.st07(9);},
					11,{IFSeqNtKick.st07(10);},
					12,{IFSeqNtKick.st07(11);
						~cntSeqNtKick07=0;
					}
				)}
			);
			},
			'/ifSeq/1/7'
		);
		~ifSeqKickBut08.free;
		~ifSeqKickBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick08 = ~cntSeqNtKick08 + 1;
				~cntSeqNtKick08.switch(
					0,{},
					1, {IFSeqNtKick.st08(0);},
					2, {IFSeqNtKick.st08(1);},
					3, {IFSeqNtKick.st08(2);},
					4, {IFSeqNtKick.st08(3);},
					5, {IFSeqNtKick.st08(4);},
					6, {IFSeqNtKick.st08(5);},
					7, {IFSeqNtKick.st08(6);},
					8, {IFSeqNtKick.st08(7);},
					9, {IFSeqNtKick.st08(8);},
					10, {IFSeqNtKick.st08(9);},
					11,{IFSeqNtKick.st08(10);},
					12,{IFSeqNtKick.st08(11);
						~cntSeqNtKick08=0;
					}
				)}
			);
			},
			'/ifSeq/1/8'
		);

		~ifSeqKickBut09.free;
		~ifSeqKickBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick09 = ~cntSeqNtKick09 + 1;
				~cntSeqNtKick09.switch(
					0,{},
					1, {IFSeqNtKick.st09(0);},
					2, {IFSeqNtKick.st09(1);},
					3, {IFSeqNtKick.st09(2);},
					4, {IFSeqNtKick.st09(3);},
					5, {IFSeqNtKick.st09(4);},
					6, {IFSeqNtKick.st09(5);},
					7, {IFSeqNtKick.st09(6);},
					8, {IFSeqNtKick.st09(7);},
					9, {IFSeqNtKick.st09(8);},
					10, {IFSeqNtKick.st09(9);},
					11,{IFSeqNtKick.st09(10);},
					12,{IFSeqNtKick.st09(11);
						~cntSeqNtKick09=0;
					}
				)}
			);
			},
			'/ifSeq/1/9'
		);
		~ifSeqKickBut10.free;
		~ifSeqKickBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick10 = ~cntSeqNtKick10 + 1;
				~cntSeqNtKick10.switch(
					0,{},
					1, {IFSeqNtKick.st10(0);},
					2, {IFSeqNtKick.st10(1);},
					3, {IFSeqNtKick.st10(2);},
					4, {IFSeqNtKick.st10(3);},
					5, {IFSeqNtKick.st10(4);},
					6, {IFSeqNtKick.st10(5);},
					7, {IFSeqNtKick.st10(6);},
					8, {IFSeqNtKick.st10(7);},
					9, {IFSeqNtKick.st10(8);},
					10, {IFSeqNtKick.st10(9);},
					11,{IFSeqNtKick.st10(10);},
					12,{IFSeqNtKick.st10(11);
						~cntSeqNtKick10=0;
					}
				)}
			);
			},
			'/ifSeq/1/10'
		);
		~ifSeqKickBut11.free;
		~ifSeqKickBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick11 = ~cntSeqNtKick11 + 1;
				~cntSeqNtKick11.switch(
					0,{},
					1, {IFSeqNtKick.st11(0);},
					2, {IFSeqNtKick.st11(1);},
					3, {IFSeqNtKick.st11(2);},
					4, {IFSeqNtKick.st11(3);},
					5, {IFSeqNtKick.st11(4);},
					6, {IFSeqNtKick.st11(5);},
					7, {IFSeqNtKick.st11(6);},
					8, {IFSeqNtKick.st11(7);},
					9, {IFSeqNtKick.st11(8);},
					10, {IFSeqNtKick.st11(9);},
					11,{IFSeqNtKick.st11(10);},
					12,{IFSeqNtKick.st11(11);
						~cntSeqNtKick11=0;
					}
				)}
			);
			},
			'/ifSeq/1/11'
		);
		~ifSeqKickBut12.free;
		~ifSeqKickBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick12 = ~cntSeqNtKick12 + 1;
				~cntSeqNtKick12.switch(
					0,{},
					1, {IFSeqNtKick.st12(0);},
					2, {IFSeqNtKick.st12(1);},
					3, {IFSeqNtKick.st12(2);},
					4, {IFSeqNtKick.st12(3);},
					5, {IFSeqNtKick.st12(4);},
					6, {IFSeqNtKick.st12(5);},
					7, {IFSeqNtKick.st12(6);},
					8, {IFSeqNtKick.st12(7);},
					9, {IFSeqNtKick.st12(8);},
					10, {IFSeqNtKick.st12(9);},
					11,{IFSeqNtKick.st12(10);},
					12,{IFSeqNtKick.st12(11);
						~cntSeqNtKick12=0;
					}
				)}
			);
			},
			'/ifSeq/1/12'
		);
		~ifSeqKickBut13.free;
		~ifSeqKickBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick13 = ~cntSeqNtKick13 + 1;
				~cntSeqNtKick13.switch(
					0,{},
					1, {IFSeqNtKick.st13(0);},
					2, {IFSeqNtKick.st13(1);},
					3, {IFSeqNtKick.st13(2);},
					4, {IFSeqNtKick.st13(3);},
					5, {IFSeqNtKick.st13(4);},
					6, {IFSeqNtKick.st13(5);},
					7, {IFSeqNtKick.st13(6);},
					8, {IFSeqNtKick.st13(7);},
					9, {IFSeqNtKick.st13(8);},
					10, {IFSeqNtKick.st13(9);},
					11,{IFSeqNtKick.st13(10);},
					12,{IFSeqNtKick.st13(11);
						~cntSeqNtKick13=0;
					}
				)}
			);
			},
			'/ifSeq/1/13'
		);
		~ifSeqKickBut14.free;
		~ifSeqKickBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick14 = ~cntSeqNtKick14 + 1;
				~cntSeqNtKick14.switch(
					0,{},
					1, {IFSeqNtKick.st14(0);},
					2, {IFSeqNtKick.st14(1);},
					3, {IFSeqNtKick.st14(2);},
					4, {IFSeqNtKick.st14(3);},
					5, {IFSeqNtKick.st14(4);},
					6, {IFSeqNtKick.st14(5);},
					7, {IFSeqNtKick.st14(6);},
					8, {IFSeqNtKick.st14(7);},
					9, {IFSeqNtKick.st14(8);},
					10, {IFSeqNtKick.st14(9);},
					11,{IFSeqNtKick.st14(10);},
					12,{IFSeqNtKick.st14(11);
						~cntSeqNtKick14=0;
					}
				)}
			);
			},
			'/ifSeq/1/14'
		);
		~ifSeqKickBut15.free;
		~ifSeqKickBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick15 = ~cntSeqNtKick15 + 1;
				~cntSeqNtKick15.switch(
					0,{},
					1, {IFSeqNtKick.st15(0);},
					2, {IFSeqNtKick.st15(1);},
					3, {IFSeqNtKick.st15(2);},
					4, {IFSeqNtKick.st15(3);},
					5, {IFSeqNtKick.st15(4);},
					6, {IFSeqNtKick.st15(5);},
					7, {IFSeqNtKick.st15(6);},
					8, {IFSeqNtKick.st15(7);},
					9, {IFSeqNtKick.st15(8);},
					10, {IFSeqNtKick.st15(9);},
					11,{IFSeqNtKick.st15(10);},
					12,{IFSeqNtKick.st15(11);
						~cntSeqNtKick15=0;
					}
				)}
			);
			},
			'/ifSeq/1/15'
		);
		~ifSeqKickBut16.free;
		~ifSeqKickBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtKick16 = ~cntSeqNtKick16 + 1;
				~cntSeqNtKick16.switch(
					0,{},
					1, {IFSeqNtKick.st16(0);},
					2, {IFSeqNtKick.st16(1);},
					3, {IFSeqNtKick.st16(2);},
					4, {IFSeqNtKick.st16(3);},
					5, {IFSeqNtKick.st16(4);},
					6, {IFSeqNtKick.st16(5);},
					7, {IFSeqNtKick.st16(6);},
					8, {IFSeqNtKick.st16(7);},
					9, {IFSeqNtKick.st16(8);},
					10, {IFSeqNtKick.st16(9);},
					11,{IFSeqNtKick.st16(10);},
					12,{IFSeqNtKick.st16(11);
						~cntSeqNtKick16=0;
					}
				)}
			);
			},
			'/ifSeq/1/16'
		);

	}//

	*st01 {|i=0|
		~seqNtKick01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick01', i);
	}
	*st02 {|i=0|
		~seqNtKick02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick02', i);
	}
	*st03 {|i=0|
		~seqNtKick03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick03', i);
	}
	*st04 {|i=0|
		~seqNtKick04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick04', i);
	}
	*st05 {|i=0|
		~seqNtKick05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick05', i);
	}
	*st06 {|i=0|
		~seqNtKick06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick06', i);
	}
	*st07 {|i=0|
		~seqNtKick07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick07', i);
	}
	*st08 {|i=0|
		~seqNtKick08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick08', i);
	}

	*st09 {|i=0|
		~seqNtKick09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick09', i);
	}
	*st10 {|i=0|
		~seqNtKick10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick10', i);
	}
	*st11 {|i=0|
		~seqNtKick11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick11', i);
	}
	*st12 {|i=0|
		~seqNtKick12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick12', i);
	}
	*st13 {|i=0|
		~seqNtKick13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick13', i);
	}
	*st14 {|i=0|
		~seqNtKick14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick14', i);
	}
	*st15 {|i=0|
		~seqNtKick15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick15', i);
	}
	*st16 {|i=0|
		~seqNtKick16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtKick16', i);
	}
	*stGrp {|i|

		IFSeqNtKick.st01(i); IFSeqNtKick.st02(i); IFSeqNtKick.st03(i); IFSeqNtKick.st04(i);
		IFSeqNtKick.st05(i); IFSeqNtKick.st06(i); IFSeqNtKick.st07(i); IFSeqNtKick.st08(i);
		IFSeqNtKick.st09(i); IFSeqNtKick.st10(i); IFSeqNtKick.st11(i); IFSeqNtKick.st12(i);
		IFSeqNtKick.st13(i); IFSeqNtKick.st14(i); IFSeqNtKick.st15(i); IFSeqNtKick.st16(i);
	}
}