/*
~loopMain_1.stop;


~loopMain_1.play;
*/
~scaleMain= Scale.minor;
//~scaleMain= Scale.major;
//~scaleMain= Scale.cargah;
//~scaleMain= Scale.neva;
//~scaleMain= Scale.hicaz;
//~scaleMain= Scale.gong;
//~scaleMain= Scale.minorPentatonic;
//~scaleMain= Scale.egyptian;
//~scaleMain= Scale.augmented2;
//~scaleMain= Scale.partch_o1;

~loopMain_1.stop; Ableton.killAll;
~loopMain_1.reset;
~mainSet_00.fork(quant:0);
~loopMain_1 = Task({
	~countMain=0;~part0=0; ~part1=0; ~part2=0; ~part3=0;~part4=0;~part5=0;~part6=0;~part7=0; ~part8=0; ~part9=0;
	inf.do({|i, count = 1|
		{
			~countMain = ~countMain + 1;
			~countMain.switch(
				0, {/* PART 0*/ },
				1, {
					~mainSet_00.fork;
					~part0Reset.fork;

				},
				2, {},
				3, {},
				4, {},
				5, {},
				6, {},
				7, {},
				8, {},
				9, {
					~countMain = 0;

					~part0=~part0+1;
					~part0.switch(
						1, {},
						4, {
							1.do{

								~countMain = 0;

							};
						},
					);

				},
				10, {  /* PART 1*/ },
				11, {
					~mainSet_01.fork; ~part1Reset.fork;

				},
				12, {},
				13, {},
				14, {},
				15, {},
				16, {},
				17, {},
				18, {},
				19, {
					~countMain=10;

					~part1=~part1+1;
					~part1.switch(
						1, {},
						2, {
							1.do{
								~mTrans=(0);
								~durMul*2.wait;
								~mTrans=(0);
								~durMul*2.wait;
								~mTrans=(0);

								~countMain = 0;

							};
						},
					);
				},

				20, { /* PART 2*/ },
				21, {
					~mainSet_02.fork; ~part2Reset.fork;

			    },
				22, {},
				23, {},
				24, {},
				25, {},
				26, {},
				27, {},
				28, {},
				29, {
					~countMain=20;

					~part2=~part2+1;
					~part2.switch(
						2, {~countMain = 30;},
					);
			    },

				30, {  /* PART 3*/ },
				31, {~part3Reset.fork;
					~mainSet_03.fork;

				},
				32, {},
				33, {},
				34, {},
				35, {},
				36, {},
				37, {},
			    38, {},
			    39, {
					~countMain=30;

					~part3=~part3+1;
					~part3.switch(
						2, {~countMain = 0;},
					);

				},


				40, { /* PART 4*/ },
				41, {~part4Reset.fork;
					~mainSet_04.fork;

				},
				42, {},
				43, {},
				44, {},
				45, {},
				46, {},
				47, {},
				48, {},
				49, {
					~countMain=40;

					~part5=~part5+1;
					~part5.switch(
						2, {~countMain = 0;},
					);

				},

			    50, { /* PART 5*/ },
				51, {~part5Reset.fork;},
				52, {},
				53, {},
				54, {},
				55, {},
				56, {},
				57, {},
			    58, {},
				59, {
					~countMain=50; ~mainSet_03.fork;

					~part5=~part5+1;
					~part5.switch(
						2, {~countMain = 0;},
					);
				},

				("           -------------Main Beat:-"+~countMain).postln;
			);

		}.fork;


		IFKick([1].choose);
		IFSnr(1);
		IFHat([2,4,3,1,2,1,2].choose);
		IFBass([1].choose);
		IFSamp(2);
		//IFOrta.pat_1;
		//IFFlat.pat_1;
		IFRes1.pat_1;

		~dur.next.wait;
	});
});

~loopMain_1.play(quant:0);
/*
IFKick(1);
~legKick=0.9;
~stretchKick=2;
*/