//IFSeqSteps.forward;

IFSeqSteps {
	*load {
		~nt=(0);
		this.loadDefault;
		this.forward;
		//this.backward;

	}


	*forward {
		~tOSCAdrr.sendMsg('partLabel', 'Forward');
		~stepNum.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
	}

	*first8 {
		~tOSCAdrr.sendMsg('partLabel', '1-->8');
		~stepNum.source  =  Pseq([1,2,3,4,5,6,7,8], inf);
	}

	*shuf {
		~tOSCAdrr.sendMsg('partLabel', 'Shuf');
		~stepNum.source  =  Pshuf([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
	}
	*random {
		~tOSCAdrr.sendMsg('partLabel', 'Random');
		~stepNum.source  =  Pxrand([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
	}

	*mirror {
		~tOSCAdrr.sendMsg('partLabel', 'Mirror');
		~stepNum.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16].mirror, inf);
	}

	*slide1 {
		~tOSCAdrr.sendMsg('partLabel', 'Slide 4/2');
		~stepNum.source  =  Pslide([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16],  inf, 4,2,0);
	}
	*slide2 {
		~tOSCAdrr.sendMsg('partLabel', 'Slide 8/2');
		~stepNum.source  =  Pslide([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16],  inf, 8,2,0);
	}
	*first8back {
		~tOSCAdrr.sendMsg('partLabel', '8-->1');
		~stepNum.source  =  Pseq([1,2,3,4,5,6,7,8].reverse, inf);
	}
	*second8 {
		~tOSCAdrr.sendMsg('partLabel', '9-->16');
		~stepNum.source  =  Pseq([9,10,11,12,13,14,15,16], inf);
	}
	*preset01 {
		~tOSCAdrr.sendMsg('partLabel', 'preset01');
		~stepNum.source  =  Pseq([
			1,
			Pxrand([2,4,6,8,10,12,14,16],3),
			5,
			Pxrand([2,4,6,8,10,12,14,16],3),
			9,
			Pxrand([2,4,6,8,10,12,14,16],3),
			13,
			Pxrand([2,4,6,8,10,12,14,16],3)
		], inf);
	}
	*preset02 {
		~tOSCAdrr.sendMsg('partLabel', 'preset02');
		~stepNum.source  =  Pseq([
			1,
			Pxrand([2,4,6,8,10,12,14,16],3),
			5,
			Pxrand([2,4,6,8,10,12,14,16],3),
			9,
			Pxrand([2,4,6,8,10,12,14,16],3),
			13,
			Pxrand([2,4,6,8,10,12,14,16],3)
		], inf);
	}
	*preset03 {
		~tOSCAdrr.sendMsg('partLabel', 'preset03');
		~stepNum.source  =  Pseq([
			1,
			Pxrand([2,4,6,8,10,12,14,16],2),
			5,
			Pxrand([2,4,6,8,10,12,14,16],2),
			9,
			Pxrand([2,4,6,8,10,12,14,16],2),
			13,
			Pxrand([2,4,6,8,10,12,14,16],2)
		], inf);
	}
	*second8back {
		~tOSCAdrr.sendMsg('partLabel', '16-->9');
		~stepNum.source  =  Pseq([9,10,11,12,13,14,15,16].reverse, inf);
	}
	*backward {
		~tOSCAdrr.sendMsg('partLabel', 'Backward');
		~stepNum.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16].reverse, inf);
	}

	*loadDefault {
		~seqStepBut01.free;
		~seqStepBut01 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.forward;
			});
			},
			'/seqStep01'
		);

		~seqStepBut02.free;
		~seqStepBut02 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.first8;
			});
			},
			'/seqStep02'
		);

		~seqStepBut03.free;
		~seqStepBut03 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.shuf;
			});
			},
			'/seqStep03'
		);

		~seqStepBut04.free;
		~seqStepBut04 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.random;
			});
			},
			'/seqStep04'
		);
		~seqStepBut05.free;
		~seqStepBut05 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.mirror;
			});
			},
			'/seqStep05'
		);
		~seqStepBut06.free;
		~seqStepBut06 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.slide1;
			});
			},
			'/seqStep06'
		);
		~seqStepBut07.free;
		~seqStepBut07 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.slide2;
			});
			},
			'/seqStep07'
		);
		~seqStepBut08.free;
		~seqStepBut08 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.first8back;
			});
			},
			'/seqStep08'
		);
		~seqStepBut09.free;
		~seqStepBut09 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.second8;
			});
			},
			'/seqStep09'
		);
		~seqStepBut10.free;
		~seqStepBut10 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.preset01;
			});
			},
			'/seqStep10'
		);
		~seqStepBut11.free;
		~seqStepBut11 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.preset02;
			});
			},
			'/seqStep11'
		);
		~seqStepBut12.free;
		~seqStepBut12 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.preset03;
			});
			},
			'/seqStep12'
		);
		~seqStepBut13.free;
		~seqStepBut13 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.preset03;
			});
			},
			'/seqStep13'
		);
		~seqStepBut14.free;
		~seqStepBut14 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.preset03;
			});
			},
			'/seqStep14'
		);
		~seqStepBut15.free;
		~seqStepBut15 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.second8back;
			});
			},
			'/seqStep15'
		);

		~seqStepBut16.free;
		~seqStepBut16 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				this.backward;
			});
			},
			'/seqStep16'
		);

	}



}