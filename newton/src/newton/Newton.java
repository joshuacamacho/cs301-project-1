/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newton;

/**
 *
 * @author Josh
 */
public class Newton {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    newton(1.0f, 20, 0.001f, 'b');
  }
      //   f(x) = 2x^3 – 11.7x^2 + 17.7x – 5
    private static float equationA(float a) {
       float square = a * a;
       return (2.0f *square*a - 11.7f *square + 17.7f * a - 5.0f);
    }

    private static float equationB(float a) {
        return (float)Math.exp(-a) - a;
    }
    
    private static void newton(float x, int nmax, float epsilon, char equation) {
        float fx, fprimex,fpx,error;
        
        error=0;
        
        
        for(int n=0; n<nmax; n++){
           if(equation == 'a'){
               fx = equationA(x);
               fprimex = equationAprime(x);
           }else{
               fx = equationB(x);
               fprimex = equationBprime(x);
           }
           
           System.out.print(String.format("\nn = %-5s x = %-15s f(x) = %-15s",n,x,fx));
           float oldx = x;
           x -= fx/fprimex;
           if(equation == 'a'){
             error = (float)Math.abs((x-oldx)/x);
           }else{
             error = (float)Math.abs((0.56714329f - x)/ 0.56714329f);
           }
           
           System.out.print(String.format("x+1 = %-15s error = %-15s",x,error));
           
           if(error<epsilon){
              System.out.println("\nConvergence reached at x = "+x+" f(x) = "+fx);
              return;
          }
           
           
        }
                
    }
    // f'(x) = 6x^2 - 23.4x +17.7
    private static float equationAprime(float x) {
        float square = x * x;
        return 6.0f *square - 23.4f * x + 17.7f;
    }
    
    // f'(x) = -e^-x -1
    private static float equationBprime(float x) {
        return -(float)Math.exp(-x)-1;
    }
}
