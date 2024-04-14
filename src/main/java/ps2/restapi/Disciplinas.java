package ps2.restapi;

public class Disciplinas {
    private long id;
	private String nome;
	private String sigla;
	private String curso;
    private int semestre;

    public Disciplinas() {}
	public Disciplinas(long id, String n, String m, String a, int s) {
		this.id = id;
		this.nome = n;
		this.sigla = m;
		this.curso = a;
        this.semestre=s;
	}
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

    public int getSemestre (){
        return semestre;
    }
    public void setSemestre(int semestre){
        this.semestre=semestre;
    }
}


