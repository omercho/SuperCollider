//IF Globals
//Omer Chatziserif
//Sunday, 19 Jan 2014, 20:38
//Corfu, Greece


	IFSCProjectGlobals {
	classvar <>kickT, <>snrT, <>hatT, <>bassT, <>sampT, <>ortaT, <>flatT, <>res1T;
	classvar <>tempo= 120;


	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({
				0.5.wait;
				IFSC.loadGroups;
				0.25.wait;
				IFSC.loadBuses;
				0.25.wait;
				IFSC.loadEffects;
				0.5.wait;
				this.globals;
				this.preSetAll;
				this.setTempo(125);
			});
		}
	}

	*resetCounts{
		~countMain = 0;

	}

	*preSetAll{
		"IFSC SetAll".postln;
		/*~md1.control(1, 11, 100); //KickVol
		~md1.control(1, 12, 64); //KickMute
		~md1.control(1, 50, 0); //KickSus
		~md1.control(1, 13, 40); //KickDec
		~md1.control(1, 41, 0); //KickChain


		~md1.control(1, 16, 95); //SnrVol
		~md1.control(1, 17, 64); //SnrMute
		~md1.control(1, 51, 0); //SnrSus
		~md1.control(1, 18, 30); //SnrDec
		~md1.control(1, 42, 64); //SnrChain


		~md1.control(1, 21, 90); //HatVol
		~md1.control(1, 22, 64); //HatMute
		~md1.control(1, 52, 20); //HatSus
		~md1.control(1, 23, 45); //HatDec
		~md1.control(1, 43, 0); //HatChain

		~md1.control(1, 26, 98); //BassVol
		~md1.control(1, 27, 64); //BassMute
		~md1.control(1, 53, 30); //BassSus
		~md1.control(1, 28, 35); //BassDec
		~md1.control(1, 44, 14); //BassChain


		~md1.control(1, 31, 106); //KeysVol
		~md1.control(1, 32, 64); //KeysMute
		~md1.control(1, 54, 100); //KeysSus
		~md1.control(1, 33, 20); //KeysDec


		~md1.control(1, 36, 90); //SampVol
		~md1.control(1, 37, 64); //SampMute
		~md1.control(1, 55, 60); //SampSus
		~md1.control(1, 38, 30); //SampDec
		~md1.control(1, 46, 64); //SampChain

		~md1.control(3, 0, 0); //MainSendX
		~md1.control(3, 1, 0); //MainSendY*/


		~harmKick=0;~harmSnr=0;~harmHat=0;
		~harmBass=0;~harmKeys=0;~harmSamp=0;

		~lfoMulBass=0.2; ~tOSCAdrr.sendMsg('lfoMulBass', 0.2);
		~lfoMulKeys=0.5; ~tOSCAdrr.sendMsg('lfoMulKeys', 0.5);
		~lfoMulSamp=0.4; ~tOSCAdrr.sendMsg('lfoMulSamp', 0.4);

	}


	*preSet_1{
		"Set1".postln;
		~md1.control(1, 11, 104); //KickVol
		~md1.control(1, 12, 64); //KickMute
		~md1.control(1, 50, 0); //KickSus
		~md1.control(1, 13, 50); //KickDec
		~md1.control(1, 41, 60); //KickChain


		~md1.control(1, 16, 95); //SnrVol
		~md1.control(1, 17, 64); //SnrMute
		~md1.control(1, 51, 100); //SnrSus
		~md1.control(1, 18, 60); //SnrDec
		~md1.control(1, 42, 74); //SnrChain


		~md1.control(1, 21, 100); //HatVol
		~md1.control(1, 22, 64); //HatMute
		~md1.control(1, 52, 120); //HatSus
		~md1.control(1, 23, 85); //HatDec
		~md1.control(1, 43, 70); //HatChain

		~md1.control(1, 26, 99); //BassVol
		~md1.control(1, 27, 64); //BassMute
		~md1.control(1, 53, 120); //BassSus
		~md1.control(1, 28, 35); //BassDec
		~md1.control(1, 44, 114); //BassChain


		~md1.control(1, 31, 106); //KeysVol
		~md1.control(1, 32, 64); //KeysMute
		~md1.control(1, 54, 100); //KeysSus
		~md1.control(1, 33, 20); //KeysDec


		~md1.control(1, 36, 90); //SampVol
		~md1.control(1, 37, 64); //SampMute
		~md1.control(1, 55, 90); //SampSus
		~md1.control(1, 38, 29); //SampDeC
		~md1.control(1, 46, 64); //SampChain

		~md1.control(3, 0, 30); //MainSendX
		~md1.control(3, 1, 0); //MainSendY


		~harmKick=0;~harmSnr=0;~harmHat=0;
		~harmBass=0;~harmKeys=0;~harmSamp=0;

		~lfoMulBass=0.7; ~tOSCAdrr.sendMsg('lfoMulBass', 0.7);
		~lfoMulKeys=0.8; ~tOSCAdrr.sendMsg('lfoMulKeys', 0.8);
		~lfoMulSamp=0.6; ~tOSCAdrr.sendMsg('lfoMulSamp', 0.6);

	}

	*times{arg kickT, snrT, hatT, bassT, sampT, ortaT, flatT, res1T;


		IFKick.times(kickT); IFSnr.times(snrT); IFHat.times(hatT);
		IFBass.times(bassT); IFSamp.times(sampT);
		IFOrta.times(ortaT); IFFlat.times(flatT);
		IFRes1.times(res1T);
	}

	*setTempo {arg tempo;
		Tempo.bpm = tempo;
		//Ableton.tap4;
	}

	*globals{

		~abLate=0.00;

		~scl1 = Scale.chromatic; ~scl2 = Scale.minor;
		~durMul = 1.0;

		~nt=0;

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



}

/*

IFProject.times(kickT:1, snrT:1, hatT:1, bassT:1, sampT:1, ortaT:1, flatT:1, res1T:1);

*/