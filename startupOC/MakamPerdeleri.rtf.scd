

/*
TM bir sekizlide bulunan 24 aralik ile 25 ses

OmerChatziserif100308

*/


currentEnvironment use: {
	~f=1; ~e=3; ~b=4; ~s=5; ~k=8; ~t=9; ~a12=12; ~a13=13;

	i = 2 ** ([~f, ~e, ~b, ~s, ~k, ~t] / 53);

	~kabaCargah = 256;
	~kabaNimHicaz = ~kabaCargah * i[2];
	~kabaHicaz = ~kabaCargah * i[3];
	~kabaDikHicaz = ~kabaCargah * i[4];
	~yegah = ~kabaCargah * i[5];
	~kabaNimHisar = ~yegah * i[2];
	~kabaHisar = ~yegah * i[3];
	~kabaDikHisar = ~yegah * i[4];
	~huseyniAsiran = ~yegah * i[5];
	~acemAsiran = ~huseyniAsiran * i[2];
	~dikAcemAsiran = ~acemAsiran * i[0];
	~irak = ~acemAsiran * i[2];
	~gevest = ~acemAsiran * i[3];
	~dikGevest = ~acemAsiran * i[4];
	~rast = ~acemAsiran * i[5];
	~nimZirgule = ~rast * i[2];
	~zirgule = ~rast * i[3];
	~dikZirgule = ~rast * i[4];
	~dugah = ~rast * i[5];
	~kurdi = ~dugah * i[2];
	~dikKurdi = ~dugah * i[3];
	~segah = ~dugah * i[4];
	~buselik = ~dugah * i[5];
	~dikBuselik = ~buselik * i[1];
	~cargah = ~buselik * i[2];
	~nimHicaz = ~cargah * i[2];
	~hicaz = ~cargah * i[3];
	~dikHicaz = ~cargah * i[4];
	~neva = ~cargah * i[5];
	~nimHisar = ~neva * i[2];
	~hisar = ~neva * i[3];
	~dikHisar = ~neva * i[4];
	~huseyni = ~neva *i[5];
	~acem = ~huseyni * i[2];
	~dikAcem = ~acem * i[0];
	~evic = ~acem * i[2];
	~mahur = ~acem * i[3];
	~dikMahur = ~acem * i[4];
	~gerdaniye = ~acem * i[5];
	~nimSehnaz = ~gerdaniye * i[2];
	~sehnaz = ~gerdaniye * i[3];
	~dikSehnaz = ~gerdaniye * i[4];
	~muhayyer = ~gerdaniye * i[5];
	~sunbule = ~muhayyer * i[2];
	~dikSunbule = ~muhayyer * i[3];
	~tizSegah = ~muhayyer * i[4];
	~tizBuselik = ~muhayyer * i[5];
	~tizDikBuselik = ~tizBuselik * i[1];
	~tizCargah = ~tizBuselik * i[2];




};


/*


Do      Kaba Cargah           =      256
          Kaba Nim Hicaz      =      269.74860677197
          Kaba Hicaz          =      273.29961601229
          Kaba Dik Hicaz      =      284.23558927899
Re      Yegah                 =      287.97730722903
          Kaba Nim Hisar      =      303.443271121
          Kaba Hisar          =      307.43784174198
          Kaba Dik Hisar      =      319.73984226257
Mi      Huseyni Asiran        =      323.94894327688
Fa      Acem Asiran           =      341.34678169606
          Dik Acem Asiran     =      345.8403195514
          Irak                =      359.67897964301
          Gevest              =      364.41384517408
          Dik Gevest          =      378.99571735885
Sol     Rast                  =      383.984871188
          Nim Zirgule         =      404.60696884562
          Zirgule             =      409.93327285238
          Dik Zirgule         =      426.33658647006
La      Dugah                 =      431.94894227111
          Kurdi               =      455.1469741182
          Dik Kurdi           =      461.13859398285
          Segah               =      479.59086775338
Si       Buselik              =      485.90427052993
          Dik Buselik         =      505.34753280092
Do      Cargah                =      512


		 Nim Hicaz     	  =      539.49721354395


          Hicaz			=      546.59923202458
          Dik Hicaz           =      568.47117855798
Re      Neva                  =      575.95461445806
          Nim Hisar           =      606.88654224199
          Hisar         	=      614.87568348396
          Dik Hisar           =      639.47968452515
Mi      Huseyni               =      647.89788655376
Fa      Acem                  =      682.69356339213
          Dik Acem     	      =      691.68063910281
          Evic                =      719.35795928602
          Mahur               =      728.82769034817
          Dik Mahur           =      757.99143471771
Sol     Gerdaniye             =      767.96974237599
          Nim Sehnaz          =      809.21393769123
          Sehnaz              =      819.86654570476
          Dik Sehnaz          =      852.67317294013
La      Muhayyer              =      863.89788454222
          Sunbule             =      910.29394823641
          Dik Sunbule         =      922.2771879657
          Tiz Segah           =      959.18173550676
Si      Tiz Buselik           =      971.80854105985
         Tiz Dik Buselik      =      1010.6950656018
Do      Tiz Cargah            =      1024


*/



