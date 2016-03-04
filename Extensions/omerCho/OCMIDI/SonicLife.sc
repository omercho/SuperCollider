SonicLife {

	*load{
		~sonic = NetAddr.new("192.168.1.4", 59663); // router OTE

		~snc1.free;
		~snc1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"sonic 1 RED".postln;
				~tOSCAdrr.sendMsg('sonicRed', msg[1]);
				},{
					~tOSCAdrr.sendMsg('sonicRed', 0);
			});
			},
			'1'
		);


		~snc2.free;
		~snc2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"sonic 2 Green".postln;
				~tOSCAdrr.sendMsg('sonicGreen', msg[1]);
				},{
					~tOSCAdrr.sendMsg('sonicGreen', 0);
			});
			},
			'2'
		);

		~snc3.free;
		~snc3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"sonic 3 Blue".postln;
				~tOSCAdrr.sendMsg('sonicBlue', msg[1]);
				},{
					~tOSCAdrr.sendMsg('sonicBlue', 0);
			});
			},
			'3'
		);
	}

}//calss END