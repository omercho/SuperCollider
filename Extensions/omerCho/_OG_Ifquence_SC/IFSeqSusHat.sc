IFSeqSusHat {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqSusHat01 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat02 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat03 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat04 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat05 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat06 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat07 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat08 = PatternProxy( Pseq([0.5], 1));

		~seqSusHat09 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat10 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat11 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat12 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat13 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat14 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat15 = PatternProxy( Pseq([0.5], 1));
		~seqSusHat16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqSusUpHat01=0;
		~cntSeqSusRandHat01=0;

		~cntSeqSusHat01=0;
		~cntSeqSusHat02=0;
		~cntSeqSusHat03=0;
		~cntSeqSusHat04=0;
		~cntSeqSusHat05=0;
		~cntSeqSusHat06=0;
		~cntSeqSusHat07=0;
		~cntSeqSusHat08=0;

		~cntSeqSusHat09=0;
		~cntSeqSusHat10=0;
		~cntSeqSusHat11=0;
		~cntSeqSusHat12=0;
		~cntSeqSusHat13=0;
		~cntSeqSusHat14=0;
		~cntSeqSusHat15=0;
		~cntSeqSusHat16=0;
	}
	*freeOn {
		~seqFreeHatBut.free;
		~seqFreeHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSusHat.stGrp(1);
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
				~cntSeqSusUpHat01 = ~cntSeqSusUpHat01 + 1;
				~cntSeqSusUpHat01.switch(
					0,{},
					1,{IFSeqSusHat.stGrp(1);},
					2,{IFSeqSusHat.stGrp(2);},
					3,{IFSeqSusHat.stGrp(3);
						~cntSeqSusUpHat01=0;
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
				~cntSeqSusRandHat01 = ~cntSeqSusRandHat01 + 1;
				~cntSeqSusRandHat01.switch(
					0,{},
					1,{
						IFSeqSusHat.st01([1,2,3,4,5].choose);
						IFSeqSusHat.st02([1,2,3,4,5].choose);
						IFSeqSusHat.st03([1,2,3,4,5].choose);
						IFSeqSusHat.st04([1,2,3,4,5].choose);
						IFSeqSusHat.st05([1,2,3,4,5].choose);
						IFSeqSusHat.st06([1,2,3,4,5].choose);
						IFSeqSusHat.st07([1,2,3,4,5].choose);
						IFSeqSusHat.st08([1,2,3,4,5].choose);

						IFSeqSusHat.st09([1,2,3,4,5].choose);
						IFSeqSusHat.st10([1,2,3,4,5].choose);
						IFSeqSusHat.st11([1,2,3,4,5].choose);
						IFSeqSusHat.st12([1,2,3,4,5].choose);
						IFSeqSusHat.st13([1,2,3,4,5].choose);
						IFSeqSusHat.st14([1,2,3,4,5].choose);
						IFSeqSusHat.st15([1,2,3,4,5].choose);
						IFSeqSusHat.st16([1,2,3,4,5].choose);
						~cntSeqSusRandHat01=0;
					}
				)}
			);
			},
			'/seqRandHat'
		);
	}


	*on { // Shift Susocity

		IFSeqSusHat.randOn;
		IFSeqSusHat.upOn;
		IFSeqSusHat.freeOn;

		~ifSeqHatBut01.free;
		~ifSeqHatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat01 = ~cntSeqSusHat01 + 1;
				~cntSeqSusHat01.switch(
					0,{},
					1, {IFSeqSusHat.st01(1);},
					2, {IFSeqSusHat.st01(2);},
					3, {IFSeqSusHat.st01(3);},
					4, {IFSeqSusHat.st01(4);},
					5, {IFSeqSusHat.st01(5);}
				)}
			);
			},
			'/ifSeq/3/1'
		);
		~ifSeqHatBut02.free;
		~ifSeqHatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat02 = ~cntSeqSusHat02 + 1;
				~cntSeqSusHat02.switch(
					0,{},
					1, {IFSeqSusHat.st02(1);},
					2, {IFSeqSusHat.st02(2);},
					3, {IFSeqSusHat.st02(3);},
					4, {IFSeqSusHat.st02(4);},
					5, {IFSeqSusHat.st02(5);}
				)}
			);
			},
			'/ifSeq/3/2'
		);
		~ifSeqHatBut03.free;
		~ifSeqHatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat03 = ~cntSeqSusHat03 + 1;
				~cntSeqSusHat03.switch(
					0,{},
					1, {IFSeqSusHat.st03(1);},
					2, {IFSeqSusHat.st03(2);},
					3, {IFSeqSusHat.st03(3);},
					4, {IFSeqSusHat.st03(4);},
					5, {IFSeqSusHat.st03(5);}
				)}
			);
			},
			'/ifSeq/3/3'
		);
		~ifSeqHatBut04.free;
		~ifSeqHatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat04 = ~cntSeqSusHat04 + 1;
				~cntSeqSusHat04.switch(
					0,{},
					1, {IFSeqSusHat.st04(1);},
					2, {IFSeqSusHat.st04(2);},
					3, {IFSeqSusHat.st04(3);},
					4, {IFSeqSusHat.st04(4);},
					5, {IFSeqSusHat.st04(5);}
				)}
			);
			},
			'/ifSeq/3/4'
		);
		~ifSeqHatBut05.free;
		~ifSeqHatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat05 = ~cntSeqSusHat05 + 1;
				~cntSeqSusHat05.switch(
					0,{},
					1, {IFSeqSusHat.st05(1);},
					2, {IFSeqSusHat.st05(2);},
					3, {IFSeqSusHat.st05(3);},
					4, {IFSeqSusHat.st05(4);},
					5, {IFSeqSusHat.st05(5);}
				)}
			);
			},
			'/ifSeq/3/5'
		);
		~ifSeqHatBut06.free;
		~ifSeqHatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat06 = ~cntSeqSusHat06 + 1;
				~cntSeqSusHat06.switch(
					0,{},
					1, {IFSeqSusHat.st06(1);},
					2, {IFSeqSusHat.st06(2);},
					3, {IFSeqSusHat.st06(3);},
					4, {IFSeqSusHat.st06(4);},
					5, {IFSeqSusHat.st06(5);}
				)}
			);
			},
			'/ifSeq/3/6'
		);
		~ifSeqHatBut07.free;
		~ifSeqHatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat07 = ~cntSeqSusHat07 + 1;
				~cntSeqSusHat07.switch(
					0,{},
					1, {IFSeqSusHat.st07(1);},
					2, {IFSeqSusHat.st07(2);},
					3, {IFSeqSusHat.st07(3);},
					4, {IFSeqSusHat.st07(4);},
					5, {IFSeqSusHat.st07(5);}
				)}
			);
			},
			'/ifSeq/3/7'
		);
		~ifSeqHatBut08.free;
		~ifSeqHatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat08 = ~cntSeqSusHat08 + 1;
				~cntSeqSusHat08.switch(
					0,{},
					1, {IFSeqSusHat.st08(1);},
					2, {IFSeqSusHat.st08(2);},
					3, {IFSeqSusHat.st08(3);},
					4, {IFSeqSusHat.st08(4);},
					5, {IFSeqSusHat.st08(5);}
				)}
			);
			},
			'/ifSeq/3/8'
		);

		~ifSeqHatBut09.free;
		~ifSeqHatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat09 = ~cntSeqSusHat09 + 1;
				~cntSeqSusHat09.switch(
					0,{},
					1, {IFSeqSusHat.st09(1);},
					2, {IFSeqSusHat.st09(2);},
					3, {IFSeqSusHat.st09(3);},
					4, {IFSeqSusHat.st09(4);},
					5, {IFSeqSusHat.st09(5);}
				)}
			);
			},
			'/ifSeq/3/9'
		);
		~ifSeqHatBut10.free;
		~ifSeqHatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat10 = ~cntSeqSusHat10 + 1;
				~cntSeqSusHat10.switch(
					0,{},
					1, {IFSeqSusHat.st10(1);},
					2, {IFSeqSusHat.st10(2);},
					3, {IFSeqSusHat.st10(3);},
					4, {IFSeqSusHat.st10(4);},
					5, {IFSeqSusHat.st10(5);}
				)}
			);
			},
			'/ifSeq/3/10'
		);
		~ifSeqHatBut11.free;
		~ifSeqHatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat11 = ~cntSeqSusHat11 + 1;
				~cntSeqSusHat11.switch(
					0,{},
					1, {IFSeqSusHat.st11(1);},
					2, {IFSeqSusHat.st11(2);},
					3, {IFSeqSusHat.st11(3);},
					4, {IFSeqSusHat.st11(4);},
					5, {IFSeqSusHat.st11(5);}
				)}
			);
			},
			'/ifSeq/3/11'
		);
		~ifSeqHatBut12.free;
		~ifSeqHatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat12 = ~cntSeqSusHat12 + 1;
				~cntSeqSusHat12.switch(
					0,{},
					1, {IFSeqSusHat.st12(1);},
					2, {IFSeqSusHat.st12(2);},
					3, {IFSeqSusHat.st12(3);},
					4, {IFSeqSusHat.st12(4);},
					5, {IFSeqSusHat.st12(5);}
				)}
			);
			},
			'/ifSeq/3/12'
		);
		~ifSeqHatBut13.free;
		~ifSeqHatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat13 = ~cntSeqSusHat13 + 1;
				~cntSeqSusHat13.switch(
					0,{},
					1, {IFSeqSusHat.st13(1);},
					2, {IFSeqSusHat.st13(2);},
					3, {IFSeqSusHat.st13(3);},
					4, {IFSeqSusHat.st13(4);},
					5, {IFSeqSusHat.st13(5);}
				)}
			);
			},
			'/ifSeq/3/13'
		);
		~ifSeqHatBut14.free;
		~ifSeqHatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat14 = ~cntSeqSusHat14 + 1;
				~cntSeqSusHat14.switch(
					0,{},
					1, {IFSeqSusHat.st14(1);},
					2, {IFSeqSusHat.st14(2);},
					3, {IFSeqSusHat.st14(3);},
					4, {IFSeqSusHat.st14(4);},
					5, {IFSeqSusHat.st14(5);}
				)}
			);
			},
			'/ifSeq/3/14'
		);
		~ifSeqHatBut15.free;
		~ifSeqHatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat15 = ~cntSeqSusHat15 + 1;
				~cntSeqSusHat15.switch(
					0,{},
					1, {IFSeqSusHat.st15(1);},
					2, {IFSeqSusHat.st15(2);},
					3, {IFSeqSusHat.st15(3);},
					4, {IFSeqSusHat.st15(4);},
					5, {IFSeqSusHat.st15(5);}
				)}
			);
			},
			'/ifSeq/3/15'
		);
		~ifSeqHatBut16.free;
		~ifSeqHatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusHat16 = ~cntSeqSusHat16 + 1;
				~cntSeqSusHat16.switch(
					0,{},
					1, {IFSeqSusHat.st16(1);},
					2, {IFSeqSusHat.st16(2);},
					3, {IFSeqSusHat.st16(3);},
					4, {IFSeqSusHat.st16(4);},
					5, {IFSeqSusHat.st16(5);}
				)}
			);
			},
			'/ifSeq/3/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqSusHat01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat01', '1');
		}
		{ i == 2 }  {
			~seqSusHat01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat01', '2');
		}
		{ i == 3 }  {
			~seqSusHat01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat01', '3');
		}
		{ i == 4 }  {
			~seqSusHat01.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat01', '4');
		}
		{ i == 5 }  {
			~seqSusHat01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat01', '5');
			~cntSeqSusHat01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqSusHat02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat02', '1');
		}
		{ i == 2 }  {
			~seqSusHat02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat02', '2');
		}
		{ i == 3 }  {
			~seqSusHat02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat02', '3');
		}
		{ i == 4 }  {
			~seqSusHat02.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat02', '4');
		}
		{ i == 5 }  {
			~seqSusHat02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat02', '5');
			~cntSeqSusHat02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqSusHat03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat03', '1');
		}
		{ i == 2 }  {
			~seqSusHat03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat03', '2');
		}
		{ i == 3 }  {
			~seqSusHat03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat03', '3');
		}
		{ i == 4 }  {
			~seqSusHat03.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat03', '4');
		}
		{ i == 5 }  {
			~seqSusHat03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat03', '5');
			~cntSeqSusHat03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqSusHat04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat04', '1');
		}
		{ i == 2 }  {
			~seqSusHat04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat04', '2');
		}
		{ i == 3 }  {
			~seqSusHat04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat04', '3');
		}
		{ i == 4 }  {
			~seqSusHat04.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat04', '4');
		}
		{ i == 5 }  {
			~seqSusHat04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat04', '5');
			~cntSeqSusHat04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqSusHat05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat05', '1');
		}
		{ i == 2 }  {
			~seqSusHat05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat05', '2');
		}
		{ i == 3 }  {
			~seqSusHat05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat05', '3');
		}
		{ i == 4 }  {
			~seqSusHat05.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat05', '4');
		}
		{ i == 5 }  {
			~seqSusHat05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat05', '5');
			~cntSeqSusHat05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqSusHat06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat06', '1');
		}
		{ i == 2 }  {
			~seqSusHat06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat06', '2');
		}
		{ i == 3 }  {
			~seqSusHat06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat06', '3');
		}
		{ i == 4 }  {
			~seqSusHat06.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat06', '4');
		}
		{ i == 5 }  {
			~seqSusHat06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat06', '5');
			~cntSeqSusHat06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqSusHat07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat07', '1');
		}
		{ i == 2 }  {
			~seqSusHat07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat07', '2');
		}
		{ i == 3 }  {
			~seqSusHat07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat07', '3');
		}
		{ i == 4 }  {
			~seqSusHat07.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat07', '4');
		}
		{ i == 5 }  {
			~seqSusHat07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat07', '5');
			~cntSeqSusHat07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqSusHat08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat08', '1');
		}
		{ i == 2 }  {
			~seqSusHat08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat08', '2');
		}
		{ i == 3 }  {
			~seqSusHat08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat08', '3');
		}
		{ i == 4 }  {
			~seqSusHat08.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat08', '4');
		}
		{ i == 5 }  {
			~seqSusHat08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat08', '5');
			~cntSeqSusHat08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqSusHat09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat09', '1');
		}
		{ i == 2 }  {
			~seqSusHat09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat09', '2');
		}
		{ i == 3 }  {
			~seqSusHat09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat09', '3');
		}
		{ i == 4 }  {
			~seqSusHat09.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat09', '4');
		}
		{ i == 5 }  {
			~seqSusHat09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat09', '5');
			~cntSeqSusHat09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqSusHat10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat10', '1');
		}
		{ i == 2 }  {
			~seqSusHat10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat10', '2');
		}
		{ i == 3 }  {
			~seqSusHat10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat10', '3');
		}
		{ i == 4 }  {
			~seqSusHat10.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat10', '4');
		}
		{ i == 5 }  {
			~seqSusHat10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat10', '5');
			~cntSeqSusHat10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqSusHat11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat11', '1');
		}
		{ i == 2 }  {
			~seqSusHat11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat11', '2');
		}
		{ i == 3 }  {
			~seqSusHat11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat11', '3');
		}
		{ i == 4 }  {
			~seqSusHat11.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat11', '4');
		}
		{ i == 5 }  {
			~seqSusHat11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat11', '5');
			~cntSeqSusHat11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqSusHat12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat12', '1');
		}
		{ i == 2 }  {
			~seqSusHat12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat12', '2');
		}
		{ i == 3 }  {
			~seqSusHat12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat12', '3');
		}
		{ i == 4 }  {
			~seqSusHat12.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat12', '4');
		}
		{ i == 5 }  {
			~seqSusHat12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat12', '5');
			~cntSeqSusHat12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqSusHat13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat13', '1');
		}
		{ i == 2 }  {
			~seqSusHat13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat13', '2');
		}
		{ i == 3 }  {
			~seqSusHat13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat13', '3');
		}
		{ i == 4 }  {
			~seqSusHat13.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat13', '4');
		}
		{ i == 5 }  {
			~seqSusHat13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat13', '5');
			~cntSeqSusHat13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqSusHat14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat14', '1');
		}
		{ i == 2 }  {
			~seqSusHat14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat14', '2');
		}
		{ i == 3 }  {
			~seqSusHat14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat14', '3');
		}
		{ i == 4 }  {
			~seqSusHat14.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat14', '4');
		}
		{ i == 5 }  {
			~seqSusHat14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat14', '5');
			~cntSeqSusHat14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqSusHat15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat15', '1');
		}
		{ i == 2 }  {
			~seqSusHat15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat15', '2');
		}
		{ i == 3 }  {
			~seqSusHat15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat15', '3');
		}
		{ i == 4 }  {
			~seqSusHat15.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat15', '4');
		}
		{ i == 5 }  {
			~seqSusHat15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat15', '5');
			~cntSeqSusHat15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqSusHat16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusHat16', '1');
		}
		{ i == 2 }  {
			~seqSusHat16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusHat16', '2');
		}
		{ i == 3 }  {
			~seqSusHat16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusHat16', '3');
		}
		{ i == 4 }  {
			~seqSusHat16.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusHat16', '4');
		}
		{ i == 5 }  {
			~seqSusHat16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusHat16', '5');
			~cntSeqSusHat16=0;
		}
	}
	*stGrp {|i|
		IFSeqSusHat.st01(i); IFSeqSusHat.st02(i); IFSeqSusHat.st03(i); IFSeqSusHat.st04(i);
		IFSeqSusHat.st05(i); IFSeqSusHat.st06(i); IFSeqSusHat.st07(i); IFSeqSusHat.st08(i);
		IFSeqSusHat.st09(i); IFSeqSusHat.st10(i); IFSeqSusHat.st11(i); IFSeqSusHat.st12(i);
		IFSeqSusHat.st13(i); IFSeqSusHat.st14(i); IFSeqSusHat.st15(i); IFSeqSusHat.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqSusHat.st01(s01); IFSeqSusHat.st02(s02); IFSeqSusHat.st03(s03); IFSeqSusHat.st04(s04);
		IFSeqSusHat.st05(s05); IFSeqSusHat.st06(s06); IFSeqSusHat.st07(s07); IFSeqSusHat.st08(s08);
		IFSeqSusHat.st09(s09); IFSeqSusHat.st10(s10); IFSeqSusHat.st11(s11); IFSeqSusHat.st12(s12);
		IFSeqSusHat.st13(s13); IFSeqSusHat.st14(s14); IFSeqSusHat.st15(s15); IFSeqSusHat.st16(s16);
	}
}