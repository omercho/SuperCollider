IFSeqVelSnr {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVelSnr01 = PatternProxy( Pseq([1], 1));
		~seqVelSnr02 = PatternProxy( Pseq([1], 1));
		~seqVelSnr03 = PatternProxy( Pseq([1], 1));
		~seqVelSnr04 = PatternProxy( Pseq([1], 1));
		~seqVelSnr05 = PatternProxy( Pseq([1], 1));
		~seqVelSnr06 = PatternProxy( Pseq([1], 1));
		~seqVelSnr07 = PatternProxy( Pseq([1], 1));
		~seqVelSnr08 = PatternProxy( Pseq([1], 1));

		~seqVelSnr09 = PatternProxy( Pseq([1], 1));
		~seqVelSnr10 = PatternProxy( Pseq([1], 1));
		~seqVelSnr11 = PatternProxy( Pseq([1], 1));
		~seqVelSnr12 = PatternProxy( Pseq([1], 1));
		~seqVelSnr13 = PatternProxy( Pseq([1], 1));
		~seqVelSnr14 = PatternProxy( Pseq([1], 1));
		~seqVelSnr15 = PatternProxy( Pseq([1], 1));
		~seqVelSnr16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqVelUpSnr01=0;
		~cntSeqVelRandSnr01=0;

		~cntSeqVelSnr01=0;
		~cntSeqVelSnr02=0;
		~cntSeqVelSnr03=0;
		~cntSeqVelSnr04=0;
		~cntSeqVelSnr05=0;
		~cntSeqVelSnr06=0;
		~cntSeqVelSnr07=0;
		~cntSeqVelSnr08=0;

		~cntSeqVelSnr09=0;
		~cntSeqVelSnr10=0;
		~cntSeqVelSnr11=0;
		~cntSeqVelSnr12=0;
		~cntSeqVelSnr13=0;
		~cntSeqVelSnr14=0;
		~cntSeqVelSnr15=0;
		~cntSeqVelSnr16=0;
	}
	*freeOn {
		~seqFreeSnrBut.free;
		~seqFreeSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVelSnr.stGrp(1);
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
				~cntSeqVelUpSnr01 = ~cntSeqVelUpSnr01 + 1;
				~cntSeqVelUpSnr01.switch(
					0,{},
					1,{IFSeqVelSnr.stGrp(1);},
					2,{IFSeqVelSnr.stGrp(2);},
					3,{IFSeqVelSnr.stGrp(3);
						~cntSeqVelUpSnr01=0;
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
				~cntSeqVelRandSnr01 = ~cntSeqVelRandSnr01 + 1;
				~cntSeqVelRandSnr01.switch(
					0,{},
					1,{
						IFSeqVelSnr.st01([1,2,3].choose);
						IFSeqVelSnr.st02([1,2,3].choose);
						IFSeqVelSnr.st03([1,2,3].choose);
						IFSeqVelSnr.st04([1,2,3].choose);
						IFSeqVelSnr.st05([1,2,3].choose);
						IFSeqVelSnr.st06([1,2,3].choose);
						IFSeqVelSnr.st07([1,2,3].choose);
						IFSeqVelSnr.st08([1,2,3].choose);

						IFSeqVelSnr.st09([1,2,3].choose);
						IFSeqVelSnr.st10([1,2,3].choose);
						IFSeqVelSnr.st11([1,2,3].choose);
						IFSeqVelSnr.st12([1,2,3].choose);
						IFSeqVelSnr.st13([1,2,3].choose);
						IFSeqVelSnr.st14([1,2,3].choose);
						IFSeqVelSnr.st15([1,2,3].choose);
						IFSeqVelSnr.st16([1,2,3].choose);
						~cntSeqVelRandSnr01=0;
					}
				)}
			);
			},
			'/seqRandSnr'
		);
	}


	*on { // Shift Velocity

		IFSeqVelSnr.randOn;
		IFSeqVelSnr.upOn;
		IFSeqVelSnr.freeOn;

		~ifSeqSnrBut01.free;
		~ifSeqSnrBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr01 = ~cntSeqVelSnr01 + 1;
				~cntSeqVelSnr01.switch(
					0,{},
					1, {IFSeqVelSnr.st01(1);},
					2, {IFSeqVelSnr.st01(2);},
					3, {IFSeqVelSnr.st01(3);}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqSnrBut02.free;
		~ifSeqSnrBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr02 = ~cntSeqVelSnr02 + 1;
				~cntSeqVelSnr02.switch(
					0,{},
					1, {IFSeqVelSnr.st02(1);},
					2, {IFSeqVelSnr.st02(2);},
					3, {IFSeqVelSnr.st02(3);}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqSnrBut03.free;
		~ifSeqSnrBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr03 = ~cntSeqVelSnr03 + 1;
				~cntSeqVelSnr03.switch(
					0,{},
					1, {IFSeqVelSnr.st03(1);},
					2, {IFSeqVelSnr.st03(2);},
					3, {IFSeqVelSnr.st03(3);}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqSnrBut04.free;
		~ifSeqSnrBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr04 = ~cntSeqVelSnr04 + 1;
				~cntSeqVelSnr04.switch(
					0,{},
					1, {IFSeqVelSnr.st04(1);},
					2, {IFSeqVelSnr.st04(2);},
					3, {IFSeqVelSnr.st04(3);}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqSnrBut05.free;
		~ifSeqSnrBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr05 = ~cntSeqVelSnr05 + 1;
				~cntSeqVelSnr05.switch(
					0,{},
					1, {IFSeqVelSnr.st05(1);},
					2, {IFSeqVelSnr.st05(2);},
					3, {IFSeqVelSnr.st05(3);}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqSnrBut06.free;
		~ifSeqSnrBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr06 = ~cntSeqVelSnr06 + 1;
				~cntSeqVelSnr06.switch(
					0,{},
					1, {IFSeqVelSnr.st06(1);},
					2, {IFSeqVelSnr.st06(2);},
					3, {IFSeqVelSnr.st06(3);}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqSnrBut07.free;
		~ifSeqSnrBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr07 = ~cntSeqVelSnr07 + 1;
				~cntSeqVelSnr07.switch(
					0,{},
					1, {IFSeqVelSnr.st07(1);},
					2, {IFSeqVelSnr.st07(2);},
					3, {IFSeqVelSnr.st07(3);}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqSnrBut08.free;
		~ifSeqSnrBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr08 = ~cntSeqVelSnr08 + 1;
				~cntSeqVelSnr08.switch(
					0,{},
					1, {IFSeqVelSnr.st08(1);},
					2, {IFSeqVelSnr.st08(2);},
					3, {IFSeqVelSnr.st08(3);}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqSnrBut09.free;
		~ifSeqSnrBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr09 = ~cntSeqVelSnr09 + 1;
				~cntSeqVelSnr09.switch(
					0,{},
					1, {IFSeqVelSnr.st09(1);},
					2, {IFSeqVelSnr.st09(2);},
					3, {IFSeqVelSnr.st09(3);}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqSnrBut10.free;
		~ifSeqSnrBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr10 = ~cntSeqVelSnr10 + 1;
				~cntSeqVelSnr10.switch(
					0,{},
					1, {IFSeqVelSnr.st10(1);},
					2, {IFSeqVelSnr.st10(2);},
					3, {IFSeqVelSnr.st10(3);}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqSnrBut11.free;
		~ifSeqSnrBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr11 = ~cntSeqVelSnr11 + 1;
				~cntSeqVelSnr11.switch(
					0,{},
					1, {IFSeqVelSnr.st11(1);},
					2, {IFSeqVelSnr.st11(2);},
					3, {IFSeqVelSnr.st11(3);}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqSnrBut12.free;
		~ifSeqSnrBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr12 = ~cntSeqVelSnr12 + 1;
				~cntSeqVelSnr12.switch(
					0,{},
					1, {IFSeqVelSnr.st12(1);},
					2, {IFSeqVelSnr.st12(2);},
					3, {IFSeqVelSnr.st12(3);}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqSnrBut13.free;
		~ifSeqSnrBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr13 = ~cntSeqVelSnr13 + 1;
				~cntSeqVelSnr13.switch(
					0,{},
					1, {IFSeqVelSnr.st13(1);},
					2, {IFSeqVelSnr.st13(2);},
					3, {IFSeqVelSnr.st13(3);}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqSnrBut14.free;
		~ifSeqSnrBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr14 = ~cntSeqVelSnr14 + 1;
				~cntSeqVelSnr14.switch(
					0,{},
					1, {IFSeqVelSnr.st14(1);},
					2, {IFSeqVelSnr.st14(2);},
					3, {IFSeqVelSnr.st14(3);}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqSnrBut15.free;
		~ifSeqSnrBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr15 = ~cntSeqVelSnr15 + 1;
				~cntSeqVelSnr15.switch(
					0,{},
					1, {IFSeqVelSnr.st15(1);},
					2, {IFSeqVelSnr.st15(2);},
					3, {IFSeqVelSnr.st15(3);}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqSnrBut16.free;
		~ifSeqSnrBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr16 = ~cntSeqVelSnr16 + 1;
				~cntSeqVelSnr16.switch(
					0,{},
					1, {IFSeqVelSnr.st16(1);},
					2, {IFSeqVelSnr.st16(2);},
					3, {IFSeqVelSnr.st16(3);}
				)}
			);
			},
			'/ifSeq/2/16'
		);


	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr01', '1');
		}
		{ i == 2 }  {
			~seqVelSnr01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr01', '2');
		}
		{ i == 3 }  {
			~seqVelSnr01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr01', '3');
		}

	}

	*st02 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr02', '1');
		}
		{ i == 2 }  {
			~seqVelSnr02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr02', '2');
		}
		{ i == 3 }  {
			~seqVelSnr02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr02', '3');
		}

	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr03', '1');
		}
		{ i == 2 }  {
			~seqVelSnr03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr03', '2');
		}
		{ i == 3 }  {
			~seqVelSnr03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr03', '3');
		}

	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr04', '1');
		}
		{ i == 2 }  {
			~seqVelSnr04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr04', '2');
		}
		{ i == 3 }  {
			~seqVelSnr04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr04', '3');
		}

	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr05', '1');
		}
		{ i == 2 }  {
			~seqVelSnr05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr05', '2');
		}
		{ i == 3 }  {
			~seqVelSnr05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr05', '3');
		}

	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr06', '1');
		}
		{ i == 2 }  {
			~seqVelSnr06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr06', '2');
		}
		{ i == 3 }  {
			~seqVelSnr06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr06', '3');
		}

	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr07', '1');
		}
		{ i == 2 }  {
			~seqVelSnr07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr07', '2');
		}
		{ i == 3 }  {
			~seqVelSnr07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr07', '3');
		}

	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr08', '1');
		}
		{ i == 2 }  {
			~seqVelSnr08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr08', '2');
		}
		{ i == 3 }  {
			~seqVelSnr08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr08', '3');
		}

	}
	*st09 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr09', '1');
		}
		{ i == 2 }  {
			~seqVelSnr09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr09', '2');
		}
		{ i == 3 }  {
			~seqVelSnr09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr09', '3');
		}

	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr10', '1');
		}
		{ i == 2 }  {
			~seqVelSnr10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr10', '2');
		}
		{ i == 3 }  {
			~seqVelSnr10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr10', '3');
		}

	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr11', '1');
		}
		{ i == 2 }  {
			~seqVelSnr11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr11', '2');
		}
		{ i == 3 }  {
			~seqVelSnr11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr11', '3');
		}

	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr12', '1');
		}
		{ i == 2 }  {
			~seqVelSnr12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr12', '2');
		}
		{ i == 3 }  {
			~seqVelSnr12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr12', '3');
		}

	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr13', '1');
		}
		{ i == 2 }  {
			~seqVelSnr13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr13', '2');
		}
		{ i == 3 }  {
			~seqVelSnr13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr13', '3');
		}

	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr14', '1');
		}
		{ i == 2 }  {
			~seqVelSnr14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr14', '2');
		}
		{ i == 3 }  {
			~seqVelSnr14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr14', '3');
		}

	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr15', '1');
		}
		{ i == 2 }  {
			~seqVelSnr15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr15', '2');
		}
		{ i == 3 }  {
			~seqVelSnr15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr15', '3');
		}

	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr16', '1');
		}
		{ i == 2 }  {
			~seqVelSnr16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr16', '2');
		}
		{ i == 3 }  {
			~seqVelSnr16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr16', '3');
		}

	}
	*stGrp {|i|
		IFSeqVelSnr.st01(i); IFSeqVelSnr.st02(i); IFSeqVelSnr.st03(i); IFSeqVelSnr.st04(i);
		IFSeqVelSnr.st05(i); IFSeqVelSnr.st06(i); IFSeqVelSnr.st07(i); IFSeqVelSnr.st08(i);
		IFSeqVelSnr.st09(i); IFSeqVelSnr.st10(i); IFSeqVelSnr.st11(i); IFSeqVelSnr.st12(i);
		IFSeqVelSnr.st13(i); IFSeqVelSnr.st14(i); IFSeqVelSnr.st15(i); IFSeqVelSnr.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqVelSnr.st01(s01); IFSeqVelSnr.st02(s02); IFSeqVelSnr.st03(s03); IFSeqVelSnr.st04(s04);
		IFSeqVelSnr.st05(s05); IFSeqVelSnr.st06(s06); IFSeqVelSnr.st07(s07); IFSeqVelSnr.st08(s08);
		IFSeqVelSnr.st09(s09); IFSeqVelSnr.st10(s10); IFSeqVelSnr.st11(s11); IFSeqVelSnr.st12(s12);
		IFSeqVelSnr.st13(s13); IFSeqVelSnr.st14(s14); IFSeqVelSnr.st15(s15); IFSeqVelSnr.st16(s16);
	}
}