(
//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([~nt+0, ~nt+0, ~nt+4,~nt+8, ~nt+0,~nt+3, ~nt+4, ~nt+5 ], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.9, 0], inf);
	~sus1Kick.source  =  Pseq([0.4, 0.1, 0.2, 0.1], inf);
	~tmKick.source    =  Pseq([1], inf);
    ~dur1Kick.source =  Pseq([1], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt+6, ~nt+3], inf);
	~amp1Snr.source =  Pseq([0.0, 0.8, 0.2, 0], inf);
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
)
(
//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([~nt-0, ~nt+0, ~nt+0,~nt+0 ], inf);
	~amp1Kick.source  =  Pseq([0.9, 0, 0.9, 0], inf);
	~sus1Kick.source  =  Pseq([0.4, 0.1, 0.2, 0.1], inf);
	~tmKick.source    =  Pseq([1], inf);
    ~dur1Kick.source =  Pseq([1], inf);
//CH -1- [ Snare ]
	~nt1Snr.source  =  Pseq([~nt+0, ~nt+6, ~nt+3, ~nt+6, ], inf);
	~amp1Snr.source =  Pseq([0.0, 0.0, 0.9, 0.0], inf);
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
	~amp1Bass.source  =  Pslide([0.9, 0.0, 0.0, 0.7, 0.0, 0.0],         inf, 3,1,0);
	~sus1Bass.source  =  Pslide([0.5, 0.3, 0.4, 0.7, 0.2, 0.1 ]*0.9,    inf, 3,1,0);
	~tmBass.source    =  Pseq([2,1,2,1], inf);
	~dur1Bass.source  =  Pseq([1/2], inf);
	~lfo1Bass.source  =  Pseq([30,90,70,98, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([0,0,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Keys.source  =  Pseq([0.0,0,0,0,0.5,0,0.8,0],inf);
	~sus1Keys.source  =  Pseq([0.8, 0.3, 0.3, 0.5, 0.2, 0.1, 0.9, 0.5 ]*0.8);
	~tmKeys.source    =  Pseq([1], inf);
	~dur1Keys.source  =  Pseq([1/2], inf);
	~lfoRtKeys.source =  Pseq([20,40,80], inf);
	~lfoCtKeys.source =  Pseq([10,20,50,80,40], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Samp.source  =  Pslide([0.0, 0.9, 0.0, 0.7, 0.0, 0.0]*0.9,inf, 3,3,0);
	~sus1Samp.source  =  Pslide([1.8, 0.03, 0.06, 0.7, 0.2, 0.2 ], inf, 3,2,0);
	~tmSamp.source    =  Pseq([1], inf);
	~dur1Samp.source  =  Pseq([1], inf);
	~lfo1Samp.source =  Pseq([90,1,7,9, 80,10,7,1], inf);
	~lfo2Samp.source =  Pseq([6,10,80,0.1], inf);
//Res1
	~nt1Res1.source   =   Pslide([~nt+0,~nt+1,~nt+7,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~dur1Res1.source  =  Pseq([1]*1, inf);
	~tmRes1.source  =  Pseq([1], inf);
)
(
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
	~amp1Keys.source  =  Pseq([0.0,0.9,0,0,0.5,0,0.8,0],inf);
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

)