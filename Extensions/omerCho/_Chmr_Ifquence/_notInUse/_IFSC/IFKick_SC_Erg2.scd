SynthDef(\IFKick_SC, {| att =0.01, dec=0.1, susLev=1.0, rel=0.09, mul = 0.9,
	gate=1, wnoise=2.8,
	amp=0.5,out=0, freq=120, freq2=45, freq3=30, pan = 0,
	ctrl01=0.03, /*0.002 -- 0.2*/
	ctrl02=0.1, /*0.05 -- 0.5*/
	ctrl03,
	filtF=60
	|

	var env, env1, env1m, ses, sesF;

	env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel, curve:[-4,-8,-8]), gate, doneAction:2);
	env1 = EnvGen.ar(Env.new([freq, freq2, freq3], [ctrl01, ctrl02/*0.05*/], [-5, -5]));
	env1m = env1.midicps;

	ses = LFPulse.ar(env1m, 0, 0.1, env, -0.5);
	ses = (ses + WhiteNoise.ar(wnoise))*env;
	ses = LPF.ar(ses, env1m*1.2, env)*0.8;
	sesF = MoogFF.ar(ses, filtF,2);
	ses = ses + SinOsc.ar(env1m, 0.5, env);
	ses = (ses+sesF).clip2(12);
	ses = ses * mul;
	ses = Limiter.ar(ses,0.9);
	Out.ar(out, Pan2.ar(ses, pan, amp*0.9));
}).add;


~attKick=0.03;
~susLevKick=0.4;
~decKick=0.3;
~relKick=0.5;