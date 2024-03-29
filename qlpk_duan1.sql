create database [qlpk_duan1]
go
USE [qlpk_duan1]
GO
/****** Object:  Table [dbo].[Nhanvien]    Script Date: 08/19/2019 02:17:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Nhanvien](
	[Manv] [varchar](20) NOT NULL,
	[Tennv] [nvarchar](50) NOT NULL,
	[Taikhoan] [varchar](20) NOT NULL,
	[Matkhau] [varchar](20) NOT NULL,
	[Chucvu] [tinyint] NULL,
 CONSTRAINT [PK_Nhanvien] PRIMARY KEY CLUSTERED 
(
	[Manv] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Benhnhan]    Script Date: 08/19/2019 02:17:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Benhnhan](
	[Mabn] [varchar](15) NOT NULL,
	[Tenbn] [nvarchar](50) NOT NULL,
	[Gioitinh] [bit] NOT NULL,
	[Ngaysinh] [date] NOT NULL,
 CONSTRAINT [PK_Benhnhan] PRIMARY KEY CLUSTERED 
(
	[Mabn] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Phongkham]    Script Date: 08/19/2019 02:17:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Phongkham](
	[Maphongkham] [int] identity (1,1),
	[Tenphongkham] [nvarchar](50) NOT NULL,
	[Manv] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Phongkham_1] PRIMARY KEY CLUSTERED 
(
	[Maphongkham] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [PK_Phongkham] UNIQUE NONCLUSTERED 
(
	[Manv] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Phieukham]    Script Date: 08/19/2019 02:17:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Phieukham](
	[Maphieukham] [int] identity(1,1),
	[Ngaykham] [date] NOT NULL,
	[Huongdieutri] [nvarchar](20) NULL,
	[Donthuoc] [bit] NULL,
	[Chandoan] [nvarchar](50) NULL,
	[Mabn] [varchar](15) NOT NULL,
	[Maphongkham] [int],
 CONSTRAINT [PK_Phieukham] PRIMARY KEY CLUSTERED 
(
	[Maphieukham] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  ForeignKey [FK_Phieukham_Benhnhan]    Script Date: 08/19/2019 02:17:11 ******/
ALTER TABLE [dbo].[Phieukham]  WITH CHECK ADD  CONSTRAINT [FK_Phieukham_Benhnhan] FOREIGN KEY([Mabn])
REFERENCES [dbo].[Benhnhan] ([Mabn])
GO
ALTER TABLE [dbo].[Phieukham] CHECK CONSTRAINT [FK_Phieukham_Benhnhan]
GO
/****** Object:  ForeignKey [FK_Phieukham_Phongkham]    Script Date: 08/19/2019 02:17:11 ******/
ALTER TABLE [dbo].[Phieukham]  WITH CHECK ADD  CONSTRAINT [FK_Phieukham_Phongkham] FOREIGN KEY([Maphongkham])
REFERENCES [dbo].[Phongkham] ([Maphongkham])
GO
ALTER TABLE [dbo].[Phieukham] CHECK CONSTRAINT [FK_Phieukham_Phongkham]
GO
/****** Object:  ForeignKey [FK_Phongkham_Nhanvien1]    Script Date: 08/19/2019 02:17:11 ******/
ALTER TABLE [dbo].[Phongkham]  WITH CHECK ADD  CONSTRAINT [FK_Phongkham_Nhanvien1] FOREIGN KEY([Manv])
REFERENCES [dbo].[Nhanvien] ([Manv])
GO
ALTER TABLE [dbo].[Phongkham] CHECK CONSTRAINT [FK_Phongkham_Nhanvien1]
GO

insert into Phieukham (Chandoan,Donthuoc,Huongdieutri,Mabn,Maphongkham,Ngaykham)
values(N'Chim to', 1,N'Cho về','BN01',3,'2019-08-20')
insert into Benhnhan (Gioitinh,Ngaysinh,Mabn,Tenbn) values (1,'1998-11-11','BN01',N'Triệu')
select * from Phieukham 
select * from Phongkham where Manv = 'NV01'