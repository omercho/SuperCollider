/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;


DJMini.loadSource;
DJMini.resetLeds;
DJMini.nobDown(mode:1);
DJMini.update;

4.ratiomidi

*/

/*
//to find the srcID of MIDIOut sources
~mdOut.uid;
~mdTouch.uid;
~djMn.uid;

//to find MIDIIn src
(
c = NoteOnResponder({ |src,chan,note,vel|
        [src,chan,note,vel].postln;
    });
    c.learn; // wait for the first note
)
NoteOnResponder.removeAll

DJMini.globals;
DJMini.resetLeds;
DJMini.shiftButton;
DJMini.psrButtonsPlay;
*/

DJMini{
	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({this.load; });
		}
	}
	*load{

		this.addr;
		this.globals;
		//this.globalMode(1);
		//this.cueNob;
		//this.resetLeds;
		this.shiftButton;
		this.psrButtonsPlay;

		//DJMini_NobDown.load;
		//DJMini_NobUp.load;

	}//loadAtStart

	*addr{

	}
	*globals{
		//channels
		~djMnMnCh=0;
		~djMnLn1=0;~djMnLn2=1;~djMnLn3=2;~djMnLn4=3;
		~djMnLn5=4;~djMnLn6=5;~djMnLn7=6;~djMnLn8=7;
		~djMnLnMaster=0;
		//Nums
		~djMnFd1=48;~djMnFd2=49;~djMnFd3=50;~djMnFd4=51;
		~djMnFd5=52;~djMnFd6=53;~djMnFd7=54;~djMnFd8=55;~djMnFd9=56;

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
		~djMnPlayBut=82;

		~djMnStopBut=92;
		~djMnRecBut=93;
		~djMnBankUpBut=94;
		~djMnBankDownBut=95;
		~djMnBankRightBut=96;
		~djMnBankLeftBut=97;
		~djMnPlusBut=100;
		~djMnMinusBut=101;



	}//globals
	*shiftButton{
		//~djMn.noteOn(0, 98, 127); //SHIFT
		~trackCase=0;
		~partCase=0;
		~djMnShiftBut.free;
		~djMnShiftBut=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				DJMini.tracks;
				~trackCase.switch(
					0,{
						//DJMini.tsLeds(0,0,0,0,0,0,0,0);
					},
					1, {
						//IFTrack01.apcParts;
						DJMini.tsLeds(1,0,0,0,0,0,0,0);
					},
					2,{
						//IFTrack02.apcParts;
						DJMini.tsLeds(0,1,0,0,0,0,0,0);
					},
					3,{
						//IFTrack03.apcParts;
						DJMini.tsLeds(0,0,1,0,0,0,0,0);
					}
				);
			});
		},srcID:~djMnInID, chan:0, noteNum:98);
		~djMnShiftButOff.free;
		~djMnShiftButOff=MIDIFunc.noteOff({
			arg vel;
			if ( vel==127, {
				DJMini.tracks;
				~partCase.switch(
					0,{DJMini.tsLeds(0,0,0,0,0,0,0,0);},
					1,{DJMini.tsLeds(1,0,0,0,0,0,0,0);},
					2,{DJMini.tsLeds(0,1,0,0,0,0,0,0);},
					3,{DJMini.tsLeds(0,0,1,0,0,0,0,0);},
					4,{DJMini.tsLeds(0,0,0,1,0,0,0,0);},
					5,{DJMini.tsLeds(0,0,0,0,1,0,0,0);},
					6,{DJMini.tsLeds(0,0,0,0,0,1,0,0);},
					7,{DJMini.tsLeds(0,0,0,0,0,0,1,0);},
					8,{DJMini.tsLeds(0,0,0,0,0,0,0,1);}
				);
				~trackCase.switch(
					0,{DJMini.tsLeds(0,0,0,0,0,0,0,0);},
					1,{IFTrack01.apcParts;},
					2,{IFTrack02.apcParts;},
					3,{IFTrack03.apcParts;}
				);
			});
		},srcID:~djMnInID, chan:0, noteNum:98);

	}



	//PLAY STOP REC Buttons
	*psrButtonsPlay{
		//Kick Activate
		~cntPlayBut=0;
		~djMnPlayButton.free;
		~djMnPlayButton=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntPlayBut = ~cntPlayBut + 1;
				~cntPlayBut.switch(
					0,{},
					1, {
						~local.sendMsg('/1/toggleMain', 1);
						~local.sendMsg('nt_0', 1);
						IFLpMnNotes.resetLeds;
						~djMn.noteOn(~djMnLn4, 55, 4); //But 1
					},
					2,{
						~local.sendMsg('/1/toggleMain', 0);
						~cntPlayBut=0;
						IFLpMnNotes.resetLeds;
					}
				)}
			);
		},srcID:~djMnInID, chan:~djMnLn1, noteNum:~djMnPlayBut);
	}

	//Activate Buttons Methods

	*act{|chan,val1,val2,val3|
		~djMn.noteOn(chan, ~actButA, val1); //But A
		~djMn.noteOn(chan, ~actButB, val2); //But B
		~djMn.noteOn(chan, ~actButC, val3); //But C

	}
	//actLine1
	*actLine1{|val1,val2,val3|
		this.actLine1ButA1(val1);
		this.actLine1ButB1(val2);
		this.actLine1ButC1(val3);
	}
	//actLine2
	*actLine2{|val1,val2,val3|
		this.actLine2ButA2(val1);
		this.actLine2ButB2(val2);
		this.actLine2ButC2(val3);
	}
	//actLine3
	*actLine3{|val1,val2,val3|
		this.actLine3ButA3(val1);
		this.actLine3ButB3(val2);
		this.actLine3ButC3(val3);
	}
	//actLine4
	*actLine4{|val1,val2,val3|
		this.actLine4ButA4(val1);
		this.actLine4ButB4(val2);
		this.actLine4ButC4(val3);
	}
	//actLine5 -- Keys
	*actLine5{|val1,val2,val3|
		this.actLine5ButA5(val1);
		this.actLine5ButB5(val2);
		this.actLine5ButC5(val3);
	}
	//actLine6 --Samp
	*actLine6{|val1,val2,val3|
		this.actLine6ButA6(val1);
		this.actLine6ButB6(val2);
		this.actLine6ButC6(val3);
	}
	//actLine7 -- Mast
	*actLine7{|val1,val2,val3|
		this.actLine7ButA7(val1);
		this.actLine7ButB7(val2);
		this.actLine7ButC7(val3);
	}
	//actLine8 -- Res1
	*actLine8{|val1,val2,val3|
		this.actLine8ButA8(val1);
		this.actLine8ButB8(val2);
		this.actLine8ButC8(val3);
	}
	//////////////////B_A
	*actLine1ButA1{|val|
		~djMn.noteOn(~djMnLn1, ~actButA1, val); //But A
		~tOSCAdrr.sendMsg('activKick', val);
		~actKick.source=val;
		~cntMnLine1ButA1=val;
	}
	*actLine2ButA2{|val|
		~djMn.noteOn(~djMnLn1, ~actButA2, val); //But A
		~tOSCAdrr.sendMsg('activSnr', val);
		~actSnr.source=val;
		~cntMnLine2ButA2=val;
	}
	*actLine3ButA3{|val|
		~djMn.noteOn(~djMnLn1, ~actButA3, val); //But A
		~tOSCAdrr.sendMsg('activHat', val);
		~actHat.source=val;
		~cntMnLine3ButA3=val;
	}
	*actLine4ButA4{|val|
		~djMn.noteOn(~djMnLn1, ~actButA4, val); //But A
		~tOSCAdrr.sendMsg('activBass', val);
		~actBass.source=val;
		~cntMnLine4ButA4=val;
	}
	*actLine5ButA5{|val|
		~djMn.noteOn(~djMnLn1, ~actButA5, val); //But A
		~tOSCAdrr.sendMsg('activKeys', val);
		~actKeys.source=val;
		~cntMnLine5ButA5=val;
	}
	*actLine6ButA6{|val|
		~djMn.noteOn(~djMnLn1, ~actButA6, val); //But A
		~tOSCAdrr.sendMsg('activSamp', val);
		~actSamp.source=val;
		~cntMnLine6ButA6=val;
	}
	*actLine7ButA7{|val|
		~djMn.noteOn(~djMnLn1, ~actButA7, val); //But A
		~tOSCAdrr.sendMsg('activMast', val);
		~actMast.source=val;
		~cntMnLine7ButA7=val;
	}
	*actLine8ButA8{|val|
		~djMn.noteOn(~djMnLn1, ~actButA8, val); //But A
		~tOSCAdrr.sendMsg('activRes', val);
		~actRes.source=val;
		~cntMnLine8ButA8=val;
	}
	//////////////////B_B
	*actLine1ButB1{|val|
		~djMn.noteOn(~djMnLn1, ~actButB1, val); //But B
		~local.sendMsg('time2Kick', val);
		//~tmMulKick.source = Pseq([val+1], inf);
		~cntMnLine1ButB1=val;
	}
	*actLine2ButB2{|val|
		~djMn.noteOn(~djMnLn1, ~actButB2, val); //But B
		~local.sendMsg('time2Snr', val);
		//~tmMulSnr.source = Pseq([val+1], inf);
		~cntMnLine2ButB2=val;
	}
	*actLine3ButB3{|val|
		~djMn.noteOn(~djMnLn1, ~actButB3, val); //But B
		~local.sendMsg('time2Hat', val);
		//~tmMulHat.source = Pseq([val+1], inf);
		~cntMnLine3ButB3=val;
	}
	*actLine4ButB4{|val|
		~djMn.noteOn(~djMnLn1, ~actButB4, val); //But B
		~local.sendMsg('time2Bass', val);
		//~tmMulBass.source = Pseq([val+1], inf);
		~cntMnLine4ButB4=val;
	}
	*actLine5ButB5{|val|
		~djMn.noteOn(~djMnLn1, ~actButB5, val); //But B
		~local.sendMsg('time2Keys', val);
		//~tmMulKeys.source = Pseq([val+1], inf);
		~cntMnLine5ButB5=val;
	}
	*actLine6ButB6{|val|
		~djMn.noteOn(~djMnLn1, ~actButB6, val); //But B
		~local.sendMsg('time2Samp', val);
		//~tmMulSamp.source = Pseq([val+1], inf);
		~cntMnLine6ButB6=val;
	}
	*actLine7ButB7{|val|
		~djMn.noteOn(~djMnLn1, ~actButB7, val); //But B
		~tOSCAdrr.sendMsg('time2Mast', val);
		~tmMulMast.source = Pseq([val+1], inf);
		~cntMnLine7ButB7=val;
	}
	*actLine8ButB8{|val|
		~djMn.noteOn(~djMnLn1, ~actButB8, val); //But B
		~tOSCAdrr.sendMsg('time2Res', val);
		~tmMulRes.source = Pseq([val+1], inf);
		~cntMnLine8ButB8=val;
	}

	/////////B_C
	*actLine1ButC1{|val|
		~djMn.noteOn(~djMnLn1, ~actButC1, val+5); //But C
		~tOSCAdrr.sendMsg('shufKick', val);
		~actKickLfo1.source=val;
		~cntMnLine1ButC1=val;
	}
	*actLine2ButC2{|val|
		~djMn.noteOn(~djMnLn1, ~actButC2, val+5); //But C
		~tOSCAdrr.sendMsg('shufSnr', val);
		~actSnrLfo1.source=val;
		~cntMnLine2ButC2=val;
	}
	*actLine3ButC3{|val|
		~djMn.noteOn(~djMnLn1, ~actButC3, val+5); //But C
		~tOSCAdrr.sendMsg('shufHat', val);
		~actHatLfo1.source=val;
		~cntMnLine3ButC3=val;
	}
	*actLine4ButC4{|val|
		~djMn.noteOn(~djMnLn1, ~actButC4, val+5); //But C
		~tOSCAdrr.sendMsg('shufBass', val);
		~local.sendMsg('shufBass', val);
		~cntMnLine4ButC4=val;
	}
	*actLine5ButC5{|val|
		~djMn.noteOn(~djMnLn1, ~actButC5, val+5); //But C
		~tOSCAdrr.sendMsg('shufKeys', val);
		~local.sendMsg('shufKeys', val);
		~cntMnLine5ButC5=val;
	}
	*actLine6ButC6{|val|
		~djMn.noteOn(~djMnLn1, ~actButC6, val+5); //But C
		~tOSCAdrr.sendMsg('shufSamp', val);
		~local.sendMsg('shufSamp', val);
		~cntMnLine6ButC6=val;
	}
	*actLine7ButC7{|val|
		~djMn.noteOn(~djMnLn1, ~actButC7, val+5); //But C
		//~tOSCAdrr.sendMsg('shufDrumHarm', val);
		//~actStHat.source=val;
		~cntMnLine7ButC7=val;
	}
	*actLine8ButC8{|val|
		~djMn.noteOn(~djMnLn1, ~actButC8, val); //But C
		//~tOSCAdrr.sendMsg('shufMelHarm', val);
		//~actStHat.source=val;
		~cntMnLine8ButC8=val;
	}

	*tracks{
		~djMn_TS01.free;
		~djMn_TS01=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack01.loadAtStart;
			});
		},srcID:~djMnInID, chan:0, noteNum:64);
		~djMn_TS02.free;
		~djMn_TS02=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack02.loadAtStart;
			});
		},srcID:~djMnInID, chan:0, noteNum:65);
		~djMn_TS03.free;
		~djMn_TS03=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack03.loadAtStart;
			});
		},srcID:~djMnInID, chan:0, noteNum:66);
		~djMn_TS04.free;
		~djMn_TS04=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~djMnInID, chan:0, noteNum:67);
		~djMn_TS05.free;
		~djMn_TS05=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~djMnInID, chan:0, noteNum:68);
		~djMn_TS06.free;
		~djMn_TS06=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~djMnInID, chan:0, noteNum:69);
		~djMn_TS07.free;
		~djMn_TS07=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~djMnInID, chan:0, noteNum:70);
		~djMn_TS08.free;
		~djMn_TS08=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~djMnInID, chan:0, noteNum:71);

	}//tracks

	*tsLed{|chan,led|
		~djMn.noteOn(chan, 51, led);
	}
	*tsLeds{|led1,led2,led3,led4,led5,led6,led7,led8|
		~djMn.noteOn(~djMnLn1, ~tsBut1, led1); //But 1
		~djMn.noteOn(~djMnLn1, ~tsBut2, led2); //But 2
		~djMn.noteOn(~djMnLn1, ~tsBut3, led3); //But 3
		~djMn.noteOn(~djMnLn1, ~tsBut4, led4); //But 4
		~djMn.noteOn(~djMnLn1, ~tsBut5, led5); //But 5
		~djMn.noteOn(~djMnLn1, ~tsBut6, led6); //But 6
		~djMn.noteOn(~djMnLn1, ~tsBut7, led7); //But 7
		~djMn.noteOn(~djMnLn1, ~tsBut8, led8); //But 8
	}
	*resetLeds{
		//Toggles Active - Times2 - Static
		~djMn.noteOn(0, 0, 0); //But 1
		~djMn.noteOn(0, 1, 0); //But 2
		~djMn.noteOn(0, 2, 0); //But 3
		~djMn.noteOn(0, 3, 0); //But 1
		~djMn.noteOn(0, 4, 0); //But 2
		~djMn.noteOn(0, 5, 0); //But 3
		~djMn.noteOn(0, 6, 0); //But 1
		~djMn.noteOn(0, 7, 0); //But 2
		~djMn.noteOn(0, 8, 0); //But 3
		~djMn.noteOn(0, 9, 0); //But 1
		~djMn.noteOn(0, 10, 0); //But 2
		~djMn.noteOn(0, 11, 0); //But 3
		~djMn.noteOn(0, 12, 0); //But 1
		~djMn.noteOn(0, 13, 0); //But 2
		~djMn.noteOn(0, 14, 0); //But 3
		~djMn.noteOn(0, 15, 0); //But 1
		~djMn.noteOn(0, 16, 0); //But 2
		~djMn.noteOn(0, 17, 0); //But 3
		~djMn.noteOn(0, 18, 0); //But 1
		~djMn.noteOn(0, 19, 0); //But 2
		~djMn.noteOn(0, 20, 0); //But 3
		~djMn.noteOn(0, 21, 0); //But 1
		~djMn.noteOn(0, 22, 0); //But 2
		~djMn.noteOn(0, 23, 0); //But 3
		//Track Selection Only One Function
		~djMn.noteOn(0, 64, 0); //But 1
		~djMn.noteOn(0, 65, 0); //But 2
		~djMn.noteOn(0, 66, 0); //But 3
		~djMn.noteOn(0, 67, 0); //But 4
		~djMn.noteOn(0, 68, 0); //But 5
		~djMn.noteOn(0, 69, 0); //But 6
		~djMn.noteOn(0, 70, 0); //But 7
		~djMn.noteOn(0, 71, 0); //But 8
		~djMn.noteOn(0, 72, 0); //But Master
		//ClipStop 2 Functions
		~djMn.noteOn(0, 52, 0); //But 1
		~djMn.noteOn(0, 52, 0); //But 2
		~djMn.noteOn(0, 52, 0); //But 3
		~djMn.noteOn(0, 52, 0); //But 4
		~djMn.noteOn(0, 52, 0); //But 5
		~djMn.noteOn(0, 52, 0); //But 6
		~djMn.noteOn(0, 52, 0); //But 7
		~djMn.noteOn(0, 52, 0); //But 8
		~djMn.noteOn(0, 81, 0); //But StopAll
		//Schene Launch Buttons
		~djMn.noteOn(~djMnLn1, 82, 0); //But Scene 1
		~djMn.noteOn(~djMnLn1, 83, 0); //But Scene 2
		~djMn.noteOn(~djMnLn1, 84, 0); //But Scene 3
		~djMn.noteOn(~djMnLn1, 85, 0); //But Scene 4
		~djMn.noteOn(~djMnLn1, 86, 0); //But Scene 5
		~djMn.noteOn(~djMnLn1, 87, 0); //But Scene 6
		~djMn.noteOn(~djMnLn1, 88, 0); //But Scene 7
		~djMn.noteOn(~djMnLn1, 89, 0); //But Scene 8

	}
}

/*

~djMn = MIDIOut.newByName("Akai APC40", "Akai APC40");


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
~djMn.noteOn(0, 48, 127);
},
2,{
~actHat.source=0;
~tOSCAdrr.sendMsg('activHat', 0);
~djMn.noteOff(0, 48, 127);
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
~djMn.noteOn(0, 49, 127);
~tOSCAdrr.sendMsg('time2Hat', 1);
~tOSCAdrr.sendMsg('tmHatLabel', 2);
~tmMulHat.source = Pseq([2], inf);
},
2,{
~djMn.noteOff(0, 49, 127);
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
~djMn.noteOn(0, 50, 127);

},
2,{
~djMn.noteOff(0, 50, 127);

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
~djMn.noteOn(3, 48, 127);
},
2,{
~actBass.source=0;
~tOSCAdrr.sendMsg('activBass', 0);
~djMn.noteOff(3, 48, 127);
~countActBass_APC=0;
}
)}
);
},48,3,~djMnInID);

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
~djMn.noteOn(3, 48, 127);
},
2,{
~actBass.source=0;
~tOSCAdrr.sendMsg('activBass', 0);
~djMn.noteOff(3, 48, 127);
~countActBass_APC=0;
}
)}
);

},1665708355,3,48,nil);


~djMn.uid;


~djMn.noteOn(0, 52, 0); //But 3

~djMn.sysex(Int8Array[
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

		},srcID:~djMnInID, chan:0, ccNum:47);
	}


*globalMode{|case|
		case.switch(
			0,{
				/*~djMn.sysex(Int8Array[
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
				/*~djMn.sysex(Int8Array[
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
				/*~djMn.sysex(Int8Array[
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