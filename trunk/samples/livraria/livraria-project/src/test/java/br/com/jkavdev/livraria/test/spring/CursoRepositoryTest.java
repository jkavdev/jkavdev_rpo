package br.com.jkavdev.livraria.test.spring;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.livraria.model.Curso;
import br.com.jkavdev.livraria.model.Livro;
import br.com.jkavdev.livraria.repository.ICursoRepository;
import br.com.jkavdev.livraria.repository.ILivroRepository;

public class CursoRepositoryTest extends AbstractDatabaseTest {

	private static final Logger logger = Logger.getLogger(AutorRepositoryTest.class);

	@Autowired
	private ICursoRepository cursoRepository;
	@Autowired
	private ILivroRepository livroRepository;

	@Test
	public void insereLivroEscritos() {

		Curso agronomia = criaCurso("Agronomia");
		Curso agroecologia = criaCurso("Agroecologia");
		Curso agricultura = criaCurso("Aquicultura");
		Curso analisesistemas = criaCurso("Análise de Sistemas");
		Curso astronomia = criaCurso("Astronomia");
		Curso automacao = criaCurso("Automação industrial");
		Curso bioengenharia = criaCurso("Bioengenharia");
		Curso biotecnologia = criaCurso("Biotecnologia");
		Curso biocombustivel = criaCurso("Biocombustíveis");
		Curso cienciaexata = criaCurso("Ciências exatas");
		Curso cienciamolecular = criaCurso("Ciências moleculares");
		Curso agronomia1 = criaCurso("Ciências naturais");
		Curso agronomia2 = criaCurso("Computação");
		Curso agronomia3 = criaCurso("Computação científica");
		Curso agronomia4 = criaCurso("Construção civil");
		Curso agronomia5 = criaCurso("Ciência e Tecnologia");
		Curso agronomia6 = criaCurso("Eletrônica");
		Curso agronomia7 = criaCurso("Engenharia aeroespacial");
		Curso agronomia8 = criaCurso("Engenharia aeronáutica");
		Curso agronomia9 = criaCurso("Engenharia agrícola");
		Curso agronomia10 = criaCurso("Engenharia de agrimensura");
		Curso agronomia11 = criaCurso("Engenharia de alimentos");
		Curso agronomia12 = criaCurso("Engenharia de áudio");
		Curso agronomia13 = criaCurso("Engenharia urbana");
		Curso agronomia14 = criaCurso("Engenharia biofísica");
		Curso agronomia15 = criaCurso("Engenharia biofísica");
		Curso agronomia16 = criaCurso("Engenharia cartográfica");
		Curso agronomia17 = criaCurso("Engenharia de computação");
		Curso agronomia18 = criaCurso("Engenharia de controle e automação");
		Curso agronomia19 = criaCurso("Engenharia econômica");
		Curso agronomia20 = criaCurso("Engenharia elétrica");
		Curso agronomia21 = criaCurso("Engenharia eletrônica");
		Curso agronomia22 = criaCurso("Engenharia estrutural");
		Curso agronomia23 = criaCurso("Engenharia física");
		Curso agronomia24 = criaCurso("Engenharia florestal");
		Curso agronomia25 = criaCurso("Prospecção geofísica");
		Curso agronomia26 = criaCurso("Engenharia geográfica");

		cursoRepository.save(agronomia);
		cursoRepository.save(agroecologia);
		cursoRepository.save(agricultura);
		cursoRepository.save(analisesistemas);
		cursoRepository.save(astronomia);
		cursoRepository.save(automacao);
		cursoRepository.save(bioengenharia);
		cursoRepository.save(biotecnologia);
		cursoRepository.save(biocombustivel);
		cursoRepository.save(cienciaexata);
		cursoRepository.save(cienciamolecular);
		cursoRepository.save(agronomia1);
		cursoRepository.save(agronomia2);
		cursoRepository.save(agronomia3);
		cursoRepository.save(agronomia4);
		cursoRepository.save(agronomia5);
		cursoRepository.save(agronomia6);
		cursoRepository.save(agronomia7);
		cursoRepository.save(agronomia8);
		cursoRepository.save(agronomia9);
		cursoRepository.save(agronomia10);
		cursoRepository.save(agronomia11);
		cursoRepository.save(agronomia12);
		cursoRepository.save(agronomia13);
		cursoRepository.save(agronomia14);
		cursoRepository.save(agronomia15);
		cursoRepository.save(agronomia16);
		cursoRepository.save(agronomia17);
		cursoRepository.save(agronomia18);
		cursoRepository.save(agronomia19);
		cursoRepository.save(agronomia20);
		cursoRepository.save(agronomia21);
		cursoRepository.save(agronomia22);
		cursoRepository.save(agronomia23);
		cursoRepository.save(agronomia24);
		cursoRepository.save(agronomia25);
		cursoRepository.save(agronomia26);

		logger.info("Cursos Salvos com Sucesso!");

		// Curso agronomia = criaCurso("Engenharia geológica");
		// Curso agronomia = criaCurso("Engenharia geológica");
		// Curso agronomia = criaCurso("Engenharia hidráulica");
		// Curso agronomia = criaCurso("Engenharia humana");
		// Curso agronomia = criaCurso("Engenharia industrial");
		// Curso agronomia = criaCurso("Engenharia industrial madeireira");
		// Curso agronomia = criaCurso("Engenharia de informação");
		// Curso agronomia = criaCurso("Engenharia de instrumentação");
		// Curso agronomia = criaCurso("Engenharia de manufatura");
		// Curso agronomia = criaCurso("Engenharia de manutenção");
		// Curso agronomia = criaCurso("Engenharia de materiais");
		// Curso agronomia = criaCurso("Engenharia mecânica");
		// Curso agronomia = criaCurso("Engenharia mecatrônica");
		// Curso agronomia = criaCurso("Engenharia metalúrgica");
		// Curso agronomia = criaCurso("Engenharia militar");
		// Curso agronomia = criaCurso("Engenharia multimídia");
		// Curso agronomia = criaCurso("Engenharia de minas");
		// Curso agronomia = criaCurso("Engenharia naval e oceânica");
		// Curso agronomia = criaCurso("Engenharia nuclear");
		// Curso agronomia = criaCurso("Engenharia óptica");
		// Curso agronomia = criaCurso("Engenharia de pesca");
		// Curso agronomia = criaCurso("Engenharia de petróleo");
		// Curso agronomia = criaCurso("Engenharia de produção");
		// Curso agronomia = criaCurso("Engenharia da qualidade");
		// Curso agronomia = criaCurso("Engenharia química");
		// Curso agronomia = criaCurso("Engenharia sanitária");
		// Curso agronomia = criaCurso("Engenharia de serviços");
		// Curso agronomia = criaCurso("Engenharia de sistemas");
		// Curso agronomia = criaCurso("Engenharia de sistemas eletrônicos");
		// Curso agronomia = criaCurso("Engenharia de software");
		// Curso agronomia = criaCurso("Engenharia de tecidos");
		// Curso agronomia = criaCurso("Engenharia de telecomunicações");
		// Curso agronomia = criaCurso("Engenharia têxtil");
		// Curso agronomia = criaCurso("Engenharia de transportes e logística");
		// Curso agronomia = criaCurso("Eletrônica embarcada");

	}

	@Test
	// @Transactional
	public void insertLivrosIndicados() {

		Curso curso = cursoRepository.findOne(1L);
		Livro livro = livroRepository.findOne(1L);

		// curso.adicionaLivroIndicado(livro);
		//
		// List<Livro> livros = new ArrayList<>();
		//
		// curso.setLivrosIndicados(livros);

		curso.adicionaLivroIndicado(livro);

		cursoRepository.save(curso);
	}

	@Test
	public void insertCategoriaCurso() {
		// Ciências exatas
		// 2 Ciências biológicas
		// 3 Ciências humanas
	}

	public Curso criaCurso(String nomeCurso) {
		return new Curso(nomeCurso);
	}

	// Farmacêutica (ou Farmácia ou ainda Bioquímica)
	// Física
	// Física biológica
	// Física computacional
	// Física médica
	// Geociências (ou ciências da terra)
	// Geofísica
	// Geologia
	// Informática (ou ciência da computação)
	// Informática biomédica
	// Química
	// Transporte hidroviário (ou transporte marítimo)
	// Manutenção industrial (tecnologia)
	// Matemática
	// Matemática aplicada
	// Matemática computacional
	// Ciência dos materiais (tecnologia)
	// Mecânica - processos de produção (tecnologia)
	// Mecânica de precisão (ou Mecatrônica [tecnologia])
	// Metalurgia (tecnologia)
	// Meteorologia
	// Oceanografia (ou oceanologia ou ainda Ciência dos Mares)
	// Processos gerenciais (tecnologia)
	// Processamento de dados
	// Produção (tecnologia)
	// Produção de materiais plásticos (tecnologia)
	// Produção têxtil
	// Química ambiental
	// Química industrial
	// Saneamento (tecnologia)
	// Segurança da informação (tecnologia)
	// Sistemas de informação
	// Sistemas para internet (tecnologia)
	// Tecnologia da informação (licenciatura)
	// Telecomunicações
	// Telemática (tecnologia)
	// Ciências biológicas[editar | editar código-fonte]
	// Alimentos (tecnologia)
	// Bioenergia sucro-alcooleira (tecnologia)
	// Biologia
	// Biologia marinha
	// Biomedicina
	// Biotecnologia
	// Botânica
	// Ciência dos alimentos
	// Ciências (licenciatura)
	// Ciências agrárias
	// Ciências ambientais
	// Ciências da atividade física (licenciatura)
	// Ciências biológicas (ou biologia)[15]
	// Ciências do esporte
	// Cosmetologia e Estética ou Estética e Cosmética
	// Ecologia
	// Engenharia Ambiental
	// Educação física[16]
	// Enfermagem
	// Esportes
	// Fisioterapia
	// Fonoaudiologia
	// Gerontologia
	// Medicina[17]
	// Medicina veterinária[18]
	// Meio ambiente e recursos hídricos (tecnologia)
	// Microbiologia (ou imunologia)
	// Nutrição[19]
	// Obstetrícia
	// Odontologia[20]
	// Radiologia (tecnologia)
	// Sistemas Biomédicos (tecnologia)
	// Silvicultura (tecnologia)
	// Tecnologias em saúde - oftálmica e radiológica
	// Terapia ocupacional
	// Zootecnia[18]
	// Ciências humanas[editar | editar código-fonte]
	// Administração
	// Administração pública
	// Agronegócio (tecnologia)
	// Antropologia
	// Arqueologia
	// Arquitetura
	// Arquivologia
	// Artes cênicas
	// Artes plásticas
	// Artes visuais
	// Automação de escritório (ou secretariado [tecnologia])
	// Biblioteconomia
	// Ciências atuariais
	// Comércio exterior
	// Ciências contábeis (ou contabilidade)
	// Ciências econômicas (ou economia)
	// Ciência da informação
	// Ciências políticas (ou Ciências do Estado)
	// Ciências sociais (ou sociologia)
	// Cinema
	// Comunicação social
	// Cooperativismo (ou associativismo em Redes de empresas e no agronegócio
	// [tecnologia])
	// Dança
	// Defesa e Gestão Estratégica Internacional[21]
	// Design
	// Design de interiores
	// Design de moda
	// Desenho industrial (ou Design gráfico)
	// Direito[22]
	// Editoração (ou produção editorial)
	// Educação artística
	// Educação musical (licenciatura)
	// Escultura
	// Estatística[23]
	// Estudos literários
	// Eventos (tecnologia)
	// Fotografia (ou Gravura)
	// Filosofia[24]
	// Gastronomia
	// Geografia
	// Gestão da Qualidade (tecnologia)
	// Gestão ambiental (tecnologia)]
	// Gestão de comércio internacional
	// Gestão de empresas[25]
	// Gestão empresarial (tecnologia)
	// Gestão de políticas públicas
	// Gestão da produção de calçados (tecnologia)
	// História[26]
	// História da arte
	// Hotelaria
	// Jornalismo[27]
	// Lazer
	// Letras[28]
	// Linguística[29]
	// Logística (tecnologia)
	// Logística aeroportuária (tecnologia)
	// Logística e transportes (tecnologia)
	// Marketing (ou propaganda)
	// Museologia
	// Música
	// Paisagismo
	// Pedagogia
	// Pintura
	// Psicologia
	// Psicopedagogia
	// Publicidade
	// Produção Fonográfica
	// Radialismo (ou Rádio & TV, ou ainda Audiovisual)
	// Recursos humanos
	// Relações internacionais (ou Diplomacia)
	// Relações públicas
	// Secretariado (tecnologia)
	// Serviço social
	// Teatro
	// Teologia[30] [31]
	// Design de jogos digitais
	// Turismologia
	// Urbanismo

}
