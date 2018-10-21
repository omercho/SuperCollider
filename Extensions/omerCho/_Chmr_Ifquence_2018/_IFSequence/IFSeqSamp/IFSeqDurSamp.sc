IFSeqDurSamp {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqDurSamp01 = PatternProxy( Pseq([0.5], 1));
		~seqDurSamp02 = PatternProxy( Pseq([0.5], 1));
		~seqDurSamp03 = PatternProxy( Pseq([0.5], 1));
		~seqDurSamp04 = PatternProxy( Pseq([0.5], 1));
		~seqDurSamp05 = PatternProxy( Pseq([0.5], 1));
		~seqDurSamp06 = PatternProxy( Pseq([0.5], 1));
		~seqDurSamp07 = PatternProxy( Pseq([0.5], 1));
		~seqDurSamp08 = PatternProxy( Pseq([0.5], 1));

		~seqDurSamp09 = PatternProxy( Pseq([0.5], 1));
		~seqDurSamp10 = PatternProxy( Pseq([0.5], 1));
		~seqDurSamp11 = PatternProxy( Pseq([0.5], 1));
		~seqDurSamp12 = PatternProxy( Pseq([0.5], 1));
		~seqDurSamp13 = PatternProxy( Pseq([0.5], 1));
		~seqDurSamp14 = PatternProxy( Pseq([0.5], 1));
		~seqDurSamp15 = PatternProxy( Pseq([0.5], 1));
		~seqDurSamp16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqDurUpSamp01=0;
		~cntSeqDurRandSamp01=0;

		~cntSeqDurSamp01=0;
		~cntSeqDurSamp02=0;
		~cntSeqDurSamp03=0;
		~cntSeqDurSamp04=0;
		~cntSeqDurSamp05=0;
		~cntSeqDurSamp06=0;
		~cntSeqDurSamp07=0;
		~cntSeqDurSamp08=0;

		~cntSeqDurSamp09=0;
		~cntSeqDurSamp10=0;
		~cntSeqDurSamp11=0;
		~cntSeqDurSamp12=0;
		~cntSeqDurSamp13=0;
		~cntSeqDurSamp14=0;
		~cntSeqDurSamp15=0;
		~cntSeqDurSamp16=0;
	}
	*freeOn {
		~seqFreeSampBut.free;
		~seqFreeSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqDurSamp.stGrp(4);
				});
			},
			'/seqFreeSamp'
		);
	}
	*upOn {
		~ifSeqUpSampBut.free;
		~ifSeqUpSampBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurUpSamp01 = ~cntSeqDurUpSamp01 + 1;
				~cntSeqDurUpSamp01.switch(
					0,{},
					1,{IFSeqDurSamp.stGrp(1);},
					2,{IFSeqDurSamp.stGrp(2);},
					3,{IFSeqDurSamp.stGrp(3);},
					4,{IFSeqDurSamp.stGrp(4);},
					5,{IFSeqDurSamp.stGrp(5);
						~cntSeqDurUpSamp01=0;
					}
				)}
			);
			},
			'/seqUpSamp'
		);
	}

	*randOn {
		~ifSeqRandSampBut.free;
		~ifSeqRandSampBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurRandSamp01 = ~cntSeqDurRandSamp01 + 1;
				~cntSeqDurRandSamp01.switch(
					0,{},
					1,{
						IFSeqDurSamp.st01([1,2,3,4,5].choose);
						IFSeqDurSamp.st02([1,2,3,4,5].choose);
						IFSeqDurSamp.st03([1,2,3,4,5].choose);
						IFSeqDurSamp.st04([1,2,3,4,5].choose);
						IFSeqDurSamp.st05([1,2,3,4,5].choose);
						IFSeqDurSamp.st06([1,2,3,4,5].choose);
						IFSeqDurSamp.st07([1,2,3,4,5].choose);
						IFSeqDurSamp.st08([1,2,3,4,5].choose);

						IFSeqDurSamp.st09([1,2,3,4,5].choose);
						IFSeqDurSamp.st10([1,2,3,4,5].choose);
						IFSeqDurSamp.st11([1,2,3,4,5].choose);
						IFSeqDurSamp.st12([1,2,3,4,5].choose);
						IFSeqDurSamp.st13([1,2,3,4,5].choose);
						IFSeqDurSamp.st14([1,2,3,4,5].choose);
						IFSeqDurSamp.st15([1,2,3,4,5].choose);
						IFSeqDurSamp.st16([1,2,3,4,5].choose);
						~cntSeqDurRandSamp01=0;
					}
				)}
			);
			},
			'/seqRandSamp'
		);
	}


	*on { // Shift Durocity

		IFSeqDurSamp.randOn;
		IFSeqDurSamp.upOn;
		IFSeqDurSamp.freeOn;

		~ifSeqSampBut01.free;
		~ifSeqSampBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp01 = ~cntSeqDurSamp01 + 1;
				~cntSeqDurSamp01.switch(
					0,{},
					1, {IFSeqDurSamp.st01(1);},
					2, {IFSeqDurSamp.st01(2);},
					3, {IFSeqDurSamp.st01(3);},
					4, {IFSeqDurSamp.st01(4);},
					5, {IFSeqDurSamp.st01(5);}
				)}
			);
			},
			'/ifSeq/6/1'
		);
		~ifSeqSampBut02.free;
		~ifSeqSampBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp02 = ~cntSeqDurSamp02 + 1;
				~cntSeqDurSamp02.switch(
					0,{},
					1, {IFSeqDurSamp.st02(1);},
					2, {IFSeqDurSamp.st02(2);},
					3, {IFSeqDurSamp.st02(3);},
					4, {IFSeqDurSamp.st02(4);},
					5, {IFSeqDurSamp.st02(5);}
				)}
			);
			},
			'/ifSeq/6/2'
		);
		~ifSeqSampBut03.free;
		~ifSeqSampBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp03 = ~cntSeqDurSamp03 + 1;
				~cntSeqDurSamp03.switch(
					0,{},
					1, {IFSeqDurSamp.st03(1);},
					2, {IFSeqDurSamp.st03(2);},
					3, {IFSeqDurSamp.st03(3);},
					4, {IFSeqDurSamp.st03(4);},
					5, {IFSeqDurSamp.st03(5);}
				)}
			);
			},
			'/ifSeq/6/3'
		);
		~ifSeqSampBut04.free;
		~ifSeqSampBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp04 = ~cntSeqDurSamp04 + 1;
				~cntSeqDurSamp04.switch(
					0,{},
					1, {IFSeqDurSamp.st04(1);},
					2, {IFSeqDurSamp.st04(2);},
					3, {IFSeqDurSamp.st04(3);},
					4, {IFSeqDurSamp.st04(4);},
					5, {IFSeqDurSamp.st04(5);}
				)}
			);
			},
			'/ifSeq/6/4'
		);
		~ifSeqSampBut05.free;
		~ifSeqSampBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp05 = ~cntSeqDurSamp05 + 1;
				~cntSeqDurSamp05.switch(
					0,{},
					1, {IFSeqDurSamp.st05(1);},
					2, {IFSeqDurSamp.st05(2);},
					3, {IFSeqDurSamp.st05(3);},
					4, {IFSeqDurSamp.st05(4);},
					5, {IFSeqDurSamp.st05(5);}
				)}
			);
			},
			'/ifSeq/6/5'
		);
		~ifSeqSampBut06.free;
		~ifSeqSampBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp06 = ~cntSeqDurSamp06 + 1;
				~cntSeqDurSamp06.switch(
					0,{},
					1, {IFSeqDurSamp.st06(1);},
					2, {IFSeqDurSamp.st06(2);},
					3, {IFSeqDurSamp.st06(3);},
					4, {IFSeqDurSamp.st06(4);},
					5, {IFSeqDurSamp.st06(5);}
				)}
			);
			},
			'/ifSeq/6/6'
		);
		~ifSeqSampBut07.free;
		~ifSeqSampBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp07 = ~cntSeqDurSamp07 + 1;
				~cntSeqDurSamp07.switch(
					0,{},
					1, {IFSeqDurSamp.st07(1);},
					2, {IFSeqDurSamp.st07(2);},
					3, {IFSeqDurSamp.st07(3);},
					4, {IFSeqDurSamp.st07(4);},
					5, {IFSeqDurSamp.st07(5);}
				)}
			);
			},
			'/ifSeq/6/7'
		);
		~ifSeqSampBut08.free;
		~ifSeqSampBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp08 = ~cntSeqDurSamp08 + 1;
				~cntSeqDurSamp08.switch(
					0,{},
					1, {IFSeqDurSamp.st08(1);},
					2, {IFSeqDurSamp.st08(2);},
					3, {IFSeqDurSamp.st08(3);},
					4, {IFSeqDurSamp.st08(4);},
					5, {IFSeqDurSamp.st08(5);}
				)}
			);
			},
			'/ifSeq/6/8'
		);

		~ifSeqSampBut09.free;
		~ifSeqSampBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp09 = ~cntSeqDurSamp09 + 1;
				~cntSeqDurSamp09.switch(
					0,{},
					1, {IFSeqDurSamp.st09(1);},
					2, {IFSeqDurSamp.st09(2);},
					3, {IFSeqDurSamp.st09(3);},
					4, {IFSeqDurSamp.st09(4);},
					5, {IFSeqDurSamp.st09(5);}
				)}
			);
			},
			'/ifSeq/6/9'
		);
		~ifSeqSampBut10.free;
		~ifSeqSampBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp10 = ~cntSeqDurSamp10 + 1;
				~cntSeqDurSamp10.switch(
					0,{},
					1, {IFSeqDurSamp.st10(1);},
					2, {IFSeqDurSamp.st10(2);},
					3, {IFSeqDurSamp.st10(3);},
					4, {IFSeqDurSamp.st10(4);},
					5, {IFSeqDurSamp.st10(5);}
				)}
			);
			},
			'/ifSeq/6/10'
		);
		~ifSeqSampBut11.free;
		~ifSeqSampBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp11 = ~cntSeqDurSamp11 + 1;
				~cntSeqDurSamp11.switch(
					0,{},
					1, {IFSeqDurSamp.st11(1);},
					2, {IFSeqDurSamp.st11(2);},
					3, {IFSeqDurSamp.st11(3);},
					4, {IFSeqDurSamp.st11(4);},
					5, {IFSeqDurSamp.st11(5);}
				)}
			);
			},
			'/ifSeq/6/11'
		);
		~ifSeqSampBut12.free;
		~ifSeqSampBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp12 = ~cntSeqDurSamp12 + 1;
				~cntSeqDurSamp12.switch(
					0,{},
					1, {IFSeqDurSamp.st12(1);},
					2, {IFSeqDurSamp.st12(2);},
					3, {IFSeqDurSamp.st12(3);},
					4, {IFSeqDurSamp.st12(4);},
					5, {IFSeqDurSamp.st12(5);}
				)}
			);
			},
			'/ifSeq/6/12'
		);
		~ifSeqSampBut13.free;
		~ifSeqSampBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp13 = ~cntSeqDurSamp13 + 1;
				~cntSeqDurSamp13.switch(
					0,{},
					1, {IFSeqDurSamp.st13(1);},
					2, {IFSeqDurSamp.st13(2);},
					3, {IFSeqDurSamp.st13(3);},
					4, {IFSeqDurSamp.st13(4);},
					5, {IFSeqDurSamp.st13(5);}
				)}
			);
			},
			'/ifSeq/6/13'
		);
		~ifSeqSampBut14.free;
		~ifSeqSampBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp14 = ~cntSeqDurSamp14 + 1;
				~cntSeqDurSamp14.switch(
					0,{},
					1, {IFSeqDurSamp.st14(1);},
					2, {IFSeqDurSamp.st14(2);},
					3, {IFSeqDurSamp.st14(3);},
					4, {IFSeqDurSamp.st14(4);},
					5, {IFSeqDurSamp.st14(5);}
				)}
			);
			},
			'/ifSeq/6/14'
		);
		~ifSeqSampBut15.free;
		~ifSeqSampBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp15 = ~cntSeqDurSamp15 + 1;
				~cntSeqDurSamp15.switch(
					0,{},
					1, {IFSeqDurSamp.st15(1);},
					2, {IFSeqDurSamp.st15(2);},
					3, {IFSeqDurSamp.st15(3);},
					4, {IFSeqDurSamp.st15(4);},
					5, {IFSeqDurSamp.st15(5);}
				)}
			);
			},
			'/ifSeq/6/15'
		);
		~ifSeqSampBut16.free;
		~ifSeqSampBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSamp16 = ~cntSeqDurSamp16 + 1;
				~cntSeqDurSamp16.switch(
					0,{},
					1, {IFSeqDurSamp.st16(1);},
					2, {IFSeqDurSamp.st16(2);},
					3, {IFSeqDurSamp.st16(3);},
					4, {IFSeqDurSamp.st16(4);},
					5, {IFSeqDurSamp.st16(5);}
				)}
			);
			},
			'/ifSeq/6/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp01.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp01', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp01.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp01', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp01.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp01', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp01.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp01', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp01', '1.5');
			~cntSeqDurSamp01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp02.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp02', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp02.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp02', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp02.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp02', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp02.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp02', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp02', '1.5');
			~cntSeqDurSamp02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp03.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp03', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp03.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp03', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp03.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp03', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp03.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp03', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp03', '1.5');
			~cntSeqDurSamp03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp04.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp04', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp04.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp04', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp04.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp04', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp04.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp04', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp04', '1.5');
			~cntSeqDurSamp04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp05.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp05', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp05.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp05', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp05.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp05', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp05.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp05', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp05', '1.5');
			~cntSeqDurSamp05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp06.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp06', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp06.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp06', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp06.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp06', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp06.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp06', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp06', '1.5');
			~cntSeqDurSamp06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp07.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp07', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp07.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp07', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp07.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp07', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp07.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp07', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp07', '1.5');
			~cntSeqDurSamp07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp08.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp08', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp08.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp08', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp08.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp08', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp08.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp08', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp08', '1.5');
			~cntSeqDurSamp08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp09.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp09', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp09.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp09', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp09.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp09', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp09.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp09', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp09', '1.5');
			~cntSeqDurSamp09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp10.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp10', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp10.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp10', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp10.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp10', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp10.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp10', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp10', '1.5');
			~cntSeqDurSamp10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp11.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp11', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp11.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp11', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp11.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp11', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp11.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp11', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp11', '1.5');
			~cntSeqDurSamp11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp12.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp12', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp12.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp12', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp12.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp12', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp12.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp12', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp12', '1.5');
			~cntSeqDurSamp12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp13.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp13', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp13.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp13', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp13.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp13', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp13.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp13', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp13', '1.5');
			~cntSeqDurSamp13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp14.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp14', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp14.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp14', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp14.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp14', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp14.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp14', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp14', '1.5');
			~cntSeqDurSamp14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp15.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp15', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp15.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp15', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp15.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp15', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp15.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp15', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp15', '1.5');
			~cntSeqDurSamp15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqDurSamp16.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSamp16', '1/4');
		}
		{ i == 2 }  {
			~seqDurSamp16.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSamp16', '1/3');
		}
		{ i == 3 }  {
			~seqDurSamp16.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSamp16', '1/2');
		}
		{ i == 4 }  {
			~seqDurSamp16.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSamp16', '1/1');
		}
		{ i == 5 }  {
			~seqDurSamp16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSamp16', '1.5');
			~cntSeqDurSamp16=0;
		}
	}
	*stGrp {|i|
		IFSeqDurSamp.st01(i); IFSeqDurSamp.st02(i); IFSeqDurSamp.st03(i); IFSeqDurSamp.st04(i);
		IFSeqDurSamp.st05(i); IFSeqDurSamp.st06(i); IFSeqDurSamp.st07(i); IFSeqDurSamp.st08(i);
		IFSeqDurSamp.st09(i); IFSeqDurSamp.st10(i); IFSeqDurSamp.st11(i); IFSeqDurSamp.st12(i);
		IFSeqDurSamp.st13(i); IFSeqDurSamp.st14(i); IFSeqDurSamp.st15(i); IFSeqDurSamp.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqDurSamp.st01(s01); IFSeqDurSamp.st02(s02); IFSeqDurSamp.st03(s03); IFSeqDurSamp.st04(s04);
		IFSeqDurSamp.st05(s05); IFSeqDurSamp.st06(s06); IFSeqDurSamp.st07(s07); IFSeqDurSamp.st08(s08);
		IFSeqDurSamp.st09(s09); IFSeqDurSamp.st10(s10); IFSeqDurSamp.st11(s11); IFSeqDurSamp.st12(s12);
		IFSeqDurSamp.st13(s13); IFSeqDurSamp.st14(s14); IFSeqDurSamp.st15(s15); IFSeqDurSamp.st16(s16);
	}
}