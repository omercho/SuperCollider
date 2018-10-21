/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

IFMopho.times(2);
IFMopho.p1_SC(1);
~octMopho=4;

~vMopho.noteOn(~chMopho, 26, 111); //But 1
~vMopho.noteOff(~chMopho, 26, 1); //But 1

*/
IFMopho {
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
		this.osc;
		this.apc40;
	}
	*globals{
		//~chMopho=1;
		~lateMopho=0.0;
		~timesMopho=1;
		~octMulMopho=0;
		~harmMopho=0;
		~rootMopho=0;
		~susMulMopho=1;
		~trMopho=0;
		~lfoMulMopho1=0.2;
		~lfoMulMopho2=0.2;
	}
	*octave{|val|
		~octMopho.source = Pseq([val], inf);
	}
	*octMul{|val|
		~octMulMopho = val;
		~tOSCAdrr.sendMsg('octMophoLabel', val);
	}



	*proxy {

		~nt1Mopho = PatternProxy( Pseq([0], inf));
		~nt1MophoP = Pseq([~nt1Mopho], inf).asStream;
		~dur1Mopho = PatternProxy( Pseq([1], inf));
		~dur1MophoP = Pseq([~dur1Mopho], inf).asStream;
		~amp1Mopho = PatternProxy( Pseq([0.9], inf));
		~amp1MophoP = Pseq([~amp1Mopho], inf).asStream;
		~sus1Mopho = PatternProxy( Pseq([1], inf));
		~sus1MophoP = Pseq([~sus1Mopho], inf).asStream;

		~transMopho = PatternProxy( Pseq([0], inf));
		~transMophoP = Pseq([~transMopho], inf).asStream;
		~transShufMopho = PatternProxy( Pseq([0], inf));
		~transShufMophoP = Pseq([~transShufMopho], inf).asStream;


		~octMopho = PatternProxy( Pseq([4], inf));
		~octMophoP = Pseq([~octMopho], inf).asStream;
		~legMopho = PatternProxy( Pseq([0.0], inf));
		~legMophoP = Pseq([~legMopho], inf).asStream;
		~hrmMopho = PatternProxy( Pseq([1.0], inf));
		~hrmMophoP = Pseq([~hrmMopho], inf).asStream;

		~delta1Mopho = PatternProxy( Pseq([1/1], inf));
		~delta1MophoP = Pseq([~delta1Mopho], inf).asStream;
		~delta2Mopho = PatternProxy( Pseq([1/1], inf));
		~delta2MophoP = Pseq([~delta2Mopho], inf).asStream;

		~lfo1Mopho = PatternProxy( Pseq([10], inf));
		~lfo1MophoP = Pseq([~lfo1Mopho], inf).asStream;
		~lfo2Mopho = PatternProxy( Pseq([58], inf));
		~lfo2MophoP = Pseq([~lfo2Mopho], inf).asStream;

		~actMopho = PatternProxy( Pseq([1], inf));
		~actMophoP= Pseq([~actMopho], inf).asStream;

		~volMopho = PatternProxy( Pseq([0.9], inf));
		~volMophoP = Pseq([~volMopho], inf).asStream;

	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~lateMopho.wait;
				this.p1(val);
				//this.p1(val);
				((~dur1MophoP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chMopho,
			\type, \midi, \midiout,~vMopho, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1MophoP.next],~actMophoP),
			\degree, Pseq([~nt1MophoP.next], 1),
			\amp, Pseq([~volMophoP.next*~amp1MophoP.next], 1),
			\sustain, Pseq([~sus1MophoP.next],1)*~susMulMopho,
			\mtranspose, Pseq([~transMophoP.next], 1)+~trMopho+~transShufMophoP.next,
			\octave, Pseq([~octMophoP.next], 1)+~octMulMopho,
			\harmonic, Pseq([~hrmMophoP.next], 1)+~harmMopho
		).play;

		//VMopho
		/*Pbind(//LFO CUT Mopho INT
			\midicmd, \control, \type, \midi,
			\midiout,~vMopho, \chan, ~chMopho, \ctlNum, 22,//Osc_1 Shape
			\delta, Pseq([~delta1MophoP.next], 1),
			\control, Pseq([~lfo1MophoP.value], 1)*~lfoMulMopho1,
		).play;
		Pbind(//LFO CUT Mopho RATE
			\midicmd, \control, \type, \midi,
			\midiout,~vMopho, \chan, ~chMopho, \ctlNum, 26,//Osc_1 Shape
			\delta, Pseq([~delta2MophoP.next], 1),
			\control, Pseq([~lfo2MophoP.value], 1)*~lfoMulMopho2,
		).play;*/

	}//p1
	*apc40{

		/*~volMopho_APC.free;
		~volMopho_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volMopho', vel/127);
			~volMopho.source = vel/127;
		},srcID:~apcMnInID, chan:~apcMnCh, ccNum:~apcFd7);*/

		//Act ButA4
		//Mopho Activate
		~cntActLine7ButA7=0;
		~mdActLine7ButA7.free;
		~mdActLine7ButA7=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine7ButA7 = ~cntActLine7ButA7 + 1;
				~cntActLine7ButA7.switch(
					0,{},
					1, {
						IFAPCMn.actLine7ButA7(1);
					},
					2,{
						IFAPCMn.actLine7ButA7(0);
					}
			)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButA7);

		//Act ButB4
		//Mopho Time Div2
		~cntActLine7ButB7=0;
		~mdActLine7ButB7.free;
		~mdActLine7ButB7=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine7ButB7 = ~cntActLine7ButB7 + 1;
				~cntActLine7ButB7.switch(
					0,{},
					1, {
						IFAPCMn.actLine7ButB7(1);
					},
					2,{
						IFAPCMn.actLine7ButB7(0);
					}
			)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButB7);

		//Act ButC
		//Static Mopho Activate
		~cntActLine7ButC7=0;
		~mdActLine7ButC7.free;
		~mdActLine7ButC7=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine7ButC7 = ~cntActLine7ButC7 + 1;
				~cntActLine7ButC7.switch(
					0,{},
					1, {
						IFAPCMn.actLine7ButC7(1);
					},
					2,{
						IFAPCMn.actLine7ButC7(0);
					}
			)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButC7);
	}//*apc40

	*osc{

		~actMophoBut.free;
		~actMophoBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actMopho.source=1;
				~apcMn.noteOn(~apcMnCh, ~actButA7, 127); //Trk4_But 1
			},{
				~actMopho.source=0;
				~apcMn.noteOff(~apcMnCh, ~actButA7, 127); //Trk4_But 1
			});
		},
		'/activMopho'
		);

		~time2MophoBut.free;
		~countTime2Mopho=0;
		~time2MophoBut= OSCFunc({
			arg msg;

			~countTime2Mopho = ~countTime2Mopho + 1;
			~countTime2Mopho.switch(
				0,{},
				1, {
					~apcMn.noteOn(~apcMnCh, ~actButB7, 1); //Trk4_But 2
					//~tOSCAdrr.sendMsg('time2Mopho', 1);
					//~tOSCAdrr.sendMsg('tmMophoLabel', 2);
					~tmMulMopho.source = Pseq([2], inf);
				},
				2,{

					//~tOSCAdrr.sendMsg('time2Mopho', 0);
					//~tOSCAdrr.sendMsg('tmMophoLabel', 1);
					~tmMulMopho.source = Pseq([1], inf);
					~apcMn.noteOn(~apcMnCh, ~actButB7, 0); //Trk4_But 2
					~countTime2Mopho=0;
				}
			);
		},
		'/time2Mopho'
		);


		~volMophoFader.free;
		~volMophoFader= OSCFunc({
			arg msg,vel,val;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volMopho', msg[1]);
			//~vMopho.control(5, 1, vel);
			~volMopho.source = val;
		},
		'/volMopho'
		);

		~attMophoFader.free;
		~attMophoFader= OSCFunc({
			arg msg,vel,val;
			vel=msg[1]*127;
			val=msg[1];
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('attMopho', val);
				//~vMopho.control(~chMopho, ~egAtt, vel+0.01);
				~vMopho.control(~chMopho, 118, vel+0.01); //Amp Att
				~attMopho=val+0.01;
			},{
				~tOSCAdrr.sendMsg('attMopho', val);
				~attMopho=val+0.01;
			});

		},
		'/attMopho'
		);

		~susMophoFader.free;
		~susMophoFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('susMopho', msg[1]);
				~vMopho.control(~chMopho, 75, vel); //Amp Sus
				~susLevMopho=val;
			},{
				~tOSCAdrr.sendMsg('susMopho', msg[1]);
				~susLevMopho=val;
			});
		},
		'/susMopho'
		);

		~decMophoFader.free;
		~decMophoFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('decMopho', val);
				~decMopho=val;
				~relMopho=val*0.7;
				~vMopho.control(~chMopho, 119, vel); //Amp Dec
				~vMopho.control(~chMopho, 76, vel/2);
			},{
				~tOSCAdrr.sendMsg('decMopho', val);
				~decMopho=val;
				~relMopho=val*0.7;
			});
		},
		'/decMopho'
		);


		~susMulMophoFader.free;
		~susMulMophoFader= OSCFunc({
			arg msg, val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('susMulMopho', val);
			~susMulMopho=val;
		},
		'/susMulMopho'
		);

		~chainMophoFader.free;
		~chainMophoFader= OSCFunc({
			arg msg, val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('chainMopho',val);

		},
		'/chainMopho'
		);

		~sendMophoFader.free;
		~sendMophoFader= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~tOSCAdrr.sendMsg('sendMopho', msg[1], msg[2]);
			~mdOut.control(8, 4, vel1); //Mopho / SendA
			~mdOut.control(8, 3, vel2); //Mopho / SendB
		},
		'/sendMopho'
		);
		~lfoMulMophoFad1.free;
		~lfoMulMophoFad1= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulMopho1', msg[1]);
			//~lfoMulMopho1=msg[1]*1.1;
		},
		'/lfoMulMopho1'
		);

		~lfoMulMophoFad2.free;
		~lfoMulMophoFad2= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulMopho2', msg[1]);
			//~lfoMulMopho2=msg[1]*1.1;
		},
		'/lfoMulMopho2'
		);

		//TIME

		~tmMulMophoBut1.free;
		~tmMulMophoBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulMopho.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmMophoLabel', 1);
			});
		},
		'/tmMulMopho1'
		);
		~tmMulMophoBut2.free;
		~tmMulMophoBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulMopho.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmMophoLabel', 2);
			});
		},
		'/tmMulMopho2'
		);
		~tmMulMophoBut3.free;
		~tmMulMophoBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulMopho.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmMophoLabel', 3);
			});
		},
		'/tmMulMopho3'
		);
		~tmMophoFader.free;
		~tmMophoFader= OSCFunc({
			arg msg;
			~tmMopho.source = msg[1];
		},
		'/timesMopho'
		);
		~padMopho.free;
		~padMopho = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFMopho(~tmMophoP.next);
			});
		},
		'/padMopho'
		);
		//----Mopho-------
		~octMophoMulBut.free;
		~octMophoMulBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulMopho = ~octMulMopho+1;
				~tOSCAdrr.sendMsg('octMophoLabel', ~octMulMopho);
			});
		},
		'/octMophoMul'
		);
		~octMophoZeroBut.free;
		~octMophoZeroBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulMopho = 0;
				~tOSCAdrr.sendMsg('octMophoLabel', ~octMulMopho);
			});
		},
		'/octMophoZero'
		);
		~octMophoDivBut.free;
		~octMophoDivBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulMopho = ~octMulMopho-1;
				~tOSCAdrr.sendMsg('octMophoLabel', ~octMulMopho);
			});
		},
		'/octMophoDiv'
		);
	}



}
/*

~vMopho.noteOn(~chMopho, 26, 111); //But 1
~vMopho.noteOff(~chMopho, 26, 1); //But 1

~vMopho.control(~chMopho, 20, 48); //Osc_1 Freq
~vMopho.control(~chMopho, 21, 50); //Osc_1 Fine Tune
~vMopho.control(~chMopho, 22, 3); //Osc_1 Shape
~vMopho.control(~chMopho, 23, 13); //Osc_1 Glide

~vMopho.control(~chMopho, 24, 60); //Osc_2 Freq
~vMopho.control(~chMopho, 25, 57); //Osc_2 Fine Tune
~vMopho.control(~chMopho, 26, 58); //Osc_2 Shape
~vMopho.control(~chMopho, 27, 113); //Osc_2 Glide

~vMopho.control(~chMopho, 28, 64); //Osc Mix

~vMopho.control(~chMopho, 30, 0); //Sub Osc_1
~vMopho.control(~chMopho, 31, 120); //Sub Osc_2


~vMopho.control(~chMopho, 102, 110); //Filter Freq CutOff
~vMopho.control(~chMopho, 103, 17); //Filter Resonans
~vMopho.control(~chMopho, 104, 17); //Filter Key Amnt
~vMopho.control(~chMopho, 105, 7); //Filter Audio Mod
~vMopho.control(~chMopho, 106, 0); //Filter Env Amnt
~vMopho.control(~chMopho, 107, 127); //Filter Env Vel Amnt
~vMopho.control(~chMopho, 108, 0); //Filter Dly
~vMopho.control(~chMopho, 109, 1); //Filter Att
~vMopho.control(~chMopho, 110, 10); //Filter Dec
~vMopho.control(~chMopho, 111, 20); //Filter Sus
~vMopho.control(~chMopho, 112, 17); //Filter Rel

~vMopho.control(~chMopho, 113, 0); //VCA Lvl
~vMopho.control(~chMopho, 115, 127); //Amp Env Amnt
~vMopho.control(~chMopho, 116, 127); //Amp Env Vel Amnt
~vMopho.control(~chMopho, 117, 0); //Amp Dly
~vMopho.control(~chMopho, 118, 1); //Amp Att
~vMopho.control(~chMopho, 119, 37); //Amp Dec
~vMopho.control(~chMopho, 75, 45); //Amp Sus
~vMopho.control(~chMopho, 76, 10); //Amp Rel

~vMopho.control(~chMopho, 85, 7); //Env3 Dest
~vMopho.control(~chMopho, 86, 7); //Env3 Amnt
~vMopho.control(~chMopho, 87, 7); //Env3 Vel Amnt
~vMopho.control(~chMopho, 88, 7); //Env3 Dly
~vMopho.control(~chMopho, 89, 7); //Env3 Att
~vMopho.control(~chMopho, 90, 7); //Env3 Dec
~vMopho.control(~chMopho, 77, 7); //Env3 Sus
~vMopho.control(~chMopho, 78, 7); //Env3 Rel


~vMopho.control(~chMopho, 29, 0); //Noise Lev
~vMopho.control(~chMopho, 14, 123); //BPM
~vMopho.control(~chMopho, 15, 0); //Clock Divide

//MOPHO SEND NRPN
//NRPN control of filter pole on DSI Tetra:
//   first, set parameter number (24 in this case)
//   set most significant byte for parameter number (0 in this case)
~vMopho.control(~chMopho, 99, 0);
//   then least significant byte for parameter number (24 in this case)
~vMopho.control(~chMopho, 98, 24);
// then set value (1 for 4 pole)
//   first set most significant byte for this value (0 in this case)
~vMopho.control(~chMopho, 6, 0);
//   then least significant byte for parameter number (1 in this case)
~vMopho.control(~chMopho,38, 1);

*/