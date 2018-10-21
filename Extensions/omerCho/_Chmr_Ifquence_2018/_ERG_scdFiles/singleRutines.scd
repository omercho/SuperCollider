~tmp1=135;
~scaleMain= Scale.hicaz;
//IFProject.setTempo(~tmp1); ~scl2 = ~scaleMain; ~scl1 = ~scaleMain;
~mainSet_00.fork(quant:0);
~ifPlay.stop;
~ifPlay={|tm=4|

	//~nt1Keys.source   =  Pseq([~nt+0, ~nt+3, ~nt+2, ~nt+4, ~nt+24 , ~nt+14], inf);
	//~dur1Keys.source  =  Pseq([1]*1, inf);
	//~amp1Keys.source  =  Pseq([0.9], inf);
	//~sus1Samp.source  =  Pseq([0.2], inf);
	//1
	inf.do{
		8.do {


			~transKeys=(-0);~transSamp=(0); ~transBass=(0);
			IFKeys([1].choose);
			IFSamp([1].choose);
			IFBass([1].choose);
			IFKick([1].choose);
			IFSnr([1].choose);
			IFHat([2].choose);
			~dur.next.wait;
		};
		//0.1.wait;
		4.do {
			~transKeys=(5); ~transSamp=(5); ~transBass=(5);
			IFKeys([1].choose);
			IFBass([1].choose);
			IFSamp([1].choose);
			IFKick([1].choose);
			IFSnr([1].choose);
			IFHat([2].choose);
			~dur.next.wait;
		};
		//0.1.wait;
		2.do {
			~transKeys=(7);~transSamp=(3); ~transBass=(4);
			IFBass([1].choose);
			IFKeys([1].choose);
			IFSamp([1].choose);
			IFKick([1].choose);
			IFSnr([1].choose);
			IFHat([2].choose);
			1.wait;
		};
		//0.1.wait;
		1.do {
			~transKeys=(8);~transSamp=(0); ~transBass=(0);
			IFKeys([2].choose);
			IFBass([2].choose);
			IFSamp([4].choose);
			IFKick([2].choose);
			IFSnr([3].choose);
			IFHat([4].choose);
			1.wait;
		};
		1.do {
			~transKeys=(12);~transSamp=(2); ~transBass=(2);
			IFKeys([1].choose);
			IFBass([1].choose);
			IFSamp([4].choose);
			IFKick([1].choose);
			IFSnr([2].choose);
			IFHat([3].choose);
			1.wait;
		};
	};
	//2
	1.do{
		32.do {
			~transKeys=(-2); ~transSamp=(12); ~transBass=(-1);
			IFKeys([4].choose);
			IFSamp([1].choose);
			IFBass([2].choose);
			IFKick([2].choose);
			IFSnr([1].choose);
			IFHat([4].choose);
			1.wait;
		};

	}
}.fork;




