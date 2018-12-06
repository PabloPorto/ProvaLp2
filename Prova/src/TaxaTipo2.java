public class TaxaTipo2 extends Ecom implements TaxasDevidas  {

    public double calculaTaxas(String cnpj){
        double taxasDevidas = 0.0;
        double lucro = getValorArrecadado();
        return taxasDevidas = lucro * 0.1 + 1000.00;
    }
}
