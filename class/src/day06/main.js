//
//Primitive are called scalar type e.g. numbers, boolean, string
let username = "fred"
let age = 50
//Array are called reference type --> 
let numList = [1,2,3,4,5]

//objects are called reference type
let fred = {
  name:'fred',
  age: 50
}

//Java - method
//if define this way, function got a name.
function greetings(name){
  console.info('Hello' + name);
}
//Function type
// Anonymous functions, lambda --> if define this way, function does not have a name. what is impt is the parameter and the body.
let greetings = function(name){
  console.info('Hello'+name)
}
//functions can be assign or reassign. Just nice functions is in the variable.
let hello = greetings
hello('barney')


//activate a function, user round brackets ()
console.info(">>>greetings: ", greetings)
greetings(username);

console.info('name: username, age: age')
//activate an array, use square brackets []
console.info('numList"', numList, numList[3])
console.info('fred', fred)
greetings (username)