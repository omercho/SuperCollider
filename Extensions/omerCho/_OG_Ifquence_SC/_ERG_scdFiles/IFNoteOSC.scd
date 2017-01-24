/////////////////////----- Note -------//////////////

//~legKick = PatternProxy( Pseq([0], inf));
//~legKickP= Pseq([~legKick], inf).asStream;

~noteFader.remove;
~noteFader= OSCFunc({
	arg msg;

	~legKick.source=msg[1];~legSnr.source=msg[1];~legHat.source=msg[1];
	~legBass.source=msg[1];~legKeys.source=msg[1];~legSamp.source=msg[1];

	~tOSCAdrr.sendMsg('noteLabel', msg[1]);
	},
	'/noteFader'
);


~note_0.remove;
~note_0 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 0".postln;
		~legKick.source=0;
		~tOSCAdrr.sendMsg('noteLabel', '0');
	});
	},
	'/nt_0'
);

~note_1.remove;
~note_1 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 1".postln;
		~legKick.source=1;
		~tOSCAdrr.sendMsg('noteLabel', '1');
	});
	},
	'/nt_1'
);


~note_2.remove;
~note_2 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 2".postln;
		~legKick.source=2;
		~tOSCAdrr.sendMsg('noteLabel', '2');
	});
	},
	'/nt_2'
);

~note_3.remove;
~note_3 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 3".postln;
		~legKick.source=3;
		~tOSCAdrr.sendMsg('noteLabel', '3');
	});
	},
	'/nt_3'
);

~note_4.remove;
~note_4 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 4".postln;
		~legKick.source=4;
		~tOSCAdrr.sendMsg('noteLabel', '4');
	});
	},
	'/nt_4'
);

~note_5.remove;
~note_5 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 5".postln;
		~legKick.source=5;
		~tOSCAdrr.sendMsg('noteLabel', '5');
	});
	},
	'/nt_5'
);

~note_6.remove;
~note_6 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 6".postln;
		~legKick.source=6;
		~tOSCAdrr.sendMsg('noteLabel', '6');
	});
	},
	'/nt_6'
);

~note_7.remove;
~note_7 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 7".postln;
		~legKick.source=7;
		~tOSCAdrr.sendMsg('noteLabel', '7');
	});
	},
	'/nt_7'
);

~note_8.remove;
~note_8 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 8".postln;
		~legKick.source=8;
		~tOSCAdrr.sendMsg('noteLabel', '8');
	});
	},
	'/nt_8'
);

~note_9.remove;
~note_9 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 9".postln;
		~legKick.source=9;
		~tOSCAdrr.sendMsg('noteLabel', '9');
	});
	},
	'/nt_9'
);

~note_10.remove;
~note_10 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 10".postln;
		~legKick.source=10;
		~tOSCAdrr.sendMsg('noteLabel', '10');
	});
	},
	'/nt_10'
);

~note_11.remove;
~note_11 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 11".postln;
		~legKick.source=11;
		~tOSCAdrr.sendMsg('noteLabel', '11');
	});
	},
	'/nt_11'
);

~note_12.remove;
~note_12 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 12".postln;
		~legKick.source=12;
		~tOSCAdrr.sendMsg('noteLabel', '12');
	});
	},
	'/nt_12'
);

~note_13.remove;
~note_13 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 13".postln;
		~legKick.source=13;
		~tOSCAdrr.sendMsg('noteLabel', '13');
	});
	},
	'/nt_13'
);

~note_14.remove;
~note_14 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 14".postln;
		~legKick.source=14;
		~tOSCAdrr.sendMsg('noteLabel', '14');
	});
	},
	'/nt_14'
);

//////////////////////////// NEGATIVE
~note1.remove;
~note1 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -1".postln;
		~legKick.source=(-1);
		~tOSCAdrr.sendMsg('noteLabel', '-1');
	});
	},
	'/nt-1'
);


~note2.remove;
~note2 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -2".postln;
		~legKick.source=(-2);
		~tOSCAdrr.sendMsg('noteLabel', '-2');
	});
	},
	'/nt-2'
);

~note3.remove;
~note3 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -3".postln;
		~legKick.source=(-3);
		~tOSCAdrr.sendMsg('noteLabel', '-3');
	});
	},
	'/nt-3'
);

~note4.remove;
~note4 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -4".postln;
		~legKick.source=(-4);
		~tOSCAdrr.sendMsg('noteLabel', '-4');
	});
	},
	'/nt-4'
);

~note5.remove;
~note5 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -5".postln;
		~legKick.source=(-5);
		~tOSCAdrr.sendMsg('noteLabel', '-5');
	});
	},
	'/nt-5'
);

~note6.remove;
~note6 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -6".postln;
		~legKick.source=(-6);
		~tOSCAdrr.sendMsg('noteLabel', '-6');
	});
	},
	'/nt-6'
);

~note7.remove;
~note7 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -7".postln;
		~legKick.source=(-7);
		~tOSCAdrr.sendMsg('noteLabel', '-7');
	});
	},
	'/nt-7'
);

~note8.remove;
~note8 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -8".postln;
		~legKick.source=(-8);
		~tOSCAdrr.sendMsg('noteLabel', '-8');
	});
	},
	'/nt-8'
);

~note9.remove;
~note9 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -9".postln;
		~legKick.source=(-9);
		~tOSCAdrr.sendMsg('noteLabel', '-9');
	});
	},
	'/nt-9'
);

~note10.remove;
~note10 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -10".postln;
		~legKick.source=(-10);
		~tOSCAdrr.sendMsg('noteLabel', '-10');
	});
	},
	'/nt-10'
);

~note11.remove;
~note11 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -11".postln;
		~legKick.source=(-11);
		~tOSCAdrr.sendMsg('noteLabel', '-11');
	});
	},
	'/nt-11'
);

~note12.remove;
~note12 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -12".postln;
		~legKick.source=(-12);
		~tOSCAdrr.sendMsg('noteLabel', '-12');
	});
	},
	'/nt-12'
);

~note13.remove;
~note13 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -13".postln;
		~legKick.source=(-13);
		~tOSCAdrr.sendMsg('noteLabel', '-13');
	});
	},
	'/nt-13'
);

~note14.remove;
~note14 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE -14".postln;
		~legKick.source=(-14);
		~tOSCAdrr.sendMsg('noteLabel', '-14');
	});
	},
	'/nt-14'
);
