/*
 * MiddleTriangles.java
 *
 * Created on April 9, 2007, 11:22 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package examples;

/**
 *
 * @author monakhov
 */
public class Calculator {
    
    
    
    public static long slowSum(long i1,long i2,Fnc fnc) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r=r+fnc.f(i);
        return r;
    }
    
    
    
    public static long fastSum_1(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r+=1;
        return r;
    }
    
    public static long fastSum_i(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r+=i;
        return r;
    }
    
    public static long fastSum_i2(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r+=i*i;
        return r;
    }
    
    public static long fastSum_i_3(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r+=i/3;
        return r;
    }
    
    public static long fastSum_and(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r+=i&0xAF;
        return r;
    }
    
    public static long fastSum_or(long i1,long i2) {
        
        long r=0;
        for(long i=i1;i<=i2;i++)
            r+=i|0xAF;
        return r;
    }
    
    public static long fastSum_xor(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r+=i^0xAF;
        return r;
    }
    
    public static long fastSum_shl(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r+=i<<3;
        return r;
    }
    
    public static long fastSum_shr(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r+=i>>3;
        return r;
    }
    
    public static long fastSum_8i(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r+=i*8;
        return r;
    }
    
    public static long fastSum_i_8(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r+=i/8;
        return r;
    }
    
    public static long usualSum_1(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r=r+1;
        return r;
    }
    
    public static long usualSum_i(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r=r+i;//i+r;
        return r;
    }
    
    public static long usualSum_i2(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r=r+i*i;
        return r;
    }
    
    public static long usualSum_i_3(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r=r+i/3;
        return r;
    }
    
    public static long usualSum_and(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r=r+(i&0xAF);
        return r;
    }
    
    public static long usualSum_or(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r=r+(i|0xAF);
        return r;
    }
    
    public static long usualSum_xor(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r=r+(i^0xAF);
        return r;
    }
    
    public static long usualSum_shl(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r=r+(i<<3);
        return r;
    }
    
    public static long usualSum_shr(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r=r+(i>>3);
        return r;
    }
    
    public static long usualSum_8i(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r=r+i*8;
        return r;
    }
    
    public static long usualSum_i_8(long i1,long i2) {
        long r=0;
        for(long i=i1;i<=i2;i++)
            r=r+i/8;
        return r;
    }
    
    
    
    public static int intSum_1(int i1,int i2) {
        int r=0;
        for(int i=i1;i<=i2;i++)
            r+=1;
        return r;
    }
    
    public static int intSum_i(int i1,int i2) {
        int r=0;
        for(int i=i1;i<=i2;i++)
            r+=i;
        return r;
    }
    
    public static int intSum_i2(int i1,int i2) {
        int r=0;
        for(int i=i1;i<=i2;i++)
            r+=i*i;
        return r;
    }
    
    public static int intSum_i_3(int i1,int i2) {
        int r=0;
        for(int i=i1;i<=i2;i++)
            r+=i/3;
        return r;
    }
    
    public static int intSum_and(int i1,int i2) {
        int r=0;
        for(int i=i1;i<=i2;i++)
            r+=i&0xAF;
        return r;
    }
    
    public static int intSum_or(int i1,int i2) {
        int r=0;
        for(int i=i1;i<=i2;i++)
            r+=i|0xAF;
        return r;
    }
    
    public static int intSum_xor(int i1,int i2) {
        int r=0;
        for(int i=i1;i<=i2;i++)
            r+=i^0xAF;
        return r;
    }
    
    public static int intSum_shl(int i1,int i2) {
        int r=0;
        for(int i=i1;i<=i2;i++)
            r+=i<<3;
        return r;
    }
    
    public static int intSum_shr(int i1,int i2) {
        int r=0;
        for(int i=i1;i<=i2;i++)
            r+=i>>3;
        return r;
    }
    
    public static int intSum_8i(int i1,int i2) {
        int r=0;
        for(int i=i1;i<=i2;i++)
            r+=i*8;
        return r;
    }
    
    
    public static int intSum_i_8(int i1,int i2) {
        int r=0;
        for(int i=i1;i<=i2;i++)
            r+=i/8;
        return r;
    }
}



