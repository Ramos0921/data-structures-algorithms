// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

let twoSums = function(arr,key){
  let result = [];

  for(let i =0; i<arr.length;i++){
    for(let j =i+1;j<arr.length;j++){
      if((arr[i]+arr[j])===key){
        result.push(i,j);
        return result;
      }
    }
  }
  return result;
}
