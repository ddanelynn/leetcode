function foo () {
    console.log(1)

    setTimeout(() => {
        console.log(2)
    }, 0)

    console.log(5)

    new Promise(() => console.log(3)).then(console.log(6))

    console.log(4)

}

foo()

var x = "hello";
x[1] = 'a';
console.log(x[1]);