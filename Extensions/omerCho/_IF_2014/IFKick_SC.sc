
/*

IFKick(4);
*/

IFKick_SC {
	classvar <>counter2=0, timeCnt=0;
	var <>kTime=1;


	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });
		}
	}

	*globals{

		~kickCh=0;
		~kickLate= 0.0;
		~kickTimes=1;
		~octMulKick=0;
		~trKick=0;
		~rootKick=0;
		~harmKick=0;
		~susMulKick=1;
		~drumVolC=0; ~kickVolC=1;
	}

	*preSet {
		SynthDef(\IFKick_SC, {| att =0.01, dec=0.0, susLev=1.2, rel=0.09, mul = 0.9,
			gate=1, wnoise=2.8,
			amp=0.5,out=0, freq=110, freq2=59, freq3=29, pan = 0 |

			var env, env1, env1m, ses;
			env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
			env1 = EnvGen.ar(Env.new([freq, freq2, freq3], [0.005, 0.29], [-4, -5]));
			env1m = env1.midicps;

			ses = LFPulse.ar(env1m, 0, 0.5, env, -0.5);
			ses = (ses + WhiteNoise.ar(wnoise))*env;
			ses = LPF.ar(ses, env1m, env);
			ses = ses + SinOsc.ar(env1m, 0.5, env);
			ses = ses.clip2(2);
			ses = ses * mul;
			Out.ar(out, Pan2.ar(ses, pan, amp*1.1));
		}).add;

	}

	*default {

		~nt1Kick = PatternProxy( Pseq([0], inf));
		~nt1KickP = Pseq([~nt1Kick], inf).asStream;
		~dur1Kick = PatternProxy( Pseq([1], inf));
		~dur1KickP = Pseq([~dur1Kick], inf).asStream;
		~amp1Kick = PatternProxy( Pseq([1], inf));
		~amp1KickP = Pseq([~amp1Kick], inf).asStream;
		~sus1Kick = PatternProxy( Pseq([0.05], inf));
		~sus1KickP = Pseq([~sus1Kick], inf).asStream;

		~tmMulKick = PatternProxy( Pseq([1], inf));
		~tmMulKickP= Pseq([~tmMulKick], inf).asStream;

		~tmKick = PatternProxy( Pseq([1], inf));
		~tmKickP= Pseq([~tmKick], inf).asStream;

		~attKick =0.001;
		~decKick =0.8;
		~relKick =0.04;
		~susLevKick = 0.01;

		~transKick = PatternProxy( Pseq([0], inf));
		~transKickP = Pseq([~transKick], inf).asStream;
		~octKick = PatternProxy( Pseq([3], inf));
		~octKickP = Pseq([~octKick], inf).asStream;
		//~legKick = PatternProxy( Pseq([0.0], inf));
		//~legKickP = Pseq([~legKick], inf).asStream;
		~strKick = PatternProxy( Pseq([1.0], inf));
		~strKickP = Pseq([~strKick], inf).asStream;

		~volKick = PatternProxy( Pseq([1], inf));
		~volKickP= Pseq([~volKick], inf).asStream;



	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{var led;
				led= ~amp1Kick.asStream.value;

				//~kickLate=~abLate;
				~kickLate.wait;

				this.p1(val);

				if ( led>0, {

					1.do{
						~tOSCAdrr.sendMsg('kickLed', led);
						~sus1Kick.asStream.value.wait;
						~tOSCAdrr.sendMsg('kickLed', 0);
					};

					},{
						~tOSCAdrr.sendMsg('kickLed', 0.0);

				});

				~durMulP*((~dur1KickP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;

		/*OCDrumKick01.ar(
		amp: ~amp1KickP.next,
		sus: ((~sus1KickP.next)*~susMulKick)*0.1,
		freq1:((~nt1KickP.next*10)+(~transKickP.next)+~trKick),
		freq2:69+((~strKickP.next)+~harmKick),
		freq3:29+~harmKick,
		wnoise:0.1,
		room:0.1
		).play;*/

		Pbind(\instrument, \IFKick_SC,
			\octave, Pseq([~octKickP.next], 1)+~octMulKick,
			\dur, Pseq([Pseq([~dur1KickP.next/val],1)], 1),
			\degree,  Pseq([~nt1KickP.next], 1),
			\amp, Pseq([~amp1KickP.next], 1),
			\sustain, Pseq([~sus1KickP.next],1)*~susMulKick*~susTD,
			\mtranspose, Pseq([~transKickP.next], 1)+~trKick,
			\harmonic, Pseq([~strKickP.next], 1)+~harmKick,
			\pan, 0,
			\att, ~attKick,
			\dec, ~decKick,
			\rel, ~relKick,
			\susLev, ~susLevKick,
			\wnoise,3,
			\group, ~piges,
			\out, Pseq([~busKick], inf )
		).play(quant:0);

		//this.count2;
		//this.timesCount;
	}

	*osc{
		~attKickFader.free;
		~attKickFader= OSCFunc({
			arg msg,val;
			val=msg[1]*2;
			~attKick=val+0.01;
			},
			'/attKick'
		);

		~susLevKickFader.free;
		~susLevKickFader= OSCFunc({
			arg msg;
			~susLevKick=msg[1]*2;
			msg[1].postln
			},
			'/susKick'
		);

		~decSnrFader.free;
		~decSnrFader= OSCFunc({
			arg msg;
			~decKick=msg[1]*2;
			msg[1].postln
			},
			'/decKick'
		);

		~tmKickFader.free;
		~tmKickFader= OSCFunc({
			arg msg;
			~tmKick.source = msg[1];

			},
			'/timesKick'
		);
		~tmMulKickBut.free;
		~tmMulKickBut= OSCFunc({
			arg msg;
			~tmMulKick.source = msg[1];

			},
			'/tmMulKick'
		);
		//MUTES
		~vKickMtCln.free;
		~vKickMtCln= OSCFunc({
			arg msg;
			~vKickSynth.set(\mtCln, msg[1]);
			},
			'/mtClnKick'
		);

		~vKickMtDly.free;
		~vKickMtDly= OSCFunc({
			arg msg;
			~vKickSynth.set(\mtDly, msg[1]);
			},
			'/mtDlyKick'
		);
		~vKickMtRev.free;
		~vKickMtRev= OSCFunc({
			arg msg;

			~vKickSynth.set(\mtRev, msg[1]);

			},
			'/mtRevKick'
		);
		~vKickMtFlo.free;
		~vKickMtFlo= OSCFunc({
			arg msg;

			~vKickSynth.set(\mtFlo, msg[1]);

			},
			'/mtFloKick'
		);

		~padKick.free;
		~padKick = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFKick(~tmKickP.next);

			});
			},
			'/padKick'
		);

	}

	//Drum Beat Counter
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
				("        -----------KickTimesCnt"+timeCnt).postln;

				timeCnt=0;
			},

		);

	}

	*count2 {
		1.do{
			counter2 = counter2 + 1;
			counter2.switch(
				2, {
					("            KickCnt"+counter2).postln;
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

