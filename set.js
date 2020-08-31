//SET DATA STRUCTURE

class Set{
  constructor(arr){
    this.arr=arr;
  }

  add(value){
    if(!this.has(value)) this.arr.push(value)

  }
  delete(value){
    this.arr = this.arr.filter(x => x !== value)
  }
  has(value){
    return this.arr.includes(value);
  }
  size(){
    return this.arr.length;
  }
  print(){
    console.log(this.arr)
  }

}