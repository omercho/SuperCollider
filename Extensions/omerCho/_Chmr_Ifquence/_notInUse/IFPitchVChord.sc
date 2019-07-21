/*
~rootMD=(28).degreeToKey(~scl2);

~vKeys.allNotesOff(0);
~ntMD=(-0);
~mdnt1=~rootMD+~ntMD;
~mdnt2=~mdnt1+5;
~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);



~vKeys.noteOff(0,~mdnt1,127);~vKeys.noteOff(0,~mdnt2,127);

~noteVChord_0.free;
~noteVChord_0 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"VChord NOTE 0".postln;
		~vKeys.allNotesOff(0);
		~ntMD=(-0);
		~mdnt1=~rootMD+~ntMD;
		~mdnt2=~mdnt1-4;
		~vKeys.noteOn(0,~mdnt1,127);~vKeys.noteOn(0,~mdnt2,121);
		~tOSCAdrr.sendMsg('noteVChordLabel', '0');
	});
	},
	'/nt_0'
);


IFPitchVChord.loadAll;
*/

IFPitchVChord {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
			1.0.wait;
			this.noteVChord;

			});*/
		}
	}

	*loadAll {

		this.globals;
		this.buttons;
		this.noteVChordOn;
		this.noteVChordOff;

	}
	*globals {
		~scl2= Scale.phrygian;
		~rootChord=28;
		~rootMD=(~rootChord).degreeToKey(~scl2);
		~ntMD=(-0);
		~scndMD=(6);
		~mdnt1=~rootMD+~ntMD;
		~mdnt2=~mdnt1+~scndMD;
		~mdntVel1=117*0.8;
		~mdntVel2=110*0.8;

	}
	*buttons {

		~pitchVChordBut.free;
		~countPVChord=0;
		~pitchVChordBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countPVChord = ~countPVChord + 1;

				~countPVChord.switch(
					0,{
						"PITCHVChord SWITCH 0".postln;
					},
					1, {

						"PITCHVChord SWITCH ON".postln;
						~tOSCAdrr.sendMsg('pitchVChord', 1);
						IFPitchVChord.noteVChordOn;
						~apcMn.noteOn(~apcMnCh, 87, 1); //But 5
					},
					2,{

						"PITCHVChord SWITCH OFF".postln;
						~tOSCAdrr.sendMsg('pitchVChord', 0);
						~countPVChord=0;
						IFPitchVChord.noteVChordOff;
						~apcMn.noteOn(~apcMnCh, 87, 0); //But 5
					}
				)
				},{
					// else

				}
			);
			},
			'/pitchVChord'
		);

		~killVChordBut.free;
		~killVChordBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);

			});
			},
			'/killAll'
		);
		//APC Pitch Samp Button
		~countPVChordApc=0;
		~apcPVChordButton.free;
		~apcPVChordButton=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~countPVChordApc = ~countPVChordApc + 1;
				~countPVChordApc.switch(
					0,{},
					1, {
						~local.sendMsg('pitchVChord', 1);
					},
					2,{
						~local.sendMsg('pitchVChord', 0);
						~vKeys.allNotesOff(0);
						~countPVChordApc=0;
					}
				)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:87);

	}

	*noteVChordOn {

		/////////////////////----- Note -------//////////////


		~noteVChord_0.free;
		~noteVChord_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-0);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '0');
			});
			},
			'/nt_0'
		);

		~noteVChord_1.free;
		~noteVChord_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(1);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '1');
			});
			},
			'/nt_1'
		);


		~noteVChord_2.free;
		~noteVChord_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(2);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '2');
			});
			},
			'/nt_2'
		);

		~noteVChord_3.free;
		~noteVChord_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(3);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '3');
			});
			},
			'/nt_3'
		);

		~noteVChord_4.free;
		~noteVChord_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(4);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '4');
			});
			},
			'/nt_4'
		);

		~noteVChord_5.free;
		~noteVChord_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(5);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '5');
			});
			},
			'/nt_5'
		);

		~noteVChord_6.free;
		~noteVChord_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(6);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '6');
			});
			},
			'/nt_6'
		);

		~noteVChord_7.free;
		~noteVChord_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(7);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '7');
			});
			},
			'/nt_7'
		);

		~noteVChord_8.free;
		~noteVChord_8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(8);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '8');
			});
			},
			'/nt_8'
		);

		~noteVChord_9.free;
		~noteVChord_9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(9);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '9');
			});
			},
			'/nt_9'
		);

		~noteVChord_10.free;
		~noteVChord_10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(10);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '10');
			});
			},
			'/nt_10'
		);

		~noteVChord_11.free;
		~noteVChord_11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(11);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '11');
			});
			},
			'/nt_11'
		);

		~noteVChord_12.free;
		~noteVChord_12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(12);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '12');
			});
			},
			'/nt_12'
		);

		~noteVChord_13.free;
		~noteVChord_13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(13);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '13');
			});
			},
			'/nt_13'
		);

		~noteVChord_14.free;
		~noteVChord_14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(14);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '14');
			});
			},
			'/nt_14'
		);

		//////////////////////////// NEGATIVE
		~noteVChord1.free;
		~noteVChord1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-1);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '-1');
			});
			},
			'/nt-1'
		);


		~noteVChord2.free;
		~noteVChord2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-2);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '-2');
			});
			},
			'/nt-2'
		);

		~noteVChord3.free;
		~noteVChord3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-3);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '-3');
			});
			},
			'/nt-3'
		);

		~noteVChord4.free;
		~noteVChord4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-4);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '-4');
			});
			},
			'/nt-4'
		);

		~noteVChord5.free;
		~noteVChord5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-5);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '-5');
			});
			},
			'/nt-5'
		);

		~noteVChord6.free;
		~noteVChord6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-6);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '-6');
			});
			},
			'/nt-6'
		);

		~noteVChord7.free;
		~noteVChord7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-7);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '-7');
			});
			},
			'/nt-7'
		);

		~noteVChord8.free;
		~noteVChord8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-8);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '-8');
			});
			},
			'/nt-8'
		);

		~noteVChord9.free;
		~noteVChord9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-9);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '-9');
			});
			},
			'/nt-9'
		);

		~noteVChord10.free;
		~noteVChord10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-10);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '-10');
			});
			},
			'/nt-10'
		);

		~noteVChord11.free;
		~noteVChord11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-11);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '-11');
			});
			},
			'/nt-11'
		);

		~noteVChord12.free;
		~noteVChord12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-12);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '-12');
			});
			},
			'/nt-12'
		);

		~noteVChord13.free;
		~noteVChord13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-13);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '-13');
			});
			},
			'/nt-13'
		);

		~noteVChord14.free;
		~noteVChord14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~vKeys.allNotesOff(0);
				~rootMD=(~rootChord).degreeToKey(~scl2);
				~ntMD=(-14);
				~mdnt1=~rootMD+~ntMD;
				~mdnt2=~mdnt1+~scndMD;
				~vKeys.noteOn(0,~mdnt1,~mdntVel1);~vKeys.noteOn(0,~mdnt2,~mdntVel2);
				~tOSCAdrr.sendMsg('noteVChordLabel', '-14');
			});
			},
			'/nt-14'
		);



	}

	*noteVChordOff {
		//~vKeys.allNotesOff(0);

		~noteVChord_0.free;

		~noteVChord_1.free;
		~noteVChord_2.free;
		~noteVChord_3.free;
		~noteVChord_4.free;
		~noteVChord_5.free;
		~noteVChord_6.free;
		~noteVChord_7.free;
		~noteVChord_8.free;
		~noteVChord_9.free;
		~noteVChord_10.free;
		~noteVChord_11.free;
		~noteVChord_12.free;
		~noteVChord_13.free;
		~noteVChord_14.free;

		~noteVChord1.free;
		~noteVChord2.free;
		~noteVChord3.free;
		~noteVChord4.free;
		~noteVChord5.free;
		~noteVChord6.free;
		~noteVChord7.free;
		~noteVChord8.free;
		~noteVChord9.free;
		~noteVChord10.free;
		~noteVChord11.free;
		~noteVChord12.free;
		~noteVChord13.free;
		~noteVChord14.free;

	}



}