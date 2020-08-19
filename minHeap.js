//MinHeap
//Incremental fashion smallest to largest

let MinHeap = function(){
  this.heap =[null];
}

MinHeap.prototype.insert=function(num){
  this.heap.push(num);
  if(this.heap.length>2){
    let index = this.heap.length-1;
    while(this.heap[index]<this.heap[Math.floor(index/2)]){
      if(index>=1){
        var temp = this.heap[Math.floor(index/2)];
        this.heap[Math.floor(index/2)]=this.heap[index];
        this.heap[index]=temp;
        if(Math.floor(index/2)>1){
          index = Math.floor(index/2);
        }else{
          break;
        }
      }
    }
  }
}

MinHeap.prototype.remove= function(){
  let smallest = this.heap[1];
  if(this.heap.length>2){
    this.heap[1]=this.heap[this.heap.length-1];
    this.heap.splice(this.heap.length-1);
    if(this.heap.length ===3){
      if(this.heap[1]>this.heap[2]){
        let temp = this.heap[1];
        this.heap[1]=this.heap[2];
        this.heap[2]=temp;
      };
      return smallest;
    };
    let i =1;
    let left = 2*i;
    let right = 2*i+1;
    while(this.heap[i]>= this.heap[left]|| this.heap[i] >= this.heap[right]){
      if(this.heap[left]<this.heap[right]){
        let temp = this.heap[i];
        this.heap[i]= this.heap[left];
        this.heap[left]=temp;
        //es6 => [this.heap[i], this.heap[left]=this.heap[left],this.heap[i]]
        i=2*i;
      }else{
        let temp = this.heap[i];
        this.heap[i]= this.heap[right];
        this.heap[right]=temp;
        i=2*i+1;
      };
      left = 2*i;
      right = 2*i+1;
      if(this.heap[left]===undefined || this.heap[right]===undefined){
        break;
      };
    };
  }else if(this.heap.length ===2){
    this.heap.splice(1,1);
  }else{
    return null;
  };
  return smallest;
}
MinHeap.prototype.sort=function(){
  let result = new Array();
  while(this.heap.length>1){
    result.push(this.remove());
  }
  return result;
}
MinHeap.prototype.view=function(){
  return this.heap;
}

// let heap = new MinHeap();
// heap.insert(20)
// heap.insert(19)
// heap.insert(13)
// heap.insert(10)
// heap.insert(30)
//heap.view()=>[ null, 10, 13, 19, 20, 30 ]
//heap.remove();
//heap.view(); =>[ null, 13, 30, 19, 20 ]
//heap.sort(); =>[ 13, 19, 20, 30 ]