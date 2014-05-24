SynthDef(\vBassInput, {
    var in;
	in=SoundIn.ar(2,0.9,0);

	Out.ar(0,Pan2.ar(in, 0));
}).play;

SynthDef(\vKeysInput, {
    var in;
	in=SoundIn.ar(3,0.9,0);

	Out.ar(0,Pan2.ar(in, 0));
}).play;
