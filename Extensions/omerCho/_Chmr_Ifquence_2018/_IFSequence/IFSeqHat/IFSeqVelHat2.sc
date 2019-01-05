IFSeqVelHat2 {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVelHat2_01 = PatternProxy( Pseq([1], 1));
		~seqVelHat2_02 = PatternProxy( Pseq([1], 1));
		~seqVelHat2_03 = PatternProxy( Pseq([1], 1));
		~seqVelHat2_04 = PatternProxy( Pseq([1], 1));
		~seqVelHat2_05 = PatternProxy( Pseq([1], 1));
		~seqVelHat2_06 = PatternProxy( Pseq([1], 1));
		~seqVelHat2_07 = PatternProxy( Pseq([1], 1));
		~seqVelHat2_08 = PatternProxy( Pseq([1], 1));

		~seqVelHat2_09 = PatternProxy( Pseq([1], 1));
		~seqVelHat2_10 = PatternProxy( Pseq([1], 1));
		~seqVelHat2_11 = PatternProxy( Pseq([1], 1));
		~seqVelHat2_12 = PatternProxy( Pseq([1], 1));
		~seqVelHat2_13 = PatternProxy( Pseq([1], 1));
		~seqVelHat2_14 = PatternProxy( Pseq([1], 1));
		~seqVelHat2_15 = PatternProxy( Pseq([1], 1));
		~seqVelHat2_16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqVelUpHat2_01=0;
		~cntSeqVelRandHat2_01=0;

		~cntSeqVelHat2_01=0;
		~cntSeqVelHat2_02=0;
		~cntSeqVelHat2_03=0;
		~cntSeqVelHat2_04=0;
		~cntSeqVelHat2_05=0;
		~cntSeqVelHat2_06=0;
		~cntSeqVelHat2_07=0;
		~cntSeqVelHat2_08=0;

		~cntSeqVelHat2_09=0;
		~cntSeqVelHat2_10=0;
		~cntSeqVelHat2_11=0;
		~cntSeqVelHat2_12=0;
		~cntSeqVelHat2_13=0;
		~cntSeqVelHat2_14=0;
		~cntSeqVelHat2_15=0;
		~cntSeqVelHat2_16=0;
	}
	*freeOn {
		~seqFreeHat2But.free;
		~seqFreeHat2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVelHat2.stGrp(1);
				});
			},
			'/seqFreeHat'
		);
	}
	*upOn {
		~ifSeqUpHat2But.free;
		~ifSeqUpHat2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelUpHat2_01 = ~cntSeqVelUpHat2_01 + 1;
				~cntSeqVelUpHat2_01.switch(
					0,{},
					1,{IFSeqVelHat2.stGrp(1);},
					2,{IFSeqVelHat2.stGrp(2);},
					3,{IFSeqVelHat2.stGrp(3);
						~cntSeqVelUpHat2_01=0;
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
				~cntSeqVelRandHat2_01 = ~cntSeqVelRandHat2_01 + 1;
				~cntSeqVelRandHat2_01.switch(
					0,{},
					1,{
						IFSeqVelHat2.st01([1,2,3].choose);
						IFSeqVelHat2.st02([1,2,3].choose);
						IFSeqVelHat2.st03([1,2,3].choose);
						IFSeqVelHat2.st04([1,2,3].choose);
						IFSeqVelHat2.st05([1,2,3].choose);
						IFSeqVelHat2.st06([1,2,3].choose);
						IFSeqVelHat2.st07([1,2,3].choose);
						IFSeqVelHat2.st08([1,2,3].choose);

						IFSeqVelHat2.st09([1,2,3].choose);
						IFSeqVelHat2.st10([1,2,3].choose);
						IFSeqVelHat2.st11([1,2,3].choose);
						IFSeqVelHat2.st12([1,2,3].choose);
						IFSeqVelHat2.st13([1,2,3].choose);
						IFSeqVelHat2.st14([1,2,3].choose);
						IFSeqVelHat2.st15([1,2,3].choose);
						IFSeqVelHat2.st16([1,2,3].choose);
						~cntSeqVelRandHat2_01=0;
					}
				)}
			);
			},
			'/seqRandHat'
		);
	}


	*on { // Shift Velocity

		IFSeqVelHat2.randOn;
		IFSeqVelHat2.upOn;
		IFSeqVelHat2.freeOn;

		~ifSeqHatBut01.free;
		~ifSeqHatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_01 = ~cntSeqVelHat2_01 + 1;
				~cntSeqVelHat2_01.switch(
					0,{},
					1, {IFSeqVelHat2.st01(1);},
					2, {IFSeqVelHat2.st01(2);},
					3, {IFSeqVelHat2.st01(3);}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqHatBut02.free;
		~ifSeqHatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_02 = ~cntSeqVelHat2_02 + 1;
				~cntSeqVelHat2_02.switch(
					0,{},
					1, {IFSeqVelHat2.st02(1);},
					2, {IFSeqVelHat2.st02(2);},
					3, {IFSeqVelHat2.st02(3);}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqHatBut03.free;
		~ifSeqHatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_03 = ~cntSeqVelHat2_03 + 1;
				~cntSeqVelHat2_03.switch(
					0,{},
					1, {IFSeqVelHat2.st03(1);},
					2, {IFSeqVelHat2.st03(2);},
					3, {IFSeqVelHat2.st03(3);}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqHatBut04.free;
		~ifSeqHatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_04 = ~cntSeqVelHat2_04 + 1;
				~cntSeqVelHat2_04.switch(
					0,{},
					1, {IFSeqVelHat2.st04(1);},
					2, {IFSeqVelHat2.st04(2);},
					3, {IFSeqVelHat2.st04(3);}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqHatBut05.free;
		~ifSeqHatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_05 = ~cntSeqVelHat2_05 + 1;
				~cntSeqVelHat2_05.switch(
					0,{},
					1, {IFSeqVelHat2.st05(1);},
					2, {IFSeqVelHat2.st05(2);},
					3, {IFSeqVelHat2.st05(3);}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqHatBut06.free;
		~ifSeqHatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_06 = ~cntSeqVelHat2_06 + 1;
				~cntSeqVelHat2_06.switch(
					0,{},
					1, {IFSeqVelHat2.st06(1);},
					2, {IFSeqVelHat2.st06(2);},
					3, {IFSeqVelHat2.st06(3);}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqHatBut07.free;
		~ifSeqHatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_07 = ~cntSeqVelHat2_07 + 1;
				~cntSeqVelHat2_07.switch(
					0,{},
					1, {IFSeqVelHat2.st07(1);},
					2, {IFSeqVelHat2.st07(2);},
					3, {IFSeqVelHat2.st07(3);}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqHatBut08.free;
		~ifSeqHatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_08 = ~cntSeqVelHat2_08 + 1;
				~cntSeqVelHat2_08.switch(
					0,{},
					1, {IFSeqVelHat2.st08(1);},
					2, {IFSeqVelHat2.st08(2);},
					3, {IFSeqVelHat2.st08(3);}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqHatBut09.free;
		~ifSeqHatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_09 = ~cntSeqVelHat2_09 + 1;
				~cntSeqVelHat2_09.switch(
					0,{},
					1, {IFSeqVelHat2.st09(1);},
					2, {IFSeqVelHat2.st09(2);},
					3, {IFSeqVelHat2.st09(3);}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqHatBut10.free;
		~ifSeqHatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_10 = ~cntSeqVelHat2_10 + 1;
				~cntSeqVelHat2_10.switch(
					0,{},
					1, {IFSeqVelHat2.st10(1);},
					2, {IFSeqVelHat2.st10(2);},
					3, {IFSeqVelHat2.st10(3);}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqHatBut11.free;
		~ifSeqHatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_11 = ~cntSeqVelHat2_11 + 1;
				~cntSeqVelHat2_11.switch(
					0,{},
					1, {IFSeqVelHat2.st11(1);},
					2, {IFSeqVelHat2.st11(2);},
					3, {IFSeqVelHat2.st11(3);}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqHatBut12.free;
		~ifSeqHatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_12 = ~cntSeqVelHat2_12 + 1;
				~cntSeqVelHat2_12.switch(
					0,{},
					1, {IFSeqVelHat2.st12(1);},
					2, {IFSeqVelHat2.st12(2);},
					3, {IFSeqVelHat2.st12(3);}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqHatBut13.free;
		~ifSeqHatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_13 = ~cntSeqVelHat2_13 + 1;
				~cntSeqVelHat2_13.switch(
					0,{},
					1, {IFSeqVelHat2.st13(1);},
					2, {IFSeqVelHat2.st13(2);},
					3, {IFSeqVelHat2.st13(3);}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqHatBut14.free;
		~ifSeqHatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_14 = ~cntSeqVelHat2_14 + 1;
				~cntSeqVelHat2_14.switch(
					0,{},
					1, {IFSeqVelHat2.st14(1);},
					2, {IFSeqVelHat2.st14(2);},
					3, {IFSeqVelHat2.st14(3);}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqHatBut15.free;
		~ifSeqHatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_15 = ~cntSeqVelHat2_15 + 1;
				~cntSeqVelHat2_15.switch(
					0,{},
					1, {IFSeqVelHat2.st15(1);},
					2, {IFSeqVelHat2.st15(2);},
					3, {IFSeqVelHat2.st15(3);}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqHatBut16.free;
		~ifSeqHatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat2_16 = ~cntSeqVelHat2_16 + 1;
				~cntSeqVelHat2_16.switch(
					0,{},
					1, {IFSeqVelHat2.st16(1);},
					2, {IFSeqVelHat2.st16(2);},
					3, {IFSeqVelHat2.st16(3);}
				)}
			);
			},
			'/ifSeq/2/16'
		);


	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat01', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat01', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat01', '3');
		}

	}

	*st02 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat02', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat02', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat02', '3');
		}

	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat03', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat03', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat03', '3');
		}

	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat04', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat04', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat04', '3');
		}

	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat05', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat05', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat05', '3');
		}

	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat06', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat06', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat06', '3');
		}

	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat07', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat07', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat07', '3');
		}

	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat08', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat08', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat08', '3');
		}

	}
	*st09 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat09', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat09', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat09', '3');
		}

	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat10', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat10', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat10', '3');
		}

	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat11', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat11', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat11', '3');
		}

	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat12', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat12', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat12', '3');
		}

	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat13', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat13', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat13', '3');
		}

	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat14', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat14', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat14', '3');
		}

	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat15', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat15', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat15', '3');
		}

	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqVelHat2_16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat16', '1');
		}
		{ i == 2 }  {
			~seqVelHat2_16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat16', '2');
		}
		{ i == 3 }  {
			~seqVelHat2_16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat16', '3');
		}

	}
	*stGrp {|i|
		IFSeqVelHat2.st01(i); IFSeqVelHat2.st02(i); IFSeqVelHat2.st03(i); IFSeqVelHat2.st04(i);
		IFSeqVelHat2.st05(i); IFSeqVelHat2.st06(i); IFSeqVelHat2.st07(i); IFSeqVelHat2.st08(i);
		IFSeqVelHat2.st09(i); IFSeqVelHat2.st10(i); IFSeqVelHat2.st11(i); IFSeqVelHat2.st12(i);
		IFSeqVelHat2.st13(i); IFSeqVelHat2.st14(i); IFSeqVelHat2.st15(i); IFSeqVelHat2.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqVelHat2.st01(s01); IFSeqVelHat2.st02(s02); IFSeqVelHat2.st03(s03); IFSeqVelHat2.st04(s04);
		IFSeqVelHat2.st05(s05); IFSeqVelHat2.st06(s06); IFSeqVelHat2.st07(s07); IFSeqVelHat2.st08(s08);
		IFSeqVelHat2.st09(s09); IFSeqVelHat2.st10(s10); IFSeqVelHat2.st11(s11); IFSeqVelHat2.st12(s12);
		IFSeqVelHat2.st13(s13); IFSeqVelHat2.st14(s14); IFSeqVelHat2.st15(s15); IFSeqVelHat2.st16(s16);
	}
}