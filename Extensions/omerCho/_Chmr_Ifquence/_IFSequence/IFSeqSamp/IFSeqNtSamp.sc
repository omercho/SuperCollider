IFSeqNtSamp {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqNtSamp01 = PatternProxy( Pseq([0], 1));
		~seqNtSamp02 = PatternProxy( Pseq([0], 1));
		~seqNtSamp03 = PatternProxy( Pseq([0], 1));
		~seqNtSamp04 = PatternProxy( Pseq([0], 1));
		~seqNtSamp05 = PatternProxy( Pseq([0], 1));
		~seqNtSamp06 = PatternProxy( Pseq([0], 1));
		~seqNtSamp07 = PatternProxy( Pseq([0], 1));
		~seqNtSamp08 = PatternProxy( Pseq([0], 1));

		~seqNtSamp09 = PatternProxy( Pseq([0], 1));
		~seqNtSamp10 = PatternProxy( Pseq([0], 1));
		~seqNtSamp11 = PatternProxy( Pseq([0], 1));
		~seqNtSamp12 = PatternProxy( Pseq([0], 1));
		~seqNtSamp13 = PatternProxy( Pseq([0], 1));
		~seqNtSamp14 = PatternProxy( Pseq([0], 1));
		~seqNtSamp15 = PatternProxy( Pseq([0], 1));
		~seqNtSamp16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqNtUpSamp01=0;
		~cntSeqNtRandSamp01=0;

		~cntSeqNtSamp01=0;
		~cntSeqNtSamp02=0;
		~cntSeqNtSamp03=0;
		~cntSeqNtSamp04=0;
		~cntSeqNtSamp05=0;
		~cntSeqNtSamp06=0;
		~cntSeqNtSamp07=0;
		~cntSeqNtSamp08=0;

		~cntSeqNtSamp09=0;
		~cntSeqNtSamp10=0;
		~cntSeqNtSamp11=0;
		~cntSeqNtSamp12=0;
		~cntSeqNtSamp13=0;
		~cntSeqNtSamp14=0;
		~cntSeqNtSamp15=0;
		~cntSeqNtSamp16=0;
	}
	*freeOn {
		~seqFreeSampBut.free;
		~seqFreeSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqNtSamp.stGrp(0);
				});
			},
			'/seqFreeSamp'
		);

	}

	*upOn {
		~ifSeqUpSampBut.free;
		~ifSeqUpSampBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtUpSamp01 = ~cntSeqNtUpSamp01 + 1;
				~cntSeqNtUpSamp01.switch(
					0,{},
					1,{IFSeqNtSamp.stGrp(0);},
					2,{IFSeqNtSamp.stGrp(1);},
					3,{IFSeqNtSamp.stGrp(2);},
					4,{IFSeqNtSamp.stGrp(3);},
					5,{IFSeqNtSamp.stGrp(4);},
					6,{IFSeqNtSamp.stGrp(5);},
					7,{IFSeqNtSamp.stGrp(6);},
					8,{IFSeqNtSamp.stGrp(7);},
					9,{IFSeqNtSamp.stGrp(8);},
					10,{IFSeqNtSamp.stGrp(9);},
					11,{IFSeqNtSamp.stGrp(10);},
					12,{IFSeqNtSamp.stGrp(11);
						~cntSeqNtUpSamp01=0;
					}
				)}
			);
			},
			'/seqUpSamp'
		);
	}

	*randOn {
		~ifSeqRandSampBut.free;
		~ifSeqRandSampBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtRandSamp01 = ~cntSeqNtRandSamp01 + 1;
				~cntSeqNtRandSamp01.switch(
					0,{},
					1,{
						IFSeqNtSamp.st01((0..11).choose);
						IFSeqNtSamp.st02((0..11).choose);
						IFSeqNtSamp.st03((0..11).choose);
						IFSeqNtSamp.st04((0..11).choose);
						IFSeqNtSamp.st05((0..11).choose);
						IFSeqNtSamp.st06((0..11).choose);
						IFSeqNtSamp.st07((0..11).choose);
						IFSeqNtSamp.st08((0..11).choose);

						IFSeqNtSamp.st09((0..11).choose);
						IFSeqNtSamp.st10((0..11).choose);
						IFSeqNtSamp.st11((0..11).choose);
						IFSeqNtSamp.st12((0..11).choose);
						IFSeqNtSamp.st13((0..11).choose);
						IFSeqNtSamp.st14((0..11).choose);
						IFSeqNtSamp.st15((0..11).choose);
						IFSeqNtSamp.st16((0..11).choose);
						~cntSeqNtRandSamp01=0;
					}
				)}
			);
			},
			'/seqRandSamp'
		);
	}

	*on { // Shift NtAVE
		IFSeqNtSamp.randOn;
		IFSeqNtSamp.upOn;
		IFSeqNtSamp.freeOn;

		~ifSeqSampBut01.free;
		~ifSeqSampBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp01 = ~cntSeqNtSamp01 + 1;
				~cntSeqNtSamp01.switch(
					0,{},
					1, {IFSeqNtSamp.st01(0);},
					2, {IFSeqNtSamp.st01(1);},
					3, {IFSeqNtSamp.st01(2);},
					4, {IFSeqNtSamp.st01(3);},
					5, {IFSeqNtSamp.st01(4);},
					6, {IFSeqNtSamp.st01(5);},
					7, {IFSeqNtSamp.st01(6);},
					8, {IFSeqNtSamp.st01(7);},
					9, {IFSeqNtSamp.st01(8);},
					10,{IFSeqNtSamp.st01(9);},
					11,{IFSeqNtSamp.st01(10);},
					12,{IFSeqNtSamp.st01(11);
						~cntSeqNtSamp01=0;
					}
				)}
			);
			},
			'/ifSeq/6/1'
		);
		~ifSeqSampBut02.free;
		~ifSeqSampBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp02 = ~cntSeqNtSamp02 + 1;
				~cntSeqNtSamp02.switch(
					0,{},
					1, {IFSeqNtSamp.st02(0);},
					2, {IFSeqNtSamp.st02(1);},
					3, {IFSeqNtSamp.st02(2);},
					4, {IFSeqNtSamp.st02(3);},
					5, {IFSeqNtSamp.st02(4);},
					6, {IFSeqNtSamp.st02(5);},
					7, {IFSeqNtSamp.st02(6);},
					8, {IFSeqNtSamp.st02(7);},
					9, {IFSeqNtSamp.st02(8);},
					10, {IFSeqNtSamp.st02(9);},
					11,{IFSeqNtSamp.st02(10);},
					12,{IFSeqNtSamp.st02(11);
						~cntSeqNtSamp02=0;
					}
				)}
			);
			},
			'/ifSeq/6/2'
		);
		~ifSeqSampBut03.free;
		~ifSeqSampBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp03 = ~cntSeqNtSamp03 + 1;
				~cntSeqNtSamp03.switch(
					0,{},
					1, {IFSeqNtSamp.st03(0);},
					2, {IFSeqNtSamp.st03(1);},
					3, {IFSeqNtSamp.st03(2);},
					4, {IFSeqNtSamp.st03(3);},
					5, {IFSeqNtSamp.st03(4);},
					6, {IFSeqNtSamp.st03(5);},
					7, {IFSeqNtSamp.st03(6);},
					8, {IFSeqNtSamp.st03(7);},
					9, {IFSeqNtSamp.st03(8);},
					10, {IFSeqNtSamp.st03(9);},
					11,{IFSeqNtSamp.st03(10);},
					12,{IFSeqNtSamp.st03(11);
						~cntSeqNtSamp03=0;
					}
				)}
			);
			},
			'/ifSeq/6/3'
		);
		~ifSeqSampBut04.free;
		~ifSeqSampBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp04 = ~cntSeqNtSamp04 + 1;
				~cntSeqNtSamp04.switch(
					0,{},
					1, {IFSeqNtSamp.st04(0);},
					2, {IFSeqNtSamp.st04(1);},
					3, {IFSeqNtSamp.st04(2);},
					4, {IFSeqNtSamp.st04(3);},
					5, {IFSeqNtSamp.st04(4);},
					6, {IFSeqNtSamp.st04(5);},
					7, {IFSeqNtSamp.st04(6);},
					8, {IFSeqNtSamp.st04(7);},
					9, {IFSeqNtSamp.st04(8);},
					10, {IFSeqNtSamp.st04(9);},
					11,{IFSeqNtSamp.st04(10);},
					12,{IFSeqNtSamp.st04(11);
						~cntSeqNtSamp04=0;
					}
				)}
			);
			},
			'/ifSeq/6/4'
		);
		~ifSeqSampBut05.free;
		~ifSeqSampBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp05 = ~cntSeqNtSamp05 + 1;
				~cntSeqNtSamp05.switch(
					0,{},
					1, {IFSeqNtSamp.st05(0);},
					2, {IFSeqNtSamp.st05(1);},
					3, {IFSeqNtSamp.st05(2);},
					4, {IFSeqNtSamp.st05(3);},
					5, {IFSeqNtSamp.st05(4);},
					6, {IFSeqNtSamp.st05(5);},
					7, {IFSeqNtSamp.st05(6);},
					8, {IFSeqNtSamp.st05(7);},
					9, {IFSeqNtSamp.st05(8);},
					10, {IFSeqNtSamp.st05(9);},
					11,{IFSeqNtSamp.st05(10);},
					12,{IFSeqNtSamp.st05(11);
						~cntSeqNtSamp05=0;
					}
				)}
			);
			},
			'/ifSeq/6/5'
		);
		~ifSeqSampBut06.free;
		~ifSeqSampBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp06 = ~cntSeqNtSamp06 + 1;
				~cntSeqNtSamp06.switch(
					0,{},
					1, {IFSeqNtSamp.st06(0);},
					2, {IFSeqNtSamp.st06(1);},
					3, {IFSeqNtSamp.st06(2);},
					4, {IFSeqNtSamp.st06(3);},
					5, {IFSeqNtSamp.st06(4);},
					6, {IFSeqNtSamp.st06(5);},
					7, {IFSeqNtSamp.st06(6);},
					8, {IFSeqNtSamp.st06(7);},
					9, {IFSeqNtSamp.st06(8);},
					10, {IFSeqNtSamp.st06(9);},
					11,{IFSeqNtSamp.st06(10);},
					12,{IFSeqNtSamp.st06(11);
						~cntSeqNtSamp06=0;
					}
				)}
			);
			},
			'/ifSeq/6/6'
		);
		~ifSeqSampBut07.free;
		~ifSeqSampBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp07 = ~cntSeqNtSamp07 + 1;
				~cntSeqNtSamp07.switch(
					0,{},
					1, {IFSeqNtSamp.st07(0);},
					2, {IFSeqNtSamp.st07(1);},
					3, {IFSeqNtSamp.st07(2);},
					4, {IFSeqNtSamp.st07(3);},
					5, {IFSeqNtSamp.st07(4);},
					6, {IFSeqNtSamp.st07(5);},
					7, {IFSeqNtSamp.st07(6);},
					8, {IFSeqNtSamp.st07(7);},
					9, {IFSeqNtSamp.st07(8);},
					10, {IFSeqNtSamp.st07(9);},
					11,{IFSeqNtSamp.st07(10);},
					12,{IFSeqNtSamp.st07(11);
						~cntSeqNtSamp07=0;
					}
				)}
			);
			},
			'/ifSeq/6/7'
		);
		~ifSeqSampBut08.free;
		~ifSeqSampBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp08 = ~cntSeqNtSamp08 + 1;
				~cntSeqNtSamp08.switch(
					0,{},
					1, {IFSeqNtSamp.st08(0);},
					2, {IFSeqNtSamp.st08(1);},
					3, {IFSeqNtSamp.st08(2);},
					4, {IFSeqNtSamp.st08(3);},
					5, {IFSeqNtSamp.st08(4);},
					6, {IFSeqNtSamp.st08(5);},
					7, {IFSeqNtSamp.st08(6);},
					8, {IFSeqNtSamp.st08(7);},
					9, {IFSeqNtSamp.st08(8);},
					10, {IFSeqNtSamp.st08(9);},
					11,{IFSeqNtSamp.st08(10);},
					12,{IFSeqNtSamp.st08(11);
						~cntSeqNtSamp08=0;
					}
				)}
			);
			},
			'/ifSeq/6/8'
		);

		~ifSeqSampBut09.free;
		~ifSeqSampBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp09 = ~cntSeqNtSamp09 + 1;
				~cntSeqNtSamp09.switch(
					0,{},
					1, {IFSeqNtSamp.st09(0);},
					2, {IFSeqNtSamp.st09(1);},
					3, {IFSeqNtSamp.st09(2);},
					4, {IFSeqNtSamp.st09(3);},
					5, {IFSeqNtSamp.st09(4);},
					6, {IFSeqNtSamp.st09(5);},
					7, {IFSeqNtSamp.st09(6);},
					8, {IFSeqNtSamp.st09(7);},
					9, {IFSeqNtSamp.st09(8);},
					10, {IFSeqNtSamp.st09(9);},
					11,{IFSeqNtSamp.st09(10);},
					12,{IFSeqNtSamp.st09(11);
						~cntSeqNtSamp09=0;
					}
				)}
			);
			},
			'/ifSeq/6/9'
		);
		~ifSeqSampBut10.free;
		~ifSeqSampBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp10 = ~cntSeqNtSamp10 + 1;
				~cntSeqNtSamp10.switch(
					0,{},
					1, {IFSeqNtSamp.st10(0);},
					2, {IFSeqNtSamp.st10(1);},
					3, {IFSeqNtSamp.st10(2);},
					4, {IFSeqNtSamp.st10(3);},
					5, {IFSeqNtSamp.st10(4);},
					6, {IFSeqNtSamp.st10(5);},
					7, {IFSeqNtSamp.st10(6);},
					8, {IFSeqNtSamp.st10(7);},
					9, {IFSeqNtSamp.st10(8);},
					10, {IFSeqNtSamp.st10(9);},
					11,{IFSeqNtSamp.st10(10);},
					12,{IFSeqNtSamp.st10(11);
						~cntSeqNtSamp10=0;
					}
				)}
			);
			},
			'/ifSeq/6/10'
		);
		~ifSeqSampBut11.free;
		~ifSeqSampBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp11 = ~cntSeqNtSamp11 + 1;
				~cntSeqNtSamp11.switch(
					0,{},
					1, {IFSeqNtSamp.st11(0);},
					2, {IFSeqNtSamp.st11(1);},
					3, {IFSeqNtSamp.st11(2);},
					4, {IFSeqNtSamp.st11(3);},
					5, {IFSeqNtSamp.st11(4);},
					6, {IFSeqNtSamp.st11(5);},
					7, {IFSeqNtSamp.st11(6);},
					8, {IFSeqNtSamp.st11(7);},
					9, {IFSeqNtSamp.st11(8);},
					10, {IFSeqNtSamp.st11(9);},
					11,{IFSeqNtSamp.st11(10);},
					12,{IFSeqNtSamp.st11(11);
						~cntSeqNtSamp11=0;
					}
				)}
			);
			},
			'/ifSeq/6/11'
		);
		~ifSeqSampBut12.free;
		~ifSeqSampBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp12 = ~cntSeqNtSamp12 + 1;
				~cntSeqNtSamp12.switch(
					0,{},
					1, {IFSeqNtSamp.st12(0);},
					2, {IFSeqNtSamp.st12(1);},
					3, {IFSeqNtSamp.st12(2);},
					4, {IFSeqNtSamp.st12(3);},
					5, {IFSeqNtSamp.st12(4);},
					6, {IFSeqNtSamp.st12(5);},
					7, {IFSeqNtSamp.st12(6);},
					8, {IFSeqNtSamp.st12(7);},
					9, {IFSeqNtSamp.st12(8);},
					10, {IFSeqNtSamp.st12(9);},
					11,{IFSeqNtSamp.st12(10);},
					12,{IFSeqNtSamp.st12(11);
						~cntSeqNtSamp12=0;
					}
				)}
			);
			},
			'/ifSeq/6/12'
		);
		~ifSeqSampBut13.free;
		~ifSeqSampBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp13 = ~cntSeqNtSamp13 + 1;
				~cntSeqNtSamp13.switch(
					0,{},
					1, {IFSeqNtSamp.st13(0);},
					2, {IFSeqNtSamp.st13(1);},
					3, {IFSeqNtSamp.st13(2);},
					4, {IFSeqNtSamp.st13(3);},
					5, {IFSeqNtSamp.st13(4);},
					6, {IFSeqNtSamp.st13(5);},
					7, {IFSeqNtSamp.st13(6);},
					8, {IFSeqNtSamp.st13(7);},
					9, {IFSeqNtSamp.st13(8);},
					10, {IFSeqNtSamp.st13(9);},
					11,{IFSeqNtSamp.st13(10);},
					12,{IFSeqNtSamp.st13(11);
						~cntSeqNtSamp13=0;
					}
				)}
			);
			},
			'/ifSeq/6/13'
		);
		~ifSeqSampBut14.free;
		~ifSeqSampBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp14 = ~cntSeqNtSamp14 + 1;
				~cntSeqNtSamp14.switch(
					0,{},
					1, {IFSeqNtSamp.st14(0);},
					2, {IFSeqNtSamp.st14(1);},
					3, {IFSeqNtSamp.st14(2);},
					4, {IFSeqNtSamp.st14(3);},
					5, {IFSeqNtSamp.st14(4);},
					6, {IFSeqNtSamp.st14(5);},
					7, {IFSeqNtSamp.st14(6);},
					8, {IFSeqNtSamp.st14(7);},
					9, {IFSeqNtSamp.st14(8);},
					10, {IFSeqNtSamp.st14(9);},
					11,{IFSeqNtSamp.st14(10);},
					12,{IFSeqNtSamp.st14(11);
						~cntSeqNtSamp14=0;
					}
				)}
			);
			},
			'/ifSeq/6/14'
		);
		~ifSeqSampBut15.free;
		~ifSeqSampBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp15 = ~cntSeqNtSamp15 + 1;
				~cntSeqNtSamp15.switch(
					0,{},
					1, {IFSeqNtSamp.st15(0);},
					2, {IFSeqNtSamp.st15(1);},
					3, {IFSeqNtSamp.st15(2);},
					4, {IFSeqNtSamp.st15(3);},
					5, {IFSeqNtSamp.st15(4);},
					6, {IFSeqNtSamp.st15(5);},
					7, {IFSeqNtSamp.st15(6);},
					8, {IFSeqNtSamp.st15(7);},
					9, {IFSeqNtSamp.st15(8);},
					10, {IFSeqNtSamp.st15(9);},
					11,{IFSeqNtSamp.st15(10);},
					12,{IFSeqNtSamp.st15(11);
						~cntSeqNtSamp15=0;
					}
				)}
			);
			},
			'/ifSeq/6/15'
		);
		~ifSeqSampBut16.free;
		~ifSeqSampBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqNtSamp16 = ~cntSeqNtSamp16 + 1;
				~cntSeqNtSamp16.switch(
					0,{},
					1, {IFSeqNtSamp.st16(0);},
					2, {IFSeqNtSamp.st16(1);},
					3, {IFSeqNtSamp.st16(2);},
					4, {IFSeqNtSamp.st16(3);},
					5, {IFSeqNtSamp.st16(4);},
					6, {IFSeqNtSamp.st16(5);},
					7, {IFSeqNtSamp.st16(6);},
					8, {IFSeqNtSamp.st16(7);},
					9, {IFSeqNtSamp.st16(8);},
					10, {IFSeqNtSamp.st16(9);},
					11,{IFSeqNtSamp.st16(10);},
					12,{IFSeqNtSamp.st16(11);
						~cntSeqNtSamp16=0;
					}
				)}
			);
			},
			'/ifSeq/6/16'
		);

	}//

	*st01 {|i=0|
		~seqNtSamp01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp01', i);
	}
	*st02 {|i=0|
		~seqNtSamp02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp02', i);
	}
	*st03 {|i=0|
		~seqNtSamp03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp03', i);
	}
	*st04 {|i=0|
		~seqNtSamp04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp04', i);
	}
	*st05 {|i=0|
		~seqNtSamp05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp05', i);
	}
	*st06 {|i=0|
		~seqNtSamp06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp06', i);
	}
	*st07 {|i=0|
		~seqNtSamp07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp07', i);
	}
	*st08 {|i=0|
		~seqNtSamp08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp08', i);
	}

	*st09 {|i=0|
		~seqNtSamp09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp09', i);
	}
	*st10 {|i=0|
		~seqNtSamp10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp10', i);
	}
	*st11 {|i=0|
		~seqNtSamp11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp11', i);
	}
	*st12 {|i=0|
		~seqNtSamp12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp12', i);
	}
	*st13 {|i=0|
		~seqNtSamp13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp13', i);
	}
	*st14 {|i=0|
		~seqNtSamp14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp14', i);
	}
	*st15 {|i=0|
		~seqNtSamp15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp15', i);
	}
	*st16 {|i=0|
		~seqNtSamp16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shNtSamp16', i);
	}
	*stGrp {|i|

		IFSeqNtSamp.st01(i); IFSeqNtSamp.st02(i); IFSeqNtSamp.st03(i); IFSeqNtSamp.st04(i);
		IFSeqNtSamp.st05(i); IFSeqNtSamp.st06(i); IFSeqNtSamp.st07(i); IFSeqNtSamp.st08(i);
		IFSeqNtSamp.st09(i); IFSeqNtSamp.st10(i); IFSeqNtSamp.st11(i); IFSeqNtSamp.st12(i);
		IFSeqNtSamp.st13(i); IFSeqNtSamp.st14(i); IFSeqNtSamp.st15(i); IFSeqNtSamp.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqNtSamp.st01(s01); IFSeqNtSamp.st02(s02); IFSeqNtSamp.st03(s03); IFSeqNtSamp.st04(s04);
		IFSeqNtSamp.st05(s05); IFSeqNtSamp.st06(s06); IFSeqNtSamp.st07(s07); IFSeqNtSamp.st08(s08);
		IFSeqNtSamp.st09(s09); IFSeqNtSamp.st10(s10); IFSeqNtSamp.st11(s11); IFSeqNtSamp.st12(s12);
		IFSeqNtSamp.st13(s13); IFSeqNtSamp.st14(s14); IFSeqNtSamp.st15(s15); IFSeqNtSamp.st16(s16);
	}
}