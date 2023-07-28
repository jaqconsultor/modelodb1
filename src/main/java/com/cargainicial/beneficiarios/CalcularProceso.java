package com.cargainicial.beneficiarios;

 
import org.openxava.calculators.*; // Para usar 'ICalculator'

public class CalcularProceso implements ICalculator {
 
    public Object calculate() throws Exception {
    	int numero;
    	numero = 1;
 /*
    	        Connection cn = null;

    	        DatosDeConeccion dc = new DatosDeConeccion();
    	        
    	        try {
    	            // Carga el driver de oracle
    	        	
    	            //DriverManager.registerDriver(new org.postgresql.Driver());
    	            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver.Driver());
    	            
    	            
    	            // Conecta con la base de datos XE con el usuario system y la contraseña password
    	            cn = DriverManager.getConnection(dc.getServidor(), dc.getUsuario(), dc.getPassword());
    	            
    	            // Llamada al procedimiento almacenado
    	            CallableStatement cst = cn.prepareCall("{call myprocedure()}");

   	                // Ejecuta el procedimiento almacenado
   	                cst.execute();

    	        } catch (SQLException ex) {
    	            System.out.println("Error: " + ex.getMessage());
    	        } finally {
    	            try {
    	                cn.close();
    	            } catch (SQLException ex) {
    	                System.out.println("Error: " + ex.getMessage());
    	            }
    	        }
    
   */ 	        
    	        
        return numero;
    }
}