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

		IFLpMnSteps.button02(~lpMnBut17,\lncLpStepOn17, \lncLpStepOff17);
		IFLpMnSteps.button02(~lpMnBut18,\lncLpStepOn18, \lncLpStepOff18);
		IFLpMnSteps.button02(~lpMnBut19,\lncLpStepOn19, \lncLpStepOff19);
		IFLpMnSteps.button02(~lpMnBut20,\lncLpStepOn20, \lncLpStepOff20);
		IFLpMnSteps.button02(~lpMnBut21,\lncLpStepOn21, \lncLpStepOff21);
		IFLpMnSteps.button02(~lpMnBut22,\lncLpStepOn22, \lncLpStepOff22);
		IFLpMnSteps.button02(~lpMnBut23,\lncLpStepOn23, \lncLpStepOff23);
		IFLpMnSteps.button02(~lpMnBut24,\lncLpStepOn24, \lncLpStepOff24);
		IFLpMnSteps.button02(~lpMnBut25,\lncLpStepOn25, \lncLpStepOff25);
		IFLpMnSteps.button02(~lpMnBut26,\lncLpStepOn26, \lncLpStepOff26);
		IFLpMnSteps.button02(~lpMnBut27,\lncLpStepOn27, \lncLpStepOff27);
		IFLpMnSteps.button02(~lpMnBut28,\lncLpStepOn28, \lncLpStepOff28);
		IFLpMnSteps.button02(~lpMnBut29,\lncLpStepOn29, \lncLpStepOff29);
		IFLpMnSteps.button02(~lpMnBut30,\lncLpStepOn30, \lncLpStepOff30);
		IFLpMnSteps.button02(~lpMnBut31,\lncLpStepOn31, \lncLpStepOff31);
		IFLpMnSteps.button02(~lpMnBut32,\lncLpStepOn32, \lncLpStepOff32);

		IFLpMnSteps.button03(~lpMnBut33,\lncLpStepOn33, \lncLpStepOff33);
		IFLpMnSteps.button03(~lpMnBut34,\lncLpStepOn34, \lncLpStepOff34);
		IFLpMnSteps.button03(~lpMnBut35,\lncLpStepOn35, \lncLpStepOff35);
		IFLpMnSteps.button03(~lpMnBut36,\lncLpStepOn36, \lncLpStepOff36);
		IFLpMnSteps.button03(~lpMnBut37,\lncLpStepOn37, \lncLpStepOff37);
		IFLpMnSteps.button03(~lpMnBut38,\lncLpStepOn38, \lncLpStepOff38);
		IFLpMnSteps.button03(~lpMnBut39,\lncLpStepOn39, \lncLpStepOff39);
		IFLpMnSteps.button03(~lpMnBut40,\lncLpStepOn40, \lncLpStepOff40);
		IFLpMnSteps.button03(~lpMnBut41,\lncLpStepOn41, \lncLpStepOff41);
		IFLpMnSteps.button03(~lpMnBut42,\lncLpStepOn42, \lncLpStepOff42);
		IFLpMnSteps.button03(~lpMnBut43,\lncLpStepOn43, \lncLpStepOff43);
		IFLpMnSteps.button03(~lpMnBut44,\lncLpStepOn44, \lncLpStepOff44);
		IFLpMnSteps.button03(~lpMnBut45,\lncLpStepOn45, \lncLpStepOff45);
		IFLpMnSteps.button03(~lpMnBut46,\lncLpStepOn46, \lncLpStepOff46);
		IFLpMnSteps.button03(~lpMnBut47,\lncLpStepOn47, \lncLpStepOff47);
		IFLpMnSteps.button03(~lpMnBut48,\lncLpStepOn48, \lncLpStepOff48);

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
				~lpMnBut17,{~local.sendMsg('seqStep17', 1);},
				~lpMnBut18,{~local.sendMsg('seqStep18', 1);},
				~lpMnBut19,{~local.sendMsg('seqStep19', 1);},
				~lpMnBut20,{~local.sendMsg('seqStep20', 1);},
				~lpMnBut21,{~local.sendMsg('seqStep21', 1);},
				~lpMnBut22,{~local.sendMsg('seqStep22', 1);},
				~lpMnBut23,{~local.sendMsg('seqStep23', 1);},
				~lpMnBut24,{~local.sendMsg('seqStep24', 1);},
				~lpMnBut25,{~local.sendMsg('seqStep25', 1);},
				~lpMnBut26,{~local.sendMsg('seqStep26', 1);},
				~lpMnBut27,{~local.sendMsg('seqStep27', 1);},
				~lpMnBut28,{~local.sendMsg('seqStep28', 1);},
				~lpMnBut29,{~local.sendMsg('seqStep29', 1);},
				~lpMnBut30,{~local.sendMsg('seqStep30', 1);},
				~lpMnBut31,{~local.sendMsg('seqStep31', 1);},
				~lpMnBut32,{~local.sendMsg('seqStep32', 1);}
			);

		},srcID:~lpMnInID, chan:0,noteNum:ntNum);

		MIDIdef.noteOff(nameOff, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut17,{~local.sendMsg('seqStep17', 1);},
				~lpMnBut18,{~local.sendMsg('seqStep18', 1);},
				~lpMnBut19,{~local.sendMsg('seqStep19', 1);},
				~lpMnBut20,{~local.sendMsg('seqStep20', 1);},
				~lpMnBut21,{~local.sendMsg('seqStep21', 1);},
				~lpMnBut22,{~local.sendMsg('seqStep22', 1);},
				~lpMnBut23,{~local.sendMsg('seqStep23', 1);},
				~lpMnBut24,{~local.sendMsg('seqStep24', 1);},
				~lpMnBut25,{~local.sendMsg('seqStep25', 1);},
				~lpMnBut26,{~local.sendMsg('seqStep26', 1);},
				~lpMnBut27,{~local.sendMsg('seqStep27', 1);},
				~lpMnBut28,{~local.sendMsg('seqStep28', 1);},
				~lpMnBut29,{~local.sendMsg('seqStep29', 1);},
				~lpMnBut30,{~local.sendMsg('seqStep30', 1);},
				~lpMnBut31,{~local.sendMsg('seqStep31', 1);},
				~lpMnBut32,{~local.sendMsg('seqStep32', 1);}
			);

		},srcID:~lpMnInID, chan:0,noteNum:ntNum);
	}
	*button03{|ntNum,nameOn, nameOff|

		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut33,{~local.sendMsg('seqStep33', 1);},
				~lpMnBut34,{~local.sendMsg('seqStep34', 1);},
				~lpMnBut35,{~local.sendMsg('seqStep35', 1);},
				~lpMnBut36,{~local.sendMsg('seqStep36', 1);},
				~lpMnBut37,{~local.sendMsg('seqStep37', 1);},
				~lpMnBut38,{~local.sendMsg('seqStep38', 1);},
				~lpMnBut39,{~local.sendMsg('seqStep39', 1);},
				~lpMnBut40,{~local.sendMsg('seqStep40', 1);},
				~lpMnBut41,{~local.sendMsg('seqStep41', 1);},
				~lpMnBut42,{~local.sendMsg('seqStep42', 1);},
				~lpMnBut43,{~local.sendMsg('seqStep43', 1);},
				~lpMnBut44,{~local.sendMsg('seqStep44', 1);},
				~lpMnBut45,{~local.sendMsg('seqStep45', 1);},
				~lpMnBut46,{~local.sendMsg('seqStep46', 1);},
				~lpMnBut47,{~local.sendMsg('seqStep47', 1);},
				~lpMnBut48,{~local.sendMsg('seqStep48', 1);}
			);

		},srcID:~lpMnInID, chan:0,noteNum:ntNum);

		MIDIdef.noteOff(nameOff, {
			arg chan,noteNum;

			ntNum.switch(
				~lpMnBut33,{~local.sendMsg('seqStep33', 1);},
				~lpMnBut34,{~local.sendMsg('seqStep34', 1);},
				~lpMnBut35,{~local.sendMsg('seqStep35', 1);},
				~lpMnBut36,{~local.sendMsg('seqStep36', 1);},
				~lpMnBut37,{~local.sendMsg('seqStep37', 1);},
				~lpMnBut38,{~local.sendMsg('seqStep38', 1);},
				~lpMnBut39,{~local.sendMsg('seqStep39', 1);},
				~lpMnBut40,{~local.sendMsg('seqStep40', 1);},
				~lpMnBut41,{~local.sendMsg('seqStep41', 1);},
				~lpMnBut42,{~local.sendMsg('seqStep42', 1);},
				~lpMnBut43,{~local.sendMsg('seqStep43', 1);},
				~lpMnBut44,{~local.sendMsg('seqStep44', 1);},
				~lpMnBut45,{~local.sendMsg('seqStep45', 1);},
				~lpMnBut46,{~local.sendMsg('seqStep46', 1);},
				~lpMnBut47,{~local.sendMsg('seqStep47', 1);},
				~lpMnBut48,{~local.sendMsg('seqStep48', 1);}
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
			~lpMnBut1,{this.ledForkRed(~lpMnBut1);},
			~lpMnBut2,{this.ledForkGreen(~lpMnBut2);},
			~lpMnBut3,{this.ledForkGreen(~lpMnBut3);},
			~lpMnBut4,{this.ledForkGreen(~lpMnBut4);},
			~lpMnBut5,{this.ledForkRed(~lpMnBut5);},
			~lpMnBut6,{this.ledForkGreen(~lpMnBut6);},
			~lpMnBut7,{this.ledForkGreen(~lpMnBut7);},
			~lpMnBut8,{this.ledForkGreen(~lpMnBut8);},
			~lpMnBut9,{this.ledForkRed(~lpMnBut9);},
			~lpMnBut10,{this.ledForkGreen(~lpMnBut10);},
			~lpMnBut11,{this.ledForkGreen(~lpMnBut11);},
			~lpMnBut12,{this.ledForkGreen(~lpMnBut12);},
			~lpMnBut13,{this.ledForkRed(~lpMnBut13);},
			~lpMnBut14,{this.ledForkGreen(~lpMnBut14);},
			~lpMnBut15,{this.ledForkGreen(~lpMnBut15);},
			~lpMnBut16,{this.ledForkGreen(~lpMnBut16);},
			//

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
	*resetLeds2{

		//Sequencer
		//Lounch 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut17, 3); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut18, 5); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut19, 5); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut20, 5); //But 4

		~lpMn.noteOn(~lpMnCh, ~lpMnBut21, 3); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut22, 5); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut23, 5); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut24, 5); //But 8
		//Lounch 4
		~lpMn.noteOn(~lpMnCh, ~lpMnBut25, 3); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut26, 5); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut27, 5); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut28, 5); //But 4

		~lpMn.noteOn(~lpMnCh, ~lpMnBut29, 3); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut30, 5); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut31, 5); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut32, 5); //But 8
	}
	*resetLeds3{

		//Sequencer
		//Lounch 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut33, 3); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut34, 5); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut35, 5); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut36, 5); //But 4

		~lpMn.noteOn(~lpMnCh, ~lpMnBut37, 3); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut38, 5); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut39, 5); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut40, 5); //But 8
		//Lounch 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut41, 3); //But 1
		~lpMn.noteOn(~lpMnCh, ~lpMnBut42, 5); //But 2
		~lpMn.noteOn(~lpMnCh, ~lpMnBut43, 5); //But 3
		~lpMn.noteOn(~lpMnCh, ~lpMnBut44, 5); //But 4

		~lpMn.noteOn(~lpMnCh, ~lpMnBut45, 3); //But 5
		~lpMn.noteOn(~lpMnCh, ~lpMnBut46, 5); //But 6
		~lpMn.noteOn(~lpMnCh, ~lpMnBut47, 5); //But 7
		~lpMn.noteOn(~lpMnCh, ~lpMnBut48, 5); //But 8
	}
}

/*

IFLpMnSteps.led(9);
IFLpMnSteps.ledOnOff(9);
IFLpMnSteps.ledForkRed(~lpMnBut9);

*/