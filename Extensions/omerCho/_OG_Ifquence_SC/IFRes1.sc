
/*
IFRes1(2);
IFRes1.p1;
PostAllMIDI.on;
*/


IFRes1 {
var <>rs1Time = 1;
classvar <>counter3 = 0;


	*initClass {
		StartUp add: {
		//Server.default.doWhenBooted({ this.globals; this.preSet; });
		}
	}
	*load{
		this.globals; this.loadProxy; this.preSet; this.apc40;
	}

	*globals{

		~res1Ch=11;
		~res2Ch=12;
		~res1Times=1;
		~octRes1=4;
		~resLate=0;

		~res1Mac1=1; ~res1Mac2=2;
		~res1Mac3=3; ~res1Mac4=4;
		~res1Mac5=5; ~res1Mac6=6;
		~res1Mac7=7; ~res1Mac8=8;
	}

	*loadProxy{
		~nt1Res1 = PatternProxy( Pseq([1], inf));
		~nt1Res1P = Pseq([~nt1Res1]+12, inf).asStream;

		~dur1Res1 = PatternProxy( Pseq([1], inf));
		~dur1Res1P = Pseq([~dur1Res1], inf).asStream;

		~tmRes1 = PatternProxy( Pseq([1], inf));
		~tmRes1P = Pseq([~tmRes1], inf).asStream;
		~tmMulRes1 = PatternProxy( Pseq([1], inf));
		~tmMulRes1P = Pseq([~tmMulRes1], inf).asStream;

		~actRes1 = PatternProxy( Pseq([0], inf));
		~actRes1P= Pseq([~actRes1], inf).asStream;
	}

	*preSet{
		~mdOut.control(~res1Ch, 1, 94); //resonator Note
		~mdOut.control(~res1Ch, 2, 94); //resonator Decay
		~mdOut.control(~res1Ch, 3, 68); //resonator Filter freq
		~mdOut.control(~res1Ch, 4, 100); //resonator Color
		~mdOut.control(~res1Ch, 5, 120); //resonator Note gain
		~mdOut.control(~res1Ch, 6, 100); //resonator Width
		~mdOut.control(~res1Ch, 7, 74); //resonator Gain
		~mdOut.control(~res1Ch, 8, 64); //resonator Gain

	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				~resLate.wait;

				this.p1(val);

				~durMulP*((~dur1Res1P.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|

		Pbind(//resonator note
			\chan, ~res1Ch, \ctlNum, ~res1Mac1,
			\type, \midi, \midicmd, \control, \midiout,~mdOut,
			\dur, Pseq([Pseq([~dur1Res1P.next/i],1)], ~actRes1P.next),
			\control, Pseq([~nt1Res1P.next].degreeToKey(~scl2), inf),
			\octave, 4
		).play;
		//this.count3;
	}

	*apc40{
		~volMast_APC.free;
		~volMast_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volMast', vel/127);
			~mdOut.control(11, 9, vel);

		},srcID:~apc40InID, chan:~apcLine8, ccNum:7);

		//Act ButA
		//Mast Activate
		~cntActLine8ButA=0;
		~mdActLine8ButA.free;
		~mdActLine8ButA=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine8ButA = ~cntActLine8ButA + 1;
				~cntActLine8ButA.switch(
					0,{},
					1, {
						IFAPC40.actLine8ButA(1);
					},
					2,{
						IFAPC40.actLine8ButA(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLine8, noteNum:~actButA);

		//Act ButB
		//Mast Time Div2
		~cntActLine8ButB=0;
		~mdActLine8ButB.free;
		~mdActLine8ButB=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine8ButB = ~cntActLine8ButB + 1;
				~cntActLine8ButB.switch(
					0,{},
					1, {
						IFAPC40.actLine8ButB(1);
					},
					2,{
						IFAPC40.actLine8ButB(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLine8, noteNum:~actButB);

		//Act ButC
		//Static Mast Activate
		~cntActLine8ButC=0;
		~mdActLine8ButC.free;
		~mdActLine8ButC=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine8ButC = ~cntActLine8ButC + 1;
				~cntActLine8ButC.switch(
					0,{},
					1, {
						IFAPC40.actLine8ButC(1);
					},
					2,{
						IFAPC40.actLine8ButC(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLine8, noteNum:~actButC);


	}//*apc40

	//Res1 Beat Counter
	*count3 {

		counter3 = counter3 + 1;
		counter3.switch(
			3, {
				("            Res1Cnt"+counter3).postln;
				this.ctl_3;
				counter3 = 0;

			}

		)
	}


	*ctl_1 {}

	*ctl_2 {}

	*ctl_3 {
		~res1Mcr2.stop;
		~res1Mcr2={
			var val;
			val = Pslide((30..100).mirror, inf,3,1,0).asStream;
			240.do{
				~mdOut.control(~res1Ch, ~res1Mac2, val.next);
			(~dur.next*(1/8)).wait;
			}
		}.fork;

	}

	*ctl_9 {}

	*ctl_18 {}
}