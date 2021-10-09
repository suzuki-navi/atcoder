function next_permutation(arr) {
    const len = arr.length;
    let left = len - 2;
    while (left >= 0 && arr[left] >= arr[left+1]) left--;
    if (left < 0) return false;
    let right = len - 1;
    while (arr[left] >= arr[right]) right--;
    { const t = arr[left]; arr[left] = arr[right]; arr[right] = t; }
    left++;
    right = len - 1;
    while (left < right) {
        { const t = arr[left]; arr[left] = arr[right]; arr[right] = t; }
        left++;
        right--;
    }
    return true;
}

const lines = require('fs').readFileSync('/dev/stdin', 'utf8').split("\n");
const [n, k] = lines[0].split(" ").map(s => Number(s));
const ts = [];
for (let i = 0; i < n; i++) {
    ts.push(lines[i + 1].split(" ").map(s => Number(s)));
}
const n1 = n - 1;
const arr = [];
for (let i = 1; i < n; i++) arr.push(i);
let answer = 0;
do {
    let cost = 0;
    let prev = 0;
    for (let i = 0; i < n1; i++) {
        const curr = arr[i];
        cost += ts[prev][curr];
        prev = curr;
    }
    cost += ts[prev][0];
    if (cost == k) answer++;
} while (next_permutation(arr));

console.log(answer);
