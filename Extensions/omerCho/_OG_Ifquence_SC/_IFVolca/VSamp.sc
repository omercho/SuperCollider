VSamp {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet01; this.oscMIDI });*/
		}
	}

	*globals{

		//~vSamp = MIDIOut.newByName("MIDIMATE II", "Port 2");
		//~vSamp = MIDIOut.newByName("IAC Driver", "SC-Abl");
		~vSamp = MIDIOut.newByName("UM-2G","2");


		~smp01=0;
		~smp02=1;
		~smp03=2;
		~smp04=3;
		~smp05=4;
		~smp06=5;
		~smp07=6;
		~smp08=7;
		~smp09=8;
		~smp10=9;

		~smpLvl=7;
		~smpPan=10;
		~smpStart=40;
		~smpLength=41;
		~smpHiCut=42;
		~smpSpeed=43;
		~smpPitchEgInt=44;
		~smpPitchAtt=45;
		~smpPitchDec=46;
		~smpAtt=47;
		~smpDec=48;




	}
	*oscMIDI {


}



*preSet01 {

	//~vSamp.control(10, ~kickLev, 20);



}

*preSet02 {




}

*killAll {

	~vSamp.allNotesOff(0);
	~vSamp.allNotesOff(1);
	~vSamp.allNotesOff(2);
	~vSamp.allNotesOff(3);
	~vSamp.allNotesOff(4);
	~vSamp.allNotesOff(5);
	~vSamp.allNotesOff(6);
	~vSamp.allNotesOff(7);
	~vSamp.allNotesOff(8);
	~vSamp.allNotesOff(9);
	~vSamp.allNotesOff(10);
	~vSamp.allNotesOff(11);
	~vSamp.allNotesOff(12);
	~vSamp.allNotesOff(13);
	~vSamp.allNotesOff(14);
	~vSamp.allNotesOff(15);
	~vSamp.allNotesOff(16);

}

}

/*

~vSamp.noteOn(0,10,64);
~vSamp.noteOff(0,10,64);

(

~testSamp1=Pbind(
	\chan, ~smp01,
	\type, \midi,
	\midicmd, \noteOn,
	\midiout,~vSamp,
	\scale, Pfunc({Scale.chromatic}, inf),
	\dur, Pseq([Pseq([1/2],inf)], inf),
	\amp, Pseq([1,0,1,0,0,1,1,0], inf),
	\sustain, Pseq([~sus1VKickP.next],inf)*~susMulVKick,

).play;
~testSampCC1=Pbind(//vKickLevel
	\type, \midi, \midicmd, \control,
	\midiout,~vSamp, \chan, 0, \ctlNum, 43,
	\delta, Pseq([1],inf),
	\control, Pshuf([0.8,0.2,1,0.3,0.5], inf)*127,

).play;

~testSamp2=Pbind(
	\chan, ~smp02,
	\type, \midi,
	\midicmd, \noteOn,
	\midiout,~vSamp,
	\scale, Pfunc({Scale.chromatic}, inf),
	\dur, Pseq([Pseq([1/4],inf)], inf),
	\amp, Pseq([1,0,1,0,0,1,1,0], inf),

).play;
~testSampCC2=Pbind(//vKickLevel
	\type, \midi, \midicmd, \control,
	\midiout,~vSamp, \chan, 1, \ctlNum, 43,
	\delta, Pseq([1/3],inf),
	\control, Pshuf([0.8,0.2,1,0.3,0.5], inf)*127,

).play;

)
~testSamp1.stop;~testSampCC1.stop;~testSamp2.stop;~testSampCC2.stop;

*/
