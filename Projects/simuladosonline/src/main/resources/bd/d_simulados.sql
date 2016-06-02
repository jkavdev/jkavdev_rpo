drop database db_simulados;
create database db_simulados;
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
	('APM'),
    ('APTA'),
    ('ARANTES ASSESSORIA TÉCNICA'),
    ('ASPERHS'),
    ('ASSECONP'),
    ('ASSEPLAC'),
    ('ASSESSORARTE'),
    ('ASTEC'),
    ('BRB'),
    ('CAIP/IMES'),
    ('CÁTEDRA'),
    ('CAJAV');

    
desc instituicao;
select * from instituicao;
insert into instituicao(nome,sigla) values
	('Agência Brasileira de Promoção de
Exportações e Investimentos','APEXBrasil'),
	('Banco Central do Brasil','BACEN'),
    ('Banco da Amazônia','BASA'),
    ('Banco do Brasil','BB'),
    ('Banco do Nordeste','BNB'),
    ('Banco Nacional de Desenvolvimento Econômico e Social','BNDES'),
    ('Caixa Econômica Federal','CAIXA'),
    ('Casa Civil da Presidência da República','CASA CIVIL'),
    ('Comissão de Valores Mobiliários','CVM'),
    ('Conselho Nacional de Desenvolvimento Científico e Tecnológico','CNPQ'),
    ('Coordenação de Aperfeiçoamento de Pessoal de Nível Superior','CAPES'),
    ('Empresa Brasileira de Correios e Telégrafos','ECT'),
    ('Financiadora de Estudos e Projetos','FINEP'),
    ('Fóruns Estaduais das Microempresas e
Empresas de Pequeno Porte
(Estaduais/Distrital)','FR'),
    ('Frente Parlamentar Mista de Apoio à Micro e Pequena Empresa','Fpmmpe'),
    ('Instituto Brasileiro de Geografia e Estatística','IBGE'),
    ('Instituto de Pesquisa Econômica Aplicada','IPEA'),
    ('Instituto Nacional de Metrologia, Normalização e Qualidade Industrial','Inmetro'),
    ('Instituto Nacional de Propriedade Industrial','INPI'),
    ('Instituto Nacional do Seguro Social','INSS'),
    ('Ministério da Agricultura, Pecuária e Abastecimento','MAPA'),
    ('Ministério da Ciência, Tecnologia e Inovação','MCTI'),
    ('Ministério da Cultura','MinC'),
    ('Ministério da Educação','MEC'),
    ('Ministério da Fazenda','MF'),
    ('Ministério da Integração Nacional','MI'),
    ('Ministério da Justiça','MJ'),
    ('Ministério da Previdência Social','MPS'),
    ('Ministério da Saúde','MS'),
    ('Ministério das Cidades','MCidades'),
    ('Ministério das Comunicações','MC'),
    ('Ministério das Relações Exteriores','MRE'),
    ('Ministério de Minas e Energia','MME'),
    ('Ministério do Desenvolvimento Agrário','MDA'),
    ('Ministério do Desenvolvimento Social e Combate à Fome','MDS'),
    ('Ministério do Desenvolvimento, Indústria e Comércio Exterior','MDIC'),
    ('Ministério do Meio Ambiente','MMA'),
    ('Ministério do Planejamento, Orçamento e Gestão','MPOG'),
    ('Ministério do Trabalho e Emprego','MTE'),
    ('Ministério do Turismo','MTur'),
    ('Ministério dos Transportes','MT'),
    ('Secretaria da Micro e Pequena Empresa da Presidência da República','SMPE/PR'),
    ('Secretaria da Receita Federal do Brasil','SRF/MF'),
    ('Serviço Brasileiro de Apoio às Micro e Pequenas Empresas','SEBRAE Nacional'),
    ('Serviço Nacional de Aprendizagem Industrial','SENAI'),
    ('Serviço Nacional de Aprendizagem Rural','SENAR'),
    ('Serviço Social do Transporte/Serviço Nacional de Aprendizagem do Transporte','SEST/SENAT'),
    ('Superintendência da Zona Franca de Manaus','Suframa');
	
desc prova;


