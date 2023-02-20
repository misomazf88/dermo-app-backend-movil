CREATE TABLE IF NOT EXISTS dermoapp_patient.diagnostic (

    id UUID NOT NULL,
	nombre varchar NOT NULL,
	edad varchar NOT NULL,
	ciudad varchar NOT NULL,
	tipo_de_piel varchar NOT NULL,
    created_at timestamp NOT NULL,
    foto varchar NOT NULL,

	CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE INDEX IF NOT EXISTS user_id_idx ON dermoapp_patient.diagnostic (id);