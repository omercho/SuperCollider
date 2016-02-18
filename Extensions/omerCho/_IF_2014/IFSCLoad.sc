/*
IFSCLoad.load;
*/

IFSCLoad{
	*load{
		//////--------
		fork{
			Server.default.doWhenBooted({

				0.1.wait;
				IFSCProjectGlobals.loadAll;
				0.1.wait;
				IFOSC.loadAll;
				0.1.wait;
				VBeats.globals; VBeats.preSet01; VBeats.oscMIDI;
				0.1.wait;
				VBass.globals; VBass.preSet01;
				0.1.wait;
				VKeys.globals; VKeys.preSet01;
				0.1.wait;

				IFVKick_SC.globals; IFVKick_SC.preSet; IFVKick_SC.default; IFVKick_SC.osc;
				0.1.wait;
				IFVSnr_SC.globals; IFVSnr_SC.preSet; IFVSnr_SC.default; IFVSnr_SC.osc;
				0.1.wait;
				IFVTom_SC.globals; IFVTom_SC.preSet; IFVTom_SC.default; IFVTom_SC.osc;
				0.1.wait;
				IFVHat_SC.globals; IFVHat_SC.preSet; IFVHat_SC.default; IFVHat_SC.osc;
				0.1.wait;
				IFVPcm_SC.globals; IFVPcm_SC.preSet; IFVPcm_SC.default; IFVPcm_SC.osc;
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
				0.1.wait;
				IFSC_MIDI.latency;

			});
		};
	}
	/////---------------
}