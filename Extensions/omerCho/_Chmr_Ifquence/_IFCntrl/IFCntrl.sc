/*
PostAllMIDI.on;
PostAllMIDI.off;

~mdOut.control(1, 7, 0); //FX Rev Decay

IFLoad.load;
IFLoad.loadVolca;
*/
IFCntrl {
	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
			1.0.wait;
			this.globals;
			this.mulFaders;
			this.main;
			this.parts;
			});*/
		}
	}
	*loadAll {
		this.main;
		//this.mutes;
	}
	*main {
		~togMain.free;
		~togMain = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"IF Main PLAY".postln;
				//~mdClock.start;//TempoClock to IAC MIDI
				fork{1.do{
					IFRoot.play;
					Ableton.tap4;
					~tOSCAdrr.sendMsg('/1/toggleMain', 1);
					0.000.wait;
				}};
			});
			if ( msg[1]==0, {
				"IF Main STOP".postln;
				//~mdClock.stop;//TempoClock to IAC MIDI
				fork{1.do{
					IFRoot.stop;
					Ableton.stop;
					~tOSCAdrr.sendMsg('/1/toggleMain', 0);
				}};
			});
		},'/1/toggleMain');

		~tempoFader.free;
		~tempoFader= OSCFunc({
			arg msg,val;
			val=msg[1];
			IFProjectGlobals.setTempo(msg[1]);
			~tOSCAdrr.sendMsg('tempoLabel', msg[1]);
			~tOSCAdrr.sendMsg('tempoFader', msg[1]);
		},'/tempoFader');

		~tempoMul.free;
		~tempoMul= OSCFunc({
			arg msg,val;
			val=msg[1];
			if ( msg[1]==1, {
				~tOSCAdrr.sendMsg('tempoLabel', Tempo.bpm*2);
				~tOSCAdrr.sendMsg('tempoFader', Tempo.bpm*2);
				IFProjectGlobals.setTempo(Tempo.bpm*2);
			});
		},'/tempoMul');

		~tempoDiv.free;
		~tempoDiv= OSCFunc({
			arg msg,val;
			val=msg[1];
			if ( msg[1]==1,{
				~tOSCAdrr.sendMsg('tempoLabel', Tempo.bpm/2);
				~tOSCAdrr.sendMsg('tempoFader', Tempo.bpm/2);
				IFProjectGlobals.setTempo(Tempo.bpm/2);
			});
		},'/tempoDiv');

		~tempoClockBut.free;
		~tempoClockLedCount = 0;
		~tempoClockBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tempoClockLedCount = ~tempoClockLedCount+1;
				~tempoClockLedCount.switch(
					1,{
						~mdClock.start;//TempoClock to IAC MIDI
						~clockLedF={inf.do{
							~tOSCAdrr.sendMsg('clockLed', 1);
							0.3.wait;
							~tOSCAdrr.sendMsg('clockLed', 0);
							0.7.wait;
						}}.fork;
					},
					2,{
						~mdClock.stop;
						~clockLedF.stop;
						~tempoClockLedCount = 0;
						~tOSCAdrr.sendMsg('clockLed', 0);
					}
				);
			});
		},'/tempoClock');

		~snrXPoseFad.free;
		~snrXPoseFad= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('snrXPose',msg[1]);
			~mdOut.control(2, 8, msg[1]*127); //Kick / Xpose
			~mdOut.control(3, 15, msg[1]*127); //Snr X-Transpose
			~tOSCAdrr.sendMsg('noteLabelDrum', msg[1]);
		},'snrXPose');
		~fsDryFad.free;
		~fsDryFad= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('freqShiftDry',msg[1]);
			~mdOut.control(2, 8, msg[1]*127); //Kick / Xpose
			~mdOut.control(3, 15, msg[1]*127); //Snr X-Transpose
			~tOSCAdrr.sendMsg('noteLabelDrum', msg[1]);
		},'freqShiftDry');
		~susDrumLedVal;
		~susDrumMulFader.free;
		~susDrumMulFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('/susDrum',~susDrumLedVal=val);
			~susMulKick=val+0.15;~susMulSnr=val+0.2;~susMulHat=val+0.15;
		},'/susDrum');
		~cutDrumXY.free;
		~cutDrumXY= OSCFunc({
			arg msg,vel1, vel2,val1,val2;
			vel1=msg[1]*127;
			vel2=msg[2]*127;
			val1=msg[1];
			val2=msg[2];
			~tOSCAdrr.sendMsg('/cutDrum',msg[1], msg[2]);
			~mdOut.control(2, 14, vel1);//Kick / Act Delay-Filter LFO
			~mdOut.control(2, 15, vel2);//Kick / FreqShift DryWet
			~mdOut.control(10, 30, vel1);//Drum / Filt Morph - Feedback Hat Delay
			~mdOut.control(10, 31, vel2);//Drum / Delay Feedback
			~mdOut.control(10, 32, vel1);//Drum / Delay DryWet
		},'cutDrum');
		~xySendsDrumMel.free;
		~xySendsDrumMel= OSCFunc({
			arg msg,vel1,vel2;
			vel1=msg[1];
			vel2=msg[2];
			~tOSCAdrr.sendMsg('/sendDrumMelC',msg[1], msg[2]);
			~mdOut.control(10, 25, msg[1]*127);//Drum SendC
			~mdOut.control(10, 25, ~midiVel); //Drum SendC
			~mdOut.control(10, 75, msg[2]*127);//Mel SendC
		},'sendDrumMelC');
		~xySendsDrum.free;
		~xySendsDrum= OSCFunc({
			arg msg,vel1,vel2;
			vel1=msg[1];
			vel2=msg[2];
			~tOSCAdrr.sendMsg('/drumSends',msg[1], msg[2]);
			~mdOut.control(10, 23, msg[1]*127);//Drum / Send A
			~mdOut.control(10, 24, msg[2]*127);//Drum / Send B
			//~mdOut.control(10, 25, msg[2]*127);//Drum / Send C
		},'/drumSends');
		~xySendsMel.free;
		~xySendsMel= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1];
			vel2=msg[2];

			~tOSCAdrr.sendMsg('/melSends',msg[1], msg[2]);
			~mdOut.control(10, 73, msg[1]*127);//Mel / Send A
			~mdOut.control(10, 74, msg[2]*127);//Mel / Send B
			//~mdOut.control(10, 75, msg[2]*127);//Mel / Send C

		},'/melSends');

		~sendOff.free;
		~sendOff = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~local.sendMsg('sendDrumMelC',0.0, 0.0);
				~local.sendMsg('melSends',0.0, 0.0);
				~local.sendMsg('drumSends',0.0, 0.0);
				~local.sendMsg('sendKick', 0.0, 0.0);
				~local.sendMsg('sendSnr', 0.0, 0.0);
				~local.sendMsg('sendHat', 0.0, 0.0);
				~local.sendMsg('sendBass', 0.0, 0.0);
				~local.sendMsg('sendKeys', 0.0, 0.0);
				~local.sendMsg('sendSamp', 0.0, 0.0);
				~local.sendMsg('extSends',0.2,0.3);

			});
		},
		'/sendsOff'
		);

		~octRandAllBut.free;
		~octRandAllBut = OSCFunc({
			arg msg;
			if ( msg[1]==1,{
				//~octMulKick = [0,1,2,3].choose;
				//~octMulSnr = [0,1,2,3].choose;
				//~octMulHat = [0,1,2,3].choose;
				~octMulBass = [0,1,2,3].choose;
				~octMulKeys = [0,1,2,3].choose;
				~octMulSamp = [0,1,2,3].choose;
				~octMulMopho = [0,1,2,3].choose;
				//~octMulExt= [0,1,2,3].choose;
			},
			{

				//~local.sendMsg('octKickZero',1);
				//~local.sendMsg('octSnrZero',1);
				//~local.sendMsg('octHatZero',1);
				~local.sendMsg('octBassZero',1);
				~local.sendMsg('octKeysZero',1);
				~local.sendMsg('octSampZero',1);
				~local.sendMsg('octMophoZero',1);
				//~local.sendMsg('octExtZero',1);

			});
		},'/octRandAll');

		~sendOn.free;
		~sendOn = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~local.sendMsg('sendDrumMelC',0.5, 0.5);
				~local.sendMsg('melSends',0.5, 0.5);
				~local.sendMsg('drumSends',0.5, 0.5);
				~local.sendMsg('sendKick', 0.5, 0.5);
				~local.sendMsg('sendSnr', 0.5, 0.5);
				~local.sendMsg('sendHat', 0.5, 0.5);
				~local.sendMsg('sendBass', 0.5, 0.5);
				~local.sendMsg('sendKeys', 0.5, 0.5);
				~local.sendMsg('sendMopho', 0.5, 0.5);
				~local.sendMsg('sendSamp', 0.5, 0.5);
				~local.sendMsg('extSends',0.2,0.3);

			});
		},'/sendsOn');
		~susMelLedVal;
		~susMelMulFader.free;
		~susMelMulFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~susMelLedVal=msg[1];
			~tOSCAdrr.sendMsg('/susMel', ~susMelLedVal=msg[1]);
			//~susMulBass=msg[1];
			~susMulKeys=msg[1];~susMulSamp=msg[1];~susMulMopho=msg[1];
		},'/susMel');
		~susMelMulBut.free;
		~susMelMulBut= OSCFunc({
			arg msg,val;
			val=msg[1];
			if ( msg[1]==1,{
				~susMelLedVal=~susMelLedVal+(1/64);
				~local.sendMsg('susMel',~susMelLedVal);
				("IF Count Down"+~susMelLedVal).postln;
			});
		},'/susMelSet');

		//TIME
		~tmOneBut.free;
		~tmOneBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulKick.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmKickLabel', 1);
				~tmMulSnr.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', 1);
				~tmMulHat.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmHatLabel', 1);
				~tmMulBass.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', 1);
				~tmMulKeys.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', 1);
				~tmMulSamp.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 1);
			});
		},
		'/tmOne');
		~tmTwoBut.free;
		~tmTwoBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulKick.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmKickLabel', 2);
				~tmMulSnr.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', 2);
				~tmMulHat.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmHatLabel', 2);
				~tmMulBass.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', 2);
				~tmMulKeys.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', 2);
				~tmMulSamp.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 2);
			});
		},
		'/tmTwo');
		~tmRandBut.free;
		~tmRandBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmKickRand=[1,2,1].choose;
				~tmMulKick.source = Pseq([~tmKickRand], inf);
				~tOSCAdrr.sendMsg('tmKickLabel', ~tmKickRand);

				~tmSnrRand=[1,2,2,1].choose;
				~tmMulSnr.source = Pseq([~tmSnrRand], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', ~tmSnrRand);

				~tmHatRand=[1,2,1].choose;
				~tmMulHat.source = Pseq([~tmHatRand], inf);
				~tOSCAdrr.sendMsg('tmHatLabel', ~tmHatRand);

				~tmBassRand=[1,2,1].choose;
				~tmMulBass.source = Pseq([~tmBassRand], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', ~tmBassRand);

				~tmKeysRand=[1,2,1].choose;
				~tmMulKeys.source = Pseq([~tmKeysRand], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', ~tmKeysRand);

				~tmSampRand=[1,2,1].choose;
				~tmMulSamp.source = Pseq([~tmSampRand], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', ~tmSampRand);
			});
		},
		'/tmRand');
		~tmMulDrumBut.free;
		~tmMulDrumBut= OSCFunc({
			arg msg;
			~tmMulKick.source = msg[1];
			~tmMulSnr.source = msg[1];
			~tmMulHat.source = msg[1];

		},
		'/tmMulDrum');
		~killAblBut.free;
		~killAblBut= OSCFunc({
			arg msg;
			if(msg[1]==1,{
				{"TRUE".postln;
				}.fork
			},{
				{"FALSE".postln;
				}.fork;
			});
		},
		'/killAbl');
		~tapAblBut.free;
		~tapAblBut = OSCFunc({
			arg msg;

			if ( msg[1]==1, {
				Ableton.tap4;
			});
		},
		'/tapAbl');

	}
	*freeAll {
	}
}

/*

*/