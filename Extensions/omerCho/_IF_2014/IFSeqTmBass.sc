IFSeqTmBass {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~tmMulBass = PatternProxy( Pseq([1], inf));
		~tmMulBassP= Pseq([~tmMulBass], inf).asStream;

		~tmBass = PatternProxy( Pseq([1], inf));
		~tmBassP= Pseq([~tmBass], inf).asStream;

		~seqTmBass01 = PatternProxy( Pseq([1], 1));
		~seqTmBass02 = PatternProxy( Pseq([1], 1));
		~seqTmBass03 = PatternProxy( Pseq([1], 1));
		~seqTmBass04 = PatternProxy( Pseq([1], 1));
		~seqTmBass05 = PatternProxy( Pseq([1], 1));
		~seqTmBass06 = PatternProxy( Pseq([1], 1));
		~seqTmBass07 = PatternProxy( Pseq([1], 1));
		~seqTmBass08 = PatternProxy( Pseq([1], 1));

		~seqTmBass08 = PatternProxy( Pseq([1], 1));
		~seqTmBass09 = PatternProxy( Pseq([1], 1));
		~seqTmBass10 = PatternProxy( Pseq([1], 1));
		~seqTmBass11 = PatternProxy( Pseq([1], 1));
		~seqTmBass12 = PatternProxy( Pseq([1], 1));
		~seqTmBass13 = PatternProxy( Pseq([1], 1));
		~seqTmBass14 = PatternProxy( Pseq([1], 1));
		~seqTmBass15 = PatternProxy( Pseq([1], 1));
		~seqTmBass16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqTmUpBass01=0;
		~cntSeqTmRandBass01=0;

		~cntSeqTmBass01=0;
		~cntSeqTmBass02=0;
		~cntSeqTmBass03=0;
		~cntSeqTmBass04=0;
		~cntSeqTmBass05=0;
		~cntSeqTmBass06=0;
		~cntSeqTmBass07=0;
		~cntSeqTmBass08=0;

		~cntSeqTmBass09=0;
		~cntSeqTmBass10=0;
		~cntSeqTmBass11=0;
		~cntSeqTmBass12=0;
		~cntSeqTmBass13=0;
		~cntSeqTmBass14=0;
		~cntSeqTmBass15=0;
		~cntSeqTmBass16=0;
	}
	*freeOn {
		~seqFreeBassBut.free;
		~seqFreeBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqTmBass.stGrp(1);
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
				~cntSeqTmUpBass01 = ~cntSeqTmUpBass01 + 1;
				~cntSeqTmUpBass01.switch(
					0,{},
					1,{IFSeqTmBass.stGrp(1);},
					2,{IFSeqTmBass.stGrp(2);
						~cntSeqTmUpBass01=0;
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
				~cntSeqTmRandBass01 = ~cntSeqTmRandBass01 + 1;
				~cntSeqTmRandBass01.switch(
					0,{},
					1,{
						IFSeqTmBass.st01([1,2].choose);
						IFSeqTmBass.st02([1,2].choose);
						IFSeqTmBass.st03([1,2].choose);
						IFSeqTmBass.st04([1,2].choose);
						IFSeqTmBass.st05([1,2].choose);
						IFSeqTmBass.st06([1,2].choose);
						IFSeqTmBass.st07([1,2].choose);
						IFSeqTmBass.st08([1,2].choose);

						IFSeqTmBass.st09([1,2].choose);
						IFSeqTmBass.st10([1,2].choose);
						IFSeqTmBass.st11([1,2].choose);
						IFSeqTmBass.st12([1,2].choose);
						IFSeqTmBass.st13([1,2].choose);
						IFSeqTmBass.st14([1,2].choose);
						IFSeqTmBass.st15([1,2].choose);
						IFSeqTmBass.st16([1,2].choose);
						~cntSeqTmRandBass01=0;
					}
				)}
			);
			},
			'/seqRandBass'
		);
	}


	*on { // Shift Tmocity

		IFSeqTmBass.randOn;
		IFSeqTmBass.upOn;
		IFSeqTmBass.freeOn;

		~ifSeqBassBut01.free;
		~ifSeqBassBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass01 = ~cntSeqTmBass01 + 1;
				~cntSeqTmBass01.switch(
					0,{},
					1, {IFSeqTmBass.st01(1);},
					2, {IFSeqTmBass.st01(2);~cntSeqTmBass01=0;}
				)}
			);
			},
			'/ifSeq/4/1'
		);
		~ifSeqBassBut02.free;
		~ifSeqBassBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass02 = ~cntSeqTmBass02 + 1;
				~cntSeqTmBass02.switch(
					0,{},
					1, {IFSeqTmBass.st02(1);},
					2, {IFSeqTmBass.st02(2);~cntSeqTmBass02=0;}
				)}
			);
			},
			'/ifSeq/4/2'
		);
		~ifSeqBassBut03.free;
		~ifSeqBassBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass03 = ~cntSeqTmBass03 + 1;
				~cntSeqTmBass03.switch(
					0,{},
					1, {IFSeqTmBass.st03(1);},
					2, {IFSeqTmBass.st03(2);~cntSeqTmBass03=0;}
				)}
			);
			},
			'/ifSeq/4/3'
		);
		~ifSeqBassBut04.free;
		~ifSeqBassBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass04 = ~cntSeqTmBass04 + 1;
				~cntSeqTmBass04.switch(
					0,{},
					1, {IFSeqTmBass.st04(1);},
					2, {IFSeqTmBass.st04(2);~cntSeqTmBass04=0;}
				)}
			);
			},
			'/ifSeq/4/4'
		);
		~ifSeqBassBut05.free;
		~ifSeqBassBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass05 = ~cntSeqTmBass05 + 1;
				~cntSeqTmBass05.switch(
					0,{},
					1, {IFSeqTmBass.st05(1);},
					2, {IFSeqTmBass.st05(2);~cntSeqTmBass05=0;}
				)}
			);
			},
			'/ifSeq/4/5'
		);
		~ifSeqBassBut06.free;
		~ifSeqBassBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass06 = ~cntSeqTmBass06 + 1;
				~cntSeqTmBass06.switch(
					0,{},
					1, {IFSeqTmBass.st06(1);},
					2, {IFSeqTmBass.st06(2);~cntSeqTmBass06=0;}
				)}
			);
			},
			'/ifSeq/4/6'
		);
		~ifSeqBassBut07.free;
		~ifSeqBassBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass07 = ~cntSeqTmBass07 + 1;
				~cntSeqTmBass07.switch(
					0,{},
					1, {IFSeqTmBass.st07(1);},
					2, {IFSeqTmBass.st07(2);~cntSeqTmBass07=0;}
				)}
			);
			},
			'/ifSeq/4/7'
		);
		~ifSeqBassBut08.free;
		~ifSeqBassBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass08 = ~cntSeqTmBass08 + 1;
				~cntSeqTmBass08.switch(
					0,{},
					1, {IFSeqTmBass.st08(1);},
					2, {IFSeqTmBass.st08(2);~cntSeqTmBass08=0;}
				)}
			);
			},
			'/ifSeq/4/8'
		);

		~ifSeqBassBut09.free;
		~ifSeqBassBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass09 = ~cntSeqTmBass09 + 1;
				~cntSeqTmBass09.switch(
					0,{},
					1, {IFSeqTmBass.st09(1);},
					2, {IFSeqTmBass.st09(2);~cntSeqTmBass09=0;}
				)}
			);
			},
			'/ifSeq/4/9'
		);
		~ifSeqBassBut10.free;
		~ifSeqBassBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass10 = ~cntSeqTmBass10 + 1;
				~cntSeqTmBass10.switch(
					0,{},
					1, {IFSeqTmBass.st10(1);},
					2, {IFSeqTmBass.st10(2);~cntSeqTmBass10=0;}
				)}
			);
			},
			'/ifSeq/4/10'
		);
		~ifSeqBassBut11.free;
		~ifSeqBassBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass11 = ~cntSeqTmBass11 + 1;
				~cntSeqTmBass11.switch(
					0,{},
					1, {IFSeqTmBass.st11(1);},
					2, {IFSeqTmBass.st11(2);~cntSeqTmBass11=0;}
				)}
			);
			},
			'/ifSeq/4/11'
		);
		~ifSeqBassBut12.free;
		~ifSeqBassBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass12 = ~cntSeqTmBass12 + 1;
				~cntSeqTmBass12.switch(
					0,{},
					1, {IFSeqTmBass.st12(1);},
					2, {IFSeqTmBass.st12(2);~cntSeqTmBass12=0;}
				)}
			);
			},
			'/ifSeq/4/12'
		);
		~ifSeqBassBut13.free;
		~ifSeqBassBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass13 = ~cntSeqTmBass13 + 1;
				~cntSeqTmBass13.switch(
					0,{},
					1, {IFSeqTmBass.st13(1);},
					2, {IFSeqTmBass.st13(2);~cntSeqTmBass13=0;}
				)}
			);
			},
			'/ifSeq/4/13'
		);
		~ifSeqBassBut14.free;
		~ifSeqBassBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass14 = ~cntSeqTmBass14 + 1;
				~cntSeqTmBass14.switch(
					0,{},
					1, {IFSeqTmBass.st14(1);},
					2, {IFSeqTmBass.st14(2);~cntSeqTmBass14=0;}
				)}
			);
			},
			'/ifSeq/4/14'
		);
		~ifSeqBassBut15.free;
		~ifSeqBassBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass15 = ~cntSeqTmBass15 + 1;
				~cntSeqTmBass15.switch(
					0,{},
					1, {IFSeqTmBass.st15(1);},
					2, {IFSeqTmBass.st15(2);~cntSeqTmBass15=0;}
				)}
			);
			},
			'/ifSeq/4/15'
		);
		~ifSeqBassBut16.free;
		~ifSeqBassBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmBass16 = ~cntSeqTmBass16 + 1;
				~cntSeqTmBass16.switch(
					0,{},
					1, {IFSeqTmBass.st16(1);},
					2, {IFSeqTmBass.st16(2);~cntSeqTmBass16=0;}
				)}
			);
			},
			'/ifSeq/4/16'
		);

	}


	*st01 {|i=0|
		~seqTmBass01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass01', i);
	}
	*st02 {|i=0|
		~seqTmBass02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass02', i);
	}
	*st03 {|i=0|
		~seqTmBass03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass03', i);
	}
	*st04 {|i=0|
		~seqTmBass04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass04', i);
	}
	*st05 {|i=0|
		~seqTmBass05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass05', i);
	}
	*st06 {|i=0|
		~seqTmBass06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass06', i);
	}
	*st07 {|i=0|
		~seqTmBass07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass07', i);
	}
	*st08 {|i=0|
		~seqTmBass08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass08', i);
	}

	*st09 {|i=0|
		~seqTmBass09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass09', i);
	}
	*st10 {|i=0|
		~seqTmBass10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass10', i);
	}
	*st11 {|i=0|
		~seqTmBass11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass11', i);
	}
	*st12 {|i=0|
		~seqTmBass12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass12', i);
	}
	*st13 {|i=0|
		~seqTmBass13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass13', i);
	}
	*st14 {|i=0|
		~seqTmBass14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass14', i);
	}
	*st15 {|i=0|
		~seqTmBass15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass15', i);
	}
	*st16 {|i=0|
		~seqTmBass16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmBass16', i);
	}
	*stGrp {|i|
		IFSeqTmBass.st01(i); IFSeqTmBass.st02(i); IFSeqTmBass.st03(i); IFSeqTmBass.st04(i);
		IFSeqTmBass.st05(i); IFSeqTmBass.st06(i); IFSeqTmBass.st07(i); IFSeqTmBass.st08(i);
		IFSeqTmBass.st09(i); IFSeqTmBass.st10(i); IFSeqTmBass.st11(i); IFSeqTmBass.st12(i);
		IFSeqTmBass.st13(i); IFSeqTmBass.st14(i); IFSeqTmBass.st15(i); IFSeqTmBass.st16(i);
	}
}