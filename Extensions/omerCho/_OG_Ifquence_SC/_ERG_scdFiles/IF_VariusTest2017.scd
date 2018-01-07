"Kick Set".postln;
~local.sendMsg('volKick', 0.99);
~local.sendMsg('sendKick', 0.0, 0.0);
~local.sendMsg('attKick', 0.0);
~local.sendMsg('susKick', 0.5);
~local.sendMsg('decKick', 0.7);
~local.sendMsg('chainKick', 0.0);

~extraShufKick.source = 0;

//CH -1- [ Kick ]
IFShuf.harmDrum(0,0,0,0,2,0,0,0,0);
IFShuf.loadKick(1,4,6,0,0,0,0,1,0);
IFSeqKick.stGrpSet    (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
IFSeqOctKick.stGrp (0);
//IFSeqNtKick.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
IFSeqNtKick.stGrp  (~vKick);
IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
IFSeqSusKick.stGrpSet (3,2,3,2, 3,2,3,2,  3,2,3,2, 3,2,3,2);
IFSeqTmKick.stGrp  (1);
IFSeqDurKick.stGrp (4);