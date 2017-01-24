IFSeqTmSamp {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~tmMulSamp = PatternProxy( Pseq([1], inf));
		~tmMulSampP= Pseq([~tmMulSamp], inf).asStream;

		~tmSamp = PatternProxy( Pseq([1], inf));
		~tmSampP= Pseq([~tmSamp], inf).asStream;

		~seqTmSamp01 = PatternProxy( Pseq([1], 1));
		~seqTmSamp02 = PatternProxy( Pseq([1], 1));
		~seqTmSamp03 = PatternProxy( Pseq([1], 1));
		~seqTmSamp04 = PatternProxy( Pseq([1], 1));
		~seqTmSamp05 = PatternProxy( Pseq([1], 1));
		~seqTmSamp06 = PatternProxy( Pseq([1], 1));
		~seqTmSamp07 = PatternProxy( Pseq([1], 1));
		~seqTmSamp08 = PatternProxy( Pseq([1], 1));

		~seqTmSamp08 = PatternProxy( Pseq([1], 1));
		~seqTmSamp09 = PatternProxy( Pseq([1], 1));
		~seqTmSamp10 = PatternProxy( Pseq([1], 1));
		~seqTmSamp11 = PatternProxy( Pseq([1], 1));
		~seqTmSamp12 = PatternProxy( Pseq([1], 1));
		~seqTmSamp13 = PatternProxy( Pseq([1], 1));
		~seqTmSamp14 = PatternProxy( Pseq([1], 1));
		~seqTmSamp15 = PatternProxy( Pseq([1], 1));
		~seqTmSamp16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqTmUpSamp01=0;
		~cntSeqTmRandSamp01=0;

		~cntSeqTmSamp01=0;
		~cntSeqTmSamp02=0;
		~cntSeqTmSamp03=0;
		~cntSeqTmSamp04=0;
		~cntSeqTmSamp05=0;
		~cntSeqTmSamp06=0;
		~cntSeqTmSamp07=0;
		~cntSeqTmSamp08=0;

		~cntSeqTmSamp09=0;
		~cntSeqTmSamp10=0;
		~cntSeqTmSamp11=0;
		~cntSeqTmSamp12=0;
		~cntSeqTmSamp13=0;
		~cntSeqTmSamp14=0;
		~cntSeqTmSamp15=0;
		~cntSeqTmSamp16=0;
	}
	*freeOn {
		~seqFreeSampBut.free;
		~seqFreeSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqTmSamp.stGrp(1);
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
				~cntSeqTmUpSamp01 = ~cntSeqTmUpSamp01 + 1;
				~cntSeqTmUpSamp01.switch(
					0,{},
					1,{IFSeqTmSamp.stGrp(1);},
					2,{IFSeqTmSamp.stGrp(2);
						~cntSeqTmUpSamp01=0;
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
				~cntSeqTmRandSamp01 = ~cntSeqTmRandSamp01 + 1;
				~cntSeqTmRandSamp01.switch(
					0,{},
					1,{
						IFSeqTmSamp.st01([1,2].choose);
						IFSeqTmSamp.st02([1,2].choose);
						IFSeqTmSamp.st03([1,2].choose);
						IFSeqTmSamp.st04([1,2].choose);
						IFSeqTmSamp.st05([1,2].choose);
						IFSeqTmSamp.st06([1,2].choose);
						IFSeqTmSamp.st07([1,2].choose);
						IFSeqTmSamp.st08([1,2].choose);

						IFSeqTmSamp.st09([1,2].choose);
						IFSeqTmSamp.st10([1,2].choose);
						IFSeqTmSamp.st11([1,2].choose);
						IFSeqTmSamp.st12([1,2].choose);
						IFSeqTmSamp.st13([1,2].choose);
						IFSeqTmSamp.st14([1,2].choose);
						IFSeqTmSamp.st15([1,2].choose);
						IFSeqTmSamp.st16([1,2].choose);
						~cntSeqTmRandSamp01=0;
					}
				)}
			);
			},
			'/seqRandSamp'
		);
	}


	*on { // Shift Tmocity

		IFSeqTmSamp.randOn;
		IFSeqTmSamp.upOn;
		IFSeqTmSamp.freeOn;

		~ifSeqSampBut01.free;
		~ifSeqSampBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp01 = ~cntSeqTmSamp01 + 1;
				~cntSeqTmSamp01.switch(
					0,{},
					1, {IFSeqTmSamp.st01(1);},
					2, {IFSeqTmSamp.st01(2);~cntSeqTmSamp01=0;}
				)}
			);
			},
			'/ifSeq/6/1'
		);
		~ifSeqSampBut02.free;
		~ifSeqSampBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp02 = ~cntSeqTmSamp02 + 1;
				~cntSeqTmSamp02.switch(
					0,{},
					1, {IFSeqTmSamp.st02(1);},
					2, {IFSeqTmSamp.st02(2);~cntSeqTmSamp02=0;}
				)}
			);
			},
			'/ifSeq/6/2'
		);
		~ifSeqSampBut03.free;
		~ifSeqSampBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp03 = ~cntSeqTmSamp03 + 1;
				~cntSeqTmSamp03.switch(
					0,{},
					1, {IFSeqTmSamp.st03(1);},
					2, {IFSeqTmSamp.st03(2);~cntSeqTmSamp03=0;}
				)}
			);
			},
			'/ifSeq/6/3'
		);
		~ifSeqSampBut04.free;
		~ifSeqSampBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp04 = ~cntSeqTmSamp04 + 1;
				~cntSeqTmSamp04.switch(
					0,{},
					1, {IFSeqTmSamp.st04(1);},
					2, {IFSeqTmSamp.st04(2);~cntSeqTmSamp04=0;}
				)}
			);
			},
			'/ifSeq/6/4'
		);
		~ifSeqSampBut05.free;
		~ifSeqSampBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp05 = ~cntSeqTmSamp05 + 1;
				~cntSeqTmSamp05.switch(
					0,{},
					1, {IFSeqTmSamp.st05(1);},
					2, {IFSeqTmSamp.st05(2);~cntSeqTmSamp05=0;}
				)}
			);
			},
			'/ifSeq/6/5'
		);
		~ifSeqSampBut06.free;
		~ifSeqSampBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp06 = ~cntSeqTmSamp06 + 1;
				~cntSeqTmSamp06.switch(
					0,{},
					1, {IFSeqTmSamp.st06(1);},
					2, {IFSeqTmSamp.st06(2);~cntSeqTmSamp06=0;}
				)}
			);
			},
			'/ifSeq/6/6'
		);
		~ifSeqSampBut07.free;
		~ifSeqSampBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp07 = ~cntSeqTmSamp07 + 1;
				~cntSeqTmSamp07.switch(
					0,{},
					1, {IFSeqTmSamp.st07(1);},
					2, {IFSeqTmSamp.st07(2);~cntSeqTmSamp07=0;}
				)}
			);
			},
			'/ifSeq/6/7'
		);
		~ifSeqSampBut08.free;
		~ifSeqSampBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp08 = ~cntSeqTmSamp08 + 1;
				~cntSeqTmSamp08.switch(
					0,{},
					1, {IFSeqTmSamp.st08(1);},
					2, {IFSeqTmSamp.st08(2);~cntSeqTmSamp08=0;}
				)}
			);
			},
			'/ifSeq/6/8'
		);

		~ifSeqSampBut09.free;
		~ifSeqSampBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp09 = ~cntSeqTmSamp09 + 1;
				~cntSeqTmSamp09.switch(
					0,{},
					1, {IFSeqTmSamp.st09(1);},
					2, {IFSeqTmSamp.st09(2);~cntSeqTmSamp09=0;}
				)}
			);
			},
			'/ifSeq/6/9'
		);
		~ifSeqSampBut10.free;
		~ifSeqSampBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp10 = ~cntSeqTmSamp10 + 1;
				~cntSeqTmSamp10.switch(
					0,{},
					1, {IFSeqTmSamp.st10(1);},
					2, {IFSeqTmSamp.st10(2);~cntSeqTmSamp10=0;}
				)}
			);
			},
			'/ifSeq/6/10'
		);
		~ifSeqSampBut11.free;
		~ifSeqSampBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp11 = ~cntSeqTmSamp11 + 1;
				~cntSeqTmSamp11.switch(
					0,{},
					1, {IFSeqTmSamp.st11(1);},
					2, {IFSeqTmSamp.st11(2);~cntSeqTmSamp11=0;}
				)}
			);
			},
			'/ifSeq/6/11'
		);
		~ifSeqSampBut12.free;
		~ifSeqSampBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp12 = ~cntSeqTmSamp12 + 1;
				~cntSeqTmSamp12.switch(
					0,{},
					1, {IFSeqTmSamp.st12(1);},
					2, {IFSeqTmSamp.st12(2);~cntSeqTmSamp12=0;}
				)}
			);
			},
			'/ifSeq/6/12'
		);
		~ifSeqSampBut13.free;
		~ifSeqSampBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp13 = ~cntSeqTmSamp13 + 1;
				~cntSeqTmSamp13.switch(
					0,{},
					1, {IFSeqTmSamp.st13(1);},
					2, {IFSeqTmSamp.st13(2);~cntSeqTmSamp13=0;}
				)}
			);
			},
			'/ifSeq/6/13'
		);
		~ifSeqSampBut14.free;
		~ifSeqSampBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp14 = ~cntSeqTmSamp14 + 1;
				~cntSeqTmSamp14.switch(
					0,{},
					1, {IFSeqTmSamp.st14(1);},
					2, {IFSeqTmSamp.st14(2);~cntSeqTmSamp14=0;}
				)}
			);
			},
			'/ifSeq/6/14'
		);
		~ifSeqSampBut15.free;
		~ifSeqSampBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp15 = ~cntSeqTmSamp15 + 1;
				~cntSeqTmSamp15.switch(
					0,{},
					1, {IFSeqTmSamp.st15(1);},
					2, {IFSeqTmSamp.st15(2);~cntSeqTmSamp15=0;}
				)}
			);
			},
			'/ifSeq/6/15'
		);
		~ifSeqSampBut16.free;
		~ifSeqSampBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmSamp16 = ~cntSeqTmSamp16 + 1;
				~cntSeqTmSamp16.switch(
					0,{},
					1, {IFSeqTmSamp.st16(1);},
					2, {IFSeqTmSamp.st16(2);~cntSeqTmSamp16=0;}
				)}
			);
			},
			'/ifSeq/6/16'
		);

	}


	*st01 {|i=0|
		~seqTmSamp01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp01', i);
	}
	*st02 {|i=0|
		~seqTmSamp02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp02', i);
	}
	*st03 {|i=0|
		~seqTmSamp03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp03', i);
	}
	*st04 {|i=0|
		~seqTmSamp04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp04', i);
	}
	*st05 {|i=0|
		~seqTmSamp05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp05', i);
	}
	*st06 {|i=0|
		~seqTmSamp06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp06', i);
	}
	*st07 {|i=0|
		~seqTmSamp07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp07', i);
	}
	*st08 {|i=0|
		~seqTmSamp08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp08', i);
	}

	*st09 {|i=0|
		~seqTmSamp09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp09', i);
	}
	*st10 {|i=0|
		~seqTmSamp10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp10', i);
	}
	*st11 {|i=0|
		~seqTmSamp11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp11', i);
	}
	*st12 {|i=0|
		~seqTmSamp12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp12', i);
	}
	*st13 {|i=0|
		~seqTmSamp13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp13', i);
	}
	*st14 {|i=0|
		~seqTmSamp14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp14', i);
	}
	*st15 {|i=0|
		~seqTmSamp15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp15', i);
	}
	*st16 {|i=0|
		~seqTmSamp16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmSamp16', i);
	}
	*stGrp {|i|
		IFSeqTmSamp.st01(i); IFSeqTmSamp.st02(i); IFSeqTmSamp.st03(i); IFSeqTmSamp.st04(i);
		IFSeqTmSamp.st05(i); IFSeqTmSamp.st06(i); IFSeqTmSamp.st07(i); IFSeqTmSamp.st08(i);
		IFSeqTmSamp.st09(i); IFSeqTmSamp.st10(i); IFSeqTmSamp.st11(i); IFSeqTmSamp.st12(i);
		IFSeqTmSamp.st13(i); IFSeqTmSamp.st14(i); IFSeqTmSamp.st15(i); IFSeqTmSamp.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqTmSamp.st01(s01); IFSeqTmSamp.st02(s02); IFSeqTmSamp.st03(s03); IFSeqTmSamp.st04(s04);
		IFSeqTmSamp.st05(s05); IFSeqTmSamp.st06(s06); IFSeqTmSamp.st07(s07); IFSeqTmSamp.st08(s08);
		IFSeqTmSamp.st09(s09); IFSeqTmSamp.st10(s10); IFSeqTmSamp.st11(s11); IFSeqTmSamp.st12(s12);
		IFSeqTmSamp.st13(s13); IFSeqTmSamp.st14(s14); IFSeqTmSamp.st15(s15); IFSeqTmSamp.st16(s16);
	}
}