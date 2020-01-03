IFTracks{
	*load {
		this.globals;
		this.loadLists;
		this.makeOSCResponders;
	}

	*globals{
		~trkPreNum=1;

	}
	*loadLists{
		~trkLst = [\00,\01,\02,\03,\04,\05,\06,\07,\08,\09,\10,\11,\12];
	}
	*lbl{|key,val1=0|
		~tOSCAdrr.sendMsg(key,val1);
	}
	*num{|nm|
		~trkPreNum=nm;
	}
	*set{|key,val|
		var vel, valNew;
		vel=val*127;
		key.switch(
			\dflt,{
				if ( val==1, {
					fork{
						"Random The System (make dflt) ".postln;
						IFTxt.trckDflt;
						0.1.wait;
						IFTxtStat.makeDflt;
						0.1.wait;
						IFTxtKick.makeDflt;
						0.1.wait;
						IFTxtSnr.makeDflt;
						0.1.wait;
						IFTxtHat.makeDflt;
						0.1.wait;
						IFTxtBass.makeDflt;
						0.1.wait;
						IFTxtMopho.makeDflt;
						0.1.wait;
						IFTxtKeys.makeDflt;
						0.1.wait;
						IFTxtSamp.makeDflt;
						//IFTxtMophoSet.makeDflt;
						this.lbl(\IFtrkLblPre,~trkPreNum);
						0.1.wait;
						"IFTxt Instrument Values".postln;
						0.1.wait;
						IFTrack.load(\00,\01);
						0.1.wait;
						IFTrack(\00,\01);

					};
				});
			},
			\fwd,{
				if ( val==1, {
					~trkPreNum=~trkPreNum+1;
					this.num(~trkPreNum);
					this.lbl(\IFtrkLblPre,~trkPreNum);
				});
			},
			\rwd,{
				if ( val==1, {
					~trkPreNum=~trkPreNum-1;
					this.num(~trkPreNum);
					this.lbl(\IFtrkLblPre,~trkPreNum);
				});
			},
			\load,{
				if ( val==1, {
					~trkPreNum.postln;
					this.lbl(\IFtrkLbl,~trkPreNum);
					~trackCase=~trkLst[~trkPreNum];
					IFTrack.load(~trkLst[~trkPreNum],\01);
					IFTrack(~trkLst[~trkPreNum],\01);
				});
			},
		);
	}
	*oscResp{|respName,oscName,playTag|
		OSCdef(respName, {|msg|
			var val, val1,val2;
			val= msg[1];
			val1= msg[1];
			val2= msg[2];
			playTag.switch(
				'mkDflt_T', { this.set(\dflt,val);},
				'trkFwd_T', { this.set(\fwd,val);},
				'trkRwd_T', { this.set(\rwd,val);},
				'trkLoad_T', { this.set(\load,val);},

			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\mkDfltResp, oscName:\IFmkDflt, playTag:'mkDflt_T');
		this.oscResp(respName:\trkFwdResp, oscName:\IFtrkFwd, playTag:'trkFwd_T');
		this.oscResp(respName:\trkRwdResp, oscName:\IFtrkRwd, playTag:'trkRwd_T');
		this.oscResp(respName:\trkLoadResp, oscName:\IFtrkLoad, playTag:'trkLoad_T');

	}

}
/*
~track1.fork;
*/

IFTrack{
	*load{|trk,prt|
		~trackCase=trk;
		IFTxt.readGlbStrt(trk,prt);
		IFTxt.readFx(trk,prt);
		IFTxtKick.read(trk,prt);
		IFTxtSnr.read(trk,prt);
		IFTxtHat.read(trk,prt);
		IFTxtKeys.read(trk,prt);
		IFTxtMopho.read(trk,prt);
		IFTxtBass.read(trk,prt);
		IFTxtStat.read(trk,prt);
		trk.switch(
			\00, {
				"TRACK 0".postln;
				~tOSCAdrr.sendMsg('trackLabel','TRACK 0');

			},
			\01, {
				"TRACK 1".postln;
				~tOSCAdrr.sendMsg('trackLabel','TRACK 1');

				/*IFAPCMn.actLine1(1,0,0,0);IFAPCMn.actLine2(1,0,0,0);IFAPCMn.actLine3(1,0,0,0);
				IFAPCMn.actLine4(1,0,0,0);IFAPCMn.actLine5(1,0,0,0);IFAPCMn.actLine6(1,0,0,0);
				IFAPCMn.actLine7(1,0,0,0);IFAPCMn.actLine8(1,0,0,0);

				IFMelMix.act1(1,0,0);IFMelMix.act2(0,0,0);IFMelMix.act3(0,0,0);
				IFMelMix.act4(0,0,0);IFMelMix.act5(0,0,0);IFMelMix.act6(0,0,0);
				IFMelMix.act7(1,0,0);IFMelMix.act8(1,0,0);

				IFMIDIMix.act1(1,0,0);IFMIDIMix.act2(0,0,0);IFMIDIMix.act3(0,0,0);IFMIDIMix.act4(0,0,0);
				IFMIDIMix.act5(0,0,0);IFMIDIMix.act6(0,0,0);IFMIDIMix.act7(0,0,0);IFMIDIMix.act8(0,0,0);*/
			},
			\02, {
				"TRACK 2".postln;
				~tOSCAdrr.sendMsg('trackLabel','TRACK 2');

			},
			\03, {
				"TRACK 3".postln;
				~tOSCAdrr.sendMsg('trackLabel','TRACK 3');


			},
			\04, {
				"TRACK 4".postln;
				~tOSCAdrr.sendMsg('trackLabel','TRACK 4');


			},
			\05, {
				"TRACK 4".postln;
				~tOSCAdrr.sendMsg('trackLabel','TRACK 5');


			},
		);
	}

	*new{|trk,prt|

		~partCase=prt;

		IFTxt.readGlbl(trk,\01,prt);


		prt.switch(
			\00, {

			},
			\01, {

			},
			\02, {

			},
		);
	}

}
