IFLfo{
	*load{this.defaults;}
	*defaults{}
	//Bass
	*setBassOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8,stp9,stp10,stp11,stp12,stp13,stp14,stp15,stp16|
		~lfo1Bass.source  = Pseq([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
		~lfo2Bass.source  = Pseq([
			(stp9),(stp10),(stp11),(stp12),
			(stp13),(stp14),(stp15),(stp16)
		], inf);
	}
	*setBassOff{
		~lfo1Bass.source  = Pseq([0], inf);
		~lfo2Bass.source  = Pseq([0], inf);
	}
	*setBass{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8,stp9,stp10,stp11,stp12,stp13,stp14,stp15,stp16|
		~lfoBassBut.free;
		~countLfoBass=0;
		~lfoBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~countShufBass = ~countShufBass + 1;

				this.setBassOn(
					stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8,
					stp9,stp10,stp11,stp12,stp13,stp14,stp15,stp16
				);
			},{
				this.setBassOff;
			}
			);
		},
		'/lfoBass'
		);
	}
	//Keys
	*setKeysOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8,stp9,stp10,stp11,stp12,stp13,stp14,stp15,stp16|
		~lfo1Keys.source  = Pseq([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
		~lfo2Keys.source  = Pseq([
			(stp9),(stp10),(stp11),(stp12),
			(stp13),(stp14),(stp15),(stp16)
		], inf);
	}
	*setKeysOff{
		~lfo1Keys.source  = Pseq([0], inf);
		~lfo2Keys.source  = Pseq([0], inf);
	}
	*setKeys{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8,stp9,stp10,stp11,stp12,stp13,stp14,stp15,stp16|
		~lfoKeysBut.free;
		~countLfoKeys=0;
		~lfoKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~countShufKeys = ~countShufKeys + 1;

				this.setKeysOn(
					stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8,
					stp9,stp10,stp11,stp12,stp13,stp14,stp15,stp16
				);
			},{
				this.setKeysOff;
			}
			);
		},
		'/lfoKeys'
		);
	}
	//Samp
	*setSampOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8,stp9,stp10,stp11,stp12,stp13,stp14,stp15,stp16|
		~lfo1Samp.source  = Pseq([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
		~lfo2Samp.source  = Pseq([
			(stp9),(stp10),(stp11),(stp12),
			(stp13),(stp14),(stp15),(stp16)
		], inf);
	}
	*setSampOff{
		~lfo1Samp.source  = Pseq([0], inf);
		~lfo2Samp.source  = Pseq([0], inf);
	}
	*setSamp{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8,stp9,stp10,stp11,stp12,stp13,stp14,stp15,stp16|
		~lfoSampBut.free;
		~countLfoSamp=0;
		~lfoSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~countShufSamp = ~countShufSamp + 1;

				this.setSampOn(
					stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8,
					stp9,stp10,stp11,stp12,stp13,stp14,stp15,stp16
				);
			},{
				this.setSampOff;
			}
			);
		},
		'/lfoSamp'
		);
	}
	//Mopho
	*setMophoOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8,stp9,stp10,stp11,stp12,stp13,stp14,stp15,stp16|
		~lfo1Mopho.source  = Pseq([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
		~lfo2Mopho.source  = Pseq([
			(stp9),(stp10),(stp11),(stp12),
			(stp13),(stp14),(stp15),(stp16)
		], inf);
	}
	*setMophoOff{
		~lfo1Mopho.source  = Pseq([0], inf);
		~lfo2Mopho.source  = Pseq([0], inf);
	}
	*setMopho{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8,stp9,stp10,stp11,stp12,stp13,stp14,stp15,stp16|
		~lfoMophoBut.free;
		~countLfoMopho=0;
		~lfoMophoBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//~countShufMopho = ~countShufMopho + 1;

				this.setMophoOn(
					stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8,
					stp9,stp10,stp11,stp12,stp13,stp14,stp15,stp16
				);
			},{
				this.setMophoOff;
			}
			);
		},
		'/lfoMopho'
		);
	}

}