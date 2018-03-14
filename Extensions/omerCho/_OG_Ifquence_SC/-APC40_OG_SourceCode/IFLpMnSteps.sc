/*
IFLoad.loadVolca;


PostAllMIDI.on;
PostAllMIDI.off;


IFLpMnSteps.button()
IFLpMnSteps.globals;
IFLpMnSteps.resetLeds;
*/

IFLpMnSteps{
	*load{
		this.globals;
		this.resetLeds;
		this.makeStepResponders;

	}//loadAtStart

	*globals{

		~stpLpBut1=0;~stpLpBut2=1;~stpLpBut3=2;~stpLpBut4=3;
		~stpLpBut5=4;~stpLpBut6=5;~stpLpBut7=6;~stpLpBut8=7;
		~stpLpBut9=16;~stpLpBut10=17;~stpLpBut11=18;~stpLpBut12=19;
		~stpLpBut13=20;~stpLpBut14=21;~stpLpBut15=22;~stpLpBut16=23;

		//~lpMn.noteOn(0, ~stpLpBut16, 0);

		~lpMnCh=0;
		~lnchLpBut1=0;~lnchLpBut2=1;~lnchLpBut3=2;~lnchLpBut4=3;
		~lnchLpBut5=4;~lnchLpBut6=5;~lnchLpBut7=6;~lnchLpBut8=7;

		~lnchLpBut9=16;~lnchLpBut10=17;~lnchLpBut11=18;~lnchLpBut12=19;
		~lnchLpBut13=20;~lnchLpBut14=21;~lnchLpBut15=22;~lnchLpBut16=23;

		~lnchLpBut17=32;~lnchLpBut18=33;~lnchLpBut19=34;~lnchLpBut20=35;
		~lnchLpBut21=36;~lnchLpBut22=37;~lnchLpBut23=38;~lnchLpBut24=39;

		~lnchLpBut25=48;~lnchLpBut26=49;~lnchLpBut27=50;~lnchLpBut28=51;
		~lnchLpBut29=52;~lnchLpBut30=53;~lnchLpBut31=54;~lnchLpBut32=55;

		~lnchLpBut33=64;~lnchLpBut34=65;~lnchLpBut35=66;~lnchLpBut36=67;
		~lnchLpBut37=68;~lnchLpBut38=69;~lnchLpBut39=70;~lnchLpBut40=71;
		//6
		~lnchLpBut41=80;~lnchLpBut42=81;~lnchLpBut43=82;~lnchLpBut44=83;
		~lnchLpBut45=84;~lnchLpBut46=85;~lnchLpBut47=86;~lnchLpBut48=87;
		//7
		~lnchLpBut49=96;~lnchLpBut50=97;~lnchLpBut51=98;~lnchLpBut52=99;
		~lnchLpBut53=100;~lnchLpBut54=101;~lnchLpBut55=102;~lnchLpBut56=103;
		//8
		~lnchLpBut57=112;~lnchLpBut58=113;~lnchLpBut59=114;~lnchLpBut60=115;
		~lnchLpBut61=116;~lnchLpBut62=117;~lnchLpBut63=118;~lnchLpBut64=119;




	}//globals


	////////////////////////
	//Step Sequencer Sixteen
	*makeStepResponders{

		IFLpMnSteps.button01(~stpLpBut1,\lncLpStepOn01, \lncLpStepOff01);
		IFLpMnSteps.button01(~stpLpBut2,\lncLpStepOn02, \lncLpStepOff02);
		IFLpMnSteps.button01(~stpLpBut3,\lncLpStepOn03, \lncLpStepOff03);
		IFLpMnSteps.button01(~stpLpBut4,\lncLpStepOn04, \lncLpStepOff04);
		IFLpMnSteps.button01(~stpLpBut5,\lncLpStepOn05, \lncLpStepOff05);
		IFLpMnSteps.button01(~stpLpBut6,\lncLpStepOn06, \lncLpStepOff06);
		IFLpMnSteps.button01(~stpLpBut7,\lncLpStepOn07, \lncLpStepOff07);
		IFLpMnSteps.button01(~stpLpBut8,\lncLpStepOn08, \lncLpStepOff08);

		IFLpMnSteps.button01(~stpLpBut9,\lncLpStepOn09, \lncLpStepOff09);
		IFLpMnSteps.button01(~stpLpBut10,\lncLpStepOn10, \lncLpStepOff10);
		IFLpMnSteps.button01(~stpLpBut11,\lncLpStepOn11, \lncLpStepOff11);
		IFLpMnSteps.button01(~stpLpBut12,\lncLpStepOn12, \lncLpStepOff12);
		IFLpMnSteps.button01(~stpLpBut13,\lncLpStepOn13, \lncLpStepOff13);
		IFLpMnSteps.button01(~stpLpBut14,\lncLpStepOn14, \lncLpStepOff14);
		IFLpMnSteps.button01(~stpLpBut15,\lncLpStepOn15, \lncLpStepOff15);
		IFLpMnSteps.button01(~stpLpBut16,\lncLpStepOn16, \lncLpStepOff16);

	}

	*button01{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~stpLpBut1,{~local.sendMsg('seqStep0l', 1);},
				~stpLpBut2,{~local.sendMsg('seqStep02', 1);},
				~stpLpBut3,{~local.sendMsg('seqStep03', 1);},
				~stpLpBut4,{~local.sendMsg('seqStep04', 1);},
				~stpLpBut5,{~local.sendMsg('seqStep05', 1);},
				~stpLpBut6,{~local.sendMsg('seqStep06', 1);},
				~stpLpBut7,{~local.sendMsg('seqStep07', 1);},
				~stpLpBut8,{~local.sendMsg('seqStep08', 1);},
				~stpLpBut9,{~local.sendMsg('seqStep09', 1);},
				~stpLpBut10,{~local.sendMsg('seqStep10', 1);},
				~stpLpBut11,{~local.sendMsg('seqStep11', 1);},
				~stpLpBut12,{~local.sendMsg('seqStep12', 1);},
				~stpLpBut13,{~local.sendMsg('seqStep13', 1);},
				~stpLpBut14,{~local.sendMsg('seqStep14', 1);},
				~stpLpBut15,{~local.sendMsg('seqStep15', 1);},
				~stpLpBut16,{~local.sendMsg('seqStep16', 1);}
			);

		},srcID:~lpMnInID, chan:0,noteNum:ntNum);

		MIDIdef.noteOff(nameOff, {
			arg chan,noteNum;

			ntNum.switch(
				~stpLpBut1,{~local.sendMsg('seqStep0l', 0);},
				~stpLpBut2,{~local.sendMsg('seqStep02', 0);},
				~stpLpBut3,{~local.sendMsg('seqStep03', 0);},
				~stpLpBut4,{~local.sendMsg('seqStep04', 0);},
				~stpLpBut5,{~local.sendMsg('seqStep05', 0);},
				~stpLpBut6,{~local.sendMsg('seqStep06', 0);},
				~stpLpBut7,{~local.sendMsg('seqStep07', 0);},
				~stpLpBut8,{~local.sendMsg('seqStep08', 0);},
				~stpLpBut9,{~local.sendMsg('seqStep09', 0);},
				~stpLpBut10,{~local.sendMsg('seqStep10', 0);},
				~stpLpBut11,{~local.sendMsg('seqStep11', 0);},
				~stpLpBut12,{~local.sendMsg('seqStep12', 0);},
				~stpLpBut13,{~local.sendMsg('seqStep13', 0);},
				~stpLpBut14,{~local.sendMsg('seqStep14', 0);},
				~stpLpBut15,{~local.sendMsg('seqStep15', 0);},
				~stpLpBut16,{~local.sendMsg('seqStep16', 0);}
			);

		},srcID:~lpMnInID, chan:0,noteNum:ntNum);
	}
	*button02{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~stpLpBut49,{~local.sendMsg('seqStep09', 1);},
				~stpLpBut50,{~local.sendMsg('seqStep10', 1);},
				~stpLpBut51,{~local.sendMsg('seqStep11', 1);},
				~stpLpBut52,{~local.sendMsg('seqStep12', 1);},
				~stpLpBut53,{~local.sendMsg('seqStep13', 1);},
				~stpLpBut54,{~local.sendMsg('seqStep14', 1);},
				~stpLpBut55,{~local.sendMsg('seqStep15', 1);},
				~stpLpBut56,{~local.sendMsg('seqStep16', 1);}
			);

		},srcID:~lpMnInID, chan:0,noteNum:ntNum);

		MIDIdef.noteOff(nameOff, {
			arg chan,noteNum;

			ntNum.switch(
				~stpLpBut49,{~local.sendMsg('seqStep09', 0);},
				~stpLpBut50,{~local.sendMsg('seqStep10', 0);},
				~stpLpBut51,{~local.sendMsg('seqStep11', 0);},
				~stpLpBut52,{~local.sendMsg('seqStep12', 0);},
				~stpLpBut53,{~local.sendMsg('seqStep13', 0);},
				~stpLpBut54,{~local.sendMsg('seqStep14', 0);},
				~stpLpBut55,{~local.sendMsg('seqStep15', 0);},
				~stpLpBut56,{~local.sendMsg('seqStep16', 0);}
			);

		},srcID:~lpMnInID, chan:0,noteNum:ntNum);
	}

	*led{|index|

		index.switch(
			1,{this.ledOnOff(~stpLpBut1);},
			2,{this.ledOnOff(~stpLpBut2);},
			3,{this.ledOnOff(~stpLpBut3);},
			4,{this.ledOnOff(~stpLpBut4);},
			5,{this.ledOnOff(~stpLpBut5);},
			6,{this.ledOnOff(~stpLpBut6);},
			7,{this.ledOnOff(~stpLpBut7);},
			8,{this.ledOnOff(~stpLpBut8);},
			9,{this.ledOnOff(~stpLpBut9);},
			10,{this.ledOnOff(~stpLpBut10);},
			11,{this.ledOnOff(~stpLpBut11);},
			12,{this.ledOnOff(~stpLpBut12);},
			13,{this.ledOnOff(~stpLpBut13);},
			14,{this.ledOnOff(~stpLpBut14);},
			15,{this.ledOnOff(~stpLpBut15);},
			16,{this.ledOnOff(~stpLpBut16);}
		);
	}
	*ledOnOff {|ntNum|
		ntNum.switch(
			~stpLpBut1,{
				this.ledForkRed(~stpLpBut1);
			},
			~stpLpBut2,{
				this.ledForkYellow(~stpLpBut2);
			},
			~stpLpBut3,{
				this.ledForkYellow(~stpLpBut3);
			},
			~stpLpBut4,{
				this.ledForkYellow(~stpLpBut4);
			},
			~stpLpBut5,{
				this.ledForkRed(~stpLpBut5);
			},
			~stpLpBut6,{
				this.ledForkYellow(~stpLpBut6);
			},
			~stpLpBut7,{
				this.ledForkYellow(~stpLpBut7);
			},
			~stpLpBut8,{
				this.ledForkYellow(~stpLpBut8);
			},
			~stpLpBut9,{
				this.ledForkRed(~stpLpBut9);
			},
			~stpLpBut10,{
				this.ledForkYellow(~stpLpBut10);
			},
			~stpLpBut11,{
				this.ledForkYellow(~stpLpBut11);
			},
			~stpLpBut12,{
				this.ledForkYellow(~stpLpBut12);
			},
			~stpLpBut13,{
				this.ledForkRed(~stpLpBut13);
			},
			~stpLpBut14,{
				this.ledForkYellow(~stpLpBut14);
			},
			~stpLpBut15,{
				this.ledForkYellow(~stpLpBut15);
			},
			~stpLpBut16,{
				this.ledForkYellow(~stpLpBut16);
			}



		)

	}
	*ledForkRed{|ntNum|
		fork{
			~lpMn.noteOn(0, ntNum, 0);
			0.3.wait;
			~lpMn.noteOn(0, ntNum, 3);
		};
	}
	*ledForkYellow{|ntNum|
		fork{
			~lpMn.noteOn(0, ntNum, 0);
			0.3.wait;
			~lpMn.noteOn(0, ntNum, 5);
		};
	}
	*ledForkGreen{|ntNum|
		fork{
			~lpMn.noteOn(0, ntNum, 0);
			0.3.wait;
			~lpMn.noteOn(0, ntNum, 1);
		};
	}

	*resetLeds{

		//Sequencer
		//Lounch1
		~lpMn.noteOn(~lpMnCh, ~stpLpBut1, 3); //But 1
		~lpMn.noteOn(~lpMnCh, ~stpLpBut2, 5); //But 2
		~lpMn.noteOn(~lpMnCh, ~stpLpBut3, 5); //But 3
		~lpMn.noteOn(~lpMnCh, ~stpLpBut4, 5); //But 4

		~lpMn.noteOn(~lpMnCh, ~stpLpBut5, 3); //But 5
		~lpMn.noteOn(~lpMnCh, ~stpLpBut6, 5); //But 6
		~lpMn.noteOn(~lpMnCh, ~stpLpBut7, 5); //But 7
		~lpMn.noteOn(~lpMnCh, ~stpLpBut8, 5); //But 8
		//Lounch 2
		~lpMn.noteOn(~lpMnCh, ~stpLpBut9, 3); //But 1
		~lpMn.noteOn(~lpMnCh, ~stpLpBut10, 5); //But 2
		~lpMn.noteOn(~lpMnCh, ~stpLpBut11, 5); //But 3
		~lpMn.noteOn(~lpMnCh, ~stpLpBut12, 5); //But 4

		~lpMn.noteOn(~lpMnCh, ~stpLpBut13, 3); //But 5
		~lpMn.noteOn(~lpMnCh, ~stpLpBut14, 5); //But 6
		~lpMn.noteOn(~lpMnCh, ~stpLpBut15, 5); //But 7
		~lpMn.noteOn(~lpMnCh, ~stpLpBut16, 5); //But 8



	}
}

/*

IFLpMnSteps.led(9);
IFLpMnSteps.ledOnOff(9);
IFLpMnSteps.ledForkRed(~stpLpBut9);

*/