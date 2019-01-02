/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;


IFAPCMn.loadSource;
IFAPCMn.resetLeds;
IFAPCMn.nobDown(mode:1);
IFAPCMn.update;



*/
IFSixteen {
	*defaults {/*this.hold*/}

	*hold {
		"TEMPORARY TEST: IFSixteen.defaults in (*defaults {this.hold})".postln;
		~seqStepBut01.free;
		~seqStepBut01 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.first8;
			},{
					IFSeqSteps.forward;
			});
			},
			'/seqStep01'
		);

		~seqStepBut02.free;
		~seqStepBut02 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~stepNum.source  =  Pseq([4,3,2], inf);

			},{
					IFSeqSteps.forward;
			});
			},
			'/seqStep02'
		);

		~seqStepBut03.free;
		~seqStepBut03 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~stepNum.source  =  Pseq([1,2,3,4], inf);
			},{
					IFSeqSteps.forward;
			});
			},
			'/seqStep03'
		);

		~seqStepBut04.free;
		~seqStepBut04 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFSeqSteps.random;
			},{
					IFSeqSteps.forward;
			});
			},
			'/seqStep04'
		);
		~seqStepBut05.free;
		~seqStepBut05 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~stepNum.source  =  Pseq([5], inf);

			},{
					~stepNum.source  =  Pseq([5,6,7,8], inf);
			});
			},
			'/seqStep05'
		);
		~seqStepBut06.free;
		~seqStepBut06 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~stepNum.source  =  Pseq([6], inf);

			},{
					IFSeqSteps.forward;
			});
			},
			'/seqStep06'
		);
		~seqStepBut07.free;
		~seqStepBut07 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~stepNum.source  =  Pseq([7], inf);

			},{
					IFSeqSteps.forward;
			});
			},
			'/seqStep07'
		);
		~seqStepBut08.free;
		~seqStepBut08 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.first8;

			},{
					IFSeqSteps.forward;
			});
			},
			'/seqStep08'
		);
		~seqStepBut09.free;
		~seqStepBut09 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.second8;

			},{
					//IFSeqSteps.forward;
			});
			},
			'/seqStep09'
		);
		~seqStepBut10.free;
		~seqStepBut10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~stepNum.source  =  Pseq([10], inf);
			},{
					IFSeqSteps.second8;
			});
			},
			'/seqStep10'
		);
		~seqStepBut11.free;
		~seqStepBut11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.preset02;
			});
			},
			'/seqStep11'
		);
		~seqStepBut12.free;
		~seqStepBut12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.preset03;
			});
			},
			'/seqStep12'
		);
		~seqStepBut13.free;
		~seqStepBut13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.preset03;
			});
			},
			'/seqStep13'
		);
		~seqStepBut14.free;
		~seqStepBut14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.preset03;
			});
			},
			'/seqStep14'
		);
		~seqStepBut15.free;
		~seqStepBut15 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.second8back;
			});
			},
			'/seqStep15'
		);

		~seqStepBut16.free;
		~seqStepBut16 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.backward;
			});
			},
			'/seqStep16'
		);

	}//hold

	*directions {
		~seqStepBut01.free;
		~seqStepBut01 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.forward;
			});
			},
			'/seqStep01'
		);

		~seqStepBut02.free;
		~seqStepBut02 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.first8;
			});
			},
			'/seqStep02'
		);

		~seqStepBut03.free;
		~seqStepBut03 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.shuf;
			});
			},
			'/seqStep03'
		);

		~seqStepBut04.free;
		~seqStepBut04 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.random;
			});
			},
			'/seqStep04'
		);
		~seqStepBut05.free;
		~seqStepBut05 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.mirror;
			});
			},
			'/seqStep05'
		);
		~seqStepBut06.free;
		~seqStepBut06 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.slide1;
			});
			},
			'/seqStep06'
		);
		~seqStepBut07.free;
		~seqStepBut07 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.slide2;
			});
			},
			'/seqStep07'
		);
		~seqStepBut08.free;
		~seqStepBut08 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.first8back;
			});
			},
			'/seqStep08'
		);
		~seqStepBut09.free;
		~seqStepBut09 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.second8;
			});
			},
			'/seqStep09'
		);
		~seqStepBut10.free;
		~seqStepBut10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.preset01;
			});
			},
			'/seqStep10'
		);
		~seqStepBut11.free;
		~seqStepBut11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.preset02;
			});
			},
			'/seqStep11'
		);
		~seqStepBut12.free;
		~seqStepBut12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.preset03;
			});
			},
			'/seqStep12'
		);
		~seqStepBut13.free;
		~seqStepBut13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.preset03;
			});
			},
			'/seqStep13'
		);
		~seqStepBut14.free;
		~seqStepBut14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.preset03;
			});
			},
			'/seqStep14'
		);
		~seqStepBut15.free;
		~seqStepBut15 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.second8back;
			});
			},
			'/seqStep15'
		);

		~seqStepBut16.free;
		~seqStepBut16 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSeqSteps.backward;
			});
			},
			'/seqStep16'
		);

	}//directions


	*tracks {
		~seqStepBut01.free;
		~seqStepBut01 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack01.loadAtStart;
			});
			},
			'/seqStep01'
		);

		~seqStepBut02.free;
		~seqStepBut02 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack02.loadAtStart;
			});
			},
			'/seqStep02'
		);

		~seqStepBut03.free;
		~seqStepBut03 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack03.loadAtStart;
			});
			},
			'/seqStep03'
		);

		~seqStepBut04.free;
		~seqStepBut04 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep04'
		);
		~seqStepBut05.free;
		~seqStepBut05 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep05'
		);
		~seqStepBut06.free;
		~seqStepBut06 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep06'
		);
		~seqStepBut07.free;
		~seqStepBut07 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep07'
		);
		~seqStepBut08.free;
		~seqStepBut08 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep08'
		);
		~seqStepBut09.free;
		~seqStepBut09 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep09'
		);
		~seqStepBut10.free;
		~seqStepBut10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep10'
		);
		~seqStepBut11.free;
		~seqStepBut11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep11'
		);
		~seqStepBut12.free;
		~seqStepBut12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep12'
		);
		~seqStepBut13.free;
		~seqStepBut13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep13'
		);
		~seqStepBut14.free;
		~seqStepBut14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep14'
		);
		~seqStepBut15.free;
		~seqStepBut15 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep15'
		);

		~seqStepBut16.free;
		~seqStepBut16 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep16'
		);

	}//tracks


	*durations {
		~seqStepBut01.free;
		~seqStepBut01 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Pattern 1".postln;
				~tOSCAdrr.sendMsg('durLabel', 'Strght 02');
				~dur.source = Pseq([
			~seqDurPat01,~seqDurPat02,~seqDurPat03,~seqDurPat04,
			~seqDurPat05,~seqDurPat06,~seqDurPat07,~seqDurPat08,
			~seqDurPat09,~seqDurPat10,~seqDurPat11,~seqDurPat12,
			~seqDurPat13,~seqDurPat14,~seqDurPat15,~seqDurPat16
		],inf)*~durMulP.next;
			});
			},
			'/seqStep01'
		);

		~seqStepBut02.free;
		~seqStepBut02 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Pattern 2".postln;
				~tOSCAdrr.sendMsg('durLabel', 'Strght 01');
				~dur.source = Pseq([1], inf)*~durMulP.next;
			});
			},
			'/seqStep02'
		);

		~seqStepBut03.free;
		~seqStepBut03 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Pattern Shuf".postln;
				~tOSCAdrr.sendMsg('durLabel', 'Shuf');
				~dur.source = Pshuf([
					Pshuf([0.25,0.5,0.5], 1),
					Pshuf([0.25,0.75], 1),
					Pshuf([0.5,0.25,0.25], 1),
					Pshuf([0.5,0.75], 2)
				], inf)*2*~durMulP.next;
			});
			},
			'/seqStep03'
		);

		~seqStepBut04.free;
		~seqStepBut04 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Pattern Rand".postln;
				~tOSCAdrr.sendMsg('durLabel', 'Rand');
				~dur.source = Pseq([
					Pxrand([0.25,0.5,0.5], 1),
					Pxrand([0.25,0.75], 1),
					Pxrand([0.5,0.25,0.25], 1),
					Pxrand([0.5,0.75], 2)
				], inf)*2*~durMulP.next;
			});
			},
			'/seqStep04'
		);
		~seqStepBut05.free;
		~seqStepBut05 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Pattern Aksak".postln;
				~tOSCAdrr.sendMsg('durLabel', 'Aksak');
				~dur.source = Pseq([
					Pseq([0.5,0.5,0.75,0.25], 1),
					Pseq([1,0.75,0.25], 1),
					Pseq([0.5,0.5,0.75,0.25], 1),
					Pseq([0.5,0.75,0.5,0.25], 2)
				], inf)*2*~durMulP.next;
			});
			},
			'/seqStep05'
		);
		~seqStepBut06.free;
		~seqStepBut06 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFRoot.set00;
			});
			},
			'/seqStep06'
		);
		~seqStepBut07.free;
		~seqStepBut07 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFRoot.set01;
			});
			},
			'/seqStep07'
		);
		~seqStepBut08.free;
		~seqStepBut08 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFRoot.set02;
			});
			},
			'/seqStep08'
		);
		~seqStepBut09.free;
		~seqStepBut09 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFRoot.set03;
			});
			},
			'/seqStep09'
		);
		~seqStepBut10.free;
		~seqStepBut10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Multiple 2".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '2');
				~durMul.source = Pseq([2], inf);
			});
			},
			'/seqStep10'
		);
		~seqStepBut11.free;
		~seqStepBut11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Multiple 1".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1');
				~durMul.source = Pseq([1], inf);
			});
			},
			'/seqStep11'
		);
		~seqStepBut12.free;
		~seqStepBut12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Multiple 1/2".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1/2');
				~durMul.source = Pseq([1/2], inf);
			});
			},
			'/seqStep12'
		);
		~seqStepBut13.free;
		~seqStepBut13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Multiple 1/3".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1/3');
				~durMul.source = Pseq([1/3], inf);
			});
			},
			'/seqStep13'
		);
		~seqStepBut14.free;
		~seqStepBut14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Multiple 1/4".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1/4');
				~durMul.source = Pseq([1/4], inf);
			});
			},
			'/seqStep14'
		);
		~seqStepBut15.free;
		~seqStepBut15 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Multiple 1/5".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1/5');
				~durMul.source = Pseq([1/5], inf);
			});
			},
			'/seqStep15'
		);

		~seqStepBut16.free;
		~seqStepBut16 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Multiple 1/6".postln;
				~tOSCAdrr.sendMsg('durMulLabel', '1/6');
				~durMul.source = Pseq([1/6], inf);
			});
			},
			'/seqStep16'
		);

	}//durations

	*scales {
		~seqStepBut01.free;
		~seqStepBut01 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl2= Scale.major;
				~tOSCAdrr.sendMsg('scaleLabel', 'major');
			});
			},
			'/seqStep01'
		);

		~seqStepBut02.free;
		~seqStepBut02 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl2= Scale.minor;
				~tOSCAdrr.sendMsg('scaleLabel', 'minor');
			});
			},
			'/seqStep02'
		);

		~seqStepBut03.free;
		~seqStepBut03 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl2= Scale.phrygian;
				~tOSCAdrr.sendMsg('scaleLabel', 'Phrygian');
			});
			},
			'/seqStep03'
		);

		~seqStepBut04.free;
		~seqStepBut04 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl2= Scale.chinese;
				~tOSCAdrr.sendMsg('scaleLabel', 'chinese');
			});
			},
			'/seqStep04'
		);
		~seqStepBut05.free;
		~seqStepBut05 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl2= Scale.zhi;
				~tOSCAdrr.sendMsg('scaleLabel', 'zhi');
			});
			},
			'/seqStep05'
		);
		~seqStepBut06.free;
		~seqStepBut06 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep06'
		);
		~seqStepBut07.free;
		~seqStepBut07 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep07'
		);
		~seqStepBut08.free;
		~seqStepBut08 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep08'
		);
		~seqStepBut09.free;
		~seqStepBut09 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

			});
			},
			'/seqStep09'
		);
		~seqStepBut10.free;
		~seqStepBut10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.chromatic;
			});
			},
			'/seqStep10'
		);
		~seqStepBut11.free;
		~seqStepBut11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.major;
			});
			},
			'/seqStep11'
		);
		~seqStepBut12.free;
		~seqStepBut12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.zhi;
			});
			},
			'/seqStep12'
		);
		~seqStepBut13.free;
		~seqStepBut13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.chinese;
			});
			},
			'/seqStep13'
		);
		~seqStepBut14.free;
		~seqStepBut14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.hexMajor7;
			});
			},
			'/seqStep14'
		);
		~seqStepBut15.free;
		~seqStepBut15 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.partch_o1;
			});
			},
			'/seqStep15'
		);

		~seqStepBut16.free;
		~seqStepBut16 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~scl1= Scale.chromatic;~scl2= Scale.chromatic;
				~tOSCAdrr.sendMsg('scaleLabel', 'chromatic');
			});
			},
			'/seqStep16'
		);

	}//scales





}
