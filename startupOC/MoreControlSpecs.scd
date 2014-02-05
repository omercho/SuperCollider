
/*

Create some more default specs to use with \symbol.asSpec

\narrowFreq.asSpec

Post the list of existing default specs: 

ControlSpec.specs;
ControlSpec.specs.asArray.inspect;
ControlSpec.specs.keys.asArray.inspect;
ControlSpec.specs.keys.asArray.sort do: _.postln;


*/

[
\narrowFreq->ControlSpec(300, 10000, 'exp', 0, 440, " Hz"),
\scaleFreq->ControlSpec(300, 10000, 'exp', 100, 440, " Hz")
] do: { | assoc | ControlSpec.specs.put(assoc.key, assoc.value) }
