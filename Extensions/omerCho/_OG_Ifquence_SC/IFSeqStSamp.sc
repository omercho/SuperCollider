IFSeqStSamp {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqStSamp01 = PatternProxy( Pseq([0], 1));
		~seqStSamp02 = PatternProxy( Pseq([0], 1));
		~seqStSamp03 = PatternProxy( Pseq([0], 1));
		~seqStSamp04 = PatternProxy( Pseq([0], 1));
		~seqStSamp05 = PatternProxy( Pseq([0], 1));
		~seqStSamp06 = PatternProxy( Pseq([0], 1));
		~seqStSamp07 = PatternProxy( Pseq([0], 1));
		~seqStSamp08 = PatternProxy( Pseq([0], 1));

		~seqStSamp09 = PatternProxy( Pseq([0], 1));
		~seqStSamp10 = PatternProxy( Pseq([0], 1));
		~seqStSamp11 = PatternProxy( Pseq([0], 1));
		~seqStSamp12 = PatternProxy( Pseq([0], 1));
		~seqStSamp13 = PatternProxy( Pseq([0], 1));
		~seqStSamp14 = PatternProxy( Pseq([0], 1));
		~seqStSamp15 = PatternProxy( Pseq([0], 1));
		~seqStSamp16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqStUpSamp01=0;
		~cntSeqStRandSamp01=0;

		~cntSeqStSamp01=0;
		~cntSeqStSamp02=0;
		~cntSeqStSamp03=0;
		~cntSeqStSamp04=0;
		~cntSeqStSamp05=0;
		~cntSeqStSamp06=0;
		~cntSeqStSamp07=0;
		~cntSeqStSamp08=0;

		~cntSeqStSamp09=0;
		~cntSeqStSamp10=0;
		~cntSeqStSamp11=0;
		~cntSeqStSamp12=0;
		~cntSeqStSamp13=0;
		~cntSeqStSamp14=0;
		~cntSeqStSamp15=0;
		~cntSeqStSamp16=0;
	}
	*freeOn {
		~seqFreeSampBut.free;
		~seqFreeSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqStSamp.stGrp(0);
				});
			},
			'/seqFreeSamp'
		);

	}

	*upOn {
		~ifSeqUpSampBut.free;
		~ifSeqUpSampBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStUpSamp01 = ~cntSeqStUpSamp01 + 1;
				~cntSeqStUpSamp01.switch(
					0,{},
					1,{IFSeqStSamp.stGrp(0);},
					2,{IFSeqStSamp.stGrp(1);},
					3,{IFSeqStSamp.stGrp(2);},
					4,{IFSeqStSamp.stGrp(3);},
					5,{IFSeqStSamp.stGrp(4);},
					6,{IFSeqStSamp.stGrp(5);},
					7,{IFSeqStSamp.stGrp(6);},
					8,{IFSeqStSamp.stGrp(7);
						~cntSeqStUpSamp01=0;
					}
				)}
			);
			},
			'/seqUpSamp'
		);
	}

	*randOn {
		~ifSeqRandSampBut.free;
		~ifSeqRandSampBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStRandSamp01 = ~cntSeqStRandSamp01 + 1;
				~cntSeqStRandSamp01.switch(
					0,{},
					1,{
						IFSeqStSamp.st01([0,1].choose);
						IFSeqStSamp.st02([0,1].choose);
						IFSeqStSamp.st03([0,1].choose);
						IFSeqStSamp.st04([0,1].choose);
						IFSeqStSamp.st05([0,1].choose);
						IFSeqStSamp.st06([0,1].choose);
						IFSeqStSamp.st07([0,1].choose);
						IFSeqStSamp.st08([0,1].choose);

						IFSeqStSamp.st09([0,1].choose);
						IFSeqStSamp.st10([0,1].choose);
						IFSeqStSamp.st11([0,1].choose);
						IFSeqStSamp.st12([0,1].choose);
						IFSeqStSamp.st13([0,1].choose);
						IFSeqStSamp.st14([0,1].choose);
						IFSeqStSamp.st15([0,1].choose);
						IFSeqStSamp.st16([0,1].choose);
						~cntSeqStRandSamp01=0;
					}
				)}
			);
			},
			'/seqRandSamp'
		);
	}

	*on { // Shift StAVE
		IFSeqStSamp.randOn;
		IFSeqStSamp.upOn;
		IFSeqStSamp.freeOn;

		~ifSeqSampBut01.free;
		~ifSeqSampBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp01 = ~cntSeqStSamp01 + 1;
				~cntSeqStSamp01.switch(
					0,{},
					1, {IFSeqStSamp.st01(0);},
					2, {IFSeqStSamp.st01(1);
						~cntSeqStSamp01=0;
					}
				)}
			);
			},
			'/ifSeq/6/1'
		);
		~ifSeqSampBut02.free;
		~ifSeqSampBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp02 = ~cntSeqStSamp02 + 1;
				~cntSeqStSamp02.switch(
					0,{},
					1, {IFSeqStSamp.st02(0);},
					2, {IFSeqStSamp.st02(1);
						~cntSeqStSamp02=0;
					}
				)}
			);
			},
			'/ifSeq/6/2'
		);
		~ifSeqSampBut03.free;
		~ifSeqSampBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp03 = ~cntSeqStSamp03 + 1;
				~cntSeqStSamp03.switch(
					0,{},
					1, {IFSeqStSamp.st03(0);},
					2, {IFSeqStSamp.st03(1);
						~cntSeqStSamp03=0;
					}
				)}
			);
			},
			'/ifSeq/6/3'
		);
		~ifSeqSampBut04.free;
		~ifSeqSampBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp04 = ~cntSeqStSamp04 + 1;
				~cntSeqStSamp04.switch(
					0,{},
					1, {IFSeqStSamp.st04(0);},
					2, {IFSeqStSamp.st04(1);
						~cntSeqStSamp04=0;
					}
				)}
			);
			},
			'/ifSeq/6/4'
		);
		~ifSeqSampBut05.free;
		~ifSeqSampBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp05 = ~cntSeqStSamp05 + 1;
				~cntSeqStSamp05.switch(
					0,{},
					1, {IFSeqStSamp.st05(0);},
					2, {IFSeqStSamp.st05(1);
						~cntSeqStSamp05=0;
					}
				)}
			);
			},
			'/ifSeq/6/5'
		);
		~ifSeqSampBut06.free;
		~ifSeqSampBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp06 = ~cntSeqStSamp06 + 1;
				~cntSeqStSamp06.switch(
					0,{},
					1, {IFSeqStSamp.st06(0);},
					2, {IFSeqStSamp.st06(1);
						~cntSeqStSamp06=0;
					}
				)}
			);
			},
			'/ifSeq/6/6'
		);
		~ifSeqSampBut07.free;
		~ifSeqSampBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp07 = ~cntSeqStSamp07 + 1;
				~cntSeqStSamp07.switch(
					0,{},
					1, {IFSeqStSamp.st07(0);},
					2, {IFSeqStSamp.st07(1);
						~cntSeqStSamp07=0;
					}
				)}
			);
			},
			'/ifSeq/6/7'
		);
		~ifSeqSampBut08.free;
		~ifSeqSampBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp08 = ~cntSeqStSamp08 + 1;
				~cntSeqStSamp08.switch(
					0,{},
					1, {IFSeqStSamp.st08(0);},
					2, {IFSeqStSamp.st08(1);
						~cntSeqStSamp08=0;
					}
				)}
			);
			},
			'/ifSeq/6/8'
		);
		~ifSeqSampBut09.free;
		~ifSeqSampBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp09 = ~cntSeqStSamp09 + 1;
				~cntSeqStSamp09.switch(
					0,{},
					1, {IFSeqStSamp.st09(0);},
					2, {IFSeqStSamp.st09(1);
						~cntSeqStSamp09=0;
					}
				)}
			);
			},
			'/ifSeq/6/9'
		);
		~ifSeqSampBut10.free;
		~ifSeqSampBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp10 = ~cntSeqStSamp10 + 1;
				~cntSeqStSamp10.switch(
					0,{},
					1, {IFSeqStSamp.st10(0);},
					2, {IFSeqStSamp.st10(1);
						~cntSeqStSamp10=0;
					}
				)}
			);
			},
			'/ifSeq/6/10'
		);
		~ifSeqSampBut11.free;
		~ifSeqSampBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp11 = ~cntSeqStSamp11 + 1;
				~cntSeqStSamp11.switch(
					0,{},
					1, {IFSeqStSamp.st11(0);},
					2, {IFSeqStSamp.st11(1);
						~cntSeqStSamp11=0;
					}
				)}
			);
			},
			'/ifSeq/6/11'
		);
		~ifSeqSampBut12.free;
		~ifSeqSampBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp12 = ~cntSeqStSamp12 + 1;
				~cntSeqStSamp12.switch(
					0,{},
					1, {IFSeqStSamp.st12(0);},
					2, {IFSeqStSamp.st12(1);
						~cntSeqStSamp12=0;
					}
				)}
			);
			},
			'/ifSeq/6/12'
		);
		~ifSeqSampBut13.free;
		~ifSeqSampBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp13 = ~cntSeqStSamp13 + 1;
				~cntSeqStSamp13.switch(
					0,{},
					1, {IFSeqStSamp.st13(0);},
					2, {IFSeqStSamp.st13(1);
						~cntSeqStSamp13=0;
					}
				)}
			);
			},
			'/ifSeq/6/13'
		);
		~ifSeqSampBut14.free;
		~ifSeqSampBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp14 = ~cntSeqStSamp14 + 1;
				~cntSeqStSamp14.switch(
					0,{},
					1, {IFSeqStSamp.st14(0);},
					2, {IFSeqStSamp.st14(1);
						~cntSeqStSamp14=0;
					}
				)}
			);
			},
			'/ifSeq/6/14'
		);
		~ifSeqSampBut15.free;
		~ifSeqSampBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp15 = ~cntSeqStSamp15 + 1;
				~cntSeqStSamp15.switch(
					0,{},
					1, {IFSeqStSamp.st15(0);},
					2, {IFSeqStSamp.st15(1);
						~cntSeqStSamp15=0;
					}
				)}
			);
			},
			'/ifSeq/6/15'
		);
		~ifSeqSampBut16.free;
		~ifSeqSampBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStSamp16 = ~cntSeqStSamp16 + 1;
				~cntSeqStSamp16.switch(
					0,{},
					1, {IFSeqStSamp.st16(0);},
					2, {IFSeqStSamp.st16(1);
						~cntSeqStSamp16=0;
					}
				)}
			);
			},
			'/ifSeq/6/16'
		);

	}//

	*st01 {|i=0|
		~seqStSamp01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp01', i);
	}
	*st02 {|i=0|
		~seqStSamp02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp02', i);
	}
	*st03 {|i=0|
		~seqStSamp03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp03', i);
	}
	*st04 {|i=0|
		~seqStSamp04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp04', i);
	}
	*st05 {|i=0|
		~seqStSamp05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp05', i);
	}
	*st06 {|i=0|
		~seqStSamp06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp06', i);
	}
	*st07 {|i=0|
		~seqStSamp07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp07', i);
	}
	*st08 {|i=0|
		~seqStSamp08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp08', i);
	}
	*st09 {|i=0|
		~seqStSamp09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp09', i);
	}
	*st10 {|i=0|
		~seqStSamp10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp10', i);
	}
	*st11 {|i=0|
		~seqStSamp11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp11', i);
	}
	*st12 {|i=0|
		~seqStSamp12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp12', i);
	}
	*st13 {|i=0|
		~seqStSamp13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp13', i);
	}
	*st14 {|i=0|
		~seqStSamp14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp14', i);
	}
	*st15 {|i=0|
		~seqStSamp15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp15', i);
	}
	*st16 {|i=0|
		~seqStSamp16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shStSamp16', i);
	}
	*stGrp {|i|

		IFSeqStSamp.st01(i); IFSeqStSamp.st02(i); IFSeqStSamp.st03(i); IFSeqStSamp.st04(i);
		IFSeqStSamp.st05(i); IFSeqStSamp.st06(i); IFSeqStSamp.st07(i); IFSeqStSamp.st08(i);
		IFSeqStSamp.st09(i); IFSeqStSamp.st10(i); IFSeqStSamp.st11(i); IFSeqStSamp.st12(i);
		IFSeqStSamp.st13(i); IFSeqStSamp.st14(i); IFSeqStSamp.st15(i); IFSeqStSamp.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqStSamp.st01(s01); IFSeqStSamp.st02(s02); IFSeqStSamp.st03(s03); IFSeqStSamp.st04(s04);
		IFSeqStSamp.st05(s05); IFSeqStSamp.st06(s06); IFSeqStSamp.st07(s07); IFSeqStSamp.st08(s08);
		IFSeqStSamp.st09(s09); IFSeqStSamp.st10(s10); IFSeqStSamp.st11(s11); IFSeqStSamp.st12(s12);
		IFSeqStSamp.st13(s13); IFSeqStSamp.st14(s14); IFSeqStSamp.st15(s15); IFSeqStSamp.st16(s16);
	}
}