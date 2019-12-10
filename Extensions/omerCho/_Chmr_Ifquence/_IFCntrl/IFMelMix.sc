/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

IFMelMix.act1(1,1,1);
IFMelMix.act1(0,0,0);


//to find MIDIOut src
~melMix.uid;

*/

IFMelMix{
	*load{

		this.addr;
		this.globals;
		this.loadResponders;
		this.makeMIDIResponders;
		this.makeOSCResponders;
		this.resetCnts;
		this.resetLeds;


	}//loadAtStart
	*addr{

	}
	*globals{
		~ln1=1;
		~ln2=2;
		~ln3=3;
		~ln4=4;
		~ln5=5;
		~ln6=6;
		~ln7=7;
		~ln8=8;
		//channels
		~melMixGlb=0;
		~melMixLn1=0;
		~melMixLn2=1;
		~melMixLn3=2;
		~melMixLn4=3;
		~melMixLn5=4;
		~melMixLn6=5;
		~melMixLn7=6;
		~melMixLn8=7;
		~melMixLnM=8;
		//Nums
		~act1A=3;~act2A=6;~act3A=9;~act4A=12;
		~act5A=15;~act6A=18;~act7A=21;~act8A=24;
		~act1B=1;~act2B=4;~act3B=7;~act4B=10;
		~act5B=13;~act6B=16;~act7B=19;~act8B=22;
		~act1C=2;~act2C=5;~act3C=8;~act4C=11;
		~act5C=14;~act6C=17;~act7C=20;~act8C=23;

		~fad=30;~nobA=33;~nobB=32;~nobC=31;

		~bnkL=25; ~bnkR=26;

	}//globals
	*act1{|val1,val2,val3|
		this.line(~ln1,\butA,val:val1);
		this.line(~ln1,\butB,val:val2);
		this.line(~ln1,\butC,val:val3);
	}
	*act2{|val1,val2,val3|
		this.line(~ln2,\butA,val:val1);
		this.line(~ln2,\butB,val:val2);
		this.line(~ln2,\butC,val:val3);
	}
	*act3{|val1,val2,val3|
		this.line(~ln3,\butA,val:val1);
		this.line(~ln3,\butB,val:val2);
		this.line(~ln3,\butC,val:val3);
	}
	*act4{|val1,val2,val3|
		this.line(~ln4,\butA,val:val1);
		this.line(~ln4,\butB,val:val2);
		this.line(~ln4,\butC,val:val3);
	}
	*act5{|val1,val2,val3|
		this.line(~ln5,\butA,val:val1);
		this.line(~ln5,\butB,val:val2);
		this.line(~ln5,\butC,val:val3);
	}
	*act6{|val1,val2,val3|
		this.line(~ln6,\butA,val:val1);
		this.line(~ln6,\butB,val:val2);
		this.line(~ln6,\butC,val:val3);
	}
	*act7{|val1,val2,val3|
		this.line(~ln7,\butA,val:val1);
		this.line(~ln7,\butB,val:val2);
		this.line(~ln7,\butC,val:val3);
	}
	*act8{|val1,val2,val3|
		this.line(~ln8,\butA,val:val1);
		this.line(~ln8,\butB,val:val2);
		this.line(~ln8,\butC,val:val3);
	}
	//actBank
	*actBank{|val1,val2|
		this.actBankButA(val1);
		this.actBankButB(val2);
	}
	*actBankButA{|val|
		~melMix.noteOn(~melMixGlb, ~bankRight, val); //But A

		~cntMix2ActBankButA=val;
	}
	*actBankButB{|val|
		~melMix.noteOn(~melMixGlb, ~bankLeft, val); //But B

		~cntMix2ActBankButB=val;
	}//actBank

	*loadResponders{
		//-----------BANKS
		//IFMelMix.actBankButA(0);
		~cntMix2ActBankButA=0;
		~mdActBankButA.free;
		~mdActBankButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2ActBankButA = ~cntMix2ActBankButA + 1;
				~cntMix2ActBankButA.switch(
					1,{IFMelMix.actBankButA(1);},
					2,{IFMelMix.actBankButA(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlb, noteNum:~bankRight);
		~cntMix2ActBankButB=0;
		~mdActBankButB.free;
		~mdActBankButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2ActBankButB = ~cntMix2ActBankButB + 1;
				~cntMix2ActBankButB.switch(
					0,{},
					1,{IFMelMix.actBankButB(1);},
					2,{IFMelMix.actBankButB(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlb, noteNum:~bankLeft);

		/////
		//--------------------line--MASTER
		~melMixFadFXMaster.free;
		~melMixFadFXMaster=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			//IFSends.set1(\vol1,val);
		},srcID:~melMixInID, chan:~melMixLnMaster, ccNum:30);



	}

	*tsLed{|chan,led|
		~melMix.noteOn(0, 51, led);
	}
	*tsLeds{|led1,led2,led3,led4,led5,led6,led7,led8|
		~melMix.noteOn(~melMixLn1, ~act1A, led1); //But 1
		~melMix.noteOn(~melMixLn1, ~act2A, led2); //But 2
		~melMix.noteOn(~melMixLn1, ~act3A, led3); //But 3
		~melMix.noteOn(~melMixLn1, ~act4A, led4); //But 4
		~melMix.noteOn(~melMixLn1, ~act5A, led5); //But 5
		~melMix.noteOn(~melMixLn1, ~act6A, led6); //But 6
		~melMix.noteOn(~melMixLn1, ~act7A, led7); //But 7
		~melMix.noteOn(~melMixLn1, ~act8A, led8); //But 8
	}

	/*
	IFMelMix.ndButLeds(1,0,0,0,0,0,0,0);
	IFMelMix.nobDown(mode:2);
	*/
	*line{|instLine,paramKey,val|
		var vel;
		vel=val*127;
		instLine.switch(
			1,{paramKey.switch(
				\butA,{
					~melMix.noteOn(~melMixGlb, ~act1A, val); //But A
					//~tOSCAdrr.sendMsg('activKick', val);
					~actKick.source=val;
					~melAct1ButACnt=val;
				},
				\butB,{
					~melMix.noteOn(~melMixGlb, ~act1B, val); //But B
					~tOSCAdrr.sendMsg('shufKick', val);
					~local.sendMsg('shufKick', val);
					~melAct1ButBCnt=val;
				},
				\butC,{
					~melMix.noteOn(~melMixGlb, ~act1C, val); //But C
					~tOSCAdrr.sendMsg('time2Kick', val);
					~tmMulKick.source = Pseq([val+1], inf);
					~melAct1ButCCnt=val;
				},
				\fad,{
					IFKick.set1(\vol,val);
					Ambk.cc(\pt1,\pt1Vol,vel*0.89);
				},
				\nobA,{
					Ambk.cc(\pt1,\pt1F1Cut,vel*0.89);
				},
				\nobB,{
					Ambk.cc(\pt1,\pt1Mix,vel*0.89);
				},
				\nobC,{

				},
			);},

			2,{paramKey.switch(
				\butA,{
					~melMix.noteOn(~melMixGlb, ~act2A, val); //But A
					~tOSCAdrr.sendMsg('activSnr', val);
					~actSnr.source=val;
					~melAct2ButACnt=val;
				},
				\butB,{
					~melMix.noteOn(~melMixGlb, ~act2B, val); //But B
					~tOSCAdrr.sendMsg('shufSnr', val);
					~local.sendMsg('shufSnr', val);
					~melAct2ButBCnt=val;
				},
				\butC,{
					~melMix.noteOn(~melMixGlb, ~act2C, val); //But C
					~tOSCAdrr.sendMsg('time2Snr', val);
					~tmMulSnr.source = Pseq([val+1], inf);
					~melAct2ButCCnt=val;
				},
				\fad,{
					~tOSCAdrr.sendMsg('volSnr', val);
					IFSnr.set1(\vol,val);
					Ambk.cc(\pt2,\pt2Vol,vel*0.79);
				},
				\nobA,{
					Ambk.cc(\pt2,\pt2F1Cut,vel*0.79);
				},
				\nobB,{
					Ambk.cc(\pt2,\pt2Mix,vel*0.79);
				},
				\nobC,{

				}
			);},
			3,{paramKey.switch(
				\butA,{
					~melMix.noteOn(~melMixGlb, ~act3A, val); //But A
					~tOSCAdrr.sendMsg('activHat', val);
					~actHat.source=val;
					~melAct3ButACnt=val;
				},
				\butB,{
					~melMix.noteOn(~melMixGlb, ~act3B, val); //But B
					~tOSCAdrr.sendMsg('shufHat', val);
					~local.sendMsg('shufHat', val);
					~melAct3ButBCnt=val;
				},
				\butC,{
					~melMix.noteOn(~melMixGlb, ~act3C, val); //But C
					~tOSCAdrr.sendMsg('time2Hat', val);
					~tmMulHat.source = Pseq([val+1], inf);
					~melAct3ButCCnt=val;
				},
				\fad,{
					IFHat.set1(\vol,val);
					Ambk.cc(\pt3,\pt3Vol,vel*0.79);
				},
				\nobA,{
					Ambk.cc(\pt3,\pt3F1Cut,vel*0.79);
				},
				\nobB,{
					Ambk.cc(\pt3,\pt3Mix,vel*0.79);
				},
				\nobC,{
					~tOSCAdrr.sendMsg('hatCln', val);
					~mdOut.control(1, 16, vel);//Cln Hats Vol
				},
			);},
			4,{paramKey.switch(
				\butA,{
					~melMix.noteOn(~melMixGlb, ~act4A, val); //But A
					~tOSCAdrr.sendMsg('activ1Keys', val);
					~act1Keys.source=val;
					~melAct4ButACnt=val;
				},
				\butB,{
					~melMix.noteOn(~melMixGlb, ~act4B, val); //But B
					~tOSCAdrr.sendMsg('shufKeys', val);
					~local.sendMsg('shufKeys', val);
					~melAct4ButBCnt=val;
				},
				\butC,{
					~melMix.noteOn(~melMixGlb, ~act4C, val); //But C
					~tOSCAdrr.sendMsg('time2Keys', val);
					~tmMulKeys.source = Pseq([val+1], inf);
					~melAct4ButCCnt=val;
				},
				\fad,{
					IFKeys.set1(\vol,val);
					Ambk.cc(\pt4,\pt4Vol,vel*0.79);
				},
				\nobA,{
					Ambk.cc(\pt4,\pt4F1Cut,vel*0.9);
				},
				\nobB,{
					Ambk.cc(\pt4,\pt4Mix,vel*0.9);
				},
				\nobC,{
					~tOSCAdrr.sendMsg('volClnKeys', val);
					~mdOut.control(1, 19, vel); //Cln Keys Vol
				},
			);},
			5,{paramKey.switch(
				\butA,{
					~melMix.noteOn(~melMixGlb, ~act5A, val); //But A
					~tOSCAdrr.sendMsg('activ2Keys', val);
					~act2Keys.source=val;
					~melAct5ButACnt=val;
				},
				\butB,{
					~melMix.noteOn(~melMixGlb, ~act5B, val); //But B

					~melAct5ButBCnt=val;
				},
				\butC,{
					~melMix.noteOn(~melMixGlb, ~act5C, val); //But C

					~melAct5ButCCnt=val;
				},
				\fad,{
					Ambk.cc(\pt5,\pt5Vol,vel*0.79);
				},
				\nobA,{
					Ambk.cc(\pt5,\pt5F1Cut,vel*0.9);
				},
				\nobB,{
					Ambk.cc(\pt5,\pt5Mix,vel*0.9);
				},
				\nobC,{

				},
			);},
			6,{paramKey.switch(
				\butA,{
					~melMix.noteOn(~melMixGlb, ~act6A, val); //But A
					~tOSCAdrr.sendMsg('activ3Keys', val);
					~act3Keys.source=val;
					~melAct6ButACnt=val;
				},
				\butB,{
					~melMix.noteOn(~melMixGlb, ~act6B, val); //But B

					~melAct6ButBCnt=val;
				},
				\butC,{
					~melMix.noteOn(~melMixGlb, ~act6C, val); //But C

					~melAct6ButCCnt=val;
				},
				\fad,{
					Ambk.cc(\pt6,\pt6Vol,vel*0.79);
				},
				\nobA,{
					Ambk.cc(\pt6,\pt6F1Cut,vel*0.9);
				},
				\nobB,{
					Ambk.cc(\pt6,\pt6Mix,vel*0.9);
				},
				\nobC,{

				},
			);},
			7,{paramKey.switch(
				\butA,{
					~melMix.noteOn(~melMixGlb, ~act7A, val); //But A
					~tOSCAdrr.sendMsg('activMopho', val);
					~actMopho.source=val;
					~melAct7ButACnt=val;
				},
				\butB,{
					~melMix.noteOn(~melMixGlb, ~act7B, val); //But B
					~tOSCAdrr.sendMsg('shufMopho', val);
					~local.sendMsg('shufMopho', val);
					~melAct7ButBCnt=val;
				},
				\butC,{
					~melMix.noteOn(~melMixGlb, ~act7C, val); //But C
					~tOSCAdrr.sendMsg('time2Mopho', val);
					~tmMulMopho.source = Pseq([val+1], inf);
					~melAct7ButCCnt=val;
				},
				\fad,{
					IFMopho.set1(\vol,val);
				},
				\nobA,{
					Mopho.cc(\lpfKeyAmnt, vel);
				},
				\nobB,{
					Mopho.cc('lfo1Amnt', vel);
				},
				\nobC,{

				},
			);},
			8,{paramKey.switch(
				\butA,{
					~melMix.noteOn(~melMixGlb, ~act8A, val); //But A
					~tOSCAdrr.sendMsg('activBass', val);
					~actBass.source=val;
					~melAct8ButACnt=val;
				},
				\butB,{
					~melMix.noteOn(~melMixGlb, ~act8B, val); //But B
					~tOSCAdrr.sendMsg('shufBass', val);
					~local.sendMsg('shufBass', val);
					~melAct8ButBCnt=val;
				},
				\butC,{
					~melMix.noteOn(~melMixGlb, ~act8C, val); //But C
					//~tOSCAdrr.sendMsg('lfoBass', val);
					//~local.sendMsg('lfoBass', val);
					~melAct8ButCCnt=val;
				},

				\fad,{

					IFBass.set1(\vol,val);
				},
				\nobA,{

				},
				\nobB,{

				},
				\nobC,{

				},
			);},
		);
	}
	*makeMIDIResponders{
		//Line1
		this.mdAct(~act1A,\melAct1ButA_Resp);
		this.mdAct(~act1B,\melAct1ButB_Resp);
		this.mdAct(~act1C,\melAct1ButC_Resp);
		this.mdLine(~melMixLn1,~fad,\melAct1Fad_Resp);
		this.mdLine(~melMixLn1,~nobA,\melAct1NobA_Resp);
		this.mdLine(~melMixLn1,~nobB,\melAct1NobB_Resp);
		this.mdLine(~melMixLn1,~nobC,\melAct1NobC_Resp);
		//Line2
		this.mdAct(~act2A,\melAct2ButA_Resp);
		this.mdAct(~act2B,\melAct2ButB_Resp);
		this.mdAct(~act2C,\melAct2ButC_Resp);
		this.mdLine(~melMixLn2,~fad,\melAct2Fad_Resp);
		this.mdLine(~melMixLn2,~nobA,\melAct2NobA_Resp);
		this.mdLine(~melMixLn2,~nobB,\melAct2NobB_Resp);
		this.mdLine(~melMixLn2,~nobC,\melAct2NobC_Resp);
		//line3
		this.mdAct(~act3A,\melAct3ButA_Resp);
		this.mdAct(~act3B,\melAct3ButB_Resp);
		this.mdAct(~act3C,\melAct3ButC_Resp);
		this.mdLine(~melMixLn3,~fad,\melAct3Fad_Resp);
		this.mdLine(~melMixLn3,~nobA,\melAct3NobA_Resp);
		this.mdLine(~melMixLn3,~nobB,\melAct3NobB_Resp);
		this.mdLine(~melMixLn3,~nobC,\melAct3NobC_Resp);
		//line4
		this.mdAct(~act4A,\melAct4ButA_Resp);
		this.mdAct(~act4B,\melAct4ButB_Resp);
		this.mdAct(~act4C,\melAct4ButC_Resp);
		this.mdLine(~melMixLn4,~fad,\melAct4Fad_Resp);
		this.mdLine(~melMixLn4,~nobA,\melAct4NobA_Resp);
		this.mdLine(~melMixLn4,~nobB,\melAct4NobB_Resp);
		this.mdLine(~melMixLn4,~nobC,\melAct4NobC_Resp);
		//line5
		this.mdAct(~act5A,\melAct5ButA_Resp);
		this.mdAct(~act5B,\melAct5ButB_Resp);
		this.mdAct(~act5C,\melAct5ButC_Resp);
		this.mdLine(~melMixLn5,~fad,\melAct5Fad_Resp);
		this.mdLine(~melMixLn5,~nobA,\melAct5NobA_Resp);
		this.mdLine(~melMixLn5,~nobB,\melAct5NobB_Resp);
		this.mdLine(~melMixLn5,~nobC,\melAct5NobC_Resp);
		//line6
		this.mdAct(~act6A,\melAct6ButA_Resp);
		this.mdAct(~act6B,\melAct6ButB_Resp);
		this.mdAct(~act6C,\melAct6ButC_Resp);
		this.mdLine(~melMixLn6,~fad,\melAct6Fad_Resp);
		this.mdLine(~melMixLn6,~nobA,\melAct6NobA_Resp);
		this.mdLine(~melMixLn6,~nobB,\melAct6NobB_Resp);
		this.mdLine(~melMixLn6,~nobC,\melAct6NobC_Resp);
		//line7
		this.mdAct(~act7A,\melAct7ButA_Resp);
		this.mdAct(~act7B,\melAct7ButB_Resp);
		this.mdAct(~act7C,\melAct7ButC_Resp);
		this.mdLine(~melMixLn7,~fad,\melAct7Fad_Resp);
		this.mdLine(~melMixLn7,~nobA,\melAct7NobA_Resp);
		this.mdLine(~melMixLn7,~nobB,\melAct7NobB_Resp);
		this.mdLine(~melMixLn7,~nobC,\melAct7NobC_Resp);
		//line8
		this.mdAct(~act8A,\melAct8ButA_Resp);
		this.mdAct(~act8B,\melAct8ButB_Resp);
		this.mdAct(~act8C,\melAct8ButC_Resp);
		this.mdLine(~melMixLn8,~fad,\melAct8Fad_Resp);
		this.mdLine(~melMixLn8,~nobA,\melAct8NobA_Resp);
		this.mdLine(~melMixLn8,~nobB,\melAct8NobB_Resp);
		this.mdLine(~melMixLn8,~nobC,\melAct8NobC_Resp);
	}

	*mdAct{|ntNum,nameOn, nameOff|
		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				//line1
				~act1A,{~local.sendMsg('melAct1ButA', 1);},
				~act1B,{~local.sendMsg('melAct1ButB', 1);},
				~act1C,{~local.sendMsg('melAct1ButC', 1);},
				//line2
				~act2A,{~local.sendMsg('melAct2ButA', 1);},
				~act2B,{~local.sendMsg('melAct2ButB', 1);},
				~act2C,{~local.sendMsg('melAct2ButC', 1);},
				//line3
				~act3A,{~local.sendMsg('melAct3ButA', 1);},
				~act3B,{~local.sendMsg('melAct3ButB', 1);},
				~act3C,{~local.sendMsg('melAct3ButC', 1);},
				//line4
				~act4A,{~local.sendMsg('melAct4ButA', 1);},
				~act4B,{~local.sendMsg('melAct4ButB', 1);},
				~act4C,{~local.sendMsg('melAct4ButC', 1);},
				//line5
				~act5A,{~local.sendMsg('melAct5ButA', 1);},
				~act5B,{~local.sendMsg('melAct5ButB', 1);},
				~act5C,{~local.sendMsg('melAct5ButC', 1);},
				//line6
				~act6A,{~local.sendMsg('melAct6ButA', 1);},
				~act6B,{~local.sendMsg('melAct6ButB', 1);},
				~act6C,{~local.sendMsg('melAct6ButC', 1);},
				//line7
				~act7A,{~local.sendMsg('melAct7ButA', 1);},
				~act7B,{~local.sendMsg('melAct7ButB', 1);},
				~act7C,{~local.sendMsg('melAct7ButC', 1);},
				//line8
				~act8A,{~local.sendMsg('melAct8ButA', 1);},
				~act8B,{~local.sendMsg('melAct8ButB', 1);},
				~act8C,{~local.sendMsg('melAct8ButC', 1);},
			);
		},srcID:~melMixInID, chan:~melMixGlb, noteNum:ntNum);
	}
	*mdLine{|chn,cNum,nameOn|
		MIDIdef.cc(nameOn, {
			arg vel,val;
			val=vel/127;
			chn.switch(
				~melMixLn1,{
					cNum.switch(
						~fad,{~local.sendMsg('melAct1Fad', val);},
						~nobA,{~local.sendMsg('melAct1NobA', val);},
						~nobB,{~local.sendMsg('melAct1NobB', val);},
						~nobC,{~local.sendMsg('melAct1NobC', val);},
				);},
				~melMixLn2,{
					cNum.switch(
						~fad,{~local.sendMsg('melAct2Fad', val);},
						~nobA,{~local.sendMsg('melAct2NobA', val);},
						~nobB,{~local.sendMsg('melAct2NobB', val);},
						~nobC,{~local.sendMsg('melAct2NobC', val);},
				);},
				~melMixLn3,{
					cNum.switch(
						~fad,{~local.sendMsg('melAct3Fad', val);},
						~nobA,{~local.sendMsg('melAct3NobA', val);},
						~nobB,{~local.sendMsg('melAct3NobB', val);},
						~nobC,{~local.sendMsg('melAct3NobC', val);},
				);},
				~melMixLn4,{
					cNum.switch(
						~fad,{~local.sendMsg('melAct4Fad', val);},
						~nobA,{~local.sendMsg('melAct4NobA', val);},
						~nobB,{~local.sendMsg('melAct4NobB', val);},
						~nobC,{~local.sendMsg('melAct4NobC', val);},
				);},
				~melMixLn5,{
					cNum.switch(
						~fad,{~local.sendMsg('melAct5Fad', val);},
						~nobA,{~local.sendMsg('melAct5NobA', val);},
						~nobB,{~local.sendMsg('melAct5NobB', val);},
						~nobC,{~local.sendMsg('melAct5NobC', val);},
				);},
				~melMixLn6,{
					cNum.switch(
						~fad,{~local.sendMsg('melAct6Fad', val);},
						~nobA,{~local.sendMsg('melAct6NobA', val);},
						~nobB,{~local.sendMsg('melAct6NobB', val);},
						~nobC,{~local.sendMsg('melAct6NobC', val);},
				);},
				~melMixLn7,{
					cNum.switch(
						~fad,{~local.sendMsg('melAct7Fad', val);},
						~nobA,{~local.sendMsg('melAct7NobA', val);},
						~nobB,{~local.sendMsg('melAct7NobB', val);},
						~nobC,{~local.sendMsg('melAct7NobC', val);},
				);},
				~melMixLn8,{
					cNum.switch(
						~fad,{~local.sendMsg('melAct8Fad', val);},
						~nobA,{~local.sendMsg('melAct8NobA', val);},
						~nobB,{~local.sendMsg('melAct8NobB', val);},
						~nobC,{~local.sendMsg('melAct8NobC', val);},
				);},
			);

		},srcID:~melMixInID, chan:chn, ccNum:cNum);
	}

	*oscResp{|respName,oscName,playDir|
		OSCdef(respName, {|msg|
			var val;
			val=msg[1];
			playDir.switch(
				//line1
				'melAct1ButA_T',{if ( msg[1]==1,{
					~melAct1ButACnt = ~melAct1ButACnt + 1;
					~melAct1ButACnt.switch(1,{this.line(~ln1,\butA,val:1);},2,{this.line(~ln1,\butA,val:0);});
				});},
				'melAct1ButB_T',{if ( msg[1]==1,{
					~melAct1ButBCnt = ~melAct1ButBCnt + 1;
					~melAct1ButBCnt.switch(1,{this.line(~ln1,\butB,val:1);},2,{this.line(~ln1,\butB,val:0);});
				});},
				'melAct1ButC_T',{if ( msg[1]==1,{
					~melAct1ButCCnt = ~melAct1ButCCnt + 1;
					~melAct1ButCCnt.switch(1,{this.line(~ln1,\butC,val:1);},2,{this.line(~ln1,\butC,val:0);});
				});},
				'melAct1Fad_T',{this.line(~ln1,\fad,val:val);},
				'melAct1NobA_T',{this.line(~ln1,\nobA,val:val);},
				'melAct1NobB_T',{this.line(~ln1,\nobB,val:val);},
				'melAct1NobC_T',{this.line(~ln1,\nobC,val:val);},
				//line2
				'melAct2ButA_T',{if ( msg[1]==1,{
					~melAct2ButACnt = ~melAct2ButACnt + 1;
					~melAct2ButACnt.switch(1,{this.line(~ln2,\butA,val:1);},2,{this.line(~ln2,\butA,val:0);});
				});},
				'melAct2ButB_T',{if ( msg[1]==1,{
					~melAct2ButBCnt = ~melAct2ButBCnt + 1;
					~melAct2ButBCnt.switch(1,{this.line(~ln2,\butB,val:1);},2,{this.line(~ln2,\butB,val:0);});
				});},
				'melAct2ButC_T',{if ( msg[1]==1,{
					~melAct2ButCCnt = ~melAct2ButCCnt + 1;
					~melAct2ButCCnt.switch(1,{this.line(~ln2,\butC,val:1);},2,{this.line(~ln2,\butC,val:0);});
				});},
				'melAct2Fad_T',{this.line(~ln2,\fad,val:val);},
				'melAct2NobA_T',{this.line(~ln2,\nobA,val:val);},
				'melAct2NobB_T',{this.line(~ln2,\nobB,val:val);},
				'melAct2NobC_T',{this.line(~ln2,\nobC,val:val);},
				//line3
				'melAct3ButA_T',{if ( msg[1]==1,{
					~melAct3ButACnt = ~melAct3ButACnt + 1;
					~melAct3ButACnt.switch(1,{this.line(~ln3,\butA,val:1);},2,{this.line(~ln3,\butA,val:0);});
				});},
				'melAct3ButB_T',{if ( msg[1]==1,{
					~melAct3ButBCnt = ~melAct3ButBCnt + 1;
					~melAct3ButBCnt.switch(1,{this.line(~ln3,\butB,val:1);},2,{this.line(~ln3,\butB,val:0);});
				});},
				'melAct3ButC_T',{if ( msg[1]==1,{
					~melAct3ButCCnt = ~melAct3ButCCnt + 1;
					~melAct3ButCCnt.switch(1,{this.line(~ln3,\butC,val:1);},2,{this.line(~ln3,\butC,val:0);});
				});},
				'melAct3Fad_T',{this.line(~ln3,\fad,val:val);},
				'melAct3NobA_T',{this.line(~ln3,\nobA,val:val);},
				'melAct3NobB_T',{this.line(~ln3,\nobB,val:val);},
				'melAct3NobC_T',{this.line(~ln3,\nobC,val:val);},
				//line4
				'melAct4ButA_T',{if ( msg[1]==1,{
					~melAct4ButACnt = ~melAct4ButACnt + 1;
					~melAct4ButACnt.switch(1,{this.line(~ln4,\butA,val:1);},2,{this.line(~ln4,\butA,val:0);});
				});},
				'melAct4ButB_T',{if ( msg[1]==1,{
					~melAct4ButBCnt = ~melAct4ButBCnt + 1;
					~melAct4ButBCnt.switch(1,{this.line(~ln4,\butB,val:1);},2,{this.line(~ln4,\butB,val:0);});
				});},
				'melAct4ButC_T',{if ( msg[1]==1,{
					~melAct4ButCCnt = ~melAct4ButCCnt + 1;
					~melAct4ButCCnt.switch(1,{this.line(~ln4,\butC,val:1);},2,{this.line(~ln4,\butC,val:0);});
				});},
				'melAct4Fad_T',{this.line(~ln4,\fad,val:val);},
				'melAct4NobA_T',{this.line(~ln4,\nobA,val:val);},
				'melAct4NobB_T',{this.line(~ln4,\nobB,val:val);},
				'melAct4NobC_T',{this.line(~ln4,\nobC,val:val);},
				//line5
				'melAct5ButA_T',{if ( msg[1]==1,{
					~melAct5ButACnt = ~melAct5ButACnt + 1;
					~melAct5ButACnt.switch(1,{this.line(~ln5,\butA,val:1);},2,{this.line(~ln5,\butA,val:0);});
				});},
				'melAct5ButB_T',{if ( msg[1]==1,{
					~melAct5ButBCnt = ~melAct5ButBCnt + 1;
					~melAct5ButBCnt.switch(1,{this.line(~ln5,\butB,val:1);},2,{this.line(~ln5,\butB,val:0);});
				});},
				'melAct5ButC_T',{if ( msg[1]==1,{
					~melAct5ButCCnt = ~melAct5ButCCnt + 1;
					~melAct5ButCCnt.switch(1,{this.line(~ln5,\butC,val:1);},2,{this.line(~ln5,\butC,val:0);});
				});},
				'melAct5Fad_T',{this.line(~ln5,\fad,val:val);},
				'melAct5NobA_T',{this.line(~ln5,\nobA,val:val);},
				'melAct5NobB_T',{this.line(~ln5,\nobB,val:val);},
				'melAct5NobC_T',{this.line(~ln5,\nobC,val:val);},
				//line6
				'melAct6ButA_T',{if ( msg[1]==1,{
					~melAct6ButACnt = ~melAct6ButACnt + 1;
					~melAct6ButACnt.switch(1,{this.line(~ln6,\butA,val:1);},2,{this.line(~ln6,\butA,val:0);});
				});},
				'melAct6ButB_T',{if ( msg[1]==1,{
					~melAct6ButBCnt = ~melAct6ButBCnt + 1;
					~melAct6ButBCnt.switch(1,{this.line(~ln6,\butB,val:1);},2,{this.line(~ln6,\butB,val:0);});
				});},
				'melAct6ButC_T',{if ( msg[1]==1,{
					~melAct6ButCCnt = ~melAct6ButCCnt + 1;
					~melAct6ButCCnt.switch(1,{this.line(~ln6,\butC,val:1);},2,{this.line(~ln6,\butC,val:0);});
				});},
				'melAct6Fad_T',{this.line(~ln6,\fad,val:val);},
				'melAct6NobA_T',{this.line(~ln6,\nobA,val:val);},
				'melAct6NobB_T',{this.line(~ln6,\nobB,val:val);},
				'melAct6NobC_T',{this.line(~ln6,\nobC,val:val);},
				//line7
				'melAct7ButA_T',{if ( msg[1]==1,{
					~melAct7ButACnt = ~melAct7ButACnt + 1;
					~melAct7ButACnt.switch(1,{this.line(~ln7,\butA,val:1);},2,{this.line(~ln7,\butA,val:0);});
				});},
				'melAct7ButB_T',{if ( msg[1]==1,{
					~melAct7ButBCnt = ~melAct7ButBCnt + 1;
					~melAct7ButBCnt.switch(1,{this.line(~ln7,\butB,val:1);},2,{this.line(~ln7,\butB,val:0);});
				});},
				'melAct7ButC_T',{if ( msg[1]==1,{
					~melAct7ButCCnt = ~melAct7ButCCnt + 1;
					~melAct7ButCCnt.switch(1,{this.line(~ln7,\butC,val:1);},2,{this.line(~ln7,\butC,val:0);});
				});},
				'melAct7Fad_T',{this.line(~ln7,\fad,val:val);},
				'melAct7NobA_T',{this.line(~ln7,\nobA,val:val);},
				'melAct7NobB_T',{this.line(~ln7,\nobB,val:val);},
				'melAct7NobC_T',{this.line(~ln7,\nobC,val:val);},
				//line8
				'melAct8ButA_T',{if ( msg[1]==1,{
					~melAct8ButACnt = ~melAct8ButACnt + 1;
					~melAct8ButACnt.switch(1,{this.line(~ln8,\butA,val:1);},2,{this.line(~ln8,\butA,val:0);});
				});},
				'melAct8ButB_T',{if ( msg[1]==1,{
					~melAct8ButBCnt = ~melAct8ButBCnt + 1;
					~melAct8ButBCnt.switch(1,{this.line(~ln8,\butB,val:1);},2,{this.line(~ln8,\butB,val:0);});
				});},
				'melAct8ButC_T',{if ( msg[1]==1,{
					~melAct8ButCCnt = ~melAct8ButCCnt + 1;
					~melAct8ButCCnt.switch(1,{this.line(~ln8,\butC,val:1);},2,{this.line(~ln8,\butC,val:0);});
				});},
				'melAct8Fad_T',{this.line(~ln8,\fad,val:val);},
				'melAct8NobA_T',{this.line(~ln8,\nobA,val:val);},
				'melAct8NobB_T',{this.line(~ln8,\nobB,val:val);},
				'melAct8NobC_T',{this.line(~ln8,\nobC,val:val);},
			);
		},path:oscName);
	}
	*makeOSCResponders{
		//line1
		this.oscResp(respName:'melAct1ButA_Resp', oscName:'melAct1ButA', playDir:'melAct1ButA_T');
		this.oscResp(respName:'melAct1ButB_Resp', oscName:'melAct1ButB', playDir:'melAct1ButB_T');
		this.oscResp(respName:'melAct1ButC_Resp', oscName:'melAct1ButC', playDir:'melAct1ButC_T');
		this.oscResp(respName:'melAct1Fad_Resp', oscName:'melAct1Fad', playDir:'melAct1Fad_T');
		this.oscResp(respName:'melAct1NobA_Resp', oscName:'melAct1NobA', playDir:'melAct1NobA_T');
		this.oscResp(respName:'melAct1NobB_Resp', oscName:'melAct1NobB', playDir:'melAct1NobB_T');
		this.oscResp(respName:'melAct1NobC_Resp', oscName:'melAct1NobC', playDir:'melAct1NobC_T');
		//line2
		this.oscResp(respName:'melAct2ButA_Resp', oscName:'melAct2ButA', playDir:'melAct2ButA_T');
		this.oscResp(respName:'melAct2ButB_Resp', oscName:'melAct2ButB', playDir:'melAct2ButB_T');
		this.oscResp(respName:'melAct2ButC_Resp', oscName:'melAct2ButC', playDir:'melAct2ButC_T');
		this.oscResp(respName:'melAct2Fad_Resp', oscName:'melAct2Fad', playDir:'melAct2Fad_T');
		this.oscResp(respName:'melAct2NobA_Resp', oscName:'melAct2NobA', playDir:'melAct2NobA_T');
		this.oscResp(respName:'melAct2NobB_Resp', oscName:'melAct2NobB', playDir:'melAct2NobB_T');
		this.oscResp(respName:'melAct2NobC_Resp', oscName:'melAct2NobC', playDir:'melAct2NobC_T');
		//line3
		this.oscResp(respName:'melAct3ButA_Resp', oscName:'melAct3ButA', playDir:'melAct3ButA_T');
		this.oscResp(respName:'melAct3ButB_Resp', oscName:'melAct3ButB', playDir:'melAct3ButB_T');
		this.oscResp(respName:'melAct3ButC_Resp', oscName:'melAct3ButC', playDir:'melAct3ButC_T');
		this.oscResp(respName:'melAct3Fad_Resp', oscName:'melAct3Fad', playDir:'melAct3Fad_T');
		this.oscResp(respName:'melAct3NobA_Resp', oscName:'melAct3NobA', playDir:'melAct3NobA_T');
		this.oscResp(respName:'melAct3NobB_Resp', oscName:'melAct3NobB', playDir:'melAct3NobB_T');
		this.oscResp(respName:'melAct3NobC_Resp', oscName:'melAct3NobC', playDir:'melAct3NobC_T');
		//line4
		this.oscResp(respName:'melAct4ButA_Resp', oscName:'melAct4ButA', playDir:'melAct4ButA_T');
		this.oscResp(respName:'melAct4ButB_Resp', oscName:'melAct4ButB', playDir:'melAct4ButB_T');
		this.oscResp(respName:'melAct4ButC_Resp', oscName:'melAct4ButC', playDir:'melAct4ButC_T');
		this.oscResp(respName:'melAct4Fad_Resp', oscName:'melAct4Fad', playDir:'melAct4Fad_T');
		this.oscResp(respName:'melAct4NobA_Resp', oscName:'melAct4NobA', playDir:'melAct4NobA_T');
		this.oscResp(respName:'melAct4NobB_Resp', oscName:'melAct4NobB', playDir:'melAct4NobB_T');
		this.oscResp(respName:'melAct4NobC_Resp', oscName:'melAct4NobC', playDir:'melAct4NobC_T');
		//line5
		this.oscResp(respName:'melAct5ButA_Resp', oscName:'melAct5ButA', playDir:'melAct5ButA_T');
		this.oscResp(respName:'melAct5ButB_Resp', oscName:'melAct5ButB', playDir:'melAct5ButB_T');
		this.oscResp(respName:'melAct5ButC_Resp', oscName:'melAct5ButC', playDir:'melAct5ButC_T');
		this.oscResp(respName:'melAct5Fad_Resp', oscName:'melAct5Fad', playDir:'melAct5Fad_T');
		this.oscResp(respName:'melAct5NobA_Resp', oscName:'melAct5NobA', playDir:'melAct5NobA_T');
		this.oscResp(respName:'melAct5NobB_Resp', oscName:'melAct5NobB', playDir:'melAct5NobB_T');
		this.oscResp(respName:'melAct5NobC_Resp', oscName:'melAct5NobC', playDir:'melAct5NobC_T');
		//line6
		this.oscResp(respName:'melAct6ButA_Resp', oscName:'melAct6ButA', playDir:'melAct6ButA_T');
		this.oscResp(respName:'melAct6ButB_Resp', oscName:'melAct6ButB', playDir:'melAct6ButB_T');
		this.oscResp(respName:'melAct6ButC_Resp', oscName:'melAct6ButC', playDir:'melAct6ButC_T');
		this.oscResp(respName:'melAct6Fad_Resp', oscName:'melAct6Fad', playDir:'melAct6Fad_T');
		this.oscResp(respName:'melAct6NobA_Resp', oscName:'melAct6NobA', playDir:'melAct6NobA_T');
		this.oscResp(respName:'melAct6NobB_Resp', oscName:'melAct6NobB', playDir:'melAct6NobB_T');
		this.oscResp(respName:'melAct6NobC_Resp', oscName:'melAct6NobC', playDir:'melAct6NobC_T');
		//line7
		this.oscResp(respName:'melAct7ButA_Resp', oscName:'melAct7ButA', playDir:'melAct7ButA_T');
		this.oscResp(respName:'melAct7ButB_Resp', oscName:'melAct7ButB', playDir:'melAct7ButB_T');
		this.oscResp(respName:'melAct7ButC_Resp', oscName:'melAct7ButC', playDir:'melAct7ButC_T');
		this.oscResp(respName:'melAct7Fad_Resp', oscName:'melAct7Fad', playDir:'melAct7Fad_T');
		this.oscResp(respName:'melAct7NobA_Resp', oscName:'melAct7NobA', playDir:'melAct7NobA_T');
		this.oscResp(respName:'melAct7NobB_Resp', oscName:'melAct7NobB', playDir:'melAct7NobB_T');
		this.oscResp(respName:'melAct7NobC_Resp', oscName:'melAct7NobC', playDir:'melAct7NobC_T');
		//line8
		this.oscResp(respName:'melAct8ButA_Resp', oscName:'melAct8ButA', playDir:'melAct8ButA_T');
		this.oscResp(respName:'melAct8ButB_Resp', oscName:'melAct8ButB', playDir:'melAct8ButB_T');
		this.oscResp(respName:'melAct8ButC_Resp', oscName:'melAct8ButC', playDir:'melAct8ButC_T');
		this.oscResp(respName:'melAct8Fad_Resp', oscName:'melAct8Fad', playDir:'melAct8Fad_T');
		this.oscResp(respName:'melAct8NobA_Resp', oscName:'melAct8NobA', playDir:'melAct8NobA_T');
		this.oscResp(respName:'melAct8NobB_Resp', oscName:'melAct8NobB', playDir:'melAct8NobB_T');
		this.oscResp(respName:'melAct8NobC_Resp', oscName:'melAct8NobC', playDir:'melAct8NobC_T');
	}

	*resetCnts{
		~melAct1ButACnt=0;
		~melAct1ButBCnt=0;
		~melAct1ButCCnt=0;
		~melAct2ButACnt=0;
		~melAct2ButBCnt=0;
		~melAct2ButCCnt=0;
		~melAct3ButACnt=0;
		~melAct3ButBCnt=0;
		~melAct3ButCCnt=0;
		~melAct4ButACnt=0;
		~melAct4ButBCnt=0;
		~melAct4ButCCnt=0;
		~melAct5ButACnt=0;
		~melAct5ButBCnt=0;
		~melAct5ButCCnt=0;
		~melAct6ButACnt=0;
		~melAct6ButBCnt=0;
		~melAct6ButCCnt=0;
		~melAct7ButACnt=0;
		~melAct7ButBCnt=0;
		~melAct7ButCCnt=0;
		~melAct8ButACnt=0;
		~melAct8ButBCnt=0;
		~melAct8ButCCnt=0;
	}
	*resetLeds{
		//Toggles Active - Times2 - Static
		~melMix.noteOn(~melMixLn1, 1, 0); //But 1
		~melMix.noteOn(~melMixLn1, 2, 0); //But 2
		~melMix.noteOn(~melMixLn1, 3, 0); //But 3

		~melMix.noteOn(~melMixLn1, 4, 0); //But 1
		~melMix.noteOn(~melMixLn1, 5, 0); //But 2
		~melMix.noteOn(~melMixLn1, 6, 0); //But 3

		~melMix.noteOn(~melMixLn1, 7, 0); //But 1
		~melMix.noteOn(~melMixLn1, 8, 0); //But 2
		~melMix.noteOn(~melMixLn1, 9, 0); //But 3

		~melMix.noteOn(~melMixLn1, 10, 0); //But 1
		~melMix.noteOn(~melMixLn1, 11, 0); //But 2
		~melMix.noteOn(~melMixLn1, 12, 0); //But 3

		~melMix.noteOn(~melMixLn1, 13, 0); //But 1
		~melMix.noteOn(~melMixLn1, 14, 0); //But 2
		~melMix.noteOn(~melMixLn1, 15, 0); //But 3

		~melMix.noteOn(~melMixLn1, 16, 0); //But 1
		~melMix.noteOn(~melMixLn1, 17, 0); //But 2
		~melMix.noteOn(~melMixLn1, 18, 0); //But 3

		~melMix.noteOn(~melMixLn1, 19, 0); //But 1
		~melMix.noteOn(~melMixLn1, 20, 0); //But 2
		~melMix.noteOn(~melMixLn1, 21, 0); //But 3

		~melMix.noteOn(~melMixLn1, 22, 0); //But 1
		~melMix.noteOn(~melMixLn1, 23, 0); //But 2
		~melMix.noteOn(~melMixLn1, 24, 0); //But 3

		~melMix.noteOn(~melMixLn1, 25, 0); //But Bank Left
		~melMix.noteOn(~melMixLn1, 26, 0); //But Bank Right


	}

}



/*
~melMix.uid;
~melMix.noteOn(0, 3, 0); //But 1
~melMix.noteOn(~melMixGlb, ~act1A, 1); //But A

~melMix.sysex(Int8Array[
0xf0,
0x47,
0x00,
0x73,
0x60,
0x00,
0x04,
0x42,//40-41-42
09,
00,
05,
0xf7
]);
*/



