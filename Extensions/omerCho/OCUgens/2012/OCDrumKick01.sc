/*
(
fork{
	~frq = 940;
	20.do{|i, frq = 4240, dur = 0.1|
		var freqs = ~frq + (12 *( i % 20)); 
		
		OCBell.ar(freq: freqs, pan: (-1.0..1.0).choose).play;
		( dur + (0.1*(i%10)) ).yield;
	}
};

fork{
	~frq = 940;
	~dur = 0.08;
	
	OCDrumKick01.ar(amp:0.8, freq1:110, freq2:59, freq3:29).play;
	
	(1/8).wait;
	
	8.do{|i, dur = 0.1|
		var freqs = ~frq + (12 *( i % 4)); 
		
		OCDrumKick01.ar( amp:0.8, freq1:freqs, freq2:59, freq3:29, pan: (-1.0..1.0).choose).play;
		( ~dur + (0.08*(i%10)) ).yield;
	};
}
)

OCDrumKick01.ar(0.01, 0.8, 0.9, mul:0.8, freq1:110, freq2:59, freq3:29, wnoise:0.8, room:0.15, mix:0.1).play;
OCDrumKick01.ar(mul:0.8, freq1:170, freq2:59, freq3:29).play;
OCDrumKick01.ar(mul:0.8, freq1:270, freq2:59, freq3:29).play;
OCDrumKick01.ar(mul:0.8, freq1:170, freq2:159, freq3:29).play;
OCDrumKick01.ar(mul:0.8, freq1:170, freq2:59, freq3:39).play;
OCDrumKick01.ar(mul:0.8, freq1:38, freq2:29, freq3:49).play;
OCDrumKick01.ar(mul:0.1, freq1:188, freq2:79, freq3:179).play;


OCDrumKick01.ar(amp:0.8, freq1:110, freq2:59, freq3:29, wnoise:9.1).play;


*/

OCDrumKick01 : UGen {

	*ar { | att =0.01, sus=0.8, rls=0.9, mul = 0.8, lenvA=1.0, lenvB=0.8, 
		amp=0,out=0, freq1=110, freq2=59, freq3=29, wnoise=0.8, mix = 0.18, room = 0.15, damp = 0.8, pan = 0 |
		
		^SynthDef(\OCDKick01, {	
			
			var env0, env1, env1m, out;
			env0 =  EnvGen.ar(
				Env.new([0, lenvA, lenvB,  0], [att, sus, rls], [-4, -2, -4], 0, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			//env0 =  EnvGen.ar(Env.new([0.5, 1, 0.5, 1.01], [0.005, 0.6, 0.26], [-4, -2, -4]), doneAction:2);
			env1 = EnvGen.ar(Env.new([freq1, freq2, freq3], [0.005, 0.29], [-4, -5]));
			env1m = env1.midicps;
			
			out = LFPulse.ar(env1m, 0, 0.5, 1, -0.5);
			out = out + WhiteNoise.ar(wnoise);
			out = LPF.ar(out, env1m*1.5, env0);
			out = out + SinOsc.ar(env1m, 0.5, env0);
			
			out = out * 1.2;
			out = out.clip2(1);
			out = FreeVerb.ar(out, // mono src
				mix, // mix 0-1
				room, // room 0-1
				damp // damp 0-1 duh
			);
			out = out * mul;
			
			Out.ar(out, Pan2.ar(out, pan));
		});
	
	}
	
}


/*

(
fork{
	~frq = 940;
	~dur = 0.08;
	
	OCDrumKick01.ar(amp:0.8, freq1:110, freq2:59, freq3:29).play;
	
	(1/8).wait;
	
	8.do{|i, dur = 0.1|
		var freqs = ~frq + (12 *( i % 4)); 
		
		OCDrumKick01.ar( amp:0.8, freq1:freqs, freq2:59, freq3:29, pan: (-1.0..1.0).choose).play;
		( ~dur + (0.08*(i%10)) ).yield;
	};
}
)

*/