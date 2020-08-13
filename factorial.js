//iterative way to a factorial
var factorial = function(n){
  var result = 1;
  for(var i =1;i<=n;i++){
    result*=i;
  }
  return result;
}


//recursive way to factorial

var factorial = function(n){
  if(n ===0){
    return 1
  }
  return n*factorial(n-1)
}

//factorial(5)=>120

// factorial recursion explained
//| stack |
//| facotrial(0)= 1  |
//| facotrial(1)=1*factorial(0)  |
//| facotrial(2)=2*factorial(1)  |
//| facotrial(3)=3*factorial(2)  |
//| facotrial(4)=4*factorial(3)  |
//| facotrial(5)=5*factorial(4)  |
// then
//| stack |
//| facotrial(0)= 1  |
//| facotrial(1)=>(1*1)=1 |
//| facotrial(2)=>(2*1)=2 |
//| facotrial(3)=>(3*2)=6  |
//| facotrial(4)=>(4*6)=24  |
//| facotrial(5)=>(5*24)=120  |