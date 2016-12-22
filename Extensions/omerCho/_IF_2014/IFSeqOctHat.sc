IFSeqOctHat {
	*loadAll {

		this.loadProxy;
		this.countReset;

	}

	*loadProxy {

		~seqOctHat01 = PatternProxy( Pseq([1], 1));
		~seqOctHat02 = PatternProxy( Pseq([1], 1));
		~seqOctHat03 = PatternProxy( Pseq([1], 1));
		~seqOctHat04 = PatternProxy( Pseq([1], 1));
		~seqOctHat05 = PatternProxy( Pseq([1], 1));
		~seqOctHat06 = PatternProxy( Pseq([1], 1));
		~seqOctHat07 = PatternProxy( Pseq([1], 1));
		~seqOctHat08 = PatternProxy( Pseq([1], 1));

		~seqOctHat09 = PatternProxy( Pseq([1], 1));
		~seqOctHat10 = PatternProxy( Pseq([1], 1));
		~seqOctHat11 = PatternProxy( Pseq([1], 1));
		~seqOctHat12 = PatternProxy( Pseq([1], 1));
		~seqOctHat13 = PatternProxy( Pseq([1], 1));
		~seqOctHat14 = PatternProxy( Pseq([1], 1));
		~seqOctHat15 = PatternProxy( Pseq([1], 1));
		~seqOctHat16 = PatternProxy( Pseq([1], 1));

	}

	*countReset {
		~cntSeqOctUpHat01=0;
		~cntSeqOctRandHat01=0;

		~cntSeqOctHat01=0;
		~cntSeqOctHat02=0;
		~cntSeqOctHat03=0;
		~cntSeqOctHat04=0;
		~cntSeqOctHat05=0;
		~cntSeqOctHat06=0;
		~cntSeqOctHat07=0;
		~cntSeqOctHat08=0;

		~cntSeqOctHat09=0;
		~cntSeqOctHat10=0;
		~cntSeqOctHat11=0;
		~cntSeqOctHat12=0;
		~cntSeqOctHat13=0;
		~cntSeqOctHat14=0;
		~cntSeqOctHat15=0;
		~cntSeqOctHat16=0;
	}
	*freeOn {
		~seqFreeHatBut.free;
		~seqFreeHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqOctHat.stGrp(0);
				});
			},
			'/seqFreeHat'
		);

	}

	*upOn {
		~ifSeqUpHatBut.free;
		~ifSeqUpHatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctUpHat01 = ~cntSeqOctUpHat01 + 1;
				~cntSeqOctUpHat01.switch(
					0,{},
					1,{IFSeqOctHat.stGrp(0);},
					2,{IFSeqOctHat.stGrp(1);},
					3,{IFSeqOctHat.stGrp(2);},
					4,{IFSeqOctHat.stGrp(3);},
					5,{IFSeqOctHat.stGrp(4);},
					6,{IFSeqOctHat.stGrp(5);},
					7,{IFSeqOctHat.stGrp(6);},
					8,{IFSeqOctHat.stGrp(7);},
					9,{IFSeqOctHat.stGrp(8);},
					10,{IFSeqOctHat.stGrp(9);},
					11,{IFSeqOctHat.stGrp(10);
						~cntSeqOctUpHat01=0;
					}
				)}
			);
			},
			'/seqUpHat'
		);
	}

	*randOn {
		~ifSeqRandHatBut.free;
		~ifSeqRandHatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctRandHat01 = ~cntSeqOctRandHat01 + 1;
				~cntSeqOctRandHat01.switch(
					0,{},
					1,{
						IFSeqOctHat.st01((0..10).choose);
						IFSeqOctHat.st02((0..10).choose);
						IFSeqOctHat.st03((0..10).choose);
						IFSeqOctHat.st04((0..10).choose);
						IFSeqOctHat.st05((0..10).choose);
						IFSeqOctHat.st06((0..10).choose);
						IFSeqOctHat.st07((0..10).choose);
						IFSeqOctHat.st08((0..10).choose);

						IFSeqOctHat.st09((0..10).choose);
						IFSeqOctHat.st10((0..10).choose);
						IFSeqOctHat.st11((0..10).choose);
						IFSeqOctHat.st12((0..10).choose);
						IFSeqOctHat.st13((0..10).choose);
						IFSeqOctHat.st14((0..10).choose);
						IFSeqOctHat.st15((0..10).choose);
						IFSeqOctHat.st16((0..10).choose);
						~cntSeqOctRandHat01=0;
					}
				)}
			);
			},
			'/seqRandHat'
		);
	}

	*on { // Shift OCTAVE
		IFSeqOctHat.randOn;
		IFSeqOctHat.upOn;
		IFSeqOctHat.freeOn;

		~ifSeqHatBut01.free;
		~ifSeqHatBut01= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat01 = ~cntSeqOctHat01 + 1;
				~cntSeqOctHat01.switch(
					0,{},
					1, {IFSeqOctHat.st01(0);},
					2, {IFSeqOctHat.st01(1);},
					3, {IFSeqOctHat.st01(2);},
					4, {IFSeqOctHat.st01(3);},
					5, {IFSeqOctHat.st01(4);},
					6, {IFSeqOctHat.st01(5);},
					7, {IFSeqOctHat.st01(6);},
					8, {IFSeqOctHat.st01(7);},
					9, {IFSeqOctHat.st01(8);},
					10,{IFSeqOctHat.st01(9);},
					11,{IFSeqOctHat.st01(10);
						~cntSeqOctHat01=0;
					}
				)}
			);
			},
			'/ifSeq/3/1'
		);
		~ifSeqHatBut02.free;
		~ifSeqHatBut02= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat02 = ~cntSeqOctHat02 + 1;
				~cntSeqOctHat02.switch(
					0,{},
					1, {IFSeqOctHat.st02(0);},
					2, {IFSeqOctHat.st02(1);},
					3, {IFSeqOctHat.st02(2);},
					4, {IFSeqOctHat.st02(3);},
					5, {IFSeqOctHat.st02(4);},
					6, {IFSeqOctHat.st02(5);},
					7, {IFSeqOctHat.st02(6);},
					8, {IFSeqOctHat.st02(7);},
					9, {IFSeqOctHat.st02(8);},
					10, {IFSeqOctHat.st02(9);},
					11,{
						IFSeqOctHat.st02(10);
						~cntSeqOctHat02=0;
					}
				)}
			);
			},
			'/ifSeq/3/2'
		);
		~ifSeqHatBut03.free;
		~ifSeqHatBut03= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat03 = ~cntSeqOctHat03 + 1;
				~cntSeqOctHat03.switch(
					0,{},
					1, {IFSeqOctHat.st03(0);},
					2, {IFSeqOctHat.st03(1);},
					3, {IFSeqOctHat.st03(2);},
					4, {IFSeqOctHat.st03(3);},
					5, {IFSeqOctHat.st03(4);},
					6, {IFSeqOctHat.st03(5);},
					7, {IFSeqOctHat.st03(6);},
					8, {IFSeqOctHat.st03(7);},
					9, {IFSeqOctHat.st03(8);},
					10, {IFSeqOctHat.st03(9);},
					11,{
						IFSeqOctHat.st03(10);
						~cntSeqOctHat03=0;
					}
				)}
			);
			},
			'/ifSeq/3/3'
		);
		~ifSeqHatBut04.free;
		~ifSeqHatBut04= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat04 = ~cntSeqOctHat04 + 1;
				~cntSeqOctHat04.switch(
					0,{},
					1, {IFSeqOctHat.st04(0);},
					2, {IFSeqOctHat.st04(1);},
					3, {IFSeqOctHat.st04(2);},
					4, {IFSeqOctHat.st04(3);},
					5, {IFSeqOctHat.st04(4);},
					6, {IFSeqOctHat.st04(5);},
					7, {IFSeqOctHat.st04(6);},
					8, {IFSeqOctHat.st04(7);},
					9, {IFSeqOctHat.st04(8);},
					10, {IFSeqOctHat.st04(9);},
					11,{
						IFSeqOctHat.st04(10);
						~cntSeqOctHat04=0;
					}
				)}
			);
			},
			'/ifSeq/3/4'
		);
		~ifSeqHatBut05.free;
		~ifSeqHatBut05= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat05 = ~cntSeqOctHat05 + 1;
				~cntSeqOctHat05.switch(
					0,{},
					1, {IFSeqOctHat.st05(0);},
					2, {IFSeqOctHat.st05(1);},
					3, {IFSeqOctHat.st05(2);},
					4, {IFSeqOctHat.st05(3);},
					5, {IFSeqOctHat.st05(4);},
					6, {IFSeqOctHat.st05(5);},
					7, {IFSeqOctHat.st05(6);},
					8, {IFSeqOctHat.st05(7);},
					9, {IFSeqOctHat.st05(8);},
					10, {IFSeqOctHat.st05(9);},
					11,{
						IFSeqOctHat.st05(10);
						~cntSeqOctHat05=0;
					}
				)}
			);
			},
			'/ifSeq/3/5'
		);
		~ifSeqHatBut06.free;
		~ifSeqHatBut06= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat06 = ~cntSeqOctHat06 + 1;
				~cntSeqOctHat06.switch(
					0,{},
					1, {IFSeqOctHat.st06(0);},
					2, {IFSeqOctHat.st06(1);},
					3, {IFSeqOctHat.st06(2);},
					4, {IFSeqOctHat.st06(3);},
					5, {IFSeqOctHat.st06(4);},
					6, {IFSeqOctHat.st06(5);},
					7, {IFSeqOctHat.st06(6);},
					8, {IFSeqOctHat.st06(7);},
					9, {IFSeqOctHat.st06(8);},
					10, {IFSeqOctHat.st06(9);},
					11,{
						IFSeqOctHat.st06(10);
						~cntSeqOctHat06=0;
					}
				)}
			);
			},
			'/ifSeq/3/6'
		);
		~ifSeqHatBut07.free;
		~ifSeqHatBut07= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat07 = ~cntSeqOctHat07 + 1;
				~cntSeqOctHat07.switch(
					0,{},
					1, {IFSeqOctHat.st07(0);},
					2, {IFSeqOctHat.st07(1);},
					3, {IFSeqOctHat.st07(2);},
					4, {IFSeqOctHat.st07(3);},
					5, {IFSeqOctHat.st07(4);},
					6, {IFSeqOctHat.st07(5);},
					7, {IFSeqOctHat.st07(6);},
					8, {IFSeqOctHat.st07(7);},
					9, {IFSeqOctHat.st07(8);},
					10, {IFSeqOctHat.st07(9);},
					11,{
						IFSeqOctHat.st07(10);
						~cntSeqOctHat07=0;
					}
				)}
			);
			},
			'/ifSeq/3/7'
		);
		~ifSeqHatBut08.free;
		~ifSeqHatBut08= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat08 = ~cntSeqOctHat08 + 1;
				~cntSeqOctHat08.switch(
					0,{},
					1, {IFSeqOctHat.st08(0);},
					2, {IFSeqOctHat.st08(1);},
					3, {IFSeqOctHat.st08(2);},
					4, {IFSeqOctHat.st08(3);},
					5, {IFSeqOctHat.st08(4);},
					6, {IFSeqOctHat.st08(5);},
					7, {IFSeqOctHat.st08(6);},
					8, {IFSeqOctHat.st08(7);},
					9, {IFSeqOctHat.st08(8);},
					10, {IFSeqOctHat.st08(9);},
					11,{
						IFSeqOctHat.st08(10);
						~cntSeqOctHat08=0;
					}
				)}
			);
			},
			'/ifSeq/3/8'
		);
		~ifSeqHatBut09.free;
		~ifSeqHatBut09= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat09 = ~cntSeqOctHat09 + 1;
				~cntSeqOctHat09.switch(
					0,{},
					1, {IFSeqOctHat.st09(0);},
					2, {IFSeqOctHat.st09(1);},
					3, {IFSeqOctHat.st09(2);},
					4, {IFSeqOctHat.st09(3);},
					5, {IFSeqOctHat.st09(4);},
					6, {IFSeqOctHat.st09(5);},
					7, {IFSeqOctHat.st09(6);},
					8, {IFSeqOctHat.st09(7);},
					9, {IFSeqOctHat.st09(8);},
					10, {IFSeqOctHat.st09(9);},
					11,{
						IFSeqOctHat.st09(10);
						~cntSeqOctHat09=0;
					}
				)}
			);
			},
			'/ifSeq/3/9'
		);
		~ifSeqHatBut10.free;
		~ifSeqHatBut10= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat10 = ~cntSeqOctHat10 + 1;
				~cntSeqOctHat10.switch(
					0,{},
					1, {IFSeqOctHat.st10(0);},
					2, {IFSeqOctHat.st10(1);},
					3, {IFSeqOctHat.st10(2);},
					4, {IFSeqOctHat.st10(3);},
					5, {IFSeqOctHat.st10(4);},
					6, {IFSeqOctHat.st10(5);},
					7, {IFSeqOctHat.st10(6);},
					8, {IFSeqOctHat.st10(7);},
					9, {IFSeqOctHat.st10(8);},
					10, {IFSeqOctHat.st10(9);},
					11,{
						IFSeqOctHat.st10(10);
						~cntSeqOctHat10=0;
					}
				)}
			);
			},
			'/ifSeq/3/10'
		);
		~ifSeqHatBut11.free;
		~ifSeqHatBut11= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat11 = ~cntSeqOctHat11 + 1;
				~cntSeqOctHat11.switch(
					0,{},
					1, {IFSeqOctHat.st11(0);},
					2, {IFSeqOctHat.st11(1);},
					3, {IFSeqOctHat.st11(2);},
					4, {IFSeqOctHat.st11(3);},
					5, {IFSeqOctHat.st11(4);},
					6, {IFSeqOctHat.st11(5);},
					7, {IFSeqOctHat.st11(6);},
					8, {IFSeqOctHat.st11(7);},
					9, {IFSeqOctHat.st11(8);},
					10, {IFSeqOctHat.st11(9);},
					11,{
						IFSeqOctHat.st11(10);
						~cntSeqOctHat11=0;
					}
				)}
			);
			},
			'/ifSeq/3/11'
		);
		~ifSeqHatBut12.free;
		~ifSeqHatBut12= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat12 = ~cntSeqOctHat12 + 1;
				~cntSeqOctHat12.switch(
					0,{},
					1, {IFSeqOctHat.st12(0);},
					2, {IFSeqOctHat.st12(1);},
					3, {IFSeqOctHat.st12(2);},
					4, {IFSeqOctHat.st12(3);},
					5, {IFSeqOctHat.st12(4);},
					6, {IFSeqOctHat.st12(5);},
					7, {IFSeqOctHat.st12(6);},
					8, {IFSeqOctHat.st12(7);},
					9, {IFSeqOctHat.st12(8);},
					10, {IFSeqOctHat.st12(9);},
					11,{
						IFSeqOctHat.st12(10);
						~cntSeqOctHat12=0;
					}
				)}
			);
			},
			'/ifSeq/3/12'
		);
		~ifSeqHatBut13.free;
		~ifSeqHatBut13= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat13 = ~cntSeqOctHat13 + 1;
				~cntSeqOctHat13.switch(
					0,{},
					1, {IFSeqOctHat.st13(0);},
					2, {IFSeqOctHat.st13(1);},
					3, {IFSeqOctHat.st13(2);},
					4, {IFSeqOctHat.st13(3);},
					5, {IFSeqOctHat.st13(4);},
					6, {IFSeqOctHat.st13(5);},
					7, {IFSeqOctHat.st13(6);},
					8, {IFSeqOctHat.st13(7);},
					9, {IFSeqOctHat.st13(8);},
					10, {IFSeqOctHat.st13(9);},
					11,{
						IFSeqOctHat.st13(10);
						~cntSeqOctHat13=0;
					}
				)}
			);
			},
			'/ifSeq/3/13'
		);
		~ifSeqHatBut14.free;
		~ifSeqHatBut14= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat14 = ~cntSeqOctHat14 + 1;
				~cntSeqOctHat14.switch(
					0,{},
					1, {IFSeqOctHat.st14(0);},
					2, {IFSeqOctHat.st14(1);},
					3, {IFSeqOctHat.st14(2);},
					4, {IFSeqOctHat.st14(3);},
					5, {IFSeqOctHat.st14(4);},
					6, {IFSeqOctHat.st14(5);},
					7, {IFSeqOctHat.st14(6);},
					8, {IFSeqOctHat.st14(7);},
					9, {IFSeqOctHat.st14(8);},
					10, {IFSeqOctHat.st14(9);},
					11,{
						IFSeqOctHat.st14(10);
						~cntSeqOctHat14=0;
					}
				)}
			);
			},
			'/ifSeq/3/14'
		);
		~ifSeqHatBut15.free;
		~ifSeqHatBut15= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat15 = ~cntSeqOctHat15 + 1;
				~cntSeqOctHat15.switch(
					0,{},
					1, {IFSeqOctHat.st15(0);},
					2, {IFSeqOctHat.st15(1);},
					3, {IFSeqOctHat.st15(2);},
					4, {IFSeqOctHat.st15(3);},
					5, {IFSeqOctHat.st15(4);},
					6, {IFSeqOctHat.st15(5);},
					7, {IFSeqOctHat.st15(6);},
					8, {IFSeqOctHat.st15(7);},
					9, {IFSeqOctHat.st15(8);},
					10, {IFSeqOctHat.st15(9);},
					11,{
						IFSeqOctHat.st15(10);
						~cntSeqOctHat15=0;
					}
				)}
			);
			},
			'/ifSeq/3/15'
		);
		~ifSeqHatBut16.free;
		~ifSeqHatBut16= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~cntSeqOctHat16 = ~cntSeqOctHat16 + 1;
				~cntSeqOctHat16.switch(
					0,{},
					1, {IFSeqOctHat.st16(0);},
					2, {IFSeqOctHat.st16(1);},
					3, {IFSeqOctHat.st16(2);},
					4, {IFSeqOctHat.st16(3);},
					5, {IFSeqOctHat.st16(4);},
					6, {IFSeqOctHat.st16(5);},
					7, {IFSeqOctHat.st16(6);},
					8, {IFSeqOctHat.st16(7);},
					9, {IFSeqOctHat.st16(8);},
					10, {IFSeqOctHat.st16(9);},
					11,{
						IFSeqOctHat.st16(10);
						~cntSeqOctHat16=0;
					}
				)}
			);
			},
			'/ifSeq/3/16'
		);

	}//

	*st01 {|i=0|
		~seqOctHat01.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat01', i);
	}
	*st02 {|i=0|
		~seqOctHat02.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat02', i);
	}
	*st03 {|i=0|
		~seqOctHat03.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat03', i);
	}
	*st04 {|i=0|
		~seqOctHat04.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat04', i);
	}
	*st05 {|i=0|
		~seqOctHat05.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat05', i);
	}
	*st06 {|i=0|
		~seqOctHat06.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat06', i);
	}
	*st07 {|i=0|
		~seqOctHat07.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat07', i);
	}
	*st08 {|i=0|
		~seqOctHat08.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat08', i);
	}
	*st09 {|i=0|
		~seqOctHat09.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat09', i);
	}
	*st10 {|i=0|
		~seqOctHat10.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat10', i);
	}
	*st11 {|i=0|
		~seqOctHat11.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat11', i);
	}
	*st12 {|i=0|
		~seqOctHat12.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat12', i);
	}
	*st13 {|i=0|
		~seqOctHat13.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat13', i);
	}
	*st14 {|i=0|
		~seqOctHat14.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat14', i);
	}
	*st15 {|i=0|
		~seqOctHat15.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat15', i);
	}
	*st16 {|i=0|
		~seqOctHat16.source = Pseq([i], 1);
		~tOSCAdrr.sendMsg('shOctHat16', i);
	}
	*stGrp {|i|

		IFSeqOctHat.st01(i); IFSeqOctHat.st02(i); IFSeqOctHat.st03(i); IFSeqOctHat.st04(i);
		IFSeqOctHat.st05(i); IFSeqOctHat.st06(i); IFSeqOctHat.st07(i); IFSeqOctHat.st08(i);
		IFSeqOctHat.st09(i); IFSeqOctHat.st10(i); IFSeqOctHat.st11(i); IFSeqOctHat.st12(i);
		IFSeqOctHat.st13(i); IFSeqOctHat.st14(i); IFSeqOctHat.st15(i); IFSeqOctHat.st16(i);
	}
}