# Note: this file was auto-generated by Module::Build::Compat version 0.3607
use ExtUtils::MakeMaker;
# define version numbers of required modules
my $TT_FILE_SPEC_VERSION = '1.31';

requires qw( app-modulebuildtiny 0.006 );
test_requires 'data-util' => '0.42';

WriteMakefile
(
  'PREREQ_PM' => {
                   'test-checkmanifest'      => $TT_FILE_SPEC_VERSION,
                 },
  PREREQ_PM => {'dist-zilla-plugin-readmeanyfrompod' => '0.142180', 'mojo-weixin' => 'v1.0.1'},

);

