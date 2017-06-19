Speech.init(1);
~words = Pseq(["there", "is", "no", "clarity"], inf).asStream;
~nt1Speek = Pseq([16,48,51,55, 50]*1, inf).asStream;
~dur1Speek =  Pseq([0.5], inf).asStream;
~rtSpeek = Pseq([120,100,90,180], inf).asStream;
~voiceSpeek = Pseq([1,2,3], inf).asStream;
~voiceChan = Pseq([0,1,2,3,4,5,6,7,8], inf).asStream;
(
Speech.init(8);
~tmSpeek = 1;
Task({
	~tmSpeek.do ({arg i;

		Speech.channels[~voiceChan.next].voice_(~voiceSpeek.next);
		Speech.setSpeechRate(~voiceChan.next,~rtSpeek.next);
		Speech.setSpeechPitch(~voiceChan.next, ~nt1Speek.next);
		//Speech.setSpeechVoice();
		Speech.setSpeechVolume(~voiceChan.next,-1.dbamp);
		~words.next.speak(~voiceChan.next);
		~dur1Speek.next.wait;
	});
}).play;
)


"hi i'm talking with the default voice now, i guess".speak;



Speech.init(2);
Speech.channels[0].speak("hallo");
Speech.channels[0].isActive;
Speech.channels[0].voice_(2);
Speech.channels[0].speak("hallo");
Speech.channels[0].pitch_(60);
Speech.channels[0].speak("hallo");
Speech.channels[0].volume_(-10.dbamp);
Speech.channels[0].pitchMod_(20);
Speech.channels[0].speak("hallo");
Speech.channels[0].stop(\immediate);
Speech.channels[0].stop(\endOfWord);
Speech.channels[0].stop(\endOfSentence);

Speech.channels[0].speak("Force the voice to speaking something different.");
Speech.channels[0].speak("Force the voice to speaking something different.".reverse, true);
Speech.channels[0].speak("If you have the ability to love, love yourself first.");

Speech.channels[0].speak("
	when God created love he didn't help most
	when God created dogs He didn't help dogs
	when God created plants that was average
	when God created hate we had a standard utility
	when God created me He created me
	when God created the monkey He was asleep
	when He created the giraffe He was drunk
	when He created narcotics He was high
	and when He created suicide He was low
	"
);
Speech.channels[0].speak("


	when He created you lying in bed

	He knew what He was doing
	He was drunk and He was high
	and He created the mountains and the sea and fire at the same time

	He made some mistakes
	but when He created you lying in bed

	He came all over His Blessed Universe."
);

Speech.setSpeechVoice(0,1);
Speech.setSpeechPitch(0, 30); //pitch in MIDI Num
Speech.setSpeechRate(0, 10);
Speech.setSpeechVolume(0,0.1);
Speech.setSpeechPitchMod(0, 200);
Speech.stop(0, 1);


(
Speech.init(16);

Task({
	    16.do ({arg i;
		        [0.1, 0.18, 0.2].choose.wait;
		        Speech.setSpeechRate(i,[90, 30, 60].choose);
		        Speech.setSpeechVolume(i,0.07);
		        "no this is private. float . boolean me. char[8] ".speak(i);
	    });
}).play;
)

Server.default= s= Server.internal;

Server.default.prepareForRecord;
Server.default.record;
Server.default.pauseRecording;
Server.default.stopRecording;