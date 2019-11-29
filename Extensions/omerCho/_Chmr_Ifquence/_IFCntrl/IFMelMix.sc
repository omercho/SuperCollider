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
		this.resetLeds;
		//this.ln6;


	}//loadAtStart
	*addr{

	}
	*globals{
		//channels
		~melMixGlobChan=0;
		~melMixLn1=0;
		~melMixLn2=1;
		~melMixLn3=2;
		~melMixLn4=3;
		~melMixLn5=4;
		~melMixLn6=5;
		~melMixLn7=6;
		~melMixLn8=7;
		~melMixLnMaster=8;
		//Nums
		~recBut1=3;~recBut2=6;~recBut3=9;~recBut4=12;
		~recBut5=15;~recBut6=18;~recBut7=21;~recBut8=24;
		~mtBut1=1;~mtBut2=4;~mtBut3=7;~mtBut4=10;
		~mtBut5=13;~mtBut6=16;~mtBut7=19;~mtBut8=22;
		~slBut1=2;~slBut2=5;~slBut3=8;~slBut4=11;
		~slBut5=14;~slBut6=17;~slBut7=20;~slBut8=23;


		~actButA=48;~actButB=49;~actButC=50;
		~bankLeft=25; ~bankRight=26;

	}//globals
	*act1{|val1,val2,val3|
		this.act1ButA(val1);
		this.act1ButB(val2);
		this.act1ButC(val3);
	}
	*act2{|val1,val2,val3|
		this.act2ButA(val1);
		this.act2ButB(val2);
		this.act2ButC(val3);
	}
	*act3{|val1,val2,val3|
		this.act3ButA(val1);
		this.act3ButB(val2);
		this.act3ButC(val3);
	}
	*act4{|val1,val2,val3|
		this.act4ButA(val1);
		this.act4ButB(val2);
		this.act4ButC(val3);
	}
	*act5{|val1,val2,val3|
		this.act5ButA(val1);
		this.act5ButB(val2);
		this.act5ButC(val3);
	}
	*act6{|val1,val2,val3|
		this.act6ButA(val1);
		this.act6ButB(val2);
		this.act6ButC(val3);
	}
	*act7{|val1,val2,val3|
		this.act7ButA(val1);
		this.act7ButB(val2);
		this.act7ButC(val3);
	}
	*act8{|val1,val2,val3|
		this.act8ButA(val1);
		this.act8ButB(val2);
		this.act8ButC(val3);
	}
	//actBank
	*actBank{|val1,val2|
		this.actBankButA(val1);
		this.actBankButB(val2);
	}
	*actBankButA{|val|
		~melMix.noteOn(~melMixGlobChan, ~bankRight, val); //But A

		~cntMix2ActBankButA=val;
	}
	*actBankButB{|val|
		~melMix.noteOn(~melMixGlobChan, ~bankLeft, val); //But B

		~cntMix2ActBankButB=val;
	}//actBank

	//actLine1
	*act1ButA{|val|
		~melMix.noteOn(~melMixGlobChan, ~recBut1, val); //But A
		~tOSCAdrr.sendMsg('activKick', val);
		~actKick.source=val;
		~cntMix2Act1ButA=val;
	}
	*act1ButB{|val|
		~melMix.noteOn(~melMixGlobChan, ~mtBut1, val); //But B
		~tOSCAdrr.sendMsg('shufKick', val);
		~local.sendMsg('shufKick', val);
		~cntMix2Act1ButB=val;
	}
	*act1ButC{|val|
		~melMix.noteOn(~melMixGlobChan, ~slBut1, val); //But C
		~tOSCAdrr.sendMsg('time2Kick', val);
		~tmMulKick.source = Pseq([val+1], inf);
		~cntMix2Act1ButC=val;
	}
	//actLine2
	*act2ButA{|val|
		~melMix.noteOn(~melMixGlobChan, ~recBut2, val); //But A
		~tOSCAdrr.sendMsg('activSnr', val);
		~actSnr.source=val;
		~cntMix2Act2ButA=val;
	}
	*act2ButB{|val|
		~melMix.noteOn(~melMixGlobChan, ~mtBut2, val); //But B
		~tOSCAdrr.sendMsg('shufSnr', val);
		~local.sendMsg('shufSnr', val);
		~cntMix2Act2ButB=val;
	}
	*act2ButC{|val|
		~melMix.noteOn(~melMixGlobChan, ~slBut2, val); //But C
		~tOSCAdrr.sendMsg('time2Snr', val);
		~tmMulSnr.source = Pseq([val+1], inf);
		~cntMix2Act2ButC=val;
	}
	//actLine3
	*act3ButA{|val|
		~melMix.noteOn(~melMixGlobChan, ~recBut3, val); //But A
		~tOSCAdrr.sendMsg('activHat', val);
		~actHat.source=val;
		~cntMix2Act3ButA=val;
	}
	*act3ButB{|val|
		~melMix.noteOn(~melMixGlobChan, ~mtBut3, val); //But B
		~tOSCAdrr.sendMsg('shufHat', val);
		~local.sendMsg('shufHat', val);
		~cntMix2Act3ButB=val;
	}
	*act3ButC{|val|
		~melMix.noteOn(~melMixGlobChan, ~slBut3, val); //But C
		~tOSCAdrr.sendMsg('time2Hat', val);
		~tmMulHat.source = Pseq([val+1], inf);
		~cntMix2Act3ButC=val;
	}
	//actLine4 -- Keys1
	*act4ButA{|val|
		~melMix.noteOn(~melMixGlobChan, ~recBut4, val); //But A
		~tOSCAdrr.sendMsg('activ1Keys', val);
		~act1Keys.source=val;
		~cntMix2Act4ButA=val;
	}
	*act4ButB{|val|
		~melMix.noteOn(~melMixGlobChan, ~mtBut4, val); //But B
		~tOSCAdrr.sendMsg('shufKeys', val);
		~local.sendMsg('shufKeys', val);
		~cntMix2Act4ButB=val;
	}
	*act4ButC{|val|
		~melMix.noteOn(~melMixGlobChan, ~slBut4, val); //But C
		~tOSCAdrr.sendMsg('time2Keys', val);
		~tmMulKeys.source = Pseq([val+1], inf);
		~cntMix2Act4ButC=val;
	}
	//actLine5 -- Keys2
	*act5ButA{|val|
		~melMix.noteOn(~melMixGlobChan, ~recBut5, val); //But A
		~tOSCAdrr.sendMsg('activ2Keys', val);
		~act2Keys.source=val;
		~cntMix2Act5ButA=val;
	}
	*act5ButB{|val|
		~melMix.noteOn(~melMixGlobChan, ~mtBut5, val); //But B

		~cntMix2Act5ButB=val;
	}
	*act5ButC{|val|
		~melMix.noteOn(~melMixGlobChan, ~slBut5, val); //But C
		~cntMix2Act5ButC=val;
	}
	//actLine6 -- Keys3
	*act6ButA{|val|
		~melMix.noteOn(~melMixGlobChan, ~recBut6, val); //But A
		~tOSCAdrr.sendMsg('activ3Keys', val);
		~act3Keys.source=val;
		~cntMix2Act6ButA=val;
	}
	*act6ButB{|val|
		~melMix.noteOn(~melMixGlobChan, ~mtBut6, val); //But B

		~cntMix2Act6ButB=val;
	}
	*act6ButC{|val|
		~melMix.noteOn(~melMixGlobChan, ~slBut6, val); //But C
		~cntMix2Act6ButC=val;
	}
	//actLine7 -- Mopho
	*act7ButA{|val|
		~melMix.noteOn(~melMixGlobChan, ~recBut7, val); //But A
		~tOSCAdrr.sendMsg('activMopho', val);
		~actMopho.source=val;
		~cntMix2Act7ButA=val;
	}
	*act7ButB{|val|
		~melMix.noteOn(~melMixGlobChan, ~mtBut7, val); //But B
		~tOSCAdrr.sendMsg('shufMopho', val);
		~local.sendMsg('shufMopho', val);
		~cntMix2Act7ButB=val;
	}
	*act7ButC{|val|
		~melMix.noteOn(~melMixGlobChan, ~slBut7, val); //But C
		~tOSCAdrr.sendMsg('time2Mopho', val);
		~tmMulMopho.source = Pseq([val+1], inf);
		~cntMix2Act7ButC=val;
	}
	//actLine8 -- IFBass
	*act8ButA{|val|
		~melMix.noteOn(~melMixGlobChan, ~recBut8, val); //But A
		~tOSCAdrr.sendMsg('activBass', val);
		~actBass.source=val;
		~cntMix2Act8ButA=val;
	}
	*act8ButB{|val|
		~melMix.noteOn(~melMixGlobChan, ~mtBut8, val); //But B
		~tOSCAdrr.sendMsg('shufBass', val);
		~local.sendMsg('shufBass', val);
		~cntMix2Act8ButB=val;
	}
	*act8ButC{|val|
		~melMix.noteOn(~melMixGlobChan, ~slBut8, val); //But C
		~tOSCAdrr.sendMsg('lfoBass', val);
		~local.sendMsg('lfoBass', val);
		~cntMix2Act8ButC=val;
	}

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
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~bankRight);
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
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~bankLeft);
		//-------------------------------------------------
		//--------------------line1------------------------
		//Act1 ButA
		~cntMix2Act1ButA=0;
		~melMixAct1ButA.free;
		~melMixAct1ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act1ButA = ~cntMix2Act1ButA + 1;
				~cntMix2Act1ButA.switch(
					0,{},
					1,{this.act1ButA(1);},
					2,{this.act1ButA(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~recBut1);
		//Act1 ButB
		~cntMix2Act1ButB=0;
		~melMixAct1ButB.free;
		~melMixAct1ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act1ButB = ~cntMix2Act1ButB + 1;
				~cntMix2Act1ButB.switch(
					0,{},
					1,{this.act1ButB(1);},
					2,{this.act1ButB(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~mtBut1);
		//Act1 ButC
		~cntMix2Act1ButC=0;
		~melMixAct1ButC.free;
		~melMixAct1ButC=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act1ButC = ~cntMix2Act1ButC + 1;
				~cntMix2Act1ButC.switch(
					0,{},
					1,{this.act1ButC(1);},
					2,{this.act1ButC(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~slBut1);
		//------FAD1
		~melMixFad1.free;
		~melMixFad1=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('volKick', val);
			~volKick.source = val;
			Ambk.cc(\pt1,\pt1Vol,vel*0.79);
		},srcID:~melMixInID, chan:~melMixLn1, ccNum:30);
		~melMixNob1A.free;
		~melMixNob1A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			Ambk.cc(\pt1,\pt1F1Cut,vel*0.79);
		},srcID:~melMixInID, chan:~melMixLn1, ccNum:33);
		~melMixNob1B.free;
		~melMixNob1B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~melMixInID, chan:~melMixLn1, ccNum:32);
		~melMixNob1C.free;
		~melMixNob1C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~melMixInID, chan:~melMixLn1, ccNum:31);
		//--------------------line2
		//Act2 ButA
		~cntMix2Act2ButA=0;
		~melMixAct2ButA.free;
		~melMixAct2ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act2ButA = ~cntMix2Act2ButA + 1;
				~cntMix2Act2ButA.switch(
					1,{this.act2ButA(1);},
					2,{this.act2ButA(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~recBut2);
		//Act2 ButB
		~cntMix2Act2ButB=0;
		~melMixAct2ButB.free;
		~melMixAct2ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act2ButB = ~cntMix2Act2ButB + 1;
				~cntMix2Act2ButB.switch(
					0,{},
					1,{this.act2ButB(1);},
					2,{this.act2ButB(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~mtBut2);
		//Act2 ButC
		~cntMix2Act2ButC=0;
		~melMixAct2ButC.free;
		~melMixAct2ButC=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act2ButC = ~cntMix2Act2ButC + 1;
				~cntMix2Act2ButC.switch(
					0,{},
					1,{this.act2ButC(1);},
					2,{this.act2ButC(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~slBut2);
		~melMixFad2.free;
		~melMixFad2=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('volSnr', val);
			~volSnr.source = val;
			Ambk.cc(\pt2,\pt2Vol,vel*0.79);
		},srcID:~melMixInID, chan:~melMixLn2, ccNum:30);
		//Nobs
		~melMixNob2A.free;
		~melMixNob2A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			Ambk.cc(\pt2,\pt2F1Cut,vel*0.79);
		},srcID:~melMixInID, chan:~melMixLn2, ccNum:33);
		~melMixNob2B.free;
		~melMixNob2B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~melMixInID, chan:~melMixLn2, ccNum:32);
		~melMixNob2C.free;
		~melMixNob2C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~melMixInID, chan:~melMixLn2, ccNum:31);

		//--------------------line3
		//Act3 ButA
		~cntMix2Act3ButA=0;
		~melMixAct3ButA.free;
		~melMixAct3ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act3ButA = ~cntMix2Act3ButA + 1;
				~cntMix2Act3ButA.switch(
					0,{},
					1,{this.act3ButA(1);},
					2,{this.act3ButA(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~recBut3);
		//Act3 ButB
		~cntMix2Act3ButB=0;
		~melMixAct3ButB.free;
		~melMixAct3ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act3ButB = ~cntMix2Act3ButB + 1;
				~cntMix2Act3ButB.switch(
					0,{},
					1,{this.act3ButB(1);},
					2,{this.act3ButB(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~mtBut3);
		//Act3 ButC
		~cntMix2Act3ButC=0;
		~melMixAct3ButC.free;
		~melMixAct3ButC=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act3ButC = ~cntMix2Act3ButC + 1;
				~cntMix2Act3ButC.switch(
					0,{},
					1,{this.act3ButC(1);},
					2,{this.act3ButC(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~slBut3);
		~melMixFad3.free;
		~melMixFad3=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('volHat', val);
			~volHat.source = val;
			Ambk.cc(\pt3,\pt3Vol,vel*0.79);
		},srcID:~melMixInID, chan:~melMixLn3, ccNum:30);
		~melMixNob3A.free;
		~melMixNob3A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			Ambk.cc(\pt3,\pt3F1Cut,vel*0.79);
		},srcID:~melMixInID, chan:~melMixLn3, ccNum:33);
		~melMixNob3B.free;
		~melMixNob3B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('susMulHat', val);
			~susMulHat=(val)+0.08;
		},srcID:~melMixInID, chan:~melMixLn3, ccNum:32);
		~melMixNob3C.free;
		~melMixNob3C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('hatCln', val);
			~mdOut.control(1, 16, vel);//Cln Hats Vol
		},srcID:~melMixInID, chan:~melMixLn3, ccNum:31);
		//---------------line4
		//Act4 ButA
		~cntMix2Act4ButA=0;
		~melMixAct4ButA.free;
		~melMixAct4ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act4ButA = ~cntMix2Act4ButA + 1;
				~cntMix2Act4ButA.switch(
					0,{},
					1,{this.act4ButA(1);},
					2,{this.act4ButA(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~recBut4);
		//Act4 ButB
		~cntMix2Act4ButB=0;
		~melMixAct4ButB.free;
		~melMixAct4ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act4ButB = ~cntMix2Act4ButB + 1;
				~cntMix2Act4ButB.switch(
					0,{},
					1,{this.act4ButB(1);},
					2,{this.act4ButB(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~mtBut4);
		//Act4 ButC
		~cntMix2Act4ButC=0;
		~melMixAct4ButC.free;
		~melMixAct4ButC=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act4ButC = ~cntMix2Act4ButC + 1;
				~cntMix2Act4ButC.switch(
					0,{},
					1,{this.act4ButC(1);},
					2,{this.act4ButC(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~slBut4);
		~melMixFad4.free;
		~melMixFad4=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			IFKeys.set1(\vol,val);
			Ambk.cc(\pt4,\pt4Vol,vel*0.79);
		},srcID:~melMixInID, chan:~melMixLn4, ccNum:30);
		~melMixNob4A.free;
		~melMixNob4A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			Ambk.cc(\pt4,\pt4F1Cut,vel*0.9);

		},srcID:~melMixInID, chan:~melMixLn4, ccNum:33);
		~melMixNob4B.free;
		~melMixNob4B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~melMixInID, chan:~melMixLn4, ccNum:32);
		~melMixNob4C.free;
		~melMixNob4C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~melMixInID, chan:~melMixLn4, ccNum:31);
		///////--------------------------line5
		//Act5 ButA
		~cntMix2Act5ButA=0;
		~melMixAct5ButA.free;
		~melMixAct5ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act5ButA = ~cntMix2Act5ButA + 1;
				~cntMix2Act5ButA.switch(
					1,{this.act5ButA(1);},
					2,{this.act5ButA(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~recBut5);
		//Act5 ButB Keys
		~cntMix2Act5ButB=0;
		~melMixAct5ButB.free;
		~melMixAct5ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act5ButB = ~cntMix2Act5ButB + 1;
				~cntMix2Act5ButB.switch(
					1,{this.act5ButB(1);},
					2,{this.act5ButB(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~mtBut5);
		//Act5 ButC
		~cntMix2Act5ButC=0;
		~melMixAct5ButC.free;
		~melMixAct5ButC=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act5ButC = ~cntMix2Act5ButC + 1;
				~cntMix2Act5ButC.switch(
					0,{},
					1,{this.act5ButC(1);},
					2,{this.act5ButC(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~slBut5);
		~melMixFad5.free;
		~melMixFad5=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			Ambk.cc(\pt5,\pt5Vol,vel*0.79);
		},srcID:~melMixInID, chan:~melMixLn5, ccNum:30);
		~melMixNob5A.free;
		~melMixNob5A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			Ambk.cc(\pt5,\pt5F1Cut,vel*0.9);
		},srcID:~melMixInID, chan:~melMixLn5, ccNum:33);
		~melMixNob5B.free;
		~melMixNob5B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~melMixInID, chan:~melMixLn5, ccNum:32);
		~melMixNob5C.free;
		~melMixNob5C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~melMixInID, chan:~melMixLn5, ccNum:31);
		////////-------------------line6
		//Act6 ButA
		~cntMix2Act6ButA=0;
		~melMixAct6ButA.free;
		~melMixAct6ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act6ButA = ~cntMix2Act6ButA + 1;
				~cntMix2Act6ButA.switch(
					0,{},
					1,{this.act6ButA(1);},
					2,{this.act6ButA(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~recBut6);
		//Act6 ButB
		~cntMix2Act6ButB=0;
		~melMixAct6ButB.free;
		~melMixAct6ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act6ButB = ~cntMix2Act6ButB + 1;
				~cntMix2Act6ButB.switch(
					0,{},
					1,{this.act6ButB(1);},
					2,{this.act6ButB(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~mtBut6);
		//Act6 ButC
		~cntMix2Act6ButC=0;
		~melMixAct6ButC.free;
		~melMixAct6ButC=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act6ButC = ~cntMix2Act6ButC + 1;
				~cntMix2Act6ButC.switch(
					0,{},
					1,{this.act6ButC(1);},
					2,{this.act6ButC(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~slBut6);
		~melMixFad6.free;
		~melMixFad6=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

			Ambk.cc(\pt6,\pt6Vol,vel*0.79);
		},srcID:~melMixInID, chan:~melMixLn6, ccNum:30);
		~melMixNob6A.free;
		~melMixNob6A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			Ambk.cc(\pt6,\pt6F1Cut,vel*0.9);
		},srcID:~melMixInID, chan:~melMixLn6, ccNum:33);
		~melMixNob6B.free;
		~melMixNob6B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~melMixInID, chan:~melMixLn6, ccNum:32);
		~melMixNob6C.free;
		~melMixNob6C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('volClnKeys', val);
			~mdOut.control(1, 19, vel); //Cln Keys Vol
		},srcID:~melMixInID, chan:~melMixLn6, ccNum:31);
		//Act7 ButA
		~cntMix2Act7ButA=0;
		~melMixAct7ButA.free;
		~melMixAct7ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act7ButA = ~cntMix2Act7ButA + 1;
				~cntMix2Act7ButA.switch(
					1,{this.act7ButA(1);},
					2,{this.act7ButA(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~recBut7);
		//Act7 ButB Keys
		~cntMix2Act7ButB=0;
		~melMixAct7ButB.free;
		~melMixAct7ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act7ButB = ~cntMix2Act7ButB + 1;
				~cntMix2Act7ButB.switch(
					1,{this.act7ButB(1);},
					2,{this.act7ButB(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~mtBut7);
		//Act7 ButC
		~cntMix2Act7ButC=0;
		~melMixAct7ButC.free;
		~melMixAct7ButC=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act7ButC = ~cntMix2Act7ButC + 1;
				~cntMix2Act7ButC.switch(
					0,{},
					1,{this.act7ButC(1);},
					2,{this.act7ButC(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~slBut7);
		~melMixFad7.free;
		~melMixFad7=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			IFMopho.set1(\vol,val);
		},srcID:~melMixInID, chan:~melMixLn7, ccNum:30);
		~melMixNob7A.free;
		~melMixNob7A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~melMixInID, chan:~melMixLn7, ccNum:33);
		~melMixNob7B.free;
		~melMixNob7B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~melMixInID, chan:~melMixLn7, ccNum:32);
		~melMixNob7C.free;
		~melMixNob7C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('volClnSamp', val);
			~mdOut.control(1, 17, vel); //Cln Samp Vol
		},srcID:~melMixInID, chan:~melMixLn7, ccNum:31);

		//Act8
		//Act8 ButA
		~cntMix2Act8ButA=0;
		~melMixAct8ButA.free;
		~melMixAct8ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act8ButA = ~cntMix2Act8ButA + 1;
				~cntMix2Act8ButA.switch(
					0,{},
					1, {this.act8ButA(1);},
					2,{this.act8ButA(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~recBut8);
		//Act8 ButB
		~cntMix2Act8ButB=0;
		~melMixAct8ButB.free;
		~melMixAct8ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act8ButB = ~cntMix2Act8ButB + 1;
				~cntMix2Act8ButB.switch(
					0,{},
					1,{this.act8ButB(1);},
					2,{this.act8ButB(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~mtBut8);
		//Act8 ButC
		~cntMix2Act8ButC=0;
		~melMixAct8ButC.free;
		~melMixAct8ButC=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2Act8ButC = ~cntMix2Act8ButC + 1;
				~cntMix2Act8ButC.switch(
					0,{},
					1,{this.act8ButC(1);},
					2,{this.act8ButC(0);}
				)});
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~slBut8);
		~melMixFad8.free;
		~melMixFad8=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			IFBass.set1(\vol,val);
		},srcID:~melMixInID, chan:~melMixLn8, ccNum:30);
		~melMixNob8A.free;
		~melMixNob8A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~melMixInID, chan:~melMixLn8, ccNum:33);
		~melMixNob8B.free;
		~melMixNob8B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~melMixInID, chan:~melMixLn8, ccNum:32);
		~melMixNob8C.free;
		~melMixNob8C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~melMixInID, chan:~melMixLn7, ccNum:31);
		/////
		/////
		//--------------------line--MASTER
		~melMixFadFXMaster.free;
		~melMixFadFXMaster=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			IFSends.set1(\vol1,val);
		},srcID:~melMixInID, chan:~melMixLnMaster, ccNum:30);

		/*~cntMix2ActBankButA=0;
		~melMixAct1ButA.free;
		~melMixAct1ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2ActBankButA = ~cntMix2ActBankButA + 1;
				~cntMix2ActBankButA.switch(
					0,{},
					1, {
						this.actBankButA(1);
					},
					2,{
						this.actBankButA(0);
					}
				)}
			);
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~bankRight);
		//Act1 ButB
		~cntMix2ActBankButB=0;
		~melMixAct1ButB.free;
		~melMixAct1ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMix2ActBankButB = ~cntMix2ActBankButB + 1;
				~cntMix2ActBankButB.switch(
					0,{},
					1, {
						this.actBankButB(1);
					},
					2,{
						this.actBankButB(0);
					}
				)}
			);
		},srcID:~melMixInID, chan:~melMixGlobChan, noteNum:~mtBut1);*/





	}

	*tsLed{|chan,led|
		~melMix.noteOn(0, 51, led);
	}
	*tsLeds{|led1,led2,led3,led4,led5,led6,led7,led8|
		~melMix.noteOn(~melMixLn1, ~recBut1, led1); //But 1
		~melMix.noteOn(~melMixLn1, ~recBut2, led2); //But 2
		~melMix.noteOn(~melMixLn1, ~recBut3, led3); //But 3
		~melMix.noteOn(~melMixLn1, ~recBut4, led4); //But 4
		~melMix.noteOn(~melMixLn1, ~recBut5, led5); //But 5
		~melMix.noteOn(~melMixLn1, ~recBut6, led6); //But 6
		~melMix.noteOn(~melMixLn1, ~recBut7, led7); //But 7
		~melMix.noteOn(~melMixLn1, ~recBut8, led8); //But 8
	}

	/*
	IFMelMix.ndButLeds(1,0,0,0,0,0,0,0);
	IFMelMix.nobDown(mode:2);
	*/
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
	/**ln6{//kick
		~volKick_APC.free;
		~volKick_APC=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('volKick', vel/127);
			~mdOut.control(2, 1, vel);

		},srcID:~melMixInID, chan:0, ccNum:30);

		//Act ButA
		//Kick Activate
		~cntMdMixLine1ButA=0;
		~melMixLine1ButA.free;
		~melMixLine1ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMdMixLine1ButA = ~cntMdMixLine1ButA + 1;
				~cntMdMixLine1ButA.switch(
					0,{},
					1, {
						IFMelMix.actLine1ButA(1);
					},
					2,{
						IFMelMix.actLine1ButA(0);
					}
				)}
			);
		},srcID:~melMixInID, chan:0, noteNum:~recBut1);

		//Act ButB
		//Kick Time Div2
		~cntMdMixLine1ButB=0;
		~melMixLine1ButB.free;
		~melMixLine1ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMdMixLine1ButB = ~cntMdMixLine1ButB + 1;
				~cntMdMixLine1ButB.switch(
					0,{},
					1, {
						IFMelMix.actLine1ButB(1);
					},
					2,{
						IFMelMix.actLine1ButB(0);
					}
				)}
			);
		},srcID:~melMixInID, chan:0, noteNum:~actButB);

		//Act ButC
		//Static Kick Activate
		~cntMdMixLine1ButC=0;
		~melMixLine1ButC.free;
		~melMixLine1ButC=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMdMixLine1ButC = ~cntMdMixLine1ButC + 1;
				~cntMdMixLine1ButC.switch(
					0,{},
					1, {
						IFMelMix.actLine1ButC(1);
					},
					2,{
						IFMelMix.actLine1ButC(0);
					}
				)}
			);
		},srcID:~melMixInID, chan:~melMixLn1, noteNum:~actButC);


	}*/
	//*apc40
}



/*
~melMix.uid;
~melMix.noteOn(0, 3, 0); //But 1
~melMix.noteOn(~melMixGlobChan, ~recBut1, 1); //But A

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



