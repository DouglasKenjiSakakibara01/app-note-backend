package project.app.controles;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import project.app.entidades.Tarefa;
import project.app.repositorios.TarefaRepository;

@RestController()
@RequestMapping("/tarefa")
@CrossOrigin(origins = "http://localhost:8100")
public class TarefaController {
    @Autowired
    TarefaRepository repository;

    @GetMapping("/lista-tarefa")
    public List<Tarefa> listaTarefa() {
        return this.repository.findAll();
    }

    @PostMapping("/insere")
    public Tarefa postMethodName(@Valid @RequestBody Tarefa tarefa) {
        this.repository.save(tarefa);
        return tarefa;
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteTarefa(@PathVariable Long id) {
        Optional<Tarefa> tarefa = repository.findById(id);

        if (tarefa.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>("Tarefa removida com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tarefa não encontrada!", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/atualiza/{id}")
    public ResponseEntity<Object> updateTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefa = repository.findById(id);

        if (tarefa.isPresent()) {
            Tarefa tarefaNovo = tarefa.get();
            tarefaNovo.setTitulo(tarefaAtualizada.getTitulo());
            tarefaNovo.setDescricao(tarefaAtualizada.getDescricao());

            Tarefa t = repository.save(tarefaNovo);
            return new ResponseEntity<>(t, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tarefa não encontrada!", HttpStatus.NOT_FOUND);
        }
    }

}
