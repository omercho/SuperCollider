/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;
*/
IFLoad{
	*initClass {
		StartUp add: {
			fork{
				1.1.wait;
				Server.default.doWhenBooted({this.load; });
			};
		}
	}
	*load{
		fork{
			"Booting Ifquence: CHMR 2019".postln;
			1.1.wait;
			~volcaBoolean=0;
			Mopho.load;
			JmxMBs.load;
			0.1.wait;
			IFRoot.load;0.1.wait;
			IFProjectGlobals.load;0.1.wait;
			IFPitch.loadAll;0.1.wait;
			IFiConnectMIDI4.load;0.1.wait;
			IFSequence.load;0.1.wait;
			IFCounter.zero;IFCounter.loadProxy;0.1.wait;
			IFCntrl.loadAll;0.1.wait;
			IFTracks.loadButtons;0.1.wait;
			"Loading Pitches: Bass".postln;
			IFPitchBass.loadAll;0.1.wait;
			"Loading Pitches: Mopho".postln;
			IFPitchMopho.loadAll;0.1.wait;
			"Loading Pitches: Keys".postln;
			IFPitchKeys.loadAll;0.1.wait;
			"Loading Pitches: Samp".postln;
			IFPitchSamp.loadAll;0.1.wait;
			"Loading IFShuf".postln;
			IFShuf.load;0.1.wait;
			"Loading VBass and VKeys".postln;
			VBass.globals; VBass.preSet01;
			VKeys.load;
			0.1.wait;
			"Loading Instruments".postln;
			IFStat.load;"IFStat Loaded".postln;0.1.wait;
			IFKick.load;"IFKick Loaded".postln;0.1.wait;
			IFSnr.load;"IFSnr Loaded".postln;0.1.wait;
			IFHat.load;"IFHat Loaded".postln;0.1.wait;
			IFBass.load;"IFBass Loaded".postln;0.1.wait;
			IFMopho.load;"IFMopho Loaded".postln;0.1.wait;
			IFKeys.load;"IFKeys Loaded".postln;0.1.wait;
			IFSamp.load;"IFSamp Loaded".postln;0.1.wait;
			IFSends.load;"IFSends Loaded".postln;0.1.wait;
			"Loading IFSeqSteps".postln;
			IFSeqSteps.load;0.1.wait;
			"IFTxt Instrument Values".postln;
			IFTxt.load;0.3.wait;
			IFRoot.set00;
			"IF PROJECT READY | SELECT A TRACK".postln;
			~tOSCAdrr.sendMsg('trackLabel', 'Track: Not loaded');
		};//--fork--
	}//--*load--

}

/*

//manualLoad

IFProjectGlobals.setAddr;
IFProjectGlobals.shiftButtons;
IFProjectGlobals.setTempo(120);
IFSixteen.defaults;
IFMIDIMix.addr;
IFMIDIMix.globals;
IFMIDIMix.loadResponders;
IFMIDIMix.resetLeds;

IFAPCMn.addr;
IFAPCMn.globals;
IFAPCMn.shiftButton;
IFAPCMn.psrButtonsPlay;

IFAPCMn_Launch.globals;
IFAPCMn_Launch.resetLeds;
IFAPCMn_Launch.makeNoteResponders;

IFLaunchSteps.globals;
IFLaunchSteps.resetLeds;
IFLaunchSteps.makeNoteResponders;


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