IFSeqSusSnr2 {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqSusSnr2_01 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr2_02 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr2_03 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr2_04 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr2_05 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr2_06 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr2_07 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr2_08 = PatternProxy( Pseq([0.5], 1));

		~seqSusSnr2_09 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr2_10 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr2_11 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr2_12 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr2_13 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr2_14 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr2_15 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr2_16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqSusUpSnr2_01=0;
		~cntSeqSusRandSnr2_01=0;

		~cntSeqSusSnr2_01=0;
		~cntSeqSusSnr2_02=0;
		~cntSeqSusSnr2_03=0;
		~cntSeqSusSnr2_04=0;
		~cntSeqSusSnr2_05=0;
		~cntSeqSusSnr2_06=0;
		~cntSeqSusSnr2_07=0;
		~cntSeqSusSnr2_08=0;

		~cntSeqSusSnr2_09=0;
		~cntSeqSusSnr2_10=0;
		~cntSeqSusSnr2_11=0;
		~cntSeqSusSnr2_12=0;
		~cntSeqSusSnr2_13=0;
		~cntSeqSusSnr2_14=0;
		~cntSeqSusSnr2_15=0;
		~cntSeqSusSnr2_16=0;
	}
	*freeOn {
		~seqFreeSnr2But.free;
		~seqFreeSnr2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSusSnr2.stGrp(1);
				});
			},
			'/seqFreeSnr'
		);
	}
	*upOn {
		~ifSeqUpSnr2But.free;
		~ifSeqUpSnr2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusUpSnr2_01 = ~cntSeqSusUpSnr2_01 + 1;
				~cntSeqSusUpSnr2_01.switch(
					0,{},
					1,{IFSeqSusSnr2.stGrp(1);},
					2,{IFSeqSusSnr2.stGrp(2);},
					3,{IFSeqSusSnr2.stGrp(3);
						~cntSeqSusUpSnr2_01=0;
					}
				)}
			);
			},
			'/seqUpSnr'
		);
	}

	*randOn {
		~ifSeqRandSnr2But.free;
		~ifSeqRandSnr2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusRandSnr2_01 = ~cntSeqSusRandSnr2_01 + 1;
				~cntSeqSusRandSnr2_01.switch(
					0,{},
					1,{
						IFSeqSusSnr2.st01([1,2,3,4,5].choose);
						IFSeqSusSnr2.st02([1,2,3,4,5].choose);
						IFSeqSusSnr2.st03([1,2,3,4,5].choose);
						IFSeqSusSnr2.st04([1,2,3,4,5].choose);
						IFSeqSusSnr2.st05([1,2,3,4,5].choose);
						IFSeqSusSnr2.st06([1,2,3,4,5].choose);
						IFSeqSusSnr2.st07([1,2,3,4,5].choose);
						IFSeqSusSnr2.st08([1,2,3,4,5].choose);

						IFSeqSusSnr2.st09([1,2,3,4,5].choose);
						IFSeqSusSnr2.st10([1,2,3,4,5].choose);
						IFSeqSusSnr2.st11([1,2,3,4,5].choose);
						IFSeqSusSnr2.st12([1,2,3,4,5].choose);
						IFSeqSusSnr2.st13([1,2,3,4,5].choose);
						IFSeqSusSnr2.st14([1,2,3,4,5].choose);
						IFSeqSusSnr2.st15([1,2,3,4,5].choose);
						IFSeqSusSnr2.st16([1,2,3,4,5].choose);
						~cntSeqSusRandSnr2_01=0;
					}
				)}
			);
			},
			'/seqRandSnr'
		);
	}


	*on { // Shift Susocity

		IFSeqSusSnr2.randOn;
		IFSeqSusSnr2.upOn;
		IFSeqSusSnr2.freeOn;

		~ifSeqSnr2But01.free;
		~ifSeqSnr2But01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_01 = ~cntSeqSusSnr2_01 + 1;
				~cntSeqSusSnr2_01.switch(
					0,{},
					1, {IFSeqSusSnr2.st01(1);},
					2, {IFSeqSusSnr2.st01(2);},
					3, {IFSeqSusSnr2.st01(3);},
					4, {IFSeqSusSnr2.st01(4);},
					5, {IFSeqSusSnr2.st01(5);}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqSnr2But02.free;
		~ifSeqSnr2But02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_02 = ~cntSeqSusSnr2_02 + 1;
				~cntSeqSusSnr2_02.switch(
					0,{},
					1, {IFSeqSusSnr2.st02(1);},
					2, {IFSeqSusSnr2.st02(2);},
					3, {IFSeqSusSnr2.st02(3);},
					4, {IFSeqSusSnr2.st02(4);},
					5, {IFSeqSusSnr2.st02(5);}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqSnr2But03.free;
		~ifSeqSnr2But03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_03 = ~cntSeqSusSnr2_03 + 1;
				~cntSeqSusSnr2_03.switch(
					0,{},
					1, {IFSeqSusSnr2.st03(1);},
					2, {IFSeqSusSnr2.st03(2);},
					3, {IFSeqSusSnr2.st03(3);},
					4, {IFSeqSusSnr2.st03(4);},
					5, {IFSeqSusSnr2.st03(5);}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqSnr2But04.free;
		~ifSeqSnr2But04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_04 = ~cntSeqSusSnr2_04 + 1;
				~cntSeqSusSnr2_04.switch(
					0,{},
					1, {IFSeqSusSnr2.st04(1);},
					2, {IFSeqSusSnr2.st04(2);},
					3, {IFSeqSusSnr2.st04(3);},
					4, {IFSeqSusSnr2.st04(4);},
					5, {IFSeqSusSnr2.st04(5);}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqSnr2But05.free;
		~ifSeqSnr2But05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_05 = ~cntSeqSusSnr2_05 + 1;
				~cntSeqSusSnr2_05.switch(
					0,{},
					1, {IFSeqSusSnr2.st05(1);},
					2, {IFSeqSusSnr2.st05(2);},
					3, {IFSeqSusSnr2.st05(3);},
					4, {IFSeqSusSnr2.st05(4);},
					5, {IFSeqSusSnr2.st05(5);}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqSnr2But06.free;
		~ifSeqSnr2But06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_06 = ~cntSeqSusSnr2_06 + 1;
				~cntSeqSusSnr2_06.switch(
					0,{},
					1, {IFSeqSusSnr2.st06(1);},
					2, {IFSeqSusSnr2.st06(2);},
					3, {IFSeqSusSnr2.st06(3);},
					4, {IFSeqSusSnr2.st06(4);},
					5, {IFSeqSusSnr2.st06(5);}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqSnr2But07.free;
		~ifSeqSnr2But07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_07 = ~cntSeqSusSnr2_07 + 1;
				~cntSeqSusSnr2_07.switch(
					0,{},
					1, {IFSeqSusSnr2.st07(1);},
					2, {IFSeqSusSnr2.st07(2);},
					3, {IFSeqSusSnr2.st07(3);},
					4, {IFSeqSusSnr2.st07(4);},
					5, {IFSeqSusSnr2.st07(5);}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqSnr2But08.free;
		~ifSeqSnr2But08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_08 = ~cntSeqSusSnr2_08 + 1;
				~cntSeqSusSnr2_08.switch(
					0,{},
					1, {IFSeqSusSnr2.st08(1);},
					2, {IFSeqSusSnr2.st08(2);},
					3, {IFSeqSusSnr2.st08(3);},
					4, {IFSeqSusSnr2.st08(4);},
					5, {IFSeqSusSnr2.st08(5);}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqSnr2But09.free;
		~ifSeqSnr2But09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_09 = ~cntSeqSusSnr2_09 + 1;
				~cntSeqSusSnr2_09.switch(
					0,{},
					1, {IFSeqSusSnr2.st09(1);},
					2, {IFSeqSusSnr2.st09(2);},
					3, {IFSeqSusSnr2.st09(3);},
					4, {IFSeqSusSnr2.st09(4);},
					5, {IFSeqSusSnr2.st09(5);}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqSnr2But10.free;
		~ifSeqSnr2But10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_10 = ~cntSeqSusSnr2_10 + 1;
				~cntSeqSusSnr2_10.switch(
					0,{},
					1, {IFSeqSusSnr2.st10(1);},
					2, {IFSeqSusSnr2.st10(2);},
					3, {IFSeqSusSnr2.st10(3);},
					4, {IFSeqSusSnr2.st10(4);},
					5, {IFSeqSusSnr2.st10(5);}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqSnr2But11.free;
		~ifSeqSnr2But11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_11 = ~cntSeqSusSnr2_11 + 1;
				~cntSeqSusSnr2_11.switch(
					0,{},
					1, {IFSeqSusSnr2.st11(1);},
					2, {IFSeqSusSnr2.st11(2);},
					3, {IFSeqSusSnr2.st11(3);},
					4, {IFSeqSusSnr2.st11(4);},
					5, {IFSeqSusSnr2.st11(5);}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqSnr2But12.free;
		~ifSeqSnr2But12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_12 = ~cntSeqSusSnr2_12 + 1;
				~cntSeqSusSnr2_12.switch(
					0,{},
					1, {IFSeqSusSnr2.st12(1);},
					2, {IFSeqSusSnr2.st12(2);},
					3, {IFSeqSusSnr2.st12(3);},
					4, {IFSeqSusSnr2.st12(4);},
					5, {IFSeqSusSnr2.st12(5);}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqSnr2But13.free;
		~ifSeqSnr2But13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_13 = ~cntSeqSusSnr2_13 + 1;
				~cntSeqSusSnr2_13.switch(
					0,{},
					1, {IFSeqSusSnr2.st13(1);},
					2, {IFSeqSusSnr2.st13(2);},
					3, {IFSeqSusSnr2.st13(3);},
					4, {IFSeqSusSnr2.st13(4);},
					5, {IFSeqSusSnr2.st13(5);}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqSnr2But14.free;
		~ifSeqSnr2But14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_14 = ~cntSeqSusSnr2_14 + 1;
				~cntSeqSusSnr2_14.switch(
					0,{},
					1, {IFSeqSusSnr2.st14(1);},
					2, {IFSeqSusSnr2.st14(2);},
					3, {IFSeqSusSnr2.st14(3);},
					4, {IFSeqSusSnr2.st14(4);},
					5, {IFSeqSusSnr2.st14(5);}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqSnr2But15.free;
		~ifSeqSnr2But15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_15 = ~cntSeqSusSnr2_15 + 1;
				~cntSeqSusSnr2_15.switch(
					0,{},
					1, {IFSeqSusSnr2.st15(1);},
					2, {IFSeqSusSnr2.st15(2);},
					3, {IFSeqSusSnr2.st15(3);},
					4, {IFSeqSusSnr2.st15(4);},
					5, {IFSeqSusSnr2.st15(5);}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqSnr2But16.free;
		~ifSeqSnr2But16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr2_16 = ~cntSeqSusSnr2_16 + 1;
				~cntSeqSusSnr2_16.switch(
					0,{},
					1, {IFSeqSusSnr2.st16(1);},
					2, {IFSeqSusSnr2.st16(2);},
					3, {IFSeqSusSnr2.st16(3);},
					4, {IFSeqSusSnr2.st16(4);},
					5, {IFSeqSusSnr2.st16(5);}
				)}
			);
			},
			'/ifSeq/2/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_01', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_01', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_01', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_01.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_01', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_01', '5');
			~cntSeqSusSnr2_01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_02', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_02', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_02', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_02.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_02', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_02', '5');
			~cntSeqSusSnr2_02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_03', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_03', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_03', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_03.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_03', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_03', '5');
			~cntSeqSusSnr2_03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_04', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_04', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_04', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_04.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_04', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_04', '5');
			~cntSeqSusSnr2_04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_05', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_05', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_05', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_05.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_05', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_05', '5');
			~cntSeqSusSnr2_05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_06', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_06', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_06', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_06.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_06', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_06', '5');
			~cntSeqSusSnr2_06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_07', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_07', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_07', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_07.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_07', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_07', '5');
			~cntSeqSusSnr2_07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_08', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_08', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_08', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_08.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_08', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_08', '5');
			~cntSeqSusSnr2_08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_09', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_09', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_09', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_09.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_09', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_09', '5');
			~cntSeqSusSnr2_09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_10', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_10', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_10', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_10.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_10', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_10', '5');
			~cntSeqSusSnr2_10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_11', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_11', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_11', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_11.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_11', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_11', '5');
			~cntSeqSusSnr2_11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_12', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_12', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_12', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_12.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_12', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_12', '5');
			~cntSeqSusSnr2_12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_13', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_13', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_13', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_13.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_13', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_13', '5');
			~cntSeqSusSnr2_13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_14', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_14', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_14', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_14.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_14', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_14', '5');
			~cntSeqSusSnr2_14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_15', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_15', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_15', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_15.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_15', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_15', '5');
			~cntSeqSusSnr2_15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr2_16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_16', '1');
		}
		{ i == 2 }  {
			~seqSusSnr2_16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_16', '2');
		}
		{ i == 3 }  {
			~seqSusSnr2_16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_16', '3');
		}
		{ i == 4 }  {
			~seqSusSnr2_16.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_16', '4');
		}
		{ i == 5 }  {
			~seqSusSnr2_16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr2_16', '5');
			~cntSeqSusSnr2_16=0;
		}
	}
	*stGrp {|i|
		IFSeqSusSnr2.st01(i); IFSeqSusSnr2.st02(i); IFSeqSusSnr2.st03(i); IFSeqSusSnr2.st04(i);
		IFSeqSusSnr2.st05(i); IFSeqSusSnr2.st06(i); IFSeqSusSnr2.st07(i); IFSeqSusSnr2.st08(i);
		IFSeqSusSnr2.st09(i); IFSeqSusSnr2.st10(i); IFSeqSusSnr2.st11(i); IFSeqSusSnr2.st12(i);
		IFSeqSusSnr2.st13(i); IFSeqSusSnr2.st14(i); IFSeqSusSnr2.st15(i); IFSeqSusSnr2.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqSusSnr2.st01(s01); IFSeqSusSnr2.st02(s02); IFSeqSusSnr2.st03(s03); IFSeqSusSnr2.st04(s04);
		IFSeqSusSnr2.st05(s05); IFSeqSusSnr2.st06(s06); IFSeqSusSnr2.st07(s07); IFSeqSusSnr2.st08(s08);
		IFSeqSusSnr2.st09(s09); IFSeqSusSnr2.st10(s10); IFSeqSusSnr2.st11(s11); IFSeqSusSnr2.st12(s12);
		IFSeqSusSnr2.st13(s13); IFSeqSusSnr2.st14(s14); IFSeqSusSnr2.st15(s15); IFSeqSusSnr2.st16(s16);
	}
}