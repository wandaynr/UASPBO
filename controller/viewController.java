package Controller;

import view.*;
import model.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class viewController extends JFrame {
    public Connection databaseKoneksi;

    public viewController() {
        try {
            databaseKoneksi = (Connection) koneksi.bukaKoneksiDB();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal terhubung ke database!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private viewController getFrame(String viewName) {
        return switch (viewName) {
            case "dashboard" ->
                new dashboard();
            case "pendaftaranMhs" ->
                new pendaftaranMhs();
            case "pendaftaranProdi" ->
                new pendaftaranProdi();
            case "daftarMhs" ->
                new daftarMhs();
            case "daftarProdi" ->
                new daftarProdi();
            default ->
                null;
        };
    }

    public <T extends viewController> void openFrame(T frame) {
        if (frame == null) {
            JOptionPane.showMessageDialog(this, "Frame tidak ditemukan!", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            frame.setLocationRelativeTo(this);
            frame.afterOpen();
            this.dispose();
            frame.setVisible(true);
        }
    }

    public void openFrame(String viewName) {
        viewController frame = getFrame(viewName);
        openFrame(frame);
    }

    public void afterOpen() {

    }
}
