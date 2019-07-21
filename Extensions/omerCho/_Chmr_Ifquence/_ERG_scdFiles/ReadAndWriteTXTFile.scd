~ifPath_VKick="~/CHMR_SCTxt/IFTxt/IFTxtStKick.csv";
/Library/Application Support/SuperCollider/Extensions/omerCho/_Chmr_Ifquence_2018/_IFTextFiles

/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks


~ifPathStbl="~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtStbl.txt";

~fileStbl=File.new(~ifPathStbl.standardizePath,"w");

(1..100).do { |n|
	    ~fileStbl.write(n.asString ++ if (n % 16 != 0, ",", Char.nl));
};
~fileStbl.close;

~readStbl = CSVFileReader.readInterpret(~ifPathStbl.standardizePath, true, true).postln;

~ifTxtVKick=~readStbl[0];
~ifTxtVSnr=~readStbl[1];
~ifTxtVHat=~readStbl[2];
~ifTxtVClap=~readStbl[3];

~ifTxtVKick[8];

~fileStbl.open(~ifPathStbl.standardizePath,"w");

(1..64).do { |n|
	~fileStbl.write(
		[0,1].choose.asString ++ if (n % 16 != 0, ",", Char.nl)
	);
};
~fileStbl.close;

~readVKick = CSVFileReader.readInterpret(~fileStbl.standardizePath, true, true).postln;




File.use(
	~ifPath_VKick.standardizePath,"wb",
	{ |txt4|
		16.do{
			txt4.write([min,max].choose.asString++ ",")
		};
	}
);

//OKKKKK WRT
IFTxst.makeFile;
IFTxst.wrtC(0,1);
//OKKKKK READ
~flCsv=CSVFileReader.readInterpret("~/CHMR_SCTxt/IFTxt/IFTxtStKick.csv".standardizePath,false,false);
~nm=~flCsv[0]
~nm[15]


~flCsv=CSVFileReader.read("~/CHMR_SCTxt/IFTxt/IFTxtStKick.csv".standardizePath,false,false);
~flCsv.postcs;
~dfg=~flCsv.collect(_.collect(_.interpret));
~nm= ~dfg[0];
(~dfg[3])+(~dfg[4])



~strm1="123456789";
~strm1="1 2 3 4 5 6 7 8 9";
~strm1="1,2,3,4,5,6,7,8,9,";
~strm1.asList();
~strm1.split($ );
~strm1.asArray;
~strm1.asStream;
~strm2.removeAll()


~strm1="123456789";
~seq=Pseq(~strm1.asArray,inf).asStream;
~seq.next




~myStream.format

"1".asInteger.collect(~myStream).postln;


Platform.resourceDir

~myStream.format(_.asInteger(_.collect()))

this is a test. pi = 3.1416, list = [ 1, 2, 3, 4 ]





(line.contains(".").not).if({

	// the ratio case
	num = line.interpret.ratiomidi;
	tuning = tuning ++ num;
},
{// the cents case
	//"as float: ".post; i.asFloat.postln;
	num = line.asFloat;
	num = num / 100;
	tuning = tuning ++ num;
});



~strm1="1 2 3 4 5 6 7 8 9 ";
~strm=~strm1.split($ );
~strm1;
~strm1.asArray;
~seq=Pseq(~strm1.split($ ),inf).asStream;
~seq.next




///FROM HELP
(
// write a test file:
f = File("CSVReadTest.sc", "w");
f.write(
	"Some,comma,delimited,items, in line 1

and then, some more, with several commas,,,, in line 3
"
);
f.close;
)
(
// write a test file with numbers:
f = File("CSVReadTestNum.sc", "w");

(1..10).do { |n| f.write(n.asString ++ ","); };
f.close;
)

x = CSVFileReader.read("CSVReadTestNum.sc", true, true).postcs;
x.collect(_.collect(_.interpret));    // convert to numbers.

// or do it immediately:
x = CSVFileReader.readInterpret("CSVReadTestNum.sc").postcs;

(
// write a test file with several lines of numbers:
f = File("CSVReadTestNum.sc", "w");

(1..100).do { |n|
	f.write(n.asString ++ if (n % 10 != 0, ",", Char.nl)); };
f.close;
)





// write some string to a file:
(
var f, g;
f = File.new("~/test.txt".standardizePath,"w");
f.write("Does this work?\n is this thing on ?\n");
f.close;
)

// read it again:
(
g = File.new("~/test.txt".standardizePath,"r");
g.readAllString.postln;
g.close;
)

// try the above with File.use:

File.use("~/test.txt".standardizePath, "w", { |f| f.write("Doesn't this work?\n is this thing really on ?\n"); });
File.use("~/test.txt".standardizePath, "r", { |f| f.readAllString.postln });


// more file writing/reading examples:
(
var h, k;
h = File("~/test.dat".standardizePath, "wb");
h.inspect;
h.write( FloatArray[1.1, 2.2, 3.3, pi, 3.sqrt] );
h.close;

k = File("~/test.dat".standardizePath, "rb");
(k.length div: 4).do({ k.getFloat.postln; });
k.close;
)


(
var f, g;
f = File("~/test.txt".standardizePath,"w");
100.do({ f.putChar([$a, $b, $c, $d, $e, $\n].choose); });
f.close;

g = File("~/test.txt".standardizePath,"r");
g.readAllString.postln;
g.close;

g = File("~/test.txt".standardizePath,"r");
g.getLine(1024).postln;
"*".postln;
g.getLine(1024).postln;
"**".postln;
g.getLine(1024).postln;
"***".postln;
g.getLine(1024).postln;
"****".postln;
g.close;
)

(
//var f, g;
f = File("~/test.dat".standardizePath,"wb");
f.inspect;
100.do({ f.putFloat(1.0.rand); });

f.inspect;
f.close;

g = File("~/test.dat".standardizePath,"rb");
100.do({
	g.getFloat.postln;
});
g.inspect;
g.close;
)

(
//var f, g;
f = File("~/test.dat".standardizePath,"r");
f.inspect;
f.close;
)




(
var add_amt, max_add, total;
max_add = 0.5;
total = 0;
{total < 1}.while({
	add_amt = max_add.rand;
	// . . .
	total = total + add_amt;
	"in while loop".postln;
	total.postln;
});
)