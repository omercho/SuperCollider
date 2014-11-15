
/*
IFKeys.times(2);
IFKeys(3);

~octKeys=4;

*/


IFKeys_SC {
	var <>keyTime = 1;
	classvar <>counter3 = 0;


	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({ this.globals; this.preSet; this.default;this.osc; });
		}
	}

	*globals{

		~chKeys=0;
		~keysLate= 0.0;
		~timesKeys=1;
		~octMulKeys=0;
		~rootKeys=0;
		~harmKeys=0;
		~susMulKeys=1;
		~lfoMulKeys=0;
		~trKeys=0;

	}

	*preSet{}


	*default {

		~nt1Keys = PatternProxy( Pseq([0], inf));
		~nt1KeysP = Pseq([~nt1Keys], inf).asStream;
		~dur1Keys = PatternProxy( Pseq([1], inf));
		~dur1KeysP = Pseq([~dur1Keys], inf).asStream;
		~amp1Keys = PatternProxy( Pseq([0.9], inf));
		~amp1KeysP = Pseq([~amp1Keys], inf).asStream;
		~sus1Keys = PatternProxy( Pseq([0.2], inf));
		~sus1KeysP = Pseq([~sus1Keys], inf).asStream;

		~tmKeys = PatternProxy( Pseq([1], inf));
		~tmKeysP = Pseq([~tmKeys], inf).asStream;


		~transKeys = PatternProxy( Pseq([1], inf));
		~transKeysP = Pseq([~transKeys], inf).asStream;
		~octKeys = PatternProxy( Pseq([4], inf));
		~octKeysP = Pseq([~octKeys], inf).asStream;
		~legKeys = PatternProxy( Pseq([0.0], inf));
		~legKeysP = Pseq([~legKeys], inf).asStream;
		~strKeys = PatternProxy( Pseq([1.0], inf));
		~strKeysP = Pseq([~strKeys], inf).asStream;
		//~delta1Keys.source=0.5;
		~delta1Keys = PatternProxy( Pseq([0.5], inf));
		~delta1KeysP = Pseq([~delta1Keys], inf).asStream;
		~lfoRtKeys = PatternProxy( Pseq([20], inf));
		~lfoRtKeysP = Pseq([~lfoRtKeys], inf).asStream;

		~delta2Keys = PatternProxy( Pseq([0.5], inf));
		~delta2KeysP = Pseq([~delta2Keys], inf).asStream;
		~lfoCtKeys = PatternProxy( Pseq([40], inf));
		~lfoCtKeysP = Pseq([~lfoRtKeys], inf).asStream;

		~delta3Keys = PatternProxy( Pseq([0.25], inf));
		~delta3KeysP = Pseq([~delta3Keys], inf).asStream;
		~vcfCtKeys = PatternProxy( Pseq([40], inf));
		~vcfCtKeysP = Pseq([~vcfCtKeys], inf).asStream;

	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				~keysLate.wait;

				this.p1(val);

				~durMulP*((~dur1KeysP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		Pbind(
			\chan, ~chKeys,
			\type, \midi, \midiout,~vKeys, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([~dur1KeysP.next/i],1)], 1),
			\degree, Pseq([~nt1KeysP.next], 1),
			\amp, Pseq([~amp1KeysP.next], 1),
			\sustain, Pseq([~sus1KeysP.next],1)*~susMulKeys*~susTD,
			\mtranspose, Pseq([~transKeysP.next], 1)+~trKeys,
			\octave, Pseq([~octKeysP.next], 1)+~octMulKeys,

			\harmonic, Pseq([~strKeysP.next], 1)+~harmKeys
		).play;

		Pbind(//LFO RATE
			\type, \midi, \midicmd, \control,
			\chan, 0, \midiout,~vKeys, \ctlNum, ~lfoRate,
			\delta, Pseq([~delta1KeysP.next], 2),
			\control, Pseq([~lfoRtKeysP.next], 2)*~lfoMulKeys,

		).play;

		Pbind(//LFO CUT
			\chan, 0, \midicmd, \control,
			\type, \midi, \midiout,~vKeys, \ctlNum, ~lfoCut,
			\delta, Pseq([~delta2KeysP.next], 2),
			\control, Pseq([~lfoCtKeysP.next], 2)*~lfoMulKeys,

		).play;

		/*Pbind(//LFO CUT
		\chan, 0, \midicmd, \control,
		\type, \midi, \midiout,~vKeys, \ctlNum, ~vcfCut,
		\delta, Pseq([~delta3KeysP.next], 4),
		\control, Pseq([~vcfCtKeysP.next], 4)*~lfoMulKeys,

		).play;*/

		//this.count2;
		//this.timesCount;
	}



	*osc{

		~xy1Keys.free;
		~xy1Keys= OSCFunc({
			arg msg;




			~vKeys.control(0, ~dlyTime, msg[2]*127); //Delay Time
			~vKeys.control(0, ~dlyFeed, msg[1]*127); //Delay FeedBack

			},
			'/xy1Keys'
		);

		~attKeysFader.free;
		~attKeysFader= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			~vKeys.control(0, ~envAtt, val+0.01);
			},
			'/attKeys'
		);

		~lfoMulKeysFad.free;
		~lfoMulKeysFad= OSCFunc({
			arg msg;
			~lfoMulKeys=msg[1];
			},
			'/lfoMulKeys'
		);

		~tmKeysFader.free;
		~tmKeysFader= OSCFunc({
			arg msg;
			~tmKeys.source = msg[1];

			},
			'/timesKeys'
		);

		//MUTES
		~vKeysMtCln.free;
		~vKeysMtCln= OSCFunc({
			arg msg;

			~vKeysSynth.set(\mtCln, msg[1]);

			},
			'/mtClnKeys'
		);
		~vKeysMtDly.free;
		~vKeysMtDly= OSCFunc({
			arg msg;

			~vKeysSynth.set(\mtDly, msg[1]);

			},
			'/mtDlyKeys'
		);
		~vKeysMtRev.free;
		~vKeysMtRev= OSCFunc({
			arg msg;

			~vKeysSynth.set(\mtRev, msg[1]);

			},
			'/mtRevKeys'
		);
		~vKeysMtFlo.free;
		~vKeysMtFlo= OSCFunc({
			arg msg;

			~vKeysSynth.set(\mtFlo, msg[1]);

			},
			'/mtFloKeys'
		);

		~padKeys.free;
		~padKeys = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFKeys(~tmKeysP.next);

			});
			},
			'/padKeys'
		);

	}



	//Keys Beat Counter
	*count3 {
		1.do{
			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            KeysCnt"+counter3).postln;
					this.ctl_2;
					counter3 = 0;

				}

			)
		}

	}


	*ctl_1 {


	}

	*ctl_2 {
		("Keys CTL 2").postln;

	}


}