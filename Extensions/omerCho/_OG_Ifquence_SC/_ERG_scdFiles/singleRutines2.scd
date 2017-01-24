{
inf.do{
		12.do {


			~transKeys=(0); ~transBass=(0);
			1.wait;
		};
		//0.1.wait;
		4.do {
			~transKeys=(5); ~transBass=(1);

			1.wait;
		};
		//0.1.wait;
		2.do {
			~transKeys=(6); ~transBass=(2);

			1.wait;
		};
		//0.1.wait;
		1.do {
			~transKeys=(10); ~transBass=(-1);

			1.wait;
		};
		1.do {
			~transKey=(3); ~transBass=(-9);

			1.wait;
		};
	};
}.fork;