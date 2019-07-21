IFSeqVClap {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVClap01 = PatternProxy( Pseq([0], 1));
		~seqVClap02 = PatternProxy( Pseq([0], 1));
		~seqVClap03 = PatternProxy( Pseq([0], 1));
		~seqVClap04 = PatternProxy( Pseq([0], 1));
		~seqVClap05 = PatternProxy( Pseq([0], 1));
		~seqVClap06 = PatternProxy( Pseq([0], 1));
		~seqVClap07 = PatternProxy( Pseq([0], 1));
		~seqVClap08 = PatternProxy( Pseq([0], 1));

		~seqVClap09 = PatternProxy( Pseq([0], 1));
		~seqVClap10 = PatternProxy( Pseq([0], 1));
		~seqVClap11 = PatternProxy( Pseq([0], 1));
		~seqVClap12 = PatternProxy( Pseq([0], 1));
		~seqVClap13 = PatternProxy( Pseq([0], 1));
		~seqVClap14 = PatternProxy( Pseq([0], 1));
		~seqVClap15 = PatternProxy( Pseq([0], 1));
		~seqVClap16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqStUpVClap01=0;
		~cntSeqStRandVClap01=0;

		~cntSeqVClap01=0;
		~cntSeqVClap02=0;
		~cntSeqVClap03=0;
		~cntSeqVClap04=0;
		~cntSeqVClap05=0;
		~cntSeqVClap06=0;
		~cntSeqVClap07=0;
		~cntSeqVClap08=0;

		~cntSeqVClap09=0;
		~cntSeqVClap10=0;
		~cntSeqVClap11=0;
		~cntSeqVClap12=0;
		~cntSeqVClap13=0;
		~cntSeqVClap14=0;
		~cntSeqVClap15=0;
		~cntSeqVClap16=0;
	}
	*freeOn {
		~seqFreeVClapBut.free;
		~seqFreeVClapBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVClap.stGrp(0);
				});
			},
			'/seqFreeVClap'
		);

	}

	*upOn {
		~ifSeqUpVClapBut.free;
		~ifSeqUpVClapBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStUpVClap01 = ~cntSeqStUpVClap01 + 1;
				~cntSeqStUpVClap01.switch(
					0,{},
					1,{IFSeqVClap.stGrp(0);},
					2,{IFSeqVClap.stGrp(1);},
					3,{IFSeqVClap.stGrp(2);},
					4,{IFSeqVClap.stGrp(3);},
					5,{IFSeqVClap.stGrp(4);},
					6,{IFSeqVClap.stGrp(5);},
					7,{IFSeqVClap.stGrp(6);},
					8,{IFSeqVClap.stGrp(7);
						~cntSeqStUpVClap01=0;
					}
				)}
			);
			},
			'/seqUpVClap'
		);
	}

	*randOn {
		~ifSeqRandVClapBut.free;
		~ifSeqRandVClapBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStRandVClap01 = ~cntSeqStRandVClap01 + 1;
				~cntSeqStRandVClap01.switch(
					0,{},
					1,{
						IFSeqVClap.st01([0,1].choose);
						IFSeqVClap.st02([0,1].choose);
						IFSeqVClap.st03([0,1].choose);
						IFSeqVClap.st04([0,1].choose);
						IFSeqVClap.st05([0,1].choose);
						IFSeqVClap.st06([0,1].choose);
						IFSeqVClap.st07([0,1].choose);
						IFSeqVClap.st08([0,1].choose);

						IFSeqVClap.st09([0,1].choose);
						IFSeqVClap.st10([0,1].choose);
						IFSeqVClap.st11([0,1].choose);
						IFSeqVClap.st12([0,1].choose);
						IFSeqVClap.st13([0,1].choose);
						IFSeqVClap.st14([0,1].choose);
						IFSeqVClap.st15([0,1].choose);
						IFSeqVClap.st16([0,1].choose);
						~cntSeqStRandVClap01=0;
					}
				)}
			);
			},
			'/seqRandVClap'
		);
	}

	*on { // Shift StAVE
		IFSeqVClap.randOn;
		IFSeqVClap.upOn;
		IFSeqVClap.freeOn;

		~ifSeqVClapBut01.free;
		~ifSeqVClapBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap01 = ~cntSeqVClap01 + 1;
				~cntSeqVClap01.switch(
					0,{},
					1, {IFSeqVClap.st01(0);},
					2, {IFSeqVClap.st01(1);
						~cntSeqVClap01=0;
					}
				)}
			);
			},
			'/ifSeq/4/1'
		);
		~ifSeqVClapBut02.free;
		~ifSeqVClapBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap02 = ~cntSeqVClap02 + 1;
				~cntSeqVClap02.switch(
					0,{},
					1, {IFSeqVClap.st02(0);},
					2, {IFSeqVClap.st02(1);
						~cntSeqVClap02=0;
					}
				)}
			);
			},
			'/ifSeq/4/2'
		);
		~ifSeqVClapBut03.free;
		~ifSeqVClapBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap03 = ~cntSeqVClap03 + 1;
				~cntSeqVClap03.switch(
					0,{},
					1, {IFSeqVClap.st03(0);},
					2, {IFSeqVClap.st03(1);
						~cntSeqVClap03=0;
					}
				)}
			);
			},
			'/ifSeq/4/3'
		);
		~ifSeqVClapBut04.free;
		~ifSeqVClapBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap04 = ~cntSeqVClap04 + 1;
				~cntSeqVClap04.switch(
					0,{},
					1, {IFSeqVClap.st04(0);},
					2, {IFSeqVClap.st04(1);
						~cntSeqVClap04=0;
					}
				)}
			);
			},
			'/ifSeq/4/4'
		);
		~ifSeqVClapBut05.free;
		~ifSeqVClapBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap05 = ~cntSeqVClap05 + 1;
				~cntSeqVClap05.switch(
					0,{},
					1, {IFSeqVClap.st05(0);},
					2, {IFSeqVClap.st05(1);
						~cntSeqVClap05=0;
					}
				)}
			);
			},
			'/ifSeq/4/5'
		);
		~ifSeqVClapBut06.free;
		~ifSeqVClapBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap06 = ~cntSeqVClap06 + 1;
				~cntSeqVClap06.switch(
					0,{},
					1, {IFSeqVClap.st06(0);},
					2, {IFSeqVClap.st06(1);
						~cntSeqVClap06=0;
					}
				)}
			);
			},
			'/ifSeq/4/6'
		);
		~ifSeqVClapBut07.free;
		~ifSeqVClapBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap07 = ~cntSeqVClap07 + 1;
				~cntSeqVClap07.switch(
					0,{},
					1, {IFSeqVClap.st07(0);},
					2, {IFSeqVClap.st07(1);
						~cntSeqVClap07=0;
					}
				)}
			);
			},
			'/ifSeq/4/7'
		);
		~ifSeqVClapBut08.free;
		~ifSeqVClapBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap08 = ~cntSeqVClap08 + 1;
				~cntSeqVClap08.switch(
					0,{},
					1, {IFSeqVClap.st08(0);},
					2, {IFSeqVClap.st08(1);
						~cntSeqVClap08=0;
					}
				)}
			);
			},
			'/ifSeq/4/8'
		);
		~ifSeqVClapBut09.free;
		~ifSeqVClapBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap09 = ~cntSeqVClap09 + 1;
				~cntSeqVClap09.switch(
					0,{},
					1, {IFSeqVClap.st09(0);},
					2, {IFSeqVClap.st09(1);
						~cntSeqVClap09=0;
					}
				)}
			);
			},
			'/ifSeq/4/9'
		);
		~ifSeqVClapBut10.free;
		~ifSeqVClapBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap10 = ~cntSeqVClap10 + 1;
				~cntSeqVClap10.switch(
					0,{},
					1, {IFSeqVClap.st10(0);},
					2, {IFSeqVClap.st10(1);
						~cntSeqVClap10=0;
					}
				)}
			);
			},
			'/ifSeq/4/10'
		);
		~ifSeqVClapBut11.free;
		~ifSeqVClapBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap11 = ~cntSeqVClap11 + 1;
				~cntSeqVClap11.switch(
					0,{},
					1, {IFSeqVClap.st11(0);},
					2, {IFSeqVClap.st11(1);
						~cntSeqVClap11=0;
					}
				)}
			);
			},
			'/ifSeq/4/11'
		);
		~ifSeqVClapBut12.free;
		~ifSeqVClapBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap12 = ~cntSeqVClap12 + 1;
				~cntSeqVClap12.switch(
					0,{},
					1, {IFSeqVClap.st12(0);},
					2, {IFSeqVClap.st12(1);
						~cntSeqVClap12=0;
					}
				)}
			);
			},
			'/ifSeq/4/12'
		);
		~ifSeqVClapBut13.free;
		~ifSeqVClapBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap13 = ~cntSeqVClap13 + 1;
				~cntSeqVClap13.switch(
					0,{},
					1, {IFSeqVClap.st13(0);},
					2, {IFSeqVClap.st13(1);
						~cntSeqVClap13=0;
					}
				)}
			);
			},
			'/ifSeq/4/13'
		);
		~ifSeqVClapBut14.free;
		~ifSeqVClapBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap14 = ~cntSeqVClap14 + 1;
				~cntSeqVClap14.switch(
					0,{},
					1, {IFSeqVClap.st14(0);},
					2, {IFSeqVClap.st14(1);
						~cntSeqVClap14=0;
					}
				)}
			);
			},
			'/ifSeq/4/14'
		);
		~ifSeqVClapBut15.free;
		~ifSeqVClapBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap15 = ~cntSeqVClap15 + 1;
				~cntSeqVClap15.switch(
					0,{},
					1, {IFSeqVClap.st15(0);},
					2, {IFSeqVClap.st15(1);
						~cntSeqVClap15=0;
					}
				)}
			);
			},
			'/ifSeq/4/15'
		);
		~ifSeqVClapBut16.free;
		~ifSeqVClapBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVClap16 = ~cntSeqVClap16 + 1;
				~cntSeqVClap16.switch(
					0,{},
					1, {IFSeqVClap.st16(0);},
					2, {IFSeqVClap.st16(1);
						~cntSeqVClap16=0;
					}
				)}
			);
			},
			'/ifSeq/4/16'
		);

	}//

	*st01 {|i=0|
		~seqVClap01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap01', i);
	}
	*st02 {|i=0|
		~seqVClap02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap02', i);
	}
	*st03 {|i=0|
		~seqVClap03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap03', i);
	}
	*st04 {|i=0|
		~seqVClap04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap04', i);
	}
	*st05 {|i=0|
		~seqVClap05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap05', i);
	}
	*st06 {|i=0|
		~seqVClap06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap06', i);
	}
	*st07 {|i=0|
		~seqVClap07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap07', i);
	}
	*st08 {|i=0|
		~seqVClap08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap08', i);
	}
	*st09 {|i=0|
		~seqVClap09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap09', i);
	}
	*st10 {|i=0|
		~seqVClap10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap10', i);
	}
	*st11 {|i=0|
		~seqVClap11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap11', i);
	}
	*st12 {|i=0|
		~seqVClap12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap12', i);
	}
	*st13 {|i=0|
		~seqVClap13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap13', i);
	}
	*st14 {|i=0|
		~seqVClap14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap14', i);
	}
	*st15 {|i=0|
		~seqVClap15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap15', i);
	}
	*st16 {|i=0|
		~seqVClap16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVClap16', i);
	}

	*stepPack{|i|
		case
		{ i == 1 } { this.step01;  }
		{ i == 2 } { this.step02; }
		{ i == 3 } { this.step03; }
		{ i == 4 } { this.step04; }
		{ i == 5 } { this.step05; }
		{ i == 6 } { this.step06; }
		{ i == 7 } { this.step07; }
		{ i == 8 } { this.step08; }

		{ i == 9 } { this.step09; }
		{ i == 10 } { this.step10; }
		{ i == 11 } { this.step11; }
		{ i == 12 } { this.step12; }
		{ i == 13 } { this.step13; }
		{ i == 14 } { this.step14; }
		{ i == 15 } { this.step15; }
		{ i == 16 } { this.step16; };
	}

	*step01{

		~ampVClap.source  =  Pseq([~seqVClap01.next], inf);
	}
	*step02{

		~ampVClap.source  =  Pseq([~seqVClap02.next], inf);
	}
	*step03{

		~ampVClap.source  =  Pseq([~seqVClap03.next], inf);
	}
	*step04{

		~ampVClap.source  =  Pseq([~seqVClap04.next], inf);
	}
	*step05{

		~ampVClap.source  =  Pseq([~seqVClap05.next], inf);
	}
	*step06{

		~ampVClap.source  =  Pseq([~seqVClap06.next], inf);
	}
	*step07{

		~ampVClap.source  =  Pseq([~seqVClap07.next], inf);
	}
	*step08{

		~ampVClap.source  =  Pseq([~seqVClap08.next], inf);
	}
	*step09{

		~ampVClap.source  =  Pseq([~seqVClap09.next], inf);
	}
	*step10{

		~ampVClap.source  =  Pseq([~seqVClap10.next], inf);
	}
	*step11{

		~ampVClap.source  =  Pseq([~seqVClap11.next], inf);
	}
	*step12{

		~ampVClap.source  =  Pseq([~seqVClap12.next], inf);
	}
	*step13{

		~ampVClap.source  =  Pseq([~seqVClap13.next], inf);
	}
	*step14{

		~ampVClap.source  =  Pseq([~seqVClap14.next], inf);
	}
	*step15{

		~ampVClap.source  =  Pseq([~seqVClap15.next], inf);
	}
	*step16{

		~ampVClap.source  =  Pseq([~seqVClap16.next], inf);
	}



	*stGrp {|i|

		IFSeqVClap.st01(i); IFSeqVClap.st02(i); IFSeqVClap.st03(i); IFSeqVClap.st04(i);
		IFSeqVClap.st05(i); IFSeqVClap.st06(i); IFSeqVClap.st07(i); IFSeqVClap.st08(i);
		IFSeqVClap.st09(i); IFSeqVClap.st10(i); IFSeqVClap.st11(i); IFSeqVClap.st12(i);
		IFSeqVClap.st13(i); IFSeqVClap.st14(i); IFSeqVClap.st15(i); IFSeqVClap.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqVClap.st01(s01); IFSeqVClap.st02(s02); IFSeqVClap.st03(s03); IFSeqVClap.st04(s04);
		IFSeqVClap.st05(s05); IFSeqVClap.st06(s06); IFSeqVClap.st07(s07); IFSeqVClap.st08(s08);
		IFSeqVClap.st09(s09); IFSeqVClap.st10(s10); IFSeqVClap.st11(s11); IFSeqVClap.st12(s12);
		IFSeqVClap.st13(s13); IFSeqVClap.st14(s14); IFSeqVClap.st15(s15); IFSeqVClap.st16(s16);
	}
}