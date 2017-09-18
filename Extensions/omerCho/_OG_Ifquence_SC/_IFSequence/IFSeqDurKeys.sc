IFSeqDurKeys {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqDurKeys01 = PatternProxy( Pseq([0.5], 1));
		~seqDurKeys02 = PatternProxy( Pseq([0.5], 1));
		~seqDurKeys03 = PatternProxy( Pseq([0.5], 1));
		~seqDurKeys04 = PatternProxy( Pseq([0.5], 1));
		~seqDurKeys05 = PatternProxy( Pseq([0.5], 1));
		~seqDurKeys06 = PatternProxy( Pseq([0.5], 1));
		~seqDurKeys07 = PatternProxy( Pseq([0.5], 1));
		~seqDurKeys08 = PatternProxy( Pseq([0.5], 1));

		~seqDurKeys09 = PatternProxy( Pseq([0.5], 1));
		~seqDurKeys10 = PatternProxy( Pseq([0.5], 1));
		~seqDurKeys11 = PatternProxy( Pseq([0.5], 1));
		~seqDurKeys12 = PatternProxy( Pseq([0.5], 1));
		~seqDurKeys13 = PatternProxy( Pseq([0.5], 1));
		~seqDurKeys14 = PatternProxy( Pseq([0.5], 1));
		~seqDurKeys15 = PatternProxy( Pseq([0.5], 1));
		~seqDurKeys16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqDurUpKeys01=0;
		~cntSeqDurRandKeys01=0;

		~cntSeqDurKeys01=0;
		~cntSeqDurKeys02=0;
		~cntSeqDurKeys03=0;
		~cntSeqDurKeys04=0;
		~cntSeqDurKeys05=0;
		~cntSeqDurKeys06=0;
		~cntSeqDurKeys07=0;
		~cntSeqDurKeys08=0;

		~cntSeqDurKeys09=0;
		~cntSeqDurKeys10=0;
		~cntSeqDurKeys11=0;
		~cntSeqDurKeys12=0;
		~cntSeqDurKeys13=0;
		~cntSeqDurKeys14=0;
		~cntSeqDurKeys15=0;
		~cntSeqDurKeys16=0;
	}
	*freeOn {
		~seqFreeKeysBut.free;
		~seqFreeKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqDurKeys.stGrp(4);
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
				~cntSeqDurUpKeys01 = ~cntSeqDurUpKeys01 + 1;
				~cntSeqDurUpKeys01.switch(
					0,{},
					1,{IFSeqDurKeys.stGrp(1);},
					2,{IFSeqDurKeys.stGrp(2);},
					3,{IFSeqDurKeys.stGrp(3);},
					4,{IFSeqDurKeys.stGrp(4);},
					5,{IFSeqDurKeys.stGrp(5);
						~cntSeqDurUpKeys01=0;
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
				~cntSeqDurRandKeys01 = ~cntSeqDurRandKeys01 + 1;
				~cntSeqDurRandKeys01.switch(
					0,{},
					1,{
						IFSeqDurKeys.st01([1,2,3,4,5].choose);
						IFSeqDurKeys.st02([1,2,3,4,5].choose);
						IFSeqDurKeys.st03([1,2,3,4,5].choose);
						IFSeqDurKeys.st04([1,2,3,4,5].choose);
						IFSeqDurKeys.st05([1,2,3,4,5].choose);
						IFSeqDurKeys.st06([1,2,3,4,5].choose);
						IFSeqDurKeys.st07([1,2,3,4,5].choose);
						IFSeqDurKeys.st08([1,2,3,4,5].choose);

						IFSeqDurKeys.st09([1,2,3,4,5].choose);
						IFSeqDurKeys.st10([1,2,3,4,5].choose);
						IFSeqDurKeys.st11([1,2,3,4,5].choose);
						IFSeqDurKeys.st12([1,2,3,4,5].choose);
						IFSeqDurKeys.st13([1,2,3,4,5].choose);
						IFSeqDurKeys.st14([1,2,3,4,5].choose);
						IFSeqDurKeys.st15([1,2,3,4,5].choose);
						IFSeqDurKeys.st16([1,2,3,4,5].choose);
						~cntSeqDurRandKeys01=0;
					}
				)}
			);
			},
			'/seqRandKeys'
		);
	}


	*on { // Shift Durocity

		IFSeqDurKeys.randOn;
		IFSeqDurKeys.upOn;
		IFSeqDurKeys.freeOn;

		~ifSeqKeysBut01.free;
		~ifSeqKeysBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys01 = ~cntSeqDurKeys01 + 1;
				~cntSeqDurKeys01.switch(
					0,{},
					1, {IFSeqDurKeys.st01(1);},
					2, {IFSeqDurKeys.st01(2);},
					3, {IFSeqDurKeys.st01(3);},
					4, {IFSeqDurKeys.st01(4);},
					5, {IFSeqDurKeys.st01(5);}
				)}
			);
			},
			'/ifSeq/5/1'
		);
		~ifSeqKeysBut02.free;
		~ifSeqKeysBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys02 = ~cntSeqDurKeys02 + 1;
				~cntSeqDurKeys02.switch(
					0,{},
					1, {IFSeqDurKeys.st02(1);},
					2, {IFSeqDurKeys.st02(2);},
					3, {IFSeqDurKeys.st02(3);},
					4, {IFSeqDurKeys.st02(4);},
					5, {IFSeqDurKeys.st02(5);}
				)}
			);
			},
			'/ifSeq/5/2'
		);
		~ifSeqKeysBut03.free;
		~ifSeqKeysBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys03 = ~cntSeqDurKeys03 + 1;
				~cntSeqDurKeys03.switch(
					0,{},
					1, {IFSeqDurKeys.st03(1);},
					2, {IFSeqDurKeys.st03(2);},
					3, {IFSeqDurKeys.st03(3);},
					4, {IFSeqDurKeys.st03(4);},
					5, {IFSeqDurKeys.st03(5);}
				)}
			);
			},
			'/ifSeq/5/3'
		);
		~ifSeqKeysBut04.free;
		~ifSeqKeysBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys04 = ~cntSeqDurKeys04 + 1;
				~cntSeqDurKeys04.switch(
					0,{},
					1, {IFSeqDurKeys.st04(1);},
					2, {IFSeqDurKeys.st04(2);},
					3, {IFSeqDurKeys.st04(3);},
					4, {IFSeqDurKeys.st04(4);},
					5, {IFSeqDurKeys.st04(5);}
				)}
			);
			},
			'/ifSeq/5/4'
		);
		~ifSeqKeysBut05.free;
		~ifSeqKeysBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys05 = ~cntSeqDurKeys05 + 1;
				~cntSeqDurKeys05.switch(
					0,{},
					1, {IFSeqDurKeys.st05(1);},
					2, {IFSeqDurKeys.st05(2);},
					3, {IFSeqDurKeys.st05(3);},
					4, {IFSeqDurKeys.st05(4);},
					5, {IFSeqDurKeys.st05(5);}
				)}
			);
			},
			'/ifSeq/5/5'
		);
		~ifSeqKeysBut06.free;
		~ifSeqKeysBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys06 = ~cntSeqDurKeys06 + 1;
				~cntSeqDurKeys06.switch(
					0,{},
					1, {IFSeqDurKeys.st06(1);},
					2, {IFSeqDurKeys.st06(2);},
					3, {IFSeqDurKeys.st06(3);},
					4, {IFSeqDurKeys.st06(4);},
					5, {IFSeqDurKeys.st06(5);}
				)}
			);
			},
			'/ifSeq/5/6'
		);
		~ifSeqKeysBut07.free;
		~ifSeqKeysBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys07 = ~cntSeqDurKeys07 + 1;
				~cntSeqDurKeys07.switch(
					0,{},
					1, {IFSeqDurKeys.st07(1);},
					2, {IFSeqDurKeys.st07(2);},
					3, {IFSeqDurKeys.st07(3);},
					4, {IFSeqDurKeys.st07(4);},
					5, {IFSeqDurKeys.st07(5);}
				)}
			);
			},
			'/ifSeq/5/7'
		);
		~ifSeqKeysBut08.free;
		~ifSeqKeysBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys08 = ~cntSeqDurKeys08 + 1;
				~cntSeqDurKeys08.switch(
					0,{},
					1, {IFSeqDurKeys.st08(1);},
					2, {IFSeqDurKeys.st08(2);},
					3, {IFSeqDurKeys.st08(3);},
					4, {IFSeqDurKeys.st08(4);},
					5, {IFSeqDurKeys.st08(5);}
				)}
			);
			},
			'/ifSeq/5/8'
		);

		~ifSeqKeysBut09.free;
		~ifSeqKeysBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys09 = ~cntSeqDurKeys09 + 1;
				~cntSeqDurKeys09.switch(
					0,{},
					1, {IFSeqDurKeys.st09(1);},
					2, {IFSeqDurKeys.st09(2);},
					3, {IFSeqDurKeys.st09(3);},
					4, {IFSeqDurKeys.st09(4);},
					5, {IFSeqDurKeys.st09(5);}
				)}
			);
			},
			'/ifSeq/5/9'
		);
		~ifSeqKeysBut10.free;
		~ifSeqKeysBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys10 = ~cntSeqDurKeys10 + 1;
				~cntSeqDurKeys10.switch(
					0,{},
					1, {IFSeqDurKeys.st10(1);},
					2, {IFSeqDurKeys.st10(2);},
					3, {IFSeqDurKeys.st10(3);},
					4, {IFSeqDurKeys.st10(4);},
					5, {IFSeqDurKeys.st10(5);}
				)}
			);
			},
			'/ifSeq/5/10'
		);
		~ifSeqKeysBut11.free;
		~ifSeqKeysBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys11 = ~cntSeqDurKeys11 + 1;
				~cntSeqDurKeys11.switch(
					0,{},
					1, {IFSeqDurKeys.st11(1);},
					2, {IFSeqDurKeys.st11(2);},
					3, {IFSeqDurKeys.st11(3);},
					4, {IFSeqDurKeys.st11(4);},
					5, {IFSeqDurKeys.st11(5);}
				)}
			);
			},
			'/ifSeq/5/11'
		);
		~ifSeqKeysBut12.free;
		~ifSeqKeysBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys12 = ~cntSeqDurKeys12 + 1;
				~cntSeqDurKeys12.switch(
					0,{},
					1, {IFSeqDurKeys.st12(1);},
					2, {IFSeqDurKeys.st12(2);},
					3, {IFSeqDurKeys.st12(3);},
					4, {IFSeqDurKeys.st12(4);},
					5, {IFSeqDurKeys.st12(5);}
				)}
			);
			},
			'/ifSeq/5/12'
		);
		~ifSeqKeysBut13.free;
		~ifSeqKeysBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys13 = ~cntSeqDurKeys13 + 1;
				~cntSeqDurKeys13.switch(
					0,{},
					1, {IFSeqDurKeys.st13(1);},
					2, {IFSeqDurKeys.st13(2);},
					3, {IFSeqDurKeys.st13(3);},
					4, {IFSeqDurKeys.st13(4);},
					5, {IFSeqDurKeys.st13(5);}
				)}
			);
			},
			'/ifSeq/5/13'
		);
		~ifSeqKeysBut14.free;
		~ifSeqKeysBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys14 = ~cntSeqDurKeys14 + 1;
				~cntSeqDurKeys14.switch(
					0,{},
					1, {IFSeqDurKeys.st14(1);},
					2, {IFSeqDurKeys.st14(2);},
					3, {IFSeqDurKeys.st14(3);},
					4, {IFSeqDurKeys.st14(4);},
					5, {IFSeqDurKeys.st14(5);}
				)}
			);
			},
			'/ifSeq/5/14'
		);
		~ifSeqKeysBut15.free;
		~ifSeqKeysBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys15 = ~cntSeqDurKeys15 + 1;
				~cntSeqDurKeys15.switch(
					0,{},
					1, {IFSeqDurKeys.st15(1);},
					2, {IFSeqDurKeys.st15(2);},
					3, {IFSeqDurKeys.st15(3);},
					4, {IFSeqDurKeys.st15(4);},
					5, {IFSeqDurKeys.st15(5);}
				)}
			);
			},
			'/ifSeq/5/15'
		);
		~ifSeqKeysBut16.free;
		~ifSeqKeysBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKeys16 = ~cntSeqDurKeys16 + 1;
				~cntSeqDurKeys16.switch(
					0,{},
					1, {IFSeqDurKeys.st16(1);},
					2, {IFSeqDurKeys.st16(2);},
					3, {IFSeqDurKeys.st16(3);},
					4, {IFSeqDurKeys.st16(4);},
					5, {IFSeqDurKeys.st16(5);}
				)}
			);
			},
			'/ifSeq/5/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys01.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys01', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys01.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys01', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys01.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys01', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys01.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys01', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys01', '1.5');
			~cntSeqDurKeys01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys02.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys02', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys02.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys02', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys02.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys02', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys02.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys02', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys02', '1.5');
			~cntSeqDurKeys02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys03.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys03', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys03.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys03', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys03.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys03', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys03.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys03', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys03', '1.5');
			~cntSeqDurKeys03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys04.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys04', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys04.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys04', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys04.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys04', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys04.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys04', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys04', '1.5');
			~cntSeqDurKeys04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys05.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys05', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys05.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys05', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys05.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys05', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys05.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys05', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys05', '1.5');
			~cntSeqDurKeys05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys06.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys06', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys06.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys06', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys06.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys06', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys06.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys06', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys06', '1.5');
			~cntSeqDurKeys06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys07.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys07', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys07.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys07', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys07.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys07', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys07.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys07', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys07', '1.5');
			~cntSeqDurKeys07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys08.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys08', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys08.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys08', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys08.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys08', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys08.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys08', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys08', '1.5');
			~cntSeqDurKeys08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys09.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys09', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys09.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys09', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys09.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys09', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys09.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys09', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys09', '1.5');
			~cntSeqDurKeys09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys10.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys10', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys10.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys10', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys10.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys10', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys10.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys10', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys10', '1.5');
			~cntSeqDurKeys10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys11.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys11', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys11.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys11', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys11.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys11', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys11.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys11', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys11', '1.5');
			~cntSeqDurKeys11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys12.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys12', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys12.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys12', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys12.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys12', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys12.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys12', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys12', '1.5');
			~cntSeqDurKeys12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys13.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys13', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys13.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys13', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys13.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys13', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys13.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys13', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys13', '1.5');
			~cntSeqDurKeys13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys14.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys14', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys14.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys14', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys14.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys14', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys14.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys14', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys14', '1.5');
			~cntSeqDurKeys14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys15.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys15', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys15.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys15', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys15.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys15', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys15.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys15', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys15', '1.5');
			~cntSeqDurKeys15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqDurKeys16.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKeys16', '1/4');
		}
		{ i == 2 }  {
			~seqDurKeys16.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKeys16', '1/3');
		}
		{ i == 3 }  {
			~seqDurKeys16.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKeys16', '1/2');
		}
		{ i == 4 }  {
			~seqDurKeys16.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKeys16', '1/1');
		}
		{ i == 5 }  {
			~seqDurKeys16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKeys16', '1.5');
			~cntSeqDurKeys16=0;
		}
	}
	*stGrp {|i|
		IFSeqDurKeys.st01(i); IFSeqDurKeys.st02(i); IFSeqDurKeys.st03(i); IFSeqDurKeys.st04(i);
		IFSeqDurKeys.st05(i); IFSeqDurKeys.st06(i); IFSeqDurKeys.st07(i); IFSeqDurKeys.st08(i);
		IFSeqDurKeys.st09(i); IFSeqDurKeys.st10(i); IFSeqDurKeys.st11(i); IFSeqDurKeys.st12(i);
		IFSeqDurKeys.st13(i); IFSeqDurKeys.st14(i); IFSeqDurKeys.st15(i); IFSeqDurKeys.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqDurKeys.st01(s01); IFSeqDurKeys.st02(s02); IFSeqDurKeys.st03(s03); IFSeqDurKeys.st04(s04);
		IFSeqDurKeys.st05(s05); IFSeqDurKeys.st06(s06); IFSeqDurKeys.st07(s07); IFSeqDurKeys.st08(s08);
		IFSeqDurKeys.st09(s09); IFSeqDurKeys.st10(s10); IFSeqDurKeys.st11(s11); IFSeqDurKeys.st12(s12);
		IFSeqDurKeys.st13(s13); IFSeqDurKeys.st14(s14); IFSeqDurKeys.st15(s15); IFSeqDurKeys.st16(s16);
	}
}