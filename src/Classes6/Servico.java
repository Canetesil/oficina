
package Classes6;

import java.sql.Date;


public class Servico {
    private int IdServico;
    private String Descriao_Servico;
    private int Preco;

    public int getIdServico() {
        return IdServico;
    }

    public void setIdServico(int IdServico) {
        this.IdServico = IdServico;
    }

    public String getDescriao_Servico() {
        return Descriao_Servico;
    }

    public void setDescriao_Servico(String Descriao_Servico) {
        this.Descriao_Servico = Descriao_Servico;
    }

    public int getPreco() {
        return Preco;
    }

    public void setPreco(int Preco) {
        this.Preco = Preco;
    }

    public Date getData_Entrada() {
        return Data_Entrada;
    }

    public void setData_Entrada(Date Data_Entrada) {
        this.Data_Entrada = Data_Entrada;
    }

    public Date getData_Saida() {
        return Data_Saida;
    }

    public void setData_Saida(Date Data_Saida) {
        this.Data_Saida = Data_Saida;
    }

    public int getPlaca() {
        return Placa;
    }

    public void setPlaca(int Placa) {
        this.Placa = Placa;
    }
    private Date Data_Entrada;
    private Date Data_Saida;
    private int Placa;
}
