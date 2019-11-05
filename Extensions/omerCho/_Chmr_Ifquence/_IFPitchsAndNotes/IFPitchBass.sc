/*
IFPitchBass.loadAll;
*/

IFPitchBass {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
			1.0.wait;
			this.noteBass;

			});*/
		}
	}

	*loadAll {

		this.buttons;
		this.noteBassOn;
		this.noteBassOff;

	}

	*buttons {

		~pitchBassBut.free;
		~countPBass=0;
		~pitchBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countPBass = ~countPBass + 1;

				~countPBass.switch(
					0,{
						"PITCHBass SWITCH 0".postln;
					},
					1, {
						"PITCHBass SWITCH ON".postln;
						~tOSCAdrr.sendMsg('pitchBass', 1);
						IFPitchBass.noteBassOn;
						~apcMn.noteOn(~apcMnCh, ~actButD4, 4); //But 5
					},
					2,{
						"PITCHBass SWITCH OFF".postln;
						~tOSCAdrr.sendMsg('pitchBass', 0);
						~countPBass=0;
						IFPitchBass.noteBassOff;
						~apcMn.noteOn(~apcMnCh, ~actButD4, 3); //But 5
					}
			)});
		},'/pitchBass');

		//APC Pitch Bass Button
		~countPBassApc=0;
		~lpPBassButton.free;
		~lpPBassButton=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~countPBassApc = ~countPBassApc + 1;
				~countPBassApc.switch(
					0,{},
					1, {~local.sendMsg('pitchBass', 1);},
					2,{
						~local.sendMsg('pitchBass', 1);
						~countPBassApc=0;
					}
			)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButD8);
	}

	*noteBassOn {

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
		'/nt_0'
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
		'/nt_1'
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
		'/nt_2'
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
		'/nt_3'
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
		'/nt_4'
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
		'/nt_5'
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
		'/nt_6'
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
		'/nt_7'
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
		'/nt_8'
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
		'/nt_9'
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
		'/nt_10'
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
		'/nt_11'
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
		'/nt_12'
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
		'/nt_13'
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
		'/nt_14'
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
		'/nt-1'
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
		'/nt-2'
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
		'/nt-3'
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
		'/nt-4'
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
		'/nt-5'
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
		'/nt-6'
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
		'/nt-7'
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
		'/nt-8'
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
		'/nt-9'
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
		'/nt-10'
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
		'/nt-11'
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
		'/nt-12'
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
		'/nt-13'
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
		'/nt-14'
		);



	}

	*noteBassOff {

		~noteBass_0.free;

		~noteBass_1.free;
		~noteBass_2.free;
		~noteBass_3.free;
		~noteBass_4.free;
		~noteBass_5.free;
		~noteBass_6.free;
		~noteBass_7.free;
		~noteBass_8.free;
		~noteBass_9.free;
		~noteBass_10.free;
		~noteBass_11.free;
		~noteBass_12.free;
		~noteBass_13.free;
		~noteBass_14.free;

		~noteBass1.free;
		~noteBass2.free;
		~noteBass3.free;
		~noteBass4.free;
		~noteBass5.free;
		~noteBass6.free;
		~noteBass7.free;
		~noteBass8.free;
		~noteBass9.free;
		~noteBass10.free;
		~noteBass11.free;
		~noteBass12.free;
		~noteBass13.free;
		~noteBass14.free;

	}



}