//STACKS

//stack from an object
var Stack = function(){
  this.storage ={};
  this.index = 0;
}

Stack.prototype.add=function(value)
{
  this.storage[this.index]=value;
  this.index++;
  alert(this)
}

Stack.prototype.remove=function(){
  var save = this.storage[this.index-1];
  delete this.storage[this.index-1];
  this.index--;
  return save
}
Stack.prototype.length=function(){
 return this.index;
}

//stack from an array
var Stack = function(){
  this.storage =[];
}

Stack.prototype.add=function(value)
{
  this.storage.push(value);
}

Stack.prototype.remove=function(){
  var save = this.storage[this.storage.length-1];
  this.storage.pop();
  return save
}
Stack.prototype.length=function(){
 return this.storage.length;
}
