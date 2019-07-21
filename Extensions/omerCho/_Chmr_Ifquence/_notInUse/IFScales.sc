/*

*/


IFScales{
	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({
			this.load;
			});
		}

	}

	*load{
		this.osc;
		this.midi;
		this.loadList;
	}
	*loadList{
		~ifSclList = [
			/*00*/Scale.chromatic,
			//5Nt
			/*01*/Scale.minorPentatonic,/*02*/Scale.majorPentatonic,
			/*03*/Scale.ritusen,        /*04*/Scale.egyptian,
			/*05*/Scale.kumoi,          /*06*/Scale.hirajoshi,
			/*07*/Scale.chinese,        /*08*/Scale.indian,
			/*09*/Scale.pelog,          /*10*/Scale.prometheus,
			/*11*/Scale.scriabin,       /*12*/Scale.gong,
			/*13*/Scale.jiao,           /*14*/Scale.zhi,
			/*15*/Scale.yu,             /*16*/Scale.shang,
			//7Nt
			/*17*/Scale.minor,          /*18*/Scale.major,
			/*19*/Scale.harmonicMinor,  /*20*/Scale.harmonicMajor,
			/*21*/Scale.melodicMinor,   /*22*/Scale.melodicMajor,
			/*23*/Scale.ionian,         /*24*/Scale.dorian,
			/*25*/Scale.phrygian,       /*26*/Scale.lydian,
			/*27*/Scale.mixolydian,     /*28*/Scale.aeolian,
			/*29*/Scale.locrian
		];
	}
	*rand{
		~scl2=~ifSclList[(0..28).choose];
	}
	*osc{

	}
	*midi{

	}

}

/*
~ifSclList[17].asStream
*/