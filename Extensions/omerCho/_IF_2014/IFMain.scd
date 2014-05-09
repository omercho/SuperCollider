
/*
//TWELVE TONES
// 5 note scales
~scl2= Scale.minorPentatonic;   //yu
~scl2= Scale.majorPentatonic;
~scl2= Scale.ritusen;           //zhi
~scl2= Scale.egyptian;

~scl2= Scale.kumoi;
~scl2= Scale.hirajoshi;
~scl2= Scale.iwato;
~scl2= Scale.chinese;
~scl2= Scale.indian;
~scl2= Scale.pelog;

~scl2= Scale.prometheus;
~scl2= Scale.scriabin;

~scl2= Scale.gong; //MajorPentatonic
~scl2= Scale.shang; //egyptian
~scl2= Scale.jiao;
~scl2= Scale.zhi;
~scl2= Scale.yu;

// 6 note scales
~scl2= Scale.whole;
~scl2= Scale.augmented;
~scl2= Scale.augmented2;

//Partch's Otonalitiew and Utonalities
~scl2= Scale.partch_o1;
~scl2= Scale.partch_o2;
~scl2= Scale.partch_o3;
~scl2= Scale.partch_o4;
~scl2= Scale.partch_o5;
~scl2= Scale.partch_o6;
~scl2= Scale.partch_u1;
~scl2= Scale.partch_u2;
~scl2= Scale.partch_u3;
~scl2= Scale.partch_u4;
~scl2= Scale.partch_u5;
~scl2= Scale.partch_u6;

// Hexatonic modes with no tritone
~scl2= Scale.hexMajor7;
~scl2= Scale.hexDorian;
~scl2= Scale.hexPhrygian;
~scl2= Scale.hexSus;
~scl2= Scale.hexMajor6;
~scl2= Scale.hexAeolian;

// 7 Note Scales
~scl2= Scale.major; //ionian
~scl2= Scale.ionian;
~scl2= Scale.dorian;
~scl2= Scale.phrygian;
~scl2= Scale.lydian;
~scl2= Scale.mixolydian;
~scl2= Scale.aeolian;    //melodicMinorDesc
~scl2= Scale.minor;      //melodicMinorDesc
~scl2= Scale.locrian;

~scl2= Scale.harmonicMinor;
~scl2= Scale.harmonicMajor;

~scl2= Scale.melodicMinor;
~scl2= Scale.melodicMinorDesc;
~scl2= Scale.melodicMajor;

~scl2= Scale.bartok;     //MelodicMajor
~scl2= Scale.hindu;      // MelodicMajor

//Raga Modes
~scl2= Scale.todi;
~scl2= Scale.purvi;
~scl2= Scale.marva;
~scl2= Scale.bhairav;
~scl2= Scale.ahirbhairav;

~scl2= Scale.superLocrian;
~scl2= Scale.romanianMinor;
~scl2= Scale.hungarianMinor;
~scl2= Scale.neapolitanMinor;
~scl2= Scale.enigmatic;
~scl2= Scale.spanish;

//Makam Scales OC
~scl2= Scale.cargah;
~scl2= Scale.buselik;
~scl2= Scale.kurdi;
~scl2= Scale.rast;
~scl2= Scale.ussak; //beyati
~scl2= Scale.beyati;
~scl2= Scale.humayun;
~scl2= Scale.hicaz; //uzzal
~scl2= Scale.uzzal;
~scl2= Scale.zirguleliHicaz;
~scl2= Scale.huseyni;
~scl2= Scale.muhayyer; //tahir
~scl2= Scale.neva; //huseyni
~scl2= Scale.tahir;
~scl2= Scale.karcigar;
~scl2= Scale.basitSuznak;
~scl2= Scale.sipihrEski; //tahir


*/
~scl1= Scale.phrygian;~scl2= Scale.phrygian;
~tmp1=135;
~durMul = 0.5;

~keysLate=0.00;
~ablate= 0.0003;~kickLate=~ablate; ~snrLate=~ablate;~hatLate=~ablate;~bassLate=~ablate;~sampLate=~ablate;

//~nt=(-7);
~nt=(0);

~dur = PatternProxy( Pseq([1], inf));
~durP= Pseq([~dur], inf).asStream;

~dur.source = Pseq([0.5,0.75,0.125,0.5,0.75,0.5,0.5,0.75], inf);
~dur.source = Pseq([0.5,0.5,0.75,0.5,0.75, 0.5,0.5,0.75], inf);
~dur.source = Pseq([
	Pseq([0.5,0.5,0.75], 1),
	Pseq([0.5,0.75], 1),
	Pseq([0.5,0.5,0.75], 1),
	Pseq([0.5,0.75], 2)
], inf);
~dur.source = Pseq([1/2,1/3,1/4,1/5,1/3,1/2,1/2,1/7], inf);
~dur.source = Pseq([1,1,1/2,1/2,1,1/2,1/2,1/4,1/4,1/4,1/2,1/4,1/2], inf);
~dur.source = Pxrand([1,1,1,1,1/2,1/2,1/4,1/4,1/4,1/4], inf);
~dur.source = Pseq([0.5], inf);
~dur.source = Pseq([1], inf);

//////                                     - 0 -
~mainSet_00 = {
//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([~nt+0], inf);
	~amp1Kick.source  =  Pseq([0.9, 0.0], inf);
	~dur1Kick.source  =  Pseq([1], inf);
	~sus1Kick.source  =  Pseq([0.1], inf);
	~tmKick.source    =  Pseq([1], inf);
//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr.source  =  Pseq([~nt+0], inf);
	~amp1Snr.source =  Pseq([ 0.0,0.0, 0.0,0.9], inf);
	~dur1Snr.source =  Pseq([1], inf);
	~sus1Snr.source =  Pseq([0.2, 0.2, 0.2, 0.2]*0.8, inf);
	~tmSnr.source   =  Pseq([1], inf);
//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat.source   = Pseq([Pseq([~nt+3],4),Pseq([~nt+0],8)], inf);
	~amp1Hat.source  = Pseq([ 0.8, 0.6, 0.0,0.7], inf);
	~sus1Hat.source  = Pseq([0.6, 0.2, 0.3, 0.2]*0.9, inf);
	~tmHat.source    = Pseq([4,2, 2, 4], inf);
	~dur1Hat.source  = Pseq([1], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1,~nt+0,~nt+1,~nt+0,~nt+0],  inf, 3,1,0);
	~amp1Bass.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.0, 0.8],         inf, 3,1,0);
	~sus1Bass.source  =  Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*0.9,        inf, 3,1,0);
	~tmBass.source    =  Pseq([2,1,2,2], inf);
	~dur1Bass.source  =  Pseq([1], inf);
	~lfo1Bass.source =  Pseq([30,90,70,98, 0,110,60,20], inf);
	~lfo2Bass.source =  Pseq([0,0,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+1,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Keys.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.0, 0.8],         inf, 3,2,0);
	~sus1Keys.source  =  Pslide([1.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*1.1,        inf, 3,1,0);
	~tmKeys.source    =  Pseq([2,2,2,1], inf);
	~dur1Keys.source  =  Pseq([1], inf);
	~lfoRtKeys.source =  Pseq([0,0,0,90, 106], inf);
	~lfoCtKeys.source =  Pseq([0,0,0,0,120], inf);
	~vcfCtKeys.source =  Pseq([0,30,10,20,120], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pslide([~nt+0,~nt+1,~nt+1,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Samp.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.0, 0.8]*0.8,         inf, 3,3,0);
	~sus1Samp.source  =  Pslide([0.8, 0.3, 0.6, 0.7, 0.2, 0.2 ],        inf, 3,2,0);
	~tmSamp.source    =  Pseq([1,2,2,2], inf);
	~dur1Samp.source  =  Pseq([1], inf);
	~lfo1Samp.source =  Pseq([90,112,70,98, 80,110,67,120], inf);
	~lfo2Samp.source =  Pseq([60,120,80,100], inf);
};
//////                                      - 0 -

//////                                      - 1 -
~mainSet_01 = {
//CH -0- [ KICK ]
	~nt1Kick.source   =  Pseq([~nt+0], inf);
	~amp1Kick.source  =  Pseq([0.9, 0.0], inf);
	~dur1Kick.source  =  Pseq([1], inf);
	~sus1Kick.source  =  Pseq([0.1], inf);
	~tmKick.source    =  Pseq([1], inf);
//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr.source  =  Pseq([~nt+0], inf);
	~amp1Snr.source =  Pseq([ 0.0,0.0, 0.9,0.0], inf);
	~dur1Snr.source =  Pseq([1], inf);
	~sus1Snr.source =  Pseq([0.2, 0.2, 0.2, 0.2]*0.8, inf);
	~tmSnr.source   =  Pseq([2], inf);
//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat.source   = Pseq([Pseq([~nt+3],4),Pseq([~nt+0],8)], inf);
	~amp1Hat.source  = Pseq([ 0.8, 0.6, 0.0,0.7], inf);
	~sus1Hat.source  = Pseq([0.6, 0.2, 0.3, 0.2]*0.9, inf);
	~tmHat.source    = Pseq([4,2, 2, 4], inf);
	~dur1Hat.source  = Pseq([1], inf);
//CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1,~nt+0,~nt+1,~nt+0,~nt+0],  inf, 3,1,0);
	~amp1Bass.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.0, 0.8],         inf, 3,1,0);
	~sus1Bass.source  =  Pslide([0.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*0.9,        inf, 3,1,0);
	~tmBass.source    =  Pseq([2,1,2,2], inf);
	~dur1Bass.source  =  Pseq([1], inf);
	~lfo1Bass.source =  Pseq([30,90,70,98, 0,110,60,20], inf);
	~lfo2Bass.source =  Pseq([60,0,110,50], inf);
//CH -5- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+1,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Keys.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.0, 0.8],         inf, 3,2,0);
	~sus1Keys.source  =  Pslide([1.2, 0.3, 0.8, 0.7, 0.2, 0.1 ]*1.1,        inf, 3,1,0);
	~tmKeys.source    =  Pseq([2,2,2,1], inf);
	~dur1Keys.source  =  Pseq([1], inf);
	~lfoRtKeys.source =  Pseq([0,0,0,90, 106], inf);
	~lfoCtKeys.source =  Pseq([0,0,0,0,120], inf);
//CH -6- [SAMP]
	~nt1Samp.source   =  Pslide([~nt+0,~nt+1,~nt+1,~nt+0,~nt+1,~nt+0],  inf, 3,1,0);
	~amp1Samp.source  =  Pslide([0.9, 0.0, 0.8, 0.7, 0.0, 0.8]*0.8,         inf, 3,3,0);
	~sus1Samp.source  =  Pslide([0.8, 0.3, 0.6, 0.7, 0.2, 0.2 ],        inf, 3,2,0);
	~tmSamp.source    =  Pseq([1,2,2,2], inf);
	~dur1Samp.source  =  Pseq([1], inf);
	~lfo1Samp.source =  Pseq([90,112,70,98, 80,110,67,120], inf);
	~lfo2Samp.source =  Pseq([60,120,80,100], inf);
};
//////                                      - 1 -

//////                                      - 2 -
~mainSet_02 = {
// DRUM
//CH -0- [ KICK ]------------------------------- [Kick] - Ch -0- //
	~nt1Kick.source   =  Pseq([~nt+0], inf);
	~dur1Kick.source  =  Pseq([1], inf);
	~amp1Kick.source  =  Pseq([0.9], inf);
	~sus1Kick.source  =  Pseq([0.1], inf);
	~tmKick.source    =  Pseq([1,1,1,1], inf);
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
	~nt1Keys.source   =  Pslide([~nt+0,~nt+1,~nt+5,~nt+6, ~nt+8],           inf, 3,1,0);
	~dur1Keys.source  =  Pseq([1], inf);
	~amp1Keys.source  =  Pxrand([0.4, 0, 0.4, 0.6, 0.8, 0.9], inf);
	~sus1Keys.source  =  Pseq([0.1], inf);
	~tmKeys.source    =  Pxrand([2,1,2,1], inf);
// BASS     //CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1,~nt+5,~nt+6, ~nt+8],           inf, 3,1,0);
	~dur1Bass.source  =  Pseq([1], inf);
	~amp1Bass.source  =  Pseq([0, 0.8, 0, 0.7, 0, 0.5, 0, 0.9], inf);
	~sus1Bass.source  =  Pseq([0.1, 0.2, 0.4, 0.2], inf);
	~tmBass.source    =  Pxrand([1,1,2,1], inf);
//SAMPLER   //CH -5- [SAMP]
	~nt1Samp.source   =  Pslide([~nt+0,~nt+1,~nt+5,~nt+6, ~nt+4],           inf, 3,1,0);
	~dur1Samp.source  =  Pseq([1, 1, 1, 1]*1, inf);
	~amp1Samp.source  =  Pseq([0.7, 0, 0.6, 0.5], inf);
	~sus1Samp.source  =  Pseq([3.6, 0.2, 0.2, 0.2], inf);
	~tmSamp.source    =  Pseq([2,1,2,1], inf);
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

//////                                      - brdg1 -
~mainBridge_01 = {
// DRUM
//CH -0- [ KICK ]------------------------------- [Kick] - Ch -0- //
	~nt1Kick.source   =  Pseq([~nt+0], inf);
	~dur1Kick.source  =  Pseq([1], inf);
	~amp1Kick.source  =  Pseq([0.9,0.0,0.7,0], inf);
	~sus1Kick.source  =  Pseq([0.1, 1, 1,1], inf);
	~tmKick.source    =  Pseq([1,1,1,1], inf);
//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr.source  =  Pslide([~nt+0,~nt+3,~nt+0, ~nt-1,~nt+8],           inf, 2,1,0).asStream;
	~dur1Snr.source =  Pseq([1], inf);
	~amp1Snr.source =  Pslide([0.7, 0.0, 0.6, 0.0],           inf, 3,1,0).asStream;
	~sus1Snr.source =  Pseq([0.02, 1, 0.2, 0.8], inf);
	~tmSnr.source   =  Pxrand([1,4, 2, 2, 4], inf);
//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat.source   = Pseq([~nt-1,~nt+8], inf);
	~dur1Hat.source  = Pseq([1], inf);
	~amp1Hat.source  = Pseq([0.9,0.8, 0.6,0.9, 0.7,0.6, 0.8], inf);
	~sus1Hat.source  = Pseq([0.1, 1.2, 0.3, 0.2]*1.1, inf);
	~tmHat.source    = Pxrand([4,2,4,4], inf);

// Keys     //CH -4- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+3,~nt+9],           inf, 2,1,0).asStream;
	~dur1Keys.source  =  Pseq([1], inf);
	~amp1Keys.source  =  Pslide([0.7, 0.4, 0.5, 0.6,0.4,0.2,0.1],           inf, 2,4,0).asStream;
	~sus1Keys.source  =  Pseq([0.1,0.8,0.01,1.2,0.1], inf);
	~tmKeys.source    =  Pxrand([2,1,2,1], inf);
// BASS     //CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1, ~nt+7],           inf, 3,1,0).asStream;
	~dur1Bass.source  =  Pseq([1], inf);
	~amp1Bass.source  =  Pslide([0.7, 0.4, 0.5, 0.6,0.4,0.2,0.1],           inf, 3,5,0).asStream;
	~sus1Bass.source  =  Pseq([0.01, 0.1, 0.05, 0.4], inf);
	~tmBass.source    =  Pxrand([2,1,2], inf);
//SAMPLER   //CH -5- [SAMP]
	~nt1Samp.source   =  Pslide([~nt+0,~nt+13,~nt+3],           inf, 3,1,0).asStream;
	~dur1Samp.source  =  Pseq([1, 1, 1, 1]*1, inf);
	~amp1Samp.source  =  Pslide([0.7, 0.4, 0.5, 0.6,0.4,0.2,0.1],           inf, 3,1,0).asStream;
	~sus1Samp.source  =  Pseq([0.4, 0.2, 0.2, 0.2], inf);
	~tmSamp.source    =  Pxrand([2,4, 1], inf);
};
//////                                      - brdg1 -

//////                                      - brdg2 -
~mainBridge_02 = {
// DRUM
//CH -0- [ KICK ]------------------------------- [Kick] - Ch -0- //
	~nt1Kick.source   =  Pseq([~nt+0], inf);
	~dur1Kick.source  =  Pseq([1], inf);
	~amp1Kick.source  =  Pseq([0.9,0.7,0.4,0], inf);
	~sus1Kick.source  =  Pseq([0.1], inf);
	~tmKick.source    =  Pseq([1,1,1,1], inf);
//CH -1- [ Snare ]------------------------------ [Snare] - Ch -1- //
	~nt1Snr.source  =  Pslide([~nt+0,~nt+3,~nt+0, ~nt-1,~nt+8],           inf, 2,1,0).asStream;
	~dur1Snr.source =  Pseq([1], inf);
	~amp1Snr.source =  Pslide([0.7, 0.8, 0.5, 0.6],           inf, 3,1,0).asStream;
	~sus1Snr.source =  Pseq([0.2, 0.2, 0.2, 0.2], inf);
	~tmSnr.source   =  Pxrand([2,1,1, 1], inf);
//CH -2- [ HAT ]-------------------------------- [ HAT ] - Ch -2- //
	~nt1Hat.source   = Pseq([~nt-1,~nt+8], inf);
	~dur1Hat.source  = Pseq([1], inf);
	~amp1Hat.source  = Pseq([0.9,0.8, 0.6,0.9, 0.7,0.6, 0.8], inf);
	~sus1Hat.source  = Pseq([0.1, 0.2, 0.3, 0.2]*1.2, inf);
	~tmHat.source    = Pxrand([4,2,4,8], inf);

// Keys     //CH -4- [Keys]
	~nt1Keys.source   =  Pslide([~nt+0,~nt+3,~nt+9],           inf, 2,1,0).asStream;
	~dur1Keys.source  =  Pseq([1], inf);
	~amp1Keys.source  =  Pslide([0.7, 0.4, 0.5, 0.6,0.4,0.2,0.1],           inf, 2,4,0).asStream;
	~sus1Keys.source  =  Pseq([0.1,0.8,1.2], inf);
	~tmKeys.source    =  Pxrand([2,1,2,1], inf);
// BASS     //CH -4- [Bass]
	~nt1Bass.source   =  Pslide([~nt+0,~nt+1, ~nt+7],           inf, 3,1,0).asStream;
	~dur1Bass.source  =  Pseq([1], inf);
	~amp1Bass.source  =  Pslide([0.7, 0.4, 0.5, 0.6,0.4,0.2,0.1],           inf, 3,5,0).asStream;
	~sus1Bass.source  =  Pseq([0.3, 0.4, 0.2, 0.1], inf);
	~tmBass.source    =  Pxrand([2,1,2], inf);
//SAMPLER   //CH -5- [SAMP]
	~nt1Samp.source   =  Pslide([~nt+0,~nt+13,~nt+3],           inf, 3,1,0).asStream;
	~dur1Samp.source  =  Pseq([1, 1, 1, 1]*1, inf);
	~amp1Samp.source  =  Pslide([0.7, 0.4, 0.5, 0.6,0.4,0.2,0.1],           inf, 3,1,0).asStream;
	~sus1Samp.source  =  Pseq([0.6, 0.4, 0.5, 0.1], inf);
	~tmSamp.source    =  Pxrand([2,4, 1], inf);
};
//////                                      - brdg2 -