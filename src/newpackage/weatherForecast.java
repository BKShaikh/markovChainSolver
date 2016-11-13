package newpackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Jama.Matrix;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Shaikh
 */
public class weatherForecast {
    
      public enum State {Sunny,Cloudy};
    private State state;
    private double [][] transitionProbabilityMatrix; 
    String filePath;
    List<String> pList;
    
    
   // public weatherForecast(int nStates, int nSteps ,String path) 
     public weatherForecast(int nStates, int nSteps ){
    
        super();
        transitionProbabilityMatrix = new double [nStates][nStates];
//     //   filePath =path;
//        
//        try(BufferedReader br= new BufferedReader(new FileReader (path)))
//        {
//            //br return as stream and convert it into a list 
//            pList = br.lines().collect(Collectors.toList());
//            
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        
        for (int i = 0; i < nStates; i++) {
                
            String line = pList.get(i);
            String[] tokens =line.split(",");
            
            for (int j = 0; j < nStates; j++) {
                
              //  System.out.println(Double.parseDouble(tokens[j]));                
                transitionProbabilityMatrix[i][j]=Double.parseDouble(tokens[j]);
                
                
//                try{
//                System.out.println(Double.parseDouble(tokens[j]));                
//                
//                transitionProbabilityMatrix[j][i]=Double.parseDouble(tokens[j]);
//                }
//                catch(NumberFormatException ex){
//
//            System.err.println("Ilegal input");
//                       }
                
            }
                                           
            }
         writeToFile(nSteps);
        
        
    }
    public void writeToFile(int steps)
    {
      
//        Matrix b1 = new Matrix(transitionProbabilityMatrix);
        Matrix A = new Matrix (transitionProbabilityMatrix);
      //  Matrix ASquare = power (A,2);
        Matrix A2=A;
      //  Matrix B = new Matrix(transitionProbabilityMatrix);
        for (int i = 0; i < 2; i++) {
         
            A2=A2.times(A);
        }
         
        
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                
                 double v= A2.get(i, j);
        
        System.out.println(v);
                
            }
           
            
        }
        
        
        
  //      b1=A2;
        
        
       // Matrix A2= A.times(A);
       // Matrix B=A2.times(A);
        String s = System.lineSeparator() + "NEW LINE! ";
        
        //solving eqs
//         int N=2;
//         
//         
//         Matrix B = A.minus(Matrix.identity(N, N));         //B=[0.6,0.6;0.6 0.3] 2x2
//         
//         for (int i = 0; i < N; i++) {
//            
//             B.set(0,i,1.0);                    // B=[1 1;0.6 0.3] 2x2
//             Matrix b = new Matrix(N,1);        // column vector 2x1
//             b.set(0,0,1.0);                    //b=[1 0]
//             
//             
//             Matrix x = new Matrix(N,1);  //hold result in coulum vector 2x1
//             x= B.solve(b);
//         
//         
//         }
        
        
        
//        PrintWriter pw =null;
//        try {
//         
////            pw =new PrintWriter(new BufferedWriter(new FileWriter(filePath,true)));
////            pw.write(s);
////            A2.print(pw,A2.getRowDimension(),A2.getColumnDimension());
//          
//           
//           // pw.write(s);
//         //   B.print(pw,B.getRowDimension(),B.getColumnDimension());
//            
////            pw.write("Stationary distribution  by solving linear system of eq");
////            x.print(pw,x.getRowDimension(),x.getColumnDimension());
//            
//            pw.close();
//                                  
//        }
//        catch(IOException ex)
//        {
//            System.err.println(ex);
//        }
//        
        
    }
    
   
    
//    public Matrix steadyState()
//    {
//        
//    }
    
}
