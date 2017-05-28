
IFShuf{
	*transKickOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~transShufKick.source  = Pshuf([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
	}
	*transKickOff{
		~transShufKick.source  = Pshuf([0], inf);
	}
	*transSnrOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~transShufSnr.source  = Pshuf([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
	}
	*transSnrOff{
		~transShufSnr.source  = Pshuf([0], inf);
	}
	*transHatOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~transShufHat.source  = Pshuf([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
	}
	*transHatOff{
		~transShufHat.source  = Pshuf([0], inf);
	}
	*transBassOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~transShufBass.source  = Pshuf([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
	}
	*transBassOff{
		~transShufBass.source  = Pshuf([0], inf);
	}
	*transKeysOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~transShufKeys.source  = Pshuf([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
	}
	*transKeysOff{
		~transShufKeys.source  = Pshuf([0], inf);
	}
	*transSampOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~transShufSamp.source  = Pshuf([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
	}
	*transSampOff{
		~transShufSamp.source  = Pshuf([0], inf);
	}

	*loadKick{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufKickBut.free;
		~countShufKick=0;
		~shufKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countShufKick = ~countShufKick + 1;

				~countShufKick.switch(
					0,{},
					1, {
						this.transKickOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
						~apc40.noteOn(~apcLn1, ~lnchBut5, 6); //But 1
					},
					2,{
						this.transKickOff;
						~apc40.noteOn(~apcLn1, ~lnchBut5, 5); //But 1
						~countShufKick=0;
					}
				)
				}
			);
			},
			'/shufKick'
		);
	}
	*loadSnr{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufSnrBut.free;
		~countShufSnr=0;
		~shufSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countShufSnr = ~countShufSnr + 1;

				~countShufSnr.switch(
					0,{},
					1, {
						this.transSnrOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
						~apc40.noteOn(~apcLn2, ~lnchBut5, 6); //But 1
					},
					2,{
						this.transSnrOff;
						~apc40.noteOn(~apcLn2, ~lnchBut5, 5); //But 1
						~countShufSnr=0;
					}
				)
				}
			);
			},
			'/shufSnr'
		);
	}
	*loadHat{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufHatBut.free;
		~countShufHat=0;
		~shufHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countShufHat = ~countShufHat + 1;

				~countShufHat.switch(
					0,{},
					1, {
						this.transHatOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
						~apc40.noteOn(~apcLn3, ~lnchBut5, 6); //But 1
					},
					2,{
						this.transHatOff;
						~apc40.noteOn(~apcLn3, ~lnchBut5, 5); //But 1
						~countShufHat=0;
					}
				)
				}
			);
			},
			'/shufHat'
		);
	}
	*loadBass{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufBassBut.free;
		~countShufBass=0;
		~shufBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countShufBass = ~countShufBass + 1;

				~countShufBass.switch(
					0,{},
					1, {
						this.transBassOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
						~apc40.noteOn(~apcLn5, ~lnchBut5, 6); //But 1
					},
					2,{
						this.transBassOff;
						~apc40.noteOn(~apcLn5, ~lnchBut5, 5); //But 1
						~countShufBass=0;
					}
				)
				}
			);
			},
			'/shufBass'
		);
	}
	*loadKeys{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufKeysBut.free;
		~countShufKeys=0;
		~shufKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countShufKeys = ~countShufKeys + 1;

				~countShufKeys.switch(
					0,{},
					1, {
						this.transKeysOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
						~apc40.noteOn(~apcLn6, ~lnchBut5, 6); //But 1
					},
					2,{
						this.transKeysOff;
						~apc40.noteOn(~apcLn6, ~lnchBut5, 5); //But 1
						~countShufKeys=0;
					}
				)
				}
			);
			},
			'/shufKeys'
		);
	}
	*loadSamp{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufSampBut.free;
		~countShufSamp=0;
		~shufSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countShufSamp = ~countShufSamp + 1;

				~countShufSamp.switch(
					0,{},
					1, {
						this.transSampOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
						~apc40.noteOn(~apcLn7, ~lnchBut5, 6); //But 1
					},
					2,{
						this.transSampOff;
						~apc40.noteOn(~apcLn7, ~lnchBut5, 5); //But 1
						~countShufSamp=0;
					}
				)
				}
			);
			},
			'/shufSamp'
		);
	}
	*harmDrumOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|

		"Harmonics Shuffle".postln;
		~strKick.source=Pshuf([stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8], inf);
		~strSnr.source=Pshuf([stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8], inf);
		~strHat.source=Pshuf([stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8], inf);
	}
	*harmDrumOff{
		~strKick.source=Pshuf([1], inf);
		~strSnr.source=Pshuf([1], inf);
		~strHat.source=Pshuf([1], inf);
	}
	*harmDrum{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufHarmDrumBut.free;
		~countShufHarmDrum=0;
		~shufHarmDrumBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countShufHarmDrum = ~countShufHarmDrum + 1;

				~countShufHarmDrum.switch(
					0,{},
					1, {
						this.harmDrumOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
						~apc40.noteOn(~apcLn4, ~lnchBut5, 6); //But 1
					},
					2,{
						this.harmDrumOff;
						~apc40.noteOn(~apcLn4, ~lnchBut5, 0); //But 1
						~local.sendMsg('harm0', 1);
						~countShufHarmDrum=0;
					}
				)
				}
			);
			},
			'/shufHarm'
		);
		~harmXY.free;
		~harmXY= OSCFunc({
			arg msg;

			//~harmKick=msg[1];
			~harmSnr=msg[1];~harmHat=msg[1]+1*1.5;
			//~harmBass=msg[2];~harmKeys=msg[2];~harmSamp=msg[2]; ~hrmMulExt=msg[1];

			~tOSCAdrr.sendMsg('harm0', 1);
			},
			'/harmXY/1'
		);

		~harm_0.free;
		~harm_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Harmonic 0".postln;
				//~harmKick=0;
				~harmSnr=0;~harmHat=0;
				~harmBass=0;~harmKeys=0;~harmSamp=0; ~hrmMulExt=0;

				//~strKick.source     =  Pshuf([1], inf);
				//~strSnr.source     =  Pshuf([1], inf);
				//~strHat.source     =  Pshuf([1], inf);
				//~strBass.source    =  Pshuf([1], inf);
				//~strKeys.source    =  Pshuf([1], inf);
				//~strSamp.source    =  Pshuf([1], inf);
				~tOSCAdrr.sendMsg('harm0', 0);
				~tOSCAdrr.sendMsg('shufHarm', 0);
			});
			},
			'/harm0'
		);

	}


}
/*

//------------shufKick
~shufKickBut.free;
~countShufKick=0;
~shufKickBut = OSCFunc({
arg msg;
if ( msg[1]==1, {

//"Transpose Shuffle".postln;
~countShufKick = ~countShufKick + 1;

~countShufKick.switch(
0,{},
1, {
~transShufKick.source  = Pshuf([0,2,4,(7), (-2),1,12,(-1)], inf);
~transShufSnr.source  = Pshuf([(-1),3,2,(-7), (-2),4,6,(-1)], inf);
~transShufHat.source  = Pshuf([(-1),2,7,(-6), (-2),3,6,(-4)], inf);
~apc40.noteOn(~apcLn1, ~lnchBut5, 6); //But 1
},
2,{
~transShufKick.source  = Pshuf([0], inf);
~transShufSnr.source  = Pshuf([0], inf);
~transShufHat.source  = Pshuf([0], inf);
~apc40.noteOn(~apcLn1, ~lnchBut5, 5); //But 1
~countShufKick=0;
}
)
},{


}
);
},
'/shufKick'
);

~shufTransBut.free;
~countShuf=0;
~tOSCAdrr.sendMsg('shufTransLabel', 'OFF');
~tOSCAdrr.sendMsg('shufTrans', 0);
~shufTransBut = OSCFunc({
arg msg;
if ( msg[1]==1, {

//"Transpose Shuffle".postln;
~countShuf = ~countShuf + 1;

~countShuf.switch(
0,{~tOSCAdrr.sendMsg('shufTransLabel', 'OFF');
~tOSCAdrr.sendMsg('shufTrans', 0);
},
1, {

"Modal Transpose Shuffle".postln;
~tOSCAdrr.sendMsg('shufTransLabel', 'ON');
~tOSCAdrr.sendMsg('shufTrans', 1);
~transShufBass.source  = Pshuf([0,2,4,(7), 0,1,12,(-1)], inf);
~transShufKeys.source  = Pshuf([0,2,2,4, 0,4,6,1], inf);
~transShufSamp.source  = Pshuf([0,2,7,(-3), 0,(-2),3,6], inf);
~apc40.noteOn(~apcLn4, ~lnchBut4, 6); //But 1
},
2,{
~tOSCAdrr.sendMsg('shufTransLabel', 'OFF');
~tOSCAdrr.sendMsg('shufTrans', 0);
~transShufBass.source  = Pshuf([0], inf);
~transShufKeys.source  = Pshuf([0], inf);
~transShufSamp.source  = Pshuf([0], inf);
~apc40.noteOn(~apcLn4, ~lnchBut4, 5); //But 1
~countShuf=0;
}
)
},{


}
);
},
'/shufTrans'
);

//------------shufDrum
~shufDrumBut.free;
~countShufDrum=0;
~shufDrumBut = OSCFunc({
arg msg;
if ( msg[1]==1, {

//"Transpose Shuffle".postln;
~countShufDrum = ~countShufDrum + 1;

~countShufDrum.switch(
0,{},
1, {
//~transShufKick.source  = Pshuf([0,2,4,(7), (-2),1,12,(-1)], inf);
~transShufSnr.source  = Pshuf([(-1),3,2,(-7), (-2),4,6,(-1)], inf);
~transShufHat.source  = Pshuf([(-1),2,7,(-6), (-2),3,6,(-4)], inf);
~apc40.noteOn(~apcLn4, ~lnchBut5, 6); //But 1
},
2,{
//~transShufKick.source  = Pshuf([0], inf);
~transShufSnr.source  = Pshuf([0], inf);
~transShufHat.source  = Pshuf([0], inf);
~apc40.noteOn(~apcLn4, ~lnchBut5, 5); //But 1
~countShufDrum=0;
}
)
},{


}
);
},
'/shufDrum'
);

*/	