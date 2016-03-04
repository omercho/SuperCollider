Speech.init(8);
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