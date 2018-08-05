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
Mopho.control(15, 0, 384, 60);
Mopho.control(15, 0, 385, 50);
*/

Mopho{
	*control{|chan,param1,nrpn,param2,val|
		~vMopho.control(chan, 99, param1);
		~vMopho.control(chan, 98, nrpn);
		~vMopho.control(chan, 6, param2);
		~vMopho.control(chan,38, val);
	}
	//GLOBAL PARAMETER NRPN
	*masterTranspose{|val|
		//0-24 -- 0=-12 -- 12=0 -- 24=+12
		this.control(~chMopho, 3,0,0, val);
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
	/*
	Mopho.masterTranspose(12);
	Mopho.masterTune(0);
	Mopho.midiClock(0);
	Mopho.parameterSend(1);
	Mopho.parameterReceive(0);
	Mopho.controllerSendReceive(1);
	Mopho.sysexSendReceive(1);
	Mopho.audioOut(0);
	Mopho.midiOut(1);
	*/
}


/*
Mopho.control(~chMopho, 0, 0, 24); //Osc_1 Freq
~vMopho.noteOn(~chMopho, 26, 111); //But 1
~vMopho.noteOff(~chMopho, 26, 1); //But 1

~vMopho.control(~chMopho, 20, 48); //Osc_1 Freq
~vMopho.control(~chMopho, 21, 50); //Osc_1 Fine Tune
~vMopho.control(~chMopho, 22, 3); //Osc_1 Shape
~vMopho.control(~chMopho, 23, 13); //Osc_1 Glide

~vMopho.control(~chMopho, 24, 60); //Osc_2 Freq
~vMopho.control(~chMopho, 25, 57); //Osc_2 Fine Tune
~vMopho.control(~chMopho, 26, 58); //Osc_2 Shape
~vMopho.control(~chMopho, 27, 113); //Osc_2 Glide

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