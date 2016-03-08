IFCntrl {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
				1.0.wait;
				this.globals;
				this.mulFaders;
				this.main;
				this.parts;
				this.bridge;
				this.note;
				this.noteBass;
				this.noteKeys;
				this.noteSamp;
				this.oct;
				this.trans;


			});*/
		}
	}

	*loadAll {
		this.main;
		this.parts;
		this.bridge;
	}




	*main {

		~tempoFader.free;
		~tempoFader= OSCFunc({
			arg msg,val;
			val=msg[1];
			//~vBeatsLate=val/(1/100);
			IFProjectGlobals.setTempo(msg[1]);
			~tOSCAdrr.sendMsg('tempoLabel', msg[1]);
			~tOSCAdrr.sendMsg('tempoFader', msg[1]);

			},
			'/tempoFader'
		);

		~cutAllXY.free;
		~cutAllXY= OSCFunc({
			arg msg,vel1, vel2;
			vel1=msg[1]*127;
			vel2=msg[2]*127;

			~md1.control(10, 6, vel1); // VBass VCFilter CutOff
			~vBass.control(0, ~cutOff, vel1);

			~vBass.control(0, ~gateTime, vel2);

			~md1.control(10, 7, vel2); //VKeys VCFilter CutOff
			~vKeys.control(0, ~vcfCut, vel2);

			~md1.control(10, 8, vel1); // IFSamp VCFilter CutOff

			~md1.control(10, 9, vel2); //IFSamp VCFilter CutOff

			},
			'/cutAll'
		);

		~harmXY.free;
		~harmXY= OSCFunc({
			arg msg;

			~harmKick=msg[1];~harmSnr=msg[1];~harmHat=msg[1]+1*1.5;
			~harmBass=msg[2];~harmKeys=msg[2];~harmSamp=msg[2];

			~tOSCAdrr.sendMsg('harm0', 1);
			},
			'/harmXY/1'
		);

		~harm_0.free;
		~harm_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Harmonic 0".postln;
				~harmKick=0;~harmSnr=0;~harmHat=0;
				~harmBass=0;~harmKeys=0;~harmSamp=0;

				~strSnr.source    =  Pshuf([1], inf);
				~strSnr.source    =  Pshuf([1], inf);
				~strHat.source    =  Pshuf([1], inf);
				~strBass.source    =  Pshuf([1], inf);
				~strKeys.source    =  Pshuf([1], inf);
				~strSamp.source    =  Pshuf([1], inf);
				~tOSCAdrr.sendMsg('harm0', 0);
				~tOSCAdrr.sendMsg('shufHarm', 0);
			});
			},
			'/harm0'
		);

		~shufHarmBut.free;
		~shufHarmBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Harmonics Shuffle".postln;
				~strKick.source  =  Pshuf([0.5,0.8,1.2,1.7, 1.1,2.8,1.8,0.4], inf);
				~strSnr.source   =  Pshuf([1.1,0.4,2.5,1.2, 1.1,3.0,1.8,0.4], inf);
				~strHat.source   =  Pshuf([0.1,0.4,2.2,1.2, 1.1,3.2,1.8,0.4], inf);
				~strBass.source  =  Pshuf([0.5,0.8,2.3,1.2, 1.1,1.8,1.8,0.4], inf);
				~strKeys.source  =  Pshuf([0.5,0.4,2.0,1.2, 1.1,2.6,1.8,0.4], inf);
				~strSamp.source  =  Pshuf([1.0,0.4,2.0,1.2, 1.1,3.4,1.8,0.4], inf);

				~tOSCAdrr.sendMsg('shufHarm', 1);
			},{
					~tOSCAdrr.sendMsg('shufHarm', 1);
			}
			);
			},
			'/shufHarm'
		);

		~shufTransBut.free;
		~shufTransBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Transpose Shuffle".postln;

				~transBass.source  = Pshuf([(-5),2,7,(-7), (-2),1,6,(-3)], inf);
				~transKeys.source  = Pshuf([(-4),3,2,(-7), (-2),4,6,(-1)], inf);
				~transSamp.source  = Pshuf([(-1),2,7,(-6), (-2),3,6,(-4)], inf);

			},{
					~transBass.source  = Pshuf([0], inf);
					~transKeys.source  = Pshuf([0], inf);
					~transSamp.source  = Pshuf([0], inf);
			}
			);
			},
			'/shufTrans'
		);

		~susAllMulFader.free;
		~susAllMulFader= OSCFunc({
			arg msg;
			//~susMulSnr=msg[1];
			~susMulBass=msg[1];~susMulKeys=msg[1];~susMulSamp=msg[1];
			},
			'/susAll'
		);

		~susDrumMulFader.free;
		~susDrumMulFader= OSCFunc({
			arg msg;
			~susMulKick=msg[1];~susMulSnr=msg[1];~susMulHat=msg[1];

			},
			'/susDrum'
		);



		~chainDrumFader.free;
		~chainDrumFader= OSCFunc({
			arg msg,val;

			val=msg[1]*127;
			~md1.control(2, 8, val);//~tOSCAdrr.sendMsg('chainKick', val);
			~md1.control(3, 8, val);//~tOSCAdrr.sendMsg('chainSnr', val);
			~md1.control(4, 8, val);//~tOSCAdrr.sendMsg('chainHat', val);

			},
			'/chainDrum'
		);

		~chainAllFader.free;
		~chainAllFader= OSCFunc({
			arg msg,val;

			val=msg[1]*127;
			~md1.control(5, 8, val);//~tOSCAdrr.sendMsg('chainBass', val);
			~md1.control(6, 8, val);//~tOSCAdrr.sendMsg('chainKeys', val);
			~md1.control(7, 8, val);//~tOSCAdrr.sendMsg('chainSamp', val);

			},
			'/chainAll'
		);

		~attMelFader.free;
		~attMelFader= OSCFunc({
			arg msg,val;

			val=msg[1]*127;
			~md1.control(5, 5, val); ~tOSCAdrr.sendMsg('attBass', val);
			~md1.control(6, 5, val); ~tOSCAdrr.sendMsg('attKeys', val);
			~md1.control(7, 5, val); ~tOSCAdrr.sendMsg('attSamp', val);
			},
			'/attMel'
		);

		//TIME
		~tmOneBut.free;
		~tmOneBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulKick.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmKickLabel', 1);
				~tmMulSnr.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', 1);
				~tmMulHat.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmHatLabel', 1);
				~tmMulBass.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', 1);
				~tmMulKeys.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', 1);
				~tmMulSamp.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 1);
			});
			},
			'/tmOne'
		);
		~tmTwoBut.free;
		~tmTwoBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulKick.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmKickLabel', 2);
				~tmMulSnr.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', 2);
				~tmMulHat.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmHatLabel', 2);
				~tmMulBass.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', 2);
				~tmMulKeys.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', 2);
				~tmMulSamp.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 2);
			});
			},
			'/tmTwo'
		);
		~tmRandBut.free;
		~tmRandBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmKickRand=[1,2,3,1].choose;
				~tmMulKick.source = Pseq([~tmKickRand], inf);
				~tOSCAdrr.sendMsg('tmKickLabel', ~tmKickRand);

				~tmSnrRand=[1,2,2,1].choose;
				~tmMulSnr.source = Pseq([~tmSnrRand], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', ~tmSnrRand);

				~tmHatRand=[1,2,3,1].choose;
				~tmMulHat.source = Pseq([~tmHatRand], inf);
				~tOSCAdrr.sendMsg('tmHatLabel', ~tmHatRand);

				~tmBassRand=[1,2,3,1].choose;
				~tmMulBass.source = Pseq([~tmBassRand], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', ~tmBassRand);

				~tmKeysRand=[1,2,3,1].choose;
				~tmMulKeys.source = Pseq([~tmKeysRand], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', ~tmKeysRand);

				~tmSampRand=[1,2,3,1].choose;
				~tmMulSamp.source = Pseq([~tmSampRand], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', ~tmSampRand);
			});
			},
			'/tmRand'
		);
		~tmMulDrumBut.free;
		~tmMulDrumBut= OSCFunc({
			arg msg;
			~tmMulKick.source = msg[1];
			~tmMulSnr.source = msg[1];
			~tmMulHat.source = msg[1];

			},
			'/tmMulDrum'
		);
		~killAblBut.free;
		~killAblBut= OSCFunc({
			arg msg;
			if(msg[1]==1,{
				{"TRUE".postln;
				}.fork
				},{
					{"FALSE".postln;
					}.fork;

			});

			},
			'/killAbl'
		);


		~tapAblBut.free;
		~tapAblBut = OSCFunc({
			arg msg;

			if ( msg[1]==1, {
				   Ableton.tap4;
				},{

				}
			);

			},
			'/tapAbl'
		);


	}

	*parts {

		/////////////////////----- Parts -------//////////////

		~part_0.free;
		~part_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part0".postln;

				~mainSet_00.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'part0');
			});
			},
			'/part0'
		);


		~part_1.free;
		~part_1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part1".postln;

				~mainSet_01.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt01');
			});
			},
			'/part1'
		);

		~part_2.free;
		~part_2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part2".postln;

				~mainSet_02.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt02');
			});
			},
			'/part2'
		);

		~part_3.free;
		~part_3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part3".postln;

				~mainSet_03.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt03');
			});
			},
			'/part3'
		);

		~part_4.free;
		~part_4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part4".postln;

				~mainSet_04.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt04');
			});
			},
			'/part4'
		);

		~part_5.free;
		~part_5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part5".postln;

				~mainSet_05.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt05');
			});
			},
			'/part5'
		);

		~part_6.free;
		~part_6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part6".postln;

				~mainSet_06.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt06');
			});
			},
			'/part6'
		);

		~part_7.free;
		~part_7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part7".postln;

				~mainSet_07.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt07');
			});
			},
			'/part7'
		);

	}

	*bridge {


		/////////////////////----- Bridges -------//////////////



		~bridge1.free;
		~bridge1 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"bridge1".postln;

				~mainBridge_01.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'brg1');
			});
			},
			'/bridge1'
		);

		~bridge2.free;
		~bridge2 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"bridge2".postln;

				~mainBridge_02.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'brg2');
			});
			},
			'/bridge2'
		);

		~bridge3.free;
		~bridge3 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"bridge3".postln;

				~mainBridge_03.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'brg3');
			});
			},
			'/bridge3'
		);

		~bridge4.free;
		~bridge4 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"bridge4".postln;

				~mainBridge_04.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'brg4');
			});
			},
			'/bridge4'
		);

		~bridge5.free;
		~bridge5 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"bridge5".postln;

				~mainBridge_05.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'brg5');
			});
			},
			'/bridge5'
		);

		~bridge6.free;
		~bridge6 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"bridge6".postln;

				~mainBridge_06.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'brg6');
			});
			},
			'/bridge6'
		);

		~bridge7.free;
		~bridge7 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"bridge7".postln;

				~mainBridge_07.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'brg7');
			});
			},
			'/bridge7'
		);

	}

	*freeAll {



	}

}