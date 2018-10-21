IFSeqVTomL {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVTomL01 = PatternProxy( Pseq([0], 1));
		~seqVTomL02 = PatternProxy( Pseq([0], 1));
		~seqVTomL03 = PatternProxy( Pseq([0], 1));
		~seqVTomL04 = PatternProxy( Pseq([0], 1));
		~seqVTomL05 = PatternProxy( Pseq([0], 1));
		~seqVTomL06 = PatternProxy( Pseq([0], 1));
		~seqVTomL07 = PatternProxy( Pseq([0], 1));
		~seqVTomL08 = PatternProxy( Pseq([0], 1));

		~seqVTomL09 = PatternProxy( Pseq([0], 1));
		~seqVTomL10 = PatternProxy( Pseq([0], 1));
		~seqVTomL11 = PatternProxy( Pseq([0], 1));
		~seqVTomL12 = PatternProxy( Pseq([0], 1));
		~seqVTomL13 = PatternProxy( Pseq([0], 1));
		~seqVTomL14 = PatternProxy( Pseq([0], 1));
		~seqVTomL15 = PatternProxy( Pseq([0], 1));
		~seqVTomL16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqStUpVTomL01=0;
		~cntSeqStRandVTomL01=0;

		~cntSeqVTomL01=0;
		~cntSeqVTomL02=0;
		~cntSeqVTomL03=0;
		~cntSeqVTomL04=0;
		~cntSeqVTomL05=0;
		~cntSeqVTomL06=0;
		~cntSeqVTomL07=0;
		~cntSeqVTomL08=0;

		~cntSeqVTomL09=0;
		~cntSeqVTomL10=0;
		~cntSeqVTomL11=0;
		~cntSeqVTomL12=0;
		~cntSeqVTomL13=0;
		~cntSeqVTomL14=0;
		~cntSeqVTomL15=0;
		~cntSeqVTomL16=0;
	}
	*freeOn {
		~seqFreeVTomLBut.free;
		~seqFreeVTomLBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVTomL.stGrp(0);
				});
			},
			'/seqFreeVTomL'
		);

	}

	*upOn {
		~ifSeqUpVTomLBut.free;
		~ifSeqUpVTomLBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStUpVTomL01 = ~cntSeqStUpVTomL01 + 1;
				~cntSeqStUpVTomL01.switch(
					0,{},
					1,{IFSeqVTomL.stGrp(0);},
					2,{IFSeqVTomL.stGrp(1);},
					3,{IFSeqVTomL.stGrp(2);},
					4,{IFSeqVTomL.stGrp(3);},
					5,{IFSeqVTomL.stGrp(4);},
					6,{IFSeqVTomL.stGrp(5);},
					7,{IFSeqVTomL.stGrp(6);},
					8,{IFSeqVTomL.stGrp(7);
						~cntSeqStUpVTomL01=0;
					}
				)}
			);
			},
			'/seqUpVTomL'
		);
	}

	*randOn {
		~ifSeqRandVTomLBut.free;
		~ifSeqRandVTomLBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStRandVTomL01 = ~cntSeqStRandVTomL01 + 1;
				~cntSeqStRandVTomL01.switch(
					0,{},
					1,{
						IFSeqVTomL.st01([0,1].choose);
						IFSeqVTomL.st02([0,1].choose);
						IFSeqVTomL.st03([0,1].choose);
						IFSeqVTomL.st04([0,1].choose);
						IFSeqVTomL.st05([0,1].choose);
						IFSeqVTomL.st06([0,1].choose);
						IFSeqVTomL.st07([0,1].choose);
						IFSeqVTomL.st08([0,1].choose);

						IFSeqVTomL.st09([0,1].choose);
						IFSeqVTomL.st10([0,1].choose);
						IFSeqVTomL.st11([0,1].choose);
						IFSeqVTomL.st12([0,1].choose);
						IFSeqVTomL.st13([0,1].choose);
						IFSeqVTomL.st14([0,1].choose);
						IFSeqVTomL.st15([0,1].choose);
						IFSeqVTomL.st16([0,1].choose);
						~cntSeqStRandVTomL01=0;
					}
				)}
			);
			},
			'/seqRandVTomL'
		);
	}

	*on { // Shift StAVE
		IFSeqVTomL.randOn;
		IFSeqVTomL.upOn;
		IFSeqVTomL.freeOn;

		~ifSeqVTomLBut01.free;
		~ifSeqVTomLBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL01 = ~cntSeqVTomL01 + 1;
				~cntSeqVTomL01.switch(
					0,{},
					1, {IFSeqVTomL.st01(0);},
					2, {IFSeqVTomL.st01(1);
						~cntSeqVTomL01=0;
					}
				)}
			);
			},
			'/ifSeq/4/1'
		);
		~ifSeqVTomLBut02.free;
		~ifSeqVTomLBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL02 = ~cntSeqVTomL02 + 1;
				~cntSeqVTomL02.switch(
					0,{},
					1, {IFSeqVTomL.st02(0);},
					2, {IFSeqVTomL.st02(1);
						~cntSeqVTomL02=0;
					}
				)}
			);
			},
			'/ifSeq/4/2'
		);
		~ifSeqVTomLBut03.free;
		~ifSeqVTomLBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL03 = ~cntSeqVTomL03 + 1;
				~cntSeqVTomL03.switch(
					0,{},
					1, {IFSeqVTomL.st03(0);},
					2, {IFSeqVTomL.st03(1);
						~cntSeqVTomL03=0;
					}
				)}
			);
			},
			'/ifSeq/4/3'
		);
		~ifSeqVTomLBut04.free;
		~ifSeqVTomLBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL04 = ~cntSeqVTomL04 + 1;
				~cntSeqVTomL04.switch(
					0,{},
					1, {IFSeqVTomL.st04(0);},
					2, {IFSeqVTomL.st04(1);
						~cntSeqVTomL04=0;
					}
				)}
			);
			},
			'/ifSeq/4/4'
		);
		~ifSeqVTomLBut05.free;
		~ifSeqVTomLBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL05 = ~cntSeqVTomL05 + 1;
				~cntSeqVTomL05.switch(
					0,{},
					1, {IFSeqVTomL.st05(0);},
					2, {IFSeqVTomL.st05(1);
						~cntSeqVTomL05=0;
					}
				)}
			);
			},
			'/ifSeq/4/5'
		);
		~ifSeqVTomLBut06.free;
		~ifSeqVTomLBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL06 = ~cntSeqVTomL06 + 1;
				~cntSeqVTomL06.switch(
					0,{},
					1, {IFSeqVTomL.st06(0);},
					2, {IFSeqVTomL.st06(1);
						~cntSeqVTomL06=0;
					}
				)}
			);
			},
			'/ifSeq/4/6'
		);
		~ifSeqVTomLBut07.free;
		~ifSeqVTomLBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL07 = ~cntSeqVTomL07 + 1;
				~cntSeqVTomL07.switch(
					0,{},
					1, {IFSeqVTomL.st07(0);},
					2, {IFSeqVTomL.st07(1);
						~cntSeqVTomL07=0;
					}
				)}
			);
			},
			'/ifSeq/4/7'
		);
		~ifSeqVTomLBut08.free;
		~ifSeqVTomLBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL08 = ~cntSeqVTomL08 + 1;
				~cntSeqVTomL08.switch(
					0,{},
					1, {IFSeqVTomL.st08(0);},
					2, {IFSeqVTomL.st08(1);
						~cntSeqVTomL08=0;
					}
				)}
			);
			},
			'/ifSeq/4/8'
		);
		~ifSeqVTomLBut09.free;
		~ifSeqVTomLBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL09 = ~cntSeqVTomL09 + 1;
				~cntSeqVTomL09.switch(
					0,{},
					1, {IFSeqVTomL.st09(0);},
					2, {IFSeqVTomL.st09(1);
						~cntSeqVTomL09=0;
					}
				)}
			);
			},
			'/ifSeq/4/9'
		);
		~ifSeqVTomLBut10.free;
		~ifSeqVTomLBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL10 = ~cntSeqVTomL10 + 1;
				~cntSeqVTomL10.switch(
					0,{},
					1, {IFSeqVTomL.st10(0);},
					2, {IFSeqVTomL.st10(1);
						~cntSeqVTomL10=0;
					}
				)}
			);
			},
			'/ifSeq/4/10'
		);
		~ifSeqVTomLBut11.free;
		~ifSeqVTomLBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL11 = ~cntSeqVTomL11 + 1;
				~cntSeqVTomL11.switch(
					0,{},
					1, {IFSeqVTomL.st11(0);},
					2, {IFSeqVTomL.st11(1);
						~cntSeqVTomL11=0;
					}
				)}
			);
			},
			'/ifSeq/4/11'
		);
		~ifSeqVTomLBut12.free;
		~ifSeqVTomLBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL12 = ~cntSeqVTomL12 + 1;
				~cntSeqVTomL12.switch(
					0,{},
					1, {IFSeqVTomL.st12(0);},
					2, {IFSeqVTomL.st12(1);
						~cntSeqVTomL12=0;
					}
				)}
			);
			},
			'/ifSeq/4/12'
		);
		~ifSeqVTomLBut13.free;
		~ifSeqVTomLBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL13 = ~cntSeqVTomL13 + 1;
				~cntSeqVTomL13.switch(
					0,{},
					1, {IFSeqVTomL.st13(0);},
					2, {IFSeqVTomL.st13(1);
						~cntSeqVTomL13=0;
					}
				)}
			);
			},
			'/ifSeq/4/13'
		);
		~ifSeqVTomLBut14.free;
		~ifSeqVTomLBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL14 = ~cntSeqVTomL14 + 1;
				~cntSeqVTomL14.switch(
					0,{},
					1, {IFSeqVTomL.st14(0);},
					2, {IFSeqVTomL.st14(1);
						~cntSeqVTomL14=0;
					}
				)}
			);
			},
			'/ifSeq/4/14'
		);
		~ifSeqVTomLBut15.free;
		~ifSeqVTomLBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL15 = ~cntSeqVTomL15 + 1;
				~cntSeqVTomL15.switch(
					0,{},
					1, {IFSeqVTomL.st15(0);},
					2, {IFSeqVTomL.st15(1);
						~cntSeqVTomL15=0;
					}
				)}
			);
			},
			'/ifSeq/4/15'
		);
		~ifSeqVTomLBut16.free;
		~ifSeqVTomLBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVTomL16 = ~cntSeqVTomL16 + 1;
				~cntSeqVTomL16.switch(
					0,{},
					1, {IFSeqVTomL.st16(0);},
					2, {IFSeqVTomL.st16(1);
						~cntSeqVTomL16=0;
					}
				)}
			);
			},
			'/ifSeq/4/16'
		);

	}//

	*st01 {|i=0|
		~seqVTomL01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL01', i);
	}
	*st02 {|i=0|
		~seqVTomL02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL02', i);
	}
	*st03 {|i=0|
		~seqVTomL03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL03', i);
	}
	*st04 {|i=0|
		~seqVTomL04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL04', i);
	}
	*st05 {|i=0|
		~seqVTomL05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL05', i);
	}
	*st06 {|i=0|
		~seqVTomL06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL06', i);
	}
	*st07 {|i=0|
		~seqVTomL07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL07', i);
	}
	*st08 {|i=0|
		~seqVTomL08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL08', i);
	}
	*st09 {|i=0|
		~seqVTomL09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL09', i);
	}
	*st10 {|i=0|
		~seqVTomL10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL10', i);
	}
	*st11 {|i=0|
		~seqVTomL11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL11', i);
	}
	*st12 {|i=0|
		~seqVTomL12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL12', i);
	}
	*st13 {|i=0|
		~seqVTomL13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL13', i);
	}
	*st14 {|i=0|
		~seqVTomL14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL14', i);
	}
	*st15 {|i=0|
		~seqVTomL15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL15', i);
	}
	*st16 {|i=0|
		~seqVTomL16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVTomL16', i);
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

		~ampVTomL.source  =  Pseq([~seqVTomL01.next], inf);
	}
	*step02{

		~ampVTomL.source  =  Pseq([~seqVTomL02.next], inf);
	}
	*step03{

		~ampVTomL.source  =  Pseq([~seqVTomL03.next], inf);
	}
	*step04{

		~ampVTomL.source  =  Pseq([~seqVTomL04.next], inf);
	}
	*step05{

		~ampVTomL.source  =  Pseq([~seqVTomL05.next], inf);
	}
	*step06{

		~ampVTomL.source  =  Pseq([~seqVTomL06.next], inf);
	}
	*step07{

		~ampVTomL.source  =  Pseq([~seqVTomL07.next], inf);
	}
	*step08{

		~ampVTomL.source  =  Pseq([~seqVTomL08.next], inf);
	}
	*step09{

		~ampVTomL.source  =  Pseq([~seqVTomL09.next], inf);
	}
	*step10{

		~ampVTomL.source  =  Pseq([~seqVTomL10.next], inf);
	}
	*step11{

		~ampVTomL.source  =  Pseq([~seqVTomL11.next], inf);
	}
	*step12{

		~ampVTomL.source  =  Pseq([~seqVTomL12.next], inf);
	}
	*step13{

		~ampVTomL.source  =  Pseq([~seqVTomL13.next], inf);
	}
	*step14{

		~ampVTomL.source  =  Pseq([~seqVTomL14.next], inf);
	}
	*step15{

		~ampVTomL.source  =  Pseq([~seqVTomL15.next], inf);
	}
	*step16{

		~ampVTomL.source  =  Pseq([~seqVTomL16.next], inf);
	}



	*stGrp {|i|

		IFSeqVTomL.st01(i); IFSeqVTomL.st02(i); IFSeqVTomL.st03(i); IFSeqVTomL.st04(i);
		IFSeqVTomL.st05(i); IFSeqVTomL.st06(i); IFSeqVTomL.st07(i); IFSeqVTomL.st08(i);
		IFSeqVTomL.st09(i); IFSeqVTomL.st10(i); IFSeqVTomL.st11(i); IFSeqVTomL.st12(i);
		IFSeqVTomL.st13(i); IFSeqVTomL.st14(i); IFSeqVTomL.st15(i); IFSeqVTomL.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqVTomL.st01(s01); IFSeqVTomL.st02(s02); IFSeqVTomL.st03(s03); IFSeqVTomL.st04(s04);
		IFSeqVTomL.st05(s05); IFSeqVTomL.st06(s06); IFSeqVTomL.st07(s07); IFSeqVTomL.st08(s08);
		IFSeqVTomL.st09(s09); IFSeqVTomL.st10(s10); IFSeqVTomL.st11(s11); IFSeqVTomL.st12(s12);
		IFSeqVTomL.st13(s13); IFSeqVTomL.st14(s14); IFSeqVTomL.st15(s15); IFSeqVTomL.st16(s16);
	}
}