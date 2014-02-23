VKeys {
	var <>ortTime = 1;
	classvar <>counter3=0, counter18=0;

	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet01; });
		}
	}

	*globals{

		~vKeys = MIDIOut.newByName("MIDIMATE II", "Port 1");

		~vcoPorta    = 5;   //*1
		~expr    = 11;  //*1,3
		~voice   = 40; //
		~octVK     = 41;
		~vcoDetune   = 42;
		~vcoEg   = 43;
		~vcfCut     = 44;
		~vcfEg   = 45;
		~lfoRate   = 46;
		~lfoPitch  = 47;
		~lfoCut  = 48;
		~envAtt   = 49;
		~envDec   = 50;
		~envSus   = 51;
		~dlyTime = 52;
		~dlyFeed = 53;


		//~voice nob
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

		~vKeys.control(0, ~expr, 127); //expression

		~vKeys.control(0, ~voice, ~poly); //voice
		~vKeys.control(0, ~octVK, ~oct3); //octave

		~vKeys.control(0, ~vcoDetune, 5); //detune
		~vKeys.control(0, ~vcoPorta, 1); // portamento
		~vKeys.control(0, ~vcoEg, 120); // VCOsculator Envelope Intencity

		~vKeys.control(0, ~vcfCut, 120); //VCFilter CutOff
		~vKeys.control(0, ~vcfEg, 74); //VCFilter Envelope Intencity

		~vKeys.control(0, ~lfoRate, 0); //LFO Rate
		~vKeys.control(0, ~lfoPitch, 0); //LFO Pitch Intencity
		~vKeys.control(0, ~lfoCut, 0); //LFO CutOff Intencity

		~vKeys.control(0, ~envAtt, 2); //Envelope Generator Attack
		~vKeys.control(0, ~envDec, 4); //Envelope Generator Decay/Release
		~vKeys.control(0, ~envSus, 104); //Envelope Generator Sustain

		~vKeys.control(0, ~dlyTime, 104); //Delay Time
		~vKeys.control(0, ~dlyFeed, 0); //Delay FeedBack

	}

	*preSet02 {

		~vKeys.control(0, ~expr, 127); //expression

		~vKeys.control(0, ~voice, ~poly); //voice
		~vKeys.control(0, ~octVK, ~oct3); //octave

		~vKeys.control(0, ~vcoDetune, 5); //detune
		~vKeys.control(0, ~vcoPorta, 1); // portamento
		~vKeys.control(0, ~vcoEg, 120); // VCOsculator Envelope Intencity

		~vKeys.control(0, ~vcfCut, 120); //VCFilter CutOff
		~vKeys.control(0, ~vcfEg, 74); //VCFilter Envelope Intencity

		~vKeys.control(0, ~lfoRate, 0); //LFO Rate
		~vKeys.control(0, ~lfoPitch, 0); //LFO Pitch Intencity
		~vKeys.control(0, ~lfoCut, 0); //LFO CutOff Intencity

		~vKeys.control(0, ~envAtt, 2); //Envelope Generator Attack
		~vKeys.control(0, ~envDec, 4); //Envelope Generator Decay/Release
		~vKeys.control(0, ~envSus, 124); //Envelope Generator Sustain

		~vKeys.control(0, ~dlyTime, 104); //Delay Time
		~vKeys.control(0, ~dlyFeed, 0); //Delay FeedBack

	}

	*killAll {

		~vKeys.allNotesOff(0);
		~vKeys.allNotesOff(1);
		~vKeys.allNotesOff(2);
		~vKeys.allNotesOff(3);
		~vKeys.allNotesOff(4);
		~vKeys.allNotesOff(5);
		~vKeys.allNotesOff(6);
		~vKeys.allNotesOff(7);
		~vKeys.allNotesOff(8);
		~vKeys.allNotesOff(9);
		~vKeys.allNotesOff(10);
		~vKeys.allNotesOff(11);
		~vKeys.allNotesOff(12);
		~vKeys.allNotesOff(13);
		~vKeys.allNotesOff(14);
		~vKeys.allNotesOff(15);
		~vKeys.allNotesOff(16);

	}

}