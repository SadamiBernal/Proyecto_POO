package org.example.controlador;

import org.example.modelo.BebidasAlcoholicas;
import org.example.modelo.ModeloTablaBebidas;
import org.example.vista.VentanaBebida;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorBebidas extends MouseAdapter {
    private VentanaBebida view;
    private ModeloTablaBebidas modelo;

    public ControladorBebidas(VentanaBebida view) {
        this.view = view;
        modelo = new ModeloTablaBebidas();
        this.view.getTabla().setModel(modelo);
        this.view.getTabla().addMouseListener(this);
        this.view.getBotonActualizar().addMouseListener(this);
        this.view.getBotonAgregar().addMouseListener(this);
        this.view.getBtnDelete().addMouseListener(this);
        this.view.getBtnModificar().addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Evento para actualizar la tabla
        if (e.getSource() == this.view.getBotonActualizar()){

            modelo.cargarDatos();
            this.view.getTabla().setModel(modelo);
            //this.view.getTblLibro().updateUI();
        }
        //Evento del boton agregar
        if (e.getSource() == view.getBotonAgregar()){
            BebidasAlcoholicas bebida = new BebidasAlcoholicas();
            bebida.setId(0);
            bebida.setNombre(this.view.getTxtNombre().getText());
            bebida.setMarca(this.view.getTxtMarca().getText());
            bebida.setPrecio(Integer.parseInt(this.view.getTxtPrecio().getText()));
            bebida.setVolumen(Integer.parseInt(this.view.getTxtVolumen().getText()));
            bebida.setUrl(this.view.getTxtUrl().getText());
            if(modelo.agregarBebida(bebida)){
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTabla().updateUI();
            }else{
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos. Por favor revise su conexión", "Error al insertar", JOptionPane.ERROR_MESSAGE);
            }
            this.view.Limpiar();

        }
        //Evento para mostrar imagen de la tabla
        if (e.getSource() == view.getTabla()) {
            System.out.println("Evento sobre la tabla");
            int index = this.view.getTabla().getSelectedRow();
            BebidasAlcoholicas tmp = modelo.getBebidaAtIndex(index);
            try {
                this.view.getImagenBebida().setIcon(tmp.getImagen());
                this.view.getImagenBebida().setText("");
            }catch (MalformedURLException mfue){
                System.out.println(e.toString());
            }
        }
        //Evento del boton borrar
        if (e.getSource() == this.view.getBtnDelete()) {
            int index = this.view.getTabla().getSelectedRow();
            BebidasAlcoholicas tmp = modelo.getBebidaAtIndex(index);
            String idx = String.valueOf(tmp.getId());
            int respuesta = JOptionPane.showConfirmDialog(view, "¿Estas seguro de borrar el registro?", "Ventana de confimaicon", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_NO_OPTION) {
                if (modelo.borrarBebida(idx)) {
                    JOptionPane.showMessageDialog(view, "Se ha borrado correctamente", "Aviso",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(view, "No se pudo borrar el resgistro", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(view, "No se ha borrado nada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        //Evento para modificar elemento de la tabla
        if (e.getSource() == this.view.getBtnModificar()){
            int index = this.view.getTabla().getSelectedRow();
            BebidasAlcoholicas tmp = modelo.getBebidaAtIndex(index);
            tmp.setNombre(this.view.getTxtNombreM().getText());
            tmp.setMarca(this.view.getTxtMarcaM().getText());
            tmp.setPrecio(Integer.parseInt(this.view.getTxtPrecioM().getText()));
            tmp.setVolumen(Integer.parseInt(this.view.getTxtVolumenM().getText()));
            tmp.setUrl(this.view.getTxtUrlM().getText());
            if (modelo.modificarBebida(tmp)){
                JOptionPane.showMessageDialog(view,"Datos actualizados","Actualizacion",JOptionPane.INFORMATION_MESSAGE);
            }
            this.view.Limpiar2();
        }
    }
}
