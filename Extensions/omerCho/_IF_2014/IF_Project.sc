//IF Globals
//Omer Chatziserif
//Sunday, 19 Jan 2014, 20:38
//Corfu, Greece


	IFProject {
	classvar <>kickT, <>snrT, <>hatT, <>bassT, <>sampT, <>ortaT, <>flatT, <>res1T;
	classvar <>tempo= 120;


	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({
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
		~md1.control(1, 11, (110..116).choose); //KickVol
		~md1.control(1, 16, (97..106).choose); //SnrVol
		~md1.control(1, 21, (90..106).choose); //HatVol
		~md1.control(1, 26, (90..95).choose); //BassVol
		~md1.control(1, 31, (100..106).choose); //KeysVol
		~md1.control(1, 36, (98..104).choose); //SampVol

		~md1.control(1, 50, 0); //KickSus
		~md1.control(1, 51, 0); //SnrSus
		~md1.control(1, 52, 0); //HatSus
		~md1.control(1, 53, 0); //BassSus
		~md1.control(1, 54, (100..116).choose); //KeysSus
		~md1.control(1, 55, 0); //SampSus

		~md1.control(1, 13, (30..26).choose); //KickDec
		~md1.control(1, 18, (30..26).choose); //SnrDec
		~md1.control(1, 23, (30..26).choose); //HatDec
		~md1.control(1, 28, (30..26).choose); //BassDec
		~md1.control(1, 33, (30..26).choose); //KeysDec
		~md1.control(1, 38, (30..26).choose); //SampDec

		~md1.control(1, 12, (64..74).choose); //KickMute
		~md1.control(1, 17, (64..74).choose); //SnrMute
		~md1.control(1, 22, (64..74).choose); //HatMute
		~md1.control(1, 27, (64..74).choose); //BassMute
		~md1.control(1, 32, (64..74).choose); //KeysMute
		~md1.control(1, 37, (64..74).choose); //SampMute

		~md1.control(1, 41, 64); //KickChain
		~md1.control(1, 42, 64); //SnrChain
		~md1.control(1, 43, 64); //HatChain
		~md1.control(1, 44, 64); //BassChain
		~md1.control(1, 45, 64); //KeysChain
		~md1.control(1, 46, 64); //SampChain

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