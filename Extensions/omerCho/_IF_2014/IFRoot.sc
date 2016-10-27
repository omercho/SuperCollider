IFRoot {

	*load{

		this.globals;

	}
	*globals{

		~ifRootPlayer=TaskProxy.new;


	}
	*play{~ifRootPlayer.play;}
	*stop{~ifRootPlayer.stop;}

	*set00{
		"IFRoot Player 00".postln;
		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFCounter.count;

					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);

					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);

					IFRes1(~tmRes1P.next);

					//~vBeatsLate=Tempo.bpm*(1/267.91897);
					//Ableton.tap4;


					~durMul*((~durP.next)).wait;
				};
			};

		};

	}

	*set01{

		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFCounter.count;
					IFRes1(~tmRes1P.next);

					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					~durMul*((~durP.next)).wait;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					~durMul*((~durP.next)).wait;

				};
			};

		};

	}

	*set02{

		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFCounter.count;
					IFRes1(~tmRes1P.next);

					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					~durMul*((~durP.next)).wait;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					~durMul*((~durP.next)).wait;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					~durMul*((~durP.next)).wait;
				};
			};

		};

	}

	*set03{

		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFCounter.count;
					IFRes1(~tmRes1P.next);

					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					~durMul*((~durP.next)).wait;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					~durMul*((~durP.next)).wait;
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


					IFCounter.count;
					IFRes1(~tmRes1P.next);

					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					~durMul*((~durP.next)).wait;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					~durMul*((~durP.next)).wait;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					~durMul*((~durP.next)).wait;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					~durMul*((~durP.next)).wait;
				};
			};

		};

	}
	*set05{

		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFCounter.count;
					IFRes1(~tmRes1P.next);

					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFBass(~tmMulBassP.next*~tmBassP.next);
					~durMul*((~durP.next)).wait;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					~durMul*((~durP.next)).wait;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					~durMul*((~durP.next)).wait;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					~durMul*((~durP.next)).wait;
				};
			};

		};

	}

}