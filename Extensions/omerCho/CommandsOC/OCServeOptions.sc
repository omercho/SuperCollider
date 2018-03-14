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
			Server.default.options.device = "iCMIDIAudio";

 			Server.default.options.hardwareBufferSize = 512;
			Server.default.options.sampleRate = 44100.000000;

 			Server.default.doWhenBooted({ "server options OKKK".postln; });
 		}
 	}

 }

