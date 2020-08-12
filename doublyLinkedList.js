//DOUBLY LINKED LIST

var List = function(){
  this.head = null;
  this.tail = null;
}
List.prototype.addToHead=function(data){
  var newNode = Node(data)
  if(!this.head && !this.tail){
    this.head = newNode;
    this.tail = newNode;
  }else{
    var next= this.head;
    this.head = newNode;
    this.head.next = next;
    next.prev = this.head;
  }
}

List.prototype.addToTail= function(data){
  var newNode= Node(data);
  if(!this.head && !this.tail){
    this.head = newNode;
    this.tail=newNode;
  }else{
    this.tail.next = newNode;
    newNode.prev = this.tail;
    this.tail = newNode;
  }
}

List.prototype.search= function(target){
  var head = this.head;
  while(head !== null){
    if(head.data ===target){
      return true;
    }
    head = head.next
  }
  return false;
}
List.prototype.removeHead = function(){
  var headVal= this.head.data;
  this.head = this.head.next;
  this.head.prev = null;
  return headVal
}
List.prototype.removeTail= function(){
  var tailVal = this.tail.data;
  this.tail = this.tail.prev;
  this.tail.next = null
  return tailVal;
}
List.prototype.length = function(){
  var len = 0;
  var start = this.head;
  while(start!==null){
    start = start.next;
    len++;
  }
  return len;
}
List.prototype.values=function(){
  var start = this.head;
  var location=1;
  var result=[];
  while(start!==null){
    var obj = {};
    obj.location= location;
    obj.value = start.data;
    result.push(obj)
    location++;
    start = start.next;
  }
  alert(result)
  return result;
}
List.prototype.sort=function(){
  var arr =[];
  var start = this.head;
  while(start){
    arr.push(start)
    start = start.next
  }
  for(var i =0;i<arr.length;i++){
    var current = arr[i].data;
    var prev = i-1;
    while(prev>=0&&arr[prev].data>current){
      arr[prev+1].data=arr[prev].data
      prev=prev-1;
    }
    arr[prev+1].data= current;
  }
 return arr;
}

var Node = function(data){
  return {data: data,next:null, prev: null,}
}
