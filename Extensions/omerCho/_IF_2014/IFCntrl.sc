IFCntrl {

	*loadAll {
		this.main;
		this.mutes;
		this.parts;
	}




	*main {

		~togMain.free;
		~togMain = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"IF Main PLAY".postln;
				//~mdClock.start;//TempoClock to IAC MIDI

				//~mainSet_00.fork(quant:0);
				IFRoot.play;
				~tOSCAdrr.sendMsg('/1/toggleMain', 1);


			});

			if ( msg[1]==0, {
				"IF Main STOP".postln;
				IFRoot.stop;
				//~mdClock.stop;//TempoClock to IAC MIDI
				//Ableton.stop;
				~tOSCAdrr.sendMsg('/1/toggleMain', 0);


			});
			},
			'/1/toggleMain'
		);

		~tempoFader.free;
		~tempoFader= OSCFunc({
			arg msg,val;
			val=msg[1];
			//~vBeatsLate=val/(1/100);
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



		~cutDrumXY.free;
		~cutDrumXY= OSCFunc({
			arg msg,vel1, vel2;
			vel1=msg[1]*127;
			vel2=msg[2]*127;

			~tOSCAdrr.sendMsg('/cutDrum',msg[1], msg[2]);
			~mdOut.control(10, 20, vel1);
			~mdOut.control(10, 21, vel2);

			},
			'/cutDrum'
		);

		~cutAllXY.free;
		~cutAllXY= OSCFunc({
			arg msg,vel1, vel2;
			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~mdOut.control(5, 13, vel1); // IFVBass CutX
			~mdOut.control(6, 13, vel1); // IFVKeys CutX
			~mdOut.control(7, 13, vel1); // IFSamp CutX
			~vKeys.control(0, ~vcfCut, vel1/1.8);
			~vBass.control(0, ~gateTime, vel1);

			~mdOut.control(5, 14, vel2); // IFVBass CutY
			~mdOut.control(6, 14, vel2); // IFVKeys CutY
			~mdOut.control(7, 14, vel2); // IFSamps CutY
			~vBass.control(0, ~cutOff, vel2);
			~tOSCAdrr.sendMsg('/cutAll',msg[1], msg[2]);
			},
			'/cutAll'
		);


		~harmXY.free;
		~harmXY= OSCFunc({
			arg msg;

			//~harmKick=msg[1];
			~harmSnr=msg[1];~harmHat=msg[1]+1*1.5;
			~harmBass=msg[2];~harmKeys=msg[2];~harmSamp=msg[2]; ~hrmMulExt=msg[1];

			~tOSCAdrr.sendMsg('harm0', 1);
			},
			'/harmXY/1'
		);

		~harm_0.free;
		~harm_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Harmonic 0".postln;
				//~harmKick=0;
				~harmSnr=0;~harmHat=0;
				~harmBass=0;~harmKeys=0;~harmSamp=0; ~hrmMulExt=0;

				~strKick.source     =  Pshuf([1], inf);
				~strSnr.source     =  Pshuf([1], inf);
				~strHat.source     =  Pshuf([1], inf);
				~strBass.source    =  Pshuf([1], inf);
				~strKeys.source    =  Pshuf([1], inf);
				~strSamp.source    =  Pshuf([1], inf);
				~tOSCAdrr.sendMsg('harm0', 0);
				~tOSCAdrr.sendMsg('shufHarm', 0);
			});
			},
			'/harm0'
		);

		~shufHarmBut.free;
		~shufHarmBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Harmonics Shuffle".postln;
				~strKick.source  =  Pshuf([0.5,0.8,1.2,1.7, 1.1,2.8,1.8,0.4], inf);
				~strSnr.source   =  Pshuf([1.1,0.4,2.5,1.2, 1.1,3.0,1.8,0.4], inf);
				~strHat.source   =  Pshuf([0.1,0.4,2.2,1.2, 1.1,3.2,1.8,0.4], inf);
				~strBass.source  =  Pshuf([0.5,0.8,2.3,1.2, 1.1,1.8,1.8,0.4], inf);
				~strKeys.source  =  Pshuf([0.5,0.4,2.0,1.2, 1.1,2.6,1.8,0.4], inf);
				~strSamp.source  =  Pshuf([1.0,0.4,2.0,1.2, 1.1,3.4,1.8,0.4], inf);

				~tOSCAdrr.sendMsg('shufHarm', 1);
				},{
					~tOSCAdrr.sendMsg('shufHarm', 1);
				}
			);
			},
			'/shufHarm'
		);

		~susMelMulFader.free;
		~susMelMulFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('/susMel', msg[1]);
			~susMulBass=msg[1];~susMulKeys=msg[1];~susMulSamp=msg[1];
			},
			'/susMel'
		);

		~susDrumMulFader.free;
		~susDrumMulFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('/susDrum', msg[1]);
			~susMulKick=msg[1];~susMulSnr=msg[1];~susMulHat=msg[1];

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

	*parts {//----- Parts

		~part_0.free;
		~part_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part0".postln;

				~mainSet_00.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'part0');
			});
			},
			'/part0'
		);


		~part_1.free;
		~part_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part1".postln;

				~mainSet_01.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt01');
			});
			},
			'/part1'
		);

		~part_2.free;
		~part_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part2".postln;

				~mainSet_02.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt02');
			});
			},
			'/part2'
		);

		~part_3.free;
		~part_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part3".postln;

				~mainSet_03.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt03');
			});
			},
			'/part3'
		);

		~part_4.free;
		~part_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part4".postln;

				~mainSet_04.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt04');
			});
			},
			'/part4'
		);

		~part_5.free;
		~part_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part5".postln;

				~mainSet_05.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt05');
			});
			},
			'/part5'
		);

		~part_6.free;
		~part_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part6".postln;

				~mainSet_06.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt06');
			});
			},
			'/part6'
		);

		~part_7.free;
		~part_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part7".postln;

				~mainSet_07.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt07');
			});
			},
			'/part7'
		);

	}

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

	*freeAll {



	}

}