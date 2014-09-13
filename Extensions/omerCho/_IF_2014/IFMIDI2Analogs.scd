MIDIdef.noteOn(\noteOnUMA).free;
MIDIdef.noteOn(\noteOnUMA, {
	arg vel, nn, chan, src;
	[nn,vel].postln;
	~notes[nn] = Synth.new(
		\IFSamp_SC,
		[
			\freq, nn.midicps,
			\amp, vel.linexp(1, 127, 0.01,0.3),
			\gate, 1,
			\bend, ~bend.linlin(0, 16383, -2, 2),

		]
	);
});

MIDIdef.noteOff(\noteOffUMA).free;
MIDIdef.noteOff(\noteOffUMA, {
	arg vel, nn, chan, src;
	[nn,vel].postln;
	~notes[nn].set(\gate, 0);
	~notes[nn] = nil;
});

MIDIdef.bend(\bendUMA, {
	arg val, chan, src;
	[chan,val].postln;
	~bend = val;
	~notes.do{arg synth; synth.set(\bend, val.linlin(0, 16383, -2, 2))};
});

(
~notes = Array.newClear(128);

MIDIdef.noteOn(\noteOnKeys).free;
MIDIdef.noteOn(\noteOnKeys, {
	arg vel, nn, chan, src;
	[chan,nn,vel,src].postln;
	~vKeys.noteOn(0,nn, vel);
});


MIDIdef.noteOff(\noteOffKeys).free;
MIDIdef.noteOff(\noteOffKeys, {
	arg vel, nn, chan, src;
	[chan, nn,vel,src].postln;
	~vKeys.noteOff(0,nn, vel);

});

)

(

MIDIdef.noteOn(\noteOnKeys).free;
MIDIdef.noteOn(\noteOnKeys, {
	arg vel, nn, chan, src;
	if( src==(-389640848), {
		~vKeys.noteOn(0,nn, vel);
		[chan,nn,vel,src].postln;
	});

});


MIDIdef.noteOff(\noteOffKeys).free;
MIDIdef.noteOff(\noteOffKeys, {
	arg vel, nn, chan, src;
	if( src==(-389640848), {
		~vKeys.noteOff(0,nn, vel);
		[chan,nn,vel,src].postln;
	});

});

)

(

MIDIdef.noteOn(\noteOnKeys).free;
MIDIdef.noteOn(\noteOnKeys, {
	arg vel, nn, chan, src;
	if( src==(-389640848), {
		~vBass.noteOn(0,nn, vel);
		[chan,nn,vel,src].postln;
	});

});


MIDIdef.noteOff(\noteOffKeys).free;
MIDIdef.noteOff(\noteOffKeys, {
	arg vel, nn, chan, src;
	if( src==(-389640848), {
		~vBass.noteOff(0,nn, vel);
		[chan,nn,vel,src].postln;
	});

});

)


(

MIDIdef.noteOn(\noteOnKeys).free;
MIDIdef.noteOn(\noteOnKeys, {
	arg vel, nn, chan, src;
	if( src==(-389640848), {
		~vKeys.noteOn(0,nn, vel);
		~vBass.noteOn(0,nn, vel);
		[chan,nn,vel,src].postln;
	});

});


MIDIdef.noteOff(\noteOffKeys).free;
MIDIdef.noteOff(\noteOffKeys, {
	arg vel, nn, chan, src;
	if( src==(-389640848), {
		~vKeys.noteOff(0,nn, vel);
		~vBass.noteOff(0,nn, vel);
		[chan,nn,vel,src].postln;
	});

});

)

~vKeys.noteOn(0,60,127);

~vKeys.allNotesOff(0);