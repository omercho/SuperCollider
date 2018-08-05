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




	}//globals


	////////////////////////
	//Step Sequencer Sixteen
	*makeStepResponders{

		IFLpMnSteps.button01(~lpMnBut1,\lncLpStepOn01, \lncLpStepOff01);
		IFLpMnSteps.button01(~lpMnBut2,\lncLpStepOn02, \lncLpStepOff02);
		IFLpMnSteps.button01(~lpMnBut3,\lncLpStepOn03, \lncLpStepOff03);
		IFLpMnSteps.button01(~lpMnBut4,\lncLpStepOn04, \lncLpStepOff04);
		IFLpMnSteps.button01(~lpMnBut5,\lncLpStepOn05, \lncLpStepOff05);
		IFLpMnSteps.button01(~lpMnBut6,\lncLpStepOn06, \lncLpStepOff06);
		IFLpMnSteps.button01(~lpMnBut7,\lncLpStepOn07, \lncLpStepOff07);
		IFLpMnSteps.button01(~lpMnBut8,\lncLpStepOn08, \lncLpStepOff08);

		IFLpMnSteps.button01(~lpMnBut9,\lncLpStepOn09, \lncLpStepOff09);
		IFLpMnSteps.button01(~lpMnBut10,\lncLpStepOn10, \lncLpStepOff10);
		IFLpMnSteps.button01(~lpMnBut11,\lncLpStepOn11, \lncLpStepOff11);
		IFLpMnSteps.button01(~lpMnBut12,\lncLpStepOn12, \lncLpStepOff12);
		IFLpMnSteps.button01(~lpMnBut13,\lncLpStepOn13, \lncLpStepOff13);
		IFLpMnSteps.button01(~lpMnBut14,\lncLpStepOn14, \lncLpStepOff14);
		IFLpMnSteps.button01(~lpMnBut15,\lncLpStepOn15, \lncLpStepOff15);
		IFLpMnSteps.button01(~lpMnBut16,\lncLpStepOn16, \lncLpStepOff16);

	}

	*button01{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut1,{~local.sendMsg('seqStep01', 1);},
				~lpMnBut2,{~local.sendMsg('seqStep02', 1);},
				~lpMnBut3,{~local.sendMsg('seqStep03', 1);},
				~lpMnBut4,{~local.sendMsg('seqStep04', 1);},
				~lpMnBut5,{~local.sendMsg('seqStep05', 1);},
				~lpMnBut6,{~local.sendMsg('seqStep06', 1);},
				~lpMnBut7,{~local.sendMsg('seqStep07', 1);},
				~lpMnBut8,{~local.sendMsg('seqStep08', 1);},
				~lpMnBut9,{~local.sendMsg('seqStep09', 1);},
				~lpMnBut10,{~local.sendMsg('seqStep10', 1);},
				~lpMnBut11,{~local.sendMsg('seqStep11', 1);},
				~lpMnBut12,{~local.sendMsg('seqStep12', 1);},
				~lpMnBut13,{~local.sendMsg('seqStep13', 1);},
				~lpMnBut14,{~local.sendMsg('seqStep14', 1);},
				~lpMnBut15,{~local.sendMsg('seqStep15', 1);},
				~lpMnBut16,{~local.sendMsg('seqStep16', 1);}
			);

		},srcID:~lpMnInID, chan:0,noteNum:ntNum);

		MIDIdef.noteOff(nameOff, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut1,{~local.sendMsg('seqStep0l', 0);},
				~lpMnBut2,{~local.sendMsg('seqStep02', 0);},
				~lpMnBut3,{~local.sendMsg('seqStep03', 0);},
				~lpMnBut4,{~local.sendMsg('seqStep04', 0);},
				~lpMnBut5,{~local.sendMsg('seqStep05', 0);},
				~lpMnBut6,{~local.sendMsg('seqStep06', 0);},
				~lpMnBut7,{~local.sendMsg('seqStep07', 0);},
				~lpMnBut8,{~local.sendMsg('seqStep08', 0);},
				~lpMnBut9,{~local.sendMsg('seqStep09', 0);},
				~lpMnBut10,{~local.sendMsg('seqStep10', 0);},
				~lpMnBut11,{~local.sendMsg('seqStep11', 0);},
				~lpMnBut12,{~local.sendMsg('seqStep12', 0);},
				~lpMnBut13,{~local.sendMsg('seqStep13', 0);},
				~lpMnBut14,{~local.sendMsg('seqStep14', 0);},
				~lpMnBut15,{~local.sendMsg('seqStep15', 0);},
				~lpMnBut16,{~local.sendMsg('seqStep16', 0);}
			);

		},srcID:~lpMnInID, chan:0,noteNum:ntNum);
	}
	*button02{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut49,{~local.sendMsg('seqStep09', 1);},
				~lpMnBut50,{~local.sendMsg('seqStep10', 1);},
				~lpMnBut51,{~local.sendMsg('seqStep11', 1);},
				~lpMnBut52,{~local.sendMsg('seqStep12', 1);},
				~lpMnBut53,{~local.sendMsg('seqStep13', 1);},
				~lpMnBut54,{~local.sendMsg('seqStep14', 1);},
				~lpMnBut55,{~local.sendMsg('seqStep15', 1);},
				~lpMnBut56,{~local.sendMsg('seqStep16', 1);}
			);

		},srcID:~lpMnInID, chan:0,noteNum:ntNum);

		MIDIdef.noteOff(nameOff, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut49,{~local.sendMsg('seqStep09', 0);},
				~lpMnBut50,{~local.sendMsg('seqStep10', 0);},
				~lpMnBut51,{~local.sendMsg('seqStep11', 0);},
				~lpMnBut52,{~local.sendMsg('seqStep12', 0);},
				~lpMnBut53,{~local.sendMsg('seqStep13', 0);},
				~lpMnBut54,{~local.sendMsg('seqStep14', 0);},
				~lpMnBut55,{~local.sendMsg('seqStep15', 0);},
				~lpMnBut56,{~local.sendMsg('seqStep16', 0);}
			);

		},srcID:~lpMnInID, chan:0,noteNum:ntNum);
	}

	*led{|index|

		index.switch(
			1,{this.ledOnOff(~lpMnBut1);},
			2,{this.ledOnOff(~lpMnBut2);},
			3,{this.ledOnOff(~lpMnBut3);},
			4,{this.ledOnOff(~lpMnBut4);},
			5,{this.ledOnOff(~lpMnBut5);},
			6,{this.ledOnOff(~lpMnBut6);},
			7,{this.ledOnOff(~lpMnBut7);},
			8,{this.ledOnOff(~lpMnBut8);},
			9,{this.ledOnOff(~lpMnBut9);},
			10,{this.ledOnOff(~lpMnBut10);},
			11,{this.ledOnOff(~lpMnBut11);},
			12,{this.ledOnOff(~lpMnBut12);},
			13,{this.ledOnOff(~lpMnBut13);},
			14,{this.ledOnOff(~lpMnBut14);},
			15,{this.ledOnOff(~lpMnBut15);},
			16,{this.ledOnOff(~lpMnBut16);}
		);
	}
	*ledOnOff {|ntNum|
		ntNum.switch(
			~lpMnBut1,{
				this.ledForkRed(~lpMnBut1);
			},
			~lpMnBut2,{
				this.ledForkYellow(~lpMnBut2);
			},
			~lpMnBut3,{
				this.ledForkYellow(~lpMnBut3);
			},
			~lpMnBut4,{
				this.ledForkYellow(~lpMnBut4);
			},
			~lpMnBut5,{
				this.ledForkRed(~lpMnBut5);
			},
			~lpMnBut6,{
				this.ledForkYellow(~lpMnBut6);
			},
			~lpMnBut7,{
				this.ledForkYellow(~lpMnBut7);
			},
			~lpMnBut8,{
				this.ledForkYellow(~lpMnBut8);
			},
			~lpMnBut9,{
				this.ledForkRed(~lpMnBut9);
			},
			~lpMnBut10,{
				this.ledForkYellow(~lpMnBut10);
			},
			~lpMnBut11,{
				this.ledForkYellow(~lpMnBut11);
			},
			~lpMnBut12,{
				this.ledForkYellow(~lpMnBut12);
			},
			~lpMnBut13,{
				this.ledForkRed(~lpMnBut13);
			},
			~lpMnBut14,{
				this.ledForkYellow(~lpMnBut14);
			},
			~lpMnBut15,{
				this.ledForkYellow(~lpMnBut15);
			},
			~lpMnBut16,{
				this.ledForkYellow(~lpMnBut16);
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
		~lpMn.noteOn(~lpMnCh, ~lpMnBut1, 3); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut2, 5); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut3, 5); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut4, 5); //But 4

		~lpMn.noteOn(~lpMnCh, ~lpMnBut5, 3); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut6, 5); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut7, 5); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut8, 5); //But 8
		//Lounch 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut9, 3); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut10, 5); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut11, 5); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut12, 5); //But 4

		~lpMn.noteOn(~lpMnCh, ~lpMnBut13, 3); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut14, 5); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut15, 5); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut16, 5); //But 8



	}
}

/*

IFLpMnSteps.led(9);
IFLpMnSteps.ledOnOff(9);
IFLpMnSteps.ledForkRed(~lpMnBut9);

*/