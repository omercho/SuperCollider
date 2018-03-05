/*

PostAllMIDI.on;
PostAllMIDI.off;


*/
ElasticDrum{
	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({this.load; });
		}
	}
	*load{
		~elstcClockOut = MIDIClockOut("iConnectMIDI4+", "USB3 usb1", TempoClock.default);
		("Elastic Drum Loaded").postln;
	}
	*playPatterns{
		~elstcClockOut.play;
		~iCElstc1=Pbind(
			\chan, Pseq([0], inf),
			\type, \midi, \midiout,~elstc,
			\octave,0,
			\dur, Pseq([1.0],inf),
			\note, Pseq([1], inf),
			\amp, Pseq([1], inf)
		).play(MIDISyncClock, quant: 0);
		~iCElstc2=Pbind(
			\chan, Pseq([0], inf),
			\type, \midi, \midiout,~elstc,
			\octave,0,
			\dur, Pseq([2.0],inf),
			\note, Pseq([2], inf),
			\amp, Pseq([0,1], inf)
		).play(MIDISyncClock, quant: 0);
		~iCElstc3=Pbind(
			\type, \midi, \midiout,~elstc,
			\chan, Pseq([0], inf),\octave,0,
			\dur, Pseq([0.5],inf),
			\note, Pseq([3], inf),
			\amp, Pseq([0,1,0,1], inf)
		).play(MIDISyncClock, quant: 0);
		~iCElstc4=Pbind(
			\type, \midi, \midiout,~elstc,
			\chan, Pseq([0], inf),\octave,0,
			\dur, Pseq([0.5],inf),
			\note, Pseq([4], inf),
			\amp, Pseq([1], inf)
		).play(MIDISyncClock, quant: 0);
	}
	*stopPatterns{
		~elstcClockOut.stop;
		~iCElstc1.stop;
		~iCElstc2.stop;
		~iCElstc3.stop;
		~iCElstc4.stop;
		~iCElstc5.stop;
		~iCElstc6.stop;
	}

}