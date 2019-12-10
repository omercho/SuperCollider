
/*

IFHat.p1(1);

~actHat.source=1;
*/

IFHat {
	classvar <>counter3=0, timeCnt=0;
	var<>hTime=1;
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
		~chHat=2;
		~actHat=1;
		~lateHat=0.00;
		~hatTimes=1;
		~octMulHat=0;
		~trHat=0;
		~rootHat=0;
		~harmHat=0;
		~susMulHat=1;
		~lfoMulHat1=0.2;
		~lfoMulHat2=0.2;

		~quantHat1=0.0;
		~quantHat2=0.0;

	}

	*proxy {


		~rootHat = PatternProxy( Pseq([0], inf));
		~rootHatP = Pseq([~rootHat], inf).asStream;
		~nt1Hat = PatternProxy( Pseq([0], inf));
		~nt1HatP = Pseq([~nt1Hat], inf).asStream;

		~dur1Hat = PatternProxy( Pseq([1], inf));
		~dur1HatP = Pseq([~dur1Hat], inf).asStream;
		~durMulHat = PatternProxy( Pseq([1], inf));
		~durMulHatP = Pseq([~durMulHat], inf).asStream;

		~amp1Hat = PatternProxy( Pseq([1], inf));
		~amp1HatP = Pseq([~amp1Hat], inf).asStream;
		~sus1Hat = PatternProxy( Pseq([1], inf));
		~sus1HatP = Pseq([~sus1Hat], inf).asStream;


		~transHat = PatternProxy( Pseq([0], inf));
		~transHatP = Pseq([~transHat], inf).asStream;
		~transShufHat = PatternProxy( Pseq([0], inf));
		~transShufHatP = Pseq([~transShufHat], inf).asStream;
		~transCntHat = PatternProxy( Pseq([0], inf));
		~transCntHatP = Pseq([~transCntHat], inf).asStream;
		~extraShufHat = PatternProxy( Pshuf([0], inf));
		~extraShufHatP = Pseq([~extraShufHat], inf).asStream;
		~octHat = PatternProxy( Pseq([3], inf));
		~octHatP = Pseq([~octHat], inf).asStream;
		~hrmHat = PatternProxy( Pseq([1.0], inf));
		~hrmHatP = Pseq([~hrmHat], inf).asStream;

		~actHat = PatternProxy( Pseq([1], inf));
		~actHatP= Pseq([~actHat], inf).asStream;
		~volHat = PatternProxy( Pseq([1.0], inf));
		~volHatP = Pseq([~volHat], inf).asStream;

		~delta1VSamp07 = PatternProxy( Pseq([1/1], inf));
		~delta1VSamp07P = Pseq([~delta1VSamp07], inf).asStream;
		~delta2VSamp07 = PatternProxy( Pseq([1/1], inf));
		~delta2VSamp07P = Pseq([~delta2VSamp07], inf).asStream;

		~lfo1Hat = PatternProxy( Pseq([1], inf));
		~lfo1HatP = Pseq([~lfo1Hat], inf).asStream;
		~lfo2Hat = PatternProxy( Pseq([1], inf));
		~lfo2HatP = Pseq([~lfo2Hat], inf).asStream;

	}//proxy

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~lateHat.wait;
				this.p1(val);
				((~dur1HatP.next)*(~durMulHatP.next)/val).wait;
			}}.fork;
		}
	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chAbk3,
			\type, \midi, \midiout,~vAmbk, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1HatP.next],~actHatP),
			\degree,  Pseq([~nt1HatP.next], inf),
			\amp, Pseq([~volHatP.next*~amp1HatP.next], inf),
			\sustain, Pseq([~sus1HatP.next],inf)*~susMulHat,
			\mtranspose, Pseq([~transHatP.next], inf)+~extraShufHatP.next+~transShufHatP.next+~transCntHatP.next+~trHat,
			\ctranspose, Pseq([~rootHatP.next],inf),
			\octave, Pseq([~octHatP], inf)+~octMulHat,
			\harmonic, Pseq([~hrmHatP.next], inf)+~harmHat,
		).play(~clkHat,quant: ~quantHat1);

		Pbind(//LFO CUT Hat INT
			\midicmd, \control, \type, \midi,
			\midiout,~vAmbk, \chan, ~chAbk3, \ctlNum, ~envDecVB,
			\delta, Pseq([~delta1HatP.next], 1),
			\control, Pseq([~lfo1HatP.value], 1)*~lfoMulHat1,
		).play(~clkHat, quant: 0);
		Pbind(//LFO CUT Hat RATE
			\midicmd, \control, \type, \midi,
			\midiout,~vAmbk, \chan, ~chAbk3, \ctlNum, ~slideTm,
			\delta, Pseq([~delta2HatP.next], 1),
			\control, Pseq([~lfo2HatP.value], 1)*~lfoMulHat2,
		).play(~clkHat, quant: 0);
	}
	*lng{|deg=0,amp=1,sus=4|
		Pbind(
			\chan, ~chAbk1,
			\type, \midi, \midiout,~vAmbk, \scale, Pfunc({~scl2},inf),
			\dur, Pseq([~dur1LngHatP.next],1)+sus,
			\ctranspose, Pseq([~rootLngHatP.next],inf),
			\degree, Pseq([~nt1LngHatP.next],inf)+deg,
			\amp, Pseq([~volHatP.next*~amp1LngHatP.next],inf)+amp,
			\sustain, Pseq([~sus1LngHatP.next],inf)+sus,
			\mtranspose, Pseq([~transLngHatP.next],inf)+~transShufLngHatP.next+~transCntHatP.next,
			\octave, Pseq([~octHatP.next],inf)+~octMulHat,
			\harmonic, Pseq([~hrmHatP.next],inf)+~harmHat
		).play(~clkHat, quant: 0);
	}//lng

	//      NEW OSC
	*set{|key,val|
		var vel, valNew;
		vel=val*127;
		key.switch(
			/*\timeM,{
				if ( val==1, {
					~apcMn.noteOn(~apcMnCh, ~actButA4, 1);
					~tmMulHat.source = Pseq([2], inf);
				});
			},*/
			\octMDcr,{
				if ( val==1, {
					~crntHat_octM=~crntHat_octM-1;
					IFHat.set1(\octM,~crntHat_octM);
				});
			},
			\octMIcr,{
				if ( val==1, {
					~crntHat_octM=~crntHat_octM+1;
					IFHat.set1(\octM,~crntHat_octM);
				});
			},
			\octMZero,{
				if ( val==1, {
					IFHat.set1(\octM,0);
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
				~crntHat_vol=val1;
				this.lbl1(\volHat,val1);
				~volHat.source = val1;
				~mdOut.control(4, 1, vel1);
			},
			\att, {
				~crntHat_att=val1;
				this.lbl1(\IFattHat,val1);

				~mdOut.control(2, 5, vel1);
			},
			\dec, {
				~crntHat_dec=val1;
				this.lbl1(\IFdecHat,val1);
				~mdOut.control(4, 127, vel1);
			},
			\sus, {
				~crntHat_sus=val1;
				this.lbl1(\IFsusHat,val1);
				~mdOut.control(2, 6, vel1);
			},
			\rls, {
				~crntHat_rls=val1;
				this.lbl1(\IFrlsHat,val1);
				~mdOut.control(2, 8, vel1);
			},
			\pan, {
				~crntHat_pan=val1;
				this.lbl1(\IFpanHat,val1);
				//~mdOut.control(5, 8, vel1);
			},
			\octM, {
				~crntHat_octM=val1;
				this.lbl1(\IFoctMHatLbl,val1);
				~octMulHat = val1;
			},
			\susM, {
				~crntHat_susM=val1;
				this.lbl1(\IFsusMHat,val1);
				~susMulHat=val1;
			},
			\lfoM1, {
				~crntHat_lfoM1=val1;
				this.lbl1(\IFlfoM1Hat,val1);
				~lfoMulHat1=val1;
			},
			\lfoM2, {
				~crntHat_lfoM2=val1;
				this.lbl1(\IFlfoM2Hat,val1);
				~lfoMulHat2=val1;
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
				this.lbl2(\sendHat,val1,val2);
				~mdOut.control(4, 4, vel1); // IFHat
				~mdOut.control(4, 3, vel2); // IFHat
				~crntHat_sndY=val1;
				~crntHat_sndX=val2;
			},
			\xy1, {
				this.lbl2(\IFxy1Hat,val1,val2);

				~mdOut.control(5, 13, vel2); //FX Comp
				~mdOut.control(5, 14, vel1); //FX Comp
				~crntHat_xy1X=val2;
				~crntHat_xy1Y=val1;
			},
			\xy2, {
				this.lbl2(\IFxy2Hat,val1,val2);

				~crntHat_xy2X=val2;
				~crntHat_xy2Y=val1;
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
				'octMDcrHat_T', { this.set(\octMDcr,val);},
				'octMIcrHat_T', { this.set(\octMIcr,val);},
				'octMZeroHat_T', { this.set(\octMZero,val);},
				//-GlobalSettings
				'volHat_T' , { this.set1(\vol,val1);},
				'attHat_T' , { this.set1(\att,val1);},
				'decHat_T' , { this.set1(\dec,val1);},
				'susHat_T' , { this.set1(\sus,val1);},
				'rlsHat_T' , { this.set1(\rls,val1);},
				'panHat_T' , { this.set1(\pan,val1);},
				'sendHat_T', { this.set2(\send,val1,val2);},
				'susMHat_T', { this.set1(\susM,val1);},
				'octMHat_T', { this.set1(\octM,val1);},
				'xy1Hat_T' , { this.set2(\xy1,val1,val2);},
				'xy2Hat_T' , { this.set2(\xy2,val1,val2);},
				'lfoM1Hat_T',{ this.set1(\lfoM1,val1);},
				'lfoM2Hat_T',{ this.set1(\lfoM2,val1);},

			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\octMDcrHatResp, oscName:\IFoctMDcrHat, playTag:'octMDcrHat_T');
		this.oscResp(respName:\octMIcrHatResp, oscName:\IFoctMIcrHat, playTag:'octMIcrHat_T');
		this.oscResp(respName:\octMZeroHatResp, oscName:\IFoctMZeroHat, playTag:'octMZeroHat_T');
		//-GlobalSettings
		this.oscResp(respName:\volHatResp, oscName:\IFvolHat, playTag:'volHat_T');
		this.oscResp(respName:\attHatResp, oscName:\IFattHat, playTag:'attHat_T');
		this.oscResp(respName:\decHatResp, oscName:\IFdecHat, playTag:'decHat_T');
		this.oscResp(respName:\susHatResp, oscName:\IFsusHat, playTag:'susHat_T');
		this.oscResp(respName:\rlsHatResp, oscName:\IFrlsHat, playTag:'rlsHat_T');
		this.oscResp(respName:\panHatResp, oscName:\IFpanHat, playTag:'panHat_T');
		this.oscResp(respName:\sendHatResp, oscName:\IFsendHat, playTag:'sendHat_T');
		this.oscResp(respName:\susMHatResp, oscName:\IFsusMHat, playTag:'susMHat_T');
		this.oscResp(respName:\octMHatResp, oscName:\IFoctMHat, playTag:'octMHat_T');
		this.oscResp(respName:\xy1HatResp,  oscName:\IFxy1Hat, playTag:'xy1Hat_T');
		this.oscResp(respName:\xy2HatResp,  oscName:\IFxy2Hat, playTag:'xy2Hat_T');
		this.oscResp(respName:\lfoM1HatResp, oscName:\IFlfoM1Hat, playTag:'lfoM1Hat_T');
		this.oscResp(respName:\lfoM2HatResp, oscName:\IFlfoM2Hat, playTag:'lfoM2Hat_T');
	}

}

IFTxtHat{
	classvar <>file;
	*crtRndLines{|trck,prt,inst|
		var cnt=1, min=0,max=1,seq;
		var amp,oct,nt,vel,susT,tm,dur,shuf,lfoP;
		var vol,att,dec,susV,rls,pan,sndA,sndB;
		var octM,susM,xy1X,xy1Y,xy2X,xy2Y,lfoM1,lfoM2;
		amp=[
			Pseq([1],inf).asStream,Pseq([1,1,1,0],inf).asStream,
			Pseq([0,1,1,1],inf).asStream,Pshuf([1,1,1,0],inf).asStream,
			Prand([0,1],inf).asStream
		].choose;
		oct=  Pwhite(3,   3,   inf).asStream;
		nt=   [
			Pwhite(-2,   7,   inf).asStream;
			Pseq([0,0,1,0],inf).asStream,
			Pseq([0,0,0,1,0,0,1,1],inf).asStream,
			Pseq([0,0,1,0,0,0,1,1],inf).asStream,
			Pseq([0,1,1,0,0,0,1,0],inf).asStream,
			Pseq([0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1],inf).asStream,
			Pshuf([0,1,1,0,0,0,1,0,0,0,1,0,1,0,1,0],inf).asStream,
		].choose;
		vel=  Pwhite(2,   3,   inf).asStream;
		susT= Pwhite(1,   5,   inf).asStream;
		tm=   [
			Pseq([1],inf).asStream,
			Pshuf([2,1,1,1],inf).asStream,
			Pshuf([2,1,2,1],inf).asStream,
		].choose;
		dur=  Pwhite(3,   4,   inf).asStream;
		shuf= Pwhite(0,  4,   inf).asStream;
		lfoP= Pwhite(0,   127, inf).asStream;
		vol=  Pwhite(0.85, 0.99,inf).asStream;
		att=  Pwhite(0.0, 0.2, inf).asStream;
		dec=  Pwhite(0.1, 0.3, inf).asStream;
		susV= Pwhite(0.1, 0.9, inf).asStream;
		rls=  Pwhite(0.1, 0.9, inf).asStream;
		pan=  Pwhite(0.1, 0.9, inf).asStream;
		sndA= Pwhite(0.1, 0.6, inf).asStream;
		sndB= Pwhite(0.1, 0.6, inf).asStream;
		octM= Pwhite(1,   1, inf).asStream;
		susM= Pwhite(0.1, 0.2, inf).asStream;
		xy1X= Pwhite(0.0, 0.5, inf).asStream;
		xy1Y= Pwhite(0.0, 0.4, inf).asStream;
		xy2X= Pwhite(0.0, 1.0, inf).asStream;
		xy2Y= Pwhite(0.0, 1.0, inf).asStream;
		lfoM1=Pwhite(0.0, 1.0, inf).asStream;
		lfoM2=Pwhite(0.0, 1.0, inf).asStream;
		fork{
			IFTxt.ifPath(trck,prt,inst);
			file=File.new(IFTxt.ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..160).do{|n|
				case
				{cnt>0&&cnt<=16}   {seq=amp.next}//amp
				{cnt>16&&cnt<=32}  {seq=oct.next}//oct
				{cnt>32&&cnt<=48}  {seq=nt.next}//nt
				{cnt>48&&cnt<=64}  {seq=vel.next}//vel
				{cnt>64&&cnt<=80}  {seq=susT.next}//susT
				{cnt>80&&cnt<=96}  {seq=tm.next}//tm
				{cnt>96&&cnt<=112} {seq=dur.next}//dur
				{cnt>112&&cnt<=128}{seq=shuf.next}//Shuf
				{cnt>128&&cnt<=144}{seq=lfoP.next}//lfo
				{cnt==145}     {seq=vol.next}//Vol
				{cnt==146}     {seq=att.next}//Att
				{cnt==147}     {seq=dec.next}//dec
				{cnt==148}     {seq=susV.next}//sus
				{cnt==149}     {seq=rls.next}//rls
				{cnt==150}     {seq=pan.next}//pan
				{cnt==151}     {seq=sndA.next}//sndX
				{cnt==152}     {seq=sndB.next}//sndY
				{cnt==153}   {seq=octM.next}//OctMul
				{cnt==154}   {seq=susM.next}//SusMul
				{cnt==155}   {seq=xy1X.next}//xy1X
				{cnt==156}   {seq=xy1Y.next}//xy1Y
				{cnt==157}   {seq=xy2X.next}//xy2X
				{cnt==158}   {seq=xy1Y.next}//xy2Y
				{cnt==159}   {seq=lfoM1.next}//lfoMul1
				{cnt==160}   {seq=lfoM2.next};//lfoMul2
				file.write(
					seq.asString ++ if (n % 16 != 0, ",", Char.nl)
				);
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}
	*make{|trck,prt,inst,lines|
		lines.switch(
			'rndHatTag',{
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
		IFTxtHat.make(\01,\00,\ifHat,'rndHatTag');
	}
	*read{|trck,prtDir|

		IFTxt.readIfTrack(trck,prtDir,\ifHat);
		~tHtAmp=IFTxt.line(1);
		~tHtOct=IFTxt.line(2);
		~tHtNt=IFTxt.line(3);
		~tHtVel=IFTxt.line(4);
		~tHtSus=IFTxt.line(5);
		~tHtTm=IFTxt.line(6);
		~tHtDur=IFTxt.line(7);
		~tHtShuf=IFTxt.line(8);
		~tHtLfo=IFTxt.line(9);
		~tHtEnv=IFTxt.line(10);

		this.storeVals;
	}
	*storeVals{//////
		"Store Hat Values from Txt to Patterns ".postln;
		//[ Hat ]
		IFSeqHat.stGrpSet    (
			~tHtAmp[0],~tHtAmp[1],~tHtAmp[2],~tHtAmp[3],
			~tHtAmp[4],~tHtAmp[5],~tHtAmp[6],~tHtAmp[7],
			~tHtAmp[8],~tHtAmp[9],~tHtAmp[10],~tHtAmp[11],
			~tHtAmp[12],~tHtAmp[13],~tHtAmp[14],~tHtAmp[15],
		);
		IFSeqOctHat.stGrpSet  (
			~tHtOct[0],~tHtOct[1],~tHtOct[2],~tHtOct[3],
			~tHtOct[4],~tHtOct[5],~tHtOct[6],~tHtOct[7],
			~tHtOct[8],~tHtOct[9],~tHtOct[10],~tHtOct[11],
			~tHtOct[12],~tHtOct[13],~tHtOct[14],~tHtOct[15],
		);
		IFSeqNtHat.stGrpSet  (
			~tHtNt[0],~tHtNt[1],~tHtNt[2],~tHtNt[3],
			~tHtNt[4],~tHtNt[5],~tHtNt[6],~tHtNt[7],
			~tHtNt[8],~tHtNt[9],~tHtNt[10],~tHtNt[11],
			~tHtNt[12],~tHtNt[13],~tHtNt[14],~tHtNt[15],
		);
		IFSeqVelHat.stGrpSet (
			~tHtVel[0],~tHtVel[1],~tHtVel[2],~tHtVel[3],
			~tHtVel[4],~tHtVel[5],~tHtVel[6],~tHtVel[7],
			~tHtVel[8],~tHtVel[9],~tHtVel[10],~tHtVel[11],
			~tHtVel[12],~tHtVel[13],~tHtVel[14],~tHtVel[15],
		);
		IFSeqSusHat.stGrpSet (
			~tHtSus[0],~tHtSus[1],~tHtSus[2],~tHtSus[3],
			~tHtSus[4],~tHtSus[5],~tHtSus[6],~tHtSus[7],
			~tHtSus[8],~tHtSus[9],~tHtSus[10],~tHtSus[11],
			~tHtSus[12],~tHtSus[13],~tHtSus[14],~tHtSus[15],
		);
		IFSeqTmHat.stGrpSet  (
			~tHtTm[0],~tHtTm[1],~tHtTm[2],~tHtTm[3],
			~tHtTm[4],~tHtTm[5],~tHtTm[6],~tHtTm[7],
			~tHtTm[8],~tHtTm[9],~tHtTm[10],~tHtTm[11],
			~tHtTm[12],~tHtTm[13],~tHtTm[14],~tHtTm[15],
		);
		IFSeqDurHat.stGrpSet (
			~tHtDur[0],~tHtDur[1],~tHtDur[2],~tHtDur[3],
			~tHtDur[4],~tHtDur[5],~tHtDur[6],~tHtDur[7],
			~tHtDur[8],~tHtDur[9],~tHtDur[10],~tHtDur[11],
			~tHtDur[12],~tHtDur[13],~tHtDur[14],~tHtDur[15],
		);
		IFLfo.setHat    (
			~tHtLfo[0],~tHtLfo[1],~tHtLfo[2],~tHtLfo[3],
			~tHtLfo[4],~tHtLfo[5],~tHtLfo[6],~tHtLfo[7],
			~tHtLfo[8],~tHtLfo[9],~tHtLfo[10],~tHtLfo[11],
			~tHtLfo[12],~tHtLfo[13],~tHtLfo[14],~tHtLfo[15],
		);
		IFGlobal.setHat  (
			~tHtEnv[0],~tHtEnv[1],~tHtEnv[2],~tHtEnv[3],
			~tHtEnv[4],~tHtEnv[5],~tHtEnv[6],~tHtEnv[7],
			~tHtEnv[8],~tHtEnv[9],~tHtEnv[10],~tHtEnv[11],
			~tHtEnv[12],~tHtEnv[13],~tHtEnv[14],~tHtEnv[15],
		);
	}//////
}
