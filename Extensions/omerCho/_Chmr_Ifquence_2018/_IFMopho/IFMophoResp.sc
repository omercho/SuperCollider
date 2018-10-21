/*
Mopho.masterTranspose(12);
Mopho.masterTune(1);
Mopho.midiClock(0);
Mopho.parameterSend(1);
Mopho.parameterReceive(0);
Mopho.controllerSendReceive(1);
Mopho.sysexSendReceive(1);
Mopho.audioOut(0);
Mopho.midiOut(1);
*/


IFMophoResp{
	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
			this.routines; this.oscMIDI;
			});*/
		}

	}

	*load{
		this.osc;
		this.midi;
	}
	*osc{
		~fadVcaLvl.free;
		~fadVcaLvl= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=val*127;
			~tOSCAdrr.sendMsg('/vcaLvl', val);
			Mopho.vcaLvl(vel);
		},'/vcaLvl');

		~xy1Mopho.free;
		~xy1Mopho= OSCFunc({
			arg msg,val1,val2,vel1,vel2;
			val1=msg[1];
			val2=msg[2];
			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~vMopho.control(~chMopho, 30, vel2);//Sub Osc_1
			~vMopho.control(~chMopho, 31, vel1);//Sub Osc_2
			~tOSCAdrr.sendMsg('xy1Mopho', msg[1], msg[2]);
		},'/xy1Mopho');

		~xy2Mopho.free;
		~xy2Mopho= OSCFunc({
			arg msg,val1,val2,vel1,vel2;
			val1=msg[1];
			val2=msg[2];
			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~vMopho.control(~chMopho, 30, vel2);//Sub Osc_1
			~vMopho.control(~chMopho, 31, vel1);//Sub Osc_2
			~tOSCAdrr.sendMsg('xy1Mopho', msg[1], msg[2]);
		},'/xy1Mopho');

	}
	*midi{

	}
}