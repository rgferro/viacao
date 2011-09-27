create table CARTAO
(
  SEQCARTAO      INTEGER not null,
  SEQCLIENTEFK   INTEGER not null,
  NOMETITULAR    VARCHAR2(100) not null,
  NUMEROCARTAO   VARCHAR2(16) not null,
  DATAVALIDADE   DATE not null,
  BANDEIRACARTAO VARCHAR2(50) not null
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
alter table CARTAO
  add constraint SEQCARTAOPK primary key (SEQCARTAO)
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
alter table CARTAO
  add foreign key (SEQCLIENTEFK)
  references CLIENTE (SEQ_CLIENTE);
