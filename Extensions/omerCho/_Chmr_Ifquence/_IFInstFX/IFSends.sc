IFSends{
	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
			1.0.wait;
			this.globals;
			this.mulFaders;
			this.main;
			this.parts;
			});*/
		}
	}
	*load {
		this.makeOSCResponders;
		//this.mutes;
	}
	*lbl1{|key,val1=0|
		~tOSCAdrr.sendMsg(key,val1);
	}
	*lbl2{|key, val1=0, val2=0|
		var chan;
		~tOSCAdrr.sendMsg(key,val1,val2);
	}
	*set1{|key,val1=0|
		var vel1;
		vel1=val1*127;
		key.switch(
			\comp, {
				~crntFX_comp=val1;
				this.lbl1(\IFXcomp,val1);
				~mdOut.control(1, 6, vel1); //FX Comp
			},
			\dec, {
				~crntFX_dec=val1;
				this.lbl1(\IFXdec,val1);
				~mdOut.control(1, 20, vel1); //FX dec
			},
			\vol1, {
				~crntFX_vol1=val1;
				this.lbl1(\IFXvol1,val1);
				~mdOut.control(1, 0, vel1); //FX vol1
			},
			\fad1, {
				~crntFX_fad1=val1;
				this.lbl1(\IFXfad1,val1);
				~mdOut.control(1, 3, vel1); //FX Fader1
			},
			\vol2, {
				~crntFX_vol2=val1;
				this.lbl1(\IFXvol2,val1);
				~mdOut.control(1, 1, vel1); //FX vol2
			},
			\fad2, {
				~crntFX_fad2=val1;
				this.lbl1(\IFXfad2,val1);
				~mdOut.control(1, 8, vel1); //FX Fader2
			},
		);
	}
	*set2{|key, val1=0, val2=0|
		var vel1,vel2;
		vel1=val1*127;
		vel2=val2*127;
		key.switch(
			\xyFx1, {
				this.lbl2(\IFXxy1,val1,val2);
				~mdOut.control(1, 4, vel1);
				~mdOut.control(1, 5, vel2);
				~crntFX1_xy1X=val2;
				~crntFX1_xy1Y=val1;
			},
			\xyFx2, {
				this.lbl2(\IFXxy2,val1,val2);
				~mdOut.control(1, 9, vel1);
				~mdOut.control(1, 10, vel2);
				~crntFX2_xy2X=val2;
				~crntFX2_xy2Y=val1;
			},

		);
	}
	*oscResp{|respName,oscName,playTag|
		OSCdef(respName, {|msg|
			var val, val1,val2;
			val= msg[1];
			val1= msg[1];
			val2= msg[2];
			playTag.switch(
				'comp_T' , { this.set1(\comp,val);},
				'dec_T' , { this.set1(\dec,val);},
				'vol1_T' , { this.set1(\vol1,val);},
				'fad1_T' , { this.set1(\fad1,val);},
				'vol2_T' , { this.set1(\vol2,val);},
				'fad2_T' , { this.set1(\fad2,val);},
				'xy1_T' , { this.set2(\xyFx1,val1,val2);},
				'xy2_T' , { this.set2(\xyFx2,val1,val2);},
			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\compResp, oscName:\IFXcomp, playTag:'comp_T');
		this.oscResp(respName:\decResp, oscName:\IFXdec, playTag:'dec_T');
		this.oscResp(respName:\vol1Resp, oscName:\IFXvol1, playTag:'vol1_T');
		this.oscResp(respName:\fad1Resp, oscName:\IFXfad1, playTag:'fad1_T');
		this.oscResp(respName:\vol2Resp, oscName:\IFXvol2, playTag:'vol2_T');
		this.oscResp(respName:\fad2Resp, oscName:\IFXfad2, playTag:'fad2_T');
		this.oscResp(respName:\xyFx1Resp,  oscName:\IFXxy1, playTag:'xy1_T');
		this.oscResp(respName:\xyFx2Resp,  oscName:\IFXxy2, playTag:'xy2_T');
	}
}