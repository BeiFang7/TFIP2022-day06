const hello = function(name){
  console.info('Hello ${name}')
}

const username = 'fred'
const hi = hello
const names = ['fred', 'betty', 'barney','wilma']

const sayHello = function(fn, args){
  //if fn is a functioon, then i can call the function
  fn(args)
}

console.info('>>> hello', hello)
hello(username)
//call function directly
hi('barney')
//use another function sayHello to call the hello function
sayHello(hello,'wilma')

console.info('Say hello to these guys ', names)
for (let n of names)
  sayHello(hello,n)