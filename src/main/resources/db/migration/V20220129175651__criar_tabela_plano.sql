create table ${SCHEMA_NAME}.plano
(
    id            bigint      not null,
    nome          varchar(40) not null,
    tipo          integer     not null,
    classificacao integer     not null
);

alter table ${SCHEMA_NAME}.plano
    add constraint pk_plano primary key (id);

alter table ${SCHEMA_NAME}.plano
    add constraint ck_tipo_plano check ( tipo in (1, 2));

alter table ${SCHEMA_NAME}.plano
    add constraint ck_classif_plano check ( tipo in (1, 2, 3));

comment on column ${SCHEMA_NAME}.plano.tipo IS 'Tipo de plano de saúde. Valores possíveis: 1: Médico, 2: Médico-odontológico';
comment on column ${SCHEMA_NAME}.plano.classificacao IS 'Classificação de plano de saúde. Valores possíveis: 1: Enfermaria, 2: Apartmanento, 3: Vip';
