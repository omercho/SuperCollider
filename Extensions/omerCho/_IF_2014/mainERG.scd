//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([0, ~nt+11, ~nt+3, ~nt+10], inf);
	~amp1Kick.source  =  Pseq([0.9], inf);
	~sus1Kick.source  =  Pseq([0.2], inf);
	~tmKick.source    =  Pseq([1], inf);
//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr.source  =  Pseq([Pseq([~nt+0],3),Pseq([~nt+1, ~nt+7],1)], inf);
	~amp1Snr.source =  Pseq([ 0.0, 0.0, 0.0, 0.0, 0.9], inf);
	~sus1Snr.source =  Pseq([0.2, 0.2, 0.2, 0.2]*0.8, inf);
	~tmSnr.source   =  Pseq([1], inf);
	~lfo1Snr.source =  Pseq([30,90,70,98, 0,110,60,20], inf);
	~lfo2Snr.source =  Pseq([0,0,110,50], inf);
//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat.source   = Pseq([Pseq([~nt+0],3),Pseq([~nt+1, ~nt+7],1)], inf);
	~amp1Hat.source  = Pseq([ 0.8], inf);
	~sus1Hat.source  = Pseq([0.03], inf);
	~tmHat.source    = Pseq([2], inf);
	~lfo1Hat.source =  Pseq([0,1,2,8, 10,11,16,20], inf);
	~lfo2Hat.source =  Pseq([0,1,11,5], inf);
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