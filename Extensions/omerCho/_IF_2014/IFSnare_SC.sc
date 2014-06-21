
/*

IFSnr.times(4);
*/

IFSnr_SC {
	classvar <>counter2=0, <>counter3=0, timeCnt=0;
	var <>sTime=1;


	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });
		}
	}

	*globals{

		~snrCh=1;
		~snrLate=0.00;
		~snrTimes=1;
		~rootSnr=0;
		~harmSnr=0;

		~trSnr=0;

		~octMulSnr=0;

		~snrVolC=1;
	}

	*preSet {

		SynthDef(\IFSnr_SC, {| att =0.01, sustain=0.1, dec=0.0, susLev=1.2, rel=0.09, mul = 0.9,
			gate=1, wnoise=2.8,
			lfo1Rate=1, lfo2Rate=1,
			amp=0.9,out=0, freq=110, freq2=69, freq3=49, pan = 0 |

			var env, env1, env1m, ses,lfo1, lfo2;
			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 1.9);
			env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
			env1 = EnvGen.ar(Env.new([freq, freq2, freq3], [0.005, sustain], [-4, -5]));
			env1m = env1.midicps;

			ses = SinOsc.ar(env1m*4,lfo2-0.9);
			ses = Mix.ar(ses*0.02,WhiteNoise.ar(wnoise));
			ses = HPF.ar(ses, env1m, env);
			ses = ses + SinOsc.ar(env1m, 0.5, env);
			ses = ses.clip2(0.2+wnoise);
			ses = ses * mul;
			Out.ar(out, Pan2.ar(ses, pan, amp*1.1)*env);
		}).add;

	}



	*default {

		~nt1Snr = PatternProxy( Pseq([0], inf));
		~nt1SnrP = Pseq([~nt1Snr], inf).asStream;
		~dur1Snr = PatternProxy( Pseq([1], inf));
		~dur1SnrP = Pseq([~dur1Snr], inf).asStream;
		~amp1Snr = PatternProxy( Pseq([1], inf));
		~amp1SnrP = Pseq([~amp1Snr], inf).asStream;
		~sus1Snr = PatternProxy( Pseq([1], inf));
		~sus1SnrP = Pseq([~sus1Snr], inf).asStream;

		~susMulSnr=1;
		~attSnr=0.001;
		~decSnr=0.08;
		~susLevSnr=0.0;
		~relSnr = 0.09;
		~wnoise=1.0;


		~tmMulSnr = PatternProxy( Pseq([1], inf));
		~tmMulSnrP= Pseq([~tmMulSnr], inf).asStream;

		~tmSnr = PatternProxy( Pseq([1], inf));
		~tmSnrP= Pseq([~tmSnr], inf).asStream;

		~transSnr = PatternProxy( Pseq([0], inf));
		~transSnrP = Pseq([~transSnr], inf).asStream;
		~octSnr = PatternProxy( Pseq([4], inf));
		~octSnrP = Pseq([~octSnr], inf).asStream;
		~strSnr = PatternProxy( Pseq([1.0], inf));
		~strSnrP = Pseq([~strSnr], inf).asStream;

		~lfoMulSnr=1;
		~lfo1Snr = PatternProxy( Pseq([1], inf));
		~lfo1SnrP = Pseq([~lfo1Snr], inf).asStream;
		~lfo2Snr = PatternProxy( Pseq([1], inf));
		~lfo2SnrP = Pseq([~lfo2Snr], inf).asStream;

	}


	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{var led;
				led= ~amp1Snr.asStream.value;

				~snrLate.wait;

				this.p1(val);

				if ( led>0, {

					1.do{
						~tOSCAdrr.sendMsg('snrLed', led);
						0.1+~sus1Snr.asStream.value.wait;
						~tOSCAdrr.sendMsg('snrLed', 0.0);
					};

					},{
						~tOSCAdrr.sendMsg('snrLed', 0.0);

				});

				//~dur1SnrSon.value;
				~durMulP*((~dur1SnrP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;

		Pbind(\instrument, \IFSnr_SC, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1SnrP.next/val],1),
			\degree, Pseq([~nt1SnrP.next], 1),
			\amp, Pseq([~amp1SnrP.next], 1),
			\sustain, Pseq([~sus1SnrP.next],1)*~susMulSnr,
			\mtranspose, Pseq([~transSnrP.next], 1)+~trSnr,
			\octave, Pseq([~octSnrP.next], 1)+~octMulSnr,
			\harmonic, Pseq([~strSnrP.next], 1)+~harmSnr,
			\pan, Pbrown(-0.5, 0.5, 0.125, inf),
			\att, ~attSnr,
			\dec, ~decSnr,
			\susLev, ~susLevSnr,
			\rel, ~relSnr,
			\wnoise,Pseq([0.2, 0.1, 0.06, 5], inf)*~wnoise,
			\lfo1Rate, ~lfo1SnrP*~lfoMulSnr,
			\lfo2Rate, ~lfo2SnrP*~lfoMulSnr,
			\group, ~piges,
			\out, Pseq([[~busSnr]], inf )
		).play;

		//this.count2;
		//this.timesCount;
	}

	*osc{

		~xy1Snr.free;
		~xy1Snr= OSCFunc({
			arg msg;



			},
			'/xy1Snr'
		);

		~attSnrFader.free;
		~attSnrFader= OSCFunc({
			arg msg,val;
			val=msg[1]*2;
			~attSnr=val+0.01;
			},
			'/attSnr'
		);
		~susLevSnrFader.free;
		~susLevSnrFader= OSCFunc({
			arg msg;
			~susLevSnr=msg[1];
			msg[1].postln
			},
			'/susSnr'
		);

		~decSnrFader.free;
		~decSnrFader= OSCFunc({
			arg msg;
			~decSnr=msg[1];
			msg[1].postln
			},
			'/decSnr'
		);

		~tmSnrFader.free;
		~tmSnrFader= OSCFunc({
			arg msg;
			~tmSnr.source = msg[1];

			},
			'/timesSnr'
		);
		~tmMulSnrBut.free;
		~tmMulSnrBut= OSCFunc({
			arg msg;
			~tmMulSnr.source = msg[1];

			},
			'/tmMulSnr'
		);

		~lfoMulSnrFad.free;
		~lfoMulSnrFad= OSCFunc({
			arg msg;
			~lfoMulSnr=msg[1];
			},
			'/lfoMulSnr'
		);

		//MUTES
		~vSnrMtCln.free;
		~vSnrMtCln= OSCFunc({
			arg msg;

			~vSnrSynth.set(\mtCln, msg[1]);

			},
			'/mtClnSnr'
		);
		~vSnrMtDly.free;
		~vSnrMtDly= OSCFunc({
			arg msg;

			~vSnrSynth.set(\mtDly, msg[1]);

			},
			'/mtDlySnr'
		);
		~vSnrMtRev.free;
		~vSnrMtRev= OSCFunc({
			arg msg;

			~vSnrSynth.set(\mtRev, msg[1]);

			},
			'/mtRevSnr'
		);
		~vSnrMtFlo.free;
		~vSnrMtFlo= OSCFunc({
			arg msg;

			~vSnrSynth.set(\mtFlo, msg[1]);

			},
			'/mtFloSnr'
		);

		~padSnr.free;
		~padSnr = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFSnr(~tmSnrP.next);

			});
			},
			'/padSnr'
		);

	}

	//Snr Beat Counter
	*timesCount {
		timeCnt = timeCnt + 1;
		timeCnt.switch(

			1, {  },
			4, {  },
			6, {  },
			8, {  },
			9, {  },
			10, {  },
			15, {  },
			17, {  },
			18, {
				("        -----------SnareTimesCnt"+timeCnt).postln;

				timeCnt=0;
			},

		);

	}

	*count2 {
		1.do{
			counter2 = counter2 + 1;
			counter2.switch(
				3, {
					("            SnareCnt"+counter2).postln;
					this.ctl_2;
					counter2 = 0;

				}

			)
		}

	}


	*ctl_1 {


	}

	*ctl_2 {


	}

	*ctl_3 {


	}
	*ctl_9 {



	}

	*ctl_18 {



	}

}

