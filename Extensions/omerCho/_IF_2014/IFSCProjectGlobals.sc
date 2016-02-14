//IF Globals
//Omer Chatziserif
//Sunday, 19 Jan 2014, 20:38
//Corfu, Greece


	IFSCProjectGlobals {
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
		this.preSetAll;
		this.setTempo(120);
	}


	*globals{

		~tOSCAdrr = NetAddr.new("192.168.1.3", 57130); // router OTE
		//~tOSCAdrr = NetAddr.new("169.254.132.166", 57130); // create the NetAddr
		//~tOSCAdrr = NetAddr.new("169.254.108.24", 57130); // vaggelisLocalNetwork


		//MIDIClient.init;	// scan all midi sources
		//MIDIClient.sources do: { | s, i | MIDIIn.connect(i, s) }; // connect all midi sources
		MIDIIn.connectAll;
		//~sc1 = MIDIOut.newByName("IAC Driver", "SC1");
		~md1 = MIDIOut.newByName("IAC Driver", "SC-Abl");
		~mdTouch = MIDIOut.newByName("TouchOSC Bridge", "TouchOSC Bridge");

		//~md1Clock = MIDIClockOut("MIDIMATE II", "Port 1");
		//~tOSCAdrr = NetAddr.new("192.168.1.3", 57130); // create the NetAddr
		//~tOSCAdrr = NetAddr.new("169.254.44.119", 57130); // create the NetAddr


		~abLate=0.00;

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

	*preSetAll{
		"IFSC SetAll".postln;



		~harmKick=0;~harmSnr=0;~harmHat=0;
		~harmBass=0;~harmKeys=0;~harmSamp=0;

		~lfoMulBass1=0.2; ~tOSCAdrr.sendMsg('lfoMulBass1', 0.2);
		~lfoMulKeys1=0.5; ~tOSCAdrr.sendMsg('lfoMulKeys1', 0.5);
		~lfoMulSamp1=0.4; ~tOSCAdrr.sendMsg('lfoMulSamp1', 0.4);

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

IFProject.times(kickT:1, snrT:1, hatT:1, bassT:1, sampT:1, ortaT:1, flatT:1, res1T:1);

*/