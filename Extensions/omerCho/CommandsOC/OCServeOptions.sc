/*
//A practical commands for MIDI and OSC
//Omer Chatziserif
//Sunday, 22 Dec 2013, 22:55
//Komotini, Greece

PostAllMIDI.on;

*/

 OCServerOptions {


 	*initClass {
 		StartUp add: {
 			//Server.default.options.device = "EDIROL FA-66 (1674)";
			//Server.default.options.inDevice = "EDIROL FA-66 (1674)";
			//Server.default.options.device = "iCMIDIAudio";
			//Server.default.options.inDevice = "Built-in Input";
			//Server.default.options.outDevice = "Built-in Output";

			//Server.default.options.device = "iCMIDIAudio";
 			//Server.default.options.hardwareBufferSize = 128;
			//Server.default.options.sampleRate = 44100.000000;


			//~serverLevels = ServerMeter.new(Server.default, 4, 2);
			//Server.default.doWhenBooted({ "OCSettings - Class:OCServerOptions".postln; });
		}
 	}

 }

