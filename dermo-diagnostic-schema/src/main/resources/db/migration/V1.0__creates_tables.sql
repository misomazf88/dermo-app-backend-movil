CREATE TABLE IF NOT EXISTS public.account (

    id UUID NOT NULL,
	correo_electronico varchar NOT NULL,
	created_at timestamp NOT NULL,
	contrasena varchar NOT NULL,

	CONSTRAINT account_pk PRIMARY KEY (correo_electronico)
);

CREATE INDEX IF NOT EXISTS account_created_at_idx ON public.account (created_at);