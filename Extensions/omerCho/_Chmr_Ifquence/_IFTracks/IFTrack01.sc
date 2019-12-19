/*

PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

Mopho.cc(\tempo,tmp);

*/

IFTrack01 {
	*loadAtStart{
		~trackCase=1;
		IFLpMn.tsLeds(1,0,0,0,0,0,0,0);
		//IFRoot.set00;
		IFTrack01.setGlb01;
		IFTrack01.setActs;
		//this.lpMnParts;
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
	}

	*setActs{
		IFAPCMn.actLine1(1,0,0,0);
		IFAPCMn.actLine2(1,0,0,0);
		IFAPCMn.actLine3(1,0,0,0);
		IFAPCMn.actLine4(1,0,0,0);
		IFAPCMn.actLine5(1,0,0,0);
		IFAPCMn.actLine6(1,0,0,0);
		IFAPCMn.actLine7(1,0,0,0);
		IFAPCMn.actLine8(1,0,0,0);

		IFMelMix.act1(1,0,0);
		IFMelMix.act2(1,0,0);
		IFMelMix.act3(1,0,0);
		IFMelMix.act4(1,0,0);
		IFMelMix.act5(1,0,0);
		IFMelMix.act6(1,0,0);
		IFMelMix.act7(1,0,0);
		IFMelMix.act8(1,0,0);

		IFMIDIMix.act1(0,0,0);
		IFMIDIMix.act2(0,0,0);
		IFMIDIMix.act3(0,0,0);
		IFMIDIMix.act4(0,0,0);
		IFMIDIMix.act5(0,0,0);
		IFMIDIMix.act6(0,0,0);
		IFMIDIMix.act7(0,0,0);
		IFMIDIMix.act8(0,0,0);



	}//setActs
	*setGlb01{
		"TRACK 1".postln;
		~tOSCAdrr.sendMsg('trackLabel','TRACK 1');


		this.part01;

		/*~local.sendMsg('cutDrum',0.2, 0.3);
		~local.sendMsg('susDrum',0.3);
		~local.sendMsg('snrXPose',0.3);//SnrXpose*/

	}

	*part01{//////                                      - 1 -
		//IFTrack01.setActs;
		"Track:01 - Part:01".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt01');
		~partCase=1;
		IFTxt.readGlbStrt(\01,\01);
		IFTxt.readGlbl(\01,\01);
		IFTxt.readFx(\01,\01);
		IFTxtStat.read(\01,\01);
		IFTxtKick.read(\01,\01);
		IFTxtSnr.read(\01,\01);
		IFTxtHat.read(\01,\01);
		IFTxtBass.read(\01,\01);
		IFTxtMopho.read(\01,\01);
		IFTxtKeys.read(\01,\01);
		IFTxtSamp.read(\01,\01);
	}//////                                             - 1 -
	*part02{//////                                      - 2 -
		"Track:01 - Part:02".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt02');
		~partCase=2;
		IFTxt.readGlbl(\01,\02);
		IFTxt.readFx(\01,\02);
		IFTxtStat.read(\01,\02);
		IFTxtKick.read(\01,\02);
		IFTxtSnr.read(\01,\02);
		IFTxtHat.read(\01,\02);
		IFTxtBass.read(\01,\02);
		IFTxtMopho.read(\01,\02);
		IFTxtKeys.read(\01,\02);
		IFTxtSamp.read(\01,\02);
	}//////                                             - 2 -
	*part03{//////                                      - 3 -
		"Track:01 - Part:03".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt03');
		~partCase=3;
		IFTxt.readGlbl(\01,\03);
		IFTxt.readFx(\01,\03);
		IFTxtStat.read(\01,\03);
		IFTxtKick.read(\01,\03);
		IFTxtSnr.read(\01,\03);
		IFTxtHat.read(\01,\03);
		IFTxtBass.read(\01,\03);
		IFTxtMopho.read(\01,\03);
		IFTxtKeys.read(\01,\03);
		IFTxtSamp.read(\01,\03);
	}//////                                             - 3 -
	*part04{//////                                      - 4 -
		"Track:01 - Part:03".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt03');
		~partCase=3;
		IFTxt.readGlbl(\01,\03);
		IFTxt.readFx(\01,\03);
		IFTxtStat.read(\01,\03);
		IFTxtKick.read(\01,\03);
		IFTxtSnr.read(\01,\03);
		IFTxtHat.read(\01,\03);
		IFTxtBass.read(\01,\03);
		IFTxtMopho.read(\01,\03);
		IFTxtKeys.read(\01,\03);
		IFTxtSamp.read(\01,\03);
	}//////                                             - 4 -
	*part05{//////                                      - 5 -

	}//////                                             - 5 -
	*part06{//////                                      - 6 -
		//IFTxtMophoSet.read(\01,\00);
	}//////                                             - 6 -
	*part07{//////                                      - 7 -
		"Trck1_Prt7_RNDM".postln;
		~tOSCAdrr.sendMsg('partLabel', 'Trck1_Prt7_RNDM');

		IFTxt.readGlbStrt(\01,\00);
		IFTxt.readGlbl(\01,\00);
		IFTxt.readInst(\01,\00);
		IFTxtStat.read(\01,\00);
		IFTxtKick.read(\01,\00);
		IFTxtSnr.read(\01,\00);
		IFTxtHat.read(\01,\00);
		IFTxtBass.read(\01,\00);
		IFTxtMopho.read(\01,\00);
		IFTxtKeys.read(\01,\00);
		IFTxtSamp.read(\01,\00);
		IFTxt.readFx(\01,\00);
	}//////                                      - 7 -

	*part08{//////                               - 8 -
		//IFTrack01.setActs;
		//"part8".postln;
		//~tOSCAdrr.sendMsg('partLabel', 'T1prt08');

	}//////                                      - 8 -


}

/*


*/