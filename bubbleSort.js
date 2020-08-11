//BUBBLE SORT IS AN USEFUL ALGORITHM FOR SORTING AN ARRAY IN INCREMENTINO OR DECREMENTING ORDER

var bubbleSort = function(arr){
  //outter for loop ensures array is iterated through each element
  for(var j =0;j<arr.length;j++){
    //inner for loop sorts array
    for(var i =0;i<arr.length;i++){
      //swapping conditional statement
      if(arr[i]>arr[i+1]){
        var temp = arr[i+1];
        arr[i+1]=arr[i];
        arr[i]=temp
      }
    }
  }
  return arr;
}

//using a do while loop

// var bubbleSort = function(arr){
//   var len = arr.length;
//   do{
//     var swap = false;
//     for(var i =0;i<arr.length;i++){
//       if(arr[i]>arr[i+1]){
//         var temp = arr[i+1];
//         arr[i+1]=arr[i];
//         arr[i]=temp
//         swap = true;
//       }
//     }
//   }while(swap === true)
//   return arr;
// }

//EX: bubbleSort([10,2,8,6,7,3]) =>[ 2, 3, 6, 7, 8, 10 ]