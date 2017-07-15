
/*

IFStat.ln01;
*/

IFStat {
	classvar <>counter2=0, timeCnt=0;
	var <>kTime=1;


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });*/
		}
	}
	*load {
		this.globals;
		this.proxy;
		this.apc40;


	}

	*globals{

		~chStatKick=8;
		~chStat=8;
		~octStKick=0;
		~octStSnr=0;
		~octStHat=0;
		~octStTom=0;
		~octStClap=0;
		~octStKrot=0;


	}

	*proxy {

		//Static_01_Kick
		~actStKick = PatternProxy( Pseq([0], inf));
		~actStKickP= Pseq([~actStKick], inf).asStream;
		~durStKick = PatternProxy( Pseq([1], inf));
		~durStKickP = Pseq([~durStKick], inf).asStream;
		~ampStKick = PatternProxy( Pseq([0,0,0,0,1], inf));
		~ampStKickP = Pseq([~ampStKick], inf).asStream;
		~ntStKick = PatternProxy( Pseq([36], inf));
		~ntStKickP = Pseq([~ntStKick], inf).asStream;
		//StaticSnr
		~actStSnr = PatternProxy( Pseq([0], inf));
		~actStSnrP= Pseq([~actStSnr], inf).asStream;
		~durStSnr = PatternProxy( Pseq([1], inf));
		~durStSnrP = Pseq([~durStSnr], inf).asStream;
		~ampStSnr = PatternProxy( Pseq([0,0,0,0,1], inf));
		~ampStSnrP = Pseq([~ampStSnr], inf).asStream;
		~ntStSnr = PatternProxy( Pseq([38], inf));
		~ntStSnrP = Pseq([~ntStSnr], inf).asStream;
		//StaticHat
		~actStHat = PatternProxy( Pseq([0], inf));
		~actStHatP= Pseq([~actStHat], inf).asStream;
		~durStHat = PatternProxy( Pseq([1], inf));
		~durStHatP = Pseq([~durStHat], inf).asStream;
		~ampStHat = PatternProxy( Pseq([0,1], inf));
		~ampStHatP = Pseq([~ampStHat], inf).asStream;
		~ntStHat = PatternProxy( Pseq([42,42,42,46], inf));
		~ntStHatP = Pseq([~ntStHat], inf).asStream;
		//StaticToms
		~actStBass = PatternProxy( Pseq([0], inf));
		~actStBassP= Pseq([~actStBass], inf).asStream;
		~durStBass = PatternProxy( Pseq([1], inf));
		~durStBassP = Pseq([~durStBass], inf).asStream;
		~ampStBass = PatternProxy( Pseq([0,1,1,0], inf));
		~ampStBassP = Pseq([~ampStBass], inf).asStream;
		~ntStBass = PatternProxy( Pseq([43,43,43,50], inf));
		~ntStBassP = Pseq([~ntStBass], inf).asStream;
		//StaticClap
		~actStKeys = PatternProxy( Pseq([0], inf));
		~actStKeysP= Pseq([~actStKeys], inf).asStream;
		~durStKeys = PatternProxy( Pseq([1], inf));
		~durStKeysP = Pseq([~durStKeys], inf).asStream;
		~ampStKeys = PatternProxy( Pseq([0,0,0,0,1], inf));
		~ampStKeysP = Pseq([~ampStKeys], inf).asStream;
		~ntStKeys = PatternProxy( Pseq([39], inf));
		~ntStKeysP = Pseq([~ntStKeys], inf).asStream;
		//StaticAgog
		~actStSamp = PatternProxy( Pseq([0], inf));
		~actStSampP= Pseq([~actStSamp], inf).asStream;
		~durStSamp = PatternProxy( Pseq([1], inf));
		~durStSampP = Pseq([~durStSamp], inf).asStream;
		~ampStSamp = PatternProxy( Pseq([0,0,0,0,1], inf));
		~ampStSampP = Pseq([~ampStSamp], inf).asStream;
		~ntStSamp = PatternProxy( Pseq([67,75,75,75], inf));
		~ntStSampP = Pseq([~ntStSamp], inf).asStream;

	}//*proxy


	*ln01 {|i=1|
		var val;
		val=i;
		~staticKickPat=Pbind(
			\chan, ~chStatKick,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octStKick,
			\dur, Pseq([~durStKickP.next],~actStKickP.next),
			\degree, Pseq([~ntStKickP.next], inf),
			\amp, Pseq([~ampStKickP.next], inf)
		).play;
	}//stat01
	*ln02 {|i=1|
		var val;
		val=i;
		~staticSnrPat=Pbind(
			\chan, ~chStat,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octStSnr,
			\dur, Pseq([~durStSnrP.next],~actStSnrP.next),
			\degree, Pseq([~ntStSnrP.next], inf),
			\amp, Pseq([~ampStSnrP.next], inf)
		).play;
	}
	*ln03 {|i=1|
		var val;
		val=i;
		~staticHatPat=Pbind(
			\chan, ~chStat,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octStHat,
			\dur, Pseq([~durStHatP.next],~actStHatP),
			\degree, Pseq([~ntStHatP.next], inf),
			\amp, Pseq([~ampStHatP.next], inf)
		).play;
	}
	*ln04 {|i=1|
		var val;
		val=i;
		~staticBassPat=Pbind(
			\chan, ~chStat,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octStTom,
			\dur, Pseq([~durStBassP.next],~actStBassP.next),
			\degree, Pseq([~ntStBassP.next], inf),
			\amp, Pseq([~ampStBassP.next], inf)
		).play;
	}
	*ln05 {|i=1|
		var val;
		val=i;
		~staticKeysPat=Pbind(
			\chan, ~chStat,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octStClap,
			\dur, Pseq([~durStKeysP.next],~actStKeysP.next),
			\degree, Pseq([~ntStKeysP.next], inf),
			\amp, Pseq([~ampStKeysP.next], inf)
		).play;
	}//stat01
	*ln06 {|i=1|
		var val;
		val=i;
		~staticSampPat=Pbind(
			\chan, ~chStat,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl1}, inf),
			\octave,~octStKrot,
			\dur, Pseq([~durStSampP.next],~actStSampP.next),
			\degree, Pseq([~ntStSampP.next], inf),
			\amp, Pseq([~ampStSampP.next], inf)
		).play;
	}//stat01

	*apc40{
		~volKick_APC.free;
		~volKick_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volKick', vel/127);
			~mdOut.control(2, 1, vel);

		},srcID:~apc40InID, chan:0, ccNum:7);



		//Act ButC
		//Static Kick Activate
		~cntActLine1ButC=0;
		~mdActLine1ButC.free;
		~mdActLine1ButC=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine1ButC = ~cntActLine1ButC + 1;
				~cntActLine1ButC.switch(
					0,{},
					1, {
						IFAPC40.actLine1ButC(1);
					},
					2,{
						IFAPC40.actLine1ButC(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn1, noteNum:~actButC);
		//Act ButC
		//Static Snr Activate
		~cntActLine2ButC=0;
		~mdActLine2ButC.free;
		~mdActLine2ButC=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine2ButC = ~cntActLine2ButC + 1;
				~cntActLine2ButC.switch(
					0,{},
					1, {
						IFAPC40.actLine2ButC(1);
					},
					2,{
						IFAPC40.actLine2ButC(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn2, noteNum:~actButC);

		//Act ButC
		//Static Hat Activate
		~cntActLine3ButC=0;
		~mdActLine3ButC.free;
		~mdActLine3ButC=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine3ButC = ~cntActLine3ButC + 1;
				~cntActLine3ButC.switch(
					0,{},
					1, {
						IFAPC40.actLine3ButC(1);
					},
					2,{
						IFAPC40.actLine3ButC(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn3, noteNum:~actButC);

		~cntActLine4ButC=0;
		~mdActLine4ButC.free;
		~mdActLine4ButC=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine4ButC = ~cntActLine4ButC + 1;
				~cntActLine4ButC.switch(
					0,{},
					1, {
						IFAPC40.actLine4ButC(1);
					},
					2,{
						IFAPC40.actLine4ButC(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn4, noteNum:~actButC);

		~cntActLine5ButC=0;
		~mdActLine5ButC.free;
		~mdActLine5ButC=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine5ButC = ~cntActLine5ButC + 1;
				~cntActLine5ButC.switch(
					0,{},
					1, {
						IFAPC40.actLine5ButC(1);
					},
					2,{
						IFAPC40.actLine5ButC(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn5, noteNum:~actButC);

		~cntActLine6ButC=0;
		~mdActLine6ButC.free;
		~mdActLine6ButC=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine6ButC = ~cntActLine6ButC + 1;
				~cntActLine6ButC.switch(
					0,{},
					1, {
						IFAPC40.actLine6ButC(1);
					},
					2,{
						IFAPC40.actLine6ButC(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcLn6, noteNum:~actButC);


	}//*apc40

}

