package view;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.koneksi;

public class editMhs extends javax.swing.JFrame {

    private String selectedNim;
    private daftarMhs parent;
    private Connection databaseKoneksi;

    public editMhs(String selectedNim, daftarMhs parent) {
        this.selectedNim = selectedNim;
        this.parent = parent;
        initComponents();
        try {
            databaseKoneksi = (Connection) koneksi.bukaKoneksiDB(); // Iniisialisasi koneksi di sini
            loadStudentDetails(); // Panggil loadStudentDetails setelah inisialisasi koneksi sukses
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal terhubung ke database!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        loadProdiData();
    }

    private void loadStudentDetails() {
        String sql = "SELECT m.nama, m.nim, p.nama_prodi, m.tanggal_lahir, m.jenis_kelamin, m.alamat "
                + "FROM mahasiswa m JOIN prodi p ON m.prodi = p.id WHERE m.nim = ?";

        try (PreparedStatement statement = databaseKoneksi.prepareStatement(sql)) {
            statement.setString(1, selectedNim);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    inpNama.setText(resultSet.getString("nama"));
                    inpNIM.setText(resultSet.getString("nim"));
                    cmbProdi.setSelectedItem(resultSet.getString("nama_prodi"));
                    inpTanggalLahir.setText(resultSet.getString("tanggal_lahir"));
                    cmbJenisKelamin.setSelectedItem(resultSet.getString("jenis_kelamin"));
                    txtAlamat.setText(resultSet.getString("alamat"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jLabel3 = new javax.swing.JLabel();
        cmbProdi = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        inpTanggalLahir = new javax.swing.JTextField();
        btnTanggal = new javax.swing.JButton();
        inpNama = new javax.swing.JTextField();
        inpNIM = new javax.swing.JTextField();
        cmbJenisKelamin = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Tanggal Lahir");

        cmbProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProdiActionPerformed(evt);
            }
        });

        jLabel4.setText("Alamat");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 45)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Edit Mahasiswa");

        jLabel5.setText("Jenis Kelamin");

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jLabel6.setText("Prodi");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnTanggal.setText("...");
        btnTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTanggalActionPerformed(evt);
            }
        });

        cmbJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        jLabel1.setText("Nama Mahasiswa");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        jLabel2.setText("NIM");

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
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProdiActionPerformed

    }//GEN-LAST:event_cmbProdiActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
        parent.setVisible(true);
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
            String sql = "UPDATE mahasiswa SET nama = ?, prodi = ?, tanggal_lahir = ?, jenis_kelamin = ?, alamat = ? WHERE nim = ?";

            try (PreparedStatement statement = databaseKoneksi.prepareStatement(sql)) {
                statement.setString(1, nama);
                statement.setInt(2, prodiId);
                statement.setString(3, tanggalLahir);
                statement.setString(4, jenisKelamin);
                statement.setString(5, alamat);
                statement.setString(6, nim);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Data mahasiswa berhasil diperbarui.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    parent.afterOpen();
                    this.dispose();
                    parent.setVisible(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTanggalActionPerformed
        dateChooser1.showPopup();
    }//GEN-LAST:event_btnTanggalActionPerformed

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
