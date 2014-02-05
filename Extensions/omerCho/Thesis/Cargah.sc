
/*

Makam : Cargah

Seyir : Cikici or Inici-Cikici

Durak : Cargah = C

Guclu : Rast = G

Asma Karar : Neva perdesinde yarim karar Hicaz cesnisi

Yedeni : Buselik = B

Cargah.aralik;
Cargah.kademe;
Cargah.frekans;
Cargah.aralik[\t,\e]


~rast
*/



Cargah {
	classvar <aralik, <kademe, <frekans;

	*initClass {
		StartUp add: {
			this.aralikYap;
			this.kademeYap;
			this.frekansYap;
			this.load;
		}
	}

	*aralikYap {

		aralik = Event make: {

			~f=1; 		//Koma
			~e=3; 		//Koma3
			~b=4; 		//Bakiye
			~s=5; 		//KucukMucenneb
			~k=8; 		//BuyukMucenneb
			~t=9; 		//Tanini
			~a12=12; 		//ArtikIkili
			~a13=13; 		//ArtikIkili
		}

		// Alternative:
		/*
		(
			f: 1,
			e: 3,
			b: 4,
			s: 5,
			k: 8
			// ... etc.

		)

		*/

	}

	*kademeYap {
		aralik use: {
			kademe = 2 ** ([~t, ~t, ~b, ~t, ~t, ~t, ~b] / 53); //Cmajor
		};

	}

	*frekansYap { | root = 256 |


		frekans = Event make: {
			~kabaCargah = root;
			~yegah = ~kabaCargah * kademe[0];
			~huseyniAsiran = ~yegah * kademe[1];
			~acemAsiran = ~huseyniAsiran * kademe[2];
			~rast = ~acemAsiran * kademe[3];
			~dugah = ~rast * kademe[4];
			~buselik = ~dugah * kademe[5];
			~cargah = ~buselik * kademe[6];
			~neva = ~cargah * kademe[0];
			~huseyni = ~neva * kademe[1];
			~acem = ~huseyni * kademe[2];
			~gerdaniye = ~acem * kademe[3];
			~muhayyer = ~gerdaniye * kademe[4];
			~tizBuselik = ~muhayyer * kademe[5];
			~tizCargah = ~tizBuselik * kademe[6];
		}

	}

	*freqsControl {


		^Demand.kr(
			Impulse.kr(4),
			0,
			Dseq(
				[
					~cargah,
					~neva,
					~huseyni,
					~acem,
					~gerdaniye,
					~muhayyer,
					~tizBuselik,
					~tizCargah
				],
				inf
			)
		);

		/*
		^SinOsc.kr(1).range(400, 440);
		^Demand.kr(
			Impulse.kr(8),
			0,
			Drand([Dseq((1..5).mirror1, 1), Drand((4..10), 8)], 2000) * 100
		);
		*/

	}

	*load {
		var i;

			~f=1; 		//Koma
			~e=3; 		//Koma3
			~b=4; 		//Bakiye
			~s=5; 		//KucukMucenneb
			~k=8; 		//BuyukMucenneb
			~t=9; 		//Tanini
			~a12=12; 		//ArtikIkili
			~a13=13; 		//ArtikIkili

		i = 2 ** ([~t, ~t, ~b, ~t, ~t, ~t, ~b] / 53); //Cargah C major


		//	karcigar Rate

		~cRA1 = 1/4;

		~cRA2 = ~cRA1 * i[0];
		~cRA3 = ~cRA2 * i[1];
		~cRA4 = ~cRA3 * i[2];
		~cRA5 = ~cRA4 * i[3];
		~cRA6 = ~cRA5 *i[4];
		~cRA7 = ~cRA6 * i[5];

		~cRB1 = ~cRA7 * i[6];

		~cRB2 = ~cRB1 * i[0];
		~cRB3 = ~cRB2 * i[1];
		~cRB4 = ~cRB3 * i[2];
		~cRB5 = ~cRB4 * i[3];
		~cRB6 = ~cRB5 *i[4];
		~cRB7 = ~cRB6 * i[5];

		~cRC1 = ~cRB7 * i[6];

		~cRC2 = ~cRC1 * i[0];
		~cRC3 = ~cRC2 * i[1];
		~cRC4 = ~cRC3 * i[2];
		~cRC5 = ~cRC4 * i[3];
		~cRC6 = ~cRC5 *i[4];
		~cRC7 = ~cRC6 * i[5];

		~cRD1 = ~cRC7 * i[6];

		~cRD2 = ~cRD1 * i[0];
		~cRD3 = ~cRD2 * i[1];
		~cRD4 = ~cRD3 * i[2];
		~cRD5 = ~cRD4 * i[3];
		~cRD6 = ~cRD5 *i[4];
		~cRD7 = ~cRD6 * i[5];

		~cRE1 = ~cRD7 * i[6];

		~cRE2 = ~cRE1 * i[0];
		~cRE3 = ~cRE2 * i[1];
		~cRE4 = ~cRE3 * i[2];
		~cRE5 = ~cRE4 * i[3];
		~cRE6 = ~cRE5 *i[4];
		~cRE7 = ~cRE6 * i[5];

		~cRF1 = ~cRE7 * i[6];

		~cRF2 = ~cRF1 * i[0];
		~cRF3 = ~cRF2 * i[1];
		~cRF4 = ~cRF3 * i[2];
		~cRF5 = ~cRF4 * i[3];
		~cRF6 = ~cRF5 *i[4];
		~cRF7 = ~cRF6 * i[5];

		~cRG1 = ~cRF7 * i[6];

		~cRG2 = ~cRG1 * i[0];
		~cRG3 = ~cRG2 * i[1];
		~cRG4 = ~cRG3 * i[2];
		~cRG5 = ~cRG4 * i[3];
		~cRG6 = ~cRG5 *i[4];
		~cRG7 = ~cRG6 * i[5];

		//	karcigar Freq

		~cA1 = 256 / 8;

		~cA2 = ~cA1 * i[0];
		~cA3 = ~cA2 * i[1];
		~cA4 = ~cA3 * i[2];
		~cA5 = ~cA4 * i[3];
		~cA6 = ~cA5 *i[4];
		~cA7 = ~cA6 * i[5];

		~cB1 = ~cA7 * i[6];

		~cB2 = ~cB1 * i[0];
		~cB3 = ~cB2 * i[1];
		~cB4 = ~cB3 * i[2];
		~cB5 = ~cB4 * i[3];
		~cB6 = ~cB5 *i[4];
		~cB7 = ~cB6 * i[5];

		~cC1 = ~cB7 * i[6];

		~cC2 = ~cC1 * i[0];
		~cC3 = ~cC2 * i[1];
		~cC4 = ~cC3 * i[2];
		~cC5 = ~cC4 * i[3];
		~cC6 = ~cC5 *i[4];
		~cC7 = ~cC6 * i[5];

		~cD1 = ~cC7 * i[6];

		~cD2 = ~cD1 * i[0];
		~cD3 = ~cD2 * i[1];
		~cD4 = ~cD3 * i[2];
		~cD5 = ~cD4 * i[3];
		~cD6 = ~cD5 *i[4];
		~cD7 = ~cD6 * i[5];

		~cE1 = ~cD7 * i[6];

		~cE2 = ~cE1 * i[0];
		~cE3 = ~cE2 * i[1];
		~cE4 = ~cE3 * i[2];
		~cE5 = ~cE4 * i[3];
		~cE6 = ~cE5 *i[4];
		~cE7 = ~cE6 * i[5];

		~cF1 = ~cE7 * i[6];

		~cF2 = ~cF1 * i[0];
		~cF3 = ~cF2 * i[1];
		~cF4 = ~cF3 * i[2];
		~cF5 = ~cF4 * i[3];
		~cF6 = ~cF5 *i[4];
		~cF7 = ~cF6 * i[5];

		~cG1 = ~cF7 * i[6];

		~cG2 = ~cG1 * i[0];
		~cG3 = ~cG2 * i[1];
		~cG4 = ~cG3 * i[2];
		~cG5 = ~cG4 * i[3];
		~cG6 = ~cG5 *i[4];
		~cG7 = ~cG6 * i[5];

	}

}



/*

{ SinOsc.ar(Cargah.freqsControl, 0, 0.5 ) }.play;
Perde.frekansYap(440)




a = Pseq(#[60, 61, 63, 65, 72], inf).asStream.next;
var trig, seq, freq;
	trig = Impulse.kr(24);
	seq = Drand([Dseq((1..5).mirror1, 1), Drand((4..10), 8)], 2000);
	freq = Demand.kr(trig, 0, seq * 100);

		Demand.kr(
			Impulse.kr(24),
			0,
			Dseq((300..500), inf) * 100
		);

*/



















/*
*ena set apo diastimata
*mia sira apo diast poy ekfrazei tis sxeseis
*i freq tis themeli..



mia klimaka se sxeseis freq vathmidwn

i = to kathe stixio tis stixias einai enas arithmos pou antiprosopevei to diastima anamesa se mia vathmida tis klimakas k tin amesos epomeni bathm tis klimakas se aniusa seira sixnotiton


tha xrisimop to i gis na paroume tis freq olon ton vathmi

i = 2 ** ([~t, ~t, ~b, ~t, ~t, ~t, ~b] / 53); //Cmajor
*/