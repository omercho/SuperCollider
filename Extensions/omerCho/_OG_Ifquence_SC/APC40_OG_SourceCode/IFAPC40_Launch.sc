/*
IFLoad.loadVolca;


PostAllMIDI.on;
PostAllMIDI.off;


IFAPC40_Launch.button()

*/

IFAPC40_Launch{
	*load{
		this.globals;
		this.resetLeds;
		this.makeNoteResponders;
		this.makeStepResponders;

	}//loadAtStart

	*globals{

		~apcLn1=0;~apcLn2=1;~apcLn3=2;~apcLn4=3;
		~apcLn5=4;~apcLn6=5;~apcLn7=6;~apcLn8=7;

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


		/*IFAPC40_Launch.button02(~apcLn1,\lncNoteOn09, \lncNoteOff09);
		IFAPC40_Launch.button02(~apcLn1,\lncNoteOn10, \lncNoteOff10);
		IFAPC40_Launch.button02(~apcLn1,\lncNoteOn11, \lncNoteOff11);
		IFAPC40_Launch.button02(~apcLn1,\lncNoteOn12, \lncNoteOff12);
		IFAPC40_Launch.button02(~apcLn1,\lncNoteOn13, \lncNoteOff13);
		IFAPC40_Launch.button02(~apcLn1,\lncNoteOn14, \lncNoteOff14);
		IFAPC40_Launch.button02(~apcLn1,\lncNoteOn15, \lncNoteOff15);
		IFAPC40_Launch.button02(~apcLn1,\lncNoteOn16, \lncNoteOff16);*/

	}
	*noteButL1{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lnchBut41,{
					~local.sendMsg('nt-3', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut41, 2); //But 1
				},
				~lnchBut42,{
					~local.sendMsg('nt-2', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut42, 2); //But 1
				},
				~lnchBut43,{
					~local.sendMsg('nt-1', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut43, 2); //But 1
				},
				~lnchBut44,{
					~local.sendMsg('nt_0', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut44, 4); //But 1
				},
				~lnchBut45,{
					~local.sendMsg('nt_1', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut45, 2); //But 1
				},
				~lnchBut46,{
					~local.sendMsg('nt_2', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut46, 2); //But 1
				},
				~lnchBut47,{
					~local.sendMsg('nt_3', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut47, 2); //But 1
				},
				~lnchBut48,{
					~local.sendMsg('nt_4', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut48, 2); //But 1
				}
			);

		},srcID:~apc40InID, chan:~apcLn1,noteNum:ntNum);

		/*MIDIdef.noteOff(nameOff, {
		arg chan,noteNum;

		ntNum.switch(
		~apcLn1,{~local.sendMsg('seqStep0l', 0);},
		~apcLn2,{~local.sendMsg('seqStep02', 0);},
		~apcLn3,{~local.sendMsg('seqStep03', 0);},
		~apcLn4,{~local.sendMsg('seqStep04', 0);},
		~apcLn5,{~local.sendMsg('seqStep05', 0);},
		~apcLn6,{~local.sendMsg('seqStep06', 0);},
		~apcLn7,{~local.sendMsg('seqStep07', 0);},
		~apcLn8,{~local.sendMsg('seqStep08', 0);}
		);

		},srcID:~apc40InID, chan:0,noteNum:~lnchBut3);*/
	}

	*noteButL2{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~apcLn1,{
					~local.sendMsg('nt-6', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut33, 2); //But 1
				},
				~lnchBut34,{
					~local.sendMsg('nt-5', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut34, 2); //But 1
				},
				~lnchBut35,{
					~local.sendMsg('nt-4', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut35, 2); //But 1
				},
				~lnchBut36,{/////---------------Shuf
					~local.sendMsg('shufMelHarm', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn1, ~lnchBut36, 6); //But 1
				},
				~lnchBut37,{
					~local.sendMsg('nt_5', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut37, 2); //But 1
				},
				~lnchBut38,{
					~local.sendMsg('nt_6', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut38, 2); //But 1
				},
				~lnchBut39,{
					~local.sendMsg('nt_7', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut39, 2); //But 1
				},
				~lnchBut40,{
					~local.sendMsg('nt_8', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut40, 2); //But 1
				}
			);

		},srcID:~apc40InID, chan:~apcLn1,noteNum:ntNum);
	}

	*noteButL3{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lnchBut24,{
					~local.sendMsg('shufKick', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn1, ~~lnchBut24, 2); //But 1
				},
				~lnchBut25,{
					~local.sendMsg('shufSnr', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn1, ~~lnchBut25, 2); //But 1
				},
				~lnchBut26,{
					~local.sendMsg('shufHat', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn1, ~~lnchBut26, 2); //But 1
				},
				~lnchBut27,{/////---------------Shuf
					~local.sendMsg('shufDrumHarm', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn1, ~~lnchBut27, 6); //But 1
				},
				~lnchBut28,{
					~local.sendMsg('shufBass', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn1, ~~lnchBut28, 2); //But 1
				},
				~lnchBut29,{
					~local.sendMsg('shufKeys', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn1, ~~lnchBut29, 2); //But 1
				},
				~lnchBut30,{
					~local.sendMsg('shufSamp', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn1, ~~lnchBut30, 2); //But 1
				},
				~lnchBut31,{
					~local.sendMsg('nt_11', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut31, 2); //But 1
				}
			);

		},srcID:~apc40InID, chan:~apcLn1,noteNum:ntNum);
	}

	*noteButsReset{
		//Notes
		//Lounch 3
		~apc40.noteOn(~apcLn1, ~lnchBut41, 1); //But 1
		~apc40.noteOn(~apcLn1, ~lnchBut42, 1); //But 2
		~apc40.noteOn(~apcLn1, ~lnchBut43, 1); //But 3
		~apc40.noteOn(~apcLn1, ~lnchBut44, 3); //But 4
		~apc40.noteOn(~apcLn1, ~lnchBut45, 1); //But 5
		~apc40.noteOn(~apcLn1, ~lnchBut46, 1); //But 6
		~apc40.noteOn(~apcLn1, ~lnchBut47, 1); //But 7
		~apc40.noteOn(~apcLn1, ~lnchBut48, 1); //But 8
		//Lounch 4
		~apc40.noteOn(~apcLn1, ~lnchBut33, 1); //But 1
		~apc40.noteOn(~apcLn1, ~lnchBut34, 1); //But 2
		~apc40.noteOn(~apcLn1, ~lnchBut35, 1); //But 3
		//~apc40.noteOn(~apcLn1, ~lnchBut36, 5); //But 4
		~apc40.noteOn(~apcLn1, ~lnchBut37, 1); //But 5
		~apc40.noteOn(~apcLn1, ~lnchBut38, 1); //But 6
		~apc40.noteOn(~apcLn1, ~lnchBut39, 1); //But 7
		~apc40.noteOn(~apcLn1, ~lnchBut40, 1); //But 8
		//Lounch 5
		//~apc40.noteOn(~apcLn1, ~lnchBut25, 5); //But 1
		//~apc40.noteOn(~apcLn1, ~lnchBut26, 5); //But 2
		//~apc40.noteOn(~apcLn1, ~lnchBut27, 5); //But 3
		//~apc40.noteOn(~apcLn1, ~lnchBut28, 5); //But 4
		//~apc40.noteOn(~apcLn1, ~lnchBut29, 1); //But 5
		//~apc40.noteOn(~apcLn1, ~lnchBut30, 1); //But 6
		//~apc40.noteOn(~apcLn1, ~lnchBut31, 1); //But 7
		~apc40.noteOn(~apcLn1, ~lnchBut32, 1); //But 8
	}
	////////////////////////
	//Step Sequencer Sixteen
	*makeStepResponders{

		IFAPC40_Launch.button01(~lnchBut57,\lncStepOn01, \lncStepOff01);
		IFAPC40_Launch.button01(~lnchBut58,\lncStepOn02, \lncStepOff02);
		IFAPC40_Launch.button01(~lnchBut59,\lncStepOn03, \lncStepOff03);
		IFAPC40_Launch.button01(~lnchBut60,\lncStepOn04, \lncStepOff04);
		IFAPC40_Launch.button01(~lnchBut61,\lncStepOn05, \lncStepOff05);
		IFAPC40_Launch.button01(~lnchBut62,\lncStepOn06, \lncStepOff06);
		IFAPC40_Launch.button01(~lnchBut63,\lncStepOn07, \lncStepOff07);
		IFAPC40_Launch.button01(~lnchBut64,\lncStepOn08, \lncStepOff08);

		IFAPC40_Launch.button02(~lnchBut57,\lncStepOn09, \lncStepOff09);
		IFAPC40_Launch.button02(~lnchBut58,\lncStepOn10, \lncStepOff10);
		IFAPC40_Launch.button02(~lnchBut59,\lncStepOn11, \lncStepOff11);
		IFAPC40_Launch.button02(~lnchBut60,\lncStepOn12, \lncStepOff12);
		IFAPC40_Launch.button02(~lnchBut61,\lncStepOn13, \lncStepOff13);
		IFAPC40_Launch.button02(~lnchBut62,\lncStepOn14, \lncStepOff14);
		IFAPC40_Launch.button02(~lnchBut63,\lncStepOn15, \lncStepOff15);
		IFAPC40_Launch.button02(~lnchBut64,\lncStepOn16, \lncStepOff16);

	}

	*button01{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lnchBut57,{~local.sendMsg('seqStep0l', 1);},
				~lnchBut58,{~local.sendMsg('seqStep02', 1);},
				~lnchBut59,{~local.sendMsg('seqStep03', 1);},
				~lnchBut60,{~local.sendMsg('seqStep04', 1);},
				~lnchBut61,{~local.sendMsg('seqStep05', 1);},
				~lnchBut62,{~local.sendMsg('seqStep06', 1);},
				~lnchBut63,{~local.sendMsg('seqStep07', 1);},
				~lnchBut64,{~local.sendMsg('seqStep08', 1);}
			);

		},srcID:~apc40InID, chan:0,noteNum:ntNum);

		MIDIdef.noteOff(nameOff, {
			arg chan,noteNum;

			ntNum.switch(
				~lnchBut57,{~local.sendMsg('seqStep0l', 0);},
				~lnchBut58,{~local.sendMsg('seqStep02', 0);},
				~lnchBut59,{~local.sendMsg('seqStep03', 0);},
				~lnchBut60,{~local.sendMsg('seqStep04', 0);},
				~lnchBut61,{~local.sendMsg('seqStep05', 0);},
				~lnchBut62,{~local.sendMsg('seqStep06', 0);},
				~lnchBut63,{~local.sendMsg('seqStep07', 0);},
				~lnchBut64,{~local.sendMsg('seqStep08', 0);}
			);

		},srcID:~apc40InID, chan:0,noteNum:ntNum);
	}
	*button02{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lnchBut49,{~local.sendMsg('seqStep09', 1);},
				~lnchBut50,{~local.sendMsg('seqStep10', 1);},
				~lnchBut51,{~local.sendMsg('seqStep11', 1);},
				~lnchBut52,{~local.sendMsg('seqStep12', 1);},
				~lnchBut53,{~local.sendMsg('seqStep13', 1);},
				~lnchBut54,{~local.sendMsg('seqStep14', 1);},
				~lnchBut55,{~local.sendMsg('seqStep15', 1);},
				~lnchBut56,{~local.sendMsg('seqStep16', 1);}
			);

		},srcID:~apc40InID, chan:0,noteNum:ntNum);

		MIDIdef.noteOff(nameOff, {
			arg chan,noteNum;

			ntNum.switch(
				~lnchBut49,{~local.sendMsg('seqStep09', 0);},
				~lnchBut50,{~local.sendMsg('seqStep10', 0);},
				~lnchBut51,{~local.sendMsg('seqStep11', 0);},
				~lnchBut52,{~local.sendMsg('seqStep12', 0);},
				~lnchBut53,{~local.sendMsg('seqStep13', 0);},
				~lnchBut54,{~local.sendMsg('seqStep14', 0);},
				~lnchBut55,{~local.sendMsg('seqStep15', 0);},
				~lnchBut56,{~local.sendMsg('seqStep16', 0);}
			);

		},srcID:~apc40InID, chan:0,noteNum:ntNum);
	}

	*led{|index|

		index.switch(
			1,{this.ledOnOff(~apcLn1,~lnchBut57);},
			2,{this.ledOnOff(~apcLn1,~lnchBut58);},
			3,{this.ledOnOff(~apcLn1,~lnchBut59);},
			4,{this.ledOnOff(~apcLn1,~lnchBut60);},
			5,{this.ledOnOff(~apcLn1,~lnchBut61);},
			6,{this.ledOnOff(~apcLn1,~lnchBut62);},
			7,{this.ledOnOff(~apcLn1,~lnchBut63);},
			8,{this.ledOnOff(~apcLn1,~lnchBut64);},

			9,{this.ledOnOff(~apcLn1,~lnchBut49);},
			10,{this.ledOnOff(~apcLn1,~lnchBut50);},
			11,{this.ledOnOff(~apcLn1,~lnchBut51);},
			12,{this.ledOnOff(~apcLn1,~lnchBut52);},
			13,{this.ledOnOff(~apcLn1,~lnchBut53);},
			14,{this.ledOnOff(~apcLn1,~lnchBut54);},
			15,{this.ledOnOff(~apcLn1,~lnchBut55);},
			16,{this.ledOnOff(~apcLn1,~lnchBut56);}
		);
	}
	*ledOnOff {|line, launch|
		line.switch(
			~apcLn1,{
				this.ledForkRed(line,
					if ( launch==~lnchBut1, {~lnchBut1;},{~lnchBut2;});
				);
			},
			~apcLn2,{
				this.ledForkYellow(line,
					if ( launch==~lnchBut1, {~lnchBut1;},{~lnchBut2;});
				);
			},
			~apcLn3,{
				this.ledForkYellow(line,
					if ( launch==~lnchBut1, {~lnchBut1;},{~lnchBut2;});
				);
			},
			~apcLn4,{
				this.ledForkYellow(line,
					if ( launch==~lnchBut1, {~lnchBut1;},{~lnchBut2;});
				);
			},
			~apcLn5,{
				this.ledForkRed(line,
					if ( launch==~lnchBut1, {~lnchBut1;},{~lnchBut2;});
				);
			},
			~apcLn6,{
				this.ledForkYellow(line,
					if ( launch==~lnchBut1, {~lnchBut1;},{~lnchBut2;});
				);
			},
			~apcLn7,{
				this.ledForkYellow(line,
					if ( launch==~lnchBut1, {~lnchBut1;},{~lnchBut2;});
				);
			},
			~apcLn8,{
				this.ledForkYellow(line,
					if ( launch==~lnchBut1, {~lnchBut1;},{~lnchBut2;});
				);
			}



		)

	}
	*ledForkRed{|line, launch|
		fork{
			~apc40.noteOn(line, launch, 0); //But 1
			0.3.wait;
			~apc40.noteOn(line, launch, 3); //But 1
		};
	}
	*ledForkYellow{|line, launch|
		fork{
			~apc40.noteOn(line, launch, 0); //But 1
			0.3.wait;
			~apc40.noteOn(line, launch, 5); //But 1
		};
	}
	*ledForkGreen{|line, launch|
		fork{
			~apc40.noteOn(line, launch, 0); //But 1
			0.3.wait;
			~apc40.noteOn(line, launch, 1); //But 1
		};
	}

	*resetLeds{

		//Sequencer
		//Lounch
		~apc40.noteOn(~apcLn1, 56, 3); //But 1
		~apc40.noteOn(~apcLn1, 57, 5); //But 2
		~apc40.noteOn(~apcLn1, 58, 5); //But 3
		~apc40.noteOn(~apcLn1, 59, 5); //But 4

		~apc40.noteOn(~apcLn1, 60, 3); //But 5
		~apc40.noteOn(~apcLn1, 61, 5); //But 6
		~apc40.noteOn(~apcLn1, 62, 5); //But 7
		~apc40.noteOn(~apcLn1, 63, 5); //But 8
		//Lounch 2
		~apc40.noteOn(~apcLn1, 48, 3); //But 1
		~apc40.noteOn(~apcLn1, 49, 5); //But 2
		~apc40.noteOn(~apcLn1, 50, 5); //But 3
		~apc40.noteOn(~apcLn1, 51, 5); //But 4

		~apc40.noteOn(~apcLn1, 52, 3); //But 5
		~apc40.noteOn(~apcLn1, 53, 5); //But 6
		~apc40.noteOn(~apcLn1, 54, 5); //But 7
		~apc40.noteOn(~apcLn1, 55, 5); //But 8

		//Notes
		//Lounch 3
		~apc40.noteOn(~apcLn1, 40, 1); //But 1
		~apc40.noteOn(~apcLn1, 41, 1); //But 2
		~apc40.noteOn(~apcLn1, 42, 1); //But 3
		~apc40.noteOn(~apcLn1, 43, 3); //But 4
		~apc40.noteOn(~apcLn1, 44, 1); //But 5
		~apc40.noteOn(~apcLn1, 45, 1); //But 6
		~apc40.noteOn(~apcLn1, 46, 1); //But 7
		~apc40.noteOn(~apcLn1, 47, 1); //But 8
		//Lounch 4
		~apc40.noteOn(~apcLn1, 32, 1); //But 1
		~apc40.noteOn(~apcLn1, 33, 1); //But 2
		~apc40.noteOn(~apcLn1, 34, 1); //But 3
		~apc40.noteOn(~apcLn1, 35, 0); //But 4
		~apc40.noteOn(~apcLn1, 36, 1); //But 5
		~apc40.noteOn(~apcLn1, 37, 1); //But 6
		~apc40.noteOn(~apcLn1, 38, 1); //But 7
		~apc40.noteOn(~apcLn1, 39, 1); //But 8
		//Lounch 5
		~apc40.noteOn(~apcLn1, 24, 5); //But 1
		~apc40.noteOn(~apcLn1, 25, 5); //But 2
		~apc40.noteOn(~apcLn1, 26, 5); //But 3
		~apc40.noteOn(~apcLn1, 27, 0); //But 4
		~apc40.noteOn(~apcLn1, 28, 5); //But 5
		~apc40.noteOn(~apcLn1, 29, 5); //But 6
		~apc40.noteOn(~apcLn1, 30, 5); //But 7
		~apc40.noteOn(~apcLn1, 31, 1); //But 8


	}
}

/*



*/