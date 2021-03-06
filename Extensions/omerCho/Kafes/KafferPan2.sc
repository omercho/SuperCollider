//A practical buffer player with panning in 2 channels
//Omer Chatziserif 
//Thu, 24 May 2011, 08:30
//Corfu

/*


*/

KafferPan2 : Buffer {
	
	var <>bout = 0, <>batt = 0.1, <>bsus = 2.0, <>brls = 2.5, <>bmul = 1.0, <>bloop = false;
	var <>btrig = 0, <>bstart = 0, <>bend = 1, <>breset = 0, <>bpan = 0;
	var <>brt = 1.0, <>brt1 = 1.0, <>brt2 = 1.0, <>brt3 = 1.0, <>brt1Dur = 1.0, <>brt2Dur = 0.5, <>btrDur = 0.2, <>bvib = 1;
	var <>broom = 125, <>brev = 1, <>bdamp = 0.5;
	var <>bfroom = 0.5, <>bfmix = 0.5, <>bfdamp = 0.5;
	var <>bpv1a = 0.1, <>bpv1b = 0.1;
	var <>bpv2a = 0.1, <>bpv2b = 0.5;
	var <>bpv3a = 1.1, <>bpv3b = 0.1;
	var <>bpv4a = 0.1, <>bpv4b = 0.1;
	var <>bpv5a = 0.1, <>bpv5b = 0.001; 
	
	*initClass {
		StartUp add: {
			
			this.panAzChannels;

		}
	}

	*panAzChannels {
		
		
		
			~pCh = 2;
		

		
	}


	// PV1 FFT with PV_BrickWall
	playPV1 { arg  att, sus, rls, mul, trig, rate, rate2, start, pv1a, pv1b, xfrom =1, xto = 15, loop, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		
		bpv1a = pv1a ? bpv1a;
		bpv1b = pv1b ? bpv1b;
		
		brt2 = rate2 ? brt2;
		bstart = start ? bstart;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		
		^SynthDef("playPV1", { 
			var player, chain, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], 4, loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = PlayBuf.ar(
						numChannels,
						bufnum, 
						BufRateScale.kr(bufnum) * brt,
						btrig,
						BufFrames.kr(bufnum) * bstart,
						loop: bloop.binaryValue
					);
			chain = FFT({LocalBuf(2048, ~pCh)}.dup(~pCh), player);
			chain = PV_BrickWall(chain, 
				SinOsc.kr(
					bpv1a * XLine.kr(xfrom, xto * [1, 1.6, 0.5], bpv1b), 
					Rand(0, pi)
				);
			);
			chain = Pan2.ar(IFFT(chain), bpan);
			Out.ar(bout, chain * bmul *env);
		}).play(Server.default);
	}


	// PV1R FFT with PV_BrickWall reverse
	playPV1R { arg  att, sus, rls, mul, trig, rate, rate2, start, loop, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		brt2 = rate2 ? brt2;
		bstart = start ? bstart;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		^SynthDef("playPV1", { 
			var player, chain, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], 4, loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = BufRd.ar(
						numChannels,
						bufnum, 
						Phasor.ar(
							btrig, 
							BufRateScale.kr(bufnum) * brt *(-1), 
							BufFrames.kr(bufnum) * bstart, 
							BufFrames.kr(bufnum) * bend, 
							BufFrames.kr(bufnum) * breset
						),
						loop: bloop.binaryValue
					);
			chain = FFT({LocalBuf(2048, ~pCh)}.dup(~pCh), player);
			chain = PV_BrickWall(chain, Line.kr(0, -1, bsus));
			chain = Pan2.ar(IFFT(chain), bpan);
 
			Out.ar(bout, chain * bmul *env);
		}).play(Server.default);
	}



	// PV2 FFT with PV_BinScramble
	playPV2 { arg  att, sus, rls, mul, trig, rate, rate2, start, loop, pv2a, pv2b, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		brt2 = rate2 ? brt2;
		bstart = start ? bstart;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		bpv2a = pv2a ? bpv2a;
		bpv2b = pv2b ? bpv2b;
		
		^SynthDef("playPV2", { 
			var player, chain, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], 'linear', loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = PlayBuf.ar(
						numChannels,
						bufnum, 
						BufRateScale.kr(bufnum) * brt,
						btrig,
						BufFrames.kr(bufnum) * bstart,
						loop: bloop.binaryValue
					);
			chain = FFT({LocalBuf(2048, ~pCh)}.dup(~pCh), player);
			chain = PV_BinScramble(chain, bpv2a , 0.1, bpv2b );
			chain = Pan2.ar(IFFT(chain), bpan);
			Out.ar(bout, chain * bmul *env);
		}).play(Server.default);
	}


	// PV3 FFT with PV_BinShift
	playPV3 { arg  att, sus, rls, mul, trig, rate, rate2, start, loop, pv3a, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		brt2 = rate2 ? brt2;
		bstart = start ? bstart;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		bpv3a = pv3a ? bpv3a;
		
		
		^SynthDef("playPV3", { 
			var player, chain, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], 'linear', loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = PlayBuf.ar(
						numChannels,
						bufnum, 
						BufRateScale.kr(bufnum) * brt,
						btrig,
						BufFrames.kr(bufnum) * bstart,
						loop: bloop.binaryValue
					);
			chain = FFT({LocalBuf(2048, ~pCh)}.dup(~pCh), player);
			chain = PV_BinShift(
				chain, 
				bpv3a,
				SinOsc.kr(
					brt2 , 
					Rand(0, pi)
				);
			);
			chain = Pan2.ar(IFFT(chain), bpan);
			Out.ar(bout, chain * bmul *env);
		}).play(Server.default);
	}


	// PV3 Pan
	playPV3Pan { arg  att, sus, rls, mul, trig, rate, rate2, start, loop, pv3a, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		brt2 = rate2 ? brt2;
		bstart = start ? bstart;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		bpv3a = pv3a ? bpv3a;
		
		
		^~pv3Pan = SynthDef("playPV3", { |panRate = 0.01|
			var player, chain, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], 'linear', loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = PlayBuf.ar(
						numChannels,
						bufnum, 
						BufRateScale.kr(bufnum) * brt,
						btrig,
						BufFrames.kr(bufnum) * bstart,
						loop: bloop.binaryValue
					);
			chain = FFT(LocalBuf(2048), player);
			chain = PV_BinShift(
				chain, 
				bpv3a,
				SinOsc.kr(
					brt2 , 
					Rand(0, pi)
				);
			);
			chain = Pan2.ar(IFFT(chain), bpan);
			Out.ar(bout, chain * bmul *env);
		}).play(Server.default);
	}

	// PV4 FFT with PV_MagShift
	playPV4 { arg  att, sus, rls, mul, trig, rate, rate2, start, loop, pv4a, pan, out, xfrom =0.1, xto=0.1;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		brt2 = rate2 ? brt2;
		bstart = start ? bstart;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		bpv4a = pv4a ? bpv4a;
		
		^SynthDef("playPV4", { 
			var player, chain, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], 'linear', loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = PlayBuf.ar(
						numChannels,
						bufnum, 
						BufRateScale.kr(bufnum) * brt,
						btrig,
						BufFrames.kr(bufnum) * bstart,
						loop: bloop.binaryValue
					);
			chain = FFT({LocalBuf(2048, ~pCh)}.dup(~pCh), player);
			chain = PV_MagShift(chain,  XLine.kr(xfrom * [1, 1.6], xto, bsus), bpv4a );
			chain = Pan2.ar(IFFT(chain), bpan);
			Out.ar(bout, chain * bmul *env);
		}).play(Server.default);
	}

	// PV4 Pan
	playPV4Pan { arg  att, sus, rls, mul, trig, rate, rate2, start, loop, pv4a, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		brt2 = rate2 ? brt2;
		bstart = start ? bstart;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		bpv4a = pv4a ? bpv4a;
		
		^~pv4Pan = SynthDef("playPV4", { |panRate = 0.1|
			var player, chain, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], 'linear', loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = PlayBuf.ar(
						numChannels,
						bufnum, 
						BufRateScale.kr(bufnum) * brt,
						btrig,
						BufFrames.kr(bufnum) * bstart,
						loop: bloop.binaryValue
					);
			chain = FFT({LocalBuf(2048, ~pCh)}.dup(~pCh), player);
			chain = PV_MagShift(chain,  XLine.kr(0.25 * [1, 1.6], 4, bsus), SinOsc.kr(
					brt2 , 
					Rand(0, pi)
				); 
			);
			chain = Pan2.ar(IFFT(chain), bpan);
			//chain = Pan2.ar(IFFT(chain), SinOsc.kr(SinOsc.kr(0.01).range(0.05, 0.09)).range(-1, 1));

			Out.ar(bout, chain * bmul *env);
		}).play(Server.default);
	}


	// PV4B FFT with PV_MagShift
	playPV4B { arg  att, sus, rls, mul, trig, rate, rate2, start, loop, pv4a, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		brt2 = rate2 ? brt2;
		bstart = start ? bstart;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		bpv4a = pv4a ? bpv4a;
		
		^SynthDef("playPV4", { 
			var player, chain, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], 'linear', loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = PlayBuf.ar(
						numChannels,
						bufnum, 
						BufRateScale.kr(bufnum) * brt,
						btrig,
						BufFrames.kr(bufnum) * bstart,
						loop: bloop.binaryValue
					);
			chain = FFT({LocalBuf(2048, ~pCh)}.dup(~pCh), player);
			chain = PV_MagShift(chain,  XLine.kr(0.25 * [1, 1.6], 4, bsus), bpv4a );
			chain = Pan2.ar(IFFT(chain), bpan); 
			Out.ar(bout, chain * bmul *env);
		}).play(Server.default);
	}



	// PV5 FFT with PV_ConformalMap
	playPV5 { arg  att, sus, rls, mul, trig, rate, rate2, start, loop, pv5a, pv5b, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		brt2 = rate2 ? brt2;
		bstart = start ? bstart;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		bpv5a = pv5a ? bpv5a;
		bpv5b = pv5b ? bpv5b;
		
		^SynthDef("playPV5", { 
			var player, chain, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], 'linear', loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = PlayBuf.ar(
						numChannels,
						bufnum, 
						BufRateScale.kr(bufnum) * brt,
						btrig,
						BufFrames.kr(bufnum) * bstart,
						loop: bloop.binaryValue
					);
			chain = FFT({LocalBuf(2048, ~pCh)}.dup(~pCh), player);
			chain = PV_ConformalMap(chain, bpv5a, bpv5b); 
			// --- pvc1 -1.0 -> 1.0 ---- pvc1 -1.0 -> 1.0
			chain = Pan2.ar(IFFT(chain), bpan);
			
			Out.ar(bout, chain * bmul *env);
		}).play(Server.default);
	}


	//transBuf
	transBuf { arg  att, sus, rls, mul, trig, rt, rt1, rt2, rt3, rt1Dur, rt2Dur, trDur, vib, start, loop, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rt ? brt;
		brt1 = rt1 ? brt1;
		brt2 = rt2 ? brt2;
		brt3 = rt3 ? brt3;
		btrDur = trDur ? btrDur;
		brt1Dur = rt1Dur ? brt1Dur;
		brt2Dur = rt2Dur ? brt2Dur;
		bvib = vib ? bvib;
		bstart = start ? bstart;

		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		
		
		^{ var player, panlayer, env, env2;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], -4, loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			
			env2 =  EnvGen.ar(
				Env.new([brt1, brt1, brt2, brt2], [brt1Dur, btrDur, brt2Dur+brls], -4, loop, releaseNode: nil), 
				1, 
				doneAction: 0
			);
			
			player = PlayBuf.ar(
						numChannels,
						bufnum, 
						SinOsc.kr(bvib*MouseX.kr(0.01, 4)).range(0.99, 1.01)*BufRateScale.kr(bufnum)*1 *env2,
						btrig,
						BufFrames.kr(bufnum) * bstart,
						loop: bloop.binaryValue
					);
			player = Pan2.ar( player, bpan);

			Out.ar(bout, player *bmul *env);
		}.play(Server.default);
	}

	// PlayBuf
	playBuf { arg  att, sus, rls, mul, trig, rate, start, loop, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		bstart = start ? bstart;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		^{ var player, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], 4, loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = PlayBuf.ar(
						1,
						bufnum, 
						BufRateScale.kr(bufnum) * brt,
						btrig,
						BufFrames.kr(bufnum) * bstart,
						loop: bloop.binaryValue
					);
			player = Pan2.ar( player.dup, bpan);
			
			Out.ar(bout, player.sum/2 * bmul *env);
		}.play(Server.default);
	}

	//with BufRD to reverse a buffer
	playBufR { arg  att, sus, rls, mul, trig, rate, start, end, reset, loop, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		bstart = start ? bstart;
		bend = end ? bend;
		breset = reset ? breset;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		
		^{ var player, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], -5, loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = BufRd.ar(
						numChannels,
						bufnum, 
						Phasor.ar(
							btrig, 
							BufRateScale.kr(bufnum) * brt *(-1), 
							BufFrames.kr(bufnum) * bstart, 
							BufFrames.kr(bufnum) * bend, 
							BufFrames.kr(bufnum) * breset
						),
						loop: bloop.binaryValue
					);
			player = Pan2.ar( player, bpan);
			Out.ar(bout, player.sum/2 * bmul *env);
		}.play(Server.default);
	}

	
	//--------------default Play-----
	play { arg loop = false;
		^{ var player;
			player = PlayBuf.ar(
				numChannels,
				bufnum,
				BufRateScale.kr(bufnum),
				loop: loop.binaryValue
			);
			loop.not.if(FreeSelfWhenDone.kr(player));
			player * bmul;
		}.play(Server.default);
	}

	//with freeVerb------------------------------------------------------------------------------------------------------------------------------------
	playFverb { arg  att, sus, rls, mul, trig, rate, start, loop, froom, fmix, fdamp, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		bstart = start ? bstart;
		bfroom = froom ? bfroom;
		bfmix = fmix ? bfmix;
		bfdamp = fdamp ? bfdamp;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		^{ var player, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], -4, loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = PlayBuf.ar(
						numChannels,
						bufnum, 
						BufRateScale.kr(bufnum) * brt,
						btrig,
						BufFrames.kr(bufnum) * bstart,
						loop: bloop.binaryValue
					);
			
			player = FreeVerb.ar(
				player,
				bfmix, 
				bfroom, 
				bfdamp, 
				bmul
			);
			player = Pan2.ar( player, bpan);
			//player = Pan2.ar(player, bpan);
			Out.ar(bout, player.sum/2 *env);
		}.play(Server.default);
	}


	//with PlayBuf Gverb
	playGverb { arg  att, sus, rls, mul, trig, rate, start, loop, room, rev, damp, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		bstart = start ? bstart;
		broom = room ? broom;
		brev = rev ? brev;
		bdamp = damp ? bdamp;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		^{ var player, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], -4, loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = PlayBuf.ar(
						numChannels,
						bufnum, 
						BufRateScale.kr(bufnum) * brt,
						btrig,
						BufFrames.kr(bufnum) * bstart,
						loop: bloop.binaryValue
					);
			player = GVerb.ar(
				player,
				broom, 
				brev, 
				bdamp, 
				0.45, 
				15, 
				-3.dbamp,
				-11.dbamp, 
				-9.dbamp,
				broom, bmul);
			player = Pan2.ar( player, bpan);
			Out.ar(bout, player.sum/2 *env);
		}.play(Server.default);
	}


	//with GverbR
	playGverbR { arg  att, sus, rls, mul, trig, rate, start, end, reset, loop, room, rev, damp, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		bstart = start ? bstart;
		bend = end ? bend;
		breset = reset ? breset;
		broom = room ? broom;
		brev = rev ? brev;
		bdamp = damp ? bdamp;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		^{ var player, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], -4, loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = BufRd.ar(
						numChannels,
						bufnum, 
						Phasor.ar(
							btrig, 
							BufRateScale.kr(bufnum) * brt *(-1), 
							BufFrames.kr(bufnum) * bstart, 
							BufFrames.kr(bufnum) * bend, 
							BufFrames.kr(bufnum) * breset
						),
						loop: bloop.binaryValue
					);
			player = GVerb.ar(
				player,
				broom, 
				brev, 
				bdamp, 
				0.45, 
				15, 
				-3.dbamp,
				-11.dbamp, 
				-9.dbamp,
				broom, bmul
			);
			player = Pan2.ar( player, bpan);
			Out.ar(bout, player.sum/2 *env);
		}.play(Server.default);
	}


	//with transGverb
	transGverb { arg  att, sus, rls, mul, trig, rt, rt1, rt2, rt3, rt1Dur, rt2Dur, trDur, vib, start, loop, room, rev, damp, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rt ? brt;
		brt1 = rt1 ? brt1;
		brt2 = rt2 ? brt2;
		brt3 = rt3 ? brt3;
		brt1Dur = rt1Dur ? brt1Dur;
		brt2Dur = rt2Dur ? brt2Dur;
		btrDur = trDur ? btrDur;
		bvib = vib ? bvib;
		bstart = start ? bstart;
		broom = room ? broom;
		brev = rev ? brev;
		bdamp = damp ? bdamp;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		
		
		^{ var player, panlayer, env, env2;
			
			env =  EnvGen.ar(
				Env.new([0, 0.5, 0.8,  0], [batt, bsus, brls], -4, loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			
			env2 =  EnvGen.ar(
				Env.new([brt1, brt1, brt2, brt2], [brt1Dur, btrDur, brt2Dur+brls], -5, loop, releaseNode: nil), 
				1, 
				doneAction: 0
			);
			
			player = PlayBuf.ar(
						numChannels,
						bufnum, 
						SinOsc.kr(bvib*MouseX.kr(0.01, 4)).range(0.99, 1.01)*BufRateScale.kr(bufnum)*1 *env2,
						btrig,
						BufFrames.kr(bufnum) * bstart,
						loop: bloop.binaryValue
					);
			
			
			
			player = GVerb.ar(
				player,
				broom, 
				brev, 
				bdamp, 
				0.45, 
				15, 
				-3.dbamp,
				-11.dbamp, 
				-9.dbamp,
				broom, bmul
			);
			player = Pan2.ar( player, bpan);
			Out.ar(bout, player.sum/2 *env);
		}.play(Server.default);
	}

	playLP { arg  att, sus, rls, mul, trig, rate, start, loop, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		bstart = start ? bstart;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		^{ var player, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [batt, bsus, brls], 4, loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = PlayBuf.ar(
						numChannels,
						bufnum, 
						BufRateScale.kr(bufnum) * brt,
						btrig,
						BufFrames.kr(bufnum) * bstart,
						loop: bloop.binaryValue
					);
			player = Pan2.ar( player, bpan);
			Out.ar(bout, player * bmul *env);
		}.play(Server.default);
	}






}

