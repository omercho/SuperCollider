/*
VKeys.cc(\voiceVK,4);
*/

VKeys {
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
		~vKeys.control(chan, key, val);
	}
	*cc{|key,vel|
		var val;val=vel/127;
		key.switch(
			\expresVK, {this.md(~expres,vel);this.lbl(\TOexpresVK,val);},
			\vcoDtnVK, {this.md(~vcoDtn,vel);this.lbl(\TOvcoDtnVK,val);},
			\vcoPortVK, {this.md(~vcoPort,vel);this.lbl(\TOvcoPortVK,val);},
			\vcoEgVK, {this.md(~vcoEg,vel);this.lbl(\TOvcoEgVK,val);},
			\vcfCutVK, {this.md(~vcfCut,vel);this.lbl(\TOvcfCutVK,val);},
			\vcfEgVK, {this.md(~vcfEg,vel);this.lbl(\TOvcfEgVK,val);},
			\lfoRateVK, {this.md(~lfoRate,vel);this.lbl(\TOlfoRateVK,val);},
			\lfoPitchVK, {this.md(~lfoPitch,vel);this.lbl(\TOlfoPitchVK,val);},
			\lfoCutVK, {this.md(~lfoCut,vel);this.lbl(\TOlfoCutVK,val);},
			\envAttVK, {this.md(~envAtt,vel);this.lbl(\TOenvAttVK,val);},
			\envDecVK, {this.md(~envDec,vel);this.lbl(\TOenvDecVK,val);},
			\envSusVK, {this.md(~envSus,vel);this.lbl(\TOenvSusVK,val);},
			\dlyTimeVK, {this.md(~dlyTime,vel);this.lbl(\TOdlyTimeVK,val);},
			\dlyFeedVK, {this.md(~dlyFeed,vel);this.lbl(\TOdlyFeedVK,val);},
			\voiceVK,{
				//if ( (vel)==6, {~voiceVKCnt=0;vel=0;},{~voiceVKCnt=~voiceVKCnt});
				~voiceVKCnt-1;
				this.md(~voice,~voiceVKLst[vel]); this.lbl(\TOvoiceVKlbl,~voiceVKLblLst[vel]);
				//~voiceVKCnt=vel+1;
			},
		);
	}
	*oscResp{|respName,oscName,playTag|
		var currentBpm=1;
		OSCdef(respName, {|msg|
			var val,vel;
			val=msg[1];
			vel=val*127;
			playTag.switch(
				'expresVK_T',{ this.cc(\expresVK,vel);},
				'vcoDtnVK_T',{ this.cc(\vcoDtnVK,vel);},
				'vcoPortVK_T',{ this.cc(\vcoPortVK,vel);},
				'vcoEgVK_T',{ this.cc(\vcoEgVK,vel);},
				'vcfCutVK_T',{ this.cc(\vcfCutVK,vel);},
				'vcfEgVK_T',{ this.cc(\vcfEgVK,vel);},
				'lfoRateVK_T',{ this.cc(\lfoRateVK,vel);},
				'lfoPitchVK_T',{ this.cc(\lfoPitchVK,vel);},
				'lfoCutVK_T',{ this.cc(\lfoCutVK,vel);},
				'envAttVK_T',{ this.cc(\envAttVK,vel);},
				'envDecVK_T',{ this.cc(\envDecVK,vel);},
				'envSusVK_T',{ this.cc(\envSusVK,vel);},
				'dlyTimeVK_T',{ this.cc(\dlyTimeVK,vel);},
				'dlyFeedVK_T',{ this.cc(\dlyFeedVK,vel);},
				'voiceVK_T',{
					if ( msg[1]==1, {
						if ( (~voiceVKCnt)==6, {~voiceVKCnt=0;},{~voiceVKCnt=~voiceVKCnt});
						~voiceVKCnt.switch(~voiceVKCnt,{this.cc(\voiceVK,~voiceVKCnt);});
						~voiceVKCnt = ~voiceVKCnt + 1;
					});
				},
			)
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\expresVKResp, oscName:\TOexpresVK, playTag:'expresVK_T');
		this.oscResp(respName:\vcoDtnVKResp, oscName:\TOvcoDtnVK, playTag:'vcoDtnVK_T');
		this.oscResp(respName:\vcoPortVKResp, oscName:\TOvcoPortVK, playTag:'vcoPortVK_T');
		this.oscResp(respName:\vcoEgVKResp, oscName:\TOvcoEgVK, playTag:'vcoEgVK_T');
		this.oscResp(respName:\vcfCutVKResp, oscName:\TOvcfCutVK, playTag:'vcfCutVK_T');
		this.oscResp(respName:\vcfEgVKResp, oscName:\TOvcfEgVK, playTag:'vcfEgVK_T');
		this.oscResp(respName:\lfoRateVKResp, oscName:\TOlfoRateVK, playTag:'lfoRateVK_T');
		this.oscResp(respName:\lfoPitchVKResp, oscName:\TOlfoPitchVK, playTag:'lfoPitchVK_T');
		this.oscResp(respName:\lfoCutVKResp, oscName:\TOlfoCutVK, playTag:'lfoCutVK_T');
		this.oscResp(respName:\envAttVKResp, oscName:\TOenvAttVK, playTag:'envAttVK_T');
		this.oscResp(respName:\envDecVKResp, oscName:\TOenvDecVK, playTag:'envDecVK_T');
		this.oscResp(respName:\envSusVKResp, oscName:\TOenvSusVK, playTag:'envSusVK_T');
		this.oscResp(respName:\dlyTimeVKResp, oscName:\TOdlyTimeVK, playTag:'dlyTimeVK_T');
		this.oscResp(respName:\dlyFeedVKResp, oscName:\TOdlyFeedVK, playTag:'dlyFeedVK_T');
		this.oscResp(respName:\voiceVKResp, oscName:\TOvoiceVK, playTag:'voiceVK_T');
	}

	*globals{
		//~vKeys = MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN2");

		this.makeOSCResponders;
		~vcoDtn=42;~vcoPort=5;~vcoEg=43;
		~vcfCut=44;~vcfEg=45;~lfoRate=46;~lfoPitch=47;~lfoCut=48;
		~envAtt=49;~envDec=50;~envSus=51;
		~dlyTime=52;~dlyFeed=53;
		~expres=11;~octVK=41;
		~voice=40;
		//~voice nob
		~poly  = 0;    // 0  - 12
		~uni   = 13;   //13  - 37
		~octav = 38;   //38  - 62
		~fifth = 63;   //63  - 87
		~uniR  = 88;   //88  - 112
		~polyR = 113;  //113 - 127
		//octave nob
		~oct1  = 0;     // 0  - 21
		~oct2  = 22;    // 22  - 21
		~oct3  = 44;    // 44  - 21
		~oct4  = 66;    // 66  - 21
		~oct5  = 88;    // 88  - 21
		~oct6  = 110;    // 110  - 127

		~voiceVKLblLst = [\POLY, \UNI, \OCTAVE, \FIFTH, \UniRing, \PolyRing];
		~voiceVKLst = [0, 13, 38, 63, 88, 113];
		~voiceVKCnt=0;
	}

	*preSet01 {
		VKeys.cc(\voiceVK,1);/*0-6*/
		VKeys.cc(\expresVK,124);
		VKeys.cc(\vcoDtnVK,4);
		VKeys.cc(\vcoPortVK,5);
		VKeys.cc(\vcoEgVK,24);

		VKeys.cc(\vcfCutVK,24);
		VKeys.cc(\vcfEgVK,84);

		VKeys.cc(\lfoRateVK,84);
		VKeys.cc(\lfoPitchVK,8);
		VKeys.cc(\lfoCutVK,84);

		VKeys.cc(\envAttVK,2);
		VKeys.cc(\envDecVK,74);
		VKeys.cc(\envSusVK,104);

		VKeys.cc(\dlyTimeVK,44);
		VKeys.cc(\dlyFeedVK,64);
	}

	*preSet02 {


		~vKeys.control(0, ~expres, 127); //expression

		~vKeys.control(0, ~voice, ~poly); //voice
		~vKeys.control(0, ~octVK, ~oct3); //octave

		~vKeys.control(0, ~vcoDtn, 0); //detune
		~vKeys.control(0, ~vcoPort, 0); // portamento
		~vKeys.control(0, ~vcoEg, 0); // VCOsculator Envelope Intencity

		~vKeys.control(0, ~vcfCut, 50); //VCFilter CutOff
		~vKeys.control(0, ~vcfEg, 75); //VCFilter Envelope Intencity

		~vKeys.control(0, ~lfoRate, 0); //LFO Rate
		~vKeys.control(0, ~lfoPitch, 0); //LFO Pitch Intencity
		~vKeys.control(0, ~lfoCut, 0); //LFO CutOff Intencity

		~vKeys.control(0, ~envAtt, 0); //Envelope Generator Attack
		~vKeys.control(0, ~envDec, 10); //Envelope Generator Decay/Release
		~vKeys.control(0, ~envSus, 10); //Envelope Generator Sustain

		~vKeys.control(0, ~dlyTime, 60); //Delay Time
		~vKeys.control(0, ~dlyFeed, 0); //Delay FeedBack

	}

	*killAll {

		~vKeys.allNotesOff(0);
		~vKeys.allNotesOff(1);
		~vKeys.allNotesOff(2);
		~vKeys.allNotesOff(3);
		~vKeys.allNotesOff(4);
		~vKeys.allNotesOff(5);
		~vKeys.allNotesOff(6);
		~vKeys.allNotesOff(7);
		~vKeys.allNotesOff(8);
		~vKeys.allNotesOff(9);
		~vKeys.allNotesOff(10);
		~vKeys.allNotesOff(11);
		~vKeys.allNotesOff(12);
		~vKeys.allNotesOff(13);
		~vKeys.allNotesOff(14);
		~vKeys.allNotesOff(15);
		~vKeys.allNotesOff(16);

	}

}