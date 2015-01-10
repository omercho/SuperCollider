
(
PostAllMIDI.on;
MIDIClient.init(0,1);
)
(
~md1 = MIDIOut.newByName("IAC Driver", "SC-Abl");
MIDISyncClock.init(0, 0);	// 0 beats, 0 secs
~tc1 = TempoClock(1, 0, Main.elapsedTime.ceil);
~scl1 = Scale.chromatic;
~scl2 = Scale.chinese;
~scl2 = Scale.indian;
~scl2 = Scale.phrygian;
~scl2 = Scale.bartok;
~scl2 = Scale.egyptian;

)

(
~vKick = 36;
~vSnr = 38;
~vTomL = 43;
~vTomH = 50;
~vHatC = 42;
~vHatO = 46;
~vClap = 39;
~vCalv = 75;
~vAgog = 67;
~vCrsh = 49;
)

~tc1.tempo_(218.81/60);



(
~tempoRespond.free;~tempoRespond = CCResponder({ | src, chan, num, val |
	format("CC received. Channel: %, Num: %, Value: %", chan, num, val).postln;
	~tc1.tempo_(1.23*val/60);
},src: -1668114248, chan: 1, num: 1, install: true); //"IAC Driver" "LocalClock" = src: -1668114248
)


(
Pdef(\VBKick).stop;
Pdef(\VBHats).stop;
Pdef(\VBToms).stop;
Pdef(\VBPcm).stop;
Pdef(\VBass).stop;
Pdef(\VKeys).stop;
Pdef(\Canadian).stop;
)
(
Pdef(\VBKick).play(MIDISyncClock, quant: 1);
Pdef(\VBHats).play(MIDISyncClock, quant: 1);
Pdef(\VBToms).play(MIDISyncClock, quant: 1);
Pdef(\VBPcm).play(MIDISyncClock, quant: 1);
Pdef(\VBass).play(MIDISyncClock, quant: 1);
Pdef(\VKeys).play(MIDISyncClock, quant: 1);
Pdef(\Canadian).play(MIDISyncClock, quant: 1);
)

//1
(
~scl2 = Scale.chinese;
Pdef(\VBKick, Pbind(
	\type, \midi, \chan, 0, \midiout,~md1, \scale, Pfunc({~scl1}, inf),\octave, 0,
	\dur, Pseq([1,1,1, 1, 0.5, 0.5], inf),
	\note, Pseq([~vKick], inf),
	\amp, Pser([0.9,0.0,0.3,0.0,0.8, 0], inf,0),

));
Pdef(\VBHats, Pbind(
	\type, \midi, \chan, 0, \midiout,~md1, \scale, Pfunc({~scl1}, inf),\octave, 0,
	\dur, Pseq([0.5, 0.5, 1, 0.5, 0.5, 2], inf),
	\note, Pxrand([
		Pseq([[~vCrsh,~vHatC,~vHatO],Pseq([~vHatC],5),~vHatO,Pseq([~vHatC],9), ~vCrsh],inf)
	],inf),
	\amp, Pser([0.7,0.9,0.3,0.7,0.8], inf,0),

));
Pdef(\VBToms, Pbind(
	\type, \midi, \chan, 0, \midiout,~md1, \scale, Pfunc({~scl1}, inf),\octave, 0,
	\dur, Pseq([1,1, 1, 0.5, 0.5, 1], inf),
	\note, Pseq([~vTomH, ~vTomL, ~vSnr, ~vClap, ~vSnr], inf),
	\amp, Pser([0.0,0.3,0.0,0.8], inf,0),

));
Pdef(\VBPcm, Pbind(
	\type, \midi, \chan, 0, \midiout,~md1, \scale, Pfunc({~scl1}, inf),\octave, 0,
	\dur, Pseq([0.5, 0.5, 1, 0.5, 0.5, 2]*2, inf),
	\note, Pseq([
		Pseq([~vCalv,~vAgog],6), [~vAgog,~vCalv]
	],inf),
	\amp, Pser([0.0,0.9,0.3,0.0,0.8], inf,0),

));

Pdef(\VBass, Pbind(
	\type, \midi, \chan, 1, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
	\dur, Pseq([0.5, 0.5, 1, 0.5, 0.5, 2], inf),
	\degree, Pseq((0..7).mirror, inf),
	\amp, Pser([0.7,0.9,0.3,0.7,0.8], inf,0),
	\sustain, Pser([0.1,0.2,0.1,0.7,0.5], inf,0)*0.5,
	\mtranspose, Pseq([Pseq([0], 8), Pseq([4], 2), Pseq([7], 2)], inf),
	\octave, Pseq([2,3,4,3,2,4], inf),
));

Pdef(\VKeys, Pbind(
	\type, \midi, \chan, 2, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
	\dur, Pxrand([0.5, 0.5, 1, 0.5, 0.5, 2], inf),
	\degree, Pseq((0..7).mirror, inf),
	\amp, Pser([0.3,0.2,0.3,0.7,0.8], inf,0),
	\sustain, Pser([0.9,0.2,0.3,0.7,0.8], inf,0)*0.8,
	\mtranspose, Pseq([Pseq([0], 8), Pseq([4], 2), Pseq([7], 2)], inf),
	\octave, Pxrand([3,2,4,3,5,6], inf),
));

Pdef(\Canadian, Pbind(
	\type, \midi, \chan, 3, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
	\dur, Pxrand([0.5, 0.5, 1, 0.5, 0.5, 2]*2, inf),
	\degree, Pseq([0,2,4,6,8,10,12, 14].mirror, inf),
	\amp, Pser([0.3,0.2,0.3,0.7,0.8], inf,0),
	\sustain, Pser([0.9,0.2,0.3,0.7,0.8], inf,0)*0.8,
	\mtranspose, Pseq([Pseq([0], 8), Pseq([4], 2), Pseq([7], 2)], inf),
	\octave, Pxrand([3,2,4,3,5,6], inf),
));

)






(
Pbind(
	\type, \midi, \chan, 1, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
	\dur, Pseq([0.5], inf),
	\degree, Pseq((0..7).mirror, inf),
	\amp, Pseq([0.9], inf),
	\sustain, Pseq([0.5], inf),
	\mtranspose, Pseq([0], inf),
	\octave, 3
).play;
)