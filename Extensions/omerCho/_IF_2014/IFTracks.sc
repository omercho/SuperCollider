IFTracks{

	*loadButtons{
		~trackOSC_1.free;
		~trackOSC_1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTracks.track1;
				"TRACK 1".postln;
				~tOSCAdrr.sendMsg('trackLabel','TRACK 1');
			});
			},
			'/track1'
		);

		~trackOSC_2.free;
		~trackOSC_2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTracks.track2;
				"TRACK 2".postln;
				~tOSCAdrr.sendMsg('trackLabel','TRACK 2');
			});
			},
			'/track2'
		);

		~trackOSC_3.free;
		~trackOSC_3= OSCFunc({
			arg msg;

			~track3.fork;
			~tOSCAdrr.sendMsg('trackLabel','TRACK 3');

			},
			'/track3'
		);

		~trackOSC_4.free;
		~trackOSC_4= OSCFunc({
			arg msg;

			~track4.fork;
			~tOSCAdrr.sendMsg('trackLabel','TRACK 4');

			},
			'/track4'
		);


	}

	*track1 {

		IFMainTrack1.load;



		//--------------  RootPlayerVariations
		~root00But.free;
		~root00But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFRoot.set00;

			},{
					~tOSCAdrr.sendMsg('rootSet00', '1');
					~tOSCAdrr.sendMsg('rootSet01', '0');
					~tOSCAdrr.sendMsg('rootSet02', '0');
					~tOSCAdrr.sendMsg('rootSet03', '0');
					~tOSCAdrr.sendMsg('rootSet04', '0');
					~tOSCAdrr.sendMsg('rootSet05', '0');

			});
			},
			'/rootSet00'
		);
		~root01But.free;
		~root01But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFRoot.set01;

			},{
					~tOSCAdrr.sendMsg('rootSet00', '0');
					~tOSCAdrr.sendMsg('rootSet01', '1');
					~tOSCAdrr.sendMsg('rootSet02', '0');
					~tOSCAdrr.sendMsg('rootSet03', '0');
					~tOSCAdrr.sendMsg('rootSet04', '0');
					~tOSCAdrr.sendMsg('rootSet05', '0');

			});
			},
			'/rootSet01'
		);
		~root02But.free;
		~root02But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFRoot.set02;

			},{
					~tOSCAdrr.sendMsg('rootSet00', '0');
					~tOSCAdrr.sendMsg('rootSet01', '0');
					~tOSCAdrr.sendMsg('rootSet02', '1');
					~tOSCAdrr.sendMsg('rootSet03', '0');
					~tOSCAdrr.sendMsg('rootSet04', '0');
					~tOSCAdrr.sendMsg('rootSet05', '0');

			});
			},
			'/rootSet02'
		);
		~root03But.free;
		~root03But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {


				IFRoot.set03;

			},{
					~tOSCAdrr.sendMsg('rootSet00', '0');
					~tOSCAdrr.sendMsg('rootSet01', '0');
					~tOSCAdrr.sendMsg('rootSet02', '0');
					~tOSCAdrr.sendMsg('rootSet03', '1');
					~tOSCAdrr.sendMsg('rootSet04', '0');
					~tOSCAdrr.sendMsg('rootSet05', '0');

			});
			},
			'/rootSet03'
		);
		~root04But.free;
		~root04But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {


				IFRoot.set04;

			},{
					~tOSCAdrr.sendMsg('rootSet00', '0');
					~tOSCAdrr.sendMsg('rootSet01', '0');
					~tOSCAdrr.sendMsg('rootSet02', '0');
					~tOSCAdrr.sendMsg('rootSet03', '0');
					~tOSCAdrr.sendMsg('rootSet04', '1');
					~tOSCAdrr.sendMsg('rootSet05', '0');

			});
			},
			'/rootSet04'
		);
		~root05But.free;
		~root05But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {


				IFRoot.set05;

			},{
					~tOSCAdrr.sendMsg('rootSet00', '0');
					~tOSCAdrr.sendMsg('rootSet01', '0');
					~tOSCAdrr.sendMsg('rootSet02', '0');
					~tOSCAdrr.sendMsg('rootSet03', '0');
					~tOSCAdrr.sendMsg('rootSet04', '0');
					~tOSCAdrr.sendMsg('rootSet05', '1');

			});
			},
			'/rootSet05'
		);

		//---------------- DUR Buttons

		~dur1But.free;
		~dur1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur1".postln;
				~tOSCAdrr.sendMsg('durLabel', '1 Straight');

				~dur.source = Pseq([1], inf)*~durMulP;

			},{
					~tOSCAdrr.sendMsg('dur1', '1');
					~tOSCAdrr.sendMsg('dur2', '0');
					~tOSCAdrr.sendMsg('dur3', '0');
					~tOSCAdrr.sendMsg('dur4', '0');
					~tOSCAdrr.sendMsg('durAks1', '0');
					~tOSCAdrr.sendMsg('durShuf1', '0');
					~tOSCAdrr.sendMsg('durRand1', '0');

			});
			},
			'/dur1'
		);
		~dur2But.free;
		~dur2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur3".postln;
				~tOSCAdrr.sendMsg('durLabel', '2');
				~dur.source = Pseq([
					Pseq([1], 3),
					Pseq([0.5], 2),
					Pseq([1], 3),
					Pseq([0.5], 2)
				], inf)*~durMulP;

			},{
					~tOSCAdrr.sendMsg('dur1', '0');
					~tOSCAdrr.sendMsg('dur2', '1');
					~tOSCAdrr.sendMsg('dur3', '0');
					~tOSCAdrr.sendMsg('dur4', '0');
					~tOSCAdrr.sendMsg('durAks1', '0');
					~tOSCAdrr.sendMsg('durShuf1', '0');
					~tOSCAdrr.sendMsg('durRand1', '0');

			});
			},
			'/dur2'
		);
		~dur3But.free;
		~dur3But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur2".postln;
				~tOSCAdrr.sendMsg('durLabel', '3');
				~dur.source = Pseq([
					Pseq([0.5], 2),
					Pseq([1], 2),
					Pseq([0.5], 2),
					Pseq([0.3], 3),
					Pseq([1], 3)
				], inf)*~durMulP;

			},{
					~tOSCAdrr.sendMsg('dur1', '0');
					~tOSCAdrr.sendMsg('dur2', '0');
					~tOSCAdrr.sendMsg('dur3', '1');
					~tOSCAdrr.sendMsg('dur4', '0');
					~tOSCAdrr.sendMsg('durAks1', '0');
					~tOSCAdrr.sendMsg('durShuf1', '0');
					~tOSCAdrr.sendMsg('durRand1', '0');

			});
			},
			'/dur3'
		);

		~dur4But.free;
		~dur4But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur4".postln;
				~tOSCAdrr.sendMsg('durLabel', '4');
				~dur.source = Pseq([
					Pseq([0.3], 3),
					Pseq([0.5], 4),
					Pseq([1.25], 1),
					Pseq([0.75], 2),
					Pseq([1], 3)
				], inf)*~durMulP;


			},{
					~tOSCAdrr.sendMsg('dur1', '0');
					~tOSCAdrr.sendMsg('dur2', '0');
					~tOSCAdrr.sendMsg('dur3', '0');
					~tOSCAdrr.sendMsg('dur4', '1');
					~tOSCAdrr.sendMsg('durAks1', '0');
					~tOSCAdrr.sendMsg('durShuf1', '0');
					~tOSCAdrr.sendMsg('durRand1', '0');

			});
			},
			'/dur4'
		);

		~durAks1But.free;
		~durAks1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------durAks1".postln;
				~tOSCAdrr.sendMsg('durLabel', 'Aks');
				~dur.source = Pseq([
					Pseq([0.5,0.5,0.75,0.25], 1),
					Pseq([1,0.75,0.25], 1),
					Pseq([0.5,0.5,0.75,0.25], 1),
					Pseq([0.5,0.75,0.5,0.25], 2)
				], inf)*~durMulP;

			},{
					~tOSCAdrr.sendMsg('dur1', '0');
					~tOSCAdrr.sendMsg('dur2', '0');
					~tOSCAdrr.sendMsg('dur3', '0');
					~tOSCAdrr.sendMsg('dur4', '0');
					~tOSCAdrr.sendMsg('durAks1', '1');
					~tOSCAdrr.sendMsg('durShuf1', '0');
					~tOSCAdrr.sendMsg('durRand1', '0');

			});
			},
			'/durAks1'
		);

		~durShuf1But.free;
		~durShuf1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------durShuf1".postln;
				~tOSCAdrr.sendMsg('durLabel', 'shuf');
				~dur.source = Pshuf([
					Pshuf([0.25,0.5,0.5], 1),
					Pshuf([0.25,0.75], 1),
					Pshuf([0.5,0.25,0.25], 1),
					Pshuf([0.5,0.75], 2)
				], inf)*~durMulP;

			},{
					~tOSCAdrr.sendMsg('dur1', '0');
					~tOSCAdrr.sendMsg('dur2', '0');
					~tOSCAdrr.sendMsg('dur3', '0');
					~tOSCAdrr.sendMsg('dur4', '0');
					~tOSCAdrr.sendMsg('durAks1', '0');
					~tOSCAdrr.sendMsg('durShuf1', '1');
					~tOSCAdrr.sendMsg('durRand1', '0');

			});
			},
			'/durShuf1'
		);



		~durRand1But.free;
		~durRand1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------durRand1".postln;
				~tOSCAdrr.sendMsg('durLabel', 'rand');
				~dur.source = Pseq([
					Pxrand([0.25,0.5,0.5], 1),
					Pxrand([0.25,0.75], 1),
					Pxrand([0.5,0.25,0.25], 1),
					Pxrand([0.5,0.75], 2)
				], inf)*~durMulP;

			},{
					~tOSCAdrr.sendMsg('dur1', '0');
					~tOSCAdrr.sendMsg('dur2', '0');
					~tOSCAdrr.sendMsg('dur3', '0');
					~tOSCAdrr.sendMsg('dur4', '0');
					~tOSCAdrr.sendMsg('durAks1', '0');
					~tOSCAdrr.sendMsg('durShuf1', '0');
					~tOSCAdrr.sendMsg('durRand1', '1');

			});
			},
			'/durRand1'
		);

		//durMul

		~durMul1_4But.free;
		~durMul1_4But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur1".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1/4');

				~durMul.source = Pseq([1/4], inf);

			},{
					~tOSCAdrr.sendMsg('durMul1_4', '1');
					~tOSCAdrr.sendMsg('durMul1_2', '0');
					~tOSCAdrr.sendMsg('durMul1', '0');

			});
			},
			'/durMul1_4'
		);

		~durMul1_2But.free;
		~durMul1_2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur1".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1/2');

				~durMul.source = Pseq([1/2], inf);

			},{
					~tOSCAdrr.sendMsg('durMul1_4', '0');
					~tOSCAdrr.sendMsg('durMul1_2', '1');
					~tOSCAdrr.sendMsg('durMul1', '0');

			});
			},
			'/durMul1_2'
		);

		~durMul1But.free;
		~durMul1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur1".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1');

				~durMul.source = Pseq([1], inf);

			},{
					~tOSCAdrr.sendMsg('durMul1_4', '0');
					~tOSCAdrr.sendMsg('durMul1_2', '0');
					~tOSCAdrr.sendMsg('durMul1', '1');

			});
			},
			'/durMul1'
		);

		//SCALES
		~scale_1.free;
		~scale_1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.phrygian;~scl2= Scale.phrygian;
				~tOSCAdrr.sendMsg('scaleLabel', 'Phrygian');
			});
			},
			'/scale1'
		);
		~scale_2.free;
		~scale_2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.major;~scl2= Scale.major;
				~tOSCAdrr.sendMsg('scaleLabel', 'major');
			});
			},
			'/scale2'
		);
		~scale_3.free;
		~scale_3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.zhi;~scl2= Scale.zhi;
				~tOSCAdrr.sendMsg('scaleLabel', 'zhi');
			});
			},
			'/scale3'
		);
		~scale_4.free;
		~scale_4= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.chinese;~scl2= Scale.chinese;
				~tOSCAdrr.sendMsg('scaleLabel', 'chinese');
			});
			},
			'/scale4'
		);
		~scale_5.free;
		~scale_5= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.minor;~scl2= Scale.minor;
				~tOSCAdrr.sendMsg('scaleLabel', 'minor');
			});
			},
			'/scale5'
		);
		~scale_6.free;
		~scale_6= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.majorPentatonic;~scl2= Scale.majorPentatonic;
				~tOSCAdrr.sendMsg('scaleLabel', 'majorPentatonic');
			});
			},
			'/scale6'
		);

		//PRESETS

		~setAllBut.free;
		~setAllBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFProjectGlobals.preSetAll;

			});
			},
			'/setAll'
		);

		~set1But.free;
		~set1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFProjectGlobals.preSet_1;

			});
			},
			'/set1'
		);
		~set2But.free;
		~set2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFProjectGlobals.preSet_2;

			});
			},
			'/set2'
		);
		~set3But.free;
		~set3But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFProjectGlobals.preSet_3;

			});
			},
			'/set3'
		);
		~set4But.free;
		~set4But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFProjectGlobals.preSet_4;

			});
			},
			'/set4'
		);

	}
	//TRACK 1 END

	*track2 {

		IFMainTrack1.load;

		~togMain.free;
		~togMain = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"IF Main PLAY".postln;
				~mainSet_00.fork(quant:0);
				~ifPlay={|tm=4|

					inf.do{
						1.do {

							//~mdClock.play;
							~vBeatsLate=Tempo.bpm*(1/267.92);
							IFKick(~tmMulKickP.next*~tmKickP.next);
							IFSnr(~tmMulSnrP.next*~tmSnrP.next);
							IFHat(~tmMulHatP.next*~tmHatP.next);

							IFBass(~tmBassP.next);
							IFKeys(~tmKeysP.next);
							IFSamp(~tmSampP.next);

							IFRes1(~tmRes1P.next);

							IFVKick(~tmVKickP.next);
							IFVSnr(~tmVSnrP.next);
							IFVTom(~tmVTomP.next);
							IFVHat(~tmVHatP.next);

							~durMul*((~durP.next)).wait;
						};
					};

				}.fork;


			});

			if ( msg[1]==0, {
				"IF Main STOP".postln;
				~ifPlay.stop;
				//~mdOutClock.stop;

			});
			},
			'/1/toggleMain'
		);

		//---------------- DUR Buttons ---------------//

		~dur1But.free;
		~dur1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur1".postln;
				~tOSCAdrr.sendMsg('durLabel', '1');

				~dur.source = Pseq([1], inf)*~durMulP;

			});
			},
			'/dur1'
		);

		~dur2But.free;
		~dur2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur2".postln;
				~tOSCAdrr.sendMsg('durLabel', '2');
				~dur.source = Pseq([
					Pseq([0.5], 2),
					Pseq([1], 2),
					Pseq([0.5], 2),
					Pseq([0.25], 4),
					Pseq([1], 3),
				], inf)*2*~durMulP;

			});
			},
			'/dur2'
		);

		~dur3But.free;
		~dur3But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur3".postln;
				~tOSCAdrr.sendMsg('durLabel', '3');
				~dur.source = Pseq([
					Pseq([1], 3),
					Pseq([0.5], 2),
					Pseq([1], 3),
					Pseq([0.5], 2)
				], inf)*~durMulP;

			});
			},
			'/dur3'
		);

		~dur4But.free;
		~dur4But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur4".postln;
				~tOSCAdrr.sendMsg('durLabel', '4');
				~dur.source = Pseq([
					Pseq([0.5], 2),
					Pseq([1], 3),
					Pseq([0.5], 2),
					Pseq([1], 3)
				], inf)*~durMulP;


			});
			},
			'/dur4'
		);

		~durAks1But.free;
		~durAks1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------durAks1".postln;
				~tOSCAdrr.sendMsg('durLabel', 'Aks');
				~dur.source = Pseq([
					Pseq([0.5,0.5,0.75,0.25], 1),
					Pseq([0.5,0.75], 1),
					Pseq([0.5,0.5,0.75,], 1),
					Pseq([0.5,0.75], 2)
				], inf)*2*~durMulP;

			});
			},
			'/durAks1'
		);

		~durShuf1But.free;
		~durShuf1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------durShuf1".postln;
				~tOSCAdrr.sendMsg('durLabel', 'shuf');
				~dur.source = Pshuf([
					Pshuf([0.25,0.5,0.5], 1),
					Pshuf([0.25,0.75], 1),
					Pshuf([0.5,0.25,0.25], 1),
					Pshuf([0.5,0.75], 2)
				], inf)*~durMulP;

			});
			},
			'/durShuf1'
		);



		~durRand1But.free;
		~durRand1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------durRand1".postln;
				~tOSCAdrr.sendMsg('durLabel', 'rand');
				~dur.source = Pseq([
					Pxrand([0.25,0.5,0.5], 1),
					Pxrand([0.25,0.75], 1),
					Pxrand([0.5,0.25,0.25], 1),
					Pxrand([0.5,0.75], 2)
				], inf)*~durMulP;

			});
			},
			'/durRand1'
		);

		//durMul

		~durMul1_4But.free;
		~durMul1_4But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur1".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1/4');

				~durMul.source = Pseq([1/4], inf);

			});
			},
			'/durMul1_4'
		);

		~durMul1_2But.free;
		~durMul1_2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur1".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1/2');

				~durMul.source = Pseq([1/2], inf);

			});
			},
			'/durMul1_2'
		);

		~durMul1But.free;
		~durMul1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"------------dur1".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1');

				~durMul.source = Pseq([1], inf);

			});
			},
			'/durMul1'
		);

		//SCALES
		~scale_1.free;
		~scale_1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.phrygian;~scl2= Scale.phrygian;
				~tOSCAdrr.sendMsg('scaleLabel', 'Phrygian');
			});
			},
			'/scale1'
		);
		~scale_2.free;
		~scale_2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.major;~scl2= Scale.major;
				~tOSCAdrr.sendMsg('scaleLabel', 'major');
			});
			},
			'/scale2'
		);
		~scale_3.free;
		~scale_3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.zhi;~scl2= Scale.zhi;
				~tOSCAdrr.sendMsg('scaleLabel', 'zhi');
			});
			},
			'/scale3'
		);
		~scale_4.free;
		~scale_4= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.chinese;~scl2= Scale.chinese;
				~tOSCAdrr.sendMsg('scaleLabel', 'chinese');
			});
			},
			'/scale4'
		);
		~scale_5.free;
		~scale_5= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.minor;~scl2= Scale.minor;
				~tOSCAdrr.sendMsg('scaleLabel', 'minor');
			});
			},
			'/scale5'
		);
		~scale_6.free;
		~scale_6= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.majorPentatonic;~scl2= Scale.majorPentatonic;
				~tOSCAdrr.sendMsg('scaleLabel', 'majorPentatonic');
			});
			},
			'/scale6'
		);

		//PRESETS

		~setAllBut.free;
		~setAllBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFProjectGlobals.preSetAll;

			});
			},
			'/setAll'
		);

		~set1But.free;
		~set1But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFProjectGlobals.preSet_1;

			});
			},
			'/set1'
		);
		~set2But.free;
		~set2But = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFProjectGlobals.preSet_2;

			});
			},
			'/set2'
		);

	}//TRACK 2 END

}
/*
~track1.fork;
*/