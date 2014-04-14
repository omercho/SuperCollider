PostAllOSC.on;

(
SynthDef(\synth1, { |out, freq1=100, freq2=200, freq3=300, sustain = 1, amp = 0.5|
    var src;

	src = LFSaw.ar([freq1, freq2, freq3], 0, amp);

	Out.ar(out, src);
}).load;

~trancOSC.remove;
~trancOSC = OSCFunc({
	arg msg;
	if ( msg[1]=='play', { "PLAYYYYY".postln; ~s1=Synth(\synth1); });
	if ( msg[1]=='stop', { "STOPPPPP".postln; ~s1.free; });
	},
	'/transport'
);

~curs2OSC.remove;
~curs2OSC = OSCFunc({
	arg msg;
	if ( msg[1]==2, {
		"cursRecieve".postln;
		~s1.set(
			\freq1,msg[3],
			\freq2,msg[4],
			\freq3,msg[5]
		);

	})},
	'/cursor'
);

)
~s1.set(\frX,150*1, \frY,150*1.5, \frZ,240*2); 