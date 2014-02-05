/*
//A practical commands for MIDI and OSC
//Omer Chatziserif
//Sunday, 22 Dec 2013, 22:55
//Komotini, Greece

PostAllMIDI.on;

*/

PostAllMIDI {


	*on {

				~midiResponders;

		MIDIClient.init;	// scan all midi sources
		MIDIClient.sources do: { | s, i | MIDIIn.connect(i, s) }; // connect all midi sources



		if (~midiResponders.isNil) {
			~midiResponders = [
			CCResponder,
			NoteOnResponder,
			NoteOffResponder,
			BendResponder,
			TouchResponder] collect:
				{ | r | r.new({ | ... args | [r.name, args].postln }, install: false) };
		};
		~midiResponders do: { | r | r.class.add(r) };
		"MIDI posting activated".postln;

	}

	*off {

		~midiResponders do: _.remove;
		"MIDI posting deactivated".postln;


	}

}