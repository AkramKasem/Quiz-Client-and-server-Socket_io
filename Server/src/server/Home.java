package server;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * @author Akram Kasem
 *
 */
public class Home extends JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JPanel header;
    private JPanel home;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JScrollPane jScrollPane1;
    private static JTable jTable1;
    private JPanel main;
    private JPanel students;
    // End of variables declaration//GEN-END:variables

    static Vector<Socket> ClientSockets;
    static int clientCount = 0;

    public Home() throws IOException {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws IOException {

        main = new JPanel();
        header = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel5 = new JLabel();
        home = new JPanel();
        students = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        main.setBackground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(1, 198, 83));
        header.setPreferredSize(new java.awt.Dimension(838, 200));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Keep going");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student Score in Quizzes");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        GroupLayout headerLayout = new GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
                headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(headerLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(headerLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel1)))
                                .addContainerGap(309, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
                headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addContainerGap(99, Short.MAX_VALUE))
        );

        home.setLayout(new java.awt.CardLayout());

        students.setBackground(new java.awt.Color(255, 255, 255));
        students.setLayout(new BoxLayout(students, BoxLayout.LINE_AXIS));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setFont(new Font("Serif", Font.BOLD, 20));
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Name", "Score", "Time", "Pass"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(1, 198, 83));
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        for (int i = 0; i < 5; i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }
        jScrollPane1.setViewportView(jTable1);

        students.add(jScrollPane1);

        home.add(students, "card3");

        GroupLayout mainLayout = new GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(header, GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                        .addComponent(home, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(header, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(home, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(main, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(main, GroupLayout.PREFERRED_SIZE, 536, Short.MAX_VALUE)
        );

        pack();

    }// </editor-fold>//GEN-END:initComponents
    int xx;
    int xy;

    private void headerMousePressed(MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();

    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_headerMouseDragged

    // ------------switch between colors for Active/Inactive color
    public void setLblColor(JLabel lbl) {
        lbl.setBackground(new Color(0, 150, 62));
    }

    public void resetLblColor(JLabel lbl) {
        lbl.setBackground(new Color(1, 198, 83));
    }

    public static void main(String args[]) throws IOException {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Home().setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        ServerSocket server = new ServerSocket(8000);
        ClientSockets = new Vector<Socket>();

        while (true) {
            Socket client = server.accept();
            Home.AcceptClient acceptClient = new Home.AcceptClient(client);
        }
    }

    static class AcceptClient extends Thread {

        Socket ClientSocket;
        DataInputStream din;
        DataOutputStream dout;

        AcceptClient(Socket client) throws IOException {
            ClientSocket = client;
            din = new DataInputStream(ClientSocket.getInputStream());
            dout = new DataOutputStream(ClientSocket.getOutputStream());

            clientCount++;
            ClientSockets.add(ClientSocket);

            start();

        }

        @Override
        public void run() {

            try {
                while (true) {
                    String msgFromClient = din.readUTF();
                    System.out.println(msgFromClient);

                    Date dNow = new Date();

                    String s[] = msgFromClient.split(":");

                    String name = s[0];
                    int Score = Integer.parseInt(s[1]);
                    String Time = String.format("%tc", dNow);
                    String Pass = s[2];

                    Object[] row = {jTable1.getRowCount(), name, Score, Time, Pass};

                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                    model.addRow(row);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
