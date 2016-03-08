
/*

IFSnr.times(4);
*/

	IFSnr {
	classvar <>counter2=0, <>counter3=0, timeCnt=0;
	var <>sTime=1;


	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.cntrl; });
		}
	}

	*globals{

		~snrCh=1;
		~snrLate=0.00;
		~snrTimes=1;
		~rootSnr=0;
		~harmSnr=0;
		~susMulSnr=1;
		~trSnr=0;

		~octMulSnr=0;

		~snrVolC=1;
	}

	*preSet {

		~md1.control(~snrCh, ~snrVolC, 100); //SnareVol

	}



	*default {

		~nt1Snr = PatternProxy( Pseq([0], inf));
		~nt1SnrP = Pseq([~nt1Snr], inf).asStream;
		~dur1Snr = PatternProxy( Pseq([1], inf));
		~dur1SnrP = Pseq([~dur1Snr], inf).asStream;
		~amp1Snr = PatternProxy( Pseq([1], inf));
		~amp1SnrP = Pseq([~amp1Snr], inf).asStream;
		~sus1Snr = PatternProxy( Pseq([1], inf));
		~sus1SnrP = Pseq([~sus1Snr], inf).asStream;

		~tmMulSnr = PatternProxy( Pseq([1], inf));
		~tmMulSnrP= Pseq([~tmMulSnr], inf).asStream;

		~tmSnr = PatternProxy( Pseq([1], inf));
		~tmSnrP= Pseq([~tmSnr], inf).asStream;

		~transSnr = PatternProxy( Pseq([0], inf));
		~transSnrP = Pseq([~transSnr], inf).asStream;
		~octSnr = PatternProxy( Pseq([4], inf));
		~octSnrP = Pseq([~octSnr], inf).asStream;
		//~legSnr = PatternProxy( Pseq([0.0], inf));
		//~legSnrP = Pseq([~legSnr], inf).asStream;
		~strSnr = PatternProxy( Pseq([1.0], inf));
		~strSnrP = Pseq([~strSnr], inf).asStream;

	}


	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				//~snrLate=~abLate;
				~snrLate.wait;

				this.p1(val);

				//~dur1SnrSon.value;
				~durMulP*((~dur1SnrP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~snrCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1SnrP.next/val], 1),
			\degree, Pseq([~nt1SnrP.next], inf),
			\amp, Pseq([~amp1SnrP.next], inf),
			\sustain, Pseq([~sus1SnrP.next],inf)*~susMulSnr,
			\mtranspose, Pseq([~transSnrP.next], inf)+~trSnr,
			\octave, Pseq([~octSnrP.next], inf)+~octMulSnr,
			\harmonic, Pseq([~strSnrP.next], inf)+~harmSnr
		).play;

		//this.count2;
		//this.timesCount;
	}

	*cntrl{

		//----Snr-------

		//TIME
		~tmMulSnrBut1.free;
		~tmMulSnrBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSnr.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', 1);

			});

			},
			'/tmMulSnr1'
		);
		~tmMulSnrBut2.free;
		~tmMulSnrBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSnr.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', 2);

			});

			},
			'/tmMulSnr2'
		);
		~tmMulSnrBut3.free;
		~tmMulSnrBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSnr.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', 3);

			});

			},
			'/tmMulSnr3'
		);

		~octSnrMulBut.free;
		~octSnrMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSnr = ~octMulSnr+1;
				~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

			});

			},
			'/octSnrMul'
		);

		~octSnrZeroBut.free;
		~octSnrZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSnr = 0;
				~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

			});

			},
			'/octSnrZero'
		);

		~octSnrDivBut.free;
		~octSnrDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSnr = ~octMulSnr-1;
				~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

			});

			},
			'/octSnrDiv'
		);

	}

	//Snr Beat Counter
	*timesCount {
		timeCnt = timeCnt + 1;
		timeCnt.switch(

			1, {  },
			4, {  },
			6, {  },
			8, {  },
			9, {  },
			10, {  },
			15, {  },
			17, {  },
			18, {
				("        -----------SnareTimesCnt"+timeCnt).postln;

				timeCnt=0;
			},

		);

	}

	*count2 {
		1.do{
			counter2 = counter2 + 1;
			counter2.switch(
				3, {
					("            SnareCnt"+counter2).postln;
					this.ctl_2;
					counter2 = 0;

				}

			)
		}

	}


	*ctl_1 {


	}

	*ctl_2 {


	}

	*ctl_3 {


	}
	*ctl_9 {



	}

	*ctl_18 {



	}

}

