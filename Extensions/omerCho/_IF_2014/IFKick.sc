
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
		~actKick=1;
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



		~transKick = PatternProxy( Pseq([0], inf));
		~transKickP = Pseq([~transKick], inf).asStream;

		~octKick = PatternProxy( Pseq([3], inf));
		~octKickP = Pseq([~octKick], inf).asStream;

		~strKick = PatternProxy( Pseq([1.0], inf));
		~strKickP = Pseq([~strKick], inf).asStream;

		~volKick = PatternProxy( Pseq([1], inf));
		~volKickP= Pseq([~volKick], inf).asStream;

		~actKick = PatternProxy( Pseq([1], inf));
		~actKickP= Pseq([~actKick], inf).asStream;



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

						~tOSCAdrr.sendMsg('kickLed', ~actKickP);
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
			\dur, Pseq([~dur1KickP.next/val],~actKickP),
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

		~actKickBut.free;
		~actKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actKick.source=1;
				~behOut.control(2, 2, 127);
			},{
					~actKick.source=0;
					~behOut.control(2, 2, 0);
			});
			},
			'/activKick'
		);
		~actKickMD.free;
		~actKickMD=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~actKick.source=1;
				~tOSCAdrr.sendMsg('activKick', 1);
				},{
					~actKick.source=0;
					~tOSCAdrr.sendMsg('activKick', 0);
			});
		}, chan:2, ccNum:2);

		//TIME

		~time2KickBut.free;
		~countTime2Kick=0;
		~time2KickBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {//"Transpose Shuffle".postln;
				~countTime2Kick = ~countTime2Kick + 1;
				~countTime2Kick.switch(
					0,{},
					1, {
						~behOut.control(2, 9, 127);
						~tOSCAdrr.sendMsg('time2Kick', 1);
						~tOSCAdrr.sendMsg('tmKickLabel', 2);
						~tmMulKick.source = Pseq([2], inf);
					},
					2,{
						~behOut.control(2, 9, 0);
						~tOSCAdrr.sendMsg('time2Kick', 0);
						~tOSCAdrr.sendMsg('tmKickLabel', 1);
						~tmMulKick.source = Pseq([1], inf);
						~countTime2Kick=0;
					}
				)}
			);
			},
			'/time2Kick'
		);

		~time2KickMD.free;
		~time2KickMD=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~countTime2Kick = ~countTime2Kick + 1;
				~tOSCAdrr.sendMsg('time2Kick', 1);
				~tOSCAdrr.sendMsg('tmKickLabel', 2);
				~tmMulKick.source = Pseq([2], inf);
				},{
					~tOSCAdrr.sendMsg('time2Kick', 0);
					~tOSCAdrr.sendMsg('tmKickLabel', 1);
					~tmMulKick.source = Pseq([1], inf);
					~countTime2Kick=0;
			});
		}, chan:2, ccNum:9);

		~volKickFader.free;
		~volKickFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volKick', msg[1]);
			~mdOut.control(2, 1, vel);
			},
			'/volKick'
		);

		~attKickFader.free;
		~attKickFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('attKick', msg[1]);
			~mdOut.control(2, 5, vel);
			},
			'attKick'
		);

		~susLevKickFader.free;
		~susLevKickFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('susKick', msg[1]);
			~susLevKick=msg[1];
			~mdOut.control(2, 6, msg[1]*127);

			},
			'/susKick'
		);

		~decKickFader.free;
		~decKickFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('decKick', msg[1]);
			~decKick=msg[1];
			~mdOut.control(2, 7, msg[1]*127);
			},
			'/decKick'
		);

		~chainKickFader.free;
		~chainKickFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('chainKick', msg[1]);
			~mdOut.control(2, 8, msg[1]*127);
			},
			'/chainKick'
		);

		~sendKickXY.free;
		~sendKickXY= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~mdOut.control(2, 4, vel1); // IFKick
			~mdOut.control(2, 3, vel2); // IFKick
			~tOSCAdrr.sendMsg('sendKick', msg[1], msg[2]);

			},
			'sendKick'
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

