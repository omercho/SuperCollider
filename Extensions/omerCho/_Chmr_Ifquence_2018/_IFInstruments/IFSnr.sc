/*
IFSnr.times(4);


PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

IFSequence.step(~stepNumP.next);
IFSnr(~tmMulSnrP.next*~tmSnrP.next);

~vSamp.noteOn(~smp06, ~smpLvl, 120);


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
		this.mdMix;
	}
	*globals{

		~chSnr=1;
		~snrLate=0.00;
		~snrTimes=1;
		~rootSnr=0;
		~harmSnr=0;
		~susMulSnr=1;
		~trSnr=0;
		~octMulSnr=0;
		~snrVolC=1;

		~tuneSnr=26;

		~susMulSnr=1;
		~attSnr=0.001;
		~decSnr=0.08;
		~susLevSnr=0.0;
		~relSnr = 0.09;
		~wnoiseSnr=1.0;
		~tomMul=0;

		~freq2Snr=69;
		~freq3Snr=49;

		~lfoMulSnr=1;

		~quantSnr1=0.0;
		~quantSnr2=0.0;

		~p1Snr=~smp04;
		~p2Snr=~smp05;
	}

	*proxy {
		~actSnr = PatternProxy( Pseq([1], inf));
		~actSnrP= Pseq([~actSnr], inf).asStream;
		~nt1Snr = PatternProxy( Pseq([0], inf));
		~nt1SnrP = Pseq([~nt1Snr], inf).asStream;
		~amp1Snr = PatternProxy( Pseq([1], inf));
		~amp1SnrP = Pseq([~amp1Snr], inf).asStream;
		~dur1Snr = PatternProxy( Pseq([1], inf));
		~dur1SnrP = Pseq([~dur1Snr], inf).asStream;
		~sus1Snr = PatternProxy( Pseq([1], inf));
		~sus1SnrP = Pseq([~sus1Snr], inf).asStream;

		~act2Snr = PatternProxy( Pseq([1], inf));
		~act2SnrP= Pseq([~act2Snr], inf).asStream;
		~nt2Snr = PatternProxy( Pseq([0], inf));
		~nt2SnrP = Pseq([~nt2Snr], inf).asStream;
		~amp2Snr = PatternProxy( Pseq([1], inf));
		~amp2SnrP = Pseq([~amp2Snr], inf).asStream;
		~dur2Snr = PatternProxy( Pseq([1], inf));
		~dur2SnrP = Pseq([~dur2Snr], inf).asStream;
		~sus2Snr = PatternProxy( Pseq([1], inf));
		~sus2SnrP = Pseq([~sus2Snr], inf).asStream;
		~volSnr2 = PatternProxy( Pseq([0.9], inf));
		~volSnr2P = Pseq([~volSnr2], inf).asStream;
		~delta1Snr2 = PatternProxy( Pseq([1], inf));
		~delta1Snr2P = Pseq([~delta1Snr2], inf).asStream;

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

		~actSnrLfo1 = PatternProxy( Pseq([0], inf));
		~actSnrLfo1P= Pseq([~actSnrLfo1], inf).asStream;

		~volSnr = PatternProxy( Pseq([0.9], inf));
		~volSnrP = Pseq([~volSnr], inf).asStream;

		~delta1VSamp06 = PatternProxy( Pseq([1/1], inf));
		~delta1VSamp06P = Pseq([~delta1VSamp06], inf).asStream;

		~delta2VSamp06 = PatternProxy( Pseq([1/1], inf));
		~delta2VSamp06P = Pseq([~delta2VSamp06], inf).asStream;

		~lfoMulSnr=1;
		~lfo1Snr = PatternProxy( Pseq([1], inf));
		~lfo1SnrP = Pseq([~lfo1Snr], inf).asStream;
		~lfo2Snr = PatternProxy( Pseq([1], inf));
		~lfo2SnrP = Pseq([~lfo2Snr], inf).asStream;

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
				~snrLate.wait;
				//this.p1_SC(val);
				this.p1(val);
				((~dur1SnrP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}
	}
	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chSnr,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~dur1SnrP.next], ~actSnrP),
			\degree, Pseq([~nt1SnrP.next], inf),
			\amp, Pseq([~volSnrP.next*~amp1SnrP.next], inf),
			\sustain, Pseq([~sus1SnrP.next],inf)*~susMulSnr,
			\mtranspose, Pseq([~transSnrP.next
			], inf)+~trSnr+~transShufSnrP.next+~extraShufSnrP.next,
			\octave, Pseq([~octSnrP.next], inf)+~octMulSnr,
			\harmonic, Pseq([~hrmSnrP.next], inf)+~harmSnr
		).play(quant:~quantSnr1);
		//snr2
		Pbind(
			\chan, ~chSnr,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~dur2SnrP.next], ~act2SnrP),
			\degree, Pseq([~nt2SnrP.next], inf),
			\amp, Pseq([~volSnr2P.next*~amp2SnrP.next], inf),
			\sustain, Pseq([~sus2SnrP.next],inf)*~susMulSnr
		).play(quant:~quantSnr2);

		/*Pbind(//LFO Amp
		\type, \midi, \midicmd, \control,
		\midiout,~vSamp, \chan, ~p1Snr, \ctlNum, ~smpLvl,
		\delta, Pseq([~delta1VSamp06P.next], 1),
		\control, Pseq([~volSnrP.next*~amp1SnrP]*127, 1),
		).play(quant:0);
		Pbind(//LFO 1
		\type, \midi, \midicmd, \control,
		\midiout,~vSamp, \chan, ~p1Snr, \ctlNum, ~smpSpeed,
		\delta, Pseq([~delta2VSamp06P.next], ~actSnrLfo1P),
		\control, PdegreeToKey(
		Pseq([~tuneSnr+~nt1SnrP.next], 1),
		Pfunc({~scl2}),
		12),
		).play(quant:0);
		Pbind(
		\chan, ~p1Snr,
		\type, \midi, \midiout,~vSamp,
		\dur, Pseq([~dur1SnrP.next], ~actSnrP),
		\amp, Pseq([~amp1SnrP.next], inf),
		\sustain, Pseq([~sus1SnrP],inf)*~susMulSnr
		).play(quant:0);

		Pbind(//LFO Amp
		\type, \midi, \midicmd, \control,
		\midiout,~vSamp, \chan, ~p2Snr, \ctlNum, ~smpLvl,
		\delta, Pseq([~delta1Snr2P.next], 1),
		\control, Pseq([~volSnr2P.next*~amp2SnrP.next]*127, 1),
		).play(quant:0);
		Pbind(
		\chan, ~p2Snr,
		\type, \midi, \midiout,~vSamp,
		\dur, Pseq([~dur2SnrP.next], ~act2SnrP),
		\amp, Pseq([~amp2SnrP.next], inf),
		\sustain, Pseq([~sus2SnrP.next],inf)*~susMulSnr
		).play(quant:0);*/

	}

	*apc40{
		/*~volSnr_APC.free;
		~volSnr_APC=MIDIFunc.cc( {
		arg vel;
		~tOSCAdrr.sendMsg('volVSamp06', vel/127);
		~vSamp.control(~smp06, ~smpLvl, vel);
		~volSnr.source = vel/127;
		},srcID:~apcMnInID, chan:~apcMnCh, ccNum:~apcFd2);*/

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
					1,{IFAPCMn.actLine2ButA2(1);},
					2,{IFAPCMn.actLine2ButA2(0);}
			)});
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButA2);

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
					1,{IFAPCMn.actLine2ButB2(1);},
					2,{IFAPCMn.actLine2ButB2(0);}
			)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButB2);

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
					1,{IFAPCMn.actLine2ButC2(1);},
					2,{IFAPCMn.actLine2ButC2(0);}
			)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButC2);


	}//*apc40
	*mdMix{
		~volSnr2_mx.free;
		~volSnr2_mx=MIDIFunc.cc( {
			arg vel;

		},srcID:~mdMixInID, chan:~mdMixLn2, ccNum:30);
	}

	*osc{

		~actSnrBut.free;
		~actSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actSnr.source=1;
				~apcMn.noteOn(~apcMnCh, ~actButA2, 127); //Trk1_But 1

			},{
				~actSnr.source=0;
				~apcMn.noteOff(~apcMnCh, ~actButA2, 127); //Trk1_But 1

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


					//~apcMn.noteOn(~apcMnCh, ~actButB2, 1);
					//~tOSCAdrr.sendMsg('time2Snr', 1);
					//~tOSCAdrr.sendMsg('tmSnrLabel', 2);
					//~tmMulSnr.source = Pseq([2], inf);
					//~extraShufSnr.source = Pshuf([10,11,12,13,14], inf);
				},
				2,{

					//~apcMn.noteOn(~apcMnCh, ~actButB2, 0);
					//~tOSCAdrr.sendMsg('time2Snr', 0);
					//~tOSCAdrr.sendMsg('tmSnrLabel', 1);
					//~tmMulSnr.source = Pseq([1], inf);
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

		~xy1Snr.free;
		~xy1Snr= OSCFunc({
			arg msg,val1,val2,vel;
			val1=msg[1];
			val2=msg[2];
			vel=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~mdOut.control(3, 11, msg[2]*127); //Snr / Act Delay1
				~mdOut.control(3, 12, msg[1]*127); //Snr / Act Delay2
				~tOSCAdrr.sendMsg('xy1Snr', msg[1], msg[2]);
			},{
				~tOSCAdrr.sendMsg('xy1Snr', msg[1], msg[2]);
			});

		},
		'/xy1Snr'
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
	*p1_SC {|i=1|
		var val;
		val=i;
		Pbind(\instrument, \IFSnr_SC, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1SnrP.next/val],~actSnrP),
			\degree, Pseq([~nt1SnrP.next],inf),
			\amp, Pseq([~volSnrP.next*~amp1SnrP.next], inf),
			\sustain, Pseq([~sus1SnrP.next],1)*~susMulSnr,
			\mtranspose, Pseq([~transSnrP.next], 1)+~trSnr,
			\octave, Pseq([~octSnrP.next], 1)+~octMulSnr,
			\harmonic, Pseq([~hrmSnrP.next], 1)+~harmSnr,
			\pan, Pbrown(-0.5, 0.5, 0.125, inf),
			\att, ~attSnr,
			\dec, ~decSnr,
			\susLev, ~susLevSnr,
			\rel, ~relSnr,
			\wnoise,~wnoiseSnr,
			\freq2, ~freq2Snr,
			\freq3, ~freq3Snr,
			\lfo1Rate, ~lfo1SnrP*~lfoMulSnr,
			\lfo2Rate, ~lfo2SnrP*~lfoMulSnr,
			\group, ~piges,
			\out, Pseq([[~busSnr]], inf )
		).play(quant:0);
	}
	*synthDef{|index|
		index.switch(
			1,{
				SynthDef(\IFSnr_SC, {| att =0.01, sustain=0.1, dec=0.0, susLev=1.2, rel=0.09, mul = 0.9,
					gate=1, wnoise=2.8,
					lfo1Rate=1, lfo2Rate=1,
					amp=0.9,out=0, freq=110, freq2=69, freq3=49, pan = 0 |

					var env, env1, env1m, ses,lfo1, lfo2;
					lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
					lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 1.9);
					env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);
					env1 = EnvGen.ar(Env.new([freq, freq2, freq3], [0.005, sustain], [-4, -5]));
					env1m = env1.midicps;

					ses = SinOsc.ar(env1m*2,lfo2-0.9);
					ses = Mix.ar(ses*0.2,WhiteNoise.ar(wnoise));
					ses = HPF.ar(ses, env1m, env);
					ses = ses + SinOsc.ar(env1m, 0.5, env);
					ses = ses.clip2(0.2+wnoise);
					ses = ses * mul;
					Out.ar(out, Pan2.ar(ses, pan, amp*1.1)*env);
				}).add;

			},
			2,{

			},
			3,{

			},
			4,{},
			5,{}
		)
	}

}

