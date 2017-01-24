~seqReciever.free;
~countSeqRec=1;
~seqReciever= OSCFunc({
	arg msg;
	if ( msg[1]==1, {//"Transpose Shuffle".postln;
		~countSeqRec.switch(
			0,{
				"0".postln;
				~tOSCAdrr.sendMsg('seqLed08', 0);
				~countSeqRec = ~countSeqRec + 1;
			},
			1, {
				"1".postln;
				~tOSCAdrr.sendMsg('seqLed08', 0);
				~tOSCAdrr.sendMsg('seqLed01', 1);
				~countSeqRec = ~countSeqRec + 1;
			},
			2, {
				"2".postln;
				~tOSCAdrr.sendMsg('seqLed01', 0);
				~tOSCAdrr.sendMsg('seqLed02', 1);
				~countSeqRec = ~countSeqRec + 1;
			},
			3, {
				"3".postln;
				~tOSCAdrr.sendMsg('seqLed02', 0);
				~tOSCAdrr.sendMsg('seqLed03', 1);
				~countSeqRec = ~countSeqRec + 1;
			},
			4, {
				"4".postln;
				~tOSCAdrr.sendMsg('seqLed03', 0);
				~tOSCAdrr.sendMsg('seqLed04', 1);
				~countSeqRec = ~countSeqRec + 1;
			},
			5, {
				"5".postln;
				~tOSCAdrr.sendMsg('seqLed04', 0);
				~tOSCAdrr.sendMsg('seqLed05', 1);
				~countSeqRec = ~countSeqRec + 1;
			},
			6, {
				"6".postln;
				~tOSCAdrr.sendMsg('seqLed05', 0);
				~tOSCAdrr.sendMsg('seqLed06', 1);
				~countSeqRec = ~countSeqRec + 1;
			},
			7, {
				"7".postln;
				~tOSCAdrr.sendMsg('seqLed06', 0);
				~tOSCAdrr.sendMsg('seqLed07', 1);
				~countSeqRec = ~countSeqRec + 1;
			},
			8,{
				"8".postln;
				~tOSCAdrr.sendMsg('seqLed07', 0);
				~tOSCAdrr.sendMsg('seqLed08', 1);
				~countSeqRec=1;
			}

		)}
	);
	},
	'/seqRec'
);

~local.sendMsg('seqRec', 1);