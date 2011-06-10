drop table fisica;
-- Create table
create table FISICA
(
  SEQ_FISICA       NUMBER(8) not null,
  SEQ_CLIENTE_FK   NUMBER(8),
  NOM_PESSOA       VARCHAR2(50),
  CPF_PESSOA       VARCHAR2(20),
  RG_PESSOA               VARCHAR2(20)
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
comment on table FISICA
  is 'Entidade que representa uma pessoa fisica.';
comment on column FISICA.SEQ_FISICA
  is 'ID (chave primária) da FISICA, gerado por sequence.';
comment on column FISICA.SEQ_CLIENTE_FK
  is 'ID (chave secundaria) da FISICA, gerado por sequence.';
comment on column FISICA.NOM_PESSOA
  is 'Nome de uma pessoa fisica.';
comment on column FISICA.CPF_PESSOA
  is 'CPF de uma pessoa fisica.';
comment on column FISICA.RG_PESSOA
  is 'RG de uma pessoa fisica.';
-- Create/Recreate primary, unique and foreign key constraints 
alter table FISICA
  add constraint PK_FISICA primary key (SEQ_FISICA)
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
alter table FISICA
  add constraint FK_FISICA_CLIENTE foreign key (SEQ_CLIENTE_FK)
  references CLIENTE (SEQ_CLIENTE) on delete cascade;
  
-- Create/Recreate indexes 
create index IF1_FISICA on FISICA (SEQ_CLIENTE_FK)
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
