IFTrack03 {
	*loadAtStart{
		~trackCase=3;
		IFRoot.set00;
		//this.setGlb01;
		IFTrack03.setGlb01;
		IFTrack03.apcParts;
		~shiftPartsBut.free;
		~shiftPartsBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack03.sixteen;
				},{
					IFSixteen.defaults;
			});
			},
			'/shiftParts'
		);

		//SampInstruments
		~mdOut.control(0, 71, 0); //Track 01
		~mdOut.control(0, 72, 0); //Track 02
		~mdOut.control(0, 73, 127); //Track 03
		~mdOut.control(0, 74, 0); //Track 04
		~mdOut.control(0, 75, 0); //Track 05
		~mdOut.control(0, 76, 0); //Track 06
		~mdOut.control(0, 77, 0); //Track 07
		~mdOut.control(0, 78, 0); //Track 08
		//ExtInstruments
		~mdOut.control(0, 81, 0); //Track 01
		~mdOut.control(0, 82, 0); //Track 02
		~mdOut.control(0, 83, 127); //Track 03
		~mdOut.control(0, 84, 0); //Track 04
		~mdOut.control(0, 85, 0); //Track 05
		~mdOut.control(0, 86, 0); //Track 06
		~mdOut.control(0, 87, 0); //Track 07
		~mdOut.control(0, 88, 0); //Track 08


		~shufTransBut.free;
		~countShuf=0;
		~tOSCAdrr.sendMsg('shufTransLabel', 'OFF');
		~tOSCAdrr.sendMsg('shufTrans', 0);
		~shufTransBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countShuf = ~countShuf + 1;

				~countShuf.switch(
					0,{~tOSCAdrr.sendMsg('shufTransLabel', 'OFF');
						~tOSCAdrr.sendMsg('shufTrans', 0);
					},
					1, {

						"Modal Transpose Shuffle".postln;
						~tOSCAdrr.sendMsg('shufTransLabel', 'ON');
						~tOSCAdrr.sendMsg('shufTrans', 1);
						~transShufBass.source  = Pshuf([(2),0,4,(7), (-2),0,12,(-1)], inf);
						~transShufKeys.source  = Pshuf([(4),0,2,(7), (2),4,6,(0)], inf);
						~transShufSamp.source  = Pshuf([(5),2,7,(-4), (-1),3,5,(-6)], inf);
					},
					2,{
						~tOSCAdrr.sendMsg('shufTransLabel', 'OFF');
						~tOSCAdrr.sendMsg('shufTrans', 0);
						~transShufBass.source  = Pshuf([0], inf);
						~transShufKeys.source  = Pshuf([0], inf);
						~transShufSamp.source  = Pshuf([0], inf);
						~countShuf=0;
					}
				)
				},{


				}
			);
			},
			'/shufTrans'
		);
	}

	*setGlb01{
		"Preset: Trk03".postln;
		~tOSCAdrr.sendMsg('presetLabel','Prst Trk02');
		"TRACK 3".postln;
		~tOSCAdrr.sendMsg('trackLabel','TRACK 3');
		~scl1= Scale.chromatic;
		~scl2= Scale.phrygian;
		~tOSCAdrr.sendMsg('scaleLabel', 'Phrygian');

		~tmp1=126;
		~tOSCAdrr.sendMsg('tempoLabel', ~tmp1);
		~tOSCAdrr.sendMsg('tempoFader', ~tmp1);
		~nt=(0);

		"Duration Pattern: Straight".postln;
		~tOSCAdrr.sendMsg('durLabel', 'Straight');
		~dur.source = Pseq([2], inf)*~durMulP.next;
		~tOSCAdrr.sendMsg('dur1', '1');
		~tOSCAdrr.sendMsg('dur2', '0');
		~tOSCAdrr.sendMsg('dur3', '0');
		~tOSCAdrr.sendMsg('dur4', '0');
		~tOSCAdrr.sendMsg('durAks1', '0');
		~tOSCAdrr.sendMsg('durShuf1', '0');
		~tOSCAdrr.sendMsg('durRand1', '0');

		"Duration Mul: 1/2".postln;
		~tOSCAdrr.sendMsg('durMulLabel', '1/2');
		~durMul.source = Pseq([1/2], inf);
		~tOSCAdrr.sendMsg('durMul1_4', '0');
		~tOSCAdrr.sendMsg('durMul1_2', '1');
		~tOSCAdrr.sendMsg('durMul1', '0');

		"Global Set".postln;
		~local.sendMsg('harm0',1);

		~local.sendMsg('cutAll',0.4, 0.55);
		~local.sendMsg('cutDrum',0.0, 0.0);
		~local.sendMsg('allMainSends',0.0, 0.0);
		~local.sendMsg('melSends',0.4, 0.0);
		~local.sendMsg('drumSends',0.0, 0.0);
		~local.sendMsg('susMel',0.2);
		~local.sendMsg('susDrum',0.2);
		~local.sendMsg('noteFader',0.5);//SnrXpose
		~local.sendMsg('fxFader',0.0);
		~local.sendMsg('AllMasterFXxy1',0.2,0.2);



		"Kick Set".postln;
		~local.sendMsg('volKick', 0.99);
		~local.sendMsg('sendKick', 0.0, 0.0);
		~local.sendMsg('attKick', 0.0);
		~local.sendMsg('susKick', 0.5);
		~local.sendMsg('decKick', 0.7);
		~local.sendMsg('chainKick', 0.0);

		"Snr Set".postln;
		~local.sendMsg('volSnr', 0.99);
		~local.sendMsg('sendSnr', 0.0, 0.0);
		~local.sendMsg('attSnr', 0.0);
		~local.sendMsg('susSnr', 0.5);
		~local.sendMsg('decSnr', 0.5);
		~local.sendMsg('chainSnr', 0.05);

		"Hat Set".postln;
		~local.sendMsg('volHat', 0.95);
		~local.sendMsg('sendHat', 0.0, 0.0);
		~local.sendMsg('attHat', 0.0);
		~local.sendMsg('susHat', 0.0);
		~local.sendMsg('decHat', 0.00);
		~local.sendMsg('chainHat', 0.3);

		"Bass Set".postln;
		~local.sendMsg('volBass', 0.95);
		~local.sendMsg('sendBass', 0.0, 0.0);
		~local.sendMsg('attBass', 0.5);
		~local.sendMsg('susBass', 0.5);
		~local.sendMsg('decBass', 0.2);
		~local.sendMsg('chainBass', 0.0);
		~local.sendMsg('lfoMulBass1',0.30);
		~local.sendMsg('lfoMulBass2',0.00);

		"Keys Set".postln;
		~local.sendMsg('volKeys', 0.95);
		~local.sendMsg('sendKeys', 0.3, 0.1);
		~local.sendMsg('attKeys', 0.3);
		~local.sendMsg('susKeys', 0.3);
		~local.sendMsg('decKeys', 0.4);
		~local.sendMsg('chainKeys', 0.0);
		~local.sendMsg('lfoMulKeys1',0.3);
		~local.sendMsg('lfoMulKeys2',0.1);

		"Samp Set".postln;
		~local.sendMsg('volSamp', 0.9);
		~local.sendMsg('sendSamp', 0.6, 0.2);
		~local.sendMsg('attSamp', 0.05);
		~local.sendMsg('susSamp', 0.05);
		~local.sendMsg('decSamp', 0.3);
		~local.sendMsg('chainSamp', 0.7);
		~local.sendMsg('lfoMulSamp1',0.3);
		~local.sendMsg('lfoMulSamp2',0.4);
		~local.sendMsg('octSampZero',1);

		"Ext Set".postln;
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);
	}//track 03 End

	*part01{//////                                      - 1 -

		"T3part01".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T3prt01');
		IFSeqKick.stGrpSet    (1,0,1,0, 1,0,1,0,  0,0,1,0, 0,1,1,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 4,3,3,3,  3,3,3,3, 3,4,3,3);
		IFSeqNtKick.stGrpSet  (1,0,4,0, 3,1,4,0,  0,1,0,0, 0,3,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (0,1,0,1, 1,0,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSnr.stGrpSet (2,4,3,1, 2,1,4,1,  1,5,4,1, 4,1,2,1);
		IFSeqNtSnr.stGrpSet  (0,5,0,3, 3,0,5,0,  1,3,3,0, 3,0,1,0);
		IFSeqVelSnr.stGrpSet (2,3,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (2,2,1,0, 3,0,0,0,  2,0,0,0, 2,0,5,0);
		IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (0,3,0,0, 0,3,0,0,  0,3,0,0, 0,3,5,0);
		IFSeqNtHat.stGrpSet  (7,0,0,0, 0,0,0,0,  3,0,0,0, 4,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,0,0,0, 1,0,0,1,  1,0,0,0, 1,0,0,0);
		IFSeqOctBass.stGrpSet (4,3,3,3, 4,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 5,0,0,0,  0,0,0,0, 5,0,0,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([30,9,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,10,50], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,0, 0,1,1,0,  0,1,0,0, 1,0,0,0);
		IFSeqOctKeys.stGrpSet (3,3,4,3, 3,4,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (5,0,5,0, 0,2,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([20,20,120,20], inf);
		~lfoCtKeys.source =  Pseq([10,10,50,110], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (0,1,1,0, 0,1,0,0,  1,1,0,1, 0,1,0,0);
		IFSeqOctSamp.stGrpSet (3,4,4,3, 3,4,3,3,  3,4,3,3, 3,4,3,3);
		IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,2,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelSamp.stGrpSet (0,0,3,0, 3,1,3,0,  3,2,3,0, 3,3,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([90,1,17,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([60,10,80,9,60,10,80,99], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+0,~nt+11,~nt+3,~nt+0,~nt+22,~nt+0,~nt+16,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*2, inf);
		~tmRes1.source    =  Pseq([1], inf);
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pxrand([1,124,0,50,120], inf);
		~dur1Mast.source=Pxrand([(1/2)*2], inf);
	}//////                                      - 1 -

	*part02{//////                                      - 2 -

		"T3part02".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T3prt02');

		IFSeqKick.stGrpSet    (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,1,1,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,4,3,3);
		IFSeqNtKick.stGrpSet  (0,0,4,0, 0,1,4,0,  0,1,0,0, 0,3,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (0,1,0,1, 1,0,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSnr.stGrpSet (2,4,3,1, 2,1,4,1,  1,5,4,1, 4,1,2,1);
		IFSeqNtSnr.stGrpSet  (0,5,0,3, 3,0,5,0,  1,3,3,0, 3,0,1,0);
		IFSeqVelSnr.stGrpSet (2,3,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (2,2,1,0, 3,0,0,0,  2,0,0,0, 2,0,5,0);
		IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (0,3,0,0, 0,3,0,0,  0,3,0,0, 0,3,5,0);
		IFSeqNtHat.stGrpSet  (7,0,0,0, 0,0,0,0,  3,0,0,0, 4,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,0,0,0, 1,0,0,1,  1,0,0,0, 1,0,0,0);
		IFSeqOctBass.stGrpSet (4,3,3,3, 4,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 5,0,0,0,  0,0,0,0, 5,0,0,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([30,9,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,10,50], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,0, 0,1,1,0,  0,1,0,0, 1,0,0,0);
		IFSeqOctKeys.stGrpSet (3,3,4,3, 3,4,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (5,0,5,0, 0,2,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([90,20,120,20], inf);
		~lfoCtKeys.source =  Pseq([90,10,50,110], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (0,1,1,0, 0,1,0,0,  1,1,0,1, 0,1,0,0);
		IFSeqOctSamp.stGrpSet (3,4,4,3, 3,4,3,3,  3,4,3,3, 3,4,3,3);
		IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,2,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelSamp.stGrpSet (0,0,3,0, 3,1,3,0,  3,2,3,0, 3,3,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([90,1,17,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([60,10,80,9,60,10,80,99], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+0,~nt+11,~nt+3,~nt+0,~nt+22,~nt+0,~nt+16,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*2, inf);
		~tmRes1.source    =  Pseq([1], inf);
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pxrand([1,124,0,50,120], inf);
		~dur1Mast.source=Pxrand([(1/2)*2], inf);
	}//////                                      - 2 -

	*part03{
		"T3part03".postln; ~tOSCAdrr.sendMsg('partLabel', 'T3prt03');
		IFSeqKick.stGrpSet    (1,0,1,0, 1,0,1,1,  1,0,1,0, 1,1,1,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,4,  3,3,3,3, 3,4,3,3);
		IFSeqNtKick.stGrpSet  (0,0,4,0, 0,1,4,6,  0,1,0,0, 0,3,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (0,1,1,1, 1,0,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSnr.stGrpSet (2,4,3,1, 2,1,4,1,  1,5,4,1, 4,1,2,1);
		IFSeqNtSnr.stGrpSet  (0,5,0,3, 3,0,5,0,  1,3,3,0, 3,0,1,0);
		IFSeqVelSnr.stGrpSet (2,3,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (2,2,1,0, 3,0,0,0,  2,0,0,0, 2,0,5,0);
		IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (0,3,0,0, 0,3,0,0,  0,3,0,0, 0,3,5,0);
		IFSeqNtHat.stGrpSet  (7,0,0,0, 0,0,0,0,  3,0,0,0, 4,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (2,1,1,1, 2,1,1,1,  2,1,1,1, 2,1,2,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,0,0,0, 1,0,1,1,  1,0,1,0, 1,1,0,0);
		IFSeqOctBass.stGrpSet (4,3,3,3, 4,3,3,3,  3,3,4,3, 3,4,3,3);
		IFSeqNtBass.stGrpSet  (5,0,0,0, 0,0,0,0,  5,0,0,0, 5,0,0,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,2,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([30,9,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,10,50], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,0, 0,1,1,0,  0,1,0,0, 1,0,0,0);
		IFSeqOctKeys.stGrpSet (3,3,4,3, 3,4,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (5,0,5,0, 0,2,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([90,20,120,20], inf);
		~lfoCtKeys.source =  Pseq([90,10,50,110], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (0,1,1,0, 0,1,0,0,  1,1,0,1, 0,1,0,0);
		IFSeqOctSamp.stGrpSet (3,4,4,3, 3,4,3,3,  3,4,3,3, 3,4,3,3);
		IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,2,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelSamp.stGrpSet (0,0,3,0, 3,1,3,0,  3,2,3,0, 3,3,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([90,1,17,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([60,10,80,9,60,10,80,99], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+0,~nt+11,~nt+3,~nt+0,~nt+22,~nt+0,~nt+16,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*2, inf);
		~tmRes1.source    =  Pseq([1], inf);
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pxrand([1,124,0,50,120], inf);
		~dur1Mast.source=Pxrand([(1/2)*2], inf);
	}//////                                      - 3 -

	*part04{
		"partT304".postln; ~tOSCAdrr.sendMsg('partLabel', 'T3prt04');
		IFSeqKick.stGrpSet    (1,1,1,0, 1,0,1,1,  1,0,1,0, 1,1,1,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,4,  3,3,3,3, 3,4,3,3);
		IFSeqNtKick.stGrpSet  (0,1,0,0, 0,1,0,6,  0,1,0,0, 0,3,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (0,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSnr.stGrpSet (2,4,3,1, 2,3,4,1,  1,5,4,1, 4,1,2,1);
		IFSeqNtSnr.stGrpSet  (0,5,0,3, 3,4,5,0,  1,3,3,0, 3,0,1,0);
		IFSeqVelSnr.stGrpSet (2,3,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (2,2,1,0, 3,0,0,0,  2,0,0,0, 2,0,5,0);
		IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (0,3,0,0, 0,3,0,0,  0,3,0,0, 0,3,5,0);
		IFSeqNtHat.stGrpSet  (7,0,0,0, 0,0,0,0,  3,0,0,0, 4,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (2,1,1,1, 2,1,1,1,  2,1,1,1, 2,1,2,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,0,0,0, 1,0,1,1,  1,0,1,0, 1,1,0,0);
		IFSeqOctBass.stGrpSet (4,3,3,3, 4,3,3,3,  3,3,4,3, 3,4,3,3);
		IFSeqNtBass.stGrpSet  (5,0,0,0, 0,0,0,0,  5,0,0,0, 5,0,0,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,2,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([30,9,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,10,50], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,0, 0,1,1,0,  0,1,0,0, 1,0,0,0);
		IFSeqOctKeys.stGrpSet (3,3,4,3, 3,4,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (5,0,5,0, 0,2,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([90,20,120,20], inf);
		~lfoCtKeys.source =  Pseq([90,10,50,110], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (0,1,1,0, 0,1,0,0,  1,1,0,1, 0,1,0,0);
		IFSeqOctSamp.stGrpSet (3,4,4,3, 3,4,3,3,  3,4,3,3, 3,4,3,3);
		IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,2,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelSamp.stGrpSet (0,0,3,0, 3,1,3,0,  3,2,3,0, 3,3,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([90,1,17,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([60,10,80,9,60,10,80,99], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+0,~nt+11,~nt+3,~nt+0,~nt+22,~nt+0,~nt+16,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*2, inf);
		~tmRes1.source    =  Pseq([1], inf);
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pxrand([1,124,0,50,120], inf);
		~dur1Mast.source=Pxrand([(1/2)*2], inf);
	}//////                                      - 4 -

	*part05{
		"T2part05".postln; ~tOSCAdrr.sendMsg('partLabel', 'T2prt05');
		IFSeqKick.stGrpSet    (1,0,1,1, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKick.stGrpSet  (0,0,1,0, 0,1,0,0,  0,1,0,0, 0,4,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (0,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSnr.stGrpSet (2,1,3,1, 2,1,1,1,  1,1,3,1, 2,1,2,1);
		IFSeqNtSnr.stGrpSet  (0,1,6,3, 3,6,0,0,  1,3,1,5, 3,0,1,0);
		IFSeqVelSnr.stGrpSet (2,3,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (0,1,0,0, 0,1,0,0,  0,1,0,0, 0,1,1,0);
		IFSeqNtHat.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,0, 1,0,1,1,  1,1,1,0, 1,0,1,0);
		IFSeqOctBass.stGrpSet (3,3,3,3, 4,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 5,0,0,0,  0,0,0,0, 5,0,5,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([30,90,70,18, 10,90,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,90,100,90], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,0, 1,1,1,0,  0,1,1,0, 1,1,0,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,4,3,3,  3,4,3,3, 4,3,3,3);
		IFSeqNtKeys.stGrpSet  (5,0,5,0, 0,2,0,0,  0,4,0,0, 5,0,0,5);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([20,40,40,10], inf);
		~lfoCtKeys.source =  Pseq([100,20,120,90], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (1,1,1,0, 0,1,0,0,  0,1,0,1, 0,1,0,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,2,0,0,  0,0,0,2, 0,0,0,0);
		IFSeqVelSamp.stGrpSet (0,0,3,0, 3,1,3,0,  3,2,3,0, 3,3,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([0,1,7,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([6,10,80,99,6,110,80,99], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+10,~nt+11,~nt+3,~nt+0,~nt+22,~nt+0,~nt+16,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*2, inf);
		~tmRes1.source    =  Pseq([1], inf);
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pxrand([1,124,0,50,120], inf);
		~dur1Mast.source=Pxrand([(1/2)*2], inf);
	}//////                                      - 5 -

	*part06{
		"part06".postln; ~tOSCAdrr.sendMsg('partLabel', 'prt06');
		IFSeqKick.stGrpSet    (1,0,0,1, 1,1,0,0,  1,0,0,0, 1,0,1,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKick.stGrpSet  (0,0,1,0, 0,1,0,0,  0,1,0,0, 0,4,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (0,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSnr.stGrpSet (2,1,3,1, 2,1,1,1,  1,1,3,1, 2,1,2,1);
		IFSeqNtSnr.stGrpSet  (0,1,6,3, 3,6,0,0,  1,3,1,5, 3,0,1,0);
		IFSeqVelSnr.stGrpSet (2,3,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (0,1,0,0, 0,1,0,0,  0,1,0,0, 0,1,1,0);
		IFSeqNtHat.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (2,1,1,1, 2,1,1,1,  2,1,1,1, 2,1,1,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,0, 1,0,1,1,  1,1,1,0, 1,0,1,0);
		IFSeqOctBass.stGrpSet (3,3,3,3, 4,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 5,0,0,0,  0,0,0,0, 5,0,5,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([30,90,70,18, 10,90,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,90,100,90], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,0, 1,1,1,0,  0,1,1,0, 1,1,0,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,4,3,3,  3,4,3,3, 4,3,3,3);
		IFSeqNtKeys.stGrpSet  (5,0,5,0, 0,2,0,0,  0,4,0,0, 5,0,0,5);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([20,40,40,10], inf);
		~lfoCtKeys.source =  Pseq([100,20,120,90], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (1,1,1,0, 0,1,0,0,  0,1,0,1, 0,1,0,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,4,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,2,0,0,  0,0,0,2, 0,0,0,0);
		IFSeqVelSamp.stGrpSet (0,0,3,0, 3,1,3,0,  3,2,3,0, 3,3,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([0,1,87,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([6,10,80,99,6,110,80,99], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+10,~nt+11,~nt+3,~nt+0,~nt+22,~nt+0,~nt+16,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*2, inf);
		~tmRes1.source    =  Pseq([1], inf);
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pxrand([1,124,0,50,120], inf);
		~dur1Mast.source=Pxrand([(1/2)*2], inf);
	}//////                                      - 6 -

	*part07{
		"T2part07".postln; ~tOSCAdrr.sendMsg('partLabel', 'T2prt07');
		IFSeqKick.stGrpSet    (1,1,1,1, 1,1,1,0,  1,0,1,0, 1,0,1,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKick.stGrpSet  (0,0,1,0, 0,1,0,0,  0,1,0,0, 0,4,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (0,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSnr.stGrpSet (2,1,3,1, 2,1,1,1,  1,1,3,1, 2,1,2,1);
		IFSeqNtSnr.stGrpSet  (0,1,6,3, 3,6,0,0,  1,3,1,5, 3,0,1,0);
		IFSeqVelSnr.stGrpSet (2,3,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSnr.stGrpSet  (1,1,2,1, 1,2,1,1,  1,2,1,1, 1,2,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (0,1,0,0, 0,1,0,0,  0,1,0,0, 0,1,1,0);
		IFSeqNtHat.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (2,1,2,1, 2,1,2,1,  2,1,2,1, 2,1,2,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,0, 1,1,1,1,  1,1,1,0, 1,1,1,0);
		IFSeqOctBass.stGrpSet (3,3,3,3, 4,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 5,0,0,0,  0,0,0,0, 5,0,5,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,2,1,1, 1,1,1,1,  1,2,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([90,90,70,18, 10,90,60,20], inf);
		~lfo2Bass.source  =  Pseq([110,20,30,50, 0,90,100,90], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,0, 1,1,1,0,  0,1,1,0, 1,1,0,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,4,3,3,  3,4,3,3, 4,3,3,3);
		IFSeqNtKeys.stGrpSet  (5,0,5,0, 0,2,0,0,  0,4,0,0, 5,0,0,5);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([20,40,40,10], inf);
		~lfoCtKeys.source =  Pseq([100,20,120,90], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (1,1,1,0, 0,1,0,0,  0,1,0,1, 0,1,0,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,4,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,2,0,0,  0,0,0,2, 0,0,0,0);
		IFSeqVelSamp.stGrpSet (0,0,3,0, 3,1,3,0,  3,2,3,0, 3,3,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([0,1,87,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([6,10,80,99,6,110,80,99], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+10,~nt+11,~nt+3,~nt+0,~nt+22,~nt+0,~nt+16,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*2, inf);
		~tmRes1.source    =  Pseq([1], inf);
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pxrand([1,124,0,50,120], inf);
		~dur1Mast.source=Pxrand([(1/2)*2], inf);
	}//////                                      - 7 -

	*part08{
		"T2part08".postln; ~tOSCAdrr.sendMsg('partLabel', 'T2prt08');
		IFSeqKick.stGrpSet    (1,1,1,1, 1,1,1,0,  1,0,1,0, 1,0,1,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKick.stGrpSet  (0,0,1,0, 0,1,0,0,  0,1,0,0, 0,4,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (0,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSnr.stGrpSet (2,1,3,1, 2,1,1,1,  1,1,3,1, 2,1,2,1);
		IFSeqNtSnr.stGrpSet  (0,1,6,3, 3,6,0,0,  1,3,1,5, 3,0,1,0);
		IFSeqVelSnr.stGrpSet (2,3,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSnr.stGrpSet  (1,1,2,1, 1,2,1,1,  1,2,1,1, 1,2,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (0,1,0,0, 0,1,0,0,  0,1,0,0, 0,1,1,0);
		IFSeqNtHat.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (2,1,2,1, 2,1,2,1,  2,1,2,1, 2,1,2,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,0, 1,1,1,1,  1,1,1,0, 1,1,1,0);
		IFSeqOctBass.stGrpSet (3,3,3,3, 4,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 5,0,0,0,  0,0,0,0, 5,0,5,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,2,1,1, 1,1,1,1,  1,2,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([90,90,70,18, 10,90,60,20], inf);
		~lfo2Bass.source  =  Pseq([110,20,30,50, 0,90,100,90], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,0, 1,1,1,0,  0,1,1,0, 1,1,0,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,4,3,3,  3,4,3,3, 4,3,3,3);
		IFSeqNtKeys.stGrpSet  (5,0,5,0, 0,2,0,0,  0,4,0,0, 5,0,0,5);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([20,40,40,10], inf);
		~lfoCtKeys.source =  Pseq([100,20,120,90], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (1,1,1,0, 0,1,0,0,  0,1,0,1, 0,1,0,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,4,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,2,0,0,  0,0,0,2, 0,0,0,0);
		IFSeqVelSamp.stGrpSet (0,0,3,0, 3,1,3,0,  3,2,3,0, 3,3,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([0,1,87,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([6,10,80,99,6,110,80,99], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+10,~nt+11,~nt+3,~nt+0,~nt+22,~nt+0,~nt+16,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*2, inf);
		~tmRes1.source    =  Pseq([1], inf);
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pxrand([1,124,0,50,120], inf);
		~dur1Mast.source=Pxrand([(1/2)*2], inf);

	}//////                                      - 8 -

	*sixteen {//Parts 1-8 //Presets 9-16
		~seqStepBut01.free;
		~seqStepBut01 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack03.part01;
			});
			},
			'/seqStep01'
		);

		~seqStepBut02.free;
		~seqStepBut02 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack03.part02;
			});
			},
			'/seqStep02'
		);

		~seqStepBut03.free;
		~seqStepBut03 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack03.part03;
			});
			},
			'/seqStep03'
		);

		~seqStepBut04.free;
		~seqStepBut04 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack03.part04;
			});
			},
			'/seqStep04'
		);
		~seqStepBut05.free;
		~seqStepBut05 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack03.part05;
			});
			},
			'/seqStep05'
		);
		~seqStepBut06.free;
		~seqStepBut06 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack03.part06;
			});
			},
			'/seqStep06'
		);
		~seqStepBut07.free;
		~seqStepBut07 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack03.part07;
			});
			},
			'/seqStep07'
		);
		~seqStepBut08.free;
		~seqStepBut08 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack03.part08;
			});
			},
			'/seqStep08'
		);
//----------------------------------------------Presets
		~seqStepBut09.free;
		~seqStepBut09 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"prst00".postln;
				IFPresets.prst00;
			});
			},
			'/seqStep09'
		);
		~seqStepBut10.free;
		~seqStepBut10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"prst02".postln;
				IFPresets.prst01;
			});
			},
			'/seqStep10'
		);
		~seqStepBut11.free;
		~seqStepBut11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"prst03".postln;
				IFPresets.prst02;
			});
			},
			'/seqStep11'
		);
		~seqStepBut12.free;
		~seqStepBut12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"prst04".postln;
				IFPresets.prst03;
			});
			},
			'/seqStep12'
		);
		~seqStepBut13.free;
		~seqStepBut13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"prst01".postln;
				IFPresets.prst04;
			});
			},
			'/seqStep13'
		);
		~seqStepBut14.free;
		~seqStepBut14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"prst05".postln;
				IFPresets.prst05;
			});
			},
			'/seqStep14'
		);
		~seqStepBut15.free;
		~seqStepBut15 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"prst06".postln;
				IFPresets.prst06;
			});
			},
			'/seqStep15'
		);

		~seqStepBut16.free;
		~seqStepBut16 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"prst07".postln;
				IFPresets.prst07;
			});
			},
			'/seqStep16'
		);

	}//sixteen

	*apcParts {//Parts 1-8 //Presets 9-16

		~apc40.noteOn(0, 51, 0); //But 1
		~apc40.noteOn(1, 51, 1); //But 2
		~apc40.noteOn(2, 51, 0); //But 3
		~apc40.noteOn(3, 51, 0); //But 4
		~apc40.noteOn(4, 51, 0); //But 5
		~apc40.noteOn(5, 51, 0); //But 6
		~apc40.noteOn(6, 51, 0); //But 7
		~apc40.noteOn(7, 51, 0); //But 8





		~apc_TS01.free;
		~apc_TS01=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack03.part01;
			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS02.free;
		~apc_TS02=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack03.part02;
			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS03.free;
		~apc_TS03=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack03.part03;
			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS04.free;
		~apc_TS04=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack03.part04;
			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS05.free;
		~apc_TS05=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack03.part05;
			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS06.free;
		~apc_TS06=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack03.part06;
			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS07.free;
		~apc_TS07=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack03.part07;
			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS08.free;
		~apc_TS08=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack03.part08;
			});
		},srcID:~apc40InID, chan:0, noteNum:51);


	}//apcParts
}