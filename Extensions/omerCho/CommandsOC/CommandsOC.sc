/*
//A practical commands for MIDI and OSC
//Omer Chatziserif
//Sunday, 22 Dec 2013, 22:55
//Komotini, Greece

PostAllMIDI.on;
PostAllMIDI.off;

//to find the srcID of MIDIOut sources
~mdOut.uid;
~mdTouch.uid;
~apc40.uid;

//to find MIDIIn src
(
c = NoteOnResponder({ |src,chan,note,vel|
        [src,chan,note,vel].postln;
    });
    c.learn; // wait for the first note
)
NoteOnResponder.removeAll

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

PostAllOSC {




	*on{

		OSCFunc.trace(true); // Turn posting on

	}

	*off{


		OSCFunc.trace(false); // Turn posting off
	}


}
