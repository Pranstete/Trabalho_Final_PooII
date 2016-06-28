package sistema.beans;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.annotation.ElementType;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.lang.model.element.ElementKind;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
/*
import com.itextpdf.io.IOException;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.sun.javafx.font.FontFactory;
*/
import sistema.modelos.Curso;
import sistema.modelos.Disciplina;
import sistema.modelos.Faculdade;
import sistema.modelos.Pergunta;
import sistema.modelos.Professor;
import sistema.modelos.Prova;
import sistema.modelos.Turma;
import sistema.service.DisciplinaService;
import sistema.service.FaculdadeService;
import sistema.service.PerguntaService;
import sistema.service.ProfessorService;
import sistema.service.ProvaService;
import sistema.service.TurmaService;

@ManagedBean(name = "provaManagedBean")
@ViewScoped
public class ProvaManagedBean extends sistema.beans.ManagedBean<Prova> {

	private TurmaService turmaService = new TurmaService();
	private FaculdadeService faculdadeService = new FaculdadeService();
	private PerguntaService perguntaService = new PerguntaService();
	private DisciplinaService disciplinaService = new DisciplinaService();
	private ProfessorService professorService = new ProfessorService();
	private Curso curso;
	private Professor professor;
	private Pergunta pergunta = new Pergunta();
	private int ordem = 0;

	public ProvaManagedBean() {
		super(new ProvaService());
	}

	public Prova getProva() {
		return model;
	}

	public void setProva(Prova prova) {
		this.model = prova;
	}

	public List<Prova> getProvas() {
		return getList();
	}

	public Professor getProfessor() {
		return professor;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
		if (professor == null || model.getFaculdade() == null) {
			model.setFaculdade(null);
			setCurso(null);
		} else {
			model.setFaculdade(
					faculdadeService.getFaculdadesPorProfessor(professor).isEmpty() ? null : model.getFaculdade());
		}
		if (curso == null || model.getFaculdade() != curso.getFaculdade())
			setCurso(null);
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
		if (curso == null || model.getDisciplina() == null)
			model.setDisciplina(null);
		else
			model.setDisciplina(model.getDisciplina().getCurso() == curso ? model.getDisciplina() : null);
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public List<Professor> getProfessores() {
		return professorService.getList();
	}

	public List<Faculdade> getFaculdades() {
		return professor == null ? null : faculdadeService.getFaculdadesPorProfessor(professor);
	}

	public List<Curso> getCursos() {
		return model.getFaculdade() != null ? model.getFaculdade().getCursos() : null;
	}

	public List<Disciplina> getDisciplinas() {
		return model.getFaculdade() == null ? null : disciplinaService.getDisciplinasPorFaculdade(model.getFaculdade());
	}

	public List<Turma> getTurmas() {
		return model.getDisciplina() == null ? null : turmaService.getTurmaPorDisciplina(model.getDisciplina());
	}

	public List<Pergunta> getPerguntas() {
		return model.getDisciplina() == null ? null : perguntaService.getPerguntasPorDisciplina(model.getDisciplina());
	}

	public void addPergunta() {
		if (ordem == 0)
			pergunta.setOrdem(model.getPerguntas().size() + 1);
		else
			pergunta.setOrdem(ordem);
		model.getPerguntas().add(pergunta);
		pergunta = new Pergunta();
		ordem = 0;
	}

	public void removePergunta(Pergunta pergunta) {
		model.getPerguntas().remove(pergunta);
		pergunta = new Pergunta();
	}

	public void onRowPerguntaEdit(RowEditEvent event) {
		perguntaService.update((Pergunta) event.getObject());
	}

	public void onRowSelect(SelectEvent event) {
		// model = (Prova)event.getObject();
		curso = model.getDisciplina().getCurso();
		professor = model.getTurma().getProfessor();
		pergunta = new Pergunta();
	}

	public void onRowUnselect(UnselectEvent event) {
		model = new Prova();
		curso = null;
		professor = null;
	}

	@Override
	public void save() {
		if (model.getCodigo() != 0) {
			super.update(model);
		} else {
			super.save();
		}
	}
}
