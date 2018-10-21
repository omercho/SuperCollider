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
		~tOSCAdrr.sendMsg('actVKick', val);
		~actVKick.source=val;
		~cntMixActBankButA=val;
	}
	*actBankButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~bankLeft, val); //But B
		~tOSCAdrr.sendMsg('actVKick2', val);
		~actVKick2.source=val;
		~cntMixActBankButB=val;
	}//actBank

	//actLine1
	*act1ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut1, val); //But A
		//~tOSCAdrr.sendMsg('activVKick', val);
		//~actVKick.source=val;
		~cntMixAct1ButA=val;
	}

	//actLine2
	*act2ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut2, val); //But A
		~tOSCAdrr.sendMsg('activVSnr', val);
		~actVSnr.source=val;
		~cntMixAct2ButA=val;
	}
	//actLine3
	*act3ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut3, val); //But A
		~tOSCAdrr.sendMsg('activVHat', val);
		~actVHat.source=val;
		~cntMixAct3ButA=val;
	}
	//actLine4
	*act4ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut4, val); //But A
		~tOSCAdrr.sendMsg('activVClap', val);
		~actVClap.source=val;
		~cntMixAct4ButA=val;
	}

	//actLine5 -- VSamp01
	*act5ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut5, val); //But A
		~tOSCAdrr.sendMsg('act5VSamp', val);
		~act5VSamp.source=val;
		~cntMixAct5ButA=val;
	}

	//actLine6 --Kick Abl
	*act6ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut6, val); //But A
		~tOSCAdrr.sendMsg('activStSamp', val);
		~actStSamp.source=val;
		~cntMixAct6ButA=val;
	}

	//actLine7 -- Mast
	*act7ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut7, val); //But A
		~tOSCAdrr.sendMsg('activStMast', val);
		//~actStHat.source=val;
		~cntMixAct7ButA=val;
	}

	//actLine8 -- Res1
	*act8ButA{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~recBut8, val); //But A
		~tOSCAdrr.sendMsg('activStRes', val);
		//~actStHat.source=val;
		~cntMixAct8ButA=val;
	}
	////////////////
	//////////////////B_B
	////////////////
	*act1ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut1, val); //But B
		~tOSCAdrr.sendMsg('activVTomL', val);
		~actVTomL.source=val;
		~cntMixAct1ButB=val;
	}
	*act2ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut2, val); //But B
		~tOSCAdrr.sendMsg('activVTomH', val);
		~actVTomH.source=val;
		~cntMixAct2ButB=val;
	}
	*act3ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut3, val); //But B
		~tOSCAdrr.sendMsg('activVCrash', val);
		~actVCrsh.source=val;
		~cntMixAct3ButB=val;
	}
	*act4ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut4, val); //But B
		~tOSCAdrr.sendMsg('activVPcm', val);
		~actVPcm.source=val;
		~cntMixAct4ButB=val;
	}
	*act5ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut5, val); //But B
		~local.sendMsg('time2VSamp', val);
		//~tmMulKeys.source = Pseq([val+1], inf);
		~cntMixAct5ButB=val;
	}
	*act6ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut6, val); //But B
		~local.sendMsg('time2Samp', val);
		//~tmMulSamp.source = Pseq([val+1], inf);
		~cntMixAct6ButB=val;
	}
	*act7ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut7, val); //But B
		~tOSCAdrr.sendMsg('time2Mast', val);
		~tmMulMast.source = Pseq([val+1], inf);
		~cntMixAct7ButB=val;
	}
	*act8ButB{|val|
		~mdMix.noteOn(~mdMixGlobChan, ~mtBut8, val); //But B
		~tOSCAdrr.sendMsg('time2Res', val);
		~tmMulRes.source = Pseq([val+1], inf);
		~cntMixAct8ButB=val;
	}

	/////////B_C
	*act1ButC{|val|
		~cntMixAct1ButC=val;
	}
	*act2ButC{|val|

		~cntMixAct2ButC=val;
	}
	*act3ButC{|val|

		~cntMixAct3ButC=val;
	}
	*act4ButC{|val|

		~cntMixAct4ButC=val;
	}
	*act5ButC{|val|

		~cntMixAct5ButC=val;
	}
	*act6ButC{|val|

		~cntMixAct6ButC=val;
	}
	*act7ButC{|val|

		~cntMixAct7ButC=val;
	}
	*act8ButC{|val|

		~cntMixAct8ButC=val;
	}


	*loadResponders{
		//--------------------line1
		//Act1 ButA
		~cntMixAct1ButA=0;
		~mdMixAct1ButA.free;
		~mdMixAct1ButA=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMixAct1ButA = ~cntMixAct1ButA + 1;
				~cntMixAct1ButA.switch(
					0,{},
					1, {
						this.act1ButA(1);
					},
					2,{
						this.act1ButA(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~recBut1);
		//Act1 ButB
		~cntMixAct1ButB=0;
		~mdMixAct1ButB.free;
		~mdMixAct1ButB=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMixAct1ButB = ~cntMixAct1ButB + 1;
				~cntMixAct1ButB.switch(
					0,{},
					1, {
						this.act1ButB(1);
					},
					2,{
						this.act1ButB(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~mtBut1);

		~mdMixFad1.free;
		~mdMixFad1=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('susMulKick', vel/127);
			~susMulKick=(vel/127)+0.05;

		},srcID:~mdMixInID, chan:~mdMixLn1, ccNum:30);
		~mdMixNob1A.free;
		~mdMixNob1A=MIDIFunc.cc( {
			arg vel;

		},srcID:~mdMixInID, chan:~mdMixLn1, ccNum:33);
		~mdMixNob1B.free;
		~mdMixNob1B=MIDIFunc.cc( {
			arg vel;


		},srcID:~mdMixInID, chan:~mdMixLn1, ccNum:32);
		~mdMixNob1C.free;
		~mdMixNob1C=MIDIFunc.cc( {
			arg vel;
			~mdOut.control(1, 15, vel);//Cln Drm Vol
		},srcID:~mdMixInID, chan:~mdMixGlobChan, ccNum:31);

		//--------------------line2
		//Act2 ButA
		~cntMixAct2ButA=0;
		~mdMixAct2ButA.free;
		~mdMixAct2ButA=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMixAct2ButA = ~cntMixAct2ButA + 1;
				~cntMixAct2ButA.switch(
					0,{},
					1, {
						this.act2ButA(1);
					},
					2,{
						this.act2ButA(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~recBut2);
		//Act2 ButB
		~cntMixAct2ButB=0;
		~mdMixAct2ButB.free;
		~mdMixAct2ButB=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMixAct2ButB = ~cntMixAct2ButB + 1;
				~cntMixAct2ButB.switch(
					0,{},
					1, {
						this.act2ButB(1);
					},
					2,{
						this.act2ButB(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~mtBut2);

		~mdMixFad2.free;
		~mdMixFad2=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('susMulSnr', vel/127);
			~susMulSnr=(vel/127)+0.05;
			//~tOSCAdrr.sendMsg('volSnr2', vel/127);
			//~volSnr2.source = vel/127;

		},srcID:~mdMixInID, chan:~mdMixLn2, ccNum:30);
		//Nobs
		~mdMixNob2A.free;
		~mdMixNob2A=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volVTomH', vel/127);

		},srcID:~mdMixInID, chan:~mdMixLn2, ccNum:33);
		~mdMixNob2B.free;
		~mdMixNob2B=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volVTomL', vel/127);

		},srcID:~mdMixInID, chan:~mdMixLn2, ccNum:32);
		~mdMixNob2C.free;
		~mdMixNob2C=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('stutDepth', vel/127);

		},srcID:~mdMixInID, chan:~mdMixLn2, ccNum:31);

		//--------------------line3
		//Act3 ButA
		~cntMixAct3ButA=0;
		~mdMixAct3ButA.free;
		~mdMixAct3ButA=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMixAct3ButA = ~cntMixAct3ButA + 1;
				~cntMixAct3ButA.switch(
					0,{},
					1, {
						this.act3ButA(1);
					},
					2,{
						this.act3ButA(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~recBut3);
		//Act3 ButB
		~cntMixAct3ButB=0;
		~mdMixAct3ButB.free;
		~mdMixAct3ButB=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMixAct3ButB = ~cntMixAct3ButB + 1;
				~cntMixAct3ButB.switch(
					0,{},
					1, {
						this.act3ButB(1);
					},
					2,{
						this.act3ButB(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~mtBut3);

		~mdMixFad3.free;
		~mdMixFad3=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('susMulHat', vel/127);
			~susMulHat=(vel/127)+0.05;

		},srcID:~mdMixInID, chan:~mdMixLn3, ccNum:30);
		~mdMixNob3A.free;
		~mdMixNob3A=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volVCrsh', vel/127);

		},srcID:~mdMixInID, chan:~mdMixGlobChan, ccNum:33);
		~mdMixNob3B.free;
		~mdMixNob3B=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('decVHatC', vel/127);

		},srcID:~mdMixInID, chan:~mdMixGlobChan, ccNum:32);
		~mdMixNob3C.free;
		~mdMixNob3C=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('grainVHat', vel/127);

		},srcID:~mdMixInID, chan:~mdMixGlobChan, ccNum:31);

		//Act4 ButA
		~cntMixAct4ButA=0;
		~mdMixAct4ButA.free;
		~mdMixAct4ButA=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMixAct4ButA = ~cntMixAct4ButA + 1;
				~cntMixAct4ButA.switch(
					0,{},
					1, {
						this.act4ButA(1);
					},
					2,{
						this.act4ButA(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~recBut4);
		//Act4 ButB
		~cntMixAct4ButB=0;
		~mdMixAct4ButB.free;
		~mdMixAct4ButB=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMixAct4ButB = ~cntMixAct4ButB + 1;
				~cntMixAct4ButB.switch(
					0,{},
					1, {
						this.act4ButB(1);
					},
					2,{
						this.act4ButB(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~mtBut4);

		~mdMixFad4.free;
		~mdMixFad4=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('susMulBass', vel/127);
			~susMulBass=(vel/127)+0.05;

		},srcID:~mdMixInID, chan:~mdMixLn4, ccNum:30);
		~mdMixNob4A.free;
		~mdMixNob4A=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volVPcm', vel/127);

		},srcID:~mdMixInID, chan:~mdMixLn4, ccNum:33);
		~mdMixNob4B.free;
		~mdMixNob4B=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('speedPcm', vel/127);

		},srcID:~mdMixInID, chan:~mdMixLn4, ccNum:32);
		~mdMixNob4C.free;
		~mdMixNob4C=MIDIFunc.cc( {
			arg vel;
			//~tOSCAdrr.sendMsg('speedClap', vel/127);

		},srcID:~mdMixInID, chan:~mdMixLn4, ccNum:31);
		/////
		//Act5 ButA
		~cntMixAct5ButA=0;
		~mdMixAct5ButA.free;
		~mdMixAct5ButA=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMixAct5ButA = ~cntMixAct5ButA + 1;
				~cntMixAct5ButA.switch(
					0,{},
					1, {
						this.act5ButA(1);
					},
					2,{
						this.act5ButA(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~recBut5);
		//Act5 ButB Keys
		~cntMixAct5ButB=0;
		~mdMixAct5ButB.free;
		~mdMixAct5ButB=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMixAct5ButB = ~cntMixAct5ButB + 1;
				~cntMixAct5ButB.switch(
					0,{},
					1, {
						this.act5ButB(1);
					},
					2,{
						this.act5ButB(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~mtBut5);

		~mdMixFad5.free;
		~mdMixFad5=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('susMulKeys', vel/127);
			~susMulKeys=(vel/127)+0.05;

		},srcID:~mdMixInID, chan:~mdMixLn5, ccNum:30);
		~mdMixNob5A.free;
		~mdMixNob5A=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volVPcm', vel/127);

		},srcID:~mdMixInID, chan:~mdMixLn5, ccNum:33);
		~mdMixNob5B.free;
		~mdMixNob5B=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('speedPcm', vel/127);

		},srcID:~mdMixInID, chan:~mdMixLn5, ccNum:32);
		~mdMixNob5C.free;
		~mdMixNob5C=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volClnKeys', vel/127);
			~mdOut.control(1, 16, vel); //Cln Keys Vol

		},srcID:~mdMixInID, chan:~mdMixLn5, ccNum:31);
		//////
		//Act6
		~mdMixFad6.free;
		~mdMixFad6=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('susMulSamp', vel/127);
			~susMulSamp=(vel/127)+0.05;

		},srcID:~mdMixInID, chan:~mdMixLn6, ccNum:30);
		~mdMixNob6C.free;
		~mdMixNob6C=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volClnSamp', vel/127);
			~mdOut.control(1, 17, vel); //Cln Mopho Vol
		},srcID:~mdMixInID, chan:~mdMixLn6, ccNum:31);

		//Act7
		~mdMixFad7.free;
		~mdMixFad7=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('susMulMopho', vel/127);
			~susMulMopho=(vel/127)+0.05;

		},srcID:~mdMixInID, chan:~mdMixLn7, ccNum:30);
		~mdMixNob7C.free;
		~mdMixNob7C=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volClnMopho', vel/127);
			~mdOut.control(1, 18, vel); //Cln Mopho Vol
		},srcID:~mdMixInID, chan:~mdMixLn7, ccNum:31);

		//Act8
		~mdMixFad8.free;
		~mdMixFad8=MIDIFunc.cc( {
			arg vel;

		},srcID:~mdMixInID, chan:~mdMixLn8, ccNum:30);
		/////
		/////


		//--------------------line--MASTER
		~mdMixFadFXMaster.free;
		~mdMixFadFXMaster=MIDIFunc.cc( {
			arg vel;
			~mdOut.control(1, 127, vel); //AllMasterFX / Track Vol
		},srcID:~mdMixInID, chan:~mdMixLnMaster, ccNum:30);

		/*~cntMixActBankButA=0;
		~mdMixAct1ButA.free;
		~mdMixAct1ButA=MIDIFunc.noteOn({
			arg vel;
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
			arg vel;
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
			arg vel;
			~tOSCAdrr.sendMsg('volKick', vel/127);
			~mdOut.control(2, 1, vel);

		},srcID:~mdMixInID, chan:0, ccNum:30);

		//Act ButA
		//Kick Activate
		~cntMdMixLine1ButA=0;
		~mdMixLine1ButA.free;
		~mdMixLine1ButA=MIDIFunc.noteOn({
			arg vel;
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
			arg vel;
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
			arg vel;
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



