package org.imobiliaria.imobiliaria.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity(name = "vendedor")
public class VendedorModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RA")
    int RA;

    @Column(name = "nome")
    String nome;

    @Column(name = "cpf")
    String cpf;

    @Column(name = "area")
    String area;

    @Column(name = "dataAdmissao")
    Date dataAdmissao;

    @Column(name = "Ativo")
    boolean ativo;


    public VendedorModel(String nome, String cpf, String area, Date dataAdmissao, boolean ativo) {
        super();
        this.nome = nome;
        this.cpf = formatCpf(cpf);
        this.area = area;
        this.dataAdmissao = dataAdmissao;
        this.ativo = ativo;
    }

    public int getRA() {
        return RA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = formatCpf(cpf);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public VendedorModel() {
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "Nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", area='" + area + '\'' +
                ", Data de Admissao=" + dataAdmissao +
                ", ativo=" + ativo +
                '}';
    }

    private String formatCpf(String cpf) {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

}