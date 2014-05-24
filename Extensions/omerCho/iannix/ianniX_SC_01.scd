NetAddr.langPort;
OSCFunc.trace(true); // Turn posting on
OSCFunc.trace(false); // Turn posting off

~curs2 = OSCFunc({
	arg msg;
	msg.postln;
	},
	'/cursor'
);



~trig3 = OSCFunc({
	arg msg;
	if ( msg[1]==3, {"post 3".postln;});
	},
	'/trigger'
);

~trig4 = OSCFunc({
	arg msg;
	if ( msg[1]==4, { "trigger 4".postln;});
	},
	'/trigger'
);

~trig5 = OSCFunc({
	arg msg;
	if ( msg[1]==5, { "trigger 5".postln;});
	},
	'/trigger'
);



~curs2 = OSCFunc({
	arg msg;
	[msg[3], msg[4], msg[5]].postln;
	/*if ( msg[1]==0, {
		"cursRecieve".postln;
		~s1.set(
			\par1,msg[3],
			\par2,msg[4],
			\par3,msg[5]
		);

	})*/},
	'/cursor'
);


~ianniX = NetAddr("localhost", 1234);

~playStop = OSCFunc({
	arg msg;
	if ( msg[1]=='play', { "PLAYYYYY".postln; });
	if ( msg[1]=='stop', { "STOPPPPP".postln; });
	},
	'/transport'
);

~ianniX.sendMsg('/iannix/play', 1);
~ianniX.sendMsg('/iannix/stop', 1);
~ianniX.sendMsg('/iannix/speed', 0.1);