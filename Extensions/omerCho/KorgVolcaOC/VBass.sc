VBass {
	var <>ortTime = 1;
	classvar <>counter3=0, counter18=0;

	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet01; });
		}
	}

	*globals{

		~vBass = MIDIOut.newByName("MIDIMATE II", "Port 1");


		//~vBass = MIDIOut.newByName("IAC Driver", "SC-Abl");

		~slideTime    = 5;   //*1
		~expr    = 11;  //*1,3

		~octVB     = 40;
		~lfoRate   = 41; //
		~lfoInt   = 42;
		~vcoPitch1   = 43;
		~vcoPitch2   = 44;
		~vcoPitch3   = 45;

		~egAtt   = 46;
		~egDec  = 47;
		~cutOff  = 48;
		~gateTime   = 49;



		//~lfoRate nob
		~poly  = 0;    // 0  - 12
		~uni   = 13;   //13  - 37
		~octav = 38;   //38  - 62
		~fifth = 63;   //63  - 87
		~uniR  = 88;   //88  - 112
		~polyR = 113;  //113 - 127

		//octave nob
		~oct1  = 0;     // 0  - 21
		~oct2  = 22;    // 22  - 21
		~oct3  = 44;    // 44  - 21
		~oct4  = 66;    // 66  - 21
		~oct5  = 88;    // 88  - 21
		~oct6  = 110;    // 110  - 127


	}

	*preSet01 {

		~vBass.control(0, ~slideTime, 20); // slideTime
		~vBass.control(0, ~expr, 120); //expression
		~vBass.control(0, ~octVB, ~oct3); //octave
		~vBass.control(0, ~lfoRate, 0); //LFO Rate
		~vBass.control(0, ~lfoInt, 0);


		~vBass.control(0, ~vcoPitch1, 0); // VCO1
		~vBass.control(0, ~vcoPitch2, 32); //VCO2
		~vBass.control(0, ~vcoPitch3, 94); //VCO3

		~vBass.control(0, ~egAtt, 0);
		~vBass.control(0, ~egDec, 120); //LFO Pitch Intencity
		~vBass.control(0, ~cutOff, 120); //LFO CutOff Intencity

		~vBass.control(0, ~gateTime, 0);

	}

	*preSet02 {


		~vBass.control(0, ~expr, 127); //expression

		~vBass.control(0, ~lfoRate, ~poly); //voice
		~vBass.control(0, ~octVK, ~oct3); //octave

		~vBass.control(0, ~lfoInt, 0); //detune
		~vBass.control(0, ~slideTime, 0); // portamento
		~vBass.control(0, ~vcoPitch1, 0); // VCOsculator Envelope Intencity

		~vBass.control(0, ~vcoPitch2, 50); //VCFilter CutOff
		~vBass.control(0, ~vcoPitch3, 75); //VCFilter Envelope Intencity

		~vBass.control(0, ~egAtt, 0); //LFO Rate
		~vBass.control(0, ~egDec, 0); //LFO Pitch Intencity
		~vBass.control(0, ~cutOff, 0); //LFO CutOff Intencity

		~vBass.control(0, ~gateTime, 0); //Envelope Generator Attack


	}

	*killAll {

		~vBass.allNotesOff(0);
		~vBass.allNotesOff(1);
		~vBass.allNotesOff(2);
		~vBass.allNotesOff(3);
		~vBass.allNotesOff(4);
		~vBass.allNotesOff(5);
		~vBass.allNotesOff(6);
		~vBass.allNotesOff(7);
		~vBass.allNotesOff(8);
		~vBass.allNotesOff(9);
		~vBass.allNotesOff(10);
		~vBass.allNotesOff(11);
		~vBass.allNotesOff(12);
		~vBass.allNotesOff(13);
		~vBass.allNotesOff(14);
		~vBass.allNotesOff(15);
		~vBass.allNotesOff(16);

	}

}