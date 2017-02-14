/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secant;

/**
 *
 * @author Josh
 */
public class Secant {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    secant(0, 1.0f , 100, 0.01f, 'b');
  }

  private static void secant(float a, float b, int nmax, float epsilon, char equation) {
    float fa,fb,error;
    for(int n=0; n<nmax; n++){
      
      if(equation=='a'){
        fa = equationA(a);
        fb = equationA(b);
      }else{
        fa = equationB(a);
        fb = equationB(b);
      }
      float lasta = a;
      float lastb = b;
      a -= (a-b)*fa/(fa-fb);
      b = lasta;
      if(equation =='a'){
        error = (float)Math.abs((a-lasta)/a);
      }else{
        error = (float)Math.abs((0.56714329f - a )/0.56714329f);
      }
      System.out.print(String.format("\nn = %-5s x-1 = %-15s x = %-15s x+1 = %-15s error = %-15s",n,lastb,b,a,error));
      
      if(error<epsilon){
              System.out.println("\nConvergence reached at x = "+a);
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
