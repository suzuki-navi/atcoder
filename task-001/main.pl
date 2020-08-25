use strict;
use warnings;

my $a = <STDIN>;
$a =~ s/\n\z//;
my $bc = <STDIN>;
$bc =~ s/\n\z//;
my $s1 = <STDIN>;
$s1 =~ s/\n\z//;
my $s2 = <STDIN>;
$s2 =~ s/\n\z//;

my ($b, $c) = split(/ /, $bc);
my ($t1, $t2) = split(/ /, $s1);

printf("%d\n", $a + $b + $c);
print "$t1$t2\n";
print "$s2\n";
