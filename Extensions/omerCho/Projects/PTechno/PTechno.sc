
PTechno{
	*synthDefs{
//Oscilator SynthDef 
		SynthDef( \lypat01, { |out = 0, vol = 1, amp = 1, sustain = 1.1, freq = 256, 
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 400, 
			attime = 0.01, rls = 0.5, pan = 0 |
			var in, osc, env, ses;
			env =  EnvGen.ar(Env.perc(attime, rls), doneAction: 2, levelScale: 0.4, timeScale: sustain);
			in = SinOsc.ar(FSinOsc.ar(freq, 0, brown), 0.4);
			ses = SinOsc.ar(0, in, 0.01) ;
			ses = RLPF.ar(ses, freq, 1.4, 1.6, 0.4 );
			ses = ses.sin/8 + SinOsc.ar(freq, Decay.ar(SinOsc.ar(sin1, sin2), 8.2.abs*8, Saw.ar(saw)));
			ses = Pan2.ar(ses, pan, amp);
			
			Out.ar(out, ses *vol *env );
		}).add;
		

		
//Effects SynyhDefs
		SynthDef("limiter",{ arg out=0, in = 0, lvl = 0.9, durt = 0.01;
			ReplaceOut.ar( out, Limiter.ar( In.ar(in, 2), lvl, durt) )
		}).add;
		
		
		SynthDef("reverb", { | out, in = 0, amp=0.05, roomsize = 10, revtime = 1, damping = 0.2, inputbw = 0.19, spread = 15,
				drylevel = -3, earlylevel = -9, taillevel = -11 |
			var input;
			input = In.ar(in, 2);
			Out.ar(out, GVerb.ar(
				input,
				roomsize,
				revtime,
				damping,
				inputbw,
				spread,
				drylevel.dbamp,
				earlylevel.dbamp,
				taillevel.dbamp,
				roomsize, amp) + input
			)
		}).add;
			
		SynthDef("delay", { |out = 0, in = 0, maxdelay = 0.25,  delay = 1.0, decay = 0.05, amp =0.5|
			var ses, filt;
			ses =  In.ar(in, 2);
			filt = CombN.ar(
					ses,
					maxdelay,
					delay,
					decay, 
					amp
				);
			Out.ar(out, ses);
		}).add;
		
		SynthDef("rlpf",{ |out = 0, amp = 0.8 in = 0, ffreq = 600, rq = 0.1, pan = 0|
			Out.ar( out, Pan2.ar(RLPF.ar( In.ar(in), ffreq, rq, amp), pan))
		}).add;
		
		
		SynthDef("wah", { arg out = 0, in = 0, rate = 0.5, amp = 1, pan = 0, cfreq = 1400, mfreq = 1200, rq=0.1, dist = 0.15;
			var zin, zout;
			zin = In.ar(in, 2);
			cfreq = Lag3.kr(cfreq, 0.1);
			mfreq = Lag3.kr(mfreq, 0.1);
			rq   = Ramp.kr(rq, 0.1);
			zout = RLPF.ar(zin, LFNoise1.kr(rate, mfreq, cfreq), rq, amp).distort * dist;
			Out.ar( out , Pan2.ar(zout, pan) ); 
		}).add;

		
	}
	
	*buses {
	
		~limBus = Bus.new(\audio, 20, 2);
		~revBus = Bus.new(\audio, 22, 2);
		~dlyBus = Bus.new(\audio, 24, 2);
		~rlpBus = Bus.new(\audio, 26, 2);
		~wahBus = Bus.new(\audio, 28, 2);
		
	}
	
	*synths {
		
		~lim = Synth("limiter",
			[ \in ,~limBus, \out, 0,  
			\lvl, 0.6, \durt, 0.01, 
			\addAction, \addToTail]
		);
		~rev = Synth("reverb", 
			[\in,  ~revBus, \out, ~limBus, \amp, 0.5,
			\addAction, \addToTail]
		);
		~dly = Synth("delay", 
			[\in,  ~dlyBus, \out, ~limBus, \amp, 0.5,
			\addAction, \addToTail]
		);
		~rlp = Synth("rlpf", 
			[\in,  ~rlpBus, \out, ~limBus, 
			\ffreq, 220, \rq, 1.5, \amp, 0.1,
			\addAction, \addToTail]
		);
		~wah = Synth( "wah", 
			[\in,  ~wahBus, \out, ~limBus, 
			\amp, 1, \addAction, \addToTail]
		);
			
	}
		
}

