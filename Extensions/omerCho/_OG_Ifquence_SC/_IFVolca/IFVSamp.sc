/*
IFVSamp.(1);
IFVSamp.p1(1);
~octVSamp=4;
*/
IFVSamp {
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
		this.midiMix;
	}
	*globals{
		~chVSamp=3;
		~vSampLate=0.0;
		~timesVSamp=1;
		~rootVSamp=0;
		~susMulVSamp=1;
		~trVSamp=0;
		~lfo1MulVSamp=0;
		~lfo2MulVSamp=0;
	}

	*proxy {

		~tmMulVSamp = PatternProxy( Pseq([1], inf));
		~tmMulVSampP= Pseq([~tmMulVSamp], inf).asStream;

		~tmVSamp = PatternProxy( Pseq([1], inf));
		~tmVSampP= Pseq([~tmVSamp], inf).asStream;

		~nt1VSamp = PatternProxy( Pseq([0], inf));
		~nt1VSampP = Pseq([~nt1VSamp], inf).asStream;
		~dur1VSamp = PatternProxy( Pseq([1], inf));
		~dur1VSampP = Pseq([~dur1VSamp], inf).asStream;
		~amp1VSamp = PatternProxy( Pseq([0.9], inf));
		~amp1VSampP = Pseq([~amp1VSamp], inf).asStream;
		~sus1VSamp = PatternProxy( Pseq([1], inf));
		~sus1VSampP = Pseq([~sus1VSamp], inf).asStream;
		~speedVSamp = PatternProxy( Pseq([50,107,27], inf));
		~speedVSampP = Pseq([~speedVSamp], inf).asStream;


		~delta1VSamp = PatternProxy( Pseq([1/1], inf));
		~delta1VSampP = Pseq([~delta1VSamp], inf).asStream;
		~delta2VSamp = PatternProxy( Pseq([1/1], inf));
		~delta2VSampP = Pseq([~delta2VSamp], inf).asStream;

		~actVSamp = PatternProxy( Pseq([1], inf));
		~actVSampP= Pseq([~actVSamp], inf).asStream;

	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				this.p1(val);
				((~dur1VSampP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~smp01,
			\type, \midi, \midiout,~vSamp,
			\dur, Pseq([~dur1VSampP.next],~actVSampP),
			\amp, Pseq([~amp1VSampP.next], 1),
			\sustain, Pseq([~sus1VSampP.next],1)*~susMulVSamp
		).play;


		Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~vSamp, \chan, ~smp01, \ctlNum, ~smpSpeed,
			\delta, Pseq([~dur1VSampP.next], 1),
			\control, Pseq([~speedVSampP.next], 1),

		).play;


	}//p1


	*midiMix{

		~volVSamp_APC.free;
		~volVSamp_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volVSamp', vel/127);
			~vSamp.control(~smp01, ~smpLvl, vel);

		},srcID:~mdMixInID, chan:~mdMixLn5, ccNum:30);

		//Act ButA
		//VSamp Activate
		~cntMDMixActLine5ButA=0;
		~mdMDMixActLine4ButA.free;
		~mdMDMixActLine4ButA=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMDMixActLine5ButA = ~cntMDMixActLine5ButA + 1;
				~cntMDMixActLine5ButA.switch(
					0,{},
					1, {

						IFMIDIMix.actLine5ButA(1);
					},
					2,{
						IFMIDIMix.actLine5ButA(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:0, noteNum:~recBut5);

		//Act ButB
		//VSamp Time Div2
		~cntMDMixActLine5ButB=0;
		~mdMDMixActLine4ButB.free;
		~mdMDMixActLine4ButB=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMDMixActLine5ButB = ~cntMDMixActLine5ButB + 1;
				~cntMDMixActLine5ButB.switch(
					0,{},
					1, {
						"asfhn".postln;
						IFMIDIMix.actLine5ButB(1);
					},
					2,{
						IFMIDIMix.actLine5ButB(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:0, noteNum:~mtBut5);

		//Act ButC
		//Static VSamp Activate
		/*~cntMDMixActLine5ButC=0;
		~mdMDMixActLine4ButC.free;
		~mdMDMixActLine4ButC=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMDMixActLine5ButC = ~cntMDMixActLine5ButC + 1;
				~cntMDMixActLine5ButC.switch(
					0,{},
					1, {
						IFAPC40.MDMixActLine4ButC(1);
					},
					2,{
						IFAPC40.MDMixActLine4ButC(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn4, noteNum:~actButC);*/
	}//*apc40


	*osc{


		~actVSampBut.free;
		~actVSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actVSamp.source=1;
				~apc40.noteOn(3, 48, 127); //Trk4_But 1
				//~behOut.control(5, 2, 127);
				},{
					~actVSamp.source=0;
					~apc40.noteOff(3, 48, 127); //Trk4_But 1
					//~behOut.control(5, 2, 0);
			});
			},
			'/activVSamp'
		);

		~time2VSampBut.free;
		~countTime2VSamp=0;
		~time2VSampBut= OSCFunc({
			arg msg;

				~countTime2VSamp = ~countTime2VSamp + 1;
				~countTime2VSamp.switch(
					0,{},
					1, {
						~apc40.noteOn(3, 49, 127); //Trk4_But 2
						~tOSCAdrr.sendMsg('time2VSamp', 1);
						~tOSCAdrr.sendMsg('tmVSampLabel', 2);
						~tmMulVSamp.source = Pseq([2], inf);
					},
					2,{
						~apc40.noteOff(3, 49, 127); //Trk4_But 2
						~tOSCAdrr.sendMsg('time2VSamp', 0);
						~tOSCAdrr.sendMsg('tmVSampLabel', 1);
						~tmMulVSamp.source = Pseq([1], inf);
						~countTime2VSamp=0;
					}
				);
			},
			'/time2VSamp'
		);


		~volVSampFader.free;
		~volVSampFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volVSamp', msg[1]);
			~mdOut.control(5, 1, vel);
			},
			'/volVSamp'
		);

		~attVSampFader.free;
		~attVSampFader= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('attVSamp', msg[1]);
				~vVSamp.control(0, ~egAtt, val+0.01);
				~mdOut.control(5, 5, val);
				},{
					~tOSCAdrr.sendMsg('attVSamp', msg[1]);
					~mdOut.control(5, 5, val);
			});

			},
			'/attVSamp'
		);

		~susVSampFader.free;
		~susVSampFader= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('susVSamp', msg[1]);
				~vVSamp.control(0, ~slideTime, val);
				~mdOut.control(5, 6, val);
				},{
					~tOSCAdrr.sendMsg('susVSamp', msg[1]);
					~mdOut.control(5, 6, val);
			});
			},
			'/susVSamp'
		);

		~decVSampFader.free;
		~decVSampFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('decVSamp', val);
				~vVSamp.control(0, ~egDec, vel);
				~mdOut.control(5, 127, vel);
				~nobD5_m1Val= vel;
				},{
					~tOSCAdrr.sendMsg('decVSamp', val);
					~mdOut.control(5, 127, vel);
					~nobD5_m1Val= vel;
			});
			},
			'/decVSamp'
		);

		~xy1VSamp.free;
		~xy1VSamp= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~vVSamp.control(0, ~vcoPitch2, msg[2]*127);
				~vVSamp.control(0, ~vcoPitch3, msg[1]*127);
				~mdOut.control(5, 11, msg[2]*127);
				~mdOut.control(5, 12, msg[1]*127);
				~tOSCAdrr.sendMsg('xy1VSamp', msg[1], msg[2]);
				},{

					~mdOut.control(5, 11, msg[2]*127);
					~mdOut.control(5, 12, msg[1]*127);
					~tOSCAdrr.sendMsg('xy1VSamp', msg[1], msg[2]);
			});

			},
			'/xy1VSamp'
		);

		~xy1VSamp.free;
		~xy1VSamp= OSCFunc({
			arg msg;



			},
			'/xy1VSamp'
		);

		~chainVSampFader.free;
		~chainVSampFader= OSCFunc({
			arg msg, val;
			val=msg[1]*127;
			~tOSCAdrr.sendMsg('chainVSamp', msg[1]);
			~mdOut.control(5, 8, val);
			},
			'/chainVSamp'
		);

		~sendVSampFader.free;
		~sendVSampFader= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~mdOut.control(5, 4, vel1); // IFVSamp
			~mdOut.control(5, 3, vel2); // IFVSamp
			~tOSCAdrr.sendMsg('sendVSamp', msg[1], msg[2]);

			},
			'/sendVSamp'
		);


		~lfoMulVSampFad1.free;
		~lfoMulVSampFad1= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulVSamp1', msg[1]);
			~lfo1MulVSamp=msg[1]*1.1;
			},
			'/lfoMulVSamp1'
		);

		~lfoMulVSampFad2.free;
		~lfoMulVSampFad2= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulVSamp2', msg[1]);
			~lfo2MulVSamp=msg[1]*1.1;
			},
			'/lfoMulVSamp2'
		);

		//TIME

		~tmMulVSampBut1.free;
		~tmMulVSampBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulVSamp.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmVSampLabel', 1);

			});

			},
			'/tmMulVSamp1'
		);
		~tmMulVSampBut2.free;
		~tmMulVSampBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulVSamp.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmVSampLabel', 2);

			});

			},
			'/tmMulVSamp2'
		);
		~tmMulVSampBut3.free;
		~tmMulVSampBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulVSamp.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmVSampLabel', 3);

			});

			},
			'/tmMulVSamp3'
		);
		~tmVSampFader.free;
		~tmVSampFader= OSCFunc({
			arg msg;
			~tmVSamp.source = msg[1];

			},
			'/timesVSamp'
		);

		~padVSamp.free;
		~padVSamp = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFVSamp(~tmVSampP.next);

			});
			},
			'/padVSamp'
		);

	}




}