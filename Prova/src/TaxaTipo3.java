public class TaxaTipo3 extends Ecom implements TaxasDevidas {

    public double calculaTaxas(String cnpj) {
        double taxasDevidas = 0.0;
        double lucro = getValorArrecadado();
        double bonus = Math.floor(lucro / 10000) * 1000;
        return taxasDevidas = (lucro * 0.2) - bonus + 5000.0;

    }
}
