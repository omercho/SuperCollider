
/*

IFHat.p1(1);

~actHat.source=1;
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

		~chHat=2;
		~lateHat=0.00;
		~hatTimes=1;
		~harmHat=0;
		~rootHat=0;
		~susMulHat=1;
		~trHat=0;
		~octMulHat=0;
		~volCHat=1;

		~tuneHat=26;

		~freq2Hat=69;
		~freq3Hat=49;

		~lfoMulHat=1;

		~quantHat1=0.0;
		~quantHat2=0.0;

	}

	*proxy {
		~actHat = PatternProxy( Pseq([1], inf));
		~actHatP= Pseq([~actHat], inf).asStream;
		~nt1Hat = PatternProxy( Pseq([0], inf));
		~nt1HatP = Pseq([~nt1Hat], inf).asStream;
		~amp1Hat = PatternProxy( Pseq([1], inf));
		~amp1HatP = Pseq([~amp1Hat], inf).asStream;
		~dur1Hat = PatternProxy( Pseq([1], inf));
		~dur1HatP = Pseq([~dur1Hat], inf).asStream;
		~sus1Hat = PatternProxy( Pseq([1], inf));
		~sus1HatP = Pseq([~sus1Hat], inf).asStream;
		~volHat = PatternProxy( Pseq([1.0], inf));
		~volHatP = Pseq([~volHat], inf).asStream;

		~act2Hat = PatternProxy( Pseq([1], inf));
		~act2HatP= Pseq([~act2Hat], inf).asStream;
		~nt2Hat = PatternProxy( Pseq([0], inf));
		~nt2HatP = Pseq([~nt2Hat], inf).asStream;
		~amp2Hat = PatternProxy( Pseq([1], inf));
		~amp2HatP = Pseq([~amp2Hat], inf).asStream;
		~dur2Hat = PatternProxy( Pseq([1], inf));
		~dur2HatP = Pseq([~dur2Hat], inf).asStream;
		~sus2Hat = PatternProxy( Pseq([1], inf));
		~sus2HatP = Pseq([~sus2Hat], inf).asStream;
		~volHat2 = PatternProxy( Pseq([0.9], inf));
		~volHat2P = Pseq([~volHat2], inf).asStream;

		~delta1Hat2 = PatternProxy( Pseq([1], inf));
		~delta1Hat2P = Pseq([~delta1Hat2], inf).asStream;

		~transHat = PatternProxy( Pseq([0], inf));
		~transHatP = Pseq([~transHat], inf).asStream;
		~transShufHat = PatternProxy( Pseq([0], inf));
		~transShufHatP = Pseq([~transShufHat], inf).asStream;
		~extraShufHat = PatternProxy( Pshuf([0], inf));
		~extraShufHatP = Pseq([~extraShufHat], inf).asStream;

		~octHat = PatternProxy( Pseq([3], inf));
		~octHatP = Pseq([~octHat], inf).asStream;

		~hrmHat = PatternProxy( Pseq([1.0], inf));
		~hrmHatP = Pseq([~hrmHat], inf).asStream;

		~actHatLfo1 = PatternProxy( Pseq([0], inf));
		~actHatLfo1P= Pseq([~actHatLfo1], inf).asStream;



		~delta1VSamp07 = PatternProxy( Pseq([1/1], inf));
		~delta1VSamp07P = Pseq([~delta1VSamp07], inf).asStream;

		~delta2VSamp07 = PatternProxy( Pseq([1/1], inf));
		~delta2VSamp07P = Pseq([~delta2VSamp07], inf).asStream;

		~attHat=0.01;
		~decHat=0.8;
		~susLevHat=0.0;
		~relHat = 0.2;
		~lfoMulHat = 1;
		~harmHatTD =1;

		~lfo1Hat = PatternProxy( Pseq([1], inf));
		~lfo1HatP = Pseq([~lfo1Hat], inf).asStream;
		~lfo2Hat = PatternProxy( Pseq([1], inf));
		~lfo2HatP = Pseq([~lfo2Hat], inf).asStream;

	}//proxy

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~lateHat.wait;
				//this.p1_SC(val);
				this.p1(val);
				((~dur1HatP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}

	}

	*hat2{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				this.p2(val);
				((~dur2HatP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}

	}
	*p1 {|i=1|
		var val;
		val=i;

		Pbind(
			\chan, ~chHat,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~dur1HatP.next],~actHatP),
			\degree, Pseq([~nt1HatP.next], inf),
			\amp, Pseq([~volHatP.next*~amp1HatP.next], inf),
			\sustain, Pseq([~sus1HatP.next],inf)*~susMulHat,
			\mtranspose, Pseq([~transHatP.next], inf)+~trHat+~transShufHatP.next,
			\octave, Pseq([~octHatP.next], inf)+~octMulHat,
			\harmonic, Pseq([~hrmHatP.next], inf)+~harmHat
		).play(quant: ~quantHat1);


	}
	*p2{|i=1|
		var val;
		val=i;

		Pbind(
			\chan, ~chHat,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\dur, Pseq([~dur2HatP.next], ~act2HatP),
			\degree, Pseq([~nt2HatP.next], inf),
			\amp, Pseq([~volHat2P.next*~amp2HatP.next], inf),
			\sustain, Pseq([~sus2HatP.next],inf)*~susMulHat
		).play(quant:~quantHat2);
	}
	*apc40{
		/*~volHat_APC.free;
		~volHat_APC=MIDIFunc.cc( {
		arg vel;
		~tOSCAdrr.sendMsg('volHat', vel/127);
		"HAT_VOL_TestPost"+vel.postln;
		~volHat.source = vel/127;
		},srcID:~apcMnInID, chan:~apcMnCh, ccNum:~apcFd3);*/

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
						IFAPCMn.actLine3ButA3(1);
					},
					2,{
						IFAPCMn.actLine3ButA3(0);
					}
			)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButA3);

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
					1,{IFAPCMn.actLine3ButB3(1);},
					2,{IFAPCMn.actLine3ButB3(0);}
			)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButB3);

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
						IFAPCMn.actLine3ButC3(1);
					},
					2,{
						IFAPCMn.actLine3ButC3(0);
					}
			)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButC3);

	}//*apc40



	*osc {

		~actHatBut.free;
		~actHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actHat.source=1;
				~apcMn.noteOn(~apcMnCh, ~actButA3, 127); //Trk1_But 1

			},{
				~actHat.source=0;
				~apcMn.noteOff(~apcMnCh, ~actButA3, 127); //Trk1_But 1

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

					//~apcMn.noteOn(~apcMnCh, ~actButB3, 1);
					//~tOSCAdrr.sendMsg('time2Hat', 1);
					//~tOSCAdrr.sendMsg('tmHatLabel', 2);
					//~tmMulHat.source = Pseq([2], inf);
				},
				2,{

					//~apcMn.noteOn(~apcMnCh, ~actButB3, 0);
					//~tOSCAdrr.sendMsg('time2Hat', 0);
					//~tOSCAdrr.sendMsg('tmHatLabel', 1);
					//~tmMulHat.source = Pseq([1], inf);
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

		~xy1Hat.free;
		~xy1Hat= OSCFunc({
			arg msg;



		},
		'/xy1Hat'
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
	*synthDef{|index|
		index.switch(
			1,{
				SynthDef(\IFHat_SC, { |out=0, amp=0.3, gate=1,
					att =0.01, dec=0.03, susLev=0.08, rel=0.04,
					lfo1Rate=1, lfo2Rate=1,
					noose =1, freq = 90, pan = 0, freqpan=0.2 |
					var env1, env2, ses, oscs1, noise, in, n2,lfo1, lfo2;
					var hatosc, hatenv, hatnoise, hatoutput;
					lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
					lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 1.9);

					env1 = EnvGen.ar(Env.perc(att, dec));
					env2 = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);

					noise = SinOsc.ar(freq*lfo2);
					in = Mix.ar(Blip.ar(4*freq*lfo2, 2*freq*lfo1).softclip(3.2),noise);
					noise = HPF.ar(in*noise*lfo2, 0, 0.9, 0.5, Mix.ar(noise*in));
					//noise = BHiShelf.ar(Mix.ar(noise,in), 1, lfo2, -6);
					noise = BHiPass.ar(noise/in, freq*lfo1, 0.5, env2);
					in= MoogFF.ar(noise, in, 0.2);

					hatnoise = {LPF.ar(WhiteNoise.ar(1),8000*(noise/16)*env1)};

					hatosc = {HPF.ar(hatnoise,2400*lfo2)};
					hatenv = {Line.ar(1, 0, 0.1)};

					hatoutput = (0.5 * hatosc *env2);

					ses = hatoutput;
					//ses = ses;
					ses = ses.clip2(0.4);
					ses = ses * amp;

					Out.ar(out, Pan2.ar(ses, SinOsc.kr(freqpan).range(-0.8, 0.8), amp*0.6)*env2);
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

