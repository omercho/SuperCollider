/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

IFBass.times(2);
IFBass.p1_SC(1);
~octBass=4;
*/
IFBass {
	var <>keyTime = 1;
	classvar <>counter3 = 0;


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
			this.load;
			});*/
		}
	}
	*load {
		this.globals;
		this.proxy;
		this.loadSC;
		this.osc;
		this.apc40;
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
		~lfoMulBass1=0.2;
		~lfoMulBass2=0.2;
	}
	*octave{|val|
		~octBass.source = Pseq([val], inf);
	}
	*octMul{|val|
		~octMulBass = val;
		~tOSCAdrr.sendMsg('octBassLabel', val);
	}
	*loadSC{

		~attBass=0.05;
		~decBass=1.02;
		~susLevBass=1.1;
		~relBass = 0.5;
		~lfoMulBass=0.8;
		~cutBass=0.1;
		~legatoBass=0.08;
		~sin1Bass=0.1;
		~sin2Bass=0.9;
		~rootFreqBass=~c5; // 261=C4|523=C5
		IFBass.synthDef(2);
		~defaultBufBass.free;~defaultBufBass = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/dop01.aif");
		~bufnumBass = PatternProxy( Pseq([~defaultBufBass], inf));
		~bufnumBassP = Pseq([~bufnumBass], inf).asStream;


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

		~volBass = PatternProxy( Pseq([0.9], inf));
		~volBassP = Pseq([~volBass], inf).asStream;

	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~bassLate.wait;
				//this.p1_SC(val);
				this.p1(val);
				//this.p1(val);
				((~dur1BassP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}

	}

	*p1_SC {|i=1|
		var val;
		val=i;

		Pbind(
			\instrument, \IFBass_SC, \scale, Pfunc({~scl2}, inf),
			\bufnum, Pseq([~bufnumBassP.next], inf),
			\dur, Pseq([~dur1BassP.next],~actBassP),
			\degree, Pseq([~nt1BassP.next], inf),
			\amp, Pseq([~volBassP.next*~amp1BassP.next], inf),
			\sustain, Pseq([~sus1BassP.next],inf)*~susMulBass,
			\mtranspose, Pseq([~transBassP.next], inf)+~trBass+~transShufBassP.next,
			\octave, Pseq([~octBassP.next], inf)+~octMulBass,
			\harmonic, Pseq([~hrmBassP.next], inf)+~harmBass,
			\legato, Pseq([~legBassP.next], inf),
			\pan, Pbrown(-0.9, 0.8, 0.125, inf),
			\rootFreq,  ~rootFreqBass,

			\cut1, Pbrown(0.05, 1.0, 0.125, inf)*~cutBass,
			\sin1, Pbrown(0.1, 1.0, 0.125, inf)*~sin1Bass,
			\sin2, Pbrown(0.2, 2.0, 0.125, inf)*~sin2Bass,
			\att, ~attBass,
			\dec, ~decBass,
			\susLev, ~susLevBass,
			\rel, ~relBass,
			\lfo1Rate, Pseq([~lfo1BassP.next],inf)*~lfoMulBass,
			\lfo2Rate, Pseq([~lfo2BassP.next],inf)*~lfoMulBass,
			\group, ~piges,
			\out, Pseq([~busBass], inf )
		).play(quant:0);

	}//p1_SC

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chBass,
			\type, \midi, \midiout,~vBass, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1BassP.next],~actBassP),
			\degree, Pseq([~nt1BassP.next], 1),
			\amp, Pseq([~volBassP.next*~amp1BassP.next], 1),
			\sustain, Pseq([~sus1BassP.next],1)*~susMulBass,
			\mtranspose, Pseq([~transBassP.next], 1)+~trBass+~transShufBassP.next,
			\octave, Pseq([~octBassP.next], 1)+~octMulBass,
			\harmonic, Pseq([~hrmBassP.next], 1)+~harmBass
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
	*apc40{

		~volBass_APC.free;
		~volBass_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volBass', vel/127);
			~volBass.source = vel/127;
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
					//~tOSCAdrr.sendMsg('time2Bass', 1);
					//~tOSCAdrr.sendMsg('tmBassLabel', 2);
					~tmMulBass.source = Pseq([2], inf);
				},
				2,{

					//~tOSCAdrr.sendMsg('time2Bass', 0);
					//~tOSCAdrr.sendMsg('tmBassLabel', 1);
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
			arg msg,vel,val;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volBass', msg[1]);
			//~vBass.control(5, 1, vel);
			~volBass.source = val;
		},
		'/volBass'
		);

		~attBassFader.free;
		~attBassFader= OSCFunc({
			arg msg,vel,val;
			vel=msg[1]*127;
			val=msg[1];
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('attBass', val);
				~vBass.control(0, ~egAtt, vel+0.01);
				~attBass=val+0.01;
			},{
				~tOSCAdrr.sendMsg('attBass', val);
				~attBass=val+0.01;
			});

		},
		'/attBass'
		);

		~susBassFader.free;
		~susBassFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('susBass', msg[1]);
				~vBass.control(0, ~slideTime, vel);
				~susLevBass=val;
			},{
				~tOSCAdrr.sendMsg('susBass', msg[1]);
				~susLevBass=val;
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
				~decBass=val;
				~relBass=val*0.7;
				~vBass.control(0, ~egDec, vel);
			},{
				~tOSCAdrr.sendMsg('decBass', val);
				~decBass=val;
				~relBass=val*0.7;
			});
		},
		'/decBass'
		);

		~xy1Bass.free;
		~xy1Bass= OSCFunc({
			arg msg,val1,val2,vel;
			val1=msg[1];
			val2=msg[2];
			vel=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~vBass.control(0, ~vcoPitch2, msg[2]*127);
				~vBass.control(0, ~vcoPitch3, msg[1]*127);
				~sin1Bass=val1;
				~sin1Bass=val2;
				~tOSCAdrr.sendMsg('xy1Bass', msg[1], msg[2]);
			},{
				~sin1Bass=val1;
				~sin2Bass=val2;
				~tOSCAdrr.sendMsg('xy1Bass', msg[1], msg[2]);
			});

		},
		'/xy1Bass'
		);
		~susMulBassFader.free;
		~susMulBassFader= OSCFunc({
			arg msg, val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('susMulBass', val);
			~susMulBass=val;
		},
		'/susMulBass'
		);

		~chainBassFader.free;
		~chainBassFader= OSCFunc({
			arg msg, val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('chainBass',val);

		},
		'/chainBass'
		);

		~sendBassFader.free;
		~sendBassFader= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
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
	*synthDef{|index|
		index.switch(
			1,{
				SynthDef( \IFBass_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
					sin1 = 0.2, sin2 = 0.4, brown = 0.1, saw = 4, pan=0, cut1=0.5, cut2=1, gate=1,
					lfo1Rate=0.1, lfo2Rate=0.22,
					att = 0.1, susLev = 0.1, dec=0.02, rel = 0.02,
					rate = 0.2, rate2 = 1.2, startPos = 0, loop = 1, stretch = 0.05,
					cutoff = 1000, gain = 2.0, lagamount = 0.01, chorus = 0.7|

					var osc1, osc2, osc3, ses;
					var env, env1, env2, env3;
					var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2;
					var lfo1, lfo2, lfo3, decay,imp;

					var mix, chain, buf, filt, freqRate, freqBuf, freqOsc;

					var osc, filter, filterenv, snd, chorusfx;

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
					osc1 = Blip.ar(freq,osc2.tanh, env);

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

					//moog
					osc = Mix(VarSaw.ar(
						freq: freq.lag(lagamount) * [1.0, 1.001, 2.0],
						iphase: Rand(0.0,1.0) ! 3,
						width: Rand(0.5,0.75) ! 3,
						mul: 0.5));
					filterenv = EnvGen.ar(
						envelope: Env.asr(0.2, 1, 0.2),
						gate: gate);
					filter =  MoogFF.ar(
						in: osc,
						freq: cutoff * (1.0 + (0.5 * filterenv)),
						gain: gain);
					snd = (0.7 * filter + (0.3 * filter.distort)) * env;

					mix = Mix(snd,filt2);
					Out.ar(out, Pan2.ar(mix*mul, pan)*amp);
				}).add;

			},
			2,{
				SynthDef( \IFBass_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
					sin1 = 0.2, sin2 = 0.4, brown = 0.1, saw = 4, pan=0, cut1=0.5, cut2=1, gate=1,
					lfo1Rate=0.1, lfo2Rate=0.22,
					att = 0.1, susLev = 0.1, dec=0.02, rel = 0.02,
					rate = 0.2, rate2 = 1.2, startPos = 0, loop = 1, stretch = 0.05,
					cutoff = 450, gain = 1.3, lagamount = 0.01, chorus = 0.7|

					var osc1, osc2, osc3, ses;
					var env, env1, env2, env3;
					var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2,cut;
					var lfo1, lfo2, lfo3, decay,imp;

					var mix, chain, buf, filt, freqRate, freqBuf, freqOsc;

					var osc, filter, filterenv, snd, chorusfx;

					startPos = startPos * BufFrames.kr(bufnum);
					freqBuf = freq;
					freqBuf = freqBuf.ratiomidi;
					freqBuf = freqBuf.midicps/rootFreq;
					freqOsc = freq;
					//freqRate = freqRate.keyToDegree();
					//freqRate = freqRate.midiratio;
					cut= cut1.range(50,2000);

					lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 1.2);
					lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 2.0);
					lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

					env =  EnvGen.ar(Env.adsr(att+0.01, dec+0.2, susLev*lfo2, rel*0.3), gate, -2, doneAction:2);
					env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
					env2 =  EnvGen.ar(Env.new([0.9,1,susLev,0.0,0],[0.01,0.03,0.1,0.1],[-6,-9,-5,-2]), gate);
					env3 =  EnvGen.ar(Env.new([0,0.9,susLev*0.2,0],[att*0.2,0.1+dec,rel+0.05],[-3,-4,-2]), gate);
					filterenv = EnvGen.ar(
						envelope: Env.asr(0.02, 1, 0.4),
						gate: gate);

					osc1 = Blip.ar(
						freq: freqOsc.lag(lagamount) * [0.3, 0.901, 1.0],
						numharm: Rand(15.5,190.75),
						mul: env1);
					osc2 = SyncSaw.ar(freqOsc,freq/2,0.3);
					osc3 = VarSaw.ar(
						freq: freqOsc.lag(lagamount) * [0.3, 0.901, 2.0],
						iphase: Rand(0.0,1.0) ! 3,
						width: Rand(0.5,0.75) ! 3,
						mul: 0.7);
					buf = PlayBuf.ar(1, bufnum, rate:freqBuf, startPos: startPos, loop:0)*env;

					//moog
					osc = Mix([osc1,osc2,osc3]);
					filter =  MoogFF.ar(
						in: osc,
						freq: cut * (3.0 + (0.6 * filterenv)),
						gain: gain);
					snd = (0.6 * filter + (0.3 * filter.distort(0.2)));

					mix = Mix(snd)*env;
					Out.ar(out, Pan2.ar(mix*mul, pan)*amp);
				}).add;
			},
			3,{
				SynthDef( \IFBass_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
					sin1 = 0.2, sin2 = 0.4, brown = 0.1, saw = 4, pan=0, cut1=0.5, cut2=1, gate=1,
					lfo1Rate=0.1, lfo2Rate=0.22,
					att = 0.1, susLev = 0.1, dec=0.02, rel = 0.02,
					rate = 0.2, rate2 = 1.2, startPos = 0, loop = 1, stretch = 0.05,
					cutoff = 450, gain = 1.3, lagamount = 0.01, chorus = 0.7|

					var osc1, osc2, osc3, ses;
					var env, env1, env2, env3;
					var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2,cut;
					var lfo1, lfo2, lfo3, decay,imp;

					var mix, chain, buf, filt, freqRate, freqBuf, freqOsc;

					var osc, filter, filterenv, snd, chorusfx;

					startPos = startPos * BufFrames.kr(bufnum);
					freqBuf = freq;
					freqBuf = freqBuf.ratiomidi;
					freqBuf = freqBuf.midicps/rootFreq;
					freqOsc = freq/2;
					//freqRate = freqRate.keyToDegree();
					//freqRate = freqRate.midiratio;
					cut= cut1.range(50,2000);

					lfo1 = Saw.kr(lfo1Rate).range(1.0, 1.2);
					lfo2 = Saw.kr(lfo2Rate).range(1.0, 2.0);
					lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

					env =  EnvGen.ar(Env.adsr(att+0.01, dec+0.2, susLev*lfo2, rel*0.3), gate, -2, doneAction:2);
					env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
					env2 =  EnvGen.ar(Env.new([0.9,1,susLev,0.0,0],[0.01,0.03,0.1,0.1],[-6,-9,-5,-2]), gate);
					env3 =  EnvGen.ar(Env.new([0,0.9,susLev*0.2,0],[att*0.2,0.1+dec,rel+0.05],[-3,-4,-2]), gate);
					filterenv = EnvGen.ar(
						envelope: Env.adsr(att+0.01, dec+0.2, susLev, rel*0.3),
						gate: gate);

					osc1 = Blip.ar(
						freq: freqOsc.lag(lagamount) * [0.3, 0.901, 1.0],
						numharm: Rand(15.5,190.75),
						mul: env1);
					osc2 = SyncSaw.ar(freq,freq/2,0.3);
					osc3 = VarSaw.ar(
						freq: freqOsc.lag(lagamount) * [0.3, 0.901, 2.0],
						iphase: Rand(0.0,1.0) ! 3,
						width: Rand(0.5,0.75) ! 3,
						mul: 0.7);
					buf = PlayBuf.ar(1, bufnum, rate:freqBuf, startPos: startPos, loop:0)*env;

					//moog
					osc = Mix([osc3,osc2]);
					filter =  MoogFF.ar(
						in: osc,
						freq: cut * (3.0 + (0.6 * filterenv)),
						gain: gain);
					snd = (0.6 * filter + (0.3 * filter.distort(1.2)));

					mix = Mix(snd)*env;
					Out.ar(out, Pan2.ar(mix*mul, pan)*amp);
				}).add;
			},
			4,{},
			5,{
				SynthDef( \IFBass_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
					sin1 = 0.2, sin2 = 0.4, brown = 0.1, saw = 4, pan=0, cut1=0.5, cut2=1, gate=1,
					lfo1Rate=0.1, lfo2Rate=0.22,
					att = 0.1, susLev = 0.1, dec=0.02, rel = 0.02,
					rate = 0.2, rate2 = 1.2, startPos = 0, loop = 1, stretch = 0.05,
					cutoff = 450, gain = 1.3, lagamount = 0.01, chorus = 0.7|

					var osc1, osc2, osc3, ses;
					var env, env1, env2, env3;
					var vco1,vco2,vco3, vco1F, vco2F, vco3F, mix1,mix2,mix3, filt1, filt2,cut;
					var lfo1, lfo2, lfo3, decay,imp;

					var mix, chain, buf, filt, freqRate, freqBuf, freqOsc;

					var osc, filter, filterenv, snd, chorusfx;

					startPos = startPos * BufFrames.kr(bufnum);
					freqBuf = freq;
					freqBuf = freqBuf.ratiomidi;
					freqBuf = freqBuf.midicps/rootFreq;
					freqOsc = freq/2;
					//freqRate = freqRate.keyToDegree();
					//freqRate = freqRate.midiratio;
					cut= cut1.range(50,2000);

					lfo1 = Saw.kr(lfo1Rate).range(1.0, 1.2);
					lfo2 = Saw.kr(lfo2Rate).range(1.0, 2.0);
					lfo3 = SinOsc.kr(lfo1Rate).range(0.8, 1.2);

					env =  EnvGen.ar(Env.adsr(att+0.01, dec+0.2, susLev*lfo2, rel*0.3), gate, -2, doneAction:2);
					env1 =  EnvGen.ar(Env.new([0,0.6,susLev*0.8,0],[att,dec*0.4,0.1],[-6,-2,-5]), gate);
					env2 =  EnvGen.ar(Env.new([0.9,1,susLev,0.0,0],[0.01,0.03,0.1,0.1],[-6,-9,-5,-2]), gate);
					env3 =  EnvGen.ar(Env.new([0,0.9,susLev*0.2,0],[att*0.2,0.1+dec,rel+0.05],[-3,-4,-2]), gate);
					filterenv = EnvGen.ar(
						envelope: Env.adsr(att+0.01, dec+0.2, susLev, rel*0.3),
						gate: gate);

					osc1 = Blip.ar(
						freq: freqOsc.lag(lagamount) * [0.3, 0.901, 1.0],
						numharm: Rand(15.5,190.75),
						mul: env1);
					osc2 = SyncSaw.ar(freq,freq/2,0.3);
					osc3 = VarSaw.ar(
						freq: freqOsc.lag(lagamount) * [0.3, 0.901, 2.0],
						iphase: Rand(0.0,1.0) ! 3,
						width: Rand(0.5,0.75) ! 3,
						mul: 0.7);
					buf = PlayBuf.ar(1, bufnum, rate:freqBuf, startPos: startPos, loop:0)*env;

					//moog
					osc = Mix([osc3,osc2]);
					filter =  MoogFF.ar(
						in: osc,
						freq: cut * (3.0 + (0.6 * filterenv)),
						gain: gain);
					snd = (0.6 * filter + (0.3 * filter.distort(1.2)));

					mix = Mix(snd)*env;
					Out.ar(out, Pan2.ar(mix*mul, pan)*amp);
				}).add;
			}
		)
	}


}