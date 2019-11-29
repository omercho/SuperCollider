/*
 IFPitchHat.loadAll;
*/

IFPitchHat {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
				1.0.wait;
				this.noteHat;

			});*/
		}
	}

	*loadAll {

		this.buttons;
		this.noteHatOn;
		this.noteHatOff;

	}

	*buttons {
		~pitchHatBut.free;
		~countPHat=0;
		~pitchHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countPHat = ~countPHat + 1;

				~countPHat.switch(
					0,{},
					1, {"PITCHHat SWITCH ON".postln;
						~tOSCAdrr.sendMsg('pitchHat', 1);
						IFPitchHat.noteHatOn;
						//~apcMn.noteOn(~apcMnCh, ~actButD3, 4); //But 5
					},
					2,{"PITCHHat SWITCH OFF".postln;
						~tOSCAdrr.sendMsg('pitchHat', 0);
						~countPHat=0;
						IFPitchHat.noteHatOff;
						//~apcMn.noteOn(~apcMnCh, ~actButD3, 3); //But 5
						~countPHatApc=0;
					}
				)
				}
			);},
			'/pitchHat'
		);

		//APC Pitch Hat Button
		/*~countPHatApc=0;
		~apcPHatButton.free;
		~apcPHatButton=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~countPHatApc = ~countPHatApc + 1;
				~countPHatApc.switch(
					0,{},
					1, {
						~local.sendMsg('pitchHat', 1);
					},
					2,{
						~local.sendMsg('pitchHat', 1);
						~countPHatApc=0;
					}
				)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButD3);*/
	}

	*noteHatOn {
		/////////////////////----- Note -------//////////////
		~noteHat_0.free;
		~noteHat_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=0;
				~tOSCAdrr.sendMsg('noteHatLabel', '0');
			});
			},
			'/nt_0'
		);

		~noteHat_1.free;
		~noteHat_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=1;
				~tOSCAdrr.sendMsg('noteHatLabel', '1');
			});
			},
			'/nt_1'
		);


		~noteHat_2.free;
		~noteHat_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=2;
				~tOSCAdrr.sendMsg('noteHatLabel', '2');
			});
			},
			'/nt_2'
		);

		~noteHat_3.free;
		~noteHat_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=3;
				~tOSCAdrr.sendMsg('noteHatLabel', '3');
			});
			},
			'/nt_3'
		);

		~noteHat_4.free;
		~noteHat_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=4;
				~tOSCAdrr.sendMsg('noteHatLabel', '4');
			});
			},
			'/nt_4'
		);

		~noteHat_5.free;
		~noteHat_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=5;
				~tOSCAdrr.sendMsg('noteHatLabel', '5');
			});
			},
			'/nt_5'
		);

		~noteHat_6.free;
		~noteHat_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=6;
				~tOSCAdrr.sendMsg('noteHatLabel', '6');
			});
			},
			'/nt_6'
		);

		~noteHat_7.free;
		~noteHat_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=7;
				~tOSCAdrr.sendMsg('noteHatLabel', '7');
			});
			},
			'/nt_7'
		);

		~noteHat_8.free;
		~noteHat_8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=8;
				~tOSCAdrr.sendMsg('noteHatLabel', '8');
			});
			},
			'/nt_8'
		);

		~noteHat_9.free;
		~noteHat_9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=9;
				~tOSCAdrr.sendMsg('noteHatLabel', '9');
			});
			},
			'/nt_9'
		);

		~noteHat_10.free;
		~noteHat_10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=10;
				~tOSCAdrr.sendMsg('noteHatLabel', '10');
			});
			},
			'/nt_10'
		);

		~noteHat_11.free;
		~noteHat_11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=11;
				~tOSCAdrr.sendMsg('noteHatLabel', '11');
			});
			},
			'/nt_11'
		);

		~noteHat_12.free;
		~noteHat_12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=12;
				~tOSCAdrr.sendMsg('noteHatLabel', '12');
			});
			},
			'/nt_12'
		);

		~noteHat_13.free;
		~noteHat_13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=13;
				~tOSCAdrr.sendMsg('noteHatLabel', '13');
			});
			},
			'/nt_13'
		);

		~noteHat_14.free;
		~noteHat_14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=14;
				~tOSCAdrr.sendMsg('noteHatLabel', '14');
			});
			},
			'/nt_14'
		);

		//////////////////////////// NEGATIVE
		~noteHat1.free;
		~noteHat1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=(-1);
				~tOSCAdrr.sendMsg('noteHatLabel', '-1');
			});
			},
			'/nt-1'
		);


		~noteHat2.free;
		~noteHat2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=(-2);
				~tOSCAdrr.sendMsg('noteHatLabel', '-2');
			});
			},
			'/nt-2'
		);

		~noteHat3.free;
		~noteHat3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=(-3);
				~tOSCAdrr.sendMsg('noteHatLabel', '-3');
			});
			},
			'/nt-3'
		);

		~noteHat4.free;
		~noteHat4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=(-4);
				~tOSCAdrr.sendMsg('noteHatLabel', '-4');
			});
			},
			'/nt-4'
		);

		~noteHat5.free;
		~noteHat5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=(-5);
				~tOSCAdrr.sendMsg('noteHatLabel', '-5');
			});
			},
			'/nt-5'
		);

		~noteHat6.free;
		~noteHat6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=(-6);
				~tOSCAdrr.sendMsg('noteHatLabel', '-6');
			});
			},
			'/nt-6'
		);

		~noteHat7.free;
		~noteHat7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=(-7);
				~tOSCAdrr.sendMsg('noteHatLabel', '-7');
			});
			},
			'/nt-7'
		);

		~noteHat8.free;
		~noteHat8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=(-8);
				~tOSCAdrr.sendMsg('noteHatLabel', '-8');
			});
			},
			'/nt-8'
		);

		~noteHat9.free;
		~noteHat9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=(-9);
				~tOSCAdrr.sendMsg('noteHatLabel', '-9');
			});
			},
			'/nt-9'
		);

		~noteHat10.free;
		~noteHat10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=(-10);
				~tOSCAdrr.sendMsg('noteHatLabel', '-10');
			});
			},
			'/nt-10'
		);

		~noteHat11.free;
		~noteHat11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=(-11);
				~tOSCAdrr.sendMsg('noteHatLabel', '-11');
			});
			},
			'/nt-11'
		);

		~noteHat12.free;
		~noteHat12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=(-12);
				~tOSCAdrr.sendMsg('noteHatLabel', '-12');
			});
			},
			'/nt-12'
		);

		~noteHat13.free;
		~noteHat13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=(-13);
				~tOSCAdrr.sendMsg('noteHatLabel', '-13');
			});
			},
			'/nt-13'
		);

		~noteHat14.free;
		~noteHat14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transHat.source=(-14);
				~tOSCAdrr.sendMsg('noteHatLabel', '-14');
			});
			},
			'/nt-14'
		);



	}

	*noteHatOff {

		~noteHat_0.free;

		~noteHat_1.free;
		~noteHat_2.free;
		~noteHat_3.free;
		~noteHat_4.free;
		~noteHat_5.free;
		~noteHat_6.free;
		~noteHat_7.free;
		~noteHat_8.free;
		~noteHat_9.free;
		~noteHat_10.free;
		~noteHat_11.free;
		~noteHat_12.free;
		~noteHat_13.free;
		~noteHat_14.free;

		~noteHat1.free;
		~noteHat2.free;
		~noteHat3.free;
		~noteHat4.free;
		~noteHat5.free;
		~noteHat6.free;
		~noteHat7.free;
		~noteHat8.free;
		~noteHat9.free;
		~noteHat10.free;
		~noteHat11.free;
		~noteHat12.free;
		~noteHat13.free;
		~noteHat14.free;

	}



}