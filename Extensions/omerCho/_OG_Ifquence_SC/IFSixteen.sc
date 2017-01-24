IFSixteen {
	*defaults {this.hold}

	*hold {
		~seqStepBut01.free;
		~seqStepBut01 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~stepNum.source  =  Pseq([1], inf);

			},{
					~stepNum.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
			});
			},
			'/seqStep01'
		);

		~seqStepBut02.free;
		~seqStepBut02 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~stepNum.source  =  Pseq([2], inf);

			},{
					~stepNum.source  =  Pseq([2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
			});
			},
			'/seqStep02'
		);

		~seqStepBut03.free;
		~seqStepBut03 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~stepNum.source  =  Pseq([3], inf);

			},{
					~stepNum.source  =  Pseq([3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
			});
			},
			'/seqStep03'
		);

		~seqStepBut04.free;
		~seqStepBut04 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~stepNum.source  =  Pseq([4], inf);

			},{
					~stepNum.source  =  Pseq([4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
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
					~stepNum.source  =  Pseq([5,6,7,8,9,10,11,12,13,14,15,16], inf);
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
					~stepNum.source  =  Pseq([6,7,8,9,10,11,12,13,14,15,16], inf);
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
					~stepNum.source  =  Pseq([7,8,9,10,11,12,13,14,15,16], inf);
			});
			},
			'/seqStep07'
		);
		~seqStepBut08.free;
		~seqStepBut08 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~stepNum.source  =  Pseq([8], inf);

			},{
					~stepNum.source  =  Pseq([8,9,10,11,12,13,14,15,16], inf);
			});
			},
			'/seqStep08'
		);
		~seqStepBut09.free;
		~seqStepBut09 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~stepNum.source  =  Pseq([9], inf);

			},{
					~stepNum.source  =  Pseq([9,10,11,12,13,14,15,16], inf);
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
				IFTracks.track1;
				"TRACK 1".postln;
				~tOSCAdrr.sendMsg('trackLabel','TRACK 1');
			});
			},
			'/seqStep01'
		);

		~seqStepBut02.free;
		~seqStepBut02 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTracks.track2;
				"TRACK 2".postln;
				~tOSCAdrr.sendMsg('trackLabel','TRACK 2');
			});
			},
			'/seqStep02'
		);

		~seqStepBut03.free;
		~seqStepBut03 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

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

	*parts {
		~seqStepBut01.free;
		~seqStepBut01 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part01".postln;
				~mainSet_01.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt01');
			});
			},
			'/seqStep01'
		);

		~seqStepBut02.free;
		~seqStepBut02 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part02".postln;
				~mainSet_02.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt02');
			});
			},
			'/seqStep02'
		);

		~seqStepBut03.free;
		~seqStepBut03 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part03".postln;
				~mainSet_03.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt03');
			});
			},
			'/seqStep03'
		);

		~seqStepBut04.free;
		~seqStepBut04 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part04".postln;
				~mainSet_04.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt04');
			});
			},
			'/seqStep04'
		);
		~seqStepBut05.free;
		~seqStepBut05 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part05".postln;
				~mainSet_05.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt05');
			});
			},
			'/seqStep05'
		);
		~seqStepBut06.free;
		~seqStepBut06 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part06".postln;
				~mainSet_06.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt06');
			});
			},
			'/seqStep06'
		);
		~seqStepBut07.free;
		~seqStepBut07 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part07".postln;
				~mainSet_07.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt07');
			});
			},
			'/seqStep07'
		);
		~seqStepBut08.free;
		~seqStepBut08 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part08".postln;
				~mainSet_08.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt08');
			});
			},
			'/seqStep08'
		);
		~seqStepBut09.free;
		~seqStepBut09 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part09".postln;
				~mainSet_09.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt09');
			});
			},
			'/seqStep09'
		);
		~seqStepBut10.free;
		~seqStepBut10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part10".postln;
				~mainSet_10.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt10');
			});
			},
			'/seqStep10'
		);
		~seqStepBut11.free;
		~seqStepBut11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part11".postln;
				~mainSet_11.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt11');
			});
			},
			'/seqStep11'
		);
		~seqStepBut12.free;
		~seqStepBut12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part12".postln;
				~mainSet_12.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt12');
			});
			},
			'/seqStep12'
		);
		~seqStepBut13.free;
		~seqStepBut13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part13".postln;
				~mainSet_13.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt13');
			});
			},
			'/seqStep13'
		);
		~seqStepBut14.free;
		~seqStepBut14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part14".postln;
				~mainSet_14.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt14');
			});
			},
			'/seqStep14'
		);
		~seqStepBut15.free;
		~seqStepBut15 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part15".postln;
				~mainSet_15.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt15');
			});
			},
			'/seqStep15'
		);

		~seqStepBut16.free;
		~seqStepBut16 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"part16".postln;
				~mainSet_16.fork(quant:0);
				~tOSCAdrr.sendMsg('partLabel', 'pt16');
			});
			},
			'/seqStep16'
		);

	}//parts

	*durations {
		~seqStepBut01.free;
		~seqStepBut01 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Pattern 1".postln;
				~tOSCAdrr.sendMsg('durLabel', 'Strght 01');
				~durP.source = Pseq([1], inf)*~durMulP.next;
			});
			},
			'/seqStep01'
		);

		~seqStepBut02.free;
		~seqStepBut02 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Duration Pattern 2".postln;
				~tOSCAdrr.sendMsg('durLabel', 'Strght 02');
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

	*presets {
		~seqStepBut01.free;
		~seqStepBut01 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack01.preset01;
			});
			},
			'/seqStep01'
		);

		~seqStepBut02.free;
		~seqStepBut02 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack01.preset02;
			});
			},
			'/seqStep02'
		);

		~seqStepBut03.free;
		~seqStepBut03 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

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

	}//presets

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