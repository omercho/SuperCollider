/*
IFSnr.times(4);


PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;



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
	}
	*globals{

		~snrCh=10;
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
		~extraShufSnr = PatternProxy( Pshuf([0], inf));
		~extraShufSnrP = Pseq([~extraShufSnr], inf).asStream;

		~octSnr = PatternProxy( Pseq([3], inf));
		~octSnrP = Pseq([~octSnr], inf).asStream;

		~hrmSnr = PatternProxy( Pseq([1.0], inf));
		~hrmSnrP = Pseq([~hrmSnr], inf).asStream;

		~volSnr = PatternProxy( Pseq([1], inf));
		~volSnrP= Pseq([~volSnr], inf).asStream;

		~actSnr = PatternProxy( Pseq([1], inf));
		~actSnrP= Pseq([~actSnr], inf).asStream;


		~delta2VSamp = PatternProxy( Pseq([1/1], inf));
		~delta2VSampP = Pseq([~delta2VSamp], inf).asStream;

		/*//StaticSnr
		~actStSnr = PatternProxy( Pseq([0], inf));
		~actStSnrP= Pseq([~actStSnr], inf).asStream;
		~durStSnr = PatternProxy( Pseq([1], inf));
		~durStSnrP = Pseq([~durStSnr], inf).asStream;
		~ampStSnr = PatternProxy( Pseq([0,0,0,0,1], inf));
		~ampStSnrP = Pseq([~ampStSnr], inf).asStream;
		~ntStSnr = PatternProxy( Pseq([67], inf));
		~ntStSnrP = Pseq([~ntStSnr], inf).asStream;*/

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
			\chan, ~smp02,
			\type, \midi, \midiout,~vSamp,
			\dur, Pseq([~dur1SnrP.next], ~actSnrP),
			\amp, Pseq([~amp1SnrP.next], inf),
			\sustain, Pseq([~sus1SnrP.next],inf)*~susMulSnr
		).play(quant:0);
		Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~vSamp, \chan, ~smp02, \ctlNum, ~smpSpeed,
			\delta, Pseq([~delta2VSampP.next], 1),
			\control, Pseq([30+~nt1SnrP.next], 1),

		).play(quant:0);

	}


	*apc40{


		~volSnr_APC.free;
		~volSnr_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volVSamp2', vel/127);
			~vSamp.control(~smp02, ~smpLvl, vel);

		},srcID:~apc40InID, chan:~apcMnCh, ccNum:~apcFd2);

		//Act ButA2
		//Snr Activate
		~cntActLine2ButA2=0;
		~mdActLine2ButA2.free;
		~mdActLine2ButA2=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine2ButA2 = ~cntActLine2ButA2 + 1;
				~cntActLine2ButA2.switch(
					0,{},
					1, {
						IFAPC40.actLine2ButA2(1);
					},
					2,{
						IFAPC40.actLine2ButA2(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButA2);

		//Act ButB2
		//Snr Time Div2
		~cntActLine2ButB2=0;
		~mdActLine2ButB2.free;
		~mdActLine2ButB2=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine2ButB2 = ~cntActLine2ButB2 + 1;
				~cntActLine2ButB2.switch(
					0,{},
					1, {
						IFAPC40.actLine2ButB2(1);
					},
					2,{
						IFAPC40.actLine2ButB2(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButB2);

		//Act ButC2
		//Static Snr Activate
		~cntActLine2ButC2=0;
		~mdActLine2ButC2.free;
		~mdActLine2ButC2=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine2ButC2 = ~cntActLine2ButC2 + 1;
				~cntActLine2ButC2.switch(
					0,{},
					1, {
						IFAPC40.actLine2ButC2(1);
					},
					2,{
						IFAPC40.actLine2ButC2(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButC2);


	}//*apc40

	*osc{

		~actSnrBut.free;
		~actSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actSnr.source=1;
				~apc40.noteOn(~apcMnCh, ~actButA2, 127); //Trk1_But 1

				},{
					~actSnr.source=0;
					~apc40.noteOff(~apcMnCh, ~actButA2, 127); //Trk1_But 1

			});
			},
			'/activSnr'
		);

		~time2SnrBut.free;
		~countTime2Snr=0;
		~time2SnrBut= OSCFunc({
			arg msg;
			~countTime2Snr = ~countTime2Snr + 1;
			~countTime2Snr.switch(
				1,{


					~apc40.noteOn(~apcMnCh, ~actButB2, 1);
					~tOSCAdrr.sendMsg('time2Snr', 1);
					~tOSCAdrr.sendMsg('tmSnrLabel', 2);
					~tmMulSnr.source = Pseq([2], inf);
					//~extraShufSnr.source = Pshuf([10,11,12,13,14], inf);
				},
				2,{

					~apc40.noteOn(~apcMnCh, ~actButB2, 0);
					~tOSCAdrr.sendMsg('time2Snr', 0);
					~tOSCAdrr.sendMsg('tmSnrLabel', 1);
					~tmMulSnr.source = Pseq([1], inf);
					//~extraShufSnr.source = Pshuf([0], inf);
					~countTime2Snr=0;
			});
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

