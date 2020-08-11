//INSERTION SORT

var insertionSort = function(arr){
  //for loop to iterate through all elements
  for(var i =0;i<arr.length;i++){
    //set current to the current i in iteration
    var current = arr[i];
    //set j to i-1 to check the previous element
    var j= i-1;
    //while loop to swap elements to lowest point in array
    while(j>=0 && arr[j]>current){
      //moves larger value to the right
      arr[j+1]= arr[j];
      //decrement j until 0 to break out of loop
      j=j-1;
    }
    //will set current value to the lowest point in array
    //complete iteration
    arr[j+1]= current
  }
  return arr;
}

//EX: selectionSort([10,2,8,6,7,3])=>[ 2, 3, 6, 7, 8, 10 ]