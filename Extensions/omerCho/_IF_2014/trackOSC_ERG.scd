~trackOSC_1.free;
~trackOSC_1= OSCFunc({
	arg msg;

	~track1.fork;

	},
	'/track1'
);

~trackOSC_2.free;
~trackOSC_2= OSCFunc({
	arg msg;

	~track2.fork;

	},
	'/track2'
);

~trackOSC_3.free;
~trackOSC_3= OSCFunc({
	arg msg;

	~track3.fork;

	},
	'/track3'
);

~trackOSC_4.free;
~trackOSC_4= OSCFunc({
	arg msg;

	~track4.fork;

	},
	'/track4'
);