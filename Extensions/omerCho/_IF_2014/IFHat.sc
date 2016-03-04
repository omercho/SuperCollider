
/*

IFHat.times(4);
*/

	IFHat {
	classvar <>counter3=0, timeCnt=0;
	var<>hTime=1;


	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.cntrl; });
		}
	}

	*globals{

		~hatCh=2;
		~hatLate=0.00;
		~hatTimes=1;
		~harmHat=0;
		~rootHat=0;
		~susMulHat=1;
		~trHat=0;


		~octMulHat=0;
		~hatVolC=1;
	}

	*preSet {

		~md1.control(~hatCh, ~hatVolC, 100); //HatVol
	}

	*default {

		~nt1Hat = PatternProxy( Pseq([0], inf));
		~nt1HatP = Pseq([~nt1Hat], inf).asStream;
		~dur1Hat = PatternProxy( Pseq([1], inf));
		~dur1HatP = Pseq([~dur1Hat], inf).asStream;
		~amp1Hat = PatternProxy( Pseq([1], inf));
		~amp1HatP = Pseq([~amp1Hat], inf).asStream;
		~sus1Hat = PatternProxy( Pseq([1], inf));
		~sus1HatP = Pseq([~sus1Hat], inf).asStream;

		~tmMulHat = PatternProxy( Pseq([1], inf));
		~tmMulHatP= Pseq([~tmMulHat], inf).asStream;
		~tmHat = PatternProxy( Pseq([1], inf));
		~tmHatP= Pseq([~tmHat], inf).asStream;

		~transHat = PatternProxy( Pseq([0], inf));
		~transHatP = Pseq([~transHat], inf).asStream;
		~octHat = PatternProxy( Pseq([3], inf));
		~octHatP = Pseq([~octHat], inf).asStream;
		~legHat = PatternProxy( Pseq([3.0], inf));
		~legHatP = Pseq([~legHat], inf).asStream;
		~strHat = PatternProxy( Pseq([1.0], inf));
		~strHatP = Pseq([~strHat], inf).asStream;

	}

	*times { arg hTime;

		{
			~hatTimes =  hTime;
		}.fork;
	}

	*oct { arg hOct;

		{
			~octHat =  hOct;
		}.fork;
	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				//~hatLate=~abLate;
				~hatLate.wait;

				this.p1(val);

				~durMulP*((~dur1HatP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;

		Pbind(
			\chan, ~hatCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([~dur1HatP.next/val],1)], 1),
			\degree, Pseq([~nt1HatP.next], 1),
			\amp, Pseq([~amp1HatP.next], 1),
			\sustain, Pseq([~sus1HatP.next],1)*~susMulHat,
			\mtranspose, Pseq([~transHatP.next], 1)+~trHat,
			\octave, Pseq([~octHatP.next], 1)+~octMulHat,
			\root, Pseq([~legHatP.next], 1),
			\harmonic, Pseq([~strHatP.next], 1)+~harmHat
		).play;

		//this.count2;
		//this.timesCount;
	}

	*cntrl {

		//----Hat-------
		//TIME
		~tmMulHatBut1.free;
		~tmMulHatBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulHat.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmHatLabel', 1);

			});

			},
			'/tmMulHat1'
		);
		~tmMulHatBut2.free;
		~tmMulHatBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulHat.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmHatLabel', 2);

			});

			},
			'/tmMulHat2'
		);
		~tmMulHatBut3.free;
		~tmMulHatBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulHat.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmHatLabel', 3);

			});

			},
			'/tmMulHat3'
		);

		~octHatMulBut.free;
		~octHatMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulHat = ~octMulHat+1;
				~tOSCAdrr.sendMsg('octHatLabel', ~octMulHat);

			});

			},
			'/octHatMul'
		);

		~octHatZeroBut.free;
		~octHatZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulHat = 0;
				~tOSCAdrr.sendMsg('octHatLabel', ~octMulHat);

			});

			},
			'/octHatZero'
		);

		~octHatDivBut.free;
		~octHatDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulHat = ~octMulHat-1;
				~tOSCAdrr.sendMsg('octHatLabel', ~octMulHat);

			});

			},
			'/octHatDiv'
		);

	}


	//Hat Counter
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
				("        -----------HatTimesCnt"+timeCnt).postln;

				timeCnt=0;
			},

		);

	}

	*count3 {
		1.do{
			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            hatCnt"+counter3).postln;
					this.ctl_3;
					counter3 = 0;

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

