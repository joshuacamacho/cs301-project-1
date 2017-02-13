package cs301.project.pkg1;

/**
 *
 * @author Josh
 */
public class Cs301Project1 {

    public static void main(String[] args) {
       // System.out.println(equationA(1));
//        bisection(1,2,20,0.001f,'a');
    }

    private static void bisection(float a, float b, float nmax, float epsilon, char equation) {
        float fa, fb, fc;
        float c = (a+b)/2.0f;
        if(equation =='a'){
            fa = equationA(a);
            fb = equationA(b);
            fc = equationA(c);
        }else {
            fa = equationB(a);
            fb = equationB(b);
            fc = equationB(c);
        }
        
        float error;
        
        if( (fa * fb) >= 0 ) {
            System.out.println("invalid starting points f(a) * f(b) >= 0");
            return;
        }
        
        for(int n=1; n<nmax; n++){
            System.out.println("C was "+c+" F(c)="+fc);
            if(fa * fc < 0 ){
                b = c;
                fb = fc;
            }else{
                a = c;
                fa = fc;
            }
            float nextC = (a+b)/2.0f;
            System.out.println("c was "+c+" nextC was "+nextC);
            error = (c - nextC)/nextC;
            c=nextC;
            if(equation == 'a'){
                fc = equationA(c);
            }else{
                fc = equationB(c);
            }
           System.out.println("epsilon was "+epsilon+" error was "+error);
            if(Math.abs(error)<epsilon){
                System.out.println("Convergence reached at c="+c+" f(c)="+fc);
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
