OCMIDI {
	classvar default;
	var <>myfreq; // an instant variable with a getter and setter

	*initClass {
		StartUp add: {

			this.initMIDI;
		}
	}

	*initMIDI{

		//MIDIClient.init;	// scan all midi sources
		//MIDIClient.sources do: { | s, i | MIDIIn.connect(i, s) }; // connect all midi sources
		~sc1 = MIDIOut.newByName("IAC Driver", "SC1");
		~md1 = MIDIOut.newByName("IAC Driver", "SC-Abl");
		~md1Clock = MIDIClockOut("MIDIMATE II", "Port 1");
		~mdTouch = MIDIOut.newByName("TouchOSC Bridge", "TouchOSC Bridge");

		MIDIIn.connectAll;

		~tOSCAdrr = NetAddr.new("192.168.1.4", 57130); // create the NetAddr



	}



}

/*

MIDIOut.newByName("IAC Driver", "SC1");

~pup1 = Puppet.new(50);

~pup.dump;
~pup.myfreq;
~pup.myfreq_(100);
~pup.blip;
~pup.myfreq_(100).blip;
*/


/*

OCMIDI {
	classvar default;
	var <>myfreq; // an instant variable with a getter and setter

	*initClass {
		StartUp add: {

			//this.initMIDI;
		}
	}

	*default {
		if (default.isNil) { default = this.new };  // create default
		^default;
	}

	*new { | server, addr, chan = 0 |
		^super.new.init(server, addr, chan);	//new.init
	}


}

*/