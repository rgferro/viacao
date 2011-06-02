drop table cliente;
-- Create table
create table CLIENTE
(
  SEQ_CLIENTE     NUMBER(8) not null,
  SEQ_PESSOA      NUMBER(8),
  SEQ_ENDERECO_FK NUMBER(8),
  LOGIN           VARCHAR2(20),
  SENHA           VARCHAR2(20),
  EMAIL           VARCHAR2(20)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    next 16K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Add comments to the table 
comment on table CLIENTE
  is 'Entidade que representa um CLIENTE.';
comment on column CLIENTE.SEQ_CLIENTE
  is 'ID (chave primária) do CLIENTE. Gerado através de Oracle Sequence.';
comment on column CLIENTE.SEQ_PESSOA
  is 'ID (chave primária) de juridica ou pessoa, gerado por sequence.';
comment on column CLIENTE.SEQ_ENDERECO_FK
  is 'ID (chave primária) de endereco, gerado por sequence.';
comment on column CLIENTE.LOGIN
  is 'Login do cliente';
comment on column CLIENTE.SENHA
  is 'Senha do cliente.';
comment on column CLIENTE.EMAIL
  is 'E-mail do cliente.';
-- Create/Recreate primary, unique and foreign key constraints 
alter table CLIENTE
  add constraint PK_CLIENTE primary key (SEQ_CLIENTE)
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
alter table CLIENTE
  add constraint FK_CLIENTE_ENDERECO foreign key (SEQ_ENDERECO_FK)
  references ENDERECO (SEQ_ENDERECO) on delete cascade;
-- Create/Recreate indexes 
create index IF1_CLIENTE on CLIENTE (SEQ_ENDERECO_FK)
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
