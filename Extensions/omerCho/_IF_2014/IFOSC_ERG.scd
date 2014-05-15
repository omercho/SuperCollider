/*
PostAllOSC.on;
PostAllOSC.off;

~tOSCAdrr = NetAddr.new("192.168.1.2", 57130); // create the NetAddr
*/
(

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
					IFKick(~tmKickP.next);
					IFSnr(~tmSnrP.next);
					IFHat(~tmHatP.next);

					IFKeys( ~tmKeysP.next );
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
			Pseq([0.5,0.5], 2)
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

)