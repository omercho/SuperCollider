/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

//ALL MIDI NOTES

// SC Channel 0 = Abl Channel 1
// SC Control 1 = Abl Control 1

//Channel, ControlNumber CC

//to find the MIDIOut srcID of sources
~mdOut.uid;
~mdTouch.uid;
~apc40.uid;
~iC_iPad=

//to find MIDIIn src
(
c = NoteOnResponder({ |src,chan,note,vel|
        [src,chan,note,vel].postln;
    });
    c.learn; // wait for the first note
)
NoteOnResponder.removeAll
*/
~midiVel=127;

//----Ableton


~mdOut.control(0, 60, ~midiVel); //Mel Audio / High
~mdOut.control(0, 61, ~midiVel); //Mel Audio / Mid
~mdOut.control(0, 62, ~midiVel); //Mel Audio / Low

~mdOut.control(0, 71, ~midiVel); //SampSetTrack 01
~mdOut.control(0, 72, ~midiVel); //SampSetTrack 02
~mdOut.control(0, 73, ~midiVel); //SampSetTrack 03
~mdOut.control(0, 74, ~midiVel); //SampSetTrack 04
~mdOut.control(0, 75, ~midiVel); //SampSetTrack 05
~mdOut.control(0, 76, ~midiVel); //SampSetTrack 06
~mdOut.control(0, 77, ~midiVel); //SampSetTrack 07
~mdOut.control(0, 78, ~midiVel); //SampSetTrack 08

~mdOut.control(0, 81, ~midiVel); //ExtSetTrack 01
~mdOut.control(0, 82, ~midiVel); //ExtSetTrack 02
~mdOut.control(0, 83, ~midiVel); //ExtSetTrack 03
~mdOut.control(0, 84, ~midiVel); //ExtSetTrack 04
~mdOut.control(0, 85, ~midiVel); //ExtSetTrack 05
~mdOut.control(0, 86, ~midiVel); //ExtSetTrack 06
~mdOut.control(0, 87, ~midiVel); //ExtSetTrack 07
~mdOut.control(0, 88, ~midiVel); //ExtSetTrack 08

~mdOut.control(1, 0, ~midiVel); //AllMaster / Track Vol
~mdOut.control(1, 1, ~midiVel); //AllMaster / Speaker On
~mdOut.control(1, 2, ~midiVel); //AllMaster / BeatRep DevOn
~mdOut.control(1, 3, ~midiVel); //AllMasterFX / BeatRep DevOn
//~mdOut.control(1, 4, ~midiVel); //AllMaster / Send A
//~mdOut.control(1, 5, ~midiVel); //AllMaster / Send B
~mdOut.control(1, 6, ~midiVel); //AllMasterFX / Speaker On
~mdOut.control(1, 127, ~midiVel); //AllMasterFX / Track Vol
~mdOut.control(1, 8, ~midiVel); //AllMasterFX /
~mdOut.control(1, 9, ~midiVel); //AllMasterFX / Y1
~mdOut.control(1, 10, ~midiVel); //AllMasterFX / X1
~mdOut.control(1, 11, ~midiVel); //AllMasterFX / Distort
~mdOut.control(1, 12, ~midiVel); //AllMaster / Grain
~mdOut.control(1, 13, ~midiVel); //AllMaster / Send C

~mdOut.control(2, 0, ~midiVel); //Kick / Mute
~mdOut.control(2, 1, ~midiVel); //Kick / Vol
~mdOut.control(2, 2, ~midiVel); //Kick / Activ (MIDIIN)
~mdOut.control(2, 3, ~midiVel); //Kick / SendA
~mdOut.control(2, 4, ~midiVel); //Kick / SendB
~mdOut.control(2, 5, ~midiVel); //Kick / Att
~mdOut.control(2, 6, ~midiVel); //Kick / Sus
~mdOut.control(2, 127, ~midiVel); //Kick / Dec/Rel
~mdOut.control(2, 8, ~midiVel); //Kick / Chain
~mdOut.control(2, 9, ~midiVel); //Kick / TimeMul (MIDIIN)
~mdOut.control(2, 10, ~midiVel); //Kick / SendC
~mdOut.control(2, 11, ~midiVel); //Kick / Act Delay-Filter LFO
~mdOut.control(2, 12, ~midiVel); //Kick / Act Delay-Filter LFO
~mdOut.control(2, 13, ~midiVel); //Kick / Act Delay-Filter LFO
~mdOut.control(2, 14, ~midiVel); //Kick / Act Delay-Filter LFO

~mdOut.control(3, 0, ~midiVel); //Snr / Mute
~mdOut.control(3, 1, ~midiVel); //Snr / Vol
~mdOut.control(3, 2, ~midiVel); //Snr / Activ (MIDIIN)
~mdOut.control(3, 3, ~midiVel); //Snr / SendA
~mdOut.control(3, 4, ~midiVel); //Snr / SendB
~mdOut.control(3, 5, ~midiVel); //Snr / Att
~mdOut.control(3, 6, ~midiVel); //Snr / Sus
~mdOut.control(3, 127, ~midiVel); //Snr / Dec/Rel
~mdOut.control(3, 8, ~midiVel); //Snr / Chain
~mdOut.control(3, 9, ~midiVel); //Snr / TimeMul (MIDIIN)
~mdOut.control(3, 10, ~midiVel); //Snr / SendC
~mdOut.control(3, 11, ~midiVel); //Snr / Act Delay-Filter LFO
~mdOut.control(3, 12, ~midiVel); //Snr / Act Delay-Filter LFO
~mdOut.control(3, 13, ~midiVel); //Snr / Act Delay-Filter LFO
~mdOut.control(3, 14, ~midiVel); //Snr / Act Delay-Filter LFO
~mdOut.control(3, 15, ~midiVel); //Snr / NoteFader XGlobal

~mdOut.control(4, 0, ~midiVel); //Hat / Mute
~mdOut.control(4, 1, ~midiVel); //Hat / Vol
~mdOut.control(4, 2, ~midiVel); //Hat / Activ (MIDIIN)
~mdOut.control(4, 3, ~midiVel); //Hat / SendA
~mdOut.control(4, 4, ~midiVel); //Hat / SendB
~mdOut.control(4, 5, ~midiVel); //Hat / Att
~mdOut.control(4, 6, ~midiVel); //Hat / Sus
~mdOut.control(4, 127, ~midiVel); //Hat / Dec/Rel
~mdOut.control(4, 8, ~midiVel); //Hat / Chain
~mdOut.control(4, 9, ~midiVel); //Hat / TimeMul (MIDIIN)
~mdOut.control(4, 10, ~midiVel); //Hat / SendC
~mdOut.control(4, 11, ~midiVel); //Hat / Act Delay-Filter LFO

~mdOut.control(5, 0, ~midiVel); //Bass / Mute
~mdOut.control(5, 1, ~midiVel); //Bass / Vol
~mdOut.control(5, 2, ~midiVel); //Bass / Activ (MIDIIN)
~mdOut.control(5, 3, ~midiVel); //Bass / SendA
~mdOut.control(5, 4, ~midiVel); //Bass / SendB
~mdOut.control(5, 5, ~midiVel); //Bass / Att
~mdOut.control(5, 6, ~midiVel); //Bass / Sus
~mdOut.control(5, 127, ~midiVel); //Bass / Dec/Rel
~mdOut.control(5, 8, ~midiVel); //Bass / Chain
~mdOut.control(5, 9, ~midiVel); //Bass / TimeMul (MIDIIN)
~mdOut.control(5, 10, ~midiVel); //Bass / SendC


~mdOut.control(5, 11, ~midiVel); //Bass / xy1X
~mdOut.control(5, 12, ~midiVel); //Bass / xy1Y
~mdOut.control(5, 13, ~midiVel); //IFBass / Cut X
~mdOut.control(5, 14, ~midiVel); //IFBass / Cut Y
~mdOut.control(5, 15, ~midiVel); //Bass / Act Delay-Filter LFO
~mdOut.control(5, 40, ~midiVel); //IFBass / lfo 1
~mdOut.control(5, 41, ~midiVel); //IFBass / lfo 2


~mdOut.control(6, 0, ~midiVel); //Keys / Mute
~mdOut.control(6, 1, ~midiVel); //Keys / Vol
~mdOut.control(6, 2, ~midiVel); //Keys / Activ (MIDIIN)
~mdOut.control(6, 3, ~midiVel); //Keys / SendA
~mdOut.control(6, 4, ~midiVel); //Keys / SendB
~mdOut.control(6, 5, ~midiVel); //Keys / Att
~mdOut.control(6, 6, ~midiVel); //Keys / Sus
~mdOut.control(6, 127, ~midiVel); //Keys / Dec/Rel
~mdOut.control(6, 8, ~midiVel); //Keys / Chain
~mdOut.control(6, 9, ~midiVel); //Keys / TimeMul (MIDIIN)
~mdOut.control(6, 10, ~midiVel); //Keys / SendC

~mdOut.control(6, 11, ~midiVel); //Keys / xy1X
~mdOut.control(6, 12, ~midiVel); //Keys / xy1Y
~mdOut.control(6, 13, ~midiVel); //IFKeys / Cut X
~mdOut.control(6, 14, ~midiVel); //IFKeys / Cut Y
~mdOut.control(6, 15, ~midiVel); //Keys / Act Delay-Filter LFO
~mdOut.control(6, 40, ~midiVel); //IFKeys / lfo 1
~mdOut.control(6, 41, ~midiVel); //IFKeys / lfo 2

~mdOut.control(7, 0, ~midiVel); //Samp / Mute
~mdOut.control(7, 1, ~midiVel); //Samp / Vol
~mdOut.control(7, 2, ~midiVel); //Samp / Activ (MIDIIN)
~mdOut.control(7, 3, ~midiVel); //Samp / SendA
~mdOut.control(7, 4, ~midiVel); //Samp / SendB
~mdOut.control(7, 5, ~midiVel); //Samp / Att
~mdOut.control(7, 6, ~midiVel); //Samp / Sus
~mdOut.control(7, 127, ~midiVel); //Samp / Dec/Rel
~mdOut.control(7, 8, ~midiVel); //Samp / Chain
~mdOut.control(7, 9, ~midiVel); //Samp / TimeMul (MIDIIN)
~mdOut.control(7, 10, ~midiVel); //Samp / SendC

~mdOut.control(7, 11, ~midiVel); //Samp / xy1X
~mdOut.control(7, 12, ~midiVel); //Samp / xy1Y
~mdOut.control(7, 13, ~midiVel); //IFSamp / Cut X
~mdOut.control(7, 14, ~midiVel); //IFSamp / Cut Y
~mdOut.control(7, 15, ~midiVel); //Samp / Act Delay-Filter LFO
~mdOut.control(7, 40, ~midiVel); //IFSamp / lfo 1
~mdOut.control(7, 41, ~midiVel); //IFSamp / lfo 2

~mdOut.control(8, 2, ~midiVel); //IFExt / Rls
~mdOut.control(8, 3, ~midiVel); //IFExt / SendA
~mdOut.control(8, 4, ~midiVel); //IFExt / SendB
~mdOut.control(8, 5, ~midiVel); //IFExt / SendC

~mdOut.control(8, 20, ~midiVel); //IFStaticHat Act ---- MIDIIn
~mdOut.control(8, 21, ~midiVel); //IFStaticClap Act ---- MIDIIn
~mdOut.control(8, 22, ~midiVel); //IFStatic Fad8 ---- MIDIIn

//Drum Channel
~mdOut.control(10, 23, ~midiVel); //Drum / Send A
~mdOut.control(10, 24, ~midiVel); //Drum / Send B
~mdOut.control(10, 25, ~midiVel); //Drum / Send C
~mdOut.control(10, 26, ~midiVel); //Drum Audio / Low
~mdOut.control(10, 27, ~midiVel); //Drum Audio / Mid
~mdOut.control(10, 28, ~midiVel); //Drum Audio / High
~mdOut.control(10, 30, ~midiVel); //Drum / Filt Morph
~mdOut.control(10, 31, ~midiVel); //Drum / Filt Freq
//Melody Channel
~mdOut.control(10, 73, ~midiVel); //Mel / Send A
~mdOut.control(10, 74, ~midiVel); //Mel / Send B
~mdOut.control(10, 75, ~midiVel); //Mel / Send C
~mdOut.control(10, 76, ~midiVel); //Mel Audio / Low
~mdOut.control(10, 77, ~midiVel); //Mel Audio / Mid
~mdOut.control(10, 78, ~midiVel); //Mel Audio / High

//IFMast MIDIChannel: SC_11 - Abl_12
~mdOut.control(~chMast, 0, ~midiVel); //IFMast / Activate ---- MIDIIn
~mdOut.control(~chMast, 1, ~midiVel); //IFMast / m1
~mdOut.control(~chMast, 2, ~midiVel); //IFMast / m2
~mdOut.control(~chMast, 3, ~midiVel); //IFMast / m3
~mdOut.control(~chMast, 4, ~midiVel); //IFMast / m4
~mdOut.control(~chMast, 5, ~midiVel); //IFMast / m5
~mdOut.control(~chMast, 6, ~midiVel); //IFMast / m6
~mdOut.control(~chMast, 7, ~midiVel); //IFMast / m7
~mdOut.control(~chMast, 8, ~midiVel); //IFMast / m8
~mdOut.control(~chMast, 9, ~midiVel); //IFMast / VolFader

//IFRes MIDIChannel: SC_12 - Abl_13
~mdOut.control(~chRes, 1, ~midiVel); //SendA / Res Note
~mdOut.control(~chRes, 2, ~midiVel); //SendA / Res Decay
~mdOut.control(~chRes, 3, ~midiVel); //SendA / Res ll+lll
~mdOut.control(~chRes, 4, ~midiVel); //SendA / Res lV+V
~mdOut.control(~chRes, 5, ~midiVel); //SendA / Res ColMat
~mdOut.control(~chRes, 6, ~midiVel); //SendA / Res l Gain
~mdOut.control(~chRes, 7, ~midiVel); //SendA / Res Width
~mdOut.control(~chRes, 8, ~midiVel); //SendA / Res Chain
~mdOut.control(~chRes, 9, ~midiVel); //SendA / Res Chain

//IFRev MIDIChannel: SC_13 - Abl_14
~mdOut.control(12, 1, ~midiVel); //SendB / Rev Reverb
~mdOut.control(12, 2, ~midiVel); //SendB / Rev Delay
~mdOut.control(12, 3, ~midiVel); //SendB / Rev Mac3
~mdOut.control(12, 4, ~midiVel); //SendB / Rev Mac4
~mdOut.control(12, 5, ~midiVel); //SendB / Rev Mac5
~mdOut.control(12, 6, ~midiVel); //SendB / Rev Mac6
~mdOut.control(12, 7, ~midiVel); //SendB / Rev Mac7
~mdOut.control(12, 8, ~midiVel); //SendB / Rev Chain

//Ableton Globals
~mdOut.control(15, 0, ~midiVel); //Ableton / Start
~mdOut.control(15, 1, ~midiVel); //Ableton / Stop
~mdOut.control(15, 2, ~midiVel); //Ableton / Tap Tempo
~mdOut.control(15, 3, ~midiVel); //Ableton / Song Tempo


//APC40

~apc40.noteOn(0, 98, 127); //SHIFT

// Faders
~apc40.control(0, 7, 127); //Fader1
~apc40.control(1, 7, 127); //Fader2
~apc40.control(2, 7, 127); //Fader3
~apc40.control(3, 7, 127); //Fader4
~apc40.control(4, 7, 127); //Fader5
~apc40.control(5, 7, 127); //Fader6
~apc40.control(6, 7, 127); //Fader7
~apc40.control(7, 7, 127); //Fader8
~apc40.control(0, 14, 127); //Fader Master
// Crossfade PlayStopRec Buttons
~apc40.control(0, 15, 127); //Fader Crossfade
~apc40.noteOn(0, 91, 127); //PLAY
~apc40.noteOn(0, 92, 127); //STOP
~apc40.noteOn(0, 93, 127); //REC

~apc40.control(0, 16, 127); //NobDown 1
~apc40.control(0, 17, 127); //NobDown 2
~apc40.control(0, 18, 127); //NobDown 3
~apc40.control(0, 19, 127); //NobDown 4
~apc40.control(0, 20, 127); //NobDown 5
~apc40.control(0, 21, 127); //NobDown 6
~apc40.control(0, 22, 127); //NobDown 7
~apc40.control(0, 23, 127); //NobDown 8
~apc40.control(0, 47, 127); //Nob CUE Level
~apc40.control(0, 48, 127); //NobUp 1
~apc40.control(0, 49, 127); //NobUp 2
~apc40.control(0, 50, 127); //NobUp 3
~apc40.control(0, 51, 127); //NobUp 4
~apc40.control(0, 52, 127); //NobUp 5
~apc40.control(0, 53, 127); //NobUp 6
~apc40.control(0, 54, 127); //NobUp 7
~apc40.control(0, 55, 127); //NobUp 8
//Toggles Active - Times2 - Static
~apc40.noteOn(0, 48, 127); //But 1
~apc40.noteOn(0, 49, 127); //But 2
~apc40.noteOn(0, 50, 127); //But 3
~apc40.noteOn(1, 48, 127); //But 1
~apc40.noteOn(1, 49, 127); //But 2
~apc40.noteOn(1, 50, 127); //But 3
~apc40.noteOn(2, 48, 127); //But 1
~apc40.noteOn(2, 49, 127); //But 2
~apc40.noteOn(2, 50, 127); //But 3
~apc40.noteOn(3, 48, 127); //But 1
~apc40.noteOn(3, 49, 127); //But 2
~apc40.noteOn(3, 50, 127); //But 3
~apc40.noteOn(4, 48, 127); //But 1
~apc40.noteOn(4, 49, 127); //But 2
~apc40.noteOn(4, 50, 127); //But 3
~apc40.noteOn(5, 48, 127); //But 1
~apc40.noteOn(5, 49, 127); //But 2
~apc40.noteOn(5, 50, 127); //But 3
~apc40.noteOn(6, 48, 127); //But 1
~apc40.noteOn(6, 49, 127); //But 2
~apc40.noteOn(6, 50, 127); //But 3
~apc40.noteOn(7, 48, 127); //But 1
~apc40.noteOn(7, 49, 127); //But 2
~apc40.noteOn(7, 50, 127); //But 3
//Track Selection Only One Function
~apc40.noteOn(0, 51, 1); //But 1
~apc40.noteOn(1, 51, 1); //But 2
~apc40.noteOn(2, 51, 1); //But 3
~apc40.noteOn(3, 51, 1); //But 4
~apc40.noteOn(4, 51, 1); //But 5
~apc40.noteOn(5, 51, 1); //But 6
~apc40.noteOn(6, 51, 1); //But 7
~apc40.noteOn(7, 51, 1); //But 8
~apc40.noteOn(0, 80, 1); //But Master

//Nob CUE
~apc40.control(0, 47, 127); //Nob CUE Level

~cueLev_APC.free;
~cueLev_APC=MIDIFunc.cc( {
	arg vel,led,val;
	val=0.01;
	vel.switch(
		127,{
			val;
			127.postln;
			~tOSCAdrr.sendMsg('/susMel', ~susMelLedVal=~susMelLedVal-val);
			~susMulBass=~susMulBass-val;
			~susMulKeys=~susMulKeys-val;
			~susMulSamp=~susMulSamp-val;

		},
		1,{
			val+val;
			1.postln;
			~tOSCAdrr.sendMsg('/susMel', ~susMelLedVal=~susMelLedVal+val);
			~susMulBass=~susMulBass+val;
			~susMulKeys=~susMulKeys+val;
			~susMulSamp=~susMulSamp+val;
		},
		126,{},
		125,{},
		2,{},
		3,{}
	);

},srcID:~apc40InID, chan:0, ccNum:47);


(

~nobT_APC.free;
~nobT_APC=MIDIFunc.cc( {
	arg vel,ccNum;

	ccNum.switch(
		16,{"1_".postln+vel.postln;}
	);

},srcID:~apc40InID, chan:0);

)

~temp=15
~temp=~temp+1;~mdOut.control(5, 127, ~temp); //Mel Audio / High

~apc40.control(0, 50, 90); //NobDown 1
