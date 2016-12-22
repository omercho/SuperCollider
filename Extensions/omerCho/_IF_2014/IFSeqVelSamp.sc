IFSeqVelSamp {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVelSamp01 = PatternProxy( Pseq([1], 1));
		~seqVelSamp02 = PatternProxy( Pseq([1], 1));
		~seqVelSamp03 = PatternProxy( Pseq([1], 1));
		~seqVelSamp04 = PatternProxy( Pseq([1], 1));
		~seqVelSamp05 = PatternProxy( Pseq([1], 1));
		~seqVelSamp06 = PatternProxy( Pseq([1], 1));
		~seqVelSamp07 = PatternProxy( Pseq([1], 1));
		~seqVelSamp08 = PatternProxy( Pseq([1], 1));

		~seqVelSamp09 = PatternProxy( Pseq([1], 1));
		~seqVelSamp10 = PatternProxy( Pseq([1], 1));
		~seqVelSamp11 = PatternProxy( Pseq([1], 1));
		~seqVelSamp12 = PatternProxy( Pseq([1], 1));
		~seqVelSamp13 = PatternProxy( Pseq([1], 1));
		~seqVelSamp14 = PatternProxy( Pseq([1], 1));
		~seqVelSamp15 = PatternProxy( Pseq([1], 1));
		~seqVelSamp16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeqVelUpSamp01=0;
		~cntSeqVelRandSamp01=0;

		~cntSeqVelSamp01=0;
		~cntSeqVelSamp02=0;
		~cntSeqVelSamp03=0;
		~cntSeqVelSamp04=0;
		~cntSeqVelSamp05=0;
		~cntSeqVelSamp06=0;
		~cntSeqVelSamp07=0;
		~cntSeqVelSamp08=0;

		~cntSeqVelSamp09=0;
		~cntSeqVelSamp10=0;
		~cntSeqVelSamp11=0;
		~cntSeqVelSamp12=0;
		~cntSeqVelSamp13=0;
		~cntSeqVelSamp14=0;
		~cntSeqVelSamp15=0;
		~cntSeqVelSamp16=0;
	}
	*freeOn {
		~seqFreeSampBut.free;
		~seqFreeSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVelSamp.stGrp(1);
				});
			},
			'/seqFreeSamp'
		);
	}
	*upOn {
		~ifSeqUpSampBut.free;
		~ifSeqUpSampBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelUpSamp01 = ~cntSeqVelUpSamp01 + 1;
				~cntSeqVelUpSamp01.switch(
					0,{},
					1,{IFSeqVelSamp.stGrp(1);},
					2,{IFSeqVelSamp.stGrp(2);},
					3,{IFSeqVelSamp.stGrp(3);
						~cntSeqVelUpSamp01=0;
					}
				)}
			);
			},
			'/seqUpSamp'
		);
	}

	*randOn {
		~ifSeqRandSampBut.free;
		~ifSeqRandSampBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelRandSamp01 = ~cntSeqVelRandSamp01 + 1;
				~cntSeqVelRandSamp01.switch(
					0,{},
					1,{
						IFSeqVelSamp.st01([1,2,3].choose);
						IFSeqVelSamp.st02([1,2,3].choose);
						IFSeqVelSamp.st03([1,2,3].choose);
						IFSeqVelSamp.st04([1,2,3].choose);
						IFSeqVelSamp.st05([1,2,3].choose);
						IFSeqVelSamp.st06([1,2,3].choose);
						IFSeqVelSamp.st07([1,2,3].choose);
						IFSeqVelSamp.st08([1,2,3].choose);

						IFSeqVelSamp.st09([1,2,3].choose);
						IFSeqVelSamp.st10([1,2,3].choose);
						IFSeqVelSamp.st11([1,2,3].choose);
						IFSeqVelSamp.st12([1,2,3].choose);
						IFSeqVelSamp.st13([1,2,3].choose);
						IFSeqVelSamp.st14([1,2,3].choose);
						IFSeqVelSamp.st15([1,2,3].choose);
						IFSeqVelSamp.st16([1,2,3].choose);
						~cntSeqVelRandSamp01=0;
					}
				)}
			);
			},
			'/seqRandSamp'
		);
	}


	*on { // Shift Velocity

		IFSeqVelSamp.randOn;
		IFSeqVelSamp.upOn;
		IFSeqVelSamp.freeOn;

		~ifSeqSampBut01.free;
		~ifSeqSampBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp01 = ~cntSeqVelSamp01 + 1;
				~cntSeqVelSamp01.switch(
					0,{},
					1, {IFSeqVelSamp.st01(1);},
					2, {IFSeqVelSamp.st01(2);},
					3, {IFSeqVelSamp.st01(3);}
				)}
			);
			},
			'/ifSeq/6/1'
		);
		~ifSeqSampBut02.free;
		~ifSeqSampBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp02 = ~cntSeqVelSamp02 + 1;
				~cntSeqVelSamp02.switch(
					0,{},
					1, {IFSeqVelSamp.st02(1);},
					2, {IFSeqVelSamp.st02(2);},
					3, {IFSeqVelSamp.st02(3);}
				)}
			);
			},
			'/ifSeq/6/2'
		);
		~ifSeqSampBut03.free;
		~ifSeqSampBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp03 = ~cntSeqVelSamp03 + 1;
				~cntSeqVelSamp03.switch(
					0,{},
					1, {IFSeqVelSamp.st03(1);},
					2, {IFSeqVelSamp.st03(2);},
					3, {IFSeqVelSamp.st03(3);}
				)}
			);
			},
			'/ifSeq/6/3'
		);
		~ifSeqSampBut04.free;
		~ifSeqSampBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp04 = ~cntSeqVelSamp04 + 1;
				~cntSeqVelSamp04.switch(
					0,{},
					1, {IFSeqVelSamp.st04(1);},
					2, {IFSeqVelSamp.st04(2);},
					3, {IFSeqVelSamp.st04(3);}
				)}
			);
			},
			'/ifSeq/6/4'
		);
		~ifSeqSampBut05.free;
		~ifSeqSampBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp05 = ~cntSeqVelSamp05 + 1;
				~cntSeqVelSamp05.switch(
					0,{},
					1, {IFSeqVelSamp.st05(1);},
					2, {IFSeqVelSamp.st05(2);},
					3, {IFSeqVelSamp.st05(3);}
				)}
			);
			},
			'/ifSeq/6/5'
		);
		~ifSeqSampBut06.free;
		~ifSeqSampBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp06 = ~cntSeqVelSamp06 + 1;
				~cntSeqVelSamp06.switch(
					0,{},
					1, {IFSeqVelSamp.st06(1);},
					2, {IFSeqVelSamp.st06(2);},
					3, {IFSeqVelSamp.st06(3);}
				)}
			);
			},
			'/ifSeq/6/6'
		);
		~ifSeqSampBut07.free;
		~ifSeqSampBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp07 = ~cntSeqVelSamp07 + 1;
				~cntSeqVelSamp07.switch(
					0,{},
					1, {IFSeqVelSamp.st07(1);},
					2, {IFSeqVelSamp.st07(2);},
					3, {IFSeqVelSamp.st07(3);}
				)}
			);
			},
			'/ifSeq/6/7'
		);
		~ifSeqSampBut08.free;
		~ifSeqSampBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp08 = ~cntSeqVelSamp08 + 1;
				~cntSeqVelSamp08.switch(
					0,{},
					1, {IFSeqVelSamp.st08(1);},
					2, {IFSeqVelSamp.st08(2);},
					3, {IFSeqVelSamp.st08(3);}
				)}
			);
			},
			'/ifSeq/6/8'
		);

		~ifSeqSampBut09.free;
		~ifSeqSampBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp09 = ~cntSeqVelSamp09 + 1;
				~cntSeqVelSamp09.switch(
					0,{},
					1, {IFSeqVelSamp.st09(1);},
					2, {IFSeqVelSamp.st09(2);},
					3, {IFSeqVelSamp.st09(3);}
				)}
			);
			},
			'/ifSeq/6/9'
		);
		~ifSeqSampBut10.free;
		~ifSeqSampBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp10 = ~cntSeqVelSamp10 + 1;
				~cntSeqVelSamp10.switch(
					0,{},
					1, {IFSeqVelSamp.st10(1);},
					2, {IFSeqVelSamp.st10(2);},
					3, {IFSeqVelSamp.st10(3);}
				)}
			);
			},
			'/ifSeq/6/10'
		);
		~ifSeqSampBut11.free;
		~ifSeqSampBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp11 = ~cntSeqVelSamp11 + 1;
				~cntSeqVelSamp11.switch(
					0,{},
					1, {IFSeqVelSamp.st11(1);},
					2, {IFSeqVelSamp.st11(2);},
					3, {IFSeqVelSamp.st11(3);}
				)}
			);
			},
			'/ifSeq/6/11'
		);
		~ifSeqSampBut12.free;
		~ifSeqSampBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp12 = ~cntSeqVelSamp12 + 1;
				~cntSeqVelSamp12.switch(
					0,{},
					1, {IFSeqVelSamp.st12(1);},
					2, {IFSeqVelSamp.st12(2);},
					3, {IFSeqVelSamp.st12(3);}
				)}
			);
			},
			'/ifSeq/6/12'
		);
		~ifSeqSampBut13.free;
		~ifSeqSampBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp13 = ~cntSeqVelSamp13 + 1;
				~cntSeqVelSamp13.switch(
					0,{},
					1, {IFSeqVelSamp.st13(1);},
					2, {IFSeqVelSamp.st13(2);},
					3, {IFSeqVelSamp.st13(3);}
				)}
			);
			},
			'/ifSeq/6/13'
		);
		~ifSeqSampBut14.free;
		~ifSeqSampBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp14 = ~cntSeqVelSamp14 + 1;
				~cntSeqVelSamp14.switch(
					0,{},
					1, {IFSeqVelSamp.st14(1);},
					2, {IFSeqVelSamp.st14(2);},
					3, {IFSeqVelSamp.st14(3);}
				)}
			);
			},
			'/ifSeq/6/14'
		);
		~ifSeqSampBut15.free;
		~ifSeqSampBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp15 = ~cntSeqVelSamp15 + 1;
				~cntSeqVelSamp15.switch(
					0,{},
					1, {IFSeqVelSamp.st15(1);},
					2, {IFSeqVelSamp.st15(2);},
					3, {IFSeqVelSamp.st15(3);}
				)}
			);
			},
			'/ifSeq/6/15'
		);
		~ifSeqSampBut16.free;
		~ifSeqSampBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVelSamp16 = ~cntSeqVelSamp16 + 1;
				~cntSeqVelSamp16.switch(
					0,{},
					1, {IFSeqVelSamp.st16(1);},
					2, {IFSeqVelSamp.st16(2);},
					3, {IFSeqVelSamp.st16(3);}
				)}
			);
			},
			'/ifSeq/6/16'
		);


	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp01.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp01', '1');
		}
		{ i == 2 }  {
			~seqVelSamp01.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp01', '2');
		}
		{ i == 3 }  {
			~seqVelSamp01.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp01', '3');
		}

	}

	*st02 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp02.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp02', '1');
		}
		{ i == 2 }  {
			~seqVelSamp02.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp02', '2');
		}
		{ i == 3 }  {
			~seqVelSamp02.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp02', '3');
		}

	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp03.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp03', '1');
		}
		{ i == 2 }  {
			~seqVelSamp03.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp03', '2');
		}
		{ i == 3 }  {
			~seqVelSamp03.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp03', '3');
		}

	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp04.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp04', '1');
		}
		{ i == 2 }  {
			~seqVelSamp04.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp04', '2');
		}
		{ i == 3 }  {
			~seqVelSamp04.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp04', '3');
		}

	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp05.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp05', '1');
		}
		{ i == 2 }  {
			~seqVelSamp05.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp05', '2');
		}
		{ i == 3 }  {
			~seqVelSamp05.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp05', '3');
		}

	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp06.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp06', '1');
		}
		{ i == 2 }  {
			~seqVelSamp06.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp06', '2');
		}
		{ i == 3 }  {
			~seqVelSamp06.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp06', '3');
		}

	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp07.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp07', '1');
		}
		{ i == 2 }  {
			~seqVelSamp07.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp07', '2');
		}
		{ i == 3 }  {
			~seqVelSamp07.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp07', '3');
		}

	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp08.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp08', '1');
		}
		{ i == 2 }  {
			~seqVelSamp08.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp08', '2');
		}
		{ i == 3 }  {
			~seqVelSamp08.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp08', '3');
		}

	}
	*st09 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp09.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp09', '1');
		}
		{ i == 2 }  {
			~seqVelSamp09.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp09', '2');
		}
		{ i == 3 }  {
			~seqVelSamp09.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp09', '3');
		}

	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp10.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp10', '1');
		}
		{ i == 2 }  {
			~seqVelSamp10.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp10', '2');
		}
		{ i == 3 }  {
			~seqVelSamp10.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp10', '3');
		}

	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp11.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp11', '1');
		}
		{ i == 2 }  {
			~seqVelSamp11.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp11', '2');
		}
		{ i == 3 }  {
			~seqVelSamp11.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp11', '3');
		}

	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp12.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp12', '1');
		}
		{ i == 2 }  {
			~seqVelSamp12.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp12', '2');
		}
		{ i == 3 }  {
			~seqVelSamp12.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp12', '3');
		}

	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp13.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp13', '1');
		}
		{ i == 2 }  {
			~seqVelSamp13.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp13', '2');
		}
		{ i == 3 }  {
			~seqVelSamp13.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp13', '3');
		}

	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp14.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp14', '1');
		}
		{ i == 2 }  {
			~seqVelSamp14.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp14', '2');
		}
		{ i == 3 }  {
			~seqVelSamp14.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp14', '3');
		}

	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp15.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp15', '1');
		}
		{ i == 2 }  {
			~seqVelSamp15.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp15', '2');
		}
		{ i == 3 }  {
			~seqVelSamp15.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp15', '3');
		}

	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seqVelSamp16.source = Pseq([0.5], 1);
			~tOSCAdrr.sendMsg('shVelSamp16', '1');
		}
		{ i == 2 }  {
			~seqVelSamp16.source = Pseq([0.7], 1);
			~tOSCAdrr.sendMsg('shVelSamp16', '2');
		}
		{ i == 3 }  {
			~seqVelSamp16.source = Pseq([0.9], 1);
			~tOSCAdrr.sendMsg('shVelSamp16', '3');
		}

	}
	*stGrp {|i|
		IFSeqVelSamp.st01(i); IFSeqVelSamp.st02(i); IFSeqVelSamp.st03(i); IFSeqVelSamp.st04(i);
		IFSeqVelSamp.st05(i); IFSeqVelSamp.st06(i); IFSeqVelSamp.st07(i); IFSeqVelSamp.st08(i);
		IFSeqVelSamp.st09(i); IFSeqVelSamp.st10(i); IFSeqVelSamp.st11(i); IFSeqVelSamp.st12(i);
		IFSeqVelSamp.st13(i); IFSeqVelSamp.st14(i); IFSeqVelSamp.st15(i); IFSeqVelSamp.st16(i);
	}
}