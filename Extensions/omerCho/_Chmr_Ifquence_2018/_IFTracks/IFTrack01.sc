/*

PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

*/

IFTrack01 {
	*loadAtStart{
		~trackCase=1;
		IFLpMn.tsLeds(1,0,0,0,0,0,0,0);
		IFRoot.set00;
		this.setGlb01;
		//this.lpMnParts;
		this.setActs;
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

		// SHUFFLES from IFShuf
		IFShuf.loadKick(0,0,2,0,0,0,7,4,0);
		IFShuf.loadSnr(1,0,2,0,3,0,1,2,0);
		IFShuf.loadHat(0,1,0,2,0,3,0,4,0);
		IFShuf.loadBass(0,1,0,4,0,2,0,0,2);
		IFShuf.loadKeys(0,4,2,0,4,6,6,0,2);
		IFShuf.loadSamp(0,2,0,3,2,1,6,0,4);
		IFShuf.loadMopho(0,2,0,1,2,4,2,0,6);
		IFShuf.harmDrum(0,-1,2,-3,2,-5,6,8,7);
		IFShuf.harmMel(0,-1,2,-3,0,-2,6,1,3);
	}

	*setActs{
		IFAPCMn.actLine1(0,0,0,0);
		IFAPCMn.actLine2(0,0,0,0);
		IFAPCMn.actLine3(0,0,0,0);
		IFAPCMn.actLine4(0,0,0,0);
		IFAPCMn.actLine5(0,0,0,0);
		IFAPCMn.actLine6(1,0,0,0);
		IFAPCMn.actLine7(1,0,0,0);

		IFMIDIMix.act5(0,0,0);

	}//setActs
	*setGlb01{
		"Preset: Trk01".postln;
		~tOSCAdrr.sendMsg('presetLabel','Prst Trk01');
		"TRACK 1".postln;
		~tOSCAdrr.sendMsg('trackLabel','TRACK 1');
		~scl1= Scale.chromatic;
		~scl2= Scale.humayun;
		~tOSCAdrr.sendMsg('scaleLabel', 'humayun');

		IFProjectGlobals.setTempo(122);
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

		"STORED GLOBAL SETTINGS:".postln;
		~local.sendMsg('harm0',1);
		~local.sendMsg('cutAll',0.4, 0.25);
		~local.sendMsg('cutMel2',0.1, 0.25);
		~local.sendMsg('melSends',0.0, 0.0);
		~local.sendMsg('susMel',0.2);
		~local.sendMsg('melFader',0.1);

		~local.sendMsg('cutDrum',0.0, 0.0);
		~local.sendMsg('drumSends',0.0, 0.0);
		~local.sendMsg('susDrum',0.3);
		~local.sendMsg('snrXPose',0.5);//SnrXpose
		~local.sendMsg('fxFader',0.0);
		~local.sendMsg('fxComp',0.3);
		~local.sendMsg('fxDecay',0.2);
		~local.sendMsg('AllMasterFXxy1',0.2,0.2);

		"Kick Set".postln;
		~local.sendMsg('volKick', 0.99);
		~local.sendMsg('sendKick', 0.0, 0.0);
		~local.sendMsg('attKick', 0.0);
		~local.sendMsg('susKick', 0.5);
		~local.sendMsg('decKick', 0.7);
		~local.sendMsg('chainKick', 0.0);

		"Snr Set".postln;
		~local.sendMsg('volSnr', 0.9);
		~local.sendMsg('sendSnr', 0.0, 0.0);
		~local.sendMsg('attSnr', 0.1);
		~local.sendMsg('susSnr', 0.2);
		~local.sendMsg('decSnr', 0.2);
		~local.sendMsg('chainSnr', 0.5);

		"Hat Set".postln;
		~local.sendMsg('volHat', 0.95);
		~local.sendMsg('sendHat', 0.0, 0.3);
		~local.sendMsg('attHat', 0.0);
		~local.sendMsg('susHat', 0.6);
		~local.sendMsg('decHat', 0.2);
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
		VBass.preSet01;
		IFBass.octMul(0);

		"Keys Set".postln;
		~local.sendMsg('volKeys', 0.95);
		~local.sendMsg('sendKeys', 0.0, 0.0);
		~local.sendMsg('attKeys', 0.05);
		~local.sendMsg('susKeys', 0.3);
		~local.sendMsg('decKeys', 0.05);
		~local.sendMsg('chainKeys', 0.05);
		~local.sendMsg('lfoMulKeys1',0.0);
		~local.sendMsg('lfoMulKeys2',0.01);
		VKeys.preSet01;
		IFKeys.octMul(1);

		"Samp Set".postln;
		~local.sendMsg('volSamp', 0.9);
		~local.sendMsg('sendSamp', 0.42, 0.0);
		~local.sendMsg('attSamp', 0.05);
		~local.sendMsg('susSamp', 0.05);
		~local.sendMsg('decSamp', 0.6);
		~local.sendMsg('chainSamp', 0.5);
		~local.sendMsg('lfoMulSamp1',0.6);
		~local.sendMsg('lfoMulSamp2',0.4);
		//~local.sendMsg('octSampZero',1);
		IFSamp.octMul(1);

		"Mopho Set".postln;
		~local.sendMsg('volMopho', 0.9);
		~local.sendMsg('sendMopho', 0.42, 0.0);
		~local.sendMsg('attMopho', 0.05);
		~local.sendMsg('susMopho', 0.05);
		~local.sendMsg('decMopho', 0.6);
		~local.sendMsg('chainMopho', 0.5);
		~local.sendMsg('lfoMulMopho1',0.2);
		~local.sendMsg('lfoMulMopho2',0.3);
		//~local.sendMsg('octMophoZero',1);
		IFMopho.octMul(1);

		"Ext Set".postln;
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);
	}//track 01 End

	*part01{//////                                      - 1 -
		//IFTrack01.setActs;
		"part01".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt01');

		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		~octVKick=0;~ntVKick.source = Pseq([0], inf);
		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~ntVSnr.source = Pseq([20], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,1,0,1);
		~ntVHat.source = Pseq([125], inf);
		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVClap.stGrpSet  (0,0,1,0, 0,0,1,1,  0,0,0,0, 1,0,0,0);
		//~ntVClap.source = Pseq([39], inf);
		//~durVClap.source  =  Pseq([1/2], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

		//CH -1- [ Kick ]
		~local.sendMsg('sendKick', 0.0, 0.0);
		~local.sendMsg('attKick', 0.0);
		~local.sendMsg('susKick', 0.0);
		~local.sendMsg('decKick', 0.9);
		~local.sendMsg('chainKick', 0.0);
		IFSeqKick.stGrpSet    (1,1,1,1, 1,1,1,1, 1,1,1,1, 1,1,1,1);
		IFSeqOctKick.stGrp (2);
		IFSeqNtKick.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKick.stGrpSet (0,4,1,3, 0,5,1,3,  0,4,1,3, 0,5,1,3);
		IFSeqSusKick.stGrpSet (1,2,1,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);

		IFSeqKick2.stGrpSet    (0,1,1,0, 1,0,1,0,  1,0,1,0, 1,1,0,0);
		IFSeqNtKick2.stGrpSet  (0,0,2,3, 0,1,4,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelKick2.stGrpSet (1,2,1,3, 1,2,1,2,  1,2,1,3, 1,2,1,2);
		IFSeqSusKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,5,2);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,0,0,0, 0,1,1,0,  0,0,1,0, 0,1,1,0);
		IFSeqNtSnr.stGrpSet   (4,1,2,3, 4,1,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,3,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,2,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurSnr.stGrp     (4);
		IFSeqSnr2.stGrpSet    (0,1,2,1, 0,0,0,1,  0,1,0,0, 0,0,0,1);
		IFSeqNtSnr2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusSnr2.stGrpSet (1,2,1,3, 1,2,1,2,  1,3,1,2, 1,2,3,2);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctHat.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,4,3,3);
		IFSeqNtHat.stGrpSet  (1,2,1,0, 1,2,1,0,  1,2,1,0, 1,2,0,1);
		IFSeqVelHat.stGrpSet (1,3,3,1, 1,3,3,1,  1,3,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (3,1,2,1, 3,1,2,1,  3,1,2,1, 3,2,3,1);
		IFSeqTmHat.stGrp  (1);
		IFSeqDurHat.stGrp  (4);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,0,1,  1,0,1,1, 1,0,1,1);
		IFSeqOctBass.stGrpSet (2,3,3,3, 2,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 2,0,3,2);
		IFSeqVelBass.stGrpSet (3,2,1,2, 3,2,1,3,  3,1,3,2, 3,2,3,0);
		IFSeqSusBass.stGrpSet (3,0,1,0, 0,0,1,3,  2,0,1,0, 3,3,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadBass(0,2,0,4,1,3,0,5,2);
		~lfo1Bass.source  =  Pseq([10,90,70,18, 10,40,60,20], inf);
		~lfo2Bass.source  =  Pseq([10,20,30,50, 80,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.30);
		~local.sendMsg('lfoMulBass2',0.10);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (0,0,1,1, 0,1,0,1,  1,0,1,1, 1,1,1,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 2,0,3,2);
		IFSeqVelKeys.stGrpSet (1,2,1,2, 1,2,1,3,  3,1,3,2, 3,2,3,0);
		IFSeqSusKeys.stGrpSet (2,3,2,0, 2,3,4,5,  2,3,2,0, 2,2,3,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,2,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,2,4,4, 4,2,4,4);
		IFShuf.loadKeys(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulKeys1',0.0);
		~local.sendMsg('lfoMulKeys2',0.01);
		~lfoRtKeys.source =  Pseq([20,40,40,10,20,10,90,10], inf);
		~lfoCtKeys.source =  Pseq([10,20,90,50,30,40,90,20], inf);
		//CH -6- [SAMP]a
		IFSeqSamp.stGrpSet    (0,1,0,1, 0,1,0,0,  1,1,0,1, 0,0,1,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtSamp.stGrpSet  (6,1,2,1, 4,3,5,0,  1,0,1,2, 0,3,0,0);
		IFSeqVelSamp.stGrpSet (0,3,0,3, 0,3,0,3,  0,3,0,3, 0,3,0,3);
		IFSeqSusSamp.stGrpSet (5,5,5,0, 3,5,4,5,  5,0,0,0, 4,0,4,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadSamp(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulSamp1',0.5);
		~local.sendMsg('lfoMulSamp2',0.4);
		~lfo1Samp.source  =  Pseq([90,1,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 0,1,1,1,  0,1,1,1, 1,0,1,0);
		IFSeqOctMopho.stGrpSet (3,3,4,3, 3,4,3,4,  4,3,4,3, 3,4,3,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,2,1, 0,0,0,0);
		IFSeqVelMopho.stGrpSet (4,3,0,3, 3,3,0,3,  0,3,0,3, 4,3,0,3);
		IFSeqSusMopho.stGrpSet (0,0,1,0, 4,0,1,0,  4,0,1,0, 0,3,0,5);
		IFSeqTmMopho.stGrpSet  (1,1,1,2, 1,1,1,2,  1,1,2,1, 2,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadMopho(0,2,0,-3,8,1,0,6,2);
		~local.sendMsg('lfoMulMopho1',0.2);
		~local.sendMsg('lfoMulMopho2',0.3);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);


	}//////                                             - 1 -

	*part02{//////                                      - 1 -
		//IFTrack01.setActs;
		"part02".postln;~tOSCAdrr.sendMsg('partLabel', 'T1prt02');

		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		~octVKick=0;~ntVKick.source = Pseq([1], inf);
		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~ntVSnr.source = Pseq([16], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,0,1,0);
		~ntVHat.source = Pseq([125], inf);
		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVClap.stGrpSet  (0,0,1,0, 0,0,1,1,  0,0,0,0, 1,0,0,0);
		//~ntVClap.source = Pseq([39], inf);
		//~durVClap.source  =  Pseq([1/2], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

		//CH -1- [ Kick ]
		IFSeqKick.stGrpSet    (0,0,0,1, 0,0,0,1, 0,0,0,1, 0,0,1,1);
		IFSeqOctKick.stGrpSet (2,1,2,1, 2,1,2,1, 2,1,2,1, 2,1,2,1);
		IFSeqNtKick.stGrpSet  (0,0,4,9, 0,0,4,0,  0,0,4,9, 0,0,4,9);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (0,2,0,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);

		IFSeqKick2.stGrpSet    (0,1,0,0, 1,0,0,0,  1,0,1,0, 0,1,0,0);
		IFSeqNtKick2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelKick2.stGrpSet (1,2,1,3, 1,2,1,2,  1,2,1,3, 1,2,1,2);
		IFSeqSusKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,5,2);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,0,0,0, 0,1,1,0,  0,0,1,0, 0,1,1,0);
		IFSeqNtSnr.stGrpSet   (4,1,2,3, 4,1,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,3,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,1,1,1,  1,1,2,1, 1,1,1,1);
		IFSeqDurSnr.stGrp     (4);
		IFSeqSnr2.stGrpSet    (0,0,0,1, 0,0,0,1,  0,1,0,0, 0,1,1,0);
		IFSeqNtSnr2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqNtHat.stGrpSet  (1,0,0,0, 1,0,0,0,  1,0,3,0, 0,1,2,3);
		IFSeqVelHat.stGrpSet (3,2,3,1, 1,3,3,1,  1,3,3,1, 3,2,3,0);
		IFSeqSusHat.stGrpSet (3,2,1,3, 3,2,1,3,  3,2,1,3, 3,2,3,1);
		IFSeqTmHat.stGrp  (1);
		IFSeqDurHat.stGrp  (4);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctBass.stGrpSet (2,3,3,3, 2,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 4,0,3,2);
		IFSeqVelBass.stGrpSet (2,3,1,2, 2,3,0,2,  2,3,0,2, 2,3,1,2);
		IFSeqSusBass.stGrpSet (3,0,1,0, 0,0,1,0,  2,0,1,0, 3,3,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadBass(0,2,0,4,1,3,0,5,2);
		~lfo1Bass.source  =  Pseq([0,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.05);
		~local.sendMsg('lfoMulBass2',0.1);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,1,0,1, 0,0,1,0,  0,1,1,0, 0,1,1,0);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 4,0,3,2);
		IFSeqVelKeys.stGrpSet (4,3,3,2, 3,2,3,2,  5,3,3,2, 5,2,3,0);
		IFSeqSusKeys.stGrpSet (5,3,2,0, 4,3,4,5,  3,3,2,0, 5,2,3,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,2,1,1, 1,2,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,2,4,4, 4,2,4,4);
		IFShuf.loadKeys(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulKeys1',0.2);
		~local.sendMsg('lfoMulKeys2',0.1);
		~lfoRtKeys.source =  Pseq([120,40,40,10,20,110,90,10], inf);
		~lfoCtKeys.source =  Pseq([0,20,90,50,0,40,90,70], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSamp.stGrpSet (3,3,3,4, 3,3,3,4,  3,3,3,4, 3,3,3,4);
		IFSeqNtSamp.stGrpSet  (0,-1,-2,3, 4,0,6,0,  0,-1,-2,5, 0,3,0,0);
		IFSeqVelSamp.stGrpSet (0,3,0,3, 0,3,0,3,  0,3,0,3, 0,3,0,3);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadSamp(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulSamp1',0.65);
		~local.sendMsg('lfoMulSamp2',0.45);
		~lfo1Samp.source  =  Pseq([90,1,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 0,1,1,1,  0,1,1,1, 1,0,1,0);
		IFSeqOctMopho.stGrpSet (4,4,4,3, 3,4,5,4,  4,4,5,4, 4,4,4,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,1, 0,1,0,1,  0,1,0,1, 1,0,3,1);
		IFSeqVelMopho.stGrpSet (4,3,0,3, 3,3,0,3,  0,3,0,3, 4,3,0,3);
		IFSeqSusMopho.stGrpSet (0,0,1,0, 4,0,1,0,  4,0,1,0, 0,3,0,5);
		IFSeqTmMopho.stGrpSet  (1,1,1,2, 1,1,1,2,  1,1,2,1, 2,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadMopho(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulMopho1',0.25);
		~local.sendMsg('lfoMulMopho2',0.35);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);

	}//////                                      - 2 -

	*part03{
		"part03".postln; ~tOSCAdrr.sendMsg('partLabel', 'T1prt03');

		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		~octVKick=0;~ntVKick.source = Pseq([1], inf);
		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~ntVSnr.source = Pseq([16], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,0,1,0);
		~ntVHat.source = Pseq([125], inf);
		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVClap.stGrpSet  (0,0,1,0, 0,0,1,1,  0,0,0,0, 1,0,0,0);
		//~ntVClap.source = Pseq([39], inf);
		//~durVClap.source  =  Pseq([1/2], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

		//CH -1- [ Kick ]
		IFSeqKick.stGrpSet    (0,0,0,1, 0,0,0,1, 0,0,0,1, 0,0,1,1);
		IFSeqOctKick.stGrpSet (2,1,2,1, 2,1,2,1, 2,1,2,1, 2,1,2,1);
		IFSeqNtKick.stGrpSet  (0,0,4,9, 0,0,4,0,  0,0,4,9, 0,0,4,9);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (0,2,0,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);

		IFSeqKick2.stGrpSet    (0,1,0,0, 1,0,0,0,  1,0,1,0, 0,1,0,0);
		IFSeqNtKick2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelKick2.stGrpSet (1,2,1,3, 1,2,1,2,  1,2,1,3, 1,2,1,2);
		IFSeqSusKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,5,2);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,0,0,0, 0,1,1,0,  0,0,1,0, 0,1,1,0);
		IFSeqNtSnr.stGrpSet   (4,1,2,3, 4,1,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,3,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,1,1,1,  1,1,2,1, 1,1,1,1);
		IFSeqDurSnr.stGrp     (4);
		IFSeqSnr2.stGrpSet    (0,0,0,1, 0,0,0,1,  0,1,0,0, 0,1,1,0);
		IFSeqNtSnr2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqNtHat.stGrpSet  (1,0,0,0, 1,0,0,0,  1,0,3,0, 0,1,2,3);
		IFSeqVelHat.stGrpSet (3,2,3,1, 1,3,3,1,  1,3,3,1, 3,2,3,0);
		IFSeqSusHat.stGrpSet (3,2,1,3, 3,2,1,3,  3,2,1,3, 3,2,3,1);
		IFSeqTmHat.stGrp  (1);
		IFSeqDurHat.stGrp  (4);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctBass.stGrpSet (2,3,3,3, 2,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 4,0,3,2);
		IFSeqVelBass.stGrpSet (2,3,1,2, 2,3,0,2,  2,3,0,2, 2,3,1,2);
		IFSeqSusBass.stGrpSet (3,0,1,0, 0,0,1,0,  2,0,1,0, 3,3,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadBass(0,2,0,4,1,3,0,5,2);
		~lfo1Bass.source  =  Pseq([0,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.00);
		~local.sendMsg('lfoMulBass2',0.00);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,1,0,1, 0,0,1,0,  0,1,1,0, 0,1,1,0);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 4,0,3,2);
		IFSeqVelKeys.stGrpSet (4,3,3,2, 3,2,3,2,  5,3,3,2, 5,2,3,0);
		IFSeqSusKeys.stGrpSet (5,3,2,0, 4,3,4,5,  3,3,2,0, 5,2,3,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,2,1,1, 1,2,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,2,4,4, 4,2,4,4);
		IFShuf.loadKeys(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulKeys1',0.0);
		~local.sendMsg('lfoMulKeys2',0.01);
		~lfoRtKeys.source =  Pseq([120,40,40,10,20,110,90,10], inf);
		~lfoCtKeys.source =  Pseq([0,20,90,50,0,40,90,70], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSamp.stGrpSet (3,3,3,4, 3,3,3,4,  3,3,3,4, 3,3,3,4);
		IFSeqNtSamp.stGrpSet  (0,-1,-2,3, 4,0,6,0,  0,-1,-2,5, 0,3,0,0);
		IFSeqVelSamp.stGrpSet (0,3,0,3, 0,3,0,3,  0,3,0,3, 0,3,0,3);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadSamp(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulSamp1',0.6);
		~local.sendMsg('lfoMulSamp2',0.4);
		~lfo1Samp.source  =  Pseq([90,1,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 0,1,1,1,  0,1,1,1, 1,0,1,0);
		IFSeqOctMopho.stGrpSet (4,4,4,3, 3,4,5,4,  4,4,5,4, 4,4,4,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,1, 0,1,0,1,  0,1,0,1, 1,0,3,1);
		IFSeqVelMopho.stGrpSet (4,3,0,3, 3,3,0,3,  0,3,0,3, 4,3,0,3);
		IFSeqSusMopho.stGrpSet (0,0,1,0, 4,0,1,0,  4,0,1,0, 0,3,0,5);
		IFSeqTmMopho.stGrpSet  (1,1,1,2, 1,1,1,2,  1,1,2,1, 2,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadMopho(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulMopho1',0.2);
		~local.sendMsg('lfoMulMopho2',0.3);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);
	}//////                                      - 3 -

	*part04{
		"part04".postln; ~tOSCAdrr.sendMsg('partLabel', 'T1prt04');
		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		~octVKick=0;~ntVKick.source = Pseq([1], inf);
		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~ntVSnr.source = Pseq([16], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,0,1,0);
		~ntVHat.source = Pseq([125], inf);
		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVClap.stGrpSet  (0,0,1,0, 0,0,1,1,  0,0,0,0, 1,0,0,0);
		//~ntVClap.source = Pseq([39], inf);
		//~durVClap.source  =  Pseq([1/2], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

		//CH -1- [ Kick ]
		IFSeqKick.stGrpSet    (0,0,0,1, 0,0,0,1, 0,0,0,1, 0,0,1,1);
		IFSeqOctKick.stGrpSet (2,1,2,1, 2,1,2,1, 2,1,2,1, 2,1,2,1);
		IFSeqNtKick.stGrpSet  (0,0,4,9, 0,0,4,0,  0,0,4,9, 0,0,4,9);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (0,2,0,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);

		IFSeqKick2.stGrpSet    (0,1,0,0, 1,0,0,0,  1,0,1,0, 0,1,0,0);
		IFSeqNtKick2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelKick2.stGrpSet (1,2,1,3, 1,2,1,2,  1,2,1,3, 1,2,1,2);
		IFSeqSusKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,5,2);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,0,0,0, 0,1,1,0,  0,0,1,0, 0,1,1,0);
		IFSeqNtSnr.stGrpSet   (4,1,2,3, 4,1,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,3,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,1,1,1,  1,1,2,1, 1,1,1,1);
		IFSeqDurSnr.stGrp     (4);
		IFSeqSnr2.stGrpSet    (0,0,0,1, 0,0,0,1,  0,1,0,0, 0,1,1,0);
		IFSeqNtSnr2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqNtHat.stGrpSet  (1,0,0,0, 1,0,0,0,  1,0,3,0, 0,1,2,3);
		IFSeqVelHat.stGrpSet (3,2,3,1, 1,3,3,1,  1,3,3,1, 3,2,3,0);
		IFSeqSusHat.stGrpSet (3,2,1,3, 3,2,1,3,  3,2,1,3, 3,2,3,1);
		IFSeqTmHat.stGrp  (1);
		IFSeqDurHat.stGrp  (4);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctBass.stGrpSet (2,3,3,3, 2,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 4,0,3,2);
		IFSeqVelBass.stGrpSet (2,3,1,2, 2,3,0,2,  2,3,0,2, 2,3,1,2);
		IFSeqSusBass.stGrpSet (3,0,1,0, 0,0,1,0,  2,0,1,0, 3,3,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadBass(0,2,0,4,1,3,0,5,2);
		~lfo1Bass.source  =  Pseq([0,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.05);
		~local.sendMsg('lfoMulBass2',0.1);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,1,0,1, 0,0,1,0,  0,1,1,0, 0,1,1,0);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 4,0,3,2);
		IFSeqVelKeys.stGrpSet (4,3,3,2, 3,2,3,2,  5,3,3,2, 5,2,3,0);
		IFSeqSusKeys.stGrpSet (5,3,2,0, 4,3,4,5,  3,3,2,0, 5,2,3,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,2,1,1, 1,2,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,2,4,4, 4,2,4,4);
		IFShuf.loadKeys(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulKeys1',0.2);
		~local.sendMsg('lfoMulKeys2',0.1);
		~lfoRtKeys.source =  Pseq([120,40,40,10,20,110,90,10], inf);
		~lfoCtKeys.source =  Pseq([0,20,90,50,0,40,90,70], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSamp.stGrpSet (3,3,3,4, 3,3,3,4,  3,3,3,4, 3,3,3,4);
		IFSeqNtSamp.stGrpSet  (0,-1,-2,3, 4,0,6,0,  0,-1,-2,5, 0,3,0,0);
		IFSeqVelSamp.stGrpSet (0,3,0,3, 0,3,0,3,  0,3,0,3, 0,3,0,3);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadSamp(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulSamp1',0.65);
		~local.sendMsg('lfoMulSamp2',0.45);
		~lfo1Samp.source  =  Pseq([90,1,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 0,1,1,1,  0,1,1,1, 1,0,1,0);
		IFSeqOctMopho.stGrpSet (4,4,4,3, 3,4,5,4,  4,4,5,4, 4,4,4,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,1, 0,1,0,1,  0,1,0,1, 1,0,3,1);
		IFSeqVelMopho.stGrpSet (4,3,0,3, 3,3,0,3,  0,3,0,3, 4,3,0,3);
		IFSeqSusMopho.stGrpSet (0,0,1,0, 4,0,1,0,  4,0,1,0, 0,3,0,5);
		IFSeqTmMopho.stGrpSet  (1,1,1,2, 1,1,1,2,  1,1,2,1, 2,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadMopho(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulMopho1',0.25);
		~local.sendMsg('lfoMulMopho2',0.35);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);
	}//////                                      - 4 -

	*part05{
		"part05".postln; ~tOSCAdrr.sendMsg('partLabel', 'T1prt05');
		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		~octVKick=0;~ntVKick.source = Pseq([1], inf);
		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~ntVSnr.source = Pseq([16], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,0,1,0);
		~ntVHat.source = Pseq([125], inf);
		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVClap.stGrpSet  (0,0,1,0, 0,0,1,1,  0,0,0,0, 1,0,0,0);
		//~ntVClap.source = Pseq([39], inf);
		//~durVClap.source  =  Pseq([1/2], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

		//CH -1- [ Kick ]
		IFSeqKick.stGrpSet    (0,0,0,1, 0,0,0,1, 0,0,0,1, 0,0,1,1);
		IFSeqOctKick.stGrpSet (2,1,2,1, 2,1,2,1, 2,1,2,1, 2,1,2,1);
		IFSeqNtKick.stGrpSet  (0,0,4,9, 0,0,4,0,  0,0,4,9, 0,0,4,9);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (0,2,0,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);

		IFSeqKick2.stGrpSet    (0,1,0,0, 1,0,0,0,  1,0,1,0, 0,1,0,0);
		IFSeqNtKick2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelKick2.stGrpSet (1,2,1,3, 1,2,1,2,  1,2,1,3, 1,2,1,2);
		IFSeqSusKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,5,2);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,0,0,0, 0,1,1,0,  0,0,1,0, 0,1,1,0);
		IFSeqNtSnr.stGrpSet   (4,1,2,3, 4,1,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,3,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,1,1,1,  1,1,2,1, 1,1,1,1);
		IFSeqDurSnr.stGrp     (4);
		IFSeqSnr2.stGrpSet    (0,0,0,1, 0,0,0,1,  0,1,0,0, 0,1,1,0);
		IFSeqNtSnr2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqNtHat.stGrpSet  (1,0,0,0, 1,0,0,0,  1,0,3,0, 0,1,2,3);
		IFSeqVelHat.stGrpSet (3,2,3,1, 1,3,3,1,  1,3,3,1, 3,2,3,0);
		IFSeqSusHat.stGrpSet (3,2,1,3, 3,2,1,3,  3,2,1,3, 3,2,3,1);
		IFSeqTmHat.stGrp  (1);
		IFSeqDurHat.stGrp  (4);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctBass.stGrpSet (2,3,3,3, 2,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 4,0,3,2);
		IFSeqVelBass.stGrpSet (2,3,1,2, 2,3,0,2,  2,3,0,2, 2,3,1,2);
		IFSeqSusBass.stGrpSet (3,0,1,0, 0,0,1,0,  2,0,1,0, 3,3,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadBass(0,2,0,4,1,3,0,5,2);
		~lfo1Bass.source  =  Pseq([0,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.05);
		~local.sendMsg('lfoMulBass2',0.1);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,1,0,1, 0,0,1,0,  0,1,1,0, 0,1,1,0);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 4,0,3,2);
		IFSeqVelKeys.stGrpSet (4,3,3,2, 3,2,3,2,  5,3,3,2, 5,2,3,0);
		IFSeqSusKeys.stGrpSet (5,3,2,0, 4,3,4,5,  3,3,2,0, 5,2,3,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,2,1,1, 1,2,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,2,4,4, 4,2,4,4);
		IFShuf.loadKeys(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulKeys1',0.2);
		~local.sendMsg('lfoMulKeys2',0.1);
		~lfoRtKeys.source =  Pseq([120,40,40,10,20,110,90,10], inf);
		~lfoCtKeys.source =  Pseq([0,20,90,50,0,40,90,70], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSamp.stGrpSet (3,3,3,4, 3,3,3,4,  3,3,3,4, 3,3,3,4);
		IFSeqNtSamp.stGrpSet  (0,-1,-2,3, 4,0,6,0,  0,-1,-2,5, 0,3,0,0);
		IFSeqVelSamp.stGrpSet (0,3,0,3, 0,3,0,3,  0,3,0,3, 0,3,0,3);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadSamp(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulSamp1',0.65);
		~local.sendMsg('lfoMulSamp2',0.45);
		~lfo1Samp.source  =  Pseq([90,1,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 0,1,1,1,  0,1,1,1, 1,0,1,0);
		IFSeqOctMopho.stGrpSet (4,4,4,3, 3,4,5,4,  4,4,5,4, 4,4,4,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,1, 0,1,0,1,  0,1,0,1, 1,0,3,1);
		IFSeqVelMopho.stGrpSet (4,3,0,3, 3,3,0,3,  0,3,0,3, 4,3,0,3);
		IFSeqSusMopho.stGrpSet (0,0,1,0, 4,0,1,0,  4,0,1,0, 0,3,0,5);
		IFSeqTmMopho.stGrpSet  (1,1,1,2, 1,1,1,2,  1,1,2,1, 2,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadMopho(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulMopho1',0.25);
		~local.sendMsg('lfoMulMopho2',0.35);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);
	}//////                                      - 5 -

	*part06{
		"part06".postln; ~tOSCAdrr.sendMsg('partLabel', 'T1prt06');
		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		~octVKick=0;~ntVKick.source = Pseq([1], inf);
		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~ntVSnr.source = Pseq([16], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,0,1,0);
		~ntVHat.source = Pseq([125], inf);
		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVClap.stGrpSet  (0,0,1,0, 0,0,1,1,  0,0,0,0, 1,0,0,0);
		//~ntVClap.source = Pseq([39], inf);
		//~durVClap.source  =  Pseq([1/2], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

		//CH -1- [ Kick ]
		IFSeqKick.stGrpSet    (0,0,0,1, 0,0,0,1, 0,0,0,1, 0,0,1,1);
		IFSeqOctKick.stGrpSet (2,1,2,1, 2,1,2,1, 2,1,2,1, 2,1,2,1);
		IFSeqNtKick.stGrpSet  (0,0,4,9, 0,0,4,0,  0,0,4,9, 0,0,4,9);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (0,2,0,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);

		IFSeqKick2.stGrpSet    (0,1,0,0, 1,0,0,0,  1,0,1,0, 0,1,0,0);
		IFSeqNtKick2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelKick2.stGrpSet (1,2,1,3, 1,2,1,2,  1,2,1,3, 1,2,1,2);
		IFSeqSusKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,5,2);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,0,0,0, 0,1,1,0,  0,0,1,0, 0,1,1,0);
		IFSeqNtSnr.stGrpSet   (4,1,2,3, 4,1,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,3,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,1,1,1,  1,1,2,1, 1,1,1,1);
		IFSeqDurSnr.stGrp     (4);
		IFSeqSnr2.stGrpSet    (0,0,0,1, 0,0,0,1,  0,1,0,0, 0,1,1,0);
		IFSeqNtSnr2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqNtHat.stGrpSet  (1,0,0,0, 1,0,0,0,  1,0,3,0, 0,1,2,3);
		IFSeqVelHat.stGrpSet (3,2,3,1, 1,3,3,1,  1,3,3,1, 3,2,3,0);
		IFSeqSusHat.stGrpSet (3,2,1,3, 3,2,1,3,  3,2,1,3, 3,2,3,1);
		IFSeqTmHat.stGrp  (1);
		IFSeqDurHat.stGrp  (4);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctBass.stGrpSet (2,3,3,3, 2,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 4,0,3,2);
		IFSeqVelBass.stGrpSet (2,3,1,2, 2,3,0,2,  2,3,0,2, 2,3,1,2);
		IFSeqSusBass.stGrpSet (3,0,1,0, 0,0,1,0,  2,0,1,0, 3,3,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadBass(0,2,0,4,1,3,0,5,2);
		~lfo1Bass.source  =  Pseq([0,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.05);
		~local.sendMsg('lfoMulBass2',0.1);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,1,0,1, 0,0,1,0,  0,1,1,0, 0,1,1,0);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 4,0,3,2);
		IFSeqVelKeys.stGrpSet (4,3,3,2, 3,2,3,2,  5,3,3,2, 5,2,3,0);
		IFSeqSusKeys.stGrpSet (5,3,2,0, 4,3,4,5,  3,3,2,0, 5,2,3,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,2,1,1, 1,2,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,2,4,4, 4,2,4,4);
		IFShuf.loadKeys(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulKeys1',0.2);
		~local.sendMsg('lfoMulKeys2',0.1);
		~lfoRtKeys.source =  Pseq([120,40,40,10,20,110,90,10], inf);
		~lfoCtKeys.source =  Pseq([0,20,90,50,0,40,90,70], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSamp.stGrpSet (3,3,3,4, 3,3,3,4,  3,3,3,4, 3,3,3,4);
		IFSeqNtSamp.stGrpSet  (0,-1,-2,3, 4,0,6,0,  0,-1,-2,5, 0,3,0,0);
		IFSeqVelSamp.stGrpSet (0,3,0,3, 0,3,0,3,  0,3,0,3, 0,3,0,3);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadSamp(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulSamp1',0.65);
		~local.sendMsg('lfoMulSamp2',0.45);
		~lfo1Samp.source  =  Pseq([90,1,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 0,1,1,1,  0,1,1,1, 1,0,1,0);
		IFSeqOctMopho.stGrpSet (4,4,4,3, 3,4,5,4,  4,4,5,4, 4,4,4,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,1, 0,1,0,1,  0,1,0,1, 1,0,3,1);
		IFSeqVelMopho.stGrpSet (4,3,0,3, 3,3,0,3,  0,3,0,3, 4,3,0,3);
		IFSeqSusMopho.stGrpSet (0,0,1,0, 4,0,1,0,  4,0,1,0, 0,3,0,5);
		IFSeqTmMopho.stGrpSet  (1,1,1,2, 1,1,1,2,  1,1,2,1, 2,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadMopho(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulMopho1',0.25);
		~local.sendMsg('lfoMulMopho2',0.35);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);
	}//////                                      - 6 -

	*part07{//////                                      - 7 -
		//IFTrack07.setActs;
		"part07".postln;~tOSCAdrr.sendMsg('partLabel', 'T1prt07');

		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		~octVKick=0;~ntVKick.source = Pseq([1], inf);
		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~ntVSnr.source = Pseq([16], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,0,1,0);
		~ntVHat.source = Pseq([125], inf);
		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVClap.stGrpSet  (0,0,1,0, 0,0,1,1,  0,0,0,0, 1,0,0,0);
		//~ntVClap.source = Pseq([39], inf);
		//~durVClap.source  =  Pseq([1/2], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

		//CH -1- [ Kick ]
		IFSeqKick.stGrpSet    (0,1,0,1, 0,0,0,1, 0,0,0,1, 1,0,1,1);
		IFSeqOctKick.stGrpSet (2,1,2,1, 2,1,2,1, 2,1,2,1, 2,1,2,1);
		IFSeqNtKick.stGrpSet  (0,0,4,9, 0,0,4,0,  0,0,4,9, 0,0,4,9);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (0,2,0,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFSeqKick2.stGrpSet    (0,1,0,1, 1,0,1,0,  1,0,1,1, 0,1,1,0);
		IFSeqNtKick2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,0,0,0, 0,1,1,0,  0,0,1,0, 0,1,1,0);
		IFSeqNtSnr.stGrpSet   (4,1,2,3, 4,1,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,3,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,1,1,1,  1,1,2,1, 1,1,1,1);
		IFSeqDurSnr.stGrp     (4);
		IFSeqSnr2.stGrpSet    (0,0,0,0, 0,0,1,0,  0,0,0,0, 0,1,1,0);
		IFSeqNtSnr2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqNtHat.stGrpSet  (1,0,0,0, 1,0,0,0,  3,0,0,0, 4,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,1, 1,3,3,1,  1,3,3,1, 3,2,3,0);
		IFSeqSusHat.stGrpSet (3,2,1,3, 3,2,1,3,  3,2,1,3, 3,2,3,1);
		IFSeqTmHat.stGrp  (1);
		IFSeqDurHat.stGrp  (4);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctBass.stGrpSet (2,3,3,3, 2,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 4,0,3,2);
		IFSeqVelBass.stGrpSet (2,3,1,2, 2,3,0,2,  2,3,0,2, 2,3,1,2);
		IFSeqSusBass.stGrpSet (3,0,1,0, 0,0,1,0,  2,0,1,0, 3,3,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadBass(0,2,0,4,1,3,0,5,2);
		~lfo1Bass.source  =  Pseq([0,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.00);
		~local.sendMsg('lfoMulBass2',0.00);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,1,0,1, 0,0,1,0,  0,1,1,0, 0,1,1,0);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,3,-1,0, 0,3,-1,0,  0,-1,-2,0, 0,3,0,0);
		IFSeqVelKeys.stGrpSet (4,3,3,2, 3,2,3,2,  5,3,3,2, 5,2,3,0);
		IFSeqSusKeys.stGrpSet (5,3,2,0, 4,3,4,5,  3,3,2,0, 5,2,3,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,2,1,1, 1,2,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,2,4,4, 4,2,4,4);
		~local.sendMsg('lfoMulKeys1',0.0);
		~local.sendMsg('lfoMulKeys2',0.01);
		~lfoRtKeys.source =  Pseq([120,40,40,10,20,110,90,10], inf);
		~lfoCtKeys.source =  Pseq([0,20,90,50,0,40,90,70], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSamp.stGrpSet (3,3,3,4, 3,3,3,4,  3,3,3,4, 3,3,3,4);
		IFSeqNtSamp.stGrpSet  (0,-1,-2,3, 4,0,6,0,  0,-1,-2,5, 0,3,0,0);
		IFSeqVelSamp.stGrpSet (0,3,0,3, 0,3,0,3,  0,3,0,3, 0,3,0,3);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~local.sendMsg('lfoMulSamp1',0.6);
		~local.sendMsg('lfoMulSamp2',0.4);
		~lfo1Samp.source  =  Pseq([90,1,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 0,1,1,1,  0,1,1,1, 1,0,1,0);
		IFSeqOctMopho.stGrpSet (4,4,4,3, 3,4,5,4,  4,4,5,4, 4,4,4,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,1, 0,1,0,1,  0,1,0,1, 1,0,3,1);
		IFSeqVelMopho.stGrpSet (4,3,0,3, 3,3,0,3,  0,3,0,3, 4,3,0,3);
		IFSeqSusMopho.stGrpSet (0,0,1,0, 4,0,1,0,  4,0,1,0, 0,3,0,5);
		IFSeqTmMopho.stGrpSet  (1,1,1,2, 1,1,1,2,  1,1,2,1, 2,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadMopho(0,2,0,3,2,-1,2,0,4);
		~local.sendMsg('lfoMulMopho1',0.2);
		~local.sendMsg('lfoMulMopho2',0.3);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);


	}//////                                      - 7 -

	*part08{//////                                      - 1 -
		//IFTrack01.setActs;
		"part01".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt01');

		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		~octVKick=0;~ntVKick.source = Pseq([1], inf);
		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~ntVSnr.source = Pseq([16], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,0,1,0);
		~ntVHat.source = Pseq([125], inf);
		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVClap.stGrpSet  (0,0,1,0, 0,0,1,1,  0,0,0,0, 1,0,0,0);
		//~ntVClap.source = Pseq([39], inf);
		//~durVClap.source  =  Pseq([1/2], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

		//CH -1- [ Kick ]
		IFSeqKick.stGrpSet    (0,1,0,1, 0,0,0,1, 0,0,0,1, 1,0,1,1);
		IFSeqOctKick.stGrpSet (2,1,2,1, 2,1,2,1, 2,1,2,1, 2,1,2,1);
		IFSeqNtKick.stGrpSet  (0,0,4,9, 0,0,4,0,  0,0,4,9, 0,0,4,9);
		IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
		IFSeqSusKick.stGrpSet (0,2,0,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFSeqKick2.stGrpSet    (0,1,0,1, 1,0,1,0,  1,0,1,1, 0,1,1,0);
		IFSeqNtKick2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,0,0,0, 0,1,1,0,  0,0,1,0, 0,1,1,0);
		IFSeqNtSnr.stGrpSet   (4,1,2,3, 4,1,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,3,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,1,1,1,  1,1,2,1, 1,1,1,1);
		IFSeqDurSnr.stGrp     (4);
		IFSeqSnr2.stGrpSet    (0,0,0,0, 0,0,1,0,  0,0,0,0, 0,1,1,0);
		IFSeqNtSnr2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqNtHat.stGrpSet  (1,0,0,0, 1,0,0,0,  3,0,0,0, 4,0,0,0);
		IFSeqVelHat.stGrpSet (3,2,3,1, 1,3,3,1,  1,3,3,1, 3,2,3,0);
		IFSeqSusHat.stGrpSet (3,2,1,3, 3,2,1,3,  3,2,1,3, 3,2,3,1);
		IFSeqTmHat.stGrp  (1);
		IFSeqDurHat.stGrp  (4);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctBass.stGrpSet (2,3,3,3, 2,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 4,0,3,2);
		IFSeqVelBass.stGrpSet (2,3,1,2, 2,3,0,2,  2,3,0,2, 2,3,1,2);
		IFSeqSusBass.stGrpSet (3,0,1,0, 0,0,1,0,  2,0,1,0, 3,3,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadBass(0,2,0,4,1,3,0,5,2);
		~lfo1Bass.source  =  Pseq([0,90,70,18, 0,10,60,20], inf);
		~lfo2Bass.source  =  Pseq([0,20,30,50, 0,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.3);
		~local.sendMsg('lfoMulBass2',0.2);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,1,0,1, 0,0,1,0,  0,1,1,0, 0,1,1,0);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,3,-1,0, 0,3,-1,0,  0,-1,-2,0, 0,3,0,0);
		IFSeqVelKeys.stGrpSet (4,3,3,2, 3,2,3,2,  5,3,3,2, 5,2,3,0);
		IFSeqSusKeys.stGrpSet (5,3,2,0, 4,3,4,5,  3,3,2,0, 5,2,3,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,2,1,1, 1,2,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,2,4,4, 4,2,4,4);
		~local.sendMsg('lfoMulKeys1',0.3);
		~local.sendMsg('lfoMulKeys2',0.4);
		~lfoRtKeys.source =  Pseq([120,40,40,10,20,110,90,10], inf);
		~lfoCtKeys.source =  Pseq([0,20,90,50,0,40,90,70], inf);
		//CH -6- [SAMP]
		IFSeqSamp.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctSamp.stGrpSet (3,3,3,4, 3,3,3,4,  3,3,3,4, 3,3,3,4);
		IFSeqNtSamp.stGrpSet  (0,-1,-2,3, 4,0,6,0,  0,-1,-2,5, 0,3,0,0);
		IFSeqVelSamp.stGrpSet (0,3,0,3, 0,3,0,3,  0,3,0,3, 0,3,0,3);
		IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		~local.sendMsg('lfoMulSamp1',0.6);
		~local.sendMsg('lfoMulSamp2',0.7);
		~lfo1Samp.source  =  Pseq([90,1,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 0,1,1,1,  0,1,1,1, 1,0,1,0);
		IFSeqOctMopho.stGrpSet (4,4,4,3, 3,4,5,4,  4,4,5,4, 4,4,4,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,1, 0,1,0,1,  0,1,0,1, 1,0,3,1);
		IFSeqVelMopho.stGrpSet (4,3,0,3, 3,3,0,3,  0,3,0,3, 4,3,0,3);
		IFSeqSusMopho.stGrpSet (0,0,1,0, 4,0,1,0,  4,0,1,0, 0,3,0,5);
		IFSeqTmMopho.stGrpSet  (1,1,1,2, 1,1,1,2,  1,1,2,1, 2,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.loadMopho(0,2,0,3,2,-1,2,0,4);
		~local.sendMsg('lfoMulMopho1',0.2);
		~local.sendMsg('lfoMulMopho2',0.3);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.8);
		~local.sendMsg('rlsExt',0.8);
		~local.sendMsg('extSends',0.5,0.6);


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
				IFAPCMn.tsLeds(1,0,0,0,0,0,0,0);
			});
		},srcID:~apcMnInID, chan:0, noteNum:~tsBut1);
		~apc_TS02.free;
		~apc_TS02=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=2;
				IFTrack01.part02;
				IFAPCMn.tsLeds(0,1,0,0,0,0,0,0);
			});
		},srcID:~apcMnInID, chan:0, noteNum:~tsBut2);
		~apc_TS03.free;
		~apc_TS03=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=3;
				IFTrack01.part03;
				IFAPCMn.tsLeds(0,0,1,0,0,0,0,0);
			});
		},srcID:~apcMnInID, chan:0, noteNum:~tsBut3);
		~apc_TS04.free;
		~apc_TS04=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=4;
				IFTrack01.part04;
				IFAPCMn.tsLeds(0,0,0,1,0,0,0,0);
			});
		},srcID:~apcMnInID, chan:0, noteNum:~tsBut4);
		~apc_TS05.free;
		~apc_TS05=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=5;
				IFTrack01.part05;
				IFAPCMn.tsLeds(0,0,0,0,1,0,0,0);
			});
		},srcID:~apcMnInID, chan:0, noteNum:~tsBut5);
		~apc_TS06.free;
		~apc_TS06=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=6;
				IFTrack01.part06;
				IFAPCMn.tsLeds(0,0,0,0,0,1,0,0);
			});
		},srcID:~apcMnInID, chan:0, noteNum:~tsBut6);
		~apc_TS07.free;
		~apc_TS07=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=7;
				IFTrack01.part07;
				IFAPCMn.tsLeds(0,0,0,0,0,0,1,0);
			});
		},srcID:~apcMnInID, chan:0, noteNum:~tsBut7);
		~apc_TS08.free;
		~apc_TS08=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				~partCase=8;
				IFTrack01.part08;
				IFAPCMn.tsLeds(0,0,0,0,0,0,0,1);
			});
		},srcID:~apcMnInID, chan:0, noteNum:~tsBut8);

	}//apcParts

	*apcActs{

	}//apcActs
	*lpMnParts {//Parts 1-8 //Presets 9-16


		~lpMn_TS01.free;
		~lpMn_TS01=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=1;
				IFTrack01.part01;
				IFLpMn.tsLeds(1,0,0,0,0,0,0,0);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH1);
		~lpMn_TS02.free;
		~lpMn_TS02=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=2;
				IFTrack01.part02;
				IFLpMn.tsLeds(0,1,0,0,0,0,0,0);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH2);
		~lpMn_TS03.free;
		~lpMn_TS03=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=3;
				IFTrack01.part03;
				IFLpMn.tsLeds(0,0,1,0,0,0,0,0);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH3);
		~lpMn_TS04.free;
		~lpMn_TS04=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=4;
				IFTrack01.part04;
				IFLpMn.tsLeds(0,0,0,1,0,0,0,0);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH4);
		~lpMn_TS05.free;
		~lpMn_TS05=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=5;
				IFTrack01.part05;
				IFLpMn.tsLeds(0,0,0,0,1,0,0,0);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH5);
		~lpMn_TS06.free;
		~lpMn_TS06=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=6;
				IFTrack01.part06;
				IFLpMn.tsLeds(0,0,0,0,0,1,0,0);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH6);
		~lpMn_TS07.free;
		~lpMn_TS07=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=7;
				IFTrack01.part07;
				IFLpMn.tsLeds(0,0,0,0,0,0,1,0);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH7);
		~lpMn_TS08.free;
		~lpMn_TS08=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=8;
				IFTrack01.part08;
				IFLpMn.tsLeds(0,0,0,0,0,0,0,1);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH8);

	}//lpMnParts

}