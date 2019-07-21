IFRoutine{
	classvar <>counter2=0, timeCnt=0;
	var <>kTime=1;


	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({
				this.load;
			});
		}
	}
	*load{
		//this.loadRoutPacks;
		//this.count;
		//this.oscMIDI;
		this.osc;
		this.midi;
	}
	*cntDwn{|min,max,tms=10,speed=0.5|
		~fadee = Pseries(min,max, inf);
		~fadeUp=~fadee.asStream;
		~tmsLab=tms;
		//speed = speed;
		~cnt01R=Routine({
			tms.do{
				~tOSCAdrr.sendMsg('cntDwnRoutLabel', ~tmsLab);
				~local.sendMsg('melFader',~fadeUp.next);
				~local.sendMsg('susMel',~fadeUp.next);
				~local.sendMsg('snrXPose',~fadeUp.next);
				~local.sendMsg('fxFader',~fadeUp.next);
				("IF Count Down"+~tmsLab).postln;
				~tmsLab=~tmsLab-1;
				//~fadeUp.next;
				//speed=speed*(-1.1);
				speed.asFloat.yield;
			};
		}).play;
	}
	*sprd{
		~rtt01.stop;
		~rtt01 = Routine({
			18.do {|i|
				var dg,vl,ss;
				IFStatNote(
					\bass,
					deg:(1+i%6),
					vel:1,
					sus:0.02+0.09*(i%11)
				);
				(0.9-(0.09*(i%9))).postln;
				(0.9-(0.09*(i%9))).wait;
			};
		});
		~rtt01.play;
	}
	*osc{
		~cntDwnRoutBut.free;
		~cntDwnRoutBut= OSCFunc({
			arg msg,val;
			val=msg[1];
			if ( msg[1]==1,{
				IFRoutine.cntDwn(
					min:0.0,max:0.001,
					tms:142,
					speed:0.2
				);
			});
		},'/cntDwnRout');

	}
	*midi{

	}

	//OLDS
	*loadRoutPacks{

		~blackFade={
			~fadeUp = Pseq((0..127), 124).asStream;
			128.do{
				var cnt;
				~mdOut.control(2, 8, ~fadeUp.next); // Kick Chain

				0.08.wait;
			};
		}.fork;

		~mdOut.noteOn(4,60,127);
		~mdOut.noteOff(4,60,127);
		~vKeys.noteOn(0,~cM2,127);~vKeys.noteOn(0,~eM3,127);
		~vKeys.noteOff(0,~cM2,127);~vKeys.noteOff(0,~eM3,127);
		~extRout = Pbind(
			\chan, 6,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([1/4],4), Pseq([1],2), Pseq([1/2],2)], 1),
			\degree, Pslide([~nt+0,~nt+0,~nt+7,~nt+0,~nt+1,~nt+4],  inf, 4,2,0),
			\amp, Pslide([0.9, 0.5, 0.8, 0.7, 0.9, 0.9], inf, 4,1,0),
			\sustain, Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*1.9,inf, 4,1,0)*~susMulBass,
			\mtranspose, Pseq([~transBassP.next], inf)+~trBass,
			\octave, Pseq([~octBassP.next], inf)+~octMulBass,
			\root, Pseq([~legBassP.next], inf),
			\harmonic, Pseq([~strBassP.next], inf)+~harmBass
		).play;
		~extRout.stop;



	}

	*count {
		1.do{var cnt;
			cnt = cnt + 1;
			counter2.switch(
				2, {
					("KickCnt"+counter2).postln;
					this.ctl_2;
					counter2 = 0;

				}

			)
		}

	}

	*oscMIDI{


		~phrsExt01osc.free;
		~phrsExt01osc= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			if ( msg[1]==1, {

				~extRout = Pbind(
					\chan, 6,
					\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
					\dur, Pseq([Pseq([1/4],4), Pseq([1],2), Pseq([1/2],2), Pseq([1/8],8)], 1),
					\degree, Pslide([~nt+0,~nt+0,~nt+7,~nt+0,~nt+1,~nt+4],  inf, 4,2,0),
					\amp, Pslide([0.9, 0.5, 0.8, 0.7, 0.9, 0.9], inf, 4,1,0),
					\sustain, Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*0.9,inf, 4,1,0)*~susMulBass,
					\mtranspose, Pseq([~transBassP.next], inf)+~trBass,
					\octave, Pseq([~octBassP.next], inf)+~octMulBass,
					\root, Pseq([~legBassP.next], inf),
					\harmonic, Pseq([~strBassP.next], inf)+~harmBass
				).play;
				~extRout.stop;

			},{~extRout.stop;});



		},
		'/phraseExt01'
		);

	}

}

/*
~scl2=~ifSclList[16];
~rrt01.stop;
~rrt01= Routine({
	~rtnt=(1);
	~seq01 = Pseq([0,0,0,0,0,0,0,0], inf).asStream;
	~seq02 = Pseq([2,4,6,8], inf).asStream;
	~seq03 = Pseq([0,1,2,3,4,5,6,7].reverse, inf).asStream;
	~amp = Pseq([0.95, 0.85, 0.75, 0.85].mirror, inf).asStream;
	~sus = Pseq([0.1,0.3,0.5,0.4].mirror, inf).asStream;
	~dur = 0.5;
	~does = 7;
	inf.do{|i|
		IFStatNote(
			\keys,
			deg:(~rtnt)+~seq01.next,
			vel:~amp.next,
			sus:~sus.next;
		);
		( ~dur ).wait;
		IFStatNote(
			\keys,
			deg:(~rtnt)+~seq02.next,
			vel:~amp.next,
			sus:~sus.next;
		);
		( ~dur  ).wait;

	};
}).play(quant:0);



~rrt01.stop;
~rrt01={
	~rtnt=(0);
	~seq01 = Pseq([0,1,2,3,4,5,6,7], inf).asStream;
	~seq02 = Pseq([0,1,2,3,4,5,6,7].reverse, inf).asStream;
	~amp = Pseq([0.05, 0.065, 0.075, 0.085].mirror, inf).asStream;
	~sus = Pseq([1.2,0.3,0.5,0.2,0.1].mirror, inf).asStream;
	~dur = 0.5;
	~does = 7;
	inf.do{|i|
		~does;
		IFHat(~tmMulHatP.next*~tmHatP.next);
		IFStatNote(
			\bass,
			deg:(~rtnt)+~seq01.next,
			vel:~amp.next,
			sus:~sus.next;
		);
		IFStatNote(
			\keys,
			deg:(~rtnt)+~seq02.next,
			vel:~amp.next,
			sus:~sus.next;
		);
		( ~dur - (0.004*(i%~does)) ).wait;
		IFStatNote(
			\bass,
			deg:(~rtnt)+~seq01.next,
			vel:~amp.next,
			sus:~sus.next;
		);
		IFStatNote(
			\keys,
			deg:(~rtnt)+~seq02.next,
			vel:~amp.next,
			sus:[0.2,0.3,0.5,0.1,1.6].choose
		);

		( ~dur - (0.004*(i%~does)) ).wait;

		IFStatNote(
			\bass,
			deg:(~rtnt)+~seq01.next,
			vel:~amp.next,
			sus:[0.2,0.3,0.5,0.2,0.6].choose
		);

		( ~dur - (0.004*(i%~does)) ).wait;
		IFStatNote(
			\bass,
			deg:(~rtnt)+~seq01.next,
			vel:~amp.next,
			sus:[0.2,0.3,0.5,0.1,0.6].choose
		);
		IFStatNote(
			\keys,
			deg:(~rtnt)+~seq02.next,
			vel:~amp.next,
			sus:[0.2,0.3,0.5,0.1,0.6].choose
		);
		( ~dur - (0.004*(i%~does)) ).wait;
	};
}.fork;




*/