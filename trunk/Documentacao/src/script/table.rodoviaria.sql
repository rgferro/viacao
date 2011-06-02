drop table RODOVIARIA;
-- Create table
create table RODOVIARIA
(
  SEQ_RODOVIARIA     NUMBER(8) not null,
  SEQ_ENDERECO_FK    NUMBER(8),
  NOM_RODOVIARIA     VARCHAR2(20)
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
comment on table RODOVIARIA
  is 'Entidade que representa um RODOVIARIA.';
-- Add comments to the columns 
comment on column RODOVIARIA.SEQ_RODOVIARIA
  is 'ID (chave primária) do RODOVIARIA. Gerado através de Oracle Sequence.';
comment on column RODOVIARIA.SEQ_ENDERECO_FK
  is 'ID (chave SECUNDARIA) do RODOVIARIA. Gerado através de Oracle Sequence.';
comment on column RODOVIARIA.NOM_RODOVIARIA
  is 'NOME da RODOVIARIA';
-- Create/Recreate primary, unique and foreign key constraints 
alter table RODOVIARIA
  add constraint PK_RODOVIARIA primary key (SEQ_RODOVIARIA)
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
alter table RODOVIARIA
  add constraint FK_RODOVIARIA_ENDERECO foreign key (SEQ_ENDERECO_FK)
  references ENDERECO (SEQ_ENDERECO) on delete cascade;
-- Create/Recreate indexes 
create index IF1_RODOVIARIA on RODOVIARIA (SEQ_ENDERECO_FK)
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