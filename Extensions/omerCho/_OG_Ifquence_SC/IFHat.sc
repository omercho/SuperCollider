
/*

IFHat.p1(1);
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

		~hatCh=10;
		~hatLate=0.00;
		~hatTimes=1;
		~harmHat=0;
		~rootHat=0;
		~susMulHat=1;
		~trHat=0;
		~octMulHat=0;
		~hatVolC=1;

		~tuneHat=26;

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


		~hrmHat = PatternProxy( Pseq([1.0], inf));
		~hrmHatP = Pseq([~hrmHat], inf).asStream;

		~actHat = PatternProxy( Pseq([1], inf));
		~actHatP= Pseq([~actHat], inf).asStream;

		~actHatLfo1 = PatternProxy( Pseq([0], inf));
		~actHatLfo1P= Pseq([~actHatLfo1], inf).asStream;

		~volHat = PatternProxy( Pseq([0.0], inf));
		~volHatP = Pseq([~volHat], inf).asStream;
		~delta1VSamp07 = PatternProxy( Pseq([1/1], inf));
		~delta1VSamp07P = Pseq([~delta1VSamp07], inf).asStream;

		~delta2VSamp07 = PatternProxy( Pseq([1/1], inf));
		~delta2VSamp07P = Pseq([~delta2VSamp07], inf).asStream;

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
		Pbind(//LFO Amp
			\type, \midi, \midicmd, \control,
			\midiout,~vSamp, \chan, ~smp07, \ctlNum, ~smpLvl,
			\delta, Pseq([~delta1VSamp07P.next], 1),
			\control, Pseq([~volHatP.next*~amp1HatP], 1),
		).play(quant:0);
		Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~vSamp, \chan, ~smp07, \ctlNum, ~smpSpeed,
			\delta, Pseq([~delta2VSamp07P.next], ~actHatLfo1P),
			\control, PdegreeToKey(
				Pseq([~tuneHat+~nt1HatP.next], 1),
				Pfunc({~scl2}),
				12),
		).play(quant:0);


		Pbind(
			\chan, ~smp07,
			\type, \midi, \midiout,~vSamp,
			\dur, Pseq([~dur1HatP.next],~actHatP),
			\amp, Pseq([~amp1HatP.next], 1),
			\sustain, Pseq([~sus1HatP.next],1)*~susMulHat,
		).play(quant:0);

	}

	*apc40{
		~volHat_APC.free;
		~volHat_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volVSamp07', vel/127);
			//~vSamp.control(~smp07, ~smpLvl, vel);
			~volHat.source = vel;
		},srcID:~apc40InID, chan:~apcMnCh, ccNum:~apcFd3);

		//Act ButA3
		//Hat Activate
		~cntActLine3ButA3=0;
		~mdActLine3ButA3.free;
		~mdActLine3ButA3=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine3ButA3 = ~cntActLine3ButA3 + 1;
				~cntActLine3ButA3.switch(
					0,{},
					1, {
						IFAPC40.actLine3ButA3(1);
					},
					2,{
						IFAPC40.actLine3ButA3(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButA3);

		//Act ButB3
		//Hat Time Div2
		~cntActLine3ButB3=0;
		~mdActLine3ButB3.free;
		~mdActLine3ButB3=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine3ButB3 = ~cntActLine3ButB3 + 1;
				~cntActLine3ButB3.switch(
					0,{},
					1, {
						IFAPC40.actLine3ButB3(1);
					},
					2,{
						IFAPC40.actLine3ButB3(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButB3);

		//Act ButC3
		//Static Hat Activate
		~cntActLine3ButC3=0;
		~mdActLine3ButC3.free;
		~mdActLine3ButC3=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine3ButC3 = ~cntActLine3ButC3 + 1;
				~cntActLine3ButC3.switch(
					0,{},
					1, {
						IFAPC40.actLine3ButC3(1);
					},
					2,{
						IFAPC40.actLine3ButC3(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButC3);

	}//*apc40



	*osc {

		~actHatBut.free;
		~actHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actHat.source=1;
				~apc40.noteOn(~apcMnCh, ~actButA3, 127); //Trk1_But 1

				},{
					~actHat.source=0;
					~apc40.noteOff(~apcMnCh, ~actButA3, 127); //Trk1_But 1

			});
			},
			'/activHat'
		);

		~time2HatBut.free;
		~countTime2Hat=0;
		~time2HatBut= OSCFunc({
			arg msg;

			~countTime2Hat = ~countTime2Hat + 1;
			~countTime2Hat.switch(
				0,{},
				1, {

					~apc40.noteOn(~apcMnCh, ~actButB3, 1);
					~tOSCAdrr.sendMsg('time2Hat', 1);
					~tOSCAdrr.sendMsg('tmHatLabel', 2);
					~tmMulHat.source = Pseq([2], inf);
				},
				2,{

					~apc40.noteOn(~apcMnCh, ~actButB3, 0);
					~tOSCAdrr.sendMsg('time2Hat', 0);
					~tOSCAdrr.sendMsg('tmHatLabel', 1);
					~tmMulHat.source = Pseq([1], inf);
					~countTime2Hat=0;
			});
			},
			'/time2Hat'
		);



		~volHatFader.free;
		~volHatFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volHat', msg[1]);
			//~mdOut.control(4, 1, vel);
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

