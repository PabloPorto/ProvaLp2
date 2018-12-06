import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

public class Sistema {
    private HashMap<String,Ecom> comerciantes;

    public Sistema() {
        comerciantes = new HashMap<>();

    }

    public void cadastrarEcom(String nomeFantasia, String CNPJ, String proprietario, int idTipo){
        
        if (nomeFantasia == null || nomeFantasia.equals("")){
            throw new RuntimeException("Nome fantasia não pode ser nulo ou vazio.");
        }
        if (CNPJ == null || CNPJ.equals("")){
            throw new RuntimeException("CNPJ não pode ser nulo ou vazio.");
        }
        if (proprietario == null || proprietario.equals("")){
            throw new RuntimeException("Proprietario não pode ser nulo ou vazio.");
        }
        comerciantes.put(CNPJ,new Ecom(nomeFantasia,CNPJ,proprietario,idTipo));
    }

    public String recuperaEcom(String cnpj){
        return comerciantes.get(cnpj).toString();
    }

    public void alteraTipoEcom(String cnpj, int idTipo){
        comerciantes.get(cnpj).setTipo(idTipo);
    }

    public void informarValorArrecadado(String cnpj,double valor){
        comerciantes.get(cnpj).setValorArrecadado(valor);
    }

    public double consultarTaxasDevidas(String cnpj){
        int tipo = comerciantes.get(cnpj).getTipo();
        double totalDevido = 0;
        if (tipo == 1){
            TaxasDevidas taxas = new TaxaTipo1();
            totalDevido = taxas.calculaTaxas(cnpj);
        }
        else if (tipo == 2){
            TaxasDevidas taxas = new TaxaTipo2();
            totalDevido = taxas.calculaTaxas(cnpj);
        }
        else if(tipo == 3){
            TaxasDevidas taxas = new TaxaTipo3();
            totalDevido = taxas.calculaTaxas(cnpj);
        }
        return totalDevido;
    }

    public double consultarTotalArrecadado(String cnpj){
        return comerciantes.get(cnpj).getValorArrecadado();
    }
    

    
}
