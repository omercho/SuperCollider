~trig3 = OSCFunc({
	arg msg;
	if ( msg[1]==3, {
		"post 3".postln;
		{
			SinOsc.ar([440,260,1200].choose)
			*EnvGen.kr(Env.perc(0.01, 4.9, 0.8), doneAction: 2)}.play;
	});
	},
	'/trigger'
);

~trig4 = OSCFunc({
	arg msg;
	if ( msg[1]==4, {
		"post 4".postln;
		{Saw.ar([440,260,1200].choose)*EnvGen.kr(Env.perc(0.01, 2.9, 0.8), doneAction: 2)}.play;
	});
	},
	'/trigger'
);

~trig5 = OSCFunc({
	arg msg;
	if ( msg[1]==5, {
		"post 5".postln;
		{Pulse.ar((52..1500).choose)*EnvGen.kr(Env.perc(0.01, 0.9, 0.8), doneAction: 2)}.play;

	});
	},
	'/trigger'
);



{SinOsc.ar(440)*EnvGen.kr(Env.perc(0.01, 4.9, 0.8), doneAction: 2)}.play;

{Saw.ar(440)*EnvGen.kr(Env.perc(0.01, 2.9, 0.8), doneAction: 2)}.play;

{Pulse.ar(440)*EnvGen.kr(Env.perc(0.01, 0.9, 0.8), doneAction: 2)}.play;
