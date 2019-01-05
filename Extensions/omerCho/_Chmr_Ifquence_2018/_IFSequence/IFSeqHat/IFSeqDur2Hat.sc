IFSeqDur2Hat {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqDur2Hat01 = PatternProxy( Pseq([1.0], 1));
		~seqDur2Hat02 = PatternProxy( Pseq([1.0], 1));
		~seqDur2Hat03 = PatternProxy( Pseq([1.0], 1));
		~seqDur2Hat04 = PatternProxy( Pseq([1.0], 1));
		~seqDur2Hat05 = PatternProxy( Pseq([1.0], 1));
		~seqDur2Hat06 = PatternProxy( Pseq([1.0], 1));
		~seqDur2Hat07 = PatternProxy( Pseq([1.0], 1));
		~seqDur2Hat08 = PatternProxy( Pseq([1.0], 1));

		~seqDur2Hat09 = PatternProxy( Pseq([1.0], 1));
		~seqDur2Hat10 = PatternProxy( Pseq([1.0], 1));
		~seqDur2Hat11 = PatternProxy( Pseq([1.0], 1));
		~seqDur2Hat12 = PatternProxy( Pseq([1.0], 1));
		~seqDur2Hat13 = PatternProxy( Pseq([1.0], 1));
		~seqDur2Hat14 = PatternProxy( Pseq([1.0], 1));
		~seqDur2Hat15 = PatternProxy( Pseq([1.0], 1));
		~seqDur2Hat16 = PatternProxy( Pseq([1.0], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqDurUp2Hat01=0;
		~cntSeqDurRand2Hat01=0;

		~cntSeqDur2Hat01=0;
		~cntSeqDur2Hat02=0;
		~cntSeqDur2Hat03=0;
		~cntSeqDur2Hat04=0;
		~cntSeqDur2Hat05=0;
		~cntSeqDur2Hat06=0;
		~cntSeqDur2Hat07=0;
		~cntSeqDur2Hat08=0;

		~cntSeqDur2Hat09=0;
		~cntSeqDur2Hat10=0;
		~cntSeqDur2Hat11=0;
		~cntSeqDur2Hat12=0;
		~cntSeqDur2Hat13=0;
		~cntSeqDur2Hat14=0;
		~cntSeqDur2Hat15=0;
		~cntSeqDur2Hat16=0;
	}
	*freeOn {
		~seqFree2HatBut.free;
		~seqFree2HatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqDur2Hat.stGrp(4);
				});
			},
			'/seqFree2Hat'
		);
	}
	*upOn {
		~ifSeqUp2HatBut.free;
		~ifSeqUp2HatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurUp2Hat01 = ~cntSeqDurUp2Hat01 + 1;
				~cntSeqDurUp2Hat01.switch(
					0,{},
					1,{IFSeqDur2Hat.stGrp(1);},
					2,{IFSeqDur2Hat.stGrp(2);},
					3,{IFSeqDur2Hat.stGrp(3);},
					4,{IFSeqDur2Hat.stGrp(4);},
					5,{IFSeqDur2Hat.stGrp(5);
						~cntSeqDurUp2Hat01=0;
					}
				)}
			);
			},
			'/seqUp2Hat'
		);
	}

	*randOn {
		~ifSeqRand2HatBut.free;
		~ifSeqRand2HatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurRand2Hat01 = ~cntSeqDurRand2Hat01 + 1;
				~cntSeqDurRand2Hat01.switch(
					0,{},
					1,{
						IFSeqDur2Hat.st01([1,2,3,4,5].choose);
						IFSeqDur2Hat.st02([1,2,3,4,5].choose);
						IFSeqDur2Hat.st03([1,2,3,4,5].choose);
						IFSeqDur2Hat.st04([1,2,3,4,5].choose);
						IFSeqDur2Hat.st05([1,2,3,4,5].choose);
						IFSeqDur2Hat.st06([1,2,3,4,5].choose);
						IFSeqDur2Hat.st07([1,2,3,4,5].choose);
						IFSeqDur2Hat.st08([1,2,3,4,5].choose);

						IFSeqDur2Hat.st09([1,2,3,4,5].choose);
						IFSeqDur2Hat.st10([1,2,3,4,5].choose);
						IFSeqDur2Hat.st11([1,2,3,4,5].choose);
						IFSeqDur2Hat.st12([1,2,3,4,5].choose);
						IFSeqDur2Hat.st13([1,2,3,4,5].choose);
						IFSeqDur2Hat.st14([1,2,3,4,5].choose);
						IFSeqDur2Hat.st15([1,2,3,4,5].choose);
						IFSeqDur2Hat.st16([1,2,3,4,5].choose);
						~cntSeqDurRand2Hat01=0;
					}
				)}
			);
			},
			'/seqRand2Hat'
		);
	}


	*on { // Shift Durocity

		IFSeqDur2Hat.randOn;
		IFSeqDur2Hat.upOn;
		IFSeqDur2Hat.freeOn;

		~ifSeq2HatBut01.free;
		~ifSeq2HatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat01 = ~cntSeqDur2Hat01 + 1;
				~cntSeqDur2Hat01.switch(
					0,{},
					1, {IFSeqDur2Hat.st01(1);},
					2, {IFSeqDur2Hat.st01(2);},
					3, {IFSeqDur2Hat.st01(3);},
					4, {IFSeqDur2Hat.st01(4);},
					5, {IFSeqDur2Hat.st01(5);}
				)}
			);
			},
			'/ifSeq/3/1'
		);
		~ifSeq2HatBut02.free;
		~ifSeq2HatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat02 = ~cntSeqDur2Hat02 + 1;
				~cntSeqDur2Hat02.switch(
					0,{},
					1, {IFSeqDur2Hat.st02(1);},
					2, {IFSeqDur2Hat.st02(2);},
					3, {IFSeqDur2Hat.st02(3);},
					4, {IFSeqDur2Hat.st02(4);},
					5, {IFSeqDur2Hat.st02(5);}
				)}
			);
			},
			'/ifSeq/3/2'
		);
		~ifSeq2HatBut03.free;
		~ifSeq2HatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat03 = ~cntSeqDur2Hat03 + 1;
				~cntSeqDur2Hat03.switch(
					0,{},
					1, {IFSeqDur2Hat.st03(1);},
					2, {IFSeqDur2Hat.st03(2);},
					3, {IFSeqDur2Hat.st03(3);},
					4, {IFSeqDur2Hat.st03(4);},
					5, {IFSeqDur2Hat.st03(5);}
				)}
			);
			},
			'/ifSeq/3/3'
		);
		~ifSeq2HatBut04.free;
		~ifSeq2HatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat04 = ~cntSeqDur2Hat04 + 1;
				~cntSeqDur2Hat04.switch(
					0,{},
					1, {IFSeqDur2Hat.st04(1);},
					2, {IFSeqDur2Hat.st04(2);},
					3, {IFSeqDur2Hat.st04(3);},
					4, {IFSeqDur2Hat.st04(4);},
					5, {IFSeqDur2Hat.st04(5);}
				)}
			);
			},
			'/ifSeq/3/4'
		);
		~ifSeq2HatBut05.free;
		~ifSeq2HatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat05 = ~cntSeqDur2Hat05 + 1;
				~cntSeqDur2Hat05.switch(
					0,{},
					1, {IFSeqDur2Hat.st05(1);},
					2, {IFSeqDur2Hat.st05(2);},
					3, {IFSeqDur2Hat.st05(3);},
					4, {IFSeqDur2Hat.st05(4);},
					5, {IFSeqDur2Hat.st05(5);}
				)}
			);
			},
			'/ifSeq/3/5'
		);
		~ifSeq2HatBut06.free;
		~ifSeq2HatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat06 = ~cntSeqDur2Hat06 + 1;
				~cntSeqDur2Hat06.switch(
					0,{},
					1, {IFSeqDur2Hat.st06(1);},
					2, {IFSeqDur2Hat.st06(2);},
					3, {IFSeqDur2Hat.st06(3);},
					4, {IFSeqDur2Hat.st06(4);},
					5, {IFSeqDur2Hat.st06(5);}
				)}
			);
			},
			'/ifSeq/3/6'
		);
		~ifSeq2HatBut07.free;
		~ifSeq2HatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat07 = ~cntSeqDur2Hat07 + 1;
				~cntSeqDur2Hat07.switch(
					0,{},
					1, {IFSeqDur2Hat.st07(1);},
					2, {IFSeqDur2Hat.st07(2);},
					3, {IFSeqDur2Hat.st07(3);},
					4, {IFSeqDur2Hat.st07(4);},
					5, {IFSeqDur2Hat.st07(5);}
				)}
			);
			},
			'/ifSeq/3/7'
		);
		~ifSeq2HatBut08.free;
		~ifSeq2HatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat08 = ~cntSeqDur2Hat08 + 1;
				~cntSeqDur2Hat08.switch(
					0,{},
					1, {IFSeqDur2Hat.st08(1);},
					2, {IFSeqDur2Hat.st08(2);},
					3, {IFSeqDur2Hat.st08(3);},
					4, {IFSeqDur2Hat.st08(4);},
					5, {IFSeqDur2Hat.st08(5);}
				)}
			);
			},
			'/ifSeq/3/8'
		);

		~ifSeq2HatBut09.free;
		~ifSeq2HatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat09 = ~cntSeqDur2Hat09 + 1;
				~cntSeqDur2Hat09.switch(
					0,{},
					1, {IFSeqDur2Hat.st09(1);},
					2, {IFSeqDur2Hat.st09(2);},
					3, {IFSeqDur2Hat.st09(3);},
					4, {IFSeqDur2Hat.st09(4);},
					5, {IFSeqDur2Hat.st09(5);}
				)}
			);
			},
			'/ifSeq/3/9'
		);
		~ifSeq2HatBut10.free;
		~ifSeq2HatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat10 = ~cntSeqDur2Hat10 + 1;
				~cntSeqDur2Hat10.switch(
					0,{},
					1, {IFSeqDur2Hat.st10(1);},
					2, {IFSeqDur2Hat.st10(2);},
					3, {IFSeqDur2Hat.st10(3);},
					4, {IFSeqDur2Hat.st10(4);},
					5, {IFSeqDur2Hat.st10(5);}
				)}
			);
			},
			'/ifSeq/3/10'
		);
		~ifSeq2HatBut11.free;
		~ifSeq2HatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat11 = ~cntSeqDur2Hat11 + 1;
				~cntSeqDur2Hat11.switch(
					0,{},
					1, {IFSeqDur2Hat.st11(1);},
					2, {IFSeqDur2Hat.st11(2);},
					3, {IFSeqDur2Hat.st11(3);},
					4, {IFSeqDur2Hat.st11(4);},
					5, {IFSeqDur2Hat.st11(5);}
				)}
			);
			},
			'/ifSeq/3/11'
		);
		~ifSeq2HatBut12.free;
		~ifSeq2HatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat12 = ~cntSeqDur2Hat12 + 1;
				~cntSeqDur2Hat12.switch(
					0,{},
					1, {IFSeqDur2Hat.st12(1);},
					2, {IFSeqDur2Hat.st12(2);},
					3, {IFSeqDur2Hat.st12(3);},
					4, {IFSeqDur2Hat.st12(4);},
					5, {IFSeqDur2Hat.st12(5);}
				)}
			);
			},
			'/ifSeq/3/12'
		);
		~ifSeq2HatBut13.free;
		~ifSeq2HatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat13 = ~cntSeqDur2Hat13 + 1;
				~cntSeqDur2Hat13.switch(
					0,{},
					1, {IFSeqDur2Hat.st13(1);},
					2, {IFSeqDur2Hat.st13(2);},
					3, {IFSeqDur2Hat.st13(3);},
					4, {IFSeqDur2Hat.st13(4);},
					5, {IFSeqDur2Hat.st13(5);}
				)}
			);
			},
			'/ifSeq/3/13'
		);
		~ifSeq2HatBut14.free;
		~ifSeq2HatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat14 = ~cntSeqDur2Hat14 + 1;
				~cntSeqDur2Hat14.switch(
					0,{},
					1, {IFSeqDur2Hat.st14(1);},
					2, {IFSeqDur2Hat.st14(2);},
					3, {IFSeqDur2Hat.st14(3);},
					4, {IFSeqDur2Hat.st14(4);},
					5, {IFSeqDur2Hat.st14(5);}
				)}
			);
			},
			'/ifSeq/3/14'
		);
		~ifSeq2HatBut15.free;
		~ifSeq2HatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat15 = ~cntSeqDur2Hat15 + 1;
				~cntSeqDur2Hat15.switch(
					0,{},
					1, {IFSeqDur2Hat.st15(1);},
					2, {IFSeqDur2Hat.st15(2);},
					3, {IFSeqDur2Hat.st15(3);},
					4, {IFSeqDur2Hat.st15(4);},
					5, {IFSeqDur2Hat.st15(5);}
				)}
			);
			},
			'/ifSeq/3/15'
		);
		~ifSeq2HatBut16.free;
		~ifSeq2HatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDur2Hat16 = ~cntSeqDur2Hat16 + 1;
				~cntSeqDur2Hat16.switch(
					0,{},
					1, {IFSeqDur2Hat.st16(1);},
					2, {IFSeqDur2Hat.st16(2);},
					3, {IFSeqDur2Hat.st16(3);},
					4, {IFSeqDur2Hat.st16(4);},
					5, {IFSeqDur2Hat.st16(5);}
				)}
			);
			},
			'/ifSeq/3/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat01.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat01', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat01.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat01', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat01.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat01', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat01.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat01', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat01', '1.5');
			~cntSeqDur2Hat01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat02.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat02', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat02.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat02', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat02.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat02', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat02.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat02', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat02', '1.5');
			~cntSeqDur2Hat02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat03.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat03', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat03.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat03', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat03.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat03', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat03.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat03', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat03', '1.5');
			~cntSeqDur2Hat03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat04.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat04', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat04.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat04', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat04.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat04', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat04.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat04', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat04', '1.5');
			~cntSeqDur2Hat04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat05.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat05', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat05.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat05', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat05.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat05', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat05.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat05', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat05', '1.5');
			~cntSeqDur2Hat05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat06.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat06', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat06.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat06', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat06.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat06', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat06.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat06', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat06', '1.5');
			~cntSeqDur2Hat06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat07.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat07', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat07.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat07', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat07.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat07', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat07.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat07', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat07', '1.5');
			~cntSeqDur2Hat07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat08.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat08', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat08.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat08', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat08.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat08', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat08.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat08', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat08', '1.5');
			~cntSeqDur2Hat08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat09.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat09', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat09.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat09', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat09.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat09', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat09.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat09', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat09', '1.5');
			~cntSeqDur2Hat09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat10.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat10', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat10.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat10', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat10.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat10', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat10.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat10', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat10', '1.5');
			~cntSeqDur2Hat10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat11.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat11', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat11.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat11', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat11.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat11', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat11.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat11', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat11', '1.5');
			~cntSeqDur2Hat11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat12.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat12', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat12.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat12', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat12.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat12', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat12.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat12', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat12', '1.5');
			~cntSeqDur2Hat12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat13.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat13', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat13.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat13', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat13.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat13', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat13.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat13', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat13', '1.5');
			~cntSeqDur2Hat13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat14.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat14', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat14.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat14', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat14.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat14', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat14.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat14', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat14', '1.5');
			~cntSeqDur2Hat14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat15.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat15', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat15.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat15', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat15.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat15', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat15.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat15', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat15', '1.5');
			~cntSeqDur2Hat15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqDur2Hat16.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDur2Hat16', '1/4');
		}
		{ i == 2 }  {
			~seqDur2Hat16.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDur2Hat16', '1/3');
		}
		{ i == 3 }  {
			~seqDur2Hat16.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDur2Hat16', '1/2');
		}
		{ i == 4 }  {
			~seqDur2Hat16.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDur2Hat16', '1/1');
		}
		{ i == 5 }  {
			~seqDur2Hat16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDur2Hat16', '1.5');
			~cntSeqDur2Hat16=0;
		}
	}
	*stGrp {|i|
		IFSeqDur2Hat.st01(i); IFSeqDur2Hat.st02(i); IFSeqDur2Hat.st03(i); IFSeqDur2Hat.st04(i);
		IFSeqDur2Hat.st05(i); IFSeqDur2Hat.st06(i); IFSeqDur2Hat.st07(i); IFSeqDur2Hat.st08(i);
		IFSeqDur2Hat.st09(i); IFSeqDur2Hat.st10(i); IFSeqDur2Hat.st11(i); IFSeqDur2Hat.st12(i);
		IFSeqDur2Hat.st13(i); IFSeqDur2Hat.st14(i); IFSeqDur2Hat.st15(i); IFSeqDur2Hat.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqDur2Hat.st01(s01); IFSeqDur2Hat.st02(s02); IFSeqDur2Hat.st03(s03); IFSeqDur2Hat.st04(s04);
		IFSeqDur2Hat.st05(s05); IFSeqDur2Hat.st06(s06); IFSeqDur2Hat.st07(s07); IFSeqDur2Hat.st08(s08);
		IFSeqDur2Hat.st09(s09); IFSeqDur2Hat.st10(s10); IFSeqDur2Hat.st11(s11); IFSeqDur2Hat.st12(s12);
		IFSeqDur2Hat.st13(s13); IFSeqDur2Hat.st14(s14); IFSeqDur2Hat.st15(s15); IFSeqDur2Hat.st16(s16);
	}
}