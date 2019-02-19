/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

~apcMn.uid;
*/

IFApcMnNotes{

	*load{
		//this.addr;
		this.globals;
		this.resetLeds;
		this.makeNoteResponders;
		this.makeOSCResponders;

	}//loadAtStart
	*addr{

	}
	*globals{
		//1
		~apcNoteBut01=56;~apcNoteBut02=57;~apcNoteBut03=58;~apcNoteBut04=59;
		~apcNoteBut05=60;~apcNoteBut06=61;~apcNoteBut07=62;~apcNoteBut08=63;
		//2
		~apcNoteBut09=48;~apcNoteBut10=49;~apcNoteBut11=50;~apcNoteBut12=51;
		~apcNoteBut13=52;~apcNoteBut14=53;~apcNoteBut15=54;~apcNoteBut16=55;

		~apcOrng1=5;
		~apcOrng2=3;

	}//globals

	//Notes
	*makeNoteResponders{
		//NoteLine1
		IFApcMnNotes.noteButL1(~apcNoteBut01,\lncNote_3);
		IFApcMnNotes.noteButL1(~apcNoteBut02,\lncNote_2);
		IFApcMnNotes.noteButL1(~apcNoteBut03,\lncNote_1);
		IFApcMnNotes.noteButL1(~apcNoteBut04,\lncNote00);
		IFApcMnNotes.noteButL1(~apcNoteBut05,\lncNote01);
		IFApcMnNotes.noteButL1(~apcNoteBut06,\lncNote02);
		IFApcMnNotes.noteButL1(~apcNoteBut07,\lncNote03);
		IFApcMnNotes.noteButL1(~apcNoteBut08,\lncNote04);
		//NoteLine2
		IFApcMnNotes.noteButL2(~apcNoteBut09,\lncNote_6);
		IFApcMnNotes.noteButL2(~apcNoteBut10,\lncNote_5);
		IFApcMnNotes.noteButL2(~apcNoteBut11,\lncNote_4);
		IFApcMnNotes.noteButL2(~apcNoteBut12,\lncNote05);
		IFApcMnNotes.noteButL2(~apcNoteBut13,\lncNote06);
		IFApcMnNotes.noteButL2(~apcNoteBut14,\lncNote07);
		IFApcMnNotes.noteButL2(~apcNoteBut15,\lncNote08);
		IFApcMnNotes.noteButL2(~apcNoteBut16,\lncNote11);
		~apcMn.noteOn(0,~apcNoteBut01,~apcOrng1);
	}
	*noteButL1{|ntNum,nameOn, nameOff|
		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~apcNoteBut01,{~local.sendMsg('nt-3', 1);},
				~apcNoteBut02,{~local.sendMsg('nt-2', 1);},
				~apcNoteBut03,{~local.sendMsg('nt-1', 1);},
				~apcNoteBut04,{~local.sendMsg('nt_0', 1);},
				~apcNoteBut05,{~local.sendMsg('nt_1', 1);},
				~apcNoteBut06,{~local.sendMsg('nt_2', 1);},
				~apcNoteBut07,{~local.sendMsg('nt_3', 1);},
				~apcNoteBut08,{~local.sendMsg('nt_4', 1);}
			);
		},srcID:~apcMnInID, chan:~apcMnCh,noteNum:ntNum);
	}
	*noteButL2{|ntNum,nameOn, nameOff|
		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~apcNoteBut09,{~local.sendMsg('nt-6', 1);},
				~apcNoteBut10,{~local.sendMsg('nt-5', 1);},
				~apcNoteBut11,{~local.sendMsg('nt-4', 1);},
				~apcNoteBut12,{~local.sendMsg('shufMelHarm', 1);},
				~apcNoteBut13,{~local.sendMsg('nt_5', 1);},
				~apcNoteBut14,{~local.sendMsg('nt_6', 1);},
				~apcNoteBut15,{~local.sendMsg('nt_7', 1);},
				~apcNoteBut16,{~local.sendMsg('nt_11', 1);}
			);
		},srcID:~apcMnInID, chan:~apcMnCh,noteNum:ntNum);
	}

	*noteButsReset{
		//Notes
		//Lounch 7 - nt line1
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut01, ~apcOrng1); //But 1
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut02, ~apcOrng1); //But 2
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut03, ~apcOrng1); //But 3
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut04, ~apcOrng2); //But 4
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut05, ~apcOrng1); //But 5
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut06, ~apcOrng1); //But 6
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut07, ~apcOrng1); //But 7
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut08, ~apcOrng1); //But 8
		//Lounch 8 - nt line2
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut09, ~apcOrng1); //But 1
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut10, ~apcOrng1); //But 2
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut11, ~apcOrng1); //But 3
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut12, ~apcOrng1); //But 4
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut13, ~apcOrng1); //But 5
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut14, ~apcOrng1); //But 6
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut15, ~apcOrng1); //But 7
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut16, ~apcOrng1); //But 8
	}

	/*
	IFApcMnNotes.resetLeds;
	*/
	*resetLeds{
		//Notes
		//Lounch 7
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut01, ~apcOrng1); //But 1
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut02, ~apcOrng1); //But 2
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut03, ~apcOrng1); //But 3
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut04, ~apcOrng2); //But 4
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut05, ~apcOrng1); //But 5
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut06, ~apcOrng1); //But 6
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut07, ~apcOrng1); //But 7
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut08, ~apcOrng1); //But 8
		//Lounch 8
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut09, ~apcOrng1); //But 1
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut10, ~apcOrng1); //But 2
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut11, ~apcOrng1); //But 3
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut12, ~apcOrng1); //But 4
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut13, ~apcOrng1); //But 5
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut14, ~apcOrng1); //But 6
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut15, ~apcOrng1); //But 7
		~apcMn.noteOn(~apcMnCh, ~apcNoteBut16, ~apcOrng1); //But 8
	}

	*makeOSCResponders{
		//ntPlus
		IFApcMnNotes.oscResp(respName:'notePlusApcMn00', oscName:'nt_0', playDir:'ntP0');
		IFApcMnNotes.oscResp(respName:'notePlusApcMn01', oscName:'nt_1', playDir:'ntP1');
		IFApcMnNotes.oscResp(respName:'notePlusApcMn02', oscName:'nt_2', playDir:'ntP2');
		IFApcMnNotes.oscResp(respName:'notePlusApcMn03', oscName:'nt_3', playDir:'ntP3');
		IFApcMnNotes.oscResp(respName:'notePlusApcMn04', oscName:'nt_4', playDir:'ntP4');
		IFApcMnNotes.oscResp(respName:'notePlusApcMn05', oscName:'nt_5', playDir:'ntP5');
		IFApcMnNotes.oscResp(respName:'notePlusApcMn06', oscName:'nt_6', playDir:'ntP6');
		IFApcMnNotes.oscResp(respName:'notePlusApcMn07', oscName:'nt_7', playDir:'ntP7');
		IFApcMnNotes.oscResp(respName:'notePlusApcMn08', oscName:'nt_8', playDir:'ntP8');
		IFApcMnNotes.oscResp(respName:'notePlusApcMn09', oscName:'nt_9', playDir:'ntP9');
		IFApcMnNotes.oscResp(respName:'notePlusApcMn10', oscName:'nt_10', playDir:'ntP10');
		IFApcMnNotes.oscResp(respName:'notePlusApcMn11', oscName:'nt_11', playDir:'ntP11');
		IFApcMnNotes.oscResp(respName:'notePlusApcMn12', oscName:'nt_12', playDir:'ntP12');
		IFApcMnNotes.oscResp(respName:'notePlusApcMn13', oscName:'nt_13', playDir:'ntP13');
		IFApcMnNotes.oscResp(respName:'notePlusApcMn14', oscName:'nt_14', playDir:'ntP14');
		//ntMinus
		IFApcMnNotes.oscResp(respName:'noteMinusApcMn01', oscName:'nt-1', playDir:'ntM1');
		IFApcMnNotes.oscResp(respName:'noteMinusApcMn02', oscName:'nt-2', playDir:'ntM2');
		IFApcMnNotes.oscResp(respName:'noteMinusApcMn03', oscName:'nt-3', playDir:'ntM3');
		IFApcMnNotes.oscResp(respName:'noteMinusApcMn04', oscName:'nt-4', playDir:'ntM4');
		IFApcMnNotes.oscResp(respName:'noteMinusApcMn05', oscName:'nt-5', playDir:'ntM5');
		IFApcMnNotes.oscResp(respName:'noteMinusApcMn06', oscName:'nt-6', playDir:'ntM6');
		IFApcMnNotes.oscResp(respName:'noteMinusApcMn07', oscName:'nt-7', playDir:'ntM7');
		IFApcMnNotes.oscResp(respName:'noteMinusApcMn08', oscName:'nt-8', playDir:'ntM8');
		IFApcMnNotes.oscResp(respName:'noteMinusApcMn09', oscName:'nt-9', playDir:'ntM9');
		IFApcMnNotes.oscResp(respName:'noteMinusApcMn10', oscName:'nt-10', playDir:'ntM10');
		IFApcMnNotes.oscResp(respName:'noteMinusApcMn11', oscName:'nt-11', playDir:'ntM11');
		IFApcMnNotes.oscResp(respName:'noteMinusApcMn12', oscName:'nt-12', playDir:'ntM12');
		IFApcMnNotes.oscResp(respName:'noteMinusApcMn13', oscName:'nt-13', playDir:'ntM13');
		IFApcMnNotes.oscResp(respName:'noteMinusApcMn14', oscName:'nt-14', playDir:'ntM14');

	}
	*oscResp{|respName,oscName,playDir|
		OSCdef(respName, {
			arg msg;
			playDir.switch(
				'ntP0',{if ( msg[1]==1, {this.noteButsReset; ~apcMn.noteOn(~apcMnCh, ~apcNoteBut04, 3); });},
				'ntP1',{if ( msg[1]==1, {this.noteButsReset; ~apcMn.noteOn(~apcMnCh, ~apcNoteBut05, 3); });},
				'ntP2',{if ( msg[1]==1, {this.noteButsReset; ~apcMn.noteOn(~apcMnCh, ~apcNoteBut06, 3); });},
				'ntP3',{if ( msg[1]==1, {this.noteButsReset; ~apcMn.noteOn(~apcMnCh, ~apcNoteBut07, 3); });},
				'ntP4',{if ( msg[1]==1, {this.noteButsReset; ~apcMn.noteOn(~apcMnCh, ~apcNoteBut08, 3); });},
				'ntP5',{if ( msg[1]==1, {this.noteButsReset; ~apcMn.noteOn(~apcMnCh, ~apcNoteBut13, 3); });},
				'ntP6',{if ( msg[1]==1, {this.noteButsReset; ~apcMn.noteOn(~apcMnCh, ~apcNoteBut14, 3); });},
				'ntP7',{if ( msg[1]==1, {this.noteButsReset; ~apcMn.noteOn(~apcMnCh, ~apcNoteBut15, 3); });},
				'ntP8',{if ( msg[1]==1, {this.noteButsReset; });},
				'ntP9',{if ( msg[1]==1, {this.noteButsReset; });},
				'ntP10',{if ( msg[1]==1, {this.noteButsReset; });},
				'ntP11',{if ( msg[1]==1, {this.noteButsReset; });},
				'ntP12',{if ( msg[1]==1, {this.noteButsReset; });},
				'ntP13',{if ( msg[1]==1, {this.noteButsReset; });},
				'ntP14',{if ( msg[1]==1, {this.noteButsReset; ~apcMn.noteOn(~apcMnCh, ~apcNoteBut16, 3); });},

				'ntM1',{if ( msg[1]==1, {this.noteButsReset;~apcMn.noteOn(~apcMnCh, ~apcNoteBut03, 3); });},
				'ntM2',{if ( msg[1]==1, {this.noteButsReset;~apcMn.noteOn(~apcMnCh, ~apcNoteBut02, 3); });},
				'ntM3',{if ( msg[1]==1, {this.noteButsReset;~apcMn.noteOn(~apcMnCh, ~apcNoteBut01, 3); });},
				'ntM4',{if ( msg[1]==1, {this.noteButsReset;~apcMn.noteOn(~apcMnCh, ~apcNoteBut11, 3); });},
				'ntM5',{if ( msg[1]==1, {this.noteButsReset;~apcMn.noteOn(~apcMnCh, ~apcNoteBut10, 3); });},
				'ntM6',{if ( msg[1]==1, {this.noteButsReset;~apcMn.noteOn(~apcMnCh, ~apcNoteBut09, 3); });},
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
}



/*



*/