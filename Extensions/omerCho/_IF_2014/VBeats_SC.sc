VBeats {
	var <>ortTime = 1;
	classvar <>counter3=0, counter18=0;

	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({ this.globals; this.preSet01; this.oscMIDI });
		}
	}

	*globals{

		~vBeats = MIDIOut.newByName("MIDIMATE II", "Port 2");
		//~vBeats = MIDIOut.newByName("IAC Driver", "SC-Abl");
		//~vBeats = MIDIOut.newByName("EDIROL FA-66 (1674)","Plug 1");

		//~vBeats = MIDIOut.newByName("", "SC-Abl");

		~stutterTime  = 54;
		~stutterDepth = 55; //

		~kickLev     = 40;
		~snrLev      = 41;
		~tomLLev    = 42;
		~tomHLev    = 43;
		~hatCLev    = 44;
		~hatOLev    = 45;
		~clapLev     = 46;
		~calvLev   = 47;
		~agogLev    = 48;
		~crshLev    = 49;

		~tomDec     = 56;
		~hatCDec   = 57;
		~hatODec   = 58;
		~hatGrain   = 59;

		~clapSpeed     = 50;
		~calvSpeed   = 51;
		~agogSpeed    = 52;
		~crshSpeed    = 53;




		~vKick = 36;
		~vSnr = 38;
		~vTomL = 43;
		~vTomH = 50;
		~vHatC = 42;
		~vHatO = 46;
		~vClap = 39;
		~vCalv = 75;
		~vAgog = 67;
		~vCrsh = 49;




	}
	*oscMIDI {

		~stutD=0;
		~stutT=0;

		~xy1Beats.free;
		~xy1Beats= OSCFunc({
			arg msg;

			~stutD=msg[1];
			~stutT=msg[2];


			~vBeats.control(9, ~stutterTime, ~stutT*127);
			~tOSCAdrr.sendMsg('stutXY', ~stutT);
			~tOSCAdrr.sendMsg('stutTime', ~stutT);
			~vBeats.control(9, ~stutterDepth, ~stutD*127);
			~tOSCAdrr.sendMsg('stutXY', ~stutD);
			~tOSCAdrr.sendMsg('stutDepth', ~stutD);

		},
		'/stutXY'
	);



	~stutDepthFader.free;
	~stutDepthFader= OSCFunc({
		arg msg;

		~stutD=msg[1];

		~vBeats.control(9, ~stutterDepth, ~stutD*127);
		~tOSCAdrr.sendMsg('stutXY',~stutD,~stutT);
		~tOSCAdrr.sendMsg('stutDepth', msg[1]);
		},
		'/stutDepth'
	);

	~stutTimeFader.free;
	~stutTimeFader= OSCFunc({
		arg msg;

		~stutT=msg[1];

		~vBeats.control(9, ~stutterTime, msg[1]*127);
		~tOSCAdrr.sendMsg('stutXY',~stutT, ~stutD);
		~tOSCAdrr.sendMsg('stutTime', msg[1]);
		},
		'/stutTime'
	);

//-------------------------------------------
		~volBeatsFad.free;
		~volBeatsFad= OSCFunc({
			arg msg; ~vBeatsSynth.set(\vol, msg[1]); ~tOSCAdrr.sendMsg('volBeats', msg[1]);
		}, '/volBeats');


	//MUTES
	~vBeatsMtCln.free;
	~vBeatsMtCln= OSCFunc({
		arg msg;

		~vBeatsSynth.set(\mtCln, msg[1]);

		},
		'/mtClnBeats'
	);
	~vBeatsMtDly.free;
	~vBeatsMtDly= OSCFunc({
		arg msg;

		~vBeatsSynth.set(\mtDly, msg[1]);

		},
		'/mtDlyBeats'
	);
	~vBeatsMtRev.free;
	~vBeatsMtRev= OSCFunc({
		arg msg;

		~vBeatsSynth.set(\mtRev, msg[1]);

		},
		'/mtRevBeats'
	);
	~vBeatsMtFlo.free;
	~vBeatsMtFlo= OSCFunc({
		arg msg;

		~vBeatsSynth.set(\mtFlo, msg[1]);

		},
		'/mtFloBeats'
	);



}



*preSet01 {

	~vBeats.control(0, ~kickLev, 120);



}

*preSet02 {




}

*killAll {

	~vBeats.allNotesOff(0);
	~vBeats.allNotesOff(1);
	~vBeats.allNotesOff(2);
	~vBeats.allNotesOff(3);
	~vBeats.allNotesOff(4);
	~vBeats.allNotesOff(5);
	~vBeats.allNotesOff(6);
	~vBeats.allNotesOff(7);
	~vBeats.allNotesOff(8);
	~vBeats.allNotesOff(9);
	~vBeats.allNotesOff(10);
	~vBeats.allNotesOff(11);
	~vBeats.allNotesOff(12);
	~vBeats.allNotesOff(13);
	~vBeats.allNotesOff(14);
	~vBeats.allNotesOff(15);
	~vBeats.allNotesOff(16);

}

}