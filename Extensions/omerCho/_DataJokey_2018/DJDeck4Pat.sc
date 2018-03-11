/*

PostAllMIDI.on;
PostAllMIDI.off;

DJDeck4.load;
DJDeck4Pat.play;
DJDeck4Pat.stop;
*/
DJDeck4Pat {
	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({this.load; });
		}
	}
	*load{
		this.globals;
		this.set00;

	}
	*globals{

	}
	*play{Pdef(\deck4Pat1).play(MIDISyncClock, quant: 0);}
	*stop{Pdef(\deck4Pat1).stop;}
	*set00{
		//pattern
		Pdef(\deck4Pat1,
			Pbind(
				\type, \midi, \midiout,~elstc,
				\chan, Pseq([0], inf),\octave,0,
				\dur, Pseq([0.25],inf),
				\note, Pseq([
					[3,1],
					[3,5],
					[3,6],
					[3,4],
					[3,1,2],
					[3,6],
					[3,5],
					[3,4]
				], inf),
				\amp, Pseq([1], inf)
			)
		);
	}
	*responder{
		//PLAY ROUT Responder
		~togPat1Main.free;
		~togPat1Main = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				fork{1.do{
					DJDeck4.playPat1;
				}};
			});
			if ( msg[1]==0, {
				fork{1.do{
					DJDeck4.stopPat1;
				}};
			});
		},
		'/1/playD3P1'
		);

		~cntPlayD3P1But=0;
		~deck4P1PlayButtonMIDI.free;
		~deck4P1PlayButtonMIDI=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntPlayBut = ~cntPlayBut + 1;
				~cntPlayBut.switch(
					0,{},
					1, {
						~local.sendMsg('/1/playD3P1', 1);
						~apc40.noteOn(~apcLn4, 55, 4); //But 1
					},
					2,{
						~local.sendMsg('/1/playD3P1', 0);
						~cntPlayBut=0;
					}
			)}
			);
		},srcID:~apc40InID, chan:~apcLn1, noteNum:~apcPlayBut);
	}
	//PLAY STOP REC Buttons
	*playRoutine1{
		~togRoutMain.free;
		~togRoutMain = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				fork{1.do{
					DJDeck4.playRout1;
				}};
			});
			if ( msg[1]==0, {
				fork{1.do{
					DJDeck4.stopRout1;
				}};
			});
		},
		'/1/playD3R1'
		);
		~cntPlayD3R1But=0;
		~deck4R1PlayButtonMIDI.free;
		~deck4R1PlayButtonMIDI=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntPlayD3R1But = ~cntPlayD3R1But + 1;
				~cntPlayD3R1But.switch(
					0,{},
					1, {
						~local.sendMsg('/1/playD3R1', 1);
						~djMn.noteOn(~apcLn4, 55, 4); //But 1
					},
					2,{
						~local.sendMsg('/1/playD3R1', 0);
						~djMn.noteOn(~apcLn4, 55, 0); //But 1
						~cntPlayD3R1But=0;
					}
			)}
			);
		},srcID:1292133807, chan:0, noteNum:69);
	}

}

/*


*/