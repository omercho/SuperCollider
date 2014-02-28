
~ifPlay.stop;
~ifPlay={|tm=4|

	~nt1Samp.source   =  Pseq([~nt-12, ~nt+0, ~nt+12, ~nt-11], inf);
	~dur1Samp.source  =  Pseq([1, 1, 1, 1]*2, inf);
	~amp1Samp.source  =  Pseq([0.9, 0.7, 0.9, 0.8], inf);
	~sus1Samp.source  =  Pseq([0.2, 0.4, 0.2, 0.9], inf);
	inf.do{
		12.do {

			~transSamp=(0);
			IFSamp([4].choose);
			IFKick([2,1].choose);
			IFHat([4,2,2].choose);
			1.wait;
		};
		0.5.wait;
		4.do {
			~transSamp=(5);
			IFSamp([4,2].choose);
			IFKick([2,1].choose);
			IFHat([4,2,2].choose);
			1.wait;
		};
		0.5.wait;
		3.do {
			~transSamp=(7);
			IFSamp([4].choose);
			IFKick([2,1].choose);
			IFHat([4,2,2].choose);
			1.wait;
		};
		0.5.wait;
		1.do {
			~transSamp=(13);
			IFSamp([4].choose);
			IFKick([2,1].choose);
			IFHat([4,2,2].choose);
			1.wait;
		};
	};
}.fork;

