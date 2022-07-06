package promhs;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class frmhs extends javax.swing.JInternalFrame {
    private DefaultTableModel model;
    static ResultSet rs;
    static Statement stmt;
    dbKoneksi cnn = new dbKoneksi();
    loadIMG img = new loadIMG();
    private String sql;
    
    /**
     * Creates new form frmhs
     */
    public frmhs() {
        initComponents();
        this.initTable();
        this.getdata();
    }
    
    private void initTable(){
        model = new DefaultTableModel();
        tMHS.setModel(model);
        model.addColumn("NIM");
        model.addColumn("Nama Mahasiswa");
        model.addColumn("Tgl Lahir");
        model.addColumn("Jurusan");
        model.addColumn("JenisKelamin");
    }
    private void tampildata(String sql){
        try{
            Statement stmt = cnn.koneksi().createStatement();
            this.rs = stmt.executeQuery(sql);
        }catch(Exception e){
            System.out.println("Terjadi Kendala pada query");
        }
    }
    private void getdata(){
        String sql = "Select NIM, NAMA, TGLLAHIR, JURUSAN, JK FROM mhs;";
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            this.tampildata(sql);
            while(this.rs.next()){
                Object[] obj = new Object[5];
                obj[0] = this.rs.getString("NIM");
                obj[1] = this.rs.getString("NAMA");
                obj[2] = this.rs.getString("TGLLAHIR");
                obj[3] = this.rs.getString("JURUSAN");
                String txJK = this.rs.getString("JK");
                if(txJK.equals("L")){
                    obj[4] = "Laki-Laki";
                }else{
                    obj[4] = "Perempuan";
                }
                model.addRow(obj);
            }
        }catch(Exception e){
        }
    }
    
    private boolean updatedata (String sql){
        boolean hsl = false;
        try{
            Statement stmt = cnn.koneksi().createStatement();
            stmt.executeUpdate(sql);
            hsl = true;
        }catch(Exception e){
            System.out.println("terjadi kendala pada query");
            JOptionPane.showMessageDialog(null,"terjadi kendala pada proses Store/Update Data");
        }
        return hsl;
    }
    
    private void storedata(){
       String NIM = this.txNIM.getText();
       String NAMA = this.txNAMA.getName();
       String TGLLAHIR = this.txTGL.getText();
       String JURUSAN = this.txJUR.getSelectedItem().toString();
       String JK = "L";
       if(this.txJKP.isSelected()){
           JK = "P";
       }
       String SQLUpdate = "INSERT INTO mhs SET NAMA = '"+NAMA+"',JURUSAN ='"+JURUSAN+"',JK = '"+JK+"',TGLLAHIR = '"+TGLLAHIR+"' WHERE NIM = '"+NIM+"';";
       if(this.updatedata(sql)){
           JOptionPane.showMessageDialog(null,"Data Berhasil Ditambahkan");
       }
    }
    
    private void updatedataform(){
       String NIM = this.txNIM.getText();
       String NAMA = this.txNAMA.getName();
       String TGLLAHIR = this.txTGL.getText();
       String JURUSAN = this.txJUR.getSelectedItem().toString();
       String JK = "L";
       if(this.txJKP.isSelected()){
           JK = "P";
       }
       TGLLAHIR = this.txTGL.getText();
       String sql = "UPDATE mhs SET NAMA = '"+NAMA+"',JURUSAN ='"+JURUSAN+"',JK = '"+JK+"',TGLLAHIR = '"+TGLLAHIR+"' WHERE NIM = '"+NIM+"';";
       if(this.updatedata(sql)){
           JOptionPane.showMessageDialog(null,"Data mahasiswa"+NAMA+"("+NIM+")\ntelah Di Update");
       }
       this.getdata();
    }
    
    private void Deletedata(){
        String NIM = this.txNIM.getText();
        String NAMA = this.txNAMA.getText();
        
        String sql = "DELETE FROM mhs WHERE NIM = '"+NIM+"';";
        
        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah Anda Ingin Menghapus Data dari:\n"+NAMA+"("+NIM+")\n","Penghapusan Data",JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION){
        if(this.updatedata(sql)){
           JOptionPane.showMessageDialog(null,"Data mahasiswa"+NAMA+"("+NIM+")\ntelah Di hapus");
       }
       this.getdata();
        }
        
    }
    
    private void navbar(Boolean tf){
        this.cmdStore.setEnabled(tf);
        this.cmdUpdate.setEnabled(tf);
        this.cmdDelete.setEnabled(tf);
        this.cmdClose.setEnabled(tf);
    }
    
    private void clearform(){
        this.txNIM.setText("");
        this.txNAMA.setText("");
        this.txTGL.setText("");
        this.txJKL.setSelected(false);
        this.txJKP.setSelected(false);
        this.txJUR.setSelectedIndex(0);
        this.navbar(false);
        this.cmdStore.setEnabled(true);
        this.cmdBatal.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cmdBaru = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMHS = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lbCURD = new javax.swing.JLabel();
        imgphoto = new javax.swing.JLabel();
        txNIM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txNAMA = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txTGL = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txJKL = new javax.swing.JRadioButton();
        txJKP = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txJUR = new javax.swing.JComboBox<>();
        cmdStore = new javax.swing.JButton();
        cmdUpdate = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        cmdBatal = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("List Data Mahasiswa");

        cmdBaru.setText("Data Baru");
        cmdBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBaruActionPerformed(evt);
            }
        });

        tMHS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tMHS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tMHSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tMHS);

        lbCURD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbCURD.setText("Detail");
        lbCURD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCURDMouseClicked(evt);
            }
        });

        imgphoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gambar01.jpg"))); // NOI18N

        jLabel4.setText("NIM");

        jLabel5.setText("Nama Mahasiswa");

        jLabel6.setText("Tgl Lahir");

        jLabel7.setText("Jenis Kelamin");

        buttonGroup1.add(txJKL);
        txJKL.setText("Laki-Laki");

        buttonGroup1.add(txJKP);
        txJKP.setText("Perempuan");

        jLabel8.setText("Jurusan");

        txJUR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jurusan", "MTI", "SK", "KAB" }));

        cmdStore.setText("Simpan Data");
        cmdStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdStoreActionPerformed(evt);
            }
        });

        cmdUpdate.setText("Update Data");
        cmdUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdUpdateMouseClicked(evt);
            }
        });
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });

        cmdDelete.setText("Hapus Data");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        cmdBatal.setText("Batal");
        cmdBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBatalActionPerformed(evt);
            }
        });

        cmdClose.setText("Tutup Form");
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCURD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imgphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(txNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(txTGL))))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txJKL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txJKP))
                                    .addComponent(jLabel8)
                                    .addComponent(txJUR, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdStore)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdBatal)
                                .addGap(39, 39, 39)
                                .addComponent(cmdClose)))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmdBaru))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCURD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txTGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txJKL)
                            .addComponent(txJKP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txJUR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imgphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdStore)
                    .addComponent(cmdUpdate)
                    .addComponent(cmdDelete)
                    .addComponent(cmdBatal)
                    .addComponent(cmdClose))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void tMHSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMHSMouseClicked
        this.txNIM.setText( model.getValueAt(tMHS.getSelectedRow(), 0).toString());
        this.txNAMA.setText( model.getValueAt(tMHS.getSelectedRow(), 1).toString());
        this.txTGL.setText( model.getValueAt(tMHS.getSelectedRow(), 2).toString());
        this.txJUR.setSelectedItem(model.getValueAt(tMHS.getSelectedRow(), 3).toString());
        String txJK = model.getValueAt(tMHS.getSelectedRow(), 4).toString();
        if(txJK.equals("Perempuan")){
            this.txJKP.setSelected(true);
        }else{
            this.txJKL.setSelected(true);
        }
    }//GEN-LAST:event_tMHSMouseClicked

    private void lbCURDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCURDMouseClicked
        
    }//GEN-LAST:event_lbCURDMouseClicked

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
       String NIM = this.txNIM.getText();
       String NAMA = this.txNAMA.getName();
       String TGLLAHIR = this.txTGL.getText();
       String JURUSAN = this.txJUR.getSelectedItem().toString();
       String JK = "L";
       if(this.txJKP.isSelected()){
           JK = "P";
       }
       String SQLUpdate = "UPDATE mhs SET NAMA = '"+NAMA+"',JURUSAN ='"+JURUSAN+"',JK = '"+JK+"',TGLLAHIR = '"+TGLLAHIR+"' WHERE NIM = '"+NIM+"';";
       if(this.updatedata(sql)){
             
       }
    }//GEN-LAST:event_cmdUpdateActionPerformed

    private void cmdBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBaruActionPerformed
        
    }//GEN-LAST:event_cmdBaruActionPerformed

    private void cmdUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdUpdateMouseClicked

    private void cmdBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBatalActionPerformed
        this.navbar(false);
        this.cmdBatal.setVisible(false);
        this.cmdClose.setEnabled(true);
    }//GEN-LAST:event_cmdBatalActionPerformed

    private void cmdStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdStoreActionPerformed
        this.storedata();
    }//GEN-LAST:event_cmdStoreActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
       this.Deletedata();
    }//GEN-LAST:event_cmdDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cmdBaru;
    private javax.swing.JButton cmdBatal;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdStore;
    private javax.swing.JButton cmdUpdate;
    private javax.swing.JLabel imgphoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCURD;
    private javax.swing.JTable tMHS;
    private javax.swing.JRadioButton txJKL;
    private javax.swing.JRadioButton txJKP;
    private javax.swing.JComboBox<String> txJUR;
    private javax.swing.JTextField txNAMA;
    private javax.swing.JTextField txNIM;
    private javax.swing.JTextField txTGL;
    // End of variables declaration//GEN-END:variables
}
