drop table TARIFA;
-- Create table
create table TARIFA
(
  SEQ_TARIFA     NUMBER(8) not null,
  NOM_TARIFA      VARCHAR2(20),
  VALOR_TARIFA     NUMBER(4,2)
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
comment on table TARIFA
  is 'Entidade que representa um TARIFA.';
-- Add comments to the columns 
comment on column TARIFA.SEQ_TARIFA
  is 'ID (chave primária) do TARIFA. Gerado através de Oracle Sequence.';
comment on column TARIFA.NOM_TARIFA
  is 'NOME da TARIFA';
comment on column TARIFA.VALOR_TARIFA
  is 'VALOR da TARIFA.';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TARIFA
  add constraint PK_TARIFA primary key (SEQ_TARIFA)
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