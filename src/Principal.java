import com.oraclealura.exchangerateapi.ConsultaDivisa;
import com.oraclealura.exchangerateapi.Divisa;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        /*
        * --------------------------------------------------------------------------------------
        * Este bloque pregunta al usuario las divisas a convertir ------------------------------
        * --------------------------------------------------------------------------------------*/
        Scanner lectura = new Scanner(System.in);

        boolean cicloDeVida = true;

        while(cicloDeVida){

        System.out.println("*******************CONVERTIDOR DE DIVISAS***********************");

        //Preguntamos divisa base
        System.out.println("Escriba el número de la divisa base a convertir:");
        System.out.println("""
                1. COP - Peso colombiano
                2. USD - Dolar estadounidense
                3. EUR - Euros
                4. JPY - Yen japones
                5. GBP - Libra esterlina
                6. AUD - Dolar australiano
                7. CAD - Dolar canadiense
                8. CHF - Franco suizo
                """);
        var divisaBase =  lectura.nextInt(); //Guardamos divisa base


        //Instanciamos convertidor de numero a codigo ISO
        ConvierteDivisaIso convierteBase = new ConvierteDivisaIso();
        String codigoIsoDivisaBase = convierteBase.convertirDivisaBase(divisaBase);


        //Preguntamos divisa objetivo a convertir
        System.out.println("Escriba el número de la divisa objetivo a convertir:");
        System.out.println("""
                1. COP - Peso colombiano
                2. USD - Dolar estadounidense
                3. EUR - Euros
                4. JPY - Yen japones
                5. GBP - Libra esterlina
                6. AUD - Dolar australiano
                7. CAD - Dolar canadiense
                8. CHF - Franco suizo
                """);
        var divisaObjetivo =  lectura.nextInt(); //Guardamos divisa objetivo

        //Instanciamos convertidor de numero a codigo ISO
        ConvierteDivisaIso convierteObjetivo = new ConvierteDivisaIso();
        String codigoIsoDivisaObjetivo = convierteObjetivo.convertirDivisaObjetivo(divisaObjetivo);

        System.out.println("Digite el monto("+codigoIsoDivisaBase+") a convertir");
        double monto = lectura.nextDouble();

        /*-------------------------------------------------------------------------------------------
         *--Este bloque de codigo inicializa la clase para consultar la conversion de dos divisas  --
         * ----------------------------------------------------------------------------------------**/
        if(monto > 0){
            ConsultaDivisa consulta = new ConsultaDivisa();

            String montoTexto = Double.toString(monto);
            //Realizamos consulta a API
            Divisa divisa = consulta.buscaDivisa(codigoIsoDivisaBase, codigoIsoDivisaObjetivo, montoTexto);
            System.out.println("\n----------------------RESULTADO----------------------------");
            System.out.println(monto+"("+codigoIsoDivisaBase + ") equivalen a "+divisa.conversion_result()+"("+codigoIsoDivisaObjetivo+")\n");
            System.out.println("Presione 9 para continuar o presione 0 para salir");

            int continuar = lectura.nextInt();

            if(continuar == 0){
                cicloDeVida = false;
            }
        }

        }

    }
}
