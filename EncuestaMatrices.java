import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author dania
 */
public class EncuestaMatrices {

    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public String entrada;

    public static int cerosUnos() {
        int respuesta;
        double valor = Math.random();
        if (valor < 0.5) {
            respuesta = 1;
        } else {
            respuesta = 0;
        }
        return respuesta;
    }

    public static int[][] encuesta() {
        int[][] encuesta = new int[10][4];
        for (int i = 0; i < encuesta.length; i++) {
            for (int j = 0; j < encuesta[i].length; j++) {
                if (j == 0) {
                    encuesta[i][j] = (int) (Math.random() * 2 + 1);
                } else if (j == 1) {
                    encuesta[i][j] = cerosUnos();
                } else if ((j == 2) && (encuesta[i][1] == 1)) {
                    encuesta[i][j] = (int) (Math.random() * 6000 + 1);
                } else if ((j == 2) && (encuesta[i][1] == 0)) {
                    encuesta[i][j] = 0;
                } else if (j == 3) {
                    encuesta[i][j] = (int) (Math.random() * 5 + 1);
                }
            }
        }
        return encuesta;
    }

    public static void imprimirMatriz(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%5d", array[i][j]);
            }
            System.out.println();
        }
    }

    public static int mujeres(int[][] array) {
        int mujeres = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == 2) {
                mujeres++;
            }
        }
        return mujeres;
    }

    public static int hombres(int[][] array) {
        int hombres = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == 1) {
                hombres++;
            }
        }
        return hombres;
    }

    public static void porcentajeGenero(int hombres, int mujeres) {
        double porcentajeM, porcentajeH;
        porcentajeM = (mujeres * 100) / 10;
        porcentajeH = (hombres * 100) / 10;
        System.out.println("Se entrevistaron a 10 personas de las cuales:");
        System.out.println(mujeres + " son mujeres, que equivale al " + porcentajeM + "%");
        System.out.println(hombres + " son hombres, que equivale al " + porcentajeH + "%");
    }

    public static int mujeresT(int[][] array) {
        int mujeresT = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i][0] == 2) && (array[i][1] == 1)) {
                mujeresT++;
            }
        }
        return mujeresT;
    }

    public static int hombresT(int[][] array) {
        int hombresT = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i][0] == 1) && (array[i][1] == 1)) {
                hombresT++;
            }
        }
        return hombresT;
    }

    public static void porcentajeTrabajo(int hombres, int mujeres, int hombresT, int mujeresT, int[][] array) {
        double porcentajeM, porcentajeH;
        porcentajeM = (mujeresT * 100) / mujeres;
        porcentajeH = (hombresT * 100) / hombres;
        System.out.println("De las " + mujeres + " mujeres entrevistadas, únicamente " + mujeresT + " trabajan, " + porcentajeM + "% de estas mujeres están en el área laboral");
        System.out.println("De los " + hombres + " hombres entrevistados, únicamente " + hombresT + " trabajan, " + porcentajeH + "% de estos hombres están en el área laboral");
    }

    public static void sueldoPromedio(int hombresT, int mujeresT, int[][] array) {
        int sueldoM = 0;
        int sueldoH = 0;
        double promedioM, promedioH;
        for (int i = 0; i < array.length; i++) {
            if ((array[i][0] == 2) && (array[i][1] == 1)) {
                sueldoM = sueldoM + array[i][2];
            }
            if ((array[i][0] == 1) && (array[i][1] == 1)) {
                sueldoH = sueldoH + array[i][2];
            }
        }
        promedioM = sueldoM / mujeresT;
        promedioH = sueldoH / hombresT;
        System.out.println("El sueldo promedio de las mujeres es: $" + promedioM);
        System.out.println("El sueldo promedio de los hombres es: $" + promedioH);
    }

    public static void universidadNT(int[][] array) {
        int hombresUNT = 0;
        int mujeresUNT = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i][0] == 2) && (array[i][1] == 0) && (array[i][3] == 4)) {
                mujeresUNT++;
            }
            if ((array[i][0] == 1) && (array[i][1] == 0) && (array[i][3] == 4)) {
                hombresUNT++;
            }
        }
        System.out.println(mujeresUNT + " mujeres tienen la universidad completa, pero no trabajan");
        System.out.println(hombresUNT + " hombres tienen la universidad completa, pero no trabajan");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int mujeres, hombres, mujeresT, hombresT;
        int[][] encuesta;
        encuesta = encuesta();
        imprimirMatriz(encuesta);
        mujeres = mujeres(encuesta);
        hombres = hombres(encuesta);
        porcentajeGenero(hombres, mujeres);
        mujeresT = mujeresT(encuesta);
        hombresT = hombresT(encuesta);
        porcentajeTrabajo(hombres, mujeres, hombresT, mujeresT, encuesta);
        sueldoPromedio(hombresT, mujeresT, encuesta);
        universidadNT(encuesta);
    }

}
