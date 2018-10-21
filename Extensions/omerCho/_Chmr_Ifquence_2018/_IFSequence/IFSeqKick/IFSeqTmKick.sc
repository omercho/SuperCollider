IFSeqTmKick {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~tmMulKick = PatternProxy( Pseq([1], inf));
		~tmMulKickP= Pseq([~tmMulKick], inf).asStream;

		~tmKick = PatternProxy( Pseq([1], inf));
		~tmKickP= Pseq([~tmKick], inf).asStream;

		~seqTmKick01 = PatternProxy( Pseq([1], 1));
		~seqTmKick02 = PatternProxy( Pseq([1], 1));
		~seqTmKick03 = PatternProxy( Pseq([1], 1));
		~seqTmKick04 = PatternProxy( Pseq([1], 1));
		~seqTmKick05 = PatternProxy( Pseq([1], 1));
		~seqTmKick06 = PatternProxy( Pseq([1], 1));
		~seqTmKick07 = PatternProxy( Pseq([1], 1));
		~seqTmKick08 = PatternProxy( Pseq([1], 1));

		~seqTmKick08 = PatternProxy( Pseq([1], 1));
		~seqTmKick09 = PatternProxy( Pseq([1], 1));
		~seqTmKick10 = PatternProxy( Pseq([1], 1));
		~seqTmKick11 = PatternProxy( Pseq([1], 1));
		~seqTmKick12 = PatternProxy( Pseq([1], 1));
		~seqTmKick13 = PatternProxy( Pseq([1], 1));
		~seqTmKick14 = PatternProxy( Pseq([1], 1));
		~seqTmKick15 = PatternProxy( Pseq([1], 1));
		~seqTmKick16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqTmUpKick01=0;
		~cntSeqTmRandKick01=0;

		~cntSeqTmKick01=0;
		~cntSeqTmKick02=0;
		~cntSeqTmKick03=0;
		~cntSeqTmKick04=0;
		~cntSeqTmKick05=0;
		~cntSeqTmKick06=0;
		~cntSeqTmKick07=0;
		~cntSeqTmKick08=0;

		~cntSeqTmKick09=0;
		~cntSeqTmKick10=0;
		~cntSeqTmKick11=0;
		~cntSeqTmKick12=0;
		~cntSeqTmKick13=0;
		~cntSeqTmKick14=0;
		~cntSeqTmKick15=0;
		~cntSeqTmKick16=0;
	}
	*freeOn {
		~seqFreeKickBut.free;
		~seqFreeKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqTmKick.stGrp(1);
				});
			},
			'/seqFreeKick'
		);
	}
	*upOn {
		~ifSeqUpKickBut.free;
		~ifSeqUpKickBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmUpKick01 = ~cntSeqTmUpKick01 + 1;
				~cntSeqTmUpKick01.switch(
					0,{},
					1,{IFSeqTmKick.stGrp(1);},
					2,{IFSeqTmKick.stGrp(2);
						~cntSeqTmUpKick01=0;
					}
				)}
			);
			},
			'/seqUpKick'
		);
	}

	*randOn {
		~ifSeqRandKickBut.free;
		~ifSeqRandKickBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmRandKick01 = ~cntSeqTmRandKick01 + 1;
				~cntSeqTmRandKick01.switch(
					0,{},
					1,{
						IFSeqTmKick.st01([1,2].choose);
						IFSeqTmKick.st02([1,2].choose);
						IFSeqTmKick.st03([1,2].choose);
						IFSeqTmKick.st04([1,2].choose);
						IFSeqTmKick.st05([1,2].choose);
						IFSeqTmKick.st06([1,2].choose);
						IFSeqTmKick.st07([1,2].choose);
						IFSeqTmKick.st08([1,2].choose);

						IFSeqTmKick.st09([1,2].choose);
						IFSeqTmKick.st10([1,2].choose);
						IFSeqTmKick.st11([1,2].choose);
						IFSeqTmKick.st12([1,2].choose);
						IFSeqTmKick.st13([1,2].choose);
						IFSeqTmKick.st14([1,2].choose);
						IFSeqTmKick.st15([1,2].choose);
						IFSeqTmKick.st16([1,2].choose);
						~cntSeqTmRandKick01=0;
					}
				)}
			);
			},
			'/seqRandKick'
		);
	}


	*on { // Shift Tmocity

		IFSeqTmKick.randOn;
		IFSeqTmKick.upOn;
		IFSeqTmKick.freeOn;

		~ifSeqKickBut01.free;
		~ifSeqKickBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick01 = ~cntSeqTmKick01 + 1;
				~cntSeqTmKick01.switch(
					0,{},
					1, {IFSeqTmKick.st01(1);},
					2, {IFSeqTmKick.st01(2);~cntSeqTmKick01=0;}
				)}
			);
			},
			'/ifSeq/1/1'
		);
		~ifSeqKickBut02.free;
		~ifSeqKickBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick02 = ~cntSeqTmKick02 + 1;
				~cntSeqTmKick02.switch(
					0,{},
					1, {IFSeqTmKick.st02(1);},
					2, {IFSeqTmKick.st02(2);~cntSeqTmKick02=0;}
				)}
			);
			},
			'/ifSeq/1/2'
		);
		~ifSeqKickBut03.free;
		~ifSeqKickBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick03 = ~cntSeqTmKick03 + 1;
				~cntSeqTmKick03.switch(
					0,{},
					1, {IFSeqTmKick.st03(1);},
					2, {IFSeqTmKick.st03(2);~cntSeqTmKick03=0;}
				)}
			);
			},
			'/ifSeq/1/3'
		);
		~ifSeqKickBut04.free;
		~ifSeqKickBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick04 = ~cntSeqTmKick04 + 1;
				~cntSeqTmKick04.switch(
					0,{},
					1, {IFSeqTmKick.st04(1);},
					2, {IFSeqTmKick.st04(2);~cntSeqTmKick04=0;}
				)}
			);
			},
			'/ifSeq/1/4'
		);
		~ifSeqKickBut05.free;
		~ifSeqKickBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick05 = ~cntSeqTmKick05 + 1;
				~cntSeqTmKick05.switch(
					0,{},
					1, {IFSeqTmKick.st05(1);},
					2, {IFSeqTmKick.st05(2);~cntSeqTmKick05=0;}
				)}
			);
			},
			'/ifSeq/1/5'
		);
		~ifSeqKickBut06.free;
		~ifSeqKickBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick06 = ~cntSeqTmKick06 + 1;
				~cntSeqTmKick06.switch(
					0,{},
					1, {IFSeqTmKick.st06(1);},
					2, {IFSeqTmKick.st06(2);~cntSeqTmKick06=0;}
				)}
			);
			},
			'/ifSeq/1/6'
		);
		~ifSeqKickBut07.free;
		~ifSeqKickBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick07 = ~cntSeqTmKick07 + 1;
				~cntSeqTmKick07.switch(
					0,{},
					1, {IFSeqTmKick.st07(1);},
					2, {IFSeqTmKick.st07(2);~cntSeqTmKick07=0;}
				)}
			);
			},
			'/ifSeq/1/7'
		);
		~ifSeqKickBut08.free;
		~ifSeqKickBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick08 = ~cntSeqTmKick08 + 1;
				~cntSeqTmKick08.switch(
					0,{},
					1, {IFSeqTmKick.st08(1);},
					2, {IFSeqTmKick.st08(2);~cntSeqTmKick08=0;}
				)}
			);
			},
			'/ifSeq/1/8'
		);

		~ifSeqKickBut09.free;
		~ifSeqKickBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick09 = ~cntSeqTmKick09 + 1;
				~cntSeqTmKick09.switch(
					0,{},
					1, {IFSeqTmKick.st09(1);},
					2, {IFSeqTmKick.st09(2);~cntSeqTmKick09=0;}
				)}
			);
			},
			'/ifSeq/1/9'
		);
		~ifSeqKickBut10.free;
		~ifSeqKickBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick10 = ~cntSeqTmKick10 + 1;
				~cntSeqTmKick10.switch(
					0,{},
					1, {IFSeqTmKick.st10(1);},
					2, {IFSeqTmKick.st10(2);~cntSeqTmKick10=0;}
				)}
			);
			},
			'/ifSeq/1/10'
		);
		~ifSeqKickBut11.free;
		~ifSeqKickBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick11 = ~cntSeqTmKick11 + 1;
				~cntSeqTmKick11.switch(
					0,{},
					1, {IFSeqTmKick.st11(1);},
					2, {IFSeqTmKick.st11(2);~cntSeqTmKick11=0;}
				)}
			);
			},
			'/ifSeq/1/11'
		);
		~ifSeqKickBut12.free;
		~ifSeqKickBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick12 = ~cntSeqTmKick12 + 1;
				~cntSeqTmKick12.switch(
					0,{},
					1, {IFSeqTmKick.st12(1);},
					2, {IFSeqTmKick.st12(2);~cntSeqTmKick12=0;}
				)}
			);
			},
			'/ifSeq/1/12'
		);
		~ifSeqKickBut13.free;
		~ifSeqKickBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick13 = ~cntSeqTmKick13 + 1;
				~cntSeqTmKick13.switch(
					0,{},
					1, {IFSeqTmKick.st13(1);},
					2, {IFSeqTmKick.st13(2);~cntSeqTmKick13=0;}
				)}
			);
			},
			'/ifSeq/1/13'
		);
		~ifSeqKickBut14.free;
		~ifSeqKickBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick14 = ~cntSeqTmKick14 + 1;
				~cntSeqTmKick14.switch(
					0,{},
					1, {IFSeqTmKick.st14(1);},
					2, {IFSeqTmKick.st14(2);~cntSeqTmKick14=0;}
				)}
			);
			},
			'/ifSeq/1/14'
		);
		~ifSeqKickBut15.free;
		~ifSeqKickBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick15 = ~cntSeqTmKick15 + 1;
				~cntSeqTmKick15.switch(
					0,{},
					1, {IFSeqTmKick.st15(1);},
					2, {IFSeqTmKick.st15(2);~cntSeqTmKick15=0;}
				)}
			);
			},
			'/ifSeq/1/15'
		);
		~ifSeqKickBut16.free;
		~ifSeqKickBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKick16 = ~cntSeqTmKick16 + 1;
				~cntSeqTmKick16.switch(
					0,{},
					1, {IFSeqTmKick.st16(1);},
					2, {IFSeqTmKick.st16(2);~cntSeqTmKick16=0;}
				)}
			);
			},
			'/ifSeq/1/16'
		);

	}


	*st01 {|i=0|
		~seqTmKick01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick01', i);
	}
	*st02 {|i=0|
		~seqTmKick02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick02', i);
	}
	*st03 {|i=0|
		~seqTmKick03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick03', i);
	}
	*st04 {|i=0|
		~seqTmKick04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick04', i);
	}
	*st05 {|i=0|
		~seqTmKick05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick05', i);
	}
	*st06 {|i=0|
		~seqTmKick06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick06', i);
	}
	*st07 {|i=0|
		~seqTmKick07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick07', i);
	}
	*st08 {|i=0|
		~seqTmKick08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick08', i);
	}

	*st09 {|i=0|
		~seqTmKick09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick09', i);
	}
	*st10 {|i=0|
		~seqTmKick10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick10', i);
	}
	*st11 {|i=0|
		~seqTmKick11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick11', i);
	}
	*st12 {|i=0|
		~seqTmKick12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick12', i);
	}
	*st13 {|i=0|
		~seqTmKick13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick13', i);
	}
	*st14 {|i=0|
		~seqTmKick14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick14', i);
	}
	*st15 {|i=0|
		~seqTmKick15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick15', i);
	}
	*st16 {|i=0|
		~seqTmKick16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKick16', i);
	}
	*stGrp {|i|
		IFSeqTmKick.st01(i); IFSeqTmKick.st02(i); IFSeqTmKick.st03(i); IFSeqTmKick.st04(i);
		IFSeqTmKick.st05(i); IFSeqTmKick.st06(i); IFSeqTmKick.st07(i); IFSeqTmKick.st08(i);
		IFSeqTmKick.st09(i); IFSeqTmKick.st10(i); IFSeqTmKick.st11(i); IFSeqTmKick.st12(i);
		IFSeqTmKick.st13(i); IFSeqTmKick.st14(i); IFSeqTmKick.st15(i); IFSeqTmKick.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqTmKick.st01(s01); IFSeqTmKick.st02(s02); IFSeqTmKick.st03(s03); IFSeqTmKick.st04(s04);
		IFSeqTmKick.st05(s05); IFSeqTmKick.st06(s06); IFSeqTmKick.st07(s07); IFSeqTmKick.st08(s08);
		IFSeqTmKick.st09(s09); IFSeqTmKick.st10(s10); IFSeqTmKick.st11(s11); IFSeqTmKick.st12(s12);
		IFSeqTmKick.st13(s13); IFSeqTmKick.st14(s14); IFSeqTmKick.st15(s15); IFSeqTmKick.st16(s16);
	}
}