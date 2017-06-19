
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
		this.globals; this.loadProxy; this.preSet; this.apc40;
	}

	*globals{

		~chMast=11;
		~timesMast=1;
		~octMast=4;
		~mastLate=0;

		~macrMast1=1; ~macrMast2=2;
		~macrMast3=3; ~macrMast4=4;
		~macrMast5=5; ~macrMast6=6;
		~macrMast7=7; ~macrMast8=8;


	}

	*loadProxy {
		~volMast = PatternProxy( Pseq([1], inf));
		~volMastP= Pseq([~volMast], inf).asStream;

		~ccMast = PatternProxy( Pseq([1], inf));
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
		~mdOut.control(~chMast, 1, 94); //mac_1
		~mdOut.control(~chMast, 2, 94); //mac_2
		~mdOut.control(~chMast, 3, 68); //mac_3
		~mdOut.control(~chMast, 4, 100); //mac_4
		~mdOut.control(~chMast, 5, 120); //mac_5
		~mdOut.control(~chMast, 6, 100); //mac_6
		~mdOut.control(~chMast, 7, 74); //mac_7
		~mdOut.control(~chMast, 8, 64); //mac_8

	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				~mastLate.wait;

				this.p1(val);

				~durMulP*((~dur1MastP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|

		Pbind(//Mast Filter
			\chan, ~chMast,
			\type, \midi, \midicmd, \control, \midiout,~mdOut,
			\ctlNum, Pseq([Pseq([~ccMastP.next],1)], inf),
			\dur, Pseq([Pseq([~dur1MastP.next/i],1)], ~actMastP.next),
			\control, Pseq([~ccValMastP.next], inf)
		).play;
		//this.count3;
	}

	*apc40{
		~volMast_APC.free;
		~volMast_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volMast', vel/127);
			~mdOut.control(13, 9, vel);

		},srcID:~apc40InID, chan:~apcLn7, ccNum:7);

		//Act ButA
		//Mast Activate
		~cntActLine7ButA=0;
		~mdActLine7ButA.free;
		~mdActLine7ButA=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine7ButA = ~cntActLine7ButA + 1;
				~cntActLine7ButA.switch(
					0,{},
					1, {
						IFAPC40.actLine7ButA(1);
					},
					2,{
						IFAPC40.actLine7ButA(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn7, noteNum:~actButA);

		//Act ButB
		//Mast Time Div2
		~cntActLine7ButB=0;
		~mdActLine7ButB.free;
		~mdActLine7ButB=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine7ButB = ~cntActLine7ButB + 1;
				~cntActLine7ButB.switch(
					0,{},
					1, {
						IFAPC40.actLine7ButB(1);
					},
					2,{
						IFAPC40.actLine7ButB(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn7, noteNum:~actButB);

		//Act ButC
		//Static Mast Activate
		~cntActLine7ButC=0;
		~mdActLine7ButC.free;
		~mdActLine7ButC=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine7ButC = ~cntActLine7ButC + 1;
				~cntActLine7ButC.switch(
					0,{},
					1, {
						IFAPC40.actLine7ButC(1);
					},
					2,{
						IFAPC40.actLine7ButC(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn7, noteNum:~actButC);


	}//*apc40


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


}