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
  //alert(this)
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
      if(this.parent && this.left === null & this.right ===null){
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