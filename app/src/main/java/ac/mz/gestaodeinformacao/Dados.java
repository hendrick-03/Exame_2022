package ac.mz.gestaodeinformacao;

import android.os.Parcel;
import android.os.Parcelable;

public class Dados implements Parcelable {
    private String nome;
    private int idade;
    private String genero;
    private String provinvia;
    private String gravidade;

    public Dados(String nome, int idade, String genero, String provinvia, String gravidade) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.provinvia = provinvia;
        this.gravidade = gravidade;

    }

    protected Dados(Parcel in) {
        nome = in.readString();
        idade = in.readInt();
        genero = in.readString();
        provinvia = in.readString();
        gravidade = in.readString();
    }

    public static final Creator<Dados> CREATOR = new Creator<Dados>() {
        @Override
        public Dados createFromParcel(Parcel in) {
            return new Dados(in);
        }

        @Override
        public Dados[] newArray(int size) {
            return new Dados[size];
        }
    };

    public Dados() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProvinvia() {
        return provinvia;
    }

    public void setProvinvia(String provinvia) {
        this.provinvia = provinvia;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeInt(idade);
        dest.writeString(genero);
        dest.writeString(provinvia);
        dest.writeString(gravidade);
    }

    public String toString() {
        return "Nome: " + nome +
                ", Idade: " + idade +
                ", Gênero: " + genero +
                ", Provinvia: " + provinvia +
                ", Gravidade: " + gravidade;
    }

}
