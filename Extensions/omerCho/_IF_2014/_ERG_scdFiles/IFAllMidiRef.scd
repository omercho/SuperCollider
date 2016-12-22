//ALL MIDI NOTES

// SC Channel 0 = Abl Channel 1
// SC Control 1 = Abl Control 1

//Channel, ControlNumber CC

~midiVel=127;

//----Ableton


~mdOut.control(0, 60, ~midiVel); //Mel Audio / High
~mdOut.control(0, 61, ~midiVel); //Mel Audio / Mid
~mdOut.control(0, 62, ~midiVel); //Mel Audio / Low

~mdOut.control(1, 0, ~midiVel); //AllMaster / Track Vol
~mdOut.control(1, 1, ~midiVel); //AllMaster / Speaker On
~mdOut.control(1, 2, ~midiVel); //AllMaster / BeatRep DevOn
~mdOut.control(1, 3, ~midiVel); //AllMasterFX / BeatRep DevOn
~mdOut.control(1, 4, ~midiVel); //AllMaster / Send A
~mdOut.control(1, 5, ~midiVel); //AllMaster / Send B
~mdOut.control(1, 6, ~midiVel); //AllMasterFX / Speaker On
~mdOut.control(1, 7, ~midiVel); //AllMasterFX / Track Vol
~mdOut.control(1, 8, ~midiVel); //AllMasterFX /
~mdOut.control(1, 9, ~midiVel); //AllMasterFX / Y1
~mdOut.control(1, 10, ~midiVel); //AllMasterFX / X1
~mdOut.control(1, 11, ~midiVel); //AllMasterFX / Distort
~mdOut.control(1, 12, ~midiVel); //AllMaster / Grain

~mdOut.control(2, 0, ~midiVel); //Kick / Mute
~mdOut.control(2, 1, ~midiVel); //Kick / Vol
~mdOut.control(2, 2, ~midiVel); //Kick / Activ (MIDIIN)
~mdOut.control(2, 3, ~midiVel); //Kick / SendA
~mdOut.control(2, 4, ~midiVel); //Kick / SendB
~mdOut.control(2, 5, ~midiVel); //Kick / Att
~mdOut.control(2, 6, ~midiVel); //Kick / Sus
~mdOut.control(2, 7, ~midiVel); //Kick / Dec/Rel
~mdOut.control(2, 8, ~midiVel); //Kick / Chain
    ~mdOut.control(2, 9, ~midiVel); //Kick / TimeMul (MIDIIN)

~mdOut.control(3, 0, ~midiVel); //Snr / Mute
~mdOut.control(3, 1, ~midiVel); //Snr / Vol
    ~mdOut.control(3, 2, ~midiVel); //Snr / Activ (MIDIIN)
~mdOut.control(3, 3, ~midiVel); //Snr / SendA
~mdOut.control(3, 4, ~midiVel); //Snr / SendB
~mdOut.control(3, 5, ~midiVel); //Snr / Att
~mdOut.control(3, 6, ~midiVel); //Snr / Sus
~mdOut.control(3, 7, ~midiVel); //Snr / Dec/Rel
~mdOut.control(3, 8, ~midiVel); //Snr / Chain
    ~mdOut.control(3, 9, ~midiVel); //Snr / TimeMul (MIDIIN)

~mdOut.control(4, 0, ~midiVel); //Hat / Mute
~mdOut.control(4, 1, ~midiVel); //Hat / Vol
    ~mdOut.control(4, 2, ~midiVel); //Hat / Activ (MIDIIN)
~mdOut.control(4, 3, ~midiVel); //Hat / SendA
~mdOut.control(4, 4, ~midiVel); //Hat / SendB
~mdOut.control(4, 5, ~midiVel); //Hat / Att
~mdOut.control(4, 6, ~midiVel); //Hat / Sus
~mdOut.control(4, 7, ~midiVel); //Hat / Dec/Rel
~mdOut.control(4, 8, ~midiVel); //Hat / Chain
    ~mdOut.control(4, 9, ~midiVel); //Hat / TimeMul (MIDIIN)

~mdOut.control(5, 0, ~midiVel); //Bass / Mute
~mdOut.control(5, 1, ~midiVel); //Bass / Vol
    ~mdOut.control(5, 2, ~midiVel); //Bass / Activ (MIDIIN)
~mdOut.control(5, 3, ~midiVel); //Bass / SendA
~mdOut.control(5, 4, ~midiVel); //Bass / SendB
~mdOut.control(5, 5, ~midiVel); //Bass / Att
~mdOut.control(5, 6, ~midiVel); //Bass / Sus
~mdOut.control(5, 7, ~midiVel); //Bass / Dec/Rel
~mdOut.control(5, 8, ~midiVel); //Bass / Chain
    ~mdOut.control(5, 9, ~midiVel); //Bass / TimeMul (MIDIIN)

~mdOut.control(5, 11, ~midiVel); //Bass / xy1X
~mdOut.control(5, 12, ~midiVel); //Bass / xy1Y
~mdOut.control(5, 13, ~midiVel); //IFBass / Cut X
~mdOut.control(5, 14, ~midiVel); //IFBass / Cut Y
~mdOut.control(5, 40, ~midiVel); //IFBass / lfo 1
~mdOut.control(5, 41, ~midiVel); //IFBass / lfo 2


~mdOut.control(6, 0, ~midiVel); //Keys / Mute
~mdOut.control(6, 1, ~midiVel); //Keys / Vol
    ~mdOut.control(6, 2, ~midiVel); //Keys / Activ (MIDIIN)
~mdOut.control(6, 3, ~midiVel); //Keys / SendA
~mdOut.control(6, 4, ~midiVel); //Keys / SendB
~mdOut.control(6, 5, ~midiVel); //Keys / Att
~mdOut.control(6, 6, ~midiVel); //Keys / Sus
~mdOut.control(6, 7, ~midiVel); //Keys / Dec/Rel
~mdOut.control(6, 8, ~midiVel); //Keys / Chain
    ~mdOut.control(6, 9, ~midiVel); //Keys / TimeMul (MIDIIN)

~mdOut.control(6, 11, ~midiVel); //Keys / xy1X
~mdOut.control(6, 12, ~midiVel); //Keys / xy1Y
~mdOut.control(6, 13, ~midiVel); //IFKeys / Cut X
~mdOut.control(6, 14, ~midiVel); //IFKeys / Cut Y
~mdOut.control(6, 40, ~midiVel); //IFKeys / lfo 1
~mdOut.control(6, 41, ~midiVel); //IFKeys / lfo 2

~mdOut.control(7, 0, ~midiVel); //Samp / Mute
~mdOut.control(7, 1, ~midiVel); //Samp / Vol
    ~mdOut.control(7, 2, ~midiVel); //Samp / Activ (MIDIIN)
~mdOut.control(7, 3, ~midiVel); //Samp / SendA
~mdOut.control(7, 4, ~midiVel); //Samp / SendB
~mdOut.control(7, 5, ~midiVel); //Samp / Att
~mdOut.control(7, 6, ~midiVel); //Samp / Sus
~mdOut.control(7, 7, ~midiVel); //Samp / Dec/Rel
~mdOut.control(7, 8, ~midiVel); //Samp / Chain
    ~mdOut.control(7, 9, ~midiVel); //Samp / TimeMul (MIDIIN)
~mdOut.control(7, 11, ~midiVel); //Samp / xy1X
~mdOut.control(7, 12, ~midiVel); //Samp / xy1Y
~mdOut.control(7, 13, ~midiVel); //IFSamp / Cut X
~mdOut.control(7, 14, ~midiVel); //IFSamp / Cut Y
~mdOut.control(7, 40, ~midiVel); //IFSamp / lfo 1
~mdOut.control(7, 41, ~midiVel); //IFSamp / lfo 2


~mdOut.control(8, 3, ~midiVel); //IFExt / SendA
~mdOut.control(8, 4, ~midiVel); //IFExt / SendB

~mdOut.control(10, 20, ~midiVel); //Drum / Filt Morph
~mdOut.control(10, 21, ~midiVel); //Drum / Filt Freq

~mdOut.control(11, 1, ~midiVel); //SendA / Res Note
~mdOut.control(11, 2, ~midiVel); //SendA / Res Decay
~mdOut.control(11, 3, ~midiVel); //SendA / Res ll+lll
~mdOut.control(11, 4, ~midiVel); //SendA / Res lV+V
~mdOut.control(11, 5, ~midiVel); //SendA / Res ColMat
~mdOut.control(11, 6, ~midiVel); //SendA / Res l Gain
~mdOut.control(11, 7, ~midiVel); //SendA / Res Width
~mdOut.control(11, 8, ~midiVel); //SendA / Res Chain

~mdOut.control(12, 1, ~midiVel); //SendB / Rev Reverb
~mdOut.control(12, 2, ~midiVel); //SendB / Rev Delay
~mdOut.control(12, 3, ~midiVel); //SendB / Rev Mac3
~mdOut.control(12, 4, ~midiVel); //SendB / Rev Mac4
~mdOut.control(12, 5, ~midiVel); //SendB / Rev Mac5
~mdOut.control(12, 6, ~midiVel); //SendB / Rev Mac6
~mdOut.control(12, 7, ~midiVel); //SendB / Rev Mac7
~mdOut.control(12, 8, ~midiVel); //SendB / Rev Chain

//IFMast
~mdOut.control(14, 0, ~midiVel); //IFMast / Activate ---- MIDIIn
~mdOut.control(14, 0, ~midiVel); //IFMast / m1
~mdOut.control(14, 0, ~midiVel); //IFMast / m2
~mdOut.control(14, 0, ~midiVel); //IFMast / m3
~mdOut.control(14, 0, ~midiVel); //IFMast / m4
~mdOut.control(14, 0, ~midiVel); //IFMast / m5
~mdOut.control(14, 0, ~midiVel); //IFMast / m6
~mdOut.control(14, 0, ~midiVel); //IFMast / m7
~mdOut.control(14, 0, ~midiVel); //IFMast / m8

//Ableton Globals
~mdOut.control(15, 0, ~midiVel); //Ableton / Start
~mdOut.control(15, 1, ~midiVel); //Ableton / Stop
~mdOut.control(15, 2, ~midiVel); //Ableton / Tap Tempo
~mdOut.control(15, 3, ~midiVel); //Ableton / Song Tempo