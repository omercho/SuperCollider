IFSeqTmHat {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~tmMulHat = PatternProxy( Pseq([1], inf));
		~tmMulHatP= Pseq([~tmMulHat], inf).asStream;

		~tmHat = PatternProxy( Pseq([1], inf));
		~tmHatP= Pseq([~tmHat], inf).asStream;

		~seqTmHat01 = PatternProxy( Pseq([1], 1));
		~seqTmHat02 = PatternProxy( Pseq([1], 1));
		~seqTmHat03 = PatternProxy( Pseq([1], 1));
		~seqTmHat04 = PatternProxy( Pseq([1], 1));
		~seqTmHat05 = PatternProxy( Pseq([1], 1));
		~seqTmHat06 = PatternProxy( Pseq([1], 1));
		~seqTmHat07 = PatternProxy( Pseq([1], 1));
		~seqTmHat08 = PatternProxy( Pseq([1], 1));

		~seqTmHat08 = PatternProxy( Pseq([1], 1));
		~seqTmHat09 = PatternProxy( Pseq([1], 1));
		~seqTmHat10 = PatternProxy( Pseq([1], 1));
		~seqTmHat11 = PatternProxy( Pseq([1], 1));
		~seqTmHat12 = PatternProxy( Pseq([1], 1));
		~seqTmHat13 = PatternProxy( Pseq([1], 1));
		~seqTmHat14 = PatternProxy( Pseq([1], 1));
		~seqTmHat15 = PatternProxy( Pseq([1], 1));
		~seqTmHat16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqTmUpHat01=0;
		~cntSeqTmRandHat01=0;

		~cntSeqTmHat01=0;
		~cntSeqTmHat02=0;
		~cntSeqTmHat03=0;
		~cntSeqTmHat04=0;
		~cntSeqTmHat05=0;
		~cntSeqTmHat06=0;
		~cntSeqTmHat07=0;
		~cntSeqTmHat08=0;

		~cntSeqTmHat09=0;
		~cntSeqTmHat10=0;
		~cntSeqTmHat11=0;
		~cntSeqTmHat12=0;
		~cntSeqTmHat13=0;
		~cntSeqTmHat14=0;
		~cntSeqTmHat15=0;
		~cntSeqTmHat16=0;
	}
	*freeOn {
		~seqFreeHatBut.free;
		~seqFreeHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqTmHat.stGrp(1);
				});
			},
			'/seqFreeHat'
		);
	}
	*upOn {
		~ifSeqUpHatBut.free;
		~ifSeqUpHatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmUpHat01 = ~cntSeqTmUpHat01 + 1;
				~cntSeqTmUpHat01.switch(
					0,{},
					1,{IFSeqTmHat.stGrp(1);},
					2,{IFSeqTmHat.stGrp(2);
						~cntSeqTmUpHat01=0;
					}
				)}
			);
			},
			'/seqUpHat'
		);
	}

	*randOn {
		~ifSeqRandHatBut.free;
		~ifSeqRandHatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmRandHat01 = ~cntSeqTmRandHat01 + 1;
				~cntSeqTmRandHat01.switch(
					0,{},
					1,{
						IFSeqTmHat.st01([1,2].choose);
						IFSeqTmHat.st02([1,2].choose);
						IFSeqTmHat.st03([1,2].choose);
						IFSeqTmHat.st04([1,2].choose);
						IFSeqTmHat.st05([1,2].choose);
						IFSeqTmHat.st06([1,2].choose);
						IFSeqTmHat.st07([1,2].choose);
						IFSeqTmHat.st08([1,2].choose);

						IFSeqTmHat.st09([1,2].choose);
						IFSeqTmHat.st10([1,2].choose);
						IFSeqTmHat.st11([1,2].choose);
						IFSeqTmHat.st12([1,2].choose);
						IFSeqTmHat.st13([1,2].choose);
						IFSeqTmHat.st14([1,2].choose);
						IFSeqTmHat.st15([1,2].choose);
						IFSeqTmHat.st16([1,2].choose);
						~cntSeqTmRandHat01=0;
					}
				)}
			);
			},
			'/seqRandHat'
		);
	}


	*on { // Shift Tmocity

		IFSeqTmHat.randOn;
		IFSeqTmHat.upOn;
		IFSeqTmHat.freeOn;

		~ifSeqHatBut01.free;
		~ifSeqHatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat01 = ~cntSeqTmHat01 + 1;
				~cntSeqTmHat01.switch(
					0,{},
					1, {IFSeqTmHat.st01(1);},
					2, {IFSeqTmHat.st01(2);~cntSeqTmHat01=0;}
				)}
			);
			},
			'/ifSeq/3/1'
		);
		~ifSeqHatBut02.free;
		~ifSeqHatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat02 = ~cntSeqTmHat02 + 1;
				~cntSeqTmHat02.switch(
					0,{},
					1, {IFSeqTmHat.st02(1);},
					2, {IFSeqTmHat.st02(2);~cntSeqTmHat02=0;}
				)}
			);
			},
			'/ifSeq/3/2'
		);
		~ifSeqHatBut03.free;
		~ifSeqHatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat03 = ~cntSeqTmHat03 + 1;
				~cntSeqTmHat03.switch(
					0,{},
					1, {IFSeqTmHat.st03(1);},
					2, {IFSeqTmHat.st03(2);~cntSeqTmHat03=0;}
				)}
			);
			},
			'/ifSeq/3/3'
		);
		~ifSeqHatBut04.free;
		~ifSeqHatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat04 = ~cntSeqTmHat04 + 1;
				~cntSeqTmHat04.switch(
					0,{},
					1, {IFSeqTmHat.st04(1);},
					2, {IFSeqTmHat.st04(2);~cntSeqTmHat04=0;}
				)}
			);
			},
			'/ifSeq/3/4'
		);
		~ifSeqHatBut05.free;
		~ifSeqHatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat05 = ~cntSeqTmHat05 + 1;
				~cntSeqTmHat05.switch(
					0,{},
					1, {IFSeqTmHat.st05(1);},
					2, {IFSeqTmHat.st05(2);~cntSeqTmHat05=0;}
				)}
			);
			},
			'/ifSeq/3/5'
		);
		~ifSeqHatBut06.free;
		~ifSeqHatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat06 = ~cntSeqTmHat06 + 1;
				~cntSeqTmHat06.switch(
					0,{},
					1, {IFSeqTmHat.st06(1);},
					2, {IFSeqTmHat.st06(2);~cntSeqTmHat06=0;}
				)}
			);
			},
			'/ifSeq/3/6'
		);
		~ifSeqHatBut07.free;
		~ifSeqHatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat07 = ~cntSeqTmHat07 + 1;
				~cntSeqTmHat07.switch(
					0,{},
					1, {IFSeqTmHat.st07(1);},
					2, {IFSeqTmHat.st07(2);~cntSeqTmHat07=0;}
				)}
			);
			},
			'/ifSeq/3/7'
		);
		~ifSeqHatBut08.free;
		~ifSeqHatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat08 = ~cntSeqTmHat08 + 1;
				~cntSeqTmHat08.switch(
					0,{},
					1, {IFSeqTmHat.st08(1);},
					2, {IFSeqTmHat.st08(2);~cntSeqTmHat08=0;}
				)}
			);
			},
			'/ifSeq/3/8'
		);

		~ifSeqHatBut09.free;
		~ifSeqHatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat09 = ~cntSeqTmHat09 + 1;
				~cntSeqTmHat09.switch(
					0,{},
					1, {IFSeqTmHat.st09(1);},
					2, {IFSeqTmHat.st09(2);~cntSeqTmHat09=0;}
				)}
			);
			},
			'/ifSeq/3/9'
		);
		~ifSeqHatBut10.free;
		~ifSeqHatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat10 = ~cntSeqTmHat10 + 1;
				~cntSeqTmHat10.switch(
					0,{},
					1, {IFSeqTmHat.st10(1);},
					2, {IFSeqTmHat.st10(2);~cntSeqTmHat10=0;}
				)}
			);
			},
			'/ifSeq/3/10'
		);
		~ifSeqHatBut11.free;
		~ifSeqHatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat11 = ~cntSeqTmHat11 + 1;
				~cntSeqTmHat11.switch(
					0,{},
					1, {IFSeqTmHat.st11(1);},
					2, {IFSeqTmHat.st11(2);~cntSeqTmHat11=0;}
				)}
			);
			},
			'/ifSeq/3/11'
		);
		~ifSeqHatBut12.free;
		~ifSeqHatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat12 = ~cntSeqTmHat12 + 1;
				~cntSeqTmHat12.switch(
					0,{},
					1, {IFSeqTmHat.st12(1);},
					2, {IFSeqTmHat.st12(2);~cntSeqTmHat12=0;}
				)}
			);
			},
			'/ifSeq/3/12'
		);
		~ifSeqHatBut13.free;
		~ifSeqHatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat13 = ~cntSeqTmHat13 + 1;
				~cntSeqTmHat13.switch(
					0,{},
					1, {IFSeqTmHat.st13(1);},
					2, {IFSeqTmHat.st13(2);~cntSeqTmHat13=0;}
				)}
			);
			},
			'/ifSeq/3/13'
		);
		~ifSeqHatBut14.free;
		~ifSeqHatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat14 = ~cntSeqTmHat14 + 1;
				~cntSeqTmHat14.switch(
					0,{},
					1, {IFSeqTmHat.st14(1);},
					2, {IFSeqTmHat.st14(2);~cntSeqTmHat14=0;}
				)}
			);
			},
			'/ifSeq/3/14'
		);
		~ifSeqHatBut15.free;
		~ifSeqHatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat15 = ~cntSeqTmHat15 + 1;
				~cntSeqTmHat15.switch(
					0,{},
					1, {IFSeqTmHat.st15(1);},
					2, {IFSeqTmHat.st15(2);~cntSeqTmHat15=0;}
				)}
			);
			},
			'/ifSeq/3/15'
		);
		~ifSeqHatBut16.free;
		~ifSeqHatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmHat16 = ~cntSeqTmHat16 + 1;
				~cntSeqTmHat16.switch(
					0,{},
					1, {IFSeqTmHat.st16(1);},
					2, {IFSeqTmHat.st16(2);~cntSeqTmHat16=0;}
				)}
			);
			},
			'/ifSeq/3/16'
		);

	}


	*st01 {|i=0|
		~seqTmHat01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat01', i);
	}
	*st02 {|i=0|
		~seqTmHat02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat02', i);
	}
	*st03 {|i=0|
		~seqTmHat03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat03', i);
	}
	*st04 {|i=0|
		~seqTmHat04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat04', i);
	}
	*st05 {|i=0|
		~seqTmHat05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat05', i);
	}
	*st06 {|i=0|
		~seqTmHat06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat06', i);
	}
	*st07 {|i=0|
		~seqTmHat07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat07', i);
	}
	*st08 {|i=0|
		~seqTmHat08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat08', i);
	}

	*st09 {|i=0|
		~seqTmHat09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat09', i);
	}
	*st10 {|i=0|
		~seqTmHat10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat10', i);
	}
	*st11 {|i=0|
		~seqTmHat11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat11', i);
	}
	*st12 {|i=0|
		~seqTmHat12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat12', i);
	}
	*st13 {|i=0|
		~seqTmHat13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat13', i);
	}
	*st14 {|i=0|
		~seqTmHat14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat14', i);
	}
	*st15 {|i=0|
		~seqTmHat15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat15', i);
	}
	*st16 {|i=0|
		~seqTmHat16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmHat16', i);
	}
	*stGrp {|i|
		IFSeqTmHat.st01(i); IFSeqTmHat.st02(i); IFSeqTmHat.st03(i); IFSeqTmHat.st04(i);
		IFSeqTmHat.st05(i); IFSeqTmHat.st06(i); IFSeqTmHat.st07(i); IFSeqTmHat.st08(i);
		IFSeqTmHat.st09(i); IFSeqTmHat.st10(i); IFSeqTmHat.st11(i); IFSeqTmHat.st12(i);
		IFSeqTmHat.st13(i); IFSeqTmHat.st14(i); IFSeqTmHat.st15(i); IFSeqTmHat.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqTmHat.st01(s01); IFSeqTmHat.st02(s02); IFSeqTmHat.st03(s03); IFSeqTmHat.st04(s04);
		IFSeqTmHat.st05(s05); IFSeqTmHat.st06(s06); IFSeqTmHat.st07(s07); IFSeqTmHat.st08(s08);
		IFSeqTmHat.st09(s09); IFSeqTmHat.st10(s10); IFSeqTmHat.st11(s11); IFSeqTmHat.st12(s12);
		IFSeqTmHat.st13(s13); IFSeqTmHat.st14(s14); IFSeqTmHat.st15(s15); IFSeqTmHat.st16(s16);
	}
}