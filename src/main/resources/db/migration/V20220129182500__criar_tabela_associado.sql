create table associado.associado
(
    id               bigint         not null,
    id_pessoa_fisica bigint         not null,
    id_plano         bigint         not null,
    categoria        integer        not null,
    tipo             integer        not null,
    valor            numeric(10, 2) not null,
    sit_carteirinha  integer        not null
);

alter table associado.associado
    add constraint pk_associado primary key (id);

alter table associado.associado
    add constraint fk_plano foreign key (id_plano) references associado.plano (id);

alter table associado.associado
    add constraint fk_pessoa_fisica foreign key (id_pessoa_fisica) references associado.pessoa_fisica (id);

alter table associado.associado
    add constraint ck_categoria_assoc check ( categoria in (1, 2, 3));

alter table associado.associado
    add constraint ck_tipo_assoc check ( tipo in (1, 2));

alter table associado.associado
    add constraint ck_sit_carteitinha check ( associado.sit_carteirinha in (1, 2, 3) );

comment on column associado.associado.categoria IS 'Categoria do associado. Valores possíveis: 1: Ativo, 2: Suspenso, 3: Inativo';
comment on column associado.associado.tipo IS 'Tipo de associação. Valores possíveis: 1: Individual, 2: Empresarial';
comment on column associado.associado.sit_carteirinha IS 'Situação da carteirinha do associado. Valores possíveis: 1: Não solicitada, 2: Em processamento, 3: emitida';

create sequence associado.sq_associado
    increment by 1
    start with 1
    minvalue 1
    no cycle owned by associado.associado.id