/*
KafesLoadEngine.loadKafs;

*/



KafesLoadEngine {

	*initClass {
		StartUp add: {
			
			//this.loadKafs;

		}
	}	

	*loadKafs {
		Server.default.options.numOutputBusChannels=8;
		Server.default.options.numInputBusChannels=8;
		//Server.default.options.sampleRate=44100;
		Server.default.options.sampleRate=48000;
		Server.default.doWhenBooted({

		KafesReceives.devriKebir;
		KafesReceives.lC1;
		KafesReceives.aP;
		KafesReceives.kP;
		KafesReceives.kk;
		KafesReceives.bit;
		
		
		KafesLayerA.load;
		KafesLayerB.load;
		KafesLayerC.load;
		KafesPLayers.load;
		KafesSpat.ch1;

		
		
		~ats01 = Kaffer.read(Server.default, "sounds/_kafes/atesh/01.aif");
		~ats02 = Kaffer.read(Server.default, "sounds/_kafes/atesh/02.aif");
		~ats03 = Kaffer.read(Server.default, "sounds/_kafes/atesh/03.aif");
		~ats04 = Kaffer.read(Server.default, "sounds/_kafes/atesh/04.aif");
		~ats05 = Kaffer.read(Server.default, "sounds/_kafes/atesh/05.aif");
		~ats06 = Kaffer.read(Server.default, "sounds/_kafes/atesh/06.aif");
		~ats07 = Kaffer.read(Server.default, "sounds/_kafes/atesh/07.aif");//*not in use
		
		
		
		//------------------------bot-----------------------------------//
		~bot01 = Kaffer.read(Server.default, "sounds/_kafes/bot/01.aif");//*not in use
		~bot02 = Kaffer.read(Server.default, "sounds/_kafes/bot/02.aif");//*not in use
		~bot03 = Kaffer.read(Server.default, "sounds/_kafes/bot/03.aif");//*not in use
		~bot04 = Kaffer.read(Server.default, "sounds/_kafes/bot/04.aif");//*not in use
		~bot05 = Kaffer.read(Server.default, "sounds/_kafes/bot/05.aif");//*not in use
		~botbs = Kaffer.read(Server.default, "sounds/_kafes/bot/bas.aif");//*not in use


		//------------------------bigs-----------------------------------//
		~big01 = Kaffer.read(Server.default, "sounds/_kafes/bigs/01.aif");//*not in use
		~big02 = Kaffer.read(Server.default, "sounds/_kafes/bigs/02.aif"); 
		
		
		
		//------------------------botahth-----------------------------------//
		~bth01 = Kaffer.read(Server.default, "sounds/_kafes/botaht/01.aif");
		~bth02 = Kaffer.read(Server.default, "sounds/_kafes/botaht/02.aif");
		~bth03 = Kaffer.read(Server.default, "sounds/_kafes/botaht/03.aif");//*not in use
		~bth04 = Kaffer.read(Server.default, "sounds/_kafes/botaht/04.aif");
		~bth05 = Kaffer.read(Server.default, "sounds/_kafes/botaht/05.aif");
		~bth06 = Kaffer.read(Server.default, "sounds/_kafes/botaht/06.aif");
		~bth07 = Kaffer.read(Server.default, "sounds/_kafes/botaht/07.aif");
		
		
		~gir01 = Kaffer.read(Server.default, "sounds/_kafes/gir/01.aif");
		~gir02 = Kaffer.read(Server.default, "sounds/_kafes/gir/02.aif");
		~gir03 = Kaffer.read(Server.default, "sounds/_kafes/gir/03.aif");//*not in use
		~gir04 = Kaffer.read(Server.default, "sounds/_kafes/gir/04.aif");
		
		
		~gou01 = Kaffer.read(Server.default, "sounds/_kafes/goun/01.aif");
		~gou02 = Kaffer.read(Server.default, "sounds/_kafes/goun/02.aif");
		~gou03 = Kaffer.read(Server.default, "sounds/_kafes/goun/03.aif");
		~gou04 = Kaffer.read(Server.default, "sounds/_kafes/goun/04.aif");//*not in use
		~gou05 = Kaffer.read(Server.default, "sounds/_kafes/goun/05.aif");
		
		
		~grn01 = Kaffer.read(Server.default, "sounds/_kafes/grain/01.aif");//*not in use
		~grn02 = Kaffer.read(Server.default, "sounds/_kafes/grain/02.aif");//*not in use
		
		
		~int01 = Kaffer.read(Server.default, "sounds/_kafes/int/01.aif");//*not in use
		~int02 = Kaffer.read(Server.default, "sounds/_kafes/int/02.aif");//*not in use
		~int03 = Kaffer.read(Server.default, "sounds/_kafes/int/03.aif");//*not in use
		~int04 = Kaffer.read(Server.default, "sounds/_kafes/int/04.aif");//*not in use
		~int05 = Kaffer.read(Server.default, "sounds/_kafes/int/05.aif");//*not in use
		~int06 = Kaffer.read(Server.default, "sounds/_kafes/int/06.aif");//*not in use
		
		~kik01 = Kaffer.read(Server.default, "sounds/_kafes/kick/01.aif");
		~kik02 = Kaffer.read(Server.default, "sounds/_kafes/kick/02.aif");
		~kik03 = Kaffer.read(Server.default, "sounds/_kafes/kick/03.aif");
		
		
		~met01 = Kaffer.read(Server.default, "sounds/_kafes/metal/01.aif");//*not in use
		~met02 = Kaffer.read(Server.default, "sounds/_kafes/metal/02.aif");
		~met03 = Kaffer.read(Server.default, "sounds/_kafes/metal/03.aif");
		~met04 = Kaffer.read(Server.default, "sounds/_kafes/metal/04.aif");//*not in use
		~met05 = Kaffer.read(Server.default, "sounds/_kafes/metal/05.aif");//*not in use
		~met06 = Kaffer.read(Server.default, "sounds/_kafes/metal/06.aif");//*not in use
		~met07 = Kaffer.read(Server.default, "sounds/_kafes/metal/07.aif");//*not in use
		~met08 = Kaffer.read(Server.default, "sounds/_kafes/metal/08.aif");//*not in use
		~met09 = Kaffer.read(Server.default, "sounds/_kafes/metal/09.aif");//*not in use
		~met10 = Kaffer.read(Server.default, "sounds/_kafes/metal/10.aif");//*not in use
		
		
		~psl01 = Kaffer.read(Server.default, "sounds/_kafes/psiles/01.aif");//*not in use
		~psl02 = Kaffer.read(Server.default, "sounds/_kafes/psiles/02.aif");//*not in use
		
		~rit01 = Kaffer.read(Server.default, "sounds/_kafes/ritm/01.aif");
		~rit02 = Kaffer.read(Server.default, "sounds/_kafes/ritm/02.aif");
		~rit03 = Kaffer.read(Server.default, "sounds/_kafes/ritm/03.aif");
		~rit04 = Kaffer.read(Server.default, "sounds/tiktik.aif");//*not in use
		~rit05 = Kaffer.read(Server.default, "sounds/cut.aiff");//*not in use
		
		~sis01 = Kaffer.read(Server.default, "sounds/_kafes/sise/01.aif");//*not in use
		~sis02 = Kaffer.read(Server.default, "sounds/_kafes/sise/02.aif");//*not in use
		~sis03 = Kaffer.read(Server.default, "sounds/_kafes/sise/03.aif");//*not in use
		~sis04 = Kaffer.read(Server.default, "sounds/_kafes/sise/04.aif");//*not in use
		~sis05 = Kaffer.read(Server.default, "sounds/_kafes/sise/05.aif");//*not in use
		~sis06 = Kaffer.read(Server.default, "sounds/_kafes/sise/06.aif");//*not in use
		~sis07 = Kaffer.read(Server.default, "sounds/_kafes/sise/07.aif");//*not in use
		~sis08 = Kaffer.read(Server.default, "sounds/_kafes/sise/08.aif");
		~sis09 = Kaffer.read(Server.default, "sounds/_kafes/sise/09.aif");//*not in use
		
		~sms01 = Kaffer.read(Server.default, "sounds/_kafes/sms/01.aif");//*not in use
		
		
		~tht01 = Kaffer.read(Server.default, "sounds/_kafes/tahta/01.aif");
		~tht02 = Kaffer.read(Server.default, "sounds/_kafes/tahta/02.aif");
		~tht03 = Kaffer.read(Server.default, "sounds/_kafes/tahta/03.aif");//*not in use
		~tht04 = Kaffer.read(Server.default, "sounds/_kafes/tahta/04.aif");//*not in use
		~tht05 = Kaffer.read(Server.default, "sounds/_kafes/tahta/05.aif");//*not in use
		~tht06 = Kaffer.read(Server.default, "sounds/_kafes/tahta/06.aif");//*not in use
		~tht07 = Kaffer.read(Server.default, "sounds/_kafes/tahta/07.aif");//*not in use
		~tht08 = Kaffer.read(Server.default, "sounds/_kafes/tahta/08.aif");
		~tht09 = Kaffer.read(Server.default, "sounds/_kafes/tahta/09.aif");//*not in use
		
		
		
		~tol01 = Kaffer.read(Server.default, "sounds/_kafes/thol/01.aif");
		~tol02 = Kaffer.read(Server.default, "sounds/_kafes/thol/02.aif");//*not in use
		~tol03 = Kaffer.read(Server.default, "sounds/_kafes/thol/03.aif");
		~tol04 = Kaffer.read(Server.default, "sounds/_kafes/thol/04.aif");//*not in use
		~tol05 = Kaffer.read(Server.default, "sounds/_kafes/thol/05.aif");//*not in use
		~tol06 = Kaffer.read(Server.default, "sounds/_kafes/thol/06.aif");
		~tol07 = Kaffer.read(Server.default, "sounds/_kafes/thol/07.aif");
		~tol08 = Kaffer.read(Server.default, "sounds/_kafes/thol/08.aif");
		"sounds are loaded".postln;
		});
		
	}	
	
	
}