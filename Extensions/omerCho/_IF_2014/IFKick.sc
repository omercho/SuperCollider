
/*

IFKick(4);
*/

	IFKick {
	classvar <>counter2=0, timeCnt=0;
	var <>kTime=1;


	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet; this.default; });
		}
	}

	*globals{

		~kickCh=0;
		~kickLate= 0.00;
		~kickTimes=1;
		~octMulKick=0;
		~trKick=0;
		~rootKick=0;
		~harmKick=0;
		~susMulKick=1;
		~drumVolC=0; ~kickVolC=1;
	}

	*preSet {
		~md1.control(~kickCh, ~drumVolC, 100); //Drum Channel Master Volume
		//~mdTouch.control(1, 11, 1); //KickVol
		~md1.control(1, 11, 120); //KickVol

	}

	*default {

		~nt1Kick = PatternProxy( Pseq([0], inf));
		~nt1KickP = Pseq([~nt1Kick], inf).asStream;
		~dur1Kick = PatternProxy( Pseq([1], inf));
		~dur1KickP = Pseq([~dur1Kick], inf).asStream;
		~amp1Kick = PatternProxy( Pseq([1], inf));
		~amp1KickP = Pseq([~amp1Kick], inf).asStream;
		~sus1Kick = PatternProxy( Pseq([0.5], inf));
		~sus1KickP = Pseq([~sus1Kick], inf).asStream;

		~tmMulKick = PatternProxy( Pseq([1], inf));
		~tmMulKickP= Pseq([~tmMulKick], inf).asStream;

		~tmKick = PatternProxy( Pseq([1], inf));
		~tmKickP= Pseq([~tmKick], inf).asStream;

		~transKick = PatternProxy( Pseq([0], inf));
		~transKickP = Pseq([~transKick], inf).asStream;
		~octKick = PatternProxy( Pseq([4], inf));
		~octKickP = Pseq([~octKick], inf).asStream;
		//~legKick = PatternProxy( Pseq([0.0], inf));
		//~legKickP = Pseq([~legKick], inf).asStream;
		~strKick = PatternProxy( Pseq([1.0], inf));
		~strKickP = Pseq([~strKick], inf).asStream;



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
		Pbind(
			\chan, ~kickCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([~dur1KickP.next/val],1)], 1),
			\degree, Pseq([~nt1KickP.next], 1),
			\amp, Pseq([~amp1KickP.next], 1),
			\sustain, Pseq([~sus1KickP.next],1)*~susMulKick,
			\mtranspose, Pseq([~transKickP.next], 1)+~trKick,
			\octave, Pseq([~octKickP.next], 1)+~octMulKick,
			\harmonic, Pseq([~strKickP.next], 1)+~harmKick
		).play;


		//this.count2;
		//this.timesCount;
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

