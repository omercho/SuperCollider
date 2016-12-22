IFSixteen {
	*defaults {this.directions}

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

	}//Default


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

	}//parts
}