
/*

IFKick(4);

IFKick.synthDef(1);
~mdOut.noteOn(0, 0, 125);

*/

IFKick {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });*/
		}
	}
	*load {
		this.globals;
		this.proxy;
		//this.osc;
		this.synthDefOSC;
		this.apc40;

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
		~tuneKick=26;


		~attKick =0.001;
		~decKick =0.8;
		~relKick =0.3;
		~susLevKick = 0.01;


	}

	*proxy {
		IFKick.synthDef(1);

		~nt1Kick = PatternProxy( Pseq([~vKick], inf));
		~nt1KickP = Pseq([~nt1Kick], inf).asStream;
		~dur1Kick = PatternProxy( Pseq([1], inf));
		~dur1KickP = Pseq([~dur1Kick], inf).asStream;
		~amp1Kick = PatternProxy( Pseq([1], inf));
		~amp1KickP = Pseq([~amp1Kick], inf).asStream;
		~sus1Kick = PatternProxy( Pseq([0.05], inf));
		~sus1KickP = Pseq([~sus1Kick], inf).asStream;



		~transKick = PatternProxy( Pseq([0], inf));
		~transKickP = Pseq([~transKick], inf).asStream;
		~transShufKick = PatternProxy( Pseq([0], inf));
		~transShufKickP = Pseq([~transShufKick], inf).asStream;
		~extraShufKick = PatternProxy( Pshuf([0], inf));
		~extraShufKickP = Pseq([~extraShufKick], inf).asStream;

		~octKick = PatternProxy( Pseq([0], inf));
		~octKickP = Pseq([~octKick], inf).asStream;

		~hrmKick = PatternProxy( Pseq([1.0], inf));
		~hrmKickP = Pseq([~hrmKick], inf).asStream;

		~actKick = PatternProxy( Pseq([1], inf));
		~actKickP= Pseq([~actKick], inf).asStream;

		~actKickLfo1 = PatternProxy( Pseq([0], inf));
		~actKickLfo1P= Pseq([~actKickLfo1], inf).asStream;

		~volKick = PatternProxy( Pseq([1.0], inf));
		~volKickP = Pseq([~volKick], inf).asStream;

		~delta1VSamp05 = PatternProxy( Pseq([1/1], inf));
		~delta1VSamp05P = Pseq([~delta1VSamp05], inf).asStream;

		~delta2VSamp05 = PatternProxy( Pseq([1/1], inf));
		~delta2VSamp05P = Pseq([~delta2VSamp05], inf).asStream;


	}//*proxy

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				~kickLate.wait;

				this.p1(val);


				//~durMulP*((~dur1KickP.next)/val).wait;
				((~dur1KickP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}

	}
	*p1 {|i=1|
		var val;
		val=i;


		Pbind(
			\chan, ~kickCh,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~dur1KickP.next],~actKickP),
			\degree,  Pseq([~nt1KickP.next], inf),
			\amp, Pseq([~volKickP.next*~amp1KickP.next], inf),
			\sustain, Pseq([~sus1KickP.next],inf)*~susMulKick,
			\mtranspose, Pseq([~transKickP.next], inf)+~trKick+~transShufKickP.next,
			\octave, Pseq([~octKickP.next], inf)+~octMulKick,
			\harmonic, Pseq([~hrmKickP.next], inf)+~harmKick,
		).play(quant:0);

		//this.count2;
		//this.timesCount;
	}

	*p1_SC {|i=1|
		var val;
		val=i;
		Pbind(\instrument, \IFKick_SC,
			\octave, Pseq([~octKickP.next], inf)+~octMulKick,
			\dur, Pseq([~dur1KickP.next], ~actKickP),
			\degree,  Pseq([~nt1KickP.next], inf),
			\amp, Pseq([~volKickP.next*~amp1KickP.next], inf),
			\sustain, Pseq([~sus1KickP.next],inf)*~susMulKick,
			\mtranspose, Pseq([~transKickP.next], inf)+~trKick,
			\harmonic, Pseq([~hrmKickP.next], inf)+~harmKick,
			\pan, Pbrown(-0.4, 0.4, 0.125, inf),
			\att, ~attKick,
			\dec, ~decKick,
			\rel, ~relKick,
			\susLev, ~susLevKick,
			\wnoise,1.8,
			\group, ~piges,
			\out, Pseq([~busKick], inf )
		).play(quant:0);

		Pbind(//LFO Amp
			\type, \midi, \midicmd, \control,
			\midiout,~vSamp, \chan, ~smp05, \ctlNum, ~smpLvl,
			\delta, Pseq([~delta1VSamp05P.next], 1),
			\control, Pseq([~volKickP.next*~amp1KickP], 1),
		).play(quant:0);
		Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~vSamp, \chan, ~smp05, \ctlNum, ~smpSpeed,
			\delta, Pseq([~delta2VSamp2P.next], ~actKickLfo1P),
			\control, PdegreeToKey(
				Pseq([~tuneKick+~nt1KickP.next], 1),
				Pfunc({~scl2}),
				12),
		).play(quant:0);
		/*Pbind(
		\chan, ~smp05,
		\type, \midi, \midiout,~vSamp,
		\dur, Pseq([~dur1KickP.next], ~actKickP),
		\amp, Pseq([~amp1KickP.next], inf),
		\sustain, Pseq([~sus1KickP.next],inf)*~susMulKick
		).play(quant:0);*/




	}//*p1_SC





	*apc40{
		~volKick_APC.free;
		~volKick_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volKick', vel/127);
			"kickTestPost"+vel.postln;

			~volKick.source = vel/127;
		},srcID:~apc40InID, chan:~apcMnCh, ccNum:~apcFd1);

		//Act ButA1
		//Kick Activate
		~cntActLine1ButA1=0;
		~mdActLine1ButA1.free;
		~mdActLine1ButA1=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine1ButA1 = ~cntActLine1ButA1 + 1;
				~cntActLine1ButA1.switch(
					0,{},
					1, {
						IFAPC40.actLine1ButA1(1);
					},
					2,{
						IFAPC40.actLine1ButA1(0);
					}
			)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButA1);

		//Act ButB1
		//Kick Time Div2
		~cntActLine1ButB1=0;
		~mdActLine1ButB1.free;
		~mdActLine1ButB1=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine1ButB1 = ~cntActLine1ButB1 + 1;
				~cntActLine1ButB1.switch(
					0,{},
					1, {
						IFAPC40.actLine1ButB1(1);
					},
					2,{
						IFAPC40.actLine1ButB1(0);
					}
			)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButB1);

		//Act ButC1
		//Static Kick Activate
		~cntActLine1ButC1=0;
		~mdActLine1ButC1.free;
		~mdActLine1ButC1=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine1ButC1 = ~cntActLine1ButC1 + 1;
				~cntActLine1ButC1.switch(
					0,{},
					1, {
						IFAPC40.actLine1ButC1(1);
					},
					2,{
						IFAPC40.actLine1ButC1(0);
					}
			)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButC1);


	}//*apc40

	*osc{

		~actKickBut.free;
		~actKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actKick.source=1;
				~apc40.noteOn(~apcMnCh, ~actButA1, 127); //Trk1_But 1
			},{
				~actKick.source=0;
				~apc40.noteOff(~apcMnCh, ~actButA1, 127); //Trk1_But 1
			});
		},
		'/activKick'
		);
		~time2KickBut.free;
		~countTime2Kick=0;
		~time2KickBut= OSCFunc({
			arg msg;

			~countTime2Kick = ~countTime2Kick + 1;
			~countTime2Kick.switch(
				1,{
					~apc40.noteOn(0, ~actButB1, 1);
					//~tOSCAdrr.sendMsg('time2Kick', 1);
					//~tOSCAdrr.sendMsg('tmKickLabel', 2);
					~tmMulKick.source = Pseq([2], inf);
					//~extraShufKick.source = Pshuf([2,0,2,3,0], inf);
				},
				2,{
					~apc40.noteOn(0, ~actButB1, 0);
					//~tOSCAdrr.sendMsg('time2Kick', 0);
					//~tOSCAdrr.sendMsg('tmKickLabel', 1);
					~tmMulKick.source = Pseq([1], inf);
					//~extraShufKick.source = Pshuf([0], inf);
					~countTime2Kick=0;
			})

		},
		'/time2Kick'
		);

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
			//~nobD1_m2Val= msg[1]*127;
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
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('decKick', val);
			~decKick= val;
			~mdOut.control(2, 127, vel);
			//~nobD1_m1Val= vel;
		},
		'/decKick'
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

	*synthDefOSC{
		~actKickBut.free;
		~actKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actKick.source=1;
				~apc40.noteOn(~apcMnCh, ~actButA1, 127); //Trk1_But 1
				},{
					~actKick.source=0;
					~apc40.noteOff(~apcMnCh, ~actButA1, 127); //Trk1_But 1
			});
			},
			'/activKick'
		);
		~time2KickBut.free;
		~countTime2Kick=0;
		~time2KickBut= OSCFunc({
			arg msg;

			~countTime2Kick = ~countTime2Kick + 1;
			~countTime2Kick.switch(
				1,{
					~apc40.noteOn(0, ~actButB1, 1);
					~tOSCAdrr.sendMsg('time2Kick', 1);
					~tOSCAdrr.sendMsg('tmKickLabel', 2);
					~tmMulKick.source = Pseq([2], inf);
					//~extraShufKick.source = Pshuf([2,0,2,3,0], inf);
				},
				2,{
					~apc40.noteOn(0, ~actButB1, 0);
					~tOSCAdrr.sendMsg('time2Kick', 0);
					~tOSCAdrr.sendMsg('tmKickLabel', 1);
					~tmMulKick.source = Pseq([1], inf);
					//~extraShufKick.source = Pshuf([0], inf);
					~countTime2Kick=0;
			})

			},
			'/time2Kick'
		);

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
			arg msg,val;
			val=msg[1]*2;
			~attKick=val+0.01;
			},
			'/attKick'
		);

		~susLevKickFader.free;
		~susLevKickFader= OSCFunc({
			arg msg;
			~susLevKick=msg[1]*2;
			msg[1].postln
			},
			'/susKick'
		);

		~decSnrFader.free;
		~decSnrFader= OSCFunc({
			arg msg;
			~decKick=msg[1]*2;
			msg[1].postln
			},
			'/decKick'
		);

		~tmKickFader.free;
		~tmKickFader= OSCFunc({
			arg msg;
			~tmKick.source = msg[1];

			},
			'/timesKick'
		);
		~tmMulKickBut.free;
		~tmMulKickBut= OSCFunc({
			arg msg;
			~tmMulKick.source = msg[1];

			},
			'/tmMulKick'
		);
		//MUTES
		/*~vKickMtCln.free;
		~vKickMtCln= OSCFunc({
		arg msg;
		~vKickSynth.set(\mtCln, msg[1]);
		},
		'/mtClnKick'
		);

		~vKickMtDly.free;
		~vKickMtDly= OSCFunc({
		arg msg;
		~vKickSynth.set(\mtDly, msg[1]);
		},
		'/mtDlyKick'
		);
		~vKickMtRev.free;
		~vKickMtRev= OSCFunc({
		arg msg;

		~vKickSynth.set(\mtRev, msg[1]);

		},
		'/mtRevKick'
		);
		~vKickMtFlo.free;
		~vKickMtFlo= OSCFunc({
		arg msg;

		~vKickSynth.set(\mtFlo, msg[1]);

		},
		'/mtFloKick'
		);*/

		~padKick.free;
		~padKick = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFKick(~tmKickP.next);

			});
			},
			'/padKick'
		);

	}//SynthDefCntrl

	*synthDef{|index|
		index.switch(
			1,{
				SynthDef(\IFKick_SC, {| att =0.01, dec=0.0, susLev=1.2, rel=0.09, mul = 0.9,
					gate=1, wnoise=1.8,
					amp=0.5,out=0, freq=120, freq2=60, freq3=31, pan = 0 |

					var env, env1, env1m, ses;
					env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel-0.1), gate, doneAction:2);
					env1 = EnvGen.ar(Env.new([freq, freq2, freq3], [0.005, 0.2], [-5, -5]));
					env1m = env1.midicps;

					ses = LFPulse.ar(env1m, 0, 0.1, env, -0.5);
					ses = (ses + WhiteNoise.ar(wnoise))*env;
					ses = LPF.ar(ses, env1m, env)*0.8;
					ses = ses + SinOsc.ar(env1m, 0.5, env);
					ses = ses.clip2(12);
					ses = ses * mul;
					ses = Limiter.ar(ses,0.9);
					Out.ar(out, Pan2.ar(ses, pan, amp*1.0));
				}).add;
			},
			2,{
				SynthDef(\IFKick_SC, {| att =0.01, dec=0.1, susLev=1.0, rel=0.09, mul = 0.9,
					gate=1, wnoise=2.8,
					amp=0.5,out=0, freq=120, freq2=42, freq3=24, pan = 0 |

					var env, env1, env1m, ses;
					env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel, curve:[-2,-2,-8]), gate, doneAction:2);
					env1 = EnvGen.ar(Env.new([freq, freq2, freq3], [0.06, 0.05], [-4, -5]));
					env1m = env1.midicps;

					ses = LFPulse.ar(env1m, 0, 0.4, env, -0.5);
					ses = (ses + WhiteNoise.ar(wnoise))*env;
					ses = LPF.ar(ses, env1m, env)*0.8;
					ses = ses + SinOsc.ar(env1m, 0.5, env);
					ses = ses.clip2(11);
					ses = ses * mul;
					ses = Limiter.ar(ses,0.9);
					Out.ar(out, Pan2.ar(ses, pan, amp*1.0));
				}).add;
			},
			3,{
				SynthDef(\IFKick_SC, {| att =0.01, dec=0.0, susLev=1.2, rel=0.09, mul = 0.9,
					gate=1, wnoise=1.8,
					amp=0.5,out=0, freq=120, freq2=60, freq3=31, pan = 0 |

					var env, env1, env1m, ses;
					env =  EnvGen.ar(Env.adsr(att, dec, susLev, rel-0.1), gate, doneAction:2);
					env1 = EnvGen.ar(Env.new([freq, freq2, freq3], [0.005, 0.3], [-5, -5]));
					env1m = env1.midicps;

					ses = LFPulse.ar(env1m, 0, 0.1, env, -0.5);
					ses = (ses + WhiteNoise.ar(wnoise))*env;
					ses = LPF.ar(ses, env1m, env)*0.8;
					ses = ses + SinOsc.ar(env1m, 0.5, env);
					ses = ses.clip2(12);
					ses = ses * mul;
					ses = Limiter.ar(ses,0.9);
					Out.ar(out, Pan2.ar(ses, pan, amp*1.0));
				}).add;
			},
			4,{},
			5,{}
		)
	}
}

