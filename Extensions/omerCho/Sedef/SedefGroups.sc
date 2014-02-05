/*
SedefGroups.load;
*/

SedefGroups {
	*load {

		
		~piges = Group.head(Server.default);
		~effe = Group.tail(Server.default);
		~recorders = Group.new(~effe, \addAfter);

	}
	
	*unLoad { 

		~piges.free;
		~effe.free;
		~recorders.free;		

	}
	

	
	
}