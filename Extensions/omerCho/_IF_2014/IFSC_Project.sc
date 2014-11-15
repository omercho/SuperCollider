

/*
IFSC.loadGroups;
IFSC.loadBuses;
*/


IFSC {

	//------Buffers------//
	*loadBuffers {



	}

	*unLoadBuffers {



	}

	//-------Groups------//
	*loadGroups {

		~piges = Group.head(Server.default);
		~effe = Group.tail(Server.default);
		"groups loaded".postln;
	}

	*unLoadGroups {

		~piges.free;
		~effe.free;
		//~recorders.free;

	}

	//---------Buses-----//
	*loadBuses {

		~busBeats = Bus.new(\audio, 24, 2);
		~busBass = Bus.new(\audio, 26, 2);
		~busKeys = Bus.new(\audio, 28, 2);
		~busKick = Bus.new(\audio, 30, 2);
		~busSamp = Bus.new(\audio, 32, 2);
		~revBus = Bus.new(\audio, 34, 2);
		~dlyBus = Bus.new(\audio, 36, 2);
		~limBus = Bus.new(\audio, 38, 2);
		~floBus = Bus.new(\audio, 40, 2);
		~clnBus = Bus.new(\audio, 42, 2);
		"buses loaded".postln;

	}

	*unLoadBuses {

		~busKick.free;

		~busBeats.free;
		~busBass.free;
		~busKeys.free;
		~busSamp.free;

		~revBus.free;
		~dlyBus.free;
		~limBus.free;
		~flobus.free;
		~clnBus.free;
		"buses unloaded".postln;
	}


	*loadEffects {




		SynthDef(\vBeatsInput, {|out1,out2, out3, out4, vol=0.9, pan=0,mtDly=0,mtRev=0,mtFlo=0,mtCln=0|
			var input, ctl;
			input=SoundIn.ar(1,0.9,0);
			input= Pan2.ar(input, pan)*2*vol;
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

		SynthDef(\vKickInput, {|out1, out2, out3, out4, in, vol=0.9,mtDly=0,mtRev=0,mtFlo=0,mtCln=0|
			var input;
			input=In.ar(in,2);
			input=Pan2.ar(input, 0)*vol;
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

		"effects OSC loaded".postln;

	}


	*playEffects {

		~vBeatsSynth = Synth.head(~piges, \vBeatsInput,[
			\out1, ~clnBus, \out2, ~dlyBus, \out3,~revBus, \out4, ~floBus
		]);
		~vBassSynth = Synth.head(~piges, \vBassInput,[
			\out1, ~clnBus, \out2, ~dlyBus, \out3,~revBus, \out4, ~floBus
		]);
		~vKeysSynth = Synth.head(~piges, \vKeysInput,[
			\out1, ~clnBus, \out2, ~dlyBus, \out3,~revBus, \out4, ~floBus
		]);
		~vKickSynth = Synth.tail(~effe, \vKickInput,[\in,~busKick,
			\out1, ~clnBus, \out2, ~dlyBus, \out3,~revBus, \out4, ~floBus
		]);
		~vSampSynth = Synth.tail(~effe, \vSampInput,[\in,~busSamp,
			\out1, ~clnBus, \out2, ~dlyBus, \out3,~revBus, \out4, ~floBus
		]);

		~cln = Synth.tail(~effe, \clean,[ \in , ~clnBus, \out, 0,\lvl, 0.9]);
		~dly = Synth.tail(~effe,\delay,[\in,  ~dlyBus, \out, 0,\lvl, 0.0]);
		~rev = Synth.tail(~effe, \reverb,[\in,  ~revBus, \out, 0,\lvl, 0.0]);
		~flo = Synth.tail(~effe, \flow,[ \in , ~floBus, \out, 0]);
		"effects are playing".postln;

	}

	*stopEffects {

		~vBeatsSynth.free;
		~vBassSynth.free;
		~vKeysSynth.free;
		~vKickSynth.free;
		~vSampSynth.free;
		~cln.free;
		~dly.free;
		~rev.free;
		~flo.free;


	}








}