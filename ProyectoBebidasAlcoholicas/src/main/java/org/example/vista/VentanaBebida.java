package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaBebida extends JFrame {
    // Etiquetas
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblMarca;
    private JLabel lblPrecio;
    private JLabel lblVolumen;
    private JLabel lblUrl;
    private JLabel imagenBebida;
    // TsxtField
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtMarca;
    private JTextField txtPrecio;
    private JTextField txtVolumen;
    private JTextField txtUrl;
    //Botones
    private JButton botonAgregar;
    private JButton botonActualizar;
    private JButton btnDelete;
    private JButton btnModificar;
    //Tabla
    private JTable tabla;
    private JScrollPane scroll;
    //Paneles y GridLayout
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    //Etiquetas, TextField del panel 4

    private JLabel lblNombreM;
    private JLabel lblMarcaM;
    private JLabel lblPrecioM;
    private JLabel lblVolumenM;
    private JLabel lblUrlM;
    private JTextField txtNombreM;
    private JTextField txtMarcaM;
    private JTextField txtPrecioM;
    private JTextField txtVolumenM;
    private JTextField txtUrlM;



    public VentanaBebida(String title) throws HeadlessException {
        super(title);
        this.setSize(800, 800);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);

        //Panel 1
        panel1= new JPanel(new FlowLayout());
        panel1.setBackground(new Color(133, 72, 201, 247));
        lblId = new JLabel("Id: ");
        lblNombre = new JLabel("Nombre");
        lblMarca = new JLabel("Marca");
        lblPrecio = new JLabel("Precio");
        lblVolumen = new JLabel("Volumen (ml)");
        lblUrl = new JLabel("Foto:");
        txtId = new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtNombre = new JTextField(15);
        txtMarca = new JTextField(15);
        txtPrecio = new JTextField(5);
        txtVolumen = new JTextField(7);
        txtUrl = new JTextField(30);
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblNombre);
        panel1.add(txtNombre);
        panel1.add(lblMarca);
        panel1.add(txtMarca);
        panel1.add(lblPrecio);
        panel1.add(txtPrecio);
        panel1.add(lblVolumen);
        panel1.add(txtVolumen);
        panel1.add(lblUrl);
        panel1.add(txtUrl);
        botonAgregar = new JButton("Agregar");
        panel1.add(botonAgregar);



        //Panel 2
        panel2= new JPanel(new FlowLayout());
        panel2.setBackground(new Color(84, 96, 159, 247));
        botonActualizar = new JButton("Actualizar tabla");
        panel2.add(botonActualizar);
        tabla = new JTable();
        scroll = new JScrollPane(tabla);
        panel2.add(scroll);


        //Panel 3
        panel3= new JPanel(new FlowLayout());
        panel3.setBackground(new Color(72, 182, 201, 247));
        imagenBebida = new JLabel("...");
        panel3.add(imagenBebida);


        //Panel 4
        panel4= new JPanel(new FlowLayout());
        panel4.setBackground(new Color(105, 189, 71, 247));
        btnDelete = new JButton("Borrar");
        lblNombreM = new JLabel("Nombre:");
        lblMarcaM = new JLabel("Marca:");
        lblPrecioM = new JLabel("Precio:");
        lblVolumenM = new JLabel("Volumen (ml):");
        lblUrlM = new JLabel("URL:");
        txtNombreM = new JTextField(15);
        txtMarcaM = new JTextField(15);
        txtPrecioM = new JTextField(5);
        txtVolumenM = new JTextField(7);
        txtUrlM = new JTextField(30);
        btnModificar = new JButton("Subir cambios");
        panel4.add(btnDelete);
        panel4.add(lblNombreM);
        panel4.add(txtNombreM);
        panel4.add(lblMarcaM);
        panel4.add(txtMarcaM);
        panel4.add(lblPrecioM);
        panel4.add(txtPrecioM);
        panel4.add(lblVolumenM);
        panel4.add(txtVolumenM);
        panel4.add(lblUrlM);
        panel4.add(txtUrlM);
        panel4.add(btnModificar);




        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JLabel getLblMarca() {
        return lblMarca;
    }

    public void setLblMarca(JLabel lblMarca) {
        this.lblMarca = lblMarca;
    }

    public JTextField getTxtMarca() {
        return txtMarca;
    }

    public void setTxtMarca(JTextField txtMarca) {
        this.txtMarca = txtMarca;
    }

    public JLabel getLblPrecio() {
        return lblPrecio;
    }

    public void setLblPrecio(JLabel lblPrecio) {
        this.lblPrecio = lblPrecio;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    public void setTxtPrecio(JTextField txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    public JLabel getLblVolumen() {
        return lblVolumen;
    }

    public void setLblVolumen(JLabel lblVolumen) {
        this.lblVolumen = lblVolumen;
    }

    public JTextField getTxtVolumen() {
        return txtVolumen;
    }

    public void setTxtVolumen(JTextField txtVolumen) {
        this.txtVolumen = txtVolumen;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBotonAgregar() {
        return botonAgregar;
    }

    public void setBotonAgregar(JButton botonAgregar) {
        this.botonAgregar = botonAgregar;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getImagenBebida() {
        return imagenBebida;
    }

    public void setImagenBebida(JLabel imagen) {
        this.imagenBebida = imagen;
    }

    public JButton getBotonActualizar() {
        return botonActualizar;
    }

    public void setBotonActualizar(JButton botonActualizar) {
        this.botonActualizar = botonActualizar;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JLabel getLblNombreM() {
        return lblNombreM;
    }

    public void setLblNombreM(JLabel lblNombreM) {
        this.lblNombreM = lblNombreM;
    }

    public JLabel getLblMarcaM() {
        return lblMarcaM;
    }

    public void setLblMarcaM(JLabel lblMarcaM) {
        this.lblMarcaM = lblMarcaM;
    }

    public JLabel getLblPrecioM() {
        return lblPrecioM;
    }

    public void setLblPrecioM(JLabel lblPrecioM) {
        this.lblPrecioM = lblPrecioM;
    }

    public JLabel getLblVolumenM() {
        return lblVolumenM;
    }

    public void setLblVolumenM(JLabel lblVolumenM) {
        this.lblVolumenM = lblVolumenM;
    }

    public JLabel getLblUrlM() {
        return lblUrlM;
    }

    public void setLblUrlM(JLabel lblUrlM) {
        this.lblUrlM = lblUrlM;
    }

    public JTextField getTxtNombreM() {
        return txtNombreM;
    }

    public void setTxtNombreM(JTextField txtNombreM) {
        this.txtNombreM = txtNombreM;
    }

    public JTextField getTxtMarcaM() {
        return txtMarcaM;
    }

    public void setTxtMarcaM(JTextField txtMarcaM) {
        this.txtMarcaM = txtMarcaM;
    }

    public JTextField getTxtPrecioM() {
        return txtPrecioM;
    }

    public void setTxtPrecioM(JTextField txtPrecioM) {
        this.txtPrecioM = txtPrecioM;
    }

    public JTextField getTxtVolumenM() {
        return txtVolumenM;
    }

    public void setTxtVolumenM(JTextField txtVolumenM) {
        this.txtVolumenM = txtVolumenM;
    }

    public JTextField getTxtUrlM() {
        return txtUrlM;
    }

    public void setTxtUrlM(JTextField txtUrlM) {
        this.txtUrlM = txtUrlM;
    }

    public void Limpiar(){
        txtNombre.setText("");
        txtMarca.setText("");
        txtPrecio.setText("");
        txtVolumen.setText("");
        txtUrl.setText("");
    }
    public void Limpiar2(){
        txtNombreM.setText("");
        txtMarcaM.setText("");
        txtPrecioM.setText("");
        txtVolumenM.setText("");
        txtUrlM.setText("");
    }
}

