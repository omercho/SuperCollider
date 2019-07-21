
/*
IFRes(2);
IFRes.p1;
PostAllMIDI.on;
*/


IFRes {

	/**initClass {
		StartUp add: {
		//Server.default.doWhenBooted({ this.globals; this.preSet; });
		}
	}*/
	*load{
		this.globals;
		this.loadProxy;
		this.preSet;
		this.apc40;
	}

	*globals{

		~chRes=12;
		~resTimes=1;
		~octRes=4;
		~resLate=0;

		~resMac1=1; ~resMac2=2;
		~resMac3=3; ~resMac4=4;
		~resMac5=5; ~resMac6=6;
		~resMac7=7; ~resMac8=8;
	}

	*loadProxy{

		~ccRes = PatternProxy( Pseq([0], inf));
		~ccResP = Pseq([~ccRes], inf).asStream;
		~ccValRes = PatternProxy( Pseq([0], inf));
		~ccValResP = Pseq([~ccValRes], inf).asStream;

		~nt1Res = PatternProxy( Pseq([1], inf));
		~nt1ResP = Pseq([~nt1Res]+12, inf).asStream;

		~dur1Res = PatternProxy( Pseq([1], inf));
		~dur1ResP = Pseq([~dur1Res], inf).asStream;

		~tmRes = PatternProxy( Pseq([1], inf));
		~tmResP = Pseq([~tmRes], inf).asStream;
		~tmMulRes = PatternProxy( Pseq([1], inf));
		~tmMulResP = Pseq([~tmMulRes], inf).asStream;

		~actRes = PatternProxy( Pseq([0], inf));
		~actResP= Pseq([~actRes], inf).asStream;
	}

	*preSet{
		//~mdOut.control(~chRes, 1, 94); //resonator Note
		//~mdOut.control(~chRes, 2, 94); //resonator Decay
		//~mdOut.control(~chRes, 3, 68); //resonator Filter freq
		//~mdOut.control(~chRes, 4, 100); //resonator Color
		//~mdOut.control(~chRes, 5, 120); //resonator Note gain
		//~mdOut.control(~chRes, 6, 100); //resonator Width
		//~mdOut.control(~chRes, 7, 74); //resonator Gain
		//~mdOut.control(~chRes, 8, 64); //resonator Gain

	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				~resLate.wait;

				this.p1(val);

				~durMulP*((~dur1ResP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|

		Pbind(//resonator note
			\chan, ~chRes,
			\type, \midi, \midicmd, \control, \midiout,~mdOut,
			\ctlNum, Pseq([Pseq([~ccResP.next],1)], inf),
			\dur, Pseq([Pseq([~dur1ResP.next/i],1)], ~actResP.next),
			\control, Pseq([~nt1ResP.next].degreeToKey(~scl2), inf),
			\octave, 4
		).play;
		//this.count3;
	}

	*apc40{
		~volRes1_APC.free;
		~volRes1_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volRes1', vel/127);
			~mdOut.control(11, 9, vel);

		},srcID:~apc40InID, chan:~apcMnCh, ccNum:~apcFd8);

		//Act ButA8
		//Res1 Activate
		~cntActLine8ButA8=0;
		~mdActLine8ButA8.free;
		~mdActLine8ButA8=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine8ButA8 = ~cntActLine8ButA8 + 1;
				~cntActLine8ButA8.switch(
					0,{},
					1, {
						IFAPCMn.actLine8ButA8(1);
					},
					2,{
						IFAPCMn.actLine8ButA8(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButA8);

		//Act ButB8
		//Res1 Time Div2
		~cntActLine8ButB8=0;
		~mdActLine8ButB8.free;
		~mdActLine8ButB8=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine8ButB8 = ~cntActLine8ButB8 + 1;
				~cntActLine8ButB8.switch(
					0,{},
					1, {
						IFAPCMn.actLine8ButB8(1);
					},
					2,{
						IFAPCMn.actLine8ButB8(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButB8);

		//Act ButC8
		//Static Res1 Activate
		~cntActLine8ButC8=0;
		~mdActLine8ButC8.free;
		~mdActLine8ButC8=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine8ButC8 = ~cntActLine8ButC8 + 1;
				~cntActLine8ButC8.switch(
					0,{},
					1, {
						IFAPCMn.actLine8ButC8(1);
					},
					2,{
						IFAPCMn.actLine8ButC8(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButC8);


	}//*apc40

}