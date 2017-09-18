IFSeqOctSnr {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqOctSnr01 = PatternProxy( Pseq([1], 1));
		~seqOctSnr02 = PatternProxy( Pseq([1], 1));
		~seqOctSnr03 = PatternProxy( Pseq([1], 1));
		~seqOctSnr04 = PatternProxy( Pseq([1], 1));
		~seqOctSnr05 = PatternProxy( Pseq([1], 1));
		~seqOctSnr06 = PatternProxy( Pseq([1], 1));
		~seqOctSnr07 = PatternProxy( Pseq([1], 1));
		~seqOctSnr08 = PatternProxy( Pseq([1], 1));

		~seqOctSnr09 = PatternProxy( Pseq([1], 1));
		~seqOctSnr10 = PatternProxy( Pseq([1], 1));
		~seqOctSnr11 = PatternProxy( Pseq([1], 1));
		~seqOctSnr12 = PatternProxy( Pseq([1], 1));
		~seqOctSnr13 = PatternProxy( Pseq([1], 1));
		~seqOctSnr14 = PatternProxy( Pseq([1], 1));
		~seqOctSnr15 = PatternProxy( Pseq([1], 1));
		~seqOctSnr16 = PatternProxy( Pseq([1], 1));

	}

	*countReset {
		~cntSeqOctUpSnr01=0;
		~cntSeqOctRandSnr01=0;

		~cntSeqOctSnr01=0;
		~cntSeqOctSnr02=0;
		~cntSeqOctSnr03=0;
		~cntSeqOctSnr04=0;
		~cntSeqOctSnr05=0;
		~cntSeqOctSnr06=0;
		~cntSeqOctSnr07=0;
		~cntSeqOctSnr08=0;

		~cntSeqOctSnr09=0;
		~cntSeqOctSnr10=0;
		~cntSeqOctSnr11=0;
		~cntSeqOctSnr12=0;
		~cntSeqOctSnr13=0;
		~cntSeqOctSnr14=0;
		~cntSeqOctSnr15=0;
		~cntSeqOctSnr16=0;
	}
	*freeOn {
		~seqFreeSnrBut.free;
		~seqFreeSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqOctSnr.stGrp(0);
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
				~cntSeqOctUpSnr01 = ~cntSeqOctUpSnr01 + 1;
				~cntSeqOctUpSnr01.switch(
					0,{},
					1,{IFSeqOctSnr.stGrp(0);},
					2,{IFSeqOctSnr.stGrp(1);},
					3,{IFSeqOctSnr.stGrp(2);},
					4,{IFSeqOctSnr.stGrp(3);},
					5,{IFSeqOctSnr.stGrp(4);},
					6,{IFSeqOctSnr.stGrp(5);},
					7,{IFSeqOctSnr.stGrp(6);},
					8,{IFSeqOctSnr.stGrp(7);
						~cntSeqOctUpSnr01=0;
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
				~cntSeqOctRandSnr01 = ~cntSeqOctRandSnr01 + 1;
				~cntSeqOctRandSnr01.switch(
					0,{},
					1,{
						IFSeqOctSnr.st01((0..7).choose);
						IFSeqOctSnr.st02((0..7).choose);
						IFSeqOctSnr.st03((0..7).choose);
						IFSeqOctSnr.st04((0..7).choose);
						IFSeqOctSnr.st05((0..7).choose);
						IFSeqOctSnr.st06((0..7).choose);
						IFSeqOctSnr.st07((0..7).choose);
						IFSeqOctSnr.st08((0..7).choose);

						IFSeqOctSnr.st09((0..7).choose);
						IFSeqOctSnr.st10((0..7).choose);
						IFSeqOctSnr.st11((0..7).choose);
						IFSeqOctSnr.st12((0..7).choose);
						IFSeqOctSnr.st13((0..7).choose);
						IFSeqOctSnr.st14((0..7).choose);
						IFSeqOctSnr.st15((0..7).choose);
						IFSeqOctSnr.st16((0..7).choose);
						~cntSeqOctRandSnr01=0;
					}
				)}
			);
			},
			'/seqRandSnr'
		);
	}

	*on { // Shift OCTAVE
		IFSeqOctSnr.randOn;
		IFSeqOctSnr.upOn;
		IFSeqOctSnr.freeOn;

		~ifSeqSnrBut01.free;
		~ifSeqSnrBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctSnr01 = ~cntSeqOctSnr01 + 1;
				~cntSeqOctSnr01.switch(
					0,{},
					1, {IFSeqOctSnr.st01(0);},
					2, {IFSeqOctSnr.st01(1);},
					3, {IFSeqOctSnr.st01(2);},
					4, {IFSeqOctSnr.st01(3);},
					5, {IFSeqOctSnr.st01(4);},
					6, {IFSeqOctSnr.st01(5);},
					7, {IFSeqOctSnr.st01(6);},
					8, {IFSeqOctSnr.st01(7);
						~cntSeqOctSnr01=0;
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
				~cntSeqOctSnr02 = ~cntSeqOctSnr02 + 1;
				~cntSeqOctSnr02.switch(
					0,{},
					1, {IFSeqOctSnr.st02(0);},
					2, {IFSeqOctSnr.st02(1);},
					3, {IFSeqOctSnr.st02(2);},
					4, {IFSeqOctSnr.st02(3);},
					5, {IFSeqOctSnr.st02(4);},
					6, {IFSeqOctSnr.st02(5);},
					7, {IFSeqOctSnr.st02(6);},
					8, {IFSeqOctSnr.st02(7);
						~cntSeqOctSnr02=0;
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
				~cntSeqOctSnr03 = ~cntSeqOctSnr03 + 1;
				~cntSeqOctSnr03.switch(
					0,{},
					1, {IFSeqOctSnr.st03(0);},
					2, {IFSeqOctSnr.st03(1);},
					3, {IFSeqOctSnr.st03(2);},
					4, {IFSeqOctSnr.st03(3);},
					5, {IFSeqOctSnr.st03(4);},
					6, {IFSeqOctSnr.st03(5);},
					7, {IFSeqOctSnr.st03(6);},
					8, {IFSeqOctSnr.st03(7);
						~cntSeqOctSnr03=0;
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
				~cntSeqOctSnr04 = ~cntSeqOctSnr04 + 1;
				~cntSeqOctSnr04.switch(
					0,{},
					1, {IFSeqOctSnr.st04(0);},
					2, {IFSeqOctSnr.st04(1);},
					3, {IFSeqOctSnr.st04(2);},
					4, {IFSeqOctSnr.st04(3);},
					5, {IFSeqOctSnr.st04(4);},
					6, {IFSeqOctSnr.st04(5);},
					7, {IFSeqOctSnr.st04(6);},
					8, {IFSeqOctSnr.st04(7);
						~cntSeqOctSnr04=0;
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
				~cntSeqOctSnr05 = ~cntSeqOctSnr05 + 1;
				~cntSeqOctSnr05.switch(
					0,{},
					1, {IFSeqOctSnr.st05(0);},
					2, {IFSeqOctSnr.st05(1);},
					3, {IFSeqOctSnr.st05(2);},
					4, {IFSeqOctSnr.st05(3);},
					5, {IFSeqOctSnr.st05(4);},
					6, {IFSeqOctSnr.st05(5);},
					7, {IFSeqOctSnr.st05(6);},
					8, {IFSeqOctSnr.st05(7);
						~cntSeqOctSnr05=0;
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
				~cntSeqOctSnr06 = ~cntSeqOctSnr06 + 1;
				~cntSeqOctSnr06.switch(
					0,{},
					1, {IFSeqOctSnr.st06(0);},
					2, {IFSeqOctSnr.st06(1);},
					3, {IFSeqOctSnr.st06(2);},
					4, {IFSeqOctSnr.st06(3);},
					5, {IFSeqOctSnr.st06(4);},
					6, {IFSeqOctSnr.st06(5);},
					7, {IFSeqOctSnr.st06(6);},
					8, {IFSeqOctSnr.st06(7);
						~cntSeqOctSnr06=0;
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
				~cntSeqOctSnr07 = ~cntSeqOctSnr07 + 1;
				~cntSeqOctSnr07.switch(
					0,{},
					1, {IFSeqOctSnr.st07(0);},
					2, {IFSeqOctSnr.st07(1);},
					3, {IFSeqOctSnr.st07(2);},
					4, {IFSeqOctSnr.st07(3);},
					5, {IFSeqOctSnr.st07(4);},
					6, {IFSeqOctSnr.st07(5);},
					7, {IFSeqOctSnr.st07(6);},
					8, {IFSeqOctSnr.st07(7);
						~cntSeqOctSnr07=0;
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
				~cntSeqOctSnr08 = ~cntSeqOctSnr08 + 1;
				~cntSeqOctSnr08.switch(
					0,{},
					1, {IFSeqOctSnr.st08(0);},
					2, {IFSeqOctSnr.st08(1);},
					3, {IFSeqOctSnr.st08(2);},
					4, {IFSeqOctSnr.st08(3);},
					5, {IFSeqOctSnr.st08(4);},
					6, {IFSeqOctSnr.st08(5);},
					7, {IFSeqOctSnr.st08(6);},
					8, {IFSeqOctSnr.st08(7);
						~cntSeqOctSnr08=0;
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
				~cntSeqOctSnr09 = ~cntSeqOctSnr09 + 1;
				~cntSeqOctSnr09.switch(
					0,{},
					1, {IFSeqOctSnr.st09(0);},
					2, {IFSeqOctSnr.st09(1);},
					3, {IFSeqOctSnr.st09(2);},
					4, {IFSeqOctSnr.st09(3);},
					5, {IFSeqOctSnr.st09(4);},
					6, {IFSeqOctSnr.st09(5);},
					7, {IFSeqOctSnr.st09(6);},
					8, {IFSeqOctSnr.st09(7);
						~cntSeqOctSnr09=0;
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
				~cntSeqOctSnr10 = ~cntSeqOctSnr10 + 1;
				~cntSeqOctSnr10.switch(
					0,{},
					1, {IFSeqOctSnr.st10(0);},
					2, {IFSeqOctSnr.st10(1);},
					3, {IFSeqOctSnr.st10(2);},
					4, {IFSeqOctSnr.st10(3);},
					5, {IFSeqOctSnr.st10(4);},
					6, {IFSeqOctSnr.st10(5);},
					7, {IFSeqOctSnr.st10(6);},
					8, {IFSeqOctSnr.st10(7);
						~cntSeqOctSnr10=0;
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
				~cntSeqOctSnr11 = ~cntSeqOctSnr11 + 1;
				~cntSeqOctSnr11.switch(
					0,{},
					1, {IFSeqOctSnr.st11(0);},
					2, {IFSeqOctSnr.st11(1);},
					3, {IFSeqOctSnr.st11(2);},
					4, {IFSeqOctSnr.st11(3);},
					5, {IFSeqOctSnr.st11(4);},
					6, {IFSeqOctSnr.st11(5);},
					7, {IFSeqOctSnr.st11(6);},
					8, {IFSeqOctSnr.st11(7);
						~cntSeqOctSnr11=0;
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
				~cntSeqOctSnr12 = ~cntSeqOctSnr12 + 1;
				~cntSeqOctSnr12.switch(
					0,{},
					1, {IFSeqOctSnr.st12(0);},
					2, {IFSeqOctSnr.st12(1);},
					3, {IFSeqOctSnr.st12(2);},
					4, {IFSeqOctSnr.st12(3);},
					5, {IFSeqOctSnr.st12(4);},
					6, {IFSeqOctSnr.st12(5);},
					7, {IFSeqOctSnr.st12(6);},
					8, {IFSeqOctSnr.st12(7);
						~cntSeqOctSnr12=0;
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
				~cntSeqOctSnr13 = ~cntSeqOctSnr13 + 1;
				~cntSeqOctSnr13.switch(
					0,{},
					1, {IFSeqOctSnr.st13(0);},
					2, {IFSeqOctSnr.st13(1);},
					3, {IFSeqOctSnr.st13(2);},
					4, {IFSeqOctSnr.st13(3);},
					5, {IFSeqOctSnr.st13(4);},
					6, {IFSeqOctSnr.st13(5);},
					7, {IFSeqOctSnr.st13(6);},
					8, {IFSeqOctSnr.st13(7);
						~cntSeqOctSnr13=0;
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
				~cntSeqOctSnr14 = ~cntSeqOctSnr14 + 1;
				~cntSeqOctSnr14.switch(
					0,{},
					1, {IFSeqOctSnr.st14(0);},
					2, {IFSeqOctSnr.st14(1);},
					3, {IFSeqOctSnr.st14(2);},
					4, {IFSeqOctSnr.st14(3);},
					5, {IFSeqOctSnr.st14(4);},
					6, {IFSeqOctSnr.st14(5);},
					7, {IFSeqOctSnr.st14(6);},
					8, {IFSeqOctSnr.st14(7);
						~cntSeqOctSnr14=0;
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
				~cntSeqOctSnr15 = ~cntSeqOctSnr15 + 1;
				~cntSeqOctSnr15.switch(
					0,{},
					1, {IFSeqOctSnr.st15(0);},
					2, {IFSeqOctSnr.st15(1);},
					3, {IFSeqOctSnr.st15(2);},
					4, {IFSeqOctSnr.st15(3);},
					5, {IFSeqOctSnr.st15(4);},
					6, {IFSeqOctSnr.st15(5);},
					7, {IFSeqOctSnr.st15(6);},
					8, {IFSeqOctSnr.st15(7);
						~cntSeqOctSnr15=0;
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
				~cntSeqOctSnr16 = ~cntSeqOctSnr16 + 1;
				~cntSeqOctSnr16.switch(
					0,{},
					1, {IFSeqOctSnr.st16(0);},
					2, {IFSeqOctSnr.st16(1);},
					3, {IFSeqOctSnr.st16(2);},
					4, {IFSeqOctSnr.st16(3);},
					5, {IFSeqOctSnr.st16(4);},
					6, {IFSeqOctSnr.st16(5);},
					7, {IFSeqOctSnr.st16(6);},
					8, {IFSeqOctSnr.st16(7);
						~cntSeqOctSnr16=0;
					}
				)}
			);
			},
			'/ifSeq/2/16'
		);

	}//

	*st01 {|i=0|
		~seqOctSnr01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr01', i);
	}
	*st02 {|i=0|
		~seqOctSnr02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr02', i);
	}
	*st03 {|i=0|
		~seqOctSnr03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr03', i);
	}
	*st04 {|i=0|
		~seqOctSnr04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr04', i);
	}
	*st05 {|i=0|
		~seqOctSnr05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr05', i);
	}
	*st06 {|i=0|
		~seqOctSnr06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr06', i);
	}
	*st07 {|i=0|
		~seqOctSnr07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr07', i);
	}
	*st08 {|i=0|
		~seqOctSnr08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr08', i);
	}
	*st09 {|i=0|
		~seqOctSnr09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr09', i);
	}
	*st10 {|i=0|
		~seqOctSnr10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr10', i);
	}
	*st11 {|i=0|
		~seqOctSnr11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr11', i);
	}
	*st12 {|i=0|
		~seqOctSnr12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr12', i);
	}
	*st13 {|i=0|
		~seqOctSnr13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr13', i);
	}
	*st14 {|i=0|
		~seqOctSnr14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr14', i);
	}
	*st15 {|i=0|
		~seqOctSnr15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr15', i);
	}
	*st16 {|i=0|
		~seqOctSnr16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSnr16', i);
	}
	*stGrp {|i|

		IFSeqOctSnr.st01(i); IFSeqOctSnr.st02(i); IFSeqOctSnr.st03(i); IFSeqOctSnr.st04(i);
		IFSeqOctSnr.st05(i); IFSeqOctSnr.st06(i); IFSeqOctSnr.st07(i); IFSeqOctSnr.st08(i);
		IFSeqOctSnr.st09(i); IFSeqOctSnr.st10(i); IFSeqOctSnr.st11(i); IFSeqOctSnr.st12(i);
		IFSeqOctSnr.st13(i); IFSeqOctSnr.st14(i); IFSeqOctSnr.st15(i); IFSeqOctSnr.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqOctSnr.st01(s01); IFSeqOctSnr.st02(s02); IFSeqOctSnr.st03(s03); IFSeqOctSnr.st04(s04);
		IFSeqOctSnr.st05(s05); IFSeqOctSnr.st06(s06); IFSeqOctSnr.st07(s07); IFSeqOctSnr.st08(s08);
		IFSeqOctSnr.st09(s09); IFSeqOctSnr.st10(s10); IFSeqOctSnr.st11(s11); IFSeqOctSnr.st12(s12);
		IFSeqOctSnr.st13(s13); IFSeqOctSnr.st14(s14); IFSeqOctSnr.st15(s15); IFSeqOctSnr.st16(s16);
	}
}