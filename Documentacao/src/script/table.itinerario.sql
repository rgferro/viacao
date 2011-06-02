drop table ITINERARIO;
-- Create table
create table ITINERARIO
(
  SEQ_ITINERARIO              NUMBER(8) not null,
  SEQ_RODOVIARIA_ORIGEM_FK    NUMBER(8),
  SEQ_RODOVIARIA_DESTINO_FK   NUMBER(8),
  TEMPO_VIAGEM                TIMESTAMP(6), 
  VALOR_PASSAGEM              NUMBER(4,2)
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
comment on table ITINERARIO
  is 'Entidade que representa um ITINERARIO.';
-- Add comments to the columns 
comment on column ITINERARIO.SEQ_ITINERARIO
  is 'ID (chave primária) do ITINERARIO. Gerado através de Oracle Sequence.';
comment on column ITINERARIO.SEQ_RODOVIARIA_ORIGEM_FK
  is 'ID (chave SECUNDARIA) do ITINERARIO. Gerado através de Oracle Sequence.';
comment on column ITINERARIO.SEQ_RODOVIARIA_DESTINO_FK
  is 'ID (chave SECUNDARIA) do ITINERARIO. Gerado através de Oracle Sequence.';
comment on column ITINERARIO.TEMPO_VIAGEM
  is 'TEMPO DO PERCURSCO do ITINERARIO';
comment on column ITINERARIO.VALOR_PASSAGEM
  is 'VALOR DA PASSAGEM CORRESPONDENTE AO ITINERARIO';
-- Create/Recreate primary, unique and foreign key constraints 
alter table ITINERARIO
  add constraint PK_ITINERARIO primary key (SEQ_ITINERARIO)
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
alter table ITINERARIO
  add constraint FK_ITI_ROD_ORIGEM foreign key (SEQ_RODOVIARIA_ORIGEM_FK)
  references RODOVIARIA (SEQ_RODOVIARIA) on delete cascade;
alter table ITINERARIO
  add constraint FK_ITI_ROD_DESTINO foreign key (SEQ_RODOVIARIA_DESTINO_FK)
  references RODOVIARIA (SEQ_RODOVIARIA) on delete cascade;
-- Create/Recreate indexes 
create index IF1_ITI_ROD_ORIGEM on ITINERARIO (SEQ_RODOVIARIA_ORIGEM_FK)
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
create index IF1_ITI_ROD_DESTINO on ITINERARIO (SEQ_RODOVIARIA_DESTINO_FK)
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