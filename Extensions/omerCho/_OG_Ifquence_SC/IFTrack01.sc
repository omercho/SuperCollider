IFTrack01 {
	*loadAtStart{
		~trackCase=1;
		IFAPC40.tsLeds(1,0,0,0,0,0,0,0);
		IFRoot.set00;
		//this.setGlb01;
		IFTrack01.setGlb01;
		IFTrack01.apcParts;
		IFTrack01.setActs;
		~shiftPartsBut.free;
		~shiftPartsBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack01.sixteen;
				},{
					IFSixteen.defaults;
			});
			},
			'/shiftParts'
		);

		//SampInstruments
		~mdOut.control(0, 71, 127); //Track 01
		~mdOut.control(0, 72, 0); //Track 02
		~mdOut.control(0, 73, 0); //Track 03
		~mdOut.control(0, 74, 0); //Track 04
		~mdOut.control(0, 75, 0); //Track 05
		~mdOut.control(0, 76, 0); //Track 06
		~mdOut.control(0, 77, 0); //Track 07
		~mdOut.control(0, 78, 0); //Track 08
		//ExtInstruments
		~mdOut.control(0, 81, 127); //Track 01
		~mdOut.control(0, 82, 0); //Track 02
		~mdOut.control(0, 83, 0); //Track 03
		~mdOut.control(0, 84, 0); //Track 04
		~mdOut.control(0, 85, 0); //Track 05
		~mdOut.control(0, 86, 0); //Track 06
		~mdOut.control(0, 87, 0); //Track 07
		~mdOut.control(0, 88, 0); //Track 08
		//StaticSnr
		~ntStKick.source = Pseq([67], inf);
		~durStKick.source  =  Pseq([1/2], inf);
		//~ampStSnr.source  =  Pseq([0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0], inf);
		//StaticSnr
		~ntStSnr.source = Pseq([67], inf);
		~durStSnr.source  =  Pseq([1/2], inf);
		//~ampStSnr.source  =  Pseq([1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0], inf);
		//StaticHat
		~ntStHat.source = Pseq([67], inf);
		~durStHat.source  =  Pseq([1/2], inf);
		//~ampStHat.source  =  Pseq([0,1], inf);
		//StaticBass
		~ntStBass.source = Pseq([5], inf);
		~durStBass.source  =  Pseq([1/2], inf);
		//~ampStBass.source  =  Pseq([0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0], inf);
		//StaticKeys
		~ntStKeys.source = Pseq([0], inf);
		~durStKeys.source  =  Pseq([1/2], inf);
		//~ampStKeys.source  =  Pseq([0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0], inf);
		//StaticSamp
		~ntStSamp.source = Pseq([2], inf);
		~durStSamp.source  =  Pseq([1/2], inf);
		//~ampStSamp.source  =  Pseq([0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0], inf);

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
						~transShufBass.source  = Pshuf([0,2,4,(7), (-2),1,12,(-1)], inf);
						~transShufKeys.source  = Pshuf([(-1),3,2,(-7), (-2),4,6,(-1)], inf);
						~transShufSamp.source  = Pshuf([(-1),2,7,(-6), (-2),3,6,(-4)], inf);
						~apc40.noteOn(~apcLn4, ~lnchBut4, 6); //But 1
					},
					2,{
						~tOSCAdrr.sendMsg('shufTransLabel', 'OFF');
						~tOSCAdrr.sendMsg('shufTrans', 0);
						~transShufBass.source  = Pshuf([0], inf);
						~transShufKeys.source  = Pshuf([0], inf);
						~transShufSamp.source  = Pshuf([0], inf);
						~apc40.noteOn(~apcLn4, ~lnchBut4, 5); //But 1
						~countShuf=0;
					}
				)
				},{


				}
			);
			},
			'/shufTrans'
		);

		//------------shufDrum
		~shufDrumBut.free;
		~countShufDrum=0;
		//~tOSCAdrr.sendMsg('shufTransLabel', 'OFF');
		//~tOSCAdrr.sendMsg('shufTrans', 0);
		~shufDrumBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countShufDrum = ~countShufDrum + 1;

				~countShufDrum.switch(
					0,{},
					1, {
						//~transShufKick.source  = Pshuf([0,2,4,(7), (-2),1,12,(-1)], inf);
						~transShufSnr.source  = Pshuf([(-1),3,2,(-7), (-2),4,6,(-1)], inf);
						~transShufHat.source  = Pshuf([(-1),2,7,(-6), (-2),3,6,(-4)], inf);
						~apc40.noteOn(~apcLn4, ~lnchBut5, 6); //But 1
					},
					2,{
						//~transShufKick.source  = Pshuf([0], inf);
						~transShufSnr.source  = Pshuf([0], inf);
						~transShufHat.source  = Pshuf([0], inf);
						~apc40.noteOn(~apcLn4, ~lnchBut5, 5); //But 1
						~countShufDrum=0;
					}
				)
				},{


				}
			);
			},
			'/shufDrum'
		);
	}

	*setActs{
		IFAPC40.actLine1(1,0,0);
		IFAPC40.actLine2(1,0,0);
		IFAPC40.actLine3(1,0,1);
		IFAPC40.actLine4(1,1,0);
		IFAPC40.actLine5(1,0,0);
		IFAPC40.actLine6(1,0,0);

	}//setActs
	*setGlb01{
		"Preset: Trk01".postln;
		~tOSCAdrr.sendMsg('presetLabel','Prst Trk01');
		"TRACK 1".postln;
		~tOSCAdrr.sendMsg('trackLabel','TRACK 1');
		~scl1= Scale.chromatic;
		~scl2= Scale.chinese;
		~tOSCAdrr.sendMsg('scaleLabel', 'Chinese');

		~tmp1=120;
		~tOSCAdrr.sendMsg('tempoLabel', ~tmp1);
		~tOSCAdrr.sendMsg('tempoFader', ~tmp1);
		~nt=(0);

		"Duration Pattern: Straight".postln;
		IFSeqDurPat.stGrp(3);
		~local.sendMsg('durResponder',1);
		~tOSCAdrr.sendMsg('durLabel', 'Straight');

		"Duration Mul: 1/2".postln;
		~tOSCAdrr.sendMsg('durMulLabel', '1/2');
		~durMul.source = Pseq([1/2], inf);
		~tOSCAdrr.sendMsg('durMul1_4', '0');
		~tOSCAdrr.sendMsg('durMul1_2', '1');
		~tOSCAdrr.sendMsg('durMul1', '0');

		"Global Set".postln;
		~local.sendMsg('harm0',1);

		~local.sendMsg('cutAll',0.4, 0.25);
		~local.sendMsg('cutDrum',0.0, 0.0);
		~local.sendMsg('allMainSends',0.0, 0.0);
		~local.sendMsg('melSends',0.0, 0.0);
		~local.sendMsg('drumSends',0.0, 0.0);
		~local.sendMsg('susMel',0.2);
		~local.sendMsg('susDrum',0.2);
		~local.sendMsg('noteFader',0.5);//SnrXpose
		~local.sendMsg('fxFader',0.0);
		~local.sendMsg('AllMasterFXxy1',0.2,0.2);

		~vKeys.control(0, ~voice, ~uni); //voice
		IFAPC40_NobDown.md1SetVals(v1:0.0,v2:0.5,v3:0.0,v4:0.3,v5:0.3,v6:0.5,v7:0.1,v8:0.1);
		/*IFAPC40_NobDown.md2SetVals(
			v1:0.2,v2:0.2,v3:0.2,v4:0.2,v5:0.2,v6:0.2,v7:0.2,v8:0.2
		);*/
		IFAPC40_NobUp.md1SetVals(
			v1:0.0,v2:0.5,v3:0.0,v4:0.3,v5:0.3,v6:0.5,v7:0.1,v8:0.1
		);
		/*IFAPC40_NobUp.md2SetVals(
			v1:0.2,v2:0.2,v3:0.2,v4:0.2,v5:0.2,v6:0.2,v7:0.2,v8:0.2
		);*/



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
		~local.sendMsg('chainHat', 0.0);

		"Bass Set".postln;
		~local.sendMsg('volBass', 0.95);
		~local.sendMsg('sendBass', 0.0, 0.0);
		~local.sendMsg('attBass', 0.05);
		~local.sendMsg('susBass', 0.5);
		~local.sendMsg('decBass', 0.2);
		~local.sendMsg('chainBass', 0.0);
		~local.sendMsg('lfoMulBass1',0.00);
		~local.sendMsg('lfoMulBass2',0.00);
		IFBass.octMul(0);

		"Keys Set".postln;
		~local.sendMsg('volKeys', 0.95);
		~local.sendMsg('sendKeys', 0.0, 0.3);
		~local.sendMsg('attKeys', 0.05);
		~local.sendMsg('susKeys', 0.3);
		~local.sendMsg('decKeys', 0.05);
		~local.sendMsg('chainKeys', 0.05);
		~local.sendMsg('lfoMulKeys1',0.0);
		~local.sendMsg('lfoMulKeys2',0.01);
		IFKeys.octMul(1);

		"Samp Set".postln;
		~local.sendMsg('volSamp', 0.9);
		~local.sendMsg('sendSamp', 0.0, 0.3);
		~local.sendMsg('attSamp', 0.05);
		~local.sendMsg('susSamp', 0.05);
		~local.sendMsg('decSamp', 0.3);
		~local.sendMsg('chainSamp', 0.5);
		~local.sendMsg('lfoMulSamp1',0.2);
		~local.sendMsg('lfoMulSamp2',0.4);
		//~local.sendMsg('octSampZero',1);
		IFSamp.octMul(2);

		"Ext Set".postln;
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);
	}//track 01 End

	*part01{//////                                      - 1 -

		"part01".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt01');
		IFSeqKick.stGrpSet    (1,0,0,0, 1,1,0,0,  0,1,1,0, 0,1,0,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKick.stGrpSet  (0,0,0,0, 0,1,0,0,  0,1,0,0, 0,1,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFSeqStKick.stGrpSet  (1,0,0,0, 0,0,0,0,  1,0,0,0, 0,0,0,0);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (0,1,1,0, 1,0,1,0,  1,0,1,0, 1,1,1,0);
		IFSeqOctSnr.stGrpSet (2,0,0,0, 2,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqNtSnr.stGrpSet  (4,2,0,3, 3,5,0,6,  1,8,0,9, 2,3,4,5);
		IFSeqVelSnr.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFSeqStSnr.stGrpSet  (0,0,0,0, 0,0,1,0,  0,0,0,0, 0,0,1,0);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,0, 1,1,1,1);
		IFSeqOctHat.stGrpSet (1,0,0,0, 2,0,0,0,  2,4,0,0, 2,0,1,0);
		IFSeqNtHat.stGrpSet  (7,0,0,0, 0,0,0,0,  3,0,0,0, 4,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFSeqStHat.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,0,0,0, 0,0,0,0,  1,0,0,0, 0,0,0,0);
		IFSeqOctBass.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFSeqStBass.stGrpSet  (1,0,0,0, 0,0,0,0,  1,0,0,0, 0,0,0,0);
		~lfo1Bass.source  =  Pseq([30,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,100,50], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (0,0,1,0, 0,0,0,0,  0,1,0,0, 1,0,0,0);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFSeqStKeys.stGrpSet  (0,0,1,0, 0,0,0,1,  0,0,0,0, 1,0,0,0);
		~lfoRtKeys.source =  Pseq([20,40,40,10], inf);
		~lfoCtKeys.source =  Pseq([10,20,50,50], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (0,1,0,0, 0,1,0,0,  0,1,0,0, 0,1,0,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelSamp.stGrpSet (0,0,3,0, 3,1,3,0,  3,2,3,0, 3,3,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFSeqStSamp.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		~lfo1Samp.source  =  Pseq([90,1,7,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([6,10,80,99,6,10,80,99], inf);
		//Mas
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pxrand([1,24,70,50,120,0,38,100], inf);
		~dur1Mast.source=Pxrand([1/2,1/4], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+0,~nt+11,~nt+3,~nt+0,~nt+12,~nt+0,~nt+6,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*1, inf);
		~tmRes1.source    =  Pseq([1], inf);

	}//////                                      - 1 -

	*part02{//////                                      - 2 -

		"part02".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt02');
		IFSeqKick.stGrpSet    (1,0,0,0, 1,1,0,0,  0,1,1,0, 0,1,0,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKick.stGrpSet  (0,0,0,0, 0,1,0,0,  0,1,0,0, 0,1,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (0,1,1,0, 1,0,1,0,  1,0,1,0, 1,1,1,0);
		IFSeqOctSnr.stGrpSet (2,0,0,0, 2,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqNtSnr.stGrpSet  (4,2,0,3, 3,5,0,6,  1,8,0,9, 2,3,4,5);
		IFSeqVelSnr.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (1,0,0,0, 2,0,0,0,  2,4,0,0, 2,0,1,0);
		IFSeqNtHat.stGrpSet  (7,0,0,0, 0,0,0,0,  3,0,0,0, 4,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,0,1,1, 1,0,1,0,  1,0,0,0, 0,1,0,0);
		IFSeqOctBass.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([30,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,100,50], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (0,0,1,0, 0,0,0,0,  0,1,0,0, 1,0,0,0);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,4,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,3,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,2,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([20,40,40,10], inf);
		~lfoCtKeys.source =  Pseq([10,20,50,50], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (0,1,0,0, 0,1,0,0,  0,1,0,0, 0,1,1,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,4,3);
		IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelSamp.stGrpSet (0,0,3,0, 3,1,3,0,  3,2,3,0, 3,3,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([90,1,7,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([6,10,80,99,6,10,80,99], inf);
		//Mast
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pseq([1,24,0,50,120], inf);
		~dur1Mast.source=Pxrand([1/2], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+0,~nt+11,~nt+3,~nt+0,~nt+12,~nt+0,~nt+6,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*1, inf);
		~tmRes1.source    =  Pseq([1], inf);

	}//////                                      - 2 -

	*part03{
		"part03".postln; ~tOSCAdrr.sendMsg('partLabel', 'T1prt03');
		IFSeqKick.stGrpSet    (1,0,1,0, 1,1,0,0,  0,1,1,0, 0,1,0,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKick.stGrpSet  (0,0,0,0, 0,1,0,0,  0,1,0,0, 0,1,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (1,1,1,0, 1,0,1,0,  1,0,1,0, 1,1,1,0);
		IFSeqOctSnr.stGrpSet (2,0,0,0, 2,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqNtSnr.stGrpSet  (4,2,0,3, 3,5,0,6,  1,8,0,9, 2,3,4,5);
		IFSeqVelSnr.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (1,0,0,0, 2,0,0,0,  2,4,0,0, 2,0,1,0);
		IFSeqNtHat.stGrpSet  (7,0,0,0, 0,0,0,0,  3,0,0,0, 4,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,0,1,1, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		IFSeqOctBass.stGrpSet (3,3,3,3, 3,3,3,3,  4,3,4,3, 3,3,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,1,0,  3,0,1,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([30,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,100,50], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (0,0,1,0, 0,0,1,1,  0,1,0,0, 1,0,0,0);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,4,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,3,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,2,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([20,40,40,10], inf);
		~lfoCtKeys.source =  Pseq([10,20,50,50], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (0,1,0,0, 1,1,0,0,  0,1,0,0, 0,1,1,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,4,3);
		IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelSamp.stGrpSet (0,0,3,0, 3,1,3,0,  3,2,3,0, 3,3,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([90,1,7,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([6,10,80,99,6,10,80,99], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+0,~nt+11,~nt+3,~nt+0,~nt+12,~nt+0,~nt+6,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*1, inf);
		~tmRes1.source    =  Pseq([1], inf);
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pseq([1,24,0,50,120], inf);
		~dur1Mast.source=Pxrand([1/2], inf);
	}//////                                      - 3 -

	*part04{
		"part04".postln; ~tOSCAdrr.sendMsg('partLabel', 'T1prt04');
		IFSeqKick.stGrpSet    (1,0,0,0, 0,0,0,0,  1,0,0,0, 0,0,0,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKick.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (0,1,1,0, 0,0,1,0,  1,0,1,0, 1,1,1,0);
		IFSeqOctSnr.stGrpSet (0,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqNtSnr.stGrpSet  (1,2,0,3, 3,5,0,6,  1,8,0,9, 2,3,4,5);
		IFSeqVelSnr.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,0, 1,0,1,0,  1,1,1,0, 1,1,1,0);
		IFSeqOctHat.stGrpSet (1,3,1,3, 1,3,1,3,  1,3,1,3, 1,3,1,3);
		IFSeqNtHat.stGrpSet  (7,0,0,0, 0,0,0,0,  7,0,0,0, 4,0,3,0);
		IFSeqVelHat.stGrpSet (3,3,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (0,1,0,0, 0,0,1,0,  0,0,0,0, 0,0,0,0);
		IFSeqOctBass.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([30,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,100,50], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,0, 0,1,0,0,  1,0,1,0, 0,1,1,0);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,3,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([100,40,40,10], inf);
		~lfoCtKeys.source =  Pseq([10,20,50,50], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (0,1,0,0, 0,1,0,0,  0,1,0,0, 1,0,0,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtSamp.stGrpSet  (0,1,0,0, 0,2,0,0,  0,3,0,0, 3,0,0,0);
		IFSeqVelSamp.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([90,11,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([6,10,80,99,6,10,80,99], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+0,~nt+11,~nt+3,~nt+0,~nt+12,~nt+0,~nt+6,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*1, inf);
		~tmRes1.source    =  Pseq([1], inf);
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pseq([0,124,10,0,12], inf);
		~dur1Mast.source=Pxrand([1/2], inf);
	}//////                                      - 4 -

	*part05{
		"part05".postln; ~tOSCAdrr.sendMsg('partLabel', 'T1prt05');
		IFSeqKick.stGrpSet    (1,0,1,0, 1,1,0,0,  1,1,1,0, 1,1,0,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKick.stGrpSet  (0,0,0,0, 0,1,0,0,  0,1,0,0, 0,1,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (1,1,1,0, 1,0,1,0,  1,1,1,0, 1,1,1,0);
		IFSeqOctSnr.stGrpSet (2,0,0,0, 2,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqNtSnr.stGrpSet  (4,2,0,3, 3,5,0,6,  1,8,0,9, 2,3,4,5);
		IFSeqVelSnr.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (1,0,0,0, 2,0,0,0,  2,4,0,0, 2,0,1,0);
		IFSeqNtHat.stGrpSet  (7,0,0,0, 0,0,0,0,  3,0,0,0, 4,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,0,1,1, 1,0,1,0,  1,0,1,0, 1,1,1,0);
		IFSeqOctBass.stGrpSet (3,3,3,3, 3,3,3,3,  4,3,4,3, 3,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,1,0,  3,0,1,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([30,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,100,50], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,0, 0,0,1,1,  0,1,0,1, 1,0,0,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,4,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,3,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,2,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([20,40,40,10], inf);
		~lfoCtKeys.source =  Pseq([10,20,50,50], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (0,1,0,1, 0,1,0,0,  0,1,0,1, 0,1,1,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,4,3);
		IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelSamp.stGrpSet (0,0,3,0, 3,1,3,0,  3,2,3,0, 3,3,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([90,1,7,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([6,10,80,99,6,10,80,99], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+0,~nt+11,~nt+3,~nt+0,~nt+12,~nt+0,~nt+6,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*1, inf);
		~tmRes1.source    =  Pseq([1], inf);
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pseq([1,24,0,50,120], inf);
		~dur1Mast.source=Pxrand([1/2], inf);
	}//////                                      - 5 -

	*part06{
		"part06".postln; ~tOSCAdrr.sendMsg('partLabel', 'T1prt06');
		IFSeqKick.stGrpSet    (1,0,1,0, 1,1,0,0,  1,1,1,0, 1,1,1,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKick.stGrpSet  (0,0,0,0, 0,1,0,0,  0,1,0,0, 0,1,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (1,1,1,0, 1,1,1,0,  1,1,1,0, 1,1,1,0);
		IFSeqOctSnr.stGrpSet (2,0,0,0, 2,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqNtSnr.stGrpSet  (4,2,0,3, 3,5,0,6,  1,8,0,9, 2,3,4,5);
		IFSeqVelSnr.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (1,0,0,0, 2,0,0,0,  2,4,0,0, 2,0,1,0);
		IFSeqNtHat.stGrpSet  (7,0,0,0, 0,0,0,0,  3,0,0,0, 4,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,0,1,1, 1,0,1,0,  1,0,1,0, 1,1,1,0);
		IFSeqOctBass.stGrpSet (3,3,3,3, 3,3,4,3,  4,3,4,3, 3,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,1,0,  3,0,1,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([30,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,100,50], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,0, 0,1,1,1,  0,1,0,1, 1,0,1,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,4,3,3,  3,4,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,3,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,2,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([20,40,40,10], inf);
		~lfoCtKeys.source =  Pseq([10,20,50,50], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (0,1,0,1, 0,1,1,0,  0,1,0,1, 0,1,1,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,4,3);
		IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelSamp.stGrpSet (0,0,3,0, 3,1,3,0,  3,2,3,0, 3,3,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([90,1,7,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([6,10,80,99,6,10,80,99], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+0,~nt+11,~nt+3,~nt+0,~nt+12,~nt+0,~nt+6,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*1, inf);
		~tmRes1.source    =  Pseq([1], inf);
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pseq([1,24,0,50,120], inf);
		~dur1Mast.source=Pxrand([1/2], inf);
	}//////                                      - 6 -

	*part07{
		"part07".postln; ~tOSCAdrr.sendMsg('partLabel', 'T1prt07');
		IFSeqKick.stGrpSet    (1,0,1,0, 1,1,1,0,  1,1,1,0, 1,1,1,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKick.stGrpSet  (0,1,0,0, 0,1,0,0,  0,1,0,1, 0,1,1,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (1,1,1,0, 1,1,1,0,  1,1,1,0, 1,1,1,0);
		IFSeqOctSnr.stGrpSet (2,0,0,0, 2,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqNtSnr.stGrpSet  (4,2,0,3, 3,5,0,6,  1,8,0,9, 2,3,4,5);
		IFSeqVelSnr.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (1,0,0,0, 2,0,0,0,  2,4,0,0, 2,0,1,0);
		IFSeqNtHat.stGrpSet  (7,0,0,0, 0,0,0,0,  3,0,0,0, 4,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,0,1,1, 1,0,1,0,  1,0,1,0, 1,1,1,0);
		IFSeqOctBass.stGrpSet (3,3,3,3, 3,3,4,3,  4,3,4,3, 3,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,1,0,  3,0,1,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([30,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,100,50], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,0, 0,1,1,1,  0,1,0,1, 1,0,1,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,4,3,3,  3,4,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,3,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,2,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([20,40,40,10], inf);
		~lfoCtKeys.source =  Pseq([10,20,50,50], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (1,1,0,1, 0,1,1,0,  0,1,1,1, 0,1,1,0);
		IFSeqOctSamp.stGrpSet (4,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,4,3);
		IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelSamp.stGrpSet (0,0,3,0, 3,1,3,0,  3,2,3,0, 3,3,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([90,1,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([60,10,80,99,6,10,80,99], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+0,~nt+11,~nt+3,~nt+0,~nt+12,~nt+0,~nt+6,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*1, inf);
		~tmRes1.source    =  Pseq([1], inf);
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pseq([100,24,0,50,120], inf);
		~dur1Mast.source=Pxrand([1/2], inf);
	}//////                                      - 7 -

	*part08{
		"part07".postln; ~tOSCAdrr.sendMsg('partLabel', 'T1prt08');
		IFSeqKick.stGrpSet    (1,1,0,0, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKick.stGrpSet  (0,1,0,1, 0,1,0,0,  0,1,0,0, 0,1,0,0);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (1,1,1,1, 1,1,1,1,  1,0,1,1, 1,1,1,1);
		IFSeqOctSnr.stGrpSet (0,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
		IFSeqNtSnr.stGrpSet  (1,2,0,3, 3,5,0,6,  1,8,0,9, 2,3,4,5);
		IFSeqVelSnr.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSnr.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSnr.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//IFSeqDurSnr.stGrp (4);
		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (1,3,1,3, 1,3,1,3,  1,3,1,3, 1,3,1,3);
		IFSeqNtHat.stGrpSet  (7,0,0,0, 0,0,0,0,  7,0,0,0, 4,0,3,0);
		IFSeqVelHat.stGrpSet (3,3,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmHat.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurHat.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,0, 1,0,1,1,  1,1,1,1, 1,0,1,0);
		IFSeqOctBass.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,7,0);
		IFSeqVelBass.stGrpSet (3,0,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusBass.stGrpSet (0,0,0,0, 0,0,0,0,  3,0,0,0, 3,0,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Bass.source  =  Pseq([90,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([10,120,30,50, 0,20,100,50], inf);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,1,1,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,4,3,3,  4,3,3,3, 3,5,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,3,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfoRtKeys.source =  Pseq([100,40,40,10], inf);
		~lfoCtKeys.source =  Pseq([10,20,50,50], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (0,1,0,0, 0,1,0,1,  0,1,1,0, 1,1,0,0);
		IFSeqOctSamp.stGrpSet (3,4,3,3, 3,3,3,3,  3,5,3,3, 3,3,3,3);
		IFSeqNtSamp.stGrpSet  (0,1,0,0, 0,2,0,0,  0,3,0,0, 3,5,0,0);
		IFSeqVelSamp.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~lfo1Samp.source  =  Pseq([90,111,70,9, 80,110,70,1], inf);
		~lfo2Samp.source  =  Pseq([6,110,80,99,60,10,80,99], inf);
		//Res1
		~nt1Res1.source   =  Pseq([~nt+0,~nt+11,~nt+13,~nt+2,~nt+12,~nt+0,~nt+6,~nt+10], inf);
		~dur1Res1.source  =  Pseq([1]*1, inf);
		~tmRes1.source    =  Pseq([1], inf);
		~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
		~ccValMast.source=Pseq([20,124,10,60,12], inf);
		~dur1Mast.source=Pxrand([1/2], inf);

	}//////                                      - 8 -

	*sixteen {//Parts 1-8 //Presets 9-16
		~seqStepBut01.free;
		~seqStepBut01 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack01.part01;
			});
			},
			'/seqStep01'
		);

		~seqStepBut02.free;
		~seqStepBut02 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack01.part02;
			});
			},
			'/seqStep02'
		);

		~seqStepBut03.free;
		~seqStepBut03 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack01.part03;
			});
			},
			'/seqStep03'
		);

		~seqStepBut04.free;
		~seqStepBut04 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack01.part04;
			});
			},
			'/seqStep04'
		);
		~seqStepBut05.free;
		~seqStepBut05 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack01.part05;
			});
			},
			'/seqStep05'
		);
		~seqStepBut06.free;
		~seqStepBut06 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack01.part06;
			});
			},
			'/seqStep06'
		);
		~seqStepBut07.free;
		~seqStepBut07 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack01.part07;
			});
			},
			'/seqStep07'
		);
		~seqStepBut08.free;
		~seqStepBut08 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack01.part08;
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

		~apc_TS01.free;
		~apc_TS01=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=1;
				IFTrack01.part01;
				IFAPC40.tsLeds(1,0,0,0,0,0,0,0);
			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS02.free;
		~apc_TS02=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=2;
				IFTrack01.part02;
				IFAPC40.tsLeds(0,1,0,0,0,0,0,0);
			});
		},srcID:~apc40InID, chan:1, noteNum:51);
		~apc_TS03.free;
		~apc_TS03=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=3;
				IFTrack01.part03;
				IFAPC40.tsLeds(0,0,1,0,0,0,0,0);
			});
		},srcID:~apc40InID, chan:2, noteNum:51);
		~apc_TS04.free;
		~apc_TS04=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=4;
				IFTrack01.part04;
				IFAPC40.tsLeds(0,0,0,1,0,0,0,0);
			});
		},srcID:~apc40InID, chan:3, noteNum:51);
		~apc_TS05.free;
		~apc_TS05=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=5;
				IFTrack01.part05;
				IFAPC40.tsLeds(0,0,0,0,1,0,0,0);
			});
		},srcID:~apc40InID, chan:4, noteNum:51);
		~apc_TS06.free;
		~apc_TS06=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=6;
				IFTrack01.part06;
				IFAPC40.tsLeds(0,0,0,0,0,1,0,0);
			});
		},srcID:~apc40InID, chan:5, noteNum:51);
		~apc_TS07.free;
		~apc_TS07=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=7;
				IFTrack01.part07;
				IFAPC40.tsLeds(0,0,0,0,0,0,1,0);
			});
		},srcID:~apc40InID, chan:6, noteNum:51);
		~apc_TS08.free;
		~apc_TS08=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=8;
				IFTrack01.part08;
				IFAPC40.tsLeds(0,0,0,0,0,0,0,1);
			});
		},srcID:~apc40InID, chan:7, noteNum:51);

	}//apcParts

	*apcActs{

	}//apcActs

}