/*
PostAllMIDI.on;
PostAllMIDI.off;

IFiConnectMIDI4.load;
IFiConnectMIDI4.playPatterns;
IFiConnectMIDI4.stopPatterns;

//to find MIDIIn src
(
c = NoteOnResponder({ |src,chan,note,vel|
        [src,chan,note,vel].postln;
    });
    c.learn; // wait for the first note
)

//to find MIDIOut src
~vJmxMBs.uid;
~vAmbk.uid;
~vBass.uid;
~vSampler.uid;
~vMopho.uid;
~vKeys.uid;
~iC_iPhone.uid;
~elstc.uid;
~iC_Mac.uid;
~lpMn.uid;
~mdMix.uid;
~apcMn.uid;
~djMix.uid;
~djMn.uid;
~mdTouch.uid;
~mdOut.uid;
*/

IFiConnectMIDI4{
	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({this.load; });
		}
	}
	*load{

		~hstPort1=(1045905020);~hstPort2=(914608399);
		~hstPort3=(-694708014);~hstPort4=(563831859);
		~hstPort5=(1843132735);~hstPort6=(1105562645);
		~hstPort7=(-1298760971);~hstPort8=(763699131);
		~hstPort9=(1351388686);~hstPort10=(1820442188);
		~hstPort11=(-421217710);~hstPort12=(-1481845706);
		~hstPort13=();~hstPort14=();
		~hstPort15=();~hstPort16=();

		~iC_iPhone = MIDIOut.newByName("iConnectMIDI4+", "USB3 usb1");
		~iC_iPhoneOutID=(-753457844);
		~iC_iPhoneInID=~hstPort1;
		//~iC_iPhoneClockOut = MIDIClockOut("iConnectMIDI4+", "USB3 usb1", TempoClock.default);

		~elstc = MIDIOut.newByName("iConnectMIDI4+", "USB3 usb1");
		~elstcOutID=(-753457844);
		~elstcInID=~hstPort1;
		//~elstcClockOut = MIDIClockOut("iConnectMIDI4+", "USB3 Usb1", TempoClock.default);

		~iC_Mac = MIDIOut.newByName("iConnectMIDI4+", "USB3 usb3");
		~iC_MacOutID=(-71786470);
		~iC_iPhoneInID=(1980474828);

		~vJmxMBsClock = MIDIClockOut("iConnectMIDI4+", "USB3 DIN1", ~clkMaster);
		~vJmxMBs = MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN1");
		~vJmxMBsOutID=(-976567310);
		//~vMophoInID=~hstPort1;

		~vBass = MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN3");
		~vBassOutID=(-679083438);

		~vKeys = MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN4");
		~vKeysOutID=(405956365);
		//~vSamplerInID=~hstPort1;

		~vSamp = MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN2");
		~vSampOutID=(-679083438);

		~chMopho=0;
		~vMopho = MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN2");
		~vMophoOutID=(-2147082145);
		//~vMophoInID=~hstPort1;

		~vAmbkClock = MIDIClockOut("iConnectMIDI4+", "USB3 DIN4", ~clkMaster);
		~vAmbk = MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN4");
		~vAmbkOutID=(405956365);

		~lpMn = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST1 LPMn");
		~lpMnOutID=(907794485);
		~lpMnInID=(1037849266);

		~mdMix = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST2 MDMx");
		~mdMixOutID=(-394082490);
		~mdMixInID=(1132239779);

		~apcMn = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST3 APCMn");
		~apcMnOutID=(-1288010067);
		~apcMnInID=(-1756375906);

		~melMix = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST4 DJMx");
		~melMixOutID=(-2126449294);
		~melMixInID=(919558582);

		~djMix = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST4 DJMx");
		~djMixOutID=(-2126449294);
		~djMixInID=(919558582);

		~djMn = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST5 DJMn");
		~djMnOutID=(432114873);
		~djMnInID=(1292133807);


	}//loadAtStart

}

/*
~iC_iPhone.uid;

~iC_iPhone.noteOn(0, 1, 127); //But 1
~iC_ESI1.noteOn(0, 37, 127); //But 1
~iC_iPhone.noteOn(15, 38, 127); //But 1
~iC_iPhone.noteOn(15, 39, 127); //But 1
~iC_iPhone.noteOn(15, 40, 127); //But 1
~iC_iPhone.noteOn(15, 41, 127); //But 1

~iCElstc1=Pbind(
			\chan, Pseq([0], inf),
			\type, \midi, \midiout,~iCUSB1,
			\dur, Pseq([0.25],inf),
			\octave,0,
			\note, Pseq([[36,37],37,[36,37],37,[38,37,39],40], inf),
			\amp, Pseq([1], inf)
		).play;

~iCUSB1.noteOff(15, 36, 0); //But 1
~iCUSB1.control(0, 1, 20); // slideTime
*/