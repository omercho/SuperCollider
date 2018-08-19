/*

PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

*/
IFRoot {
	*load{this.globals;}
	*globals{

		~ifRootPlayer=TaskProxy.new;

	}

	*play{~ifRootPlayer.play(TempoClock.default, quant: 0);}
/*
	*play{~ifRootPlayer.play(MIDISyncClock, quant: 0);}
*/
	*stop{~ifRootPlayer.stop;}

	*set00{
		"IFRoot Player 00".postln;
		~ifRootPlayer.source={
			//~cntApcUpdate=0;
			inf.do{
				1.do {


					IFSequence.step(~stepNumP.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);

					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					IFMopho(~tmMulMophoP.next*~tmMophoP.next);

					IFMast(~tmMulMastP.next*~tmMastP.next);

					IFRes(~tmMulResP.next*~tmResP.next);



					/*~cntApcUpdate = ~cntApcUpdate + 1;
					~cntApcUpdate.switch(
					0,{},
					16,{
					IFAPC40.update;
					~cntApcUpdate=0;
					}
					);*/
					((~durP.next)*(~durMulP.next)).wait;
				};
			};

		};

	}

	*set01{

		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFSequence.step(~stepNumP.next);
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);

					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);

					IFMast(~tmMulMastP.next*~tmMastP.next);

					IFRes(~tmResP.next);

					((~durP.next)*(~durMulP.next)).wait;

				};
			};

		};

	}

	*set02{

		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFSequence.step(~stepNumP.next);
					IFMast(~tmMulMastP.next*~tmMastP.next);
					//IFVKick(~tmMulVKickP.next*~tmVKickP.next);
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					((~durP.next)*(~durMulP.next)).wait;
				};
			};

		};

	}

	*set03{

		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFSequence.step(~stepNumP.next);
					IFMast(~tmMulMastP.next*~tmMastP.next);
					IFRes(~tmResP.next);
					//IFVKick(~tmMulVKickP.next*~tmVKickP.next);
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					~durMul*((~durP.next)).wait;
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					~durMul*((~durP.next)).wait;
				};
			};

		};

	}


	*set04{

		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFSequence.step(~stepNumP.next);
					IFMast(~tmMulMastP.next*~tmMastP.next);
					IFRes(~tmResP.next);
					//IFVKick(~tmMulVKickP.next*~tmVKickP.next);
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					((~durP.next)*(~durMulP.next)).wait;
				};
			};

		};

	}
	*set05{

		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFSequence.step(~stepNumP.next);
					IFMast(~tmMulMastP.next*~tmMastP.next);
					IFRes(~tmResP.next);
					//IFVKick(~tmMulVKickP.next*~tmVKickP.next);
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFBass(~tmMulBassP.next*~tmBassP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					((~durP.next)*(~durMulP.next)).wait;
				};
			};

		};

	}

}

/*
*set00{
"IFRoot Player 00".postln;
~ifRootPlayer.source={

inf.do{
1.do {


IFSequence.step(~stepNumP.next);
//IFCounter.step(~stepNumCntP.next);
//~local.sendMsg('seqRec', 1);
//IFVKick(~tmMulVKickP.next*~tmVKickP.next);
IFKick(~tmMulKickP.next*~tmKickP.next);
IFSnr(~tmMulSnrP.next*~tmSnrP.next);
IFHat(~tmMulHatP.next*~tmHatP.next);

IFBass(~tmMulBassP.next*~tmBassP.next);
IFKeys(~tmMulKeysP.next*~tmKeysP.next);
IFSamp(~tmMulSampP.next*~tmSampP.next);

IFMast(~tmMulMastP.next*~tmMastP.next);

IFRes(~tmResP.next);

//~vBeatsLate=Tempo.bpm*(1/267.91897);
//Ableton.tap4;


((~durP.next)*(~durMulP.next)).wait;
};
};

};

}

*/