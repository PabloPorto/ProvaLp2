public class TaxaTipo1 extends Ecom implements TaxasDevidas {

    public double calculaTaxas(String cnpj){
        double taxasDevidas = 0.0;
        double lucro = getValorArrecadado();
        if (lucro < 500.00){
            taxasDevidas = lucro - 500.00;
        }
        else{
            taxasDevidas = lucro * 0.05 + 500.00;
        }
        return taxasDevidas;
    }
}
