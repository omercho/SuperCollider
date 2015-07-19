/*
IFSCLoad.load;
*/

IFSCLoad{
	*load{
		//////--------
		fork{
			Server.default.doWhenBooted({
				IFOSC.globals; IFOSC.mulFaders; IFOSC.sets;
				IFOSC.main; IFOSC.parts; IFOSC.bridge;
				IFOSC.note; IFOSC.noteBass; IFOSC.noteKeys;
				IFOSC.noteSamp; IFOSC.oct; IFOSC.trans;
				0.1.wait;
				IFSC_MIDI.vBass; IFSC_MIDI.vKeys;
				0.1.wait;
				IFSC_MIDI.midiAdrr;
				0.1.wait;
				IFSCProjectGlobals.globals; IFSCProjectGlobals.preSetAll;
				IFSCProjectGlobals.setTempo(120);
				0.1.wait;

				0.1.wait;
				VBeats.globals; VBeats.preSet01; VBeats.oscMIDI;
				0.1.wait;
				VBass.globals; VBass.preSet01;
				0.1.wait;
				VKeys.globals; VKeys.preSet01;

				IFVKick_SC.globals; IFVKick_SC.preSet; IFVKick_SC.default; IFVKick_SC.osc;
				0.1.wait;
				IFVSnr_SC.globals; IFVSnr_SC.preSet; IFVSnr_SC.default; IFVSnr_SC.osc;
				0.1.wait;
				IFVTom_SC.globals; IFVTom_SC.preSet; IFVTom_SC.default; IFVTom_SC.osc;
				0.1.wait;
				IFVHat_SC.globals; IFVHat_SC.preSet; IFVHat_SC.default; IFVHat_SC.osc;
				0.1.wait;
				IFVPcm_SC.globals; IFVPcm_SC.preSet; IFVPcm_SC.default; IFVPcm_SC.osc;
				0.1.wait;
				IFBass_SC.globals; IFBass_SC.preSet; IFBass_SC.default; IFBass_SC.osc;
				0.1.wait;
				IFKeys_SC.globals; IFKeys_SC.preSet; IFKeys_SC.default; IFKeys_SC.osc;
				0.1.wait;
				IFKick_SC.globals; IFKick_SC.preSet; IFKick_SC.default; IFKick_SC.osc;
				0.1.wait;
				IFSamp_SC.globals; IFSamp_SC.preSet; IFSamp_SC.default; IFSamp_SC.osc;


				0.1.wait;
				//IFSC.loadGroups;
				0.25.wait;
				//IFSC.loadBuses;
				0.25.wait;
				//IFSC.loadEffects;
				0.25.wait;
				//IFSC.playEffects;
				0.1.wait;
				IFSC_MIDI.latency;

			});
		};
	}
	/////---------------
}