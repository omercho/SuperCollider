/////////////////////----- Note -------//////////////

//~rootKick = PatternProxy( Pseq([0], inf));
//~rootKickP= Pseq([~rootKick], inf).asStream;

~harmXY.remove;
~harmXY= OSCFunc({
	arg msg;

	~harmKick=msg[1];~harmSnr=msg[2];~harmHat=msg[1];
	~harmBass=msg[2];~harmKeys=msg[1];~harmSamp=msg[2];

	//~tOSCAdrr.sendMsg('noteLabel', msg[1]);
	},
	'/harmXY/1'
);

~harm_0.remove;
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


~noteFader.remove;
~noteFader= OSCFunc({
	arg msg;

	~rootKick=msg[1];~rootSnr=msg[1];~rootHat=msg[1];
	~rootBass=msg[1];~rootKeys=msg[1];~rootSamp=msg[1];

	~tOSCAdrr.sendMsg('noteLabel', msg[1]);
	},
	'/noteFader'
);


~note_0.remove;
~note_0 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Root NOTE 0".postln;
		~rootKick=0;~rootSnr=0;~rootHat=0;
		~rootBass=0;~rootKeys=0;~rootSamp=0;
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
		~rootKick=1;~rootSnr=1;~rootHat=1;
		~rootBass=1;~rootKeys=1;~rootSamp=1;
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
		~rootKick=2;~rootSnr=2;~rootHat=2;
		~rootBass=2;~rootKeys=2;~rootSamp=2;
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
		~rootKick=3;~rootSnr=3;~rootHat=3;
		~rootBass=3;~rootKeys=3;~rootSamp=3;
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
		~rootKick=4;~rootSnr=4;~rootHat=4;
		~rootBass=4;~rootKeys=4;~rootSamp=4;
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
		~rootKick=5;~rootSnr=5;~rootHat=5;
		~rootBass=5;~rootKeys=5;~rootSamp=5;
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
		~rootKick=6;~rootSnr=6;~rootHat=6;
		~rootBass=6;~rootKeys=6;~rootSamp=6;
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
		~rootKick=7;~rootSnr=7;~rootHat=7;
		~rootBass=7;~rootKeys=7;~rootSamp=7;
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
		~rootKick=8;~rootSnr=8;~rootHat=8;
		~rootBass=8;~rootKeys=8;~rootSamp=8;
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
		~rootKick=9;~rootSnr=9;~rootHat=9;
		~rootBass=9;~rootKeys=9;~rootSamp=9;
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
		~rootKick=10;~rootSnr=10;~rootHat=10;
		~rootBass=10;~rootKeys=10;~rootSamp=10;
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
		~rootKick=11;~rootSnr=11;~rootHat=11;
		~rootBass=11;~rootKeys=11;~rootSamp=11;
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
		~rootKick=12;~rootSnr=12;~rootHat=12;
		~rootBass=12;~rootKeys=12;~rootSamp=12;
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
		~rootKick=13;~rootSnr=13;~rootHat=13;
		~rootBass=13;~rootKeys=13;~rootSamp=13;
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
		~rootKick=14;~rootSnr=14;~rootHat=14;
		~rootBass=14;~rootKeys=14;~rootSamp=14;
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
		~rootKick=(-1);~rootSnr=(-1);~rootHat=(-1);
		~rootBass=(-1);~rootKeys=(-1);~rootSamp=(-1);
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
		~rootKick=(-2);~rootSnr=(-2);~rootHat=(-2);
		~rootBass=(-2);~rootKeys=(-2);~rootSamp=(-2);
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
		~rootKick=(-3);~rootSnr=(-3);~rootHat=(-3);
		~rootBass=(-3);~rootKeys=(-3);~rootSamp=(-3);
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
		~rootKick=(-4);~rootSnr=(-4);~rootHat=(-4);
		~rootBass=(-4);~rootKeys=(-4);~rootSamp=(-4);
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
		~rootKick=(-5);~rootSnr=(-5);~rootHat=(-5);
		~rootBass=(-5);~rootKeys=(-5);~rootSamp=(-5);
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
		~rootKick=(-6);~rootSnr=(-6);~rootHat=(-6);
		~rootBass=(-6);~rootKeys=(-6);~rootSamp=(-6);
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
		~rootKick=(-7);~rootSnr=(-7);~rootHat=(-7);
		~rootBass=(-7);~rootKeys=(-7);~rootSamp=(-7);
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
		~rootKick=(-8);~rootSnr=(-8);~rootHat=(-8);
		~rootBass=(-8);~rootKeys=(-8);~rootSamp=(-8);
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
		~rootKick=(-9);~rootSnr=(-9);~rootHat=(-9);
		~rootBass=(-9);~rootKeys=(-9);~rootSamp=(-9);
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
		~rootKick=(-10);~rootSnr=(-10);~rootHat=(-10);
		~rootBass=(-10);~rootKeys=(-10);~rootSamp=(-10);
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
		~rootKick=(-11);~rootSnr=(-11);~rootHat=(-11);
		~rootBass=(-11);~rootKeys=(-11);~rootSamp=(-11);
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
		~rootKick=(-12);~rootSnr=(-12);~rootHat=(-12);
		~rootBass=(-12);~rootKeys=(-12);~rootSamp=(-12);
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
		~rootKick=(-13);~rootSnr=(-13);~rootHat=(-13);
		~rootBass=(-13);~rootKeys=(-13);~rootSamp=(-13);
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
		~rootKick=(-14);~rootSnr=(-14);~rootHat=(-14);
		~rootBass=(-14);~rootKeys=(-14);~rootSamp=(-14);
		~tOSCAdrr.sendMsg('noteLabel', '-14');
	});
	},
	'/nt-14'
);
