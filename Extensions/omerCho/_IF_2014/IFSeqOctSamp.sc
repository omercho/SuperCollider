IFSeqOctSamp {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqOctSamp01 = PatternProxy( Pseq([1], 1));
		~seqOctSamp02 = PatternProxy( Pseq([1], 1));
		~seqOctSamp03 = PatternProxy( Pseq([1], 1));
		~seqOctSamp04 = PatternProxy( Pseq([1], 1));
		~seqOctSamp05 = PatternProxy( Pseq([1], 1));
		~seqOctSamp06 = PatternProxy( Pseq([1], 1));
		~seqOctSamp07 = PatternProxy( Pseq([1], 1));
		~seqOctSamp08 = PatternProxy( Pseq([1], 1));

		~seqOctSamp09 = PatternProxy( Pseq([1], 1));
		~seqOctSamp10 = PatternProxy( Pseq([1], 1));
		~seqOctSamp11 = PatternProxy( Pseq([1], 1));
		~seqOctSamp12 = PatternProxy( Pseq([1], 1));
		~seqOctSamp13 = PatternProxy( Pseq([1], 1));
		~seqOctSamp14 = PatternProxy( Pseq([1], 1));
		~seqOctSamp15 = PatternProxy( Pseq([1], 1));
		~seqOctSamp16 = PatternProxy( Pseq([1], 1));

	}

	*countReset {
		~cntSeqOctUpSamp01=0;
		~cntSeqOctRandSamp01=0;

		~cntSeqOctSamp01=0;
		~cntSeqOctSamp02=0;
		~cntSeqOctSamp03=0;
		~cntSeqOctSamp04=0;
		~cntSeqOctSamp05=0;
		~cntSeqOctSamp06=0;
		~cntSeqOctSamp07=0;
		~cntSeqOctSamp08=0;

		~cntSeqOctSamp09=0;
		~cntSeqOctSamp10=0;
		~cntSeqOctSamp11=0;
		~cntSeqOctSamp12=0;
		~cntSeqOctSamp13=0;
		~cntSeqOctSamp14=0;
		~cntSeqOctSamp15=0;
		~cntSeqOctSamp16=0;
	}
	*freeOn {
		~seqFreeSampBut.free;
		~seqFreeSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqOctSamp.stGrp(0);
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
				~cntSeqOctUpSamp01 = ~cntSeqOctUpSamp01 + 1;
				~cntSeqOctUpSamp01.switch(
					0,{},
					1,{IFSeqOctSamp.stGrp(0);},
					2,{IFSeqOctSamp.stGrp(1);},
					3,{IFSeqOctSamp.stGrp(2);},
					4,{IFSeqOctSamp.stGrp(3);},
					5,{IFSeqOctSamp.stGrp(4);},
					6,{IFSeqOctSamp.stGrp(5);},
					7,{IFSeqOctSamp.stGrp(6);},
					8,{IFSeqOctSamp.stGrp(7);},
					9,{IFSeqOctSamp.stGrp(8);},
					10,{IFSeqOctSamp.stGrp(9);},
					11,{IFSeqOctSamp.stGrp(10);
						~cntSeqOctUpSamp01=0;
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
				~cntSeqOctRandSamp01 = ~cntSeqOctRandSamp01 + 1;
				~cntSeqOctRandSamp01.switch(
					0,{},
					1,{
						IFSeqOctSamp.st01((0..10).choose);
						IFSeqOctSamp.st02((0..10).choose);
						IFSeqOctSamp.st03((0..10).choose);
						IFSeqOctSamp.st04((0..10).choose);
						IFSeqOctSamp.st05((0..10).choose);
						IFSeqOctSamp.st06((0..10).choose);
						IFSeqOctSamp.st07((0..10).choose);
						IFSeqOctSamp.st08((0..10).choose);

						IFSeqOctSamp.st09((0..10).choose);
						IFSeqOctSamp.st10((0..10).choose);
						IFSeqOctSamp.st11((0..10).choose);
						IFSeqOctSamp.st12((0..10).choose);
						IFSeqOctSamp.st13((0..10).choose);
						IFSeqOctSamp.st14((0..10).choose);
						IFSeqOctSamp.st15((0..10).choose);
						IFSeqOctSamp.st16((0..10).choose);
						~cntSeqOctRandSamp01=0;
					}
				)}
			);
			},
			'/seqRandSamp'
		);
	}

	*on { // Shift OCTAVE
		IFSeqOctSamp.randOn;
		IFSeqOctSamp.upOn;
		IFSeqOctSamp.freeOn;

		~ifSeqSampBut01.free;
		~ifSeqSampBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctSamp01 = ~cntSeqOctSamp01 + 1;
				~cntSeqOctSamp01.switch(
					0,{},
					1, {IFSeqOctSamp.st01(0);},
					2, {IFSeqOctSamp.st01(1);},
					3, {IFSeqOctSamp.st01(2);},
					4, {IFSeqOctSamp.st01(3);},
					5, {IFSeqOctSamp.st01(4);},
					6, {IFSeqOctSamp.st01(5);},
					7, {IFSeqOctSamp.st01(6);},
					8, {IFSeqOctSamp.st01(7);},
					9, {IFSeqOctSamp.st01(8);},
					10,{IFSeqOctSamp.st01(9);},
					11,{IFSeqOctSamp.st01(10);
						~cntSeqOctSamp01=0;
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
				~cntSeqOctSamp02 = ~cntSeqOctSamp02 + 1;
				~cntSeqOctSamp02.switch(
					0,{},
					1, {IFSeqOctSamp.st02(0);},
					2, {IFSeqOctSamp.st02(1);},
					3, {IFSeqOctSamp.st02(2);},
					4, {IFSeqOctSamp.st02(3);},
					5, {IFSeqOctSamp.st02(4);},
					6, {IFSeqOctSamp.st02(5);},
					7, {IFSeqOctSamp.st02(6);},
					8, {IFSeqOctSamp.st02(7);},
					9, {IFSeqOctSamp.st02(8);},
					10, {IFSeqOctSamp.st02(9);},
					11,{
						IFSeqOctSamp.st02(10);
						~cntSeqOctSamp02=0;
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
				~cntSeqOctSamp03 = ~cntSeqOctSamp03 + 1;
				~cntSeqOctSamp03.switch(
					0,{},
					1, {IFSeqOctSamp.st03(0);},
					2, {IFSeqOctSamp.st03(1);},
					3, {IFSeqOctSamp.st03(2);},
					4, {IFSeqOctSamp.st03(3);},
					5, {IFSeqOctSamp.st03(4);},
					6, {IFSeqOctSamp.st03(5);},
					7, {IFSeqOctSamp.st03(6);},
					8, {IFSeqOctSamp.st03(7);},
					9, {IFSeqOctSamp.st03(8);},
					10, {IFSeqOctSamp.st03(9);},
					11,{
						IFSeqOctSamp.st03(10);
						~cntSeqOctSamp03=0;
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
				~cntSeqOctSamp04 = ~cntSeqOctSamp04 + 1;
				~cntSeqOctSamp04.switch(
					0,{},
					1, {IFSeqOctSamp.st04(0);},
					2, {IFSeqOctSamp.st04(1);},
					3, {IFSeqOctSamp.st04(2);},
					4, {IFSeqOctSamp.st04(3);},
					5, {IFSeqOctSamp.st04(4);},
					6, {IFSeqOctSamp.st04(5);},
					7, {IFSeqOctSamp.st04(6);},
					8, {IFSeqOctSamp.st04(7);},
					9, {IFSeqOctSamp.st04(8);},
					10, {IFSeqOctSamp.st04(9);},
					11,{
						IFSeqOctSamp.st04(10);
						~cntSeqOctSamp04=0;
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
				~cntSeqOctSamp05 = ~cntSeqOctSamp05 + 1;
				~cntSeqOctSamp05.switch(
					0,{},
					1, {IFSeqOctSamp.st05(0);},
					2, {IFSeqOctSamp.st05(1);},
					3, {IFSeqOctSamp.st05(2);},
					4, {IFSeqOctSamp.st05(3);},
					5, {IFSeqOctSamp.st05(4);},
					6, {IFSeqOctSamp.st05(5);},
					7, {IFSeqOctSamp.st05(6);},
					8, {IFSeqOctSamp.st05(7);},
					9, {IFSeqOctSamp.st05(8);},
					10, {IFSeqOctSamp.st05(9);},
					11,{
						IFSeqOctSamp.st05(10);
						~cntSeqOctSamp05=0;
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
				~cntSeqOctSamp06 = ~cntSeqOctSamp06 + 1;
				~cntSeqOctSamp06.switch(
					0,{},
					1, {IFSeqOctSamp.st06(0);},
					2, {IFSeqOctSamp.st06(1);},
					3, {IFSeqOctSamp.st06(2);},
					4, {IFSeqOctSamp.st06(3);},
					5, {IFSeqOctSamp.st06(4);},
					6, {IFSeqOctSamp.st06(5);},
					7, {IFSeqOctSamp.st06(6);},
					8, {IFSeqOctSamp.st06(7);},
					9, {IFSeqOctSamp.st06(8);},
					10, {IFSeqOctSamp.st06(9);},
					11,{
						IFSeqOctSamp.st06(10);
						~cntSeqOctSamp06=0;
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
				~cntSeqOctSamp07 = ~cntSeqOctSamp07 + 1;
				~cntSeqOctSamp07.switch(
					0,{},
					1, {IFSeqOctSamp.st07(0);},
					2, {IFSeqOctSamp.st07(1);},
					3, {IFSeqOctSamp.st07(2);},
					4, {IFSeqOctSamp.st07(3);},
					5, {IFSeqOctSamp.st07(4);},
					6, {IFSeqOctSamp.st07(5);},
					7, {IFSeqOctSamp.st07(6);},
					8, {IFSeqOctSamp.st07(7);},
					9, {IFSeqOctSamp.st07(8);},
					10, {IFSeqOctSamp.st07(9);},
					11,{
						IFSeqOctSamp.st07(10);
						~cntSeqOctSamp07=0;
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
				~cntSeqOctSamp08 = ~cntSeqOctSamp08 + 1;
				~cntSeqOctSamp08.switch(
					0,{},
					1, {IFSeqOctSamp.st08(0);},
					2, {IFSeqOctSamp.st08(1);},
					3, {IFSeqOctSamp.st08(2);},
					4, {IFSeqOctSamp.st08(3);},
					5, {IFSeqOctSamp.st08(4);},
					6, {IFSeqOctSamp.st08(5);},
					7, {IFSeqOctSamp.st08(6);},
					8, {IFSeqOctSamp.st08(7);},
					9, {IFSeqOctSamp.st08(8);},
					10, {IFSeqOctSamp.st08(9);},
					11,{
						IFSeqOctSamp.st08(10);
						~cntSeqOctSamp08=0;
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
				~cntSeqOctSamp09 = ~cntSeqOctSamp09 + 1;
				~cntSeqOctSamp09.switch(
					0,{},
					1, {IFSeqOctSamp.st09(0);},
					2, {IFSeqOctSamp.st09(1);},
					3, {IFSeqOctSamp.st09(2);},
					4, {IFSeqOctSamp.st09(3);},
					5, {IFSeqOctSamp.st09(4);},
					6, {IFSeqOctSamp.st09(5);},
					7, {IFSeqOctSamp.st09(6);},
					8, {IFSeqOctSamp.st09(7);},
					9, {IFSeqOctSamp.st09(8);},
					10, {IFSeqOctSamp.st09(9);},
					11,{
						IFSeqOctSamp.st09(10);
						~cntSeqOctSamp09=0;
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
				~cntSeqOctSamp10 = ~cntSeqOctSamp10 + 1;
				~cntSeqOctSamp10.switch(
					0,{},
					1, {IFSeqOctSamp.st10(0);},
					2, {IFSeqOctSamp.st10(1);},
					3, {IFSeqOctSamp.st10(2);},
					4, {IFSeqOctSamp.st10(3);},
					5, {IFSeqOctSamp.st10(4);},
					6, {IFSeqOctSamp.st10(5);},
					7, {IFSeqOctSamp.st10(6);},
					8, {IFSeqOctSamp.st10(7);},
					9, {IFSeqOctSamp.st10(8);},
					10, {IFSeqOctSamp.st10(9);},
					11,{
						IFSeqOctSamp.st10(10);
						~cntSeqOctSamp10=0;
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
				~cntSeqOctSamp11 = ~cntSeqOctSamp11 + 1;
				~cntSeqOctSamp11.switch(
					0,{},
					1, {IFSeqOctSamp.st11(0);},
					2, {IFSeqOctSamp.st11(1);},
					3, {IFSeqOctSamp.st11(2);},
					4, {IFSeqOctSamp.st11(3);},
					5, {IFSeqOctSamp.st11(4);},
					6, {IFSeqOctSamp.st11(5);},
					7, {IFSeqOctSamp.st11(6);},
					8, {IFSeqOctSamp.st11(7);},
					9, {IFSeqOctSamp.st11(8);},
					10, {IFSeqOctSamp.st11(9);},
					11,{
						IFSeqOctSamp.st11(10);
						~cntSeqOctSamp11=0;
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
				~cntSeqOctSamp12 = ~cntSeqOctSamp12 + 1;
				~cntSeqOctSamp12.switch(
					0,{},
					1, {IFSeqOctSamp.st12(0);},
					2, {IFSeqOctSamp.st12(1);},
					3, {IFSeqOctSamp.st12(2);},
					4, {IFSeqOctSamp.st12(3);},
					5, {IFSeqOctSamp.st12(4);},
					6, {IFSeqOctSamp.st12(5);},
					7, {IFSeqOctSamp.st12(6);},
					8, {IFSeqOctSamp.st12(7);},
					9, {IFSeqOctSamp.st12(8);},
					10, {IFSeqOctSamp.st12(9);},
					11,{
						IFSeqOctSamp.st12(10);
						~cntSeqOctSamp12=0;
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
				~cntSeqOctSamp13 = ~cntSeqOctSamp13 + 1;
				~cntSeqOctSamp13.switch(
					0,{},
					1, {IFSeqOctSamp.st13(0);},
					2, {IFSeqOctSamp.st13(1);},
					3, {IFSeqOctSamp.st13(2);},
					4, {IFSeqOctSamp.st13(3);},
					5, {IFSeqOctSamp.st13(4);},
					6, {IFSeqOctSamp.st13(5);},
					7, {IFSeqOctSamp.st13(6);},
					8, {IFSeqOctSamp.st13(7);},
					9, {IFSeqOctSamp.st13(8);},
					10, {IFSeqOctSamp.st13(9);},
					11,{
						IFSeqOctSamp.st13(10);
						~cntSeqOctSamp13=0;
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
				~cntSeqOctSamp14 = ~cntSeqOctSamp14 + 1;
				~cntSeqOctSamp14.switch(
					0,{},
					1, {IFSeqOctSamp.st14(0);},
					2, {IFSeqOctSamp.st14(1);},
					3, {IFSeqOctSamp.st14(2);},
					4, {IFSeqOctSamp.st14(3);},
					5, {IFSeqOctSamp.st14(4);},
					6, {IFSeqOctSamp.st14(5);},
					7, {IFSeqOctSamp.st14(6);},
					8, {IFSeqOctSamp.st14(7);},
					9, {IFSeqOctSamp.st14(8);},
					10, {IFSeqOctSamp.st14(9);},
					11,{
						IFSeqOctSamp.st14(10);
						~cntSeqOctSamp14=0;
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
				~cntSeqOctSamp15 = ~cntSeqOctSamp15 + 1;
				~cntSeqOctSamp15.switch(
					0,{},
					1, {IFSeqOctSamp.st15(0);},
					2, {IFSeqOctSamp.st15(1);},
					3, {IFSeqOctSamp.st15(2);},
					4, {IFSeqOctSamp.st15(3);},
					5, {IFSeqOctSamp.st15(4);},
					6, {IFSeqOctSamp.st15(5);},
					7, {IFSeqOctSamp.st15(6);},
					8, {IFSeqOctSamp.st15(7);},
					9, {IFSeqOctSamp.st15(8);},
					10, {IFSeqOctSamp.st15(9);},
					11,{
						IFSeqOctSamp.st15(10);
						~cntSeqOctSamp15=0;
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
				~cntSeqOctSamp16 = ~cntSeqOctSamp16 + 1;
				~cntSeqOctSamp16.switch(
					0,{},
					1, {IFSeqOctSamp.st16(0);},
					2, {IFSeqOctSamp.st16(1);},
					3, {IFSeqOctSamp.st16(2);},
					4, {IFSeqOctSamp.st16(3);},
					5, {IFSeqOctSamp.st16(4);},
					6, {IFSeqOctSamp.st16(5);},
					7, {IFSeqOctSamp.st16(6);},
					8, {IFSeqOctSamp.st16(7);},
					9, {IFSeqOctSamp.st16(8);},
					10, {IFSeqOctSamp.st16(9);},
					11,{
						IFSeqOctSamp.st16(10);
						~cntSeqOctSamp16=0;
					}
				)}
			);
			},
			'/ifSeq/6/16'
		);

	}//

	*st01 {|i=0|
		~seqOctSamp01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp01', i);
	}
	*st02 {|i=0|
		~seqOctSamp02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp02', i);
	}
	*st03 {|i=0|
		~seqOctSamp03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp03', i);
	}
	*st04 {|i=0|
		~seqOctSamp04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp04', i);
	}
	*st05 {|i=0|
		~seqOctSamp05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp05', i);
	}
	*st06 {|i=0|
		~seqOctSamp06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp06', i);
	}
	*st07 {|i=0|
		~seqOctSamp07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp07', i);
	}
	*st08 {|i=0|
		~seqOctSamp08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp08', i);
	}
	*st09 {|i=0|
		~seqOctSamp09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp09', i);
	}
	*st10 {|i=0|
		~seqOctSamp10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp10', i);
	}
	*st11 {|i=0|
		~seqOctSamp11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp11', i);
	}
	*st12 {|i=0|
		~seqOctSamp12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp12', i);
	}
	*st13 {|i=0|
		~seqOctSamp13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp13', i);
	}
	*st14 {|i=0|
		~seqOctSamp14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp14', i);
	}
	*st15 {|i=0|
		~seqOctSamp15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp15', i);
	}
	*st16 {|i=0|
		~seqOctSamp16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctSamp16', i);
	}
	*stGrp {|i|

		IFSeqOctSamp.st01(i); IFSeqOctSamp.st02(i); IFSeqOctSamp.st03(i); IFSeqOctSamp.st04(i);
		IFSeqOctSamp.st05(i); IFSeqOctSamp.st06(i); IFSeqOctSamp.st07(i); IFSeqOctSamp.st08(i);
		IFSeqOctSamp.st09(i); IFSeqOctSamp.st10(i); IFSeqOctSamp.st11(i); IFSeqOctSamp.st12(i);
		IFSeqOctSamp.st13(i); IFSeqOctSamp.st14(i); IFSeqOctSamp.st15(i); IFSeqOctSamp.st16(i);
	}
}