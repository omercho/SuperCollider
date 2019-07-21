IFSeqVelMopho {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVelMopho01 = PatternProxy( Pseq([1], 1));
		~seqVelMopho02 = PatternProxy( Pseq([1], 1));
		~seqVelMopho03 = PatternProxy( Pseq([1], 1));
		~seqVelMopho04 = PatternProxy( Pseq([1], 1));
		~seqVelMopho05 = PatternProxy( Pseq([1], 1));
		~seqVelMopho06 = PatternProxy( Pseq([1], 1));
		~seqVelMopho07 = PatternProxy( Pseq([1], 1));
		~seqVelMopho08 = PatternProxy( Pseq([1], 1));

		~seqVelMopho09 = PatternProxy( Pseq([1], 1));
		~seqVelMopho10 = PatternProxy( Pseq([1], 1));
		~seqVelMopho11 = PatternProxy( Pseq([1], 1));
		~seqVelMopho12 = PatternProxy( Pseq([1], 1));
		~seqVelMopho13 = PatternProxy( Pseq([1], 1));
		~seqVelMopho14 = PatternProxy( Pseq([1], 1));
		~seqVelMopho15 = PatternProxy( Pseq([1], 1));
		~seqVelMopho16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqVelUpMopho01=0;
		~cntSeqVelRandMopho01=0;

		~cntSeqVelMopho01=0;
		~cntSeqVelMopho02=0;
		~cntSeqVelMopho03=0;
		~cntSeqVelMopho04=0;
		~cntSeqVelMopho05=0;
		~cntSeqVelMopho06=0;
		~cntSeqVelMopho07=0;
		~cntSeqVelMopho08=0;

		~cntSeqVelMopho09=0;
		~cntSeqVelMopho10=0;
		~cntSeqVelMopho11=0;
		~cntSeqVelMopho12=0;
		~cntSeqVelMopho13=0;
		~cntSeqVelMopho14=0;
		~cntSeqVelMopho15=0;
		~cntSeqVelMopho16=0;
	}
	*freeOn {
		~seqFreeMophoBut.free;
		~seqFreeMophoBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVelMopho.stGrp(1);
				});
			},
			'/seqFreeMopho'
		);
	}
	*upOn {
		~ifSeqUpMophoBut.free;
		~ifSeqUpMophoBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelUpMopho01 = ~cntSeqVelUpMopho01 + 1;
				~cntSeqVelUpMopho01.switch(
					0,{},
					1,{IFSeqVelMopho.stGrp(1);},
					2,{IFSeqVelMopho.stGrp(2);},
					3,{IFSeqVelMopho.stGrp(3);
						~cntSeqVelUpMopho01=0;
					}
				)}
			);
			},
			'/seqUpMopho'
		);
	}

	*randOn {
		~ifSeqRandMophoBut.free;
		~ifSeqRandMophoBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelRandMopho01 = ~cntSeqVelRandMopho01 + 1;
				~cntSeqVelRandMopho01.switch(
					0,{},
					1,{
						IFSeqVelMopho.st01([1,2,3].choose);
						IFSeqVelMopho.st02([1,2,3].choose);
						IFSeqVelMopho.st03([1,2,3].choose);
						IFSeqVelMopho.st04([1,2,3].choose);
						IFSeqVelMopho.st05([1,2,3].choose);
						IFSeqVelMopho.st06([1,2,3].choose);
						IFSeqVelMopho.st07([1,2,3].choose);
						IFSeqVelMopho.st08([1,2,3].choose);

						IFSeqVelMopho.st09([1,2,3].choose);
						IFSeqVelMopho.st10([1,2,3].choose);
						IFSeqVelMopho.st11([1,2,3].choose);
						IFSeqVelMopho.st12([1,2,3].choose);
						IFSeqVelMopho.st13([1,2,3].choose);
						IFSeqVelMopho.st14([1,2,3].choose);
						IFSeqVelMopho.st15([1,2,3].choose);
						IFSeqVelMopho.st16([1,2,3].choose);
						~cntSeqVelRandMopho01=0;
					}
				)}
			);
			},
			'/seqRandMopho'
		);
	}


	*on { // Shift Velocity

		IFSeqVelMopho.randOn;
		IFSeqVelMopho.upOn;
		IFSeqVelMopho.freeOn;

		~ifSeqMophoBut01.free;
		~ifSeqMophoBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho01 = ~cntSeqVelMopho01 + 1;
				~cntSeqVelMopho01.switch(
					0,{},
					1, {IFSeqVelMopho.st01(1);},
					2, {IFSeqVelMopho.st01(2);},
					3, {IFSeqVelMopho.st01(3);}
				)}
			);
			},
			'/ifSeq/7/1'
		);
		~ifSeqMophoBut02.free;
		~ifSeqMophoBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho02 = ~cntSeqVelMopho02 + 1;
				~cntSeqVelMopho02.switch(
					0,{},
					1, {IFSeqVelMopho.st02(1);},
					2, {IFSeqVelMopho.st02(2);},
					3, {IFSeqVelMopho.st02(3);}
				)}
			);
			},
			'/ifSeq/7/2'
		);
		~ifSeqMophoBut03.free;
		~ifSeqMophoBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho03 = ~cntSeqVelMopho03 + 1;
				~cntSeqVelMopho03.switch(
					0,{},
					1, {IFSeqVelMopho.st03(1);},
					2, {IFSeqVelMopho.st03(2);},
					3, {IFSeqVelMopho.st03(3);}
				)}
			);
			},
			'/ifSeq/7/3'
		);
		~ifSeqMophoBut04.free;
		~ifSeqMophoBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho04 = ~cntSeqVelMopho04 + 1;
				~cntSeqVelMopho04.switch(
					0,{},
					1, {IFSeqVelMopho.st04(1);},
					2, {IFSeqVelMopho.st04(2);},
					3, {IFSeqVelMopho.st04(3);}
				)}
			);
			},
			'/ifSeq/7/4'
		);
		~ifSeqMophoBut05.free;
		~ifSeqMophoBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho05 = ~cntSeqVelMopho05 + 1;
				~cntSeqVelMopho05.switch(
					0,{},
					1, {IFSeqVelMopho.st05(1);},
					2, {IFSeqVelMopho.st05(2);},
					3, {IFSeqVelMopho.st05(3);}
				)}
			);
			},
			'/ifSeq/7/5'
		);
		~ifSeqMophoBut06.free;
		~ifSeqMophoBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho06 = ~cntSeqVelMopho06 + 1;
				~cntSeqVelMopho06.switch(
					0,{},
					1, {IFSeqVelMopho.st06(1);},
					2, {IFSeqVelMopho.st06(2);},
					3, {IFSeqVelMopho.st06(3);}
				)}
			);
			},
			'/ifSeq/7/6'
		);
		~ifSeqMophoBut07.free;
		~ifSeqMophoBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho07 = ~cntSeqVelMopho07 + 1;
				~cntSeqVelMopho07.switch(
					0,{},
					1, {IFSeqVelMopho.st07(1);},
					2, {IFSeqVelMopho.st07(2);},
					3, {IFSeqVelMopho.st07(3);}
				)}
			);
			},
			'/ifSeq/7/7'
		);
		~ifSeqMophoBut08.free;
		~ifSeqMophoBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho08 = ~cntSeqVelMopho08 + 1;
				~cntSeqVelMopho08.switch(
					0,{},
					1, {IFSeqVelMopho.st08(1);},
					2, {IFSeqVelMopho.st08(2);},
					3, {IFSeqVelMopho.st08(3);}
				)}
			);
			},
			'/ifSeq/7/8'
		);

		~ifSeqMophoBut09.free;
		~ifSeqMophoBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho09 = ~cntSeqVelMopho09 + 1;
				~cntSeqVelMopho09.switch(
					0,{},
					1, {IFSeqVelMopho.st09(1);},
					2, {IFSeqVelMopho.st09(2);},
					3, {IFSeqVelMopho.st09(3);}
				)}
			);
			},
			'/ifSeq/7/9'
		);
		~ifSeqMophoBut10.free;
		~ifSeqMophoBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho10 = ~cntSeqVelMopho10 + 1;
				~cntSeqVelMopho10.switch(
					0,{},
					1, {IFSeqVelMopho.st10(1);},
					2, {IFSeqVelMopho.st10(2);},
					3, {IFSeqVelMopho.st10(3);}
				)}
			);
			},
			'/ifSeq/7/10'
		);
		~ifSeqMophoBut11.free;
		~ifSeqMophoBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho11 = ~cntSeqVelMopho11 + 1;
				~cntSeqVelMopho11.switch(
					0,{},
					1, {IFSeqVelMopho.st11(1);},
					2, {IFSeqVelMopho.st11(2);},
					3, {IFSeqVelMopho.st11(3);}
				)}
			);
			},
			'/ifSeq/7/11'
		);
		~ifSeqMophoBut12.free;
		~ifSeqMophoBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho12 = ~cntSeqVelMopho12 + 1;
				~cntSeqVelMopho12.switch(
					0,{},
					1, {IFSeqVelMopho.st12(1);},
					2, {IFSeqVelMopho.st12(2);},
					3, {IFSeqVelMopho.st12(3);}
				)}
			);
			},
			'/ifSeq/7/12'
		);
		~ifSeqMophoBut13.free;
		~ifSeqMophoBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho13 = ~cntSeqVelMopho13 + 1;
				~cntSeqVelMopho13.switch(
					0,{},
					1, {IFSeqVelMopho.st13(1);},
					2, {IFSeqVelMopho.st13(2);},
					3, {IFSeqVelMopho.st13(3);}
				)}
			);
			},
			'/ifSeq/7/13'
		);
		~ifSeqMophoBut14.free;
		~ifSeqMophoBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho14 = ~cntSeqVelMopho14 + 1;
				~cntSeqVelMopho14.switch(
					0,{},
					1, {IFSeqVelMopho.st14(1);},
					2, {IFSeqVelMopho.st14(2);},
					3, {IFSeqVelMopho.st14(3);}
				)}
			);
			},
			'/ifSeq/7/14'
		);
		~ifSeqMophoBut15.free;
		~ifSeqMophoBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho15 = ~cntSeqVelMopho15 + 1;
				~cntSeqVelMopho15.switch(
					0,{},
					1, {IFSeqVelMopho.st15(1);},
					2, {IFSeqVelMopho.st15(2);},
					3, {IFSeqVelMopho.st15(3);}
				)}
			);
			},
			'/ifSeq/7/15'
		);
		~ifSeqMophoBut16.free;
		~ifSeqMophoBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelMopho16 = ~cntSeqVelMopho16 + 1;
				~cntSeqVelMopho16.switch(
					0,{},
					1, {IFSeqVelMopho.st16(1);},
					2, {IFSeqVelMopho.st16(2);},
					3, {IFSeqVelMopho.st16(3);}
				)}
			);
			},
			'/ifSeq/7/16'
		);


	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho01', '1');
		}
		{ i == 2 }  {
			~seqVelMopho01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho01', '2');
		}
		{ i == 3 }  {
			~seqVelMopho01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho01', '3');
		}

	}

	*st02 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho02', '1');
		}
		{ i == 2 }  {
			~seqVelMopho02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho02', '2');
		}
		{ i == 3 }  {
			~seqVelMopho02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho02', '3');
		}

	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho03', '1');
		}
		{ i == 2 }  {
			~seqVelMopho03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho03', '2');
		}
		{ i == 3 }  {
			~seqVelMopho03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho03', '3');
		}

	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho04', '1');
		}
		{ i == 2 }  {
			~seqVelMopho04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho04', '2');
		}
		{ i == 3 }  {
			~seqVelMopho04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho04', '3');
		}

	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho05', '1');
		}
		{ i == 2 }  {
			~seqVelMopho05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho05', '2');
		}
		{ i == 3 }  {
			~seqVelMopho05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho05', '3');
		}

	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho06', '1');
		}
		{ i == 2 }  {
			~seqVelMopho06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho06', '2');
		}
		{ i == 3 }  {
			~seqVelMopho06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho06', '3');
		}

	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho07', '1');
		}
		{ i == 2 }  {
			~seqVelMopho07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho07', '2');
		}
		{ i == 3 }  {
			~seqVelMopho07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho07', '3');
		}

	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho08', '1');
		}
		{ i == 2 }  {
			~seqVelMopho08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho08', '2');
		}
		{ i == 3 }  {
			~seqVelMopho08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho08', '3');
		}

	}
	*st09 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho09', '1');
		}
		{ i == 2 }  {
			~seqVelMopho09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho09', '2');
		}
		{ i == 3 }  {
			~seqVelMopho09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho09', '3');
		}

	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho10', '1');
		}
		{ i == 2 }  {
			~seqVelMopho10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho10', '2');
		}
		{ i == 3 }  {
			~seqVelMopho10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho10', '3');
		}

	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho11', '1');
		}
		{ i == 2 }  {
			~seqVelMopho11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho11', '2');
		}
		{ i == 3 }  {
			~seqVelMopho11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho11', '3');
		}

	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho12', '1');
		}
		{ i == 2 }  {
			~seqVelMopho12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho12', '2');
		}
		{ i == 3 }  {
			~seqVelMopho12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho12', '3');
		}

	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho13', '1');
		}
		{ i == 2 }  {
			~seqVelMopho13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho13', '2');
		}
		{ i == 3 }  {
			~seqVelMopho13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho13', '3');
		}

	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho14', '1');
		}
		{ i == 2 }  {
			~seqVelMopho14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho14', '2');
		}
		{ i == 3 }  {
			~seqVelMopho14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho14', '3');
		}

	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho15', '1');
		}
		{ i == 2 }  {
			~seqVelMopho15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho15', '2');
		}
		{ i == 3 }  {
			~seqVelMopho15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho15', '3');
		}

	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqVelMopho16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelMopho16', '1');
		}
		{ i == 2 }  {
			~seqVelMopho16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelMopho16', '2');
		}
		{ i == 3 }  {
			~seqVelMopho16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelMopho16', '3');
		}

	}
	*stGrp {|i|
		IFSeqVelMopho.st01(i); IFSeqVelMopho.st02(i); IFSeqVelMopho.st03(i); IFSeqVelMopho.st04(i);
		IFSeqVelMopho.st05(i); IFSeqVelMopho.st06(i); IFSeqVelMopho.st07(i); IFSeqVelMopho.st08(i);
		IFSeqVelMopho.st09(i); IFSeqVelMopho.st10(i); IFSeqVelMopho.st11(i); IFSeqVelMopho.st12(i);
		IFSeqVelMopho.st13(i); IFSeqVelMopho.st14(i); IFSeqVelMopho.st15(i); IFSeqVelMopho.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqVelMopho.st01(s01); IFSeqVelMopho.st02(s02); IFSeqVelMopho.st03(s03); IFSeqVelMopho.st04(s04);
		IFSeqVelMopho.st05(s05); IFSeqVelMopho.st06(s06); IFSeqVelMopho.st07(s07); IFSeqVelMopho.st08(s08);
		IFSeqVelMopho.st09(s09); IFSeqVelMopho.st10(s10); IFSeqVelMopho.st11(s11); IFSeqVelMopho.st12(s12);
		IFSeqVelMopho.st13(s13); IFSeqVelMopho.st14(s14); IFSeqVelMopho.st15(s15); IFSeqVelMopho.st16(s16);
	}
}