/*

PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

~lpMn.uid;

*/

IFLpMnNotes{

	*load{
		//this.addr;
		//this.globals;
		this.resetLeds;
		this.makeNoteResponders;

	}//loadAtStart
	*addr{

	}
	*globals{

	}//globals

	//Notes
	*makeNoteResponders{
		//NoteLine1
		IFLpMnNotes.noteButL1(~lpMnBut41,\lncNote_3);
		IFLpMnNotes.noteButL1(~lpMnBut42,\lncNote_2);
		IFLpMnNotes.noteButL1(~lpMnBut43,\lncNote_1);
		IFLpMnNotes.noteButL1(~lpMnBut44,\lncNote00);
		IFLpMnNotes.noteButL1(~lpMnBut45,\lncNote01);
		IFLpMnNotes.noteButL1(~lpMnBut46,\lncNote02);
		IFLpMnNotes.noteButL1(~lpMnBut47,\lncNote03);
		IFLpMnNotes.noteButL1(~lpMnBut48,\lncNote04);
		//NoteLine2
		IFLpMnNotes.noteButL2(~lpMnBut49,\lncNote_6);
		IFLpMnNotes.noteButL2(~lpMnBut50,\lncNote_5);
		IFLpMnNotes.noteButL2(~lpMnBut51,\lncNote_4);
		IFLpMnNotes.noteButL2(~lpMnBut52,\lncNote05);
		IFLpMnNotes.noteButL2(~lpMnBut53,\lncNote06);
		IFLpMnNotes.noteButL2(~lpMnBut54,\lncNote07);
		IFLpMnNotes.noteButL2(~lpMnBut55,\lncNote08);
		IFLpMnNotes.noteButL2(~lpMnBut56,\lncNote11);
		//NoteLine3
		IFLpMnNotes.noteButL3(~lpMnBut57,\lncShufKick);
		IFLpMnNotes.noteButL3(~lpMnBut58,\lncShufSnr);
		IFLpMnNotes.noteButL3(~lpMnBut59,\lncShufHat);
		IFLpMnNotes.noteButL3(~lpMnBut60,\lncShufDrum);
		IFLpMnNotes.noteButL3(~lpMnBut61,\lncShufBass);
		IFLpMnNotes.noteButL3(~lpMnBut62,\lncShufKeys);
		IFLpMnNotes.noteButL3(~lpMnBut63,\lncShufSamp);
		IFLpMnNotes.noteButL3(~lpMnBut64,\lncNote11);


	}
	*noteButL1{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut41,{
					~local.sendMsg('nt-3', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut41, 3); //But 1
				},
				~lpMnBut42,{
					~local.sendMsg('nt-2', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut42, 3); //But 1
				},
				~lpMnBut43,{
					~local.sendMsg('nt-1', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut43, 3); //But 1
				},
				~lpMnBut44,{
					~local.sendMsg('nt_0', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut44, 3); //But 1
				},
				~lpMnBut45,{
					~local.sendMsg('nt_1', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut45, 3); //But 1
				},
				~lpMnBut46,{
					~local.sendMsg('nt_2', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut46, 3); //But 1
				},
				~lpMnBut47,{
					~local.sendMsg('nt_3', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut47, 3); //But 1
				},
				~lpMnBut48,{
					~local.sendMsg('nt_4', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut48, 3); //But 1
				}
			);

		},srcID:~lpMnInID, chan:~lpMnCh,noteNum:ntNum);
	}

	*noteButL2{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut49,{
					~local.sendMsg('nt-6', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut49, 3); //But 1
				},
				~lpMnBut50,{
					~local.sendMsg('nt-5', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut50, 3); //But 1
				},
				~lpMnBut51,{
					~local.sendMsg('nt-4', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut51, 3); //But 1
				},
				~lpMnBut52,{
					~local.sendMsg('nt_5', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut52, 3); //But 1
				},
				~lpMnBut53,{
					~local.sendMsg('nt_6', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut53, 3); //But 1
				},
				~lpMnBut54,{
					~local.sendMsg('nt_7', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut54, 3); //But 1
				},
				~lpMnBut55,{
					~local.sendMsg('nt_8', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut55, 3); //But 1
				},
				~lpMnBut56,{
					~local.sendMsg('nt_11', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut56, 3); //But 1
				}
			);

		},srcID:~lpMnInID, chan:~lpMnCh,noteNum:ntNum);
	}

	*noteButL3{|ntNum, nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut57,{

					//this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut57, 3); //But 1
				},
				~lpMnBut58,{
					//~local.sendMsg('shufSnr', 1);
					//this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut58, 3); //But 1
				},
				~lpMnBut59,{
					//~local.sendMsg('shufHat', 1);
					//this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut59, 3); //But 1
				},
				~lpMnBut60,{/////---------------Shuf
					//~local.sendMsg('shufDrumHarm', 1);
					//this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut60, 6); //But 1
				},
				~lpMnBut61,{
					//~local.sendMsg('shufBass', 1);
					//this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut61, 3); //But 1
				},
				~lpMnBut62,{
					//~local.sendMsg('shufKeys', 1);
					//this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut62, 3); //But 1
				},
				~lpMnBut63,{
					//~local.sendMsg('shufSamp', 1);
					//this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut63, 3); //But 1
				},
				~lpMnBut64,{
					//~local.sendMsg('shufMelHarm', 1);
					//this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut64, 3); //But 1
				}
			);

		},srcID:~lpMnInID, chan:~lpMnCh,noteNum:ntNum);
	}

	*noteButsReset{
			//Notes
		//Lounch 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut41, ~orng1); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut42, ~orng1); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut43, ~orng1); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut44, ~orng3); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut45, ~orng1); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut46, ~orng1); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut47, ~orng1); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut48, ~orng1); //But 8
		//Lounch 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut49, ~orng1); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut50, ~orng1); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut51, ~orng1); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut52, ~orng2); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut53, ~orng1); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut54, ~orng1); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut55, ~orng1); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut56, ~orng1); //But 8
		//Lounch 8
		~lpMn.noteOn(~lpMnCh, ~lpMnBut57, ~yellow3); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut58, ~yellow3); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut59, ~yellow3); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut60, ~yellow3); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut61, ~yellow3); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut62, ~yellow3); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut63, ~yellow3); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut64, ~yellow3); //But 8
	}

	/*
	IFLpMnNotes.resetLeds;
	*/
	*resetLeds{

		//NULL
		//Lounch 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut1, 0); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut2, 0); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut3, 0); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut4, 0); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut5, 0); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut6, 0); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut7, 0); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut8, 0); //But 8
		//Lounch 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut9, 0); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut10, 0); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut11, 0); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut12, 0); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut13, 0); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut14, 0); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut15, 0); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut16, 0); //But 8
		//~lpMn.noteOn(~lpMnCh, 24, 0); //But 9
		//Lounch 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut17, 0); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut18, 0); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut19, 0); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut20, 0); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut21, 0); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut22, 0); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut23, 0); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut24, 0); //But 8
		//~lpMn.noteOn(~lpMnCh, 40, 0); //But 9
		//Lounch 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut25, 0); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut26, 0); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut27, 0); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut28, 0); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut29, 0); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut30, 0); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut31, 0); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut32, 0); //But 8
		//Lounch 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut33, 0); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut34, 0); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut35, 0); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut36, 0); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut37, 0); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut38, 0); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut39, 0); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut40, 0); //But 8

		//Notes
		//Lounch 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut41, ~orng1); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut42, ~orng1); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut43, ~orng1); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut44, ~orng3); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut45, ~orng1); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut46, ~orng1); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut47, ~orng1); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut48, ~orng1); //But 8
		//Lounch 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut49, ~orng1); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut50, ~orng1); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut51, ~orng1); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut52, ~orng2); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut53, ~orng1); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut54, ~orng1); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut55, ~orng1); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut56, ~orng1); //But 8
		//Lounch 8
		~lpMn.noteOn(~lpMnCh, ~lpMnBut57, ~yellow3); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut58, ~yellow3); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut59, ~yellow3); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut60, ~yellow3); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut61, ~yellow3); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut62, ~yellow3); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut63, ~yellow3); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut64, ~yellow3); //But 8



	}

}



/*



*/