IFSeqOctBass {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqOctBass01 = PatternProxy( Pseq([2], 1));
		~seqOctBass02 = PatternProxy( Pseq([2], 1));
		~seqOctBass03 = PatternProxy( Pseq([2], 1));
		~seqOctBass04 = PatternProxy( Pseq([2], 1));
		~seqOctBass05 = PatternProxy( Pseq([2], 1));
		~seqOctBass06 = PatternProxy( Pseq([2], 1));
		~seqOctBass07 = PatternProxy( Pseq([2], 1));
		~seqOctBass08 = PatternProxy( Pseq([2], 1));

		~seqOctBass09 = PatternProxy( Pseq([2], 1));
		~seqOctBass10 = PatternProxy( Pseq([2], 1));
		~seqOctBass11 = PatternProxy( Pseq([2], 1));
		~seqOctBass12 = PatternProxy( Pseq([2], 1));
		~seqOctBass13 = PatternProxy( Pseq([2], 1));
		~seqOctBass14 = PatternProxy( Pseq([2], 1));
		~seqOctBass15 = PatternProxy( Pseq([2], 1));
		~seqOctBass16 = PatternProxy( Pseq([2], 1));

	}

	*countReset {
		~cntSeqOctUpBass01=0;
		~cntSeqOctRandBass01=0;

		~cntSeqOctBass01=0;
		~cntSeqOctBass02=0;
		~cntSeqOctBass03=0;
		~cntSeqOctBass04=0;
		~cntSeqOctBass05=0;
		~cntSeqOctBass06=0;
		~cntSeqOctBass07=0;
		~cntSeqOctBass08=0;

		~cntSeqOctBass09=0;
		~cntSeqOctBass10=0;
		~cntSeqOctBass11=0;
		~cntSeqOctBass12=0;
		~cntSeqOctBass13=0;
		~cntSeqOctBass14=0;
		~cntSeqOctBass15=0;
		~cntSeqOctBass16=0;
	}
	*freeOn {
		~seqFreeBassBut.free;
		~seqFreeBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqOctBass.stGrp(0);
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
				~cntSeqOctUpBass01 = ~cntSeqOctUpBass01 + 1;
				~cntSeqOctUpBass01.switch(
					0,{},
					1,{IFSeqOctBass.stGrp(2);},
					2,{IFSeqOctBass.stGrp(3);},
					3,{IFSeqOctBass.stGrp(4);},
					4,{IFSeqOctBass.stGrp(5);},
					5,{IFSeqOctBass.stGrp(6);},
					6,{IFSeqOctBass.stGrp(7);},
					7,{IFSeqOctBass.stGrp(8);
						~cntSeqOctUpBass01=0;
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
				~cntSeqOctRandBass01 = ~cntSeqOctRandBass01 + 1;
				~cntSeqOctRandBass01.switch(
					0,{},
					1,{
						IFSeqOctBass.st01((2..7).choose);
						IFSeqOctBass.st02((2..7).choose);
						IFSeqOctBass.st03((2..7).choose);
						IFSeqOctBass.st04((2..7).choose);
						IFSeqOctBass.st05((2..7).choose);
						IFSeqOctBass.st06((2..7).choose);
						IFSeqOctBass.st07((2..7).choose);
						IFSeqOctBass.st08((2..7).choose);

						IFSeqOctBass.st09((2..7).choose);
						IFSeqOctBass.st10((2..7).choose);
						IFSeqOctBass.st11((2..7).choose);
						IFSeqOctBass.st12((2..7).choose);
						IFSeqOctBass.st13((2..7).choose);
						IFSeqOctBass.st14((2..7).choose);
						IFSeqOctBass.st15((2..7).choose);
						IFSeqOctBass.st16((2..7).choose);
						~cntSeqOctRandBass01=0;
					}
				)}
			);
			},
			'/seqRandBass'
		);
	}

	*on { // Shift OCTAVE
		IFSeqOctBass.randOn;
		IFSeqOctBass.upOn;
		IFSeqOctBass.freeOn;

		~ifSeqBassBut01.free;
		~ifSeqBassBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctBass01 = ~cntSeqOctBass01 + 1;
				~cntSeqOctBass01.switch(
					0,{},
					1,{IFSeqOctBass.st01(2);},
					2,{IFSeqOctBass.st01(3);},
					3,{IFSeqOctBass.st01(4);},
					4,{IFSeqOctBass.st01(5);},
					5,{IFSeqOctBass.st01(6);},
					6,{IFSeqOctBass.st01(7);},
					7,{
						IFSeqOctBass.st01(8);
						~cntSeqOctBass01=0;
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
				~cntSeqOctBass02 = ~cntSeqOctBass02 + 1;
				~cntSeqOctBass02.switch(
					0,{},
					1,{IFSeqOctBass.st02(2);},
					2,{IFSeqOctBass.st02(3);},
					3,{IFSeqOctBass.st02(4);},
					4,{IFSeqOctBass.st02(5);},
					5,{IFSeqOctBass.st02(6);},
					6,{IFSeqOctBass.st02(7);},
					7,{
						IFSeqOctBass.st02(8);
						~cntSeqOctBass02=0;
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
				~cntSeqOctBass03 = ~cntSeqOctBass03 + 1;
				~cntSeqOctBass03.switch(
					0,{},
					1,{IFSeqOctBass.st03(2);},
					2,{IFSeqOctBass.st03(3);},
					3,{IFSeqOctBass.st03(4);},
					4,{IFSeqOctBass.st03(5);},
					5,{IFSeqOctBass.st03(6);},
					6,{IFSeqOctBass.st03(7);},
					7,{
						IFSeqOctBass.st03(8);
						~cntSeqOctBass03=0;
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
				~cntSeqOctBass04 = ~cntSeqOctBass04 + 1;
				~cntSeqOctBass04.switch(
					0,{},
					1,{IFSeqOctBass.st04(2);},
					2,{IFSeqOctBass.st04(3);},
					3,{IFSeqOctBass.st04(4);},
					4,{IFSeqOctBass.st04(5);},
					5,{IFSeqOctBass.st04(6);},
					6,{IFSeqOctBass.st04(7);},
					7,{
						IFSeqOctBass.st04(8);
						~cntSeqOctBass04=0;
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
				~cntSeqOctBass05 = ~cntSeqOctBass05 + 1;
				~cntSeqOctBass05.switch(
					0,{},
					1,{IFSeqOctBass.st05(2);},
					2,{IFSeqOctBass.st05(3);},
					3,{IFSeqOctBass.st05(4);},
					4,{IFSeqOctBass.st05(5);},
					5,{IFSeqOctBass.st05(6);},
					6,{IFSeqOctBass.st05(7);},
					7,{
						IFSeqOctBass.st05(8);
						~cntSeqOctBass05=0;
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
				~cntSeqOctBass06 = ~cntSeqOctBass06 + 1;
				~cntSeqOctBass06.switch(
					0,{},
					1,{IFSeqOctBass.st06(2);},
					2,{IFSeqOctBass.st06(3);},
					3,{IFSeqOctBass.st06(4);},
					4,{IFSeqOctBass.st06(5);},
					5,{IFSeqOctBass.st06(6);},
					6,{IFSeqOctBass.st06(7);},
					7,{
						IFSeqOctBass.st06(8);
						~cntSeqOctBass06=0;
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
				~cntSeqOctBass07 = ~cntSeqOctBass07 + 1;
				~cntSeqOctBass07.switch(
					0,{},
					1,{IFSeqOctBass.st07(2);},
					2,{IFSeqOctBass.st07(3);},
					3,{IFSeqOctBass.st07(4);},
					4,{IFSeqOctBass.st07(5);},
					5,{IFSeqOctBass.st07(6);},
					6,{IFSeqOctBass.st07(7);},
					7,{
						IFSeqOctBass.st07(8);
						~cntSeqOctBass07=0;
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
				~cntSeqOctBass08 = ~cntSeqOctBass08 + 1;
				~cntSeqOctBass08.switch(
					0,{},
					1,{IFSeqOctBass.st08(2);},
					2,{IFSeqOctBass.st08(3);},
					3,{IFSeqOctBass.st08(4);},
					4,{IFSeqOctBass.st08(5);},
					5,{IFSeqOctBass.st08(6);},
					6,{IFSeqOctBass.st08(7);},
					7,{
						IFSeqOctBass.st08(8);
						~cntSeqOctBass08=0;
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
				~cntSeqOctBass09 = ~cntSeqOctBass09 + 1;
				~cntSeqOctBass09.switch(
					0,{},
					1,{IFSeqOctBass.st09(2);},
					2,{IFSeqOctBass.st09(3);},
					3,{IFSeqOctBass.st09(4);},
					4,{IFSeqOctBass.st09(5);},
					5,{IFSeqOctBass.st09(6);},
					6,{IFSeqOctBass.st09(7);},
					7,{
						IFSeqOctBass.st09(8);
						~cntSeqOctBass09=0;
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
				~cntSeqOctBass10 = ~cntSeqOctBass10 + 1;
				~cntSeqOctBass10.switch(
					0,{},
					1,{IFSeqOctBass.st10(2);},
					2,{IFSeqOctBass.st10(3);},
					3,{IFSeqOctBass.st10(4);},
					4,{IFSeqOctBass.st10(5);},
					5,{IFSeqOctBass.st10(6);},
					6,{IFSeqOctBass.st10(7);},
					7,{
						IFSeqOctBass.st10(8);
						~cntSeqOctBass10=0;
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
				~cntSeqOctBass11 = ~cntSeqOctBass11 + 1;
				~cntSeqOctBass11.switch(
					0,{},
					1,{IFSeqOctBass.st11(2);},
					2,{IFSeqOctBass.st11(3);},
					3,{IFSeqOctBass.st11(4);},
					4,{IFSeqOctBass.st11(5);},
					5,{IFSeqOctBass.st11(6);},
					6,{IFSeqOctBass.st11(7);},
					7,{
						IFSeqOctBass.st11(8);
						~cntSeqOctBass11=0;
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
				~cntSeqOctBass12 = ~cntSeqOctBass12 + 1;
				~cntSeqOctBass12.switch(
					0,{},
					1,{IFSeqOctBass.st12(2);},
					2,{IFSeqOctBass.st12(3);},
					3,{IFSeqOctBass.st12(4);},
					4,{IFSeqOctBass.st12(5);},
					5,{IFSeqOctBass.st12(6);},
					6,{IFSeqOctBass.st12(7);},
					7,{
						IFSeqOctBass.st12(8);
						~cntSeqOctBass12=0;
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
				~cntSeqOctBass13 = ~cntSeqOctBass13 + 1;
				~cntSeqOctBass13.switch(
					0,{},
					1,{IFSeqOctBass.st13(2);},
					2,{IFSeqOctBass.st13(3);},
					3,{IFSeqOctBass.st13(4);},
					4,{IFSeqOctBass.st13(5);},
					5,{IFSeqOctBass.st13(6);},
					6,{IFSeqOctBass.st13(7);},
					7,{
						IFSeqOctBass.st13(8);
						~cntSeqOctBass13=0;
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
				~cntSeqOctBass14 = ~cntSeqOctBass14 + 1;
				~cntSeqOctBass14.switch(
					0,{},
					1,{IFSeqOctBass.st14(2);},
					2,{IFSeqOctBass.st14(3);},
					3,{IFSeqOctBass.st14(4);},
					4,{IFSeqOctBass.st14(5);},
					5,{IFSeqOctBass.st14(6);},
					6,{IFSeqOctBass.st14(7);},
					7,{
						IFSeqOctBass.st14(8);
						~cntSeqOctBass14=0;
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
				~cntSeqOctBass15 = ~cntSeqOctBass15 + 1;
				~cntSeqOctBass15.switch(
					0,{},
					1,{IFSeqOctBass.st15(2);},
					2,{IFSeqOctBass.st15(3);},
					3,{IFSeqOctBass.st15(4);},
					4,{IFSeqOctBass.st15(5);},
					5,{IFSeqOctBass.st15(6);},
					6,{IFSeqOctBass.st15(7);},
					7,{
						IFSeqOctBass.st15(8);
						~cntSeqOctBass15=0;
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
				~cntSeqOctBass16 = ~cntSeqOctBass16 + 1;
				~cntSeqOctBass16.switch(
					0,{},
					1,{IFSeqOctBass.st16(2);},
					2,{IFSeqOctBass.st16(3);},
					3,{IFSeqOctBass.st16(4);},
					4,{IFSeqOctBass.st16(5);},
					5,{IFSeqOctBass.st16(6);},
					6,{IFSeqOctBass.st16(7);},
					7,{
						IFSeqOctBass.st16(8);
						~cntSeqOctBass16=0;
					}
				)}
			);
			},
			'/ifSeq/4/16'
		);

	}//

	*st01 {|i=0|
		~seqOctBass01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass01', i);
	}
	*st02 {|i=0|
		~seqOctBass02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass02', i);
	}
	*st03 {|i=0|
		~seqOctBass03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass03', i);
	}
	*st04 {|i=0|
		~seqOctBass04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass04', i);
	}
	*st05 {|i=0|
		~seqOctBass05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass05', i);
	}
	*st06 {|i=0|
		~seqOctBass06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass06', i);
	}
	*st07 {|i=0|
		~seqOctBass07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass07', i);
	}
	*st08 {|i=0|
		~seqOctBass08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass08', i);
	}
	*st09 {|i=0|
		~seqOctBass09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass09', i);
	}
	*st10 {|i=0|
		~seqOctBass10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass10', i);
	}
	*st11 {|i=0|
		~seqOctBass11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass11', i);
	}
	*st12 {|i=0|
		~seqOctBass12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass12', i);
	}
	*st13 {|i=0|
		~seqOctBass13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass13', i);
	}
	*st14 {|i=0|
		~seqOctBass14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass14', i);
	}
	*st15 {|i=0|
		~seqOctBass15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass15', i);
	}
	*st16 {|i=0|
		~seqOctBass16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctBass16', i);
	}
	*stGrp {|i|

		IFSeqOctBass.st01(i); IFSeqOctBass.st02(i); IFSeqOctBass.st03(i); IFSeqOctBass.st04(i);
		IFSeqOctBass.st05(i); IFSeqOctBass.st06(i); IFSeqOctBass.st07(i); IFSeqOctBass.st08(i);
		IFSeqOctBass.st09(i); IFSeqOctBass.st10(i); IFSeqOctBass.st11(i); IFSeqOctBass.st12(i);
		IFSeqOctBass.st13(i); IFSeqOctBass.st14(i); IFSeqOctBass.st15(i); IFSeqOctBass.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqOctBass.st01(s01); IFSeqOctBass.st02(s02); IFSeqOctBass.st03(s03); IFSeqOctBass.st04(s04);
		IFSeqOctBass.st05(s05); IFSeqOctBass.st06(s06); IFSeqOctBass.st07(s07); IFSeqOctBass.st08(s08);
		IFSeqOctBass.st09(s09); IFSeqOctBass.st10(s10); IFSeqOctBass.st11(s11); IFSeqOctBass.st12(s12);
		IFSeqOctBass.st13(s13); IFSeqOctBass.st14(s14); IFSeqOctBass.st15(s15); IFSeqOctBass.st16(s16);
	}
}