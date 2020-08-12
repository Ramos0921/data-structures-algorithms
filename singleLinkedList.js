//LINKED LIST

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
  }
}

List.prototype.addToTail= function(data){
  var newNode= Node(data);
  if(!this.head && !this.tail){
    this.head = newNode;
    this.tail=newNode;
  }else{
    this.tail.next = newNode;
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
  return headVal
}

var Node = function(data){
  return {data: data,next:null}
}