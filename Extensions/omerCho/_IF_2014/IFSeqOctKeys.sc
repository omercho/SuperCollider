IFSeqOctKeys {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqOctKeys01 = PatternProxy( Pseq([2], 1));
		~seqOctKeys02 = PatternProxy( Pseq([2], 1));
		~seqOctKeys03 = PatternProxy( Pseq([2], 1));
		~seqOctKeys04 = PatternProxy( Pseq([2], 1));
		~seqOctKeys05 = PatternProxy( Pseq([2], 1));
		~seqOctKeys06 = PatternProxy( Pseq([2], 1));
		~seqOctKeys07 = PatternProxy( Pseq([2], 1));
		~seqOctKeys08 = PatternProxy( Pseq([2], 1));

		~seqOctKeys09 = PatternProxy( Pseq([2], 1));
		~seqOctKeys10 = PatternProxy( Pseq([2], 1));
		~seqOctKeys11 = PatternProxy( Pseq([2], 1));
		~seqOctKeys12 = PatternProxy( Pseq([2], 1));
		~seqOctKeys13 = PatternProxy( Pseq([2], 1));
		~seqOctKeys14 = PatternProxy( Pseq([2], 1));
		~seqOctKeys15 = PatternProxy( Pseq([2], 1));
		~seqOctKeys16 = PatternProxy( Pseq([2], 1));

	}

	*countReset {
		~cntSeqOctUpKeys01=0;
		~cntSeqOctRandKeys01=0;

		~cntSeqOctKeys01=0;
		~cntSeqOctKeys02=0;
		~cntSeqOctKeys03=0;
		~cntSeqOctKeys04=0;
		~cntSeqOctKeys05=0;
		~cntSeqOctKeys06=0;
		~cntSeqOctKeys07=0;
		~cntSeqOctKeys08=0;

		~cntSeqOctKeys09=0;
		~cntSeqOctKeys10=0;
		~cntSeqOctKeys11=0;
		~cntSeqOctKeys12=0;
		~cntSeqOctKeys13=0;
		~cntSeqOctKeys14=0;
		~cntSeqOctKeys15=0;
		~cntSeqOctKeys16=0;
	}
	*freeOn {
		~seqFreeKeysBut.free;
		~seqFreeKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqOctKeys.stGrp(0);
			});
			},
			'/seqFreeKeys'
		);

	}

	*upOn {
		~ifSeqUpKeysBut.free;
		~ifSeqUpKeysBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctUpKeys01 = ~cntSeqOctUpKeys01 + 1;
				~cntSeqOctUpKeys01.switch(
					0,{},
					1,{IFSeqOctKeys.stGrp(2);},
					2,{IFSeqOctKeys.stGrp(3);},
					3,{IFSeqOctKeys.stGrp(4);},
					4,{IFSeqOctKeys.stGrp(5);},
					5,{IFSeqOctKeys.stGrp(6);},
					6,{IFSeqOctKeys.stGrp(7);},
					7,{IFSeqOctKeys.stGrp(8);
						~cntSeqOctUpKeys01=0;
					}
				)}
			);
			},
			'/seqUpKeys'
		);
	}

	*randOn {
		~ifSeqRandKeysBut.free;
		~ifSeqRandKeysBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctRandKeys01 = ~cntSeqOctRandKeys01 + 1;
				~cntSeqOctRandKeys01.switch(
					0,{},
					1,{
						IFSeqOctKeys.st01((2..8).choose);
						IFSeqOctKeys.st02((2..8).choose);
						IFSeqOctKeys.st03((2..8).choose);
						IFSeqOctKeys.st04((2..8).choose);
						IFSeqOctKeys.st05((2..8).choose);
						IFSeqOctKeys.st06((2..8).choose);
						IFSeqOctKeys.st07((2..8).choose);
						IFSeqOctKeys.st08((2..8).choose);

						IFSeqOctKeys.st09((2..8).choose);
						IFSeqOctKeys.st10((2..8).choose);
						IFSeqOctKeys.st11((2..8).choose);
						IFSeqOctKeys.st12((2..8).choose);
						IFSeqOctKeys.st13((2..8).choose);
						IFSeqOctKeys.st14((2..8).choose);
						IFSeqOctKeys.st15((2..8).choose);
						IFSeqOctKeys.st16((2..8).choose);
						~cntSeqOctRandKeys01=0;
					}
				)}
			);
			},
			'/seqRandKeys'
		);
	}

	*on { // Shift OCTAVE
		IFSeqOctKeys.randOn;
		IFSeqOctKeys.upOn;
		IFSeqOctKeys.freeOn;

		~ifSeqKeysBut01.free;
		~ifSeqKeysBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys01 = ~cntSeqOctKeys01 + 1;
				~cntSeqOctKeys01.switch(
					0,{},
					1,{IFSeqOctKeys.st01(2);},
					2,{IFSeqOctKeys.st01(3);},
					3,{IFSeqOctKeys.st01(4);},
					4,{IFSeqOctKeys.st01(5);},
					5,{IFSeqOctKeys.st01(6);},
					6,{IFSeqOctKeys.st01(7);},
					7,{
						IFSeqOctKeys.st01(8);
						~cntSeqOctKeys01=0;
					}
				)}
			);
			},
			'/ifSeq/5/1'
		);
		~ifSeqKeysBut02.free;
		~ifSeqKeysBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys02 = ~cntSeqOctKeys02 + 1;
				~cntSeqOctKeys02.switch(
					0,{},
					1,{IFSeqOctKeys.st02(2);},
					2,{IFSeqOctKeys.st02(3);},
					3,{IFSeqOctKeys.st02(4);},
					4,{IFSeqOctKeys.st02(5);},
					5,{IFSeqOctKeys.st02(6);},
					6,{IFSeqOctKeys.st02(7);},
					7,{
						IFSeqOctKeys.st02(8);
						~cntSeqOctKeys02=0;
					}
				)}
			);
			},
			'/ifSeq/5/2'
		);
		~ifSeqKeysBut03.free;
		~ifSeqKeysBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys03 = ~cntSeqOctKeys03 + 1;
				~cntSeqOctKeys03.switch(
					0,{},
					1,{IFSeqOctKeys.st03(2);},
					2,{IFSeqOctKeys.st03(3);},
					3,{IFSeqOctKeys.st03(4);},
					4,{IFSeqOctKeys.st03(5);},
					5,{IFSeqOctKeys.st03(6);},
					6,{IFSeqOctKeys.st03(7);},
					7,{
						IFSeqOctKeys.st03(8);
						~cntSeqOctKeys03=0;
					}
				)}
			);
			},
			'/ifSeq/5/3'
		);
		~ifSeqKeysBut04.free;
		~ifSeqKeysBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys04 = ~cntSeqOctKeys04 + 1;
				~cntSeqOctKeys04.switch(
					0,{},
					1,{IFSeqOctKeys.st04(2);},
					2,{IFSeqOctKeys.st04(3);},
					3,{IFSeqOctKeys.st04(4);},
					4,{IFSeqOctKeys.st04(5);},
					5,{IFSeqOctKeys.st04(6);},
					6,{IFSeqOctKeys.st04(7);},
					7,{
						IFSeqOctKeys.st04(8);
						~cntSeqOctKeys04=0;
					}
				)}
			);
			},
			'/ifSeq/5/4'
		);
		~ifSeqKeysBut05.free;
		~ifSeqKeysBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys05 = ~cntSeqOctKeys05 + 1;
				~cntSeqOctKeys05.switch(
					0,{},
					1,{IFSeqOctKeys.st05(2);},
					2,{IFSeqOctKeys.st05(3);},
					3,{IFSeqOctKeys.st05(4);},
					4,{IFSeqOctKeys.st05(5);},
					5,{IFSeqOctKeys.st05(6);},
					6,{IFSeqOctKeys.st05(7);},
					7,{
						IFSeqOctKeys.st05(8);
						~cntSeqOctKeys05=0;
					}
				)}
			);
			},
			'/ifSeq/5/5'
		);
		~ifSeqKeysBut06.free;
		~ifSeqKeysBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys06 = ~cntSeqOctKeys06 + 1;
				~cntSeqOctKeys06.switch(
					0,{},
					1,{IFSeqOctKeys.st06(2);},
					2,{IFSeqOctKeys.st06(3);},
					3,{IFSeqOctKeys.st06(4);},
					4,{IFSeqOctKeys.st06(5);},
					5,{IFSeqOctKeys.st06(6);},
					6,{IFSeqOctKeys.st06(7);},
					7,{
						IFSeqOctKeys.st06(8);
						~cntSeqOctKeys06=0;
					}
				)}
			);
			},
			'/ifSeq/5/6'
		);
		~ifSeqKeysBut07.free;
		~ifSeqKeysBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys07 = ~cntSeqOctKeys07 + 1;
				~cntSeqOctKeys07.switch(
					0,{},
					1,{IFSeqOctKeys.st07(2);},
					2,{IFSeqOctKeys.st07(3);},
					3,{IFSeqOctKeys.st07(4);},
					4,{IFSeqOctKeys.st07(5);},
					5,{IFSeqOctKeys.st07(6);},
					6,{IFSeqOctKeys.st07(7);},
					7,{
						IFSeqOctKeys.st07(8);
						~cntSeqOctKeys07=0;
					}
				)}
			);
			},
			'/ifSeq/5/7'
		);
		~ifSeqKeysBut08.free;
		~ifSeqKeysBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys08 = ~cntSeqOctKeys08 + 1;
				~cntSeqOctKeys08.switch(
					0,{},
					1,{IFSeqOctKeys.st08(2);},
					2,{IFSeqOctKeys.st08(3);},
					3,{IFSeqOctKeys.st08(4);},
					4,{IFSeqOctKeys.st08(5);},
					5,{IFSeqOctKeys.st08(6);},
					6,{IFSeqOctKeys.st08(7);},
					7,{
						IFSeqOctKeys.st08(8);
						~cntSeqOctKeys08=0;
					}
				)}
			);
			},
			'/ifSeq/5/8'
		);
		~ifSeqKeysBut09.free;
		~ifSeqKeysBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys09 = ~cntSeqOctKeys09 + 1;
				~cntSeqOctKeys09.switch(
					0,{},
					1,{IFSeqOctKeys.st09(2);},
					2,{IFSeqOctKeys.st09(3);},
					3,{IFSeqOctKeys.st09(4);},
					4,{IFSeqOctKeys.st09(5);},
					5,{IFSeqOctKeys.st09(6);},
					6,{IFSeqOctKeys.st09(7);},
					7,{
						IFSeqOctKeys.st09(8);
						~cntSeqOctKeys09=0;
					}
				)}
			);
			},
			'/ifSeq/5/9'
		);
		~ifSeqKeysBut10.free;
		~ifSeqKeysBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys10 = ~cntSeqOctKeys10 + 1;
				~cntSeqOctKeys10.switch(
					0,{},
					1,{IFSeqOctKeys.st10(2);},
					2,{IFSeqOctKeys.st10(3);},
					3,{IFSeqOctKeys.st10(4);},
					4,{IFSeqOctKeys.st10(5);},
					5,{IFSeqOctKeys.st10(6);},
					6,{IFSeqOctKeys.st10(7);},
					7,{
						IFSeqOctKeys.st10(8);
						~cntSeqOctKeys10=0;
					}
				)}
			);
			},
			'/ifSeq/5/10'
		);
		~ifSeqKeysBut11.free;
		~ifSeqKeysBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys11 = ~cntSeqOctKeys11 + 1;
				~cntSeqOctKeys11.switch(
					0,{},
					1,{IFSeqOctKeys.st11(2);},
					2,{IFSeqOctKeys.st11(3);},
					3,{IFSeqOctKeys.st11(4);},
					4,{IFSeqOctKeys.st11(5);},
					5,{IFSeqOctKeys.st11(6);},
					6,{IFSeqOctKeys.st11(7);},
					7,{
						IFSeqOctKeys.st11(8);
						~cntSeqOctKeys11=0;
					}
				)}
			);
			},
			'/ifSeq/5/11'
		);
		~ifSeqKeysBut12.free;
		~ifSeqKeysBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys12 = ~cntSeqOctKeys12 + 1;
				~cntSeqOctKeys12.switch(
					0,{},
					1,{IFSeqOctKeys.st12(2);},
					2,{IFSeqOctKeys.st12(3);},
					3,{IFSeqOctKeys.st12(4);},
					4,{IFSeqOctKeys.st12(5);},
					5,{IFSeqOctKeys.st12(6);},
					6,{IFSeqOctKeys.st12(7);},
					7,{
						IFSeqOctKeys.st12(8);
						~cntSeqOctKeys12=0;
					}
				)}
			);
			},
			'/ifSeq/5/12'
		);
		~ifSeqKeysBut13.free;
		~ifSeqKeysBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys13 = ~cntSeqOctKeys13 + 1;
				~cntSeqOctKeys13.switch(
					0,{},
					1,{IFSeqOctKeys.st13(2);},
					2,{IFSeqOctKeys.st13(3);},
					3,{IFSeqOctKeys.st13(4);},
					4,{IFSeqOctKeys.st13(5);},
					5,{IFSeqOctKeys.st13(6);},
					6,{IFSeqOctKeys.st13(7);},
					7,{
						IFSeqOctKeys.st13(8);
						~cntSeqOctKeys13=0;
					}
				)}
			);
			},
			'/ifSeq/5/13'
		);
		~ifSeqKeysBut14.free;
		~ifSeqKeysBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys14 = ~cntSeqOctKeys14 + 1;
				~cntSeqOctKeys14.switch(
					0,{},
					1,{IFSeqOctKeys.st14(2);},
					2,{IFSeqOctKeys.st14(3);},
					3,{IFSeqOctKeys.st14(4);},
					4,{IFSeqOctKeys.st14(5);},
					5,{IFSeqOctKeys.st14(6);},
					6,{IFSeqOctKeys.st14(7);},
					7,{
						IFSeqOctKeys.st14(8);
						~cntSeqOctKeys14=0;
					}
				)}
			);
			},
			'/ifSeq/5/14'
		);
		~ifSeqKeysBut15.free;
		~ifSeqKeysBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys15 = ~cntSeqOctKeys15 + 1;
				~cntSeqOctKeys15.switch(
					0,{},
					1,{IFSeqOctKeys.st15(2);},
					2,{IFSeqOctKeys.st15(3);},
					3,{IFSeqOctKeys.st15(4);},
					4,{IFSeqOctKeys.st15(5);},
					5,{IFSeqOctKeys.st15(6);},
					6,{IFSeqOctKeys.st15(7);},
					7,{
						IFSeqOctKeys.st15(8);
						~cntSeqOctKeys15=0;
					}
				)}
			);
			},
			'/ifSeq/5/15'
		);
		~ifSeqKeysBut16.free;
		~ifSeqKeysBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctKeys16 = ~cntSeqOctKeys16 + 1;
				~cntSeqOctKeys16.switch(
					0,{},
					1,{IFSeqOctKeys.st16(2);},
					2,{IFSeqOctKeys.st16(3);},
					3,{IFSeqOctKeys.st16(4);},
					4,{IFSeqOctKeys.st16(5);},
					5,{IFSeqOctKeys.st16(6);},
					6,{IFSeqOctKeys.st16(7);},
					7,{
						IFSeqOctKeys.st16(8);
						~cntSeqOctKeys16=0;
					}
				)}
			);
			},
			'/ifSeq/5/16'
		);

	}//

	*st01 {|i=0|
		~seqOctKeys01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys01', i);
	}
	*st02 {|i=0|
		~seqOctKeys02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys02', i);
	}
	*st03 {|i=0|
		~seqOctKeys03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys03', i);
	}
	*st04 {|i=0|
		~seqOctKeys04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys04', i);
	}
	*st05 {|i=0|
		~seqOctKeys05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys05', i);
	}
	*st06 {|i=0|
		~seqOctKeys06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys06', i);
	}
	*st07 {|i=0|
		~seqOctKeys07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys07', i);
	}
	*st08 {|i=0|
		~seqOctKeys08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys08', i);
	}
	*st09 {|i=0|
		~seqOctKeys09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys09', i);
	}
	*st10 {|i=0|
		~seqOctKeys10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys10', i);
	}
	*st11 {|i=0|
		~seqOctKeys11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys11', i);
	}
	*st12 {|i=0|
		~seqOctKeys12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys12', i);
	}
	*st13 {|i=0|
		~seqOctKeys13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys13', i);
	}
	*st14 {|i=0|
		~seqOctKeys14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys14', i);
	}
	*st15 {|i=0|
		~seqOctKeys15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys15', i);
	}
	*st16 {|i=0|
		~seqOctKeys16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctKeys16', i);
	}
	*stGrp {|i|

		IFSeqOctKeys.st01(i); IFSeqOctKeys.st02(i); IFSeqOctKeys.st03(i); IFSeqOctKeys.st04(i);
		IFSeqOctKeys.st05(i); IFSeqOctKeys.st06(i); IFSeqOctKeys.st07(i); IFSeqOctKeys.st08(i);
		IFSeqOctKeys.st09(i); IFSeqOctKeys.st10(i); IFSeqOctKeys.st11(i); IFSeqOctKeys.st12(i);
		IFSeqOctKeys.st13(i); IFSeqOctKeys.st14(i); IFSeqOctKeys.st15(i); IFSeqOctKeys.st16(i);
	}
}