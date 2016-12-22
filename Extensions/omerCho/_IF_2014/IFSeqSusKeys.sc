IFSeqSusKeys {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqSusKeys01 = PatternProxy( Pseq([0.5], 1));
		~seqSusKeys02 = PatternProxy( Pseq([0.5], 1));
		~seqSusKeys03 = PatternProxy( Pseq([0.5], 1));
		~seqSusKeys04 = PatternProxy( Pseq([0.5], 1));
		~seqSusKeys05 = PatternProxy( Pseq([0.5], 1));
		~seqSusKeys06 = PatternProxy( Pseq([0.5], 1));
		~seqSusKeys07 = PatternProxy( Pseq([0.5], 1));
		~seqSusKeys08 = PatternProxy( Pseq([0.5], 1));

		~seqSusKeys09 = PatternProxy( Pseq([0.5], 1));
		~seqSusKeys10 = PatternProxy( Pseq([0.5], 1));
		~seqSusKeys11 = PatternProxy( Pseq([0.5], 1));
		~seqSusKeys12 = PatternProxy( Pseq([0.5], 1));
		~seqSusKeys13 = PatternProxy( Pseq([0.5], 1));
		~seqSusKeys14 = PatternProxy( Pseq([0.5], 1));
		~seqSusKeys15 = PatternProxy( Pseq([0.5], 1));
		~seqSusKeys16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqSusUpKeys01=0;
		~cntSeqSusRandKeys01=0;

		~cntSeqSusKeys01=0;
		~cntSeqSusKeys02=0;
		~cntSeqSusKeys03=0;
		~cntSeqSusKeys04=0;
		~cntSeqSusKeys05=0;
		~cntSeqSusKeys06=0;
		~cntSeqSusKeys07=0;
		~cntSeqSusKeys08=0;

		~cntSeqSusKeys09=0;
		~cntSeqSusKeys10=0;
		~cntSeqSusKeys11=0;
		~cntSeqSusKeys12=0;
		~cntSeqSusKeys13=0;
		~cntSeqSusKeys14=0;
		~cntSeqSusKeys15=0;
		~cntSeqSusKeys16=0;
	}
	*freeOn {
		~seqFreeKeysBut.free;
		~seqFreeKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSusKeys.stGrp(1);
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
				~cntSeqSusUpKeys01 = ~cntSeqSusUpKeys01 + 1;
				~cntSeqSusUpKeys01.switch(
					0,{},
					1,{IFSeqSusKeys.stGrp(1);},
					2,{IFSeqSusKeys.stGrp(2);},
					3,{IFSeqSusKeys.stGrp(3);
						~cntSeqSusUpKeys01=0;
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
				~cntSeqSusRandKeys01 = ~cntSeqSusRandKeys01 + 1;
				~cntSeqSusRandKeys01.switch(
					0,{},
					1,{
						IFSeqSusKeys.st01([1,2,3,4,5].choose);
						IFSeqSusKeys.st02([1,2,3,4,5].choose);
						IFSeqSusKeys.st03([1,2,3,4,5].choose);
						IFSeqSusKeys.st04([1,2,3,4,5].choose);
						IFSeqSusKeys.st05([1,2,3,4,5].choose);
						IFSeqSusKeys.st06([1,2,3,4,5].choose);
						IFSeqSusKeys.st07([1,2,3,4,5].choose);
						IFSeqSusKeys.st08([1,2,3,4,5].choose);

						IFSeqSusKeys.st09([1,2,3,4,5].choose);
						IFSeqSusKeys.st10([1,2,3,4,5].choose);
						IFSeqSusKeys.st11([1,2,3,4,5].choose);
						IFSeqSusKeys.st12([1,2,3,4,5].choose);
						IFSeqSusKeys.st13([1,2,3,4,5].choose);
						IFSeqSusKeys.st14([1,2,3,4,5].choose);
						IFSeqSusKeys.st15([1,2,3,4,5].choose);
						IFSeqSusKeys.st16([1,2,3,4,5].choose);
						~cntSeqSusRandKeys01=0;
					}
				)}
			);
			},
			'/seqRandKeys'
		);
	}


	*on { // Shift Susocity

		IFSeqSusKeys.randOn;
		IFSeqSusKeys.upOn;
		IFSeqSusKeys.freeOn;

		~ifSeqKeysBut01.free;
		~ifSeqKeysBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys01 = ~cntSeqSusKeys01 + 1;
				~cntSeqSusKeys01.switch(
					0,{},
					1, {IFSeqSusKeys.st01(1);},
					2, {IFSeqSusKeys.st01(2);},
					3, {IFSeqSusKeys.st01(3);},
					4, {IFSeqSusKeys.st01(4);},
					5, {IFSeqSusKeys.st01(5);}
				)}
			);
			},
			'/ifSeq/5/1'
		);
		~ifSeqKeysBut02.free;
		~ifSeqKeysBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys02 = ~cntSeqSusKeys02 + 1;
				~cntSeqSusKeys02.switch(
					0,{},
					1, {IFSeqSusKeys.st02(1);},
					2, {IFSeqSusKeys.st02(2);},
					3, {IFSeqSusKeys.st02(3);},
					4, {IFSeqSusKeys.st02(4);},
					5, {IFSeqSusKeys.st02(5);}
				)}
			);
			},
			'/ifSeq/5/2'
		);
		~ifSeqKeysBut03.free;
		~ifSeqKeysBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys03 = ~cntSeqSusKeys03 + 1;
				~cntSeqSusKeys03.switch(
					0,{},
					1, {IFSeqSusKeys.st03(1);},
					2, {IFSeqSusKeys.st03(2);},
					3, {IFSeqSusKeys.st03(3);},
					4, {IFSeqSusKeys.st03(4);},
					5, {IFSeqSusKeys.st03(5);}
				)}
			);
			},
			'/ifSeq/5/3'
		);
		~ifSeqKeysBut04.free;
		~ifSeqKeysBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys04 = ~cntSeqSusKeys04 + 1;
				~cntSeqSusKeys04.switch(
					0,{},
					1, {IFSeqSusKeys.st04(1);},
					2, {IFSeqSusKeys.st04(2);},
					3, {IFSeqSusKeys.st04(3);},
					4, {IFSeqSusKeys.st04(4);},
					5, {IFSeqSusKeys.st04(5);}
				)}
			);
			},
			'/ifSeq/5/4'
		);
		~ifSeqKeysBut05.free;
		~ifSeqKeysBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys05 = ~cntSeqSusKeys05 + 1;
				~cntSeqSusKeys05.switch(
					0,{},
					1, {IFSeqSusKeys.st05(1);},
					2, {IFSeqSusKeys.st05(2);},
					3, {IFSeqSusKeys.st05(3);},
					4, {IFSeqSusKeys.st05(4);},
					5, {IFSeqSusKeys.st05(5);}
				)}
			);
			},
			'/ifSeq/5/5'
		);
		~ifSeqKeysBut06.free;
		~ifSeqKeysBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys06 = ~cntSeqSusKeys06 + 1;
				~cntSeqSusKeys06.switch(
					0,{},
					1, {IFSeqSusKeys.st06(1);},
					2, {IFSeqSusKeys.st06(2);},
					3, {IFSeqSusKeys.st06(3);},
					4, {IFSeqSusKeys.st06(4);},
					5, {IFSeqSusKeys.st06(5);}
				)}
			);
			},
			'/ifSeq/5/6'
		);
		~ifSeqKeysBut07.free;
		~ifSeqKeysBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys07 = ~cntSeqSusKeys07 + 1;
				~cntSeqSusKeys07.switch(
					0,{},
					1, {IFSeqSusKeys.st07(1);},
					2, {IFSeqSusKeys.st07(2);},
					3, {IFSeqSusKeys.st07(3);},
					4, {IFSeqSusKeys.st07(4);},
					5, {IFSeqSusKeys.st07(5);}
				)}
			);
			},
			'/ifSeq/5/7'
		);
		~ifSeqKeysBut08.free;
		~ifSeqKeysBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys08 = ~cntSeqSusKeys08 + 1;
				~cntSeqSusKeys08.switch(
					0,{},
					1, {IFSeqSusKeys.st08(1);},
					2, {IFSeqSusKeys.st08(2);},
					3, {IFSeqSusKeys.st08(3);},
					4, {IFSeqSusKeys.st08(4);},
					5, {IFSeqSusKeys.st08(5);}
				)}
			);
			},
			'/ifSeq/5/8'
		);

		~ifSeqKeysBut09.free;
		~ifSeqKeysBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys09 = ~cntSeqSusKeys09 + 1;
				~cntSeqSusKeys09.switch(
					0,{},
					1, {IFSeqSusKeys.st09(1);},
					2, {IFSeqSusKeys.st09(2);},
					3, {IFSeqSusKeys.st09(3);},
					4, {IFSeqSusKeys.st09(4);},
					5, {IFSeqSusKeys.st09(5);}
				)}
			);
			},
			'/ifSeq/5/9'
		);
		~ifSeqKeysBut10.free;
		~ifSeqKeysBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys10 = ~cntSeqSusKeys10 + 1;
				~cntSeqSusKeys10.switch(
					0,{},
					1, {IFSeqSusKeys.st10(1);},
					2, {IFSeqSusKeys.st10(2);},
					3, {IFSeqSusKeys.st10(3);},
					4, {IFSeqSusKeys.st10(4);},
					5, {IFSeqSusKeys.st10(5);}
				)}
			);
			},
			'/ifSeq/5/10'
		);
		~ifSeqKeysBut11.free;
		~ifSeqKeysBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys11 = ~cntSeqSusKeys11 + 1;
				~cntSeqSusKeys11.switch(
					0,{},
					1, {IFSeqSusKeys.st11(1);},
					2, {IFSeqSusKeys.st11(2);},
					3, {IFSeqSusKeys.st11(3);},
					4, {IFSeqSusKeys.st11(4);},
					5, {IFSeqSusKeys.st11(5);}
				)}
			);
			},
			'/ifSeq/5/11'
		);
		~ifSeqKeysBut12.free;
		~ifSeqKeysBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys12 = ~cntSeqSusKeys12 + 1;
				~cntSeqSusKeys12.switch(
					0,{},
					1, {IFSeqSusKeys.st12(1);},
					2, {IFSeqSusKeys.st12(2);},
					3, {IFSeqSusKeys.st12(3);},
					4, {IFSeqSusKeys.st12(4);},
					5, {IFSeqSusKeys.st12(5);}
				)}
			);
			},
			'/ifSeq/5/12'
		);
		~ifSeqKeysBut13.free;
		~ifSeqKeysBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys13 = ~cntSeqSusKeys13 + 1;
				~cntSeqSusKeys13.switch(
					0,{},
					1, {IFSeqSusKeys.st13(1);},
					2, {IFSeqSusKeys.st13(2);},
					3, {IFSeqSusKeys.st13(3);},
					4, {IFSeqSusKeys.st13(4);},
					5, {IFSeqSusKeys.st13(5);}
				)}
			);
			},
			'/ifSeq/5/13'
		);
		~ifSeqKeysBut14.free;
		~ifSeqKeysBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys14 = ~cntSeqSusKeys14 + 1;
				~cntSeqSusKeys14.switch(
					0,{},
					1, {IFSeqSusKeys.st14(1);},
					2, {IFSeqSusKeys.st14(2);},
					3, {IFSeqSusKeys.st14(3);},
					4, {IFSeqSusKeys.st14(4);},
					5, {IFSeqSusKeys.st14(5);}
				)}
			);
			},
			'/ifSeq/5/14'
		);
		~ifSeqKeysBut15.free;
		~ifSeqKeysBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys15 = ~cntSeqSusKeys15 + 1;
				~cntSeqSusKeys15.switch(
					0,{},
					1, {IFSeqSusKeys.st15(1);},
					2, {IFSeqSusKeys.st15(2);},
					3, {IFSeqSusKeys.st15(3);},
					4, {IFSeqSusKeys.st15(4);},
					5, {IFSeqSusKeys.st15(5);}
				)}
			);
			},
			'/ifSeq/5/15'
		);
		~ifSeqKeysBut16.free;
		~ifSeqKeysBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKeys16 = ~cntSeqSusKeys16 + 1;
				~cntSeqSusKeys16.switch(
					0,{},
					1, {IFSeqSusKeys.st16(1);},
					2, {IFSeqSusKeys.st16(2);},
					3, {IFSeqSusKeys.st16(3);},
					4, {IFSeqSusKeys.st16(4);},
					5, {IFSeqSusKeys.st16(5);}
				)}
			);
			},
			'/ifSeq/5/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys01', '1');
		}
		{ i == 2 }  {
			~seqSusKeys01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys01', '2');
		}
		{ i == 3 }  {
			~seqSusKeys01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys01', '3');
		}
		{ i == 4 }  {
			~seqSusKeys01.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys01', '4');
		}
		{ i == 5 }  {
			~seqSusKeys01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys01', '5');
			~cntSeqSusKeys01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys02', '1');
		}
		{ i == 2 }  {
			~seqSusKeys02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys02', '2');
		}
		{ i == 3 }  {
			~seqSusKeys02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys02', '3');
		}
		{ i == 4 }  {
			~seqSusKeys02.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys02', '4');
		}
		{ i == 5 }  {
			~seqSusKeys02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys02', '5');
			~cntSeqSusKeys02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys03', '1');
		}
		{ i == 2 }  {
			~seqSusKeys03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys03', '2');
		}
		{ i == 3 }  {
			~seqSusKeys03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys03', '3');
		}
		{ i == 4 }  {
			~seqSusKeys03.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys03', '4');
		}
		{ i == 5 }  {
			~seqSusKeys03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys03', '5');
			~cntSeqSusKeys03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys04', '1');
		}
		{ i == 2 }  {
			~seqSusKeys04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys04', '2');
		}
		{ i == 3 }  {
			~seqSusKeys04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys04', '3');
		}
		{ i == 4 }  {
			~seqSusKeys04.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys04', '4');
		}
		{ i == 5 }  {
			~seqSusKeys04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys04', '5');
			~cntSeqSusKeys04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys05', '1');
		}
		{ i == 2 }  {
			~seqSusKeys05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys05', '2');
		}
		{ i == 3 }  {
			~seqSusKeys05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys05', '3');
		}
		{ i == 4 }  {
			~seqSusKeys05.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys05', '4');
		}
		{ i == 5 }  {
			~seqSusKeys05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys05', '5');
			~cntSeqSusKeys05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys06', '1');
		}
		{ i == 2 }  {
			~seqSusKeys06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys06', '2');
		}
		{ i == 3 }  {
			~seqSusKeys06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys06', '3');
		}
		{ i == 4 }  {
			~seqSusKeys06.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys06', '4');
		}
		{ i == 5 }  {
			~seqSusKeys06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys06', '5');
			~cntSeqSusKeys06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys07', '1');
		}
		{ i == 2 }  {
			~seqSusKeys07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys07', '2');
		}
		{ i == 3 }  {
			~seqSusKeys07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys07', '3');
		}
		{ i == 4 }  {
			~seqSusKeys07.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys07', '4');
		}
		{ i == 5 }  {
			~seqSusKeys07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys07', '5');
			~cntSeqSusKeys07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys08', '1');
		}
		{ i == 2 }  {
			~seqSusKeys08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys08', '2');
		}
		{ i == 3 }  {
			~seqSusKeys08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys08', '3');
		}
		{ i == 4 }  {
			~seqSusKeys08.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys08', '4');
		}
		{ i == 5 }  {
			~seqSusKeys08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys08', '5');
			~cntSeqSusKeys08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys09', '1');
		}
		{ i == 2 }  {
			~seqSusKeys09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys09', '2');
		}
		{ i == 3 }  {
			~seqSusKeys09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys09', '3');
		}
		{ i == 4 }  {
			~seqSusKeys09.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys09', '4');
		}
		{ i == 5 }  {
			~seqSusKeys09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys09', '5');
			~cntSeqSusKeys09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys10', '1');
		}
		{ i == 2 }  {
			~seqSusKeys10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys10', '2');
		}
		{ i == 3 }  {
			~seqSusKeys10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys10', '3');
		}
		{ i == 4 }  {
			~seqSusKeys10.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys10', '4');
		}
		{ i == 5 }  {
			~seqSusKeys10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys10', '5');
			~cntSeqSusKeys10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys11', '1');
		}
		{ i == 2 }  {
			~seqSusKeys11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys11', '2');
		}
		{ i == 3 }  {
			~seqSusKeys11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys11', '3');
		}
		{ i == 4 }  {
			~seqSusKeys11.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys11', '4');
		}
		{ i == 5 }  {
			~seqSusKeys11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys11', '5');
			~cntSeqSusKeys11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys12', '1');
		}
		{ i == 2 }  {
			~seqSusKeys12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys12', '2');
		}
		{ i == 3 }  {
			~seqSusKeys12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys12', '3');
		}
		{ i == 4 }  {
			~seqSusKeys12.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys12', '4');
		}
		{ i == 5 }  {
			~seqSusKeys12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys12', '5');
			~cntSeqSusKeys12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys13', '1');
		}
		{ i == 2 }  {
			~seqSusKeys13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys13', '2');
		}
		{ i == 3 }  {
			~seqSusKeys13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys13', '3');
		}
		{ i == 4 }  {
			~seqSusKeys13.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys13', '4');
		}
		{ i == 5 }  {
			~seqSusKeys13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys13', '5');
			~cntSeqSusKeys13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys14', '1');
		}
		{ i == 2 }  {
			~seqSusKeys14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys14', '2');
		}
		{ i == 3 }  {
			~seqSusKeys14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys14', '3');
		}
		{ i == 4 }  {
			~seqSusKeys14.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys14', '4');
		}
		{ i == 5 }  {
			~seqSusKeys14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys14', '5');
			~cntSeqSusKeys14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys15', '1');
		}
		{ i == 2 }  {
			~seqSusKeys15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys15', '2');
		}
		{ i == 3 }  {
			~seqSusKeys15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys15', '3');
		}
		{ i == 4 }  {
			~seqSusKeys15.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys15', '4');
		}
		{ i == 5 }  {
			~seqSusKeys15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys15', '5');
			~cntSeqSusKeys15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqSusKeys16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys16', '1');
		}
		{ i == 2 }  {
			~seqSusKeys16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKeys16', '2');
		}
		{ i == 3 }  {
			~seqSusKeys16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKeys16', '3');
		}
		{ i == 4 }  {
			~seqSusKeys16.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKeys16', '4');
		}
		{ i == 5 }  {
			~seqSusKeys16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKeys16', '5');
			~cntSeqSusKeys16=0;
		}
	}
	*stGrp {|i|
		IFSeqSusKeys.st01(i); IFSeqSusKeys.st02(i); IFSeqSusKeys.st03(i); IFSeqSusKeys.st04(i);
		IFSeqSusKeys.st05(i); IFSeqSusKeys.st06(i); IFSeqSusKeys.st07(i); IFSeqSusKeys.st08(i);
		IFSeqSusKeys.st09(i); IFSeqSusKeys.st10(i); IFSeqSusKeys.st11(i); IFSeqSusKeys.st12(i);
		IFSeqSusKeys.st13(i); IFSeqSusKeys.st14(i); IFSeqSusKeys.st15(i); IFSeqSusKeys.st16(i);
	}
}