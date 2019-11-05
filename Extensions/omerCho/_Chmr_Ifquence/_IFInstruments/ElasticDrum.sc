/*

PostAllMIDI.on;
PostAllMIDI.off;


*/
ElasticDrum{
	*initClass {
		StartUp add: {
			//Server.default.doWhenBooted({this.load; });
		}
	}
	*load{
		~elstcClockOut = MIDIClockOut("iConnectMIDI4+", "USB3 usb1", TempoClock.default);
		("Elastic Drum Loaded").postln;
	}

	*playPatterns{
		//~elstcClockOut.play;
		~iCElstc1=Pbind(
			\chan, Pseq([0], inf),
			\type, \midi, \midiout,~elstc,
			\octave,0,
			\dur, Pseq([4.0],inf),
			\note, Pseq([60], inf),
			\amp, Pseq([1], inf)
		).play(MIDISyncClock, quant: 0);
		~iCElstc2=Pbind(
			\chan, Pseq([0], inf),
			\type, \midi, \midiout,~elstc,
			\octave,0,
			\dur, Pseq([2.0],inf),
			\note, Pseq([61], inf),
			\amp, Pseq([0,1], inf)
		).play(MIDISyncClock, quant: 0);
		~iCElstc3=Pbind(
			\type, \midi, \midiout,~elstc,
			\chan, Pseq([0], inf),\octave,0,
			\dur, Pseq([0.5],inf),
			\note, Pseq([62], inf),
			\amp, Pseq([0,1,0,1], inf)
		).play(MIDISyncClock, quant: 0);
		~iCElstc4=Pbind(
			\type, \midi, \midiout,~elstc,
			\chan, Pseq([0], inf),\octave,0,
			\dur, Pseq([0.5],inf),
			\note, Pseq([63,64,65], inf),
			\amp, Pseq([1], inf)
		).play(MIDISyncClock, quant: 0);
	}
	*stopPatterns{
		//~elstcClockOut.stop;
		~iCElstc1.stop;
		~iCElstc2.stop;
		~iCElstc3.stop;
		~iCElstc4.stop;
		~iCElstc5.stop;
		~iCElstc6.stop;
	}
	*midiLearn{
		//inst1
		~vol_inst1=0; ~pan_inst1=1; ~fx12_inst1=2;~fx34_inst1=3;
		~pitch_inst1=4; ~tone_inst1=5; ~decay_inst1=6;~rls_inst1=7;
		~n1_inst1=8; ~n2_inst1=9; ~n3_inst1=10; ~n4_inst1=11;
		~n5_inst1=12; ~n6_inst1=13; ~n7_inst1=14; ~n8_inst1=15;
		//inst2
		~vol_inst2=16; ~pan_inst2=7; ~fx12_inst2=18;~fx34_inst2=19;
		~pitch_inst2=20; ~tone_inst2=21; ~decay_inst2=22;~rls_inst2=23;
		~n1_inst2=24; ~n2_inst2=25; ~n3_inst2=26; ~n4_inst2=27;
		~n5_inst2=28; ~n6_inst2=29; ~n7_inst2=30; ~n8_inst2=31;
		//inst3
		~vol_inst3=32; ~pan_inst3=33; ~fx12_inst3=34;~fx34_inst3=5;
		~pitch_inst3=36; ~tone_inst3=37; ~decay_inst3=38;~rls_inst3=39;
		~n1_inst3=40; ~n2_inst3=41; ~n3_inst3=42; ~n4_inst3=43;
		~n5_inst3=44; ~n6_inst3=45; ~n7_inst3=46; ~n8_inst3=47;
		//inst4
		~vol_inst4=48; ~pan_inst4=49; ~fx12_inst4=50;~fx34_inst4=51;
		~pitch_inst4=52; ~tone_inst4=53; ~decay_inst4=54;~rls_inst4=55;
		~n1_inst4=56; ~n2_inst4=57; ~n3_inst4=58; ~n4_inst4=59;
		~n5_inst4=60; ~n6_inst4=61; ~n7_inst4=62; ~n8_inst4=63;
		//inst5
		~vol_inst5=64; ~pan_inst5=65; ~fx12_inst5=66;~fx34_inst5=67;
		~pitch_inst5=68; ~tone_inst5=69; ~decay_inst5=70;~rls_inst5=71;
		~n1_inst5=72; ~n2_inst5=73; ~n3_inst5=74; ~n4_inst5=75;
		~n5_inst5=76; ~n6_inst5=77; ~n7_inst5=78; ~n8_inst5=79;
		//inst6
		~vol_inst6=80; ~pan_inst6=81; ~fx12_inst6=82;~fx34_inst6=83;
		~pitch_inst6=84; ~tone_inst6=85; ~decay_inst6=86;~rls_inst6=87;
		~n1_inst6=88; ~n2_inst6=89; ~n3_inst6=90; ~n4_inst6=91;
		~n5_inst6=92; ~n6_inst6=93; ~n7_inst6=94; ~n8_inst6=95;

		~jamX=96; ~jamY=97;
		~jamPlay=84; ~jamPats=85;
		~jamPat1=0;
		~jamPat2=1;
		~jamPat3=2;
		~jamPat4=3;
		~inst1=60;
		~inst2=61;
		~inst3=62;
		~inst4=63;
		~inst5=64;
		~inst6=65;

		~elstc.control(0, 10, 64); //Mel Audio / High
		~valmul=6;
		~valmul=~valmul+1;
		~elstc.control(0, ~valmul, 64); //Mel Audio / High

		~elstc.noteOn(0, 5, 1);
	}

}