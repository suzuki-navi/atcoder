const lines = require('fs').readFileSync('/dev/stdin', 'utf8').split("\n");
const a = Number(lines[0]);
const [b, c] = lines[1].split(" ").map(s => Number(s));
console.log(a + b + c);
