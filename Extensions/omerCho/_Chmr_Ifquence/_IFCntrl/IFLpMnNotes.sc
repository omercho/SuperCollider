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
		this.makeOSCResponders;

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
		~lpMn.noteOn(0,~lpMnBut49,~orng1);
	}
	*noteButL1{|ntNum,nameOn, nameOff|
		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut49,{~local.sendMsg('nt-3', 1);},
				~lpMnBut50,{~local.sendMsg('nt-2', 1);},
				~lpMnBut51,{~local.sendMsg('nt-1', 1);},
				~lpMnBut52,{~local.sendMsg('nt_0', 1);},
				~lpMnBut53,{~local.sendMsg('nt_1', 1);},
				~lpMnBut54,{~local.sendMsg('nt_2', 1);},
				~lpMnBut55,{~local.sendMsg('nt_3', 1);},
				~lpMnBut56,{~local.sendMsg('nt_4', 1);}
			);
		},srcID:~lpMnInID, chan:~lpMnCh,noteNum:ntNum);
	}
	*noteButL2{|ntNum,nameOn, nameOff|
		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut57,{~local.sendMsg('nt-6', 1);},
				~lpMnBut58,{~local.sendMsg('nt-5', 1);},
				~lpMnBut59,{~local.sendMsg('nt-4', 1);},
				~lpMnBut60,{~local.sendMsg('shufMelHarm', 1);},
				~lpMnBut61,{~local.sendMsg('nt_5', 1);},
				~lpMnBut62,{~local.sendMsg('nt_6', 1);},
				~lpMnBut63,{~local.sendMsg('nt_7', 1);},
				~lpMnBut64,{~local.sendMsg('nt_11', 1);}
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


	*oscResp{|respName,oscName,playDir|
		OSCdef(respName, {
			arg msg;
			playDir.switch(
				'ntP0',{if ( msg[1]==1, {this.noteButsReset; ~lpMn.noteOn(~lpMnCh, ~lpMnBut52, 3); });},
				'ntP1',{if ( msg[1]==1, {this.noteButsReset; ~lpMn.noteOn(~lpMnCh, ~lpMnBut53, 3); });},
				'ntP2',{if ( msg[1]==1, {this.noteButsReset; ~lpMn.noteOn(~lpMnCh, ~lpMnBut54, 3); });},
				'ntP3',{if ( msg[1]==1, {this.noteButsReset; ~lpMn.noteOn(~lpMnCh, ~lpMnBut55, 3); });},
				'ntP4',{if ( msg[1]==1, {this.noteButsReset; ~lpMn.noteOn(~lpMnCh, ~lpMnBut56, 3); });},
				'ntP5',{if ( msg[1]==1, {this.noteButsReset; ~lpMn.noteOn(~lpMnCh, ~lpMnBut61, 3); });},
				'ntP6',{if ( msg[1]==1, {this.noteButsReset; ~lpMn.noteOn(~lpMnCh, ~lpMnBut62, 3); });},
				'ntP7',{if ( msg[1]==1, {this.noteButsReset; ~lpMn.noteOn(~lpMnCh, ~lpMnBut63, 3); });},
				'ntP8',{if ( msg[1]==1, {this.noteButsReset; });},
				'ntP9',{if ( msg[1]==1, {this.noteButsReset; });},
				'ntP10',{if ( msg[1]==1, {this.noteButsReset; });},
				'ntP11',{if ( msg[1]==1, {this.noteButsReset; });},
				'ntP12',{if ( msg[1]==1, {this.noteButsReset; });},
				'ntP13',{if ( msg[1]==1, {this.noteButsReset; });},
				'ntP14',{if ( msg[1]==1, {this.noteButsReset; ~lpMn.noteOn(~lpMnCh, ~lpMnBut64, 3); });},

				'ntM1',{if ( msg[1]==1, {this.noteButsReset;~lpMn.noteOn(~lpMnCh, ~lpMnBut51, 3); });},
				'ntM2',{if ( msg[1]==1, {this.noteButsReset;~lpMn.noteOn(~lpMnCh, ~lpMnBut50, 3); });},
				'ntM3',{if ( msg[1]==1, {this.noteButsReset;~lpMn.noteOn(~lpMnCh, ~lpMnBut49, 3); });},
				'ntM4',{if ( msg[1]==1, {this.noteButsReset;~lpMn.noteOn(~lpMnCh, ~lpMnBut59, 3); });},
				'ntM5',{if ( msg[1]==1, {this.noteButsReset;~lpMn.noteOn(~lpMnCh, ~lpMnBut58, 3); });},
				'ntM6',{if ( msg[1]==1, {this.noteButsReset;~lpMn.noteOn(~lpMnCh, ~lpMnBut57, 3); });},
				'ntM7',{if ( msg[1]==1, {this.noteButsReset;});},
				'ntM8',{if ( msg[1]==1, {this.noteButsReset;});},
				'ntM9',{if ( msg[1]==1, {this.noteButsReset;});},
				'ntM10',{if ( msg[1]==1, {this.noteButsReset;});},
				'ntM11',{if ( msg[1]==1, {this.noteButsReset;});},
				'ntM12',{if ( msg[1]==1, {this.noteButsReset;});},
				'ntM13',{if ( msg[1]==1, {this.noteButsReset;});},
				'ntM14',{if ( msg[1]==1, {this.noteButsReset;});}


			);
		},path:oscName);
	}
	*makeOSCResponders{
		//ntPlus
		IFLpMnNotes.oscResp(respName:'notePlusLpMn00', oscName:'nt_0', playDir:'ntP0');
		IFLpMnNotes.oscResp(respName:'notePlusLpMn01', oscName:'nt_1', playDir:'ntP1');
		IFLpMnNotes.oscResp(respName:'notePlusLpMn02', oscName:'nt_2', playDir:'ntP2');
		IFLpMnNotes.oscResp(respName:'notePlusLpMn03', oscName:'nt_3', playDir:'ntP3');
		IFLpMnNotes.oscResp(respName:'notePlusLpMn04', oscName:'nt_4', playDir:'ntP4');
		IFLpMnNotes.oscResp(respName:'notePlusLpMn05', oscName:'nt_5', playDir:'ntP5');
		IFLpMnNotes.oscResp(respName:'notePlusLpMn06', oscName:'nt_6', playDir:'ntP6');
		IFLpMnNotes.oscResp(respName:'notePlusLpMn07', oscName:'nt_7', playDir:'ntP7');
		IFLpMnNotes.oscResp(respName:'notePlusLpMn08', oscName:'nt_8', playDir:'ntP8');
		IFLpMnNotes.oscResp(respName:'notePlusLpMn09', oscName:'nt_9', playDir:'ntP9');
		IFLpMnNotes.oscResp(respName:'notePlusLpMn10', oscName:'nt_10', playDir:'ntP10');
		IFLpMnNotes.oscResp(respName:'notePlusLpMn11', oscName:'nt_11', playDir:'ntP11');
		IFLpMnNotes.oscResp(respName:'notePlusLpMn12', oscName:'nt_12', playDir:'ntP12');
		IFLpMnNotes.oscResp(respName:'notePlusLpMn13', oscName:'nt_13', playDir:'ntP13');
		IFLpMnNotes.oscResp(respName:'notePlusLpMn14', oscName:'nt_14', playDir:'ntP14');
		//ntMinus
		IFLpMnNotes.oscResp(respName:'noteMinusLpMn01', oscName:'nt-1', playDir:'ntM1');
		IFLpMnNotes.oscResp(respName:'noteMinusLpMn02', oscName:'nt-2', playDir:'ntM2');
		IFLpMnNotes.oscResp(respName:'noteMinusLpMn03', oscName:'nt-3', playDir:'ntM3');
		IFLpMnNotes.oscResp(respName:'noteMinusLpMn04', oscName:'nt-4', playDir:'ntM4');
		IFLpMnNotes.oscResp(respName:'noteMinusLpMn05', oscName:'nt-5', playDir:'ntM5');
		IFLpMnNotes.oscResp(respName:'noteMinusLpMn06', oscName:'nt-6', playDir:'ntM6');
		IFLpMnNotes.oscResp(respName:'noteMinusLpMn07', oscName:'nt-7', playDir:'ntM7');
		IFLpMnNotes.oscResp(respName:'noteMinusLpMn08', oscName:'nt-8', playDir:'ntM8');
		IFLpMnNotes.oscResp(respName:'noteMinusLpMn09', oscName:'nt-9', playDir:'ntM9');
		IFLpMnNotes.oscResp(respName:'noteMinusLpMn10', oscName:'nt-10', playDir:'ntM10');
		IFLpMnNotes.oscResp(respName:'noteMinusLpMn11', oscName:'nt-11', playDir:'ntM11');
		IFLpMnNotes.oscResp(respName:'noteMinusLpMn12', oscName:'nt-12', playDir:'ntM12');
		IFLpMnNotes.oscResp(respName:'noteMinusLpMn13', oscName:'nt-13', playDir:'ntM13');
		IFLpMnNotes.oscResp(respName:'noteMinusLpMn14', oscName:'nt-14', playDir:'ntM14');

	}
}



/*



*/