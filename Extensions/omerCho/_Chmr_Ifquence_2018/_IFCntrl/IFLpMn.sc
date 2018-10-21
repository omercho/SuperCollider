/*
~lpMn.control(0, ~stpLpBut16, 0);
PostAllMIDI.on;
PostAllMIDI.off;
*/
IFLpMn{
	*load{
		this.addr;
		this.globals;
		this.parts;
		this.shiftButton;
		this.resetLeds;
		//this.makeNoteResponders;

	}//loadAtStart
	*addr{

	}
	*globals{


		~lpMnCh=0;

		~lpMnButV1=8;~lpMnButV2=24;~lpMnButV3=40;~lpMnButV4=56;
		~lpMnButV5=72;~lpMnButV6=88;~lpMnButV7=104;~lpMnButV8=120;

		//CCResponders
		~lpMnButH1=104;~lpMnButH2=105;~lpMnButH3=106;~lpMnButH4=107;
		~lpMnButH5=108;~lpMnButH6=109;~lpMnButH7=110;~lpMnButH8=111;

		//1
		~lpMnBut1=0;~lpMnBut2=1;~lpMnBut3=2;~lpMnBut4=3;
		~lpMnBut5=4;~lpMnBut6=5;~lpMnBut7=6;~lpMnBut8=7;
		//2
		~lpMnBut9=16;~lpMnBut10=17;~lpMnBut11=18;~lpMnBut12=19;
		~lpMnBut13=20;~lpMnBut14=21;~lpMnBut15=22;~lpMnBut16=23;
		//3
		~lpMnBut17=32;~lpMnBut18=33;~lpMnBut19=34;~lpMnBut20=35;
		~lpMnBut21=36;~lpMnBut22=37;~lpMnBut23=38;~lpMnBut24=39;
		//4
		~lpMnBut25=48;~lpMnBut26=49;~lpMnBut27=50;~lpMnBut28=51;
		~lpMnBut29=52;~lpMnBut30=53;~lpMnBut31=54;~lpMnBut32=55;
		//5
		~lpMnBut33=64;~lpMnBut34=65;~lpMnBut35=66;~lpMnBut36=67;
		~lpMnBut37=68;~lpMnBut38=69;~lpMnBut39=70;~lpMnBut40=71;
		//6
		~lpMnBut41=80;~lpMnBut42=81;~lpMnBut43=82;~lpMnBut44=83;
		~lpMnBut45=84;~lpMnBut46=85;~lpMnBut47=86;~lpMnBut48=87;
		//7
		~lpMnBut49=96;~lpMnBut50=97;~lpMnBut51=98;~lpMnBut52=99;
		~lpMnBut53=100;~lpMnBut54=101;~lpMnBut55=102;~lpMnBut56=103;
		//8
		~lpMnBut57=112;~lpMnBut58=113;~lpMnBut59=114;~lpMnBut60=115;
		~lpMnBut61=116;~lpMnBut62=117;~lpMnBut63=118;~lpMnBut64=119;

		~red1=1;
		~red2=2;
		~red3=3;

		~orng1=21;//23
		~orng2=63;
		~orng3=18;//115
		~orng4=19;//83-63

		~green1=20;
		~green2=32;//96
		~green3=48;//84

		~yellow1=33;//114
		~yellow2=118;//118
		~yellow3=113;//113



	}//globals
	*shiftButton{
		//~lpMn.noteOn(0, 98, 127); //SHIFT
		~trackCase=0;
		~partCase=0;
		~lpMnShiftBut.free;
		~lpMnShiftBut=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				IFLpMn.tracks;
				~trackCase.switch(
					0,{
						//IFLpMn.tsLeds(0,0,0,0,0,0,0,0);
					},
					1, {
						//IFTrack01.apcParts;
						IFLpMn.tsLeds(1,0,0,0,0,0,0,0);
					},
					2,{
						//IFTrack02.apcParts;
						IFLpMn.tsLeds(0,1,0,0,0,0,0,0);
					},
					3,{
						//IFTrack03.apcParts;
						IFLpMn.tsLeds(0,0,1,0,0,0,0,0);
					}
				);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, noteNum:~lpMnButV1);

		~lpMnShiftButOff.free;
		~lpMnShiftButOff=MIDIFunc.noteOff({
			arg vel;
			if ( vel==0, {
				IFLpMn.tracks;
				~partCase.switch(
					0,{IFLpMn.tsLeds(0,0,0,0,0,0,0,0);},
					1,{IFLpMn.tsLeds(1,0,0,0,0,0,0,0);},
					2,{IFLpMn.tsLeds(0,1,0,0,0,0,0,0);},
					3,{IFLpMn.tsLeds(0,0,1,0,0,0,0,0);},
					4,{IFLpMn.tsLeds(0,0,0,1,0,0,0,0);},
					5,{IFLpMn.tsLeds(0,0,0,0,1,0,0,0);},
					6,{IFLpMn.tsLeds(0,0,0,0,0,1,0,0);},
					7,{IFLpMn.tsLeds(0,0,0,0,0,0,1,0);},
					8,{IFLpMn.tsLeds(0,0,0,0,0,0,0,1);}
				);
				~trackCase.switch(
					0,{IFLpMn.tsLeds(0,0,0,0,0,0,0,0);},
					1,{IFTrack01.lpMnParts;},
					2,{IFTrack02.lpMnParts;},
					3,{IFTrack03.lpMnParts;}
				);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, noteNum:~lpMnButV1);

	}//shiftButtons
	*tracks{
		~lpMn_TS01.free;
		~lpMn_TS01=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				IFTrack01.loadAtStart;
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH1);
		~lpMn_TS02.free;
		~lpMn_TS02=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				IFTrack02.loadAtStart;
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH2);
		~lpMn_TS03.free;
		~lpMn_TS03=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				IFTrack03.loadAtStart;
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH3);
		~lpMn_TS04.free;
		~lpMn_TS04=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH4);
		~lpMn_TS05.free;
		~lpMn_TS05=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH5);
		~lpMn_TS06.free;
		~lpMn_TS06=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH6);
		~lpMn_TS07.free;
		~lpMn_TS07=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH7);
		~lpMn_TS08.free;
		~lpMn_TS08=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {

			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH8);

	}//tracks

	*parts {//Parts 1-8 //Presets 9-16


		~lpMn_TS01.free;
		~lpMn_TS01=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=1;
				IFTrack01.part01;
				IFLpMn.tsLeds(1,0,0,0,0,0,0,0);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH1);
		~lpMn_TS02.free;
		~lpMn_TS02=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=2;
				IFTrack01.part02;
				IFLpMn.tsLeds(0,1,0,0,0,0,0,0);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH2);
		~lpMn_TS03.free;
		~lpMn_TS03=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=3;
				IFTrack01.part03;
				IFLpMn.tsLeds(0,0,1,0,0,0,0,0);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH3);
		~lpMn_TS04.free;
		~lpMn_TS04=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=4;
				IFTrack01.part04;
				IFLpMn.tsLeds(0,0,0,1,0,0,0,0);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH4);
		~lpMn_TS05.free;
		~lpMn_TS05=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=5;
				IFTrack01.part05;
				IFLpMn.tsLeds(0,0,0,0,1,0,0,0);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH5);
		~lpMn_TS06.free;
		~lpMn_TS06=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=6;
				IFTrack01.part06;
				IFLpMn.tsLeds(0,0,0,0,0,1,0,0);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH6);
		~lpMn_TS07.free;
		~lpMn_TS07=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=7;
				IFTrack01.part07;
				IFLpMn.tsLeds(0,0,0,0,0,0,1,0);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH7);
		~lpMn_TS08.free;
		~lpMn_TS08=MIDIFunc.cc( {
			arg vel;
			if ( vel==127, {
				~partCase=8;
				IFTrack01.part08;
				IFLpMn.tsLeds(0,0,0,0,0,0,0,1);
			});
		},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH8);

	}//lpMnParts

	*tsLed{|chan,led|
		//~lpMn.noteOn(chan, 51, led);
	}
	*tsLeds{|led1,led2,led3,led4,led5,led6,led7,led8|
		~lpMn.control(~lpMnCh, ~lpMnButH1, led1); //But 1
		~lpMn.control(~lpMnCh, ~lpMnButH2, led2); //But 2
		~lpMn.control(~lpMnCh, ~lpMnButH3, led3); //But 3
		~lpMn.control(~lpMnCh, ~lpMnButH4, led4); //But 4
		~lpMn.control(~lpMnCh, ~lpMnButH5, led5); //But 5
		~lpMn.control(~lpMnCh, ~lpMnButH6, led6); //But 6
		~lpMn.control(~lpMnCh, ~lpMnButH7, led7); //But 7
		~lpMn.control(~lpMnCh, ~lpMnButH8, led8); //But 8
	}
	*resetLeds{

		//Track Selection Only One Function
		~lpMn.control(0, 104, 0); //But 1
		~lpMn.control(0, 105, 0); //But 2
		~lpMn.control(0, 106, 0); //But 3
		~lpMn.control(0, 107, 0); //But 4
		~lpMn.control(0, 108, 0); //But 5
		~lpMn.control(0, 109, 0); //But 6
		~lpMn.control(0, 110, 0); //But 7
		~lpMn.control(0, 111, 0); //But 8

	}

}

