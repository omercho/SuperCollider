
/*
IFSamp.times(2);
IFSamp.pat_1;

~octSamp=4;

*/


IFSamp {
	var <>keyTime = 1;
	classvar <>counter3 = 0;



	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });*/
		}
	}

	*globals{

		~chSamp=5;
		~sampLate=0.00;
		~timesSamp=1;
		~octMulSamp=0;
		~rootFreqSamp=~c5; // 261=C4|523=C5
		~harmSamp=0;
		~susMulSamp=1;
		~lfoMulSamp1=0;
		~lfoMulSamp2=0;
		~trSamp=0;



	}

	*preSet{

	}


	*default {

		//~samplerEvent = Event.default.put(\freq, { ~midinote.midicps / ~sampleBaseFreq });

		~nt1Samp = PatternProxy( Pseq([0], inf));
		~nt1SampP = Pseq([~nt1Samp], inf).asStream;
		~dur1Samp = PatternProxy( Pseq([1], inf));
		~dur1SampP = Pseq([~dur1Samp], inf).asStream;
		~amp1Samp = PatternProxy( Pseq([0.9], inf));
		~amp1SampP = Pseq([~amp1Samp], inf).asStream;
		~sus1Samp = PatternProxy( Pseq([1], inf));
		~sus1SampP = Pseq([~sus1Samp], inf).asStream;

		~tmMulSamp = PatternProxy( Pseq([1], inf));
		~tmMulSampP= Pseq([~tmMulSamp], inf).asStream;
		~tmSamp = PatternProxy( Pseq([1], inf));
		~tmSampP= Pseq([~tmSamp], inf).asStream;

		~transSamp = PatternProxy( Pseq([0], inf));
		~transSampP = Pseq([~transSamp], inf).asStream;

		~transShufSamp = PatternProxy( Pseq([0], inf));
		~transShufSampP = Pseq([~transShufSamp], inf).asStream;

		~octSamp = PatternProxy( Pseq([3], inf));
		~octSampP = Pseq([~octSamp], inf).asStream;

		~legSamp= PatternProxy( Pseq([0.0], inf));
		~legSampP = Pseq([~legSamp], inf).asStream;
		~strSamp = PatternProxy( Pseq([1.0], inf));
		~strSampP = Pseq([~strSamp], inf).asStream;

		~delta1Samp = PatternProxy( Pseq([1/4], inf));
		~delta1SampP = Pseq([~delta1Samp], inf).asStream;
		~delta2Samp = PatternProxy( Pseq([1/2], inf));
		~delta2SampP = Pseq([~delta2Samp], inf).asStream;

		~lfo1Samp = PatternProxy( Pseq([1], inf));
		~lfo1SampP = Pseq([~lfo1Samp], inf).asStream;
		~lfo2Samp = PatternProxy( Pseq([1], inf));
		~lfo2SampP = Pseq([~lfo2Samp], inf).asStream;

		~actSamp = PatternProxy( Pseq([1], inf));
		~actSampP= Pseq([~actSamp], inf).asStream;


	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				//~sampLate=~abLate;
				~sampLate.wait;

				this.p1(val);

				~durMulP*((~dur1SampP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;

		Pbind(
			\chan, ~chSamp,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1SampP.next/val],~actSampP),
			\degree, Pseq([~nt1SampP.next], 1),
			\amp, Pseq([~amp1SampP.next], 1),
			\sustain, Pseq([~sus1SampP.next],1)*~susMulSamp,
			\mtranspose, Pseq([~transSampP.next], 1)+~trSamp+~transShufSampP.next,
			\octave, Pseq([~octSampP.next], 1)+~octMulSamp,
			\harmonic, Pseq([~strSampP.next], 1)+~harmSamp


		).play;

		Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~mdOut, \chan, 7, \ctlNum, 40,
			\delta, Pseq([~delta1SampP.next], 1),
			\control, Pseq([~lfo1SampP.next], 1)*~lfoMulSamp1,

		).play;

		Pbind(//LFO 2
			\type, \midi, \midicmd, \control,
			\midiout,~mdOut,\chan, 7,  \ctlNum, 41,
			\delta, Pseq([~delta2SampP.next], 1),
			\control, Pseq([~lfo2SampP.next], 1)*~lfoMulSamp2,

		).play;

		//this.count2;
		//this.timesCount;
	}

	*osc{

		~actSampBut.free;
		~actSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actSamp.source=1;
				~behOut.control(7, 2, 127);
			},{
					~actSamp.source=0;
					~behOut.control(7, 2, 0);
			});
			},
			'/activSamp'
		);
		~actSampMD.free;
		~actSampMD=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~actSamp.source=1;
				~tOSCAdrr.sendMsg('activSamp', 1);
				},{
					~actSamp.source=0;
					~tOSCAdrr.sendMsg('activSamp', 0);
			});
		}, chan:7, ccNum:2);

		//TIME

		~time2SampBut.free;
		~countTime2Samp=0;
		~time2SampBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {//"Transpose Shuffle".postln;
				~countTime2Samp = ~countTime2Samp + 1;
				~countTime2Samp.switch(
					0,{},
					1, {
						~behOut.control(7, 9, 127);
						~tOSCAdrr.sendMsg('time2Samp', 1);
						~tOSCAdrr.sendMsg('tmSampLabel', 2);
						~tmMulSamp.source = Pseq([2], inf);
					},
					2,{
						~behOut.control(7, 9, 0);
						~tOSCAdrr.sendMsg('time2Samp', 0);
						~tOSCAdrr.sendMsg('tmSampLabel', 1);
						~tmMulSamp.source = Pseq([1], inf);
						~countTime2Samp=0;
					}
				)}
			);
			},
			'/time2Samp'
		);

		~time2SampMD.free;
		~time2SampMD=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~countTime2Samp = ~countTime2Samp + 1;
				~tOSCAdrr.sendMsg('time2Samp', 1);
				~tOSCAdrr.sendMsg('tmSampLabel', 2);
				~tmMulSamp.source = Pseq([2], inf);
				},{
					~tOSCAdrr.sendMsg('time2Samp', 0);
					~tOSCAdrr.sendMsg('tmSampLabel', 1);
					~tmMulSamp.source = Pseq([1], inf);
					~countTime2Samp=0;
			});
		}, chan:7, ccNum:9);

		~volSampFader.free;
		~volSampFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volSamp', msg[1]);
			~mdOut.control(7, 1, vel);
			},
			'/volSamp'
		);

		~attSampFader.free;
		~attSampFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('attSamp', msg[1]);
			~mdOut.control(7, 5, vel);
			},
			'attSamp'
		);

		~susLevSampFader.free;
		~susLevSampFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('susSamp', msg[1]);
			~susLevSamp=msg[1];
			~mdOut.control(7, 6, msg[1]*127);

			},
			'/susSamp'
		);

		~decSampFader.free;
		~decSampFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('decSamp', msg[1]);
			~decSamp=msg[1];
			~mdOut.control(7, 7, msg[1]*127);
			},
			'/decSamp'
		);

		~chainSampFader.free;
		~chainSampFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('chainSamp', msg[1]);
			~mdOut.control(7, 8, msg[1]*127);
			},
			'/chainSamp'
		);

		~sendSampXY.free;
		~sendSampXY= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~mdOut.control(7, 4, vel1); // IFSamp
			~mdOut.control(7, 3, vel2); // IFSamp
			~tOSCAdrr.sendMsg('sendSamp', msg[1], msg[2]);

			},
			'sendSamp'
		);

		~xy1Samp.free;
		~xy1Samp= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~mdOut.control(7, 11, vel1); // IFSamp
			~mdOut.control(7, 12, vel2); // IFSamp
			~tOSCAdrr.sendMsg('xy1Samp', msg[1], msg[2]);

			},
			'xy1Samp'
		);

		~lfoMulSampFad1.free;
		~lfoMulSampFad1= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulSamp1', msg[1]);
			~lfoMulSamp1=msg[1];
			},
			'/lfoMulSamp1'
		);

		~lfoMulSampFad2.free;
		~lfoMulSampFad2= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulSamp2', msg[1]);
			~lfoMulSamp2=msg[1];
			},
			'/lfoMulSamp2'
		);
		//TIME

		~tmMulSampBut1.free;
		~tmMulSampBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSamp.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 1);

			});

			},
			'/tmMulSamp1'
		);
		~tmMulSampBut2.free;
		~tmMulSampBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSamp.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 2);

			});

			},
			'/tmMulSamp2'
		);
		~tmMulSampBut3.free;
		~tmMulSampBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSamp.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 3);

			});

			},
			'/tmMulSamp3'
		);
		~tmSampFader.free;
		~tmSampFader= OSCFunc({
			arg msg;
			~tmSamp.source = msg[1];

			},
			'/timesSamp'
		);



		~padSamp.free;
		~padSamp = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFSamp(~tmSampP.next);

			});
			},
			'/padSamp'
		);

		//----Samp-------
		~octSampMulBut.free;
		~octSampMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSamp = ~octMulSamp+1;
				~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);

			});

			},
			'/octSampMul'
		);

		~octSampZeroBut.free;
		~octSampZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSamp = 0;
				~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);

			});

			},
			'/octSampZero'
		);

		~octSampDivBut.free;
		~octSampDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSamp = ~octMulSamp-1;
				~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);

			});

			},
			'/octSampDiv'
		);

	}

	//Samp Beat Counter
	*count3 {
		1.do{
			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            SampCnt"+counter3).postln;
					this.ctl_2;
					counter3 = 0;

				}

			)
		}

	}


	*ctl_1 {


	}

	*ctl_2 {
		("Samp CTL 2").postln;

	}


}