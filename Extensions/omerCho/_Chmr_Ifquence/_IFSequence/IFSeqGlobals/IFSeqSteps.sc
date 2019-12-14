//IFSeqSteps.forward;

IFSeqSteps {
	classvar <>list;
	*load {
		this.makeResponders;
		this.new(01,08);

	}
	*new{|directMst,direct|
		//this.srcStpMstr;
		~crntStepDir=direct;
		~stepCnt.source  =  Pseq([1], inf);
		directMst.switch(
			00,{ ~stepMaster.source=Pseq([1], inf);},
			01,{ ~stepMaster.source=Pseq([1,2], inf);},
			02,{ ~stepMaster.source=Pseq([1,2,3,4], inf);},
			03,{ ~stepMaster.source=Pseq([5,6,7,8], inf);},
			04,{ ~stepMaster.source=Pseq([9,10,11,12], inf);},
			05,{ ~stepMaster.source=Pseq([13,14,15,16], inf);},
			06,{ ~stepMaster.source=Pseq([1,2,3,4,5,6,7,8], inf);},
			07,{ ~stepMaster.source=Pseq([9,10,11,12,13,14,15,16], inf);},
			08,{ ~stepMaster.source=Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			09,{ ~stepMaster.source=Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16].reverse, inf);},
			10,{ ~stepMaster.source=Pseq([1,2,3,4,5,6,7,8].reverse, inf);},
			11,{ ~stepMaster.source=Pseq([9,10,11,12,13,14,15,16].reverse, inf);},
			12,{ ~stepMaster.source=Pseq([13,14,15,16].reverse, inf);},
			13,{ ~stepMaster.source=Pseq([9,10,11,12].reverse, inf);},
			14,{ ~stepMaster.source=Pseq([5,6,7,8].reverse, inf);},
			15,{ ~stepMaster.source=Pseq([1,2,3,4].reverse, inf);},
			16,{ ~stepMaster.source=Pseq([1,2].reverse, inf);}
		);
		direct.switch(
			00,{ this.first4;},
			01,{ this.long01;},
			02,{ this.long02;},
			03,{ this.long03;},
			04,{ this.long04;},
			05,{ this.forward;},
			06,{ this.forward2;},
			07,{ this.first8;},
			08,{ this.second8;},
			09,{ this.first8back;},
			10,{ this.second8back;},
			11,{ this.mirror;},
			12,{ this.slide1;},
			13,{ this.slide2;},
			14,{ this.random;},
			15,{ this.shuf;},
			16,{ this.backward;}
		);
		IFRoot.reset;
	}
	*srcStpMstr{
		~stepMaster.source= Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepCnt.source  =  Pseq([1], inf);
	}
	*first4{
		~tOSCAdrr.sendMsg('stepsLabel', 'First4');
		~stepNum1.source  =  Pseq([1,2,3,4], inf);
		~stepNum2.source  =  Pseq([1,2,3,4], inf);
		~stepNum3.source  =  Pseq([1,2,3,4], inf);
		~stepNum4.source  =  Pseq([1,2,3,4], inf);
	}
	*long01{
		~tOSCAdrr.sendMsg('stepsLabel', 'Long 01');
		~stepNum1.source  =  Pseq([
			1,2,3,4,5,6,7,8,
			1,2,3,4,5,6,7,8,
			1,2,3,4,5,6,7,8,
			9,10,11,12,13,14,15,16,
		], inf);
		~stepNum2.source  =  Pseq([
			1,2,3,4,5,6,7,8,
			1,2,3,4,5,6,7,8,
			1,2,3,4,5,6,7,8,
			9,10,11,12,13,14,15,16,
		], inf);
		~stepNum3.source  =  Pseq([
			1,2,3,4,5,6,7,8,
			1,2,3,4,5,6,7,8,
			1,2,3,4,5,6,7,8,
			9,10,11,12,13,14,15,16,
		], inf);
		~stepNum4.source  =  Pseq([
			1,2,3,4,5,6,7,8,
			1,2,3,4,5,6,7,8,
			1,2,3,4,5,6,7,8,
			9,10,11,12,13,14,15,16,
		], inf);
	}
	*long02{
		~tOSCAdrr.sendMsg('stepsLabel', 'Long 02');
		~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum2.source  =  Pseq([
			1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,
			1,4,3,2,5,12,7,11,1,10,3,12,1,14,6,16
		], inf);
		~stepNum3.source  =  Pseq([
			1,2,3,4,1,6,3,8,
			1,11,3,12,5,10,7,12,
			1,9,3,4,1,6,3,8,
			1,2,3,15,5,14,7,15,
			9,10,11,12,13,14,15,16
		], inf);
		~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
	}
	*long03{
		~tOSCAdrr.sendMsg('stepsLabel', 'Long 03');
		~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum2.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8].mirror, inf);
		~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
	}
	*long04{
		~tOSCAdrr.sendMsg('stepsLabel', 'Long 01');
		~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16].mirror, inf);
		~stepNum2.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8], inf);
		~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
	}
	*forward {
		~tOSCAdrr.sendMsg('stepsLabel', 'Forward');
		~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum2.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
	}
	*forward2 {
		~tOSCAdrr.sendMsg('stepsLabel', 'Forward2');
		~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum2.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16].mirror, inf);
		~stepNum4.source  =  Pseq([
			1,2,3,4,5,6,7,8,
			1,2,3,4,5,6,7,8,
			1,2,3,4,5,6,7,8,
			9,10,11,12,13,14,15,16
		], inf);
	}

	*first8 {
		~tOSCAdrr.sendMsg('stepsLabel', '1-->8');
		~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8], inf);
		~stepNum2.source  =  Pseq([1,2,3,4,5,6,7,8], inf);
		~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8], inf);
		~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8], inf);
	}

	*shuf {
		~tOSCAdrr.sendMsg('stepsLabel', 'Shuf');
		~stepNum1.source  =  Pshuf([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum2.source  =  Pshuf([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum3.source  =  Pshuf([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum4.source  =   Pseq([1,2,3,4], inf);
	}
	*random {
		~tOSCAdrr.sendMsg('stepsLabel', 'Random');
		~stepNum1.source  =  Pxrand([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum2.source  =  Pxrand([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum3.source  =  Pxrand([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
		~stepNum4.source  =   Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
	}

	*mirror {
		~tOSCAdrr.sendMsg('stepsLabel', 'Mirror');
		~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16].mirror, inf);
		~stepNum2.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16].mirror, inf);
		~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16].mirror, inf);
		~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
	}

	*slide1 {
		~tOSCAdrr.sendMsg('stepsLabel', 'Slide 4/2');
		~stepNum1.source  =  Pslide([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16],  inf, 4,1,0);
		~stepNum2.source  =  Pslide([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16],  inf, 4,2,0);
		~stepNum3.source  =  Pslide([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16],  inf, 3,1,0);
		~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
	}
	*slide2 {
		~tOSCAdrr.sendMsg('stepsLabel', 'Slide 8/2');
		~stepNum1.source  =  Pslide([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16],  inf, 8,2,0);
		~stepNum2.source  =  Pslide([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16],  inf, 8,2,0);
		~stepNum3.source  =  Pslide([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16],  inf, 8,2,0);
		~stepNum4.source  =   Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
	}
	*first8back {
		~tOSCAdrr.sendMsg('stepsLabel', '8-->1');
		~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8].reverse, inf);
		~stepNum2.source  =  Pseq([1,2,3,4,5,6,7,8].reverse, inf);
		~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8].reverse, inf);
		~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8], inf);
	}
	*second8 {
		~tOSCAdrr.sendMsg('stepsLabel', '9-->16');
		~stepNum1.source  =  Pseq([9,10,11,12,13,14,15,16], inf);
		~stepNum2.source  =  Pseq([9,10,11,12,13,14,15,16], inf);
		~stepNum3.source  =  Pseq([9,10,11,12,13,14,15,16], inf);
		~stepNum4.source  =  Pseq([9,10,11,12,13,14,15,16], inf);
	}
	*second8back {
		~tOSCAdrr.sendMsg('stepsLabel', '16-->9');
		~stepNum1.source  =  Pseq([9,10,11,12,13,14,15,16].reverse, inf);
		~stepNum2.source  =  Pseq([9,10,11,12,13,14,15,16].reverse, inf);
		~stepNum3.source  =  Pseq([9,10,11,12,13,14,15,16].reverse, inf);
		~stepNum4.source  =  Pseq([9,10,11,12,13,14,15,16], inf);
	}
	*backward {
		~tOSCAdrr.sendMsg('stepsLabel', 'Backward');
		~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16].reverse, inf);
		~stepNum2.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16].reverse, inf);
		~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16].reverse, inf);
		~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);
	}
	*preset01 {|seq|
		~tOSCAdrr.sendMsg('stepsLabel', 'SeqPrst01');
		seq.switch(
			'seqA', {~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8], inf);},
			'seqB', {~stepNum2.source  =  Pseq([1,2,3,4,5,6,7,8], inf);},
			'seqC', {~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8], inf);},
			'seqD', {~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8], inf);}
		);
	}

	*preset02 {|seq|
		~tOSCAdrr.sendMsg('stepsLabel', 'SeqPrst02');
		seq.switch(
			'seqA', {~stepNum1.source  =  Pseq([1,2,3,4], inf);},
			'seqB', {~stepNum2.source  =  Pseq([1,2,3,4], inf);},
			'seqC', {~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8], inf);},
			'seqD', {~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8], inf);}
		);
	}

	*preset03 {|seq|
		~tOSCAdrr.sendMsg('stepsLabel', 'SeqPrst03');
		seq.switch(
			'seqA', {~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8], inf);},
			'seqB', {~stepNum2.source  =  Pseq([1,2,3,4,5,6], inf);},
			'seqC', {~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8], inf);},
			'seqD', {~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8], inf);}
		);
	}
	*preset04 {|seq|
		~tOSCAdrr.sendMsg('stepsLabel', 'preset01');
		seq.switch(
			'seqA', {~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			'seqB', {~stepNum2.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			'seqC', {~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			'seqD', {~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8], inf);}
		);
	}
	*preset05 {|seq|
		~tOSCAdrr.sendMsg('stepsLabel', '1-->8');
		seq.switch(
			'seqA', {~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			'seqB', {~stepNum2.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			'seqC', {~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			'seqD', {~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8], inf);}
		);
	}
	*preset06 {|seq|
		~tOSCAdrr.sendMsg('stepsLabel', '1-->8');
		seq.switch(
			'seqA', {~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			'seqB', {~stepNum2.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			'seqC', {~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			'seqD', {~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8], inf);}
		);
	}
	*preset07 {|seq|
		~tOSCAdrr.sendMsg('stepsLabel', 'SeqPrst01');
		seq.switch(
			'seqA', {~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			'seqB', {~stepNum2.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			'seqC', {~stepNum3.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			'seqD', {~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8], inf);}
		);
	}
	*preset08 {|seq|
		~tOSCAdrr.sendMsg('stepsLabel', '1-->8');
		seq.switch(
			'seqA', {~stepNum1.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			'seqB', {~stepNum2.source  =  Pseq([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);},
			'seqC', {
				~stepNum3.source  =  Pseq([
					1,2,3,4,5,6,7,8,
					1,2,3,4,5,6,7,8,
					1,2,3,4,5,6,7,8,
					9,10,11,12,13,14,15,16
				], inf);
			},
			'seqD', {~stepNum4.source  =  Pseq([1,2,3,4,5,6,7,8], inf);}
		);
	}

	*makeResponders{
		//Seq1
		IFSeqSteps.oscResp(respName:'seq1StepBut01', oscName:'seqStep01', playDir:'sqA1');
		IFSeqSteps.oscResp(respName:'seq1StepBut02', oscName:'seqStep02', playDir:'sqA2');
		IFSeqSteps.oscResp(respName:'seq1StepBut03', oscName:'seqStep03', playDir:'sqA3');
		IFSeqSteps.oscResp(respName:'seq1StepBut04', oscName:'seqStep04', playDir:'sqA4');
		IFSeqSteps.oscResp(respName:'seq1StepBut05', oscName:'seqStep05', playDir:'sqA5');
		IFSeqSteps.oscResp(respName:'seq1StepBut06', oscName:'seqStep06', playDir:'sqA6');
		IFSeqSteps.oscResp(respName:'seq1StepBut07', oscName:'seqStep07', playDir:'sqA7');
		IFSeqSteps.oscResp(respName:'seq1StepBut08', oscName:'seqStep08', playDir:'sqA8');
		IFSeqSteps.oscResp(respName:'seq1StepBut09', oscName:'seqStep09', playDir:'sqA1');
		IFSeqSteps.oscResp(respName:'seq1StepBut10', oscName:'seqStep10', playDir:'sqA2');
		IFSeqSteps.oscResp(respName:'seq1StepBut11', oscName:'seqStep11', playDir:'sqA3');
		IFSeqSteps.oscResp(respName:'seq1StepBut12', oscName:'seqStep12', playDir:'sqA4');
		IFSeqSteps.oscResp(respName:'seq1StepBut13', oscName:'seqStep13', playDir:'sqA5');
		IFSeqSteps.oscResp(respName:'seq1StepBut14', oscName:'seqStep14', playDir:'sqA6');
		IFSeqSteps.oscResp(respName:'seq1StepBut15', oscName:'seqStep15', playDir:'sqA7');
		IFSeqSteps.oscResp(respName:'seq1StepBut16', oscName:'seqStep16', playDir:'sqA8');
		//Seq2
		IFSeqSteps.oscResp(respName:'seq2StepBut01', oscName:'seqStep17', playDir:'sqB1');
		IFSeqSteps.oscResp(respName:'seq2StepBut02', oscName:'seqStep18', playDir:'sqB2');
		IFSeqSteps.oscResp(respName:'seq2StepBut03', oscName:'seqStep19', playDir:'sqB3');
		IFSeqSteps.oscResp(respName:'seq2StepBut04', oscName:'seqStep20', playDir:'sqB4');
		IFSeqSteps.oscResp(respName:'seq2StepBut05', oscName:'seqStep21', playDir:'sqB5');
		IFSeqSteps.oscResp(respName:'seq2StepBut06', oscName:'seqStep22', playDir:'sqB6');
		IFSeqSteps.oscResp(respName:'seq2StepBut07', oscName:'seqStep23', playDir:'sqB7');
		IFSeqSteps.oscResp(respName:'seq2StepBut08', oscName:'seqStep24', playDir:'sqB8');
		IFSeqSteps.oscResp(respName:'seq2StepBut09', oscName:'seqStep25', playDir:'sqB1');
		IFSeqSteps.oscResp(respName:'seq2StepBut10', oscName:'seqStep26', playDir:'sqB2');
		IFSeqSteps.oscResp(respName:'seq2StepBut11', oscName:'seqStep27', playDir:'sqB3');
		IFSeqSteps.oscResp(respName:'seq2StepBut12', oscName:'seqStep28', playDir:'sqB4');
		IFSeqSteps.oscResp(respName:'seq2StepBut13', oscName:'seqStep29', playDir:'sqB5');
		IFSeqSteps.oscResp(respName:'seq2StepBut14', oscName:'seqStep30', playDir:'sqB6');
		IFSeqSteps.oscResp(respName:'seq2StepBut15', oscName:'seqStep31', playDir:'sqB7');
		IFSeqSteps.oscResp(respName:'seq2StepBut16', oscName:'seqStep32', playDir:'sqB8');
		//Seq3
		IFSeqSteps.oscResp(respName:'seq3StepBut01', oscName:'seqStep33', playDir:'sqC1');
		IFSeqSteps.oscResp(respName:'seq3StepBut02', oscName:'seqStep34', playDir:'sqC2');
		IFSeqSteps.oscResp(respName:'seq3StepBut03', oscName:'seqStep35', playDir:'sqC3');
		IFSeqSteps.oscResp(respName:'seq3StepBut04', oscName:'seqStep36', playDir:'sqC4');
		IFSeqSteps.oscResp(respName:'seq3StepBut05', oscName:'seqStep37', playDir:'sqC5');
		IFSeqSteps.oscResp(respName:'seq3StepBut06', oscName:'seqStep38', playDir:'sqC6');
		IFSeqSteps.oscResp(respName:'seq3StepBut07', oscName:'seqStep39', playDir:'sqC7');
		IFSeqSteps.oscResp(respName:'seq3StepBut08', oscName:'seqStep40', playDir:'sqC8');
		IFSeqSteps.oscResp(respName:'seq3StepBut09', oscName:'seqStep41', playDir:'sqC1');
		IFSeqSteps.oscResp(respName:'seq3StepBut10', oscName:'seqStep42', playDir:'sqC2');
		IFSeqSteps.oscResp(respName:'seq3StepBut11', oscName:'seqStep43', playDir:'sqC3');
		IFSeqSteps.oscResp(respName:'seq3StepBut12', oscName:'seqStep44', playDir:'sqC4');
		IFSeqSteps.oscResp(respName:'seq3StepBut13', oscName:'seqStep45', playDir:'sqC5');
		IFSeqSteps.oscResp(respName:'seq3StepBut14', oscName:'seqStep46', playDir:'sqC6');
		IFSeqSteps.oscResp(respName:'seq3StepBut15', oscName:'seqStep47', playDir:'sqC7');
		IFSeqSteps.oscResp(respName:'seq3StepBut16', oscName:'seqStep48', playDir:'sqC8');
		//Seq4
		IFSeqSteps.oscResp(respName:'seq4StepBut01', oscName:'seqStep49', playDir:'sqD1');
		IFSeqSteps.oscResp(respName:'seq4StepBut02', oscName:'seqStep50', playDir:'sqD2');
		IFSeqSteps.oscResp(respName:'seq4StepBut03', oscName:'seqStep51', playDir:'sqD3');
		IFSeqSteps.oscResp(respName:'seq4StepBut04', oscName:'seqStep52', playDir:'sqD4');
		IFSeqSteps.oscResp(respName:'seq4StepBut05', oscName:'seqStep53', playDir:'sqD5');
		IFSeqSteps.oscResp(respName:'seq4StepBut06', oscName:'seqStep54', playDir:'sqD6');
		IFSeqSteps.oscResp(respName:'seq4StepBut07', oscName:'seqStep55', playDir:'sqD7');
		IFSeqSteps.oscResp(respName:'seq4StepBut08', oscName:'seqStep56', playDir:'sqD8');
		IFSeqSteps.oscResp(respName:'seq4StepBut09', oscName:'seqStep57', playDir:'sqD1');
		IFSeqSteps.oscResp(respName:'seq4StepBut10', oscName:'seqStep58', playDir:'sqD2');
		IFSeqSteps.oscResp(respName:'seq4StepBut11', oscName:'seqStep59', playDir:'sqD3');
		IFSeqSteps.oscResp(respName:'seq4StepBut12', oscName:'seqStep60', playDir:'sqD4');
		IFSeqSteps.oscResp(respName:'seq4StepBut13', oscName:'seqStep61', playDir:'sqD5');
		IFSeqSteps.oscResp(respName:'seq4StepBut14', oscName:'seqStep62', playDir:'sqD6');
		IFSeqSteps.oscResp(respName:'seq4StepBut15', oscName:'seqStep63', playDir:'sqD7');
		IFSeqSteps.oscResp(respName:'seq4StepBut16', oscName:'seqStep64', playDir:'sqD8');
	}
	*oscResp{|respName,oscName,playDir|
		OSCdef(respName, {
			arg msg;
			playDir.switch(
				'sqA1',{if ( msg[1]==1, {this.preset01('seqA');});},
				'sqA2',{if ( msg[1]==1, {this.preset02('seqA');});},
				'sqA3',{if ( msg[1]==1, {this.preset03('seqA');});},
				'sqA4',{if ( msg[1]==1, {this.preset04('seqA');});},
				'sqA5',{if ( msg[1]==1, {this.preset05('seqA');});},
				'sqA6',{if ( msg[1]==1, {this.preset06('seqA');});},
				'sqA7',{if ( msg[1]==1, {this.preset07('seqA');});},
				'sqA8',{if ( msg[1]==1, {this.preset08('seqA');});},

				'sqB1',{if ( msg[1]==1, {this.preset01('seqB');});},
				'sqB2',{if ( msg[1]==1, {this.preset02('seqB');});},
				'sqB3',{if ( msg[1]==1, {this.preset03('seqB');});},
				'sqB4',{if ( msg[1]==1, {this.preset04('seqB');});},
				'sqB5',{if ( msg[1]==1, {this.preset05('seqB');});},
				'sqB6',{if ( msg[1]==1, {this.preset06('seqB');});},
				'sqB7',{if ( msg[1]==1, {this.preset07('seqB');});},
				'sqB8',{if ( msg[1]==1, {this.preset08('seqB');});},

				'sqC1',{if ( msg[1]==1, {this.preset01('seqC');});},
				'sqC2',{if ( msg[1]==1, {this.preset02('seqC');});},
				'sqC3',{if ( msg[1]==1, {this.preset03('seqC');});},
				'sqC4',{if ( msg[1]==1, {this.preset04('seqC');});},
				'sqC5',{if ( msg[1]==1, {this.preset05('seqC');});},
				'sqC6',{if ( msg[1]==1, {this.preset06('seqC');});},
				'sqC7',{if ( msg[1]==1, {this.preset07('seqC');});},
				'sqC8',{if ( msg[1]==1, {this.preset08('seqC');});},

				'sqD1',{if ( msg[1]==1, {this.preset01('seqD');});},
				'sqD2',{if ( msg[1]==1, {this.preset02('seqD');});},
				'sqD3',{if ( msg[1]==1, {this.preset03('seqD');});},
				'sqD4',{if ( msg[1]==1, {this.preset04('seqD');});},
				'sqD5',{if ( msg[1]==1, {this.preset05('seqD');});},
				'sqD6',{if ( msg[1]==1, {this.preset06('seqD');});},
				'sqD7',{if ( msg[1]==1, {this.preset07('seqD');});},
				'sqD8',{if ( msg[1]==1, {this.preset08('seqD');});}

			);
		},path:oscName);
	}

	/*
	*oscResp{|respName,oscName,playDirection|
	OSCDef(respName, {
	arg msg;
	if ( msg[1]==1, {
	playDirection.switch(
	1,{this.preset02;},
	2,{this.preset03;},
	3,{this.preset04;},
	4,{this.preset05;},
	5,{this.preset06;},
	6,{this.preset07;},
	7,{this.preset08;}
	);
	}
	);

	},oscName
	);
	}
	*/

}
