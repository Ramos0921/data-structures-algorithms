// SEARCHING SORTED ARRAY
//binary search

var search= function (arr,target){
  //set max to the length of array
  var max = arr.length-1;
  //set low to zero
  var low = 0;
  //while loop to search for target
  while(low<=max){
    //set mid point to the middle index of array
    mid = Math.floor((max+low)/2)
    //conditional to return if target is found
    if(arr[mid]===target){
      //return mid plus one to resemble array starting at 1
      return mid+1;
    }
    //conditional to reset low if target is larger than
    //value at mid point in array
    if(arr[mid]<target){
      low = mid+1;
    }
    //conditional to reset max if target is less than
    //value at mid point in array
    if(arr[mid]>target){
      max = mid-1;
    }
  }
  //returns null if target is not found
  return null;
}

//search([3,7,20,32,45,55,60,75,99],32)=>4