
Dests {
	classvar <>mitsosAddr, <>myAddr, <>comInAddr, <>vagAddr;

	*initClass {
		StartUp.add{
			mitsosAddr = NetAddr("10.1.60.2", 57120);
			vagAddr = NetAddr("10.1.60.3", 57120);
			myAddr = NetAddr.localAddr;
			comInAddr = NetAddr("10.1.60.91", 10001);
		}
	}
}

SendTags {

	var <>num=0, <>step=0.25, <>title, <>steppattern, <>tagPat, task, verbose = true;
	var  <>dests, <>tag, <>tagg, <>stp, <>x;
	var tag2;
	var <>tags;

	immediate {
		verbose = true;
	}

	atEnd {
		verbose = false;
	}

	loop {
		tagPat = PatternProxy(Pseq([nil], inf));
		steppattern = PatternProxy(Pseq([0.2], inf));
		tagg = tagPat.asStream;
		stp = steppattern.asStream;
		task = Task({
			inf.do{
				tagPat.source = Pseq(tags, inf);
				steppattern.source = Pseq(step, inf);
				verbose.switch(
					true, {
						num = tags.numChannels;
						num.do{
							x = tagg.next;
							dests do: _.sendMsg(title.asString, x);
							stp.next.wait;
							//tag = tag+1;
						}
					},
					false, {
						steppattern.source = Pseq(step, inf);
						num.do{
							x = tagg.next;
							stp = steppattern.asStream;
							dests do: _.sendMsg(title.asString, x);
							//stp.next.postln;
							stp.next.wait;
							//tag = tag+1;
						}
					}
				)
			}
		});
		task.start;
	}
	pause {
		task.pause;
	}
	resume {
		task.resume;
	}
	reset {
		task.reset;
	}
	stop {
		task.stop;
	}

}


RespTags {
	var <>title, <>tag, <>action, <>responder;

//	*new { |tags|
//		super.newCopyArgs(tags);
//	}

	*do { |title, tag, action, responder|
		^super.newCopyArgs(title, tag, action, responder).addResp;
	}

	addResp {
		responder = OSCresponderNode(nil, title.asString, {arg time, resp, msg; /*msg[1].postln;*/
			msg[1].switch( tag,
				action
			 );
		}).add;
	}

	removeResp {
		responder.remove;
	}

	removeWhenDone {
		responder.removeWhenDone;
	}
}

CountRespTags {
	var counter, times, counterTimes, <>numCounter, <>resps, sendTagsSize, <>sendTags, respNames, <>counter2, <>counterResps, c,
		numCountResps, numCountResps2,
		<>currentCount, <>counterAll;

	prepare {
		counterAll = 0;
		if(sendTags == nil, {"no SendTags Instance".error}, {
			currentCount = 1;
			times = 1;
			counterTimes = 1;
			sendTagsSize = sendTags.tags.size;
			resps = IdentityDictionary.new;
			counterResps = IdentityDictionary.new;
			numCounter.do({
				sendTagsSize.do({ arg i;
					resps[("countResp" ++ times.asString ++ "_" ++ (i+1).asString).asSymbol] = RespTags.do(sendTags.title, i+1, nil);
					i = i+1;
				});
				times = times + 1;
			});
			counterTimes = 1;
			counter2  = 0;
			c = 1;
			numCountResps = Pseq((1..numCounter), inf).asStream;
			numCountResps2 = Pseq((1..numCounter), inf, 1).asStream;

		});
	}

	load {
		//counterResps.collect {|resps| resps.removeResp};
		numCounter.do({
			var d, h;
			d =	numCountResps.next;
			h = numCountResps2.next;

			h.postln;
			d.postln;
			counterAll = 0;
			counterResps[("counter" ++ d.asString).asSymbol] = RespTags.do(sendTags.title, sendTagsSize, {

				counterAll = counterAll + 1;
				counterAll.switch(
					1, {
						resps.collect {|resp| resp.removeResp};
						sendTagsSize.do({ arg i;

							 resps[("countResp" ++ h.asString ++ "_" ++ (i+1).asString).asSymbol].addResp;
							i = i + 1;
						});
						counterAll = 0;
						counterResps.collect {|resps| resps.removeResp};
						counterResps[("counter" ++ h.asString).asSymbol].addResp;
					},
					counterAll
				)
			});

		});

	}

	remove {
			numCounter.do({
				sendTagsSize.do({ arg i;
					resps[("countResp" ++ times.asString ++ "_" ++ (i+1).asString).asSymbol].removeResp;
					i = i+1;
				});
				times = times + 1;
			});

	}
}

//
//CountRespTags {
//	var counter, times, counterTimes,  <>resps, sendTagsSize,  respNames, <>counter2, <>counterResps, c,
//		numCountResps, numCountResps2;
//	var <>sendTags, <>numCounter;
//
//
//	load {
//		~counterAll = 0;
//		if(sendTags == nil, {"no SendTags Instance".error}, {
//			times = 1;
//			counterTimes = 1;
//			sendTagsSize = sendTags.tags.size;
//			resps = IdentityDictionary.new;
//			counterResps = IdentityDictionary.new;
//			numCounter.do({
//				sendTagsSize.do({ arg i;
//					resps[("countResp" ++ times.asString ++ "_" ++ (i+1).asString).asSymbol] = RespTags.do(sendTags.title, i+1, nil);
//					i = i+1;
//				});
//				times = times + 1;
//			});
//			counterTimes = 1;
//			counter2  = 0;
//			c = 1;
//			numCountResps = Pseq((1..numCounter), inf).asStream;
//			numCountResps2 = Pseq((1..numCounter), inf, 1).asStream;
//		});
//		this.tags[sendTags.size].postln;
//		numCounter.do({
//			var d, h;
//			d =	numCountResps.next;
//			h = numCountResps2.next;
//			h.postln;
//			d.postln;
//			~counterAll = 0;
//			counterResps[("counter" ++ d.asString).asSymbol] = RespTags.do(sendTags.title, sendTagsSize, {
//				~counterAll = ~counterAll + 1;
//				~counterAll.switch(
//					1, {
//						resps.collect {|resp| resp.removeResp};
//						sendTagsSize.do({ arg i;
//							 resps[("countResp" ++ h.asString ++ "_" ++ (i+1).asString).asSymbol].addResp;
//							i = i + 1;
//						});
//						~counterAll = 0;
//						counterResps.collect {|resps| resps.removeResp};
//						counterResps[("counter" ++ h.asString).asSymbol].addResp;
//					},
//					~counterAll
//				)
//			});
//
//		});
//
//	}
//}


//RespClockTags { var <>title, <>tags, <>actions, <>numTags1, <>numTags2, num = 0;
//
//	addResp {
//		numTags1 = tags.size;
//		fork{
//			numTags1.do{
//				OSCresponderNode(nil, title.asString, {arg time, resp, msg; /*msg[1].postln;*/
//					msg[1].switch( tags[num],
//					actions[num]
//						 );
//					}).add;
//				num.postln;
//				num = num + 1;
//				//numTags = numTags;
//			}
//		};
//		fork{
//			inf.do{
//				var count;
//				numTags2 = tags.size;
//				if((numTags2 != numTags1) && (numTags2 > numTags1),
//					{ count = numTags2 - numTags1;
//						count.do{
//							OSCresponderNode(nil, title.asString, {arg time, resp, msg;
//								msg[1].switch( tags[num],
//								actions[num]
//									 );
//								}).add;
//							num.postln;
//							num = num + 1;
//							  };
//					},
//					{  }
//
//				);
//				0.001.wait;
//			}
//		};
//
//
//	}
//
//}
