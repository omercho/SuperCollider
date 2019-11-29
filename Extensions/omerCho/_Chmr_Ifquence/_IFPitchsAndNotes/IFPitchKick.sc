/*
 IFPitchKick.loadAll;
*/

IFPitchKick {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
				1.0.wait;
				this.noteKick;

			});*/
		}
	}

	*loadAll {

		this.buttons;
		this.noteKickOn;
		this.noteKickOff;

	}

	*buttons {
		~pitchKickBut.free;
		~countPKick=0;
		~pitchKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countPKick = ~countPKick + 1;

				~countPKick.switch(
					0,{},
					1, {"PITCHKick SWITCH ON".postln;
						~tOSCAdrr.sendMsg('pitchKick', 1);
						IFPitchKick.noteKickOn;
						//~apcMn.noteOn(~apcMnCh, ~actButD1, 4); //But 5
					},
					2,{"PITCHKick SWITCH OFF".postln;
						~tOSCAdrr.sendMsg('pitchKick', 0);
						~countPKick=0;
						IFPitchKick.noteKickOff;
						//~apcMn.noteOn(~apcMnCh, ~actButD1, 3); //But 5
						~countPKickApc=0;
					}
				)
				}
			);},
			'/pitchKick'
		);

		//APC Pitch Kick Button
		/*~countPKickApc=0;
		~apcPKickButton.free;
		~apcPKickButton=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~countPKickApc = ~countPKickApc + 1;
				~countPKickApc.switch(
					0,{},
					1, {
						~local.sendMsg('pitchKick', 1);
					},
					2,{
						~local.sendMsg('pitchKick', 1);
						~countPKickApc=0;
					}
				)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButD1);*/
	}

	*noteKickOn {
		/////////////////////----- Note -------//////////////
		~noteKick_0.free;
		~noteKick_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=0;
				~tOSCAdrr.sendMsg('noteKickLabel', '0');
			});
			},
			'/nt_0'
		);

		~noteKick_1.free;
		~noteKick_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=1;
				~tOSCAdrr.sendMsg('noteKickLabel', '1');
			});
			},
			'/nt_1'
		);


		~noteKick_2.free;
		~noteKick_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=2;
				~tOSCAdrr.sendMsg('noteKickLabel', '2');
			});
			},
			'/nt_2'
		);

		~noteKick_3.free;
		~noteKick_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=3;
				~tOSCAdrr.sendMsg('noteKickLabel', '3');
			});
			},
			'/nt_3'
		);

		~noteKick_4.free;
		~noteKick_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=4;
				~tOSCAdrr.sendMsg('noteKickLabel', '4');
			});
			},
			'/nt_4'
		);

		~noteKick_5.free;
		~noteKick_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=5;
				~tOSCAdrr.sendMsg('noteKickLabel', '5');
			});
			},
			'/nt_5'
		);

		~noteKick_6.free;
		~noteKick_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=6;
				~tOSCAdrr.sendMsg('noteKickLabel', '6');
			});
			},
			'/nt_6'
		);

		~noteKick_7.free;
		~noteKick_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=7;
				~tOSCAdrr.sendMsg('noteKickLabel', '7');
			});
			},
			'/nt_7'
		);

		~noteKick_8.free;
		~noteKick_8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=8;
				~tOSCAdrr.sendMsg('noteKickLabel', '8');
			});
			},
			'/nt_8'
		);

		~noteKick_9.free;
		~noteKick_9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=9;
				~tOSCAdrr.sendMsg('noteKickLabel', '9');
			});
			},
			'/nt_9'
		);

		~noteKick_10.free;
		~noteKick_10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=10;
				~tOSCAdrr.sendMsg('noteKickLabel', '10');
			});
			},
			'/nt_10'
		);

		~noteKick_11.free;
		~noteKick_11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=11;
				~tOSCAdrr.sendMsg('noteKickLabel', '11');
			});
			},
			'/nt_11'
		);

		~noteKick_12.free;
		~noteKick_12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=12;
				~tOSCAdrr.sendMsg('noteKickLabel', '12');
			});
			},
			'/nt_12'
		);

		~noteKick_13.free;
		~noteKick_13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=13;
				~tOSCAdrr.sendMsg('noteKickLabel', '13');
			});
			},
			'/nt_13'
		);

		~noteKick_14.free;
		~noteKick_14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=14;
				~tOSCAdrr.sendMsg('noteKickLabel', '14');
			});
			},
			'/nt_14'
		);

		//////////////////////////// NEGATIVE
		~noteKick1.free;
		~noteKick1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=(-1);
				~tOSCAdrr.sendMsg('noteKickLabel', '-1');
			});
			},
			'/nt-1'
		);


		~noteKick2.free;
		~noteKick2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=(-2);
				~tOSCAdrr.sendMsg('noteKickLabel', '-2');
			});
			},
			'/nt-2'
		);

		~noteKick3.free;
		~noteKick3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=(-3);
				~tOSCAdrr.sendMsg('noteKickLabel', '-3');
			});
			},
			'/nt-3'
		);

		~noteKick4.free;
		~noteKick4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=(-4);
				~tOSCAdrr.sendMsg('noteKickLabel', '-4');
			});
			},
			'/nt-4'
		);

		~noteKick5.free;
		~noteKick5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=(-5);
				~tOSCAdrr.sendMsg('noteKickLabel', '-5');
			});
			},
			'/nt-5'
		);

		~noteKick6.free;
		~noteKick6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=(-6);
				~tOSCAdrr.sendMsg('noteKickLabel', '-6');
			});
			},
			'/nt-6'
		);

		~noteKick7.free;
		~noteKick7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=(-7);
				~tOSCAdrr.sendMsg('noteKickLabel', '-7');
			});
			},
			'/nt-7'
		);

		~noteKick8.free;
		~noteKick8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=(-8);
				~tOSCAdrr.sendMsg('noteKickLabel', '-8');
			});
			},
			'/nt-8'
		);

		~noteKick9.free;
		~noteKick9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=(-9);
				~tOSCAdrr.sendMsg('noteKickLabel', '-9');
			});
			},
			'/nt-9'
		);

		~noteKick10.free;
		~noteKick10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=(-10);
				~tOSCAdrr.sendMsg('noteKickLabel', '-10');
			});
			},
			'/nt-10'
		);

		~noteKick11.free;
		~noteKick11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=(-11);
				~tOSCAdrr.sendMsg('noteKickLabel', '-11');
			});
			},
			'/nt-11'
		);

		~noteKick12.free;
		~noteKick12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=(-12);
				~tOSCAdrr.sendMsg('noteKickLabel', '-12');
			});
			},
			'/nt-12'
		);

		~noteKick13.free;
		~noteKick13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=(-13);
				~tOSCAdrr.sendMsg('noteKickLabel', '-13');
			});
			},
			'/nt-13'
		);

		~noteKick14.free;
		~noteKick14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transKick.source=(-14);
				~tOSCAdrr.sendMsg('noteKickLabel', '-14');
			});
			},
			'/nt-14'
		);



	}

	*noteKickOff {

		~noteKick_0.free;

		~noteKick_1.free;
		~noteKick_2.free;
		~noteKick_3.free;
		~noteKick_4.free;
		~noteKick_5.free;
		~noteKick_6.free;
		~noteKick_7.free;
		~noteKick_8.free;
		~noteKick_9.free;
		~noteKick_10.free;
		~noteKick_11.free;
		~noteKick_12.free;
		~noteKick_13.free;
		~noteKick_14.free;

		~noteKick1.free;
		~noteKick2.free;
		~noteKick3.free;
		~noteKick4.free;
		~noteKick5.free;
		~noteKick6.free;
		~noteKick7.free;
		~noteKick8.free;
		~noteKick9.free;
		~noteKick10.free;
		~noteKick11.free;
		~noteKick12.free;
		~noteKick13.free;
		~noteKick14.free;

	}



}