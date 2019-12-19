IFTracks{
	*loadButtons{

	}

	*track1 {


	}//TRACK 1 END

	*track2 {


	}//TRACK 2 END
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
}
/*
~track1.fork;
*/

IFTrack{
	*load{|trk,prt|
		~trackCase=trk;
		IFTxt.readGlbStrt(trk,prt);
		trk.switch(
			\01, {
				"TRACK 1".postln;
				~tOSCAdrr.sendMsg('trackLabel','TRACK 1');
				//IFLpMn.tsLeds(1,0,0,0,0,0,0,0);

				IFAPCMn.actLine1(1,0,0,0);
				IFAPCMn.actLine2(1,0,0,0);
				IFAPCMn.actLine3(1,0,0,0);
				IFAPCMn.actLine4(1,0,0,0);
				IFAPCMn.actLine5(1,0,0,0);
				IFAPCMn.actLine6(1,0,0,0);
				IFAPCMn.actLine7(1,0,0,0);
				IFAPCMn.actLine8(1,0,0,0);

				IFMelMix.act1(0,0,0);
				IFMelMix.act2(0,0,0);
				IFMelMix.act3(0,0,0);
				IFMelMix.act4(0,0,0);
				IFMelMix.act5(0,0,0);
				IFMelMix.act6(0,0,0);
				IFMelMix.act7(1,0,0);
				IFMelMix.act8(1,0,0);

				IFMIDIMix.act1(1,0,0);
				IFMIDIMix.act2(0,0,0);
				IFMIDIMix.act3(0,0,0);
				IFMIDIMix.act4(0,0,0);
				IFMIDIMix.act5(0,0,0);
				IFMIDIMix.act6(0,0,0);
				IFMIDIMix.act7(0,0,0);
				IFMIDIMix.act8(0,0,0);
			},
			\02, {

			},
		);
	}

	*new{|trk,prt|

		~partCase=prt;

		IFTxt.readGlbl(trk,prt);
		IFTxt.readFx(trk,prt);

		IFTxtKick.read(trk,prt);
		IFTxtSnr.read(trk,prt);
		IFTxtHat.read(trk,prt);
		IFTxtKeys.read(trk,prt);
		IFTxtMopho.read(trk,prt);
		IFTxtBass.read(trk,prt);

		IFTxtStat.read(trk,prt);

		prt.switch(
			\01, {


			},
			\02, {

			},
		);
	}

}
