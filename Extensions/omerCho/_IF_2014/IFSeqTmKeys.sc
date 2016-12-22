IFSeqTmKeys {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~tmMulKeys = PatternProxy( Pseq([1], inf));
		~tmMulKeysP= Pseq([~tmMulKeys], inf).asStream;

		~tmKeys = PatternProxy( Pseq([1], inf));
		~tmKeysP= Pseq([~tmKeys], inf).asStream;

		~seqTmKeys01 = PatternProxy( Pseq([1], 1));
		~seqTmKeys02 = PatternProxy( Pseq([1], 1));
		~seqTmKeys03 = PatternProxy( Pseq([1], 1));
		~seqTmKeys04 = PatternProxy( Pseq([1], 1));
		~seqTmKeys05 = PatternProxy( Pseq([1], 1));
		~seqTmKeys06 = PatternProxy( Pseq([1], 1));
		~seqTmKeys07 = PatternProxy( Pseq([1], 1));
		~seqTmKeys08 = PatternProxy( Pseq([1], 1));

		~seqTmKeys08 = PatternProxy( Pseq([1], 1));
		~seqTmKeys09 = PatternProxy( Pseq([1], 1));
		~seqTmKeys10 = PatternProxy( Pseq([1], 1));
		~seqTmKeys11 = PatternProxy( Pseq([1], 1));
		~seqTmKeys12 = PatternProxy( Pseq([1], 1));
		~seqTmKeys13 = PatternProxy( Pseq([1], 1));
		~seqTmKeys14 = PatternProxy( Pseq([1], 1));
		~seqTmKeys15 = PatternProxy( Pseq([1], 1));
		~seqTmKeys16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqTmUpKeys01=0;
		~cntSeqTmRandKeys01=0;

		~cntSeqTmKeys01=0;
		~cntSeqTmKeys02=0;
		~cntSeqTmKeys03=0;
		~cntSeqTmKeys04=0;
		~cntSeqTmKeys05=0;
		~cntSeqTmKeys06=0;
		~cntSeqTmKeys07=0;
		~cntSeqTmKeys08=0;

		~cntSeqTmKeys09=0;
		~cntSeqTmKeys10=0;
		~cntSeqTmKeys11=0;
		~cntSeqTmKeys12=0;
		~cntSeqTmKeys13=0;
		~cntSeqTmKeys14=0;
		~cntSeqTmKeys15=0;
		~cntSeqTmKeys16=0;
	}
	*freeOn {
		~seqFreeKeysBut.free;
		~seqFreeKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqTmKeys.stGrp(1);
				});
			},
			'/seqFreeKeys'
		);
	}
	*upOn {
		~ifSeqUpKeysBut.free;
		~ifSeqUpKeysBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmUpKeys01 = ~cntSeqTmUpKeys01 + 1;
				~cntSeqTmUpKeys01.switch(
					0,{},
					1,{IFSeqTmKeys.stGrp(1);},
					2,{IFSeqTmKeys.stGrp(2);
						~cntSeqTmUpKeys01=0;
					}
				)}
			);
			},
			'/seqUpKeys'
		);
	}

	*randOn {
		~ifSeqRandKeysBut.free;
		~ifSeqRandKeysBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmRandKeys01 = ~cntSeqTmRandKeys01 + 1;
				~cntSeqTmRandKeys01.switch(
					0,{},
					1,{
						IFSeqTmKeys.st01([1,2].choose);
						IFSeqTmKeys.st02([1,2].choose);
						IFSeqTmKeys.st03([1,2].choose);
						IFSeqTmKeys.st04([1,2].choose);
						IFSeqTmKeys.st05([1,2].choose);
						IFSeqTmKeys.st06([1,2].choose);
						IFSeqTmKeys.st07([1,2].choose);
						IFSeqTmKeys.st08([1,2].choose);

						IFSeqTmKeys.st09([1,2].choose);
						IFSeqTmKeys.st10([1,2].choose);
						IFSeqTmKeys.st11([1,2].choose);
						IFSeqTmKeys.st12([1,2].choose);
						IFSeqTmKeys.st13([1,2].choose);
						IFSeqTmKeys.st14([1,2].choose);
						IFSeqTmKeys.st15([1,2].choose);
						IFSeqTmKeys.st16([1,2].choose);
						~cntSeqTmRandKeys01=0;
					}
				)}
			);
			},
			'/seqRandKeys'
		);
	}


	*on { // Shift Tmocity

		IFSeqTmKeys.randOn;
		IFSeqTmKeys.upOn;
		IFSeqTmKeys.freeOn;

		~ifSeqKeysBut01.free;
		~ifSeqKeysBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys01 = ~cntSeqTmKeys01 + 1;
				~cntSeqTmKeys01.switch(
					0,{},
					1, {IFSeqTmKeys.st01(1);},
					2, {IFSeqTmKeys.st01(2);~cntSeqTmKeys01=0;}
				)}
			);
			},
			'/ifSeq/5/1'
		);
		~ifSeqKeysBut02.free;
		~ifSeqKeysBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys02 = ~cntSeqTmKeys02 + 1;
				~cntSeqTmKeys02.switch(
					0,{},
					1, {IFSeqTmKeys.st02(1);},
					2, {IFSeqTmKeys.st02(2);~cntSeqTmKeys02=0;}
				)}
			);
			},
			'/ifSeq/5/2'
		);
		~ifSeqKeysBut03.free;
		~ifSeqKeysBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys03 = ~cntSeqTmKeys03 + 1;
				~cntSeqTmKeys03.switch(
					0,{},
					1, {IFSeqTmKeys.st03(1);},
					2, {IFSeqTmKeys.st03(2);~cntSeqTmKeys03=0;}
				)}
			);
			},
			'/ifSeq/5/3'
		);
		~ifSeqKeysBut04.free;
		~ifSeqKeysBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys04 = ~cntSeqTmKeys04 + 1;
				~cntSeqTmKeys04.switch(
					0,{},
					1, {IFSeqTmKeys.st04(1);},
					2, {IFSeqTmKeys.st04(2);~cntSeqTmKeys04=0;}
				)}
			);
			},
			'/ifSeq/5/4'
		);
		~ifSeqKeysBut05.free;
		~ifSeqKeysBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys05 = ~cntSeqTmKeys05 + 1;
				~cntSeqTmKeys05.switch(
					0,{},
					1, {IFSeqTmKeys.st05(1);},
					2, {IFSeqTmKeys.st05(2);~cntSeqTmKeys05=0;}
				)}
			);
			},
			'/ifSeq/5/5'
		);
		~ifSeqKeysBut06.free;
		~ifSeqKeysBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys06 = ~cntSeqTmKeys06 + 1;
				~cntSeqTmKeys06.switch(
					0,{},
					1, {IFSeqTmKeys.st06(1);},
					2, {IFSeqTmKeys.st06(2);~cntSeqTmKeys06=0;}
				)}
			);
			},
			'/ifSeq/5/6'
		);
		~ifSeqKeysBut07.free;
		~ifSeqKeysBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys07 = ~cntSeqTmKeys07 + 1;
				~cntSeqTmKeys07.switch(
					0,{},
					1, {IFSeqTmKeys.st07(1);},
					2, {IFSeqTmKeys.st07(2);~cntSeqTmKeys07=0;}
				)}
			);
			},
			'/ifSeq/5/7'
		);
		~ifSeqKeysBut08.free;
		~ifSeqKeysBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys08 = ~cntSeqTmKeys08 + 1;
				~cntSeqTmKeys08.switch(
					0,{},
					1, {IFSeqTmKeys.st08(1);},
					2, {IFSeqTmKeys.st08(2);~cntSeqTmKeys08=0;}
				)}
			);
			},
			'/ifSeq/5/8'
		);

		~ifSeqKeysBut09.free;
		~ifSeqKeysBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys09 = ~cntSeqTmKeys09 + 1;
				~cntSeqTmKeys09.switch(
					0,{},
					1, {IFSeqTmKeys.st09(1);},
					2, {IFSeqTmKeys.st09(2);~cntSeqTmKeys09=0;}
				)}
			);
			},
			'/ifSeq/5/9'
		);
		~ifSeqKeysBut10.free;
		~ifSeqKeysBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys10 = ~cntSeqTmKeys10 + 1;
				~cntSeqTmKeys10.switch(
					0,{},
					1, {IFSeqTmKeys.st10(1);},
					2, {IFSeqTmKeys.st10(2);~cntSeqTmKeys10=0;}
				)}
			);
			},
			'/ifSeq/5/10'
		);
		~ifSeqKeysBut11.free;
		~ifSeqKeysBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys11 = ~cntSeqTmKeys11 + 1;
				~cntSeqTmKeys11.switch(
					0,{},
					1, {IFSeqTmKeys.st11(1);},
					2, {IFSeqTmKeys.st11(2);~cntSeqTmKeys11=0;}
				)}
			);
			},
			'/ifSeq/5/11'
		);
		~ifSeqKeysBut12.free;
		~ifSeqKeysBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys12 = ~cntSeqTmKeys12 + 1;
				~cntSeqTmKeys12.switch(
					0,{},
					1, {IFSeqTmKeys.st12(1);},
					2, {IFSeqTmKeys.st12(2);~cntSeqTmKeys12=0;}
				)}
			);
			},
			'/ifSeq/5/12'
		);
		~ifSeqKeysBut13.free;
		~ifSeqKeysBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys13 = ~cntSeqTmKeys13 + 1;
				~cntSeqTmKeys13.switch(
					0,{},
					1, {IFSeqTmKeys.st13(1);},
					2, {IFSeqTmKeys.st13(2);~cntSeqTmKeys13=0;}
				)}
			);
			},
			'/ifSeq/5/13'
		);
		~ifSeqKeysBut14.free;
		~ifSeqKeysBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys14 = ~cntSeqTmKeys14 + 1;
				~cntSeqTmKeys14.switch(
					0,{},
					1, {IFSeqTmKeys.st14(1);},
					2, {IFSeqTmKeys.st14(2);~cntSeqTmKeys14=0;}
				)}
			);
			},
			'/ifSeq/5/14'
		);
		~ifSeqKeysBut15.free;
		~ifSeqKeysBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys15 = ~cntSeqTmKeys15 + 1;
				~cntSeqTmKeys15.switch(
					0,{},
					1, {IFSeqTmKeys.st15(1);},
					2, {IFSeqTmKeys.st15(2);~cntSeqTmKeys15=0;}
				)}
			);
			},
			'/ifSeq/5/15'
		);
		~ifSeqKeysBut16.free;
		~ifSeqKeysBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqTmKeys16 = ~cntSeqTmKeys16 + 1;
				~cntSeqTmKeys16.switch(
					0,{},
					1, {IFSeqTmKeys.st16(1);},
					2, {IFSeqTmKeys.st16(2);~cntSeqTmKeys16=0;}
				)}
			);
			},
			'/ifSeq/5/16'
		);

	}


	*st01 {|i=0|
		~seqTmKeys01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys01', i);
	}
	*st02 {|i=0|
		~seqTmKeys02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys02', i);
	}
	*st03 {|i=0|
		~seqTmKeys03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys03', i);
	}
	*st04 {|i=0|
		~seqTmKeys04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys04', i);
	}
	*st05 {|i=0|
		~seqTmKeys05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys05', i);
	}
	*st06 {|i=0|
		~seqTmKeys06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys06', i);
	}
	*st07 {|i=0|
		~seqTmKeys07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys07', i);
	}
	*st08 {|i=0|
		~seqTmKeys08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys08', i);
	}

	*st09 {|i=0|
		~seqTmKeys09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys09', i);
	}
	*st10 {|i=0|
		~seqTmKeys10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys10', i);
	}
	*st11 {|i=0|
		~seqTmKeys11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys11', i);
	}
	*st12 {|i=0|
		~seqTmKeys12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys12', i);
	}
	*st13 {|i=0|
		~seqTmKeys13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys13', i);
	}
	*st14 {|i=0|
		~seqTmKeys14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys14', i);
	}
	*st15 {|i=0|
		~seqTmKeys15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys15', i);
	}
	*st16 {|i=0|
		~seqTmKeys16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shTmKeys16', i);
	}
	*stGrp {|i|
		IFSeqTmKeys.st01(i); IFSeqTmKeys.st02(i); IFSeqTmKeys.st03(i); IFSeqTmKeys.st04(i);
		IFSeqTmKeys.st05(i); IFSeqTmKeys.st06(i); IFSeqTmKeys.st07(i); IFSeqTmKeys.st08(i);
		IFSeqTmKeys.st09(i); IFSeqTmKeys.st10(i); IFSeqTmKeys.st11(i); IFSeqTmKeys.st12(i);
		IFSeqTmKeys.st13(i); IFSeqTmKeys.st14(i); IFSeqTmKeys.st15(i); IFSeqTmKeys.st16(i);
	}
}