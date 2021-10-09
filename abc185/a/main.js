const lines = require('fs').readFileSync('/dev/stdin', 'utf8').split("\n");
const [a1, a2, a3, a4] = lines[0].split(" ").map(s => Number(s));
console.log(Math.min(a1, a2, a3, a4));
