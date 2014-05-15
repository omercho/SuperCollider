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