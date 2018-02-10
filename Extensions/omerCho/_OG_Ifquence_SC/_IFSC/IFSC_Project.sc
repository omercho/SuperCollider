

/*
IFSC.loadGroups;
IFSC.loadBuses;
IFSC.loadEffects;
IFSC.playEffects;

s.queryAllNodes;

*/


IFSC {

	*load {
		fork{
			IFSC.loadGroups;
			0.25.wait;
			IFSC.loadBuses;
			0.25.wait;
			IFSC.loadEffects;
			0.25.wait;
			IFSC.playEffects;
			0.1.wait;
			IFSC.osc;
			IFSC.mutes;
		};
	}
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
		~busSampler = Bus.new(\audio, 26, 2);
		~busBass = Bus.new(\audio, 28, 2);
		~busKeys = Bus.new(\audio, 30, 2);
		~busKick = Bus.new(\audio, 32, 2);
		~busSamp = Bus.new(\audio, 34, 2);
		~revBus = Bus.new(\audio, 36, 2);
		~dlyBus = Bus.new(\audio, 38, 2);
		~limBus = Bus.new(\audio, 40, 2);
		~floBus = Bus.new(\audio, 42, 2);
		~clnBus = Bus.new(\audio, 44, 2);
		"buses loaded".postln;

	}

	*unLoadBuses {



		~busBeats.free;
		~busSampler.free;
		~busBass.free;
		~busKeys.free;

		~busKick.free;
		~busSamp.free;

		~revBus.free;
		~dlyBus.free;
		~limBus.free;
		~flobus.free;
		~clnBus.free;
		"buses unloaded".postln;
	}


	*loadEffects {




		SynthDef(\vBeatsInput, {|out1,out2, out3, out4, vol=0.9, pan=0.3,mtDly=0,mtRev=0,mtFlo=0,mtCln=0|
			var input, ctl;
			input=SoundIn.ar(4,0.9,0);
			input= Pan2.ar(input, 0)*2*vol;
			Out.ar(out1, input*mtCln);
			Out.ar(out2, input*mtDly);
			Out.ar(out3, input*mtRev);
			Out.ar(out4, input*mtFlo);
		}).send(Server.default);
		SynthDef(\vSamplerInput, {|out1, out2, out3, out4, in, vol=0.9, pan=0,mtDly=0,mtRev=0,mtFlo=0,mtCln=0|
			var input;
			//input=In.ar(in,2);
			input=SoundIn.ar(6,0.9,0);
			input=Pan2.ar(input, SinOsc.kr(pan).range(-0.5, 0.5);)*vol;
			Out.ar(out1, input*mtCln);
			Out.ar(out2, input*mtDly);
			Out.ar(out3, input*mtRev);
			Out.ar(out4, input*mtFlo);
		}).send(Server.default);

		SynthDef(\vBassInput, {|out1,out2, out3, out4, vol=0.9, pan=0, fosMul=0,mtDly=0,mtRev=0,mtFlo=0,mtCln=0|
			var input, ctl;
			input=SoundIn.ar(5,0.9,0);
			//ctl = FOS.kr(LFSaw.kr(8, 0, 0.2), 1 - input.abs, input, fosMul);
			input= Pan2.ar(input, pan)*2*vol;
			Out.ar(out1, input*mtCln);
			Out.ar(out2, input*mtDly);
			Out.ar(out3, input*mtRev);
			Out.ar(out4, input*mtFlo);
		}).send(Server.default);

		SynthDef(\vKeysInput, {|out1, out2, out3, out4, vol=0.9, pan=0.5,mtDly=0,mtRev=0,mtFlo=0,mtCln=0|
			var input;
			input=SoundIn.ar(7,0.9,0);
			input= Pan2.ar(input, SinOsc.kr(pan).range(-0.7, 0.7);)*2*vol;
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
			//input=SoundIn.ar(6,0.9,0);
			input=Pan2.ar(input, 0)*vol;
			Out.ar(out1, input*mtCln);
			Out.ar(out2, input*mtDly);
			Out.ar(out3, input*mtRev);
			Out.ar(out4, input*mtFlo);
		}).send(Server.default);



		SynthDef("clean",{|
			out=0, in=0, lvl=0.9,
			durt=0.01, mainVol=0.9,
			delay=0, decay=1|
			var ses;
			ses=In.ar(in, 2)*mainVol;
			ses=CombN.ar(ses,0.1,delay,decay, 1);
			ses=Limiter.ar( ses, lvl);
			Out.ar( out, ses );
		}).send(Server.default);

		SynthDef("limiter",{|
			out=0, in = 0, lvl = 0.9,
			durt = 0.01, mainVol=0.9|
			Out.ar( out, Limiter.ar( In.ar(in, 2)*mainVol, lvl) )
		}).send(Server.default);

		SynthDef("reverb", {|
			out, in = 0, amp=0.5, pan=0.0, lvl=0.9,
			room = 0.5, mix = 0.0, damp = 1.0 |
			var input, ses, comp, compIn;
			input = In.ar(in, 2);
			compIn = In.ar(~busBeats,1);
			ses = FreeVerb.ar(input,mix,room,damp);
			comp = Compander.ar(ses, compIn,
				thresh: -72.dbamp,
				slopeBelow: 1,
				slopeAbove: 0.5,
				clampTime: 0.001,
				relaxTime: 0.1,
				mul: 0.2
			);
			ses=Limiter.ar( ses, lvl);

			Out.ar(out, Pan2.ar(ses, pan, amp) );
		}).send(Server.default);

		SynthDef("delay", {|
			out = 0, in = 0, maxdelay = 1.25,
			delay = 0.0, decay = 0.05, pan = 0, amp =0.9, lvl=0.9|
			var ses, fx;
			ses =  In.ar(in, 2);
			ses = CombN.ar(ses,0.9,delay,decay, mul: 0.4);
			//AllpassN.ar(dry, 2.5,[LFNoise1.kr(2, 1.5, 1.6), LFNoise1.kr(2, 1.5, 1.6)],3, mul: 0.8);
			//ses = (ses+fx).dup;
			ses=Limiter.ar( ses, lvl);
			Out.ar(out,  Pan2.ar(ses, pan, amp));
		}).send(Server.default);

		SynthDef("fx1", {|
			out = 0, in = 0,
			maxdelay = 1.25,  delay = 0.0, decay = 0.05,
			pan = 0, amp =0.5, dlyVol=0.8,
			room = 0.5, mix = 1, damp = 1.0, revVol=0.8|
			var ses, filt;
			ses =  In.ar(in, 2);
			ses = CombN.ar(ses,maxdelay,delay,decay,dlyVol);
			ses = FreeVerb.ar(ses,mix,room,damp,revVol);
			Out.ar(out,  Pan2.ar(ses, pan, amp));
		}).send(Server.default);


		SynthDef("flow",{|out=0, in, pan=0, lvl = 0.9,
			durt = 0.01,
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
		~vSamplerSynth = Synth.head(~piges, \vSamplerInput,[\in,~busSampler,
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
		~dly = Synth.tail(~effe,\delay,[ \in,  ~dlyBus, \out, 0,\lvl, 0.9]);
		~rev = Synth.tail(~effe, \reverb,[\in,  ~revBus, \out, 0,\lvl, 0.9]);
		~flo = Synth.tail(~effe, \flow,[ \in , ~floBus, \out, 0,\lvl, 0.9]);
		"effects are playing".postln;

	}

	*stopEffects {

		~vBeatsSynth.free;
		~vBassSynth.free;
		~vSamplerSynth.free;
		~vKeysSynth.free;
		~vKickSynth.free;
		~vSampSynth.free;
		~cln.free;
		~dly.free;
		~rev.free;
		~flo.free;


	}


	*osc {

		~killAllBut.free;
		~killAllBut= OSCFunc({
			arg msg;
			if(msg[1]==1,{
				{"TRUE".postln;
					IFSC.stopEffects;
					IFSC.unLoadBuses;
					IFSC.unLoadGroups;}.fork
				},{
					{"FALSE".postln;
						IFSC.loadGroups;
						IFSC.loadBuses;
						IFSC.playEffects;}.fork;

			});

			},
			'/killAll'
		);


		~recordBut.free;
		~recordBut = OSCFunc({
			arg msg;

			if ( msg[1]==1, {
				{
					Server.default.prepareForRecord;
					0.1.wait;
					Server.default.record;}.fork;
				},{
					Server.default.stopRecording;
				}
			);

			},
			'/record'
		);


		//-------------------------------------------
		~volBeatsFad.free;
		~volBeatsFad= OSCFunc({
			arg msg; ~vBeatsSynth.set(\vol, msg[1]);
			~tOSCAdrr.sendMsg('volBeats', msg[1]);
		}, '/volBeats');
		~volSamplerFad.free;
		~volSamplerFad= OSCFunc({
			arg msg; ~vSamplerSynth.set(\vol, msg[1]);
			~tOSCAdrr.sendMsg('volSampler', msg[1]);
		}, '/volSampler');

		//-------------------------------------------
		~volBassFad.free;
		~volBassFad= OSCFunc({
			arg msg; ~vBassSynth.set(\vol, msg[1]);
			~tOSCAdrr.sendMsg('volBass', msg[1]);
		}, '/volBass');
		//-------------------------------------------
		~volKeysFad.free;
		~volKeysFad= OSCFunc({
			arg msg; ~vKeysSynth.set(\vol, msg[1]);
			~tOSCAdrr.sendMsg('volKeys', msg[1]);
		}, '/volKeys');
		//-------------------------------------------
		~volKickFad.free;
		~volKickFad= OSCFunc({
			arg msg; ~vKickSynth.set(\vol, msg[1]);
			~tOSCAdrr.sendMsg('volKick', msg[1]);
		}, '/volKick');
		~volSampFad.free;
		~volSampFad= OSCFunc({
			arg msg; ~vSampSynth.set(\vol, msg[1]);
			~tOSCAdrr.sendMsg('volSamp', msg[1]);
		}, '/volSamp');



		//_-_-_-_-_-_-_-_-SYNTH-_-_-_-_-_-_-_-_
		~volCleanFad.free;
		~volCleanFad= OSCFunc({
			arg msg;
			~cln.set(\lvl, msg[1]); ~tOSCAdrr.sendMsg('volClean', msg[1]);
		}, '/volClean');
		//-------------------------------------------
		~volFlowFad.free;
		~volFlowFad= OSCFunc({
			arg msg; ~flo.set(\lvl, msg[1]); ~tOSCAdrr.sendMsg('volFlow', msg[1]);
		}, '/volFlow');
		//-------------------------------------------
		~volDelayFad.free;
		~volDelayFad= OSCFunc({
			arg msg; ~dly.set(\lvl, msg[1]); ~tOSCAdrr.sendMsg('volDelay', msg[1]);
		}, '/volDelay');
		//-------------------------------------------
		~volMainFad.free;
		~volMainFad= OSCFunc({
			arg msg; ~rev.set(\lvl, msg[1]); ~tOSCAdrr.sendMsg('volReverb', msg[1]);
		}, '/volReverb');

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



	}

	*mutes {
		//MUTES KICK
		~vKickMtCln.free;
		~vKickMtCln= OSCFunc({
			arg msg;
			~vKickSynth.set(\mtCln, msg[1]);
			},
			'/mtClnKick'
		);

		~vKickMtDly.free;
		~vKickMtDly= OSCFunc({
			arg msg;
			~vKickSynth.set(\mtDly, msg[1]);
			},
			'/mtDlyKick'
		);
		~vKickMtRev.free;
		~vKickMtRev= OSCFunc({
			arg msg;

			~vKickSynth.set(\mtRev, msg[1]);

			},
			'/mtRevKick'
		);
		~vKickMtFlo.free;
		~vKickMtFlo= OSCFunc({
			arg msg;

			~vKickSynth.set(\mtFlo, msg[1]);

			},
			'/mtFloKick'
		);

		//MUTES BEATS
		~vBeatsMtCln.free;
		~vBeatsMtCln= OSCFunc({
			arg msg;

			~vBeatsSynth.set(\mtCln, msg[1]);

			},
			'/mtClnBeats'
		);
		~vBeatsMtDly.free;
		~vBeatsMtDly= OSCFunc({
			arg msg;

			~vBeatsSynth.set(\mtDly, msg[1]);

			},
			'/mtDlyBeats'
		);
		~vBeatsMtRev.free;
		~vBeatsMtRev= OSCFunc({
			arg msg;

			~vBeatsSynth.set(\mtRev, msg[1]);

			},
			'/mtRevBeats'
		);
		~vBeatsMtFlo.free;
		~vBeatsMtFlo= OSCFunc({
			arg msg;

			~vBeatsSynth.set(\mtFlo, msg[1]);

			},
			'/mtFloBeats'
		);
		//MUTES Sampler
		~vSamplerMtCln.free;
		~vSamplerMtCln= OSCFunc({
			arg msg;

			~vSamplerSynth.set(\mtCln, msg[1]);

			},
			'/mtClnSampler'
		);
		~vSamplerMtDly.free;
		~vSamplerMtDly= OSCFunc({
			arg msg;

			~vSamplerSynth.set(\mtDly, msg[1]);

			},
			'/mtDlySampler'
		);
		~vSamplerMtRev.free;
		~vSamplerMtRev= OSCFunc({
			arg msg;

			~vSamplerSynth.set(\mtRev, msg[1]);

			},
			'/mtRevSampler'
		);
		~vSamplerMtFlo.free;
		~vSamplerMtFlo= OSCFunc({
			arg msg;

			~vSamplerSynth.set(\mtFlo, msg[1]);

			},
			'/mtFloSampler'
		);

		//MUTES BASS
		~vBassMtCln.free;
		~vBassMtCln= OSCFunc({
			arg msg;

			~vBassSynth.set(\mtCln, msg[1]);

			},
			'/mtClnBass'
		);

		~vBassMtDly.free;
		~vBassMtDly= OSCFunc({
			arg msg;

			~vBassSynth.set(\mtDly, msg[1]);

			},
			'/mtDlyBass'
		);
		~vBassMtRev.free;
		~vBassMtRev= OSCFunc({
			arg msg;

			~vBassSynth.set(\mtRev, msg[1]);

			},
			'/mtRevBass'
		);
		~vBassMtFlo.free;
		~vBassMtFlo= OSCFunc({
			arg msg;

			~vBassSynth.set(\mtFlo, msg[1]);

			},
			'/mtFloBass'
		);

		//MUTES
		~vKeysMtCln.free;
		~vKeysMtCln= OSCFunc({
			arg msg;

			~vKeysSynth.set(\mtCln, msg[1]);

			},
			'/mtClnKeys'
		);
		~vKeysMtDly.free;
		~vKeysMtDly= OSCFunc({
			arg msg;

			~vKeysSynth.set(\mtDly, msg[1]);

			},
			'/mtDlyKeys'
		);
		~vKeysMtRev.free;
		~vKeysMtRev= OSCFunc({
			arg msg;

			~vKeysSynth.set(\mtRev, msg[1]);

			},
			'/mtRevKeys'
		);
		~vKeysMtFlo.free;
		~vKeysMtFlo= OSCFunc({
			arg msg;

			~vKeysSynth.set(\mtFlo, msg[1]);

			},
			'/mtFloKeys'
		);
		//MUTES
		~vSampMtCln.free;
		~vSampMtCln= OSCFunc({
			arg msg;

			~vSampSynth.set(\mtCln, msg[1]);

			},
			'/mtClnSamp'
		);
		~vSampMtDly.free;
		~vSampMtDly= OSCFunc({
			arg msg;

			~vSampSynth.set(\mtDly, msg[1]);

			},
			'/mtDlySamp'
		);
		~vSampMtRev.free;
		~vSampMtRev= OSCFunc({
			arg msg;

			~vSampSynth.set(\mtRev, msg[1]);

			},
			'/mtRevSamp'
		);
		~vSampMtFlo.free;
		~vSampMtFlo= OSCFunc({
			arg msg;

			~vSampSynth.set(\mtFlo, msg[1]);

			},
			'/mtFloSamp'
		);
	}

}