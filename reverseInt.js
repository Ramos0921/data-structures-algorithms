
//Input: 123
//Output: 321

//Input: -123
//Output: -321

//Input: 120
// Output: 21

var reverse = function(x) {
  var results=[];
  var negative=false;
  var final;
  if(x<0){
    negative=true;
    x= x *-1
  }

  var arr = x.toString().split('')

  for(var i =arr.length-1;i>=0;i--){
    results.push(arr[i])
  }
  if(negative){
    if(results.length>10)
    {
      return 0;
    }
    var neg = Number(results.join(''))*-1

    return neg;
  }
  if(results.length>=10){
    return 0;
  }
  final = Number(results.join(''))

  return final
};