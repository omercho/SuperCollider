/*
IFSequence.step(~stepNumP.next);
IFKick(~tmMulKickP.next*~tmKickP.next);


IFSequence.step(~stepNumP.next);
IFSnr(~tmMulSnrP.next*~tmSnrP.next);

IFSequence.step(~stepNumP.next);
IFHat(~tmMulHatP.next*~tmHatP.next);

IFSequence.step(~stepNumP.next);
IFBass(~tmMulBassP.next*~tmBassP.next);

IFSequence.step(~stepNumP.next);
IFKeys(~tmMulKeysP.next*~tmKeysP.next);

IFSequence.step(~stepNumP.next);
IFSamp(~tmMulSampP.next*~tmSampP.next);

*/

IFRoot {

	*load{

		this.globals;

	}
	*globals{

		~ifRootPlayer=TaskProxy.new;

		/*
		~dur.source = Pseq([
		~seqDurPat01,~seqDurPat02,~seqDurPat03,~seqDurPat04,
		~seqDurPat05,~seqDurPat06,~seqDurPat07,~seqDurPat08,
		~seqDurPat09,~seqDurPat10,~seqDurPat11,~seqDurPat12,
		~seqDurPat13,~seqDurPat14,~seqDurPat15,~seqDurPat16
		],inf);
		~durMul.source = Pseq([1/2],inf);
		IFSeqDurPat.stGrp(2);
		*/

	}
	*play{~ifRootPlayer.play(TempoClock.default, quant: 0);}
	*stop{~ifRootPlayer.stop;}

	*set00{
		"IFRoot Player 00".postln;
		~ifRootPlayer.source={
			//~cntApcUpdate=0;
			inf.do{
				1.do {


					IFSequence.step(~stepNumP.next);
					IFKick(~tmMulKickP.next*~tmKickP.next);IFKick.stat01;
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);IFSnr.stat01;
					IFHat(~tmMulHatP.next*~tmHatP.next);IFHat.stat01;

					IFBass(~tmMulBassP.next*~tmBassP.next);IFBass.stat01;
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);IFKeys.stat01;
					IFSamp(~tmMulSampP.next*~tmSampP.next);IFSamp.stat01;

					IFMast(~tmMulMastP.next*~tmMastP.next);

					IFRes1(~tmMulRes1P.next*~tmRes1P.next);



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

					IFRes1(~tmRes1P.next);

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
					IFRes1(~tmRes1P.next);
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
					IFRes1(~tmRes1P.next);
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
					IFRes1(~tmRes1P.next);
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

IFRes1(~tmRes1P.next);

//~vBeatsLate=Tempo.bpm*(1/267.91897);
//Ableton.tap4;


((~durP.next)*(~durMulP.next)).wait;
};
};

};

}

*/