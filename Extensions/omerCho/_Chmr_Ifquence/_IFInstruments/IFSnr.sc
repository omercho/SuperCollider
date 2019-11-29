/*
IFSnr.times(4);


PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

IFSequence.step(~stepNumP.next);
IFSnr(~tmMulSnrP.next*~tmSnrP.next);

~vSamp.noteOn(~smp06, ~smpLvl, 120);


*/

IFSnr {
	classvar <>counter2=0, <>counter3=0, timeCnt=0;
	var <>sTime=1;
	/**initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.cntrl; });*/
		}
	}*/
	*load {
		this.globals;
		this.proxy;
		this.makeOSCResponders;
	}
	*globals{
		~chSnr=1;
		~snrLate=0.00;
		~snrTimes=1;
		~rootSnr=0;
		~harmSnr=0;
		~susMulSnr=1;
		~trSnr=0;
		~octMulSnr=0;

		~lfoMulSnr=1;

		~quantSnr1=0.0;
		~quantSnr2=0.0;
	}
	*proxy {
		~actSnr = PatternProxy( Pseq([1], inf));
		~actSnrP= Pseq([~actSnr], inf).asStream;

		~rootSnr = PatternProxy( Pseq([0], inf));
		~rootSnrP = Pseq([~rootSnr], inf).asStream;
		~nt1Snr = PatternProxy( Pseq([0], inf));
		~nt1SnrP = Pseq([~nt1Snr], inf).asStream;
		~nt2Snr = PatternProxy( Pseq([0], inf));
		~nt2SnrP = Pseq([~nt2Snr], inf).asStream;
		~nt3Snr = PatternProxy( Pseq([0], inf));
		~nt3SnrP = Pseq([~nt3Snr], inf).asStream;

		~amp1Snr = PatternProxy( Pseq([1], inf));
		~amp1SnrP = Pseq([~amp1Snr], inf).asStream;

		~dur1Snr = PatternProxy( Pseq([1], inf));
		~dur1SnrP = Pseq([~dur1Snr], inf).asStream;
		~durMulSnr = PatternProxy( Pseq([1], inf));
		~durMulSnrP = Pseq([~durMulSnr], inf).asStream;

		~sus1Snr = PatternProxy( Pseq([1], inf));
		~sus1SnrP = Pseq([~sus1Snr], inf).asStream;

		~act2Snr = PatternProxy( Pseq([1], inf));
		~act2SnrP= Pseq([~act2Snr], inf).asStream;

		~amp2Snr = PatternProxy( Pseq([1], inf));
		~amp2SnrP = Pseq([~amp2Snr], inf).asStream;
		~dur2Snr = PatternProxy( Pseq([1], inf));
		~dur2SnrP = Pseq([~dur2Snr], inf).asStream;
		~sus2Snr = PatternProxy( Pseq([1], inf));
		~sus2SnrP = Pseq([~sus2Snr], inf).asStream;
		~volSnr2 = PatternProxy( Pseq([0.9], inf));
		~volSnr2P = Pseq([~volSnr2], inf).asStream;
		~delta1Snr2 = PatternProxy( Pseq([1], inf));
		~delta1Snr2P = Pseq([~delta1Snr2], inf).asStream;

		~transSnr = PatternProxy( Pseq([0], inf));
		~transSnrP = Pseq([~transSnr], inf).asStream;
		~transShufSnr = PatternProxy( Pseq([0], inf));
		~transShufSnrP = Pseq([~transShufSnr], inf).asStream;
		~transCntSnr = PatternProxy( Pseq([0], inf));
		~transCntSnrP = Pseq([~transCntSnr], inf).asStream;

		~extraShufSnr = PatternProxy( Pshuf([0], inf));
		~extraShufSnrP = Pseq([~extraShufSnr], inf).asStream;

		~octSnr = PatternProxy( Pseq([3], inf));
		~octSnrP = Pseq([~octSnr], inf).asStream;

		~hrmSnr = PatternProxy( Pseq([1.0], inf));
		~hrmSnrP = Pseq([~hrmSnr], inf).asStream;

		~actSnrLfo1 = PatternProxy( Pseq([0], inf));
		~actSnrLfo1P= Pseq([~actSnrLfo1], inf).asStream;

		~volSnr = PatternProxy( Pseq([0.9], inf));
		~volSnrP = Pseq([~volSnr], inf).asStream;

		~delta1VSamp06 = PatternProxy( Pseq([1/1], inf));
		~delta1VSamp06P = Pseq([~delta1VSamp06], inf).asStream;

		~delta2VSamp06 = PatternProxy( Pseq([1/1], inf));
		~delta2VSamp06P = Pseq([~delta2VSamp06], inf).asStream;

		~lfoMulSnr=1;
		~lfo1Snr = PatternProxy( Pseq([1], inf));
		~lfo1SnrP = Pseq([~lfo1Snr], inf).asStream;
		~lfo2Snr = PatternProxy( Pseq([1], inf));
		~lfo2SnrP = Pseq([~lfo2Snr], inf).asStream;

	}//*proxy
	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~snrLate.wait;
				this.p1(val);
				((~dur1SnrP.next)*(~durMulSnrP.next)/val).wait;
			}}.fork;
		}
	}
	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chSnr,
			\type, \midi, \midiout,~vAmbk, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1SnrP.next], ~actSnrP.next),
			\degree, Pseq([~nt1SnrP.next], inf),
			\amp, Pseq([~volSnrP.next*~amp1SnrP.next], inf),
			\sustain, Pseq([~sus1SnrP.next],inf)*~susMulSnr,
			\mtranspose, Pseq([~transSnrP.next], inf)+~extraShufSnrP.next+~transShufSnrP.next+~transCntSnrP.next+~trSnr,
			\ctranspose, Pseq([~rootSnrP.next],inf),
			\octave, Pseq([~octSnrP.next], inf)+~octMulSnr,
			\harmonic, Pseq([~hrmSnrP.next], inf)+~harmSnr
		).play(~clkSnr,quant:~quantSnr1);
		//snr2

	}
	*p2{
		Pbind(
			\chan, ~chSnr,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur2SnrP.next], ~act2SnrP),
			\degree, Pseq([~nt2SnrP.next], inf),
			\amp, Pseq([~volSnr2P.next*~amp2SnrP.next], inf),
			\sustain, Pseq([~sus2SnrP.next],inf)*~susMulSnr,
			\harmonic, Pseq([~hrmSnrP.next], inf)+~harmSnr
		).play(~clkSnr,quant:~quantSnr2);

	}

	//      NEW OSC
	*set{|key,val|
		var vel, valNew;
		vel=val*127;
		key.switch(
			/*\timeM,{
				if ( val==1, {
					~apcMn.noteOn(~apcMnCh, ~actButA4, 1);
					~tmMulSnr.source = Pseq([2], inf);
				});
			},*/
			\octMDcr,{
				if ( val==1, {
					~crntSnr_octM=~crntSnr_octM-1;
					IFSnr.set1(\octM,~crntSnr_octM);
				});
			},
			\octMIcr,{
				if ( val==1, {
					~crntSnr_octM=~crntSnr_octM+1;
					IFSnr.set1(\octM,~crntSnr_octM);
				});
			},
			\octMZero,{
				if ( val==1, {
					IFSnr.set1(\octM,0);
				});
			},
		);
	}
	*lbl1{|key,val1=0|
		~tOSCAdrr.sendMsg(key,val1);
	}
	*set1{|key,val1=0|
		var vel1;
		vel1=val1*127;
		key.switch(
			\vol, {
				~crntSnr_vol=val1;
				this.lbl1(\volSnr,val1);
				~volSnr.source = val1;
				~mdOut.control(3, 1, vel1);
			},
			\octM, {
				~crntSnr_octM=val1;
				this.lbl1(\IFoctMSnrLbl,val1);
				~octMulSnr = val1;
			},
			\susM, {
				~crntSnr_susM=val1;
				this.lbl1(\IFsusMSnr,val1);
				~susMulSnr=val1;
			},
			\dec, {
				~crntSnr_dec=val1;
				this.lbl1(\IFdecSnr,val1);
				~mdOut.control(3, 127, vel1);
			},
			\dly, {
				~crntSnr_sus=val1;
				this.lbl1(\IFdlySnr,val1);
				//~mdOut.control(5, 6, vel1);
			},
			\pan, {
				~crntSnr_pan=val1;
				this.lbl1(\IFpanSnr,val1);
				//~mdOut.control(5, 8, vel1);
			},

		);
	}
	*lbl2{|key, val1=0, val2=0|
		var chan;
		~tOSCAdrr.sendMsg(key,val1,val2);
	}
	*set2{|key, val1=0, val2=0|
		var vel1,vel2;
		vel1=val1*127;
		vel2=val2*127;
		key.switch(
			\send, {
				this.lbl2(\sendSnr,val1,val2);
				~mdOut.control(3, 4, vel1); // IFSnr
				~mdOut.control(3, 3, vel2); // IFSnr
				~crntSnr_sndY=val1;
				~crntSnr_sndX=val2;
			},
		);
	}
	*oscResp{|respName,oscName,playTag|
		OSCdef(respName, {|msg|
			var val, val1,val2;
			val= msg[1];
			val1= msg[1];
			val2= msg[2];
			playTag.switch(
				'octMDcrSnr_T', { this.set(\octMDcr,val);},
				'octMIcrSnr_T', { this.set(\octMIcr,val);},
				'octMZeroSnr_T', { this.set(\octMZero,val);},
				//-GlobalSettings
				'volSnr_T' , { this.set1(\vol,val1);},
				'octMSnr_T', { this.set1(\octM,val1);},
				'susMSnr_T', { this.set1(\susM,val1);},
				'decSnr_T' , { this.set1(\dec,val1);},
				'susSnr_T' , { this.set1(\dly,val1);},
				'panSnr_T' , { this.set1(\pan,val1);},
				'sendSnr_T', { this.set2(\send,val1,val2);},

			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\octMDcrSnrResp, oscName:\IFoctMDcrSnr, playTag:'octMDcrSnr_T');
		this.oscResp(respName:\octMIcrSnrResp, oscName:\IFoctMIcrSnr, playTag:'octMIcrSnr_T');
		this.oscResp(respName:\octMZeroSnrResp, oscName:\IFoctMZeroSnr, playTag:'octMZeroSnr_T');
		//-GlobalSettings
		this.oscResp(respName:\volSnrResp, oscName:\IFvolSnr, playTag:'volSnr_T');
		this.oscResp(respName:\octMSnrResp, oscName:\IFoctMSnr, playTag:'octMSnr_T');
		this.oscResp(respName:\susMSnrResp, oscName:\IFsusMSnr, playTag:'susMSnr_T');
		this.oscResp(respName:\decSnrResp, oscName:\IFdecSnr, playTag:'decSnr_T');
		this.oscResp(respName:\dlySnrResp, oscName:\IFdlySnr, playTag:'dlySnr_T');
		this.oscResp(respName:\panSnrResp, oscName:\IFpanSnr, playTag:'panSnr_T');
		this.oscResp(respName:\sendSnrResp, oscName:\IFsendSnr, playTag:'sendSnr_T');
	}


}
IFTxtSnr{
	classvar <>file;
	*crtRndLines{|trck,prt,inst|
		var cnt=1, min=0,max=1,seq;
		var amp,oct,octV1,nt,ntV1,ntV2,vel,susT,tm,dur,shuf;
		var vol,octM,susM,dec,dly,pan,sndA,sndB;
		amp=  Pwhite(0,   1,   inf).asStream;
		octV1=(1..4).choose;
		oct=  Pshuf([1,octV1,1,octV1],inf).asStream;
		ntV1=(10..44).choose;
		ntV2=(44..88).choose;
		nt=   Pshuf([ntV1,ntV1,ntV1,ntV2],inf).asStream;
		vel=  Pwhite(1,   3,   inf).asStream;
		susT= Pwhite(1,   5,   inf).asStream;
		tm=   Pshuf([1,2,1,1],inf).asStream;
		dur=  Pwhite(2,   3,   inf).asStream;
		shuf= Pshuf([0,2,0,0,3,1],inf).asStream;
		vol=  Pwhite(0.8, 0.99,inf).asStream;
		octM= Pwhite(0,   1,   inf).asStream;
		susM= Pwhite(0.1, 0.9, inf).asStream;
		dec=  Pwhite(0.2, 1.0, inf).asStream;
		dly=  Pwhite(0.1, 0.9, inf).asStream;
		pan=  Pwhite(0.1, 0.9, inf).asStream;
		sndA= Pwhite(0.0, 0.3, inf).asStream;
		sndB= Pwhite(0.0, 0.2, inf).asStream;
		fork{
			IFTxt.ifPath(trck,prt,inst);
			file=File.new(IFTxt.ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..136).do{|n|
				case
				{cnt>0&&cnt<=16}   {seq=amp.next}//amp
				{cnt>16&&cnt<=32}  {seq=oct.next}//oct
				{cnt>32&&cnt<=48}  {seq=nt.next}//nt
				{cnt>48&&cnt<=64}  {seq=vel.next}//vel
				{cnt>64&&cnt<=80}  {seq=susT.next}//susT
				{cnt>80&&cnt<=96}  {seq=tm.next}//tm
				{cnt>96&&cnt<=112} {seq=dur.next}//dur
				{cnt>112&&cnt<=128}{seq=shuf.next}//Shuf
				{cnt==129}     {seq=vol.next}//Vol
				{cnt==130}     {seq=octM.next}//OctMul
				{cnt==131}     {seq=susM.next}//SusMul
				{cnt==132}     {seq=dec.next}//dec
				{cnt==133}     {seq=dly.next}//rls
				{cnt==134}     {seq=pan.next}//pan
				{cnt==135}     {seq=sndA.next}//sndX
				{cnt==136}     {seq=sndB.next};//sndY
				file.write(seq.asString ++ if (n % 16 != 0, ",", Char.nl));
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}
	*make{|trck,prt,inst,lines|
		lines.switch(
			'rndSnrTag',{
				fork{
					this.crtRndLines(trck,prt,inst);
					0.1.wait;
					IFTxt.readIfTrack(trck,prt,inst);
					0.1.wait;
				};
			};
		)
	}
	*makeDflt{
		IFTxtSnr.make(\01,\00,\ifSnr,'rndSnrTag');
	}
	*read{|trck,prtDir|

		IFTxt.readIfTrack(trck,prtDir,\ifSnr);
		~tSnAmp=IFTxt.line(1);
		~tSnOct=IFTxt.line(2);
		~tSnNt=IFTxt.line(3);
		~tSnVel=IFTxt.line(4);
		~tSnSus=IFTxt.line(5);
		~tSnTm=IFTxt.line(6);
		~tSnDur=IFTxt.line(7);
		~tSnShuf=IFTxt.line(8);
		~tSnGlob=IFTxt.line(9);

		this.storeVals;
	}
	*storeVals{//////
		"Store Snr Values from Txt to Patterns ".postln;
		//[ Snr ]
		IFSeqSnr.stGrpSet    (
			~tSnAmp[0],~tSnAmp[1],~tSnAmp[2],~tSnAmp[3],
			~tSnAmp[4],~tSnAmp[5],~tSnAmp[6],~tSnAmp[7],
			~tSnAmp[8],~tSnAmp[9],~tSnAmp[10],~tSnAmp[11],
			~tSnAmp[12],~tSnAmp[13],~tSnAmp[14],~tSnAmp[15],
		);
		IFSeqOctSnr.stGrpSet  (
			~tSnOct[0],~tSnOct[1],~tSnOct[2],~tSnOct[3],
			~tSnOct[4],~tSnOct[5],~tSnOct[6],~tSnOct[7],
			~tSnOct[8],~tSnOct[9],~tSnOct[10],~tSnOct[11],
			~tSnOct[12],~tSnOct[13],~tSnOct[14],~tSnOct[15],
		);
		IFSeqNtSnr.stGrpSet  (
			~tSnNt[0],~tSnNt[1],~tSnNt[2],~tSnNt[3],
			~tSnNt[4],~tSnNt[5],~tSnNt[6],~tSnNt[7],
			~tSnNt[8],~tSnNt[9],~tSnNt[10],~tSnNt[11],
			~tSnNt[12],~tSnNt[13],~tSnNt[14],~tSnNt[15],
		);
		IFSeqVelSnr.stGrpSet (
			~tSnVel[0],~tSnVel[1],~tSnVel[2],~tSnVel[3],
			~tSnVel[4],~tSnVel[5],~tSnVel[6],~tSnVel[7],
			~tSnVel[8],~tSnVel[9],~tSnVel[10],~tSnVel[11],
			~tSnVel[12],~tSnVel[13],~tSnVel[14],~tSnVel[15],
		);
		IFSeqSusSnr.stGrpSet (
			~tSnSus[0],~tSnSus[1],~tSnSus[2],~tSnSus[3],
			~tSnSus[4],~tSnSus[5],~tSnSus[6],~tSnSus[7],
			~tSnSus[8],~tSnSus[9],~tSnSus[10],~tSnSus[11],
			~tSnSus[12],~tSnSus[13],~tSnSus[14],~tSnSus[15],
		);
		IFSeqTmSnr.stGrpSet  (
			~tSnTm[0],~tSnTm[1],~tSnTm[2],~tSnTm[3],
			~tSnTm[4],~tSnTm[5],~tSnTm[6],~tSnTm[7],
			~tSnTm[8],~tSnTm[9],~tSnTm[10],~tSnTm[11],
			~tSnTm[12],~tSnTm[13],~tSnTm[14],~tSnTm[15],
		);
		IFSeqDurSnr.stGrpSet (
			~tSnDur[0],~tSnDur[1],~tSnDur[2],~tSnDur[3],
			~tSnDur[4],~tSnDur[5],~tSnDur[6],~tSnDur[7],
			~tSnDur[8],~tSnDur[9],~tSnDur[10],~tSnDur[11],
			~tSnDur[12],~tSnDur[13],~tSnDur[14],~tSnDur[15],
		);
		IFShuf.setSnr    (
			~tSnShuf[0],~tSnShuf[1],~tSnShuf[2],~tSnShuf[3],
			~tSnShuf[4],~tSnShuf[5],~tSnShuf[6],~tSnShuf[7],
			~tSnShuf[8],~tSnShuf[9],~tSnShuf[10],~tSnShuf[11],
			~tSnShuf[12],~tSnShuf[13],~tSnShuf[14],~tSnShuf[15],
		);
		IFGlobal.setSnr  (
			~tSnGlob[0],~tSnGlob[1],~tSnGlob[2],~tSnGlob[3],
			~tSnGlob[4],~tSnGlob[5],~tSnGlob[6],~tSnGlob[7],
			~tSnGlob[8],~tSnGlob[9],~tSnGlob[10],~tSnGlob[11],
			~tSnGlob[12],~tSnGlob[13],~tSnGlob[14],~tSnGlob[15],
		);


	}//////
}
