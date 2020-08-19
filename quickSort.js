//QUICK SORT


const quickSort = function(array){
  if(array.length <=1){
    return array;
  }
  let pivot = array[array.length-1];
  let left =[];
  let right =[];

  for(let i=0;i<array.length-1;i++){
    if(array[i]<pivot){
      left.push(array[i])
    }else{
      right.push(array[i])
    }
  }
  return [...quickSort(left), pivot,...quickSort(right)]
}

//ex: quickSort([12,9,7,15,10]) =>[ 7, 9, 10, 12, 15 ]