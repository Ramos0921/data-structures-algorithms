/**
 * An implementation of the Matrix ADT. Provides four basic operations over an
 * immutable type.
 *
 * @author Eduardo Ramos, Ruben Acuna
 * @version 1.0, 01/18/2021
 */
public class RamosMatrix implements Matrix {
  //private matrix for immutability purposes
  private int [][] data;

  //constructor
  RamosMatrix(int [][] matrix){
      if(matrix.length == 0){
          data = new int[0][0];
      }else{
          data = new int[matrix.length][matrix[0].length];
          for(int i = 0; i < matrix.length; i++){
              for(int j = 0; j < matrix[i].length; j++){
                  data[i][j] = matrix[i][j];
              }
          }
      }
   }

  public int getElement(int y, int x){
       return data[y][x];
  };

  public int getRows(){
       return data.length;
  };

  public int getColumns(){
      if(data.length == 0){
          return 0;
      }else{
      return data[0].length;
      }
  };

  public Matrix scale(int scalar){
      try{
          int [][] temp = new int[data.length][data[0].length];
          for(int i = 0; i < data.length; i++){
              for(int j = 0; j < data[0].length; j++){
                  temp[i][j] = data[i][j] * scalar;
              };
          };
          Matrix result = new RamosMatrix(temp);
          return result;
      }catch(Exception e){
          System.out.println("Cannot scale an empty matrix!: "+e);
      }
      return null;
  };

  public Matrix plus(Matrix other){
      try{
          int [][] temp = new int[data.length][data[0].length];
          for(int i = 0; i < data.length; i++){
              for(int j = 0; j < data[0].length; j++){
                  temp[i][j] = data[i][j] + other.getElement(i, j);
              };
          };
          Matrix result = new RamosMatrix(temp);
          return result;
      }catch(Exception e){
          System.out.println("Dimensions did not match: "+e);
      };
      return null;
  };

  public Matrix minus(Matrix other){
      try{
          int [][] temp = new int[data.length][data[0].length];
          for(int i = 0; i < data.length; i++){
              for(int j = 0; j < data[0].length; j++){
                  temp[i][j] = data[i][j] - other.getElement(i, j);
              };
          };
          Matrix result = new RamosMatrix(temp);
          return result;
      }catch(Exception e){
          System.out.println("Dimensions did not match: "+e);
      };
      return null;
  };

  public Matrix multiply(Matrix other){
      try{
          int [][] temp = new int[data.length][data[0].length];
          for(int i = 0; i < data.length; i++){
              for(int j = 0; j < data[0].length; j++){
                  temp[i][j] = data[i][j] * other.getElement(i, j);
              };
          };
          Matrix result = new RamosMatrix(temp);
          return result;
      }catch(Exception e){
          System.out.println("Dimensions did not match: "+e);
      };
      return null;
  };

  @Override
  public boolean equals(Object other){
      if(this == null || other == null){
              return false;
          }
      if(this.getClass() != other.getClass()){
              return false;
          }
      if(data.length != ((RamosMatrix) other).getRows() || data[0].length != ((RamosMatrix) other).getColumns()){
          return false;
      }
      for(int i = 0; i < data.length; i++){
          for(int j = 0; j < data[0].length; j++){
              if(data[i][j] != ((RamosMatrix) other).getElement(i,j)){
                  return false;
              }
          };
      };
      return true;
  };

  @Override
  public String toString(){
      String result = "";
      for(int i = 0; i < data.length; i++){
          for(int j = 0; j < data[i].length; j++){
              result += data[i][j]+" ";
          }
      result +="\n";
      }
      return result;
  };

  public static void main(String[] args) {

      int[][] data1 = new int[0][0];
      int[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
      int[][] data3 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
      int[][] data4 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};

      Matrix m1 = new RamosMatrix(data1);
      Matrix m2 = new RamosMatrix(data2);
      Matrix m3 = new RamosMatrix(data3);
      Matrix m4 = new RamosMatrix(data4);

      System.out.println("m2 value at (0,2)----> value: "+ m2.getElement(0,2)+"\n");
      System.out.println("m1 --> Rows: " + m1.getRows() + " Columns: " + m1.getColumns());
      System.out.println("m2 --> Rows: " + m2.getRows() + " Columns: " + m2.getColumns());
      System.out.println("m3 --> Rows: " + m3.getRows() + " Columns: " + m3.getColumns());

      //check for reference issues
      System.out.println("m2 -->\n" + m2);

      //immutable this will not work!
      data2[1][1] = 101;

      System.out.println("m2 -->\n" + m2);
      m2.toString();
      //test equals

      System.out.println("m2==null: " + m2.equals(null));             //false
      System.out.println("m3==\"MATRIX\": " + m2.equals("MATRIX"));   //false
      System.out.println("m2==m1: " + m2.equals(m1));                 //false
      System.out.println("m2==m2: " + m2.equals(m2));                 //true
      System.out.println("m2==m3: " + m2.equals(m3));                 //false
      System.out.println("m3==m4: " + m3.equals(m4));                 //true

      // //test operations (valid)
      System.out.println("2 * m2:\n" + m2.scale(2));
      System.out.println("m2 + m3:\n" + m2.plus(m3));
      System.out.println("m2 - m3:\n" + m2.minus(m3));
      System.out.println("m2 * m3:\n" + m2.multiply(m3));

      //test operations (invalid) return null
      System.out.println("m1 + m2: " + m1.plus(m2));
      System.out.println("m1 - m2: " + m1.minus(m2));
      System.out.println("m1 * m2: " + m1.multiply(m2));
      System.out.println("2 * m1: " + m1.scale(2));
  }
}

