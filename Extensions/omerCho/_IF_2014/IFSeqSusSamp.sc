IFSeqSusSamp {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqSusSamp01 = PatternProxy( Pseq([0.5], 1));
		~seqSusSamp02 = PatternProxy( Pseq([0.5], 1));
		~seqSusSamp03 = PatternProxy( Pseq([0.5], 1));
		~seqSusSamp04 = PatternProxy( Pseq([0.5], 1));
		~seqSusSamp05 = PatternProxy( Pseq([0.5], 1));
		~seqSusSamp06 = PatternProxy( Pseq([0.5], 1));
		~seqSusSamp07 = PatternProxy( Pseq([0.5], 1));
		~seqSusSamp08 = PatternProxy( Pseq([0.5], 1));

		~seqSusSamp09 = PatternProxy( Pseq([0.5], 1));
		~seqSusSamp10 = PatternProxy( Pseq([0.5], 1));
		~seqSusSamp11 = PatternProxy( Pseq([0.5], 1));
		~seqSusSamp12 = PatternProxy( Pseq([0.5], 1));
		~seqSusSamp13 = PatternProxy( Pseq([0.5], 1));
		~seqSusSamp14 = PatternProxy( Pseq([0.5], 1));
		~seqSusSamp15 = PatternProxy( Pseq([0.5], 1));
		~seqSusSamp16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqSusUpSamp01=0;
		~cntSeqSusRandSamp01=0;

		~cntSeqSusSamp01=0;
		~cntSeqSusSamp02=0;
		~cntSeqSusSamp03=0;
		~cntSeqSusSamp04=0;
		~cntSeqSusSamp05=0;
		~cntSeqSusSamp06=0;
		~cntSeqSusSamp07=0;
		~cntSeqSusSamp08=0;

		~cntSeqSusSamp09=0;
		~cntSeqSusSamp10=0;
		~cntSeqSusSamp11=0;
		~cntSeqSusSamp12=0;
		~cntSeqSusSamp13=0;
		~cntSeqSusSamp14=0;
		~cntSeqSusSamp15=0;
		~cntSeqSusSamp16=0;
	}
	*freeOn {
		~seqFreeSampBut.free;
		~seqFreeSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSusSamp.stGrp(1);
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
				~cntSeqSusUpSamp01 = ~cntSeqSusUpSamp01 + 1;
				~cntSeqSusUpSamp01.switch(
					0,{},
					1,{IFSeqSusSamp.stGrp(1);},
					2,{IFSeqSusSamp.stGrp(2);},
					3,{IFSeqSusSamp.stGrp(3);
						~cntSeqSusUpSamp01=0;
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
				~cntSeqSusRandSamp01 = ~cntSeqSusRandSamp01 + 1;
				~cntSeqSusRandSamp01.switch(
					0,{},
					1,{
						IFSeqSusSamp.st01([1,2,3,4,5].choose);
						IFSeqSusSamp.st02([1,2,3,4,5].choose);
						IFSeqSusSamp.st03([1,2,3,4,5].choose);
						IFSeqSusSamp.st04([1,2,3,4,5].choose);
						IFSeqSusSamp.st05([1,2,3,4,5].choose);
						IFSeqSusSamp.st06([1,2,3,4,5].choose);
						IFSeqSusSamp.st07([1,2,3,4,5].choose);
						IFSeqSusSamp.st08([1,2,3,4,5].choose);

						IFSeqSusSamp.st09([1,2,3,4,5].choose);
						IFSeqSusSamp.st10([1,2,3,4,5].choose);
						IFSeqSusSamp.st11([1,2,3,4,5].choose);
						IFSeqSusSamp.st12([1,2,3,4,5].choose);
						IFSeqSusSamp.st13([1,2,3,4,5].choose);
						IFSeqSusSamp.st14([1,2,3,4,5].choose);
						IFSeqSusSamp.st15([1,2,3,4,5].choose);
						IFSeqSusSamp.st16([1,2,3,4,5].choose);
						~cntSeqSusRandSamp01=0;
					}
				)}
			);
			},
			'/seqRandSamp'
		);
	}


	*on { // Shift Susocity

		IFSeqSusSamp.randOn;
		IFSeqSusSamp.upOn;
		IFSeqSusSamp.freeOn;

		~ifSeqSampBut01.free;
		~ifSeqSampBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp01 = ~cntSeqSusSamp01 + 1;
				~cntSeqSusSamp01.switch(
					0,{},
					1, {IFSeqSusSamp.st01(1);},
					2, {IFSeqSusSamp.st01(2);},
					3, {IFSeqSusSamp.st01(3);},
					4, {IFSeqSusSamp.st01(4);},
					5, {IFSeqSusSamp.st01(5);}
				)}
			);
			},
			'/ifSeq/6/1'
		);
		~ifSeqSampBut02.free;
		~ifSeqSampBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp02 = ~cntSeqSusSamp02 + 1;
				~cntSeqSusSamp02.switch(
					0,{},
					1, {IFSeqSusSamp.st02(1);},
					2, {IFSeqSusSamp.st02(2);},
					3, {IFSeqSusSamp.st02(3);},
					4, {IFSeqSusSamp.st02(4);},
					5, {IFSeqSusSamp.st02(5);}
				)}
			);
			},
			'/ifSeq/6/2'
		);
		~ifSeqSampBut03.free;
		~ifSeqSampBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp03 = ~cntSeqSusSamp03 + 1;
				~cntSeqSusSamp03.switch(
					0,{},
					1, {IFSeqSusSamp.st03(1);},
					2, {IFSeqSusSamp.st03(2);},
					3, {IFSeqSusSamp.st03(3);},
					4, {IFSeqSusSamp.st03(4);},
					5, {IFSeqSusSamp.st03(5);}
				)}
			);
			},
			'/ifSeq/6/3'
		);
		~ifSeqSampBut04.free;
		~ifSeqSampBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp04 = ~cntSeqSusSamp04 + 1;
				~cntSeqSusSamp04.switch(
					0,{},
					1, {IFSeqSusSamp.st04(1);},
					2, {IFSeqSusSamp.st04(2);},
					3, {IFSeqSusSamp.st04(3);},
					4, {IFSeqSusSamp.st04(4);},
					5, {IFSeqSusSamp.st04(5);}
				)}
			);
			},
			'/ifSeq/6/4'
		);
		~ifSeqSampBut05.free;
		~ifSeqSampBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp05 = ~cntSeqSusSamp05 + 1;
				~cntSeqSusSamp05.switch(
					0,{},
					1, {IFSeqSusSamp.st05(1);},
					2, {IFSeqSusSamp.st05(2);},
					3, {IFSeqSusSamp.st05(3);},
					4, {IFSeqSusSamp.st05(4);},
					5, {IFSeqSusSamp.st05(5);}
				)}
			);
			},
			'/ifSeq/6/5'
		);
		~ifSeqSampBut06.free;
		~ifSeqSampBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp06 = ~cntSeqSusSamp06 + 1;
				~cntSeqSusSamp06.switch(
					0,{},
					1, {IFSeqSusSamp.st06(1);},
					2, {IFSeqSusSamp.st06(2);},
					3, {IFSeqSusSamp.st06(3);},
					4, {IFSeqSusSamp.st06(4);},
					5, {IFSeqSusSamp.st06(5);}
				)}
			);
			},
			'/ifSeq/6/6'
		);
		~ifSeqSampBut07.free;
		~ifSeqSampBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp07 = ~cntSeqSusSamp07 + 1;
				~cntSeqSusSamp07.switch(
					0,{},
					1, {IFSeqSusSamp.st07(1);},
					2, {IFSeqSusSamp.st07(2);},
					3, {IFSeqSusSamp.st07(3);},
					4, {IFSeqSusSamp.st07(4);},
					5, {IFSeqSusSamp.st07(5);}
				)}
			);
			},
			'/ifSeq/6/7'
		);
		~ifSeqSampBut08.free;
		~ifSeqSampBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp08 = ~cntSeqSusSamp08 + 1;
				~cntSeqSusSamp08.switch(
					0,{},
					1, {IFSeqSusSamp.st08(1);},
					2, {IFSeqSusSamp.st08(2);},
					3, {IFSeqSusSamp.st08(3);},
					4, {IFSeqSusSamp.st08(4);},
					5, {IFSeqSusSamp.st08(5);}
				)}
			);
			},
			'/ifSeq/6/8'
		);

		~ifSeqSampBut09.free;
		~ifSeqSampBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp09 = ~cntSeqSusSamp09 + 1;
				~cntSeqSusSamp09.switch(
					0,{},
					1, {IFSeqSusSamp.st09(1);},
					2, {IFSeqSusSamp.st09(2);},
					3, {IFSeqSusSamp.st09(3);},
					4, {IFSeqSusSamp.st09(4);},
					5, {IFSeqSusSamp.st09(5);}
				)}
			);
			},
			'/ifSeq/6/9'
		);
		~ifSeqSampBut10.free;
		~ifSeqSampBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp10 = ~cntSeqSusSamp10 + 1;
				~cntSeqSusSamp10.switch(
					0,{},
					1, {IFSeqSusSamp.st10(1);},
					2, {IFSeqSusSamp.st10(2);},
					3, {IFSeqSusSamp.st10(3);},
					4, {IFSeqSusSamp.st10(4);},
					5, {IFSeqSusSamp.st10(5);}
				)}
			);
			},
			'/ifSeq/6/10'
		);
		~ifSeqSampBut11.free;
		~ifSeqSampBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp11 = ~cntSeqSusSamp11 + 1;
				~cntSeqSusSamp11.switch(
					0,{},
					1, {IFSeqSusSamp.st11(1);},
					2, {IFSeqSusSamp.st11(2);},
					3, {IFSeqSusSamp.st11(3);},
					4, {IFSeqSusSamp.st11(4);},
					5, {IFSeqSusSamp.st11(5);}
				)}
			);
			},
			'/ifSeq/6/11'
		);
		~ifSeqSampBut12.free;
		~ifSeqSampBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp12 = ~cntSeqSusSamp12 + 1;
				~cntSeqSusSamp12.switch(
					0,{},
					1, {IFSeqSusSamp.st12(1);},
					2, {IFSeqSusSamp.st12(2);},
					3, {IFSeqSusSamp.st12(3);},
					4, {IFSeqSusSamp.st12(4);},
					5, {IFSeqSusSamp.st12(5);}
				)}
			);
			},
			'/ifSeq/6/12'
		);
		~ifSeqSampBut13.free;
		~ifSeqSampBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp13 = ~cntSeqSusSamp13 + 1;
				~cntSeqSusSamp13.switch(
					0,{},
					1, {IFSeqSusSamp.st13(1);},
					2, {IFSeqSusSamp.st13(2);},
					3, {IFSeqSusSamp.st13(3);},
					4, {IFSeqSusSamp.st13(4);},
					5, {IFSeqSusSamp.st13(5);}
				)}
			);
			},
			'/ifSeq/6/13'
		);
		~ifSeqSampBut14.free;
		~ifSeqSampBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp14 = ~cntSeqSusSamp14 + 1;
				~cntSeqSusSamp14.switch(
					0,{},
					1, {IFSeqSusSamp.st14(1);},
					2, {IFSeqSusSamp.st14(2);},
					3, {IFSeqSusSamp.st14(3);},
					4, {IFSeqSusSamp.st14(4);},
					5, {IFSeqSusSamp.st14(5);}
				)}
			);
			},
			'/ifSeq/6/14'
		);
		~ifSeqSampBut15.free;
		~ifSeqSampBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp15 = ~cntSeqSusSamp15 + 1;
				~cntSeqSusSamp15.switch(
					0,{},
					1, {IFSeqSusSamp.st15(1);},
					2, {IFSeqSusSamp.st15(2);},
					3, {IFSeqSusSamp.st15(3);},
					4, {IFSeqSusSamp.st15(4);},
					5, {IFSeqSusSamp.st15(5);}
				)}
			);
			},
			'/ifSeq/6/15'
		);
		~ifSeqSampBut16.free;
		~ifSeqSampBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSamp16 = ~cntSeqSusSamp16 + 1;
				~cntSeqSusSamp16.switch(
					0,{},
					1, {IFSeqSusSamp.st16(1);},
					2, {IFSeqSusSamp.st16(2);},
					3, {IFSeqSusSamp.st16(3);},
					4, {IFSeqSusSamp.st16(4);},
					5, {IFSeqSusSamp.st16(5);}
				)}
			);
			},
			'/ifSeq/6/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp01', '1');
		}
		{ i == 2 }  {
			~seqSusSamp01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp01', '2');
		}
		{ i == 3 }  {
			~seqSusSamp01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp01', '3');
		}
		{ i == 4 }  {
			~seqSusSamp01.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp01', '4');
		}
		{ i == 5 }  {
			~seqSusSamp01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp01', '5');
			~cntSeqSusSamp01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp02', '1');
		}
		{ i == 2 }  {
			~seqSusSamp02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp02', '2');
		}
		{ i == 3 }  {
			~seqSusSamp02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp02', '3');
		}
		{ i == 4 }  {
			~seqSusSamp02.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp02', '4');
		}
		{ i == 5 }  {
			~seqSusSamp02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp02', '5');
			~cntSeqSusSamp02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp03', '1');
		}
		{ i == 2 }  {
			~seqSusSamp03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp03', '2');
		}
		{ i == 3 }  {
			~seqSusSamp03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp03', '3');
		}
		{ i == 4 }  {
			~seqSusSamp03.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp03', '4');
		}
		{ i == 5 }  {
			~seqSusSamp03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp03', '5');
			~cntSeqSusSamp03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp04', '1');
		}
		{ i == 2 }  {
			~seqSusSamp04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp04', '2');
		}
		{ i == 3 }  {
			~seqSusSamp04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp04', '3');
		}
		{ i == 4 }  {
			~seqSusSamp04.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp04', '4');
		}
		{ i == 5 }  {
			~seqSusSamp04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp04', '5');
			~cntSeqSusSamp04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp05', '1');
		}
		{ i == 2 }  {
			~seqSusSamp05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp05', '2');
		}
		{ i == 3 }  {
			~seqSusSamp05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp05', '3');
		}
		{ i == 4 }  {
			~seqSusSamp05.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp05', '4');
		}
		{ i == 5 }  {
			~seqSusSamp05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp05', '5');
			~cntSeqSusSamp05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp06', '1');
		}
		{ i == 2 }  {
			~seqSusSamp06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp06', '2');
		}
		{ i == 3 }  {
			~seqSusSamp06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp06', '3');
		}
		{ i == 4 }  {
			~seqSusSamp06.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp06', '4');
		}
		{ i == 5 }  {
			~seqSusSamp06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp06', '5');
			~cntSeqSusSamp06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp07', '1');
		}
		{ i == 2 }  {
			~seqSusSamp07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp07', '2');
		}
		{ i == 3 }  {
			~seqSusSamp07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp07', '3');
		}
		{ i == 4 }  {
			~seqSusSamp07.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp07', '4');
		}
		{ i == 5 }  {
			~seqSusSamp07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp07', '5');
			~cntSeqSusSamp07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp08', '1');
		}
		{ i == 2 }  {
			~seqSusSamp08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp08', '2');
		}
		{ i == 3 }  {
			~seqSusSamp08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp08', '3');
		}
		{ i == 4 }  {
			~seqSusSamp08.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp08', '4');
		}
		{ i == 5 }  {
			~seqSusSamp08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp08', '5');
			~cntSeqSusSamp08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp09', '1');
		}
		{ i == 2 }  {
			~seqSusSamp09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp09', '2');
		}
		{ i == 3 }  {
			~seqSusSamp09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp09', '3');
		}
		{ i == 4 }  {
			~seqSusSamp09.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp09', '4');
		}
		{ i == 5 }  {
			~seqSusSamp09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp09', '5');
			~cntSeqSusSamp09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp10', '1');
		}
		{ i == 2 }  {
			~seqSusSamp10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp10', '2');
		}
		{ i == 3 }  {
			~seqSusSamp10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp10', '3');
		}
		{ i == 4 }  {
			~seqSusSamp10.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp10', '4');
		}
		{ i == 5 }  {
			~seqSusSamp10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp10', '5');
			~cntSeqSusSamp10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp11', '1');
		}
		{ i == 2 }  {
			~seqSusSamp11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp11', '2');
		}
		{ i == 3 }  {
			~seqSusSamp11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp11', '3');
		}
		{ i == 4 }  {
			~seqSusSamp11.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp11', '4');
		}
		{ i == 5 }  {
			~seqSusSamp11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp11', '5');
			~cntSeqSusSamp11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp12', '1');
		}
		{ i == 2 }  {
			~seqSusSamp12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp12', '2');
		}
		{ i == 3 }  {
			~seqSusSamp12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp12', '3');
		}
		{ i == 4 }  {
			~seqSusSamp12.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp12', '4');
		}
		{ i == 5 }  {
			~seqSusSamp12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp12', '5');
			~cntSeqSusSamp12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp13', '1');
		}
		{ i == 2 }  {
			~seqSusSamp13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp13', '2');
		}
		{ i == 3 }  {
			~seqSusSamp13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp13', '3');
		}
		{ i == 4 }  {
			~seqSusSamp13.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp13', '4');
		}
		{ i == 5 }  {
			~seqSusSamp13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp13', '5');
			~cntSeqSusSamp13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp14', '1');
		}
		{ i == 2 }  {
			~seqSusSamp14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp14', '2');
		}
		{ i == 3 }  {
			~seqSusSamp14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp14', '3');
		}
		{ i == 4 }  {
			~seqSusSamp14.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp14', '4');
		}
		{ i == 5 }  {
			~seqSusSamp14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp14', '5');
			~cntSeqSusSamp14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp15', '1');
		}
		{ i == 2 }  {
			~seqSusSamp15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp15', '2');
		}
		{ i == 3 }  {
			~seqSusSamp15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp15', '3');
		}
		{ i == 4 }  {
			~seqSusSamp15.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp15', '4');
		}
		{ i == 5 }  {
			~seqSusSamp15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp15', '5');
			~cntSeqSusSamp15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqSusSamp16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp16', '1');
		}
		{ i == 2 }  {
			~seqSusSamp16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSamp16', '2');
		}
		{ i == 3 }  {
			~seqSusSamp16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSamp16', '3');
		}
		{ i == 4 }  {
			~seqSusSamp16.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSamp16', '4');
		}
		{ i == 5 }  {
			~seqSusSamp16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSamp16', '5');
			~cntSeqSusSamp16=0;
		}
	}
	*stGrp {|i|
		IFSeqSusSamp.st01(i); IFSeqSusSamp.st02(i); IFSeqSusSamp.st03(i); IFSeqSusSamp.st04(i);
		IFSeqSusSamp.st05(i); IFSeqSusSamp.st06(i); IFSeqSusSamp.st07(i); IFSeqSusSamp.st08(i);
		IFSeqSusSamp.st09(i); IFSeqSusSamp.st10(i); IFSeqSusSamp.st11(i); IFSeqSusSamp.st12(i);
		IFSeqSusSamp.st13(i); IFSeqSusSamp.st14(i); IFSeqSusSamp.st15(i); IFSeqSusSamp.st16(i);
	}
}