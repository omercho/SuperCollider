/*
IFExt.load;
*/
IFExt{
	classvar <>counter2=0, timeCnt=0;
	var <>kTime=1;


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
			this.routines; this.oscMIDI;
			});*/
		}

	}

	*load{
		this.globals;
		this.loadPProxy;
		this.oscMIDI;

	}

	*globals{

		~chExt=6;
		~extLate=0.0;
		~timesExt=1;
		~octMulExt=0;
		~hrmMulExt=0;
		~rootExt=0;
		~susMulExt=1;
		~trExt=0;
		~lfoMulExt1=0;
		~lfoMulExt2=0;



	}

	*preSet{}

	*loadPProxy {

		~nt1Ext = PatternProxy( Pseq([0], inf));
		~nt1ExtP = Pseq([~nt1Ext], inf).asStream;
		~dur1Ext = PatternProxy( Pseq([1], inf));
		~dur1ExtP = Pseq([~dur1Ext], inf).asStream;
		~amp1Ext = PatternProxy( Pseq([0.9], inf));
		~amp1ExtP = Pseq([~amp1Ext], inf).asStream;
		~sus1Ext = PatternProxy( Pseq([1], inf));
		~sus1ExtP = Pseq([~sus1Ext], inf).asStream;

		~tmMulExt = PatternProxy( Pseq([1], inf));
		~tmMulExtP= Pseq([~tmMulExt], inf).asStream;
		~tmExt = PatternProxy( Pseq([1], inf));
		~tmExtP= Pseq([~tmExt], inf).asStream;


		~transExt = PatternProxy( Pseq([0], inf));
		~transExtP = Pseq([~transExt], inf).asStream;
		~octExt = PatternProxy( Pseq([4], inf));
		~octExtP = Pseq([~octExt], inf).asStream;
		~rootExt = PatternProxy( Pseq([0.0], inf));
		~rootExtP = Pseq([~rootExt], inf).asStream;
		~hrmExt = PatternProxy( Pseq([1.0], inf));
		~hrmExtP = Pseq([~hrmExt], inf).asStream;

		~delta1Ext = PatternProxy( Pseq([0.5], inf));
		~delta1ExtP = Pseq([~delta1Ext], inf).asStream;
		~delta2Ext = PatternProxy( Pseq([0.5], inf));
		~delta2ExtP = Pseq([~delta2Ext], inf).asStream;

		~lfo1Ext = PatternProxy( Pseq([40], inf));
		~lfo1ExtP = Pseq([~lfo1Ext], inf).asStream;
		~lfo2Ext = PatternProxy( Pseq([40], inf));
		~lfo2ExtP = Pseq([~lfo2Ext], inf).asStream;


	}


	*oscMIDI{


		~volExtFader.free;
		~volExtFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volExt', msg[1]);
			~mdOut.control(8, 22, vel);
			},
			'/volExt'
		);

		~susExtMulFader.free;
		~susExtMulFader= OSCFunc({
			arg msg;

			~susMulExt=msg[1];
			~tOSCAdrr.sendMsg('susExt', msg[1]);

			},
			'/susExt'
		);
		~rlsExtFader.free;
		~rlsExtFader= OSCFunc({
			arg msg;

			~mdOut.control(8, 2, msg[1]*127);
			~tOSCAdrr.sendMsg('rlsExt', msg[1]);

			},
			'/rlsExt'
		);

		~xySendsExt.free;
		~xySendsExt= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1];
			vel2=msg[2];

			~tOSCAdrr.sendMsg('/extSends',msg[1], msg[2]);
			~mdOut.control(8, 4, msg[1]*127);
			~mdOut.control(8, 3, msg[2]*127);
			~mdOut.control(8, 5, msg[2]*127);

			},
			'/extSends'
		);

		//-------Phrases

		~phrsExt01osc.free;
		~phrsExt01osc= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			if ( msg[1]==1, {

				~extRout1 = Pbind(
					\chan, 6,
					\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
					\dur, Pshuf([
						Pseq([1/1],2),
						Pseq([1/2],2),
						Pseq([1/4],2),
						Pseq([2/1],1),
						Pseq([1/2],2),
						Pseq([1/1],1),
					], inf),
					\degree, Pslide([~nt+0,~nt+0,~nt+3,~nt+0,~nt+2,~nt+0],  inf, 4,2,0),
					\amp, Pslide([0.9, 0.5, 0.6, 0.7, 0.4, 0.9], inf, 4,1,0),
					\sustain, Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*0.9,inf, 4,1,0)*~susMulExt,
					\mtranspose, Pseq([~transExtP.next], inf)+~trExt,
					\octave, Pseq([~octExtP.next], inf)+~octMulExt
				).play;


				},{~extRout1.stop;}
			);
			},
			'/phraseExt01'
		);

		~phrsExt02osc.free;
		~phrsExt02osc= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			if ( msg[1]==1, {

				~extRout2 = Pbind(
					\chan, 6,
					\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
					\dur, Pshuf([
						Pseq([1/4],2),
						Pseq([1/2],2),
						Pseq([1/2],2),
						Pseq([1/1],2),
						Pseq([1],1)
					], inf),
					\degree, Pslide([~nt+13,~nt+0,~nt+8,~nt+0,~nt+12,~nt+3],  inf, 3,2,0),
					\amp, Pslide([0.9, 0.5, 0.6, 0.7, 0.4, 0.9], inf, 3,1,0),
					\sustain, Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*0.9,inf, 3,1,0)*~susMulExt,
					\mtranspose, Pseq([~transExtP.next], inf)+~trExt,
					\octave, Pseq([~octExtP.next], inf)+~octMulExt
				).play;


				},{~extRout2.stop;}
			);
			},
			'/phraseExt02'
		);

		~phrsExt03osc.free;
		~phrsExt03osc= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			if ( msg[1]==1, {

				~extRout3 = Pbind(
					\chan, 6,
					\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
					\dur, Pshuf([
						Pseq([1/1],1),
						Pseq([1/2],1),
						Pseq([1/2],2),
						Pseq([1/2],2),
						Pseq([1/4],2),
						Pseq([2/1],1)
					], inf),
					\degree, Pslide([~nt+10,~nt+0,~nt+8,~nt+0,~nt+12,~nt+3],  inf, 3,2,0),
					\amp, Pslide([0.9, 0.5, 0.6, 0.7, 0.4, 0.9], inf, 3,1,0),
					\sustain, Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*0.9,inf, 3,1,0)*~susMulExt,
					\mtranspose, Pseq([~transExtP.next], inf)+~trExt,
					\octave, Pseq([~octExtP.next], inf)+~octMulExt
				).play;


				},{~extRout3.stop;}
			);
			},
			'/phraseExt03'
		);

		//4
		~phrsExt04osc.free;
		~phrsExt04osc= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			if ( msg[1]==1, {

				~extRout4 = Pbind(
					\chan, 6,
					\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
					\dur, Pshuf([
						Pseq([1/4],4),
						Pseq([1/1],2),
						Pseq([1/2],2),
						Pseq([1/4],2),
						Pseq([2/1],1),
						Pseq([1/4],2),
						Pseq([1/1],1),
					], inf),
					\degree, Pslide([~nt+0,~nt+0,~nt+7,~nt+0,~nt+1,~nt+4],  inf, 4,2,0),
					\amp, Pslide([0.9, 0.5, 0.6, 0.7, 0.4, 0.9], inf, 4,1,0),
					\sustain, Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*0.9,inf, 4,1,0)*~susMulExt,
					\mtranspose, Pseq([~transExtP.next], inf)+~trExt,
					\octave, Pseq([~octExtP.next], inf)+~octMulExt
				).play;


				},{~extRout4.stop;}
			);
			},
			'/phraseExt04'
		);

		~phrsExt05osc.free;
		~phrsExt05osc= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			if ( msg[1]==1, {

				~extRout5 = Pbind(
					\chan, 6,
					\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
					\dur, Pshuf([
						Pseq([1/4],4),
						Pseq([1/2],2),
						Pseq([1/2],2),
						Pseq([1/8],8),
						Pseq([1],1)
					], inf),
					\degree, Pslide([~nt+11,~nt+0,~nt+8,~nt+0,~nt+12,~nt+3],  inf, 3,2,0),
					\amp, Pslide([0.9, 0.5, 0.6, 0.7, 0.4, 0.9], inf, 3,1,0),
					\sustain, Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*0.9,inf, 3,1,0)*~susMulExt,
					\mtranspose, Pseq([~transExtP.next], inf)+~trExt,
					\octave, Pseq([~octExtP.next], inf)+~octMulExt
				).play;


				},{~extRout5.stop;}
			);
			},
			'/phraseExt05'
		);

		~phrsExt06osc.free;
		~phrsExt06osc= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			if ( msg[1]==1, {

				~extRout6 = Pbind(
					\chan, 6,
					\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
					\dur, Pshuf([
						Pseq([1/1],1),
						Pseq([1/2],1),
						Pseq([1/4],4),
						Pseq([1/2],2),
						Pseq([1/2],2),
						Pseq([1/4],2),
						Pseq([1/1],1)
					], inf),
					\degree, Pslide([~nt+9,~nt+0,~nt+8,~nt+0,~nt+10,~nt+3],  inf, 3,2,0),
					\amp, Pslide([0.9, 0.5, 0.6, 0.7, 0.4, 0.9], inf, 3,1,0),
					\sustain, Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*0.9,inf, 3,1,0)*~susMulExt,
					\mtranspose, Pseq([~transExtP.next], inf)+~trExt,
					\octave, Pseq([~octExtP.next], inf)+~octMulExt
				).play;


				},{~extRout6.stop;}
			);
			},
			'/phraseExt06'
		);


	}

	*count {
		1.do{var cnt;
			cnt = cnt + 1;
			counter2.switch(
				2, {
					("            ExtCnt"+counter2).postln;
					this.ctl_2;
					counter2 = 0;

				}

			)
		}

	}

}

/*
~mdOut.allNotesOff(0);
		~mdOut.allNotesOff(1);
		~mdOut.allNotesOff(2);
		~mdOut.allNotesOff(3);
		~mdOut.allNotesOff(4);
		~mdOut.allNotesOff(5);
		~mdOut.allNotesOff(6);
		~mdOut.allNotesOff(7);
		~mdOut.allNotesOff(8);
		~mdOut.allNotesOff(9);
		~mdOut.allNotesOff(10);
        ~mdOut.allNotesOff(11);
		~mdOut.allNotesOff(12);
		~mdOut.allNotesOff(13);
		~mdOut.allNotesOff(14);
		~mdOut.allNotesOff(15);
		~mdOut.allNotesOff(16);
		~vKeys.allNotesOff(11);
		~vKeys.allNotesOff(12);
		~vKeys.allNotesOff(13);
		~vKeys.allNotesOff(14);
		~vKeys.allNotesOff(15);
		~vKeys.allNotesOff(16);

*/