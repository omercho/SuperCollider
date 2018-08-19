(
//VolcaKeys
~scl2=Scale.major;
~scl3=Scale.minor;
~scl3=Scale.lydian;
~scl3=Scale.hicaz;

Pdef(\vBass1).stop;
Pdef(\vBass1,Pbind(
	\type, \midi, \chan, 0, \midiout,~vBass, \scale, Pfunc({~scl3}, inf),
	\degree, Pseq((0..7).mirror, inf),
	\dur, 0.25,
	\sustain, Pseq([0.1], inf),
	\amp, Pseq([1], inf),
	\mtranspose, Pseq([0], inf),
	\octave, Pseq([2], inf)
));
Pdef(\vBass1).play;


Pdef(\vBass2).stop;
Pdef(\vBass2, Pbind(
	\type, \midi, \chan, 0, \midiout,~vBass, \scale, Pfunc({~scl3}, inf),
	\degree, Pseries(4, Pshuf(#[-7, -2, 2, 3], inf), inf).fold(4, 8),
    \dur, Pseq([Pseq([1/8],4 ), Pseq([0.4, 2, 1.5],2 )], inf),
	\sustain, Pseq([ 0.3], inf),
	\amp, Pseq([Pseq([0.75],4 ), Pseq([1],2 )], inf),
	\mtranspose, Pseq([Pseq([0],4 ), Pseq([1,5],2 )], inf),
	\octave, Pseq([4], inf),
	\stretch, 0
));
Pdef(\vBass2).play;

Pdef(\vBassVCOCut).stop;
Pdef(\vBassVCOCut,
		Pbind(//samp resonator note
			\chan, 0, \ctlNum, ~cutOff,
			\type, \midi, \midicmd, \control, \midiout,~vBass,
			\delta, Pseq([0.5], inf),
			\control, Pseq([120,40, 60,40, 10,40, 80,40],inf)
		//\stretch, 2

		).play;

);
Pdef(\vBassVCOCut).play;


Pdef(\vBass1LFORate).stop;
Pdef(\vBass1LFORate,
		Pbind(//samp resonator note
			\chan, 0, \ctlNum, ~lfoRate,
			\type, \midi, \midicmd, \control, \midiout,~vBass,
			\delta, Pseq([Pseq([0.25],4 ), Pseq([1],2 )], inf),
			\control, Pseq([Pseq([90],4 ), Pseq([91],4 )], inf),

		).play;

);
Pdef(\vBass1LFORate).play;
Pdef(\vBass1LFOCut).stop;
Pdef(\vBass1LFOCut,
		Pbind(//samp resonator note
			\chan, 0, \ctlNum, ~lfoCut,
			\type, \midi, \midicmd, \control, \midiout,~vBass,
			\delta, Pseq([Pseq([1.25],4 ), Pseq([1],2 )], inf),
			\control, Pseq([Pseq([90],4 ), Pseq([100],4 )], inf),

		).play;

);
Pdef(\vBass1LFOCut).play;
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

~vBass.control(0, ~detuneVB, ~mouseSynth.getValue); //detune

)
