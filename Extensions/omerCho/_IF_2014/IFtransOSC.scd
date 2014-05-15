//----Kick-------
~transKickMulBut.free;
~transKickMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trKick = ~trKick+1;
		~tOSCAdrr.sendMsg('transKickLabel', ~trKick);

	});

	},
	'/transKickMul'
);

~transKickZeroBut.free;
~transKickZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trKick = 0;
		~tOSCAdrr.sendMsg('transKickLabel', ~trKick);

	});

	},
	'/transKickZero'
);

~transKickDivBut.free;
~transKickDivBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trKick = ~trKick-1;
		~tOSCAdrr.sendMsg('transKickLabel', ~trKick);

	});

	},
	'/transKickDiv'
);

//----Snr-------
~transSnrMulBut.free;
~transSnrMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trSnr = ~trSnr+1;
		~tOSCAdrr.sendMsg('transSnrLabel', ~trSnr);

	});

	},
	'/transSnrMul'
);

~transSnrZeroBut.free;
~transSnrZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trSnr = 0;
		~tOSCAdrr.sendMsg('transSnrLabel', ~trSnr);

	});

	},
	'/transSnrZero'
);

~transSnrDivBut.free;
~transSnrDivBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trSnr = ~trSnr-1;
		~tOSCAdrr.sendMsg('transSnrLabel', ~trSnr);

	});

	},
	'/transSnrDiv'
);

//----Hat-------
~transHatMulBut.free;
~transHatMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trHat = ~trHat+1;
		~tOSCAdrr.sendMsg('transHatLabel', ~trHat);

	});

	},
	'/transHatMul'
);

~transHatZeroBut.free;
~transHatZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trHat = 0;
		~tOSCAdrr.sendMsg('transHatLabel', ~trHat);

	});

	},
	'/transHatZero'
);

~transHatDivBut.free;
~transHatDivBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trHat = ~trHat-1;
		~tOSCAdrr.sendMsg('transHatLabel', ~trHat);

	});

	},
	'/transHatDiv'
);

//----Keys-------
~transKeysMulBut.free;
~transKeysMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trKeys = ~trKeys+1;
		~tOSCAdrr.sendMsg('transKeysLabel', ~trKeys);

	});

	},
	'/transKeysMul'
);

~transKeysZeroBut.free;
~transKeysZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trKeys = 0;
		~tOSCAdrr.sendMsg('transKeysLabel', ~trKeys);

	});

	},
	'/transKeysZero'
);

~transKeysDivBut.free;
~transKeysDivBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trKeys = ~trKeys-1;
		~tOSCAdrr.sendMsg('transKeysLabel', ~trKeys);

	});

	},
	'/transKeysDiv'
);

//----Bass-------
~transBassMulBut.free;
~transBassMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trBass = ~trBass+1;
		~tOSCAdrr.sendMsg('transBassLabel', ~trBass);

	});

	},
	'/transBassMul'
);

~transBassZeroBut.free;
~transBassZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trBass = 0;
		~tOSCAdrr.sendMsg('transBassLabel', ~trBass);

	});

	},
	'/transBassZero'
);

~transBassDivBut.free;
~transBassDivBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trBass = ~trBass-1;
		~tOSCAdrr.sendMsg('transBassLabel', ~trBass);

	});

	},
	'/transBassDiv'
);

//----Samp-------
~transSampMulBut.free;
~transSampMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trSamp = ~trSamp+1;
		~tOSCAdrr.sendMsg('transSampLabel', ~trSamp);

	});

	},
	'/transSampMul'
);

~transSampZeroBut.free;
~transSampZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trSamp = 0;
		~tOSCAdrr.sendMsg('transSampLabel', ~trSamp);

	});

	},
	'/transSampZero'
);

~transSampDivBut.free;
~transSampDivBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~trSamp = ~trSamp-1;
		~tOSCAdrr.sendMsg('transSampLabel', ~trSamp);

	});

	},
	'/transSampDiv'
);