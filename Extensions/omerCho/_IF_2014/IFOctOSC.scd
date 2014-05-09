//----Kick-------
~octKickMulBut.remove;
~octKickMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulKick = ~octMulKick+1;
		~tOSCAdrr.sendMsg('octKickLabel', ~octMulKick);

	});

	},
	'/octKickMul'
);

~octKickZeroBut.remove;
~octKickZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulKick = 0;
		~tOSCAdrr.sendMsg('octKickLabel', ~octMulKick);

	});

	},
	'/octKickZero'
);

~octKickDivBut.remove;
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
~octSnrMulBut.remove;
~octSnrMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulSnr = ~octMulSnr+1;
		~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

	});

	},
	'/octSnrMul'
);

~octSnrZeroBut.remove;
~octSnrZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulSnr = 0;
		~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

	});

	},
	'/octSnrZero'
);

~octSnrDivBut.remove;
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
~octHatMulBut.remove;
~octHatMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulHat = ~octMulHat+1;
		~tOSCAdrr.sendMsg('octHatLabel', ~octMulHat);

	});

	},
	'/octHatMul'
);

~octHatZeroBut.remove;
~octHatZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulHat = 0;
		~tOSCAdrr.sendMsg('octHatLabel', ~octMulHat);

	});

	},
	'/octHatZero'
);

~octHatDivBut.remove;
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
~octKeysMulBut.remove;
~octKeysMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulKeys = ~octMulKeys+1;
		~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);

	});

	},
	'/octKeysMul'
);

~octKeysZeroBut.remove;
~octKeysZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulKeys = 0;
		~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);

	});

	},
	'/octKeysZero'
);

~octKeysDivBut.remove;
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
~octBassMulBut.remove;
~octBassMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulBass = ~octMulBass+1;
		~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);

	});

	},
	'/octBassMul'
);

~octBassZeroBut.remove;
~octBassZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulBass = 0;
		~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);

	});

	},
	'/octBassZero'
);

~octBassDivBut.remove;
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
~octSampMulBut.remove;
~octSampMulBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulSamp = ~octMulSamp+1;
		~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);

	});

	},
	'/octSampMul'
);

~octSampZeroBut.remove;
~octSampZeroBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulSamp = 0;
		~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);

	});

	},
	'/octSampZero'
);

~octSampDivBut.remove;
~octSampDivBut= OSCFunc({
	arg msg;


	if ( msg[1]==1, {

		~octMulSamp = ~octMulSamp-1;
		~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);

	});

	},
	'/octSampDiv'
);