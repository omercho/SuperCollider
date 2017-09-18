/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;


IFAPC40.loadSource;
IFAPC40.resetLeds;
IFAPC40.globalMode(1);
IFAPC40.nobDown(mode:1);
IFAPC40.update;



*/

/*
//to find the srcID of MIDIOut sources
~mdOut.uid;
~mdTouch.uid;
~apc40.uid;

//to find MIDIIn src
(
c = NoteOnResponder({ |src,chan,note,vel|
        [src,chan,note,vel].postln;
    });
    c.learn; // wait for the first note
)
NoteOnResponder.removeAll
*/

IFAPC40{
	*load{

		~apc40 = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST3 APCMn");
		~apc40OutID=(-2027289954);
		~apc40InID=(-1298760971);
		this.globals;
		//this.globalMode(1);
		//this.cueNob;
		this.resetLeds;
		this.shiftButton;
		this.psrButtonsPlay;

		//IFAPC40_NobDown.load;
		//IFAPC40_NobUp.load;
		IFAPC40_Launch.load;

	}//loadAtStart


	*globals{
		//channels
		~apcLn1=0;
		~apcLn2=1;
		~apcLn3=2;
		~apcLn4=3;
		~apcLn5=4;
		~apcLn6=5;
		~apcLn7=6;
		~apcLn8=7;
		~apcLnMaster=0;
		//Nums
		~actButA1=0;~actButB1=8;~actButC1=16;
		~actButA2=1;~actButB2=9;~actButC2=17;
		~actButA3=2;~actButB3=10;~actButC3=18;
		~actButA4=3;~actButB4=11;~actButC4=19;
		~actButA5=4;~actButB5=12;~actButC5=20;
		~actButA6=5;~actButB6=13;~actButC6=21;
		~actButA7=6;~actButB7=14;~actButC7=22;
		~actButA8=7;~actButB8=15;~actButC8=23;

		~tsBut1=64;~tsBut2=65;~tsBut3=66;~tsBut4=67;
		~tsBut5=68;~tsBut6=69;~tsBut7=70;~tsBut8=71;
		~apcPlayBut=82;

		~apcStopBut=92;
		~apcRecBut=93;
		~apcBankUpBut=94;
		~apcBankDownBut=95;
		~apcBankRightBut=96;
		~apcBankLeftBut=97;
		~apcPlusBut=100;
		~apcMinusBut=101;



	}//globals
	*shiftButton{
		//~apc40.noteOn(0, 98, 127); //SHIFT
		~trackCase=0;
		~partCase=0;
		~apc40ShiftBut.free;
		~apc40ShiftBut=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				IFAPC40.tracks;
				~trackCase.switch(
					0,{
						//IFAPC40.tsLeds(0,0,0,0,0,0,0,0);
					},
					1, {
						//IFTrack01.apcParts;
						IFAPC40.tsLeds(1,0,0,0,0,0,0,0);
					},
					2,{
						//IFTrack02.apcParts;
						IFAPC40.tsLeds(0,1,0,0,0,0,0,0);
					},
					3,{
						//IFTrack03.apcParts;
						IFAPC40.tsLeds(0,0,1,0,0,0,0,0);
					}
				);
			});
		},srcID:~apc40InID, chan:0, noteNum:98);
		~apc40ShiftButOff.free;
		~apc40ShiftButOff=MIDIFunc.noteOff({
			arg vel;
			if ( vel==127, {
				IFAPC40.tracks;
				~partCase.switch(
					0,{IFAPC40.tsLeds(0,0,0,0,0,0,0,0);},
					1,{IFAPC40.tsLeds(1,0,0,0,0,0,0,0);},
					2,{IFAPC40.tsLeds(0,1,0,0,0,0,0,0);},
					3,{IFAPC40.tsLeds(0,0,1,0,0,0,0,0);},
					4,{IFAPC40.tsLeds(0,0,0,1,0,0,0,0);},
					5,{IFAPC40.tsLeds(0,0,0,0,1,0,0,0);},
					6,{IFAPC40.tsLeds(0,0,0,0,0,1,0,0);},
					7,{IFAPC40.tsLeds(0,0,0,0,0,0,1,0);},
					8,{IFAPC40.tsLeds(0,0,0,0,0,0,0,1);}
				);
				~trackCase.switch(
					0,{IFAPC40.tsLeds(0,0,0,0,0,0,0,0);},
					1,{IFTrack01.apcParts;},
					2,{IFTrack02.apcParts;},
					3,{IFTrack03.apcParts;}
				);
			});
		},srcID:~apc40InID, chan:0, noteNum:98);

	}



	//PLAY STOP REC Buttons
	*psrButtonsPlay{
		//Kick Activate
		~cntPlayBut=0;
		~apcPlayButton.free;
		~apcPlayButton=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntPlayBut = ~cntPlayBut + 1;
				~cntPlayBut.switch(
					0,{},
					1, {
						~local.sendMsg('/1/toggleMain', 1);
						~local.sendMsg('nt_0', 1);
						IFAPC40_Launch.noteButsReset;
						~apc40.noteOn(~apcLn4, 55, 4); //But 1
					},
					2,{
						~local.sendMsg('/1/toggleMain', 0);
						~cntPlayBut=0;
						IFAPC40_Launch.noteButsReset;
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn1, noteNum:~apcPlayBut);
	}

	//Activate Buttons Methods

	*act{|chan,val1,val2,val3|
		~apc40.noteOn(chan, ~actButA, val1); //But A
		~apc40.noteOn(chan, ~actButB, val2); //But B
		~apc40.noteOn(chan, ~actButC, val3); //But C

	}
	//actLine1
	*actLine1{|val1,val2,val3|
		this.actLine1ButA(val1);
		this.actLine1ButB(val2);
		this.actLine1ButC(val3);
	}
	*actLine1ButA{|val|
		~apc40.noteOn(~apcLn1, ~actButA1, val); //But A
		~tOSCAdrr.sendMsg('activKick', val);
		~actKick.source=val;
		~cntActLine1ButA=val;
	}

	//actLine2
	*actLine2{|val1,val2,val3|
		this.actLine2ButA(val1);
		this.actLine2ButB(val2);
		this.actLine2ButC(val3);
	}
	*actLine2ButA{|val|
		~apc40.noteOn(~apcLn1, ~actButA2, val); //But A
		~tOSCAdrr.sendMsg('activSnr', val);
		~actSnr.source=val;
		~cntActLine2ButA=val;
	}


	//actLine3
	*actLine3{|val1,val2,val3|
		this.actLine3ButA(val1);
		this.actLine3ButB(val2);
		this.actLine3ButC(val3);
	}
	*actLine3ButA{|val|
		~apc40.noteOn(~apcLn1, ~actButA3, val); //But A
		~tOSCAdrr.sendMsg('activHat', val);
		~actHat.source=val;
		~cntActLine3ButA=val;
	}

	//actLine4
	*actLine4{|val1,val2,val3|
		this.actLine4ButA(val1);
		this.actLine4ButB(val2);
		this.actLine4ButC(val3);
	}
	*actLine4ButA{|val|
		~apc40.noteOn(~apcLn1, ~actButA4, val); //But A
		~tOSCAdrr.sendMsg('activBass', val);
		~actBass.source=val;
		~cntActLine4ButA=val;
	}

	//actLine5 -- Keys
	*actLine5{|val1,val2,val3|
		this.actLine5ButA(val1);
		this.actLine5ButB(val2);
		this.actLine5ButC(val3);
	}
	*actLine5ButA{|val|
		~apc40.noteOn(~apcLn1, ~actButA5, val); //But A
		~tOSCAdrr.sendMsg('activKeys', val);
		~actKeys.source=val;
		~cntActLine5ButA=val;
	}

	//actLine6 --Samp
	*actLine6{|val1,val2,val3|
		this.actLine6ButA(val1);
		this.actLine6ButB(val2);
		this.actLine6ButC(val3);
	}
	*actLine6ButA{|val|
		~apc40.noteOn(~apcLn1, ~actButA6, val); //But A
		~tOSCAdrr.sendMsg('activSamp', val);
		~actSamp.source=val;
		~cntActLine6ButA=val;
	}

	//actLine7 -- Mast
	*actLine7{|val1,val2,val3|
		this.actLine7ButA(val1);
		this.actLine7ButB(val2);
		this.actLine7ButC(val3);
	}
	*actLine7ButA{|val|
		~apc40.noteOn(~apcLn1, ~actButA7, val); //But A
		~tOSCAdrr.sendMsg('activMast', val);
		~actMast.source=val;
		~cntActLine7ButA=val;
	}

	//actLine8 -- Res1
	*actLine8{|val1,val2,val3|
		this.actLine8ButA(val1);
		this.actLine8ButB(val2);
		this.actLine8ButC(val3);
	}
	*actLine8ButA{|val|
		~apc40.noteOn(~apcLn1, ~actButA8, val); //But A
		~tOSCAdrr.sendMsg('activRes', val);
		~actRes.source=val;
		~cntActLine8ButA=val;
	}

	//////////////////B_B
	*actLine1ButB{|val|
		~apc40.noteOn(~apcLn1, ~actButB1, val); //But B
		~local.sendMsg('time2Kick', 1);
		//~tmMulKick.source = Pseq([val+1], inf);
		~cntActLine1ButB=val;
	}
	*actLine2ButB{|val|
		~apc40.noteOn(~apcLn1, ~actButB2, val); //But B
		~local.sendMsg('time2Snr', val);
		//~tmMulSnr.source = Pseq([val+1], inf);
		~cntActLine2ButB=val;
	}
	*actLine3ButB{|val|
		~apc40.noteOn(~apcLn1, ~actButB3, val); //But B
		~local.sendMsg('time2Hat', val);
		//~tmMulHat.source = Pseq([val+1], inf);
		~cntActLine3ButB=val;
	}
	*actLine4ButB{|val|
		~apc40.noteOn(~apcLn1, ~actButB4, val); //But B
		~local.sendMsg('time2Bass', val);
		//~tmMulBass.source = Pseq([val+1], inf);
		~cntActLine4ButB=val;
	}
	*actLine5ButB{|val|
		~apc40.noteOn(~apcLn1, ~actButB5, val); //But B
		~local.sendMsg('time2Keys', val);
		//~tmMulKeys.source = Pseq([val+1], inf);
		~cntActLine5ButB=val;
	}
	*actLine6ButB{|val|
		~apc40.noteOn(~apcLn1, ~actButB6, val); //But B
		~local.sendMsg('time2Samp', val);
		//~tmMulSamp.source = Pseq([val+1], inf);
		~cntActLine6ButB=val;
	}
	*actLine7ButB{|val|
		~apc40.noteOn(~apcLn1, ~actButB7, val); //But B
		~tOSCAdrr.sendMsg('time2Mast', val);
		~tmMulMast.source = Pseq([val+1], inf);
		~cntActLine7ButB=val;
	}
	*actLine8ButB{|val|
		~apc40.noteOn(~apcLn1, ~actButB8, val); //But B
		~tOSCAdrr.sendMsg('time2Res', val);
		~tmMulRes.source = Pseq([val+1], inf);
		~cntActLine8ButB=val;
	}

	/////////B_C
	*actLine1ButC{|val|
		~apc40.noteOn(~apcLn1, ~actButC1, val); //But C
		~tOSCAdrr.sendMsg('activStKick', val);
		~actStKick.source=val;
		~cntActLine1ButC=val;
	}
	*actLine2ButC{|val|
		~apc40.noteOn(~apcLn1, ~actButC2, val); //But C
		~tOSCAdrr.sendMsg('activStSnr', val);
		~actStSnr.source=val;
		~cntActLine2ButC=val;
	}
	*actLine3ButC{|val|
		~apc40.noteOn(~apcLn1, ~actButC3, val); //But C
		~tOSCAdrr.sendMsg('activStHat', val);
		~actStHat.source=val;
		~cntActLine3ButC=val;
	}
	*actLine4ButC{|val|
		~apc40.noteOn(~apcLn1, ~actButC4, val); //But C
		~tOSCAdrr.sendMsg('activStBass', val);
		~actStBass.source=val;
		~cntActLine4ButC=val;
	}
	*actLine5ButC{|val|
		~apc40.noteOn(~apcLn1, ~actButC5, val); //But C
		~tOSCAdrr.sendMsg('activStKeys', val);
		~actStKeys.source=val;
		~cntActLine5ButC=val;
	}
	*actLine6ButC{|val|
		~apc40.noteOn(~apcLn1, ~actButC6, val); //But C
		~tOSCAdrr.sendMsg('activStSamp', val);
		~actStSamp.source=val;
		~cntActLine6ButC=val;
	}
	*actLine7ButC{|val|
		~apc40.noteOn(~apcLn1, ~actButC7, val); //But C
		~tOSCAdrr.sendMsg('activStMast', val);
		//~actStHat.source=val;
		~cntActLine7ButC=val;
	}
	*actLine8ButC{|val|
		~apc40.noteOn(~apcLn1, ~actButC8, val); //But C
		~tOSCAdrr.sendMsg('activStRes', val);
		//~actStHat.source=val;
		~cntActLine8ButC=val;
	}

	*tracks{
		~apc_TS01.free;
		~apc_TS01=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack01.loadAtStart;
			});
		},srcID:~apc40InID, chan:0, noteNum:64);
		~apc_TS02.free;
		~apc_TS02=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack02.loadAtStart;
			});
		},srcID:~apc40InID, chan:0, noteNum:65);
		~apc_TS03.free;
		~apc_TS03=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack03.loadAtStart;
			});
		},srcID:~apc40InID, chan:0, noteNum:66);
		~apc_TS04.free;
		~apc_TS04=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:67);
		~apc_TS05.free;
		~apc_TS05=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:68);
		~apc_TS06.free;
		~apc_TS06=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:69);
		~apc_TS07.free;
		~apc_TS07=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:70);
		~apc_TS08.free;
		~apc_TS08=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:71);

	}//tracks

	*tsLed{|chan,led|
		~apc40.noteOn(chan, 51, led);
	}
	*tsLeds{|led1,led2,led3,led4,led5,led6,led7,led8|
		~apc40.noteOn(~apcLn1, ~tsBut1, led1); //But 1
		~apc40.noteOn(~apcLn1, ~tsBut2, led2); //But 2
		~apc40.noteOn(~apcLn1, ~tsBut3, led3); //But 3
		~apc40.noteOn(~apcLn1, ~tsBut4, led4); //But 4
		~apc40.noteOn(~apcLn1, ~tsBut5, led5); //But 5
		~apc40.noteOn(~apcLn1, ~tsBut6, led6); //But 6
		~apc40.noteOn(~apcLn1, ~tsBut7, led7); //But 7
		~apc40.noteOn(~apcLn1, ~tsBut8, led8); //But 8
	}

	*resetLeds{
		//Toggles Active - Times2 - Static
		~apc40.noteOn(0, 0, 0); //But 1
		~apc40.noteOn(0, 1, 0); //But 2
		~apc40.noteOn(0, 2, 0); //But 3
		~apc40.noteOn(0, 3, 0); //But 1
		~apc40.noteOn(0, 4, 0); //But 2
		~apc40.noteOn(0, 5, 0); //But 3
		~apc40.noteOn(0, 6, 0); //But 1
		~apc40.noteOn(0, 7, 0); //But 2
		~apc40.noteOn(0, 8, 0); //But 3
		~apc40.noteOn(0, 9, 0); //But 1
		~apc40.noteOn(0, 10, 0); //But 2
		~apc40.noteOn(0, 11, 0); //But 3
		~apc40.noteOn(0, 12, 0); //But 1
		~apc40.noteOn(0, 13, 0); //But 2
		~apc40.noteOn(0, 14, 0); //But 3
		~apc40.noteOn(0, 15, 0); //But 1
		~apc40.noteOn(0, 16, 0); //But 2
		~apc40.noteOn(0, 17, 0); //But 3
		~apc40.noteOn(0, 18, 0); //But 1
		~apc40.noteOn(0, 19, 0); //But 2
		~apc40.noteOn(0, 20, 0); //But 3
		~apc40.noteOn(0, 21, 0); //But 1
		~apc40.noteOn(0, 22, 0); //But 2
		~apc40.noteOn(0, 23, 0); //But 3
		//Track Selection Only One Function
		~apc40.noteOn(0, 64, 0); //But 1
		~apc40.noteOn(1, 65, 0); //But 2
		~apc40.noteOn(2, 66, 0); //But 3
		~apc40.noteOn(3, 67, 0); //But 4
		~apc40.noteOn(4, 68, 0); //But 5
		~apc40.noteOn(5, 69, 0); //But 6
		~apc40.noteOn(6, 70, 0); //But 7
		~apc40.noteOn(7, 71, 0); //But 8
		~apc40.noteOn(0, 72, 0); //But Master
		//ClipStop 2 Functions
		~apc40.noteOn(0, 52, 0); //But 1
		~apc40.noteOn(1, 52, 0); //But 2
		~apc40.noteOn(2, 52, 0); //But 3
		~apc40.noteOn(3, 52, 0); //But 4
		~apc40.noteOn(4, 52, 0); //But 5
		~apc40.noteOn(5, 52, 0); //But 6
		~apc40.noteOn(6, 52, 0); //But 7
		~apc40.noteOn(7, 52, 0); //But 8
		~apc40.noteOn(0, 81, 0); //But StopAll
		//Schene Launch Buttons
		~apc40.noteOn(~apcLn1, 82, 0); //But Scene 1
		~apc40.noteOn(~apcLn1, 83, 0); //But Scene 2
		~apc40.noteOn(~apcLn1, 84, 0); //But Scene 3
		~apc40.noteOn(~apcLn1, 85, 0); //But Scene 4
		~apc40.noteOn(~apcLn1, 86, 0); //But Scene 5
		~apc40.noteOn(~apcLn1, 87, 0); //But Scene 6
		~apc40.noteOn(~apcLn1, 88, 0); //But Scene 7
		~apc40.noteOn(~apcLn1, 89, 0); //But Scene 8

	}
}

/*

~apc40 = MIDIOut.newByName("Akai APC40", "Akai APC40");


~volHatFader.free;
~volHatFader= OSCFunc({
arg msg,vel;
vel=msg[1]*127;
~tOSCAdrr.sendMsg('volHat', msg[1]);
~mdOut.control(2, 1, vel);
},
'/volHat'
);

~volHat_APC.free;
~volHat_APC=MIDIFunc.cc( {
arg vel;
~tOSCAdrr.sendMsg('volHat', vel/127);
~mdOut.control(2, 1, vel);

}, chan:0, ccNum:7);

~countActHat_APC=0;
~actHatMD_APC.free;
~actHatMD_APC=MIDIFunc.noteOn({
arg vel;
if ( vel==127, {
~countActHat_APC = ~countActHat_APC + 1;
~countActHat_APC.switch(
0,{},
1, {
~actHat.source=1;
~tOSCAdrr.sendMsg('activHat', 1);
~apc40.noteOn(0, 48, 127);
},
2,{
~actHat.source=0;
~tOSCAdrr.sendMsg('activHat', 0);
~apc40.noteOff(0, 48, 127);
~countActHat_APC=0;
}
)}
);
}, chan:0, noteNum:48);

~countTime2Hat_APC=0;
~time2HatMD_APC.free;
~time2HatMD_APC=MIDIFunc.noteOn({
arg vel;
if ( vel==127, {
~countTime2Hat_APC = ~countTime2Hat_APC + 1;
~countTime2Hat_APC.switch(
0,{},
1, {
~apc40.noteOn(0, 49, 127);
~tOSCAdrr.sendMsg('time2Hat', 1);
~tOSCAdrr.sendMsg('tmHatLabel', 2);
~tmMulHat.source = Pseq([2], inf);
},
2,{
~apc40.noteOff(0, 49, 127);
~tOSCAdrr.sendMsg('time2Hat', 0);
~tOSCAdrr.sendMsg('tmHatLabel', 1);
~tmMulHat.source = Pseq([1], inf);
~countTime2Hat_APC=0;
}
)}
);
}, chan:0, noteNum:49);

~countHatBut3_APC=0;
~but3HatMD_APC.free;
~but3HatMD_APC=MIDIFunc.noteOn({
arg vel;
if ( vel==127, {
~countHatBut3_APC = ~countHatBut3_APC + 1;
~countHatBut3_APC.switch(
0,{},
1, {
~apc40.noteOn(0, 50, 127);

},
2,{
~apc40.noteOff(0, 50, 127);

~countHatBut3_APC=0;
}
)}
);
}, chan:0, noteNum:50);






(
~countActBass_APC=0;
~actBassMD_APC.free;
~actBassMD_APC=MIDIFunc.noteOn({
arg vel;
if ( vel==127, {
~countActBass_APC = ~countActBass_APC + 1;
~countActBass_APC.switch(
0,{},
1, {
~actBass.source=1;
~tOSCAdrr.sendMsg('activBass', 1);
~apc40.noteOn(3, 48, 127);
},
2,{
~actBass.source=0;
~tOSCAdrr.sendMsg('activBass', 0);
~apc40.noteOff(3, 48, 127);
~countActBass_APC=0;
}
)}
);
},48,3,~apc40InID);

)

~countActBass_APC=0;
~actBassMD_APC.remove;
~actBassMD_APC=NoteOnResponder({ |src,chan,note,vel|
[src,chan,note,vel].postln;

if ( vel==127, {
~countActBass_APC = ~countActBass_APC + 1;
~countActBass_APC.switch(
0,{},
1, {
~actBass.source=1;
~tOSCAdrr.sendMsg('activBass', 1);
~apc40.noteOn(3, 48, 127);
},
2,{
~actBass.source=0;
~tOSCAdrr.sendMsg('activBass', 0);
~apc40.noteOff(3, 48, 127);
~countActBass_APC=0;
}
)}
);

},1665708355,3,48,nil);


~apc40.uid;


~apc40.noteOn(0, 52, 0); //But 3

~apc40.sysex(Int8Array[
0xf0,
0x47,
0x00,
0x73,
0x60,
0x00,
0x04,
0x41,//40-41-42
09,
00,
05,
0xf7
]);


*cueNob{
		~cueLev_APC.free;
		~cueLev_APC=MIDIFunc.cc( {
			arg vel,led,val;
			val=0.01;
			vel.switch(
				127,{
					127.postln;
					~tOSCAdrr.sendMsg('/susDrum',~susDrumLedVal=~susDrumLedVal+val);
					~tOSCAdrr.sendMsg('/susMel', ~susMelLedVal=~susMelLedVal-val);
					~susMulKick=~susMulKick+val;
					~susMulSnr=~susMulSnr+val;
					~susMulHat=~susMulHat+val;
					~susMulBass=~susMulBass-val;
					~susMulKeys=~susMulKeys-val;
					~susMulSamp=~susMulSamp-val;
					~nobD4_m1Val=~nobD4_m1Val-val;
					~nobD8_m1Val=~nobD8_m1Val+val;

				},
				1,{

					1.postln;
					~tOSCAdrr.sendMsg('/susDrum',~susDrumLedVal=~susDrumLedVal-val);
					~tOSCAdrr.sendMsg('/susMel', ~susMelLedVal=~susMelLedVal+val);
					~susMulKick=~susMulKick-val;
					~susMulSnr=~susMulSnr-val;
					~susMulHat=~susMulHat-val;
					~susMulBass=~susMulBass+val;
					~susMulKeys=~susMulKeys+val;
					~susMulSamp=~susMulSamp+val;
					~nobD4_m1Val=~nobD4_m1Val+val;
					~nobD8_m1Val=~nobD8_m1Val-val;
				},
				126,{},
				125,{},
				2,{},
				3,{}
			);

		},srcID:~apc40InID, chan:0, ccNum:47);
	}


*globalMode{|case|
		case.switch(
			0,{
				/*~apc40.sysex(Int8Array[
					0xf0,
					0x47,
					0x00,
					0x73,
					0x60,
					0x00,
					0x04,
					0x40,//40-41-42
					09,
					00,
					05,
					0xf7
				]);*/
			},
			1,{
				/*~apc40.sysex(Int8Array[
					0xf0,
					0x47,
					0x00,
					0x73,
					0x60,
					0x00,
					0x04,
					0x41,//40-41-42
					09,
					00,
					05,
					0xf7
				]);*/
			},
			2,{
				/*~apc40.sysex(Int8Array[
					0xf0,
					0x47,
					0x00,
					0x73,
					0x60,
					0x00,
					0x04,
					0x42,//40-41-42
					09,
					00,
					05,
					0xf7
				]);*/
			}
		);
	}


*/