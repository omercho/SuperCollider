
/*
IFSamp.loadSC;
IFSamp.synthDef(1);
IFSamp.synthDef(2);
IFSamp.synthDef(3);
IFSamp.synthDef(4);
IFSamp.synthDef(5);


IFSamp.times(2);
IFSamp.pat_1;

~octSamp=4;
~octSamp.source = 5;

*/


IFSamp {
	var <>keyTime = 1;
	classvar <>counter3 = 0;



	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });*/
		}
	}
	*load{
		this.globals;
		this.proxy;
		this.loadSC;
		this.osc;
		this.apc40;
		//this.beh;
	}
	*globals{

		~chSamp=5;
		~sampLate=0.00;
		~timesSamp=1;
		~octMulSamp=2;
		~rootFreqSamp=~c5; // 261=C4|523=C5
		~harmSamp=0;
		~susMulSamp=1;
		~lfoMulSamp1=0;
		~lfoMulSamp2=0;
		~trSamp=0;



	}
	*octave{|val|
		~octSamp.source = Pseq([val], inf);
	}
	*octMul{|val|
		~octMulSamp = val;
		~tOSCAdrr.sendMsg('octSampLabel', val);
	}
	*loadSC{

		~attSamp=0.05;
		~decSamp=1.02;
		~susLevSamp=1.1;
		~relSamp = 0.5;
		~lfoMulSamp=0.8;
		~cutSamp=0.1;
		~legatoSamp=0.08;
		~sin1Samp=1.1;
		~sin2Samp=0.9;
		~rootFreqSamp=~c5; // 261=C4|523=C5
		IFSamp.synthDef(1);


		~n01.free;~n01 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/athm01.aif");
		~n02.free;~n02 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/athm01R.aif");
		~n03.free;~n03 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/athm02.aif");
		~n04.free;~n04 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/athm02R.aif");
		~p01.free;~p01 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/piano01.aif");
		~p02.free;~p02 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/sop01.aif");
		~p03.free;~p03 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/dop01.aif");
		~p04.free;~p04 = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/dop01r.aif");
		//~samplerEvent = Event.default.put(\freq, { ~midinote.midicps / ~sampleBaseFreq });

		~bufnumSamp = PatternProxy( Pseq([~p02], inf));
		~bufnumSampP = Pseq([~bufnumSamp], inf).asStream;


	}

	*proxy{

		//~samplerEvent = Event.default.put(\freq, { ~midinote.midicps / ~sampleBaseFreq });

		~nt1Samp = PatternProxy( Pseq([0], inf));
		~nt1SampP = Pseq([~nt1Samp], inf).asStream;
		~dur1Samp = PatternProxy( Pseq([1], inf));
		~dur1SampP = Pseq([~dur1Samp], inf).asStream;
		~amp1Samp = PatternProxy( Pseq([0.9], inf));
		~amp1SampP = Pseq([~amp1Samp], inf).asStream;
		~sus1Samp = PatternProxy( Pseq([1], inf));
		~sus1SampP = Pseq([~sus1Samp], inf).asStream;

		~tmMulSamp = PatternProxy( Pseq([1], inf));
		~tmMulSampP= Pseq([~tmMulSamp], inf).asStream;
		~tmSamp = PatternProxy( Pseq([1], inf));
		~tmSampP= Pseq([~tmSamp], inf).asStream;

		~transSamp = PatternProxy( Pseq([0], inf));
		~transSampP = Pseq([~transSamp], inf).asStream;

		~transShufSamp = PatternProxy( Pseq([0], inf));
		~transShufSampP = Pseq([~transShufSamp], inf).asStream;

		~octSamp = PatternProxy( Pseq([4], inf));
		~octSampP = Pseq([~octSamp], inf).asStream;

		~legSamp= PatternProxy( Pseq([0.0], inf));
		~legSampP = Pseq([~legSamp], inf).asStream;
		~hrmSamp = PatternProxy( Pseq([1.0], inf));
		~hrmSampP = Pseq([~hrmSamp], inf).asStream;

		~delta1Samp = PatternProxy( Pseq([1/4], inf));
		~delta1SampP = Pseq([~delta1Samp], inf).asStream;
		~delta2Samp = PatternProxy( Pseq([1/2], inf));
		~delta2SampP = Pseq([~delta2Samp], inf).asStream;

		~lfo1Samp = PatternProxy( Pseq([1], inf));
		~lfo1SampP = Pseq([~lfo1Samp], inf).asStream;
		~lfo2Samp = PatternProxy( Pseq([1], inf));
		~lfo2SampP = Pseq([~lfo2Samp], inf).asStream;

		~actSamp = PatternProxy( Pseq([1], inf));
		~actSampP= Pseq([~actSamp], inf).asStream;

		~volSamp = PatternProxy( Pseq([0.9], inf));
		~volSampP = Pseq([~volSamp], inf).asStream;

		/*//StaticSamp
		~actStSamp = PatternProxy( Pseq([0], inf));
		~actStSampP= Pseq([~actStSamp], inf).asStream;
		~durStSamp = PatternProxy( Pseq([1], inf));
		~durStSampP = Pseq([~durStSamp], inf).asStream;
		~ampStSamp = PatternProxy( Pseq([0,0,0,0,1], inf));
		~ampStSampP = Pseq([~ampStSamp], inf).asStream;
		~ntStSamp = PatternProxy( Pseq([67], inf));
		~ntStSampP = Pseq([~ntStSamp], inf).asStream;*/


	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				//~sampLate=~abLate;
				~sampLate.wait;

				this.p1(val);

				//~durMulP*((~dur1SampP.next)/val).wait;
				((~dur1SampP.next)*(~durMulP.next)/val).wait;

			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;

		/*Pbind(
		\chan, ~chSamp,
		\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
		\dur, Pseq([~dur1SampP.next],~actSampP),
		\degree, Pseq([~nt1SampP.next], 1),
		\amp, Pseq([~amp1SampP.next], 1),
		\sustain, Pseq([~sus1SampP.next],1)*~susMulSamp,
		\mtranspose, Pseq([~transSampP.next], 1)+~trSamp+~transShufSampP.next,
		\octave, Pseq([~octSampP.next], 1)+~octMulSamp,
		\harmonic, Pseq([~hrmSampP.next], 1)+~harmSamp


		).play;*/

		Pbind(
			\instrument, \IFSamp_SC, \scale, Pfunc({~scl2}, inf),
			\bufnum, Pseq([~bufnumSampP.next], inf),
			\dur, Pseq([~dur1SampP.next],~actSampP),
			\degree, Pseq([~nt1SampP.next], inf),
			\amp, Pseq([~volSampP.next*~amp1SampP.next], inf),
			\sustain, Pseq([~sus1SampP.next],inf)*~susMulSamp,
			\mtranspose, Pseq([~transSampP.next], inf)+~trSamp+~transShufSampP.next,
			\octave, Pseq([~octSampP.next], inf)+~octMulSamp,
			\harmonic, Pseq([~hrmSampP.next], inf)+~harmSamp,
			\legato, Pseq([~legSampP.next], inf),
			\pan, Pbrown(-0.9, 0.8, 0.125, inf),
			\rootFreq,  ~rootFreqSamp,

			\cut1, Pbrown(0.05, 1.0, 0.125, inf)*~cutSamp,
			\sin1, Pbrown(0.1, 1.0, 0.125, inf)*~sin1Samp,
			\sin2, Pbrown(0.2, 2.0, 0.125, inf)*~sin2Samp,
			\att, ~attSamp,
			\dec, ~decSamp,
			\susLev, ~susLevSamp,
			\rel, ~relSamp,
			\lfo1Rate, ~lfo1SampP*~lfoMulSamp,
			\lfo2Rate, ~lfo2SampP*~lfoMulSamp,
			\group, ~piges,
			\out, Pseq([~busSamp], inf )

		).play(quant:0);

		Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~mdOut, \chan, 7, \ctlNum, 40,
			\delta, Pseq([~delta1SampP.next], 1),
			\control, Pseq([~lfo1SampP.next], 1)*~lfoMulSamp1,

		).play(quant:0);

		Pbind(//LFO 2
			\type, \midi, \midicmd, \control,
			\midiout,~mdOut,\chan, 7,  \ctlNum, 41,
			\delta, Pseq([~delta2SampP.next], 1),
			\control, Pseq([~lfo2SampP.next], 1)*~lfoMulSamp2,

		).play(quant:0);

	}//p1

	*apc40{

		~volSamp_APC.free;
		~volSamp_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volSamp', vel/127);
			~volSamp.source = vel/127;

		},srcID:~apc40InID, chan:~apcMnCh, ccNum:~apcFd6);

		//Act ButA6
		//Samp Activate
		~cntActLine6ButA6=0;
		~mdActLine6ButA6.free;
		~mdActLine6ButA6=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine6ButA6 = ~cntActLine6ButA6 + 1;
				~cntActLine6ButA6.switch(
					0,{},
					1, {
						IFAPC40.actLine6ButA6(1);
					},
					2,{
						IFAPC40.actLine6ButA6(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButA6);

		//Act ButB6
		//Samp Time Div2
		~cntActLine6ButB6=0;
		~mdActLine6ButB6.free;
		~mdActLine6ButB6=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine6ButB6 = ~cntActLine6ButB6 + 1;
				~cntActLine6ButB6.switch(
					0,{},
					1, {
						IFAPC40.actLine6ButB6(1);
					},
					2,{
						IFAPC40.actLine6ButB6(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButB6);

		//Act ButC6
		//Static Samp Activate
		~cntActLine6ButC6=0;
		~mdActLine6ButC6.free;
		~mdActLine6ButC6=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine6ButC6 = ~cntActLine6ButC6 + 1;
				~cntActLine6ButC6.switch(
					0,{},
					1, {
						IFAPC40.actLine6ButC6(1);
					},
					2,{
						IFAPC40.actLine6ButC6(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButC6);

	}//*apc40


	*osc{

		~actSampBut.free;
		~actSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actSamp.source=1;
				~apc40.noteOn(~apcMnCh, ~actButA6, 127);
				//~behOut.control(7, 2, 127);
				},{
					~actSamp.source=0;
					~apc40.noteOff(~apcMnCh, ~actButA6, 127);
					//~behOut.control(7, 2, 0);
			});
			},
			'/activSamp'
		);

		~time2SampBut.free;
		~countTime2Samp=0;
		~time2SampBut= OSCFunc({
			arg msg;
			~countTime2Samp = ~countTime2Samp + 1;
			~countTime2Samp.switch(
				0,{},
				1, {
					~apc40.noteOn(~apcMnCh, ~actButB6, 1);
					~tOSCAdrr.sendMsg('time2Samp', 1);
					~tOSCAdrr.sendMsg('tmSampLabel', 2);
					~tmMulSamp.source = Pseq([2], inf);
				},
				2,{
					~apc40.noteOn(~apcMnCh, ~actButB6, 0);
					~tOSCAdrr.sendMsg('time2Samp', 0);
					~tOSCAdrr.sendMsg('tmSampLabel', 1);
					~tmMulSamp.source = Pseq([1], inf);
					~countTime2Samp=0;
				}
			);
			},
			'/time2Samp'
		);


		~volSampFader.free;
		~volSampFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volSamp', msg[1]);
			~mdOut.control(7, 1, vel);
			},
			'/volSamp'
		);

		/*~attSampFader.free;
		~attSampFader= OSCFunc({
		arg msg,vel;
		vel=msg[1]*127;
		~tOSCAdrr.sendMsg('attSamp', msg[1]);
		~mdOut.control(7, 5, vel);
		},
		'attSamp'
		);

		~susLevSampFader.free;
		~susLevSampFader= OSCFunc({
		arg msg;
		~tOSCAdrr.sendMsg('susSamp', msg[1]);
		~susLevSamp=msg[1];
		~mdOut.control(7, 6, msg[1]*127);

		},
		'/susSamp'
		);

		~decSampFader.free;
		~decSampFader= OSCFunc({
		arg msg,val,vel;
		val=msg[1];
		vel=msg[1]*127;
		~tOSCAdrr.sendMsg('decSamp', val);
		~decSamp=val;
		~mdOut.control(7, 127, vel);
		~nobD7_m1Val= vel;
		},
		'/decSamp'
		);

		~chainSampFader.free;
		~chainSampFader= OSCFunc({
		arg msg;
		~tOSCAdrr.sendMsg('chainSamp', msg[1]);
		~mdOut.control(7, 8, msg[1]*127);
		},
		'/chainSamp'
		);

		~sendSampXY.free;
		~sendSampXY= OSCFunc({
		arg msg,vel1,vel2;

		vel1=msg[1]*127;
		vel2=msg[2]*127;
		~mdOut.control(7, 4, vel1); // IFSamp
		~mdOut.control(7, 3, vel2); // IFSamp
		~mdOut.control(7, 10, vel2); // IFSamp
		~tOSCAdrr.sendMsg('sendSamp', msg[1], msg[2]);

		},
		'sendSamp'
		);*/
		~susLevSampFader.free;
		~susLevSampFader= OSCFunc({
			arg msg;
			~susLevSamp=msg[1];
			//msg[1].postln
			},
			'/susSamp'
		);

		~decSampFader.free;
		~decSampFader= OSCFunc({
			arg msg;
			~decSamp=msg[1];
			//msg[1].postln
			},
			'/decSamp'
		);

		~attSampFader.free;
		~attSampFader= OSCFunc({
			arg msg,val;
			val=msg[1]*2;
			~attSamp=val+0.01;
			},
			'/attSamp'
		);

		~xy1Samp.free;
		~xy1Samp= OSCFunc({
			arg msg;
			~sin1Samp=msg[1]+~sin2Samp;
			~sin2Samp=msg[2]+~sin1Samp;
			},
			'/xy1Samp'
		);
		/*~xy1Samp.free;
		~xy1Samp= OSCFunc({
		arg msg,vel1,vel2;

		vel1=msg[1]*127;
		vel2=msg[2]*127;
		~mdOut.control(7, 11, vel1); // IFSamp
		~mdOut.control(7, 12, vel2); // IFSamp
		~tOSCAdrr.sendMsg('xy1Samp', msg[1], msg[2]);

		},
		'xy1Samp'
		);*/

		~lfoMulSampFad1.free;
		~lfoMulSampFad1= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulSamp1', msg[1]);
			~lfoMulSamp1=msg[1];
			},
			'/lfoMulSamp1'
		);

		~lfoMulSampFad2.free;
		~lfoMulSampFad2= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulSamp2', msg[1]);
			~lfoMulSamp2=msg[1];
			},
			'/lfoMulSamp2'
		);
		//TIME

		~tmMulSampBut1.free;
		~tmMulSampBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSamp.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 1);

			});

			},
			'/tmMulSamp1'
		);
		~tmMulSampBut2.free;
		~tmMulSampBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSamp.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 2);

			});

			},
			'/tmMulSamp2'
		);
		~tmMulSampBut3.free;
		~tmMulSampBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSamp.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 3);

			});

			},
			'/tmMulSamp3'
		);
		~tmSampFader.free;
		~tmSampFader= OSCFunc({
			arg msg;
			~tmSamp.source = msg[1];

			},
			'/timesSamp'
		);



		~padSamp.free;
		~padSamp = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFSamp(~tmSampP.next);

			});
			},
			'/padSamp'
		);

		//----Samp-------
		~octSampMulBut.free;
		~octSampMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				//~octMulSamp = ~octMulSamp+1;
				//~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);
				IFSamp.octMul(~octMulSamp+1)

			});

			},
			'/octSampMul'
		);

		~octSampZeroBut.free;
		~octSampZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				IFSamp.octMul(0)

			});

			},
			'/octSampZero'
		);

		~octSampDivBut.free;
		~octSampDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSamp = ~octMulSamp-1;
				~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);

			});

			},
			'/octSampDiv'
		);

	}
	*synthDef{|index|
		index.switch(
			1,{
				SynthDef( \IFSamp_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
					sin1 = 0.2, sin2 = 0.4, brown = 0.1, saw = 4, pan=0, cut1=0.5, cut2=1, gate=1,
					lfo1Rate=0.1, lfo2Rate=0.22,
					att = 0.1, susLev = 0.1, dec=0.02, rel = 0.02,
					rate = 0.2, rate2 = 1.2, startPos = 0, loop = 1, stretch = 0.05|

					var osc, osc2, osc3, ses;
					var env, env1, env2, env3;
					var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
					var lfo1, lfo2, lfo3, decay,imp;

					var mix, chain, buf, filt, freqRate, freqBuf, freqOsc;
					startPos = startPos * BufFrames.kr(bufnum);
					freqBuf = freq;
					freqBuf = freqBuf.ratiomidi;
					freqBuf = freqBuf.midicps/rootFreq;
					freqOsc = freq;
					//freqRate = freqRate.keyToDegree();
					//freqRate = freqRate.midiratio;

					lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
					lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
					lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

					env =  EnvGen.ar(Env.adsr(att+0.01, dec+0.2, susLev*lfo2, rel*0.3), gate, -2, doneAction:2);
					env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
					env2 =  EnvGen.ar(Env.new([0,1,susLev,0.3,0],[0.1,0.3,0.8,0.1],[-6,-9,-5,-2]), gate);
					env3 =  EnvGen.ar(Env.new([0,susLev*0.6,0.2,0],[att*0.5,0.1*dec,rel+0.01],[-7,-4,-2]), gate);
					osc2 = Blip.ar(freq)*0.4;
					osc = Blip.ar(freq,osc2.tanh, env);

					buf = PlayBuf.ar(1, bufnum, rate:freqBuf, startPos: startPos, loop:0)*env;
					filt= MoogFF.ar(
						[osc],
						(lfo1*10000),
						1,
						mul:0.6
					);
					filt2= MoogFF.ar(
						[osc],
						2200*lfo1,
						0.5,
						mul:0.4
					);
					mix = Mix(filt2);
					Out.ar(out, Pan2.ar(mix*mul, pan, env)*amp);
				}).add;
			},
			2,{
SynthDef( \IFSamp_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
	sin1 = 0.2, sin2 = 0.4, brown = 0.1, saw = 4, pan=0, cut1=0.5, cut2=1, gate=1,
	lfo1Rate=0.1, lfo2Rate=0.22,
	att = 0.1, susLev = 0.1, dec=0.02, rel = 0.02,
	rate = 0.2, rate2 = 1.2, startPos = 0, loop = 1, stretch = 0.05|

	var osc1, osc2, osc3, ses;
	var env, env1, env2, env3;
	var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
	var lfo1, lfo2, lfo3, decay,imp;

	var mix, chain, buf, filt, freqRate, freqBuf, freqOsc;
	startPos = startPos * BufFrames.kr(bufnum);
	freq = freq/4;
	freqBuf = freq;
	freqBuf = freqBuf.ratiomidi;
	freqBuf = freqBuf.midicps/rootFreq;
	freqOsc = freq;
	//freqRate = freqRate.keyToDegree();
	//freqRate = freqRate.midiratio;

	lfo1 = SinOsc.kr(lfo1Rate).range(0.0, 1.0);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
	lfo3 = SinOsc.kr(lfo1Rate).range(0.5, 4.5);

	env =  EnvGen.ar(Env.adsr(att, dec+0.1, susLev, rel), gate, -2, doneAction:2);
	env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
	env2 =  EnvGen.ar(Env.new([0,1,susLev,0.3,0],[0.1,0.3,0.8,0.1],[-6,-9,-5,-2]), gate);
	env3 =  EnvGen.ar(Env.new([0,susLev*0.6,0.2,0],[att*0.5,0.1*dec,rel+0.01],[-7,-4,-2]), gate);

	osc1 = LFPulse.ar(LFSaw.kr(lfo1Rate*0.05, 0, freqOsc, freqOsc*2), 0)*0.4;
	osc2 = SinOscFB.ar(freq, lfo1, amp * env1) * cut1*1.2 ;
	osc3 = FSinOsc.ar(LFSaw.kr(lfo1Rate*0.08, 0, freqOsc, freqOsc*4), 0)*0.5;
	buf = PlayBuf.ar(1, bufnum, rate:freqBuf, startPos: startPos, loop:0)*1.9;
	filt= MoogFF.ar(
		(osc1),
		//12220,
		cut1*(~c5*lfo2),
		1
	);
	mix = XFade2.ar(filt*osc2*lfo2, filt*osc3*lfo3, lfo3, 1);
	Out.ar(out, Pan2.ar(mix*mul*1.0, pan, env)*amp);
}).add;
			},
			3,{
SynthDef( \IFSamp_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
	sin1 = 0.2, sin2 = 0.4, brown = 0.1, saw = 4, pan=0, cut1=0.5, cut2=1, gate=1,
	lfo1Rate=0.1, lfo2Rate=0.22,
	att = 0.1, susLev = 0.1, dec=0.02, rel = 0.02,
	rate = 0.2, rate2 = 1.2, startPos = 0, loop = 1, stretch = 0.05|

	var osc1, osc2, osc3, ses;
	var env, env1, env2, env3;
	var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
	var lfo1, lfo2, lfo3, decay,imp;

	var mix, chain, buf, filt, freqRate, freqBuf, freqOsc;
	startPos = startPos * BufFrames.kr(bufnum);
	freq = freq/4;
	freqBuf = freq;
	freqBuf = freqBuf.ratiomidi;
	freqBuf = freqBuf.midicps/rootFreq;
	freqOsc = freq;
	//freqRate = freqRate.keyToDegree();
	//freqRate = freqRate.midiratio;

	lfo1 = SinOsc.kr(lfo1Rate).range(0.0, 1.0);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
	lfo3 = SinOsc.kr(lfo1Rate).range(0.5, 4.5);

	env =  EnvGen.ar(Env.adsr(att, dec+0.1, susLev, rel), gate, -2, doneAction:2);
	env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
	env2 =  EnvGen.ar(Env.new([0,1,susLev,0.3,0],[0.1,0.3,0.8,0.1],[-6,-9,-5,-2]), gate);
	env3 =  EnvGen.ar(Env.new([0,susLev*0.6,0.2,0],[att*0.5,0.1*dec,rel+0.01],[-7,-4,-2]), gate);

	osc1 = LFPulse.ar(LFPulse.kr(lfo2Rate*0.0005, 1, freq*2, freq*0.0), 0)*0.4;
	osc2 = SinOscFB.ar(freq, lfo1, amp * env1) *1.0 ;
	osc3 = FSinOsc.ar(LFPulse.kr(lfo1Rate*0.0008, 0.5, freq, freq*1.0), 0)*0.6;
	buf = PlayBuf.ar(1, bufnum, rate:freqBuf, startPos: startPos, loop:0)*1.9;
	filt= MoogFF.ar(
		(osc1),
		6220*cut1*(lfo3),
		1
	);
	mix= Mix(filt,osc1);
	mix = XFade2.ar(mix*osc2, mix*osc3, 0, 1);
	Out.ar(out, Pan2.ar(mix*mul*1.0, pan, env)*amp);
}).add;
			},
			4,{
SynthDef( \IFSamp_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
	sin1 = 0.2, sin2 = 0.4, brown = 0.1, saw = 4, pan=0, cut1=0.5, cut2=1, gate=1,
	lfo1Rate=0.1, lfo2Rate=0.22,
	att = 0.1, susLev = 0.1, dec=0.02, rel = 0.02,
	rate = 0.2, rate2 = 1.2, startPos = 0, loop = 1, stretch = 0.05|

	var osc1, osc2, osc3, ses;
	var env, env1, env2, env3;
	var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
	var lfo1, lfo2, lfo3, decay,imp;

	var mix, chain, buf, filt, freqRate, freqBuf, freqOsc;
	startPos = startPos * BufFrames.kr(bufnum);
	freq = freq/2;
	freqBuf = freq;
	freqBuf = freqBuf.ratiomidi;
	freqBuf = freqBuf.midicps/rootFreq;
	freqOsc = freq;
	//freqRate = freqRate.keyToDegree();
	//freqRate = freqRate.midiratio;

	lfo1 = SinOsc.kr(lfo1Rate).range(0.0, 1.0);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
	lfo3 = SinOsc.kr(lfo1Rate).range(0.5, 4.5);

	env =  EnvGen.ar(Env.adsr(att, dec+0.1, susLev, rel), gate, -2, doneAction:2);
	env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
	env2 =  EnvGen.ar(Env.new([0,1,susLev,0.3,0],[0.1,0.3,0.8,0.1],[-6,-9,-5,-2]), gate);
	env3 =  EnvGen.ar(Env.new([0,susLev*0.6,0.2,0],[att*0.5,0.1*dec,rel+0.01],[-7,-4,-2]), gate);

	osc1 = Blip.ar(freq, 0,env1)*0.4;
	osc2 = SinOscFB.ar(freq, 1) *1.0 ;
	osc3 = FSinOsc.ar(freq, 0)*0.6;
	buf = PlayBuf.ar(1, bufnum, rate:freqBuf, startPos: startPos, loop:0)*1.9;
	filt= MoogFF.ar(
		(osc1),
		6220,
		1
	);
	mix= Mix(filt,osc2);
	mix = XFade2.ar(mix*osc2, mix*osc3, 0, 1);
	Out.ar(out, Pan2.ar(mix*mul*1.0, pan, env)*amp);
}).add;
			},
			5,{
SynthDef( \IFSamp_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
	sin1 = 0.2, sin2 = 0.4, brown = 0.1, saw = 4, pan=0, cut1=0.5, cut2=1, gate=1,
	lfo1Rate=0.1, lfo2Rate=0.22,
	att = 0.1, susLev = 0.1, dec=0.02, rel = 0.02,
	rate = 0.2, rate2 = 1.2, startPos = 0, loop = 1, stretch = 0.05|

	var osc1, osc2, osc3, ses;
	var env, env1, env2, env3;
	var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
	var lfo1, lfo2, lfo3, decay,imp;

	var mix, chain, buf, filt, freqRate, freqBuf, freqOsc;
	startPos = startPos * BufFrames.kr(bufnum);
	freq = freq/2;
	freqBuf = freq;
	freqBuf = freqBuf.ratiomidi;
	freqBuf = freqBuf.midicps/rootFreq;
	freqOsc = freq;
	//freqRate = freqRate.keyToDegree();
	//freqRate = freqRate.midiratio;

	lfo1 = SinOsc.kr(lfo1Rate).range(0.0, 1.0);
	lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
	lfo3 = SinOsc.kr(lfo1Rate).range(0.5, 4.5);

	env =  EnvGen.ar(Env.adsr(att, dec+0.1, susLev, rel), gate, -2, doneAction:2);
	env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
	env2 =  EnvGen.ar(Env.new([0,1,susLev,0.3,0],[0.1,0.3,0.8,0.1],[-6,-9,-5,-2]), gate);
	env3 =  EnvGen.ar(Env.new([0,susLev*0.6,0.2,0],[att*0.5,0.1*dec,rel+0.01],[-7,-4,-2]), gate);

	osc1 = Blip.ar(freq, 0,env1)*0.4;
	osc2 = SinOscFB.ar(freq, 1,env2) *0.3;
	osc3 = FSinOsc.ar(freq, 0,env3)*0.6;
	buf = PlayBuf.ar(1, bufnum, rate:freqBuf, startPos: startPos, loop:0)*1.9;
	filt= MoogFF.ar(
		(osc3),
		6220,
		1
	);
	mix= Mix(filt,osc2);
	mix = XFade2.ar(mix*osc1, filt*4, 0, 1);
	Out.ar(out, Pan2.ar(mix*mul*1.0, pan, env)*amp);
}).add;
			},
			6,{},
			7,{},
			8,{}
		)
	}


}