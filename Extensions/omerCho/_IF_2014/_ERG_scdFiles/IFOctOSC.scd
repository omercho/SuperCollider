//----Kick-------
~octKickMulBut.free;
~octKickMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulKick = ~octMulKick+1;
		~tOSCAdrr.sendMsg('octKickLabel', ~octMulKick);

	});

	},
	'/octKickMul'
);

~octKickZeroBut.free;
~octKickZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulKick = 0;
		~tOSCAdrr.sendMsg('octKickLabel', ~octMulKick);

	});

	},
	'/octKickZero'
);

~octKickDivBut.free;
~octKickDivBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulKick = ~octMulKick-1;
		~tOSCAdrr.sendMsg('octKickLabel', ~octMulKick);

	});

	},
	'/octKickDiv'
);

//----Snr-------
~octSnrMulBut.free;
~octSnrMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulSnr = ~octMulSnr+1;
		~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

	});

	},
	'/octSnrMul'
);

~octSnrZeroBut.free;
~octSnrZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulSnr = 0;
		~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

	});

	},
	'/octSnrZero'
);

~octSnrDivBut.free;
~octSnrDivBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulSnr = ~octMulSnr-1;
		~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

	});

	},
	'/octSnrDiv'
);

//----Hat-------
~octHatMulBut.free;
~octHatMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulHat = ~octMulHat+1;
		~tOSCAdrr.sendMsg('octHatLabel', ~octMulHat);

	});

	},
	'/octHatMul'
);

~octHatZeroBut.free;
~octHatZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulHat = 0;
		~tOSCAdrr.sendMsg('octHatLabel', ~octMulHat);

	});

	},
	'/octHatZero'
);

~octHatDivBut.free;
~octHatDivBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulHat = ~octMulHat-1;
		~tOSCAdrr.sendMsg('octHatLabel', ~octMulHat);

	});

	},
	'/octHatDiv'
);

//----Keys-------
~octKeysMulBut.free;
~octKeysMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulKeys = ~octMulKeys+1;
		~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);

	});

	},
	'/octKeysMul'
);

~octKeysZeroBut.free;
~octKeysZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulKeys = 0;
		~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);

	});

	},
	'/octKeysZero'
);

~octKeysDivBut.free;
~octKeysDivBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulKeys = ~octMulKeys-1;
		~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);

	});

	},
	'/octKeysDiv'
);

//----Bass-------
~octBassMulBut.free;
~octBassMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulBass = ~octMulBass+1;
		~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);

	});

	},
	'/octBassMul'
);

~octBassZeroBut.free;
~octBassZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulBass = 0;
		~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);

	});

	},
	'/octBassZero'
);

~octBassDivBut.free;
~octBassDivBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulBass = ~octMulBass-1;
		~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);

	});

	},
	'/octBassDiv'
);

//----Samp-------
~octSampMulBut.free;
~octSampMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulSamp = ~octMulSamp+1;
		~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);

	});

	},
	'/octSampMul'
);

~octSampZeroBut.free;
~octSampZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulSamp = 0;
		~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);

	});

	},
	'/octSampZero'
);

~octSampDivBut.free;
~octSampDivBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulSamp = ~octMulSamp-1;
		~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);

	});

	},
	'/octSampDiv'
);