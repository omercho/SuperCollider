
/*
IFMast(2);
IFMast.p1;
PostAllMIDI.on;


~actMast.source=Pseq([1], inf);
~ccMast.source=Pxrand([1,2,3,4,5,6,7,8], inf);
~ccValMast.source=Pseq([1,24,0,50,120], inf);
~dur1Mast.source=Pxrand([1/2], inf);
*/


IFMast {
var <>rs1Time = 1;
classvar <>counter3 = 0;


	*initClass {
		StartUp add: {
		//Server.default.doWhenBooted({ this.globals; this.preSet; });
		}
	}
	*load{
		this.globals; this.loadProxy; this.preSet;
	}

	*globals{

		~chMast=14;
		~timesMast=1;
		~octMast=4;
		~resLate=0;

		~macrMast1=1; ~macrMast2=2;
		~macrMast3=3; ~macrMast4=4;
		~macrMast5=5; ~macrMast6=6;
		~macrMast7=7; ~macrMast8=8;


	}

	*defaultButtons {
		~actMastBut.free;
		~actMastBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actMast.source=1;
				~behOut.control(15, 0, 127);
			},{
					~actMast.source=0;
					~behOut.control(15, 0, 0);
			});
			},
			'/activMast'
		);
		~actMastMD.free;
		~actMastMD=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~actMast.source=1;
				~tOSCAdrr.sendMsg('activMast', 1);
				},{
					~actMast.source=0;
					~tOSCAdrr.sendMsg('activMast', 0);
			});
		}, chan:15, ccNum:0);

	}

	*loadProxy {
		~ccMast = PatternProxy( Pseq([0], inf));
		~ccMastP = Pseq([~ccMast], inf).asStream;

		~ccValMast = PatternProxy( Pseq([1], inf));
		~ccValMastP = Pseq([~ccValMast], inf).asStream;

		~dur1Mast = PatternProxy( Pseq([1], inf));
		~dur1MastP = Pseq([~dur1Mast], inf).asStream;

		~tmMulMast = PatternProxy( Pseq([1], inf));
		~tmMulMastP= Pseq([~tmMulMast], inf).asStream;
		~tmMast = PatternProxy( Pseq([1], inf));
		~tmMastP = Pseq([~tmMast], inf).asStream;


		~actMast = PatternProxy( Pseq([0], inf));
		~actMastP= Pseq([~actMast], inf).asStream;
	}


	*preSet{
		~mdOut.control(~chMast, 1, 94); //resonator Note
		~mdOut.control(~chMast, 2, 94); //resonator Decay
		~mdOut.control(~chMast, 3, 68); //resonator Filter freq
		~mdOut.control(~chMast, 4, 100); //resonator Color
		~mdOut.control(~chMast, 5, 120); //resonator Note gain
		~mdOut.control(~chMast, 6, 100); //resonator Width
		~mdOut.control(~chMast, 7, 74); //resonator Gain
		~mdOut.control(~chMast, 8, 64); //resonator Gain

	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				~resLate.wait;

				this.p1(val);

				~durMulP*((~dur1MastP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|

		Pbind(//resonator note
			\chan, ~chMast,
			\type, \midi, \midicmd, \control, \midiout,~mdOut,
			\ctlNum, Pseq([Pseq([~ccMastP.next],1)], inf),
			\dur, Pseq([Pseq([~dur1MastP.next/i],1)], ~actMastP.next),
			\control, Pseq([~ccValMastP.next], inf)
		).play;
		//this.count3;
	}

	//Mast Beat Counter
	*count3 {

		counter3 = counter3 + 1;
		counter3.switch(
			3, {
				("            MastCnt"+counter3).postln;
				this.ctl_3;
				counter3 = 0;

			}

		)
	}


	*ctl_1 {}

	*ctl_2 {}

	*ctl_3 {
		~mcrMast2.stop;
		~mcrMast2={
			var val;
			val = Pslide((30..100).mirror, inf,3,1,0).asStream;
			240.do{
				~mdOut.control(~chMast, ~macrMast2, val.next);
			(~dur.next*(1/8)).wait;
			}
		}.fork;

	}

	*ctl_9 {}

	*ctl_18 {}
}