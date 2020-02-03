SET SEARCH_PATH TO atividade;

create table atividade.CLI_CLINICA(
	CLI_SEQ_CLINICA bigserial not null,
	CLI_NOME_CLINICA varchar(60) not null,
	primary key (CLI_SEQ_CLINICA)
);

CREATE SEQUENCE atividade.seq_cli_clinica
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999
  START 1
  CACHE 1;


create table atividade.LTO_LEITO(
	LTO_SEQ_LEITO bigserial not null,
	LTO_DSC_LEITO varchar(60) not null,
	CLI_CLINICA bigserial not null,
	primary key (LTO_SEQ_LEITO),
	FOREIGN KEY (CLI_CLINICA)
  REFERENCES atividade.CLI_CLINICA
  
);

 CREATE SEQUENCE atividade.seq_lto_leito
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999
  START 1
  CACHE 1;


  create table atividade.PAC_PACIENTE(
	
	PAC_SEQ_PACIENTE bigserial not null,
	PAC_NOME_PACIENTE varchar(80) not null,	
	PAC_DATA_NASCIMENTO date,
	primary key (PAC_SEQ_PACIENTE)
	
);
  
 CREATE SEQUENCE atividade.SEQ_PAC_PACIENTE
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999
  START 1
  CACHE 1;



create table atividade.INT_INTERNACAO(
	INT_SEQ_INTERNACAO bigserial not null,
	INT_DATA_INTERNACAO date,
	PAC_PACIENTE bigserial not null,
	LTO_LEITO bigserial not null,
	primary key (INT_SEQ_INTERNACAO),

	FOREIGN KEY (PAC_PACIENTE)
	REFERENCES atividade.PAC_PACIENTE,

	FOREIGN KEY (LTO_LEITO)
	REFERENCES atividade.LTO_LEITO
	
);



CREATE SEQUENCE atividade.SEQ_INT_INTERNACAO
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999
  START 1
  CACHE 1;

