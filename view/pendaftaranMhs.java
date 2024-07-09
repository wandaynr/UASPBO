package view;

import Controller.viewController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class pendaftaranMhs extends viewController {

    public pendaftaranMhs() {
        initComponents();
        afterOpen();
        loadProdiData();
    }

    private void loadProdiData() {

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT nama_prodi FROM prodi";
            statement = databaseKoneksi.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String prodiName = resultSet.getString("nama_prodi");
                cmbProdi.addItem(prodiName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getProdiIdByName(String prodiName) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int prodiId = -1;
        try {
            String sql = "SELECT id FROM prodi WHERE nama_prodi = ?";
            statement = databaseKoneksi.prepareStatement(sql);
            statement.setString(1, prodiName);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                prodiId = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return prodiId;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inpTanggalLahir = new javax.swing.JTextField();
        btnTanggal = new javax.swing.JButton();
        inpNama = new javax.swing.JTextField();
        inpNIM = new javax.swing.JTextField();
        cmbJenisKelamin = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        cmbProdi = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(inpTanggalLahir);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nama Mahasiswa");

        jLabel2.setText("NIM");

        jLabel3.setText("Tanggal Lahir");

        jLabel4.setText("Alamat");

        jLabel5.setText("Jenis Kelamin");

        jLabel6.setText("Prodi");

        btnTanggal.setText("...");
        btnTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTanggalActionPerformed(evt);
            }
        });

        cmbJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        cmbProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProdiActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 45)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Pendaftaran Mahasiswa");

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inpTanggalLahir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inpNama)
                            .addComponent(inpNIM)
                            .addComponent(cmbJenisKelamin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(cmbProdi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inpNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inpNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inpTanggalLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTanggal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTanggalActionPerformed
        dateChooser1.showPopup();
    }//GEN-LAST:event_btnTanggalActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        openFrame("dashboard");
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String nim = inpNIM.getText();
        String nama = inpNama.getText();
        String tanggalLahir = inpTanggalLahir.getText();
        String alamat = txtAlamat.getText();
        String jenisKelamin = cmbJenisKelamin.getSelectedItem().toString();
        String prodiName = cmbProdi.getSelectedItem().toString();

        if (nim.isEmpty() || nama.isEmpty() || tanggalLahir.isEmpty() || alamat.isEmpty() || jenisKelamin.isEmpty() || prodiName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int prodiId = getProdiIdByName(prodiName);
        if (prodiId == -1) {
            JOptionPane.showMessageDialog(this, "Prodi tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menyimpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            String sql = "INSERT INTO mahasiswa (nim, nama, tanggal_lahir, alamat, jenis_kelamin, prodi) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = databaseKoneksi.prepareStatement(sql)) {
                statement.setString(1, nim);
                statement.setString(2, nama);
                statement.setString(3, tanggalLahir);
                statement.setString(4, alamat);
                statement.setString(5, jenisKelamin);
                statement.setInt(6, prodiId);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Data mahasiswa berhasil disimpan.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    openFrame("dashboard");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            return;
        }

    }//GEN-LAST:event_btnSimpanActionPerformed

    private void cmbProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProdiActionPerformed

    }//GEN-LAST:event_cmbProdiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTanggal;
    private javax.swing.JComboBox<String> cmbJenisKelamin;
    private javax.swing.JComboBox<String> cmbProdi;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JTextField inpNIM;
    private javax.swing.JTextField inpNama;
    private javax.swing.JTextField inpTanggalLahir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAlamat;
    // End of variables declaration//GEN-END:variables
}
