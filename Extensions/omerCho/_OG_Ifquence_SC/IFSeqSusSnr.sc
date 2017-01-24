IFSeqSusSnr {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqSusSnr01 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr02 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr03 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr04 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr05 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr06 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr07 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr08 = PatternProxy( Pseq([0.5], 1));

		~seqSusSnr09 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr10 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr11 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr12 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr13 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr14 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr15 = PatternProxy( Pseq([0.5], 1));
		~seqSusSnr16 = PatternProxy( Pseq([0.5], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqSusUpSnr01=0;
		~cntSeqSusRandSnr01=0;

		~cntSeqSusSnr01=0;
		~cntSeqSusSnr02=0;
		~cntSeqSusSnr03=0;
		~cntSeqSusSnr04=0;
		~cntSeqSusSnr05=0;
		~cntSeqSusSnr06=0;
		~cntSeqSusSnr07=0;
		~cntSeqSusSnr08=0;

		~cntSeqSusSnr09=0;
		~cntSeqSusSnr10=0;
		~cntSeqSusSnr11=0;
		~cntSeqSusSnr12=0;
		~cntSeqSusSnr13=0;
		~cntSeqSusSnr14=0;
		~cntSeqSusSnr15=0;
		~cntSeqSusSnr16=0;
	}
	*freeOn {
		~seqFreeSnrBut.free;
		~seqFreeSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSusSnr.stGrp(1);
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
				~cntSeqSusUpSnr01 = ~cntSeqSusUpSnr01 + 1;
				~cntSeqSusUpSnr01.switch(
					0,{},
					1,{IFSeqSusSnr.stGrp(1);},
					2,{IFSeqSusSnr.stGrp(2);},
					3,{IFSeqSusSnr.stGrp(3);
						~cntSeqSusUpSnr01=0;
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
				~cntSeqSusRandSnr01 = ~cntSeqSusRandSnr01 + 1;
				~cntSeqSusRandSnr01.switch(
					0,{},
					1,{
						IFSeqSusSnr.st01([1,2,3,4,5].choose);
						IFSeqSusSnr.st02([1,2,3,4,5].choose);
						IFSeqSusSnr.st03([1,2,3,4,5].choose);
						IFSeqSusSnr.st04([1,2,3,4,5].choose);
						IFSeqSusSnr.st05([1,2,3,4,5].choose);
						IFSeqSusSnr.st06([1,2,3,4,5].choose);
						IFSeqSusSnr.st07([1,2,3,4,5].choose);
						IFSeqSusSnr.st08([1,2,3,4,5].choose);

						IFSeqSusSnr.st09([1,2,3,4,5].choose);
						IFSeqSusSnr.st10([1,2,3,4,5].choose);
						IFSeqSusSnr.st11([1,2,3,4,5].choose);
						IFSeqSusSnr.st12([1,2,3,4,5].choose);
						IFSeqSusSnr.st13([1,2,3,4,5].choose);
						IFSeqSusSnr.st14([1,2,3,4,5].choose);
						IFSeqSusSnr.st15([1,2,3,4,5].choose);
						IFSeqSusSnr.st16([1,2,3,4,5].choose);
						~cntSeqSusRandSnr01=0;
					}
				)}
			);
			},
			'/seqRandSnr'
		);
	}


	*on { // Shift Susocity

		IFSeqSusSnr.randOn;
		IFSeqSusSnr.upOn;
		IFSeqSusSnr.freeOn;

		~ifSeqSnrBut01.free;
		~ifSeqSnrBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr01 = ~cntSeqSusSnr01 + 1;
				~cntSeqSusSnr01.switch(
					0,{},
					1, {IFSeqSusSnr.st01(1);},
					2, {IFSeqSusSnr.st01(2);},
					3, {IFSeqSusSnr.st01(3);},
					4, {IFSeqSusSnr.st01(4);},
					5, {IFSeqSusSnr.st01(5);}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqSnrBut02.free;
		~ifSeqSnrBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr02 = ~cntSeqSusSnr02 + 1;
				~cntSeqSusSnr02.switch(
					0,{},
					1, {IFSeqSusSnr.st02(1);},
					2, {IFSeqSusSnr.st02(2);},
					3, {IFSeqSusSnr.st02(3);},
					4, {IFSeqSusSnr.st02(4);},
					5, {IFSeqSusSnr.st02(5);}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqSnrBut03.free;
		~ifSeqSnrBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr03 = ~cntSeqSusSnr03 + 1;
				~cntSeqSusSnr03.switch(
					0,{},
					1, {IFSeqSusSnr.st03(1);},
					2, {IFSeqSusSnr.st03(2);},
					3, {IFSeqSusSnr.st03(3);},
					4, {IFSeqSusSnr.st03(4);},
					5, {IFSeqSusSnr.st03(5);}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqSnrBut04.free;
		~ifSeqSnrBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr04 = ~cntSeqSusSnr04 + 1;
				~cntSeqSusSnr04.switch(
					0,{},
					1, {IFSeqSusSnr.st04(1);},
					2, {IFSeqSusSnr.st04(2);},
					3, {IFSeqSusSnr.st04(3);},
					4, {IFSeqSusSnr.st04(4);},
					5, {IFSeqSusSnr.st04(5);}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqSnrBut05.free;
		~ifSeqSnrBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr05 = ~cntSeqSusSnr05 + 1;
				~cntSeqSusSnr05.switch(
					0,{},
					1, {IFSeqSusSnr.st05(1);},
					2, {IFSeqSusSnr.st05(2);},
					3, {IFSeqSusSnr.st05(3);},
					4, {IFSeqSusSnr.st05(4);},
					5, {IFSeqSusSnr.st05(5);}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqSnrBut06.free;
		~ifSeqSnrBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr06 = ~cntSeqSusSnr06 + 1;
				~cntSeqSusSnr06.switch(
					0,{},
					1, {IFSeqSusSnr.st06(1);},
					2, {IFSeqSusSnr.st06(2);},
					3, {IFSeqSusSnr.st06(3);},
					4, {IFSeqSusSnr.st06(4);},
					5, {IFSeqSusSnr.st06(5);}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqSnrBut07.free;
		~ifSeqSnrBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr07 = ~cntSeqSusSnr07 + 1;
				~cntSeqSusSnr07.switch(
					0,{},
					1, {IFSeqSusSnr.st07(1);},
					2, {IFSeqSusSnr.st07(2);},
					3, {IFSeqSusSnr.st07(3);},
					4, {IFSeqSusSnr.st07(4);},
					5, {IFSeqSusSnr.st07(5);}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqSnrBut08.free;
		~ifSeqSnrBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr08 = ~cntSeqSusSnr08 + 1;
				~cntSeqSusSnr08.switch(
					0,{},
					1, {IFSeqSusSnr.st08(1);},
					2, {IFSeqSusSnr.st08(2);},
					3, {IFSeqSusSnr.st08(3);},
					4, {IFSeqSusSnr.st08(4);},
					5, {IFSeqSusSnr.st08(5);}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqSnrBut09.free;
		~ifSeqSnrBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr09 = ~cntSeqSusSnr09 + 1;
				~cntSeqSusSnr09.switch(
					0,{},
					1, {IFSeqSusSnr.st09(1);},
					2, {IFSeqSusSnr.st09(2);},
					3, {IFSeqSusSnr.st09(3);},
					4, {IFSeqSusSnr.st09(4);},
					5, {IFSeqSusSnr.st09(5);}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqSnrBut10.free;
		~ifSeqSnrBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr10 = ~cntSeqSusSnr10 + 1;
				~cntSeqSusSnr10.switch(
					0,{},
					1, {IFSeqSusSnr.st10(1);},
					2, {IFSeqSusSnr.st10(2);},
					3, {IFSeqSusSnr.st10(3);},
					4, {IFSeqSusSnr.st10(4);},
					5, {IFSeqSusSnr.st10(5);}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqSnrBut11.free;
		~ifSeqSnrBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr11 = ~cntSeqSusSnr11 + 1;
				~cntSeqSusSnr11.switch(
					0,{},
					1, {IFSeqSusSnr.st11(1);},
					2, {IFSeqSusSnr.st11(2);},
					3, {IFSeqSusSnr.st11(3);},
					4, {IFSeqSusSnr.st11(4);},
					5, {IFSeqSusSnr.st11(5);}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqSnrBut12.free;
		~ifSeqSnrBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr12 = ~cntSeqSusSnr12 + 1;
				~cntSeqSusSnr12.switch(
					0,{},
					1, {IFSeqSusSnr.st12(1);},
					2, {IFSeqSusSnr.st12(2);},
					3, {IFSeqSusSnr.st12(3);},
					4, {IFSeqSusSnr.st12(4);},
					5, {IFSeqSusSnr.st12(5);}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqSnrBut13.free;
		~ifSeqSnrBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr13 = ~cntSeqSusSnr13 + 1;
				~cntSeqSusSnr13.switch(
					0,{},
					1, {IFSeqSusSnr.st13(1);},
					2, {IFSeqSusSnr.st13(2);},
					3, {IFSeqSusSnr.st13(3);},
					4, {IFSeqSusSnr.st13(4);},
					5, {IFSeqSusSnr.st13(5);}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqSnrBut14.free;
		~ifSeqSnrBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr14 = ~cntSeqSusSnr14 + 1;
				~cntSeqSusSnr14.switch(
					0,{},
					1, {IFSeqSusSnr.st14(1);},
					2, {IFSeqSusSnr.st14(2);},
					3, {IFSeqSusSnr.st14(3);},
					4, {IFSeqSusSnr.st14(4);},
					5, {IFSeqSusSnr.st14(5);}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqSnrBut15.free;
		~ifSeqSnrBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr15 = ~cntSeqSusSnr15 + 1;
				~cntSeqSusSnr15.switch(
					0,{},
					1, {IFSeqSusSnr.st15(1);},
					2, {IFSeqSusSnr.st15(2);},
					3, {IFSeqSusSnr.st15(3);},
					4, {IFSeqSusSnr.st15(4);},
					5, {IFSeqSusSnr.st15(5);}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqSnrBut16.free;
		~ifSeqSnrBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSusSnr16 = ~cntSeqSusSnr16 + 1;
				~cntSeqSusSnr16.switch(
					0,{},
					1, {IFSeqSusSnr.st16(1);},
					2, {IFSeqSusSnr.st16(2);},
					3, {IFSeqSusSnr.st16(3);},
					4, {IFSeqSusSnr.st16(4);},
					5, {IFSeqSusSnr.st16(5);}
				)}
			);
			},
			'/ifSeq/2/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr01', '1');
		}
		{ i == 2 }  {
			~seqSusSnr01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr01', '2');
		}
		{ i == 3 }  {
			~seqSusSnr01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr01', '3');
		}
		{ i == 4 }  {
			~seqSusSnr01.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr01', '4');
		}
		{ i == 5 }  {
			~seqSusSnr01.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr01', '5');
			~cntSeqSusSnr01=0;
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr02', '1');
		}
		{ i == 2 }  {
			~seqSusSnr02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr02', '2');
		}
		{ i == 3 }  {
			~seqSusSnr02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr02', '3');
		}
		{ i == 4 }  {
			~seqSusSnr02.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr02', '4');
		}
		{ i == 5 }  {
			~seqSusSnr02.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr02', '5');
			~cntSeqSusSnr02=0;
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr03', '1');
		}
		{ i == 2 }  {
			~seqSusSnr03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr03', '2');
		}
		{ i == 3 }  {
			~seqSusSnr03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr03', '3');
		}
		{ i == 4 }  {
			~seqSusSnr03.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr03', '4');
		}
		{ i == 5 }  {
			~seqSusSnr03.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr03', '5');
			~cntSeqSusSnr03=0;
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr04', '1');
		}
		{ i == 2 }  {
			~seqSusSnr04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr04', '2');
		}
		{ i == 3 }  {
			~seqSusSnr04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr04', '3');
		}
		{ i == 4 }  {
			~seqSusSnr04.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr04', '4');
		}
		{ i == 5 }  {
			~seqSusSnr04.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr04', '5');
			~cntSeqSusSnr04=0;
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr05', '1');
		}
		{ i == 2 }  {
			~seqSusSnr05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr05', '2');
		}
		{ i == 3 }  {
			~seqSusSnr05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr05', '3');
		}
		{ i == 4 }  {
			~seqSusSnr05.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr05', '4');
		}
		{ i == 5 }  {
			~seqSusSnr05.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr05', '5');
			~cntSeqSusSnr05=0;
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr06', '1');
		}
		{ i == 2 }  {
			~seqSusSnr06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr06', '2');
		}
		{ i == 3 }  {
			~seqSusSnr06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr06', '3');
		}
		{ i == 4 }  {
			~seqSusSnr06.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr06', '4');
		}
		{ i == 5 }  {
			~seqSusSnr06.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr06', '5');
			~cntSeqSusSnr06=0;
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr07', '1');
		}
		{ i == 2 }  {
			~seqSusSnr07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr07', '2');
		}
		{ i == 3 }  {
			~seqSusSnr07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr07', '3');
		}
		{ i == 4 }  {
			~seqSusSnr07.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr07', '4');
		}
		{ i == 5 }  {
			~seqSusSnr07.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr07', '5');
			~cntSeqSusSnr07=0;
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr08', '1');
		}
		{ i == 2 }  {
			~seqSusSnr08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr08', '2');
		}
		{ i == 3 }  {
			~seqSusSnr08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr08', '3');
		}
		{ i == 4 }  {
			~seqSusSnr08.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr08', '4');
		}
		{ i == 5 }  {
			~seqSusSnr08.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr08', '5');
			~cntSeqSusSnr08=0;
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr09', '1');
		}
		{ i == 2 }  {
			~seqSusSnr09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr09', '2');
		}
		{ i == 3 }  {
			~seqSusSnr09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr09', '3');
		}
		{ i == 4 }  {
			~seqSusSnr09.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr09', '4');
		}
		{ i == 5 }  {
			~seqSusSnr09.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr09', '5');
			~cntSeqSusSnr09=0;
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr10', '1');
		}
		{ i == 2 }  {
			~seqSusSnr10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr10', '2');
		}
		{ i == 3 }  {
			~seqSusSnr10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr10', '3');
		}
		{ i == 4 }  {
			~seqSusSnr10.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr10', '4');
		}
		{ i == 5 }  {
			~seqSusSnr10.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr10', '5');
			~cntSeqSusSnr10=0;
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr11', '1');
		}
		{ i == 2 }  {
			~seqSusSnr11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr11', '2');
		}
		{ i == 3 }  {
			~seqSusSnr11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr11', '3');
		}
		{ i == 4 }  {
			~seqSusSnr11.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr11', '4');
		}
		{ i == 5 }  {
			~seqSusSnr11.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr11', '5');
			~cntSeqSusSnr11=0;
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr12', '1');
		}
		{ i == 2 }  {
			~seqSusSnr12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr12', '2');
		}
		{ i == 3 }  {
			~seqSusSnr12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr12', '3');
		}
		{ i == 4 }  {
			~seqSusSnr12.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr12', '4');
		}
		{ i == 5 }  {
			~seqSusSnr12.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr12', '5');
			~cntSeqSusSnr12=0;
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr13', '1');
		}
		{ i == 2 }  {
			~seqSusSnr13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr13', '2');
		}
		{ i == 3 }  {
			~seqSusSnr13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr13', '3');
		}
		{ i == 4 }  {
			~seqSusSnr13.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr13', '4');
		}
		{ i == 5 }  {
			~seqSusSnr13.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr13', '5');
			~cntSeqSusSnr13=0;
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr14', '1');
		}
		{ i == 2 }  {
			~seqSusSnr14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr14', '2');
		}
		{ i == 3 }  {
			~seqSusSnr14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr14', '3');
		}
		{ i == 4 }  {
			~seqSusSnr14.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr14', '4');
		}
		{ i == 5 }  {
			~seqSusSnr14.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr14', '5');
			~cntSeqSusSnr14=0;
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr15', '1');
		}
		{ i == 2 }  {
			~seqSusSnr15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr15', '2');
		}
		{ i == 3 }  {
			~seqSusSnr15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr15', '3');
		}
		{ i == 4 }  {
			~seqSusSnr15.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr15', '4');
		}
		{ i == 5 }  {
			~seqSusSnr15.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr15', '5');
			~cntSeqSusSnr15=0;
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqSusSnr16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr16', '1');
		}
		{ i == 2 }  {
			~seqSusSnr16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shSusSnr16', '2');
		}
		{ i == 3 }  {
			~seqSusSnr16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shSusSnr16', '3');
		}
		{ i == 4 }  {
			~seqSusSnr16.source = Pseq([1.2], 1);
			~tOSCAdrr.sendMsg('shSusSnr16', '4');
		}
		{ i == 5 }  {
			~seqSusSnr16.source = Pseq([1.5], 1);
			~tOSCAdrr.sendMsg('shSusSnr16', '5');
			~cntSeqSusSnr16=0;
		}
	}
	*stGrp {|i|
		IFSeqSusSnr.st01(i); IFSeqSusSnr.st02(i); IFSeqSusSnr.st03(i); IFSeqSusSnr.st04(i);
		IFSeqSusSnr.st05(i); IFSeqSusSnr.st06(i); IFSeqSusSnr.st07(i); IFSeqSusSnr.st08(i);
		IFSeqSusSnr.st09(i); IFSeqSusSnr.st10(i); IFSeqSusSnr.st11(i); IFSeqSusSnr.st12(i);
		IFSeqSusSnr.st13(i); IFSeqSusSnr.st14(i); IFSeqSusSnr.st15(i); IFSeqSusSnr.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqSusSnr.st01(s01); IFSeqSusSnr.st02(s02); IFSeqSusSnr.st03(s03); IFSeqSusSnr.st04(s04);
		IFSeqSusSnr.st05(s05); IFSeqSusSnr.st06(s06); IFSeqSusSnr.st07(s07); IFSeqSusSnr.st08(s08);
		IFSeqSusSnr.st09(s09); IFSeqSusSnr.st10(s10); IFSeqSusSnr.st11(s11); IFSeqSusSnr.st12(s12);
		IFSeqSusSnr.st13(s13); IFSeqSusSnr.st14(s14); IFSeqSusSnr.st15(s15); IFSeqSusSnr.st16(s16);
	}
}