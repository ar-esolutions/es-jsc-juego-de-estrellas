--liquibase formatted sql

--changeset mpianello:1
CREATE TABLE matches (
	year              INTEGER   PRIMARY KEY,
	day_of_year       INTEGER   NOT NULL CHECK (day_of_year BETWEEN 1 AND 366),
	id_equipo_1       INTEGER,
	id_equipo_2       INTEGER
);

--changeset mpianello:2
INSERT INTO matches (year, day_of_year) VALUES (1930, 16);
INSERT INTO matches (year, day_of_year) VALUES (1931, 13);
INSERT INTO matches (year, day_of_year) VALUES (1932, 67);
INSERT INTO matches (year, day_of_year) VALUES (1933, 227);
INSERT INTO matches (year, day_of_year) VALUES (1934, 260);
INSERT INTO matches (year, day_of_year) VALUES (1935, 92);
INSERT INTO matches (year, day_of_year) VALUES (1936, 102);
INSERT INTO matches (year, day_of_year) VALUES (1937, 199);
INSERT INTO matches (year, day_of_year) VALUES (1938, 97);
INSERT INTO matches (year, day_of_year) VALUES (1939, 96);
INSERT INTO matches (year, day_of_year) VALUES (1940, 146);
INSERT INTO matches (year, day_of_year) VALUES (1941, 59);
INSERT INTO matches (year, day_of_year) VALUES (1942, 139);
INSERT INTO matches (year, day_of_year) VALUES (1943, 145);
INSERT INTO matches (year, day_of_year) VALUES (1944, 1);
INSERT INTO matches (year, day_of_year) VALUES (1945, 350);
INSERT INTO matches (year, day_of_year) VALUES (1946, 136);
INSERT INTO matches (year, day_of_year) VALUES (1947, 118);
INSERT INTO matches (year, day_of_year) VALUES (1948, 4);
INSERT INTO matches (year, day_of_year) VALUES (1949, 76);
INSERT INTO matches (year, day_of_year) VALUES (1950, 254);
INSERT INTO matches (year, day_of_year) VALUES (1951, 309);
INSERT INTO matches (year, day_of_year) VALUES (1952, 324);
INSERT INTO matches (year, day_of_year) VALUES (1953, 155);
INSERT INTO matches (year, day_of_year) VALUES (1954, 233);
INSERT INTO matches (year, day_of_year) VALUES (1955, 18);
INSERT INTO matches (year, day_of_year) VALUES (1956, 175);
INSERT INTO matches (year, day_of_year) VALUES (1957, 62);
INSERT INTO matches (year, day_of_year) VALUES (1958, 59);
INSERT INTO matches (year, day_of_year) VALUES (1959, 214);
INSERT INTO matches (year, day_of_year) VALUES (1960, 366);
INSERT INTO matches (year, day_of_year) VALUES (1961, 104);
INSERT INTO matches (year, day_of_year) VALUES (1962, 364);
INSERT INTO matches (year, day_of_year) VALUES (1963, 106);
INSERT INTO matches (year, day_of_year) VALUES (1964, 208);
INSERT INTO matches (year, day_of_year) VALUES (1965, 219);
INSERT INTO matches (year, day_of_year) VALUES (1966, 251);
INSERT INTO matches (year, day_of_year) VALUES (1967, 286);
INSERT INTO matches (year, day_of_year) VALUES (1968, 165);
INSERT INTO matches (year, day_of_year) VALUES (1969, 222);
INSERT INTO matches (year, day_of_year) VALUES (1970, 129);
INSERT INTO matches (year, day_of_year) VALUES (1971, 34);
INSERT INTO matches (year, day_of_year) VALUES (1972, 253);
INSERT INTO matches (year, day_of_year) VALUES (1973, 358);
INSERT INTO matches (year, day_of_year) VALUES (1974, 186);
INSERT INTO matches (year, day_of_year) VALUES (1975, 1);
INSERT INTO matches (year, day_of_year) VALUES (1976, 73);
INSERT INTO matches (year, day_of_year) VALUES (1977, 298);
INSERT INTO matches (year, day_of_year) VALUES (1978, 87);
INSERT INTO matches (year, day_of_year) VALUES (1979, 230);
INSERT INTO matches (year, day_of_year) VALUES (1980, 194);
INSERT INTO matches (year, day_of_year) VALUES (1981, 233);
INSERT INTO matches (year, day_of_year) VALUES (1982, 311);
INSERT INTO matches (year, day_of_year) VALUES (1983, 162);
INSERT INTO matches (year, day_of_year) VALUES (1984, 53);
INSERT INTO matches (year, day_of_year) VALUES (1985, 203);
INSERT INTO matches (year, day_of_year) VALUES (1986, 40);
INSERT INTO matches (year, day_of_year) VALUES (1987, 94);
INSERT INTO matches (year, day_of_year) VALUES (1988, 51);
INSERT INTO matches (year, day_of_year) VALUES (1989, 45);
INSERT INTO matches (year, day_of_year) VALUES (1990, 359);
INSERT INTO matches (year, day_of_year) VALUES (1991, 254);
INSERT INTO matches (year, day_of_year) VALUES (1992, 135);
INSERT INTO matches (year, day_of_year) VALUES (1993, 226);
INSERT INTO matches (year, day_of_year) VALUES (1994, 216);
INSERT INTO matches (year, day_of_year) VALUES (1995, 104);
INSERT INTO matches (year, day_of_year) VALUES (1996, 51);
INSERT INTO matches (year, day_of_year) VALUES (1997, 12);
INSERT INTO matches (year, day_of_year) VALUES (1998, 212);
INSERT INTO matches (year, day_of_year) VALUES (1999, 327);
INSERT INTO matches (year, day_of_year) VALUES (2000, 266);
INSERT INTO matches (year, day_of_year) VALUES (2001, 193);
INSERT INTO matches (year, day_of_year) VALUES (2002, 17);
INSERT INTO matches (year, day_of_year) VALUES (2003, 365);
INSERT INTO matches (year, day_of_year) VALUES (2004, 299);
INSERT INTO matches (year, day_of_year) VALUES (2005, 81);
INSERT INTO matches (year, day_of_year) VALUES (2006, 59);
INSERT INTO matches (year, day_of_year) VALUES (2007, 262);
INSERT INTO matches (year, day_of_year) VALUES (2008, 19);
INSERT INTO matches (year, day_of_year) VALUES (2009, 111);
INSERT INTO matches (year, day_of_year) VALUES (2010, 121);
INSERT INTO matches (year, day_of_year) VALUES (2011, 103);
INSERT INTO matches (year, day_of_year) VALUES (2012, 35);
INSERT INTO matches (year, day_of_year) VALUES (2013, 169);
INSERT INTO matches (year, day_of_year) VALUES (2014, 198);
INSERT INTO matches (year, day_of_year) VALUES (2015, 49);
INSERT INTO matches (year, day_of_year) VALUES (2016, 241);
INSERT INTO matches (year, day_of_year) VALUES (2017, 210);
INSERT INTO matches (year, day_of_year) VALUES (2018, 187);

COMMIT;