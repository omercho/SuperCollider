
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
			Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });
		}
	}

	*globals{

		~chSamp=5;
		~sampLate=0.00;
		~timesSamp=1;
		~octMulSamp=0;
		~rootSamp=0;
		~harmSamp=0;
		~susMulSamp=1;
		~trSamp=0;


	}

	*preSet{
		SynthDef( \IFSamp_SC, { |out, amp = 0.9, susLev = 0.1, freq = 60, freqlp=1250, mul=0.7,
			sin1 = 0, sin2 = 0.1, brown = 0.1, saw = 40, pan=0, cut1=0.5, gate=1,
			lfo1Rate=1, lfo2Rate=2,
			att = 0.05, dec=0.02, rel = 0.02 |

			var in, osc, env,ses;
			var lfo1, lfo2, decay, den;
			lfo1 = Saw.kr(lfo1Rate).range(1.0, 1.2);
			lfo2 = LFNoise2.kr(lfo2Rate).range(1.0, 2.0);
			den =  LFSaw.ar(freq*lfo2, Decay.ar(SinOsc.ar(sin1, sin2), 4.2.abs, Saw.ar(saw)));
			//env =  EnvGen.ar(Env.perc(att, rel), doneAction: 2, levelScale: 0.8, timeScale: sus);
			env = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
			decay = Decay2.ar(
				SinOsc.ar(sin1, sin2),
				LFSaw.ar(sin2, sin1),
				Saw.ar(saw)*den
			)*lfo1;

			in = LFSaw.ar(LFSaw.ar(freq, cut1, brown), 0.3)*0.3**lfo2;
			ses = LFSaw.ar(freq, den, brown);
			ses = RLPF.ar(Mix.ar(ses,in), freqlp*cut1*lfo2, cut1, 0.9, 0.6);
			ses = 0.5*(ses*SinOsc.ar(freq,decay/den));

			ses = DelayC.ar( ses, 0.01, 0.001*lfo2, 4.5.abs, 0.3, ses);
			ses = (Mix.ar(ses*0.3,den*1.4,in*1.2)*amp*env);
			//ses = Limiter.ar(ses, 0.9, 0.01);

			Out.ar(out, Pan2.ar(ses, pan, mul));
		}).add;

	}


	*default {

		~nt1Samp = PatternProxy( Pseq([0], inf));
		~nt1SampP = Pseq([~nt1Samp], inf).asStream;
		~dur1Samp = PatternProxy( Pseq([1], inf));
		~dur1SampP = Pseq([~dur1Samp], inf).asStream;
		~amp1Samp = PatternProxy( Pseq([0.9], inf));
		~amp1SampP = Pseq([~amp1Samp], inf).asStream;
		~sus1Samp = PatternProxy( Pseq([1], inf));
		~sus1SampP = Pseq([~sus1Samp], inf).asStream;

		~attSamp=0.1;
		~decSamp=0.8;
		~susLevSamp=0.1;
		~relSamp = 0.2;
		~lfoMulSamp=0;
		~cutSamp=1;
		~brownSamp=1.0;
		~sawSamp=0.11;
		~sin1Samp=0.1;
		~sin2Samp=2.1;
		~tmSamp = PatternProxy( Pseq([1], inf));
		~tmSampP= Pseq([~tmSamp], inf).asStream;

		~transSamp = PatternProxy( Pseq([0], inf));
		~transSampP = Pseq([~transSamp], inf).asStream;
		~octSamp = PatternProxy( Pseq([4], inf));
		~octSampP = Pseq([~octSamp], inf).asStream;
		~legSamp = PatternProxy( Pseq([0.0], inf));
		~legSampP = Pseq([~legSamp], inf).asStream;
		~strSamp = PatternProxy( Pseq([1.0], inf));
		~strSampP = Pseq([~strSamp], inf).asStream;

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
			\dur, Pseq([Pseq([~dur1SampP.next],1)], 1),
			\degree, Pseq([~nt1SampP.next], 1),
			\amp, Pseq([~amp1SampP.next], 1),
			\sustain, Pseq([~sus1SampP.next],1)*~susMulSamp,
			\mtranspose, Pseq([~transSampP.next], 1)+~trSamp,
			\octave, Pseq([~octSampP.next], 1)+~octMulSamp,
			\harmonic, Pseq([~strSampP.next], 1)+~harmSamp,
			\pan, Pbrown(-1.0, 1.0, 0.125, inf),
			\brown, Pbrown(0.0, 1.0, 0.125, inf)*~brownSamp,
			\saw, Pbrown(0.4, 100.0, 0.125, inf)*~sawSamp,
			\cut1, Pbrown(0.0, 1.0, 0.125, inf)*~cutSamp,
			\sin1, Pbrown(0.4, 100.0, 10.125, inf)*~sin1Samp,
			\sin2, Pbrown(0.4, 100.0, 20.125, inf)*~sin2Samp,
			\att, ~attSamp,
			\dec, ~decSamp,
			\susLev, ~susLevSamp,
			\rel, ~relHat,
			\lfo1Rate, ~lfo1SampP*~lfoMulSamp,
			\lfo2Rate, ~lfo2SampP*~lfoMulSamp,
			\group, ~piges,
			\out, Pseq([~busSamp], inf )


		).play;

		/*Pbind(
		\chan, ~chSamp,
		\type, \midi, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
		\dur, Pseq([Pseq([~dur1SampP.next],1)], 1),
		\degree, Pseq([~nt1SampP.next], 1),
		\amp, Pseq([~amp1SampP.next], 1),
		\sustain, Pseq([~sus1SampP.next],1)*~susMulSamp,
		\mtranspose, Pseq([~transSampP.next], 1)+~trSamp,
		\octave, Pseq([~octSampP.next], 1)+~octMulSamp,
		\harmonic, Pseq([~strSampP.next], 1)+~harmSamp
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

		).play;*/

		//this.count2;
		//this.timesCount;
	}

	*osc{
		~xy1Samp.free;
		~xy1Samp= OSCFunc({
			arg msg;




			~sin1Samp=msg[1];
			~sin2Samp=msg[2];

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