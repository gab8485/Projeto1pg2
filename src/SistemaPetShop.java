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

