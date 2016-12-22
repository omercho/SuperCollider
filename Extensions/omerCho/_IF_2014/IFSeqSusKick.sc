IFSeqSusKick {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqSusKick01 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick02 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick03 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick04 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick05 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick06 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick07 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick08 = PatternProxy( Pseq([0.5], 1));

		~seqSusKick09 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick10 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick11 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick12 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick13 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick14 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick15 = PatternProxy( Pseq([0.5], 1));
		~seqSusKick16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqSusUpKick01=0;
		~cntSeqSusRandKick01=0;

		~cntSeqSusKick01=0;
		~cntSeqSusKick02=0;
		~cntSeqSusKick03=0;
		~cntSeqSusKick04=0;
		~cntSeqSusKick05=0;
		~cntSeqSusKick06=0;
		~cntSeqSusKick07=0;
		~cntSeqSusKick08=0;

		~cntSeqSusKick09=0;
		~cntSeqSusKick10=0;
		~cntSeqSusKick11=0;
		~cntSeqSusKick12=0;
		~cntSeqSusKick13=0;
		~cntSeqSusKick14=0;
		~cntSeqSusKick15=0;
		~cntSeqSusKick16=0;
	}
	*freeOn {
		~seqFreeKickBut.free;
		~seqFreeKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSusKick.stGrp(1);
				});
			},
			'/seqFreeKick'
		);
	}
	*upOn {
		~ifSeqUpKickBut.free;
		~ifSeqUpKickBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusUpKick01 = ~cntSeqSusUpKick01 + 1;
				~cntSeqSusUpKick01.switch(
					0,{},
					1,{IFSeqSusKick.stGrp(1);},
					2,{IFSeqSusKick.stGrp(2);},
					3,{IFSeqSusKick.stGrp(3);
						~cntSeqSusUpKick01=0;
					}
				)}
			);
			},
			'/seqUpKick'
		);
	}

	*randOn {
		~ifSeqRandKickBut.free;
		~ifSeqRandKickBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusRandKick01 = ~cntSeqSusRandKick01 + 1;
				~cntSeqSusRandKick01.switch(
					0,{},
					1,{
						IFSeqSusKick.st01([1,2,3,4,5].choose);
						IFSeqSusKick.st02([1,2,3,4,5].choose);
						IFSeqSusKick.st03([1,2,3,4,5].choose);
						IFSeqSusKick.st04([1,2,3,4,5].choose);
						IFSeqSusKick.st05([1,2,3,4,5].choose);
						IFSeqSusKick.st06([1,2,3,4,5].choose);
						IFSeqSusKick.st07([1,2,3,4,5].choose);
						IFSeqSusKick.st08([1,2,3,4,5].choose);

						IFSeqSusKick.st09([1,2,3,4,5].choose);
						IFSeqSusKick.st10([1,2,3,4,5].choose);
						IFSeqSusKick.st11([1,2,3,4,5].choose);
						IFSeqSusKick.st12([1,2,3,4,5].choose);
						IFSeqSusKick.st13([1,2,3,4,5].choose);
						IFSeqSusKick.st14([1,2,3,4,5].choose);
						IFSeqSusKick.st15([1,2,3,4,5].choose);
						IFSeqSusKick.st16([1,2,3,4,5].choose);
						~cntSeqSusRandKick01=0;
					}
				)}
			);
			},
			'/seqRandKick'
		);
	}


	*on { // Shift Susocity

		IFSeqSusKick.randOn;
		IFSeqSusKick.upOn;
		IFSeqSusKick.freeOn;

		~ifSeqKickBut01.free;
		~ifSeqKickBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick01 = ~cntSeqSusKick01 + 1;
				~cntSeqSusKick01.switch(
					0,{},
					1, {IFSeqSusKick.st01(1);},
					2, {IFSeqSusKick.st01(2);},
					3, {IFSeqSusKick.st01(3);},
					4, {IFSeqSusKick.st01(4);},
					5, {IFSeqSusKick.st01(5);}
				)}
			);
			},
			'/ifSeq/1/1'
		);
		~ifSeqKickBut02.free;
		~ifSeqKickBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick02 = ~cntSeqSusKick02 + 1;
				~cntSeqSusKick02.switch(
					0,{},
					1, {IFSeqSusKick.st02(1);},
					2, {IFSeqSusKick.st02(2);},
					3, {IFSeqSusKick.st02(3);},
					4, {IFSeqSusKick.st02(4);},
					5, {IFSeqSusKick.st02(5);}
				)}
			);
			},
			'/ifSeq/1/2'
		);
		~ifSeqKickBut03.free;
		~ifSeqKickBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick03 = ~cntSeqSusKick03 + 1;
				~cntSeqSusKick03.switch(
					0,{},
					1, {IFSeqSusKick.st03(1);},
					2, {IFSeqSusKick.st03(2);},
					3, {IFSeqSusKick.st03(3);},
					4, {IFSeqSusKick.st03(4);},
					5, {IFSeqSusKick.st03(5);}
				)}
			);
			},
			'/ifSeq/1/3'
		);
		~ifSeqKickBut04.free;
		~ifSeqKickBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick04 = ~cntSeqSusKick04 + 1;
				~cntSeqSusKick04.switch(
					0,{},
					1, {IFSeqSusKick.st04(1);},
					2, {IFSeqSusKick.st04(2);},
					3, {IFSeqSusKick.st04(3);},
					4, {IFSeqSusKick.st04(4);},
					5, {IFSeqSusKick.st04(5);}
				)}
			);
			},
			'/ifSeq/1/4'
		);
		~ifSeqKickBut05.free;
		~ifSeqKickBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick05 = ~cntSeqSusKick05 + 1;
				~cntSeqSusKick05.switch(
					0,{},
					1, {IFSeqSusKick.st05(1);},
					2, {IFSeqSusKick.st05(2);},
					3, {IFSeqSusKick.st05(3);},
					4, {IFSeqSusKick.st05(4);},
					5, {IFSeqSusKick.st05(5);}
				)}
			);
			},
			'/ifSeq/1/5'
		);
		~ifSeqKickBut06.free;
		~ifSeqKickBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick06 = ~cntSeqSusKick06 + 1;
				~cntSeqSusKick06.switch(
					0,{},
					1, {IFSeqSusKick.st06(1);},
					2, {IFSeqSusKick.st06(2);},
					3, {IFSeqSusKick.st06(3);},
					4, {IFSeqSusKick.st06(4);},
					5, {IFSeqSusKick.st06(5);}
				)}
			);
			},
			'/ifSeq/1/6'
		);
		~ifSeqKickBut07.free;
		~ifSeqKickBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick07 = ~cntSeqSusKick07 + 1;
				~cntSeqSusKick07.switch(
					0,{},
					1, {IFSeqSusKick.st07(1);},
					2, {IFSeqSusKick.st07(2);},
					3, {IFSeqSusKick.st07(3);},
					4, {IFSeqSusKick.st07(4);},
					5, {IFSeqSusKick.st07(5);}
				)}
			);
			},
			'/ifSeq/1/7'
		);
		~ifSeqKickBut08.free;
		~ifSeqKickBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick08 = ~cntSeqSusKick08 + 1;
				~cntSeqSusKick08.switch(
					0,{},
					1, {IFSeqSusKick.st08(1);},
					2, {IFSeqSusKick.st08(2);},
					3, {IFSeqSusKick.st08(3);},
					4, {IFSeqSusKick.st08(4);},
					5, {IFSeqSusKick.st08(5);}
				)}
			);
			},
			'/ifSeq/1/8'
		);

		~ifSeqKickBut09.free;
		~ifSeqKickBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick09 = ~cntSeqSusKick09 + 1;
				~cntSeqSusKick09.switch(
					0,{},
					1, {IFSeqSusKick.st09(1);},
					2, {IFSeqSusKick.st09(2);},
					3, {IFSeqSusKick.st09(3);},
					4, {IFSeqSusKick.st09(4);},
					5, {IFSeqSusKick.st09(5);}
				)}
			);
			},
			'/ifSeq/1/9'
		);
		~ifSeqKickBut10.free;
		~ifSeqKickBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick10 = ~cntSeqSusKick10 + 1;
				~cntSeqSusKick10.switch(
					0,{},
					1, {IFSeqSusKick.st10(1);},
					2, {IFSeqSusKick.st10(2);},
					3, {IFSeqSusKick.st10(3);},
					4, {IFSeqSusKick.st10(4);},
					5, {IFSeqSusKick.st10(5);}
				)}
			);
			},
			'/ifSeq/1/10'
		);
		~ifSeqKickBut11.free;
		~ifSeqKickBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick11 = ~cntSeqSusKick11 + 1;
				~cntSeqSusKick11.switch(
					0,{},
					1, {IFSeqSusKick.st11(1);},
					2, {IFSeqSusKick.st11(2);},
					3, {IFSeqSusKick.st11(3);},
					4, {IFSeqSusKick.st11(4);},
					5, {IFSeqSusKick.st11(5);}
				)}
			);
			},
			'/ifSeq/1/11'
		);
		~ifSeqKickBut12.free;
		~ifSeqKickBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick12 = ~cntSeqSusKick12 + 1;
				~cntSeqSusKick12.switch(
					0,{},
					1, {IFSeqSusKick.st12(1);},
					2, {IFSeqSusKick.st12(2);},
					3, {IFSeqSusKick.st12(3);},
					4, {IFSeqSusKick.st12(4);},
					5, {IFSeqSusKick.st12(5);}
				)}
			);
			},
			'/ifSeq/1/12'
		);
		~ifSeqKickBut13.free;
		~ifSeqKickBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick13 = ~cntSeqSusKick13 + 1;
				~cntSeqSusKick13.switch(
					0,{},
					1, {IFSeqSusKick.st13(1);},
					2, {IFSeqSusKick.st13(2);},
					3, {IFSeqSusKick.st13(3);},
					4, {IFSeqSusKick.st13(4);},
					5, {IFSeqSusKick.st13(5);}
				)}
			);
			},
			'/ifSeq/1/13'
		);
		~ifSeqKickBut14.free;
		~ifSeqKickBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick14 = ~cntSeqSusKick14 + 1;
				~cntSeqSusKick14.switch(
					0,{},
					1, {IFSeqSusKick.st14(1);},
					2, {IFSeqSusKick.st14(2);},
					3, {IFSeqSusKick.st14(3);},
					4, {IFSeqSusKick.st14(4);},
					5, {IFSeqSusKick.st14(5);}
				)}
			);
			},
			'/ifSeq/1/14'
		);
		~ifSeqKickBut15.free;
		~ifSeqKickBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick15 = ~cntSeqSusKick15 + 1;
				~cntSeqSusKick15.switch(
					0,{},
					1, {IFSeqSusKick.st15(1);},
					2, {IFSeqSusKick.st15(2);},
					3, {IFSeqSusKick.st15(3);},
					4, {IFSeqSusKick.st15(4);},
					5, {IFSeqSusKick.st15(5);}
				)}
			);
			},
			'/ifSeq/1/15'
		);
		~ifSeqKickBut16.free;
		~ifSeqKickBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusKick16 = ~cntSeqSusKick16 + 1;
				~cntSeqSusKick16.switch(
					0,{},
					1, {IFSeqSusKick.st16(1);},
					2, {IFSeqSusKick.st16(2);},
					3, {IFSeqSusKick.st16(3);},
					4, {IFSeqSusKick.st16(4);},
					5, {IFSeqSusKick.st16(5);}
				)}
			);
			},
			'/ifSeq/1/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqSusKick01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick01', '1');
		}
		{ i == 2 }  {
			~seqSusKick01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick01', '2');
		}
		{ i == 3 }  {
			~seqSusKick01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick01', '3');
		}
		{ i == 4 }  {
			~seqSusKick01.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick01', '4');
		}
		{ i == 5 }  {
			~seqSusKick01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick01', '5');
			~cntSeqSusKick01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqSusKick02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick02', '1');
		}
		{ i == 2 }  {
			~seqSusKick02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick02', '2');
		}
		{ i == 3 }  {
			~seqSusKick02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick02', '3');
		}
		{ i == 4 }  {
			~seqSusKick02.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick02', '4');
		}
		{ i == 5 }  {
			~seqSusKick02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick02', '5');
			~cntSeqSusKick02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqSusKick03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick03', '1');
		}
		{ i == 2 }  {
			~seqSusKick03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick03', '2');
		}
		{ i == 3 }  {
			~seqSusKick03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick03', '3');
		}
		{ i == 4 }  {
			~seqSusKick03.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick03', '4');
		}
		{ i == 5 }  {
			~seqSusKick03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick03', '5');
			~cntSeqSusKick03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqSusKick04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick04', '1');
		}
		{ i == 2 }  {
			~seqSusKick04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick04', '2');
		}
		{ i == 3 }  {
			~seqSusKick04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick04', '3');
		}
		{ i == 4 }  {
			~seqSusKick04.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick04', '4');
		}
		{ i == 5 }  {
			~seqSusKick04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick04', '5');
			~cntSeqSusKick04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqSusKick05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick05', '1');
		}
		{ i == 2 }  {
			~seqSusKick05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick05', '2');
		}
		{ i == 3 }  {
			~seqSusKick05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick05', '3');
		}
		{ i == 4 }  {
			~seqSusKick05.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick05', '4');
		}
		{ i == 5 }  {
			~seqSusKick05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick05', '5');
			~cntSeqSusKick05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqSusKick06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick06', '1');
		}
		{ i == 2 }  {
			~seqSusKick06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick06', '2');
		}
		{ i == 3 }  {
			~seqSusKick06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick06', '3');
		}
		{ i == 4 }  {
			~seqSusKick06.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick06', '4');
		}
		{ i == 5 }  {
			~seqSusKick06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick06', '5');
			~cntSeqSusKick06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqSusKick07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick07', '1');
		}
		{ i == 2 }  {
			~seqSusKick07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick07', '2');
		}
		{ i == 3 }  {
			~seqSusKick07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick07', '3');
		}
		{ i == 4 }  {
			~seqSusKick07.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick07', '4');
		}
		{ i == 5 }  {
			~seqSusKick07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick07', '5');
			~cntSeqSusKick07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqSusKick08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick08', '1');
		}
		{ i == 2 }  {
			~seqSusKick08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick08', '2');
		}
		{ i == 3 }  {
			~seqSusKick08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick08', '3');
		}
		{ i == 4 }  {
			~seqSusKick08.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick08', '4');
		}
		{ i == 5 }  {
			~seqSusKick08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick08', '5');
			~cntSeqSusKick08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqSusKick09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick09', '1');
		}
		{ i == 2 }  {
			~seqSusKick09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick09', '2');
		}
		{ i == 3 }  {
			~seqSusKick09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick09', '3');
		}
		{ i == 4 }  {
			~seqSusKick09.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick09', '4');
		}
		{ i == 5 }  {
			~seqSusKick09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick09', '5');
			~cntSeqSusKick09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqSusKick10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick10', '1');
		}
		{ i == 2 }  {
			~seqSusKick10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick10', '2');
		}
		{ i == 3 }  {
			~seqSusKick10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick10', '3');
		}
		{ i == 4 }  {
			~seqSusKick10.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick10', '4');
		}
		{ i == 5 }  {
			~seqSusKick10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick10', '5');
			~cntSeqSusKick10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqSusKick11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick11', '1');
		}
		{ i == 2 }  {
			~seqSusKick11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick11', '2');
		}
		{ i == 3 }  {
			~seqSusKick11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick11', '3');
		}
		{ i == 4 }  {
			~seqSusKick11.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick11', '4');
		}
		{ i == 5 }  {
			~seqSusKick11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick11', '5');
			~cntSeqSusKick11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqSusKick12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick12', '1');
		}
		{ i == 2 }  {
			~seqSusKick12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick12', '2');
		}
		{ i == 3 }  {
			~seqSusKick12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick12', '3');
		}
		{ i == 4 }  {
			~seqSusKick12.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick12', '4');
		}
		{ i == 5 }  {
			~seqSusKick12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick12', '5');
			~cntSeqSusKick12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqSusKick13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick13', '1');
		}
		{ i == 2 }  {
			~seqSusKick13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick13', '2');
		}
		{ i == 3 }  {
			~seqSusKick13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick13', '3');
		}
		{ i == 4 }  {
			~seqSusKick13.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick13', '4');
		}
		{ i == 5 }  {
			~seqSusKick13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick13', '5');
			~cntSeqSusKick13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqSusKick14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick14', '1');
		}
		{ i == 2 }  {
			~seqSusKick14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick14', '2');
		}
		{ i == 3 }  {
			~seqSusKick14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick14', '3');
		}
		{ i == 4 }  {
			~seqSusKick14.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick14', '4');
		}
		{ i == 5 }  {
			~seqSusKick14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick14', '5');
			~cntSeqSusKick14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqSusKick15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick15', '1');
		}
		{ i == 2 }  {
			~seqSusKick15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick15', '2');
		}
		{ i == 3 }  {
			~seqSusKick15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick15', '3');
		}
		{ i == 4 }  {
			~seqSusKick15.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick15', '4');
		}
		{ i == 5 }  {
			~seqSusKick15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick15', '5');
			~cntSeqSusKick15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqSusKick16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusKick16', '1');
		}
		{ i == 2 }  {
			~seqSusKick16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusKick16', '2');
		}
		{ i == 3 }  {
			~seqSusKick16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusKick16', '3');
		}
		{ i == 4 }  {
			~seqSusKick16.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusKick16', '4');
		}
		{ i == 5 }  {
			~seqSusKick16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusKick16', '5');
			~cntSeqSusKick16=0;
		}
	}
	*stGrp {|i|
		IFSeqSusKick.st01(i); IFSeqSusKick.st02(i); IFSeqSusKick.st03(i); IFSeqSusKick.st04(i);
		IFSeqSusKick.st05(i); IFSeqSusKick.st06(i); IFSeqSusKick.st07(i); IFSeqSusKick.st08(i);
		IFSeqSusKick.st09(i); IFSeqSusKick.st10(i); IFSeqSusKick.st11(i); IFSeqSusKick.st12(i);
		IFSeqSusKick.st13(i); IFSeqSusKick.st14(i); IFSeqSusKick.st15(i); IFSeqSusKick.st16(i);
	}
}