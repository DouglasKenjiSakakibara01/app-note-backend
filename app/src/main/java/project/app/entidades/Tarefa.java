package project.app.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="titulo can not be null")
    private String titulo;
    @NotBlank(message="descricao can not be null")
    private String descricao;
    private String data;
    private String horario;

    public Long getId(){
        return this.id;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;

    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;

    }
    public String getData(){
        return this.data;
    }
    public void setData(String data){
        this.data = data;

    }
    public String getHorario(){
        return this.horario;
    }
    public void setHorario(String horario){
        this.horario = horario;

    }


}
