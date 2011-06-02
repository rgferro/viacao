drop table JURIDICA;
-- Create table
create table JURIDICA
(
  SEQ_JURIDICA       NUMBER(8) not null,
  SEQ_PESSOA_FK      NUMBER(8),
  RAZAO_SOCIAL       VARCHAR2(50),
  NOM_FANTASIA       VARCHAR2(50),
  NOM_RESPONSAVEL    VARCHAR2(50),
  CNPJ               VARCHAR2(80),
  NUM_INSCRICAO      VARCHAR2(30)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    next 24K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Add comments to the table 
comment on table JURIDICA
  is 'Entidade que representa uma pessoa juridica.';
comment on column JURIDICA.SEQ_JURIDICA
  is 'ID (chave primária) da JURIDICA, gerado por sequence.';
comment on column JURIDICA.SEQ_PESSOA_FK
  is 'ID (chave secundaria) da FISICA, gerado por sequence.';
comment on column JURIDICA.RAZAO_SOCIAL
  is 'Razao social de uma pessoa juridica.';
comment on column JURIDICA.NOM_FANTASIA
  is 'Nome fantasia de uma pessoa juridica.';
comment on column JURIDICA.NOM_RESPONSAVEL
  is 'Nome DO RESPONSAVEL de uma pessoa juridica.';
comment on column JURIDICA.CNPJ
  is 'CNPJ de uma pessoa juridica.';
comment on column JURIDICA.NUM_INSCRICAO
  is 'Numero de inscricao de uma pessoa juridica.';
-- Create/Recreate primary, unique and foreign key constraints 
alter table JURIDICA
  add constraint PK_JURIDICA primary key (SEQ_JURIDICA)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 16K
    next 16K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table JURIDICA
  add constraint FK_JURIDICA_CLIENTE foreign key (SEQ_PESSOA_FK)
  references CLIENTE (SEQ_CLIENTE) on delete cascade;
  
-- Create/Recreate indexes 
create index IF1_JURIDICA on JURIDICA (SEQ_PESSOA_FK)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 16K
    next 16K
    minextents 1
    maxextents 505
    pctincrease 50
  );
