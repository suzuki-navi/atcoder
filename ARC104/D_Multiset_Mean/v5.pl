# TLE

use strict;
use warnings;
use integer;

my $nkm = <STDIN>;
$nkm =~ s/\n\z//;
my ($n, $k, $m) = split(/ /, $nkm);

my $table = [[1]];
for (my $i = 1; $i < $n; $i++) {
    my $t1 = $table->[$i - 1];
    my $t2 = [];
    my $j_max = $i * ($i + 1) * $k / 2;
    for (my $j = 0; $j <= $j_max; $j++) {
        my $a1 = (($j - ($i - 1) * $i * $k / 2) + $i - 1) / $i;
        $a1 = 0 if $a1 < 0;
        my $a2 = $j / $i;
        $a2 = $k if $a2 > $k;
        my $s = 0;
        for (my $aa = $a1; $aa <= $a2; $aa++) {
            $s += $t1->[$j - $aa * $i];
        }
        $s = $s % $m;
        push(@$t2, $s);
    }
    push(@$table, $t2);
}

my $table2 = [0];
for (my $x = 1; $x <= ($n + 1) / 2; $x++) {
    my $n1 = $x - 1;
    my $n2 = $n - $x;
    my $s = 0;
    for (my $i = 0; $i <= $n1 * ($n1+1) * $k / 2; $i++) {
        $s += $table->[$n1]->[$i] * $table->[$n2]->[$i] % $m;
    }
    my $answer = ($m + $s * ($k+1) - 1) % $m;
    push(@$table2, $answer);
    printf("%d\n", $answer);
}
for (my $x = ($n + 1) / 2 + 1; $x <= $n; $x++) {
    printf("%d\n", $table2->[$n + 1 - $x]);
}


