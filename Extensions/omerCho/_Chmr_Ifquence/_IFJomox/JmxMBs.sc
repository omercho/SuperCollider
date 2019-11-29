/*
JmxMBs.load;

~vJmxMBs.control(0, 100, 128);
*/
JmxMBs{
	*load{
		this.globals;
		this.resetCnts;
		this.loadLabelLists;
		this.makeOSCResponders;
	}
	*lbl{|key,val|
		var chan;
		~tOSCAdrr.sendMsg(key, val);
	}
	*loadLabelLists{
		~jmxOnOffLst = [0,64];
		~jmxOnOffLbLst = [\OFF, \ON];
	}
	*md{|key,val|
		var chan;
		chan=2;
		~vJmxMBs.control(chan, key, val);
	}
	*cc{|key,vel|
		var val;val=vel/127;
		key.switch(
			\tuneJmx, {this.md(~tuneJmx, vel);this.lbl(\JMXtune,val);}, //Jomox tune
			\pitchJmx, {this.md(~pitchJmx, vel);this.lbl(\JMXpitch,val);}, //Jomox pitch
			\volJmx, {this.md(~volJmx, vel);this.lbl(\JMXvol,val);}, //Jomox vol
			\attJmx, {this.md(~attJmx, vel);this.lbl(\JMXatt,val);}, //Jomox att
			\decJmx, {this.md(~decJmx, vel);this.lbl(\JMXdec,val);}, //Jomox dec
			\gateTmJmx, {this.md(~gateTmJmx, vel);this.lbl(\JMXgateTm,val);}, //Jomox gateTm
			\harmJmx, {this.md(~harmJmx, vel);this.lbl(\JMXharm,val);}, //Jomox harm
			\pulseJmx, {this.md(~pulseJmx, vel);this.lbl(\JMXpulse,val);}, //Jomox pulse
			\eqJmx, {this.md(~eqJmx, vel);this.lbl(\JMXeq,val);}, //Jomox eq
			\noiseJmx, {this.md(~noiseJmx, vel);this.lbl(\JMXnoise,val);}, //Jomox noise
			\mtlNoiseJmx, {this.md(~mtlNoiseJmx, vel);this.lbl(\JMXmtlNoise,val);}, //Jomox mtlNoise
			\compJmx, {this.md(~compJmx, vel);this.lbl(\JMXcomp,val);}, //Jomox comp
			\lfoIntJmx, {this.md(~lfoIntJmx, vel);this.lbl(\JMXlfoInt,val);}, //Jomox lfoInt
			\lfoRtJmx, {this.md(~lfoRtJmx, vel);this.lbl(\JMXlfoRt,val);}, //Jomox lfoRt
		);
	}
	*oscResp{|respName,oscName,playTag|
		var currentBpm=1;
		OSCdef(respName, {|msg|
			var val,vel;
			val=msg[1];
			vel=val*127;
			playTag.switch(
				'tuneJmxT',{ this.cc(\tuneJmx,vel);},
				'pitchJmxT',{ this.cc(\pitchJmx,vel);},
				'volJmxT',{ this.cc(\volJmx,vel);},
				'attJmxT',{ this.cc(\attJmx,vel);},
				'decJmxT',{ this.cc(\decJmx,vel);},
				'gateTmJmxT',{ this.cc(\gateTmJmx,vel);},
				'harmJmxT',{ this.cc(\harmJmx,vel);},
				'pulseJmxT',{ this.cc(\pulseJmx,vel);},
				'eqJmxT',{ this.cc(\eqJmx,vel);},
				'noiseJmxT',{ this.cc(\noiseJmx,vel);},
				'mtlNoiseJmxT',{ this.cc(\mtlNoiseJmx,vel);},
				'compJmxT',{ this.cc(\compJmx,vel);},
				'lfoIntJmxT',{ this.cc(\lfoIntJmx,vel);},
				'lfoRtJmxT',{ this.cc(\lfoRtJmx,vel);},
			)
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:'tuneJmxResp', oscName:'JMXtune', playTag:'tuneJmxT');
		this.oscResp(respName:'pitchJmxResp', oscName:'JMXpitch', playTag:'pitchJmxT');
		this.oscResp(respName:'volJmxResp', oscName:'JMXvol', playTag:'volJmxT');
		this.oscResp(respName:'attJmxResp', oscName:'JMXatt', playTag:'attJmxT');
		this.oscResp(respName:'decJmxResp', oscName:'JMXdec', playTag:'decJmxT');
		this.oscResp(respName:'gateTmJmxResp', oscName:'JMXgateTm', playTag:'gateTmJmxT');
		this.oscResp(respName:'harmJmxResp', oscName:'JMXharm', playTag:'harmJmxT');
		this.oscResp(respName:'pulseJmxResp', oscName:'JMXpulse', playTag:'pulseJmxT');
		this.oscResp(respName:'eqJmxResp', oscName:'JMXeq', playTag:'eqJmxT');
		this.oscResp(respName:'noiseJmxResp', oscName:'JMXnoise', playTag:'noiseJmxT');
		this.oscResp(respName:'mtlNoiseJmxResp', oscName:'JMXmtlNoise', playTag:'mtlNoiseJmxT');
		this.oscResp(respName:'compJmxResp', oscName:'JMXcomp', playTag:'compJmxT');
		this.oscResp(respName:'lfoIntJmxResp', oscName:'JMXlfoInt', playTag:'lfoIntJmxT');
		this.oscResp(respName:'lfoRtJmxResp', oscName:'JMXlfoRt', playTag:'lfoRtJmxT');
	}
	*resetCnts{
		//~osc1KybrdCnt=0;
	}

	*set01{
		JmxMBs.cc(\tuneJmx,124);
		JmxMBs.cc(\pitchJmx,14);
		JmxMBs.cc(\volJmx,105);
		JmxMBs.cc(\attJmx,20);
		JmxMBs.cc(\decJmx,12);
		JmxMBs.cc(\gateTmJmx,124);
		JmxMBs.cc(\harmJmx,10);
		JmxMBs.cc(\pulseJmx,50);
		JmxMBs.cc(\eqJmx,0);
		JmxMBs.cc(\noiseJmx,90);
		JmxMBs.cc(\mtlNoiseJmx,0);
		JmxMBs.cc(\compJmx,62);
		JmxMBs.cc(\lfoIntJmx,34);
		JmxMBs.cc(\lfoRtJmx,60);
	}

	*globals{
		~tuneJmx=100;
		~pitchJmx=101;
		~decJmx=102;
		~harmJmx=103;
		~pulseJmx=104;
		~noiseJmx=105;
		~attJmx=106;
		~eqJmx=107;
		~compJmx=113;
		~gateTmJmx=114;
		~mtlNoiseJmx=115;
		~volJmx=117;
		~lfoSyncJmx=120;
		~lfoOneShotJmx=123;
		~lfoIntJmx=121;
		~lfoRtJmx=122;

	}
}