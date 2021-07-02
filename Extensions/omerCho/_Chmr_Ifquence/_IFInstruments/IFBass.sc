/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

IFBass.times(2);
IFBass.p1_SC(1);
~octBass=4;

IFBass.lng(0,1,127,1);
IFMopho.lng(0,0.1,118,0.7);
*/
IFBass {
	var <>keyTime = 1;
	classvar <>counter3 = 0;
	/**initClass {
	StartUp add: {
	/*Server.default.doWhenBooted({
	this.load;
	});*/
	}
	}*/
	*load {
		this.globals;
		this.proxy;
		this.osc;
		this.makeOSCResponders;
	}
	*globals{
		~chVBass=0;
		~chBass=3;
		~bassLate=0.0;
		~timesBass=1;
		~octMulBass=0;
		~harmBass=0;
		~rootBass=0;
		~susMulBass=1;
		~trBass=0;
		~lfoMulBass1=0.2;
		~lfoMulBass2=0.2;
	}

	*proxy {
		~actBass = PatternProxy( Pseq([1], inf));
		~actBassP= Pseq([~actBass], inf).asStream;

		~volBass = PatternProxy( Pseq([0.9], inf));
		~volBassP = Pseq([~volBass], inf).asStream;

		~rootBass = PatternProxy( Pseq([0], inf));
		~rootBassP = ~rootBass.asStream;
		~root2BassP = ~rootBass.asStream;
		~root3BassP = ~rootBass.asStream;


		~nt1Bass = PatternProxy( Pseq([0], inf));
		~nt1BassP = ~nt1Bass.asStream;
		~nt2BassP = ~nt1Bass.asStream+~nt2Bass.asStream;
		~nt3BassP = ~nt1Bass.asStream+~nt2Bass.asStream+~nt3Bass.asStream;
		//~nt1BassP = Pseq([~nt1Bass], inf).asStream;

		~dur1Bass = PatternProxy( Pseq([1], inf));
		~dur1BassP =~dur1Bass.asStream;
		~dur2BassP = ~dur1Bass.asStream;
		~dur3BassP = ~dur1Bass.asStream;
		//~dur1BassP = Pseq([~dur1Bass], inf).asStream;

		~durMulBass = PatternProxy( Pseq([1], inf));
		//~durMulBassP = Pseq([~durMulBass], inf).asStream;
		~durMulBassP = ~durMulBass.asStream;
		~durMul2BassP = ~durMulBass.asStream;
		~durMul3BassP = ~durMulBass.asStream;

		~amp1Bass = PatternProxy( Pseq([0.9], inf));
		~amp1BassP = ~amp1Bass.asStream;
		~amp2BassP = ~amp1Bass.asStream;
		~amp3BassP = ~amp1Bass.asStream;
		//~amp1BassP = Pseq([~amp1Bass], inf).asStream;

		~sus1Bass = PatternProxy( Pseq([1], inf));
		~sus1BassP = ~sus1Bass.asStream;
		~sus2BassP = ~sus1Bass.asStream;
		~sus3BassP = ~sus1Bass.asStream;
		//~sus1BassP = Pseq([~sus1Bass], inf).asStream;

		~transBass = PatternProxy( Pseq([0.2], inf));
		~transBassP= ~transBass.asStream;
		~trans2BassP= ~transBass.asStream;
		~trans3BassP= ~transBass.asStream;
		//~transBassP = Pseq([~transBass], inf).asStream;


		~transShufBass = PatternProxy( Pseq([0], inf));
		//~transShufBassP = Pseq([~transShufBass], inf).asStream;
		~transShufBassP = ~transShufBass.asStream;
		~trans2ShufBassP = ~transShufBass.asStream;
		~trans3ShufBassP = ~transShufBass.asStream;


		~transCntBass = PatternProxy( Pseq([0], inf));
		//~transCntBassP = Pseq([~transCntBass], inf).asStream;
		~transCntBassP = ~transCntBass.asStream;
		~trans2CntBassP = ~transCntBass.asStream;
		~trans3CntBassP = ~transCntBass.asStream;

		//~extraShufBass = PatternProxy( Pshuf([0], inf));
		//~extraShufBassP = Pseq([~extraShufBass], inf).asStream;

		~octBass = PatternProxy( Pseq([2], inf));
		~octBassP = Pseq([~octBass], inf).asStream;
		~oct2BassP = Pseq([~octBass], inf).asStream;
		~oct3BassP = Pseq([~octBass], inf).asStream;

		~hrmBass = PatternProxy( Pseq([1.0], inf));
		~hrmBassP = Pseq([~hrmBass], inf).asStream;
		~hrm2BassP = Pseq([~hrmBass], inf).asStream;
		~hrm2BassP = Pseq([~hrmBass], inf).asStream;

		~delta1Bass = PatternProxy( Pseq([1/1], inf));
		~delta1BassP = Pseq([~delta1Bass], inf).asStream;
		~delta2Bass = PatternProxy( Pseq([1/1], inf));
		~delta2BassP = Pseq([~delta2Bass], inf).asStream;

		~lfo1Bass = PatternProxy( Pseq([10], inf));
		~lfo1BassP = Pseq([~lfo1Bass], inf).asStream;
		~lfo2Bass = PatternProxy( Pseq([10], inf));
		~lfo2BassP = Pseq([~lfo2Bass], inf).asStream;



		//lng
		~rootLngBass = PatternProxy( Pseq([0], inf));
		~rootLngBassP = Pseq([~rootLngBass], inf).asStream;
		~nt1LngBass = PatternProxy( Pseq([0], inf));
		~nt1LngBassP = Pseq([~nt1LngBass], inf).asStream;
		~dur1LngBass = PatternProxy( Pseq([0.25], inf));
		~dur1LngBassP = Pseq([~dur1LngBass], inf).asStream;
		~amp1LngBass = PatternProxy( Pseq([0.9], inf));
		~amp1LngBassP = Pseq([~amp1LngBass], inf).asStream;
		~sus1LngBass = PatternProxy( Pseq([1], inf));
		~sus1LngBassP = Pseq([~sus1LngBass], inf).asStream;

		~transLngBass = PatternProxy( Pseq([0], inf));
		~transLngBassP = Pseq([~transLngBass], inf).asStream;
		~transShufLngBass = PatternProxy( Pseq([0], inf));
		~transShufLngBassP = Pseq([~transShufLngBass], inf).asStream;
	}
	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~bassLate.wait;
				this.p1(val);
				((~dur1BassP.next)*(~durMulBassP.next)/val).wait;
			}}.fork;
		}
	}
	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chAbk1,
			\type, \midi, \midiout,~vAmbk, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1BassP.next],~actBassP.next),
			\degree, Pseq([~nt1BassP.next], inf),
			//\amp, Pseq([~volBassP.next*~amp1BassP.next], inf),
			\amp, Pseq([~amp1BassP.next], inf),
			\sustain, Pseq([1*~sus1BassP.next],inf)*~susMulBass,
			\mtranspose, Pseq([~transBassP.next], inf)+~transShufBassP.next+~transCntBassP.next+~trBass,
			\ctranspose, Pseq([~rootBassP.next],inf),
			\octave, Pseq([~octBassP.next], inf)+~octMulBass,
			\harmonic, Pseq([~hrmBassP.next], inf)+~harmBass
		).play(~clkBass, quant: 0);

		/*Pbind(//LFO CUT BASS INT
			\midicmd, \control, \type, \midi,
			\midiout,~vAmbk, \chan, ~chAbk1, \ctlNum, ~envDecVB,
			\delta, Pseq([~delta1BassP.next], 1),
			\control, Pseq([~lfo1BassP.value], 1)*~lfoMulBass1,
		).play(~clkBass, quant: 0);
		Pbind(//LFO CUT BASS RATE
			\midicmd, \control, \type, \midi,
			\midiout,~vAmbk, \chan, ~chAbk1, \ctlNum, ~slideTm,
			\delta, Pseq([~delta2BassP.next], 1),
			\control, Pseq([~lfo2BassP.value], 1)*~lfoMulBass2,
		).play(~clkBass, quant: 0);*/

	}//p1

	*lng{|deg=0,amp=1,sus=4|
		/*Pbind(
			\chan, ~chAbk1,
			\type, \midi, \midiout,~vAmbk, \scale, Pfunc({~scl2},inf),
			\dur, Pseq([~dur1LngBassP.next],1)+sus,
			\ctranspose, Pseq([~rootLngBassP.next],inf),
			\degree, Pseq([~nt1LngBassP.next],inf)+deg,
			\amp, Pseq([~volBassP.next*~amp1LngBassP.next],inf)+amp,
			\sustain, Pseq([~sus1LngBassP.next],inf)+sus,
			\mtranspose, Pseq([~transLngBassP.next],inf)+~transShufLngBassP.next+~transCntBassP.next,
			\octave, Pseq([~octBassP.next],inf)+~octMulBass,
			\harmonic, Pseq([~hrmBassP.next],inf)+~harmBass
		).play(~clkBass, quant: 0);*/
	}//lng

	*osc{
		~actBassBut.free;
		~actBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actBass.source=1;
				~melMix.noteOn(~melMixGlb, ~actButA1, 127); //Trk4_But 1
			},{
				~actBass.source=0;
				~melMix.noteOff(~melMixGlb, ~actButA1, 0); //Trk4_But 1
			});
		},'/activBass');

		~time2BassBut.free;
		~countTime2Bass=0;
		~time2BassBut= OSCFunc({
			arg msg;
			~countTime2Bass = ~countTime2Bass + 1;
			~countTime2Bass.switch(
				1, {
					//~apcMn.noteOn(~melMixGlb, ~actButB8, 1); //Trk4_But 2
					//~tmMulBass.source = Pseq([2], inf);
				},
				2,{
					//~tmMulBass.source = Pseq([1], inf);
					//~apcMn.noteOn(~melMixGlb, ~actButB8, 0); //Trk4_But 2
					~countTime2Bass=0;
				}
			);
		},'/time2Bass');

	}
	/*
	*octave{|val|
		~octBass.source = Pseq([val], inf);
	}
	*octMul{|val|
		~octMulBass = val;
		~tOSCAdrr.sendMsg('octBassLabel', val);
	}
	IFBass.octMul(1);
	IFBass.set1(\octM,2);
	IFBass.set1(\vol,0.2);
	IFBass.set1(\att,0.5);
	IFBass.lbl1(\IFattBass,0.2);
	VBass.cc(\envAttVB,0.5);
	~mdOut.control(5, 5, 0.8*127);
	~vBass.control(0, ~envAttVB, 0.1);
	~local.sendMsg('IFattBass',0.1);
	IFBass.set(\decBass,0.2);
	~local.sendMsg('IFdecBass',0.1);
	IFBass.set1(\sus,0.2);
	IFBass.set1(\rls,0.2);

	IFBass.oscResp(respName:\attBassResp, oscName:\IFattBass, playTag:'attBass_T');
	*/
	//      NEW OSC
	*set{|key,val|
		var vel, valNew;
		vel=val*127;
		key.switch(
			/*\timeM,{
				if ( val==1, {
					~apcMn.noteOn(~apcMnCh, ~actButA4, 1);
					~tmMulBass.source = Pseq([2], inf);
				});
			},*/
			\octMDcr,{
				if ( val==1, {
					~crntBass_octM=~crntBass_octM-1;
					IFBass.set1(\octM,~crntBass_octM);
				});
			},
			\octMIcr,{
				if ( val==1, {
					~crntBass_octM=~crntBass_octM+1;
					IFBass.set1(\octM,~crntBass_octM);
				});
			},
			\octMZero,{
				if ( val==1, {
					IFBass.set1(\octM,0);
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
				~crntBass_vol=val1;
				this.lbl1(\volBass,val1);
				~volBass.source = val1;
				Ambk.cc(\pt1,\pt1Vol,vel1);
				//~mdOut.control(2, 1, vel1);
			},
			\att, {
				~crntBass_att=val1;
				this.lbl1(\IFattBass,val1);
				Ambk.cc(\pt1,\pt1Env1Att,vel1);
				//~mdOut.control(5, 5, vel1);
			},
			\dec, {
				~crntBass_dec=val1;
				this.lbl1(\IFdecBass,val1);
				Ambk.cc(\pt1,\pt1Env1Dec,vel1);
				//~mdOut.control(5, 127, vel1);
			},
			\sus, {
				~crntBass_sus=val1;
				this.lbl1(\IFsusBass,val1);
				Ambk.cc(\pt1,\pt1Env1Sus,vel1);
				//~mdOut.control(5, 6, vel1);
			},
			\rls, {
				~crntBass_rls=val1;
				this.lbl1(\IFrlsBass,val1);
				Ambk.cc(\pt1,\pt1Env1Rls,vel1);
				//~mdOut.control(5, 8, vel1);
			},
			\pan, {
				~crntBass_pan=val1;
				this.lbl1(\IFpanBass,val1);
				Ambk.cc(\pt1,\pt1Mix,vel1);
				//~mdOut.control(5, 16, vel1);
			},
			\cut, {
				~crntBass_cut=val1;
				this.lbl1(\IFcutBass,val1);
				Ambk.cc(\pt1,\pt1F1Cut,vel1);
				//~mdOut.control(5, 13, vel1);
			},
			\res, {
				~crntBass_res=val1;
				this.lbl1(\IFresBass,val1);
				Ambk.cc(\pt1,\pt1F1Res,vel1);
				//~mdOut.control(5, 14, vel1);
			},
			\octM, {
				~crntBass_octM=val1;
				this.lbl1(\IFoctMBassLbl,val1);
				~octMulBass = val1;
			},
			\susM, {
				~crntBass_susM=val1;
				this.lbl1(\IFsusMBass,val1);
				~susMulBass=val1;
			},
			\lfoM1, {
				~crntBass_lfoM1=val1;
				this.lbl1(\IFlfoM1Bass,val1);
				~lfoMulBass1=val1;
			},
			\lfoM2, {
				~crntBass_lfoM2=val1;
				this.lbl1(\IFlfoM2Bass,val1);
				~lfoMulBass2=val1;
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
				this.lbl2(\IFsendBass,val1,val2);
				~mdOut.control(5, 4, vel1); // IFBass
				~mdOut.control(5, 3, vel2); // IFBass
				~crntBass_sndY=val1;
				~crntBass_sndX=val2;
			},
			\xy1, {
				this.lbl2(\IFxy1Bass,val1,val2);
				IFBass.set1(\cut,val2);
				IFBass.set1(\res,val1);
				//~mdOut.control(5, 13, vel2);
				//~mdOut.control(5, 14, vel1);
				~crntBass_xy1X=val2;
				~crntBass_xy1Y=val1;
			},
			\xy2, {
				this.lbl2(\IFxy2Bass,val1,val2);
				//VBass.cc(\vco2VB,vel2);
				//VBass.cc(\vco3VB,vel1);
				~crntBass_xy2X=val2;
				~crntBass_xy2Y=val1;
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
				'octMDcrBass_T', { this.set(\octMDcr,val);},
				'octMIcrBass_T', { this.set(\octMIcr,val);},
				'octMZeroBass_T', { this.set(\octMZero,val);},
				//-GlobalSettings
				'volBass_T' , { this.set1(\vol,val1);},
				'attBass_T' , { this.set1(\att,val1);},
				'decBass_T' , { this.set1(\dec,val1);},
				'susBass_T' , { this.set1(\sus,val1);},
				'rlsBass_T' , { this.set1(\rls,val1);},
				'panBass_T' , { this.set1(\pan,val1);},

				'cutBass_T' , { this.set1(\cut,val1);},
				'resBass_T' , { this.set1(\res,val1);},

				'sendBass_T', { this.set2(\send,val1,val2);},
				'susMBass_T', { this.set1(\susM,val1);},
				'octMBass_T', { this.set1(\octM,val1);},
				'xy1Bass_T' , { this.set2(\xy1,val1,val2);},
				'xy2Bass_T' , { this.set2(\xy2,val1,val2);},
				'lfoM1Bass_T',{ this.set1(\lfoM1,val1);},
				'lfoM2Bass_T',{ this.set1(\lfoM2,val1);},
			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\octMDcrBassResp, oscName:\IFoctMDcrBass, playTag:'octMDcrBass_T');
		this.oscResp(respName:\octMIcrBassResp, oscName:\IFoctMIcrBass, playTag:'octMIcrBass_T');
		this.oscResp(respName:\octMZeroBassResp, oscName:\IFoctMZeroBass, playTag:'octMZeroBass_T');
		//-GlobalSettings
		this.oscResp(respName:\volBassResp, oscName:\IFvolBass, playTag:'volBass_T');
		this.oscResp(respName:\attBassResp, oscName:\IFattBass, playTag:'attBass_T');
		this.oscResp(respName:\decBassResp, oscName:\IFdecBass, playTag:'decBass_T');
		this.oscResp(respName:\susBassResp, oscName:\IFsusBass, playTag:'susBass_T');
		this.oscResp(respName:\rlsBassResp, oscName:\IFrlsBass, playTag:'rlsBass_T');
		this.oscResp(respName:\panBassResp, oscName:\IFpanBass, playTag:'panBass_T');

		this.oscResp(respName:\cutBassResp, oscName:\IFcutBass, playTag:'cutBass_T');
		this.oscResp(respName:\resBassResp, oscName:\IFresBass, playTag:'resBass_T');

		this.oscResp(respName:\sendBassResp, oscName:\IFsendBass, playTag:'sendBass_T');
		this.oscResp(respName:\susMBassResp, oscName:\IFsusMBass, playTag:'susMBass_T');
		this.oscResp(respName:\octMBassResp, oscName:\IFoctMBass, playTag:'octMBass_T');
		this.oscResp(respName:\xy1BassResp,  oscName:\IFxy1Bass, playTag:'xy1Bass_T');
		this.oscResp(respName:\xy2BassResp,  oscName:\IFxy2Bass, playTag:'xy2Bass_T');
		this.oscResp(respName:\lfoM1BassResp, oscName:\IFlfoM1Bass, playTag:'lfoM1Bass_T');
		this.oscResp(respName:\lfoM2BassResp, oscName:\IFlfoM2Bass, playTag:'lfoM2Bass_T');
	}

}
IFTxtBass{
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
			Pwhite(0,   7,   inf).asStream;
			Pseq([0,0,1,0],inf).asStream,
			Pseq([0,1,1,0],inf).asStream,
			Pseq([1,1,1,0],inf).asStream,
			Pseq([0,1,1,1],inf).asStream,
			Pseq([0,1,0,1],inf).asStream,
			Pshuf([0,1,0,1],inf).asStream,
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
			Pseq([2],inf).asStream,
			Pshuf([2,1,1,1],inf).asStream,
			Pshuf([2,1,2,1],inf).asStream,
		].choose;
		dur=  Pwhite(1,   4,   inf).asStream;
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
			'rndBassTag',{
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
		IFTxtBass.make(\00,\01,\ifBass,'rndBassTag');
	}
	*read{|trck,prtDir|

		IFTxt.readIfTrack(trck,prtDir,\ifBass);
		~tBsAmp=IFTxt.line(1);
		~tBsOct=IFTxt.line(2);
		~tBsNt=IFTxt.line(3);
		~tBsVel=IFTxt.line(4);
		~tBsSus=IFTxt.line(5);
		~tBsTm=IFTxt.line(6);
		~tBsDur=IFTxt.line(7);
		~tBsShuf=IFTxt.line(8);
		~tBsLfo=IFTxt.line(9);
		~tBsEnv=IFTxt.line(10);

		this.storeVals;
	}
	*storeVals{//////
		"Store Bass Values from Txt to Patterns ".postln;
		//[ Bass ]
		IFSeqBass.stGrpSet    (
			~tBsAmp[0],~tBsAmp[1],~tBsAmp[2],~tBsAmp[3],
			~tBsAmp[4],~tBsAmp[5],~tBsAmp[6],~tBsAmp[7],
			~tBsAmp[8],~tBsAmp[9],~tBsAmp[10],~tBsAmp[11],
			~tBsAmp[12],~tBsAmp[13],~tBsAmp[14],~tBsAmp[15],
		);
		IFSeqOctBass.stGrpSet  (
			~tBsOct[0],~tBsOct[1],~tBsOct[2],~tBsOct[3],
			~tBsOct[4],~tBsOct[5],~tBsOct[6],~tBsOct[7],
			~tBsOct[8],~tBsOct[9],~tBsOct[10],~tBsOct[11],
			~tBsOct[12],~tBsOct[13],~tBsOct[14],~tBsOct[15],
		);
		IFSeqNtBass.stGrpSet  (
			~tBsNt[0],~tBsNt[1],~tBsNt[2],~tBsNt[3],
			~tBsNt[4],~tBsNt[5],~tBsNt[6],~tBsNt[7],
			~tBsNt[8],~tBsNt[9],~tBsNt[10],~tBsNt[11],
			~tBsNt[12],~tBsNt[13],~tBsNt[14],~tBsNt[15],
		);
		IFSeqVelBass.stGrpSet (
			~tBsVel[0],~tBsVel[1],~tBsVel[2],~tBsVel[3],
			~tBsVel[4],~tBsVel[5],~tBsVel[6],~tBsVel[7],
			~tBsVel[8],~tBsVel[9],~tBsVel[10],~tBsVel[11],
			~tBsVel[12],~tBsVel[13],~tBsVel[14],~tBsVel[15],
		);
		IFSeqSusBass.stGrpSet (
			~tBsSus[0],~tBsSus[1],~tBsSus[2],~tBsSus[3],
			~tBsSus[4],~tBsSus[5],~tBsSus[6],~tBsSus[7],
			~tBsSus[8],~tBsSus[9],~tBsSus[10],~tBsSus[11],
			~tBsSus[12],~tBsSus[13],~tBsSus[14],~tBsSus[15],
		);
		IFSeqTmBass.stGrpSet  (
			~tBsTm[0],~tBsTm[1],~tBsTm[2],~tBsTm[3],
			~tBsTm[4],~tBsTm[5],~tBsTm[6],~tBsTm[7],
			~tBsTm[8],~tBsTm[9],~tBsTm[10],~tBsTm[11],
			~tBsTm[12],~tBsTm[13],~tBsTm[14],~tBsTm[15],
		);
		IFSeqDurBass.stGrpSet (
			~tBsDur[0],~tBsDur[1],~tBsDur[2],~tBsDur[3],
			~tBsDur[4],~tBsDur[5],~tBsDur[6],~tBsDur[7],
			~tBsDur[8],~tBsDur[9],~tBsDur[10],~tBsDur[11],
			~tBsDur[12],~tBsDur[13],~tBsDur[14],~tBsDur[15],
		);
		IFShuf.setBass    (
			~tBsShuf[0],~tBsShuf[1],~tBsShuf[2],~tBsShuf[3],
			~tBsShuf[4],~tBsShuf[5],~tBsShuf[6],~tBsShuf[7],
			~tBsShuf[8],~tBsShuf[9],~tBsShuf[10],~tBsShuf[11],
			~tBsShuf[12],~tBsShuf[13],~tBsShuf[14],~tBsShuf[15],
		);
		IFLfo.setBass    (
			~tBsLfo[0],~tBsLfo[1],~tBsLfo[2],~tBsLfo[3],
			~tBsLfo[4],~tBsLfo[5],~tBsLfo[6],~tBsLfo[7],
			~tBsLfo[8],~tBsLfo[9],~tBsLfo[10],~tBsLfo[11],
			~tBsLfo[12],~tBsLfo[13],~tBsLfo[14],~tBsLfo[15],
		);
		IFGlobal.setBass  (
			~tBsEnv[0],~tBsEnv[1],~tBsEnv[2],~tBsEnv[3],
			~tBsEnv[4],~tBsEnv[5],~tBsEnv[6],~tBsEnv[7],
			~tBsEnv[8],~tBsEnv[9],~tBsEnv[10],~tBsEnv[11],
			~tBsEnv[12],~tBsEnv[13],~tBsEnv[14],~tBsEnv[15],
		);


	}//////
}