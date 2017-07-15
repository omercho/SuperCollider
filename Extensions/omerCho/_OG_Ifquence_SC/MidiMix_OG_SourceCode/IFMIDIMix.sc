/*
PostAllMIDI.on;
PostAllMIDI.off;

*/

IFMIDIMix{
	*load{

		~mdMix = MIDIOut.newByName("MIDI Mix", "MIDI Mix");
		~mdMixOutID=(-1217358296);
		~mdMixInID=1556204285;
		this.globals;
		this.resetLeds;
		this.ln6;


	}//loadAtStart
	*globals{
		//channels
		~mdMixLn1=0;
		~mdMixLn2=1;
		~mdMixLn3=2;
		~mdMixLn4=3;
		~mdMixLn5=4;
		~mdMixLn6=5;
		~mdMixLn7=6;
		~mdMixLn8=7;
		~mdMixLnMaster=9;
		//Nums
		~mtBut1=1;~mtBut2=4;~mtBut3=7;~mtBut4=10;
		~mtBut5=13;~mtBut6=16;~mtBut7=19;~mtBut8=22;
		~slBut1=2;~slBut2=5;~slBut3=8;~slBut4=11;
		~slBut5=14;~slBut6=17;~slBut7=20;~slBut8=23;
		~recBut1=3;~recBut2=6;~recBut3=9;~recBut4=12;
		~recBut5=15;~recBut6=18;~recBut7=21;~recBut8=24;

		~actButA=48;~actButB=49;~actButC=50;

	}//globals

	//actLine1
	*actLine1{|val1,val2,val3|
		this.actLine1ButA(val1);
		this.actLine1ButB(val2);
		this.actLine1ButC(val3);
	}
	*actLine1ButA{|val|
		~apc40.noteOn(~apcLn1, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activKick', val);
		~actKick.source=val;
		~cntMdMixLine1ButA=val;
	}

	//actLine2
	*actLine2{|val1,val2,val3|
		this.actLine2ButA(val1);
		this.actLine2ButB(val2);
		this.actLine2ButC(val3);
	}
	*actLine2ButA{|val|
		~apc40.noteOn(~apcLn2, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activSnr', val);
		~actSnr.source=val;
		~cntActLine2ButA=val;
	}


	//actLine3
	*actLine3{|val1,val2,val3|
		this.actLine3ButA(val1);
		this.actLine3ButB(val2);
		this.actLine3ButC(val3);
	}
	*actLine3ButA{|val|
		~apc40.noteOn(~apcLn3, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activHat', val);
		~actHat.source=val;
		~cntActLine3ButA=val;
	}

	//actLine4
	*actLine4{|val1,val2,val3|
		this.actLine4ButA(val1);
		this.actLine4ButB(val2);
		this.actLine4ButC(val3);
	}
	*actLine4ButA{|val|
		~apc40.noteOn(~apcLn4, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activBass', val);
		~actBass.source=val;
		~cntActLine4ButA=val;
	}

	//actLine5 -- Keys
	*actLine5{|val1,val2,val3|
		this.actLine5ButA(val1);
		this.actLine5ButB(val2);
		this.actLine5ButC(val3);
	}
	*actLine5ButA{|val|
		~apc40.noteOn(~apcLn5, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activKeys', val);
		~actKeys.source=val;
		~cntActLine5ButA=val;
	}

	//actLine6 --Kick Abl
	*actLine6{|val1,val2,val3|
		this.actLine6ButA(val1);
		this.actLine6ButB(val2);
		this.actLine6ButC(val3);
	}
	*actLine6ButA{|val|
		~apc40.noteOn(~apcLn6, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activSamp', val);
		~actSamp.source=val;
		~cntActLine6ButA=val;
	}

	//actLine7 -- Mast
	*actLine7{|val1,val2,val3|
		this.actLine7ButA(val1);
		this.actLine7ButB(val2);
		this.actLine7ButC(val3);
	}
	*actLine7ButA{|val|
		~apc40.noteOn(~apcLn7, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activMast', val);
		~actMast.source=val;
		~cntActLine7ButA=val;
	}

	//actLine8 -- Res1
	*actLine8{|val1,val2,val3|
		this.actLine8ButA(val1);
		this.actLine8ButB(val2);
		this.actLine8ButC(val3);
	}
	*actLine8ButA{|val|
		~apc40.noteOn(~apcLn8, ~actButA, val); //But A
		~tOSCAdrr.sendMsg('activRes', val);
		~actRes.source=val;
		~cntActLine8ButA=val;
	}

	//////////////////B_B
	*actLine1ButB{|val|
		~apc40.noteOn(~apcLn1, ~actButB, val); //But B
		~local.sendMsg('time2Kick', 1);
		//~tmMulKick.source = Pseq([val+1], inf);
		~cntMdMixLine1ButB=val;
	}
	*actLine2ButB{|val|
		~apc40.noteOn(~apcLn2, ~actButB, val); //But B
		~local.sendMsg('time2Snr', val);
		//~tmMulSnr.source = Pseq([val+1], inf);
		~cntActLine2ButB=val;
	}
	*actLine3ButB{|val|
		~apc40.noteOn(~apcLn3, ~actButB, val); //But B
		~local.sendMsg('time2Hat', val);
		//~tmMulHat.source = Pseq([val+1], inf);
		~cntActLine3ButB=val;
	}
	*actLine4ButB{|val|
		~apc40.noteOn(~apcLn4, ~actButB, val); //But B
		~local.sendMsg('time2Bass', val);
		//~tmMulBass.source = Pseq([val+1], inf);
		~cntActLine4ButB=val;
	}
	*actLine5ButB{|val|
		~apc40.noteOn(~apcLn5, ~actButB, val); //But B
		~local.sendMsg('time2Keys', val);
		//~tmMulKeys.source = Pseq([val+1], inf);
		~cntActLine5ButB=val;
	}
	*actLine6ButB{|val|
		~apc40.noteOn(~apcLn6, ~actButB, val); //But B
		~local.sendMsg('time2Samp', val);
		//~tmMulSamp.source = Pseq([val+1], inf);
		~cntActLine6ButB=val;
	}
	*actLine7ButB{|val|
		~apc40.noteOn(~apcLn7, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Mast', val);
		~tmMulMast.source = Pseq([val+1], inf);
		~cntActLine7ButB=val;
	}
	*actLine8ButB{|val|
		~apc40.noteOn(~apcLn8, ~actButB, val); //But B
		~tOSCAdrr.sendMsg('time2Res', val);
		~tmMulRes.source = Pseq([val+1], inf);
		~cntActLine8ButB=val;
	}

	/////////B_C
	*actLine1ButC{|val|
		~apc40.noteOn(~apcLn1, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStKick', val);
		~actStKick.source=val;
		~cntMdMixLine1ButC=val;
	}
	*actLine2ButC{|val|
		~apc40.noteOn(~apcLn2, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStSnr', val);
		~actStSnr.source=val;
		~cntActLine2ButC=val;
	}
	*actLine3ButC{|val|
		~apc40.noteOn(~apcLn3, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStHat', val);
		~actStHat.source=val;
		~cntActLine3ButC=val;
	}
	*actLine4ButC{|val|
		~apc40.noteOn(~apcLn4, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStBass', val);
		~actStBass.source=val;
		~cntActLine4ButC=val;
	}
	*actLine5ButC{|val|
		~apc40.noteOn(~apcLn5, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStKeys', val);
		~actStKeys.source=val;
		~cntActLine5ButC=val;
	}
	*actLine6ButC{|val|
		~apc40.noteOn(~apcLn6, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStSamp', val);
		~actStSamp.source=val;
		~cntActLine6ButC=val;
	}
	*actLine7ButC{|val|
		~apc40.noteOn(~apcLn7, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStMast', val);
		//~actStHat.source=val;
		~cntActLine7ButC=val;
	}
	*actLine8ButC{|val|
		~apc40.noteOn(~apcLn8, ~actButC, val); //But C
		~tOSCAdrr.sendMsg('activStRes', val);
		//~actStHat.source=val;
		~cntActLine8ButC=val;
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
		~mdMix.noteOn(~mdMixLn1, 24, 1); //But 3

	}
	*ln6{//kick
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
		},srcID:~apc40InID, chan:~apcLn1, noteNum:~actButC);


	}//*apc40
}



/*
~mdMix.uid;
~mdMix.noteOn(0, 3, 1); //But 1

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



