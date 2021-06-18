/*
/*
Ambk.cc;

~vAmbk.noteOn(1, 26, 111); //But 1
~vAmbk.noteOff(1, 26, 1); //But 1

*/
*/
Ambk{
	//var <>currentBpm;
	*load{
		~currentBpm=1;
		~currentBpmDiv=1;
		this.resetCnts;
		this.globals;
		this.loadLists;
		this.makeOSCResponders;
	}
	*globals{
		~pt1=0;
		~pt2=1;
		~pt3=2;
		~pt4=3;
		~pt5=4;
		~pt6=5;

		~chAbk1=0;
		~chAbk2=1;
		~chAbk3=2;
		~chAbk4=3;
		~chAbk5=4;
		~chAbk6=5;

		~ptVolABK=7;
		~ptF1CutABK=74;
		~ptF1ResABK=71;
		~ptF2CutABK=29;
		~ptF2ResABK=30;
		~ptMixABK=22;

		Ambk.multi(ch:~pt1,bnk:\a,prg:0);
	}
	*loadLists{

		~bankLst = [\a,\b,\c,\d,\e,\f,\g];

	}
	*multi{|ch=0,bnk,prg|
		bnk.switch(
			\a, {~vAmbk.control(ch, 0, /*26-51*/26);~vAmbk.program(ch, prg);},
			\b, {~vAmbk.control(ch, 0, 27);~vAmbk.program(ch, prg);},
			\c, {~vAmbk.control(ch, 0, 28);~vAmbk.program(ch, prg);},
			\d, {~vAmbk.control(ch, 0, 29);~vAmbk.program(ch, prg);},
			\e, {~vAmbk.control(ch, 0, 30);~vAmbk.program(ch, prg);},
			\f, {~vAmbk.control(ch, 0, 31);~vAmbk.program(ch, prg);},
			\g, {~vAmbk.control(ch, 0, 32);~vAmbk.program(ch, prg);},
		);
	}
	*prog{|ch,bnk,prg|
		bnk.switch(
			\a, {~vAmbk.control(ch, 0, /*0-25*/0);~vAmbk.program(ch, prg);},
			\b, {~vAmbk.control(ch, 0, 1);~vAmbk.program(ch, prg);},
			\c, {~vAmbk.control(ch, 0, 2);~vAmbk.program(ch, prg);},
			\d, {~vAmbk.control(ch, 0, 3);~vAmbk.program(ch, prg);},
			\e, {~vAmbk.control(ch, 0, 4);~vAmbk.program(ch, prg);},
			\f, {~vAmbk.control(ch, 0, 5);~vAmbk.program(ch, prg);},
			\g, {~vAmbk.control(ch, 0, 6);~vAmbk.program(ch, prg);},
		);
	}
	*bank{|chan,bank,prog|
		Ambk.prog(ch:chan,bnk:~bankLst[bank],prg:prog);
	}
	*prtBnks{|bnk1,prg1,bnk2,prg2,bnk3,prg3,bnk4,prg4,bnk5,prg5,bnk6,prg6|
		Ambk.prog(ch:~pt1,bnk:~bankLst[bnk1],prg:prg1);
		Ambk.prog(ch:~pt2,bnk:~bankLst[bnk2],prg:prg2);
		Ambk.prog(ch:~pt3,bnk:~bankLst[bnk3],prg:prg3);
		Ambk.prog(ch:~pt4,bnk:~bankLst[bnk4],prg:prg4);
		Ambk.prog(ch:~pt5,bnk:~bankLst[bnk5],prg:prg5);
		Ambk.prog(ch:~pt6,bnk:~bankLst[bnk6],prg:prg6);
	}
	*lbl{|key,val|~tOSCAdrr.sendMsg(key, val);}

	*md{|pt,cc,vel|
		pt.switch(
			\pt1, {~vAmbk.control(0, cc, vel);}, //pt1
			\pt2, {~vAmbk.control(1, cc, vel);}, //pt2
			\pt3, {~vAmbk.control(2, cc, vel);}, //pt3
			\pt4, {~vAmbk.control(3, cc, vel);}, //pt4
			\pt5, {~vAmbk.control(4, cc, vel);}, //pt5
			\pt6, {~vAmbk.control(5, cc, vel);}, //pt6

		);
	}

	*cc{|pt,key,vel|
		var val;
		val=vel/127;

		key.switch(

			//VOL
			\pt1Vol, {this.md(pt,~ptVolABK, vel);Ambk.lbl(\ABKpt1Vol,val);}, //ptVol
			\pt2Vol, {this.md(pt,~ptVolABK, vel);Ambk.lbl(\ABKpt2Vol,val);}, //ptVol
			\pt3Vol, {this.md(pt,~ptVolABK, vel);Ambk.lbl(\ABKpt3Vol,val);}, //ptVol
			\pt4Vol, {this.md(pt,~ptVolABK, vel);Ambk.lbl(\ABKpt4Vol,val);}, //ptVol
			\pt5Vol, {this.md(pt,~ptVolABK, vel);Ambk.lbl(\ABKpt5Vol,val);}, //ptVol
			\pt6Vol, {this.md(pt,~ptVolABK, vel);Ambk.lbl(\ABKpt6Vol,val);}, //ptVol
			//F1Cut
			\pt1F1Cut, {this.md(pt,~ptF1CutABK, vel);Ambk.lbl(\ABKpt1F1Cut,val);}, //ptF1Cut
			\pt2F1Cut, {this.md(pt,~ptF1CutABK, vel);Ambk.lbl(\ABKpt2F1Cut,val);}, //ptF1Cut
			\pt3F1Cut, {this.md(pt,~ptF1CutABK, vel);Ambk.lbl(\ABKpt3F1Cut,val);}, //ptF1Cut
			\pt4F1Cut, {this.md(pt,~ptF1CutABK, vel);Ambk.lbl(\ABKpt4F1Cut,val);}, //ptF1Cut
			\pt5F1Cut, {this.md(pt,~ptF1CutABK, vel);Ambk.lbl(\ABKpt5F1Cut,val);}, //ptF1Cut
			\pt6F1Cut, {this.md(pt,~ptF1CutABK, vel);Ambk.lbl(\ABKpt6F1Cut,val);}, //ptF1Cut
			//Mix
			\pt1Mix, {this.md(pt,~ptMixABK, vel);Ambk.lbl(\ABKpt1Mix,val);}, //ptMix
			\pt2Mix, {this.md(pt,~ptMixABK, vel);Ambk.lbl(\ABKpt2Mix,val);}, //ptMix
			\pt3Mix, {this.md(pt,~ptMixABK, vel);Ambk.lbl(\ABKpt3Mix,val);}, //ptMix
			\pt4Mix, {this.md(pt,~ptMixABK, vel);Ambk.lbl(\ABKpt4Mix,val);}, //ptMix
			\pt5Mix, {this.md(pt,~ptMixABK, vel);Ambk.lbl(\ABKpt5Mix,val);}, //ptMix
			\pt6Mix, {this.md(pt,~ptMixABK, vel);Ambk.lbl(\ABKpt6Mix,val);}, //ptMix


		);
	}
	*oscResp{|respName,oscName,playDir|
		var currentBpm=1;
		OSCdef(respName, {|msg|
			var val,vel, velFreq, velTune;
			val=msg[1];
			vel=val*127;
			velFreq= val*120;
			velTune= val*100;
			playDir.switch(

				'pt1VolT',{ this.cc(\pt1,\pt1Vol,vel);},
				'pt2VolT',{ this.cc(\pt2,\pt2Vol,vel);},
				'pt3VolT',{ this.cc(\pt3,\pt3Vol,vel);},
				'pt4VolT',{ this.cc(\pt4,\pt4Vol,vel);},
				'pt5VolT',{ this.cc(\pt5,\pt5Vol,vel);},
				'pt6VolT',{ this.cc(\pt6,\pt6Vol,vel);},

				'pt1F1CutT',{ this.cc(\pt1,\pt1F1Cut,vel);},
				'pt2F1CutT',{ this.cc(\pt2,\pt2F1Cut,vel);},
				'pt3F1CutT',{ this.cc(\pt3,\pt3F1Cut,vel);},
				'pt4F1CutT',{ this.cc(\pt4,\pt4F1Cut,vel);},
				'pt5F1CutT',{ this.cc(\pt5,\pt5F1Cut,vel);},
				'pt6F1CutT',{ this.cc(\pt6,\pt6F1Cut,vel);},

				'pt1MixT',{ this.cc(\pt1,\pt1Mix,vel);},
				'pt2MixT',{ this.cc(\pt2,\pt2Mix,vel);},
				'pt3MixT',{ this.cc(\pt3,\pt3Mix,vel);},
				'pt4MixT',{ this.cc(\pt4,\pt4Mix,vel);},
				'pt5MixT',{ this.cc(\pt5,\pt5Mix,vel);},
				'pt6MixT',{ this.cc(\pt6,\pt6Mix,vel);},

			);
		},path:oscName);
	}
	*makeOSCResponders{
		//ptVol
		this.oscResp(respName:'pt1VolResp', oscName:'ABKpt1Vol', playDir:'pt1VolT');
		this.oscResp(respName:'pt2VolResp', oscName:'ABKpt2Vol', playDir:'pt2VolT');
		this.oscResp(respName:'pt3VolResp', oscName:'ABKpt3Vol', playDir:'pt3VolT');
		this.oscResp(respName:'pt4VolResp', oscName:'ABKpt4Vol', playDir:'pt4VolT');
		this.oscResp(respName:'pt5VolResp', oscName:'ABKpt5Vol', playDir:'pt5VolT');
		this.oscResp(respName:'pt6VolResp', oscName:'ABKpt6Vol', playDir:'pt6VolT');
		//ptF1Cut
		this.oscResp(respName:'pt1F1CutResp', oscName:'ABKpt1F1Cut', playDir:'pt1F1CutT');
		this.oscResp(respName:'pt2F1CutResp', oscName:'ABKpt2F1Cut', playDir:'pt2F1CutT');
		this.oscResp(respName:'pt3F1CutResp', oscName:'ABKpt3F1Cut', playDir:'pt3F1CutT');
		this.oscResp(respName:'pt4F1CutResp', oscName:'ABKpt4F1Cut', playDir:'pt4F1CutT');
		this.oscResp(respName:'pt5F1CutResp', oscName:'ABKpt5F1Cut', playDir:'pt5F1CutT');
		this.oscResp(respName:'pt6F1CutResp', oscName:'ABKpt6F1Cut', playDir:'pt6F1CutT');
		//ptMix
		this.oscResp(respName:'pt1MixResp', oscName:'ABKpt1Mix', playDir:'pt1MixT');
		this.oscResp(respName:'pt2MixResp', oscName:'ABKpt2Mix', playDir:'pt2MixT');
		this.oscResp(respName:'pt3MixResp', oscName:'ABKpt3Mix', playDir:'pt3MixT');
		this.oscResp(respName:'pt4MixResp', oscName:'ABKpt4Mix', playDir:'pt4MixT');
		this.oscResp(respName:'pt5MixResp', oscName:'ABKpt5Mix', playDir:'pt5MixT');
		this.oscResp(respName:'pt6MixResp', oscName:'ABKpt6Mix', playDir:'pt6MixT');


	}

	*resetCnts{
		//~tempoDivTag=0;
		~osc1KybrdCntt=0;
	}
}
//GLOBAL PARAMETER NRPN


/*

Ambk.oscResp(respName:'pt1VolResp', oscName:'ABKpt1Vol', playDir:'pt1VolT');

~tOSCAdrr.sendMsg(\ABKpt1Vol, 0.5);
Ambk.lbl(\ABKpt1Vol,5);
Ambk.md(\pt1,~ptVolABK,10);
Ambk.cc(\pt1,\pt1Vol,0);
~vAmbk.control(0, 7, 12);

127*0.79

		~chAbk1=0;
		~chAbk2=1;
		~chAbk3=2;
		~chAbk4=3;
		~chAbk5=4;
		~chAbk6=5;

~vAmbk.noteOn( 26, 111);   //But 1
~vAmbk.noteOff( 26, 1);    //But 1

~ch=0;~vAmbk.control(~ch, 0, /*26-51*/26); ~vAmbk.program(~ch, 0);//Multi Select
~ch=0;~vAmbk.control(~ch, 0, /*0-25*/0); ~vAmbk.program(~ch, 6);//Part Select
~ch=1;~vAmbk.control(~ch, 0, /*0-25*/0); ~vAmbk.program(~ch, 22);//Part Select
~ch=2;~vAmbk.control(~ch, 0, /*0-25*/0); ~vAmbk.program(~ch, 48);//Part Select
~ch=3;~vAmbk.control(~ch, 0, /*0-25*/0); ~vAmbk.program(~ch, 61);//Part Select
~ch=4;~vAmbk.control(~ch, 0, /*0-25*/0); ~vAmbk.program(~ch, 62);//Part Select
~ch=5;~vAmbk.control(~ch, 0, /*0-25*/0); ~vAmbk.program(~ch, 63);//Part Select

Ambk.multi(ch:~pt1,bnk:\a,prg:0);
Ambk.prog(ch:~pt1,bnk:\a,prg:34);
Ambk.prog(ch:~pt2,bnk:\a,prg:62);
Ambk.prog(ch:~pt3,bnk:\a,prg:97);
Ambk.prog(ch:~pt4,bnk:\a,prg:102);
Ambk.prog(ch:~pt5,bnk:\a,prg:91);
Ambk.prog(ch:~pt6,bnk:\a,prg:33);

Ambk.prtBnks(2,5,2,97,2,123,0,123,1,21,1,61);

~vAmbk.control(~chAbk5, 0, 3);     //Bank Select (MSB)
~vAmbk.control(~chAbk5, 1, 89);    //Modulation Wheel (MSB)
~vAmbk.control(~chAbk5, 2, 89);    //Breath Controller (MSB)
~vAmbk.control(~chAbk5, 3, 40);    //env2 -> cutoff
~vAmbk.control(~chAbk5, 4, 0);     //Foot Controller (MSB)
~vAmbk.control(~chAbk5, 5, 0);     //Portamento Time (MSB)
~vAmbk.control(~chAbk5, 6, 89);    //Data Entry (MSB)
~vAmbk.control(~chAbk5, 7, 100);   //Channel Volume
~vAmbk.control(~chAbk5, 8, 60);    //Balance
~vAmbk.control(~chAbk5, 9, 18);    //LFO to filter (growl)
~vAmbk.control(~chAbk5, 10, 0);    //
~vAmbk.control(~chAbk5, 11, 89);   //
~vAmbk.control(~chAbk5, 12, 89);   //Fuzz
~vAmbk.control(~chAbk5, 13, 89);   //Crush
~vAmbk.control(~chAbk5, 14, 89);   //Osc 1 range
~vAmbk.control(~chAbk5, 15, 89);   //Osc 1 detune
~vAmbk.control(~chAbk5, 16, 89);   //Osc 1 shape
~vAmbk.control(~chAbk5, 17, 89);   //Osc 1 param
~vAmbk.control(~chAbk5, 18, 89);   //Osc 2 shape
~vAmbk.control(~chAbk5, 19, 89);   //Osc 2 param
~vAmbk.control(~chAbk5, 20, 89);   //Osc 2 range
~vAmbk.control(~chAbk5, 21, 89);   //Osc 2 detune
~vAmbk.control(~chAbk5, 22, 89);   //Mixer balance
~vAmbk.control(~chAbk5, 23, 89);   //Mixer xmod type
~vAmbk.control(~chAbk5, 24, 89);   //Mixer xmod amount
~vAmbk.control(~chAbk5, 25, 89);   //Sub shape
~vAmbk.control(~chAbk5, 26, 89);   //Sub level
~vAmbk.control(~chAbk5, 27, 89);   //Noise level
~vAmbk.control(~chAbk5, 28, 89);   //Filter mode
~vAmbk.control(~chAbk5, 29, 89);   //Filter 2 cutoff
~vAmbk.control(~chAbk5, 30, 89);   //Filter 2 resonance
~vAmbk.control(~chAbk5, 31, 89);   //Filter 2 mode
~vAmbk.control(~chAbk5, 32, 0);   //Bank Select (LSB)
~vAmbk.control(~chAbk5, 33, 64);   //Modulation Wheel (LSB)
~vAmbk.control(~chAbk5, 34, 89);   //Breath Controller (LSB)
~vAmbk.control(~chAbk5, 35, 89);   //
~vAmbk.control(~chAbk5, 36, 89);   //Foot Controller (LSB)
~vAmbk.control(~chAbk5, 37, 8);    //Portamento Time (LSB)
~vAmbk.control(~chAbk5, 38, 89);   //Data Entry (LSB)
~vAmbk.control(~chAbk5, 39, 89);   //Channel Volume (LSB)
~vAmbk.control(~chAbk5, 40, 89);   //Balance (LSB)
~vAmbk.control(~chAbk5, 41, 0);  //
~vAmbk.control(~chAbk5, 42, 89);   //Pan (LSB)
~vAmbk.control(~chAbk5, 43, 89);   //Expression (LSB)
~vAmbk.control(~chAbk5, 44, 89);   //LFO1 sync mode
~vAmbk.control(~chAbk5, 45, 89);   //LFO1 rate
~vAmbk.control(~chAbk5, 46, 89);   //LFO1 shape
~vAmbk.control(~chAbk5, 47, 89);   //LFO4 rate
~vAmbk.control(~chAbk5, 48, 89);   //LFO4 shape
~vAmbk.control(~chAbk5, 49, 89);   //
~vAmbk.control(~chAbk5, 50, 89);   //
~vAmbk.control(~chAbk5, 51, 89);   //
~vAmbk.control(~chAbk5, 52, 89);   //LFO2 sync mode
~vAmbk.control(~chAbk5, 53, 89);   //LFO2 rate
~vAmbk.control(~chAbk5, 54, 89);   //LFO2 shape
~vAmbk.control(~chAbk5, 55, 89);   //
~vAmbk.control(~chAbk5, 56, 89);   //
~vAmbk.control(~chAbk5, 57, 89);   //
~vAmbk.control(~chAbk5, 58, 89);   //
~vAmbk.control(~chAbk5, 59, 89);   //
~vAmbk.control(~chAbk5, 60, 89);   //LFO3 sync mode
~vAmbk.control(~chAbk5, 61, 89);   //LFO3 rate
~vAmbk.control(~chAbk5, 62, 89);   //LFO3 shape
~vAmbk.control(~chAbk5, 63, 89);   //
~vAmbk.control(~chAbk5, 64, 89);   //Sustain Pedal HOLD
~vAmbk.control(~chAbk5, 65, 89);   //
~vAmbk.control(~chAbk5, 66, 89);   //
~vAmbk.control(~chAbk5, 67, 89);   //
~vAmbk.control(~chAbk5, 68, 89);   //Legato Footswitch  -  Legato on / off
~vAmbk.control(~chAbk5, 69, 89);   //
~vAmbk.control(~chAbk5, 70, 89);   //ENV1 S
~vAmbk.control(~chAbk5, 71, 89);   //Filter 1 resonance
~vAmbk.control(~chAbk5, 72, 89);   //ENV1 R
~vAmbk.control(~chAbk5, 73, 89);   //ENV1 A
~vAmbk.control(~chAbk5, 74, 89);   //Filter 1 cutoff
~vAmbk.control(~chAbk5, 75, 89);   //ENV1 D
~vAmbk.control(~chAbk5, 76, 89);   //
~vAmbk.control(~chAbk5, 77, 89);   //
~vAmbk.control(~chAbk5, 78, 89);   //ENV2 S
~vAmbk.control(~chAbk5, 79, 89);   //
~vAmbk.control(~chAbk5, 80, 89);   //ENV2 R
~vAmbk.control(~chAbk5, 81, 89);   //ENV2 A
~vAmbk.control(~chAbk5, 82, 89);   //
~vAmbk.control(~chAbk5, 83, 89);   //ENV2 D
~vAmbk.control(~chAbk5, 84, 89);   //
~vAmbk.control(~chAbk5, 85, 89);   //
~vAmbk.control(~chAbk5, 86, 89);   //ENV3 S
~vAmbk.control(~chAbk5, 87, 89);   //
~vAmbk.control(~chAbk5, 88, 89);   //ENV3 R
~vAmbk.control(~chAbk5, 89, 89);   //ENV3 A
~vAmbk.control(~chAbk5, 90, 89);   //
~vAmbk.control(~chAbk5, 91, 89);   //ENV3 D
~vAmbk.control(~chAbk5, 92, 89);   //
~vAmbk.control(~chAbk5, 93, 89);   //
~vAmbk.control(~chAbk5, 94, 89);   //Part tuning
~vAmbk.control(~chAbk5, 95, 89);   //Tuning spread
~vAmbk.control(~chAbk5, 96, 89);   //
~vAmbk.control(~chAbk5, 97, 89);   //
~vAmbk.control(~chAbk5, 98, 89);   //
~vAmbk.control(~chAbk5, 99, 89);   //
~vAmbk.control(~chAbk5, 100, 89);  //
~vAmbk.control(~chAbk5, 101, 89);  //
~vAmbk.control(~chAbk5, 102, 89);  //Arp mode --
~vAmbk.control(~chAbk5, 103, 89);  //Arp direction
~vAmbk.control(~chAbk5, 104, 89);  //Arp octave
~vAmbk.control(~chAbk5, 105, 89);  //Arp pattern
~vAmbk.control(~chAbk5, 106, 89);  //Arp resolution
~vAmbk.control(~chAbk5, 107, 89);  //Polyphony mode
~vAmbk.control(~chAbk5, 108, 89);  //
~vAmbk.control(~chAbk5, 109, 89);  //
~vAmbk.control(~chAbk5, 110, 89);  //
~vAmbk.control(~chAbk5, 111, 89);  //
~vAmbk.control(~chAbk5, 112, 89);  //
~vAmbk.control(~chAbk5, 113, 89);  //
~vAmbk.control(~chAbk5, 114, 89);  //
~vAmbk.control(~chAbk5, 115, 89);  //
~vAmbk.control(~chAbk5, 116, 89);  //
~vAmbk.control(~chAbk5, 117, 89);  //
~vAmbk.control(~chAbk5, 118, 89);  //
~vAmbk.control(~chAbk5, 119, 89);  //
~vAmbk.control(~chAbk5, 120, 89);  //All Sound Off
~vAmbk.control(~chAbk5, 121, 89);  //Reset All Controllers
~vAmbk.control(~chAbk5, 122, 89);  //Local Control On/Off
~vAmbk.control(~chAbk5, 123, 89);  //All Notes Off
~vAmbk.control(~chAbk5, 124, 89);  //Omni Mode Off
~vAmbk.control(~chAbk5, 125, 89);  //Omni Mode On
~vAmbk.control(~chAbk5, 126, 89);  //Poly Mode Off
~vAmbk.control(~chAbk5, 127, 89);  //Poly Mode On

*/