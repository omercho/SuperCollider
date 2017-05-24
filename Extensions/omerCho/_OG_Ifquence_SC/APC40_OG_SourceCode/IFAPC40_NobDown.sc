/*
PostAllMIDI.on;
PostAllMIDI.off;
IFAPC40_NobDown.load;
IFAPC40_NobDown.globals;
IFAPC40_NobDown.resetLeds;
IFAPC40_NobDown.cueNob;
IFAPC40_NobDown.mode(1);

*/

IFAPC40_NobDown{
	*load{

		this.globals;
		this.resetLeds;
		this.mode(1);
		this.nobDModes(1);
		this.update;
	}//loadAtStart


	*globals{
		//NobDownn Nums
		~nobD1=16;~nobD2=17;~nobD3=18;~nobD4=19;
		~nobD5=20;~nobD6=21;~nobD7=22;~nobD8=23;
		~nD_m1Num=58;
		~nD_m2Num=59;
		~nD_m3Num=60;
		~nD_m4Num=61;
		~nD_m5Num=62;
		~nD_m6Num=63;
		~nD_m7Num=64;
		~nD_m8Num=65;
		//Proxies-------------------
		//mode:1
		this.md1SetVals(v1:0.0,v2:0.5,v3:0.0,v4:0.3,v5:0.3,v6:0.5,v7:0.1,v8:0.1);
/*		~nobD1_m1Val=0;~nobD2_m1Val=0;~nobD3_m1Val=0;~nobD4_m1Val=0;
		~nobD5_m1Val=0;~nobD6_m1Val=0;~nobD7_m1Val=0;~nobD8_m1Val=0;*/
		//mode:2
		this.md2SetVals(v1:0.2,v2:0.2,v3:0.2,v4:0.2,v5:0.2,v6:0.2,v7:0.2,v8:0.2);
/*		~nobD1_m2Val=0;~nobD2_m2Val=0;~nobD3_m2Val=0;~nobD4_m2Val=0;
		~nobD5_m2Val=0;~nobD6_m2Val=0;~nobD7_m2Val=0;~nobD8_m2Val=0;*/


	}//globals



	*nobDModes{|mode|
		~nobDModes_APC.free;
		~nobDModes_APC=MIDIFunc.noteOn( {
			arg vel,ccNum;

			ccNum.switch(
				~nD_m1Num,{
					"nobDown Mode 1".postln;
					IFAPC40_NobDown.mode(1);
					~ndModeCase=1;
				},
				~nD_m2Num,{
					"nobDown Mode 2".postln;
					IFAPC40_NobDown.mode(2);
					~ndModeCase=2;
				},
				~nD_m3Num,{"M1_3".postln+vel.postln;},
				~nD_m4Num,{"M1_4".postln+vel.postln;},
				~nD_m5Num,{"M1_5".postln+vel.postln;},
				~nD_m6Num,{"M1_6".postln+vel.postln;},
				~nD_m7Num,{"M1_7".postln+vel.postln;},
				~nD_m8Num,{"M1_8".postln+vel.postln;}
			);

		},srcID:~apc40InID, chan:0);

	}

	*update{

		~ndModeCase.switch(
			1,{
				~apc40.control(~apcLn1, ~nobD1, ~nobD1_m1Val);
				~apc40.control(~apcLn1, ~nobD2, ~nobD2_m1Val);
				~apc40.control(~apcLn1, ~nobD3, ~nobD3_m1Val);
				~apc40.control(~apcLn1, ~nobD4, ~nobD4_m1Val);
				~apc40.control(~apcLn1, ~nobD5, ~nobD5_m1Val);
				~apc40.control(~apcLn1, ~nobD6, ~nobD6_m1Val);
				~apc40.control(~apcLn1, ~nobD7, ~nobD7_m1Val);
				~apc40.control(~apcLn1, ~nobD8, ~nobD8_m1Val);
			},
			2,{

				~apc40.control(~apcLn1, ~nobD1, ~nobD1_m2Val);
				~apc40.control(~apcLn1, ~nobD2, ~nobD2_m2Val);
				~apc40.control(~apcLn1, ~nobD3, ~nobD3_m2Val);
				~apc40.control(~apcLn1, ~nobD4, ~nobD4_m2Val);
				~apc40.control(~apcLn1, ~nobD5, ~nobD5_m2Val);
				~apc40.control(~apcLn1, ~nobD6, ~nobD6_m2Val);
				~apc40.control(~apcLn1, ~nobD7, ~nobD7_m2Val);
				~apc40.control(~apcLn1, ~nobD8, ~nobD8_m2Val);


			}
		);


	}
	*mode{|index|
		index.switch(
			1,{
				//~ndModeCase=index;
				//IFAPC40_NobDown.update;
				IFAPC40_NobDown.butLeds(1,0,0,0);
				IFAPC40_NobDown.md1(1,~nobD1_m1Val);
				IFAPC40_NobDown.md1(2,~nobD2_m1Val);
				IFAPC40_NobDown.md1(3,~nobD3_m1Val);
				IFAPC40_NobDown.md1(4,~nobD4_m1Val);//--FX
				IFAPC40_NobDown.md1(5,~nobD5_m1Val);
				IFAPC40_NobDown.md1(6,~nobD6_m1Val);
				IFAPC40_NobDown.md1(7,~nobD7_m1Val);
				IFAPC40_NobDown.md1(8,~nobD8_m1Val);//--FX
				~apc40.control(~apcLn1, ~nobD1, ~nobD1_m1Val); //NobDown 1
				~apc40.control(~apcLn1, ~nobD2, ~nobD2_m1Val); //NobDown 2
				~apc40.control(~apcLn1, ~nobD3, ~nobD3_m1Val); //NobDown 3
				~apc40.control(~apcLn1, ~nobD4, ~nobD4_m1Val); //NobDown 4
				~apc40.control(~apcLn1, ~nobD5, ~nobD5_m1Val); //NobDown 5
				~apc40.control(~apcLn1, ~nobD6, ~nobD6_m1Val); //NobDown 6
				~apc40.control(~apcLn1, ~nobD7, ~nobD7_m1Val); //NobDown 7
				~apc40.control(~apcLn1, ~nobD8, ~nobD8_m1Val); //NobDown 8
				~nobDown_APC.free;
				~nobDown_APC=MIDIFunc.cc( {
					arg vel,ccNum;

					ccNum.switch(
						~nobD1,{IFAPC40_NobDown.md1(index:1, val:vel);},
						~nobD2,{IFAPC40_NobDown.md1(index:2, val:vel);},
						~nobD3,{IFAPC40_NobDown.md1(index:3, val:vel);},
						~nobD4,{IFAPC40_NobDown.md1(index:4, val:vel);},
						~nobD5,{IFAPC40_NobDown.md1(index:5, val:vel);},
						~nobD6,{IFAPC40_NobDown.md1(index:6, val:vel);},
						~nobD7,{IFAPC40_NobDown.md1(index:7, val:vel);},
						~nobD8,{IFAPC40_NobDown.md1(index:8, val:vel);}
					);

				},srcID:~apc40InID, chan:0);
			},
			2,{
				//~ndModeCase=index;
				//IFAPC40_NobDown.update;
				IFAPC40_NobDown.butLeds(0,1,0,0);
				IFAPC40_NobDown.md2(1,~nobD1_m2Val);
				IFAPC40_NobDown.md2(2,~nobD2_m2Val);
				IFAPC40_NobDown.md2(3,~nobD3_m2Val);
				IFAPC40_NobDown.md2(4,~nobD4_m2Val);
				IFAPC40_NobDown.md2(5,~nobD5_m2Val);
				IFAPC40_NobDown.md2(6,~nobD6_m2Val);
				IFAPC40_NobDown.md2(7,~nobD7_m2Val);
				IFAPC40_NobDown.md2(8,~nobD8_m2Val);
				~apc40.control(~apcLn1, ~nobD1, ~nobD1_m2Val); //NobDown 1
				~apc40.control(~apcLn1, ~nobD2, ~nobD2_m2Val); //NobDown 2
				~apc40.control(~apcLn1, ~nobD3, ~nobD3_m2Val); //NobDown 3
				~apc40.control(~apcLn1, ~nobD4, ~nobD4_m2Val); //NobDown 4
				~apc40.control(~apcLn1, ~nobD5, ~nobD5_m2Val); //NobDown 5
				~apc40.control(~apcLn1, ~nobD6, ~nobD6_m2Val); //NobDown 6
				~apc40.control(~apcLn1, ~nobD7, ~nobD7_m2Val); //NobDown 7
				~apc40.control(~apcLn1, ~nobD8, ~nobD8_m2Val); //NobDown 8
				~nobDown_APC.free;
				~nobDown_APC=MIDIFunc.cc( {
					arg vel,ccNum;

					ccNum.switch(
						~nobD1,{IFAPC40_NobDown.md2(index:1, val:vel);},
						~nobD2,{IFAPC40_NobDown.md2(index:2, val:vel);},
						~nobD3,{IFAPC40_NobDown.md2(index:3, val:vel);},
						~nobD4,{IFAPC40_NobDown.md2(index:4, val:vel);},
						~nobD5,{IFAPC40_NobDown.md2(index:5, val:vel);},
						~nobD6,{IFAPC40_NobDown.md2(index:6, val:vel);},
						~nobD7,{IFAPC40_NobDown.md2(index:7, val:vel);},
						~nobD8,{IFAPC40_NobDown.md2(index:8, val:vel);}
					);

				},srcID:~apc40InID, chan:0);
			},
		);

	}
	//NobDown Mode:1
	*md1SetVals{|v1=0.0,v2=0.5,v3=0.0,v4=0.3,v5=0.3,v6=0.5,v7=0.1,v8=0.1|
		//mode:1
		~nobD1_m1Val=v1;~apc40.control(~apcLn1, ~nobD1, ~nobD1_m1Val*127);
		~nobD2_m1Val=v2;~apc40.control(~apcLn1, ~nobD2, ~nobD2_m1Val*127);
		~nobD3_m1Val=v3;~apc40.control(~apcLn1, ~nobD3, ~nobD3_m1Val*127);
		~nobD4_m1Val=v4;~apc40.control(~apcLn1, ~nobD4, ~nobD4_m1Val*127);
		~nobD5_m1Val=v5;~apc40.control(~apcLn1, ~nobD5, ~nobD5_m1Val*127);
		~nobD6_m1Val=v6;~apc40.control(~apcLn1, ~nobD6, ~nobD6_m1Val*127);
		~nobD7_m1Val=v7;~apc40.control(~apcLn1, ~nobD7, ~nobD7_m1Val*127);
		~nobD8_m1Val=v8;~apc40.control(~apcLn1, ~nobD8, ~nobD8_m1Val*127);
	}
	*md1{|index,val|
		~valueND=val/127;
		index.switch(
			1,{
				~local.sendMsg('cutDrum', ~valueND.sin*3,~valueND.sin*2);
				~nobD1_m1Val=val;

			},
			2,{
				~local.sendMsg('noteFader', ~valueND);
				~nobD2_m1Val=val;
			},
			3,{
				~local.sendMsg('drumSends', ~valueND.sin*3,~valueND.sin*2);
				~nobD3_m1Val=val;
			},
			4,{
				~local.sendMsg('susDrum', ~valueND);
				~nobD4_m1Val=val;
			},
			5,{
				~local.sendMsg('cutAll',  ~valueND.sin*2,~valueND.sin);
				~nobD5_m1Val=val;
			},
			6,{
				~local.sendMsg('melFader', ~valueND);
				~nobD6_m1Val=val;
			},
			7,{
				~local.sendMsg('susMel', ~valueND);
				~nobD7_m1Val=val;
			},
			8,{
				~local.sendMsg('melSends', ~valueND.sin*3,~valueND.sin*2);
				~nobD8_m1Val=val;
			}
		);
	}
	//NobDown Mode:2
	*md2SetVals{|v1=0.2,v2=0.2,v3=0.2,v4=0.2,v5=0.2,v6=0.2,v7=0.2,v8=0.2|
		//mode:2
		~nobD1_m2Val=v1;~apc40.control(~apcLn1, ~nobD1, ~nobD1_m2Val*127);
		~nobD2_m2Val=v2;~apc40.control(~apcLn1, ~nobD2, ~nobD2_m2Val*127);
		~nobD3_m2Val=v3;~apc40.control(~apcLn1, ~nobD3, ~nobD3_m2Val*127);
		~nobD4_m2Val=v4;~apc40.control(~apcLn1, ~nobD4, ~nobD4_m2Val*127);
		~nobD5_m2Val=v5;~apc40.control(~apcLn1, ~nobD5, ~nobD5_m2Val*127);
		~nobD6_m2Val=v6;~apc40.control(~apcLn1, ~nobD6, ~nobD6_m2Val*127);
		~nobD7_m2Val=v7;~apc40.control(~apcLn1, ~nobD7, ~nobD7_m2Val*127);
		~nobD8_m2Val=v8;~apc40.control(~apcLn1, ~nobD8, ~nobD8_m2Val*127);
	}
	*md2{|index,val|
		~valueND=val/127;
		index.switch(
			1,{
				~local.sendMsg('lfoMulBass1', ~valueND);
				~nobD1_m2Val=val;

			},
			2,{
				~local.sendMsg('lfoMulKeys1', ~valueND);
				~nobD2_m2Val=val;
			},
			3,{
				~local.sendMsg('lfoMulSamp1', ~valueND);
				~nobD3_m2Val=val;
			},
			4,{//-FX
				~local.sendMsg('fxFader',~valueND);
				~nobD4_m2Val=val;
			},
			5,{
				~local.sendMsg('lfoMulBass2', ~valueND);
				~nobD5_m2Val=val;
			},
			6,{
				~local.sendMsg('lfoMulKeys2', ~valueND);
				~nobD6_m2Val=val;
			},
			7,{
				~local.sendMsg('lfoMulSamp2', ~valueND);
				~nobD7_m2Val=val;
			},
			8,{//-FX
				~local.sendMsg('fxDecay', ~valueND);
				~nobD8_m2Val=val;
			}
		);
	}





	*butLed{|cc=1,led|
		~apc40.noteOn(~apcLn1, 57+cc, led);
	}
	*butLeds{|led1,led2,led3,led4|
		~apc40.noteOn(~apcLn1, ~nD_m1Num, led1); //But 1
		~apc40.noteOn(~apcLn1, ~nD_m2Num, led2); //But 2
		~apc40.noteOn(~apcLn1, ~nD_m3Num, led3); //But 3
		~apc40.noteOn(~apcLn1, ~nD_m4Num, led4); //But 4
		//~apc40.noteOn(~apcLn1, ~nD_m5Num, led5); //But 5
		//~apc40.noteOn(~apcLn1, ~nD_m6Num, led6); //But 6
		//~apc40.noteOn(~apcLn1, ~nD_m7Num, led7); //But 7
		//~apc40.noteOn(~apcLn1, ~nD_m8Num, led8); //But 8
	}
	/*
	IFAPC40_NobDown.butLeds(1,0,0,0,0,0,0,0);
	IFAPC40_NobDown.nobDown(mode:2);
	*/
	*resetLeds{

	}
}

/*



*/