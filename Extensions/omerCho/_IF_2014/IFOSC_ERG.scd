PostAllOSC.on;
PostAllOSC.off;


~tOSCAdrr = NetAddr.new("192.168.1.2", 57130); // create the NetAddr
~tOSCAdrr.sendMsg('/1/label1', 'part1');// send the application the message "hello" with the parameter "there"

~tOSCAdrr.sendMsg('/1/toggleMain', 0);


(
~togMain.remove;
~togMain = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"IF Main PLAY".postln;

		~ifPlay={|tm=4|

			//~nt1Keys.source   =  Pseq([~nt+0, ~nt+3, ~nt+2, ~nt+4, ~nt+24 , ~nt+14], inf);
			//~dur1Keys.source  =  Pseq([1]*1, inf);
			//~amp1Keys.source  =  Pseq([0.9], inf);
			//~sus1Samp.source  =  Pseq([0.2], inf);
			//1
			inf.do{
				12.do {


					~transKeys=(-0);~transSamp=(0); ~transBass=(0);
					IFKeys([1].choose);
					IFSamp([1].choose);
					IFBass([1].choose);
					IFKick([1].choose);
					IFSnr([1].choose);
					IFHat([2].choose);
					~dur.next.wait;
				};
			};

		}.fork;


	});

	if ( msg[1]==0, {
		"IF Main STOP".postln;
		~ifPlay.stop;

	});
	},
	'/1/toggleMain'
);

~noteFader.remove;
~noteFader= OSCFunc({
	arg msg;
	~nt= msg[1];
	~tOSCAdrr.sendMsg('noteLabel', msg[1]);
	},
	'/noteFader'
);

~tempoFader.remove;
~tempoFader= OSCFunc({
	arg msg;
	IFProject.setTempo(msg[1]);
	~tOSCAdrr.sendMsg('tempoLabel', msg[1]);
	},
	'/tempoFader'
);

~tapAbleton.remove;
~tapAbleton= OSCFunc({
	arg msg;
	if ( msg[1]==1, {

		Ableton.tap4;

	});
	},
	'/tapAbleton'
);

~note_0.remove;
~note_0 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 0".postln;
		~nt=0;
		~tOSCAdrr.sendMsg('noteLabel', '0');
	});
	},
	'/nt_0'
);

~note_1.remove;
~note_1 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 1".postln;
		~nt=1;
		~tOSCAdrr.sendMsg('noteLabel', '1');
	});
	},
	'/nt_1'
);


~note_2.remove;
~note_2 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 2".postln;
		~nt=2;
		~tOSCAdrr.sendMsg('noteLabel', '2');
	});
	},
	'/nt_2'
);

~note_3.remove;
~note_3 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 3".postln;
		~nt=3;
		~tOSCAdrr.sendMsg('noteLabel', '3');
	});
	},
	'/nt_3'
);

~note_4.remove;
~note_4 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 4".postln;
		~nt=4;
		~tOSCAdrr.sendMsg('noteLabel', '4');
	});
	},
	'/nt_4'
);

~note_5.remove;
~note_5 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 5".postln;
		~nt=5;
		~tOSCAdrr.sendMsg('noteLabel', '5');
	});
	},
	'/nt_5'
);

~note_6.remove;
~note_6 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 6".postln;
		~nt=6;
		~tOSCAdrr.sendMsg('noteLabel', '6');
	});
	},
	'/nt_6'
);

~note_7.remove;
~note_7 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 7".postln;
		~nt=7;
		~tOSCAdrr.sendMsg('noteLabel', '7');
	});
	},
	'/nt_7'
);

~note_8.remove;
~note_8 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 8".postln;
		~nt=8;
		~tOSCAdrr.sendMsg('noteLabel', '8');
	});
	},
	'/nt_8'
);

~note_9.remove;
~note_9 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 9".postln;
		~nt=9;
		~tOSCAdrr.sendMsg('noteLabel', '9');
	});
	},
	'/nt_9'
);

~note_10.remove;
~note_10 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 10".postln;
		~nt=10;
		~tOSCAdrr.sendMsg('noteLabel', '10');
	});
	},
	'/nt_10'
);

~note_11.remove;
~note_11 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 11".postln;
		~nt=11;
		~tOSCAdrr.sendMsg('noteLabel', '11');
	});
	},
	'/nt_11'
);

~note_12.remove;
~note_12 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 12".postln;
		~nt=12;
		~tOSCAdrr.sendMsg('noteLabel', '12');
	});
	},
	'/nt_12'
);

~note_13.remove;
~note_13 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 13".postln;
		~nt=13;
		~tOSCAdrr.sendMsg('noteLabel', '13');
	});
	},
	'/nt_13'
);

~note_14.remove;
~note_14 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE 14".postln;
		~nt=14;
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
		"Main NOTE -1".postln;
		~nt=(-1);
		~tOSCAdrr.sendMsg('noteLabel', '-1');
	});
	},
	'/nt-1'
);


~note2.remove;
~note2 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE -2".postln;
		~nt=(-2);
		~tOSCAdrr.sendMsg('noteLabel', '-2');
	});
	},
	'/nt-2'
);

~note3.remove;
~note3 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE -3".postln;
		~nt=(-3);
		~tOSCAdrr.sendMsg('noteLabel', '-3');
	});
	},
	'/nt-4'
);

~note4.remove;
~note4 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE -4".postln;
		~nt=(-4);
		~tOSCAdrr.sendMsg('noteLabel', '-4');
	});
	},
	'/nt-4'
);

~note5.remove;
~note5 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE -5".postln;
		~nt=(-5);
		~tOSCAdrr.sendMsg('noteLabel', '-5');
	});
	},
	'/nt-5'
);

~note6.remove;
~note6 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE -6".postln;
		~nt=(-6);
		~tOSCAdrr.sendMsg('noteLabel', '-6');
	});
	},
	'/nt-6'
);

~note7.remove;
~note7 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE -7".postln;
		~nt=(-7);
		~tOSCAdrr.sendMsg('noteLabel', '-7');
	});
	},
	'/nt-7'
);

~note8.remove;
~note8 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE -8".postln;
		~nt=(-8);
		~tOSCAdrr.sendMsg('noteLabel', '-8');
	});
	},
	'/nt-8'
);

~note9.remove;
~note9 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE -9".postln;
		~nt=(-9);
		~tOSCAdrr.sendMsg('noteLabel', '-9');
	});
	},
	'/nt-9'
);

~note10.remove;
~note10 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE -10".postln;
		~nt=(-10);
		~tOSCAdrr.sendMsg('noteLabel', '-10');
	});
	},
	'/nt-10'
);

~note11.remove;
~note11 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE -11".postln;
		~nt=(-11);
		~tOSCAdrr.sendMsg('noteLabel', '-11');
	});
	},
	'/nt-11'
);

~note12.remove;
~note12 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE -12".postln;
		~nt=(-12);
		~tOSCAdrr.sendMsg('noteLabel', '-12');
	});
	},
	'/nt-12'
);

~note13.remove;
~note13 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE -13".postln;
		~nt=(-13);
		~tOSCAdrr.sendMsg('noteLabel', '-13');
	});
	},
	'/nt-13'
);

~note14.remove;
~note14 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"Main NOTE -14".postln;
		~nt=(-14);
		~tOSCAdrr.sendMsg('noteLabel', '-14');
	});
	},
	'/nt-14'
);




~part__0.remove;
~part_0 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part0".postln;

		~mainSet_00.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'part0');
	});
	},
	'/part0'
);

~part_1.remove;
~part_1 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part1".postln;

		~mainSet_01.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'part1');
	});
	},
	'/part1'
);

~part_2.remove;
~part_2 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part2".postln;

		~mainSet_02.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'part2');
	});
	},
	'/part2'
);

~part_3.remove;
~part_3 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part3".postln;

		~tOSCAdrr.sendMsg('partLabel', 'part3');
	});
	},
	'/part3'
);

~part_4.remove;
~part_4 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part4".postln;

		~tOSCAdrr.sendMsg('partLabel', 'part4');
	});
	},
	'/part4'
);

~part_5.remove;
~part_5 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part5".postln;

		~tOSCAdrr.sendMsg('partLabel', 'part5');
	});
	},
	'/part5'
);

~part_6.remove;
~part_6 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part6".postln;

		~tOSCAdrr.sendMsg('partLabel', 'part6');
	});
	},
	'/part6'
);

~part_7.remove;
~part_7 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part7".postln;

		~tOSCAdrr.sendMsg('partLabel', 'part7');
	});
	},
	'/part7'
);



)