IFSeqSusMopho {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqSusMopho01 = PatternProxy( Pseq([0.5], 1));
		~seqSusMopho02 = PatternProxy( Pseq([0.5], 1));
		~seqSusMopho03 = PatternProxy( Pseq([0.5], 1));
		~seqSusMopho04 = PatternProxy( Pseq([0.5], 1));
		~seqSusMopho05 = PatternProxy( Pseq([0.5], 1));
		~seqSusMopho06 = PatternProxy( Pseq([0.5], 1));
		~seqSusMopho07 = PatternProxy( Pseq([0.5], 1));
		~seqSusMopho08 = PatternProxy( Pseq([0.5], 1));

		~seqSusMopho09 = PatternProxy( Pseq([0.5], 1));
		~seqSusMopho10 = PatternProxy( Pseq([0.5], 1));
		~seqSusMopho11 = PatternProxy( Pseq([0.5], 1));
		~seqSusMopho12 = PatternProxy( Pseq([0.5], 1));
		~seqSusMopho13 = PatternProxy( Pseq([0.5], 1));
		~seqSusMopho14 = PatternProxy( Pseq([0.5], 1));
		~seqSusMopho15 = PatternProxy( Pseq([0.5], 1));
		~seqSusMopho16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqSusUpMopho01=0;
		~cntSeqSusRandMopho01=0;

		~cntSeqSusMopho01=0;
		~cntSeqSusMopho02=0;
		~cntSeqSusMopho03=0;
		~cntSeqSusMopho04=0;
		~cntSeqSusMopho05=0;
		~cntSeqSusMopho06=0;
		~cntSeqSusMopho07=0;
		~cntSeqSusMopho08=0;

		~cntSeqSusMopho09=0;
		~cntSeqSusMopho10=0;
		~cntSeqSusMopho11=0;
		~cntSeqSusMopho12=0;
		~cntSeqSusMopho13=0;
		~cntSeqSusMopho14=0;
		~cntSeqSusMopho15=0;
		~cntSeqSusMopho16=0;
	}
	*freeOn {
		~seqFreeMophoBut.free;
		~seqFreeMophoBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSusMopho.stGrp(1);
				});
			},
			'/seqFreeMopho'
		);
	}
	*upOn {
		~ifSeqUpMophoBut.free;
		~ifSeqUpMophoBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusUpMopho01 = ~cntSeqSusUpMopho01 + 1;
				~cntSeqSusUpMopho01.switch(
					0,{},
					1,{IFSeqSusMopho.stGrp(1);},
					2,{IFSeqSusMopho.stGrp(2);},
					3,{IFSeqSusMopho.stGrp(3);
						~cntSeqSusUpMopho01=0;
					}
				)}
			);
			},
			'/seqUpMopho'
		);
	}

	*randOn {
		~ifSeqRandMophoBut.free;
		~ifSeqRandMophoBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusRandMopho01 = ~cntSeqSusRandMopho01 + 1;
				~cntSeqSusRandMopho01.switch(
					0,{},
					1,{
						IFSeqSusMopho.st01([1,2,3,4,5].choose);
						IFSeqSusMopho.st02([1,2,3,4,5].choose);
						IFSeqSusMopho.st03([1,2,3,4,5].choose);
						IFSeqSusMopho.st04([1,2,3,4,5].choose);
						IFSeqSusMopho.st05([1,2,3,4,5].choose);
						IFSeqSusMopho.st06([1,2,3,4,5].choose);
						IFSeqSusMopho.st07([1,2,3,4,5].choose);
						IFSeqSusMopho.st08([1,2,3,4,5].choose);

						IFSeqSusMopho.st09([1,2,3,4,5].choose);
						IFSeqSusMopho.st10([1,2,3,4,5].choose);
						IFSeqSusMopho.st11([1,2,3,4,5].choose);
						IFSeqSusMopho.st12([1,2,3,4,5].choose);
						IFSeqSusMopho.st13([1,2,3,4,5].choose);
						IFSeqSusMopho.st14([1,2,3,4,5].choose);
						IFSeqSusMopho.st15([1,2,3,4,5].choose);
						IFSeqSusMopho.st16([1,2,3,4,5].choose);
						~cntSeqSusRandMopho01=0;
					}
				)}
			);
			},
			'/seqRandMopho'
		);
	}


	*on { // Shift Susocity

		IFSeqSusMopho.randOn;
		IFSeqSusMopho.upOn;
		IFSeqSusMopho.freeOn;

		~ifSeqMophoBut01.free;
		~ifSeqMophoBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho01 = ~cntSeqSusMopho01 + 1;
				~cntSeqSusMopho01.switch(
					0,{},
					1, {IFSeqSusMopho.st01(1);},
					2, {IFSeqSusMopho.st01(2);},
					3, {IFSeqSusMopho.st01(3);},
					4, {IFSeqSusMopho.st01(4);},
					5, {IFSeqSusMopho.st01(5);}
				)}
			);
			},
			'/ifSeq/6/1'
		);
		~ifSeqMophoBut02.free;
		~ifSeqMophoBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho02 = ~cntSeqSusMopho02 + 1;
				~cntSeqSusMopho02.switch(
					0,{},
					1, {IFSeqSusMopho.st02(1);},
					2, {IFSeqSusMopho.st02(2);},
					3, {IFSeqSusMopho.st02(3);},
					4, {IFSeqSusMopho.st02(4);},
					5, {IFSeqSusMopho.st02(5);}
				)}
			);
			},
			'/ifSeq/6/2'
		);
		~ifSeqMophoBut03.free;
		~ifSeqMophoBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho03 = ~cntSeqSusMopho03 + 1;
				~cntSeqSusMopho03.switch(
					0,{},
					1, {IFSeqSusMopho.st03(1);},
					2, {IFSeqSusMopho.st03(2);},
					3, {IFSeqSusMopho.st03(3);},
					4, {IFSeqSusMopho.st03(4);},
					5, {IFSeqSusMopho.st03(5);}
				)}
			);
			},
			'/ifSeq/6/3'
		);
		~ifSeqMophoBut04.free;
		~ifSeqMophoBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho04 = ~cntSeqSusMopho04 + 1;
				~cntSeqSusMopho04.switch(
					0,{},
					1, {IFSeqSusMopho.st04(1);},
					2, {IFSeqSusMopho.st04(2);},
					3, {IFSeqSusMopho.st04(3);},
					4, {IFSeqSusMopho.st04(4);},
					5, {IFSeqSusMopho.st04(5);}
				)}
			);
			},
			'/ifSeq/6/4'
		);
		~ifSeqMophoBut05.free;
		~ifSeqMophoBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho05 = ~cntSeqSusMopho05 + 1;
				~cntSeqSusMopho05.switch(
					0,{},
					1, {IFSeqSusMopho.st05(1);},
					2, {IFSeqSusMopho.st05(2);},
					3, {IFSeqSusMopho.st05(3);},
					4, {IFSeqSusMopho.st05(4);},
					5, {IFSeqSusMopho.st05(5);}
				)}
			);
			},
			'/ifSeq/6/5'
		);
		~ifSeqMophoBut06.free;
		~ifSeqMophoBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho06 = ~cntSeqSusMopho06 + 1;
				~cntSeqSusMopho06.switch(
					0,{},
					1, {IFSeqSusMopho.st06(1);},
					2, {IFSeqSusMopho.st06(2);},
					3, {IFSeqSusMopho.st06(3);},
					4, {IFSeqSusMopho.st06(4);},
					5, {IFSeqSusMopho.st06(5);}
				)}
			);
			},
			'/ifSeq/6/6'
		);
		~ifSeqMophoBut07.free;
		~ifSeqMophoBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho07 = ~cntSeqSusMopho07 + 1;
				~cntSeqSusMopho07.switch(
					0,{},
					1, {IFSeqSusMopho.st07(1);},
					2, {IFSeqSusMopho.st07(2);},
					3, {IFSeqSusMopho.st07(3);},
					4, {IFSeqSusMopho.st07(4);},
					5, {IFSeqSusMopho.st07(5);}
				)}
			);
			},
			'/ifSeq/6/7'
		);
		~ifSeqMophoBut08.free;
		~ifSeqMophoBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho08 = ~cntSeqSusMopho08 + 1;
				~cntSeqSusMopho08.switch(
					0,{},
					1, {IFSeqSusMopho.st08(1);},
					2, {IFSeqSusMopho.st08(2);},
					3, {IFSeqSusMopho.st08(3);},
					4, {IFSeqSusMopho.st08(4);},
					5, {IFSeqSusMopho.st08(5);}
				)}
			);
			},
			'/ifSeq/6/8'
		);

		~ifSeqMophoBut09.free;
		~ifSeqMophoBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho09 = ~cntSeqSusMopho09 + 1;
				~cntSeqSusMopho09.switch(
					0,{},
					1, {IFSeqSusMopho.st09(1);},
					2, {IFSeqSusMopho.st09(2);},
					3, {IFSeqSusMopho.st09(3);},
					4, {IFSeqSusMopho.st09(4);},
					5, {IFSeqSusMopho.st09(5);}
				)}
			);
			},
			'/ifSeq/6/9'
		);
		~ifSeqMophoBut10.free;
		~ifSeqMophoBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho10 = ~cntSeqSusMopho10 + 1;
				~cntSeqSusMopho10.switch(
					0,{},
					1, {IFSeqSusMopho.st10(1);},
					2, {IFSeqSusMopho.st10(2);},
					3, {IFSeqSusMopho.st10(3);},
					4, {IFSeqSusMopho.st10(4);},
					5, {IFSeqSusMopho.st10(5);}
				)}
			);
			},
			'/ifSeq/6/10'
		);
		~ifSeqMophoBut11.free;
		~ifSeqMophoBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho11 = ~cntSeqSusMopho11 + 1;
				~cntSeqSusMopho11.switch(
					0,{},
					1, {IFSeqSusMopho.st11(1);},
					2, {IFSeqSusMopho.st11(2);},
					3, {IFSeqSusMopho.st11(3);},
					4, {IFSeqSusMopho.st11(4);},
					5, {IFSeqSusMopho.st11(5);}
				)}
			);
			},
			'/ifSeq/6/11'
		);
		~ifSeqMophoBut12.free;
		~ifSeqMophoBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho12 = ~cntSeqSusMopho12 + 1;
				~cntSeqSusMopho12.switch(
					0,{},
					1, {IFSeqSusMopho.st12(1);},
					2, {IFSeqSusMopho.st12(2);},
					3, {IFSeqSusMopho.st12(3);},
					4, {IFSeqSusMopho.st12(4);},
					5, {IFSeqSusMopho.st12(5);}
				)}
			);
			},
			'/ifSeq/6/12'
		);
		~ifSeqMophoBut13.free;
		~ifSeqMophoBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho13 = ~cntSeqSusMopho13 + 1;
				~cntSeqSusMopho13.switch(
					0,{},
					1, {IFSeqSusMopho.st13(1);},
					2, {IFSeqSusMopho.st13(2);},
					3, {IFSeqSusMopho.st13(3);},
					4, {IFSeqSusMopho.st13(4);},
					5, {IFSeqSusMopho.st13(5);}
				)}
			);
			},
			'/ifSeq/6/13'
		);
		~ifSeqMophoBut14.free;
		~ifSeqMophoBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho14 = ~cntSeqSusMopho14 + 1;
				~cntSeqSusMopho14.switch(
					0,{},
					1, {IFSeqSusMopho.st14(1);},
					2, {IFSeqSusMopho.st14(2);},
					3, {IFSeqSusMopho.st14(3);},
					4, {IFSeqSusMopho.st14(4);},
					5, {IFSeqSusMopho.st14(5);}
				)}
			);
			},
			'/ifSeq/6/14'
		);
		~ifSeqMophoBut15.free;
		~ifSeqMophoBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho15 = ~cntSeqSusMopho15 + 1;
				~cntSeqSusMopho15.switch(
					0,{},
					1, {IFSeqSusMopho.st15(1);},
					2, {IFSeqSusMopho.st15(2);},
					3, {IFSeqSusMopho.st15(3);},
					4, {IFSeqSusMopho.st15(4);},
					5, {IFSeqSusMopho.st15(5);}
				)}
			);
			},
			'/ifSeq/6/15'
		);
		~ifSeqMophoBut16.free;
		~ifSeqMophoBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusMopho16 = ~cntSeqSusMopho16 + 1;
				~cntSeqSusMopho16.switch(
					0,{},
					1, {IFSeqSusMopho.st16(1);},
					2, {IFSeqSusMopho.st16(2);},
					3, {IFSeqSusMopho.st16(3);},
					4, {IFSeqSusMopho.st16(4);},
					5, {IFSeqSusMopho.st16(5);}
				)}
			);
			},
			'/ifSeq/6/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho01', '1');
		}
		{ i == 2 }  {
			~seqSusMopho01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho01', '2');
		}
		{ i == 3 }  {
			~seqSusMopho01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho01', '3');
		}
		{ i == 4 }  {
			~seqSusMopho01.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho01', '4');
		}
		{ i == 5 }  {
			~seqSusMopho01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho01', '5');
			~cntSeqSusMopho01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho02', '1');
		}
		{ i == 2 }  {
			~seqSusMopho02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho02', '2');
		}
		{ i == 3 }  {
			~seqSusMopho02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho02', '3');
		}
		{ i == 4 }  {
			~seqSusMopho02.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho02', '4');
		}
		{ i == 5 }  {
			~seqSusMopho02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho02', '5');
			~cntSeqSusMopho02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho03', '1');
		}
		{ i == 2 }  {
			~seqSusMopho03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho03', '2');
		}
		{ i == 3 }  {
			~seqSusMopho03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho03', '3');
		}
		{ i == 4 }  {
			~seqSusMopho03.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho03', '4');
		}
		{ i == 5 }  {
			~seqSusMopho03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho03', '5');
			~cntSeqSusMopho03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho04', '1');
		}
		{ i == 2 }  {
			~seqSusMopho04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho04', '2');
		}
		{ i == 3 }  {
			~seqSusMopho04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho04', '3');
		}
		{ i == 4 }  {
			~seqSusMopho04.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho04', '4');
		}
		{ i == 5 }  {
			~seqSusMopho04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho04', '5');
			~cntSeqSusMopho04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho05', '1');
		}
		{ i == 2 }  {
			~seqSusMopho05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho05', '2');
		}
		{ i == 3 }  {
			~seqSusMopho05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho05', '3');
		}
		{ i == 4 }  {
			~seqSusMopho05.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho05', '4');
		}
		{ i == 5 }  {
			~seqSusMopho05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho05', '5');
			~cntSeqSusMopho05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho06', '1');
		}
		{ i == 2 }  {
			~seqSusMopho06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho06', '2');
		}
		{ i == 3 }  {
			~seqSusMopho06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho06', '3');
		}
		{ i == 4 }  {
			~seqSusMopho06.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho06', '4');
		}
		{ i == 5 }  {
			~seqSusMopho06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho06', '5');
			~cntSeqSusMopho06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho07', '1');
		}
		{ i == 2 }  {
			~seqSusMopho07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho07', '2');
		}
		{ i == 3 }  {
			~seqSusMopho07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho07', '3');
		}
		{ i == 4 }  {
			~seqSusMopho07.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho07', '4');
		}
		{ i == 5 }  {
			~seqSusMopho07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho07', '5');
			~cntSeqSusMopho07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho08', '1');
		}
		{ i == 2 }  {
			~seqSusMopho08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho08', '2');
		}
		{ i == 3 }  {
			~seqSusMopho08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho08', '3');
		}
		{ i == 4 }  {
			~seqSusMopho08.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho08', '4');
		}
		{ i == 5 }  {
			~seqSusMopho08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho08', '5');
			~cntSeqSusMopho08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho09', '1');
		}
		{ i == 2 }  {
			~seqSusMopho09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho09', '2');
		}
		{ i == 3 }  {
			~seqSusMopho09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho09', '3');
		}
		{ i == 4 }  {
			~seqSusMopho09.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho09', '4');
		}
		{ i == 5 }  {
			~seqSusMopho09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho09', '5');
			~cntSeqSusMopho09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho10', '1');
		}
		{ i == 2 }  {
			~seqSusMopho10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho10', '2');
		}
		{ i == 3 }  {
			~seqSusMopho10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho10', '3');
		}
		{ i == 4 }  {
			~seqSusMopho10.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho10', '4');
		}
		{ i == 5 }  {
			~seqSusMopho10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho10', '5');
			~cntSeqSusMopho10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho11', '1');
		}
		{ i == 2 }  {
			~seqSusMopho11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho11', '2');
		}
		{ i == 3 }  {
			~seqSusMopho11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho11', '3');
		}
		{ i == 4 }  {
			~seqSusMopho11.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho11', '4');
		}
		{ i == 5 }  {
			~seqSusMopho11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho11', '5');
			~cntSeqSusMopho11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho12', '1');
		}
		{ i == 2 }  {
			~seqSusMopho12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho12', '2');
		}
		{ i == 3 }  {
			~seqSusMopho12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho12', '3');
		}
		{ i == 4 }  {
			~seqSusMopho12.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho12', '4');
		}
		{ i == 5 }  {
			~seqSusMopho12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho12', '5');
			~cntSeqSusMopho12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho13', '1');
		}
		{ i == 2 }  {
			~seqSusMopho13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho13', '2');
		}
		{ i == 3 }  {
			~seqSusMopho13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho13', '3');
		}
		{ i == 4 }  {
			~seqSusMopho13.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho13', '4');
		}
		{ i == 5 }  {
			~seqSusMopho13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho13', '5');
			~cntSeqSusMopho13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho14', '1');
		}
		{ i == 2 }  {
			~seqSusMopho14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho14', '2');
		}
		{ i == 3 }  {
			~seqSusMopho14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho14', '3');
		}
		{ i == 4 }  {
			~seqSusMopho14.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho14', '4');
		}
		{ i == 5 }  {
			~seqSusMopho14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho14', '5');
			~cntSeqSusMopho14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho15', '1');
		}
		{ i == 2 }  {
			~seqSusMopho15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho15', '2');
		}
		{ i == 3 }  {
			~seqSusMopho15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho15', '3');
		}
		{ i == 4 }  {
			~seqSusMopho15.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho15', '4');
		}
		{ i == 5 }  {
			~seqSusMopho15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho15', '5');
			~cntSeqSusMopho15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqSusMopho16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho16', '1');
		}
		{ i == 2 }  {
			~seqSusMopho16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusMopho16', '2');
		}
		{ i == 3 }  {
			~seqSusMopho16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusMopho16', '3');
		}
		{ i == 4 }  {
			~seqSusMopho16.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusMopho16', '4');
		}
		{ i == 5 }  {
			~seqSusMopho16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusMopho16', '5');
			~cntSeqSusMopho16=0;
		}
	}
	*stGrp {|i|
		IFSeqSusMopho.st01(i); IFSeqSusMopho.st02(i); IFSeqSusMopho.st03(i); IFSeqSusMopho.st04(i);
		IFSeqSusMopho.st05(i); IFSeqSusMopho.st06(i); IFSeqSusMopho.st07(i); IFSeqSusMopho.st08(i);
		IFSeqSusMopho.st09(i); IFSeqSusMopho.st10(i); IFSeqSusMopho.st11(i); IFSeqSusMopho.st12(i);
		IFSeqSusMopho.st13(i); IFSeqSusMopho.st14(i); IFSeqSusMopho.st15(i); IFSeqSusMopho.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqSusMopho.st01(s01); IFSeqSusMopho.st02(s02); IFSeqSusMopho.st03(s03); IFSeqSusMopho.st04(s04);
		IFSeqSusMopho.st05(s05); IFSeqSusMopho.st06(s06); IFSeqSusMopho.st07(s07); IFSeqSusMopho.st08(s08);
		IFSeqSusMopho.st09(s09); IFSeqSusMopho.st10(s10); IFSeqSusMopho.st11(s11); IFSeqSusMopho.st12(s12);
		IFSeqSusMopho.st13(s13); IFSeqSusMopho.st14(s14); IFSeqSusMopho.st15(s15); IFSeqSusMopho.st16(s16);
	}
}