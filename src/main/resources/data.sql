insert into shippingdb.profile (id, name, page, role) VALUES (1,'Super Administrateur','admin/dashboard/main','super');
insert into shippingdb.profile (id, name, page, role) VALUES (2,'Administrateur','configuration/account/page','admin');
insert into shippingdb.profile (id, name, page, role) VALUES (3,'Agent','admin/dashboard/main','attendee');
insert into shippingdb.profile (id, name, page, role) VALUES (4,'User','admin/dashboard/main','organiser');
insert into shippingdb.profile (id, name, page, role) VALUES (5,'Livreur','partnership/request','partner');

insert into shippingdb.users(id, username, password, status, locale, profile, created, creator)
values(1, 'techgeeknext', '$2a$10$ixlPY3AAd4ty1l6E2IsQ9OFZi2ba9ZQE0bP7RFcGIWNhyFrrT3YUi', 'USER_ACTIVE', 'fr', 1, now(), null); -- password: Password

-- location
insert into shippingdb.location (id, name, parent, nature, created, creator) values (1,'Ouest', null, 'department', now(), 1);
insert into shippingdb.location (id, name, parent, nature, created, creator) values (2,'Artibonite', null,'department', now(), 1);
insert into shippingdb.location (id, name, parent, nature, created, creator) values (3,'Sud Est', null, 'department', now(), 1);
insert into shippingdb.location (id, name, parent, nature, created, creator) values (4,'Grand Anse', null, 'department', now(), 1);
insert into shippingdb.location (id, name, parent, nature, created, creator) values (5,'Sud', null, 'department', now(), 1);
insert into shippingdb.location (id, name, parent, nature, created, creator) values (6,'Centre', null, 'department', now(), 1);
insert into shippingdb.location (id, name, parent, nature, created, creator) values (7,'Nord', null, 'department', now(), 1);
insert into shippingdb.location (id, name, parent, nature, created, creator) values (8,'Nord Est', null, 'department', now(), 1);
insert into shippingdb.location (id, name, parent, nature, created, creator) values (9,'Nord Ouest', null, 'department', now(), 1);
insert into shippingdb.location (id, name, parent, nature, created, creator) values (10,'Nippes', null, 'department', now(), 1);

insert into shippingdb.location (id, name, parent, nature, created, creator) values (11,'Port-au-Prince', 1,'commune', now(), 1);
insert into shippingdb.location (id, name, parent, nature, created, creator) values (12,'Delmas', 1,'commune', now(), 1);
insert into shippingdb.location (id, name, parent, nature, created, creator) values (13,'Petion-ville', 1,'commune', now(), 1);

insert into shippingdb.location (name, parent, nature, created, creator) values ('Arcahaie', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Cabaret', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Cornillon', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Croix-des-Bouquets', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Fonds-Verrettes', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Ganthier', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Thomazeau', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Anse-a-Galets', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Pointe-a-Raquette', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Grand-Goave', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Leogane', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Petit-Goave', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Carrefour', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Gressier', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Kenscoff', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Tabarre', 1, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Cite Soleil', 1, 'commune', now(), 1);


insert into shippingdb.location (name, parent, nature, created, creator) values ('Desdunes', 2, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Dessalines', 2, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Grande-Saline', 2, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Petite Riviere de l''Artibonite', 2, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Ennery', 2, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('L''Estere', 2, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Gonaives', 2, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Anse-Rouge', 2, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Gros-Morne', 2, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Terre-Neuve', 2, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Marmelade', 2, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Saint-Michel-de-l''Atalaye', 2, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('La Chapelle', 2, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Saint-Marc', 2, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Verrettes', 2, 'commune', now(), 1);

insert into shippingdb.location (name, parent, nature, created, creator) values ('Jacmel', 3,'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Bainet', 3, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Cotes-de-Fer', 3, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Anse-a-Pitres', 3, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Belle-Anse', 3, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Grand-Gosier', 3, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Thiotte', 3, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Cayes-Jacmel', 3, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('La Vallee', 3, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Marigot', 3, 'commune', now(), 1);


insert into shippingdb.location (name, parent, nature, created, creator) values ('Anse-d''Hainault', 4, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Dame-Marie', 4, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Les Irois', 4, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Beaumont', 4, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Corail', 4, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Pestel', 4, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Roseaux', 4, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Abricots', 4, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Bonbon', 4, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Chambellan', 4, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Jeremie', 4, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Moron', 4, 'commune', now(), 1);


insert into shippingdb.location (name, parent, nature, created, creator) values ('Aquin', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Cavaellon', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Saint-Louis-du-Sud', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Camp-Perrin', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Les Cayes', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Chantal', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Ile-a-Vache', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Maniche', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Torbeck', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Les Anglais', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Chardonnieres', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Tiburon', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Coteaux', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Port-a-Piment', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Roche-a-Bateaux', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Arniquet', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Port-Salut', 5, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Saint-Jean-du-Sud', 5, 'commune', now(), 1);


insert into shippingdb.location (name, parent, nature, created, creator) values ('Cerca-la-Source', 6, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Thomassique', 6, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Cerca-Carvajal', 6, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Hinche', 6, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Maissade', 6, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Thomonde', 6, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Belladeres', 6, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Lascahobas', 6, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Savanette', 6, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Boucan-Carre', 6, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Mirebalais', 6, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Saut-d''Eau', 6, 'commune', now(), 1);


insert into shippingdb.location (name, parent, nature, created, creator) values ('Acul-du-Nord', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Milot', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Plaine-du-Nord', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Borgne', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Port-Margot', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Cap-Haitien', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Limonade', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Quartier-Morin', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Bahon', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Grande-Riviere-du-Nord', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Bas-Limbe', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Limbe', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Pilate', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Plaisance', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Dondon', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('La Victoire', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Pignon', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Ranquitte', 7, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Saint-Raphael', 7, 'commune', now(), 1);


insert into shippingdb.location (name, parent, nature, created, creator) values ('Fort-Liberte', 8, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Perches', 8, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Ferrier', 8, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Capotille', 8, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Mont-Organise', 8, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Ouanaminthe', 8, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Caracol', 8, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Sainte Suzanne', 8, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Terrier-Rouge', 8, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Trou-du-Nord', 8, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Carice', 8, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Mombin-Crochu', 8, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Vallieres', 8, 'commune', now(), 1);


insert into shippingdb.location (name, parent, nature, created, creator) values ('Baie-de-Henne', 9, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Bombardopolis', 9, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Jean-Rabel', 9, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Mole-Saint-Nicolas', 9, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Bassin-Bleu', 9, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Chansolme', 9, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('La Tortue', 9, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Port-de-Paix', 9, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Anse-a-Foleur', 9, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Saint-Louis-du-Nord', 9, 'commune', now(), 1);


insert into shippingdb.location (name, parent, nature, created, creator) values ('Anse-a-Veau', 10, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Petit-Trou-de-Nippes', 10, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('L''Asile', 10, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Arnaud', 10, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Plaisance-du-Sud', 10, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Baraderes', 10, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Grand-Boucan', 10, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Miragoane', 10, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Petite-Riviere-de-Nippes', 10, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Fonds-des-Negres', 10, 'commune', now(), 1);
insert into shippingdb.location (name, parent, nature, created, creator) values ('Paillant', 10, 'commune', now(), 1);
