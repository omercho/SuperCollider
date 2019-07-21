IFSeqVCrsh {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVCrsh01 = PatternProxy( Pseq([0], 1));
		~seqVCrsh02 = PatternProxy( Pseq([0], 1));
		~seqVCrsh03 = PatternProxy( Pseq([0], 1));
		~seqVCrsh04 = PatternProxy( Pseq([0], 1));
		~seqVCrsh05 = PatternProxy( Pseq([0], 1));
		~seqVCrsh06 = PatternProxy( Pseq([0], 1));
		~seqVCrsh07 = PatternProxy( Pseq([0], 1));
		~seqVCrsh08 = PatternProxy( Pseq([0], 1));

		~seqVCrsh09 = PatternProxy( Pseq([0], 1));
		~seqVCrsh10 = PatternProxy( Pseq([0], 1));
		~seqVCrsh11 = PatternProxy( Pseq([0], 1));
		~seqVCrsh12 = PatternProxy( Pseq([0], 1));
		~seqVCrsh13 = PatternProxy( Pseq([0], 1));
		~seqVCrsh14 = PatternProxy( Pseq([0], 1));
		~seqVCrsh15 = PatternProxy( Pseq([0], 1));
		~seqVCrsh16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqStUpVCrsh01=0;
		~cntSeqStRandVCrsh01=0;

		~cntSeqVCrsh01=0;
		~cntSeqVCrsh02=0;
		~cntSeqVCrsh03=0;
		~cntSeqVCrsh04=0;
		~cntSeqVCrsh05=0;
		~cntSeqVCrsh06=0;
		~cntSeqVCrsh07=0;
		~cntSeqVCrsh08=0;

		~cntSeqVCrsh09=0;
		~cntSeqVCrsh10=0;
		~cntSeqVCrsh11=0;
		~cntSeqVCrsh12=0;
		~cntSeqVCrsh13=0;
		~cntSeqVCrsh14=0;
		~cntSeqVCrsh15=0;
		~cntSeqVCrsh16=0;
	}
	*freeOn {
		~seqFreeVCrshBut.free;
		~seqFreeVCrshBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVCrsh.stGrp(0);
				});
			},
			'/seqFreeVCrsh'
		);

	}

	*upOn {
		~ifSeqUpVCrshBut.free;
		~ifSeqUpVCrshBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStUpVCrsh01 = ~cntSeqStUpVCrsh01 + 1;
				~cntSeqStUpVCrsh01.switch(
					0,{},
					1,{IFSeqVCrsh.stGrp(0);},
					2,{IFSeqVCrsh.stGrp(1);},
					3,{IFSeqVCrsh.stGrp(2);},
					4,{IFSeqVCrsh.stGrp(3);},
					5,{IFSeqVCrsh.stGrp(4);},
					6,{IFSeqVCrsh.stGrp(5);},
					7,{IFSeqVCrsh.stGrp(6);},
					8,{IFSeqVCrsh.stGrp(7);
						~cntSeqStUpVCrsh01=0;
					}
				)}
			);
			},
			'/seqUpVCrsh'
		);
	}

	*randOn {
		~ifSeqRandVCrshBut.free;
		~ifSeqRandVCrshBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStRandVCrsh01 = ~cntSeqStRandVCrsh01 + 1;
				~cntSeqStRandVCrsh01.switch(
					0,{},
					1,{
						IFSeqVCrsh.st01([0,1].choose);
						IFSeqVCrsh.st02([0,1].choose);
						IFSeqVCrsh.st03([0,1].choose);
						IFSeqVCrsh.st04([0,1].choose);
						IFSeqVCrsh.st05([0,1].choose);
						IFSeqVCrsh.st06([0,1].choose);
						IFSeqVCrsh.st07([0,1].choose);
						IFSeqVCrsh.st08([0,1].choose);

						IFSeqVCrsh.st09([0,1].choose);
						IFSeqVCrsh.st10([0,1].choose);
						IFSeqVCrsh.st11([0,1].choose);
						IFSeqVCrsh.st12([0,1].choose);
						IFSeqVCrsh.st13([0,1].choose);
						IFSeqVCrsh.st14([0,1].choose);
						IFSeqVCrsh.st15([0,1].choose);
						IFSeqVCrsh.st16([0,1].choose);
						~cntSeqStRandVCrsh01=0;
					}
				)}
			);
			},
			'/seqRandVCrsh'
		);
	}

	*on { // Shift StAVE
		IFSeqVCrsh.randOn;
		IFSeqVCrsh.upOn;
		IFSeqVCrsh.freeOn;

		~ifSeqVCrshBut01.free;
		~ifSeqVCrshBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh01 = ~cntSeqVCrsh01 + 1;
				~cntSeqVCrsh01.switch(
					0,{},
					1, {IFSeqVCrsh.st01(0);},
					2, {IFSeqVCrsh.st01(1);
						~cntSeqVCrsh01=0;
					}
				)}
			);
			},
			'/ifSeq/4/1'
		);
		~ifSeqVCrshBut02.free;
		~ifSeqVCrshBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh02 = ~cntSeqVCrsh02 + 1;
				~cntSeqVCrsh02.switch(
					0,{},
					1, {IFSeqVCrsh.st02(0);},
					2, {IFSeqVCrsh.st02(1);
						~cntSeqVCrsh02=0;
					}
				)}
			);
			},
			'/ifSeq/4/2'
		);
		~ifSeqVCrshBut03.free;
		~ifSeqVCrshBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh03 = ~cntSeqVCrsh03 + 1;
				~cntSeqVCrsh03.switch(
					0,{},
					1, {IFSeqVCrsh.st03(0);},
					2, {IFSeqVCrsh.st03(1);
						~cntSeqVCrsh03=0;
					}
				)}
			);
			},
			'/ifSeq/4/3'
		);
		~ifSeqVCrshBut04.free;
		~ifSeqVCrshBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh04 = ~cntSeqVCrsh04 + 1;
				~cntSeqVCrsh04.switch(
					0,{},
					1, {IFSeqVCrsh.st04(0);},
					2, {IFSeqVCrsh.st04(1);
						~cntSeqVCrsh04=0;
					}
				)}
			);
			},
			'/ifSeq/4/4'
		);
		~ifSeqVCrshBut05.free;
		~ifSeqVCrshBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh05 = ~cntSeqVCrsh05 + 1;
				~cntSeqVCrsh05.switch(
					0,{},
					1, {IFSeqVCrsh.st05(0);},
					2, {IFSeqVCrsh.st05(1);
						~cntSeqVCrsh05=0;
					}
				)}
			);
			},
			'/ifSeq/4/5'
		);
		~ifSeqVCrshBut06.free;
		~ifSeqVCrshBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh06 = ~cntSeqVCrsh06 + 1;
				~cntSeqVCrsh06.switch(
					0,{},
					1, {IFSeqVCrsh.st06(0);},
					2, {IFSeqVCrsh.st06(1);
						~cntSeqVCrsh06=0;
					}
				)}
			);
			},
			'/ifSeq/4/6'
		);
		~ifSeqVCrshBut07.free;
		~ifSeqVCrshBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh07 = ~cntSeqVCrsh07 + 1;
				~cntSeqVCrsh07.switch(
					0,{},
					1, {IFSeqVCrsh.st07(0);},
					2, {IFSeqVCrsh.st07(1);
						~cntSeqVCrsh07=0;
					}
				)}
			);
			},
			'/ifSeq/4/7'
		);
		~ifSeqVCrshBut08.free;
		~ifSeqVCrshBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh08 = ~cntSeqVCrsh08 + 1;
				~cntSeqVCrsh08.switch(
					0,{},
					1, {IFSeqVCrsh.st08(0);},
					2, {IFSeqVCrsh.st08(1);
						~cntSeqVCrsh08=0;
					}
				)}
			);
			},
			'/ifSeq/4/8'
		);
		~ifSeqVCrshBut09.free;
		~ifSeqVCrshBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh09 = ~cntSeqVCrsh09 + 1;
				~cntSeqVCrsh09.switch(
					0,{},
					1, {IFSeqVCrsh.st09(0);},
					2, {IFSeqVCrsh.st09(1);
						~cntSeqVCrsh09=0;
					}
				)}
			);
			},
			'/ifSeq/4/9'
		);
		~ifSeqVCrshBut10.free;
		~ifSeqVCrshBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh10 = ~cntSeqVCrsh10 + 1;
				~cntSeqVCrsh10.switch(
					0,{},
					1, {IFSeqVCrsh.st10(0);},
					2, {IFSeqVCrsh.st10(1);
						~cntSeqVCrsh10=0;
					}
				)}
			);
			},
			'/ifSeq/4/10'
		);
		~ifSeqVCrshBut11.free;
		~ifSeqVCrshBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh11 = ~cntSeqVCrsh11 + 1;
				~cntSeqVCrsh11.switch(
					0,{},
					1, {IFSeqVCrsh.st11(0);},
					2, {IFSeqVCrsh.st11(1);
						~cntSeqVCrsh11=0;
					}
				)}
			);
			},
			'/ifSeq/4/11'
		);
		~ifSeqVCrshBut12.free;
		~ifSeqVCrshBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh12 = ~cntSeqVCrsh12 + 1;
				~cntSeqVCrsh12.switch(
					0,{},
					1, {IFSeqVCrsh.st12(0);},
					2, {IFSeqVCrsh.st12(1);
						~cntSeqVCrsh12=0;
					}
				)}
			);
			},
			'/ifSeq/4/12'
		);
		~ifSeqVCrshBut13.free;
		~ifSeqVCrshBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh13 = ~cntSeqVCrsh13 + 1;
				~cntSeqVCrsh13.switch(
					0,{},
					1, {IFSeqVCrsh.st13(0);},
					2, {IFSeqVCrsh.st13(1);
						~cntSeqVCrsh13=0;
					}
				)}
			);
			},
			'/ifSeq/4/13'
		);
		~ifSeqVCrshBut14.free;
		~ifSeqVCrshBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh14 = ~cntSeqVCrsh14 + 1;
				~cntSeqVCrsh14.switch(
					0,{},
					1, {IFSeqVCrsh.st14(0);},
					2, {IFSeqVCrsh.st14(1);
						~cntSeqVCrsh14=0;
					}
				)}
			);
			},
			'/ifSeq/4/14'
		);
		~ifSeqVCrshBut15.free;
		~ifSeqVCrshBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh15 = ~cntSeqVCrsh15 + 1;
				~cntSeqVCrsh15.switch(
					0,{},
					1, {IFSeqVCrsh.st15(0);},
					2, {IFSeqVCrsh.st15(1);
						~cntSeqVCrsh15=0;
					}
				)}
			);
			},
			'/ifSeq/4/15'
		);
		~ifSeqVCrshBut16.free;
		~ifSeqVCrshBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVCrsh16 = ~cntSeqVCrsh16 + 1;
				~cntSeqVCrsh16.switch(
					0,{},
					1, {IFSeqVCrsh.st16(0);},
					2, {IFSeqVCrsh.st16(1);
						~cntSeqVCrsh16=0;
					}
				)}
			);
			},
			'/ifSeq/4/16'
		);

	}//

	*st01 {|i=0|
		~seqVCrsh01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh01', i);
	}
	*st02 {|i=0|
		~seqVCrsh02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh02', i);
	}
	*st03 {|i=0|
		~seqVCrsh03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh03', i);
	}
	*st04 {|i=0|
		~seqVCrsh04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh04', i);
	}
	*st05 {|i=0|
		~seqVCrsh05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh05', i);
	}
	*st06 {|i=0|
		~seqVCrsh06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh06', i);
	}
	*st07 {|i=0|
		~seqVCrsh07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh07', i);
	}
	*st08 {|i=0|
		~seqVCrsh08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh08', i);
	}
	*st09 {|i=0|
		~seqVCrsh09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh09', i);
	}
	*st10 {|i=0|
		~seqVCrsh10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh10', i);
	}
	*st11 {|i=0|
		~seqVCrsh11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh11', i);
	}
	*st12 {|i=0|
		~seqVCrsh12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh12', i);
	}
	*st13 {|i=0|
		~seqVCrsh13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh13', i);
	}
	*st14 {|i=0|
		~seqVCrsh14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh14', i);
	}
	*st15 {|i=0|
		~seqVCrsh15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh15', i);
	}
	*st16 {|i=0|
		~seqVCrsh16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVCrsh16', i);
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

		~ampVCrsh.source  =  Pseq([~seqVCrsh01.next], inf);
	}
	*step02{

		~ampVCrsh.source  =  Pseq([~seqVCrsh02.next], inf);
	}
	*step03{

		~ampVCrsh.source  =  Pseq([~seqVCrsh03.next], inf);
	}
	*step04{

		~ampVCrsh.source  =  Pseq([~seqVCrsh04.next], inf);
	}
	*step05{

		~ampVCrsh.source  =  Pseq([~seqVCrsh05.next], inf);
	}
	*step06{

		~ampVCrsh.source  =  Pseq([~seqVCrsh06.next], inf);
	}
	*step07{

		~ampVCrsh.source  =  Pseq([~seqVCrsh07.next], inf);
	}
	*step08{

		~ampVCrsh.source  =  Pseq([~seqVCrsh08.next], inf);
	}
	*step09{

		~ampVCrsh.source  =  Pseq([~seqVCrsh09.next], inf);
	}
	*step10{

		~ampVCrsh.source  =  Pseq([~seqVCrsh10.next], inf);
	}
	*step11{

		~ampVCrsh.source  =  Pseq([~seqVCrsh11.next], inf);
	}
	*step12{

		~ampVCrsh.source  =  Pseq([~seqVCrsh12.next], inf);
	}
	*step13{

		~ampVCrsh.source  =  Pseq([~seqVCrsh13.next], inf);
	}
	*step14{

		~ampVCrsh.source  =  Pseq([~seqVCrsh14.next], inf);
	}
	*step15{

		~ampVCrsh.source  =  Pseq([~seqVCrsh15.next], inf);
	}
	*step16{

		~ampVCrsh.source  =  Pseq([~seqVCrsh16.next], inf);
	}



	*stGrp {|i|

		IFSeqVCrsh.st01(i); IFSeqVCrsh.st02(i); IFSeqVCrsh.st03(i); IFSeqVCrsh.st04(i);
		IFSeqVCrsh.st05(i); IFSeqVCrsh.st06(i); IFSeqVCrsh.st07(i); IFSeqVCrsh.st08(i);
		IFSeqVCrsh.st09(i); IFSeqVCrsh.st10(i); IFSeqVCrsh.st11(i); IFSeqVCrsh.st12(i);
		IFSeqVCrsh.st13(i); IFSeqVCrsh.st14(i); IFSeqVCrsh.st15(i); IFSeqVCrsh.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqVCrsh.st01(s01); IFSeqVCrsh.st02(s02); IFSeqVCrsh.st03(s03); IFSeqVCrsh.st04(s04);
		IFSeqVCrsh.st05(s05); IFSeqVCrsh.st06(s06); IFSeqVCrsh.st07(s07); IFSeqVCrsh.st08(s08);
		IFSeqVCrsh.st09(s09); IFSeqVCrsh.st10(s10); IFSeqVCrsh.st11(s11); IFSeqVCrsh.st12(s12);
		IFSeqVCrsh.st13(s13); IFSeqVCrsh.st14(s14); IFSeqVCrsh.st15(s15); IFSeqVCrsh.st16(s16);
	}
}