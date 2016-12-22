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
		~mdOut = MIDIOut.newByName("IAC Driver", "SC-Abl");
		~abLate=0.00;

	}

	*start {

		~mdOut.control(15, 0, 100); //Start Live
	}

	*stop {

		~mdOut.control(15, 1, 100); //Stop Live
	}

	*tap {

		~mdOut.control(15, 2, 100); //Tap Live
	}

	*tap4 {

		{
			Pbind(
				\type, \midi, \midicmd, \control,
				\midiout,~mdOut, \chan, 15, \ctlNum, 2,
				\delta, Pseq([1], 4),\control, Pseq([100], 4)
			).play;
			4.01.wait;
			//this.stop;
		}.fork;
	}

	*killAll{
		~mdOut.allNotesOff(0);
		~mdOut.allNotesOff(1);
		~mdOut.allNotesOff(2);
		~mdOut.allNotesOff(3);
		~mdOut.allNotesOff(4);
		~mdOut.allNotesOff(5);
		~mdOut.allNotesOff(6);
		~mdOut.allNotesOff(7);
		~mdOut.allNotesOff(8);
		~mdOut.allNotesOff(9);
		~mdOut.allNotesOff(10);
		//~mdOut.control(15, 1, 100); //Stop Live



	}


}

/*
Pdef(\tap1,// tempo tap1
	Pbind(
		\type, \midi, \midicmd, \control, \midiout,~mdOut, \chan, 15, \ctlNum, 2,
		\delta, Pseq([1], 4),
		\control, Pseq([100], 4)
	)
).play;

~mdOut = MIDIOut.newByName("IAC Driver", "SC1");

~mdOut.control(15, 0, 100); //Start Live
~mdOut.control(15, 1, 100); //Stop Live
~mdOut.control(15, 2, 100); //Tempo Tap

~mdOut.allNotesOff(0);
~mdOut.allNotesOff(1);
~mdOut.allNotesOff(2);
~mdOut.allNotesOff(3);
~mdOut.allNotesOff(4);
~mdOut.allNotesOff(5);
~mdOut.allNotesOff(6);
~mdOut.allNotesOff(7);
~mdOut.allNotesOff(8);
~mdOut.allNotesOff(9);
~mdOut.allNotesOff(10);
~mdOut.control(15, 1, 100); //Stop Live


Ableton.start;
Ableton.stop;
Ableton.tap4;
Ableton.killAll;



*/