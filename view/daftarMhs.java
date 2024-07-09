package view;

import Controller.viewController;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class daftarMhs extends viewController {

    public daftarMhs() {
        initComponents();
        addTableListener();
        afterOpen();
        loadData();
        btnHapus.setEnabled(false);
        btnEdit.setEnabled(false);
    }

    @Override
    public void afterOpen() {
        loadData();
    }

    private void loadData() {
        DefaultTableModel model = (DefaultTableModel) tblDaftarMahasiswa.getModel();
        model.setRowCount(0);

        String sql = "SELECT m.nama, m.nim, p.nama_prodi, m.tanggal_lahir, m.jenis_kelamin, m.alamat "
                + "FROM mahasiswa m JOIN prodi p ON m.prodi = p.id";

        try (PreparedStatement statement = databaseKoneksi.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nama = resultSet.getString("nama");
                String nim = resultSet.getString("nim");
                String prodi = resultSet.getString("nama_prodi");
                String tanggalLahir = resultSet.getString("tanggal_lahir");
                String jenisKelamin = resultSet.getString("jenis_kelamin");
                String alamat = resultSet.getString("alamat");

                model.addRow(new Object[]{nama, nim, prodi, tanggalLahir, jenisKelamin, alamat});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addTableListener() {
        tblDaftarMahasiswa.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                btnHapus.setEnabled(tblDaftarMahasiswa.getSelectedRow() != -1);
                btnEdit.setEnabled(tblDaftarMahasiswa.getSelectedRow() != -1);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDaftarMahasiswa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        inpCariNIM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCari = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblDaftarMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Mahasiswa", "NIM", "Program Studi", "Tanggal Lahir", "Jenis Kelamin", "Alamat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDaftarMahasiswa.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDaftarMahasiswa);
        if (tblDaftarMahasiswa.getColumnModel().getColumnCount() > 0) {
            tblDaftarMahasiswa.getColumnModel().getColumn(0).setResizable(false);
            tblDaftarMahasiswa.getColumnModel().getColumn(1).setResizable(false);
            tblDaftarMahasiswa.getColumnModel().getColumn(2).setResizable(false);
            tblDaftarMahasiswa.getColumnModel().getColumn(3).setResizable(false);
            tblDaftarMahasiswa.getColumnModel().getColumn(4).setResizable(false);
            tblDaftarMahasiswa.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Daftar Mahasiswa");

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jLabel2.setText("Cari berdasarkan NIM");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inpCariNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inpCariNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKembali)
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        openFrame("dashboard");
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String nim = inpCariNIM.getText();
        if (nim.isEmpty()) {
            loadData();
        }
        DefaultTableModel model = (DefaultTableModel) tblDaftarMahasiswa.getModel();
        model.setRowCount(0);

        String sql = "SELECT m.nama, m.nim, p.nama_prodi, m.tanggal_lahir, m.jenis_kelamin, m.alamat "
                + "FROM mahasiswa m JOIN prodi p ON m.prodi = p.id WHERE m.nim LIKE ?";

        try (PreparedStatement statement = databaseKoneksi.prepareStatement(sql)) {
            statement.setString(1, "%" + nim + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String nama = resultSet.getString("nama");
                    String nimValue = resultSet.getString("nim");
                    String prodi = resultSet.getString("nama_prodi");
                    String tanggalLahir = resultSet.getString("tanggal_lahir");
                    String jenisKelamin = resultSet.getString("jenis_kelamin");
                    String alamat = resultSet.getString("alamat");

                    model.addRow(new Object[]{nama, nimValue, prodi, tanggalLahir, jenisKelamin, alamat});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int selectedRow = tblDaftarMahasiswa.getSelectedRow();
        if (selectedRow != -1) {
            String selectedNim = (String) tblDaftarMahasiswa.getValueAt(selectedRow, 1);

            int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus mahasiswa ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM mahasiswa WHERE nim = ?";

                try (PreparedStatement statement = databaseKoneksi.prepareStatement(sql)) {
                    statement.setString(1, selectedNim);
                    int rowsDeleted = statement.executeUpdate();

                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(this, "Mahasiswa berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        loadData(); // Refresh table data
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih mahasiswa yang akan dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int selectedRow = tblDaftarMahasiswa.getSelectedRow();
        if (selectedRow != -1) {
            String selectedNim = (String) tblDaftarMahasiswa.getValueAt(selectedRow, 1);
            new editMhs(selectedNim, this).setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih mahasiswa yang akan diedit.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JTextField inpCariNIM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDaftarMahasiswa;
    // End of variables declaration//GEN-END:variables
}
