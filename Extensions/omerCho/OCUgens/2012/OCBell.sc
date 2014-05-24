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

OCBell.ar(freq: 20, accent: 0.5, mul: 0.6, pan: (-1.0..1.0).choose).play;

*/

OCBell : UGen {

	*ar { |out = 0, freq = 431, accent = 1, mul = 0.4, decayScale = 1.01, pan = 0|

		^SynthDef(\bell, {
			var	exc = PinkNoise.ar(mul)
					* Decay2.kr(Impulse.kr(0.1), 0.01, 0.05),
				sig = Klank.ar(`[
					[freq, freq*2, freq*3.2, freq*4],
					1 ! 4,
					{ ExpRand(0.1, 0.4) } ! 4
				], exc, freqscale: accent + 1, decayscale: decayScale);
			DetectSilence.ar(sig, doneAction: 2);
			Out.ar(out, Pan2.ar(sig, pan))
		});

	}

}


/*


*/