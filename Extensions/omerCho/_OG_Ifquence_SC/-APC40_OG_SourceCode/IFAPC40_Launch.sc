/*
IFLoad.loadVolca;


PostAllMIDI.on;
PostAllMIDI.off;


IFAPC40_Launch.globals;

IFAPC40_Launch.resetLeds;
IFAPC40_Launch.makeNoteResponders;

*/

IFAPC40_Launch{
	*load{
		this.globals;
		this.resetLeds;
		//this.makeNoteResponders;

	}//loadAtStart

	*globals{
		~stpBut1=56;~stpBut2=57;~stpBut3=58;~stpBut4=59;
		~stpBut5=60;~stpBut6=61;~stpBut7=62;~stpBut8=63;
		~stpBut9=48;~stpBut10=49;~stpBut11=50;~stpBut12=51;
		~stpBut13=52;~stpBut14=53;~stpBut15=54;~stpBut16=55;


		~apcMnCh=0;
		~lnchBut1=0;~lnchBut2=1;~lnchBut3=2;~lnchBut4=3;
		~lnchBut5=4;~lnchBut6=5;~lnchBut7=6;~lnchBut8=7;

		~lnchBut9=8;~lnchBut10=9;~lnchBut11=10;~lnchBut12=11;
		~lnchBut13=12;~lnchBut14=13;~lnchBut15=14;~lnchBut16=15;

		~lnchBut17=16;~lnchBut18=17;~lnchBut19=18;~lnchBut20=19;
		~lnchBut21=20;~lnchBut22=21;~lnchBut23=22;~lnchBut24=23;

		~lnchBut25=24;~lnchBut26=25;~lnchBut27=26;~lnchBut28=27;
		~lnchBut29=28;~lnchBut30=29;~lnchBut31=30;~lnchBut32=31;

		~lnchBut33=32;~lnchBut34=33;~lnchBut35=34;~lnchBut36=35;
		~lnchBut37=36;~lnchBut38=37;~lnchBut39=38;~lnchBut40=39;

		~lnchBut41=40;~lnchBut42=41;~lnchBut43=42;~lnchBut44=43;
		~lnchBut45=44;~lnchBut46=45;~lnchBut47=46;~lnchBut48=47;

		~lnchBut49=48;~lnchBut50=49;~lnchBut51=50;~lnchBut52=51;
		~lnchBut53=52;~lnchBut54=53;~lnchBut55=54;~lnchBut56=55;

		~lnchBut57=56;~lnchBut58=57;~lnchBut59=58;~lnchBut60=59;
		~lnchBut61=60;~lnchBut62=61;~lnchBut63=62;~lnchBut64=63;



	}//globals

	//Notes
	*makeNoteResponders{
		//NoteLine1
		IFAPC40_Launch.noteButL1(~lnchBut41,\lncNote_3);
		IFAPC40_Launch.noteButL1(~lnchBut42,\lncNote_2);
		IFAPC40_Launch.noteButL1(~lnchBut43,\lncNote_1);
		IFAPC40_Launch.noteButL1(~lnchBut44,\lncNote00);
		IFAPC40_Launch.noteButL1(~lnchBut45,\lncNote01);
		IFAPC40_Launch.noteButL1(~lnchBut46,\lncNote02);
		IFAPC40_Launch.noteButL1(~lnchBut47,\lncNote03);
		IFAPC40_Launch.noteButL1(~lnchBut48,\lncNote04);
		//NoteLine2
		IFAPC40_Launch.noteButL2(~lnchBut33,\lncNote_6);
		IFAPC40_Launch.noteButL2(~lnchBut34,\lncNote_5);
		IFAPC40_Launch.noteButL2(~lnchBut35,\lncNote_4);
		IFAPC40_Launch.noteButL2(~lnchBut36,\lncShufAll);
		IFAPC40_Launch.noteButL2(~lnchBut37,\lncNote05);
		IFAPC40_Launch.noteButL2(~lnchBut38,\lncNote06);
		IFAPC40_Launch.noteButL2(~lnchBut39,\lncNote07);
		IFAPC40_Launch.noteButL2(~lnchBut40,\lncNote08);
		//NoteLine3
		IFAPC40_Launch.noteButL3(~lnchBut25,\lncShufKick);
		IFAPC40_Launch.noteButL3(~lnchBut26,\lncShufSnr);
		IFAPC40_Launch.noteButL3(~lnchBut27,\lncShufHat);
		IFAPC40_Launch.noteButL3(~lnchBut28,\lncShufDrum);
		IFAPC40_Launch.noteButL3(~lnchBut29,\lncShufBass);
		IFAPC40_Launch.noteButL3(~lnchBut30,\lncShufKeys);
		IFAPC40_Launch.noteButL3(~lnchBut31,\lncShufSamp);
		IFAPC40_Launch.noteButL3(~lnchBut32,\lncNote11);


	}
	*noteButL1{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lnchBut41,{
					~local.sendMsg('nt-3', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut41, 2); //But 1
				},
				~lnchBut42,{
					~local.sendMsg('nt-2', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut42, 2); //But 1
				},
				~lnchBut43,{
					~local.sendMsg('nt-1', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut43, 2); //But 1
				},
				~lnchBut44,{
					~local.sendMsg('nt_0', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut44, 4); //But 1
				},
				~lnchBut45,{
					~local.sendMsg('nt_1', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut45, 2); //But 1
				},
				~lnchBut46,{
					~local.sendMsg('nt_2', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut46, 2); //But 1
				},
				~lnchBut47,{
					~local.sendMsg('nt_3', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut47, 2); //But 1
				},
				~lnchBut48,{
					~local.sendMsg('nt_4', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut48, 2); //But 1
				}
			);

		},srcID:~apc40InID, chan:~apcMnCh,noteNum:ntNum);
	}

	*noteButL2{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lnchBut33,{
					~local.sendMsg('nt-6', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut33, 2); //But 1
				},
				~lnchBut34,{
					~local.sendMsg('nt-5', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut34, 2); //But 1
				},
				~lnchBut35,{
					~local.sendMsg('nt-4', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut35, 2); //But 1
				},
				~lnchBut36,{/////---------------Shuf
					~local.sendMsg('shufMelHarm', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcMnCh, ~lnchBut36, 6); //But 1
				},
				~lnchBut37,{
					~local.sendMsg('nt_5', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut37, 2); //But 1
				},
				~lnchBut38,{
					~local.sendMsg('nt_6', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut38, 2); //But 1
				},
				~lnchBut39,{
					~local.sendMsg('nt_7', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut39, 2); //But 1
				},
				~lnchBut40,{
					~local.sendMsg('nt_8', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut40, 2); //But 1
				}
			);

		},srcID:~apc40InID, chan:~apcMnCh,noteNum:ntNum);
	}

	*noteButL3{|ntNum, nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lnchBut25,{
					~local.sendMsg('shufKick', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcMnCh, ~~lnchBut25, 2); //But 1
				},
				~lnchBut26,{
					~local.sendMsg('shufSnr', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcMnCh, ~~lnchBut26, 2); //But 1
				},
				~lnchBut27,{
					~local.sendMsg('shufHat', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcMnCh, ~~lnchBut27, 2); //But 1
				},
				~lnchBut28,{/////---------------Shuf
					~local.sendMsg('shufDrumHarm', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcMnCh, ~~lnchBut28, 6); //But 1
				},
				~lnchBut29,{
					~local.sendMsg('shufBass', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcMnCh, ~~lnchBut29, 2); //But 1
				},
				~lnchBut30,{
					~local.sendMsg('shufKeys', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcMnCh, ~~lnchBut30, 2); //But 1
				},
				~lnchBut31,{
					~local.sendMsg('shufSamp', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcMnCh, ~~lnchBut31, 2); //But 1
				},
				~lnchBut32,{
					~local.sendMsg('nt_11', 1);
					//this.noteButsReset;
					~apc40.noteOn(~apcMnCh, ~lnchBut32, 2); //But 1
				}
			);

		},srcID:~apc40InID, chan:~apcMnCh,noteNum:ntNum);
	}

	*noteButsReset{
		//Notes
		//Lounch 3
		~apc40.noteOn(~apcMnCh, ~lnchBut41, 1); //But 1
		~apc40.noteOn(~apcMnCh, ~lnchBut42, 1); //But 2
		~apc40.noteOn(~apcMnCh, ~lnchBut43, 1); //But 3
		~apc40.noteOn(~apcMnCh, ~lnchBut44, 3); //But 4
		~apc40.noteOn(~apcMnCh, ~lnchBut45, 1); //But 5
		~apc40.noteOn(~apcMnCh, ~lnchBut46, 1); //But 6
		~apc40.noteOn(~apcMnCh, ~lnchBut47, 1); //But 7
		~apc40.noteOn(~apcMnCh, ~lnchBut48, 1); //But 8
		//Lounch 4
		~apc40.noteOn(~apcMnCh, ~lnchBut33, 1); //But 1
		~apc40.noteOn(~apcMnCh, ~lnchBut34, 1); //But 2
		~apc40.noteOn(~apcMnCh, ~lnchBut35, 1); //But 3
		//~apc40.noteOn(~apcMnCh, ~lnchBut36, 5); //But 4
		~apc40.noteOn(~apcMnCh, ~lnchBut37, 1); //But 5
		~apc40.noteOn(~apcMnCh, ~lnchBut38, 1); //But 6
		~apc40.noteOn(~apcMnCh, ~lnchBut39, 1); //But 7
		~apc40.noteOn(~apcMnCh, ~lnchBut40, 1); //But 8
		//Lounch 5
		//~apc40.noteOn(~apcMnCh, ~lnchBut25, 5); //But 1
		//~apc40.noteOn(~apcMnCh, ~lnchBut26, 5); //But 2
		//~apc40.noteOn(~apcMnCh, ~lnchBut27, 5); //But 3
		//~apc40.noteOn(~apcMnCh, ~lnchBut28, 5); //But 4
		//~apc40.noteOn(~apcMnCh, ~lnchBut29, 1); //But 5
		//~apc40.noteOn(~apcMnCh, ~lnchBut30, 1); //But 6
		//~apc40.noteOn(~apcMnCh, ~lnchBut31, 1); //But 7
		~apc40.noteOn(~apcMnCh, ~lnchBut32, 1); //But 8
	}
	////////////////////////
	//Step Sequencer Sixteen
	*makeStepResponders{

		IFAPC40_Launch.button01(~stpBut1,\lncStepOn01, \lncStepOff01);
		IFAPC40_Launch.button01(~stpBut2,\lncStepOn02, \lncStepOff02);
		IFAPC40_Launch.button01(~stpBut3,\lncStepOn03, \lncStepOff03);
		IFAPC40_Launch.button01(~stpBut4,\lncStepOn04, \lncStepOff04);
		IFAPC40_Launch.button01(~stpBut5,\lncStepOn05, \lncStepOff05);
		IFAPC40_Launch.button01(~stpBut6,\lncStepOn06, \lncStepOff06);
		IFAPC40_Launch.button01(~stpBut7,\lncStepOn07, \lncStepOff07);
		IFAPC40_Launch.button01(~stpBut8,\lncStepOn08, \lncStepOff08);

		IFAPC40_Launch.button02(~stpBut9,\lncStepOn09, \lncStepOff09);
		IFAPC40_Launch.button02(~stpBut10,\lncStepOn10, \lncStepOff10);
		IFAPC40_Launch.button02(~stpBut11,\lncStepOn11, \lncStepOff11);
		IFAPC40_Launch.button02(~stpBut12,\lncStepOn12, \lncStepOff12);
		IFAPC40_Launch.button02(~stpBut13,\lncStepOn13, \lncStepOff13);
		IFAPC40_Launch.button02(~stpBut14,\lncStepOn14, \lncStepOff14);
		IFAPC40_Launch.button02(~stpBut15,\lncStepOn15, \lncStepOff15);
		IFAPC40_Launch.button02(~stpBut16,\lncStepOn16, \lncStepOff16);

	}

	*button01{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~stpBut1,{~local.sendMsg('seqStep0l', 1);},
				~stpBut2,{~local.sendMsg('seqStep02', 1);},
				~stpBut3,{~local.sendMsg('seqStep03', 1);},
				~stpBut4,{~local.sendMsg('seqStep04', 1);},
				~stpBut4,{~local.sendMsg('seqStep05', 1);},
				~stpBut62,{~local.sendMsg('seqStep06', 1);},
				~stpBut63,{~local.sendMsg('seqStep07', 1);},
				~stpBut64,{~local.sendMsg('seqStep08', 1);}
			);

		},srcID:~apc40InID, chan:0,noteNum:ntNum);

		MIDIdef.noteOff(nameOff, {
			arg chan,noteNum;

			ntNum.switch(
				~stpBut1,{~local.sendMsg('seqStep0l', 0);},
				~stpBut2,{~local.sendMsg('seqStep02', 0);},
				~stpBut3,{~local.sendMsg('seqStep03', 0);},
				~stpBut4,{~local.sendMsg('seqStep04', 0);},
				~stpBut4,{~local.sendMsg('seqStep05', 0);},
				~stpBut62,{~local.sendMsg('seqStep06', 0);},
				~stpBut63,{~local.sendMsg('seqStep07', 0);},
				~stpBut64,{~local.sendMsg('seqStep08', 0);}
			);

		},srcID:~apc40InID, chan:0,noteNum:ntNum);
	}
	*button02{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~stpBut49,{~local.sendMsg('seqStep09', 1);},
				~stpBut50,{~local.sendMsg('seqStep10', 1);},
				~stpBut51,{~local.sendMsg('seqStep11', 1);},
				~stpBut52,{~local.sendMsg('seqStep12', 1);},
				~stpBut53,{~local.sendMsg('seqStep13', 1);},
				~stpBut54,{~local.sendMsg('seqStep14', 1);},
				~stpBut55,{~local.sendMsg('seqStep15', 1);},
				~stpBut56,{~local.sendMsg('seqStep16', 1);}
			);

		},srcID:~apc40InID, chan:0,noteNum:ntNum);

		MIDIdef.noteOff(nameOff, {
			arg chan,noteNum;

			ntNum.switch(
				~stpBut49,{~local.sendMsg('seqStep09', 0);},
				~stpBut50,{~local.sendMsg('seqStep10', 0);},
				~stpBut51,{~local.sendMsg('seqStep11', 0);},
				~stpBut52,{~local.sendMsg('seqStep12', 0);},
				~stpBut53,{~local.sendMsg('seqStep13', 0);},
				~stpBut54,{~local.sendMsg('seqStep14', 0);},
				~stpBut55,{~local.sendMsg('seqStep15', 0);},
				~stpBut56,{~local.sendMsg('seqStep16', 0);}
			);

		},srcID:~apc40InID, chan:0,noteNum:ntNum);
	}

	*led{|index|

		index.switch(
			1,{this.ledOnOff(~stpBut1);},
			2,{this.ledOnOff(~stpBut2);},
			3,{this.ledOnOff(~stpBut3);},
			4,{this.ledOnOff(~stpBut4);},
			5,{this.ledOnOff(~stpBu5);},
			6,{this.ledOnOff(~stpBut6);},
			7,{this.ledOnOff(~stpBut7);},
			8,{this.ledOnOff(~stpBut8);},

			9,{this.ledOnOff(~stpBut9);},
			10,{this.ledOnOff(~stpBut10);},
			11,{this.ledOnOff(~stpBut11);},
			12,{this.ledOnOff(~stpBut12);},
			13,{this.ledOnOff(~stpBut13);},
			14,{this.ledOnOff(~stpBut14);},
			15,{this.ledOnOff(~stpBut15);},
			16,{this.ledOnOff(~stpBut16);}
		);
	}
	*ledOnOff {|ntNum|
		ntNum.switch(
			~stpBut1,{
				this.ledForkRed(~stpBut1);
			},
			~stpBut2,{
				this.ledForkYellow(~stpBut2);
			},
			~stpBut3,{
				this.ledForkYellow(~stpBut3);
			},
			~stpBut4,{
				this.ledForkYellow(~stpBut4);
			},
			~stpBut5,{
				this.ledForkRed(~stpBut5);
			},
			~stpBut6,{
				this.ledForkYellow(~stpBut6);
			},
			~stpBut7,{
				this.ledForkYellow(~stpBut7);
			},
			~stpBut8,{
				this.ledForkYellow(~stpBut8);
			},
			~stpBu9,{
				this.ledForkRed(~stpBut9);
			},
			~stpBu10,{
				this.ledForkYellow(~stpBut10);
			},
			~stpBu11,{
				this.ledForkYellow(~stpBut11);
			},
			~stpBu12,{
				this.ledForkYellow(~stpBut12);
			},
			~stpBu13,{
				this.ledForkRed(~stpBut13);
			},
			~stpBu14,{
				this.ledForkYellow(~stpBut14);
			},
			~stpBu15,{
				this.ledForkYellow(~stpBut15);
			},
			~stpBu16,{
				this.ledForkYellow(~stpBut16);
			}



		)

	}
	*ledForkRed{|ntNum|
		fork{
			~apc40.noteOn(0, ntNum, 0);
			0.3.wait;
			~apc40.noteOn(0, ntNum, 3);
		};
	}
	*ledForkYellow{|ntNum|
		fork{
			~apc40.noteOn(0, ntNum, 0);
			0.3.wait;
			~apc40.noteOn(0, ntNum, 5);
		};
	}
	*ledForkGreen{|ntNum|
		fork{
			~apc40.noteOn(0, ntNum, 0);
			0.3.wait;
			~apc40.noteOn(0, ntNum, 1);
		};
	}
	/*
	IFAPC40_Launch.resetLeds;
	*/
	*resetLeds{
		//Sequencer
		//Lounch
		~apc40.noteOn(~apcMnCh, ~stpBut1, 0); //But 1
		~apc40.noteOn(~apcMnCh, ~stpBut2, 0); //But 2
		~apc40.noteOn(~apcMnCh, ~stpBut3, 0); //But 3
		~apc40.noteOn(~apcMnCh, ~stpBut4, 0); //But 4

		~apc40.noteOn(~apcMnCh, ~stpBut5, 0); //But 5
		~apc40.noteOn(~apcMnCh, ~stpBut6, 0); //But 6
		~apc40.noteOn(~apcMnCh, ~stpBut7, 0); //But 7
		~apc40.noteOn(~apcMnCh, ~stpBut8, 0); //But 8
		//Lounch 2
		~apc40.noteOn(~apcMnCh, ~stpBut9, 0); //But 1
		~apc40.noteOn(~apcMnCh, ~stpBut10, 0); //But 2
		~apc40.noteOn(~apcMnCh, ~stpBut11, 0); //But 3
		~apc40.noteOn(~apcMnCh, ~stpBut12, 0); //But 4

		~apc40.noteOn(~apcMnCh, ~stpBut13, 0); //But 5
		~apc40.noteOn(~apcMnCh, ~stpBut14, 0); //But 6
		~apc40.noteOn(~apcMnCh, ~stpBut15, 0); //But 7
		~apc40.noteOn(~apcMnCh, ~stpBut16, 0); //But 8

		//Notes
		//Lounch 3
		~apc40.noteOn(~apcMnCh, 40, 0); //But 1
		~apc40.noteOn(~apcMnCh, 41, 0); //But 2
		~apc40.noteOn(~apcMnCh, 42, 0); //But 3
		~apc40.noteOn(~apcMnCh, 43, 0); //But 4
		~apc40.noteOn(~apcMnCh, 44, 0); //But 5
		~apc40.noteOn(~apcMnCh, 45, 0); //But 6
		~apc40.noteOn(~apcMnCh, 46, 0); //But 7
		~apc40.noteOn(~apcMnCh, 47, 0); //But 8
		//Lounch 4
		~apc40.noteOn(~apcMnCh, 32, 0); //But 1
		~apc40.noteOn(~apcMnCh, 33, 0); //But 2
		~apc40.noteOn(~apcMnCh, 34, 0); //But 3
		~apc40.noteOn(~apcMnCh, 35, 0); //But 4
		~apc40.noteOn(~apcMnCh, 36, 0); //But 5
		~apc40.noteOn(~apcMnCh, 37, 0); //But 6
		~apc40.noteOn(~apcMnCh, 38, 0); //But 7
		~apc40.noteOn(~apcMnCh, 39, 0); //But 8
		//Lounch 5
		~apc40.noteOn(~apcMnCh, 24, 0); //But 1
		~apc40.noteOn(~apcMnCh, 25, 0); //But 2
		~apc40.noteOn(~apcMnCh, 26, 0); //But 3
		~apc40.noteOn(~apcMnCh, 27, 0); //But 4
		~apc40.noteOn(~apcMnCh, 28, 0); //But 5
		~apc40.noteOn(~apcMnCh, 29, 0); //But 6
		~apc40.noteOn(~apcMnCh, 30, 0); //But 7
		~apc40.noteOn(~apcMnCh, 31, 0); //But 8


	}
}

/*



*/