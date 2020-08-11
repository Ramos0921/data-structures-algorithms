//recursion is used to find the greatest common divisor of two positive integers.

var gcd = function (a,b){
  if(a===0){
    return b;
  }
  if(b===0){
    return a;
  }
  return gcd(b,a%b)
}