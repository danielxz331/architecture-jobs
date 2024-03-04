CREATE TABLE departamento (
    id serial PRIMARY KEY,
    nombre varchar
);

CREATE TABLE municipio (
    id serial PRIMARY KEY,
    nombre varchar,
    departamento_id integer NOT NULL
);

ALTER TABLE municipio
    ADD CONSTRAINT fk_departamento_id
    FOREIGN KEY (departamento_id)
    REFERENCES departamento (id);

CREATE TABLE lugar (
    id serial PRIMARY KEY,
    direccion varchar,
    departamento_id integer NOT NULL,
    municipio_id integer NOT NULL
);

ALTER TABLE lugar
    ADD CONSTRAINT fk_lugar_departamento_id
    FOREIGN KEY (departamento_id)
    REFERENCES departamento (id);

ALTER TABLE lugar
    ADD CONSTRAINT fk_lugar_municipio_id
    FOREIGN KEY (municipio_id)
    REFERENCES municipio (id);

CREATE TABLE programa (
    id serial PRIMARY KEY,
    nombre varchar,
    semestre integer,
    lugar_id integer NOT NULL
);

ALTER TABLE programa
    ADD CONSTRAINT fk_programa_lugar_id
    FOREIGN KEY (lugar_id)
    REFERENCES lugar (id);

CREATE TABLE estudiante (
    id serial PRIMARY KEY,
    nombres varchar,
    apellidos varchar,
    codigo integer,
    programa_id integer NOT NULL,
    lugar_id integer NOT NULL
);

ALTER TABLE estudiante
    ADD CONSTRAINT fk_estudiante_programa_id
    FOREIGN KEY (programa_id)
    REFERENCES programa (id);

ALTER TABLE estudiante
    ADD CONSTRAINT fk_estudiante_lugar_id
    FOREIGN KEY (lugar_id)
    REFERENCES lugar (id);

/*
    DELETE FROM estudiante;
    DELETE FROM programa;
    DELETE FROM lugar;
    DELETE FROM municipio;
    DELETE FROM departamento;
    */

/*
    DROP TABLE estudiante;
    DROP TABLE programa;
    DROP TABLE lugar;
    DROP TABLE municipio;
    DROP TABLE departamento;
 */
