CREATE TABLE IF NOT EXISTS public.diagnostic (

	id UUID NOT NULL,
	created_at timestamp NOT NULL,
	diagnostic_description varchar NOT NULL,
	treatment varchar NOT NULL,

	CONSTRAINT diagnostic_pk PRIMARY KEY (id)
);

CREATE INDEX IF NOT EXISTS diagnostic_created_at_idx ON public.diagnostic (created_at);