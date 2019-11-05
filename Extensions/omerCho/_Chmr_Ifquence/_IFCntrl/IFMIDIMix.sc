/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

IFMIDIMix.act1(1,1,1);
IFMIDIMix.act1(0,0,0);


//to find MIDIOut src
~mdMix.uid;

*/

IFMIDIMix{
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
		~mdMixGlobChan=0;
		~mdMixLn1=0;
		~mdMixLn2=1;
		~mdMixLn3=2;
		~mdMixLn4=3;
		~mdMixLn5=4;
		~mdMixLn6=5;
		~mdMixLn7=6;
		~mdMixLn8=7;
		~mdMixLnMaster=8;
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
		~mdMix.noteOn(~mdMixGlobChan, ~bankRight, val); //But A
		//~tOSCAdrr.sendMsg('actVKick', val);
		//~actVKick.source=val;
		~cntMixActBankButA=val;
	}
	*actBankButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~bankLeft, val); //But B
		//~tOSCAdrr.sendMsg('actVKick2', val);
		//~actVKick2.source=val;
		~cntMixActBankButB=val;
	}//actBank

	//actLine1
	*act1ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut1, val); //But A
		~tOSCAdrr.sendMsg('activVKick', val);
		~actVKick.source=val;
		~cntMixAct1ButA=val;
	}
	*act1ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut1, val); //But B
		~tOSCAdrr.sendMsg('activVTomL', val);
		~actVTomL.source=val;
		//JmxMBs.cc(\tuneJmx,val*127);
		~cntMixAct1ButB=val;
	}
	*act1ButC{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~slBut1, val); //But C
		//~tOSCAdrr.sendMsg('shufKick', val);
		//~local.sendMsg('shufKick', val);
		~cntMixAct1ButC=val;
	}
	//actLine2
	*act2ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut2, val); //But A
		~tOSCAdrr.sendMsg('activVSnr', val);
		~actVSnr.source=val;
		~cntMixAct2ButA=val;
	}
	*act2ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut2, val); //But B
		~tOSCAdrr.sendMsg('activVClap', val);
		~actVClap.source=val;
		/*~tOSCAdrr.sendMsg('activVTomH', val);
		~actVTomH.source=val;*/
		~cntMixAct2ButB=val;
	}
	*act2ButC{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~slBut2, val); //But C
		//~tOSCAdrr.sendMsg('shufSnr', val);
		//~local.sendMsg('shufSnr', val);
		~cntMixAct2ButC=val;
	}
	//actLine3
	*act3ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut3, val); //But A
		~tOSCAdrr.sendMsg('activVHat', val);
		~actVHat.source=val;
		~cntMixAct3ButA=val;
	}
	*act3ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut3, val); //But B
		/*~tOSCAdrr.sendMsg('activVCrash', val);
		~actVCrsh.source=val;*/
		~tOSCAdrr.sendMsg('activVTomH', val);
		~actVTomH.source=val;
		~cntMixAct3ButB=val;
	}
	*act3ButC{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~slBut3, val); //But C
		//~tOSCAdrr.sendMsg('shufHat', val);
		//~local.sendMsg('shufHat', val);
		~cntMixAct3ButC=val;
	}
	//actLine4
	*act4ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut4, val); //But A
		/*~tOSCAdrr.sendMsg('activVClap', val);
		~actVClap.source=val;*/
		~cntMixAct4ButA=val;
	}
	*act4ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut4, val); //But B
		/*~tOSCAdrr.sendMsg('activVPcm', val);
		~actVPcm.source=val;*/
		~cntMixAct4ButB=val;
	}
	*act4ButC{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~slBut4, val); //But C
		~cntMixAct4ButC=val;
	}
	//actLine5
	*act5ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut5, val); //But A
		/*~tOSCAdrr.sendMsg('activVTomL', val);
		~actVTomL.source=val;*/
		~cntMixAct5ButA=val;
	}
	*act5ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut5, val); //But B
		//~local.sendMsg('time2VSamp', val);
		//~tmMulKeys.source = Pseq([val+1], inf);
		~cntMixAct5ButB=val;
	}
	*act5ButC{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~slBut5, val); //But C
		~cntMixAct5ButC=val;
	}
	//actLine6 --
	*act6ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut6, val); //But A
		/*~tOSCAdrr.sendMsg('activVTomH', val);
		~actVTomH.source=val;*/
		~cntMixAct6ButA=val;
	}
	*act6ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut6, val); //But B
		//~local.sendMsg('time2Samp', val);
		//~tmMulSamp.source = Pseq([val+1], inf);
		~cntMixAct6ButB=val;
	}
	*act6ButC{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~slBut6, val); //But C
		~cntMixAct6ButC=val;
	}
	//actLine7 -- Mast
	*act7ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut7, val); //But A
		~tOSCAdrr.sendMsg('activStMast', val);
		//~actStHat.source=val;
		~cntMixAct7ButA=val;
	}
	*act7ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut7, val); //But B
		//~tOSCAdrr.sendMsg('time2Mast', val);
		//~tmMulMast.source = Pseq([val+1], inf);
		~cntMixAct7ButB=val;
	}
	*act7ButC{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~slBut7, val); //But C
		~cntMixAct7ButC=val;
	}
	//actLine8 -- Res1
	*act8ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut8, val); //But A
		~tOSCAdrr.sendMsg('activStRes', val);
		//~actStHat.source=val;
		~cntMixAct8ButA=val;
	}
	*act8ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut8, val); //But B
		//~tOSCAdrr.sendMsg('time2Res', val);
		//~tmMulRes.source = Pseq([val+1], inf);
		~cntMixAct8ButB=val;
	}
	*act8ButC{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~slBut8, val); //But C
		~cntMixAct8ButC=val;
	}

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
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~bankRight);
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
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~bankLeft);
		//-------------------------------------------------
		//--------------------line1------------------------
		//Act1 ButA
		~cntMixAct1ButA=0;
		~mdMixAct1ButA.free;
		~mdMixAct1ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct1ButA = ~cntMixAct1ButA + 1;
				~cntMixAct1ButA.switch(
					0,{},
					1, {this.act1ButA(1);},
					2,{this.act1ButA(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~recBut1);
		//Act1 ButB
		~cntMixAct1ButB=0;
		~mdMixAct1ButB.free;
		~mdMixAct1ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct1ButB = ~cntMixAct1ButB + 1;
				~cntMixAct1ButB.switch(
					0,{},
					1,{this.act1ButB(1);},
					2,{this.act1ButB(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~mtBut1);
		//Act1 ButC
		~cntMixAct1ButC=0;
		~mdMixAct1ButC.free;
		~mdMixAct1ButC=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct1ButC = ~cntMixAct1ButC + 1;
				~cntMixAct1ButC.switch(
					0,{},
					1,{this.act1ButC(1);},
					2,{this.act1ButC(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~slBut1);
		~mdMixFad1.free;
		~mdMixFad1=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('volVKick', val);
			JmxMBs.cc(\volJmx,vel);
			~volVKick.source = vel;
		},srcID:~mdMixInID, chan:~mdMixLn1, ccNum:30);
		~mdMixNob1A.free;
		~mdMixNob1A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('volKick', val);
			~volKick.source = val;
		},srcID:~mdMixInID, chan:~mdMixLn1, ccNum:33);
		~mdMixNob1B.free;
		~mdMixNob1B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			JmxMBs.cc(\decJmx,vel);
		},srcID:~mdMixInID, chan:~mdMixLn1, ccNum:32);
		~mdMixNob1C.free;
		~mdMixNob1C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			JmxMBs.cc(\lfoRtJmx,vel);
			~susMulKick=(127/vel)+0.15;
			//JmxMBs.cc(\lfoIntJmx,vel);
		},srcID:~mdMixInID, chan:~mdMixLn1, ccNum:31);
		//--------------------line2
		//Act2 ButA
		~cntMixAct2ButA=0;
		~mdMixAct2ButA.free;
		~mdMixAct2ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct2ButA = ~cntMixAct2ButA + 1;
				~cntMixAct2ButA.switch(
					1,{this.act2ButA(1);},
					2,{this.act2ButA(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~recBut2);
		//Act2 ButB
		~cntMixAct2ButB=0;
		~mdMixAct2ButB.free;
		~mdMixAct2ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct2ButB = ~cntMixAct2ButB + 1;
				~cntMixAct2ButB.switch(
					0,{},
					1,{this.act2ButB(1);},
					2,{this.act2ButB(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~mtBut2);
		//Act2 ButC
		~cntMixAct2ButC=0;
		~mdMixAct2ButC.free;
		~mdMixAct2ButC=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct2ButC = ~cntMixAct2ButC + 1;
				~cntMixAct2ButC.switch(
					0,{},
					1,{this.act2ButC(1);},
					2,{this.act2ButC(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~slBut2);
		~mdMixFad2.free;
		~mdMixFad2=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			/*~tOSCAdrr.sendMsg('volSnr', val);
			~volSnr.source = val;
			~tOSCAdrr.sendMsg('volSnr2', val);
			~volSnr2.source = val;*/
			~tOSCAdrr.sendMsg('volVSnr', val);
			~volVSnr.source = val;
		},srcID:~mdMixInID, chan:~mdMixLn2, ccNum:30);
		//Nobs
		~mdMixNob2A.free;
		~mdMixNob2A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('volSnr', val);
			~volSnr.source = val;
		},srcID:~mdMixInID, chan:~mdMixLn2, ccNum:33);
		~mdMixNob2B.free;
		~mdMixNob2B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~mdMixInID, chan:~mdMixLn2, ccNum:32);
		~mdMixNob2C.free;
		~mdMixNob2C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('snrCln', val);
			~mdOut.control(1, 15, vel);//Cln Snrs Vol
		},srcID:~mdMixInID, chan:~mdMixLn2, ccNum:31);

		//--------------------line3
		//Act3 ButA
		~cntMixAct3ButA=0;
		~mdMixAct3ButA.free;
		~mdMixAct3ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct3ButA = ~cntMixAct3ButA + 1;
				~cntMixAct3ButA.switch(
					0,{},
					1,{this.act3ButA(1);},
					2,{this.act3ButA(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~recBut3);
		//Act3 ButB
		~cntMixAct3ButB=0;
		~mdMixAct3ButB.free;
		~mdMixAct3ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct3ButB = ~cntMixAct3ButB + 1;
				~cntMixAct3ButB.switch(
					0,{},
					1,{this.act3ButB(1);},
					2,{this.act3ButB(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~mtBut3);
		//Act3 ButC
		~cntMixAct3ButC=0;
		~mdMixAct3ButC.free;
		~mdMixAct3ButC=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct3ButC = ~cntMixAct3ButC + 1;
				~cntMixAct3ButC.switch(
					0,{},
					1,{this.act3ButC(1);},
					2,{this.act3ButC(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~slBut3);
		~mdMixFad3.free;
		~mdMixFad3=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			/*~tOSCAdrr.sendMsg('volHat', val);
			~volHat.source = val;*/
			~tOSCAdrr.sendMsg('volVHat', val);
			~volVHat.source = val;
		},srcID:~mdMixInID, chan:~mdMixLn3, ccNum:30);
		~mdMixNob3A.free;
		~mdMixNob3A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('volHat', val);
			~volHat.source = val;
		},srcID:~mdMixInID, chan:~mdMixLn3, ccNum:33);
		~mdMixNob3B.free;
		~mdMixNob3B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('susMulHat', val);
			~susMulHat=(val)+0.08;
		},srcID:~mdMixInID, chan:~mdMixLn3, ccNum:32);
		~mdMixNob3C.free;
		~mdMixNob3C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('hatCln', val);
			~mdOut.control(1, 16, vel);//Cln Hats Vol
		},srcID:~mdMixInID, chan:~mdMixLn3, ccNum:31);
		//----------------MEL--------------//
		//---------------line4
		//Act4 ButA
		~cntMixAct4ButA=0;
		~mdMixAct4ButA.free;
		~mdMixAct4ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct4ButA = ~cntMixAct4ButA + 1;
				~cntMixAct4ButA.switch(
					0,{},
					1,{this.act4ButA(1);},
					2,{this.act4ButA(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~recBut4);
		//Act4 ButB
		~cntMixAct4ButB=0;
		~mdMixAct4ButB.free;
		~mdMixAct4ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct4ButB = ~cntMixAct4ButB + 1;
				~cntMixAct4ButB.switch(
					0,{},
					1,{this.act4ButB(1);},
					2,{this.act4ButB(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~mtBut4);
		~mdMixFad4.free;
		~mdMixFad4=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			IFBass.set1(\susM,val);
		},srcID:~mdMixInID, chan:~mdMixLn4, ccNum:30);
		~mdMixNob4A.free;
		~mdMixNob4A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;


		},srcID:~mdMixInID, chan:~mdMixLn4, ccNum:33);
		~mdMixNob4B.free;
		~mdMixNob4B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;


		},srcID:~mdMixInID, chan:~mdMixLn4, ccNum:32);
		~mdMixNob4C.free;
		~mdMixNob4C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			//~tOSCAdrr.sendMsg('speedClap', vel/127);

		},srcID:~mdMixInID, chan:~mdMixLn4, ccNum:31);
		///////--------------------------line5
		//Act5 ButA
		~cntMixAct5ButA=0;
		~mdMixAct5ButA.free;
		~mdMixAct5ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct5ButA = ~cntMixAct5ButA + 1;
				~cntMixAct5ButA.switch(
					1,{this.act5ButA(1);},
					2,{this.act5ButA(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~recBut5);
		//Act5 ButB Keys
		~cntMixAct5ButB=0;
		~mdMixAct5ButB.free;
		~mdMixAct5ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct5ButB = ~cntMixAct5ButB + 1;
				~cntMixAct5ButB.switch(
					1,{this.act5ButB(1);},
					2,{this.act5ButB(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~mtBut5);
		~mdMixFad5.free;
		~mdMixFad5=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			IFMopho.set1(\susM,val);
		},srcID:~mdMixInID, chan:~mdMixLn5, ccNum:30);
		~mdMixNob5A.free;
		~mdMixNob5A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~mdMixInID, chan:~mdMixLn5, ccNum:33);
		~mdMixNob5B.free;
		~mdMixNob5B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~mdMixInID, chan:~mdMixLn5, ccNum:32);
		~mdMixNob5C.free;
		~mdMixNob5C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('volClnMopho', val);
			~mdOut.control(1, 18, vel); //Cln Mopho Vol
		},srcID:~mdMixInID, chan:~mdMixLn5, ccNum:31);
		////////-------------------line6
		//Act6 ButA
		~cntMixAct6ButA=0;
		~mdMixAct6ButA.free;
		~mdMixAct6ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct6ButA = ~cntMixAct6ButA + 1;
				~cntMixAct6ButA.switch(
					0,{},
					1,{this.act6ButA(1);},
					2,{this.act6ButA(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~recBut6);
		//Act6 ButB
		~cntMixAct6ButB=0;
		~mdMixAct6ButB.free;
		~mdMixAct6ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct6ButB = ~cntMixAct6ButB + 1;
				~cntMixAct6ButB.switch(
					0,{},
					1,{this.act6ButB(1);},
					2,{this.act6ButB(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~mtBut6);
		~mdMixFad6.free;
		~mdMixFad6=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			IFKeys.set1(\susM,val);

		},srcID:~mdMixInID, chan:~mdMixLn6, ccNum:30);
		~mdMixNob6A.free;
		~mdMixNob6A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~mdMixInID, chan:~mdMixLn6, ccNum:33);
		~mdMixNob6B.free;
		~mdMixNob6B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~mdMixInID, chan:~mdMixLn6, ccNum:32);
		~mdMixNob6C.free;
		~mdMixNob6C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('volClnKeys', val);
			~mdOut.control(1, 19, vel); //Cln Keys Vol
		},srcID:~mdMixInID, chan:~mdMixLn6, ccNum:31);
		//Act7 ButA
		~cntMixAct7ButA=0;
		~mdMixAct7ButA.free;
		~mdMixAct7ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct7ButA = ~cntMixAct7ButA + 1;
				~cntMixAct7ButA.switch(
					1,{this.act7ButA(1);},
					2,{this.act7ButA(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~recBut7);
		//Act7 ButB Keys
		~cntMixAct7ButB=0;
		~mdMixAct7ButB.free;
		~mdMixAct7ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixAct7ButB = ~cntMixAct7ButB + 1;
				~cntMixAct7ButB.switch(
					1,{this.act7ButB(1);},
					2,{this.act7ButB(0);}
				)});
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~mtBut7);
		~mdMixFad7.free;
		~mdMixFad7=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('susMulSamp', val);
			~susMulSamp=(val)+0.05;

		},srcID:~mdMixInID, chan:~mdMixLn7, ccNum:30);
		~mdMixNob7A.free;
		~mdMixNob7A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~mdMixInID, chan:~mdMixLn7, ccNum:33);
		~mdMixNob7B.free;
		~mdMixNob7B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~mdMixInID, chan:~mdMixLn7, ccNum:32);
		~mdMixNob7C.free;
		~mdMixNob7C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('volClnSamp', val);
			~mdOut.control(1, 17, vel); //Cln Samp Vol
		},srcID:~mdMixInID, chan:~mdMixLn7, ccNum:31);

		//Act8
		~mdMixFad8.free;
		~mdMixFad8=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~mdMixInID, chan:~mdMixLn8, ccNum:30);
		~mdMixNob8A.free;
		~mdMixNob8A=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~mdMixInID, chan:~mdMixLn8, ccNum:33);
		~mdMixNob8B.free;
		~mdMixNob8B=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~mdMixInID, chan:~mdMixLn8, ccNum:32);
		~mdMixNob8C.free;
		~mdMixNob8C=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;

		},srcID:~mdMixInID, chan:~mdMixLn7, ccNum:31);
		/////
		/////
		//--------------------line--MASTER
		~mdMixFadFXMaster.free;
		~mdMixFadFXMaster=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			IFSends.set1(\vol1,val);
		},srcID:~mdMixInID, chan:~mdMixLnMaster, ccNum:30);

		/*~cntMixActBankButA=0;
		~mdMixAct1ButA.free;
		~mdMixAct1ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixActBankButA = ~cntMixActBankButA + 1;
				~cntMixActBankButA.switch(
					0,{},
					1, {
						this.actBankButA(1);
					},
					2,{
						this.actBankButA(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~bankRight);
		//Act1 ButB
		~cntMixActBankButB=0;
		~mdMixAct1ButB.free;
		~mdMixAct1ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMixActBankButB = ~cntMixActBankButB + 1;
				~cntMixActBankButB.switch(
					0,{},
					1, {
						this.actBankButB(1);
					},
					2,{
						this.actBankButB(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~mtBut1);*/





	}

	*tsLed{|chan,led|
		~mdMix.noteOn(0, 51, led);
	}
	*tsLeds{|led1,led2,led3,led4,led5,led6,led7,led8|
		~mdMix.noteOn(~mdMixLn1, ~recBut1, led1); //But 1
		~mdMix.noteOn(~mdMixLn1, ~recBut2, led2); //But 2
		~mdMix.noteOn(~mdMixLn1, ~recBut3, led3); //But 3
		~mdMix.noteOn(~mdMixLn1, ~recBut4, led4); //But 4
		~mdMix.noteOn(~mdMixLn1, ~recBut5, led5); //But 5
		~mdMix.noteOn(~mdMixLn1, ~recBut6, led6); //But 6
		~mdMix.noteOn(~mdMixLn1, ~recBut7, led7); //But 7
		~mdMix.noteOn(~mdMixLn1, ~recBut8, led8); //But 8
	}

	/*
	IFMIDIMix.ndButLeds(1,0,0,0,0,0,0,0);
	IFMIDIMix.nobDown(mode:2);
	*/
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
	/**ln6{//kick
		~volKick_APC.free;
		~volKick_APC=MIDIFunc.cc( {
			arg vel,val;
			val=vel/127;
			~tOSCAdrr.sendMsg('volKick', vel/127);
			~mdOut.control(2, 1, vel);

		},srcID:~mdMixInID, chan:0, ccNum:30);

		//Act ButA
		//Kick Activate
		~cntMdMixLine1ButA=0;
		~mdMixLine1ButA.free;
		~mdMixLine1ButA=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMdMixLine1ButA = ~cntMdMixLine1ButA + 1;
				~cntMdMixLine1ButA.switch(
					0,{},
					1, {
						IFMIDIMix.actLine1ButA(1);
					},
					2,{
						IFMIDIMix.actLine1ButA(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:0, noteNum:~recBut1);

		//Act ButB
		//Kick Time Div2
		~cntMdMixLine1ButB=0;
		~mdMixLine1ButB.free;
		~mdMixLine1ButB=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMdMixLine1ButB = ~cntMdMixLine1ButB + 1;
				~cntMdMixLine1ButB.switch(
					0,{},
					1, {
						IFMIDIMix.actLine1ButB(1);
					},
					2,{
						IFMIDIMix.actLine1ButB(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:0, noteNum:~actButB);

		//Act ButC
		//Static Kick Activate
		~cntMdMixLine1ButC=0;
		~mdMixLine1ButC.free;
		~mdMixLine1ButC=MIDIFunc.noteOn({
			arg vel,val;
			val=vel/127;
			if ( vel==127, {
				~cntMdMixLine1ButC = ~cntMdMixLine1ButC + 1;
				~cntMdMixLine1ButC.switch(
					0,{},
					1, {
						IFMIDIMix.actLine1ButC(1);
					},
					2,{
						IFMIDIMix.actLine1ButC(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixLn1, noteNum:~actButC);


	}*/
	//*apc40
}



/*
~mdMix.uid;
~mdMix.noteOn(0, 3, 0); //But 1
~mdMix.noteOn(~mdMixGlobChan, ~recBut1, 1); //But A

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



