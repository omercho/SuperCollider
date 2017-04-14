IFSeqStBass {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqStBass01 = PatternProxy( Pseq([0], 1));
		~seqStBass02 = PatternProxy( Pseq([0], 1));
		~seqStBass03 = PatternProxy( Pseq([0], 1));
		~seqStBass04 = PatternProxy( Pseq([0], 1));
		~seqStBass05 = PatternProxy( Pseq([0], 1));
		~seqStBass06 = PatternProxy( Pseq([0], 1));
		~seqStBass07 = PatternProxy( Pseq([0], 1));
		~seqStBass08 = PatternProxy( Pseq([0], 1));

		~seqStBass09 = PatternProxy( Pseq([0], 1));
		~seqStBass10 = PatternProxy( Pseq([0], 1));
		~seqStBass11 = PatternProxy( Pseq([0], 1));
		~seqStBass12 = PatternProxy( Pseq([0], 1));
		~seqStBass13 = PatternProxy( Pseq([0], 1));
		~seqStBass14 = PatternProxy( Pseq([0], 1));
		~seqStBass15 = PatternProxy( Pseq([0], 1));
		~seqStBass16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqStUpBass01=0;
		~cntSeqStRandBass01=0;

		~cntSeqStBass01=0;
		~cntSeqStBass02=0;
		~cntSeqStBass03=0;
		~cntSeqStBass04=0;
		~cntSeqStBass05=0;
		~cntSeqStBass06=0;
		~cntSeqStBass07=0;
		~cntSeqStBass08=0;

		~cntSeqStBass09=0;
		~cntSeqStBass10=0;
		~cntSeqStBass11=0;
		~cntSeqStBass12=0;
		~cntSeqStBass13=0;
		~cntSeqStBass14=0;
		~cntSeqStBass15=0;
		~cntSeqStBass16=0;
	}
	*freeOn {
		~seqFreeBassBut.free;
		~seqFreeBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqStBass.stGrp(0);
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
				~cntSeqStUpBass01 = ~cntSeqStUpBass01 + 1;
				~cntSeqStUpBass01.switch(
					0,{},
					1,{IFSeqStBass.stGrp(0);},
					2,{IFSeqStBass.stGrp(1);},
					3,{IFSeqStBass.stGrp(2);},
					4,{IFSeqStBass.stGrp(3);},
					5,{IFSeqStBass.stGrp(4);},
					6,{IFSeqStBass.stGrp(5);},
					7,{IFSeqStBass.stGrp(6);},
					8,{IFSeqStBass.stGrp(7);
						~cntSeqStUpBass01=0;
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
				~cntSeqStRandBass01 = ~cntSeqStRandBass01 + 1;
				~cntSeqStRandBass01.switch(
					0,{},
					1,{
						IFSeqStBass.st01([0,1].choose);
						IFSeqStBass.st02([0,1].choose);
						IFSeqStBass.st03([0,1].choose);
						IFSeqStBass.st04([0,1].choose);
						IFSeqStBass.st05([0,1].choose);
						IFSeqStBass.st06([0,1].choose);
						IFSeqStBass.st07([0,1].choose);
						IFSeqStBass.st08([0,1].choose);

						IFSeqStBass.st09([0,1].choose);
						IFSeqStBass.st10([0,1].choose);
						IFSeqStBass.st11([0,1].choose);
						IFSeqStBass.st12([0,1].choose);
						IFSeqStBass.st13([0,1].choose);
						IFSeqStBass.st14([0,1].choose);
						IFSeqStBass.st15([0,1].choose);
						IFSeqStBass.st16([0,1].choose);
						~cntSeqStRandBass01=0;
					}
				)}
			);
			},
			'/seqRandBass'
		);
	}

	*on { // Shift StAVE
		IFSeqStBass.randOn;
		IFSeqStBass.upOn;
		IFSeqStBass.freeOn;

		~ifSeqBassBut01.free;
		~ifSeqBassBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStBass01 = ~cntSeqStBass01 + 1;
				~cntSeqStBass01.switch(
					0,{},
					1, {IFSeqStBass.st01(0);},
					2, {IFSeqStBass.st01(1);
						~cntSeqStBass01=0;
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
				~cntSeqStBass02 = ~cntSeqStBass02 + 1;
				~cntSeqStBass02.switch(
					0,{},
					1, {IFSeqStBass.st02(0);},
					2, {IFSeqStBass.st02(1);
						~cntSeqStBass02=0;
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
				~cntSeqStBass03 = ~cntSeqStBass03 + 1;
				~cntSeqStBass03.switch(
					0,{},
					1, {IFSeqStBass.st03(0);},
					2, {IFSeqStBass.st03(1);
						~cntSeqStBass03=0;
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
				~cntSeqStBass04 = ~cntSeqStBass04 + 1;
				~cntSeqStBass04.switch(
					0,{},
					1, {IFSeqStBass.st04(0);},
					2, {IFSeqStBass.st04(1);
						~cntSeqStBass04=0;
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
				~cntSeqStBass05 = ~cntSeqStBass05 + 1;
				~cntSeqStBass05.switch(
					0,{},
					1, {IFSeqStBass.st05(0);},
					2, {IFSeqStBass.st05(1);
						~cntSeqStBass05=0;
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
				~cntSeqStBass06 = ~cntSeqStBass06 + 1;
				~cntSeqStBass06.switch(
					0,{},
					1, {IFSeqStBass.st06(0);},
					2, {IFSeqStBass.st06(1);
						~cntSeqStBass06=0;
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
				~cntSeqStBass07 = ~cntSeqStBass07 + 1;
				~cntSeqStBass07.switch(
					0,{},
					1, {IFSeqStBass.st07(0);},
					2, {IFSeqStBass.st07(1);
						~cntSeqStBass07=0;
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
				~cntSeqStBass08 = ~cntSeqStBass08 + 1;
				~cntSeqStBass08.switch(
					0,{},
					1, {IFSeqStBass.st08(0);},
					2, {IFSeqStBass.st08(1);
						~cntSeqStBass08=0;
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
				~cntSeqStBass09 = ~cntSeqStBass09 + 1;
				~cntSeqStBass09.switch(
					0,{},
					1, {IFSeqStBass.st09(0);},
					2, {IFSeqStBass.st09(1);
						~cntSeqStBass09=0;
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
				~cntSeqStBass10 = ~cntSeqStBass10 + 1;
				~cntSeqStBass10.switch(
					0,{},
					1, {IFSeqStBass.st10(0);},
					2, {IFSeqStBass.st10(1);
						~cntSeqStBass10=0;
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
				~cntSeqStBass11 = ~cntSeqStBass11 + 1;
				~cntSeqStBass11.switch(
					0,{},
					1, {IFSeqStBass.st11(0);},
					2, {IFSeqStBass.st11(1);
						~cntSeqStBass11=0;
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
				~cntSeqStBass12 = ~cntSeqStBass12 + 1;
				~cntSeqStBass12.switch(
					0,{},
					1, {IFSeqStBass.st12(0);},
					2, {IFSeqStBass.st12(1);
						~cntSeqStBass12=0;
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
				~cntSeqStBass13 = ~cntSeqStBass13 + 1;
				~cntSeqStBass13.switch(
					0,{},
					1, {IFSeqStBass.st13(0);},
					2, {IFSeqStBass.st13(1);
						~cntSeqStBass13=0;
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
				~cntSeqStBass14 = ~cntSeqStBass14 + 1;
				~cntSeqStBass14.switch(
					0,{},
					1, {IFSeqStBass.st14(0);},
					2, {IFSeqStBass.st14(1);
						~cntSeqStBass14=0;
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
				~cntSeqStBass15 = ~cntSeqStBass15 + 1;
				~cntSeqStBass15.switch(
					0,{},
					1, {IFSeqStBass.st15(0);},
					2, {IFSeqStBass.st15(1);
						~cntSeqStBass15=0;
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
				~cntSeqStBass16 = ~cntSeqStBass16 + 1;
				~cntSeqStBass16.switch(
					0,{},
					1, {IFSeqStBass.st16(0);},
					2, {IFSeqStBass.st16(1);
						~cntSeqStBass16=0;
					}
				)}
			);
			},
			'/ifSeq/4/16'
		);

	}//

	*st01 {|i=0|
		~seqStBass01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass01', i);
	}
	*st02 {|i=0|
		~seqStBass02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass02', i);
	}
	*st03 {|i=0|
		~seqStBass03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass03', i);
	}
	*st04 {|i=0|
		~seqStBass04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass04', i);
	}
	*st05 {|i=0|
		~seqStBass05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass05', i);
	}
	*st06 {|i=0|
		~seqStBass06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass06', i);
	}
	*st07 {|i=0|
		~seqStBass07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass07', i);
	}
	*st08 {|i=0|
		~seqStBass08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass08', i);
	}
	*st09 {|i=0|
		~seqStBass09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass09', i);
	}
	*st10 {|i=0|
		~seqStBass10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass10', i);
	}
	*st11 {|i=0|
		~seqStBass11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass11', i);
	}
	*st12 {|i=0|
		~seqStBass12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass12', i);
	}
	*st13 {|i=0|
		~seqStBass13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass13', i);
	}
	*st14 {|i=0|
		~seqStBass14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass14', i);
	}
	*st15 {|i=0|
		~seqStBass15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass15', i);
	}
	*st16 {|i=0|
		~seqStBass16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStBass16', i);
	}
	*stGrp {|i|

		IFSeqStBass.st01(i); IFSeqStBass.st02(i); IFSeqStBass.st03(i); IFSeqStBass.st04(i);
		IFSeqStBass.st05(i); IFSeqStBass.st06(i); IFSeqStBass.st07(i); IFSeqStBass.st08(i);
		IFSeqStBass.st09(i); IFSeqStBass.st10(i); IFSeqStBass.st11(i); IFSeqStBass.st12(i);
		IFSeqStBass.st13(i); IFSeqStBass.st14(i); IFSeqStBass.st15(i); IFSeqStBass.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqStBass.st01(s01); IFSeqStBass.st02(s02); IFSeqStBass.st03(s03); IFSeqStBass.st04(s04);
		IFSeqStBass.st05(s05); IFSeqStBass.st06(s06); IFSeqStBass.st07(s07); IFSeqStBass.st08(s08);
		IFSeqStBass.st09(s09); IFSeqStBass.st10(s10); IFSeqStBass.st11(s11); IFSeqStBass.st12(s12);
		IFSeqStBass.st13(s13); IFSeqStBass.st14(s14); IFSeqStBass.st15(s15); IFSeqStBass.st16(s16);
	}
}