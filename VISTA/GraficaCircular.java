
package VISTA;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.SQLException;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

import DADES.SQLComandes;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;

public class GraficaCircular extends javax.swing.JFrame {
	
	public JFrame frameCirc;
    boolean bandera = true;
	
    public GraficaCircular() {
    	
        initComponents();
        
    }
    
  
    private void initComponents() {
    	
    	frameCirc = new JFrame();
    	frameCirc.getContentPane().setBackground(Color.BLACK);
    	frameCirc.setResizable(false);
    	frameCirc.getContentPane().setFocusable(false);
    	frameCirc.getContentPane().setFocusTraversalKeysEnabled(true);
    	frameCirc.setBounds(730, 300, 686, 551);
    	frameCirc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frameCirc.getContentPane().setLayout(null);
        
        JLabel label_1 = new JLabel();
        label_1.setText("Tàsques Finalitzades");
        label_1.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.RED);
        
        JLabel label = new JLabel();
        label.setText("Tasques en Procés");
        label.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.BLUE);
        
        JLabel label_2 = new JLabel();
        label_2.setText("Tàsques Finalitzades");
        label_2.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(212, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        			.addGap(24)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(273)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
        				.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(label, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraficaCircular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaCircular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaCircular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaCircular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficaCircular().setVisible(true);
            }
        });
    }
    
    // End of variables declaration//GEN-END:variables

    public void paint(Graphics g){
    	SQLComandes sqlCo = new SQLComandes();

        super.paint(g);
        if(bandera == true){
            
            int int_rojo = 0;
            int int_verde = 0;
            int int_azul = 0;
            
			try {
				int_verde = sqlCo.contarComandesFin();
				int_rojo = sqlCo.contarComandesEnProces();
		        int_azul = sqlCo.contarComandesP();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
            
            int total_votos = int_rojo + int_verde + int_azul;
            
            int grados_rojo = int_rojo * 360 / total_votos;
            int grados_verde = int_verde * 360 / total_votos;
            int grados_azul = int_azul * 360 / total_votos;
            
            g.setColor(new Color(255, 0, 0));
            g.fillArc(25, 80, 200, 200, 0, grados_rojo);
            
            g.setColor(new Color(0, 130, 0));
            g.fillArc(25, 80, 200, 200, grados_rojo, grados_verde);
            
            g.setColor(new Color(0, 0, 255));
            g.fillArc(25, 80, 200, 200, grados_rojo + grados_verde, grados_azul);
        }
    }
}
