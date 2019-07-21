IFSeqSusKick2 {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqSusKick2_01 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick2_02 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick2_03 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick2_04 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick2_05 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick2_06 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick2_07 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick2_08 = PatternProxy( Pseq([0.5], 1));

		~seqSusKick2_09 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick2_10 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick2_11 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick2_12 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick2_13 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick2_14 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick2_15 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick2_16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqSusUpKick2_01=0;
		~cntSeqSusRandKick2_01=0;

		~cntSeqSusKick2_01=0;
		~cntSeqSusKick2_02=0;
		~cntSeqSusKick2_03=0;
		~cntSeqSusKick2_04=0;
		~cntSeqSusKick2_05=0;
		~cntSeqSusKick2_06=0;
		~cntSeqSusKick2_07=0;
		~cntSeqSusKick2_08=0;

		~cntSeqSusKick2_09=0;
		~cntSeqSusKick2_10=0;
		~cntSeqSusKick2_11=0;
		~cntSeqSusKick2_12=0;
		~cntSeqSusKick2_13=0;
		~cntSeqSusKick2_14=0;
		~cntSeqSusKick2_15=0;
		~cntSeqSusKick2_16=0;
	}
	*freeOn {
		~seqFreeKick2But.free;
		~seqFreeKick2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSusKick2.stGrp(1);
				});
			},
			'/seqFreeKick'
		);
	}
	*upOn {
		~ifSeqUpKick2But.free;
		~ifSeqUpKick2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusUpKick2_01 = ~cntSeqSusUpKick2_01 + 1;
				~cntSeqSusUpKick2_01.switch(
					0,{},
					1,{IFSeqSusKick2.stGrp(1);},
					2,{IFSeqSusKick2.stGrp(2);},
					3,{IFSeqSusKick2.stGrp(3);
						~cntSeqSusUpKick2_01=0;
					}
				)}
			);
			},
			'/seqUpKick'
		);
	}

	*randOn {
		~ifSeqRandKick2But.free;
		~ifSeqRandKick2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusRandKick2_01 = ~cntSeqSusRandKick2_01 + 1;
				~cntSeqSusRandKick2_01.switch(
					0,{},
					1,{
						IFSeqSusKick2.st01([1,2,3,4,5].choose);
						IFSeqSusKick2.st02([1,2,3,4,5].choose);
						IFSeqSusKick2.st03([1,2,3,4,5].choose);
						IFSeqSusKick2.st04([1,2,3,4,5].choose);
						IFSeqSusKick2.st05([1,2,3,4,5].choose);
						IFSeqSusKick2.st06([1,2,3,4,5].choose);
						IFSeqSusKick2.st07([1,2,3,4,5].choose);
						IFSeqSusKick2.st08([1,2,3,4,5].choose);

						IFSeqSusKick2.st09([1,2,3,4,5].choose);
						IFSeqSusKick2.st10([1,2,3,4,5].choose);
						IFSeqSusKick2.st11([1,2,3,4,5].choose);
						IFSeqSusKick2.st12([1,2,3,4,5].choose);
						IFSeqSusKick2.st13([1,2,3,4,5].choose);
						IFSeqSusKick2.st14([1,2,3,4,5].choose);
						IFSeqSusKick2.st15([1,2,3,4,5].choose);
						IFSeqSusKick2.st16([1,2,3,4,5].choose);
						~cntSeqSusRandKick2_01=0;
					}
				)}
			);
			},
			'/seqRandKick'
		);
	}


	*on { // Shift Susocity

		IFSeqSusKick2.randOn;
		IFSeqSusKick2.upOn;
		IFSeqSusKick2.freeOn;

		~ifSeqKick2But01.free;
		~ifSeqKick2But01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_01 = ~cntSeqSusKick2_01 + 1;
				~cntSeqSusKick2_01.switch(
					0,{},
					1, {IFSeqSusKick2.st01(1);},
					2, {IFSeqSusKick2.st01(2);},
					3, {IFSeqSusKick2.st01(3);},
					4, {IFSeqSusKick2.st01(4);},
					5, {IFSeqSusKick2.st01(5);}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqKick2But02.free;
		~ifSeqKick2But02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_02 = ~cntSeqSusKick2_02 + 1;
				~cntSeqSusKick2_02.switch(
					0,{},
					1, {IFSeqSusKick2.st02(1);},
					2, {IFSeqSusKick2.st02(2);},
					3, {IFSeqSusKick2.st02(3);},
					4, {IFSeqSusKick2.st02(4);},
					5, {IFSeqSusKick2.st02(5);}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqKick2But03.free;
		~ifSeqKick2But03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_03 = ~cntSeqSusKick2_03 + 1;
				~cntSeqSusKick2_03.switch(
					0,{},
					1, {IFSeqSusKick2.st03(1);},
					2, {IFSeqSusKick2.st03(2);},
					3, {IFSeqSusKick2.st03(3);},
					4, {IFSeqSusKick2.st03(4);},
					5, {IFSeqSusKick2.st03(5);}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqKick2But04.free;
		~ifSeqKick2But04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_04 = ~cntSeqSusKick2_04 + 1;
				~cntSeqSusKick2_04.switch(
					0,{},
					1, {IFSeqSusKick2.st04(1);},
					2, {IFSeqSusKick2.st04(2);},
					3, {IFSeqSusKick2.st04(3);},
					4, {IFSeqSusKick2.st04(4);},
					5, {IFSeqSusKick2.st04(5);}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqKick2But05.free;
		~ifSeqKick2But05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_05 = ~cntSeqSusKick2_05 + 1;
				~cntSeqSusKick2_05.switch(
					0,{},
					1, {IFSeqSusKick2.st05(1);},
					2, {IFSeqSusKick2.st05(2);},
					3, {IFSeqSusKick2.st05(3);},
					4, {IFSeqSusKick2.st05(4);},
					5, {IFSeqSusKick2.st05(5);}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqKick2But06.free;
		~ifSeqKick2But06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_06 = ~cntSeqSusKick2_06 + 1;
				~cntSeqSusKick2_06.switch(
					0,{},
					1, {IFSeqSusKick2.st06(1);},
					2, {IFSeqSusKick2.st06(2);},
					3, {IFSeqSusKick2.st06(3);},
					4, {IFSeqSusKick2.st06(4);},
					5, {IFSeqSusKick2.st06(5);}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqKick2But07.free;
		~ifSeqKick2But07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_07 = ~cntSeqSusKick2_07 + 1;
				~cntSeqSusKick2_07.switch(
					0,{},
					1, {IFSeqSusKick2.st07(1);},
					2, {IFSeqSusKick2.st07(2);},
					3, {IFSeqSusKick2.st07(3);},
					4, {IFSeqSusKick2.st07(4);},
					5, {IFSeqSusKick2.st07(5);}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqKick2But08.free;
		~ifSeqKick2But08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_08 = ~cntSeqSusKick2_08 + 1;
				~cntSeqSusKick2_08.switch(
					0,{},
					1, {IFSeqSusKick2.st08(1);},
					2, {IFSeqSusKick2.st08(2);},
					3, {IFSeqSusKick2.st08(3);},
					4, {IFSeqSusKick2.st08(4);},
					5, {IFSeqSusKick2.st08(5);}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqKick2But09.free;
		~ifSeqKick2But09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_09 = ~cntSeqSusKick2_09 + 1;
				~cntSeqSusKick2_09.switch(
					0,{},
					1, {IFSeqSusKick2.st09(1);},
					2, {IFSeqSusKick2.st09(2);},
					3, {IFSeqSusKick2.st09(3);},
					4, {IFSeqSusKick2.st09(4);},
					5, {IFSeqSusKick2.st09(5);}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqKick2But10.free;
		~ifSeqKick2But10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_10 = ~cntSeqSusKick2_10 + 1;
				~cntSeqSusKick2_10.switch(
					0,{},
					1, {IFSeqSusKick2.st10(1);},
					2, {IFSeqSusKick2.st10(2);},
					3, {IFSeqSusKick2.st10(3);},
					4, {IFSeqSusKick2.st10(4);},
					5, {IFSeqSusKick2.st10(5);}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqKick2But11.free;
		~ifSeqKick2But11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_11 = ~cntSeqSusKick2_11 + 1;
				~cntSeqSusKick2_11.switch(
					0,{},
					1, {IFSeqSusKick2.st11(1);},
					2, {IFSeqSusKick2.st11(2);},
					3, {IFSeqSusKick2.st11(3);},
					4, {IFSeqSusKick2.st11(4);},
					5, {IFSeqSusKick2.st11(5);}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqKick2But12.free;
		~ifSeqKick2But12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_12 = ~cntSeqSusKick2_12 + 1;
				~cntSeqSusKick2_12.switch(
					0,{},
					1, {IFSeqSusKick2.st12(1);},
					2, {IFSeqSusKick2.st12(2);},
					3, {IFSeqSusKick2.st12(3);},
					4, {IFSeqSusKick2.st12(4);},
					5, {IFSeqSusKick2.st12(5);}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqKick2But13.free;
		~ifSeqKick2But13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_13 = ~cntSeqSusKick2_13 + 1;
				~cntSeqSusKick2_13.switch(
					0,{},
					1, {IFSeqSusKick2.st13(1);},
					2, {IFSeqSusKick2.st13(2);},
					3, {IFSeqSusKick2.st13(3);},
					4, {IFSeqSusKick2.st13(4);},
					5, {IFSeqSusKick2.st13(5);}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqKick2But14.free;
		~ifSeqKick2But14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_14 = ~cntSeqSusKick2_14 + 1;
				~cntSeqSusKick2_14.switch(
					0,{},
					1, {IFSeqSusKick2.st14(1);},
					2, {IFSeqSusKick2.st14(2);},
					3, {IFSeqSusKick2.st14(3);},
					4, {IFSeqSusKick2.st14(4);},
					5, {IFSeqSusKick2.st14(5);}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqKick2But15.free;
		~ifSeqKick2But15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_15 = ~cntSeqSusKick2_15 + 1;
				~cntSeqSusKick2_15.switch(
					0,{},
					1, {IFSeqSusKick2.st15(1);},
					2, {IFSeqSusKick2.st15(2);},
					3, {IFSeqSusKick2.st15(3);},
					4, {IFSeqSusKick2.st15(4);},
					5, {IFSeqSusKick2.st15(5);}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqKick2But16.free;
		~ifSeqKick2But16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick2_16 = ~cntSeqSusKick2_16 + 1;
				~cntSeqSusKick2_16.switch(
					0,{},
					1, {IFSeqSusKick2.st16(1);},
					2, {IFSeqSusKick2.st16(2);},
					3, {IFSeqSusKick2.st16(3);},
					4, {IFSeqSusKick2.st16(4);},
					5, {IFSeqSusKick2.st16(5);}
				)}
			);
			},
			'/ifSeq/2/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_01', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_01', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_01', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_01.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_01', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_01', '5');
			~cntSeqSusKick2_01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_02', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_02', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_02', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_02.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_02', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_02', '5');
			~cntSeqSusKick2_02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_03', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_03', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_03', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_03.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_03', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_03', '5');
			~cntSeqSusKick2_03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_04', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_04', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_04', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_04.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_04', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_04', '5');
			~cntSeqSusKick2_04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_05', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_05', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_05', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_05.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_05', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_05', '5');
			~cntSeqSusKick2_05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_06', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_06', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_06', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_06.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_06', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_06', '5');
			~cntSeqSusKick2_06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_07', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_07', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_07', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_07.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_07', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_07', '5');
			~cntSeqSusKick2_07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_08', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_08', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_08', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_08.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_08', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_08', '5');
			~cntSeqSusKick2_08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_09', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_09', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_09', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_09.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_09', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_09', '5');
			~cntSeqSusKick2_09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_10', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_10', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_10', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_10.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_10', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_10', '5');
			~cntSeqSusKick2_10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_11', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_11', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_11', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_11.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_11', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_11', '5');
			~cntSeqSusKick2_11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_12', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_12', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_12', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_12.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_12', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_12', '5');
			~cntSeqSusKick2_12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_13', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_13', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_13', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_13.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_13', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_13', '5');
			~cntSeqSusKick2_13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_14', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_14', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_14', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_14.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_14', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_14', '5');
			~cntSeqSusKick2_14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_15', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_15', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_15', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_15.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_15', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_15', '5');
			~cntSeqSusKick2_15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqSusKick2_16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_16', '1');
		}
		{ i == 2 }  {
			~seqSusKick2_16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick2_16', '2');
		}
		{ i == 3 }  {
			~seqSusKick2_16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick2_16', '3');
		}
		{ i == 4 }  {
			~seqSusKick2_16.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick2_16', '4');
		}
		{ i == 5 }  {
			~seqSusKick2_16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick2_16', '5');
			~cntSeqSusKick2_16=0;
		}
	}
	*stGrp {|i|
		IFSeqSusKick2.st01(i); IFSeqSusKick2.st02(i); IFSeqSusKick2.st03(i); IFSeqSusKick2.st04(i);
		IFSeqSusKick2.st05(i); IFSeqSusKick2.st06(i); IFSeqSusKick2.st07(i); IFSeqSusKick2.st08(i);
		IFSeqSusKick2.st09(i); IFSeqSusKick2.st10(i); IFSeqSusKick2.st11(i); IFSeqSusKick2.st12(i);
		IFSeqSusKick2.st13(i); IFSeqSusKick2.st14(i); IFSeqSusKick2.st15(i); IFSeqSusKick2.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqSusKick2.st01(s01); IFSeqSusKick2.st02(s02); IFSeqSusKick2.st03(s03); IFSeqSusKick2.st04(s04);
		IFSeqSusKick2.st05(s05); IFSeqSusKick2.st06(s06); IFSeqSusKick2.st07(s07); IFSeqSusKick2.st08(s08);
		IFSeqSusKick2.st09(s09); IFSeqSusKick2.st10(s10); IFSeqSusKick2.st11(s11); IFSeqSusKick2.st12(s12);
		IFSeqSusKick2.st13(s13); IFSeqSusKick2.st14(s14); IFSeqSusKick2.st15(s15); IFSeqSusKick2.st16(s16);
	}
}