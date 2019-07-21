/*
IFLoad.loadVolca;


PostAllMIDI.on;
PostAllMIDI.off;


IFLaunchSteps.button()
IFLaunchSteps.globals;
IFLaunchSteps.resetLeds;
*/

IFLaunchSteps{
	*load{
		this.globals;
		this.resetLeds;
		this.makeStepResponders;

	}//loadAtStart

	*globals{

		~stpBut1=56;~stpBut2=57;~stpBut3=58;~stpBut4=59;
		~stpBut5=60;~stpBut6=61;~stpBut7=62;~stpBut8=63;
		~stpBut9=48;~stpBut10=49;~stpBut11=50;~stpBut12=51;
		~stpBut13=52;~stpBut14=53;~stpBut15=54;~stpBut16=55;

		~stpBut17=40;~stpBut18=41;~stpBut19=42;~stpBut20=43;
		~stpBut21=44;~stpBut22=45;~stpBut23=46;~stpBut24=47;
		~stpBut25=32;~stpBut26=33;~stpBut27=34;~stpBut28=35;
		~stpBut29=36;~stpBut30=37;~stpBut31=38;~stpBut32=39;
		//~apcMn.noteOn(0, ~stpBut16, 0);

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


	////////////////////////
	//Step Sequencer Sixteen
	*makeStepResponders{

		IFLaunchSteps.button01(~stpBut1,\lncStepOn01, \lncStepOff01);
		IFLaunchSteps.button01(~stpBut2,\lncStepOn02, \lncStepOff02);
		IFLaunchSteps.button01(~stpBut3,\lncStepOn03, \lncStepOff03);
		IFLaunchSteps.button01(~stpBut4,\lncStepOn04, \lncStepOff04);
		IFLaunchSteps.button01(~stpBut5,\lncStepOn05, \lncStepOff05);
		IFLaunchSteps.button01(~stpBut6,\lncStepOn06, \lncStepOff06);
		IFLaunchSteps.button01(~stpBut7,\lncStepOn07, \lncStepOff07);
		IFLaunchSteps.button01(~stpBut8,\lncStepOn08, \lncStepOff08);

		IFLaunchSteps.button01(~stpBut9,\lncStepOn09, \lncStepOff09);
		IFLaunchSteps.button01(~stpBut10,\lncStepOn10, \lncStepOff10);
		IFLaunchSteps.button01(~stpBut11,\lncStepOn11, \lncStepOff11);
		IFLaunchSteps.button01(~stpBut12,\lncStepOn12, \lncStepOff12);
		IFLaunchSteps.button01(~stpBut13,\lncStepOn13, \lncStepOff13);
		IFLaunchSteps.button01(~stpBut14,\lncStepOn14, \lncStepOff14);
		IFLaunchSteps.button01(~stpBut15,\lncStepOn15, \lncStepOff15);
		IFLaunchSteps.button01(~stpBut16,\lncStepOn16, \lncStepOff16);

	}

	*button01{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~stpBut1,{~local.sendMsg('seqStep0l', 1);},
				~stpBut2,{~local.sendMsg('seqStep02', 1);},
				~stpBut3,{~local.sendMsg('seqStep03', 1);},
				~stpBut4,{~local.sendMsg('seqStep04', 1);},
				~stpBut5,{~local.sendMsg('seqStep05', 1);},
				~stpBut6,{~local.sendMsg('seqStep06', 1);},
				~stpBut7,{~local.sendMsg('seqStep07', 1);},
				~stpBut8,{~local.sendMsg('seqStep08', 1);},
				~stpBut9,{~local.sendMsg('seqStep09', 1);},
				~stpBut10,{~local.sendMsg('seqStep10', 1);},
				~stpBut11,{~local.sendMsg('seqStep11', 1);},
				~stpBut12,{~local.sendMsg('seqStep12', 1);},
				~stpBut13,{~local.sendMsg('seqStep13', 1);},
				~stpBut14,{~local.sendMsg('seqStep14', 1);},
				~stpBut15,{~local.sendMsg('seqStep15', 1);},
				~stpBut16,{~local.sendMsg('seqStep16', 1);}
			);

		},srcID:~apcMnInID, chan:0,noteNum:ntNum);

		MIDIdef.noteOff(nameOff, {
			arg chan,noteNum;

			ntNum.switch(
				~stpBut1,{~local.sendMsg('seqStep0l', 0);},
				~stpBut2,{~local.sendMsg('seqStep02', 0);},
				~stpBut3,{~local.sendMsg('seqStep03', 0);},
				~stpBut4,{~local.sendMsg('seqStep04', 0);},
				~stpBut5,{~local.sendMsg('seqStep05', 0);},
				~stpBut6,{~local.sendMsg('seqStep06', 0);},
				~stpBut7,{~local.sendMsg('seqStep07', 0);},
				~stpBut8,{~local.sendMsg('seqStep08', 0);},
				~stpBut9,{~local.sendMsg('seqStep09', 0);},
				~stpBut10,{~local.sendMsg('seqStep10', 0);},
				~stpBut11,{~local.sendMsg('seqStep11', 0);},
				~stpBut12,{~local.sendMsg('seqStep12', 0);},
				~stpBut13,{~local.sendMsg('seqStep13', 0);},
				~stpBut14,{~local.sendMsg('seqStep14', 0);},
				~stpBut15,{~local.sendMsg('seqStep15', 0);},
				~stpBut16,{~local.sendMsg('seqStep16', 0);}
			);

		},srcID:~apcMnInID, chan:0,noteNum:ntNum);
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

		},srcID:~apcMnInID, chan:0,noteNum:ntNum);

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

		},srcID:~apcMnInID, chan:0,noteNum:ntNum);
	}

	*led{|index|

		index.switch(
			1,{this.ledOnOff(~stpBut1);},
			2,{this.ledOnOff(~stpBut2);},
			3,{this.ledOnOff(~stpBut3);},
			4,{this.ledOnOff(~stpBut4);},
			5,{this.ledOnOff(~stpBut5);},
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
			~stpBut9,{
				this.ledForkRed(~stpBut9);
			},
			~stpBut10,{
				this.ledForkYellow(~stpBut10);
			},
			~stpBut11,{
				this.ledForkYellow(~stpBut11);
			},
			~stpBut12,{
				this.ledForkYellow(~stpBut12);
			},
			~stpBut13,{
				this.ledForkRed(~stpBut13);
			},
			~stpBut14,{
				this.ledForkYellow(~stpBut14);
			},
			~stpBut15,{
				this.ledForkYellow(~stpBut15);
			},
			~stpBut16,{
				this.ledForkYellow(~stpBut16);
			}
		)

	}
	*ledForkRed{|ntNum|
		fork{
			~apcMn.noteOn(0, ntNum, 0);
			0.3.wait;
			~apcMn.noteOn(0, ntNum, 3);
		};
	}
	*ledForkYellow{|ntNum|
		fork{
			~apcMn.noteOn(0, ntNum, 0);
			0.3.wait;
			~apcMn.noteOn(0, ntNum, 5);
		};
	}
	*ledForkGreen{|ntNum|
		fork{
			~apcMn.noteOn(0, ntNum, 0);
			0.3.wait;
			~apcMn.noteOn(0, ntNum, 1);
		};
	}

	*resetLeds{
		//Sequencer
		//Lounch
		~apcMn.noteOn(~apcMnCh, ~stpBut1, 3); //But 1
		~apcMn.noteOn(~apcMnCh, ~stpBut2, 5); //But 2
		~apcMn.noteOn(~apcMnCh, ~stpBut3, 5); //But 3
		~apcMn.noteOn(~apcMnCh, ~stpBut4, 5); //But 4

		~apcMn.noteOn(~apcMnCh, ~stpBut5, 3); //But 5
		~apcMn.noteOn(~apcMnCh, ~stpBut6, 5); //But 6
		~apcMn.noteOn(~apcMnCh, ~stpBut7, 5); //But 7
		~apcMn.noteOn(~apcMnCh, ~stpBut8, 5); //But 8
		//Lounch 2
		~apcMn.noteOn(~apcMnCh, ~stpBut9, 3); //But 1
		~apcMn.noteOn(~apcMnCh, ~stpBut10, 5); //But 2
		~apcMn.noteOn(~apcMnCh, ~stpBut11, 5); //But 3
		~apcMn.noteOn(~apcMnCh, ~stpBut12, 5); //But 4

		~apcMn.noteOn(~apcMnCh, ~stpBut13, 3); //But 5
		~apcMn.noteOn(~apcMnCh, ~stpBut14, 5); //But 6
		~apcMn.noteOn(~apcMnCh, ~stpBut15, 5); //But 7
		~apcMn.noteOn(~apcMnCh, ~stpBut16, 5); //But 8
		//Lounch 3
		~apcMn.noteOn(~apcMnCh, ~stpBut17, 0); //But 1
		~apcMn.noteOn(~apcMnCh, ~stpBut18, 0); //But 2
		~apcMn.noteOn(~apcMnCh, ~stpBut19, 0); //But 3
		~apcMn.noteOn(~apcMnCh, ~stpBut20, 0); //But 4

		~apcMn.noteOn(~apcMnCh, ~stpBut21, 0); //But 5
		~apcMn.noteOn(~apcMnCh, ~stpBut22, 0); //But 6
		~apcMn.noteOn(~apcMnCh, ~stpBut23, 0); //But 7
		~apcMn.noteOn(~apcMnCh, ~stpBut24, 0); //But 8
		//Lounch 4
		~apcMn.noteOn(~apcMnCh, ~stpBut25, 0); //But 1
		~apcMn.noteOn(~apcMnCh, ~stpBut26, 0); //But 2
		~apcMn.noteOn(~apcMnCh, ~stpBut27, 0); //But 3
		~apcMn.noteOn(~apcMnCh, ~stpBut28, 0); //But 4

		~apcMn.noteOn(~apcMnCh, ~stpBut29, 0); //But 5
		~apcMn.noteOn(~apcMnCh, ~stpBut30, 0); //But 6
		~apcMn.noteOn(~apcMnCh, ~stpBut31, 0); //But 7
		~apcMn.noteOn(~apcMnCh, ~stpBut32, 0); //But 8
	}
}

/*
IFApcMnNotes.oscResp;

IFLaunchSteps.led(9);
IFLaunchSteps.ledOnOff(9);
IFLaunchSteps.ledForkRed(~stpBut9);

*/