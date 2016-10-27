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

	*loadAll {

		this.globals;

		this.setTempo(120);
		this.preSetAll;
	}


	*globals{

		~tOSCAdrr = NetAddr.new("192.168.1.2", 57130); // router OTE

		~mdOut = MIDIOut.newByName("IAC Driver", "SC-Abl");
		~mdClock = MIDIClockOut("IAC Driver", "SC-Abl", TempoClock.default);
		~mdTouch = MIDIOut.newByName("TouchOSC Bridge", "TouchOSC Bridge");


	}

	*preSetAll{
		"Preset: Default".postln;
		~tOSCAdrr.sendMsg('presetLabel','Default');

		"Duration Pattern: 1 Straight".postln;
		~tOSCAdrr.sendMsg('durLabel', '1');
		~dur.source = Pseq([1], inf)*~durMulP;
		~tOSCAdrr.sendMsg('dur1', '1');
		~tOSCAdrr.sendMsg('dur2', '0');
		~tOSCAdrr.sendMsg('dur3', '0');
		~tOSCAdrr.sendMsg('dur4', '0');
		~tOSCAdrr.sendMsg('durAks1', '0');
		~tOSCAdrr.sendMsg('durShuf1', '0');
		~tOSCAdrr.sendMsg('durRand1', '0');

		"Duration Mul: 1/2".postln;
		~tOSCAdrr.sendMsg('durMulLabel', '1/2');
		~durMul.source = Pseq([1/2], inf);
		~tOSCAdrr.sendMsg('durMul1_4', '0');
		~tOSCAdrr.sendMsg('durMul1_2', '1');
		~tOSCAdrr.sendMsg('durMul1', '0');

		//~vBeatsLate=Tempo.bpm*(1/267.91897);
		"Kick Set".postln;
		~volKickMsg=0.9; ~mdOut.control(2, 1, ~volKickMsg*127);
		~sndXKickMsg=0.0; ~mdOut.control(2, 3, ~sndXKickMsg*127);
		~sndYKickMsg=0.0; ~mdOut.control(2, 4, ~sndYKickMsg*127);
		~attKickMsg=0.0; ~mdOut.control(2, 5, ~attKickMsg*127);
		~susKickMsg=0.0; ~mdOut.control(2, 6, ~susKickMsg*127);
		~decKickMsg=0.0; ~mdOut.control(2, 7, ~decKickMsg*127);
		~chnKickMsg=0.0; ~mdOut.control(2, 8, ~chnKickMsg*127);
		~tOSCAdrr.sendMsg('volKick', ~volKickMsg);
		~tOSCAdrr.sendMsg('kickSends', ~sndXKickMsg, ~sndYKickMsg);
		~tOSCAdrr.sendMsg('attKick', ~attKickMsg);
		~tOSCAdrr.sendMsg('decKick', ~decKickMsg);
		~tOSCAdrr.sendMsg('susKick', ~susKickMsg);
		~tOSCAdrr.sendMsg('chainKick', ~chnKickMsg);

		"Snr Set".postln;
		~volSnrMsg=1.0; ~mdOut.control(3, 1, ~volSnrMsg*127);
		~sndXSnrMsg=0.0; ~mdOut.control(3, 3, ~sndXSnrMsg*127);
		~sndYSnrMsg=0.0; ~mdOut.control(3, 4, ~sndYSnrMsg*127);
		~attSnrMsg=0.0; ~mdOut.control(3, 5, ~attSnrMsg*127);
		~susSnrMsg=0.0; ~mdOut.control(3, 6, ~susSnrMsg*127);
		~decSnrMsg=0.0; ~mdOut.control(3, 7, ~decSnrMsg*127);
		~chnSnrMsg=0.0; ~mdOut.control(3, 8, ~chnSnrMsg*127);
		~tOSCAdrr.sendMsg('volSnr', ~volSnrMsg);
		~tOSCAdrr.sendMsg('snrSends', ~sndXSnrMsg, ~sndYSnrMsg);
		~tOSCAdrr.sendMsg('attSnr', ~attSnrMsg);
		~tOSCAdrr.sendMsg('decSnr', ~decSnrMsg);
		~tOSCAdrr.sendMsg('susSnr', ~susSnrMsg);
		~tOSCAdrr.sendMsg('chainSnr', ~chnSnrMsg);

		"Hat Set".postln;
		~volHatMsg=1.0; ~mdOut.control(4, 1, ~volHatMsg*127);
		~sndXHatMsg=0.0; ~mdOut.control(4, 3, ~sndXHatMsg*127);
		~sndYHatMsg=0.0; ~mdOut.control(4, 4, ~sndYHatMsg*127);
		~attHatMsg=0.0; ~mdOut.control(4, 5, ~attHatMsg*127);
		~susHatMsg=0.0; ~mdOut.control(4, 6, ~susHatMsg*127);
		~decHatMsg=0.0; ~mdOut.control(4, 7, ~decHatMsg*127);
		~chnHatMsg=0.0; ~mdOut.control(4, 8, ~chnHatMsg*127);
		~tOSCAdrr.sendMsg('volHat', ~volHatMsg);
		~tOSCAdrr.sendMsg('hatSends', ~sndXHatMsg, ~sndYHatMsg);
		~tOSCAdrr.sendMsg('attHat', ~attHatMsg);
		~tOSCAdrr.sendMsg('decHat', ~decHatMsg);
		~tOSCAdrr.sendMsg('susHat', ~susHatMsg);
		~tOSCAdrr.sendMsg('chainHat', ~chnHatMsg);

		"Bass Set".postln;
		~volBassMsg=1.0; ~mdOut.control(5, 1, ~volBassMsg*127);
		~sndXBassMsg=0.0; ~mdOut.control(5, 3, ~sndXBassMsg*127);
		~sndYBassMsg=0.0; ~mdOut.control(5, 4, ~sndYBassMsg*127);
		~attBassMsg=0.0; ~mdOut.control(5, 5, ~attBassMsg*127);
		~susBassMsg=0.0; ~mdOut.control(5, 6, ~susBassMsg*127);
		~decBassMsg=0.0; ~mdOut.control(5, 7, ~decBassMsg*127);
		~chnBassMsg=0.0; ~mdOut.control(5, 8, ~chnBassMsg*127);
		~lfoMulBass1=0.2; ~tOSCAdrr.sendMsg('lfoMulBass1', 0.2);
		~lfoMulBass2=0.1; ~tOSCAdrr.sendMsg('lfoMulBass2', 0.1);
		~tOSCAdrr.sendMsg('volBass', ~volBassMsg);
		~tOSCAdrr.sendMsg('bassSends', ~sndXBassMsg, ~sndYBassMsg);
		~tOSCAdrr.sendMsg('attBass', ~attBassMsg);
		~tOSCAdrr.sendMsg('decBass', ~decBassMsg);
		~tOSCAdrr.sendMsg('susBass', ~susBassMsg);
		~tOSCAdrr.sendMsg('chainBass', ~chnBassMsg);

		"Keys Set".postln;
		~volKeysMsg=1.0; ~mdOut.control(6, 1, ~volKeysMsg*127);
		~sndXKeysMsg=0.0; ~mdOut.control(6, 3, ~sndXKeysMsg*127);
		~sndYKeysMsg=0.0; ~mdOut.control(6, 4, ~sndYKeysMsg*127);
		~attKeysMsg=0.0; ~mdOut.control(6, 5, ~attKeysMsg*127);
		~susKeysMsg=0.0; ~mdOut.control(6, 6, ~susKeysMsg*127);
		~decKeysMsg=0.0; ~mdOut.control(6, 7, ~decKeysMsg*127);
		~chnKeysMsg=0.0; ~mdOut.control(6, 8, ~chnKeysMsg*127);
		~lfoMulKeys1=0.2; ~tOSCAdrr.sendMsg('lfoMulKeys1', 0.2);
		~lfoMulKeys2=0.1; ~tOSCAdrr.sendMsg('lfoMulKeys2', 0.1);
		~tOSCAdrr.sendMsg('volKeys', ~volKeysMsg);
		~tOSCAdrr.sendMsg('keysSends', ~sndXKeysMsg, ~sndYKeysMsg);
		~tOSCAdrr.sendMsg('attKeys', ~attKeysMsg);
		~tOSCAdrr.sendMsg('decKeys', ~decKeysMsg);
		~tOSCAdrr.sendMsg('susKeys', ~susKeysMsg);
		~tOSCAdrr.sendMsg('chainKeys', ~chnKeysMsg);

		"Samp Set".postln;
		~volSampMsg=1.0; ~mdOut.control(7, 1, ~volSampMsg*127);
		~sndXSampMsg=0.0; ~mdOut.control(7, 3, ~sndXSampMsg*127);
		~sndYSampMsg=0.0; ~mdOut.control(7, 4, ~sndYSampMsg*127);
		~attSampMsg=0.0; ~mdOut.control(7, 5, ~attSampMsg*127);
		~susSampMsg=0.0; ~mdOut.control(7, 6, ~susSampMsg*127);
		~decSampMsg=0.0; ~mdOut.control(7, 7, ~decSampMsg*127);
		~chnSampMsg=0.0; ~mdOut.control(7, 8, ~chnSampMsg*127);
		~lfoMulSamp1=0.2; ~tOSCAdrr.sendMsg('lfoMulSamp1', 0.2);
		~lfoMulSamp2=0.1; ~tOSCAdrr.sendMsg('lfoMulSamp2', 0.1);
		~tOSCAdrr.sendMsg('volSamp', ~volSampMsg);
		~tOSCAdrr.sendMsg('sampSends', ~sndXSampMsg, ~sndYSampMsg);
		~tOSCAdrr.sendMsg('attSamp', ~attSampMsg);
		~tOSCAdrr.sendMsg('decSamp', ~decSampMsg);
		~tOSCAdrr.sendMsg('susSamp', ~susSampMsg);
		~tOSCAdrr.sendMsg('chainSamp', ~chnSampMsg);

		~harmKick=0;~harmSnr=0;~harmHat=0;
		~harmBass=0;~harmKeys=0;~harmSamp=0;
		~tOSCAdrr.sendMsg('harm0', 0);

		~cutAllSet1=0.2;// Y
		~mdOut.control(10, 6, ~cutAllSet1); // VBass CUT Y
		~mdOut.control(10, 7, ~cutAllSet1); //VKeys CUT Y
		~mdOut.control(10, 8, ~cutAllSet1); // IFSamp Morf
		//~vBass.control(0, ~cutOff, ~cutSet1);
		~cutAllSet2=0.2;// X
		~mdOut.control(10, 9, ~cutAllSet2); //IFVBass CUTX
		~mdOut.control(10, 10, ~cutAllSet2); //IFVKeys CUT X
		~mdOut.control(10, 11, ~cutAllSet2); //IFSamp CUT X
		//~vBass.control(0, ~gateTime, ~cutSet2);
		//~vKeys.control(0, ~vcfCut, ~cutSet2);
		~tOSCAdrr.sendMsg('/cutAll',~cutAllSet1, ~cutAllSet2);

		~cutDrumSet1=0.0;// Y
		~mdOut.control(10, 20, ~cutDrumSet1);
		~cutDrumSet2=0.0;// X
		~mdOut.control(10, 21, ~cutDrumSet2);
		~tOSCAdrr.sendMsg('/cutDrum',~cutDrumSet1, ~cutDrumSet2);

	}


	*preSet_1{
		"Set1".postln;



		~harmKick=0;~harmSnr=0;~harmHat=0;
		~harmBass=0;~harmKeys=0;~harmSamp=0;

		~lfoMulBass1=0.7; ~tOSCAdrr.sendMsg('lfoMulBass1', 0.7);
		~lfoMulKeys1=0.8; ~tOSCAdrr.sendMsg('lfoMulKeys1', 0.8);
		~lfoMulSamp1=0.6; ~tOSCAdrr.sendMsg('lfoMulSamp1', 0.6);

	}

	*times{arg kickT, snrT, hatT, bassT, keysT, sampT, res1T;


		IFKick.times(kickT); IFSnr.times(snrT); IFHat.times(hatT);
		IFBass.times(bassT); IFKeys.times(keysT);  IFSamp.times(sampT);
		IFRes1.times(res1T);
	}

	*setTempo {arg tempo;
		Tempo.bpm=tempo;
		~tmp1=90;
		//~mdOut.control(15, 3, tempo); //ableton global tempo
		~tOSCAdrr.sendMsg('tempoLabel', tempo);
		//Tempo.bpm = tempo;
		//Ableton.tap4;
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