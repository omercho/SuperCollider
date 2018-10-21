APC40{
	*loadSource{
		~apc40 = MIDIOut.newByName("Akai APC40", "Akai APC40");
		~apc40OutID=34339974;
		~apc40InID=1665708355;
		this.shiftButton;
	}//loadAtStart

	*shiftButton{
		//~apc40.noteOn(0, 98, 127); //SHIFT
		~apc40ShiftBut.free;
		~apc40ShiftBut=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				APC40TrackSelection.tracks;
				},{
					~trackCase.switch(
						0,{},
						1, {
							IFTrack01.apcParts;
						},
						2,{
							IFTrack02.apcParts;
						}
						3,{
							IFTrack03.apcParts;
						}
					)
			});
		},srcID:~apc40InID, chan:0, noteNum:98);
	}

}



APC40TrackSelection{
	*tracks{
		~apc_TS01.free;
		~apc_TS01=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack01.loadAtStart;
			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS02.free;
		~apc_TS02=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack02.loadAtStart;
			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS03.free;
		~apc_TS03=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {
				IFTrack03.loadAtStart;
			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS04.free;
		~apc_TS04=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS05.free;
		~apc_TS05=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS06.free;
		~apc_TS06=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS07.free;
		~apc_TS07=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:51);
		~apc_TS08.free;
		~apc_TS08=MIDIFunc.noteOn( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~apc40InID, chan:0, noteNum:51);

	}//tracks

}

/*

~apc40 = MIDIOut.newByName("Akai APC40", "Akai APC40");


~volHatFader.free;
~volHatFader= OSCFunc({
arg msg,vel;
vel=msg[1]*127;
~tOSCAdrr.sendMsg('volHat', msg[1]);
~mdOut.control(2, 1, vel);
},
'/volHat'
);

~volHat_APC.free;
~volHat_APC=MIDIFunc.cc( {
arg vel;
~tOSCAdrr.sendMsg('volHat', vel/127);
~mdOut.control(2, 1, vel);

}, chan:0, ccNum:7);

~countActHat_APC=0;
~actHatMD_APC.free;
~actHatMD_APC=MIDIFunc.noteOn({
arg vel;
if ( vel==127, {
~countActHat_APC = ~countActHat_APC + 1;
~countActHat_APC.switch(
0,{},
1, {
~actHat.source=1;
~tOSCAdrr.sendMsg('activHat', 1);
~apc40.noteOn(0, 48, 127);
},
2,{
~actHat.source=0;
~tOSCAdrr.sendMsg('activHat', 0);
~apc40.noteOff(0, 48, 127);
~countActHat_APC=0;
}
)}
);
}, chan:0, noteNum:48);

~countTime2Hat_APC=0;
~time2HatMD_APC.free;
~time2HatMD_APC=MIDIFunc.noteOn({
arg vel;
if ( vel==127, {
~countTime2Hat_APC = ~countTime2Hat_APC + 1;
~countTime2Hat_APC.switch(
0,{},
1, {
~apc40.noteOn(0, 49, 127);
~tOSCAdrr.sendMsg('time2Hat', 1);
~tOSCAdrr.sendMsg('tmHatLabel', 2);
~tmMulHat.source = Pseq([2], inf);
},
2,{
~apc40.noteOff(0, 49, 127);
~tOSCAdrr.sendMsg('time2Hat', 0);
~tOSCAdrr.sendMsg('tmHatLabel', 1);
~tmMulHat.source = Pseq([1], inf);
~countTime2Hat_APC=0;
}
)}
);
}, chan:0, noteNum:49);

~countHatBut3_APC=0;
~but3HatMD_APC.free;
~but3HatMD_APC=MIDIFunc.noteOn({
arg vel;
if ( vel==127, {
~countHatBut3_APC = ~countHatBut3_APC + 1;
~countHatBut3_APC.switch(
0,{},
1, {
~apc40.noteOn(0, 50, 127);

},
2,{
~apc40.noteOff(0, 50, 127);

~countHatBut3_APC=0;
}
)}
);
}, chan:0, noteNum:50);






(
~countActBass_APC=0;
~actBassMD_APC.free;
~actBassMD_APC=MIDIFunc.noteOn({
arg vel;
if ( vel==127, {
~countActBass_APC = ~countActBass_APC + 1;
~countActBass_APC.switch(
0,{},
1, {
~actBass.source=1;
~tOSCAdrr.sendMsg('activBass', 1);
~apc40.noteOn(3, 48, 127);
},
2,{
~actBass.source=0;
~tOSCAdrr.sendMsg('activBass', 0);
~apc40.noteOff(3, 48, 127);
~countActBass_APC=0;
}
)}
);
},48,3,~apc40InID);

)

~countActBass_APC=0;
~actBassMD_APC.remove;
~actBassMD_APC=NoteOnResponder({ |src,chan,note,vel|
[src,chan,note,vel].postln;

if ( vel==127, {
~countActBass_APC = ~countActBass_APC + 1;
~countActBass_APC.switch(
0,{},
1, {
~actBass.source=1;
~tOSCAdrr.sendMsg('activBass', 1);
~apc40.noteOn(3, 48, 127);
},
2,{
~actBass.source=0;
~tOSCAdrr.sendMsg('activBass', 0);
~apc40.noteOff(3, 48, 127);
~countActBass_APC=0;
}
)}
);

},1665708355,3,48,nil);


~apc40ID.value


~apc40.noteOn(0, 52, 0); //But 3

*/