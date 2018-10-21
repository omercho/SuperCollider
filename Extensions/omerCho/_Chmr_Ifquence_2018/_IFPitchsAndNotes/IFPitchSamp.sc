/*
 IFPitchSamp.loadAll;
*/

IFPitchSamp {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
				1.0.wait;
				this.noteSamp;

			});*/
		}
	}

	*loadAll {

		this.buttons;
		this.noteSampOn;
		this.noteSampOff;

	}

	*buttons {
		~pitchSampBut.free;
		~countPSamp=0;
		~pitchSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countPSamp = ~countPSamp + 1;

				~countPSamp.switch(
					0,{},
					1, {"PITCHSamp SWITCH ON".postln;
						~tOSCAdrr.sendMsg('pitchSamp', 1);
						IFPitchSamp.noteSampOn;
						~lpMn.noteOn(~lpMnCh, 88, 1); //But 7
					},
					2,{"PITCHSamp SWITCH OFF".postln;
						~tOSCAdrr.sendMsg('pitchSamp', 0);
						~countPSamp=0;
						IFPitchSamp.noteSampOff;
						~lpMn.noteOn(~lpMnCh, 88, 0); //But 7
					}
				)
				}
			);},
			'/pitchSamp'
		);

		//APC Pitch Samp Button
		~countPSampApc=0;
		~apcPSampButton.free;
		~apcPSampButton=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~countPSampApc = ~countPSampApc + 1;
				~countPSampApc.switch(
					0,{},
					1, {
						~local.sendMsg('pitchSamp', 1);
					},
					2,{
						~local.sendMsg('pitchSamp', 1);
						~countPSampApc=0;
					}
				)}
			);
		},srcID:~lpMnInID, chan:~lpMnCh, noteNum:88);
	}

	*noteSampOn {
		/////////////////////----- Note -------//////////////
		~noteSamp_0.free;
		~noteSamp_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=0;
				~tOSCAdrr.sendMsg('noteSampLabel', '0');
			});
			},
			'/nt_0'
		);

		~noteSamp_1.free;
		~noteSamp_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=1;
				~tOSCAdrr.sendMsg('noteSampLabel', '1');
			});
			},
			'/nt_1'
		);


		~noteSamp_2.free;
		~noteSamp_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=2;
				~tOSCAdrr.sendMsg('noteSampLabel', '2');
			});
			},
			'/nt_2'
		);

		~noteSamp_3.free;
		~noteSamp_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=3;
				~tOSCAdrr.sendMsg('noteSampLabel', '3');
			});
			},
			'/nt_3'
		);

		~noteSamp_4.free;
		~noteSamp_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=4;
				~tOSCAdrr.sendMsg('noteSampLabel', '4');
			});
			},
			'/nt_4'
		);

		~noteSamp_5.free;
		~noteSamp_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=5;
				~tOSCAdrr.sendMsg('noteSampLabel', '5');
			});
			},
			'/nt_5'
		);

		~noteSamp_6.free;
		~noteSamp_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=6;
				~tOSCAdrr.sendMsg('noteSampLabel', '6');
			});
			},
			'/nt_6'
		);

		~noteSamp_7.free;
		~noteSamp_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=7;
				~tOSCAdrr.sendMsg('noteSampLabel', '7');
			});
			},
			'/nt_7'
		);

		~noteSamp_8.free;
		~noteSamp_8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=8;
				~tOSCAdrr.sendMsg('noteSampLabel', '8');
			});
			},
			'/nt_8'
		);

		~noteSamp_9.free;
		~noteSamp_9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=9;
				~tOSCAdrr.sendMsg('noteSampLabel', '9');
			});
			},
			'/nt_9'
		);

		~noteSamp_10.free;
		~noteSamp_10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=10;
				~tOSCAdrr.sendMsg('noteSampLabel', '10');
			});
			},
			'/nt_10'
		);

		~noteSamp_11.free;
		~noteSamp_11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=11;
				~tOSCAdrr.sendMsg('noteSampLabel', '11');
			});
			},
			'/nt_11'
		);

		~noteSamp_12.free;
		~noteSamp_12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=12;
				~tOSCAdrr.sendMsg('noteSampLabel', '12');
			});
			},
			'/nt_12'
		);

		~noteSamp_13.free;
		~noteSamp_13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=13;
				~tOSCAdrr.sendMsg('noteSampLabel', '13');
			});
			},
			'/nt_13'
		);

		~noteSamp_14.free;
		~noteSamp_14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=14;
				~tOSCAdrr.sendMsg('noteSampLabel', '14');
			});
			},
			'/nt_14'
		);

		//////////////////////////// NEGATIVE
		~noteSamp1.free;
		~noteSamp1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=(-1);
				~tOSCAdrr.sendMsg('noteSampLabel', '-1');
			});
			},
			'/nt-1'
		);


		~noteSamp2.free;
		~noteSamp2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=(-2);
				~tOSCAdrr.sendMsg('noteSampLabel', '-2');
			});
			},
			'/nt-2'
		);

		~noteSamp3.free;
		~noteSamp3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=(-3);
				~tOSCAdrr.sendMsg('noteSampLabel', '-3');
			});
			},
			'/nt-3'
		);

		~noteSamp4.free;
		~noteSamp4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=(-4);
				~tOSCAdrr.sendMsg('noteSampLabel', '-4');
			});
			},
			'/nt-4'
		);

		~noteSamp5.free;
		~noteSamp5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=(-5);
				~tOSCAdrr.sendMsg('noteSampLabel', '-5');
			});
			},
			'/nt-5'
		);

		~noteSamp6.free;
		~noteSamp6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=(-6);
				~tOSCAdrr.sendMsg('noteSampLabel', '-6');
			});
			},
			'/nt-6'
		);

		~noteSamp7.free;
		~noteSamp7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=(-7);
				~tOSCAdrr.sendMsg('noteSampLabel', '-7');
			});
			},
			'/nt-7'
		);

		~noteSamp8.free;
		~noteSamp8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=(-8);
				~tOSCAdrr.sendMsg('noteSampLabel', '-8');
			});
			},
			'/nt-8'
		);

		~noteSamp9.free;
		~noteSamp9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=(-9);
				~tOSCAdrr.sendMsg('noteSampLabel', '-9');
			});
			},
			'/nt-9'
		);

		~noteSamp10.free;
		~noteSamp10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=(-10);
				~tOSCAdrr.sendMsg('noteSampLabel', '-10');
			});
			},
			'/nt-10'
		);

		~noteSamp11.free;
		~noteSamp11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=(-11);
				~tOSCAdrr.sendMsg('noteSampLabel', '-11');
			});
			},
			'/nt-11'
		);

		~noteSamp12.free;
		~noteSamp12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=(-12);
				~tOSCAdrr.sendMsg('noteSampLabel', '-12');
			});
			},
			'/nt-12'
		);

		~noteSamp13.free;
		~noteSamp13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=(-13);
				~tOSCAdrr.sendMsg('noteSampLabel', '-13');
			});
			},
			'/nt-13'
		);

		~noteSamp14.free;
		~noteSamp14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transSamp.source=(-14);
				~tOSCAdrr.sendMsg('noteSampLabel', '-14');
			});
			},
			'/nt-14'
		);



	}

	*noteSampOff {

		~noteBass_0.free;

		~noteSamp_1.free;
		~noteSamp_2.free;
		~noteSamp_3.free;
		~noteSamp_4.free;
		~noteSamp_5.free;
		~noteSamp_6.free;
		~noteSamp_7.free;
		~noteSamp_8.free;
		~noteSamp_9.free;
		~noteSamp_10.free;
		~noteSamp_11.free;
		~noteSamp_12.free;
		~noteSamp_13.free;
		~noteSamp_14.free;

		~noteSamp1.free;
		~noteSamp2.free;
		~noteSamp3.free;
		~noteSamp4.free;
		~noteSamp5.free;
		~noteSamp6.free;
		~noteSamp7.free;
		~noteSamp8.free;
		~noteSamp9.free;
		~noteSamp10.free;
		~noteSamp11.free;
		~noteSamp12.free;
		~noteSamp13.free;
		~noteSamp14.free;

	}



}