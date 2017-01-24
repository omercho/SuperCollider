/*
IFSequence.step(~stepNumP.next);

IFLoad.load;
IFLoad.loadVolca;
IFTracks.track1; "TRACK 1".postln;~tOSCAdrr.sendMsg('trackLabel','TRACK 1');

~dur1KickP.next;
~tmKickP.next;
~tmMulKickP.next;
~dur1SnrP.next;
~dur1HatP.next;
~dur1BassP.next;
(~tmKeysP.next;)*(~tmMulKeysP.next;)
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
				//SonicLife.load;
				0.1.wait;
				VBass.globals; VBass.preSet01; VKeys.globals; VKeys.preSet01;
				0.1.wait;
				VBeats.globals; VBeats.preSet01; VBeats.oscMIDI;
				IFVKick.globals; IFVKick.preSet; IFVKick.default; IFVKick.osc;
				IFVSnr.globals; IFVSnr.preSet; IFVSnr.default; IFVSnr.osc;
				IFVTom.globals; IFVTom.preSet; IFVTom.default; IFVTom.osc;
				IFVHat.globals; IFVHat.preSet; IFVHat.default; IFVHat.osc;
				0.1.wait;
				IFKick.globals; IFKick.preSet; IFKick.default; IFKick.osc;
				0.1.wait;
				IFSnr.globals; IFSnr.preSet; IFSnr.default;
				0.1.wait;
				IFHat.globals; IFHat.preSet; IFHat.default;
				0.1.wait;
				IFBass.globals; IFBass.preSet; IFBass.default; IFBass.oscMIDI;
				0.1.wait;
				IFKeys.globals; IFKeys.preSet; IFKeys.default; IFKeys.osc;
				0.1.wait;
				IFSamp.globals; IFSamp.preSet; IFSamp.default; IFSamp.osc;
				0.1.wait;
				IFRes1.globals; IFRes1.preSet;
				IFMast.load;
				0.1.wait;
				IFExt.load;
				0.1.wait;
				IFRoot.load;
				0.1.wait;
				IFProjectGlobals.preSetAll;
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
				//SonicLife.load;
				0.1.wait;
				//VBass.globals; VBass.preSet01; VKeys.globals; VKeys.preSet01;
				0.1.wait;
				//VBeats.globals; VBeats.preSet01; VBeats.oscMIDI;
				//IFVKick.globals; IFVKick.preSet; IFVKick.default; IFVKick.osc;
				//IFVSnr.globals; IFVSnr.preSet; IFVSnr.default; IFVSnr.osc;
				//IFVTom.globals; IFVTom.preSet; IFVTom.default; IFVTom.osc;
				//IFVHat.globals; IFVHat.preSet; IFVHat.default; IFVHat.osc;
				0.1.wait;
				IFKick.globals; IFKick.preSet; IFKick.default; IFKick.osc;
				0.1.wait;
				IFSnr.globals; IFSnr.preSet; IFSnr.default;
				0.1.wait;
				IFHat.globals; IFHat.preSet; IFHat.default;
				0.1.wait;
				IFBass.globals; IFBass.preSet; IFBass.default; IFBass.oscMIDI;
				0.1.wait;
				IFKeys.globals; IFKeys.preSet; IFKeys.default; IFKeys.osc;
				0.1.wait;
				IFSamp.globals; IFSamp.preSet; IFSamp.default; IFSamp.osc;
				0.1.wait;
				IFRes1.globals; IFRes1.preSet;
				IFMast.load;
				0.1.wait;
				IFExt.load;
				0.1.wait;
				IFRoot.load;
				0.1.wait;
				IFProjectGlobals.preSetAll;
				IFSeqSteps.load;
				0.1.wait;
				"Track: Not loaded".postln;
				~tOSCAdrr.sendMsg('trackLabel', 'Track: Not loaded');

			});
		};//--fork--
	}//--*load--


}