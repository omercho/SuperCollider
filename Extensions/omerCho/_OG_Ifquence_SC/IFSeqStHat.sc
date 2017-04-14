IFSeqStHat {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqStHat01 = PatternProxy( Pseq([0], 1));
		~seqStHat02 = PatternProxy( Pseq([0], 1));
		~seqStHat03 = PatternProxy( Pseq([0], 1));
		~seqStHat04 = PatternProxy( Pseq([0], 1));
		~seqStHat05 = PatternProxy( Pseq([0], 1));
		~seqStHat06 = PatternProxy( Pseq([0], 1));
		~seqStHat07 = PatternProxy( Pseq([0], 1));
		~seqStHat08 = PatternProxy( Pseq([0], 1));

		~seqStHat09 = PatternProxy( Pseq([0], 1));
		~seqStHat10 = PatternProxy( Pseq([0], 1));
		~seqStHat11 = PatternProxy( Pseq([0], 1));
		~seqStHat12 = PatternProxy( Pseq([0], 1));
		~seqStHat13 = PatternProxy( Pseq([0], 1));
		~seqStHat14 = PatternProxy( Pseq([0], 1));
		~seqStHat15 = PatternProxy( Pseq([0], 1));
		~seqStHat16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqStUpHat01=0;
		~cntSeqStRandHat01=0;

		~cntSeqStHat01=0;
		~cntSeqStHat02=0;
		~cntSeqStHat03=0;
		~cntSeqStHat04=0;
		~cntSeqStHat05=0;
		~cntSeqStHat06=0;
		~cntSeqStHat07=0;
		~cntSeqStHat08=0;

		~cntSeqStHat09=0;
		~cntSeqStHat10=0;
		~cntSeqStHat11=0;
		~cntSeqStHat12=0;
		~cntSeqStHat13=0;
		~cntSeqStHat14=0;
		~cntSeqStHat15=0;
		~cntSeqStHat16=0;
	}
	*freeOn {
		~seqFreeHatBut.free;
		~seqFreeHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqStHat.stGrp(0);
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
				~cntSeqStUpHat01 = ~cntSeqStUpHat01 + 1;
				~cntSeqStUpHat01.switch(
					0,{},
					1,{IFSeqStHat.stGrp(0);},
					2,{IFSeqStHat.stGrp(1);},
					3,{IFSeqStHat.stGrp(2);},
					4,{IFSeqStHat.stGrp(3);},
					5,{IFSeqStHat.stGrp(4);},
					6,{IFSeqStHat.stGrp(5);},
					7,{IFSeqStHat.stGrp(6);},
					8,{IFSeqStHat.stGrp(7);
						~cntSeqStUpHat01=0;
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
				~cntSeqStRandHat01 = ~cntSeqStRandHat01 + 1;
				~cntSeqStRandHat01.switch(
					0,{},
					1,{
						IFSeqStHat.st01([0,1].choose);
						IFSeqStHat.st02([0,1].choose);
						IFSeqStHat.st03([0,1].choose);
						IFSeqStHat.st04([0,1].choose);
						IFSeqStHat.st05([0,1].choose);
						IFSeqStHat.st06([0,1].choose);
						IFSeqStHat.st07([0,1].choose);
						IFSeqStHat.st08([0,1].choose);

						IFSeqStHat.st09([0,1].choose);
						IFSeqStHat.st10([0,1].choose);
						IFSeqStHat.st11([0,1].choose);
						IFSeqStHat.st12([0,1].choose);
						IFSeqStHat.st13([0,1].choose);
						IFSeqStHat.st14([0,1].choose);
						IFSeqStHat.st15([0,1].choose);
						IFSeqStHat.st16([0,1].choose);
						~cntSeqStRandHat01=0;
					}
				)}
			);
			},
			'/seqRandHat'
		);
	}

	*on { // Shift StAVE
		IFSeqStHat.randOn;
		IFSeqStHat.upOn;
		IFSeqStHat.freeOn;

		~ifSeqHatBut01.free;
		~ifSeqHatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat01 = ~cntSeqStHat01 + 1;
				~cntSeqStHat01.switch(
					0,{},
					1, {IFSeqStHat.st01(0);},
					2, {IFSeqStHat.st01(1);
						~cntSeqStHat01=0;
					}
				)}
			);
			},
			'/ifSeq/3/1'
		);
		~ifSeqHatBut02.free;
		~ifSeqHatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat02 = ~cntSeqStHat02 + 1;
				~cntSeqStHat02.switch(
					0,{},
					1, {IFSeqStHat.st02(0);},
					2, {IFSeqStHat.st02(1);
						~cntSeqStHat02=0;
					}
				)}
			);
			},
			'/ifSeq/3/2'
		);
		~ifSeqHatBut03.free;
		~ifSeqHatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat03 = ~cntSeqStHat03 + 1;
				~cntSeqStHat03.switch(
					0,{},
					1, {IFSeqStHat.st03(0);},
					2, {IFSeqStHat.st03(1);
						~cntSeqStHat03=0;
					}
				)}
			);
			},
			'/ifSeq/3/3'
		);
		~ifSeqHatBut04.free;
		~ifSeqHatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat04 = ~cntSeqStHat04 + 1;
				~cntSeqStHat04.switch(
					0,{},
					1, {IFSeqStHat.st04(0);},
					2, {IFSeqStHat.st04(1);
						~cntSeqStHat04=0;
					}
				)}
			);
			},
			'/ifSeq/3/4'
		);
		~ifSeqHatBut05.free;
		~ifSeqHatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat05 = ~cntSeqStHat05 + 1;
				~cntSeqStHat05.switch(
					0,{},
					1, {IFSeqStHat.st05(0);},
					2, {IFSeqStHat.st05(1);
						~cntSeqStHat05=0;
					}
				)}
			);
			},
			'/ifSeq/3/5'
		);
		~ifSeqHatBut06.free;
		~ifSeqHatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat06 = ~cntSeqStHat06 + 1;
				~cntSeqStHat06.switch(
					0,{},
					1, {IFSeqStHat.st06(0);},
					2, {IFSeqStHat.st06(1);
						~cntSeqStHat06=0;
					}
				)}
			);
			},
			'/ifSeq/3/6'
		);
		~ifSeqHatBut07.free;
		~ifSeqHatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat07 = ~cntSeqStHat07 + 1;
				~cntSeqStHat07.switch(
					0,{},
					1, {IFSeqStHat.st07(0);},
					2, {IFSeqStHat.st07(1);
						~cntSeqStHat07=0;
					}
				)}
			);
			},
			'/ifSeq/3/7'
		);
		~ifSeqHatBut08.free;
		~ifSeqHatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat08 = ~cntSeqStHat08 + 1;
				~cntSeqStHat08.switch(
					0,{},
					1, {IFSeqStHat.st08(0);},
					2, {IFSeqStHat.st08(1);
						~cntSeqStHat08=0;
					}
				)}
			);
			},
			'/ifSeq/3/8'
		);
		~ifSeqHatBut09.free;
		~ifSeqHatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat09 = ~cntSeqStHat09 + 1;
				~cntSeqStHat09.switch(
					0,{},
					1, {IFSeqStHat.st09(0);},
					2, {IFSeqStHat.st09(1);
						~cntSeqStHat09=0;
					}
				)}
			);
			},
			'/ifSeq/3/9'
		);
		~ifSeqHatBut10.free;
		~ifSeqHatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat10 = ~cntSeqStHat10 + 1;
				~cntSeqStHat10.switch(
					0,{},
					1, {IFSeqStHat.st10(0);},
					2, {IFSeqStHat.st10(1);
						~cntSeqStHat10=0;
					}
				)}
			);
			},
			'/ifSeq/3/10'
		);
		~ifSeqHatBut11.free;
		~ifSeqHatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat11 = ~cntSeqStHat11 + 1;
				~cntSeqStHat11.switch(
					0,{},
					1, {IFSeqStHat.st11(0);},
					2, {IFSeqStHat.st11(1);
						~cntSeqStHat11=0;
					}
				)}
			);
			},
			'/ifSeq/3/11'
		);
		~ifSeqHatBut12.free;
		~ifSeqHatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat12 = ~cntSeqStHat12 + 1;
				~cntSeqStHat12.switch(
					0,{},
					1, {IFSeqStHat.st12(0);},
					2, {IFSeqStHat.st12(1);
						~cntSeqStHat12=0;
					}
				)}
			);
			},
			'/ifSeq/3/12'
		);
		~ifSeqHatBut13.free;
		~ifSeqHatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat13 = ~cntSeqStHat13 + 1;
				~cntSeqStHat13.switch(
					0,{},
					1, {IFSeqStHat.st13(0);},
					2, {IFSeqStHat.st13(1);
						~cntSeqStHat13=0;
					}
				)}
			);
			},
			'/ifSeq/3/13'
		);
		~ifSeqHatBut14.free;
		~ifSeqHatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat14 = ~cntSeqStHat14 + 1;
				~cntSeqStHat14.switch(
					0,{},
					1, {IFSeqStHat.st14(0);},
					2, {IFSeqStHat.st14(1);
						~cntSeqStHat14=0;
					}
				)}
			);
			},
			'/ifSeq/3/14'
		);
		~ifSeqHatBut15.free;
		~ifSeqHatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat15 = ~cntSeqStHat15 + 1;
				~cntSeqStHat15.switch(
					0,{},
					1, {IFSeqStHat.st15(0);},
					2, {IFSeqStHat.st15(1);
						~cntSeqStHat15=0;
					}
				)}
			);
			},
			'/ifSeq/3/15'
		);
		~ifSeqHatBut16.free;
		~ifSeqHatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStHat16 = ~cntSeqStHat16 + 1;
				~cntSeqStHat16.switch(
					0,{},
					1, {IFSeqStHat.st16(0);},
					2, {IFSeqStHat.st16(1);
						~cntSeqStHat16=0;
					}
				)}
			);
			},
			'/ifSeq/3/16'
		);

	}//

	*st01 {|i=0|
		~seqStHat01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat01', i);
	}
	*st02 {|i=0|
		~seqStHat02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat02', i);
	}
	*st03 {|i=0|
		~seqStHat03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat03', i);
	}
	*st04 {|i=0|
		~seqStHat04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat04', i);
	}
	*st05 {|i=0|
		~seqStHat05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat05', i);
	}
	*st06 {|i=0|
		~seqStHat06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat06', i);
	}
	*st07 {|i=0|
		~seqStHat07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat07', i);
	}
	*st08 {|i=0|
		~seqStHat08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat08', i);
	}
	*st09 {|i=0|
		~seqStHat09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat09', i);
	}
	*st10 {|i=0|
		~seqStHat10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat10', i);
	}
	*st11 {|i=0|
		~seqStHat11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat11', i);
	}
	*st12 {|i=0|
		~seqStHat12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat12', i);
	}
	*st13 {|i=0|
		~seqStHat13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat13', i);
	}
	*st14 {|i=0|
		~seqStHat14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat14', i);
	}
	*st15 {|i=0|
		~seqStHat15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat15', i);
	}
	*st16 {|i=0|
		~seqStHat16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStHat16', i);
	}
	*stGrp {|i|

		IFSeqStHat.st01(i); IFSeqStHat.st02(i); IFSeqStHat.st03(i); IFSeqStHat.st04(i);
		IFSeqStHat.st05(i); IFSeqStHat.st06(i); IFSeqStHat.st07(i); IFSeqStHat.st08(i);
		IFSeqStHat.st09(i); IFSeqStHat.st10(i); IFSeqStHat.st11(i); IFSeqStHat.st12(i);
		IFSeqStHat.st13(i); IFSeqStHat.st14(i); IFSeqStHat.st15(i); IFSeqStHat.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqStHat.st01(s01); IFSeqStHat.st02(s02); IFSeqStHat.st03(s03); IFSeqStHat.st04(s04);
		IFSeqStHat.st05(s05); IFSeqStHat.st06(s06); IFSeqStHat.st07(s07); IFSeqStHat.st08(s08);
		IFSeqStHat.st09(s09); IFSeqStHat.st10(s10); IFSeqStHat.st11(s11); IFSeqStHat.st12(s12);
		IFSeqStHat.st13(s13); IFSeqStHat.st14(s14); IFSeqStHat.st15(s15); IFSeqStHat.st16(s16);
	}
}