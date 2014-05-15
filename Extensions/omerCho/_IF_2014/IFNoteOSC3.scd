/////////////////////----- Note -------//////////////

//~transKick.source = PatternProxy( Pseq([0], inf));
//~transKick.sourceP= Pseq([~transKick.source], inf).asStream;

~harmXY.free;
~harmXY= OSCFunc({
	arg msg;

	~harmKick=msg[1];~harmSnr=msg[2];~harmHat=msg[1];
	~harmBass=msg[2];~harmKeys=msg[1];~harmSamp=msg[2];

	//~tOSCAdrr.sendMsg('noteLabel', msg[1]);
	},
	'/harmXY/1'
);

~harm_0.free;
~harm_0 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Harmonic 0".postln;
		~harmKick=0;~harmSnr=0;~harmHat=0;
		~harmBass=0;~harmKeys=0;~harmSamp=0;
		//~tOSCAdrr.sendMsg('noteLabel', '0');
	});
	},
	'/harm0'
);


~noteFader.free;
~noteFader= OSCFunc({
	arg msg;

	~transKick.source=msg[1];~transSnr.source=msg[1];~transHat.source=msg[1];
	~transBass.source=msg[1];~transKeys.source=msg[1];~transSamp.source=msg[1];

	~tOSCAdrr.sendMsg('noteLabel', msg[1]);
	},
	'/noteFader'
);


~note_0.free;
~note_0 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 0".postln;
		~transKick.source=0;~transSnr.source=0;~transHat.source=0;
		~transBass.source=0;~transKeys.source=0;~transSamp.source=0;
		~tOSCAdrr.sendMsg('noteLabel', '0');
	});
	},
	'/nt_0'
);

~note_1.free;
~note_1 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 1".postln;
		~transKick.source=1;~transSnr.source=1;~transHat.source=1;
		~transBass.source=1;~transKeys.source=1;~transSamp.source=1;
		~tOSCAdrr.sendMsg('noteLabel', '1');
	});
	},
	'/nt_1'
);


~note_2.free;
~note_2 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 2".postln;
		~transKick.source=2;~transSnr.source=2;~transHat.source=2;
		~transBass.source=2;~transKeys.source=2;~transSamp.source=2;
		~tOSCAdrr.sendMsg('noteLabel', '2');
	});
	},
	'/nt_2'
);

~note_3.free;
~note_3 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 3".postln;
		~transKick.source=3;~transSnr.source=3;~transHat.source=3;
		~transBass.source=3;~transKeys.source=3;~transSamp.source=3;
		~tOSCAdrr.sendMsg('noteLabel', '3');
	});
	},
	'/nt_3'
);

~note_4.free;
~note_4 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 4".postln;
		~transKick.source=4;~transSnr.source=4;~transHat.source=4;
		~transBass.source=4;~transKeys.source=4;~transSamp.source=4;
		~tOSCAdrr.sendMsg('noteLabel', '4');
	});
	},
	'/nt_4'
);

~note_5.free;
~note_5 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 5".postln;
		~transKick.source=5;~transSnr.source=5;~transHat.source=5;
		~transBass.source=5;~transKeys.source=5;~transSamp.source=5;
		~tOSCAdrr.sendMsg('noteLabel', '5');
	});
	},
	'/nt_5'
);

~note_6.free;
~note_6 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 6".postln;
		~transKick.source=6;~transSnr.source=6;~transHat.source=6;
		~transBass.source=6;~transKeys.source=6;~transSamp.source=6;
		~tOSCAdrr.sendMsg('noteLabel', '6');
	});
	},
	'/nt_6'
);

~note_7.free;
~note_7 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 7".postln;
		~transKick.source=7;~transSnr.source=7;~transHat.source=7;
		~transBass.source=7;~transKeys.source=7;~transSamp.source=7;
		~tOSCAdrr.sendMsg('noteLabel', '7');
	});
	},
	'/nt_7'
);

~note_8.free;
~note_8 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 8".postln;
		~transKick.source=8;~transSnr.source=8;~transHat.source=8;
		~transBass.source=8;~transKeys.source=8;~transSamp.source=8;
		~tOSCAdrr.sendMsg('noteLabel', '8');
	});
	},
	'/nt_8'
);

~note_9.free;
~note_9 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 9".postln;
		~transKick.source=9;~transSnr.source=9;~transHat.source=9;
		~transBass.source=9;~transKeys.source=9;~transSamp.source=9;
		~tOSCAdrr.sendMsg('noteLabel', '9');
	});
	},
	'/nt_9'
);

~note_10.free;
~note_10 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 10".postln;
		~transKick.source=10;~transSnr.source=10;~transHat.source=10;
		~transBass.source=10;~transKeys.source=10;~transSamp.source=10;
		~tOSCAdrr.sendMsg('noteLabel', '10');
	});
	},
	'/nt_10'
);

~note_11.free;
~note_11 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 11".postln;
		~transKick.source=11;~transSnr.source=11;~transHat.source=11;
		~transBass.source=11;~transKeys.source=11;~transSamp.source=11;
		~tOSCAdrr.sendMsg('noteLabel', '11');
	});
	},
	'/nt_11'
);

~note_12.free;
~note_12 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 12".postln;
		~transKick.source=12;~transSnr.source=12;~transHat.source=12;
		~transBass.source=12;~transKeys.source=12;~transSamp.source=12;
		~tOSCAdrr.sendMsg('noteLabel', '12');
	});
	},
	'/nt_12'
);

~note_13.free;
~note_13 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 13".postln;
		~transKick.source=13;~transSnr.source=13;~transHat.source=13;
		~transBass.source=13;~transKeys.source=13;~transSamp.source=13;
		~tOSCAdrr.sendMsg('noteLabel', '13');
	});
	},
	'/nt_13'
);

~note_14.free;
~note_14 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 14".postln;
		~transKick.source=14;~transSnr.source=14;~transHat.source=14;
		~transBass.source=14;~transKeys.source=14;~transSamp.source=14;
		~tOSCAdrr.sendMsg('noteLabel', '14');
	});
	},
	'/nt_14'
);

//////////////////////////// NEGATIVE
~note1.free;
~note1 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -1".postln;
		~transKick.source=(-1);~transSnr.source=(-1);~transHat.source=(-1);
		~transBass.source=(-1);~transKeys.source=(-1);~transSamp.source=(-1);
		~tOSCAdrr.sendMsg('noteLabel', '-1');
	});
	},
	'/nt-1'
);


~note2.free;
~note2 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -2".postln;
		~transKick.source=(-2);~transSnr.source=(-2);~transHat.source=(-2);
		~transBass.source=(-2);~transKeys.source=(-2);~transSamp.source=(-2);
		~tOSCAdrr.sendMsg('noteLabel', '-2');
	});
	},
	'/nt-2'
);

~note3.free;
~note3 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -3".postln;
		~transKick.source=(-3);~transSnr.source=(-3);~transHat.source=(-3);
		~transBass.source=(-3);~transKeys.source=(-3);~transSamp.source=(-3);
		~tOSCAdrr.sendMsg('noteLabel', '-3');
	});
	},
	'/nt-3'
);

~note4.free;
~note4 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -4".postln;
		~transKick.source=(-4);~transSnr.source=(-4);~transHat.source=(-4);
		~transBass.source=(-4);~transKeys.source=(-4);~transSamp.source=(-4);
		~tOSCAdrr.sendMsg('noteLabel', '-4');
	});
	},
	'/nt-4'
);

~note5.free;
~note5 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -5".postln;
		~transKick.source=(-5);~transSnr.source=(-5);~transHat.source=(-5);
		~transBass.source=(-5);~transKeys.source=(-5);~transSamp.source=(-5);
		~tOSCAdrr.sendMsg('noteLabel', '-5');
	});
	},
	'/nt-5'
);

~note6.free;
~note6 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -6".postln;
		~transKick.source=(-6);~transSnr.source=(-6);~transHat.source=(-6);
		~transBass.source=(-6);~transKeys.source=(-6);~transSamp.source=(-6);
		~tOSCAdrr.sendMsg('noteLabel', '-6');
	});
	},
	'/nt-6'
);

~note7.free;
~note7 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -7".postln;
		~transKick.source=(-7);~transSnr.source=(-7);~transHat.source=(-7);
		~transBass.source=(-7);~transKeys.source=(-7);~transSamp.source=(-7);
		~tOSCAdrr.sendMsg('noteLabel', '-7');
	});
	},
	'/nt-7'
);

~note8.free;
~note8 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -8".postln;
		~transKick.source=(-8);~transSnr.source=(-8);~transHat.source=(-8);
		~transBass.source=(-8);~transKeys.source=(-8);~transSamp.source=(-8);
		~tOSCAdrr.sendMsg('noteLabel', '-8');
	});
	},
	'/nt-8'
);

~note9.free;
~note9 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -9".postln;
		~transKick.source=(-9);~transSnr.source=(-9);~transHat.source=(-9);
		~transBass.source=(-9);~transKeys.source=(-9);~transSamp.source=(-9);
		~tOSCAdrr.sendMsg('noteLabel', '-9');
	});
	},
	'/nt-9'
);

~note10.free;
~note10 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -10".postln;
		~transKick.source=(-10);~transSnr.source=(-10);~transHat.source=(-10);
		~transBass.source=(-10);~transKeys.source=(-10);~transSamp.source=(-10);
		~tOSCAdrr.sendMsg('noteLabel', '-10');
	});
	},
	'/nt-10'
);

~note11.free;
~note11 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -11".postln;
		~transKick.source=(-11);~transSnr.source=(-11);~transHat.source=(-11);
		~transBass.source=(-11);~transKeys.source=(-11);~transSamp.source=(-11);
		~tOSCAdrr.sendMsg('noteLabel', '-11');
	});
	},
	'/nt-11'
);

~note12.free;
~note12 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -12".postln;
		~transKick.source=(-12);~transSnr.source=(-12);~transHat.source=(-12);
		~transBass.source=(-12);~transKeys.source=(-12);~transSamp.source=(-12);
		~tOSCAdrr.sendMsg('noteLabel', '-12');
	});
	},
	'/nt-12'
);

~note13.free;
~note13 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -13".postln;
		~transKick.source=(-13);~transSnr.source=(-13);~transHat.source=(-13);
		~transBass.source=(-13);~transKeys.source=(-13);~transSamp.source=(-13);
		~tOSCAdrr.sendMsg('noteLabel', '-13');
	});
	},
	'/nt-13'
);

~note14.free;
~note14 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -14".postln;
		~transKick.source=(-14);~transSnr.source=(-14);~transHat.source=(-14);
		~transBass.source=(-14);~transKeys.source=(-14);~transSamp.source=(-14);
		~tOSCAdrr.sendMsg('noteLabel', '-14');
	});
	},
	'/nt-14'
);
