IFSeqVTomH {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVTomH01 = PatternProxy( Pseq([0], 1));
		~seqVTomH02 = PatternProxy( Pseq([0], 1));
		~seqVTomH03 = PatternProxy( Pseq([0], 1));
		~seqVTomH04 = PatternProxy( Pseq([0], 1));
		~seqVTomH05 = PatternProxy( Pseq([0], 1));
		~seqVTomH06 = PatternProxy( Pseq([0], 1));
		~seqVTomH07 = PatternProxy( Pseq([0], 1));
		~seqVTomH08 = PatternProxy( Pseq([0], 1));

		~seqVTomH09 = PatternProxy( Pseq([0], 1));
		~seqVTomH10 = PatternProxy( Pseq([0], 1));
		~seqVTomH11 = PatternProxy( Pseq([0], 1));
		~seqVTomH12 = PatternProxy( Pseq([0], 1));
		~seqVTomH13 = PatternProxy( Pseq([0], 1));
		~seqVTomH14 = PatternProxy( Pseq([0], 1));
		~seqVTomH15 = PatternProxy( Pseq([0], 1));
		~seqVTomH16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqStUpVTomH01=0;
		~cntSeqStRandVTomH01=0;

		~cntSeqVTomH01=0;
		~cntSeqVTomH02=0;
		~cntSeqVTomH03=0;
		~cntSeqVTomH04=0;
		~cntSeqVTomH05=0;
		~cntSeqVTomH06=0;
		~cntSeqVTomH07=0;
		~cntSeqVTomH08=0;

		~cntSeqVTomH09=0;
		~cntSeqVTomH10=0;
		~cntSeqVTomH11=0;
		~cntSeqVTomH12=0;
		~cntSeqVTomH13=0;
		~cntSeqVTomH14=0;
		~cntSeqVTomH15=0;
		~cntSeqVTomH16=0;
	}
	*freeOn {
		~seqFreeVTomHBut.free;
		~seqFreeVTomHBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVTomH.stGrp(0);
				});
			},
			'/seqFreeVTomH'
		);

	}

	*upOn {
		~ifSeqUpVTomHBut.free;
		~ifSeqUpVTomHBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStUpVTomH01 = ~cntSeqStUpVTomH01 + 1;
				~cntSeqStUpVTomH01.switch(
					0,{},
					1,{IFSeqVTomH.stGrp(0);},
					2,{IFSeqVTomH.stGrp(1);},
					3,{IFSeqVTomH.stGrp(2);},
					4,{IFSeqVTomH.stGrp(3);},
					5,{IFSeqVTomH.stGrp(4);},
					6,{IFSeqVTomH.stGrp(5);},
					7,{IFSeqVTomH.stGrp(6);},
					8,{IFSeqVTomH.stGrp(7);
						~cntSeqStUpVTomH01=0;
					}
				)}
			);
			},
			'/seqUpVTomH'
		);
	}

	*randOn {
		~ifSeqRandVTomHBut.free;
		~ifSeqRandVTomHBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStRandVTomH01 = ~cntSeqStRandVTomH01 + 1;
				~cntSeqStRandVTomH01.switch(
					0,{},
					1,{
						IFSeqVTomH.st01([0,1].choose);
						IFSeqVTomH.st02([0,1].choose);
						IFSeqVTomH.st03([0,1].choose);
						IFSeqVTomH.st04([0,1].choose);
						IFSeqVTomH.st05([0,1].choose);
						IFSeqVTomH.st06([0,1].choose);
						IFSeqVTomH.st07([0,1].choose);
						IFSeqVTomH.st08([0,1].choose);

						IFSeqVTomH.st09([0,1].choose);
						IFSeqVTomH.st10([0,1].choose);
						IFSeqVTomH.st11([0,1].choose);
						IFSeqVTomH.st12([0,1].choose);
						IFSeqVTomH.st13([0,1].choose);
						IFSeqVTomH.st14([0,1].choose);
						IFSeqVTomH.st15([0,1].choose);
						IFSeqVTomH.st16([0,1].choose);
						~cntSeqStRandVTomH01=0;
					}
				)}
			);
			},
			'/seqRandVTomH'
		);
	}

	*on { // Shift StAVE
		IFSeqVTomH.randOn;
		IFSeqVTomH.upOn;
		IFSeqVTomH.freeOn;

		~ifSeqVTomHBut01.free;
		~ifSeqVTomHBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH01 = ~cntSeqVTomH01 + 1;
				~cntSeqVTomH01.switch(
					0,{},
					1, {IFSeqVTomH.st01(0);},
					2, {IFSeqVTomH.st01(1);
						~cntSeqVTomH01=0;
					}
				)}
			);
			},
			'/ifSeq/4/1'
		);
		~ifSeqVTomHBut02.free;
		~ifSeqVTomHBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH02 = ~cntSeqVTomH02 + 1;
				~cntSeqVTomH02.switch(
					0,{},
					1, {IFSeqVTomH.st02(0);},
					2, {IFSeqVTomH.st02(1);
						~cntSeqVTomH02=0;
					}
				)}
			);
			},
			'/ifSeq/4/2'
		);
		~ifSeqVTomHBut03.free;
		~ifSeqVTomHBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH03 = ~cntSeqVTomH03 + 1;
				~cntSeqVTomH03.switch(
					0,{},
					1, {IFSeqVTomH.st03(0);},
					2, {IFSeqVTomH.st03(1);
						~cntSeqVTomH03=0;
					}
				)}
			);
			},
			'/ifSeq/4/3'
		);
		~ifSeqVTomHBut04.free;
		~ifSeqVTomHBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH04 = ~cntSeqVTomH04 + 1;
				~cntSeqVTomH04.switch(
					0,{},
					1, {IFSeqVTomH.st04(0);},
					2, {IFSeqVTomH.st04(1);
						~cntSeqVTomH04=0;
					}
				)}
			);
			},
			'/ifSeq/4/4'
		);
		~ifSeqVTomHBut05.free;
		~ifSeqVTomHBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH05 = ~cntSeqVTomH05 + 1;
				~cntSeqVTomH05.switch(
					0,{},
					1, {IFSeqVTomH.st05(0);},
					2, {IFSeqVTomH.st05(1);
						~cntSeqVTomH05=0;
					}
				)}
			);
			},
			'/ifSeq/4/5'
		);
		~ifSeqVTomHBut06.free;
		~ifSeqVTomHBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH06 = ~cntSeqVTomH06 + 1;
				~cntSeqVTomH06.switch(
					0,{},
					1, {IFSeqVTomH.st06(0);},
					2, {IFSeqVTomH.st06(1);
						~cntSeqVTomH06=0;
					}
				)}
			);
			},
			'/ifSeq/4/6'
		);
		~ifSeqVTomHBut07.free;
		~ifSeqVTomHBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH07 = ~cntSeqVTomH07 + 1;
				~cntSeqVTomH07.switch(
					0,{},
					1, {IFSeqVTomH.st07(0);},
					2, {IFSeqVTomH.st07(1);
						~cntSeqVTomH07=0;
					}
				)}
			);
			},
			'/ifSeq/4/7'
		);
		~ifSeqVTomHBut08.free;
		~ifSeqVTomHBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH08 = ~cntSeqVTomH08 + 1;
				~cntSeqVTomH08.switch(
					0,{},
					1, {IFSeqVTomH.st08(0);},
					2, {IFSeqVTomH.st08(1);
						~cntSeqVTomH08=0;
					}
				)}
			);
			},
			'/ifSeq/4/8'
		);
		~ifSeqVTomHBut09.free;
		~ifSeqVTomHBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH09 = ~cntSeqVTomH09 + 1;
				~cntSeqVTomH09.switch(
					0,{},
					1, {IFSeqVTomH.st09(0);},
					2, {IFSeqVTomH.st09(1);
						~cntSeqVTomH09=0;
					}
				)}
			);
			},
			'/ifSeq/4/9'
		);
		~ifSeqVTomHBut10.free;
		~ifSeqVTomHBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH10 = ~cntSeqVTomH10 + 1;
				~cntSeqVTomH10.switch(
					0,{},
					1, {IFSeqVTomH.st10(0);},
					2, {IFSeqVTomH.st10(1);
						~cntSeqVTomH10=0;
					}
				)}
			);
			},
			'/ifSeq/4/10'
		);
		~ifSeqVTomHBut11.free;
		~ifSeqVTomHBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH11 = ~cntSeqVTomH11 + 1;
				~cntSeqVTomH11.switch(
					0,{},
					1, {IFSeqVTomH.st11(0);},
					2, {IFSeqVTomH.st11(1);
						~cntSeqVTomH11=0;
					}
				)}
			);
			},
			'/ifSeq/4/11'
		);
		~ifSeqVTomHBut12.free;
		~ifSeqVTomHBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH12 = ~cntSeqVTomH12 + 1;
				~cntSeqVTomH12.switch(
					0,{},
					1, {IFSeqVTomH.st12(0);},
					2, {IFSeqVTomH.st12(1);
						~cntSeqVTomH12=0;
					}
				)}
			);
			},
			'/ifSeq/4/12'
		);
		~ifSeqVTomHBut13.free;
		~ifSeqVTomHBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH13 = ~cntSeqVTomH13 + 1;
				~cntSeqVTomH13.switch(
					0,{},
					1, {IFSeqVTomH.st13(0);},
					2, {IFSeqVTomH.st13(1);
						~cntSeqVTomH13=0;
					}
				)}
			);
			},
			'/ifSeq/4/13'
		);
		~ifSeqVTomHBut14.free;
		~ifSeqVTomHBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH14 = ~cntSeqVTomH14 + 1;
				~cntSeqVTomH14.switch(
					0,{},
					1, {IFSeqVTomH.st14(0);},
					2, {IFSeqVTomH.st14(1);
						~cntSeqVTomH14=0;
					}
				)}
			);
			},
			'/ifSeq/4/14'
		);
		~ifSeqVTomHBut15.free;
		~ifSeqVTomHBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH15 = ~cntSeqVTomH15 + 1;
				~cntSeqVTomH15.switch(
					0,{},
					1, {IFSeqVTomH.st15(0);},
					2, {IFSeqVTomH.st15(1);
						~cntSeqVTomH15=0;
					}
				)}
			);
			},
			'/ifSeq/4/15'
		);
		~ifSeqVTomHBut16.free;
		~ifSeqVTomHBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomH16 = ~cntSeqVTomH16 + 1;
				~cntSeqVTomH16.switch(
					0,{},
					1, {IFSeqVTomH.st16(0);},
					2, {IFSeqVTomH.st16(1);
						~cntSeqVTomH16=0;
					}
				)}
			);
			},
			'/ifSeq/4/16'
		);

	}//

	*st01 {|i=0|
		~seqVTomH01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH01', i);
	}
	*st02 {|i=0|
		~seqVTomH02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH02', i);
	}
	*st03 {|i=0|
		~seqVTomH03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH03', i);
	}
	*st04 {|i=0|
		~seqVTomH04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH04', i);
	}
	*st05 {|i=0|
		~seqVTomH05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH05', i);
	}
	*st06 {|i=0|
		~seqVTomH06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH06', i);
	}
	*st07 {|i=0|
		~seqVTomH07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH07', i);
	}
	*st08 {|i=0|
		~seqVTomH08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH08', i);
	}
	*st09 {|i=0|
		~seqVTomH09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH09', i);
	}
	*st10 {|i=0|
		~seqVTomH10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH10', i);
	}
	*st11 {|i=0|
		~seqVTomH11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH11', i);
	}
	*st12 {|i=0|
		~seqVTomH12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH12', i);
	}
	*st13 {|i=0|
		~seqVTomH13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH13', i);
	}
	*st14 {|i=0|
		~seqVTomH14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH14', i);
	}
	*st15 {|i=0|
		~seqVTomH15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH15', i);
	}
	*st16 {|i=0|
		~seqVTomH16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomH16', i);
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

		~ampVTomH.source  =  Pseq([~seqVTomH01.next], inf);
	}
	*step02{

		~ampVTomH.source  =  Pseq([~seqVTomH02.next], inf);
	}
	*step03{

		~ampVTomH.source  =  Pseq([~seqVTomH03.next], inf);
	}
	*step04{

		~ampVTomH.source  =  Pseq([~seqVTomH04.next], inf);
	}
	*step05{

		~ampVTomH.source  =  Pseq([~seqVTomH05.next], inf);
	}
	*step06{

		~ampVTomH.source  =  Pseq([~seqVTomH06.next], inf);
	}
	*step07{

		~ampVTomH.source  =  Pseq([~seqVTomH07.next], inf);
	}
	*step08{

		~ampVTomH.source  =  Pseq([~seqVTomH08.next], inf);
	}
	*step09{

		~ampVTomH.source  =  Pseq([~seqVTomH09.next], inf);
	}
	*step10{

		~ampVTomH.source  =  Pseq([~seqVTomH10.next], inf);
	}
	*step11{

		~ampVTomH.source  =  Pseq([~seqVTomH11.next], inf);
	}
	*step12{

		~ampVTomH.source  =  Pseq([~seqVTomH12.next], inf);
	}
	*step13{

		~ampVTomH.source  =  Pseq([~seqVTomH13.next], inf);
	}
	*step14{

		~ampVTomH.source  =  Pseq([~seqVTomH14.next], inf);
	}
	*step15{

		~ampVTomH.source  =  Pseq([~seqVTomH15.next], inf);
	}
	*step16{

		~ampVTomH.source  =  Pseq([~seqVTomH16.next], inf);
	}



	*stGrp {|i|

		IFSeqVTomH.st01(i); IFSeqVTomH.st02(i); IFSeqVTomH.st03(i); IFSeqVTomH.st04(i);
		IFSeqVTomH.st05(i); IFSeqVTomH.st06(i); IFSeqVTomH.st07(i); IFSeqVTomH.st08(i);
		IFSeqVTomH.st09(i); IFSeqVTomH.st10(i); IFSeqVTomH.st11(i); IFSeqVTomH.st12(i);
		IFSeqVTomH.st13(i); IFSeqVTomH.st14(i); IFSeqVTomH.st15(i); IFSeqVTomH.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqVTomH.st01(s01); IFSeqVTomH.st02(s02); IFSeqVTomH.st03(s03); IFSeqVTomH.st04(s04);
		IFSeqVTomH.st05(s05); IFSeqVTomH.st06(s06); IFSeqVTomH.st07(s07); IFSeqVTomH.st08(s08);
		IFSeqVTomH.st09(s09); IFSeqVTomH.st10(s10); IFSeqVTomH.st11(s11); IFSeqVTomH.st12(s12);
		IFSeqVTomH.st13(s13); IFSeqVTomH.st14(s14); IFSeqVTomH.st15(s15); IFSeqVTomH.st16(s16);
	}
}