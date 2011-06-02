drop table VIAGEM;
-- Create table
create table VIAGEM
(
  SEQ_VIAGEM          NUMBER(8) not null,
  SEQ_ITINERARIO_FK   NUMBER(8),
  SEQ_ONIBUS_FK       NUMBER(8),
  DATA_HORA_SAIDA     TIMESTAMP(6),
  DATA_HORA_CHEGADA   TIMESTAMP(6)
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
comment on table VIAGEM
  is 'Entidade que representa um VIAGEM.';
-- Add comments to the columns 
comment on column VIAGEM.SEQ_VIAGEM
  is 'ID (chave primária) do VIAGEM. Gerado através de Oracle Sequence.';
comment on column VIAGEM.SEQ_ITINERARIO_FK
  is 'ID (chave SECUNDARIA) de VIAGEM, gerado por sequence.';
comment on column VIAGEM.SEQ_ONIBUS_FK
  is 'ID (chave SECUNDARIA) de CLIENTE, gerado por sequence.';
comment on column VIAGEM.DATA_HORA_SAIDA
  is 'DATA E HORA DA SAIDA da VIAGEM';
comment on column VIAGEM.DATA_HORA_CHEGADA
  is 'DATA E HORA DA CHEGADA da VIAGEM.';
-- Create/Recreate primary, unique and foreign key constraints 
alter table VIAGEM
  add constraint PK_VIAGEM primary key (SEQ_VIAGEM)
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
alter table VIAGEM
  add constraint FK_VIAGEM_ITINERARIO foreign key (SEQ_ITINERARIO_FK)
  references ITINERARIO (SEQ_ITINERARIO) on delete cascade;
alter table VIAGEM
  add constraint FK_VIAGEM_ONIBUS foreign key (SEQ_ONIBUS_FK)
  references ONIBUS (SEQ_ONIBUS) on delete cascade;
-- Create/Recreate indexes 
create index IF1_VIAGEM_ITINERARIO on VIAGEM (SEQ_ITINERARIO_FK)
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
create index IF1_VIAGEM_ONIBUS on VIAGEM (SEQ_ONIBUS_FK)
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
