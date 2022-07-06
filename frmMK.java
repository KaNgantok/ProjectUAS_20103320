package promhs;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class frmMK extends javax.swing.JPanel {
    private DefaultTableModel model;
    static ResultSet rs;
    static Statement stmt;
    dbKoneksi cnn = new dbKoneksi();
    loadIMG img = new loadIMG();
    private String sql;

    /**
     * Creates new form frmMK
     */
    public frmMK() {
        initComponents();
        this.initTable();
        this.getdata();
    }
    
    private void initTable(){
        model = new DefaultTableModel();
        tMK.setModel(model);
        model.addColumn("idmk");
        model.addColumn("NAMAMK");
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
        String sql = "Select idmk, NAMAMK FROM mk;";
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            this.tampildata(sql);
            while(this.rs.next()){
                Object[] obj = new Object[2];
                obj[0] = this.rs.getString("idmk");
                obj[1] = this.rs.getString("NAMAMK");
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
       String idmk = this.txID.getText();
       String NAMAMK = this.txNAMA.getName();
       String SQLUpdate = "INSERT INTO mk SET NAMAMK = '"+NAMAMK+"' WHERE idmk = '"+idmk+"';";
       if(this.updatedata(sql)){
           JOptionPane.showMessageDialog(null,"Data Berhasil Ditambahkan");
       }
    }
    
    private void updatedataform(){
       String idmk = this.txID.getText();
       String NAMAMK = this.txNAMA.getName();
       String sql = "UPDATE mk SET NAMAMK = '"+NAMAMK+"' WHERE idmk = '"+idmk+"';";
       if(this.updatedata(sql)){
           JOptionPane.showMessageDialog(null,"Data Matakuliah"+NAMAMK+"("+idmk+")\ntelah Di Update");
       }
       this.getdata();
    }
    
    private void Deletedata(){
        String idmk = this.txID.getText();
        String NAMAMK = this.txNAMA.getText();
        
        String sql = "DELETE FROM mk WHERE idmk = '"+idmk+"';";
        
        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah Anda Ingin Menghapus Data dari:\n"+NAMAMK+"("+idmk+")\n","Penghapusan Data",JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION){
        if(this.updatedata(sql)){
           JOptionPane.showMessageDialog(null,"Data Matakuliah"+NAMAMK+"("+idmk+")\ntelah Di hapus");
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
        this.txID.setText("");
        this.txNAMA.setText("");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMK = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        imgphoto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txNAMA = new javax.swing.JTextField();
        cmdStore = new javax.swing.JButton();
        cmdUpdate = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        cmdBatal = new javax.swing.JButton();
        cmdBaru = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("LIST DATA MATA KULIAH");

        tMK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tMK);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("DETAIL");

        jLabel3.setText("ID Matakuliah");

        jLabel4.setText("Nama Matakuliah");

        cmdStore.setText("Simpan Data");
        cmdStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdStoreActionPerformed(evt);
            }
        });

        cmdUpdate.setText("Update Data");
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

        cmdClose.setText("Tutup Form");
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        cmdBatal.setText("Batal");
        cmdBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBatalActionPerformed(evt);
            }
        });

        cmdBaru.setText("Data Baru");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imgphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txID)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(txNAMA))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdStore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                        .addComponent(cmdBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdClose)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdBaru)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdBaru))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdStore)
                    .addComponent(cmdUpdate)
                    .addComponent(cmdDelete)
                    .addComponent(cmdClose)
                    .addComponent(cmdBatal))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBatalActionPerformed
        this.navbar(false);
        this.cmdBatal.setVisible(false);
        this.cmdClose.setEnabled(true);
    }//GEN-LAST:event_cmdBatalActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        this.Deletedata();
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
       String idmk = this.txID.getText();
       String NAMAMK = this.txNAMA.getName();
       String SQLUpdate = "UPDATE mk SET NAMAMK = '"+NAMAMK+"' WHERE idmk = '"+idmk+"';";
       if(this.updatedata(sql)){
             
       }
    }//GEN-LAST:event_cmdUpdateActionPerformed

    private void cmdStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdStoreActionPerformed
       this.storedata();
    }//GEN-LAST:event_cmdStoreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdBaru;
    private javax.swing.JButton cmdBatal;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdStore;
    private javax.swing.JButton cmdUpdate;
    private javax.swing.JTextField imgphoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tMK;
    private javax.swing.JTextField txID;
    private javax.swing.JTextField txNAMA;
    // End of variables declaration//GEN-END:variables

    boolean isClosed() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
