/*
//MOPHO SEND NRPN
//NRPN control of filter pole on DSI Tetra:

//   first, set parameter number (24 in this case)

//   set most significant byte for parameter number (0 in this case)
~vMopho.control(0, 99, 0);

//   then least significant byte for parameter number (24 in this case)
~vMopho.control(0, 98, 24);

// then set value (1 for 4 pole)


//   first set most significant byte for this value (0 in this case)
~vMopho.control(0, 6, 0);
//   then least significant byte for parameter number (1 in this case)
Mopho.control(1, 0, 0, 0, 36);// osc1 freq
Mopho.control(1, 0, 1, 0, 39);// osc1 tune
Mopho.control(1, 0, 2, 0, 59);// osc1 shape
Mopho.control(1, 0, 3, 0, 10);// osc1 Glide
Mopho.control(1, 0, 4, 0, 1);// osc1 Keybord OnOff
Mopho.control(1, 0, 114, 0, 96);// osc1 Sub level

Mopho.control(1, 0, 5, 0, 36);// osc2 freq
Mopho.control(1, 0, 6, 0, 39);// osc2 tune
Mopho.control(1, 0, 7, 0, 50);// osc2 shape
Mopho.control(1, 0, 8, 0, 120);// osc2 Glide
Mopho.control(1, 0, 9, 0, 1);// osc2 Keybord OnOff 0->1
Mopho.control(1, 0, 115, 0, 0);// osc2 Sub level 0->127

Mopho.control(1, 0, 11, 0, 1);// Glide Mode 0->3
0 fixedRate -
1 fixRtAuto -
2 fixedTime -
3 fixTmAuto

Mopho.control(1, 0, 96, 0, 5);// Key Assing Mode 0->5
0=Low note priority
1=Low note priority with re-trigger
2=High note priority
3=High note priority with re-trigger
4=Last note priority
5=Last note priority with re-trigger

Mopho.control(1, 0, 10, 0, 0); //0->1    Sync osc2->osc1 OnOff
Mopho.control(1, 0, 93, 0, 12);//0->12   Pitch Bend Range
Mopho.control(1, 0, 13, 0, 1); //0->127  Osc Mix
Mopho.control(1, 0, 14, 0, 0); //0->127  Noise Lvl
Mopho.control(1, 0, 116, 0, 0);//0->127  Ext AudioIn
Mopho.control(1, 0, 15, 0, 38);//0->164  Filter Frequency, steps in semitones
Mopho.control(1, 0, 16, 0, 28);//0->127  Filter Resonance
Mopho.control(1, 0, 17, 0, 28);//0->127  Filter Keyboard Amount
Mopho.control(1, 0, 18, 0, 28);//0->127  Filter Audio Modulation
Mopho.control(1, 0, 19, 0, 1); //0->1    Filter Poles 0=2pole 1=4pole
Mopho.control(1, 0, 20, 1, 45);//0->254  Filter Envelope Amount -127 to +127
Mopho.control(1, 0, 21, 0, 120);//0->127  Filter Envelope Velocity Amount
Mopho.control(1, 0, 22, 0, 120);//0->127  Filter Envelope Delay
Mopho.control(1, 0, 23, 0, 120);//0->127  Filter Envelope Att
Mopho.control(1, 0, 24, 0, 120);//0->127  Filter Envelope Decay
Mopho.control(1, 0, 25, 0, 120);//0->127  Filter Envelope Sustain
Mopho.control(1, 0, 26, 0, 120);//0->127  Filter Envelope Release

Mopho.control(1, 0, 27, 0, 0);//0->127  VCA Initial Level
Mopho.vcaLvl(0);
Mopho.control(1, 0, 30, 0, 120);//0->127  VCA Envelope Amount
Mopho.control(1, 0, 31, 0, 120);//0->127  VCA Envelope Velocity Amount
Mopho.control(1, 0, 32, 0, 120);//0->127  VCA Envelope Delay
Mopho.control(1, 0, 33, 0, 120);//0->127  VCA Envelope Att
Mopho.control(1, 0, 34, 0, 120);//0->127  VCA Envelope Decay
Mopho.control(1, 0, 35, 0, 120);//0->127  VCA Envelope Sustain
Mopho.control(1, 0, 36, 0, 78);//0->127  VCA Envelope Release
Mopho.control(1, 0, 29, 0, 127);//0->127  Voice Volume

/*
Mopho.control(1, 0, 39, 0, 34);//0->127  LFO1 Amount
Mopho.control(1, 0, 37, 0, 127);//0->166  LFO1 Freq // 0-150 unsynced freqs
Mopho.control(1, 0, 37, 1, 38);//0->166  LFO1 Freq // 151-166 synced freqs
val23 = 151- div/32
val24 = 152- /16
val25 = 153- /8
val26 = 154- /6
val27 = 155- /4
val28 = 156- /3
val29 = 157- /2
val30 = 158- /1.5
val31 = 159- 1 cycle per 1 step
val32 = 160- 2 cycle per 3 step
val33 = 161- 2 cycle per 1 step
val34 = 162- 3 cycle per 1 step
val35 = 163- 4 cycle per 1 step
val36 = 164- 6 cycle per 1 step
val37 = 165- 8 cycle per 1 step
val38 = 166- 16 cycle per 1 step
Mopho.control(1, 0, 38, 0, 3);//0->4  LFO1 Shape 0 Triangle - 1 RevSawtooth - 2 Sawtooth - 3 Sqr - 4 Rand
*/

*/

Mopho{
	*control{|chan,param1,nrpn,param2,val|
		~vMopho.control(chan, 99, param1);// first, set parameter number
		~vMopho.control(chan, 98, nrpn);//   most significant byte for parameter number
		~vMopho.control(chan, 6, param2);//  least significant byte for parameter number
		~vMopho.control(chan,38, val);//     then set value
	}
	//GLOBAL PARAMETER NRPN
	*masterTranspose{|val|
		//0-24 -- 0=-12 -- 12=0 -- 24=+12
		this.control(~chMopho, 0,384,0, val);
	}
	*masterTune{|val|
		//0-100 -- 0=-50 -- 50=0 -- 100=+50
		this.control(~chMopho, 3,1,0, val);
	}
	*midiClock{|val|
		/*0-3
		-- 0= InternalClock - Don't Send MIDIClock
		-- 1= InternalClock - Send MIDIClock
		-- 2= MIDIClock In
		-- 3=  MIDIClock In - Retransmint MIDI Clock Out
		*/
		this.control(~chMopho, 3,4,0, val);
	}
	*parameterSend{|val|
		/*0-2
		-- 0= NRPN
		-- 1= CC
		-- 2= Off
		*/
		this.control(~chMopho, 3,6,0, val);
	}
	*parameterReceive{|val|
		/*0-3
		-- 0= All
		-- 1= NRPN
		-- 2= CC
		-- 3= Off
		*/
		this.control(~chMopho, 3,7,0, val);
	}
	*controllerSendReceive{|val|
		/*0-1 Off On
		*/
		this.control(~chMopho, 3,10,0, val);
	}
	*sysexSendReceive{|val|
		/*0-1 Off On
		*/
		this.control(~chMopho, 3,11,0, val);
	}
	*audioOut{|val|
		/*0-2
		-- 0= Stereo
		-- 1= Mono
		*/
		this.control(~chMopho, 3,21,0, val);
	}
	*midiOut{|val|
		/*0-2
		-- 0= Out
		-- 1= Thru
		*/
		this.control(~chMopho, 3,22,0, val);
	}
	*osc1Freq{|val|
		/*0-120 in semitones
		10 octave range
		*/
		this.control(~chMopho, 3,22,0, val);
	}
	/*
	Mopho.masterTranspose(12);
	Mopho.masterTune(1);
	Mopho.midiClock(0);
	Mopho.parameterSend(1);
	Mopho.parameterReceive(0);
	Mopho.controllerSendReceive(1);
	Mopho.sysexSendReceive(1);
	Mopho.audioOut(0);
	Mopho.midiOut(1);
	*/
	*vcaLvl{|val|
		//0->127  VCA Initial Level
		this.control(~chMopho, 0,27,0, val);
	}
	*voiVol{|val|
		//0->127  VCA Initial Level
		this.control(~chMopho, 0,29,0, val);
	}
	/*
	Mopho.vcaLvl(0);
	*/
}


/*
Mopho.control(15, 0,0, 0, 24); //Osc_1 Freq
~vMopho.noteOn(~chMopho, 26, 111); //But 1
~vMopho.noteOff(~chMopho, 26, 1); //But 1

~vMopho.control(15, 20, 49); //Osc_1 Freq
~vMopho.control(~chMopho, 21, 50); //Osc_1 Fine Tune
~vMopho.control(~chMopho, 22, 3); //Osc_1 Shape
~vMopho.control(~chMopho, 23, 43); //Osc_1 Glide

~vMopho.control(~chMopho, 24, 60); //Osc_2 Freq
~vMopho.control(~chMopho, 25, 57); //Osc_2 Fine Tune
~vMopho.control(~chMopho, 26, 58); //Osc_2 Shape
~vMopho.control(~chMopho, 27, 13); //Osc_2 Glide

~vMopho.control(~chMopho, 28, 64); //Osc Mix

~vMopho.control(~chMopho, 30, 0); //Sub Osc_1
~vMopho.control(~chMopho, 31, 120); //Sub Osc_2


~vMopho.control(~chMopho, 102, 110); //Filter Freq CutOff
~vMopho.control(~chMopho, 103, 17); //Filter Resonans
~vMopho.control(~chMopho, 104, 17); //Filter Key Amnt
~vMopho.control(~chMopho, 105, 7); //Filter Audio Mod
~vMopho.control(~chMopho, 106, 0); //Filter Env Amnt
~vMopho.control(~chMopho, 107, 127); //Filter Env Vel Amnt
~vMopho.control(~chMopho, 108, 0); //Filter Dly
~vMopho.control(~chMopho, 109, 1); //Filter Att
~vMopho.control(~chMopho, 110, 10); //Filter Dec
~vMopho.control(~chMopho, 111, 20); //Filter Sus
~vMopho.control(~chMopho, 112, 17); //Filter Rel

~vMopho.control(~chMopho, 113, 0); //VCA Lvl
~vMopho.control(~chMopho, 115, 127); //Amp Env Amnt
~vMopho.control(~chMopho, 116, 127); //Amp Env Vel Amnt
~vMopho.control(~chMopho, 117, 0); //Amp Dly
~vMopho.control(~chMopho, 118, 1); //Amp Att
~vMopho.control(~chMopho, 119, 37); //Amp Dec
~vMopho.control(~chMopho, 75, 45); //Amp Sus
~vMopho.control(~chMopho, 76, 10); //Amp Rel

~vMopho.control(~chMopho, 85, 7); //Env3 Dest
~vMopho.control(~chMopho, 86, 7); //Env3 Amnt
~vMopho.control(~chMopho, 87, 7); //Env3 Vel Amnt
~vMopho.control(~chMopho, 88, 7); //Env3 Dly
~vMopho.control(~chMopho, 89, 7); //Env3 Att
~vMopho.control(~chMopho, 90, 7); //Env3 Dec
~vMopho.control(~chMopho, 77, 7); //Env3 Sus
~vMopho.control(~chMopho, 78, 7); //Env3 Rel


~vMopho.control(~chMopho, 29, 0); //Noise Lev
~vMopho.control(~chMopho, 14, 64); //BPM
~vMopho.control(~chMopho, 15, 0); //Clock Divide

//MOPHO SEND NRPN
//NRPN control of filter pole on DSI Tetra:
//   first, set parameter number (24 in this case)
//   set most significant byte for parameter number (0 in this case)
~vMopho.control(~chMopho, 99, 0);
//   then least significant byte for parameter number (24 in this case)
~vMopho.control(~chMopho, 98, 24);
// then set value (1 for 4 pole)
//   first set most significant byte for this value (0 in this case)
~vMopho.control(~chMopho, 6, 0);
//   then least significant byte for parameter number (1 in this case)
~vMopho.control(~chMopho,38, 1);

~param=0;~nrpn=13;~vall=5;
        ~vMopho.control(~chMopho, 99, ~param);
		~vMopho.control(~chMopho, 98, ~nrpn);
		~vMopho.control(~chMopho, 6, 0);
		~vMopho.control(~chMopho,38, ~vall);


*/