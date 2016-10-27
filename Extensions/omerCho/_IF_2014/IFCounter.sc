/*
IFCounter.count;
*/
IFCounter{
classvar <>counter=0;

	*zero{

		counter = 0;
		~tOSCAdrr.sendMsg('mainCountLabel', counter);


	}
	*reset{

		counter = 1;
		~tOSCAdrr.sendMsg('mainCountLabel', counter);


	}

	*count {

		counter = counter + 1;
		~tOSCAdrr.sendMsg('mainCountLabel', counter);
		counter.switch(
			9, {
				//("Main Count: "+counter).postln;
				this.ctrl_8;
				this.reset;

			}

		)
	}


	*ctrl_8 {



		/*~res1Mcr2.stop;
		~res1Mcr2={
			var val;
			val = Pslide((30..100).mirror, inf,3,1,0).asStream;
			240.do{
				~mdOut.control(~res1Ch, ~res1Mac2, val.next);
			(~dur.next*(1/8)).wait;
			}
		}.fork;*/

	}


}