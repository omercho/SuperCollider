~track1={

	~track1Main.fork;

	~togMain.free;
	~togMain = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"IF Main PLAY".postln;
			~mainSet_00.fork(quant:0);
			~ifPlay={|tm=4|

				inf.do{
					1.do {

						//~md1Clock.play;
						IFKick_SC(~tmMulKickP.next*~tmKickP.next);
						IFSnr_SC(~tmMulSnrP.next*~tmSnrP.next);
						IFHat_SC(~tmMulHatP.next*~tmHatP.next);

						IFKeys_SC(~tmKeysP.next);
						IFBass_SC(~tmBassP.next);
						IFSamp_SC(~tmSampP.next);

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

	//---------------- DUR Buttons ---------------//

	~dur1But.free;
	~dur1But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"------------dur1".postln;
			~tOSCAdrr.sendMsg('durLabel', '1');

			~dur.source = Pseq([1], inf)*~durMulP;

		});
		},
		'/dur1'
	);

	~dur2But.free;
	~dur2But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"------------dur2".postln;
			~tOSCAdrr.sendMsg('durLabel', '2');
			~dur.source = Pseq([
				Pseq([1], 7),
				Pseq([0.5,0.5], 1)
			], inf)*~durMulP;

		});
		},
		'/dur2'
	);

	~dur3But.free;
	~dur3But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"------------dur3".postln;
			~tOSCAdrr.sendMsg('durLabel', '3');
			~dur.source = Pseq([
				Pseq([1], 3),
				Pseq([0.5], 2),
				Pseq([1], 3),
				Pseq([0.5], 2)
			], inf)*~durMulP;

		});
		},
		'/dur3'
	);

	~dur4But.free;
	~dur4But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {
			"------------dur4".postln;
			~tOSCAdrr.sendMsg('durLabel', '4');
			~dur.source = Pseq([
				Pseq([1], 2),
				Pseq([0.5], 4),
				Pseq([1.25], 1),
				Pseq([0.75], 2)
			], inf)*~durMulP;


		});
		},
		'/dur4'
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
				Pxrand([0.25,0.5,0.5], 1),
				Pxrand([0.25,0.75], 1),
				Pxrand([0.5,0.25,0.25], 1),
				Pxrand([0.5,0.75], 2)
			], inf)*~durMulP;

		});
		},
		'/durRand1'
	);

	//durMul

	~durMul1_4But.free;
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

	~durMul1_2But.free;
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

	~durMul1But.free;
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



//PRESETS

	~setAllBut.free;
	~setAllBut = OSCFunc({
		arg msg;
		if ( msg[1]==1, {

			IFSCProjectGlobals.preSetAll;

		});
		},
		'/setAll'
	);

	~set1But.free;
	~set1But = OSCFunc({
		arg msg;
		if ( msg[1]==1, {

			IFSCProjectGlobals.preSet_1;

		});
		},
		'/set1'
	);

};

/*
~track1.fork;
*/