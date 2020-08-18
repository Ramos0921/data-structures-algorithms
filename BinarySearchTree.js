//BINARY SEARCH TREE

var BST = function(data){
  this.data = data;
  this.left = null;
  this.right= null;
  this.parent=null;
}
BST.prototype.insert= function(data){

  //go left
  if(data<this.data){
    if(!this.left){
      this.left = new BST(data);
      this.left.parent= this;
    }else{
        this.left.insert(data);
      }
  }else{
    //go right
    if(!this.right){
      this.right = new BST(data)
      this.right.parent= this
    }else{
      this.right.insert(data);
    }
  }
}

BST.prototype.search=function(value){
  alert(this)
  if(this.data===value){
    return true;
  }
  if(value<this.data){
    if(this.left){
      return this.left.search(value)
    }else{
      return false;
    }
  }else{
      if(this.right){
      return this.right.search(value)
    }else{
      return false;
    }
  }
};


BST.prototype.delete=function(value){
  if(this.search(value)){
    if(this.data===value){
      //deletes leaf nodes
      if(this.parent && this.left === null && this.right===null){
        if(this.parent.right){
          if(this.parent.right.data===value){
            this.parent.right= null;
          }
        }
        if(this.parent.left){
          if(this.parent.left.data===value){
            this.parent.left= null;
          }
        }
      }
      //deletes child with only one child
      if(this.parent && (this.left===null||this.right===null)&&(this.left|| this.right)){
       var child= this.left || this.right;
       if(this === this.parent.left){
         child.parent = this.parent;
         this.parent.left = child
       }else{
         child.parent = this.parent;
         this.parent.right = child
       }
      }
      //deletes child with left and right children
      if(this.parent && this.left && this.right){

        var next = this.left;
        while(next){
          var succesor = next;
          next = next.left;
        }

        if(succesor.right){
          succesor.parent.left = succesor.right
        }else{
          succesor.parent.left = null;
        }

        succesor.parent= this.parent;

        if(this.right){
          succesor.right = this.right;
          this.right.parent = succesor;
        }else{
          succesor.right = null;
        }

        if(this.left){
          succesor.left = this.left
          this.left.parent = succesor;
        }else{
          succesor.left = null
        }

        if(this===this.parent.left){
          this.parent.left = succesor;
        }else{
          this.parent.right = succesor;
        }
      }

    }

    if(value<this.data){
      if(this.left){
       return this.left.delete(value)
       }
    }else{
        if(this.right){
          return this.right.delete(value)
        }
    }

  }else{
    return 'value not found in tree'
  }
}
BST.prototype.smallest = function(){
  var next = this.left;
    while(next){
      var smallest = next;
      next = next.left;
    }

return smallest.data;
}

BST.prototype.largest = function(){
  var next = this.right;
    while(next){
      var largest = next;
      next = next.right;
    }

return largest.data;
}

BST.prototype.view=function(){
  return this;
}
