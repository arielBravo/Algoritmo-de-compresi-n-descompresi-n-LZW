/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author ariel
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class DescompresionLZW {
    
    String rutaArchivo;
    Double tiempo;
    String textoArchivo;
   
    long pesoArchivoDescomprimido;
    long pesoArchivoComprimido;
    
    public DescompresionLZW(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.tiempo=0.0;
        this.textoArchivo="";
        this.pesoArchivoDescomprimido=0;
        this.pesoArchivoComprimido=0;
    }
    
	public  void descomprimir() {
		int maximoTamañoTabla,lector, contadorAscii = 0, bitLength, codigoRecibido;
		String string = "";
		String newString;
		String stringDelArchivo= null;
		ArrayList<String> tabla = new ArrayList<String>();
		ArrayList<String> charDesdeStringCodificado = new ArrayList<String>();
		BufferedReader br = null;
		//Generamos la tabla con  lista de los caracteres ASCII estandar
		while(contadorAscii!=256){
			tabla.add(String.valueOf((char) contadorAscii));
			contadorAscii++;
		}
		//	Leemos el contenido del  archivo y alamacenamos los datos en un buffer string  que se utilizara mas tarde.
		StringBuilder textoDesdeArchivo = new StringBuilder();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(rutaArchivo), Charset.forName("UTF-16BE")));
			while((lector = br.read())!= -1){
				textoDesdeArchivo.append((char) lector);
			}
                        stringDelArchivo = textoDesdeArchivo.toString(); //obtenemos el string codificado desde el archivo codificado

                        bitLength = 16; 	

                        maximoTamañoTabla = (int) Math.pow(2, bitLength); //damos la longitud de la tabla 2^16
                        //////////////////********Para saber el peso del archivo comprimido
                        File archivo=new File(rutaArchivo);
                        pesoArchivoComprimido=Math.round(Math.ceil(archivo.length()/1024.0));
                       //////////////////**************************************
                        //System.out.println("-------------Algoritmo Descompresion LZW------------");
                        stringDelArchivo = textoDesdeArchivo.toString();
                        int indiceInicial = (int) stringDelArchivo.charAt(0);
                        string = tabla.get(indiceInicial);
                        charDesdeStringCodificado.add(string);
                        int contadorParaRecibirCodigo = 1;
                         double tinicio = (double) System.currentTimeMillis(); //inicia el tiempo
                        while(contadorParaRecibirCodigo < stringDelArchivo.length()){
                                codigoRecibido =  (int) stringDelArchivo.charAt(contadorParaRecibirCodigo);
                                if(codigoRecibido < contadorAscii){
                                        newString = tabla.get(codigoRecibido);

                                }
                                else{
                                        newString = string + string.charAt(0);

                                }
                                charDesdeStringCodificado.add(newString);
                                if(contadorAscii < maximoTamañoTabla){
                                        tabla.add(string+newString.charAt(0));
                                        contadorAscii++;
                                        contadorParaRecibirCodigo++;
                                }
                                string = newString;


                        }

                        


                        StringBuilder imprimirDecodificado = new StringBuilder();
                        for(String s: charDesdeStringCodificado){
                                imprimirDecodificado.append(s);
                        }

                       //System.out.println("\n\nString Decodificado: " +imprimirDecodificado +"\n\n");
                        textoArchivo="\n\nString Decodificado: " +imprimirDecodificado +"\n\n";
                        //System.out.println("----------------------------------------------------");
                        BufferedReader escribirEnArchivo = new BufferedReader(new StringReader(imprimirDecodificado.toString()));

                        PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo.split("\\.")[0] + "Decodificado.txt"));
                        escribirEnArchivo.lines().forEach(lineValue -> writer.println(lineValue));
                        writer.close();
                        
                        double tfin = (double) System.currentTimeMillis();
                        tiempo = tfin - tinicio;
                        
                        //////////////////********Para saber el peso del archivo descomprimido
                         archivo=new File(rutaArchivo.split("\\.")[0] + "Decodificado.txt");
                        pesoArchivoDescomprimido=Math.round(Math.ceil(archivo.length()/1024.0));
                       //////////////////**************************************
                        
                        
		} catch (FileNotFoundException e) {
			 JOptionPane.showMessageDialog(null, "Error: No se encuentra el archivo");
			
		} catch (IOException e) {
			 JOptionPane.showMessageDialog(null, "Error: El archivo no puede ser leido.");
			
		}	
	}
        
    public Double obtenerTiempo(){
        return this.tiempo;
    }
    
    public String getTextoArchivoDescomprimido(){
        return textoArchivo;
    }
    public long getPesoArchivoComprimido(){
        return pesoArchivoComprimido;
    }
    public long getPesoArchivoDescomprimido(){
        return pesoArchivoDescomprimido;
    }
}
