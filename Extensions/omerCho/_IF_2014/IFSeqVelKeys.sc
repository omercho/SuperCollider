IFSeqVelKeys {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVelKeys01 = PatternProxy( Pseq([1], 1));
		~seqVelKeys02 = PatternProxy( Pseq([1], 1));
		~seqVelKeys03 = PatternProxy( Pseq([1], 1));
		~seqVelKeys04 = PatternProxy( Pseq([1], 1));
		~seqVelKeys05 = PatternProxy( Pseq([1], 1));
		~seqVelKeys06 = PatternProxy( Pseq([1], 1));
		~seqVelKeys07 = PatternProxy( Pseq([1], 1));
		~seqVelKeys08 = PatternProxy( Pseq([1], 1));

		~seqVelKeys09 = PatternProxy( Pseq([1], 1));
		~seqVelKeys10 = PatternProxy( Pseq([1], 1));
		~seqVelKeys11 = PatternProxy( Pseq([1], 1));
		~seqVelKeys12 = PatternProxy( Pseq([1], 1));
		~seqVelKeys13 = PatternProxy( Pseq([1], 1));
		~seqVelKeys14 = PatternProxy( Pseq([1], 1));
		~seqVelKeys15 = PatternProxy( Pseq([1], 1));
		~seqVelKeys16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqVelUpKeys01=0;
		~cntSeqVelRandKeys01=0;

		~cntSeqVelKeys01=0;
		~cntSeqVelKeys02=0;
		~cntSeqVelKeys03=0;
		~cntSeqVelKeys04=0;
		~cntSeqVelKeys05=0;
		~cntSeqVelKeys06=0;
		~cntSeqVelKeys07=0;
		~cntSeqVelKeys08=0;

		~cntSeqVelKeys09=0;
		~cntSeqVelKeys10=0;
		~cntSeqVelKeys11=0;
		~cntSeqVelKeys12=0;
		~cntSeqVelKeys13=0;
		~cntSeqVelKeys14=0;
		~cntSeqVelKeys15=0;
		~cntSeqVelKeys16=0;
	}
	*freeOn {
		~seqFreeKeysBut.free;
		~seqFreeKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVelKeys.stGrp(1);
				});
			},
			'/seqFreeKeys'
		);
	}
	*upOn {
		~ifSeqUpKeysBut.free;
		~ifSeqUpKeysBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelUpKeys01 = ~cntSeqVelUpKeys01 + 1;
				~cntSeqVelUpKeys01.switch(
					0,{},
					1,{IFSeqVelKeys.stGrp(1);},
					2,{IFSeqVelKeys.stGrp(2);},
					3,{IFSeqVelKeys.stGrp(3);
						~cntSeqVelUpKeys01=0;
					}
				)}
			);
			},
			'/seqUpKeys'
		);
	}

	*randOn {
		~ifSeqRandKeysBut.free;
		~ifSeqRandKeysBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelRandKeys01 = ~cntSeqVelRandKeys01 + 1;
				~cntSeqVelRandKeys01.switch(
					0,{},
					1,{
						IFSeqVelKeys.st01([1,2,3].choose);
						IFSeqVelKeys.st02([1,2,3].choose);
						IFSeqVelKeys.st03([1,2,3].choose);
						IFSeqVelKeys.st04([1,2,3].choose);
						IFSeqVelKeys.st05([1,2,3].choose);
						IFSeqVelKeys.st06([1,2,3].choose);
						IFSeqVelKeys.st07([1,2,3].choose);
						IFSeqVelKeys.st08([1,2,3].choose);

						IFSeqVelKeys.st09([1,2,3].choose);
						IFSeqVelKeys.st10([1,2,3].choose);
						IFSeqVelKeys.st11([1,2,3].choose);
						IFSeqVelKeys.st12([1,2,3].choose);
						IFSeqVelKeys.st13([1,2,3].choose);
						IFSeqVelKeys.st14([1,2,3].choose);
						IFSeqVelKeys.st15([1,2,3].choose);
						IFSeqVelKeys.st16([1,2,3].choose);
						~cntSeqVelRandKeys01=0;
					}
				)}
			);
			},
			'/seqRandKeys'
		);
	}


	*on { // Shift Velocity

		IFSeqVelKeys.randOn;
		IFSeqVelKeys.upOn;
		IFSeqVelKeys.freeOn;

		~ifSeqKeysBut01.free;
		~ifSeqKeysBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys01 = ~cntSeqVelKeys01 + 1;
				~cntSeqVelKeys01.switch(
					0,{},
					1, {IFSeqVelKeys.st01(1);},
					2, {IFSeqVelKeys.st01(2);},
					3, {IFSeqVelKeys.st01(3);}
				)}
			);
			},
			'/ifSeq/5/1'
		);
		~ifSeqKeysBut02.free;
		~ifSeqKeysBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys02 = ~cntSeqVelKeys02 + 1;
				~cntSeqVelKeys02.switch(
					0,{},
					1, {IFSeqVelKeys.st02(1);},
					2, {IFSeqVelKeys.st02(2);},
					3, {IFSeqVelKeys.st02(3);}
				)}
			);
			},
			'/ifSeq/5/2'
		);
		~ifSeqKeysBut03.free;
		~ifSeqKeysBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys03 = ~cntSeqVelKeys03 + 1;
				~cntSeqVelKeys03.switch(
					0,{},
					1, {IFSeqVelKeys.st03(1);},
					2, {IFSeqVelKeys.st03(2);},
					3, {IFSeqVelKeys.st03(3);}
				)}
			);
			},
			'/ifSeq/5/3'
		);
		~ifSeqKeysBut04.free;
		~ifSeqKeysBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys04 = ~cntSeqVelKeys04 + 1;
				~cntSeqVelKeys04.switch(
					0,{},
					1, {IFSeqVelKeys.st04(1);},
					2, {IFSeqVelKeys.st04(2);},
					3, {IFSeqVelKeys.st04(3);}
				)}
			);
			},
			'/ifSeq/5/4'
		);
		~ifSeqKeysBut05.free;
		~ifSeqKeysBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys05 = ~cntSeqVelKeys05 + 1;
				~cntSeqVelKeys05.switch(
					0,{},
					1, {IFSeqVelKeys.st05(1);},
					2, {IFSeqVelKeys.st05(2);},
					3, {IFSeqVelKeys.st05(3);}
				)}
			);
			},
			'/ifSeq/5/5'
		);
		~ifSeqKeysBut06.free;
		~ifSeqKeysBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys06 = ~cntSeqVelKeys06 + 1;
				~cntSeqVelKeys06.switch(
					0,{},
					1, {IFSeqVelKeys.st06(1);},
					2, {IFSeqVelKeys.st06(2);},
					3, {IFSeqVelKeys.st06(3);}
				)}
			);
			},
			'/ifSeq/5/6'
		);
		~ifSeqKeysBut07.free;
		~ifSeqKeysBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys07 = ~cntSeqVelKeys07 + 1;
				~cntSeqVelKeys07.switch(
					0,{},
					1, {IFSeqVelKeys.st07(1);},
					2, {IFSeqVelKeys.st07(2);},
					3, {IFSeqVelKeys.st07(3);}
				)}
			);
			},
			'/ifSeq/5/7'
		);
		~ifSeqKeysBut08.free;
		~ifSeqKeysBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys08 = ~cntSeqVelKeys08 + 1;
				~cntSeqVelKeys08.switch(
					0,{},
					1, {IFSeqVelKeys.st08(1);},
					2, {IFSeqVelKeys.st08(2);},
					3, {IFSeqVelKeys.st08(3);}
				)}
			);
			},
			'/ifSeq/5/8'
		);

		~ifSeqKeysBut09.free;
		~ifSeqKeysBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys09 = ~cntSeqVelKeys09 + 1;
				~cntSeqVelKeys09.switch(
					0,{},
					1, {IFSeqVelKeys.st09(1);},
					2, {IFSeqVelKeys.st09(2);},
					3, {IFSeqVelKeys.st09(3);}
				)}
			);
			},
			'/ifSeq/5/9'
		);
		~ifSeqKeysBut10.free;
		~ifSeqKeysBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys10 = ~cntSeqVelKeys10 + 1;
				~cntSeqVelKeys10.switch(
					0,{},
					1, {IFSeqVelKeys.st10(1);},
					2, {IFSeqVelKeys.st10(2);},
					3, {IFSeqVelKeys.st10(3);}
				)}
			);
			},
			'/ifSeq/5/10'
		);
		~ifSeqKeysBut11.free;
		~ifSeqKeysBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys11 = ~cntSeqVelKeys11 + 1;
				~cntSeqVelKeys11.switch(
					0,{},
					1, {IFSeqVelKeys.st11(1);},
					2, {IFSeqVelKeys.st11(2);},
					3, {IFSeqVelKeys.st11(3);}
				)}
			);
			},
			'/ifSeq/5/11'
		);
		~ifSeqKeysBut12.free;
		~ifSeqKeysBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys12 = ~cntSeqVelKeys12 + 1;
				~cntSeqVelKeys12.switch(
					0,{},
					1, {IFSeqVelKeys.st12(1);},
					2, {IFSeqVelKeys.st12(2);},
					3, {IFSeqVelKeys.st12(3);}
				)}
			);
			},
			'/ifSeq/5/12'
		);
		~ifSeqKeysBut13.free;
		~ifSeqKeysBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys13 = ~cntSeqVelKeys13 + 1;
				~cntSeqVelKeys13.switch(
					0,{},
					1, {IFSeqVelKeys.st13(1);},
					2, {IFSeqVelKeys.st13(2);},
					3, {IFSeqVelKeys.st13(3);}
				)}
			);
			},
			'/ifSeq/5/13'
		);
		~ifSeqKeysBut14.free;
		~ifSeqKeysBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys14 = ~cntSeqVelKeys14 + 1;
				~cntSeqVelKeys14.switch(
					0,{},
					1, {IFSeqVelKeys.st14(1);},
					2, {IFSeqVelKeys.st14(2);},
					3, {IFSeqVelKeys.st14(3);}
				)}
			);
			},
			'/ifSeq/5/14'
		);
		~ifSeqKeysBut15.free;
		~ifSeqKeysBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys15 = ~cntSeqVelKeys15 + 1;
				~cntSeqVelKeys15.switch(
					0,{},
					1, {IFSeqVelKeys.st15(1);},
					2, {IFSeqVelKeys.st15(2);},
					3, {IFSeqVelKeys.st15(3);}
				)}
			);
			},
			'/ifSeq/5/15'
		);
		~ifSeqKeysBut16.free;
		~ifSeqKeysBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelKeys16 = ~cntSeqVelKeys16 + 1;
				~cntSeqVelKeys16.switch(
					0,{},
					1, {IFSeqVelKeys.st16(1);},
					2, {IFSeqVelKeys.st16(2);},
					3, {IFSeqVelKeys.st16(3);}
				)}
			);
			},
			'/ifSeq/5/16'
		);


	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys01', '1');
		}
		{ i == 2 }  {
			~seqVelKeys01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys01', '2');
		}
		{ i == 3 }  {
			~seqVelKeys01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys01', '3');
		}

	}

	*st02 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys02', '1');
		}
		{ i == 2 }  {
			~seqVelKeys02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys02', '2');
		}
		{ i == 3 }  {
			~seqVelKeys02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys02', '3');
		}

	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys03', '1');
		}
		{ i == 2 }  {
			~seqVelKeys03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys03', '2');
		}
		{ i == 3 }  {
			~seqVelKeys03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys03', '3');
		}

	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys04', '1');
		}
		{ i == 2 }  {
			~seqVelKeys04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys04', '2');
		}
		{ i == 3 }  {
			~seqVelKeys04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys04', '3');
		}

	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys05', '1');
		}
		{ i == 2 }  {
			~seqVelKeys05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys05', '2');
		}
		{ i == 3 }  {
			~seqVelKeys05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys05', '3');
		}

	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys06', '1');
		}
		{ i == 2 }  {
			~seqVelKeys06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys06', '2');
		}
		{ i == 3 }  {
			~seqVelKeys06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys06', '3');
		}

	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys07', '1');
		}
		{ i == 2 }  {
			~seqVelKeys07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys07', '2');
		}
		{ i == 3 }  {
			~seqVelKeys07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys07', '3');
		}

	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys08', '1');
		}
		{ i == 2 }  {
			~seqVelKeys08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys08', '2');
		}
		{ i == 3 }  {
			~seqVelKeys08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys08', '3');
		}

	}
	*st09 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys09', '1');
		}
		{ i == 2 }  {
			~seqVelKeys09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys09', '2');
		}
		{ i == 3 }  {
			~seqVelKeys09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys09', '3');
		}

	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys10', '1');
		}
		{ i == 2 }  {
			~seqVelKeys10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys10', '2');
		}
		{ i == 3 }  {
			~seqVelKeys10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys10', '3');
		}

	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys11', '1');
		}
		{ i == 2 }  {
			~seqVelKeys11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys11', '2');
		}
		{ i == 3 }  {
			~seqVelKeys11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys11', '3');
		}

	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys12', '1');
		}
		{ i == 2 }  {
			~seqVelKeys12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys12', '2');
		}
		{ i == 3 }  {
			~seqVelKeys12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys12', '3');
		}

	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys13', '1');
		}
		{ i == 2 }  {
			~seqVelKeys13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys13', '2');
		}
		{ i == 3 }  {
			~seqVelKeys13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys13', '3');
		}

	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys14', '1');
		}
		{ i == 2 }  {
			~seqVelKeys14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys14', '2');
		}
		{ i == 3 }  {
			~seqVelKeys14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys14', '3');
		}

	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys15', '1');
		}
		{ i == 2 }  {
			~seqVelKeys15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys15', '2');
		}
		{ i == 3 }  {
			~seqVelKeys15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys15', '3');
		}

	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqVelKeys16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelKeys16', '1');
		}
		{ i == 2 }  {
			~seqVelKeys16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelKeys16', '2');
		}
		{ i == 3 }  {
			~seqVelKeys16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelKeys16', '3');
		}

	}
	*stGrp {|i|
		IFSeqVelKeys.st01(i); IFSeqVelKeys.st02(i); IFSeqVelKeys.st03(i); IFSeqVelKeys.st04(i);
		IFSeqVelKeys.st05(i); IFSeqVelKeys.st06(i); IFSeqVelKeys.st07(i); IFSeqVelKeys.st08(i);
		IFSeqVelKeys.st09(i); IFSeqVelKeys.st10(i); IFSeqVelKeys.st11(i); IFSeqVelKeys.st12(i);
		IFSeqVelKeys.st13(i); IFSeqVelKeys.st14(i); IFSeqVelKeys.st15(i); IFSeqVelKeys.st16(i);
	}
}