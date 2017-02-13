/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modified.secant;

/**
 *
 * @author Josh
 */
public class ModifiedSecant {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    modifiedsecant(0.2f, 1.0f , 100, 0.001f, 'a');
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
      System.out.print(String.format("\nn = %-5s x = %-15s x+1 = %-15s f(x) = %-15s error = %-15s",n,delta,x,fx,error));
      
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
