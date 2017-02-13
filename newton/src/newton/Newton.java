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
    newton(1.0f, 20, 0.001f, 'a');
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
        float fx, fprimex,fpx;
        if(equation == 'a'){
            fx = equationA(x);
        }else{
            fx = equationB(x);
        }
        
        System.out.println("X = "+x+" fx ="+fx);
        
        for(int n=1; n<nmax; n++){
           if(equation == 'a'){
               fpx = equationAprime(x);
           }else{
               fpx = equationBprime(x);
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
