/* load all files in startup folder */
(Platform.userAppSupportDir ++ "/startupOC/*").pathMatch do: _.load;

SynthDescLib.read;
