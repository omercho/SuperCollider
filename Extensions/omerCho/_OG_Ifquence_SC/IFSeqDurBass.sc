IFSeqDurBass {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqDurBass01 = PatternProxy( Pseq([0.5], 1));
		~seqDurBass02 = PatternProxy( Pseq([0.5], 1));
		~seqDurBass03 = PatternProxy( Pseq([0.5], 1));
		~seqDurBass04 = PatternProxy( Pseq([0.5], 1));
		~seqDurBass05 = PatternProxy( Pseq([0.5], 1));
		~seqDurBass06 = PatternProxy( Pseq([0.5], 1));
		~seqDurBass07 = PatternProxy( Pseq([0.5], 1));
		~seqDurBass08 = PatternProxy( Pseq([0.5], 1));

		~seqDurBass09 = PatternProxy( Pseq([0.5], 1));
		~seqDurBass10 = PatternProxy( Pseq([0.5], 1));
		~seqDurBass11 = PatternProxy( Pseq([0.5], 1));
		~seqDurBass12 = PatternProxy( Pseq([0.5], 1));
		~seqDurBass13 = PatternProxy( Pseq([0.5], 1));
		~seqDurBass14 = PatternProxy( Pseq([0.5], 1));
		~seqDurBass15 = PatternProxy( Pseq([0.5], 1));
		~seqDurBass16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqDurUpBass01=0;
		~cntSeqDurRandBass01=0;

		~cntSeqDurBass01=0;
		~cntSeqDurBass02=0;
		~cntSeqDurBass03=0;
		~cntSeqDurBass04=0;
		~cntSeqDurBass05=0;
		~cntSeqDurBass06=0;
		~cntSeqDurBass07=0;
		~cntSeqDurBass08=0;

		~cntSeqDurBass09=0;
		~cntSeqDurBass10=0;
		~cntSeqDurBass11=0;
		~cntSeqDurBass12=0;
		~cntSeqDurBass13=0;
		~cntSeqDurBass14=0;
		~cntSeqDurBass15=0;
		~cntSeqDurBass16=0;
	}
	*freeOn {
		~seqFreeBassBut.free;
		~seqFreeBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqDurBass.stGrp(4);
				});
			},
			'/seqFreeBass'
		);
	}
	*upOn {
		~ifSeqUpBassBut.free;
		~ifSeqUpBassBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurUpBass01 = ~cntSeqDurUpBass01 + 1;
				~cntSeqDurUpBass01.switch(
					0,{},
					1,{IFSeqDurBass.stGrp(1);},
					2,{IFSeqDurBass.stGrp(2);},
					3,{IFSeqDurBass.stGrp(3);
						~cntSeqDurUpBass01=0;
					}
				)}
			);
			},
			'/seqUpBass'
		);
	}

	*randOn {
		~ifSeqRandBassBut.free;
		~ifSeqRandBassBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurRandBass01 = ~cntSeqDurRandBass01 + 1;
				~cntSeqDurRandBass01.switch(
					0,{},
					1,{
						IFSeqDurBass.st01([1,2,3,4,5].choose);
						IFSeqDurBass.st02([1,2,3,4,5].choose);
						IFSeqDurBass.st03([1,2,3,4,5].choose);
						IFSeqDurBass.st04([1,2,3,4,5].choose);
						IFSeqDurBass.st05([1,2,3,4,5].choose);
						IFSeqDurBass.st06([1,2,3,4,5].choose);
						IFSeqDurBass.st07([1,2,3,4,5].choose);
						IFSeqDurBass.st08([1,2,3,4,5].choose);

						IFSeqDurBass.st09([1,2,3,4,5].choose);
						IFSeqDurBass.st10([1,2,3,4,5].choose);
						IFSeqDurBass.st11([1,2,3,4,5].choose);
						IFSeqDurBass.st12([1,2,3,4,5].choose);
						IFSeqDurBass.st13([1,2,3,4,5].choose);
						IFSeqDurBass.st14([1,2,3,4,5].choose);
						IFSeqDurBass.st15([1,2,3,4,5].choose);
						IFSeqDurBass.st16([1,2,3,4,5].choose);
						~cntSeqDurRandBass01=0;
					}
				)}
			);
			},
			'/seqRandBass'
		);
	}


	*on { // Shift Durocity

		IFSeqDurBass.randOn;
		IFSeqDurBass.upOn;
		IFSeqDurBass.freeOn;

		~ifSeqBassBut01.free;
		~ifSeqBassBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass01 = ~cntSeqDurBass01 + 1;
				~cntSeqDurBass01.switch(
					0,{},
					1, {IFSeqDurBass.st01(1);},
					2, {IFSeqDurBass.st01(2);},
					3, {IFSeqDurBass.st01(3);},
					4, {IFSeqDurBass.st01(4);},
					5, {IFSeqDurBass.st01(5);}
				)}
			);
			},
			'/ifSeq/4/1'
		);
		~ifSeqBassBut02.free;
		~ifSeqBassBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass02 = ~cntSeqDurBass02 + 1;
				~cntSeqDurBass02.switch(
					0,{},
					1, {IFSeqDurBass.st02(1);},
					2, {IFSeqDurBass.st02(2);},
					3, {IFSeqDurBass.st02(3);},
					4, {IFSeqDurBass.st02(4);},
					5, {IFSeqDurBass.st02(5);}
				)}
			);
			},
			'/ifSeq/4/2'
		);
		~ifSeqBassBut03.free;
		~ifSeqBassBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass03 = ~cntSeqDurBass03 + 1;
				~cntSeqDurBass03.switch(
					0,{},
					1, {IFSeqDurBass.st03(1);},
					2, {IFSeqDurBass.st03(2);},
					3, {IFSeqDurBass.st03(3);},
					4, {IFSeqDurBass.st03(4);},
					5, {IFSeqDurBass.st03(5);}
				)}
			);
			},
			'/ifSeq/4/3'
		);
		~ifSeqBassBut04.free;
		~ifSeqBassBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass04 = ~cntSeqDurBass04 + 1;
				~cntSeqDurBass04.switch(
					0,{},
					1, {IFSeqDurBass.st04(1);},
					2, {IFSeqDurBass.st04(2);},
					3, {IFSeqDurBass.st04(3);},
					4, {IFSeqDurBass.st04(4);},
					5, {IFSeqDurBass.st04(5);}
				)}
			);
			},
			'/ifSeq/4/4'
		);
		~ifSeqBassBut05.free;
		~ifSeqBassBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass05 = ~cntSeqDurBass05 + 1;
				~cntSeqDurBass05.switch(
					0,{},
					1, {IFSeqDurBass.st05(1);},
					2, {IFSeqDurBass.st05(2);},
					3, {IFSeqDurBass.st05(3);},
					4, {IFSeqDurBass.st05(4);},
					5, {IFSeqDurBass.st05(5);}
				)}
			);
			},
			'/ifSeq/4/5'
		);
		~ifSeqBassBut06.free;
		~ifSeqBassBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass06 = ~cntSeqDurBass06 + 1;
				~cntSeqDurBass06.switch(
					0,{},
					1, {IFSeqDurBass.st06(1);},
					2, {IFSeqDurBass.st06(2);},
					3, {IFSeqDurBass.st06(3);},
					4, {IFSeqDurBass.st06(4);},
					5, {IFSeqDurBass.st06(5);}
				)}
			);
			},
			'/ifSeq/4/6'
		);
		~ifSeqBassBut07.free;
		~ifSeqBassBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass07 = ~cntSeqDurBass07 + 1;
				~cntSeqDurBass07.switch(
					0,{},
					1, {IFSeqDurBass.st07(1);},
					2, {IFSeqDurBass.st07(2);},
					3, {IFSeqDurBass.st07(3);},
					4, {IFSeqDurBass.st07(4);},
					5, {IFSeqDurBass.st07(5);}
				)}
			);
			},
			'/ifSeq/4/7'
		);
		~ifSeqBassBut08.free;
		~ifSeqBassBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass08 = ~cntSeqDurBass08 + 1;
				~cntSeqDurBass08.switch(
					0,{},
					1, {IFSeqDurBass.st08(1);},
					2, {IFSeqDurBass.st08(2);},
					3, {IFSeqDurBass.st08(3);},
					4, {IFSeqDurBass.st08(4);},
					5, {IFSeqDurBass.st08(5);}
				)}
			);
			},
			'/ifSeq/4/8'
		);

		~ifSeqBassBut09.free;
		~ifSeqBassBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass09 = ~cntSeqDurBass09 + 1;
				~cntSeqDurBass09.switch(
					0,{},
					1, {IFSeqDurBass.st09(1);},
					2, {IFSeqDurBass.st09(2);},
					3, {IFSeqDurBass.st09(3);},
					4, {IFSeqDurBass.st09(4);},
					5, {IFSeqDurBass.st09(5);}
				)}
			);
			},
			'/ifSeq/4/9'
		);
		~ifSeqBassBut10.free;
		~ifSeqBassBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass10 = ~cntSeqDurBass10 + 1;
				~cntSeqDurBass10.switch(
					0,{},
					1, {IFSeqDurBass.st10(1);},
					2, {IFSeqDurBass.st10(2);},
					3, {IFSeqDurBass.st10(3);},
					4, {IFSeqDurBass.st10(4);},
					5, {IFSeqDurBass.st10(5);}
				)}
			);
			},
			'/ifSeq/4/10'
		);
		~ifSeqBassBut11.free;
		~ifSeqBassBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass11 = ~cntSeqDurBass11 + 1;
				~cntSeqDurBass11.switch(
					0,{},
					1, {IFSeqDurBass.st11(1);},
					2, {IFSeqDurBass.st11(2);},
					3, {IFSeqDurBass.st11(3);},
					4, {IFSeqDurBass.st11(4);},
					5, {IFSeqDurBass.st11(5);}
				)}
			);
			},
			'/ifSeq/4/11'
		);
		~ifSeqBassBut12.free;
		~ifSeqBassBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass12 = ~cntSeqDurBass12 + 1;
				~cntSeqDurBass12.switch(
					0,{},
					1, {IFSeqDurBass.st12(1);},
					2, {IFSeqDurBass.st12(2);},
					3, {IFSeqDurBass.st12(3);},
					4, {IFSeqDurBass.st12(4);},
					5, {IFSeqDurBass.st12(5);}
				)}
			);
			},
			'/ifSeq/4/12'
		);
		~ifSeqBassBut13.free;
		~ifSeqBassBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass13 = ~cntSeqDurBass13 + 1;
				~cntSeqDurBass13.switch(
					0,{},
					1, {IFSeqDurBass.st13(1);},
					2, {IFSeqDurBass.st13(2);},
					3, {IFSeqDurBass.st13(3);},
					4, {IFSeqDurBass.st13(4);},
					5, {IFSeqDurBass.st13(5);}
				)}
			);
			},
			'/ifSeq/4/13'
		);
		~ifSeqBassBut14.free;
		~ifSeqBassBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass14 = ~cntSeqDurBass14 + 1;
				~cntSeqDurBass14.switch(
					0,{},
					1, {IFSeqDurBass.st14(1);},
					2, {IFSeqDurBass.st14(2);},
					3, {IFSeqDurBass.st14(3);},
					4, {IFSeqDurBass.st14(4);},
					5, {IFSeqDurBass.st14(5);}
				)}
			);
			},
			'/ifSeq/4/14'
		);
		~ifSeqBassBut15.free;
		~ifSeqBassBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass15 = ~cntSeqDurBass15 + 1;
				~cntSeqDurBass15.switch(
					0,{},
					1, {IFSeqDurBass.st15(1);},
					2, {IFSeqDurBass.st15(2);},
					3, {IFSeqDurBass.st15(3);},
					4, {IFSeqDurBass.st15(4);},
					5, {IFSeqDurBass.st15(5);}
				)}
			);
			},
			'/ifSeq/4/15'
		);
		~ifSeqBassBut16.free;
		~ifSeqBassBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurBass16 = ~cntSeqDurBass16 + 1;
				~cntSeqDurBass16.switch(
					0,{},
					1, {IFSeqDurBass.st16(1);},
					2, {IFSeqDurBass.st16(2);},
					3, {IFSeqDurBass.st16(3);},
					4, {IFSeqDurBass.st16(4);},
					5, {IFSeqDurBass.st16(5);}
				)}
			);
			},
			'/ifSeq/4/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqDurBass01.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass01', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass01.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass01', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass01.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass01', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass01.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass01', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass01', '1.5');
			~cntSeqDurBass01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqDurBass02.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass02', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass02.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass02', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass02.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass02', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass02.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass02', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass02', '1.5');
			~cntSeqDurBass02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqDurBass03.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass03', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass03.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass03', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass03.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass03', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass03.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass03', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass03', '1.5');
			~cntSeqDurBass03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqDurBass04.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass04', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass04.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass04', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass04.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass04', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass04.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass04', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass04', '1.5');
			~cntSeqDurBass04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqDurBass05.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass05', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass05.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass05', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass05.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass05', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass05.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass05', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass05', '1.5');
			~cntSeqDurBass05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqDurBass06.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass06', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass06.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass06', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass06.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass06', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass06.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass06', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass06', '1.5');
			~cntSeqDurBass06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqDurBass07.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass07', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass07.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass07', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass07.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass07', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass07.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass07', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass07', '1.5');
			~cntSeqDurBass07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqDurBass08.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass08', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass08.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass08', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass08.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass08', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass08.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass08', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass08', '1.5');
			~cntSeqDurBass08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqDurBass09.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass09', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass09.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass09', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass09.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass09', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass09.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass09', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass09', '1.5');
			~cntSeqDurBass09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqDurBass10.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass10', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass10.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass10', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass10.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass10', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass10.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass10', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass10', '1.5');
			~cntSeqDurBass10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqDurBass11.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass11', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass11.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass11', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass11.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass11', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass11.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass11', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass11', '1.5');
			~cntSeqDurBass11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqDurBass12.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass12', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass12.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass12', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass12.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass12', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass12.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass12', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass12', '1.5');
			~cntSeqDurBass12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqDurBass13.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass13', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass13.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass13', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass13.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass13', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass13.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass13', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass13', '1.5');
			~cntSeqDurBass13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqDurBass14.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass14', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass14.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass14', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass14.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass14', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass14.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass14', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass14', '1.5');
			~cntSeqDurBass14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqDurBass15.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass15', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass15.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass15', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass15.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass15', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass15.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass15', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass15', '1.5');
			~cntSeqDurBass15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqDurBass16.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurBass16', '1/4');
		}
		{ i == 2 }  {
			~seqDurBass16.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurBass16', '1/3');
		}
		{ i == 3 }  {
			~seqDurBass16.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurBass16', '1/2');
		}
		{ i == 4 }  {
			~seqDurBass16.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurBass16', '1/1');
		}
		{ i == 5 }  {
			~seqDurBass16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurBass16', '1.5');
			~cntSeqDurBass16=0;
		}
	}
	*stGrp {|i|
		IFSeqDurBass.st01(i); IFSeqDurBass.st02(i); IFSeqDurBass.st03(i); IFSeqDurBass.st04(i);
		IFSeqDurBass.st05(i); IFSeqDurBass.st06(i); IFSeqDurBass.st07(i); IFSeqDurBass.st08(i);
		IFSeqDurBass.st09(i); IFSeqDurBass.st10(i); IFSeqDurBass.st11(i); IFSeqDurBass.st12(i);
		IFSeqDurBass.st13(i); IFSeqDurBass.st14(i); IFSeqDurBass.st15(i); IFSeqDurBass.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqDurBass.st01(s01); IFSeqDurBass.st02(s02); IFSeqDurBass.st03(s03); IFSeqDurBass.st04(s04);
		IFSeqDurBass.st05(s05); IFSeqDurBass.st06(s06); IFSeqDurBass.st07(s07); IFSeqDurBass.st08(s08);
		IFSeqDurBass.st09(s09); IFSeqDurBass.st10(s10); IFSeqDurBass.st11(s11); IFSeqDurBass.st12(s12);
		IFSeqDurBass.st13(s13); IFSeqDurBass.st14(s14); IFSeqDurBass.st15(s15); IFSeqDurBass.st16(s16);
	}
}