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
		IFLpMnNotes.noteButL1(~lpMnBut49,\lncNote_3);
		IFLpMnNotes.noteButL1(~lpMnBut50,\lncNote_2);
		IFLpMnNotes.noteButL1(~lpMnBut51,\lncNote_1);
		IFLpMnNotes.noteButL1(~lpMnBut52,\lncNote00);
		IFLpMnNotes.noteButL1(~lpMnBut53,\lncNote01);
		IFLpMnNotes.noteButL1(~lpMnBut54,\lncNote02);
		IFLpMnNotes.noteButL1(~lpMnBut55,\lncNote03);
		IFLpMnNotes.noteButL1(~lpMnBut56,\lncNote04);
		//NoteLine2
		IFLpMnNotes.noteButL2(~lpMnBut57,\lncNote_6);
		IFLpMnNotes.noteButL2(~lpMnBut58,\lncNote_5);
		IFLpMnNotes.noteButL2(~lpMnBut59,\lncNote_4);
		IFLpMnNotes.noteButL2(~lpMnBut60,\lncNote05);
		IFLpMnNotes.noteButL2(~lpMnBut61,\lncNote06);
		IFLpMnNotes.noteButL2(~lpMnBut62,\lncNote07);
		IFLpMnNotes.noteButL2(~lpMnBut63,\lncNote08);
		IFLpMnNotes.noteButL2(~lpMnBut64,\lncNote11);

	}
	*noteButL1{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut49,{
					~local.sendMsg('nt-3', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut49, 3); //But 1
				},
				~lpMnBut50,{
					~local.sendMsg('nt-2', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut50, 3); //But 1
				},
				~lpMnBut51,{
					~local.sendMsg('nt-1', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut51, 3); //But 1
				},
				~lpMnBut52,{
					~local.sendMsg('nt_0', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut52, 3); //But 1
				},
				~lpMnBut53,{
					~local.sendMsg('nt_1', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut53, 3); //But 1
				},
				~lpMnBut54,{
					~local.sendMsg('nt_2', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut54, 3); //But 1
				},
				~lpMnBut55,{
					~local.sendMsg('nt_3', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut55, 3); //But 1
				},
				~lpMnBut56,{
					~local.sendMsg('nt_4', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut56, 3); //But 1
				}
			);

		},srcID:~lpMnInID, chan:~lpMnCh,noteNum:ntNum);
	}

	*noteButL2{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut57,{
					~local.sendMsg('nt-6', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut57, 3); //But 1
				},
				~lpMnBut58,{
					~local.sendMsg('nt-5', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut58, 3); //But 1
				},
				~lpMnBut59,{
					~local.sendMsg('nt-4', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut59, 3); //But 1
				},
				~lpMnBut60,{
					~local.sendMsg('shufMelHarm', 1);
					//this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut60, 3); //But 1
				},
				~lpMnBut61,{
					~local.sendMsg('nt_5', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut61, 3); //But 1
				},
				~lpMnBut62,{
					~local.sendMsg('nt_6', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut62, 3); //But 1
				},
				~lpMnBut63,{
					~local.sendMsg('nt_7', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut63, 3); //But 1
				},
				~lpMnBut64,{
					~local.sendMsg('nt_11', 1);
					this.noteButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut64, 3); //But 1
				}
			);

		},srcID:~lpMnInID, chan:~lpMnCh,noteNum:ntNum);
	}

	*noteButsReset{
			//Notes
		//Lounch 7 - nt line1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut49, ~orng1); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut50, ~orng1); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut51, ~orng1); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut52, ~orng2); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut53, ~orng1); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut54, ~orng1); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut55, ~orng1); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut56, ~orng1); //But 8
		//Lounch 8 - nt line2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut57, ~orng1); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut58, ~orng1); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut59, ~orng1); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut60, ~orng1); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut61, ~orng1); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut62, ~orng1); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut63, ~orng1); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut64, ~orng1); //But 8
	}

	/*
	IFLpMnNotes.resetLeds;
	*/
	*resetLeds{


		//Notes
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
		~lpMn.noteOn(~lpMnCh, ~lpMnBut57, ~orng1); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut58, ~orng1); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut59, ~orng1); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut60, ~orng1); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut61, ~orng1); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut62, ~orng1); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut63, ~orng1); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut64, ~orng1); //But 8



	}

}



/*



*/