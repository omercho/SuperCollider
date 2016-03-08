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

		~tOSCAdrr = NetAddr.new("192.168.1.3", 57130); // router OTE

		~md1 = MIDIOut.newByName("IAC Driver", "SC-Abl");
		~mdTouch = MIDIOut.newByName("TouchOSC Bridge", "TouchOSC Bridge");
		//~md1Clock = MIDIClockOut("MIDIMATE II", "Port 1");



		~countMain=0;

		~mainCountersReset = {
			~countMain=0;
		};
		~mainCountersReset.fork;
		~part0Reset = {
			~part1=0; ~part2=0; ~part3=0;
			~part4=0; ~part5=0; ~part6=0;
			~part7=0; ~part8=0; ~part9=0;
		};~part0Reset.fork;
		~part1Reset = {
			~part0=0;
			          ~part2=0; ~part3=0;
			~part4=0; ~part5=0; ~part6=0;
			~part7=0; ~part8=0; ~part9=0;
		};~part1Reset.fork;
		~part2Reset = {
			~part0=0;
			~part1=0;           ~part3=0;
			~part4=0; ~part5=0; ~part6=0;
			~part7=0; ~part8=0; ~part9=0;
		};~part2Reset.fork;
		~part3Reset = {
			~part0=0;
			~part1=0; ~part2=0;
			~part4=0; ~part5=0; ~part6=0;
			~part7=0; ~part8=0; ~part9=0;
		};~part3Reset.fork;
		~part4Reset = {
			~part0=0;
			~part1=0; ~part2=0; ~part3=0;
			          ~part5=0; ~part6=0;
			~part7=0; ~part8=0; ~part9=0;
		};~part4Reset.fork;
		~part5Reset = {
			~part0=0;
			~part1=0; ~part2=0; ~part3=0;
			~part4=0;           ~part6=0;
			~part7=0; ~part8=0; ~part9=0;
		};~part5Reset.fork;
		~part6Reset = {
			~part0=0;
			~part1=0; ~part2=0; ~part3=0;
			~part4=0; ~part5=0;
			~part7=0; ~part8=0; ~part9=0;
		};~part6Reset.fork;
				~part7Reset = {
			~part0=0;
			~part1=0; ~part2=0; ~part3=0;
			~part4=0; ~part5=0; ~part6=0;
			          ~part8=0; ~part9=0;
		};~part7Reset.fork;
				~part8Reset = {
			~part0=0;
			~part1=0; ~part2=0; ~part3=0;
			~part4=0; ~part5=0; ~part6=0;
			~part7=0;           ~part9=0;
		};~part8Reset.fork;
				~part9Reset = {
			~part0=0;
			~part1=0; ~part2=0; ~part3=0;
			~part4=0; ~part5=0; ~part6=0;
			~part7=0; ~part8=0;
		};~part9Reset.fork;

	}

	*preSetAll{
		"Preset: Default".postln;
		~tOSCAdrr.sendMsg('presetLabel','Default');

		"Duration Pattern: 1 Straight".postln;
		~tOSCAdrr.sendMsg('durLabel', '1');
		~dur.source = Pseq([1], inf)*~durMulP;

		"Duration Mul: 1/2".postln;
		~tOSCAdrr.sendMsg('durMulLabel', '1/2');
		~durMul.source = Pseq([1/2], inf);

		~vBeatsLate=Tempo.bpm*(1/267.91897);

		~harmKick=0;~harmSnr=0;~harmHat=0;
		~harmBass=0;~harmKeys=0;~harmSamp=0;
		~tOSCAdrr.sendMsg('harm0', 0);

		~cutSet2=0.2;// X
		~tOSCAdrr.sendMsg('/cutAll','1', ~cutSet2);
		~vBass.control(0, ~gateTime, ~cutSet2);
		~md1.control(10, 7, ~cutSet2); //VKeys VCFilter CutOff
		~vKeys.control(0, ~vcfCut, ~cutSet2);
		~md1.control(10, 9, ~cutSet2); //IFSamp VCFilter CutOff
		~cutSet1=0.2;// Y
		~tOSCAdrr.sendMsg('/cutAll','0', ~cutSet1);
		~md1.control(10, 6, ~cutSet1); // VBass VCFilter CutOff
		~vBass.control(0, ~cutOff, ~cutSet1);
		~md1.control(10, 8, ~cutSet1); // IFSamp VCFilter CutOff


		~lfoMulBass1=0.2; ~tOSCAdrr.sendMsg('lfoMulBass1', 0.1);
		~lfoMulBass2=0.1; ~tOSCAdrr.sendMsg('lfoMulBass2', 0.05);
		~lfoMulKeys1=0.5; ~tOSCAdrr.sendMsg('lfoMulKeys1', 0.2);
		~lfoMulKeys2=0.5; ~tOSCAdrr.sendMsg('lfoMulKeys2', 0.1);
		~lfoMulSamp1=0.4; ~tOSCAdrr.sendMsg('lfoMulSamp1', 0.4);
		~lfoMulSamp2=0.4; ~tOSCAdrr.sendMsg('lfoMulSamp2', 0.5);

	}


	*preSet_1{
		"Set1".postln;



		~harmKick=0;~harmSnr=0;~harmHat=0;
		~harmBass=0;~harmKeys=0;~harmSamp=0;

		~lfoMulBass1=0.7; ~tOSCAdrr.sendMsg('lfoMulBass1', 0.7);
		~lfoMulKeys1=0.8; ~tOSCAdrr.sendMsg('lfoMulKeys1', 0.8);
		~lfoMulSamp1=0.6; ~tOSCAdrr.sendMsg('lfoMulSamp1', 0.6);

	}

	*times{arg kickT, snrT, hatT, bassT, sampT, ortaT, flatT, res1T;


		IFKick.times(kickT); IFSnr.times(snrT); IFHat.times(hatT);
		IFBass.times(bassT); IFSamp.times(sampT);
		IFOrta.times(ortaT); IFFlat.times(flatT);
		IFRes1.times(res1T);
	}

	*setTempo {arg tempo;
		Tempo.bpm = tempo;
		Ableton.tap4;
	}



	*resetCounts{
		~countMain = 0;

	}



}

/*

IFProjectGlobals.times(kickT:1, snrT:1, hatT:1, bassT:1, sampT:1, ortaT:1, flatT:1, res1T:1);

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