IFTrack01 {
	*loadAtStart{
		"IF Main Track 1 loaded".postln;
		~scl1= Scale.chromatic;
		~scl2= Scale.chinese;
		~tOSCAdrr.sendMsg('scaleLabel', 'Chinese');

		~tmp1=120;
		~tOSCAdrr.sendMsg('tempoLabel', ~tmp1);
		~tOSCAdrr.sendMsg('tempoFader', ~tmp1);
		~nt=(0);

		this.preset01;
	}
	*preset01{
		"Preset: 01".postln;
		~tOSCAdrr.sendMsg('presetLabel','Preset 01');

		"Kick Set".postln;
		~local.sendMsg('volKick', 0.99);
		~local.sendMsg('sendKick', 0.0, 0.0);
		~local.sendMsg('attKick', 0.0);
		~local.sendMsg('susKick', 0.5);
		~local.sendMsg('decKick', 0.7);
		~local.sendMsg('chainKick', 0.0);

		"Snr Set".postln;
		~local.sendMsg('volSnr', 0.99);
		~local.sendMsg('sendSnr', 0.3, 0.1);
		~local.sendMsg('attSnr', 0.0);
		~local.sendMsg('susSnr', 0.5);
		~local.sendMsg('decSnr', 0.5);
		~local.sendMsg('chainSnr', 0.05);

		"Hat Set".postln;
		~local.sendMsg('volHat', 0.99);
		~local.sendMsg('sendHat', 0.0, 0.0);
		~local.sendMsg('attHat', 0.05);
		~local.sendMsg('susHat', 0.05);
		~local.sendMsg('decHat', 0.4);
		~local.sendMsg('chainHat', 0.05);

		"Bass Set".postln;
		~local.sendMsg('volBass', 0.95);
		~local.sendMsg('sendBass', 0.1, 0.0);
		~local.sendMsg('attBass', 0.05);
		~local.sendMsg('susBass', 0.5);
		~local.sendMsg('decBass', 0.2);
		~local.sendMsg('chainBass', 0.0);
		~local.sendMsg('lfoMulBass1',0.00);
		~local.sendMsg('lfoMulBass2',0.00);

		"Keys Set".postln;
		~local.sendMsg('volKeys', 0.95);
		~local.sendMsg('sendKeys', 0.0, 0.6);
		~local.sendMsg('attKeys', 0.05);
		~local.sendMsg('susKeys', 0.3);
		~local.sendMsg('decKeys', 0.05);
		~local.sendMsg('chainKeys', 0.05);
		~local.sendMsg('lfoMulKeys1',0.0);
		~local.sendMsg('lfoMulKeys2',0.01);

		"Samp Set".postln;
		~local.sendMsg('volSamp', 0.8);
		~local.sendMsg('sendSamp', 0.0, 0.3);
		~local.sendMsg('attSamp', 0.05);
		~local.sendMsg('susSamp', 0.05);
		~local.sendMsg('decSamp', 0.3);
		~local.sendMsg('chainSamp', 0.0);
		~local.sendMsg('lfoMulSamp1',0.2);
		~local.sendMsg('lfoMulSamp2',0.4);

		"Global Set".postln;
		~local.sendMsg('harm0',1);
		~local.sendMsg('cutAll',0.4, 0.25);
		~local.sendMsg('cutDrum',0.2, 0.2);
	}

	*preset02{
		"Preset: 02".postln;
		~tOSCAdrr.sendMsg('presetLabel','Preset 02');

		"Duration Pattern: Straight".postln;
		~tOSCAdrr.sendMsg('durLabel', 'Straight');
		~dur.source = Pseq([1], inf)*~durMulP.next;
		~tOSCAdrr.sendMsg('dur1', '1');
		~tOSCAdrr.sendMsg('dur2', '0');
		~tOSCAdrr.sendMsg('dur3', '0');
		~tOSCAdrr.sendMsg('dur4', '0');
		~tOSCAdrr.sendMsg('durAks1', '0');
		~tOSCAdrr.sendMsg('durShuf1', '0');
		~tOSCAdrr.sendMsg('durRand1', '0');

		"Duration Mul: 1/2".postln;
		~tOSCAdrr.sendMsg('durMulLabel', '1/2');
		~durMul.source = Pseq([1/2], inf);
		~tOSCAdrr.sendMsg('durMul1_4', '0');
		~tOSCAdrr.sendMsg('durMul1_2', '1');
		~tOSCAdrr.sendMsg('durMul1', '0');

		"Kick Set".postln;
		~local.sendMsg('volKick', 0.99);
		~local.sendMsg('sendKick', 0.0, 0.0);
		~local.sendMsg('attKick', 0.0);
		~local.sendMsg('susKick', 0.5);
		~local.sendMsg('decKick', 0.7);
		~local.sendMsg('chainKick', 0.0);

		"Snr Set".postln;
		~local.sendMsg('volSnr', 0.99);
		~local.sendMsg('sendSnr', 0.3, 0.1);
		~local.sendMsg('attSnr', 0.0);
		~local.sendMsg('susSnr', 0.5);
		~local.sendMsg('decSnr', 0.5);
		~local.sendMsg('chainSnr', 0.05);

		"Hat Set".postln;
		~local.sendMsg('volHat', 0.99);
		~local.sendMsg('sendHat', 0.0, 0.0);
		~local.sendMsg('attHat', 0.05);
		~local.sendMsg('susHat', 0.05);
		~local.sendMsg('decHat', 0.4);
		~local.sendMsg('chainHat', 0.05);

		"Bass Set".postln;
		~local.sendMsg('volBass', 0.95);
		~local.sendMsg('sendBass', 0.1, 0.0);
		~local.sendMsg('attBass', 0.05);
		~local.sendMsg('susBass', 0.5);
		~local.sendMsg('decBass', 0.2);
		~local.sendMsg('chainBass', 0.0);
		~local.sendMsg('lfoMulBass1',0.00);
		~local.sendMsg('lfoMulBass2',0.00);

		"Keys Set".postln;
		~local.sendMsg('volKeys', 0.95);
		~local.sendMsg('sendKeys', 0.0, 0.6);
		~local.sendMsg('attKeys', 0.05);
		~local.sendMsg('susKeys', 0.3);
		~local.sendMsg('decKeys', 0.05);
		~local.sendMsg('chainKeys', 0.05);
		~local.sendMsg('lfoMulKeys1',0.0);
		~local.sendMsg('lfoMulKeys2',0.01);

		"Samp Set".postln;
		~local.sendMsg('volSamp', 0.8);
		~local.sendMsg('sendSamp', 0.0, 0.3);
		~local.sendMsg('attSamp', 0.05);
		~local.sendMsg('susSamp', 0.05);
		~local.sendMsg('decSamp', 0.3);
		~local.sendMsg('chainSamp', 0.0);
		~local.sendMsg('lfoMulSamp1',0.2);
		~local.sendMsg('lfoMulSamp2',0.4);

		"Global Set".postln;
		~local.sendMsg('harm0',1);
		~local.sendMsg('cutAll',0.4, 0.25);
		~local.sendMsg('cutDrum',0.2, 0.2);
	}
}