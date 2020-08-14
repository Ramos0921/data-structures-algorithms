//MERGE SORT
//explaination at bottom

var mergeSort=function(arr){
  if(arr.length===1){
    return arr;
  }
  var middle = Math.floor(arr.length/2);
  alert(middle)
  var leftSide = arr.slice(0,middle);
  var rightSide = arr.slice(middle);
   alert(leftSide)
  return merge(mergeSort(leftSide), mergeSort(rightSide))
}

var merge=function(left,right){
  var result=[];
  var leftIndex =0;
  var rightIndex =0;
  while(leftIndex<left.length && rightIndex< right.length){
    if(left[leftIndex]<right[rightIndex]){
      result.push(left[leftIndex])
      leftIndex++;
    }else{
      result.push(right[rightIndex]);
      rightIndex++
    }
  }
  var final = result
            .concat(left.slice(leftIndex))
            .concat(right.slice(rightIndex))
  return final
}

//mergeSort([5,15,32,4,66,9,105])=>[4,5, 9, 15,32, 66, 105]

//HOW IT WORKS
//[5,15,32,4,66,9,105] len= 7
//middle = 3
//merge(mergeSort([5,15,32]), mergeSort([4,66,9,105]))
// recurse^^^^^^^^^^^^^^^
//[5,15,32] len=3
//mergeSort([5,15,32])
//middle=1
//merge(mergeSort([5]), mergeSort([15,32]))
// recurse^^^^^^^^^^
//[5] len =1
//***returns [5] */
//merge(mergeSort([5]), mergeSort([15,32]))
//          done          recurse^^^^^^^^^^
//[15,35] len = 2
//midle = 1
//merge(mergeSort([15]), mergeSort([32]))
//    recurse^^^^^^^^
//[15] len =1
//***returns [15] */
//merge(mergeSort([15]), mergeSort([32]))
//          done          recurse^^^^^^^^^^
//[32] len =1
//***returns [32] */
//merge(mergeSort([15]), mergeSort([32]))
//          done          done
//now merge
//returns [15,32]
//now good to merge
//merge(mergeSort([5]), mergeSort([15,32]))
//return [5,15,32]
//merge(mergeSort([5,15,32]), mergeSort([4,66,9,105]))
//          done                recurse^^^^^^^^^^^^^^^
//[4,66,9,105] len =4
//middle = 2
//merge(mergeSort([4,66]), mergeSort([9,105]))
//    recurse^^^^^^^^
//[4,66] len =2
//middle = 1
//merge(mergeSort([4]), mergeSort([66]))
//    recurse^^^^^^^^
//[4] len =1
////***returns [4] */
//merge(mergeSort([4]), mergeSort([66]))
//         done.         recurse^^^^^^^^
//[66] len =1
////***returns [66] */
//now good to merge
//merge(mergeSort([4]), mergeSort([66]))
//return [4,66]
//merge(mergeSort([4,66]), mergeSort([9,105]))
//        done.              recurse^^^^^^^^
//[9,105] len =2
//middle = 1
//merge(mergeSort([9]), mergeSort([105]))
//    recurse^^^^^^^^
//[9] len =1
////***returns [9] */
//merge(mergeSort([9]), mergeSort([105]))
//         done.         recurse^^^^^^^^
//[105] len =1
////***returns [105] */
//now good to merge
//merge(mergeSort([9]), mergeSort([105]))
//return [9,105]
//now good to merge
//merge(mergeSort([4,66]), mergeSort([9,105]))
// returns [4,9,66,105]
//now good to merge
//merge(mergeSort([5,15,32]), mergeSort([4,9,66,105]))
//***returns [4,5,9,15,32,66,105] */
//done