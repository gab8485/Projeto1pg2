package Projeto1;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;


class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private List<Pet> pets = new ArrayList<>();

    public Cliente(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() { return nome; }
    public List<Pet> getPets() { return pets; }
    public void adicionarPet(Pet pet) { pets.add(pet); }
    public void removerPet(Pet pet) { pets.remove(pet); }
    @Override
    public String toString() {
        return nome + " - " + telefone + " - " + email;
    }
}

class Pet {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private double peso;

    public Pet(String nome, String especie, String raca, int idade, double peso) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
    }

    public String getNome() { return nome; }
    @Override
    public String toString() {
        return nome + " (" + especie + ", " + raca + ", " + idade + " anos, " + peso + "kg)";
    }
}

abstract class Servico {
    protected String descricao;
    protected Date data;

    public Servico(String descricao, Date data) {
        this.descricao = descricao;
        this.data = data;
    }

    public abstract double getPreco();

    @Override
    public String toString() {
        return descricao + " no dia " + data;
    }
}

class BanhoETosa extends Servico {
    public BanhoETosa(Date data) {
        super("Banho e Tosa", data);
    }

    @Override
    public double getPreco() {
        return 50.0;
    }
}

class ConsultaVeterinaria extends Servico {
    public ConsultaVeterinaria(Date data) {
        super("Consulta Veterinária", data);
    }

    @Override
    public double getPreco() {
        return 100.0;
    }
}

class PacoteServicos {
    private List<Servico> servicos = new ArrayList<>();

    public void adicionarServico(Servico s) {
        servicos.add(s);
    }

    public double getPrecoTotal() {
        double total = 0;
        for (Servico s : servicos) {
            total += s.getPreco();
        }
        return total * 0.9; // 10% de desconto
    }

    public List<Servico> getServicos() { return servicos; }

    @Override
    public String toString() {
        return "Pacote: " + servicos + ", Total com desconto: R$" + getPrecoTotal();
    }
}
public class SistemaPetShop {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Gabriel", "(61)99848-2810", "gabrielbigorna969@gamil.com");
        Pet pet = new Pet("Ozzy", "Cachorro", "Dog Alemao", 3, 70.0);


        LocalDate localDate = LocalDate.of(2026, 5, 20);
        Date dataAgendada = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()); 

        cliente.adicionarPet(pet);




        Date hoje = new Date();
        Servico banho = new BanhoETosa(hoje);
        Servico consulta = new ConsultaVeterinaria(hoje);

        PacoteServicos pacote = new PacoteServicos();
        pacote.adicionarServico(banho);
        pacote.adicionarServico(consulta);




        System.out.println("Cliente: " + cliente);
        System.out.println("Pet: " + pet);

        System.out.println(pacote);

