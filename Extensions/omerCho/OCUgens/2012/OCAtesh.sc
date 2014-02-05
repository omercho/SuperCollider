/*
(
fork{
	~frq = 940;
	~dur = 0.1;
	20.do{|i|
		var freqs = ~frq + (12 *( i % 20)); 
		
		OCBell.ar(freq: freqs, pan: (0.0..1.0).choose).play;
		( ~dur + (0.1*(i%10)) ).yield;
	}
}
)

OCAtesh.ar(0.2, 0.3, 2.0, freq:~a1/4).play;

*/

OCAtesh : UGen {

	*ar { |att =0.1, sus = 0.11, rls =1, loop = 0, out = 0, amp = 0.5, gate = 1,  freq = 2|
		
		^{
			(
				{|k|
					(
						{|i|
							SinOsc.ar(
								freq,
						 		SinOsc.ar(i*k**i+18/[4,5])	
						 		 *
						 		Decay.kr(
						 		 	WhiteNoise.kr(1/4**i), 
						 			SinOsc.ar(0.1)+1*k+i,
						 			k*freq
						 		)
						 	)
						}!2
					).product
				}!16
			).sum *EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [att, sus, rls], -4, loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
		}
	
	}
	
}


/*

OCNam : UGen {

	*ar { |out, amp = 0.9, gate = 1, attime =0.1, suslev = 0.11, rls =1, doneact = 0, freq = #[788.99, 196, 392, 1567, 293]|
		
		^SynthDef(\name,{|i|
			var env, ses, ses1, ses2, decay;
			env = Linen.kr(gate, attime, suslev, rls, doneAction:2) * amp;
			decay = Decay.ar(Impulse.ar(Dust.kr(5),0.5,1), 0.1);
			ses = VarSaw.ar(
				LFPulse.ar(#[30, 133.03], 2.rand, 0.3, freq.cos/8,freq +.t [0, 0.2]),//freq
				1*decay.cos.sin,//iphase
				LFTri.kr(decay).range(0, 1).cos.abs,	//width
				0.2.sin	//mul
			);
			ses1 = ses.sum.rand;
			ses2 = ses1+decay;
			ses2 = Formlet.ar(ses2, ses, 0.001, 0.3 );
			Out.ar(out, ses2.cos/4 * env);
		});
	
	}
	
}


SynthDef(\name,{|i,out, amp = 0.9, gate = 1, attime =0.1, suslev = 0.11, rls =1, doneact = 0, freq = #[788.99, 196, 392, 1567, 293]|
	var env, ses, ses1, ses2, decay;
	env = Linen.kr(gate, attime, suslev, rls, doneAction:2) * amp;
	decay = Decay.ar(Impulse.ar(Dust.kr(5),0.5,1), 0.1);
	ses = VarSaw.ar(
		LFPulse.ar(#[30, 133.03], 2.rand, 0.3, freq.cos/8,freq +.t [0, 0.2]),	//freq
		1*decay.cos.sin,									//iphase
		LFTri.kr(decay).range(0, 1).cos.abs,				//width
		0.2.sin									//mul
				);
	ses1 = ses.sum.rand;
	ses2 = ses1+decay;
	ses2 = Formlet.ar(ses2, ses, 0.001, 0.3 );
	Out.ar(out, ses2.cos/4 * env);
}).add;


*/