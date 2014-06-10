
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

		SynthDef(\IFSnr_SC, {|
			att =0.01, dec=0.3, sustain=0.1,susLev=0.8, rel=0.9, mul = 0.8, pan = 0.9,
			wnoise=0.2, gate=1,
			out = 0, amp = 1, freq = 100, decayTime = 0.7, bpfilter = 1900|

			var env0, env1, env2, env1m, oscs, noise, ses;

			env0 = EnvGen.ar(Env.new([0.0, dec, susLev, 0], [att, sustain, rel], [-4, -2, -4], 1), gate, doneAction:2);
			env1 = EnvGen.ar(Env.new([freq, 160, 140], [att, susLev], [-4, -5]));
			env1m = env1.midicps;
			env2 = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);

			oscs = LFPulse.ar(env1m*2, 0, 0.5, 0.3, -0.5) + LFPulse.ar(env1m * 1.2, 0, 0.5, 0.3, -0.25);
			oscs = BPF.ar(oscs, env1m, env2);
			oscs = oscs + SinOsc.ar(env1m, 0.8, env2);
			oscs = oscs * env2;

			noise = WhiteNoise.ar(wnoise);
			noise = BPF.ar(noise, bpfilter/4, 1);
			noise = HPF.ar(noise, freq, 0.6, 3) * noise;
			//noise = noise * env2;

			ses = (oscs * noise);
			ses = ses.clip2(2);
			ses = Ringz.ar(ses, freq, 0.02, *env2);

			Out.ar(out, Pan2.ar(ses, pan, amp*0.2)*mul)*env2;
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
					~sus1Snr.asStream.value.wait;
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
			\wnoise,Pseq([0.2, 0.1, 0.06, 5], inf),
			\group, ~piges,
			\out, Pseq([[~busSnr]], inf )
		).play;

		//this.count2;
		//this.timesCount;
	}

	*osc{

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

