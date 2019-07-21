IFSeqSusBass {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqSusBass01 = PatternProxy( Pseq([0.5], 1));
		~seqSusBass02 = PatternProxy( Pseq([0.5], 1));
		~seqSusBass03 = PatternProxy( Pseq([0.5], 1));
		~seqSusBass04 = PatternProxy( Pseq([0.5], 1));
		~seqSusBass05 = PatternProxy( Pseq([0.5], 1));
		~seqSusBass06 = PatternProxy( Pseq([0.5], 1));
		~seqSusBass07 = PatternProxy( Pseq([0.5], 1));
		~seqSusBass08 = PatternProxy( Pseq([0.5], 1));

		~seqSusBass09 = PatternProxy( Pseq([0.5], 1));
		~seqSusBass10 = PatternProxy( Pseq([0.5], 1));
		~seqSusBass11 = PatternProxy( Pseq([0.5], 1));
		~seqSusBass12 = PatternProxy( Pseq([0.5], 1));
		~seqSusBass13 = PatternProxy( Pseq([0.5], 1));
		~seqSusBass14 = PatternProxy( Pseq([0.5], 1));
		~seqSusBass15 = PatternProxy( Pseq([0.5], 1));
		~seqSusBass16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqSusUpBass01=0;
		~cntSeqSusRandBass01=0;

		~cntSeqSusBass01=0;
		~cntSeqSusBass02=0;
		~cntSeqSusBass03=0;
		~cntSeqSusBass04=0;
		~cntSeqSusBass05=0;
		~cntSeqSusBass06=0;
		~cntSeqSusBass07=0;
		~cntSeqSusBass08=0;

		~cntSeqSusBass09=0;
		~cntSeqSusBass10=0;
		~cntSeqSusBass11=0;
		~cntSeqSusBass12=0;
		~cntSeqSusBass13=0;
		~cntSeqSusBass14=0;
		~cntSeqSusBass15=0;
		~cntSeqSusBass16=0;
	}
	*freeOn {
		~seqFreeBassBut.free;
		~seqFreeBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSusBass.stGrp(1);
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
				~cntSeqSusUpBass01 = ~cntSeqSusUpBass01 + 1;
				~cntSeqSusUpBass01.switch(
					0,{},
					1,{IFSeqSusBass.stGrp(1);},
					2,{IFSeqSusBass.stGrp(2);},
					3,{IFSeqSusBass.stGrp(3);
						~cntSeqSusUpBass01=0;
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
				~cntSeqSusRandBass01 = ~cntSeqSusRandBass01 + 1;
				~cntSeqSusRandBass01.switch(
					0,{},
					1,{
						IFSeqSusBass.st01([1,2,3,4,5].choose);
						IFSeqSusBass.st02([1,2,3,4,5].choose);
						IFSeqSusBass.st03([1,2,3,4,5].choose);
						IFSeqSusBass.st04([1,2,3,4,5].choose);
						IFSeqSusBass.st05([1,2,3,4,5].choose);
						IFSeqSusBass.st06([1,2,3,4,5].choose);
						IFSeqSusBass.st07([1,2,3,4,5].choose);
						IFSeqSusBass.st08([1,2,3,4,5].choose);

						IFSeqSusBass.st09([1,2,3,4,5].choose);
						IFSeqSusBass.st10([1,2,3,4,5].choose);
						IFSeqSusBass.st11([1,2,3,4,5].choose);
						IFSeqSusBass.st12([1,2,3,4,5].choose);
						IFSeqSusBass.st13([1,2,3,4,5].choose);
						IFSeqSusBass.st14([1,2,3,4,5].choose);
						IFSeqSusBass.st15([1,2,3,4,5].choose);
						IFSeqSusBass.st16([1,2,3,4,5].choose);
						~cntSeqSusRandBass01=0;
					}
				)}
			);
			},
			'/seqRandBass'
		);
	}


	*on { // Shift Susocity

		IFSeqSusBass.randOn;
		IFSeqSusBass.upOn;
		IFSeqSusBass.freeOn;

		~ifSeqBassBut01.free;
		~ifSeqBassBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass01 = ~cntSeqSusBass01 + 1;
				~cntSeqSusBass01.switch(
					0,{},
					1, {IFSeqSusBass.st01(1);},
					2, {IFSeqSusBass.st01(2);},
					3, {IFSeqSusBass.st01(3);},
					4, {IFSeqSusBass.st01(4);},
					5, {IFSeqSusBass.st01(5);}
				)}
			);
			},
			'/ifSeq/4/1'
		);
		~ifSeqBassBut02.free;
		~ifSeqBassBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass02 = ~cntSeqSusBass02 + 1;
				~cntSeqSusBass02.switch(
					0,{},
					1, {IFSeqSusBass.st02(1);},
					2, {IFSeqSusBass.st02(2);},
					3, {IFSeqSusBass.st02(3);},
					4, {IFSeqSusBass.st02(4);},
					5, {IFSeqSusBass.st02(5);}
				)}
			);
			},
			'/ifSeq/4/2'
		);
		~ifSeqBassBut03.free;
		~ifSeqBassBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass03 = ~cntSeqSusBass03 + 1;
				~cntSeqSusBass03.switch(
					0,{},
					1, {IFSeqSusBass.st03(1);},
					2, {IFSeqSusBass.st03(2);},
					3, {IFSeqSusBass.st03(3);},
					4, {IFSeqSusBass.st03(4);},
					5, {IFSeqSusBass.st03(5);}
				)}
			);
			},
			'/ifSeq/4/3'
		);
		~ifSeqBassBut04.free;
		~ifSeqBassBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass04 = ~cntSeqSusBass04 + 1;
				~cntSeqSusBass04.switch(
					0,{},
					1, {IFSeqSusBass.st04(1);},
					2, {IFSeqSusBass.st04(2);},
					3, {IFSeqSusBass.st04(3);},
					4, {IFSeqSusBass.st04(4);},
					5, {IFSeqSusBass.st04(5);}
				)}
			);
			},
			'/ifSeq/4/4'
		);
		~ifSeqBassBut05.free;
		~ifSeqBassBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass05 = ~cntSeqSusBass05 + 1;
				~cntSeqSusBass05.switch(
					0,{},
					1, {IFSeqSusBass.st05(1);},
					2, {IFSeqSusBass.st05(2);},
					3, {IFSeqSusBass.st05(3);},
					4, {IFSeqSusBass.st05(4);},
					5, {IFSeqSusBass.st05(5);}
				)}
			);
			},
			'/ifSeq/4/5'
		);
		~ifSeqBassBut06.free;
		~ifSeqBassBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass06 = ~cntSeqSusBass06 + 1;
				~cntSeqSusBass06.switch(
					0,{},
					1, {IFSeqSusBass.st06(1);},
					2, {IFSeqSusBass.st06(2);},
					3, {IFSeqSusBass.st06(3);},
					4, {IFSeqSusBass.st06(4);},
					5, {IFSeqSusBass.st06(5);}
				)}
			);
			},
			'/ifSeq/4/6'
		);
		~ifSeqBassBut07.free;
		~ifSeqBassBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass07 = ~cntSeqSusBass07 + 1;
				~cntSeqSusBass07.switch(
					0,{},
					1, {IFSeqSusBass.st07(1);},
					2, {IFSeqSusBass.st07(2);},
					3, {IFSeqSusBass.st07(3);},
					4, {IFSeqSusBass.st07(4);},
					5, {IFSeqSusBass.st07(5);}
				)}
			);
			},
			'/ifSeq/4/7'
		);
		~ifSeqBassBut08.free;
		~ifSeqBassBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass08 = ~cntSeqSusBass08 + 1;
				~cntSeqSusBass08.switch(
					0,{},
					1, {IFSeqSusBass.st08(1);},
					2, {IFSeqSusBass.st08(2);},
					3, {IFSeqSusBass.st08(3);},
					4, {IFSeqSusBass.st08(4);},
					5, {IFSeqSusBass.st08(5);}
				)}
			);
			},
			'/ifSeq/4/8'
		);

		~ifSeqBassBut09.free;
		~ifSeqBassBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass09 = ~cntSeqSusBass09 + 1;
				~cntSeqSusBass09.switch(
					0,{},
					1, {IFSeqSusBass.st09(1);},
					2, {IFSeqSusBass.st09(2);},
					3, {IFSeqSusBass.st09(3);},
					4, {IFSeqSusBass.st09(4);},
					5, {IFSeqSusBass.st09(5);}
				)}
			);
			},
			'/ifSeq/4/9'
		);
		~ifSeqBassBut10.free;
		~ifSeqBassBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass10 = ~cntSeqSusBass10 + 1;
				~cntSeqSusBass10.switch(
					0,{},
					1, {IFSeqSusBass.st10(1);},
					2, {IFSeqSusBass.st10(2);},
					3, {IFSeqSusBass.st10(3);},
					4, {IFSeqSusBass.st10(4);},
					5, {IFSeqSusBass.st10(5);}
				)}
			);
			},
			'/ifSeq/4/10'
		);
		~ifSeqBassBut11.free;
		~ifSeqBassBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass11 = ~cntSeqSusBass11 + 1;
				~cntSeqSusBass11.switch(
					0,{},
					1, {IFSeqSusBass.st11(1);},
					2, {IFSeqSusBass.st11(2);},
					3, {IFSeqSusBass.st11(3);},
					4, {IFSeqSusBass.st11(4);},
					5, {IFSeqSusBass.st11(5);}
				)}
			);
			},
			'/ifSeq/4/11'
		);
		~ifSeqBassBut12.free;
		~ifSeqBassBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass12 = ~cntSeqSusBass12 + 1;
				~cntSeqSusBass12.switch(
					0,{},
					1, {IFSeqSusBass.st12(1);},
					2, {IFSeqSusBass.st12(2);},
					3, {IFSeqSusBass.st12(3);},
					4, {IFSeqSusBass.st12(4);},
					5, {IFSeqSusBass.st12(5);}
				)}
			);
			},
			'/ifSeq/4/12'
		);
		~ifSeqBassBut13.free;
		~ifSeqBassBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass13 = ~cntSeqSusBass13 + 1;
				~cntSeqSusBass13.switch(
					0,{},
					1, {IFSeqSusBass.st13(1);},
					2, {IFSeqSusBass.st13(2);},
					3, {IFSeqSusBass.st13(3);},
					4, {IFSeqSusBass.st13(4);},
					5, {IFSeqSusBass.st13(5);}
				)}
			);
			},
			'/ifSeq/4/13'
		);
		~ifSeqBassBut14.free;
		~ifSeqBassBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass14 = ~cntSeqSusBass14 + 1;
				~cntSeqSusBass14.switch(
					0,{},
					1, {IFSeqSusBass.st14(1);},
					2, {IFSeqSusBass.st14(2);},
					3, {IFSeqSusBass.st14(3);},
					4, {IFSeqSusBass.st14(4);},
					5, {IFSeqSusBass.st14(5);}
				)}
			);
			},
			'/ifSeq/4/14'
		);
		~ifSeqBassBut15.free;
		~ifSeqBassBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass15 = ~cntSeqSusBass15 + 1;
				~cntSeqSusBass15.switch(
					0,{},
					1, {IFSeqSusBass.st15(1);},
					2, {IFSeqSusBass.st15(2);},
					3, {IFSeqSusBass.st15(3);},
					4, {IFSeqSusBass.st15(4);},
					5, {IFSeqSusBass.st15(5);}
				)}
			);
			},
			'/ifSeq/4/15'
		);
		~ifSeqBassBut16.free;
		~ifSeqBassBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusBass16 = ~cntSeqSusBass16 + 1;
				~cntSeqSusBass16.switch(
					0,{},
					1, {IFSeqSusBass.st16(1);},
					2, {IFSeqSusBass.st16(2);},
					3, {IFSeqSusBass.st16(3);},
					4, {IFSeqSusBass.st16(4);},
					5, {IFSeqSusBass.st16(5);}
				)}
			);
			},
			'/ifSeq/4/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqSusBass01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass01', '1');
		}
		{ i == 2 }  {
			~seqSusBass01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass01', '2');
		}
		{ i == 3 }  {
			~seqSusBass01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass01', '3');
		}
		{ i == 4 }  {
			~seqSusBass01.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass01', '4');
		}
		{ i == 5 }  {
			~seqSusBass01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass01', '5');
			~cntSeqSusBass01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqSusBass02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass02', '1');
		}
		{ i == 2 }  {
			~seqSusBass02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass02', '2');
		}
		{ i == 3 }  {
			~seqSusBass02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass02', '3');
		}
		{ i == 4 }  {
			~seqSusBass02.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass02', '4');
		}
		{ i == 5 }  {
			~seqSusBass02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass02', '5');
			~cntSeqSusBass02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqSusBass03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass03', '1');
		}
		{ i == 2 }  {
			~seqSusBass03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass03', '2');
		}
		{ i == 3 }  {
			~seqSusBass03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass03', '3');
		}
		{ i == 4 }  {
			~seqSusBass03.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass03', '4');
		}
		{ i == 5 }  {
			~seqSusBass03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass03', '5');
			~cntSeqSusBass03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqSusBass04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass04', '1');
		}
		{ i == 2 }  {
			~seqSusBass04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass04', '2');
		}
		{ i == 3 }  {
			~seqSusBass04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass04', '3');
		}
		{ i == 4 }  {
			~seqSusBass04.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass04', '4');
		}
		{ i == 5 }  {
			~seqSusBass04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass04', '5');
			~cntSeqSusBass04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqSusBass05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass05', '1');
		}
		{ i == 2 }  {
			~seqSusBass05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass05', '2');
		}
		{ i == 3 }  {
			~seqSusBass05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass05', '3');
		}
		{ i == 4 }  {
			~seqSusBass05.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass05', '4');
		}
		{ i == 5 }  {
			~seqSusBass05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass05', '5');
			~cntSeqSusBass05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqSusBass06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass06', '1');
		}
		{ i == 2 }  {
			~seqSusBass06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass06', '2');
		}
		{ i == 3 }  {
			~seqSusBass06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass06', '3');
		}
		{ i == 4 }  {
			~seqSusBass06.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass06', '4');
		}
		{ i == 5 }  {
			~seqSusBass06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass06', '5');
			~cntSeqSusBass06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqSusBass07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass07', '1');
		}
		{ i == 2 }  {
			~seqSusBass07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass07', '2');
		}
		{ i == 3 }  {
			~seqSusBass07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass07', '3');
		}
		{ i == 4 }  {
			~seqSusBass07.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass07', '4');
		}
		{ i == 5 }  {
			~seqSusBass07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass07', '5');
			~cntSeqSusBass07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqSusBass08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass08', '1');
		}
		{ i == 2 }  {
			~seqSusBass08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass08', '2');
		}
		{ i == 3 }  {
			~seqSusBass08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass08', '3');
		}
		{ i == 4 }  {
			~seqSusBass08.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass08', '4');
		}
		{ i == 5 }  {
			~seqSusBass08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass08', '5');
			~cntSeqSusBass08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqSusBass09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass09', '1');
		}
		{ i == 2 }  {
			~seqSusBass09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass09', '2');
		}
		{ i == 3 }  {
			~seqSusBass09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass09', '3');
		}
		{ i == 4 }  {
			~seqSusBass09.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass09', '4');
		}
		{ i == 5 }  {
			~seqSusBass09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass09', '5');
			~cntSeqSusBass09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqSusBass10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass10', '1');
		}
		{ i == 2 }  {
			~seqSusBass10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass10', '2');
		}
		{ i == 3 }  {
			~seqSusBass10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass10', '3');
		}
		{ i == 4 }  {
			~seqSusBass10.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass10', '4');
		}
		{ i == 5 }  {
			~seqSusBass10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass10', '5');
			~cntSeqSusBass10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqSusBass11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass11', '1');
		}
		{ i == 2 }  {
			~seqSusBass11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass11', '2');
		}
		{ i == 3 }  {
			~seqSusBass11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass11', '3');
		}
		{ i == 4 }  {
			~seqSusBass11.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass11', '4');
		}
		{ i == 5 }  {
			~seqSusBass11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass11', '5');
			~cntSeqSusBass11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqSusBass12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass12', '1');
		}
		{ i == 2 }  {
			~seqSusBass12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass12', '2');
		}
		{ i == 3 }  {
			~seqSusBass12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass12', '3');
		}
		{ i == 4 }  {
			~seqSusBass12.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass12', '4');
		}
		{ i == 5 }  {
			~seqSusBass12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass12', '5');
			~cntSeqSusBass12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqSusBass13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass13', '1');
		}
		{ i == 2 }  {
			~seqSusBass13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass13', '2');
		}
		{ i == 3 }  {
			~seqSusBass13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass13', '3');
		}
		{ i == 4 }  {
			~seqSusBass13.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass13', '4');
		}
		{ i == 5 }  {
			~seqSusBass13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass13', '5');
			~cntSeqSusBass13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqSusBass14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass14', '1');
		}
		{ i == 2 }  {
			~seqSusBass14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass14', '2');
		}
		{ i == 3 }  {
			~seqSusBass14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass14', '3');
		}
		{ i == 4 }  {
			~seqSusBass14.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass14', '4');
		}
		{ i == 5 }  {
			~seqSusBass14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass14', '5');
			~cntSeqSusBass14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqSusBass15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass15', '1');
		}
		{ i == 2 }  {
			~seqSusBass15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass15', '2');
		}
		{ i == 3 }  {
			~seqSusBass15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass15', '3');
		}
		{ i == 4 }  {
			~seqSusBass15.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass15', '4');
		}
		{ i == 5 }  {
			~seqSusBass15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass15', '5');
			~cntSeqSusBass15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqSusBass16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusBass16', '1');
		}
		{ i == 2 }  {
			~seqSusBass16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusBass16', '2');
		}
		{ i == 3 }  {
			~seqSusBass16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusBass16', '3');
		}
		{ i == 4 }  {
			~seqSusBass16.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusBass16', '4');
		}
		{ i == 5 }  {
			~seqSusBass16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusBass16', '5');
			~cntSeqSusBass16=0;
		}
	}
	*stGrp {|i|
		IFSeqSusBass.st01(i); IFSeqSusBass.st02(i); IFSeqSusBass.st03(i); IFSeqSusBass.st04(i);
		IFSeqSusBass.st05(i); IFSeqSusBass.st06(i); IFSeqSusBass.st07(i); IFSeqSusBass.st08(i);
		IFSeqSusBass.st09(i); IFSeqSusBass.st10(i); IFSeqSusBass.st11(i); IFSeqSusBass.st12(i);
		IFSeqSusBass.st13(i); IFSeqSusBass.st14(i); IFSeqSusBass.st15(i); IFSeqSusBass.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqSusBass.st01(s01); IFSeqSusBass.st02(s02); IFSeqSusBass.st03(s03); IFSeqSusBass.st04(s04);
		IFSeqSusBass.st05(s05); IFSeqSusBass.st06(s06); IFSeqSusBass.st07(s07); IFSeqSusBass.st08(s08);
		IFSeqSusBass.st09(s09); IFSeqSusBass.st10(s10); IFSeqSusBass.st11(s11); IFSeqSusBass.st12(s12);
		IFSeqSusBass.st13(s13); IFSeqSusBass.st14(s14); IFSeqSusBass.st15(s15); IFSeqSusBass.st16(s16);
	}
}