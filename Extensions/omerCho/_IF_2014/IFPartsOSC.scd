/////////////////////----- Parts -------//////////////

~part_0.free;
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


~part_1.free;
~part_1 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part1".postln;

		~mainSet_01.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'pt01');
	});
	},
	'/part1'
);

~part_2.free;
~part_2 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part2".postln;

		~mainSet_02.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'pt02');
	});
	},
	'/part2'
);

~part_3.free;
~part_3 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part3".postln;

		~mainSet_03.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'pt03');
	});
	},
	'/part3'
);

~part_4.free;
~part_4 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part4".postln;

		~mainSet_04.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'pt04');
	});
	},
	'/part4'
);

~part_5.free;
~part_5 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part5".postln;

		~mainSet_05.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'pt05');
	});
	},
	'/part5'
);

~part_6.free;
~part_6 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part6".postln;

		~mainSet_06.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'pt06');
	});
	},
	'/part6'
);

~part_7.free;
~part_7 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"part7".postln;

		~mainSet_07.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'pt07');
	});
	},
	'/part7'
);

/////////////////////----- Bridges -------//////////////



~bridge1.free;
~bridge1 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"bridge1".postln;

		~mainBridge_01.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'brg1');
	});
	},
	'/bridge1'
);

~bridge2.free;
~bridge2 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"bridge2".postln;

		~mainBridge_02.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'brg2');
	});
	},
	'/bridge2'
);

~bridge3.free;
~bridge3 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"bridge3".postln;

		~mainBridge_03.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'brg3');
	});
	},
	'/bridge3'
);

~bridge4.free;
~bridge4 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"bridge4".postln;

		~mainBridge_04.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'brg4');
	});
	},
	'/bridge4'
);

~bridge5.free;
~bridge5 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"bridge5".postln;

		~mainBridge_05.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'brg5');
	});
	},
	'/bridge5'
);

~bridge6.free;
~bridge6 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"bridge6".postln;

		~mainBridge_06.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'brg6');
	});
	},
	'/bridge6'
);

~bridge7.free;
~bridge7 = OSCFunc({
	arg msg;
	if ( msg[1]==1, {
		"bridge7".postln;

		~mainBridge_07.fork(quant:0);
		~tOSCAdrr.sendMsg('partLabel', 'brg7');
	});
	},
	'/bridge7'
);