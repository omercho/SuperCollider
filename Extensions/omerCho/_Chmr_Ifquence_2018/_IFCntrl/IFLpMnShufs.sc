/*

PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

~lpMn.uid;

*/

IFLpMnShufs{

	*load{
		//this.addr;
		//this.globals;
		this.resetLeds;
		this.makeShResponders;

	}//loadAtStart
	*addr{

	}
	*globals{

	}//globals

	//Notes
	*makeShResponders{
		//NoteLine1
		IFLpMnShufs.shButL1(~lpMnBut41,\lncSh1);
		IFLpMnShufs.shButL1(~lpMnBut42,\lncSh2);
		IFLpMnShufs.shButL1(~lpMnBut43,\lncSh3);
		IFLpMnShufs.shButL1(~lpMnBut44,\lncSh4);
		IFLpMnShufs.shButL1(~lpMnBut45,\lncSh5);
		IFLpMnShufs.shButL1(~lpMnBut46,\lncSh6);
		IFLpMnShufs.shButL1(~lpMnBut47,\lncSh7);
		IFLpMnShufs.shButL1(~lpMnBut48,\lncSh8);
		//NoteLine2
		IFLpMnShufs.shButL2(~lpMnBut49,\lncShKick);
		IFLpMnShufs.shButL2(~lpMnBut50,\lncShSnr);
		IFLpMnShufs.shButL2(~lpMnBut51,\lncShHat);
		IFLpMnShufs.shButL2(~lpMnBut52,\lncShBass);
		IFLpMnShufs.shButL2(~lpMnBut53,\lncShKeys);
		IFLpMnShufs.shButL2(~lpMnBut54,\lncShSamp);
		IFLpMnShufs.shButL2(~lpMnBut55,\lncShMopho);
		IFLpMnShufs.shButL2(~lpMnBut56,\lncSh8b);



	}
	*shButL1{|ntNum, nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut33,{
					~local.sendMsg('shuf1', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut33, 3); //But 1
				},
				~lpMnBut34,{
					~local.sendMsg('shuf2', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut34, 3); //But 1
				},
				~lpMnBut35,{
					~local.sendMsg('shuf3', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut35, 3); //But 1
				},
				~lpMnBut36,{/////---------------Shuf
					~local.sendMsg('shuf4', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut36, 6); //But 1
				},
				~lpMnBut37,{
					~local.sendMsg('shuf5', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut37, 3); //But 1
				},
				~lpMnBut38,{
					~local.sendMsg('shuf6', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut38, 3); //But 1
				},
				~lpMnBut39,{
					~local.sendMsg('shuf7', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut39, 3); //But 1
				},
				~lpMnBut40,{
					~local.sendMsg('shuf8', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut40, 3); //But 1
				}
			);

		},srcID:~lpMnInID, chan:~lpMnCh,noteNum:ntNum);
	}

	*shButL2{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut41,{
					~local.sendMsg('shufKick', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut41, 3); //But 1
				},
				~lpMnBut42,{
					~local.sendMsg('shufSnr', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut42, 3); //But 1
				},
				~lpMnBut43,{
					~local.sendMsg('shufHat', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut43, 3); //But 1
				},
				~lpMnBut44,{
					~local.sendMsg('shufBass', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut44, 3); //But 1
				},
				~lpMnBut45,{
					~local.sendMsg('shufKeys', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut45, 3); //But 1
				},
				~lpMnBut46,{
					~local.sendMsg('shufSamp', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut46, 3); //But 1
				},
				~lpMnBut47,{
					~local.sendMsg('shufMopho', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut47, 3); //But 1
				},
				~lpMnBut48,{
					~local.sendMsg('shufMopho8b', 1);
					this.shButsReset;
					~lpMn.noteOn(~lpMnCh, ~lpMnBut48, 3); //But 1
				}
			);

		},srcID:~lpMnInID, chan:~lpMnCh,noteNum:ntNum);
	}

	*shButsReset{
			//Notes
		//Lounch 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut33, ~yellow3); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut34, ~yellow3); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut35, ~yellow3); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut36, ~yellow3); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut37, ~yellow3); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut38, ~yellow3); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut39, ~yellow3); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut40, ~yellow3); //But 8
		//Lounch 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut41, ~yellow2); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut42, ~yellow2); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut43, ~yellow2); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut44, ~yellow2); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut45, ~yellow2); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut46, ~yellow2); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut47, ~yellow2); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut48, ~yellow2); //But 8

	}

	/*
	IFLpMnShufs.resetLeds;
	*/
	*resetLeds{

		//NULL

		//Lounch 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut33, ~yellow3); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut34, ~yellow3); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut35, ~yellow3); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut36, ~yellow3); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut37, ~yellow3); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut38, ~yellow3); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut39, ~yellow3); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut40, ~yellow3); //But 8
		//Lounch 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut41, ~yellow2); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut42, ~yellow2); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut43, ~yellow2); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut44, ~yellow2); //But 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut45, ~yellow2); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut46, ~yellow2); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut47, ~yellow2); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut48, ~yellow2); //But 8




	}

}



/*



*/