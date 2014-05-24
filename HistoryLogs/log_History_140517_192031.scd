// History, as it was on Sat May 17 19:20:31 2014.

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
[ 101.869513711, 'KK', "NdefMixer(s)" ],
[ 120.016123905, 'KV', "Ndef(\\dust, { Dust.ar(0.3) }).play(0, 2)" ],
[ 151.781627885, 'KK', "Ndef(\\dust, { Dust.ar(0.3) }).play(0, 2)" ],
[ 176.547555045, 'me', "Ndef(\\dust, { Dust.ar([0.3,0.5,0.9]) }).play(0, 2);" ],
[ 183.671073115, 'KK', "Ndef(\\dust, { Dust.ar(0.6) }).play(0, 2)" ],
[ 387.164204409, 'me', "Ndef(\\pulse, { Pulse.ar([350, 351.3] / 4, 0.4) * 0.2 });" ],
[ 430.321528782, 'KK', "Ndef(\\pulse, { Pulse.ar([350, 351.3] / 4, 0.4) * 0.2 });" ],
[ 451.15064055, 'KV', "Ndef(\\ringz, {
	var in = Ndef(\\dust).ar;
	Ringz.ar(in)
}).play(0, 2)" ],
[ 459.448804516, 'KK', "Ndef(\\ringz, {
	var in = Ndef(\\dust).ar;
	Ringz.ar(in)
}).play(0, 2)" ],
[ 468.69353456, 'KV', "Ndef(\\dust, { Dust.ar(0.6) }).play(0, 2)" ],
[ 474.809348725, 'KV', "Ndef(\\dust, { Dust.ar(0.8) }).play(0, 2)" ],
