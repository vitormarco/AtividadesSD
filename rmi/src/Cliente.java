import java.rmi.Naming;
import java.rmi.RemoteException;

public class Cliente {
    public static void main(String[] args) {
        try {
            ContaBancaria conta = (ContaBancaria) Naming.lookup("rmi://localhost/ContaBancaria");
            conta.deposita(1000.0);
            conta.retira(500.0);
            double saldo = conta.saldo();
            System.out.println("Saldo atual: " + saldo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
