/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

IFBass.times(2);
IFBass.pat_1;
~octBass=4;
*/
IFBass {
	var <>keyTime = 1;
	classvar <>counter3 = 0;


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
			this.globals; this.preSet; this.default; this.osc;
			});*/
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
		~chBass=0;
		~bassLate=0.0;
		~timesBass=1;
		~octMulBass=0;
		~harmBass=0;
		~rootBass=0;
		~susMulBass=1;
		~trBass=0;
		~lfoMulBass1=0;
		~lfoMulBass2=0;
	}

	*octave{|val|
		~octBass.source = Pseq([val], inf);
	}
	*octMul{|val|
		~octMulBass = val;
		~tOSCAdrr.sendMsg('octBassLabel', val);
	}
	*proxy {

		~nt1Bass = PatternProxy( Pseq([0], inf));
		~nt1BassP = Pseq([~nt1Bass], inf).asStream;
		~dur1Bass = PatternProxy( Pseq([1], inf));
		~dur1BassP = Pseq([~dur1Bass], inf).asStream;
		~amp1Bass = PatternProxy( Pseq([0.9], inf));
		~amp1BassP = Pseq([~amp1Bass], inf).asStream;
		~sus1Bass = PatternProxy( Pseq([1], inf));
		~sus1BassP = Pseq([~sus1Bass], inf).asStream;

		~transBass = PatternProxy( Pseq([0], inf));
		~transBassP = Pseq([~transBass], inf).asStream;
		~transShufBass = PatternProxy( Pseq([0], inf));
		~transShufBassP = Pseq([~transShufBass], inf).asStream;


		~octBass = PatternProxy( Pseq([4], inf));
		~octBassP = Pseq([~octBass], inf).asStream;
		~legBass = PatternProxy( Pseq([0.0], inf));
		~legBassP = Pseq([~legBass], inf).asStream;
		~hrmBass = PatternProxy( Pseq([1.0], inf));
		~hrmBassP = Pseq([~hrmBass], inf).asStream;

		~delta1Bass = PatternProxy( Pseq([1/1], inf));
		~delta1BassP = Pseq([~delta1Bass], inf).asStream;
		~delta2Bass = PatternProxy( Pseq([1/1], inf));
		~delta2BassP = Pseq([~delta2Bass], inf).asStream;

		~lfo1Bass = PatternProxy( Pseq([10], inf));
		~lfo1BassP = Pseq([~lfo1Bass], inf).asStream;
		~lfo2Bass = PatternProxy( Pseq([10], inf));
		~lfo2BassP = Pseq([~lfo2Bass], inf).asStream;

		~actBass = PatternProxy( Pseq([1], inf));
		~actBassP= Pseq([~actBass], inf).asStream;

		/*//StaticBass
		~actStBass = PatternProxy( Pseq([0], inf));
		~actStBassP= Pseq([~actStBass], inf).asStream;
		~durStBass = PatternProxy( Pseq([1], inf));
		~durStBassP = Pseq([~durStBass], inf).asStream;
		~ampStBass = PatternProxy( Pseq([0,0,0,0,1], inf));
		~ampStBassP = Pseq([~ampStBass], inf).asStream;
		~ntStBass = PatternProxy( Pseq([67], inf));
		~ntStBassP = Pseq([~ntStBass], inf).asStream;*/

	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				//~bassLate=~abLate;
				~bassLate.wait;

				this.p1(val);

				//~durMulP*((~dur1BassP.next)/val).wait;
				((~dur1BassP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chBass,
			\type, \midi, \midiout,~vBass, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1BassP.next],~actBassP),
			\degree, Pseq([~nt1BassP.next], 1),
			\amp, Pseq([~amp1BassP.next], 1),
			\sustain, Pseq([~sus1BassP.next],1)*~susMulBass,
			\mtranspose, Pseq([~transBassP.next], 1)+~trBass+~transShufBassP.next,
			\octave, Pseq([~octBassP.next], 1)+~octMulBass,
			\harmonic, Pseq([~hrmBassP.next], 1)+~harmBass
		).play;


		Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~mdOut, \chan, 5, \ctlNum, 40,
			\delta, Pseq([~delta1BassP.next], 1),
			\control, Pseq([~lfo1BassP.next], 1)*~lfoMulBass1,

		).play;
		Pbind(//LFO 2
			\type, \midi, \midicmd, \control,
			\midiout,~mdOut,\chan, 5,  \ctlNum, 41,
			\delta, Pseq([~delta2BassP.next], 1),
			\control, Pseq([~lfo2BassP.next], 1)*~lfoMulBass2,

		).play;


		//VBass
		Pbind(//LFO CUT BASS INT
			\midicmd, \control, \type, \midi,
			\midiout,~vBass, \chan, 0, \ctlNum, ~lfoInt,
			\delta, Pseq([~delta1BassP.next], 1),
			\control, Pseq([~lfo1BassP.value], 1)*~lfoMulBass1,
		).play;
		Pbind(//LFO CUT BASS RATE
			\midicmd, \control, \type, \midi,
			\midiout,~vBass, \chan, 0, \ctlNum, ~lfoRate,
			\delta, Pseq([~delta2BassP.next], 1),
			\control, Pseq([~lfo2BassP.value], 1)*~lfoMulBass2,
		).play;

	}//p1
	/**stat01 {|i=1|
	var val;
	val=i;
	~staticBassPat=Pbind(
	\chan, ~chBass,
	\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
	\dur, Pseq([~durStBassP.next],~actStBassP.next),
	\degree, Pseq([~ntStBassP.next], inf),
	\amp, Pseq([~ampStBassP.next], inf)
	).play;
	}//stat01*/

	*apc40{

		~volBass_APC.free;
		~volBass_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volBass', vel/127);
			~mdOut.control(5, 1, vel);

		},srcID:~apc40InID, chan:~apcMnCh, ccNum:~apcFd4);

		//Act ButA4
		//Bass Activate
		~cntActLine4ButA4=0;
		~mdActLine4ButA4.free;
		~mdActLine4ButA4=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine4ButA4 = ~cntActLine4ButA4 + 1;
				~cntActLine4ButA4.switch(
					0,{},
					1, {
						IFAPC40.actLine4ButA4(1);
					},
					2,{
						IFAPC40.actLine4ButA4(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButA4);

		//Act ButB4
		//Bass Time Div2
		~cntActLine4ButB4=0;
		~mdActLine4ButB4.free;
		~mdActLine4ButB4=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine4ButB4 = ~cntActLine4ButB4 + 1;
				~cntActLine4ButB4.switch(
					0,{},
					1, {
						IFAPC40.actLine4ButB4(1);
					},
					2,{
						IFAPC40.actLine4ButB4(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButB4);

		//Act ButC
		//Static Bass Activate
		~cntActLine4ButC4=0;
		~mdActLine4ButC4.free;
		~mdActLine4ButC4=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine4ButC4 = ~cntActLine4ButC4 + 1;
				~cntActLine4ButC4.switch(
					0,{},
					1, {
						IFAPC40.actLine4ButC4(1);
					},
					2,{
						IFAPC40.actLine4ButC4(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButC4);
	}//*apc40


	*osc{

		~phrase01Bass.free;
		~phrase01Bass= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			if ( msg[1]==1, {

				//~nt1Bass.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 4,1,0);
				~amp1Bass.source  =  Pslide([0.9, 0.9, 0.8, 0.7, 0.9, 0.5],         inf, 4,1,0);
				~sus1Bass.source  =  Pslide([0.8, 0.3, 0.8, 0.7, 0.8, 0.1 ]*1.9,    inf, 4,1,0);
				~tmBass.source    =  Pseq([2,1,1,1], inf);
				~dur1Bass.source  =  Pseq([1/2,1], inf);
				~lfo1Bass.source  =  Pseq([120,20,70,98, 0,110,60,20], inf);
				~lfo2Bass.source  =  Pseq([110,30,110,50], inf);

			});
			},
			'/phrase01Bass'
		);

		~actBassBut.free;
		~actBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actBass.source=1;
				~apc40.noteOn(~apcMnCh, ~actButA4, 127); //Trk4_But 1
				},{
					~actBass.source=0;
					~apc40.noteOff(~apcMnCh, ~actButA4, 127); //Trk4_But 1
			});
			},
			'/activBass'
		);

		~time2BassBut.free;
		~countTime2Bass=0;
		~time2BassBut= OSCFunc({
			arg msg;

			~countTime2Bass = ~countTime2Bass + 1;
			~countTime2Bass.switch(
				0,{},
				1, {
					~apc40.noteOn(~apcMnCh, ~actButB4, 1); //Trk4_But 2
					~tOSCAdrr.sendMsg('time2Bass', 1);
					~tOSCAdrr.sendMsg('tmBassLabel', 2);
					~tmMulBass.source = Pseq([2], inf);
				},
				2,{

					~tOSCAdrr.sendMsg('time2Bass', 0);
					~tOSCAdrr.sendMsg('tmBassLabel', 1);
					~tmMulBass.source = Pseq([1], inf);
					~apc40.noteOn(~apcMnCh, ~actButB4, 0); //Trk4_But 2
					~countTime2Bass=0;
				}
			);
			},
			'/time2Bass'
		);


		~volBassFader.free;
		~volBassFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volBass', msg[1]);
			~mdOut.control(5, 1, vel);
			},
			'/volBass'
		);

		~attBassFader.free;
		~attBassFader= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('attBass', msg[1]);
				~vBass.control(0, ~egAtt, val+0.01);
				~mdOut.control(5, 5, val);
				},{
					~tOSCAdrr.sendMsg('attBass', msg[1]);
					~mdOut.control(5, 5, val);
			});

			},
			'/attBass'
		);

		~susBassFader.free;
		~susBassFader= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('susBass', msg[1]);
				~vBass.control(0, ~slideTime, val);
				~mdOut.control(5, 6, val);
				},{
					~tOSCAdrr.sendMsg('susBass', msg[1]);
					~mdOut.control(5, 6, val);
			});
			},
			'/susBass'
		);

		~decBassFader.free;
		~decBassFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('decBass', val);
				~vBass.control(0, ~egDec, vel);
				~mdOut.control(5, 127, vel);
				~nobD5_m1Val= vel;
				},{
					~tOSCAdrr.sendMsg('decBass', val);
					~mdOut.control(5, 127, vel);
					~nobD5_m1Val= vel;
			});
			},
			'/decBass'
		);

		~xy1Bass.free;
		~xy1Bass= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~vBass.control(0, ~vcoPitch2, msg[2]*127);
				~vBass.control(0, ~vcoPitch3, msg[1]*127);
				~mdOut.control(5, 11, msg[2]*127);
				~mdOut.control(5, 12, msg[1]*127);
				~tOSCAdrr.sendMsg('xy1Bass', msg[1], msg[2]);
				},{

					~mdOut.control(5, 11, msg[2]*127);
					~mdOut.control(5, 12, msg[1]*127);
					~tOSCAdrr.sendMsg('xy1Bass', msg[1], msg[2]);
			});

			},
			'/xy1Bass'
		);

		~xy1Bass.free;
		~xy1Bass= OSCFunc({
			arg msg;



			},
			'/xy1Bass'
		);

		~chainBassFader.free;
		~chainBassFader= OSCFunc({
			arg msg, val;
			val=msg[1]*127;
			~tOSCAdrr.sendMsg('chainBass', msg[1]);
			~mdOut.control(5, 8, val);
			},
			'/chainBass'
		);

		~sendBassFader.free;
		~sendBassFader= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~mdOut.control(5, 4, vel1); // IFBass
			~mdOut.control(5, 3, vel2); // IFBass
			~tOSCAdrr.sendMsg('sendBass', msg[1], msg[2]);

			},
			'/sendBass'
		);


		~lfoMulBassFad1.free;
		~lfoMulBassFad1= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulBass1', msg[1]);
			~lfoMulBass1=msg[1]*1.1;
			},
			'/lfoMulBass1'
		);

		~lfoMulBassFad2.free;
		~lfoMulBassFad2= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulBass2', msg[1]);
			~lfoMulBass2=msg[1]*1.1;
			},
			'/lfoMulBass2'
		);

		//TIME

		~tmMulBassBut1.free;
		~tmMulBassBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulBass.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', 1);

			});

			},
			'/tmMulBass1'
		);
		~tmMulBassBut2.free;
		~tmMulBassBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulBass.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', 2);

			});

			},
			'/tmMulBass2'
		);
		~tmMulBassBut3.free;
		~tmMulBassBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulBass.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', 3);

			});

			},
			'/tmMulBass3'
		);
		~tmBassFader.free;
		~tmBassFader= OSCFunc({
			arg msg;
			~tmBass.source = msg[1];

			},
			'/timesBass'
		);

		~padBass.free;
		~padBass = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFBass(~tmBassP.next);

			});
			},
			'/padBass'
		);

		//----Bass-------
		~octBassMulBut.free;
		~octBassMulBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~octMulBass = ~octMulBass+1;
				~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);
			});
			},
			'/octBassMul'
		);

		~octBassZeroBut.free;
		~octBassZeroBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~octMulBass = 0;
				~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);
			});
			},
			'/octBassZero'
		);

		~octBassDivBut.free;
		~octBassDivBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulBass = ~octMulBass-1;
				~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);
			});
			},
			'/octBassDiv'
		);
	}




	//Bass Beat Counter
	*count3 {
		1.do{
			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            BassCnt"+counter3).postln;
					this.ctl_2;
					counter3 = 0;

				}

			)
		}

	}


	*ctl_1 {


	}

	*ctl_2 {
		("Bass CTL 2").postln;

	}


}