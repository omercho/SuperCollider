
IFMainTrack1 {
*load {
		"IF Main Track 1 loaded".postln;
		~scl1= Scale.chromatic;
		~scl2= Scale.chinese;
		~tOSCAdrr.sendMsg('scaleLabel', 'Chinese');

		~tmp1=120;
		~tOSCAdrr.sendMsg('tempoLabel', ~tmp1);
		~tOSCAdrr.sendMsg('tempoFader', ~tmp1);
		~nt=(0);

		~dur = PatternProxy( Pseq([1], inf));
		~durP= Pseq([~dur], inf).asStream;

		~durMul = PatternProxy( Pseq([1], inf));
		~durMulP= Pseq([~durMul], inf).asStream;



//////                                     - 0 -
~mainSet_00 = {
	~nt1VKick.source   =  Pseq([~vKick], inf);
	~amp1VKick.source  =  Pseq([1,0,1,0], inf);
	~tmVKick.source    =  Pseq([1], inf);
	~levVKick.source    =  Pseq([0.9, 0.4, 0.9, 0.5], inf);
//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([~nt-0, ~nt+0, ~nt+0,~nt+0 ], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.9, 0], inf);
	~sus1Kick.source  =  Pseq([0.4, 0.1, 0.2, 0.1], inf);
	~tmKick.source    =  Pseq([1], inf);
    ~dur1Kick.source =  Pseq([1/2], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt+3, ~nt+0, ~nt+0 ], inf);
	~amp1Snr.source =  Pseq([0.0, 0.8, 0.9, 0.0], inf);
	~sus1Snr.source =  Pseq([0.2, 2.6, 0.2, 0.3]*0.8, inf);
	~tmSnr.source   =  Pseq([1,1,1,1], inf);
	~dur1Snr.source =  Pseq([1/2], inf);
//CH -2- [ HAT ]
	~nt1Hat.source   = Pseq([Pseq([~nt+0],3), Pseq([~nt+2],1)], inf);
	~amp1Hat.source  = Pseq([1,0.8,0.9,0.7, 1,0.8,0.8,0.7], inf);
	~sus1Hat.source  = Pseq([0.3, 0.1, 0.03, 0.1], inf);
	~tmHat.source    = Pseq([1,1,1,1,1,1], inf);
	~dur1Hat.source  = Pseq([1/2], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pseq([Pseq([~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Bass.source  =  Pseq([0.9, 0.7, 0.8, 0.7], inf);
	~sus1Bass.source  =  Pseq([0.5, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9, inf);
	~tmBass.source    =  Pseq([1,1,1,1], inf);
	~dur1Bass.source  =  Pseq([1/2], inf);
	~lfo1Bass.source  =  Pseq([30,90,70,18, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([10,20,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pseq([Pseq([~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Keys.source  =  Pseq([0.0,0.9,0.0,0.0],inf);
	~sus1Keys.source  =  Pseq([0.3, 0.3, 0.3, 0.5, 0.2, 0.1, 0.4, 0.5 ]*0.8);
	~tmKeys.source    =  Pseq([1/4], inf);
	~dur1Keys.source  =  Pseq([1/2], inf);
	~lfoRtKeys.source =  Pseq([20,40,40,10], inf);
	~lfoCtKeys.source =  Pseq([10,20,50,50], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pseq([Pseq([~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Samp.source  =  Pseq([0.0,0.0,0.9,0.0],inf);
	~sus1Samp.source  =  Pseq([0.5, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9, inf);
	~tmSamp.source    =  Pseq([1,1,2,1], inf);
	~dur1Samp.source  =  Pseq([1/2], inf);
	~lfo1Samp.source  =  Pseq([90,1,7,9, 80,10,7,1], inf);
	~lfo2Samp.source  =  Pseq([6,10,80,0.1], inf);
//Res1
	~nt1Res1.source   =  Pseq([~nt+0,~nt+1,~nt+3,~nt+0,~nt+1,~nt+0], inf);
	~dur1Res1.source  =  Pseq([1]*1, inf);
	~tmRes1.source    =  Pseq([1], inf);
};
//////                                      - 0 -

//////                                      - 1 -
~mainSet_01 = {
	~nt1VKick.source   =  Pseq([~vKick, ~vTomL, ~vTomH], inf);
	~amp1VKick.source  =  Pseq([1,0,1,0], inf);
	~tmVKick.source    =  Pseq([1], inf);
	~levVKick.source    =  Pseq([0.9, 0.4, 0.9, 0.5], inf);
//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([~nt-0, ~nt+0, ~nt+0,~nt+0 ], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.9, 0], inf);
	~sus1Kick.source  =  Pseq([0.4, 0.1, 0.2, 0.1], inf);
	~tmKick.source    =  Pseq([1], inf);
    ~dur1Kick.source =  Pseq([1/2], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt+3, ~nt+0, ~nt+0 ], inf);
	~amp1Snr.source =  Pseq([0.0, 0.8, 0.9, 0.0], inf);
	~sus1Snr.source =  Pseq([0.2, 2.6, 0.2, 0.3]*0.8, inf);
	~tmSnr.source   =  Pseq([1,1,1,1], inf);
	~dur1Snr.source =  Pseq([1/2], inf);
//CH -2- [ HAT ]
	~nt1Hat.source   = Pseq([Pseq([~nt+0],3), Pseq([~nt+2],1)], inf);
	~amp1Hat.source  = Pseq([1,0.8,0.9,0.7, 1,0.8,0.8,0.7], inf);
	~sus1Hat.source  = Pseq([0.3, 0.1, 0.03, 0.1], inf);
	~tmHat.source    = Pseq([1,1,1,1,1,1], inf);
	~dur1Hat.source  = Pseq([1/2], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pseq([Pseq([~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Bass.source  =  Pseq([0.9, 0.7, 0.8, 0.7], inf);
	~sus1Bass.source  =  Pseq([0.5, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9, inf);
	~tmBass.source    =  Pseq([1,1,1,1], inf);
	~dur1Bass.source  =  Pseq([1/2], inf);
	~lfo1Bass.source  =  Pseq([30,90,70,18, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([10,20,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pseq([Pseq([~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Keys.source  =  Pseq([0.0,0.9,0.0,0.0],inf);
	~sus1Keys.source  =  Pseq([0.3, 0.3, 0.3, 0.5, 0.2, 0.1, 0.4, 0.5 ]*0.8);
	~tmKeys.source    =  Pseq([1], inf);
	~dur1Keys.source  =  Pseq([1/2], inf);
	~lfoRtKeys.source =  Pseq([20,40,40,10], inf);
	~lfoCtKeys.source =  Pseq([10,20,50,50], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pseq([Pseq([~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Samp.source  =  Pseq([0.0,0.0,0.9,0.0],inf);
	~sus1Samp.source  =  Pseq([0.5, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9, inf);
	~tmSamp.source    =  Pseq([1,1,2,1], inf);
	~dur1Samp.source  =  Pseq([1/2], inf);
	~lfo1Samp.source  =  Pseq([90,1,7,9, 80,10,7,1], inf);
	~lfo2Samp.source  =  Pseq([6,10,80,0.1], inf);
//Res1
	~nt1Res1.source   =  Pseq([~nt+0,~nt+1,~nt+3,~nt+0,~nt+1,~nt+0], inf);
	~dur1Res1.source  =  Pseq([1]*1, inf);
	~tmRes1.source    =  Pseq([1], inf);
};
//////                                      - 1 -

//////                                      - 2 -
~mainSet_02 = {
//CH -0- [ KICK ]
	~nt1VKick.source   =  Pseq([~vKick, ~vTomL, ~vTomH], inf);
	~amp1VKick.source  =  Pseq([1,0,1,0], inf);
	~tmVKick.source    =  Pseq([1], inf);
	~nt1Kick.source   =  Pseq([~nt-0, ~nt+0, ~nt+0,~nt+0 ], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.9, 0], inf);
	~sus1Kick.source  =  Pseq([0.4, 0.1, 0.2, 0.1], inf);
	~tmKick.source    =  Pseq([1], inf);
    ~dur1Kick.source =  Pseq([1/2], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt+4, ~nt+0, ~nt+0 ], inf);
	~amp1Snr.source =  Pseq([0.0, 0.8, 0.9, 0.0], inf);
	~sus1Snr.source =  Pseq([0.2, 2.6, 0.2, 0.3]*0.8, inf);
	~tmSnr.source   =  Pseq([1,1,1,1], inf);
	~dur1Snr.source =  Pseq([1/2], inf);
//CH -2- [ HAT ]
	~nt1Hat.source   = Pseq([Pseq([~nt+0],3), Pseq([~nt+2],1)], inf);
	~amp1Hat.source  = Pseq([1,0.8,0.9,0.7, 1,0.8,0.8,0.7], inf);
	~sus1Hat.source  = Pseq([0.3, 0.1, 0.03, 0.1], inf);
	~tmHat.source    = Pseq([1,1,1,1,1,1], inf);
	~dur1Hat.source  = Pseq([1/2], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pseq([Pseq([~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Bass.source  =  Pseq([0.9, 0.7, 0.9, 0.6],inf);
	~sus1Bass.source  =  Pseq([0.1, 0.3, 0.1, 0.5 ]*0.8);
	~tmBass.source    =  Pseq([1,1,1,1], inf);
	~dur1Bass.source  =  Pseq([1/2], inf);
	~lfo1Bass.source  =  Pseq([70,90,70,18, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([10,20,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pseq([Pseq([~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Keys.source  =  Pseq([0.0, 0.0, 0.9, 0.6],inf);
	~sus1Keys.source  =  Pseq([0.1, 0.3, 0.1, 0.5 ]*0.8);
	~tmKeys.source    =  Pseq([1], inf);
	~dur1Keys.source  =  Pseq([1/2], inf);
	~lfoRtKeys.source =  Pseq([20,10,120,10], inf);
	~lfoCtKeys.source =  Pseq([10,10,50,50], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pseq([Pseq([~nt+0,~nt+0,~nt+0,~nt+0,~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Samp.source  =  Pslide([0.9, 0.7, 0.0, 0.7, 0.9, 0.6],         inf, 3,1,0);
	~sus1Samp.source  =  Pslide([0.5, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9,    inf, 3,1,0);
	~tmSamp.source    =  Pseq([1,1,2,1], inf);
	~dur1Samp.source  =  Pseq([1/2], inf);
	~lfo1Samp.source =  Pseq([90,1,7,90, 80,10,7,1], inf);
	~lfo2Samp.source =  Pseq([6,10,80,10], inf);
//Res1
	~nt1Res1.source   =   Pslide([~nt+0,~nt+1,~nt+3,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~dur1Res1.source  =  Pseq([1]*1, inf);
	~tmRes1.source  =  Pseq([1], inf);

};
//////                                      - 2 -

//////                                      - 3 -
~mainSet_03 = {
//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([~nt-0, ~nt+0, ~nt+0,~nt+0 ], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.9, 0], inf);
	~sus1Kick.source  =  Pseq([0.4, 0.1, 0.2, 0.1], inf);
	~tmKick.source    =  Pseq([1], inf);
    ~dur1Kick.source =  Pseq([1/2], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt+3, ~nt+4, ~nt+0 ], inf);
	~amp1Snr.source =  Pseq([0.0, 0.8, 0.9, 0.0], inf);
	~sus1Snr.source =  Pseq([0.2, 2.6, 0.2, 0.3]*0.8, inf);
	~tmSnr.source   =  Pseq([1,2,1,1], inf);
	~dur1Snr.source =  Pseq([1/2], inf);
//CH -2- [ HAT ]
	~nt1Hat.source   = Pseq([Pseq([~nt+0],3), Pseq([~nt+2],1)], inf);
	~amp1Hat.source  = Pseq([1,0.8,0.9,0.7, 1,0.8,0.8,0.7], inf);
	~sus1Hat.source  = Pseq([0.3, 0.1, 0.03, 0.1], inf);
	~tmHat.source    = Pseq([2,1,1,1,1,1], inf);
	~dur1Hat.source  = Pseq([1/2], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pseq([Pseq([~nt+0,~nt+3,~nt+0,~nt+0],1)], inf);
	~amp1Bass.source  =  Pseq([0.9, 0.7, 0.9, 0.6],inf);
	~sus1Bass.source  =  Pseq([0.1, 0.3, 0.1, 0.5 ]*0.8);
	~tmBass.source    =  Pseq([1,1,1,1], inf);
	~dur1Bass.source  =  Pseq([1/2], inf);
	~lfo1Bass.source  =  Pseq([70,90,70,18, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([10,20,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pseq([Pseq([~nt+0,~nt+1,~nt+0,~nt+0],1)], inf);
	~amp1Keys.source  =  Pseq([0.0, 0.5, 0.9, 0.6],inf);
	~sus1Keys.source  =  Pseq([0.0, 0.9, 0.1, 0.5 ]*0.8);
	~tmKeys.source    =  Pseq([1], inf);
	~dur1Keys.source  =  Pseq([1/2], inf);
	~lfoRtKeys.source =  Pseq([20,10,120,10], inf);
	~lfoCtKeys.source =  Pseq([10,10,50,50], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pseq([Pseq([~nt+0,~nt+0,~nt+3,~nt+0,~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Samp.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.9, 0.6],         inf, 3,1,0);
	~sus1Samp.source  =  Pslide([0.8, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9,    inf, 3,1,0);
	~tmSamp.source    =  Pseq([1,1,2,1], inf);
	~dur1Samp.source  =  Pseq([1/2], inf);
	~lfo1Samp.source =  Pseq([90,1,7,90, 80,10,7,1], inf);
	~lfo2Samp.source =  Pseq([6,10,80,10], inf);
//Res1
	~nt1Res1.source   =   Pslide([~nt+0,~nt+1,~nt+3,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~dur1Res1.source  =  Pseq([1]*1, inf);
	~tmRes1.source  =  Pseq([1], inf);
};
//////                                      - 3 -

//////                                      - 4 -
~mainSet_04 = {
//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([~nt-0, ~nt+0, ~nt+0,~nt+0 ], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.9, 0], inf);
	~sus1Kick.source  =  Pseq([0.4, 0.1, 0.2, 0.1], inf);
	~tmKick.source    =  Pseq([1], inf);
    ~dur1Kick.source =  Pseq([1/2], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt+4, ~nt+0, ~nt+0 ], inf);
	~amp1Snr.source =  Pseq([0.0, 0.8, 0.9, 0.0], inf);
	~sus1Snr.source =  Pseq([0.2, 2.6, 0.2, 0.3]*0.8, inf);
	~tmSnr.source   =  Pseq([1,1,1,1], inf);
	~dur1Snr.source =  Pseq([1/2], inf);
//CH -2- [ HAT ]
	~nt1Hat.source   = Pseq([Pseq([~nt+0,~nt+1],3), Pseq([~nt+2],1)], inf);
	~amp1Hat.source  = Pseq([1,0.8,0.9,0.7, 1,0.8,0.8,0.7], inf);
	~sus1Hat.source  = Pseq([0.3, 0.1, 0.03, 0.1], inf);
	~tmHat.source    = Pseq([2,1,1,1,1,1], inf);
	~dur1Hat.source  = Pseq([1/2], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pseq([Pseq([~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Bass.source  =  Pseq([0.9, 0.7, 0.9, 0.6],inf);
	~sus1Bass.source  =  Pseq([0.1, 0.3, 0.1, 0.5 ]*0.8);
	~tmBass.source    =  Pseq([1,1,1,1], inf);
	~dur1Bass.source  =  Pseq([1/2], inf);
	~lfo1Bass.source  =  Pseq([70,90,70,18, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([10,20,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pseq([Pseq([~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Keys.source  =  Pseq([0.0, 0.0, 0.9, 0.6],inf);
	~sus1Keys.source  =  Pseq([0.1, 0.3, 0.1, 0.5 ]*0.8);
	~tmKeys.source    =  Pseq([1], inf);
	~dur1Keys.source  =  Pseq([1/2], inf);
	~lfoRtKeys.source =  Pseq([20,10,120,10], inf);
	~lfoCtKeys.source =  Pseq([10,10,50,50], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pseq([Pseq([~nt+3,~nt+0,~nt+0,~nt+0,~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Samp.source  =  Pslide([0.9, 0.7, 0.0, 0.7, 0.9, 0.6],         inf, 3,1,0);
	~sus1Samp.source  =  Pslide([0.5, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9,    inf, 3,1,0);
	~tmSamp.source    =  Pseq([1,1,2,1], inf);
	~dur1Samp.source  =  Pseq([1/2], inf);
	~lfo1Samp.source =  Pseq([90,1,7,90, 80,10,7,1], inf);
	~lfo2Samp.source =  Pseq([6,10,80,10], inf);
//Res1
	~nt1Res1.source   =   Pslide([~nt+0,~nt+1,~nt+3,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~dur1Res1.source  =  Pseq([1]*1, inf);
	~tmRes1.source  =  Pseq([1], inf);
};
//////                                      - 4 -

//////                                      - 5 -
~mainSet_05 = {
// DRUM
//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([~nt-0, ~nt+0, ~nt+0,~nt+0 ], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.9, 0], inf);
	~sus1Kick.source  =  Pseq([0.4, 0.1, 0.2, 0.1], inf);
	~tmKick.source    =  Pseq([1], inf);
    ~dur1Kick.source =  Pseq([1.25], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt+4, ~nt+0, ~nt+0 ], inf);
	~amp1Snr.source =  Pseq([0.0, 0.8, 0.9, 0.0], inf);
	~sus1Snr.source =  Pseq([0.2, 2.6, 0.2, 0.3]*0.8, inf);
	~tmSnr.source   =  Pseq([1,1,1,1], inf);
	~dur1Snr.source =  Pseq([1], inf);
//CH -2- [ HAT ]
	~nt1Hat.source   = Pseq([Pseq([~nt+0,~nt+1],3), Pseq([~nt+2],1)], inf);
	~amp1Hat.source  = Pseq([1,0.8,0.9,0.7, 1,0.8,0.8,0.7], inf);
	~sus1Hat.source  = Pseq([0.3, 0.1, 0.03, 0.1], inf);
	~tmHat.source    = Pseq([2,1,1,1,1,1], inf);
	~dur1Hat.source  = Pseq([1], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pseq([Pseq([~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Bass.source  =  Pseq([0.9, 0.7, 0.9, 0.6],inf);
	~sus1Bass.source  =  Pseq([0.1, 0.3, 0.1, 0.5 ]*0.8);
	~tmBass.source    =  Pseq([1,1,1,1], inf);
			~dur1Bass.source  =  Pseq([1.5], inf);
	~lfo1Bass.source  =  Pseq([70,90,70,18, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([10,20,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pseq([Pseq([~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Keys.source  =  Pseq([0.0, 0.0, 0.9, 0.6],inf);
	~sus1Keys.source  =  Pseq([0.1, 0.3, 0.1, 0.5 ]*0.8);
	~tmKeys.source    =  Pseq([1], inf);
	~dur1Keys.source  =  Pseq([1/2], inf);
	~lfoRtKeys.source =  Pseq([20,10,120,10], inf);
	~lfoCtKeys.source =  Pseq([10,10,50,50], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pseq([Pseq([~nt+3,~nt+0,~nt+0,~nt+0,~nt+0,~nt+0,~nt+0,~nt+0],1)], inf);
	~amp1Samp.source  =  Pslide([0.9, 0.7, 0.0, 0.7, 0.9, 0.6],         inf, 3,1,0);
	~sus1Samp.source  =  Pslide([0.5, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9,    inf, 3,1,0);
	~tmSamp.source    =  Pseq([1,1,2,1], inf);
	~dur1Samp.source  =  Pseq([1/2], inf);
	~lfo1Samp.source =  Pseq([90,1,7,90, 80,10,7,1], inf);
	~lfo2Samp.source =  Pseq([6,10,80,10], inf);
//Res1
	~nt1Res1.source   =   Pslide([~nt+0,~nt+1,~nt+3,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~dur1Res1.source  =  Pseq([1]*1, inf);
	~tmRes1.source  =  Pseq([1], inf);
};
//////                                      - 5 -

//////                                      - 6 -
~mainSet_06 = {
//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([~nt-0, ~nt+0, ~nt+0,~nt+0 ], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.9, 0], inf);
	~sus1Kick.source  =  Pseq([0.4, 0.1, 0.2, 0.1], inf);
	~tmKick.source    =  Pseq([1], inf);
    ~dur1Kick.source =  Pseq([1/1], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt+0, ~nt+0, ~nt+0, ], inf);
	~amp1Snr.source =  Pseq([0.0, 0.0, 0.9, 0.0], inf);
	~sus1Snr.source =  Pseq([0.2, 2.6, 0.2, 0.3]*0.8, inf);
	~tmSnr.source   =  Pseq([1,1,1,1], inf);
	~dur1Snr.source =  Pseq([1/1], inf);
//CH -2- [ HAT ]
	~nt1Hat.source   = Pseq([Pseq([~nt+0,~nt+3],1)], inf);
	~amp1Hat.source  = Pseq([1,0.8,0.8,0.7], inf);
	~sus1Hat.source  = Pseq([0.6, 0.1, 0.03, 0.1], inf);
	~tmHat.source    = Pseq([1,1,1,1,1,2], inf);
	~dur1Hat.source  = Pseq([1/1], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+0,~nt+3,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Bass.source  =  Pslide([0.9, 0.7, 0.8, 0.7, 0.9, 0.6],         inf, 3,1,0);
	~sus1Bass.source  =  Pslide([0.5, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9,    inf, 3,1,0);
	~tmBass.source    =  Pseq([1,1,2,1], inf);
	~dur1Bass.source  =  Pseq([1/2], inf);
	~lfo1Bass.source  =  Pseq([30,90,70,18, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([0,0,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+3,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Keys.source  =  Pseq([0.9,0.9,0,0,0.5,0,0.8,0],inf);
	~sus1Keys.source  =  Pseq([0.8, 0.3, 0.3, 0.5, 0.2, 0.1, 0.9, 0.5 ]*0.8);
	~tmKeys.source    =  Pseq([1], inf);
	~dur1Keys.source  =  Pseq([1/2], inf);
	~lfoRtKeys.source =  Pseq([20,40,80], inf);
	~lfoCtKeys.source =  Pseq([10,20,50,80,40], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pslide([~nt+0,~nt+0,~nt+1,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Samp.source  =  Pslide([0.9, 0.7, 0.0, 0.7, 0.9, 0.6],         inf, 3,1,0);
	~sus1Samp.source  =  Pslide([0.5, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9,    inf, 3,1,0);
	~tmBass.source    =  Pseq([1,1,2,1], inf);
	~dur1Samp.source  =  Pseq([1], inf);
	~lfo1Samp.source =  Pseq([90,1,7,9, 80,10,7,1], inf);
	~lfo2Samp.source =  Pseq([6,10,80,0.1], inf);
//Res1
	~nt1Res1.source   =   Pslide([~nt+0,~nt+1,~nt+3,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~dur1Res1.source  =  Pseq([1]*1, inf);
	~tmRes1.source  =  Pseq([1], inf);
};
//////                                      - 6 -

//////                                      - 7 -
~mainSet_07 = {
//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([~nt-0, ~nt+0, ~nt+0,~nt+0 ], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.9, 0], inf);
	~sus1Kick.source  =  Pseq([0.5, 0.1, 0.2, 0.1], inf);
	~tmKick.source    =  Pseq([1], inf);
    ~dur1Kick.source =  Pseq([1/1], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt+0, ~nt+0, ~nt+0, ], inf);
	~amp1Snr.source =  Pseq([0.0, 0.0, 0.9, 0.0], inf);
	~sus1Snr.source =  Pseq([0.9, 2.6, 0.2, 0.3]*0.8, inf);
	~tmSnr.source   =  Pseq([1,2,1,1], inf);
	~dur1Snr.source =  Pseq([1/1], inf);
//CH -2- [ HAT ]
	~nt1Hat.source   = Pseq([Pseq([~nt+0,~nt+3],1)], inf);
	~amp1Hat.source  = Pseq([1,0.8,0.8,0.7], inf);
	~sus1Hat.source  = Pseq([0.6, 0.1, 0.03, 0.1]*1.2, inf);
	~tmHat.source    = Pseq([1,1,1,1,1,2], inf);
	~dur1Hat.source  = Pseq([1/1], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+0,~nt+3,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Bass.source  =  Pslide([0.9, 0.7, 0.8, 0.7, 0.9, 0.6],         inf, 3,1,0);
	~sus1Bass.source  =  Pslide([0.5, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9,    inf, 3,1,0);
	~tmBass.source    =  Pseq([1,1,2,1], inf);
	~dur1Bass.source  =  Pseq([1/2], inf);
	~lfo1Bass.source  =  Pseq([30,90,70,18, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([0,0,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+3,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Keys.source  =  Pseq([0.9,0.9,0,0,0.5,0,0.8,0],inf);
	~sus1Keys.source  =  Pseq([0.8, 0.3, 0.3, 0.5, 0.2, 0.1, 0.9, 0.5 ]*0.8);
	~tmKeys.source    =  Pseq([1], inf);
	~dur1Keys.source  =  Pseq([1/2], inf);
	~lfoRtKeys.source =  Pseq([20,40,80], inf);
	~lfoCtKeys.source =  Pseq([10,20,50,80,40], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pslide([~nt+0,~nt+0,~nt+1,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Samp.source  =  Pslide([0.9, 0.7, 0.0, 0.7, 0.9, 0.6],         inf, 3,1,0);
	~sus1Samp.source  =  Pslide([0.5, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9,    inf, 3,1,0);
	~tmBass.source    =  Pseq([1,1,2,1], inf);
	~dur1Samp.source  =  Pseq([1], inf);
	~lfo1Samp.source =  Pseq([90,1,7,9, 80,10,7,1], inf);
	~lfo2Samp.source =  Pseq([6,10,80,0.1], inf);
//Res1
	~nt1Res1.source   =   Pslide([~nt+0,~nt+1,~nt+3,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~dur1Res1.source  =  Pseq([1]*1, inf);
	~tmRes1.source  =  Pseq([1], inf);
};
//////                                      - 7 -


////////---------------------------------- BRIDGES ----------------------------------------/////////

//////                                      - brdg1 -
~mainBridge_01 = {
//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([~nt-0, ~nt+0, ~nt+0,~nt+0 ], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.0, 0], inf);
	~sus1Kick.source  =  Pseq([0.4, 0.1, 0.2, 0.1], inf);
	~tmKick.source    =  Pseq([1], inf);
    ~dur1Kick.source =   Pseq([1], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt+6, ~nt+3, ~nt+6, ], inf);
	~amp1Snr.source =  Pseq([0.0, 0.9, 0.0, 0.0], inf);
	~sus1Snr.source =  Pseq([0.2, 0.6, 0.2, 0.3]*0.4, inf);
	~tmSnr.source   =  Pseq([1,1,1,1], inf);
	~dur1Snr.source =  Pseq([1/2], inf);
//CH -2- [ HAT ]
	~nt1Hat.source   = Pseq([Pseq([~nt+0,~nt+3,~nt+12],2)], inf);
	~amp1Hat.source  = Pseq([1,0.8,0.8,0.7], inf);
	~sus1Hat.source  = Pseq([0.6, 0.1, 0.03, 0.1], inf);
	~tmHat.source    = Pseq([1,1,1,1,1,1], inf);
	~dur1Hat.source  = Pseq([1/1], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Bass.source  =  Pslide([0.0, 0.0, 0.0, 0.7, 0.0, 0.0],         inf, 3,1,0);
	~sus1Bass.source  =  Pslide([0.5, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9,    inf, 3,1,0);
	~tmBass.source    =  Pseq([1,1,1,1], inf);
	~dur1Bass.source  =  Pseq([1/2], inf);
	~lfo1Bass.source  =  Pseq([30,90,70,98, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([0,0,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Keys.source  =  Pseq([0.9,0,0,0,0.5,0,0,0],inf);
	~sus1Keys.source  =  Pseq([0.8, 0.3, 0.3, 0.5, 0.2, 0.1, 0.9, 0.5 ]*0.8);
	~tmKeys.source    =  Pseq([1], inf);
	~dur1Keys.source  =  Pseq([1/2], inf);
	~lfoRtKeys.source =  Pseq([20,40,80], inf);
	~lfoCtKeys.source =  Pseq([10,20,50,80,40], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Samp.source  =  Pslide([0.0, 0.0, 0.0, 0.7, 0.0, 0.0]*0.9,inf, 3,3,0);
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
//////                                      - brdg1 -

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
//IFCounter.reset;
		~stepNum.source  =  Pseq([1,2,3,4,5,6,7,8], inf);
//CH -0- [ KICK ]
	~dur1Kick.source  =  Pseq([1/2], inf);
	~nt1Kick.source   =  Pseq([
				~seqNtKick01.next, ~seqNtKick02.next, ~seqNtKick03.next, ~seqNtKick04.next,
				~seqNtKick05.next, ~seqNtKick06.next, ~seqNtKick07.next, ~seqNtKick08.next
			], inf);
	~sus1Kick.source  =  Pseq([
				~seqSusKick01.next, ~seqSusKick02.next, ~seqSusKick03.next, ~seqSusKick04.next,
				~seqSusKick05.next, ~seqSusKick06.next, ~seqSusKick07.next, ~seqSusKick08.next
			], inf);
	~octKick.source = Pseq([
				~seqOctKick01.next, ~seqOctKick02.next, ~seqOctKick03.next, ~seqOctKick04.next,
				~seqOctKick05.next, ~seqOctKick06.next, ~seqOctKick07.next, ~seqOctKick08.next
			], inf);
	~tmKick.source    =  Pseq([
				~seqTmKick01.next, ~seqTmKick02.next, ~seqTmKick03.next, ~seqTmKick04.next,
				~seqTmKick05.next, ~seqTmKick06.next, ~seqTmKick07.next, ~seqTmKick08.next
			], inf);
	~amp1Kick.source  =  Pseq([
				~seqKick01.next*~seqVelKick01.next,
				~seqKick02.next*~seqVelKick02.next,
				~seqKick03.next*~seqVelKick03.next,
				~seqKick04.next*~seqVelKick04.next,
				~seqKick05.next*~seqVelKick05.next,
				~seqKick06.next*~seqVelKick06.next,
				~seqKick07.next*~seqVelKick07.next,
				~seqKick08.next*~seqVelKick08.next
			], inf);
//CH -1- [ Snare ]
	~dur1Snr.source  =  Pseq([1/2], inf);
	~nt1Snr.source   =  Pseq([
				~seqNtSnr01.next, ~seqNtSnr02.next, ~seqNtSnr03.next, ~seqNtSnr04.next,
				~seqNtSnr05.next, ~seqNtSnr06.next, ~seqNtSnr07.next, ~seqNtSnr08.next
			], inf);
	~sus1Snr.source  =  Pseq([
				~seqSusSnr01.next, ~seqSusSnr02.next, ~seqSusSnr03.next, ~seqSusSnr04.next,
				~seqSusSnr05.next, ~seqSusSnr06.next, ~seqSusSnr07.next, ~seqSusSnr08.next
			], inf);
	~octSnr.source = Pseq([
				~seqOctSnr01.next, ~seqOctSnr02.next, ~seqOctSnr03.next, ~seqOctSnr04.next,
				~seqOctSnr05.next, ~seqOctSnr06.next, ~seqOctSnr07.next, ~seqOctSnr08.next
			], inf);
	~tmSnr.source    =  Pseq([
				~seqTmSnr01.next, ~seqTmSnr02.next, ~seqTmSnr03.next, ~seqTmSnr04.next,
				~seqTmSnr05.next, ~seqTmSnr06.next, ~seqTmSnr07.next, ~seqTmSnr08.next
			], inf);
	~amp1Snr.source  =  Pseq([
				~seqSnr01.next*~seqVelSnr01.next,
				~seqSnr02.next*~seqVelSnr02.next,
				~seqSnr03.next*~seqVelSnr03.next,
				~seqSnr04.next*~seqVelSnr04.next,
				~seqSnr05.next*~seqVelSnr05.next,
				~seqSnr06.next*~seqVelSnr06.next,
				~seqSnr07.next*~seqVelSnr07.next,
				~seqSnr08.next*~seqVelSnr08.next
			], inf);
//CH -2- [ HAT ]
	~dur1Hat.source  =  Pseq([1/2], inf);
	~nt1Hat.source   =  Pseq([
				~seqNtHat01.next, ~seqNtHat02.next, ~seqNtHat03.next, ~seqNtHat04.next,
				~seqNtHat05.next, ~seqNtHat06.next, ~seqNtHat07.next, ~seqNtHat08.next
			], inf);
	~sus1Hat.source  =  Pseq([
				~seqSusHat01.next, ~seqSusHat02.next, ~seqSusHat03.next, ~seqSusHat04.next,
				~seqSusHat05.next, ~seqSusHat06.next, ~seqSusHat07.next, ~seqSusHat08.next
			], inf);
	~octHat.source = Pseq([
				~seqOctHat01.next, ~seqOctHat02.next, ~seqOctHat03.next, ~seqOctHat04.next,
				~seqOctHat05.next, ~seqOctHat06.next, ~seqOctHat07.next, ~seqOctHat08.next
			], inf);
	~tmHat.source    =  Pseq([
				~seqTmHat01.next, ~seqTmHat02.next, ~seqTmHat03.next, ~seqTmHat04.next,
				~seqTmHat05.next, ~seqTmHat06.next, ~seqTmHat07.next, ~seqTmHat08.next
			], inf);
	~amp1Hat.source  =  Pseq([
				~seqHat01.next*~seqVelHat01.next,
				~seqHat02.next*~seqVelHat02.next,
				~seqHat03.next*~seqVelHat03.next,
				~seqHat04.next*~seqVelHat04.next,
				~seqHat05.next*~seqVelHat05.next,
				~seqHat06.next*~seqVelHat06.next,
				~seqHat07.next*~seqVelHat07.next,
				~seqHat08.next*~seqVelHat08.next
			], inf);
//CH -4- [Bass]
	~lfo1Bass.source  =  Pseq([30,90,70,18, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([10,20,110,50], inf);
	~dur1Bass.source  =  Pseq([1/2], inf);
	~nt1Bass.source   =  Pseq([
				~seqNtBass01.next, ~seqNtBass02.next, ~seqNtBass03.next, ~seqNtBass04.next,
				~seqNtBass05.next, ~seqNtBass06.next, ~seqNtBass07.next, ~seqNtBass08.next
			], inf);
	~sus1Bass.source  =  Pseq([
				~seqSusBass01.next, ~seqSusBass02.next, ~seqSusBass03.next, ~seqSusBass04.next,
				~seqSusBass05.next, ~seqSusBass06.next, ~seqSusBass07.next, ~seqSusBass08.next
			], inf);
	~octBass.source = Pseq([
				~seqOctBass01.next, ~seqOctBass02.next, ~seqOctBass03.next, ~seqOctBass04.next,
				~seqOctBass05.next, ~seqOctBass06.next, ~seqOctBass07.next, ~seqOctBass08.next
			], inf);
	~tmBass.source    =  Pseq([
				~seqTmBass01.next, ~seqTmBass02.next, ~seqTmBass03.next, ~seqTmBass04.next,
				~seqTmBass05.next, ~seqTmBass06.next, ~seqTmBass07.next, ~seqTmBass08.next
			], inf);
	~amp1Bass.source  =  Pseq([
				~seqBass01.next*~seqVelBass01.next,
				~seqBass02.next*~seqVelBass02.next,
				~seqBass03.next*~seqVelBass03.next,
				~seqBass04.next*~seqVelBass04.next,
				~seqBass05.next*~seqVelBass05.next,
				~seqBass06.next*~seqVelBass06.next,
				~seqBass07.next*~seqVelBass07.next,
				~seqBass08.next*~seqVelBass08.next
			], inf);
//CH -5- [Keys]
	~lfoRtKeys.source =  Pseq([20,40,40,10], inf);
	~lfoCtKeys.source =  Pseq([10,20,50,50], inf);
	~dur1Keys.source  =  Pseq([1/2], inf);
	~nt1Keys.source   =  Pseq([
				~seqNtKeys01.next, ~seqNtKeys02.next, ~seqNtKeys03.next, ~seqNtKeys04.next,
				~seqNtKeys05.next, ~seqNtKeys06.next, ~seqNtKeys07.next, ~seqNtKeys08.next
			], inf);
	~sus1Keys.source  =  Pseq([
				~seqSusKeys01.next, ~seqSusKeys02.next, ~seqSusKeys03.next, ~seqSusKeys04.next,
				~seqSusKeys05.next, ~seqSusKeys06.next, ~seqSusKeys07.next, ~seqSusKeys08.next
			], inf);
	~octKeys.source = Pseq([
				~seqOctKeys01.next, ~seqOctKeys02.next, ~seqOctKeys03.next, ~seqOctKeys04.next,
				~seqOctKeys05.next, ~seqOctKeys06.next, ~seqOctKeys07.next, ~seqOctKeys08.next
			], inf);
	~tmKeys.source    =  Pseq([
				~seqTmKeys01.next, ~seqTmKeys02.next, ~seqTmKeys03.next, ~seqTmKeys04.next,
				~seqTmKeys05.next, ~seqTmKeys06.next, ~seqTmKeys07.next, ~seqTmKeys08.next
			], inf);
	~amp1Keys.source  =  Pseq([
				~seqKeys01.next*~seqVelKeys01.next,
				~seqKeys02.next*~seqVelKeys02.next,
				~seqKeys03.next*~seqVelKeys03.next,
				~seqKeys04.next*~seqVelKeys04.next,
				~seqKeys05.next*~seqVelKeys05.next,
				~seqKeys06.next*~seqVelKeys06.next,
				~seqKeys07.next*~seqVelKeys07.next,
				~seqKeys08.next*~seqVelKeys08.next
			], inf);
//CH -6- [SAMP]
	~lfo1Samp.source  =  Pseq([90,1,7,9, 80,10,7,1], inf);
	~lfo2Samp.source  =  Pseq([6,10,80,0.1], inf);
	~dur1Samp.source  =  Pseq([1/2], inf);
	~nt1Samp.source   =  Pseq([
				~seqNtSamp01.next, ~seqNtSamp02.next, ~seqNtSamp03.next, ~seqNtSamp04.next,
				~seqNtSamp05.next, ~seqNtSamp06.next, ~seqNtSamp07.next, ~seqNtSamp08.next
			], inf);
	~sus1Samp.source  =  Pseq([
				~seqSusSamp01.next, ~seqSusSamp02.next, ~seqSusSamp03.next, ~seqSusSamp04.next,
				~seqSusSamp05.next, ~seqSusSamp06.next, ~seqSusSamp07.next, ~seqSusSamp08.next
			], inf);
	~octSamp.source = Pseq([
				~seqOctSamp01.next, ~seqOctSamp02.next, ~seqOctSamp03.next, ~seqOctSamp04.next,
				~seqOctSamp05.next, ~seqOctSamp06.next, ~seqOctSamp07.next, ~seqOctSamp08.next
			], inf);
	~tmSamp.source    =  Pseq([
				~seqTmSamp01.next, ~seqTmSamp02.next, ~seqTmSamp03.next, ~seqTmSamp04.next,
				~seqTmSamp05.next, ~seqTmSamp06.next, ~seqTmSamp07.next, ~seqTmSamp08.next
			], inf);
	~amp1Samp.source  =  Pseq([
				~seqSamp01.next*~seqVelSamp01.next,
				~seqSamp02.next*~seqVelSamp02.next,
				~seqSamp03.next*~seqVelSamp03.next,
				~seqSamp04.next*~seqVelSamp04.next,
				~seqSamp05.next*~seqVelSamp05.next,
				~seqSamp06.next*~seqVelSamp06.next,
				~seqSamp07.next*~seqVelSamp07.next,
				~seqSamp08.next*~seqVelSamp08.next
			], inf);
//Res1
	~nt1Res1.source   =  Pseq([~nt+0,~nt+1,~nt+3,~nt+0,~nt+8,~nt+0], inf);
	~dur1Res1.source  =  Pseq([1]*1, inf);
	~tmRes1.source    =  Pseq([1], inf);


};
//////                                      - brdg4 -
//*mainTrack1 END
}



//Class END
}