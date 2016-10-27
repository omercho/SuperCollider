
/*

IFKick(4);
*/

IFKick {
	classvar <>counter2=0, timeCnt=0;
	var <>kTime=1;


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });*/
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
				led= ~amp1Kick.value;

				//~kickLate=~abLate;
				~kickLate.wait;

				this.p1(val);

				~kickLedFork={

						~tOSCAdrr.sendMsg('kickLed', 1);
						0.25.wait;
						~tOSCAdrr.sendMsg('kickLed', 0);

				}.fork;

				~durMulP*((~dur1KickP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;


		Pbind(
			\chan, ~kickCh,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~dur1KickP.next/val],1),
			\degree,  Pseq([~nt1KickP.next], inf),
			\amp, Pseq([~amp1KickP.next], inf),
			\sustain, Pseq([~sus1KickP.next],inf)*~susMulKick,
			\octave, Pseq([~octKickP.next], inf)+~octMulKick,
			\mtranspose, Pseq([~transKickP.next], inf)+~trKick,
			\harmonic, Pseq([~strKickP.next], inf)+~harmKick,
		).play(quant:0);

		//this.count2;
		//this.timesCount;
	}

	*osc{
		~attKickFader.free;
		~attKickFader= OSCFunc({
			arg msg,val;
			val=msg[1];
			~tOSCAdrr.sendMsg('attKick', msg[1]);
			//~attKick=val+0.01;
			},
			'/attKick'
		);

		~susLevKickFader.free;
		~susLevKickFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('susKick', msg[1]);
			//~susLevKick=msg[1];

			},
			'/susKick'
		);

		~decKickFader.free;
		~decKickFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('decKick', msg[1]);
			//~decKick=msg[1];

			},
			'/decKick'
		);

		//TIME
		~tmMulKickBut1.free;
		~tmMulKickBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulKick.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmKickLabel', 1);

			});

			},
			'/tmMulKick1'
		);
		~tmMulKickBut2.free;
		~tmMulKickBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulKick.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmKickLabel', 2);

			});

			},
			'/tmMulKick2'
		);
		~tmMulKickBut3.free;
		~tmMulKickBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulKick.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmKickLabel', 3);

			});

			},
			'/tmMulKick3'
		);
		~tmKickFader.free;
		~tmKickFader= OSCFunc({
			arg msg;
			~tmKick.source = msg[1];

			},
			'/timesKick'
		);

		~padKick.free;
		~padKick = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFKick(~tmMulKickP.next*~tmKickP.next);

			});
			},
			'/padKick'
		);

		//----Kick-------
		~octKickMulBut.free;
		~octKickMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulKick = ~octMulKick+1;
				~tOSCAdrr.sendMsg('octKickLabel', ~octMulKick);

			});

			},
			'/octKickMul'
		);

		~octKickZeroBut.free;
		~octKickZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulKick = 0;
				~tOSCAdrr.sendMsg('octKickLabel', ~octMulKick);

			});

			},
			'/octKickZero'
		);

		~octKickDivBut.free;
		~octKickDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulKick = ~octMulKick-1;
				~tOSCAdrr.sendMsg('octKickLabel', ~octMulKick);

			});

			},
			'/octKickDiv'
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

