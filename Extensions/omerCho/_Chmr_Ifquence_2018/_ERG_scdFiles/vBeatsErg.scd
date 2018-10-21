~vBeats.noteOn(9,~vKick,64);
~vBeats.noteOff(0,~vKick,64);

(

Pbind(
	\chan, ~chBeats,
	\type, \midi,
	\midicmd, \noteOn,
	\midiout,~vBeats,
	\scale, Pfunc({Scale.chromatic}, inf),
	\octave, 0,
	\dur, Pseq([Pseq([~dur1BeatsP.next],inf)], 1),
	\note, Pseq([~vKick,~vSnr, ~vTomL,
	~vTomH,~vHatCl, ~vHatOp, ~vClap], 1),
	\amp, Pseq([~amp1BeatsP.next], inf),
	\sustain, Pseq([~sus1BeatsP.next],inf)*~susMulBeats,

).play;

)


(

Pbind(
	\chan, ~chBeats,
	\type, \midi,
	\midicmd, \noteOn,
	\midiout,~vBeats,
	\scale, Pfunc({Scale.chromatic}, inf),
	\octave, 0,
	\dur, Pseq([0.5],inf),
	\note, Pseq((75..75), inf),
	\amp, Pseq([~amp1BeatsP.next], inf),
	\sustain, Pseq([~sus1BeatsP.next],inf)*~susMulBeats,

).play;

)

Pbind(
			\chan, ~chVKick,
			\type, \midi, \midiout,~vBeats, \scale, Pfunc({Scale.chromatic}, inf),
			\octave, 0,
			\dur, Pseq([~dur1VKickP.next], 1),
			\note, Pseq([~nt1VKickP.next], inf),
			\amp, Pseq([~amp1VKickP.next], inf),
			\sustain, Pseq([~sus1VKickP.next],inf)*~susMulVKick,

		).play;

	Pbind(//vKickLevel
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, 9, \ctlNum, ~kickLev,
			\delta, Pseq([~dur1VKickP],1),
			\control, Pseq([0.8], inf)*~levVKickMul*127,

		).play;


(

		Pbind(
			\instrument, \IFSamp_SC, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([~dur1SampP.next],1)], 1),
			\degree, Pseq([~nt1SampP.next], 1),
			\amp, Pseq([~amp1SampP.next], 1),
			\sustain, Pseq([~sus1SampP.next],1)*~susMulSamp*~susTD,
			\mtranspose, Pseq([~transSampP.next], 1)+~trSamp,
			\octave, Pseq([~octSampP.next], 1)+~octMulSamp,
			\harmonic, Pseq([~strSampP.next], 1)+~harmSamp,
			\pan, Pbrown(-1.0, 1.0, 0.125, inf),
			\brown, Pbrown(0.0, 1.0, 0.125, inf)*~brownSamp,
			\saw, Pbrown(0.4, 100.0, 0.125, inf)*~sawSamp,
			\cut1, Pbrown(0.0, 1.0, 0.125, inf)*~cutSamp,
			\sin1, Pbrown(0.4, 100.0, 10.125, inf)*~sin1Samp,
			\sin2, Pbrown(0.4, 100.0, 20.125, inf)*~sin2Samp,
			\att, ~attSamp,
			\dec, ~decSamp,
			\susLev, ~susLevSamp,
			\rel, ~relHat,
			\lfo1Rate, ~lfo1SampP*~lfoMulSamp,
			\lfo2Rate, ~lfo2SampP*~lfoMulSamp,
			\group, ~piges,
			\out, Pseq([~busSamp], inf )


		).play;

)