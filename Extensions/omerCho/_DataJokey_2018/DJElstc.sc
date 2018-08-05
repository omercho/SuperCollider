/*
DJElstc(1);

~nt1Elstc.source = Pseq([1,2,3,4,5], inf);

*/

DJElstc {

	*initClass {
		StartUp add: {
			//Server.default.doWhenBooted({ this.load; });
		}
	}
	*load {
		this.globals;
		this.proxy;
		this.osc;
		this.apc40;

	}

	*globals{
		~lateElstc= 0.6;
		~chanElstc=0;
		~actElstc1=1;
		~timesElstc1=1;
		~octMulElstc1=0;
		~trElstc1=0;
		~rootElstc1=0;
		~harmElstc1=0;
		~susMulElstc1=1;
		~tuneElstc1=0;
	}

	*proxy {
		~lateElstc = PatternProxy( Pseq([0], inf));
		~lateElstcP = Pseq([~lateElstc], inf).asStream;
		~instElstc1 = PatternProxy( Pseq([60], inf));
		~instElstc1P = Pseq([~instElstc1], inf).asStream;
		~nt1Elstc1 = PatternProxy( Pseq([1], inf));
		~nt1Elstc1P = Pseq([~nt1Elstc1]*0.01, inf).asStream;
		~dur1Elstc1 = PatternProxy( Pseq([1], inf));
		~dur1Elstc1P = Pseq([~dur1Elstc1], inf).asStream;
		~amp1Elstc1 = PatternProxy( Pseq([1], inf));
		~amp1Elstc1P = Pseq([~amp1Elstc1]*(127/10), inf).asStream;
		~sus1Elstc1 = PatternProxy( Pseq([0.05], inf));
		~sus1Elstc1P = Pseq([~sus1Elstc1], inf).asStream;


		~actElstc1 = PatternProxy( Pseq([1], inf));
		~actElstc1P= Pseq([~actElstc1], inf).asStream;

		~lfo1ActElstc1P = PatternProxy( Pseq([1], inf));
		~lfo1ActElstc1P= Pseq([~lfo1ActElstc1P], inf).asStream;

		~volElstc1 = PatternProxy( Pseq([1.0], inf));
		~volElstc1P = Pseq([~volElstc1], inf).asStream;

		~lfo1DurElstc1 = PatternProxy( Pseq([1/1], inf));
		~lfo1DurElstc1P = Pseq([~lfo1DurElstc1], inf).asStream;



	}//*proxy

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				~lateElstcP.next.wait;

				this.p1(val);


				//~durMulRootDJP*((~dur1ElstcP.next)/val).wait;
				((~dur1ElstcP.next)*(~durMulRootDJP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;

		/*Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~elstc, \chan, ~chanElstc, \ctlNum, 10,
			\delta, Pseq([~lfo1DurElstc1P.next], ~lfo1ActElstc1P),
			\control, PdegreeToKey(
				Pseq([~tuneElstc1+~nt1Elstc1P.next], 1),
				Pfunc({~scl2}),
				12),
		).play(quant:0);
		Pbind(
			\chan, ~chanElstc,
			\type, \midi, \midiout,~elstc,
			\octave,0,
			\note, Pseq([~instElstc1P.next], inf),
			\dur, Pseq([~dur1Elstc1P.next], ~actElstc1P),
			\amp, Pseq([~amp1Elstc1P.next], inf),
			\sustain, Pseq([~sus1Elstc1P.next],inf)*~susMulElstc1
		).play(quant:0);*/
		Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~elstc, \chan, ~chanElstc, \ctlNum, 0,
			\delta, Pseq([~lfo1DurElstc1P.next], ~lfo1ActElstc1P),
			\control, Pseq([~amp1Elstc1P.next], inf)
		).play(quant:0);
		Pbind(
			\chan, ~chanElstc,
			\type, \midi, \midiout,~elstc,
			\octave,0,
			\note, Pseq([~instElstc1P.next], inf),
			\dur, Pseq([~dur1Elstc1P.next], ~actElstc1P),
			\amp,PdegreeToKey(
				Pseq([~tuneElstc1+~nt1Elstc1P.next], 1),
				Pfunc({~scl2}),
				12),
			\sustain, Pseq([~sus1Elstc1P.next],inf)*~susMulElstc1
		).play(quant:0);



	}//*p1

	/**stat01 {|i=1|
	var val;
	val=i;
	~staticElstcPat=Pbind(
	\chan, ~chanElstc,
	\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
	\dur, Pseq([~durStElstcP.next],~actStElstcP.next),
	\degree, Pseq([~ntStElstcP.next], inf),
	\amp, Pseq([~ampStElstcP.next], inf)
	).play(TempoClock.default, quant: 0);
	}//stat01*/

	*apc40{
		~volElstc_APC.free;
		~volElstc_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volVSamp05', vel/127);
			~volElstc.source = vel;
		},srcID:~djMnInID, chan:~apcMnCh, ccNum:~apcFd7);

		//Act ButA1
		//Elstc Activate
		~cntActLine7ButA7=0;
		~mdActLine7ButA7.free;
		~mdActLine7ButA7=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine7ButA7 = ~cntActLine7ButA7 + 1;
				~cntActLine1ButA1.switch(
					0,{},
					1, {
						IFAPC40.actLine7ButA7(1);
					},
					2,{
						IFAPC40.actLine7ButA7(0);
					}
			)}
			);
		},srcID:~djMnInID, chan:~djMnCh, noteNum:~actButA7);

		//Act ButB1
		//Elstc Time Div2
		~cntActLine1ButB1=0;
		~mdActLine1ButB1.free;
		~mdActLine1ButB1=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine1ButB1 = ~cntActLine1ButB1 + 1;
				~cntActLine1ButB1.switch(
					0,{},
					1, {
						IFAPC40.actLine7ButB1(1);
					},
					2,{
						IFAPC40.actLine7ButB1(0);
					}
			)}
			);
		},srcID:~djMnInID, chan:~apcMnCh, noteNum:~actButB1);

		//Act ButC1
		//Static Elstc Activate
		~cntActLine1ButC1=0;
		~mdActLine1ButC1.free;
		~mdActLine1ButC1=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine1ButC1 = ~cntActLine1ButC1 + 1;
				~cntActLine1ButC1.switch(
					0,{},
					1, {
						IFAPC40.actLine7ButC1(1);
					},
					2,{
						IFAPC40.actLine7ButC1(0);
					}
			)}
			);
		},srcID:~djMnInID, chan:~apcMnCh, noteNum:~actButC1);


	}//*DJMn

	*osc{
		~lateElstcMulBut.free;
		~lateElstcMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulKick = ~octMulKick+1;
				//~tOSCAdrr.sendMsg('octKickLabel', ~octMulKick);

			});

			},
			'/octKickMul'
		);

		~lateElstcZeroBut.free;
		~lateElstcZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulKick = 0;
				~tOSCAdrr.sendMsg('octKickLabel', ~octMulKick);

			});

			},
			'/octKickZero'
		);

		~lateElstcDivBut.free;
		~lateElstcDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulKick = ~octMulKick-1;
				~tOSCAdrr.sendMsg('octKickLabel', ~octMulKick);

			});

			},
			'/octKickDiv'
		);

	}
	*preset1{
		~nt1Elstc1.source   =  Pseq([7.4], inf);
		~amp1Elstc1.source  =  Pseq([10,0,10,0], inf);
		~sus1Elstc1.source  =  Pseq([0.1], inf);
		~lfo1ActElstc1.source=1;
		~durMulRootDJ.source=Pseq([1], inf);
		~lateElstc.source =(0.4);

		DJElstc(1);
	}
}
