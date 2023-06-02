package org.example.modelo;

import org.example.modelo.persistencia.BebidasDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaBebidas implements TableModel {
    private ArrayList<BebidasAlcoholicas> datos;
    private BebidasDAO ldao;
    public static final int COLS = 6;

    public ModeloTablaBebidas() {
        ldao = new BebidasDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaBebidas(ArrayList<BebidasAlcoholicas> datos) {

        this.datos = datos;
        ldao = new BebidasDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String nombreCol= "";
        switch (columnIndex){
            case 0:
                nombreCol = "id";
                break;
            case 1:
                nombreCol = "nombre";
                break;
            case 2:
                nombreCol = "marca";
                break;
            case 3:
                nombreCol = "precio";
                break;
            case 4:
                nombreCol = "volumen";
                break;
            case 5:
                nombreCol = "Foto (URL)";
                break;
            default:
                nombreCol = "";

        }
        return nombreCol;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return Integer.class;
            case 5:
                return String.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BebidasAlcoholicas tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return  tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getMarca();
            case 3:
                return "$ "+tmp.getPrecio();
            case 4:
                return tmp.getVolumen()+"ml";
            case 5:
                return tmp.getUrl();


        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                //datos.get(rowIndex).setId((int) aValue);
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setMarca((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setPrecio((int) aValue);
                break;
            case 4:
                datos.get(rowIndex).setVolumen((int) aValue);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String) aValue);
                break;


        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public BebidasAlcoholicas getBebidaAtIndex(int index){

        return datos.get(index);
    }
    public void cargarDatos(){
        try{
            datos= ldao.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }

    }
    public boolean agregarBebida(BebidasAlcoholicas bebida){
        boolean resultado = false;
        try{
            if(ldao.insertar(bebida)){
                datos.add(bebida);
                resultado= true;

            }  else{
                resultado = false;
            }
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
    public boolean borrarBebida(String index) {
        boolean resultado = false;
        try {
            if (ldao.delete(index)) {
                resultado = true;

            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
    public boolean modificarBebida(BebidasAlcoholicas bebida) {
        boolean resultado = false;
        try {
            if (ldao.update(bebida)) {
                datos.add(bebida);
                resultado = true;

            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
}
