IFMIDIIn{


	*midiFromAbleton{

		~midiInCC_1.free;
		~midiInCC_1=MIDIFunc.cc( {
			arg vel;
			//vel.postln;
			//~vBass.control(0, ~egAtt, vel);
			//~tOSCAdrr.sendMsg('chainKick', vel/127);
			//~tOSCAdrr.sendMsg('chainSnr', vel/127);
			~mdOut.control(2, 8, vel); // Kick Chain
			~mdOut.control(3, 8, vel); // Snr Chain
		}, chan:14, ccNum:1);

	}


}