/*
PostAllMIDI.on;
PostAllMIDI.off;
IFAPC40.loadSource;
IFAPC40.resetLeds;
IFAPC40.globalMode(1);
IFAPC40.nobDown(mode:1);
IFAPC40.update;

*/

IFAPC40{
	*loadSource{

		~apc40 = MIDIOut.newByName("Akai APC40", "Akai APC40");
		~apc40OutID=34339974;
		~apc40InID=1665708355;
		this.globals;
		this.globalMode(1);
		this.cueNob;
		this.resetLeds;
		this.shiftButton;
		this.psrButtonsPlay;

		IFAPC40_NobDown.load;
		IFAPC40_NobUp.load;
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
		~actButA=48;~actButB=49;~actButC=50;
		~tsBut=51;
		~apcPlayBut=91;
		~apcStopBut=92;
		~apcRecBut=93;
		~apcBankUpBut=94;
		~apcBankDownBut=95;
		~apcBankRightBut=96;
		~apcBankLeftBut=97;
		~apcTapBut=99;
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
		},srcID:~apc40InID, chan:~apcLn1, noteNum:~apcTapBut);
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
		~apc40.noteOn(~apcLn1, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activKick', val);
		~actKick.source=val;
		~cntActLine1ButA=val;
	}
	*actLine1ButB{|val|
		~apc40.noteOn(~apcLn1, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Kick', val);
		~tmMulKick.source = Pseq([val+1], inf);
		~cntActLine1ButB=val;
	}
	*actLine1ButC{|val|
		~apc40.noteOn(~apcLn1, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStKick', val);
		~actStKick.source=val;
		~cntActLine1ButC=val;
	}
	//actLine2
	*actLine2{|val1,val2,val3|
		this.actLine2ButA(val1);
		this.actLine2ButB(val2);
		this.actLine2ButC(val3);
	}
	*actLine2ButA{|val|
		~apc40.noteOn(~apcLn2, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activSnr', val);
		~actSnr.source=val;
		~cntActLine2ButA=val;
	}
	*actLine2ButB{|val|
		~apc40.noteOn(~apcLn2, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Snr', val);
		~tmMulSnr.source = Pseq([val+1], inf);
		~cntActLine2ButB=val;
	}
	*actLine2ButC{|val|
		~apc40.noteOn(~apcLn2, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStSnr', val);
		~actStSnr.source=val;
		~cntActLine2ButC=val;
	}
	//actLine3
	*actLine3{|val1,val2,val3|
		this.actLine3ButA(val1);
		this.actLine3ButB(val2);
		this.actLine3ButC(val3);
	}
	*actLine3ButA{|val|
		~apc40.noteOn(~apcLn3, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activHat', val);
		~actHat.source=val;
		~cntActLine3ButA=val;
	}
	*actLine3ButB{|val|
		~apc40.noteOn(~apcLn3, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Hat', val);
		~tmMulHat.source = Pseq([val+1], inf);
		~cntActLine3ButB=val;
	}
	*actLine3ButC{|val|
		~apc40.noteOn(~apcLn3, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStHat', val);
		~actStHat.source=val;
		~cntActLine3ButC=val;
	}
	//actLine4
	*actLine4{|val1,val2,val3|
		this.actLine4ButA(val1);
		this.actLine4ButB(val2);
		this.actLine4ButC(val3);
	}
	*actLine4ButA{|val|
		~apc40.noteOn(~apcLn4, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activBass', val);
		~actBass.source=val;
		~cntActLine4ButA=val;
	}
	*actLine4ButB{|val|
		~apc40.noteOn(~apcLn4, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Bass', val);
		~tmMulBass.source = Pseq([val+1], inf);
		~cntActLine4ButB=val;
	}
	*actLine4ButC{|val|
		~apc40.noteOn(~apcLn4, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStBass', val);
		~actStBass.source=val;
		~cntActLine4ButC=val;
	}
	//actLine5 -- Keys
	*actLine5{|val1,val2,val3|
		this.actLine5ButA(val1);
		this.actLine5ButB(val2);
		this.actLine5ButC(val3);
	}
	*actLine5ButA{|val|
		~apc40.noteOn(~apcLn5, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activKeys', val);
		~actKeys.source=val;
		~cntActLine5ButA=val;
	}
	*actLine5ButB{|val|
		~apc40.noteOn(~apcLn5, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Keys', val);
		~tmMulKeys.source = Pseq([val+1], inf);
		~cntActLine5ButB=val;
	}
	*actLine5ButC{|val|
		~apc40.noteOn(~apcLn5, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStKeys', val);
		~actStKeys.source=val;
		~cntActLine5ButC=val;
	}
	//actLine6 --Samp
	*actLine6{|val1,val2,val3|
		this.actLine6ButA(val1);
		this.actLine6ButB(val2);
		this.actLine6ButC(val3);
	}
	*actLine6ButA{|val|
		~apc40.noteOn(~apcLn6, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activSamp', val);
		~actSamp.source=val;
		~cntActLine6ButA=val;
	}
	*actLine6ButB{|val|
		~apc40.noteOn(~apcLn6, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Samp', val);
		~tmMulSamp.source = Pseq([val+1], inf);
		~cntActLine6ButB=val;
	}
	*actLine6ButC{|val|
		~apc40.noteOn(~apcLn6, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStSamp', val);
		~actStSamp.source=val;
		~cntActLine6ButC=val;
	}
	//actLine7 -- Mast
	*actLine7{|val1,val2,val3|
		this.actLine7ButA(val1);
		this.actLine7ButB(val2);
		this.actLine7ButC(val3);
	}
	*actLine7ButA{|val|
		~apc40.noteOn(~apcLn7, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activMast', val);
		~actMast.source=val;
		~cntActLine7ButA=val;
	}
	*actLine7ButB{|val|
		~apc40.noteOn(~apcLn7, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Mast', val);
		~tmMulMast.source = Pseq([val+1], inf);
		~cntActLine7ButB=val;
	}
	*actLine7ButC{|val|
		~apc40.noteOn(~apcLn7, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStMast', val);
		//~actStHat.source=val;
		~cntActLine7ButC=val;
	}
	//actLine8 -- Res1
	*actLine8{|val1,val2,val3|
		this.actLine8ButA(val1);
		this.actLine8ButB(val2);
		this.actLine8ButC(val3);
	}
	*actLine8ButA{|val|
		~apc40.noteOn(~apcLn8, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activRes1', val);
		~actRes1.source=val;
		~cntActLine8ButA=val;
	}
	*actLine8ButB{|val|
		~apc40.noteOn(~apcLn8, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Res1', val);
		~tmMulRes1.source = Pseq([val+1], inf);
		~cntActLine8ButB=val;
	}
	*actLine8ButC{|val|
		~apc40.noteOn(~apcLn8, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStRes1', val);
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
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS02.free;
		~apc_TS02=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack02.loadAtStart;
			});
		},srcID:~apc40InID, chan:1, noteNum:51);
		~apc_TS03.free;
		~apc_TS03=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack03.loadAtStart;
			});
		},srcID:~apc40InID, chan:2, noteNum:51);
		~apc_TS04.free;
		~apc_TS04=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:3, noteNum:51);
		~apc_TS05.free;
		~apc_TS05=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:4, noteNum:51);
		~apc_TS06.free;
		~apc_TS06=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:5, noteNum:51);
		~apc_TS07.free;
		~apc_TS07=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:6, noteNum:51);
		~apc_TS08.free;
		~apc_TS08=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:7, noteNum:51);

	}//tracks

	*globalMode{|case|
		case.switch(
			0,{
				~apc40.sysex(Int8Array[
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
				]);
			},
			1,{
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
			},
			2,{
				~apc40.sysex(Int8Array[
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
				]);
			}
		);
	}
	*tsLed{|chan,led|
		~apc40.noteOn(chan, 51, led);
	}
	*tsLeds{|led1,led2,led3,led4,led5,led6,led7,led8|
		~apc40.noteOn(~apcLn1, ~tsBut, led1); //But 1
		~apc40.noteOn(~apcLn2, ~tsBut, led2); //But 2
		~apc40.noteOn(~apcLn3, ~tsBut, led3); //But 3
		~apc40.noteOn(~apcLn4, ~tsBut, led4); //But 4
		~apc40.noteOn(~apcLn5, ~tsBut, led5); //But 5
		~apc40.noteOn(~apcLn6, ~tsBut, led6); //But 6
		~apc40.noteOn(~apcLn7, ~tsBut, led7); //But 7
		~apc40.noteOn(~apcLn8, ~tsBut, led8); //But 8
	}

	/*
	IFAPC40.ndButLeds(1,0,0,0,0,0,0,0);
	IFAPC40.nobDown(mode:2);
	*/
	*resetLeds{
		//Toggles Active - Times2 - Static
		~apc40.noteOn(0, 48, 0); //But 1
		~apc40.noteOn(0, 49, 0); //But 2
		~apc40.noteOn(0, 50, 0); //But 3
		~apc40.noteOn(1, 48, 0); //But 1
		~apc40.noteOn(1, 49, 0); //But 2
		~apc40.noteOn(1, 50, 0); //But 3
		~apc40.noteOn(2, 48, 0); //But 1
		~apc40.noteOn(2, 49, 0); //But 2
		~apc40.noteOn(2, 50, 0); //But 3
		~apc40.noteOn(3, 48, 0); //But 1
		~apc40.noteOn(3, 49, 0); //But 2
		~apc40.noteOn(3, 50, 0); //But 3
		~apc40.noteOn(4, 48, 0); //But 1
		~apc40.noteOn(4, 49, 0); //But 2
		~apc40.noteOn(4, 50, 0); //But 3
		~apc40.noteOn(5, 48, 0); //But 1
		~apc40.noteOn(5, 49, 0); //But 2
		~apc40.noteOn(5, 50, 0); //But 3
		~apc40.noteOn(6, 48, 0); //But 1
		~apc40.noteOn(6, 49, 0); //But 2
		~apc40.noteOn(6, 50, 0); //But 3
		~apc40.noteOn(7, 48, 0); //But 1
		~apc40.noteOn(7, 49, 0); //But 2
		~apc40.noteOn(7, 50, 0); //But 3
		//Track Selection Only One Function
		~apc40.noteOn(0, 51, 0); //But 1
		~apc40.noteOn(1, 51, 0); //But 2
		~apc40.noteOn(2, 51, 0); //But 3
		~apc40.noteOn(3, 51, 0); //But 4
		~apc40.noteOn(4, 51, 0); //But 5
		~apc40.noteOn(5, 51, 0); //But 6
		~apc40.noteOn(6, 51, 0); //But 7
		~apc40.noteOn(7, 51, 0); //But 8
		~apc40.noteOn(0, 80, 0); //But Master
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


~apc40ID.value


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

*/