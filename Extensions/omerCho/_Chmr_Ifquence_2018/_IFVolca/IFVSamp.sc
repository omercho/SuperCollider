/*
IFVSamp(1);
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
		~chVSamp=10;
		~vSampLate=0.0;
		~timesVSamp=1;
		~rootVSamp=0;
		~susMul5VSamp=1;
		~trVSamp=0;
		~lfo5MulVSamp=0;
		~lfo6MulVSamp=0;
	}

	*proxy {

		~tmMul5VSamp = PatternProxy( Pseq([1], inf));
		~tmMul5VSampP= Pseq([~tmMul5VSamp], inf).asStream;

		~tm5VSamp = PatternProxy( Pseq([1], inf));
		~tm5VSampP= Pseq([~tm5VSamp], inf).asStream;

		~nt5VSamp = PatternProxy( Pseq([0], inf));
		~nt5VSampP = Pseq([~nt5VSamp], inf).asStream;
		~dur5VSamp = PatternProxy( Pseq([1], inf));
		~dur5VSampP = Pseq([~dur5VSamp], inf).asStream;
		~amp5VSamp = PatternProxy( Pseq([0.9], inf));
		~amp5VSampP = Pseq([~amp5VSamp], inf).asStream;
		~sus5VSamp = PatternProxy( Pseq([1], inf));
		~sus5VSampP = Pseq([~sus5VSamp], inf).asStream;
		~speed5VSamp = PatternProxy( Pseq([50,107,27], inf));
		~speed5VSampP = Pseq([~speed5VSamp], inf).asStream;


		~delta5VSamp = PatternProxy( Pseq([1/1], inf));
		~delta5VSampP = Pseq([~delta5VSamp], inf).asStream;
		~delta6VSamp = PatternProxy( Pseq([1/1], inf));
		~delta6VSampP = Pseq([~delta6VSamp], inf).asStream;

		~act5VSamp = PatternProxy( Pseq([1], inf));
		~act5VSampP= Pseq([~act5VSamp], inf).asStream;

	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				this.p1(val);
				((~dur5VSampP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~smp05,
			\type, \midi, \midiout,~vSamp,
			\dur, Pseq([~dur5VSampP.next],~act5VSampP),
			\amp, Pseq([~amp5VSampP.next], 1),
			\sustain, Pseq([~sus5VSampP.next],1)*~susMul5VSamp
		).play;


		Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~vSamp, \chan, ~smp05, \ctlNum, ~smpSpeed,
			\delta, Pseq([~delta5VSampP.next], 1),
			\control, Pseq([~speed5VSampP.next], 1),

		).play;


	}//p1


	*midiMix{

		~volVSamp5_MDMix.free;
		~volVSamp5_MDMix=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volVSamp5', vel/127);
			~vSamp.control(~smp05, ~smpLvl, vel);

		},srcID:~mdMixInID, chan:~mdMixLn5, ccNum:30);

		//Act ButA
		//VSamp Activate
		~cntMDMixact5ButA=0;
		~mdMDMixact4ButA.free;
		~mdMDMixact4ButA=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMDMixact5ButA = ~cntMDMixact5ButA + 1;
				~cntMDMixact5ButA.switch(
					0,{},
					1, {

						IFMIDIMix.act5ButA(1);
					},
					2,{
						IFMIDIMix.act5ButA(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~recBut5);

		//Act ButB
		//VSamp Time Div2
		~cntMDMixact5ButB=0;
		~mdMDMixact4ButB.free;
		~mdMDMixact4ButB=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMDMixact5ButB = ~cntMDMixact5ButB + 1;
				~cntMDMixact5ButB.switch(
					0,{},
					1, {

						IFMIDIMix.act5ButB(1);
					},
					2,{
						IFMIDIMix.act5ButB(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~mtBut5);

		//Act ButC
		//Static VSamp Activate
		/*~cntMDMixact5ButC=0;
		~mdMDMixact4ButC.free;
		~mdMDMixact4ButC=MIDIFunc.noteOn({
		arg vel;
		if ( vel==127, {
		~cntMDMixact5ButC = ~cntMDMixact5ButC + 1;
		~cntMDMixact5ButC.switch(
		0,{},
		1, {
		IFMDMix40.MDMixact4ButC(1);
		},
		2,{
		IFMDMix40.MDMixact4ButC(0);
		}
		)}
		);
		},srcID:~MDMix40InID, chan:~MDMixLn4, noteNum:~actButC);*/
	}//MDMix40


	*osc{


		~actVSampBut.free;
		~actVSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actVSamp.source=1;
				//~MDMix40.noteOn(3, 48, 127);
				//~behOut.control(5, 2, 127);
				},{
					~actVSamp.source=0;
					//~MDMix40.noteOff(3, 48, 127); //Trk4_But 1
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
					//~MDMix40.noteOn(3, 49, 127); //Trk4_But 2
					~tOSCAdrr.sendMsg('time2VSamp', 1);
					~tOSCAdrr.sendMsg('tmVSampLabel', 2);
					~tmMulVSamp.source = Pseq([2], inf);
				},
				2,{
					//~MDMix40.noteOff(3, 49, 127); //Trk4_But 2
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
			//~mdOut.control(5, 1, vel);
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