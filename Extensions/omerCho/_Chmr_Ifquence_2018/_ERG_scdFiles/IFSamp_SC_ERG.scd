(
SynthDef( \IFSamp_SC, { | amp = 1, sustain = 1.1, freq = 60, freqlp=50,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 400, pan=0, cut1=0.5,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.02, rls = 0.2 |

	var in, osc, env, lfo1, lfo2, ses;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 4.2);
	env =  EnvGen.ar(Env.perc(att, rls), doneAction: 2, levelScale: 0.8, timeScale: sustain);
	in = Saw.ar(SinOsc.ar(freq, 0, brown), 0.6);
	ses = SinOsc.ar(freq, in, 0.8) ;
	ses = RLPF.ar(ses, freq*lfo1, cut1, 1.0, 0.6 );
	ses = lfo1*2+(ses.cos(14.2)* LFSaw.ar(freq, Decay.ar(SinOsc.ar(sin1, sin2), 4.2.abs, Saw.ar(saw))));
	ses = Limiter.ar(ses, 0.9, 0.01);
	//ses = DelayN.ar( ses, 3.5, 0.01, 1.5, 0.0, 2.1, ses);
	ses = 4*ses*amp *env;
	//ses = Limiter.ar(ses, 0.9, 0.01);
	Out.ar(0, Pan2.ar(ses, pan));
}).add;
)

(
SynthDef( \IFSamp_SC, { | amp = 1, sustain = 1.1, freq = 60, freqlp=50,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 400, pan=0, cut1=0.5,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.02, rls = 0.2 |

	var in, osc, env, lfo1, lfo2, ses;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 4.2);
	lfo2 = LFTri.kr(lfo2Rate).range(1.0, 0.99);
	env =  EnvGen.ar(Env.perc(att, rls), doneAction: 2, levelScale: 0.8, timeScale: sustain);

	in = VarSaw.ar(SinOsc.ar(freq, 0, brown), 0.6);
	ses = SinOsc.ar(freq, in, 0.8) ;
	ses = RLPF.ar(ses, freq*lfo1, cut1, 1.0, 0.6 );
	ses = lfo1*(ses* SyncSaw.ar(freq*lfo2/2, Decay2.ar(VarSaw.ar(sin1, sin2), 2.2.abs, VarSaw.ar(saw))));
	ses = Limiter.ar(ses, 0.9, 0.01);
	//ses = DelayN.ar( ses, 3.5, 0.01, 1.5, 0.0, 2.1, ses);
	ses = 5*ses*amp *env;
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(0, Pan2.ar(ses, pan));
}).add;
)

(
SynthDef( \IFSamp_SC, { | amp = 1, sustain = 1.1, freq = 60, freqlp=50,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 400, pan=0, cut1=0.5,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.005, rls = 0.2 |

	var in, osc, env, lfo1, lfo2, ses;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 4.2);
	lfo2 = LFSaw.kr(lfo2Rate).range(1.0, 0.99);
	env =  EnvGen.ar(Env.perc(att, rls), doneAction: 2, levelScale: 0.8, timeScale: sustain);

	in = Blip.ar(SinOsc.ar(freq, 0, brown), 0.6*lfo1);
	ses = Blip.ar(freq, in, 0.8) ;
	ses = RLPF.ar(ses, freq*lfo1, cut1, 1.0, 0.6* lfo1);
	ses = lfo2*(ses* SinOsc.ar(freq*lfo2, Decay2.ar(Blip.ar(sin1, sin2), 0.2, Blip.ar(saw))));
	ses = Limiter.ar(ses, 0.9, 0.01);
	//ses = DelayN.ar( ses, 3.5, 0.01, 1.5, 0.0, 2.1, ses);
	ses = 5*ses*amp *env;
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(0, Pan2.ar(ses, pan));
}).add;
)

(
SynthDef( \IFSamp_SC, { | amp = 1, sustain = 1.1, freq = 60, freqlp=50, mul=0.9,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 400, pan=0, cut1=0.5,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.145, rls = 0.2 |

	var in, osc, env, lfo1, lfo2, ses;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 4.2);
	lfo2 = Blip.kr(lfo2Rate).range(1.0, 0.99);
	env =  EnvGen.ar(Env.perc(att, rls), doneAction: 2, levelScale: 0.8, timeScale: sustain);

	in = VarSaw.ar(Blip.ar(freq, 0, brown), 0.6*lfo2);
	ses = LFPulse.ar(freq*lfo2, in*lfo2, 0.8) ;
	ses = RLPF.ar(ses, freq*lfo1, cut1, 1.0, 0.6* lfo1);
	ses = (ses* LFSaw.ar(freq*lfo2, Decay2.ar(SyncSaw.ar(sin1, sin2), 0.8, LFSaw.ar(saw*lfo2))));

	ses = DelayC.ar( ses, 0.5, 0.001, 4.5, 0.0, ses);
	ses = 1*ses*amp *env;
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(0, Pan2.ar(ses, pan, mul)*0.05);
}).add;
)

(
SynthDef( \IFSamp_SC, { | amp = 1, sustain = 1.1, freq = 60, freqlp=50, mul=0.9,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 400, pan=0, cut1=0.5,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.5, rls = 0.2 |

	var in, osc, env, lfo1, lfo2, ses;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 0.99);
	env =  EnvGen.ar(Env.perc(att, rls), doneAction: 2, levelScale: 0.8, timeScale: sustain);

	in = Saw.ar(SinOsc.ar(freq*lfo1, 0, brown), 0.7)*0.9;
	ses = LFPulse.ar(freq*lfo2, in*lfo2, 0.8) ;
	ses = RLPF.ar(ses, freq*lfo1, cut1, 1.0, 0.6* lfo1);
	ses = (ses.sin* LFSaw.ar(freq*lfo2, Decay2.ar(SyncSaw.ar(sin1, sin2), 0.8, LFSaw.ar(saw*lfo2))));

	ses = DelayC.ar( ses, 0.5, 0.001, 4.5, 0.0, ses);
	ses = (ses*amp *env)/10.01.sin**in;
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(0, Pan2.ar(ses, pan, mul*0.06));
}).add;
)

(
SynthDef( \IFSamp_SC, { |out, amp = 1, sus = 1.1, freq = 60, freqlp=50, mul=0.9, gate=1,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 400, pan=0, cut1=0.5,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.005, dec=0.02, rel = 0.02 |

	var in, osc, env, lfo1, lfo2, ses;
	lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 0.99);
	//env =  EnvGen.ar(Env.perc(att, rel), doneAction: 2, levelScale: 0.8, timeScale: sus);
	env = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);

	in = LFSaw.ar(SinOsc.ar(freq*lfo2, 0, brown), 0.7)*0.9;
	ses = LFSaw.ar(freq*lfo2, in*lfo2, 0.8) ;
	ses = RLPF.ar(ses, freq*lfo1, cut1, 1.0, 0.6* lfo1);
	ses = (ses.sin(-19.4)* LFSaw.ar(freq*lfo2, Decay2.ar(SinOsc.ar(sin1, sin2), 0.8, LFSaw.ar(saw*lfo2))))*0.5;

	ses = DelayC.ar( ses, 0.5, 0.001, 4.5, 0.0, ses);
	ses = (ses*amp *env)**1.cos(-10.2)**in;
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(out, Pan2.ar(ses, pan, mul*0.6));
}).add;
)


(
SynthDef( \IFSamp_SC, { |out, amp = 1, sus = 1.1, freq = 60, freqlp=50, mul=0.9,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 400, pan=0, cut1=0.5, gate=1,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.005, dec=0.02, rel = 0.02 |

	var in, osc, env,ses;
	var lfo1, lfo2, decay;
	lfo1 = LFSaw.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = Saw.kr(lfo2Rate).range(1.0, 0.95);
	//env =  EnvGen.ar(Env.perc(att, rel), doneAction: 2, levelScale: 0.8, timeScale: sus);
	env = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);
	decay = Decay2.ar(
		SinOsc.ar(sin1, sin2),
		Saw.ar(sin1, sin2)*4.2,
		Saw.ar(saw)
	);

	in = LFSaw.ar(LFPulse.ar(freq, 2, brown), 0.7)*0.9;
	ses = SinOsc.ar(freq+decay, in*lfo2, 0.8);
	ses = RLPF.ar(ses, freq*lfo2, cut1, 0.9, 0.6);
	ses = (
		ses
		* SinOsc.ar(
			freq*lfo2,

			decay
		)
	);

	//ses = DelayC.ar( ses, 0.5, 0.001, 4.5, 0.0, ses);
	ses = (ses*amp *env);
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(out, Pan2.ar(ses, pan, mul*0.3));
}).add;

)

(
SynthDef( \IFSamp_SC, { |out, amp = 1, sus = 1.1, freq = 60, freqlp=50, mul=0.9,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 400, pan=0, cut1=0.5, gate=1,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.005, dec=0.02, rel = 0.02 |

	var in, osc, env,ses;
	var lfo1, lfo2, decay;
	lfo1 = LFSaw.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = Saw.kr(lfo2Rate).range(1.0, 0.95);
	//env =  EnvGen.ar(Env.perc(att, rel), doneAction: 2, levelScale: 0.8, timeScale: sus);
	env = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);
	decay = Decay2.ar(
		SinOsc.ar(sin1, sin2),
		Saw.ar(sin1, sin2)*4.2,
		Saw.ar(saw)
	);

	in = LFSaw.ar(LFPulse.ar(freq, 2, brown), 0.7)*0.9;
	ses = SinOsc.ar(freq+decay, in*lfo2, 0.8);
	ses = RLPF.ar(ses, freq*lfo2, cut1, 0.9, 0.6);
	ses = (
		ses
		* SinOsc.ar(
			freq*lfo2,

			decay
		)
	);

	//ses = DelayC.ar( ses, 0.5, 0.001, 4.5, 0.0, ses);
	ses = (ses*amp *env);
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(out, Pan2.ar(ses, pan, mul*0.3));
}).add;

)

(
SynthDef( \IFSamp_SC, { |out, amp = 1, sus = 1.1, freq = 60, freqlp=50, mul=0.9,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 400, pan=0, cut1=0.5, gate=1,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.05, dec=0.02, rel = 0.02 |

	var in, osc, env,ses;
	var lfo1, lfo2, decay;
	lfo1 = Saw.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = LFTri.kr(lfo2Rate).range(1.0, 0.95);
	//env =  EnvGen.ar(Env.perc(att, rel), doneAction: 2, levelScale: 0.8, timeScale: sus);
	env = EnvGen.ar(Env.adsr(att, dec, sus, rel), gate, doneAction:2);
	decay = Decay2.ar(
		SinOsc.ar(sin1, sin2),
		LFSaw.ar(sin2, sin1)*2.2,
		Saw.ar(saw)
	);

	in = SinOsc.ar(LFPulse.ar(freq, 2, brown), 0.7)*0.9;
	ses = SinOsc.ar(freq, in*lfo2, 0.8);
	ses = RLPF.ar(ses, freq*lfo2, cut1, 0.9, 0.6);
	ses = 0.5*(ses*SinOsc.ar(freq*lfo2,decay));

	//ses = DelayC.ar( ses, 0.5, 0.001, 4.5, 0.0, ses);
	ses = (ses*amp *env);
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(out, Pan2.ar(ses, pan, mul*0.1));
}).add;

)

(
SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=50, mul=0.9,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 400, pan=0, cut1=0.5, gate=1,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.05, dec=0.02, rel = 0.02 |

	var in, osc, env,ses;
	var lfo1, lfo2, decay;
	lfo1 = Saw.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = LFTri.kr(lfo2Rate).range(1.0, 0.95);
	//env =  EnvGen.ar(Env.perc(att, rel), doneAction: 2, levelScale: 0.8, timeScale: sus);
	env = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
	decay = Decay2.ar(
		SinOsc.ar(sin1, sin2),
		LFSaw.ar(sin2, sin1)*2.2,
		Saw.ar(saw)
	);

	in = SinOsc.ar(LFPulse.ar(freq, 2, brown), 0.7)*0.9;
	ses = SinOsc.ar(freq, in*lfo2, 0.8);
	ses = RLPF.ar(ses, freq*lfo2, cut1, 0.9, 0.6);
	ses = 0.8*(ses*SinOsc.ar(freq*lfo2,decay));

	ses = DelayC.ar( ses, 0.5, 0.001, 4.5, 0.0, ses);
	ses = (ses*amp*env);
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(out, Pan2.ar(ses, pan, mul*0.1));
}).add;

)

(
SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=50, mul=0.9,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 400, pan=0, cut1=0.5, gate=1,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.05, dec=0.02, rel = 0.02 |

	var in, osc, env,ses;
	var lfo1, lfo2, decay;
	lfo1 = Saw.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = LFTri.kr(lfo2Rate).range(1.0, 0.95);
	//env =  EnvGen.ar(Env.perc(att, rel), doneAction: 2, levelScale: 0.8, timeScale: sus);
	env = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
	decay = Decay2.ar(
		Blip.ar(sin1, sin2),
		Blip.ar(sin2, sin1)*2.2,
		LFSaw.ar(saw)
	);

	in = Blip.ar(LFPulse.ar(freq, 2, brown), 0.7)*0.9;
	ses = Blip.ar(freq, in*lfo2, 0.8);
	ses = RLPF.ar(ses, freq*lfo2, cut1, 0.9, 0.6);
	ses = 0.5*(ses*SinOsc.ar(freq*lfo2,decay));

	ses = DelayC.ar( ses, 0.5, 0.001, 4.5, 0.0, ses);
	ses = (ses*amp*env);
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(out, Pan2.ar(ses, pan, mul*0.1));
}).add;

)

(
Pdef(\fft01,
	Pbind(
		\instrument, \IFSamp_SC,
		\octave, 3.0,
		\dur, 1/4,
		\amp, 0.9,
		\degree, Pseq([0,1,2,5,8,14,-14, 18], inf),
		\sustain,Pseq([2.1, 0.1, 1, 0.2, 1.2, 0.1, 0.3], inf)*0.9,
		\mtranspose, ,
		\brown, Pbrown(0.0, 1.0, 0.125, inf),
		\saw, Pbrown(0.4, 100.0, 0.125, inf),
		\cut1, Pbrown(0.0, 1.0, 0.125, inf),
		\sin1, Pbrown(0.4, 100.0, 0.125, inf),
		\sin2, Pbrown(0.4, 100.0, 0.125, inf),

	)
);
)
Pdef(\fft01).play;



///////////////////
(
SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=50, mul=0.5,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.5, gate=1,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.05, dec=0.02, rel = 0.02 |

	var in, osc, env,ses;
	var lfo1, lfo2, decay;
	lfo1 = Saw.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = LFTri.kr(lfo2Rate).range(1.0, 0.95);
	//env =  EnvGen.ar(Env.perc(att, rel), doneAction: 2, levelScale: 0.8, timeScale: sus);
	env = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
	decay = Decay2.ar(
		SinOsc.ar(sin1, sin2),
		LFSaw.ar(sin2, sin1)*1.2,
		Saw.ar(saw)
	);

	in = SinOsc.ar(LFPulse.ar(freq, cut1, brown), 0.7)*0.9;
	ses = SinOsc.ar(freq, in*lfo2, 0.8);
	ses = RLPF.ar(ses, freq*lfo2, cut1, 0.9, 0.6);
	ses = 0.5*(ses*SinOsc.ar(freq*lfo2,decay));

	ses = DelayC.ar( ses, 0.1, 0.001, 4.5, 0.0, ses);
	ses = (ses*amp*env);
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(out, Pan2.ar(ses, pan, mul));
}).add;
)

(
SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=50, mul=0.5,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.5, gate=1,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.05, dec=0.02, rel = 0.02 |

	var in, osc, env,ses;
	var lfo1, lfo2, decay;
	lfo1 = Saw.kr(lfo1Rate).range(1.0, 3.2);
	lfo2 = LFTri.kr(lfo2Rate).range(1.0, 4.95);
	//env =  EnvGen.ar(Env.perc(att, rel), doneAction: 2, levelScale: 0.8, timeScale: sus);
	env = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
	decay = Decay2.ar(
		SinOsc.ar(sin1, sin2),
		LFSaw.ar(sin2, sin1)*1.2,
		Saw.ar(saw)
	);

	in = SinOsc.ar(LFPulse.ar(freq, cut1, brown), 0.7)*0.9;
	ses = LFSaw.ar(freq, in*lfo2, brown);
	ses = RLPF.ar(ses, freq*lfo2, cut1, 0.9, 0.6);
	ses = 0.5*(ses*SinOsc.ar(freq*lfo2,decay));

	ses = DelayC.ar( ses, 0.1, 0.001, 4.5, 0.0, ses);
	ses = (ses*amp*env);
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(out, Pan2.ar(ses, pan, mul));
}).add;
)

(

SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=1250, mul=0.7,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=1.05, gate=1,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.05, dec=0.02, rel = 0.02 |

	var in, osc, env,ses;
	var lfo1, lfo2, decay, den;
	lfo1 = Saw.kr(lfo1Rate).range(1.0, 1.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
	den =  LFSaw.ar(freq*lfo2, Decay.ar(SinOsc.ar(sin1, sin2), 4.2.abs, Saw.ar(saw)));
	env = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
	decay = Decay2.ar(
		SinOsc.ar(sin1, sin2),
		LFSaw.ar(sin2, sin1),
		Saw.ar(saw)
	);

	in = LFSaw.ar(LFSaw.ar(freq, cut1, brown), 0.3)*0.3**lfo2;
	ses = LFSaw.ar(freq, den, brown);
	ses = RLPF.ar(Mix.ar(ses,in), freqlp*cut1*lfo2, cut1, 0.9, 0.6);
	ses = 0.8*(ses*SinOsc.ar(freq,decay/den));

	ses = DelayC.ar( ses, 0.01, 0.001*lfo2, 4.5.abs, 0.3, ses);
	ses = (Mix.ar(ses*0.3,den*1.4,in*1.2)*amp*env);
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(out, Pan2.ar(ses, pan, mul));
}).add;

)


(

SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=1250, mul=0.7,
	sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=1.05, gate=1,
	lfo1Rate=1, lfo2Rate=2,
	att = 0.05, dec=0.02, rel = 0.02 |

	var in, osc, env,ses;
	var lfo1, lfo2, decay, den;
	lfo1 = Saw.kr(lfo1Rate).range(1.0, 14.2);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
	den =  LFSaw.ar(freq*lfo2, Decay.ar(SinOsc.ar(sin1, sin2), 1.2, Saw.ar(saw)));
	env = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
	decay = Decay2.ar(
		SinOsc.ar(sin1, sin2),
		LFSaw.ar(sin2, sin1),
		Saw.ar(saw)
	);

	in = LFSaw.ar(LFSaw.ar(freq, cut1, brown), cut1)*lfo2;
	ses = SyncSaw.ar(freq, den, amp);
	ses = RLPF.ar(Mix.ar(ses,in), freq*4, cut1, 0.3, 0.9);
	ses = 0.8*(ses+LFSaw.ar(freq,cut1,amp));

	ses = DelayC.ar( ses, 0.01, 0.4*lfo2, 4.5.abs, 0.3, ses);
	ses = (Mix.ar(ses*0.3,den*1.4,in*1.2)*amp*env);
	//ses = Limiter.ar(ses, 0.9, 0.01);

	Out.ar(out, Pan2.ar(ses, pan, mul));
}).add;

)

(

		SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=1250, mul=0.4,
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.05, gate=1,
			lfo1Rate=1, lfo2Rate=2,
			att = 0.05, dec=0.02, rel = 0.02 |

			var in, osc, env,ses, vco1,vco2,vco3, mix1,mix2, filt1, filt2;
			var lfo1, lfo2, decay, den;
			env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
			vco1=  LFSaw.ar(freq*2,cut1,amp);
			vco2=  LFTri.ar(freq, cut1, amp);
			vco3 = SinOsc.ar(4*freq, cut1, amp);

			mix1 = Mix.ar(vco1*1.7,vco2*1.1, vco3*0.9);

			filt1 = RLPF.ar(mix1, (freq*5)+lfo1, 0.5, amp);
			filt2 = MoogFF.ar(mix1, (freq*5)+lfo1, 4+amp+sin1);

			mix2 = Mix.ar(filt1*0.9,filt2*0.9)*amp;

			ses = Limiter.ar(mix2, 0.9, 0.01)*env;

			Out.ar(out, Pan2.ar(ses, pan, mul));
		}).add;

)

(

		SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=1250, mul=0.4,
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.05, gate=1,
			lfo1Rate=1, lfo2Rate=2,
			att = 0.05, dec=0.02, rel = 0.02 |

			var in, osc, env,env2,ses, vco1,vco2,vco3, mix1,mix2,mix3, filt1, filt2;
			var lfo1, lfo2, decay, gend;
			gend = Gendy3.kr(2, 4,
                SinOsc.kr(0.1,0,0.49,0.51),
                SinOsc.kr(0.13,0,0.49,0.51),
                3.4, 3.5,
                SinOsc.kr(0.17,0,0.49,0.51),
                SinOsc.kr(0.19,0,0.49,0.51),
                10,10,50, 50);
			env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
			env2 =  EnvGen.ar(Env.adsr(0.06, 0.1, 0.2, 0.1,1,-6), gate);
			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
			vco1=  LFSaw.ar(freq/2,cut1, env2);
			vco2=  SinOsc.ar(freq/2,cut1,amp+mul);
			vco3 = SinOsc.ar(freq, Saw.kr(saw*freq/8));

			mix1 = Mix.ar(vco1*0.7,vco2*3.1, vco3*6.9);

			filt1 = RLPF.ar(mix1, (freq*gend)/lfo1, cut1, amp);
			filt2 = MoogFF.ar(mix1, gend*freq/lfo2, lfo1);

			mix2 = Mix.ar(filt1*0.9,filt2*1.9, vco3)*amp*2;
			//ses=BBandPass.ar([mix2+vco3].sum,SinOsc.kr(lfo1).range(freq/4,freq*4),0.9,amp);
			ses = mix2+mix1+vco2;

			ses = Limiter.ar(ses, 1.0, 0.01)*env;

			Out.ar(out, Pan2.ar(ses, pan, mul));
		}).add;

)


(

		SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=1250, mul=0.4,
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.05, cut2=1, gate=1,
			lfo1Rate=1, lfo2Rate=2,
			att = 0.1, dec=0.02, rel = 0.02 |

			var in, osc, ses;
			var env,env2;
			var vco1,vco1F,vco2,vco3, mix1,mix2,mix3, filt1, filt2;
			var lfo1, lfo2, lfo3, decay, gend;
			gend = Gendy3.kr(1, 4,
                SinOsc.kr(0.1,0,0.49,0.51),
                SinOsc.kr(0.13,0,0.49,0.51),
                3.4, 3.5,
                SinOsc.kr(0.17,0,0.49,0.51),
                SinOsc.kr(0.19,0,0.49,0.51),
                10,10,50, 50);
			env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, -6, doneAction:2);
			//env2 =  EnvGen.ar(Env.adsr(0.6, 0.6, susLev, 0.2,1,-7), gate);

			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
			lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

			vco1=  LFSaw.ar(freq,cut1+0.2, Impulse.kr(saw*lfo3).range(freq/2, freq*2));

			vco2=  SinOsc.ar((freq),Impulse.kr(saw*lfo3).range(freq/2, freq*2));
			vco3 = SyncSaw.ar(cut1,(freq),0.2);

			vco1F = FreeVerb.ar(vco1,0.2,0.5*lfo1,0.6*lfo3);

			mix1 = Mix.ar(vco1*0.7,vco2*0.6, vco3*0.9);
			mix1 = FreeVerb.ar(mix1,sin1,0.5,0.5);
			filt1 = RLPF.ar(mix1, SinOsc.kr(0.5).range(20, 1200)*lfo2,lfo1, amp);
			filt2 = MoogFF.ar(mix1, SinOsc.kr(0.4+lfo3).range(400, 4200), 2.0);


			mix2 = Mix.ar(filt1*0.9,filt2*1.9, vco1F/vco1*0.5);
			ses = mix2+(mix1*filt1)+vco3*0.5;
			ses = BPF.ar(ses,~g4/2,0.4,1);
			ses = Limiter.ar(ses, 1.0, 0.01)*env;

			Out.ar(out, Pan2.ar(ses, pan, amp*gend/50));
		}).add;

)

(

		SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=1250, mul=0.4,
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.05, cut2=1, gate=1,
			lfo1Rate=1, lfo2Rate=2,
			att = 0.1, dec=0.02, rel = 0.02 |

			var in, osc, ses;
			var env,env2;
			var vco1,vco1F,vco2,vco3, mix1,mix2,mix3, filt1, filt2;
			var lfo1, lfo2, lfo3, decay, gend, imp;
			gend = Gendy3.kr(1, 4,
                SinOsc.kr(0.1,0,0.49,0.51),
                SinOsc.kr(0.13,0,0.49,0.51),
                3.4, 3.5,
                SinOsc.kr(0.17,0,0.49,0.51),
                SinOsc.kr(0.19,0,0.49,0.51),
                10,10,50, 50);
			imp = Impulse.kr(saw).range(freq, freq*2);
			env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, -6, doneAction:2);
			//env2 =  EnvGen.ar(Env.adsr(0.6, 0.6, susLev, 0.2,1,-7), gate);

			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
			lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

			vco1=  LFSaw.ar(imp,cut1+0.2, imp*0.3);

			vco2=  SinOsc.ar(imp*2,imp*0.3);
			vco3 = SyncSaw.ar(cut1,imp/2,imp*0.1);

			vco1F = FreeVerb.ar(vco1,0.2,0.5*lfo1,0.6*lfo3);

			mix1 = Mix.ar(vco1*0.7,vco2*0.6, vco3*0.9);
			mix1 = FreeVerb.ar(mix1,sin1,0.5,0.5);
			filt1 = RLPF.ar(mix1, SinOsc.kr(0.5).range(20, 1200)*lfo2,lfo1, amp);
			filt2 = MoogFF.ar(mix1, SinOsc.kr(0.4+lfo3).range(400, 4200), 2.0);


			mix2 = Mix.ar(filt1*0.9,filt2*1.9, vco1F/vco1*0.5);
			ses = mix2+(mix1*filt1)+vco3*0.5;
			ses = BPF.ar(ses,~g4/2,0.4,1);
			ses = Limiter.ar(ses, 1.0, 0.01)*env;

			Out.ar(out, Pan2.ar(ses, pan, amp*gend/50));
		}).add;

)

(
//Kick

		SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=1250, mul=0.4,
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.05, cut2=1, gate=1,
			lfo1Rate=1, lfo2Rate=2,
			att = 0.1, dec=0.02, rel = 0.02 |

			var in, osc, ses;
			var env, env1, env2, env3;
			var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
			var lfo1, lfo2, lfo3, decay, gend, imp;
			gend = Gendy3.kr(1, 4,
                SinOsc.kr(0.1,0,0.49,0.51),
                SinOsc.kr(0.13,0,0.49,0.51),
                3.4, 3.5,
                SinOsc.kr(0.17,0,0.49,0.51),
                SinOsc.kr(0.19,0,0.49,0.51),
                10,10,50, 50);
			imp = Saw.kr(saw).range(freq, freq*2)*0.74;
			env =  EnvGen.ar(Env.adsr(att, dec+0.1, susLev, rel+0.1), gate, -6, doneAction:2);
			env1 =  EnvGen.ar(Env.new([0,1,susLev*0.8,0],[att,dec,rel],[-6,-6,-5]), gate);
			env2 =  EnvGen.ar(Env.new([0,1,susLev,0],[0.1,0.1,rel],[-6,-6,-5]), gate);
			env3 =  EnvGen.ar(Env.new([0,0.9,0.5,0],[att,dec,rel+0.1],[-7,-4,-5]), gate);

			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
			lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

			vco1=  LFSaw.ar(imp,cut1+0.2, env1);
			vco2=  SinOsc.ar(imp,env2);
			vco3 = SinOsc.ar(imp,imp*env3);

			vco1F = FreeVerb.ar(vco1,0.2,0.5*lfo1,1);
			vco2F = FreeVerb.ar(vco2,0.9,0.7*lfo2,1);
			vco3F = FreeVerb.ar(vco3,0.3,0.8*lfo3,1);

			mix1 = Mix.ar(vco1*0.7,vco2F*0.6, vco3F*0.9);
			mix1 = FreeVerb.ar(mix1,sin1,0.9,0.9);
			filt1 = RLPF.ar(mix1, SinOsc.kr(0.5).range(90, 1200)*lfo2,lfo1, amp);
			filt2 = MoogFF.ar(mix1, SinOsc.kr(0.4+lfo3).range(400, 8200), 2.0);


			mix2 = Mix.ar(filt1*0.9,filt2*1.9, vco1F/vco1*0.5);
			ses = mix2+(mix1*filt1)+vco1F*0.5+vco1;
			ses = BPF.ar(ses,imp,0.4,imp/2);
			ses = Limiter.ar(ses, 1.0, 0.01)*env;

			Out.ar(out, Pan2.ar(ses, pan, amp*gend/50));
		}).add;

)

(
		SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=1250, mul=0.4,
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.05, cut2=1, gate=1,
			lfo1Rate=1, lfo2Rate=2,
			att = 0.1, dec=0.02, rel = 0.02 |

			var in, osc, ses;
			var env, env1, env2, env3;
			var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
			var lfo1, lfo2, lfo3, decay, gend, imp;
			gend = Gendy3.kr(1, 4,
                SinOsc.kr(0.1,0,0.49,0.51),
                SinOsc.kr(0.13,0,0.49,0.51),
                3.4, 3.5,
                SinOsc.kr(0.17,0,0.49,0.51),
                SinOsc.kr(0.19,0,0.49,0.51),
                10,10,50, 50);
			imp = Saw.kr(saw).range(freq, freq*2);
			env =  EnvGen.ar(Env.adsr(att, dec+0.1, susLev, rel+0.1), gate, -6, doneAction:2);
			env1 =  EnvGen.ar(Env.new([0,1,susLev*0.8,0],[att,dec*0.4,rel],[-6,-2,-5]), gate);
			env2 =  EnvGen.ar(Env.new([0,1,susLev,0],[0.1,0.1,rel*0.8],[-6,-9,-5]), gate);
			env3 =  EnvGen.ar(Env.new([0,susLev*0.6,0.9,0],[att*0.5,dec*0.5,rel+0.01],[-7,-4,-5]), gate);

			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
			lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

			vco1=  LFCub.ar(imp/16*0.1,cut1+0.2, env1);
			vco2=  LFCub.ar(imp/16,cut1+0.2,env2*0.8);
			vco3 = LFPulse.ar(imp/16*0.01,imp*env3*0.2);

			vco1F = FreeVerb.ar(vco1,0.2,0.5*lfo1,1);
			vco2F = FreeVerb.ar(vco2,0.9,0.7*lfo2,1);
			vco3F = FreeVerb.ar(vco3,0.3,0.8*lfo3,1,0.2);

			mix1 = Mix.ar(vco1F*0.7,vco2F*0.6);
			mix1 = FreeVerb.ar(mix1,sin1,0.9,0.9);
			filt1 = RLPF.ar(mix1, SinOsc.kr(0.5).range(90, 1200)*lfo2,lfo1, amp);
			filt2 = MoogFF.ar(mix1, SinOsc.kr(0.4+lfo3).range(400, 8200), 2.0);


			mix2 = Mix.ar(filt1*0.9,filt2*1.9, vco1F/vco1*0.5,vco2);
			ses = mix2+(mix1*filt1)+vco3F*0.5+vco1;
			ses = BPF.ar(ses,440,0.4+cut1,imp/2);
			ses = Limiter.ar(ses, 1.0, 0.01)*env;

			Out.ar(out, Pan2.ar(ses, pan, amp*gend/50));
		}).add;


)

(

		SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=1250, mul=0.4,
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.05, gate=1,
			lfo1Rate=1, lfo2Rate=2,
			att = 0.05, dec=0.02, rel = 0.02 |

			var in, osc, env,env2,ses, vco1,vco2,vco3, mix1,mix2,mix3, filt1, filt2;
			var lfo1, lfo2, decay, gend;
			gend = Gendy3.kr(2, 4,
                SinOsc.kr(0.1,0,0.49,0.51),
                SinOsc.kr(0.13,0,0.49,0.51),
                3.4, 3.5,
                SinOsc.kr(0.17,0,0.49,0.51),
                SinOsc.kr(0.19,0,0.49,0.51),
                10,10,50, 50);
			env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
			env2 =  EnvGen.ar(Env.adsr(0.06, 0.1, 0.2, 0.1,1,-6), gate);
			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
			vco1=  LFSaw.ar(freq/2,cut1, env2);
			vco2=  SinOsc.ar(freq/2,cut1,amp+mul);
			vco3 = SinOsc.ar(freq, Saw.kr(saw*freq/8));

			mix1 = Mix.ar(vco1*0.7,vco2*3.1, vco3*6.9);

			filt1 = RLPF.ar(mix1, (freq*gend)/lfo1, cut1, amp);
			filt2 = MoogFF.ar(mix1, gend*freq/lfo2, lfo1);

			mix2 = Mix.ar(filt1*0.9,filt2*1.9, vco3)*amp*2;
			ses=BBandPass.ar(
		        [mix2+vco3].sum,
		        SinOsc.kr(lfo1).range(freq/4,freq*4),
		        SinOsc.kr(lfo1).range(0,10),amp);
			ses = mix2+mix1+vco2;

			ses = Limiter.ar(ses, 1.0, 0.01)*env;

			Out.ar(out, Pan2.ar(ses, pan, mul));
		}).add;

)

(

		SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=1250, mul=0.4,
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.05, cut2=1, gate=1,
			lfo1Rate=1, lfo2Rate=2,
			att = 0.1, dec=0.02, rel = 0.02 |

			var in, osc, ses;
			var env, env1, env2, env3;
			var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
			var lfo1, lfo2, lfo3, decay, gend, imp;
			gend = Gendy3.kr(1, 4,
                SinOsc.kr(0.1,0,0.49,0.51),
                SinOsc.kr(0.13,0,0.49,0.51),
                3.4, 3.5,
                SinOsc.kr(0.17,0,0.49,0.51),
                SinOsc.kr(0.19,0,0.49,0.51),
                10,10,50, 50);
			imp = Saw.kr(saw).range(freq, freq*2);
			env =  EnvGen.ar(Env.adsr(att, dec+0.1, susLev, rel+0.1), gate, -6, doneAction:2);
			env1 =  EnvGen.ar(Env.new([0,1,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
			env2 =  EnvGen.ar(Env.new([0,1,susLev,0],[0.1,0.3,0.8],[-6,-9,-5]), gate);
			env3 =  EnvGen.ar(Env.new([0,susLev*0.6,0.9,0],[att*0.5,dec*0.5,rel+0.01],[-7,-4,-5]), gate);

			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
			lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

			vco1=  LFCub.ar(imp,cut1+0.2, env1*0.8);
			vco2=  LFCub.ar(imp,cut1+0.2,env2*0.8);
			vco3 = LFCub.ar(imp*0.1,imp*env3*0.2);

			vco1F = FreeVerb.ar(vco1,0.2,0.2*lfo1,1);
			vco2F = FreeVerb.ar(vco2,0.5,0.1*lfo2,1);
			vco3F = FreeVerb.ar(vco3,0.3,0.8*lfo3,1,0.2);

			mix1 = Mix.ar(vco1F*vco1.neg,vco2F*0.6);
			mix1 = FreeVerb.ar(mix1,sin1,0.9,0.9);
			filt1 = RLPF.ar(mix1, SinOsc.kr(0.5).range(90, 1200)*lfo2,lfo1, amp);
			filt2 = MoogFF.ar(mix1, SinOsc.kr(0.4+lfo3).range(400, 8200), 2.0);


			mix2 = Mix.ar(filt1*0.9,filt2*1.9, vco1F/vco1*0.5,vco2);
			ses = mix2+(mix1*filt1)+vco3F*0.5+vco1;
			ses = BPF.ar(ses,440,0.4+cut1,imp/2);
			ses = Limiter.ar(ses, 1.0, 0.01)*env;

			Out.ar(out, Pan2.ar(ses, pan, amp*imp*0.1));
		}).add;

)

(
		SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=1250, mul=0.4,
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.05, cut2=1, gate=1,
			lfo1Rate=1, lfo2Rate=2,
			att = 0.1, dec=0.02, rel = 0.02 |

			var in, osc, ses;
			var env, env1, env2, env3;
			var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
			var trig1;
			var lfo1, lfo2, lfo3, decay, gend, imp;
			gend = Gendy3.kr(1, 4,
                SinOsc.kr(0.1,0,0.49,0.51),
                SinOsc.kr(0.13,0,0.49,0.51),
                3.4, 3.5,
                SinOsc.kr(0.17,0,0.49,0.51),
                SinOsc.kr(0.19,0,0.49,0.51),
                10,10,50, 50);
			trig1 = Trig.ar(Dust.ar(sin1), 0.2) * FSinOsc.ar(0.5, 0, 0.4);
			imp = Saw.kr(saw).range(freq/2, freq*2);
			env =  EnvGen.ar(Env.adsr(att, dec+0.1, susLev, rel+0.1), gate, -6, doneAction:2);
			env1 =  EnvGen.ar(Env.new([0,1,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
			env2 =  EnvGen.ar(Env.new([0,1,susLev,0],[0.1,0.3,0.8],[-6,-9,-5]), gate);
			env3 =  EnvGen.ar(Env.new([0,susLev*0.6,0.2,0],[att*0.5,0.1*dec,rel+0.01],[-7,-4,-2]), gate);

			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
			lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

			vco1=  LFCub.ar(freq,cut1+0.2, env1*0.8);
			vco2=  Dust.ar(imp*2,env2*0.4)*vco1;
			vco3 = Dust.ar(imp,imp*env3*0.2*vco1);

			vco1F = FreeVerb.ar(vco1,0.2,0.2*lfo1,1, trig1*env3);
			vco2F = FreeVerb.ar(vco2,0.9,0.1*lfo2,1, trig1*0.8*env2);
			vco3F = FreeVerb.ar(vco3,0.3,0.1*lfo3,1,trig1*0.5);

			mix1 = Mix.ar(vco1F*vco1.sin,vco2F.sin*0.6);
			mix1 = FreeVerb.ar(mix1,sin1,0.9,0.9);
			filt1 = RLPF.ar(mix1, SinOsc.kr(0.5).range(~c3, ~c4)*lfo2,lfo1, amp);
			filt2 = MoogFF.ar(mix1, SinOsc.kr(0.4+lfo3).range(400, 8200), 2.0);


			mix2 = Mix.ar(filt1*0.9,filt2*1.9, vco1F/vco1*0.5,vco2*9/8);
			ses = mix2+(mix1*filt1)+vco3F*0.5+vco1;
			ses = BPF.ar(ses,440,0.4+cut1,imp/2);
			ses = Limiter.ar(ses, 1.0, 0.01)*env;

			Out.ar(out, Pan2.ar(ses, pan, amp*imp*0.1));
		}).add;

)
(
		SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=1250, mul=0.4,
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.05, cut2=1, gate=1,
			lfo1Rate=1, lfo2Rate=2,
			att = 0.1, dec=0.02, rel = 0.02 |

			var in, osc, ses;
			var env, env1, env2, env3;
			var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
			var trig1;
			var lfo1, lfo2, lfo3, decay, gend, imp;
			gend = Gendy3.kr(1, 4,
                SinOsc.kr(0.1,0,0.49,0.51),
                SinOsc.kr(0.13,0,0.49,0.51),
                3.4, 3.5,
                SinOsc.kr(0.17,0,0.49,0.51),
                SinOsc.kr(0.19,0,0.49,0.51),
                10,10,50, 50);
			trig1 = Trig.ar(Dust.ar(sin1), 0.2) * FSinOsc.ar(0.5, 0, 0.4);
			imp = Saw.kr(saw).range(freq/2, freq*2);
			env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, -2, doneAction:2);
			env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
			env2 =  EnvGen.ar(Env.new([0,1,susLev,0],[0.1,0.3,0.8],[-6,-9,-5]), gate);
			env3 =  EnvGen.ar(Env.new([0,susLev*0.6,0.2,0],[att*0.5,0.1*dec,rel+0.01],[-7,-4,-2]), gate);

			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
			lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

			vco1=  LFSaw.ar(freq,0.1+cut1, env1*0.01);
			vco2=  FSinOsc.ar(imp*(freq*0.01),lfo1*cut1/2,env2)*vco1;
			vco3 = FSinOsc.ar(imp,0.1+cut1,imp*env3*0.02*vco1);

			vco1F = FreeVerb.ar(vco1,0.3,0.2*lfo1,1, env);
			vco2F = FreeVerb.ar(vco2,0.6,0.1*lfo2,1, env2);
			vco3F = FreeVerb.ar(vco3,0.3,0.1*lfo3,1, trig1*0.1*env);

			mix1 = Mix.ar(vco1F,vco2F, vco3F);
			mix1 = FreeVerb.ar(mix1,sin1,0.5,0.8);
			filt1 = RLPF.ar(mix1, SinOsc.kr(0.5).range(~c2, ~c3),0.2, amp);
			filt2 = MoogFF.ar(mix1, SinOsc.kr(cut1+0.5).range(~c3, ~c4), 1.0*sin1);


			mix2 = Mix.ar(filt1*0.9,filt2*0.9);
			ses = mix2+(mix1*filt1);
			ses = BPF.ar(ses,SinOsc.kr(0.5).range(~c4, ~c5),0.4+cut1,imp/2);
			ses = Limiter.ar(ses, 1.0, 0.01)*env;

			Out.ar(out, Pan2.ar(ses, pan, amp*imp*0.1));
		}).add;

)
