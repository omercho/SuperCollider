
/*

Create TCM Makams
OmerChatziserif 2011


*/

	[
		//TSM Makamlari
		
		//Basit Makamlar
		
			\cargah -> 	Scale.new(#[0, 9, 18, 22, 31, 40, 49], 53, name: "Cargah"),
			\buselik ->  	Scale.new(#[0, 9, 13, 22, 31, 35, 44], 53, name: "Buselik"), //cikici or cikci-inici
			\kurdi -> 	Scale.new(#[0, 4, 13, 22, 31, 35, 44], 53, name: "Kurdi"), //cikici or cikci-inici
			\rast -> 		Scale.new(#[0, 9, 17, 22, 31, 40, 48], 53, name: "Rast"), //cikici
			\ussak -> 	Scale.new(#[0, 8, 13, 22, 31, 35, 44], 53, name: "Ussak"), //cikici
			\beyati -> 	Scale.new(#[0, 8, 13, 22, 31, 35, 44], 53, name: "Beyati"), //cikici-inici
		
		//Hicaz Ailesi
		
			\humayun -> 	Scale.new(#[0, 5, 17, 22, 31, 35, 44], 53, name: "Humayun"), //cikici-inici
			\hicaz -> 	Scale.new(#[0, 5, 17, 22, 31, 39, 44], 53, name: "Hicaz"), //inici-cikici or cikici
			\uzzal -> 	Scale.new(#[0, 5, 17, 22, 31, 39, 44], 53, name: "Uzzal"), //inici-cikici or cikici
			\zirguleliHicaz -> Scale.new(#[0, 5, 17, 22, 31, 36, 48], 53, name: "Zirguleli Hicaz"), //inici-cikici
			\huseyni -> 	Scale.new(#[0, 8, 13, 22, 31, 39, 44], 53, name: "Huseyni"), //inici-cikici
			\muhayyer -> 	Scale.new(#[0, 9, 14, 22, 31, 40, 45], 53, name: "Muhayyer"), //inici
			\neva -> 		Scale.new(#[0, 8, 13, 22, 31, 39, 44], 53, name: "Neva"), //inici-cikici
			\tahir -> 	Scale.new(#[0, 9, 14, 22, 31, 40, 45], 53, name: "Tahir"), //inici
			\karcigar -> 	Scale.new(#[0, 8, 13, 22, 27, 39, 44], 53, name: "Karcigar"), //inici-cikici
			\basitSuznak -> Scale.new(#[0, 9, 17, 22, 31, 36, 48], 53, name: "Basit Suznak"), //inici-cikici
			
		//Murekkeb Makamlar
			\sipihrEski -> Scale.new(#[0, 9, 14, 22, 31, 40, 45], 53, name: "Sipihr (eski)"), //inici i = 2 ** ([~t, ~s, ~k, ~t, ~t, ~s, ~k] / 53);
	
	] do: { | assoc | ScaleInfo.scales.put(assoc.key, assoc.value) }


/*
try

(
s.waitForBoot({
	a = Scale.hicaz;
	
	p = Pbind(
		\degree, Pseq([0, 1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1, 0, \rest], inf),
		\scale, Pfunc({ a }, inf),
		\dur, 0.25
	);
	
	q = p.play;
})
)

// change scale
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