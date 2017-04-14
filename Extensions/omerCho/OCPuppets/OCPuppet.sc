Puppet {

	var <>myfreq; // an instant variable with a getter and setter

	*new { |myfreq=50| ^super.new.myfreq_(myfreq)}

	blip {{ Blip.ar(myfreq, 11) * EnvGen.kr(Env.perc, doneAction: 2)}.play;}

}

/*
~pup = Puppet.new(50);
~pup2= Puppet.new(250);
~pup.dump;
~pup.myfreq;
~pup.myfreq_(100);
~pup.blip;
~pup2.blip;
~pup.myfreq_(400).blip;
*/