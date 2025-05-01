package conta_bancaria.controller;

import java.util.ArrayList;
import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{

    
    private ArrayList<Conta> listaContas = new ArrayList<Conta>();

    
    int numero = 0;

@Override
public void procurarPorNumero(int numero) {
        // TODO Auto-generated method stub
        var conta = buscarNaCollection(numero);

        if(conta != null)
            conta.visualizar();
        else
            System.out.printf("\n A conta numero: %d não foi encontrada!", numero);
}

@Override
public void listarTodas() {
        
        for(var conta : listaContas) {
            conta.visualizar();
        }

}

@Override
public void cadastrar(Conta conta) {
        
        listaContas.add(conta);
        System.out.println("A Conta foi criada com sucesso!");

}

  public void transferir(int numeroOrigem, int numeroDestino, double valor) {


}
   

    public int gerarNumero() {
        return ++ numero;
    }

    public Conta buscarNaCollection(int numero) {
        for(var conta: listaContas) {
            if(conta.getNumero() == numero)
                return conta;
        }
        return null;
    }

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, double valor) {
	
		
	}

	@Override
	public void depositar(int numero, double valor) {
		
		
	}

}