{SinOsc.ar(440)}.play;


{SinOsc.ar(440)*EnvGen.kr(Env.perc(0.01, 4.9, 0.8), doneAction: 2)}.play;
{Saw.ar(440)*EnvGen.kr(Env.perc(0.01, 2.9, 0.8), doneAction: 2)}.play;
{Pulse.ar(440)*EnvGen.kr(Env.perc(0.01, 0.9, 0.8), doneAction: 2)}.play;


{
	var sig, env;
	sig = SinOsc.ar(440);
	env = EnvGen.kr(Env.perc(0.01, 0.9, 0.8), doneAction: 2);
	sig = sig*env;

}.play;


SynthDef(\sine, {
	arg freq=440, att=0.05, rel=0.5, amp=0.5;
	var sig, env;
	sig = LFSaw.ar(freq);
	env = EnvGen.kr(Env.perc(att, rel, amp), doneAction: 2);
	sig = sig*env;
	Out.ar([0,1], sig);
}).add;

SynthDef(\saw, {
	arg freq=440, att=0.05, rel=0.5, amp=0.5;
	var sig, env;
	sig = Saw.ar(freq);
	env = EnvGen.kr(Env.perc(att, rel, amp), doneAction: 2);
	sig = sig*env;
	Out.ar([0,1], sig);
}).add;

SynthDef(\pulse, {
	arg freq=440, att=0.05, rel=0.5, amp=0.5;
	var sig, env;
	sig = Pulse.ar(freq);
	env = EnvGen.kr(Env.perc(att, rel, amp), doneAction: 2);
	sig = sig*env;
	Out.ar([0,1], sig);
}).add;

Synth(\sine,[\freq, 440]);
Synth(\saw,[\freq, 440]);
Synth(\pulse,[\freq, 440]);

