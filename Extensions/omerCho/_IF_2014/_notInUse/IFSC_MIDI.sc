IFSC_MIDI {

	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
				this.midiAdrr;
				1.2.wait;
				this.vBass;
				this.vKeys;
				this.latency;

			});*/
		}
	}

	*midiAdrr{



	}

	*vBass{

	}

	*vKeys{

	}

	*latency{

		~grp1=0.00;
		Server.default.latency=~grp1;
		~vBeats.latency=~grp1;
		~vBass.latency=~grp1;
		~vKeys.latency=~grp1;


	}

}