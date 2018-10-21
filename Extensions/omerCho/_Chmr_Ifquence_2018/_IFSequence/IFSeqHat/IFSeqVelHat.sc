IFSeqVelHat {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVelHat01 = PatternProxy( Pseq([1], 1));
		~seqVelHat02 = PatternProxy( Pseq([1], 1));
		~seqVelHat03 = PatternProxy( Pseq([1], 1));
		~seqVelHat04 = PatternProxy( Pseq([1], 1));
		~seqVelHat05 = PatternProxy( Pseq([1], 1));
		~seqVelHat06 = PatternProxy( Pseq([1], 1));
		~seqVelHat07 = PatternProxy( Pseq([1], 1));
		~seqVelHat08 = PatternProxy( Pseq([1], 1));

		~seqVelHat09 = PatternProxy( Pseq([1], 1));
		~seqVelHat10 = PatternProxy( Pseq([1], 1));
		~seqVelHat11 = PatternProxy( Pseq([1], 1));
		~seqVelHat12 = PatternProxy( Pseq([1], 1));
		~seqVelHat13 = PatternProxy( Pseq([1], 1));
		~seqVelHat14 = PatternProxy( Pseq([1], 1));
		~seqVelHat15 = PatternProxy( Pseq([1], 1));
		~seqVelHat16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqVelUpHat01=0;
		~cntSeqVelRandHat01=0;

		~cntSeqVelHat01=0;
		~cntSeqVelHat02=0;
		~cntSeqVelHat03=0;
		~cntSeqVelHat04=0;
		~cntSeqVelHat05=0;
		~cntSeqVelHat06=0;
		~cntSeqVelHat07=0;
		~cntSeqVelHat08=0;

		~cntSeqVelHat09=0;
		~cntSeqVelHat10=0;
		~cntSeqVelHat11=0;
		~cntSeqVelHat12=0;
		~cntSeqVelHat13=0;
		~cntSeqVelHat14=0;
		~cntSeqVelHat15=0;
		~cntSeqVelHat16=0;
	}
	*freeOn {
		~seqFreeHatBut.free;
		~seqFreeHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVelHat.stGrp(1);
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
				~cntSeqVelUpHat01 = ~cntSeqVelUpHat01 + 1;
				~cntSeqVelUpHat01.switch(
					0,{},
					1,{IFSeqVelHat.stGrp(1);},
					2,{IFSeqVelHat.stGrp(2);},
					3,{IFSeqVelHat.stGrp(3);
						~cntSeqVelUpHat01=0;
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
				~cntSeqVelRandHat01 = ~cntSeqVelRandHat01 + 1;
				~cntSeqVelRandHat01.switch(
					0,{},
					1,{
						IFSeqVelHat.st01([1,2,3].choose);
						IFSeqVelHat.st02([1,2,3].choose);
						IFSeqVelHat.st03([1,2,3].choose);
						IFSeqVelHat.st04([1,2,3].choose);
						IFSeqVelHat.st05([1,2,3].choose);
						IFSeqVelHat.st06([1,2,3].choose);
						IFSeqVelHat.st07([1,2,3].choose);
						IFSeqVelHat.st08([1,2,3].choose);

						IFSeqVelHat.st09([1,2,3].choose);
						IFSeqVelHat.st10([1,2,3].choose);
						IFSeqVelHat.st11([1,2,3].choose);
						IFSeqVelHat.st12([1,2,3].choose);
						IFSeqVelHat.st13([1,2,3].choose);
						IFSeqVelHat.st14([1,2,3].choose);
						IFSeqVelHat.st15([1,2,3].choose);
						IFSeqVelHat.st16([1,2,3].choose);
						~cntSeqVelRandHat01=0;
					}
				)}
			);
			},
			'/seqRandHat'
		);
	}


	*on { // Shift Velocity

		IFSeqVelHat.randOn;
		IFSeqVelHat.upOn;
		IFSeqVelHat.freeOn;

		~ifSeqHatBut01.free;
		~ifSeqHatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat01 = ~cntSeqVelHat01 + 1;
				~cntSeqVelHat01.switch(
					0,{},
					1, {IFSeqVelHat.st01(1);},
					2, {IFSeqVelHat.st01(2);},
					3, {IFSeqVelHat.st01(3);}
				)}
			);
			},
			'/ifSeq/3/1'
		);
		~ifSeqHatBut02.free;
		~ifSeqHatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat02 = ~cntSeqVelHat02 + 1;
				~cntSeqVelHat02.switch(
					0,{},
					1, {IFSeqVelHat.st02(1);},
					2, {IFSeqVelHat.st02(2);},
					3, {IFSeqVelHat.st02(3);}
				)}
			);
			},
			'/ifSeq/3/2'
		);
		~ifSeqHatBut03.free;
		~ifSeqHatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat03 = ~cntSeqVelHat03 + 1;
				~cntSeqVelHat03.switch(
					0,{},
					1, {IFSeqVelHat.st03(1);},
					2, {IFSeqVelHat.st03(2);},
					3, {IFSeqVelHat.st03(3);}
				)}
			);
			},
			'/ifSeq/3/3'
		);
		~ifSeqHatBut04.free;
		~ifSeqHatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat04 = ~cntSeqVelHat04 + 1;
				~cntSeqVelHat04.switch(
					0,{},
					1, {IFSeqVelHat.st04(1);},
					2, {IFSeqVelHat.st04(2);},
					3, {IFSeqVelHat.st04(3);}
				)}
			);
			},
			'/ifSeq/3/4'
		);
		~ifSeqHatBut05.free;
		~ifSeqHatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat05 = ~cntSeqVelHat05 + 1;
				~cntSeqVelHat05.switch(
					0,{},
					1, {IFSeqVelHat.st05(1);},
					2, {IFSeqVelHat.st05(2);},
					3, {IFSeqVelHat.st05(3);}
				)}
			);
			},
			'/ifSeq/3/5'
		);
		~ifSeqHatBut06.free;
		~ifSeqHatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat06 = ~cntSeqVelHat06 + 1;
				~cntSeqVelHat06.switch(
					0,{},
					1, {IFSeqVelHat.st06(1);},
					2, {IFSeqVelHat.st06(2);},
					3, {IFSeqVelHat.st06(3);}
				)}
			);
			},
			'/ifSeq/3/6'
		);
		~ifSeqHatBut07.free;
		~ifSeqHatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat07 = ~cntSeqVelHat07 + 1;
				~cntSeqVelHat07.switch(
					0,{},
					1, {IFSeqVelHat.st07(1);},
					2, {IFSeqVelHat.st07(2);},
					3, {IFSeqVelHat.st07(3);}
				)}
			);
			},
			'/ifSeq/3/7'
		);
		~ifSeqHatBut08.free;
		~ifSeqHatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat08 = ~cntSeqVelHat08 + 1;
				~cntSeqVelHat08.switch(
					0,{},
					1, {IFSeqVelHat.st08(1);},
					2, {IFSeqVelHat.st08(2);},
					3, {IFSeqVelHat.st08(3);}
				)}
			);
			},
			'/ifSeq/3/8'
		);

		~ifSeqHatBut09.free;
		~ifSeqHatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat09 = ~cntSeqVelHat09 + 1;
				~cntSeqVelHat09.switch(
					0,{},
					1, {IFSeqVelHat.st09(1);},
					2, {IFSeqVelHat.st09(2);},
					3, {IFSeqVelHat.st09(3);}
				)}
			);
			},
			'/ifSeq/3/9'
		);
		~ifSeqHatBut10.free;
		~ifSeqHatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat10 = ~cntSeqVelHat10 + 1;
				~cntSeqVelHat10.switch(
					0,{},
					1, {IFSeqVelHat.st10(1);},
					2, {IFSeqVelHat.st10(2);},
					3, {IFSeqVelHat.st10(3);}
				)}
			);
			},
			'/ifSeq/3/10'
		);
		~ifSeqHatBut11.free;
		~ifSeqHatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat11 = ~cntSeqVelHat11 + 1;
				~cntSeqVelHat11.switch(
					0,{},
					1, {IFSeqVelHat.st11(1);},
					2, {IFSeqVelHat.st11(2);},
					3, {IFSeqVelHat.st11(3);}
				)}
			);
			},
			'/ifSeq/3/11'
		);
		~ifSeqHatBut12.free;
		~ifSeqHatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat12 = ~cntSeqVelHat12 + 1;
				~cntSeqVelHat12.switch(
					0,{},
					1, {IFSeqVelHat.st12(1);},
					2, {IFSeqVelHat.st12(2);},
					3, {IFSeqVelHat.st12(3);}
				)}
			);
			},
			'/ifSeq/3/12'
		);
		~ifSeqHatBut13.free;
		~ifSeqHatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat13 = ~cntSeqVelHat13 + 1;
				~cntSeqVelHat13.switch(
					0,{},
					1, {IFSeqVelHat.st13(1);},
					2, {IFSeqVelHat.st13(2);},
					3, {IFSeqVelHat.st13(3);}
				)}
			);
			},
			'/ifSeq/3/13'
		);
		~ifSeqHatBut14.free;
		~ifSeqHatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat14 = ~cntSeqVelHat14 + 1;
				~cntSeqVelHat14.switch(
					0,{},
					1, {IFSeqVelHat.st14(1);},
					2, {IFSeqVelHat.st14(2);},
					3, {IFSeqVelHat.st14(3);}
				)}
			);
			},
			'/ifSeq/3/14'
		);
		~ifSeqHatBut15.free;
		~ifSeqHatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat15 = ~cntSeqVelHat15 + 1;
				~cntSeqVelHat15.switch(
					0,{},
					1, {IFSeqVelHat.st15(1);},
					2, {IFSeqVelHat.st15(2);},
					3, {IFSeqVelHat.st15(3);}
				)}
			);
			},
			'/ifSeq/3/15'
		);
		~ifSeqHatBut16.free;
		~ifSeqHatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelHat16 = ~cntSeqVelHat16 + 1;
				~cntSeqVelHat16.switch(
					0,{},
					1, {IFSeqVelHat.st16(1);},
					2, {IFSeqVelHat.st16(2);},
					3, {IFSeqVelHat.st16(3);}
				)}
			);
			},
			'/ifSeq/3/16'
		);


	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqVelHat01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat01', '1');
		}
		{ i == 2 }  {
			~seqVelHat01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat01', '2');
		}
		{ i == 3 }  {
			~seqVelHat01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat01', '3');
		}

	}

	*st02 {|i|
		case
		{ i == 1 }  {
			~seqVelHat02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat02', '1');
		}
		{ i == 2 }  {
			~seqVelHat02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat02', '2');
		}
		{ i == 3 }  {
			~seqVelHat02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat02', '3');
		}

	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqVelHat03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat03', '1');
		}
		{ i == 2 }  {
			~seqVelHat03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat03', '2');
		}
		{ i == 3 }  {
			~seqVelHat03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat03', '3');
		}

	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqVelHat04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat04', '1');
		}
		{ i == 2 }  {
			~seqVelHat04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat04', '2');
		}
		{ i == 3 }  {
			~seqVelHat04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat04', '3');
		}

	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqVelHat05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat05', '1');
		}
		{ i == 2 }  {
			~seqVelHat05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat05', '2');
		}
		{ i == 3 }  {
			~seqVelHat05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat05', '3');
		}

	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqVelHat06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat06', '1');
		}
		{ i == 2 }  {
			~seqVelHat06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat06', '2');
		}
		{ i == 3 }  {
			~seqVelHat06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat06', '3');
		}

	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqVelHat07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat07', '1');
		}
		{ i == 2 }  {
			~seqVelHat07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat07', '2');
		}
		{ i == 3 }  {
			~seqVelHat07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat07', '3');
		}

	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqVelHat08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat08', '1');
		}
		{ i == 2 }  {
			~seqVelHat08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat08', '2');
		}
		{ i == 3 }  {
			~seqVelHat08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat08', '3');
		}

	}
	*st09 {|i|
		case
		{ i == 1 }  {
			~seqVelHat09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat09', '1');
		}
		{ i == 2 }  {
			~seqVelHat09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat09', '2');
		}
		{ i == 3 }  {
			~seqVelHat09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat09', '3');
		}

	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqVelHat10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat10', '1');
		}
		{ i == 2 }  {
			~seqVelHat10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat10', '2');
		}
		{ i == 3 }  {
			~seqVelHat10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat10', '3');
		}

	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqVelHat11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat11', '1');
		}
		{ i == 2 }  {
			~seqVelHat11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat11', '2');
		}
		{ i == 3 }  {
			~seqVelHat11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat11', '3');
		}

	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqVelHat12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat12', '1');
		}
		{ i == 2 }  {
			~seqVelHat12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat12', '2');
		}
		{ i == 3 }  {
			~seqVelHat12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat12', '3');
		}

	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqVelHat13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat13', '1');
		}
		{ i == 2 }  {
			~seqVelHat13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat13', '2');
		}
		{ i == 3 }  {
			~seqVelHat13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat13', '3');
		}

	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqVelHat14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat14', '1');
		}
		{ i == 2 }  {
			~seqVelHat14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat14', '2');
		}
		{ i == 3 }  {
			~seqVelHat14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat14', '3');
		}

	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqVelHat15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat15', '1');
		}
		{ i == 2 }  {
			~seqVelHat15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat15', '2');
		}
		{ i == 3 }  {
			~seqVelHat15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat15', '3');
		}

	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqVelHat16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelHat16', '1');
		}
		{ i == 2 }  {
			~seqVelHat16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelHat16', '2');
		}
		{ i == 3 }  {
			~seqVelHat16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelHat16', '3');
		}

	}
	*stGrp {|i|
		IFSeqVelHat.st01(i); IFSeqVelHat.st02(i); IFSeqVelHat.st03(i); IFSeqVelHat.st04(i);
		IFSeqVelHat.st05(i); IFSeqVelHat.st06(i); IFSeqVelHat.st07(i); IFSeqVelHat.st08(i);
		IFSeqVelHat.st09(i); IFSeqVelHat.st10(i); IFSeqVelHat.st11(i); IFSeqVelHat.st12(i);
		IFSeqVelHat.st13(i); IFSeqVelHat.st14(i); IFSeqVelHat.st15(i); IFSeqVelHat.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqVelHat.st01(s01); IFSeqVelHat.st02(s02); IFSeqVelHat.st03(s03); IFSeqVelHat.st04(s04);
		IFSeqVelHat.st05(s05); IFSeqVelHat.st06(s06); IFSeqVelHat.st07(s07); IFSeqVelHat.st08(s08);
		IFSeqVelHat.st09(s09); IFSeqVelHat.st10(s10); IFSeqVelHat.st11(s11); IFSeqVelHat.st12(s12);
		IFSeqVelHat.st13(s13); IFSeqVelHat.st14(s14); IFSeqVelHat.st15(s15); IFSeqVelHat.st16(s16);
	}
}