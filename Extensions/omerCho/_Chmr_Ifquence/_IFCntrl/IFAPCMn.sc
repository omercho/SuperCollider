/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;


IFAPCMn.loadSource;
IFAPCMn.resetLeds;
IFAPCMn.nobDown(mode:1);
IFAPCMn.update;

4.ratiomidi

//to find the srcID of MIDIOut sources
~mdOut.uid;
~mdTouch.uid;
~apcMn.uid;

//to find MIDIIn src
(
c = NoteOnResponder({ |src,chan,note,vel|
        [src,chan,note,vel].postln;
    });
    c.learn; // wait for the first note
)
NoteOnResponder.removeAll

IFAPCMn.globals;
IFAPCMn.resetLeds;
IFAPCMn.shiftButton;
IFAPCMn.psrButtonsPlay;
*/

IFAPCMn{
	*load{

		this.addr;
		this.globals;
		//this.globalMode(1);
		//this.cueNob;
		this.resetLeds;
		this.shiftButton;
		this.psrButtonsPlay;
		this.loadTSResponders;
		this.loadFaders;

		//IFAPCMn_NobDown.load;
		//IFAPCMn_NobUp.load;

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

		~actButTS1=64;~actButTS2=65;~actButTS3=66;~actButTS4=67;
		~actButTS5=68;~actButTS6=69;~actButTS7=70;~actButTS8=71;

		~actButA1=56;~actButA2=57;~actButA3=58;~actButA4=59;
		~actButA5=60;~actButA6=61;~actButA7=62;~actButA8=63;

		~actButB1=48;~actButB2=49;~actButB3=50;~actButB4=51;
		~actButB5=52;~actButB6=53;~actButB7=54;~actButB8=55;

		~actButC1=40;~actButC2=41;~actButC3=42;~actButC4=43;
		~actButC5=44;~actButC6=45;~actButC7=46;~actButC8=47;

		~actButD1=24;~actButD2=25;~actButD3=26;~actButD4=27;
		~actButD5=28;~actButD6=29;~actButD7=30;~actButD8=31;

		~tsBut1=64;~tsBut2=65;~tsBut3=66;~tsBut4=67;
		~tsBut5=68;~tsBut6=69;~tsBut7=70;~tsBut8=71;

		~apcPlayBut=98;

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
		//~apcMn.noteOn(0, 98, 127); //SHIFT
		~trackCase=\00;
		~partCase=\00;
		~apcMnShiftBut.free;
		~apcMnShiftBut=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apcMnInID, chan:0, noteNum:98);
		~apcMnShiftButOff.free;
		~apcMnShiftButOff=MIDIFunc.noteOff({
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apcMnInID, chan:0, noteNum:98);
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
						//~local.sendMsg('nt_0', 1);
						//~apcMn.noteOn(~apcLn1, ~apcPlayBut, 127); //But A
						//IFLpMnNotes.resetLeds;
						//~apcMn.noteOn(~apcLn4, 55, 4); //But 1
					},
					2,{
						~local.sendMsg('/1/toggleMain', 0);
						//~apcMn.noteOn(~apcLn1, ~apcPlayBut, 0); //But A
						~cntPlayBut=0;
						//IFLpMnNotes.resetLeds;
					}
				)}
			);
		},srcID:~apcMnInID, chan:~apcLn1, noteNum:~apcPlayBut);
	}
	/////TS Buts//////
	*actTSButs{|val1,val2,val3,val4,val5,val6,val7,val8|
		this.actLine1TS1(val1);
		this.actLine1TS2(val2);
		this.actLine1TS3(val3);
		this.actLine1TS4(val4);
		this.actLine1TS5(val5);
		this.actLine1TS6(val6);
		this.actLine1TS7(val7);
		this.actLine1TS8(val8);
	}

	//Activate Buttons Methods
	*act{|chan,val1,val2,val3|
		~apcMn.noteOn(chan, ~actButA, val1); //But A
		~apcMn.noteOn(chan, ~actButB, val2); //But B
		~apcMn.noteOn(chan, ~actButC, val3); //But C

	}
	//actLine1
	*actLine1{|val0,val1,val2,val3|
		this.actLine1ButTS1(val0);
		this.actLine1ButA1(val1);
		this.actLine1ButB1(val2);
		this.actLine1ButC1(val3);

	}
	//actLine2
	*actLine2{|val0,val1,val2,val3|
		this.actLine2ButTS2(val0);
		this.actLine2ButA2(val1);
		this.actLine2ButB2(val2);
		this.actLine2ButC2(val3);

	}
	//actLine3
	*actLine3{|val0,val1,val2,val3|
		this.actLine3ButTS3(val0);
		this.actLine3ButA3(val1);
		this.actLine3ButB3(val2);
		this.actLine3ButC3(val3);

	}
	//actLine4
	*actLine4{|val0,val1,val2,val3|
		this.actLine4ButTS4(val0);
		this.actLine4ButA4(val1);
		this.actLine4ButB4(val2);
		this.actLine4ButC4(val3);

	}
	//actLine5 -- Keys
	*actLine5{|val0,val1,val2,val3|
		this.actLine5ButTS5(val0);
		this.actLine5ButA5(val1);
		this.actLine5ButB5(val2);
		this.actLine5ButC5(val3);

	}
	//actLine6 --Samp
	*actLine6{|val0,val1,val2,val3|
		this.actLine6ButTS6(val0);
		this.actLine6ButA6(val1);
		this.actLine6ButB6(val2);
		this.actLine6ButC6(val3);

	}
	//actLine7 -- Mopho
	*actLine7{|val0,val1,val2,val3|
		this.actLine7ButTS7(val0);
		this.actLine7ButA7(val1);
		this.actLine7ButB7(val2);
		this.actLine7ButC7(val3);

	}
	//actLine8 -- Res1
	*actLine8{|val0,val1,val2,val3|
		this.actLine8ButTS8(val0);
		this.actLine8ButA8(val1);
		this.actLine8ButB8(val2);
		this.actLine8ButC8(val3);

	}
	//////////////////Button
	//--1
	*actLine1ButTS1{|val|
		~apcMn.noteOn(~apcLn1, ~actButTS1, val); //ButTS
		//~local.sendMsg('pitchKick', 1);
		~local.sendMsg('pitchBass', 1);
		~cntActLine1ButTS1=val;
	}
	*actLine1ButA1{|val|
		~apcMn.noteOn(~apcLn1, ~actButA1, val+5);  //But A

		~cntActLine1ButA1=val;
	}
	*actLine1ButB1{|val|
		~apcMn.noteOn(~apcLn1, ~actButB1, val+5); //But B

		~cntActLine1ButB1=val;
	}
	*actLine1ButC1{|val|
		~apcMn.noteOn(~apcLn1, ~actButC1, val+5); //But C

		~cntActLine1ButC1=val;
	}

	//--2
	*actLine2ButTS2{|val|
		~apcMn.noteOn(~apcLn1, ~actButTS2, val);  //ButTS
		//~local.sendMsg('pitchSnr', 1);
		~cntActLine2ButTS2=val;
	}
	*actLine2ButA2{|val|
		~apcMn.noteOn(~apcLn1, ~actButA2, val+5);   //But A

		~cntActLine2ButA2=val;
	}
	*actLine2ButB2{|val|
		~apcMn.noteOn(~apcLn1, ~actButB2, val+5); //But B

		~cntActLine2ButB2=val;
	}
	*actLine2ButC2{|val|
		~apcMn.noteOn(~apcLn1, ~actButC2, val+5); //But C
		//~tOSCAdrr.sendMsg('shufSnr', val);
		//~actSnrLfo1.source=val;
		~cntActLine2ButC2=val;
	}

	//--3
	*actLine3ButTS3{|val|
		~apcMn.noteOn(~apcLn1, ~actButTS3, val); //ButTS

		~local.sendMsg('pitchKeys', 1);
		//~local.sendMsg('pitchHat', 1);
		~cntActLine3ButTS3=val;
	}
	*actLine3ButA3{|val|
		~apcMn.noteOn(~apcLn1, ~actButA3, val+5);  //But A

		~cntActLine3ButA3=val;
	}
	*actLine3ButB3{|val|
		~apcMn.noteOn(~apcLn1, ~actButB3, val+5); //But B

		~cntActLine3ButB3=val;
	}
	*actLine3ButC3{|val|
		~apcMn.noteOn(~apcLn1, ~actButC3, val+5); //But C
		//~tOSCAdrr.sendMsg('shufHat', val);
		//~actHatLfo1.source=val;
		~cntActLine3ButC3=val;
	}

	//--4
	*actLine4ButTS4{|val|
		~apcMn.noteOn(~apcLn1, ~actButTS4, val); //ButTS

		~cntActLine4ButTS4=val;
	}
	*actLine4ButA4{|val|
		~apcMn.noteOn(~apcLn1, ~actButA4, val+5);  //But A

		~cntActLine4ButA4=val;
	}
	*actLine4ButB4{|val|
		~apcMn.noteOn(~apcLn1, ~actButB4, val+5); //But B

		~cntActLine4ButB4=val;
	}
	*actLine4ButC4{|val|
		~apcMn.noteOn(~apcLn1, ~actButC4, val+5); //But C
		//~tOSCAdrr.sendMsg('shufBass', val);
		//~local.sendMsg('shufBass', val);
		~cntActLine4ButC4=val;
	}

	//--5
	*actLine5ButTS5{|val|
		~apcMn.noteOn(~apcLn1, ~actButTS5, val); //ButTS
		~local.sendMsg('pitchSamp', 1);
		~cntActLine5ButTS5=val;
	}
	*actLine5ButA5{|val|
		~apcMn.noteOn(~apcLn1, ~actButA5, val+5);   //But A

		~cntActLine5ButA5=val;
	}
	*actLine5ButB5{|val|
		~apcMn.noteOn(~apcLn1, ~actButB5, val+5);  //But B

		~cntActLine5ButB5=val;
	}
	*actLine5ButC5{|val|
		~apcMn.noteOn(~apcLn1, ~actButC5, val+5); //But C
		//~tOSCAdrr.sendMsg('shufKeys', val);
		//~local.sendMsg('shufKeys', val);
		~cntActLine5ButC5=val;
	}

	//--6
	*actLine6ButTS6{|val|
		~apcMn.noteOn(~apcLn1, ~actButTS6, val); //ButTS

		~cntActLine6ButTS6=val;
	}
	*actLine6ButA6{|val|
		~apcMn.noteOn(~apcLn1, ~actButA6, val+5);  //But A

		~cntActLine6ButA6=val;
	}
	*actLine6ButB6{|val|
		~apcMn.noteOn(~apcLn1, ~actButB6, val+5); //But B

		~cntActLine6ButB6=val;
	}
	*actLine6ButC6{|val|
		~apcMn.noteOn(~apcLn1, ~actButC6, val+5); //But C
		//~tOSCAdrr.sendMsg('shufSamp', val);
		//~local.sendMsg('shufSamp', val);
		~cntActLine6ButC6=val;
	}

	//--7
	*actLine7ButTS7{|val|
		~apcMn.noteOn(~apcLn1, ~actButTS7, val); //ButTS
		~local.sendMsg('pitchMopho', 1);
		~cntActLine7ButTS7=val;
	}
	*actLine7ButA7{|val|
		~apcMn.noteOn(~apcLn1, ~actButA7, val+5);  //But A

		~cntActLine7ButA7=val;
	}
	*actLine7ButB7{|val|
		~apcMn.noteOn(~apcLn1, ~actButB7, val+5); //But B

		~cntActLine7ButB7=val;
	}
	*actLine7ButC7{|val|
		~apcMn.noteOn(~apcLn1, ~actButC7, val+5); //But C
		//~tOSCAdrr.sendMsg('shufMopho', val);
		//~local.sendMsg('pitchMopho', 1);
		~cntActLine7ButC7=val;
	}

	//--8
	*actLine8ButTS8{|val|
		~apcMn.noteOn(~apcLn1, ~actButTS8, val); //ButTS
		//~local.sendMsg('pitchBass', 1);
		~cntActLine8ButTS8=val;
	}
	*actLine8ButA8{|val|
		~apcMn.noteOn(~apcLn1, ~actButA8, val+5); //But A

		~cntActLine8ButA8=val;
	}
	*actLine8ButB8{|val|
		~apcMn.noteOn(~apcLn1, ~actButB8, val+5); //But B

		~cntActLine8ButB8=val;
	}
	*actLine8ButC8{|val|
		~apcMn.noteOn(~apcLn1, ~actButC8, val+5); //But C

		~cntActLine8ButD8=val;
	}


	*loadFaders{
		//--------------------line1
		~apcMnFad1.free;
		~apcMnFad1=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			IFBass.set1(\susM,val);
			//IFKick.set1(\susM,val+0.15);
		},srcID:~apcMnInID, chan:~apcMnCh, ccNum:~apcFd1);

		////--------------------line2
		~apcMnFad2.free;
		~apcMnFad2=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			//IFSnr.set1(\susM,val+0.1);
		},srcID:~apcMnInID, chan:~apcMnCh, ccNum:~apcFd2);

		////--------------------line3
		~apcMnFad3.free;
		~apcMnFad3=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			IFKeys.set1(\susM,val);
			//IFHat.set1(\susM,val+0.15);
		},srcID:~apcMnInID, chan:~apcMnCh, ccNum:~apcFd3);

		//--------------------line4
		~apcMnFad4.free;
		~apcMnFad4=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			//IFKeys.set1(\susM,val);
		},srcID:~apcMnInID, chan:~apcMnCh, ccNum:~apcFd4);

		//--------------------line5
		~apcMnFad5.free;
		~apcMnFad5=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			IFSamp.set1(\susM,val);
		},srcID:~apcMnInID, chan:~apcMnCh, ccNum:~apcFd5);

		//--------------------line6
		~apcMnFad6.free;
		~apcMnFad6=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~apcMnInID, chan:~apcMnCh, ccNum:~apcFd6);

		//--------------------line7
		~apcMnFad7.free;
		~apcMnFad7=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			IFMopho.set1(\susM,val);
		},srcID:~apcMnInID, chan:~apcMnCh, ccNum:~apcFd7);

		//--------------------line8
		~apcMnFad8.free;
		~apcMnFad8=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			//IFBass.set1(\susM,val);
		},srcID:~apcMnInID, chan:~apcMnCh, ccNum:~apcFd8);

	}
	*loadTSResponders{

		//ActTS1
		~cntActLine1ButTS1=0;
		~mdMixActTS1.free;
		~mdMixActTS1=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine1ButTS1 = ~cntActLine1ButTS1 + 1;
				~cntActLine1ButTS1.switch(
					1,{this.actLine1ButTS1(1);},
					2,{this.actLine1ButTS1(0);}
				)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButTS1);
		//Act ButA1
		~cntActLine1ButA1=0;
		~mdActLine1ButA1.free;
		~mdActLine1ButA1=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine1ButA1 = ~cntActLine1ButA1 + 1;
				~cntActLine1ButA1.switch(
					1,{IFAPCMn.actLine1ButA1(1);},
					2,{IFAPCMn.actLine1ButA1(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButA1);
		//Act ButB1
		~cntActLine1ButB1=0;
		~mdActLine1ButB1.free;
		~mdActLine1ButB1=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine1ButB1 = ~cntActLine1ButB1 + 1;
				~cntActLine1ButB1.switch(
					1, {IFAPCMn.actLine1ButB1(1);},
					2,{IFAPCMn.actLine1ButB1(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButB1);
		//Act ButC1
		~cntActLine1ButC1=0;
		~mdActLine1ButC1.free;
		~mdActLine1ButC1=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine1ButC1 = ~cntActLine1ButC1 + 1;
				~cntActLine1ButC1.switch(
					1, {IFAPCMn.actLine1ButC1(1);},
					2,{IFAPCMn.actLine1ButC1(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButC1);


		//----------
		//ActTS2
		~cntActLine2ButTS2=0;
		~mdMixActTS2.free;
		~mdMixActTS2=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine2ButTS2 = ~cntActLine2ButTS2 + 1;
				~cntActLine2ButTS2.switch(
					1,{this.actLine2ButTS2(1);},
					2,{this.actLine2ButTS2(0);}
				)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButTS2);
		//Act ButA2
		~cntActLine2ButA2=0;
		~mdActLine2ButA2.free;
		~mdActLine2ButA2=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine2ButA2 = ~cntActLine2ButA2 + 1;
				~cntActLine2ButA2.switch(
					1,{IFAPCMn.actLine2ButA2(1);},
					2,{IFAPCMn.actLine2ButA2(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButA2);
		//Act ButB2
		~cntActLine2ButB2=0;
		~mdActLine2ButB2.free;
		~mdActLine2ButB2=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine2ButB2 = ~cntActLine2ButB2 + 1;
				~cntActLine2ButB2.switch(
					1,{IFAPCMn.actLine2ButB2(1);},
					2,{IFAPCMn.actLine2ButB2(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButB2);
		//Act ButC2
		~cntActLine2ButC2=0;
		~mdActLine2ButC2.free;
		~mdActLine2ButC2=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine2ButC2 = ~cntActLine2ButC2 + 1;
				~cntActLine2ButC2.switch(
					1,{IFAPCMn.actLine2ButC2(1);},
					2,{IFAPCMn.actLine2ButC2(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButC2);


		//----------
		//ActTS3
		~cntActLine3ButTS3=0;
		~mdMixActTS3.free;
		~mdMixActTS3=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine3ButTS3 = ~cntActLine3ButTS3 + 1;
				~cntActLine3ButTS3.switch(
					1,{this.actLine3ButTS3(1);},
					2,{this.actLine3ButTS3(0);}
				)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButTS3);
		//Act ButA3
		~cntActLine3ButA3=0;
		~mdActLine3ButA3.free;
		~mdActLine3ButA3=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine3ButA3 = ~cntActLine3ButA3 + 1;
				~cntActLine3ButA3.switch(
					1,{IFAPCMn.actLine3ButA3(1);},
					2,{IFAPCMn.actLine3ButA3(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButA3);
		//Act ButB3
		~cntActLine3ButB3=0;
		~mdActLine3ButB3.free;
		~mdActLine3ButB3=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine3ButB3 = ~cntActLine3ButB3 + 1;
				~cntActLine3ButB3.switch(
					1,{IFAPCMn.actLine3ButB3(1);},
					2,{IFAPCMn.actLine3ButB3(0);}
			)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButB3);
		//Act ButC3
		~cntActLine3ButC3=0;
		~mdActLine3ButC3.free;
		~mdActLine3ButC3=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine3ButC3 = ~cntActLine3ButC3 + 1;
				~cntActLine3ButC3.switch(
					1,{IFAPCMn.actLine3ButC3(1);},
					2,{IFAPCMn.actLine3ButC3(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButC3);


		//----------
		//ActTS4
		~cntActLine4ButTS4=0;
		~mdMixActTS4.free;
		~mdMixActTS4=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine4ButTS4 = ~cntActLine4ButTS4 + 1;
				~cntActLine4ButTS4.switch(
					1,{this.actLine4ButTS4(1);},
					2,{this.actLine4ButTS4(0);}
				)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButTS4);
		//Act ButA4
		~cntActLine4ButA4=0;
		~mdActLine4ButA4.free;
		~mdActLine4ButA4=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine4ButA4 = ~cntActLine4ButA4 + 1;
				~cntActLine4ButA4.switch(
					1,{IFAPCMn.actLine4ButA4(1);},
					2,{IFAPCMn.actLine4ButA4(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButA4);
		//Act ButB4
		~cntActLine4ButB4=0;
		~mdActLine4ButB4.free;
		~mdActLine4ButB4=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine4ButB4 = ~cntActLine4ButB4 + 1;
				~cntActLine4ButB4.switch(
					1,{IFAPCMn.actLine4ButB4(1);},
					2,{IFAPCMn.actLine4ButB4(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButB4);
		//Act ButC4
		~cntActLine4ButC4=0;
		~mdActLine4ButC4.free;
		~mdActLine4ButC4=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine4ButC4 = ~cntActLine4ButC4 + 1;
				~cntActLine4ButC4.switch(
					1,{IFAPCMn.actLine4ButC4(1);},
					2,{IFAPCMn.actLine4ButC4(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButC4);


		//----------
		//ActTS5
		~cntActLine5ButTS5=0;
		~mdMixActTS5.free;
		~mdMixActTS5=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine5ButTS5 = ~cntActLine5ButTS5 + 1;
				~cntActLine5ButTS5.switch(
					1,{this.actLine5ButTS5(1);},
					2,{this.actLine5ButTS5(0);}
				)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButTS5);
		//Act ButA5
		~cntActLine5ButA5=0;
		~mdActLine5ButA5.free;
		~mdActLine5ButA5=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine5ButA5 = ~cntActLine5ButA5 + 1;
				~cntActLine5ButA5.switch(
					1,{IFAPCMn.actLine5ButA5(1);},
					2,{IFAPCMn.actLine5ButA5(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButA5);
		//Act ButB5
		~cntActLine5ButB5=0;
		~mdActLine5ButB5.free;
		~mdActLine5ButB5=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine5ButB5 = ~cntActLine5ButB5 + 1;
				~cntActLine5ButB5.switch(
					1,{IFAPCMn.actLine5ButB5(1);},
					2,{IFAPCMn.actLine5ButB5(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButB5);
		//Act ButC5
		~cntActLine5ButC5=0;
		~mdActLine5ButC5.free;
		~mdActLine5ButC5=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine5ButC5 = ~cntActLine5ButC5 + 1;
				~cntActLine5ButC5.switch(
					1,{IFAPCMn.actLine5ButC5(1);},
					2,{IFAPCMn.actLine5ButC5(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButC5);


		//----------
		//ActTS6
		~cntActLine6ButTS6=0;
		~mdMixActTS6.free;
		~mdMixActTS6=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine6ButTS6 = ~cntActLine6ButTS6 + 1;
				~cntActLine6ButTS6.switch(
					1,{this.actLine6ButTS6(1);},
					2,{this.actLine6ButTS6(0);}
				)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButTS6);
		//Act ButA6
		~cntActLine6ButA6=0;
		~mdActLine6ButA6.free;
		~mdActLine6ButA6=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine6ButA6 = ~cntActLine6ButA6 + 1;
				~cntActLine6ButA6.switch(
					1,{IFAPCMn.actLine6ButA6(1);},
					2,{IFAPCMn.actLine6ButA6(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButA6);
		//Act ButB6
		~cntActLine6ButB6=0;
		~mdActLine6ButB6.free;
		~mdActLine6ButB6=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine6ButB6 = ~cntActLine6ButB6 + 1;
				~cntActLine6ButB6.switch(
					1,{IFAPCMn.actLine6ButB6(1);},
					2,{IFAPCMn.actLine6ButB6(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButB6);
		//Act ButC6
		~cntActLine6ButC6=0;
		~mdActLine6ButC6.free;
		~mdActLine6ButC6=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine6ButC6 = ~cntActLine6ButC6 + 1;
				~cntActLine6ButC6.switch(
					1,{IFAPCMn.actLine6ButC6(1);},
					2,{IFAPCMn.actLine6ButC6(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButC6);


		//----------
		//ActTS7
		~cntActLine7ButTS7=0;
		~mdMixActTS7.free;
		~mdMixActTS7=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine7ButTS7 = ~cntActLine7ButTS7 + 1;
				~cntActLine7ButTS7.switch(
					1,{this.actLine7ButTS7(1);},
					2,{this.actLine7ButTS7(0);}
				)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButTS7);
		//Act ButA7
		~cntActLine7ButA7=0;
		~mdActLine7ButA7.free;
		~mdActLine7ButA7=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine7ButA7 = ~cntActLine7ButA7 + 1;
				~cntActLine7ButA7.switch(
					1,{IFAPCMn.actLine7ButA7(1);},
					2,{IFAPCMn.actLine7ButA7(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButA7);
		//Act ButB7
		~cntActLine7ButB7=0;
		~mdActLine7ButB7.free;
		~mdActLine7ButB7=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine7ButB7 = ~cntActLine7ButB7 + 1;
				~cntActLine7ButB7.switch(
					1, {IFAPCMn.actLine7ButB7(1);},
					2,{IFAPCMn.actLine7ButB7(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButB7);
		//Act ButC7
		~cntActLine7ButC7=0;
		~mdActLine7ButC7.free;
		~mdActLine7ButC7=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine7ButC7 = ~cntActLine7ButC7 + 1;
				~cntActLine7ButC7.switch(
					1, {IFAPCMn.actLine7ButC7(1);},
					2,{IFAPCMn.actLine7ButC7(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButC7);


		//----------
		//ActTS8
		~cntActLine8ButTS8=0;
		~mdMixActTS8.free;
		~mdMixActTS8=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine8ButTS8 = ~cntActLine8ButTS8 + 1;
				~cntActLine8ButTS8.switch(
					1,{this.actLine8ButTS8(1);},
					2,{this.actLine8ButTS8(0);}
				)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButTS8);
		//Act ButA8
		~cntActLine8ButA8=0;
		~mdActLine8ButA8.free;
		~mdActLine8ButA8=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine8ButA8 = ~cntActLine8ButA8 + 1;
				~cntActLine8ButA8.switch(
					1,{IFAPCMn.actLine8ButA8(1);},
					2,{IFAPCMn.actLine8ButA8(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButA8);
		//Act ButB8
		~cntActLine8ButB8=0;
		~mdActLine8ButB8.free;
		~mdActLine8ButB8=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine8ButB8 = ~cntActLine8ButB8 + 1;
				~cntActLine8ButB8.switch(
					1,{IFAPCMn.actLine8ButB8(1);},
					2,{IFAPCMn.actLine8ButB8(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButB8);
		//Act ButC8
		~cntActLine8ButC8=0;
		~mdActLine8ButC8.free;
		~mdActLine8ButC8=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine8ButC8 = ~cntActLine8ButC8 + 1;
				~cntActLine8ButC8.switch(
					1,{IFAPCMn.actLine8ButC8(1);},
					2,{IFAPCMn.actLine8ButC8(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButC8);

	}
	*resetLeds{
		//Track Selection Only One Function
		~apcMn.noteOn(~apcMnCh, ~actButTS1, 0); //But 1
		~apcMn.noteOn(~apcMnCh, ~actButTS2, 0); //But 2
		~apcMn.noteOn(~apcMnCh, ~actButTS3, 0); //But 3
		~apcMn.noteOn(~apcMnCh, ~actButTS4, 0); //But 4
		~apcMn.noteOn(~apcMnCh, ~actButTS5, 0); //But 5
		~apcMn.noteOn(~apcMnCh, ~actButTS6, 0); //But 6
		~apcMn.noteOn(~apcMnCh, ~actButTS7, 0); //But 7
		~apcMn.noteOn(~apcMnCh, ~actButTS8, 0); //But 8
		//Toggles Active - Times2 - Static
		~apcMn.noteOn(~apcMnCh, ~actButA1, 0); //But 1
		~apcMn.noteOn(~apcMnCh, ~actButA2, 0); //But 2
		~apcMn.noteOn(~apcMnCh, ~actButA3, 0); //But 3
		~apcMn.noteOn(~apcMnCh, ~actButA4, 0); //But 1
		~apcMn.noteOn(~apcMnCh, ~actButA5, 0); //But 2
		~apcMn.noteOn(~apcMnCh, ~actButA6, 0); //But 3
		~apcMn.noteOn(~apcMnCh, ~actButA7, 0); //But 1
		~apcMn.noteOn(~apcMnCh, ~actButA8, 0); //But 2

		~apcMn.noteOn(~apcMnCh, ~actButB1, 0); //But 1
		~apcMn.noteOn(~apcMnCh, ~actButB2, 0); //But 2
		~apcMn.noteOn(~apcMnCh, ~actButB3, 0); //But 3
		~apcMn.noteOn(~apcMnCh, ~actButB4, 0); //But 1
		~apcMn.noteOn(~apcMnCh, ~actButB5, 0); //But 2
		~apcMn.noteOn(~apcMnCh, ~actButB6, 0); //But 3
		~apcMn.noteOn(~apcMnCh, ~actButB7, 0); //But 1
		~apcMn.noteOn(~apcMnCh, ~actButB8, 0); //But 2

		~apcMn.noteOn(~apcMnCh, ~actButC1, 0); //But 1
		~apcMn.noteOn(~apcMnCh, ~actButC2, 0); //But 2
		~apcMn.noteOn(~apcMnCh, ~actButC3, 0); //But 3
		~apcMn.noteOn(~apcMnCh, ~actButC4, 0); //But 1
		~apcMn.noteOn(~apcMnCh, ~actButC5, 0); //But 2
		~apcMn.noteOn(~apcMnCh, ~actButC6, 0); //But 3
		~apcMn.noteOn(~apcMnCh, ~actButC7, 0); //But 1
		~apcMn.noteOn(~apcMnCh, ~actButC8, 0); //But 2
		/*
		~apcMn.noteOn(~apcMnCh, 24, 0); //But 3
		~apcMn.noteOn(~apcMnCh, 25, 0); //But 3
		~apcMn.noteOn(~apcMnCh, 26, 0); //But 3
		~apcMn.noteOn(~apcMnCh, 27, 0); //But 3
		~apcMn.noteOn(~apcMnCh, 28, 0); //But 3
		~apcMn.noteOn(~apcMnCh, 29, 0); //But 3
		~apcMn.noteOn(~apcMnCh, 3~apcMnCh, 0); //But 3
		~apcMn.noteOn(~apcMnCh, 31, 0); //But 3

		~apcMn.noteOn(~apcMnCh, 32, 0); //But 3
		~apcMn.noteOn(~apcMnCh, 33, 0); //But 3
		~apcMn.noteOn(~apcMnCh, 34, 0); //But 3
		~apcMn.noteOn(~apcMnCh, 35, 0); //But 3
		~apcMn.noteOn(~apcMnCh, 36, 0); //But 3
		~apcMn.noteOn(~apcMnCh, 37, 0); //But 3
		~apcMn.noteOn(~apcMnCh, 38, 0); //But 3
		~apcMn.noteOn(~apcMnCh, 39, 0); //But 3
		*/


		//Schene Launch Buttons
		~apcMn.noteOn(~apcLn1, 82, 0); //But Scene 1
		~apcMn.noteOn(~apcLn1, 83, 0); //But Scene 2
		~apcMn.noteOn(~apcLn1, 84, 0); //But Scene 3
		~apcMn.noteOn(~apcLn1, 85, 0); //But Scene 4
		~apcMn.noteOn(~apcLn1, 86, 0); //But Scene 5
		~apcMn.noteOn(~apcLn1, 87, 0); //But Scene 6
		~apcMn.noteOn(~apcLn1, 88, 0); //But Scene 7
		~apcMn.noteOn(~apcLn1, 89, 0); //But Scene 8

	}
}

/*

~apcMn = MIDIOut.newByName("Akai APC40", "Akai APC40");


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
~apcMn.noteOn(0, 48, 127);
},
2,{
~actHat.source=0;
~tOSCAdrr.sendMsg('activHat', 0);
~apcMn.noteOff(0, 48, 127);
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
~apcMn.noteOn(0, 49, 127);
~tOSCAdrr.sendMsg('time2Hat', 1);
~tOSCAdrr.sendMsg('tmHatLabel', 2);
~tmMulHat.source = Pseq([2], inf);
},
2,{
~apcMn.noteOff(0, 49, 127);
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
~apcMn.noteOn(0, 50, 127);

},
2,{
~apcMn.noteOff(0, 50, 127);

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
~apcMn.noteOn(3, 48, 127);
},
2,{
~actBass.source=0;
~tOSCAdrr.sendMsg('activBass', 0);
~apcMn.noteOff(3, 48, 127);
~countActBass_APC=0;
}
)}
);
},48,3,~apcMnInID);

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
~apcMn.noteOn(3, 48, 127);
},
2,{
~actBass.source=0;
~tOSCAdrr.sendMsg('activBass', 0);
~apcMn.noteOff(3, 48, 127);
~countActBass_APC=0;
}
)}
);

},1665708355,3,48,nil);


~apcMn.uid;


~apcMn.noteOn(0, 52, 0); //But 3

~apcMn.sysex(Int8Array[
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

		},srcID:~apcMnInID, chan:0, ccNum:47);
	}


*globalMode{|case|
		case.switch(
			0,{
				/*~apcMn.sysex(Int8Array[
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
				/*~apcMn.sysex(Int8Array[
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
				/*~apcMn.sysex(Int8Array[
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