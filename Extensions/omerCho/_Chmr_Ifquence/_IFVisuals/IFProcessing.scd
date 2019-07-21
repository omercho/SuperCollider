OSCFunc.trace(true); // Turn posting on

~processing = NetAddr.new("192.168.1.8", 12000); // router StudioVag

~processing.sendMsg("/test",3,2);

~processing.sendMsg("/test",1,0.9,"safhg");
~processing.sendMsg("/test", 100.rand, 130.rand);
~processing.sendMsg("/imgPost", 9.rand);

~processing.sendMsg("/test2",1);

~processing.sendMsg("/test3",173,126);
~processing.sendMsg("/test4",17.rand,24.rand);

b.sendMsg("/test", Pseq([50, 24], inf).asStream);

