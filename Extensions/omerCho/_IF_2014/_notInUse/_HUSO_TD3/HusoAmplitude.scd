//SoundIn Trigger


( // trigger a synth
SynthDef("help-EnvGen",{ arg out=0;
	Out.ar(out,
		EnvGen.kr(Env.perc(0.001, 0.2),1.0,doneAction: 2)
			* SinOsc.ar(440,0,Amplitude.kr(SoundIn.ar(0, 2.2)))*Trig.ar(Saw.ar(18), LFNoise2.ar(4, 0.5, 5))
	)
}).send(s);

// This synth has no output. It only checks amplitude of input and looks for a transition from > 0.2
// to < 0.2

SynthDef("help-<= trig", {
	SendTrig.kr(Amplitude.kr(SoundIn.ar(0)) <= 0.005);
}).play(s);

// responder to trigger synth
OSCresponderNode(s.addr,'/tr',{
	"triggered".postln;
	Synth.new("help-EnvGen");
	IFBass_SC(~tmBassP.next);
}).add;
)


(
SynthDef('digDrum', {
	var in, sinyal;

	p= Trig.ar(Saw.ar(18), LFNoise2.ar(4, 0.5, 5));
	y= SinOsc.ar(p*SoundIn.ar(0, 0.2));
	z= SinOsc.ar(p* LFNoise2.ar(4, 0.5, 5));
	in = GrainIn.ar(
			2, 	//channelNum
			y, 	//trigger
			y,	//duration-the size of the grain
			z,	//input to granulate
			p*z,	//pan
			-1	//buf num containing a singal to use for the grain envelope. -1 uses a built-in Hanning envelope.
		);
	in = in * Amplitude.kr(SoundIn.ar(0, 0.1), mul:1.0);
	sinyal = GVerb.ar(
		in,
		20.2, //room
		4,
		0.4
	)*8;
	Out.ar(0, sinyal*2);
}).send(Server.default);

~drum = Synth(\digDrum);
)
