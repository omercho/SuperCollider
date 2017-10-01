/*

PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

~lpMn.uid;

*/

IFLaunchNotes{

	*load{
		this.addr;
		this.globals;
		this.resetLeds;
		this.makeNoteResponders;

	}//loadAtStart
	*addr{
		~lpMn = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST1 LPMn");
		~lpMnOutID=(-2121236207);
		~lpMnInID=(1843132735);
	}
	*globals{


		~lpMnCh=0;

		//1
		~lpMnBut1=0;~lpMnBut2=1;~lpMnBut3=2;~lpMnBut4=3;
		~lpMnBut5=4;~lpMnBut6=5;~lpMnBut7=6;~lpMnBut8=7;
		//2
		~lpMnBut9=8;~lpMnBut10=9;~lpMnBut11=10;~lpMnBut12=11;
		~lpMnBut13=12;~lpMnBut14=13;~lpMnBut15=14;~lpMnBut16=15;
		//3
		~lpMnBut17=32;~lpMnBut18=33;~lpMnBut19=34;~lpMnBut20=35;
		~lpMnBut21=36;~lpMnBut22=37;~lpMnBut23=38;~lpMnBut24=39;
		//4
		~lpMnBut25=48;~lpMnBut26=49;~lpMnBut27=50;~lpMnBut28=51;
		~lpMnBut29=52;~lpMnBut30=53;~lpMnBut31=54;~lpMnBut32=55;
		//5
		~lpMnBut33=64;~lpMnBut34=65;~lpMnBut35=66;~lpMnBut36=67;
		~lpMnBut37=68;~lpMnBut38=69;~lpMnBut39=70;~lpMnBut40=71;
		//6
		~lpMnBut41=80;~lpMnBut42=81;~lpMnBut43=82;~lpMnBut44=83;
		~lpMnBut45=84;~lpMnBut46=85;~lpMnBut47=86;~lpMnBut48=87;
		//7
		~lpMnBut49=96;~lpMnBut50=97;~lpMnBut51=98;~lpMnBut52=99;
		~lpMnBut53=100;~lpMnBut54=101;~lpMnBut55=102;~lpMnBut56=103;
		//8
		~lpMnBut57=112;~lpMnBut58=113;~lpMnBut59=114;~lpMnBut60=115;
		~lpMnBut61=116;~lpMnBut62=117;~lpMnBut63=118;~lpMnBut64=119;

		~red1=1;
		~red2=2;
		~red3=3;

		~orng1=21;//23
		~orng2=63;
		~orng3=18;//115
		~orng4=19;//83-63

		~green1=20;
		~green2=32;//96
		~green3=48;//84

		~yellow1=33;//114
		~yellow2=118;//118
		~yellow3=113;//113



	}//globals

	//Notes
	*makeNoteResponders{
		//NoteLine1
		IFLaunchNotes.noteButL1(~lpMnBut41,\lncNote_3);
		IFLaunchNotes.noteButL1(~lpMnBut42,\lncNote_2);
		IFLaunchNotes.noteButL1(~lpMnBut43,\lncNote_1);
		IFLaunchNotes.noteButL1(~lpMnBut44,\lncNote00);
		IFLaunchNotes.noteButL1(~lpMnBut45,\lncNote01);
		IFLaunchNotes.noteButL1(~lpMnBut46,\lncNote02);
		IFLaunchNotes.noteButL1(~lpMnBut47,\lncNote03);
		IFLaunchNotes.noteButL1(~lpMnBut48,\lncNote04);
		//NoteLine2
		IFLaunchNotes.noteButL2(~lpMnBut49,\lncNote_6);
		IFLaunchNotes.noteButL2(~lpMnBut50,\lncNote_5);
		IFLaunchNotes.noteButL2(~lpMnBut51,\lncNote_4);
		IFLaunchNotes.noteButL2(~lpMnBut52,\lncNote05);
		IFLaunchNotes.noteButL2(~lpMnBut53,\lncNote06);
		IFLaunchNotes.noteButL2(~lpMnBut54,\lncNote07);
		IFLaunchNotes.noteButL2(~lpMnBut55,\lncNote08);
		IFLaunchNotes.noteButL2(~lpMnBut56,\lncNote11);
		//NoteLine3
		//IFLaunchNotes.noteButL3(~lpMnBut57,\lncShufKick);
		//IFLaunchNotes.noteButL3(~lpMnBut58,\lncShufSnr);
		//IFLaunchNotes.noteButL3(~lpMnBut59,\lncShufHat);
		//IFLaunchNotes.noteButL3(~lpMnBut60,\lncShufDrum);
		//IFLaunchNotes.noteButL3(~lpMnBut61,\lncShufBass);
		//IFLaunchNotes.noteButL3(~lpMnBut62,\lncShufKeys);
		//IFLaunchNotes.noteButL3(~lpMnBut63,\lncShufSamp);
		//IFLaunchNotes.noteButL3(~lpMnBut64,\lncNote11);


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
	IFLaunchNotes.resetLeds;
	*/
	*resetLeds{

		//NULL
		//Lounch 2
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