IFSeqTm2Hat {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~tmMul2Hat = PatternProxy( Pseq([1], inf));
		~tmMul2HatP= Pseq([~tmMul2Hat], inf).asStream;

		~tm2Hat = PatternProxy( Pseq([1], inf));
		~tm2HatP= Pseq([~tm2Hat], inf).asStream;

		~seqTm2Hat01 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat02 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat03 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat04 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat05 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat06 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat07 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat08 = PatternProxy( Pseq([1], 1));

		~seqTm2Hat08 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat09 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat10 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat11 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat12 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat13 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat14 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat15 = PatternProxy( Pseq([1], 1));
		~seqTm2Hat16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqTmUp2Hat01=0;
		~cntSeqTmRand2Hat01=0;

		~cntSeqTm2Hat01=0;
		~cntSeqTm2Hat02=0;
		~cntSeqTm2Hat03=0;
		~cntSeqTm2Hat04=0;
		~cntSeqTm2Hat05=0;
		~cntSeqTm2Hat06=0;
		~cntSeqTm2Hat07=0;
		~cntSeqTm2Hat08=0;

		~cntSeqTm2Hat09=0;
		~cntSeqTm2Hat10=0;
		~cntSeqTm2Hat11=0;
		~cntSeqTm2Hat12=0;
		~cntSeqTm2Hat13=0;
		~cntSeqTm2Hat14=0;
		~cntSeqTm2Hat15=0;
		~cntSeqTm2Hat16=0;
	}
	*freeOn {
		~seqFree2HatBut.free;
		~seqFree2HatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqTm2Hat.stGrp(1);
				});
			},
			'/seqFree2Hat'
		);
	}
	*upOn {
		~ifSeqUp2HatBut.free;
		~ifSeqUp2HatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmUp2Hat01 = ~cntSeqTmUp2Hat01 + 1;
				~cntSeqTmUp2Hat01.switch(
					0,{},
					1,{IFSeqTm2Hat.stGrp(1);},
					2,{IFSeqTm2Hat.stGrp(2);
						~cntSeqTmUp2Hat01=0;
					}
				)}
			);
			},
			'/seqUp2Hat'
		);
	}

	*randOn {
		~ifSeqRand2HatBut.free;
		~ifSeqRand2HatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmRand2Hat01 = ~cntSeqTmRand2Hat01 + 1;
				~cntSeqTmRand2Hat01.switch(
					0,{},
					1,{
						IFSeqTm2Hat.st01([1,2].choose);
						IFSeqTm2Hat.st02([1,2].choose);
						IFSeqTm2Hat.st03([1,2].choose);
						IFSeqTm2Hat.st04([1,2].choose);
						IFSeqTm2Hat.st05([1,2].choose);
						IFSeqTm2Hat.st06([1,2].choose);
						IFSeqTm2Hat.st07([1,2].choose);
						IFSeqTm2Hat.st08([1,2].choose);

						IFSeqTm2Hat.st09([1,2].choose);
						IFSeqTm2Hat.st10([1,2].choose);
						IFSeqTm2Hat.st11([1,2].choose);
						IFSeqTm2Hat.st12([1,2].choose);
						IFSeqTm2Hat.st13([1,2].choose);
						IFSeqTm2Hat.st14([1,2].choose);
						IFSeqTm2Hat.st15([1,2].choose);
						IFSeqTm2Hat.st16([1,2].choose);
						~cntSeqTmRand2Hat01=0;
					}
				)}
			);
			},
			'/seqRand2Hat'
		);
	}


	*on { // Shift Tmocity

		IFSeqTm2Hat.randOn;
		IFSeqTm2Hat.upOn;
		IFSeqTm2Hat.freeOn;

		~ifSeq2HatBut01.free;
		~ifSeq2HatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat01 = ~cntSeqTm2Hat01 + 1;
				~cntSeqTm2Hat01.switch(
					0,{},
					1, {IFSeqTm2Hat.st01(1);},
					2, {IFSeqTm2Hat.st01(2);~cntSeqTm2Hat01=0;}
				)}
			);
			},
			'/ifSeq/3/1'
		);
		~ifSeq2HatBut02.free;
		~ifSeq2HatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat02 = ~cntSeqTm2Hat02 + 1;
				~cntSeqTm2Hat02.switch(
					0,{},
					1, {IFSeqTm2Hat.st02(1);},
					2, {IFSeqTm2Hat.st02(2);~cntSeqTm2Hat02=0;}
				)}
			);
			},
			'/ifSeq/3/2'
		);
		~ifSeq2HatBut03.free;
		~ifSeq2HatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat03 = ~cntSeqTm2Hat03 + 1;
				~cntSeqTm2Hat03.switch(
					0,{},
					1, {IFSeqTm2Hat.st03(1);},
					2, {IFSeqTm2Hat.st03(2);~cntSeqTm2Hat03=0;}
				)}
			);
			},
			'/ifSeq/3/3'
		);
		~ifSeq2HatBut04.free;
		~ifSeq2HatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat04 = ~cntSeqTm2Hat04 + 1;
				~cntSeqTm2Hat04.switch(
					0,{},
					1, {IFSeqTm2Hat.st04(1);},
					2, {IFSeqTm2Hat.st04(2);~cntSeqTm2Hat04=0;}
				)}
			);
			},
			'/ifSeq/3/4'
		);
		~ifSeq2HatBut05.free;
		~ifSeq2HatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat05 = ~cntSeqTm2Hat05 + 1;
				~cntSeqTm2Hat05.switch(
					0,{},
					1, {IFSeqTm2Hat.st05(1);},
					2, {IFSeqTm2Hat.st05(2);~cntSeqTm2Hat05=0;}
				)}
			);
			},
			'/ifSeq/3/5'
		);
		~ifSeq2HatBut06.free;
		~ifSeq2HatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat06 = ~cntSeqTm2Hat06 + 1;
				~cntSeqTm2Hat06.switch(
					0,{},
					1, {IFSeqTm2Hat.st06(1);},
					2, {IFSeqTm2Hat.st06(2);~cntSeqTm2Hat06=0;}
				)}
			);
			},
			'/ifSeq/3/6'
		);
		~ifSeq2HatBut07.free;
		~ifSeq2HatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat07 = ~cntSeqTm2Hat07 + 1;
				~cntSeqTm2Hat07.switch(
					0,{},
					1, {IFSeqTm2Hat.st07(1);},
					2, {IFSeqTm2Hat.st07(2);~cntSeqTm2Hat07=0;}
				)}
			);
			},
			'/ifSeq/3/7'
		);
		~ifSeq2HatBut08.free;
		~ifSeq2HatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat08 = ~cntSeqTm2Hat08 + 1;
				~cntSeqTm2Hat08.switch(
					0,{},
					1, {IFSeqTm2Hat.st08(1);},
					2, {IFSeqTm2Hat.st08(2);~cntSeqTm2Hat08=0;}
				)}
			);
			},
			'/ifSeq/3/8'
		);

		~ifSeq2HatBut09.free;
		~ifSeq2HatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat09 = ~cntSeqTm2Hat09 + 1;
				~cntSeqTm2Hat09.switch(
					0,{},
					1, {IFSeqTm2Hat.st09(1);},
					2, {IFSeqTm2Hat.st09(2);~cntSeqTm2Hat09=0;}
				)}
			);
			},
			'/ifSeq/3/9'
		);
		~ifSeq2HatBut10.free;
		~ifSeq2HatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat10 = ~cntSeqTm2Hat10 + 1;
				~cntSeqTm2Hat10.switch(
					0,{},
					1, {IFSeqTm2Hat.st10(1);},
					2, {IFSeqTm2Hat.st10(2);~cntSeqTm2Hat10=0;}
				)}
			);
			},
			'/ifSeq/3/10'
		);
		~ifSeq2HatBut11.free;
		~ifSeq2HatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat11 = ~cntSeqTm2Hat11 + 1;
				~cntSeqTm2Hat11.switch(
					0,{},
					1, {IFSeqTm2Hat.st11(1);},
					2, {IFSeqTm2Hat.st11(2);~cntSeqTm2Hat11=0;}
				)}
			);
			},
			'/ifSeq/3/11'
		);
		~ifSeq2HatBut12.free;
		~ifSeq2HatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat12 = ~cntSeqTm2Hat12 + 1;
				~cntSeqTm2Hat12.switch(
					0,{},
					1, {IFSeqTm2Hat.st12(1);},
					2, {IFSeqTm2Hat.st12(2);~cntSeqTm2Hat12=0;}
				)}
			);
			},
			'/ifSeq/3/12'
		);
		~ifSeq2HatBut13.free;
		~ifSeq2HatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat13 = ~cntSeqTm2Hat13 + 1;
				~cntSeqTm2Hat13.switch(
					0,{},
					1, {IFSeqTm2Hat.st13(1);},
					2, {IFSeqTm2Hat.st13(2);~cntSeqTm2Hat13=0;}
				)}
			);
			},
			'/ifSeq/3/13'
		);
		~ifSeq2HatBut14.free;
		~ifSeq2HatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat14 = ~cntSeqTm2Hat14 + 1;
				~cntSeqTm2Hat14.switch(
					0,{},
					1, {IFSeqTm2Hat.st14(1);},
					2, {IFSeqTm2Hat.st14(2);~cntSeqTm2Hat14=0;}
				)}
			);
			},
			'/ifSeq/3/14'
		);
		~ifSeq2HatBut15.free;
		~ifSeq2HatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat15 = ~cntSeqTm2Hat15 + 1;
				~cntSeqTm2Hat15.switch(
					0,{},
					1, {IFSeqTm2Hat.st15(1);},
					2, {IFSeqTm2Hat.st15(2);~cntSeqTm2Hat15=0;}
				)}
			);
			},
			'/ifSeq/3/15'
		);
		~ifSeq2HatBut16.free;
		~ifSeq2HatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTm2Hat16 = ~cntSeqTm2Hat16 + 1;
				~cntSeqTm2Hat16.switch(
					0,{},
					1, {IFSeqTm2Hat.st16(1);},
					2, {IFSeqTm2Hat.st16(2);~cntSeqTm2Hat16=0;}
				)}
			);
			},
			'/ifSeq/3/16'
		);

	}


	*st01 {|i=0|
		~seqTm2Hat01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat01', i);
	}
	*st02 {|i=0|
		~seqTm2Hat02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat02', i);
	}
	*st03 {|i=0|
		~seqTm2Hat03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat03', i);
	}
	*st04 {|i=0|
		~seqTm2Hat04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat04', i);
	}
	*st05 {|i=0|
		~seqTm2Hat05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat05', i);
	}
	*st06 {|i=0|
		~seqTm2Hat06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat06', i);
	}
	*st07 {|i=0|
		~seqTm2Hat07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat07', i);
	}
	*st08 {|i=0|
		~seqTm2Hat08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat08', i);
	}

	*st09 {|i=0|
		~seqTm2Hat09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat09', i);
	}
	*st10 {|i=0|
		~seqTm2Hat10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat10', i);
	}
	*st11 {|i=0|
		~seqTm2Hat11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat11', i);
	}
	*st12 {|i=0|
		~seqTm2Hat12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat12', i);
	}
	*st13 {|i=0|
		~seqTm2Hat13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat13', i);
	}
	*st14 {|i=0|
		~seqTm2Hat14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat14', i);
	}
	*st15 {|i=0|
		~seqTm2Hat15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat15', i);
	}
	*st16 {|i=0|
		~seqTm2Hat16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTm2Hat16', i);
	}
	*stGrp {|i|
		IFSeqTm2Hat.st01(i); IFSeqTm2Hat.st02(i); IFSeqTm2Hat.st03(i); IFSeqTm2Hat.st04(i);
		IFSeqTm2Hat.st05(i); IFSeqTm2Hat.st06(i); IFSeqTm2Hat.st07(i); IFSeqTm2Hat.st08(i);
		IFSeqTm2Hat.st09(i); IFSeqTm2Hat.st10(i); IFSeqTm2Hat.st11(i); IFSeqTm2Hat.st12(i);
		IFSeqTm2Hat.st13(i); IFSeqTm2Hat.st14(i); IFSeqTm2Hat.st15(i); IFSeqTm2Hat.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqTm2Hat.st01(s01); IFSeqTm2Hat.st02(s02); IFSeqTm2Hat.st03(s03); IFSeqTm2Hat.st04(s04);
		IFSeqTm2Hat.st05(s05); IFSeqTm2Hat.st06(s06); IFSeqTm2Hat.st07(s07); IFSeqTm2Hat.st08(s08);
		IFSeqTm2Hat.st09(s09); IFSeqTm2Hat.st10(s10); IFSeqTm2Hat.st11(s11); IFSeqTm2Hat.st12(s12);
		IFSeqTm2Hat.st13(s13); IFSeqTm2Hat.st14(s14); IFSeqTm2Hat.st15(s15); IFSeqTm2Hat.st16(s16);
	}
}