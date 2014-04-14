PostAllOSC.on;
PostAllMIDI.on;

(
SynthDef(\varel,{|i, out, par1=4, par2=4, par3=5, amp = 1, gate = 1, attime = 0.01, decaytime = 2, suslev = 4, rls = 6|

	var env, env1, ses, penv;

	penv = Env.new([0.0, 1, 0.8, 0.3, 0.0], [0.01, 0.1, 2, 10],'exp', 1);
	env = EnvGen.kr(Env.asr, gate, doneAction:2) * amp;
	env1 = EnvGen.kr(penv, 1, doneAction:2);
	ses = {
		x= RLPF.ar(Blip.ar([2], 3, 0.5, 0.1), MouseX.kr(2, 120), 0.5);
		b= Blip.ar(par1, par2);
		p= Trig.kr(Saw.ar(par3), 0.3);
		y= Blip.ar(p**x**b/par1, 4);
		d= x*b*y.product/1.9;
		z= Blip.kr(d/x,4*env1*5);
		(GVerb.ar(GrainIn.ar(2,d,y,z,p,-1),2*b))
	};
	ses = ses.sin/0.19 *env1;
	Out.ar(out, (ses/1.02)*env);
}).load;

~trancOSC.remove;
~trancOSC = OSCFunc({
	arg msg;
	if ( msg[1]=='play', { "PLAYYYYY".postln; ~s1=Synth(\varel); });
	if ( msg[1]=='stop', { "STOPPPPP".postln; ~s1.release(1); });
	},
	'/transport'
);

~curs2OSC.remove;
~curs2OSC = OSCFunc({
	arg msg;
	if ( msg[1]==0, {
		"cursRecieve".postln;
		~s1.set(
			\par1,msg[3],
			\par2,msg[4],
			\par3,msg[5]
		);

	})},
	'/cursor'
);

)
~s1.set(\frX,150*1, \frY,150*1.5, \frZ,240*2); 