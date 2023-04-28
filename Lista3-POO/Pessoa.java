import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    
    private String nome;
    private String sobrenome;
    private Data dataNacimento;
    private double altura;
    private double peso;
    private double IMC;

    public Pessoa(String nome, String sobrenome, Data dataNacimento, double peso, double altura) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNacimento = dataNacimento;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNomeCompleto(){
        return this.nome + " " + this.sobrenome;
    }

    public String getNomeReferencia() {
        return this.sobrenome.toUpperCase() + ", " + this.nome.toUpperCase();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNasc = LocalDate.of(dataNacimento.getAno(), dataNacimento.getMes(), dataNacimento.getDia());

        Period periodo = Period.between(dataNasc, dataAtual);

        return periodo.getYears();
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public void CalculaIMC() {
        this.IMC = peso / (altura * altura);
    }

    public void InformaObesidade() {
        if (IMC < 18.5) {
            System.out.println("Baixo peso");
            
        } else if (IMC < 25) {
            System.out.println("Peso normal");
            
        } else if (IMC < 30) {
            System.out.println("Sobrepeso");
            
        } else if (IMC < 35) {
            System.out.println("Obesidade grau 1");
            
        } else if (IMC < 40) {
            System.out.println("Obesidade grau 2");
            
        } else {
            System.out.println("Obesidade grau 3");
            
        }
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Pessoa[] pessoas = new Pessoa[10];

        int numPessoa = 0;

        while(numPessoa <= pessoas.length){

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Sobrenome: ");
            String sobrenome = scanner.nextLine();

            if (numPessoa > 0 && (nome + " " + sobrenome).equalsIgnoreCase(pessoas[numPessoa - 1].getNomeCompleto())) {
                System.out.println("\nNome já cadastrado. Cadastro encerrado.\n");
                break;
            }

            System.out.print("Data de nascimento (DD/MM/AAAA): ");

            String dataNascimentoStr = scanner.nextLine();
            String[] partesDataNascimento = dataNascimentoStr.split("/");

            int dia = Integer.parseInt(partesDataNascimento[0]);
            int mes = Integer.parseInt(partesDataNascimento[1]);
            int ano = Integer.parseInt(partesDataNascimento[2]);

            Data dataNascimento = new Data(dia, mes, ano);

            System.out.print("Peso (kg): ");
            double peso = scanner.nextDouble();

            System.out.print("Altura (m): ");
            double altura = scanner.nextDouble();
            scanner.nextLine(); 

            pessoas[numPessoa] = new Pessoa(nome, sobrenome, dataNascimento, peso, altura);

            numPessoa = numPessoa + 1;

            System.out.println("\n");
            
        }

        for(int i = 0; i <= pessoas.length; i++){

            System.out.println("Cadastro: " + (i + 1));
            System.out.println("Nome completo: " + pessoas[i].getNomeCompleto());
            System.out.println("Nome de Referencia: " + pessoas[i].getNomeReferencia());
            System.out.println("Idade: " + pessoas[i].getIdade());
            System.out.println("Peso: " + pessoas[i].getPeso());
            System.out.println("Altura: " + pessoas[i].getPeso());
            System.out.println("Altura: " + pessoas[i].getAltura());

            pessoas[i].CalculaIMC();
            System.out.println("IMC: " + pessoas[i].getIMC());

            
            System.out.print("Clasificação: ");
            pessoas[i].InformaObesidade();

            System.out.println("\n");
        }

        scanner.close();
    }       
}