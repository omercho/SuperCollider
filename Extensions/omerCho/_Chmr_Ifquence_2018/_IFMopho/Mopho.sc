/*

*/
Mopho{
	//var <>currentBpm;
	*load{
		~currentBpm=1;
		~currentBpmDiv=1;
		this.resetCnts;
		this.loadLabelLists;
		this.makeOSCResponders;
	}
	*nrp{|param1,nrpn,param2,vel|
		var chan;
		chan=~chMopho;
		~vMopho.control(chan, 99, param1);// first, set parameter number
		~vMopho.control(chan, 98, nrpn);//   most significant byte for parameter number
		~vMopho.control(chan, 6, param2);//  least significant byte for parameter number
		~vMopho.control(chan,38, vel);//     then set value
	}
	*lbl{|key,val| var chan; ~tOSCAdrr.sendMsg(key, val);}
	*loadLabelLists{
		~onOffLst = [0,1];
		~oscShapeLst = [\OFF, \SAW, \TRI, \SAW_TRI];
		~keyModeLst = [\LowNote, \LowNtRT, \LowNtRT, \HighNtRT, \LastNt, \LastNtRT];
		~glideModeLst = [\FixedRate, \FixRtAuto, \FixedTime, \FixTmAuto];
		~tempoDivLst = [\Half,\Quarter,\FixTm,\d8Note,\d8NtHlfSwng,\d8NtFllSwng,\d8NtTrplt,\d16Note,\d16NtHlfSwng,\d16NtFllSwng,\d16NtTrplt,\d32Nt,\d32NtTrplt,\d64NtTrplt];
		~destLst = [\OFF,\OSC1Note,\Osc2Note,\Osc1n2Note,\OscMix,\NoiseLev,\Osc1Pulse,\Osc2Pulse,\Osc1n2Pulse,\FiltFreq,\FiltRes,\FiltAudMod,\VCALev,\PanSpread,\LFO1Freq,\LFO2Freq,\LFO3Freq,\LFO4Freq,\AllLFOFreq,\LFO1Amnt,\LFO2Amnt,\LFO3Amnt,\LFO4Amnt,\AllLFOAmnt,\FiltEnvAmnt,\VCAEnvAmnt,\Env3Amnt,\AllEnvAmnt,\Env1Att,\Env2Att,\Env3Att,\AllEnvAtt,\Env1Dec,\Env2Dec,\Env3Dec,\AllEnvDec,\Env1Rls,\Env2Rls,\Env3Rls,\AllEnvRls,\Mod1Amnt,\Mod2Amnt,\Mod3Amnt,\Mod4Amnt,\ExtAudIn,\Sub1Lev,\Sub2Lev];
		~syncFreqLst = [\div32,\div16,\div8,\div6,\div4,\div3,\div2,\div1nHalf,\cyc1stp1,\cyc2stp3,\cyc2stp1,\cyc3stp1,\cyc4stp1,\cyc6stp1,\cyc8stp1,\cyc16stp1];
		~lfoShapeLst = [\Tringl,\RevSAW,\SAW,\SQR,\RAND];
		~srcLst = [\OFF,\Seq1,\Seq2,\Seq3,\Seq4,\LFO1,\LFO2,\LFO3,\LFO4,\FiltEnv,\AmpEnv,\Env3,\PitchBend,\ModWheel,\Pressure,\MIDIBreath,\MIDIFoot,\MIDIExp,\Velocity,\NoteNumber,\Noise,\AudInEnvFollow,\AudInPeakHold];
		~arpKndLst=[\UP,\DOWN,\UpDown,\ASSIGN];
		~seqTrigLst=[\NORMAL,\NrmNoRest,\NoGate,\NoGtNoRst,\KeyStep,\AudioIn];
	}
	*cc{|key,vel|
		var ch,val,direct,valFreq, valTune;
		ch=~chMopho;
		val=vel/127;

		valFreq= vel/120;
		valTune= vel/100;
		key.switch(
			\globalTranspose,{this.nrp( 3, 0, 0, vel);}, //0-24 -- 0=-12 -- 12=0 -- 24=+12
			\globalTune, {this.nrp( 3, 1, 0, vel);}, //0-100 -- 0=-50 -- 50=0 -- 100=+50
			\mdClock, {this.nrp( 3, 4, 0, vel);},/*0-3*/
			\parameterSend,{this.nrp( 3,6,0, vel);},/*0-2-- 0= NRPN-- 1= CC-- 2= Off*/
			\parameterReceive,{this.nrp( 3,7,0, vel);},/*0-3 -- 0= All -- 1= NRPN -- 2= CC -- 3= Off*/
			\controllerSendReceive,{this.nrp( 3,10,0, vel); /*0-1 Off On*/},
			\sysexSendReceive,{ this.nrp( 3,11,0, vel);},/*0-1 Off On*/
			\audioOut,{this.nrp( 3,21,0, vel);},/*0-2 -- 0= Stereo -- 1= Mono*/
			\midiOut,{this.nrp( 3,22,0, vel);}, /*0-2 -- 0= Out -- 1= Thru*/
			/////////////////////
			//Program Parameters
			\voiVol, {this.nrp( 0,29,0, vel);this.lbl(\MPHvoiVol,val);},/*0->127  Voice Volume*/
			\tempoBpmA, {this.nrp( 0,91,0, vel);},/*30->127  tempo 30-127*/
			\tempoBpmB, {this.nrp( 0,91,1, vel);},/*0->122  tempo 128-250*/
			\tempoDiv, {this.nrp( 0,92,0, vel);this.lbl(\tempoDivLbl,1+~tempoDivLst[vel]);},/*0->12* ~currentBpmDiv=vel;*/
			\tempoDivPls, {this.nrp( 0,92,0, vel);},/*0->12  tempo 30-250*/
			\tempoDivMin, {this.nrp( 0,92,0, vel);},/*0->12  tempo 30-250*/

			//OSCULATORS
			\osc1Freq, {this.nrp( 0, 0, 0, vel);this.lbl(\MPHosc1Freq,valFreq);}, //Osc_1 Freq
			\osc1Tune, {this.nrp( 0, 1, 0, vel);this.lbl(\MPHosc1Tune,valTune);}, //Osc_1 Tune
			\osc1Shape, {this.nrp( 0, 2, 0, vel);this.lbl(\MPHosc1Shape,val);}, //Osc_1 Shape
			\osc1ShBut,{
				if ( (vel)==4, {~osc1ShButCnt=0;vel=0;},{~osc1ShButCnt=~osc1ShButCnt});
				this.nrp( 0,2,0, vel); this.lbl(\osc1ShButLbl,1+~oscShapeLst[vel]);~osc1ShButCnt=vel+1;
			},//Osc_1 Shape Button
			\osc1Glide, {this.nrp( 0, 3, 0, vel);this.lbl(\MPHosc1Glide,val);}, //Osc_1 Glide
			//\osc1Kybrd, {this.nrp( 0, 4, 0, vel); this.lbl(\MPHosc1Kybrd,val);}, //Osc_1 Kybrd OnOff 0-1
			\osc1Kybrd,{this.nrp(0,4,0, vel-1);  this.lbl(\MPHosc1Kybrd,vel-1);}, /*0->1 Osc_1 Kybrd OnOff 0-1*/
			\osc1Sub, {this.nrp( 0, 114, 0, vel);this.lbl(\MPHosc1Sub,val);}, //Osc_1 Sub

			\osc2Freq, {this.nrp( 0, 5, 0, vel);this.lbl(\MPHosc2Freq,valFreq);}, //Osc_2 Freq
			\osc2Tune, {this.nrp( 0, 6, 0, vel);this.lbl(\MPHosc2Tune,valTune);}, //Osc_2 Tune
			\osc2Shape, {this.nrp( 0, 7, 0, vel);this.lbl(\MPHosc2Shape,val);}, //Osc_2 Shape
			\osc2ShBut,{
				if ( (vel)==4, {~osc2ShButCnt=0;vel=0;},{~osc2ShButCnt=~osc2ShButCnt});
				this.nrp( 0,7,0, vel); this.lbl(\osc2ShButLbl,1+~oscShapeLst[vel]);
				~osc2ShButCnt=vel+1;
			},
			\osc2Glide, {this.nrp( 0, 8, 0, vel);this.lbl(\MPHosc2Glide,val);}, //Osc_2 Glide
			//\osc2Kybrd, {this.nrp( 0, 9, 0, vel);this.lbl(\MPHosc2Kybrd,val);}, //Osc_2 Kybrd OnOff 0-1
			\osc2Kybrd,{this.nrp(0,9,0, vel-1);  this.lbl(\MPHosc2Kybrd,vel-1);}, /*0->1 Osc_2 Kybrd OnOff 0-1*/
			\osc2Sub, {this.nrp( 0, 115, 0, vel);this.lbl(\MPHosc2Sub,val);}, //Osc_2 Sub

			\oscMix, {this.nrp( 0, 13, 0, vel);this.lbl(\MPHoscMix,val);}, //0->127
			\extIn, {this.nrp( 0, 116, 0, vel);this.lbl(\MPHextIn,val);}, //0->127
			\noise, {this.nrp( 0, 14, 0, vel);this.lbl(\MPHnoise,val);}, //0->127
			\oscSync, {this.nrp( 0, 10, 0, vel); this.lbl(\MPHoscSync,val);}, /*0->1 Sync osc2->osc1 OnOff*/
			\oscSlop, {this.nrp( 0, 12, 0, vel);this.lbl(\MPHoscSlop,val);}, //0->5
			\keyMode,{
				if ( (vel)==6, {~keyModeCnt=0;vel=0;},{~keyModeCnt=~keyModeCnt});
				this.nrp( 0,96,0, vel); this.lbl(\keyModeLbl,1+~keyModeLst[vel]);
				~keyModeCnt=vel+1;
			},
			\glideMode,{
				if ( (vel)==4, {~glideModeCnt=0;vel=0;},{~glideModeCnt=~glideModeCnt});
				this.nrp( 0,11,0, vel); this.lbl(\glideModeLbl,1+~glideModeLst[vel]);
				~glideModeCnt=vel+1;
			},
			//LOW PASS Filter
			//\lpfFreq, {this.nrp( 0, 15, 0, vel);this.lbl(\MPHlpfFreq,val);},/*0->164  Filter Frequency, steps in semitones*/
			\lpfFreq,{
				this.lbl(\MPHlpfFreq, vel);
				case
				{vel<=127} {this.nrp( 0,15,0, vel);}
				{vel>128} {this.nrp( 0,15,1, vel-127);};
			},
			\lpfRes, {this.nrp( 0, 16, 0, vel);this.lbl(\MPHlpfRes,val);}, /*0->127  Filter Resonance*/
			\lpfAmnt,{this.nrp( 0,20,1, vel);this.lbl(\MPHlpfAmnt,val);},/*0->254  Filter Envelope Amount -127 to +127*/
			\lpfVel,{this.nrp( 0,21,0, vel);this.lbl(\MPHlpfVel,val);}, /*0->127  Filter Envelope Velocity*/
			\lpfKeyAmnt, {this.nrp( 0, 17, 0, vel);this.lbl(\MPHlpfKeyAmnt,val);}, /*0->127  Filter Keyboard Amount*/
			\lpfAudMod, {this.nrp( 0, 18, 0, vel);this.lbl(\MPHlpfAudMode,val);}, /*0->127  Filter Audio Modulation*/
			\lpfPole,{this.nrp( 0,19,0, vel);this.lbl(\MPHlpfPole,val);}, /*0->1  Filter Poles 0=2pole 1=4pole*/
			\lpfEnvDel,{this.nrp( 0,22,0, vel);this.lbl(\MPHlpfEnvDel,val);}, /*0->127  Filter Envelope delay*/
			\lpfEnvAtt,{this.nrp( 0,23,0, vel);this.lbl(\MPHlpfEnvAtt,val);}, /*0->127  Filter Envelope att*/
			\lpfEnvDec,{this.nrp( 0,24,0, vel);this.lbl(\MPHlpfEnvDec,val);}, /*0->127  Filter Envelope dec*/
			\lpfEnvSus,{this.nrp( 0,25,0, vel);this.lbl(\MPHlpfEnvSus,val);}, /*0->127  Filter Envelope sus*/
			\lpfEnvRls,{this.nrp( 0,26,0, vel);this.lbl(\MPHlpfEnvRls,val);}, /*0->127  Filter Envelope rls*/
			//VCA
			\vcaLvl, {this.nrp( 0,27,0, vel);this.lbl(\MPHvcaLvl,val);},/*0->127  VCA Initial Level*/
			\vcaAmnt,{this.nrp( 0,30,1, vel);this.lbl(\MPHvcaAmnt,val);},/*0->254  VCA Envelope Amount -127 to +127*/
			\vcaVel, {this.nrp( 0,31,0, vel);this.lbl(\MPHvcaVel,val);}, /*0->127  VCA Envelope Velocity*/
			\vcaEnvDel,{this.nrp( 0,32,0, vel);this.lbl(\MPHvcaEnvDel,val);}, /*0->127  VCA Envelope delay*/
			\vcaEnvAtt,{this.nrp( 0,33,0, vel);this.lbl(\MPHvcaEnvAtt,val);}, /*0->127  VCA Envelope att*/
			\vcaEnvDec,{this.nrp( 0,34,0, vel);this.lbl(\MPHvcaEnvDec,val);}, /*0->127  VCA Envelope dec*/
			\vcaEnvSus,{this.nrp( 0,35,0, vel);this.lbl(\MPHvcaEnvSus,val);}, /*0->127  VCA Envelope sus*/
			\vcaEnvRls,{this.nrp( 0,36,0, vel);this.lbl(\MPHvcaEnvRls,val);}, /*0->127  VCA Envelope rls*/
			//LFO 1
			\lfo1Amnt,   {this.nrp(0,39,0, vel);this.lbl(\MPHlfo1Amnt,val);},/*0->127 */
			\lfo1Freq,   {this.nrp(0,37,0, vel);this.lbl(\MPHlfo1Freq,val)},/*0->166  LFO1 Freq // 0-150 unsynced freqs*/
			\lfo1Dest,   {
				this.nrp(0,40,0, vel);this.lbl(\lfo1DestLbl,1+~destLst[vel]);
				if (~lfo1DestCnt>46, {~lfo1DestCnt=0;});if (~lfo1DestCnt<0, {~lfo1DestCnt=46;});
			},
			\lfo1SFreq,   {
				this.nrp(0,37,1, vel+23);this.lbl(\lfo1SFreqLbl,~syncFreqLst[vel]);
				if (~lfo1SFreqCnt>16, {~lfo1SFreqCnt=0;});if (~lfo1SFreqCnt<0, {~lfo1SFreqCnt=16;});
			},
			\lfo1Shape,  {this.nrp(0,38,0, vel);    this.lbl(\lfo1ShapeLbl,~lfoShapeLst[vel]);},/**/
			\lfo1KeySync,{this.nrp(0,41,0, vel-1);  this.lbl(\MPHlfo1KeySync,vel-1);}, /*0->1 osc2->osc1 */
			//LFO 2
			\lfo2Amnt,   {this.nrp(0,44,0, vel);this.lbl(\MPHlfo2Amnt,val);},
			\lfo2Freq,   {this.nrp(0,42,0, vel);this.lbl(\MPHlfo2Freq,val);},
			\lfo2Dest,   {
				this.nrp(0,45,0, vel);this.lbl(\lfo2DestLbl,1+~destLst[vel]);
				if (~lfo2DestCnt>46, {~lfo2DestCnt=0;});if (~lfo2DestCnt<0, {~lfo2DestCnt=46;});
			},
			\lfo2SFreq,   {
				this.nrp(0,42,1, vel+23);this.lbl(\lfo2SFreqLbl,~syncFreqLst[vel]);
				if (~lfo2SFreqCnt>16, {~lfo2SFreqCnt=0;});if (~lfo2SFreqCnt<0, {~lfo2SFreqCnt=16;});
			},
			\lfo2Shape,  {this.nrp(0,43,0, vel);this.lbl(\lfo2ShapeLbl,~lfoShapeLst[vel]);},
			\lfo2KeySync,{this.nrp(0,46,0, vel-1); this.lbl(\MPHlfo2KeySync,vel-1);},
			//LFO 3
			\lfo3Amnt,   {this.nrp(0,49,0, vel);this.lbl(\MPHlfo3Amnt,val);},
			\lfo3Freq,   {this.nrp(0,47,0, vel);this.lbl(\MPHlfo3Freq,val);},
			\lfo3Dest,   {
				this.nrp(0,50,0, vel);this.lbl(\lfo3DestLbl,1+~destLst[vel]);
				if (~lfo3DestCnt>46, {~lfo3DestCnt=0;});if (~lfo3DestCnt<0, {~lfo3DestCnt=46;});
			},
			\lfo3SFreq,   {
				this.nrp(0,47,1, vel+23);this.lbl(\lfo3SFreqLbl,~syncFreqLst[vel]);
				if (~lfo3SFreqCnt>16, {~lfo3SFreqCnt=0;});if (~lfo3SFreqCnt<0, {~lfo3SFreqCnt=16;});
			},
			\lfo3Shape,  {this.nrp(0,48,0, vel);    this.lbl(\lfo3ShapeLbl,~lfoShapeLst[vel]);},
			\lfo3KeySync,{this.nrp(0,51,0, vel-1);    this.lbl(\MPHlfo3KeySync,vel-1);},
			//LFO 4
			\lfo4Amnt,   {this.nrp(0,54,0, vel);this.lbl(\MPHlfo4Amnt,val);},
			\lfo4Freq,   {this.nrp(0,52,0, vel);this.lbl(\MPHlfo4Freq,val);},
			\lfo4Dest,   {
				this.nrp(0,55,0, vel);this.lbl(\lfo4DestLbl,1+~destLst[vel]);
				if (~lfo4DestCnt>46, {~lfo4DestCnt=0;});if (~lfo4DestCnt<0, {~lfo4DestCnt=46;});
			},
			\lfo4SFreq,   {
				this.nrp(0,52,1, vel+23);this.lbl(\lfo4SFreqLbl,~syncFreqLst[vel]);
				if (~lfo4SFreqCnt>16, {~lfo4SFreqCnt=0;});if (~lfo4SFreqCnt<0, {~lfo4SFreqCnt=16;});
			},
			\lfo4Shape,  {this.nrp(0,53,0, vel);    this.lbl(\lfo4ShapeLbl,~lfoShapeLst[vel]);},
			\lfo4KeySync,{this.nrp(0,56,0, vel-1);    this.lbl(\MPHlfo4KeySync,vel-1);},
			//Env3
			\env3Dest,   {
				this.nrp(0,57,0, vel);this.lbl(\env3DestLbl,1+~destLst[vel]);
				if (~env3DestCnt>46, {~env3DestCnt=0;});if (~env3DestCnt<0, {~env3DestCnt=46;});
			},
			\env3Amnt,{
				this.lbl('MPHenv3Amnt', vel);
				case
				{vel<=127} {this.nrp( 0,58,0, vel);}
				{vel>128} {this.nrp( 0,58,1, vel-127);};
			},
			\env3Vel,{this.nrp( 0,59,0, vel);this.lbl(\MPHenv3Vel,val);}, /*0->127  VCA Envelope Velocity*/
			\env3Del,{this.nrp( 0,60,0, vel);this.lbl(\MPHenv3Del,val);}, /*0->127  VCA Envelope delay*/
			\env3Att,{this.nrp( 0,61,0, vel);this.lbl(\MPHenv3Att,val);}, /*0->127  VCA Envelope att*/
			\env3Dec,{this.nrp( 0,62,0, vel);this.lbl(\MPHenv3Dec,val);}, /*0->127  VCA Envelope dec*/
			\env3Sus,{this.nrp( 0,63,0, vel);this.lbl(\MPHenv3Sus,val);}, /*0->127  VCA Envelope sus*/
			\env3Rls,{this.nrp( 0,64,0, vel);this.lbl(\MPHenv3Rls,val);}, /*0->127  VCA Envelope rls*/
			\env3Rpt,{this.nrp( 0,98,0, vel);this.lbl(\MPHenv3Rpt,val);}, /*0->1 Repeat->Env3 OnOff*/
			//MODS
			\mod1Src,   {
				this.nrp(0,65,0, vel);this.lbl(\mod1SrcLbl,1+~srcLst[vel]);
				if (~mod1SrcCnt>22, {~mod1SrcCnt=0;});if (~mod1SrcCnt<0, {~mod1SrcCnt=22;});
			},
			\mod1Amnt,{
				this.lbl('MPHmod1Amnt', vel);
				case
				{vel<=127} {this.nrp( 0,66,0, vel);}
				{vel>128} {this.nrp( 0,66,1, vel-127);};
			},
			\mod1Dest,   {
				this.nrp(0,67,0, vel);this.lbl(\mod1DestLbl,1+~destLst[vel]);
				if (~mod1DestCnt>46, {~mod1DestCnt=0;});if (~mod1DestCnt<0, {~mod1DestCnt=46;});
			},
			//mod2
			\mod2Src,   {
				this.nrp(0,68,0, vel);this.lbl(\mod2SrcLbl,1+~srcLst[vel]);
				if (~mod2SrcCnt>22, {~mod2SrcCnt=0;});if (~mod2SrcCnt<0, {~mod2SrcCnt=22;});
			},
			\mod2Amnt,{
				this.lbl('MPHmod2Amnt', vel);
				case
				{vel<=127} {this.nrp( 0,69,0, vel);}
				{val>128} {this.nrp( 0,69,1, vel-127);};
			},
			\mod2Dest,   {
				this.nrp(0,70,0, vel);this.lbl(\mod2DestLbl,1+~destLst[vel]);
				if (~mod2DestCnt>46, {~mod2DestCnt=0;});if (~mod2DestCnt<0, {~mod2DestCnt=46;});
			},
			//mod3
			\mod3Src,   {
				this.nrp(0,71,0, vel);this.lbl(\mod3SrcLbl,1+~srcLst[vel]);
				if (~mod3SrcCnt>22, {~mod3SrcCnt=0;});if (~mod3SrcCnt<0, {~mod3SrcCnt=22;});
			},
			\mod3Amnt,{
				this.lbl('MPHmod3Amnt', vel);
				case
				{vel<=127} {this.nrp( 0,72,0, vel);}
				{val>128} {this.nrp( 0,72,1, vel-127);};
			},
			\mod3Dest,   {
				this.nrp(0,73,0, vel);this.lbl(\mod3DestLbl,1+~destLst[vel]);
				if (~mod3DestCnt>46, {~mod3DestCnt=0;});if (~mod3DestCnt<0, {~mod3DestCnt=46;});
			},
			//mod4
			\mod4Src,   {
				this.nrp(0,74,0, vel);this.lbl(\mod4SrcLbl,1+~srcLst[vel]);
				if (~mod4SrcCnt>22, {~mod4SrcCnt=0;});if (~mod4SrcCnt<0, {~mod4SrcCnt=22;});
			},
			\mod4Amnt,{
				this.lbl('MPHmod4Amnt', vel);
				case
				{vel<=127} {this.nrp( 0,75,0, vel);}
				{val>128} {this.nrp( 0,75,1, vel-127);};
			},
			\mod4Dest,   {
				this.nrp(0,76,0, vel);this.lbl(\mod4DestLbl,1+~destLst[vel]);
				if (~mod4DestCnt>46, {~mod4DestCnt=0;});if (~mod4DestCnt<0, {~mod4DestCnt=46;});
			},
			\arpOn,{this.nrp(0,100,0, vel-1);  this.lbl(\MPHarpOn,vel-1);}, /*0->1*/
			\arpKnd,  {this.nrp(0,97,0, vel);    this.lbl(\arpKndLbl,~arpKndLst[vel]);},/**/
			\seqOn,{this.nrp(0,101,0, vel-1);  this.lbl(\MPHseqOn,vel-1);}, /*0->1 */
			\seqTrig,  {this.nrp(0,94,0, vel);    this.lbl(\seqTrigLbl,~seqTrigLst[vel]);},/**/

		);
	}
	*oscResp{|respName,oscName,playDir|
		var currentBpm=1;
		OSCdef(respName, {|msg|
			var val,vel, velFreq, velTune;
			val=msg[1];
			vel=val*127;
			velFreq= val*120;
			velTune= val*100;
			playDir.switch(
				'voiVolT',{ Mopho.cc(\voiVol,vel);},
				'tempoBpmMinT',{if( val==1,{~currentBpm=~currentBpm-1;~local.sendMsg(\MPHtempoBpm,~currentBpm);});},
				'tempoBpmPlsT',{if( val==1,{~currentBpm=~currentBpm+1;~local.sendMsg(\MPHtempoBpm,~currentBpm);});},
				'tempoBpmT',{
					case
					{msg[1]<=127} {"Tempo A".postln; Mopho.cc(\tempoBpmA, val);}
					{msg[1]>=128} {"Tempo B".postln; Mopho.cc(\tempoBpmB, val-128);};
					~tOSCAdrr.sendMsg('MPHtempoBpmLbl', val);
					~tOSCAdrr.sendMsg('MPHtempoBpm', val);
					~currentBpm=val;
				},
				'tempoDivT',{
					~tempoDivTag=val;
					~tempoDivTag.postln;
					~currentBpmDiv.postln;
					case
					{~currentBpmDiv>11}{~currentBpmDiv=0}
					{~currentBpmDiv<0}{~currentBpmDiv=12};
					~tempoDivTag.switch(
						0,{Mopho.cc(\tempoDiv,0);},1,{Mopho.cc(\tempoDiv,1);},2,{Mopho.cc(\tempoDiv,2);},
						3,{Mopho.cc(\tempoDiv,3);},4,{Mopho.cc(\tempoDiv,4);},5,{Mopho.cc(\tempoDiv,5);},
						6,{Mopho.cc(\tempoDiv,6);},7,{Mopho.cc(\tempoDiv,7);},8,{Mopho.cc(\tempoDiv,8);},
						9,{Mopho.cc(\tempoDiv,9);},10,{Mopho.cc(\tempoDiv,10);},11,{Mopho.cc(\tempoDiv,11);},
						12,{Mopho.cc(\tempoDiv,12);}
					);
				},
				/*'tempoDivT',{
					~tempoDivTag=val;
					~tempoDivTag.postln;
					~currentBpmDiv.postln;
					case
					{~currentBpmDiv>11}{~currentBpmDiv=0}
					{~currentBpmDiv<0}{~currentBpmDiv=12};
					~tempoDivTag.switch(~tempoDivTag,{Mopho.cc(\tempoDiv,~tempoDivTag);});
				},*/
				'tempoDivMinT',{
					if ( val==1, {
						~currentBpmDiv=~currentBpmDiv-1;
						~local.sendMsg(\MPHtempoDiv,~currentBpmDiv);
					});
				},
				'tempoDivPlsT',{
					if ( val==1, {
						~currentBpmDiv=~currentBpmDiv+1;
						~local.sendMsg(\MPHtempoDiv,~currentBpmDiv);
					});
				},
				'osc1FreqT',{ Mopho.cc(\osc1Freq,velFreq);},
				'osc1TuneT',{ Mopho.cc(\osc1Tune,velTune);},
				'osc1ShapeT',{ Mopho.cc(\osc1Shape,vel);},
				'osc1ShButT',{
					if ( msg[1]==1, {
						~osc1ShButCnt = ~osc1ShButCnt + 1;
						~osc1ShButCnt.switch(~osc1ShButCnt,{Mopho.cc(\osc1ShBut,~osc1ShButCnt-1);});
					});
				},
				'osc1GlideT',{ Mopho.cc(\osc1Glide,vel);},
				'osc1KybrdT',{
					if ( msg[1]==1, {
						~osc1KybrdCnt = ~osc1KybrdCnt + 1;
						~osc1KybrdCnt.switch(~osc1KybrdCnt,{Mopho.cc(\osc1Kybrd,~osc1KybrdCnt);});
						if (~osc1KybrdCnt==2, {~osc1KybrdCnt=0;});
					});
				},
				'osc1SubT',{ Mopho.cc(\osc1Sub,vel);},

				'osc2FreqT',{ Mopho.cc(\osc2Freq,velFreq);},
				'osc2TuneT',{ Mopho.cc(\osc2Tune,velTune);},
				'osc2ShapeT',{ Mopho.cc(\osc2Shape,vel);},
				'osc2ShButT',{
					if ( msg[1]==1, {
						~osc2ShButCnt = ~osc2ShButCnt + 1;
						~osc2ShButCnt.switch(~osc2ShButCnt,{Mopho.cc(\osc2ShBut,~osc2ShButCnt-1);});
					});
				},
				'osc2GlideT',{ Mopho.cc(\osc2Glide,vel);},
				'osc2KybrdT',{
					if ( msg[1]==1, {
						~osc2KybrdCnt = ~osc2KybrdCnt + 1;
						~osc2KybrdCnt.switch(~osc2KybrdCnt,{Mopho.cc(\osc2Kybrd,~osc2KybrdCnt);});
						if (~osc2KybrdCnt==2, {~osc2KybrdCnt=0;});
					});
				},
				'osc2SubT',{ Mopho.cc(\osc2Sub,vel);},

				'oscMixT',{ Mopho.cc(\oscMix,vel);},
				'oscSlopT',{ Mopho.cc(\oscSlop,val);},
				'extInT',{ Mopho.cc(\extIn,vel);},
				'noiseT',{ Mopho.cc(\noise,vel);},
				'oscSyncT',{
					if ( msg[1]==1, {
						~oscSyncCnt = ~oscSyncCnt + 1;
						~oscSyncCnt.switch(1,{Mopho.cc(\oscSync,0);},2,{Mopho.cc(\oscSync,1);~oscSyncCnt=0;});
					});
				},
				'keyModeT',{
					if ( msg[1]==1, {
						~keyModeCnt = ~keyModeCnt + 1;
						~keyModeCnt.switch(~keyModeCnt,{Mopho.cc(\keyMode,~keyModeCnt-1);});
					});
				},
				'glideModeT',{
					if ( msg[1]==1, {
						~glideModeCnt = ~glideModeCnt + 1;
						~glideModeCnt.switch(~glideModeCnt,{Mopho.cc(\glideMode,~glideModeCnt-1);});
					});
				},
				'lpfFreqT',{ Mopho.cc(\lpfFreq,val);},
				'lpfResT',{ Mopho.cc(\lpfRes,vel); },
				'lpfAmntT',{ Mopho.cc(\lpfAmnt,vel); },
				'lpfVelT',{ Mopho.cc(\lpfVel,vel); },
				'lpfKeyAmntT',{ Mopho.cc(\lpfKeyAmnt,vel); },
				'lpfAudModT',{ Mopho.cc(\lpfAudMod,vel); },
				'lpfPoleT',{
					if ( val==1, {
						~lpfPoleCnt = ~lpfPoleCnt + 1;
						~lpfPoleCnt.switch(1,{Mopho.cc(\lpfPole,0);},2,{Mopho.cc(\lpfPole,1);~lpfPoleCnt=0;});
					});
				},
				/*'lpfPoleT',{
					if ( msg[1]==1, {
						"lpfPole TRIG".postln;
						("before mul:"+~lpfPoleCnt).postln;
						~lpfPoleCnt = ~lpfPoleCnt + 1;
						("after mul:"+~lpfPoleCnt).postln;
						~lpfPoleCnt.switch(
							~lpfPoleCnt,{Mopho.cc(\lpfPole,~lpfPoleCnt);("in the switch:"+~lpfPoleCnt).postln;}
						);
						if (~lpfPoleCnt==2, {~lpfPoleCnt=0;("in th reset:"+~lpfPoleCnt).postln;});
					});
				},*/
				'lpfEnvDelT',{ Mopho.cc(\lpfEnvDel,vel);},
				'lpfEnvAttT',{ Mopho.cc(\lpfEnvAtt,vel);},
				'lpfEnvDecT',{ Mopho.cc(\lpfEnvDec,vel);},
				'lpfEnvSusT',{ Mopho.cc(\lpfEnvSus,vel);},
				'lpfEnvRlsT',{ Mopho.cc(\lpfEnvRls,vel);},
				//VCA
				'vcaLvlT',{ Mopho.cc(\vcaLvl,vel);},
				'vcaAmntT',{ Mopho.cc(\vcaAmnt,vel); },
				'vcaVelT',{ Mopho.cc(\vcaVel,vel);},
				'vcaEnvDelT',{ Mopho.cc(\vcaEnvDel,vel); },
				'vcaEnvAttT',{ Mopho.cc(\vcaEnvAtt,vel); },
				'vcaEnvDecT',{ Mopho.cc(\vcaEnvDec,vel);},
				'vcaEnvSusT',{ Mopho.cc(\vcaEnvSus,vel);},
				'vcaEnvRlsT',{ Mopho.cc(\vcaEnvRls,vel);},
				//LFO1
				'lfo1AmntT',{ Mopho.cc(\lfo1Amnt,vel);},
				'lfo1FreqT',{ Mopho.cc(\lfo1Freq,vel);},
				'lfo1DestT',{
					if ( msg[1]==1, {
						~lfo1DestCnt = ~lfo1DestCnt + 1;
						~lfo1DestCnt.switch(~lfo1DestCnt,{Mopho.cc(\lfo1Dest,~lfo1DestCnt-1);});
					});
				},
				'lfo1DestMT',{
					if ( msg[1]==1, {
						~lfo1DestCnt = (~lfo1DestCnt) - 1;
						~lfo1DestCnt.switch(~lfo1DestCnt,{Mopho.cc(\lfo1Dest,~lfo1DestCnt+1);});
					});
				},
				'lfo1SFreqT',{
					if ( msg[1]==1, {
						~lfo1SFreqCnt = ~lfo1SFreqCnt + 1;
						~lfo1SFreqCnt.switch(~lfo1SFreqCnt,{Mopho.cc(\lfo1SFreq,~lfo1SFreqCnt-1);});
					});
				},
				'lfo1SFreqMT',{
					if ( msg[1]==1, {
						~lfo1SFreqCnt = (~lfo1SFreqCnt) - 1;
						~lfo1SFreqCnt.switch(~lfo1SFreqCnt,{Mopho.cc(\lfo1SFreq,~lfo1SFreqCnt+1);});
					});
				},
				'lfo1ShapeT',{
					if ( msg[1]==1, {
						~lfo1ShapeCnt = ~lfo1ShapeCnt + 1;
						~lfo1ShapeCnt.switch(~lfo1ShapeCnt,{Mopho.cc(\lfo1Shape,~lfo1ShapeCnt);});
						if ( ~lfo1ShapeCnt==5, {~lfo1ShapeCnt=0;});
					});
				},
				'lfo1KeySyncT',{
					if ( msg[1]==1, {
						~lfo1KeySyncCnt = ~lfo1KeySyncCnt + 1;
						~lfo1KeySyncCnt.switch(~lfo1KeySyncCnt,{Mopho.cc(\lfo1KeySync,~lfo1KeySyncCnt);});
						if (~lfo1KeySyncCnt==2, {~lfo1KeySyncCnt=0;});
					});
				},
				//LFO 2
				'lfo2AmntT',{ Mopho.cc(\lfo2Amnt,vel);},
				'lfo2FreqT',{ Mopho.cc(\lfo2Freq,vel);},
				'lfo2DestT',{
					if ( msg[1]==1, {
						~lfo2DestCnt = ~lfo2DestCnt + 1;
						~lfo2DestCnt.switch(~lfo2DestCnt,{Mopho.cc(\lfo2Dest,~lfo2DestCnt-1);});
					});
				},
				'lfo2DestMT',{
					if ( msg[1]==1, {
						~lfo2DestCnt = ~lfo2DestCnt - 1;
						~lfo2DestCnt.switch(~lfo2DestCnt,{Mopho.cc(\lfo2Dest,~lfo2DestCnt+1);});
					});
				},
				'lfo2SFreqT',{
					if ( msg[1]==1, {
						~lfo2SFreqCnt = ~lfo2SFreqCnt + 1;
						~lfo2SFreqCnt.switch(~lfo2SFreqCnt,{Mopho.cc(\lfo2SFreq,~lfo2SFreqCnt-1);});
					});
				},
				'lfo2SFreqMT',{
					if ( msg[1]==1, {
						~lfo2SFreqCnt = (~lfo2SFreqCnt) - 1;
						~lfo2SFreqCnt.switch(~lfo2SFreqCnt,{Mopho.cc(\lfo2SFreq,~lfo2SFreqCnt+1);});
					});
				},
				'lfo2ShapeT',{
					if ( msg[1]==1, {
						~lfo2ShapeCnt = ~lfo2ShapeCnt + 1;
						~lfo2ShapeCnt.switch(~lfo2ShapeCnt,{Mopho.cc(\lfo2Shape,~lfo2ShapeCnt);});
						if ( ~lfo2ShapeCnt==5, {~lfo2ShapeCnt=0;});
					});
				},
				'lfo2KeySyncT',{
					if ( msg[1]==1, {
						~lfo2KeySyncCnt = ~lfo2KeySyncCnt + 1;
						~lfo2KeySyncCnt.switch(~lfo2KeySyncCnt,{Mopho.cc(\lfo2KeySync,~lfo2KeySyncCnt);});
						if (~lfo2KeySyncCnt==2, {~lfo2KeySyncCnt=0;});
					});
				},
				//LFO3
				'lfo3AmntT',{ Mopho.cc(\lfo3Amnt,vel);},
				'lfo3FreqT',{ Mopho.cc(\lfo3Freq,vel);},
				'lfo3DestT',{
					if ( msg[1]==1, {
						~lfo3DestCnt = ~lfo3DestCnt + 1;
						~lfo3DestCnt.switch(~lfo3DestCnt,{Mopho.cc(\lfo3Dest,~lfo3DestCnt-1);});
					});
				},
				'lfo3DestMT',{
					if ( msg[1]==1, {
						~lfo3DestCnt = (~lfo3DestCnt) - 1;
						~lfo3DestCnt.switch(~lfo3DestCnt,{Mopho.cc(\lfo3Dest,~lfo3DestCnt+1);});
					});
				},
				'lfo3SFreqT',{
					if ( msg[1]==1, {
						~lfo3SFreqCnt = ~lfo3SFreqCnt + 1;
						~lfo3SFreqCnt.switch(~lfo3SFreqCnt,{Mopho.cc(\lfo3SFreq,~lfo3SFreqCnt-1);});
					});
				},
				'lfo3SFreqMT',{
					if ( msg[1]==1, {
						~lfo3SFreqCnt = (~lfo3SFreqCnt) - 1;
						~lfo3SFreqCnt.switch(~lfo3SFreqCnt,{Mopho.cc(\lfo3SFreq,~lfo3SFreqCnt+1);});
					});
				},
				'lfo3ShapeT',{
					if ( msg[1]==1, {
						~lfo3ShapeCnt = ~lfo3ShapeCnt + 1;
						~lfo3ShapeCnt.switch(~lfo3ShapeCnt,{Mopho.cc(\lfo3Shape,~lfo3ShapeCnt);});
						if ( ~lfo3ShapeCnt==5, {~lfo3ShapeCnt=0;});
					});
				},
				'lfo3KeySyncT',{
					if ( msg[1]==1, {
						~lfo3KeySyncCnt = ~lfo3KeySyncCnt + 1;
						~lfo3KeySyncCnt.switch(~lfo3KeySyncCnt,{Mopho.cc(\lfo3KeySync,~lfo3KeySyncCnt);});
						if (~lfo3KeySyncCnt==2, {~lfo3KeySyncCnt=0;});
					});
				},
				//LFO4
				'lfo4AmntT',{ Mopho.cc(\lfo4Amnt,vel);},
				'lfo4FreqT',{ Mopho.cc(\lfo4Freq,vel);},
				'lfo4DestT',{
					if ( msg[1]==1, {
						~lfo4DestCnt = ~lfo4DestCnt + 1;
						~lfo4DestCnt.switch(~lfo4DestCnt,{Mopho.cc(\lfo4Dest,~lfo4DestCnt-1);});
					});
				},
				'lfo4DestMT',{
					if ( msg[1]==1, {
						~lfo4DestCnt = (~lfo4DestCnt) - 1;
						~lfo4DestCnt.switch(~lfo4DestCnt,{Mopho.cc(\lfo4Dest,~lfo4DestCnt+1);});
					});
				},
				'lfo4SFreqT',{
					if ( msg[1]==1, {
						~lfo4SFreqCnt = ~lfo4SFreqCnt + 1;
						~lfo4SFreqCnt.switch(~lfo4SFreqCnt,{Mopho.cc(\lfo4SFreq,~lfo4SFreqCnt-1);});
					});
				},
				'lfo4SFreqMT',{
					if ( msg[1]==1, {
						~lfo4SFreqCnt = (~lfo4SFreqCnt) - 1;
						~lfo4SFreqCnt.switch(~lfo4SFreqCnt,{Mopho.cc(\lfo4SFreq,~lfo4SFreqCnt+1);});
					});
				},
				'lfo4ShapeT',{
					if ( msg[1]==1, {
						~lfo4ShapeCnt = ~lfo4ShapeCnt + 1;
						~lfo4ShapeCnt.switch(~lfo4ShapeCnt,{Mopho.cc(\lfo4Shape,~lfo4ShapeCnt);});
						if ( ~lfo4ShapeCnt==5, {~lfo4ShapeCnt=0;});
					});
				},
				'lfo4KeySyncT',{
					if ( msg[1]==1, {
						~lfo4KeySyncCnt = ~lfo4KeySyncCnt + 1;
						~lfo4KeySyncCnt.switch(~lfo4KeySyncCnt,{Mopho.cc(\lfo4KeySync,~lfo4KeySyncCnt);});
						if (~lfo4KeySyncCnt==2, {~lfo4KeySyncCnt=0;});
					});
				},
				//Env3
				'env3DestT',{
					if ( msg[1]==1, {
						~env3DestCnt = ~env3DestCnt + 1;
						~env3DestCnt.switch(~env3DestCnt,{Mopho.cc(\env3Dest,~env3DestCnt-1);});
					});
				},
				'env3DestMT',{
					if ( msg[1]==1, {
						~env3DestCnt = (~env3DestCnt) - 1;
						~env3DestCnt.switch(~env3DestCnt,{Mopho.cc(\env3Dest,~env3DestCnt+1);});
					});
				},
				'env3AmntT',{Mopho.cc(\env3Amnt, val);},
				'env3VelT',{ Mopho.cc(\env3Vel,vel);},
				'env3EnvDelT',{ Mopho.cc(\env3EnvDel,vel);},
				'env3EnvAttT',{ Mopho.cc(\env3EnvAtt,vel);},
				'env3EnvDecT',{ Mopho.cc(\env3EnvDec,vel);},
				'env3EnvSusT',{ Mopho.cc(\env3EnvSus,vel);},
				'env3EnvRlsT',{ Mopho.cc(\env3EnvRls,vel);},
				'env3RptT',{
					if ( msg[1]==1, {
						~env3RptCnt = ~env3RptCnt + 1;
						~env3RptCnt.switch(
							0,{},
							1,{Mopho.cc(\env3Rpt,0); },
							2,{Mopho.cc(\env3Rpt,1);~env3RptCnt=0;},
						);
					});
				},
				//MOD1
				'mod1AmntT',{Mopho.cc(\mod1Amnt, val);},
				'mod1SrcT',{
					if ( msg[1]==1, {
						~mod1SrcCnt = ~mod1SrcCnt + 1;
						~mod1SrcCnt.switch(~mod1SrcCnt,{Mopho.cc(\mod1Src,~mod1SrcCnt-1);});
					});
				},
				'mod1SrcMT',{
					if ( msg[1]==1, {
						~mod1SrcCnt = (~mod1SrcCnt) - 1;
						~mod1SrcCnt.switch(~mod1SrcCnt,{Mopho.cc(\mod1Src,~mod1SrcCnt+1);});
					});
				},
				'mod1DestT',{
					if ( msg[1]==1, {
						~mod1DestCnt = ~mod1DestCnt + 1;
						~mod1DestCnt.switch(~mod1DestCnt,{Mopho.cc(\mod1Dest,~mod1DestCnt-1);});
					});
				},
				'mod1DestMT',{
					if ( msg[1]==1, {
						~mod1DestCnt = (~mod1DestCnt) - 1;
						~mod1DestCnt.switch(~mod1DestCnt,{Mopho.cc(\mod1Dest,~mod1DestCnt+1);});
					});
				},
				//mod2
				'mod2AmntT',{Mopho.cc(\mod2Amnt, val);},
				'mod2SrcT',{
					if ( msg[1]==1, {
						~mod2SrcCnt = ~mod2SrcCnt + 1;
						~mod2SrcCnt.switch(~mod2SrcCnt,{Mopho.cc(\mod2Src,~mod2SrcCnt-1);});
					});
				},
				'mod2SrcMT',{
					if ( msg[1]==1, {
						~mod2SrcCnt = (~mod2SrcCnt) - 1;
						~mod2SrcCnt.switch(~mod2SrcCnt,{Mopho.cc(\mod2Src,~mod2SrcCnt+1);});
					});
				},
				'mod2DestT',{
					if ( msg[1]==1, {
						~mod2DestCnt = ~mod2DestCnt + 1;
						~mod2DestCnt.switch(~mod2DestCnt,{Mopho.cc(\mod2Dest,~mod2DestCnt-1);});
					});
				},
				'mod2DestMT',{
					if ( msg[1]==1, {
						~mod2DestCnt = (~mod2DestCnt) - 1;
						~mod2DestCnt.switch(~mod2DestCnt,{Mopho.cc(\mod2Dest,~mod2DestCnt+1);});
					});
				},
				//mod3
				'mod3AmntT',{Mopho.cc(\mod3Amnt, val);},
				'mod3SrcT',{
					if ( msg[1]==1, {
						~mod3SrcCnt = ~mod3SrcCnt + 1;
						~mod3SrcCnt.switch(~mod3SrcCnt,{Mopho.cc(\mod3Src,~mod3SrcCnt-1);});
					});
				},
				'mod3SrcMT',{
					if ( msg[1]==1, {
						~mod3SrcCnt = (~mod3SrcCnt) - 1;
						~mod3SrcCnt.switch(~mod3SrcCnt,{Mopho.cc(\mod3Src,~mod3SrcCnt+1);});
					});
				},
				'mod3DestT',{
					if ( msg[1]==1, {
						~mod3DestCnt = ~mod3DestCnt + 1;
						~mod3DestCnt.switch(~mod3DestCnt,{Mopho.cc(\mod3Dest,~mod3DestCnt-1);});
					});
				},
				'mod3DestMT',{
					if ( msg[1]==1, {
						~mod3DestCnt = (~mod3DestCnt) - 1;
						~mod3DestCnt.switch(~mod3DestCnt,{Mopho.cc(\mod3Dest,~mod3DestCnt+1);});
					});
				},
				//mod4
				'mod4AmntT',{Mopho.cc(\mod4Amnt, val);},
				'mod4SrcT',{
					if ( msg[1]==1, {
						~mod4SrcCnt = ~mod4SrcCnt + 1;
						~mod4SrcCnt.switch(~mod4SrcCnt,{Mopho.cc(\mod4Src,~mod4SrcCnt-1);});
					});
				},
				'mod4SrcMT',{
					if ( msg[1]==1, {
						~mod4SrcCnt = (~mod4SrcCnt) - 1;
						~mod4SrcCnt.switch(~mod4SrcCnt,{Mopho.cc(\mod4Src,~mod4SrcCnt+1);});
					});
				},
				'mod4DestT',{
					if ( msg[1]==1, {
						~mod4DestCnt = ~mod4DestCnt + 1;
						~mod4DestCnt.switch(~mod4DestCnt,{Mopho.cc(\mod4Dest,~mod4DestCnt-1);});
					});
				},
				'mod4DestMT',{
					if ( msg[1]==1, {
						~mod4DestCnt = (~mod4DestCnt) - 1;
						~mod4DestCnt.switch(~mod4DestCnt,{Mopho.cc(\mod4Dest,~mod4DestCnt+1);});
					});
				},
				///Arpeggiator
				'arpOnT',{
					if ( msg[1]==1, {
						~arpOnCnt = ~arpOnCnt + 1;
						~arpOnCnt.switch(~arpOnCnt,{Mopho.cc(\arpOn,~arpOnCnt);});
						if (~arpOnCnt==2, {~arpOnCnt=0;});
					});
				},
				'arpKndT',{
					if ( msg[1]==1, {
						~arpKndCnt = ~arpKndCnt + 1;
						~arpKndCnt.switch(~arpKndCnt,{Mopho.cc(\arpKnd,~arpKndCnt);});
						if ( ~arpKndCnt==5, {~arpKndCnt=0;});
					});
				},
				///Sequencer
				'seqOnT',{
					if ( msg[1]==1, {
						~seqOnCnt = ~seqOnCnt + 1;
						~seqOnCnt.switch(~seqOnCnt,{Mopho.cc(\seqOn,~seqOnCnt);});
						if (~seqOnCnt==2, {~seqOnCnt=0;});
					});
				},
				'seqTrigT',{
					if ( msg[1]==1, {
						~seqTrigCnt = ~seqTrigCnt + 1;
						~seqTrigCnt.switch(~seqTrigCnt,{Mopho.cc(\seqTrig,~seqTrigCnt);});
						if ( ~seqTrigCnt==5, {~seqTrigCnt=0;});
					});
				},
			)
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:'tempoBpmResp', oscName:'MPHtempoBpm', playDir:'tempoBpmT');
		this.oscResp(respName:'tempoBpmMinResp', oscName:'MPHtempoBpmMin', playDir:'tempoBpmMinT');
		this.oscResp(respName:'tempoBpmPlsResp', oscName:'MPHtempoBpmPls', playDir:'tempoBpmPlsT');
		this.oscResp(respName:'tempoDivResp', oscName:'MPHtempoDiv', playDir:'tempoDivT');
		this.oscResp(respName:'tempoDivMinResp', oscName:'MPHtempoDivMin', playDir:'tempoDivMinT');
		this.oscResp(respName:'tempoDivPlsResp', oscName:'MPHtempoDivPls', playDir:'tempoDivPlsT');
		//osc1
		this.oscResp(respName:'osc1FreqResp', oscName:'MPHosc1Freq', playDir:'osc1FreqT');
		this.oscResp(respName:'osc1TuneResp', oscName:'MPHosc1Tune', playDir:'osc1TuneT');
		this.oscResp(respName:'osc1ShapeResp', oscName:'MPHosc1Shape', playDir:'osc1ShapeT');
		this.oscResp(respName:'osc1ShButResp', oscName:'MPHosc1ShBut', playDir:'osc1ShButT');
		this.oscResp(respName:'osc2ShButResp', oscName:'MPHosc2ShBut', playDir:'osc2ShButT');
		this.oscResp(respName:'osc1GlideResp', oscName:'MPHosc1Glide', playDir:'osc1GlideT');
		this.oscResp(respName:'osc1KybrdResp', oscName:'MPHosc1Kybrd', playDir:'osc1KybrdT');
		this.oscResp(respName:'osc1SubResp', oscName:'MPHosc1Sub', playDir:'osc1SubT');
		//osc2
		this.oscResp(respName:'osc2FreqResp', oscName:'MPHosc2Freq', playDir:'osc2FreqT');
		this.oscResp(respName:'osc2TuneResp', oscName:'MPHosc2Tune', playDir:'osc2TuneT');
		this.oscResp(respName:'osc2ShapeResp', oscName:'MPHosc2Shape', playDir:'osc2ShapeT');
		this.oscResp(respName:'osc2GlideResp', oscName:'MPHosc2Glide', playDir:'osc2GlideT');
		this.oscResp(respName:'osc2KybrdResp', oscName:'MPHosc2Kybrd', playDir:'osc2KybrdT');
		this.oscResp(respName:'osc2SubResp', oscName:'MPHosc2Sub', playDir:'osc2SubT');
		//oscGlbl
		this.oscResp(respName:'oscMixResp', oscName:'MPHoscMix', playDir:'oscMixT');
		this.oscResp(respName:'oscSlopResp', oscName:'MPHoscSlop', playDir:'oscSlopT');
		this.oscResp(respName:'extInResp', oscName:'MPHextIn', playDir:'extInT');
		this.oscResp(respName:'noiseResp', oscName:'MPHnoise', playDir:'noiseT');
		this.oscResp(respName:'oscSyncResp', oscName:'MPHoscSync', playDir:'oscSyncT');
		this.oscResp(respName:'keyModeResp', oscName:'MPHkeyMode', playDir:'keyModeT');
		this.oscResp(respName:'glideModeResp', oscName:'MPHglideMode', playDir:'glideModeT');
		//LPF
		this.oscResp(respName:'lpfFreqResp', oscName:'MPHlpfFreq', playDir:'lpfFreqT');
		this.oscResp(respName:'lpfResResp', oscName:'MPHlpfRes', playDir:'lpfResT');
		this.oscResp(respName:'lpfAmntResp', oscName:'MPHlpfAmnt', playDir:'lpfAmntT');
		this.oscResp(respName:'lpfVelResp', oscName:'MPHlpfVel', playDir:'lpfVelT');
		this.oscResp(respName:'lpfKeyAmntResp', oscName:'MPHlpfKeyAmnt', playDir:'lpfKeyAmntT');
		this.oscResp(respName:'lpfAudModResp', oscName:'MPHlpfAudMod', playDir:'lpfAudModT');
		this.oscResp(respName:'lpfPoleResp', oscName:'MPHlpfPole', playDir:'lpfPoleT');

		this.oscResp(respName:'lpfEnvDelResp', oscName:'MPHlpfEnvDel', playDir:'lpfEnvDelT');
		this.oscResp(respName:'lpfEnvAttResp', oscName:'MPHlpfEnvAtt', playDir:'lpfEnvAttT');
		this.oscResp(respName:'lpfEnvDecResp', oscName:'MPHlpfEnvDec', playDir:'lpfEnvDecT');
		this.oscResp(respName:'lpfEnvSusResp', oscName:'MPHlpfEnvSus', playDir:'lpfEnvSusT');
		this.oscResp(respName:'lpfEnvRlsResp', oscName:'MPHlpfEnvRls', playDir:'lpfEnvRlsT');
		//VCA
		this.oscResp(respName:'vcaLvlResp', oscName:'MPHvcaLvl', playDir:'vcaLvlT');
		this.oscResp(respName:'vcaAmntResp', oscName:'MPHvcaAmnt', playDir:'vcaAmntT');
		this.oscResp(respName:'vcaVelResp', oscName:'MPHvcaVel', playDir:'vcaVelT');
		this.oscResp(respName:'voiVolResp', oscName:'MPHvoiVol', playDir:'voiVolT');
		this.oscResp(respName:'vcaEnvDelResp', oscName:'MPHvcaEnvDel', playDir:'vcaEnvDelT');
		this.oscResp(respName:'vcaEnvAttResp', oscName:'MPHvcaEnvAtt', playDir:'vcaEnvAttT');
		this.oscResp(respName:'vcaEnvDecResp', oscName:'MPHvcaEnvDec', playDir:'vcaEnvDecT');
		this.oscResp(respName:'vcaEnvSusResp', oscName:'MPHvcaEnvSus', playDir:'vcaEnvSusT');
		this.oscResp(respName:'vcaEnvRlsResp', oscName:'MPHvcaEnvRls', playDir:'vcaEnvRlsT');
		//ENV 3
		this.oscResp(respName:'env3RptResp', oscName:'MPHenv3Rpt', playDir:'env3RptT');
		this.oscResp(respName:'env3AmntResp', oscName:'MPHenv3Amnt', playDir:'env3AmntT');
		this.oscResp(respName:'env3VelResp', oscName:'MPHenv3Vel', playDir:'env3VelT');
		this.oscResp(respName:'env3DelResp', oscName:'MPHenv3Del', playDir:'env3DelT');
		this.oscResp(respName:'env3AttResp', oscName:'MPHenv3Att', playDir:'env3AttT');
		this.oscResp(respName:'env3DecResp', oscName:'MPHenv3Dec', playDir:'env3DecT');
		this.oscResp(respName:'env3SusResp', oscName:'MPHenv3Sus', playDir:'env3SusT');
		this.oscResp(respName:'env3RlsResp', oscName:'MPHenv3Rls', playDir:'env3RlsT');
		this.oscResp(respName:'env3DestResp', oscName:'MPHenv3Dest', playDir:'env3DestT');
		this.oscResp(respName:'env3DestMResp', oscName:'MPHenv3DestM', playDir:'env3DestMT');
		//LFO1
		this.oscResp(respName:'lfo1AmntResp', oscName:'MPHlfo1Amnt', playDir:'lfo1AmntT');
		this.oscResp(respName:'lfo1KeySyncResp', oscName:'MPHlfo1KeySync', playDir:'lfo1KeySyncT');
		this.oscResp(respName:'lfo1FreqResp', oscName:'MPHlfo1Freq', playDir:'lfo1FreqT');
		this.oscResp(respName:'lfo1SFreqResp', oscName:'MPHlfo1SFreq', playDir:'lfo1SFreqT');
		this.oscResp(respName:'lfo1SFreqMResp', oscName:'MPHlfo1SFreqM', playDir:'lfo1SFreqMT');
		this.oscResp(respName:'lfo1ShapeResp', oscName:'MPHlfo1Shape', playDir:'lfo1ShapeT');
		this.oscResp(respName:'lfo1ShapeMResp', oscName:'MPHlfo1ShapeM', playDir:'lfo1ShapeMT');
		this.oscResp(respName:'lfo1DestResp', oscName:'MPHlfo1Dest', playDir:'lfo1DestT');
		this.oscResp(respName:'lfo1DestMResp', oscName:'MPHlfo1DestM', playDir:'lfo1DestMT');
		//LFO2
		this.oscResp(respName:'lfo2AmntResp', oscName:'MPHlfo2Amnt', playDir:'lfo2AmntT');
		this.oscResp(respName:'lfo2KeySyncResp', oscName:'MPHlfo2KeySync', playDir:'lfo2KeySyncT');
		this.oscResp(respName:'lfo2FreqResp', oscName:'MPHlfo2Freq', playDir:'lfo2FreqT');
		this.oscResp(respName:'lfo2SFreqResp', oscName:'MPHlfo2SFreq', playDir:'lfo2SFreqT');
		this.oscResp(respName:'lfo2SFreqMResp', oscName:'MPHlfo2SFreqM', playDir:'lfo2SFreqMT');
		this.oscResp(respName:'lfo2ShapeResp', oscName:'MPHlfo2Shape', playDir:'lfo2ShapeT');
		this.oscResp(respName:'lfo2ShapeMResp', oscName:'MPHlfo2ShapeM', playDir:'lfo2ShapeMT');
		this.oscResp(respName:'lfo2DestResp', oscName:'MPHlfo2Dest', playDir:'lfo2DestT');
		this.oscResp(respName:'lfo2DestMResp', oscName:'MPHlfo2DestM', playDir:'lfo2DestMT');
		//LFO3
		this.oscResp(respName:'lfo3AmntResp', oscName:'MPHlfo3Amnt', playDir:'lfo3AmntT');
		this.oscResp(respName:'lfo3KeySyncResp', oscName:'MPHlfo3KeySync', playDir:'lfo3KeySyncT');
		this.oscResp(respName:'lfo3FreqResp', oscName:'MPHlfo3Freq', playDir:'lfo3FreqT');
		this.oscResp(respName:'lfo3SFreqResp', oscName:'MPHlfo3SFreq', playDir:'lfo3SFreqT');
		this.oscResp(respName:'lfo3SFreqMResp', oscName:'MPHlfo3SFreqM', playDir:'lfo3SFreqMT');
		this.oscResp(respName:'lfo3ShapeResp', oscName:'MPHlfo3Shape', playDir:'lfo3ShapeT');
		this.oscResp(respName:'lfo3ShapeMResp', oscName:'MPHlfo3ShapeM', playDir:'lfo3ShapeMT');
		this.oscResp(respName:'lfo3DestResp', oscName:'MPHlfo3Dest', playDir:'lfo3DestT');
		this.oscResp(respName:'lfo3DestMResp', oscName:'MPHlfo3DestM', playDir:'lfo3DestMT');
		//LFO4
		this.oscResp(respName:'lfo4AmntResp',    oscName:'MPHlfo4Amnt',    playDir:'lfo4AmntT');
		this.oscResp(respName:'lfo4KeySyncResp', oscName:'MPHlfo4KeySync', playDir:'lfo4KeySyncT');
		this.oscResp(respName:'lfo4FreqResp',    oscName:'MPHlfo4Freq',    playDir:'lfo4FreqT');
		this.oscResp(respName:'lfo4SFreqResp',   oscName:'MPHlfo4SFreq',   playDir:'lfo4SFreqT');
		this.oscResp(respName:'lfo4SFreqMResp',   oscName:'MPHlfo4SFreqM',   playDir:'lfo4SFreqMT');
		this.oscResp(respName:'lfo4ShapeResp',   oscName:'MPHlfo4Shape',   playDir:'lfo4ShapeT');
		this.oscResp(respName:'lfo4ShapeMResp',   oscName:'MPHlfo4ShapeM',   playDir:'lfo4ShapeMT');
		this.oscResp(respName:'lfo4DestResp',    oscName:'MPHlfo4Dest',    playDir:'lfo4DestT');
		this.oscResp(respName:'lfo4DestMResp',    oscName:'MPHlfo4DestM',    playDir:'lfo4DestMT');
		//MOD1
		this.oscResp(respName:'mod1SrcResp',  oscName:'MPHmod1Src',  playDir:'mod1SrcT');
		this.oscResp(respName:'mod1SrcMResp',  oscName:'MPHmod1SrcM',  playDir:'mod1SrcMT');
		this.oscResp(respName:'mod1AmntResp', oscName:'MPHmod1Amnt', playDir:'mod1AmntT');
		this.oscResp(respName:'mod1DestResp', oscName:'MPHmod1Dest', playDir:'mod1DestT');
		this.oscResp(respName:'mod1DestMResp', oscName:'MPHmod1DestM', playDir:'mod1DestMT');
		//mod2
		this.oscResp(respName:'mod2SrcResp',  oscName:'MPHmod2Src',  playDir:'mod2SrcT');
		this.oscResp(respName:'mod2SrcMResp',  oscName:'MPHmod2SrcM',  playDir:'mod2SrcMT');
		this.oscResp(respName:'mod2AmntResp', oscName:'MPHmod2Amnt', playDir:'mod2AmntT');
		this.oscResp(respName:'mod2DestResp', oscName:'MPHmod2Dest', playDir:'mod2DestT');
		this.oscResp(respName:'mod2DestMResp', oscName:'MPHmod2DestM', playDir:'mod2DestMT');
		//mod3
		this.oscResp(respName:'mod3SrcResp',  oscName:'MPHmod3Src',  playDir:'mod3SrcT');
		this.oscResp(respName:'mod3SrcMResp',  oscName:'MPHmod3SrcM',  playDir:'mod3SrcMT');
		this.oscResp(respName:'mod3AmntResp', oscName:'MPHmod3Amnt', playDir:'mod3AmntT');
		this.oscResp(respName:'mod3DestResp', oscName:'MPHmod3Dest', playDir:'mod3DestT');
		this.oscResp(respName:'mod3DestMResp', oscName:'MPHmod3DestM', playDir:'mod3DestMT');
		//mod4
		this.oscResp(respName:'mod4SrcResp',  oscName:'MPHmod4Src',  playDir:'mod4SrcT');
		this.oscResp(respName:'mod4SrcMResp',  oscName:'MPHmod4SrcM',  playDir:'mod4SrcMT');
		this.oscResp(respName:'mod4AmntResp', oscName:'MPHmod4Amnt', playDir:'mod4AmntT');
		this.oscResp(respName:'mod4DestResp', oscName:'MPHmod4Dest', playDir:'mod4DestT');
		this.oscResp(respName:'mod4DestMResp', oscName:'MPHmod4DestM', playDir:'mod4DestMT');
		//Arp - SEQ
		this.oscResp(respName:'arpOnResp', oscName:'MPHarpOn', playDir:'arpOnT');
		this.oscResp(respName:'arpKndResp', oscName:'MPHarpKnd', playDir:'arpKndT');
		this.oscResp(respName:'seqOnResp', oscName:'MPHseqOn', playDir:'seqOnT');
		this.oscResp(respName:'seqTrigResp', oscName:'MPHseqTrig', playDir:'seqTrigT');

	}
	*resetCnts{
		//~tempoDivTag=0;
		~osc1KybrdCnt=0;
		~osc2KybrdCnt=0;
		~osc1ShButCnt=0;
		~osc2ShButCnt=0;
		~oscSyncCnt=0;
		~keyModeCnt=0;
		~glideModeCnt=0;
		~lpfPoleCnt=0;
		~env3DestCnt=0;
		~env3DestMCnt=0;
		~env3RptCnt=0;
		~lfo1SFreqCnt=0;
		~lfo1SFreqMCnt=0;
		~lfo1KeySyncCnt=0;
		~lfo1DestCnt=0;
		~lfo1DestMCnt=0;
		~lfo1ShapeCnt=0;
		~lfo1ShapeMCnt=0;
		~lfo2SFreqCnt=0;
		~lfo2SFreqMCnt=0;
		~lfo2KeySyncCnt=0;
		~lfo2DestCnt=0;
		~lfo2DestMCnt=0;
		~lfo2ShapeCnt=0;
		~lfo2ShapeMCnt=0;
		~lfo3SFreqCnt=0;
		~lfo3SFreqMCnt=0;
		~lfo3KeySyncCnt=0;
		~lfo3DestCnt=0;
		~lfo3DestMCnt=0;
		~lfo3ShapeCnt=0;
		~lfo3ShapeMCnt=0;
		~lfo4SFreqCnt=0;
		~lfo4SFreqMCnt=0;
		~lfo4KeySyncCnt=0;
		~lfo4DestCnt=0;
		~lfo4DestMCnt=0;
		~lfo4ShapeCnt=0;
		~lfo4ShapeMCnt=0;
		~mod1SrcCnt=0;
		~mod1DestCnt=0;
		~mod1DestMCnt=0;
		~mod2SrcCnt=0;
		~mod2DestCnt=0;
		~mod2DestMCnt=0;
		~mod3SrcCnt=0;
		~mod3DestCnt=0;
		~mod3DestMCnt=0;
		~mod4SrcCnt=0;
		~mod4DestCnt=0;
		~mod4DestMCnt=0;
		~arpOnCnt=0;
		~arpKndCnt=0;
		~seqOnCnt=0;
		~seqTrigCnt=0;
	}
}
//GLOBAL PARAMETER NRPN
//noise
/**parameterSend{|val|
/*0-2
-- 0= NRPN
-- 1= CC
-- 2= Off
*/
this.nrp( 3,6,0, val);
}
*parameterReceive{|val|
/*0-3
-- 0= All
-- 1= NRPN
-- 2= CC
-- 3= Off
*/
this.nrp( 3,7,0, val);
}
*controllerSendReceive{|val|
/*0-1 Off On
*/
this.nrp( 3,10,0, val);
}
*sysexSendReceive{|val|
/*0-1 Off On
*/
this.nrp( 3,11,0, val);
}
*audioOut{|val|
/*0-2
-- 0= Stereo
-- 1= Mono
*/
this.nrp( 3,21,0, val);
}
*midiOut{|val|
/*0-2
-- 0= Out
-- 1= Thru
*/
this.nrp( 3,22,0, val);
}
*osc1Freq{|val|
/*0-120 in semitones
10 octave range
*/
this.nrp( 3,22,0, val);
}*/
/*
Mopho.cc(transpose,12)
Mopho.masterTranspose(12);
Mopho.masterTune(1);
Mopho.midiClock(0);
Mopho.parameterSend(1);
Mopho.parameterReceive(0);
Mopho.controllerSendReceive(1);
Mopho.sysexSendReceive(1);
Mopho.audioOut(0);
Mopho.midiOut(1);

*vcaLvl{|val|
//0->127  VCA Initial Level
this.nrp( 0,27,0, val);
}
*voiVol{|val|
//0->127  VCA Initial Level
this.nrp( 0,29,0, val);
}

Mopho.vcaLvl(0);
*/



/*
Mopho.cc(\globalTune,50);
Mopho.control( 3, 0, 0, 12); //Global Transpose 12=0 24=+12
Mopho.control( 3, 1, 0, 50); //Fine Tune 0=-50 50=0 100=+50
//Mopho.control( 3, 2, 0, 100); //MIDI Channel 0=all deflt=2
Mopho.control( 3, 3, 0, ); //MIDI Channel 0=all deflt=2
Mopho.control(15, 0,84, 0, 24); //Osc_1 Freq

~vMopho.noteOn( 26, 111);   //But 1
~vMopho.noteOff( 26, 1);    //But 1

~vMopho.control(15, 20, 49); //Osc_1 Freq
~vMopho.control( 21, 50);    //Osc_1 Fine Tune
~vMopho.control( 22, 3);     //Osc_1 Shape
~vMopho.control( 23, 43);    //Osc_1 Glide

~vMopho.control( 24, 60); //Osc_2 Freq
~vMopho.control( 25, 57); //Osc_2 Fine Tune
~vMopho.control( 26, 58); //Osc_2 Shape
~vMopho.control( 27, 13); //Osc_2 Glide

~vMopho.control( 28, 64); //Osc Mix

~vMopho.control( 30, 0); //Sub Osc_1
~vMopho.control( 31, 120); //Sub Osc_2


~vMopho.control( 102, 110); //Filter Freq CutOff
~vMopho.control( 103, 17); //Filter Resonans
~vMopho.control( 104, 17); //Filter Key Amnt
~vMopho.control( 105, 7); //Filter Audio Mod
~vMopho.control( 106, 0); //Filter Env Amnt
~vMopho.control( 107, 127); //Filter Env Vel Amnt
~vMopho.control( 108, 0); //Filter Dly
~vMopho.control( 109, 1); //Filter Att
~vMopho.control( 110, 10); //Filter Dec
~vMopho.control( 111, 20); //Filter Sus
~vMopho.control( 112, 17); //Filter Rel

~vMopho.control( 113, 0); //VCA Lvl
~vMopho.control( 115, 127); //Amp Env Amnt
~vMopho.control( 116, 127); //Amp Env Vel Amnt
~vMopho.control( 117, 0); //Amp Dly
~vMopho.control( 118, 1); //Amp Att
~vMopho.control( 119, 37); //Amp Dec
~vMopho.control( 75, 45); //Amp Sus
~vMopho.control( 76, 10); //Amp Rel

~vMopho.control( 85, 7); //Env3 Dest
~vMopho.control( 86, 7); //Env3 Amnt
~vMopho.control( 87, 7); //Env3 Vel Amnt
~vMopho.control( 88, 7); //Env3 Dly
~vMopho.control( 89, 7); //Env3 Att
~vMopho.control( 90, 7); //Env3 Dec
~vMopho.control( 77, 7); //Env3 Sus
~vMopho.control( 78, 7); //Env3 Rel


~vMopho.control( 29, 0); //Noise Lev
~vMopho.control( 14, 64); //BPM
~vMopho.control( 15, 0); //Clock Divide

//MOPHO SEND NRPN
//NRPN control of filter pole on DSI Tetra:
//   first, set parameter number (24 in this case)
//   set most significant byte for parameter number (0 in this case)
~vMopho.control( 99, 0);
//   then least significant byte for parameter number (24 in this case)
~vMopho.control( 98, 24);
// then set value (1 for 4 pole)
//   first set most significant byte for this value (0 in this case)
~vMopho.control( 6, 0);
//   then least significant byte for parameter number (1 in this case)
~vMopho.control(38, 1);

~param=0;~nrpn=13;~vall=5;
~vMopho.control( 99, ~param);
~vMopho.control( 98, ~nrpn);
~vMopho.control( 6, 0);
~vMopho.control(38, ~vall);

Mopho.nrp(0,66,0, 127);


'env3AmntT',{
case
{msg[1]<0} {
Mopho.cc(\env3AmntMin,(((-1)*msg[1])*127).reverse);
~tOSCAdrr.sendMsg('MPHenv3Amnt', msg[1]);
}
{msg[1]>0} {
Mopho.cc(\env3AmntPlus,msg[1]*127);
~tOSCAdrr.sendMsg('MPHenv3Amnt', msg[1]);
};
},

////TEEEEEEEEEEEST OOOOOOSSSSSSCCCCCCCC
~tesOSC.free;
~tesOSC = OSCFunc({
arg msg,val,vel, val1,val2, vel1,vel2,vel3, spec,spec1,spec2,spec3;
val=msg[1];
vel=(val*127);

spec1=ControlSpec(30, 127,\exp,1);
vel1=spec1.map(val);

spec=ControlSpec(0, 127,\lin,1);
spec2=ControlSpec(0, 12,\lin,1);


vel2=spec.map(vel);

vel3=spec2.map(vel2);
/*
122=0.96;
127-22
250-30
*/
case
{val<=0.96}{"Tempo A".postln; val.postln; vel.postln; vel1.postln; }
{val>0.96}{(vel3).postln; "vel 2".postln;}

},'/MPHtempoBpm');

/// OOOOOOOOOOOOOO SSSSSSSSSSSSSSS CCCCCCCCCCC

~tesOSC.free;
~tesOSC = OSCFunc({
arg msg,val,vel, val1,val2, vel1,vel2,vel3, spec,spec1,spec2,spec3;
val=msg[1];
vel=(val*127);

spec1=ControlSpec(30, 127,\exp,1);
vel1=spec1.map(val);

spec=ControlSpec(0, 127,\lin,1);
spec2=ControlSpec(0, 12,\lin,1);


vel2=spec2.map((val+(-122)));

vel3=spec2.map(vel2);
/*
122=0.96;
127-22
250-30
*/
case
{vel<=122}{"Tempo A".postln; Mopho.nrp( 0, 91, 0, vel1);}
{vel>=123}{"Tempo B".postln;vel2.postln; Mopho.nrp( 0, 91, 1, vel2);}

},'/MPHtempoBpm');

//
// ~tesOSC.free;
// ~tesOSC = OSCFunc({
// 	arg msg,val1,vel1,val2,vel2;
// 	val=msg[1];
// 	val1= val.range(30,127);
// 	val2= val.range(0,127);
// 	case
// 	{msg[1]<0.}{}
// 	if ( , {
// 		Mopho.nrp( 0, 91, 0, val1);//tempoA
// 		},{
// 			Mopho.nrp( 0, 91, 1, val2);//tempoB
// 	});
// },'/MPHtempoBpm');
//


////WORKING

//MOPHO SEND NRPN
//NRPN control of filter pole on DSI Tetra:

//   first, set parameter number (24 in this case)

//   set most significant byte for parameter number (0 in this case)
~vMopho.control(0, 99, 0);

//   then least significant byte for parameter number (24 in this case)
~vMopho.control(0, 98, 24);

// then set value (1 for 4 pole)


//   first set most significant byte for this value (0 in this case)
~vMopho.control(0, 6, 0);
//   then least significant byte for parameter number (1 in this case)


Mopho.nrp( 0, 0, 0, 36);// osc1 freq
Mopho.nrp( 0, 1, 0, 39);// osc1 tune
Mopho.nrp( 0, 2, 0, 59);// osc1 shape
Mopho.nrp( 0, 3, 0, 10);// osc1 Glide
Mopho.nrp( 0, 4, 0, 1);// osc1 Keybord OnOff
Mopho.nrp( 0, 114, 0, 96);// osc1 Sub level

Mopho.nrp( 0, 5, 0, 36);// osc2 freq
Mopho.nrp( 0, 6, 0, 39);// osc2 tune
Mopho.nrp( 0, 7, 0, 50);// osc2 shape
Mopho.nrp( 0, 8, 0, 120);// osc2 Glide
Mopho.nrp( 0, 9, 0, 1);// osc2 Keybord OnOff 0->1
Mopho.nrp( 0, 115, 0, 0);// osc2 Sub level 0->127

Mopho.nrp( 0, 11, 0, 1);// Glide Mode 0->3
0 fixedRate -
1 fixRtAuto -
2 fixedTime -
3 fixTmAuto

Mopho.nrp( 0, 96, 0, 5);// Key Assing Mode 0->5
0=Low note priority
1=Low note priority with re-trigger
2=High note priority
3=High note priority with re-trigger
4=Last note priority
5=Last note priority with re-trigger

Mopho.nrp( 0, 116, 0, 0);//0->127  Ext AudioIn
Mopho.nrp( 0, 14, 0, 0); //0->127  Noise Lvl
Mopho.nrp( 0, 10, 0, 0); //0->1    Sync osc2->osc1 OnOff
Mopho.nrp( 0, 93, 0, 12);//0->12   Pitch Bend Range
Mopho.nrp( 0, 13, 0, 1); //0->127  Osc Mix


Mopho.nrp( 0, 15, 0, 38);//0->164  Filter Frequency, steps in semitones
Mopho.nrp( 0, 16, 0, 28);//0->127  Filter Resonance
Mopho.nrp( 0, 17, 0, 28);//0->127  Filter Keyboard Amount
Mopho.nrp( 0, 18, 0, 28);//0->127  Filter Audio Modulation
Mopho.nrp( 0, 19, 0, 1); //0->1    Filter Poles 0=2pole 1=4pole
Mopho.nrp( 0, 20, 1, 45);//0->254  Filter Envelope Amount -127 to +127
Mopho.nrp( 0, 21, 0, 120);//0->127  Filter Envelope Velocity Amount
Mopho.nrp( 0, 22, 0, 120);//0->127  Filter Envelope Delay
Mopho.nrp( 0, 23, 0, 120);//0->127  Filter Envelope Att
Mopho.nrp( 0, 24, 0, 120);//0->127  Filter Envelope Decay
Mopho.nrp( 0, 25, 0, 120);//0->127  Filter Envelope Sustain
Mopho.nrp( 0, 26, 0, 120);//0->127  Filter Envelope Release

Mopho.nrp( 0, 27, 0, 0);//0->127  VCA Initial Level
Mopho.vcaLvl(0);
Mopho.nrp( 0, 30, 0, 120);//0->127  VCA Envelope Amount
Mopho.nrp( 0, 31, 0, 120);//0->127  VCA Envelope Velocity Amount
Mopho.nrp( 0, 32, 0, 120);//0->127  VCA Envelope Delay
Mopho.nrp( 0, 33, 0, 120);//0->127  VCA Envelope Att
Mopho.nrp( 0, 34, 0, 120);//0->127  VCA Envelope Decay
Mopho.nrp( 0, 35, 0, 120);//0->127  VCA Envelope Sustain
Mopho.nrp( 0, 36, 0, 78);//0->127  VCA Envelope Release
Mopho.nrp( 0, 29, 0, 127);//0->127  Voice Volume

/*
//LFO 1
Mopho.nrp( 0, 39, 0, 34);//0->127  LFO1 Amount
Mopho.nrp( 0, 37, 0, 0);//0->166  LFO1 Freq // 0-150 unsynced freqs
Mopho.nrp( 0, 37, 1, 23);//0->166  LFO1 Freq // 151-166 synced freqs
val23 = 151- div/32
val24 = 152- /16
val25 = 153- /8
val26 = 154- /6
val27 = 155- /4
val28 = 156- /3
val29 = 157- /2
val30 = 158- /1.5
val31 = 159- 1 cycle per 1 step
val32 = 160- 2 cycle per 3 step
val33 = 161- 2 cycle per 1 step
val34 = 162- 3 cycle per 1 step
val35 = 163- 4 cycle per 1 step
val36 = 164- 6 cycle per 1 step
val37 = 165- 8 cycle per 1 step
val38 = 166- 16 cycle per 1 step
Mopho.nrp( 0, 38, 0, 3);//0->4  LFO1 Shape 0 Triangle - 1 RevSawtooth - 2 Sawtooth - 3 Sqr - 4 Rand
*/
Mopho.cc(\osc1Freq,12)

((0.1.reverse-0.5)*127*2)

-- 0= InternalClock - Don't Send MIDIClock
-- 1= InternalClock - Send MIDIClock
-- 2= MIDIClock In
-- 3=  MIDIClock In - Retransmint MIDI Clock Out
//Env3
\env3Dest,{
("Top Function Trig mul:"+~env3DestCnt).postln;

if ( (val)==47, {~env3DestCnt=0;val=0;},{~env3DestCnt=~env3DestCnt});

("Top Function Before IF:"+~env3DestCnt).postln;

this.nrp( 0,57,0, val); this.lbl(\env3DestLbl,1+~destLst[val]);

("Top Function After mul:"+~env3DestCnt).postln;

~env3DestCnt=val+1;
//if ( val==47, {~env3DestCnt=0;});
("Top Function Last mul:"+~env3DestCnt).postln;
},
*/