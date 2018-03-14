
[
//Custom Bridge Scales

	\gec1 -> 	       Scale.new(#[0, 1, -2, 2, 2.21, 4, 3], 3, name: "Gec 1"),
	\gec2 -> 	       Scale.new(#[0, -1, -3], 4, name: "Gec 1"),

] do: { | assoc | Scale.all.put(assoc.key, assoc.value) }


/*
try

(
s.waitForBoot({
	a = Scale.hicaz;

	p = Pbind(
		\degree, Pseq([0, 1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1, 0, \rest], inf),
		\scale, Pfunc({ a }, inf),
		\dur, 0.5
	);

	q = p.play;
})
)

// change scale
a = Scale.gec1;
a = Scale.gec2;
a = Scale.cargah;
a = Scale.buselik;
a = Scale.kurdi;
a = Scale.rast;
a = Scale.ussak;
a = Scale.beyati;

a = Scale.humayun;
a = Scale.hicaz;
a = Scale.uzzal;
a = Scale.zirguleliHicaz;
a = Scale.huseyni;
a = Scale.muhayyer;
a = Scale.neva;
a = Scale.tahir;
a = Scale.karcigar;
a = Scale.basitSuznak;
a = Scale.sipihrEski;


*/