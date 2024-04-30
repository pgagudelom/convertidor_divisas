public class ConvierteDivisaIso {

    public String convertirDivisaBase(int numeroDivisaBase){

       String codigoDivisa;

        switch (numeroDivisaBase){
            case 1:
                codigoDivisa = "COP";
                break;
            case 2:
                codigoDivisa = "USD";
                break;
            case 3:
                codigoDivisa = "EUR";
                break;
            case 4:
                codigoDivisa = "JPY";
                break;
            case 5:
                codigoDivisa = "GBP";
                break;
            case 6:
                codigoDivisa = "AUD";
                break;
            case 7:
                codigoDivisa = "CAD";
                break;
            case 8:
                codigoDivisa = "CHF";
                break;
            default:
                codigoDivisa = "USD";
                break;
        }

        return codigoDivisa;
    }


    public String convertirDivisaObjetivo(int numeroDivisaObjetivo){

        String codigoDivisa;

        switch (numeroDivisaObjetivo){
            case 1:
                codigoDivisa = "COP";
                break;
            case 2:
                codigoDivisa = "USD";
                break;
            case 3:
                codigoDivisa = "EUR";
                break;
            case 4:
                codigoDivisa = "JPY";
                break;
            case 5:
                codigoDivisa = "GBP";
                break;
            case 6:
                codigoDivisa = "AUD";
                break;
            case 7:
                codigoDivisa = "CAD";
                break;
            case 8:
                codigoDivisa = "CHF";
                break;
            default:
                codigoDivisa = "USD";
                break;
        }

        return codigoDivisa;
    }
}
