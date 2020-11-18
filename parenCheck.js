var isValid = function(s) {

  var spl= s.split('');
  var arr = [];
  for(let i =0;i<spl.length;i++){
    if(spl[i]==="("||spl[i]==="["||spl[i]==="{")
    {
      arr.push(spl[i]);
    }

    if(spl[i]==="}"||spl[i]==="]"||spl[i]===")")
    {
      var temp = arr.pop();
      if(spl[i] === ']' && temp != "["){
        return false;
      }
      if(spl[i]==='}' && temp !="{"){
        return false
      }
      if(spl[i]===')' && temp !="("){
        return false;
      }
    }
  }
  if(arr.length>0){
    return false;
  }
  return true;
};

// s ="([)]"
// isValid(s) === false
//s="{}{}"=== true
