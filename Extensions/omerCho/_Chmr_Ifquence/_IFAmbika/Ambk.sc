/*
/*
Ambk.cc
*/
*/
Ambk{
	//var <>currentBpm;
	*load{
		~currentBpm=1;
		~currentBpmDiv=1;
		this.resetCnts;
		this.globals;
		this.makeOSCResponders;
	}
	*globals{
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

~vAmbk.control(abk1Ch, 0, 3);     //Bank Select (MSB)
~vAmbk.control(abk1Ch, 1, 89);    //Modulation Wheel (MSB)
~vAmbk.control(abk1Ch, 2, 89);    //Breath Controller (MSB)
~vAmbk.control(abk1Ch, 3, 40);    //env2 -> cutoff
~vAmbk.control(abk1Ch, 4, 0);     //Foot Controller (MSB)
~vAmbk.control(abk1Ch, 5, 0);     //Portamento Time (MSB)
~vAmbk.control(abk1Ch, 6, 89);    //Data Entry (MSB)
~vAmbk.control(abk1Ch, 7, 100);   //Channel Volume
~vAmbk.control(abk1Ch, 8, 60);    //Balance
~vAmbk.control(abk1Ch, 9, 18);    //LFO to filter (growl)
~vAmbk.control(abk1Ch, 10, 0);    //
~vAmbk.control(abk1Ch, 11, 89);   //
~vAmbk.control(abk1Ch, 12, 89);   //Fuzz
~vAmbk.control(abk1Ch, 13, 89);   //Crush
~vAmbk.control(abk1Ch, 14, 89);   //Osc 1 range
~vAmbk.control(abk1Ch, 15, 89);   //Osc 1 detune
~vAmbk.control(abk1Ch, 16, 89);   //Osc 1 shape
~vAmbk.control(abk1Ch, 17, 89);   //Osc 1 param
~vAmbk.control(abk1Ch, 18, 89);   //Osc 2 shape
~vAmbk.control(abk1Ch, 19, 89);   //Osc 2 param
~vAmbk.control(abk1Ch, 20, 89);   //Osc 2 range
~vAmbk.control(abk1Ch, 21, 89);   //Osc 2 detune
~vAmbk.control(abk1Ch, 22, 89);   //Mixer balance
~vAmbk.control(abk1Ch, 23, 89);   //Mixer xmod type
~vAmbk.control(abk1Ch, 24, 89);   //Mixer xmod amount
~vAmbk.control(abk1Ch, 25, 89);   //Sub shape
~vAmbk.control(abk1Ch, 26, 89);   //Sub level
~vAmbk.control(abk1Ch, 27, 89);   //Noise level
~vAmbk.control(abk1Ch, 28, 89);   //Filter mode
~vAmbk.control(abk1Ch, 29, 89);   //Filter 2 cutoff
~vAmbk.control(abk1Ch, 30, 89);   //Filter 2 resonance
~vAmbk.control(abk1Ch, 31, 89);   //Filter 2 mode
~vAmbk.control(abk1Ch, 32, 0);   //Bank Select (LSB)
~vAmbk.control(abk1Ch, 33, 64);   //Modulation Wheel (LSB)
~vAmbk.control(abk1Ch, 34, 89);   //Breath Controller (LSB)
~vAmbk.control(abk1Ch, 35, 89);   //
~vAmbk.control(abk1Ch, 36, 89);   //Foot Controller (LSB)
~vAmbk.control(abk1Ch, 37, 8);    //Portamento Time (LSB)
~vAmbk.control(abk1Ch, 38, 89);   //Data Entry (LSB)
~vAmbk.control(abk1Ch, 39, 89);   //Channel Volume (LSB)
~vAmbk.control(abk1Ch, 40, 89);   //Balance (LSB)
~vAmbk.control(abk1Ch, 41, 0);  //
~vAmbk.control(abk1Ch, 42, 89);   //Pan (LSB)
~vAmbk.control(abk1Ch, 43, 89);   //Expression (LSB)
~vAmbk.control(abk1Ch, 44, 89);   //LFO1 sync mode
~vAmbk.control(abk1Ch, 45, 89);   //LFO1 rate
~vAmbk.control(abk1Ch, 46, 89);   //LFO1 shape
~vAmbk.control(abk1Ch, 47, 89);   //LFO4 rate
~vAmbk.control(abk1Ch, 48, 89);   //LFO4 shape
~vAmbk.control(abk1Ch, 49, 89);   //
~vAmbk.control(abk1Ch, 50, 89);   //
~vAmbk.control(abk1Ch, 51, 89);   //
~vAmbk.control(abk1Ch, 52, 89);   //LFO2 sync mode
~vAmbk.control(abk1Ch, 53, 89);   //LFO2 rate
~vAmbk.control(abk1Ch, 54, 89);   //LFO2 shape
~vAmbk.control(abk1Ch, 55, 89);   //
~vAmbk.control(abk1Ch, 56, 89);   //
~vAmbk.control(abk1Ch, 57, 89);   //
~vAmbk.control(abk1Ch, 58, 89);   //
~vAmbk.control(abk1Ch, 59, 89);   //
~vAmbk.control(abk1Ch, 60, 89);   //LFO3 sync mode
~vAmbk.control(abk1Ch, 61, 89);   //LFO3 rate
~vAmbk.control(abk1Ch, 62, 89);   //LFO3 shape
~vAmbk.control(abk1Ch, 63, 89);   //
~vAmbk.control(abk1Ch, 64, 89);   //Sustain Pedal HOLD
~vAmbk.control(abk1Ch, 65, 89);   //
~vAmbk.control(abk1Ch, 66, 89);   //
~vAmbk.control(abk1Ch, 67, 89);   //
~vAmbk.control(abk1Ch, 68, 89);   //Legato Footswitch  -  Legato on / off
~vAmbk.control(abk1Ch, 69, 89);   //
~vAmbk.control(abk1Ch, 70, 89);   //ENV1 S
~vAmbk.control(abk1Ch, 71, 89);   //Filter 1 resonance
~vAmbk.control(abk1Ch, 72, 89);   //ENV1 R
~vAmbk.control(abk1Ch, 73, 89);   //ENV1 A
~vAmbk.control(abk1Ch, 74, 89);   //Filter 1 cutoff
~vAmbk.control(abk1Ch, 75, 89);   //ENV1 D
~vAmbk.control(abk1Ch, 76, 89);   //
~vAmbk.control(abk1Ch, 77, 89);   //
~vAmbk.control(abk1Ch, 78, 89);   //ENV2 S
~vAmbk.control(abk1Ch, 79, 89);   //
~vAmbk.control(abk1Ch, 80, 89);   //ENV2 R
~vAmbk.control(abk1Ch, 81, 89);   //ENV2 A
~vAmbk.control(abk1Ch, 82, 89);   //
~vAmbk.control(abk1Ch, 83, 89);   //ENV2 D
~vAmbk.control(abk1Ch, 84, 89);   //
~vAmbk.control(abk1Ch, 85, 89);   //
~vAmbk.control(abk1Ch, 86, 89);   //ENV3 S
~vAmbk.control(abk1Ch, 87, 89);   //
~vAmbk.control(abk1Ch, 88, 89);   //ENV3 R
~vAmbk.control(abk1Ch, 89, 89);   //ENV3 A
~vAmbk.control(abk1Ch, 90, 89);   //
~vAmbk.control(abk1Ch, 91, 89);   //ENV3 D
~vAmbk.control(abk1Ch, 92, 89);   //
~vAmbk.control(abk1Ch, 93, 89);   //
~vAmbk.control(abk1Ch, 94, 89);   //Part tuning
~vAmbk.control(abk1Ch, 95, 89);   //Tuning spread
~vAmbk.control(abk1Ch, 96, 89);   //
~vAmbk.control(abk1Ch, 97, 89);   //
~vAmbk.control(abk1Ch, 98, 89);   //
~vAmbk.control(abk1Ch, 99, 89);   //
~vAmbk.control(abk1Ch, 100, 89);  //
~vAmbk.control(abk1Ch, 101, 89);  //
~vAmbk.control(abk1Ch, 102, 89);  //Arp mode
~vAmbk.control(abk1Ch, 103, 89);  //Arp direction
~vAmbk.control(abk1Ch, 104, 89);  //Arp octave
~vAmbk.control(abk1Ch, 105, 89);  //Arp pattern
~vAmbk.control(abk1Ch, 106, 89);  //Arp resolution
~vAmbk.control(abk1Ch, 107, 89);  //Polyphony mode
~vAmbk.control(abk1Ch, 108, 89);  //
~vAmbk.control(abk1Ch, 109, 89);  //
~vAmbk.control(abk1Ch, 110, 89);  //
~vAmbk.control(abk1Ch, 111, 89);  //
~vAmbk.control(abk1Ch, 112, 89);  //
~vAmbk.control(abk1Ch, 113, 89);  //
~vAmbk.control(abk1Ch, 114, 89);  //
~vAmbk.control(abk1Ch, 115, 89);  //
~vAmbk.control(abk1Ch, 116, 89);  //
~vAmbk.control(abk1Ch, 117, 89);  //
~vAmbk.control(abk1Ch, 118, 89);  //
~vAmbk.control(abk1Ch, 119, 89);  //
~vAmbk.control(abk1Ch, 120, 89);  //All Sound Off
~vAmbk.control(abk1Ch, 121, 89);  //Reset All Controllers
~vAmbk.control(abk1Ch, 122, 89);  //Local Control On/Off
~vAmbk.control(abk1Ch, 123, 89);  //All Notes Off
~vAmbk.control(abk1Ch, 124, 89);  //Omni Mode Off
~vAmbk.control(abk1Ch, 125, 89);  //Omni Mode On
~vAmbk.control(abk1Ch, 126, 89);  //Poly Mode Off
~vAmbk.control(abk1Ch, 127, 89);  //Poly Mode On

*/