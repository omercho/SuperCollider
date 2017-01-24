IFSeqDurSnr {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqDurSnr01 = PatternProxy( Pseq([0.5], 1));
		~seqDurSnr02 = PatternProxy( Pseq([0.5], 1));
		~seqDurSnr03 = PatternProxy( Pseq([0.5], 1));
		~seqDurSnr04 = PatternProxy( Pseq([0.5], 1));
		~seqDurSnr05 = PatternProxy( Pseq([0.5], 1));
		~seqDurSnr06 = PatternProxy( Pseq([0.5], 1));
		~seqDurSnr07 = PatternProxy( Pseq([0.5], 1));
		~seqDurSnr08 = PatternProxy( Pseq([0.5], 1));

		~seqDurSnr09 = PatternProxy( Pseq([0.5], 1));
		~seqDurSnr10 = PatternProxy( Pseq([0.5], 1));
		~seqDurSnr11 = PatternProxy( Pseq([0.5], 1));
		~seqDurSnr12 = PatternProxy( Pseq([0.5], 1));
		~seqDurSnr13 = PatternProxy( Pseq([0.5], 1));
		~seqDurSnr14 = PatternProxy( Pseq([0.5], 1));
		~seqDurSnr15 = PatternProxy( Pseq([0.5], 1));
		~seqDurSnr16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqDurUpSnr01=0;
		~cntSeqDurRandSnr01=0;

		~cntSeqDurSnr01=0;
		~cntSeqDurSnr02=0;
		~cntSeqDurSnr03=0;
		~cntSeqDurSnr04=0;
		~cntSeqDurSnr05=0;
		~cntSeqDurSnr06=0;
		~cntSeqDurSnr07=0;
		~cntSeqDurSnr08=0;

		~cntSeqDurSnr09=0;
		~cntSeqDurSnr10=0;
		~cntSeqDurSnr11=0;
		~cntSeqDurSnr12=0;
		~cntSeqDurSnr13=0;
		~cntSeqDurSnr14=0;
		~cntSeqDurSnr15=0;
		~cntSeqDurSnr16=0;
	}
	*freeOn {
		~seqFreeSnrBut.free;
		~seqFreeSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqDurSnr.stGrp(4);
				});
			},
			'/seqFreeSnr'
		);
	}
	*upOn {
		~ifSeqUpSnrBut.free;
		~ifSeqUpSnrBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurUpSnr01 = ~cntSeqDurUpSnr01 + 1;
				~cntSeqDurUpSnr01.switch(
					0,{},
					1,{IFSeqDurSnr.stGrp(1);},
					2,{IFSeqDurSnr.stGrp(2);},
					3,{IFSeqDurSnr.stGrp(3);
						~cntSeqDurUpSnr01=0;
					}
				)}
			);
			},
			'/seqUpSnr'
		);
	}

	*randOn {
		~ifSeqRandSnrBut.free;
		~ifSeqRandSnrBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurRandSnr01 = ~cntSeqDurRandSnr01 + 1;
				~cntSeqDurRandSnr01.switch(
					0,{},
					1,{
						IFSeqDurSnr.st01([1,2,3,4,5].choose);
						IFSeqDurSnr.st02([1,2,3,4,5].choose);
						IFSeqDurSnr.st03([1,2,3,4,5].choose);
						IFSeqDurSnr.st04([1,2,3,4,5].choose);
						IFSeqDurSnr.st05([1,2,3,4,5].choose);
						IFSeqDurSnr.st06([1,2,3,4,5].choose);
						IFSeqDurSnr.st07([1,2,3,4,5].choose);
						IFSeqDurSnr.st08([1,2,3,4,5].choose);

						IFSeqDurSnr.st09([1,2,3,4,5].choose);
						IFSeqDurSnr.st10([1,2,3,4,5].choose);
						IFSeqDurSnr.st11([1,2,3,4,5].choose);
						IFSeqDurSnr.st12([1,2,3,4,5].choose);
						IFSeqDurSnr.st13([1,2,3,4,5].choose);
						IFSeqDurSnr.st14([1,2,3,4,5].choose);
						IFSeqDurSnr.st15([1,2,3,4,5].choose);
						IFSeqDurSnr.st16([1,2,3,4,5].choose);
						~cntSeqDurRandSnr01=0;
					}
				)}
			);
			},
			'/seqRandSnr'
		);
	}


	*on { // Shift Durocity

		IFSeqDurSnr.randOn;
		IFSeqDurSnr.upOn;
		IFSeqDurSnr.freeOn;

		~ifSeqSnrBut01.free;
		~ifSeqSnrBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr01 = ~cntSeqDurSnr01 + 1;
				~cntSeqDurSnr01.switch(
					0,{},
					1, {IFSeqDurSnr.st01(1);},
					2, {IFSeqDurSnr.st01(2);},
					3, {IFSeqDurSnr.st01(3);},
					4, {IFSeqDurSnr.st01(4);},
					5, {IFSeqDurSnr.st01(5);}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqSnrBut02.free;
		~ifSeqSnrBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr02 = ~cntSeqDurSnr02 + 1;
				~cntSeqDurSnr02.switch(
					0,{},
					1, {IFSeqDurSnr.st02(1);},
					2, {IFSeqDurSnr.st02(2);},
					3, {IFSeqDurSnr.st02(3);},
					4, {IFSeqDurSnr.st02(4);},
					5, {IFSeqDurSnr.st02(5);}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqSnrBut03.free;
		~ifSeqSnrBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr03 = ~cntSeqDurSnr03 + 1;
				~cntSeqDurSnr03.switch(
					0,{},
					1, {IFSeqDurSnr.st03(1);},
					2, {IFSeqDurSnr.st03(2);},
					3, {IFSeqDurSnr.st03(3);},
					4, {IFSeqDurSnr.st03(4);},
					5, {IFSeqDurSnr.st03(5);}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqSnrBut04.free;
		~ifSeqSnrBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr04 = ~cntSeqDurSnr04 + 1;
				~cntSeqDurSnr04.switch(
					0,{},
					1, {IFSeqDurSnr.st04(1);},
					2, {IFSeqDurSnr.st04(2);},
					3, {IFSeqDurSnr.st04(3);},
					4, {IFSeqDurSnr.st04(4);},
					5, {IFSeqDurSnr.st04(5);}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqSnrBut05.free;
		~ifSeqSnrBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr05 = ~cntSeqDurSnr05 + 1;
				~cntSeqDurSnr05.switch(
					0,{},
					1, {IFSeqDurSnr.st05(1);},
					2, {IFSeqDurSnr.st05(2);},
					3, {IFSeqDurSnr.st05(3);},
					4, {IFSeqDurSnr.st05(4);},
					5, {IFSeqDurSnr.st05(5);}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqSnrBut06.free;
		~ifSeqSnrBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr06 = ~cntSeqDurSnr06 + 1;
				~cntSeqDurSnr06.switch(
					0,{},
					1, {IFSeqDurSnr.st06(1);},
					2, {IFSeqDurSnr.st06(2);},
					3, {IFSeqDurSnr.st06(3);},
					4, {IFSeqDurSnr.st06(4);},
					5, {IFSeqDurSnr.st06(5);}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqSnrBut07.free;
		~ifSeqSnrBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr07 = ~cntSeqDurSnr07 + 1;
				~cntSeqDurSnr07.switch(
					0,{},
					1, {IFSeqDurSnr.st07(1);},
					2, {IFSeqDurSnr.st07(2);},
					3, {IFSeqDurSnr.st07(3);},
					4, {IFSeqDurSnr.st07(4);},
					5, {IFSeqDurSnr.st07(5);}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqSnrBut08.free;
		~ifSeqSnrBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr08 = ~cntSeqDurSnr08 + 1;
				~cntSeqDurSnr08.switch(
					0,{},
					1, {IFSeqDurSnr.st08(1);},
					2, {IFSeqDurSnr.st08(2);},
					3, {IFSeqDurSnr.st08(3);},
					4, {IFSeqDurSnr.st08(4);},
					5, {IFSeqDurSnr.st08(5);}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqSnrBut09.free;
		~ifSeqSnrBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr09 = ~cntSeqDurSnr09 + 1;
				~cntSeqDurSnr09.switch(
					0,{},
					1, {IFSeqDurSnr.st09(1);},
					2, {IFSeqDurSnr.st09(2);},
					3, {IFSeqDurSnr.st09(3);},
					4, {IFSeqDurSnr.st09(4);},
					5, {IFSeqDurSnr.st09(5);}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqSnrBut10.free;
		~ifSeqSnrBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr10 = ~cntSeqDurSnr10 + 1;
				~cntSeqDurSnr10.switch(
					0,{},
					1, {IFSeqDurSnr.st10(1);},
					2, {IFSeqDurSnr.st10(2);},
					3, {IFSeqDurSnr.st10(3);},
					4, {IFSeqDurSnr.st10(4);},
					5, {IFSeqDurSnr.st10(5);}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqSnrBut11.free;
		~ifSeqSnrBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr11 = ~cntSeqDurSnr11 + 1;
				~cntSeqDurSnr11.switch(
					0,{},
					1, {IFSeqDurSnr.st11(1);},
					2, {IFSeqDurSnr.st11(2);},
					3, {IFSeqDurSnr.st11(3);},
					4, {IFSeqDurSnr.st11(4);},
					5, {IFSeqDurSnr.st11(5);}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqSnrBut12.free;
		~ifSeqSnrBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr12 = ~cntSeqDurSnr12 + 1;
				~cntSeqDurSnr12.switch(
					0,{},
					1, {IFSeqDurSnr.st12(1);},
					2, {IFSeqDurSnr.st12(2);},
					3, {IFSeqDurSnr.st12(3);},
					4, {IFSeqDurSnr.st12(4);},
					5, {IFSeqDurSnr.st12(5);}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqSnrBut13.free;
		~ifSeqSnrBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr13 = ~cntSeqDurSnr13 + 1;
				~cntSeqDurSnr13.switch(
					0,{},
					1, {IFSeqDurSnr.st13(1);},
					2, {IFSeqDurSnr.st13(2);},
					3, {IFSeqDurSnr.st13(3);},
					4, {IFSeqDurSnr.st13(4);},
					5, {IFSeqDurSnr.st13(5);}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqSnrBut14.free;
		~ifSeqSnrBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr14 = ~cntSeqDurSnr14 + 1;
				~cntSeqDurSnr14.switch(
					0,{},
					1, {IFSeqDurSnr.st14(1);},
					2, {IFSeqDurSnr.st14(2);},
					3, {IFSeqDurSnr.st14(3);},
					4, {IFSeqDurSnr.st14(4);},
					5, {IFSeqDurSnr.st14(5);}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqSnrBut15.free;
		~ifSeqSnrBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr15 = ~cntSeqDurSnr15 + 1;
				~cntSeqDurSnr15.switch(
					0,{},
					1, {IFSeqDurSnr.st15(1);},
					2, {IFSeqDurSnr.st15(2);},
					3, {IFSeqDurSnr.st15(3);},
					4, {IFSeqDurSnr.st15(4);},
					5, {IFSeqDurSnr.st15(5);}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqSnrBut16.free;
		~ifSeqSnrBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqDurSnr16 = ~cntSeqDurSnr16 + 1;
				~cntSeqDurSnr16.switch(
					0,{},
					1, {IFSeqDurSnr.st16(1);},
					2, {IFSeqDurSnr.st16(2);},
					3, {IFSeqDurSnr.st16(3);},
					4, {IFSeqDurSnr.st16(4);},
					5, {IFSeqDurSnr.st16(5);}
				)}
			);
			},
			'/ifSeq/2/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr01.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr01', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr01.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr01', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr01.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr01', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr01.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr01', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr01', '1.5');
			~cntSeqDurSnr01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr02.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr02', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr02.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr02', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr02.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr02', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr02.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr02', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr02', '1.5');
			~cntSeqDurSnr02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr03.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr03', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr03.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr03', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr03.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr03', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr03.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr03', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr03', '1.5');
			~cntSeqDurSnr03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr04.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr04', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr04.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr04', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr04.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr04', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr04.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr04', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr04', '1.5');
			~cntSeqDurSnr04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr05.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr05', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr05.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr05', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr05.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr05', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr05.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr05', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr05', '1.5');
			~cntSeqDurSnr05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr06.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr06', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr06.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr06', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr06.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr06', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr06.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr06', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr06', '1.5');
			~cntSeqDurSnr06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr07.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr07', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr07.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr07', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr07.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr07', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr07.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr07', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr07', '1.5');
			~cntSeqDurSnr07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr08.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr08', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr08.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr08', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr08.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr08', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr08.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr08', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr08', '1.5');
			~cntSeqDurSnr08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr09.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr09', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr09.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr09', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr09.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr09', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr09.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr09', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr09', '1.5');
			~cntSeqDurSnr09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr10.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr10', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr10.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr10', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr10.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr10', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr10.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr10', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr10', '1.5');
			~cntSeqDurSnr10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr11.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr11', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr11.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr11', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr11.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr11', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr11.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr11', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr11', '1.5');
			~cntSeqDurSnr11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr12.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr12', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr12.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr12', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr12.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr12', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr12.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr12', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr12', '1.5');
			~cntSeqDurSnr12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr13.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr13', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr13.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr13', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr13.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr13', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr13.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr13', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr13', '1.5');
			~cntSeqDurSnr13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr14.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr14', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr14.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr14', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr14.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr14', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr14.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr14', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr14', '1.5');
			~cntSeqDurSnr14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr15.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr15', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr15.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr15', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr15.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr15', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr15.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr15', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr15', '1.5');
			~cntSeqDurSnr15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqDurSnr16.source = Pseq([1/4], 1);
			~tOSCAdrr.sendMsg('shDurSnr16', '1/4');
		}
		{ i == 2 }  {
			~seqDurSnr16.source = Pseq([1/3], 1);
			~tOSCAdrr.sendMsg('shDurSnr16', '1/3');
		}
		{ i == 3 }  {
			~seqDurSnr16.source = Pseq([1/2], 1);
			~tOSCAdrr.sendMsg('shDurSnr16', '1/2');
		}
		{ i == 4 }  {
			~seqDurSnr16.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurSnr16', '1/1');
		}
		{ i == 5 }  {
			~seqDurSnr16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shDurSnr16', '1.5');
			~cntSeqDurSnr16=0;
		}
	}
	*stGrp {|i|
		IFSeqDurSnr.st01(i); IFSeqDurSnr.st02(i); IFSeqDurSnr.st03(i); IFSeqDurSnr.st04(i);
		IFSeqDurSnr.st05(i); IFSeqDurSnr.st06(i); IFSeqDurSnr.st07(i); IFSeqDurSnr.st08(i);
		IFSeqDurSnr.st09(i); IFSeqDurSnr.st10(i); IFSeqDurSnr.st11(i); IFSeqDurSnr.st12(i);
		IFSeqDurSnr.st13(i); IFSeqDurSnr.st14(i); IFSeqDurSnr.st15(i); IFSeqDurSnr.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqDurSnr.st01(s01); IFSeqDurSnr.st02(s02); IFSeqDurSnr.st03(s03); IFSeqDurSnr.st04(s04);
		IFSeqDurSnr.st05(s05); IFSeqDurSnr.st06(s06); IFSeqDurSnr.st07(s07); IFSeqDurSnr.st08(s08);
		IFSeqDurSnr.st09(s09); IFSeqDurSnr.st10(s10); IFSeqDurSnr.st11(s11); IFSeqDurSnr.st12(s12);
		IFSeqDurSnr.st13(s13); IFSeqDurSnr.st14(s14); IFSeqDurSnr.st15(s15); IFSeqDurSnr.st16(s16);
	}
}