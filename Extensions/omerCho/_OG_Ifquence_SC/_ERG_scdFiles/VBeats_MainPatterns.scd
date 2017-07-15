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