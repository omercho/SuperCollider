/*

PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

*/
IFLoad{
	*loadVolca{
		fork{
			Server.default.doWhenBooted({
				IFProjectGlobals.load;
				0.1.wait;
				IFSequence.loadAll;
				0.1.wait;
				IFCounter.zero;IFCounter.loadProxy;
				0.1.wait;
				IFCntrl.loadAll;
				0.1.wait;
				IFPitch.loadAll;
				0.1.wait;
				IFTracks.loadButtons;
				0.1.wait;
				IFPitchBass.loadAll;
				IFPitchKeys.loadAll;
				IFPitchSamp.loadAll;
				IFPitchExt.loadAll;
				IFPitchVChord.loadAll;
				0.1.wait;
				VBass.globals; VBass.preSet01; VKeys.globals; VKeys.preSet01;
				//0.1.wait;
				//VBeats.globals; VBeats.preSet01; VBeats.oscMIDI;
				//IFVKick.globals; IFVKick.preSet; IFVKick.default; IFVKick.osc;
				//IFVSnr.globals; IFVSnr.preSet; IFVSnr.default; IFVSnr.osc;
				//IFVTom.globals; IFVTom.preSet; IFVTom.default; IFVTom.osc;
				//IFVHat.globals; IFVHat.preSet; IFVHat.default; IFVHat.osc;
				0.1.wait;
				IFKick.load;
				0.1.wait;
				IFSnr.load;
				0.1.wait;
				IFHat.load;
				0.1.wait;
				IFBass.load;
				0.1.wait;
				IFKeys.load;
				0.1.wait;
				IFSamp.load;
				0.1.wait;
				IFRes1.load;
				IFMast.load;
				0.1.wait;
				IFExt.load;
				0.1.wait;
				IFRoot.load;
				0.1.wait;
				IFSeqSteps.load;
				0.1.wait;
				"Track: Not loaded".postln;
				~tOSCAdrr.sendMsg('trackLabel', 'Track: Not loaded');

			});
		};//--fork--
	}//--*loadVolca--

	*load{
		fork{
			Server.default.doWhenBooted({
				IFProjectGlobals.load;
				0.1.wait;
				IFSequence.loadAll;
				0.1.wait;
				IFCounter.zero;IFCounter.loadProxy;
				0.1.wait;
				IFCntrl.loadAll;
				0.1.wait;
				IFPitch.loadAll;
				0.1.wait;
				IFTracks.loadButtons;
				0.1.wait;
				IFPitchBass.loadAll;
				IFPitchKeys.loadAll;
				IFPitchSamp.loadAll;
				IFPitchExt.loadAll;
				IFPitchVChord.loadAll;
				0.1.wait;
				//VBass.globals; VBass.preSet01; VKeys.globals; VKeys.preSet01;
				//0.1.wait;
				//VBeats.globals; VBeats.preSet01; VBeats.oscMIDI;
				//IFVKick.globals; IFVKick.preSet; IFVKick.default; IFVKick.osc;
				//IFVSnr.globals; IFVSnr.preSet; IFVSnr.default; IFVSnr.osc;
				//IFVTom.globals; IFVTom.preSet; IFVTom.default; IFVTom.osc;
				//IFVHat.globals; IFVHat.preSet; IFVHat.default; IFVHat.osc;
				0.1.wait;
				IFKick.load;
				0.1.wait;
				IFSnr.load;
				0.1.wait;
				IFHat.load;
				0.1.wait;
				IFBass.load;
				0.1.wait;
				IFKeys.load;
				0.1.wait;
				IFSamp.load;
				0.1.wait;
				IFRes1.load;
				IFMast.load;
				0.1.wait;
				IFExt.load;
				0.1.wait;
				IFRoot.load;
				0.1.wait;
				IFSeqSteps.load;
				0.1.wait;
				"Track: Not loaded".postln;
				~tOSCAdrr.sendMsg('trackLabel', 'Track: Not loaded');

			});
		};//--fork--
	}//--*load--


}

/*
~mdOut.allNotesOff(0);
		~mdOut.allNotesOff(1);
		~mdOut.allNotesOff(2);
		~mdOut.allNotesOff(3);
		~mdOut.allNotesOff(4);
		~mdOut.allNotesOff(5);
		~mdOut.allNotesOff(6);
		~mdOut.allNotesOff(7);
		~mdOut.allNotesOff(8);
		~mdOut.allNotesOff(9);
		~mdOut.allNotesOff(10);
        ~mdOut.allNotesOff(11);
		~mdOut.allNotesOff(12);
		~mdOut.allNotesOff(13);
		~mdOut.allNotesOff(14);
		~mdOut.allNotesOff(15);
		~mdOut.allNotesOff(16);
		~vKeys.allNotesOff(11);
		~vKeys.allNotesOff(12);
		~vKeys.allNotesOff(13);
		~vKeys.allNotesOff(14);
		~vKeys.allNotesOff(15);
		~vKeys.allNotesOff(16);

*/