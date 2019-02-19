IFTxst{
	classvar path01, path02,path03, make, wrt;
	*paths{
		path01="~/IFTxst01.txt";
		path02="~/IFTxst01.csv";
		path03="~/IFTxst01.dat";

	}
	*makeFile{
		this.paths;
		make=File.new(path02.standardizePath,"w");
		path01.postln;
	}
	*writeFile{|vl01,vl02,vl03,vl04,vl05,vl06,vl07,vl08,vl09,vl10,vl11,vl12,vl13,vl14,vl15,vl16|
		File.use(
			path01.standardizePath, "w",
			{ |txt1|
				txt1.write(vl01,vl02,vl03,vl04,vl05,vl06,vl07,vl08,vl09,vl10,vl11,vl12,vl13,vl14,vl15,vl16);
			}
		);
	}
	*writeArr{|minVal,maxVal|
		File.use(
			path01.standardizePath,"w",
			{ |txt2|
				(minVal..maxVal).do { |n| txt2.write(n.asString ++ ","); };
		});

	}
	*writeArrDo{|tms,val|
		File.use(
			path01.standardizePath,"w",
			{ |txt2|
				tms.do {
					txt2.write(val.asString ++ ",");
					val=val+1;
				};
		});
	}
	*writeSer{|vl01,vl02,vl03,vl04,vl05,vl06,vl07,vl08,vl09,vl10,vl11,vl12,vl13,vl14,vl15,vl16|
		File.use(
			path01.standardizePath,
			"w",
			{ |txt3|
				txt3.write(
					vl01,vl02,vl03,vl04,vl05,vl06,vl07,vl08,vl09,vl10,vl11,vl12,vl13,vl14,vl15,vl16
				);
			}
		);
	}
	*writeDo{|min,max|
		File.use(
			path01.standardizePath,"w+",
			{ |txt4|
				16.do{txt4.write([min,max].choose.asString ++ " ")};
			}
		);
	}
	*write{|min,max|
		File.use(
			path01.standardizePath,"w+",
			{ |txt4|
				15.do{txt4.write([min,max].choose.asString ++ ", ")};
				//2.0.wait;
				1.do{txt4.write([min,max].choose.asString)};
			}
		);
	}
	*wrt{|min,max|
		File.use(
			path02.standardizePath,"wb+",
			{ |txt4|
				16.do{txt4.write([min,max].choose.asString)};
			}
		);
	}
	*wrtC{|min,max|
		File.use(
			path02.standardizePath,"wb",
			{ |txt4|
				16.do{txt4.write([min,max].choose.asString++ ",")};
			}
		);
	}
	//READ
	*readFile{
		File.use(
			path01,
			"r",
			{ |read|
				read.read(path01);
				//read.getString.postln;
			}
		);
	}
}

/*
IFTxst.makeFile;
IFTxst.wrt(0,1);
IFTxst.wrtC(0,1);
IFTxst.write(0,1);
IFTxst.writeDo(0,1);
IFTxst.writeArrDo(16,2);
IFTxst.readFile;

IFTxst.makeFile;
IFTxst.wrtC(0,1);
~flCsv=CSVFileReader.read("~/IFTxst01.csv".standardizePath,false,false);
~flCsv.postcs;
~dfg=~flCsv.collect(_.collect(_.interpret));
~nm= ~dfg[0];


~fl=File.readAllString("~/IFTxst01.csv".standardizePath,"rb");
~fl=File.read("~/IFTxst01.csv".standardizePath);
~flCsv=CSVFileReader.read("~/IFTxst01.csv".standardizePath,false,false);
~flCsv;
~flCsv.postcs;
~dfg=~flCsv.collect(_.collect(_.interpret));
~nm= ~dfg[0]
~nm[2]
~nm[2]+~nm[3]
~nm.collect(_.collect(_.interpret));
~nm1=~flCsv.at(0);
~nm2=5;
~sum = "~nm1+~nm2".compile.postln;
~sum.value
~fl=File.readAllSignal("~/IFTxst01.txt".standardizePath);
~num = "~fl[0]".interpret;
~num=~fl.asArray[2]
~fl[1].asInteger
~fl.at(2);
~fl.split($ );
~fl.asArray.split($ ).interpret
~num01=(~fl[3]);
"~num+0".asInteger;
~fl[2].asString;
~seq=Pseq(~fl.split($ ),inf).asStream;
~seq.next
~fl.value
~fl.collect(_.collect(_.interpret))
~fl.ascii

~nm= ~fl[2];
~nm.value.postln

IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
~seqVKick01.source = ~nm[0]

IFSeqVKick.st01(~num.value);
IFSeqVKick.st01("~fl[2]+0".asInteger;);
IFSeqVKick.st01(~fl[0].asString);

"~fl.at(2)".asInteger;
~num = "~fl.at(2)+1".compile;
~num.value
IFSeqVKick.st01(~fl[0]);
IFSeqVKick.st02(~fl[1]);
IFSeqVKick.st03(~fl[2]);
IFSeqVKick.st04(~fl[3]);
IFSeqVKick.st05(~fl[4]);
IFSeqVKick.st06(~fl[5]);
IFSeqVKick.st07(~fl[6]);
IFSeqVKick.st08(~fl[7]);

IFSeqVKick.stGrpSet(
~fl[0].asInteger,
~fl[1].asStream,
~fl[2].asStream,
~fl[3].asStream,
~fl[4].asStream,
~fl[5].asStream,
~fl[6].asStream,
~fl[7].asStream,
~fl[8].asStream,
~fl[9].asStream,
~fl[10].asStream,
~fl[11].asStream,
~fl[12].asStream,
~fl[13].asStream,
~fl[14].asStream,
~fl[15].asStream
);
IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);

IFSeqVKick.st01(~fl[0].asString);
IFSeqVKick.st02(~fl[1]);
IFSeqVKick.st03(~fl[2]);
IFSeqVKick.st04(~fl[3]);
IFSeqVKick.st05(~fl[4]);
IFSeqVKick.st06(~fl[5]);
IFSeqVKick.st07(~fl[6]);
IFSeqVKick.st08(~fl[7]);

postf("this % a %. pi = %, list = %\n", "is", "test", pi.round(1e-4), (1..4))

this is a test. pi = 3.1416, list = [ 1, 2, 3, 4 ]


List[~fl].do({ arg item, i; item.postln });
List[2, 1, 4, 3].asSortedList;

String.readNew(~fl)

f.collect(_.collect(_.interpret))
Post<<"~/IFTxst01.txt".pathMatch

IFTxst.loadPath;
IFTxst.writeArr(1,16);

IFTxst.readFile;

IFTxst.writeSer(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
IFTxst.writeFile(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);

IFTxst.writeSer();


File.getcwd;

~seq=Pseq([~vl01,2,\vl03],inf).asStream;
format("here I will send message % with args %", message, args).postln;

~readFile= FileReader.readInterpret("~/IFTxst01.txt").postcs;
File.readAllString("~/IFTxst01.txt".standardizedPath);

f.postcs
File.getcwd;


~br="1";
~zr="3+~br".compile.asInteger
~zr.value

*/