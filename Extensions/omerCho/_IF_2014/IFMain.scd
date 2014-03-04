~tmp1=125;
//~scaleMain= Scale.gong;
//////                                     - 0 -
~mainSet_00 = { IFProject.setTempo(~tmp1); ~scl2 = ~scaleMain; ~scl1 = ~scaleMain;
//global
	~nt=[0].choose;
// MAIN
	~durMul = 1.0;
	~dur    = Pseq([1, 1, 1, 1]*~durMul, inf).asStream;

// DRUM
//CH -0- [ KICK ]------------------------------- [Kick] - Ch -0- //
	~nt1Kick.source   =  Pseq([~nt+0, ~nt+0, ~nt+0, ~nt+0], inf);
	~dur1Kick.source  =  Pseq([1, 1, 1, 1], inf);
	~amp1Kick.source  =  Pseq([0.9, 1.0], inf);
	~sus1Kick.source  =  Pseq([1.2, 0.5, 0.2, 0.1], inf);

//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr.source  =  Pslide([~nt+0, ~nt+6, ~nt-10, ~nt+22, ~nt-4], inf,   3,1,0);
	~dur1Snr.source  =  Pseq([1, 1, 1, 1], inf);
	~amp1Snr.source =  Pseq([0.5, 0.9, 0.0, 0.9, 0.0, 0.9, 0.4, 0.9], inf);
	~sus1Snr.source =  Pseq([1.22, 1, 0.66, 0.22], inf,3,1,1);


//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat.source   = Pslide([~nt+0, ~nt+16, ~nt-10, ~nt+22, ~nt-4], inf,   3,1,0);
	~dur1Hat.source  = Pseq([1, 1, 1, 1], inf);
	~amp1Hat.source  = Pseq([0.9, 0.9, 0.3, 0.9, 0.9, 0.5, 0.9, 0.9], inf);
	~sus1Hat.source  = Pslide([0.8, 0.6, 0.4, 0.9, 0.9], inf,           3,1,0);


// Keys     //CH -4- [Keys]
	~nt1Keys.source   =  Pseq([~nt+5, ~nt+4, ~nt+2, ~nt+3, ~nt+1 , ~nt+7], inf);
	~dur1Keys.source  =  Pseq([1, 1, 1, 1]*1, inf);
	~amp1Keys.source  =  Pseq([1.0, 0.9, 0.0, 0.8], inf);
	~sus1Keys.source  =  Pseq([1.1, 0.1, 0.1, 0.1], inf);

// BASS     //CH -4- [Bass]
	~nt1Bass.source   =  Pseq([~nt+0, ~nt+4, ~nt+2, ~nt+3, ~nt+1 , ~nt+7], inf);
	~dur1Bass.source  =  Pseq([1, 1, 1, 1]*2, inf);
	~amp1Bass.source  =  Pseq([0.9, 0.8, 0.9, 0.8], inf);
	~sus1Bass.source  =  Pseq([1.1, 0.1, 0.1, 0.1], inf);


//SAMPLER   //CH -5- [SAMP]
	~nt1Samp.source   =  Pseq([~nt+0, ~nt+13, ~nt-12], inf);
	~dur1Samp.source  =  Pseq([1, 1, 1, 1]*1, inf);
	~amp1Samp.source  =  Pseq([0.9, 0.0, 0.5, 0.0], inf);
	~sus1Samp.source  =  Pseq([0.2, 0.1, 0.1, 0.1], inf);
//SampFX
	~nt1SampRes = Pslide([~nt,~nt,~nt,~nt, ~nt]+12,           inf, 3,1,0).asStream;
	~nt2SampRes = Pslide([~nt,~nt,~nt,~nt, ~nt]+12,           inf, 3,1,1).asStream;
	~nt3SampRes = Pslide([~nt,~nt,~nt,~nt, ~nt]+5,           inf, 3,1,2).asStream;




//Resonator Send
	~nt1Res1 = Pslide([~nt]+12, inf, 3,1,0).asStream;
	~nt2Res1 = Pslide([~nt]+12, inf, 3,1,1).asStream;
	~nt3Res1 = Pslide([~nt]+12, inf, 3,1,2).asStream;


};
~mainSet_00.fork(quant:0);
//////                                      - 0 -
//////                                      - 1 -

~mainSet_01 = { IFProject.setTempo(~tmp1); ~scl2 = ~scaleMain;

//global
	~nt=[0].choose;

// MAIN
	~durMul = 1.0;
	~dur    = Pseq([1, 1, 1, 1, 1, 1, 1, 1, 1]*~durMul, inf).asStream;

// DRUM
//CH -0- [ KICK ]------------------------------- [Kick] - Ch -0- //
	~nt1Kick.source   =  Pseq([~nt+0, ~nt+7, ~nt+14, ~nt+9, ~nt+3], inf);
	~dur1Kick.source  =  Pseq([1, 1, 1/2, 1, 1/2], inf);
	~amp1Kick.source  =  Pseq([0.9, 0.0, 0.9, 0.0, 0.9, 0.2, 0.9, 0.1], inf);
	~sus1Kick.source  =  Pseq([1.2, 0.5, 0.2, 0.1], inf);

//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr.source  =  Pseq([~nt], inf);
	~dur1Snr.source  =  Pseq([1/2, 1, 1/2, 1, 1], inf);
	~amp1Snr.source =  Pseq([0.5, 0.9, 0.0, 0.9, 0.0, 0.9, 0.4, 0.9], inf);
	~sus1Snr.source =  Pseq([0.22], inf, 3,1,1);


//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat.source   = Pslide([~nt, ~nt+16, ~nt-1, ~nt+18, ~nt-4], inf,   3,1,0);
	~dur1Kick.source  =  Pseq([1, 1/2, 1, 1/2], inf);
	~amp1Hat.source  = Pslide([0.8, 0.6, 0.4, 0.9, 0.9], inf,           3,1,0);
	~sus1Hat.source  = Pslide([0.8, 0.6, 0.4, 0.9, 0.9], inf,           3,1,0);

// BASS     //CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+5,~nt+7,~nt+14,~nt-2], inf, 3,1,0).asStream;
	~dur1Bass.source  =  Pseq([1, 1, 1, 1/2, 1/2], inf);
	~amp1Bass.source  =  Pseq([0.9, 0.0, 0.9, 0.8], inf);
	~sus1Bass.source  =  Pseq([0.2, 0.5, 0.2, 0.1], inf);


//SAMPLER   //CH -3- [SAMP]
	~nt1Samp = Pslide([~nt,~nt-1,~nt,~nt+1, ~nt-2],           inf, 3,1,1).asStream;
	~amp1Samp =  Pslide([0.9, 0.0, 0.7, 0, 0],                       inf, 3,1,1).asStream;
	~sus1Samp = Pslide([1.5, 2.5, 2.5, 1.8, 2, 2.5, 2.25, 1.8 ],     inf, 3,1,1).asStream;
	~nt2Samp = Pslide([~nt+5,~nt+1,~nt,~nt+1, ~nt-1],           inf, 3,1,4).asStream;
	~amp2Samp =  Pslide([0.8, 0.0, 0.0, 0, 0],                       inf, 3,1,4).asStream;
	~sus2Samp = Pslide([2.5, 2.5, 1.5, 1.8, 2, 2.5, 2.25, 1.8 ]*0.4, inf, 3,1,4).asStream;
	~nt3Samp = Pslide([~nt+7,~nt+1,~nt,~nt+4, ~nt-1],           inf, 3,1,2).asStream;
	~amp3Samp =  Pslide([0.8, 0.0, 0.0, 0.4, 0],                       inf, 3,1,2).asStream;
	~sus3Samp = Pslide([1.5, 2.5, 1.5, 1.8, 2 ]*0.3,                 inf, 3,1,2).asStream;


//SampFX
	~nt1SampRes = Pslide([~nt+2,~nt+5,~nt+7,~nt, ~nt-2]+13,           inf, 3,1,0).asStream;
	~nt2SampRes = Pslide([~nt,~nt,~nt,~nt, ~nt]+13,           inf, 3,1,1).asStream;
	~nt3SampRes = Pslide([~nt,~nt+1,~nt+2,~nt+3, ~nt+5]+13,           inf, 3,1,2).asStream;


// OrtaDLE    //CH -5- [Orta]
	~nt1Orta = Pslide([~nt,~nt+1,~nt-3,~nt+1, ~nt-1],    inf, 3,1,0).asStream;
	~amp1Orta =  Pslide([0.9, 0.0, 0, 0.8, 0.7],                            inf, 3,1,0).asStream;
	~sus1Orta = Pslide([2.5, 0.5, 1.5, 2.1, 2],                         inf, 3,1,0).asStream;
	~nt2Orta = Pslide([~nt-4,~nt+1,~nt,~nt+1, ~nt-1],  inf, 3,1,1).asStream;
	~amp2Orta =  Pslide([0.0, 0.2, 0, 0.6, 0],                            inf, 3,1,1).asStream;
	~sus2Orta = Pslide([1.5, 0.5, 1.5, 2.8, 1.2],                       inf, 3,1,1).asStream;
	~nt3Orta = Pslide([~nt, ~nt+1,~nt,~nt+3, ~nt],       inf, 3,1,3).asStream;
	~amp3Orta =  Pslide([0.0, 0.3, 0, 0.8, 0],                            inf, 3,1,3).asStream;
	~sus3Orta = Pslide([1.5, 2.5, 1.5, 1.8, 2],                         inf, 3,1,3).asStream;


// Flutter    //CH -6- [Flat]

	~nt1Flat = Pslide([~nt,~nt+7,~nt-7,~nt+1, ~nt],    inf, 3,1,0).asStream;
	~amp1Flat =  Pslide([0.9, 0.6, 0, 0.8, 0],                            inf, 3,1,0).asStream;
	~sus1Flat = Pslide([1.5, 0.5, 1.5, 1.1, 2]*0.3,                         inf, 3,1,0).asStream;
	~nt2Flat = Pslide([~nt+2,~nt+3,~nt+4,~nt+3, ~nt+2],  inf, 3,1,1).asStream;
	~amp2Flat =  Pslide([0.9, 0.6, 0, 0.8, 0],                            inf, 3,1,1).asStream;
	~sus2Flat = Pslide([1.5, 0.5, 1.5, 0.8, 1.2]*0.3,                       inf, 3,1,1).asStream;
	~nt3Flat = Pslide([~nt, ~nt+1,~nt,~nt+3, ~nt],       inf, 3,1,3).asStream;
	~amp3Flat =  Pslide([0.9, 0.6, 0, 0.8, 0],                            inf, 3,1,3).asStream;
	~sus3Flat = Pslide([1.5, 2.5, 1.5, 1.8, 2]*0.3,                         inf, 3,1,3).asStream;

//SampFX
	~nt1Res1 = Pslide([~nt,~nt+1,~nt,~nt+3, ~nt-1],           inf, 3,1,0).asStream;
	~nt2Res1 = Pslide([~nt,~nt+1,~nt,~nt+3, ~nt-1]*2,         inf, 3,1,1).asStream;
	~nt3Res1 = Pslide([~nt,~nt+1,~nt,~nt+3, ~nt-1],           inf, 3,1,2).asStream;

};
//////                                      - 1 -

//////                                      - 2 -

~mainSet_02 = { IFProject.setTempo(~tmp1); ~scl2 = ~scaleMain;

//global
	~nt=[0].choose; ~nt=~nt+13; ~nt=~nt+13; ~nt=~nt-13;

// MAIN
	~durMul = 1.0;
	~dur    = Pseq([1, 1, 1, 1, 1, 1, 1, 1, 1]*~durMul, inf).asStream;

// DRUM
//CH -0- [ KICK ]------------------------------- [Kick] - Ch -0- //
	~nt1Kick   =  Pseq([0], inf).asStream;
	~amp1Kick  =  Pseq([1, 0, 0, 0.9, 0.0, 0, 0.9, 0, 0], inf).asStream;
	~amp2Kick  =  Pseq([0.9, 0.0, 0, 0.9, 0.0, 0, 0.9, 0.8, 0], inf).asStream;

//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr  = Pseq([0, 3, 5, 1, 2, 3, 5, 1, 4], inf).asStream;
	~amp1Snr =  Pseq([0.9, 0, 0.9, 0, 0, 0.7, 0, 0.9, 0.8], inf).asStream;
	~nt1Snr  = Pslide([0, 1, 2, 3, 4, 5], inf, 3,1,0).asStream;
	~amp2Snr =  Pslide([0, 0.9, 0, 0, 0.7], inf, 3,1,0).asStream;
	~nt3Snr  = Pslide([6, 7, 2, 3, 4, 5], inf, 3,1,1).asStream;
	~amp3Snr =  Pslide([0, 0, 0.9, 0, 0.7], inf, 3,1,1).asStream;

//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat     = Pslide([0, 3, 6, 5, 6],         inf,3,1,0).asStream;
	~amp1Hat   =  Pslide([0.8, 0.9, 0, 0.5, 0.2], inf,3,1,0).asStream;
	~nt2Hat     = Pslide([1, 4, 2, 0, 1],         inf,3,1,1).asStream;
	~amp2Hat   =  Pslide([0.8, 0.9, 0, 0.5, 0.2], inf,3,1,1).asStream;
	~nt3Hat     = Pslide([1, 4, 2, 0, 1],         inf,3,1,3).asStream;
	~amp3Hat   =  Pslide([0.8, 0.9, 0, 0.5, 0.2], inf,3,1,3).asStream;

//SAMPLER   //CH -3- [SAMP]
	~nt1Samp = Pslide([~nt-4,~nt+1,~nt,~nt+1, ~nt-1]/2, inf, 3,1,0).asStream;
	~amp1Samp =  Pslide([0.4, 0.6, 0.5, 0, 0],                           inf, 3,1,0).asStream;
	~sus1Samp = Pslide([1.5, 2.5, 1.5, 1.8, 2, 2.5, 2.25, 1.8 ],       inf, 3,1,0).asStream;
	~nt2Samp = Pslide([~nt-4,~nt+1,~nt,~nt+1, ~nt-1],   inf, 3,1,1).asStream;
	~amp2Samp =  Pslide([0.4, 0.6, 0.5, 0, 0],                           inf, 3,1,1).asStream;
	~sus2Samp = Pslide([1.5, 2.5, 1.5, 1.8, 2, 2.5, 2.25, 1.8 ]*0.8,   inf, 3,1,1).asStream;
	~nt3Samp = Pslide([~nt-4,~nt+1,~nt,~nt+1, ~nt-1],   inf, 3,1,2).asStream;
	~amp3Samp =  Pslide([0.4, 0.6, 0.5, 0, 0],                           inf, 3,1,2).asStream;
	~sus3Samp = Pslide([1.5, 2.5, 1.5, 1.8, 2, 2.5, 2.25, 1.8 ]*1.8,   inf, 3,1,2).asStream;


	~resNt1 = Pslide([~nt+3, ~nt,~nt-3,~nt+5, ~nt-2], inf,3,1,0).asStream;
	~corpNt1 = Pseq([~nt+1,~nt+2,~nt+3,~nt].degreeToKey(~scl2)/2, inf).asStream;


// BASS     //CH -4- [Bass]

	~nt1Bass = Pslide([~nt, ~nt+1,~nt,~nt+3, ~nt],      inf, 3,1,0).asStream;
	~amp1Bass =  Pslide([0.9, 0.6, 0, 0.8, 0],                           inf, 3,1,0).asStream;
	~sus1Bass = Pslide([1.5, 2.5, 1.5, 1.8, 2],                        inf, 3,1,0).asStream;
	~nt2Bass = Pslide([~nt, ~nt+3,~nt,~nt+5, ~nt],      inf, 3,1,1).asStream;
	~amp2Bass =  Pslide([0.9, 0.6, 0, 0.8, 0],                           inf, 3,1,1).asStream;
	~sus2Bass = Pslide([1.5, 2.5, 1.5, 1.8, 2],                        inf, 3,1,1).asStream;
	~nt3Bass = Pslide([~nt, ~nt+1,~nt,~nt+3, ~nt],      inf, 3,1,3).asStream;
	~amp3Bass =  Pslide([0.9, 0.6, 0, 0.8, 0],                           inf, 3,1,3).asStream;
	~sus3Bass = Pslide([1.5, 2.5, 1.5, 1.8, 2],                        inf, 3,1,3).asStream;

// OrtaDLE    //CH -5- [Orta]
	~nt1Orta = Pslide([~nt,~nt+1,~nt-3,~nt+1, ~nt-1],    inf, 3,1,0).asStream;
	~amp1Orta =  Pslide([0.9, 0.6, 0, 0.8, 0],                            inf, 3,1,0).asStream;
	~sus1Orta = Pslide([1.5, 0.5, 1.5, 1.1, 2],                         inf, 3,1,0).asStream;
	~nt2Orta = Pslide([~nt+2,~nt+3,~nt+4,~nt+3, ~nt+2],  inf, 3,1,1).asStream;
	~amp2Orta =  Pslide([0.9, 0.6, 0, 0.8, 0],                            inf, 3,1,1).asStream;
	~sus2Orta = Pslide([1.5, 0.5, 1.5, 0.8, 1.2],                       inf, 3,1,1).asStream;
	~nt3Orta = Pslide([~nt, ~nt+1,~nt,~nt+3, ~nt],       inf, 3,1,3).asStream;
	~amp3Orta =  Pslide([0.9, 0.6, 0, 0.8, 0],                            inf, 3,1,3).asStream;
	~sus3Orta = Pslide([1.5, 2.5, 1.5, 1.8, 2],                         inf, 3,1,3).asStream;


// Flutter    //CH -6- [Flat]

	~nt1Flat = Pslide([~nt,~nt+1,~nt-3,~nt+1, ~nt-1],    inf, 3,1,0).asStream;
	~amp1Flat =  Pslide([0.9, 0.6, 0, 0.8, 0],                            inf, 3,1,0).asStream;
	~sus1Flat = Pslide([1.5, 0.5, 1.5, 1.1, 2],                         inf, 3,1,0).asStream;
	~nt2Flat = Pslide([~nt+2,~nt+3,~nt+4,~nt+3, ~nt+2],  inf, 3,1,1).asStream;
	~amp2Flat =  Pslide([0.9, 0.6, 0, 0.8, 0],                            inf, 3,1,1).asStream;
	~sus2Flat = Pslide([1.5, 0.5, 1.5, 0.8, 1.2],                       inf, 3,1,1).asStream;
	~nt3Flat = Pslide([~nt, ~nt+1,~nt,~nt+3, ~nt],       inf, 3,1,3).asStream;
	~amp3Flat =  Pslide([0.9, 0.6, 0, 0.8, 0],                            inf, 3,1,3).asStream;
	~sus3Flat = Pslide([1.5, 2.5, 1.5, 1.8, 2],                         inf, 3,1,3).asStream;


};
 //////                                      - 2 -

 //////                                      - 3 -

~mainSet_03 = { IFProject.setTempo(~tmp1); ~scl2 = ~scaleMain;

//global
	~nt=[0].choose; ~nt=~nt+13; ~nt=~nt+13; ~nt=~nt-13;

// MAIN
	~durMul = 1.0;
	~dur    = Pseq([1, 1, 1, 1, 1, 1, 1, 1, 1]*~durMul, inf).asStream;

// DRUM
//CH -0- [ KICK ]------------------------------- [Kick] - Ch -0- //
	~nt1Kick   =  Pseq([0], inf).asStream;
	~amp1Kick  =  Pseq([1, 0, 0, 0.9, 0.7, 0, 0.9, 0, 0], inf).asStream;
	~amp2Kick  =  Pseq([0.9, 0.5, 0, 0.9, 0.7, 0, 0.9, 0.8, 0], inf).asStream;

//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr  = Pseq([0, 3, 5, 1, 2, 3, 5, 1, 4], inf).asStream;
	~amp1Snr =  Pseq([0.9, 0, 0.9, 0, 0, 0.7, 0, 0.9, 0.8], inf).asStream;
	~nt2Snr  = Pslide([0, 1, 2, 3, 4, 5], inf, 3,1,0).asStream;
	~amp2Snr =  Pslide([0, 0.9, 0, 0, 0.7], inf, 3,1,0).asStream;
	~nt3Snr  = Pslide([6, 7, 2, 3, 4, 5], inf, 3,1,1).asStream;
	~amp3Snr =  Pslide([0, 0, 0.9, 0, 0.7], inf, 3,1,1).asStream;

//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat     = Pslide([0, 3, 6, 5, 6],         inf,3,1,0).asStream;
	~amp1Hat   =  Pslide([0.8, 0.9, 0, 0.5, 0.2], inf,3,1,0).asStream;
	~nt2Hat     = Pslide([1, 4, 2, 0, 1],         inf,3,1,1).asStream;
	~amp2Hat   =  Pslide([0.8, 0.9, 0, 0.5, 0.2], inf,3,1,1).asStream;
	~nt3Hat     = Pslide([1, 4, 2, 0, 1],         inf,3,1,3).asStream;
	~amp3Hat   =  Pslide([0.8, 0.9, 0, 0.5, 0.2], inf,3,1,3).asStream;

//SAMPLER   //CH -3- [SAMP]
	~nt1Samp = Pslide([~nt-4,~nt+1,~nt,~nt+1, ~nt-1]/2, inf, 3,1,0).asStream;
	~amp1Samp =  Pslide([0.4, 0.6, 0.5, 0, 1],                           inf, 3,1,0).asStream;
	~sus1Samp = Pslide([1.5, 2.5, 1.5, 1.8, 2, 2.5, 2.25, 1.8 ],       inf, 3,1,0).asStream;
	~nt2Samp = Pslide([~nt-4,~nt+1,~nt,~nt+1, ~nt-1],   inf, 3,1,1).asStream;
	~amp2Samp =  Pslide([0.4, 0.6, 0.5, 0, 0],                           inf, 3,1,1).asStream;
	~sus2Samp = Pslide([1.5, 2.5, 1.5, 1.8, 2, 2.5, 2.25, 1.8 ]*0.8,   inf, 3,1,4).asStream;
	~nt3Samp = Pslide([~nt-4,~nt+1,~nt,~nt+1, ~nt-1],   inf, 3,1,2).asStream;
	~amp3Samp =  Pslide([0.4, 0.6, 0.5, 0, 0.8],                           inf, 3,1,2).asStream;
	~sus3Samp = Pslide([1.5, 2.5, 1.5, 1.8, 2, 2.5, 2.25, 1.8 ]*1.8,   inf, 3,1,3).asStream;


	~resNt1 = Pslide([~nt+3, ~nt,~nt-3,~nt+5, ~nt-2], inf,3,1,0).asStream;
	~corpNt1 = Pseq([~nt+1,~nt+2,~nt+3,~nt].degreeToKey(~scl2)/2, inf).asStream;


// BASS     //CH -4- [Bass]

	~nt1Bass = Pslide([~nt, ~nt+1,~nt,~nt+3, ~nt],      inf, 3,1,0).asStream;
	~amp1Bass =  Pslide([0.9, 0.6, 0, 0.8, 0],                           inf, 3,1,0).asStream;
	~sus1Bass = Pslide([1.5, 2.5, 1.5, 1.8, 2],                        inf, 3,1,0).asStream;
	~nt2Bass = Pslide([~nt, ~nt+3,~nt,~nt+5, ~nt],      inf, 3,1,1).asStream;
	~amp2Bass =  Pslide([0.9, 0.6, 0, 0.8, 0],                           inf, 3,1,1).asStream;
	~sus2Bass = Pslide([1.5, 2.5, 1.5, 1.8, 2],                        inf, 3,1,1).asStream;
	~nt3Bass = Pslide([~nt, ~nt+1,~nt,~nt+3, ~nt],      inf, 3,1,3).asStream;
	~amp3Bass =  Pslide([0.9, 0.6, 0, 0.8, 0],                           inf, 3,1,3).asStream;
	~sus3Bass = Pslide([1.5, 2.5, 1.5, 1.8, 2],                        inf, 3,1,3).asStream;

// Orta    //CH -5- [Orta]
	~nt1Orta = Pslide([~nt,~nt+1,~nt-3,~nt+1, ~nt-1],    inf, 3,1,0).asStream;
	~amp1Orta =  Pslide([0.9, 0.9, 0.4, 0.6, 0],                            inf, 3,1,0).asStream;
	~sus1Orta = Pslide([1.5, 0.5, 1.5, 1.1, 2]*1.2,                         inf, 3,1,0).asStream;
	~nt2Orta = Pslide([~nt+2,~nt+3,~nt+4,~nt+3, ~nt+2],  inf, 3,1,1).asStream;
	~amp2Orta =  Pslide([0.9, 0.6, 0, 0.8, 0],                            inf, 3,1,1).asStream;
	~sus2Orta = Pslide([1.5, 0.5, 1.5, 0.8, 1.2],                       inf, 3,1,1).asStream;
	~nt3Orta = Pslide([~nt, ~nt+1,~nt,~nt+3, ~nt],       inf, 3,1,3).asStream;
	~amp3Orta =  Pslide([0.9, 0.6, 0, 0.8, 0.4],                            inf, 3,1,3).asStream;
	~sus3Orta = Pslide([1.5, 2.5, 1.5, 1.8, 2],                         inf, 3,1,3).asStream;


// Flat    //CH -6- [Flat]

	~nt1Flat = Pslide([~nt,~nt+1,~nt-3,~nt+1, ~nt-1],    inf, 3,1,0).asStream;
	~amp1Flat =  Pslide([0.9, 0.6, 0, 0.8, 0],                            inf, 3,1,0).asStream;
	~sus1Flat = Pslide([1.5, 3.5, 1.5, 1.1, 2],                         inf, 3,1,0).asStream;
	~nt2Flat = Pslide([~nt+2,~nt+3,~nt+4,~nt+3, ~nt+2],  inf, 3,1,1).asStream;
	~amp2Flat =  Pslide([0.9, 0.6, 0, 0.8, 0],                            inf, 3,1,1).asStream;
	~sus2Flat = Pslide([1.5, 0.5, 1.5, 2.8, 1.2],                       inf, 3,1,1).asStream;
	~nt3Flat = Pslide([~nt, ~nt+1,~nt,~nt+3, ~nt],       inf, 3,1,3).asStream;
	~amp3Flat =  Pslide([0.9, 0.6, 0.9, 0.8, 0],                            inf, 3,1,3).asStream;
	~sus3Flat = Pslide([1.5, 2.5, 1.5, 1.8, 2],                         inf, 3,1,3).asStream;



};
//////                                      - 3 -
