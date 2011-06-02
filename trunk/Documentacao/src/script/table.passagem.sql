drop table passagem;
-- Create table
create table PASSAGEM
(
  SEQ_PASSAGEM     NUMBER(8) not null,
  SEQ_VIAGEM_FK    NUMBER(8),
  SEQ_CLIENTE_FK   NUMBER(8),
  NUM_BILHETE      VARCHAR2(20),
  NUM_POLTRONA     NUMBER(8)
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
comment on table PASSAGEM
  is 'Entidade que representa um PASSAGEM.';
-- Add comments to the columns 
comment on column PASSAGEM.SEQ_PASSAGEM
  is 'ID (chave primária) do PASSAGEM. Gerado através de Oracle Sequence.';
comment on column PASSAGEM.SEQ_VIAGEM_FK
  is 'ID (chave SECUNDARIA) de VIAGEM, gerado por sequence.';
comment on column PASSAGEM.SEQ_CLIENTE_FK
  is 'ID (chave SECUNDARIA) de CLIENTE, gerado por sequence.';
comment on column PASSAGEM.NUM_BILHETE
  is 'numero do bilhete da PASSAGEM';
comment on column PASSAGEM.NUM_POLTRONA
  is 'Numero da poltrona da PASSAGEM.';
-- Create/Recreate primary, unique and foreign key constraints 
alter table PASSAGEM
  add constraint PK_PASSAGEM primary key (SEQ_PASSAGEM)
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
alter table PASSAGEM
  add constraint FK_PASSAGEM_VIAGEM foreign key (SEQ_VIAGEM_FK)
  references VIAGEM (SEQ_VIAGEM) on delete cascade;
alter table PASSAGEM
  add constraint FK_PASSAGEM_CLIENTE foreign key (SEQ_CLIENTE_FK)
  references CLIENTE (SEQ_CLIENTE) on delete cascade;
-- Create/Recreate indexes 
create index IF1_PASSAGEM_VIAGEM on PASSAGEM (SEQ_VIAGEM_FK)
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
create index IF1_PASSAGEM_CLIENTE on PASSAGEM (SEQ_CLIENTE_FK)
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
