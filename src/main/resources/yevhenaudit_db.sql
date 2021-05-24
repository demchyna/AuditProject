--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE yevhen_audit;
--
-- TOC entry 2934 (class 1262 OID 17162)
-- Name: todolist; Type: DATABASE; Schema: -; Owner: -
--

CREATE DATABASE yevhen_audit WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Ukrainian_Ukraine.1251' LC_CTYPE = 'Ukrainian_Ukraine.1251';


\connect yevhen_audit

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA public;

--
-- TOC entry 562 (class 1247 OID 17164)
-- Name: priority_type; Type: TYPE; Schema: public; Owner: -
--

CREATE TYPE public.priority_type AS ENUM (
    'low',
    'medium',
    'high'
);

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 17171)
-- Name: roles; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    name character varying(255) NOT NULL
);

--
-- TOC entry 204 (class 1259 OID 17174)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

--
-- TOC entry 2935 (class 0 OID 0)
-- Dependencies: 204
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;

--
-- TOC entry 211 (class 1259 OID 17195)
-- Name: reports; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.reports (
    id integer NOT NULL,
    address character varying(255) NOT NULL,
    indicator_1 numeric NOT NULL,
    indicator_2 numeric NOT NULL,
    indicator_3 numeric NOT NULL,
    indicator_4 numeric NOT NULL,
    indicator_5 numeric NOT NULL,
    indicator_6 numeric NOT NULL,
    energy_efficiency character varying(255) NOT NULL,
    owner_id integer NOT NULL
);

--
-- TOC entry 212 (class 1259 OID 17198)
-- Name: reports_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.reports_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

--
-- TOC entry 2939 (class 0 OID 0)
-- Dependencies: 212
-- Name: reports_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.reports_id_seq OWNED BY public.reports.id;

--
-- TOC entry 213 (class 1259 OID 17200)
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users (
    id integer NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying NOT NULL,
    role_id integer NOT NULL
);

--
-- TOC entry 214 (class 1259 OID 17206)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

--
-- TOC entry 2940 (class 0 OID 0)
-- Dependencies: 214
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;

--
-- TOC entry 215 (class 1259 OID 17208)
-- Name: users_role_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.users_role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

--
-- TOC entry 2941 (class 0 OID 0)
-- Dependencies: 215
-- Name: users_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.users_role_id_seq OWNED BY public.users.role_id;

--
-- TOC entry 2761 (class 2604 OID 17210)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);

--
-- TOC entry 2766 (class 2604 OID 17214)
-- Name: reports id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.reports ALTER COLUMN id SET DEFAULT nextval('public.reports_id_seq'::regclass);

--
-- TOC entry 2767 (class 2604 OID 17215)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);

--
-- TOC entry 2768 (class 2604 OID 17216)
-- Name: users role_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users ALTER COLUMN role_id SET DEFAULT nextval('public.users_role_id_seq'::regclass);

--
-- TOC entry 2942 (class 0 OID 0)
-- Dependencies: 204
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.roles_id_seq', 2, true);

--
-- TOC entry 2946 (class 0 OID 0)
-- Dependencies: 212
-- Name: reports_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.reports_id_seq', 13, true);

--
-- TOC entry 2947 (class 0 OID 0)
-- Dependencies: 214
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.users_id_seq', 6, true);

--
-- TOC entry 2948 (class 0 OID 0)
-- Dependencies: 215
-- Name: users_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.users_role_id_seq', 1, false);

--
-- TOC entry 2771 (class 2606 OID 17218)
-- Name: roles roles_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pk PRIMARY KEY (id);

--
-- TOC entry 2780 (class 2606 OID 17224)
-- Name: reports reports_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.reports
    ADD CONSTRAINT reports_pk PRIMARY KEY (id);

--
-- TOC entry 2783 (class 2606 OID 17226)
-- Name: users users_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pk PRIMARY KEY (id);

--
-- TOC entry 2769 (class 1259 OID 17227)
-- Name: roles_id_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX roles_id_uindex ON public.roles USING btree (id);

--
-- TOC entry 2778 (class 1259 OID 17230)
-- Name: reports_id_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX reports_id_uindex ON public.reports USING btree (id);

--
-- TOC entry 2781 (class 1259 OID 17231)
-- Name: users_id_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX users_id_uindex ON public.users USING btree (id);

--
-- TOC entry 2788 (class 2606 OID 17252)
-- Name: reports todo_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.reports
    ADD CONSTRAINT todo_user_fk FOREIGN KEY (owner_id) REFERENCES public.users(id);

--
-- TOC entry 2789 (class 2606 OID 17257)
-- Name: users user_role_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_role_fk FOREIGN KEY (role_id) REFERENCES public.roles(id) NOT VALID;

--
-- PostgreSQL database dump complete
--

