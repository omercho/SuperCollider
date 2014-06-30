~countKick=0;
~freqKick=155;

1.do{
	~countKick = ~countKick + 1;
	~countKick.switch(
		4, {
			("            KickCnt"+~countKick).postln;

			//~freqKick=~freqKick+10;
			~countKick = 0;

		}

	)
};
~vBass.latency=0.221;
~vBass.noteOff(~chBass,60, 0);
~vBass.latency=(-0.2);
~vKeys.latency=(-0.2);


IFKick_SC(~tmMulKickP.next*~tmKickP.next);
IFSnr_SC(~tmMulSnrP.next*~tmSnrP.next);
IFHat_SC(~tmMulHatP.next*~tmHatP.next);

IFKeys_SC(~tmKeysP.next);
IFBass_SC(~tmBassP.next);
IFSamp_SC(~tmSampP.next);

(
~tdKick1.free;
~tdKick1=MIDIFunc.noteOn( {
	arg vel;
	"Kick".postln;
	IFKick_SC(~tmMulKickP.next*~tmKickP.next);
	IFBass_SC(~tmBassP.next);

}, chan:9, noteNum:36);

~tdSnr1.free;
~tdSnr1=MIDIFunc.noteOn( {
	arg vel;
	"Snare".postln;
	IFSnr_SC(~tmMulSnrP.next*~tmSnrP.next);
	IFSamp_SC(~tmSampP.next);


}, chan:9, noteNum:38);

~tdHat1.free;
~tdHat1=MIDIFunc.noteOn( {
	arg vel;
	"Snare".postln;
	IFHat_SC(~tmMulHatP.next*~tmHatP.next);
	IFKeys_SC(~tmKeysP.next);

}, chan:9, noteNum:42);

)