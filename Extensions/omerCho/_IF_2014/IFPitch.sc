/*
 IFPitch.loadAll;
*/

IFPitch {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
				1.0.wait;

				this.note;
				this.noteBass;
				this.noteKeys;
				this.noteSamp;
				this.oct;
				this.trans;


			});*/
		}
	}

	*loadAll {

		this.note;
		this.noteBass;
		this.noteKeys;
		this.noteSamp;
		this.trans;
	}



	*note {

		/////////////////////----- Note -------//////////////

		//~transKick.source = PatternProxy( Pseq([0], inf));
		//~transKick.sourceP= Pseq([~transKick.source], inf).asStream;




		~noteFader.free;
		~noteFader= OSCFunc({
			arg msg;

			//~transKick.source= msg[1]+Pseq([0], inf);
			//~transSnr.source=msg[1]+Pseq([0], inf);
			//~transHat.source=msg[1]+Pseq([0], inf);

			~tOSCAdrr.sendMsg('noteLabelDrum', msg[1]);
			},
			'/noteFader'
		);


		~note_0.free;
		~note_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 0".postln;
				~transKick.source=0;~transSnr.source=0;~transHat.source=0;
				~transBass.source=0;~transKeys.source=0;~transSamp.source=0;
				~transExt.source=0;
				~tOSCAdrr.sendMsg('noteLabel', '0');
			});
			},
			'/nt_0'
		);

		~note_1.free;
		~note_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 1".postln;
				//~transKick.source=1;//~transSnr.source=1;~transHat.source=1;
				~transBass.source=1;~transKeys.source=1;~transSamp.source=1;
				~transExt.source=1;
				~tOSCAdrr.sendMsg('noteLabel', '1');
			});
			},
			'/nt_1'
		);


		~note_2.free;
		~note_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 2".postln;
				//~transKick.source=2;//~transSnr.source=2;~transHat.source=2;
				~transBass.source=2;~transKeys.source=2;~transSamp.source=2;
				~transExt.source=2;
				~tOSCAdrr.sendMsg('noteLabel', '2');
			});
			},
			'/nt_2'
		);

		~note_3.free;
		~note_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 3".postln;
				//~transKick.source=3;//~transSnr.source=3;~transHat.source=3;
				~transBass.source=3;~transKeys.source=3;~transSamp.source=3;
				~transExt.source=3;
				~tOSCAdrr.sendMsg('noteLabel', '3');
			});
			},
			'/nt_3'
		);

		~note_4.free;
		~note_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 4".postln;
				//~transKick.source=4;//~transSnr.source=4;~transHat.source=4;
				~transBass.source=4;~transKeys.source=4;~transSamp.source=4;
				~transExt.source=4;
				~tOSCAdrr.sendMsg('noteLabel', '4');
			});
			},
			'/nt_4'
		);

		~note_5.free;
		~note_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 5".postln;
				//~transKick.source=5;//~transSnr.source=5;~transHat.source=5;
				~transBass.source=5;~transKeys.source=5;~transSamp.source=5;
				~transExt.source=5;
				~tOSCAdrr.sendMsg('noteLabel', '5');
			});
			},
			'/nt_5'
		);

		~note_6.free;
		~note_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 6".postln;
				//~transKick.source=6;//~transSnr.source=6;~transHat.source=6;
				~transBass.source=6;~transKeys.source=6;~transSamp.source=6;
				~transExt.source=6;
				~tOSCAdrr.sendMsg('noteLabel', '6');
			});
			},
			'/nt_6'
		);

		~note_7.free;
		~note_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 7".postln;
				//~transKick.source=7;//~transSnr.source=7;~transHat.source=7;
				~transBass.source=7;~transKeys.source=7;~transSamp.source=7;
				~transExt.source=7;
				~tOSCAdrr.sendMsg('noteLabel', '7');
			});
			},
			'/nt_7'
		);

		~note_8.free;
		~note_8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 8".postln;
				//~transKick.source=8;//~transSnr.source=8;~transHat.source=8;
				~transBass.source=8;~transKeys.source=8;~transSamp.source=8;
				~transExt.source=8;
				~tOSCAdrr.sendMsg('noteLabel', '8');
			});
			},
			'/nt_8'
		);

		~note_9.free;
		~note_9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 9".postln;
				//~transKick.source=9;//~transSnr.source=9;~transHat.source=9;
				~transBass.source=9;~transKeys.source=9;~transSamp.source=9;
				~transExt.source=9;
				~tOSCAdrr.sendMsg('noteLabel', '9');
			});
			},
			'/nt_9'
		);

		~note_10.free;
		~note_10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 10".postln;
				//~transKick.source=10;//~transSnr.source=10;~transHat.source=10;
				~transBass.source=10;~transKeys.source=10;~transSamp.source=10;
				~transExt.source=10;
				~tOSCAdrr.sendMsg('noteLabel', '10');
			});
			},
			'/nt_10'
		);

		~note_11.free;
		~note_11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 11".postln;
				//~transKick.source=11;//~transSnr.source=11;~transHat.source=11;
				~transBass.source=11;~transKeys.source=11;~transSamp.source=11;
				~transExt.source=11;
				~tOSCAdrr.sendMsg('noteLabel', '11');
			});
			},
			'/nt_11'
		);

		~note_12.free;
		~note_12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 12".postln;
				//~transKick.source=12;//~transSnr.source=12;~transHat.source=12;
				~transBass.source=12;~transKeys.source=12;~transSamp.source=12;
				~transExt.source=12;
				~tOSCAdrr.sendMsg('noteLabel', '12');
			});
			},
			'/nt_12'
		);

		~note_13.free;
		~note_13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 13".postln;
				//~transKick.source=13;//~transSnr.source=13;~transHat.source=13;
				~transBass.source=13;~transKeys.source=13;~transSamp.source=13;
				~transExt.source=13;
				~tOSCAdrr.sendMsg('noteLabel', '13');
			});
			},
			'/nt_13'
		);

		~note_14.free;
		~note_14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 14".postln;
				//~transKick.source=14;//~transSnr.source=14;~transHat.source=14;
				~transBass.source=14;~transKeys.source=14;~transSamp.source=14;
				~transExt.source=14;
				~tOSCAdrr.sendMsg('noteLabel', '14');
			});
			},
			'/nt_14'
		);

		//////////////////////////// NEGATIVE
		~note1.free;
		~note1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -1".postln;
				//~transKick.source=(-1);//~transSnr.source=(-1);~transHat.source=(-1);
				~transBass.source=(-1);~transKeys.source=(-1);~transSamp.source=(-1);
				~transExt.source=(-1);
				~tOSCAdrr.sendMsg('noteLabel', '-1');
			});
			},
			'/nt-1'
		);


		~note2.free;
		~note2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -2".postln;
				//~transKick.source=(-2);//~transSnr.source=(-2);~transHat.source=(-2);
				~transBass.source=(-2);~transKeys.source=(-2);~transSamp.source=(-2);
				~transExt.source=(-2);
				~tOSCAdrr.sendMsg('noteLabel', '-2');
			});
			},
			'/nt-2'
		);

		~note3.free;
		~note3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -3".postln;
				//~transKick.source=(-3);//~transSnr.source=(-3);~transHat.source=(-3);
				~transBass.source=(-3);~transKeys.source=(-3);~transSamp.source=(-3);
				~transExt.source=(-3);
				~tOSCAdrr.sendMsg('noteLabel', '-3');
			});
			},
			'/nt-3'
		);

		~note4.free;
		~note4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -4".postln;
				//~transKick.source=(-4);//~transSnr.source=(-4);~transHat.source=(-4);
				~transBass.source=(-4);~transKeys.source=(-4);~transSamp.source=(-4);
				~transExt.source=(-4);
				~tOSCAdrr.sendMsg('noteLabel', '-4');
			});
			},
			'/nt-4'
		);

		~note5.free;
		~note5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -5".postln;
				//~transKick.source=(-5);//~transSnr.source=(-5);~transHat.source=(-5);
				~transBass.source=(-5);~transKeys.source=(-5);~transSamp.source=(-5);
				~transExt.source=(-5);
				~tOSCAdrr.sendMsg('noteLabel', '-5');
			});
			},
			'/nt-5'
		);

		~note6.free;
		~note6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -6".postln;
				//~transKick.source=(-6);//~transSnr.source=(-6);~transHat.source=(-6);
				~transBass.source=(-6);~transKeys.source=(-6);~transSamp.source=(-6);
				~transExt.source=(-6);
				~tOSCAdrr.sendMsg('noteLabel', '-6');
			});
			},
			'/nt-6'
		);

		~note7.free;
		~note7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -7".postln;
				//~transKick.source=(-7);//~transSnr.source=(-7);~transHat.source=(-7);
				~transBass.source=(-7);~transKeys.source=(-7);~transSamp.source=(-7);
				~transExt.source=(-7);
				~tOSCAdrr.sendMsg('noteLabel', '-7');
			});
			},
			'/nt-7'
		);

		~note8.free;
		~note8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -8".postln;
				//~transKick.source=(-8);//~transSnr.source=(-8);~transHat.source=(-8);
				~transBass.source=(-8);~transKeys.source=(-8);~transSamp.source=(-8);
				~transExt.source=(-8);
				~tOSCAdrr.sendMsg('noteLabel', '-8');
			});
			},
			'/nt-8'
		);

		~note9.free;
		~note9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -9".postln;
				//~transKick.source=(-9);//~transSnr.source=(-9);~transHat.source=(-9);
				~transBass.source=(-9);~transKeys.source=(-9);~transSamp.source=(-9);
				~transExt.source=(-9);
				~tOSCAdrr.sendMsg('noteLabel', '-9');
			});
			},
			'/nt-9'
		);

		~note10.free;
		~note10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -10".postln;
				//~transKick.source=(-10);//~transSnr.source=(-10);~transHat.source=(-10);
				~transBass.source=(-10);~transKeys.source=(-10);~transSamp.source=(-10);
				~transExt.source=(-10);
				~tOSCAdrr.sendMsg('noteLabel', '-10');
			});
			},
			'/nt-10'
		);

		~note11.free;
		~note11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -11".postln;
				//~transKick.source=(-11);//~transSnr.source=(-11);~transHat.source=(-11);
				~transBass.source=(-11);~transKeys.source=(-11);~transSamp.source=(-11);
				~transExt.source=(-11);
				~tOSCAdrr.sendMsg('noteLabel', '-11');
			});
			},
			'/nt-11'
		);

		~note12.free;
		~note12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -12".postln;
				//~transKick.source=(-12);//~transSnr.source=(-12);~transHat.source=(-12);
				~transBass.source=(-12);~transKeys.source=(-12);~transSamp.source=(-12);
				~transExt.source=(-12);
				~tOSCAdrr.sendMsg('noteLabel', '-12');
			});
			},
			'/nt-12'
		);

		~note13.free;
		~note13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -13".postln;
				//~transKick.source=(-13);//~transSnr.source=(-13);~transHat.source=(-13);
				~transBass.source=(-13);~transKeys.source=(-13);~transSamp.source=(-13);
				~transExt.source=(-13);
				~tOSCAdrr.sendMsg('noteLabel', '-13');
			});
			},
			'/nt-13'
		);

		~note14.free;
		~note14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -14".postln;
				//~transKick.source=(-14);//~transSnr.source=(-14);~transHat.source=(-14);
				~transBass.source=(-14);~transKeys.source=(-14);~transSamp.source=(-14);
				~transExt.source=(-14);
				~tOSCAdrr.sendMsg('noteLabel', '-14');
			});
			},
			'/nt-14'
		);



	}



	*trans {

		//----Kick-------
		~transKickMulBut.free;
		~transKickMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trKick = ~trKick+1;
				~tOSCAdrr.sendMsg('transKickLabel', ~trKick);

			});

			},
			'/transKickMul'
		);

		~transKickZeroBut.free;
		~transKickZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trKick = 0;
				~tOSCAdrr.sendMsg('transKickLabel', ~trKick);

			});

			},
			'/transKickZero'
		);

		~transKickDivBut.free;
		~transKickDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trKick = ~trKick-1;
				~tOSCAdrr.sendMsg('transKickLabel', ~trKick);

			});

			},
			'/transKickDiv'
		);

		//----Snr-------
		~transSnrMulBut.free;
		~transSnrMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trSnr = ~trSnr+1;
				~tOSCAdrr.sendMsg('transSnrLabel', ~trSnr);

			});

			},
			'/transSnrMul'
		);

		~transSnrZeroBut.free;
		~transSnrZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trSnr = 0;
				~tOSCAdrr.sendMsg('transSnrLabel', ~trSnr);

			});

			},
			'/transSnrZero'
		);

		~transSnrDivBut.free;
		~transSnrDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trSnr = ~trSnr-1;
				~tOSCAdrr.sendMsg('transSnrLabel', ~trSnr);

			});

			},
			'/transSnrDiv'
		);

		//----Hat-------
		~transHatMulBut.free;
		~transHatMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trHat = ~trHat+1;
				~tOSCAdrr.sendMsg('transHatLabel', ~trHat);

			});

			},
			'/transHatMul'
		);

		~transHatZeroBut.free;
		~transHatZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trHat = 0;
				~tOSCAdrr.sendMsg('transHatLabel', ~trHat);

			});

			},
			'/transHatZero'
		);

		~transHatDivBut.free;
		~transHatDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trHat = ~trHat-1;
				~tOSCAdrr.sendMsg('transHatLabel', ~trHat);

			});

			},
			'/transHatDiv'
		);

		//----Keys-------
		~transKeysMulBut.free;
		~transKeysMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trKeys = ~trKeys+1;
				~tOSCAdrr.sendMsg('transKeysLabel', ~trKeys);

			});

			},
			'/transKeysMul'
		);

		~transKeysZeroBut.free;
		~transKeysZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trKeys = 0;
				~tOSCAdrr.sendMsg('transKeysLabel', ~trKeys);

			});

			},
			'/transKeysZero'
		);

		~transKeysDivBut.free;
		~transKeysDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trKeys = ~trKeys-1;
				~tOSCAdrr.sendMsg('transKeysLabel', ~trKeys);

			});

			},
			'/transKeysDiv'
		);

		//----Bass-------
		~transBassMulBut.free;
		~transBassMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trBass = ~trBass+1;
				~tOSCAdrr.sendMsg('transBassLabel', ~trBass);

			});

			},
			'/transBassMul'
		);

		~transBassZeroBut.free;
		~transBassZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trBass = 0;
				~tOSCAdrr.sendMsg('transBassLabel', ~trBass);

			});

			},
			'/transBassZero'
		);

		~transBassDivBut.free;
		~transBassDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trBass = ~trBass-1;
				~tOSCAdrr.sendMsg('transBassLabel', ~trBass);

			});

			},
			'/transBassDiv'
		);

		//----Samp-------
		~transSampMulBut.free;
		~transSampMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trSamp = ~trSamp+1;
				~tOSCAdrr.sendMsg('transSampLabel', ~trSamp);

			});

			},
			'/transSampMul'
		);

		~transSampZeroBut.free;
		~transSampZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trSamp = 0;
				~tOSCAdrr.sendMsg('transSampLabel', ~trSamp);

			});

			},
			'/transSampZero'
		);

		~transSampDivBut.free;
		~transSampDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trSamp = ~trSamp-1;
				~tOSCAdrr.sendMsg('transSampLabel', ~trSamp);

			});

			},
			'/transSampDiv'
		);


	}

	*noteBass {

		/////////////////////----- Note -------//////////////


		~noteBass_0.free;
		~noteBass_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Bass NOTE 0".postln;
				~transBass.source=0;
				~tOSCAdrr.sendMsg('noteBassLabel', '0');
			});
			},
			'/ntBass_0'
		);

		~noteBass_1.free;
		~noteBass_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 1".postln;
				//~transKick.source=1;~transSnr.source=1;~transHat.source=1;
				~transBass.source=1;
				~tOSCAdrr.sendMsg('noteBassLabel', '1');
			});
			},
			'/ntBass_1'
		);


		~noteBass_2.free;
		~noteBass_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 2".postln;
				//~transKick.source=2;~transSnr.source=2;~transHat.source=2;
				~transBass.source=2;
				~tOSCAdrr.sendMsg('noteBassLabel', '2');
			});
			},
			'/ntBass_2'
		);

		~noteBass_3.free;
		~noteBass_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 3".postln;
				//~transKick.source=3;~transSnr.source=3;~transHat.source=3;
				~transBass.source=3;
				~tOSCAdrr.sendMsg('noteBassLabel', '3');
			});
			},
			'/ntBass_3'
		);

		~noteBass_4.free;
		~noteBass_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 4".postln;
				//~transKick.source=4;~transSnr.source=4;~transHat.source=4;
				~transBass.source=4;
				~tOSCAdrr.sendMsg('noteBassLabel', '4');
			});
			},
			'/ntBass_4'
		);

		~noteBass_5.free;
		~noteBass_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 5".postln;
				//~transKick.source=5;~transSnr.source=5;~transHat.source=5;
				~transBass.source=5;
				~tOSCAdrr.sendMsg('noteBassLabel', '5');
			});
			},
			'/ntBass_5'
		);

		~noteBass_6.free;
		~noteBass_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 6".postln;
				//~transKick.source=6;~transSnr.source=6;~transHat.source=6;
				~transBass.source=6;
				~tOSCAdrr.sendMsg('noteBassLabel', '6');
			});
			},
			'/ntBass_6'
		);

		~noteBass_7.free;
		~noteBass_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 7".postln;
				//~transKick.source=7;~transSnr.source=7;~transHat.source=7;
				~transBass.source=7;
				~tOSCAdrr.sendMsg('noteBassLabel', '7');
			});
			},
			'/ntBass_7'
		);

		~noteBass_8.free;
		~noteBass_8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 8".postln;
				//~transKick.source=8;~transSnr.source=8;~transHat.source=8;
				~transBass.source=8;
				~tOSCAdrr.sendMsg('noteBassLabel', '8');
			});
			},
			'/ntBass_8'
		);

		~noteBass_9.free;
		~noteBass_9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 9".postln;
				//~transKick.source=9;~transSnr.source=9;~transHat.source=9;
				~transBass.source=9;
				~tOSCAdrr.sendMsg('noteBassLabel', '9');
			});
			},
			'/ntBass_9'
		);

		~noteBass_10.free;
		~noteBass_10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 10".postln;
				//~transKick.source=10;~transSnr.source=10;~transHat.source=10;
				~transBass.source=10;
				~tOSCAdrr.sendMsg('noteBassLabel', '10');
			});
			},
			'/ntBass_10'
		);

		~noteBass_11.free;
		~noteBass_11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 11".postln;
				//~transKick.source=11;~transSnr.source=11;~transHat.source=11;
				~transBass.source=11;
				~tOSCAdrr.sendMsg('noteBassLabel', '11');
			});
			},
			'/ntBass_11'
		);

		~noteBass_12.free;
		~noteBass_12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 12".postln;
				//~transKick.source=12;~transSnr.source=12;~transHat.source=12;
				~transBass.source=12;
				~tOSCAdrr.sendMsg('noteBassLabel', '12');
			});
			},
			'/ntBass_12'
		);

		~noteBass_13.free;
		~noteBass_13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 13".postln;
				//~transKick.source=13;~transSnr.source=13;~transHat.source=13;
				~transBass.source=13;
				~tOSCAdrr.sendMsg('noteBassLabel', '13');
			});
			},
			'/ntBass_13'
		);

		~noteBass_14.free;
		~noteBass_14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 14".postln;
				//~transKick.source=14;~transSnr.source=14;~transHat.source=14;
				~transBass.source=14;
				~tOSCAdrr.sendMsg('noteBassLabel', '14');
			});
			},
			'/ntBass_14'
		);

		//////////////////////////// NEGATIVE
		~noteBass1.free;
		~noteBass1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -1".postln;
				//~transKick.source=(-1);~transSnr.source=(-1);~transHat.source=(-1);
				~transBass.source=(-1);
				~tOSCAdrr.sendMsg('noteBassLabel', '-1');
			});
			},
			'/ntBass-1'
		);


		~noteBass2.free;
		~noteBass2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -2".postln;
				//~transKick.source=(-2);~transSnr.source=(-2);~transHat.source=(-2);
				~transBass.source=(-2);
				~tOSCAdrr.sendMsg('noteBassLabel', '-2');
			});
			},
			'/ntBass-2'
		);

		~noteBass3.free;
		~noteBass3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -3".postln;
				//~transKick.source=(-3);~transSnr.source=(-3);~transHat.source=(-3);
				~transBass.source=(-3);
				~tOSCAdrr.sendMsg('noteBassLabel', '-3');
			});
			},
			'/ntBass-3'
		);

		~noteBass4.free;
		~noteBass4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -4".postln;
				//~transKick.source=(-4);~transSnr.source=(-4);~transHat.source=(-4);
				~transBass.source=(-4);
				~tOSCAdrr.sendMsg('noteBassLabel', '-4');
			});
			},
			'/ntBass-4'
		);

		~noteBass5.free;
		~noteBass5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -5".postln;
				//~transKick.source=(-5);~transSnr.source=(-5);~transHat.source=(-5);
				~transBass.source=(-5);
				~tOSCAdrr.sendMsg('noteBassLabel', '-5');
			});
			},
			'/ntBass-5'
		);

		~noteBass6.free;
		~noteBass6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -6".postln;
				//~transKick.source=(-6);~transSnr.source=(-6);~transHat.source=(-6);
				~transBass.source=(-6);
				~tOSCAdrr.sendMsg('noteBassLabel', '-6');
			});
			},
			'/ntBass-6'
		);

		~noteBass7.free;
		~noteBass7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -7".postln;
				//~transKick.source=(-7);~transSnr.source=(-7);~transHat.source=(-7);
				~transBass.source=(-7);
				~tOSCAdrr.sendMsg('noteBassLabel', '-7');
			});
			},
			'/ntBass-7'
		);

		~noteBass8.free;
		~noteBass8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -8".postln;
				//~transKick.source=(-8);~transSnr.source=(-8);~transHat.source=(-8);
				~transBass.source=(-8);
				~tOSCAdrr.sendMsg('noteBassLabel', '-8');
			});
			},
			'/ntBass-8'
		);

		~noteBass9.free;
		~noteBass9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -9".postln;
				//~transKick.source=(-9);~transSnr.source=(-9);~transHat.source=(-9);
				~transBass.source=(-9);
				~tOSCAdrr.sendMsg('noteBassLabel', '-9');
			});
			},
			'/ntBass-9'
		);

		~noteBass10.free;
		~noteBass10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -10".postln;
				//~transKick.source=(-10);~transSnr.source=(-10);~transHat.source=(-10);
				~transBass.source=(-10);
				~tOSCAdrr.sendMsg('noteBassLabel', '-10');
			});
			},
			'/ntBass-10'
		);

		~noteBass11.free;
		~noteBass11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -11".postln;
				//~transKick.source=(-11);~transSnr.source=(-11);~transHat.source=(-11);
				~transBass.source=(-11);
				~tOSCAdrr.sendMsg('noteBassLabel', '-11');
			});
			},
			'/ntBass-11'
		);

		~noteBass12.free;
		~noteBass12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -12".postln;
				//~transKick.source=(-12);~transSnr.source=(-12);~transHat.source=(-12);
				~transBass.source=(-12);
				~tOSCAdrr.sendMsg('noteBassLabel', '-12');
			});
			},
			'/ntBass-12'
		);

		~noteBass13.free;
		~noteBass13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -13".postln;
				//~transKick.source=(-13);~transSnr.source=(-13);~transHat.source=(-13);
				~transBass.source=(-13);
				~tOSCAdrr.sendMsg('noteBassLabel', '-13');
			});
			},
			'/ntBass-13'
		);

		~noteBass14.free;
		~noteBass14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -14".postln;
				//~transKick.source=(-14);~transSnr.source=(-14);~transHat.source=(-14);
				~transBass.source=(-14);
				~tOSCAdrr.sendMsg('noteBassLabel', '-14');
			});
			},
			'/ntBass-14'
		);



	}

	*noteKeys {

		/////////////////////----- Note -------//////////////


		~noteKeys_0.free;
		~noteKeys_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 0".postln;

				~transKeys.source=0;
				~tOSCAdrr.sendMsg('noteKeysLabel', '0');
			});
			},
			'/ntKeys_0'
		);

		~noteKeys_1.free;
		~noteKeys_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 1".postln;

				~transKeys.source=1;
				~tOSCAdrr.sendMsg('noteKeysLabel', '1');
			});
			},
			'/ntKeys_1'
		);


		~noteKeys_2.free;
		~noteKeys_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 2".postln;

			~transKeys.source=2;
				~tOSCAdrr.sendMsg('noteKeysLabel', '2');
			});
			},
			'/ntKeys_2'
		);

		~noteKeys_3.free;
		~noteKeys_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 3".postln;
				//~transKick.source=3;~transSnr.source=3;~transHat.source=3;
				~transKeys.source=3;
				~tOSCAdrr.sendMsg('noteKeysLabel', '3');
			});
			},
			'/ntKeys_3'
		);

		~noteKeys_4.free;
		~noteKeys_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 4".postln;

				~transKeys.source=4;
				~tOSCAdrr.sendMsg('noteKeysLabel', '4');
			});
			},
			'/ntKeys_4'
		);

		~noteKeys_5.free;
		~noteKeys_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 5".postln;

				~transKeys.source=5;
				~tOSCAdrr.sendMsg('noteKeysLabel', '5');
			});
			},
			'/ntKeys_5'
		);

		~noteKeys_6.free;
		~noteKeys_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 6".postln;

				~transKeys.source=6;
				~tOSCAdrr.sendMsg('noteKeysLabel', '6');
			});
			},
			'/ntKeys_6'
		);

		~noteKeys_7.free;
		~noteKeys_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 7".postln;
				//~transKick.source=7;~transSnr.source=7;~transHat.source=7;
				~transKeys.source=7;
				~tOSCAdrr.sendMsg('noteKeysLabel', '7');
			});
			},
			'/ntKeys_7'
		);

		~noteKeys_8.free;
		~noteKeys_8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 8".postln;
				//~transKick.source=8;~transSnr.source=8;~transHat.source=8;
				~transKeys.source=8;
				~tOSCAdrr.sendMsg('noteKeysLabel', '8');
			});
			},
			'/ntKeys_8'
		);

		~noteKeys_9.free;
		~noteKeys_9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 9".postln;
				//~transKick.source=9;~transSnr.source=9;~transHat.source=9;
				~transKeys.source=9;
				~tOSCAdrr.sendMsg('noteKeysLabel', '9');
			});
			},
			'/ntKeys_9'
		);

		~noteKeys_10.free;
		~noteKeys_10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 10".postln;
				//~transKick.source=10;~transSnr.source=10;~transHat.source=10;
				~transKeys.source=10;
				~tOSCAdrr.sendMsg('noteKeysLabel', '10');
			});
			},
			'/ntKeys_10'
		);

		~noteKeys_11.free;
		~noteKeys_11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 11".postln;
				//~transKick.source=11;~transSnr.source=11;~transHat.source=11;
				~transKeys.source=11;
				~tOSCAdrr.sendMsg('noteKeysLabel', '11');
			});
			},
			'/ntKeys_11'
		);

		~noteKeys_12.free;
		~noteKeys_12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 12".postln;
				//~transKick.source=12;~transSnr.source=12;~transHat.source=12;
				~transKeys.source=12;
				~tOSCAdrr.sendMsg('noteKeysLabel', '12');
			});
			},
			'/ntKeys_12'
		);

		~noteKeys_13.free;
		~noteKeys_13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 13".postln;
				//~transKick.source=13;~transSnr.source=13;~transHat.source=13;
				~transKeys.source=13;
				~tOSCAdrr.sendMsg('noteKeysLabel', '13');
			});
			},
			'/ntKeys_13'
		);

		~noteKeys_14.free;
		~noteKeys_14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 14".postln;
				//~transKick.source=14;~transSnr.source=14;~transHat.source=14;
				~transKeys.source=14;
				~tOSCAdrr.sendMsg('noteKeysLabel', '14');
			});
			},
			'/ntKeys_14'
		);

		//////////////////////////// NEGATIVE
		~noteKeys1.free;
		~noteKeys1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -1".postln;
				//~transKick.source=(-1);~transSnr.source=(-1);~transHat.source=(-1);
				~transKeys.source=(-1);
				~tOSCAdrr.sendMsg('noteKeysLabel', '-1');
			});
			},
			'/ntKeys-1'
		);


		~noteKeys2.free;
		~noteKeys2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -2".postln;
				//~transKick.source=(-2);~transSnr.source=(-2);~transHat.source=(-2);
				~transKeys.source=(-2);
				~tOSCAdrr.sendMsg('noteKeysLabel', '-2');
			});
			},
			'/ntKeys-2'
		);

		~noteKeys3.free;
		~noteKeys3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -3".postln;
				//~transKick.source=(-3);~transSnr.source=(-3);~transHat.source=(-3);
				~transKeys.source=(-3);
				~tOSCAdrr.sendMsg('noteKeysLabel', '-3');
			});
			},
			'/ntKeys-3'
		);

		~noteKeys4.free;
		~noteKeys4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -4".postln;
				//~transKick.source=(-4);~transSnr.source=(-4);~transHat.source=(-4);
				~transKeys.source=(-4);
				~tOSCAdrr.sendMsg('noteKeysLabel', '-4');
			});
			},
			'/ntKeys-4'
		);

		~noteKeys5.free;
		~noteKeys5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -5".postln;
				//~transKick.source=(-5);~transSnr.source=(-5);~transHat.source=(-5);
				~transKeys.source=(-5);
			});
			},
			'/ntKeys-5'
		);

		~noteKeys6.free;
		~noteKeys6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -6".postln;
				//~transKick.source=(-6);~transSnr.source=(-6);~transHat.source=(-6);
				~transKeys.source=(-6);
				~tOSCAdrr.sendMsg('noteKeysLabel', '-6');
			});
			},
			'/ntKeys-6'
		);

		~noteKeys7.free;
		~noteKeys7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -7".postln;
				//~transKick.source=(-7);~transSnr.source=(-7);~transHat.source=(-7);
				~transKeys.source=(-7);
				~tOSCAdrr.sendMsg('noteKeysLabel', '-7');
			});
			},
			'/ntKeys-7'
		);

		~noteKeys8.free;
		~noteKeys8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -8".postln;
				//~transKick.source=(-8);~transSnr.source=(-8);~transHat.source=(-8);
				~transKeys.source=(-8);
				~tOSCAdrr.sendMsg('noteKeysLabel', '-8');
			});
			},
			'/ntKeys-8'
		);

		~noteKeys9.free;
		~noteKeys9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -9".postln;
				//~transKick.source=(-9);~transSnr.source=(-9);~transHat.source=(-9);
				~transKeys.source=(-9);
				~tOSCAdrr.sendMsg('noteKeysLabel', '-9');
			});
			},
			'/ntKeys-9'
		);

		~noteKeys10.free;
		~noteKeys10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -10".postln;
				//~transKick.source=(-10);~transSnr.source=(-10);~transHat.source=(-10);
				~transKeys.source=(-10);
				~tOSCAdrr.sendMsg('noteKeysLabel', '-10');
			});
			},
			'/ntKeys-10'
		);

		~noteKeys11.free;
		~noteKeys11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -11".postln;
				//~transKick.source=(-11);~transSnr.source=(-11);~transHat.source=(-11);
				~transKeys.source=(-11);
				~tOSCAdrr.sendMsg('noteKeysLabel', '-11');
			});
			},
			'/ntKeys-11'
		);

		~noteKeys12.free;
		~noteKeys12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -12".postln;
				//~transKick.source=(-12);~transSnr.source=(-12);~transHat.source=(-12);
				~transKeys.source=(-12);
				~tOSCAdrr.sendMsg('noteKeysLabel', '-12');
			});
			},
			'/ntKeys-12'
		);

		~noteKeys13.free;
		~noteKeys13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -13".postln;
				//~transKick.source=(-13);~transSnr.source=(-13);~transHat.source=(-13);
				~transKeys.source=(-13);
				~tOSCAdrr.sendMsg('noteKeysLabel', '-13');
			});
			},
			'/ntKeys-13'
		);

		~noteKeys14.free;
		~noteKeys14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -14".postln;
				//~transKick.source=(-14);~transSnr.source=(-14);~transHat.source=(-14);
				~transKeys.source=(-14);
				~tOSCAdrr.sendMsg('noteKeysLabel', '-14');
			});
			},
			'/ntKeys-14'
		);



	}

	*noteSamp {

		/////////////////////----- Note -------//////////////


		~noteSamp_0.free;
		~noteSamp_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 0".postln;

				~transSamp.source=0;
				~tOSCAdrr.sendMsg('noteSampLabel', '0');
			});
			},
			'/ntSamp_0'
		);

		~noteSamp_1.free;
		~noteSamp_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 1".postln;
				//~transKick.source=1;~transSnr.source=1;~transHat.source=1;
				~transSamp.source=1;
				~tOSCAdrr.sendMsg('noteSampLabel', '1');
			});
			},
			'/ntSamp_1'
		);


		~noteSamp_2.free;
		~noteSamp_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 2".postln;
				//~transKick.source=2;~transSnr.source=2;~transHat.source=2;
				~transSamp.source=2;
				~tOSCAdrr.sendMsg('noteSampLabel', '2');
			});
			},
			'/ntSamp_2'
		);

		~noteSamp_3.free;
		~noteSamp_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 3".postln;
				//~transKick.source=3;~transSnr.source=3;~transHat.source=3;
				~transSamp.source=3;
				~tOSCAdrr.sendMsg('noteSampLabel', '3');
			});
			},
			'/ntSamp_3'
		);

		~noteSamp_4.free;
		~noteSamp_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 4".postln;
				//~transKick.source=4;~transSnr.source=4;~transHat.source=4;
				~transSamp.source=4;
				~tOSCAdrr.sendMsg('noteSampLabel', '4');
			});
			},
			'/ntSamp_4'
		);

		~noteSamp_5.free;
		~noteSamp_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 5".postln;
				//~transKick.source=5;~transSnr.source=5;~transHat.source=5;
				~transSamp.source=5;
				~tOSCAdrr.sendMsg('noteSampLabel', '5');
			});
			},
			'/ntSamp_5'
		);

		~noteSamp_6.free;
		~noteSamp_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 6".postln;
				//~transKick.source=6;~transSnr.source=6;~transHat.source=6;
				~transSamp.source=6;
				~tOSCAdrr.sendMsg('noteSampLabel', '6');
			});
			},
			'/ntSamp_6'
		);

		~noteSamp_7.free;
		~noteSamp_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 7".postln;
				//~transKick.source=7;~transSnr.source=7;~transHat.source=7;
				~transSamp.source=7;
				~tOSCAdrr.sendMsg('noteSampLabel', '7');
			});
			},
			'/ntSamp_7'
		);

		~noteSamp_8.free;
		~noteSamp_8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 8".postln;
				//~transKick.source=8;~transSnr.source=8;~transHat.source=8;
				~transSamp.source=8;
				~tOSCAdrr.sendMsg('noteSampLabel', '8');
			});
			},
			'/ntSamp_8'
		);

		~noteSamp_9.free;
		~noteSamp_9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 9".postln;
				//~transKick.source=9;~transSnr.source=9;~transHat.source=9;
				~transSamp.source=9;
				~tOSCAdrr.sendMsg('noteSampLabel', '9');
			});
			},
			'/ntSamp_9'
		);

		~noteSamp_10.free;
		~noteSamp_10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 10".postln;
				//~transKick.source=10;~transSnr.source=10;~transHat.source=10;
				~transSamp.source=10;
				~tOSCAdrr.sendMsg('noteSampLabel', '10');
			});
			},
			'/ntSamp_10'
		);

		~noteSamp_11.free;
		~noteSamp_11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 11".postln;
				//~transKick.source=11;~transSnr.source=11;~transHat.source=11;
				~transSamp.source=11;
				~tOSCAdrr.sendMsg('noteSampLabel', '11');
			});
			},
			'/ntSamp_11'
		);

		~noteSamp_12.free;
		~noteSamp_12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 12".postln;
				//~transKick.source=12;~transSnr.source=12;~transHat.source=12;
				~transSamp.source=12;
				~tOSCAdrr.sendMsg('noteSampLabel', '12');
			});
			},
			'/ntSamp_12'
		);

		~noteSamp_13.free;
		~noteSamp_13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 13".postln;
				//~transKick.source=13;~transSnr.source=13;~transHat.source=13;
				~transSamp.source=13;
				~tOSCAdrr.sendMsg('noteSampLabel', '13');
			});
			},
			'/ntSamp_13'
		);

		~noteSamp_14.free;
		~noteSamp_14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 14".postln;
				//~transKick.source=14;~transSnr.source=14;~transHat.source=14;
				~transSamp.source=14;
				~tOSCAdrr.sendMsg('noteSampLabel', '14');
			});
			},
			'/ntSamp_14'
		);

		//////////////////////////// NEGATIVE
		~noteSamp1.free;
		~noteSamp1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -1".postln;
				//~transKick.source=(-1);~transSnr.source=(-1);~transHat.source=(-1);
				~transSamp.source=(-1);
				~tOSCAdrr.sendMsg('noteSampLabel', '-1');
			});
			},
			'/ntSamp-1'
		);


		~noteSamp2.free;
		~noteSamp2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -2".postln;
				//~transKick.source=(-2);~transSnr.source=(-2);~transHat.source=(-2);
				~transSamp.source=(-2);
				~tOSCAdrr.sendMsg('noteSampLabel', '-2');
			});
			},
			'/ntSamp-2'
		);

		~noteSamp3.free;
		~noteSamp3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -3".postln;
				//~transKick.source=(-3);~transSnr.source=(-3);~transHat.source=(-3);
				~transSamp.source=(-3);
				~tOSCAdrr.sendMsg('noteSampLabel', '-3');
			});
			},
			'/ntSamp-3'
		);

		~noteSamp4.free;
		~noteSamp4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -4".postln;
				//~transKick.source=(-4);~transSnr.source=(-4);~transHat.source=(-4);
				~transSamp.source=(-4);
				~tOSCAdrr.sendMsg('noteSampLabel', '-4');
			});
			},
			'/ntSamp-4'
		);

		~noteSamp5.free;
		~noteSamp5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -5".postln;
				//~transKick.source=(-5);~transSnr.source=(-5);~transHat.source=(-5);
				~transSamp.source=(-5);
				~tOSCAdrr.sendMsg('noteSampLabel', '-5');
			});
			},
			'/ntSamp-5'
		);

		~noteSamp6.free;
		~noteSamp6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -6".postln;
				//~transKick.source=(-6);~transSnr.source=(-6);~transHat.source=(-6);
				~transSamp.source=(-6);
				~tOSCAdrr.sendMsg('noteSampLabel', '-6');
			});
			},
			'/ntSamp-6'
		);

		~noteSamp7.free;
		~noteSamp7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -7".postln;
				//~transKick.source=(-7);~transSnr.source=(-7);~transHat.source=(-7);
				~transSamp.source=(-7);
				~tOSCAdrr.sendMsg('noteSampLabel', '-7');
			});
			},
			'/ntSamp-7'
		);

		~noteSamp8.free;
		~noteSamp8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -8".postln;
				//~transKick.source=(-8);~transSnr.source=(-8);~transHat.source=(-8);
				~transSamp.source=(-8);
				~tOSCAdrr.sendMsg('noteSampLabel', '-8');
			});
			},
			'/ntSamp-8'
		);

		~noteSamp9.free;
		~noteSamp9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -9".postln;
				//~transKick.source=(-9);~transSnr.source=(-9);~transHat.source=(-9);
				~transSamp.source=(-9);
				~tOSCAdrr.sendMsg('noteSampLabel', '-9');
			});
			},
			'/ntSamp-9'
		);

		~noteSamp10.free;
		~noteSamp10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -10".postln;
				//~transKick.source=(-10);~transSnr.source=(-10);~transHat.source=(-10);
				~transSamp.source=(-10);
				~tOSCAdrr.sendMsg('noteSampLabel', '-10');
			});
			},
			'/ntSamp-10'
		);

		~noteSamp11.free;
		~noteSamp11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -11".postln;
				//~transKick.source=(-11);~transSnr.source=(-11);~transHat.source=(-11);
				~transSamp.source=(-11);
				~tOSCAdrr.sendMsg('noteSampLabel', '-11');
			});
			},
			'/ntSamp-11'
		);

		~noteSamp12.free;
		~noteSamp12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -12".postln;
				//~transKick.source=(-12);~transSnr.source=(-12);~transHat.source=(-12);
				~transSamp.source=(-12);
				~tOSCAdrr.sendMsg('noteSampLabel', '-12');
			});
			},
			'/ntSamp-12'
		);

		~noteSamp13.free;
		~noteSamp13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -13".postln;
				//~transKick.source=(-13);~transSnr.source=(-13);~transHat.source=(-13);
				~transSamp.source=(-13);
				~tOSCAdrr.sendMsg('noteSampLabel', '-13');
			});
			},
			'/ntSamp-13'
		);

		~noteSamp14.free;
		~noteSamp14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -14".postln;
				//~transKick.source=(-14);~transSnr.source=(-14);~transHat.source=(-14);
				~transSamp.source=(-14);
				~tOSCAdrr.sendMsg('noteSampLabel', '-14');
			});
			},
			'/ntSamp-14'
		);



	}

	*freeAll {



	}

}