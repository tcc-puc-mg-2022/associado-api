create table ${SCHEMA_NAME}.pessoa_fisica
(
    id              bigint      not null,
    nome            varchar(40) not null,
    cpf             varchar(11) not null,
    data_nascimento date        not null
);

alter table ${SCHEMA_NAME}.pessoa_fisica
    add constraint pk_pessoa_fisica primary key (id);

create unique index uk_pessoa_fisica_cpf on  ${SCHEMA_NAME}.pessoa_fisica (cpf);

create sequence  ${SCHEMA_NAME}.sq_pessoa_fisica
    increment by 1
    start with 1
    minvalue 1
    no cycle owned by  ${SCHEMA_NAME}.pessoa_fisica.id;
