Puppet {

	var <>myfreq; // an instant variable with a getter and setter

	*new { |myfreq=50| ^super.new.myfreq_(myfreq)}

	blip {{ Blip.ar(myfreq, 11) * EnvGen.kr(Env.perc, doneAction: 2)}.play;}

}

/*
~pup1 = Puppet.new(50);

~pup.dump;
~pup.myfreq;
~pup.myfreq_(100);
~pup.blip;
~pup.myfreq_(100).blip;
*/