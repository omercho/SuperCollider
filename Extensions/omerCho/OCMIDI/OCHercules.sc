OCHercules {

	*initClass {
		StartUp add: {

			this.initMIDI;
		}
	}

	*initMIDI{

		//MIDIClient.init;	// scan all midi sources
		//MIDIClient.sources do: { | s, i | MIDIIn.connect(i, s) }; // connect all midi sources
		~mdHerc = MIDIOut.newByName("Hercules DJControl Instinct", "Hercules DJControl Instinct");

	}

	*default{
		// LEFT
		~mdHerc.noteOn(0, 21, 0); //left cue  ----LED
		~mdHerc.noteOn(0, 22, 0); //left play  ----LED

		~mdHerc.control(0, 48, 1); //left jog clock 0, 48, 1 ----- CC
		~mdHerc.control(0, 48, 127); //left jog reverse 0, 48, 127 ----- CC
		~mdHerc.noteOn(0, 26, 0); //left jog push
		~mdHerc.control(0, 50, 1); //left jog clock 0, 50, 1 ----- CC
		~mdHerc.control(0, 50, 127); //left jog reverse 0, 50, 127 ----- CC

		~mdHerc.noteOn(0, 19, 0); //left rw
		~mdHerc.noteOn(0, 20, 0); //left ff

		~mdHerc.noteOn(0, 23, 0); //left sync  ----LED
		~mdHerc.noteOn(0, 17, 0); //left minus
		~mdHerc.noteOn(0, 18, 0); //left plus
		~mdHerc.control(0, 52, 1); //left pitch minus 0, 52, 1 ----- CC
		~mdHerc.control(0, 52, 127); //left pitch plus 0, 52, 127 ----- CC


		~mdHerc.noteOn(0, 09, 0); //left Loop 1
		~mdHerc.noteOn(0, 10, 0); //left Loop 2
		~mdHerc.noteOn(0, 11, 0); //left Loop 3
		~mdHerc.noteOn(0, 12, 0); //left Loop 4

		~mdHerc.noteOn(0, 1, 0); //left Effect 1
		~mdHerc.noteOn(0, 2, 0); //left Effect 2
		~mdHerc.noteOn(0, 3, 0); //left Effect 3
		~mdHerc.noteOn(0, 4, 0); //left Effect 4

		~mdHerc.noteOn(0, 5, 0); //left Sample 1
		~mdHerc.noteOn(0, 6, 0); //left Sample 2
		~mdHerc.noteOn(0, 7, 0); //left Sample 3
		~mdHerc.noteOn(0, 8, 0); //left Sample 4

		~mdHerc.noteOn(0, 13, 0); //left Not Lighted 1
		~mdHerc.noteOn(0, 14, 0); //left Not Lighted 2
		~mdHerc.noteOn(0, 15, 0); //left Not Lighted 3
		~mdHerc.noteOn(0, 16, 0); //left Not Lighted 4

		//RIGHT
		~mdHerc.noteOn(0, 47, 0); //right cue  ----LED
		~mdHerc.noteOn(0, 48, 0); //right play  ----LED

		~mdHerc.control(0, 49, 1); //right jog clock 0, 49, 1 ----- CC
		~mdHerc.control(0, 49, 127); //right jog reverse 0, 49, 127 ----- CC
		~mdHerc.noteOn(0, 52, 0); //right jog push
		~mdHerc.control(0, 51, 1); //right jog clock 0, 51, 1 ----- CC
		~mdHerc.control(0, 51, 127); //right jog reverse 0, 51, 127 ----- CC

		~mdHerc.noteOn(0, 45, 0); //right rw
		~mdHerc.noteOn(0, 46, 0); //right ff

		~mdHerc.noteOn(0, 49, 0); //right sync  ----LED
		~mdHerc.noteOn(0, 43, 0); //right minus
		~mdHerc.noteOn(0, 44, 0); //right plus
		~mdHerc.control(0, 53, 1); //right pitch minus 0, 52, 1 ----- CC
		~mdHerc.control(0, 53, 127); //right pitch plus 0, 52, 127 ----- CC

		~mdHerc.noteOn(0, 35, 0); //right Loop 1
		~mdHerc.noteOn(0, 36, 0); //right Loop 2
		~mdHerc.noteOn(0, 37, 0); //right Loop 3
		~mdHerc.noteOn(0, 38, 0); //right Loop 4

		~mdHerc.noteOn(0, 27, 0); //right Effect 1
		~mdHerc.noteOn(0, 28, 0); //right Effect 2
		~mdHerc.noteOn(0, 29, 0); //right Effect 3
		~mdHerc.noteOn(0, 30, 0); //right Effect 4

		~mdHerc.noteOn(0, 31, 0); //right Sample 1
		~mdHerc.noteOn(0, 32, 0); //right Sample 2
		~mdHerc.noteOn(0, 33, 0); //right Sample 3
		~mdHerc.noteOn(0, 34, 0); //right Sample 4

		~mdHerc.noteOn(0, 39, 0); //right Not Lighted 1
		~mdHerc.noteOn(0, 40, 0); //right Not Lighted 2
		~mdHerc.noteOn(0, 41, 0); //right Not Lighted 3
		~mdHerc.noteOn(0, 42, 0); //right Not Lighted 4

		//CENTER
		~mdHerc.control(0, 58, 0); //center cross fader
		~mdHerc.control(0, 54, 0); //center left fader
		~mdHerc.control(0, 54, 0); //center right fader

		~mdHerc.noteOn(0, 24, 0); //center left ear ----LED
		~mdHerc.noteOn(0, 50, 0); //center right ear ----LED
		~mdHerc.noteOn(0, 25, 0); //center left load
		~mdHerc.noteOn(0, 51, 0); //center right load

		~mdHerc.control(0, 57, 0); //center left bass
		~mdHerc.control(0, 56, 0); //center left mid
		~mdHerc.control(0, 55, 0); //center left treb

		~mdHerc.control(0, 62, 0); //center right bass
		~mdHerc.control(0, 61, 0); //center right mid
		~mdHerc.control(0, 60, 0); //center right treb

		~mdHerc.noteOn(0, 57, 0); //center left ear ----LED
		~mdHerc.noteOn(0, 56, 0); //center right ear ----LED

		~mdHerc.noteOn(0, 54, 0); //center up
		~mdHerc.noteOn(0, 55, 0); //center down

	}


//class end
}

/*
~hercLeftEar.free;
~hercLeftEar=MIDIFunc.noteOn( {//center left ear ----LED
	arg vel;
	~md1.control(0, ~envAtt, vel);
	~mdHerc.noteOn(0, 57, 127); //center left ear ----LED

}, chan:0, ccNum:55);


~mdHerc.control(0, 127, 127); //
~mdHerc.control(0, 60, 5); //

~midiHerc={|tm=4|
	~fade = Pseq((0..127), inf).asStream;
	128.do{

		~mdHerc.noteOn(0, ~fade.next.postln, 0); //left load
		0.005.wait;
	};

}.fork;

~midiHerc.stop;

*/