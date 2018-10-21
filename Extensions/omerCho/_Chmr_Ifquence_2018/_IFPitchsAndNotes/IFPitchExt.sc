/*
 IFPitchExt.loadAll;
*/

IFPitchExt {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
				1.0.wait;
				this.noteExt;

			});*/
		}
	}

	*loadAll {

		this.buttons;
		this.noteExtOn;
		this.noteExtOff;

	}

	*buttons {

		~pitchExtBut.free;
		~countPExt=0;
		~pitchExtBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countPExt = ~countPExt + 1;

				~countPExt.switch(
					0,{
						"PITCHExt SWITCH 0".postln;
					},
					1, {

						"PITCHExt SWITCH ON".postln;
						~tOSCAdrr.sendMsg('pitchExt', 1);
						IFPitchExt.noteExtOn;
						~apcMn.noteOn(~apcMnCh, 86, 1); //But 8


					},
					2,{

						"PITCHExt SWITCH OFF".postln;
						~tOSCAdrr.sendMsg('pitchExt', 0);
						~countPExt=0;
						IFPitchExt.noteExtOff;
						~apcMn.noteOn(~apcMnCh, 86, 0); //But 8
					}
				)
				},{
					// else

				}
			);
			},
			'/pitchExt'
		);

		//APC Pitch Ext Button
		~countPExtApc=0;
		~apcPExtButton.free;
		~apcPExtButton=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~countPExtApc = ~countPExtApc + 1;
				~countPExtApc.switch(
					0,{},
					1,{~local.sendMsg('pitchExt', 1);},
					2,{~local.sendMsg('pitchExt', 1);~countPExtApc=0;}
				)});

		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:86);

	}

	*noteExtOn {

		/////////////////////----- Note -------//////////////


		~noteExt_0.free;
		~noteExt_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~transExt.source=0;
				~tOSCAdrr.sendMsg('noteExtLabel', '0');
			});
			},
			'/nt_0'
		);

		~noteExt_1.free;
		~noteExt_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=1;
				~tOSCAdrr.sendMsg('noteExtLabel', '1');
			});
			},
			'/nt_1'
		);


		~noteExt_2.free;
		~noteExt_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=2;
				~tOSCAdrr.sendMsg('noteExtLabel', '2');
			});
			},
			'/nt_2'
		);

		~noteExt_3.free;
		~noteExt_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=3;
				~tOSCAdrr.sendMsg('noteExtLabel', '3');
			});
			},
			'/nt_3'
		);

		~noteExt_4.free;
		~noteExt_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=4;
				~tOSCAdrr.sendMsg('noteExtLabel', '4');
			});
			},
			'/nt_4'
		);

		~noteExt_5.free;
		~noteExt_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=5;
				~tOSCAdrr.sendMsg('noteExtLabel', '5');
			});
			},
			'/nt_5'
		);

		~noteExt_6.free;
		~noteExt_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=6;
				~tOSCAdrr.sendMsg('noteExtLabel', '6');
			});
			},
			'/nt_6'
		);

		~noteExt_7.free;
		~noteExt_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=7;
				~tOSCAdrr.sendMsg('noteExtLabel', '7');
			});
			},
			'/nt_7'
		);

		~noteExt_8.free;
		~noteExt_8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=8;
				~tOSCAdrr.sendMsg('noteExtLabel', '8');
			});
			},
			'/nt_8'
		);

		~noteExt_9.free;
		~noteExt_9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=9;
				~tOSCAdrr.sendMsg('noteExtLabel', '9');
			});
			},
			'/nt_9'
		);

		~noteExt_10.free;
		~noteExt_10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=10;
				~tOSCAdrr.sendMsg('noteExtLabel', '10');
			});
			},
			'/nt_10'
		);

		~noteExt_11.free;
		~noteExt_11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=11;
				~tOSCAdrr.sendMsg('noteExtLabel', '11');
			});
			},
			'/nt_11'
		);

		~noteExt_12.free;
		~noteExt_12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=12;
				~tOSCAdrr.sendMsg('noteExtLabel', '12');
			});
			},
			'/nt_12'
		);

		~noteExt_13.free;
		~noteExt_13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=13;
				~tOSCAdrr.sendMsg('noteExtLabel', '13');
			});
			},
			'/nt_13'
		);

		~noteExt_14.free;
		~noteExt_14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=14;
				~tOSCAdrr.sendMsg('noteExtLabel', '14');
			});
			},
			'/nt_14'
		);

		//////////////////////////// NEGATIVE
		~noteExt1.free;
		~noteExt1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=(-1);
				~tOSCAdrr.sendMsg('noteExtLabel', '-1');
			});
			},
			'/nt-1'
		);


		~noteExt2.free;
		~noteExt2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=(-2);
				~tOSCAdrr.sendMsg('noteExtLabel', '-2');
			});
			},
			'/nt-2'
		);

		~noteExt3.free;
		~noteExt3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=(-3);
				~tOSCAdrr.sendMsg('noteExtLabel', '-3');
			});
			},
			'/nt-3'
		);

		~noteExt4.free;
		~noteExt4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=(-4);
				~tOSCAdrr.sendMsg('noteExtLabel', '-4');
			});
			},
			'/nt-4'
		);

		~noteExt5.free;
		~noteExt5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=(-5);
				~tOSCAdrr.sendMsg('noteExtLabel', '-5');
			});
			},
			'/nt-5'
		);

		~noteExt6.free;
		~noteExt6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=(-6);
				~tOSCAdrr.sendMsg('noteExtLabel', '-6');
			});
			},
			'/nt-6'
		);

		~noteExt7.free;
		~noteExt7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=(-7);
				~tOSCAdrr.sendMsg('noteExtLabel', '-7');
			});
			},
			'/nt-7'
		);

		~noteExt8.free;
		~noteExt8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=(-8);
				~tOSCAdrr.sendMsg('noteExtLabel', '-8');
			});
			},
			'/nt-8'
		);

		~noteExt9.free;
		~noteExt9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=(-9);
				~tOSCAdrr.sendMsg('noteExtLabel', '-9');
			});
			},
			'/nt-9'
		);

		~noteExt10.free;
		~noteExt10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=(-10);
				~tOSCAdrr.sendMsg('noteExtLabel', '-10');
			});
			},
			'/nt-10'
		);

		~noteExt11.free;
		~noteExt11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=(-11);
				~tOSCAdrr.sendMsg('noteExtLabel', '-11');
			});
			},
			'/nt-11'
		);

		~noteExt12.free;
		~noteExt12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=(-12);
				~tOSCAdrr.sendMsg('noteExtLabel', '-12');
			});
			},
			'/nt-12'
		);

		~noteExt13.free;
		~noteExt13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=(-13);
				~tOSCAdrr.sendMsg('noteExtLabel', '-13');
			});
			},
			'/nt-13'
		);

		~noteExt14.free;
		~noteExt14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~transExt.source=(-14);
				~tOSCAdrr.sendMsg('noteExtLabel', '-14');
			});
			},
			'/nt-14'
		);



	}

	*noteExtOff {

		~noteExt_0.free;

		~noteExt_1.free;
		~noteExt_2.free;
		~noteExt_3.free;
		~noteExt_4.free;
		~noteExt_5.free;
		~noteExt_6.free;
		~noteExt_7.free;
		~noteExt_8.free;
		~noteExt_9.free;
		~noteExt_10.free;
		~noteExt_11.free;
		~noteExt_12.free;
		~noteExt_13.free;
		~noteExt_14.free;

		~noteExt1.free;
		~noteExt2.free;
		~noteExt3.free;
		~noteExt4.free;
		~noteExt5.free;
		~noteExt6.free;
		~noteExt7.free;
		~noteExt8.free;
		~noteExt9.free;
		~noteExt10.free;
		~noteExt11.free;
		~noteExt12.free;
		~noteExt13.free;
		~noteExt14.free;

	}



}