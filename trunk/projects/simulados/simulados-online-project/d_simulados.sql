create database db_simulados;
drop database db_simulados;
use db_simulados;

show tables;

desc area;
select * from area;
insert into area(nome) values
	('Comercial'), 
    ('Informática'),
    ('Telecomunicações'),
    ('Administração'),
    ('Finanças'),
    ('Economia'),
    ('Marketing'),
    ('Saúde'),
    ('Recursos Humanos '),
    ('Educação'),
    ('Engenharia'),
    ('Comercial');
    
desc cargo;
select * from cargo;
insert into cargo(nomeCargo) values
	('Cabeleireiro'),
    ('Corretor de Imóveis'),
    ('Técnico de Suporte'),
    ('Técnico de Informática'),
    ('Estagiário em Marketing'),
    ('Administrador de loja'),
    ('Assistente Administrativo'),
    ('Agente de Vendas Internas'),
    ('Representante Comercial'),
    ('Coordenador Comercial');

desc banca;
select * from banca;
insert into banca(nome) values
	('CESPE'),
    ('IADES'),
    ('FCC'),
    ('IBFC'),
    ('FGV'),
    ('VUNESP'),
    ('FUNCAB'),
    ('CESGRANRIO'),
    ('CONSULPLAN'),
    ('FUMARC'),
    ('FUNDAÇÃO SOUSÂNDRADE');

    
desc instituicao;
select * from instituicao;
insert into instituicao(nome) values
	('Banco Central do Brasil'),
    ('Banco da Amazônia'),
    ('Banco do Brasil'),
    ('Banco do Nordeste'),
    ('Banco Nacional de Desenvolvimento Econômico e Social'),
    ('Caixa Econômica Federal'),
    ('Casa Civil da Presidência da República'),
    ('Comissão de Valores Mobiliários'),
    ('Conselho Nacional de Desenvolvimento Científico e Tecnológico'),
    ('Coordenação de Aperfeiçoamento de Pessoal de Nível Superior'),
    ('Empresa Brasileira de Correios e Telégrafos'),
    ('Financiadora de Estudos e Projetos'),
    ('Frente Parlamentar Mista de Apoio à Micro e Pequena Empresa'),
    ('Instituto Brasileiro de Geografia e Estatística'),
    ('Instituto de Pesquisa Econômica Aplicada'),
    ('Instituto Nacional de Metrologia, Normalização e Qualidade Industrial'),
    ('Instituto Nacional de Propriedade Industrial'),
    ('Instituto Nacional do Seguro Social'),
    ('Ministério da Agricultura, Pecuária e Abastecimento'),
    ('Ministério da Ciência, Tecnologia e Inovação'),
    ('Ministério da Cultura'),
    ('Ministério da Educação'),
    ('Ministério da Fazenda'),
    ('Ministério da Integração Nacional'),
    ('Ministério da Justiça'),
    ('Ministério da Previdência Social'),
    ('Ministério da Saúde'),
    ('Ministério das Cidades - MCidades'),
    ('Ministério das Comunicações'),
    ('Ministério das Relações Exteriores'),
    ('Ministério de Minas e Energia'),
    ('Ministério de Minas e Energia'),
    ('Ministério do Desenvolvimento Agrário'),
    ('Ministério do Desenvolvimento Social e Combate à Fome'),
    ('Ministério do Desenvolvimento, Indústria e Comércio Exterior'),
    ('Ministério do Meio Ambiente'),
    ('Ministério do Planejamento, Orçamento e Gestão'),
    ('Ministério do Trabalho e Emprego'),
    ('Ministério do Turismo'),
    ('Ministério dos Transportes'),
    ('Secretaria da Micro e Pequena Empresa da Presidência da República'),
    ('Serviço Brasileiro de Apoio às Micro e Pequenas Empresas'),
    ('Serviço Nacional de Aprendizagem Industrial'),
    ('Serviço Nacional de Aprendizagem Rural'),
    ('Serviço Social do Transporte/Serviço Nacional de Aprendizagem do Transporte'),
    ('Superintendência da Zona Franca de Manaus');
	
desc prova;


