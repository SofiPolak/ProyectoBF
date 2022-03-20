package main;

import static spark.Spark.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {

		Gson g = new Gson();  

		// PERSONA
		PersonaUtils utilsP = new PersonaUtils();
        get("/persona/:dni", (request, response) -> {
        	Connection conn = null;
        	try {
        		conn = connect();
        		int dni = Integer.parseInt(request.params(":dni"));
                return utilsP.getPersona(dni, conn);
        	}finally {
        		if(conn != null) {
            		conn.close();
        		}
        	}
        	
        });
        
        post("/persona", (request, response) -> {
        	Connection conn = null;
        	try {
            	Persona persona = g.fromJson(request.body(), Persona.class);
            	conn = connect();
            	//int dni = 
            	utilsP.createPersona(persona, conn);
            	//persona.setDni(dni);
            	response.body(g.toJson(persona));
            	response.status(201);
            	return response.body();

        	} catch (Exception e){
        		response.status(400);
        		response.body("invalid parameter");
        		return response.body();
        	}finally {
        		if(conn!= null) {
        			conn.close();
        		}
        	}
        });
        
        delete("/persona", (request, response) -> {
        	Connection conn = null;
        	try {
            	Persona persona = g.fromJson(request.body(), Persona.class);
            	conn = connect();
            	utilsP.deletePersona(persona, conn);
            	response.status(200);
            	return response.body();

        	} catch (Exception e){
        		response.status(400);
        		response.body("invalid parameter");
        		return response.body();
        	}finally {
        		if(conn!= null) {
        			conn.close();
        		}
        	}
        });
        
        put("/persona", (request, response) -> {
        	Connection conn = null;
        	try {
            	Persona persona = g.fromJson(request.body(), Persona.class);
            	conn = connect();
            	utilsP.updatePersona(persona, conn);
            	response.status(200);
            	return response.body();

        	} catch (Exception e){
        		response.status(400);
        		response.body("invalid parameter");
        		return response.body();
        	}finally {
        		if(conn!= null) {
        			conn.close();
        		}
        	}
        });
        
     // PERSONA JURIDICA
        PersonaJuridicaUtils utilsPJ = new PersonaJuridicaUtils();
        get("/personaJuridica/:cuit", (request, response) -> {
        	Connection conn = null;
        	try {
        		conn = connect();
        		int cuit = Integer.parseInt(request.params(":cuit"));
                return utilsPJ.getPersonaJuridica(cuit, conn);
        	}finally {
        		if(conn != null) {
            		conn.close();
        		}
        	}
        	
        });
        
        post("/personaJuridica", (request, response) -> {
        	Connection conn = null;
        	try {
            	PersonaJuridica personaJuridica = g.fromJson(request.body(), PersonaJuridica.class);
            	conn = connect();
            	utilsPJ.createPersonaJuridica(personaJuridica, conn);
            	response.body(g.toJson(personaJuridica));
            	response.status(201);
            	return response.body();

        	} catch (Exception e){
        		response.status(400);
        		response.body("invalid parameter");
        		return response.body();
        	}finally {
        		if(conn!= null) {
        			conn.close();
        		}
        	}
        });
        
        delete("/personaJuridica", (request, response) -> {
        	Connection conn = null;
        	try {
            	PersonaJuridica personaJuridica = g.fromJson(request.body(), PersonaJuridica.class);
            	conn = connect();
            	utilsPJ.deletePersonaJuridica(personaJuridica, conn);
            	response.status(200);
            	return response.body();

        	} catch (Exception e){
        		response.status(400);
        		response.body("invalid parameter");
        		return response.body();
        	}finally {
        		if(conn!= null) {
        			conn.close();
        		}
        	}
        });
        
        put("/personaJuridica", (request, response) -> {
        	Connection conn = null;
        	try {
            	PersonaJuridica personaJuridica = g.fromJson(request.body(), PersonaJuridica.class);
            	conn = connect();
            	utilsPJ.updatePersonaJuridica(personaJuridica, conn);
            	response.status(200);
            	return response.body();

        	} catch (Exception e){
        		response.status(400);
        		response.body("invalid parameter");
        		return response.body();
        	}finally {
        		if(conn!= null) {
        			conn.close();
        		}
        	}
        });
        
     // ITEMPRODUCTO
     		ItemProductoUtils utilsProducto = new ItemProductoUtils();
             get("/itemProducto/:nombre", (request, response) -> {
             	Connection conn = null;
             	try {
             		conn = connect();
             		//problema?
             		String nombre = (request.params(":nombre"));
                     return utilsProducto.getItemProducto(nombre, conn);
             	}finally {
             		if(conn != null) {
                 		conn.close();
             		}
             	}
             	
             });
             
             post("/itemProducto", (request, response) -> {
             	Connection conn = null;
             	try {
             		ItemProducto itemProducto = g.fromJson(request.body(), ItemProducto.class);
                 	conn = connect();
                 	utilsProducto.createItemProducto(itemProducto, conn);
                 	response.body(g.toJson(itemProducto));
                 	response.status(201);
                 	return response.body();

             	} catch (Exception e){
             		response.status(400);
             		response.body("invalid parameter");
             		return response.body();
             	}finally {
             		if(conn!= null) {
             			conn.close();
             		}
             	}
             });
             
             delete("/itemProducto", (request, response) -> {
             	Connection conn = null;
             	try {
             		ItemProducto itemProducto = g.fromJson(request.body(), ItemProducto.class);
                 	conn = connect();
                 	utilsProducto.deleteItemProducto(itemProducto, conn);
                 	response.status(200);
                 	return response.body();

             	} catch (Exception e){
             		response.status(400);
             		response.body("invalid parameter");
             		return response.body();
             	}finally {
             		if(conn!= null) {
             			conn.close();
             		}
             	}
             });
             
             put("/itemProducto", (request, response) -> {
             	Connection conn = null;
             	try {
             		ItemProducto itemProducto = g.fromJson(request.body(), ItemProducto.class);
                 	conn = connect();
                 	utilsProducto.updateItemProducto(itemProducto, conn);
                 	response.status(200);
                 	return response.body();

             	} catch (Exception e){
             		response.status(400);
             		response.body("invalid parameter");
             		return response.body();
             	}finally {
             		if(conn!= null) {
             			conn.close();
             		}
             	}
             });
             
          // ITEMSERVICIO
      		ItemServicioUtils utilsServicio = new ItemServicioUtils();
              get("/itemServicio/:nombre", (request, response) -> {
              	Connection conn = null;
              	try {
              		conn = connect();
              		//problema?
              		String nombre = (request.params(":nombre"));
                      return utilsServicio.getItemServicio(nombre, conn);
              	}finally {
              		if(conn != null) {
                  		conn.close();
              		}
              	}
              	
              });
              
              post("/itemServicio", (request, response) -> {
              	Connection conn = null;
              	try {
              		ItemServicio itemServicio = g.fromJson(request.body(), ItemServicio.class);
                  	conn = connect();
                  	utilsServicio.createItemServicio(itemServicio, conn);
                  	response.body(g.toJson(itemServicio));
                  	response.status(201);
                  	return response.body();

              	} catch (Exception e){
              		response.status(400);
              		response.body("invalid parameter");
              		return response.body();
              	}finally {
              		if(conn!= null) {
              			conn.close();
              		}
              	}
              });
              
              delete("/itemServicio", (request, response) -> {
              	Connection conn = null;
              	try {
              		ItemServicio itemServicio = g.fromJson(request.body(), ItemServicio.class);
                  	conn = connect();
                  	utilsServicio.deleteItemServicio(itemServicio, conn);
                  	response.status(200);
                  	return response.body();

              	} catch (Exception e){
              		response.status(400);
              		response.body("invalid parameter");
              		return response.body();
              	}finally {
              		if(conn!= null) {
              			conn.close();
              		}
              	}
              });
              
              put("/itemServicio", (request, response) -> {
              	Connection conn = null;
              	try {
              		ItemServicio itemServicio = g.fromJson(request.body(), ItemServicio.class);
                  	conn = connect();
                  	utilsServicio.updateItemServicio(itemServicio, conn);
                  	response.status(200);
                  	return response.body();

              	} catch (Exception e){
              		response.status(400);
              		response.body("invalid parameter");
              		return response.body();
              	}finally {
              		if(conn!= null) {
              			conn.close();
              		}
              	}
              });
              
           // PEDIDO
        		PedidoUtils utilsPedido = new PedidoUtils();
                get("/pedido/:numero", (request, response) -> {
                	Connection conn = null;
                	try {
                		conn = connect();
                		int numero = Integer.parseInt(request.params(":numero"));
                        return utilsPedido.getPedido(numero, conn);
                	}finally {
                		if(conn != null) {
                    		conn.close();
                		}
                	}
                	
                });
                
                post("/pedido", (request, response) -> {
                	Connection conn = null;
                	try {
                		Pedido pedido = g.fromJson(request.body(), Pedido.class);
                    	conn = connect();
                    	int numero = utilsPedido.createPedido(pedido, conn);
                    	pedido.setNumero(numero);
                    	response.body(g.toJson(pedido));
                    	response.status(201);
                    	return response.body();

                	} catch (Exception e){
                		response.status(400);
                		response.body("invalid parameter");
                		return response.body();
                	}finally {
                		if(conn!= null) {
                			conn.close();
                		}
                	}
                });
                
                delete("/pedido", (request, response) -> {
                	Connection conn = null;
                	try {
                		Pedido pedido = g.fromJson(request.body(), Pedido.class);
                    	conn = connect();
                    	utilsPedido.deletePedido(pedido, conn);
                    	response.status(200);
                    	return response.body();

                	} catch (Exception e){
                		response.status(400);
                		response.body("invalid parameter");
                		return response.body();
                	}finally {
                		if(conn!= null) {
                			conn.close();
                		}
                	}
                });
                
//                put("/pedido", (request, response) -> {
//                	Connection conn = null;
//                	try {
//                		Pedido pedido = g.fromJson(request.body(), Pedido.class);
//                    	conn = connect();
//                    	utilsPedido.updatePedido(pedido, conn);
//                    	response.status(200);
//                    	return response.body();
//
//                	} catch (Exception e){
//                		response.status(400);
//                		response.body("invalid parameter");
//                		return response.body();
//                	}finally {
//                		if(conn!= null) {
//                			conn.close();
//                		}
//                	}
//                });
       
	}
	
	public static Connection connect() throws SQLException {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/Users/sofiapolak/Documents/Finnegans/proyectoBF.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            return conn;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
		
}
