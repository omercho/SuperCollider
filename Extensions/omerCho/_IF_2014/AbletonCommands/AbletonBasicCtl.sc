//A Basic MIDI Commands for Ableton Live 9
//Omer Chatziserif
//Sunday, 19 Jan 2014, 20:38
//Corfu, Greece


	Ableton {

	*initClass {
		StartUp add: {

			this.initMIDI;
		}
	}

	*initMIDI{

		MIDIClient.init;	// scan all midi sources
		MIDIClient.sources do: { | s, i | MIDIIn.connect(i, s) }; // connect all midi sources
		~md1 = MIDIOut.newByName("IAC Driver", "SC-Abl");

	}

	*start {

		~md1.control(15, 0, 100); //Start Live
	}

	*stop {

		~md1.control(15, 1, 100); //Start Live
	}

	*tap {

		~md1.control(15, 2, 100); //Tap Live
	}

	*tap4 {

/*		{
			Pbind(
				\type, \midi, \midicmd, \control,
				\midiout,~md1, \chan, 15, \ctlNum, 2,\delta, Pseq([1], 4),\control, Pseq([100], 4)
			).play;
			4.01.wait;
			this.stop;
		}.fork;*/
	}

	*killAll{
		~md1.allNotesOff(0);
		~md1.allNotesOff(1);
		~md1.allNotesOff(2);
		~md1.allNotesOff(3);
		~md1.allNotesOff(4);
		~md1.allNotesOff(5);
		~md1.allNotesOff(6);
		~md1.allNotesOff(7);
		~md1.allNotesOff(8);
		~md1.allNotesOff(9);
		~md1.allNotesOff(10);
		~md1.control(15, 1, 100); //Stop Live

	}


}

/*
Pdef(\tap1,// tempo tap1
	Pbind(
		\type, \midi, \midicmd, \control, \midiout,~md1, \chan, 15, \ctlNum, 2,
		\delta, Pseq([1], 4),
		\control, Pseq([100], 4)
	)
).play;

~md1 = MIDIOut.newByName("IAC Driver", "SC1");

~md1.control(15, 0, 100); //Start Live
~md1.control(15, 1, 100); //Stop Live
~md1.control(15, 2, 100); //Tempo Tap

~md1.allNotesOff(0);
~md1.allNotesOff(1);
~md1.allNotesOff(2);
~md1.allNotesOff(3);
~md1.allNotesOff(4);
~md1.allNotesOff(5);
~md1.allNotesOff(6);
~md1.allNotesOff(7);
~md1.allNotesOff(8);
~md1.allNotesOff(9);
~md1.allNotesOff(10);
~md1.control(15, 1, 100); //Stop Live


Ableton.start;
Ableton.stop;
Ableton.tap4;
Ableton.killAll;



*/