create table associado.pessoa_fisica
(
    idt_pessoa_fisica bigint      not null,
    nom_pessoa        varchar(40) not null,
    num_cpf           varchar(11) not null,
    dat_nascimento    date        not null
);

alter table associado.pessoa_fisica
    add constraint pk_pessoa_fisica primary key (idt_pessoa_fisica);

create unique index uk_pessoa_fisica_cpf on associado.pessoa_fisica (num_cpf);

create sequence associado.sq_pessoa_fisica
    increment by 1
    start with 1
    minvalue 1
    no cycle
    owned by associado.pessoa_fisica.idt_pessoa_fisica