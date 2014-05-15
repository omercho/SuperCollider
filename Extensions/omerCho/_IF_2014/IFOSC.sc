IFOSC {

	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({
				1.0.wait;
				this.globals;
				this.sets;
				this.main;
				this.parts;
				this.bridge;
				this.note;
				this.oct;
				this.trans;


			});
		}
	}

	*globals {

		~tOSCAdrr = NetAddr.new("192.168.1.4", 57130); // create the NetAddr


	}

	*sets {

		~setAllBut.free;
		~setAllBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFProject.preSetAll;

			});
			},
			'/setAll'
		);

	}

	*main {

		~togMain.free;
		~togMain = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"IF Main PLAY".postln;
				~mainSet_01.fork(quant:0);
				~ifPlay={|tm=4|

					inf.do{
						1.do {

							//~md1Clock.play;
							IFKick(~tmMulKickP.next*~tmKickP.next);
							IFSnr(~tmMulSnrP.next*~tmSnrP.next);
							IFHat(~tmMulHatP.next*~tmHatP.next);

							IFKeys(~tmKeysP.next );
							IFBass(~tmBassP.next);
							IFSamp(~tmSampP.next);

							~durMul*((~durP.next)).wait;
						};
					};

				}.fork;


			});

			if ( msg[1]==0, {
				"IF Main STOP".postln;
				~ifPlay.stop;
				//~md1Clock.stop;

			});
			},
			'/1/toggleMain'
		);

		~susAllMulFader.free;
		~susAllMulFader= OSCFunc({
			arg msg;

			~susMulKick=msg[1];~susMulSnr=msg[1];~susMulHat=msg[1];
			~susMulBass=msg[1];~susMulKeys=msg[1];~susMulSamp=msg[1];



			},
			'/susAll'
		);

		~lfoMulKeysFad.free;
		~lfoMulKeysFad= OSCFunc({
			arg msg;

			~lfoMulKeys=msg[1];



			},
			'/lfoMulKeys'
		);

		~lfoMulBassFad.free;
		~lfoMulBassFad= OSCFunc({
			arg msg;

			~lfoMulBass=msg[1];



			},
			'/lfoMulBass'
		);

		~lfoMulSampFad.free;
		~lfoMulSampFad= OSCFunc({
			arg msg;

			~lfoMulSamp=msg[1];



			},
			'/lfoMulSamp'
		);

		~susAllFader.free;
		~susAllFader= OSCFunc({
			arg msg;

			~md1.control(1, 41, msg[1]); //KickChain
			~md1.control(1, 42, msg[1]); //SnrChain
			~md1.control(1, 43, msg[1]); //HatChain
			~md1.control(1, 44, msg[1]); //BassChain
			~md1.control(1, 45, msg[1]); //KeysChain
			~md1.control(1, 46, msg[1]); //SampChain



			},
			'/chainAll'
		);

		~tempoFader.free;
		~tempoFader= OSCFunc({
			arg msg;

			IFProject.setTempo(msg[1]);
			~tOSCAdrr.sendMsg('tempoLabel', msg[1]);


			},
			'/tempoFader'
		);

		~tapAbleton.free;
		~tapAbleton= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				Ableton.tap4;

			});
			},
			'/tapAbleton'
		);

		~padKick.free;
		~padKick = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFKick(~tmKickP.next);

			});
			},
			'/padKick'
		);

		~padSnr.free;
		~padSnr = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFSnr(~tmSnrP.next);

			});
			},
			'/padSnr'
		);

		~padHat.free;
		~padHat = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFHat(~tmHatP.next);

			});
			},
			'/padHat'
		);

		~padKeys.free;
		~padKeys = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFKeys(~tmKeysP.next);

			});
			},
			'/padKeys'
		);

		~padBass.free;
		~padBass = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFBass(~tmBassP.next);

			});
			},
			'/padBass'
		);

		~padSamp.free;
		~padSamp = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFSamp(~tmSampP.next);

			});
			},
			'/padSamp'
		);

		/////////////////////---- TIMES FADERS ----//////////////////

		~tmKickFader.free;
		~tmKickFader= OSCFunc({
			arg msg;
			~tmKick.source = msg[1];

			},
			'/timesKick'
		);
		~tmSnrFader.free;
		~tmSnrFader= OSCFunc({
			arg msg;
			~tmSnr.source = msg[1];

			},
			'/timesSnr'
		);
		~tmHatFader.free;
		~tmHatFader= OSCFunc({
			arg msg;
			~tmHat.source = msg[1];

			},
			'/timesHat'
		);
		~tmKeysFader.free;
		~tmKeysFader= OSCFunc({
			arg msg;
			~tmKeys.source = msg[1];

			},
			'/timesKeys'
		);
		~tmBassFader.free;
		~tmBassFader= OSCFunc({
			arg msg;
			~tmBass.source = msg[1];

			},
			'/timesBass'
		);
		~tmSampFader.free;
		~tmSampFader= OSCFunc({
			arg msg;
			~tmSamp.source = msg[1];

			},
			'/timesSamp'
		);

		~tmMulKickBut.free;
		~tmMulKickBut= OSCFunc({
			arg msg;
			~tmMulKick.source = msg[1];

			},
			'/tmMulKick'
		);
		~tmMulSnrBut.free;
		~tmMulSnrBut= OSCFunc({
			arg msg;
			~tmMulSnr.source = msg[1];

			},
			'/tmMulSnr'
		);
		~tmMulHatBut.free;
		~tmMulHatBut= OSCFunc({
			arg msg;
			~tmMulHat.source = msg[1];

			},
			'/tmMulHat'
		);



		//---------------- DUR Buttons ---------------//

		~dur1But.free;
		~dur1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur1".postln;
				~tOSCAdrr.sendMsg('durLabel', msg[1]);

				~dur.source = Pseq([1], inf)*~durMulP;

			});
			},
			'/dur1'
		);

		~dur05But.free;
		~dur05But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur0.5".postln;
				~tOSCAdrr.sendMsg('durLabel', msg[1]);
				~dur.source = Pseq([
					Pseq([1], 7),
					Pseq([0.5,0.5], 1)
				], inf)*~durMulP;

			});
			},
			'/dur05'
		);

		~durAks1But.free;
		~durAks1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------durAks1".postln;
				~tOSCAdrr.sendMsg('durLabel', 'Aks');
				~dur.source = Pseq([
					Pseq([0.5,0.5,0.75], 1),
					Pseq([0.5,0.75], 1),
					Pseq([0.5,0.5,0.75], 1),
					Pseq([0.5,0.75], 2)
				], inf)*~durMulP;

			});
			},
			'/durAks1'
		);

		~durShuf1But.free;
		~durShuf1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------durShuf1".postln;
				~tOSCAdrr.sendMsg('durLabel', 'shuf');
				~dur.source = Pshuf([
					Pshuf([0.25,0.5,0.5], 1),
					Pshuf([0.25,0.75], 1),
					Pshuf([0.5,0.25,0.25], 1),
					Pshuf([0.5,0.75], 2)
				], inf)*~durMulP;

			});
			},
			'/durShuf1'
		);

		~durRand1But.free;
		~durRand1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------durRand1".postln;
				~tOSCAdrr.sendMsg('durLabel', 'rand');
				~dur.source = Pseq([
					Pwhite(0.5, 0.9, 2),
					Pwhite(0.2, 0.5, 2),
					Pbrown(0.1, 2, 0.2, 2),
					Pxrand([0.5,0.75, 1, 0.25], 2)
				], inf)*~durMulP;

			});
			},
			'/durRand1'
		);

		~durMul1_4But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur1".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1/4');

				~durMul.source = Pseq([1/4], inf);

			});
			},
			'/durMul1_4'
		);

		~durMul1_2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur1".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1/2');

				~durMul.source = Pseq([1/2], inf);

			});
			},
			'/durMul1_2'
		);

		~durMul1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur1".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1');

				~durMul.source = Pseq([1], inf);

			});
			},
			'/durMul1'
		);

		~durMul2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur1".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '2');

				~durMul.source = Pseq([2], inf);

			});
			},
			'/durMul2'
		);


	}

	*parts {

		/////////////////////----- Parts -------//////////////

		~part_0.free;
		~part_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part0".postln;

				~mainSet_00.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'part0');
			});
			},
			'/part0'
		);


		~part_1.free;
		~part_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part1".postln;

				~mainSet_01.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt01');
			});
			},
			'/part1'
		);

		~part_2.free;
		~part_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part2".postln;

				~mainSet_02.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt02');
			});
			},
			'/part2'
		);

		~part_3.free;
		~part_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part3".postln;

				~mainSet_03.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt03');
			});
			},
			'/part3'
		);

		~part_4.free;
		~part_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part4".postln;

				~mainSet_04.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt04');
			});
			},
			'/part4'
		);

		~part_5.free;
		~part_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part5".postln;

				~mainSet_05.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt05');
			});
			},
			'/part5'
		);

		~part_6.free;
		~part_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part6".postln;

				~mainSet_06.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt06');
			});
			},
			'/part6'
		);

		~part_7.free;
		~part_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part7".postln;

				~mainSet_07.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt07');
			});
			},
			'/part7'
		);

	}

	*bridge {


		/////////////////////----- Bridges -------//////////////



		~bridge1.free;
		~bridge1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"bridge1".postln;

				~mainBridge_01.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'brg1');
			});
			},
			'/bridge1'
		);

		~bridge2.free;
		~bridge2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"bridge2".postln;

				~mainBridge_02.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'brg2');
			});
			},
			'/bridge2'
		);

		~bridge3.free;
		~bridge3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"bridge3".postln;

				~mainBridge_03.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'brg3');
			});
			},
			'/bridge3'
		);

		~bridge4.free;
		~bridge4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"bridge4".postln;

				~mainBridge_04.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'brg4');
			});
			},
			'/bridge4'
		);

		~bridge5.free;
		~bridge5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"bridge5".postln;

				~mainBridge_05.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'brg5');
			});
			},
			'/bridge5'
		);

		~bridge6.free;
		~bridge6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"bridge6".postln;

				~mainBridge_06.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'brg6');
			});
			},
			'/bridge6'
		);

		~bridge7.free;
		~bridge7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"bridge7".postln;

				~mainBridge_07.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'brg7');
			});
			},
			'/bridge7'
		);

	}

	*note {

		/////////////////////----- Note -------//////////////

		//~transKick.source = PatternProxy( Pseq([0], inf));
		//~transKick.sourceP= Pseq([~transKick.source], inf).asStream;

		~harmXY.free;
		~harmXY= OSCFunc({
			arg msg;

			~harmKick=msg[1];~harmSnr=msg[2];~harmHat=msg[1];
			~harmBass=msg[2];~harmKeys=msg[1];~harmSamp=msg[2];

			//~tOSCAdrr.sendMsg('noteLabel', msg[1]);
			},
			'/harmXY/1'
		);

		~harm_0.free;
		~harm_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Harmonic 0".postln;
				~harmKick=0;~harmSnr=0;~harmHat=0;
				~harmBass=0;~harmKeys=0;~harmSamp=0;
				//~tOSCAdrr.sendMsg('noteLabel', '0');
			});
			},
			'/harm0'
		);


		~noteFader.free;
		~noteFader= OSCFunc({
			arg msg;

			~transKick.source=msg[1];~transSnr.source=msg[1];~transHat.source=msg[1];
			~transBass.source=msg[1];~transKeys.source=msg[1];~transSamp.source=msg[1];

			~tOSCAdrr.sendMsg('noteLabel', msg[1]);
			},
			'/noteFader'
		);


		~note_0.free;
		~note_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 0".postln;
				~transKick.source=0;~transSnr.source=0;~transHat.source=0;
				~transBass.source=0;~transKeys.source=0;~transSamp.source=0;
				~tOSCAdrr.sendMsg('noteLabel', '0');
			});
			},
			'/nt_0'
		);

		~note_1.free;
		~note_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 1".postln;
				~transKick.source=1;~transSnr.source=1;~transHat.source=1;
				~transBass.source=1;~transKeys.source=1;~transSamp.source=1;
				~tOSCAdrr.sendMsg('noteLabel', '1');
			});
			},
			'/nt_1'
		);


		~note_2.free;
		~note_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 2".postln;
				~transKick.source=2;~transSnr.source=2;~transHat.source=2;
				~transBass.source=2;~transKeys.source=2;~transSamp.source=2;
				~tOSCAdrr.sendMsg('noteLabel', '2');
			});
			},
			'/nt_2'
		);

		~note_3.free;
		~note_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 3".postln;
				~transKick.source=3;~transSnr.source=3;~transHat.source=3;
				~transBass.source=3;~transKeys.source=3;~transSamp.source=3;
				~tOSCAdrr.sendMsg('noteLabel', '3');
			});
			},
			'/nt_3'
		);

		~note_4.free;
		~note_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 4".postln;
				~transKick.source=4;~transSnr.source=4;~transHat.source=4;
				~transBass.source=4;~transKeys.source=4;~transSamp.source=4;
				~tOSCAdrr.sendMsg('noteLabel', '4');
			});
			},
			'/nt_4'
		);

		~note_5.free;
		~note_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 5".postln;
				~transKick.source=5;~transSnr.source=5;~transHat.source=5;
				~transBass.source=5;~transKeys.source=5;~transSamp.source=5;
				~tOSCAdrr.sendMsg('noteLabel', '5');
			});
			},
			'/nt_5'
		);

		~note_6.free;
		~note_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 6".postln;
				~transKick.source=6;~transSnr.source=6;~transHat.source=6;
				~transBass.source=6;~transKeys.source=6;~transSamp.source=6;
				~tOSCAdrr.sendMsg('noteLabel', '6');
			});
			},
			'/nt_6'
		);

		~note_7.free;
		~note_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 7".postln;
				~transKick.source=7;~transSnr.source=7;~transHat.source=7;
				~transBass.source=7;~transKeys.source=7;~transSamp.source=7;
				~tOSCAdrr.sendMsg('noteLabel', '7');
			});
			},
			'/nt_7'
		);

		~note_8.free;
		~note_8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 8".postln;
				~transKick.source=8;~transSnr.source=8;~transHat.source=8;
				~transBass.source=8;~transKeys.source=8;~transSamp.source=8;
				~tOSCAdrr.sendMsg('noteLabel', '8');
			});
			},
			'/nt_8'
		);

		~note_9.free;
		~note_9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 9".postln;
				~transKick.source=9;~transSnr.source=9;~transHat.source=9;
				~transBass.source=9;~transKeys.source=9;~transSamp.source=9;
				~tOSCAdrr.sendMsg('noteLabel', '9');
			});
			},
			'/nt_9'
		);

		~note_10.free;
		~note_10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 10".postln;
				~transKick.source=10;~transSnr.source=10;~transHat.source=10;
				~transBass.source=10;~transKeys.source=10;~transSamp.source=10;
				~tOSCAdrr.sendMsg('noteLabel', '10');
			});
			},
			'/nt_10'
		);

		~note_11.free;
		~note_11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 11".postln;
				~transKick.source=11;~transSnr.source=11;~transHat.source=11;
				~transBass.source=11;~transKeys.source=11;~transSamp.source=11;
				~tOSCAdrr.sendMsg('noteLabel', '11');
			});
			},
			'/nt_11'
		);

		~note_12.free;
		~note_12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 12".postln;
				~transKick.source=12;~transSnr.source=12;~transHat.source=12;
				~transBass.source=12;~transKeys.source=12;~transSamp.source=12;
				~tOSCAdrr.sendMsg('noteLabel', '12');
			});
			},
			'/nt_12'
		);

		~note_13.free;
		~note_13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 13".postln;
				~transKick.source=13;~transSnr.source=13;~transHat.source=13;
				~transBass.source=13;~transKeys.source=13;~transSamp.source=13;
				~tOSCAdrr.sendMsg('noteLabel', '13');
			});
			},
			'/nt_13'
		);

		~note_14.free;
		~note_14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE 14".postln;
				~transKick.source=14;~transSnr.source=14;~transHat.source=14;
				~transBass.source=14;~transKeys.source=14;~transSamp.source=14;
				~tOSCAdrr.sendMsg('noteLabel', '14');
			});
			},
			'/nt_14'
		);

		//////////////////////////// NEGATIVE
		~note1.free;
		~note1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -1".postln;
				~transKick.source=(-1);~transSnr.source=(-1);~transHat.source=(-1);
				~transBass.source=(-1);~transKeys.source=(-1);~transSamp.source=(-1);
				~tOSCAdrr.sendMsg('noteLabel', '-1');
			});
			},
			'/nt-1'
		);


		~note2.free;
		~note2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -2".postln;
				~transKick.source=(-2);~transSnr.source=(-2);~transHat.source=(-2);
				~transBass.source=(-2);~transKeys.source=(-2);~transSamp.source=(-2);
				~tOSCAdrr.sendMsg('noteLabel', '-2');
			});
			},
			'/nt-2'
		);

		~note3.free;
		~note3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -3".postln;
				~transKick.source=(-3);~transSnr.source=(-3);~transHat.source=(-3);
				~transBass.source=(-3);~transKeys.source=(-3);~transSamp.source=(-3);
				~tOSCAdrr.sendMsg('noteLabel', '-3');
			});
			},
			'/nt-3'
		);

		~note4.free;
		~note4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -4".postln;
				~transKick.source=(-4);~transSnr.source=(-4);~transHat.source=(-4);
				~transBass.source=(-4);~transKeys.source=(-4);~transSamp.source=(-4);
				~tOSCAdrr.sendMsg('noteLabel', '-4');
			});
			},
			'/nt-4'
		);

		~note5.free;
		~note5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -5".postln;
				~transKick.source=(-5);~transSnr.source=(-5);~transHat.source=(-5);
				~transBass.source=(-5);~transKeys.source=(-5);~transSamp.source=(-5);
				~tOSCAdrr.sendMsg('noteLabel', '-5');
			});
			},
			'/nt-5'
		);

		~note6.free;
		~note6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -6".postln;
				~transKick.source=(-6);~transSnr.source=(-6);~transHat.source=(-6);
				~transBass.source=(-6);~transKeys.source=(-6);~transSamp.source=(-6);
				~tOSCAdrr.sendMsg('noteLabel', '-6');
			});
			},
			'/nt-6'
		);

		~note7.free;
		~note7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -7".postln;
				~transKick.source=(-7);~transSnr.source=(-7);~transHat.source=(-7);
				~transBass.source=(-7);~transKeys.source=(-7);~transSamp.source=(-7);
				~tOSCAdrr.sendMsg('noteLabel', '-7');
			});
			},
			'/nt-7'
		);

		~note8.free;
		~note8 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -8".postln;
				~transKick.source=(-8);~transSnr.source=(-8);~transHat.source=(-8);
				~transBass.source=(-8);~transKeys.source=(-8);~transSamp.source=(-8);
				~tOSCAdrr.sendMsg('noteLabel', '-8');
			});
			},
			'/nt-8'
		);

		~note9.free;
		~note9 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -9".postln;
				~transKick.source=(-9);~transSnr.source=(-9);~transHat.source=(-9);
				~transBass.source=(-9);~transKeys.source=(-9);~transSamp.source=(-9);
				~tOSCAdrr.sendMsg('noteLabel', '-9');
			});
			},
			'/nt-9'
		);

		~note10.free;
		~note10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -10".postln;
				~transKick.source=(-10);~transSnr.source=(-10);~transHat.source=(-10);
				~transBass.source=(-10);~transKeys.source=(-10);~transSamp.source=(-10);
				~tOSCAdrr.sendMsg('noteLabel', '-10');
			});
			},
			'/nt-10'
		);

		~note11.free;
		~note11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -11".postln;
				~transKick.source=(-11);~transSnr.source=(-11);~transHat.source=(-11);
				~transBass.source=(-11);~transKeys.source=(-11);~transSamp.source=(-11);
				~tOSCAdrr.sendMsg('noteLabel', '-11');
			});
			},
			'/nt-11'
		);

		~note12.free;
		~note12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -12".postln;
				~transKick.source=(-12);~transSnr.source=(-12);~transHat.source=(-12);
				~transBass.source=(-12);~transKeys.source=(-12);~transSamp.source=(-12);
				~tOSCAdrr.sendMsg('noteLabel', '-12');
			});
			},
			'/nt-12'
		);

		~note13.free;
		~note13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -13".postln;
				~transKick.source=(-13);~transSnr.source=(-13);~transHat.source=(-13);
				~transBass.source=(-13);~transKeys.source=(-13);~transSamp.source=(-13);
				~tOSCAdrr.sendMsg('noteLabel', '-13');
			});
			},
			'/nt-13'
		);

		~note14.free;
		~note14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Root NOTE -14".postln;
				~transKick.source=(-14);~transSnr.source=(-14);~transHat.source=(-14);
				~transBass.source=(-14);~transKeys.source=(-14);~transSamp.source=(-14);
				~tOSCAdrr.sendMsg('noteLabel', '-14');
			});
			},
			'/nt-14'
		);



	}

	*oct {

		//----Kick-------
		~octKickMulBut.free;
		~octKickMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulKick = ~octMulKick+1;
				~tOSCAdrr.sendMsg('octKickLabel', ~octMulKick);

			});

			},
			'/octKickMul'
		);

		~octKickZeroBut.free;
		~octKickZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulKick = 0;
				~tOSCAdrr.sendMsg('octKickLabel', ~octMulKick);

			});

			},
			'/octKickZero'
		);

		~octKickDivBut.free;
		~octKickDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulKick = ~octMulKick-1;
				~tOSCAdrr.sendMsg('octKickLabel', ~octMulKick);

			});

			},
			'/octKickDiv'
		);

		//----Snr-------
		~octSnrMulBut.free;
		~octSnrMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSnr = ~octMulSnr+1;
				~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

			});

			},
			'/octSnrMul'
		);

		~octSnrZeroBut.free;
		~octSnrZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSnr = 0;
				~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

			});

			},
			'/octSnrZero'
		);

		~octSnrDivBut.free;
		~octSnrDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSnr = ~octMulSnr-1;
				~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

			});

			},
			'/octSnrDiv'
		);

		//----Hat-------
		~octHatMulBut.free;
		~octHatMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulHat = ~octMulHat+1;
				~tOSCAdrr.sendMsg('octHatLabel', ~octMulHat);

			});

			},
			'/octHatMul'
		);

		~octHatZeroBut.free;
		~octHatZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulHat = 0;
				~tOSCAdrr.sendMsg('octHatLabel', ~octMulHat);

			});

			},
			'/octHatZero'
		);

		~octHatDivBut.free;
		~octHatDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulHat = ~octMulHat-1;
				~tOSCAdrr.sendMsg('octHatLabel', ~octMulHat);

			});

			},
			'/octHatDiv'
		);

		//----Keys-------
		~octKeysMulBut.free;
		~octKeysMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulKeys = ~octMulKeys+1;
				~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);

			});

			},
			'/octKeysMul'
		);

		~octKeysZeroBut.free;
		~octKeysZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulKeys = 0;
				~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);

			});

			},
			'/octKeysZero'
		);

		~octKeysDivBut.free;
		~octKeysDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulKeys = ~octMulKeys-1;
				~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);

			});

			},
			'/octKeysDiv'
		);

		//----Bass-------
		~octBassMulBut.free;
		~octBassMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulBass = ~octMulBass+1;
				~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);

			});

			},
			'/octBassMul'
		);

		~octBassZeroBut.free;
		~octBassZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulBass = 0;
				~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);

			});

			},
			'/octBassZero'
		);

		~octBassDivBut.free;
		~octBassDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulBass = ~octMulBass-1;
				~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);

			});

			},
			'/octBassDiv'
		);

		//----Samp-------
		~octSampMulBut.free;
		~octSampMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSamp = ~octMulSamp+1;
				~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);

			});

			},
			'/octSampMul'
		);

		~octSampZeroBut.free;
		~octSampZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSamp = 0;
				~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);

			});

			},
			'/octSampZero'
		);

		~octSampDivBut.free;
		~octSampDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSamp = ~octMulSamp-1;
				~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);

			});

			},
			'/octSampDiv'
		);


	}

	*trans {

		//----Kick-------
		~transKickMulBut.free;
		~transKickMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trKick = ~trKick+1;
				~tOSCAdrr.sendMsg('transKickLabel', ~trKick);

			});

			},
			'/transKickMul'
		);

		~transKickZeroBut.free;
		~transKickZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trKick = 0;
				~tOSCAdrr.sendMsg('transKickLabel', ~trKick);

			});

			},
			'/transKickZero'
		);

		~transKickDivBut.free;
		~transKickDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trKick = ~trKick-1;
				~tOSCAdrr.sendMsg('transKickLabel', ~trKick);

			});

			},
			'/transKickDiv'
		);

		//----Snr-------
		~transSnrMulBut.free;
		~transSnrMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trSnr = ~trSnr+1;
				~tOSCAdrr.sendMsg('transSnrLabel', ~trSnr);

			});

			},
			'/transSnrMul'
		);

		~transSnrZeroBut.free;
		~transSnrZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trSnr = 0;
				~tOSCAdrr.sendMsg('transSnrLabel', ~trSnr);

			});

			},
			'/transSnrZero'
		);

		~transSnrDivBut.free;
		~transSnrDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trSnr = ~trSnr-1;
				~tOSCAdrr.sendMsg('transSnrLabel', ~trSnr);

			});

			},
			'/transSnrDiv'
		);

		//----Hat-------
		~transHatMulBut.free;
		~transHatMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trHat = ~trHat+1;
				~tOSCAdrr.sendMsg('transHatLabel', ~trHat);

			});

			},
			'/transHatMul'
		);

		~transHatZeroBut.free;
		~transHatZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trHat = 0;
				~tOSCAdrr.sendMsg('transHatLabel', ~trHat);

			});

			},
			'/transHatZero'
		);

		~transHatDivBut.free;
		~transHatDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trHat = ~trHat-1;
				~tOSCAdrr.sendMsg('transHatLabel', ~trHat);

			});

			},
			'/transHatDiv'
		);

		//----Keys-------
		~transKeysMulBut.free;
		~transKeysMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trKeys = ~trKeys+1;
				~tOSCAdrr.sendMsg('transKeysLabel', ~trKeys);

			});

			},
			'/transKeysMul'
		);

		~transKeysZeroBut.free;
		~transKeysZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trKeys = 0;
				~tOSCAdrr.sendMsg('transKeysLabel', ~trKeys);

			});

			},
			'/transKeysZero'
		);

		~transKeysDivBut.free;
		~transKeysDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trKeys = ~trKeys-1;
				~tOSCAdrr.sendMsg('transKeysLabel', ~trKeys);

			});

			},
			'/transKeysDiv'
		);

		//----Bass-------
		~transBassMulBut.free;
		~transBassMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trBass = ~trBass+1;
				~tOSCAdrr.sendMsg('transBassLabel', ~trBass);

			});

			},
			'/transBassMul'
		);

		~transBassZeroBut.free;
		~transBassZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trBass = 0;
				~tOSCAdrr.sendMsg('transBassLabel', ~trBass);

			});

			},
			'/transBassZero'
		);

		~transBassDivBut.free;
		~transBassDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trBass = ~trBass-1;
				~tOSCAdrr.sendMsg('transBassLabel', ~trBass);

			});

			},
			'/transBassDiv'
		);

		//----Samp-------
		~transSampMulBut.free;
		~transSampMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trSamp = ~trSamp+1;
				~tOSCAdrr.sendMsg('transSampLabel', ~trSamp);

			});

			},
			'/transSampMul'
		);

		~transSampZeroBut.free;
		~transSampZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trSamp = 0;
				~tOSCAdrr.sendMsg('transSampLabel', ~trSamp);

			});

			},
			'/transSampZero'
		);

		~transSampDivBut.free;
		~transSampDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~trSamp = ~trSamp-1;
				~tOSCAdrr.sendMsg('transSampLabel', ~trSamp);

			});

			},
			'/transSampDiv'
		);


	}

	*freeAll {



	}

}