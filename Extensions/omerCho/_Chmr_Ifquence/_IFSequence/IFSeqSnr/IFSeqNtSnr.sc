IFSeqNtSnr {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqNtSnr01 = PatternProxy( Pseq([0], 1));
		~seqNtSnr02 = PatternProxy( Pseq([0], 1));
		~seqNtSnr03 = PatternProxy( Pseq([0], 1));
		~seqNtSnr04 = PatternProxy( Pseq([0], 1));
		~seqNtSnr05 = PatternProxy( Pseq([0], 1));
		~seqNtSnr06 = PatternProxy( Pseq([0], 1));
		~seqNtSnr07 = PatternProxy( Pseq([0], 1));
		~seqNtSnr08 = PatternProxy( Pseq([0], 1));

		~seqNtSnr09 = PatternProxy( Pseq([0], 1));
		~seqNtSnr10 = PatternProxy( Pseq([0], 1));
		~seqNtSnr11 = PatternProxy( Pseq([0], 1));
		~seqNtSnr12 = PatternProxy( Pseq([0], 1));
		~seqNtSnr13 = PatternProxy( Pseq([0], 1));
		~seqNtSnr14 = PatternProxy( Pseq([0], 1));
		~seqNtSnr15 = PatternProxy( Pseq([0], 1));
		~seqNtSnr16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqNtUpSnr01=0;
		~cntSeqNtRandSnr01=0;

		~cntSeqNtSnr01=0;
		~cntSeqNtSnr02=0;
		~cntSeqNtSnr03=0;
		~cntSeqNtSnr04=0;
		~cntSeqNtSnr05=0;
		~cntSeqNtSnr06=0;
		~cntSeqNtSnr07=0;
		~cntSeqNtSnr08=0;

		~cntSeqNtSnr09=0;
		~cntSeqNtSnr10=0;
		~cntSeqNtSnr11=0;
		~cntSeqNtSnr12=0;
		~cntSeqNtSnr13=0;
		~cntSeqNtSnr14=0;
		~cntSeqNtSnr15=0;
		~cntSeqNtSnr16=0;
	}
	*freeOn {
		~seqFreeSnrBut.free;
		~seqFreeSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqNtSnr.stGrp(0);
				});
			},
			'/seqFreeSnr'
		);

	}

	*upOn {
		~ifSeqUpSnrBut.free;
		~ifSeqUpSnrBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtUpSnr01 = ~cntSeqNtUpSnr01 + 1;
				~cntSeqNtUpSnr01.switch(
					0,{},
					1,{IFSeqNtSnr.stGrp(0);},
					2,{IFSeqNtSnr.stGrp(1);},
					3,{IFSeqNtSnr.stGrp(2);},
					4,{IFSeqNtSnr.stGrp(3);},
					5,{IFSeqNtSnr.stGrp(4);},
					6,{IFSeqNtSnr.stGrp(5);},
					7,{IFSeqNtSnr.stGrp(6);},
					8,{IFSeqNtSnr.stGrp(7);},
					9,{IFSeqNtSnr.stGrp(8);},
					10,{IFSeqNtSnr.stGrp(9);},
					11,{IFSeqNtSnr.stGrp(10);},
					12,{IFSeqNtSnr.stGrp(11);
						~cntSeqNtUpSnr01=0;
					}
				)}
			);
			},
			'/seqUpSnr'
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
						IFSeqNtSnr.st01((0..11).choose);
						IFSeqNtSnr.st02((0..11).choose);
						IFSeqNtSnr.st03((0..11).choose);
						IFSeqNtSnr.st04((0..11).choose);
						IFSeqNtSnr.st05((0..11).choose);
						IFSeqNtSnr.st06((0..11).choose);
						IFSeqNtSnr.st07((0..11).choose);
						IFSeqNtSnr.st08((0..11).choose);

						IFSeqNtSnr.st09((0..11).choose);
						IFSeqNtSnr.st10((0..11).choose);
						IFSeqNtSnr.st11((0..11).choose);
						IFSeqNtSnr.st12((0..11).choose);
						IFSeqNtSnr.st13((0..11).choose);
						IFSeqNtSnr.st14((0..11).choose);
						IFSeqNtSnr.st15((0..11).choose);
						IFSeqNtSnr.st16((0..11).choose);
						~cntSeqNtRandSnr01=0;
					}
				)}
			);
			},
			'/seqRandSnr'
		);
	}

	*on { // Shift NtAVE
		IFSeqNtSnr.randOn;
		IFSeqNtSnr.upOn;
		IFSeqNtSnr.freeOn;

		~ifSeqSnrBut01.free;
		~ifSeqSnrBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr01 = ~cntSeqNtSnr01 + 1;
				~cntSeqNtSnr01.switch(
					0,{},
					1, {IFSeqNtSnr.st01(0);},
					2, {IFSeqNtSnr.st01(1);},
					3, {IFSeqNtSnr.st01(2);},
					4, {IFSeqNtSnr.st01(3);},
					5, {IFSeqNtSnr.st01(4);},
					6, {IFSeqNtSnr.st01(5);},
					7, {IFSeqNtSnr.st01(6);},
					8, {IFSeqNtSnr.st01(7);},
					9, {IFSeqNtSnr.st01(8);},
					10,{IFSeqNtSnr.st01(9);},
					11,{IFSeqNtSnr.st01(10);},
					12,{IFSeqNtSnr.st01(11);
						~cntSeqNtSnr01=0;
					}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqSnrBut02.free;
		~ifSeqSnrBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr02 = ~cntSeqNtSnr02 + 1;
				~cntSeqNtSnr02.switch(
					0,{},
					1, {IFSeqNtSnr.st02(0);},
					2, {IFSeqNtSnr.st02(1);},
					3, {IFSeqNtSnr.st02(2);},
					4, {IFSeqNtSnr.st02(3);},
					5, {IFSeqNtSnr.st02(4);},
					6, {IFSeqNtSnr.st02(5);},
					7, {IFSeqNtSnr.st02(6);},
					8, {IFSeqNtSnr.st02(7);},
					9, {IFSeqNtSnr.st02(8);},
					10, {IFSeqNtSnr.st02(9);},
					11,{IFSeqNtSnr.st02(10);},
					12,{IFSeqNtSnr.st02(11);
						~cntSeqNtSnr02=0;
					}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqSnrBut03.free;
		~ifSeqSnrBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr03 = ~cntSeqNtSnr03 + 1;
				~cntSeqNtSnr03.switch(
					0,{},
					1, {IFSeqNtSnr.st03(0);},
					2, {IFSeqNtSnr.st03(1);},
					3, {IFSeqNtSnr.st03(2);},
					4, {IFSeqNtSnr.st03(3);},
					5, {IFSeqNtSnr.st03(4);},
					6, {IFSeqNtSnr.st03(5);},
					7, {IFSeqNtSnr.st03(6);},
					8, {IFSeqNtSnr.st03(7);},
					9, {IFSeqNtSnr.st03(8);},
					10, {IFSeqNtSnr.st03(9);},
					11,{IFSeqNtSnr.st03(10);},
					12,{IFSeqNtSnr.st03(11);
						~cntSeqNtSnr03=0;
					}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqSnrBut04.free;
		~ifSeqSnrBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr04 = ~cntSeqNtSnr04 + 1;
				~cntSeqNtSnr04.switch(
					0,{},
					1, {IFSeqNtSnr.st04(0);},
					2, {IFSeqNtSnr.st04(1);},
					3, {IFSeqNtSnr.st04(2);},
					4, {IFSeqNtSnr.st04(3);},
					5, {IFSeqNtSnr.st04(4);},
					6, {IFSeqNtSnr.st04(5);},
					7, {IFSeqNtSnr.st04(6);},
					8, {IFSeqNtSnr.st04(7);},
					9, {IFSeqNtSnr.st04(8);},
					10, {IFSeqNtSnr.st04(9);},
					11,{IFSeqNtSnr.st04(10);},
					12,{IFSeqNtSnr.st04(11);
						~cntSeqNtSnr04=0;
					}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqSnrBut05.free;
		~ifSeqSnrBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr05 = ~cntSeqNtSnr05 + 1;
				~cntSeqNtSnr05.switch(
					0,{},
					1, {IFSeqNtSnr.st05(0);},
					2, {IFSeqNtSnr.st05(1);},
					3, {IFSeqNtSnr.st05(2);},
					4, {IFSeqNtSnr.st05(3);},
					5, {IFSeqNtSnr.st05(4);},
					6, {IFSeqNtSnr.st05(5);},
					7, {IFSeqNtSnr.st05(6);},
					8, {IFSeqNtSnr.st05(7);},
					9, {IFSeqNtSnr.st05(8);},
					10, {IFSeqNtSnr.st05(9);},
					11,{IFSeqNtSnr.st05(10);},
					12,{IFSeqNtSnr.st05(11);
						~cntSeqNtSnr05=0;
					}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqSnrBut06.free;
		~ifSeqSnrBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr06 = ~cntSeqNtSnr06 + 1;
				~cntSeqNtSnr06.switch(
					0,{},
					1, {IFSeqNtSnr.st06(0);},
					2, {IFSeqNtSnr.st06(1);},
					3, {IFSeqNtSnr.st06(2);},
					4, {IFSeqNtSnr.st06(3);},
					5, {IFSeqNtSnr.st06(4);},
					6, {IFSeqNtSnr.st06(5);},
					7, {IFSeqNtSnr.st06(6);},
					8, {IFSeqNtSnr.st06(7);},
					9, {IFSeqNtSnr.st06(8);},
					10, {IFSeqNtSnr.st06(9);},
					11,{IFSeqNtSnr.st06(10);},
					12,{IFSeqNtSnr.st06(11);
						~cntSeqNtSnr06=0;
					}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqSnrBut07.free;
		~ifSeqSnrBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr07 = ~cntSeqNtSnr07 + 1;
				~cntSeqNtSnr07.switch(
					0,{},
					1, {IFSeqNtSnr.st07(0);},
					2, {IFSeqNtSnr.st07(1);},
					3, {IFSeqNtSnr.st07(2);},
					4, {IFSeqNtSnr.st07(3);},
					5, {IFSeqNtSnr.st07(4);},
					6, {IFSeqNtSnr.st07(5);},
					7, {IFSeqNtSnr.st07(6);},
					8, {IFSeqNtSnr.st07(7);},
					9, {IFSeqNtSnr.st07(8);},
					10, {IFSeqNtSnr.st07(9);},
					11,{IFSeqNtSnr.st07(10);},
					12,{IFSeqNtSnr.st07(11);
						~cntSeqNtSnr07=0;
					}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqSnrBut08.free;
		~ifSeqSnrBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr08 = ~cntSeqNtSnr08 + 1;
				~cntSeqNtSnr08.switch(
					0,{},
					1, {IFSeqNtSnr.st08(0);},
					2, {IFSeqNtSnr.st08(1);},
					3, {IFSeqNtSnr.st08(2);},
					4, {IFSeqNtSnr.st08(3);},
					5, {IFSeqNtSnr.st08(4);},
					6, {IFSeqNtSnr.st08(5);},
					7, {IFSeqNtSnr.st08(6);},
					8, {IFSeqNtSnr.st08(7);},
					9, {IFSeqNtSnr.st08(8);},
					10, {IFSeqNtSnr.st08(9);},
					11,{IFSeqNtSnr.st08(10);},
					12,{IFSeqNtSnr.st08(11);
						~cntSeqNtSnr08=0;
					}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqSnrBut09.free;
		~ifSeqSnrBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr09 = ~cntSeqNtSnr09 + 1;
				~cntSeqNtSnr09.switch(
					0,{},
					1, {IFSeqNtSnr.st09(0);},
					2, {IFSeqNtSnr.st09(1);},
					3, {IFSeqNtSnr.st09(2);},
					4, {IFSeqNtSnr.st09(3);},
					5, {IFSeqNtSnr.st09(4);},
					6, {IFSeqNtSnr.st09(5);},
					7, {IFSeqNtSnr.st09(6);},
					8, {IFSeqNtSnr.st09(7);},
					9, {IFSeqNtSnr.st09(8);},
					10, {IFSeqNtSnr.st09(9);},
					11,{IFSeqNtSnr.st09(10);},
					12,{IFSeqNtSnr.st09(11);
						~cntSeqNtSnr09=0;
					}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqSnrBut10.free;
		~ifSeqSnrBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr10 = ~cntSeqNtSnr10 + 1;
				~cntSeqNtSnr10.switch(
					0,{},
					1, {IFSeqNtSnr.st10(0);},
					2, {IFSeqNtSnr.st10(1);},
					3, {IFSeqNtSnr.st10(2);},
					4, {IFSeqNtSnr.st10(3);},
					5, {IFSeqNtSnr.st10(4);},
					6, {IFSeqNtSnr.st10(5);},
					7, {IFSeqNtSnr.st10(6);},
					8, {IFSeqNtSnr.st10(7);},
					9, {IFSeqNtSnr.st10(8);},
					10, {IFSeqNtSnr.st10(9);},
					11,{IFSeqNtSnr.st10(10);},
					12,{IFSeqNtSnr.st10(11);
						~cntSeqNtSnr10=0;
					}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqSnrBut11.free;
		~ifSeqSnrBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr11 = ~cntSeqNtSnr11 + 1;
				~cntSeqNtSnr11.switch(
					0,{},
					1, {IFSeqNtSnr.st11(0);},
					2, {IFSeqNtSnr.st11(1);},
					3, {IFSeqNtSnr.st11(2);},
					4, {IFSeqNtSnr.st11(3);},
					5, {IFSeqNtSnr.st11(4);},
					6, {IFSeqNtSnr.st11(5);},
					7, {IFSeqNtSnr.st11(6);},
					8, {IFSeqNtSnr.st11(7);},
					9, {IFSeqNtSnr.st11(8);},
					10, {IFSeqNtSnr.st11(9);},
					11,{IFSeqNtSnr.st11(10);},
					12,{IFSeqNtSnr.st11(11);
						~cntSeqNtSnr11=0;
					}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqSnrBut12.free;
		~ifSeqSnrBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr12 = ~cntSeqNtSnr12 + 1;
				~cntSeqNtSnr12.switch(
					0,{},
					1, {IFSeqNtSnr.st12(0);},
					2, {IFSeqNtSnr.st12(1);},
					3, {IFSeqNtSnr.st12(2);},
					4, {IFSeqNtSnr.st12(3);},
					5, {IFSeqNtSnr.st12(4);},
					6, {IFSeqNtSnr.st12(5);},
					7, {IFSeqNtSnr.st12(6);},
					8, {IFSeqNtSnr.st12(7);},
					9, {IFSeqNtSnr.st12(8);},
					10, {IFSeqNtSnr.st12(9);},
					11,{IFSeqNtSnr.st12(10);},
					12,{IFSeqNtSnr.st12(11);
						~cntSeqNtSnr12=0;
					}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqSnrBut13.free;
		~ifSeqSnrBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr13 = ~cntSeqNtSnr13 + 1;
				~cntSeqNtSnr13.switch(
					0,{},
					1, {IFSeqNtSnr.st13(0);},
					2, {IFSeqNtSnr.st13(1);},
					3, {IFSeqNtSnr.st13(2);},
					4, {IFSeqNtSnr.st13(3);},
					5, {IFSeqNtSnr.st13(4);},
					6, {IFSeqNtSnr.st13(5);},
					7, {IFSeqNtSnr.st13(6);},
					8, {IFSeqNtSnr.st13(7);},
					9, {IFSeqNtSnr.st13(8);},
					10, {IFSeqNtSnr.st13(9);},
					11,{IFSeqNtSnr.st13(10);},
					12,{IFSeqNtSnr.st13(11);
						~cntSeqNtSnr13=0;
					}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqSnrBut14.free;
		~ifSeqSnrBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr14 = ~cntSeqNtSnr14 + 1;
				~cntSeqNtSnr14.switch(
					0,{},
					1, {IFSeqNtSnr.st14(0);},
					2, {IFSeqNtSnr.st14(1);},
					3, {IFSeqNtSnr.st14(2);},
					4, {IFSeqNtSnr.st14(3);},
					5, {IFSeqNtSnr.st14(4);},
					6, {IFSeqNtSnr.st14(5);},
					7, {IFSeqNtSnr.st14(6);},
					8, {IFSeqNtSnr.st14(7);},
					9, {IFSeqNtSnr.st14(8);},
					10, {IFSeqNtSnr.st14(9);},
					11,{IFSeqNtSnr.st14(10);},
					12,{IFSeqNtSnr.st14(11);
						~cntSeqNtSnr14=0;
					}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqSnrBut15.free;
		~ifSeqSnrBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr15 = ~cntSeqNtSnr15 + 1;
				~cntSeqNtSnr15.switch(
					0,{},
					1, {IFSeqNtSnr.st15(0);},
					2, {IFSeqNtSnr.st15(1);},
					3, {IFSeqNtSnr.st15(2);},
					4, {IFSeqNtSnr.st15(3);},
					5, {IFSeqNtSnr.st15(4);},
					6, {IFSeqNtSnr.st15(5);},
					7, {IFSeqNtSnr.st15(6);},
					8, {IFSeqNtSnr.st15(7);},
					9, {IFSeqNtSnr.st15(8);},
					10, {IFSeqNtSnr.st15(9);},
					11,{IFSeqNtSnr.st15(10);},
					12,{IFSeqNtSnr.st15(11);
						~cntSeqNtSnr15=0;
					}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqSnrBut16.free;
		~ifSeqSnrBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSnr16 = ~cntSeqNtSnr16 + 1;
				~cntSeqNtSnr16.switch(
					0,{},
					1, {IFSeqNtSnr.st16(0);},
					2, {IFSeqNtSnr.st16(1);},
					3, {IFSeqNtSnr.st16(2);},
					4, {IFSeqNtSnr.st16(3);},
					5, {IFSeqNtSnr.st16(4);},
					6, {IFSeqNtSnr.st16(5);},
					7, {IFSeqNtSnr.st16(6);},
					8, {IFSeqNtSnr.st16(7);},
					9, {IFSeqNtSnr.st16(8);},
					10, {IFSeqNtSnr.st16(9);},
					11,{IFSeqNtSnr.st16(10);},
					12,{IFSeqNtSnr.st16(11);
						~cntSeqNtSnr16=0;
					}
				)}
			);
			},
			'/ifSeq/2/16'
		);

	}//

	*st01 {|i=0|
		~seqNtSnr01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr01', i);
	}
	*st02 {|i=0|
		~seqNtSnr02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr02', i);
	}
	*st03 {|i=0|
		~seqNtSnr03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr03', i);
	}
	*st04 {|i=0|
		~seqNtSnr04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr04', i);
	}
	*st05 {|i=0|
		~seqNtSnr05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr05', i);
	}
	*st06 {|i=0|
		~seqNtSnr06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr06', i);
	}
	*st07 {|i=0|
		~seqNtSnr07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr07', i);
	}
	*st08 {|i=0|
		~seqNtSnr08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr08', i);
	}

	*st09 {|i=0|
		~seqNtSnr09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr09', i);
	}
	*st10 {|i=0|
		~seqNtSnr10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr10', i);
	}
	*st11 {|i=0|
		~seqNtSnr11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr11', i);
	}
	*st12 {|i=0|
		~seqNtSnr12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr12', i);
	}
	*st13 {|i=0|
		~seqNtSnr13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr13', i);
	}
	*st14 {|i=0|
		~seqNtSnr14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr14', i);
	}
	*st15 {|i=0|
		~seqNtSnr15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr15', i);
	}
	*st16 {|i=0|
		~seqNtSnr16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSnr16', i);
	}
	*stGrp {|i|

		IFSeqNtSnr.st01(i); IFSeqNtSnr.st02(i); IFSeqNtSnr.st03(i); IFSeqNtSnr.st04(i);
		IFSeqNtSnr.st05(i); IFSeqNtSnr.st06(i); IFSeqNtSnr.st07(i); IFSeqNtSnr.st08(i);
		IFSeqNtSnr.st09(i); IFSeqNtSnr.st10(i); IFSeqNtSnr.st11(i); IFSeqNtSnr.st12(i);
		IFSeqNtSnr.st13(i); IFSeqNtSnr.st14(i); IFSeqNtSnr.st15(i); IFSeqNtSnr.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqNtSnr.st01(s01); IFSeqNtSnr.st02(s02); IFSeqNtSnr.st03(s03); IFSeqNtSnr.st04(s04);
		IFSeqNtSnr.st05(s05); IFSeqNtSnr.st06(s06); IFSeqNtSnr.st07(s07); IFSeqNtSnr.st08(s08);
		IFSeqNtSnr.st09(s09); IFSeqNtSnr.st10(s10); IFSeqNtSnr.st11(s11); IFSeqNtSnr.st12(s12);
		IFSeqNtSnr.st13(s13); IFSeqNtSnr.st14(s14); IFSeqNtSnr.st15(s15); IFSeqNtSnr.st16(s16);
	}
}