package project.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import project.app.entidades.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
