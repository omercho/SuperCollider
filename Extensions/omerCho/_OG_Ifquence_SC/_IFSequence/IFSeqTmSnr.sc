IFSeqTmSnr {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~tmMulSnr = PatternProxy( Pseq([1], inf));
		~tmMulSnrP= Pseq([~tmMulSnr], inf).asStream;

		~tmSnr = PatternProxy( Pseq([1], inf));
		~tmSnrP= Pseq([~tmSnr], inf).asStream;

		~seqTmSnr01 = PatternProxy( Pseq([1], 1));
		~seqTmSnr02 = PatternProxy( Pseq([1], 1));
		~seqTmSnr03 = PatternProxy( Pseq([1], 1));
		~seqTmSnr04 = PatternProxy( Pseq([1], 1));
		~seqTmSnr05 = PatternProxy( Pseq([1], 1));
		~seqTmSnr06 = PatternProxy( Pseq([1], 1));
		~seqTmSnr07 = PatternProxy( Pseq([1], 1));
		~seqTmSnr08 = PatternProxy( Pseq([1], 1));

		~seqTmSnr08 = PatternProxy( Pseq([1], 1));
		~seqTmSnr09 = PatternProxy( Pseq([1], 1));
		~seqTmSnr10 = PatternProxy( Pseq([1], 1));
		~seqTmSnr11 = PatternProxy( Pseq([1], 1));
		~seqTmSnr12 = PatternProxy( Pseq([1], 1));
		~seqTmSnr13 = PatternProxy( Pseq([1], 1));
		~seqTmSnr14 = PatternProxy( Pseq([1], 1));
		~seqTmSnr15 = PatternProxy( Pseq([1], 1));
		~seqTmSnr16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqTmUpSnr01=0;
		~cntSeqTmRandSnr01=0;

		~cntSeqTmSnr01=0;
		~cntSeqTmSnr02=0;
		~cntSeqTmSnr03=0;
		~cntSeqTmSnr04=0;
		~cntSeqTmSnr05=0;
		~cntSeqTmSnr06=0;
		~cntSeqTmSnr07=0;
		~cntSeqTmSnr08=0;

		~cntSeqTmSnr09=0;
		~cntSeqTmSnr10=0;
		~cntSeqTmSnr11=0;
		~cntSeqTmSnr12=0;
		~cntSeqTmSnr13=0;
		~cntSeqTmSnr14=0;
		~cntSeqTmSnr15=0;
		~cntSeqTmSnr16=0;
	}
	*freeOn {
		~seqFreeSnrBut.free;
		~seqFreeSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqTmSnr.stGrp(1);
				});
			},
			'/seqFreeSnr'
		);
	}
	*upOn {
		~ifSeqUpSnrBut.free;
		~ifSeqUpSnrBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmUpSnr01 = ~cntSeqTmUpSnr01 + 1;
				~cntSeqTmUpSnr01.switch(
					0,{},
					1,{IFSeqTmSnr.stGrp(1);},
					2,{IFSeqTmSnr.stGrp(2);
						~cntSeqTmUpSnr01=0;
					}
				)}
			);
			},
			'/seqUpSnr'
		);
	}

	*randOn {
		~ifSeqRandSnrBut.free;
		~ifSeqRandSnrBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmRandSnr01 = ~cntSeqTmRandSnr01 + 1;
				~cntSeqTmRandSnr01.switch(
					0,{},
					1,{
						IFSeqTmSnr.st01([1,2].choose);
						IFSeqTmSnr.st02([1,2].choose);
						IFSeqTmSnr.st03([1,2].choose);
						IFSeqTmSnr.st04([1,2].choose);
						IFSeqTmSnr.st05([1,2].choose);
						IFSeqTmSnr.st06([1,2].choose);
						IFSeqTmSnr.st07([1,2].choose);
						IFSeqTmSnr.st08([1,2].choose);

						IFSeqTmSnr.st09([1,2].choose);
						IFSeqTmSnr.st10([1,2].choose);
						IFSeqTmSnr.st11([1,2].choose);
						IFSeqTmSnr.st12([1,2].choose);
						IFSeqTmSnr.st13([1,2].choose);
						IFSeqTmSnr.st14([1,2].choose);
						IFSeqTmSnr.st15([1,2].choose);
						IFSeqTmSnr.st16([1,2].choose);
						~cntSeqTmRandSnr01=0;
					}
				)}
			);
			},
			'/seqRandSnr'
		);
	}


	*on { // Shift Tmocity

		IFSeqTmSnr.randOn;
		IFSeqTmSnr.upOn;
		IFSeqTmSnr.freeOn;

		~ifSeqSnrBut01.free;
		~ifSeqSnrBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr01 = ~cntSeqTmSnr01 + 1;
				~cntSeqTmSnr01.switch(
					0,{},
					1, {IFSeqTmSnr.st01(1);},
					2, {IFSeqTmSnr.st01(2);~cntSeqTmSnr01=0;}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqSnrBut02.free;
		~ifSeqSnrBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr02 = ~cntSeqTmSnr02 + 1;
				~cntSeqTmSnr02.switch(
					0,{},
					1, {IFSeqTmSnr.st02(1);},
					2, {IFSeqTmSnr.st02(2);~cntSeqTmSnr02=0;}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqSnrBut03.free;
		~ifSeqSnrBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr03 = ~cntSeqTmSnr03 + 1;
				~cntSeqTmSnr03.switch(
					0,{},
					1, {IFSeqTmSnr.st03(1);},
					2, {IFSeqTmSnr.st03(2);~cntSeqTmSnr03=0;}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqSnrBut04.free;
		~ifSeqSnrBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr04 = ~cntSeqTmSnr04 + 1;
				~cntSeqTmSnr04.switch(
					0,{},
					1, {IFSeqTmSnr.st04(1);},
					2, {IFSeqTmSnr.st04(2);~cntSeqTmSnr04=0;}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqSnrBut05.free;
		~ifSeqSnrBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr05 = ~cntSeqTmSnr05 + 1;
				~cntSeqTmSnr05.switch(
					0,{},
					1, {IFSeqTmSnr.st05(1);},
					2, {IFSeqTmSnr.st05(2);~cntSeqTmSnr05=0;}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqSnrBut06.free;
		~ifSeqSnrBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr06 = ~cntSeqTmSnr06 + 1;
				~cntSeqTmSnr06.switch(
					0,{},
					1, {IFSeqTmSnr.st06(1);},
					2, {IFSeqTmSnr.st06(2);~cntSeqTmSnr06=0;}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqSnrBut07.free;
		~ifSeqSnrBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr07 = ~cntSeqTmSnr07 + 1;
				~cntSeqTmSnr07.switch(
					0,{},
					1, {IFSeqTmSnr.st07(1);},
					2, {IFSeqTmSnr.st07(2);~cntSeqTmSnr07=0;}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqSnrBut08.free;
		~ifSeqSnrBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr08 = ~cntSeqTmSnr08 + 1;
				~cntSeqTmSnr08.switch(
					0,{},
					1, {IFSeqTmSnr.st08(1);},
					2, {IFSeqTmSnr.st08(2);~cntSeqTmSnr08=0;}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqSnrBut09.free;
		~ifSeqSnrBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr09 = ~cntSeqTmSnr09 + 1;
				~cntSeqTmSnr09.switch(
					0,{},
					1, {IFSeqTmSnr.st09(1);},
					2, {IFSeqTmSnr.st09(2);~cntSeqTmSnr09=0;}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqSnrBut10.free;
		~ifSeqSnrBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr10 = ~cntSeqTmSnr10 + 1;
				~cntSeqTmSnr10.switch(
					0,{},
					1, {IFSeqTmSnr.st10(1);},
					2, {IFSeqTmSnr.st10(2);~cntSeqTmSnr10=0;}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqSnrBut11.free;
		~ifSeqSnrBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr11 = ~cntSeqTmSnr11 + 1;
				~cntSeqTmSnr11.switch(
					0,{},
					1, {IFSeqTmSnr.st11(1);},
					2, {IFSeqTmSnr.st11(2);~cntSeqTmSnr11=0;}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqSnrBut12.free;
		~ifSeqSnrBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr12 = ~cntSeqTmSnr12 + 1;
				~cntSeqTmSnr12.switch(
					0,{},
					1, {IFSeqTmSnr.st12(1);},
					2, {IFSeqTmSnr.st12(2);~cntSeqTmSnr12=0;}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqSnrBut13.free;
		~ifSeqSnrBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr13 = ~cntSeqTmSnr13 + 1;
				~cntSeqTmSnr13.switch(
					0,{},
					1, {IFSeqTmSnr.st13(1);},
					2, {IFSeqTmSnr.st13(2);~cntSeqTmSnr13=0;}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqSnrBut14.free;
		~ifSeqSnrBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr14 = ~cntSeqTmSnr14 + 1;
				~cntSeqTmSnr14.switch(
					0,{},
					1, {IFSeqTmSnr.st14(1);},
					2, {IFSeqTmSnr.st14(2);~cntSeqTmSnr14=0;}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqSnrBut15.free;
		~ifSeqSnrBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr15 = ~cntSeqTmSnr15 + 1;
				~cntSeqTmSnr15.switch(
					0,{},
					1, {IFSeqTmSnr.st15(1);},
					2, {IFSeqTmSnr.st15(2);~cntSeqTmSnr15=0;}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqSnrBut16.free;
		~ifSeqSnrBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSnr16 = ~cntSeqTmSnr16 + 1;
				~cntSeqTmSnr16.switch(
					0,{},
					1, {IFSeqTmSnr.st16(1);},
					2, {IFSeqTmSnr.st16(2);~cntSeqTmSnr16=0;}
				)}
			);
			},
			'/ifSeq/2/16'
		);

	}


	*st01 {|i=0|
		~seqTmSnr01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr01', i);
	}
	*st02 {|i=0|
		~seqTmSnr02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr02', i);
	}
	*st03 {|i=0|
		~seqTmSnr03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr03', i);
	}
	*st04 {|i=0|
		~seqTmSnr04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr04', i);
	}
	*st05 {|i=0|
		~seqTmSnr05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr05', i);
	}
	*st06 {|i=0|
		~seqTmSnr06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr06', i);
	}
	*st07 {|i=0|
		~seqTmSnr07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr07', i);
	}
	*st08 {|i=0|
		~seqTmSnr08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr08', i);
	}

	*st09 {|i=0|
		~seqTmSnr09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr09', i);
	}
	*st10 {|i=0|
		~seqTmSnr10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr10', i);
	}
	*st11 {|i=0|
		~seqTmSnr11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr11', i);
	}
	*st12 {|i=0|
		~seqTmSnr12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr12', i);
	}
	*st13 {|i=0|
		~seqTmSnr13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr13', i);
	}
	*st14 {|i=0|
		~seqTmSnr14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr14', i);
	}
	*st15 {|i=0|
		~seqTmSnr15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr15', i);
	}
	*st16 {|i=0|
		~seqTmSnr16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSnr16', i);
	}
	*stGrp {|i|
		IFSeqTmSnr.st01(i); IFSeqTmSnr.st02(i); IFSeqTmSnr.st03(i); IFSeqTmSnr.st04(i);
		IFSeqTmSnr.st05(i); IFSeqTmSnr.st06(i); IFSeqTmSnr.st07(i); IFSeqTmSnr.st08(i);
		IFSeqTmSnr.st09(i); IFSeqTmSnr.st10(i); IFSeqTmSnr.st11(i); IFSeqTmSnr.st12(i);
		IFSeqTmSnr.st13(i); IFSeqTmSnr.st14(i); IFSeqTmSnr.st15(i); IFSeqTmSnr.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqTmSnr.st01(s01); IFSeqTmSnr.st02(s02); IFSeqTmSnr.st03(s03); IFSeqTmSnr.st04(s04);
		IFSeqTmSnr.st05(s05); IFSeqTmSnr.st06(s06); IFSeqTmSnr.st07(s07); IFSeqTmSnr.st08(s08);
		IFSeqTmSnr.st09(s09); IFSeqTmSnr.st10(s10); IFSeqTmSnr.st11(s11); IFSeqTmSnr.st12(s12);
		IFSeqTmSnr.st13(s13); IFSeqTmSnr.st14(s14); IFSeqTmSnr.st15(s15); IFSeqTmSnr.st16(s16);
	}
}