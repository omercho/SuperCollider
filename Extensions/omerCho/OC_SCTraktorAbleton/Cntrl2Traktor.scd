
(

MIDIClient.init(0,1);
~md1 = MIDIOut.newByName("IAC Driver", "SC-Abl");
MIDISyncClock.init(0, 0);	// 0 beats, 0 secs
~tc1 = TempoClock(1, 0, Main.elapsedTime.ceil);

)

~tc1.tempo_(218.81/60);
/*
MIDIClient.sources[1].uid //to find the src number
*/
(
~tempoRespond.free;~tempoRespond = CCResponder({ | src, chan, num, val |
	format("CC received. Channel: %, Num: %, Value: %", chan, num, val).postln;
		~tc1.tempo_(1.23*val/60);
},src: 1299467116,chan: 1, num: 1, install: true);
)

(

~keyAdjA1.stop;
~keyAdjA1 = {
	~fade = Pseq([0, 100], inf).asStream;
	inf.do{
		~md1.control(0, 0, ~fade.next);
		"tikkkkk".postln;
		2.0.wait;
		//~md1.control(0, 0, 50);
		//0.5.wait;

	};
}.fork(MIDISyncClock, quant: 1);

)


(

~trans1.stop;
~trans1={
	~fade = Prand((20..100).mirror, inf).asStream;
	inf.do{
		~md1.control(0, 0, ~fade.next);

		1.00.wait;
	};
}.fork;

)

s.boot;
t = Task({
	var	synth;
	loop {
		#[60, 62, 64, 65, 67, 65, 64, 62].do({ |note|
			s.makeBundle(0.2, {
				synth = Synth(\default, [freq: note.midicps])
			});

			s.makeBundle(0.4, {
				synth.release;
			});
			0.25.wait;
		});
	}
}).play(MIDISyncClock, quant: 1);