IFSeqTmMopho {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~tmMulMopho = PatternProxy( Pseq([1], inf));
		~tmMulMophoP= Pseq([~tmMulMopho], inf).asStream;

		~tmMopho = PatternProxy( Pseq([1], inf));
		~tmMophoP= Pseq([~tmMopho], inf).asStream;

		~seqTmMopho01 = PatternProxy( Pseq([1], 1));
		~seqTmMopho02 = PatternProxy( Pseq([1], 1));
		~seqTmMopho03 = PatternProxy( Pseq([1], 1));
		~seqTmMopho04 = PatternProxy( Pseq([1], 1));
		~seqTmMopho05 = PatternProxy( Pseq([1], 1));
		~seqTmMopho06 = PatternProxy( Pseq([1], 1));
		~seqTmMopho07 = PatternProxy( Pseq([1], 1));
		~seqTmMopho08 = PatternProxy( Pseq([1], 1));

		~seqTmMopho08 = PatternProxy( Pseq([1], 1));
		~seqTmMopho09 = PatternProxy( Pseq([1], 1));
		~seqTmMopho10 = PatternProxy( Pseq([1], 1));
		~seqTmMopho11 = PatternProxy( Pseq([1], 1));
		~seqTmMopho12 = PatternProxy( Pseq([1], 1));
		~seqTmMopho13 = PatternProxy( Pseq([1], 1));
		~seqTmMopho14 = PatternProxy( Pseq([1], 1));
		~seqTmMopho15 = PatternProxy( Pseq([1], 1));
		~seqTmMopho16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqTmUpMopho01=0;
		~cntSeqTmRandMopho01=0;

		~cntSeqTmMopho01=0;
		~cntSeqTmMopho02=0;
		~cntSeqTmMopho03=0;
		~cntSeqTmMopho04=0;
		~cntSeqTmMopho05=0;
		~cntSeqTmMopho06=0;
		~cntSeqTmMopho07=0;
		~cntSeqTmMopho08=0;

		~cntSeqTmMopho09=0;
		~cntSeqTmMopho10=0;
		~cntSeqTmMopho11=0;
		~cntSeqTmMopho12=0;
		~cntSeqTmMopho13=0;
		~cntSeqTmMopho14=0;
		~cntSeqTmMopho15=0;
		~cntSeqTmMopho16=0;
	}
	*freeOn {
		~seqFreeMophoBut.free;
		~seqFreeMophoBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqTmMopho.stGrp(1);
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
				~cntSeqTmUpMopho01 = ~cntSeqTmUpMopho01 + 1;
				~cntSeqTmUpMopho01.switch(
					0,{},
					1,{IFSeqTmMopho.stGrp(1);},
					2,{IFSeqTmMopho.stGrp(2);
						~cntSeqTmUpMopho01=0;
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
				~cntSeqTmRandMopho01 = ~cntSeqTmRandMopho01 + 1;
				~cntSeqTmRandMopho01.switch(
					0,{},
					1,{
						IFSeqTmMopho.st01([1,2].choose);
						IFSeqTmMopho.st02([1,2].choose);
						IFSeqTmMopho.st03([1,2].choose);
						IFSeqTmMopho.st04([1,2].choose);
						IFSeqTmMopho.st05([1,2].choose);
						IFSeqTmMopho.st06([1,2].choose);
						IFSeqTmMopho.st07([1,2].choose);
						IFSeqTmMopho.st08([1,2].choose);

						IFSeqTmMopho.st09([1,2].choose);
						IFSeqTmMopho.st10([1,2].choose);
						IFSeqTmMopho.st11([1,2].choose);
						IFSeqTmMopho.st12([1,2].choose);
						IFSeqTmMopho.st13([1,2].choose);
						IFSeqTmMopho.st14([1,2].choose);
						IFSeqTmMopho.st15([1,2].choose);
						IFSeqTmMopho.st16([1,2].choose);
						~cntSeqTmRandMopho01=0;
					}
				)}
			);
			},
			'/seqRandMopho'
		);
	}


	*on { // Shift Tmocity

		IFSeqTmMopho.randOn;
		IFSeqTmMopho.upOn;
		IFSeqTmMopho.freeOn;

		~ifSeqMophoBut01.free;
		~ifSeqMophoBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho01 = ~cntSeqTmMopho01 + 1;
				~cntSeqTmMopho01.switch(
					0,{},
					1, {IFSeqTmMopho.st01(1);},
					2, {IFSeqTmMopho.st01(2);~cntSeqTmMopho01=0;}
				)}
			);
			},
			'/ifSeq/6/1'
		);
		~ifSeqMophoBut02.free;
		~ifSeqMophoBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho02 = ~cntSeqTmMopho02 + 1;
				~cntSeqTmMopho02.switch(
					0,{},
					1, {IFSeqTmMopho.st02(1);},
					2, {IFSeqTmMopho.st02(2);~cntSeqTmMopho02=0;}
				)}
			);
			},
			'/ifSeq/6/2'
		);
		~ifSeqMophoBut03.free;
		~ifSeqMophoBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho03 = ~cntSeqTmMopho03 + 1;
				~cntSeqTmMopho03.switch(
					0,{},
					1, {IFSeqTmMopho.st03(1);},
					2, {IFSeqTmMopho.st03(2);~cntSeqTmMopho03=0;}
				)}
			);
			},
			'/ifSeq/6/3'
		);
		~ifSeqMophoBut04.free;
		~ifSeqMophoBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho04 = ~cntSeqTmMopho04 + 1;
				~cntSeqTmMopho04.switch(
					0,{},
					1, {IFSeqTmMopho.st04(1);},
					2, {IFSeqTmMopho.st04(2);~cntSeqTmMopho04=0;}
				)}
			);
			},
			'/ifSeq/6/4'
		);
		~ifSeqMophoBut05.free;
		~ifSeqMophoBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho05 = ~cntSeqTmMopho05 + 1;
				~cntSeqTmMopho05.switch(
					0,{},
					1, {IFSeqTmMopho.st05(1);},
					2, {IFSeqTmMopho.st05(2);~cntSeqTmMopho05=0;}
				)}
			);
			},
			'/ifSeq/6/5'
		);
		~ifSeqMophoBut06.free;
		~ifSeqMophoBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho06 = ~cntSeqTmMopho06 + 1;
				~cntSeqTmMopho06.switch(
					0,{},
					1, {IFSeqTmMopho.st06(1);},
					2, {IFSeqTmMopho.st06(2);~cntSeqTmMopho06=0;}
				)}
			);
			},
			'/ifSeq/6/6'
		);
		~ifSeqMophoBut07.free;
		~ifSeqMophoBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho07 = ~cntSeqTmMopho07 + 1;
				~cntSeqTmMopho07.switch(
					0,{},
					1, {IFSeqTmMopho.st07(1);},
					2, {IFSeqTmMopho.st07(2);~cntSeqTmMopho07=0;}
				)}
			);
			},
			'/ifSeq/6/7'
		);
		~ifSeqMophoBut08.free;
		~ifSeqMophoBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho08 = ~cntSeqTmMopho08 + 1;
				~cntSeqTmMopho08.switch(
					0,{},
					1, {IFSeqTmMopho.st08(1);},
					2, {IFSeqTmMopho.st08(2);~cntSeqTmMopho08=0;}
				)}
			);
			},
			'/ifSeq/6/8'
		);

		~ifSeqMophoBut09.free;
		~ifSeqMophoBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho09 = ~cntSeqTmMopho09 + 1;
				~cntSeqTmMopho09.switch(
					0,{},
					1, {IFSeqTmMopho.st09(1);},
					2, {IFSeqTmMopho.st09(2);~cntSeqTmMopho09=0;}
				)}
			);
			},
			'/ifSeq/6/9'
		);
		~ifSeqMophoBut10.free;
		~ifSeqMophoBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho10 = ~cntSeqTmMopho10 + 1;
				~cntSeqTmMopho10.switch(
					0,{},
					1, {IFSeqTmMopho.st10(1);},
					2, {IFSeqTmMopho.st10(2);~cntSeqTmMopho10=0;}
				)}
			);
			},
			'/ifSeq/6/10'
		);
		~ifSeqMophoBut11.free;
		~ifSeqMophoBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho11 = ~cntSeqTmMopho11 + 1;
				~cntSeqTmMopho11.switch(
					0,{},
					1, {IFSeqTmMopho.st11(1);},
					2, {IFSeqTmMopho.st11(2);~cntSeqTmMopho11=0;}
				)}
			);
			},
			'/ifSeq/6/11'
		);
		~ifSeqMophoBut12.free;
		~ifSeqMophoBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho12 = ~cntSeqTmMopho12 + 1;
				~cntSeqTmMopho12.switch(
					0,{},
					1, {IFSeqTmMopho.st12(1);},
					2, {IFSeqTmMopho.st12(2);~cntSeqTmMopho12=0;}
				)}
			);
			},
			'/ifSeq/6/12'
		);
		~ifSeqMophoBut13.free;
		~ifSeqMophoBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho13 = ~cntSeqTmMopho13 + 1;
				~cntSeqTmMopho13.switch(
					0,{},
					1, {IFSeqTmMopho.st13(1);},
					2, {IFSeqTmMopho.st13(2);~cntSeqTmMopho13=0;}
				)}
			);
			},
			'/ifSeq/6/13'
		);
		~ifSeqMophoBut14.free;
		~ifSeqMophoBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho14 = ~cntSeqTmMopho14 + 1;
				~cntSeqTmMopho14.switch(
					0,{},
					1, {IFSeqTmMopho.st14(1);},
					2, {IFSeqTmMopho.st14(2);~cntSeqTmMopho14=0;}
				)}
			);
			},
			'/ifSeq/6/14'
		);
		~ifSeqMophoBut15.free;
		~ifSeqMophoBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho15 = ~cntSeqTmMopho15 + 1;
				~cntSeqTmMopho15.switch(
					0,{},
					1, {IFSeqTmMopho.st15(1);},
					2, {IFSeqTmMopho.st15(2);~cntSeqTmMopho15=0;}
				)}
			);
			},
			'/ifSeq/6/15'
		);
		~ifSeqMophoBut16.free;
		~ifSeqMophoBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmMopho16 = ~cntSeqTmMopho16 + 1;
				~cntSeqTmMopho16.switch(
					0,{},
					1, {IFSeqTmMopho.st16(1);},
					2, {IFSeqTmMopho.st16(2);~cntSeqTmMopho16=0;}
				)}
			);
			},
			'/ifSeq/6/16'
		);

	}


	*st01 {|i=0|
		~seqTmMopho01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho01', i);
	}
	*st02 {|i=0|
		~seqTmMopho02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho02', i);
	}
	*st03 {|i=0|
		~seqTmMopho03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho03', i);
	}
	*st04 {|i=0|
		~seqTmMopho04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho04', i);
	}
	*st05 {|i=0|
		~seqTmMopho05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho05', i);
	}
	*st06 {|i=0|
		~seqTmMopho06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho06', i);
	}
	*st07 {|i=0|
		~seqTmMopho07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho07', i);
	}
	*st08 {|i=0|
		~seqTmMopho08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho08', i);
	}

	*st09 {|i=0|
		~seqTmMopho09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho09', i);
	}
	*st10 {|i=0|
		~seqTmMopho10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho10', i);
	}
	*st11 {|i=0|
		~seqTmMopho11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho11', i);
	}
	*st12 {|i=0|
		~seqTmMopho12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho12', i);
	}
	*st13 {|i=0|
		~seqTmMopho13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho13', i);
	}
	*st14 {|i=0|
		~seqTmMopho14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho14', i);
	}
	*st15 {|i=0|
		~seqTmMopho15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho15', i);
	}
	*st16 {|i=0|
		~seqTmMopho16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmMopho16', i);
	}
	*stGrp {|i|
		IFSeqTmMopho.st01(i); IFSeqTmMopho.st02(i); IFSeqTmMopho.st03(i); IFSeqTmMopho.st04(i);
		IFSeqTmMopho.st05(i); IFSeqTmMopho.st06(i); IFSeqTmMopho.st07(i); IFSeqTmMopho.st08(i);
		IFSeqTmMopho.st09(i); IFSeqTmMopho.st10(i); IFSeqTmMopho.st11(i); IFSeqTmMopho.st12(i);
		IFSeqTmMopho.st13(i); IFSeqTmMopho.st14(i); IFSeqTmMopho.st15(i); IFSeqTmMopho.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqTmMopho.st01(s01); IFSeqTmMopho.st02(s02); IFSeqTmMopho.st03(s03); IFSeqTmMopho.st04(s04);
		IFSeqTmMopho.st05(s05); IFSeqTmMopho.st06(s06); IFSeqTmMopho.st07(s07); IFSeqTmMopho.st08(s08);
		IFSeqTmMopho.st09(s09); IFSeqTmMopho.st10(s10); IFSeqTmMopho.st11(s11); IFSeqTmMopho.st12(s12);
		IFSeqTmMopho.st13(s13); IFSeqTmMopho.st14(s14); IFSeqTmMopho.st15(s15); IFSeqTmMopho.st16(s16);
	}
}