/*
Put Mopho shift buttons in IFSequence.sc


*/

Pbind(
	\chan, 1,
	\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
	\dur,1,
	\degree, 1,
	\amp, 1,
	\sustain, 1,
	\mtranspose, 1,
	\octave, 1,
	\harmonic, 1
).play(quant: 0);