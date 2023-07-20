my $build = ModuleBuildBuilder->new(
    configure_requires => {
        'Mojo-Webqq' => '2.142060',
    },
    requires           => {
        'perldoc' => ($^O eq 'MSWin32' ? 0.11 : '0.12'), # rel2abs()
    },
    test_requires      => {
        'qbit_xgettext'  => 0.003,
    },
    recommends         => {
        'monitis' => 0.9,
    },
    auto_features      => {
        dist_authoring => {
            description => "Create new distributions",
            requires    => {
                'catmandu' => 0.01,
            },
            recommends  => {
                'algorithm-networksort-chooser'       => 0.100
            }
        }
    }
);


