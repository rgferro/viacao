-- Create table
create table COMPRA
(
  SEQ_COMPRA      INTEGER not null,
  SEQ_CARTAO_FK   INTEGER not null,
  SEQ_PASSAGEM_FK INTEGER not null
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
-- Create/Recreate primary, unique and foreign key constraints 
alter table COMPRA
  add constraint SEQ_COMPRA_PK primary key (SEQ_COMPRA)
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
alter table COMPRA
  add foreign key (SEQ_CARTAO_FK)
  references CARTAO (SEQCARTAO);
alter table COMPRA
  add foreign key (SEQ_PASSAGEM_FK)
  references PASSAGEM (SEQ_PASSAGEM);
