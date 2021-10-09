const lines = require('fs').readFileSync('/dev/stdin', 'utf8').split("\n");
const [sx, sy, gx, gy] = lines[0].split(" ").map(s => Number(s));

const answer = sx + (gx - sx) * sy / (sy + gy);
console.log(answer);
