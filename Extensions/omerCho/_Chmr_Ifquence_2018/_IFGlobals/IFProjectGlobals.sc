//IF Globals
//Omer Chatziserif
//Sunday, 19 Jan 2014, 20:38
//Corfu, Greece
/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

IFProjectGlobals.setTempo(20);
*/

	IFProjectGlobals {
	classvar <>tempo= 120;


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
				0.5.wait;
			~mdClock.play
				IFSC.loadGroups;
				0.25.wait;
				IFSC.loadBuses;
				0.25.wait;
				IFSC.loadEffects;
				0.25.wait;
				IFSC.playEffects;
				0.5.wait;
				this.globals;
				this.preSetAll;
				this.setTempo(120);
				//Server.default.latency=0.0;
			});*/
		}
	}

	*load {

		this.setAddr;
		this.shiftButtons;
		this.setTempo(126);
		IFSixteen.defaults;
		IFMIDIMix.load;
		IFAPCMn.load;
		IFApcMnNotes.load;
		//IFAPCMn_Launch.load;
		//IFLaunchSteps.load;
		IFLpMn.load;
		//IFLpMnNotes.load;

		//IFLpMnShufs.load;
		IFLpMnSteps.load;
		~nt=(0);

		/*
		IFProjectGlobals.setAddr;
		IFProjectGlobals.shiftButtons;
		IFProjectGlobals.setTempo(120);
		IFSixteen.defaults;
		*/
	}

	*setAddr{

		//~tOSCAdrr = NetAddr.new("192.168.1.2", 57130); // router OTE
		~tOSCAdrr = NetAddr.new("192.168.1.2", 5001); // router OTE
		~local = NetAddr("localhost", 57120);

		~mdOut = MIDIOut.newByName("IAC Driver", "SC-Abl");
		~mdOutID= (-17145979325);
		~mdClock = MIDIClockOut("IAC Driver", "SC-Abl", TempoClock.default);

		~vBass = MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN1");
		~vKeys = MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN2");

		~mdTouch = MIDIOut.newByName("TouchOSC Bridge", "TouchOSC Bridge");
		~midiVel=127;

		//IFProjectGlobals.setTempo(124);
		~chMopho=1;

	}

	*setTempo {arg tempo;
		Tempo.bpm=tempo;
		~tmp1=tempo;
		~tOSCAdrr.sendMsg('tempoLabel', tempo);
		~vMopho.control(~chMopho, 14, tempo-30); //BPM
		//~mdOut.control(15, 3, 10); //ableton global tempo
		//Tempo.bpm = tempo;
		//Ableton.tap4;
	}

	*shiftButtons {
		~shiftTracksBut.free;
		~shiftTracksBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSixteen.tracks;
				},{
					IFSixteen.defaults;
			});
			},
			'/shiftTracks'
		);
		~shiftPartsBut.free;
		~shiftPartsBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSixteen.partsTrack01;
				},{
					IFSixteen.defaults;
			});
			},
			'/shiftParts'
		);
		~shiftPresetsBut.free;
		~shiftPresetsBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSixteen.presets;
				},{
					IFSixteen.defaults;
			});
			},
			'/shiftPresets'
		);
		~shiftDurationsBut.free;
		~shiftDurationsBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSixteen.durations;
				},{
					IFSixteen.defaults;
			});
			},
			'/shiftDurations'
		);

		~shiftScalesBut.free;
		~shiftScalesBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSixteen.scales;
				},{
					IFSixteen.defaults;
			});
			},
			'/shiftScales'
		);
		~shiftDirectionsBut.free;
		~shiftDirectionsBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSixteen.directions;
				},{
					IFSixteen.defaults;
			});
			},
			'/shiftDirect'
		);

	}



}

/*

IFProjectGlobals.times(kickT:1, snrT:1, hatT:1, bassT:1, sampT:1, ortaT:1, flatT:1, res1T:1);

~mdClock.tempo=140;

*/

/*
VBass.killAll; VKeys.killAll;

//TWELVE TONES
// 5 note scales
~scl2= Scale.minorPentatonic;   //yu
~scl2= Scale.majorPentatonic;
~scl2= Scale.ritusen;           //zhi
~scl2= Scale.egyptian;

~scl2= Scale.kumoi;
~scl2= Scale.hirajoshi;
~scl2= Scale.iwato;
~scl2= Scale.chinese;
~scl2= Scale.indian;
~scl2= Scale.pelog;

~scl2= Scale.prometheus;
~scl2= Scale.scriabin;

~scl2= Scale.gong; //MajorPentatonic
~scl2= Scale.shang; //egyptian
~scl2= Scale.jiao;
~scl2= Scale.zhi;
~scl2= Scale.yu;

// 6 note scales
~scl2= Scale.whole;
~scl2= Scale.augmented;
~scl2= Scale.augmented2;

//Partch's Otonalitiew and Utonalities
~scl2= Scale.partch_o1;
~scl2= Scale.partch_o2;
~scl2= Scale.partch_o3;
~scl2= Scale.partch_o4;
~scl2= Scale.partch_o5;
~scl2= Scale.partch_o6;
~scl2= Scale.partch_u1;
~scl2= Scale.partch_u2;
~scl2= Scale.partch_u3;
~scl2= Scale.partch_u4;
~scl2= Scale.partch_u5;
~scl2= Scale.partch_u6;

// Hexatonic modes with no tritone
~scl2= Scale.hexMajor7;
~scl2= Scale.hexDorian;
~scl2= Scale.hexPhrygian;
~scl2= Scale.hexSus;
~scl2= Scale.hexMajor6;
~scl2= Scale.hexAeolian;

// 7 Note Scales
~scl2= Scale.major; //ionian
~scl2= Scale.ionian;
~scl2= Scale.dorian;
~scl2= Scale.phrygian;
~scl2= Scale.lydian;
~scl2= Scale.mixolydian;
~scl2= Scale.aeolian;    //melodicMinorDesc
~scl2= Scale.minor;      //melodicMinorDesc
~scl2= Scale.locrian;

~scl2= Scale.harmonicMinor;
~scl2= Scale.harmonicMajor;

~scl2= Scale.melodicMinor;
~scl2= Scale.melodicMinorDesc;
~scl2= Scale.melodicMajor;

~scl2= Scale.bartok;     //MelodicMajor
~scl2= Scale.hindu;      // MelodicMajor

//Raga Modes
~scl2= Scale.todi;
~scl2= Scale.purvi;
~scl2= Scale.marva;
~scl2= Scale.bhairav;
~scl2= Scale.ahirbhairav;

~scl2= Scale.superLocrian;
~scl2= Scale.romanianMinor;
~scl2= Scale.hungarianMinor;
~scl2= Scale.neapolitanMinor;
~scl2= Scale.enigmatic;
~scl2= Scale.spanish;


//Makam Scales OC
~scl2= Scale.cargah;
~scl2= Scale.buselik;
~scl2= Scale.kurdi;
~scl2= Scale.rast;
~scl2= Scale.ussak; //beyati
~scl2= Scale.beyati;
~scl2= Scale.humayun;
~scl2= Scale.hicaz; //uzzal
~scl2= Scale.uzzal;
~scl2= Scale.zirguleliHicaz;
~scl2= Scale.huseyni;
~scl2= Scale.muhayyer; //tahir
~scl2= Scale.neva; //huseyni
~scl2= Scale.tahir;
~scl2= Scale.karcigar;
~scl2= Scale.basitSuznak;
~scl2= Scale.sipihrEski; //tahir


*/