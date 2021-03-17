import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class JuegoRolSL {
    private final File f = new File("save.txt");
    private int[] datos;

    public JuegoRolSL() {
        datos = new int[5];
    }

    public void guardar() {
        try {
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < datos.length; i++) {
                fw.write(String.valueOf(datos[i]) + "\n");
            }
            fw.close();
        }
        catch (FileNotFoundException e) {
            try {
                f.createNewFile();
                guardar();
            }
            catch (IOException x) {
                System.out.println("Ha ocurrido un error");
            }
        }
        catch (IOException e) {}
    }

    public void cargar() {
        try {
            Scanner sc = new Scanner(f);
            int i = 0;
            while (i < datos.length && sc.hasNextLine()) {
                datos[i] = Integer.parseInt(sc.nextLine());
                i++;
            }
            sc.close();
        }
        catch (FileNotFoundException e) {}
        catch (NumberFormatException e) {}
    }

    public int getLongitud() {
        return datos[0];
    }
    
    public void setLongitud(int n) {
        datos[0] = n;
    }

    public int getEnergia() {
        return datos[1];
    }
    
    public void setEnergia(int n) {
        datos[1] = n;
    }

    public int getComida() {
        return datos[2];
    }
    
    public void setComida(int n) {
        datos[2] = n;
    }

    public int getAgua() {
        return datos[3];
    }
    
    public void setAgua(int n) {
        datos[3] = n;
    }

    public int getAcciones() {
        return datos[4];
    }
    
    public void setAcciones(int n) {
        datos[4] = n;
    }
}