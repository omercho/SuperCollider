

/*
ZKM1Buffers.load;
*/


SedefBuffers {
	*load {

		
		~bufA = Buffer.alloc(Server.default, Server.default.sampleRate * 8, 1);
		~bufB = Buffer.alloc(Server.default, Server.default.sampleRate * 8, 1);
		
		~bufIn = Buffer.alloc(Server.default, Server.default.sampleRate * 8, 1);
		~bufTap = Buffer.alloc(Server.default, Server.default.sampleRate * 8, 1);
		
		
		
	}
	
	*unLoad { 
		
		~bufA.free;
		~bufB.free;
		
		~bufIn.free;
		~bufTap.free;


	}

}