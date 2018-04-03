/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso_prac;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.stream.Stream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graphic_Representation extends JPanel {

    double[] x;
    double[] y;

    Graphic_Representation() {

    }

    Graphic_Representation(double[] x, double[] y) {
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // g2d.setColor(generateRandomColor());
         g2d.setBackground(Color.BLACK);
            g2d.fillRect(1, 1, 12000, 12000);
        g.setColor(Color.WHITE);
        g.fillOval(570, 165, 80, 80);
        for (int i = 0; i < x.length; i++) {
            g2d.setColor(generateRandomColor());
            g2d.fill3DRect((int) this.x[i], (int) this.y[i], 10, 10, true);
            //g2d.fillOval((int)this.x[i],(int)this.y[i], 10, 10); 
            

        }

    }

    private Color generateRandomColor() {
        int R = (int) (Math.random() * 256);
        int G = (int) (Math.random() * 256);
        int B = (int) (Math.random() * 256);
        Color c = new Color(R, G, B);
        return c;
    }

    public void drawPoints(ArrayList<Double[]> xs, ArrayList<Double[]> ys) throws InterruptedException {
        JFrame frame = new JFrame("Points");

        //demo d = new demo();
        ImageIcon img = new ImageIcon(getClass().getResource("/pso_prac/3.gif"));
        ImageIcon img1 = new ImageIcon(getClass().getResource("/pso_prac/2.gif"));

        JLabel imageLabel = new JLabel();
        JLabel lbl = new JLabel();
        lbl.setIcon(img1);
        lbl.setLocation(3, 1);

        //imageUpdate(img, i, i, i, i, i)
        // imageLabel.setPreferredSize(new Dimension(200, 200));    
        imageLabel.setIcon(img);
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < xs.size(); i++) {
            double[] unboxedX = Stream.of(xs.get(i)).mapToDouble(Double::doubleValue).toArray();
            double[] unboxedY = Stream.of(ys.get(i)).mapToDouble(Double::doubleValue).toArray();
            frame.getContentPane().setLayout(new BorderLayout());

            frame.getContentPane().add(imageLabel, BorderLayout.SOUTH);
            frame.getContentPane().add(lbl);

            frame.getContentPane().add(new Graphic_Representation(unboxedX, unboxedY), BorderLayout.CENTER);
             frame.getContentPane().setBackground(Color.BLACK);
            frame.setVisible(true);
            Thread.sleep(300);
        }

        // frame.getContentPane().add(imageLabel, BorderLayout.CENTER);
        //frame.setVisible(true);
//------------------------------------
//       javax.swing.JLabel jLabel1;
//       javax.swing.JLabel jLabel2;
//        jLabel2 = new javax.swing.JLabel();
//        jLabel1 = new javax.swing.JLabel();
//
//        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        jLabel2.setText("jLabel2");
//        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
//
//        jLabel1.setText("jLabel1");
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
//        frame.getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
//            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap())
//        );
//
//        
//frame.setVisible(true);
    }
}
