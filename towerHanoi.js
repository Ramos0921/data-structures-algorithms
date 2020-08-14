//Tower of Hanoi
//Recursion

var move = function(disc,start,end,inter){
  if(disc===1){
    console.log('Moving disc 1 from '+ start +' to '+ end)
  }else{
    move(disc-1, start,inter,end)
    console.log('Moving disc '+ disc+' from '+start+' to '+end);
    move(disc-1,inter,end,start)
  }
}
//EX: move(3,'A','C','B')=>
//Moving disc 1 from A to C
// Moving disc 2 from A to B
// Moving disc 1 from C to B
// Moving disc 3 from A to C
// Moving disc 1 from B to A
// Moving disc 2 from B to C
// Moving disc 1 from A to C