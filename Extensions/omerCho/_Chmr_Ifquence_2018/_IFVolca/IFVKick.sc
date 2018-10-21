
/*
IFVKick(1);
IFVKick.pat_1;

~octVKick=4;


IFVKick(~tmMulVKickP.next*~tmVKickP.next);
*/


IFVKick {


	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc;});*/
		}
	}
	*load{
	this.globals; this.preSet; this.default; this.osc;this.midi;
	}
	*globals{

		~chVKick=9;
		~vBeatsLate=0;
		//~vBeatsLate=Tempo.bpm*(1/267.92);
		~timesVKick=1;



	}

	*preSet{}


	*default {

		~ntVKick = PatternProxy( Pseq([0], inf));
		~ntVKickP = Pseq([~ntVKick], inf).asStream;
		~durVKick = PatternProxy( Pseq([1], inf));
		~durVKickP = Pseq([~durVKick], inf).asStream;
		~ampVKick = PatternProxy( Pseq([0.9], inf));
		~ampVKickP = Pseq([~ampVKick], inf).asStream;
		~susVKick = PatternProxy( Pseq([0.3], inf));
		~susVKickP = Pseq([~susVKick], inf).asStream;


		~tmMulVKick = PatternProxy( Pseq([1], inf));
		~tmMulVKickP= Pseq([~tmMulVKick], inf).asStream;
		~tmVKick = PatternProxy( Pseq([1], inf));
		~tmVKickP= Pseq([~tmVKick], inf).asStream;

		~levVKick = PatternProxy( Pseq([0.9], inf));
		~levVKickP= Pseq([~levVKick], inf).asStream;
		~levVKickMul =1;

		~actVKick = PatternProxy( Pseq([1], inf));
		~actVKickP= Pseq([~actVKick], inf).asStream;

		~actVKickLfo1 = PatternProxy( Pseq([0], inf));
		~actVKickLfo1P= Pseq([~actVKickLfo1], inf).asStream;

		~volVKick = PatternProxy( Pseq([0.9], inf));
		~volVKickP = Pseq([~volVKick], inf).asStream;

		~delta1VKick = PatternProxy( Pseq([1/1], inf));
		~delta1VKickP = Pseq([~delta1VKick], inf).asStream;

		~delta2VKick = PatternProxy( Pseq([1/1], inf));
		~delta2VKickP = Pseq([~delta2VKick], inf).asStream;



	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				~vBeatsLate.wait;

				this.p1(val);


				//~durMulP*((~dur1KickP.next)/val).wait;
				((~durVKickP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;
		/*Pbind(//LFO Amp
			\type, \midi, \midicmd, \control,
			\midiout,~vBeats, \chan, ~chVKick, \ctlNum, ~kickLev,
			\delta, Pseq([~delta1VKickP.next], 1),
			\control, Pseq([~volVKickP.next*~ampVKickP], 1),
		).play(quant:0);*/
		Pbind(
			\chan, ~chVKick,
			\type, \midi, \midiout,~vBeats,\scale, Pfunc({~scl1}, inf),
			\octave,0,
			\dur, Pseq([~durVKickP.next], ~actVKickP),
			\degree, Pseq([~vKick], inf),
			\amp, Pseq([~volKickP.next*~ampVKickP.next], inf),
			\sustain, Pseq([~susVKickP.next],inf)*~susMulKick
		).play(quant:0);

	}
	*midi{
		~volVKick_md.free;
		~volVKick_md=MIDIFunc.cc( {
			arg vel;
			/*~tOSCAdrr.sendMsg('volVKick', vel/127);
			~volVKick.source = vel;*/
		},srcID:~mdMixInID, chan:~mdMixLnMaster, ccNum:30);

		//Act ButA1
		//Kick Activate
		IFMIDIMix.actBankButA(0);
		~cntMixActBankButA=0;
		~mdActBankButA.free;
		~mdActBankButA=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMixActBankButA = ~cntMixActBankButA + 1;
				~cntMixActBankButA.switch(
					0,{},
					1, {
						IFMIDIMix.actBankButA(1);
					},
					2,{
						IFMIDIMix.actBankButA(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~bankRight);

		//Act ButB
		//VKick Time Div2
		~cntMixActBankButB=0;
		~mdActBankButB.free;
		~mdActBankButB=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntMixActBankButB = ~cntMixActBankButB + 1;
				~cntMixActBankButB.switch(
					0,{},
					1, {
						IFMIDIMix.actBankButB(1);
					},
					2,{
						IFMIDIMix.actBankButB(0);
					}
				)}
			);
		},srcID:~mdMixInID, chan:~mdMixGlobChan, noteNum:~bankLeft);


	}//*midi

	*osc{

	~levVKickMulFad.free;
	~levVKickMulFad= OSCFunc({
		arg msg;

			~levVKickMul=msg[1];
		~tOSCAdrr.sendMsg('/vBeatsLevels/1', msg[1]);
		},
		'/vBeatsLevels/1'
	);

///vBeatsLevels/1

	}



}