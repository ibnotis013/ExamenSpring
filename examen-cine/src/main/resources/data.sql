-- =====================================================
-- data.sql - Examen API REST (Cine)
-- Se ejecuta automáticamente al arrancar el proyecto.
-- Orden: primero las tablas "padre" (pelicula, actor)
-- y por último la tabla de la relación N:M (reparto).
-- =====================================================

INSERT INTO pelicula (id, titulo, director, anio, duracion) VALUES
(1, 'El Faro Perdido',        'Marta Quintana',  2019, 112),
(2, 'Ciudad de Cristal',      'Julián Ferrer',   2021, 128),
(3, 'La Última Estación',     'Marta Quintana',  2015, 97),
(4, 'Sombras en el Desierto', 'Ibrahim Nasser',  2018, 135),
(5, 'Rumbo a Ítaca',          'Julián Ferrer',   2023, 104),
(6, 'Noche de Tormenta',      'Elena Vidal',     2010, 90),
(7, 'El Cartógrafo',          'Ibrahim Nasser',  2022, 118),
(8, 'Marea Alta',             'Elena Vidal',     2024, 101);

INSERT INTO actor (id, nombre, nacionalidad) VALUES
(1,  'Lucía Montero',    'España'),
(2,  'Darío Salvatierra','Argentina'),
(3,  'Clara Beaumont',   'Francia'),
(4,  'Tomás Aranda',     'México'),
(5,  'Nadia Haddad',     'Líbano'),
(6,  'Pietro Valli',     'Italia'),
(7,  'Irene Solano',     'España'),
(8,  'Hugo Lambert',     'Francia'),
(9,  'Sofía Maldonado',  'Chile'),
(10, 'Andrés Paredes',   'Colombia');

INSERT INTO reparto (id, personaje, salario, pelicula_id, actor_id) VALUES
(1,  'Inés, la farera',          45000.00, 1, 1),
(2,  'Capitán Duarte',           60000.00, 1, 2),
(3,  'Voz del narrador',         15000.00, 1, 6),
(4,  'Dra. Lemaire',             80000.00, 2, 3),
(5,  'Inspector Rojas',          55000.00, 2, 4),
(6,  'Mireya',                   30000.00, 2, 1),
(7,  'Jefa de estación',         40000.00, 3, 7),
(8,  'Viajero misterioso',       35000.00, 3, 8),
(9,  'Leila',                    70000.00, 4, 5),
(10, 'Coronel Mansour',          65000.00, 4, 6),
(11, 'Guía beduino',             25000.00, 4, 4),
(12, 'Penélope',                 50000.00, 5, 9),
(13, 'Ulises',                   75000.00, 5, 10),
(14, 'Doctor Valmont',           48000.00, 6, 8),
(15, 'Camille',                  52000.00, 6, 3),
(16, 'Amadeo, el cartógrafo',    90000.00, 7, 2),
(17, 'Zoe',                      58000.00, 7, 9),
(18, 'Patrona del puerto',       38000.00, 8, 7),
(19, 'Marino Gil',               42000.00, 8, 10);
