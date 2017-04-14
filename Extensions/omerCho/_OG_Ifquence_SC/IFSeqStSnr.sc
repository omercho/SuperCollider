IFSeqStSnr {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqStSnr01 = PatternProxy( Pseq([0], 1));
		~seqStSnr02 = PatternProxy( Pseq([0], 1));
		~seqStSnr03 = PatternProxy( Pseq([0], 1));
		~seqStSnr04 = PatternProxy( Pseq([0], 1));
		~seqStSnr05 = PatternProxy( Pseq([0], 1));
		~seqStSnr06 = PatternProxy( Pseq([0], 1));
		~seqStSnr07 = PatternProxy( Pseq([0], 1));
		~seqStSnr08 = PatternProxy( Pseq([0], 1));

		~seqStSnr09 = PatternProxy( Pseq([0], 1));
		~seqStSnr10 = PatternProxy( Pseq([0], 1));
		~seqStSnr11 = PatternProxy( Pseq([0], 1));
		~seqStSnr12 = PatternProxy( Pseq([0], 1));
		~seqStSnr13 = PatternProxy( Pseq([0], 1));
		~seqStSnr14 = PatternProxy( Pseq([0], 1));
		~seqStSnr15 = PatternProxy( Pseq([0], 1));
		~seqStSnr16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqStUpSnr01=0;
		~cntSeqStRandSnr01=0;

		~cntSeqStSnr01=0;
		~cntSeqStSnr02=0;
		~cntSeqStSnr03=0;
		~cntSeqStSnr04=0;
		~cntSeqStSnr05=0;
		~cntSeqStSnr06=0;
		~cntSeqStSnr07=0;
		~cntSeqStSnr08=0;

		~cntSeqStSnr09=0;
		~cntSeqStSnr10=0;
		~cntSeqStSnr11=0;
		~cntSeqStSnr12=0;
		~cntSeqStSnr13=0;
		~cntSeqStSnr14=0;
		~cntSeqStSnr15=0;
		~cntSeqStSnr16=0;
	}
	*freeOn {
		~seqFreeSnrBut.free;
		~seqFreeSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqStSnr.stGrp(0);
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
				~cntSeqStUpSnr01 = ~cntSeqStUpSnr01 + 1;
				~cntSeqStUpSnr01.switch(
					0,{},
					1,{IFSeqStSnr.stGrp(0);},
					2,{IFSeqStSnr.stGrp(1);},
					3,{IFSeqStSnr.stGrp(2);},
					4,{IFSeqStSnr.stGrp(3);},
					5,{IFSeqStSnr.stGrp(4);},
					6,{IFSeqStSnr.stGrp(5);},
					7,{IFSeqStSnr.stGrp(6);},
					8,{IFSeqStSnr.stGrp(7);
						~cntSeqStUpSnr01=0;
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
				~cntSeqStRandSnr01 = ~cntSeqStRandSnr01 + 1;
				~cntSeqStRandSnr01.switch(
					0,{},
					1,{
						IFSeqStSnr.st01([0,1].choose);
						IFSeqStSnr.st02([0,1].choose);
						IFSeqStSnr.st03([0,1].choose);
						IFSeqStSnr.st04([0,1].choose);
						IFSeqStSnr.st05([0,1].choose);
						IFSeqStSnr.st06([0,1].choose);
						IFSeqStSnr.st07([0,1].choose);
						IFSeqStSnr.st08([0,1].choose);

						IFSeqStSnr.st09([0,1].choose);
						IFSeqStSnr.st10([0,1].choose);
						IFSeqStSnr.st11([0,1].choose);
						IFSeqStSnr.st12([0,1].choose);
						IFSeqStSnr.st13([0,1].choose);
						IFSeqStSnr.st14([0,1].choose);
						IFSeqStSnr.st15([0,1].choose);
						IFSeqStSnr.st16([0,1].choose);
						~cntSeqStRandSnr01=0;
					}
				)}
			);
			},
			'/seqRandSnr'
		);
	}

	*on { // Shift StAVE
		IFSeqStSnr.randOn;
		IFSeqStSnr.upOn;
		IFSeqStSnr.freeOn;

		~ifSeqSnrBut01.free;
		~ifSeqSnrBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr01 = ~cntSeqStSnr01 + 1;
				~cntSeqStSnr01.switch(
					0,{},
					1, {IFSeqStSnr.st01(0);},
					2, {IFSeqStSnr.st01(1);
						~cntSeqStSnr01=0;
					}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqSnrBut02.free;
		~ifSeqSnrBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr02 = ~cntSeqStSnr02 + 1;
				~cntSeqStSnr02.switch(
					0,{},
					1, {IFSeqStSnr.st02(0);},
					2, {IFSeqStSnr.st02(1);
						~cntSeqStSnr02=0;
					}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqSnrBut03.free;
		~ifSeqSnrBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr03 = ~cntSeqStSnr03 + 1;
				~cntSeqStSnr03.switch(
					0,{},
					1, {IFSeqStSnr.st03(0);},
					2, {IFSeqStSnr.st03(1);
						~cntSeqStSnr03=0;
					}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqSnrBut04.free;
		~ifSeqSnrBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr04 = ~cntSeqStSnr04 + 1;
				~cntSeqStSnr04.switch(
					0,{},
					1, {IFSeqStSnr.st04(0);},
					2, {IFSeqStSnr.st04(1);
						~cntSeqStSnr04=0;
					}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqSnrBut05.free;
		~ifSeqSnrBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr05 = ~cntSeqStSnr05 + 1;
				~cntSeqStSnr05.switch(
					0,{},
					1, {IFSeqStSnr.st05(0);},
					2, {IFSeqStSnr.st05(1);
						~cntSeqStSnr05=0;
					}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqSnrBut06.free;
		~ifSeqSnrBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr06 = ~cntSeqStSnr06 + 1;
				~cntSeqStSnr06.switch(
					0,{},
					1, {IFSeqStSnr.st06(0);},
					2, {IFSeqStSnr.st06(1);
						~cntSeqStSnr06=0;
					}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqSnrBut07.free;
		~ifSeqSnrBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr07 = ~cntSeqStSnr07 + 1;
				~cntSeqStSnr07.switch(
					0,{},
					1, {IFSeqStSnr.st07(0);},
					2, {IFSeqStSnr.st07(1);
						~cntSeqStSnr07=0;
					}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqSnrBut08.free;
		~ifSeqSnrBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr08 = ~cntSeqStSnr08 + 1;
				~cntSeqStSnr08.switch(
					0,{},
					1, {IFSeqStSnr.st08(0);},
					2, {IFSeqStSnr.st08(1);
						~cntSeqStSnr08=0;
					}
				)}
			);
			},
			'/ifSeq/2/8'
		);
		~ifSeqSnrBut09.free;
		~ifSeqSnrBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr09 = ~cntSeqStSnr09 + 1;
				~cntSeqStSnr09.switch(
					0,{},
					1, {IFSeqStSnr.st09(0);},
					2, {IFSeqStSnr.st09(1);
						~cntSeqStSnr09=0;
					}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqSnrBut10.free;
		~ifSeqSnrBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr10 = ~cntSeqStSnr10 + 1;
				~cntSeqStSnr10.switch(
					0,{},
					1, {IFSeqStSnr.st10(0);},
					2, {IFSeqStSnr.st10(1);
						~cntSeqStSnr10=0;
					}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqSnrBut11.free;
		~ifSeqSnrBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr11 = ~cntSeqStSnr11 + 1;
				~cntSeqStSnr11.switch(
					0,{},
					1, {IFSeqStSnr.st11(0);},
					2, {IFSeqStSnr.st11(1);
						~cntSeqStSnr11=0;
					}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqSnrBut12.free;
		~ifSeqSnrBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr12 = ~cntSeqStSnr12 + 1;
				~cntSeqStSnr12.switch(
					0,{},
					1, {IFSeqStSnr.st12(0);},
					2, {IFSeqStSnr.st12(1);
						~cntSeqStSnr12=0;
					}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqSnrBut13.free;
		~ifSeqSnrBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr13 = ~cntSeqStSnr13 + 1;
				~cntSeqStSnr13.switch(
					0,{},
					1, {IFSeqStSnr.st13(0);},
					2, {IFSeqStSnr.st13(1);
						~cntSeqStSnr13=0;
					}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqSnrBut14.free;
		~ifSeqSnrBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr14 = ~cntSeqStSnr14 + 1;
				~cntSeqStSnr14.switch(
					0,{},
					1, {IFSeqStSnr.st14(0);},
					2, {IFSeqStSnr.st14(1);
						~cntSeqStSnr14=0;
					}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqSnrBut15.free;
		~ifSeqSnrBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr15 = ~cntSeqStSnr15 + 1;
				~cntSeqStSnr15.switch(
					0,{},
					1, {IFSeqStSnr.st15(0);},
					2, {IFSeqStSnr.st15(1);
						~cntSeqStSnr15=0;
					}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqSnrBut16.free;
		~ifSeqSnrBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSnr16 = ~cntSeqStSnr16 + 1;
				~cntSeqStSnr16.switch(
					0,{},
					1, {IFSeqStSnr.st16(0);},
					2, {IFSeqStSnr.st16(1);
						~cntSeqStSnr16=0;
					}
				)}
			);
			},
			'/ifSeq/2/16'
		);

	}//

	*st01 {|i=0|
		~seqStSnr01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr01', i);
	}
	*st02 {|i=0|
		~seqStSnr02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr02', i);
	}
	*st03 {|i=0|
		~seqStSnr03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr03', i);
	}
	*st04 {|i=0|
		~seqStSnr04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr04', i);
	}
	*st05 {|i=0|
		~seqStSnr05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr05', i);
	}
	*st06 {|i=0|
		~seqStSnr06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr06', i);
	}
	*st07 {|i=0|
		~seqStSnr07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr07', i);
	}
	*st08 {|i=0|
		~seqStSnr08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr08', i);
	}
	*st09 {|i=0|
		~seqStSnr09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr09', i);
	}
	*st10 {|i=0|
		~seqStSnr10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr10', i);
	}
	*st11 {|i=0|
		~seqStSnr11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr11', i);
	}
	*st12 {|i=0|
		~seqStSnr12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr12', i);
	}
	*st13 {|i=0|
		~seqStSnr13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr13', i);
	}
	*st14 {|i=0|
		~seqStSnr14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr14', i);
	}
	*st15 {|i=0|
		~seqStSnr15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr15', i);
	}
	*st16 {|i=0|
		~seqStSnr16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSnr16', i);
	}
	*stGrp {|i|

		IFSeqStSnr.st01(i); IFSeqStSnr.st02(i); IFSeqStSnr.st03(i); IFSeqStSnr.st04(i);
		IFSeqStSnr.st05(i); IFSeqStSnr.st06(i); IFSeqStSnr.st07(i); IFSeqStSnr.st08(i);
		IFSeqStSnr.st09(i); IFSeqStSnr.st10(i); IFSeqStSnr.st11(i); IFSeqStSnr.st12(i);
		IFSeqStSnr.st13(i); IFSeqStSnr.st14(i); IFSeqStSnr.st15(i); IFSeqStSnr.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqStSnr.st01(s01); IFSeqStSnr.st02(s02); IFSeqStSnr.st03(s03); IFSeqStSnr.st04(s04);
		IFSeqStSnr.st05(s05); IFSeqStSnr.st06(s06); IFSeqStSnr.st07(s07); IFSeqStSnr.st08(s08);
		IFSeqStSnr.st09(s09); IFSeqStSnr.st10(s10); IFSeqStSnr.st11(s11); IFSeqStSnr.st12(s12);
		IFSeqStSnr.st13(s13); IFSeqStSnr.st14(s14); IFSeqStSnr.st15(s15); IFSeqStSnr.st16(s16);
	}
}