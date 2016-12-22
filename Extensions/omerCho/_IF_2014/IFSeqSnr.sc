/*
IFSeqSnr.st16(0);
IFSeqSnr.stepPack(1);
*/

IFSeqSnr {
	*loadAll {

		this.loadProxy;
		this.countReset;

		IFSeqOctSnr.loadAll;
		IFSeqNtSnr.loadAll;
		IFSeqVelSnr.loadAll;
		IFSeqSusSnr.loadAll;
		IFSeqTmSnr.loadAll;
		this.on;
	}

	*loadProxy {

		~seqSnr01 = PatternProxy( Pseq([0], 1));
		~seqSnr02 = PatternProxy( Pseq([0], 1));
		~seqSnr03 = PatternProxy( Pseq([0], 1));
		~seqSnr04 = PatternProxy( Pseq([0], 1));
		~seqSnr05 = PatternProxy( Pseq([0], 1));
		~seqSnr06 = PatternProxy( Pseq([0], 1));
		~seqSnr07 = PatternProxy( Pseq([0], 1));
		~seqSnr08 = PatternProxy( Pseq([0], 1));

		~seqSnr09 = PatternProxy( Pseq([0], 1));
		~seqSnr10 = PatternProxy( Pseq([0], 1));
		~seqSnr11 = PatternProxy( Pseq([0], 1));
		~seqSnr12 = PatternProxy( Pseq([0], 1));
		~seqSnr13 = PatternProxy( Pseq([0], 1));
		~seqSnr14 = PatternProxy( Pseq([0], 1));
		~seqSnr15 = PatternProxy( Pseq([0], 1));
		~seqSnr16 = PatternProxy( Pseq([0], 1));
	}


	*free {
		~cntSeqUpSnr01=0;
		~cntSeqRandSnr01=0;

		IFSeqSnr.st01(0);
		IFSeqSnr.st02(0);
		IFSeqSnr.st03(0);
		IFSeqSnr.st04(0);
		IFSeqSnr.st05(0);
		IFSeqSnr.st06(0);
		IFSeqSnr.st07(0);
		IFSeqSnr.st08(0);

		IFSeqSnr.st09(0);
		IFSeqSnr.st10(0);
		IFSeqSnr.st11(0);
		IFSeqSnr.st12(0);
		IFSeqSnr.st13(0);
		IFSeqSnr.st14(0);
		IFSeqSnr.st15(0);
		IFSeqSnr.st16(0);
	}

	*countReset {
		~cntSeqUpSnr01=0;
		~cntSeqRandSnr01=0;

		~cntSeqSnr01=0;
		~cntSeqSnr02=0;
		~cntSeqSnr03=0;
		~cntSeqSnr04=0;
		~cntSeqSnr05=0;
		~cntSeqSnr06=0;
		~cntSeqSnr07=0;
		~cntSeqSnr08=0;

		~cntSeqSnr09=0;
		~cntSeqSnr10=0;
		~cntSeqSnr11=0;
		~cntSeqSnr12=0;
		~cntSeqSnr13=0;
		~cntSeqSnr14=0;
		~cntSeqSnr15=0;
		~cntSeqSnr16=0;
	}

	*freeOn {

		~seqFreeSnrBut.free;
		~seqFreeSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSnr.free;
				});
			},
			'/seqFreeSnr'
		);
	}
	*upOn {
		~ifSeqUpSnrBut.free;
		~ifSeqUpSnrBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqUpSnr01 = ~cntSeqUpSnr01 + 1;
				~cntSeqUpSnr01.switch(
					0,{},
					1,{
						IFSeqSnr.st01(1);
						IFSeqSnr.st02(0);
						IFSeqSnr.st03(0);
						IFSeqSnr.st04(0);
						IFSeqSnr.st05(1);
						IFSeqSnr.st06(0);
						IFSeqSnr.st07(0);
						IFSeqSnr.st08(0);

						IFSeqSnr.st09(1);
						IFSeqSnr.st10(0);
						IFSeqSnr.st11(0);
						IFSeqSnr.st12(0);
						IFSeqSnr.st13(1);
						IFSeqSnr.st14(0);
						IFSeqSnr.st15(0);
						IFSeqSnr.st16(0);
					},
					2,{
						IFSeqSnr.st01(1);
						IFSeqSnr.st02(0);
						IFSeqSnr.st03(1);
						IFSeqSnr.st04(0);
						IFSeqSnr.st05(1);
						IFSeqSnr.st06(0);
						IFSeqSnr.st07(1);
						IFSeqSnr.st08(0);

						IFSeqSnr.st09(1);
						IFSeqSnr.st10(0);
						IFSeqSnr.st11(1);
						IFSeqSnr.st12(0);
						IFSeqSnr.st13(1);
						IFSeqSnr.st14(0);
						IFSeqSnr.st15(1);
						IFSeqSnr.st16(0);
					},
					3,{
						IFSeqSnr.st01(1);
						IFSeqSnr.st02(0);
						IFSeqSnr.st03(1);
						IFSeqSnr.st04(0);
						IFSeqSnr.st05(1);
						IFSeqSnr.st06(0);
						IFSeqSnr.st07(1);
						IFSeqSnr.st08(0);

						IFSeqSnr.st09(1);
						IFSeqSnr.st10(0);
						IFSeqSnr.st11(1);
						IFSeqSnr.st12(0);
						IFSeqSnr.st13(1);
						IFSeqSnr.st14(1);
						IFSeqSnr.st15(0);
						IFSeqSnr.st16(0);
					},
					4,{
						IFSeqSnr.st01(1);
						IFSeqSnr.st02(1);
						IFSeqSnr.st03(0);
						IFSeqSnr.st04(0);
						IFSeqSnr.st05(1);
						IFSeqSnr.st06(0);
						IFSeqSnr.st07(1);
						IFSeqSnr.st08(0);

						IFSeqSnr.st09(1);
						IFSeqSnr.st10(1);
						IFSeqSnr.st11(0);
						IFSeqSnr.st12(1);
						IFSeqSnr.st13(1);
						IFSeqSnr.st14(0);
						IFSeqSnr.st15(1);
						IFSeqSnr.st16(0);
						~cntSeqUpSnr01=0;
					}
				)}
			);
			},
			'/seqUpSnr'
		);
	}

	*randOn {
		~ifSeqRandSnrBut.free;
		~ifSeqRandSnrBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqRandSnr01 = ~cntSeqRandSnr01 + 1;
				~cntSeqRandSnr01.switch(
					0,{},
					1,{
						IFSeqSnr.st01([0,1].choose);
						IFSeqSnr.st02([0,1].choose);
						IFSeqSnr.st03([0,1].choose);
						IFSeqSnr.st04([0,1].choose);
						IFSeqSnr.st05([0,1].choose);
						IFSeqSnr.st06([0,1].choose);
						IFSeqSnr.st07([0,1].choose);
						IFSeqSnr.st08([0,1].choose);
						IFSeqSnr.st09([0,1].choose);
						IFSeqSnr.st10([0,1].choose);
						IFSeqSnr.st11([0,1].choose);
						IFSeqSnr.st12([0,1].choose);
						IFSeqSnr.st13([0,1].choose);
						IFSeqSnr.st14([0,1].choose);
						IFSeqSnr.st15([0,1].choose);
						IFSeqSnr.st16([0,1].choose);
						~cntSeqRandSnr01=0;
					}
				)}
			);
			},
			'/seqRandSnr'
		);
	}

	*on {
		IFSeqSnr.upOn;
		IFSeqSnr.randOn;
		IFSeqSnr.freeOn;

		~ifSeqSnrBut01.free;
		~ifSeqSnrBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr01 = ~cntSeqSnr01 + 1;
				~cntSeqSnr01.switch(
					0,{}, 1,{IFSeqSnr.st01(1);}, 2,{IFSeqSnr.st01(0);}
				)}
			);
			},
			'/ifSeq/2/1'
		);
		~ifSeqSnrBut02.free;
		~ifSeqSnrBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr02 = ~cntSeqSnr02 + 1;
				~cntSeqSnr02.switch(
					0,{}, 1,{IFSeqSnr.st02(1);}, 2,{IFSeqSnr.st02(0);}
				)}
			);
			},
			'/ifSeq/2/2'
		);
		~ifSeqSnrBut03.free;
		~ifSeqSnrBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr03 = ~cntSeqSnr03 + 1;
				~cntSeqSnr03.switch(
					0,{}, 1,{IFSeqSnr.st03(1);}, 2,{IFSeqSnr.st03(0);}
				)}
			);
			},
			'/ifSeq/2/3'
		);
		~ifSeqSnrBut04.free;
		~ifSeqSnrBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr04 = ~cntSeqSnr04 + 1;
				~cntSeqSnr04.switch(
					0,{}, 1,{IFSeqSnr.st04(1);}, 2,{IFSeqSnr.st04(0);}
				)}
			);
			},
			'/ifSeq/2/4'
		);
		~ifSeqSnrBut05.free;
		~ifSeqSnrBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr05 = ~cntSeqSnr05 + 1;
				~cntSeqSnr05.switch(
					0,{}, 1,{IFSeqSnr.st05(1);}, 2,{IFSeqSnr.st05(0);}
				)}
			);
			},
			'/ifSeq/2/5'
		);
		~ifSeqSnrBut06.free;
		~ifSeqSnrBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr06 = ~cntSeqSnr06 + 1;
				~cntSeqSnr06.switch(
					0,{}, 1,{IFSeqSnr.st06(1);}, 2,{IFSeqSnr.st06(0);}
				)}
			);
			},
			'/ifSeq/2/6'
		);
		~ifSeqSnrBut07.free;
		~ifSeqSnrBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr07 = ~cntSeqSnr07 + 1;
				~cntSeqSnr07.switch(
					0,{}, 1,{IFSeqSnr.st07(1);}, 2,{IFSeqSnr.st07(0);}
				)}
			);
			},
			'/ifSeq/2/7'
		);
		~ifSeqSnrBut08.free;
		~ifSeqSnrBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr08 = ~cntSeqSnr08 + 1;
				~cntSeqSnr08.switch(
					0,{}, 1,{IFSeqSnr.st08(1);}, 2,{IFSeqSnr.st08(0);}
				)}
			);
			},
			'/ifSeq/2/8'
		);

		~ifSeqSnrBut09.free;
		~ifSeqSnrBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr09 = ~cntSeqSnr09 + 1;
				~cntSeqSnr09.switch(
					0,{}, 1,{IFSeqSnr.st09(1);}, 2,{IFSeqSnr.st09(0);}
				)}
			);
			},
			'/ifSeq/2/9'
		);
		~ifSeqSnrBut10.free;
		~ifSeqSnrBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr10 = ~cntSeqSnr10 + 1;
				~cntSeqSnr10.switch(
					0,{}, 1,{IFSeqSnr.st10(1);}, 2,{IFSeqSnr.st10(0);}
				)}
			);
			},
			'/ifSeq/2/10'
		);
		~ifSeqSnrBut11.free;
		~ifSeqSnrBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr11 = ~cntSeqSnr11 + 1;
				~cntSeqSnr11.switch(
					0,{}, 1,{IFSeqSnr.st11(1);}, 2,{IFSeqSnr.st11(0);}
				)}
			);
			},
			'/ifSeq/2/11'
		);
		~ifSeqSnrBut12.free;
		~ifSeqSnrBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr12 = ~cntSeqSnr12 + 1;
				~cntSeqSnr12.switch(
					0,{}, 1,{IFSeqSnr.st12(1);}, 2,{IFSeqSnr.st12(0);}
				)}
			);
			},
			'/ifSeq/2/12'
		);
		~ifSeqSnrBut13.free;
		~ifSeqSnrBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr13 = ~cntSeqSnr13 + 1;
				~cntSeqSnr13.switch(
					0,{}, 1,{IFSeqSnr.st13(1);}, 2,{IFSeqSnr.st13(0);}
				)}
			);
			},
			'/ifSeq/2/13'
		);
		~ifSeqSnrBut14.free;
		~ifSeqSnrBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr14 = ~cntSeqSnr14 + 1;
				~cntSeqSnr14.switch(
					0,{}, 1,{IFSeqSnr.st14(1);}, 2,{IFSeqSnr.st14(0);}
				)}
			);
			},
			'/ifSeq/2/14'
		);
		~ifSeqSnrBut15.free;
		~ifSeqSnrBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr15 = ~cntSeqSnr15 + 1;
				~cntSeqSnr15.switch(
					0,{}, 1,{IFSeqSnr.st15(1);}, 2,{IFSeqSnr.st15(0);}
				)}
			);
			},
			'/ifSeq/2/15'
		);
		~ifSeqSnrBut16.free;
		~ifSeqSnrBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqSnr16 = ~cntSeqSnr16 + 1;
				~cntSeqSnr16.switch(
					0,{}, 1,{IFSeqSnr.st16(1);}, 2,{IFSeqSnr.st16(0);}
				)}
			);
			},
			'/ifSeq/2/16'
		);


	}

	*st01 {|i|
		~cntSeqSnr01=i;
		~seqSnr01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr01', i);
	}
	*st02 {|i|
		~cntSeqSnr02=i;
		~seqSnr02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr02', i);
	}
	*st03 {|i|
		~cntSeqSnr03=i;
		~seqSnr03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr03', i);
	}
	*st04 {|i|
		~cntSeqSnr04=i;
		~seqSnr04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr04', i);
	}
	*st05 {|i|
		~cntSeqSnr05=i;
		~seqSnr05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr05', i);
	}
	*st06 {|i|
		~cntSeqSnr06=i;
		~seqSnr06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr06', i);
	}
	*st07 {|i|
		~cntSeqSnr07=i;
		~seqSnr07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr07', i);
	}
	*st08 {|i|
		~cntSeqSnr08=i;
		~seqSnr08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr08', i);
	}

	*st09 {|i|
		~cntSeqSnr01=i;
		~seqSnr09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr09', i);
	}
	*st10 {|i|
		~cntSeqSnr10=i;
		~seqSnr10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr10', i);
	}
	*st11 {|i|
		~cntSeqSnr11=i;
		~seqSnr11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr11', i);
	}
	*st12 {|i|
		~cntSeqSnr12=i;
		~seqSnr12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr12', i);
	}
	*st13 {|i|
		~cntSeqSnr13=i;
		~seqSnr13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr13', i);
	}
	*st14 {|i|
		~cntSeqSnr14=i;
		~seqSnr14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr14', i);
	}
	*st15 {|i|
		~cntSeqSnr15=i;
		~seqSnr15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr15', i);
	}
	*st16 {|i|
		~cntSeqSnr16=i;
		~seqSnr16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('ledSnr16', i);
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
		~amp1Snr.source  =  Pseq([~seqSnr01.next*~seqVelSnr01.next], inf);
		~octSnr.source = Pseq([~seqOctSnr01.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr01.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr01.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr01.next], inf);
	}
	*step02{
		~amp1Snr.source  =  Pseq([~seqSnr02.next*~seqVelSnr02.next], inf);
		~octSnr.source = Pseq([~seqOctSnr02.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr02.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr02.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr02.next], inf);
	}
	*step03{
		~amp1Snr.source  =  Pseq([~seqSnr03.next*~seqVelSnr03.next], inf);
		~octSnr.source = Pseq([~seqOctSnr03.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr03.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr03.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr03.next], inf);
	}
	*step04{
		~amp1Snr.source  =  Pseq([~seqSnr04.next*~seqVelSnr04.next], inf);
		~octSnr.source = Pseq([~seqOctSnr04.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr04.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr04.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr04.next], inf);
	}
	*step05{
		~amp1Snr.source  =  Pseq([~seqSnr05.next*~seqVelSnr05.next], inf);
		~octSnr.source = Pseq([~seqOctSnr05.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr05.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr05.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr05.next], inf);
	}
	*step06{
		~amp1Snr.source  =  Pseq([~seqSnr06.next*~seqVelSnr06.next], inf);
		~octSnr.source = Pseq([~seqOctSnr06.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr06.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr06.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr06.next], inf);
	}
	*step07{
		~amp1Snr.source  =  Pseq([~seqSnr07.next*~seqVelSnr07.next], inf);
		~octSnr.source = Pseq([~seqOctSnr07.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr07.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr07.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr07.next], inf);
	}
	*step08{
		~amp1Snr.source  =  Pseq([~seqSnr08.next*~seqVelSnr08.next], inf);
		~octSnr.source = Pseq([~seqOctSnr08.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr08.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr08.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr08.next], inf);
	}
	*step09{
		~amp1Snr.source  =  Pseq([~seqSnr09.next*~seqVelSnr09.next], inf);
		~octSnr.source = Pseq([~seqOctSnr09.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr09.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr09.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr09.next], inf);
	}
	*step10{
		~amp1Snr.source  =  Pseq([~seqSnr10.next*~seqVelSnr10.next], inf);
		~octSnr.source = Pseq([~seqOctSnr10.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr10.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr10.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr10.next], inf);
	}
	*step11{
		~amp1Snr.source  =  Pseq([~seqSnr11.next*~seqVelSnr11.next], inf);
		~octSnr.source = Pseq([~seqOctSnr11.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr11.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr11.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr11.next], inf);
	}
	*step12{
		~amp1Snr.source  =  Pseq([~seqSnr12.next*~seqVelSnr12.next], inf);
		~octSnr.source = Pseq([~seqOctSnr12.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr12.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr12.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr12.next], inf);
	}
	*step13{
		~amp1Snr.source  =  Pseq([~seqSnr13.next*~seqVelSnr13.next], inf);
		~octSnr.source = Pseq([~seqOctSnr13.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr13.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr13.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr13.next], inf);
	}
	*step14{
		~amp1Snr.source  =  Pseq([~seqSnr14.next*~seqVelSnr14.next], inf);
		~octSnr.source = Pseq([~seqOctSnr14.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr14.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr14.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr14.next], inf);
	}
	*step15{
		~amp1Snr.source  =  Pseq([~seqSnr15.next*~seqVelSnr15.next], inf);
		~octSnr.source = Pseq([~seqOctSnr15.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr15.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr15.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr15.next], inf);
	}
	*step16{
		~amp1Snr.source  =  Pseq([~seqSnr16.next*~seqVelSnr16.next], inf);
		~octSnr.source = Pseq([~seqOctSnr16.next], inf);
		~nt1Snr.source   =  Pseq([~seqNtSnr16.next], inf);
		~sus1Snr.source  =  Pseq([~seqSusSnr16.next], inf);
		~tmSnr.source    =  Pseq([~seqTmSnr16.next], inf);
	}

}

