import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ContaBancariaImpl extends UnicastRemoteObject implements ContaBancaria {
    private double saldo;

    public ContaBancariaImpl() throws RemoteException {
        saldo = 0.0;
    }

    @Override
    public void deposita(double valor) throws RemoteException {
        saldo += valor;
        System.out.println("Depósito de " + valor + " realizado. Saldo atual: " + saldo);
    }

    @Override
    public void retira(double valor) throws RemoteException {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Retirada de " + valor + " realizada. Saldo atual: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para a retirada de " + valor);
        }
    }

    @Override
    public double saldo() throws RemoteException {
        return saldo;
    }
}
