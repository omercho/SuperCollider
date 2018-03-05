
/*

IFHat.times(4);
*/

IFHat_SC {
	classvar <>counter3=0, timeCnt=0;
	var<>hTime=1;


	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });
		}
	}

	*globals{

		~hatCh=2;
		~hatLate=0.00;
		~hatTimes=1;
		~harmHat=0;
		~rootHat=0;
		~susMulHat=1;
		~trHat=0;


		~octMulHat=0;
		~hatVolC=1;
	}

	*preSet {

		SynthDef(\IFHat_SC, { |out=0, amp=0.3, gate=1,
			att =0.01, dec=0.03, susLev=0.08, rel=0.04,
			lfo1Rate=1, lfo2Rate=1,
			noose =1, freq = 90, pan = 0, freqpan=0.2 |
			var env1, env2, ses, oscs1, noise, in, n2,lfo1, lfo2;
			lfo1 = SinOsc.kr(lfo1Rate).range(1.0, 3.2);
			lfo2 = SinOsc.kr(lfo2Rate).range(1.0, 1.9);

			env1 = EnvGen.ar(Env.perc(att, dec));
			env2 = EnvGen.ar(Env.adsr(att, dec, susLev, rel), gate, doneAction:2);

			noise = SinOsc.ar(freq*lfo2);
			in = Mix.ar(Blip.ar(4*freq*lfo2, 2*freq*lfo1).softclip(3.2),noise);
			noise = HPF.ar(in*noise*lfo2, 0, 0.9, 0.5, Mix.ar(noise*in));
			//noise = BHiShelf.ar(Mix.ar(noise,in), 1, lfo2, -6);
			noise = BHiPass.ar(noise/in, freq*lfo1, 0.5, env2);
			in= MoogFF.ar(noise, in, 0.2);

			ses = noise**in;
			//ses = ses;
			ses = ses.clip2(0.4);
			ses = ses * amp;

			Out.ar(out, Pan2.ar(ses, SinOsc.kr(freqpan).range(-0.8, 0.8), amp*0.6)*env2);
		}).add;

	}

	*default {

		~nt1Hat = PatternProxy( Pseq([0], inf));
		~nt1HatP = Pseq([~nt1Hat], inf).asStream;
		~dur1Hat = PatternProxy( Pseq([1], inf));
		~dur1HatP = Pseq([~dur1Snr], inf).asStream;
		~amp1Hat = PatternProxy( Pseq([1], inf));
		~amp1HatP = Pseq([~amp1Hat], inf).asStream;
		~sus1Hat = PatternProxy( Pseq([1], inf));
		~sus1HatP = Pseq([~sus1Hat], inf).asStream;

		~attHat=0.01;
		~decHat=0.8;
		~susLevHat=0.0;
		~relHat = 0.2;
		~lfoMulHat = 1;
		~harmHatTD =1;

		~tmMulHat = PatternProxy( Pseq([1], inf));
		~tmMulHatP= Pseq([~tmMulHat], inf).asStream;
		~tmHat = PatternProxy( Pseq([1], inf));
		~tmHatP= Pseq([~tmHat], inf).asStream;

		~transHat = PatternProxy( Pseq([0], inf));
		~transHatP = Pseq([~transHat], inf).asStream;
		~octHat = PatternProxy( Pseq([4], inf));
		~octHatP = Pseq([~octHat], inf).asStream;
		~legHat = PatternProxy( Pseq([3.0], inf));
		~legHatP = Pseq([~legHat], inf).asStream;
		~strHat = PatternProxy( Pseq([1.0], inf));
		~strHatP = Pseq([~strHat], inf).asStream;

		~lfo1Hat = PatternProxy( Pseq([1], inf));
		~lfo1HatP = Pseq([~lfo1Hat], inf).asStream;
		~lfo2Hat = PatternProxy( Pseq([1], inf));
		~lfo2HatP = Pseq([~lfo2Hat], inf).asStream;

	}



	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{var led;
				led= ~amp1Hat.asStream.value;

				//~hatLate=~abLate;
				~hatLate.wait;

				this.p1(val);

				if ( led>0, {

					1.do{
						~tOSCAdrr.sendMsg('hatLed', led);
						~sus1Hat.asStream.value.wait;
						~tOSCAdrr.sendMsg('hatLed', 0);
					};

					},{
						~tOSCAdrr.sendMsg('hatLed', 0.0);

				});

				~durMulP*((~dur1HatP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;

		Pbind(\instrument, \IFHat_SC, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([Pseq([~dur1HatP.next/val],1)], 1),
			\degree, Pseq([~nt1HatP.next], 1),
			\amp, Pseq([~amp1HatP.next], 1),
			\sustain, Pseq([~sus1HatP.next],1)*~susMulHat*~susTD,
			\mtranspose, Pseq([~transHatP.next], 1)+~trHat,
			\octave, Pseq([~octHatP.next], 1)+~octMulHat,
			\harmonic, Pseq([~strHatP.next], 1)+~harmHat*~harmHatTD,
			\freqpan, Pbrown(0.04, 1.4, 0.125, inf),
			\att, ~attHat,
			\dec, ~decHat,
			\susLev, ~susLevHat,
			\rel, ~relHat,
			\lfo1Rate, ~lfo1HatP*~lfoMulHat,
			\lfo2Rate, ~lfo2HatP*~lfoMulHat,
			\group, ~piges,
			\out, Pseq([[ ~busHat]], inf )
		).play;

		//this.count2;
		//this.timesCount;
	}

	*osc{

		~xy1Hat.free;
		~xy1Hat= OSCFunc({
			arg msg;



			},
			'/xy1Hat'
		);

		~attHatFader.free;
		~attHatFader= OSCFunc({
			arg msg,val;
			val=msg[1]*2;
			~attHat=val+0.01;
			},
			'/attHat'
		);

		~susLevHatFader.free;
		~susLevHatFader= OSCFunc({
			arg msg;
			~susLevHat=msg[1];


			},
			'/susHat'
		);

		~decHatFader.free;
		~decHatFader= OSCFunc({
			arg msg;
			~decHat=msg[1];
			~relHat=msg[1]+0.1;
			},
			'/decHat'
		);

		~tmHatFader.free;
		~tmHatFader= OSCFunc({
			arg msg;
			~tmHat.source = msg[1];

			},
			'/timesHat'
		);

		~lfoMulHatFad.free;
		~lfoMulHatFad= OSCFunc({
			arg msg;
			~lfoMulHat=msg[1];
			},
			'/lfoMulHat'
		);

		~tmMulHatBut.free;
		~tmMulHatBut= OSCFunc({
			arg msg;
			~tmMulHat.source = msg[1];

			},
			'/tmMulHat'
		);

		//MUTES
		~vHatMtCln.free;
		~vHatMtCln= OSCFunc({
			arg msg;

			~vHatSynth.set(\mtCln, msg[1]);

			},
			'/mtClnHat'
		);
		~vHatMtDly.free;
		~vHatMtDly= OSCFunc({
			arg msg;

			~vHatSynth.set(\mtDly, msg[1]);

			},
			'/mtDlyHat'
		);
		~vHatMtRev.free;
		~vHatMtRev= OSCFunc({
			arg msg;

			~vHatSynth.set(\mtRev, msg[1]);

			},
			'/mtRevHat'
		);
		~vHatMtFlo.free;
		~vHatMtFlo= OSCFunc({
			arg msg;

			~vHatSynth.set(\mtFlo, msg[1]);

			},
			'/mtFloHat'
		);

		~padHat.free;
		~padHat = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFHat(~tmHatP.next);

			});
			},
			'/padHat'
		);

	}

	*times { arg hTime;
		{~hatTimes =  hTime;}.fork;
	}

	*oct { arg hOct;

		{~octHat =  hOct;}.fork;
	}

	//Hat Counter
	*timesCount {
		timeCnt = timeCnt + 1;
		timeCnt.switch(

			1, {  },
			4, {  },
			6, {  },
			8, {  },
			9, {  },
			10, {  },
			15, {  },
			17, {  },
			18, {
				("        -----------HatTimesCnt"+timeCnt).postln;

				timeCnt=0;
			},

		);

	}

	*count3 {
		1.do{
			counter3 = counter3 + 1;
			counter3.switch(
				3, {
					("            hatCnt"+counter3).postln;
					this.ctl_3;
					counter3 = 0;

				}

			)
		}

	}


	*ctl_1 {


	}

	*ctl_2 {


	}

	*ctl_3 {


	}
	*ctl_9 {



	}

	*ctl_18 {



	}

}

