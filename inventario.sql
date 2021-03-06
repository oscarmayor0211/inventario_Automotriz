PGDMP     -    -                y         
   inventario    10.18    10.18 !    	           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    16393 
   inventario    DATABASE     ?   CREATE DATABASE inventario WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE inventario;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false                       0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            ?            1259    16850    cargos    TABLE     o   CREATE TABLE public.cargos (
    id_cargo bigint NOT NULL,
    nombre_cargo character varying(255) NOT NULL
);
    DROP TABLE public.cargos;
       public         postgres    false    3            ?            1259    16848    cargos_id_cargo_seq    SEQUENCE     |   CREATE SEQUENCE public.cargos_id_cargo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.cargos_id_cargo_seq;
       public       postgres    false    197    3                       0    0    cargos_id_cargo_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.cargos_id_cargo_seq OWNED BY public.cargos.id_cargo;
            public       postgres    false    196            ?            1259    16858 	   productos    TABLE       CREATE TABLE public.productos (
    id_producto bigint NOT NULL,
    cantidad integer NOT NULL,
    fecha_ingreso date,
    fecha_update timestamp without time zone,
    id_usuario_modifica bigint,
    id_usuario_registro bigint,
    nombre character varying(255) NOT NULL
);
    DROP TABLE public.productos;
       public         postgres    false    3            ?            1259    16856    productos_id_producto_seq    SEQUENCE     ?   CREATE SEQUENCE public.productos_id_producto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.productos_id_producto_seq;
       public       postgres    false    3    199                       0    0    productos_id_producto_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.productos_id_producto_seq OWNED BY public.productos.id_producto;
            public       postgres    false    198            ?            1259    16866    usuarios    TABLE     ?   CREATE TABLE public.usuarios (
    id bigint NOT NULL,
    cedula bigint NOT NULL,
    edad integer NOT NULL,
    fecha_ingreso date,
    id_cargo bigint,
    nombre_usuario character varying(255) NOT NULL
);
    DROP TABLE public.usuarios;
       public         postgres    false    3            ?            1259    16864    usuarios_id_seq    SEQUENCE     x   CREATE SEQUENCE public.usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.usuarios_id_seq;
       public       postgres    false    201    3                       0    0    usuarios_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;
            public       postgres    false    200            z
           2604    16853    cargos id_cargo    DEFAULT     r   ALTER TABLE ONLY public.cargos ALTER COLUMN id_cargo SET DEFAULT nextval('public.cargos_id_cargo_seq'::regclass);
 >   ALTER TABLE public.cargos ALTER COLUMN id_cargo DROP DEFAULT;
       public       postgres    false    197    196    197            {
           2604    16861    productos id_producto    DEFAULT     ~   ALTER TABLE ONLY public.productos ALTER COLUMN id_producto SET DEFAULT nextval('public.productos_id_producto_seq'::regclass);
 D   ALTER TABLE public.productos ALTER COLUMN id_producto DROP DEFAULT;
       public       postgres    false    199    198    199            |
           2604    16869    usuarios id    DEFAULT     j   ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);
 :   ALTER TABLE public.usuarios ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    200    201    201                      0    16850    cargos 
   TABLE DATA               8   COPY public.cargos (id_cargo, nombre_cargo) FROM stdin;
    public       postgres    false    197   ?#                 0    16858 	   productos 
   TABLE DATA               ?   COPY public.productos (id_producto, cantidad, fecha_ingreso, fecha_update, id_usuario_modifica, id_usuario_registro, nombre) FROM stdin;
    public       postgres    false    199   ?#                 0    16866    usuarios 
   TABLE DATA               ]   COPY public.usuarios (id, cedula, edad, fecha_ingreso, id_cargo, nombre_usuario) FROM stdin;
    public       postgres    false    201   N$                  0    0    cargos_id_cargo_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.cargos_id_cargo_seq', 3, true);
            public       postgres    false    196                       0    0    productos_id_producto_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.productos_id_producto_seq', 4, true);
            public       postgres    false    198                       0    0    usuarios_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuarios_id_seq', 3, true);
            public       postgres    false    200            ~
           2606    16855    cargos cargos_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.cargos
    ADD CONSTRAINT cargos_pkey PRIMARY KEY (id_cargo);
 <   ALTER TABLE ONLY public.cargos DROP CONSTRAINT cargos_pkey;
       public         postgres    false    197            ?
           2606    16863    productos productos_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (id_producto);
 B   ALTER TABLE ONLY public.productos DROP CONSTRAINT productos_pkey;
       public         postgres    false    199            ?
           2606    16873 &   productos uk_mlgw7js72hh2xtd4mvpdqfsbe 
   CONSTRAINT     c   ALTER TABLE ONLY public.productos
    ADD CONSTRAINT uk_mlgw7js72hh2xtd4mvpdqfsbe UNIQUE (nombre);
 P   ALTER TABLE ONLY public.productos DROP CONSTRAINT uk_mlgw7js72hh2xtd4mvpdqfsbe;
       public         postgres    false    199            ?
           2606    16871    usuarios usuarios_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public         postgres    false    201            ?
           2606    16884 $   usuarios fkdedywmktm4yolcuws70emifbs    FK CONSTRAINT     ?   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT fkdedywmktm4yolcuws70emifbs FOREIGN KEY (id_cargo) REFERENCES public.cargos(id_cargo);
 N   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT fkdedywmktm4yolcuws70emifbs;
       public       postgres    false    201    197    2686            ?
           2606    16874 %   productos fkfieh8cckd4p8v8kr198a2fyqj    FK CONSTRAINT     ?   ALTER TABLE ONLY public.productos
    ADD CONSTRAINT fkfieh8cckd4p8v8kr198a2fyqj FOREIGN KEY (id_usuario_modifica) REFERENCES public.usuarios(id);
 O   ALTER TABLE ONLY public.productos DROP CONSTRAINT fkfieh8cckd4p8v8kr198a2fyqj;
       public       postgres    false    2692    199    201            ?
           2606    16879 %   productos fksxfqb0mi84p0tbjnwuqp6cav5    FK CONSTRAINT     ?   ALTER TABLE ONLY public.productos
    ADD CONSTRAINT fksxfqb0mi84p0tbjnwuqp6cav5 FOREIGN KEY (id_usuario_registro) REFERENCES public.usuarios(id);
 O   ALTER TABLE ONLY public.productos DROP CONSTRAINT fksxfqb0mi84p0tbjnwuqp6cav5;
       public       postgres    false    199    2692    201               :   x?3?t,N-?/RHIU(K?+I,?2?tL????,.)JL?/?2??/?/*I?????? ???         f   x?3???4202?5??50?3M???L?M??-8??-?(?˘???M????????1H???o8?	^??V?@?̀ʍ9}s????32?2?b???? ?p?         x   x?U?1
1F???S?+??0??6???BL ???^??W~<3??%?$
q8Ap|\??}^???l???D~<??5??R>v?yy?be;?"????a???[)??"z?? F     