/*
 IFPitchKeys.loadAll;
*/

IFPitchKeys {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
				1.0.wait;
				this.noteKeys;

			});*/
		}
	}

	*loadAll {

		this.buttons;
		this.noteKeysOn;
		this.noteKeysOff;

	}

	*buttons {

		"Transpose Shuffle LOOOOOOOAAAADDD".postln;

		~pitchKeysBut.free;
		~countPKeys=0;
		~pitchKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countPKeys = ~countPKeys + 1;

				~countPKeys.switch(
					0,{},
					1, {
						"PITCHKeys SWITCH ON".postln;
						~tOSCAdrr.sendMsg('pitchKeys', 1);
						IFPitchKeys.noteKeysOn;
						~apc40.noteOn(~apcLn1, 63, 1); //But 6
					},
					2,{
						"PITCHKeys SWITCH OFF".postln;
						~tOSCAdrr.sendMsg('pitchKeys', 0);
						~countPKeys=0;
						IFPitchKeys.noteKeysOff;
						~apc40.noteOn(~apcLn1, 63, 1); //But 6
					}
				)}
			);
			},
			'/pitchKeys'
		);

		//APC Pitch Keys Button
		~countPKeysApc=0;
		~apcPKeysButton.free;
		~apcPKeysButton=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~countPKeysApc = ~countPKeysApc + 1;
				~countPKeysApc.switch(
					0,{},
					1, {

						~local.sendMsg('pitchKeys', 1);


					},
					2,{
						~local.sendMsg('pitchKeys', 1);
						~countPKeysApc=0;

					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn1, noteNum:63);
	}

	*noteKeysOn {

		/////////////////////----- Note -------//////////////


		~noteKeys_0.free;
		~noteKeys_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Keys NOTE 0".postln;
				~transKeys.source=0;
				~tOSCAdrr.sendMsg('noteKeysLabel', '0');
			});
			},
			'/nt_0'
		);

		~noteKeys_1.free;
		~noteKeys_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 1".postln;
				//~transKick.source=1;~transSnr.source=1;~transHat.source=1;
				~transKeys.source=1;
				~tOSCAdrr.sendMsg('noteKeysLabel', '1');
			});
			},
			'/nt_1'
		);


		~noteKeys_2.free;
		~noteKeys_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 2".postln;
				//~transKick.source=2;~transSnr.source=2;~transHat.source=2;
				~transKeys.source=2;
				~tOSCAdrr.sendMsg('noteKeysLabel', '2');
			});
			},
			'/nt_2'
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
			'/nt_3'
		);

		~noteKeys_4.free;
		~noteKeys_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 4".postln;
				//~transKick.source=4;~transSnr.source=4;~transHat.source=4;
				~transKeys.source=4;
				~tOSCAdrr.sendMsg('noteKeysLabel', '4');
			});
			},
			'/nt_4'
		);

		~noteKeys_5.free;
		~noteKeys_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 5".postln;
				//~transKick.source=5;~transSnr.source=5;~transHat.source=5;
				~transKeys.source=5;
				~tOSCAdrr.sendMsg('noteKeysLabel', '5');
			});
			},
			'/nt_5'
		);

		~noteKeys_6.free;
		~noteKeys_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 6".postln;
				//~transKick.source=6;~transSnr.source=6;~transHat.source=6;
				~transKeys.source=6;
				~tOSCAdrr.sendMsg('noteKeysLabel', '6');
			});
			},
			'/nt_6'
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
			'/nt_7'
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
			'/nt_8'
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
			'/nt_9'
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
			'/nt_10'
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
			'/nt_11'
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
			'/nt_12'
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
			'/nt_13'
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
			'/nt_14'
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
			'/nt-1'
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
			'/nt-2'
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
			'/nt-3'
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
			'/nt-4'
		);

		~noteKeys5.free;
		~noteKeys5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -5".postln;
				//~transKick.source=(-5);~transSnr.source=(-5);~transHat.source=(-5);
				~transKeys.source=(-5);
				~tOSCAdrr.sendMsg('noteKeysLabel', '-5');
			});
			},
			'/nt-5'
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
			'/nt-6'
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
			'/nt-7'
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
			'/nt-8'
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
			'/nt-9'
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
			'/nt-10'
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
			'/nt-11'
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
			'/nt-12'
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
			'/nt-13'
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
			'/nt-14'
		);



	}

	*noteKeysOff {

		~noteKeys_0.free;

		~noteKeys_1.free;
		~noteKeys_2.free;
		~noteKeys_3.free;
		~noteKeys_4.free;
		~noteKeys_5.free;
		~noteKeys_6.free;
		~noteKeys_7.free;
		~noteKeys_8.free;
		~noteKeys_9.free;
		~noteKeys_10.free;
		~noteKeys_11.free;
		~noteKeys_12.free;
		~noteKeys_13.free;
		~noteKeys_14.free;

		~noteKeys1.free;
		~noteKeys2.free;
		~noteKeys3.free;
		~noteKeys4.free;
		~noteKeys5.free;
		~noteKeys6.free;
		~noteKeys7.free;
		~noteKeys8.free;
		~noteKeys9.free;
		~noteKeys10.free;
		~noteKeys11.free;
		~noteKeys12.free;
		~noteKeys13.free;
		~noteKeys14.free;

	}



}