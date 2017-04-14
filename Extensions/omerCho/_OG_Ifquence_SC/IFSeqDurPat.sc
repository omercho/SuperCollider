IFSeqDurPat {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~durMul = PatternProxy( Pseq([2], inf));
		~durMulP= Pseq([~durMul], inf).asStream;

		~dur = PatternProxy(
			Pseq([
				2
			],inf);
		);
		~durP= Pseq([~dur], inf).asStream;



		~seqDurPat01 = PatternProxy( Pseq([1], 1));
		~seqDurPat02 = PatternProxy( Pseq([1], 1));
		~seqDurPat03 = PatternProxy( Pseq([1], 1));
		~seqDurPat04 = PatternProxy( Pseq([1], 1));
		~seqDurPat05 = PatternProxy( Pseq([1], 1));
		~seqDurPat06 = PatternProxy( Pseq([1], 1));
		~seqDurPat07 = PatternProxy( Pseq([1], 1));
		~seqDurPat08 = PatternProxy( Pseq([1], 1));

		~seqDurPat09 = PatternProxy( Pseq([1], 1));
		~seqDurPat10 = PatternProxy( Pseq([1], 1));
		~seqDurPat11 = PatternProxy( Pseq([1], 1));
		~seqDurPat12 = PatternProxy( Pseq([1], 1));
		~seqDurPat13 = PatternProxy( Pseq([1], 1));
		~seqDurPat14 = PatternProxy( Pseq([1], 1));
		~seqDurPat15 = PatternProxy( Pseq([1], 1));
		~seqDurPat16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqDurUpPat01=0;
		~cntSeqDurRandPat01=0;

		~cntSeqDurPat01=0;
		~cntSeqDurPat02=0;
		~cntSeqDurPat03=0;
		~cntSeqDurPat04=0;
		~cntSeqDurPat05=0;
		~cntSeqDurPat06=0;
		~cntSeqDurPat07=0;
		~cntSeqDurPat08=0;

		~cntSeqDurPat09=0;
		~cntSeqDurPat10=0;
		~cntSeqDurPat11=0;
		~cntSeqDurPat12=0;
		~cntSeqDurPat13=0;
		~cntSeqDurPat14=0;
		~cntSeqDurPat15=0;
		~cntSeqDurPat16=0;
	}
	*freeOn {
		~seqFreePatBut.free;
		~seqFreePatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqDurPat.stGrp(4);
				});
			},
			'/seqFreePat'
		);
	}
	*upOn {
		~ifSeqUpPatBut.free;
		~ifSeqUpPatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurUpPat01 = ~cntSeqDurUpPat01 + 1;
				~cntSeqDurUpPat01.switch(
					0,{},
					1,{IFSeqDurPat.stGrp(1);},
					2,{IFSeqDurPat.stGrp(2);},
					3,{IFSeqDurPat.stGrp(3);},
					4,{IFSeqDurPat.stGrp(4);},
					5,{IFSeqDurPat.stGrp(5);
						~cntSeqDurUpPat01=0;
					}
				)}
			);
			},
			'/seqUpPat'
		);
	}

	*randOn {
		~ifSeqRandPatBut.free;
		~ifSeqRandPatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurRandPat01 = ~cntSeqDurRandPat01 + 1;
				~cntSeqDurRandPat01.switch(
					0,{},
					1,{
						IFSeqDurPat.st01([1,2,3,4,5].choose);
						IFSeqDurPat.st02([1,2,3,4,5].choose);
						IFSeqDurPat.st03([1,2,3,4,5].choose);
						IFSeqDurPat.st04([1,2,3,4,5].choose);
						IFSeqDurPat.st05([1,2,3,4,5].choose);
						IFSeqDurPat.st06([1,2,3,4,5].choose);
						IFSeqDurPat.st07([1,2,3,4,5].choose);
						IFSeqDurPat.st08([1,2,3,4,5].choose);

						IFSeqDurPat.st09([1,2,3,4,5].choose);
						IFSeqDurPat.st10([1,2,3,4,5].choose);
						IFSeqDurPat.st11([1,2,3,4,5].choose);
						IFSeqDurPat.st12([1,2,3,4,5].choose);
						IFSeqDurPat.st13([1,2,3,4,5].choose);
						IFSeqDurPat.st14([1,2,3,4,5].choose);
						IFSeqDurPat.st15([1,2,3,4,5].choose);
						IFSeqDurPat.st16([1,2,3,4,5].choose);
						~cntSeqDurRandPat01=0;
					}
				)}
			);
			},
			'/seqRandPat'
		);
	}


	*on { // Shift Durocity

		IFSeqDurPat.randOn;
		IFSeqDurPat.upOn;
		IFSeqDurPat.freeOn;

		~ifSeqPatBut01.free;
		~ifSeqPatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat01 = ~cntSeqDurPat01 + 1;
				~cntSeqDurPat01.switch(
					0,{},
					1, {IFSeqDurPat.st01(1);},
					2, {IFSeqDurPat.st01(2);},
					3, {IFSeqDurPat.st01(3);},
					4, {IFSeqDurPat.st01(4);},
					5, {IFSeqDurPat.st01(5);}
				)}
			);
			},
			'/ifSeq/7/1'
		);
		~ifSeqPatBut02.free;
		~ifSeqPatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat02 = ~cntSeqDurPat02 + 1;
				~cntSeqDurPat02.switch(
					0,{},
					1, {IFSeqDurPat.st02(1);},
					2, {IFSeqDurPat.st02(2);},
					3, {IFSeqDurPat.st02(3);},
					4, {IFSeqDurPat.st02(4);},
					5, {IFSeqDurPat.st02(5);}
				)}
			);
			},
			'/ifSeq/7/2'
		);
		~ifSeqPatBut03.free;
		~ifSeqPatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat03 = ~cntSeqDurPat03 + 1;
				~cntSeqDurPat03.switch(
					0,{},
					1, {IFSeqDurPat.st03(1);},
					2, {IFSeqDurPat.st03(2);},
					3, {IFSeqDurPat.st03(3);},
					4, {IFSeqDurPat.st03(4);},
					5, {IFSeqDurPat.st03(5);}
				)}
			);
			},
			'/ifSeq/7/3'
		);
		~ifSeqPatBut04.free;
		~ifSeqPatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat04 = ~cntSeqDurPat04 + 1;
				~cntSeqDurPat04.switch(
					0,{},
					1, {IFSeqDurPat.st04(1);},
					2, {IFSeqDurPat.st04(2);},
					3, {IFSeqDurPat.st04(3);},
					4, {IFSeqDurPat.st04(4);},
					5, {IFSeqDurPat.st04(5);}
				)}
			);
			},
			'/ifSeq/7/4'
		);
		~ifSeqPatBut05.free;
		~ifSeqPatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat05 = ~cntSeqDurPat05 + 1;
				~cntSeqDurPat05.switch(
					0,{},
					1, {IFSeqDurPat.st05(1);},
					2, {IFSeqDurPat.st05(2);},
					3, {IFSeqDurPat.st05(3);},
					4, {IFSeqDurPat.st05(4);},
					5, {IFSeqDurPat.st05(5);}
				)}
			);
			},
			'/ifSeq/7/5'
		);
		~ifSeqPatBut06.free;
		~ifSeqPatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat06 = ~cntSeqDurPat06 + 1;
				~cntSeqDurPat06.switch(
					0,{},
					1, {IFSeqDurPat.st06(1);},
					2, {IFSeqDurPat.st06(2);},
					3, {IFSeqDurPat.st06(3);},
					4, {IFSeqDurPat.st06(4);},
					5, {IFSeqDurPat.st06(5);}
				)}
			);
			},
			'/ifSeq/7/6'
		);
		~ifSeqPatBut07.free;
		~ifSeqPatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat07 = ~cntSeqDurPat07 + 1;
				~cntSeqDurPat07.switch(
					0,{},
					1, {IFSeqDurPat.st07(1);},
					2, {IFSeqDurPat.st07(2);},
					3, {IFSeqDurPat.st07(3);},
					4, {IFSeqDurPat.st07(4);},
					5, {IFSeqDurPat.st07(5);}
				)}
			);
			},
			'/ifSeq/7/7'
		);
		~ifSeqPatBut08.free;
		~ifSeqPatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat08 = ~cntSeqDurPat08 + 1;
				~cntSeqDurPat08.switch(
					0,{},
					1, {IFSeqDurPat.st08(1);},
					2, {IFSeqDurPat.st08(2);},
					3, {IFSeqDurPat.st08(3);},
					4, {IFSeqDurPat.st08(4);},
					5, {IFSeqDurPat.st08(5);}
				)}
			);
			},
			'/ifSeq/7/8'
		);

		~ifSeqPatBut09.free;
		~ifSeqPatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat09 = ~cntSeqDurPat09 + 1;
				~cntSeqDurPat09.switch(
					0,{},
					1, {IFSeqDurPat.st09(1);},
					2, {IFSeqDurPat.st09(2);},
					3, {IFSeqDurPat.st09(3);},
					4, {IFSeqDurPat.st09(4);},
					5, {IFSeqDurPat.st09(5);}
				)}
			);
			},
			'/ifSeq/7/9'
		);
		~ifSeqPatBut10.free;
		~ifSeqPatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat10 = ~cntSeqDurPat10 + 1;
				~cntSeqDurPat10.switch(
					0,{},
					1, {IFSeqDurPat.st10(1);},
					2, {IFSeqDurPat.st10(2);},
					3, {IFSeqDurPat.st10(3);},
					4, {IFSeqDurPat.st10(4);},
					5, {IFSeqDurPat.st10(5);}
				)}
			);
			},
			'/ifSeq/7/10'
		);
		~ifSeqPatBut11.free;
		~ifSeqPatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat11 = ~cntSeqDurPat11 + 1;
				~cntSeqDurPat11.switch(
					0,{},
					1, {IFSeqDurPat.st11(1);},
					2, {IFSeqDurPat.st11(2);},
					3, {IFSeqDurPat.st11(3);},
					4, {IFSeqDurPat.st11(4);},
					5, {IFSeqDurPat.st11(5);}
				)}
			);
			},
			'/ifSeq/7/11'
		);
		~ifSeqPatBut12.free;
		~ifSeqPatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat12 = ~cntSeqDurPat12 + 1;
				~cntSeqDurPat12.switch(
					0,{},
					1, {IFSeqDurPat.st12(1);},
					2, {IFSeqDurPat.st12(2);},
					3, {IFSeqDurPat.st12(3);},
					4, {IFSeqDurPat.st12(4);},
					5, {IFSeqDurPat.st12(5);}
				)}
			);
			},
			'/ifSeq/7/12'
		);
		~ifSeqPatBut13.free;
		~ifSeqPatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat13 = ~cntSeqDurPat13 + 1;
				~cntSeqDurPat13.switch(
					0,{},
					1, {IFSeqDurPat.st13(1);},
					2, {IFSeqDurPat.st13(2);},
					3, {IFSeqDurPat.st13(3);},
					4, {IFSeqDurPat.st13(4);},
					5, {IFSeqDurPat.st13(5);}
				)}
			);
			},
			'/ifSeq/7/13'
		);
		~ifSeqPatBut14.free;
		~ifSeqPatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat14 = ~cntSeqDurPat14 + 1;
				~cntSeqDurPat14.switch(
					0,{},
					1, {IFSeqDurPat.st14(1);},
					2, {IFSeqDurPat.st14(2);},
					3, {IFSeqDurPat.st14(3);},
					4, {IFSeqDurPat.st14(4);},
					5, {IFSeqDurPat.st14(5);}
				)}
			);
			},
			'/ifSeq/7/14'
		);
		~ifSeqPatBut15.free;
		~ifSeqPatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat15 = ~cntSeqDurPat15 + 1;
				~cntSeqDurPat15.switch(
					0,{},
					1, {IFSeqDurPat.st15(1);},
					2, {IFSeqDurPat.st15(2);},
					3, {IFSeqDurPat.st15(3);},
					4, {IFSeqDurPat.st15(4);},
					5, {IFSeqDurPat.st15(5);}
				)}
			);
			},
			'/ifSeq/7/15'
		);
		~ifSeqPatBut16.free;
		~ifSeqPatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurPat16 = ~cntSeqDurPat16 + 1;
				~cntSeqDurPat16.switch(
					0,{},
					1, {IFSeqDurPat.st16(1);},
					2, {IFSeqDurPat.st16(2);},
					3, {IFSeqDurPat.st16(3);},
					4, {IFSeqDurPat.st16(4);},
					5, {IFSeqDurPat.st16(5);}
				)}
			);
			},
			'/ifSeq/7/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqDurPat01.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat01', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat01.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat01', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat01.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat01', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat01.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat01', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat01.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat01', '4/1');
			~cntSeqDurPat01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqDurPat02.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat02', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat02.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat02', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat02.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat02', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat02.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat02', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat02.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat02', '4/1');
			~cntSeqDurPat02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqDurPat03.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat03', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat03.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat03', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat03.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat03', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat03.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat03', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat03.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat03', '4/1');
			~cntSeqDurPat03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqDurPat04.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat04', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat04.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat04', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat04.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat04', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat04.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat04', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat04.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat04', '4/1');
			~cntSeqDurPat04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqDurPat05.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat05', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat05.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat05', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat05.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat05', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat05.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat05', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat05.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat05', '4/1');
			~cntSeqDurPat05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqDurPat06.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat06', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat06.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat06', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat06.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat06', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat06.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat06', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat06.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat06', '4/1');
			~cntSeqDurPat06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqDurPat07.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat07', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat07.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat07', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat07.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat07', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat07.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat07', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat07.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat07', '4/1');
			~cntSeqDurPat07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqDurPat08.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat08', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat08.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat08', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat08.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat08', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat08.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat08', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat08.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat08', '4/1');
			~cntSeqDurPat08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqDurPat09.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat09', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat09.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat09', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat09.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat09', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat09.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat09', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat09.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat09', '4/1');
			~cntSeqDurPat09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqDurPat10.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat10', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat10.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat10', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat10.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat10', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat10.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat10', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat10.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat10', '4/1');
			~cntSeqDurPat10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqDurPat11.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat11', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat11.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat11', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat11.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat11', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat11.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat11', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat11.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat11', '4/1');
			~cntSeqDurPat11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqDurPat12.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat12', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat12.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat12', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat12.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat12', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat12.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat12', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat12.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat12', '4/1');
			~cntSeqDurPat12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqDurPat13.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat13', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat13.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat13', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat13.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat13', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat13.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat13', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat13.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat13', '4/1');
			~cntSeqDurPat13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqDurPat14.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat14', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat14.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat14', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat14.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat14', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat14.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat14', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat14.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat14', '4/1');
			~cntSeqDurPat14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqDurPat15.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat15', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat15.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat15', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat15.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat15', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat15.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat15', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat15.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat15', '4/1');
			~cntSeqDurPat15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqDurPat16.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurPat16', '1/2');
		}
		{ i == 2 }  {
			~seqDurPat16.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat16', '1/1');
		}
		{ i == 3 }  {
			~seqDurPat16.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat16', '2/1');
		}
		{ i == 4 }  {
			~seqDurPat16.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat16', '3/1');
		}
		{ i == 5 }  {
			~seqDurPat16.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat16', '4/1');
			~cntSeqDurPat16=0;
		}
	}
	*stGrp {|i|
		IFSeqDurPat.st01(i); IFSeqDurPat.st02(i); IFSeqDurPat.st03(i); IFSeqDurPat.st04(i);
		IFSeqDurPat.st05(i); IFSeqDurPat.st06(i); IFSeqDurPat.st07(i); IFSeqDurPat.st08(i);
		IFSeqDurPat.st09(i); IFSeqDurPat.st10(i); IFSeqDurPat.st11(i); IFSeqDurPat.st12(i);
		IFSeqDurPat.st13(i); IFSeqDurPat.st14(i); IFSeqDurPat.st15(i); IFSeqDurPat.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqDurPat.st01(s01); IFSeqDurPat.st02(s02); IFSeqDurPat.st03(s03); IFSeqDurPat.st04(s04);
		IFSeqDurPat.st05(s05); IFSeqDurPat.st06(s06); IFSeqDurPat.st07(s07); IFSeqDurPat.st08(s08);
		IFSeqDurPat.st09(s09); IFSeqDurPat.st10(s10); IFSeqDurPat.st11(s11); IFSeqDurPat.st12(s12);
		IFSeqDurPat.st13(s13); IFSeqDurPat.st14(s14); IFSeqDurPat.st15(s15); IFSeqDurPat.st16(s16);
	}
}