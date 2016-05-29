/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import DTO.Consulta;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sun.awt.AWTAccessor;

public class Utilitarios {
    JFrame f = new JFrame();
    private ResultSetMetaData rsm;
    
    public void listar_Consulta(Consulta consulta){
    
        for(int i=0;i<consulta.getColumnas().length;i++){
        
            System.out.print(consulta.getColumnas()[i] + "\t");
        }
        System.out.println("");
        for(int i=0;i<consulta.getData().length;i++){
        
            for (int j = 0; j < consulta.getData()[0].length; j++) {
                
                System.out.print(consulta.getData()[i][j] + "\t");
            }
            System.out.println("");
        }
    }
    
    public Consulta obtener_Consulta(ResultSet rs) {
        Consulta consulta = new Consulta();
        String columna[], data[][];
        int rowSize = 0;
        try {
            rs.last();
            rowSize = rs.getRow();
            rs.beforeFirst();
            rsm = rs.getMetaData();
            
            int columnSize = rsm.getColumnCount();
            columna=new String[columnSize];
            for (int i=1;i<=columnSize;i++){
            
                columna[i-1]=rsm.getColumnName(i);
            }
            consulta.setColumnas(columna);
            
            data = new String[rowSize][columnSize];
            int contador_fila=0;
            while(rs.next() && contador_fila < rowSize){
                for(int j=1;j<=columnSize;j++){
                    data[contador_fila][j-1] = rs.getString(j);
                }
                contador_fila++;                    
            }
            consulta.setData(data);
        rs.close();
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
        return consulta;
    }
    
    public void solo_Letras(JTextField jtf){
        jtf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c)){
                    f.getToolkit().beep();
                    e.consume();
                }
            }
        });
    }
    
    public void solo_Numeros(JTextField jtf){
        jtf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    f.getToolkit().beep();
                    e.consume();
                }
            }
        });
    }
    
    public boolean tiene_Acceso(String opcion,String opciones[][]){
        int fila=opciones.length;
        String op;
        for(int i=0;i<fila;i++){
            op=opciones[i][0];
            if(op.equals(opcion)){
                return true;
            }
        }
        
        return false;
    }
    
    public String[][] buscar_RUC(String ruc,String data[][]){
        int columnas=data[0].length;
        int filas=data.length;
        String datos[][] = new String[1][columnas];
        String aux;
        for(int i=0;i<filas;i++){
            aux=data[i][0];
            if(aux.equals(ruc)){
                for(int j=0;j<columnas;j++){
                    datos[0][j]=data[i][j];
                }
                return datos;
            }
        }
        
        return datos;
    }
    
    public String[] Listar_Columna(int columna,String data[][]){

        int filas=data.length;
        String datos[] = new String[filas];
        for(int i=0;i<filas;i++){
            datos[i]=data[i][columna];
        }
        
        return datos;
    }
    
    public String[] Listar_Columna(String col, Consulta consulta){

        int filas=consulta.getData().length;
        String datos[] = new String[filas];
        int columna=buscar_posicion(col, consulta.getColumnas());
        for(int i=0;i<filas;i++){
            datos[i]=consulta.getData()[i][columna];
        }
        
        return datos;
    }
    
    public int nulo_A_Int(String a){
        if("".equals(a)){
            return 0;
        }
        
        return Integer.parseInt(a);
    }
    
    public int buscar_posicion(String dato,String[] vector){
        int aux=-1;
        for(int i = 0;i<vector.length;i++){
            if(dato.equals(vector[i])){
                aux=i;
            }
        }
        
        return aux;
    }
    
}
