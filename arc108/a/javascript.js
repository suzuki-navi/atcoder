const lines = require('fs').readFileSync('/dev/stdin', 'utf8').split("\n");
const [s, p] = lines[0].split(" ").map(s => Number(s));

const max = Math.sqrt(p);
for (let i = 1; i <= max; i++) {
    if (i * (s - i) == p) {
        console.log("Yes");
        process.exit(0);
    }
}
console.log("No");
