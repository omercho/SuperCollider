/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;


IFAPC40.loadSource;
IFAPC40.resetLeds;
IFAPC40.nobDown(mode:1);
IFAPC40.update;

4.ratiomidi

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

IFAPC40.globals;
IFAPC40.resetLeds;
IFAPC40.shiftButton;
IFAPC40.psrButtonsPlay;
*/

IFAPC40{
	*load{

		this.addr;
		this.globals;
		//this.globalMode(1);
		//this.cueNob;
		this.resetLeds;
		this.shiftButton;
		this.psrButtonsPlay;

		//IFAPC40_NobDown.load;
		//IFAPC40_NobUp.load;

	}//loadAtStart

	*addr{

	}
	*globals{
		//channels
		~apcMnCh=0;
		~apcLn1=0;~apcLn2=1;~apcLn3=2;~apcLn4=3;
		~apcLn5=4;~apcLn6=5;~apcLn7=6;~apcLn8=7;
		~apcLnMaster=0;
		//Nums
		~apcFd1=48;~apcFd2=49;~apcFd3=50;~apcFd4=51;
		~apcFd5=52;~apcFd6=53;~apcFd7=54;~apcFd8=55;~apcFd9=56;

		~actButA1=0;~actButA2=1;~actButA3=2;~actButA4=3;~actButA5=4;
		~actButA6=5;~actButB6=13;~actButA7=6;~actButA8=7;

		~actButB1=8;~actButB2=9;~actButB3=10;~actButB4=11;
		~actButB5=12;~actButB6=13;~actButB7=14;~actButB8=15;

		~actButC1=16;~actButC2=17;~actButC3=18;~actButC4=19;
		~actButC5=20;~actButC6=21;~actButC7=22;~actButC8=23;

		~actButD1=24;~actButD2=25;~actButD3=26;~actButD4=27;
		~actButD5=28;~actButD6=29;~actButD7=30;~actButD8=31;

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

			});
		},srcID:~apc40InID, chan:0, noteNum:98);
		~apc40ShiftButOff.free;
		~apc40ShiftButOff=MIDIFunc.noteOff({
			arg vel;
			if ( vel==127, {

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
						//IFLpMnNotes.resetLeds;
						//~apc40.noteOn(~apcLn4, 55, 4); //But 1
					},
					2,{
						~local.sendMsg('/1/toggleMain', 0);
						~cntPlayBut=0;
						//IFLpMnNotes.resetLeds;
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn1, noteNum:~apcPlayBut);
	}

	//Activate Buttons Methods

	*act{|chan,val1,val2,val3,val4|
		~apc40.noteOn(chan, ~actButA, val1); //But A
		~apc40.noteOn(chan, ~actButB, val2); //But B
		~apc40.noteOn(chan, ~actButC, val3); //But C
		~apc40.noteOn(chan, ~actButD, val4); //But D

	}
	//actLine1
	*actLine1{|val1,val2,val3,val4|
		this.actLine1ButA1(val1);
		this.actLine1ButB1(val2);
		this.actLine1ButC1(val3);
		this.actLine1ButD1(val4);
	}
	//actLine2
	*actLine2{|val1,val2,val3,val4|
		this.actLine2ButA2(val1);
		this.actLine2ButB2(val2);
		this.actLine2ButC2(val3);
		this.actLine2ButD2(val4);
	}
	//actLine3
	*actLine3{|val1,val2,val3,val4|
		this.actLine3ButA3(val1);
		this.actLine3ButB3(val2);
		this.actLine3ButC3(val3);
		this.actLine3ButD3(val4);
	}
	//actLine4
	*actLine4{|val1,val2,val3,val4|
		this.actLine4ButA4(val1);
		this.actLine4ButB4(val2);
		this.actLine4ButC4(val3);
		this.actLine4ButD4(val4);
	}
	//actLine5 -- Keys
	*actLine5{|val1,val2,val3,val4|
		this.actLine5ButA5(val1);
		this.actLine5ButB5(val2);
		this.actLine5ButC5(val3);
		this.actLine5ButD5(val4);
	}
	//actLine6 --Samp
	*actLine6{|val1,val2,val3,val4|
		this.actLine6ButA6(val1);
		this.actLine6ButB6(val2);
		this.actLine6ButC6(val3);
		this.actLine6ButD6(val4);
	}
	//actLine7 -- Mast
	*actLine7{|val1,val2,val3,val4|
		this.actLine7ButA7(val1);
		this.actLine7ButB7(val2);
		this.actLine7ButC7(val3);
		this.actLine7ButD7(val4);
	}
	//actLine8 -- Res1
	*actLine8{|val1,val2,val3,val4|
		this.actLine8ButA8(val1);
		this.actLine8ButB8(val2);
		this.actLine8ButC8(val3);
		this.actLine8ButD8(val4);
	}
	//////////////////Button_A
	*actLine1ButA1{|val|
		~apc40.noteOn(~apcLn1, ~actButA1, val); //But A
		~tOSCAdrr.sendMsg('activKick', val);
		~actKick.source=val;
		~cntActLine1ButA1=val;
	}
	*actLine2ButA2{|val|
		~apc40.noteOn(~apcLn1, ~actButA2, val); //But A
		~tOSCAdrr.sendMsg('activSnr', val);
		~actSnr.source=val;
		~cntActLine2ButA2=val;
	}
	*actLine3ButA3{|val|
		~apc40.noteOn(~apcLn1, ~actButA3, val); //But A
		~tOSCAdrr.sendMsg('activHat', val);
		~actHat.source=val;
		~cntActLine3ButA3=val;
	}
	*actLine4ButA4{|val|
		~apc40.noteOn(~apcLn1, ~actButA4, val); //But A
		~tOSCAdrr.sendMsg('activBass', val);
		~actBass.source=val;
		~cntActLine4ButA4=val;
	}
	*actLine5ButA5{|val|
		~apc40.noteOn(~apcLn1, ~actButA5, val); //But A
		~tOSCAdrr.sendMsg('activKeys', val);
		~actKeys.source=val;
		~cntActLine5ButA5=val;
	}
	*actLine6ButA6{|val|
		~apc40.noteOn(~apcLn1, ~actButA6, val); //But A
		~tOSCAdrr.sendMsg('activSamp', val);
		~actSamp.source=val;
		~cntActLine6ButA6=val;
	}
	*actLine7ButA7{|val|
		~apc40.noteOn(~apcLn1, ~actButA7, val); //But A
		~tOSCAdrr.sendMsg('activMopho', val);
		~actMopho.source=val;
		~cntActLine7ButA7=val;
	}
	*actLine8ButA8{|val|
		~apc40.noteOn(~apcLn1, ~actButA8, val); //But A
		~tOSCAdrr.sendMsg('activRes', val);
		~actRes.source=val;
		~cntActLine8ButA8=val;
	}
	//////////////////B_B
	*actLine1ButB1{|val|
		~apc40.noteOn(~apcLn1, ~actButB1, val); //But B
		//~local.sendMsg('time2Kick', val);
		~tOSCAdrr.sendMsg('time2Kick', val);
		~tmMulKick.source = Pseq([val+1], inf);
		~cntActLine1ButB1=val;
	}
	*actLine2ButB2{|val|
		~apc40.noteOn(~apcLn1, ~actButB2, val); //But B
		~tOSCAdrr.sendMsg('activSnr2', val);
		~act2Snr.source=val;
		~cntActLine2ButB2=val;
	}
	*actLine3ButB3{|val|
		~apc40.noteOn(~apcLn1, ~actButB3, val); //But B
		//~local.sendMsg('time2Hat', val);
		~tOSCAdrr.sendMsg('time2Hat', val);
		~tmMulHat.source = Pseq([val+1], inf);
		~cntActLine3ButB3=val;
	}
	*actLine4ButB4{|val|
		~apc40.noteOn(~apcLn1, ~actButB4, val); //But B
		//~local.sendMsg('time2Bass', val);
		~tOSCAdrr.sendMsg('time2Bass', val);
		~tmMulBass.source = Pseq([val+1], inf);
		~cntActLine4ButB4=val;
	}
	*actLine5ButB5{|val|
		~apc40.noteOn(~apcLn1, ~actButB5, val); //But B
		//~local.sendMsg('time2Keys', val);
		~tOSCAdrr.sendMsg('time2Keys', val);
		~tmMulKeys.source = Pseq([val+1], inf);
		~cntActLine5ButB5=val;
	}
	*actLine6ButB6{|val|
		~apc40.noteOn(~apcLn1, ~actButB6, val); //But B
		//~local.sendMsg('time2Samp', val);
		~tOSCAdrr.sendMsg('time2Samp', val);
		~tmMulSamp.source = Pseq([val+1], inf);
		~cntActLine6ButB6=val;
	}
	*actLine7ButB7{|val|
		~apc40.noteOn(~apcLn1, ~actButB7, val); //But B
		~tOSCAdrr.sendMsg('time2Mopho', val);
		~tmMulMopho.source = Pseq([val+1], inf);
		~cntActLine7ButB7=val;
	}
	*actLine8ButB8{|val|
		~apc40.noteOn(~apcLn1, ~actButB8, val); //But B
		~tOSCAdrr.sendMsg('time2Res', val);
		~tmMulRes.source = Pseq([val+1], inf);
		~cntActLine8ButB8=val;
	}

	/////////B_C
	*actLine1ButC1{|val|
		~apc40.noteOn(~apcLn1, ~actButC1, val); //But C
		//~tOSCAdrr.sendMsg('shufKick', val);
		//~actKickLfo1.source=val;
		~cntActLine1ButC1=val;
	}
	*actLine2ButC2{|val|
		~apc40.noteOn(~apcLn1, ~actButC2, val); //But C
		//~tOSCAdrr.sendMsg('shufSnr', val);
		//~actSnrLfo1.source=val;
		~cntActLine2ButC2=val;
	}
	*actLine3ButC3{|val|
		~apc40.noteOn(~apcLn1, ~actButC3, val); //But C
		//~tOSCAdrr.sendMsg('shufHat', val);
		//~actHatLfo1.source=val;
		~cntActLine3ButC3=val;
	}
	*actLine4ButC4{|val|
		~apc40.noteOn(~apcLn1, ~actButC4, val+5); //But C
		~tOSCAdrr.sendMsg('shufBass', val);
		~local.sendMsg('shufBass', val);
		~cntActLine4ButC4=val;
	}
	*actLine5ButC5{|val|
		~apc40.noteOn(~apcLn1, ~actButC5, val+5); //But C
		~tOSCAdrr.sendMsg('shufKeys', val);
		~local.sendMsg('shufKeys', val);
		~cntActLine5ButC5=val;
	}
	*actLine6ButC6{|val|
		~apc40.noteOn(~apcLn1, ~actButC6, val+5); //But C
		~tOSCAdrr.sendMsg('shufSamp', val);
		~local.sendMsg('shufSamp', val);
		~cntActLine6ButC6=val;
	}
	*actLine7ButC7{|val|
		~apc40.noteOn(~apcLn1, ~actButC7, val+5); //But C
		~tOSCAdrr.sendMsg('shufMopho', val);
		~local.sendMsg('shufMopho', val);
		~cntActLine7ButC7=val;
	}
	*actLine8ButC8{|val|
		~apc40.noteOn(~apcLn1, ~actButC8, val); //But C
		//~tOSCAdrr.sendMsg('shufMelHarm', val);
		//~actStHat.source=val;
		~cntActLine8ButC8=val;
	}
	/////////B_D
	*actLine1ButD1{|val|
		~apc40.noteOn(~apcLn1, ~actButD1, val+5); //But D
		~tOSCAdrr.sendMsg('shufKick', val);
		~actKickLfo1.source=val;
		~cntActLine1ButD1=val;
	}
	*actLine2ButD2{|val|
		~apc40.noteOn(~apcLn1, ~actButD2, val+5); //But D
		~tOSCAdrr.sendMsg('shufSnr', val);
		~actSnrLfo1.source=val;
		~cntActLine2ButD2=val;
	}
	*actLine3ButD3{|val|
		~apc40.noteOn(~apcLn1, ~actButD3, val+5); //But D
		~tOSCAdrr.sendMsg('shufHat', val);
		~actHatLfo1.source=val;
		~cntActLine3ButD3=val;
	}
	*actLine4ButD4{|val|
		~apc40.noteOn(~apcLn1, ~actButD4, val+5); //But D
		//~tOSCAdrr.sendMsg('shufBass', val);
		//~local.sendMsg('shufBass', val);
		~cntActLine4ButD4=val;
	}
	*actLine5ButD5{|val|
		~apc40.noteOn(~apcLn1, ~actButD5, val+5); //But D
		//~tOSCAdrr.sendMsg('shufKeys', val);
		//~local.sendMsg('shufKeys', val);
		~cntActLine5ButD5=val;
	}
	*actLine6ButD6{|val|
		~apc40.noteOn(~apcLn1, ~actButD6, val+5); //But D
		//~tOSCAdrr.sendMsg('shufSamp', val);
		//~local.sendMsg('shufSamp', val);
		~cntActLine6ButD6=val;
	}
	*actLine7ButD7{|val|
		~apc40.noteOn(~apcLn1, ~actButD7, val+5); //But D
		//~tOSCAdrr.sendMsg('shufMopho', val);
		//~local.sendMsg('shufMopho', val);
		~cntActLine7ButD7=val;
	}
	*actLine8ButD8{|val|
		~apc40.noteOn(~apcLn1, ~actButD8, val); //But D
		//~tOSCAdrr.sendMsg('shufMelHarm', val);
		//~actStHat.source=val;
		~cntActLine8ButD8=val;
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
		~apc40.noteOn(0, 65, 0); //But 2
		~apc40.noteOn(0, 66, 0); //But 3
		~apc40.noteOn(0, 67, 0); //But 4
		~apc40.noteOn(0, 68, 0); //But 5
		~apc40.noteOn(0, 69, 0); //But 6
		~apc40.noteOn(0, 70, 0); //But 7
		~apc40.noteOn(0, 71, 0); //But 8
		~apc40.noteOn(0, 72, 0); //But Master
		//ClipStop 2 Functions
		~apc40.noteOn(0, 52, 0); //But 1
		~apc40.noteOn(0, 52, 0); //But 2
		~apc40.noteOn(0, 52, 0); //But 3
		~apc40.noteOn(0, 52, 0); //But 4
		~apc40.noteOn(0, 52, 0); //But 5
		~apc40.noteOn(0, 52, 0); //But 6
		~apc40.noteOn(0, 52, 0); //But 7
		~apc40.noteOn(0, 52, 0); //But 8
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