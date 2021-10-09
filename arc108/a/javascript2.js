const lines = require('fs').readFileSync('/dev/stdin', 'utf8').split("\n");
const [s, p] = lines[0].split(" ").map(s => Number(s));

const sq = s * s - 4 * p;
const sqrt = Math.floor(Math.sqrt(sq));

console.log(sq);
console.log(sqrt);

if (sqrt * sqrt != sq) {
    console.log("No");
} else {
    if ((s - sqrt) % 2 == 0) {
        console.log("Yes");
    } else {
        console.log("No");
    }
}
