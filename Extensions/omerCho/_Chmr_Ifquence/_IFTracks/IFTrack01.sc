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
		this.setGlb01;
		this.setActs;
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
		IFAPCMn.actLine1(1,0,0,0,0);
		IFAPCMn.actLine2(1,0,0,0,0);
		IFAPCMn.actLine3(1,0,0,0,0);
		IFAPCMn.actLine4(1,0,0,0,0);
		IFAPCMn.actLine5(1,0,0,0,0);
		IFAPCMn.actLine6(1,0,0,0,0);
		IFAPCMn.actLine7(0,0,0,0,0);
		IFAPCMn.actLine8(0,0,0,0,0);

		IFMIDIMix.act1(1,0,0);
		IFMIDIMix.act2(1,0,0);
		IFMIDIMix.act3(1,0,0);
		IFMIDIMix.act4(0,0,0);
		IFMIDIMix.act5(0,0,0);
		IFMIDIMix.act6(0,0,0);
		IFMIDIMix.act7(0,0,0);
		IFMIDIMix.act8(0,0,0);

	}//setActs
	*setGlb01{
		"TRACK 1".postln;
		~tOSCAdrr.sendMsg('trackLabel','TRACK 1');
		IFTxt.readGlbStrt(trck:\01,prtDir:\01);
		IFTxt.readGlbl(trck:\01,prtDir:\01,prt:1);
		IFTxt.readFx(trck:\01,prtDir:\01,prt:1);
		IFTxtStat.read(\01,\01);
		IFTxtKick.read(\01,\01);
		IFTxtSnr.read(\01,\01);
		IFTxtHat.read(\01,\01);
		IFTxtBass.read(\01,\01);
		IFTxtMopho.read(\01,\01);
		IFTxtKeys.read(\01,\01);
		IFTxtSamp.read(\01,\01);

		~local.sendMsg('cutDrum',0.2, 0.3);
		~local.sendMsg('susDrum',0.3);
		~local.sendMsg('snrXPose',0.3);//SnrXpose

		//this.part1;
	}//track 01 End

	*part01{//////                                      - 1 -
		//IFTrack01.setActs;
		"Track:01 - Part:01".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt01');
		IFTxt.readGlbl(trck:\01,prtDir:\01,prt:1);
		IFTxt.readFx(trck:\01,prtDir:\01,prt:1);
	}//////                                             - 1 -
	*part02{//////                                      - 2 -
		IFTxt.readGlbl(trck:\01,prtDir:\01,prt:2);
		IFTxt.readFx(trck:\01,prtDir:\01,prt:2);
	}//////                                             - 2 -
	*part03{//////                                      - 3 -
		IFTxt.readGlbl(trck:\01,prtDir:\01,prt:3);
		IFTxt.readFx(trck:\01,prtDir:\01,prt:3);
	}//////                                             - 3 -
	*part04{//////                                      - 4 -
		IFTxt.readGlbl(trck:\01,prtDir:\01,prt:4);
		IFTxt.readFx(trck:\01,prtDir:\01,prt:4);
	}//////                                             - 4 -
	*part05{//////                                      - 5 -

	}//////                                             - 5 -
	*part06{//////                                      - 6 -
		IFTxtMophoSet.read(\01,\00);
	}//////                                             - 6 -
	*part07{//////                                      - 7 -
		"Trck1_Prt7_RNDM".postln;
		~tOSCAdrr.sendMsg('partLabel', 'Trck1_Prt7_RNDM');
		IFTxt.readGlbStrt(\01,\00);
		IFTxt.readGlbl(trck:\01,prtDir:\00,prt:1);
		IFTxt.readInst(\01,\00);
		IFTxtStat.read(\01,\00);
		IFTxtKick.read(\01,\00);
		IFTxtSnr.read(\01,\00);
		IFTxtHat.read(\01,\00);
		IFTxtBass.read(\01,\00);
		IFTxtMopho.read(\01,\00);
		IFTxtKeys.read(\01,\00);
		IFTxtSamp.read(\01,\00);
		IFTxt.readFx(trck:\01,prtDir:\00,prt:1);
	}//////                                      - 7 -

	*part08{//////                               - 8 -
		//IFTrack01.setActs;
		//"part8".postln;
		//~tOSCAdrr.sendMsg('partLabel', 'T1prt08');

	}//////                                      - 8 -


}

/*


*/