//COUNT SORT

const countSort = function(arr,range){
  let rangeNum = range;

  let obj={};
  let count = 1;
  for(let i =0;i<rangeNum;i++){
    if(obj[arr[i]]===undefined){
      obj[arr[i]]=count;
    }else{
      obj[arr[i]]++
    }
  }
  let final = [];
  for(var key in obj){
    let num = Number(key);
    for(let j =1;j<=obj[key];j++){
      final.push(num)
    }
  }
  return final;
}

//ex: countSort([3,10,2,4,2,6,9,5,7,2],10)=>[2, 2, 2, 3,  4, 5, 6, 7, 9, 10]