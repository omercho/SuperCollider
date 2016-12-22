IFSeqVelKick {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVelKick01 = PatternProxy( Pseq([1], 1));
		~seqVelKick02 = PatternProxy( Pseq([1], 1));
		~seqVelKick03 = PatternProxy( Pseq([1], 1));
		~seqVelKick04 = PatternProxy( Pseq([1], 1));
		~seqVelKick05 = PatternProxy( Pseq([1], 1));
		~seqVelKick06 = PatternProxy( Pseq([1], 1));
		~seqVelKick07 = PatternProxy( Pseq([1], 1));
		~seqVelKick08 = PatternProxy( Pseq([1], 1));

		~seqVelKick09 = PatternProxy( Pseq([1], 1));
		~seqVelKick10 = PatternProxy( Pseq([1], 1));
		~seqVelKick11 = PatternProxy( Pseq([1], 1));
		~seqVelKick12 = PatternProxy( Pseq([1], 1));
		~seqVelKick13 = PatternProxy( Pseq([1], 1));
		~seqVelKick14 = PatternProxy( Pseq([1], 1));
		~seqVelKick15 = PatternProxy( Pseq([1], 1));
		~seqVelKick16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqVelUpKick01=0;
		~cntSeqVelRandKick01=0;

		~cntSeqVelKick01=0;
		~cntSeqVelKick02=0;
		~cntSeqVelKick03=0;
		~cntSeqVelKick04=0;
		~cntSeqVelKick05=0;
		~cntSeqVelKick06=0;
		~cntSeqVelKick07=0;
		~cntSeqVelKick08=0;

		~cntSeqVelKick09=0;
		~cntSeqVelKick10=0;
		~cntSeqVelKick11=0;
		~cntSeqVelKick12=0;
		~cntSeqVelKick13=0;
		~cntSeqVelKick14=0;
		~cntSeqVelKick15=0;
		~cntSeqVelKick16=0;
	}
	*freeOn {
		~seqFreeKickBut.free;
		~seqFreeKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVelKick.stGrp(1);
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
				~cntSeqVelUpKick01 = ~cntSeqVelUpKick01 + 1;
				~cntSeqVelUpKick01.switch(
					0,{},
					1,{IFSeqVelKick.stGrp(1);},
					2,{IFSeqVelKick.stGrp(2);},
					3,{IFSeqVelKick.stGrp(3);
						~cntSeqVelUpKick01=0;
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
				~cntSeqVelRandKick01 = ~cntSeqVelRandKick01 + 1;
				~cntSeqVelRandKick01.switch(
					0,{},
					1,{
						IFSeqVelKick.st01([1,2,3].choose);
						IFSeqVelKick.st02([1,2,3].choose);
						IFSeqVelKick.st03([1,2,3].choose);
						IFSeqVelKick.st04([1,2,3].choose);
						IFSeqVelKick.st05([1,2,3].choose);
						IFSeqVelKick.st06([1,2,3].choose);
						IFSeqVelKick.st07([1,2,3].choose);
						IFSeqVelKick.st08([1,2,3].choose);

						IFSeqVelKick.st09([1,2,3].choose);
						IFSeqVelKick.st10([1,2,3].choose);
						IFSeqVelKick.st11([1,2,3].choose);
						IFSeqVelKick.st12([1,2,3].choose);
						IFSeqVelKick.st13([1,2,3].choose);
						IFSeqVelKick.st14([1,2,3].choose);
						IFSeqVelKick.st15([1,2,3].choose);
						IFSeqVelKick.st16([1,2,3].choose);
						~cntSeqVelRandKick01=0;
					}
				)}
			);
			},
			'/seqRandKick'
		);
	}


	*on { // Shift Velocity

		IFSeqVelKick.randOn;
		IFSeqVelKick.upOn;
		IFSeqVelKick.freeOn;

		~ifSeqKickBut01.free;
		~ifSeqKickBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick01 = ~cntSeqVelKick01 + 1;
				~cntSeqVelKick01.switch(
					0,{},
					1, {IFSeqVelKick.st01(1);},
					2, {IFSeqVelKick.st01(2);},
					3, {IFSeqVelKick.st01(3);}
				)}
			);
			},
			'/ifSeq/1/1'
		);
		~ifSeqKickBut02.free;
		~ifSeqKickBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick02 = ~cntSeqVelKick02 + 1;
				~cntSeqVelKick02.switch(
					0,{},
					1, {IFSeqVelKick.st02(1);},
					2, {IFSeqVelKick.st02(2);},
					3, {IFSeqVelKick.st02(3);}
				)}
			);
			},
			'/ifSeq/1/2'
		);
		~ifSeqKickBut03.free;
		~ifSeqKickBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick03 = ~cntSeqVelKick03 + 1;
				~cntSeqVelKick03.switch(
					0,{},
					1, {IFSeqVelKick.st03(1);},
					2, {IFSeqVelKick.st03(2);},
					3, {IFSeqVelKick.st03(3);}
				)}
			);
			},
			'/ifSeq/1/3'
		);
		~ifSeqKickBut04.free;
		~ifSeqKickBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick04 = ~cntSeqVelKick04 + 1;
				~cntSeqVelKick04.switch(
					0,{},
					1, {IFSeqVelKick.st04(1);},
					2, {IFSeqVelKick.st04(2);},
					3, {IFSeqVelKick.st04(3);}
				)}
			);
			},
			'/ifSeq/1/4'
		);
		~ifSeqKickBut05.free;
		~ifSeqKickBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick05 = ~cntSeqVelKick05 + 1;
				~cntSeqVelKick05.switch(
					0,{},
					1, {IFSeqVelKick.st05(1);},
					2, {IFSeqVelKick.st05(2);},
					3, {IFSeqVelKick.st05(3);}
				)}
			);
			},
			'/ifSeq/1/5'
		);
		~ifSeqKickBut06.free;
		~ifSeqKickBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick06 = ~cntSeqVelKick06 + 1;
				~cntSeqVelKick06.switch(
					0,{},
					1, {IFSeqVelKick.st06(1);},
					2, {IFSeqVelKick.st06(2);},
					3, {IFSeqVelKick.st06(3);}
				)}
			);
			},
			'/ifSeq/1/6'
		);
		~ifSeqKickBut07.free;
		~ifSeqKickBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick07 = ~cntSeqVelKick07 + 1;
				~cntSeqVelKick07.switch(
					0,{},
					1, {IFSeqVelKick.st07(1);},
					2, {IFSeqVelKick.st07(2);},
					3, {IFSeqVelKick.st07(3);}
				)}
			);
			},
			'/ifSeq/1/7'
		);
		~ifSeqKickBut08.free;
		~ifSeqKickBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick08 = ~cntSeqVelKick08 + 1;
				~cntSeqVelKick08.switch(
					0,{},
					1, {IFSeqVelKick.st08(1);},
					2, {IFSeqVelKick.st08(2);},
					3, {IFSeqVelKick.st08(3);}
				)}
			);
			},
			'/ifSeq/1/8'
		);

		~ifSeqKickBut09.free;
		~ifSeqKickBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick09 = ~cntSeqVelKick09 + 1;
				~cntSeqVelKick09.switch(
					0,{},
					1, {IFSeqVelKick.st09(1);},
					2, {IFSeqVelKick.st09(2);},
					3, {IFSeqVelKick.st09(3);}
				)}
			);
			},
			'/ifSeq/1/9'
		);
		~ifSeqKickBut10.free;
		~ifSeqKickBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick10 = ~cntSeqVelKick10 + 1;
				~cntSeqVelKick10.switch(
					0,{},
					1, {IFSeqVelKick.st10(1);},
					2, {IFSeqVelKick.st10(2);},
					3, {IFSeqVelKick.st10(3);}
				)}
			);
			},
			'/ifSeq/1/10'
		);
		~ifSeqKickBut11.free;
		~ifSeqKickBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick11 = ~cntSeqVelKick11 + 1;
				~cntSeqVelKick11.switch(
					0,{},
					1, {IFSeqVelKick.st11(1);},
					2, {IFSeqVelKick.st11(2);},
					3, {IFSeqVelKick.st11(3);}
				)}
			);
			},
			'/ifSeq/1/11'
		);
		~ifSeqKickBut12.free;
		~ifSeqKickBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick12 = ~cntSeqVelKick12 + 1;
				~cntSeqVelKick12.switch(
					0,{},
					1, {IFSeqVelKick.st12(1);},
					2, {IFSeqVelKick.st12(2);},
					3, {IFSeqVelKick.st12(3);}
				)}
			);
			},
			'/ifSeq/1/12'
		);
		~ifSeqKickBut13.free;
		~ifSeqKickBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick13 = ~cntSeqVelKick13 + 1;
				~cntSeqVelKick13.switch(
					0,{},
					1, {IFSeqVelKick.st13(1);},
					2, {IFSeqVelKick.st13(2);},
					3, {IFSeqVelKick.st13(3);}
				)}
			);
			},
			'/ifSeq/1/13'
		);
		~ifSeqKickBut14.free;
		~ifSeqKickBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick14 = ~cntSeqVelKick14 + 1;
				~cntSeqVelKick14.switch(
					0,{},
					1, {IFSeqVelKick.st14(1);},
					2, {IFSeqVelKick.st14(2);},
					3, {IFSeqVelKick.st14(3);}
				)}
			);
			},
			'/ifSeq/1/14'
		);
		~ifSeqKickBut15.free;
		~ifSeqKickBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick15 = ~cntSeqVelKick15 + 1;
				~cntSeqVelKick15.switch(
					0,{},
					1, {IFSeqVelKick.st15(1);},
					2, {IFSeqVelKick.st15(2);},
					3, {IFSeqVelKick.st15(3);}
				)}
			);
			},
			'/ifSeq/1/15'
		);
		~ifSeqKickBut16.free;
		~ifSeqKickBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKick16 = ~cntSeqVelKick16 + 1;
				~cntSeqVelKick16.switch(
					0,{},
					1, {IFSeqVelKick.st16(1);},
					2, {IFSeqVelKick.st16(2);},
					3, {IFSeqVelKick.st16(3);}
				)}
			);
			},
			'/ifSeq/1/16'
		);


	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqVelKick01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick01', '1');
		}
		{ i == 2 }  {
			~seqVelKick01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick01', '2');
		}
		{ i == 3 }  {
			~seqVelKick01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick01', '3');
		}

	}

	*st02 {|i|
		case
		{ i == 1 }  {
			~seqVelKick02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick02', '1');
		}
		{ i == 2 }  {
			~seqVelKick02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick02', '2');
		}
		{ i == 3 }  {
			~seqVelKick02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick02', '3');
		}

	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqVelKick03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick03', '1');
		}
		{ i == 2 }  {
			~seqVelKick03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick03', '2');
		}
		{ i == 3 }  {
			~seqVelKick03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick03', '3');
		}

	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqVelKick04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick04', '1');
		}
		{ i == 2 }  {
			~seqVelKick04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick04', '2');
		}
		{ i == 3 }  {
			~seqVelKick04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick04', '3');
		}

	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqVelKick05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick05', '1');
		}
		{ i == 2 }  {
			~seqVelKick05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick05', '2');
		}
		{ i == 3 }  {
			~seqVelKick05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick05', '3');
		}

	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqVelKick06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick06', '1');
		}
		{ i == 2 }  {
			~seqVelKick06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick06', '2');
		}
		{ i == 3 }  {
			~seqVelKick06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick06', '3');
		}

	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqVelKick07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick07', '1');
		}
		{ i == 2 }  {
			~seqVelKick07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick07', '2');
		}
		{ i == 3 }  {
			~seqVelKick07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick07', '3');
		}

	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqVelKick08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick08', '1');
		}
		{ i == 2 }  {
			~seqVelKick08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick08', '2');
		}
		{ i == 3 }  {
			~seqVelKick08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick08', '3');
		}

	}
	*st09 {|i|
		case
		{ i == 1 }  {
			~seqVelKick09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick09', '1');
		}
		{ i == 2 }  {
			~seqVelKick09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick09', '2');
		}
		{ i == 3 }  {
			~seqVelKick09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick09', '3');
		}

	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqVelKick10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick10', '1');
		}
		{ i == 2 }  {
			~seqVelKick10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick10', '2');
		}
		{ i == 3 }  {
			~seqVelKick10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick10', '3');
		}

	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqVelKick11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick11', '1');
		}
		{ i == 2 }  {
			~seqVelKick11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick11', '2');
		}
		{ i == 3 }  {
			~seqVelKick11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick11', '3');
		}

	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqVelKick12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick12', '1');
		}
		{ i == 2 }  {
			~seqVelKick12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick12', '2');
		}
		{ i == 3 }  {
			~seqVelKick12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick12', '3');
		}

	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqVelKick13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick13', '1');
		}
		{ i == 2 }  {
			~seqVelKick13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick13', '2');
		}
		{ i == 3 }  {
			~seqVelKick13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick13', '3');
		}

	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqVelKick14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick14', '1');
		}
		{ i == 2 }  {
			~seqVelKick14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick14', '2');
		}
		{ i == 3 }  {
			~seqVelKick14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick14', '3');
		}

	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqVelKick15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick15', '1');
		}
		{ i == 2 }  {
			~seqVelKick15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick15', '2');
		}
		{ i == 3 }  {
			~seqVelKick15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick15', '3');
		}

	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqVelKick16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKick16', '1');
		}
		{ i == 2 }  {
			~seqVelKick16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKick16', '2');
		}
		{ i == 3 }  {
			~seqVelKick16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKick16', '3');
		}

	}
	*stGrp {|i|
		IFSeqVelKick.st01(i); IFSeqVelKick.st02(i); IFSeqVelKick.st03(i); IFSeqVelKick.st04(i);
		IFSeqVelKick.st05(i); IFSeqVelKick.st06(i); IFSeqVelKick.st07(i); IFSeqVelKick.st08(i);
		IFSeqVelKick.st09(i); IFSeqVelKick.st10(i); IFSeqVelKick.st11(i); IFSeqVelKick.st12(i);
		IFSeqVelKick.st13(i); IFSeqVelKick.st14(i); IFSeqVelKick.st15(i); IFSeqVelKick.st16(i);
	}
}