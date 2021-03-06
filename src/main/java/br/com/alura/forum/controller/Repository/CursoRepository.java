package br.com.alura.forum.controller.Repository;

import br.com.alura.forum.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {

    Curso findByNome(String nomeCurso);
}
