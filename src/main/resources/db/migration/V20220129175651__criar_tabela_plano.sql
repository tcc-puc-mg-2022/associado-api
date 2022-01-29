create table associado.plano
(
    id            bigint      not null,
    nome          varchar(40) not null,
    tipo          integer     not null,
    classificacao integer     not null
);

alter table associado.plano
    add constraint pk_plano primary key (id);

alter table associado.plano
    add constraint ck_tipo_plano check ( tipo in (1, 2));

alter table associado.plano
    add constraint ck_classif_plano check ( tipo in (1, 2, 3));

comment on column associado.plano.tipo IS 'Tipo de plano de saúde. Valores possíveis: 1: Médico, 2: Médico-odontológico';
comment on column associado.plano.classificacao IS 'Classificação de plano de saúde. Valores possíveis: 1: Enfermaria, 2: Apartmanento, 3: Vip';