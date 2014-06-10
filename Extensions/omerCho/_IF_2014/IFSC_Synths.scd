(
SynthDef(\vKickInput, {|out1, out2, out3, in, vol=0.9|
	var input;
	input=In.ar(in,2);
	input=Pan2.ar(input, 0)*vol;
	Out.ar(out1, input);
	Out.ar(out2, input);
	Out.ar(out3, input)
}).send(Server.default);

SynthDef(\vSnrInput, {|out1, out2, out3, in, vol=0.9|
	var input;
	input=In.ar(in,2);
	input=Pan2.ar(input, 0)*vol;
	Out.ar(out1, input);
	Out.ar(out2, input);
	Out.ar(out3, input)
}).send(Server.default);

SynthDef(\vHatInput, {|out1, out2, out3, in, vol=0.9|
	var input;
	input=In.ar(in,2);
	input=Pan2.ar(input, 0)*vol;
	Out.ar(out1, input);
	Out.ar(out2, input);
	Out.ar(out3, input)
}).send(Server.default);

SynthDef(\vBassInput, {|out1,out2, out3, vol=0.9, pan=0, fosMul=0|
	var input, ctl;
	input=SoundIn.ar(2,0.9,0);
	//ctl = FOS.kr(LFSaw.kr(8, 0, 0.2), 1 - input.abs, input, fosMul);
	input= Pan2.ar(input, pan)*2*vol;
	Out.ar(out1, input);
	Out.ar(out2, input);
	Out.ar(out3, input)
}).send(Server.default);

SynthDef(\vKeysInput, {|out1, out2, out3, vol=0.9, pan=0|
	var input;
	input=SoundIn.ar(3,0.9,0);
	input= Pan2.ar(input, pan)*2*vol;
	Out.ar(out1, input);
	Out.ar(out2, input);
	Out.ar(out3, input)
}).send(Server.default);

SynthDef(\vSampInput, {|out1, out2, out3, in, vol=0.9, pan=0|
	var input;
	input=In.ar(in,2);
	input=Pan2.ar(input, 0)*vol;
	Out.ar(out1, input);
	Out.ar(out2, input);
	Out.ar(out3, input)
}).send(Server.default);

SynthDef("clean",{ |out=0, in = 0, lvl = 0.9, durt = 0.01, mainVol=0.9,
	delay=0|
	var ses;
	ses=In.ar(in, 2)*mainVol;
	ses=ses+AllpassN.ar(ses,delay,delay,4);
	ses=Limiter.ar( ses, lvl, durt);
	Out.ar( out, ses );
}).send(Server.default);

SynthDef("limiter",{ arg out=0, in = 0, lvl = 0.9, durt = 0.01, mainVol=0.9;
	Out.ar( out, Limiter.ar( In.ar(in, 2)*mainVol, lvl, durt) )
}).send(Server.default);

SynthDef("reverb", { | out, in = 0, amp=0.5, pan=0.0,
	room = 0.5, mix = 0.0, damp = 1.0 |
	var input, ses;
	input = In.ar(in, 2);
	ses = FreeVerb.ar(input,mix,room,damp,amp);

	Out.ar(out, Pan2.ar(ses, pan) );
}).send(Server.default);

SynthDef("delay", { |out = 0, in = 0, maxdelay = 1.25,  delay = 0.0, decay = 0.05, pan = 0, amp =0.9|
	var ses, filt;
	ses =  In.ar(in, 2);
	filt = CombN.ar(ses,delay,delay,decay, amp);
	Out.ar(out,  Pan2.ar(filt, pan));
}).send(Server.default);

SynthDef("fx1", { |out = 0, in = 0,
	maxdelay = 1.25,  delay = 0.0, decay = 0.05, pan = 0, amp =0.5, dlyVol=0.8,
	room = 0.5, mix = 1, damp = 1.0, revVol=0.8|
	var ses, filt;
	ses =  In.ar(in, 2);
	ses = CombN.ar(ses,maxdelay,delay,decay,dlyVol);
	ses = FreeVerb.ar(ses,mix,room,damp,revVol);
	Out.ar(out,  Pan2.ar(ses, pan, amp));
}).send(Server.default);


SynthDef("flow",{ |out=0, in, pan=0, lvl = 0.9, durt = 0.01,
	ampInc = 0, ampExp = 1, ampScale = 0.1,
	f1 = 0.5, f2 = 1.2, f3 = 1.5, f4 = 1.7, f5 = 2.2|
	var input, amp, freq, hasFreq, ses;
	input = In.ar(in);
	//in = SoundIn.ar(1);
	amp = Amplitude.kr(input, 0.05, 0.05);
	# freq, hasFreq = Pitch.kr(input, ampThreshold: 0.02, median: 1);
	freq = Lag.kr(freq, 0.01);
	ses = Mix.new(
		SinOsc.ar(
			freq * [f1, f2, f3, f4, f5]*2.5 ,
			0,
			LFNoise1.kr(0.2,0.1,0.1),
			amp + ampInc pow: ampExp * ampScale
		)
	);

	ses = Resonz.ar(ses, LFDNoise0.kr(10).range(freq, freq/2), 0.01, 0.1);
	//ses = Formlet.ar(ses, LFDNoise0.kr(2).range(freq, freq/2), 0.01, 0.1);
	6.do({
		ses = AllpassN.ar(ses, 0.040, [0.060.rand,0.070.rand], 2)
	});

	Out.ar(out,  Pan2.ar(Limiter.ar( ses, lvl, durt), pan, amp));
}).send(Server.default);


/*~vBassFosMul.free;
~vBassFosMul= OSCFunc({
arg msg, dec, delay;
dec= (msg[1])*4;

~vBassSynth.set(\fosMul, msg[1]);

},
'/susBass'
);*/

~flowXY.free;
~flowXY= OSCFunc({
	arg msg, inc, exp;
	inc= (msg[1]);
	exp= (msg[2]);

	~flo.set(\ampInc, inc, \ampExp, exp);
	~tOSCAdrr.sendMsg('ampIncLabel', inc);
	~tOSCAdrr.sendMsg('ampExpLabel', exp);

	},
	'/flowXY'
);
~flowAmpScale.free;
~flowAmpScale= OSCFunc({
	arg msg;

	~flo.set(\ampScale, msg[1]);

	},
	'/flowAmpScale'
);

~delayXY.free;
~delayXY= OSCFunc({
	arg msg, dec, delay;
	dec= (msg[1])*4;

	~dly.set(\maxdelay, 4.01, \decay, dec, \delay, msg[2]);
	~tOSCAdrr.sendMsg('delayLabel', msg[2]);
	~tOSCAdrr.sendMsg('decayLabel', msg[1]);

	},
	'/delayXY'
);

~delay0.free;
~delay0= OSCFunc({
	arg msg;
	~dly.set(\delay, 0);
	~tOSCAdrr.sendMsg('delayLabel', 0);
	~tOSCAdrr.sendMsg('delayXY', 0,0);
	},
	'/delay0'
);

~delay05.free;
~delay05= OSCFunc({
	arg msg;
	~dly.set(\delay, 0.5);
	~tOSCAdrr.sendMsg('delayLabel', 0.5);
	~tOSCAdrr.sendMsg('delayXY',0, 0.5);
	},
	'/delay05'
);

~delay1.free;
~delay1= OSCFunc({
	arg msg;
	~dly.set(\delay, 1.0);
	~tOSCAdrr.sendMsg('delayLabel', 1.0);
	~tOSCAdrr.sendMsg('delayXY',0, 1.0);
	},
	'/delay1'
);

~reverbXY.free;
~reverbXY= OSCFunc({
	arg msg;


	~rev.set(\mix, msg[2], \room, msg[1]);

	},
	'/reverbXY'
);

~reverbDamp.free;
~reverbDamp= OSCFunc({
	arg msg;

	~rev.set(\damp, msg[1]);

	},
	'/reverbDamp'
);

~mFX1Del.free;
~mFX1Del= OSCFunc({
	arg msg;

	~cln.set(\delay, msg[2]*0.01);

	},
	'/masterFX1/1'
);

~mFX1DelOff.free;
~mFX1DelOff=MIDIFunc.cc( {
	arg vel;

	if ( vel==0, {

		~cln.set(\delay, 0);

	});



}, chan:1, ccNum:6);

)
(
~vBassSynth = Synth.head(~piges, \vBassInput,[ \out1, ~clnBus, \out2, ~dlyBus, \out3,~floBus]);
~vKeysSynth = Synth.head(~piges, \vKeysInput,[ \out1, ~clnBus, \out2, ~dlyBus, \out3,~floBus]);
~vKickSynth = Synth.tail(~effe, \vKickInput,[\in,~busKick, \out1, ~clnBus, \out2, ~dlyBus, \out3,~floBus]);
~vSnrSynth = Synth.tail(~effe, \vSnrInput,[\in,~busSnr, \out1, ~clnBus, \out2, ~dlyBus, \out3,~floBus]);
~vHatSynth = Synth.tail(~effe, \vHatInput,[\in,~busHat, \out1, ~clnBus, \out2, ~dlyBus, \out3,~floBus]);
~vSampSynth = Synth.tail(~effe, \vSampInput,[\in,~busSamp, \out1, ~clnBus, \out2, ~dlyBus, \out3,~floBus]);

~dly = Synth.tail(~effe,\delay,[\in,  ~dlyBus, \out, ~revBus]);
~rev = Synth.tail(~effe, \reverb,[\in,  ~revBus, \out, ~limBus]);
~lim = Synth.tail(~effe, \limiter,[ \in , ~limBus, \out, 0,\lvl, 0.6]);
~flo = Synth.tail(~effe, \flow,[ \in , ~floBus, \out, 0]);
~cln = Synth.tail(~effe, \clean,[ \in , ~clnBus, \out, 0,\lvl, 0.6]);
)

(
~vBassSynth.free;
~vKeysSynth.free;
~vSampSynth.free;
~vKickSynth.free;
~vSnrSynth.free;
~vHatSynth.free;
~dly.free;
~rev.free;
~lim.free;
~flo.free;
~cln.free;
)
//SET
//~vKickSynth.set(\vol, 0.2);
(
~lim.set(\lvl, 0.9);

~dly.set(\maxdelay, 4.0, \decay, 4.0, \delay, 0.5);

~rev.set(\mix, 1.0, \room, 0.9, \damp, 1.0);
~flo.set(\ampInc, -0.9, \ampExp, -2.9, \ampScale, 0.1);

)

~cln.set(\in, [~busSnr,~busKick]);


s.queryAllNodes
