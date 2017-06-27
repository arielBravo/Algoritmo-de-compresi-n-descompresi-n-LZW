package Logica;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CompresionLZW {
    String rutaArchivo;
    Double tiempo;
    String textoArchivo;
    String valoresCodificados;
    long pesoArchivo;
    long pesoArchivoComprimido;
    public CompresionLZW(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.tiempo=0.0;
        this.textoArchivo="";
        this.valoresCodificados="";
        this.pesoArchivo=0;
        this.pesoArchivoComprimido=0;
    }

    public void comprimir() {
        int maximoTamanioTabla, lector, asciiContador = 0, bitLength;
        String string = "";
        char[] charsDelArchivo;
        ArrayList<Integer> codigoTabla = new ArrayList<Integer>();
        ArrayList<String> tabla = new ArrayList<String>();
        ArrayList<Character> ArrayCaracteres = new ArrayList<Character>();
        //Generar una tabla con sla lista de los caracteres ASCII estandar
        while (asciiContador != 256) {
            tabla.add(String.valueOf((char) asciiContador));
            asciiContador++;
        }
        //Leemos el contenido del archivo y almacenamos los datos en un string buffer que se utilizara mas adelante.
        StringBuilder textoDelArchivo = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rutaArchivo)));
            while ((lector = br.read()) != -1) {
                textoDelArchivo.append((char) lector);
            }
            br.close();
            
            bitLength = 16;
            
            //////////////////********Para saber el peso del archivo original
            File archivo=new File(rutaArchivo);
            pesoArchivo=Math.round(Math.ceil(archivo.length()/1024.0));
            
           //////////////////*********************************************
            

        //System.out.println("-------------------Algoritmo de compresion LZW-------------------\n");
        //System.out.println("Entrada del archivo:" + textoDelArchivo.toString() + "\n");
        double tinicio = (double) System.currentTimeMillis(); //inicia el tiempo
        textoArchivo="Entrada del archivo:" + textoDelArchivo.toString() + "\n";
        
        charsDelArchivo = textoDelArchivo.toString().toCharArray();
        //generamos un array que contiene los caracteres individuales de la entrada
        for (char c : charsDelArchivo) {
            if (c != '\r') {
                ArrayCaracteres.add(c);
            }
        }

        maximoTamanioTabla = (int) Math.pow(2, bitLength); //damos el maximo tamano de la tabla 2^numerobits
        
        //Algoritmo para la codificacion
        for (char c : ArrayCaracteres) {
            if (tabla.contains(string + c)) {
                string += c;
            } else {
                codigoTabla.add(tabla.indexOf(string));
                if (asciiContador < maximoTamanioTabla) {
                    tabla.add(string + c);
                }
                string = String.valueOf(c);
            }
        }
        codigoTabla.add(tabla.indexOf(string));
        
        
      //  System.out.println("Valores codificados"); //Imprimimos los valores codificados
        StringBuilder codigosDelArchivoLzw = new StringBuilder();
        for (int codigos: codigoTabla) {
            //System.out.println(codigos);
            valoresCodificados=valoresCodificados+String.valueOf(codigos)+"\n";
            codigosDelArchivoLzw.append((char) codigos);
        }
        
        //System.out.println("---------------------------------------------------------------\n");
        
        //ingresamos los valores codificados al archivo y generamos el archivo en el formato especificado .lzw
        FileOutputStream os = new FileOutputStream(new File(rutaArchivo.split("\\.")[0] + ".lzw"));
         os.write(codigosDelArchivoLzw.toString().getBytes("UTF-16BE"));
         os.close();
        double tfin = (double) System.currentTimeMillis();
        tiempo = tfin - tinicio;
         
         //////////////////********Para saber el peso del archivo comprimido
            archivo=new File(rutaArchivo.split("\\.")[0] + ".lzw");
            pesoArchivoComprimido=Math.round(Math.ceil(archivo.length()/1024.0));
            
           //////////////////*********************************************
        
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: No se encuentra el archivo");
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: El archivo no puede ser leido.");
        }

        
        

    }
    public Double obtenerTiempo(){
        return this.tiempo;
    }
    public String getTextoArchivo(){
        return this.textoArchivo;
    }
    public String getValoresCodificados(){
        return valoresCodificados;
    }
    public long getPesoArchivo(){
        return pesoArchivo;
    }
    public long getPesoArchivoComprimido(){
        return pesoArchivoComprimido;
    }
}
