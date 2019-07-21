/////////////OKKK

~ifPathStbl="~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtStbl.txt";
~ifPathKick="~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtKick.txt";
~ifPathSnr="~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtSnr.txt";
~ifPathHat="~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtHat.txt";
~ifPathBass="~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtBass.txt";
~ifPathKeys="~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtKeys.txt";
~ifPathSamp="~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtSamp.txt";
~ifPathMopho="~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtMopho.txt";

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

/////////////OKKK
"adfgj"++2.postln

~fileKick=File.new(~ifPathKick.standardizePath,"w");
~fileKick.open(~ifPathKick.standardizePath,"w");

var cnt=1, min=0,max=1;
(1..64).do{|n|
	case
	{cnt>0&&cnt<=16}{min=(0);max=(1);}
	{cnt>16&&cnt<=32}{min=(-7);max=(7);}
	{cnt>32&&cnt<=48}{min=(1);max=(3);}
	{cnt>48}{min=(1);max=(5);};
	~fileKick.write(
		(min..max).choose.asString ++ if (n % 16 != 0, ",", Char.nl)
	);
	cnt=cnt+1;
	//0.01.wait;
}
~fileKick.close;

~readKick = CSVFileReader.readInterpret(~ifPathKick.standardizePath, true, true).postln;


~ifTxtKick=~readKick[0];
~ifTxtNtKick=~readKick[1];
~ifTxtVelKick=~readKick[2];
~ifTxtSusKick=~readKick[3];
IFSeqKick.stGrpSet    (
	~ifTxtKick[0],~ifTxtKick[1],~ifTxtKick[2],~ifTxtKick[3],
	~ifTxtKick[4],~ifTxtKick[5],~ifTxtKick[6],~ifTxtKick[7],
	~ifTxtKick[8],~ifTxtKick[9],~ifTxtKick[10],~ifTxtKick[11],
	~ifTxtKick[12],~ifTxtKick[13],~ifTxtKick[14],~ifTxtKick[15]
);
IFSeqNtKick.stGrpSet    (
	~ifTxtNtKick[0],~ifTxtNtKick[1],~ifTxtNtKick[2],~ifTxtNtKick[3],
	~ifTxtNtKick[4],~ifTxtNtKick[5],~ifTxtNtKick[6],~ifTxtNtKick[7],
	~ifTxtNtKick[8],~ifTxtNtKick[9],~ifTxtNtKick[10],~ifTxtNtKick[11],
	~ifTxtNtKick[12],~ifTxtNtKick[13],~ifTxtNtKick[14],~ifTxtNtKick[15]
);
IFSeqVelKick.stGrpSet    (
	~ifTxtVelKick[0],~ifTxtVelKick[1],~ifTxtVelKick[2],~ifTxtVelKick[3],
	~ifTxtVelKick[4],~ifTxtVelKick[5],~ifTxtVelKick[6],~ifTxtVelKick[7],
	~ifTxtVelKick[8],~ifTxtVelKick[9],~ifTxtVelKick[10],~ifTxtVelKick[11],
	~ifTxtVelKick[12],~ifTxtVelKick[13],~ifTxtVelKick[14],~ifTxtVelKick[15]
);
IFSeqSusKick.stGrpSet    (
	~ifTxtSusKick[0],~ifTxtSusKick[1],~ifTxtSusKick[2],~ifTxtSusKick[3],
	~ifTxtSusKick[4],~ifTxtSusKick[5],~ifTxtSusKick[6],~ifTxtSusKick[7],
	~ifTxtSusKick[8],~ifTxtSusKick[9],~ifTxtSusKick[10],~ifTxtSusKick[11],
	~ifTxtSusKick[12],~ifTxtSusKick[13],~ifTxtSusKick[14],~ifTxtSusKick[15]
);


fork {
	var cnt=1, min=0,max=1;
	65.do{|n|
		case
		{cnt>0&&cnt<=16}{min=(0);max=(1);}
		{cnt>16&&cnt<=32}{min=(-70);max=(70);}
		{cnt>32&&cnt<=48}{min=(100);max=(300);}
		{cnt>48}{min=(1000);max=(5000);};

		~fileKick.write(
			(min..max).choose.asString ++ if (n % 16 != 0, ",", Char.nl)
		);
		0.01.wait;
	}
}
~fileKick.close;


fork {
	(0..63).do{|cnt=0,n|
		cnt=cnt+1;
		~fileKick.write(
			[0,1].choose.asString ++ if (cnt % 16 != 0, ",", Char.nl)
		);
		cnt.postln;
		0.01.wait;
	}
}
~fileKick.close;



(
r = Routine {

	Routine { 16.do { |i| [0,1].choose.yield } }.idle(16);
	Char.nl.yield;
	Routine { 16.do { |i| [5,6].choose.yield } }.idle(16);
};

fork {
	    (1..64).do{|cnt=0,n|
		  ~fileKick.write(r.value.asString++",");
		0.1.wait;
	   }
}
~fileKick.close;
)


(1..64).do { |n|
	~fileKick.write(
		n.switch
		{n<16}{[0,1].choose.asString++","}
		{n=16}{Char.nl}
		{n>16&n<32}{[0,1].choose.asString++","}
		{n=32}{Char.nl}
		{n>32&n<48}{[2,3].choose.asString++","}
		{n=48}{Char.nl}
		{n>48&n<64}{[4,5].choose.asString++","}
		{n=64}{Char.nl};
	);
};
~fileKick.close;

~readStbl = CSVFileReader.readInterpret(~ifPathStbl.standardizePath, true, true).postln;

~ifTxtVKick=~readStbl[0];
~ifTxtVSnr=~readStbl[1];
~ifTxtVHat=~readStbl[2];
~ifTxtVClap=~readStbl[3];

~ifTxtVKick[8];


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




/////     CLASS TUTORIALLLLLLLLLL //////////



// =====================================================================

// - SuperCollider Basics -

// =====================================================================



// Tutorial 18 - Creating Classes



// =====================================================================

// - ixi audio tutorial - www.ixi-audio.net

// =====================================================================





/*

		---------------------------------------------------------------

 		Copyright (c) 2005-2010, ixi audio.

 		This work is licensed under a Creative Commons

		Attribution-NonCommercial-ShareAlike 2.0 England & Wales License.

 		http://creativecommons.org/licenses/by-nc-sa/2.0/uk/

		---------------------------------------------------------------

*/







// ========== Contents of this tutorial ==========



// 	0) Creating classes



















// 0) ========= Creating Classes ==========





// A good introduction to writing classes are in the Help

"Writing-Classes".openHelpFile



// If you don't know what a class is, then a good start is the wikipedia:

"open 'http://en.wikipedia.org/wiki/Class_(computer_science)'".unixCmd; // run this line in SuperCollider







// ====== here is the TestClass (save as TestClass.sc in the SCClassLib folder of SC ) ======







TestClass {



	classvar <>myvar; // classvariables

	var <>addnr, >addnrSet, <addnrGet; // instance variables

	// this is a normal constructor method

	*new { arg argaddnr;

		^super.new.initTest(argaddnr)

	}



	initTest { arg argaddnr;

		addnr = argaddnr ? 3;

	    // do initiation here

	}



	calc {arg a, b;

		var c;

		c = a+b;

		^c // return

	}



}



TestClass2 : TestClass {

	calc { arg a, b;

		var c;

		c = a * b + addnr;

		^c;

	}



	setAddNr_ { arg newnr;

		addnr = newnr;

	}



	getAddNr {

		^addnr;

	}

}



// ===========================================================================





// and here we test the class



t = TestClass.new



t.calc(3,4)





t = TestClass.new(9)



t.addnr





v = TestClass2.new



v.calc(3,4)



v.addnr_(55)

v.addnr // our new class

t.addnr // the other of course still is just 9



v.addnrSet = 33 // we can set this number (because of > (a setter) )

v.addnrSet_(33) // another way of setting a variable (same as = )





v.addnrGet = 33 // Wrong! we cannot set this number ( because it is a getter < )





// proper object orientated programming uses setter and getter methods

// (rather than accessing variables directly)





// here we use the setAddNr_ method to set our variable.

v.setAddNr_(333)

// and we can look at it:

v.addnr

// but should really look at it with the getter method we made:

v.getAddNr







// =============================== another test class ========================





SonicArtsClass {



	var win, textfield, textfield2, rect; // get text but set text2

	var name, <>profession; // a getter and setter variable

	var friends;



	*new { arg name, rect, color;

		^super.new.initSAClass(name, rect, color);

		}



	initSAClass { arg argname, argrect, color;

		var scramblebutton;



		rect = argrect;

		name = argname;

		win = SCWindow(name, rect, resizable:false).front;

		win.view.background_(color);

		textfield = SCStaticText(win, Rect(10, (rect.height/2)-30, rect.width, 30));

		textfield.string_("");

		textfield.font_(Font("Helvetica-Bold", 24));

		textfield2 = SCStaticText(win, Rect(10, (rect.height/2)+30, rect.width, 30));

		textfield2.string_("");

		textfield2.font_(Font("Helvetica-Bold", 14));

		scramblebutton = SCButton(win, Rect(10,10, 200, 30))

						.states_([

							["change friends color",Color.black,Color.clear]]

						)

						.action_({

							friends.do({arg friend; friend.changeColor(Color.rand)});

						});



		friends = List.new;

	}



	speak_{arg string;

		textfield.string_(string);

	}



	speak2_{arg string;

		textfield2.string_(string);

	}



	updateGUI {

		win.refresh;

	}



	addFriend {arg friend;

		friends.add(friend);

	}



	getName {

		^name; // note the return symbol

	}



	setName_ {arg newname; // note the underscore used when you are setting

		name = newname;

	}



	removeFriend {arg friend;

		var friendindex;

		friendindex = friends.indexOfEqual(friend);

		friends.remove(friendindex);

	}



	showFriends {

		var namesOfFriends;

		namesOfFriends = List.new;

		friends.do({arg friend; namesOfFriends.add(friend.getName)});

		textfield2.string_(namesOfFriends.asString);

	}



	getFriends {

		^friends

	}



	getFriendNames {

		var namesOfFriends;

		namesOfFriends = List.new;

		friends.do({arg friend; namesOfFriends.add(friend.getName)});

		^namesOfFriends;

	}



	changeColor {arg color;

		win.view.background_(color);

		win.update;

	}

}







// ================== and here is some code to try the class





a = SonicArtsClass("john", Rect(50, 800, 300, 200), Color.red)

a.speak_("Hi! I'm John")

a.profession = "singer"

a.speak2_("I am a" + a.profession)



b = SonicArtsClass("george", Rect(350, 800, 300, 200), Color.blue)

b.speak_("Hi! I'm george")

b.profession = "bass player"

b.speak2_("I am a" + b.profession)



c = SonicArtsClass("paul", Rect(650, 800, 300, 200), Color.green)

c.speak_("Hi! I'm paul")

c.profession = "guitarist"

c.speak2_("I am a" + c.profession)



// let's fix the roles



b.profession = "guitarist"

b.speak2_("I am a" + b.profession)

c.profession = "bass player"

c.speak2_("I am a" + c.profession)



a.addFriend(b)

a.addFriend(c)

a.showFriends



b.showFriends

c.showFriends



b.addFriend(a)

b.addFriend(c)

b.showFriends // check his friends



// what if john wants to change his name?



a.setName_("ringo");

a.speak_("Hi! I'm"+a.getName)

// we can get the name like this

a.getName

// but not like this:

a.name

// however, we can get the profession like this

a.profession

// WHY?

// the reason is the < (get) and > (set) properties of the profession variable

