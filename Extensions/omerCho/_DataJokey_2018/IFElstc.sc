/*
IFElstc(1);

~nt1Elstc.source = Pseq([1,2,3,4,5], inf);

*/

IFElstc {

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

		~chanElstc=0;
		~actElstc=1;
		~lateElstc= 0.00;
		~timesElstc=1;
		~octMulElstc=0;
		~trElstc=0;
		~rootElstc=0;
		~harmElstc=0;
		~susMulElstc=1;
		~tuneElstc=26;
	}

	*proxy {
		~instElstc = PatternProxy( Pseq([1], inf));
		~instElstcP = Pseq([~instElstc], inf).asStream;

		~nt1Elstc = PatternProxy( Pseq([1], inf));
		~nt1ElstcP = Pseq([~nt1Elstc], inf).asStream;
		~dur1Elstc = PatternProxy( Pseq([1], inf));
		~dur1ElstcP = Pseq([~dur1Elstc], inf).asStream;
		~amp1Elstc = PatternProxy( Pseq([1], inf));
		~amp1ElstcP = Pseq([~amp1Elstc], inf).asStream;
		~sus1Elstc = PatternProxy( Pseq([0.05], inf));
		~sus1ElstcP = Pseq([~sus1Elstc], inf).asStream;



		~transElstc = PatternProxy( Pseq([0], inf));
		~transElstcP = Pseq([~transElstc], inf).asStream;
		~transShufElstc = PatternProxy( Pseq([0], inf));
		~transShufElstcP = Pseq([~transShufElstc], inf).asStream;
		~extraShufElstc = PatternProxy( Pshuf([0], inf));
		~extraShufElstcP = Pseq([~extraShufElstc], inf).asStream;

		~octElstc = PatternProxy( Pseq([0], inf));
		~octElstcP = Pseq([~octElstc], inf).asStream;

		~hrmElstc = PatternProxy( Pseq([1.0], inf));
		~hrmElstcP = Pseq([~hrmElstc], inf).asStream;

		~actElstc = PatternProxy( Pseq([1], inf));
		~actElstcP= Pseq([~actElstc], inf).asStream;

		~lfo1ActElstcP = PatternProxy( Pseq([0], inf));
		~lfo1ActElstcP= Pseq([~lfo1ActElstcP], inf).asStream;

		~volElstc = PatternProxy( Pseq([1.0], inf));
		~volElstcP = Pseq([~volElstc], inf).asStream;

		~lfo1DurElstc = PatternProxy( Pseq([1/1], inf));
		~lfo1DurElstcP = Pseq([~lfo1DurElstc], inf).asStream;

		~lateElstc = PatternProxy( Pseq([0], inf));
		~lateElstcP = Pseq([~lateElstc], inf).asStream;


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

		Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~elstc, \chan, ~chanElstc, \ctlNum, 10,
			\delta, Pseq([~lfo1DurElstcP.next], ~lfo1ActElstcP),
			\control, PdegreeToKey(
				Pseq([~tuneElstc+~nt1ElstcP.next], 1),
				Pfunc({~scl2}),
				12),
		).play(quant:0);
		Pbind(
			\chan, ~chanElstc,
			\type, \midi, \midiout,~elstc,
			\octave,~octElstcP,
			\note, Pseq([~instElstcP.next], inf),
			\dur, Pseq([~dur1ElstcP.next], ~actElstcP),
			\amp, Pseq([~amp1ElstcP.next], inf),
			\sustain, Pseq([~sus1ElstcP.next],inf)*~susMulElstc
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
		},srcID:~apc40InID, chan:~apcMnCh, ccNum:~apcFd7);

		//Act ButA1
		//Elstc Activate
		~cntActLine1ButA1=0;
		~mdActLine1ButA1.free;
		~mdActLine1ButA1=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine1ButA1 = ~cntActLine1ButA1 + 1;
				~cntActLine1ButA1.switch(
					0,{},
					1, {
						IFAPC40.actLine7ButA1(1);
					},
					2,{
						IFAPC40.actLine7ButA1(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButA1);

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
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButB1);

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
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButC1);


	}//*apc40

	*osc{

		~actElstcBut.free;
		~actElstcBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actElstc.source=1;
				~apc40.noteOn(~apcMnCh, ~actButA1, 127); //Trk1_But 1
				},{
					~actElstc.source=0;
					~apc40.noteOff(~apcMnCh, ~actButA1, 127); //Trk1_But 1
			});
			},
			'/activElstc'
		);
		~time2ElstcBut.free;
		~countTime2Elstc=0;
		~time2ElstcBut= OSCFunc({
			arg msg;

			~countTime2Elstc = ~countTime2Elstc + 1;
			~countTime2Elstc.switch(
				1,{
					~apc40.noteOn(0, ~actButB1, 1);
					~tOSCAdrr.sendMsg('time2Elstc', 1);
					~tOSCAdrr.sendMsg('tmElstcLabel', 2);
					~tmMulElstc.source = Pseq([2], inf);
					//~extraShufElstc.source = Pshuf([2,0,2,3,0], inf);
				},
				2,{
					~apc40.noteOn(0, ~actButB1, 0);
					~tOSCAdrr.sendMsg('time2Elstc', 0);
					~tOSCAdrr.sendMsg('tmElstcLabel', 1);
					~tmMulElstc.source = Pseq([1], inf);
					//~extraShufElstc.source = Pshuf([0], inf);
					~countTime2Elstc=0;
			})

			},
			'/time2Elstc'
		);

		~volElstcFader.free;
		~volElstcFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volElstc', msg[1]);
			~mdOut.control(2, 1, vel);
			},
			'/volElstc'
		);

		~attElstcFader.free;
		~attElstcFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('attElstc', msg[1]);
			~mdOut.control(2, 5, vel);
			//~nobD1_m2Val= msg[1]*127;
			},
			'attElstc'
		);

		~susLevElstcFader.free;
		~susLevElstcFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('susElstc', msg[1]);
			~susLevElstc=msg[1];
			~mdOut.control(2, 6, msg[1]*127);


			},
			'/susElstc'
		);

		~decElstcFader.free;
		~decElstcFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('decElstc', val);
			~decElstc= val;
			~mdOut.control(2, 127, vel);
			//~nobD1_m1Val= vel;
			},
			'/decElstc'
		);

		~chainElstcFader.free;
		~chainElstcFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('chainElstc', msg[1]);
			~mdOut.control(2, 8, msg[1]*127);
			},
			'/chainElstc'
		);

		~sendElstcXY.free;
		~sendElstcXY= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~mdOut.control(2, 4, vel1); // IFElstc
			~mdOut.control(2, 3, vel2); // IFElstc
			~tOSCAdrr.sendMsg('sendElstc', msg[1], msg[2]);

			},
			'sendElstc'
		);

		//TIME

		~tmMulElstcBut1.free;
		~tmMulElstcBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulElstc.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmElstcLabel', 1);

			});

			},
			'/tmMulElstc1'
		);
		~tmMulElstcBut2.free;
		~tmMulElstcBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulElstc.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmElstcLabel', 2);

			});

			},
			'/tmMulElstc2'
		);
		~tmMulElstcBut3.free;
		~tmMulElstcBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulElstc.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmElstcLabel', 3);

			});

			},
			'/tmMulElstc3'
		);
		~tmElstcFader.free;
		~tmElstcFader= OSCFunc({
			arg msg;
			~tmElstc.source = msg[1];

			},
			'/timesElstc'
		);

		~padElstc.free;
		~padElstc = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFElstc(~tmMulElstcP.next*~tmElstcP.next);

			});
			},
			'/padElstc'
		);

		//----Elstc-------
		~octElstcMulBut.free;
		~octElstcMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulElstc = ~octMulElstc+1;
				~tOSCAdrr.sendMsg('octElstcLabel', ~octMulElstc);

			});

			},
			'/octElstcMul'
		);

		~octElstcZeroBut.free;
		~octElstcZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulElstc = 0;
				~tOSCAdrr.sendMsg('octElstcLabel', ~octMulElstc);

			});

			},
			'/octElstcZero'
		);

		~octElstcDivBut.free;
		~octElstcDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulElstc = ~octMulElstc-1;
				~tOSCAdrr.sendMsg('octElstcLabel', ~octMulElstc);

			});

			},
			'/octElstcDiv'
		);






	}
}
