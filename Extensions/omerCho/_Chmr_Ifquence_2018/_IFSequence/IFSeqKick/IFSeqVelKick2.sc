IFSeqVelKick2 {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVelKick2_01 = PatternProxy( Pseq([1], 1));
		~seqVelKick2_02 = PatternProxy( Pseq([1], 1));
		~seqVelKick2_03 = PatternProxy( Pseq([1], 1));
		~seqVelKick2_04 = PatternProxy( Pseq([1], 1));
		~seqVelKick2_05 = PatternProxy( Pseq([1], 1));
		~seqVelKick2_06 = PatternProxy( Pseq([1], 1));
		~seqVelKick2_07 = PatternProxy( Pseq([1], 1));
		~seqVelKick2_08 = PatternProxy( Pseq([1], 1));

		~seqVelKick2_09 = PatternProxy( Pseq([1], 1));
		~seqVelKick2_10 = PatternProxy( Pseq([1], 1));
		~seqVelKick2_11 = PatternProxy( Pseq([1], 1));
		~seqVelKick2_12 = PatternProxy( Pseq([1], 1));
		~seqVelKick2_13 = PatternProxy( Pseq([1], 1));
		~seqVelKick2_14 = PatternProxy( Pseq([1], 1));
		~seqVelKick2_15 = PatternProxy( Pseq([1], 1));
		~seqVelKick2_16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqVelUpKick2_01=0;
		~cntSeqVelRandKick2_01=0;

		~cntSeqVelKick2_01=0;
		~cntSeqVelKick2_02=0;
		~cntSeqVelKick2_03=0;
		~cntSeqVelKick2_04=0;
		~cntSeqVelKick2_05=0;
		~cntSeqVelKick2_06=0;
		~cntSeqVelKick2_07=0;
		~cntSeqVelKick2_08=0;

		~cntSeqVelKick2_09=0;
		~cntSeqVelKick2_10=0;
		~cntSeqVelKick2_11=0;
		~cntSeqVelKick2_12=0;
		~cntSeqVelKick2_13=0;
		~cntSeqVelKick2_14=0;
		~cntSeqVelKick2_15=0;
		~cntSeqVelKick2_16=0;
	}
	*freeOn {
		~seqFreeKick2But.free;
		~seqFreeKick2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVelKick2.stGrp(1);
				});
			},
			'/seqFreeKick'
		);
	}
	*upOn {
		~ifSeqUpKick2But.free;
		~ifSeqUpKick2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelUpKick2_01 = ~cntSeqVelUpKick2_01 + 1;
				~cntSeqVelUpKick2_01.switch(
					0,{},
					1,{IFSeqVelKick2.stGrp(1);},
					2,{IFSeqVelKick2.stGrp(2);},
					3,{IFSeqVelKick2.stGrp(3);
						~cntSeqVelUpKick2_01=0;
					}
				)}
			);
			},
			'/seqUpKick'
		);
	}

	*randOn {
		~ifSeqRandKick2But.free;
		~ifSeqRandKick2But= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelRandKick2_01 = ~cntSeqVelRandKick2_01 + 1;
				~cntSeqVelRandKick2_01.switch(
					0,{},
					1,{
						IFSeqVelKick2.st01([1,2,3].choose);
						IFSeqVelKick2.st02([1,2,3].choose);
						IFSeqVelKick2.st03([1,2,3].choose);
						IFSeqVelKick2.st04([1,2,3].choose);
						IFSeqVelKick2.st05([1,2,3].choose);
						IFSeqVelKick2.st06([1,2,3].choose);
						IFSeqVelKick2.st07([1,2,3].choose);
						IFSeqVelKick2.st08([1,2,3].choose);

						IFSeqVelKick2.st09([1,2,3].choose);
						IFSeqVelKick2.st10([1,2,3].choose);
						IFSeqVelKick2.st11([1,2,3].choose);
						IFSeqVelKick2.st12([1,2,3].choose);
						IFSeqVelKick2.st13([1,2,3].choose);
						IFSeqVelKick2.st14([1,2,3].choose);
						IFSeqVelKick2.st15([1,2,3].choose);
						IFSeqVelKick2.st16([1,2,3].choose);
						~cntSeqVelRandKick2_01=0;
					}
				)}
			);
			},
			'/seqRandKick'
		);
	}


	*on { // Shift Velocity

		IFSeqVelKick2.randOn;
		IFSeqVelKick2.upOn;
		IFSeqVelKick2.freeOn;

		~ifSeqKick2But01.free;
		~ifSeqKick2But01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_01 = ~cntSeqVelKick2_01 + 1;
				~cntSeqVelKick2_01.switch(
					0,{},
					1, {IFSeqVelKick2.st01(1);},
					2, {IFSeqVelKick2.st01(2);},
					3, {IFSeqVelKick2.st01(3);}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqKick2But02.free;
		~ifSeqKick2But02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_02 = ~cntSeqVelKick2_02 + 1;
				~cntSeqVelKick2_02.switch(
					0,{},
					1, {IFSeqVelKick2.st02(1);},
					2, {IFSeqVelKick2.st02(2);},
					3, {IFSeqVelKick2.st02(3);}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqKick2But03.free;
		~ifSeqKick2But03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_03 = ~cntSeqVelKick2_03 + 1;
				~cntSeqVelKick2_03.switch(
					0,{},
					1, {IFSeqVelKick2.st03(1);},
					2, {IFSeqVelKick2.st03(2);},
					3, {IFSeqVelKick2.st03(3);}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqKick2But04.free;
		~ifSeqKick2But04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_04 = ~cntSeqVelKick2_04 + 1;
				~cntSeqVelKick2_04.switch(
					0,{},
					1, {IFSeqVelKick2.st04(1);},
					2, {IFSeqVelKick2.st04(2);},
					3, {IFSeqVelKick2.st04(3);}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqKick2But05.free;
		~ifSeqKick2But05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_05 = ~cntSeqVelKick2_05 + 1;
				~cntSeqVelKick2_05.switch(
					0,{},
					1, {IFSeqVelKick2.st05(1);},
					2, {IFSeqVelKick2.st05(2);},
					3, {IFSeqVelKick2.st05(3);}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqKick2But06.free;
		~ifSeqKick2But06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_06 = ~cntSeqVelKick2_06 + 1;
				~cntSeqVelKick2_06.switch(
					0,{},
					1, {IFSeqVelKick2.st06(1);},
					2, {IFSeqVelKick2.st06(2);},
					3, {IFSeqVelKick2.st06(3);}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqKick2But07.free;
		~ifSeqKick2But07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_07 = ~cntSeqVelKick2_07 + 1;
				~cntSeqVelKick2_07.switch(
					0,{},
					1, {IFSeqVelKick2.st07(1);},
					2, {IFSeqVelKick2.st07(2);},
					3, {IFSeqVelKick2.st07(3);}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqKick2But08.free;
		~ifSeqKick2But08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_08 = ~cntSeqVelKick2_08 + 1;
				~cntSeqVelKick2_08.switch(
					0,{},
					1, {IFSeqVelKick2.st08(1);},
					2, {IFSeqVelKick2.st08(2);},
					3, {IFSeqVelKick2.st08(3);}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqKick2But09.free;
		~ifSeqKick2But09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_09 = ~cntSeqVelKick2_09 + 1;
				~cntSeqVelKick2_09.switch(
					0,{},
					1, {IFSeqVelKick2.st09(1);},
					2, {IFSeqVelKick2.st09(2);},
					3, {IFSeqVelKick2.st09(3);}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqKick2But10.free;
		~ifSeqKick2But10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_10 = ~cntSeqVelKick2_10 + 1;
				~cntSeqVelKick2_10.switch(
					0,{},
					1, {IFSeqVelKick2.st10(1);},
					2, {IFSeqVelKick2.st10(2);},
					3, {IFSeqVelKick2.st10(3);}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqKick2But11.free;
		~ifSeqKick2But11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_11 = ~cntSeqVelKick2_11 + 1;
				~cntSeqVelKick2_11.switch(
					0,{},
					1, {IFSeqVelKick2.st11(1);},
					2, {IFSeqVelKick2.st11(2);},
					3, {IFSeqVelKick2.st11(3);}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqKick2But12.free;
		~ifSeqKick2But12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_12 = ~cntSeqVelKick2_12 + 1;
				~cntSeqVelKick2_12.switch(
					0,{},
					1, {IFSeqVelKick2.st12(1);},
					2, {IFSeqVelKick2.st12(2);},
					3, {IFSeqVelKick2.st12(3);}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqKick2But13.free;
		~ifSeqKick2But13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_13 = ~cntSeqVelKick2_13 + 1;
				~cntSeqVelKick2_13.switch(
					0,{},
					1, {IFSeqVelKick2.st13(1);},
					2, {IFSeqVelKick2.st13(2);},
					3, {IFSeqVelKick2.st13(3);}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqKick2But14.free;
		~ifSeqKick2But14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_14 = ~cntSeqVelKick2_14 + 1;
				~cntSeqVelKick2_14.switch(
					0,{},
					1, {IFSeqVelKick2.st14(1);},
					2, {IFSeqVelKick2.st14(2);},
					3, {IFSeqVelKick2.st14(3);}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqKick2But15.free;
		~ifSeqKick2But15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_15 = ~cntSeqVelKick2_15 + 1;
				~cntSeqVelKick2_15.switch(
					0,{},
					1, {IFSeqVelKick2.st15(1);},
					2, {IFSeqVelKick2.st15(2);},
					3, {IFSeqVelKick2.st15(3);}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqKick2But16.free;
		~ifSeqKick2But16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick2_16 = ~cntSeqVelKick2_16 + 1;
				~cntSeqVelKick2_16.switch(
					0,{},
					1, {IFSeqVelKick2.st16(1);},
					2, {IFSeqVelKick2.st16(2);},
					3, {IFSeqVelKick2.st16(3);}
				)}
			);
			},
			'/ifSeq/2/16'
		);


	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick01', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick01', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick01', '3');
		}

	}

	*st02 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick02', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick02', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick02', '3');
		}

	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick03', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick03', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick03', '3');
		}

	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick04', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick04', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick04', '3');
		}

	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick05', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick05', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick05', '3');
		}

	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick06', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick06', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick06', '3');
		}

	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick07', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick07', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick07', '3');
		}

	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick08', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick08', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick08', '3');
		}

	}
	*st09 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick09', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick09', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick09', '3');
		}

	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick10', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick10', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick10', '3');
		}

	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick11', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick11', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick11', '3');
		}

	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick12', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick12', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick12', '3');
		}

	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick13', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick13', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick13', '3');
		}

	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick14', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick14', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick14', '3');
		}

	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick15', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick15', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick15', '3');
		}

	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqVelKick2_16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick16', '1');
		}
		{ i == 2 }  {
			~seqVelKick2_16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick16', '2');
		}
		{ i == 3 }  {
			~seqVelKick2_16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick16', '3');
		}

	}
	*stGrp {|i|
		IFSeqVelKick2.st01(i); IFSeqVelKick2.st02(i); IFSeqVelKick2.st03(i); IFSeqVelKick2.st04(i);
		IFSeqVelKick2.st05(i); IFSeqVelKick2.st06(i); IFSeqVelKick2.st07(i); IFSeqVelKick2.st08(i);
		IFSeqVelKick2.st09(i); IFSeqVelKick2.st10(i); IFSeqVelKick2.st11(i); IFSeqVelKick2.st12(i);
		IFSeqVelKick2.st13(i); IFSeqVelKick2.st14(i); IFSeqVelKick2.st15(i); IFSeqVelKick2.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqVelKick2.st01(s01); IFSeqVelKick2.st02(s02); IFSeqVelKick2.st03(s03); IFSeqVelKick2.st04(s04);
		IFSeqVelKick2.st05(s05); IFSeqVelKick2.st06(s06); IFSeqVelKick2.st07(s07); IFSeqVelKick2.st08(s08);
		IFSeqVelKick2.st09(s09); IFSeqVelKick2.st10(s10); IFSeqVelKick2.st11(s11); IFSeqVelKick2.st12(s12);
		IFSeqVelKick2.st13(s13); IFSeqVelKick2.st14(s14); IFSeqVelKick2.st15(s15); IFSeqVelKick2.st16(s16);
	}
}