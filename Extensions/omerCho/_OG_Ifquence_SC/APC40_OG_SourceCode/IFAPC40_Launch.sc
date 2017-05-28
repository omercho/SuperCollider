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
		~lnchBut1=53;~lnchBut2=54;
		~lnchBut3=55;~lnchBut4=56;
		~lnchBut5=57;


	}//globals

//Notes
	*makeNoteResponders{
		//NoteLine1
		IFAPC40_Launch.noteButL1(~apcLn1,\lncNote_3);
		IFAPC40_Launch.noteButL1(~apcLn2,\lncNote_2);
		IFAPC40_Launch.noteButL1(~apcLn3,\lncNote_1);
		IFAPC40_Launch.noteButL1(~apcLn4,\lncNote00);
		IFAPC40_Launch.noteButL1(~apcLn5,\lncNote01);
		IFAPC40_Launch.noteButL1(~apcLn6,\lncNote02);
		IFAPC40_Launch.noteButL1(~apcLn7,\lncNote03);
		IFAPC40_Launch.noteButL1(~apcLn8,\lncNote04);
		//NoteLine2
		IFAPC40_Launch.noteButL2(~apcLn1,\lncNote_6);
		IFAPC40_Launch.noteButL2(~apcLn2,\lncNote_5);
		IFAPC40_Launch.noteButL2(~apcLn3,\lncNote_4);
		IFAPC40_Launch.noteButL2(~apcLn4,\lncShufAll);
		IFAPC40_Launch.noteButL2(~apcLn5,\lncNote05);
		IFAPC40_Launch.noteButL2(~apcLn6,\lncNote06);
		IFAPC40_Launch.noteButL2(~apcLn7,\lncNote07);
		IFAPC40_Launch.noteButL2(~apcLn8,\lncNote08);
		//NoteLine3
		IFAPC40_Launch.noteButL3(~apcLn1,\lncShufKick);
		IFAPC40_Launch.noteButL3(~apcLn2,\lncShufSnr);
		IFAPC40_Launch.noteButL3(~apcLn3,\lncShufHat);
		IFAPC40_Launch.noteButL3(~apcLn4,\lncShufDrum);
		IFAPC40_Launch.noteButL3(~apcLn5,\lncShufBass);
		IFAPC40_Launch.noteButL3(~apcLn6,\lncShufKeys);
		IFAPC40_Launch.noteButL3(~apcLn7,\lncShufSamp);
		IFAPC40_Launch.noteButL3(~apcLn8,\lncNote11);


		/*IFAPC40_Launch.button02(~apcLn1,\lncNoteOn09, \lncNoteOff09);
		IFAPC40_Launch.button02(~apcLn2,\lncNoteOn10, \lncNoteOff10);
		IFAPC40_Launch.button02(~apcLn3,\lncNoteOn11, \lncNoteOff11);
		IFAPC40_Launch.button02(~apcLn4,\lncNoteOn12, \lncNoteOff12);
		IFAPC40_Launch.button02(~apcLn5,\lncNoteOn13, \lncNoteOff13);
		IFAPC40_Launch.button02(~apcLn6,\lncNoteOn14, \lncNoteOff14);
		IFAPC40_Launch.button02(~apcLn7,\lncNoteOn15, \lncNoteOff15);
		IFAPC40_Launch.button02(~apcLn8,\lncNoteOn16, \lncNoteOff16);*/

	}
	*noteButL1{|channel,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			channel.switch(
				~apcLn1,{
					~local.sendMsg('nt-3', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut3, 2); //But 1
				},
				~apcLn2,{
					~local.sendMsg('nt-2', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn2, ~lnchBut3, 2); //But 1
				},
				~apcLn3,{
					~local.sendMsg('nt-1', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn3, ~lnchBut3, 2); //But 1
				},
				~apcLn4,{
					~local.sendMsg('nt_0', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn4, ~lnchBut3, 4); //But 1
				},
				~apcLn5,{
					~local.sendMsg('nt_1', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn5, ~lnchBut3, 2); //But 1
				},
				~apcLn6,{
					~local.sendMsg('nt_2', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn6, ~lnchBut3, 2); //But 1
				},
				~apcLn7,{
					~local.sendMsg('nt_3', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn7, ~lnchBut3, 2); //But 1
				},
				~apcLn8,{
					~local.sendMsg('nt_4', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn8, ~lnchBut3, 2); //But 1
				}
			);

		},srcID:~apc40InID, chan:channel,noteNum:~lnchBut3);

		/*MIDIdef.noteOff(nameOff, {
			arg chan,noteNum;

			channel.switch(
				~apcLn1,{~local.sendMsg('seqStep0l', 0);},
				~apcLn2,{~local.sendMsg('seqStep02', 0);},
				~apcLn3,{~local.sendMsg('seqStep03', 0);},
				~apcLn4,{~local.sendMsg('seqStep04', 0);},
				~apcLn5,{~local.sendMsg('seqStep05', 0);},
				~apcLn6,{~local.sendMsg('seqStep06', 0);},
				~apcLn7,{~local.sendMsg('seqStep07', 0);},
				~apcLn8,{~local.sendMsg('seqStep08', 0);}
			);

		},srcID:~apc40InID, chan:channel,noteNum:~lnchBut3);*/
	}

	*noteButL2{|channel,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			channel.switch(
				~apcLn1,{
					~local.sendMsg('nt-6', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn1, ~lnchBut4, 2); //But 1
				},
				~apcLn2,{
					~local.sendMsg('nt-5', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn2, ~lnchBut4, 2); //But 1
				},
				~apcLn3,{
					~local.sendMsg('nt-4', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn3, ~lnchBut4, 2); //But 1
				},
				~apcLn4,{/////---------------Shuf
					~local.sendMsg('shufTrans', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn4, ~lnchBut4, 6); //But 1
				},
				~apcLn5,{
					~local.sendMsg('nt_5', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn5, ~lnchBut4, 2); //But 1
				},
				~apcLn6,{
					~local.sendMsg('nt_6', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn6, ~lnchBut4, 2); //But 1
				},
				~apcLn7,{
					~local.sendMsg('nt_7', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn7, ~lnchBut4, 2); //But 1
				},
				~apcLn8,{
					~local.sendMsg('nt_8', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn8, ~lnchBut4, 2); //But 1
				}
			);

		},srcID:~apc40InID, chan:channel,noteNum:~lnchBut4);
	}

	*noteButL3{|channel,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			channel.switch(
				~apcLn1,{
					~local.sendMsg('shufKick', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn1, ~lnchBut5, 2); //But 1
				},
				~apcLn2,{
					~local.sendMsg('shufSnr', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn2, ~lnchBut5, 2); //But 1
				},
				~apcLn3,{
					~local.sendMsg('shufHat', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn3, ~lnchBut5, 2); //But 1
				},
				~apcLn4,{/////---------------Shuf
					~local.sendMsg('shufHarm', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn4, ~lnchBut5, 6); //But 1
				},
				~apcLn5,{
					~local.sendMsg('shufBass', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn5, ~lnchBut5, 2); //But 1
				},
				~apcLn6,{
					~local.sendMsg('shufKeys', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn6, ~lnchBut5, 2); //But 1
				},
				~apcLn7,{
					~local.sendMsg('shufSamp', 1);
					//this.noteButsReset;
					//~apc40.noteOn(~apcLn7, ~lnchBut5, 2); //But 1
				},
				~apcLn8,{
					~local.sendMsg('nt_11', 1);
					this.noteButsReset;
					~apc40.noteOn(~apcLn8, ~lnchBut5, 2); //But 1
				}
			);

		},srcID:~apc40InID, chan:channel,noteNum:~lnchBut5);
	}

	*noteButsReset{
		//Notes
		//Lounch 3
		~apc40.noteOn(~apcLn1, 55, 1); //But 1
		~apc40.noteOn(~apcLn2, 55, 1); //But 2
		~apc40.noteOn(~apcLn3, 55, 1); //But 3
		~apc40.noteOn(~apcLn4, 55, 3); //But 4
		~apc40.noteOn(~apcLn5, 55, 1); //But 5
		~apc40.noteOn(~apcLn6, 55, 1); //But 6
		~apc40.noteOn(~apcLn7, 55, 1); //But 7
		~apc40.noteOn(~apcLn8, 55, 1); //But 8
		//Lounch 4
		~apc40.noteOn(~apcLn1, 56, 1); //But 1
		~apc40.noteOn(~apcLn2, 56, 1); //But 2
		~apc40.noteOn(~apcLn3, 56, 1); //But 3
		//~apc40.noteOn(~apcLn4, 56, 5); //But 4
		~apc40.noteOn(~apcLn5, 56, 1); //But 5
		~apc40.noteOn(~apcLn6, 56, 1); //But 6
		~apc40.noteOn(~apcLn7, 56, 1); //But 7
		~apc40.noteOn(~apcLn8, 56, 1); //But 8
		//Lounch 5
		//~apc40.noteOn(~apcLn1, 57, 5); //But 1
		//~apc40.noteOn(~apcLn2, 57, 5); //But 2
		//~apc40.noteOn(~apcLn3, 57, 5); //But 3
		//~apc40.noteOn(~apcLn4, 57, 5); //But 4
		//~apc40.noteOn(~apcLn5, 57, 1); //But 5
		//~apc40.noteOn(~apcLn6, 57, 1); //But 6
		//~apc40.noteOn(~apcLn7, 57, 1); //But 7
		~apc40.noteOn(~apcLn8, 57, 1); //But 8
	}
////////////////////////
//Step Sequencer Sixteen
	*makeStepResponders{

		IFAPC40_Launch.button01(~apcLn1,\lncStepOn01, \lncStepOff01);
		IFAPC40_Launch.button01(~apcLn2,\lncStepOn02, \lncStepOff02);
		IFAPC40_Launch.button01(~apcLn3,\lncStepOn03, \lncStepOff03);
		IFAPC40_Launch.button01(~apcLn4,\lncStepOn04, \lncStepOff04);
		IFAPC40_Launch.button01(~apcLn5,\lncStepOn05, \lncStepOff05);
		IFAPC40_Launch.button01(~apcLn6,\lncStepOn06, \lncStepOff06);
		IFAPC40_Launch.button01(~apcLn7,\lncStepOn07, \lncStepOff07);
		IFAPC40_Launch.button01(~apcLn8,\lncStepOn08, \lncStepOff08);

		IFAPC40_Launch.button02(~apcLn1,\lncStepOn09, \lncStepOff09);
		IFAPC40_Launch.button02(~apcLn2,\lncStepOn10, \lncStepOff10);
		IFAPC40_Launch.button02(~apcLn3,\lncStepOn11, \lncStepOff11);
		IFAPC40_Launch.button02(~apcLn4,\lncStepOn12, \lncStepOff12);
		IFAPC40_Launch.button02(~apcLn5,\lncStepOn13, \lncStepOff13);
		IFAPC40_Launch.button02(~apcLn6,\lncStepOn14, \lncStepOff14);
		IFAPC40_Launch.button02(~apcLn7,\lncStepOn15, \lncStepOff15);
		IFAPC40_Launch.button02(~apcLn8,\lncStepOn16, \lncStepOff16);

	}

	*button01{|channel,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			channel.switch(
				~apcLn1,{~local.sendMsg('seqStep0l', 1);},
				~apcLn2,{~local.sendMsg('seqStep02', 1);},
				~apcLn3,{~local.sendMsg('seqStep03', 1);},
				~apcLn4,{~local.sendMsg('seqStep04', 1);},
				~apcLn5,{~local.sendMsg('seqStep05', 1);},
				~apcLn6,{~local.sendMsg('seqStep06', 1);},
				~apcLn7,{~local.sendMsg('seqStep07', 1);},
				~apcLn8,{~local.sendMsg('seqStep08', 1);}
			);

		},srcID:~apc40InID, chan:channel,noteNum:~lnchBut1);

		MIDIdef.noteOff(nameOff, {
			arg chan,noteNum;

			channel.switch(
				~apcLn1,{~local.sendMsg('seqStep0l', 0);},
				~apcLn2,{~local.sendMsg('seqStep02', 0);},
				~apcLn3,{~local.sendMsg('seqStep03', 0);},
				~apcLn4,{~local.sendMsg('seqStep04', 0);},
				~apcLn5,{~local.sendMsg('seqStep05', 0);},
				~apcLn6,{~local.sendMsg('seqStep06', 0);},
				~apcLn7,{~local.sendMsg('seqStep07', 0);},
				~apcLn8,{~local.sendMsg('seqStep08', 0);}
			);

		},srcID:~apc40InID, chan:channel,noteNum:~lnchBut1);
	}
	*button02{|channel,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			channel.switch(
				~apcLn1,{~local.sendMsg('seqStep09', 1);},
				~apcLn2,{~local.sendMsg('seqStep10', 1);},
				~apcLn3,{~local.sendMsg('seqStep11', 1);},
				~apcLn4,{~local.sendMsg('seqStep12', 1);},
				~apcLn5,{~local.sendMsg('seqStep13', 1);},
				~apcLn6,{~local.sendMsg('seqStep14', 1);},
				~apcLn7,{~local.sendMsg('seqStep15', 1);},
				~apcLn8,{~local.sendMsg('seqStep16', 1);}
			);

		},srcID:~apc40InID, chan:channel,noteNum:~lnchBut2);

		MIDIdef.noteOff(nameOff, {
			arg chan,noteNum;

			channel.switch(
				~apcLn1,{~local.sendMsg('seqStep09', 0);},
				~apcLn2,{~local.sendMsg('seqStep10', 0);},
				~apcLn3,{~local.sendMsg('seqStep11', 0);},
				~apcLn4,{~local.sendMsg('seqStep12', 0);},
				~apcLn5,{~local.sendMsg('seqStep13', 0);},
				~apcLn6,{~local.sendMsg('seqStep14', 0);},
				~apcLn7,{~local.sendMsg('seqStep15', 0);},
				~apcLn8,{~local.sendMsg('seqStep16', 0);}
			);

		},srcID:~apc40InID, chan:channel,noteNum:~lnchBut2);
	}

	*led{|index|

		index.switch(
			1,{this.ledOnOff(~apcLn1,~lnchBut1);},
			2,{this.ledOnOff(~apcLn2,~lnchBut1);},
			3,{this.ledOnOff(~apcLn3,~lnchBut1);},
			4,{this.ledOnOff(~apcLn4,~lnchBut1);},
			5,{this.ledOnOff(~apcLn5,~lnchBut1);},
			6,{this.ledOnOff(~apcLn6,~lnchBut1);},
			7,{this.ledOnOff(~apcLn7,~lnchBut1);},
			8,{this.ledOnOff(~apcLn8,~lnchBut1);},

			9,{this.ledOnOff(~apcLn1,~lnchBut2);},
			10,{this.ledOnOff(~apcLn2,~lnchBut2);},
			11,{this.ledOnOff(~apcLn3,~lnchBut2);},
			12,{this.ledOnOff(~apcLn4,~lnchBut2);},
			13,{this.ledOnOff(~apcLn5,~lnchBut2);},
			14,{this.ledOnOff(~apcLn6,~lnchBut2);},
			15,{this.ledOnOff(~apcLn7,~lnchBut2);},
			16,{this.ledOnOff(~apcLn8,~lnchBut2);}
		);
	}
	*ledOnOff {|line, launch|
		fork{
			~apc40.noteOn(line, launch, 0); //But 1
			0.3.wait;
			~apc40.noteOn(line, launch, 5); //But 1
		};
	}

	*resetLeds{

		//Sequencer
		//Lounch
		~apc40.noteOn(~apcLn1, 53, 5); //But 1
		~apc40.noteOn(~apcLn2, 53, 5); //But 2
		~apc40.noteOn(~apcLn3, 53, 5); //But 3
		~apc40.noteOn(~apcLn4, 53, 5); //But 4
		~apc40.noteOn(~apcLn5, 53, 5); //But 5
		~apc40.noteOn(~apcLn6, 53, 5); //But 6
		~apc40.noteOn(~apcLn7, 53, 5); //But 7
		~apc40.noteOn(~apcLn8, 53, 5); //But 8
		//Lounch 2
		~apc40.noteOn(~apcLn1, 54, 5); //But 1
		~apc40.noteOn(~apcLn2, 54, 5); //But 2
		~apc40.noteOn(~apcLn3, 54, 5); //But 3
		~apc40.noteOn(~apcLn4, 54, 5); //But 4
		~apc40.noteOn(~apcLn5, 54, 5); //But 5
		~apc40.noteOn(~apcLn6, 54, 5); //But 6
		~apc40.noteOn(~apcLn7, 54, 5); //But 7
		~apc40.noteOn(~apcLn8, 54, 5); //But 8

		//Notes
		//Lounch 3
		~apc40.noteOn(~apcLn1, 55, 1); //But 1
		~apc40.noteOn(~apcLn2, 55, 1); //But 2
		~apc40.noteOn(~apcLn3, 55, 1); //But 3
		~apc40.noteOn(~apcLn4, 55, 3); //But 4
		~apc40.noteOn(~apcLn5, 55, 1); //But 5
		~apc40.noteOn(~apcLn6, 55, 1); //But 6
		~apc40.noteOn(~apcLn7, 55, 1); //But 7
		~apc40.noteOn(~apcLn8, 55, 1); //But 8
		//Lounch 4
		~apc40.noteOn(~apcLn1, 56, 1); //But 1
		~apc40.noteOn(~apcLn2, 56, 1); //But 2
		~apc40.noteOn(~apcLn3, 56, 1); //But 3
		~apc40.noteOn(~apcLn4, 56, 0); //But 4
		~apc40.noteOn(~apcLn5, 56, 1); //But 5
		~apc40.noteOn(~apcLn6, 56, 1); //But 6
		~apc40.noteOn(~apcLn7, 56, 1); //But 7
		~apc40.noteOn(~apcLn8, 56, 1); //But 8
		//Lounch 5
		~apc40.noteOn(~apcLn1, 57, 5); //But 1
		~apc40.noteOn(~apcLn2, 57, 5); //But 2
		~apc40.noteOn(~apcLn3, 57, 5); //But 3
		~apc40.noteOn(~apcLn4, 57, 0); //But 4
		~apc40.noteOn(~apcLn5, 57, 5); //But 5
		~apc40.noteOn(~apcLn6, 57, 5); //But 6
		~apc40.noteOn(~apcLn7, 57, 5); //But 7
		~apc40.noteOn(~apcLn8, 57, 1); //But 8


	}
}

/*



*/