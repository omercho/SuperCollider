
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
		~lfoMulKick1=0.2;
		~lfoMulKick2=0.2;

		~drumVolC=0; ~kickVolC=1;
		~tuneKick=26;

		~quantKick2=0.0;
	}

	*proxy {

		~rootKick = PatternProxy( Pseq([0], inf));
		~rootKickP = Pseq([~rootKick], inf).asStream;
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


		~transKick = PatternProxy( Pseq([0], inf));
		~transKickP = Pseq([~transKick], inf).asStream;
		~transShufKick = PatternProxy( Pseq([0], inf));
		~transShufKickP = Pseq([~transShufKick], inf).asStream;
		~transCntKick = PatternProxy( Pseq([0], inf));
		~transCntKickP = Pseq([~transCntKick], inf).asStream;
		~extraShufKick = PatternProxy( Pshuf([0], inf));
		~extraShufKickP = Pseq([~extraShufKick], inf).asStream;

		~octKick = PatternProxy( Pseq([0], inf));
		~octKickP = Pseq([~octKick], inf).asStream;
		~hrmKick = PatternProxy( Pseq([1.0], inf));
		~hrmKickP = Pseq([~hrmKick], inf).asStream;

		~actKick = PatternProxy( Pseq([1], inf));
		~actKickP= Pseq([~actKick], inf).asStream;
		~volKick = PatternProxy( Pseq([1.0], inf));
		~volKickP = Pseq([~volKick], inf).asStream;

		~delta1VSamp05 = PatternProxy( Pseq([1/1], inf));
		~delta1VSamp05P = Pseq([~delta1VSamp05], inf).asStream;
		~delta2VSamp05 = PatternProxy( Pseq([1/1], inf));
		~delta2VSamp05P = Pseq([~delta2VSamp05], inf).asStream;

		~lfo1Kick = PatternProxy( Pseq([10], inf));
		~lfo1KickP = Pseq([~lfo1Kick], inf).asStream;
		~lfo2Kick = PatternProxy( Pseq([10], inf));
		~lfo2KickP = Pseq([~lfo2Kick], inf).asStream;

		~actKickLfo1 = PatternProxy( Pseq([0], inf));
		~actKickLfo1P= Pseq([~actKickLfo1], inf).asStream;


		//lng
		~rootLngKick = PatternProxy( Pseq([0], inf));
		~rootLngKickP = Pseq([~rootLngKick], inf).asStream;
		~nt1LngKick = PatternProxy( Pseq([0], inf));
		~nt1LngKickP = Pseq([~nt1LngKick], inf).asStream;
		~dur1LngKick = PatternProxy( Pseq([0.25], inf));
		~dur1LngKickP = Pseq([~dur1LngKick], inf).asStream;
		~amp1LngKick = PatternProxy( Pseq([0.9], inf));
		~amp1LngKickP = Pseq([~amp1LngKick], inf).asStream;
		~sus1LngKick = PatternProxy( Pseq([1], inf));
		~sus1LngKickP = Pseq([~sus1LngKick], inf).asStream;

		~transLngKick = PatternProxy( Pseq([0], inf));
		~transLngKickP = Pseq([~transLngKick], inf).asStream;
		~transShufLngKick = PatternProxy( Pseq([0], inf));
		~transShufLngKickP = Pseq([~transShufLngKick], inf).asStream;


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
			\chan, ~chAbk1,
			\type, \midi, \midiout,~vAmbk, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1KickP.next],~actKickP),
			\degree,  Pseq([~nt1KickP.next], inf),
			\amp, Pseq([~volKickP.next*~amp1KickP.next], inf),
			\sustain, Pseq([~sus1KickP.next],inf)*~susMulKick,
			\mtranspose, Pseq([~transKickP.next], inf)+~extraShufKickP.next+~transShufKickP.next+~transCntKickP.next+~trKick,
			\ctranspose, Pseq([~rootKickP.next],inf),
			\octave, Pseq([~octKickP], inf)+~octMulKick,
			\harmonic, Pseq([~hrmKickP.next], inf)+~harmKick,
		).play(~clkKick,quant:0);
		//this.count2;
		//this.timesCount;
		Pbind(//LFO CUT Kick INT
			\midicmd, \control, \type, \midi,
			\midiout,~vAmbk, \chan, ~chAbk1, \ctlNum, ~envDecVB,
			\delta, Pseq([~delta1KickP.next], 1),
			\control, Pseq([~lfo1KickP.value], 1)*~lfoMulKick1,
		).play(~clkKick, quant: 0);
		Pbind(//LFO CUT Kick RATE
			\midicmd, \control, \type, \midi,
			\midiout,~vAmbk, \chan, ~chAbk1, \ctlNum, ~slideTm,
			\delta, Pseq([~delta2KickP.next], 1),
			\control, Pseq([~lfo2KickP.value], 1)*~lfoMulKick2,
		).play(~clkKick, quant: 0);
	}


	*lng{|deg=0,amp=1,sus=4|
		Pbind(
			\chan, ~chAbk1,
			\type, \midi, \midiout,~vAmbk, \scale, Pfunc({~scl2},inf),
			\dur, Pseq([~dur1LngKickP.next],1)+sus,
			\ctranspose, Pseq([~rootLngKickP.next],inf),
			\degree, Pseq([~nt1LngKickP.next],inf)+deg,
			\amp, Pseq([~volKickP.next*~amp1LngKickP.next],inf)+amp,
			\sustain, Pseq([~sus1LngKickP.next],inf)+sus,
			\mtranspose, Pseq([~transLngKickP.next],inf)+~transShufLngKickP.next+~transCntKickP.next,
			\octave, Pseq([~octKickP.next],inf)+~octMulKick,
			\harmonic, Pseq([~hrmKickP.next],inf)+~harmKick
		).play(~clkKick, quant: 0);
	}//lng

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
			\att, {
				~crntKick_att=val1;
				this.lbl1(\IFattKick,val1);

				~mdOut.control(2, 5, vel1);
			},
			\dec, {
				~crntKick_dec=val1;
				this.lbl1(\IFdecKick,val1);
				~mdOut.control(2, 127, vel1);
			},
			\sus, {
				~crntKick_sus=val1;
				this.lbl1(\IFsusKick,val1);
				~mdOut.control(2, 6, vel1);
			},
			\rls, {
				~crntKick_rls=val1;
				this.lbl1(\IFrlsKick,val1);
				~mdOut.control(2, 8, vel1);
			},
			\pan, {
				~crntKick_pan=val1;
				this.lbl1(\IFpanKick,val1);
				~mdOut.control(2, 8, vel1);
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
			\lfoM1, {
				~crntKick_lfoM1=val1;
				this.lbl1(\IFlfoM1Kick,val1);
				~lfoMulKick1=val1;
			},
			\lfoM2, {
				~crntKick_lfoM2=val1;
				this.lbl1(\IFlfoM2Kick,val1);
				~lfoMulKick2=val1;
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
			\xy1, {
				this.lbl2(\IFxy1Kick,val1,val2);

				~mdOut.control(5, 13, vel2); //FX Comp
				~mdOut.control(5, 14, vel1); //FX Comp
				~crntKick_xy1X=val2;
				~crntKick_xy1Y=val1;
			},
			\xy2, {
				this.lbl2(\IFxy2Kick,val1,val2);

				~crntKick_xy2X=val2;
				~crntKick_xy2Y=val1;
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
				'attKick_T' , { this.set1(\att,val1);},
				'decKick_T' , { this.set1(\dec,val1);},
				'susKick_T' , { this.set1(\sus,val1);},
				'rlsKick_T' , { this.set1(\rls,val1);},
				'panKick_T' , { this.set1(\pan,val1);},
				'sendKick_T', { this.set2(\send,val1,val2);},
				'susMKick_T', { this.set1(\susM,val1);},
				'octMKick_T', { this.set1(\octM,val1);},
				'xy1Kick_T' , { this.set2(\xy1,val1,val2);},
				'xy2Kick_T' , { this.set2(\xy2,val1,val2);},
				'lfoM1Kick_T',{ this.set1(\lfoM1,val1);},
				'lfoM2Kick_T',{ this.set1(\lfoM2,val1);},

			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\octMDcrKickResp, oscName:\IFoctMDcrKick, playTag:'octMDcrKick_T');
		this.oscResp(respName:\octMIcrKickResp, oscName:\IFoctMIcrKick, playTag:'octMIcrKick_T');
		this.oscResp(respName:\octMZeroKickResp, oscName:\IFoctMZeroKick, playTag:'octMZeroKick_T');
		//-GlobalSettings
		this.oscResp(respName:\volKickResp, oscName:\IFvolKick, playTag:'volKick_T');
		this.oscResp(respName:\attKickResp, oscName:\IFattKick, playTag:'attKick_T');
		this.oscResp(respName:\decKickResp, oscName:\IFdecKick, playTag:'decKick_T');
		this.oscResp(respName:\susKickResp, oscName:\IFsusKick, playTag:'susKick_T');
		this.oscResp(respName:\rlsKickResp, oscName:\IFrlsKick, playTag:'rlsKick_T');
		this.oscResp(respName:\panKickResp, oscName:\IFpanKick, playTag:'panKick_T');
		this.oscResp(respName:\sendKickResp, oscName:\IFsendKick, playTag:'sendKick_T');
		this.oscResp(respName:\susMKickResp, oscName:\IFsusMKick, playTag:'susMKick_T');
		this.oscResp(respName:\octMKickResp, oscName:\IFoctMKick, playTag:'octMKick_T');
		this.oscResp(respName:\xy1KickResp,  oscName:\IFxy1Kick, playTag:'xy1Kick_T');
		this.oscResp(respName:\xy2KickResp,  oscName:\IFxy2Kick, playTag:'xy2Kick_T');
		this.oscResp(respName:\lfoM1KickResp, oscName:\IFlfoM1Kick, playTag:'lfoM1Kick_T');
		this.oscResp(respName:\lfoM2KickResp, oscName:\IFlfoM2Kick, playTag:'lfoM2Kick_T');
	}

}
IFTxtKick{
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
		oct=  Pwhite(2,   3,   inf).asStream;
		nt=   [
			Pwhite(-2,   7,   inf).asStream;
			Pseq([0,0,1,0],inf).asStream,
			Pseq([0,0,0,1,0,0,1,1],inf).asStream,
			Pseq([0,0,1,0,0,0,1,1],inf).asStream,
			Pseq([0,1,1,0,0,0,1,0],inf).asStream,
			Pseq([0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1],inf).asStream,
			Pshuf([0,1,1,0,0,0,1,0,0,0,1,0,1,0,1,0],inf).asStream,
		].choose;
		vel=  Pwhite(1,   3,   inf).asStream;
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
		IFTxtKick.make(\00,\01,\ifKick,'rndKickTag');
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
		~tKcLfo=IFTxt.line(9);
		~tKcEnv=IFTxt.line(10);

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
		IFLfo.setKick    (
			~tKcLfo[0],~tKcLfo[1],~tKcLfo[2],~tKcLfo[3],
			~tKcLfo[4],~tKcLfo[5],~tKcLfo[6],~tKcLfo[7],
			~tKcLfo[8],~tKcLfo[9],~tKcLfo[10],~tKcLfo[11],
			~tKcLfo[12],~tKcLfo[13],~tKcLfo[14],~tKcLfo[15],
		);
		IFGlobal.setKick  (
			~tKcEnv[0],~tKcEnv[1],~tKcEnv[2],~tKcEnv[3],
			~tKcEnv[4],~tKcEnv[5],~tKcEnv[6],~tKcEnv[7],
			~tKcEnv[8],~tKcEnv[9],~tKcEnv[10],~tKcEnv[11],
			~tKcEnv[12],~tKcEnv[13],~tKcEnv[14],~tKcEnv[15],
		);
	}//////
}
/*
IFTxtKick.read(\01,\00);
*/