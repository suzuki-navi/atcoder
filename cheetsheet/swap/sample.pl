use strict;
use warnings;

my $a = 1, $b = 2;
print "$a $b\n";

($a, $b) = ($b, $a);
print "$a $b\n";

