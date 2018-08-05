/*

PostAllMIDI.on;
PostAllMIDI.off;


*/

DataJokey{
	*initClass {
		StartUp add: {
			//Server.default.doWhenBooted({this.load; });
		}
	}
	*load{
		MIDISyncClock.init(0, 0);	// 0 beats, 0 secs
		~clock1 = TempoClock.default;
		this.clockResponder;
		IFiConnectMIDI4.load;
		("Data Jokey Successfully Loaded").postln;
	}
	*clockResponder{
		/*~tempoRespond.remove;
		~tempoRespond = CCResponder({ | src, chan, num, val |
			format("CC received. Channel: %, Num: %, Value: %", chan, num, val).postln;
			~clock1.tempo_((1.23*val/60));
		},src: 1980474828,chan: 0, num: 0, install: true);*/
	}
	*deck1{
		~keyAdjA1.stop;
		~keyAdjA1 = {
			~fade = Pseq([30, 50,75, 100], inf).asStream;
			inf.do{
				~iC_Mac.control(0, 0, ~fade.next);
				"tikkkkk".postln;
				2.0.wait;
				//~md1.control(0, 0, 50);
				//0.5.wait;

			};
		}.fork(MIDISyncClock, quant: 1);
	}

}