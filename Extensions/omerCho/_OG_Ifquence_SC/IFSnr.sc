/*
IFSnr.times(4);
*/

IFSnr {
	classvar <>counter2=0, <>counter3=0, timeCnt=0;
	var <>sTime=1;


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.cntrl; });*/
		}
	}

	*load {
		this.globals;
		this.proxy;
		this.osc;
		this.apc40;
		//this.beh;
	}
	*globals{

		~snrCh=1;
		~snrLate=0.00;
		~snrTimes=1;
		~rootSnr=0;
		~harmSnr=0;
		~susMulSnr=1;
		~trSnr=0;
		~octMulSnr=0;
		~snrVolC=1;
	}

	*proxy {

		~nt1Snr = PatternProxy( Pseq([0], inf));
		~nt1SnrP = Pseq([~nt1Snr], inf).asStream;
		~amp1Snr = PatternProxy( Pseq([1], inf));
		~amp1SnrP = Pseq([~amp1Snr], inf).asStream;
		~dur1Snr = PatternProxy( Pseq([1], inf));
		~dur1SnrP = Pseq([~dur1Snr], inf).asStream;
		~sus1Snr = PatternProxy( Pseq([1], inf));
		~sus1SnrP = Pseq([~sus1Snr], inf).asStream;

		~transSnr = PatternProxy( Pseq([0], inf));
		~transSnrP = Pseq([~transSnr], inf).asStream;
		~transShufSnr = PatternProxy( Pseq([0], inf));
		~transShufSnrP = Pseq([~transShufSnr], inf).asStream;

		~octSnr = PatternProxy( Pseq([3], inf));
		~octSnrP = Pseq([~octSnr], inf).asStream;

		~strSnr = PatternProxy( Pseq([1.0], inf));
		~strSnrP = Pseq([~strSnr], inf).asStream;

		~volSnr = PatternProxy( Pseq([1], inf));
		~volSnrP= Pseq([~volSnr], inf).asStream;

		~actSnr = PatternProxy( Pseq([1], inf));
		~actSnrP= Pseq([~actSnr], inf).asStream;

		//StaticSnr
		~actStSnr = PatternProxy( Pseq([0], inf));
		~actStSnrP= Pseq([~actStSnr], inf).asStream;
		~durStSnr = PatternProxy( Pseq([1], inf));
		~durStSnrP = Pseq([~durStSnr], inf).asStream;
		~ampStSnr = PatternProxy( Pseq([0,0,0,0,1], inf));
		~ampStSnrP = Pseq([~ampStSnr], inf).asStream;
		~ntStSnr = PatternProxy( Pseq([67], inf));
		~ntStSnrP = Pseq([~ntStSnr], inf).asStream;

	}//*proxy


	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				//~snrLate=~abLate;
				~snrLate.wait;
				this.p1(val);
				//~durMulP*((~dur1SnrP.next)/val).wait;
				((~dur1SnrP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~snrCh,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~dur1SnrP.next], ~actSnrP),
			\degree, Pseq([~nt1SnrP.next], inf),
			\amp, Pseq([~amp1SnrP.next], inf),
			\sustain, Pseq([~sus1SnrP.next],inf)*~susMulSnr,
			\mtranspose, Pseq([~transSnrP.next], inf)+~trSnr+~transShufSnrP.next,
			\octave, Pseq([~octSnrP.next], inf)+~octMulSnr,
			\harmonic, Pseq([~strSnrP.next], inf)+~harmSnr
		).play;

	}

	*stat01 {|i=1|
		var val;
		val=i;
		~staticSnrPat=Pbind(
			\chan, ~snrCh,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~durStSnrP.next],~actStSnrP.next),
			\degree, Pseq([~ntStSnrP.next], inf),
			\amp, Pseq([~ampStSnrP.next], inf)
		).play(TempoClock.default, quant: 1);
	}

	*apc40{


		~volSnr_APC.free;
		~volSnr_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volSnr', vel/127);
			~mdOut.control(3, 1, vel);

		},srcID:~apc40InID, chan:1, ccNum:7);

		//Act ButA
		//Snr Activate
		~cntActLine2ButA=0;
		~mdActLine2ButA.free;
		~mdActLine2ButA=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine2ButA = ~cntActLine2ButA + 1;
				~cntActLine2ButA.switch(
					0,{},
					1, {
						IFAPC40.actLine2ButA(1);
					},
					2,{
						IFAPC40.actLine2ButA(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn2, noteNum:~actButA);

		//Act ButB
		//Snr Time Div2
		~cntActLine2ButB=0;
		~mdActLine2ButB.free;
		~mdActLine2ButB=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine2ButB = ~cntActLine2ButB + 1;
				~cntActLine2ButB.switch(
					0,{},
					1, {
						IFAPC40.actLine2ButB(1);
					},
					2,{
						IFAPC40.actLine2ButB(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn2, noteNum:~actButB);

		//Act ButC
		//Static Snr Activate
		~cntActLine2ButC=0;
		~mdActLine2ButC.free;
		~mdActLine2ButC=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine2ButC = ~cntActLine2ButC + 1;
				~cntActLine2ButC.switch(
					0,{},
					1, {
						IFAPC40.actLine2ButC(1);
					},
					2,{
						IFAPC40.actLine2ButC(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn2, noteNum:~actButC);
	}//*apc40

	*beh{
		~actSnrMD.free;
		~actSnrMD=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~actSnr.source=1;
				~tOSCAdrr.sendMsg('activSnr', 1);
				},{
					~actSnr.source=0;
					~tOSCAdrr.sendMsg('activSnr', 0);
			});
		}, chan:3, ccNum:2);
		~time2SnrMD.free;
		~time2SnrMD=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~countTime2Snr = ~countTime2Snr + 1;
				~tOSCAdrr.sendMsg('time2Snr', 1);
				~tOSCAdrr.sendMsg('tmSnrLabel', 2);
				~tmMulSnr.source = Pseq([2], inf);
				},{
					~tOSCAdrr.sendMsg('time2Snr', 0);
					~tOSCAdrr.sendMsg('tmSnrLabel', 1);
					~tmMulSnr.source = Pseq([1], inf);
					~countTime2Snr=0;
			});
		}, chan:3, ccNum:9);
	}//*beh

	*osc{

		~actSnrBut.free;
		~actSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actSnr.source=1;
				~apc40.noteOn(1, 48, 127); //Trk1_But 1
				//~behOut.control(3, 2, 127);
				},{
					~actSnr.source=0;
					~apc40.noteOff(1, 48, 127); //Trk1_But 1
					//~behOut.control(3, 2, 0);
			});
			},
			'/activSnr'
		);

		~time2SnrBut.free;
		~countTime2Snr=0;
		~time2SnrBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {//"Transpose Shuffle".postln;
				~countTime2Snr = ~countTime2Snr + 1;
				~countTime2Snr.switch(
					0,{},
					1, {
						//~behOut.control(3, 9, 127);
						~apc40.noteOn(1, 49, 127);
						~tOSCAdrr.sendMsg('time2Snr', 1);
						~tOSCAdrr.sendMsg('tmSnrLabel', 2);
						~tmMulSnr.source = Pseq([2], inf);
					},
					2,{
						//~behOut.control(3, 9, 0);
						~apc40.noteOff(1, 49, 127);
						~tOSCAdrr.sendMsg('time2Snr', 0);
						~tOSCAdrr.sendMsg('tmSnrLabel', 1);
						~tmMulSnr.source = Pseq([1], inf);
						~countTime2Snr=0;
					}
				)}
			);
			},
			'/time2Snr'
		);



		~volSnrFader.free;
		~volSnrFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volSnr', msg[1]);
			~mdOut.control(3, 1, vel);
			},
			'/volSnr'
		);

		~attSnrFader.free;
		~attSnrFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('attSnr', msg[1]);
			~mdOut.control(3, 5, vel);
			//~nobD2_m2Val= msg[1]*127;
			},
			'attSnr'
		);

		~susLevSnrFader.free;
		~susLevSnrFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('susSnr', msg[1]);
			~susLevSnr=msg[1];
			~mdOut.control(3, 6, msg[1]*127);


			},
			'/susSnr'
		);

		~decSnrFader.free;
		~decSnrFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('decSnr', msg[1]);
			~decSnr=msg[1];
			~mdOut.control(3, 127, msg[1]*127);
			//~nobD2_m1Val= msg[1]*127;
			},
			'/decSnr'
		);

		~chainSnrFader.free;
		~chainSnrFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('chainSnr', msg[1]);
			~mdOut.control(3, 8, msg[1]*127);
			},
			'/chainSnr'
		);

		~sendSnrXY.free;
		~sendSnrXY= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~mdOut.control(3, 4, vel1); // IFSnr
			~mdOut.control(3, 3, vel2); // IFSnr
			~tOSCAdrr.sendMsg('sendSnr', msg[1], msg[2]);

			},
			'sendSnr'
		);

		//TIME

		~tmMulSnrBut1.free;
		~tmMulSnrBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSnr.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', 1);

			});

			},
			'/tmMulSnr1'
		);
		~tmMulSnrBut2.free;
		~tmMulSnrBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSnr.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', 2);

			});

			},
			'/tmMulSnr2'
		);
		~tmMulSnrBut3.free;
		~tmMulSnrBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSnr.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', 3);

			});

			},
			'/tmMulSnr3'
		);

		~octSnrMulBut.free;
		~octSnrMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSnr = ~octMulSnr+1;
				~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

			});

			},
			'/octSnrMul'
		);

		~octSnrZeroBut.free;
		~octSnrZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSnr = 0;
				~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

			});

			},
			'/octSnrZero'
		);

		~octSnrDivBut.free;
		~octSnrDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSnr = ~octMulSnr-1;
				~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

			});

			},
			'/octSnrDiv'
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

