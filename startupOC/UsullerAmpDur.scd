/*

Usuller

*/

currentEnvironment use: {

	//2
	
	~nimSofyanAmp = Pseq([0.8, 0.4], 1);
	~nimSofyanDur = Pseq([1, 1]);
	
	
	//3
	
	~semaiAmp = Pseq([0.8, 0.5, 0.15], 1);
	~semaiDur = Pseq([1, 1, 1], 1);
	
	//4
	
	~sofyanAmp = Pseq([0.8, 0.6, 0.3], 1);
	~sofyanDur = Pseq([2, 1, 1], 1);
	
	//5
	
	~turkAksagiAmp = Pseq([0.6, 0.3, 0.2, 0.4, 0.4, 0.3, 0.2 ], 1);
	~turkAksagiDur = Pseq([1, 1/2, 1/2, 1, 1, 1/2, 1/2], 1);
	
	//6
	
	~yurukSemaiAmp = Pseq([0.8, 0.6, 0.4, 0.2, 0.4 ], 1);
	~yurukSemaiDur = Pseq([1, 1, 1, 1, 2], 1);
	
	~senginSemaiAmp = ~yurukSemaiAmp;
	~senginSemaiDur = Pseq([1, 1, 1, 1, 2], 1);
	
	~agirSenginSemaiAmp = ~yurukSemaiAmp;
	~agirSenginSemaiDur = Pseq([1, 1, 1, 1, 2], 1);
	
	//8
	
	~duyekDur =  Pseq([1, 1/2, 1/2, 	1, 1], 1);
	~duyekKudDur =  Pseq([1, 1/2, 1/2, 1, 1, 	1/2, 1/2, 1, 1, 1/2, 1/2], 1);

	
	//16 zamanli
	
	~cifteDuyekDur = Pseq([
				Pseq([2, 4, 2], 1),
				Pseq([2, 2, 2, 1, 1], 1)
	
	], 1); //8

	//20 zmanli
	
	~fahteDur = Pseq([
				~sofyanDur,//3
				~yurukSemaiDur,//5
				~yurukSemaiDur, //5
				~sofyanDur //3
	
	], 1); //16


	//24 zamanli
	~cemberDur = Pseq([
				~sofyanDur, //3
				~sofyanDur, //3
				~yurukSemaiDur, //5
				~yurukSemaiDur, //5
				~sofyanDur //3
	
	], 1); //19

	//28 zamanli
	~devriKebirDur = Pseq([
				~senginSemaiDur, //5
				~sofyanDur, //3
				~sofyanDur, //3
				~senginSemaiDur,//5
				~sofyanDur, //3
				~sofyanDur //3
	], 1); //22

	//32 zamanli
	~berefsanDur = Pseq([
				~yurukSemaiDur, //5
				~yurukSemaiDur, //5
				~sofyanDur, //3
				~sofyanDur, //3
				~sofyanDur, //3
				~sofyanDur, //3
				~sofyanDur //3
	], 1); //25

	//120 zamanli
	~zencir1Dur = Pseq([
				~cifteDuyekDur, //8
				~fahteDur, //16
				~cemberDur, //19
				~devriKebirDur, //22
				~berefsanDur //25
	], 1); //90


};




/*
Birinci cesit Zencir Usulu
	cifteDuyek(16/4) + fahte(20/4) + cember(24/4) + devr-iKebir(28/4) + berefsan(32/4)

vurus --> 8+16+19+22+25 = 90
8+16 = 24
24+19 = 43
43+22 = 65
65+25 = 90
*/

