/*

PostAllMIDI.on;
PostAllMIDI.off;

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
					~tOSCAdrr.sendMsg('/1/toggleMain', 1);
					0.000.wait;
					//~vBeatsClock.play;//TempoClock to VBeats
				}};
			});
			if ( msg[1]==0, {
				"IF Main STOP".postln;
				//~mdClock.stop;//TempoClock to IAC MIDI
				fork{1.do{
					IFRoot.stop;
					//~vBeatsClock.stop;
					~tOSCAdrr.sendMsg('/1/toggleMain', 0);
				}};
			});
		},
		'/1/toggleMain'
		);

		~tempoFader.free;
		~tempoFader= OSCFunc({
			arg msg,val;
			val=msg[1];
			IFProjectGlobals.setTempo(msg[1]);
			~tOSCAdrr.sendMsg('tempoLabel', msg[1]);
			~tOSCAdrr.sendMsg('tempoFader', msg[1]);

		},
		'/tempoFader'
		);
		~tempoMul.free;
		~tempoMul= OSCFunc({
			arg msg,val;
			val=msg[1];
			if ( msg[1]==1, {
				~tOSCAdrr.sendMsg('tempoLabel', Tempo.bpm*2);
				~tOSCAdrr.sendMsg('tempoFader', Tempo.bpm*2);
				IFProjectGlobals.setTempo(Tempo.bpm*2);
			});
		},
		'/tempoMul'
		);
		~tempoDiv.free;
		~tempoDiv= OSCFunc({
			arg msg,val;
			val=msg[1];
			if ( msg[1]==1, {
				~tOSCAdrr.sendMsg('tempoLabel', Tempo.bpm/2);
				~tOSCAdrr.sendMsg('tempoFader', Tempo.bpm/2);
				IFProjectGlobals.setTempo(Tempo.bpm/2);
			});

		},
		'/tempoDiv'
		);

		~tempoClockBut.free;
		~tempoClockLedCount = 0;
		~tempoClockBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tempoClockLedCount = ~tempoClockLedCount+1;
				~tempoClockLedCount.switch(
					1, {
						~mdClock.start;//TempoClock to IAC MIDI

						~clockLedF={inf.do{
							~tOSCAdrr.sendMsg('clockLed', 1);
							0.3.wait;
							~tOSCAdrr.sendMsg('clockLed', 0);
							0.7.wait;

						}}.fork;
					},
					2, {
						~mdClock.stop;
						~clockLedF.stop;
						~tempoClockLedCount = 0;
						~tOSCAdrr.sendMsg('clockLed', 0);
					}

				);

			},{

			}
			);
		},
		'/tempoClock'
		);

		~durResp.free;
		~durResp = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Pattern 1".postln;
				~tOSCAdrr.sendMsg('durLabel', 'Strght 02');
				~dur.source = Pseq([
					~seqDurPat01,~seqDurPat02,~seqDurPat03,~seqDurPat04,
					~seqDurPat05,~seqDurPat06,~seqDurPat07,~seqDurPat08,
					~seqDurPat09,~seqDurPat10,~seqDurPat11,~seqDurPat12,
					~seqDurPat13,~seqDurPat14,~seqDurPat15,~seqDurPat16
				],inf)*~durMulP.next;
			});
		},
		'/durResponder'
		);

		~snrXPoseFad.free;
		~snrXPoseFad= OSCFunc({
			arg msg;

			//~transKick.source= msg[1]+Pseq([0], inf);
			//~transSnr.source=msg[1]+Pseq([0], inf);
			//~transHat.source=msg[1]+Pseq([0], inf);
			~tOSCAdrr.sendMsg('snrXPose',msg[1]);
			~mdOut.control(2, 8, msg[1]*127); //Kick / Xpose
			~mdOut.control(3, 15, msg[1]*127); //Snr X-Transpose
			~tOSCAdrr.sendMsg('noteLabelDrum', msg[1]);
		},
		'/snrXPose'
		);
		~fsDryFad.free;
		~fsDryFad= OSCFunc({
			arg msg;

			//~transKick.source= msg[1]+Pseq([0], inf);
			//~transSnr.source=msg[1]+Pseq([0], inf);
			//~transHat.source=msg[1]+Pseq([0], inf);
			~tOSCAdrr.sendMsg('snrXPose',msg[1]);
			~mdOut.control(2, 8, msg[1]*127); //Kick / Xpose
			~mdOut.control(3, 15, msg[1]*127); //Snr X-Transpose
			~tOSCAdrr.sendMsg('noteLabelDrum', msg[1]);
		},
		'/freqShiftDry'
		);
		~melFad.free;
		~melFad= OSCFunc({
			arg msg;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('melFader',msg[1]);
				~mdOut.control(7, 8, msg[1]*127); //Samp Chain
				~vKeys.control(0, ~vcfEg, msg[1]*127); //VCFilter Envelope Intencity
				~vBass.control(0, ~gateTime, msg[1]*127);
				//~vBass.control(0, ~gateTime, vel1);
				~vMopho.control(~chMopho, 28, msg[1]*127); //Osc Mix

			},
			{
				~tOSCAdrr.sendMsg('melFader',msg[1]);
				~mdOut.control(7, 8, msg[1]*127); //Samp Chain
				//~vKeys.control(0, ~vcfEg, msg[1]*127); //VCFilter Envelope Intencity
				//~vBass.control(0, ~gateTime, msg[1]*127);

			}
			);
		},
		'/melFader'
		);

		~cutDrumXY.free;
		~cutDrumXY= OSCFunc({
			arg msg,vel1, vel2,val1,val2;
			vel1=msg[1]*127;
			vel2=msg[2]*127;
			val1=msg[1];
			val2=msg[2];

			~tOSCAdrr.sendMsg('/cutDrum',msg[1], msg[2]);
			~mdOut.control(10, 30, vel1);
			~mdOut.control(10, 31, vel2);

		},
		'/cutDrum'
		);

		~xySendsAllMain.free;
		~xySendsAllMain= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1];
			vel2=msg[2];

			~tOSCAdrr.sendMsg('/sendDrumMelC',msg[1], msg[2]);
			//~mdOut.control(1, 4, msg[2]*127);
			//~mdOut.control(1, 5, msg[1]*127);
			//~mdOut.control(1, 13, msg[2]*127);
			~mdOut.control(10, 25, msg[1]*127);
			~mdOut.control(10, 75, msg[2]*127);

		},
		'/sendDrumMelC'
		);

		~xySendsDrum.free;
		~xySendsDrum= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1];
			vel2=msg[2];

			~tOSCAdrr.sendMsg('/drumSends',msg[1], msg[2]);
			~mdOut.control(10, 23, msg[1]*127);
			~mdOut.control(10, 24, msg[2]*127);
			//~mdOut.control(10, 25, msg[2]*127);

		},
		'/drumSends'
		);
		~xySendsMel.free;
		~xySendsMel= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1];
			vel2=msg[2];

			~tOSCAdrr.sendMsg('/melSends',msg[1], msg[2]);
			~mdOut.control(10, 73, msg[1]*127);
			~mdOut.control(10, 74, msg[2]*127);
			//~mdOut.control(10, 75, msg[2]*127);

		},
		'/melSends'
		);

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
				//~octMulExt= [0,1,2,3].choose;
			},
			{

				//~local.sendMsg('octKickZero',1);
				//~local.sendMsg('octSnrZero',1);
				//~local.sendMsg('octHatZero',1);
				~local.sendMsg('octBassZero',1);
				~local.sendMsg('octKeysZero',1);
				~local.sendMsg('octSampZero',1);
				//~local.sendMsg('octExtZero',1);

			});
		},
		'/octRandAll'
		);



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
				~local.sendMsg('sendSamp', 0.5, 0.5);
				~local.sendMsg('extSends',0.2,0.3);

			});
		},
		'/sendsOn'
		);

		~xyAllMasterFx.free;
		~xyAllMasterFx= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1];
			vel2=msg[2];

			~tOSCAdrr.sendMsg('AllMasterFXxy1',msg[1], msg[2]);

			~mdOut.control(1, 9, msg[1]*127);
			~mdOut.control(1, 10, msg[2]*127);
		},
		'AllMasterFXxy1'
		);

		~fxFad.free;
		~fxFad= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('/fxFader', msg[1]);
			~mdOut.control(1, 8, msg[1]*127); //FX Rev Chain

		},
		'/fxFader'
		);
		~fxDecay.free;
		~fxDecay= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('/fxDecay', msg[1]);
			~mdOut.control(1, 7, msg[1]*127); //FX Rev Decay

		},
		'/fxDecay'
		);
		~fxComp.free;
		~fxComp= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('/fxComp', msg[1]);
			~mdOut.control(1, 6, msg[1]*127); //FX Rev Comp

		},
		'/fxComp'
		);

		~cutAllXY.free;
		~cutAllXY= OSCFunc({
			arg msg,vel1, vel2,val1,val2;
			vel1=msg[1]*127;
			vel2=msg[2]*127;
			val1=msg[1];
			val2=msg[2];
			if ( ~volcaBoolean==1, {
				//~mdOut.control(5, 13, vel1); // IFVBass CutX
				//~mdOut.control(6, 13, vel1); // IFVKeys CutX
				~mdOut.control(7, 13, vel1); // IFSamp CutX
				~vKeys.control(0, ~vcfCut, vel1/1.8);
				//~vMopho.control(~chMopho, 104, vel1); //Filter Key Amnt

				//~mdOut.control(5, 14, vel2); // IFVBass CutY
				//~mdOut.control(6, 14, vel2); // IFVKeys CutY
				//~mdOut.control(7, 14, vel2); // IFSamps CutY
				~vBass.control(0, ~cutOff, vel2);
				//~vMopho.control(~chMopho, 105, vel2); //Filter Audio Mod
				~tOSCAdrr.sendMsg('/cutAll',msg[1], msg[2]);
			},
			{
				~cutBass = val1; // IFVBass CutX
				~cutKeys = val2; // IFVKeys CutX
				~mdOut.control(7, 13, vel1); // IFSamp CutX

				~mdOut.control(5, 14, vel2); // IFVBass CutY
				~mdOut.control(6, 14, vel2); // IFVKeys CutY
				~mdOut.control(7, 14, vel2); // IFSamps CutY
				~tOSCAdrr.sendMsg('/cutAll',msg[1], msg[2]);
			}
			);
		},
		'/cutAll'
		);
		~cutMel2XY.free;
		~cutMel2XY= OSCFunc({
			arg msg,vel1, vel2,val1,val2;
			vel1=msg[1]*127;
			vel2=msg[2]*127;
			val1=msg[1];
			val2=msg[2];
			if ( ~volcaBoolean==1, {
				//~mdOut.control(5, 13, vel1); // IFVBass CutX
				//~mdOut.control(6, 13, vel1); // IFVKeys CutX
				//~vKeys.control(0, ~vcfCut, vel1/1.8);
				//~vBass.control(0, ~gateTime, vel1);
				~mdOut.control(7, 13, vel1); // IFSamp CutX
				~vMopho.control(~chMopho, 104, vel1); //Filter Key Amnt

				//~mdOut.control(5, 14, vel2); // IFVBass CutY
				//~mdOut.control(6, 14, vel2); // IFVKeys CutY
				//~vBass.control(0, ~cutOff, vel2);
				~vMopho.control(~chMopho, 86, vel2); //Env3 Amnt
				~mdOut.control(7, 14, vel2); // IFSamps CutY
				~tOSCAdrr.sendMsg('/cutMel2',msg[1], msg[2]);
			},
			{
				~tOSCAdrr.sendMsg('/cutMel2',msg[1], msg[2]);
			}
			);
		},
		'/cutMel2'
		);

		~susMelLedVal;
		~susMelMulFader.free;
		~susMelMulFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('/susMel', ~susMelLedVal=msg[1]);
			~susMulBass=msg[1];~susMulKeys=msg[1];~susMulSamp=msg[1];~susMulMopho=msg[1];
		},
		'/susMel'
		);

		~susDrumLedVal;
		~susDrumMulFader.free;
		~susDrumMulFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('/susDrum',~susDrumLedVal=val);
			~susMulKick=val+0.15;~susMulSnr=val+0.2;~susMulHat=val+0.15;
		},
		'/susDrum'
		);
		~chainDrumFader.free;
		~chainDrumFader= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			~tOSCAdrr.sendMsg('/chainDrum', msg[1]);
			~mdOut.control(2, 8, val);//~tOSCAdrr.sendMsg('chainKick', val);
			~mdOut.control(3, 8, val);//~tOSCAdrr.sendMsg('chainSnr', val);
			~mdOut.control(4, 8, val);//~tOSCAdrr.sendMsg('chainHat', val);
		},
		'/chainDrum'
		);
		~chainAllFader.free;
		~chainAllFader= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			~tOSCAdrr.sendMsg('/chainAll', msg[1]);
			~mdOut.control(5, 8, val);//~tOSCAdrr.sendMsg('chainBass', val);
			~mdOut.control(6, 8, val);//~tOSCAdrr.sendMsg('chainKeys', val);
			~mdOut.control(7, 8, val);//~tOSCAdrr.sendMsg('chainSamp', val);

		},
		'/chainAll'
		);

		~attMelFader.free;
		~attMelFader= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			~tOSCAdrr.sendMsg('/attMel', msg[1]);
			~mdOut.control(5, 5, val); ~tOSCAdrr.sendMsg('attBass', val);
			~mdOut.control(6, 5, val); ~tOSCAdrr.sendMsg('attKeys', val);
			~mdOut.control(7, 5, val); ~tOSCAdrr.sendMsg('attSamp', val);

		},
		'/attMel'
		);

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
		'/tmOne'
		);
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
		'/tmTwo'
		);
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
		'/tmRand'
		);
		~tmMulDrumBut.free;
		~tmMulDrumBut= OSCFunc({
			arg msg;
			~tmMulKick.source = msg[1];
			~tmMulSnr.source = msg[1];
			~tmMulHat.source = msg[1];

		},
		'/tmMulDrum'
		);
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
		'/killAbl'
		);
		~tapAblBut.free;
		~tapAblBut = OSCFunc({
			arg msg;

			if ( msg[1]==1, {
				Ableton.tap4;
			},{

			}
			);
		},
		'/tapAbl'
		);



	}
	*freeAll {



	}

}

/*
	*mutes{//----------MUTES
		~mtAllOn.free;
		~mtAllOn = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~tOSCAdrr.sendMsg('muteKick', 0);
				~mdOut.control(2, 0, 1*127); // VKick Mute
				~mdOut.control(3, 0, 1*127); // VSnr Mute
				~mdOut.control(4, 0, 1*127); // VHat Mute
				~mdOut.control(5, 0, 1*127); // VBass Mute
				~mdOut.control(6, 0, 1*127); // VKeys Mute
				~mdOut.control(7, 0, 1*127); // VSamp Mute

			});
		},
		'/mtAllOn'
		);
		~mtAllOff.free;
		~mtAllOff = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~tOSCAdrr.sendMsg('muteKick', 0);
				~mdOut.control(2, 0, 0*127); // VKick Mute
				~mdOut.control(3, 0, 0*127); // VSnr Mute
				~mdOut.control(4, 0, 0*127); // VHat Mute
				~mdOut.control(5, 0, 0*127); // VBass Mute
				~mdOut.control(6, 0, 0*127); // VKeys Mute
				~mdOut.control(7, 0, 0*127); // VSamp Mute

			});
		},
		'/mtAllOff'
		);
		~mtDrum.free;
		~mtDrum = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~tOSCAdrr.sendMsg('muteKick', 0);
				~mdOut.control(2, 0, 0*127); // VKick Mute
				~mdOut.control(3, 0, 0*127); // VSnr Mute
				~mdOut.control(4, 0, 0*127); // VHat Mute
				~mdOut.control(5, 0, 1*127); // VBass Mute
				~mdOut.control(6, 0, 1*127); // VKeys Mute
				~mdOut.control(7, 0, 1*127); // VSamp Mute

			});
		},
		'/mtDrum'
		);
		~mtMel.free;
		~mtMel = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~tOSCAdrr.sendMsg('muteKick', 0);
				~mdOut.control(2, 0, 1*127); // VKick Mute
				~mdOut.control(3, 0, 1*127); // VSnr Mute
				~mdOut.control(4, 0, 1*127); // VHat Mute
				~mdOut.control(5, 0, 0*127); // VBass Mute
				~mdOut.control(6, 0, 0*127); // VKeys Mute
				~mdOut.control(7, 0, 0*127); // VSamp Mute

			});
		},
		'/mtMel'
		);
		//Kick OFF
		~mtKkHtBsSp.free;
		~mtKkHtBsSp = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~tOSCAdrr.sendMsg('muteKick', 0);
				~mdOut.control(2, 0, 0*127); // VKick Mute
				~mdOut.control(3, 0, 1*127); // VSnr Mute
				~mdOut.control(4, 0, 0*127); // VHat Mute
				~mdOut.control(5, 0, 0*127); // VBass Mute
				~mdOut.control(6, 0, 1*127); // VKeys Mute
				~mdOut.control(7, 0, 0*127); // VSamp Mute

			});
		},
		'/mtKkHtBsSp'
		);

		~mtKkHtBs.free;
		~mtKkHtBs = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~tOSCAdrr.sendMsg('muteKick', 0);
				~mdOut.control(2, 0, 0*127); // VKick Mute
				~mdOut.control(3, 0, 1*127); // VSnr Mute
				~mdOut.control(4, 0, 0*127); // VHat Mute
				~mdOut.control(5, 0, 0*127); // VBass Mute
				~mdOut.control(6, 0, 1*127); // VKeys Mute
				~mdOut.control(7, 0, 1*127); // VSamp Mute

			});
		},
		'/mtKkHtBs'
		);

		~mtKkBsSp.free;
		~mtKkBsSp = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~tOSCAdrr.sendMsg('muteKick', 0);
				~mdOut.control(2, 0, 0*127); // VKick Mute
				~mdOut.control(3, 0, 1*127); // VSnr Mute
				~mdOut.control(4, 0, 1*127); // VHat Mute
				~mdOut.control(5, 0, 0*127); // VBass Mute
				~mdOut.control(6, 0, 1*127); // VKeys Mute
				~mdOut.control(7, 0, 0*127); // VSamp Mute

			});
		},
		'/mtKkBsSp'
		);

		~mtKkHtSp.free;
		~mtKkHtSp = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~tOSCAdrr.sendMsg('muteKick', 0);
				~mdOut.control(2, 0, 0*127); // VKick Mute
				~mdOut.control(3, 0, 1*127); // VSnr Mute
				~mdOut.control(4, 0, 0*127); // VHat Mute
				~mdOut.control(5, 0, 1*127); // VBass Mute
				~mdOut.control(6, 0, 1*127); // VKeys Mute
				~mdOut.control(7, 0, 0*127); // VSamp Mute

			});
		},
		'/mtKkHtSp'
		);
		~mtKkBs.free;
		~mtKkBs = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~tOSCAdrr.sendMsg('muteKick', 0);
				~mdOut.control(2, 0, 0*127); // VKick Mute
				~mdOut.control(3, 0, 1*127); // VSnr Mute
				~mdOut.control(4, 0, 1*127); // VHat Mute
				~mdOut.control(5, 0, 0*127); // VBass Mute
				~mdOut.control(6, 0, 1*127); // VKeys Mute
				~mdOut.control(7, 0, 1*127); // VSamp Mute

			});
		},
		'/mtKkBs'
		);
		//Kick ON
		~mtSnHtBsKy.free;
		~mtSnHtBsKy = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~tOSCAdrr.sendMsg('muteKick', 0);
				~mdOut.control(2, 0, 1*127); // VKick Mute
				~mdOut.control(3, 0, 0*127); // VSnr Mute
				~mdOut.control(4, 0, 0*127); // VHat Mute
				~mdOut.control(5, 0, 0*127); // VBass Mute
				~mdOut.control(6, 0, 0*127); // VKeys Mute
				~mdOut.control(7, 0, 1*127); // VSamp Mute

			});
		},
		'/mtSnHtBsKy'
		);

		~mtSnBsKy.free;
		~mtSnBsKy = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~tOSCAdrr.sendMsg('muteKick', 0);
				~mdOut.control(2, 0, 1*127); // VKick Mute
				~mdOut.control(3, 0, 0*127); // VSnr Mute
				~mdOut.control(4, 0, 1*127); // VHat Mute
				~mdOut.control(5, 0, 0*127); // VBass Mute
				~mdOut.control(6, 0, 0*127); // VKeys Mute
				~mdOut.control(7, 0, 1*127); // VSamp Mute

			});
		},
		'/mtSnBsKy'
		);

		~mtSnBs.free;
		~mtSnBs = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~tOSCAdrr.sendMsg('muteKick', 0);
				~mdOut.control(2, 0, 1*127); // VKick Mute
				~mdOut.control(3, 0, 0*127); // VSnr Mute
				~mdOut.control(4, 0, 1*127); // VHat Mute
				~mdOut.control(5, 0, 0*127); // VBass Mute
				~mdOut.control(6, 0, 1*127); // VKeys Mute
				~mdOut.control(7, 0, 1*127); // VSamp Mute

			});
		},
		'/mtSnBs'
		);

		~mtSnHtKy.free;
		~mtSnHtKy = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~tOSCAdrr.sendMsg('muteKick', 0);
				~mdOut.control(2, 0, 1*127); // VKick Mute
				~mdOut.control(3, 0, 0*127); // VSnr Mute
				~mdOut.control(4, 0, 0*127); // VHat Mute
				~mdOut.control(5, 0, 1*127); // VBass Mute
				~mdOut.control(6, 0, 0*127); // VKeys Mute
				~mdOut.control(7, 0, 1*127); // VSamp Mute

			});
		},
		'/mtSnHtKy'
		);
		~mtHtKy.free;
		~mtHtKy = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~tOSCAdrr.sendMsg('muteKick', 0);
				~mdOut.control(2, 0, 1*127); // VKick Mute
				~mdOut.control(3, 0, 0*127); // VSnr Mute
				~mdOut.control(4, 0, 0*127); // VHat Mute
				~mdOut.control(5, 0, 1*127); // VBass Mute
				~mdOut.control(6, 0, 0*127); // VKeys Mute
				~mdOut.control(7, 0, 1*127); // VSamp Mute

			});
		},
		'/mtHtKy'
		);


	}
	*/