(
~scl2=~ifSclList[16];

~rootLngKeys.source = (4);
~rrt01.stop;
~rrt01= Routine({
	~rtnt=(0);
	~seq01 = Pseq([0,0,0,0,0,0,0,0], inf).asStream;
	~seq02 = Pseq([2,4], inf).asStream;
	~seq03 = Pseq([7,6,5,6], inf).asStream;
	~transLngKeys.source = ~seq03.next;


	~amp = Pseq([0.95, 0.85, 0.75, 0.85].mirror2, inf).asStream;
	~sus = Pseq([0.6,0.5,0.6,0.4], inf).asStream;
	~dur1 = 0.5;
	~dur2 = ~dur1*(1/1);
	~does = 7;
	~ccnt=0;

	inf.do{|i,cnt=0|
		~ccnt=~ccnt+1;
		IFStatNote(
			\keys,
			deg:(~rtnt)+~seq01.next,
			vel:~amp.next,
			sus:~sus.next;
		);
		~ccnt.postln;
		~ccnt.switch(
			8,{~transLngKeys.source=(~seq03.next);~ccnt=0;}
		);

		( ~dur1 ).wait;

		IFStatNote(
			\keys,
			deg:(~rtnt)+~seq02.next,
			vel:0.9*~amp.next,
			sus:~sus.next;
		);

		( ~dur2  ).wait;

	};
}).play(quant:0);
)
(
~scl2=~ifSclList[16];
~transLngKeys.source = (-0);
~rootLngKeys.source = (4);
~rrt01.stop;
~rrt01= Routine({
	~rtnt=(0);
	~seq01 = Pseq([0,0,0,0,0,0,0,0], inf).asStream;
	~seq02 = Pseq([3,6], inf).asStream;
	~seq03 = Pseq((0..9), inf).asStream;
	~amp = Pseq([0.95, 0.85, 0.75, 0.85].mirror2, inf).asStream;
	~sus = Pseq([0.6,0.5,0.6,0.4], inf).asStream;
	~dur1 = 0.5;
	~dur2 = ~dur1*(1/1);
	~does = 7;
	inf.do{|i,cnt=0|
		cnt=cnt+1;
		IFStatNote(
			\keys,
			deg:(~rtnt)+~seq03.next,
			vel:~amp.next,
			sus:~sus.next;
		);
		( ~dur1 ).wait;
	};
}).play(quant:0);
)
(
~scl2= Scale.minor;
~rootKeys.source = (4);
~transKeys.source = (0);
IFSeqKeys.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
IFSeqNtKeys.stGrpSet  (0,2,0,4, 0,2,0,4,  0,2,0,4, 0,2,0,4);
IFSeqVelKeys.stGrpSet (3,2,3,2, 3,2,3,3,  3,1,3,2, 3,2,3,0);
IFSeqSusKeys.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,2);
IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
)