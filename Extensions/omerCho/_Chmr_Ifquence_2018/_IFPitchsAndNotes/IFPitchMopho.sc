/*
 IFPitchMopho.loadAll;
*/

IFPitchMopho {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
				1.0.wait;
				this.noteMopho;

			});*/
		}
	}

	*loadAll {

		this.buttons;
		this.noteMophoOn;
		this.noteMophoOff;

	}

	*buttons {
		~pitchMophoBut.free;
		~countPMopho=0;
		~pitchMophoBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countPMopho = ~countPMopho + 1;

				~countPMopho.switch(
					0,{},
					1, {"PITCHMopho SWITCH ON".postln;
						~tOSCAdrr.sendMsg('pitchMopho', 1);
						IFPitchMopho.noteMophoOn;
						~lpMn.noteOn(~lpMnCh, ~lpMnButV5, 1); //But 7
					},
					2,{"PITCHMopho SWITCH OFF".postln;
						~tOSCAdrr.sendMsg('pitchMopho', 0);
						~countPMopho=0;
						IFPitchMopho.noteMophoOff;
						~lpMn.noteOn(~lpMnCh, ~lpMnButV5, 0); //But 7
					}
				)
				}
			);},
			'/pitchMopho'
		);

		//APC Pitch Mopho Button
		~countPMophoApc=0;
		~apcPMophoButton.free;
		~apcPMophoButton=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~countPMophoApc = ~countPMophoApc + 1;
				~countPMophoApc.switch(
					0,{},
					1, {
						~local.sendMsg('pitchMopho', 1);
					},
					2,{
						~local.sendMsg('pitchMopho', 1);
						~countPMophoApc=0;
					}
				)}
			);
		},srcID:~lpMnInID, chan:~lpMnCh, noteNum:~lpMnButV5);
	}

	*noteMophoOn {
		/////////////////////----- Note -------//////////////
		~noteMopho_0.free;
		~noteMopho_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=0;
				~tOSCAdrr.sendMsg('noteMophoLabel', '0');
			});
			},
			'/nt_0'
		);

		~noteMopho_1.free;
		~noteMopho_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=1;
				~tOSCAdrr.sendMsg('noteMophoLabel', '1');
			});
			},
			'/nt_1'
		);


		~noteMopho_2.free;
		~noteMopho_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=2;
				~tOSCAdrr.sendMsg('noteMophoLabel', '2');
			});
			},
			'/nt_2'
		);

		~noteMopho_3.free;
		~noteMopho_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=3;
				~tOSCAdrr.sendMsg('noteMophoLabel', '3');
			});
			},
			'/nt_3'
		);

		~noteMopho_4.free;
		~noteMopho_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=4;
				~tOSCAdrr.sendMsg('noteMophoLabel', '4');
			});
			},
			'/nt_4'
		);

		~noteMopho_5.free;
		~noteMopho_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=5;
				~tOSCAdrr.sendMsg('noteMophoLabel', '5');
			});
			},
			'/nt_5'
		);

		~noteMopho_6.free;
		~noteMopho_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=6;
				~tOSCAdrr.sendMsg('noteMophoLabel', '6');
			});
			},
			'/nt_6'
		);

		~noteMopho_7.free;
		~noteMopho_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=7;
				~tOSCAdrr.sendMsg('noteMophoLabel', '7');
			});
			},
			'/nt_7'
		);

		~noteMopho_8.free;
		~noteMopho_8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=8;
				~tOSCAdrr.sendMsg('noteMophoLabel', '8');
			});
			},
			'/nt_8'
		);

		~noteMopho_9.free;
		~noteMopho_9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=9;
				~tOSCAdrr.sendMsg('noteMophoLabel', '9');
			});
			},
			'/nt_9'
		);

		~noteMopho_10.free;
		~noteMopho_10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=10;
				~tOSCAdrr.sendMsg('noteMophoLabel', '10');
			});
			},
			'/nt_10'
		);

		~noteMopho_11.free;
		~noteMopho_11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=11;
				~tOSCAdrr.sendMsg('noteMophoLabel', '11');
			});
			},
			'/nt_11'
		);

		~noteMopho_12.free;
		~noteMopho_12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=12;
				~tOSCAdrr.sendMsg('noteMophoLabel', '12');
			});
			},
			'/nt_12'
		);

		~noteMopho_13.free;
		~noteMopho_13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=13;
				~tOSCAdrr.sendMsg('noteMophoLabel', '13');
			});
			},
			'/nt_13'
		);

		~noteMopho_14.free;
		~noteMopho_14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=14;
				~tOSCAdrr.sendMsg('noteMophoLabel', '14');
			});
			},
			'/nt_14'
		);

		//////////////////////////// NEGATIVE
		~noteMopho1.free;
		~noteMopho1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=(-1);
				~tOSCAdrr.sendMsg('noteMophoLabel', '-1');
			});
			},
			'/nt-1'
		);


		~noteMopho2.free;
		~noteMopho2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=(-2);
				~tOSCAdrr.sendMsg('noteMophoLabel', '-2');
			});
			},
			'/nt-2'
		);

		~noteMopho3.free;
		~noteMopho3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=(-3);
				~tOSCAdrr.sendMsg('noteMophoLabel', '-3');
			});
			},
			'/nt-3'
		);

		~noteMopho4.free;
		~noteMopho4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=(-4);
				~tOSCAdrr.sendMsg('noteMophoLabel', '-4');
			});
			},
			'/nt-4'
		);

		~noteMopho5.free;
		~noteMopho5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=(-5);
				~tOSCAdrr.sendMsg('noteMophoLabel', '-5');
			});
			},
			'/nt-5'
		);

		~noteMopho6.free;
		~noteMopho6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=(-6);
				~tOSCAdrr.sendMsg('noteMophoLabel', '-6');
			});
			},
			'/nt-6'
		);

		~noteMopho7.free;
		~noteMopho7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=(-7);
				~tOSCAdrr.sendMsg('noteMophoLabel', '-7');
			});
			},
			'/nt-7'
		);

		~noteMopho8.free;
		~noteMopho8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=(-8);
				~tOSCAdrr.sendMsg('noteMophoLabel', '-8');
			});
			},
			'/nt-8'
		);

		~noteMopho9.free;
		~noteMopho9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=(-9);
				~tOSCAdrr.sendMsg('noteMophoLabel', '-9');
			});
			},
			'/nt-9'
		);

		~noteMopho10.free;
		~noteMopho10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=(-10);
				~tOSCAdrr.sendMsg('noteMophoLabel', '-10');
			});
			},
			'/nt-10'
		);

		~noteMopho11.free;
		~noteMopho11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=(-11);
				~tOSCAdrr.sendMsg('noteMophoLabel', '-11');
			});
			},
			'/nt-11'
		);

		~noteMopho12.free;
		~noteMopho12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=(-12);
				~tOSCAdrr.sendMsg('noteMophoLabel', '-12');
			});
			},
			'/nt-12'
		);

		~noteMopho13.free;
		~noteMopho13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=(-13);
				~tOSCAdrr.sendMsg('noteMophoLabel', '-13');
			});
			},
			'/nt-13'
		);

		~noteMopho14.free;
		~noteMopho14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transMopho.source=(-14);
				~tOSCAdrr.sendMsg('noteMophoLabel', '-14');
			});
			},
			'/nt-14'
		);



	}

	*noteMophoOff {

		~noteMopho_0.free;

		~noteMopho_1.free;
		~noteMopho_2.free;
		~noteMopho_3.free;
		~noteMopho_4.free;
		~noteMopho_5.free;
		~noteMopho_6.free;
		~noteMopho_7.free;
		~noteMopho_8.free;
		~noteMopho_9.free;
		~noteMopho_10.free;
		~noteMopho_11.free;
		~noteMopho_12.free;
		~noteMopho_13.free;
		~noteMopho_14.free;

		~noteMopho1.free;
		~noteMopho2.free;
		~noteMopho3.free;
		~noteMopho4.free;
		~noteMopho5.free;
		~noteMopho6.free;
		~noteMopho7.free;
		~noteMopho8.free;
		~noteMopho9.free;
		~noteMopho10.free;
		~noteMopho11.free;
		~noteMopho12.free;
		~noteMopho13.free;
		~noteMopho14.free;

	}



}