IFSeqDurKick {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqDurKick01 = PatternProxy( Pseq([0.5], 1));
		~seqDurKick02 = PatternProxy( Pseq([0.5], 1));
		~seqDurKick03 = PatternProxy( Pseq([0.5], 1));
		~seqDurKick04 = PatternProxy( Pseq([0.5], 1));
		~seqDurKick05 = PatternProxy( Pseq([0.5], 1));
		~seqDurKick06 = PatternProxy( Pseq([0.5], 1));
		~seqDurKick07 = PatternProxy( Pseq([0.5], 1));
		~seqDurKick08 = PatternProxy( Pseq([0.5], 1));

		~seqDurKick09 = PatternProxy( Pseq([0.5], 1));
		~seqDurKick10 = PatternProxy( Pseq([0.5], 1));
		~seqDurKick11 = PatternProxy( Pseq([0.5], 1));
		~seqDurKick12 = PatternProxy( Pseq([0.5], 1));
		~seqDurKick13 = PatternProxy( Pseq([0.5], 1));
		~seqDurKick14 = PatternProxy( Pseq([0.5], 1));
		~seqDurKick15 = PatternProxy( Pseq([0.5], 1));
		~seqDurKick16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqDurUpKick01=0;
		~cntSeqDurRandKick01=0;

		~cntSeqDurKick01=0;
		~cntSeqDurKick02=0;
		~cntSeqDurKick03=0;
		~cntSeqDurKick04=0;
		~cntSeqDurKick05=0;
		~cntSeqDurKick06=0;
		~cntSeqDurKick07=0;
		~cntSeqDurKick08=0;

		~cntSeqDurKick09=0;
		~cntSeqDurKick10=0;
		~cntSeqDurKick11=0;
		~cntSeqDurKick12=0;
		~cntSeqDurKick13=0;
		~cntSeqDurKick14=0;
		~cntSeqDurKick15=0;
		~cntSeqDurKick16=0;
	}
	*freeOn {
		~seqFreeKickBut.free;
		~seqFreeKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqDurKick.stGrp(4);
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
				~cntSeqDurUpKick01 = ~cntSeqDurUpKick01 + 1;
				~cntSeqDurUpKick01.switch(
					0,{},
					1,{IFSeqDurKick.stGrp(1);},
					2,{IFSeqDurKick.stGrp(2);},
					3,{IFSeqDurKick.stGrp(3);
						~cntSeqDurUpKick01=0;
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
				~cntSeqDurRandKick01 = ~cntSeqDurRandKick01 + 1;
				~cntSeqDurRandKick01.switch(
					0,{},
					1,{
						IFSeqDurKick.st01([1,2,3,4,5].choose);
						IFSeqDurKick.st02([1,2,3,4,5].choose);
						IFSeqDurKick.st03([1,2,3,4,5].choose);
						IFSeqDurKick.st04([1,2,3,4,5].choose);
						IFSeqDurKick.st05([1,2,3,4,5].choose);
						IFSeqDurKick.st06([1,2,3,4,5].choose);
						IFSeqDurKick.st07([1,2,3,4,5].choose);
						IFSeqDurKick.st08([1,2,3,4,5].choose);

						IFSeqDurKick.st09([1,2,3,4,5].choose);
						IFSeqDurKick.st10([1,2,3,4,5].choose);
						IFSeqDurKick.st11([1,2,3,4,5].choose);
						IFSeqDurKick.st12([1,2,3,4,5].choose);
						IFSeqDurKick.st13([1,2,3,4,5].choose);
						IFSeqDurKick.st14([1,2,3,4,5].choose);
						IFSeqDurKick.st15([1,2,3,4,5].choose);
						IFSeqDurKick.st16([1,2,3,4,5].choose);
						~cntSeqDurRandKick01=0;
					}
				)}
			);
			},
			'/seqRandKick'
		);
	}


	*on { // Shift Durocity

		IFSeqDurKick.randOn;
		IFSeqDurKick.upOn;
		IFSeqDurKick.freeOn;

		~ifSeqKickBut01.free;
		~ifSeqKickBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick01 = ~cntSeqDurKick01 + 1;
				~cntSeqDurKick01.switch(
					0,{},
					1, {IFSeqDurKick.st01(1);},
					2, {IFSeqDurKick.st01(2);},
					3, {IFSeqDurKick.st01(3);},
					4, {IFSeqDurKick.st01(4);},
					5, {IFSeqDurKick.st01(5);}
				)}
			);
			},
			'/ifSeq/1/1'
		);
		~ifSeqKickBut02.free;
		~ifSeqKickBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick02 = ~cntSeqDurKick02 + 1;
				~cntSeqDurKick02.switch(
					0,{},
					1, {IFSeqDurKick.st02(1);},
					2, {IFSeqDurKick.st02(2);},
					3, {IFSeqDurKick.st02(3);},
					4, {IFSeqDurKick.st02(4);},
					5, {IFSeqDurKick.st02(5);}
				)}
			);
			},
			'/ifSeq/1/2'
		);
		~ifSeqKickBut03.free;
		~ifSeqKickBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick03 = ~cntSeqDurKick03 + 1;
				~cntSeqDurKick03.switch(
					0,{},
					1, {IFSeqDurKick.st03(1);},
					2, {IFSeqDurKick.st03(2);},
					3, {IFSeqDurKick.st03(3);},
					4, {IFSeqDurKick.st03(4);},
					5, {IFSeqDurKick.st03(5);}
				)}
			);
			},
			'/ifSeq/1/3'
		);
		~ifSeqKickBut04.free;
		~ifSeqKickBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick04 = ~cntSeqDurKick04 + 1;
				~cntSeqDurKick04.switch(
					0,{},
					1, {IFSeqDurKick.st04(1);},
					2, {IFSeqDurKick.st04(2);},
					3, {IFSeqDurKick.st04(3);},
					4, {IFSeqDurKick.st04(4);},
					5, {IFSeqDurKick.st04(5);}
				)}
			);
			},
			'/ifSeq/1/4'
		);
		~ifSeqKickBut05.free;
		~ifSeqKickBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick05 = ~cntSeqDurKick05 + 1;
				~cntSeqDurKick05.switch(
					0,{},
					1, {IFSeqDurKick.st05(1);},
					2, {IFSeqDurKick.st05(2);},
					3, {IFSeqDurKick.st05(3);},
					4, {IFSeqDurKick.st05(4);},
					5, {IFSeqDurKick.st05(5);}
				)}
			);
			},
			'/ifSeq/1/5'
		);
		~ifSeqKickBut06.free;
		~ifSeqKickBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick06 = ~cntSeqDurKick06 + 1;
				~cntSeqDurKick06.switch(
					0,{},
					1, {IFSeqDurKick.st06(1);},
					2, {IFSeqDurKick.st06(2);},
					3, {IFSeqDurKick.st06(3);},
					4, {IFSeqDurKick.st06(4);},
					5, {IFSeqDurKick.st06(5);}
				)}
			);
			},
			'/ifSeq/1/6'
		);
		~ifSeqKickBut07.free;
		~ifSeqKickBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick07 = ~cntSeqDurKick07 + 1;
				~cntSeqDurKick07.switch(
					0,{},
					1, {IFSeqDurKick.st07(1);},
					2, {IFSeqDurKick.st07(2);},
					3, {IFSeqDurKick.st07(3);},
					4, {IFSeqDurKick.st07(4);},
					5, {IFSeqDurKick.st07(5);}
				)}
			);
			},
			'/ifSeq/1/7'
		);
		~ifSeqKickBut08.free;
		~ifSeqKickBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick08 = ~cntSeqDurKick08 + 1;
				~cntSeqDurKick08.switch(
					0,{},
					1, {IFSeqDurKick.st08(1);},
					2, {IFSeqDurKick.st08(2);},
					3, {IFSeqDurKick.st08(3);},
					4, {IFSeqDurKick.st08(4);},
					5, {IFSeqDurKick.st08(5);}
				)}
			);
			},
			'/ifSeq/1/8'
		);

		~ifSeqKickBut09.free;
		~ifSeqKickBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick09 = ~cntSeqDurKick09 + 1;
				~cntSeqDurKick09.switch(
					0,{},
					1, {IFSeqDurKick.st09(1);},
					2, {IFSeqDurKick.st09(2);},
					3, {IFSeqDurKick.st09(3);},
					4, {IFSeqDurKick.st09(4);},
					5, {IFSeqDurKick.st09(5);}
				)}
			);
			},
			'/ifSeq/1/9'
		);
		~ifSeqKickBut10.free;
		~ifSeqKickBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick10 = ~cntSeqDurKick10 + 1;
				~cntSeqDurKick10.switch(
					0,{},
					1, {IFSeqDurKick.st10(1);},
					2, {IFSeqDurKick.st10(2);},
					3, {IFSeqDurKick.st10(3);},
					4, {IFSeqDurKick.st10(4);},
					5, {IFSeqDurKick.st10(5);}
				)}
			);
			},
			'/ifSeq/1/10'
		);
		~ifSeqKickBut11.free;
		~ifSeqKickBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick11 = ~cntSeqDurKick11 + 1;
				~cntSeqDurKick11.switch(
					0,{},
					1, {IFSeqDurKick.st11(1);},
					2, {IFSeqDurKick.st11(2);},
					3, {IFSeqDurKick.st11(3);},
					4, {IFSeqDurKick.st11(4);},
					5, {IFSeqDurKick.st11(5);}
				)}
			);
			},
			'/ifSeq/1/11'
		);
		~ifSeqKickBut12.free;
		~ifSeqKickBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick12 = ~cntSeqDurKick12 + 1;
				~cntSeqDurKick12.switch(
					0,{},
					1, {IFSeqDurKick.st12(1);},
					2, {IFSeqDurKick.st12(2);},
					3, {IFSeqDurKick.st12(3);},
					4, {IFSeqDurKick.st12(4);},
					5, {IFSeqDurKick.st12(5);}
				)}
			);
			},
			'/ifSeq/1/12'
		);
		~ifSeqKickBut13.free;
		~ifSeqKickBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick13 = ~cntSeqDurKick13 + 1;
				~cntSeqDurKick13.switch(
					0,{},
					1, {IFSeqDurKick.st13(1);},
					2, {IFSeqDurKick.st13(2);},
					3, {IFSeqDurKick.st13(3);},
					4, {IFSeqDurKick.st13(4);},
					5, {IFSeqDurKick.st13(5);}
				)}
			);
			},
			'/ifSeq/1/13'
		);
		~ifSeqKickBut14.free;
		~ifSeqKickBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick14 = ~cntSeqDurKick14 + 1;
				~cntSeqDurKick14.switch(
					0,{},
					1, {IFSeqDurKick.st14(1);},
					2, {IFSeqDurKick.st14(2);},
					3, {IFSeqDurKick.st14(3);},
					4, {IFSeqDurKick.st14(4);},
					5, {IFSeqDurKick.st14(5);}
				)}
			);
			},
			'/ifSeq/1/14'
		);
		~ifSeqKickBut15.free;
		~ifSeqKickBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick15 = ~cntSeqDurKick15 + 1;
				~cntSeqDurKick15.switch(
					0,{},
					1, {IFSeqDurKick.st15(1);},
					2, {IFSeqDurKick.st15(2);},
					3, {IFSeqDurKick.st15(3);},
					4, {IFSeqDurKick.st15(4);},
					5, {IFSeqDurKick.st15(5);}
				)}
			);
			},
			'/ifSeq/1/15'
		);
		~ifSeqKickBut16.free;
		~ifSeqKickBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurKick16 = ~cntSeqDurKick16 + 1;
				~cntSeqDurKick16.switch(
					0,{},
					1, {IFSeqDurKick.st16(1);},
					2, {IFSeqDurKick.st16(2);},
					3, {IFSeqDurKick.st16(3);},
					4, {IFSeqDurKick.st16(4);},
					5, {IFSeqDurKick.st16(5);}
				)}
			);
			},
			'/ifSeq/1/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqDurKick01.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick01', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick01.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick01', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick01.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick01', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick01.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick01', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick01', '1.5');
			~cntSeqDurKick01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqDurKick02.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick02', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick02.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick02', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick02.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick02', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick02.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick02', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick02', '1.5');
			~cntSeqDurKick02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqDurKick03.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick03', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick03.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick03', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick03.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick03', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick03.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick03', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick03', '1.5');
			~cntSeqDurKick03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqDurKick04.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick04', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick04.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick04', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick04.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick04', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick04.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick04', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick04', '1.5');
			~cntSeqDurKick04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqDurKick05.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick05', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick05.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick05', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick05.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick05', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick05.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick05', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick05', '1.5');
			~cntSeqDurKick05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqDurKick06.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick06', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick06.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick06', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick06.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick06', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick06.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick06', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick06', '1.5');
			~cntSeqDurKick06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqDurKick07.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick07', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick07.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick07', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick07.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick07', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick07.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick07', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick07', '1.5');
			~cntSeqDurKick07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqDurKick08.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick08', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick08.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick08', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick08.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick08', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick08.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick08', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick08', '1.5');
			~cntSeqDurKick08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqDurKick09.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick09', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick09.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick09', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick09.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick09', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick09.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick09', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick09', '1.5');
			~cntSeqDurKick09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqDurKick10.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick10', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick10.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick10', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick10.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick10', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick10.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick10', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick10', '1.5');
			~cntSeqDurKick10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqDurKick11.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick11', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick11.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick11', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick11.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick11', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick11.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick11', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick11', '1.5');
			~cntSeqDurKick11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqDurKick12.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick12', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick12.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick12', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick12.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick12', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick12.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick12', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick12', '1.5');
			~cntSeqDurKick12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqDurKick13.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick13', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick13.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick13', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick13.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick13', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick13.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick13', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick13', '1.5');
			~cntSeqDurKick13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqDurKick14.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick14', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick14.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick14', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick14.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick14', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick14.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick14', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick14', '1.5');
			~cntSeqDurKick14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqDurKick15.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick15', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick15.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick15', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick15.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick15', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick15.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick15', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick15', '1.5');
			~cntSeqDurKick15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqDurKick16.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurKick16', '1/4');
		}
		{ i == 2 }  {
			~seqDurKick16.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurKick16', '1/3');
		}
		{ i == 3 }  {
			~seqDurKick16.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurKick16', '1/2');
		}
		{ i == 4 }  {
			~seqDurKick16.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurKick16', '1/1');
		}
		{ i == 5 }  {
			~seqDurKick16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurKick16', '1.5');
			~cntSeqDurKick16=0;
		}
	}
	*stGrp {|i|
		IFSeqDurKick.st01(i); IFSeqDurKick.st02(i); IFSeqDurKick.st03(i); IFSeqDurKick.st04(i);
		IFSeqDurKick.st05(i); IFSeqDurKick.st06(i); IFSeqDurKick.st07(i); IFSeqDurKick.st08(i);
		IFSeqDurKick.st09(i); IFSeqDurKick.st10(i); IFSeqDurKick.st11(i); IFSeqDurKick.st12(i);
		IFSeqDurKick.st13(i); IFSeqDurKick.st14(i); IFSeqDurKick.st15(i); IFSeqDurKick.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqDurKick.st01(s01); IFSeqDurKick.st02(s02); IFSeqDurKick.st03(s03); IFSeqDurKick.st04(s04);
		IFSeqDurKick.st05(s05); IFSeqDurKick.st06(s06); IFSeqDurKick.st07(s07); IFSeqDurKick.st08(s08);
		IFSeqDurKick.st09(s09); IFSeqDurKick.st10(s10); IFSeqDurKick.st11(s11); IFSeqDurKick.st12(s12);
		IFSeqDurKick.st13(s13); IFSeqDurKick.st14(s14); IFSeqDurKick.st15(s15); IFSeqDurKick.st16(s16);
	}
}