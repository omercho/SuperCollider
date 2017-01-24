IFSeqDurHat {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqDurHat01 = PatternProxy( Pseq([0.5], 1));
		~seqDurHat02 = PatternProxy( Pseq([0.5], 1));
		~seqDurHat03 = PatternProxy( Pseq([0.5], 1));
		~seqDurHat04 = PatternProxy( Pseq([0.5], 1));
		~seqDurHat05 = PatternProxy( Pseq([0.5], 1));
		~seqDurHat06 = PatternProxy( Pseq([0.5], 1));
		~seqDurHat07 = PatternProxy( Pseq([0.5], 1));
		~seqDurHat08 = PatternProxy( Pseq([0.5], 1));

		~seqDurHat09 = PatternProxy( Pseq([0.5], 1));
		~seqDurHat10 = PatternProxy( Pseq([0.5], 1));
		~seqDurHat11 = PatternProxy( Pseq([0.5], 1));
		~seqDurHat12 = PatternProxy( Pseq([0.5], 1));
		~seqDurHat13 = PatternProxy( Pseq([0.5], 1));
		~seqDurHat14 = PatternProxy( Pseq([0.5], 1));
		~seqDurHat15 = PatternProxy( Pseq([0.5], 1));
		~seqDurHat16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqDurUpHat01=0;
		~cntSeqDurRandHat01=0;

		~cntSeqDurHat01=0;
		~cntSeqDurHat02=0;
		~cntSeqDurHat03=0;
		~cntSeqDurHat04=0;
		~cntSeqDurHat05=0;
		~cntSeqDurHat06=0;
		~cntSeqDurHat07=0;
		~cntSeqDurHat08=0;

		~cntSeqDurHat09=0;
		~cntSeqDurHat10=0;
		~cntSeqDurHat11=0;
		~cntSeqDurHat12=0;
		~cntSeqDurHat13=0;
		~cntSeqDurHat14=0;
		~cntSeqDurHat15=0;
		~cntSeqDurHat16=0;
	}
	*freeOn {
		~seqFreeHatBut.free;
		~seqFreeHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqDurHat.stGrp(4);
				});
			},
			'/seqFreeHat'
		);
	}
	*upOn {
		~ifSeqUpHatBut.free;
		~ifSeqUpHatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurUpHat01 = ~cntSeqDurUpHat01 + 1;
				~cntSeqDurUpHat01.switch(
					0,{},
					1,{IFSeqDurHat.stGrp(1);},
					2,{IFSeqDurHat.stGrp(2);},
					3,{IFSeqDurHat.stGrp(3);
						~cntSeqDurUpHat01=0;
					}
				)}
			);
			},
			'/seqUpHat'
		);
	}

	*randOn {
		~ifSeqRandHatBut.free;
		~ifSeqRandHatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurRandHat01 = ~cntSeqDurRandHat01 + 1;
				~cntSeqDurRandHat01.switch(
					0,{},
					1,{
						IFSeqDurHat.st01([1,2,3,4,5].choose);
						IFSeqDurHat.st02([1,2,3,4,5].choose);
						IFSeqDurHat.st03([1,2,3,4,5].choose);
						IFSeqDurHat.st04([1,2,3,4,5].choose);
						IFSeqDurHat.st05([1,2,3,4,5].choose);
						IFSeqDurHat.st06([1,2,3,4,5].choose);
						IFSeqDurHat.st07([1,2,3,4,5].choose);
						IFSeqDurHat.st08([1,2,3,4,5].choose);

						IFSeqDurHat.st09([1,2,3,4,5].choose);
						IFSeqDurHat.st10([1,2,3,4,5].choose);
						IFSeqDurHat.st11([1,2,3,4,5].choose);
						IFSeqDurHat.st12([1,2,3,4,5].choose);
						IFSeqDurHat.st13([1,2,3,4,5].choose);
						IFSeqDurHat.st14([1,2,3,4,5].choose);
						IFSeqDurHat.st15([1,2,3,4,5].choose);
						IFSeqDurHat.st16([1,2,3,4,5].choose);
						~cntSeqDurRandHat01=0;
					}
				)}
			);
			},
			'/seqRandHat'
		);
	}


	*on { // Shift Durocity

		IFSeqDurHat.randOn;
		IFSeqDurHat.upOn;
		IFSeqDurHat.freeOn;

		~ifSeqHatBut01.free;
		~ifSeqHatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat01 = ~cntSeqDurHat01 + 1;
				~cntSeqDurHat01.switch(
					0,{},
					1, {IFSeqDurHat.st01(1);},
					2, {IFSeqDurHat.st01(2);},
					3, {IFSeqDurHat.st01(3);},
					4, {IFSeqDurHat.st01(4);},
					5, {IFSeqDurHat.st01(5);}
				)}
			);
			},
			'/ifSeq/3/1'
		);
		~ifSeqHatBut02.free;
		~ifSeqHatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat02 = ~cntSeqDurHat02 + 1;
				~cntSeqDurHat02.switch(
					0,{},
					1, {IFSeqDurHat.st02(1);},
					2, {IFSeqDurHat.st02(2);},
					3, {IFSeqDurHat.st02(3);},
					4, {IFSeqDurHat.st02(4);},
					5, {IFSeqDurHat.st02(5);}
				)}
			);
			},
			'/ifSeq/3/2'
		);
		~ifSeqHatBut03.free;
		~ifSeqHatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat03 = ~cntSeqDurHat03 + 1;
				~cntSeqDurHat03.switch(
					0,{},
					1, {IFSeqDurHat.st03(1);},
					2, {IFSeqDurHat.st03(2);},
					3, {IFSeqDurHat.st03(3);},
					4, {IFSeqDurHat.st03(4);},
					5, {IFSeqDurHat.st03(5);}
				)}
			);
			},
			'/ifSeq/3/3'
		);
		~ifSeqHatBut04.free;
		~ifSeqHatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat04 = ~cntSeqDurHat04 + 1;
				~cntSeqDurHat04.switch(
					0,{},
					1, {IFSeqDurHat.st04(1);},
					2, {IFSeqDurHat.st04(2);},
					3, {IFSeqDurHat.st04(3);},
					4, {IFSeqDurHat.st04(4);},
					5, {IFSeqDurHat.st04(5);}
				)}
			);
			},
			'/ifSeq/3/4'
		);
		~ifSeqHatBut05.free;
		~ifSeqHatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat05 = ~cntSeqDurHat05 + 1;
				~cntSeqDurHat05.switch(
					0,{},
					1, {IFSeqDurHat.st05(1);},
					2, {IFSeqDurHat.st05(2);},
					3, {IFSeqDurHat.st05(3);},
					4, {IFSeqDurHat.st05(4);},
					5, {IFSeqDurHat.st05(5);}
				)}
			);
			},
			'/ifSeq/3/5'
		);
		~ifSeqHatBut06.free;
		~ifSeqHatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat06 = ~cntSeqDurHat06 + 1;
				~cntSeqDurHat06.switch(
					0,{},
					1, {IFSeqDurHat.st06(1);},
					2, {IFSeqDurHat.st06(2);},
					3, {IFSeqDurHat.st06(3);},
					4, {IFSeqDurHat.st06(4);},
					5, {IFSeqDurHat.st06(5);}
				)}
			);
			},
			'/ifSeq/3/6'
		);
		~ifSeqHatBut07.free;
		~ifSeqHatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat07 = ~cntSeqDurHat07 + 1;
				~cntSeqDurHat07.switch(
					0,{},
					1, {IFSeqDurHat.st07(1);},
					2, {IFSeqDurHat.st07(2);},
					3, {IFSeqDurHat.st07(3);},
					4, {IFSeqDurHat.st07(4);},
					5, {IFSeqDurHat.st07(5);}
				)}
			);
			},
			'/ifSeq/3/7'
		);
		~ifSeqHatBut08.free;
		~ifSeqHatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat08 = ~cntSeqDurHat08 + 1;
				~cntSeqDurHat08.switch(
					0,{},
					1, {IFSeqDurHat.st08(1);},
					2, {IFSeqDurHat.st08(2);},
					3, {IFSeqDurHat.st08(3);},
					4, {IFSeqDurHat.st08(4);},
					5, {IFSeqDurHat.st08(5);}
				)}
			);
			},
			'/ifSeq/3/8'
		);

		~ifSeqHatBut09.free;
		~ifSeqHatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat09 = ~cntSeqDurHat09 + 1;
				~cntSeqDurHat09.switch(
					0,{},
					1, {IFSeqDurHat.st09(1);},
					2, {IFSeqDurHat.st09(2);},
					3, {IFSeqDurHat.st09(3);},
					4, {IFSeqDurHat.st09(4);},
					5, {IFSeqDurHat.st09(5);}
				)}
			);
			},
			'/ifSeq/3/9'
		);
		~ifSeqHatBut10.free;
		~ifSeqHatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat10 = ~cntSeqDurHat10 + 1;
				~cntSeqDurHat10.switch(
					0,{},
					1, {IFSeqDurHat.st10(1);},
					2, {IFSeqDurHat.st10(2);},
					3, {IFSeqDurHat.st10(3);},
					4, {IFSeqDurHat.st10(4);},
					5, {IFSeqDurHat.st10(5);}
				)}
			);
			},
			'/ifSeq/3/10'
		);
		~ifSeqHatBut11.free;
		~ifSeqHatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat11 = ~cntSeqDurHat11 + 1;
				~cntSeqDurHat11.switch(
					0,{},
					1, {IFSeqDurHat.st11(1);},
					2, {IFSeqDurHat.st11(2);},
					3, {IFSeqDurHat.st11(3);},
					4, {IFSeqDurHat.st11(4);},
					5, {IFSeqDurHat.st11(5);}
				)}
			);
			},
			'/ifSeq/3/11'
		);
		~ifSeqHatBut12.free;
		~ifSeqHatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat12 = ~cntSeqDurHat12 + 1;
				~cntSeqDurHat12.switch(
					0,{},
					1, {IFSeqDurHat.st12(1);},
					2, {IFSeqDurHat.st12(2);},
					3, {IFSeqDurHat.st12(3);},
					4, {IFSeqDurHat.st12(4);},
					5, {IFSeqDurHat.st12(5);}
				)}
			);
			},
			'/ifSeq/3/12'
		);
		~ifSeqHatBut13.free;
		~ifSeqHatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat13 = ~cntSeqDurHat13 + 1;
				~cntSeqDurHat13.switch(
					0,{},
					1, {IFSeqDurHat.st13(1);},
					2, {IFSeqDurHat.st13(2);},
					3, {IFSeqDurHat.st13(3);},
					4, {IFSeqDurHat.st13(4);},
					5, {IFSeqDurHat.st13(5);}
				)}
			);
			},
			'/ifSeq/3/13'
		);
		~ifSeqHatBut14.free;
		~ifSeqHatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat14 = ~cntSeqDurHat14 + 1;
				~cntSeqDurHat14.switch(
					0,{},
					1, {IFSeqDurHat.st14(1);},
					2, {IFSeqDurHat.st14(2);},
					3, {IFSeqDurHat.st14(3);},
					4, {IFSeqDurHat.st14(4);},
					5, {IFSeqDurHat.st14(5);}
				)}
			);
			},
			'/ifSeq/3/14'
		);
		~ifSeqHatBut15.free;
		~ifSeqHatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat15 = ~cntSeqDurHat15 + 1;
				~cntSeqDurHat15.switch(
					0,{},
					1, {IFSeqDurHat.st15(1);},
					2, {IFSeqDurHat.st15(2);},
					3, {IFSeqDurHat.st15(3);},
					4, {IFSeqDurHat.st15(4);},
					5, {IFSeqDurHat.st15(5);}
				)}
			);
			},
			'/ifSeq/3/15'
		);
		~ifSeqHatBut16.free;
		~ifSeqHatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurHat16 = ~cntSeqDurHat16 + 1;
				~cntSeqDurHat16.switch(
					0,{},
					1, {IFSeqDurHat.st16(1);},
					2, {IFSeqDurHat.st16(2);},
					3, {IFSeqDurHat.st16(3);},
					4, {IFSeqDurHat.st16(4);},
					5, {IFSeqDurHat.st16(5);}
				)}
			);
			},
			'/ifSeq/3/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqDurHat01.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat01', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat01.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat01', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat01.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat01', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat01.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat01', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat01', '1.5');
			~cntSeqDurHat01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqDurHat02.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat02', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat02.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat02', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat02.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat02', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat02.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat02', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat02', '1.5');
			~cntSeqDurHat02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqDurHat03.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat03', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat03.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat03', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat03.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat03', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat03.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat03', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat03', '1.5');
			~cntSeqDurHat03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqDurHat04.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat04', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat04.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat04', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat04.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat04', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat04.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat04', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat04', '1.5');
			~cntSeqDurHat04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqDurHat05.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat05', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat05.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat05', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat05.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat05', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat05.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat05', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat05', '1.5');
			~cntSeqDurHat05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqDurHat06.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat06', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat06.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat06', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat06.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat06', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat06.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat06', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat06', '1.5');
			~cntSeqDurHat06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqDurHat07.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat07', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat07.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat07', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat07.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat07', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat07.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat07', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat07', '1.5');
			~cntSeqDurHat07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqDurHat08.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat08', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat08.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat08', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat08.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat08', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat08.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat08', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat08', '1.5');
			~cntSeqDurHat08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqDurHat09.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat09', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat09.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat09', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat09.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat09', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat09.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat09', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat09', '1.5');
			~cntSeqDurHat09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqDurHat10.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat10', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat10.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat10', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat10.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat10', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat10.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat10', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat10', '1.5');
			~cntSeqDurHat10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqDurHat11.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat11', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat11.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat11', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat11.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat11', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat11.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat11', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat11', '1.5');
			~cntSeqDurHat11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqDurHat12.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat12', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat12.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat12', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat12.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat12', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat12.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat12', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat12', '1.5');
			~cntSeqDurHat12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqDurHat13.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat13', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat13.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat13', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat13.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat13', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat13.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat13', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat13', '1.5');
			~cntSeqDurHat13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqDurHat14.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat14', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat14.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat14', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat14.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat14', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat14.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat14', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat14', '1.5');
			~cntSeqDurHat14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqDurHat15.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat15', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat15.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat15', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat15.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat15', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat15.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat15', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat15', '1.5');
			~cntSeqDurHat15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqDurHat16.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurHat16', '1/4');
		}
		{ i == 2 }  {
			~seqDurHat16.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurHat16', '1/3');
		}
		{ i == 3 }  {
			~seqDurHat16.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurHat16', '1/2');
		}
		{ i == 4 }  {
			~seqDurHat16.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurHat16', '1/1');
		}
		{ i == 5 }  {
			~seqDurHat16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurHat16', '1.5');
			~cntSeqDurHat16=0;
		}
	}
	*stGrp {|i|
		IFSeqDurHat.st01(i); IFSeqDurHat.st02(i); IFSeqDurHat.st03(i); IFSeqDurHat.st04(i);
		IFSeqDurHat.st05(i); IFSeqDurHat.st06(i); IFSeqDurHat.st07(i); IFSeqDurHat.st08(i);
		IFSeqDurHat.st09(i); IFSeqDurHat.st10(i); IFSeqDurHat.st11(i); IFSeqDurHat.st12(i);
		IFSeqDurHat.st13(i); IFSeqDurHat.st14(i); IFSeqDurHat.st15(i); IFSeqDurHat.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqDurHat.st01(s01); IFSeqDurHat.st02(s02); IFSeqDurHat.st03(s03); IFSeqDurHat.st04(s04);
		IFSeqDurHat.st05(s05); IFSeqDurHat.st06(s06); IFSeqDurHat.st07(s07); IFSeqDurHat.st08(s08);
		IFSeqDurHat.st09(s09); IFSeqDurHat.st10(s10); IFSeqDurHat.st11(s11); IFSeqDurHat.st12(s12);
		IFSeqDurHat.st13(s13); IFSeqDurHat.st14(s14); IFSeqDurHat.st15(s15); IFSeqDurHat.st16(s16);
	}
}