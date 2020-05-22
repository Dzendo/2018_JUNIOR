/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplethreadmanager;

/**
 *
 * @author LV
 */
public class SimpleThreadManager_1
{
    public static void main(String[] arg) {
        for (int i = 0; i < 100; i++) {
            Thread first = new Thread() {
                @Override
                public void run() {
                    try {
                        long pause = Math.round(Math.random() * 7000);
                        Thread.sleep(pause);
                        System.out.println("Simple Thread - pause=" + pause);
                    } catch (InterruptedException i_ex) {
                    }
                }
            };
            first.start();
        }
    }
}
 
