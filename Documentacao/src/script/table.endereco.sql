drop table endereco;
-- Create table
create table ENDERECO
(
  SEQ_ENDERECO   NUMBER(8) not null,
  LOGRADOURO     VARCHAR2(50),
  NUMERO         VARCHAR2(10),
  COMPLEMENTO    VARCHAR2(20),
  BAIRRO         VARCHAR2(30),
  CIDADE         VARCHAR2(30),
  ESTADO         VARCHAR2(30)
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
comment on table ENDERECO
  is 'Entidade que representa um endereco.';
-- Add comments to the columns 
comment on column ENDERECO.SEQ_ENDERECO
  is 'ID (chave primária) do endereco, gerado por sequence.';
comment on column ENDERECO.LOGRADOURO
  is 'rua/avenida do endereco.';
comment on column ENDERECO.NUMERO
  is 'Numero do endereco.';
comment on column ENDERECO.COMPLEMENTO
  is 'Complemento do endereco.';
comment on column ENDERECO.BAIRRO
  is 'Bairro do endereco.';
comment on column ENDERECO.CIDADE
  is 'Cidade do endereco.';
comment on column ENDERECO.ESTADO
  is 'Estado do endereco.';
-- Create/Recreate primary, unique and foreign key constraints 
alter table ENDERECO
  add constraint PK_ENDERECO primary key (SEQ_ENDERECO)
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
