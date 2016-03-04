
IFMainTrack1 {
*load {
		"IF Main Track 1 loaded".postln;
		~scl1= Scale.chromatic;~scl2= Scale.phrygian;
		~tOSCAdrr.sendMsg('scaleLabel', 'Phrygian');

		~tmp1=90;
		~tOSCAdrr.sendMsg('tempoLabel', ~tmp1);
		~tOSCAdrr.sendMsg('tempoFader', ~tmp1);
		~nt=(0);

		~dur = PatternProxy( Pseq([1], inf));
		~durP= Pseq([~dur], inf).asStream;

		~durMul = PatternProxy( Pseq([1], inf));
		~durMulP= Pseq([~durMul], inf).asStream;



//////                                     - 0 -
~mainSet_00 = {

//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([0, ~nt+0, ~nt+3, ~nt+0], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.9, 0], inf);
	~sus1Kick.source  =  Pseq([0.9, 0.1, 0.7, 0.1]*0.8, inf);
	~tmKick.source    =  Pseq([1], inf);
    ~dur1Kick.source =  Pseq([1/2], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt-2, ~nt+3], inf);
	~amp1Snr.source =  Pseq([0.0, 0.5, 0.9, 0], inf);
	~sus1Snr.source =  Pseq([0.2, 0.2, 0.2, 0.3]*0.8, inf);
	~tmSnr.source   =  Pseq([1,1,2,1], inf);
	~dur1Snr.source =  Pseq([1/2], inf);
//CH -2- [ HAT ]
	~nt1Hat.source   = Pseq([Pseq([~nt+0,~nt+3],2)], inf);
	~amp1Hat.source  = Pseq([1,0.8,0.8,0.7], inf);
	~sus1Hat.source  = Pseq([0.6, 0.1, 0.03, 0.1], inf);
	~tmHat.source    = Pseq([1], inf);
	~dur1Hat.source  = Pseq([1/2], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 4,1,0);
	~amp1Bass.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.0, 0.0],         inf, 4,1,0);
	~sus1Bass.source  =  Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*1.9,    inf, 4,1,0);
	~tmBass.source    =  Pseq([1,1,1,1], inf);
	~dur1Bass.source  =  Pseq([1/2], inf);
	~lfo1Bass.source  =  Pseq([30,90,70,98, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([10,30,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 4,1,0);
	~amp1Keys.source  =  Pslide([0.0, 0.0, 0.8, 0.7, 0.0, 0.5],         inf, 4,1,0);
	~sus1Keys.source  =  Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*1.9,    inf, 4,1,0);
	~tmKeys.source    =  Pseq([1], inf);
	~dur1Keys.source  =  Pseq([1/2], inf);
	~lfoRtKeys.source =  Pseq([20,40,80], inf);
	~lfoCtKeys.source =  Pseq([10,20,50,80,40], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pseq([~nt+0,~nt+1,~nt+1,~nt+7,~nt+1,~nt+0,~nt+7,~nt+0],inf);
	~amp1Samp.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.0, 0.0]*0.9,   inf, 4,3,0);
	~sus1Samp.source  =  Pslide([0.8, 0.3, 0.06, 0.7, 0.2, 0.2 ],     inf, 4,2,0);
	~tmSamp.source    =  Pseq([1,2,1,2], inf);
	~dur1Samp.source  =  Pseq([1/2,1,1], inf);
	~lfo1Samp.source =  Pseq([90,1,7,9, 80,10,7,1], inf);
	~lfo2Samp.source =  Pseq([60,20,80,10], inf);
//Res1
	~nt1Res1.source   =   Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~dur1Res1.source  =  Pseq([1]*1, inf);
	~tmRes1.source  =  Pseq([1], inf);

};
//////                                      - 0 -
//////                                      - brdg1 -
~mainBridge_01 = {

//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([0, ~nt+0, ~nt+3, ~nt+0], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.9, 0], inf);
	~sus1Kick.source  =  Pseq([0.9, 0.1, 0.7, 0.1], inf);
	~tmKick.source    =  Pseq([1], inf);

	~nt1VKick.source   =  Pseq([~vKick], inf);
	~amp1VKick.source  =  Pseq([1,0,1,0], inf);
	~tmVKick.source    =  Pseq([1], inf);
	~levVKick.source    =  Pseq([1], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt-2, ~nt+3], inf);
	~amp1Snr.source =  Pseq([0.0, 0, 0.9, 0], inf);
	~sus1Snr.source =  Pseq([0.2, 0.2, 0.2, 0.3]*0.8, inf);
	~tmSnr.source   =  Pseq([1,1,3,1], inf);
	~dur1Snr.source =  Pseq([1], inf);

	~nt1VSnr.source   =  Pseq([~vSnr], inf);
	~amp1VSnr.source  =  Pseq([0,0,0,1,0,0,1,0], inf);
	~tmVSnr.source    =  Pseq([1,1,1,1,1,1], inf);
	~levVSnr.source    =  Pseq([1, 0.9, 0.6, 0.4], inf);

//CH -2- [ HAT ]
	~nt1Hat.source   = Pseq([Pseq([~nt+0,~nt+3,~nt+5,~nt+9],2)], inf);
	~amp1Hat.source  = Pseq([1,0.8,0.8,0.7], inf);
	~sus1Hat.source  = Pseq([0.6, 0.1, 0.03, 0.1], inf);
	~tmHat.source    = Pseq([4,1,2,1], inf);
	~dur1Hat.source  = Pseq([1], inf);

	~nt1VHat.source   = Pseq([~vHatO,Pseq([~vHatC],3),~vHatO,Pseq([~vHatC],4)],inf);
	~amp1VHat.source  = Pseq([1, 0, 1, 0, 1], inf);
	~tmVHat.source    = Pseq([2,1,2,1,2,1], inf);
	~levVHatC.source  = Pseq([ 1], inf);
	~levVHatO.source  = Pseq([ 1], inf);
	~decVHatC.source  = Pseq([ 0.1, 0.2, 0.4], inf);
	~decVHatO.source  = Pseq([ 0.2, 0.4, 0.6, 0.5], inf);

//CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Bass.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.0, 0.8],         inf, 3,3,0);
	~sus1Bass.source  =  Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*1.9,        inf, 3,1,0);
	~tmBass.source    =  Pseq([2,1,2,1], inf);
	~dur1Bass.source  =  Pseq([1, 2, 1], inf);
	~lfo1Bass.source  =  Pseq([30,90,70,98, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([0,0,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Keys.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.0, 0.8],         inf, 3,2,0);
	~sus1Keys.source  =  Pslide([1.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*1.4,        inf, 3,1,0);
	~tmKeys.source    =  Pseq([2,1,2,1], inf);
	~dur1Keys.source  =  Pseq([2], inf);
	~lfoRtKeys.source =  Pseq([20,70,0,90, 106], inf);
	~lfoCtKeys.source =  Pseq([10,30,50,90,120], inf);
	~vcfCtKeys.source =  Pseq([50,30,40,80,120], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pslide([~nt+0,~nt+1,~nt+1,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Samp.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.0, 0.0]*0.9,         inf, 3,3,0);
	~sus1Samp.source  =  Pslide([1.8, 0.03, 0.06, 0.7, 0.2, 0.2 ],        inf, 3,2,0);
	~tmSamp.source    =  Pseq([1,2,1,2], inf);
	~dur1Samp.source  =  Pseq([2,1,1], inf);
	~lfo1Samp.source  =  Pseq([90,1,7,9, 80,10,7,1], inf);
	~lfo2Samp.source  =  Pseq([6,10,80,0.1], inf);
//Res1
	~nt1Res1.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~dur1Res1.source  =  Pseq([2,1,1], inf);
	~tmRes1.source    =  Pseq([1,2,1,2], inf);


};
//////                                      - brdg1 -

//////                                      - 1 -
~mainSet_01 = {

//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([~nt+0, ~nt+0, ~nt+4,~nt+8, ~nt+0,~nt+3, ~nt+4, ~nt+5 ], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.9, 0], inf);
	~sus1Kick.source  =  Pseq([0.4, 0.1, 0.2, 0.1], inf);
	~tmKick.source    =  Pseq([1], inf);
    ~dur1Kick.source =  Pseq([1], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt+6, ~nt+3, ~nt+6, ], inf);
	~amp1Snr.source =  Pseq([0.0, 0.9, 0.0, 0.7], inf);
	~sus1Snr.source =  Pseq([0.2, 0.6, 0.2, 0.3]*0.8, inf);
	~tmSnr.source   =  Pseq([1,1,1,1], inf);
	~dur1Snr.source =  Pseq([1/2], inf);
//CH -2- [ HAT ]
	~nt1Hat.source   = Pseq([Pseq([~nt+0,~nt+3],2)], inf);
	~amp1Hat.source  = Pseq([1,0.8,0.8,0.7], inf);
	~sus1Hat.source  = Pseq([0.6, 0.1, 0.03, 0.1], inf);
	~tmHat.source    = Pseq([1,1,1,1,1,2], inf);
	~dur1Hat.source  = Pseq([1/1], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Bass.source  =  Pslide([0.9, 0.0, 0.3, 0.7, 0.0, 0.0],         inf, 3,1,0);
	~sus1Bass.source  =  Pslide([0.5, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9,    inf, 3,1,0);
	~tmBass.source    =  Pseq([2,1,2,1], inf);
	~dur1Bass.source  =  Pseq([1/2], inf);
	~lfo1Bass.source  =  Pseq([30,90,70,98, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([0,0,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Keys.source  =  Pseq([0.9,0,0,0,0.5,0,0,0],inf);
	~sus1Keys.source  =  Pseq([1.2, 0.3, 0.8, 1.7, 0.2, 0.1, 0.9, 2.5 ]*0.8);
	~tmKeys.source    =  Pseq([1], inf);
	~dur1Keys.source  =  Pseq([1/2], inf);
	~lfoRtKeys.source =  Pseq([20,40,80], inf);
	~lfoCtKeys.source =  Pseq([10,20,50,80,40], inf);
//IFKeys(~tmMulKeysP.next*~tmKeysP.next);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pseq([~nt+0,~nt+1,~nt+7,~nt+1,~nt+0,~nt+7],inf);
	~amp1Samp.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.0, 0.0]*0.9,inf, 3,3,0);
	~sus1Samp.source  =  Pslide([1.8, 0.03, 0.06, 0.7, 0.2, 0.2 ], inf, 3,2,0);
	~tmSamp.source    =  Pseq([1], inf);
	~dur1Samp.source  =  Pseq([1], inf);
	~lfo1Samp.source =  Pseq([90,1,7,9, 80,10,7,1], inf);
	~lfo2Samp.source =  Pseq([6,10,80,0.1], inf);
//Res1
	~nt1Res1.source   =   Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~dur1Res1.source  =  Pseq([1]*1, inf);
	~tmRes1.source  =  Pseq([1], inf);

};
//////                                      - 1 -

//////                                      - 2 -
~mainSet_02 = {

//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([0, ~nt+0, ~nt+3, ~nt+0], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.9, 0], inf);
	~sus1Kick.source  =  Pseq([0.9, 0.1, 0.7, 0.1], inf);
	~tmKick.source    =  Pseq([2], inf);
    ~dur1Kick.source =  Pseq([1/2], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt-2, ~nt+3], inf);
	~amp1Snr.source =  Pseq([0.6, 0, 0.9, 0], inf);
	~sus1Snr.source =  Pseq([0.2, 0.2, 0.2, 0.3]*0.8, inf);
	~tmSnr.source   =  Pseq([4,1,2,1], inf);
	~dur1Snr.source =  Pseq([1/1], inf);
//CH -2- [ HAT ]
	~nt1Hat.source   = Pseq([Pseq([~nt+0,~nt+3],2)], inf);
	~amp1Hat.source  = Pseq([1,0.8,0.8,0.7], inf);
	~sus1Hat.source  = Pseq([0.6, 0.1, 0.03, 0.1], inf);
	~tmHat.source    = Pseq([1,3], inf);
	~dur1Hat.source  = Pseq([1/1], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Bass.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.0, 0.8],         inf, 3,3,0);
	~sus1Bass.source  =  Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*1.9,    inf, 3,1,0);
	~tmBass.source    =  Pseq([2,1,2,1], inf);
	~dur1Bass.source  =  Pseq([1, 2, 1], inf);
	~lfo1Bass.source  =  Pseq([30,90,70,98, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([0,0,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Keys.source  =  Pseq([0.9],inf);
	~sus1Keys.source  =  Pseq([1.2, 0.3, 0.8, 1.7, 0.2, 0.1, 0.9, 2.5 ]*1.0);
	~tmKeys.source    =  Pseq([2], inf);
	~dur1Keys.source  =  Pseq([1], inf);
	~lfoRtKeys.source =  Pseq([20,40,80], inf);
	~lfoCtKeys.source =  Pseq([10,20,50,80,40], inf);
//IFKeys(~tmMulKeysP.next*~tmKeysP.next);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pseq([~nt+0,~nt+1,~nt+1,~nt+0,~nt+1,~nt+0],inf);
	~amp1Samp.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.0, 0.0]*0.9,         inf, 3,3,0);
	~sus1Samp.source  =  Pslide([1.8, 0.03, 0.06, 0.7, 0.2, 0.2 ],        inf, 3,2,0);
	~tmSamp.source    =  Pseq([1,2,1,2], inf);
	~dur1Samp.source  =  Pseq([2,1,1], inf);
	~lfo1Samp.source =  Pseq([90,1,7,9, 80,10,7,1], inf);
	~lfo2Samp.source =  Pseq([6,10,80,0.1], inf);
//Res1
	~nt1Res1.source   =   Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~dur1Res1.source  =  Pseq([1]*1, inf);
	~tmRes1.source  =  Pseq([1], inf);

};
//////                                      - 2 -

//////                                      - 3 -
~mainSet_03 = {
// DRUM
//CH -0- [ KICK ]------------------------------- [Kick] - Ch -0- //
	~nt1Kick.source   =  Pseq([~nt+0], inf);
	~dur1Kick.source  =  Pseq([1], inf);
	~amp1Kick.source  =  Pseq([0.9], inf);
	~sus1Kick.source  =  Pseq([0.1], inf);
	~tmKick.source    =  Pseq([2,1,2,1], inf);
//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr.source  =  Pseq([~nt+0,~nt+1,~nt+2, ~nt-1,~nt+0, ~nt+2,~nt+1,~nt+7], inf);
	~dur1Snr.source =  Pseq([1], inf);
	~amp1Snr.source =  Pseq([0.0, 0.9, 0.0, 0.9, 0.0, 0.9, 0.0], inf);
	~sus1Snr.source =  Pseq([0.2, 0.2, 1.8, 0.7], inf);
	~tmSnr.source   =  Pseq([1,1,1,1], inf);
//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat.source   = Pseq([~nt+0,~nt+1,~nt+2, ~nt-2,~nt+0, ~nt+4,~nt+6,~nt+0], inf);
	~dur1Hat.source  = Pseq([1], inf);
	~amp1Hat.source  = Pseq([0.9,0.8, 0.6,0.9, 0.7,0.7, 0.8], inf);
	~sus1Hat.source  = Pseq([2.1, 0.2, 0.3, 0.2]*1.2, inf);
	~tmHat.source    = Pseq([1,2,4,1,2,2], inf);

// Keys     //CH -4- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+5,~nt+6, ~nt+8],           inf, 3,1,0);
	~dur1Keys.source  =  Pseq([1], inf);
	~amp1Keys.source  =  Pxrand([0.4, 0, 0.4, 0.6, 0.8, 0.9], inf);
	~sus1Keys.source  =  Pseq([0.1], inf);
	~tmKeys.source    =  Pxrand([2,1,2,1], inf);
// BASS     //CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1,~nt+5,~nt+0, ~nt+8],           inf, 3,1,0);
	~dur1Bass.source  =  Pseq([1], inf);
	~amp1Bass.source  =  Pxrand([0, 0.8, 0, 0.7, 0, 0.5, 0, 0.9], inf);
	~sus1Bass.source  =  Pseq([3.1, 0.2, 0.4, 0.2], inf);
	~tmBass.source    =  Pxrand([1,2,2,1], inf);
//SAMPLER   //CH -5- [SAMP]
	~nt1Samp.source   =   Pslide([~nt+7,~nt+0,~nt+5,~nt+0, ~nt+1],           inf, 3,1,0).asStream;
	~dur1Samp.source  =  Pseq([1, 1, 1, 1]*1, inf);
	~amp1Samp.source  =  Pseq([0.7, 0, 0.6, 0.5], inf);
	~sus1Samp.source  =  Pseq([0.6, 0.2, 0.2, 0.2], inf);
	~tmSamp.source    =  Pxrand([2,1,2,1], inf);
};
//////                                      - 3 -

//////                                      - 4 -
~mainSet_04 = {
// DRUM
//CH -0- [ KICK ]------------------------------- [Kick] - Ch -0- //
	~nt1Kick.source   =  Pseq([~nt+0], inf);
	~dur1Kick.source  =  Pseq([1], inf);
	~amp1Kick.source  =  Pseq([0.9], inf);
	~sus1Kick.source  =  Pseq([0.1], inf);
	~tmKick.source    =  Pseq([2,1,1,1], inf);
//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr.source  =  Pseq([~nt+0,~nt+8,~nt+2, ~nt-8,~nt+9, ~nt+4,~nt+6,~nt+7], inf);
	~dur1Snr.source =  Pseq([1], inf);
	~amp1Snr.source =  Pseq([0.0, 0.8, 0.0, 0.9, 0.0, 0.7, 0.8], inf);
	~sus1Snr.source =  Pseq([0.2, 0.2, 0.8, 0.7], inf);
	~tmSnr.source   =  Pseq([1,1,2,1], inf);
//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat.source   = Pseq([~nt+0,~nt+8,~nt+2, ~nt-8,~nt+9, ~nt+4,~nt+6,~nt+9], inf);
	~dur1Hat.source  = Pseq([1], inf);
	~amp1Hat.source  = Pseq([0.0,0.8, 0.6,0.9, 0.7,0.7, 0.8], inf);
	~sus1Hat.source  = Pseq([0.1, 0.2, 0.3, 0.2]*1.2, inf);
	~tmHat.source    = Pseq([1,2,4,1,2,2], inf);

// Keys     //CH -4- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+5,~nt+6, ~nt+8],           inf, 3,1,0).asStream;
	~dur1Keys.source  =  Pseq([1], inf);
	~amp1Keys.source  =  Pxrand([0.4, 0, 0.4, 0.6, 0.8, 0.9], inf);
	~sus1Keys.source  =  Pseq([0.1], inf);
	~tmKeys.source    =  Pxrand([2,1,2,1], inf);
// BASS     //CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1,~nt+5,~nt+6, ~nt+8],           inf, 3,1,0).asStream;
	~dur1Bass.source  =  Pseq([1], inf);
	~amp1Bass.source  =  Pxrand([0, 0.8, 0, 0.7, 0, 0.5, 0, 0.9], inf);
	~sus1Bass.source  =  Pseq([0.1, 0.2, 0.4, 0.2], inf);
	~tmBass.source    =  Pxrand([1,1,2,1], inf);
//SAMPLER   //CH -5- [SAMP]
	~nt1Samp.source   =   Pslide([~nt+14,~nt+1,~nt+5,~nt+6, ~nt+4],           inf, 3,1,0).asStream;
	~dur1Samp.source  =  Pseq([1, 1, 1, 1]*1, inf);
	~amp1Samp.source  =  Pseq([0.7, 0, 0.6, 0.5], inf);
	~sus1Samp.source  =  Pseq([0.6, 0.2, 0.2, 0.2], inf);
	~tmSamp.source    =  Pxrand([2,1,2,1], inf);
};
//////                                      - 4 -

//////                                      - 5 -
~mainSet_05 = {
// DRUM
//CH -0- [ KICK ]------------------------------- [Kick] - Ch -0- //
	~nt1Kick.source   =  Pseq([~nt+0], inf);
	~dur1Kick.source  =  Pseq([1], inf);
	~amp1Kick.source  =  Pseq([0.9], inf);
	~sus1Kick.source  =  Pseq([0.1], inf);
	~tmKick.source    =  Pseq([2,1,1,1], inf);
//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr.source  =  Pseq([~nt+0,~nt+8,~nt+2, ~nt-8,~nt+9, ~nt+4,~nt+6,~nt+7], inf);
	~dur1Snr.source =  Pseq([1], inf);
	~amp1Snr.source =  Pseq([0.0, 0.8, 0.0, 0.9, 0.0, 0.7, 0.8], inf);
	~sus1Snr.source =  Pseq([0.2, 0.2, 0.8, 0.7], inf);
	~tmSnr.source   =  Pseq([1,1,2,1], inf);
//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat.source   = Pseq([~nt+0,~nt+8,~nt+2, ~nt-8,~nt+9, ~nt+4,~nt+6,~nt+9], inf);
	~dur1Hat.source  = Pseq([1], inf);
	~amp1Hat.source  = Pseq([0.0,0.8, 0.6,0.9, 0.7,0.7, 0.8], inf);
	~sus1Hat.source  = Pseq([0.1, 0.2, 0.3, 0.2]*1.2, inf);
	~tmHat.source    = Pseq([1,2,4,1,2,2], inf);

// Keys     //CH -4- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+5,~nt+6, ~nt+8],           inf, 3,1,0).asStream;
	~dur1Keys.source  =  Pseq([1], inf);
	~amp1Keys.source  =  Pxrand([0.4, 0, 0.4, 0.6, 0.8, 0.9], inf);
	~sus1Keys.source  =  Pseq([0.1], inf);
	~tmKeys.source    =  Pxrand([2,1,2,1], inf);
// BASS     //CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1,~nt+5,~nt+6, ~nt+8],           inf, 3,1,0).asStream;
	~dur1Bass.source  =  Pseq([1], inf);
	~amp1Bass.source  =  Pxrand([0, 0.8, 0, 0.7, 0, 0.5, 0, 0.9], inf);
	~sus1Bass.source  =  Pseq([0.1, 0.2, 0.4, 0.2], inf);
	~tmBass.source    =  Pxrand([1,1,2,1], inf);
//SAMPLER   //CH -5- [SAMP]
	~nt1Samp.source   =   Pslide([~nt+14,~nt+1,~nt+5,~nt+6, ~nt+4],           inf, 3,1,0).asStream;
	~dur1Samp.source  =  Pseq([1, 1, 1, 1]*1, inf);
	~amp1Samp.source  =  Pseq([0.7, 0, 0.6, 0.5], inf);
	~sus1Samp.source  =  Pseq([0.6, 0.2, 0.2, 0.2], inf);
	~tmSamp.source    =  Pxrand([2,1,2,1], inf);
};
//////                                      - 5 -

//////                                      - 6 -
~mainSet_06 = {
//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([0, ~nt+11, ~nt+3, ~nt+10], inf);
	~amp1Kick.source  =  Pseq([0.9], inf);
	~sus1Kick.source  =  Pseq([0.4], inf);
	~tmKick.source    =  Pseq([1], inf);
//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr.source  =  Pseq([Pseq([~nt+3],4),Pseq([~nt+0, ~nt+7],8)], inf);
	~amp1Snr.source =  Pseq([ 0.0, 0.0, 0.0, 0.0, 0.9], inf);
	~sus1Snr.source =  Pseq([0.2, 0.2, 0.2, 0.2]*0.8, inf);
	~tmSnr.source   =  Pseq([2], inf);
	~lfo1Snr.source =  Pseq([30,90,70,98, 0,110,60,20], inf);
	~lfo2Snr.source =  Pseq([0,0,110,50], inf);
//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat.source   = Pseq([Pseq([~nt+3, ~nt-7],1),Pseq([~nt+0, ~nt+7],1)], inf);
	~amp1Hat.source  = Pseq([ 0.8, 0.0, 0.7,0.0], inf);
	~sus1Hat.source  = Pseq([0.1], inf);
	~tmHat.source    = Pseq([2], inf);
	~lfo1Hat.source =  Pseq([0,0,0,98, 0,110,60,20], inf);
	~lfo2Hat.source =  Pseq([0,0,110,50], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pseq([Pseq([~nt+0],12),Pseq([~nt+0, ~nt+7, ~nt+4, ~nt+14],1)], inf);
	~amp1Bass.source  =  Pseq([Pseq([0.9],8),Pseq([0.9, 0.4, 0.6, 0.3],1)], inf);
	~sus1Bass.source  =  Pseq([Pseq([0.2, 0.1],8),Pseq([0.3, 0.2],2)], inf);
	~tmBass.source    =  Pseq([2], inf);
	~dur1Bass.source  =  Pseq([1], inf);
	~lfo1Bass.source =  Pseq([30,90,70,98, 0,110,60,20], inf);
	~lfo2Bass.source =  Pseq([0,0,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pseq([Pseq([~nt+0],12),Pseq([~nt+3, ~nt+14, ~nt+8, ~nt+7],1)], inf);
	~amp1Keys.source  =  Pseq([Pseq([0.9, 0.6],8),Pseq([0.9, 0.7],2)], inf);
	~sus1Keys.source  =  Pseq([Pseq([0.2, 0.1],8),Pseq([0.3, 0.2],2)], inf)*2;
	~tmKeys.source    =  Pseq([2], inf);
	~lfoRtKeys.source =  Pseq([0,0,0,90,0], inf);
	~lfoCtKeys.source =  Pseq([0,0,0,0,0], inf);
	~vcfCtKeys.source =  Pseq([30,30,30,30,120], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pseq([Pseq([~nt+0, ~nt-3],8),Pseq([~nt+0, ~nt+7, ~nt+4, ~nt+14],1)], inf);
	~amp1Samp.source  =  Pseq([Pseq([0.9, 0.6],8),Pseq([0.9, 0.7],2)], inf);
	~sus1Samp.source  =  Pslide([0.8, 0.3, 0.6, 0.7, 0.2, 0.2 ],        inf, 3,2,0);
	~tmSamp.source    =  Pseq([1,2,2,2], inf);
	~lfo1Samp.source =  Pseq([90,112,70,98, 80,110,67,120], inf);
	~lfo2Samp.source =  Pseq([60,120,80,100], inf);
};
//////                                      - 6 -

//////                                      - 7 -
~mainSet_07 = {
// DRUM
//CH -0- [ KICK ]------------------------------- [Kick] - Ch -0- //
	~nt1Kick.source   =  Pseq([~nt+0], inf);
	~dur1Kick.source  =  Pseq([1], inf);
	~amp1Kick.source  =  Pseq([0.9], inf);
	~sus1Kick.source  =  Pseq([0.1], inf);
	~tmKick.source    =  Pseq([2,1,1,1], inf);
//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr.source  =  Pseq([~nt+0,~nt+8,~nt+2, ~nt-8,~nt+9, ~nt+4,~nt+6,~nt+7], inf);
	~dur1Snr.source =  Pseq([1], inf);
	~amp1Snr.source =  Pseq([0.0, 0.8, 0.0, 0.9, 0.0, 0.7, 0.8], inf);
	~sus1Snr.source =  Pseq([0.2, 0.2, 0.8, 0.7], inf);
	~tmSnr.source   =  Pseq([1,1,2,1], inf);
//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat.source   = Pseq([~nt+0,~nt+8,~nt+2, ~nt-8,~nt+9, ~nt+4,~nt+6,~nt+9], inf);
	~dur1Hat.source  = Pseq([1], inf);
	~amp1Hat.source  = Pseq([0.0,0.8, 0.6,0.9, 0.7,0.7, 0.8], inf);
	~sus1Hat.source  = Pseq([0.1, 0.2, 0.3, 0.2]*1.2, inf);
	~tmHat.source    = Pseq([1,2,4,1,2,2], inf);

// Keys     //CH -4- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+5,~nt+6, ~nt+8],           inf, 3,1,0).asStream;
	~dur1Keys.source  =  Pseq([1], inf);
	~amp1Keys.source  =  Pxrand([0.4, 0, 0.4, 0.6, 0.8, 0.9], inf);
	~sus1Keys.source  =  Pseq([0.1], inf);
	~tmKeys.source    =  Pxrand([2,1,2,1], inf);
// BASS     //CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1,~nt+5,~nt+6, ~nt+8],           inf, 3,1,0).asStream;
	~dur1Bass.source  =  Pseq([1], inf);
	~amp1Bass.source  =  Pxrand([0, 0.8, 0, 0.7, 0, 0.5, 0, 0.9], inf);
	~sus1Bass.source  =  Pseq([0.1, 0.2, 0.4, 0.2], inf);
	~tmBass.source    =  Pxrand([1,1,2,1], inf);
//SAMPLER   //CH -5- [SAMP]
	~nt1Samp.source   =   Pslide([~nt+14,~nt+1,~nt+5,~nt+6, ~nt+4],           inf, 3,1,0).asStream;
	~dur1Samp.source  =  Pseq([1, 1, 1, 1]*1, inf);
	~amp1Samp.source  =  Pseq([0.7, 0, 0.6, 0.5], inf);
	~sus1Samp.source  =  Pseq([0.6, 0.2, 0.2, 0.2], inf);
	~tmSamp.source    =  Pxrand([2,1,2,1], inf);
};
//////                                      - 7 -


////////---------------------------------- BRIDGES ----------------------------------------/////////


//////                                      - brdg2 -
~mainBridge_02 = {
// DRUM
//CH -0- [ KICK ]------------------------------- [Kick] - Ch -0- //
	~nt1Kick.source   =  Pseq([~nt+0], inf);
	~amp1Kick.source  =  Pseq([0.9,0.7,0.4,0], inf);
	~sus1Kick.source  =  Pseq([0.7], inf);
	~tmKick.source    =  Pseq([1,1,1,1], inf);
//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr.source  =  Pslide([~nt+0,~nt+3,~nt+0, ~nt-1,~nt+8],           inf, 2,1,0);
	~amp1Snr.source =  Pslide([0.7, 0.8, 0.5, 0.6],           inf, 3,1,0);
	~sus1Snr.source =  Pseq([0.2, 0.2, 0.2, 0.2], inf);
	~tmSnr.source   =  Pxrand([2,1,1, 1], inf);
//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat.source   = Pseq([~nt-1,~nt+8], inf);
	~amp1Hat.source  = Pseq([0.9,0.8, 0.6,0.9, 0.7,0.6, 0.8], inf);
	~sus1Hat.source  = Pseq([0.1, 0.2, 0.3, 0.2]*0.9, inf);
	~tmHat.source    = Pxrand([4,2,4,8], inf);

// Keys     //CH -4- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+3,~nt+9],           inf, 2,1,0);
	~dur1Keys.source  =  Pseq([1], inf);
	~amp1Keys.source  =  Pslide([0.7, 0.4, 0.5, 0.6,0.4,0.2,0.1],           inf, 2,4,0);
	~sus1Keys.source  =  Pseq([0.1,0.8,1.2], inf);
	~tmKeys.source    =  Pxrand([2,1,2,1], inf);
// BASS     //CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1, ~nt+7],           inf, 3,1,0);
	~dur1Bass.source  =  Pseq([1], inf);
	~amp1Bass.source  =  Pslide([0.7, 0.4, 0.5, 0.6,0.4,0.2,0.1],           inf, 3,5,0);
	~sus1Bass.source  =  Pseq([0.3, 0.4, 0.2, 0.1], inf);
	~tmBass.source    =  Pxrand([2,1,2], inf);
//SAMPLER   //CH -5- [SAMP]
	~nt1Samp.source   =  Pslide([~nt+0,~nt+13,~nt+3],           inf, 3,1,0);
	~dur1Samp.source  =  Pseq([1, 1, 1, 1]*1, inf);
	~amp1Samp.source  =  Pslide([0.7, 0.4, 0.5, 0.6,0.4,0.2,0.1],           inf, 3,1,0);
	~sus1Samp.source  =  Pseq([0.6, 0.4, 0.5, 0.1], inf);
	~tmSamp.source    =  Pxrand([2,4, 1], inf);


//CH -7- [ BEATS ]
	//CH -0- [ BEATS ]
	//~nt1Beats.source   =  Pseq([~vKick,~vSnr,~vTomL,~vTomH,~vHatCl,~vHatOp,~vClap], inf);
	~nt1VKick.source   =  Pseq([~vKick], inf);
	~amp1VKick.source  =  Pseq([1,0,1,1], inf);
	~tmVKick.source    =  Pseq([1], inf);
	~levVKick.source    =  Pseq([0.9, 0.4, 1,0.5], inf);

	~nt1VSnr.source   =  Pseq([~vSnr], inf);
	~amp1VSnr.source  =  Pseq([1,0,1,0,0,1,0], inf);
	~tmVSnr.source    =  Pseq([1, 1, 1,1,1,1,1,2], inf);
	~levVSnr.source    =  Pseq([1, 0.9, 0.6, 0.4], inf);

	~nt1VTom.source   =  Pxrand([[~vTomL,~vTomH],~vTomH,~vTomL], inf);
	~amp1VTom.source  =  Pseq([1, 0, 1, 1, 0, 0], inf);
	~tmVTom.source    =  Pseq([1,1,2,1,1,2,2,1,2], inf);
	~levVTomL.source  =  Pseq([ 0.3, 0.8, 0.3, 0.2], inf);
	~levVTomH.source  =  Pseq([ 0.8, 0.2, 0.9, 0.5], inf);
	~decVTom.source   =  Pseq([ 0.5, 0.4, 0.6, 0.5], inf);

	~nt1VHat.source   =  Pxrand([[~vHatC,~vHatO],Pseq([~vHatC],5),~vHatO,Pseq([~vHatC],5)],inf);
	~amp1VHat.source  =  Pseq([1, 1, 1, 0, 1], inf);
	~tmVHat.source    =  Pseq([2,2,2,2,1,4,1], inf);
	~levVHatC.source  =  Pseq([ 1], inf);
	~levVHatO.source  =  Pseq([ 1], inf);
	~decVHatC.source   =  Pseq([ 0.1], inf);
	~decVHatO.source   =  Pseq([ 0.2, 0.4, 0.6, 0.5], inf);

	~nt1VPcm.source = Pxrand([
				[~vCrsh,~vCalv,~vClap],
				Pseq([~vCalv,~vAgog],5),
				[~vCalv,~vAgog,~vClap],
				Pseq([~vCalv],5),
				~vCrsh],inf);
	~amp1VPcm.source  =  Pseq([0, 1, 1, 0, 0,1,0], inf);
	~tmVPcm.source    =  Pseq([1,2,1,1,1,2,1], inf);
	~levVClap.source  =  Pseq([ 1,0.6, 0.8, 0.2], inf);
	~spdVClap.source   =  Pseq([ 0.1, 0.9, 0.5], inf);
	~levVCalv.source  =  Pseq([ 1,0.5, 0.3], inf);
	~spdVCalv.source   =  Pseq([ 0.1, 0.9, 0.6, 0.2], inf);
	~levVAgog.source  =  Pseq([ 1,0.5, 0.3], inf);
	~spdVAgog.source   =  Pseq([ 0.1, 0.9, 0.6, 0.2], inf);
	~levVCrsh.source  =  Pseq([ 1,0.5, 0.3], inf);
	~spdVCrsh.source   =  Pseq([ 0.1, 0.9, 0.6, 0.2], inf);


};
//////                                      - brdg2 -
//////                                      - brdg4 -
~mainBridge_04 = {
//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([0, ~nt+14, ~nt+3, ~nt+10], inf);
	~amp1Kick.source  =  Pseq([0.9], inf);
	~sus1Kick.source  =  Pseq([0.4], inf);
	~tmKick.source    =  Pseq([1], inf);
//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr.source  =  Pseq([Pseq([~nt+3],4),Pseq([~nt+0, ~nt+7],8)], inf);
	~amp1Snr.source =  Pseq([ 0.0, 0.0, 0.0, 0.0, 0.9], inf);
	~sus1Snr.source =  Pseq([0.2, 0.2, 0.2, 0.2]*0.8, inf);
	~tmSnr.source   =  Pseq([2], inf);
//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat.source   = Pseq([Pseq([~nt+3, ~nt-7],8),Pseq([~nt+0, ~nt+7],8)], inf);
	~amp1Hat.source  = Pseq([ 0.8, 0.6, 0.0,0.7], inf);
	~sus1Hat.source  = Pseq([0.1], inf);
	~tmHat.source    = Pseq([4], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pseq([Pseq([~nt+0],32),Pseq([~nt+0, ~nt+7, ~nt+4, ~nt+14],1)], inf);
	~amp1Bass.source  =  Pseq([Pseq([0.9],8),Pseq([0.9, 0.4, 0.6, 0.3],1)], inf);
	~sus1Bass.source  =  Pseq([Pseq([0.2, 0.1],8),Pseq([0.3, 0.2],2)], inf);
	~tmBass.source    =  Pseq([4], inf);
	~dur1Bass.source  =  Pseq([1], inf);
	~lfo1Bass.source =  Pseq([30,90,70,98, 0,110,60,20], inf);
	~lfo2Bass.source =  Pseq([0,0,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pseq([Pseq([~nt+0, ~nt-3],8),Pseq([~nt+0, ~nt+7, ~nt+4, ~nt+14],1)], inf);
	~amp1Keys.source  =  Pseq([Pseq([0.9, 0.6],8),Pseq([0.9, 0.7],2)], inf);
	~sus1Keys.source  =  Pseq([Pseq([0.2, 0.1],8),Pseq([0.3, 0.2],2)], inf)*2;
	~tmKeys.source    =  Pseq([2,2,2,1], inf);
	~lfoRtKeys.source =  Pseq([40,50,0,90,0], inf);
	~lfoCtKeys.source =  Pseq([10,10,40,50,60], inf);
	~vcfCtKeys.source =  Pseq([30,30,30,30,120], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pseq([Pseq([~nt+0, ~nt-3],8),Pseq([~nt+0, ~nt+7, ~nt+4, ~nt+14],1)], inf);
	~amp1Samp.source  =  Pseq([Pseq([0.9, 0.6],8),Pseq([0.9, 0.7],2)], inf);
	~sus1Samp.source  =  Pslide([0.8, 0.3, 0.6, 0.7, 0.2, 0.2 ],        inf, 3,2,0);
	~tmSamp.source    =  Pseq([1,2,2,2], inf);
	~lfo1Samp.source =  Pseq([90,112,70,98, 80,110,67,120], inf);
	~lfo2Samp.source =  Pseq([60,120,80,100], inf);
};
//////                                      - brdg4 -
//*mainTrack1 END
}



//Class END
}