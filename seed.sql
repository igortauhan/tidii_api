-- First
INSERT INTO public.tb_districts (info, is_leaking, name) VALUES ('Atividade normal', false, 'Centro');
INSERT INTO public.tb_districts (info, is_leaking, name) VALUES ('Atividade normal', false, 'Outro lado');
INSERT INTO public.tb_districts (info, is_leaking, name) VALUES ('Vazamento detectado', true, 'Bairro de cima');
INSERT INTO public.tb_districts (info, is_leaking, name) VALUES ('Atividade normal', false, 'Bairro de baixo');
INSERT INTO public.tb_districts (info, is_leaking, name) VALUES ('Atividade normal', false, 'Urbis');
INSERT INTO public.tb_districts (info, is_leaking, name) VALUES ('Vazamento detectado', true, 'Bairro Leste');


-- Later
INSERT INTO public.tb_streets (info, is_leaking, leaking_date, name, district_id) VALUES ('Atividade normal', false, '1969-12-31 21:00:00', 'Rua 1', 1);
INSERT INTO public.tb_streets (info, is_leaking, leaking_date, name, district_id) VALUES ('Atividade normal', false, '1969-12-31 21:00:00', 'Rua 2', 1);
INSERT INTO public.tb_streets (info, is_leaking, leaking_date, name, district_id) VALUES ('Atividade normal', false, '1969-12-31 21:00:00', 'Rua Principal', 2);
INSERT INTO public.tb_streets (info, is_leaking, leaking_date, name, district_id) VALUES ('Atividade normal', false, '1969-12-31 21:00:00', 'Rua Secundaria', 2);
INSERT INTO public.tb_streets (info, is_leaking, leaking_date, name, district_id) VALUES ('Atividade normal', false, '1969-12-31 21:00:00', 'Avenida Brasil', 3);
INSERT INTO public.tb_streets (info, is_leaking, leaking_date, name, district_id) VALUES ('Vazamento detectado', true, '2021-11-08 19:32:00', 'Avenida Dois', 3);
INSERT INTO public.tb_streets (info, is_leaking, leaking_date, name, district_id) VALUES ('Atividade normal', false, '1969-12-31 21:00:00', 'Avenida de Cima', 4);
INSERT INTO public.tb_streets (info, is_leaking, leaking_date, name, district_id) VALUES ('Atividade normal', false, '1969-12-31 21:00:00', 'Rua D Pedro', 4);
INSERT INTO public.tb_streets (info, is_leaking, leaking_date, name, district_id) VALUES ('Atividade normal', false, '1969-12-31 21:00:00', 'Rua D Pedro II', 5);
INSERT INTO public.tb_streets (info, is_leaking, leaking_date, name, district_id) VALUES ('Atividade normal', false, '1969-12-31 21:00:00', 'Avenida Oliveira', 5);
INSERT INTO public.tb_streets (info, is_leaking, leaking_date, name, district_id) VALUES ('Vazamento detectado', true, '2021-11-10 07:15:00', 'Avenida Simples', 6);
INSERT INTO public.tb_streets (info, is_leaking, leaking_date, name, district_id) VALUES ('Atividade normal', false, '1969-12-31 21:00:00', 'Rua Campos', 6);