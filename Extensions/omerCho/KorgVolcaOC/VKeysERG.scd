(
//VolcaKeys
~scl2=Scale.major;
~scl3=Scale.minor;
~scl3=Scale.lydian;
~scl3=Scale.hicaz;

Pdef(\vKey1).stop;
Pdef(\vKey1,
Pbind(
	\type, \midi, \chan, 0, \midiout,~vKeys, \scale, Pfunc({~scl3}, inf),
	\degree, Pseries(4, Pshuf([-2, -1, 1, 2], inf), inf).fold(-7, 11),
    \dur, 1.0,
	\sustain, Pseq([Pseq([1.25],4 ), Pseq([0.4, 2],2 )], inf),
	\amp, Pseq([Pseq([0.5],4 ), Pseq([0,7, 0.9],2 )], inf),
	\mtranspose, Pseq([Pseq([0, 4],2 ), Pseq([1,5],2 )], inf),
	\octave, Pseq([3], inf)
);
);
Pdef(\vKey1).play;
Pdef(\vKey2).stop;
Pdef(\vKey2,
Pbind(
	\type, \midi, \chan, 0, \midiout,~vKeys, \scale, Pfunc({~scl3}, inf),
	\degree, Pseries(4, Pshuf(#[-7, -2, 2, 3], inf), inf).fold(4, 8),
    \dur, Pseq([Pseq([1/8],4 ), Pseq([0.4, 2, 1.5],2 )], inf),
	\sustain, Pseq([ 0.3], inf),
	\amp, Pseq([Pseq([0.75],4 ), Pseq([1],2 )], inf),
	\mtranspose, Pseq([Pseq([0],4 ), Pseq([1,5],2 )], inf),
	\octave, Pseq([4], inf),
		\stretch, 0
);
);
Pdef(\vKey2).play;

Pdef(\vKeyVCOCut).stop;
Pdef(\vKeyVCOCut,
		Pbind(//samp resonator note
			\chan, 0, \ctlNum, ~vcoCut,
			\type, \midi, \midicmd, \control, \midiout,~vKeys,
			\delta, Pseq([0.5], inf),
			\control, Pseq([20,40, 60,40, 10,40, 80,40],inf),
		\stretch, 2

		).play;

);
Pdef(\vKeyVCOCut).play;


Pdef(\vKey1LFORate).stop;
Pdef(\vKey1LFORate,
		Pbind(//samp resonator note
			\chan, 0, \ctlNum, ~lfoRate,
			\type, \midi, \midicmd, \control, \midiout,~vKeys,
			\delta, Pseq([Pseq([0.25],4 ), Pseq([1],2 )], inf),
			\control, Pseq([Pseq([90],4 ), Pseq([91],4 )], inf),

		).play;

);
Pdef(\vKey1LFORate).play;
Pdef(\vKey1LFOCut).stop;
Pdef(\vKey1LFOCut,
		Pbind(//samp resonator note
			\chan, 0, \ctlNum, ~lfoCut,
			\type, \midi, \midicmd, \control, \midiout,~vKeys,
			\delta, Pseq([Pseq([1.25],4 ), Pseq([1],2 )], inf),
			\control, Pseq([Pseq([90],4 ), Pseq([100],4 )], inf),

		).play;

);
Pdef(\vKey1LFOCut).play;
)

(
SynthDef.new(\MouseMIDI,{
	var mouseX,mouseY;
	mouseX = MouseX.kr(0,127).round(1);
 	mouseY = MouseY.kr(0,127).round(1);
	// Check if mouse changed, if so, send a new midi reply
 	SendReply.kr(HPZ2.kr(mouseX+mouseY),'mouseMIDI',[mouseX,mouseY]);
	}).store;

o = OSCresponder(nil,'mouseMIDI', { |t,r,msg| msg.postln; /*MIDI STUFF*/ }).add;
~mouseSynth = Synth(\MouseMIDI);
o.remove;

~vKeys.control(0, ~detuneVK, ~mouseSynth.getValue); //detune

)
