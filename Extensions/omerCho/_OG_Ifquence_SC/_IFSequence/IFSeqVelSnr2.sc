IFSeqVelSnr2 {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVelSnr2_01 = PatternProxy( Pseq([1], 1));
		~seqVelSnr2_02 = PatternProxy( Pseq([1], 1));
		~seqVelSnr2_03 = PatternProxy( Pseq([1], 1));
		~seqVelSnr2_04 = PatternProxy( Pseq([1], 1));
		~seqVelSnr2_05 = PatternProxy( Pseq([1], 1));
		~seqVelSnr2_06 = PatternProxy( Pseq([1], 1));
		~seqVelSnr2_07 = PatternProxy( Pseq([1], 1));
		~seqVelSnr2_08 = PatternProxy( Pseq([1], 1));

		~seqVelSnr2_09 = PatternProxy( Pseq([1], 1));
		~seqVelSnr2_10 = PatternProxy( Pseq([1], 1));
		~seqVelSnr2_11 = PatternProxy( Pseq([1], 1));
		~seqVelSnr2_12 = PatternProxy( Pseq([1], 1));
		~seqVelSnr2_13 = PatternProxy( Pseq([1], 1));
		~seqVelSnr2_14 = PatternProxy( Pseq([1], 1));
		~seqVelSnr2_15 = PatternProxy( Pseq([1], 1));
		~seqVelSnr2_16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqVelUpSnr2_01=0;
		~cntSeqVelRandSnr2_01=0;

		~cntSeqVelSnr2_01=0;
		~cntSeqVelSnr2_02=0;
		~cntSeqVelSnr2_03=0;
		~cntSeqVelSnr2_04=0;
		~cntSeqVelSnr2_05=0;
		~cntSeqVelSnr2_06=0;
		~cntSeqVelSnr2_07=0;
		~cntSeqVelSnr2_08=0;

		~cntSeqVelSnr2_09=0;
		~cntSeqVelSnr2_10=0;
		~cntSeqVelSnr2_11=0;
		~cntSeqVelSnr2_12=0;
		~cntSeqVelSnr2_13=0;
		~cntSeqVelSnr2_14=0;
		~cntSeqVelSnr2_15=0;
		~cntSeqVelSnr2_16=0;
	}
	*freeOn {
		~seqFreeSnr2But.free;
		~seqFreeSnr2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVelSnr2.stGrp(1);
				});
			},
			'/seqFreeSnr'
		);
	}
	*upOn {
		~ifSeqUpSnr2But.free;
		~ifSeqUpSnr2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelUpSnr2_01 = ~cntSeqVelUpSnr2_01 + 1;
				~cntSeqVelUpSnr2_01.switch(
					0,{},
					1,{IFSeqVelSnr2.stGrp(1);},
					2,{IFSeqVelSnr2.stGrp(2);},
					3,{IFSeqVelSnr2.stGrp(3);
						~cntSeqVelUpSnr2_01=0;
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
				~cntSeqVelRandSnr2_01 = ~cntSeqVelRandSnr2_01 + 1;
				~cntSeqVelRandSnr2_01.switch(
					0,{},
					1,{
						IFSeqVelSnr2.st01([1,2,3].choose);
						IFSeqVelSnr2.st02([1,2,3].choose);
						IFSeqVelSnr2.st03([1,2,3].choose);
						IFSeqVelSnr2.st04([1,2,3].choose);
						IFSeqVelSnr2.st05([1,2,3].choose);
						IFSeqVelSnr2.st06([1,2,3].choose);
						IFSeqVelSnr2.st07([1,2,3].choose);
						IFSeqVelSnr2.st08([1,2,3].choose);

						IFSeqVelSnr2.st09([1,2,3].choose);
						IFSeqVelSnr2.st10([1,2,3].choose);
						IFSeqVelSnr2.st11([1,2,3].choose);
						IFSeqVelSnr2.st12([1,2,3].choose);
						IFSeqVelSnr2.st13([1,2,3].choose);
						IFSeqVelSnr2.st14([1,2,3].choose);
						IFSeqVelSnr2.st15([1,2,3].choose);
						IFSeqVelSnr2.st16([1,2,3].choose);
						~cntSeqVelRandSnr2_01=0;
					}
				)}
			);
			},
			'/seqRandSnr'
		);
	}


	*on { // Shift Velocity

		IFSeqVelSnr2.randOn;
		IFSeqVelSnr2.upOn;
		IFSeqVelSnr2.freeOn;

		~ifSeqSnrBut01.free;
		~ifSeqSnrBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_01 = ~cntSeqVelSnr2_01 + 1;
				~cntSeqVelSnr2_01.switch(
					0,{},
					1, {IFSeqVelSnr2.st01(1);},
					2, {IFSeqVelSnr2.st01(2);},
					3, {IFSeqVelSnr2.st01(3);}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqSnrBut02.free;
		~ifSeqSnrBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_02 = ~cntSeqVelSnr2_02 + 1;
				~cntSeqVelSnr2_02.switch(
					0,{},
					1, {IFSeqVelSnr2.st02(1);},
					2, {IFSeqVelSnr2.st02(2);},
					3, {IFSeqVelSnr2.st02(3);}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqSnrBut03.free;
		~ifSeqSnrBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_03 = ~cntSeqVelSnr2_03 + 1;
				~cntSeqVelSnr2_03.switch(
					0,{},
					1, {IFSeqVelSnr2.st03(1);},
					2, {IFSeqVelSnr2.st03(2);},
					3, {IFSeqVelSnr2.st03(3);}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqSnrBut04.free;
		~ifSeqSnrBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_04 = ~cntSeqVelSnr2_04 + 1;
				~cntSeqVelSnr2_04.switch(
					0,{},
					1, {IFSeqVelSnr2.st04(1);},
					2, {IFSeqVelSnr2.st04(2);},
					3, {IFSeqVelSnr2.st04(3);}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqSnrBut05.free;
		~ifSeqSnrBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_05 = ~cntSeqVelSnr2_05 + 1;
				~cntSeqVelSnr2_05.switch(
					0,{},
					1, {IFSeqVelSnr2.st05(1);},
					2, {IFSeqVelSnr2.st05(2);},
					3, {IFSeqVelSnr2.st05(3);}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqSnrBut06.free;
		~ifSeqSnrBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_06 = ~cntSeqVelSnr2_06 + 1;
				~cntSeqVelSnr2_06.switch(
					0,{},
					1, {IFSeqVelSnr2.st06(1);},
					2, {IFSeqVelSnr2.st06(2);},
					3, {IFSeqVelSnr2.st06(3);}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqSnrBut07.free;
		~ifSeqSnrBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_07 = ~cntSeqVelSnr2_07 + 1;
				~cntSeqVelSnr2_07.switch(
					0,{},
					1, {IFSeqVelSnr2.st07(1);},
					2, {IFSeqVelSnr2.st07(2);},
					3, {IFSeqVelSnr2.st07(3);}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqSnrBut08.free;
		~ifSeqSnrBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_08 = ~cntSeqVelSnr2_08 + 1;
				~cntSeqVelSnr2_08.switch(
					0,{},
					1, {IFSeqVelSnr2.st08(1);},
					2, {IFSeqVelSnr2.st08(2);},
					3, {IFSeqVelSnr2.st08(3);}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqSnrBut09.free;
		~ifSeqSnrBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_09 = ~cntSeqVelSnr2_09 + 1;
				~cntSeqVelSnr2_09.switch(
					0,{},
					1, {IFSeqVelSnr2.st09(1);},
					2, {IFSeqVelSnr2.st09(2);},
					3, {IFSeqVelSnr2.st09(3);}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqSnrBut10.free;
		~ifSeqSnrBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_10 = ~cntSeqVelSnr2_10 + 1;
				~cntSeqVelSnr2_10.switch(
					0,{},
					1, {IFSeqVelSnr2.st10(1);},
					2, {IFSeqVelSnr2.st10(2);},
					3, {IFSeqVelSnr2.st10(3);}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqSnrBut11.free;
		~ifSeqSnrBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_11 = ~cntSeqVelSnr2_11 + 1;
				~cntSeqVelSnr2_11.switch(
					0,{},
					1, {IFSeqVelSnr2.st11(1);},
					2, {IFSeqVelSnr2.st11(2);},
					3, {IFSeqVelSnr2.st11(3);}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqSnrBut12.free;
		~ifSeqSnrBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_12 = ~cntSeqVelSnr2_12 + 1;
				~cntSeqVelSnr2_12.switch(
					0,{},
					1, {IFSeqVelSnr2.st12(1);},
					2, {IFSeqVelSnr2.st12(2);},
					3, {IFSeqVelSnr2.st12(3);}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqSnrBut13.free;
		~ifSeqSnrBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_13 = ~cntSeqVelSnr2_13 + 1;
				~cntSeqVelSnr2_13.switch(
					0,{},
					1, {IFSeqVelSnr2.st13(1);},
					2, {IFSeqVelSnr2.st13(2);},
					3, {IFSeqVelSnr2.st13(3);}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqSnrBut14.free;
		~ifSeqSnrBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_14 = ~cntSeqVelSnr2_14 + 1;
				~cntSeqVelSnr2_14.switch(
					0,{},
					1, {IFSeqVelSnr2.st14(1);},
					2, {IFSeqVelSnr2.st14(2);},
					3, {IFSeqVelSnr2.st14(3);}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqSnrBut15.free;
		~ifSeqSnrBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_15 = ~cntSeqVelSnr2_15 + 1;
				~cntSeqVelSnr2_15.switch(
					0,{},
					1, {IFSeqVelSnr2.st15(1);},
					2, {IFSeqVelSnr2.st15(2);},
					3, {IFSeqVelSnr2.st15(3);}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqSnrBut16.free;
		~ifSeqSnrBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSnr2_16 = ~cntSeqVelSnr2_16 + 1;
				~cntSeqVelSnr2_16.switch(
					0,{},
					1, {IFSeqVelSnr2.st16(1);},
					2, {IFSeqVelSnr2.st16(2);},
					3, {IFSeqVelSnr2.st16(3);}
				)}
			);
			},
			'/ifSeq/2/16'
		);


	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr01', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr01', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr01', '3');
		}

	}

	*st02 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr02', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr02', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr02', '3');
		}

	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr03', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr03', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr03', '3');
		}

	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr04', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr04', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr04', '3');
		}

	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr05', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr05', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr05', '3');
		}

	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr06', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr06', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr06', '3');
		}

	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr07', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr07', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr07', '3');
		}

	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr08', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr08', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr08', '3');
		}

	}
	*st09 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr09', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr09', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr09', '3');
		}

	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr10', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr10', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr10', '3');
		}

	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr11', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr11', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr11', '3');
		}

	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr12', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr12', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr12', '3');
		}

	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr13', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr13', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr13', '3');
		}

	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr14', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr14', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr14', '3');
		}

	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr15', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr15', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr15', '3');
		}

	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqVelSnr2_16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSnr16', '1');
		}
		{ i == 2 }  {
			~seqVelSnr2_16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSnr16', '2');
		}
		{ i == 3 }  {
			~seqVelSnr2_16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSnr16', '3');
		}

	}
	*stGrp {|i|
		IFSeqVelSnr2.st01(i); IFSeqVelSnr2.st02(i); IFSeqVelSnr2.st03(i); IFSeqVelSnr2.st04(i);
		IFSeqVelSnr2.st05(i); IFSeqVelSnr2.st06(i); IFSeqVelSnr2.st07(i); IFSeqVelSnr2.st08(i);
		IFSeqVelSnr2.st09(i); IFSeqVelSnr2.st10(i); IFSeqVelSnr2.st11(i); IFSeqVelSnr2.st12(i);
		IFSeqVelSnr2.st13(i); IFSeqVelSnr2.st14(i); IFSeqVelSnr2.st15(i); IFSeqVelSnr2.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqVelSnr2.st01(s01); IFSeqVelSnr2.st02(s02); IFSeqVelSnr2.st03(s03); IFSeqVelSnr2.st04(s04);
		IFSeqVelSnr2.st05(s05); IFSeqVelSnr2.st06(s06); IFSeqVelSnr2.st07(s07); IFSeqVelSnr2.st08(s08);
		IFSeqVelSnr2.st09(s09); IFSeqVelSnr2.st10(s10); IFSeqVelSnr2.st11(s11); IFSeqVelSnr2.st12(s12);
		IFSeqVelSnr2.st13(s13); IFSeqVelSnr2.st14(s14); IFSeqVelSnr2.st15(s15); IFSeqVelSnr2.st16(s16);
	}
}