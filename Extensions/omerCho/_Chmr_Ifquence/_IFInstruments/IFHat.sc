
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
		this.osc;
		this.makeOSCResponders;
	}

	*globals{
		~chHat=2;
		~lateHat=0.00;
		~hatTimes=1;
		~susMulHat=1;
		~trHat=0;
		~octMulHat=0;
		~volCHat=1;

		~lfoMulHat=1;

		~quantHat1=0.0;
		~quantHat2=0.0;

	}

	*proxy {
		~actHat = PatternProxy( Pseq([1], inf));
		~actHatP= Pseq([~actHat], inf).asStream;
		~nt1Hat = PatternProxy( Pseq([0], inf));
		~nt1HatP = Pseq([~nt1Hat], inf).asStream;
		~amp1Hat = PatternProxy( Pseq([1], inf));
		~amp1HatP = Pseq([~amp1Hat], inf).asStream;
		~dur1Hat = PatternProxy( Pseq([1], inf));
		~dur1HatP = Pseq([~dur1Hat], inf).asStream;
		~durMulHat = PatternProxy( Pseq([1], inf));
		~durMulHatP = Pseq([~durMulHat], inf).asStream;
		~sus1Hat = PatternProxy( Pseq([1], inf));
		~sus1HatP = Pseq([~sus1Hat], inf).asStream;
		~volHat = PatternProxy( Pseq([1.0], inf));
		~volHatP = Pseq([~volHat], inf).asStream;

		~act2Hat = PatternProxy( Pseq([1], inf));
		~act2HatP= Pseq([~act2Hat], inf).asStream;
		~nt2Hat = PatternProxy( Pseq([0], inf));
		~nt2HatP = Pseq([~nt2Hat], inf).asStream;
		~amp2Hat = PatternProxy( Pseq([1], inf));
		~amp2HatP = Pseq([~amp2Hat], inf).asStream;
		~dur2Hat = PatternProxy( Pseq([1], inf));
		~dur2HatP = Pseq([~dur2Hat], inf).asStream;
		~sus2Hat = PatternProxy( Pseq([1], inf));
		~sus2HatP = Pseq([~sus2Hat], inf).asStream;
		~volHat2 = PatternProxy( Pseq([0.9], inf));
		~volHat2P = Pseq([~volHat2], inf).asStream;

		~delta1Hat2 = PatternProxy( Pseq([1], inf));
		~delta1Hat2P = Pseq([~delta1Hat2], inf).asStream;

		~transHat = PatternProxy( Pseq([0], inf));
		~transHatP = Pseq([~transHat], inf).asStream;
		~transShufHat = PatternProxy( Pseq([0], inf));
		~transShufHatP = Pseq([~transShufHat], inf).asStream;
		~extraShufHat = PatternProxy( Pshuf([0], inf));
		~extraShufHatP = Pseq([~extraShufHat], inf).asStream;

		~octHat = PatternProxy( Pseq([3], inf));
		~octHatP = Pseq([~octHat], inf).asStream;

		~hrmHat = PatternProxy( Pseq([1.0], inf));
		~hrmHatP = Pseq([~hrmHat], inf).asStream;

		~actHatLfo1 = PatternProxy( Pseq([0], inf));
		~actHatLfo1P= Pseq([~actHatLfo1], inf).asStream;

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

	*hat2{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				this.p2(val);
				((~dur2HatP.next)*(~durMul2P.next)/val).wait;
			}}.fork;
		}

	}
	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chHat,
			\type, \midi, \midiout,~vAmbk, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1HatP.next],~actHatP),
			\degree, Pseq([~nt1HatP.next], inf),
			\amp, Pseq([~volHatP.next*~amp1HatP.next], inf),
			\sustain, Pseq([~sus1HatP.next],inf)*~susMulHat,
			\mtranspose, Pseq([~transHatP.next], inf)+~trHat+~transShufHatP.next,
			\octave, Pseq([~octHatP.next], inf)+~octMulHat,
			\harmonic, Pseq([~hrmHatP.next], inf)+~harmHat
		).play(~clkHat,quant: ~quantHat1);
	}
	*p2{|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chHat,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur2HatP.next], ~act2HatP),
			\degree, Pseq([~nt2HatP.next], inf),
			\amp, Pseq([~volHat2P.next*~amp2HatP.next], inf),
			\sustain, Pseq([~sus2HatP.next],inf)*~susMulHat,
			\harmonic, Pseq([~hrmHatP.next], inf)+~harmHat
		).play(~clkHat,quant:~quantHat2);
	}

	*osc {

		~actHatBut.free;
		~actHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actHat.source=1;
				~apcMn.noteOn(~apcMnCh, ~actButA3, 127); //Trk1_But 1

			},{
				~actHat.source=0;
				~apcMn.noteOff(~apcMnCh, ~actButA3, 127); //Trk1_But 1

			});
		},
		'/activHat'
		);

		~time2HatBut.free;
		~countTime2Hat=0;
		~time2HatBut= OSCFunc({
			arg msg;

			~countTime2Hat = ~countTime2Hat + 1;
			~countTime2Hat.switch(
				0,{},
				1, {

					//~apcMn.noteOn(~apcMnCh, ~actButB3, 1);
					//~tOSCAdrr.sendMsg('time2Hat', 1);
					//~tOSCAdrr.sendMsg('tmHatLabel', 2);
					//~tmMulHat.source = Pseq([2], inf);
				},
				2,{

					//~apcMn.noteOn(~apcMnCh, ~actButB3, 0);
					//~tOSCAdrr.sendMsg('time2Hat', 0);
					//~tOSCAdrr.sendMsg('tmHatLabel', 1);
					//~tmMulHat.source = Pseq([1], inf);
					~countTime2Hat=0;
			});
		},
		'/time2Hat'
		);

	}

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
			\dec, {
				~crntHat_dec=val1;
				this.lbl1(\IFdecHat,val1);
				~mdOut.control(4, 127, vel1);
			},
			\dly, {
				~crntHat_sus=val1;
				this.lbl1(\IFdlyHat,val1);
				//~mdOut.control(5, 6, vel1);
			},
			\pan, {
				~crntHat_pan=val1;
				this.lbl1(\IFpanHat,val1);
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
				this.lbl2(\sendHat,val1,val2);
				~mdOut.control(4, 4, vel1); // IFHat
				~mdOut.control(4, 3, vel2); // IFHat
				~crntHat_sndY=val1;
				~crntHat_sndX=val2;
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
				'octMHat_T', { this.set1(\octM,val1);},
				'susMHat_T', { this.set1(\susM,val1);},
				'decHat_T' , { this.set1(\dec,val1);},
				'susHat_T' , { this.set1(\dly,val1);},
				'panHat_T' , { this.set1(\pan,val1);},
				'sendHat_T', { this.set2(\send,val1,val2);},

			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\octMDcrHatResp, oscName:\IFoctMDcrHat, playTag:'octMDcrHat_T');
		this.oscResp(respName:\octMIcrHatResp, oscName:\IFoctMIcrHat, playTag:'octMIcrHat_T');
		this.oscResp(respName:\octMZeroHatResp, oscName:\IFoctMZeroHat, playTag:'octMZeroHat_T');
		//-GlobalSettings
		this.oscResp(respName:\volHatResp, oscName:\IFvolHat, playTag:'volHat_T');
		this.oscResp(respName:\octMHatResp, oscName:\IFoctMHat, playTag:'octMHat_T');
		this.oscResp(respName:\susMHatResp, oscName:\IFsusMHat, playTag:'susMHat_T');
		this.oscResp(respName:\decHatResp, oscName:\IFdecHat, playTag:'decHat_T');
		this.oscResp(respName:\dlyHatResp, oscName:\IFdlyHat, playTag:'dlyHat_T');
		this.oscResp(respName:\panHatResp, oscName:\IFpanHat, playTag:'panHat_T');
		this.oscResp(respName:\sendHatResp, oscName:\IFsendHat, playTag:'sendHat_T');
	}

}

IFTxtHat{
	classvar <>file;
	*crtRndLines{|trck,prt,inst|
		var cnt=1, min=0,max=1,seq;
		var amp,oct,octV1,nt,ntV1,ntV2,vel,susT,tm,dur,shuf;
		var vol,octM,susM,dec,dly,pan,sndA,sndB;
		amp=  [
			Pseq([1],inf).asStream,Pshuf([0,1],inf).asStream,
			Pshuf([1,0,0],inf).asStream,Pshuf([1,0,0,0],inf).asStream,
			Pshuf([1,0,1,0],inf).asStream,Pshuf([1,0,1,1],inf).asStream
		].choose;
		octV1=(2..5).choose;
		oct=  Pshuf([1,1,1,octV1],inf).asStream;
		ntV1=(10..44).choose;
		ntV2=(44..88).choose;
		nt=   Pshuf([ntV1,ntV1,ntV1,ntV2],inf).asStream;
		vel=  Pwhite(1,   3,   inf).asStream;
		susT= Pwhite(1,   5,   inf).asStream;
		tm=   Pshuf([1,2,1,1,1,2,1,1],inf).asStream;
		dur=  Pwhite(2,   4,   inf).asStream;
		shuf= Pshuf([0,2,0,1,0,1,2,0],inf).asStream;
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
		~tHtGlob=IFTxt.line(9);

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
		IFShuf.setHat    (
			~tHtShuf[0],~tHtShuf[1],~tHtShuf[2],~tHtShuf[3],
			~tHtShuf[4],~tHtShuf[5],~tHtShuf[6],~tHtShuf[7],
			~tHtShuf[8],~tHtShuf[9],~tHtShuf[10],~tHtShuf[11],
			~tHtShuf[12],~tHtShuf[13],~tHtShuf[14],~tHtShuf[15],
		);
		IFGlobal.setHat  (
			~tHtGlob[0],~tHtGlob[1],~tHtGlob[2],~tHtGlob[3],
			~tHtGlob[4],~tHtGlob[5],~tHtGlob[6],~tHtGlob[7],
			~tHtGlob[8],~tHtGlob[9],~tHtGlob[10],~tHtGlob[11],
			~tHtGlob[12],~tHtGlob[13],~tHtGlob[14],~tHtGlob[15],
		);
	}//////
}
