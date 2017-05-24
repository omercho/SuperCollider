
/*

IFHat.times(4);
*/

IFHat {
	classvar <>counter3=0, timeCnt=0;
	var<>hTime=1;


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

		~hatCh=2;
		~hatLate=0.00;
		~hatTimes=1;
		~harmHat=0;
		~rootHat=0;
		~susMulHat=1;
		~trHat=0;
		~octMulHat=0;
		~hatVolC=1;
	}

	*proxy {

		~nt1Hat = PatternProxy( Pseq([0], inf));
		~nt1HatP = Pseq([~nt1Hat], inf).asStream;
		~dur1Hat = PatternProxy( Pseq([1], inf));
		~dur1HatP = Pseq([~dur1Hat], inf).asStream;
		~amp1Hat = PatternProxy( Pseq([1], inf));
		~amp1HatP = Pseq([~amp1Hat], inf).asStream;
		~sus1Hat = PatternProxy( Pseq([1], inf));
		~sus1HatP = Pseq([~sus1Hat], inf).asStream;

		~transHat = PatternProxy( Pseq([0], inf));
		~transHatP = Pseq([~transHat], inf).asStream;
		~transShufHat = PatternProxy( Pseq([0], inf));
		~transShufHatP = Pseq([~transShufHat], inf).asStream;

		~octHat = PatternProxy( Pseq([3], inf));
		~octHatP = Pseq([~octHat], inf).asStream;
		~legHat = PatternProxy( Pseq([0.0], inf));
		~legHatP = Pseq([~legHat], inf).asStream;

		~strHat = PatternProxy( Pseq([1.0], inf));
		~strHatP = Pseq([~strHat], inf).asStream;

		~actHat = PatternProxy( Pseq([1], inf));
		~actHatP= Pseq([~actHat], inf).asStream;

		//StaticHat
		~actStHat = PatternProxy( Pseq([0], inf));
		~actStHatP= Pseq([~actStHat], inf).asStream;
		~durStHat = PatternProxy( Pseq([1], inf));
		~durStHatP = Pseq([~durStHat], inf).asStream;
		~ampStHat = PatternProxy( Pseq([0,1], inf));
		~ampStHatP = Pseq([~ampStHat], inf).asStream;
		~ntStHat = PatternProxy( Pseq([67], inf));
		~ntStHatP = Pseq([~ntStHat], inf).asStream;

	}//proxy

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				//~hatLate=~abLate;
				~hatLate.wait;
				this.p1(val);
				//~durMulP*((~dur1HatP.next)/val).wait;
				((~dur1HatP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;

		Pbind(
			\chan, ~hatCh,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~dur1HatP.next],~actHatP),
			\degree, Pseq([~nt1HatP.next], 1),
			\amp, Pseq([~amp1HatP.next], 1),
			\sustain, Pseq([~sus1HatP.next],1)*~susMulHat,
			\mtranspose, Pseq([~transHatP.next], 1)+~trHat+~transShufHatP.next,
			\octave, Pseq([~octHatP.next], 1)+~octMulHat,
			\harmonic, Pseq([~strHatP.next], 1)+~harmHat
		).play;

		~staticHatPat=Pbind(
			\chan, ~hatCh,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~durStHatP.next],~actStHatP),
			\degree, Pseq([~ntStHatP.next], inf),
			\amp, Pseq([~ampStHatP.next], inf)
		).play(TempoClock.default, quant: 2);
	}
	*stat01 {|i=1|
		var val;
		val=i;
		~staticHatPat=Pbind(
			\chan, ~hatCh,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~durStHatP.next],~actStHatP),
			\degree, Pseq([~ntStHatP.next], inf),
			\amp, Pseq([~ampStHatP.next], inf)
		).play(TempoClock.default, quant: 2);
	}

	*apc40{
		~volHat_APC.free;
		~volHat_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volHat', vel/127);
			~mdOut.control(4, 1, vel);

		},srcID:~apc40InID, chan:2, ccNum:7);

		//Act ButA
		//Hat Activate
		~cntActLine3ButA=0;
		~mdActLine3ButA.free;
		~mdActLine3ButA=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine3ButA = ~cntActLine3ButA + 1;
				~cntActLine3ButA.switch(
					0,{},
					1, {
						IFAPC40.actLine3ButA(1);
					},
					2,{
						IFAPC40.actLine3ButA(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn3, noteNum:~actButA);

		//Act ButB
		//Hat Time Div2
		~cntActLine3ButB=0;
		~mdActLine3ButB.free;
		~mdActLine3ButB=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine3ButB = ~cntActLine3ButB + 1;
				~cntActLine3ButB.switch(
					0,{},
					1, {
						IFAPC40.actLine3ButB(1);
					},
					2,{
						IFAPC40.actLine3ButB(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn3, noteNum:~actButB);

		//Act ButC
		//Static Hat Activate
		~cntActLine3ButC=0;
		~mdActLine3ButC.free;
		~mdActLine3ButC=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine3ButC = ~cntActLine3ButC + 1;
				~cntActLine3ButC.switch(
					0,{},
					1, {
						IFAPC40.actLine3ButC(1);
					},
					2,{
						IFAPC40.actLine3ButC(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn3, noteNum:~actButC);

	}//*apc40

	*beh{
		~actHatMD.free;
		~actHatMD=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~actHat.source=1;
				~tOSCAdrr.sendMsg('activHat', 1);
				},{
					~actHat.source=0;
					~tOSCAdrr.sendMsg('activHat', 0);
			});
		}, chan:4, ccNum:2);

		~time2HatMD.free;
		~time2HatMD=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~countTime2Hat = ~countTime2Hat + 1;
				~tOSCAdrr.sendMsg('time2Hat', 1);
				~tOSCAdrr.sendMsg('tmHatLabel', 2);
				~tmMulHat.source = Pseq([2], inf);
				},{
					~tOSCAdrr.sendMsg('time2Hat', 0);
					~tOSCAdrr.sendMsg('tmHatLabel', 1);
					~tmMulHat.source = Pseq([1], inf);
					~countTime2Hat=0;
			});
		}, chan:4, ccNum:9);


		~actStHatActMD.free;
		~actStHatActMD=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~actStHat.source=1;
				~tOSCAdrr.sendMsg('activStHat', 1);
				},{
					~actStHat.source=0;
					~tOSCAdrr.sendMsg('activStHat', 0);
			});
		}, chan:8, ccNum:20);
		~stableHatMD.free;
		~stableHatMD=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~ntStHat.source = Pseq([67], inf);
				~durStHat.source  =  Pseq([1/2], inf);
				~ampStHat.source  =  Pseq([0,1], inf);


				},{
					~ntStHat.source = Pseq([67], inf);
					~durStHat.source  =  Pseq([1/2], inf);
					~ampStHat.source  =  Pseq([0,0,0,1], inf);

			});
		}, chan:8, ccNum:21);
	}//beh

	*osc {

		~actHatBut.free;
		~actHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actHat.source=1;
				~apc40.noteOn(2, 48, 127); //Trk1_But 1
				//~behOut.control(4, 2, 127);
				},{
					~actHat.source=0;
					~apc40.noteOff(2, 48, 127); //Trk1_But 1
					//~behOut.control(4, 2, 0);
			});
			},
			'/activHat'
		);

		~time2HatBut.free;
		~countTime2Hat=0;
		~time2HatBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {//"Transpose Shuffle".postln;
				~countTime2Hat = ~countTime2Hat + 1;
				~countTime2Hat.switch(
					0,{},
					1, {
						//~behOut.control(4, 9, 127);
						~apc40.noteOn(2, 49, 127);
						~tOSCAdrr.sendMsg('time2Hat', 1);
						~tOSCAdrr.sendMsg('tmHatLabel', 2);
						~tmMulHat.source = Pseq([2], inf);
					},
					2,{
						//~behOut.control(4, 9, 0);
						~apc40.noteOff(2, 49, 127);
						~tOSCAdrr.sendMsg('time2Hat', 0);
						~tOSCAdrr.sendMsg('tmHatLabel', 1);
						~tmMulHat.source = Pseq([1], inf);
						~countTime2Hat=0;
					}
				)}
			);
			},
			'/time2Hat'
		);



		~volHatFader.free;
		~volHatFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volHat', msg[1]);
			~mdOut.control(4, 1, vel);
			},
			'/volHat'
		);

		~attHatFader.free;
		~attHatFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('attHat', msg[1]);
			~mdOut.control(4, 5, vel);
			},
			'attHat'
		);

		~susLevHatFader.free;
		~susLevHatFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('susHat', msg[1]);
			~susLevHat=msg[1];
			~mdOut.control(4, 6, msg[1]*127);

			},
			'/susHat'
		);

		~decHatFader.free;
		~decHatFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('decHat', val);
			~decHat= val;
			~mdOut.control(4, 127, vel);
			//~nobD3_m1Val= vel;
			},
			'/decHat'
		);

		~chainHatFader.free;
		~chainHatFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('chainHat', msg[1]);
			~mdOut.control(4, 8, msg[1]*127);
			},
			'/chainHat'
		);

		~sendHatXY.free;
		~sendHatXY= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~mdOut.control(4, 4, vel1); // IFHat
			~mdOut.control(4, 3, vel2); // IFHat
			~tOSCAdrr.sendMsg('sendHat', msg[1], msg[2]);

			},
			'sendHat'
		);

		//TIME

		~tmMulHatBut1.free;
		~tmMulHatBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulHat.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmHatLabel', 1);

			});

			},
			'/tmMulHat1'
		);
		~tmMulHatBut2.free;
		~tmMulHatBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulHat.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmHatLabel', 2);

			});

			},
			'/tmMulHat2'
		);
		~tmMulHatBut3.free;
		~tmMulHatBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulHat.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmHatLabel', 3);

			});

			},
			'/tmMulHat3'
		);

		~octHatMulBut.free;
		~octHatMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulHat = ~octMulHat+1;
				~tOSCAdrr.sendMsg('octHatLabel', ~octMulHat);

			});

			},
			'/octHatMul'
		);

		~octHatZeroBut.free;
		~octHatZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulHat = 0;
				~tOSCAdrr.sendMsg('octHatLabel', ~octMulHat);

			});

			},
			'/octHatZero'
		);

		~octHatDivBut.free;
		~octHatDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulHat = ~octMulHat-1;
				~tOSCAdrr.sendMsg('octHatLabel', ~octMulHat);

			});

			},
			'/octHatDiv'
		);

	}


	//Hat Counter
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
				("        -----------HatTimesCnt"+timeCnt).postln;

				timeCnt=0;
			},

		);

	}

	*count3 {
		1.do{
			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            hatCnt"+counter3).postln;
					this.ctl_3;
					counter3 = 0;

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

