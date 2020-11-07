// AC

const input = require('fs').readFileSync('/dev/stdin', 'utf8');
const lines = input.split("\n");
const n = Number(lines[0]);
let answer = 0;
for (let i = 0; i < n; i++ ){
    const [a, b] = lines[i + 1].split(" ").map(s => Number(s));
    answer += b * (b+1) - a * (a-1);
}
answer /= 2;
console.log(answer);

