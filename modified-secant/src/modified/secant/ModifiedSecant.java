/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modified.secant;
import java.util.Scanner;


public class ModifiedSecant {

  public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
       System.out.println("Enter x");
       float x = scan.nextFloat();
       System.out.println("Enter a or b for equation a or b");
       String eq = scan.next();
    
    
    //arguments ( x , delta, nmax, epsilon, equation letter (a or b)
    modifiedsecant(x, 0.01f , 100, 0.01f, eq.charAt(0));
  }
  
  private static void modifiedsecant(float x, float delta, int nmax, float epsilon, char equation) {
    float fx,fdeltax,error;
    for(int n=0; n<nmax; n++){
      
      if(equation=='a'){
        fx = equationA(x);
        fdeltax = equationA(delta*x + x);
      }else{
        fx = equationB(x);
        fdeltax = equationB(delta*x + x);
      }
      float lastx = x;
      
      x -= (fx * delta * x)/(fdeltax - fx);
      
      if(equation =='a'){
        error = (float)Math.abs((x-lastx)/x);
      }else{
        error = (float)Math.abs((0.56714329f - x )/0.56714329f);
      }
      System.out.print(String.format("\nn = %-5s x = %-15s x+1 = %-15s f(x) = %-15s error = %-15s",n,lastx,x,fx,error));
      
      if(error<epsilon){
              System.out.println("\nConvergence reached at x = "+x);
              return;
      }
    }
    
  }
  
  private static float equationA(float a) {
   float square = a * a;
   return (2.0f *square*a - 11.7f *square + 17.7f * a - 5.0f);
}

  private static float equationB(float a) {
      return (float)Math.exp(-a) - a;
  }
  
}
