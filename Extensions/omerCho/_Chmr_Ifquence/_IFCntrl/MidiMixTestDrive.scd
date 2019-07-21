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
		~mtBut1=1;~mtBut1=4;~mtBut1=7;~mtBut1=10;
		~mtBut1=13;~mtBut1=16;~mtBut1=19;~mtBut1=22;
		~slBut1=2;~slBut1=5;~slBut1=8;~slBut1=11;
		~slBut1=14;~slBut1=17;~slBut1=20;~slBut1=23;
		~recBut1=3;~recBut2=6;~recBut3=9;~recBut4=12;
		~recBut5=15;~recBut6=18;~recBut7=21;~recBut8=24;

		~actButA=48;~actButB=49;~actButC=50;

	}//globals

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
	IFAPC40.ndButLeds(1,0,0,0,0,0,0,0);
	IFAPC40.nobDown(mode:2);
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



