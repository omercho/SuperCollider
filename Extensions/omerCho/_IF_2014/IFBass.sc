
/*
IFBass.times(2);
IFBass.pat_1;

~octBass=4;

*/


IFBass {
	var <>keyTime = 1;
	classvar <>counter3 = 0;


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc;});*/
		}
	}

	*globals{

		~chBass=3;
		~bassLate=0.0;
		~timesBass=1;
		~octMulBass=0;
		~harmBass=0;
		~rootBass=0;
		~susMulBass=1;
		~trBass=0;
		~lfoMulBass1=0;
		~lfoMulBass2=0;



	}

	*preSet{}


	*default {

		~nt1Bass = PatternProxy( Pseq([0], inf));
		~nt1BassP = Pseq([~nt1Bass], inf).asStream;
		~dur1Bass = PatternProxy( Pseq([1], inf));
		~dur1BassP = Pseq([~dur1Bass], inf).asStream;
		~amp1Bass = PatternProxy( Pseq([0.9], inf));
		~amp1BassP = Pseq([~amp1Bass], inf).asStream;
		~sus1Bass = PatternProxy( Pseq([1], inf));
		~sus1BassP = Pseq([~sus1Bass], inf).asStream;

		~tmMulBass = PatternProxy( Pseq([1], inf));
		~tmMulBassP= Pseq([~tmMulBass], inf).asStream;
		~tmBass = PatternProxy( Pseq([1], inf));
		~tmBassP= Pseq([~tmBass], inf).asStream;


		~transBass = PatternProxy( Pseq([0], inf));
		~transBassP = Pseq([~transBass], inf).asStream;
		~octBass = PatternProxy( Pseq([4], inf));
		~octBassP = Pseq([~octBass], inf).asStream;
		~legBass = PatternProxy( Pseq([0.0], inf));
		~legBassP = Pseq([~legBass], inf).asStream;
		~strBass = PatternProxy( Pseq([1.0], inf));
		~strBassP = Pseq([~strBass], inf).asStream;

		~delta1Bass = PatternProxy( Pseq([0.5], inf));
		~delta1BassP = Pseq([~delta1Bass], inf).asStream;
		~delta2Bass = PatternProxy( Pseq([0.5], inf));
		~delta2BassP = Pseq([~delta2Bass], inf).asStream;

		~lfo1Bass = PatternProxy( Pseq([40], inf));
		~lfo1BassP = Pseq([~lfo1Bass], inf).asStream;
		~lfo2Bass = PatternProxy( Pseq([40], inf));
		~lfo2BassP = Pseq([~lfo2Bass], inf).asStream;


	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				//~bassLate=~abLate;
				~bassLate.wait;

				this.p1(val);

				~durMulP*((~dur1BassP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chBass,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([~dur1BassP.next/val],1)], 1),
			\degree, Pseq([~nt1BassP.next], 1),
			\amp, Pseq([~amp1BassP.next], 1),
			\sustain, Pseq([~sus1BassP.next],1)*~susMulBass,
			\mtranspose, Pseq([~transBassP.next], 1)+~trBass,
			\octave, Pseq([~octBassP.next], 1)+~octMulBass,
			//\root, Pseq([~legBassP.next], 1),
			\harmonic, Pseq([~strBassP.next], 1)+~harmBass
		).play;

		Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~md1, \chan, 10, \ctlNum, 0,
			\delta, Pseq([~delta1BassP.next], 2),
			\control, Pseq([~lfo1BassP.next], 2)*~lfoMulBass1,

		).play;

		Pbind(//LFO CUT BASS INT
			\midicmd, \control, \type, \midi,
			\midiout,~vBass, \chan, 0, \ctlNum, ~lfoInt,
			\delta, Pseq([~delta1KeysP.value], 1),
			\control, Pseq([~lfo1BassP.value], 1)*~lfoMulBass1,
		).play;

		Pbind(//LFO 2
			\type, \midi, \midicmd, \control,
			\midiout,~md1,\chan, 10,  \ctlNum, 1,
			\delta, Pseq([~delta2BassP.next], 1),
			\control, Pseq([~lfo2BassP.next], 1)*~lfoMulBass2,

		).play;

		Pbind(//LFO CUT BASS RATE
			\midicmd, \control, \type, \midi,
			\midiout,~vBass, \chan, 0, \ctlNum, ~lfoRate,
			\delta, Pseq([~delta2KeysP.value], 2),
			\control, Pseq([~lfo2BassP.value], 2)*~lfoMulBass2,
		).play;


		//this.count2;
		//this.timesCount;
	}


	*oscMIDI{

		~xy1Bass.free;
		~xy1Bass= OSCFunc({
			arg msg;

			~vBass.control(0, ~vcoPitch2, msg[2]*127);
			//~tOSCAdrr.sendMsg('sltBass', vel);
			~vBass.control(0, ~vcoPitch3, msg[1]*127);

			},
			'/xy1Bass'
		);

		/*~attBassFader.free;
		~attBassFader= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			~vBass.control(0, ~egAtt, val+0.01);
			},
			'/attBass'
		);*/

		~midiAttBass.free;
		~midiAttBass=MIDIFunc.cc( {
			arg vel;
			//vel.postln;
			~vBass.control(0, ~egAtt, vel);
			//~tOSCAdrr.sendMsg('attBass', vel/127);
		}, chan:5, ccNum:5);

		~midiSltBass.free;
		~midiSltBass=MIDIFunc.cc( {
			arg vel;
			//vel.postln;
			~vBass.control(0, ~slideTime, vel);
			//~tOSCAdrr.sendMsg('sltBass', vel*(1/127));
		}, chan:5, ccNum:6);


		~midiDecBass.free;
		~midiDecBass=MIDIFunc.cc( {
			arg vel;
			//vel.postln;
			~vBass.control(0, ~egDec, vel);
			//~tOSCAdrr.sendMsg('decBass', vel);

		}, chan:5, ccNum:7);

		~lfoMulBassFad1.free;
		~lfoMulBassFad1= OSCFunc({
			arg msg;
			~lfoMulBass1=msg[1]*1.1;
			},
			'/lfoMulBass1'
		);

		~lfoMulBassFad2.free;
		~lfoMulBassFad2= OSCFunc({
			arg msg;
			~lfoMulBass2=msg[1]*1.1;
			},
			'/lfoMulBass2'
		);

		//TIME
		~tmMulBassBut1.free;
		~tmMulBassBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulBass.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', 1);

			});

			},
			'/tmMulBass1'
		);
		~tmMulBassBut2.free;
		~tmMulBassBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulBass.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', 2);

			});

			},
			'/tmMulBass2'
		);
		~tmMulBassBut3.free;
		~tmMulBassBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulBass.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', 3);

			});

			},
			'/tmMulBass3'
		);
		~tmBassFader.free;
		~tmBassFader= OSCFunc({
			arg msg;
			~tmBass.source = msg[1];

			},
			'/timesBass'
		);

		~padBass.free;
		~padBass = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFBass(~tmBassP.next);

			});
			},
			'/padBass'
		);

		//----Bass-------
		~octBassMulBut.free;
		~octBassMulBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~octMulBass = ~octMulBass+1;
				~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);
			});
			},
			'/octBassMul'
		);

		~octBassZeroBut.free;
		~octBassZeroBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~octMulBass = 0;
				~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);
			});
			},
			'/octBassZero'
		);

		~octBassDivBut.free;
		~octBassDivBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulBass = ~octMulBass-1;
				~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);
			});
			},
			'/octBassDiv'
		);
	}




	//Bass Beat Counter
	*count3 {
		1.do{
			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            BassCnt"+counter3).postln;
					this.ctl_2;
					counter3 = 0;

				}

			)
		}

	}


	*ctl_1 {


	}

	*ctl_2 {
		("Bass CTL 2").postln;

	}


}