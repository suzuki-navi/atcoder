const lines = require('fs').readFileSync('/dev/stdin', 'utf8').split("\n");
const a = Number(lines[0])
console.log(Math.max(a, 0));
