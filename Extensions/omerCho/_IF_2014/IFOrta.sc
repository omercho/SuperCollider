
/*
IFOrta.times(2);
IFOrta.pat_1;
*/


IFOrta {
var <>ortTime = 1;
classvar <>counter3=0, counter18=0;


	*initClass {
		StartUp add: {
		Server.default.doWhenBooted({ this.globals; this.preSet; });
		}
	}

	*globals{

		~ortaCh=6;
		~ortaTimes=1;
		~octOrta=4;
		~ortaMac1=1; ~ortaMac2=2;
		~ortaMac3=3; ~ortaMac4=4;
		~ortaMac5=5; ~ortaMac6=6;
		~ortaMac7=7; ~ortaMac8=8;
	}

	*preSet{}

	*times { arg ortTime; {~ortaTimes = ortTime;}.fork;}

	*pat_1 { arg ortTime;

	Pbind(
		\type, \midi, \chan, ~ortaCh, \midiout,~md1, \scale, Pfunc({~scl2}, inf),
		\dur, Pseq([~durMul/3], ~ortaTimes),
		\degree, Pseq([~nt1Orta.next, ~nt2Orta.next, ~nt3Orta.next], inf),
		\amp, Pseq([~amp1Orta.next, ~amp2Orta.next, ~amp3Orta.next], inf),
		\sustain, Pseq([~sus1Orta.next, ~sus2Orta.next, ~sus3Orta.next], inf),
		\mtranspose, Pseq([~mTrans], inf),
		\octave, ~octOrta
	).play;
		this.count3;
	}

	//Orta Beat Counter
	*count3 {

			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            OrtaCnt"+counter3).postln;
					this.ctl_3;
					counter3 = 0;

				}

			)


	}

	*count18 {

			counter18 = counter18 + 1;
			counter3.switch(
				18, {
					("            OrtaCnt"+counter18).postln;
					this.ctl_18;
					counter18 = 0;

				}

			)


	}

	*ctl_1 {


	}

	*ctl_2 {
		("Orta CTL 2").postln;

	}

	*ctl_3 {

		Pbind(//att
			\chan, ~ortaCh, \ctlNum, ~ortaMac1,
			\type, \midi, \midicmd, \control, \midiout,~md1,
			\delta, Pseq([~durMul/2], ~ortaTimes*2),
			\control, Pbrown(17,26, 1, inf)
		).play;

		~ortaMcr1.stop;
		~ortaMcr1={
			var val;
			val = Pslide((30..120).mirror, inf,3,1,0).asStream;
			240.do{
				~md1.control(~ortaCh, 0, val.next);
				(~dur.next*(1/8)).wait;
			}
		}.fork;

		~ortaMcr4.stop;
		~ortaMcr4={
			var val;
			val = Pbrown(37,90, 1, inf).asStream;
			8.do{
				~md1.control(~ortaCh, ~ortaMac4, val.next);
				(~dur.next*(1/6)).wait;
			}
		}.fork;

		~ortaMcr5.stop;
		~ortaMcr5={
			var val;
			val = Pbrown(37,90, 1, inf).asStream;
			8.do{
				~md1.control(~ortaCh, ~ortaMac5, val.next);
				(~dur.next*(1/6)).wait;
			}
		}.fork;


	}
	*ctl_9 {


	}

	*ctl_18 {


		~ortaMcr2.stop;
		~ortaMcr2={
			var val;
			val = Pseq((47..57).mirror, inf).asStream;
			220.do{
				~md1.control(~ortaCh, ~ortaMac2, val.next);
				(~dur.next*(1/6)).wait;
			}
		}.fork;
		~ortaMcr3.stop;
		~ortaMcr3={//Decay
			var val;
			val = Pseq((40..100).mirror, inf).asStream;
			220.do{
				~md1.control(~ortaCh, ~ortaMac3, val.next);
				(~dur.next*(1/7)).wait;
			}
		}.fork;


	}
}