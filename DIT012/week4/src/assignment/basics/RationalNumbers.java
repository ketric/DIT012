package assignment.basics;

import static java.lang.Math.*;
import static java.lang.System.*;

/**
 *  Class for rationals (below)
 */
public class RationalNumbers {

    public static void main(String[] args) {
        new RationalNumbers().program();
    }

    void program() {
        // This is testing. All output should print true
        Rational r = new Rational(2);
        out.println(r.num == 2 && r.denom == 1);
        r = new Rational(4, 9);
        out.println(r.num == 4 && r.denom == 9);
        r = new Rational(49, 168);
        out.println(r.num == 7 && r.denom == 24);
        r = new Rational(20, 4);
        out.println(r.num == 5 && r.denom == 1);
        r = new Rational(0, 1);
        out.println(r.num == 0 && r.denom == 1);
        r = new Rational(-49, 168);
        out.println(r.num == -7 && r.denom == 24);
        r = new Rational(49, -168);
        out.println(r.num == -7 && r.denom == 24);
        r = new Rational(-49, -168);
        out.println(r.num == 7 && r.denom == 24);

        Rational r1 = new Rational(1, 4);
        Rational r2 = new Rational(1, 2);
        out.println(r1.add(r2).equals(new Rational(3, 4)));
        out.println(r1.sub(r2).equals(new Rational(-1, 4)));
        out.println(r1.mul(r2).equals(new Rational(1, 8)));
        out.println(r1.div(r2).equals(new Rational(1,2 )));

        Rational r3 = new Rational(r1);
        out.println(r3.equals(r1));
        out.println(! r3.lessThan(r1));
        out.println(r3.toDouble() == 0.25); // Bit dangerous compare doubles

    }


    // -- The rational class -------------------------

    class Rational {
        final int num;   // 0 just for now
        final int denom;  // 0 just for now

        Rational(int num){
            this.num=num;
            this.denom=1;
        }
        Rational(int num, int denom){
            if(denom<0){
                num*=-1;
                denom*=-1;
            }
            int gc = this.gcd(num, denom);
            this.num=num/gc;
            this.denom=denom/gc;
        }
        Rational(Rational r){
            this.num=r.num;
            this.denom=r.denom;
        }

        // Add methods below this
        private int gcd(int num, int denom){
            int gc=1;
            int min;
            if(abs(num)<abs(denom)) {
                min = abs(num);
            }else{
                min=abs(denom);
            }
            for(int i=2; i<=min;i++){
                if(num%i==0 && denom%i==0){
                    gc=i;
                }
            }
            return gc;
        }

        public boolean equals(Rational a){
            if (a.num==this.num && a.denom==this.denom){
                return true;
            }
            return false;
        }

        public Rational add(Rational a){
            return new Rational(a.num*this.denom + this.num*a.denom,a.denom*this.denom);
        }

        public Rational sub(Rational a){
            return new Rational(this.num*a.denom - a.num*this.denom,a.denom*this.denom);
        }

        public Rational mul(Rational a){
            return new Rational(this.num*a.num,this.denom*a.denom);
        }

        public Rational div(Rational a){
            return new Rational(this.num*a.denom,this.denom*a.num);
        }

        public double toDouble(){
            return (double) (this.num)/this.denom;
        }

        public boolean lessThan(Rational a){
            if(a.toDouble()>this.toDouble()){
                return true;
            }
            return false;
        }
    }
}