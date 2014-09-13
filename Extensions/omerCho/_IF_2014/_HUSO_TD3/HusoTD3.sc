HusoTD3 {

	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({
				1.5.wait;
				this.track1;



			});
		}
	}

	*track1 {

		(
			"TD3 Track1 loaded".postln;
			~tdKick.free;
			~tdKick=MIDIFunc.noteOn( {
				arg vel;
				vel=vel/128;

				"Kick".postln;
				~amp1Kick.source=vel;
				~amp1Bass.source=vel;
				IFKick_SC(~tmMulKickP.next*~tmKickP.next);
				IFBass_SC(~tmBassP.next);


			}, chan:9, noteNum:36);



			~tdHatClosed.free;
			~tdHatClosed=MIDIFunc.noteOn( {
				arg vel;
				vel=vel/168;

				"HatClosed".postln;
				~amp1Hat.source=vel;~harmHatTD=1; IFHat_SC(~tmMulHatP.next*~tmHatP.next);

				~amp1Keys.source=vel;IFKeys_SC(~tmKeysP.next);


			}, chan:9, noteNum:42);

			~tdHatOpen.free;
			~tdHatOpen=MIDIFunc.noteOn( {
				arg vel;
				vel=(vel/160);
				"HatOpen".postln;
				~amp1Hat.source=vel;~harmHatTD=0.8; IFHat_SC(~tmMulHatP.next*~tmHatP.next);
				~amp1Keys.source=vel;IFKeys_SC(~tmKeysP.next);


			}, chan:9, noteNum:46);

			~tdHatPedal.free;
			~tdHatPedal=MIDIFunc.noteOn( {
				arg vel;
				vel=vel/128;
				"HatPedal".postln;
				~amp1Hat.source=vel;~harmHatTD=1.8; IFHat_SC(~tmMulHatP.next*~tmHatP.next);


			}, chan:9, noteNum:44);

			~tdHatPedalBut.free;
			~tdHatPedalBut=MIDIFunc.cc( {
				arg vel;
				"HatPedalButton".postln;
				if ( vel==127, {
					~susTD=1;
					},{
						~susTD=3;
				});

			}, chan:9, ccNum:4);

			~tdSnare.free;
			~tdSnare=MIDIFunc.noteOn( {
				arg vel;
				vel=vel/128;

				"Snare".postln;
				~tomMul=16; ~freq2Snr=19;~freq3Snr=19; ~wnoiseSnr=0.03;
				~amp1Snr.source=vel;IFSnr_SC(~tmMulSnrP.next*~tmSnrP.next);
				~amp1Samp.source=vel;IFSamp_SC(~tmSampP.next);



			}, chan:9, noteNum:38);

			~tdTom1.free;
			~tdTom1=MIDIFunc.noteOn( {
				arg vel;
				vel=vel/128;

				"Tom_1".postln;
				~tomMul=5; ~freq2Snr=69;~freq3Snr=49; ~wnoiseSnr=0.3;
				~amp1Snr.source=vel;IFSnr_SC(~tmMulSnrP.next*~tmSnrP.next);
				~amp1Bass.source=vel;IFBass_SC(~tmBassP.next);

			}, chan:9, noteNum:48);

			~tdTom2.free;
			~tdTom2=MIDIFunc.noteOn( {
				arg vel;
				vel=vel/128;

				"Tom_2".postln;
				~tomMul=10; ~freq2Snr=65;~freq3Snr=44; ~wnoiseSnr=0.2;
				~amp1Snr.source=vel;IFSnr_SC(~tmMulSnrP.next*~tmSnrP.next);
				~amp1Keys.source=vel;IFKeys_SC(~tmKeysP.next);

			}, chan:9, noteNum:45);

			~tdTom3.free;
			~tdTom3=MIDIFunc.noteOn( {
				arg vel;
				vel=vel/128;

				"Tom_3".postln;
				~tomMul=17; ~freq2Snr=50;~freq3Snr=39; ~wnoiseSnr=0.1;
				~amp1Snr.source=vel;IFSnr_SC(~tmMulSnrP.next*~tmSnrP.next);
				~amp1Samp.source=vel;IFSamp_SC(~tmSampP.next);

			}, chan:9, noteNum:41);

			~tdCrash1.free;
			~tdCrash1=MIDIFunc.noteOn( {
				arg vel;
				vel=vel/128;
				"Crash_1".postln;
				~amp1Hat.source=vel;~harmHatTD=0.4; IFHat_SC(~tmMulHatP.next*~tmHatP.next);


			}, chan:9, noteNum:49);

			~tdRide.free;
			~tdRide=MIDIFunc.noteOn( {
				arg vel;
				vel=vel/128;
				"Ride".postln;
				~amp1Hat.source=vel; ~harmHatTD=3.8; IFHat_SC(~tmMulHatP.next*~tmHatP.next);


			}, chan:9, noteNum:51);

		)

	}
}