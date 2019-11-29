/*
 IFPitchSnr.loadAll;
*/

IFPitchSnr {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
				1.0.wait;
				this.noteSnr;

			});*/
		}
	}

	*loadAll {

		this.buttons;
		this.noteSnrOn;
		this.noteSnrOff;

	}

	*buttons {
		~pitchSnrBut.free;
		~countPSnr=0;
		~pitchSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countPSnr = ~countPSnr + 1;

				~countPSnr.switch(
					0,{},
					1, {"PITCHSnr SWITCH ON".postln;
						~tOSCAdrr.sendMsg('pitchSnr', 1);
						IFPitchSnr.noteSnrOn;
						//~apcMn.noteOn(~apcMnCh, ~actButD2, 4); //But 5
					},
					2,{"PITCHSnr SWITCH OFF".postln;
						~tOSCAdrr.sendMsg('pitchSnr', 0);
						~countPSnr=0;
						IFPitchSnr.noteSnrOff;
						//~apcMn.noteOn(~apcMnCh, ~actButD2, 3); //But 5
						~countPSnrApc=0;
					}
				)
				}
			);},
			'/pitchSnr'
		);

		//APC Pitch Snr Button
		/*~countPSnrApc=0;
		~apcPSnrButton.free;
		~apcPSnrButton=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~countPSnrApc = ~countPSnrApc + 1;
				~countPSnrApc.switch(
					0,{},
					1, {
						~local.sendMsg('pitchSnr', 1);
					},
					2,{
						~local.sendMsg('pitchSnr', 1);
						~countPSnrApc=0;
					}
				)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButD2);*/
	}

	*noteSnrOn {
		/////////////////////----- Note -------//////////////
		~noteSnr_0.free;
		~noteSnr_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=0;
				~tOSCAdrr.sendMsg('noteSnrLabel', '0');
			});
			},
			'/nt_0'
		);

		~noteSnr_1.free;
		~noteSnr_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=1;
				~tOSCAdrr.sendMsg('noteSnrLabel', '1');
			});
			},
			'/nt_1'
		);


		~noteSnr_2.free;
		~noteSnr_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=2;
				~tOSCAdrr.sendMsg('noteSnrLabel', '2');
			});
			},
			'/nt_2'
		);

		~noteSnr_3.free;
		~noteSnr_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=3;
				~tOSCAdrr.sendMsg('noteSnrLabel', '3');
			});
			},
			'/nt_3'
		);

		~noteSnr_4.free;
		~noteSnr_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=4;
				~tOSCAdrr.sendMsg('noteSnrLabel', '4');
			});
			},
			'/nt_4'
		);

		~noteSnr_5.free;
		~noteSnr_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=5;
				~tOSCAdrr.sendMsg('noteSnrLabel', '5');
			});
			},
			'/nt_5'
		);

		~noteSnr_6.free;
		~noteSnr_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=6;
				~tOSCAdrr.sendMsg('noteSnrLabel', '6');
			});
			},
			'/nt_6'
		);

		~noteSnr_7.free;
		~noteSnr_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=7;
				~tOSCAdrr.sendMsg('noteSnrLabel', '7');
			});
			},
			'/nt_7'
		);

		~noteSnr_8.free;
		~noteSnr_8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=8;
				~tOSCAdrr.sendMsg('noteSnrLabel', '8');
			});
			},
			'/nt_8'
		);

		~noteSnr_9.free;
		~noteSnr_9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=9;
				~tOSCAdrr.sendMsg('noteSnrLabel', '9');
			});
			},
			'/nt_9'
		);

		~noteSnr_10.free;
		~noteSnr_10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=10;
				~tOSCAdrr.sendMsg('noteSnrLabel', '10');
			});
			},
			'/nt_10'
		);

		~noteSnr_11.free;
		~noteSnr_11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=11;
				~tOSCAdrr.sendMsg('noteSnrLabel', '11');
			});
			},
			'/nt_11'
		);

		~noteSnr_12.free;
		~noteSnr_12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=12;
				~tOSCAdrr.sendMsg('noteSnrLabel', '12');
			});
			},
			'/nt_12'
		);

		~noteSnr_13.free;
		~noteSnr_13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=13;
				~tOSCAdrr.sendMsg('noteSnrLabel', '13');
			});
			},
			'/nt_13'
		);

		~noteSnr_14.free;
		~noteSnr_14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=14;
				~tOSCAdrr.sendMsg('noteSnrLabel', '14');
			});
			},
			'/nt_14'
		);

		//////////////////////////// NEGATIVE
		~noteSnr1.free;
		~noteSnr1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=(-1);
				~tOSCAdrr.sendMsg('noteSnrLabel', '-1');
			});
			},
			'/nt-1'
		);


		~noteSnr2.free;
		~noteSnr2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=(-2);
				~tOSCAdrr.sendMsg('noteSnrLabel', '-2');
			});
			},
			'/nt-2'
		);

		~noteSnr3.free;
		~noteSnr3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=(-3);
				~tOSCAdrr.sendMsg('noteSnrLabel', '-3');
			});
			},
			'/nt-3'
		);

		~noteSnr4.free;
		~noteSnr4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=(-4);
				~tOSCAdrr.sendMsg('noteSnrLabel', '-4');
			});
			},
			'/nt-4'
		);

		~noteSnr5.free;
		~noteSnr5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=(-5);
				~tOSCAdrr.sendMsg('noteSnrLabel', '-5');
			});
			},
			'/nt-5'
		);

		~noteSnr6.free;
		~noteSnr6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=(-6);
				~tOSCAdrr.sendMsg('noteSnrLabel', '-6');
			});
			},
			'/nt-6'
		);

		~noteSnr7.free;
		~noteSnr7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=(-7);
				~tOSCAdrr.sendMsg('noteSnrLabel', '-7');
			});
			},
			'/nt-7'
		);

		~noteSnr8.free;
		~noteSnr8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=(-8);
				~tOSCAdrr.sendMsg('noteSnrLabel', '-8');
			});
			},
			'/nt-8'
		);

		~noteSnr9.free;
		~noteSnr9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=(-9);
				~tOSCAdrr.sendMsg('noteSnrLabel', '-9');
			});
			},
			'/nt-9'
		);

		~noteSnr10.free;
		~noteSnr10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=(-10);
				~tOSCAdrr.sendMsg('noteSnrLabel', '-10');
			});
			},
			'/nt-10'
		);

		~noteSnr11.free;
		~noteSnr11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=(-11);
				~tOSCAdrr.sendMsg('noteSnrLabel', '-11');
			});
			},
			'/nt-11'
		);

		~noteSnr12.free;
		~noteSnr12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=(-12);
				~tOSCAdrr.sendMsg('noteSnrLabel', '-12');
			});
			},
			'/nt-12'
		);

		~noteSnr13.free;
		~noteSnr13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=(-13);
				~tOSCAdrr.sendMsg('noteSnrLabel', '-13');
			});
			},
			'/nt-13'
		);

		~noteSnr14.free;
		~noteSnr14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSnr.source=(-14);
				~tOSCAdrr.sendMsg('noteSnrLabel', '-14');
			});
			},
			'/nt-14'
		);



	}

	*noteSnrOff {

		~noteSnr_0.free;

		~noteSnr_1.free;
		~noteSnr_2.free;
		~noteSnr_3.free;
		~noteSnr_4.free;
		~noteSnr_5.free;
		~noteSnr_6.free;
		~noteSnr_7.free;
		~noteSnr_8.free;
		~noteSnr_9.free;
		~noteSnr_10.free;
		~noteSnr_11.free;
		~noteSnr_12.free;
		~noteSnr_13.free;
		~noteSnr_14.free;

		~noteSnr1.free;
		~noteSnr2.free;
		~noteSnr3.free;
		~noteSnr4.free;
		~noteSnr5.free;
		~noteSnr6.free;
		~noteSnr7.free;
		~noteSnr8.free;
		~noteSnr9.free;
		~noteSnr10.free;
		~noteSnr11.free;
		~noteSnr12.free;
		~noteSnr13.free;
		~noteSnr14.free;

	}



}