/*

	SynthDef(\baxx,{|out = 6, amp = 0.1, vol = 0.9, gate = 1,
		freq = 50, pan = 0,
		att = 0.1, dec = 0.005, sus = 0.5, rls = 1.5 |
		
		var env, ses;
		env = EnvGen.ar(Env.adsr(att, dec, sus, rls, 0.5, 1), gate, doneAction:2);
	
		ses = SinOsc.ar(freq,0,amp);
		ses = ses.sin**2/20.abs+ ses;
		ses = DelayL.ar(ses, 0.5, 0.006, 0.5, ses);
		
		Out.ar(out, Pan2.ar(ses, pan) *env  *vol);
	}).send(s);

default args  att= 0.01, sus = 0.1, rls = 2.5, mul = 0.8, loop = 0, freq = 55, vib=4, out = 0;
KafSinVibTest.new.ar(0.1, 0.1, 8.0, mul:0.8, freq1: 55, freq2: 57, vib1: 2.1, vib2: 4, loop:1, out: 0).play;
~kafSin.set(\freq1, 299, \freq2, 299);

*/

KafSinVibTest : UGen { 
	
	var <>batt= 0.01, <>bsus = 0.1, <>brls = 2.5, <>bmul = 0.6, <>bloop = 0, <>bfreq1 = 55, <>bfreq2 = 55, <>bvib1=4, <>bvib2=2, <>bloop = 0, <>bout = 0;


	ar { arg  att, sus, rls, mul, loop, freq1, freq2, vib1, vib2, out;


		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		bvib1 = vib1 ? bvib1;
		bvib2 = vib2 ? bvib2;
		bfreq1 = freq1 ? bfreq1;
		bfreq2 = freq2 ? bfreq2;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		
		^~kafSin = SynthDef("sinBass", { arg  att, sus, rls, mul, loop, freq1, freq2, vib1, vib2, out;
			var player, depth, vibrato1, vibrato2, env;
			
			depth = Line.kr(2.1, 4, 3);
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [att, sus, rls], -4, loop), 
				1, 
				doneAction: 2
			);
			
			vibrato1 = SinOsc.ar(freq: vib1, mul: depth, add: freq1);
			vibrato2 = SinOsc.ar(freq: vib2, mul: depth, add: freq2);
			
			player = Mix.ar([
				SinOsc.ar(vibrato1, mul: 0.5),
				SinOsc.ar(vibrato2, mul: 0.3)
			]);
			
			player = player.sin**2/20+ player;
			player = DelayL.ar(player, 0.5, 0.006, 0.5, player);
			
			player = PanAz.ar(~pCh,
				player, 
				SinOsc.kr(SinOsc.kr(0.01).range(0.05, 0.09)).range(-1, 1),
				0.8,
				2
			);
			
			Out.ar(out, player *mul *env);
		}).play(Server.default, [
							\att , batt,
							\sus , bsus,
							\rls , brls,
							\mul , bmul,
							\vib1 , bvib1,
							\vib2 , bvib2,
							\out , bout,
							\loop , bloop,
							\freq1, bfreq1,
							\freq2, bfreq2
							]);
	}




}