
/*
IFSamp.times(12);
IFSamp.pat_1;
*/


IFSamp {
var <>smpTime = 1;
classvar <>counter3 = 0;


	*initClass {
		StartUp add: {
			this.globals;
			Server.default.doWhenBooted({  this.preSet; this.default; });
		}
	}

	*globals{

		~sampCh=5;
		~sampTimes=1;
		~octSamp=4;
		~transSamp=0;
		~legSamp=0;
		~stretchSamp=0;
		~sampMac1=1; ~sampMac2=2;~sampMac3=3; ~sampMac4=4;
		~sampMac5=5; ~sampMac6=6;~sampMac7=7; ~sampMac8=8;
	}

	*preSet {
		~md1.control(~sampCh, ~sampMac2, 94); //

	}
	*default {

		~nt1Samp = PatternProxy( Pseq([0], inf));
		~nt1SampP = Pseq([~nt1Samp], inf).asStream;
		~dur1Samp = PatternProxy( Pseq([1], inf));
		~dur1SampP = Pseq([~dur1Samp], inf).asStream;
		~amp1Samp = PatternProxy( Pseq([0.9], inf));
		~amp1SampP = Pseq([~amp1Samp], inf).asStream;
		~sus1Samp = PatternProxy( Pseq([1], inf));
		~sus1SampP = Pseq([~dur1Samp], inf).asStream;


	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~nt1SampP.next;
				~dur1SampP.next;
				~amp1SampP.next;
				~sus1SampP.next;

				~nt1SampSon=~nt1SampP;
				~dur1SampSon=~dur1SampP;
				~amp1SampSon=~amp1SampP;
				~sus1SampSon=~sus1SampP;
				//~nt1SampSon.value;
				//~dur1SampSon.value;
				//~amp1SampSon.value;
				//~sus1SampSon.value;

				this.p1(val);

				~durMul*((~dur1SampSon.value)/i).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~sampCh,
			\type, \midi, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([~dur1SampSon.value/val],1)], 1),
			\degree, Pseq([~nt1SampSon.value], 1),
			\amp, Pseq([~amp1SampSon.value], 1),
			\sustain, Pseq([~sus1SampSon.value],1),
			\mtranspose, Pseq([~transSamp.value], 1),
			\octave, ~octSamp,
			\legato, ~legSamp,
			\stretch, ~stretchSamp
		).play;



		//IFSampFX.resPat_1;
		//this.count3;

	}

	//Samp Beat Counter
	*count3 {
		1.do{
			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            SampCnt"+counter3).postln;
					this.ctl_3;
					counter3 = 0;

				}

			)
		}

	}


	*ctl_1 {}

	*ctl_2 {}

	*ctl_3 {  }

	*ctl_9 {}

	*ctl_18 {
		~sampMcr1.stop;
		~sampMcr1={
			var val;
			val = Pslide((30..120).mirror, inf,3,1,0).asStream;
			240.do{
				~md1.control(~sampCh, ~sampMac1, val.next);
			(~dur.next*(1/8)).wait;
			}
		}.fork;

		~sampMcr2.stop;
		~sampMcr2={
			var val;
			val = Pbrown(37,90, 1, inf).asStream;
			8.do{
				~md1.control(~sampCh, ~sampMac2, val.next);
			(~dur.next*(1/6)).wait;
			}
		}.fork;


	}


}

/*

IFSampFX {
	classvar <>resTime =1;
	*initClass { StartUp add: { this.globals; this.preSet;}}
	*globals{
		~sampResTimes=1;
		~sampFXMac1=10; ~sampResNote=11; ~sampFXMac2=12; ~sampFXMac3=13; ~sampFXMac4=14;
		~sampFXMac5=15; ~sampFXMac6=16; ~sampFXMac7=17; ~sampFXMac8=18;

	}

	*preSet {

		~md1.control(~sampCh, ~sampResNote, ~cM1); // sampResNote - preset:  42=C1
		~md1.control(~sampCh, 2, 94); //resonator Dry
		~md1.control(~sampCh, 2, 94); //resonator Decay
		~md1.control(~sampCh, 3, 68); //resonator Filter freq
		~md1.control(~sampCh, 4, 100); //resonator Color
		~md1.control(~sampCh, 5, 120); //resonator Note gain
		~md1.control(~sampCh, 6, 100); //resonator Width
		~md1.control(~sampCh, 7, 74); //resonator Gain

		~md1.control(~sampCh, 10, 104); //corpus Dry/Wet
		~md1.control(~sampCh, 11, 64); //corpus Tune

	}

	*times { arg resTime;

		{~sampResTimes = resTime;}.fork;
	}

	*resPat_1 { arg resTime;

		Pbind(//samp resonator note
			\chan, ~sampCh, \ctlNum, ~sampResNote,
			\type, \midi, \midicmd, \control, \midiout,~md1,
			\delta, Pseq([~durMul/3], ~sampResTimes),
			\control, Pseq([~nt1SampRes.next, ~nt2SampRes.next, ~nt3SampRes.next].degreeToKey(~scl2),inf)

		).play;

	}

}

*/
/*
IFCounter {
	classvar <>counter = 0;

	*count3 {
		1.do{
			counter = counter + 1;
			counter.switch(
				3, {
					("cnt"+counter).postln;
					counter = 0;

				}

			)
		}

	}

}

IFCounter.count3;
IFCounter.count3;
IFCounter.count3(1,4);
*/
/*
IFCounter {
	classvar <>counter=0;

	*count3 {

		{arg countStart=0, countTime=3;
		counter = countStart;
		1.do{
			counter = counter + 1;
			counter.switch(
				countTime.asInteger, {
					("cnt"+counter).postln;
					counter = 0;
				}

			)
		}
		}.fork;

	}

}

IFCounter {
	classvar <>countStartB=0, <>countTimeB=3;
	classvar <>counterB=0;

	*count3 {arg counter, countStart, countTime;

		countStartB = countStart ? countStartB;
		countTimeB = countTime ? countTimeB;
		counterB = counter ? counterB;

		counterB = countStartB;
		1.do{
			counterB = counterB + 1;
			counterB.switch(
				3, {
					("cnt"+counter).postln;
					counterB = countStartB;
				}

			)
		}

	}

}
*/