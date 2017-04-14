/*
PostAllMIDI.on;
PostAllMIDI.off;
IFAPC40.loadSource;
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
		this.resetLeds;
		this.shiftButton;
		this.cueNob;
		this.globalMode(1);
		this.nobDown(mode:1);
		~ndModeCase=1;
		this.update;
	}//loadAtStart

	*update{

		~ndModeCase.switch(
			1,{
				~apc40.control(0, ~nobD1, ~nobD1_m1Val);
				~apc40.control(0, ~nobD2, ~nobD2_m1Val);
				~apc40.control(0, ~nobD3, ~nobD3_m1Val);
				~apc40.control(0, ~nobD4, ~nobD4_m1Val);
				~apc40.control(0, ~nobD5, ~nobD5_m1Val);
				~apc40.control(0, ~nobD6, ~nobD6_m1Val);
				~apc40.control(0, ~nobD7, ~nobD7_m1Val);
				~apc40.control(0, ~nobD8, ~nobD8_m1Val);
			},
			2,{

				~apc40.control(0, ~nobD1, ~nobD1_m2Val);
				~apc40.control(0, ~nobD2, ~nobD2_m2Val);
				~apc40.control(0, ~nobD3, ~nobD3_m2Val);
				~apc40.control(0, ~nobD4, ~nobD4_m2Val);
				~apc40.control(0, ~nobD5, ~nobD5_m2Val);
				~apc40.control(0, ~nobD6, ~nobD6_m2Val);
				~apc40.control(0, ~nobD7, ~nobD7_m2Val);
				~apc40.control(0, ~nobD8, ~nobD8_m2Val);


			}
		);


	}
	*globals{
		//channels
		~apcLine1=0;
		~apcLine2=1;
		~apcLine3=2;
		~apcLine4=3;
		~apcLine5=4;
		~apcLine6=5;
		~apcLine7=6;
		~apcLine8=7;
		~apcLineMaster=0;
		//Nums
		~actButA=48;~actButB=49;~actButC=50;
		~tsBut=51;
		~apcPlayBut=91;
		~apcStopBut=91;
		~apcRecBut=91;
		//NobDownn Nums
		~nobD1=16;~nobD2=17;~nobD3=18;~nobD4=19;
		~nobD5=20;~nobD6=21;~nobD7=22;~nobD8=23;
		~nD_m1Num=58;
		~nD_m2Num=59;
		~nD_m3Num=60;
		~nD_m4Num=61;
		~nD_m5Num=62;
		~nD_m6Num=63;
		~nD_m7Num=64;
		~nD_m8Num=65;
		//Proxies-------------------
		//mode:1
		~nobD1_m1Val=0;~nobD2_m1Val=0;~nobD3_m1Val=0;~nobD4_m1Val=0;
		~nobD5_m1Val=0;~nobD6_m1Val=0;~nobD7_m1Val=0;~nobD8_m1Val=0;
		//mode:2
		~nobD1_m2Val=0;
		~nobD2_m2Val=0;
		~nobD3_m2Val=0;
		~nobD4_m2Val=0;
		~nobD5_m2Val=0;
		~nobD6_m2Val=0;
		~nobD7_m2Val=0;
		~nobD8_m2Val=0;


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
				},
				126,{},
				125,{},
				2,{},
				3,{}
			);

		},srcID:~apc40InID, chan:0, ccNum:47);
	}

	*nobModes{|mode|
		~nobModes_APC.free;
		~nobModes_APC=MIDIFunc.cc( {
			arg vel,ccNum;

			ccNum.switch(
				~nD_m1Num,{
					"nobDown Mode 1".postln;
					~ndModeCase=1;
				},
				~nD_m2Num,{
					"nobDown Mode 2".postln;
					~ndModeCase=2;
				},
				~nD_m3Num,{"M1_3".postln+vel.postln;},
				~nD_m4Num,{"M1_4".postln+vel.postln;},
				~nD_m5Num,{"M1_5".postln+vel.postln;},
				~nD_m6Num,{"M1_6".postln+vel.postln;},
				~nD_m7Num,{"M1_7".postln+vel.postln;},
				~nD_m8Num,{"M1_8".postln+vel.postln;}
			);

		},srcID:~apc40InID, chan:0);

	}

	*nobDown{|mode|
		mode.switch(
			1,{
				IFAPC40.ndButLeds(1,0,0,0,0,0,0,0);
				IFAPC40.nobDown_M1(1,~nobD1_m1Val);
				IFAPC40.nobDown_M1(2,~nobD2_m1Val);
				~apc40.control(0, ~nobD1, ~nobD1_m1Val); //NobDown 1
				~nobDown_APC.free;
				~nobDown_APC=MIDIFunc.cc( {
					arg vel,ccNum;

					ccNum.switch(
						16,{
							"M1_1".postln+vel.postln;
							IFAPC40.nobDown_M1(index:1, val:vel);

						},
						17,{
							"M1_2".postln+vel.postln;
							IFAPC40.nobDown_M1(index:2, val:vel);
						},
						18,{"M1_3".postln+vel.postln;},
						19,{"M1_4".postln+vel.postln;},
						20,{"M1_5".postln+vel.postln;},
						21,{"M1_6".postln+vel.postln;},
						22,{"M1_7".postln+vel.postln;},
						23,{"M1_8".postln+vel.postln;}
					);

				},srcID:~apc40InID, chan:0);
			},
			2,{
				IFAPC40.ndButLeds(0,1,0,0,0,0,0,0);
				IFAPC40.nobDown_M2(~nobD1_m2Val);
				~apc40.control(0, ~nobD1, ~nobD1_m2Val); //NobDown 1
				~nobDown_APC.free;
				~nobDown_APC=MIDIFunc.cc( {
					arg vel,ccNum;

					ccNum.switch(
						16,{
							"M2_1".postln+vel.postln;
							IFAPC40.nobDown_M2(1,vel);

						},
						17,{
							"M2_2".postln+vel.postln;
							IFAPC40.nobDown_M2(2,vel);
						},
						18,{"M2_3".postln+vel.postln;},
						19,{"M2_4".postln+vel.postln;},
						20,{"M2_5".postln+vel.postln;},
						21,{"M2_6".postln+vel.postln;},
						22,{"M2_7".postln+vel.postln;},
						23,{"M2_8".postln+vel.postln;}
					);

				},srcID:~apc40InID, chan:0);
			},
		);

	}
	//NobDown Mode:1
	*nobDown_M1{|index,val|
		val= val/127;
		index.switch(
			1,{
				~local.sendMsg('decKick', val);
				//~nobD1_m1Val=val;

			},
			2,{
				~local.sendMsg('decSnr', val);
				//~nobD2_m1Val=val;
			},
			3,{
				~local.sendMsg('decHat', val);
				//~nobD2_m1Val=val;
			},
			5,{
				~local.sendMsg('decBass', val);
				//~nobD2_m1Val=val;
			},
			6,{
				~local.sendMsg('decKeys', val);
				~local.sendMsg('susKeys', val*0.5);
				//~nobD2_m1Val=val;
			},
			7,{
				~local.sendMsg('decSamp', val/127);
				//~nobD2_m1Val=val;
			},
			4,{
				~local.sendMsg('decSnr', val/127);
				//~nobD2_m1Val=val;
			},
			8,{
				~local.sendMsg('decSnr', val/127);
				//~nobD2_m1Val=val;
			},
		);
	}
	//NobDown Mode:2
	*nobDown_M2{|index,val|
		"MODE 2 Works".postln;
		index.switch(
			1,{
				~local.sendMsg('attKick', val/127);
				//~nobD1_m2Val=val;

			},
			2,{
				~local.sendMsg('attSnr', val/127);
				//~nobD2_m2Val=val;
			},
		);
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
		~apc40.noteOn(~apcLine1, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activKick', val);
		~actKick.source=val;
		~cntActLine1ButA=val;
	}
	*actLine1ButB{|val|
		~apc40.noteOn(~apcLine1, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Kick', val);
		~tmMulKick.source = Pseq([val+1], inf);
		~cntActLine1ButB=val;
	}
	*actLine1ButC{|val|
		~apc40.noteOn(~apcLine1, ~actButC, val); //But C
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
		~apc40.noteOn(~apcLine2, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activSnr', val);
		~actSnr.source=val;
		~cntActLine2ButA=val;
	}
	*actLine2ButB{|val|
		~apc40.noteOn(~apcLine2, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Snr', val);
		~tmMulSnr.source = Pseq([val+1], inf);
		~cntActLine2ButB=val;
	}
	*actLine2ButC{|val|
		~apc40.noteOn(~apcLine2, ~actButC, val); //But C
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
		~apc40.noteOn(~apcLine3, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activHat', val);
		~actHat.source=val;
		~cntActLine3ButA=val;
	}
	*actLine3ButB{|val|
		~apc40.noteOn(~apcLine3, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Hat', val);
		~tmMulHat.source = Pseq([val+1], inf);
		~cntActLine3ButB=val;
	}
	*actLine3ButC{|val|
		~apc40.noteOn(~apcLine3, ~actButC, val); //But C
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
		~apc40.noteOn(~apcLine4, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activBass', val);
		~actBass.source=val;
		~cntActLine4ButA=val;
	}
	*actLine4ButB{|val|
		~apc40.noteOn(~apcLine4, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Bass', val);
		~tmMulBass.source = Pseq([val+1], inf);
		~cntActLine4ButB=val;
	}
	*actLine4ButC{|val|
		~apc40.noteOn(~apcLine4, ~actButC, val); //But C
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
		~apc40.noteOn(~apcLine5, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activKeys', val);
		~actKeys.source=val;
		~cntActLine5ButA=val;
	}
	*actLine5ButB{|val|
		~apc40.noteOn(~apcLine5, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Keys', val);
		~tmMulKeys.source = Pseq([val+1], inf);
		~cntActLine5ButB=val;
	}
	*actLine5ButC{|val|
		~apc40.noteOn(~apcLine5, ~actButC, val); //But C
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
		~apc40.noteOn(~apcLine6, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activSamp', val);
		~actSamp.source=val;
		~cntActLine6ButA=val;
	}
	*actLine6ButB{|val|
		~apc40.noteOn(~apcLine6, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Samp', val);
		~tmMulSamp.source = Pseq([val+1], inf);
		~cntActLine6ButB=val;
	}
	*actLine6ButC{|val|
		~apc40.noteOn(~apcLine6, ~actButC, val); //But C
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
		~apc40.noteOn(~apcLine7, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activMast', val);
		~actMast.source=val;
		~cntActLine7ButA=val;
	}
	*actLine7ButB{|val|
		~apc40.noteOn(~apcLine7, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Mast', val);
		~tmMulMast.source = Pseq([val+1], inf);
		~cntActLine7ButB=val;
	}
	*actLine7ButC{|val|
		~apc40.noteOn(~apcLine7, ~actButC, val); //But C
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
		~apc40.noteOn(~apcLine8, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activRes1', val);
		~actRes1.source=val;
		~cntActLine8ButA=val;
	}
	*actLine8ButB{|val|
		~apc40.noteOn(~apcLine8, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Res1', val);
		~tmMulRes1.source = Pseq([val+1], inf);
		~cntActLine8ButB=val;
	}
	*actLine8ButC{|val|
		~apc40.noteOn(~apcLine8, ~actButC, val); //But C
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
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS03.free;
		~apc_TS03=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack03.loadAtStart;
			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS04.free;
		~apc_TS04=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS05.free;
		~apc_TS05=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS06.free;
		~apc_TS06=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS07.free;
		~apc_TS07=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS08.free;
		~apc_TS08=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:51);

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
		~apc40.noteOn(~apcLine1, ~tsBut, led1); //But 1
		~apc40.noteOn(~apcLine2, ~tsBut, led2); //But 2
		~apc40.noteOn(~apcLine3, ~tsBut, led3); //But 3
		~apc40.noteOn(~apcLine4, ~tsBut, led4); //But 4
		~apc40.noteOn(~apcLine5, ~tsBut, led5); //But 5
		~apc40.noteOn(~apcLine6, ~tsBut, led6); //But 6
		~apc40.noteOn(~apcLine7, ~tsBut, led7); //But 7
		~apc40.noteOn(~apcLine8, ~tsBut, led8); //But 8
	}
	*ndButLed{|cc=1,led|
		~apc40.noteOn(0, 57+cc, led);
	}
	*ndButLeds{|led1,led2,led3,led4,led5,led6,led7,led8|
		~apc40.noteOn(0, 58, led1); //But 1
		~apc40.noteOn(0, 59, led2); //But 2
		~apc40.noteOn(0, 60, led3); //But 3
		~apc40.noteOn(0, 61, led4); //But 4
		~apc40.noteOn(0, 62, led5); //But 5
		~apc40.noteOn(0, 63, led6); //But 6
		~apc40.noteOn(0, 64, led7); //But 7
		~apc40.noteOn(0, 65, led8); //But 8
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
		//Lounch 1
		~apc40.noteOn(0, 53, 0); //But 1
		~apc40.noteOn(1, 53, 0); //But 2
		~apc40.noteOn(2, 53, 0); //But 3
		~apc40.noteOn(3, 53, 0); //But 4
		~apc40.noteOn(4, 53, 0); //But 5
		~apc40.noteOn(5, 53, 0); //But 6
		~apc40.noteOn(6, 53, 0); //But 7
		~apc40.noteOn(7, 53, 0); //But 8
		~apc40.noteOn(0, 82, 0); //But Scene 1
		//Lounch 2
		~apc40.noteOn(0, 54, 0); //But 1
		~apc40.noteOn(1, 54, 0); //But 2
		~apc40.noteOn(2, 54, 0); //But 3
		~apc40.noteOn(3, 54, 0); //But 4
		~apc40.noteOn(4, 54, 0); //But 5
		~apc40.noteOn(5, 54, 0); //But 6
		~apc40.noteOn(6, 54, 0); //But 7
		~apc40.noteOn(7, 54, 0); //But 8
		~apc40.noteOn(0, 83, 0); //But Scene 2
		//Lounch 3
		~apc40.noteOn(0, 55, 0); //But 1
		~apc40.noteOn(1, 55, 0); //But 2
		~apc40.noteOn(2, 55, 0); //But 3
		~apc40.noteOn(3, 55, 0); //But 4
		~apc40.noteOn(4, 55, 0); //But 5
		~apc40.noteOn(5, 55, 0); //But 6
		~apc40.noteOn(6, 55, 0); //But 7
		~apc40.noteOn(7, 55, 0); //But 8
		~apc40.noteOn(0, 84, 0); //But Scene 3
		//Lounch 4
		~apc40.noteOn(0, 56, 0); //But 1
		~apc40.noteOn(1, 56, 0); //But 2
		~apc40.noteOn(2, 56, 0); //But 3
		~apc40.noteOn(3, 56, 0); //But 4
		~apc40.noteOn(4, 56, 0); //But 5
		~apc40.noteOn(5, 56, 0); //But 6
		~apc40.noteOn(6, 56, 0); //But 7
		~apc40.noteOn(7, 56, 0); //But 8
		~apc40.noteOn(0, 85, 0); //But Scene 4
		//Lounch 5
		~apc40.noteOn(0, 57, 0); //But 1
		~apc40.noteOn(1, 57, 0); //But 2
		~apc40.noteOn(2, 57, 0); //But 3
		~apc40.noteOn(3, 57, 0); //But 4
		~apc40.noteOn(4, 57, 0); //But 5
		~apc40.noteOn(5, 57, 0); //But 6
		~apc40.noteOn(6, 57, 0); //But 7
		~apc40.noteOn(7, 57, 0); //But 8
		~apc40.noteOn(0, 86, 0); //But Scene 5
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