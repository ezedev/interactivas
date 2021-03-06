USE [interactivas2]
GO
/****** Object:  User [interactivas2]    Script Date: 07/02/2015 20:43:22 ******/
CREATE USER [interactivas2] FOR LOGIN [interactivas2] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[zona]    Script Date: 07/02/2015 20:43:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[zona](
	[codigo] [varchar](12) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
	[coeficiente] [float] NOT NULL,
 CONSTRAINT [PK_zona_1] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [UNIQUE_zona] UNIQUE NONCLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[zona] ([codigo], [nombre], [coeficiente]) VALUES (N'CENTRO', N'Zona Centro', 1.33)
INSERT [dbo].[zona] ([codigo], [nombre], [coeficiente]) VALUES (N'NORTE', N'Zona Norte', 1.33)
INSERT [dbo].[zona] ([codigo], [nombre], [coeficiente]) VALUES (N'SUR', N'Zona Sur', 1.33)
/****** Object:  Table [dbo].[rol]    Script Date: 07/02/2015 20:43:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[rol](
	[codigo] [varchar](12) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
 CONSTRAINT [PK_rol] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [UNIQUE_nombre] UNIQUE NONCLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[rol] ([codigo], [nombre]) VALUES (N'ADMIN-COLOC', N'ADMINISTRADOR-COLOCACIONES')
INSERT [dbo].[rol] ([codigo], [nombre]) VALUES (N'ADMIN-EDIC', N'ADMINISTRADOR-EDICIONES')
/****** Object:  Table [dbo].[publicacion]    Script Date: 07/02/2015 20:43:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[publicacion](
	[codigo] [varchar](6) NOT NULL,
	[titulo] [varchar](100) NOT NULL,
	[editor] [varchar](100) NOT NULL,
	[tema] [varchar](100) NOT NULL,
	[subtema] [varchar](100) NOT NULL,
	[publico] [varchar](100) NOT NULL,
	[periodicidad] [char](1) NOT NULL,
	[idioma] [char](2) NOT NULL,
	[pais_origen] [char](3) NOT NULL,
	[tipo] [char](1) NOT NULL,
 CONSTRAINT [PK_publicacion] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [UNIQUE_publicacion] UNIQUE NONCLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[publicacion] ([codigo], [titulo], [editor], [tema], [subtema], [publico], [periodicidad], [idioma], [pais_origen], [tipo]) VALUES (N'CLARIN', N'Clarin', N'Grupo Clarin', N'General', N'General', N'General', N'D', N'es', N'ARG', N'D')
INSERT [dbo].[publicacion] ([codigo], [titulo], [editor], [tema], [subtema], [publico], [periodicidad], [idioma], [pais_origen], [tipo]) VALUES (N'NACION', N'La Nacion', N'Grupo Clarin', N'General', N'General', N'General', N'D', N'es', N'ARG', N'D')
/****** Object:  Table [dbo].[pauta]    Script Date: 07/02/2015 20:43:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[pauta](
	[codigo] [varchar](12) NOT NULL,
	[estado] [char](1) NOT NULL,
 CONSTRAINT [PK_pauta] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[pauta] ([codigo], [estado]) VALUES (N'AGOTADO', N'A')
INSERT [dbo].[pauta] ([codigo], [estado]) VALUES (N'EXCESO', N'A')
INSERT [dbo].[pauta] ([codigo], [estado]) VALUES (N'ZONA', N'A')
/****** Object:  Table [dbo].[modulo]    Script Date: 07/02/2015 20:43:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[modulo](
	[codigo] [varchar](12) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
 CONSTRAINT [PK_modulo_1] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[modulo] ([codigo], [nombre]) VALUES (N'COLOCACIONES', N'MODULO COLOCACIONES')
INSERT [dbo].[modulo] ([codigo], [nombre]) VALUES (N'EDICIONES', N'MODULO EDICIONES')
/****** Object:  Table [dbo].[vendedor]    Script Date: 07/02/2015 20:43:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[vendedor](
	[codigo] [varchar](12) NOT NULL,
	[direccion] [varchar](100) NOT NULL,
	[tipo] [char](1) NOT NULL,
	[codigo_zona] [varchar](12) NOT NULL,
 CONSTRAINT [PK_vendedor_1] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [UNIQUE_vendedor] UNIQUE NONCLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[vendedor] ([codigo], [direccion], [tipo], [codigo_zona]) VALUES (N'PUESTO1', N'Av. Corrientes 900', N'D', N'CENTRO')
INSERT [dbo].[vendedor] ([codigo], [direccion], [tipo], [codigo_zona]) VALUES (N'PUESTO2', N'Av. Corrientes 1300', N'D', N'CENTRO')
INSERT [dbo].[vendedor] ([codigo], [direccion], [tipo], [codigo_zona]) VALUES (N'PUESTO3', N'Av. Corrientes 2000', N'D', N'CENTRO')
/****** Object:  Table [dbo].[usuario]    Script Date: 07/02/2015 20:43:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[usuario](
	[codigo] [int] NOT NULL,
	[usuario] [varchar](32) NOT NULL,
	[clave] [varchar](32) NOT NULL,
	[codigo_rol] [varchar](12) NOT NULL,
 CONSTRAINT [PK_usuario_1] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[usuario] ([codigo], [usuario], [clave], [codigo_rol]) VALUES (1, N'coloc1', N'1234', N'ADMIN-COLOC')
INSERT [dbo].[usuario] ([codigo], [usuario], [clave], [codigo_rol]) VALUES (2, N'edic1', N'1234', N'ADMIN-EDIC')
/****** Object:  Table [dbo].[rol_modulo]    Script Date: 07/02/2015 20:43:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[rol_modulo](
	[codigo_rol] [varchar](12) NOT NULL,
	[codigo_modulo] [varchar](12) NOT NULL,
 CONSTRAINT [PK_rol_modulo_1] PRIMARY KEY CLUSTERED 
(
	[codigo_rol] ASC,
	[codigo_modulo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[rol_modulo] ([codigo_rol], [codigo_modulo]) VALUES (N'ADMIN-COLOC', N'COLOCACIONES')
INSERT [dbo].[rol_modulo] ([codigo_rol], [codigo_modulo]) VALUES (N'ADMIN-EDIC', N'EDICIONES')
/****** Object:  Table [dbo].[edicion]    Script Date: 07/02/2015 20:43:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[edicion](
	[codigo] [varchar](12) NOT NULL,
	[fecha_salida] [date] NOT NULL,
	[titulo] [varchar](100) NOT NULL,
	[precio] [money] NOT NULL,
	[codigo_publicacion] [varchar](6) NOT NULL,
 CONSTRAINT [PK_edicion] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN010615', CAST(0x053A0B00 AS Date), N'Clarin 01/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN020615', CAST(0x063A0B00 AS Date), N'Clarin 02/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN030615', CAST(0x073A0B00 AS Date), N'Clarin 03/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN030715', CAST(0x253A0B00 AS Date), N'Clarin 03/07', 15.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN040615', CAST(0x083A0B00 AS Date), N'Clarin 04/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN050615', CAST(0x093A0B00 AS Date), N'Clarin 05/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN060615', CAST(0x0A3A0B00 AS Date), N'Clarin 06/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN070615', CAST(0x0B3A0B00 AS Date), N'Clarin 07/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN080615', CAST(0x0C3A0B00 AS Date), N'Clarin 08/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN090615', CAST(0x0D3A0B00 AS Date), N'Clarin 09/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN100615', CAST(0x0E3A0B00 AS Date), N'Clarin 10/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN110615', CAST(0x0F3A0B00 AS Date), N'Clarin 11/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN120615', CAST(0x103A0B00 AS Date), N'Clarin 12/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN130615', CAST(0x113A0B00 AS Date), N'Clarin 13/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN140615', CAST(0x123A0B00 AS Date), N'Clarin 14/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN150615', CAST(0x133A0B00 AS Date), N'Clarin 15/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN160615', CAST(0x143A0B00 AS Date), N'Clarin 16/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN170615', CAST(0x153A0B00 AS Date), N'Clarin 17/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN180615', CAST(0x163A0B00 AS Date), N'Clarin 18/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN190615', CAST(0x173A0B00 AS Date), N'Clarin 19/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN200615', CAST(0x183A0B00 AS Date), N'Clarin 20/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN210615', CAST(0x193A0B00 AS Date), N'Clarin 21/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN220515', CAST(0xFB390B00 AS Date), N'Clarin 22/05', 13.5000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN220615', CAST(0x1A3A0B00 AS Date), N'Clarin 22/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN230515', CAST(0xFC390B00 AS Date), N'Clarin 23/05', 13.5000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN230615', CAST(0x1B3A0B00 AS Date), N'Clarin 23/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN240515', CAST(0xFD390B00 AS Date), N'Clarin 24/05', 13.5000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN240615', CAST(0x1C3A0B00 AS Date), N'Clarin 24/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN250515', CAST(0xFE390B00 AS Date), N'Clarin 25/05', 13.5000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN250615', CAST(0x1D3A0B00 AS Date), N'Clarin 25/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN260515', CAST(0xFF390B00 AS Date), N'Clarin 26/05', 13.5000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN260615', CAST(0x1E3A0B00 AS Date), N'Clarin 26/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN270515', CAST(0x003A0B00 AS Date), N'Clarin 27/05', 13.5000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN270615', CAST(0x1F3A0B00 AS Date), N'Clarin 27/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN280515', CAST(0x013A0B00 AS Date), N'Clarin 28/05', 13.5000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN280615', CAST(0x203A0B00 AS Date), N'Clarin 28/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN290515', CAST(0x023A0B00 AS Date), N'Clarin 29/05', 13.5000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN290615', CAST(0x213A0B00 AS Date), N'Clarin 29/06', 13.0000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN300515', CAST(0x033A0B00 AS Date), N'Clarin 30/05', 13.5000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'CLARIN310515', CAST(0x043A0B00 AS Date), N'Clarin 31/05', 13.5000, N'CLARIN')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION010615', CAST(0x053A0B00 AS Date), N'Lanacion 01/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION020615', CAST(0x063A0B00 AS Date), N'Lanacion 02/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION030615', CAST(0x073A0B00 AS Date), N'Lanacion 03/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION040615', CAST(0x083A0B00 AS Date), N'Lanacion 04/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION050615', CAST(0x093A0B00 AS Date), N'Lanacion 05/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION060615', CAST(0x0A3A0B00 AS Date), N'Lanacion 06/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION070615', CAST(0x0B3A0B00 AS Date), N'Lanacion 07/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION080615', CAST(0x0C3A0B00 AS Date), N'Lanacion 08/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION090615', CAST(0x0D3A0B00 AS Date), N'Lanacion 09/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION100615', CAST(0x0E3A0B00 AS Date), N'Lanacion 10/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION110615', CAST(0x0F3A0B00 AS Date), N'Lanacion 11/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION120615', CAST(0x103A0B00 AS Date), N'Lanacion 12/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION130615', CAST(0x113A0B00 AS Date), N'Lanacion 13/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION140615', CAST(0x123A0B00 AS Date), N'Lanacion 14/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION150615', CAST(0x133A0B00 AS Date), N'Lanacion 15/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION160615', CAST(0x143A0B00 AS Date), N'Lanacion 16/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION170615', CAST(0x153A0B00 AS Date), N'Lanacion 17/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION180615', CAST(0x163A0B00 AS Date), N'Lanacion 18/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION190615', CAST(0x173A0B00 AS Date), N'Lanacion 19/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION200615', CAST(0x183A0B00 AS Date), N'Lanacion 20/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION210615', CAST(0x193A0B00 AS Date), N'Lanacion 21/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION220515', CAST(0xFB390B00 AS Date), N'Lanacion 22/05', 13.5000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION220615', CAST(0x1A3A0B00 AS Date), N'Lanacion 22/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION230515', CAST(0xFC390B00 AS Date), N'Lanacion 23/05', 13.5000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION230615', CAST(0x1B3A0B00 AS Date), N'Lanacion 23/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION240515', CAST(0xFD390B00 AS Date), N'Lanacion 24/05', 13.5000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION240615', CAST(0x1C3A0B00 AS Date), N'Lanacion 24/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION250515', CAST(0xFE390B00 AS Date), N'Lanacion 25/05', 13.5000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION250615', CAST(0x1D3A0B00 AS Date), N'Lanacion 25/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION260515', CAST(0xFF390B00 AS Date), N'Lanacion 26/05', 13.5000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION260615', CAST(0x1E3A0B00 AS Date), N'Lanacion 26/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION270515', CAST(0x003A0B00 AS Date), N'Lanacion 27/05', 13.5000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION270615', CAST(0x1F3A0B00 AS Date), N'Lanacion 27/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION280515', CAST(0x013A0B00 AS Date), N'Lanacion 28/05', 13.5000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION280615', CAST(0x203A0B00 AS Date), N'Lanacion 28/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION290515', CAST(0x023A0B00 AS Date), N'Lanacion 29/05', 13.5000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION290615', CAST(0x213A0B00 AS Date), N'Lanacion 29/06', 13.0000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION300515', CAST(0x033A0B00 AS Date), N'Lanacion 30/05', 13.5000, N'NACION')
INSERT [dbo].[edicion] ([codigo], [fecha_salida], [titulo], [precio], [codigo_publicacion]) VALUES (N'NACION310515', CAST(0x043A0B00 AS Date), N'Lanacion 31/05', 13.5000, N'NACION')
/****** Object:  Table [dbo].[vendedor_publicacion]    Script Date: 07/02/2015 20:43:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[vendedor_publicacion](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[codigo_vendedor] [varchar](12) NOT NULL,
	[codigo_publicacion] [varchar](6) NOT NULL,
 CONSTRAINT [PK_vendedor_publicacion] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[vendedor_publicacion] ON
INSERT [dbo].[vendedor_publicacion] ([id], [codigo_vendedor], [codigo_publicacion]) VALUES (2, N'PUESTO1', N'NACION')
INSERT [dbo].[vendedor_publicacion] ([id], [codigo_vendedor], [codigo_publicacion]) VALUES (3, N'PUESTO2', N'NACION')
INSERT [dbo].[vendedor_publicacion] ([id], [codigo_vendedor], [codigo_publicacion]) VALUES (4, N'PUESTO3', N'NACION')
INSERT [dbo].[vendedor_publicacion] ([id], [codigo_vendedor], [codigo_publicacion]) VALUES (5, N'PUESTO1', N'CLARIN')
INSERT [dbo].[vendedor_publicacion] ([id], [codigo_vendedor], [codigo_publicacion]) VALUES (6, N'PUESTO2', N'CLARIN')
INSERT [dbo].[vendedor_publicacion] ([id], [codigo_vendedor], [codigo_publicacion]) VALUES (7, N'PUESTO3', N'CLARIN')
SET IDENTITY_INSERT [dbo].[vendedor_publicacion] OFF
/****** Object:  Table [dbo].[colocacion]    Script Date: 07/02/2015 20:43:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[colocacion](
	[fecha] [date] NOT NULL,
	[codigo_edicion] [varchar](12) NOT NULL,
 CONSTRAINT [PK_colocacion] PRIMARY KEY CLUSTERED 
(
	[fecha] ASC,
	[codigo_edicion] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[colocacion] ([fecha], [codigo_edicion]) VALUES (CAST(0x123A0B00 AS Date), N'NACION140615')
INSERT [dbo].[colocacion] ([fecha], [codigo_edicion]) VALUES (CAST(0x133A0B00 AS Date), N'NACION150615')
INSERT [dbo].[colocacion] ([fecha], [codigo_edicion]) VALUES (CAST(0x193A0B00 AS Date), N'NACION210615')
INSERT [dbo].[colocacion] ([fecha], [codigo_edicion]) VALUES (CAST(0x1A3A0B00 AS Date), N'NACION220615')
INSERT [dbo].[colocacion] ([fecha], [codigo_edicion]) VALUES (CAST(0x1E3A0B00 AS Date), N'CLARIN260615')
INSERT [dbo].[colocacion] ([fecha], [codigo_edicion]) VALUES (CAST(0x213A0B00 AS Date), N'CLARIN290615')
INSERT [dbo].[colocacion] ([fecha], [codigo_edicion]) VALUES (CAST(0x213A0B00 AS Date), N'NACION290615')
INSERT [dbo].[colocacion] ([fecha], [codigo_edicion]) VALUES (CAST(0x253A0B00 AS Date), N'CLARIN030715')
/****** Object:  Table [dbo].[item_colocacion]    Script Date: 07/02/2015 20:43:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[item_colocacion](
	[fecha_colocacion] [date] NOT NULL,
	[codigo_edicion] [varchar](12) NOT NULL,
	[codigo_vendedor] [varchar](12) NOT NULL,
	[cantidad_entregada] [int] NOT NULL,
	[cantidad_devuelta] [int] NOT NULL,
 CONSTRAINT [PK_item_colocacion_1] PRIMARY KEY CLUSTERED 
(
	[fecha_colocacion] ASC,
	[codigo_edicion] ASC,
	[codigo_vendedor] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x123A0B00 AS Date), N'NACION140615', N'PUESTO1', 50, 0)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x123A0B00 AS Date), N'NACION140615', N'PUESTO2', 65, 56)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x123A0B00 AS Date), N'NACION140615', N'PUESTO3', 112, 4)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x133A0B00 AS Date), N'NACION150615', N'PUESTO1', 50, 0)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x133A0B00 AS Date), N'NACION150615', N'PUESTO2', 65, 56)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x133A0B00 AS Date), N'NACION150615', N'PUESTO3', 112, 4)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x193A0B00 AS Date), N'NACION210615', N'PUESTO1', 100, 23)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x193A0B00 AS Date), N'NACION210615', N'PUESTO2', 65, 42)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x193A0B00 AS Date), N'NACION210615', N'PUESTO3', 103, 103)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x1A3A0B00 AS Date), N'NACION220615', N'PUESTO1', 100, 23)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x1A3A0B00 AS Date), N'NACION220615', N'PUESTO2', 65, 42)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x1A3A0B00 AS Date), N'NACION220615', N'PUESTO3', 103, 103)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x1E3A0B00 AS Date), N'CLARIN260615', N'PUESTO1', 100, 30)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x1E3A0B00 AS Date), N'CLARIN260615', N'PUESTO2', 170, 0)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x1E3A0B00 AS Date), N'CLARIN260615', N'PUESTO3', 150, 20)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x213A0B00 AS Date), N'CLARIN290615', N'PUESTO1', 1000, 0)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x213A0B00 AS Date), N'CLARIN290615', N'PUESTO2', 2000, 0)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x213A0B00 AS Date), N'CLARIN290615', N'PUESTO3', 3000, 0)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x213A0B00 AS Date), N'NACION290615', N'PUESTO1', 6, 0)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x213A0B00 AS Date), N'NACION290615', N'PUESTO2', 441, 0)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x213A0B00 AS Date), N'NACION290615', N'PUESTO3', 516, 0)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x253A0B00 AS Date), N'CLARIN030715', N'PUESTO1', 2991, 10)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x253A0B00 AS Date), N'CLARIN030715', N'PUESTO2', 6994, 20)
INSERT [dbo].[item_colocacion] ([fecha_colocacion], [codigo_edicion], [codigo_vendedor], [cantidad_entregada], [cantidad_devuelta]) VALUES (CAST(0x253A0B00 AS Date), N'CLARIN030715', N'PUESTO3', 6052, 50)
/****** Object:  ForeignKey [FK_COLOCACION_EDICION]    Script Date: 07/02/2015 20:43:22 ******/
ALTER TABLE [dbo].[colocacion]  WITH CHECK ADD  CONSTRAINT [FK_COLOCACION_EDICION] FOREIGN KEY([codigo_edicion])
REFERENCES [dbo].[edicion] ([codigo])
GO
ALTER TABLE [dbo].[colocacion] CHECK CONSTRAINT [FK_COLOCACION_EDICION]
GO
/****** Object:  ForeignKey [FK_EDICION_PUBLICACION]    Script Date: 07/02/2015 20:43:22 ******/
ALTER TABLE [dbo].[edicion]  WITH CHECK ADD  CONSTRAINT [FK_EDICION_PUBLICACION] FOREIGN KEY([codigo_publicacion])
REFERENCES [dbo].[publicacion] ([codigo])
GO
ALTER TABLE [dbo].[edicion] CHECK CONSTRAINT [FK_EDICION_PUBLICACION]
GO
/****** Object:  ForeignKey [FK_ITEM_COLOCACION_COLOCACION]    Script Date: 07/02/2015 20:43:22 ******/
ALTER TABLE [dbo].[item_colocacion]  WITH CHECK ADD  CONSTRAINT [FK_ITEM_COLOCACION_COLOCACION] FOREIGN KEY([fecha_colocacion], [codigo_edicion])
REFERENCES [dbo].[colocacion] ([fecha], [codigo_edicion])
GO
ALTER TABLE [dbo].[item_colocacion] CHECK CONSTRAINT [FK_ITEM_COLOCACION_COLOCACION]
GO
/****** Object:  ForeignKey [FK_ITEM_COLOCACION_VENDEDOR]    Script Date: 07/02/2015 20:43:22 ******/
ALTER TABLE [dbo].[item_colocacion]  WITH CHECK ADD  CONSTRAINT [FK_ITEM_COLOCACION_VENDEDOR] FOREIGN KEY([codigo_vendedor])
REFERENCES [dbo].[vendedor] ([codigo])
GO
ALTER TABLE [dbo].[item_colocacion] CHECK CONSTRAINT [FK_ITEM_COLOCACION_VENDEDOR]
GO
/****** Object:  ForeignKey [FK_ROL_MODULO_MODULO]    Script Date: 07/02/2015 20:43:22 ******/
ALTER TABLE [dbo].[rol_modulo]  WITH CHECK ADD  CONSTRAINT [FK_ROL_MODULO_MODULO] FOREIGN KEY([codigo_modulo])
REFERENCES [dbo].[modulo] ([codigo])
GO
ALTER TABLE [dbo].[rol_modulo] CHECK CONSTRAINT [FK_ROL_MODULO_MODULO]
GO
/****** Object:  ForeignKey [FK_ROL_MODULO_ROL]    Script Date: 07/02/2015 20:43:22 ******/
ALTER TABLE [dbo].[rol_modulo]  WITH CHECK ADD  CONSTRAINT [FK_ROL_MODULO_ROL] FOREIGN KEY([codigo_rol])
REFERENCES [dbo].[rol] ([codigo])
GO
ALTER TABLE [dbo].[rol_modulo] CHECK CONSTRAINT [FK_ROL_MODULO_ROL]
GO
/****** Object:  ForeignKey [FK_USUARIO_ROL]    Script Date: 07/02/2015 20:43:22 ******/
ALTER TABLE [dbo].[usuario]  WITH CHECK ADD  CONSTRAINT [FK_USUARIO_ROL] FOREIGN KEY([codigo_rol])
REFERENCES [dbo].[rol] ([codigo])
GO
ALTER TABLE [dbo].[usuario] CHECK CONSTRAINT [FK_USUARIO_ROL]
GO
/****** Object:  ForeignKey [FK_VENDEDOR_ZONA]    Script Date: 07/02/2015 20:43:22 ******/
ALTER TABLE [dbo].[vendedor]  WITH CHECK ADD  CONSTRAINT [FK_VENDEDOR_ZONA] FOREIGN KEY([codigo_zona])
REFERENCES [dbo].[zona] ([codigo])
GO
ALTER TABLE [dbo].[vendedor] CHECK CONSTRAINT [FK_VENDEDOR_ZONA]
GO
/****** Object:  ForeignKey [FK_VENDEDOR_PUBLICACION_PUBLICACION]    Script Date: 07/02/2015 20:43:22 ******/
ALTER TABLE [dbo].[vendedor_publicacion]  WITH CHECK ADD  CONSTRAINT [FK_VENDEDOR_PUBLICACION_PUBLICACION] FOREIGN KEY([codigo_publicacion])
REFERENCES [dbo].[publicacion] ([codigo])
GO
ALTER TABLE [dbo].[vendedor_publicacion] CHECK CONSTRAINT [FK_VENDEDOR_PUBLICACION_PUBLICACION]
GO
/****** Object:  ForeignKey [FK_VENDEDOR_PUBLICACION_VENDEDOR]    Script Date: 07/02/2015 20:43:22 ******/
ALTER TABLE [dbo].[vendedor_publicacion]  WITH CHECK ADD  CONSTRAINT [FK_VENDEDOR_PUBLICACION_VENDEDOR] FOREIGN KEY([codigo_vendedor])
REFERENCES [dbo].[vendedor] ([codigo])
GO
ALTER TABLE [dbo].[vendedor_publicacion] CHECK CONSTRAINT [FK_VENDEDOR_PUBLICACION_VENDEDOR]
GO
