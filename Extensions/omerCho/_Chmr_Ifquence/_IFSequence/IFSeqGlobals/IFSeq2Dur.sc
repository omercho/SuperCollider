IFSeq2Dur {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {
		/*~durResp.free;
		~durResp = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Pattern 1".postln;
				~tOSCAdrr.sendMsg('durMasterLabel', 'Strght 02');
				~dur1.source = Pseq([
					~seq2Dur01,~seq2Dur02,~seq2Dur03,~seq2Dur04,
					~seq2Dur05,~seq2Dur06,~seq2Dur07,~seq2Dur08,
					~seq2Dur09,~seq2Dur10,~seq2Dur11,~seq2Dur12,
					~seq2Dur13,~seq2Dur14,~seq2Dur15,~seq2Dur16
				],inf)*~dur1MulP.next;
			});
		},'/durResponder');*/

		~seq2Dur01 = PatternProxy( Pseq([1], 1));
		~seq2Dur02 = PatternProxy( Pseq([1], 1));
		~seq2Dur03 = PatternProxy( Pseq([1], 1));
		~seq2Dur04 = PatternProxy( Pseq([1], 1));
		~seq2Dur05 = PatternProxy( Pseq([1], 1));
		~seq2Dur06 = PatternProxy( Pseq([1], 1));
		~seq2Dur07 = PatternProxy( Pseq([1], 1));
		~seq2Dur08 = PatternProxy( Pseq([1], 1));

		~seq2Dur09 = PatternProxy( Pseq([1], 1));
		~seq2Dur10 = PatternProxy( Pseq([1], 1));
		~seq2Dur11 = PatternProxy( Pseq([1], 1));
		~seq2Dur12 = PatternProxy( Pseq([1], 1));
		~seq2Dur13 = PatternProxy( Pseq([1], 1));
		~seq2Dur14 = PatternProxy( Pseq([1], 1));
		~seq2Dur15 = PatternProxy( Pseq([1], 1));
		~seq2Dur16 = PatternProxy( Pseq([1], 1));

	}

	*loadButtons {


	}

	*countReset {
		~cntSeq2DurUpPat01=0;
		~cntSeq2DurRandPat01=0;

		~cntSeq2DurPat01=0;
		~cntSeq2DurPat02=0;
		~cntSeq2DurPat03=0;
		~cntSeq2DurPat04=0;
		~cntSeq2DurPat05=0;
		~cntSeq2DurPat06=0;
		~cntSeq2DurPat07=0;
		~cntSeq2DurPat08=0;

		~cntSeq2DurPat09=0;
		~cntSeq2DurPat10=0;
		~cntSeq2DurPat11=0;
		~cntSeq2DurPat12=0;
		~cntSeq2DurPat13=0;
		~cntSeq2DurPat14=0;
		~cntSeq2DurPat15=0;
		~cntSeq2DurPat16=0;
	}
	*freeOn {
		~seqFreePatBut.free;
		~seqFreePatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.stGrp(4);
				});
			},
			'/seqFreePat'
		);
	}
	*upOn {
		~ifSeqUpPatBut.free;
		~ifSeqUpPatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurUpPat01 = ~cntSeq2DurUpPat01 + 1;
				~cntSeq2DurUpPat01.switch(
					0,{},
					1,{this.stGrp(1);},
					2,{this.stGrp(2);},
					3,{this.stGrp(3);},
					4,{this.stGrp(4);},
					5,{this.stGrp(5);~cntSeq2DurUpPat01=0;}
				)}
			);
			},
			'/seqUpPat'
		);
	}

	*randOn {
		~ifSeqRandPatBut.free;
		~ifSeqRandPatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurRandPat01 = ~cntSeq2DurRandPat01 + 1;
				~cntSeq2DurRandPat01.switch(
					0,{},
					1,{
						this.st01([1,2,3,4,5].choose);
						this.st02([1,2,3,4,5].choose);
						this.st03([1,2,3,4,5].choose);
						this.st04([1,2,3,4,5].choose);
						this.st05([1,2,3,4,5].choose);
						this.st06([1,2,3,4,5].choose);
						this.st07([1,2,3,4,5].choose);
						this.st08([1,2,3,4,5].choose);

						this.st09([1,2,3,4,5].choose);
						this.st10([1,2,3,4,5].choose);
						this.st11([1,2,3,4,5].choose);
						this.st12([1,2,3,4,5].choose);
						this.st13([1,2,3,4,5].choose);
						this.st14([1,2,3,4,5].choose);
						this.st15([1,2,3,4,5].choose);
						this.st16([1,2,3,4,5].choose);
						~cntSeq2DurRandPat01=0;
					}
				)}
			);
			},
			'/seqRandPat'
		);
	}


	*on { // Shift Durocity

		this.randOn;
		this.upOn;
		this.freeOn;

		~ifSeq2PatBut01.free;
		~ifSeq2PatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat01 = ~cntSeq2DurPat01 + 1;
				~cntSeq2DurPat01.switch(
					0,{},
					1, {this.st01(1);},
					2, {this.st01(2);},
					3, {this.st01(3);},
					4, {this.st01(4);},
					5, {this.st01(5);}
				)}
			);
			},
			'/ifSeq/8/1'
		);
		~ifSeq2PatBut02.free;
		~ifSeq2PatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat02 = ~cntSeq2DurPat02 + 1;
				~cntSeq2DurPat02.switch(
					0,{},
					1, {this.st02(1);},
					2, {this.st02(2);},
					3, {this.st02(3);},
					4, {this.st02(4);},
					5, {this.st02(5);}
				)}
			);
			},
			'/ifSeq/8/2'
		);
		~ifSeq2PatBut03.free;
		~ifSeq2PatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat03 = ~cntSeq2DurPat03 + 1;
				~cntSeq2DurPat03.switch(
					0,{},
					1, {this.st03(1);},
					2, {this.st03(2);},
					3, {this.st03(3);},
					4, {this.st03(4);},
					5, {this.st03(5);}
				)}
			);
			},
			'/ifSeq/8/3'
		);
		~ifSeq2PatBut04.free;
		~ifSeq2PatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat04 = ~cntSeq2DurPat04 + 1;
				~cntSeq2DurPat04.switch(
					0,{},
					1, {this.st04(1);},
					2, {this.st04(2);},
					3, {this.st04(3);},
					4, {this.st04(4);},
					5, {this.st04(5);}
				)}
			);
			},
			'/ifSeq/8/4'
		);
		~ifSeq2PatBut05.free;
		~ifSeq2PatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat05 = ~cntSeq2DurPat05 + 1;
				~cntSeq2DurPat05.switch(
					0,{},
					1, {this.st05(1);},
					2, {this.st05(2);},
					3, {this.st05(3);},
					4, {this.st05(4);},
					5, {this.st05(5);}
				)}
			);
			},
			'/ifSeq/8/5'
		);
		~ifSeq2PatBut06.free;
		~ifSeq2PatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat06 = ~cntSeq2DurPat06 + 1;
				~cntSeq2DurPat06.switch(
					0,{},
					1, {this.st06(1);},
					2, {this.st06(2);},
					3, {this.st06(3);},
					4, {this.st06(4);},
					5, {this.st06(5);}
				)}
			);
			},
			'/ifSeq/8/6'
		);
		~ifSeq2PatBut07.free;
		~ifSeq2PatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat07 = ~cntSeq2DurPat07 + 1;
				~cntSeq2DurPat07.switch(
					0,{},
					1, {this.st07(1);},
					2, {this.st07(2);},
					3, {this.st07(3);},
					4, {this.st07(4);},
					5, {this.st07(5);}
				)}
			);
			},
			'/ifSeq/8/7'
		);
		~ifSeq2PatBut08.free;
		~ifSeq2PatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat08 = ~cntSeq2DurPat08 + 1;
				~cntSeq2DurPat08.switch(
					0,{},
					1, {this.st08(1);},
					2, {this.st08(2);},
					3, {this.st08(3);},
					4, {this.st08(4);},
					5, {this.st08(5);}
				)}
			);
			},
			'/ifSeq/8/8'
		);

		~ifSeq2PatBut09.free;
		~ifSeq2PatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat09 = ~cntSeq2DurPat09 + 1;
				~cntSeq2DurPat09.switch(
					0,{},
					1, {this.st09(1);},
					2, {this.st09(2);},
					3, {this.st09(3);},
					4, {this.st09(4);},
					5, {this.st09(5);}
				)}
			);
			},
			'/ifSeq/8/9'
		);
		~ifSeq2PatBut10.free;
		~ifSeq2PatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat10 = ~cntSeq2DurPat10 + 1;
				~cntSeq2DurPat10.switch(
					0,{},
					1, {this.st10(1);},
					2, {this.st10(2);},
					3, {this.st10(3);},
					4, {this.st10(4);},
					5, {this.st10(5);}
				)}
			);
			},
			'/ifSeq/8/10'
		);
		~ifSeq2PatBut11.free;
		~ifSeq2PatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat11 = ~cntSeq2DurPat11 + 1;
				~cntSeq2DurPat11.switch(
					0,{},
					1, {this.st11(1);},
					2, {this.st11(2);},
					3, {this.st11(3);},
					4, {this.st11(4);},
					5, {this.st11(5);}
				)}
			);
			},
			'/ifSeq/8/11'
		);
		~ifSeq2PatBut12.free;
		~ifSeq2PatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat12 = ~cntSeq2DurPat12 + 1;
				~cntSeq2DurPat12.switch(
					0,{},
					1, {this.st12(1);},
					2, {this.st12(2);},
					3, {this.st12(3);},
					4, {this.st12(4);},
					5, {this.st12(5);}
				)}
			);
			},
			'/ifSeq/8/12'
		);
		~ifSeq2PatBut13.free;
		~ifSeq2PatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat13 = ~cntSeq2DurPat13 + 1;
				~cntSeq2DurPat13.switch(
					0,{},
					1, {this.st13(1);},
					2, {this.st13(2);},
					3, {this.st13(3);},
					4, {this.st13(4);},
					5, {this.st13(5);}
				)}
			);
			},
			'/ifSeq/8/13'
		);
		~ifSeq2PatBut14.free;
		~ifSeq2PatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat14 = ~cntSeq2DurPat14 + 1;
				~cntSeq2DurPat14.switch(
					0,{},
					1, {this.st14(1);},
					2, {this.st14(2);},
					3, {this.st14(3);},
					4, {this.st14(4);},
					5, {this.st14(5);}
				)}
			);
			},
			'/ifSeq/8/14'
		);
		~ifSeq2PatBut15.free;
		~ifSeq2PatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat15 = ~cntSeq2DurPat15 + 1;
				~cntSeq2DurPat15.switch(
					0,{},
					1, {this.st15(1);},
					2, {this.st15(2);},
					3, {this.st15(3);},
					4, {this.st15(4);},
					5, {this.st15(5);}
				)}
			);
			},
			'/ifSeq/8/15'
		);
		~ifSeq2PatBut16.free;
		~ifSeq2PatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeq2DurPat16 = ~cntSeq2DurPat16 + 1;
				~cntSeq2DurPat16.switch(
					0,{},
					1, {this.st16(1);},
					2, {this.st16(2);},
					3, {this.st16(3);},
					4, {this.st16(4);},
					5, {this.st16(5);}
				)}
			);
			},
			'/ifSeq/8/16'
		);

	}


	*st01 {|i|
		case
		{ i == 1 }  {
			~seq2Dur01.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat01', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur01.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat01', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur01.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat01', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur01.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat01', '4/1');
		}
	}
	*st02 {|i|
		case
		{ i == 1 }  {
			~seq2Dur02.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat02', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur02.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat02', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur02.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat02', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur02.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat02', '4/1');
		}
	}
	*st03 {|i|
		case
		{ i == 1 }  {
			~seq2Dur03.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat03', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur03.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat03', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur03.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat03', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur03.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat03', '4/1');
		}
	}
	*st04 {|i|
		case
		{ i == 1 }  {
			~seq2Dur04.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat04', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur04.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat04', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur04.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat04', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur04.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat04', '4/1');
		}
	}
	*st05 {|i|
		case
		{ i == 1 }  {
			~seq2Dur05.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat05', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur05.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat05', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur05.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat05', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur05.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat05', '4/1');
		}
	}
	*st06 {|i|
		case
		{ i == 1 }  {
			~seq2Dur06.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat06', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur06.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat06', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur06.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat06', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur06.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat06', '4/1');
		}
	}
	*st07 {|i|
		case
		{ i == 1 }  {
			~seq2Dur07.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat07', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur07.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat07', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur07.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat07', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur07.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat07', '4/1');
		}
	}
	*st08 {|i|
		case
		{ i == 1 }  {
			~seq2Dur08.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat08', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur08.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat08', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur08.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat08', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur08.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat08', '4/1');
		}
	}

	*st09 {|i|
		case
		{ i == 1 }  {
			~seq2Dur09.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat09', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur09.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat09', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur09.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat09', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur09.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat09', '4/1');
		}
	}
	*st10 {|i|
		case
		{ i == 1 }  {
			~seq2Dur10.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat10', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur10.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat10', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur10.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat10', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur10.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat10', '4/1');
		}
	}
	*st11 {|i|
		case
		{ i == 1 }  {
			~seq2Dur11.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat11', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur11.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat11', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur11.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat11', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur11.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat11', '4/1');
		}
	}
	*st12 {|i|
		case
		{ i == 1 }  {
			~seq2Dur12.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat12', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur12.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat12', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur12.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat12', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur12.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat12', '4/1');
		}
	}
	*st13 {|i|
		case
		{ i == 1 }  {
			~seq2Dur13.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat13', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur13.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat13', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur13.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat13', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur13.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat13', '4/1');
		}
	}
	*st14 {|i|
		case
		{ i == 1 }  {
			~seq2Dur14.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat14', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur14.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat14', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur14.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat14', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur14.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat14', '4/1');
		}
	}
	*st15 {|i|
		case
		{ i == 1 }  {
			~seq2Dur15.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat15', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur15.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat15', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur15.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat15', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur15.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat15', '4/1');
		}
	}
	*st16 {|i|
		case
		{ i == 1 }  {
			~seq2Dur16.source = Pseq([1/1], 1);
			~tOSCAdrr.sendMsg('shDurPat16', '1/1');
		}
		{ i == 2 }  {
			~seq2Dur16.source = Pseq([2/1], 1);
			~tOSCAdrr.sendMsg('shDurPat16', '2/1');
		}
		{ i == 3 }  {
			~seq2Dur16.source = Pseq([3/1], 1);
			~tOSCAdrr.sendMsg('shDurPat16', '3/1');
		}
		{ i == 4 }  {
			~seq2Dur16.source = Pseq([4/1], 1);
			~tOSCAdrr.sendMsg('shDurPat16', '4/1');
		}
	}
	*stGrp {|i|
		this.st01(i); this.st02(i); this.st03(i); this.st04(i);
		this.st05(i); this.st06(i); this.st07(i); this.st08(i);
		this.st09(i); this.st10(i); this.st11(i); this.st12(i);
		this.st13(i); this.st14(i); this.st15(i); this.st16(i);
	}
	*stGrpSet {|s01,s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16|

		this.st01(s01); this.st02(s02); this.st03(s03); this.st04(s04);
		this.st05(s05); this.st06(s06); this.st07(s07); this.st08(s08);
		this.st09(s09); this.st10(s10); this.st11(s11); this.st12(s12);
		this.st13(s13); this.st14(s14); this.st15(s15); this.st16(s16);
	}
}