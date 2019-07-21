IFSeqSusHat2 {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqSusHat2_01 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat2_02 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat2_03 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat2_04 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat2_05 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat2_06 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat2_07 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat2_08 = PatternProxy( Pseq([0.5], 1));

		~seqSusHat2_09 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat2_10 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat2_11 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat2_12 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat2_13 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat2_14 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat2_15 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat2_16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqSusUpHat2_01=0;
		~cntSeqSusRandHat2_01=0;

		~cntSeqSusHat2_01=0;
		~cntSeqSusHat2_02=0;
		~cntSeqSusHat2_03=0;
		~cntSeqSusHat2_04=0;
		~cntSeqSusHat2_05=0;
		~cntSeqSusHat2_06=0;
		~cntSeqSusHat2_07=0;
		~cntSeqSusHat2_08=0;

		~cntSeqSusHat2_09=0;
		~cntSeqSusHat2_10=0;
		~cntSeqSusHat2_11=0;
		~cntSeqSusHat2_12=0;
		~cntSeqSusHat2_13=0;
		~cntSeqSusHat2_14=0;
		~cntSeqSusHat2_15=0;
		~cntSeqSusHat2_16=0;
	}
	*freeOn {
		~seqFreeHat2But.free;
		~seqFreeHat2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSusHat2.stGrp(1);
				});
			},
			'/seqFreeHat'
		);
	}
	*upOn {
		~ifSeqUpHat2But.free;
		~ifSeqUpHat2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusUpHat2_01 = ~cntSeqSusUpHat2_01 + 1;
				~cntSeqSusUpHat2_01.switch(
					0,{},
					1,{IFSeqSusHat2.stGrp(1);},
					2,{IFSeqSusHat2.stGrp(2);},
					3,{IFSeqSusHat2.stGrp(3);
						~cntSeqSusUpHat2_01=0;
					}
				)}
			);
			},
			'/seqUpHat'
		);
	}

	*randOn {
		~ifSeqRandHat2But.free;
		~ifSeqRandHat2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusRandHat2_01 = ~cntSeqSusRandHat2_01 + 1;
				~cntSeqSusRandHat2_01.switch(
					0,{},
					1,{
						IFSeqSusHat2.st01([1,2,3,4,5].choose);
						IFSeqSusHat2.st02([1,2,3,4,5].choose);
						IFSeqSusHat2.st03([1,2,3,4,5].choose);
						IFSeqSusHat2.st04([1,2,3,4,5].choose);
						IFSeqSusHat2.st05([1,2,3,4,5].choose);
						IFSeqSusHat2.st06([1,2,3,4,5].choose);
						IFSeqSusHat2.st07([1,2,3,4,5].choose);
						IFSeqSusHat2.st08([1,2,3,4,5].choose);

						IFSeqSusHat2.st09([1,2,3,4,5].choose);
						IFSeqSusHat2.st10([1,2,3,4,5].choose);
						IFSeqSusHat2.st11([1,2,3,4,5].choose);
						IFSeqSusHat2.st12([1,2,3,4,5].choose);
						IFSeqSusHat2.st13([1,2,3,4,5].choose);
						IFSeqSusHat2.st14([1,2,3,4,5].choose);
						IFSeqSusHat2.st15([1,2,3,4,5].choose);
						IFSeqSusHat2.st16([1,2,3,4,5].choose);
						~cntSeqSusRandHat2_01=0;
					}
				)}
			);
			},
			'/seqRandHat'
		);
	}


	*on { // Shift Susocity

		IFSeqSusHat2.randOn;
		IFSeqSusHat2.upOn;
		IFSeqSusHat2.freeOn;

		~ifSeqHat2But01.free;
		~ifSeqHat2But01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_01 = ~cntSeqSusHat2_01 + 1;
				~cntSeqSusHat2_01.switch(
					0,{},
					1, {IFSeqSusHat2.st01(1);},
					2, {IFSeqSusHat2.st01(2);},
					3, {IFSeqSusHat2.st01(3);},
					4, {IFSeqSusHat2.st01(4);},
					5, {IFSeqSusHat2.st01(5);}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqHat2But02.free;
		~ifSeqHat2But02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_02 = ~cntSeqSusHat2_02 + 1;
				~cntSeqSusHat2_02.switch(
					0,{},
					1, {IFSeqSusHat2.st02(1);},
					2, {IFSeqSusHat2.st02(2);},
					3, {IFSeqSusHat2.st02(3);},
					4, {IFSeqSusHat2.st02(4);},
					5, {IFSeqSusHat2.st02(5);}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqHat2But03.free;
		~ifSeqHat2But03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_03 = ~cntSeqSusHat2_03 + 1;
				~cntSeqSusHat2_03.switch(
					0,{},
					1, {IFSeqSusHat2.st03(1);},
					2, {IFSeqSusHat2.st03(2);},
					3, {IFSeqSusHat2.st03(3);},
					4, {IFSeqSusHat2.st03(4);},
					5, {IFSeqSusHat2.st03(5);}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqHat2But04.free;
		~ifSeqHat2But04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_04 = ~cntSeqSusHat2_04 + 1;
				~cntSeqSusHat2_04.switch(
					0,{},
					1, {IFSeqSusHat2.st04(1);},
					2, {IFSeqSusHat2.st04(2);},
					3, {IFSeqSusHat2.st04(3);},
					4, {IFSeqSusHat2.st04(4);},
					5, {IFSeqSusHat2.st04(5);}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqHat2But05.free;
		~ifSeqHat2But05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_05 = ~cntSeqSusHat2_05 + 1;
				~cntSeqSusHat2_05.switch(
					0,{},
					1, {IFSeqSusHat2.st05(1);},
					2, {IFSeqSusHat2.st05(2);},
					3, {IFSeqSusHat2.st05(3);},
					4, {IFSeqSusHat2.st05(4);},
					5, {IFSeqSusHat2.st05(5);}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqHat2But06.free;
		~ifSeqHat2But06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_06 = ~cntSeqSusHat2_06 + 1;
				~cntSeqSusHat2_06.switch(
					0,{},
					1, {IFSeqSusHat2.st06(1);},
					2, {IFSeqSusHat2.st06(2);},
					3, {IFSeqSusHat2.st06(3);},
					4, {IFSeqSusHat2.st06(4);},
					5, {IFSeqSusHat2.st06(5);}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqHat2But07.free;
		~ifSeqHat2But07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_07 = ~cntSeqSusHat2_07 + 1;
				~cntSeqSusHat2_07.switch(
					0,{},
					1, {IFSeqSusHat2.st07(1);},
					2, {IFSeqSusHat2.st07(2);},
					3, {IFSeqSusHat2.st07(3);},
					4, {IFSeqSusHat2.st07(4);},
					5, {IFSeqSusHat2.st07(5);}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqHat2But08.free;
		~ifSeqHat2But08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_08 = ~cntSeqSusHat2_08 + 1;
				~cntSeqSusHat2_08.switch(
					0,{},
					1, {IFSeqSusHat2.st08(1);},
					2, {IFSeqSusHat2.st08(2);},
					3, {IFSeqSusHat2.st08(3);},
					4, {IFSeqSusHat2.st08(4);},
					5, {IFSeqSusHat2.st08(5);}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqHat2But09.free;
		~ifSeqHat2But09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_09 = ~cntSeqSusHat2_09 + 1;
				~cntSeqSusHat2_09.switch(
					0,{},
					1, {IFSeqSusHat2.st09(1);},
					2, {IFSeqSusHat2.st09(2);},
					3, {IFSeqSusHat2.st09(3);},
					4, {IFSeqSusHat2.st09(4);},
					5, {IFSeqSusHat2.st09(5);}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqHat2But10.free;
		~ifSeqHat2But10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_10 = ~cntSeqSusHat2_10 + 1;
				~cntSeqSusHat2_10.switch(
					0,{},
					1, {IFSeqSusHat2.st10(1);},
					2, {IFSeqSusHat2.st10(2);},
					3, {IFSeqSusHat2.st10(3);},
					4, {IFSeqSusHat2.st10(4);},
					5, {IFSeqSusHat2.st10(5);}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqHat2But11.free;
		~ifSeqHat2But11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_11 = ~cntSeqSusHat2_11 + 1;
				~cntSeqSusHat2_11.switch(
					0,{},
					1, {IFSeqSusHat2.st11(1);},
					2, {IFSeqSusHat2.st11(2);},
					3, {IFSeqSusHat2.st11(3);},
					4, {IFSeqSusHat2.st11(4);},
					5, {IFSeqSusHat2.st11(5);}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqHat2But12.free;
		~ifSeqHat2But12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_12 = ~cntSeqSusHat2_12 + 1;
				~cntSeqSusHat2_12.switch(
					0,{},
					1, {IFSeqSusHat2.st12(1);},
					2, {IFSeqSusHat2.st12(2);},
					3, {IFSeqSusHat2.st12(3);},
					4, {IFSeqSusHat2.st12(4);},
					5, {IFSeqSusHat2.st12(5);}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqHat2But13.free;
		~ifSeqHat2But13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_13 = ~cntSeqSusHat2_13 + 1;
				~cntSeqSusHat2_13.switch(
					0,{},
					1, {IFSeqSusHat2.st13(1);},
					2, {IFSeqSusHat2.st13(2);},
					3, {IFSeqSusHat2.st13(3);},
					4, {IFSeqSusHat2.st13(4);},
					5, {IFSeqSusHat2.st13(5);}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqHat2But14.free;
		~ifSeqHat2But14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_14 = ~cntSeqSusHat2_14 + 1;
				~cntSeqSusHat2_14.switch(
					0,{},
					1, {IFSeqSusHat2.st14(1);},
					2, {IFSeqSusHat2.st14(2);},
					3, {IFSeqSusHat2.st14(3);},
					4, {IFSeqSusHat2.st14(4);},
					5, {IFSeqSusHat2.st14(5);}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqHat2But15.free;
		~ifSeqHat2But15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_15 = ~cntSeqSusHat2_15 + 1;
				~cntSeqSusHat2_15.switch(
					0,{},
					1, {IFSeqSusHat2.st15(1);},
					2, {IFSeqSusHat2.st15(2);},
					3, {IFSeqSusHat2.st15(3);},
					4, {IFSeqSusHat2.st15(4);},
					5, {IFSeqSusHat2.st15(5);}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqHat2But16.free;
		~ifSeqHat2But16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat2_16 = ~cntSeqSusHat2_16 + 1;
				~cntSeqSusHat2_16.switch(
					0,{},
					1, {IFSeqSusHat2.st16(1);},
					2, {IFSeqSusHat2.st16(2);},
					3, {IFSeqSusHat2.st16(3);},
					4, {IFSeqSusHat2.st16(4);},
					5, {IFSeqSusHat2.st16(5);}
				)}
			);
			},
			'/ifSeq/2/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_01', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_01', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_01', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_01.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_01', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_01', '5');
			~cntSeqSusHat2_01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_02', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_02', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_02', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_02.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_02', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_02', '5');
			~cntSeqSusHat2_02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_03', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_03', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_03', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_03.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_03', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_03', '5');
			~cntSeqSusHat2_03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_04', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_04', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_04', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_04.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_04', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_04', '5');
			~cntSeqSusHat2_04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_05', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_05', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_05', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_05.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_05', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_05', '5');
			~cntSeqSusHat2_05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_06', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_06', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_06', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_06.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_06', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_06', '5');
			~cntSeqSusHat2_06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_07', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_07', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_07', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_07.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_07', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_07', '5');
			~cntSeqSusHat2_07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_08', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_08', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_08', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_08.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_08', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_08', '5');
			~cntSeqSusHat2_08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_09', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_09', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_09', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_09.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_09', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_09', '5');
			~cntSeqSusHat2_09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_10', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_10', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_10', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_10.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_10', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_10', '5');
			~cntSeqSusHat2_10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_11', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_11', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_11', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_11.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_11', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_11', '5');
			~cntSeqSusHat2_11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_12', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_12', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_12', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_12.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_12', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_12', '5');
			~cntSeqSusHat2_12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_13', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_13', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_13', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_13.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_13', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_13', '5');
			~cntSeqSusHat2_13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_14', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_14', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_14', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_14.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_14', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_14', '5');
			~cntSeqSusHat2_14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_15', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_15', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_15', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_15.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_15', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_15', '5');
			~cntSeqSusHat2_15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqSusHat2_16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_16', '1');
		}
		{ i == 2 }  {
			~seqSusHat2_16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat2_16', '2');
		}
		{ i == 3 }  {
			~seqSusHat2_16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat2_16', '3');
		}
		{ i == 4 }  {
			~seqSusHat2_16.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat2_16', '4');
		}
		{ i == 5 }  {
			~seqSusHat2_16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat2_16', '5');
			~cntSeqSusHat2_16=0;
		}
	}
	*stGrp {|i|
		IFSeqSusHat2.st01(i); IFSeqSusHat2.st02(i); IFSeqSusHat2.st03(i); IFSeqSusHat2.st04(i);
		IFSeqSusHat2.st05(i); IFSeqSusHat2.st06(i); IFSeqSusHat2.st07(i); IFSeqSusHat2.st08(i);
		IFSeqSusHat2.st09(i); IFSeqSusHat2.st10(i); IFSeqSusHat2.st11(i); IFSeqSusHat2.st12(i);
		IFSeqSusHat2.st13(i); IFSeqSusHat2.st14(i); IFSeqSusHat2.st15(i); IFSeqSusHat2.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqSusHat2.st01(s01); IFSeqSusHat2.st02(s02); IFSeqSusHat2.st03(s03); IFSeqSusHat2.st04(s04);
		IFSeqSusHat2.st05(s05); IFSeqSusHat2.st06(s06); IFSeqSusHat2.st07(s07); IFSeqSusHat2.st08(s08);
		IFSeqSusHat2.st09(s09); IFSeqSusHat2.st10(s10); IFSeqSusHat2.st11(s11); IFSeqSusHat2.st12(s12);
		IFSeqSusHat2.st13(s13); IFSeqSusHat2.st14(s14); IFSeqSusHat2.st15(s15); IFSeqSusHat2.st16(s16);
	}
}