//SELLECTION SORT

var selectionSort = function(arr){
  //first for loop to iterate through all elements in array
  for(var j =0;j<arr.length;j++){
    //set min to index j
    var min = j;
    //second for loop to SORT
    //start at j+1 one element head
    for(var i =j+1;i<arr.length;i++){
      //swap conditional statement
      if(arr[i]< arr[min]){
        //new min is set
        min =j;
        var temp = arr[min];
        arr[min]= arr[i];
        arr[i]= temp
      }
    }
  }
  return arr;
}

//EX: selectionSort([10,2,8,6,7,3])=>[ 2, 3, 6, 7, 8, 10 ]