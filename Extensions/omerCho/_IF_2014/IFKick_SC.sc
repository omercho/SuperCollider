
/*

IFKick(4);
*/

IFKick_SC {
	classvar <>counter2=0, timeCnt=0;
	var <>kTime=1;


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });*/
		}
	}

	*globals{

		~kickCh=0;
		~kickLate= 0.02;
		~kickTimes=1;
		~octMulKick=0;
		~trKick=0;
		~rootKick=0;
		~harmKick=0;
		~susMulKick=1;
		~drumVolC=0; ~kickVolC=1;
	}

	*preSet {


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


		~transKick = PatternProxy( Pseq([0], inf));
		~transKickP = Pseq([~transKick], inf).asStream;
		~octKick = PatternProxy( Pseq([3], inf));
		~octKickP = Pseq([~octKick], inf).asStream;

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
						2/~sus1Kick.asStream.value.wait;
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

		Pbind(
			\chan, ~kickCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl1}, inf),
			\octave, Pseq([~octKickP.next], 1)+~octMulKick,
			\dur, Pseq([Pseq([~dur1KickP.next/val],1)], 1),
			\degree,  Pseq([~nt1KickP.next], 1),
			\amp, Pseq([~amp1KickP.next], 1),
			\sustain, Pseq([~sus1KickP.next],1)*~susMulKick*~susTD,
			\mtranspose, Pseq([~transKickP.next], 1)+~trKick,
			\harmonic, Pseq([~strKickP.next], 1)+~harmKick,
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



}

