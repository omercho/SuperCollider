~testTru= MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN1");

~testTru.noteOn(18,60,64)





~fade = Pseq((0..63), inf).asStream;
~dur2 = Pseq([0.1]/2, inf).asStream;
fork{
64.do{

	~testTru.noteOn(0,~fade.next,120);
	~dur2.next.wait;
		~testTru.noteOff(0,~fade,120);
		~dur2.next.wait;

};
};

