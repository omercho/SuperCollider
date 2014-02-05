//A practical buffer player 
//Omer Chatziserif 
//Thu, 17 May 2012, 03:53
//Corfu

/*
Server.default.queryAllNodes;

~big02Test = KafferTest.read(Server.default, "sounds/_kafes/bigs/02.aif"); 

~big02Test.brt_(0.85).playGverb(1.1, 12.1, 19.1, mul:0.9, room:20.0, rev:3.5, damp:0.98, start:0.1, loop:1, out:0);

~gVerb.set(\rev, 0.5);
~gVerb.set(\rev, 10.5);
~gVerb.set(\room, 13.5);
~gVerb.set(\rev, 3.5);
~gVerb.set(\damp, 1.0);
~gVerb.set(\damp, 0.9);

(
~froom.stop;
~froom = {
	~durfMul = 0.7;
	~ampfMul = 0.2;
	~durf = Pseq([1, 1/2,1/2, 1, 2, 1, 1/2, 2]*~durfMul, inf).asStream;
	
	~ampf = Pseq((0.2..0.4)*~ampfMul, inf).asStream;
	~ampf1 = 0.5*~ampfMul;
	inf.do {
		"_______________________frit__01______________________".postln;
		~gVerb.set(\room, 10.1);
		
		~durf.next.wait;	
		"_______________________frit__02______________________".postln;
		~gVerb.set(\room, 1.5);
		
		~durf.next.wait;
		"_______________________frit__03______________________".postln;
		~gVerb.set(\room, 0.5);
		
		~durf.next.wait;
		"_______________________frit__04______________________".postln;
		~gVerb.set(\room, 52.5);
		
		~durf.next.wait;
		"_______________________frit__05______________________".postln;
		~gVerb.set(\room, 20.5);
		
		~durf.next.wait;
		"_______________________frit__06______________________".postln;
		~gVerb.set(\room, 114.5);
		
		~durf.next.wait;
		"_______________________frit__07______________________".postln;
		~gVerb.set(\room, 8.2);
		
		~durf.next.wait;
		"_______________________frit__08______________________".postln;
		~gVerb.set(\room, 0.9);
		
		~durf.next.wait;

	};
}.fork;
)

(
~frev.stop;
~frev = {
	~durfMul = 0.7;
	~ampfMul = 0.2;
	~durf = Pseq([1, 1/2,1/2, 1, 2, 1, 1/2, 2]*~durfMul, inf).asStream;
	
	~ampf = Pseq((0.2..0.4)*~ampfMul, inf).asStream;
	~ampf1 = 0.5*~ampfMul;
	inf.do {
		"_______________________frit__01______________________".postln;
		~gVerb.set(\rev, 10.1);
		
		~durf.next.wait;	
		"_______________________frit__02______________________".postln;
		~gVerb.set(\rev, 1.5);
		
		~durf.next.wait;
		"_______________________frit__03______________________".postln;
		~gVerb.set(\rev, 0.5);
		
		~durf.next.wait;
		"_______________________frit__04______________________".postln;
		~gVerb.set(\rev, 2.5);
		
		~durf.next.wait;
		"_______________________frit__05______________________".postln;
		~gVerb.set(\rev, 20.5);
		
		~durf.next.wait;
		"_______________________frit__06______________________".postln;
		~gVerb.set(\rev, 114.5);
		
		~durf.next.wait;
		"_______________________frit__07______________________".postln;
		~gVerb.set(\rev, 8.2);
		
		~durf.next.wait;
		"_______________________frit__08______________________".postln;
		~gVerb.set(\rev, 0.9);
		
		~durf.next.wait;

	};
}.fork;
)


(
~frate.stop;
~frate = {
	~durfMul = 0.8;
	~ampfMul = 0.2;
	~durf = Pseq([1, 1/2,1/2, 1, 2, 1, 1/2, 2]*~durfMul, inf).asStream;
	
	~ampf = Pseq((0.2..0.4)*~ampfMul, inf).asStream;
	~ampf1 = 0.5*~ampfMul;
	inf.do {
		"_______________________frit__01______________________".postln;
		~gVerb.set(\rate, 0.1);
		
		~durf.next.wait;	
		"_______________________frit__02______________________".postln;
		~gVerb.set(\rate, 1.5);
		
		~durf.next.wait;
		"_______________________frit__03______________________".postln;
		~gVerb.set(\rate, 0.5);
		
		~durf.next.wait;
		"_______________________frit__04______________________".postln;
		~gVerb.set(\rate, 2.5);
		
		~durf.next.wait;
		"_______________________frit__05______________________".postln;
		~gVerb.set(\rate, 0.5);
		
		~durf.next.wait;
		"_______________________frit__06______________________".postln;
		~gVerb.set(\rate, 10.5);
		
		~durf.next.wait;
		"_______________________frit__07______________________".postln;
		~gVerb.set(\rate, 0.2);
		
		~durf.next.wait;
		"_______________________frit__08______________________".postln;
		~gVerb.set(\rate, 0.9);
		
		~durf.next.wait;

	};
}.fork;
)

*/

KafferTest : Buffer {
	
	var <>bout = 0, <>batt = 0.1, <>bsus = 2.0, <>brls = 2.5, <>bmul = 1.0, <>bloop = 0;
	var <>btrig = 0, <>bstart = 0, <>bend = 1, <>breset = 0, <>bpan = 0;
	var <>brt = 1.0, <>brt1 = 1.0, <>brt2 = 1.0, <>brt3 = 1.0, <>brt1Dur = 1.0, <>brt2Dur = 0.5, <>btrDur = 0.2, <>bvib = 1;
	var <>broom = 125, <>brev = 1, <>bdamp = 0.5;
	var <>bfroom = 0.5, <>bfmix = 0.5, <>bfdamp = 0.5;
	var <>bpv1a = 0.1, <>bpv1b = 0.1;
	var <>bpv2a = 0.1, <>bpv2b = 0.5;
	var <>bpv3a = 0.1, <>bpv3b = 0.1;
	var <>bpv4a = 0.1, <>bpv4b = 0.1;
	var <>bpv5a = 0.00001, <>bpv5b = 0.001; 
	
	*initClass {
		StartUp add: {
			
			this.panAzChannels;

		}
	}

	*panAzChannels {
		
		
		
			~pCh = 2;
		

		
	}


	//with PlayBuf Gverb
	playGverb { arg  att, sus, rls, mul, trig, rate, start, loop, room, rev, damp, pan, out;

		batt = att ? batt;
		bsus = sus ? bsus;
		brls = rls ? brls;
		bmul = mul ? bmul;
		btrig = trig ? btrig;
		brt = rate ? brt;
		bstart = start ? bstart;
		broom = room ? broom;
		brev = rev ? brev;
		bdamp = damp ? bdamp;
		bpan = pan ? bpan;
		bout = out ? bout;
		bloop = loop ? bloop;
		
		^~gVerb = SynthDef("playGverb", { arg  att, sus, rls, mul, trig, rate, start, loop, room, rev, damp, pan, out;
			var player, panlayer, env;
			
			env =  EnvGen.ar(
				Env.new([0, 1, 0.8,  0], [att, sus, rls], -4, loop, releaseNode: nil), 
				1, 
				doneAction: 2
			);
			player = PlayBuf.ar(
						numChannels,
						bufnum, 
						BufrevScale.kr(bufnum) * rate,
						btrig,
						BufFrames.kr(bufnum) * start,
						loop: loop
					);
			player = GVerb.ar(
				player,
				room, 
				rev, 
				damp, 
				0.45, 
				15, 
				-3.dbamp,
				-11.dbamp, 
				-9.dbamp,
				room, mul);
			player = PanAz.ar(~pCh,
				player, 
				SinOsc.kr(SinOsc.kr(0.01).range(0.05, 0.09)).range(-0.5, 0.5),
				0.8,
				1.8
			);
			Out.ar(bout, player.sum/2 *env);
		}).play(Server.default, [
							\att , batt,
							\sus , bsus,
							\rls , brls,
							\mul , bmul,
							\trig , btrig,
							\rev , brt,
							\start , bstart,
							\room , broom,
							\rev , brev,
							\damp , bdamp,
							\pan , bpan,
							\out , bout,
							\loop , bloop
							
							]);
	}





}

