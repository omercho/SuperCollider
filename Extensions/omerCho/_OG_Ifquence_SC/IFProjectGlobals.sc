//IF Globals
//Omer Chatziserif
//Sunday, 19 Jan 2014, 20:38
//Corfu, Greece


	IFProjectGlobals {
	classvar <>kickT, <>snrT, <>hatT, <>bassT, <>sampT, <>ortaT, <>flatT, <>res1T;
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
		this.setTempo(120);
		IFSixteen.defaults;
		//this.preSetAll;
		~nt=(0);
	}

	*setAddr{

		//~tOSCAdrr = NetAddr.new("192.168.1.7", 57130); // router OTE
		~tOSCAdrr = NetAddr.new("192.168.1.6", 5001); // router StudioVag
		//~tOSCAdrr = NetAddr.new("192.168.1.3", 5001); // connX
		~local = NetAddr("localhost", 57120);
		~mdOut = MIDIOut.newByName("IAC Driver", "SC-Abl");
		~behOut = MIDIOut.newByName("BCF2000", "Port 1");
		~mdClock = MIDIClockOut("IAC Driver", "SC-Abl", TempoClock.default);
		~vBeatsClock = MIDIClockOut("BCF2000", "Port 1", TempoClock.default);
		~mdTouch = MIDIOut.newByName("TouchOSC Bridge", "TouchOSC Bridge");

	}

	*setTempo {arg tempo;
		Tempo.bpm=tempo;
		~tmp1=120;
		~tOSCAdrr.sendMsg('tempoLabel', tempo);
		//~mdOut.control(15, 3, tempo); //ableton global tempo
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
				IFSixteen.parts;
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

	}
	*preSetAll{
		"Preset: Default".postln;
		~tOSCAdrr.sendMsg('presetLabel','Default');

		"Duration Mul: 1/2".postln;
		~tOSCAdrr.sendMsg('durMulLabel', '1/2');
		~durMul.source = Pseq([1/2], inf);
		~tOSCAdrr.sendMsg('durMul1_4', '0');
		~tOSCAdrr.sendMsg('durMul1_2', '1');
		~tOSCAdrr.sendMsg('durMul1', '0');

		"Duration Pattern: Straight".postln;
		~tOSCAdrr.sendMsg('durLabel', 'Straight');
		~dur.source = Pseq([1], inf)*~durMulP.next;
		~tOSCAdrr.sendMsg('dur1', '1');
		~tOSCAdrr.sendMsg('dur2', '0');
		~tOSCAdrr.sendMsg('dur3', '0');
		~tOSCAdrr.sendMsg('dur4', '0');
		~tOSCAdrr.sendMsg('durAks1', '0');
		~tOSCAdrr.sendMsg('durShuf1', '0');
		~tOSCAdrr.sendMsg('durRand1', '0');

		"Kick Set".postln;
		~local.sendMsg('volKick', 0.99);
		~local.sendMsg('sendKick', 0.0, 0.0);
		~local.sendMsg('attKick', 0.0);
		~local.sendMsg('susKick', 0.5);
		~local.sendMsg('decKick', 0.7);
		~local.sendMsg('chainKick', 0.0);

		"Snr Set".postln;
		~local.sendMsg('volSnr', 0.99);
		~local.sendMsg('sendSnr', 0.3, 0.1);
		~local.sendMsg('attSnr', 0.0);
		~local.sendMsg('susSnr', 0.5);
		~local.sendMsg('decSnr', 0.5);
		~local.sendMsg('chainSnr', 0.05);

		"Hat Set".postln;
		~local.sendMsg('volHat', 0.99);
		~local.sendMsg('sendHat', 0.0, 0.0);
		~local.sendMsg('attHat', 0.05);
		~local.sendMsg('susHat', 0.05);
		~local.sendMsg('decHat', 0.4);
		~local.sendMsg('chainHat', 0.05);

		"Bass Set".postln;
		~local.sendMsg('volBass', 0.95);
		~local.sendMsg('sendBass', 0.1, 0.0);
		~local.sendMsg('attBass', 0.05);
		~local.sendMsg('susBass', 0.5);
		~local.sendMsg('decBass', 0.2);
		~local.sendMsg('chainBass', 0.0);
		~local.sendMsg('lfoMulBass1',0.00);
		~local.sendMsg('lfoMulBass2',0.00);

		"Keys Set".postln;
		~local.sendMsg('volKeys', 0.95);
		~local.sendMsg('sendKeys', 0.0, 0.6);
		~local.sendMsg('attKeys', 0.05);
		~local.sendMsg('susKeys', 0.3);
		~local.sendMsg('decKeys', 0.05);
		~local.sendMsg('chainKeys', 0.05);
		~local.sendMsg('lfoMulKeys1',0.0);
		~local.sendMsg('lfoMulKeys2',0.01);

		"Samp Set".postln;
		~local.sendMsg('volSamp', 0.8);
		~local.sendMsg('sendSamp', 0.0, 0.3);
		~local.sendMsg('attSamp', 0.05);
		~local.sendMsg('susSamp', 0.05);
		~local.sendMsg('decSamp', 0.3);
		~local.sendMsg('chainSamp', 0.0);
		~local.sendMsg('lfoMulSamp1',0.2);
		~local.sendMsg('lfoMulSamp2',0.4);

		"Global Set".postln;
		~local.sendMsg('harm0',1);
		~local.sendMsg('cutAll',0.2, 0.2);
		~local.sendMsg('cutDrum',0.2, 0.2);



	}


	*preSet_1{
		"Set1".postln;


	}

	*times{arg kickT, snrT, hatT, bassT, keysT, sampT, res1T;


		IFKick.times(kickT); IFSnr.times(snrT); IFHat.times(hatT);
		IFBass.times(bassT); IFKeys.times(keysT);  IFSamp.times(sampT);
		IFRes1.times(res1T);
	}





	*resetCounts{
		~countMain = 0;

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