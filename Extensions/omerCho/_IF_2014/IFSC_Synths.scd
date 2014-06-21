(

~track1={

	~track1Main.fork;

	~togMain.free;
	~togMain = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"IF Main PLAY".postln;
			~mainSet_00.fork(quant:0);
			~ifPlay={|tm=4|

				inf.do{
					1.do {

						//~md1Clock.play;
						IFKick_SC(~tmMulKickP.next*~tmKickP.next);
						IFSnr_SC(~tmMulSnrP.next*~tmSnrP.next);
						IFHat_SC(~tmMulHatP.next*~tmHatP.next);

						IFKeys_SC(~tmKeysP.next);
						IFBass_SC(~tmBassP.next);
						IFSamp_SC(~tmSampP.next);

						~durMul*((~durP.next)).wait;
					};
				};

			}.fork;


		});

		if ( msg[1]==0, {
			"IF Main STOP".postln;
			~ifPlay.stop;
			//~md1Clock.stop;

		});
		},
		'/1/toggleMain'
	);

	//---------------- DUR Buttons ---------------//

	~dur1But.free;
	~dur1But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"------------dur1".postln;
			~tOSCAdrr.sendMsg('durLabel', '1');

			~dur.source = Pseq([1], inf)*~durMulP;

		});
		},
		'/dur1'
	);

	~dur2But.free;
	~dur2But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"------------dur2".postln;
			~tOSCAdrr.sendMsg('durLabel', '2');
			~dur.source = Pseq([
				Pseq([1], 7),
				Pseq([0.5,0.5], 1)
			], inf)*~durMulP;

		});
		},
		'/dur2'
	);

	~dur3But.free;
	~dur3But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"------------dur3".postln;
			~tOSCAdrr.sendMsg('durLabel', '3');
			~dur.source = Pseq([
				Pseq([1], 3),
				Pseq([0.5], 2),
				Pseq([1], 3),
				Pseq([0.5], 2)
			], inf)*~durMulP;

		});
		},
		'/dur3'
	);

	~dur4But.free;
	~dur4But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"------------dur4".postln;
			~tOSCAdrr.sendMsg('durLabel', '4');
			~dur.source = Pseq([
				Pseq([1], 2),
				Pseq([0.5], 4),
				Pseq([1.25], 1),
				Pseq([0.75], 2)
			], inf)*~durMulP;


		});
		},
		'/dur4'
	);

	~durAks1But.free;
	~durAks1But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"------------durAks1".postln;
			~tOSCAdrr.sendMsg('durLabel', 'Aks');
			~dur.source = Pseq([
				Pseq([0.5,0.5,0.75], 1),
				Pseq([0.5,0.75], 1),
				Pseq([0.5,0.5,0.75], 1),
				Pseq([0.5,0.75], 2)
			], inf)*~durMulP;

		});
		},
		'/durAks1'
	);

	~durShuf1But.free;
	~durShuf1But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"------------durShuf1".postln;
			~tOSCAdrr.sendMsg('durLabel', 'shuf');
			~dur.source = Pshuf([
				Pshuf([0.25,0.5,0.5], 1),
				Pshuf([0.25,0.75], 1),
				Pshuf([0.5,0.25,0.25], 1),
				Pshuf([0.5,0.75], 2)
			], inf)*~durMulP;

		});
		},
		'/durShuf1'
	);



	~durRand1But.free;
	~durRand1But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"------------durRand1".postln;
			~tOSCAdrr.sendMsg('durLabel', 'rand');
			~dur.source = Pseq([
				Pxrand([0.25,0.5,0.5], 1),
				Pxrand([0.25,0.75], 1),
				Pxrand([0.5,0.25,0.25], 1),
				Pxrand([0.5,0.75], 2)
			], inf)*~durMulP;

		});
		},
		'/durRand1'
	);

	//durMul

	~durMul1_4But.free;
	~durMul1_4But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"------------dur1".postln;
			~tOSCAdrr.sendMsg('durMulLabel', '1/4');

			~durMul.source = Pseq([1/4], inf);

		});
		},
		'/durMul1_4'
	);

	~durMul1_2But.free;
	~durMul1_2But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"------------dur1".postln;
			~tOSCAdrr.sendMsg('durMulLabel', '1/2');

			~durMul.source = Pseq([1/2], inf);

		});
		},
		'/durMul1_2'
	);

	~durMul1But.free;
	~durMul1But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"------------dur1".postln;
			~tOSCAdrr.sendMsg('durMulLabel', '1');

			~durMul.source = Pseq([1], inf);

		});
		},
		'/durMul1'
	);



//PRESETS

	~setAllBut.free;
	~setAllBut = OSCFunc({
		arg msg;
		if ( msg[1]==1, {

			IFSCProjectGlobals.preSetAll;

		});
		},
		'/setAll'
	);

	~set1But.free;
	~set1But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {

			IFSCProjectGlobals.preSet_1;

		});
		},
		'/set1'
	);

};

/*
~track1.fork;
*/

SynthDef(\vKickInput, {|out1, out2, out3, out4, in, vol=0.9,mtDly=0,mtRev=0,mtFlo=0,mtCln=0|
	var input;
	input=In.ar(in,2);
	input=Pan2.ar(input, 0)*vol;
	Out.ar(out1, input*mtCln);
	Out.ar(out2, input*mtDly);
	Out.ar(out3, input*mtRev);
	Out.ar(out4, input*mtFlo);
}).send(Server.default);

SynthDef(\vSnrInput, {|out1, out2, out3, out4, in, vol=0.9,mtDly=0,mtRev=0,mtFlo=0,mtCln=0|
	var input;
	input=In.ar(in,2);
	input=Pan2.ar(input, 0)*vol;
	Out.ar(out1, input*mtCln);
	Out.ar(out2, input*mtDly);
	Out.ar(out3, input*mtRev);
	Out.ar(out4, input*mtFlo);
}).send(Server.default);

SynthDef(\vHatInput, {|out1, out2, out3, out4, in, vol=0.9,mtDly=0,mtRev=0,mtFlo=0,mtCln=0|
	var input;
	input=In.ar(in,2);
	input=Pan2.ar(input, 0)*vol;
	Out.ar(out1, input*mtCln);
	Out.ar(out2, input*mtDly);
	Out.ar(out3, input*mtRev);
	Out.ar(out4, input*mtFlo);
}).send(Server.default);

SynthDef(\vBassInput, {|out1,out2, out3, out4, vol=0.9, pan=0, fosMul=0,mtDly=0,mtRev=0,mtFlo=0,mtCln=0|
	var input, ctl;
	input=SoundIn.ar(2,0.9,0);
	//ctl = FOS.kr(LFSaw.kr(8, 0, 0.2), 1 - input.abs, input, fosMul);
	input= Pan2.ar(input, pan)*2*vol;
	Out.ar(out1, input*mtCln);
	Out.ar(out2, input*mtDly);
	Out.ar(out3, input*mtRev);
	Out.ar(out4, input*mtFlo);
}).send(Server.default);

SynthDef(\vKeysInput, {|out1, out2, out3, out4, vol=0.9, pan=0,mtDly=0,mtRev=0,mtFlo=0,mtCln=0|
	var input;
	input=SoundIn.ar(3,0.9,0);
	input= Pan2.ar(input, pan)*2*vol;
	Out.ar(out1, input*mtCln);
	Out.ar(out2, input*mtDly);
	Out.ar(out3, input*mtRev);
	Out.ar(out4, input*mtFlo);
}).send(Server.default);

SynthDef(\vSampInput, {|out1, out2, out3, out4, in, vol=0.9, pan=0,mtDly=0,mtRev=0,mtFlo=0,mtCln=0|
	var input;
	input=In.ar(in,2);
	input=Pan2.ar(input, 0)*vol;
	Out.ar(out1, input*mtCln);
	Out.ar(out2, input*mtDly);
	Out.ar(out3, input*mtRev);
	Out.ar(out4, input*mtFlo);
}).send(Server.default);

SynthDef("clean",{ |out=0, in=0, lvl=0.9, durt=0.01, mainVol=0.9,
	delay=0, decay=1|
	var ses;
	ses=In.ar(in, 2)*mainVol;
	ses=CombN.ar(ses,0.1,delay,decay, 1);
	ses=Limiter.ar( ses, lvl);
	Out.ar( out, ses );
}).send(Server.default);

SynthDef("limiter",{ |out=0, in = 0, lvl = 0.9, durt = 0.01, mainVol=0.9|
	Out.ar( out, Limiter.ar( In.ar(in, 2)*mainVol, lvl) )
}).send(Server.default);

SynthDef("reverb", { | out, in = 0, amp=0.5, pan=0.0, lvl=0.9,
	room = 0.5, mix = 0.0, damp = 1.0 |
	var input, ses;
	input = In.ar(in, 2);
	ses = FreeVerb.ar(input,mix,room,damp);
	ses=Limiter.ar( ses, lvl);

	Out.ar(out, Pan2.ar(ses, pan, amp) );
}).send(Server.default);

SynthDef("delay", { |out = 0, in = 0, maxdelay = 1.25,  delay = 0.0, decay = 0.05, pan = 0, amp =0.9, lvl=0.9|
	var ses, fx;
	ses =  In.ar(in, 2);
	ses = CombN.ar(ses,0.9,delay,decay, mul: 0.4);
	//AllpassN.ar(dry, 2.5,[LFNoise1.kr(2, 1.5, 1.6), LFNoise1.kr(2, 1.5, 1.6)],3, mul: 0.8);
	//ses = (ses+fx).dup;
	ses=Limiter.ar( ses, lvl);
	Out.ar(out,  Pan2.ar(ses, pan, amp));
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
	//freq = Lag.kr(freq, 0.01);
	ses = Mix.new(
		SinOsc.ar(
			freq * [f1, f2, f3, f4, f5]*1.0 ,
			0,
			LFNoise1.kr(0.2,0.1,0.1),
			amp + ampInc pow: ampExp * ampScale
		)
	);

	ses = Resonz.ar(ses, LFDNoise0.kr(10).range(freq, freq/2), 0.01, 0.1);
	//ses = Formlet.ar(ses, LFDNoise0.kr(2).range(freq, freq/2), 0.01, 0.1);
	3.do({
		ses = AllpassN.ar(ses, 0.90, [0.060.rand,0.70.rand], 2)
	});

	Out.ar(out,  Pan2.ar(Limiter.ar( ses, lvl, durt), pan, amp));
}).send(Server.default);


//Flow
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
	arg msg, dec, del;
	dec= (msg[2])*4;
	del= (msg[1]);

	~dly.set( \decay, dec, \delay, del);
	~tOSCAdrr.sendMsg('delayLabel', del);
	~tOSCAdrr.sendMsg('decayLabel', dec);

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
	~dly.set(\delay, 0.31);
	~tOSCAdrr.sendMsg('delayLabel', 0.25);
	~tOSCAdrr.sendMsg('delayXY',0, 0.25);
	},
	'/delay05'
);

~delay1.free;
~delay1= OSCFunc({
	arg msg;
	~dly.set(\delay, 0.43);
	~tOSCAdrr.sendMsg('delayLabel', 0.5);
	~tOSCAdrr.sendMsg('delayXY',0, 0.5);
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

	~cln.set(\delay, msg[2]);

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
~vBassSynth = Synth.head(~piges, \vBassInput,[
	\out1, ~clnBus, \out2, ~dlyBus, \out3,~revBus, \out4, ~floBus
]);
~vKeysSynth = Synth.head(~piges, \vKeysInput,[
	\out1, ~clnBus, \out2, ~dlyBus, \out3,~revBus, \out4, ~floBus
]);
~vKickSynth = Synth.tail(~effe, \vKickInput,[\in,~busKick,
	\out1, ~clnBus, \out2, ~dlyBus, \out3,~revBus, \out4, ~floBus
]);
~vSnrSynth = Synth.tail(~effe, \vSnrInput,[\in,~busSnr,
	\out1, ~clnBus, \out2, ~dlyBus, \out3,~revBus, \out4, ~floBus
]);
~vHatSynth = Synth.tail(~effe, \vHatInput,[\in,~busHat,
	\out1, ~clnBus, \out2, ~dlyBus, \out3,~revBus, \out4, ~floBus
]);
~vSampSynth = Synth.tail(~effe, \vSampInput,[\in,~busSamp,
	\out1, ~clnBus, \out2, ~dlyBus, \out3,~revBus, \out4, ~floBus
]);

~cln = Synth.tail(~effe, \clean,[ \in , ~clnBus, \out, 0,\lvl, 0.9]);
~dly = Synth.tail(~effe,\delay,[\in,  ~dlyBus, \out, 0,\lvl, 0.0]);
~rev = Synth.tail(~effe, \reverb,[\in,  ~revBus, \out, 0,\lvl, 0.0]);
~flo = Synth.tail(~effe, \flow,[ \in , ~floBus, \out, 0]);
)

(
~vBassSynth.free;
~vKeysSynth.free;
~vSampSynth.free;
~vKickSynth.free;
~vSnrSynth.free;
~vHatSynth.free;
~cln.free;
~dly.free;
~rev.free;
~flo.free;

)
//SET
//~vKickSynth.set(\vol, 0.2);
(
~dly.set(\lvl, 0.9);

~dly.set(\maxdelay, 1.0, \decay, 4.0, \delay, 0.7);

~rev.set(\mix, 1.0, \room, 0.9, \damp, 1.0);
~flo.set(\ampInc, -0.9, \ampExp, -2.9, \ampScale, 0.1);

)

~cln.set(\delay,0.2);
~cln.set(\in, [~busSnr,~busKick]);


s.queryAllNodes
