/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

IFMIDIMix.act1(1,1,1);
IFMIDIMix.act1(0,0,0);
IFMIDIMix.line(~ln1,\butA,val:0);


//to find MIDIOut src
~mdMix.uid;

*/

IFMIDIMix{
	*load{

		this.addr;
		this.globals;
		this.loadResponders;
		this.makeMIDIResponders;
		this.makeOSCResponders;
		this.resetCnts;
		this.resetLeds;
		//this.ln6;


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
		~mdMixGlb=0;
		~mdMixLn1=0;
		~mdMixLn2=1;
		~mdMixLn3=2;
		~mdMixLn4=3;
		~mdMixLn5=4;
		~mdMixLn6=5;
		~mdMixLn7=6;
		~mdMixLn8=7;
		~mdMixLnM=8;
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
		~mdMix.noteOn(~mdMixGlb, ~bnkR, val); //But A
		//~tOSCAdrr.sendMsg('actVKick', val);
		//~actVKick.source=val;
		~cntMixActBankButA=val;
	}
	*actBankButB{|val|
		~mdMix.noteOn(~mdMixGlb, ~bnkL, val); //But B
		//~tOSCAdrr.sendMsg('actVKick2', val);
		//~actVKick2.source=val;
		~cntMixActBankButB=val;
	}//actBank


	*loadResponders{
		//-----------BANKS
		IFMIDIMix.actBankButA(0);
		~cntMixActBankButA=0;
		~mdActBankButA.free;
		~mdActBankButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixActBankButA = ~cntMixActBankButA + 1;
				~cntMixActBankButA.switch(
					1,{IFMIDIMix.actBankButA(1);},
					2,{IFMIDIMix.actBankButA(0);}
			)});
		},srcID:~mdMixInID, chan:~mdMixGlb, noteNum:~bnkR);
		~cntMixActBankButB=0;
		~mdActBankButB.free;
		~mdActBankButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixActBankButB = ~cntMixActBankButB + 1;
				~cntMixActBankButB.switch(
					0,{},
					1, {IFMIDIMix.actBankButB(1);},
					2,{IFMIDIMix.actBankButB(0);}
			)});
		},srcID:~mdMixInID, chan:~mdMixGlb, noteNum:~bnkL);
		/////
		//--------------------line--MASTER
		~mdMixFadFXMaster.free;
		~mdMixFadFXMaster=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			IFSends.set1(\vol1,val);
		},srcID:~mdMixInID, chan:~mdMixLnM, ccNum:30);

	}

	*tsLed{|chan,led|
		~mdMix.noteOn(0, 51, led);
	}
	*tsLeds{|led1,led2,led3,led4,led5,led6,led7,led8|
		~mdMix.noteOn(~mdMixLn1, ~act1A, led1); //But 1
		~mdMix.noteOn(~mdMixLn1, ~act2A, led2); //But 2
		~mdMix.noteOn(~mdMixLn1, ~act3A, led3); //But 3
		~mdMix.noteOn(~mdMixLn1, ~act4A, led4); //But 4
		~mdMix.noteOn(~mdMixLn1, ~act5A, led5); //But 5
		~mdMix.noteOn(~mdMixLn1, ~act6A, led6); //But 6
		~mdMix.noteOn(~mdMixLn1, ~act7A, led7); //But 7
		~mdMix.noteOn(~mdMixLn1, ~act8A, led8); //But 8
	}

	/*
	IFMIDIMix.ndButLeds(1,0,0,0,0,0,0,0);
	IFMIDIMix.nobDown(mode:2);
	*/
	*line{|instLine,paramKey,val|
		var vel;
		vel=val*127;
		instLine.switch(
			1,{paramKey.switch(
				\butA,{
					~mdMix.noteOn(~mdMixGlb, ~act1A, val); //But A
					~tOSCAdrr.sendMsg('activVKick', val);
					~actVKick.source=val;
					~mixAct1ButACnt=val;
				},
				\butB,{
					~mdMix.noteOn(~mdMixGlb, ~act1B, val); //But B
					JmxMBs.cc(\tuneJmx,val*127);
					~mixAct1ButBCnt=val;
				},
				\butC,{
					~mdMix.noteOn(~mdMixGlb, ~act1C, val); //But C
					~mixAct1ButCCnt=val;
				},
				\fad,{JmxMBs.cc(\volJmx,vel);},
				\nobA,{JmxMBs.cc(\tuneJmx,vel);},
				\nobB,{JmxMBs.cc(\decJmx,vel);},
				\nobC,{JmxMBs.cc(\lfoIntJmx,vel);},
			);},
			2,{paramKey.switch(
				\butA,{
					~mdMix.noteOn(~mdMixGlb, ~act2A, val); //But A
					~tOSCAdrr.sendMsg('activVSnr', val);
					~actVSnr.source=val;
					~mixAct2ButACnt=val;
				},
				\butB,{
					~mdMix.noteOn(~mdMixGlb, ~act2B, val); //But B
					/*~tOSCAdrr.sendMsg('activVTomH', val);
					~actVTomH.source=val;*/
					~mixAct2ButBCnt=val;
				},
				\butC,{
					~mdMix.noteOn(~mdMixGlb, ~act2C, val); //But C
					//~tOSCAdrr.sendMsg('shufSnr', val);
					//~local.sendMsg('shufSnr', val);
					~mixAct2ButCCnt=val;
				},
				\fad,{
					~tOSCAdrr.sendMsg('volVSnr', val);
					~volVSnr.source = val;
				},
				\nobA,{

				},
				\nobB,{

				},
				\nobC,{
					~tOSCAdrr.sendMsg('snrCln', val);
					~mdOut.control(1, 15, vel);//Cln Snrs Vol
				}
			);},
			3,{paramKey.switch(
				\butA,{
					~mdMix.noteOn(~mdMixGlb, ~act3A, val); //But A
					~tOSCAdrr.sendMsg('activVHat', val);
					~actVHat.source=val;
					~mixAct3ButACnt=val;
				},
				\butB,{
					~mdMix.noteOn(~mdMixGlb, ~act3B, val); //But B
					/*~tOSCAdrr.sendMsg('activVTomH', val);
					~actVTomH.source=val;*/
					~mixAct3ButBCnt=val;
				},
				\butC,{
					~mdMix.noteOn(~mdMixGlb, ~act3C, val); //But C
					//~tOSCAdrr.sendMsg('shufSnr', val);
					//~local.sendMsg('shufSnr', val);
					~mixAct3ButCCnt=val;
				},
				\fad,{
					~tOSCAdrr.sendMsg('volVHat', val);
					~volVHat.source = val;
				},
				\nobA,{

				},
				\nobB,{

				},
				\nobC,{

				},
			);},
			4,{paramKey.switch(
				\butA,{
					~mdMix.noteOn(~mdMixGlb, ~act4A, val); //But A
					~tOSCAdrr.sendMsg('activVClap', val);
					~actVClap.source=val;
					~mixAct4ButACnt=val;
				},
				\butB,{
					~mdMix.noteOn(~mdMixGlb, ~act4B, val); //But B
					/*~tOSCAdrr.sendMsg('activVTomH', val);
					~actVTomH.source=val;*/
					~mixAct4ButBCnt=val;
				},
				\butC,{
					~mdMix.noteOn(~mdMixGlb, ~act4C, val); //But C
					//~tOSCAdrr.sendMsg('shufSnr', val);
					//~local.sendMsg('shufSnr', val);
					~mixAct4ButCCnt=val;
				},
				\fad,{
					~tOSCAdrr.sendMsg('volVClap', val);
					~volVClap.source = val;
				},
				\nobA,{

				},
				\nobB,{

				},
				\nobC,{

				},
			);},
			5,{paramKey.switch(
				\butA,{
					~mdMix.noteOn(~mdMixGlb, ~act5A, val); //But A
					~tOSCAdrr.sendMsg('activVTomL', val);
					~actVTomL.source=val;
					~mixAct5ButACnt=val;
				},
				\butB,{
					~mdMix.noteOn(~mdMixGlb, ~act5B, val); //But B
					/*~tOSCAdrr.sendMsg('activVTomH', val);
					~actVTomH.source=val;*/
					~mixAct5ButBCnt=val;
				},
				\butC,{
					~mdMix.noteOn(~mdMixGlb, ~act5C, val); //But C
					//~tOSCAdrr.sendMsg('shufSnr', val);
					//~local.sendMsg('shufSnr', val);
					~mixAct5ButCCnt=val;
				},
				\fad,{
					~tOSCAdrr.sendMsg('volVTomL', val);
					~volVTomL.source = val;
				},
				\nobA,{

				},
				\nobB,{

				},
				\nobC,{

				},
			);},
			6,{paramKey.switch(
				\butA,{
					~mdMix.noteOn(~mdMixGlb, ~act6A, val); //But A
					~tOSCAdrr.sendMsg('activVTomH', val);
					~actVTomH.source=val;
					~mixAct6ButACnt=val;
				},
				\butB,{
					~mdMix.noteOn(~mdMixGlb, ~act6B, val); //But B
					/*~tOSCAdrr.sendMsg('activVTomH', val);
					~actVTomH.source=val;*/
					~mixAct6ButBCnt=val;
				},
				\butC,{
					~mdMix.noteOn(~mdMixGlb, ~act6C, val); //But C
					//~tOSCAdrr.sendMsg('shufSnr', val);
					//~local.sendMsg('shufSnr', val);
					~mixAct6ButCCnt=val;
				},
				\fad,{
					~tOSCAdrr.sendMsg('volVTomH', val);
					~volVTomH.source = val;
				},
				\nobA,{

				},
				\nobB,{

				},
				\nobC,{

				},
			);},
			7,{paramKey.switch(
				\butA,{
					~mdMix.noteOn(~mdMixGlb, ~act7A, val); //But A
					//~tOSCAdrr.sendMsg('activVClap', val);
					//~actVClap.source=val;
					~mixAct7ButACnt=val;
				},
				\butB,{
					~mdMix.noteOn(~mdMixGlb, ~act7B, val); //But B
					/*~tOSCAdrr.sendMsg('activVTomH', val);
					~actVTomH.source=val;*/
					~mixAct7ButBCnt=val;
				},
				\butC,{
					~mdMix.noteOn(~mdMixGlb, ~act7C, val); //But C
					//~tOSCAdrr.sendMsg('shufSnr', val);
					//~local.sendMsg('shufSnr', val);
					~mixAct7ButCCnt=val;
				},
				\fad,{
					~tOSCAdrr.sendMsg('volVClap', val);
					~volVClap.source = val;
				},
				\nobA,{

				},
				\nobB,{

				},
				\nobC,{

				},
			);},
			8,{paramKey.switch(
				\butA,{
					~mdMix.noteOn(~mdMixGlb, ~act8A, val); //But A
					~tOSCAdrr.sendMsg('activVClap', val);
					~actVClap.source=val;
					~mixAct8ButACnt=val;
				},
				\butB,{
					~mdMix.noteOn(~mdMixGlb, ~act8B, val); //But B
					/*~tOSCAdrr.sendMsg('activVTomH', val);
					~actVTomH.source=val;*/
					~mixAct8ButBCnt=val;
				},
				\butC,{
					~mdMix.noteOn(~mdMixGlb, ~act8C, val); //But C
					//~tOSCAdrr.sendMsg('shufSnr', val);
					//~local.sendMsg('shufSnr', val);
					~mixAct8ButCCnt=val;
				},
				\fad,{
					~tOSCAdrr.sendMsg('volVClap', val);
					~volVClap.source = val;
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
		this.mdAct(~act1A,\mixAct1ButA_Resp);
		this.mdAct(~act1B,\mixAct1ButB_Resp);
		this.mdAct(~act1C,\mixAct1ButC_Resp);
		this.mdLine(~mdMixLn1,~fad,\mixAct1Fad_Resp);
		this.mdLine(~mdMixLn1,~nobA,\mixAct1NobA_Resp);
		this.mdLine(~mdMixLn1,~nobB,\mixAct1NobB_Resp);
		this.mdLine(~mdMixLn1,~nobC,\mixAct1NobC_Resp);
		//Line2
		this.mdAct(~act2A,\mixAct2ButA_Resp);
		this.mdAct(~act2B,\mixAct2ButB_Resp);
		this.mdAct(~act2C,\mixAct2ButC_Resp);
		this.mdLine(~mdMixLn2,~fad,\mixAct2Fad_Resp);
		this.mdLine(~mdMixLn2,~nobA,\mixAct2NobA_Resp);
		this.mdLine(~mdMixLn2,~nobB,\mixAct2NobB_Resp);
		this.mdLine(~mdMixLn2,~nobC,\mixAct2NobC_Resp);
		//line3
		this.mdAct(~act3A,\mixAct3ButA_Resp);
		this.mdAct(~act3B,\mixAct3ButB_Resp);
		this.mdAct(~act3C,\mixAct3ButC_Resp);
		this.mdLine(~mdMixLn3,~fad,\mixAct3Fad_Resp);
		this.mdLine(~mdMixLn3,~nobA,\mixAct3NobA_Resp);
		this.mdLine(~mdMixLn3,~nobB,\mixAct3NobB_Resp);
		this.mdLine(~mdMixLn3,~nobC,\mixAct3NobC_Resp);
		//line4
		this.mdAct(~act4A,\mixAct4ButA_Resp);
		this.mdAct(~act4B,\mixAct4ButB_Resp);
		this.mdAct(~act4C,\mixAct4ButC_Resp);
		this.mdLine(~mdMixLn4,~fad,\mixAct4Fad_Resp);
		this.mdLine(~mdMixLn4,~nobA,\mixAct4NobA_Resp);
		this.mdLine(~mdMixLn4,~nobB,\mixAct4NobB_Resp);
		this.mdLine(~mdMixLn4,~nobC,\mixAct4NobC_Resp);
		//line5
		this.mdAct(~act5A,\mixAct5ButA_Resp);
		this.mdAct(~act5B,\mixAct5ButB_Resp);
		this.mdAct(~act5C,\mixAct5ButC_Resp);
		this.mdLine(~mdMixLn5,~fad,\mixAct5Fad_Resp);
		this.mdLine(~mdMixLn5,~nobA,\mixAct5NobA_Resp);
		this.mdLine(~mdMixLn5,~nobB,\mixAct5NobB_Resp);
		this.mdLine(~mdMixLn5,~nobC,\mixAct5NobC_Resp);
		//line6
		this.mdAct(~act6A,\mixAct6ButA_Resp);
		this.mdAct(~act6B,\mixAct6ButB_Resp);
		this.mdAct(~act6C,\mixAct6ButC_Resp);
		this.mdLine(~mdMixLn6,~fad,\mixAct6Fad_Resp);
		this.mdLine(~mdMixLn6,~nobA,\mixAct6NobA_Resp);
		this.mdLine(~mdMixLn6,~nobB,\mixAct6NobB_Resp);
		this.mdLine(~mdMixLn6,~nobC,\mixAct6NobC_Resp);
		//line7
		this.mdAct(~act7A,\mixAct7ButA_Resp);
		this.mdAct(~act7B,\mixAct7ButB_Resp);
		this.mdAct(~act7C,\mixAct7ButC_Resp);
		this.mdLine(~mdMixLn7,~fad,\mixAct7Fad_Resp);
		this.mdLine(~mdMixLn7,~nobA,\mixAct7NobA_Resp);
		this.mdLine(~mdMixLn7,~nobB,\mixAct7NobB_Resp);
		this.mdLine(~mdMixLn7,~nobC,\mixAct7NobC_Resp);
		//line8
		this.mdAct(~act8A,\mixAct8ButA_Resp);
		this.mdAct(~act8B,\mixAct8ButB_Resp);
		this.mdAct(~act8C,\mixAct8ButC_Resp);
		this.mdLine(~mdMixLn8,~fad,\mixAct8Fad_Resp);
		this.mdLine(~mdMixLn8,~nobA,\mixAct8NobA_Resp);
		this.mdLine(~mdMixLn8,~nobB,\mixAct8NobB_Resp);
		this.mdLine(~mdMixLn8,~nobC,\mixAct8NobC_Resp);
	}

	*mdAct{|ntNum,nameOn, nameOff|
		MIDIdef.noteOn(nameOn, {
			arg chan,noteNum;

			ntNum.switch(
				//line1
				~act1A,{~local.sendMsg('mixAct1ButA', 1);},
				~act1B,{~local.sendMsg('mixAct1ButB', 1);},
				~act1C,{~local.sendMsg('mixAct1ButC', 1);},
				//line2
				~act2A,{~local.sendMsg('mixAct2ButA', 1);},
				~act2B,{~local.sendMsg('mixAct2ButB', 1);},
				~act2C,{~local.sendMsg('mixAct2ButC', 1);},
				//line3
				~act3A,{~local.sendMsg('mixAct3ButA', 1);},
				~act3B,{~local.sendMsg('mixAct3ButB', 1);},
				~act3C,{~local.sendMsg('mixAct3ButC', 1);},
				//line4
				~act4A,{~local.sendMsg('mixAct4ButA', 1);},
				~act4B,{~local.sendMsg('mixAct4ButB', 1);},
				~act4C,{~local.sendMsg('mixAct4ButC', 1);},
				//line5
				~act5A,{~local.sendMsg('mixAct5ButA', 1);},
				~act5B,{~local.sendMsg('mixAct5ButB', 1);},
				~act5C,{~local.sendMsg('mixAct5ButC', 1);},
				//line6
				~act6A,{~local.sendMsg('mixAct6ButA', 1);},
				~act6B,{~local.sendMsg('mixAct6ButB', 1);},
				~act6C,{~local.sendMsg('mixAct6ButC', 1);},
				//line7
				~act7A,{~local.sendMsg('mixAct7ButA', 1);},
				~act7B,{~local.sendMsg('mixAct7ButB', 1);},
				~act7C,{~local.sendMsg('mixAct7ButC', 1);},
				//line8
				~act8A,{~local.sendMsg('mixAct8ButA', 1);},
				~act8B,{~local.sendMsg('mixAct8ButB', 1);},
				~act8C,{~local.sendMsg('mixAct8ButC', 1);},
			);
		},srcID:~mdMixInID, chan:~mdMixGlb, noteNum:ntNum);
	}
	*mdLine{|chn,cNum,nameOn|
		MIDIdef.cc(nameOn, {
			arg vel,val;
			val=vel/127;
			chn.switch(
				~mdMixLn1,{
					cNum.switch(
						~fad,{~local.sendMsg('mixAct1Fad', val);},
						~nobA,{~local.sendMsg('mixAct1NobA', val);},
						~nobB,{~local.sendMsg('mixAct1NobB', val);},
						~nobC,{~local.sendMsg('mixAct1NobC', val);},
				);},
				~mdMixLn2,{
					cNum.switch(
						~fad,{~local.sendMsg('mixAct2Fad', val);},
						~nobA,{~local.sendMsg('mixAct2NobA', val);},
						~nobB,{~local.sendMsg('mixAct2NobB', val);},
						~nobC,{~local.sendMsg('mixAct2NobC', val);},
				);},
				~mdMixLn3,{
					cNum.switch(
						~fad,{~local.sendMsg('mixAct3Fad', val);},
						~nobA,{~local.sendMsg('mixAct3NobA', val);},
						~nobB,{~local.sendMsg('mixAct3NobB', val);},
						~nobC,{~local.sendMsg('mixAct3NobC', val);},
				);},
				~mdMixLn4,{
					cNum.switch(
						~fad,{~local.sendMsg('mixAct4Fad', val);},
						~nobA,{~local.sendMsg('mixAct4NobA', val);},
						~nobB,{~local.sendMsg('mixAct4NobB', val);},
						~nobC,{~local.sendMsg('mixAct4NobC', val);},
				);},
				~mdMixLn5,{
					cNum.switch(
						~fad,{~local.sendMsg('mixAct5Fad', val);},
						~nobA,{~local.sendMsg('mixAct5NobA', val);},
						~nobB,{~local.sendMsg('mixAct5NobB', val);},
						~nobC,{~local.sendMsg('mixAct5NobC', val);},
				);},
				~mdMixLn6,{
					cNum.switch(
						~fad,{~local.sendMsg('mixAct6Fad', val);},
						~nobA,{~local.sendMsg('mixAct6NobA', val);},
						~nobB,{~local.sendMsg('mixAct6NobB', val);},
						~nobC,{~local.sendMsg('mixAct6NobC', val);},
				);},
				~mdMixLn7,{
					cNum.switch(
						~fad,{~local.sendMsg('mixAct7Fad', val);},
						~nobA,{~local.sendMsg('mixAct7NobA', val);},
						~nobB,{~local.sendMsg('mixAct7NobB', val);},
						~nobC,{~local.sendMsg('mixAct7NobC', val);},
				);},
				~mdMixLn8,{
					cNum.switch(
						~fad,{~local.sendMsg('mixAct8Fad', val);},
						~nobA,{~local.sendMsg('mixAct8NobA', val);},
						~nobB,{~local.sendMsg('mixAct8NobB', val);},
						~nobC,{~local.sendMsg('mixAct8NobC', val);},
				);},
			);

		},srcID:~mdMixInID, chan:chn, ccNum:cNum);
	}

	*oscResp{|respName,oscName,playDir|
		OSCdef(respName, {|msg|
			var val;
			val=msg[1];
			playDir.switch(
				//line1
				'mixAct1ButA_T',{if ( msg[1]==1,{
					~mixAct1ButACnt = ~mixAct1ButACnt + 1;
					~mixAct1ButACnt.switch(1,{this.line(~ln1,\butA,val:1);},2,{this.line(~ln1,\butA,val:0);});
				});},
				'mixAct1ButB_T',{if ( msg[1]==1,{
					~mixAct1ButBCnt = ~mixAct1ButBCnt + 1;
					~mixAct1ButBCnt.switch(1,{this.line(~ln1,\butB,val:1);},2,{this.line(~ln1,\butB,val:0);});
				});},
				'mixAct1ButC_T',{if ( msg[1]==1,{
					~mixAct1ButCCnt = ~mixAct1ButCCnt + 1;
					~mixAct1ButCCnt.switch(1,{this.line(~ln1,\butC,val:1);},2,{this.line(~ln1,\butC,val:0);});
				});},
				'mixAct1Fad_T',{this.line(~ln1,\fad,val:val);},
				'mixAct1NobA_T',{this.line(~ln1,\nobA,val:val);},
				'mixAct1NobB_T',{this.line(~ln1,\nobB,val:val);},
				'mixAct1NobC_T',{this.line(~ln1,\nobC,val:val);},
				//line2
				'mixAct2ButA_T',{if ( msg[1]==1,{
					~mixAct2ButACnt = ~mixAct2ButACnt + 1;
					~mixAct2ButACnt.switch(1,{this.line(~ln2,\butA,val:1);},2,{this.line(~ln2,\butA,val:0);});
				});},
				'mixAct2ButB_T',{if ( msg[1]==1,{
					~mixAct2ButBCnt = ~mixAct2ButBCnt + 1;
					~mixAct2ButBCnt.switch(1,{this.line(~ln2,\butB,val:1);},2,{this.line(~ln2,\butB,val:0);});
				});},
				'mixAct2ButC_T',{if ( msg[1]==1,{
					~mixAct2ButCCnt = ~mixAct2ButCCnt + 1;
					~mixAct2ButCCnt.switch(1,{this.line(~ln2,\butC,val:1);},2,{this.line(~ln2,\butC,val:0);});
				});},
				'mixAct2Fad_T',{this.line(~ln2,\fad,val:val);},
				'mixAct2NobA_T',{this.line(~ln2,\nobA,val:val);},
				'mixAct2NobB_T',{this.line(~ln2,\nobB,val:val);},
				'mixAct2NobC_T',{this.line(~ln2,\nobC,val:val);},
				//line3
				'mixAct3ButA_T',{if ( msg[1]==1,{
					~mixAct3ButACnt = ~mixAct3ButACnt + 1;
					~mixAct3ButACnt.switch(1,{this.line(~ln3,\butA,val:1);},2,{this.line(~ln3,\butA,val:0);});
				});},
				'mixAct3ButB_T',{if ( msg[1]==1,{
					~mixAct3ButBCnt = ~mixAct3ButBCnt + 1;
					~mixAct3ButBCnt.switch(1,{this.line(~ln3,\butB,val:1);},2,{this.line(~ln3,\butB,val:0);});
				});},
				'mixAct3ButC_T',{if ( msg[1]==1,{
					~mixAct3ButCCnt = ~mixAct3ButCCnt + 1;
					~mixAct3ButCCnt.switch(1,{this.line(~ln3,\butC,val:1);},2,{this.line(~ln3,\butC,val:0);});
				});},
				'mixAct3Fad_T',{this.line(~ln3,\fad,val:val);},
				'mixAct3NobA_T',{this.line(~ln3,\nobA,val:val);},
				'mixAct3NobB_T',{this.line(~ln3,\nobB,val:val);},
				'mixAct3NobC_T',{this.line(~ln3,\nobC,val:val);},
				//line4
				'mixAct4ButA_T',{if ( msg[1]==1,{
					~mixAct4ButACnt = ~mixAct4ButACnt + 1;
					~mixAct4ButACnt.switch(1,{this.line(~ln4,\butA,val:1);},2,{this.line(~ln4,\butA,val:0);});
				});},
				'mixAct4ButB_T',{if ( msg[1]==1,{
					~mixAct4ButBCnt = ~mixAct4ButBCnt + 1;
					~mixAct4ButBCnt.switch(1,{this.line(~ln4,\butB,val:1);},2,{this.line(~ln4,\butB,val:0);});
				});},
				'mixAct4ButC_T',{if ( msg[1]==1,{
					~mixAct4ButCCnt = ~mixAct4ButCCnt + 1;
					~mixAct4ButCCnt.switch(1,{this.line(~ln4,\butC,val:1);},2,{this.line(~ln4,\butC,val:0);});
				});},
				'mixAct4Fad_T',{this.line(~ln4,\fad,val:val);},
				'mixAct4NobA_T',{this.line(~ln4,\nobA,val:val);},
				'mixAct4NobB_T',{this.line(~ln4,\nobB,val:val);},
				'mixAct4NobC_T',{this.line(~ln4,\nobC,val:val);},
				//line5
				'mixAct5ButA_T',{if ( msg[1]==1,{
					~mixAct5ButACnt = ~mixAct5ButACnt + 1;
					~mixAct5ButACnt.switch(1,{this.line(~ln5,\butA,val:1);},2,{this.line(~ln5,\butA,val:0);});
				});},
				'mixAct5ButB_T',{if ( msg[1]==1,{
					~mixAct5ButBCnt = ~mixAct5ButBCnt + 1;
					~mixAct5ButBCnt.switch(1,{this.line(~ln5,\butB,val:1);},2,{this.line(~ln5,\butB,val:0);});
				});},
				'mixAct5ButC_T',{if ( msg[1]==1,{
					~mixAct5ButCCnt = ~mixAct5ButCCnt + 1;
					~mixAct5ButCCnt.switch(1,{this.line(~ln5,\butC,val:1);},2,{this.line(~ln5,\butC,val:0);});
				});},
				'mixAct5Fad_T',{this.line(~ln5,\fad,val:val);},
				'mixAct5NobA_T',{this.line(~ln5,\nobA,val:val);},
				'mixAct5NobB_T',{this.line(~ln5,\nobB,val:val);},
				'mixAct5NobC_T',{this.line(~ln5,\nobC,val:val);},
				//line6
				'mixAct6ButA_T',{if ( msg[1]==1,{
					~mixAct6ButACnt = ~mixAct6ButACnt + 1;
					~mixAct6ButACnt.switch(1,{this.line(~ln6,\butA,val:1);},2,{this.line(~ln6,\butA,val:0);});
				});},
				'mixAct6ButB_T',{if ( msg[1]==1,{
					~mixAct6ButBCnt = ~mixAct6ButBCnt + 1;
					~mixAct6ButBCnt.switch(1,{this.line(~ln6,\butB,val:1);},2,{this.line(~ln6,\butB,val:0);});
				});},
				'mixAct6ButC_T',{if ( msg[1]==1,{
					~mixAct6ButCCnt = ~mixAct6ButCCnt + 1;
					~mixAct6ButCCnt.switch(1,{this.line(~ln6,\butC,val:1);},2,{this.line(~ln6,\butC,val:0);});
				});},
				'mixAct6Fad_T',{this.line(~ln6,\fad,val:val);},
				'mixAct6NobA_T',{this.line(~ln6,\nobA,val:val);},
				'mixAct6NobB_T',{this.line(~ln6,\nobB,val:val);},
				'mixAct6NobC_T',{this.line(~ln6,\nobC,val:val);},
				//line7
				'mixAct7ButA_T',{if ( msg[1]==1,{
					~mixAct7ButACnt = ~mixAct7ButACnt + 1;
					~mixAct7ButACnt.switch(1,{this.line(~ln7,\butA,val:1);},2,{this.line(~ln7,\butA,val:0);});
				});},
				'mixAct7ButB_T',{if ( msg[1]==1,{
					~mixAct7ButBCnt = ~mixAct7ButBCnt + 1;
					~mixAct7ButBCnt.switch(1,{this.line(~ln7,\butB,val:1);},2,{this.line(~ln7,\butB,val:0);});
				});},
				'mixAct7ButC_T',{if ( msg[1]==1,{
					~mixAct7ButCCnt = ~mixAct7ButCCnt + 1;
					~mixAct7ButCCnt.switch(1,{this.line(~ln7,\butC,val:1);},2,{this.line(~ln7,\butC,val:0);});
				});},
				'mixAct7Fad_T',{this.line(~ln7,\fad,val:val);},
				'mixAct7NobA_T',{this.line(~ln7,\nobA,val:val);},
				'mixAct7NobB_T',{this.line(~ln7,\nobB,val:val);},
				'mixAct7NobC_T',{this.line(~ln7,\nobC,val:val);},
				//line8
				'mixAct8ButA_T',{if ( msg[1]==1,{
					~mixAct8ButACnt = ~mixAct8ButACnt + 1;
					~mixAct8ButACnt.switch(1,{this.line(~ln8,\butA,val:1);},2,{this.line(~ln8,\butA,val:0);});
				});},
				'mixAct8ButB_T',{if ( msg[1]==1,{
					~mixAct8ButBCnt = ~mixAct8ButBCnt + 1;
					~mixAct8ButBCnt.switch(1,{this.line(~ln8,\butB,val:1);},2,{this.line(~ln8,\butB,val:0);});
				});},
				'mixAct8ButC_T',{if ( msg[1]==1,{
					~mixAct8ButCCnt = ~mixAct8ButCCnt + 1;
					~mixAct8ButCCnt.switch(1,{this.line(~ln8,\butC,val:1);},2,{this.line(~ln8,\butC,val:0);});
				});},
				'mixAct8Fad_T',{this.line(~ln8,\fad,val:val);},
				'mixAct8NobA_T',{this.line(~ln8,\nobA,val:val);},
				'mixAct8NobB_T',{this.line(~ln8,\nobB,val:val);},
				'mixAct8NobC_T',{this.line(~ln8,\nobC,val:val);},
			);
		},path:oscName);
	}
	*makeOSCResponders{
		//line1
		this.oscResp(respName:'mixAct1ButA_Resp', oscName:'mixAct1ButA', playDir:'mixAct1ButA_T');
		this.oscResp(respName:'mixAct1ButB_Resp', oscName:'mixAct1ButB', playDir:'mixAct1ButB_T');
		this.oscResp(respName:'mixAct1ButC_Resp', oscName:'mixAct1ButC', playDir:'mixAct1ButC_T');
		this.oscResp(respName:'mixAct1Fad_Resp', oscName:'mixAct1Fad', playDir:'mixAct1Fad_T');
		this.oscResp(respName:'mixAct1NobA_Resp', oscName:'mixAct1NobA', playDir:'mixAct1NobA_T');
		this.oscResp(respName:'mixAct1NobB_Resp', oscName:'mixAct1NobB', playDir:'mixAct1NobB_T');
		this.oscResp(respName:'mixAct1NobC_Resp', oscName:'mixAct1NobC', playDir:'mixAct1NobC_T');
		//line2
		this.oscResp(respName:'mixAct2ButA_Resp', oscName:'mixAct2ButA', playDir:'mixAct2ButA_T');
		this.oscResp(respName:'mixAct2ButB_Resp', oscName:'mixAct2ButB', playDir:'mixAct2ButB_T');
		this.oscResp(respName:'mixAct2ButC_Resp', oscName:'mixAct2ButC', playDir:'mixAct2ButC_T');
		this.oscResp(respName:'mixAct2Fad_Resp', oscName:'mixAct2Fad', playDir:'mixAct2Fad_T');
		this.oscResp(respName:'mixAct2NobA_Resp', oscName:'mixAct2NobA', playDir:'mixAct2NobA_T');
		this.oscResp(respName:'mixAct2NobB_Resp', oscName:'mixAct2NobB', playDir:'mixAct2NobB_T');
		this.oscResp(respName:'mixAct2NobC_Resp', oscName:'mixAct2NobC', playDir:'mixAct2NobC_T');
		//line3
		this.oscResp(respName:'mixAct3ButA_Resp', oscName:'mixAct3ButA', playDir:'mixAct3ButA_T');
		this.oscResp(respName:'mixAct3ButB_Resp', oscName:'mixAct3ButB', playDir:'mixAct3ButB_T');
		this.oscResp(respName:'mixAct3ButC_Resp', oscName:'mixAct3ButC', playDir:'mixAct3ButC_T');
		this.oscResp(respName:'mixAct3Fad_Resp', oscName:'mixAct3Fad', playDir:'mixAct3Fad_T');
		this.oscResp(respName:'mixAct3NobA_Resp', oscName:'mixAct3NobA', playDir:'mixAct3NobA_T');
		this.oscResp(respName:'mixAct3NobB_Resp', oscName:'mixAct3NobB', playDir:'mixAct3NobB_T');
		this.oscResp(respName:'mixAct3NobC_Resp', oscName:'mixAct3NobC', playDir:'mixAct3NobC_T');
		//line4
		this.oscResp(respName:'mixAct4ButA_Resp', oscName:'mixAct4ButA', playDir:'mixAct4ButA_T');
		this.oscResp(respName:'mixAct4ButB_Resp', oscName:'mixAct4ButB', playDir:'mixAct4ButB_T');
		this.oscResp(respName:'mixAct4ButC_Resp', oscName:'mixAct4ButC', playDir:'mixAct4ButC_T');
		this.oscResp(respName:'mixAct4Fad_Resp', oscName:'mixAct4Fad', playDir:'mixAct4Fad_T');
		this.oscResp(respName:'mixAct4NobA_Resp', oscName:'mixAct4NobA', playDir:'mixAct4NobA_T');
		this.oscResp(respName:'mixAct4NobB_Resp', oscName:'mixAct4NobB', playDir:'mixAct4NobB_T');
		this.oscResp(respName:'mixAct4NobC_Resp', oscName:'mixAct4NobC', playDir:'mixAct4NobC_T');
		//line5
		this.oscResp(respName:'mixAct5ButA_Resp', oscName:'mixAct5ButA', playDir:'mixAct5ButA_T');
		this.oscResp(respName:'mixAct5ButB_Resp', oscName:'mixAct5ButB', playDir:'mixAct5ButB_T');
		this.oscResp(respName:'mixAct5ButC_Resp', oscName:'mixAct5ButC', playDir:'mixAct5ButC_T');
		this.oscResp(respName:'mixAct5Fad_Resp', oscName:'mixAct5Fad', playDir:'mixAct5Fad_T');
		this.oscResp(respName:'mixAct5NobA_Resp', oscName:'mixAct5NobA', playDir:'mixAct5NobA_T');
		this.oscResp(respName:'mixAct5NobB_Resp', oscName:'mixAct5NobB', playDir:'mixAct5NobB_T');
		this.oscResp(respName:'mixAct5NobC_Resp', oscName:'mixAct5NobC', playDir:'mixAct5NobC_T');
		//line6
		this.oscResp(respName:'mixAct6ButA_Resp', oscName:'mixAct6ButA', playDir:'mixAct6ButA_T');
		this.oscResp(respName:'mixAct6ButB_Resp', oscName:'mixAct6ButB', playDir:'mixAct6ButB_T');
		this.oscResp(respName:'mixAct6ButC_Resp', oscName:'mixAct6ButC', playDir:'mixAct6ButC_T');
		this.oscResp(respName:'mixAct6Fad_Resp', oscName:'mixAct6Fad', playDir:'mixAct6Fad_T');
		this.oscResp(respName:'mixAct6NobA_Resp', oscName:'mixAct6NobA', playDir:'mixAct6NobA_T');
		this.oscResp(respName:'mixAct6NobB_Resp', oscName:'mixAct6NobB', playDir:'mixAct6NobB_T');
		this.oscResp(respName:'mixAct6NobC_Resp', oscName:'mixAct6NobC', playDir:'mixAct6NobC_T');
		//line7
		this.oscResp(respName:'mixAct7ButA_Resp', oscName:'mixAct7ButA', playDir:'mixAct7ButA_T');
		this.oscResp(respName:'mixAct7ButB_Resp', oscName:'mixAct7ButB', playDir:'mixAct7ButB_T');
		this.oscResp(respName:'mixAct7ButC_Resp', oscName:'mixAct7ButC', playDir:'mixAct7ButC_T');
		this.oscResp(respName:'mixAct7Fad_Resp', oscName:'mixAct7Fad', playDir:'mixAct7Fad_T');
		this.oscResp(respName:'mixAct7NobA_Resp', oscName:'mixAct7NobA', playDir:'mixAct7NobA_T');
		this.oscResp(respName:'mixAct7NobB_Resp', oscName:'mixAct7NobB', playDir:'mixAct7NobB_T');
		this.oscResp(respName:'mixAct7NobC_Resp', oscName:'mixAct7NobC', playDir:'mixAct7NobC_T');
		//line8
		this.oscResp(respName:'mixAct8ButA_Resp', oscName:'mixAct8ButA', playDir:'mixAct8ButA_T');
		this.oscResp(respName:'mixAct8ButB_Resp', oscName:'mixAct8ButB', playDir:'mixAct8ButB_T');
		this.oscResp(respName:'mixAct8ButC_Resp', oscName:'mixAct8ButC', playDir:'mixAct8ButC_T');
		this.oscResp(respName:'mixAct8Fad_Resp', oscName:'mixAct8Fad', playDir:'mixAct8Fad_T');
		this.oscResp(respName:'mixAct8NobA_Resp', oscName:'mixAct8NobA', playDir:'mixAct8NobA_T');
		this.oscResp(respName:'mixAct8NobB_Resp', oscName:'mixAct8NobB', playDir:'mixAct8NobB_T');
		this.oscResp(respName:'mixAct8NobC_Resp', oscName:'mixAct8NobC', playDir:'mixAct8NobC_T');
	}

	*resetCnts{
		~mixAct1ButACnt=0;
		~mixAct1ButBCnt=0;
		~mixAct1ButCCnt=0;
		~mixAct2ButACnt=0;
		~mixAct2ButBCnt=0;
		~mixAct2ButCCnt=0;
		~mixAct3ButACnt=0;
		~mixAct3ButBCnt=0;
		~mixAct3ButCCnt=0;
		~mixAct4ButACnt=0;
		~mixAct4ButBCnt=0;
		~mixAct4ButCCnt=0;
		~mixAct5ButACnt=0;
		~mixAct5ButBCnt=0;
		~mixAct5ButCCnt=0;
		~mixAct6ButACnt=0;
		~mixAct6ButBCnt=0;
		~mixAct6ButCCnt=0;
		~mixAct7ButACnt=0;
		~mixAct7ButBCnt=0;
		~mixAct7ButCCnt=0;
		~mixAct8ButACnt=0;
		~mixAct8ButBCnt=0;
		~mixAct8ButCCnt=0;
	}

	*resetLeds{
		//Toggles Active - Times2 - Static
		~mdMix.noteOn(~mdMixLn1, 1, 0); //But 1
		~mdMix.noteOn(~mdMixLn1, 2, 0); //But 2
		~mdMix.noteOn(~mdMixLn1, 3, 0); //But 3

		~mdMix.noteOn(~mdMixLn1, 4, 0); //But 1
		~mdMix.noteOn(~mdMixLn1, 5, 0); //But 2
		~mdMix.noteOn(~mdMixLn1, 6, 0); //But 3

		~mdMix.noteOn(~mdMixLn1, 7, 0); //But 1
		~mdMix.noteOn(~mdMixLn1, 8, 0); //But 2
		~mdMix.noteOn(~mdMixLn1, 9, 0); //But 3

		~mdMix.noteOn(~mdMixLn1, 10, 0); //But 1
		~mdMix.noteOn(~mdMixLn1, 11, 0); //But 2
		~mdMix.noteOn(~mdMixLn1, 12, 0); //But 3

		~mdMix.noteOn(~mdMixLn1, 13, 0); //But 1
		~mdMix.noteOn(~mdMixLn1, 14, 0); //But 2
		~mdMix.noteOn(~mdMixLn1, 15, 0); //But 3

		~mdMix.noteOn(~mdMixLn1, 16, 0); //But 1
		~mdMix.noteOn(~mdMixLn1, 17, 0); //But 2
		~mdMix.noteOn(~mdMixLn1, 18, 0); //But 3

		~mdMix.noteOn(~mdMixLn1, 19, 0); //But 1
		~mdMix.noteOn(~mdMixLn1, 20, 0); //But 2
		~mdMix.noteOn(~mdMixLn1, 21, 0); //But 3

		~mdMix.noteOn(~mdMixLn1, 22, 0); //But 1
		~mdMix.noteOn(~mdMixLn1, 23, 0); //But 2
		~mdMix.noteOn(~mdMixLn1, 24, 0); //But 3

		~mdMix.noteOn(~mdMixLn1, 25, 0); //But Bank Left
		~mdMix.noteOn(~mdMixLn1, 26, 0); //But Bank Right


	}

}



/*
~mdMix.uid;
~mdMix.noteOn(0, 3, 0); //But 1
~mdMix.noteOn(~mdMixGlb, ~act1A, 1); //But A

~mdMix.sysex(Int8Array[
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



