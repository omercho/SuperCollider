

(
SedefBuffers.load;
SedefSynthDefs.load;
)

(
SedefGroups.load;
SedefBusses.load;
SedefSynths.load;
SedefOsc.load;
)

(
SynthDef(\playBuf1, { | out=0, vol = 0.5, bufnum = 0, gate = 1.5, rate = 1, startPos = 0, amp = 1.0, 
	att = 0.1, dec = 0.5, sus = 1, rls = 0.5, lvl=0.8,
	pan = 0, loop = 0|
	var audio, env;
	env = EnvGen.ar(Env.perc(att, rls, lvl), 1.5, timeScale: sus, doneAction: 2);
	//env = EnvGen.ar(Env.adsr(att, dec, sus, rls, lvl, -1), gate, doneAction: 2);
	//env = EnvGen.ar(Env.linen(att, sus, rls, lvl), gate, doneAction: 2);
	
	rate = rate * BufRateScale.kr(bufnum);
	startPos = startPos * BufFrames.kr(bufnum);
	
	audio = BufRd.ar(1, bufnum, Phasor.ar(1, rate, startPos, BufFrames.ir(bufnum)), 0, 4);
	audio = env * audio;
	audio = Pan2.ar(audio, pan, amp*4*vol);
	Out.ar(out, audio);
}).add;

)

(
/*
(
Pdef(\buf1, Pbind(
			
			\instrument,	\playBuf1,
			\vol,		~volA ,
			\amp,		Pseq([~turkAksagiAmp], inf).sin*1 * p { inf.do { ([0.4, 1].choose + [0.1, 0.5].choose + [0.3, 1.0].choose).postln.yield } },
			\dur,		Prand([0.05,0.1,0.01, 0.03, 0.1], inf).sin**2*2,
			\startPos,	~positionA,
			\rate,		PdegreeToKey(
							Prand([1, 2, 3, 2, 5, 4, 3, 4, 2, 1], inf),
							#[0, 2, 3, 6, 7, 9],
							53
						).abs/8*~rateA,
			\att,		0.1*~randA,
			\dec,		0.5,
			\sus,		Pseq([ (4..1),2 ], inf),
			\rls,		Pseq([ (0.1..2.5),inf ], inf).tanh,
			\lvl,		0.9,
			\pan,  		Pseq([ (-3..3),inf ], inf).tanh,
			\bufnum,		 Pseq([~bufA], inf),
			\group, 		~piges,
			\out,		[~limBus, ~revBus, ~dlyBus]
	
		));
)
*/
~toggleA= OSCresponderNode(nil, '/bufP/togA', { |t,r,m| 
	if (~pat1.isNil or: { ~pat1.isPlaying.not}) {
		~pat1 = Pdef(\buf1, Pbind(
			
			\instrument,	\playBuf1,
			\vol,		~volA ,
			\amp,		Pseq([~turkAksagiAmp], inf),
			\dur,		Prand([0.5,0.1,0.01], inf).sin**1.1*4,
			\startPos,	~positionA,
			\rate,		Pwhite(0.1, 4).abs/8*~rateA,
			\att,		0.001,
			\dec,		0.5,
			\sus,		Pseq([ (4..1),2 ], inf),
			\rls,		2.5,
			\lvl,		0.9,
			\pan,  		Pseq([ (-3..3),inf ], inf).tanh,
			\bufnum,		 Pseq([~bufA], inf),
			\group, 		~piges,
			\out,		[~limBus, ~revBus, ~dlyBus]
	
		)).play( quant: [4, 0, 0]);
	}{
		~pat1.stop;
		~pat1 = nil;
	}
}).add;






~volA = PatternProxy ( Pn(1.0, inf) );

~durationA = PatternProxy ( Pn(1.0, inf) );
~durationASpec = ControlSpec(1.0, 3, \lin);


~positionA = PatternProxy ( Pn(0, inf) );
~positionASpec = ControlSpec(0, 1, \lin);

~rateA = PatternProxy ( Pn(0.5, inf) );
~rateASpec = ControlSpec(0.1, 8, \lin);

~randA = PatternProxy ( Pn(0.5, inf) );
~randASpec = ControlSpec(0.001, 2, \lin);
/*
~attA = PatternProxy ( Pn(0.1, inf) );
~attASpec = ControlSpec(0.05, 2, \lin);

~decA = PatternProxy ( Pn(0.5, inf) );
~decASpec = ControlSpec(0.3, 1.5, \lin);

~susA = PatternProxy ( Pn(1, inf) );
~susASpec = ControlSpec(0.5, 2, \lin);


~rlsA = PatternProxy ( Pn(1, inf) );
~rlsASpec = ControlSpec(0.4, 2, \lin);

~lvlA = PatternProxy ( Pn(0.8, inf) );
~lvlASpec = ControlSpec(0, 1, \lin);
*/



~vol1 = OSCresponderNode(nil, '/bufP/volA', { |t,r,m| 
	~volA.source = (m[1]);	 
}).add;

~dur1 = OSCresponderNode(nil, '/bufP/durA', { |t,r,m| 
	
	~durationA.source = (m[1]);	 
	
	}).add;

~xy1 = OSCresponderNode(nil, '/bufP/xyA', { |t,r,m| 
	var n1, n2;
	n1 = (m[1]);
	n2 = (m[2]);
	
	~rateA.source = ~rateASpec.map(n1);
	~positionA.source = ~positionASpec.map(n2);
	 
	}).add;

~randomA = OSCresponderNode(nil, '/bufP/randA', { |t,r,m| 
	var n1;
	n1 = (m[1]);
	~randA.source = ~randASpec.map(n1);
	}).add;
/*
~envAatt = OSCresponderNode(nil, '/bufP/envA/1', { |t,r,m| 
	var n1;
	n1 = (m[1]);
	~attA.source = ~attASpec.map(n1);
	}).add;

~envAdec = OSCresponderNode(nil, '/bufP/envA/2', { |t,r,m| 
	var n1;
	n1 = (m[1]);
	~decA.source = ~decASpec.map(n1);
	}).add;

~envAsus = OSCresponderNode(nil, '/bufP/envA/3', { |t,r,m| 
	var n1;
	n1 = (m[1]);
	~susA.source = ~susASpec.map(n1);
	}).add;

~envArls = OSCresponderNode(nil, '/bufP/envA/4', { |t,r,m| 
	var n1;
	n1 = (m[1]);
	~rlsA.source = ~rlsASpec.map(n1);
	}).add;

~envAlvl = OSCresponderNode(nil, '/bufP/envA/5', { |t,r,m| 
	var n1;
	n1 = (m[1]);
	~lvlA.source = ~lvlASpec.map(n1);
	}).add;

*/


~pushA1 = OSCresponderNode(nil, '/bufP/push1A', { |t,r,m| 
	[
	~pat1 = Pdef(\buf1, Pbind(
			
			\instrument,	\playBuf1,
			\vol,		~volA ,
			\amp,		Pseq([~turkAksagiAmp], inf),
			\dur,		Pseq([ 0.7, 0.3, 0.5, 0.6, 1], inf)*~durationA,
			\startPos,	~positionA,
			\rate,		~rateA,
			\att,		~attA,
			\dec,		~decA,
			\sus,		~susA,
			\rls,		~rlsA,
			\lvl,		~lvlA,
			\pan,  		Pseq([ 0], inf),
			\bufnum,		 Pseq([~bufA], inf)
	
		));
	]
	}).add;


~pushA2 = OSCresponderNode(nil, '/bufP/push2A', { |t,r,m| 
	[
	~pat1 = Pdef(\buf1, Pbind(
		
		\instrument,	\playBuf1,
		\amp,		Pseq([~turkAksagiAmp]*2, inf),
		\dur,		Pseq([~turkAksagiDur]/2.sin/6, inf),
		\legato,		Pseq([ 10, 1, 0, 0, 1], inf)*8.abs.cos,
		\startPos,	~positionA.sin*2,
		\rate,		~rateA.sin,
		\sustain,		Pseq([ 1.0, 0.5, 1.sin,2 ], inf),
		\pan,  		Prand([ 0, -0.9, -0.4, 0.2, 0.9], inf),
		\bufnum,		 Pseq([~bufA], inf)
	
	));
	]
	}).add;

~pushA3 = OSCresponderNode(nil, '/bufP/push3A', { |t,r,m| 
	[
	~pat1 = Pdef(\buf1, Pbind(
		
		\instrument,	\playBuf1,
		\amp,		Pseq([~turkAksagiAmp]*2, inf),
		\dur,		Pseq([~turkAksagiDur]/2.sin/8, inf),
		\legato,		Pseq([ 10, 1, 0, 0, 1], inf)*8.abs,
		\startPos,	~positionA.sin,
		\rate,		~rateA.sin,
		\sustain,		Pseq([ 1.0, 0.5, 1 ], inf),
		\pan,  		Prand([ 0, -0.9, -0.4, 0.2, 0.9], inf),
		\bufnum,		 Pseq([~bufA], inf)
	
	));
	]
	}).add;


~pushA4 = OSCresponderNode(nil, '/bufP/push4A', { |t,r,m| 
	[
	~pat1 = Pdef(\buf1, Pbind(
		
		\instrument,	\playBuf1,
		\amp,		Pseq([~turkAksagiAmp]*2, inf),
		\dur,		Pseq([~turkAksagiDur]/2.sin/6, inf),
		\legato,		Pseq([ 10, 1, 0, 0, 1], inf)*8.abs.cos,
		\startPos,	~positionA.sin*2,
		\rate,		~rateA.sin,
		\sustain,		Pseq([ 1.0, 0.5, 1.sin,2 ], inf),
		\pan,  		Prand([ 0, -0.9, -0.4, 0.2, 0.9], inf),
		\bufnum,		 Pseq([~bufA], inf)
	
	));
	]
	}).add;




)