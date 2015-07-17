
/*
IFSamp.times(2);
IFSamp.pat_1;

~octSamp=4;

*/


IFSamp_SC {
	var <>keyTime = 1;
	classvar <>counter3 = 0;



	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });*/
		}
	}

	*globals{

		~chSamp=5;
		~sampLate=0.00;
		~timesSamp=1;
		~octMulSamp=1;
		~rootFreqSamp=~c5; // 261=C4|523=C5
		~harmSamp=0;
		~susMulSamp=1;
		~trSamp=0;



	}

	*preSet{
		SynthDef( \IFSamp_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.05, cut2=1, gate=1,
			lfo1Rate=1, lfo2Rate=2,
			att = 0.1, susLev = 0.1, dec=0.02, rel = 0.02,
			rate = 0.2, rate2 = 1.2, startPos = 0, loop = 1, stretch = 0.05|

			var osc, ses;
			var env, env1, env2, env3;
			var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
			var lfo1, lfo2, lfo3, decay,imp;

			var mix, chain, buf, filt, freqRate, freqBuf, freqOsc;
			startPos = startPos * BufFrames.kr(bufnum);
			freqBuf = freq;
			freqBuf = freqBuf.ratiomidi;
	        freqBuf = freqBuf.midicps/rootFreq;
			freqOsc = freq*4;
			//freqRate = freqRate.keyToDegree();
			//freqRate = freqRate.midiratio;

			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
			lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

			env =  EnvGen.ar(Env.adsr(att, dec+0.1, susLev, rel), gate, -2, doneAction:2);
			env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
			env2 =  EnvGen.ar(Env.new([0,1,susLev,0.3,0],[0.1,0.3,0.8,0.1],[-6,-9,-5,-2]), gate);
			env3 =  EnvGen.ar(Env.new([0,susLev*0.6,0.2,0],[att*0.5,0.1*dec,rel+0.01],[-7,-4,-2]), gate);

			osc = LFSaw.ar(LFSaw.kr(lfo1Rate, 0, freqOsc, freqOsc*0.5), 0)*0.5;
			buf = PlayBuf.ar(1, bufnum, rate:freqBuf, startPos: startPos, loop:0)*1.9;
			filt= MoogFF.ar(
				        (1.5*buf)+(osc*0.03),
				//12220,
				cut1*(~c5*lfo1)*4,
				        1
			);
			mix = Mix.ar(osc)+Mix.ar(buf)+Mix.ar(filt);
			Out.ar(out, Pan2.ar(Mix.ar(mix)*mul*0.5, pan, env)*amp);
		}).add;
}


*default {
		~n01.free;~n01 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/athm01.aif");
		~n02.free;~n02 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/athm01R.aif");
		~n03.free;~n03 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/athm02.aif");
		~n04.free;~n04 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/athm02R.aif");
		~p01.free;~p01 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/piano01.aif");
		~p02.free;~p02 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/sop01.aif");
		~p03.free;~p03 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/dop01.aif");
		~p04.free;~p04 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/dop01r.aif");
		//~samplerEvent = Event.default.put(\freq, { ~midinote.midicps / ~sampleBaseFreq });

	~nt1Samp = PatternProxy( Pseq([0], inf));
	~nt1SampP = Pseq([~nt1Samp], inf).asStream;
	~dur1Samp = PatternProxy( Pseq([1], inf));
	~dur1SampP = Pseq([~dur1Samp], inf).asStream;
	~amp1Samp = PatternProxy( Pseq([0.9], inf));
	~amp1SampP = Pseq([~amp1Samp], inf).asStream;
	~sus1Samp = PatternProxy( Pseq([1], inf));
	~sus1SampP = Pseq([~sus1Samp], inf).asStream;

	~attSamp=0.05;
	~decSamp=1.02;
	~susLevSamp=1.1;
	~relSamp = 0.5;
	~lfoMulSamp=0.8;
	~cutSamp=0.1;
	~legatoSamp=0.08;
	~sin1Samp=1.1;
	~sin2Samp=0.9;
	~tmSamp = PatternProxy( Pseq([1], inf));
	~tmSampP= Pseq([~tmSamp], inf).asStream;

	~transSamp = PatternProxy( Pseq([0], inf));
	~transSampP = Pseq([~transSamp], inf).asStream;
	~octSamp = PatternProxy( Pseq([0], inf));
	~octSampP = Pseq([~octSamp], inf).asStream;
	~legSamp = PatternProxy( Pseq([0.0], inf));
	~legSampP = Pseq([~legSamp], inf).asStream;

	~bufnumSamp = PatternProxy( Pseq([~sop01], inf));
	~bufnumSampP = Pseq([~bufnumSamp], inf).asStream;

	~delta1Samp = PatternProxy( Pseq([1/4], inf));
	~delta1SampP = Pseq([~delta1Samp], inf).asStream;
	~delta2Samp = PatternProxy( Pseq([1/2], inf));
	~delta2SampP = Pseq([~delta2Samp], inf).asStream;

	~lfo1Samp = PatternProxy( Pseq([1], inf));
	~lfo1SampP = Pseq([~lfo1Samp], inf).asStream;
	~lfo2Samp = PatternProxy( Pseq([1], inf));
	~lfo2SampP = Pseq([~lfo2Samp], inf).asStream;


}

*new{|i=1|
	var val;
	val=i;
	case
	{ i == val }  {
		{val.do{

			//~sampLate=~abLate;
			~sampLate.wait;

			this.p1(val);

			~durMulP*((~dur1SampP.next)/val).wait;
		}}.fork;
	}

}

*p1 {|i=1|
	var val;
	val=i;

	Pbind(
		\instrument, \IFSamp_SC, \scale, Pfunc({~scl2}, inf),
		\bufnum, Pseq([~bufnumSampP.next], inf),
		\dur, Pseq([Pseq([~dur1SampP.next],1)], 1),
		\degree, Pseq([~nt1SampP.next], 1),
		\amp, Pseq([~amp1SampP.next], 1),
		\sustain, Pseq([~sus1SampP.next],1)*~susMulSamp,
		\mtranspose, Pseq([~transSampP.next], 1)+~trSamp,
		\octave, Pseq([~octSampP.next], 1)+~octMulSamp,
		\harmonic, Pseq([~strSampP.next], 1)+~harmSamp,
		\legato, Pseq([~legSamp], inf),
		\pan, Pbrown(-0.9, 0.8, 0.125, inf),
		\rootFreq,  ~rootFreqSamp,

		\cut1, Pbrown(0.05, 1.0, 0.125, inf)*~cutSamp,
		\sin1, Pbrown(0.1, 1.0, 0.125, inf)*~sin1Samp,
		\sin2, Pbrown(0.2, 2.0, 0.125, inf)*~sin2Samp,
		\att, ~attSamp,
		\dec, ~decSamp,
		\susLev, ~susLevSamp,
		\rel, ~relSamp,
		\lfo1Rate, ~lfo1SampP*~lfoMulSamp,
		\lfo2Rate, ~lfo2SampP*~lfoMulSamp,
		\group, ~piges,
		\out, Pseq([~busSamp], inf )

		).play;

	Pbind(//LFO 1
		\type, \midi, \midicmd, \control,
		\midiout,~md1, \chan, 4, \ctlNum, 10,
		\delta, Pseq([~delta1SampP.next], 2),
		\control, Pseq([~lfo1SampP.next], 2)*~lfoMulSamp,

	).play;

	Pbind(//LFO 2
		\type, \midi, \midicmd, \control,
		\midiout,~md1,\chan, 4,  \ctlNum, 11,
		\delta, Pseq([~delta2SampP.next], 2),
		\control, Pseq([~lfo2SampP.next], 2)*~lfoMulSamp,

	).play;

	//this.count2;
	//this.timesCount;
}

*osc{
	~xy1Samp.free;
	~xy1Samp= OSCFunc({
		arg msg;




		~sin1Samp=msg[1]+~sin2Samp;
		~sin2Samp=msg[2]+~sin1Samp;

		},
		'/xy1Samp'
	);

	~susLevSampFader.free;
	~susLevSampFader= OSCFunc({
		arg msg;
		~susLevSamp=msg[1];
		//msg[1].postln
		},
		'/susSamp'
	);

	~decSampFader.free;
	~decSampFader= OSCFunc({
		arg msg;
		~decSamp=msg[1];
		//msg[1].postln
		},
		'/decSamp'
	);

	~attSampFader.free;
	~attSampFader= OSCFunc({
		arg msg,val;
		val=msg[1]*2;
		~attSamp=val+0.01;
		},
		'/attSamp'
	);

	~lfoMulSampFad.free;
	~lfoMulSampFad= OSCFunc({
		arg msg;
		~lfoMulSamp=msg[1];
		},
		'/lfoMulSamp'
	);

	~tmSampFader.free;
	~tmSampFader= OSCFunc({
		arg msg;
		~tmSamp.source = msg[1];

		},
		'/timesSamp'
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

	~padSamp.free;
	~padSamp = OSCFunc({
		arg msg;
		if ( msg[1]==1, {

			IFSamp(~tmSampP.next);

		});
		},
		'/padSamp'
	);

}

//Samp Beat Counter
*count3 {
	1.do{
		counter3 = counter3 + 1;
		counter3.switch(
			3, {
				("            SampCnt"+counter3).postln;
				this.ctl_2;
				counter3 = 0;

			}

		)
	}

}


*ctl_1 {


}

*ctl_2 {
	("Samp CTL 2").postln;

}


}