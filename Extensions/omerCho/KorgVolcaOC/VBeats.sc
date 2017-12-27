/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

*/

VBeats {
	var <>ortTime = 1;
	classvar <>counter3=0, counter18=0;

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet01; this.oscMIDI });*/
		}
	}

	*globals{

		//~vBeats = MIDIOut.newByName("MIDIMATE II", "Port 2");
		//~vBeats = MIDIOut.newByName("IAC Driver", "SC-Abl");
		//~vBeats = MIDIOut.newByName("EDIROL FA-66 (1674)","Plug 1");
		//~vBeatsTest = MIDIOut.newByName("UM-2G", "1");
		~vBeats = MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN1");
		//~vBeats = MIDIOut.newByName("BCF2000", "Port 1");

		//~vBeatsLate=Tempo.bpm*(1/267.91897); //with Edirols MIDI Out
		~vBeatsLate=Tempo.bpm*(1);

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
			arg msg;
			~vBeatsSynth.set(\vol, msg[1]);
			~tOSCAdrr.sendMsg('volBeats', msg[1]);
		}, '/volBeats');





}



*preSet01 {

	~vBeats.control(9, ~kickLev, 20);



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

/*
//CH -7- [ BEATS ]
	//CH -0- [ BEATS ]
	//~nt1Beats.source   =  Pseq([~vKick,~vSnr,~vTomL,~vTomH,~vHatCl,~vHatOp,~vClap], inf);
	~nt1VKick.source   =  Pseq([~vKick], inf);
	~amp1VKick.source  =  Pseq([1,0,1,1], inf);
	~tmVKick.source    =  Pseq([1], inf);
	~levVKick.source    =  Pseq([0.9, 0.4, 1,0.5], inf);

	~nt1VSnr.source   =  Pseq([~vSnr], inf);
	~amp1VSnr.source  =  Pseq([1,0,1,0,0,1,0], inf);
	~tmVSnr.source    =  Pseq([1, 1, 1,1,1,1,1,2], inf);
	~levVSnr.source    =  Pseq([1, 0.9, 0.6, 0.4], inf);

	~nt1VTom.source   =  Pxrand([[~vTomL,~vTomH],~vTomH,~vTomL], inf);
	~amp1VTom.source  =  Pseq([1, 0, 1, 1, 0, 0], inf);
	~tmVTom.source    =  Pseq([1,1,2,1,1,2,2,1,2], inf);
	~levVTomL.source  =  Pseq([ 0.3, 0.8, 0.3, 0.2], inf);
	~levVTomH.source  =  Pseq([ 0.8, 0.2, 0.9, 0.5], inf);
	~decVTom.source   =  Pseq([ 0.5, 0.4, 0.6, 0.5], inf);

	~nt1VHat.source   =  Pxrand([[~vHatC,~vHatO],Pseq([~vHatC],5),~vHatO,Pseq([~vHatC],5)],inf);
	~amp1VHat.source  =  Pseq([1, 1, 1, 0, 1], inf);
	~tmVHat.source    =  Pseq([2,2,2,2,1,4,1], inf);
	~levVHatC.source  =  Pseq([ 1], inf);
	~levVHatO.source  =  Pseq([ 1], inf);
	~decVHatC.source   =  Pseq([ 0.1], inf);
	~decVHatO.source   =  Pseq([ 0.2, 0.4, 0.6, 0.5], inf);

	~nt1VPcm.source = Pxrand([
				[~vCrsh,~vCalv,~vClap],
				Pseq([~vCalv,~vAgog],5),
				[~vCalv,~vAgog,~vClap],
				Pseq([~vCalv],5),
				~vCrsh],inf);
	~amp1VPcm.source  =  Pseq([0, 1, 1, 0, 0,1,0], inf);
	~tmVPcm.source    =  Pseq([1,2,1,1,1,2,1], inf);
	~levVClap.source  =  Pseq([ 1,0.6, 0.8, 0.2], inf);
	~spdVClap.source   =  Pseq([ 0.1, 0.9, 0.5], inf);
	~levVCalv.source  =  Pseq([ 1,0.5, 0.3], inf);
	~spdVCalv.source   =  Pseq([ 0.1, 0.9, 0.6, 0.2], inf);
	~levVAgog.source  =  Pseq([ 1,0.5, 0.3], inf);
	~spdVAgog.source   =  Pseq([ 0.1, 0.9, 0.6, 0.2], inf);
	~levVCrsh.source  =  Pseq([ 1,0.5, 0.3], inf);
	~spdVCrsh.source   =  Pseq([ 0.1, 0.9, 0.6, 0.2], inf);


        Pbind(
			\chan, 9,
			\type, \midi, \midiout,~vBeats, \scale, Pfunc({Scale.chromatic}, inf),
			\octave,0,
			\dur, Pseq([1,1],1),
			\degree, Pseq([36], inf),
			\amp, Pseq([1,0.2], inf)
		).play;

*/