import Catatan.Catatan;
import Catatan.CatatanApp;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class CrudApp extends JFrame
{
    private DefaultListModel<String> listModel;
    private JList<String> catatanJList;
    private JTextField judulTextField;
    private JTextArea isiTextArea;
    private JTextField tanggalTextField;

    private CatatanApp catatanApp;

    public CrudApp()
    {
        catatanApp = new CatatanApp();

        setTitle("CRUD App");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        getContentPane().setBackground(new Color(25, 25, 112)); 


        listModel = new DefaultListModel<>();
        catatanJList = new JList<>(listModel);
        catatanJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        catatanJList.addListSelectionListener(e -> tampilkanCatatan());

        tanggalTextField = new JTextField();
        judulTextField = new JTextField();
        isiTextArea = new JTextArea();
        

        JButton tambahButton = new JButton("Tambah Catatan");
        tambahButton.addActionListener(e -> tambahCatatan());

        JButton hapusButton = new JButton("Hapus Catatan");
        hapusButton.addActionListener(e -> hapusCatatan());

        setLayout(new BorderLayout());

       JPanel panelKiri = new JPanel();
        //panelKiri.setLayout(new GridLayout(3, 1));
        panelKiri.setLayout(new BoxLayout(panelKiri, BoxLayout.Y_AXIS));
        panelKiri.add(new JScrollPane(catatanJList), BorderLayout.CENTER);
        panelKiri.add(hapusButton, BorderLayout.SOUTH);
        panelKiri.setBackground(new Color(169, 169, 169));
        panelKiri.setForeground(new Color(0, 0, 0));

        JPanel panelKanan = new JPanel();
        panelKanan.setLayout(new GridLayout(8, 1));
        panelKanan.add(new JLabel("Judul: "));
        panelKanan.add(judulTextField);
        panelKanan.add(new JLabel("Tanggal: "));
        panelKanan.add(tanggalTextField);
        panelKanan.add(new JLabel("Isi: "));
        panelKanan.add(isiTextArea);
        panelKanan.add(tambahButton);
        panelKanan.setBackground(new Color(169, 169, 169));


        add(panelKiri, BorderLayout.WEST);
        add(panelKanan, BorderLayout.CENTER);
    }

    private void tampilkanCatatan()
    {
        int index = catatanJList.getSelectedIndex();
        if (index != -1)
        {
            Catatan catatan = catatanApp.getCatatanList().get(index);
            judulTextField.setText(catatan.getJudul());
            tanggalTextField.setText(catatan.getTanggal());
            isiTextArea.setText(catatan.getIsi());
        }
    }

    private void tambahCatatan()
    {
        String judul = judulTextField.getText();
        String tanggal = tanggalTextField.getText();
        String isi = isiTextArea.getText();
        

        if(!judul.isEmpty() && !tanggal.isEmpty() && !isi.isEmpty())
        {
            Catatan catatanBaru = new Catatan(judul, tanggal, isi);
            catatanApp.tambahCatatan(catatanBaru);
            refreshList();
            resetForm();
            

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Judul, Isi, dan Tanggal pada catatan tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void hapusCatatan()
    {
        int index = catatanJList.getSelectedIndex();
        if(index != -1)
        {
            catatanApp.hapusCatatan(index);
            refreshList();
            resetForm();
        }
    }

    private void refreshList()
    {
        listModel.removeAllElements();
        for(Catatan catatan : catatanApp.getCatatanList())
        {
            listModel.addElement(catatan.getJudul());
        }
    }

    private void resetForm()
    {
        judulTextField.setText("");
        tanggalTextField.setText("");
        isiTextArea.setText("");
        catatanJList.clearSelection();
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->{
            CrudApp aplikasi = new CrudApp();
            aplikasi.setVisible(true);
        });
    }
}