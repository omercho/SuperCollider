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
			ses = 0.5*(ses*SinOsc.ar(freq*lfo2,decay));

			//ses = DelayC.ar( ses, 0.5, 0.001, 4.5, 0.0, ses);
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