IFStatNote{
	classvar  >lstChan=0,>lstNote=0;
	*globals{
		//notes = Array.newClear(128);
	}

	*new{|key,deg,vel,sus|
		key.switch(
			\mopho, {IFMopho.lng(deg,vel,sus);},
			\bass, {IFBass.lng(deg,vel,sus);},
			\keys, {IFKeys.lng(deg,vel,sus);},
			\samp, {IFSamp.lng(deg,vel,sus);},
			\ext, {IFExt.lng(deg,vel,sus);}
		);
	}

	*onOld{|chan,note,vel|
		var deg;
		deg=note+60;
		~mdOut.noteOff(lstChan,lstNote,vel);
		~mdOut.noteOn(chan,deg,vel);
		lstChan=chan;
		lstNote=deg;
		lstNote.postln;
		//this.update;
	}
	*update{
		//^lstChan
		//^lstNote

	}
	*off{|vel=0|

		~mdOut.noteOff(lstChan,lstNote,vel);

	}
}





/*

IFStatNote(
	\keys,
deg:[0,2,7],
	vel:1,
	sus:8
);

~rrt01.stop;
~rrt01={
	~seq01 = Pseq([0,1,2,3,4,5,6,7], inf).asStream;
	~seq02 = Pseq([0,1,2,3,4,5,6,7].reverse, inf).asStream;
	~amp = Pseq([0.65, 0.75, 0.85].mirror2, inf).asStream;
	~dur = 0.27;
	~does = 8;
	inf.do{|i|
		~does;
		IFStat.ln01;
		IFStatNote(
			\bass,
			deg:~seq01.next,
			vel:~amp.next,
			sus:[0.2,0.3,0.5,5,6].choose
		);
		IFStatNote(
			\keys,
			deg:~seq02.next,
			vel:~amp.next,
			sus:[0.2,0.3,0.5,0.1,1.6].choose
		);
		( ~dur - (0.004*(i%~does)) ).wait;
		/*IFStat.ln03;

		IFStatNote(
			\bass,
			deg:~seq01.next,
			vel:~amp.next,
			sus:[0.2,0.3,0.5,1.5,0.6].choose
		);

		( ~dur - (0.004*(i%~does)) ).wait;
		IFStat.ln01;IFStat.ln02;
		( ~dur - (0.004*(i%~does)) ).wait;*/
	};
}.fork;



~rtt01.stop;
~rtt01 = Routine({
	16.do {|i|
		var dg,vl,ss;
		//("Times"+i).postln;
		//i=rrand(0.5,0.9)*i;
		IFStatNote(
			\bass,
			deg:i%8+3,
			vel:1,
			sus:0.02+0.09*(i%11)
			//0.2+8.09-(0.0009*(i%11))
		);
		//dg=1*(i%11).postln;
		//vl=rrand(0.5,1.0).postln;
		//ss=0.09-(0.9*(i%7));
		//ss.postln;
		//(0.2-0.4*i%7).postln;

(1.1-(0.1*(i%5))).wait;
		//(0.2*0.4*i%7).yield;

	};
});
~rtt01.play;



~stat01R=Routine({
	[0,1,2,3,20,24,10,11,12].do{
		arg deg;
		IFStatNote(\mopho,deg,1,0.5);
		deg.postln;
		0.5.wait;
	};
}).play;

IFStatNote(\mopho,12,1,18);
IFStatNote(\bass,1,1,2);





~rtt02 = Routine.new({
	inf.do {|i|

		IFStatNote(\bass,0+(1*(i%11)),0.8+(0.1*(i%18)),1.9-(0.9*(i%8)));
		0.2-(0.04*(i%13)).wait;

	};
});
~rtt02.stop;
~rtt02.play;

~rtt03 = Routine.new({
	inf.do {|i|

		IFStatNote(\keys,rrand(1,2)+(1*(i%8)),0.8+(0.1*(i%17)),0.9-(0.6*(i%11)));
		(0.2 - (0.04*(i%12))).wait;

	};
});
~rtt03.stop;
~rtt03.play;

~rtt04.stop;
~rtt04 = Routine.new({
	inf.do {|i|

		IFStatNote(
			\samp,
			0+(1*(i%14)),
			0.8+(0.8*(i%11)),
			0.9-(0.6*(i%7))
		);
		0.1- (0.04*(i%13)).wait;

	};
});
~rtt04.play;



(0.1 + (0.04*(i%15))).wait;

OF.img(~imageLib.at('el1', rrand(0,8)), [68, 155, 100, 55].choose, 255, 0, 0);


(
var r;
r = Routine.new({
	inf.do({ arg i;

		Synth(\bleep, [ \note, 36+(3*(i%10)) ]);
		0.25.wait;   //do not miss me out!

	});
});

r.play;
)

~mdOut.noteOn(4,60,127);
~mdOut.noteOff(4,60,127);

~mdOut.allNotesOff(4)

(
var r;
r = Routine.new({
	12.do({ arg i;
		IFStatNote(\mopho,0+(3*(i%10)),1,0.2);
		//Synth(\bleep, [ \note, 36+(3*(i%10)) ]); //added %10 to stop it going up forever
		0.25.wait;   //do not miss me out!

	});
});

r.play;
)


///KAFES

fork{
		~seq01 = Pseq([~kRA4, ~kRC1, ~kRB3, ~kRA7, ~kRB5, ~kRB7, ~kRC4, ~kRD4]*4, inf).asStream;
		~amp = Pseq([0.15, 0.25, 0.35].mirror2/2, inf).asStream;
		~dur = 0.27;
		~does = 4;
		~seqCokus = Pseq((0..12).reverse, inf).asStream;
		0.02.wait;
		~does.do{|i|

			~tol07.brt_(~seq01.next *1.07500).playPV5(0.001, 0.9, 1.4, mul:~amp.next, out: 0);
			~ats05.brt_(~seq01 *1.01000).playPV5(3.001, 4.1, 4, mul:0.09, out: ~strCok.choose);
			OF.int("mirrorMode", [5,6].choose);
			OF.img(~imageLib.at('cokus', ~seqCokus.next), 200, 100, 0, 0);
			( ~dur - (0.004*(i%~does)) ).wait;

			//~gou02.brt_(~seq01 *0.89000).playPV5(0.001, 1.1, 3.1, mul:0.09, out: ~strTek.choose);
			~ats06.brt_(~seq01.next *1.01000).playPV5(0.001, 1.1, 4, mul:0.9, out: ~strTek.choose);
			OF.img(~imageLib.at('cokus', ~seqCokus.next), 200, 100, 0, 0);
			( ~dur - (0.004*(i%~does)) ).wait;
		};
		~tol07.brt_(~seq01.next *1.07500).playPV5(0.001, 0.9, 1.4, mul:~amp.next, out: 0);
		OF.img(~imageLib.at('cokus', ~seqCokus.next), 200, 100, 0, 0);
	};


/**onOld{|chan,note,vel|
		MIDIdef.noteOn(key,{ |veloc, num, chan, src|
			    notes[num] = Synth(\default, [\freq, num.midicps,
				        \amp, veloc * 0.00315]);
		},);
	}*/

*/