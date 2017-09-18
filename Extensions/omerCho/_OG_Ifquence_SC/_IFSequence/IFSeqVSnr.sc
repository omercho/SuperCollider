IFSeqVSnr {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqVSnr01 = PatternProxy( Pseq([0], 1));
		~seqVSnr02 = PatternProxy( Pseq([0], 1));
		~seqVSnr03 = PatternProxy( Pseq([0], 1));
		~seqVSnr04 = PatternProxy( Pseq([0], 1));
		~seqVSnr05 = PatternProxy( Pseq([0], 1));
		~seqVSnr06 = PatternProxy( Pseq([0], 1));
		~seqVSnr07 = PatternProxy( Pseq([0], 1));
		~seqVSnr08 = PatternProxy( Pseq([0], 1));

		~seqVSnr09 = PatternProxy( Pseq([0], 1));
		~seqVSnr10 = PatternProxy( Pseq([0], 1));
		~seqVSnr11 = PatternProxy( Pseq([0], 1));
		~seqVSnr12 = PatternProxy( Pseq([0], 1));
		~seqVSnr13 = PatternProxy( Pseq([0], 1));
		~seqVSnr14 = PatternProxy( Pseq([0], 1));
		~seqVSnr15 = PatternProxy( Pseq([0], 1));
		~seqVSnr16 = PatternProxy( Pseq([0], 1));

	}

	*countReset {
		~cntSeqStUpVSnr01=0;
		~cntSeqStRandVSnr01=0;

		~cntSeqVSnr01=0;
		~cntSeqVSnr02=0;
		~cntSeqVSnr03=0;
		~cntSeqVSnr04=0;
		~cntSeqVSnr05=0;
		~cntSeqVSnr06=0;
		~cntSeqVSnr07=0;
		~cntSeqVSnr08=0;

		~cntSeqVSnr09=0;
		~cntSeqVSnr10=0;
		~cntSeqVSnr11=0;
		~cntSeqVSnr12=0;
		~cntSeqVSnr13=0;
		~cntSeqVSnr14=0;
		~cntSeqVSnr15=0;
		~cntSeqVSnr16=0;
	}
	*freeOn {
		~seqFreeVSnrBut.free;
		~seqFreeVSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqVSnr.stGrp(0);
				});
			},
			'/seqFreeVSnr'
		);

	}

	*upOn {
		~ifSeqUpVSnrBut.free;
		~ifSeqUpVSnrBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStUpVSnr01 = ~cntSeqStUpVSnr01 + 1;
				~cntSeqStUpVSnr01.switch(
					0,{},
					1,{IFSeqVSnr.stGrp(0);},
					2,{IFSeqVSnr.stGrp(1);},
					3,{IFSeqVSnr.stGrp(2);},
					4,{IFSeqVSnr.stGrp(3);},
					5,{IFSeqVSnr.stGrp(4);},
					6,{IFSeqVSnr.stGrp(5);},
					7,{IFSeqVSnr.stGrp(6);},
					8,{IFSeqVSnr.stGrp(7);
						~cntSeqStUpVSnr01=0;
					}
				)}
			);
			},
			'/seqUpVSnr'
		);
	}

	*randOn {
		~ifSeqRandVSnrBut.free;
		~ifSeqRandVSnrBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqStRandVSnr01 = ~cntSeqStRandVSnr01 + 1;
				~cntSeqStRandVSnr01.switch(
					0,{},
					1,{
						IFSeqVSnr.st01([0,1].choose);
						IFSeqVSnr.st02([0,1].choose);
						IFSeqVSnr.st03([0,1].choose);
						IFSeqVSnr.st04([0,1].choose);
						IFSeqVSnr.st05([0,1].choose);
						IFSeqVSnr.st06([0,1].choose);
						IFSeqVSnr.st07([0,1].choose);
						IFSeqVSnr.st08([0,1].choose);

						IFSeqVSnr.st09([0,1].choose);
						IFSeqVSnr.st10([0,1].choose);
						IFSeqVSnr.st11([0,1].choose);
						IFSeqVSnr.st12([0,1].choose);
						IFSeqVSnr.st13([0,1].choose);
						IFSeqVSnr.st14([0,1].choose);
						IFSeqVSnr.st15([0,1].choose);
						IFSeqVSnr.st16([0,1].choose);
						~cntSeqStRandVSnr01=0;
					}
				)}
			);
			},
			'/seqRandVSnr'
		);
	}

	*on { // Shift StAVE
		IFSeqVSnr.randOn;
		IFSeqVSnr.upOn;
		IFSeqVSnr.freeOn;

		~ifSeqVSnrBut01.free;
		~ifSeqVSnrBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr01 = ~cntSeqVSnr01 + 1;
				~cntSeqVSnr01.switch(
					0,{},
					1, {IFSeqVSnr.st01(0);},
					2, {IFSeqVSnr.st01(1);
						~cntSeqVSnr01=0;
					}
				)}
			);
			},
			'/ifSeq/4/1'
		);
		~ifSeqVSnrBut02.free;
		~ifSeqVSnrBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr02 = ~cntSeqVSnr02 + 1;
				~cntSeqVSnr02.switch(
					0,{},
					1, {IFSeqVSnr.st02(0);},
					2, {IFSeqVSnr.st02(1);
						~cntSeqVSnr02=0;
					}
				)}
			);
			},
			'/ifSeq/4/2'
		);
		~ifSeqVSnrBut03.free;
		~ifSeqVSnrBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr03 = ~cntSeqVSnr03 + 1;
				~cntSeqVSnr03.switch(
					0,{},
					1, {IFSeqVSnr.st03(0);},
					2, {IFSeqVSnr.st03(1);
						~cntSeqVSnr03=0;
					}
				)}
			);
			},
			'/ifSeq/4/3'
		);
		~ifSeqVSnrBut04.free;
		~ifSeqVSnrBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr04 = ~cntSeqVSnr04 + 1;
				~cntSeqVSnr04.switch(
					0,{},
					1, {IFSeqVSnr.st04(0);},
					2, {IFSeqVSnr.st04(1);
						~cntSeqVSnr04=0;
					}
				)}
			);
			},
			'/ifSeq/4/4'
		);
		~ifSeqVSnrBut05.free;
		~ifSeqVSnrBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr05 = ~cntSeqVSnr05 + 1;
				~cntSeqVSnr05.switch(
					0,{},
					1, {IFSeqVSnr.st05(0);},
					2, {IFSeqVSnr.st05(1);
						~cntSeqVSnr05=0;
					}
				)}
			);
			},
			'/ifSeq/4/5'
		);
		~ifSeqVSnrBut06.free;
		~ifSeqVSnrBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr06 = ~cntSeqVSnr06 + 1;
				~cntSeqVSnr06.switch(
					0,{},
					1, {IFSeqVSnr.st06(0);},
					2, {IFSeqVSnr.st06(1);
						~cntSeqVSnr06=0;
					}
				)}
			);
			},
			'/ifSeq/4/6'
		);
		~ifSeqVSnrBut07.free;
		~ifSeqVSnrBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr07 = ~cntSeqVSnr07 + 1;
				~cntSeqVSnr07.switch(
					0,{},
					1, {IFSeqVSnr.st07(0);},
					2, {IFSeqVSnr.st07(1);
						~cntSeqVSnr07=0;
					}
				)}
			);
			},
			'/ifSeq/4/7'
		);
		~ifSeqVSnrBut08.free;
		~ifSeqVSnrBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr08 = ~cntSeqVSnr08 + 1;
				~cntSeqVSnr08.switch(
					0,{},
					1, {IFSeqVSnr.st08(0);},
					2, {IFSeqVSnr.st08(1);
						~cntSeqVSnr08=0;
					}
				)}
			);
			},
			'/ifSeq/4/8'
		);
		~ifSeqVSnrBut09.free;
		~ifSeqVSnrBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr09 = ~cntSeqVSnr09 + 1;
				~cntSeqVSnr09.switch(
					0,{},
					1, {IFSeqVSnr.st09(0);},
					2, {IFSeqVSnr.st09(1);
						~cntSeqVSnr09=0;
					}
				)}
			);
			},
			'/ifSeq/4/9'
		);
		~ifSeqVSnrBut10.free;
		~ifSeqVSnrBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr10 = ~cntSeqVSnr10 + 1;
				~cntSeqVSnr10.switch(
					0,{},
					1, {IFSeqVSnr.st10(0);},
					2, {IFSeqVSnr.st10(1);
						~cntSeqVSnr10=0;
					}
				)}
			);
			},
			'/ifSeq/4/10'
		);
		~ifSeqVSnrBut11.free;
		~ifSeqVSnrBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr11 = ~cntSeqVSnr11 + 1;
				~cntSeqVSnr11.switch(
					0,{},
					1, {IFSeqVSnr.st11(0);},
					2, {IFSeqVSnr.st11(1);
						~cntSeqVSnr11=0;
					}
				)}
			);
			},
			'/ifSeq/4/11'
		);
		~ifSeqVSnrBut12.free;
		~ifSeqVSnrBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr12 = ~cntSeqVSnr12 + 1;
				~cntSeqVSnr12.switch(
					0,{},
					1, {IFSeqVSnr.st12(0);},
					2, {IFSeqVSnr.st12(1);
						~cntSeqVSnr12=0;
					}
				)}
			);
			},
			'/ifSeq/4/12'
		);
		~ifSeqVSnrBut13.free;
		~ifSeqVSnrBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr13 = ~cntSeqVSnr13 + 1;
				~cntSeqVSnr13.switch(
					0,{},
					1, {IFSeqVSnr.st13(0);},
					2, {IFSeqVSnr.st13(1);
						~cntSeqVSnr13=0;
					}
				)}
			);
			},
			'/ifSeq/4/13'
		);
		~ifSeqVSnrBut14.free;
		~ifSeqVSnrBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr14 = ~cntSeqVSnr14 + 1;
				~cntSeqVSnr14.switch(
					0,{},
					1, {IFSeqVSnr.st14(0);},
					2, {IFSeqVSnr.st14(1);
						~cntSeqVSnr14=0;
					}
				)}
			);
			},
			'/ifSeq/4/14'
		);
		~ifSeqVSnrBut15.free;
		~ifSeqVSnrBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr15 = ~cntSeqVSnr15 + 1;
				~cntSeqVSnr15.switch(
					0,{},
					1, {IFSeqVSnr.st15(0);},
					2, {IFSeqVSnr.st15(1);
						~cntSeqVSnr15=0;
					}
				)}
			);
			},
			'/ifSeq/4/15'
		);
		~ifSeqVSnrBut16.free;
		~ifSeqVSnrBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqVSnr16 = ~cntSeqVSnr16 + 1;
				~cntSeqVSnr16.switch(
					0,{},
					1, {IFSeqVSnr.st16(0);},
					2, {IFSeqVSnr.st16(1);
						~cntSeqVSnr16=0;
					}
				)}
			);
			},
			'/ifSeq/4/16'
		);

	}//

	*st01 {|i=0|
		~seqVSnr01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr01', i);
	}
	*st02 {|i=0|
		~seqVSnr02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr02', i);
	}
	*st03 {|i=0|
		~seqVSnr03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr03', i);
	}
	*st04 {|i=0|
		~seqVSnr04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr04', i);
	}
	*st05 {|i=0|
		~seqVSnr05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr05', i);
	}
	*st06 {|i=0|
		~seqVSnr06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr06', i);
	}
	*st07 {|i=0|
		~seqVSnr07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr07', i);
	}
	*st08 {|i=0|
		~seqVSnr08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr08', i);
	}
	*st09 {|i=0|
		~seqVSnr09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr09', i);
	}
	*st10 {|i=0|
		~seqVSnr10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr10', i);
	}
	*st11 {|i=0|
		~seqVSnr11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr11', i);
	}
	*st12 {|i=0|
		~seqVSnr12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr12', i);
	}
	*st13 {|i=0|
		~seqVSnr13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr13', i);
	}
	*st14 {|i=0|
		~seqVSnr14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr14', i);
	}
	*st15 {|i=0|
		~seqVSnr15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr15', i);
	}
	*st16 {|i=0|
		~seqVSnr16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shVSnr16', i);
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

		~ampVSnr.source  =  Pseq([~seqVSnr01.next], inf);
	}
	*step02{

		~ampVSnr.source  =  Pseq([~seqVSnr02.next], inf);
	}
	*step03{

		~ampVSnr.source  =  Pseq([~seqVSnr03.next], inf);
	}
	*step04{

		~ampVSnr.source  =  Pseq([~seqVSnr04.next], inf);
	}
	*step05{

		~ampVSnr.source  =  Pseq([~seqVSnr05.next], inf);
	}
	*step06{

		~ampVSnr.source  =  Pseq([~seqVSnr06.next], inf);
	}
	*step07{

		~ampVSnr.source  =  Pseq([~seqVSnr07.next], inf);
	}
	*step08{

		~ampVSnr.source  =  Pseq([~seqVSnr08.next], inf);
	}
	*step09{

		~ampVSnr.source  =  Pseq([~seqVSnr09.next], inf);
	}
	*step10{

		~ampVSnr.source  =  Pseq([~seqVSnr10.next], inf);
	}
	*step11{

		~ampVSnr.source  =  Pseq([~seqVSnr11.next], inf);
	}
	*step12{

		~ampVSnr.source  =  Pseq([~seqVSnr12.next], inf);
	}
	*step13{

		~ampVSnr.source  =  Pseq([~seqVSnr13.next], inf);
	}
	*step14{

		~ampVSnr.source  =  Pseq([~seqVSnr14.next], inf);
	}
	*step15{

		~ampVSnr.source  =  Pseq([~seqVSnr15.next], inf);
	}
	*step16{

		~ampVSnr.source  =  Pseq([~seqVSnr16.next], inf);
	}



	*stGrp {|i|

		IFSeqVSnr.st01(i); IFSeqVSnr.st02(i); IFSeqVSnr.st03(i); IFSeqVSnr.st04(i);
		IFSeqVSnr.st05(i); IFSeqVSnr.st06(i); IFSeqVSnr.st07(i); IFSeqVSnr.st08(i);
		IFSeqVSnr.st09(i); IFSeqVSnr.st10(i); IFSeqVSnr.st11(i); IFSeqVSnr.st12(i);
		IFSeqVSnr.st13(i); IFSeqVSnr.st14(i); IFSeqVSnr.st15(i); IFSeqVSnr.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		IFSeqVSnr.st01(s01); IFSeqVSnr.st02(s02); IFSeqVSnr.st03(s03); IFSeqVSnr.st04(s04);
		IFSeqVSnr.st05(s05); IFSeqVSnr.st06(s06); IFSeqVSnr.st07(s07); IFSeqVSnr.st08(s08);
		IFSeqVSnr.st09(s09); IFSeqVSnr.st10(s10); IFSeqVSnr.st11(s11); IFSeqVSnr.st12(s12);
		IFSeqVSnr.st13(s13); IFSeqVSnr.st14(s14); IFSeqVSnr.st15(s15); IFSeqVSnr.st16(s16);
	}
}