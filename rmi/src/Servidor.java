import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args) {
        try {
            ContaBancaria conta = new ContaBancariaImpl();
            LocateRegistry.createRegistry(1099); // Inicia o registro RMI na porta 1099
            Naming.rebind("ContaBancaria", conta); // Registra a instância da conta bancária com o nome "ContaBancaria"
            System.out.println("Servidor pronto para receber conexões...");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
