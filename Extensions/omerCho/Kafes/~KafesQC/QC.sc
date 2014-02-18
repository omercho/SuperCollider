
/*

QC.img("tekme", 1, 0.8, 0.0, 0.0, 1.0, 0.8, 90);

~visRout.stop;
~visRout = {
	~seq = Pseq((0..16).mirror,inf).asStream;
	inf.do{

		QC.img('deliKapali', ~seq.next, 1);
		0.08.wait;


	}
}.fork;


{

	~qc.sendMsg("/img", 1); ~qc.sendMsg("/alph", 0.8); ~qc.sendMsg("/folder", "/Users/omerchatziserif/Media/Pics/~Kafes800*800/tekme");

}.fork;

*/

QC {

	classvar <>folderr = "box", <>indexx = 0, <>alphaa = 1.0, <>xposs = 1.0, <>yposs = 1.0, <>xscalee = 1.0, <>yscalee = 1.0, <>rotatee = 0;


	*initClass {
		StartUp add: {

			this.dest;

		}
	}

	*dest {

		//~qc = NetAddr.new("localhost", 60000);
		~qc = NetAddr.new("localhost", 61000);
		//~qc = NetAddr.new("localhost", 57120);

	}

	*img { arg folder, index, alpha, xpos, ypos, xscale, yscale, rotate;
		folderr = folder ? folderr;
		indexx = index ? indexx;
		alphaa = alpha ? alphaa;
		xposs = xpos ? xposs;
		yposs = ypos ? yposs;
		xscalee = xscale ? xscalee;
		yscalee = yscale ? yscalee;
		rotatee = rotate ? rotatee;

		{
			~qc.sendMsg("/folder", "/Users/omercho/~KafesImages/"++folderr);
			~qc.sendMsg("/img", indexx);
			~qc.sendMsg("/alpha", alphaa);
			~qc.sendMsg("/xpos", xposs);
			~qc.sendMsg("/ypos", yposs);
			~qc.sendMsg("/xscale", xscalee);
			~qc.sendMsg("/yscale", yscalee);
			~qc.sendMsg("/rotate", rotatee);
			"qc".postln;

		}.fork;

	}

}

////////////////////////////////////////---------------------------//////////////////////////////

/*

QC.img("tekme", 1, 0.8, 0.6, 0.8, 90);
(
~visRout.stop;
~visRout = {
	~seq = Pseq((1..4).mirror,inf).asStream;
	~xsc = Pwhite(0.5, 1.5, inf).asStream;
	~ysc = Pwhite(0.5, 1.5, inf).asStream;
	inf.do{

		//QC.img('tekme', ~seq.next, 1);
		QC.img("tekme", ~seq.next, 0.4 rrand: 0.9, -0.5 rrand: 0.5, -0.5 rrand: 0.5, ~xsc.next, ~ysc.next, [0,90,180,360].choose);
		0.1.wait;


	}
}.fork;
)

{

	~qc.sendMsg("/img", 1); ~qc.sendMsg("/alph", 0.8); ~qc.sendMsg("/folder", "/Users/omerchatziserif/Media/Pics/~Kafes800*800/tekme");

}.fork;

*/