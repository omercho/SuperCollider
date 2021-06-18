
/*
IFSamp.loadSC;
IFSamp.synthDef(1);
IFSamp.synthDef(2);
IFSamp.synthDef(3);
IFSamp.synthDef(4);
IFSamp.synthDef(5);


IFSamp.times(2);
IFSamp.pat_1;

~octSamp=4;
~octSamp.source = 5;

~secs=Clock.seconds;
*/


IFSamp {
	var <>keyTime = 1;
	classvar <>counter3 = 0;

	/**initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });*/
		}
	}*/
	*load{
		this.globals;
		this.proxy;
		this.osc;
		this.makeOSCResponders;
	}
	*globals{

		~chSamp=5;
		~lateSamp=0.00;
		~timesSamp=1;
		~octMulSamp=2;
		~rootFreqSamp=~c5; // 261=C4|523=C5
		~harmSamp=0;
		~susMulSamp=1;
		~trSamp=0;
		~lfoMulSamp1=0;
		~lfoMulSamp2=0;


	}
	/**octave{|val|
		~octSamp.source = Pseq([val], inf);
	}
	*octMul{|val|
		~octMulSamp = val;
		~tOSCAdrr.sendMsg('octSampLabel', val);
	}*/
	*proxy{
		~rootSamp = PatternProxy( Pseq([0], inf));
		~rootSampP = Pseq([~rootSamp], inf).asStream;
		~nt1Samp = PatternProxy( Pseq([0], inf));
		~nt1SampP = Pseq([~nt1Samp], inf).asStream;

		~dur1Samp = PatternProxy( Pseq([1], inf));
		~dur1SampP = Pseq([~dur1Samp], inf).asStream;
		~durMulSamp = PatternProxy( Pseq([1], inf));
		~durMulSampP = Pseq([~durMulSamp], inf).asStream;

		~amp1Samp = PatternProxy( Pseq([0.9], inf));
		~amp1SampP = Pseq([~amp1Samp], inf).asStream;
		~sus1Samp = PatternProxy( Pseq([1], inf));
		~sus1SampP = Pseq([~sus1Samp], inf).asStream;

		//~tmMulSamp = PatternProxy( Pseq([1], inf));
		//~tmMulSampP= Pseq([~tmMulSamp], inf).asStream;
		//~tmSamp = PatternProxy( Pseq([1], inf));
		//~tmSampP= Pseq([~tmSamp], inf).asStream;

		~transSamp = PatternProxy( Pseq([0], inf));
		~transSampP = Pseq([~transSamp], inf).asStream;
		~transShufSamp = PatternProxy( Pseq([0], inf));
		~transShufSampP = Pseq([~transShufSamp], inf).asStream;
		~transCntSamp = PatternProxy( Pseq([0], inf));
		~transCntSampP = Pseq([~transCntSamp], inf).asStream;

		~extraShufSamp = PatternProxy( Pshuf([0], inf));
		~extraShufSampP = Pseq([~extraShufSamp], inf).asStream;

		~octSamp = PatternProxy( Pseq([4], inf));
		~octSampP = Pseq([~octSamp], inf).asStream;
		//~legSamp= PatternProxy( Pseq([0.0], inf));
		//~legSampP = Pseq([~legSamp], inf).asStream;
		~hrmSamp = PatternProxy( Pseq([1.0], inf));
		~hrmSampP = Pseq([~hrmSamp], inf).asStream;

		~delta1Samp = PatternProxy( Pseq([1/4], inf));
		~delta1SampP = Pseq([~delta1Samp], inf).asStream;
		~delta2Samp = PatternProxy( Pseq([1/2], inf));
		~delta2SampP = Pseq([~delta2Samp], inf).asStream;

		~lfo1Samp = PatternProxy( Pseq([1], inf));
		~lfo1SampP = Pseq([~lfo1Samp], inf).asStream;
		~lfo2Samp = PatternProxy( Pseq([1], inf));
		~lfo2SampP = Pseq([~lfo2Samp], inf).asStream;

		~actSamp = PatternProxy( Pseq([1], inf));
		~actSampP= Pseq([~actSamp], inf).asStream;
		~volSamp = PatternProxy( Pseq([0.9], inf));
		~volSampP = Pseq([~volSamp], inf).asStream;

		//lng
		~rootLngSamp = PatternProxy( Pseq([0], inf));
		~rootLngSampP = Pseq([~rootLngSamp], inf).asStream;
		~nt1LngSamp = PatternProxy( Pseq([0], inf));
		~nt1LngSampP = Pseq([~nt1LngSamp], inf).asStream;
		~dur1LngSamp = PatternProxy( Pseq([1], inf));
		~dur1LngSampP = Pseq([~dur1LngSamp], inf).asStream;
		~amp1LngSamp = PatternProxy( Pseq([0.9], inf));
		~amp1LngSampP = Pseq([~amp1LngSamp], inf).asStream;
		~sus1LngSamp = PatternProxy( Pseq([1], inf));
		~sus1LngSampP = Pseq([~sus1LngSamp], inf).asStream;

		~transLngSamp = PatternProxy( Pseq([0], inf));
		~transLngSampP = Pseq([~transLngSamp], inf).asStream;
		~transShufLngSamp = PatternProxy( Pseq([0], inf));
		~transShufLngSampP = Pseq([~transShufLngSamp], inf).asStream;

	}


	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~lateSamp.wait;
				this.p1(val);
				((~dur1SampP.next)*(~durMulSampP.next)/val).wait;
			}}.fork;
		}
	}
	*p1 {|i=1|
		var val;
		val=i;

		Pbind(
			\chan, ~chAbk3,
			\type, \midi, \midiout,~vAmbk, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1SampP.next],~actSampP.next),
			\degree, Pseq([~nt1SampP.next], inf),
			//\amp, Pseq([~volSampP.next*~amp1SampP.next], inf),
			\amp, Pseq([~amp1SampP.next], inf),
			\sustain, Pseq([~sus1SampP.next],inf)*~susMulSamp,
			\mtranspose, Pseq([~transSampP.next], inf)+~extraShufSampP.next+~transCntSampP.next+~trSamp+~transShufSampP.next+~trSamp,
			\ctranspose, Pseq([~rootSampP.next],inf),
			\octave, Pseq([~octSampP.next], inf)+~octMulSamp,
			\harmonic, Pseq([~hrmSampP.next], inf)+~harmSamp
		).play(~clkSamp, quant: 0);

		Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~vAmbk, \chan, ~chAbk3, \ctlNum, 40,
			\delta, Pseq([~delta1SampP.next], 1),
			\control, Pseq([~lfo1SampP.next], 1)*~lfoMulSamp1,
		).play(~clkSamp, quant: 0);

		Pbind(//LFO 2
			\type, \midi, \midicmd, \control,
			\midiout,~vAmbk,\chan, ~chAbk3,  \ctlNum, 41,
			\delta, Pseq([~delta2SampP.next], 1),
			\control, Pseq([~lfo2SampP.next], 1)*~lfoMulSamp2,
		).play(~clkSamp, quant: 0);

	}//p1

	*lng{|deg=0,amp=1,sus=4|
		Pbind(
			\chan, ~chAbk3,
			\type, \midi, \midiout,~vAmbk, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1LngSampP.next],1),
			\degree, Pseq([~nt1LngSampP.next], inf)+deg,
			\amp, Pseq([~volSampP.next*~amp1LngSampP.next], inf)*amp,
			\sustain, Pseq([~sus1LngSampP.next],inf)*sus,
			\mtranspose, Pseq([~transLngSampP.next], inf)+~transCntSampP.next+~transShufLngSampP.next,
			\ctranspose, Pseq([~rootLngSampP.next],inf),
			\octave, Pseq([~octSampP.next], inf)+~octMulSamp,
			\harmonic, Pseq([~hrmSampP.next], inf)+~harmSamp
		).play(~clkSamp, quant: 0);
	}

	*osc{

		~actSampBut.free;
		~actSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actSamp.source=1;
				~apcMn.noteOn(~melMixGlb, ~actButA5, 127); //Trk5_But 1

			},{
				~actSamp.source=0;
				~apcMn.noteOff(~melMixGlb, ~actButA5, 0); //Trk4_But 1
			});
		},
		'/activSamp'
		);

		~time2SampBut.free;
		~countTime2Samp=0;
		~time2SampBut= OSCFunc({
			arg msg;
			~countTime2Samp = ~countTime2Samp + 1;
			~countTime2Samp.switch(
				0,{},
				1, {
					//~apcMn.noteOn(~apcMnCh, ~actButB6, 1);
					//~tOSCAdrr.sendMsg('time2Samp', 1);
					//~tOSCAdrr.sendMsg('tmSampLabel', 2);
					//~tmMulSamp.source = Pseq([2], inf);
				},
				2,{
					//~apcMn.noteOn(~apcMnCh, ~actButB6, 0);
					//~tOSCAdrr.sendMsg('time2Samp', 0);
					//~tOSCAdrr.sendMsg('tmSampLabel', 1);
					//~tmMulSamp.source = Pseq([1], inf);
					~countTime2Samp=0;
				}
			);
		},
		'/time2Samp'
		);


		/*~volSampFader.free;
		~volSampFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volSamp', msg[1]);
			~mdOut.control(7, 1, vel);
		},
		'/volSamp'
		);

		~attSampFader.free;
		~attSampFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('attSamp', msg[1]);
			~mdOut.control(7, 5, vel);
		},
		'attSamp'
		);

		~susLevSampFader.free;
		~susLevSampFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('susSamp', msg[1]);
			~susLevSamp=msg[1];
			~mdOut.control(7, 6, msg[1]*127);

		},
		'/susSamp'
		);

		~decSampFader.free;
		~decSampFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('decSamp', val);
			~decSamp=val;
			~mdOut.control(7, 127, vel);
			~nobD7_m1Val= vel;
		},
		'/decSamp'
		);

		~chainSampFader.free;
		~chainSampFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('chainSamp', msg[1]);
			~mdOut.control(7, 8, msg[1]*127);
		},
		'/chainSamp'
		);

		~sendSampXY.free;
		~sendSampXY= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~mdOut.control(7, 4, vel1); // IFSamp
			~mdOut.control(7, 3, vel2); // IFSamp
			~mdOut.control(7, 10, vel2); // IFSamp
			~tOSCAdrr.sendMsg('sendSamp', msg[1], msg[2]);

		},
		'sendSamp'
		);
		~xy1Samp.free;
		~xy1Samp= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~mdOut.control(7, 11, vel1); // IFSamp
			~mdOut.control(7, 12, vel2); // IFSamp
			~tOSCAdrr.sendMsg('xy1Samp', msg[1], msg[2]);

		},
		'xy1Samp'
		);

		~lfoMulSampFad1.free;
		~lfoMulSampFad1= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulSamp1', msg[1]);
			~lfoMulSamp1=msg[1];
		},
		'/lfoMulSamp1'
		);

		~lfoMulSampFad2.free;
		~lfoMulSampFad2= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulSamp2', msg[1]);
			~lfoMulSamp2=msg[1];
		},
		'/lfoMulSamp2'
		);
		//TIME

		~tmMulSampBut1.free;
		~tmMulSampBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulSamp.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 1);
			});
		},
		'/tmMulSamp1'
		);
		~tmMulSampBut2.free;
		~tmMulSampBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulSamp.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 2);
			});
		},
		'/tmMulSamp2'
		);
		~tmMulSampBut3.free;
		~tmMulSampBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulSamp.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 3);
			});
		},
		'/tmMulSamp3'
		);
		~tmSampFader.free;
		~tmSampFader= OSCFunc({
			arg msg;
			~tmSamp.source = msg[1];
		},
		'/timesSamp'
		);

		~padSamp.free;
		~padSamp = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSamp(~tmSampP.next);
			});
		},
		'/padSamp'
		);

		//----Samp-------
		~octSampMulBut.free;
		~octSampMulBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				//~octMulSamp = ~octMulSamp+1;
				//~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);
				IFSamp.octMul(~octMulSamp+1)
			});
		},
		'/octSampMul'
		);

		~octSampZeroBut.free;
		~octSampZeroBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSamp.octMul(0)
			});
		},
		'/octSampZero'
		);

		~octSampDivBut.free;
		~octSampDivBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulSamp = ~octMulSamp-1;
				~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);
			});
		},
		'/octSampDiv'
		);*/

	}
	//      NEW OSC
	*set{|key,val|
		var vel, valNew;
		vel=val*127;
		key.switch(
			/*\timeM,{
				if ( val==1, {
					~apcMn.noteOn(~apcMnCh, ~actButA4, 1);
					~tmMulSamp.source = Pseq([2], inf);
				});
			},*/
			\octMDcr,{
				if ( val==1, {
					~crntSamp_octM=~crntSamp_octM-1;
					IFSamp.set1(\octM,~crntSamp_octM);
				});
			},
			\octMIcr,{
				if ( val==1, {
					~crntSamp_octM=~crntSamp_octM+1;
					IFSamp.set1(\octM,~crntSamp_octM);
				});
			},
			\octMZero,{
				if ( val==1, {
					IFSamp.set1(\octM,0);
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
				~crntSamp_vol=val1;
				this.lbl1(\volSamp,val1);
				//~volSamp.source = val1;
				//~mdOut.control(7, 1, vel1);
			},
			\att, {
				~crntSamp_att=val1;
				this.lbl1(\IFattSamp,val1);
				//~mdOut.control(7, 5, vel1);
			},
			\dec, {
				~crntSamp_dec=val1;
				this.lbl1(\IFdecSamp,val1);
				//~mdOut.control(7, 127, vel1);
			},
			\sus, {
				~crntSamp_sus=val1;
				this.lbl1(\IFsusSamp,val1);
				//~mdOut.control(7, 6, vel1);
			},
			\rls, {
				~crntSamp_rls=val1;
				this.lbl1(\IFrlsSamp,val1);
				//~mdOut.control(7, 8, vel1);
			},
			\pan, {
				~crntSamp_pan=val1;
				this.lbl1(\IFpanSamp,val1);
				//~mdOut.control(7, 16, vel1);
			},
			\octM, {
				~crntSamp_octM=val1;
				this.lbl1(\IFoctMSampLbl,val1);
				~octMulSamp = val1;
			},
			\susM, {
				~crntSamp_susM=val1;
				this.lbl1(\IFsusMSamp,val1);
				~susMulSamp=val1;
			},
			\lfoM1, {
				~crntSamp_lfoM1=val1;
				this.lbl1(\IFlfoM1Samp,val1);
				~lfoMulSamp1=val1;
			},
			\lfoM2, {
				~crntSamp_lfoM2=val1;
				this.lbl1(\IFlfoM2Samp,val1);
				~lfoMulSamp2=val1;
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
				this.lbl2(\IFsendSamp,val1,val2);
				~mdOut.control(7, 4, vel1); // IFSamp
				~mdOut.control(7, 3, vel2); // IFSamp
				~crntSamp_sndY=val1;
				~crntSamp_sndX=val2;
			},
			\xy1, {
				this.lbl2(\IFxy1Samp,val1,val2);
				~crntSamp_xy1X=val2;
				~crntSamp_xy1Y=val1;
			},
			\xy2, {
				this.lbl2(\IFxy2Samp,val1,val2);
				~crntSamp_xy2X=val2;
				~crntSamp_xy2Y=val1;
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
				'octMDcrSamp_T', { this.set(\octMDcr,val);},
				'octMIcrSamp_T', { this.set(\octMIcr,val);},
				'octMZeroSamp_T', { this.set(\octMZero,val);},
				//-GlobalSettings
				'volSamp_T' , { this.set1(\vol,val1);},
				'attSamp_T' , { this.set1(\att,val1);},
				'decSamp_T' , { this.set1(\dec,val1);},
				'susSamp_T' , { this.set1(\sus,val1);},
				'rlsSamp_T' , { this.set1(\rls,val1);},
				'panSamp_T' , { this.set1(\pan,val1);},

				'sendSamp_T', { this.set2(\send,val1,val2);},
				'susMSamp_T', { this.set1(\susM,val1);},
				'octMSamp_T', { this.set1(\octM,val1);},
				'xy1Samp_T' , { this.set2(\xy1,val1,val2);},
				'xy2Samp_T' , { this.set2(\xy2,val1,val2);},
				'lfoM1Samp_T',{ this.set1(\lfoM1,val1);},
				'lfoM2Samp_T',{ this.set1(\lfoM2,val1);},
			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\octMDcrSampResp, oscName:\IFoctMDcrSamp, playTag:'octMDcrSamp_T');
		this.oscResp(respName:\octMIcrSampResp, oscName:\IFoctMIcrSamp, playTag:'octMIcrSamp_T');
		this.oscResp(respName:\octMZeroSampResp, oscName:\IFoctMZeroSamp, playTag:'octMZeroSamp_T');
		//-GlobalSettings
		this.oscResp(respName:\volSampResp, oscName:\IFvolSamp, playTag:'volSamp_T');
		this.oscResp(respName:\attSampResp, oscName:\IFattSamp, playTag:'attSamp_T');
		this.oscResp(respName:\decSampResp, oscName:\IFdecSamp, playTag:'decSamp_T');
		this.oscResp(respName:\susSampResp, oscName:\IFsusSamp, playTag:'susSamp_T');
		this.oscResp(respName:\rlsSampResp, oscName:\IFrlsSamp, playTag:'rlsSamp_T');
		this.oscResp(respName:\panSampResp, oscName:\IFpanSamp, playTag:'panSamp_T');

		this.oscResp(respName:\sendSampResp, oscName:\IFsendSamp, playTag:'sendSamp_T');
		this.oscResp(respName:\susMSampResp, oscName:\IFsusMSamp, playTag:'susMSamp_T');
		this.oscResp(respName:\octMSampResp, oscName:\IFoctMSamp, playTag:'octMSamp_T');
		this.oscResp(respName:\xy1SampResp,  oscName:\IFxy1Samp, playTag:'xy1Samp_T');
		this.oscResp(respName:\xy2SampResp, oscName:\IFxy2Samp, playTag:'xy2Samp_T');
		this.oscResp(respName:\lfoM1SampResp, oscName:\IFlfoM1Samp, playTag:'lfoM1Samp_T');
		this.oscResp(respName:\lfoM2SampResp, oscName:\IFlfoM2Samp, playTag:'lfoM2Samp_T');
	}
}

IFTxtSamp{
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
		shuf= Pwhite(0,   4,   inf).asStream;
		lfoP= Pwhite(10,   127, inf).asStream;
		vol=  Pwhite(0.85, 0.95,inf).asStream;
		att=  Pwhite(0.2, 0.5, inf).asStream;
		dec=  Pwhite(0.6, 1.0, inf).asStream;
		susV= Pwhite(0.1, 0.6, inf).asStream;
		rls=  Pwhite(0.2, 0.9, inf).asStream;
		pan=  Pwhite(0.1, 0.9, inf).asStream;
		sndA= Pwhite(0.1, 0.9, inf).asStream;
		sndB= Pwhite(0.1, 0.9, inf).asStream;
		octM= Pwhite(1,   3, inf).asStream;
		susM= Pwhite(0.1, 0.4, inf).asStream;
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
			'rndSampTag',{
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
		IFTxtSamp.make(\00,\01,\ifSamp,'rndSampTag');
	}
	*read{|trck,prtDir|

		IFTxt.readIfTrack(trck,prtDir,\ifSamp);
		~tSmAmp=IFTxt.line(1);
		~tSmOct=IFTxt.line(2);
		~tSmNt=IFTxt.line(3);
		~tSmVel=IFTxt.line(4);
		~tSmSus=IFTxt.line(5);
		~tSmTm=IFTxt.line(6);
		~tSmDur=IFTxt.line(7);
		~tSmShuf=IFTxt.line(8);
		~tSmLfo=IFTxt.line(9);
		~tSmEnv=IFTxt.line(10);

		this.storeVals;
	}
	*storeVals{//////
		"Store Samp Values from Txt to Patterns ".postln;
		//[ Samp ]
		IFSeqSamp.stGrpSet    (
			~tSmAmp[0],~tSmAmp[1],~tSmAmp[2],~tSmAmp[3],
			~tSmAmp[4],~tSmAmp[5],~tSmAmp[6],~tSmAmp[7],
			~tSmAmp[8],~tSmAmp[9],~tSmAmp[10],~tSmAmp[11],
			~tSmAmp[12],~tSmAmp[13],~tSmAmp[14],~tSmAmp[15],
		);
		IFSeqOctSamp.stGrpSet  (
			~tSmOct[0],~tSmOct[1],~tSmOct[2],~tSmOct[3],
			~tSmOct[4],~tSmOct[5],~tSmOct[6],~tSmOct[7],
			~tSmOct[8],~tSmOct[9],~tSmOct[10],~tSmOct[11],
			~tSmOct[12],~tSmOct[13],~tSmOct[14],~tSmOct[15],
		);
		IFSeqNtSamp.stGrpSet  (
			~tSmNt[0],~tSmNt[1],~tSmNt[2],~tSmNt[3],
			~tSmNt[4],~tSmNt[5],~tSmNt[6],~tSmNt[7],
			~tSmNt[8],~tSmNt[9],~tSmNt[10],~tSmNt[11],
			~tSmNt[12],~tSmNt[13],~tSmNt[14],~tSmNt[15],
		);
		IFSeqVelSamp.stGrpSet (
			~tSmVel[0],~tSmVel[1],~tSmVel[2],~tSmVel[3],
			~tSmVel[4],~tSmVel[5],~tSmVel[6],~tSmVel[7],
			~tSmVel[8],~tSmVel[9],~tSmVel[10],~tSmVel[11],
			~tSmVel[12],~tSmVel[13],~tSmVel[14],~tSmVel[15],
		);
		IFSeqSusSamp.stGrpSet (
			~tSmSus[0],~tSmSus[1],~tSmSus[2],~tSmSus[3],
			~tSmSus[4],~tSmSus[5],~tSmSus[6],~tSmSus[7],
			~tSmSus[8],~tSmSus[9],~tSmSus[10],~tSmSus[11],
			~tSmSus[12],~tSmSus[13],~tSmSus[14],~tSmSus[15],
		);
		IFSeqTmSamp.stGrpSet  (
			~tSmTm[0],~tSmTm[1],~tSmTm[2],~tSmTm[3],
			~tSmTm[4],~tSmTm[5],~tSmTm[6],~tSmTm[7],
			~tSmTm[8],~tSmTm[9],~tSmTm[10],~tSmTm[11],
			~tSmTm[12],~tSmTm[13],~tSmTm[14],~tSmTm[15],
		);
		IFSeqDurSamp.stGrpSet (
			~tSmDur[0],~tSmDur[1],~tSmDur[2],~tSmDur[3],
			~tSmDur[4],~tSmDur[5],~tSmDur[6],~tSmDur[7],
			~tSmDur[8],~tSmDur[9],~tSmDur[10],~tSmDur[11],
			~tSmDur[12],~tSmDur[13],~tSmDur[14],~tSmDur[15],
		);
		IFShuf.setSamp    (
			~tSmShuf[0],~tSmShuf[1],~tSmShuf[2],~tSmShuf[3],
			~tSmShuf[4],~tSmShuf[5],~tSmShuf[6],~tSmShuf[7],
			~tSmShuf[8],~tSmShuf[9],~tSmShuf[10],~tSmShuf[11],
			~tSmShuf[12],~tSmShuf[13],~tSmShuf[14],~tSmShuf[15],
		);
		IFLfo.setSamp    (
			~tSmLfo[0],~tSmLfo[1],~tSmLfo[2],~tSmLfo[3],
			~tSmLfo[4],~tSmLfo[5],~tSmLfo[6],~tSmLfo[7],
			~tSmLfo[8],~tSmLfo[9],~tSmLfo[10],~tSmLfo[11],
			~tSmLfo[12],~tSmLfo[13],~tSmLfo[14],~tSmLfo[15],
		);
		IFGlobal.setSamp  (
			~tSmEnv[0],~tSmEnv[1],~tSmEnv[2],~tSmEnv[3],
			~tSmEnv[4],~tSmEnv[5],~tSmEnv[6],~tSmEnv[7],
			~tSmEnv[8],~tSmEnv[9],~tSmEnv[10],~tSmEnv[11],
			~tSmEnv[12],~tSmEnv[13],~tSmEnv[14],~tSmEnv[15],
		);


	}//////
}

/*
Pbind(
	\chan, ~chSamp,
	\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
	\dur, Pseq([1],1),
	\degree, Pxrand([
		[0,2,4],
		[0,6,4],
		[0,3,9]
	], inf),
	\amp, Pseq([1], inf),
	\sustain, Pseq([12],inf),
	//\mtranspose, Pseq([~transSampP.next], inf)+~trSamp+~transShufSampP.next,
	//\octave, Pseq([~octSampP.next], inf)+~octMulSamp,
	//\harmonic, Pseq([~hrmSampP.next], inf)+~harmSamp
).play;

*/