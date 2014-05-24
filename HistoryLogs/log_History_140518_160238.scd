// History, as it was on Sun May 18 16:02:38 2014.

[
[ 0, 'me', "(
s.options.numBuffers = 8192;
s.options.numPrivateAudioBusChannels = 8192;
s.options.numOutputBusChannels = 10;
s.options.numInputBusChannels = 10;
// use Jack if it's running
s.options.inDevice = \"JackRouter\";
s.options.outDevice = \"JackRouter\";
s.reboot;

// fix bad values

/*~bvFunc = {
	{var in;

		in = In.ar(0, s.options.numOutputBusChannels);
		in.do({|chan, i|
			var bad;
			bad = CheckBadValues.ar(chan);
			//ReplaceOut.ar(i, if(bad < 1) * chan);
			ReplaceOut.ar(i, Select.ar(bad.clip(0, 1), [chan, Silent.ar]) );
		});

	}.play(RootNode(r.myServer), addAction: \\addToTail);
};
ServerTree.add(~bvFunc);
~bvFunc.value;*/


// discover others
~win = Window(\"BEERtopia\").front;
~win.bounds = ~win.bounds.moveTo(0, 600);
~win.layout = VLayout.new.add(~listView = ListView.new);

~addrBook = AddrBook.new;
// to get updates, just add a dependant
~addrBook.addDependant({|addrBook, what, who|
	{~listView.items = addrBook.peers.collectAs({|peer|
		peer.name ++ \" | \" ++ peer.addr.ip ++ \" | \" ++ if(peer.online, \"online\", \"offline\");
	}, Array)}.defer;
});

//~addrBook.addMe; // will automatically add you using your user name
 ~addrBook.addMe(Peer('omerCho', NetAddr.localAddr)); // use this to override name

~hail = Hail(~addrBook);

// Chat
~chatter = Chatter(~addrBook);

~win.layout.add(VLayout(StaticText().string_(\"Chatter\"), ~textField = TextField(), ~textView = TextView()));
~textField.action_({|v| ~chatter.send(v.string); v.string = \"\" });
// to get updates, just add a dependant
~chatter.addDependant({|chatter, what, who, chat|
	chat = chat.asString;
	{ ~textView.string_(who ++ \": \" ++ chat ++ \"\\n\" ++ ~textView.string) }.defer;
	// Shout
	if (chat.beginsWith(NMLShout.tag)) {
		defer {
			NMLShout((chat.drop(NMLShout.tag.size).reject(_ == $\\n) + (\"/\" ++ who)));
			{~win.front;}.defer(0.1);
		}
	};
});

~sharedData = OSCDataSpace(~addrBook);


// Code Relay
~codeRelay = CodeRelay(~addrBook);
History.start;
~historyGUI = History.makeWin;
~codeRelay.addDependant({|chatter, what, who, code|
	if(who != ~addrBook.me.name, {
		History.enter(code.asString, who);
		{~historyGUI.updateLines;}.defer;
	});
});

)" ],
[ 18.052566545, 'KK', "NdefMixer(s);" ],
[ 52.76625948, 'KK', "NdefMixer(s);" ],
[ 172.737105474, 'me', "Ndef(\\a).play;" ],
[ 175.229429504, 'me', "Ndef(\\a, { SinOsc.ar([350, 351.3], 0, 0.2) });" ],
[ 204.82386095, 'me', "Ndef.clear(3); // clear all after 3 seconds" ],
[ 220.338795715, 'KV', "Ndef(\\foo, { Impulse.ar([1, 8]) * 0.5 }).play" ],
[ 244.718454646, 'me', "Ndef(\\a).play;" ],
[ 249.018442834, 'me', "Ndef(\\a, { SinOsc.ar([350, 351.3], 0, 0.2) });" ],
[ 260.618014602, 'me', "Ndef(\\a, Pbind(\\dur, 0.03, \\freq, Pbrown(0, 1, 0.1, inf).linexp(0, 1, 200, 350)));" ],
[ 263.783796946, 'KK', "Ndef(\\foo, { Impulse.ar([1, 8]) * 0.7 }).play" ],
[ 308.722067805, 'me', "Ndef(\\a, { Pulse.ar([350, 351.3] / 4, 0.4) * 0.2 });" ],
[ 310.470113365, 'KV', "Ndef(\\ringz, { Ringz.ar(Ndef.ar(\\foo), ExpRand(80, 1200), decaytime:0.3 )}).play" ],
[ 313.35985504, 'me', "Ndef(\\a, Pbind(\\dur, 0.03, \\freq, Pbrown(0, 1, 0.1, inf).linexp(0, 1, 200, 350)));" ],
[ 315.672811359, 'KV', "Ndef(\\ringz, { Ringz.ar(Ndef.ar(\\foo), ExpRand(80, 1200), decaytime:0.3 )}).play" ],
[ 316.264956877, 'KK', "Ndef(\\ringz, { Ringz.ar(Ndef.ar(\\foo), ExpRand(80, 1200), decaytime:0.3 )}).play" ],
[ 316.44843631, 'KV', "Ndef(\\ringz, { Ringz.ar(Ndef.ar(\\foo), ExpRand(80, 1200), decaytime:0.3 )}).play" ],
[ 317.513944087, 'KV', "Ndef(\\ringz, { Ringz.ar(Ndef.ar(\\foo), ExpRand(80, 1200), decaytime:0.3 )}).play" ],
[ 320.178124685, 'KV', "Ndef(\\ringz, { Ringz.ar(Ndef.ar(\\foo), ExpRand(80, 1200), decaytime:0.3 )}).play" ],
[ 326.239058326, 'KV', "NdefMixer(s)" ],
[ 336.641518094, 'me', "Ndef(\\a, { Ringz.ar(Ndef.ar(\\foo), ExpRand(80, 1200), decaytime:0.3 )}).play" ],
[ 337.072465606, 'KK', "Ndef(\\ringz, { Ringz.ar(Ndef.ar(\\foo), ExpRand(80, 1200), decaytime:0.3 )}).play" ],
[ 355.01361746, 'KK', "Ndef(\\ringz2, { Ringz.ar(Ndef.ar(\\foo), ExpRand(80, 1200), decaytime:0.3 )}).play" ],
[ 357.885891689, 'me', "Ndef(\\a, { Ringz.ar(Ndef.ar(\\foo), ExpRand(80, 20), decaytime:0.3 )}).play" ],
[ 364.166537988, 'me', "Ndef(\\a, { Ringz.ar(Ndef.ar(\\foo), ExpRand(80, 120), decaytime:0.3 )}).play" ],
[ 368.958436822, 'me', "Ndef(\\a, Pbind(\\dur, 0.03, \\freq, Pbrown(0, 1, 0.1, inf).linexp(0, 1, 200, 350)));" ],
[ 377.3101733, 'KV', "Ndef(\\pad, {
	Resonz.ar(WhiteNoise.ar(0.1.dup))
}).play" ],
[ 381.617366548, 'me', "Ndef(\\a, Pbind(\\dur, 0.03, \\freq, Pbrown(0, 1, 0.1, inf).linexp(0, 1, 20, 350)));" ],
[ 394.21753781, 'KK', "Ndef(\\a, { Ringz.ar(Ndef.ar(\\foo), ExpRand(80, 120), decaytime:0.3 )}).play" ],
[ 416.925779304, 'KK', "Ndef(\\a, { Ringz.ar(Ndef.ar(\\foo), ExpRand(10000, 8000), decaytime:0.3 )}).play" ],
[ 427.489687302, 'me', "Ndef(\\b, { Ringz.ar(Ndef.ar(\\a), ExpRand(180, 820), decaytime:0.3 )}).play" ],
[ 444.769286464, 'me', "Ndef(\\b, { Ringz.ar(Ndef.ar(\\foo), ExpRand(180, 820), decaytime:0.3 )}).play" ],
[ 485.067354016, 'me', "Ndef(\\a, { SinOsc.ar(MouseX.kr(300, 1000, 1) * [1, 1.2], \\phase.ar([0, 0]) * 0.2) });" ],
[ 508.475384777, 'KK', "Ndef(\\a, { Ringz.ar(Ndef.ar(\\foo), ExpRand(80, 120), decaytime:0.9 )}).play" ],
[ 524.459811252, 'KK', "Ndef(\\a, { SinOsc.ar(MouseX.kr(300, 1000, 1) * [1, 1.2], \\phase.ar([0, 0]) * 0.2) });" ],
[ 557.865871018, 'me', "Ndef(\\a, { SinOsc.ar(MouseX.kr(300, 1000, 1) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 590.050425717, 'me', "Ndef(\\a, { SinOsc.ar(XLine.kr(800,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 597.504850578, 'me', "Ndef(\\a, { SinOsc.ar(XLine.kr(800,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 604.321279697, 'me', "Ndef(\\a, { SinOsc.ar(XLine.kr(800,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 611.398134577, 'KV', "Ndef(\\a, { SinOsc.ar(XLine.kr(800,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 612.070760316, 'KK', "Ndef(\\a, { SinOsc.ar(XLine.kr(800,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 613.944308585, 'KK', "Ndef(\\a, { SinOsc.ar(XLine.kr(800,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 624.776591912, 'me', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40),100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 634.791375733, 'me', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 638.73756877, 'KV', "Ndef(\\foo, { Impulse.ar([1, 12]) * 0.5 }).play" ],
[ 639.255443747, 'me', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 640.665492234, 'me', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 641.63547192, 'me', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 643.649043512, 'KV', "Ndef(\\foo, { Impulse.ar([0.5, 12]) * 0.5 }).play" ],
[ 647.951070709, 'KV', "Ndef(\\foo, { Impulse.ar([0.5, 20]) * 0.5 }).play" ],
[ 653.589820021, 'me', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 653.98945503, 'KK', "Ndef(\\a, { SinOsc.ar(XLine.kr(800,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 666.690085276, 'KV', "NdefMixer(s)" ],
[ 674.34771296, 'me', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 690.542701434, 'KK', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 700.496639449, 'KK', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 702.63486966, 'KK', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 704.515932906, 'KK', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 706.44191344, 'KK', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 708.781984749, 'KK', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 733.359234795, 'KK', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 735.224461987, 'KK', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 736.427452937, 'KK', "Ndef(\\a, { SinOsc.ar(XLine.kr((800..40).choose,100,5) * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 746.02961858, 'KV', "~speed = 8" ],
[ 747.843453939, 'KV', "Ndef(\\crack,  { | in | Crackle.ar( LFNoise0.kr(~speed).range(0.1, 1.75), 0.1, 0.1 )  }).play" ],
[ 749.491407929, 'KV', "Ndef(\\source, { Dust.ar( 1.75.dup ) }).play" ],
[ 750.864988366, 'KV', "Ndef(\\beat, { Impulse.ar([1, ~speed]) * 0.8 }).play(0,2)" ],
[ 753.69702613, 'KV', "(
Ndef(\\dust, {
	var in = Ndef(\\crackle).ar;
	Splay.ar(
		Ringz.ar( in,
			{ ExpRand(200, 1200) }!4,
			\\decay.kr(0.3, 0.5 )
		)
	)
})
)" ],
[ 757.541426987, 'KV', "Ndef(\\dust).fadeTime = 0.4;" ],
[ 758.546410427, 'KV', "Ndef(\\dust).play(0, 2);" ],
[ 759.775616457, 'KV', "(
Ndef(\\crackle, {
	Crackle.ar(LFNoise0.kr(10).range(0.1, 2.0), 0.5, 0.5) * Ndef(\\beat).ar
});
)" ],
[ 763.967578685, 'KV', "Ndef(\\crackle).play(0, 2)" ],
[ 767.965514686, 'KV', "Ndef(\\pad).play" ],
[ 769.01493354, 'KV', "Ndef(\\pad).fadeTime = 2;" ],
[ 770.013376455, 'KV', "Ndef(\\pad, { Resonz.ar( WhiteNoise.ar(0.3.dup, 0.5, 0.5), {ExpRand(220, 1220)}!8, 0.9.rand.max(0.1), mul:0.1) });" ],
[ 774.614943087, 'KV', "Tdef(\\padTask, {
	loop{
		Ndef(\\pad)[0] = { Resonz.ar( WhiteNoise.ar(0.3.dup, 0.5, 0.5), {ExpRand(220, 1220)}!8, 0.9.rand.max(0.1), mul:0.1) };
		3.wait
}
}).play" ],
[ 780.165357742, 'KV', "Ndef(\\pad)[1] = \\filter -> { |in| CombC.ar( CombC.ar( in, 0.6, 0.6 ), 0.02, 0.03 )}" ],
[ 781.6927972, 'KV', "Ndef(\\pad)[2] = \\filter -> { |in| PitchShift.ar ( in, 0.08, 1, 8, 0.5, add:in) }" ],
[ 783.74153523, 'KV', "Ndef(\\pad)[3] = \\filter -> { |in| RHPF.ar( in, 120, 0.6, 0.3 )}" ],
[ 786.19130824, 'me', "Ndef(\\a, { Resonz.ar( WhiteNoise.ar(0.3.dup, 0.5, 0.5), {ExpRand(220, 1220)}!8, 0.9.rand.max(0.1), mul:0.1) });" ],
[ 786.270130419, 'KK', "Ndef(\\a, { SinOsc.ar(500 * [1, 1.2], \\phase.ar([0, 0]) * 0.1) });" ],
[ 788.348673036, 'KV', "Tdef(\\padTask).play" ],
[ 801.384969383, 'KV', "(
Ndef(\\dust, {
	var in = Ndef(\\crackle).ar;
	Splay.ar(
		Ringz.ar( in,
			{ ExpRand(200, 1200) }!4,
			\\decay.kr(0.3, 0.5 )
		)
	)
})
)" ],
[ 804.352173824, 'KV', "(
Ndef(\\dust, {
	var in = Ndef(\\crackle).ar;
	Splay.ar(
		Ringz.ar( in,
			{ ExpRand(200, 1200) }!4,
			\\decay.kr(0.3, 0.5 )
		)
	)
})
)" ],
[ 807.396970716, 'KV', "(
Ndef(\\dust, {
	var in = Ndef(\\crackle).ar;
	Splay.ar(
		Ringz.ar( in,
			{ ExpRand(200, 1200) }!4,
			\\decay.kr(0.3, 0.5 )
		)
	)
})
)" ],
[ 814.217308055, 'KV', "(
Ndef(\\dust, {
	var in = Ndef(\\crackle).ar;
	Splay.ar(
		Ringz.ar( in,
			{ ExpRand(200, 1200) }!4,
			\\decay.kr(0.3, 0.5 )
		)
	)
})
)" ],
[ 816.16854515, 'KV', "(
Ndef(\\dust, {
	var in = Ndef(\\crackle).ar;
	Splay.ar(
		Ringz.ar( in,
			{ ExpRand(200, 1200) }!4,
			\\decay.kr(0.3, 0.5 )
		)
	)
})
)" ],
[ 817.122486552, 'KV', "(
Ndef(\\dust, {
	var in = Ndef(\\crackle).ar;
	Splay.ar(
		Ringz.ar( in,
			{ ExpRand(200, 1200) }!4,
			\\decay.kr(0.3, 0.5 )
		)
	)
})
)" ],
[ 820.372376395, 'KV', "(
Ndef(\\dust, {
	var in = Ndef(\\crackle).ar;
	Splay.ar(
		Ringz.ar( in,
			{ ExpRand(200, 1200) }!4,
			\\decay.kr(0.3, 0.5 )
		)
	)
})
)" ],
[ 821.880878397, 'KV', "(
Ndef(\\dust, {
	var in = Ndef(\\crackle).ar;
	Splay.ar(
		Ringz.ar( in,
			{ ExpRand(200, 1200) }!4,
			\\decay.kr(0.3, 0.5 )
		)
	)
})
)" ],
[ 822.752661062, 'KK', "(
Ndef(\\dust, {
	var in = Ndef(\\crackle).ar;
	Splay.ar(
		Ringz.ar( in,
			{ ExpRand(200, 1200) }!4,
			\\decay.kr(0.3, 0.5 )
		)
	)
})
)" ],
[ 823.366398529, 'KV', "(
Ndef(\\dust, {
	var in = Ndef(\\crackle).ar;
	Splay.ar(
		Ringz.ar( in,
			{ ExpRand(200, 1200) }!4,
			\\decay.kr(0.3, 0.5 )
		)
	)
})
)" ],
[ 824.927081036, 'me', "Ndef.clear(3); // clear all after 3 seconds" ],
[ 828.605011058, 'me', "Ndef(\\a).play;" ],
[ 834.036213705, 'me', "(
Ndef(\\a, {
	var in = Ndef(\\crackle).ar;
	Splay.ar(
		Ringz.ar( in,
			{ ExpRand(200, 1200) }!4,
			\\decay.kr(0.3, 0.5 )
		)
	)
})
)" ],
[ 844.29110117, 'KK', "Ndef(\\a).play;" ],
[ 847.16895228, 'me', "Ndef(\\a).play;" ],
