IFSeqOctMopho {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqOctMopho01 = PatternProxy( Pseq([1], 1));
		~seqOctMopho02 = PatternProxy( Pseq([1], 1));
		~seqOctMopho03 = PatternProxy( Pseq([1], 1));
		~seqOctMopho04 = PatternProxy( Pseq([1], 1));
		~seqOctMopho05 = PatternProxy( Pseq([1], 1));
		~seqOctMopho06 = PatternProxy( Pseq([1], 1));
		~seqOctMopho07 = PatternProxy( Pseq([1], 1));
		~seqOctMopho08 = PatternProxy( Pseq([1], 1));

		~seqOctMopho09 = PatternProxy( Pseq([1], 1));
		~seqOctMopho10 = PatternProxy( Pseq([1], 1));
		~seqOctMopho11 = PatternProxy( Pseq([1], 1));
		~seqOctMopho12 = PatternProxy( Pseq([1], 1));
		~seqOctMopho13 = PatternProxy( Pseq([1], 1));
		~seqOctMopho14 = PatternProxy( Pseq([1], 1));
		~seqOctMopho15 = PatternProxy( Pseq([1], 1));
		~seqOctMopho16 = PatternProxy( Pseq([1], 1));

	}

	*countReset {
		~cntSeqOctUpMopho01=0;
		~cntSeqOctRandMopho01=0;

		~cntSeqOctMopho01=0;
		~cntSeqOctMopho02=0;
		~cntSeqOctMopho03=0;
		~cntSeqOctMopho04=0;
		~cntSeqOctMopho05=0;
		~cntSeqOctMopho06=0;
		~cntSeqOctMopho07=0;
		~cntSeqOctMopho08=0;

		~cntSeqOctMopho09=0;
		~cntSeqOctMopho10=0;
		~cntSeqOctMopho11=0;
		~cntSeqOctMopho12=0;
		~cntSeqOctMopho13=0;
		~cntSeqOctMopho14=0;
		~cntSeqOctMopho15=0;
		~cntSeqOctMopho16=0;
	}
	*freeOn {
		~seqFreeMophoBut.free;
		~seqFreeMophoBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqOctMopho.stGrp(0);
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
				~cntSeqOctUpMopho01 = ~cntSeqOctUpMopho01 + 1;
				~cntSeqOctUpMopho01.switch(
					0,{},
					1,{IFSeqOctMopho.stGrp(0);},
					2,{IFSeqOctMopho.stGrp(1);},
					3,{IFSeqOctMopho.stGrp(2);},
					4,{IFSeqOctMopho.stGrp(3);},
					5,{IFSeqOctMopho.stGrp(4);},
					6,{IFSeqOctMopho.stGrp(5);},
					7,{IFSeqOctMopho.stGrp(6);},
					8,{IFSeqOctMopho.stGrp(7);},
					9,{IFSeqOctMopho.stGrp(8);},
					10,{IFSeqOctMopho.stGrp(9);},
					11,{IFSeqOctMopho.stGrp(10);
						~cntSeqOctUpMopho01=0;
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
				~cntSeqOctRandMopho01 = ~cntSeqOctRandMopho01 + 1;
				~cntSeqOctRandMopho01.switch(
					0,{},
					1,{
						IFSeqOctMopho.st01((0..10).choose);
						IFSeqOctMopho.st02((0..10).choose);
						IFSeqOctMopho.st03((0..10).choose);
						IFSeqOctMopho.st04((0..10).choose);
						IFSeqOctMopho.st05((0..10).choose);
						IFSeqOctMopho.st06((0..10).choose);
						IFSeqOctMopho.st07((0..10).choose);
						IFSeqOctMopho.st08((0..10).choose);

						IFSeqOctMopho.st09((0..10).choose);
						IFSeqOctMopho.st10((0..10).choose);
						IFSeqOctMopho.st11((0..10).choose);
						IFSeqOctMopho.st12((0..10).choose);
						IFSeqOctMopho.st13((0..10).choose);
						IFSeqOctMopho.st14((0..10).choose);
						IFSeqOctMopho.st15((0..10).choose);
						IFSeqOctMopho.st16((0..10).choose);
						~cntSeqOctRandMopho01=0;
					}
				)}
			);
			},
			'/seqRandMopho'
		);
	}

	*on { // Shift OCTAVE
		IFSeqOctMopho.randOn;
		IFSeqOctMopho.upOn;
		IFSeqOctMopho.freeOn;

		~ifSeqMophoBut01.free;
		~ifSeqMophoBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctMopho01 = ~cntSeqOctMopho01 + 1;
				~cntSeqOctMopho01.switch(
					0,{},
					1, {IFSeqOctMopho.st01(0);},
					2, {IFSeqOctMopho.st01(1);},
					3, {IFSeqOctMopho.st01(2);},
					4, {IFSeqOctMopho.st01(3);},
					5, {IFSeqOctMopho.st01(4);},
					6, {IFSeqOctMopho.st01(5);},
					7, {IFSeqOctMopho.st01(6);},
					8, {IFSeqOctMopho.st01(7);},
					9, {IFSeqOctMopho.st01(8);},
					10,{IFSeqOctMopho.st01(9);},
					11,{IFSeqOctMopho.st01(10);
						~cntSeqOctMopho01=0;
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
				~cntSeqOctMopho02 = ~cntSeqOctMopho02 + 1;
				~cntSeqOctMopho02.switch(
					0,{},
					1, {IFSeqOctMopho.st02(0);},
					2, {IFSeqOctMopho.st02(1);},
					3, {IFSeqOctMopho.st02(2);},
					4, {IFSeqOctMopho.st02(3);},
					5, {IFSeqOctMopho.st02(4);},
					6, {IFSeqOctMopho.st02(5);},
					7, {IFSeqOctMopho.st02(6);},
					8, {IFSeqOctMopho.st02(7);},
					9, {IFSeqOctMopho.st02(8);},
					10, {IFSeqOctMopho.st02(9);},
					11,{
						IFSeqOctMopho.st02(10);
						~cntSeqOctMopho02=0;
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
				~cntSeqOctMopho03 = ~cntSeqOctMopho03 + 1;
				~cntSeqOctMopho03.switch(
					0,{},
					1, {IFSeqOctMopho.st03(0);},
					2, {IFSeqOctMopho.st03(1);},
					3, {IFSeqOctMopho.st03(2);},
					4, {IFSeqOctMopho.st03(3);},
					5, {IFSeqOctMopho.st03(4);},
					6, {IFSeqOctMopho.st03(5);},
					7, {IFSeqOctMopho.st03(6);},
					8, {IFSeqOctMopho.st03(7);},
					9, {IFSeqOctMopho.st03(8);},
					10, {IFSeqOctMopho.st03(9);},
					11,{
						IFSeqOctMopho.st03(10);
						~cntSeqOctMopho03=0;
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
				~cntSeqOctMopho04 = ~cntSeqOctMopho04 + 1;
				~cntSeqOctMopho04.switch(
					0,{},
					1, {IFSeqOctMopho.st04(0);},
					2, {IFSeqOctMopho.st04(1);},
					3, {IFSeqOctMopho.st04(2);},
					4, {IFSeqOctMopho.st04(3);},
					5, {IFSeqOctMopho.st04(4);},
					6, {IFSeqOctMopho.st04(5);},
					7, {IFSeqOctMopho.st04(6);},
					8, {IFSeqOctMopho.st04(7);},
					9, {IFSeqOctMopho.st04(8);},
					10, {IFSeqOctMopho.st04(9);},
					11,{
						IFSeqOctMopho.st04(10);
						~cntSeqOctMopho04=0;
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
				~cntSeqOctMopho05 = ~cntSeqOctMopho05 + 1;
				~cntSeqOctMopho05.switch(
					0,{},
					1, {IFSeqOctMopho.st05(0);},
					2, {IFSeqOctMopho.st05(1);},
					3, {IFSeqOctMopho.st05(2);},
					4, {IFSeqOctMopho.st05(3);},
					5, {IFSeqOctMopho.st05(4);},
					6, {IFSeqOctMopho.st05(5);},
					7, {IFSeqOctMopho.st05(6);},
					8, {IFSeqOctMopho.st05(7);},
					9, {IFSeqOctMopho.st05(8);},
					10, {IFSeqOctMopho.st05(9);},
					11,{
						IFSeqOctMopho.st05(10);
						~cntSeqOctMopho05=0;
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
				~cntSeqOctMopho06 = ~cntSeqOctMopho06 + 1;
				~cntSeqOctMopho06.switch(
					0,{},
					1, {IFSeqOctMopho.st06(0);},
					2, {IFSeqOctMopho.st06(1);},
					3, {IFSeqOctMopho.st06(2);},
					4, {IFSeqOctMopho.st06(3);},
					5, {IFSeqOctMopho.st06(4);},
					6, {IFSeqOctMopho.st06(5);},
					7, {IFSeqOctMopho.st06(6);},
					8, {IFSeqOctMopho.st06(7);},
					9, {IFSeqOctMopho.st06(8);},
					10, {IFSeqOctMopho.st06(9);},
					11,{
						IFSeqOctMopho.st06(10);
						~cntSeqOctMopho06=0;
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
				~cntSeqOctMopho07 = ~cntSeqOctMopho07 + 1;
				~cntSeqOctMopho07.switch(
					0,{},
					1, {IFSeqOctMopho.st07(0);},
					2, {IFSeqOctMopho.st07(1);},
					3, {IFSeqOctMopho.st07(2);},
					4, {IFSeqOctMopho.st07(3);},
					5, {IFSeqOctMopho.st07(4);},
					6, {IFSeqOctMopho.st07(5);},
					7, {IFSeqOctMopho.st07(6);},
					8, {IFSeqOctMopho.st07(7);},
					9, {IFSeqOctMopho.st07(8);},
					10, {IFSeqOctMopho.st07(9);},
					11,{
						IFSeqOctMopho.st07(10);
						~cntSeqOctMopho07=0;
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
				~cntSeqOctMopho08 = ~cntSeqOctMopho08 + 1;
				~cntSeqOctMopho08.switch(
					0,{},
					1, {IFSeqOctMopho.st08(0);},
					2, {IFSeqOctMopho.st08(1);},
					3, {IFSeqOctMopho.st08(2);},
					4, {IFSeqOctMopho.st08(3);},
					5, {IFSeqOctMopho.st08(4);},
					6, {IFSeqOctMopho.st08(5);},
					7, {IFSeqOctMopho.st08(6);},
					8, {IFSeqOctMopho.st08(7);},
					9, {IFSeqOctMopho.st08(8);},
					10, {IFSeqOctMopho.st08(9);},
					11,{
						IFSeqOctMopho.st08(10);
						~cntSeqOctMopho08=0;
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
				~cntSeqOctMopho09 = ~cntSeqOctMopho09 + 1;
				~cntSeqOctMopho09.switch(
					0,{},
					1, {IFSeqOctMopho.st09(0);},
					2, {IFSeqOctMopho.st09(1);},
					3, {IFSeqOctMopho.st09(2);},
					4, {IFSeqOctMopho.st09(3);},
					5, {IFSeqOctMopho.st09(4);},
					6, {IFSeqOctMopho.st09(5);},
					7, {IFSeqOctMopho.st09(6);},
					8, {IFSeqOctMopho.st09(7);},
					9, {IFSeqOctMopho.st09(8);},
					10, {IFSeqOctMopho.st09(9);},
					11,{
						IFSeqOctMopho.st09(10);
						~cntSeqOctMopho09=0;
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
				~cntSeqOctMopho10 = ~cntSeqOctMopho10 + 1;
				~cntSeqOctMopho10.switch(
					0,{},
					1, {IFSeqOctMopho.st10(0);},
					2, {IFSeqOctMopho.st10(1);},
					3, {IFSeqOctMopho.st10(2);},
					4, {IFSeqOctMopho.st10(3);},
					5, {IFSeqOctMopho.st10(4);},
					6, {IFSeqOctMopho.st10(5);},
					7, {IFSeqOctMopho.st10(6);},
					8, {IFSeqOctMopho.st10(7);},
					9, {IFSeqOctMopho.st10(8);},
					10, {IFSeqOctMopho.st10(9);},
					11,{
						IFSeqOctMopho.st10(10);
						~cntSeqOctMopho10=0;
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
				~cntSeqOctMopho11 = ~cntSeqOctMopho11 + 1;
				~cntSeqOctMopho11.switch(
					0,{},
					1, {IFSeqOctMopho.st11(0);},
					2, {IFSeqOctMopho.st11(1);},
					3, {IFSeqOctMopho.st11(2);},
					4, {IFSeqOctMopho.st11(3);},
					5, {IFSeqOctMopho.st11(4);},
					6, {IFSeqOctMopho.st11(5);},
					7, {IFSeqOctMopho.st11(6);},
					8, {IFSeqOctMopho.st11(7);},
					9, {IFSeqOctMopho.st11(8);},
					10, {IFSeqOctMopho.st11(9);},
					11,{
						IFSeqOctMopho.st11(10);
						~cntSeqOctMopho11=0;
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
				~cntSeqOctMopho12 = ~cntSeqOctMopho12 + 1;
				~cntSeqOctMopho12.switch(
					0,{},
					1, {IFSeqOctMopho.st12(0);},
					2, {IFSeqOctMopho.st12(1);},
					3, {IFSeqOctMopho.st12(2);},
					4, {IFSeqOctMopho.st12(3);},
					5, {IFSeqOctMopho.st12(4);},
					6, {IFSeqOctMopho.st12(5);},
					7, {IFSeqOctMopho.st12(6);},
					8, {IFSeqOctMopho.st12(7);},
					9, {IFSeqOctMopho.st12(8);},
					10, {IFSeqOctMopho.st12(9);},
					11,{
						IFSeqOctMopho.st12(10);
						~cntSeqOctMopho12=0;
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
				~cntSeqOctMopho13 = ~cntSeqOctMopho13 + 1;
				~cntSeqOctMopho13.switch(
					0,{},
					1, {IFSeqOctMopho.st13(0);},
					2, {IFSeqOctMopho.st13(1);},
					3, {IFSeqOctMopho.st13(2);},
					4, {IFSeqOctMopho.st13(3);},
					5, {IFSeqOctMopho.st13(4);},
					6, {IFSeqOctMopho.st13(5);},
					7, {IFSeqOctMopho.st13(6);},
					8, {IFSeqOctMopho.st13(7);},
					9, {IFSeqOctMopho.st13(8);},
					10, {IFSeqOctMopho.st13(9);},
					11,{
						IFSeqOctMopho.st13(10);
						~cntSeqOctMopho13=0;
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
				~cntSeqOctMopho14 = ~cntSeqOctMopho14 + 1;
				~cntSeqOctMopho14.switch(
					0,{},
					1, {IFSeqOctMopho.st14(0);},
					2, {IFSeqOctMopho.st14(1);},
					3, {IFSeqOctMopho.st14(2);},
					4, {IFSeqOctMopho.st14(3);},
					5, {IFSeqOctMopho.st14(4);},
					6, {IFSeqOctMopho.st14(5);},
					7, {IFSeqOctMopho.st14(6);},
					8, {IFSeqOctMopho.st14(7);},
					9, {IFSeqOctMopho.st14(8);},
					10, {IFSeqOctMopho.st14(9);},
					11,{
						IFSeqOctMopho.st14(10);
						~cntSeqOctMopho14=0;
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
				~cntSeqOctMopho15 = ~cntSeqOctMopho15 + 1;
				~cntSeqOctMopho15.switch(
					0,{},
					1, {IFSeqOctMopho.st15(0);},
					2, {IFSeqOctMopho.st15(1);},
					3, {IFSeqOctMopho.st15(2);},
					4, {IFSeqOctMopho.st15(3);},
					5, {IFSeqOctMopho.st15(4);},
					6, {IFSeqOctMopho.st15(5);},
					7, {IFSeqOctMopho.st15(6);},
					8, {IFSeqOctMopho.st15(7);},
					9, {IFSeqOctMopho.st15(8);},
					10, {IFSeqOctMopho.st15(9);},
					11,{
						IFSeqOctMopho.st15(10);
						~cntSeqOctMopho15=0;
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
				~cntSeqOctMopho16 = ~cntSeqOctMopho16 + 1;
				~cntSeqOctMopho16.switch(
					0,{},
					1, {IFSeqOctMopho.st16(0);},
					2, {IFSeqOctMopho.st16(1);},
					3, {IFSeqOctMopho.st16(2);},
					4, {IFSeqOctMopho.st16(3);},
					5, {IFSeqOctMopho.st16(4);},
					6, {IFSeqOctMopho.st16(5);},
					7, {IFSeqOctMopho.st16(6);},
					8, {IFSeqOctMopho.st16(7);},
					9, {IFSeqOctMopho.st16(8);},
					10, {IFSeqOctMopho.st16(9);},
					11,{
						IFSeqOctMopho.st16(10);
						~cntSeqOctMopho16=0;
					}
				)}
			);
			},
			'/ifSeq/7/16'
		);

	}//

	*st01 {|i=0|
		~seqOctMopho01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho01', i);
	}
	*st02 {|i=0|
		~seqOctMopho02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho02', i);
	}
	*st03 {|i=0|
		~seqOctMopho03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho03', i);
	}
	*st04 {|i=0|
		~seqOctMopho04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho04', i);
	}
	*st05 {|i=0|
		~seqOctMopho05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho05', i);
	}
	*st06 {|i=0|
		~seqOctMopho06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho06', i);
	}
	*st07 {|i=0|
		~seqOctMopho07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho07', i);
	}
	*st08 {|i=0|
		~seqOctMopho08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho08', i);
	}
	*st09 {|i=0|
		~seqOctMopho09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho09', i);
	}
	*st10 {|i=0|
		~seqOctMopho10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho10', i);
	}
	*st11 {|i=0|
		~seqOctMopho11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho11', i);
	}
	*st12 {|i=0|
		~seqOctMopho12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho12', i);
	}
	*st13 {|i=0|
		~seqOctMopho13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho13', i);
	}
	*st14 {|i=0|
		~seqOctMopho14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho14', i);
	}
	*st15 {|i=0|
		~seqOctMopho15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho15', i);
	}
	*st16 {|i=0|
		~seqOctMopho16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctMopho16', i);
	}
	*stGrp {|i|

		IFSeqOctMopho.st01(i); IFSeqOctMopho.st02(i); IFSeqOctMopho.st03(i); IFSeqOctMopho.st04(i);
		IFSeqOctMopho.st05(i); IFSeqOctMopho.st06(i); IFSeqOctMopho.st07(i); IFSeqOctMopho.st08(i);
		IFSeqOctMopho.st09(i); IFSeqOctMopho.st10(i); IFSeqOctMopho.st11(i); IFSeqOctMopho.st12(i);
		IFSeqOctMopho.st13(i); IFSeqOctMopho.st14(i); IFSeqOctMopho.st15(i); IFSeqOctMopho.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqOctMopho.st01(s01); IFSeqOctMopho.st02(s02); IFSeqOctMopho.st03(s03); IFSeqOctMopho.st04(s04);
		IFSeqOctMopho.st05(s05); IFSeqOctMopho.st06(s06); IFSeqOctMopho.st07(s07); IFSeqOctMopho.st08(s08);
		IFSeqOctMopho.st09(s09); IFSeqOctMopho.st10(s10); IFSeqOctMopho.st11(s11); IFSeqOctMopho.st12(s12);
		IFSeqOctMopho.st13(s13); IFSeqOctMopho.st14(s14); IFSeqOctMopho.st15(s15); IFSeqOctMopho.st16(s16);
	}
}