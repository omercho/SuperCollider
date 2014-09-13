//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([0], inf);
	~amp1Kick.source  =  Pseq([0.9], inf);
	~sus1Kick.source  =  Pseq([0.2], inf);
	~tmKick.source    =  Pseq([1], inf);
//CH -1- [ Snare ]
	~nt1Snr.source    =  Pseq([Pseq([~nt+0],3)], inf);
	~amp1Snr.source   =  Pseq([0.9], inf);
	~sus1Snr.source   =  Pseq([0.2, 0.2, 0.2, 0.2]*0.8, inf);
	~tmSnr.source     =  Pseq([1], inf);
	~lfo1Snr.source   =  Pseq([30,90,70,98, 0,110,60,20], inf);
	~lfo2Snr.source   =  Pseq([0,0,0,0], inf);
//CH -2- [ HAT ]
	~nt1Hat.source    =  Pseq([Pseq([~nt+0],3)], inf);
	~amp1Hat.source   =  Pseq([0.8], inf);
	~sus1Hat.source   =  Pseq([0.3], inf);
	~tmHat.source     =  Pseq([1], inf);
	~lfo1Hat.source   =  Pseq([-3], inf);
	~lfo2Hat.source   =  Pseq([4], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pseq([Pseq([~nt+0],4), Pseq([~nt+2],1), Pseq([~nt+1],1)], inf);
	~amp1Bass.source  =  Pseq([Pseq([0.9],8)], inf);
	~sus1Bass.source  =  Pseq([Pseq([0.2],8)], inf);
	~tmBass.source    =  Pseq([1], inf);
	~lfo1Bass.source  =  Pseq([0], inf);
	~lfo2Bass.source  =  Pseq([0], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pseq([Pseq([~nt+0],12)], inf);
	~amp1Keys.source  =  Pseq([Pseq([0.9, 0.6],8),Pseq([0.9, 0.7],2)], inf);
	~sus1Keys.source  =  Pseq([Pseq([0.2],8)], inf);
	~tmKeys.source    =  Pseq([1], inf);
	~lfoRtKeys.source =  Pseq([95], inf);
	~lfoCtKeys.source =  Pseq([120], inf);
	~vcfCtKeys.source =  Pseq([120], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pseq([Pseq([~nt+0, ~nt-3],8)], inf);
	~amp1Samp.source  =  Pseq([Pseq([0.9, 0.6],8),Pseq([0.9, 0.7],2)], inf);
	~sus1Samp.source  =  Pseq([Pseq([0.2, 0.1],8),Pseq([0.3, 0.2],2)], inf);
	~tmSamp.source    =  Pseq([1], inf);
	~lfo1Samp.source  =  Pseq([90,112,70,98, 80,110,67,120], inf);
	~lfo2Samp.source  =  Pseq([60,120,80,100], inf);