
/*

PostAllMIDI.on;
PostAllMIDI.off;

IFKeys.times(2);
IFKeys(3);

*/


IFKeys {
	var <>keyTime = 1;
	classvar <>counter3 = 0;


	*initClass{
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default;this.osc; });*/
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

		~chKeys=0;
		~keysLate= 0.0;
		~timesKeys=1;
		~octMulKeys=0;
		~rootKeys=0;
		~harmKeys=0;
		~susMulKeys=1;
		~lfoMulKeys1=0;
		~lfoMulKeys2=0;
		~trKeys=0;
		~lfoMulKeys1=0.2;
		~lfoMulKeys2=0.2;

	}
	*octave{|val|
		~octKeys.source = Pseq([val], inf);
	}
	*octMul{|val|
		~octMulKeys = val;
		~tOSCAdrr.sendMsg('octKeysLabel', val);
	}
	*loadSC{

		~attKeys=0.05;
		~decKeys=1.02;
		~susLevKeys=1.1;
		~relKeys = 0.5;
		~lfoMulKeys=0.8;
		~cutKeys=0.1;
		~legatoKeys=0.08;
		~sin1Keys=1.1;
		~sin2Keys=0.9;
		~rootFreqKeys=~c5; // 261=C4|523=C5
		IFKeys.synthDef(1);
		~defaultBufKeys.free;~defaultBufKeys = Buffer.read(Server.default, "/Applications/SuperCollider/sounds/_IFSC_Sounds/dop01.aif");
		~bufnumKeys = PatternProxy( Pseq([~defaultBufKeys], inf));
		~bufnumKeysP = Pseq([~bufnumKeys], inf).asStream;


	}
	*proxy{
		~nt1Keys = PatternProxy( Pseq([0], inf));
		~nt1KeysP = Pseq([~nt1Keys], inf).asStream;
		~dur1Keys = PatternProxy( Pseq([1], inf));
		~dur1KeysP = Pseq([~dur1Keys], inf).asStream;
		~amp1Keys = PatternProxy( Pseq([0.9], inf));
		~amp1KeysP = Pseq([~amp1Keys], inf).asStream;
		~sus1Keys = PatternProxy( Pseq([0.2], inf));
		~sus1KeysP = Pseq([~sus1Keys], inf).asStream;

		~transKeys = PatternProxy( Pseq([1], inf));
		~transKeysP = Pseq([~transKeys], inf).asStream;
		~transShufKeys = PatternProxy( Pseq([1], inf));
		~transShufKeysP = Pseq([~transShufKeys], inf).asStream;

		~octKeys = PatternProxy( Pseq([3], inf));
		~octKeysP = Pseq([~octKeys], inf).asStream;
		~legKeys = PatternProxy( Pseq([0.0], inf));
		~legKeysP = Pseq([~legKeys], inf).asStream;
		~hrmKeys = PatternProxy( Pseq([1.0], inf));
		~hrmKeysP = Pseq([~hrmKeys], inf).asStream;

		~delta1Keys = PatternProxy( Pseq([1/1], inf));
		~delta1KeysP = Pseq([~delta1Keys], inf).asStream;
		~lfoRtKeys = PatternProxy( Pseq([20], inf));
		~lfoRtKeysP = Pseq([~lfoRtKeys], inf).asStream;

		~delta2Keys = PatternProxy( Pseq([1/1], inf));
		~delta2KeysP = Pseq([~delta2Keys], inf).asStream;
		~lfoCtKeys = PatternProxy( Pseq([40], inf));
		~lfoCtKeysP = Pseq([~lfoCtKeys], inf).asStream;

		~delta3Keys = PatternProxy( Pseq([1/2], inf));
		~delta3KeysP = Pseq([~delta3Keys], inf).asStream;
		~vcfCtKeys = PatternProxy( Pseq([40], inf));
		~vcfCtKeysP = Pseq([~vcfCtKeys], inf).asStream;

		~lfo1Keys = PatternProxy( Pseq([10], inf));
		~lfo1KeysP = Pseq([~lfo1Keys], inf).asStream;
		~lfo2Keys = PatternProxy( Pseq([10], inf));
		~lfo2KeysP = Pseq([~lfo2Keys], inf).asStream;

		~actKeys = PatternProxy( Pseq([1], inf));
		~actKeysP= Pseq([~actKeys], inf).asStream;

		~volKeys = PatternProxy( Pseq([0.9], inf));
		~volKeysP = Pseq([~volKeys], inf).asStream;

	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~keysLate.wait;
				//this.p1_SC(val);
				this.p1(val);
				((~dur1KeysP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}

	}

	*p1_SC {|i=1|
		var val;
		val=i;

		Pbind(
			\instrument, \IFKeys_SC, \scale, Pfunc({~scl2}, inf),
			\bufnum, Pseq([~bufnumKeysP.next], inf),
			\dur, Pseq([~dur1KeysP.next],~actKeysP),
			\degree, Pseq([~nt1KeysP.next], inf),
			\amp, Pseq([~volKeysP.next*~amp1KeysP.next], inf),
			\sustain, Pseq([~sus1KeysP.next],inf)*~susMulKeys,
			\mtranspose, Pseq([~transKeysP.next], inf)+~trKeys+~transShufKeysP.next,
			\octave, Pseq([~octKeysP.next], inf)+~octMulKeys,
			\harmonic, Pseq([~hrmKeysP.next], inf)+~harmKeys,
			\legato, Pseq([~legKeysP.next], inf),
			\pan, Pbrown(-0.9, 0.8, 0.125, inf),
			\rootFreq,  ~rootFreqKeys,

			\cut1, Pbrown(0.05, 1.0, 0.125, inf)*~cutKeys,
			\sin1, Pbrown(0.1, 1.0, 0.125, inf)*~sin1Keys,
			\sin2, Pbrown(0.2, 2.0, 0.125, inf)*~sin2Keys,
			\att, ~attKeys,
			\dec, ~decKeys,
			\susLev, ~susLevKeys,
			\rel, ~relKeys,
			\lfo1Rate, Pseq([~lfo1KeysP.next],inf)*~lfoMulKeys,
			\lfo2Rate, Pseq([~lfo2KeysP.next],inf)*~lfoMulKeys,
			\group, ~piges,
			\out, Pseq([~busKeys], inf )
		).play(quant:0);

	}//p1_SC

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chKeys,
			\type, \midi, \midiout,~vKeys, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1KeysP.next],~actKeysP),
			\degree, Pseq([~nt1KeysP.next], inf),
			\amp, Pseq([~volKeysP.next*~amp1KeysP.next], inf),
			\sustain, Pseq([~sus1KeysP.next],inf)*~susMulKeys,
			\mtranspose, Pseq([~transKeysP.next], inf)+~trKeys+~transShufKeysP.next,
			\octave, Pseq([~octKeysP.next], inf)+~octMulKeys,
			\harmonic, Pseq([~hrmKeysP.next], inf)+~harmKeys
		).play;

		//VKeys
		Pbind(//LFO CUT KEYS INT
			\midicmd, \control, \type, \midi,
			\midiout,~vKeys, \chan, 0, \ctlNum, ~lfoCut,
			\delta, Pseq([~delta1KeysP.value], ~actKeysP),
			\control, Pseq([~lfoCtKeysP.value], inf)*~lfoMulKeys1,
		).play;

		Pbind(//LFO RATE KEYS
			\midicmd, \control, \type, \midi,
			\midiout,~vKeys, \chan, 0, \ctlNum, ~lfoRate,
			\delta, Pseq([~delta2KeysP.value], ~actKeysP),
			\control, Pseq([~lfoRtKeysP.value], inf)*~lfoMulKeys2,
		).play;

	}//p1
	*apc40{

		~volKeys_APC.free;
		~volKeys_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volKeys', vel/127);
			~volKeys.source = vel/127;
		},srcID:~apc40InID, chan:~apcMnCh, ccNum:~apcFd5);

		//Act ButA5
		//Keys Activate
		~cntActLine5ButA5=0;
		~mdActLine5ButA5.free;
		~mdActLine5ButA5=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine5ButA5 = ~cntActLine5ButA5 + 1;
				~cntActLine5ButA5.switch(
					0,{},
					1, {
						IFAPC40.actLine5ButA5(1);
					},
					2,{
						IFAPC40.actLine5ButA5(0);
					}
			)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButA5);

		//Act ButB5
		//Keys Time Div2
		~cntActLine5ButB5=0;
		~mdActLine5ButB5.free;
		~mdActLine5ButB5=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine5ButB5 = ~cntActLine5ButB5 + 1;
				~cntActLine5ButB5.switch(
					0,{},
					1, {
						IFAPC40.actLine5ButB5(1);
					},
					2,{
						IFAPC40.actLine5ButB5(0);
					}
			)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButB5);

		//Act ButC5
		//Static Keys Activate
		~cntActLine5ButC5=0;
		~mdActLine5ButC5.free;
		~mdActLine5ButC5=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine5ButC5 = ~cntActLine5ButC5 + 1;
				~cntActLine5ButC5.switch(
					0,{},
					1, {
						IFAPC40.actLine5ButC5(1);
					},
					2,{
						IFAPC40.actLine5ButC5(0);
					}
			)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButC5);

	}//*apc40
	*osc{

		~actKeysBut.free;
		~actKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actKeys.source=1;
				~apc40.noteOn(~apcMnCh, ~actButA5, 127); //Trk5_But 1
			},{
				~actKeys.source=0;
				~apc40.noteOff(~apcMnCh, ~actButA5, 127); //Trk5_But
			});
		},
		'/activKeys'
		);

		~time2KeysBut.free;
		~countTime2Keys=0;
		~time2KeysBut= OSCFunc({
			arg msg;

			~countTime2Keys = ~countTime2Keys + 1;
			~countTime2Keys.switch(
				0,{},
				1, {
					~apc40.noteOn(~apcMnCh, ~actButB5, 1); //Trk5_But 2
					//~tOSCAdrr.sendMsg('time2Keys', 1);
					//~tOSCAdrr.sendMsg('tmKeysLabel', 2);
					~tmMulKeys.source = Pseq([2], inf);
				},
				2,{
					~apc40.noteOn(~apcMnCh, ~actButB5, 0); //Trk5_But 2
					//~tOSCAdrr.sendMsg('time2Keys', 0);
					//~tOSCAdrr.sendMsg('tmKeysLabel', 1);
					~tmMulKeys.source = Pseq([1], inf);
					~countTime2Keys=0;
				}
			);
		},
		'/time2Keys'
		);

		~volKeysFader.free;
		~volKeysFader= OSCFunc({
			arg msg,vel,val;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volKeys', msg[1]);
			//~vKeys.control(5, 1, vel);
			~volKeys.source = val;
		},
		'/volKeys'
		);

		~attKeysFader.free;
		~attKeysFader= OSCFunc({
			arg msg,vel,val;
			vel=msg[1]*127;
			val=msg[1];
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('attKeys', msg[1]);
				~vKeys.control(0, ~envAtt, val);
				~attKeys=val+0.01;
			},{
				~tOSCAdrr.sendMsg('attKeys', msg[1]);
				~attKeys=val+0.01;
			});
		},
		'/attKeys'
		);


		~susKeysFader.free;
		~susKeysFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('susKeys', msg[1]);
				~vKeys.control(0, ~envSus, vel+0.01);
				~susLevKeys=val;
			},{
				~tOSCAdrr.sendMsg('susKeys', msg[1]);
				~susLevKeys=val;
			});
		},
		'/susKeys'
		);


		~decKeysFader.free;
		~decKeysFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('decKeys', val);
				~vKeys.control(0, ~envDec, vel+0.01);
				~decKeys=val;
				~relKeys=val*0.7;
			},{
				~tOSCAdrr.sendMsg('decKeys', val);
				~decKeys=val;
				~relKeys=val*0.7;
			});
		},
		'/decKeys'
		);

		~xy1Keys.free;
		~xy1Keys= OSCFunc({
			arg msg,val1,val2,vel;
			val1=msg[1];
			val2=msg[2];
			vel=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~vKeys.control(0, ~dlyTime, msg[2]*127); //Delay Time
				~vKeys.control(0, ~dlyFeed, msg[1]*127); //Delay FeedBack
				~tOSCAdrr.sendMsg('xy1Keys', msg[1], msg[2]);
			},{

				~tOSCAdrr.sendMsg('xy1Keys', msg[1], msg[2]);
			});
		},
		'/xy1Keys'
		);

		~chainKeysFader.free;
		~chainKeysFader= OSCFunc({
			arg msg, val;
			val=msg[1]*127;
			~tOSCAdrr.sendMsg('chainKeys', msg[1]);
		},
		'/chainKeys'
		);

		~sendsKeys.free;
		~sendsKeys= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~tOSCAdrr.sendMsg('sendKeys', msg[1], msg[2]);
			~mdOut.control(6, 4, vel1); // IFKeys
			~mdOut.control(6, 3, vel2); // IFKeys
			~mdOut.control(6, 10, vel2); // IFKeys sendC

		},
		'/sendKeys'
		);




		/**/

		~lfoMulKeysFad1.free;
		~lfoMulKeysFad1= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulKeys1', msg[1]);
			~lfoMulKeys1=msg[1]*1.2;
		},
		'/lfoMulKeys1'
		);

		~lfoMulKeysFad2.free;
		~lfoMulKeysFad2= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulKeys2', msg[1]);
			~lfoMulKeys2=msg[1]*1.2;
		},
		'/lfoMulKeys2'
		);

		//TIME

		~tmMulKeysBut1.free;
		~tmMulKeysBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulKeys.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', 1);

			});

		},
		'/tmMulKeys1'
		);
		~tmMulKeysBut2.free;
		~tmMulKeysBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulKeys.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', 2);

			});

		},
		'/tmMulKeys2'
		);
		~tmMulKeysBut3.free;
		~tmMulKeysBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulKeys.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', 3);

			});

		},
		'/tmMulKeys3'
		);
		~tmKeysFader.free;
		~tmKeysFader= OSCFunc({
			arg msg;
			~tmKeys.source = msg[1];

		},
		'/timesKeys'
		);



		~padKeys.free;
		~padKeys = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFKeys(~tmKeysP.next);

			});
		},
		'/padKeys'
		);

		//----Keys-------
		~octKeysMulBut.free;
		~octKeysMulBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulKeys = ~octMulKeys+1;
				~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);
			});
		},
		'/octKeysMul'
		);

		~octKeysZeroBut.free;
		~octKeysZeroBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulKeys = 0;
				~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);
			});
		},
		'/octKeysZero'
		);

		~octKeysDivBut.free;
		~octKeysDivBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulKeys = ~octMulKeys-1;
				~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);
			});
		},
		'/octKeysDiv'
		);

	}
	*synthDef{|index|
		index.switch(
			1,{
				SynthDef( \IFKeys_SC, { |out=0, bufnum, amp = 0.9, freq = 160, rootFreq = 160, mul=0.4,
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
					osc1 = Saw.ar(freq,osc2.tanh, env);

					buf = PlayBuf.ar(1, bufnum, rate:freqBuf, startPos: startPos, loop:0)*env;
					filt= MoogFF.ar(
						[osc1],
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

			},
			3,{

			},
			4,{},
			5,{}
		)
	}


}