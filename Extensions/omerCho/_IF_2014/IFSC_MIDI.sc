IFSC_MIDI {

	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({
				1.2.wait;
				this.vBass;
				this.vKeys;

			});
		}
	}

	*vBass{
		~midiSusBass.free;
		~midiSusBass=MIDIFunc.cc( {
			arg vel;
			vel.postln;
			//~vBass.control(0, ~egAtt, vel);
			~vBass.control(0, ~gateTime, vel);
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

}