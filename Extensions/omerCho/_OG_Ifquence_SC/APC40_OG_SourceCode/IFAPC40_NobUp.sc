/*
PostAllMIDI.on;
PostAllMIDI.off;
IFAPC40_NobUp.load;
IFAPC40_NobUp.globals;
IFAPC40_NobUp.resetLeds;
IFAPC40_NobUp.cueNob;
IFAPC40_NobUp.mode(1);

*/

IFAPC40_NobUp{
	*load{

		this.globals;
		this.resetLeds;
		this.mode(1);
		this.nobUModes(1);
		this.update;
	}//loadAtStart


	*globals{
		//NobDown Nums
		~nobU1=48;~nobU2=49;~nobU3=50;~nobU4=51;
		~nobU5=52;~nobU6=53;~nobU7=54;~nobU8=55;
		~nU_m1Num=87;
		~nU_m2Num=88;
		~nU_m3Num=89;
		~nU_m4Num=90;

		//Proxies-------------------
		//mode:1
		this.md1SetVals(v1:0.0,v2:0.2,v3:0.0,v4:0.3,v5:0.3,v6:0.5,v7:0.1,v8:0.1);
		/*~nobU1_m1Val=0;~nobU2_m1Val=0;~nobU3_m1Val=0;~nobU4_m1Val=0;
		~nobU5_m1Val=0;~nobU6_m1Val=0;~nobU7_m1Val=0;~nobU8_m1Val=0;*/
		//mode:2
		this.md2SetVals(v1:0.2,v2:0.2,v3:0.2,v4:0.2,v5:0.2,v6:0.2,v7:0.2,v8:0.2);
		/*~nobU1_m2Val=0;~nobU2_m2Val=0;~nobU3_m2Val=0;~nobU4_m2Val=0;
		~nobU5_m2Val=0;~nobU6_m2Val=0;~nobU7_m2Val=0;~nobU8_m2Val=0;*/


	}//globals


	*nobUModes{|mode|
		~nobUModes_APC.free;
		~nobUModes_APC=MIDIFunc.noteOn( {
			arg vel,ccNum;

			ccNum.switch(
				~nU_m1Num,{
					"nobUp Mode 1".postln;
					IFAPC40_NobUp.mode(1);
					~nUModeCase=1;
				},
				~nU_m2Num,{
					"nobUp Mode 2".postln;
					IFAPC40_NobUp.mode(2);
					~nUModeCase=2;
				},
				~nU_m3Num,{"NU_M1_3".postln+vel.postln;},
				~nU_m4Num,{"NU M1_4".postln+vel.postln;},
				~nU_m5Num,{"NU M1_5".postln+vel.postln;},
				~nU_m6Num,{"NU M1_6".postln+vel.postln;},
				~nU_m7Num,{"NU M1_7".postln+vel.postln;},
				~nU_m8Num,{"NU M1_8".postln+vel.postln;}
			);

		},srcID:~apc40InID, chan:0);

	}

	*update{

		~nUModeCase.switch(
			1,{
				~apc40.control(0, ~nobU1, ~nobU1_m1Val);
				~apc40.control(0, ~nobU2, ~nobU2_m1Val);
				~apc40.control(0, ~nobU3, ~nobU3_m1Val);
				~apc40.control(0, ~nobU4, ~nobU4_m1Val);
				~apc40.control(0, ~nobU5, ~nobU5_m1Val);
				~apc40.control(0, ~nobU6, ~nobU6_m1Val);
				~apc40.control(0, ~nobU7, ~nobU7_m1Val);
				~apc40.control(0, ~nobU8, ~nobU8_m1Val);
			},
			2,{

				~apc40.control(0, ~nobU1, ~nobU1_m2Val);
				~apc40.control(0, ~nobU2, ~nobU2_m2Val);
				~apc40.control(0, ~nobU3, ~nobU3_m2Val);
				~apc40.control(0, ~nobU4, ~nobU4_m2Val);
				~apc40.control(0, ~nobU5, ~nobU5_m2Val);
				~apc40.control(0, ~nobU6, ~nobU6_m2Val);
				~apc40.control(0, ~nobU7, ~nobU7_m2Val);
				~apc40.control(0, ~nobU8, ~nobU8_m2Val);


			}
		);


	}
	*mode{|index|
		index.switch(
			1,{
				IFAPC40_NobUp.butLeds(1,0,0,0);
				IFAPC40_NobUp.md1(1,~nobU1_m1Val);
				IFAPC40_NobUp.md1(2,~nobU2_m1Val);
				IFAPC40_NobUp.md1(3,~nobU3_m1Val);
				IFAPC40_NobUp.md1(5,~nobU5_m1Val);
				IFAPC40_NobUp.md1(6,~nobU6_m1Val);
				IFAPC40_NobUp.md1(7,~nobU7_m1Val);
				IFAPC40_NobUp.md1(4,~nobU4_m1Val);
				IFAPC40_NobUp.md1(8,~nobU8_m1Val);
				~apc40.control(0, ~nobU1, ~nobU1_m1Val); //NobUp 1
				~apc40.control(0, ~nobU2, ~nobU2_m1Val); //NobUp 2
				~apc40.control(0, ~nobU3, ~nobU3_m1Val); //NobUp 3
				~apc40.control(0, ~nobU4, ~nobU4_m1Val); //NobUp 4
				~apc40.control(0, ~nobU5, ~nobU5_m1Val); //NobUp 5
				~apc40.control(0, ~nobU6, ~nobU6_m1Val); //NobUp 6
				~apc40.control(0, ~nobU7, ~nobU7_m1Val); //NobUp 7
				~apc40.control(0, ~nobU8, ~nobU8_m1Val); //NobUp 8
				~nobUp_APC.free;
				~nobUp_APC=MIDIFunc.cc( {
					arg vel,ccNum;
					ccNum.switch(
						~nobU1,{IFAPC40_NobUp.md1(index:1, val:vel);},
						~nobU2,{IFAPC40_NobUp.md1(index:2, val:vel);},
						~nobU3,{IFAPC40_NobUp.md1(index:3, val:vel);},
						~nobU4,{IFAPC40_NobUp.md1(index:4, val:vel);},
						~nobU5,{IFAPC40_NobUp.md1(index:5, val:vel);},
						~nobU6,{IFAPC40_NobUp.md1(index:6, val:vel);},
						~nobU7,{IFAPC40_NobUp.md1(index:7, val:vel);},
						~nobU8,{IFAPC40_NobUp.md1(index:8, val:vel);}
					);
				},srcID:~apc40InID, chan:0);
			},
			2,{
				IFAPC40_NobUp.butLeds(0,1,0,0);
				IFAPC40_NobUp.md2(1,~nobU1_m2Val);
				IFAPC40_NobUp.md2(2,~nobU2_m2Val);
				IFAPC40_NobUp.md2(3,~nobU3_m2Val);
				IFAPC40_NobUp.md2(4,~nobU4_m2Val);
				IFAPC40_NobUp.md2(5,~nobU5_m2Val);
				IFAPC40_NobUp.md2(6,~nobU6_m2Val);
				IFAPC40_NobUp.md2(7,~nobU7_m2Val);
				IFAPC40_NobUp.md2(8,~nobU8_m2Val);
				~apc40.control(0, ~nobU1, ~nobU1_m2Val);
				~apc40.control(0, ~nobU2, ~nobU2_m2Val);
				~apc40.control(0, ~nobU3, ~nobU3_m2Val);
				~apc40.control(0, ~nobU4, ~nobU4_m2Val);
				~apc40.control(0, ~nobU5, ~nobU5_m2Val);
				~apc40.control(0, ~nobU6, ~nobU6_m2Val);
				~apc40.control(0, ~nobU7, ~nobU7_m2Val);
				~apc40.control(0, ~nobU8, ~nobU8_m2Val);
				~nobUp_APC.free;
				~nobUp_APC=MIDIFunc.cc( {
					arg vel,ccNum;

					ccNum.switch(
						~nobU1,{IFAPC40_NobUp.md2(index:1, val:vel);},
						~nobU2,{IFAPC40_NobUp.md2(index:2, val:vel);},
						~nobU3,{IFAPC40_NobUp.md2(index:3, val:vel);},
						~nobU4,{IFAPC40_NobUp.md2(index:4, val:vel);},
						~nobU5,{IFAPC40_NobUp.md2(index:5, val:vel);},
						~nobU6,{IFAPC40_NobUp.md2(index:6, val:vel);},
						~nobU7,{IFAPC40_NobUp.md2(index:7, val:vel);},
						~nobU8,{IFAPC40_NobUp.md2(index:8, val:vel);}
					);

				},srcID:~apc40InID, chan:0);
			},
		);

	}
	//NobUp Mode:1
	*md1SetVals{|v1=0.0,v2=0.5,v3=0.0,v4=0.3,v5=0.3,v6=0.5,v7=0.1,v8=0.1|
		//mode:1
		~nobU1_m1Val=v1;~apc40.control(~apcLn1, ~nobU1, ~nobU1_m1Val*127);
		~nobU2_m1Val=v2;~apc40.control(~apcLn1, ~nobU2, ~nobU2_m1Val*127);
		~nobU3_m1Val=v3;~apc40.control(~apcLn1, ~nobU3, ~nobU3_m1Val*127);
		~nobU4_m1Val=v4;~apc40.control(~apcLn1, ~nobU4, ~nobU4_m1Val*127);
		~nobU5_m1Val=v5;~apc40.control(~apcLn1, ~nobU5, ~nobU5_m1Val*127);
		~nobU6_m1Val=v6;~apc40.control(~apcLn1, ~nobU6, ~nobU6_m1Val*127);
		~nobU7_m1Val=v7;~apc40.control(~apcLn1, ~nobU7, ~nobU7_m1Val*127);
		~nobU8_m1Val=v8;~apc40.control(~apcLn1, ~nobU8, ~nobU8_m1Val*127);
	}
	*md1{|index,val|
		~valueUD=val/127;
		index.switch(
			1,{
				~local.sendMsg('decKick', ~valueUD);
				~nobU1_m1Val=val;

			},
			2,{
				~local.sendMsg('decSnr', ~valueUD);
				~local.sendMsg('decHat', ~valueUD);
				~local.sendMsg('susHat', (~valueUD+0.5)/2);
				~nobU2_m1Val=val;
			},
			3,{
				~local.sendMsg('xy1Keys', ~valueUD.sin*1.5,~valueUD.sin*1.3);
				~nobU3_m1Val=val;
			},
			4,{

				~local.sendMsg('xy1Keys', ~valueUD.sin*1.5,~valueUD.sin*1.3);
				~nobU4_m1Val=val;
			},
			5,{
				~local.sendMsg('decBass', ~valueUD);
				~nobU5_m1Val=val;
			},
			6,{
				~local.sendMsg('decKeys', ~valueUD);
				~nobU6_m1Val=val;
			},
			7,{

				~local.sendMsg('decSamp', ~valueUD);
				~nobU7_m1Val=val;
			},
			8,{

				~local.sendMsg('attKeys', ~valueUD/2);
				~nobU8_m1Val=val;
			}
		);
	}
	//NobUp Mode:2
	*md2SetVals{|v1=0.2,v2=0.2,v3=0.2,v4=0.2,v5=0.2,v6=0.2,v7=0.2,v8=0.2|
		//mode:2
		~nobU1_m2Val=v1;~apc40.control(~apcLn1, ~nobU1, ~nobU1_m2Val*127);
		~nobU2_m2Val=v2;~apc40.control(~apcLn1, ~nobU2, ~nobU2_m2Val*127);
		~nobU3_m2Val=v3;~apc40.control(~apcLn1, ~nobU3, ~nobU3_m2Val*127);
		~nobU4_m2Val=v4;~apc40.control(~apcLn1, ~nobU4, ~nobU4_m2Val*127);
		~nobU5_m2Val=v5;~apc40.control(~apcLn1, ~nobU5, ~nobU5_m2Val*127);
		~nobU6_m2Val=v6;~apc40.control(~apcLn1, ~nobU6, ~nobU6_m2Val*127);
		~nobU7_m2Val=v7;~apc40.control(~apcLn1, ~nobU7, ~nobU7_m2Val*127);
		~nobU8_m2Val=v8;~apc40.control(~apcLn1, ~nobU8, ~nobU8_m2Val*127);
	}
	*md2{|index,val|
		~valueUD=val/127;
		index.switch(
			1,{
				//~local.sendMsg('decKick', ~valueUD);
				~nobU1_m2Val=val;

			},
			2,{

				~nobU2_m2Val=val;
			},
			3,{

				~nobU3_m2Val=val;
			},
			4,{
				//~local.sendMsg('susDrum',~valueUD);
				~nobU4_m2Val=val;
			},
			5,{
				//~local.sendMsg('decBass', ~valueUD);
				~nobU5_m2Val=val;
			},
			6,{
				//~local.sendMsg('decKeys', ~valueUD);
				~nobU6_m2Val=val;
			},
			7,{

				~nobU7_m2Val=val;
			},
			8,{
				~local.sendMsg('AllMasterFXxy1', ~valueUD.sin*1.5,~valueUD.sin*1.3);
				~nobU8_m2Val=val;
			}
		);
	}





	*butLed{|cc=1,led|
		~apc40.noteOn(0, 86+cc, led);
	}
	*butLeds{|led1,led2,led3,led4|
		~apc40.noteOn(0, ~nU_m1Num, led1); //But 1
		~apc40.noteOn(0, ~nU_m2Num, led2); //But 2
		~apc40.noteOn(0, ~nU_m3Num, led3); //But 3
		~apc40.noteOn(0, ~nU_m4Num, led4); //But 4

	}
	/*
	IFAPC40_NobUp.butLeds(1,0,0,0,0,0,0,0);
	IFAPC40_NobUp.nobDown(mode:2);
	*/
	*resetLeds{

	}
}

/*



*/