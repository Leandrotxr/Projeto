-- Alunos: Leandro Teixeira Ambrósio - GEC - 2118
-- Pedro Paulo de Paiva Junqueira - GEC - 1998
-- Desativei manualmente o SafeMode em PREFERENCES para permitir o update na procedure

drop database if exists projeto;
create database if not exists projeto;
use projeto;

set global log_bin_trust_function_creators = 1; -- permitir a criação de trigger

create table usuario(
	id int not null auto_increment primary key,
    nome varchar(45) not null,
    cpf varchar(45) not null
);

create table if not exists Tecnico (
	cpf int not null primary key,
    nome varchar(45),
    idade int,
    nacionalidade varchar(45)
);

create table if not exists Equipe (
	cnpj int not null primary key,
    nome varchar(45),
    fundacao int,
    sede varchar(45),
    receitamax int,
    receitamax_reajuste double,
    Tecnico_cpf int,
	constraint fk_Equipe_Tecnico
		foreign key (Tecnico_cpf)
        references Tecnico (cpf)
        on delete no action
        on update no action
);

create table if not exists Jogador (
	cpf int not null primary key,
    nome varchar(45),
    idade int,
    nacionalidade varchar(45),
    posicao varchar(45),
    Equipe_cnpj int not null,
	constraint fk_Jogador_Equipe
		foreign key (Equipe_cnpj)
        references Equipe (cnpj)
        on delete no action
        on update no action
);

create table if not exists Patrocinador (
	cnpj int not null primary key,
    nome varchar(45)
);

create table if not exists Equipe_has_Patrocinador (
	Equipe_cnpj int not null,
    Patrocinador_cnpj int not null,
    valor int,
    primary key(Equipe_cnpj, Patrocinador_cnpj),
    constraint fk_Equipe_has_Patrocinador_Equipe
		foreign key (Equipe_cnpj)
        references Equipe (cnpj),
	constraint fk_Equipe_has_Patrocinador_Patrocinador1
		foreign key (Patrocinador_cnpj)
        references Patrocinador (cnpj)
);

create table if not exists Federacao (
	cnpj int not null primary key,
    nome varchar(45)
);

create table if not exists Arbitro (
    cpf int not null primary key,
    nome varchar(45),
    idade int,
    Federacao_cnpj int,
    constraint fk_Arbitro_Federacao
        foreign key (Federacao_cnpj)
        references Federacao (cnpj)
        on update no action
        on delete no action
);

create table if not exists Campeonato (
	idCampeonato int not null primary key,
    nome varchar(45),
    premiacao int,
    localizacao varchar(45),
    Federacao_cnpj int,
    constraint fk_Campeonato_Federacao
		foreign key (Federacao_cnpj)
        references Federacao (cnpj)
        on update no action
        on delete no action
);

create table if not exists Equipe_has_Campeonato (
	Equipe_cnpj int not null,
    Campeonato_idCampeonato int not null,
    primary key(Equipe_cnpj, Campeonato_idCampeonato),
    constraint fk_Equipe_has_Campeonato_Equipe
		foreign key (Equipe_cnpj)
        references Equipe (cnpj),
	constraint fk_Equipe_has_Campeonato_Campeonato1
		foreign key (Campeonato_idCampeonato)
        references Campeonato (idCampeonato)
);

DELIMITER $$

CREATE TRIGGER atualizar_receitamax_depois_campeonato
AFTER INSERT ON Equipe_has_Campeonato
FOR EACH ROW
BEGIN
  DECLARE total_patrocinio INT;
  DECLARE total_campeonatos INT;

  -- Soma dos valores de patrocínio da equipe
  SELECT IFNULL(SUM(valor), 0)
  INTO total_patrocinio
  FROM Equipe_has_Patrocinador
  WHERE Equipe_cnpj = NEW.Equipe_cnpj;

  -- Soma das premiações dos campeonatos que a equipe participa
  SELECT IFNULL(SUM(C.premiacao), 0)
  INTO total_campeonatos
  FROM Equipe_has_Campeonato EC
  JOIN Campeonato C ON C.idCampeonato = EC.Campeonato_idCampeonato
  WHERE EC.Equipe_cnpj = NEW.Equipe_cnpj;

  -- Atualiza a receita máxima da equipe
  UPDATE Equipe
  SET receitamax = total_patrocinio + total_campeonatos
  WHERE cnpj = NEW.Equipe_cnpj;
END$$

CREATE TRIGGER trg_ehc_update AFTER UPDATE ON Equipe_has_Campeonato
FOR EACH ROW
BEGIN
  DECLARE total_patrocinio INT;
  DECLARE total_campeonatos INT;

  -- Atualiza equipe antiga
  SELECT IFNULL(SUM(valor), 0)
  INTO total_patrocinio
  FROM Equipe_has_Patrocinador
  WHERE Equipe_cnpj = OLD.Equipe_cnpj;

  SELECT IFNULL(SUM(C.premiacao), 0)
  INTO total_campeonatos
  FROM Equipe_has_Campeonato EC
  JOIN Campeonato C ON C.idCampeonato = EC.Campeonato_idCampeonato
  WHERE EC.Equipe_cnpj = OLD.Equipe_cnpj;

  UPDATE Equipe
  SET receitamax = total_patrocinio + total_campeonatos
  WHERE cnpj = OLD.Equipe_cnpj;

  -- Se mudou o CNPJ
  IF OLD.Equipe_cnpj <> NEW.Equipe_cnpj THEN
    SELECT IFNULL(SUM(valor), 0)
    INTO total_patrocinio
    FROM Equipe_has_Patrocinador
    WHERE Equipe_cnpj = NEW.Equipe_cnpj;

    SELECT IFNULL(SUM(C.premiacao), 0)
    INTO total_campeonatos
    FROM Equipe_has_Campeonato EC
    JOIN Campeonato C ON C.idCampeonato = EC.Campeonato_idCampeonato
    WHERE EC.Equipe_cnpj = NEW.Equipe_cnpj;

    UPDATE Equipe
    SET receitamax = total_patrocinio + total_campeonatos
    WHERE cnpj = NEW.Equipe_cnpj;
  END IF;
END$$

create procedure reajuste (in p_cnpj int, in inflacao double) 
deterministic
begin 

update Equipe set receitamax_reajuste = round(receitamax * (1 + inflacao)) where cnpj = p_cnpj;

end $$

DELIMITER ;

select * from Tecnico;
select * from Equipe;
select * from Jogador;
select * from Patrocinador;
select * from Equipe_has_Patrocinador;
select * from Federacao;
select * from Arbitro;
select * from Campeonato;
select * from Equipe_has_Campeonato;

select E.nome, J.nome from Equipe as E join Jogador as J on J.Equipe_cnpj = E.cnpj;
select E.nome, T.nome from Equipe as E join Tecnico as T on T.cpf = E.Tecnico_cpf;
select T.nome, E.nome from Tecnico as T join Equipe as E on E.tecnico_cpf = T.cpf;


/*
call reajuste(11111, 0.12);
call reajuste(22222, 0.04);
call reajuste(33333, 0.02);
call reajuste(44444, 0.08);

select nome, receitamax, receitamax_reajuste from equipe;   */

