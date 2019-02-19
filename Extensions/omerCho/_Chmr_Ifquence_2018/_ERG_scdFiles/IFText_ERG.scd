(
var path=
)
File.getcwd;
~chmrLivePath=PathName("~/Library/Application Support/SuperCollider/Extensions/omerCho/_Chmr_Ifquence_2018/_IFTextFiles/ifGlobalTest.txt")
~chmrLivePath=PathName("~/ifGlobalTest.txt");
~makeIFTxt=File.new(~chmrLivePath.pathOnly.standardizePath,"w+");
~makeIFTxt.write("Does this work?\n is this thing on ?\n");
~makeIFTxt.close;
~/ifGlobalTest.txt

~ifGlobalsTxt.write("Does this work?\n is this thing on ?\n");

~ifGlobalsTxt=File(~chmrLivePath.pathOnly.standardizePath,"r");
~ifGlobalsTxt.readAllString.postln;
~ifGlobalsTxt.close;

File.use("~/ifGlobalTest2.txt".standardizePath, "w", { |txt1| txt1.write("CHOMER TEXT\n 2019 \n"); });
File.use("~/ifGlobalTest2.txt".standardizePath, "r", { |txt1| txt1.readAllString.postln });


File.use("~/ifGlobalTest2.txt".standardizePath, "w", { |txt1| txt1.write("CHOMER TEXT\n 2019 \n"); });
File.use("~/ifGlobalTest2.txt".standardizePath, "r", { |txt1| txt1.readAllString.postln });
File.use("~/ifGlobalTest2.txt".standardizePath, "w+", { |txt1| txt1.write(FloatArray[1.1, 2.2, 3.3, pi, 3.sqrt]); });

txt1.write( FloatArray[1.1, 2.2, 3.3, pi, 3.sqrt] );

// write some string to a file:
(
var f, g;
f = File("~/test.txt".standardizePath,"w");
f.write("Does this work?\n is this thing on ?\n");
f.close;
)

// read it again:
(
g = File("~/test.txt".standardizePath,"r");
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
// write a test file:
f = File("~/Documents/IFTxst01.txt", "r");
f.write(
"Some,comma,delimited,items, in line 1

and then, some more, with several commas,,,, in line 3
"
);
f.close;
)


    // open file, read and put strings into array, close file.
x = CSVFileReader.read("CSVReadTest.sc").postcs;

    // can skip empty lines:
x = CSVFileReader.read("CSVReadTest.sc", true).postcs;

    // can skip blank entries caused by multiple commas:
x = CSVFileReader.read("CSVReadTest.sc", true, true).postcs;

    // do file open/close by hand if you prefer:
f = File("CSVReadTest.sc", "r"); f.isOpen;
t = CSVFileReader(f);
t.read(true, true).postcs;
f.close;

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


x = CSVFileReader.readInterpret("CSVReadTestNum.sc", true, true).postln;