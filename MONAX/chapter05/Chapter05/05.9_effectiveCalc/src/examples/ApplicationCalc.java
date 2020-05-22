
package examples;

import javax.swing.*;

public class ApplicationCalc extends javax.swing.JFrame {
    /**
     * Creates new form AppThreads
     */
    public ApplicationCalc() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {};
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("������ ����������� ����������");

        jButton1.setText("��������� ����� ����� long: ��������� �������");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("��������� ����� ����� long: ���������������� �������");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("��������� ����� ����� long: ������� �������");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("1");
        jRadioButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("i");
        jRadioButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("i*i");
        jRadioButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("i/3");
        jRadioButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("i&0xAF");
        jRadioButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setText("i|0xAF");
        jRadioButton6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel1.setText("���������:");

        jLabel2.setText("��");

        jLabel3.setText("��");

        jLabel4.setText("-----------------");

        jLabel6.setText("����� ���������� ");

        jLabel8.setText("t=------ ��");

        jTextField2.setText("1");

        jTextField3.setText("100000000");

        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setText("i^0xAF");
        jRadioButton7.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton7.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setText("i<<3");
        jRadioButton8.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton8.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton9);
        jRadioButton9.setText("i>>3");
        jRadioButton9.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton9.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton10);
        jRadioButton10.setText("i*8");
        jRadioButton10.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton10.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton11);
        jRadioButton11.setText("i/8");
        jRadioButton11.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton11.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jButton4.setText("��������� ����� ����� int: ���������������� �������");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jRadioButton8)
                        .add(18, 18, 18)
                        .add(jRadioButton10)
                        .add(684, 684, 684))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                            .add(jRadioButton7)
                            .addContainerGap())
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jRadioButton6)
                                .addContainerGap())
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup()
                                    .add(jRadioButton5)
                                    .addContainerGap())
                                .add(layout.createSequentialGroup()
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(layout.createSequentialGroup()
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                .add(layout.createSequentialGroup()
                                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                .add(jRadioButton1)
                                                                .add(jRadioButton2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)))
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jRadioButton3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                                        .add(jRadioButton4))
                                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                                                .add(layout.createSequentialGroup()
                                                    .add(jRadioButton9)
                                                    .add(242, 242, 242)))
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                                .add(jButton3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                                .add(jButton2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(layout.createSequentialGroup()
                                                    .add(jLabel2)
                                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                    .add(18, 18, 18)
                                                    .add(jLabel3)
                                                    .add(18, 18, 18)
                                                    .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 147, Short.MAX_VALUE))
                                                .add(jButton4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)))
                                        .add(layout.createSequentialGroup()
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(jLabel1)
                                                .add(jLabel6))
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(layout.createSequentialGroup()
                                                    .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                    .add(384, 384, 384))
                                                .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))))
                                    .add(175, 175, 175)))))
                    .add(layout.createSequentialGroup()
                        .add(59, 59, 59)
                        .add(jRadioButton11)
                        .add(684, 684, 684))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(26, 26, 26)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jRadioButton1)
                    .add(jButton2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jRadioButton2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jRadioButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jRadioButton4))
                    .add(layout.createSequentialGroup()
                        .add(jButton3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton1)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jRadioButton5)
                    .add(jButton4))
                .add(3, 3, 3)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jRadioButton6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jRadioButton7)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jRadioButton10)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jRadioButton11)
                                    .add(jRadioButton9)))
                            .add(jRadioButton8)))
                    .add(layout.createSequentialGroup()
                        .add(29, 29, 29)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel3)
                            .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(99, 99, 99)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel4))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(jLabel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE))
                .add(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    //        result=Calculator.intSum_i((int)i1,(int)i2);
    i1=Integer.parseInt(jTextField2.getText());
    i2=Integer.parseInt(jTextField3.getText());
    long t0=System.currentTimeMillis();
    if( jRadioButton1.isSelected() )  result=Calculator.intSum_1((int)i1,(int)i2);
    if( jRadioButton2.isSelected() )  result=Calculator.intSum_i((int)i1,(int)i2);
    if( jRadioButton3.isSelected() )  result=Calculator.intSum_i2((int)i1,(int)i2);
    if( jRadioButton4.isSelected() )  result=Calculator.intSum_i_3((int)i1,(int)i2);
    if( jRadioButton5.isSelected() )  result=Calculator.intSum_and((int)i1,(int)i2);
    if( jRadioButton6.isSelected() )  result=Calculator.intSum_or((int)i1,(int)i2);
    if( jRadioButton7.isSelected() )  result=Calculator.intSum_xor((int)i1,(int)i2);
    if( jRadioButton8.isSelected() )  result=Calculator.intSum_shl((int)i1,(int)i2);
    if( jRadioButton9.isSelected() )  result=Calculator.intSum_shr((int)i1,(int)i2);
    if( jRadioButton10.isSelected() )  result=Calculator.intSum_8i((int)i1,(int)i2);
    if( jRadioButton11.isSelected() )  result=Calculator.intSum_i_8((int)i1,(int)i2);
    long t=System.currentTimeMillis()-t0;
    jLabel4.setText("integral="+result);
    jLabel8.setText("t="+t+" мс");
}//GEN-LAST:event_jButton4ActionPerformed

Fnc fnc;
long i1=0;
long i2=10;
long result=0;

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    i1=Integer.parseInt(jTextField2.getText());
    i2=Integer.parseInt(jTextField3.getText());
    if( jRadioButton1.isSelected() )  fnc=new Fnc1();
    if( jRadioButton2.isSelected() )  fnc=new Fnc();
    if( jRadioButton3.isSelected() )  fnc=new FncI2();
    if( jRadioButton4.isSelected() )  fnc=new FncI_3();
    if( jRadioButton5.isSelected() )  fnc=new Fnc_and();
    if( jRadioButton6.isSelected() )  fnc=new Fnc_or();
    if( jRadioButton7.isSelected() )  fnc=new Fnc_xor();
    if( jRadioButton8.isSelected() )  fnc=new Fnc_shl();
    if( jRadioButton9.isSelected() )  fnc=new Fnc_shr();
    if( jRadioButton10.isSelected() )  fnc=new Fnc8i();
    if( jRadioButton11.isSelected() )  fnc=new FncI_8();
    long t0=System.currentTimeMillis();
    result=Calculator.slowSum(i1,i2,fnc);
    long t=System.currentTimeMillis()-t0;
    jLabel4.setText("integral="+result);
    jLabel8.setText("t="+t+" мс");
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    i1=Integer.parseInt(jTextField2.getText());
    i2=Integer.parseInt(jTextField3.getText());
    long t0=System.currentTimeMillis();
    if( jRadioButton1.isSelected() )  result=Calculator.usualSum_1(i1,i2);
    if( jRadioButton2.isSelected() )  result=Calculator.usualSum_i(i1,i2);
    if( jRadioButton3.isSelected() )  result=Calculator.usualSum_i2(i1,i2);
    if( jRadioButton4.isSelected() )  result=Calculator.usualSum_i_3(i1,i2);
    if( jRadioButton5.isSelected() )  result=Calculator.usualSum_and(i1,i2);
    if( jRadioButton6.isSelected() )  result=Calculator.usualSum_or(i1,i2);
    if( jRadioButton7.isSelected() )  result=Calculator.usualSum_xor(i1,i2);
    if( jRadioButton8.isSelected() )  result=Calculator.usualSum_shl(i1,i2);
    if( jRadioButton9.isSelected() )  result=Calculator.usualSum_shr(i1,i2);
    if( jRadioButton10.isSelected() )  result=Calculator.usualSum_8i(i1,i2);
    if( jRadioButton11.isSelected() )  result=Calculator.usualSum_i_8(i1,i2);
    long t=System.currentTimeMillis()-t0;
    jLabel4.setText("integral="+result);
    jLabel8.setText("t="+t+" мс");
}//GEN-LAST:event_jButton3ActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        i1=Integer.parseInt(jTextField2.getText());
        i2=Integer.parseInt(jTextField3.getText());
        long t0=System.currentTimeMillis();
        if( jRadioButton1.isSelected() )  result=Calculator.fastSum_1(i1,i2);
        if( jRadioButton2.isSelected() )  result=Calculator.fastSum_i(i1,i2);
        if( jRadioButton3.isSelected() )  result=Calculator.fastSum_i2(i1,i2);
        if( jRadioButton4.isSelected() )  result=Calculator.fastSum_i_3(i1,i2);
        if( jRadioButton5.isSelected() )  result=Calculator.fastSum_and(i1,i2);
        if( jRadioButton6.isSelected() )  result=Calculator.fastSum_or(i1,i2);
        if( jRadioButton7.isSelected() )  result=Calculator.fastSum_xor(i1,i2);
        if( jRadioButton8.isSelected() )  result=Calculator.fastSum_shl(i1,i2);
        if( jRadioButton9.isSelected() )  result=Calculator.fastSum_shr(i1,i2);
        if( jRadioButton10.isSelected() )  result=Calculator.fastSum_8i(i1,i2);
        if( jRadioButton11.isSelected() )  result=Calculator.fastSum_i_8(i1,i2);
        long t=System.currentTimeMillis()-t0;
        jLabel4.setText("integral="+result);
        jLabel8.setText("t="+t+" мс");
    }//GEN-LAST:event_jButton2ActionPerformed
    
    Integrator integrator;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationCalc().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
    
}
