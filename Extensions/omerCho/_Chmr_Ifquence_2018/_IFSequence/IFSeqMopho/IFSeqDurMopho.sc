IFSeqDurMopho {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqDurMopho01 = PatternProxy( Pseq([0.5], 1));
		~seqDurMopho02 = PatternProxy( Pseq([0.5], 1));
		~seqDurMopho03 = PatternProxy( Pseq([0.5], 1));
		~seqDurMopho04 = PatternProxy( Pseq([0.5], 1));
		~seqDurMopho05 = PatternProxy( Pseq([0.5], 1));
		~seqDurMopho06 = PatternProxy( Pseq([0.5], 1));
		~seqDurMopho07 = PatternProxy( Pseq([0.5], 1));
		~seqDurMopho08 = PatternProxy( Pseq([0.5], 1));

		~seqDurMopho09 = PatternProxy( Pseq([0.5], 1));
		~seqDurMopho10 = PatternProxy( Pseq([0.5], 1));
		~seqDurMopho11 = PatternProxy( Pseq([0.5], 1));
		~seqDurMopho12 = PatternProxy( Pseq([0.5], 1));
		~seqDurMopho13 = PatternProxy( Pseq([0.5], 1));
		~seqDurMopho14 = PatternProxy( Pseq([0.5], 1));
		~seqDurMopho15 = PatternProxy( Pseq([0.5], 1));
		~seqDurMopho16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqDurUpMopho01=0;
		~cntSeqDurRandMopho01=0;

		~cntSeqDurMopho01=0;
		~cntSeqDurMopho02=0;
		~cntSeqDurMopho03=0;
		~cntSeqDurMopho04=0;
		~cntSeqDurMopho05=0;
		~cntSeqDurMopho06=0;
		~cntSeqDurMopho07=0;
		~cntSeqDurMopho08=0;

		~cntSeqDurMopho09=0;
		~cntSeqDurMopho10=0;
		~cntSeqDurMopho11=0;
		~cntSeqDurMopho12=0;
		~cntSeqDurMopho13=0;
		~cntSeqDurMopho14=0;
		~cntSeqDurMopho15=0;
		~cntSeqDurMopho16=0;
	}
	*freeOn {
		~seqFreeMophoBut.free;
		~seqFreeMophoBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqDurMopho.stGrp(4);
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
				~cntSeqDurUpMopho01 = ~cntSeqDurUpMopho01 + 1;
				~cntSeqDurUpMopho01.switch(
					0,{},
					1,{IFSeqDurMopho.stGrp(1);},
					2,{IFSeqDurMopho.stGrp(2);},
					3,{IFSeqDurMopho.stGrp(3);},
					4,{IFSeqDurMopho.stGrp(4);},
					5,{IFSeqDurMopho.stGrp(5);
						~cntSeqDurUpMopho01=0;
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
				~cntSeqDurRandMopho01 = ~cntSeqDurRandMopho01 + 1;
				~cntSeqDurRandMopho01.switch(
					0,{},
					1,{
						IFSeqDurMopho.st01([1,2,3,4,5].choose);
						IFSeqDurMopho.st02([1,2,3,4,5].choose);
						IFSeqDurMopho.st03([1,2,3,4,5].choose);
						IFSeqDurMopho.st04([1,2,3,4,5].choose);
						IFSeqDurMopho.st05([1,2,3,4,5].choose);
						IFSeqDurMopho.st06([1,2,3,4,5].choose);
						IFSeqDurMopho.st07([1,2,3,4,5].choose);
						IFSeqDurMopho.st08([1,2,3,4,5].choose);

						IFSeqDurMopho.st09([1,2,3,4,5].choose);
						IFSeqDurMopho.st10([1,2,3,4,5].choose);
						IFSeqDurMopho.st11([1,2,3,4,5].choose);
						IFSeqDurMopho.st12([1,2,3,4,5].choose);
						IFSeqDurMopho.st13([1,2,3,4,5].choose);
						IFSeqDurMopho.st14([1,2,3,4,5].choose);
						IFSeqDurMopho.st15([1,2,3,4,5].choose);
						IFSeqDurMopho.st16([1,2,3,4,5].choose);
						~cntSeqDurRandMopho01=0;
					}
				)}
			);
			},
			'/seqRandMopho'
		);
	}


	*on { // Shift Durocity

		IFSeqDurMopho.randOn;
		IFSeqDurMopho.upOn;
		IFSeqDurMopho.freeOn;

		~ifSeqMophoBut01.free;
		~ifSeqMophoBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho01 = ~cntSeqDurMopho01 + 1;
				~cntSeqDurMopho01.switch(
					0,{},
					1, {IFSeqDurMopho.st01(1);},
					2, {IFSeqDurMopho.st01(2);},
					3, {IFSeqDurMopho.st01(3);},
					4, {IFSeqDurMopho.st01(4);},
					5, {IFSeqDurMopho.st01(5);}
				)}
			);
			},
			'/ifSeq/7/1'
		);
		~ifSeqMophoBut02.free;
		~ifSeqMophoBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho02 = ~cntSeqDurMopho02 + 1;
				~cntSeqDurMopho02.switch(
					0,{},
					1, {IFSeqDurMopho.st02(1);},
					2, {IFSeqDurMopho.st02(2);},
					3, {IFSeqDurMopho.st02(3);},
					4, {IFSeqDurMopho.st02(4);},
					5, {IFSeqDurMopho.st02(5);}
				)}
			);
			},
			'/ifSeq/7/2'
		);
		~ifSeqMophoBut03.free;
		~ifSeqMophoBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho03 = ~cntSeqDurMopho03 + 1;
				~cntSeqDurMopho03.switch(
					0,{},
					1, {IFSeqDurMopho.st03(1);},
					2, {IFSeqDurMopho.st03(2);},
					3, {IFSeqDurMopho.st03(3);},
					4, {IFSeqDurMopho.st03(4);},
					5, {IFSeqDurMopho.st03(5);}
				)}
			);
			},
			'/ifSeq/7/3'
		);
		~ifSeqMophoBut04.free;
		~ifSeqMophoBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho04 = ~cntSeqDurMopho04 + 1;
				~cntSeqDurMopho04.switch(
					0,{},
					1, {IFSeqDurMopho.st04(1);},
					2, {IFSeqDurMopho.st04(2);},
					3, {IFSeqDurMopho.st04(3);},
					4, {IFSeqDurMopho.st04(4);},
					5, {IFSeqDurMopho.st04(5);}
				)}
			);
			},
			'/ifSeq/7/4'
		);
		~ifSeqMophoBut05.free;
		~ifSeqMophoBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho05 = ~cntSeqDurMopho05 + 1;
				~cntSeqDurMopho05.switch(
					0,{},
					1, {IFSeqDurMopho.st05(1);},
					2, {IFSeqDurMopho.st05(2);},
					3, {IFSeqDurMopho.st05(3);},
					4, {IFSeqDurMopho.st05(4);},
					5, {IFSeqDurMopho.st05(5);}
				)}
			);
			},
			'/ifSeq/7/5'
		);
		~ifSeqMophoBut06.free;
		~ifSeqMophoBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho06 = ~cntSeqDurMopho06 + 1;
				~cntSeqDurMopho06.switch(
					0,{},
					1, {IFSeqDurMopho.st06(1);},
					2, {IFSeqDurMopho.st06(2);},
					3, {IFSeqDurMopho.st06(3);},
					4, {IFSeqDurMopho.st06(4);},
					5, {IFSeqDurMopho.st06(5);}
				)}
			);
			},
			'/ifSeq/7/6'
		);
		~ifSeqMophoBut07.free;
		~ifSeqMophoBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho07 = ~cntSeqDurMopho07 + 1;
				~cntSeqDurMopho07.switch(
					0,{},
					1, {IFSeqDurMopho.st07(1);},
					2, {IFSeqDurMopho.st07(2);},
					3, {IFSeqDurMopho.st07(3);},
					4, {IFSeqDurMopho.st07(4);},
					5, {IFSeqDurMopho.st07(5);}
				)}
			);
			},
			'/ifSeq/7/7'
		);
		~ifSeqMophoBut08.free;
		~ifSeqMophoBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho08 = ~cntSeqDurMopho08 + 1;
				~cntSeqDurMopho08.switch(
					0,{},
					1, {IFSeqDurMopho.st08(1);},
					2, {IFSeqDurMopho.st08(2);},
					3, {IFSeqDurMopho.st08(3);},
					4, {IFSeqDurMopho.st08(4);},
					5, {IFSeqDurMopho.st08(5);}
				)}
			);
			},
			'/ifSeq/7/8'
		);

		~ifSeqMophoBut09.free;
		~ifSeqMophoBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho09 = ~cntSeqDurMopho09 + 1;
				~cntSeqDurMopho09.switch(
					0,{},
					1, {IFSeqDurMopho.st09(1);},
					2, {IFSeqDurMopho.st09(2);},
					3, {IFSeqDurMopho.st09(3);},
					4, {IFSeqDurMopho.st09(4);},
					5, {IFSeqDurMopho.st09(5);}
				)}
			);
			},
			'/ifSeq/7/9'
		);
		~ifSeqMophoBut10.free;
		~ifSeqMophoBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho10 = ~cntSeqDurMopho10 + 1;
				~cntSeqDurMopho10.switch(
					0,{},
					1, {IFSeqDurMopho.st10(1);},
					2, {IFSeqDurMopho.st10(2);},
					3, {IFSeqDurMopho.st10(3);},
					4, {IFSeqDurMopho.st10(4);},
					5, {IFSeqDurMopho.st10(5);}
				)}
			);
			},
			'/ifSeq/7/10'
		);
		~ifSeqMophoBut11.free;
		~ifSeqMophoBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho11 = ~cntSeqDurMopho11 + 1;
				~cntSeqDurMopho11.switch(
					0,{},
					1, {IFSeqDurMopho.st11(1);},
					2, {IFSeqDurMopho.st11(2);},
					3, {IFSeqDurMopho.st11(3);},
					4, {IFSeqDurMopho.st11(4);},
					5, {IFSeqDurMopho.st11(5);}
				)}
			);
			},
			'/ifSeq/7/11'
		);
		~ifSeqMophoBut12.free;
		~ifSeqMophoBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho12 = ~cntSeqDurMopho12 + 1;
				~cntSeqDurMopho12.switch(
					0,{},
					1, {IFSeqDurMopho.st12(1);},
					2, {IFSeqDurMopho.st12(2);},
					3, {IFSeqDurMopho.st12(3);},
					4, {IFSeqDurMopho.st12(4);},
					5, {IFSeqDurMopho.st12(5);}
				)}
			);
			},
			'/ifSeq/7/12'
		);
		~ifSeqMophoBut13.free;
		~ifSeqMophoBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho13 = ~cntSeqDurMopho13 + 1;
				~cntSeqDurMopho13.switch(
					0,{},
					1, {IFSeqDurMopho.st13(1);},
					2, {IFSeqDurMopho.st13(2);},
					3, {IFSeqDurMopho.st13(3);},
					4, {IFSeqDurMopho.st13(4);},
					5, {IFSeqDurMopho.st13(5);}
				)}
			);
			},
			'/ifSeq/7/13'
		);
		~ifSeqMophoBut14.free;
		~ifSeqMophoBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho14 = ~cntSeqDurMopho14 + 1;
				~cntSeqDurMopho14.switch(
					0,{},
					1, {IFSeqDurMopho.st14(1);},
					2, {IFSeqDurMopho.st14(2);},
					3, {IFSeqDurMopho.st14(3);},
					4, {IFSeqDurMopho.st14(4);},
					5, {IFSeqDurMopho.st14(5);}
				)}
			);
			},
			'/ifSeq/7/14'
		);
		~ifSeqMophoBut15.free;
		~ifSeqMophoBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho15 = ~cntSeqDurMopho15 + 1;
				~cntSeqDurMopho15.switch(
					0,{},
					1, {IFSeqDurMopho.st15(1);},
					2, {IFSeqDurMopho.st15(2);},
					3, {IFSeqDurMopho.st15(3);},
					4, {IFSeqDurMopho.st15(4);},
					5, {IFSeqDurMopho.st15(5);}
				)}
			);
			},
			'/ifSeq/7/15'
		);
		~ifSeqMophoBut16.free;
		~ifSeqMophoBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurMopho16 = ~cntSeqDurMopho16 + 1;
				~cntSeqDurMopho16.switch(
					0,{},
					1, {IFSeqDurMopho.st16(1);},
					2, {IFSeqDurMopho.st16(2);},
					3, {IFSeqDurMopho.st16(3);},
					4, {IFSeqDurMopho.st16(4);},
					5, {IFSeqDurMopho.st16(5);}
				)}
			);
			},
			'/ifSeq/7/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho01.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho01', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho01.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho01', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho01.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho01', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho01.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho01', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho01', '1.5');
			~cntSeqDurMopho01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho02.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho02', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho02.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho02', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho02.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho02', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho02.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho02', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho02', '1.5');
			~cntSeqDurMopho02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho03.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho03', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho03.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho03', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho03.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho03', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho03.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho03', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho03', '1.5');
			~cntSeqDurMopho03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho04.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho04', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho04.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho04', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho04.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho04', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho04.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho04', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho04', '1.5');
			~cntSeqDurMopho04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho05.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho05', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho05.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho05', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho05.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho05', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho05.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho05', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho05', '1.5');
			~cntSeqDurMopho05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho06.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho06', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho06.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho06', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho06.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho06', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho06.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho06', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho06', '1.5');
			~cntSeqDurMopho06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho07.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho07', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho07.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho07', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho07.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho07', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho07.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho07', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho07', '1.5');
			~cntSeqDurMopho07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho08.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho08', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho08.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho08', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho08.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho08', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho08.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho08', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho08', '1.5');
			~cntSeqDurMopho08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho09.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho09', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho09.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho09', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho09.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho09', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho09.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho09', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho09', '1.5');
			~cntSeqDurMopho09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho10.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho10', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho10.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho10', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho10.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho10', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho10.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho10', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho10', '1.5');
			~cntSeqDurMopho10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho11.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho11', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho11.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho11', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho11.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho11', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho11.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho11', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho11', '1.5');
			~cntSeqDurMopho11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho12.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho12', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho12.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho12', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho12.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho12', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho12.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho12', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho12', '1.5');
			~cntSeqDurMopho12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho13.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho13', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho13.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho13', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho13.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho13', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho13.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho13', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho13', '1.5');
			~cntSeqDurMopho13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho14.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho14', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho14.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho14', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho14.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho14', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho14.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho14', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho14', '1.5');
			~cntSeqDurMopho14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho15.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho15', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho15.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho15', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho15.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho15', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho15.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho15', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho15', '1.5');
			~cntSeqDurMopho15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqDurMopho16.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurMopho16', '1/4');
		}
		{ i == 2 }  {
			~seqDurMopho16.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurMopho16', '1/3');
		}
		{ i == 3 }  {
			~seqDurMopho16.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurMopho16', '1/2');
		}
		{ i == 4 }  {
			~seqDurMopho16.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurMopho16', '1/1');
		}
		{ i == 5 }  {
			~seqDurMopho16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurMopho16', '1.5');
			~cntSeqDurMopho16=0;
		}
	}
	*stGrp {|i|
		IFSeqDurMopho.st01(i); IFSeqDurMopho.st02(i); IFSeqDurMopho.st03(i); IFSeqDurMopho.st04(i);
		IFSeqDurMopho.st05(i); IFSeqDurMopho.st06(i); IFSeqDurMopho.st07(i); IFSeqDurMopho.st08(i);
		IFSeqDurMopho.st09(i); IFSeqDurMopho.st10(i); IFSeqDurMopho.st11(i); IFSeqDurMopho.st12(i);
		IFSeqDurMopho.st13(i); IFSeqDurMopho.st14(i); IFSeqDurMopho.st15(i); IFSeqDurMopho.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqDurMopho.st01(s01); IFSeqDurMopho.st02(s02); IFSeqDurMopho.st03(s03); IFSeqDurMopho.st04(s04);
		IFSeqDurMopho.st05(s05); IFSeqDurMopho.st06(s06); IFSeqDurMopho.st07(s07); IFSeqDurMopho.st08(s08);
		IFSeqDurMopho.st09(s09); IFSeqDurMopho.st10(s10); IFSeqDurMopho.st11(s11); IFSeqDurMopho.st12(s12);
		IFSeqDurMopho.st13(s13); IFSeqDurMopho.st14(s14); IFSeqDurMopho.st15(s15); IFSeqDurMopho.st16(s16);
	}
}