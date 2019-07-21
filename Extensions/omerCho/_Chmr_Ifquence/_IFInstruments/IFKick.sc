
/*

IFKick(4);

IFKick.synthDef(1);
~mdOut.noteOn(0, 0, 125);

*/

IFKick {

	/**initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });*/
		}
	}*/
	*load {
		this.globals;
		this.proxy;
		this.osc;
		this.makeOSCResponders;
	}

	*globals{

		~chKick=0;
		~actKick=1;
		~kickLate= 0.00;
		~kickTimes=1;
		~octMulKick=0;
		~trKick=0;
		~rootKick=0;
		~harmKick=0;
		~susMulKick=1;
		~drumVolC=0; ~kickVolC=1;
		~tuneKick=26;


		~attKick =0.001;
		~decKick =0.8;
		~relKick =0.3;
		~susLevKick = 0.01;

		~quantKick2=0.0;
	}

	*proxy {
		~actKick = PatternProxy( Pseq([1], inf));
		~actKickP= Pseq([~actKick], inf).asStream;
		~nt1Kick = PatternProxy( Pseq([~vKick], inf));
		~nt1KickP = Pseq([~nt1Kick], inf).asStream;
		~dur1Kick = PatternProxy( Pseq([1], inf));
		~dur1KickP = Pseq([~dur1Kick], inf).asStream;
		~durMulKick = PatternProxy( Pseq([1], inf));
		~durMulKickP = Pseq([~durMulKick], inf).asStream;
		~amp1Kick = PatternProxy( Pseq([1], inf));
		~amp1KickP = Pseq([~amp1Kick], inf).asStream;
		~sus1Kick = PatternProxy( Pseq([0.05], inf));
		~sus1KickP = Pseq([~sus1Kick], inf).asStream;


		~actKick2 = PatternProxy( Pseq([1], inf));
		~actKick2P= Pseq([~actKick2], inf).asStream;
		~ntKick2 = PatternProxy( Pseq([0], inf));
		~ntKick2P = Pseq([~ntKick2], inf).asStream;
		~ampKick2 = PatternProxy( Pseq([1], inf));
		~ampKick2P = Pseq([~ampKick2], inf).asStream;
		~durKick2 = PatternProxy( Pseq([1/2], inf));
		~durKick2P = Pseq([~durKick2], inf).asStream;
		~susKick2 = PatternProxy( Pseq([1], inf));
		~susKick2P = Pseq([~susKick2], inf).asStream;
		~volKick2 = PatternProxy( Pseq([0.9], inf));
		~volKick2P = Pseq([~volKick2], inf).asStream;
		~delta1Kick2 = PatternProxy( Pseq([1], inf));
		~delta1Kick2P = Pseq([~delta1Kick2], inf).asStream;

		~transKick = PatternProxy( Pseq([0], inf));
		~transKickP = Pseq([~transKick], inf).asStream;
		~transShufKick = PatternProxy( Pseq([0], inf));
		~transShufKickP = Pseq([~transShufKick], inf).asStream;
		~extraShufKick = PatternProxy( Pshuf([0], inf));
		~extraShufKickP = Pseq([~extraShufKick], inf).asStream;

		~octKick = PatternProxy( Pseq([0], inf));
		~octKickP = Pseq([~octKick], inf).asStream;

		~hrmKick = PatternProxy( Pseq([1.0], inf));
		~hrmKickP = Pseq([~hrmKick], inf).asStream;

		~actKickLfo1 = PatternProxy( Pseq([0], inf));
		~actKickLfo1P= Pseq([~actKickLfo1], inf).asStream;

		~volKick = PatternProxy( Pseq([1.0], inf));
		~volKickP = Pseq([~volKick], inf).asStream;

		~delta1VSamp05 = PatternProxy( Pseq([1/1], inf));
		~delta1VSamp05P = Pseq([~delta1VSamp05], inf).asStream;

		~delta2VSamp05 = PatternProxy( Pseq([1/1], inf));
		~delta2VSamp05P = Pseq([~delta2VSamp05], inf).asStream;
	}//*proxy

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~kickLate.wait;
				this.p1(val);
				((~dur1KickP.next)*(~durMulKickP.next)/val).wait;
			}}.fork;
		}
	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chKick,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1KickP.next],~actKickP),
			\degree,  Pseq([~nt1KickP.next], inf),
			\amp, Pseq([~volKickP.next*~amp1KickP.next], inf),
			\sustain, Pseq([~sus1KickP.next],inf)*~susMulKick,
			\mtranspose, Pseq([~transKickP.next], inf)+~trKick+~transShufKickP.next,
			\octave, Pseq([~octKickP], inf)+~octMulKick,
			\harmonic, Pseq([~hrmKickP.next], inf)+~harmKick,
		).play(~clkTom,quant:0);
		//this.count2;
		//this.timesCount;
	}
	*p2{
		//Kick2
		Pbind(
			\chan, ~chKick,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~durKick2P.next], ~actKick2P),
			\degree, Pseq([~ntKick2P.next], inf),
			\octave, Pseq([~octKickP.next], inf)+~octMulKick,
			\amp, Pseq([~volKick2P.next*~ampKick2P.next], inf),
			\sustain, Pseq([~susKick2P.next],inf)*~susMulKick,
			\harmonic, Pseq([~hrmKickP.next], inf)+~harmKick,
		).play(~clkTom,quant:~quantKick2);
	}


	*osc{

		~actKickBut.free;
		~actKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actKick.source=1;
				~apcMn.noteOn(~apcMnCh, ~actButA1, 127); //Trk1_But 1
			},{
				~actKick.source=0;
				~apcMn.noteOff(~apcMnCh, ~actButA1, 127); //Trk1_But 1
			});
		},
		'/activKick'
		);
		~time2KickBut.free;
		~countTime2Kick=0;
		~time2KickBut= OSCFunc({
			arg msg;

			~countTime2Kick = ~countTime2Kick + 1;
			~countTime2Kick.switch(
				1,{
					//~apcMn.noteOn(0, ~actButB1, 1);
					//~tOSCAdrr.sendMsg('time2Kick', 1);
					//~tOSCAdrr.sendMsg('tmKickLabel', 2);
					//~tmMulKick.source = Pseq([2], inf);
					//~extraShufKick.source = Pshuf([2,0,2,3,0], inf);
				},
				2,{
					//~apcMn.noteOn(0, ~actButB1, 0);
					//~tOSCAdrr.sendMsg('time2Kick', 0);
					//~tOSCAdrr.sendMsg('tmKickLabel', 1);
					//~tmMulKick.source = Pseq([1], inf);
					//~extraShufKick.source = Pshuf([0], inf);
					~countTime2Kick=0;
			})

		},
		'/time2Kick'
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
					~tmMulKick.source = Pseq([2], inf);
				});
			},*/
			\octMDcr,{
				if ( val==1, {
					~crntKick_octM=~crntKick_octM-1;
					IFKick.set1(\octM,~crntKick_octM);
				});
			},
			\octMIcr,{
				if ( val==1, {
					~crntKick_octM=~crntKick_octM+1;
					IFKick.set1(\octM,~crntKick_octM);
				});
			},
			\octMZero,{
				if ( val==1, {
					IFKick.set1(\octM,0);
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
				~crntKick_vol=val1;
				this.lbl1(\volKick,val1);
				~volKick.source = val1;
				~mdOut.control(2, 1, vel1);
			},
			\octM, {
				~crntKick_octM=val1;
				this.lbl1(\IFoctMKickLbl,val1);
				~octMulKick = val1;
			},
			\susM, {
				~crntKick_susM=val1;
				this.lbl1(\IFsusMKick,val1);
				~susMulKick=val1;
			},
			\dec, {
				~crntKick_dec=val1;
				this.lbl1(\IFdecKick,val1);
				~mdOut.control(2, 127, vel1);
			},
			\dly, {
				~crntKick_sus=val1;
				this.lbl1(\IFdlyKick,val1);
				//~mdOut.control(5, 6, vel1);
			},
			\pan, {
				~crntKick_pan=val1;
				this.lbl1(\IFpanKick,val1);
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
				this.lbl2(\sendKick,val1,val2);
				~mdOut.control(2, 4, vel1); // IFKick
				~mdOut.control(2, 3, vel2); // IFKick
				~crntKick_sndY=val1;
				~crntKick_sndX=val2;
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
				'octMDcrKick_T', { this.set(\octMDcr,val);},
				'octMIcrKick_T', { this.set(\octMIcr,val);},
				'octMZeroKick_T', { this.set(\octMZero,val);},
				//-GlobalSettings
				'volKick_T' , { this.set1(\vol,val1);},
				'octMKick_T', { this.set1(\octM,val1);},
				'susMKick_T', { this.set1(\susM,val1);},
				'decKick_T' , { this.set1(\dec,val1);},
				'susKick_T' , { this.set1(\dly,val1);},
				'panKick_T' , { this.set1(\pan,val1);},
				'sendKick_T', { this.set2(\send,val1,val2);},

			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\octMDcrKickResp, oscName:\IFoctMDcrKick, playTag:'octMDcrKick_T');
		this.oscResp(respName:\octMIcrKickResp, oscName:\IFoctMIcrKick, playTag:'octMIcrKick_T');
		this.oscResp(respName:\octMZeroKickResp, oscName:\IFoctMZeroKick, playTag:'octMZeroKick_T');
		//-GlobalSettings
		this.oscResp(respName:\volKickResp, oscName:\IFvolKick, playTag:'volKick_T');
		this.oscResp(respName:\octMKickResp, oscName:\IFoctMKick, playTag:'octMKick_T');
		this.oscResp(respName:\susMKickResp, oscName:\IFsusMKick, playTag:'susMKick_T');
		this.oscResp(respName:\decKickResp, oscName:\IFdecKick, playTag:'decKick_T');
		this.oscResp(respName:\dlyKickResp, oscName:\IFdlyKick, playTag:'dlyKick_T');
		this.oscResp(respName:\panKickResp, oscName:\IFpanKick, playTag:'panKick_T');
		this.oscResp(respName:\sendKickResp, oscName:\IFsendKick, playTag:'sendKick_T');
	}

}
IFTxtKick{
	classvar <>file;
	*crtRndLines{|trck,prt,inst|
		var cnt=1, min=0,max=1,seq;
		var amp,oct,nt,vel,susT,tm,dur,shuf;
		var vol,octM,susM,dec,dly,pan,sndA,sndB;
		amp=  Pwhite(0,   1,   inf).asStream;
		oct=  Pwhite(0,   3,   inf).asStream;
		nt=   Pshuf([0,0,0,1],inf).asStream;
		vel=  Pwhite(1,   3,   inf).asStream;
		susT= Pwhite(1,   5,   inf).asStream;
		tm=   Pshuf([1,2,1,1],inf).asStream;
		dur=  Pwhite(2,   3,   inf).asStream;
		shuf= Pshuf([0,2,0,0,3,1],inf).asStream;
		vol=  Pwhite(0.89, 0.99,inf).asStream;
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
			'rndKickTag',{
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
		IFTxtKick.make(\01,\00,\ifKick,'rndKickTag');
	}
	*read{|trck,prtDir|

		IFTxt.readIfTrack(trck,prtDir,\ifKick);
		~tKcAmp=IFTxt.line(1);
		~tKcOct=IFTxt.line(2);
		~tKcNt=IFTxt.line(3);
		~tKcVel=IFTxt.line(4);
		~tKcSus=IFTxt.line(5);
		~tKcTm=IFTxt.line(6);
		~tKcDur=IFTxt.line(7);
		~tKcShuf=IFTxt.line(8);
		~tKcGlob=IFTxt.line(9);

		this.storeVals;
	}
	*storeVals{//////
		"Store Kick Values from Txt to Patterns ".postln;
		//[ Kick ]
		IFSeqKick.stGrpSet    (
			~tKcAmp[0],~tKcAmp[1],~tKcAmp[2],~tKcAmp[3],
			~tKcAmp[4],~tKcAmp[5],~tKcAmp[6],~tKcAmp[7],
			~tKcAmp[8],~tKcAmp[9],~tKcAmp[10],~tKcAmp[11],
			~tKcAmp[12],~tKcAmp[13],~tKcAmp[14],~tKcAmp[15],
		);
		IFSeqOctKick.stGrpSet  (
			~tKcOct[0],~tKcOct[1],~tKcOct[2],~tKcOct[3],
			~tKcOct[4],~tKcOct[5],~tKcOct[6],~tKcOct[7],
			~tKcOct[8],~tKcOct[9],~tKcOct[10],~tKcOct[11],
			~tKcOct[12],~tKcOct[13],~tKcOct[14],~tKcOct[15],
		);
		IFSeqNtKick.stGrpSet  (
			~tKcNt[0],~tKcNt[1],~tKcNt[2],~tKcNt[3],
			~tKcNt[4],~tKcNt[5],~tKcNt[6],~tKcNt[7],
			~tKcNt[8],~tKcNt[9],~tKcNt[10],~tKcNt[11],
			~tKcNt[12],~tKcNt[13],~tKcNt[14],~tKcNt[15],
		);
		IFSeqVelKick.stGrpSet (
			~tKcVel[0],~tKcVel[1],~tKcVel[2],~tKcVel[3],
			~tKcVel[4],~tKcVel[5],~tKcVel[6],~tKcVel[7],
			~tKcVel[8],~tKcVel[9],~tKcVel[10],~tKcVel[11],
			~tKcVel[12],~tKcVel[13],~tKcVel[14],~tKcVel[15],
		);
		IFSeqSusKick.stGrpSet (
			~tKcSus[0],~tKcSus[1],~tKcSus[2],~tKcSus[3],
			~tKcSus[4],~tKcSus[5],~tKcSus[6],~tKcSus[7],
			~tKcSus[8],~tKcSus[9],~tKcSus[10],~tKcSus[11],
			~tKcSus[12],~tKcSus[13],~tKcSus[14],~tKcSus[15],
		);
		IFSeqTmKick.stGrpSet  (
			~tKcTm[0],~tKcTm[1],~tKcTm[2],~tKcTm[3],
			~tKcTm[4],~tKcTm[5],~tKcTm[6],~tKcTm[7],
			~tKcTm[8],~tKcTm[9],~tKcTm[10],~tKcTm[11],
			~tKcTm[12],~tKcTm[13],~tKcTm[14],~tKcTm[15],
		);
		IFSeqDurKick.stGrpSet (
			~tKcDur[0],~tKcDur[1],~tKcDur[2],~tKcDur[3],
			~tKcDur[4],~tKcDur[5],~tKcDur[6],~tKcDur[7],
			~tKcDur[8],~tKcDur[9],~tKcDur[10],~tKcDur[11],
			~tKcDur[12],~tKcDur[13],~tKcDur[14],~tKcDur[15],
		);
		IFShuf.setKick    (
			~tKcShuf[0],~tKcShuf[1],~tKcShuf[2],~tKcShuf[3],
			~tKcShuf[4],~tKcShuf[5],~tKcShuf[6],~tKcShuf[7],
			~tKcShuf[8],~tKcShuf[9],~tKcShuf[10],~tKcShuf[11],
			~tKcShuf[12],~tKcShuf[13],~tKcShuf[14],~tKcShuf[15],
		);
		IFGlobal.setKick  (
			~tKcGlob[0],~tKcGlob[1],~tKcGlob[2],~tKcGlob[3],
			~tKcGlob[4],~tKcGlob[5],~tKcGlob[6],~tKcGlob[7],
			~tKcGlob[8],~tKcGlob[9],~tKcGlob[10],~tKcGlob[11],
			~tKcGlob[12],~tKcGlob[13],~tKcGlob[14],~tKcGlob[15],
		);


	}//////
}
/*
IFTxtKick.read(\01,\00);
*/