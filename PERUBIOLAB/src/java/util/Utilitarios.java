/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import dto.Consulta;

/**
 *
 * @author ALDO
 */
public class Utilitarios {
	
    private ResultSetMetaData rsm;
	
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
            
        }
        
        return consulta;
    }
	
    public int nulo_A_Int(String a){
        if("".equals(a)){
            return 0;
        }
        
        return Integer.parseInt(a);
    }
	
    public String[] Listar_Columna(int columna,String data[][]){

        int filas=data.length;
        String datos[] = new String[filas];
        for(int i=0;i<filas;i++){
            datos[i]=data[i][columna];
        }
        
        return datos;
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
