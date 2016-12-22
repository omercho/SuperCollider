IFSeqVelBass {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVelBass01 = PatternProxy( Pseq([1], 1));
		~seqVelBass02 = PatternProxy( Pseq([1], 1));
		~seqVelBass03 = PatternProxy( Pseq([1], 1));
		~seqVelBass04 = PatternProxy( Pseq([1], 1));
		~seqVelBass05 = PatternProxy( Pseq([1], 1));
		~seqVelBass06 = PatternProxy( Pseq([1], 1));
		~seqVelBass07 = PatternProxy( Pseq([1], 1));
		~seqVelBass08 = PatternProxy( Pseq([1], 1));

		~seqVelBass09 = PatternProxy( Pseq([1], 1));
		~seqVelBass10 = PatternProxy( Pseq([1], 1));
		~seqVelBass11 = PatternProxy( Pseq([1], 1));
		~seqVelBass12 = PatternProxy( Pseq([1], 1));
		~seqVelBass13 = PatternProxy( Pseq([1], 1));
		~seqVelBass14 = PatternProxy( Pseq([1], 1));
		~seqVelBass15 = PatternProxy( Pseq([1], 1));
		~seqVelBass16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqVelUpBass01=0;
		~cntSeqVelRandBass01=0;

		~cntSeqVelBass01=0;
		~cntSeqVelBass02=0;
		~cntSeqVelBass03=0;
		~cntSeqVelBass04=0;
		~cntSeqVelBass05=0;
		~cntSeqVelBass06=0;
		~cntSeqVelBass07=0;
		~cntSeqVelBass08=0;

		~cntSeqVelBass09=0;
		~cntSeqVelBass10=0;
		~cntSeqVelBass11=0;
		~cntSeqVelBass12=0;
		~cntSeqVelBass13=0;
		~cntSeqVelBass14=0;
		~cntSeqVelBass15=0;
		~cntSeqVelBass16=0;
	}
	*freeOn {
		~seqFreeBassBut.free;
		~seqFreeBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVelBass.stGrp(1);
				});
			},
			'/seqFreeBass'
		);
	}
	*upOn {
		~ifSeqUpBassBut.free;
		~ifSeqUpBassBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelUpBass01 = ~cntSeqVelUpBass01 + 1;
				~cntSeqVelUpBass01.switch(
					0,{},
					1,{IFSeqVelBass.stGrp(1);},
					2,{IFSeqVelBass.stGrp(2);},
					3,{IFSeqVelBass.stGrp(3);
						~cntSeqVelUpBass01=0;
					}
				)}
			);
			},
			'/seqUpBass'
		);
	}

	*randOn {
		~ifSeqRandBassBut.free;
		~ifSeqRandBassBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelRandBass01 = ~cntSeqVelRandBass01 + 1;
				~cntSeqVelRandBass01.switch(
					0,{},
					1,{
						IFSeqVelBass.st01([1,2,3].choose);
						IFSeqVelBass.st02([1,2,3].choose);
						IFSeqVelBass.st03([1,2,3].choose);
						IFSeqVelBass.st04([1,2,3].choose);
						IFSeqVelBass.st05([1,2,3].choose);
						IFSeqVelBass.st06([1,2,3].choose);
						IFSeqVelBass.st07([1,2,3].choose);
						IFSeqVelBass.st08([1,2,3].choose);

						IFSeqVelBass.st09([1,2,3].choose);
						IFSeqVelBass.st10([1,2,3].choose);
						IFSeqVelBass.st11([1,2,3].choose);
						IFSeqVelBass.st12([1,2,3].choose);
						IFSeqVelBass.st13([1,2,3].choose);
						IFSeqVelBass.st14([1,2,3].choose);
						IFSeqVelBass.st15([1,2,3].choose);
						IFSeqVelBass.st16([1,2,3].choose);
						~cntSeqVelRandBass01=0;
					}
				)}
			);
			},
			'/seqRandBass'
		);
	}


	*on { // Shift Velocity

		IFSeqVelBass.randOn;
		IFSeqVelBass.upOn;
		IFSeqVelBass.freeOn;

		~ifSeqBassBut01.free;
		~ifSeqBassBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass01 = ~cntSeqVelBass01 + 1;
				~cntSeqVelBass01.switch(
					0,{},
					1, {IFSeqVelBass.st01(1);},
					2, {IFSeqVelBass.st01(2);},
					3, {IFSeqVelBass.st01(3);}
				)}
			);
			},
			'/ifSeq/4/1'
		);
		~ifSeqBassBut02.free;
		~ifSeqBassBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass02 = ~cntSeqVelBass02 + 1;
				~cntSeqVelBass02.switch(
					0,{},
					1, {IFSeqVelBass.st02(1);},
					2, {IFSeqVelBass.st02(2);},
					3, {IFSeqVelBass.st02(3);}
				)}
			);
			},
			'/ifSeq/4/2'
		);
		~ifSeqBassBut03.free;
		~ifSeqBassBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass03 = ~cntSeqVelBass03 + 1;
				~cntSeqVelBass03.switch(
					0,{},
					1, {IFSeqVelBass.st03(1);},
					2, {IFSeqVelBass.st03(2);},
					3, {IFSeqVelBass.st03(3);}
				)}
			);
			},
			'/ifSeq/4/3'
		);
		~ifSeqBassBut04.free;
		~ifSeqBassBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass04 = ~cntSeqVelBass04 + 1;
				~cntSeqVelBass04.switch(
					0,{},
					1, {IFSeqVelBass.st04(1);},
					2, {IFSeqVelBass.st04(2);},
					3, {IFSeqVelBass.st04(3);}
				)}
			);
			},
			'/ifSeq/4/4'
		);
		~ifSeqBassBut05.free;
		~ifSeqBassBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass05 = ~cntSeqVelBass05 + 1;
				~cntSeqVelBass05.switch(
					0,{},
					1, {IFSeqVelBass.st05(1);},
					2, {IFSeqVelBass.st05(2);},
					3, {IFSeqVelBass.st05(3);}
				)}
			);
			},
			'/ifSeq/4/5'
		);
		~ifSeqBassBut06.free;
		~ifSeqBassBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass06 = ~cntSeqVelBass06 + 1;
				~cntSeqVelBass06.switch(
					0,{},
					1, {IFSeqVelBass.st06(1);},
					2, {IFSeqVelBass.st06(2);},
					3, {IFSeqVelBass.st06(3);}
				)}
			);
			},
			'/ifSeq/4/6'
		);
		~ifSeqBassBut07.free;
		~ifSeqBassBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass07 = ~cntSeqVelBass07 + 1;
				~cntSeqVelBass07.switch(
					0,{},
					1, {IFSeqVelBass.st07(1);},
					2, {IFSeqVelBass.st07(2);},
					3, {IFSeqVelBass.st07(3);}
				)}
			);
			},
			'/ifSeq/4/7'
		);
		~ifSeqBassBut08.free;
		~ifSeqBassBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass08 = ~cntSeqVelBass08 + 1;
				~cntSeqVelBass08.switch(
					0,{},
					1, {IFSeqVelBass.st08(1);},
					2, {IFSeqVelBass.st08(2);},
					3, {IFSeqVelBass.st08(3);}
				)}
			);
			},
			'/ifSeq/4/8'
		);

		~ifSeqBassBut09.free;
		~ifSeqBassBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass09 = ~cntSeqVelBass09 + 1;
				~cntSeqVelBass09.switch(
					0,{},
					1, {IFSeqVelBass.st09(1);},
					2, {IFSeqVelBass.st09(2);},
					3, {IFSeqVelBass.st09(3);}
				)}
			);
			},
			'/ifSeq/4/9'
		);
		~ifSeqBassBut10.free;
		~ifSeqBassBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass10 = ~cntSeqVelBass10 + 1;
				~cntSeqVelBass10.switch(
					0,{},
					1, {IFSeqVelBass.st10(1);},
					2, {IFSeqVelBass.st10(2);},
					3, {IFSeqVelBass.st10(3);}
				)}
			);
			},
			'/ifSeq/4/10'
		);
		~ifSeqBassBut11.free;
		~ifSeqBassBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass11 = ~cntSeqVelBass11 + 1;
				~cntSeqVelBass11.switch(
					0,{},
					1, {IFSeqVelBass.st11(1);},
					2, {IFSeqVelBass.st11(2);},
					3, {IFSeqVelBass.st11(3);}
				)}
			);
			},
			'/ifSeq/4/11'
		);
		~ifSeqBassBut12.free;
		~ifSeqBassBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass12 = ~cntSeqVelBass12 + 1;
				~cntSeqVelBass12.switch(
					0,{},
					1, {IFSeqVelBass.st12(1);},
					2, {IFSeqVelBass.st12(2);},
					3, {IFSeqVelBass.st12(3);}
				)}
			);
			},
			'/ifSeq/4/12'
		);
		~ifSeqBassBut13.free;
		~ifSeqBassBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass13 = ~cntSeqVelBass13 + 1;
				~cntSeqVelBass13.switch(
					0,{},
					1, {IFSeqVelBass.st13(1);},
					2, {IFSeqVelBass.st13(2);},
					3, {IFSeqVelBass.st13(3);}
				)}
			);
			},
			'/ifSeq/4/13'
		);
		~ifSeqBassBut14.free;
		~ifSeqBassBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass14 = ~cntSeqVelBass14 + 1;
				~cntSeqVelBass14.switch(
					0,{},
					1, {IFSeqVelBass.st14(1);},
					2, {IFSeqVelBass.st14(2);},
					3, {IFSeqVelBass.st14(3);}
				)}
			);
			},
			'/ifSeq/4/14'
		);
		~ifSeqBassBut15.free;
		~ifSeqBassBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass15 = ~cntSeqVelBass15 + 1;
				~cntSeqVelBass15.switch(
					0,{},
					1, {IFSeqVelBass.st15(1);},
					2, {IFSeqVelBass.st15(2);},
					3, {IFSeqVelBass.st15(3);}
				)}
			);
			},
			'/ifSeq/4/15'
		);
		~ifSeqBassBut16.free;
		~ifSeqBassBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelBass16 = ~cntSeqVelBass16 + 1;
				~cntSeqVelBass16.switch(
					0,{},
					1, {IFSeqVelBass.st16(1);},
					2, {IFSeqVelBass.st16(2);},
					3, {IFSeqVelBass.st16(3);}
				)}
			);
			},
			'/ifSeq/4/16'
		);


	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqVelBass01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass01', '1');
		}
		{ i == 2 }  {
			~seqVelBass01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass01', '2');
		}
		{ i == 3 }  {
			~seqVelBass01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass01', '3');
		}

	}

	*st02 {|i|
		case
		{ i == 1 }  {
			~seqVelBass02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass02', '1');
		}
		{ i == 2 }  {
			~seqVelBass02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass02', '2');
		}
		{ i == 3 }  {
			~seqVelBass02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass02', '3');
		}

	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqVelBass03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass03', '1');
		}
		{ i == 2 }  {
			~seqVelBass03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass03', '2');
		}
		{ i == 3 }  {
			~seqVelBass03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass03', '3');
		}

	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqVelBass04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass04', '1');
		}
		{ i == 2 }  {
			~seqVelBass04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass04', '2');
		}
		{ i == 3 }  {
			~seqVelBass04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass04', '3');
		}

	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqVelBass05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass05', '1');
		}
		{ i == 2 }  {
			~seqVelBass05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass05', '2');
		}
		{ i == 3 }  {
			~seqVelBass05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass05', '3');
		}

	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqVelBass06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass06', '1');
		}
		{ i == 2 }  {
			~seqVelBass06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass06', '2');
		}
		{ i == 3 }  {
			~seqVelBass06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass06', '3');
		}

	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqVelBass07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass07', '1');
		}
		{ i == 2 }  {
			~seqVelBass07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass07', '2');
		}
		{ i == 3 }  {
			~seqVelBass07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass07', '3');
		}

	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqVelBass08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass08', '1');
		}
		{ i == 2 }  {
			~seqVelBass08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass08', '2');
		}
		{ i == 3 }  {
			~seqVelBass08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass08', '3');
		}

	}
	*st09 {|i|
		case
		{ i == 1 }  {
			~seqVelBass09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass09', '1');
		}
		{ i == 2 }  {
			~seqVelBass09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass09', '2');
		}
		{ i == 3 }  {
			~seqVelBass09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass09', '3');
		}

	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqVelBass10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass10', '1');
		}
		{ i == 2 }  {
			~seqVelBass10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass10', '2');
		}
		{ i == 3 }  {
			~seqVelBass10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass10', '3');
		}

	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqVelBass11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass11', '1');
		}
		{ i == 2 }  {
			~seqVelBass11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass11', '2');
		}
		{ i == 3 }  {
			~seqVelBass11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass11', '3');
		}

	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqVelBass12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass12', '1');
		}
		{ i == 2 }  {
			~seqVelBass12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass12', '2');
		}
		{ i == 3 }  {
			~seqVelBass12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass12', '3');
		}

	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqVelBass13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass13', '1');
		}
		{ i == 2 }  {
			~seqVelBass13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass13', '2');
		}
		{ i == 3 }  {
			~seqVelBass13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass13', '3');
		}

	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqVelBass14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass14', '1');
		}
		{ i == 2 }  {
			~seqVelBass14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass14', '2');
		}
		{ i == 3 }  {
			~seqVelBass14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass14', '3');
		}

	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqVelBass15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass15', '1');
		}
		{ i == 2 }  {
			~seqVelBass15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass15', '2');
		}
		{ i == 3 }  {
			~seqVelBass15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass15', '3');
		}

	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqVelBass16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelBass16', '1');
		}
		{ i == 2 }  {
			~seqVelBass16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelBass16', '2');
		}
		{ i == 3 }  {
			~seqVelBass16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelBass16', '3');
		}

	}
	*stGrp {|i|
		IFSeqVelBass.st01(i); IFSeqVelBass.st02(i); IFSeqVelBass.st03(i); IFSeqVelBass.st04(i);
		IFSeqVelBass.st05(i); IFSeqVelBass.st06(i); IFSeqVelBass.st07(i); IFSeqVelBass.st08(i);
		IFSeqVelBass.st09(i); IFSeqVelBass.st10(i); IFSeqVelBass.st11(i); IFSeqVelBass.st12(i);
		IFSeqVelBass.st13(i); IFSeqVelBass.st14(i); IFSeqVelBass.st15(i); IFSeqVelBass.st16(i);
	}
}