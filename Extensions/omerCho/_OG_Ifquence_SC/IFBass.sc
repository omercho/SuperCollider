/*
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
		~chBass=3;
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
		~strBass = PatternProxy( Pseq([1.0], inf));
		~strBassP = Pseq([~strBass], inf).asStream;

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

		//StaticBass
		~actStBass = PatternProxy( Pseq([0], inf));
		~actStBassP= Pseq([~actStBass], inf).asStream;
		~durStBass = PatternProxy( Pseq([1], inf));
		~durStBassP = Pseq([~durStBass], inf).asStream;
		~ampStBass = PatternProxy( Pseq([0,0,0,0,1], inf));
		~ampStBassP = Pseq([~ampStBass], inf).asStream;
		~ntStBass = PatternProxy( Pseq([67], inf));
		~ntStBassP = Pseq([~ntStBass], inf).asStream;

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
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1BassP.next],~actBassP),
			\degree, Pseq([~nt1BassP.next], 1),
			\amp, Pseq([~amp1BassP.next], 1),
			\sustain, Pseq([~sus1BassP.next],1)*~susMulBass,
			\mtranspose, Pseq([~transBassP.next], 1)+~trBass+~transShufBassP.next,
			\octave, Pseq([~octBassP.next], 1)+~octMulBass,
			\harmonic, Pseq([~strBassP.next], 1)+~harmBass
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
	*stat01 {|i=1|
		var val;
		val=i;
		~staticBassPat=Pbind(
			\chan, ~chBass,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~durStBassP.next],~actStBassP.next),
			\degree, Pseq([~ntStBassP.next], inf),
			\amp, Pseq([~ampStBassP.next], inf)
		).play;
	}//stat01

	*apc40{

		~volBass_APC.free;
		~volBass_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volBass', vel/127);
			~mdOut.control(5, 1, vel);

		},srcID:~apc40InID, chan:3, ccNum:7);

		//Act ButA
		//Bass Activate
		~cntActLine4ButA=0;
		~mdActLine4ButA.free;
		~mdActLine4ButA=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine4ButA = ~cntActLine4ButA + 1;
				~cntActLine4ButA.switch(
					0,{},
					1, {
						IFAPC40.actLine4ButA(1);
					},
					2,{
						IFAPC40.actLine4ButA(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLine4, noteNum:~actButA);

		//Act ButB
		//Bass Time Div2
		~cntActLine4ButB=0;
		~mdActLine4ButB.free;
		~mdActLine4ButB=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine4ButB = ~cntActLine4ButB + 1;
				~cntActLine4ButB.switch(
					0,{},
					1, {
						IFAPC40.actLine4ButB(1);
					},
					2,{
						IFAPC40.actLine4ButB(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLine4, noteNum:~actButB);

		//Act ButC
		//Static Bass Activate
		~cntActLine4ButC=0;
		~mdActLine4ButC.free;
		~mdActLine4ButC=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine4ButC = ~cntActLine4ButC + 1;
				~cntActLine4ButC.switch(
					0,{},
					1, {
						IFAPC40.actLine4ButC(1);
					},
					2,{
						IFAPC40.actLine4ButC(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLine4, noteNum:~actButC);
	}//*apc40

	*beh{
		~actBassMD.free;
		~actBassMD=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~actBass.source=1;
				~tOSCAdrr.sendMsg('activBass', 1);
				},{
					~actBass.source=0;
					~tOSCAdrr.sendMsg('activBass', 0);
			});
		}, chan:5, ccNum:2);
		~time2BassMD.free;
		~time2BassMD=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~countTime2Bass = ~countTime2Bass + 1;
				~tOSCAdrr.sendMsg('time2Bass', 1);
				~tOSCAdrr.sendMsg('tmBassLabel', 2);
				~tmMulBass.source = Pseq([2], inf);
				},{
					~tOSCAdrr.sendMsg('time2Bass', 0);
					~tOSCAdrr.sendMsg('tmBassLabel', 1);
					~tmMulBass.source = Pseq([1], inf);
					~countTime2Bass=0;
			});
		}, chan:5, ccNum:9);
	}
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
				~apc40.noteOn(3, 48, 127); //Trk4_But 1
				//~behOut.control(5, 2, 127);
				},{
					~actBass.source=0;
					~apc40.noteOff(3, 48, 127); //Trk4_But 1
					//~behOut.control(5, 2, 0);
			});
			},
			'/activBass'
		);

		~time2BassBut.free;
		~countTime2Bass=0;
		~time2BassBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {//"Transpose Shuffle".postln;
				~countTime2Bass = ~countTime2Bass + 1;
				~countTime2Bass.switch(
					0,{},
					1, {
						//~behOut.control(5, 9, 127);
						~apc40.noteOn(3, 49, 127); //Trk4_But 2
						~tOSCAdrr.sendMsg('time2Bass', 1);
						~tOSCAdrr.sendMsg('tmBassLabel', 2);
						~tmMulBass.source = Pseq([2], inf);
					},
					2,{
						//~behOut.control(5, 9, 0);
						~apc40.noteOff(3, 49, 127); //Trk4_But 2
						~tOSCAdrr.sendMsg('time2Bass', 0);
						~tOSCAdrr.sendMsg('tmBassLabel', 1);
						~tmMulBass.source = Pseq([1], inf);
						~countTime2Bass=0;
					}
				)}
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
			~tOSCAdrr.sendMsg('attBass', msg[1]);
			~vBass.control(0, ~egAtt, val+0.01);
			~mdOut.control(5, 5, val);

			},
			'/attBass'
		);

		~susBassFader.free;
		~susBassFader= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			~tOSCAdrr.sendMsg('susBass', msg[1]);
			~vBass.control(0, ~slideTime, val);
			~mdOut.control(5, 6, val);
			},
			'/susBass'
		);

		~decBassFader.free;
		~decBassFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('decBass', val);
			~vBass.control(0, ~egDec, val);
			~mdOut.control(5, 7, vel);
			~nobD5_m1Val= vel;
			},
			'/decBass'
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

		~xy1Bass.free;
		~xy1Bass= OSCFunc({
			arg msg;

			~vBass.control(0, ~vcoPitch2, msg[2]*127);
			~vBass.control(0, ~vcoPitch3, msg[1]*127);
			~tOSCAdrr.sendMsg('xy1Bass', msg[1], msg[2]);

			},
			'/xy1Bass'
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