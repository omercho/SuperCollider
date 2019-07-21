~qc = NetAddr.new("192.168.1.3", 61000);

~qc.sendMsg("/folder", '/Users/OCiMac/Pictures/IFQC_Pics/obje');

~qc.sendMsg("/img", 1);

~qc.sendMsg("/img", 2);

~qc.sendMsg("/img", 3);

(
~rithm.stop;
~rithm={
	inf.do{
		~qc.sendMsg("/yscale", 1);
		~qc.sendMsg("/xscale", rrand(0,2));
		~qc.sendMsg("/ypos", 1);
		~qc.sendMsg("/folder", '/Users/OCiMac/Pictures/IFQC_Pics/obje');
		~qc.sendMsg("/img", rrand(0,6));
		~qc.sendMsg("/alpha", rrand(0.1,1.5));
		~qc.sendMsg("/aVecX", rrand(-5.0,5.0));

		0.3.wait;
		~qc.sendMsg("/folder", '/Users/OCiMac/Pictures/IFQC_Pics/ceket');
		0.6.wait;
	}
}.fork;

)