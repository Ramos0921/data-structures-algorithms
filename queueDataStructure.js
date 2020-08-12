//QUEUES

//QUEUE FROM AN OBJECT
var Queue = function(){
  this.storage={};
  this.index=0;
  this.len=0;
}

Queue.prototype.add = function(value){
  this.storage[this.len]=value;
  this.len++;
}
Queue.prototype.remove=function(){
  var save = this.storage[this.index];
  delete this.storage[this.index];
  this.len--
  this.index++
  return save
}
Queue.prototype.length = function(){
  return this.len;
}


//QUEQUE FROM AN ARRAY
var Queue = function(){
  this.storage=[];
}

Queue.prototype.add = function(value){
  this.storage.push(value);
  this.len++;
}
Queue.prototype.remove=function(){
  var save = this.storage[0];
  this.storage.shift();
  return save
}
Queue.prototype.length = function(){
  return this.storage.length;
}