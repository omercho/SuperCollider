/*

PostAllMIDI.on;
PostAllMIDI.off;

DJDeck4.load;
DJDeck4Rout.play;
DJDeck4.stop;
*/
DJDeck4Rout {
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
		~dj_Deck4R1Player=TaskProxy.new;

		~durMulRootDJ = PatternProxy( Pseq([2], inf));
		~durMulRootDJP= Pseq([~durMulRootDJ], inf).asStream;

		~durRootDJ = PatternProxy(
			Pseq([
				2
			],inf);
		);
		~durRootDJP= Pseq([~durRootDJ], inf).asStream;
	}
	*play{~dj_Deck4R1Player.play(MIDISyncClock, quant: 0);}
	*stop{~dj_Deck4R1Player.stop;}
	*set00{
		//routine
		"Data Jokey Running".postln;
		~dj_Deck4R1Player.source={
			inf.do{
				1.do {
					//~elstc.control(0, 10, 64); //Mel Audio / High
					IFElstc(1);

					((~durRootDJP.next)*(~durMulRootDJP.next)).wait;
				};
			};

		};

	}
	//PLAY STOP REC Buttons
	*responders{
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