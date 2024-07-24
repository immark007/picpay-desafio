import model.Enum.EnumType;
import model.entities.Account;
import model.entities.AccountUser;
import model.entities.LojistAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        List<Account> acc = new ArrayList<>();
        options();
        int verification = input.nextInt();
        while (verification != 5) {
            switch (verification) {
                case 1:
                    cadastro(input, acc);
                    break;
                case 2:
                    login(input, acc);
                    break;
            }
            options();
            verification = input.nextInt();
        }
        input.close();
    }

    public static void options(){
        System.out.println("[1] Fazer Cadastro");
        System.out.println("[2] Fazer login");
        System.out.println("[3] depositar");
        System.out.println("[4] Sacar");
    }

    public static void cadastro(Scanner input, List<Account> acc){
        System.out.print("Name: ");
        input.nextLine();
        String name = input.nextLine();
        System.out.print("CPF: ");
        String cpf = input.nextLine();
        System.out.print("Type account: ");
        String type = input.nextLine();
        if(type.equalsIgnoreCase("user")){
            acc.add(new AccountUser(name, cpf, EnumType.USER));
        }else if(type.equalsIgnoreCase("lojist")){
            acc.add(new LojistAccount(name, cpf, EnumType.LOJIST));
        }
        System.out.println("Cadastro feito com sucesso");
    }


    public static void login(Scanner input, List<Account> acc){
        System.out.print("Digite o cpf: ");
        input.nextLine();
        String cpf = input.nextLine();
        System.out.println("CPF digitado: " + cpf);
        Account account = acc.stream().filter(x -> x.getCpf().equals(cpf)).findFirst().orElse(null);
        if(account == null){
            System.out.println("Essa conta não existe");
        }else{
            System.out.println("Bem vindo: " + account.getName());
        }
    }
}
