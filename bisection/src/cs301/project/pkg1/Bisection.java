package cs301.project.pkg1;

/**
 *
 * @author Josh
 */
public class Bisection {

    public static void main(String[] args) {
       
        bisection(0.5f,1.0f,20,0.0001f,'b');
    }

  private static void bisection(float a, float b, float nmax, float epsilon, char equation) {
    float fa, fb, fc;
    float c = (a+b)/2.0f;
    System.out.print(String.format("\nn = %-5s a = %-10s b = %-10s c = %-10s",0,a, b, c));
    if(equation =='a'){
        fa = equationA(a);
        fb = equationA(b);
        fc = equationA(c);
    }else {
        fa = equationB(a);
        fb = equationB(b);
        fc = equationB(c);
    }
    System.out.print(String.format(" f(a) = %-15s f(b) = %-15s f(c) = %-15s",fa,fb,fc));    
      float error;

      if( (fa * fb) >= 0 ) {
          System.out.println("invalid starting points f(a) * f(b) >= 0");
          return;
      }

      for(int n=1; n<nmax; n++){
          if(fa * fc < 0 ){
              b = c;
              fb = fc;
          }else{
              a = c;
              fa = fc;
          }
          float nextC = (a+b)/2.0f;
          
          if(equation =='a'){
              error = ( nextC - c)/nextC;
          }else{
              error = ( 0.56714329f - c)/ 0.56714329f;
          }
          System.out.print("Error = "+Math.abs(error));
          c=nextC;
          if(equation == 'a'){
              fc = equationA(c);
          }else{
              fc = equationB(c);
          }
         System.out.print(String.format("\nn = %-5s a = %-10s b = %-10s c = %-10s",n, a, b, c));
          System.out.print(String.format(" f(a) = %-15s f(b) = %-15s f(c) = %-15s",fa,fb,fc));  
         
          if(Math.abs(error)<epsilon){
              System.out.println("\nConvergence reached at c = "+c+" f(c) = "+fc);
              return;
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
