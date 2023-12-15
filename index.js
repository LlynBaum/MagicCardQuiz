// Read input from the console
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('What is your name? ', (name) => {
    // Write output to the console
    console.log(`Hello, ${name}!`);
    rl.close();
});
