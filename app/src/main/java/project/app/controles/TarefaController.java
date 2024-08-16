package project.app.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import project.app.entidades.Tarefa;
import project.app.repositorios.TarefaRepository;


@RestController()
@RequestMapping("/tarefa")
public class TarefaController {
    @Autowired
    TarefaRepository repository;

    @GetMapping("/lista-tarefa")
    public List<Tarefa> listaTarefa(){
        return this.repository.findAll();
    }
    @PostMapping("/insere")
    public Tarefa postMethodName(@Valid @RequestBody Tarefa tarefa) {
        this.repository.save(tarefa);
        return tarefa;
    }
    

}
