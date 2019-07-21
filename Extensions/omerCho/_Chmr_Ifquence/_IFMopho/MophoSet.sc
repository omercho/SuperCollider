/*
/*
Mopho.masterTranspose(12);
Mopho.masterTune(1);
Mopho.midiClock(0);
Mopho.parameterSend(1);
Mopho.parameterReceive(0);
Mopho.controllerSendReceive(1);
Mopho.sysexSendReceive(1);
Mopho.audioOut(0);
Mopho.midiOut(1);
*/
MophoSet(\default);
MophoSet.makeOSCResps;

Mopho.cc(\extIn, 127);

*/
MophoSet{
	*new{|key,val|
		key.switch(
			\default,{
				("MophoSet"+key).postln;
				Mopho.cc(\extIn, 0);
				Mopho.cc(\noise, 0);
				Mopho.cc(\voiVol, 124);

				Mopho.cc(\osc1Freq, 36);
				Mopho.cc(\osc1Tune,50);
				Mopho.cc(\osc1Shape,1);
				Mopho.cc(\osc1Glide,0);
				Mopho.cc(\osc1Kybrd,2);
				Mopho.cc(\osc1Sub, 0);

				Mopho.cc(\osc2Freq, 36);
				Mopho.cc(\osc2Tune,53);
				Mopho.cc(\osc2Shape,3);
				Mopho.cc(\osc2Glide,0);
				Mopho.cc(\osc2Kybrd,2);
				Mopho.cc(\osc2Sub, 0);

				Mopho.cc(\oscMix, 63);
				Mopho.cc(\oscSync, 1);
				Mopho.cc(\oscSlop, 1);
				Mopho.cc(\keyMode, 1);
				Mopho.cc(\glideMode, 1);

				Mopho.cc(\lpfFreq, 10);
				Mopho.cc(\lpfRes, 0);
				Mopho.cc(\lpfAmnt, 80);
				Mopho.cc(\lpfVel, 120);
				Mopho.cc(\lpfKeyAmnt, 100);
				Mopho.cc(\lpfAudMod, 40);
				Mopho.cc(\lpfPole, 0);
				Mopho.cc(\lpfEnvAtt, 0);
				Mopho.cc(\lpfEnvDec, 68);
				Mopho.cc(\lpfEnvSus, 40);
				Mopho.cc(\lpfEnvRls, 40);

				Mopho.cc(\vcaLvl, 120);
				Mopho.cc(\vcaAmnt, 120);
				Mopho.cc(\vcaVel, 127);
				Mopho.cc(\vcaEnvAtt, 0);
				Mopho.cc(\vcaEnvDec, 50);
				Mopho.cc(\vcaEnvSus, 100);
				Mopho.cc(\vcaEnvRls, 20);

				Mopho.cc('lfo1Dest', 0);
				Mopho.cc('lfo2Dest', 0);
				Mopho.cc('lfo3Dest', 0);
				Mopho.cc('lfo4Dest', 0);
				Mopho.cc('lfo1Amnt', 0);
				Mopho.cc('lfo2Amnt', 0);
				Mopho.cc('lfo3Amnt', 0);
				Mopho.cc('lfo4Amnt', 0);
				Mopho.cc('lfo1Freq', 0);
				Mopho.cc('lfo2Freq', 0);
				Mopho.cc('lfo3Freq', 0);
				Mopho.cc('lfo4Freq', 0);
				Mopho.cc('lfo1Shape', 0);
				Mopho.cc('lfo2Shape', 0);
				Mopho.cc('lfo3Shape', 0);
				Mopho.cc('lfo4Shape', 0);
				Mopho.cc('lfo1KeySync', 0);
				Mopho.cc('lfo2KeySync', 0);
				Mopho.cc('lfo3KeySync', 0);
				Mopho.cc('lfo4KeySync', 0);

				Mopho.cc('env3Dest', 0);
				Mopho.cc(\env3Amnt, 127);
				Mopho.cc(\env3Vel, 0);
				Mopho.cc(\env3Att, 0);
				Mopho.cc(\env3Dec, 0);
				Mopho.cc(\env3Sus, 0);
				Mopho.cc(\env3Rls, 0);
				Mopho.cc('mod1Dest', 0);
				Mopho.cc('mod2Dest', 0);
				Mopho.cc('mod3Dest', 0);
				Mopho.cc('mod4Dest', 0);
				Mopho.cc('mod1Src', 0);
				Mopho.cc('mod2Src', 0);
				Mopho.cc('mod3Src', 0);
				Mopho.cc('mod4Src', 0);
				Mopho.cc(\mod1Amnt, 127);
				Mopho.cc(\mod2Amnt, 127);
				Mopho.cc(\mod3Amnt, 127);
				Mopho.cc(\mod4Amnt, 127);
			},
			\oc01,{
				("MophoSet"+key).postln;
				Mopho.cc(\extIn, 64);
				Mopho.cc(\noise, 0);
				Mopho.cc(\voiVol, 126);

				Mopho.cc(\osc1Freq, 36);
				Mopho.cc(\osc1Tune,50);
				Mopho.cc(\osc1Shape,1);
				Mopho.cc(\osc1Glide,0);
				Mopho.cc(\osc1Kybrd,2);
				Mopho.cc(\osc1Sub, 0);

				Mopho.cc(\osc2Freq, 36);
				Mopho.cc(\osc2Tune,53);
				Mopho.cc(\osc2Shape,3);
				Mopho.cc(\osc2Glide,0);
				Mopho.cc(\osc2Kybrd,2);
				Mopho.cc(\osc2Sub, 0);

				Mopho.cc(\oscMix, 63);
				Mopho.cc(\oscSync, 1);
				Mopho.cc(\oscSlop, 1);
				Mopho.cc(\keyMode, 1);
				Mopho.cc(\glideMode, 1);

				Mopho.cc(\lpfFreq, 10);
				Mopho.cc(\lpfRes, 0);
				Mopho.cc(\lpfAmnt, 60);
				Mopho.cc(\lpfVel, 100);
				Mopho.cc(\lpfKeyAmnt, 100);
				Mopho.cc(\lpfAudMod, 80);
				Mopho.cc(\lpfPole, 1);
				Mopho.cc(\lpfEnvAtt, 0);
				Mopho.cc(\lpfEnvDec, 68);
				Mopho.cc(\lpfEnvSus, 60);
				Mopho.cc(\lpfEnvRls, 20);

				Mopho.cc(\vcaLvl, 10);
				Mopho.cc(\vcaAmnt, 90);
				Mopho.cc(\vcaVel, 127);
				Mopho.cc(\vcaEnvAtt, 0);
				Mopho.cc(\vcaEnvDec, 90);
				Mopho.cc(\vcaEnvSus, 100);
				Mopho.cc(\vcaEnvRls, 60);

				Mopho.cc('lfo1Dest', 0);
				Mopho.cc('lfo2Dest', 0);
				Mopho.cc('lfo3Dest', 0);
				Mopho.cc('lfo4Dest', 0);
				Mopho.cc('lfo1Amnt', 0);
				Mopho.cc('lfo2Amnt', 0);
				Mopho.cc('lfo3Amnt', 0);
				Mopho.cc('lfo4Amnt', 0);
				Mopho.cc('lfo1Freq', 0);
				Mopho.cc('lfo2Freq', 0);
				Mopho.cc('lfo3Freq', 0);
				Mopho.cc('lfo4Freq', 0);
				Mopho.cc('lfo1Shape', 0);
				Mopho.cc('lfo2Shape', 0);
				Mopho.cc('lfo3Shape', 0);
				Mopho.cc('lfo4Shape', 0);
				Mopho.cc('lfo1KeySync', 0);
				Mopho.cc('lfo2KeySync', 0);
				Mopho.cc('lfo3KeySync', 0);
				Mopho.cc('lfo4KeySync', 0);

				Mopho.cc(\env3Amnt, 127);
				Mopho.cc('env3Dest', 0);
				Mopho.cc(\env3Vel, 0);
				Mopho.cc(\env3Att, 0);
				Mopho.cc(\env3Dec, 0);
				Mopho.cc(\env3Sus, 0);
				Mopho.cc(\env3Rls, 0);
				Mopho.cc('mod1Dest', 0);
				Mopho.cc('mod2Dest', 0);
				Mopho.cc('mod3Dest', 0);
				Mopho.cc('mod4Dest', 0);
				Mopho.cc('mod1Src', 0);
				Mopho.cc('mod2Src', 0);
				Mopho.cc('mod3Src', 0);
				Mopho.cc('mod4Src', 0);
				Mopho.cc(\mod1Amnt, 127);
				Mopho.cc(\mod2Amnt, 127);
				Mopho.cc(\mod3Amnt, 127);
				Mopho.cc(\mod4Amnt, 127);
			},
			\oc02,{
				("MophoSet"+key).postln;
				Mopho.cc(\extIn, 64);
				Mopho.cc(\noise, 0);
				Mopho.cc(\voiVol, 126);

				Mopho.cc(\osc1Freq, 36);
				Mopho.cc(\osc1Tune,50);
				Mopho.cc(\osc1Shape,1);
				Mopho.cc(\osc1Glide,0);
				Mopho.cc(\osc1Kybrd,2);
				Mopho.cc(\osc1Sub, 0);

				Mopho.cc(\osc2Freq, 36);
				Mopho.cc(\osc2Tune,53);
				Mopho.cc(\osc2Shape,3);
				Mopho.cc(\osc2Glide,10);
				Mopho.cc(\osc2Kybrd,2);
				Mopho.cc(\osc2Sub, 0);

				Mopho.cc(\oscMix, 68);
				Mopho.cc(\oscSync, 1);
				Mopho.cc(\oscSlop, 1);
				Mopho.cc(\keyMode, 1);
				Mopho.cc(\glideMode, 1);

				Mopho.cc(\lpfFreq, 10);
				Mopho.cc(\lpfRes, 20);
				Mopho.cc(\lpfAmnt, 60);
				Mopho.cc(\lpfVel, 100);
				Mopho.cc(\lpfKeyAmnt, 100);
				Mopho.cc(\lpfAudMod, 80);
				Mopho.cc(\lpfPole, 2);
				Mopho.cc(\lpfEnvAtt, 0);
				Mopho.cc(\lpfEnvDec, 68);
				Mopho.cc(\lpfEnvSus, 90);
				Mopho.cc(\lpfEnvRls, 20);

				Mopho.cc(\vcaLvl, 0);
				Mopho.cc(\vcaAmnt, 90);
				Mopho.cc(\vcaVel, 127);
				Mopho.cc(\vcaEnvAtt, 0);
				Mopho.cc(\vcaEnvDec, 90);
				Mopho.cc(\vcaEnvSus, 100);
				Mopho.cc(\vcaEnvRls, 60);

				Mopho.cc('lfo1Dest', 4);
				Mopho.cc('lfo2Dest', 6);
				Mopho.cc('lfo3Dest', 8);
				Mopho.cc('lfo4Dest', 10);
				Mopho.cc('lfo1Amnt', 22);
				Mopho.cc('lfo2Amnt', 12);
				Mopho.cc('lfo3Amnt', 33);
				Mopho.cc('lfo4Amnt', 42);
				Mopho.cc('lfo1Freq', 1);
				Mopho.cc('lfo2Freq', 3);
				Mopho.cc('lfo3Freq', 4);
				Mopho.cc('lfo4Freq', 2);
				Mopho.cc('lfo1Shape', 1);
				Mopho.cc('lfo2Shape', 6);
				Mopho.cc('lfo3Shape', 4);
				Mopho.cc('lfo4Shape', 2);
				Mopho.cc('lfo1KeySync', 1);
				Mopho.cc('lfo2KeySync', 1);
				Mopho.cc('lfo3KeySync', 1);
				Mopho.cc('lfo4KeySync', 1);

				Mopho.cc(\env3Amnt, 127);
				Mopho.cc('env3Dest', 3);
				Mopho.cc(\env3Vel, 27);
				Mopho.cc(\env3Att, 0);
				Mopho.cc(\env3Dec, 0);
				Mopho.cc(\env3Sus, 0);
				Mopho.cc(\env3Rls, 0);
				Mopho.cc('mod1Dest', 0);
				Mopho.cc('mod2Dest', 0);
				Mopho.cc('mod3Dest', 0);
				Mopho.cc('mod4Dest', 0);
				Mopho.cc('mod1Src', 0);
				Mopho.cc('mod2Src', 0);
				Mopho.cc('mod3Src', 0);
				Mopho.cc('mod4Src', 0);
				Mopho.cc(\mod1Amnt, 127);
				Mopho.cc(\mod2Amnt, 127);
				Mopho.cc(\mod3Amnt, 127);
				Mopho.cc(\mod4Amnt, 127);
			},
		)
	}
	*rand{|key,min=0,max=1|
		key.switch(
			'oscs',{
				Mopho.cc(\osc1Freq, (0..127).choose);
				Mopho.cc(\osc1Tune, (0..103).choose);
				Mopho.cc(\osc1Shape, (0..127).choose);
				Mopho.cc(\osc1Glide, (0..127).choose);
				Mopho.cc(\osc1Sub, (0..127).choose);
				Mopho.cc(\osc1Kybrd, [0,1].choose);
				Mopho.cc(\osc2Freq, (0..127).choose);
				Mopho.cc(\osc2Tune, (0..103).choose);
				Mopho.cc(\osc2Shape, (0..127).choose);
				Mopho.cc(\osc2Glide, (0..127).choose);
				Mopho.cc(\osc2Sub, (0..127).choose);
				Mopho.cc(\osc2Kybrd, [0,1].choose);

				Mopho.cc(\oscMix, (0..127).choose);
				Mopho.cc(\extIn, (0..127).choose);
				Mopho.cc(\noise, (0..127).choose);
				Mopho.cc(\oscSync, [0,1].choose);
				Mopho.cc(\oscSlop, (0..5).choose);
				Mopho.cc(\keyMode, (0..5).choose);
				Mopho.cc(\glideMode, (0..3).choose);
			},
			'filt',{
				Mopho.cc(\lpfFreq, (0..127).choose);
				Mopho.cc(\lpfRes, (0..127).choose);
				Mopho.cc(\lpfAmnt, (0..127).choose);
				Mopho.cc(\lpfVel, (0..127).choose);
				Mopho.cc(\lpfKeyAmnt, (0..127).choose);
				Mopho.cc(\lpfAudMod, (0..127).choose);
				Mopho.cc(\lpfPole, [0,1].choose);
				Mopho.cc(\lpfEnvAtt, (0..127).choose);
				Mopho.cc(\lpfEnvDec, (0..127).choose);
				Mopho.cc(\lpfEnvSus, (0..127).choose);
				Mopho.cc(\lpfEnvRls, (0..127).choose);

			},
			'vca',{
				Mopho.cc(\vcaLvl, (0..127).choose);
				Mopho.cc(\vcaAmnt, (0..127).choose);
				Mopho.cc(\vcaVel, (0..127).choose);
				Mopho.cc(\vcaEnvAtt, (0..127).choose);
				Mopho.cc(\vcaEnvDec, (0..127).choose);
				Mopho.cc(\vcaEnvSus, (0..127).choose);
				Mopho.cc(\vcaEnvRls, (0..127).choose);

			},
			'lfo', {

				Mopho.cc('lfo1Dest', (0..46).choose);
				Mopho.cc('lfo2Dest', (0..46).choose);
				Mopho.cc('lfo3Dest', (0..46).choose);
				Mopho.cc('lfo4Dest', (0..46).choose);
				Mopho.cc('lfo1Amnt', (0..127).choose);
				Mopho.cc('lfo2Amnt', (0..127).choose);
				Mopho.cc('lfo3Amnt', (0..127).choose);
				Mopho.cc('lfo4Amnt', (0..127).choose);
				Mopho.cc('lfo1Freq', (0..127).choose);
				Mopho.cc('lfo2Freq', (0..127).choose);
				Mopho.cc('lfo3Freq', (0..127).choose);
				Mopho.cc('lfo4Freq', (0..127).choose);
				Mopho.cc('lfo1Shape', (0..4).choose);
				Mopho.cc('lfo2Shape', (0..4).choose);
				Mopho.cc('lfo3Shape', (0..4).choose);
				Mopho.cc('lfo4Shape', (0..4).choose);
				Mopho.cc('lfo1KeySync', [0,1].choose);
				Mopho.cc('lfo2KeySync', [0,1].choose);
				Mopho.cc('lfo3KeySync', [0,1].choose);
				Mopho.cc('lfo4KeySync', [0,1].choose);
			},
			'mod', {
				Mopho.cc('env3Dest', (0..46).choose);
				Mopho.cc(\env3Amnt, (0..254).choose);
				Mopho.cc(\env3Vel, (0..127).choose);
				Mopho.cc(\env3Att, (0..127).choose);
				Mopho.cc(\env3Dec, (0..127).choose);
				Mopho.cc(\env3Sus, (0..127).choose);
				Mopho.cc(\env3Rls, (0..127).choose);
				Mopho.cc('mod1Dest', (0..46).choose);
				Mopho.cc('mod2Dest', (0..46).choose);
				Mopho.cc('mod3Dest', (0..46).choose);
				Mopho.cc('mod4Dest', (0..46).choose);
				Mopho.cc('mod1Src', (0..22).choose);
				Mopho.cc('mod2Src', (0..22).choose);
				Mopho.cc('mod3Src', (0..22).choose);
				Mopho.cc('mod4Src', (0..22).choose);
				Mopho.cc(\mod1Amnt, (0..254).choose);
				Mopho.cc(\mod2Amnt, (0..254).choose);
				Mopho.cc(\mod3Amnt, (0..254).choose);
				Mopho.cc(\mod4Amnt, (0..254).choose);
			}
		);
	}//rand
	*randSmooth{|key,min=0,max=1|
		key.switch(
			'oscs',{
				Mopho.cc(\osc1Freq, (40..80).choose);
				Mopho.cc(\osc1Tune, (0..103).choose);
				Mopho.cc(\osc1Shape, (0..100).choose);
				Mopho.cc(\osc1Glide, (0..100).choose);
				Mopho.cc(\osc1Sub, (0..90).choose);
				Mopho.cc(\osc1Kybrd, [0,1].choose);
				Mopho.cc(\osc2Freq, (50..70).choose);
				Mopho.cc(\osc2Tune, (0..103).choose);
				Mopho.cc(\osc2Shape, (0..107).choose);
				Mopho.cc(\osc2Glide, (0..127).choose);
				Mopho.cc(\osc2Sub, (0..70).choose);
				Mopho.cc(\osc2Kybrd, [0,1].choose);

				Mopho.cc(\oscMix, (40..100).choose);
				Mopho.cc(\extIn, (0..107).choose);
				//Mopho.cc(\noise, (0..127).choose);
				Mopho.cc(\oscSync, [0,1].choose);
				Mopho.cc(\oscSlop, (0..5).choose);
				Mopho.cc(\keyMode, (0..5).choose);
				Mopho.cc(\glideMode, (0..3).choose);
			},
			'filt',{
				Mopho.cc(\lpfFreq, (30..97).choose);
				Mopho.cc(\lpfRes, (0..77).choose);
				Mopho.cc(\lpfAmnt, (0..107).choose);
				Mopho.cc(\lpfVel, (0..127).choose);
				Mopho.cc(\lpfKeyAmnt, (0..127).choose);
				Mopho.cc(\lpfAudMod, (0..127).choose);
				Mopho.cc(\lpfPole, [0,1].choose);
				Mopho.cc(\lpfEnvAtt, (0..67).choose);
				Mopho.cc(\lpfEnvDec, (10..107).choose);
				Mopho.cc(\lpfEnvSus, (0..117).choose);
				Mopho.cc(\lpfEnvRls, (10..127).choose);

			},
			'vca',{
				Mopho.cc(\vcaLvl, (0..127).choose);
				Mopho.cc(\vcaAmnt, (0..127).choose);
				Mopho.cc(\vcaVel, (40..127).choose);
				Mopho.cc(\vcaEnvAtt, (0..27).choose);
				Mopho.cc(\vcaEnvDec, (10..127).choose);
				Mopho.cc(\vcaEnvSus, (20..97).choose);
				Mopho.cc(\vcaEnvRls, (0..77).choose);

			},
			'lfo', {

				Mopho.cc('lfo1Dest', (0..46).choose);
				Mopho.cc('lfo2Dest', (0..46).choose);
				Mopho.cc('lfo3Dest', (0..46).choose);
				Mopho.cc('lfo4Dest', (0..46).choose);
				Mopho.cc('lfo1Amnt', (0..127).choose);
				Mopho.cc('lfo2Amnt', (0..127).choose);
				Mopho.cc('lfo3Amnt', (0..127).choose);
				Mopho.cc('lfo4Amnt', (0..127).choose);
				Mopho.cc('lfo1Freq', (0..127).choose);
				Mopho.cc('lfo2Freq', (0..127).choose);
				Mopho.cc('lfo3Freq', (0..127).choose);
				Mopho.cc('lfo4Freq', (0..127).choose);
				Mopho.cc('lfo1Shape', (0..4).choose);
				Mopho.cc('lfo2Shape', (0..4).choose);
				Mopho.cc('lfo3Shape', (0..4).choose);
				Mopho.cc('lfo4Shape', (0..4).choose);
				Mopho.cc('lfo1KeySync', [0,1].choose);
				Mopho.cc('lfo2KeySync', [0,1].choose);
				Mopho.cc('lfo3KeySync', [0,1].choose);
				Mopho.cc('lfo4KeySync', [0,1].choose);
			},
			'mod', {
				Mopho.cc('env3Dest', (0..46).choose);
				Mopho.cc(\env3Amnt, (0..254).choose);
				Mopho.cc(\env3Vel, (0..127).choose);
				Mopho.cc(\env3Att, (0..127).choose);
				Mopho.cc(\env3Dec, (0..127).choose);
				Mopho.cc(\env3Sus, (0..127).choose);
				Mopho.cc(\env3Rls, (0..127).choose);
				Mopho.cc('mod1Dest', (0..46).choose);
				Mopho.cc('mod2Dest', (0..46).choose);
				Mopho.cc('mod3Dest', (0..46).choose);
				Mopho.cc('mod4Dest', (0..46).choose);
				Mopho.cc('mod1Src', (0..22).choose);
				Mopho.cc('mod2Src', (0..22).choose);
				Mopho.cc('mod3Src', (0..22).choose);
				Mopho.cc('mod4Src', (0..22).choose);
				Mopho.cc(\mod1Amnt, (0..254).choose);
				Mopho.cc(\mod2Amnt, (0..254).choose);
				Mopho.cc(\mod3Amnt, (0..254).choose);
				Mopho.cc(\mod4Amnt, (0..254).choose);
			}
		);
	}//randSmooth
	*oscs{|osc1Freq,osc1Tune,osc1Shape,osc1Glide,osc1Sub,osc1Kybrd,
		osc2Freq,osc2Tune,osc2Shape,osc2Glide,osc2Sub,osc2Kybrd,
		oscMix,extIn,noise,oscSync,oscSlop,keyMode,glideMode|
		Mopho.cc(\osc1Freq, osc1Freq);
		Mopho.cc(\osc1Tune, osc1Tune);
		Mopho.cc(\osc1Shape, osc1Shape);
		Mopho.cc(\osc1Glide, osc1Glide);
		Mopho.cc(\osc1Sub, osc1Sub);
		Mopho.cc(\osc1Kybrd, osc1Kybrd);
		Mopho.cc(\osc2Freq, osc2Freq);
		Mopho.cc(\osc2Tune, osc2Tune);
		Mopho.cc(\osc2Shape, osc2Shape);
		Mopho.cc(\osc2Glide, osc2Glide);
		Mopho.cc(\osc2Sub, osc2Sub);
		Mopho.cc(\osc2Kybrd, osc2Kybrd);

		Mopho.cc(\oscMix, oscMix);
		Mopho.cc(\extIn, extIn);
		Mopho.cc(\noise, noise);
		Mopho.cc(\oscSync, oscSync);
		Mopho.cc(\oscSlop, oscSlop);
		Mopho.cc(\keyMode, keyMode);
		Mopho.cc(\glideMode, glideMode);
	}
	*vcas{|vcaLvl,vcaAmnt,vcaVel,vcaEnvAtt,vcaEnvDec,vcaEnvSus,vcaEnvRls,
		lpfFreq,lpfRes,lpfAmnt,lpfVel,lpfKeyAmnt,lpfAudMod,lpfPole,
		lpfEnvAtt,lpfEnvDec,lpfEnvSus,lpfEnvRls|
		Mopho.cc(\vcaLvl, vcaLvl);
		Mopho.cc(\vcaAmnt, vcaAmnt);
		Mopho.cc(\vcaVel, vcaVel);
		Mopho.cc(\vcaEnvAtt, vcaEnvAtt);
		Mopho.cc(\vcaEnvDec, vcaEnvDec);
		Mopho.cc(\vcaEnvSus, vcaEnvSus);
		Mopho.cc(\vcaEnvRls, vcaEnvRls);
		Mopho.cc(\lpfFreq, lpfFreq);
		Mopho.cc(\lpfRes, lpfRes);
		Mopho.cc(\lpfAmnt, lpfAmnt);
		Mopho.cc(\lpfVel, lpfVel);
		Mopho.cc(\lpfKeyAmnt, lpfKeyAmnt);
		Mopho.cc(\lpfAudMod, lpfAudMod);
		Mopho.cc(\lpfPole, lpfPole);
		Mopho.cc(\lpfEnvAtt, lpfEnvAtt);
		Mopho.cc(\lpfEnvDec, lpfEnvDec);
		Mopho.cc(\lpfEnvSus, lpfEnvSus);
		Mopho.cc(\lpfEnvRls, lpfEnvRls);
	}
	*lfos{|lfo1Dest,lfo2Dest,lfo3Dest,lfo4Dest,lfo1Amnt,lfo2Amnt,lfo3Amnt,lfo4Amnt,
		lfo1Freq,lfo2Freq,lfo3Freq,lfo4Freq,lfo1Shape,lfo2Shape,lfo3Shape,lfo4Shape,
		lfo1KeySync,lfo2KeySync,lfo3KeySync,lfo4KeySync|
		Mopho.cc('lfo1Dest', lfo1Dest);
		Mopho.cc('lfo2Dest', lfo2Dest);
		Mopho.cc('lfo3Dest', lfo3Dest);
		Mopho.cc('lfo4Dest', lfo4Dest);
		Mopho.cc('lfo1Amnt', lfo1Amnt);
		Mopho.cc('lfo2Amnt', lfo2Amnt);
		Mopho.cc('lfo3Amnt', lfo3Amnt);
		Mopho.cc('lfo4Amnt', lfo4Amnt);
		Mopho.cc('lfo1Freq', lfo1Freq);
		Mopho.cc('lfo2Freq', lfo2Freq);
		Mopho.cc('lfo3Freq', lfo3Freq);
		Mopho.cc('lfo4Freq', lfo4Freq);
		Mopho.cc('lfo1Shape', lfo1Shape);
		Mopho.cc('lfo2Shape', lfo2Shape);
		Mopho.cc('lfo3Shape', lfo3Shape);
		Mopho.cc('lfo4Shape', lfo4Shape);
		Mopho.cc('lfo1KeySync', lfo1KeySync);
		Mopho.cc('lfo2KeySync', lfo2KeySync);
		Mopho.cc('lfo3KeySync', lfo3KeySync);
		Mopho.cc('lfo4KeySync', lfo4KeySync);
	}
	*mods{|env3Dest,env3Amnt,env3Vel,env3Att,env3Dec,env3Sus,env3Rls,
		mod1Dest,mod2Dest,mod3Dest,mod4Dest,mod1Src,mod2Src,mod3Src,mod4Src,
		mod1Amnt,mod2Amnt,mod3Amnt,mod4Amnt|
		Mopho.cc('env3Dest', env3Dest);
		Mopho.cc(\env3Amnt, env3Amnt);
		Mopho.cc(\env3Vel, env3Vel);
		Mopho.cc(\env3Att, env3Att);
		Mopho.cc(\env3Dec, env3Dec);
		Mopho.cc(\env3Sus, env3Sus);
		Mopho.cc(\env3Rls, env3Rls);
		Mopho.cc('mod1Dest', mod1Dest);
		Mopho.cc('mod2Dest', mod2Dest);
		Mopho.cc('mod3Dest', mod3Dest);
		Mopho.cc('mod4Dest', mod4Dest);
		Mopho.cc('mod1Src', mod1Src);
		Mopho.cc('mod2Src', mod2Src);
		Mopho.cc('mod3Src', mod3Src);
		Mopho.cc('mod4Src', mod4Src);
		Mopho.cc(\mod1Amnt, mod1Amnt);
		Mopho.cc(\mod2Amnt, mod2Amnt);
		Mopho.cc(\mod3Amnt, mod3Amnt);
		Mopho.cc(\mod4Amnt, mod4Amnt);
	}
	*oscResp{|respName,oscName,playDir|
		var currentBpm=1;
		OSCdef(respName, {|msg|
			var val,vel;
			val=msg[1];
			vel=val*127;
			playDir.switch(
				'MPHsetRandT',{
					if ( val==1, {
						MophoSet.rand(\oscs);
						MophoSet.rand(\filt);
						MophoSet.rand(\vca);
						MophoSet.rand(\lfo);
						MophoSet.rand(\mod);
					})
				},
				'MPHsetDfltT',{
					if ( val==1, {MophoSet(\default);})
				},
			)
		},path:oscName);
	}
	*makeOSCResps{
		this.oscResp(respName:'MPHsetRandResp', oscName:'MPHsetRand', playDir:'MPHsetRandT');
		this.oscResp(respName:'MPHsetDfltResp', oscName:'MPHsetDflt', playDir:'MPHsetDfltT');

	}

}

IFTxtMophoSet{
	classvar <>file;
	*crtRndLines{|trck,prt,inst|
		var cnt=1, min=0,max=1, seq,rtSeq;
		var frq1=[12,24,36,48],frq2=(12..48);
		var shp=(0..103),hlf=(0..103),sub=(0..64);
		var dflt=(0..127),tune=(0..103),one=[0,1],five=(0..5),three=(0..3);
		var dest=(0..46),four=(0..4),src=(0..22),amnt=(0..254);

		var osc1Freq,osc1Tune,osc1Shape,osc1Glide,osc1Sub,osc1Kybrd;
		var osc2Freq,osc2Tune,osc2Shape,osc2Glide,osc2Sub,osc2Kybrd;
		var oscMix,extIn,noise,oscSync,oscSlop,  keyMode,glideMode;
		var vcaLvl,vcaAmnt,vcaVel,vcaEnvAtt,vcaEnvDec,vcaEnvSus,vcaEnvRls;
		var lpfFreq,lpfRes,lpfAmnt,lpfVel,lpfKeyAmnt,lpfAudMod,lpfPole;
		var lpfEnvAtt,lpfEnvDec,lpfEnvSus,lpfEnvRls;
		var lfo1Dest,lfo2Dest,lfo3Dest,lfo4Dest,lfo1Amnt,lfo2Amnt,lfo3Amnt,lfo4Amnt;
		var lfo1Freq,lfo2Freq,lfo3Freq,lfo4Freq,lfo1Shape,lfo2Shape,lfo3Shape,lfo4Shape;
		var lfo1KeySync,lfo2KeySync,lfo3KeySync,lfo4KeySync;
		var env3Dest,env3Amnt,env3Vel,env3Att,env3Dec,env3Sus,env3Rls;
		var mod1Dest,mod2Dest,mod3Dest,mod4Dest,mod1Src,mod2Src,mod3Src,mod4Src;
		var mod1Amnt,mod2Amnt,mod3Amnt,mod4Amnt;

		osc1Freq=frq1.choose; osc1Tune=tune.choose; osc1Shape=shp.choose;
		osc1Glide=dflt.choose; osc1Sub=dflt.choose; osc1Kybrd=one.choose;
		osc2Freq=frq2.choose; osc2Tune=tune.choose; osc2Shape=shp.choose;
		osc2Glide=dflt.choose; osc2Sub=dflt.choose; osc2Kybrd=one.choose;
		oscMix=dflt.choose; extIn=dflt.choose; noise=0;
		oscSync=one.choose; oscSlop=five.choose; keyMode=five.choose; glideMode=three.choose;

		vcaLvl=dflt.choose;vcaAmnt=dflt.choose;vcaVel=dflt.choose;
		vcaEnvAtt=dflt.choose;vcaEnvDec=dflt.choose;vcaEnvSus=dflt.choose;vcaEnvRls=dflt.choose;
		lpfFreq=(0..20).choose;lpfRes=(0..15).choose;lpfAmnt=0;lpfVel=hlf.choose;
		lpfKeyAmnt=hlf.choose;lpfAudMod=dflt.choose;lpfPole=one.choose;
		lpfEnvAtt=(0..20).choose;lpfEnvDec=(20..90).choose;lpfEnvSus=dflt.choose;lpfEnvRls=dflt.choose;

		lfo1Dest=dest.choose; lfo2Dest=dest.choose; lfo3Dest=dest.choose; lfo4Dest=dest.choose;
		lfo1Amnt=dflt.choose; lfo2Amnt=dflt.choose; lfo3Amnt=dflt.choose; lfo4Amnt=dflt.choose;
		lfo1Freq=dflt.choose; lfo2Freq=dflt.choose; lfo3Freq=dflt.choose; lfo4Freq=dflt.choose;
		lfo1Shape=four.choose;lfo2Shape=four.choose;lfo3Shape=four.choose;lfo4Shape=four.choose;
		lfo1KeySync=one.choose;lfo2KeySync=one.choose;lfo3KeySync=one.choose;lfo4KeySync=one.choose;

		env3Dest=dest.choose;env3Amnt=amnt.choose;
		env3Vel=dflt.choose;env3Att=dflt.choose;env3Dec=dflt.choose;env3Sus=dflt.choose;env3Rls=dflt.choose;
		mod1Dest=dest.choose;mod2Dest=dest.choose;mod3Dest=dest.choose;mod4Dest=dest.choose;
		mod1Src=src.choose;mod2Src=src.choose;mod3Src=src.choose;mod4Src=src.choose;
		mod1Amnt=amnt.choose;mod2Amnt=amnt.choose;mod3Amnt=amnt.choose;mod4Amnt=amnt.choose;

		rtSeq=Pseq([
			//oscs
			osc1Freq,osc1Tune,osc1Shape,osc1Glide,osc1Sub,osc1Kybrd,
			osc2Freq,osc2Tune,osc2Shape,osc2Glide,osc2Sub,osc2Kybrd,
			oscMix,extIn,noise,oscSync,oscSlop,keyMode,glideMode,glideMode,
			//vcas
			vcaLvl,vcaAmnt,vcaVel,vcaEnvAtt,vcaEnvDec,vcaEnvSus,vcaEnvRls,
			lpfFreq,lpfRes,lpfAmnt,lpfVel,lpfKeyAmnt,lpfAudMod,lpfPole,
			lpfEnvAtt,lpfEnvDec,lpfEnvSus,lpfEnvRls,lpfEnvRls,lpfEnvRls,
			//lfos
			lfo1Dest,lfo2Dest,lfo3Dest,lfo4Dest,lfo1Amnt,lfo2Amnt,lfo3Amnt,lfo4Amnt,
			lfo1Freq,lfo1Freq,lfo1Freq,lfo1Freq,lfo1Shape,lfo2Shape,lfo3Shape,lfo4Shape,
			lfo1KeySync,lfo2KeySync,lfo3KeySync,lfo4KeySync,
			//mods
			env3Dest,env3Amnt,env3Vel,env3Att,env3Dec,env3Sus,env3Rls,
			mod1Dest,mod2Dest,mod3Dest,mod4Dest,mod1Src,mod2Src,mod3Src,mod4Src,
			mod1Amnt,mod2Amnt,mod3Amnt,mod4Amnt,mod4Amnt
		],inf).asStream;
		fork{
			IFTxt.ifPath(trck,prt,inst);
			file=File.new(IFTxt.ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..80).do{|n|
				case
				{cnt>=1&&cnt<=80}{seq=rtSeq.next;};
				file.write(seq.asString ++ if (n % 20 != 0, ",", Char.nl));
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}
	*make{|trck,prt,inst,lines|
		lines.switch(
			'rndMophoSetTag',{
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
		IFTxtMophoSet.make(\01,\00,\ifMophoSet,'rndMophoSetTag');
	}
	*read{|trck,prtDir|

		IFTxt.readIfTrack(trck,prtDir,\ifMophoSet);
		~tMpO=IFTxt.line(1);
		~tMpV=IFTxt.line(2);
		~tMpL=IFTxt.line(3);
		~tMpM=IFTxt.line(4);
		this.storeVals;
	}
	*storeVals{//////
		"Store MophoSet Values from Txt to Patterns ".postln;
		//[ MophoSet ]//MophoSetic Drum
		MophoSet.oscs  (
			~tMpO[0],~tMpO[1],~tMpO[2],~tMpO[3],
			~tMpO[4],~tMpO[5],~tMpO[6],~tMpO[7],
			~tMpO[8],~tMpO[9],~tMpO[10],~tMpO[11],
			~tMpO[12],~tMpO[13],~tMpO[14],~tMpO[15],
			~tMpO[16],~tMpO[17],~tMpO[18],
		);
		MophoSet.vcas  (
			~tMpV[0],~tMpV[1],~tMpV[2],~tMpV[3],
			~tMpV[4],~tMpV[5],~tMpV[6],~tMpV[7],
			~tMpV[8],~tMpV[9],~tMpV[10],~tMpV[11],
			~tMpV[12],~tMpV[13],~tMpV[14],~tMpV[15],
			~tMpV[16],~tMpV[17],
		);
		MophoSet.lfos  (
			~tMpL[0],~tMpL[1],~tMpL[2],~tMpL[3],
			~tMpL[4],~tMpL[5],~tMpL[6],~tMpL[7],
			~tMpL[8],~tMpL[9],~tMpL[10],~tMpL[11],
			~tMpL[12],~tMpL[13],~tMpL[14],~tMpL[15],
			~tMpL[16],~tMpL[17],~tMpL[18],~tMpL[19],
		);
		MophoSet.mods  (
			~tMpM[0],~tMpM[1],~tMpM[2],~tMpM[3],
			~tMpM[4],~tMpM[5],~tMpM[6],~tMpM[7],
			~tMpM[8],~tMpM[9],~tMpM[10],~tMpM[11],
			~tMpM[12],~tMpM[13],~tMpM[14],~tMpM[15],
			~tMpM[16],~tMpM[17],~tMpM[18],
		);
	}//////
}

/*
Mopho.cc(\osc1Freq, 24);
Mopho.cc(\osc2Freq, 48);
Mopho.cc(\osc1Tune, (0..103).choose);

*/