// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000


let intToRoman = function(num) {
  let numbers=[1000,900,500,400,100,90,50,40,10,9,5,4,1];
  let romanNums=['M','CM','D','CD','C','XC','L','XL','X','IX','V','IV','I'];
  let roman='';
  for(let i =0;i<numbers.length;i++){
    while(numbers[i]<=num){
      roman+=romanNums[i];
      num-=numbers[i];
    }
  }
  return roman;
};