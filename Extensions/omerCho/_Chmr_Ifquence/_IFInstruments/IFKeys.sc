/*
PostAllMIDI.on;
PostAllMIDI.off;

IFKeys.makeOSCResponders;
IFKeys(3);
*/
IFKeys {
	var <>keyTime = 1;
	classvar <>counter3 = 0;
	/**initClass{
	StartUp add: {
	/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default;this.osc; });*/
	}
	}*/
	*load{
		this.globals;
		this.proxy;
		this.osc;
		this.makeOSCResponders;
	}
	*globals{
		~chVKeys=3;
		~chKeys=4;
		~lateKeys= 0.0;
		~timesKeys=1;
		~octMulKeys=0;
		~rootKeys=0;
		~harmKeys=0;
		~susMulKeys=1;
		~trKeys=0;
		~lfoMulKeys1=0.2;
		~lfoMulKeys2=0.2;
	}
	*proxy{
		~rootKeys = PatternProxy( Pseq([0], inf));
		~rootKeysP = Pseq([~rootKeys], inf).asStream;
		~nt1Keys = PatternProxy( Pseq([0], inf));
		~nt1KeysP = Pseq([~nt1Keys], inf).asStream;
		~nt2Keys = PatternProxy( Pseq([0], inf));
		~nt2KeysP = Pseq([~nt2Keys], inf).asStream;
		~nt3Keys = PatternProxy( Pseq([0], inf));
		~nt3KeysP = Pseq([~nt3Keys], inf).asStream;
		~dur1Keys = PatternProxy( Pseq([1], inf));
		~dur1KeysP = Pseq([~dur1Keys], inf).asStream;
		~durMulKeys = PatternProxy( Pseq([1], inf));
		~durMulKeysP = Pseq([~durMulKeys], inf).asStream;
		~amp1Keys = PatternProxy( Pseq([0.9], inf));
		~amp1KeysP = Pseq([~amp1Keys], inf).asStream;
		~sus1Keys = PatternProxy( Pseq([0.2], inf));
		~sus1KeysP = Pseq([~sus1Keys], inf).asStream;

		~transKeys = PatternProxy( Pseq([1], inf));
		~transKeysP = Pseq([~transKeys], inf).asStream;
		~transShufKeys = PatternProxy( Pseq([1], inf));
		~transShufKeysP = Pseq([~transShufKeys], inf).asStream;
		~transCntKeys = PatternProxy( Pseq([0], inf));
		~transCntKeysP = Pseq([~transCntKeys], inf).asStream;

		~octKeys = PatternProxy( Pseq([3], inf));
		~octKeysP = Pseq([~octKeys], inf).asStream;
		~legKeys = PatternProxy( Pseq([0.0], inf));
		~legKeysP = Pseq([~legKeys], inf).asStream;
		~hrmKeys = PatternProxy( Pseq([1.0], inf));
		~hrmKeysP = Pseq([~hrmKeys], inf).asStream;

		~delta1Keys = PatternProxy( Pseq([1/1], inf));
		~delta1KeysP = Pseq([~delta1Keys], inf).asStream;
		~lfoRtKeys = PatternProxy( Pseq([20], inf));
		~lfoRtKeysP = Pseq([~lfoRtKeys], inf).asStream;

		~delta2Keys = PatternProxy( Pseq([1/1], inf));
		~delta2KeysP = Pseq([~delta2Keys], inf).asStream;
		~lfoCtKeys = PatternProxy( Pseq([40], inf));
		~lfoCtKeysP = Pseq([~lfoCtKeys], inf).asStream;

		~delta3Keys = PatternProxy( Pseq([1/2], inf));
		~delta3KeysP = Pseq([~delta3Keys], inf).asStream;
		~vcfCtKeys = PatternProxy( Pseq([40], inf));
		~vcfCtKeysP = Pseq([~vcfCtKeys], inf).asStream;

		~lfo1Keys = PatternProxy( Pseq([10], inf));
		~lfo1KeysP = Pseq([~lfo1Keys], inf).asStream;
		~lfo2Keys = PatternProxy( Pseq([10], inf));
		~lfo2KeysP = Pseq([~lfo2Keys], inf).asStream;

		~actKeys = PatternProxy( Pseq([1], inf));
		~actKeysP= Pseq([~actKeys], inf).asStream;

		~volKeys = PatternProxy( Pseq([0.9], inf));
		~volKeysP = Pseq([~volKeys], inf).asStream;

		//lng
		~rootLngKeys = PatternProxy( Pseq([0], inf));
		~rootLngKeysP = Pseq([~rootLngKeys], inf).asStream;
		~nt1LngKeys = PatternProxy( Pseq([0], inf));
		~nt1LngKeysP = Pseq([~nt1LngKeys], inf).asStream;
		~dur1LngKeys = PatternProxy( Pseq([1], inf));
		~dur1LngKeysP = Pseq([~dur1LngKeys], inf).asStream;
		~amp1LngKeys = PatternProxy( Pseq([0.9], inf));
		~amp1LngKeysP = Pseq([~amp1LngKeys], inf).asStream;
		~sus1LngKeys = PatternProxy( Pseq([1], inf));
		~sus1LngKeysP = Pseq([~sus1LngKeys], inf).asStream;

		~transLngKeys = PatternProxy( Pseq([0], inf));
		~transLngKeysP = Pseq([~transLngKeys], inf).asStream;
		~transShufLngKeys = PatternProxy( Pseq([0], inf));
		~transShufLngKeysP = Pseq([~transShufLngKeys], inf).asStream;

		~cntKeysLfo=0;
		~cntKeys=0;
	}


	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				this.p1(val);
				((~dur1KeysP.next)*(~durMulKeysP.next)/val).wait;
			}}.fork;
		}
	}
	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chVKeys,
			\type, \midi, \midiout,~vKeys, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1KeysP.next],~actKeysP.next),
			\degree, Pseq([[~nt1KeysP.next,~nt2KeysP.next,~nt3KeysP.next]], inf),
			\amp, Pseq([~volKeysP.next*~amp1KeysP.next], inf),
			\sustain, Pseq([1.5*~sus1KeysP.next],inf)*~susMulKeys,
			\mtranspose, Pseq([~transKeysP.next], inf)+~transCntKeysP.next+~trKeys+~transShufKeysP.next,
			\ctranspose, Pseq([~rootKeysP.next],inf),
			\octave, Pseq([~octKeysP.next], inf)+~octMulKeys,
			\harmonic, Pseq([~hrmKeysP.next], inf)+~harmKeys
		).play(~clkKeys, quant: 0);

		~cntKeysLfo=~cntKeysLfo+1;
		~cntKeysLfo.switch(
			0,{},
			1,{this.pLfo;},
			2,{~cntKeysLfo=0;}
		);
	}//p1
	*pLfo{
		Pbind(//LFO CUT KEYS INT
			\midicmd, \control, \type, \midi,
			\midiout,~vKeys, \chan, ~chVKeys, \ctlNum, Pseq([~vcoDtn],inf),
			\delta, Pseq([~delta1KeysP.next], ~actKeysP.next),
			\control, ~lfoMulKeys1*Pexprand(0.5*~lfo1KeysP.next,1*~lfo1KeysP.next, inf).round,
		).play(~clkKeys, quant: 0);

		Pbind(//LFO RATE KEYS
			\midicmd, \control, \type, \midi,
			\midiout,~vKeys, \chan, ~chVKeys, \ctlNum, Pseq([~vcoPort],inf),
			\delta, Pseq([~delta2KeysP.next], ~actKeysP.next),
			\control, ~lfoMulKeys2*Pexprand(0.8*~lfo2KeysP.next,0.5*~lfo2KeysP.next, inf).round,
		).play(~clkKeys, quant: 0);
	}//pLfo
	*lng{|deg=0,amp=1,sus=4|
		Pbind(
			\chan, ~chVKeys,
			\type, \midi, \midiout,~vKeys, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1LngKeysP.next],1),
			\degree, Pseq([~nt1LngKeysP.next], inf)+deg,
			\amp, Pseq([~volKeysP.next*~amp1LngKeysP.next], inf)*amp,
			\sustain, Pseq([~sus1LngKeysP.next],inf)*sus,
			\mtranspose, Pseq([~transLngKeysP.next], inf)+~transCntKeysP.next+~transShufLngKeysP.next,
			\ctranspose, Pseq([~rootLngKeysP.next],inf),
			\octave, Pseq([~octKeysP.next], inf)+~octMulKeys,
			\harmonic, Pseq([~hrmKeysP.next], inf)+~harmKeys
		).play(~clkKeys, quant: 0);
	}
	*osc{
		~actKeysBut.free;
		~actKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actKeys.source=1;
				~apcMn.noteOn(~apcMnCh, ~actButA6, 127); //Trk5_But 1
			},{
				~actKeys.source=0;
				~apcMn.noteOff(~apcMnCh, ~actButA6, 127); //Trk5_But
			});
		},'/activKeys');
		~time2KeysBut.free;
		~countTime2Keys=0;
		~time2KeysBut= OSCFunc({
			arg msg;

			~countTime2Keys = ~countTime2Keys + 1;
			~countTime2Keys.switch(
				0,{},
				1, {
					~apcMn.noteOn(~apcMnCh, ~actButB5, 1); //Trk5_But 2
					//~tOSCAdrr.sendMsg('time2Keys', 1);
					//~tOSCAdrr.sendMsg('tmKeysLabel', 2);
					~tmMulKeys.source = Pseq([2], inf);
				},
				2,{
					~apcMn.noteOn(~apcMnCh, ~actButB5, 0); //Trk5_But 2
					//~tOSCAdrr.sendMsg('time2Keys', 0);
					//~tOSCAdrr.sendMsg('tmKeysLabel', 1);
					~tmMulKeys.source = Pseq([1], inf);
					~countTime2Keys=0;
				}
			);
		},
		'/time2Keys'
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
					~tmMulKeys.source = Pseq([2], inf);
				});
			},*/
			\octMDcr,{
				if ( val==1, {
					~crntKeys_octM=~crntKeys_octM-1;
					IFKeys.set1(\octM,~crntKeys_octM);
				});
			},
			\octMIcr,{
				if ( val==1, {
					~crntKeys_octM=~crntKeys_octM+1;
					IFKeys.set1(\octM,~crntKeys_octM);
				});
			},
			\octMZero,{
				if ( val==1, {
					IFKeys.set1(\octM,0);
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
				~crntKeys_vol=val1;
				this.lbl1(\IFvolKeys,val1);
				~volKeys.source = val1;
				VKeys.cc(\expresVK,vel1);
				~mdOut.control(6, 1, vel1);
			},
			\att, {
				~crntKeys_att=val1;
				this.lbl1(\IFattKeys,val1);
				VKeys.cc(\envAttVK,vel1);
				~mdOut.control(6, 5, vel1);
			},
			\dec, {
				~crntKeys_dec=val1;
				this.lbl1(\IFdecKeys,val1);
				VKeys.cc(\envDecVK,vel1);
				~mdOut.control(6, 127, vel1);
			},
			\sus, {
				~crntKeys_sus=val1;
				this.lbl1(\IFsusKeys,val1);
				VKeys.cc(\envSusVK,vel1);
				~mdOut.control(6, 6, vel1);
			},
			\rls, {
				~crntKeys_rls=val1;
				this.lbl1(\IFrlsKeys,val1);
				~mdOut.control(6, 8, vel1);
			},
			\pan, {
				~crntKeys_pan=val1;
				this.lbl1(\IFpanKeys,val1);
				VKeys.cc(\vcfEgVK,vel1);
				~mdOut.control(6, 16, vel1);
			},
			\octM, {
				~crntKeys_octM=val1;
				this.lbl1(\IFoctMKeysLbl,val1);
				~octMulKeys = val1;
			},
			\susM, {
				~crntKeys_susM=val1;
				this.lbl1(\IFsusMKeys,val1);
				~susMulKeys=val1;
			},
			\lfoM1, {
				~crntKeys_lfoM1=val1;
				this.lbl1(\IFlfoM1Keys,val1);
				~lfoMulKeys1=val1;
			},
			\lfoM2, {
				~crntKeys_lfoM2=val1;
				this.lbl1(\IFlfoM2Keys,val1);
				~lfoMulKeys2=val1;
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
				this.lbl2(\IFsendKeys,val1,val2);
				~mdOut.control(6, 4, vel1); // IFKeys
				~mdOut.control(6, 3, vel2); // IFKeys
				~crntKeys_sndY=val1;
				~crntKeys_sndX=val2;
			},
			\xy1, {
				this.lbl2(\IFxy1Keys,val1,val2);
				VKeys.cc(\lfoRateVK,val2);
				VKeys.cc(\lfoPitchVK,val1);
				~crntKeys_xy1X=val2;
				~crntKeys_xy1Y=val1;
			},
			\xy2, {
				this.lbl2(\IFxy2Keys,val1,val2);
				VKeys.cc(\dlyTimeVK,vel2);
				VKeys.cc(\dlyFeedVK,vel1);
				~crntKeys_xy2X=val2;
				~crntKeys_xy2Y=val1;
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
				'octMDcrKeys_T', { this.set(\octMDcr,val);},
				'octMIcrKeys_T', { this.set(\octMIcr,val);},
				'octMZeroKeys_T', { this.set(\octMZero,val);},
				//-GlobalSettings
				'volKeys_T' , { this.set1(\vol,val1);},
				'attKeys_T' , { this.set1(\att,val1);},
				'decKeys_T' , { this.set1(\dec,val1);},
				'susKeys_T' , { this.set1(\sus,val1);},
				'rlsKeys_T' , { this.set1(\rls,val1);},
				'panKeys_T' , { this.set1(\pan,val1);},
				'sendKeys_T', { this.set2(\send,val1,val2);},
				'susMKeys_T', { this.set1(\susM,val1);},
				'octMKeys_T', { this.set1(\octM,val1);},
				'xy1Keys_T' , { this.set2(\xy1,val1,val2);},
				'xy2Keys_T' , { this.set2(\xy2,val1,val2);},
				'lfoM1Keys_T',{ this.set1(\lfoM1,val1);},
				'lfoM2Keys_T',{ this.set1(\lfoM2,val1);},
			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\octMDcrKeysResp, oscName:\IFoctMDcrKeys, playTag:'octMDcrKeys_T');
		this.oscResp(respName:\octMIcrKeysResp, oscName:\IFoctMIcrKeys, playTag:'octMIcrKeys_T');
		this.oscResp(respName:\octMZeroKeysResp, oscName:\IFoctMZeroKeys, playTag:'octMZeroKeys_T');
		//-GlobalSettings
		this.oscResp(respName:\volKeysResp, oscName:\IFvolKeys, playTag:'volKeys_T');
		this.oscResp(respName:\attKeysResp, oscName:\IFattKeys, playTag:'attKeys_T');
		this.oscResp(respName:\decKeysResp, oscName:\IFdecKeys, playTag:'decKeys_T');
		this.oscResp(respName:\susKeysResp, oscName:\IFsusKeys, playTag:'susKeys_T');
		this.oscResp(respName:\rlsKeysResp, oscName:\IFrlsKeys, playTag:'rlsKeys_T');
		this.oscResp(respName:\panKeysResp, oscName:\IFpanKeys, playTag:'panKeys_T');
		this.oscResp(respName:\sendKeysResp, oscName:\IFsendKeys, playTag:'sendKeys_T');
		this.oscResp(respName:\susMKeysResp, oscName:\IFsusMKeys, playTag:'susMKeys_T');
		this.oscResp(respName:\octMKeysResp, oscName:\IFoctMKeys, playTag:'octMKeys_T');
		this.oscResp(respName:\xy1KeysResp,  oscName:\IFxy1Keys, playTag:'xy1Keys_T');
		this.oscResp(respName:\xy2KeysResp, oscName:\IFxy2Keys, playTag:'xy2Keys_T');
		this.oscResp(respName:\lfoM1KeysResp, oscName:\IFlfoM1Keys, playTag:'lfoM1Keys_T');
		this.oscResp(respName:\lfoM2KeysResp, oscName:\IFlfoM2Keys, playTag:'lfoM2Keys_T');
	}

}
IFTxtKeys{
	classvar <>file;
	*crtRndLines{|trck,prt,inst|
		var cnt=1, min=0,max=1,seq;
		var amp,oct,nt,nt2,nt3,vel,susT,tm,dur,shuf,lfoP;
		var vol,att,dec,susV,rls,pan,sndA,sndB;
		var octM,susM,xy1X,xy1Y,xy2X,xy2Y,lfoM1,lfoM2;
		amp=  Pwhite(0,   1,   inf).asStream;
		oct=  Pwhite(2,   3,   inf).asStream;
		nt=   Pwhite(0,   4,   inf).asStream;
		nt2=  Pwhite(2,   7,   inf).asStream;
		nt3=  Pwhite(4,   10,   inf).asStream;
		vel=  Pwhite(1,   3,   inf).asStream;
		susT= Pwhite(1,   5,   inf).asStream;
		tm=   Pwhite(1,   2,   inf).asStream;
		dur=  Pwhite(2,   4,   inf).asStream;
		shuf= Pwhite(-4,   4,   inf).asStream;
		lfoP= Pwhite(10,   120, inf).asStream;
		vol=  Pwhite(0.89, 0.99,inf).asStream;
		att=  Pwhite(0.0, 0.4, inf).asStream;
		dec=  Pwhite(0.4, 1.0, inf).asStream;
		susV= Pwhite(0.0, 0.9, inf).asStream;
		rls=  Pwhite(0.1, 0.9, inf).asStream;
		pan=  Pwhite(0.1, 0.9, inf).asStream;
		sndA= Pwhite(0.0, 0.9, inf).asStream;
		sndB= Pwhite(0.0, 0.9, inf).asStream;
		octM= Pwhite(0,   2, inf).asStream;
		susM= Pwhite(0.1, 0.9, inf).asStream;
		xy1X= Pwhite(0.0, 0.9, inf).asStream;
		xy1Y= Pwhite(0.0, 0.9, inf).asStream;
		xy2X= Pwhite(0.0, 0.9, inf).asStream;
		xy2Y= Pwhite(0.0, 0.9, inf).asStream;
		lfoM1=Pwhite(0.0, 1.0, inf).asStream;
		lfoM2=Pwhite(0.0, 1.0, inf).asStream;
		fork{
			IFTxt.ifPath(trck,prt,inst);
			file=File.new(IFTxt.ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..192).do{|n|
				case
				{cnt>0&&cnt<=16}   {seq=amp.next}//amp
				{cnt>16&&cnt<=32}  {seq=oct.next}//oct
				{cnt>32&&cnt<=48}  {seq=nt.next}//nt

				{cnt>48&&cnt<=64}  {seq=nt2.next}//nt2
				{cnt>64&&cnt<=80}  {seq=nt3.next}//nt3

				{cnt>80&&cnt<=96}  {seq=vel.next}//vel
				{cnt>96&&cnt<=112}  {seq=susT.next}//susT

				{cnt>112&&cnt<=128}  {seq=tm.next}//tm
				{cnt>128&&cnt<=144} {seq=dur.next}//dur
				{cnt>144&&cnt<=160}{seq=shuf.next}//Shuf
				{cnt>160&&cnt<=176}{seq=lfoP.next}//lfo
				{cnt==177}     {seq=vol.next}//Vol
				{cnt==178}     {seq=att.next}//Att
				{cnt==179}     {seq=dec.next}//dec
				{cnt==180}     {seq=susV.next}//sus
				{cnt==181}     {seq=rls.next}//rls
				{cnt==182}     {seq=pan.next}//pan
				{cnt==183}     {seq=sndA.next}//sndX
				{cnt==184}     {seq=sndB.next}//sndY
				{cnt==185}   {seq=octM.next}//OctMul
				{cnt==186}   {seq=susM.next}//SusMul
				{cnt==187}   {seq=xy1X.next}//xy1X
				{cnt==188}   {seq=xy1Y.next}//xy1Y
				{cnt==189}   {seq=xy2X.next}//xy2X
				{cnt==190}   {seq=xy1Y.next}//xy2Y
				{cnt==191}   {seq=lfoM1.next}//lfoMul1
				{cnt==192}   {seq=lfoM2.next};//lfoMul2
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
			'rndKeysTag',{
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
		IFTxtKeys.make(\01,\00,\ifKeys,'rndKeysTag');
	}
	*read{|trck,prtDir|

		IFTxt.readIfTrack(trck,prtDir,\ifKeys);
		~tKyAmp=IFTxt.line(1);
		~tKyOct=IFTxt.line(2);
		~tKyNt=IFTxt.line(3);
		~tKyNt2=IFTxt.line(4);
		~tKyNt3=IFTxt.line(5);
		~tKyVel=IFTxt.line(6);
		~tKySus=IFTxt.line(7);
		~tKyTm=IFTxt.line(8);
		~tKyDur=IFTxt.line(9);
		~tKyShuf=IFTxt.line(10);
		~tKyLfo=IFTxt.line(11);
		~tKyEnv=IFTxt.line(12);

		this.storeVals;
	}
	*storeVals{//////
		"Store Keys Values from Txt to Patterns ".postln;
		//[ Keys ]
		IFSeqKeys.stGrpSet    (
			~tKyAmp[0],~tKyAmp[1],~tKyAmp[2],~tKyAmp[3],
			~tKyAmp[4],~tKyAmp[5],~tKyAmp[6],~tKyAmp[7],
			~tKyAmp[8],~tKyAmp[9],~tKyAmp[10],~tKyAmp[11],
			~tKyAmp[12],~tKyAmp[13],~tKyAmp[14],~tKyAmp[15],
		);
		IFSeqOctKeys.stGrpSet  (
			~tKyOct[0],~tKyOct[1],~tKyOct[2],~tKyOct[3],
			~tKyOct[4],~tKyOct[5],~tKyOct[6],~tKyOct[7],
			~tKyOct[8],~tKyOct[9],~tKyOct[10],~tKyOct[11],
			~tKyOct[12],~tKyOct[13],~tKyOct[14],~tKyOct[15],
		);
		IFSeqNtKeys.stGrpSet  (
			~tKyNt[0],~tKyNt[1],~tKyNt[2],~tKyNt[3],
			~tKyNt[4],~tKyNt[5],~tKyNt[6],~tKyNt[7],
			~tKyNt[8],~tKyNt[9],~tKyNt[10],~tKyNt[11],
			~tKyNt[12],~tKyNt[13],~tKyNt[14],~tKyNt[15],
		);
		IFSeqNt2Keys.stGrpSet  (
			~tKyNt2[0],~tKyNt2[1],~tKyNt2[2],~tKyNt2[3],
			~tKyNt2[4],~tKyNt2[5],~tKyNt2[6],~tKyNt2[7],
			~tKyNt2[8],~tKyNt2[9],~tKyNt2[10],~tKyNt2[11],
			~tKyNt2[12],~tKyNt2[13],~tKyNt2[14],~tKyNt2[15],
		);
		IFSeqNt3Keys.stGrpSet  (
			~tKyNt3[0],~tKyNt3[1],~tKyNt3[2],~tKyNt3[3],
			~tKyNt3[4],~tKyNt3[5],~tKyNt3[6],~tKyNt3[7],
			~tKyNt3[8],~tKyNt3[9],~tKyNt3[10],~tKyNt3[11],
			~tKyNt3[12],~tKyNt3[13],~tKyNt3[14],~tKyNt3[15],
		);
		IFSeqVelKeys.stGrpSet (
			~tKyVel[0],~tKyVel[1],~tKyVel[2],~tKyVel[3],
			~tKyVel[4],~tKyVel[5],~tKyVel[6],~tKyVel[7],
			~tKyVel[8],~tKyVel[9],~tKyVel[10],~tKyVel[11],
			~tKyVel[12],~tKyVel[13],~tKyVel[14],~tKyVel[15],
		);
		IFSeqSusKeys.stGrpSet (
			~tKySus[0],~tKySus[1],~tKySus[2],~tKySus[3],
			~tKySus[4],~tKySus[5],~tKySus[6],~tKySus[7],
			~tKySus[8],~tKySus[9],~tKySus[10],~tKySus[11],
			~tKySus[12],~tKySus[13],~tKySus[14],~tKySus[15],
		);
		IFSeqTmKeys.stGrpSet  (
			~tKyTm[0],~tKyTm[1],~tKyTm[2],~tKyTm[3],
			~tKyTm[4],~tKyTm[5],~tKyTm[6],~tKyTm[7],
			~tKyTm[8],~tKyTm[9],~tKyTm[10],~tKyTm[11],
			~tKyTm[12],~tKyTm[13],~tKyTm[14],~tKyTm[15],
		);
		IFSeqDurKeys.stGrpSet (
			~tKyDur[0],~tKyDur[1],~tKyDur[2],~tKyDur[3],
			~tKyDur[4],~tKyDur[5],~tKyDur[6],~tKyDur[7],
			~tKyDur[8],~tKyDur[9],~tKyDur[10],~tKyDur[11],
			~tKyDur[12],~tKyDur[13],~tKyDur[14],~tKyDur[15],
		);
		IFShuf.setKeys    (
			~tKyShuf[0],~tKyShuf[1],~tKyShuf[2],~tKyShuf[3],
			~tKyShuf[4],~tKyShuf[5],~tKyShuf[6],~tKyShuf[7],
			~tKyShuf[8],~tKyShuf[9],~tKyShuf[10],~tKyShuf[11],
			~tKyShuf[12],~tKyShuf[13],~tKyShuf[14],~tKyShuf[15],
		);
		IFLfo.setKeys    (
			~tKyLfo[0],~tKyLfo[1],~tKyLfo[2],~tKyLfo[3],
			~tKyLfo[4],~tKyLfo[5],~tKyLfo[6],~tKyLfo[7],
			~tKyLfo[8],~tKyLfo[9],~tKyLfo[10],~tKyLfo[11],
			~tKyLfo[12],~tKyLfo[13],~tKyLfo[14],~tKyLfo[15],
		);
		IFGlobal.setKeys  (
			~tKyEnv[0],~tKyEnv[1],~tKyEnv[2],~tKyEnv[3],
			~tKyEnv[4],~tKyEnv[5],~tKyEnv[6],~tKyEnv[7],
			~tKyEnv[8],~tKyEnv[9],~tKyEnv[10],~tKyEnv[11],
			~tKyEnv[12],~tKyEnv[13],~tKyEnv[14],~tKyEnv[15],
		);


	}//////
}
/*
Pbind(
\chan, ~chKeys,
\type, \midi, \midiout,~vKeys, \scale, Pfunc({~scl2}, inf),
\dur, Pseq([4],1),
\degree, Pseq([
], inf),
\amp, Pseq([~volKeysP.next*~amp1KeysP.next], inf),
\sustain, Pseq([~sus1KeysP.next],inf)*~susMulKeys,
\mtranspose, Pseq([~transKeysP.next], inf)+~trKeys+~transShufKeysP.next,
\octave, Pseq([~octKeysP.next], inf)+~octMulKeys,
\harmonic, Pseq([~hrmKeysP.next], inf)+~harmKeys
).play;

*/