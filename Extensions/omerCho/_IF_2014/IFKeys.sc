
/*
IFKeys.times(2);
IFKeys(3);

*/


IFKeys {
	var <>keyTime = 1;
	classvar <>counter3 = 0;


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default;this.osc; });*/
		}
	}

	*globals{

		~chKeys=4;
		~keysLate= 0.0;
		~timesKeys=1;
		~octMulKeys=0;
		~rootKeys=0;
		~harmKeys=0;
		~susMulKeys=1;
		~lfoMulKeys1=0;
		~lfoMulKeys2=0;
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

		~tmMulKeys = PatternProxy( Pseq([1], inf));
		~tmMulKeysP= Pseq([~tmMulKeys], inf).asStream;
		~tmKeys = PatternProxy( Pseq([1], inf));
		~tmKeysP = Pseq([~tmKeys], inf).asStream;


		~transKeys = PatternProxy( Pseq([1], inf));
		~transKeysP = Pseq([~transKeys], inf).asStream;
		~octKeys = PatternProxy( Pseq([3], inf));
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
		~lfoCtKeysP = Pseq([~lfoCtKeys], inf).asStream;

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
		var val;
		val=i;
		Pbind(
			\chan, ~chKeys,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1KeysP.next/(val/2)],1),
			\degree, Pseq([~nt1KeysP.next], inf),
			\amp, Pseq([~amp1KeysP.next], inf),
			\sustain, Pseq([~sus1KeysP.next],inf)*~susMulKeys,
			\mtranspose, Pseq([~transKeysP.next], inf)+~trKeys,
			\octave, Pseq([~octKeysP.next], inf)+~octMulKeys,
			\harmonic, Pseq([~strKeysP.next], inf)+~harmKeys
		).play;

		Pbind(//LFO CUT ABL INT
			\type, \midi, \midicmd, \control,
			\midiout,~mdOut, \chan, 10, \ctlNum, 3,
			\delta, Pseq([~delta1KeysP.next], 1),
			\control, Pseq([~lfoCtKeysP.next], 1)*~lfoMulKeys1,
		).play;


		Pbind(//LFO RATE ABL
			\type, \midi, \midicmd, \control,
			\midiout,~mdOut, \chan, 10, \ctlNum, 2,
			\delta, Pseq([~delta2KeysP.next], 1),
			\control, Pseq([~lfoRtKeysP.next], 1)*~lfoMulKeys2,
		).play;

		/*
		//VKeys
		Pbind(//LFO CUT KEYS INT
			\midicmd, \control, \type, \midi,
			\midiout,~vKeys, \chan, 0, \ctlNum, ~lfoCut,
			\delta, Pseq([~delta1KeysP.value], 1),
			\control, Pseq([~lfoCtKeysP.value], 1)*~lfoMulKeys1,
		).play;

		Pbind(//LFO RATE KEYS
			\midicmd, \control, \type, \midi,
			\midiout,~vKeys, \chan, 0, \ctlNum, ~lfoRate,
			\delta, Pseq([~delta2KeysP.value], 1),
			\control, Pseq([~lfoRtKeysP.value], 1)*~lfoMulKeys2,
		).play;

		*/

		//this.count2;
		//this.timesCount;
	}



	*osc{


		/*
		~midiAttKeys.free; //THE MIDI FORMAT CONTROL
		~midiAttKeys=MIDIFunc.cc( {
			arg vel;
			~vKeys.control(0, ~envAtt, vel);

		}, chan:6, ccNum:5);

		~midiSusKeys.free;
		~midiSusKeys=MIDIFunc.cc( {
			arg vel;
			~vKeys.control(0, ~envSus, vel);

		}, chan:6, ccNum:6);

		~midiDecKeys.free;
		~midiDecKeys=MIDIFunc.cc( {
			arg vel;
			vel.postln;
			~vKeys.control(0, ~envDec, vel);

		}, chan:6, ccNum:7);
		*/

		~oscAttKeys.free;
		~oscAttKeys= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			~tOSCAdrr.sendMsg('attKeys', msg[1]);
			//~vKeys.control(0, ~envAtt, val+0.01);
			},
			'/attKeys'
		);

		~oscSusKeys.free;
		~oscSusKeys= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			~tOSCAdrr.sendMsg('susKeys', msg[1]);
			//~vKeys.control(0, ~envAtt, val+0.01);
			},
			'/susKeys'
		);

		~oscDecKeys.free;
		~oscDecKeys= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			~tOSCAdrr.sendMsg('decKeys', msg[1]);
			//~vKeys.control(0, ~envAtt, val+0.01);
			},
			'/decKeys'
		);

		~xy1Keys.free;
		~xy1Keys= OSCFunc({
			arg msg;
			//~vKeys.control(0, ~dlyTime, msg[2]*127); //Delay Time
			//~vKeys.control(0, ~dlyFeed, msg[1]*127); //Delay FeedBack
			},
			'/xy1Keys'
		);

		/**/

		~lfoMulKeysFad1.free;
		~lfoMulKeysFad1= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulKeys1', msg[1]);
			~lfoMulKeys1=msg[1]*1.2;
			},
			'/lfoMulKeys1'
		);

		~lfoMulKeysFad2.free;
		~lfoMulKeysFad2= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulKeys2', msg[1]);
			~lfoMulKeys2=msg[1]*1.2;
			},
			'/lfoMulKeys2'
		);

		//TIME
		~tmMulKeysBut1.free;
		~tmMulKeysBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulKeys.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', 1);

			});

			},
			'/tmMulKeys1'
		);
		~tmMulKeysBut2.free;
		~tmMulKeysBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulKeys.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', 2);

			});

			},
			'/tmMulKeys2'
		);
		~tmMulKeysBut3.free;
		~tmMulKeysBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulKeys.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', 3);

			});

			},
			'/tmMulKeys3'
		);
		~tmKeysFader.free;
		~tmKeysFader= OSCFunc({
			arg msg;
			~tmKeys.source = msg[1];

			},
			'/timesKeys'
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

		//----Keys-------
		~octKeysMulBut.free;
		~octKeysMulBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulKeys = ~octMulKeys+1;
				~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);
			});
			},
			'/octKeysMul'
		);

		~octKeysZeroBut.free;
		~octKeysZeroBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulKeys = 0;
				~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);
			});
			},
			'/octKeysZero'
		);

		~octKeysDivBut.free;
		~octKeysDivBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulKeys = ~octMulKeys-1;
				~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);
			});
			},
			'/octKeysDiv'
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