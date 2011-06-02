drop table ITINERARIO_TARIFA;
-- Create table
create table ITINERARIO_TARIFA
(
  SEQ_ITINERARIO_TARIFA              NUMBER(8) not null,
  SEQ_ITINERARIO_FK    NUMBER(8),
  SEQ_TARIFA_FK   NUMBER(8)
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
comment on table ITINERARIO_TARIFA
  is 'Entidade que representa um ITINERARIO_TARIFA.';
-- Add comments to the columns 
comment on column ITINERARIO_TARIFA.SEQ_ITINERARIO_TARIFA
  is 'ID (chave primária) do ITINERARIO_TARIFA. Gerado através de Oracle Sequence.';
comment on column ITINERARIO_TARIFA.SEQ_ITINERARIO_FK
  is 'ID (chave SECUNDARIA) do ITINERARIO_TARIFA. Gerado através de Oracle Sequence.';
comment on column ITINERARIO_TARIFA.SEQ_TARIFA_FK
  is 'ID (chave SECUNDARIA) do ITINERARIO_TARIFA. Gerado através de Oracle Sequence.';
-- Create/Recreate primary, unique and foreign key constraints 
alter table ITINERARIO_TARIFA
  add constraint PK_ITINERARIO_TARIFA primary key (SEQ_ITINERARIO_TARIFA)
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
alter table ITINERARIO_TARIFA
  add constraint FK_ITI_TARIFA_ITINERARIO foreign key (SEQ_ITINERARIO_FK)
  references ITINERARIO (SEQ_ITINERARIO) on delete cascade;
alter table ITINERARIO_TARIFA
  add constraint FK_ITI_TARIFA_TARIFA foreign key (SEQ_TARIFA_FK)
  references TARIFA (SEQ_TARIFA) on delete cascade;
-- Create/Recreate indexes 
create index IF1_ITI_TARIFA_ITINERARIO on ITINERARIO_TARIFA (SEQ_ITINERARIO_FK)
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
create index IF1_ITI_TARIFA_TARIFA on ITINERARIO_TARIFA (SEQ_TARIFA_FK)
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