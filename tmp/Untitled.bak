
~dur1.source=Pshuf([1,0.5,2,0.5]*2,inf);
~dur2.source=Pshuf([1,0.5,2,0.5]*2,inf);
~dur3.source=Pshuf([1,0.5,2,0.5]*2,inf);
~dur4.source=Pshuf([1,0.5,2,0.5]*2,inf);
~durMaster.source=Pshuf([1,0.5,2,0.5]*2,inf);

~dur1.source=Pshuf([1]*2,inf);
~dur2.source=Pshuf([1]*2,inf);
~dur3.source=Pshuf([1]*2,inf);
~dur4.source=Pshuf([1]*2,inf);

IFRoot.set(\durPatSeq1,127);
IFRoot.set(\durMulSeq1,127);

~test=Pseq([Pxrand([\a,\b,\c],1),Pwhite(0, 127, 1)],inf).asStream;
~test.next;


Mopho.bank(~chMopho,2/*0-2*/,59/*0-2*/);

~vMopho.program(0,127);


~vMopho.control(0,32,0);

*loadLists{

		~bankLst = [\a,\b,\c];

	}
	*prog{|ch,bnk,prg|
		bnk.switch(
			\a, {~vMopho.control(ch, 0, /*0-2*/0);~vMopho.program(ch, prg);},
			\b, {~vMopho.control(ch, 0, 1);~vMopho.program(ch, prg);},
			\c, {~vMopho.control(ch, 0, 2);~vMopho.program(ch, prg);},
		);
	}
	*bank{|chan,bank,prog|
		Mopho.prog(ch:chan,bnk:~bankLst[bank],prg:prog);
	}
	