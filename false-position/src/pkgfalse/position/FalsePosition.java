/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfalse.position;
import java.util.Scanner;
/**
 *
 * @author Josh
 */
public class FalsePosition {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
       System.out.println("Enter a");
       float a = scan.nextFloat();
        System.out.println("Enter b");
       float b = scan.nextFloat();
       System.out.println("Enter a or b for equation a or b");
       String eq = scan.next();
    
    //parameters a, b, nmax, epsilon, equation(a or b)
     falseposition(a,b,100,0.01f,eq.charAt(0));
  }

  private static void falseposition(float a, float b, int nmax, float epsilon, char equation) {
    float fb,fa,fc,error,c;
    error=1.0f;c=0;
    fa=0;fb=0;
    for(int n=0; n<nmax; n++){
      
      if(equation=='a' && n==0){
        fa = equationA(a);
        fb = equationA(b);
      }else if(n==0){
        fa = equationB(a);
        fb = equationB(b);
      }
      float lastc = c;
      c = (a*fb - b * fa)/(fb-fa);
      
      if(equation == 'a'){
        fc = equationA(c);
      }else{
        fc = equationB(c);
      }
      
      if(equation=='a' && n!=0){
        error = (float)Math.abs((c-lastc)/c);
      }else{
        error = (float)Math.abs( (0.56714329f - c) / 0.56714329f );
      }
      
      System.out.print(String.format("\nn = %-5s a = %-15s b = %-15s c = %-15s f(c) = %-15s error = %-15s", n, a,b, c,fc,error));
      
       if(error<epsilon){
              System.out.println("\nConvergence reached at c = "+c+"\nf(c) = "+fc);
              return;
       }
       
       if( fa *fc < 0){
         b = c;
         fb = fc;
       }else{
         a = c;
         fa = fc;
       }
       
       
    }
    
    
  }
  
  //   f(x) = 2x^3 – 11.7x^2 + 17.7x – 5
  private static float equationA(float a) {
     float square = a * a;
     return (2.0f *square*a - 11.7f *square + 17.7f * a - 5.0f);
  }

  private static float equationB(float a) {
      return (float)Math.exp(-a) - a;
  }
    
  
}
