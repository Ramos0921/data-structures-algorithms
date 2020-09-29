let isPalindrome = function(num) {
  let str = num.toString();
  if(str === null){
    return false;
  }
  let strSplit = str.split('');
  var temp = [];
  for(var j=strSplit.length-1;j>=0;j--){
    temp.push(strSplit[j]);
  }
  for(let i =0;i<=strSplit.length;i++){
    if(strSplit[i]!= temp[i]){
      return false;
    }
  }
  return true;
};