IFSC_MIDI {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
				this.midiAdrr;
				1.2.wait;
				this.vBass;
				this.vKeys;
				this.latency;

			});*/
		}
	}

	*midiAdrr{

		//MIDIClient.init;	// scan all midi sources
		//MIDIClient.sources do: { | s, i | MIDIIn.connect(i, s) }; // connect all midi sources
		MIDIIn.connectAll;
		~sc1 = MIDIOut.newByName("IAC Driver", "SC1");
		~md1 = MIDIOut.newByName("IAC Driver", "SC-Abl");
		~mdTouch = MIDIOut.newByName("TouchOSC Bridge", "TouchOSC Bridge");

		//~md1Clock = MIDIClockOut("MIDIMATE II", "Port 1");
		//~tOSCAdrr = NetAddr.new("192.168.1.3", 57130); // create the NetAddr
		//~tOSCAdrr = NetAddr.new("169.254.44.119", 57130); // create the NetAddr

	}

	*vBass{
		~midiSusBass.free;
		~midiSusBass=MIDIFunc.cc( {
			arg vel;
			vel.postln;
			//~vBass.control(0, ~egAtt, vel);
			//~vBass.control(0, ~egAtt, vel);
			~vBass.control(0, ~slideTime, vel);
		}, chan:1, ccNum:53);

		~midiDecBass.free;
		~midiDecBass=MIDIFunc.cc( {
			arg vel;
			vel.postln;
			~vBass.control(0, ~egDec, vel);

		}, chan:1, ccNum:28);
	}

	*vKeys{
		~midiSusKeys.free;
		~midiSusKeys=MIDIFunc.cc( {
			arg vel;
			vel.postln;
			~vKeys.control(0, ~envSus, vel);

		}, chan:1, ccNum:54);

		~midiDecKeys.free;
		~midiDecKeys=MIDIFunc.cc( {
			arg vel;
			vel.postln;
			~vKeys.control(0, ~envDec, vel);

		}, chan:1, ccNum:33);
	}

	*latency{

		~grp1=0.02;Server.default.latency=~grp1;~vBeats.latency=0.0;~vBass.latency=~grp1;~vKeys.latency=~grp1;


	}

}