IFSeqOctKick {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqOctKick01 = PatternProxy( Pseq([1], 1));
		~seqOctKick02 = PatternProxy( Pseq([1], 1));
		~seqOctKick03 = PatternProxy( Pseq([1], 1));
		~seqOctKick04 = PatternProxy( Pseq([1], 1));
		~seqOctKick05 = PatternProxy( Pseq([1], 1));
		~seqOctKick06 = PatternProxy( Pseq([1], 1));
		~seqOctKick07 = PatternProxy( Pseq([1], 1));
		~seqOctKick08 = PatternProxy( Pseq([1], 1));

		~seqOctKick09 = PatternProxy( Pseq([1], 1));
		~seqOctKick10 = PatternProxy( Pseq([1], 1));
		~seqOctKick11 = PatternProxy( Pseq([1], 1));
		~seqOctKick12 = PatternProxy( Pseq([1], 1));
		~seqOctKick13 = PatternProxy( Pseq([1], 1));
		~seqOctKick14 = PatternProxy( Pseq([1], 1));
		~seqOctKick15 = PatternProxy( Pseq([1], 1));
		~seqOctKick16 = PatternProxy( Pseq([1], 1));

	}

	*countReset {
		~cntSeqOctUpKick01=0;
		~cntSeqOctRandKick01=0;

		~cntSeqOctKick01=0;
		~cntSeqOctKick02=0;
		~cntSeqOctKick03=0;
		~cntSeqOctKick04=0;
		~cntSeqOctKick05=0;
		~cntSeqOctKick06=0;
		~cntSeqOctKick07=0;
		~cntSeqOctKick08=0;

		~cntSeqOctKick09=0;
		~cntSeqOctKick10=0;
		~cntSeqOctKick11=0;
		~cntSeqOctKick12=0;
		~cntSeqOctKick13=0;
		~cntSeqOctKick14=0;
		~cntSeqOctKick15=0;
		~cntSeqOctKick16=0;
	}
	*freeOn {
		~seqFreeKickBut.free;
		~seqFreeKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqOctKick.stGrp(0);
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
				~cntSeqOctUpKick01 = ~cntSeqOctUpKick01 + 1;
				~cntSeqOctUpKick01.switch(
					0,{},
					1,{IFSeqOctKick.stGrp(0);},
					2,{IFSeqOctKick.stGrp(1);},
					3,{IFSeqOctKick.stGrp(2);},
					4,{IFSeqOctKick.stGrp(3);},
					5,{IFSeqOctKick.stGrp(4);},
					6,{IFSeqOctKick.stGrp(5);},
					7,{IFSeqOctKick.stGrp(6);},
					8,{IFSeqOctKick.stGrp(7);},
					9,{IFSeqOctKick.stGrp(8);},
					10,{IFSeqOctKick.stGrp(9);},
					11,{IFSeqOctKick.stGrp(10);
						~cntSeqOctUpKick01=0;
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
				~cntSeqOctRandKick01 = ~cntSeqOctRandKick01 + 1;
				~cntSeqOctRandKick01.switch(
					0,{},
					1,{
						IFSeqOctKick.st01((0..10).choose);
						IFSeqOctKick.st02((0..10).choose);
						IFSeqOctKick.st03((0..10).choose);
						IFSeqOctKick.st04((0..10).choose);
						IFSeqOctKick.st05((0..10).choose);
						IFSeqOctKick.st06((0..10).choose);
						IFSeqOctKick.st07((0..10).choose);
						IFSeqOctKick.st08((0..10).choose);

						IFSeqOctKick.st09((0..10).choose);
						IFSeqOctKick.st10((0..10).choose);
						IFSeqOctKick.st11((0..10).choose);
						IFSeqOctKick.st12((0..10).choose);
						IFSeqOctKick.st13((0..10).choose);
						IFSeqOctKick.st14((0..10).choose);
						IFSeqOctKick.st15((0..10).choose);
						IFSeqOctKick.st16((0..10).choose);
						~cntSeqOctRandKick01=0;
					}
				)}
			);
			},
			'/seqRandKick'
		);
	}

	*on { // Shift OCTAVE
		IFSeqOctKick.randOn;
		IFSeqOctKick.upOn;
		IFSeqOctKick.freeOn;

		~ifSeqKickBut01.free;
		~ifSeqKickBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKick01 = ~cntSeqOctKick01 + 1;
				~cntSeqOctKick01.switch(
					0,{},
					1, {IFSeqOctKick.st01(0);},
					2, {IFSeqOctKick.st01(1);},
					3, {IFSeqOctKick.st01(2);},
					4, {IFSeqOctKick.st01(3);},
					5, {IFSeqOctKick.st01(4);},
					6, {IFSeqOctKick.st01(5);},
					7, {IFSeqOctKick.st01(6);},
					8, {IFSeqOctKick.st01(7);},
					9, {IFSeqOctKick.st01(8);},
					10,{IFSeqOctKick.st01(9);},
					11,{IFSeqOctKick.st01(10);
						~cntSeqOctKick01=0;
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
				~cntSeqOctKick02 = ~cntSeqOctKick02 + 1;
				~cntSeqOctKick02.switch(
					0,{},
					1, {IFSeqOctKick.st02(0);},
					2, {IFSeqOctKick.st02(1);},
					3, {IFSeqOctKick.st02(2);},
					4, {IFSeqOctKick.st02(3);},
					5, {IFSeqOctKick.st02(4);},
					6, {IFSeqOctKick.st02(5);},
					7, {IFSeqOctKick.st02(6);},
					8, {IFSeqOctKick.st02(7);},
					9, {IFSeqOctKick.st02(8);},
					10, {IFSeqOctKick.st02(9);},
					11,{
						IFSeqOctKick.st02(10);
						~cntSeqOctKick02=0;
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
				~cntSeqOctKick03 = ~cntSeqOctKick03 + 1;
				~cntSeqOctKick03.switch(
					0,{},
					1, {IFSeqOctKick.st03(0);},
					2, {IFSeqOctKick.st03(1);},
					3, {IFSeqOctKick.st03(2);},
					4, {IFSeqOctKick.st03(3);},
					5, {IFSeqOctKick.st03(4);},
					6, {IFSeqOctKick.st03(5);},
					7, {IFSeqOctKick.st03(6);},
					8, {IFSeqOctKick.st03(7);},
					9, {IFSeqOctKick.st03(8);},
					10, {IFSeqOctKick.st03(9);},
					11,{
						IFSeqOctKick.st03(10);
						~cntSeqOctKick03=0;
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
				~cntSeqOctKick04 = ~cntSeqOctKick04 + 1;
				~cntSeqOctKick04.switch(
					0,{},
					1, {IFSeqOctKick.st04(0);},
					2, {IFSeqOctKick.st04(1);},
					3, {IFSeqOctKick.st04(2);},
					4, {IFSeqOctKick.st04(3);},
					5, {IFSeqOctKick.st04(4);},
					6, {IFSeqOctKick.st04(5);},
					7, {IFSeqOctKick.st04(6);},
					8, {IFSeqOctKick.st04(7);},
					9, {IFSeqOctKick.st04(8);},
					10, {IFSeqOctKick.st04(9);},
					11,{
						IFSeqOctKick.st04(10);
						~cntSeqOctKick04=0;
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
				~cntSeqOctKick05 = ~cntSeqOctKick05 + 1;
				~cntSeqOctKick05.switch(
					0,{},
					1, {IFSeqOctKick.st05(0);},
					2, {IFSeqOctKick.st05(1);},
					3, {IFSeqOctKick.st05(2);},
					4, {IFSeqOctKick.st05(3);},
					5, {IFSeqOctKick.st05(4);},
					6, {IFSeqOctKick.st05(5);},
					7, {IFSeqOctKick.st05(6);},
					8, {IFSeqOctKick.st05(7);},
					9, {IFSeqOctKick.st05(8);},
					10, {IFSeqOctKick.st05(9);},
					11,{
						IFSeqOctKick.st05(10);
						~cntSeqOctKick05=0;
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
				~cntSeqOctKick06 = ~cntSeqOctKick06 + 1;
				~cntSeqOctKick06.switch(
					0,{},
					1, {IFSeqOctKick.st06(0);},
					2, {IFSeqOctKick.st06(1);},
					3, {IFSeqOctKick.st06(2);},
					4, {IFSeqOctKick.st06(3);},
					5, {IFSeqOctKick.st06(4);},
					6, {IFSeqOctKick.st06(5);},
					7, {IFSeqOctKick.st06(6);},
					8, {IFSeqOctKick.st06(7);},
					9, {IFSeqOctKick.st06(8);},
					10, {IFSeqOctKick.st06(9);},
					11,{
						IFSeqOctKick.st06(10);
						~cntSeqOctKick06=0;
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
				~cntSeqOctKick07 = ~cntSeqOctKick07 + 1;
				~cntSeqOctKick07.switch(
					0,{},
					1, {IFSeqOctKick.st07(0);},
					2, {IFSeqOctKick.st07(1);},
					3, {IFSeqOctKick.st07(2);},
					4, {IFSeqOctKick.st07(3);},
					5, {IFSeqOctKick.st07(4);},
					6, {IFSeqOctKick.st07(5);},
					7, {IFSeqOctKick.st07(6);},
					8, {IFSeqOctKick.st07(7);},
					9, {IFSeqOctKick.st07(8);},
					10, {IFSeqOctKick.st07(9);},
					11,{
						IFSeqOctKick.st07(10);
						~cntSeqOctKick07=0;
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
				~cntSeqOctKick08 = ~cntSeqOctKick08 + 1;
				~cntSeqOctKick08.switch(
					0,{},
					1, {IFSeqOctKick.st08(0);},
					2, {IFSeqOctKick.st08(1);},
					3, {IFSeqOctKick.st08(2);},
					4, {IFSeqOctKick.st08(3);},
					5, {IFSeqOctKick.st08(4);},
					6, {IFSeqOctKick.st08(5);},
					7, {IFSeqOctKick.st08(6);},
					8, {IFSeqOctKick.st08(7);},
					9, {IFSeqOctKick.st08(8);},
					10, {IFSeqOctKick.st08(9);},
					11,{
						IFSeqOctKick.st08(10);
						~cntSeqOctKick08=0;
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
				~cntSeqOctKick09 = ~cntSeqOctKick09 + 1;
				~cntSeqOctKick09.switch(
					0,{},
					1, {IFSeqOctKick.st09(0);},
					2, {IFSeqOctKick.st09(1);},
					3, {IFSeqOctKick.st09(2);},
					4, {IFSeqOctKick.st09(3);},
					5, {IFSeqOctKick.st09(4);},
					6, {IFSeqOctKick.st09(5);},
					7, {IFSeqOctKick.st09(6);},
					8, {IFSeqOctKick.st09(7);},
					9, {IFSeqOctKick.st09(8);},
					10, {IFSeqOctKick.st09(9);},
					11,{
						IFSeqOctKick.st09(10);
						~cntSeqOctKick09=0;
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
				~cntSeqOctKick10 = ~cntSeqOctKick10 + 1;
				~cntSeqOctKick10.switch(
					0,{},
					1, {IFSeqOctKick.st10(0);},
					2, {IFSeqOctKick.st10(1);},
					3, {IFSeqOctKick.st10(2);},
					4, {IFSeqOctKick.st10(3);},
					5, {IFSeqOctKick.st10(4);},
					6, {IFSeqOctKick.st10(5);},
					7, {IFSeqOctKick.st10(6);},
					8, {IFSeqOctKick.st10(7);},
					9, {IFSeqOctKick.st10(8);},
					10, {IFSeqOctKick.st10(9);},
					11,{
						IFSeqOctKick.st10(10);
						~cntSeqOctKick10=0;
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
				~cntSeqOctKick11 = ~cntSeqOctKick11 + 1;
				~cntSeqOctKick11.switch(
					0,{},
					1, {IFSeqOctKick.st11(0);},
					2, {IFSeqOctKick.st11(1);},
					3, {IFSeqOctKick.st11(2);},
					4, {IFSeqOctKick.st11(3);},
					5, {IFSeqOctKick.st11(4);},
					6, {IFSeqOctKick.st11(5);},
					7, {IFSeqOctKick.st11(6);},
					8, {IFSeqOctKick.st11(7);},
					9, {IFSeqOctKick.st11(8);},
					10, {IFSeqOctKick.st11(9);},
					11,{
						IFSeqOctKick.st11(10);
						~cntSeqOctKick11=0;
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
				~cntSeqOctKick12 = ~cntSeqOctKick12 + 1;
				~cntSeqOctKick12.switch(
					0,{},
					1, {IFSeqOctKick.st12(0);},
					2, {IFSeqOctKick.st12(1);},
					3, {IFSeqOctKick.st12(2);},
					4, {IFSeqOctKick.st12(3);},
					5, {IFSeqOctKick.st12(4);},
					6, {IFSeqOctKick.st12(5);},
					7, {IFSeqOctKick.st12(6);},
					8, {IFSeqOctKick.st12(7);},
					9, {IFSeqOctKick.st12(8);},
					10, {IFSeqOctKick.st12(9);},
					11,{
						IFSeqOctKick.st12(10);
						~cntSeqOctKick12=0;
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
				~cntSeqOctKick13 = ~cntSeqOctKick13 + 1;
				~cntSeqOctKick13.switch(
					0,{},
					1, {IFSeqOctKick.st13(0);},
					2, {IFSeqOctKick.st13(1);},
					3, {IFSeqOctKick.st13(2);},
					4, {IFSeqOctKick.st13(3);},
					5, {IFSeqOctKick.st13(4);},
					6, {IFSeqOctKick.st13(5);},
					7, {IFSeqOctKick.st13(6);},
					8, {IFSeqOctKick.st13(7);},
					9, {IFSeqOctKick.st13(8);},
					10, {IFSeqOctKick.st13(9);},
					11,{
						IFSeqOctKick.st13(10);
						~cntSeqOctKick13=0;
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
				~cntSeqOctKick14 = ~cntSeqOctKick14 + 1;
				~cntSeqOctKick14.switch(
					0,{},
					1, {IFSeqOctKick.st14(0);},
					2, {IFSeqOctKick.st14(1);},
					3, {IFSeqOctKick.st14(2);},
					4, {IFSeqOctKick.st14(3);},
					5, {IFSeqOctKick.st14(4);},
					6, {IFSeqOctKick.st14(5);},
					7, {IFSeqOctKick.st14(6);},
					8, {IFSeqOctKick.st14(7);},
					9, {IFSeqOctKick.st14(8);},
					10, {IFSeqOctKick.st14(9);},
					11,{
						IFSeqOctKick.st14(10);
						~cntSeqOctKick14=0;
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
				~cntSeqOctKick15 = ~cntSeqOctKick15 + 1;
				~cntSeqOctKick15.switch(
					0,{},
					1, {IFSeqOctKick.st15(0);},
					2, {IFSeqOctKick.st15(1);},
					3, {IFSeqOctKick.st15(2);},
					4, {IFSeqOctKick.st15(3);},
					5, {IFSeqOctKick.st15(4);},
					6, {IFSeqOctKick.st15(5);},
					7, {IFSeqOctKick.st15(6);},
					8, {IFSeqOctKick.st15(7);},
					9, {IFSeqOctKick.st15(8);},
					10, {IFSeqOctKick.st15(9);},
					11,{
						IFSeqOctKick.st15(10);
						~cntSeqOctKick15=0;
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
				~cntSeqOctKick16 = ~cntSeqOctKick16 + 1;
				~cntSeqOctKick16.switch(
					0,{},
					1, {IFSeqOctKick.st16(0);},
					2, {IFSeqOctKick.st16(1);},
					3, {IFSeqOctKick.st16(2);},
					4, {IFSeqOctKick.st16(3);},
					5, {IFSeqOctKick.st16(4);},
					6, {IFSeqOctKick.st16(5);},
					7, {IFSeqOctKick.st16(6);},
					8, {IFSeqOctKick.st16(7);},
					9, {IFSeqOctKick.st16(8);},
					10, {IFSeqOctKick.st16(9);},
					11,{
						IFSeqOctKick.st16(10);
						~cntSeqOctKick16=0;
					}
				)}
			);
			},
			'/ifSeq/1/16'
		);

	}//

	*st01 {|i=0|
		~seqOctKick01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick01', i);
	}
	*st02 {|i=0|
		~seqOctKick02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick02', i);
	}
	*st03 {|i=0|
		~seqOctKick03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick03', i);
	}
	*st04 {|i=0|
		~seqOctKick04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick04', i);
	}
	*st05 {|i=0|
		~seqOctKick05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick05', i);
	}
	*st06 {|i=0|
		~seqOctKick06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick06', i);
	}
	*st07 {|i=0|
		~seqOctKick07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick07', i);
	}
	*st08 {|i=0|
		~seqOctKick08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick08', i);
	}
	*st09 {|i=0|
		~seqOctKick09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick09', i);
	}
	*st10 {|i=0|
		~seqOctKick10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick10', i);
	}
	*st11 {|i=0|
		~seqOctKick11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick11', i);
	}
	*st12 {|i=0|
		~seqOctKick12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick12', i);
	}
	*st13 {|i=0|
		~seqOctKick13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick13', i);
	}
	*st14 {|i=0|
		~seqOctKick14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick14', i);
	}
	*st15 {|i=0|
		~seqOctKick15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick15', i);
	}
	*st16 {|i=0|
		~seqOctKick16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKick16', i);
	}
	*stGrp {|i|

		IFSeqOctKick.st01(i); IFSeqOctKick.st02(i); IFSeqOctKick.st03(i); IFSeqOctKick.st04(i);
		IFSeqOctKick.st05(i); IFSeqOctKick.st06(i); IFSeqOctKick.st07(i); IFSeqOctKick.st08(i);
		IFSeqOctKick.st09(i); IFSeqOctKick.st10(i); IFSeqOctKick.st11(i); IFSeqOctKick.st12(i);
		IFSeqOctKick.st13(i); IFSeqOctKick.st14(i); IFSeqOctKick.st15(i); IFSeqOctKick.st16(i);
	}
}