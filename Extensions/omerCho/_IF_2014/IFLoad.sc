/*
IFLoad.load;
*/

IFLoad{
	*load{
		//////--------
		fork{
			Server.default.doWhenBooted({
				IFProjectGlobals.globals;
				IFProjectGlobals.setTempo(120);
				IFCounter.zero;
				0.1.wait;
				IFOSC.loadAll;
				SonicLife.load;
				0.1.wait;
				//VBeats.globals; VBeats.preSet01; VBeats.oscMIDI;
				VBass.globals; VBass.preSet01;
				0.1.wait;
				VKeys.globals; VKeys.preSet01;

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
				//IFSC_MIDI.latency;
				0.1.wait;
				IFProjectGlobals.preSetAll;
				"Track: Not loaded".postln;
				~tOSCAdrr.sendMsg('trackLabel', 'Track: Not loaded');

			});
		};
	}
	/////---------------
}