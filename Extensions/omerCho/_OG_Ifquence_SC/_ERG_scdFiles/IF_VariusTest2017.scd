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
(
~ttm=inf;
//CH -2- [ HAT ]
IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,0);
IFSeqNtHat.stGrpSet  (10,1,0,4, 0,2,0,0,  2,0,1,0, 4,1,1,0);
IFSeqVelHat.stGrpSet (3,1,3,1, 3,1,1,2,  3,2,3,2, 3,2,3,0);
IFSeqSusHat.stGrp  (1);
IFSeqTmHat.stGrp  (1);
IFSeqDurHat.stGrp  (4);

Pbind(//LFO Amp
	\type, \midi, \midicmd, \control,
	\midiout,~vSamp, \chan, ~smp07, \ctlNum, ~smpLvl,
	\delta, Pseq([~delta1VSamp07P.next], ~ttm),
	\control, Pseq([~volHatP.next*~amp1HatP], ~ttm),
).play(quant:0);
Pbind(//LFO 1
	\type, \midi, \midicmd, \control,
	\midiout,~vSamp, \chan, ~smp07, \ctlNum, ~smpSpeed,
	\delta, Pseq([~delta2VSamp07P.next], ~ttm),
	\control, PdegreeToKey(
		Pseq([26+~nt1HatP.next], inf),
		Pfunc({~scl2}),
		12),
).play(quant:0);
Pbind(
	\chan, ~smp07,
	\type, \midi, \midiout,~vSamp,
	\dur, Pseq([~dur1HatP.next],~ttm),
	\amp, Pseq([~amp1HatP.next], inf),
	\sustain, Pseq([~sus1HatP.next],inf)*~susMulHat,
).play(quant:0);
)

(
//CH -1- [ Snare ]
IFSeqSnr.stGrp  (1);
IFSeqNtSnr.stGrpSet  (0,1,0,4, 0,2,0,0,  2,0,1,0, 4,1,1,0);
IFSeqVelSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
IFSeqSusSnr.stGrp (3);
IFSeqTmSnr.stGrp  (1);
IFSeqDurSnr.stGrp  (5);

//CH -2- [ HAT ]
IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
IFSeqNtHat.stGrpSet  (0,1,2,3, 4,5,6,7,  8,9,10,11, 12,13,14,15);
IFSeqVelHat.stGrp  (3);
IFSeqSusHat.stGrp  (1);
IFSeqTmHat.stGrp  (1);
IFSeqDurHat.stGrp  (4);

IFSeqBass.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
IFSeqOctBass.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
IFSeqNtBass.stGrpSet  (0,1,2,3, 4,5,6,7,  8,9,10,11, 12,13,14,15);
IFSeqVelBass.stGrp  (3);
)