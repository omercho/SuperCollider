VBass {
	var <>ortTime = 1;
	classvar <>counter3=0, counter18=0;

	*initClass {
		StartUp add: {
		/*Server.default.doWhenBooted({ this.globals; this.preSet01; });*/
		}
	}
	*lbl{|key,val|
		var chan;
		~tOSCAdrr.sendMsg(key, val);
	}
	*md{|key,val|
		var chan;
		chan=0;
		~vBass.control(chan, key, val);
	}
	*cc{|key,vel|
		var val;val=vel/127;
		key.switch(
			\expresVB, {this.md(~exprVB,vel);this.lbl(\TOexpresVB,val);},
			\vco1VB, {this.md(~vco1,vel);this.lbl(\TOvco1VB,val);},
			\vco2VB, {this.md(~vco2,vel);this.lbl(\TOvco2VB,val);},
			\vco3VB, {this.md(~vco3,vel);this.lbl(\TOvco3VB,val);},
			\vcfCutVB, {this.md(~vcfCutVB,vel);this.lbl(\TOvcfCutVB,val);},
			\lfoRateVB, {this.md(~lfoRateVB,vel);this.lbl(\TOlfoRateVB,val);},
			\lfoIntVB, {this.md(~lfoIntVB,vel);this.lbl(\TOlfoIntVB,val);},
			\envAttVB, {this.md(~envAttVB,vel);this.lbl(\TOenvAttVB,val);},
			\envDecVB, {this.md(~envDecVB,vel);this.lbl(\TOenvDecVB,val);},
			\slideTmVB, {this.md(~slideTm,vel);this.lbl(\TOslideTmVB,val);},
			\gateTmVB, {this.md(~gateTm,vel);this.lbl(\TOgateTmVB,val);},
		);
	}
	*oscResp{|respName,oscName,playTag|
		var currentBpm=1;
		OSCdef(respName, {|msg|
			var val,vel;
			val=msg[1];
			vel=val*127;
			playTag.switch(
				'expresVB_T',{ this.cc(\expresVB,vel);},
				'vco1VB_T',{ this.cc(\vco1VB,vel);},
				'vco2VB_T',{ this.cc(\vco2VB,vel);},
				'vco3VB_T',{ this.cc(\vco3VB,vel);},
				'vcfCutVB_T',{ this.cc(\vcfCutVB,vel);},
				'lfoRateVB_T',{ this.cc(\lfoRateVB,vel);},
				'lfoIntVB_T',{ this.cc(\lfoIntVB,vel);},
				'envAttVB_T',{ this.cc(\envAttVB,vel);},
				'envDecVB_T',{ this.cc(\envDecVB,vel);},
				'slideTmVB_T',{ this.cc(\slideTmVB,vel);},
				'gateTmVB_T',{ this.cc(\gateTmVB,vel);},
			)
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\expresVBResp, oscName:\TOexpresVB, playTag:'expresVB_T');
		this.oscResp(respName:\vco1VBResp, oscName:\TOvco1VB, playTag:'vco1VB_T');
		this.oscResp(respName:\vco2VBResp, oscName:\TOvco2VB, playTag:'vco2VB_T');
		this.oscResp(respName:\vco3VBResp, oscName:\TOvco3VB, playTag:'vco3VB_T');
		this.oscResp(respName:\vcfCutVBResp, oscName:\TOvcfCutVB, playTag:'vcfCutVB_T');
		this.oscResp(respName:\lfoRateVBResp, oscName:\TOlfoRateVB, playTag:'lfoRateVB_T');
		this.oscResp(respName:\lfoIntVBResp, oscName:\TOlfoIntVB, playTag:'lfoIntVB_T');
		this.oscResp(respName:\envAttVBResp, oscName:\TOenvAttVB, playTag:'envAttVB_T');
		this.oscResp(respName:\envDecVBResp, oscName:\TOenvDecVB, playTag:'envDecVB_T');
		this.oscResp(respName:\slideTmVBResp, oscName:\TOslideTmVB, playTag:'slideTmVB_T');
		this.oscResp(respName:\gateTmVBResp, oscName:\TOgateTmVB, playTag:'gateTmVB_T');
	}
	*globals{
		//~vBass = MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN1");
		VBass.makeOSCResponders;
		~exprVB=11; ~octVB=40; ~lfoRateVB=41; ~lfoIntVB=42;
		~vco1=43; ~vco2=44; ~vco3=45;
		~envAttVB=46; ~envDecVB=47; ~vcfCutVB=48; ~slideTm=5; ~gateTm=49;

		//octave nob
		~oct1  = 0;     // 0  - 21
		~oct2  = 22;    // 22  - 21
		~oct3  = 44;    // 44  - 21
		~oct4  = 66;    // 66  - 21
		~oct5  = 88;    // 88  - 21
		~oct6  = 110;    // 110  - 127
	}
	*preSet01 {
		VBass.cc(\expresVB,127);
		VBass.cc(\vco1VB,64);
		VBass.cc(\vco2VB,64);
		VBass.cc(\vco3VB,64);
		VBass.cc(\vcfCutVB,64);
		VBass.cc(\lfoRateVB,5);
		VBass.cc(\lfoIntVB,24);
		VBass.cc(\envAttVB,0);
		VBass.cc(\envDecVB,12);
		VBass.cc(\slideTmVB,10);
		VBass.cc(\gateTmVB,24);
	}
	*preSet02 {
		VBass.cc(\expresVB,127);
		VBass.cc(\vco1VB,64);
		VBass.cc(\vco2VB,64);
		VBass.cc(\vco3VB,64);
		VBass.cc(\vcfCutVB,54);
		VBass.cc(\lfoRateVB,10);
		VBass.cc(\lfoIntVB,84);
		VBass.cc(\envAttVB,2);
		VBass.cc(\envDecVB,12);
		VBass.cc(\slideTmVB,17);
		VBass.cc(\gateTmVB,24);
	}
	*killAll {
		~vBass.allNotesOff(0);
		~vBass.allNotesOff(1);
		~vBass.allNotesOff(2);
		~vBass.allNotesOff(3);
		~vBass.allNotesOff(4);
		~vBass.allNotesOff(5);
		~vBass.allNotesOff(6);
		~vBass.allNotesOff(7);
		~vBass.allNotesOff(8);
		~vBass.allNotesOff(9);
		~vBass.allNotesOff(10);
		~vBass.allNotesOff(11);
		~vBass.allNotesOff(12);
		~vBass.allNotesOff(13);
		~vBass.allNotesOff(14);
		~vBass.allNotesOff(15);
		~vBass.allNotesOff(16);
	}

}