import java.util.Scanner;

public class ASSIGNMENT2 {
    public static void main(String[] args)
    {      
        Scanner In=new Scanner(System.in); 
	    int[][] A=new int[3][3];
	    int[][] B=new int[3][3];
	    int[][] C=new int[3][3];
	    MatrixProduct[][] thrd= new MatrixProduct[3][3];

	    System.out.println("Matrix A:");
	    System.out.println();
	    for(int i=0;i<3;i++)
	    {
	    	for(int j=0;j<3;j++)
	    	{
	           System.out.print(i+","+j+" = ");
	           A[i][j]=In.nextInt();
	    	}
	    }        
      System.out.println();    
      System.out.println("Matrix B:");
      System.out.println();
      for(int i=0;i<3;i++)
      {
    	  for(int j=0;j<3;j++)
    	  {
    		  System.out.print(i+","+j+" = ");
    		  B[i][j]=In.nextInt();
          }        
      }
      System.out.println();
      for(int i=0;i<3;i++)
      {
    	  for(int j=0;j<3;j++)
    	  {
    		  thrd[i][j]=new MatrixProduct(A,B,C,i,j);
    		  thrd[i][j].start();
    	  }
      }
      for(int i=0;i<3;i++)
      {
    	  for(int j=0;j<3;j++)
    	  {
    		  try{
    			  thrd[i][j].join();
    		  }
    		  catch(InterruptedException e){}
    	  }
      }        
      System.out.println();
      System.out.println("Multiplication");
      System.out.println();
      for(int i=0;i<3;i++)
      {
    	  for(int j=0;j<3;j++)
    	  {
    		  System.out.print(C[i][j]+" ");
    	  }    
    	  System.out.println(); 
      }       
      In.close();
    }      
}
class MatrixProduct extends Thread {
    int[][] A;
    int[][] B;
    int[][] C;
    int rig,col;

    public MatrixProduct(int[][] A,int[][] B,int[][] C,int rig, int col)
    {
       this.A=A;    
       this.B=B;
       this.C=C;
       this.rig=rig;    
       this.col=col;      
    }

   public void run()
   {
       for(int i=0;i<3;i++){
             C[rig][col]+=A[rig][i]*B[i][col];        
       }      
        System.out.println("Thread "+rig+","+col+" complete.");        
   }          
}